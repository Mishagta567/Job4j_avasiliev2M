package ru.job4j.webproject01;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;


public class JdbcPoolTest {

   public static void main(String[] args) throws Exception {
      PoolProperties p = new PoolProperties();
      p.setUrl("jdbc:postgresql://localhost:5432/junior003");
      p.setDriverClassName("org.postgresql.Driver");
      p.setUsername("postgres");
      p.setPassword("raduga");
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

      Connection con = null;
      try {
         con = datasource.getConnection();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("select * from users");
         int cnt = 1;
         while (rs.next()) {
            System.out.println((cnt++) + " Login:" + rs.getString("login")
                    + " Password:" + rs.getString("Password"));
         }
         rs.close();
         st.close();
      } finally {
         if (con != null) {
            try {
               con.close();
            } catch (Exception ignore) {
            }
         }
      }
   }

}