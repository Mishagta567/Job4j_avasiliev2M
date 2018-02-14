package ru.job4j.mvc05;


import ru.job4j.crud02.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Queue;


/**
 * Создадим сервлет, который будет дергать UserStore.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class UsersController extends HttpServlet {

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
   public void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      writer.append("Hello there. Page src/main/java/mvc05/UsersController.java");
      writer.flush();
      // По какой-то причине не работает переадресация.
      //req.getRequestDispatcher("/WEB-INF/views/UsersView.jsp").forward(req, resp);
      //req.getRequestDispatcher("/UsersView.jsp").forward(req, resp);
   }


}
