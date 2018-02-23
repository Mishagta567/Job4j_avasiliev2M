package ru.job4j.mvcjstl05;

import ru.job4j.servlet03.UserStore03;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UsersControler05 extends HttpServlet {

   private List<String> users = new CopyOnWriteArrayList<String>();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/WEB-INF/mvc05/userList.jsp").forward(req, resp);
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      resp.sendRedirect(String.format("%s/", req.getContextPath()));
   }


}
