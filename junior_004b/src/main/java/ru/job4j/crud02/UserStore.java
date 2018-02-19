package ru.job4j.crud02;

import java.io.IOException;
import java.sql.*;
import java.util.*;



/**
 * Class, wich fo all job for UsersServlet
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev, 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class UserStore {

   private Connection conn;
   private String dbUrl;
   private String user;
   private String password;
   private PreparedStatement pst;
   private ResultSet rst;
   private Statement stm;
   private static UserStore instance;

   private UserStore() throws SQLException, IOException {
      this.dbUrl = "jdbc:postgresql://localhost:5432/junior003";
      this.user = "postgres";
      this.password = "raduga";
      this.connectDb();
   }

   public static void main(String[] args) throws SQLException {
      UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();
      User user = userStore.getUser("agent007");
      System.out.println(user.getEmail());
   }

   public enum SingletonEnum {
      INSTANCE;
      public UserStore getInstance() {
         try {
            instance = new UserStore();
         } catch (SQLException | IOException e) {
            //LOG.error(e.getMessage(), e);
            e.printStackTrace();
         }
         return instance;
      }
   }

   /**
    *  Connect to DB
    */
   private void connectDb() throws SQLException, IOException {
      try {
         Class.forName("org.postgresql.Driver");
         this.conn = DriverManager.getConnection(this.dbUrl, this.user, this.password);
      } catch (ClassNotFoundException | SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      try {
         this.rst = this.conn.getMetaData().
                 getTables(null, null, "users", null);
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
   }


   /**
    *  Add new user
    *  @param userName - field 'name'
    *  @param userLogin - field 'login'
    *  @param userEmail - field 'email'
    */
   public boolean addUser(String userName, String userLogin, String userEmail)
           throws SQLException {
      boolean result = false;
      String request = String.format("INSERT INTO users (login, name, email, inserted_date) VALUES('%s', '%s', '%s', CURRENT_TIMESTAMP(0))",
                                                    userLogin, userName, userEmail);
      this.stm = this.conn.createStatement();
      try {
         result = this.stm.execute(request);
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return result;
   }

   /**
    *  Get all info about user by login
    *  @param login - field login
    */
   public User getUser(String login) throws SQLException {
      User user = null;
      String request = String.format("SELECT name, login, email, inserted_date FROM users WHERE login = ?");
      this.pst = this.conn.prepareStatement(request);
      try {
         this.pst.setString(1, login);
         this.rst = this.pst.executeQuery();
         while (rst.next()) {
            user = new User(rst.getString("name"),
                              //"damn_login",
                              rst.getString("login"),
                              //"dam_mail",
                              rst.getString("email"),
                              rst.getTimestamp("inserted_date")
            );
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return user;
   }

   /**
    *  Update user using login as a key.
    *  @param login - login
    *  @param newName - new name
    *  @param newEmail - new Email
    */
   public boolean updateUser(String login, String newName, String newEmail)
           throws SQLException {
      boolean result = false;
      User user = getUser(login);
      if (user != null) {
         String request = String.format("UPDATE users SET name = '%s', email = '%s' "
                 + "WHERE login = '%s'", newName, newEmail, login);
         this.stm = this.conn.createStatement();
         try {
            result = this.stm.executeUpdate(request) > 0;
         } catch (SQLException e) {
            //LOG.error(e.getMessage(), e);
            e.printStackTrace();
         }
      }
      return result;
   }

   /**
    *  Delete user using login as a key.
    */
   public boolean deleteUser(String login) throws SQLException {
      boolean result = false;
      String request = String.format("DELETE FROM users WHERE login = '%s'", login);
      this.stm = this.conn.createStatement();
      try {
         result = this.stm.executeUpdate(request) > 0;
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return result;
   }

   public List<String> getAlllogins() throws SQLException {
      List<String> allLogins = new ArrayList<String>();
      String request = String.format("SELECT %s FROM users ORDER BY login", "login");
      this.pst = this.conn.prepareStatement(request);
      try {
         this.rst = this.pst.executeQuery();
         while (rst.next()) {
            allLogins.add(rst.getString("login")
            );
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return allLogins;
   }

   /**
    *  Get all users List. Need it for servlet03
    */
   public List getAllUsers() throws SQLException {
      java.util.List<User> allUsers = new ArrayList<User>();
      String request = String.format("SELECT name, login, email, inserted_date FROM users");
      this.pst = this.conn.prepareStatement(request);
      try {
         this.rst = this.pst.executeQuery();
         while (rst.next()) {
            allUsers.add(new User(rst.getString("name"),
                    rst.getString("login"),
                    rst.getString("email"),
                    rst.getTimestamp("inserted_date"))
            );
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return (List) allUsers;
   }

   /**
    *  Disconnect from DB
    */
   public void disconnectDb() {
      try {
         assert conn != null;
         this.conn.close();
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      try {
         if (this.pst != null) {
            this.pst.close();
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      try {
         if (this.stm != null) {
            this.stm.close();
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      try {
         if (this.rst != null) {
            this.rst.close();
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
   }

}
