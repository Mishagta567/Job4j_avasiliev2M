package ru.job4j.todo01;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class JsonController extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/json");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      AllTodoItems allTodoItems = new AllTodoItems();
      List<TodoItem>  allItems = allTodoItems.getAllItems();
      writer.append("[");
      for (int indx = 0; indx < allItems.size(); indx++) {
         writer.append(String.format("{'id':'%s', 'descr':'%s', 'created':'%s', 'done':'%s'}",
            allItems.get(indx).getId(), allItems.get(indx).getDescr(), allItems.get(indx).getCreated(), allItems.get(indx).getDone()));
         if (indx < allItems.size() - 1) {
            writer.append(", ");
         }
      }
      writer.append("]");
      writer.flush();
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      resp.setContentType("text/html");
      doGet(req, resp);
   }

}
