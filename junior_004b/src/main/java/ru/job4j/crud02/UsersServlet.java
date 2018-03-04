package ru.job4j.crud02;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
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

   //private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);
   private final UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userLogin = req.getParameter("login");
      User user = null;
      try {
         user = this.userStore.getUser(userLogin);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());                               //
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

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String newName = req.getParameter("name");
      String login = req.getParameter("login");
      String newEmail = req.getParameter("email");
      try {
         this.userStore.updateUser(login, newName, newEmail);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }
   }

   @Override
   protected void doPut(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userName = req.getParameter("name");
      String userLogin = req.getParameter("login");
      String userEmail = req.getParameter("email");
      try {
         this.userStore.addUser(userName, userLogin, userEmail);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }
   }

   @Override
   protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userLogin = req.getParameter("login");
      try {
         this.userStore.deleteUser(userLogin);
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
