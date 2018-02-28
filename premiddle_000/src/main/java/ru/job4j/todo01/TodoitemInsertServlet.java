package ru.job4j.todo01;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;

public class TodoitemInsertServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      writer.append("This is servlet TodoitemInsertServlet, doGet method. There is no new description");
      writer.flush();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session = req.getSession();
      synchronized (session) {
         if (session.getAttribute("login") == null || session == null) {
            //resp.sendRedirect("/WEB-INF/views/todo01/loginView.jsp?from=TodoitemInsertServlet");
            req.getRequestDispatcher("/WEB-INF/views/todo01/loginView.jsp?from=TodoitemInsertServlet").forward(req, resp); // or //
         } else {
            SessionFactory factory = new Configuration()
                    .configure() // configure setting from hibernate,cfg,xml
                    .buildSessionFactory();
            Session dbSession = factory.openSession();
            dbSession.beginTransaction();
            TodoItem todoItem = new TodoItem();
            String descr = req.getParameter("descr");
            if (!descr.equals(null) && !descr.equals("")) {
               todoItem.setDescr(descr);
               todoItem.setDone(false);
               todoItem.setCreated(new Timestamp(System.currentTimeMillis()));
               dbSession.save(todoItem);
               dbSession.getTransaction().commit();
               dbSession.close();
               factory.close();
            }
            //resp.sendRedirect("/WEB-INF/views/todo01/todoitems.jsp?out=From_doPost_TodoitemInsertServlet");
            req.getRequestDispatcher("/WEB-INF/views/todo01/todoitems.jsp?out=From_doPost_TodoitemInsertServlet").forward(req, resp); // or //
         }
      }
   }

}
