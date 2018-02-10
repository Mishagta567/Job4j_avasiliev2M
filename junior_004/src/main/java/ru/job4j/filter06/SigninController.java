package ru.job4j.filter06;


import ru.job4j.crud02.UserCS;
import ru.job4j.crud02.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


/**
 * Создадим сервлет, который будет отвечать за проверку сессии
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class SigninController extends HttpServlet {
   /**
    * Logger for database errors. У меня по-прежнему не работает.
    */
   //private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);

   private final UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();


   /**
    * Get and post
    */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      synchronized (session) {
         if (session == null || session.getAttribute("login") == null) {
            resp.sendRedirect("/LoginView.jsp?out=SigninController_doGet");
         } else {
            req.setAttribute("user", "alex");
            req.getRequestDispatcher("/items/UsersView.jsp?out=SigninController_doGet").forward(req, resp);
         }
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      String login = req.getParameter("login");
      String pass = req.getParameter("password");
      try {
         if (userStore.isCredentional(login, pass)) {
            HttpSession session = req.getSession();
            synchronized (session) {
               session.setAttribute("login", login);
               session.setAttribute("role", userStore.getRole(login));
            }
            resp.sendRedirect(("/items/UsersView.jsp?out=SigninController_Signed"));
         } else {
            req.setAttribute("error", "Credentional invalid");
            resp.sendRedirect(("/items/LoginView.jsp?err=Invalid"));
            //doGet(req, resp);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
