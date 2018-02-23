package ru.job4j.filter06;


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

public class SigninController06 extends HttpServlet {

   private final UserStore06 userStore = UserStore06.SingletonEnum.INSTANCE.getInstance();


   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      synchronized (session) {
         if (session == null || session.getAttribute("login") == null) {
            req.getRequestDispatcher("/WEB-INF/filter06/loginView.jsp?Out_get=From_signinController_Not_signed").forward(req, resp); // or //
         } else {
            req.getRequestDispatcher("/WEB-INF/filter06/userList.jsp?out_get=UserController_Signed").forward(req, resp);  // Пашет
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
               session.setAttribute("role", userStore.getRole(login));
               session.setAttribute("login", login);
            }
            //resp.sendRedirect("/WEB-INF/filter06/userList.jsp?outPost=SgninController_Sgned");      // Почему не работает ?
            doGet(req, resp);
         } else {
            req.setAttribute("error", "Credentional invalid"); // Пашет
            doGet(req, resp);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

}
