<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 22.02.2018
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

Page webapp/WEB-INF/filter06/notAdmin.jsp <br/><br/><br/>

You are not admin, you can't change other people records <br><br><br>

Можете выйти и авторизоваться вторично:

    <form action='<%= request.getContextPath()%>/signout06' method='post'>
        <input type="submit" value="SignOut">
    </form>

</body>
</html>
