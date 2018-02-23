package ru.job4j.filter06;

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
public class EditUserServlet06 extends HttpServlet {

   private final UserStore06 userStore = UserStore06.SingletonEnum.INSTANCE.getInstance();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");

      int id = Integer.parseInt(req.getParameter("id"));
      try {
         this.userStore.deleteUser(id);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      req.getRequestDispatcher("/WEB-INF/filter06/userList.jsp?out_get=UserController_Signed").forward(req, resp);  // Пашет

   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      int id = Integer.parseInt(req.getParameter("id"));
      String login = req.getParameter("login");
      String password = req.getParameter("password");
      String name = req.getParameter("name");
      String email = req.getParameter("email");
      int roleId = Integer.parseInt(req.getParameter("roleId"));
      //if (!userName.equals(null)) { //&& !userName.equals("")) {
         try {
            this.userStore.updateUser(id, login, password, name, email, roleId);
         } catch (SQLException e) {
            e.printStackTrace();
         }
      //}  */
      req.getRequestDispatcher("/WEB-INF/filter06/userList.jsp?out_get=UserController_Signed").forward(req, resp);  // Пашет
   }

}
