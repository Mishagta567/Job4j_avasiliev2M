<%@ page import="ru.job4j.crud02.UserStore" %>
<%@ page import="java.util.Queue" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="ru.job4j.crud02.UserCS" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>

<body>
Страница UsersView.jsp в корне<br/><br/>


<% final UserStore userStore = UserStore.SingletonEnum.INSTANCE.getInstance();
    //String path = request.getContextPath();
    //List<UserCS> allLogins = (List<UserCS>) userStore.getAllUsersCS();  %>

<table>

    <c:forEach items="<%=userStore.getAllUsers()%>" var="user">

        <tr>
            <% // td>${user}<!--c:out value="${user.getLogin()}"></c:out> </td %>

            <td><c:out value="${user}"></c:out></td>
            <td><form action='/items/edit03?login=${user}' method='get'><button>Edit</button>
                <input type='hidden' name='login' value='${user}'></form>
            </td>
            <td><form action='/items/delete03?login=${user}' method='post'><button>Delete</button>
                <input type='hidden' name='login' value='${user}'></form>
            </td>
            <td>
                <a href='/items/newuser03'>Create new user</a>
            </td>
        </tr>

    </c:forEach>>

</table>
</body>
</html>
