<%@ page import="ru.job4j.crud02.UserStore" %>
<%@ page import="ru.job4j.crud02.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Page webapp/userList.jsp<br/><br/>

<% final UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();
    String path = request.getContextPath();
    List<String> allLogins = userStore.getAlllogins(); %>

<table>
    <% for (String login : allLogins) { %>
    <tr>
        <td><%=login %></td>
        <td><form action='/j004b/edit03?login=<%=login %>' method='get'><button>Edit</button>
               <input type='hidden' name='login' value='<%=login %>'>
            </form></td>
        <td><form action='/j004b/delete03?login=<%=login %>' method='post'><button>Delete</button>
               <input type='hidden' name='login' value='<%=login %>'>
            </form></td>
        <td>
           <a href='/j004b/newuser03'>Create new user</a>
        </td>
    </tr>
    <% } %>

</table>




</body>
</html>
