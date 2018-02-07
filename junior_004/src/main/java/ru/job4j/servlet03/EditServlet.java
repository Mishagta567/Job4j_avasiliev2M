package ru.job4j.servlet03;


import ru.job4j.crud02.UserCS;
import ru.job4j.crud02.UserStore;

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

public class EditServlet extends HttpServlet {

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
      PrintWriter writer = new PrintWriter(resp.getOutputStream());

      String userLogin = req.getParameter("login");
      UserCS user = null;
      try {
         user = this.userStore.getUserCS(userLogin);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }

      if (user != null) {
         writer.append("<form action='" + req.getContextPath() + "/edit03' method='post'>"
                 + "Login: <input type='text' value='" + user.getLogin() + "' name='login'><br/>"
                 + "Name: <input type='text' value='" + user.getName() + "' name='name'><br/>"
                 + "Email: <input type='text' value='" + user.getEmail() + "' name='email'><br/>"
                 + "<input type='submit'>"
                 + "</form>");
         writer.append(user.toString());
      } else {
         writer.append("<form action='" + req.getContextPath() + "/edit03' method='post'>"
                 + "Login: <input type='text' name='login'><br/>"
                 + "Name: <input type='text' name='name'><br/>"
                 + "Email: <input type='text' name='email'><br/>"
                 + "<input type='submit'>"
                 + "</form>");
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
      String userName = req.getParameter("name");
      String userLogin = req.getParameter("login");
      String userEmail = req.getParameter("email");
      //if (!userName.equals(null)) { //&& !userName.equals("null")) {
         try {
            this.userStore.updateUserCS(userLogin, userName, userEmail);
         } catch (SQLException e) {
            //LOG.error(e.getMessage());
            e.printStackTrace();
         }
      //}
      doGet(req, resp);
   }

}
