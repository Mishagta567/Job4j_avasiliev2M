package ru.job4j.filter06;

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

public class UserStore06 {

   private Connection conn;
   private String dbUrl;
   private String user;
   private String password;
   private PreparedStatement prepSt;
   private ResultSet rs;
   private Statement st;
   private static UserStore06 instance;

   private UserStore06() throws SQLException, IOException {
      this.dbUrl = "jdbc:postgresql://localhost:5432/junior003";
      this.user = "postgres";
      this.password = "raduga";
      this.connectDb();
   }

   public enum SingletonEnum {
      INSTANCE;
      public UserStore06 getInstance() {
         try {
            instance = new UserStore06();
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
      p.setTestOnBorrow(true);
      p.setTestWhileIdle(false);
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
         this.rs = this.conn.getMetaData().
                 getTables(null, null, "users", null);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /**
    *  Add new user
    *  @param name - field 'name'
    *  @param login - field 'login'
    *  @param email - field 'email'
    */
   public boolean addUser(String login, String password, String name, String email, int roleId)
           throws SQLException {
      String request = String.format("INSERT INTO users (login, password, role_id, name, email, inserted_date) "
                      + " VALUES('%s', '%s', '%s', '%s', '%s', CURRENT_TIMESTAMP(0))", login, password, roleId, name, email);
      this.st = this.conn.createStatement();
      boolean result = false;
      try {
         result = this.st.execute(request);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

   /**
    *  Get all info about user by login
    *  @param login - field login
    */
   public User06 getUser(String login) throws SQLException {
      String request = String.format("SELECT us.id id, us.login, us.password, us.role_id, us.name, us.inserted_date, "
                            + " us.email, rl.id roleid, rl.role rolename "
                            + " FROM users AS us INNER JOIN role AS rl ON us.role_id = rl.id WHERE us.login = '%s' ", login);
      User06 user = null;
      this.prepSt = this.conn.prepareStatement(request);
      try {
         //this.prepSt.setString(1, login);
         this.rs = this.prepSt.executeQuery();
         while (rs.next()) {
            user = new User06(rs.getInt("id"),
                            rs.getString("login"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getTimestamp("inserted_date"),
                            rs.getInt("roleId"),
                            rs.getString("roleName")
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
    *  @param name - new name
    *  @param email - new Email
    *
    *  (int id, String login, String password, String name, String email, Timestamp insertedDate, int roleId, String roleName)
    */
   public boolean updateUser(int id, String login, String password, String name, String email, int roleId)
           throws SQLException {
      //User06 user = getUser(login);
      boolean result = false;
      //if (user != null) {
         String request = String.format("UPDATE users SET login = '%s', password = '%s', name = '%s', email = '%s',"
                 + " role_id = '%s' WHERE id = %s", login, password, name, email, roleId, id);
         this.st = this.conn.createStatement();
         try {
            result = this.st.executeUpdate(request) > 0;
         } catch (SQLException e) {
            e.printStackTrace();
         }
      //}
      return result;
   }

   public void insertUser(String login, String password, String name, String email, int roleId)
           throws SQLException {
      String request = String.format("INSERT INTO users (login, password, name, email, role_id, inserted_date) "
              +  " VALUES('%s', '%s', '%s', '%s', %s, CURRENT_TIMESTAMP(0))", login, password, name, email, roleId);
      this.st = this.conn.createStatement();
      try {
         this.st.executeUpdate(request);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /**
    *  Delete user using login as a key.
    */
   public boolean deleteUser(int id) throws SQLException {
      boolean result = false;
      this.st = this.conn.createStatement();
      String request = String.format("DELETE FROM users WHERE id = %s", id);
      try {
         result = this.st.executeUpdate(request) > 0;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

   public List<String> getAlllogins() throws SQLException {
      String request = String.format("SELECT %s FROM users ORDER BY login", "login");
      List<String> allLogins = new ArrayList<String>();
      this.prepSt = this.conn.prepareStatement(request);
      try {
         this.rs = this.prepSt.executeQuery();
         while (rs.next()) {
            allLogins.add(rs.getString("login")
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
   public List<User06> getAllUsers() throws SQLException {
      List<User06> allUsers = new ArrayList<User06>();
      String request = String.format("SELECT us.id, us.login, us.password, us.role_id, us.name, us.inserted_date, "
              + " us.email, rl.id roleid, rl.role rolename "
              + " FROM users AS us INNER JOIN role AS rl ON us.role_id = rl.id");
      this.prepSt = this.conn.prepareStatement(request);
      try {
         this.rs = this.prepSt.executeQuery();
         while (rs.next()) {
            allUsers.add(new User06(rs.getInt("id"),
                    rs.getString("login"),
                    rs.getString("password"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getTimestamp("inserted_date"),
                    rs.getInt("roleId"),
                    rs.getString("roleName"))
            );
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return (List) allUsers;
   }

   public boolean isCredentional(String login, String pass) throws SQLException {
      int count = 0;
      String request = String.format("SELECT count(*) FROM users WHERE login=? AND password=?");
      this.prepSt = this.conn.prepareStatement(request);
      try {
         this.prepSt.setString(1, login);
         this.prepSt.setString(2, pass);
         this.rs = this.prepSt.executeQuery();
         while (rs.next()) {
            count = rs.getInt(1);
         }
      } catch (SQLException e) {
         //LOG.error(e.getMessage(), e);
         e.printStackTrace();
      }
      return (count > 0);
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
         if (this.prepSt != null) {
            this.prepSt.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      try {
         if (this.st != null) {
            this.st.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      try {
         if (this.rs != null) {
            this.rs.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public String getRole(String login) throws SQLException {
      String role = null;
      String request = ("SELECT rl.role FROM users us INNER JOIN role rl on us.role_id = rl.id WHERE us.login = ?");
      this.prepSt = this.conn.prepareStatement(request);
      try {
         this.prepSt.setString(1, login);
         this.rs = this.prepSt.executeQuery();
         while (rs.next()) {
            role = rs.getString(1);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return role;
   }

   public boolean updateRoleName(int id, String newRoleName)
           throws SQLException {
      boolean result = false;
      //if (user != null) {
      String request = String.format("UPDATE role SET role = '%s' WHERE id = %s",
              newRoleName, id);
      this.st = this.conn.createStatement();
      try {
         result = this.st.executeUpdate(request) > 0;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      //}
      return result;
   }

   public boolean insertRole(String newRoleName) throws SQLException {
      String request = String.format("INSERT INTO role (role) VALUES('%s')", newRoleName);
      this.st = this.conn.createStatement();
      boolean result = false;
      try {
         result = this.st.execute(request);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

   public List<Role06> getAllRoles() throws SQLException {
      List<Role06> allRoles = new ArrayList<Role06>();
      String request = String.format("SELECT rl.id roleid, rl.role rolename FROM role AS rl");
      this.prepSt = this.conn.prepareStatement(request);
      try {
         this.rs = this.prepSt.executeQuery();
         while (rs.next()) {
            allRoles.add(new Role06(rs.getInt("roleid"),
                               rs.getString("roleName"))
            );
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return (List) allRoles;
   }

   public boolean deleteRole(int id) throws SQLException {
      boolean result = false;
      this.st = this.conn.createStatement();
      String request = String.format("DELETE FROM role WHERE id = %s", id);
      try {
         result = this.st.executeUpdate(request) > 0;
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

}
