package ru.job4j.filter06;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Создадим сервлет, который будет отвечать за SignOut
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class SigninOutController06 extends HttpServlet {

   private final UserStore06 userStore = UserStore06.SingletonEnum.INSTANCE.getInstance();


   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      HttpSession session = req.getSession();
      synchronized (session) {
         if (session != null && session.getAttribute("login") != null) {
            session.removeAttribute("role");
            session.removeAttribute("login");
            session.invalidate();
            req.getRequestDispatcher("/WEB-INF/filter06/loginView.jsp?Out_get=From_signinController_Not_signed").forward(req, resp); // or //
         }
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      doGet(req, resp);
   }

}
