package ru.job4j.servlet03;


import ru.job4j.crud02.UserCS;
import ru.job4j.crud02.UserStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Queue;


/**
 * Создадим сервлет, который будет дергать UserStore.
 * Saving UserCS data in the PostgreSQL
 * @author Alex Vasiliev 9720560@gmail.com
 * @version $Id$
 * @since 0.1
 */

public class IndexServlet extends HttpServlet {

   /**
    * Logger for database errors. У меня по-прежнему не работает.
    */
   //private static final Logger LOG = LoggerFactory.getLogger(UsersServlet.class);
   /**
    * Specified database manager instance.
    */
   private final UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();


   /**
    * Returns user-info specified by login.
    */
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp)
           throws ServletException, IOException {
      Queue<String> allLogins = null;
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
         allLogins = userStore.getAllUsers();
         writer.append("<table>");
         String path = req.getContextPath();

         for (String login : allLogins) {
            writer.append(String.format("<tr>"
                    + "        <td>%s</td>"
                    + "        <td><form action='%s/edit03'?login=%s method='get'><button>Edit</button>"
                    + "               <input type='hidden' name='login' value=%s>"
                    + "            </form></td>"
                    + "        <td><form action='%s/delete03'?login=%s method='post'><button>Delete</button>"
                    + "               <input type='hidden' name='login' value=%s>"
                    + "            </form></td>"
                    + "        <td> <a href='%s/newuser03'>Create new user</a> </td>"
                    + "    </tr>", login, path, login, login, path, login, login, path));
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
