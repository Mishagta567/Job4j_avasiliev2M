package ru.job4j.todo01;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TodoServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      AllTodoItems allTodoItems = new AllTodoItems();
      List<TodoItem>  allItems = allTodoItems.getAllItems();
      writer.append("<!DOCTYPE html>"
              + "<html lang=\"en\">"
              + "<head>"
              + "    <meta charset=\"UTF-8\">"
              + "    <title>my Todo Servlet</title>"
              + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
              + "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js\"></script>"
              + " <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"
              + "</head>"
              + "<body>"
              + "<table border=\"1\" cellspacing=\"5\">");
      for (TodoItem item : allItems) {
         writer.append(String.format("<tr>"
                 + "<td>"
                 +   "<label for=\"id\">ID:</label><br>%s"
                 + "</td>"
                 + "<td>"
                 +   "<label for=\"descr\">Description:</label>"
                 +   "<input type=\"email\" class=\"form-control\" id=\"desc\" placeholder=\"Enter description\" name=\"email\" value=\"%s\">"
                 + "</td>"
                 + "<td>"
                 +   "<label for=\"created\">Created:</label>"
                 +   "<input type=\"text\" class=\"form-control\" id=\"created\" placeholder=\"Enter description\" name=\"created\" value=\"%s\">"
                 + "</td>", item.getId(), item.getDescr(), item.getCreated()));
         if (item.getDone()) {
            writer.append("<td>"
                 +   "<label for=\"done\">Done:</label><br>"
                 +   "<input id=\"done\" type=\"checkbox\" value=\"true\" name=\"done\" checked>"
                 + "</td>"
                 + "</tr>");
         } else {
            writer.append("<td>"
                    +   "<label for=\"done\">Done:</label><br>"
                    +   "<input id=\"done\" type=\"checkbox\" value=\"false\" name=\"done\">"
                    + "</td>"
                    + "</tr>");
         }
      }
      writer.append("</table></body>"
              + "</html>");
      writer.flush();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      doGet(req, resp);
   }

}
