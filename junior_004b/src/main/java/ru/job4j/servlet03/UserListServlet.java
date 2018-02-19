package ru.job4j.servlet03;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;


/**
 * Создадим сервлет, который будет дергать UserStore.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class UserListServlet extends HttpServlet {

   private final UserStore03 userStore = UserStore03.SingletonEnum.INSTANCE.getInstance();

   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      resp.setContentType("text/html");
      PrintWriter writer = new PrintWriter(resp.getOutputStream());
      writer.append("<!DOCTYPE html>"
              + "<html lang=\"en\">"
              + "<head>"
              + "    <meta charset=\"UTF-8\">"
              + "    <title>Title</title>"
              + "</head>"
              + "<body>");

      try {
         List alllogins = (List) userStore.getAlllogins();
         String path = req.getContextPath();
         writer.append("<table>");
         for (Object login : alllogins) {
            writer.append(String.format("<tr>"
                    + "        <td>%s</td>"
                    + "        <td><form action='%s/edit03'?login=%s method='get'><button>Edit</button>"
                    + "               <input type='hidden' name='login' value=%s>"
                    + "            </form></td>"
                    + "        <td><form action='%s/delete03'?login=%s method='post'><button>Delete</button>"
                    + "               <input type='hidden' name='login' value=%s>"
                    + "            </form></td>"
                    + "        <td> <a href='%s/newuser03'>Create new user</a> </td>"
                    + "    </tr>", login.toString(), path, login.toString(), login.toString(),
                                   path, login.toString(), login.toString(), path));
         }
         writer.append("</table>");
      } catch (SQLException e) {
         e.printStackTrace();
      }
      writer.append("</body>"
                  + "</html>");
         writer.flush();
   }

}
