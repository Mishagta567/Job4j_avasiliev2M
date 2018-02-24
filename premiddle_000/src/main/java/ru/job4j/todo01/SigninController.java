package ru.job4j.todo01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.job4j.video00.User00;
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
            req.getRequestDispatcher("/WEB-INF/views/todo01/loginView.jsp?get=From_signinController_Not_signed").forward(req, resp); // or //
         } else {
            req.getRequestDispatcher("/WEB-INF/views/todo01/todoitems.jsp?out_get=UserController_Signed").forward(req, resp);  // Пашет
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
         Query query = session.createQuery(String.format("FROM User00 WHERE login = '%s' AND password = '%s'", login, pass));
         List<User00> myUser00 = query.list();
         session.close();
         factory.close();
         if (myUser00.size() > 0) {
            HttpSession userSession = req.getSession();
            synchronized (session) {
               userSession.setAttribute("login", login);
            }
            //resp.sendRedirect("todoitems.jsp?out=SigninController_Signed");
            doGet(req, resp);
         } else {
            req.setAttribute("error", "Login_or_Pass_invalid");
            doGet(req, resp);
         }
      }
   }

}
