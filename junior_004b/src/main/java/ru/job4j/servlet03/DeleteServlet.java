package ru.job4j.servlet03;


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

public class DeleteServlet extends HttpServlet {

   private final UserStore03 userStore = UserStore03.SingletonEnum.INSTANCE.getInstance();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      writer.append("user Deleted");
      writer.flush();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userLogin = req.getParameter("login");
      try {
         this.userStore.deleteUser(userLogin);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      doGet(req, resp);
   }

   @Override
   public void destroy() {
         this.userStore.disconnectDb();
   }

}
