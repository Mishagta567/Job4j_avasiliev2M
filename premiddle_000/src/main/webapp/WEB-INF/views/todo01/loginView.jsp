<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login page</title>
</head>
<body>

webapp/WEB-INF/views/todo01/login.jsp <br><br><br>


<% String err = request.getParameter("error"); %>


<c:if test="${error != ''}">
    <div style="background-color: red">
        <c:out value="${error}"></c:out>
    </div>
</c:if>
<br><br><br>

Login please (alex / 123 for example)<br><br><br>

<form action="${pageContext.servletContext.contextPath}/signin01" method="post">
    Login:  <input type="text" name="login">
    Password:<input type="password" name="password">
    <input type="submit">
</form>

</body>
</html>
