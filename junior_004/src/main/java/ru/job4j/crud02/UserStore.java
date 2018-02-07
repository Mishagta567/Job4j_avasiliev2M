package ru.job4j.crud02;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Class, wich fo all job for UsersServlet
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev, 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class UserStore {
   //private static final Logger LOG = LoggerFactory.getLogger(UserStore.class);

   private Connection conn;
   private String dbUrl;
   private String user;
   private String password;
   private PreparedStatement ps;
   private ResultSet rs;
   private Statement st;
   private static UserStore instance;

   private UserStore() throws SQLException, IOException {
      this.dbUrl = "jdbc:postgresql://localhost:5432/junior003";
      this.user = "postgres";
      this.password = "raduga";
      this.connectDb();
   }

   // Вот эту шнягу Я не понимаю. Что такое INSTANCE ?   enum  ?
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
         this.rs = this.conn.getMetaData().
                 getTables(null, null, "users", null);
         // Если таблица не создана - суетиться нужно? Или считаем что есть?
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
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
         if (this.ps != null) {
            this.ps.close();
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      try {
         if (this.st != null) {
            this.st.close();
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      try {
         if (this.rs != null) {
            this.rs.close();
         }
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
   public boolean addUserCS(String userName, String userLogin, String userEmail)
           throws SQLException {
      boolean result = false;
      String request = String.format("INSERT INTO users (login, name, email, inserted_date) VALUES(?,?,?, CURRENT_TIMESTAMP(0))");
      this.ps = this.conn.prepareStatement(request);
      try {
         this.ps.setString(1, userLogin);
         this.ps.setString(2, userName);
         this.ps.setString(3, userEmail);
         result = this.ps.execute();
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
   public UserCS getUserCS(String login) throws SQLException {
      UserCS user = null;
      String request = String.format("SELECT name, login, email, inserted_date FROM users WHERE login = ?");
      this.ps = this.conn.prepareStatement(request);
      try {
         this.ps.setString(1, login);
         this.rs = this.ps.executeQuery();
         while (rs.next()) {
            user = new UserCS(rs.getString("name"),
                              //"damn_login",
                              rs.getString("login"),
                              //"dam_mail",
                              rs.getString(3),
                              rs.getTimestamp("inserted_date")
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
   public boolean updateUserCS(String login, String newName, String newEmail)
           throws SQLException {
      boolean result = false;
      UserCS user = getUserCS(login);
      if (user != null) {
         String request = String.format("UPDATE users SET name = '%s', email = '%s' "
                 + "WHERE login = '%s'", newName, newEmail, login);
         this.st = this.conn.createStatement();
         try {
            result = this.st.executeUpdate(request) > 0;
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
   public boolean deleteUserCS(String login) throws SQLException {
      boolean result = false;
      String request = String.format("DELETE FROM users WHERE login = '%s'", login);
      this.st = this.conn.createStatement();
      try {
         result = this.st.executeUpdate(request) > 0;
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return result;
   }

   public Queue getAllUsers() throws SQLException {
      Queue<String> allLogins = new LinkedList<String>();
      String request = String.format("SELECT %s FROM users", "login");
      this.ps = this.conn.prepareStatement(request);
      try {
         this.rs = this.ps.executeQuery();
         while (rs.next()) {
            allLogins.add(rs.getString("login")
            );
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return allLogins;
   }

}
