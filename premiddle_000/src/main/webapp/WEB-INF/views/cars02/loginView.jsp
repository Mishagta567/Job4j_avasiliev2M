<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

WEB-INF/views/cars02/loginView.jsp<br>

<% String error = request.getParameter("message"); %>
<c:if test="${error != ''}">
   <div style="background-color: red">
         ${error}
   </div>
</c:if><br><br>

<% String message = request.getParameter("message"); %>
<c:if test="${message != ''}">
   <h1>${message}</h1>
</c:if><br><br>

<br><br><br>

<form action="${pageContext.servletContext.contextPath}/signin02" method="post">
   Login:  <input type="text" name="login">
   Password:<input type="password" name="password">
   <input type="submit" value="Login">
</form>

</body>
</html>
