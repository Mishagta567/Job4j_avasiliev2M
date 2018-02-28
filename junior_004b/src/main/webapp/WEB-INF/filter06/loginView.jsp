<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

WEB-INF/filter06/loginView.jsp<br><br>

<c:if test="${error != ''}">
   <div style="background-color: red">
       <c:out value="${error}"></c:out>
   </div>
</c:if>

<br><br><br>

<form action="${pageContext.servletContext.contextPath}/signin06" method="post">
    Login:  <input type="text" name="login">
    Password:<input type="password" name="password">
    <input type="submit" value="Login">
</form>


</body>
</html>
