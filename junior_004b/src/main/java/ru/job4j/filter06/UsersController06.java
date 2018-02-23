package ru.job4j.filter06;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


/**
 * Создадим сервлет, который будет отвечать за проверку сессии
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class UsersController06 extends HttpServlet {

   private final UserStore06 userStore = UserStore06.SingletonEnum.INSTANCE.getInstance();


   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      synchronized (session) {
         //if (session == null || session.getAttribute("login") == null) {
         //   resp.sendRedirect(String.format("%s/signin?out=UserController_doGet"));
         //} else {
         //   req.getRequestDispatcher("/WEB-INF/mvc05/userList.jsp?out=SigninController_doGet").forward(req, resp);
         //}
         req.getRequestDispatcher("/WEB-INF/mvc05/userList.jsp?out=SigninController_doGet").forward(req, resp);
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      String login = req.getParameter("login");
      String pass = req.getParameter("password");
      //try {
      //   if (userStore.isCredentional(login, pass)) {
      //      HttpSession session = req.getSession();
      //      synchronized (session) {
      //         session.setAttribute("role", userStore.getRole(login));
      //         session.setAttribute("login", login);
      //      }
      //      resp.sendRedirect(("/WEB-INF/mvc05/userList.jsp?out=SigninController_Signed"));
      //   } else {
      //      req.setAttribute("error", "Credentional invalid");
      //      resp.sendRedirect(("/items/loginView.jsp?error=Invalid"));
      //      //doGet(req, resp);
      //   }
      //} catch (SQLException e) {
      //   e.printStackTrace();
      //}
      resp.sendRedirect(("/WEB-INF/mvc05/userList.jsp?out=SigninController_Signed"));
   }

}
