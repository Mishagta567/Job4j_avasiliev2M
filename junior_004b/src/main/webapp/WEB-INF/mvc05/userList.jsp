<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.job4j.servlet03.UserStore03" %>
<%@ page import="ru.job4j.crud02.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Page webapp/WEB-INF/mvc05/userList.jsp<br/><br/>

<% final UserStore03 userStore = UserStore03.SingletonEnum.INSTANCE.getInstance(); %>

<table>
    <c:forEach items="<%=userStore.getAllUsers()%>" var="user00">
    <tr>
        <td><c:out value="${user00.login}"></c:out></td>
        <td><form action="<c:out value="${pageContext.request.contextPath}"></c:out>/edit03?login='<c:out value="${user00.login}"></c:out>" method='get'>
               <input type="submit" value="Edit">
               <input type='hidden' name='login' value='<c:out value="${user00.login}"></c:out>'></form>
        </td>
        <td><form action="<c:out value="${pageContext.request.contextPath}"></c:out>/delete03?login=<c:out value="${user00.login}"></c:out>" method='post'>
               <input type="submit" value="Delete">
               <input type='hidden' name='login' value='<c:out value="${user00.login}"></c:out>'></form>
        </td>
        <td>
           <a href="${pageContext.request.contextPath}/newuser03">Create new user00</a>
        </td>
    </tr>
    </c:forEach>

</table>




</body>
</html>
