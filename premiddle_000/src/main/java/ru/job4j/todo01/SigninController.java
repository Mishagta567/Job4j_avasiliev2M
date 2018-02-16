package ru.job4j.todo01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.job4j.video00.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class SigninController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      synchronized (session) {
      if (session == null || session.getAttribute("login") == null) {
         resp.sendRedirect("login.jsp");
         /**
          * Очень хочется понять почему не работает эта вещь. Почему не показывает в views
          * resp.sendRedirect("../WEB-INF/views/login.jsp?out=From_doGet_SigninController");
         */
      } else {
            req.setAttribute("user", "alex");
            req.getRequestDispatcher("todoitems.jsp?out=From_doGet_SigninController").forward(req, resp); //req.getContextPath())).forward(req, resp);
         }
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      String login = req.getParameter("login");
      String pass = req.getParameter("password");
      if (!login.equals(null) && !pass.equals(null)) {
         SessionFactory factory = new Configuration()
                 .configure() // configure setting from hibernate,cfg,xml
                 .buildSessionFactory();
         Session session = factory.openSession();
         session.beginTransaction();
         User user = new User();
         user.setLogin(login);
         user.setPassword(pass);
         Query query = session.createQuery(String.format("FROM User WHERE login = '%s' AND password = '%s'", login, pass));
         List<User> myUser = query.list();
         session.close();
         factory.close();
         if (myUser.size() > 0) {
            HttpSession userSession = req.getSession();
            synchronized (session) {
               userSession.setAttribute("login", login);
            }
            resp.sendRedirect("todoitems.jsp?out=SigninController_Signed");
         } else {
            req.setAttribute("error", "Login_or_Pass_invalid");
            resp.sendRedirect("login.jsp?error=Invalid_User_or_password");
         }
      }
   }

}
