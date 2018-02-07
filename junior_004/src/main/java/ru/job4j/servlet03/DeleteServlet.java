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

public class DeleteServlet extends HttpServlet {

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
      writer.append("user Deleted");
      writer.flush();
   }

   /**
    * Edits user's information (Можно менять: name, login, email)
    */
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      String userLogin = req.getParameter("login");
      try {
         this.userStore.deleteUserCS(userLogin);
      } catch (SQLException e) {
         //LOG.error(e.getMessage());
         e.printStackTrace();
      }
      doGet(req, resp);
   }


   @Override
   public void destroy() {
         this.userStore.disconnectDb();
   }

}
