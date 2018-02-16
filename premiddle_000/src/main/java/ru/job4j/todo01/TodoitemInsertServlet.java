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
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.List;

public class TodoitemInsertServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      writer.append("This is servlet TodoitemInsertServlet, doGet method. There is no new description");
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      synchronized (session) {
         if (session.getAttribute("login") == null || session == null) {
            resp.sendRedirect("login.jsp?from=TodoitemInsertServlet");
         } else {
            SessionFactory factory = new Configuration()
                    .configure() // configure setting from hibernate,cfg,xml
                    .buildSessionFactory();
            Session dbSession = factory.openSession();
            dbSession.beginTransaction();
            TodoItem item = new TodoItem();
            String descr = req.getParameter("descr");
            if (!descr.equals(null) && !descr.equals("null")) {
               item.setDescr(descr);
               item.setDone(false);
               item.setCreated(new Timestamp(System.currentTimeMillis()));
               dbSession.save(item);
               dbSession.getTransaction().commit();
               dbSession.close();
               factory.close();
            }
            resp.sendRedirect("todoitems.jsp?out=From_doPost_TodoitemInsertServlet");
         }
      }
   }

}
