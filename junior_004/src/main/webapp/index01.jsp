<%@ page import="ru.job4j.crud02.UserStore" %>
<%@ page import="java.util.Queue" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.job4j.crud02.UserCS" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Страница webapp/index.jsp<br/>

<% final UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();
    String path = request.getContextPath();
    Queue<String> allLogins = userStore.getAllUsers(); %>

<table>
    <% for (String login : allLogins) { %>
    <tr>
        <td><%=login %></td>
        <td><form action='/items/edit03?login=<%=login %>' method='get'><button>Edit</button>
               <input type='hidden' name='login' value='<%=login %>'>
            </form></td>
        <td><form action='/items/delete03?login=<%=login %>' method='post'><button>Delete</button>
               <input type='hidden' name='login' value='<%=login %>'>
            </form></td>
        <td>
           <a href='/items/newuser03'>Create new user01</a>
        </td>
    </tr>
    <% } %>

</table>




</body>
</html>
