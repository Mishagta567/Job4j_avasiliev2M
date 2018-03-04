package ru.job4j.webproject01;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EchoServlet extends HttpServlet {
   //private static final Logger LOG = LoggerFactory.getLogger(EchoServlet.class);

   private List<String> users = new CopyOnWriteArrayList<String>();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      StringBuilder sbb = new StringBuilder();
      //if (!req.getParameter("login").equals(null)){
         this.users.add(req.getParameter("login"));
         for (String lgn : users) {
            sbb.append(lgn + "<br>");
         }
      //}

      writer.append("<!DOCTYPE html>"
              + "<html lang=\"en\">"
              + "<head>"
              + "    <meta charset=\"UTF-8\">"
              + "    <title>Title</title>"
              + "</head>"
              + "<body>"
              + "<form action='" + req.getContextPath() + "/echo' method='post'>"
              + "Name: <input type='text' name='login'>"
              + "<input type='submit'>"
              + "</form>"
              + "</br>" + "</br>"
              + sbb.toString()
              + "</body>"
              + "</html>");

      writer.flush();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //resp.setContentType("text/html");
      //this.users.add(req.getParameter("login") + "Post work");
      doGet(req, resp);
   }


}
