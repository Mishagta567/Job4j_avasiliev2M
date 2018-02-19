package ru.job4j.servlet03;

import ru.job4j.crud02.User;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Class, wich fo all job for UsersServlet
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev, 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class UserStore03 {

   private Connection conn;
   private String dbUrl;
   private String user;
   private String password;
   private PreparedStatement pstt;
   private ResultSet rstt;
   private Statement sttm;
   private static UserStore03 instance;

   private UserStore03() throws SQLException, IOException {
      this.dbUrl = "jdbc:postgresql://localhost:5432/junior003";
      this.user = "postgres";
      this.password = "raduga";
      this.connectDb();
   }

   public enum SingletonEnum {
      INSTANCE;
      public UserStore03 getInstance() {
         try {
            instance = new UserStore03();
         } catch (SQLException | IOException e) {
            e.printStackTrace();
         }
         return instance;
      }
   }

   /**
    *  Connect to DB
    */
   private void connectDb() throws SQLException, IOException {
      // Till try we need to get pool connection
      PoolProperties p = new PoolProperties();
      p.setUrl(this.dbUrl);
      p.setDriverClassName("org.postgresql.Driver");
      p.setUsername(this.user);
      p.setPassword(this.password);
      p.setJmxEnabled(true);
      p.setTestWhileIdle(false);
      p.setTestOnBorrow(true);
      p.setValidationQuery("SELECT 1");
      p.setTestOnReturn(false);
      p.setValidationInterval(30000);
      p.setTimeBetweenEvictionRunsMillis(30000);
      p.setMaxActive(100);
      p.setInitialSize(10);
      p.setMaxWait(10000);
      p.setRemoveAbandonedTimeout(60);
      p.setMinEvictableIdleTimeMillis(30000);
      p.setMinIdle(10);
      p.setLogAbandoned(true);
      p.setRemoveAbandoned(true);
      p.setJdbcInterceptors("org.apache.tomcat.jdbc.pool.interceptor.ConnectionState;"
                      + "org.apache.tomcat.jdbc.pool.interceptor.StatementFinalizer");
      DataSource datasource = new DataSource();
      datasource.setPoolProperties(p);

      try {
         Class.forName("org.postgresql.Driver");
         this.conn = datasource.getConnection();
      } catch (ClassNotFoundException | SQLException e) {
         e.printStackTrace();
      }
      try {
         this.rstt = this.conn.getMetaData().
                 getTables(null, null, "users", null);
      } catch (SQLException e) {
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
      String request = String.format("INSERT INTO users (login, name, email, inserted_date) VALUES('%s', '%s', '%s', CURRENT_TIMESTAMP(0))",
                                                    userLogin, userName, userEmail);
      boolean result = false;
      this.sttm = this.conn.createStatement();
      try {
         result = this.sttm.execute(request);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

   /**
    *  Get all info about user by login
    *  @param login - field login
    */
   public User getUser(String login) throws SQLException {
      String request = String.format("SELECT name, login, email, inserted_date FROM users WHERE login = ?");
      this.pstt = this.conn.prepareStatement(request);
      User user = null;
      try {
         this.pstt.setString(1, login);
         this.rstt = this.pstt.executeQuery();
         while (rstt.next()) {
            user = new User(rstt.getString("name"),
                              rstt.getString("login"),
                              rstt.getString("email"),
                              rstt.getTimestamp("inserted_date")
            );
         }
      } catch (SQLException e) {
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
      User user = getUser(login);
      boolean result = false;
      if (user != null) {
         String request = String.format("UPDATE users SET name = '%s', email = '%s' WHERE login = '%s'",
                 newName, newEmail, login);
         this.sttm = this.conn.createStatement();
         try {
            result = this.sttm.executeUpdate(request) > 0;
         } catch (SQLException e) {
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
      this.sttm = this.conn.createStatement();
      String request = String.format("DELETE FROM users WHERE login = '%s'", login);
      try {
         result = this.sttm.executeUpdate(request) > 0;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

   public List<String> getAlllogins() throws SQLException {
      String request = String.format("SELECT %s FROM users ORDER BY login", "login");
      List<String> allLogins = new ArrayList<String>();
      this.pstt = this.conn.prepareStatement(request);
      try {
         this.rstt = this.pstt.executeQuery();
         while (rstt.next()) {
            allLogins.add(rstt.getString("login")
            );
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return allLogins;
   }

   /**
    *  Get all users List. Need it for servlet03
    */
   public List getAllUsers() throws SQLException {
      List<User> allUsers = new ArrayList<User>();
      String request = String.format("SELECT name, login, email, inserted_date FROM users");
      this.pstt = this.conn.prepareStatement(request);
      try {
         this.rstt = this.pstt.executeQuery();
         while (rstt.next()) {
            allUsers.add(new User(rstt.getString("name"),
                    rstt.getString("login"),
                    rstt.getString("email"),
                    rstt.getTimestamp("inserted_date"))
            );
         }
      } catch (SQLException e) {
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
         e.printStackTrace();
      }
      try {
         if (this.pstt != null) {
            this.pstt.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      try {
         if (this.sttm != null) {
            this.sttm.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      try {
         if (this.rstt != null) {
            this.rstt.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
