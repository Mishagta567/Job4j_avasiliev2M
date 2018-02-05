package ru.job4j.strctr01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * An echo servlet.
 */
public class EchoServlet extends HttpServlet {
   /**
    * Logger for database errors.
    */
   private static final Logger LOG = LoggerFactory.getLogger(ru.job4j.strctr01.EchoServlet.class);

   private List<String> users = new CopyOnWriteArrayList<String>();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());

      StringBuilder sb = new StringBuilder();
      sb.append("<table>");
      for (String lgn : users) {
         sb.append("<tr><td>" + lgn + "</td></tr>");
      }
      sb.append("</table>");

      writer.append("<!DOCTYPE html>"
              + "<html lang=\"en\">"
              + "<head>"
              + "    <meta charset=\"UTF-8\">"
              + "    <title>Title</title>"
              + "</head>"
              + "<body>"
              + "<form action='" + req.getContextPath() + "/echo' metod='post'>"
              + "Name: <input type='text' name='login'/>"
              + "<input type='submit'/>"
              + "</form>"
              + "</br>" + "</br>"
              + sb.toString()
              + "</body>"
              + "</html>");  // */

      writer.flush();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      this.users.add(req.getParameter("login"));
      doGet(req, resp);
   }

}
