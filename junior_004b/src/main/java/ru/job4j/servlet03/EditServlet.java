package ru.job4j.servlet03;


import ru.job4j.crud02.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Создадим сервлет, который будет дергать UserStore03.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class EditServlet extends HttpServlet {

   private final UserStore03 userStore = UserStore03.SingletonEnum.INSTANCE.getInstance();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      String userLogin = req.getParameter("login");
      User user = null;
      try {
         user = this.userStore.getUser(userLogin);
      } catch (SQLException e) {
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

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userLogin = req.getParameter("login");
      String userName = req.getParameter("name");
      String userEmail = req.getParameter("email");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      writer.append(String.format("Login: %s, Name: %s, Email: %s", userLogin, userName, userEmail));
      writer.flush();
      //if (!userName.equals(null)) { //&& !userName.equals("")) {
         try {
            this.userStore.updateUser(userLogin, userName, userEmail);
         } catch (SQLException e) {
            e.printStackTrace();
         }
      //}  */
      doGet(req, resp);
   }

}
