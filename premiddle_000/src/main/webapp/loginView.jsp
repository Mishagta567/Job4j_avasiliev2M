<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

wabapp/loginView.jsp<br><br>

<% String error = request.getParameter("message"); %>
<c:if test="${error != ''}">
   <div style="background-color: red">
       ${error}
   </div><br><br>
</c:if>

<% String message = request.getParameter("message"); %>
<c:if test="${message != ''}">
   <h1>${message}</h1><br><br>
</c:if>

<form action="${pageContext.servletContext.contextPath}/signin02" method="post">
    Login:  <input type="text" name="login">
    Password:<input type="password" name="password">
    <input type="submit" value="Login">
   <a>
</form>


</body>
</html>
