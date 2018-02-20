package ru.job4j.servlet03;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */
public class NewuserServlet extends HttpServlet {

   private final UserStore03 userStore = UserStore03.SingletonEnum.INSTANCE.getInstance();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      writer.append("<form action='" + req.getContextPath() + "/newuser03' method='post'>"
                 + "Login: <input type='text' name='login'><br/>"
                 + "Name: <input type='text' name='name'><br/>"
                 + "Email: <input type='text' name='email'><br/>"
                 + "<input type='submit'>"
              + "</form>");
      writer.flush();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userEmail = req.getParameter("email");
      String userLogin = req.getParameter("login");
      String userName = req.getParameter("name");
      try {
         this.userStore.addUser(userName, userLogin, userEmail);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      resp.sendRedirect(String.format("%s/", req.getContextPath()));
   }

}
