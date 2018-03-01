package ru.job4j.cars02.servlets;



import ru.job4j.cars02.AllCarsAds;

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

public class SigninController02 extends HttpServlet {


   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      synchronized (session) {
         if (session == null || session.getAttribute("login") == null) {
            req.setAttribute("error", "Credentional invalid"); // Пашет
            req.getRequestDispatcher("/WEB-INF/views/cars02/loginView.jsp?out=get_UserController_NOT_Signed").forward(req, resp); // or //
//            writer.append("Пароль не верный <br> <a href=\"loginView.jsp\">Авторизоваться</a>");
//            writer.flush();
         } else {
            req.getRequestDispatcher("/carsAds.jsp?out=get_UserController_Signed").forward(req, resp);  // Пашет
//            writer.append("Вы авторизованы <br> <a href=\"carsAds.jsp\">Все объявления</a>");
//            writer.flush();
         }
      }
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());

      resp.setContentType("text/html");
      String login = req.getParameter("login");
      String pass = req.getParameter("password");
      AllCarsAds allCarsAds = new AllCarsAds();
      int userid = allCarsAds.getLogin(login, pass);
      if (userid > 0) {
         HttpSession session = req.getSession();
         synchronized (session) {
            session.setAttribute("login", login);
            session.setAttribute("userid", userid);
         }
         doGet(req, resp);
      } else {
         doGet(req, resp);
      } //
   }

}
