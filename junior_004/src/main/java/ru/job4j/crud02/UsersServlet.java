package ru.job4j.crud02;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Создадим сервлет, который будет дергать UserStore.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class UsersServlet extends HttpServlet {

   /**
    * Logger for database errors. У меня по-прежнему не работает.
    */
   //private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);
   /**
    * Specified database manager instance.
    */
   private final UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();


   /**
    * Returns user-info specified by login.
    */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userLogin = req.getParameter("login");
      UserCS user = null;
      try {
         user = this.userStore.getUserCS(userLogin);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      if (user != null) {
         writer.append(user.toString());
      } else {
         writer.append(String.format("There is no user with login %s.", userLogin));
      }
      writer.flush();
   }

   /**
    * Edits user's information (Можно менять: name, login, email)
    */
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String newName = req.getParameter("name");
      String login = req.getParameter("login");
      String newEmail = req.getParameter("email");
      try {
         this.userStore.updateUserCS(login, newName, newEmail);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }
   }

   /**
    * Creates new user (с параметрами name, login, email).
    */
   @Override
   protected void doPut(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userName = req.getParameter("name");
      String userLogin = req.getParameter("login");
      String userEmail = req.getParameter("email");
      try {
         this.userStore.addUserCS(userName, userLogin, userEmail);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }
   }

   /**
    * Deletes user specified by login.
    */
   @Override
   protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userLogin = req.getParameter("login");
      try {
         this.userStore.deleteUserCS(userLogin);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }
   }

   @Override
   public void destroy() {
         this.userStore.disconnectDb();
   }

}
