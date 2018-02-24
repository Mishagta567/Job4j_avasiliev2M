<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="ru.job4j.filter06.UserStore06" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

Page webapp/WEB-INF/filter06/userList.jsp<br/><br/>

<% final UserStore06 userStore = UserStore06.SingletonEnum.INSTANCE.getInstance(); %>

<table>

    <tr>
            <td>ID:</td>
            <td>Login: </td>
            <td>Password: </td>
            <td>Name: </td>
            <td>Email: </td>
            <td>InsertedDate: </td>
            <td>Role Id: </td>
            <td>Role Name: </td>
            <td></td>
            <td></td>
    </tr>

    <c:forEach items="<%=userStore.getAllUsers()%>" var="user01">
        <tr>
            <%--<form action='<%= request.getContextPath()%>/editUser06' method='post'>--%>
            <form action="<c:out value="${pageContext.request.contextPath}"></c:out>/editUser06" method='post'>
                <td>${user01.id}<input type="hidden" name="id" value='${user01.id}'></td>
                <td><input type="text" name="login" value='${user01.login}'></td>
                <td><input type="text" name="password" value='${user01.password}'></td>
                <td><input type="text" name="name" value='${user01.name}'></td>
                <td><input type="text" name="email" value='${user01.email}'></td>
                <td>${user01.insertedDate}</td>
                <td><input type="text" name="roleId" value='${user01.roleId}'></td>
                <td>${user01.roleName}</td>
                <td><input type="submit" value="Save"></td>
            </form>
            <form action="<c:out value="${pageContext.request.contextPath}"></c:out>/editUser06?login=${user01.login}&&id=${user01.id}" method='get'>
                <input type='hidden' name='login' value='${user01.login}'>
                <input type='hidden' name='id' value='${user01.id}'>
                <td><input type="submit" value="Delete"></td>
            </form>
        </tr>
    </c:forEach>
    <tr>
        <td>.</td>
    </tr>
    <tr>
        <form action="<c:out value="${pageContext.request.contextPath}"></c:out>/insertUser06" method='post'>
            <td></td>
            <td><input type="text" name="login" value=''></td>
            <td><input type="password" name="password" value=''></td>
            <td><input type="text" name="name" value=''></td>
            <td><input type="text" name="email" value=''></td>
            <td></td>
            <td><input type="text" name="roleId" value=''></td>
            <td><input type="submit" value="New"></td>
            <td></td>
            <td></td>
        </form>
    </tr>
</table><br>


    <br><br><br><br>

<table>
        <tr>
            <td>ID</td>
            <td>Role name</td>
            <td></td>
            <td></td>
        </tr>

    <c:forEach items="<%=userStore.getAllRoles()%>" var="role">
        <tr>
            <form action="<c:out value="${pageContext.request.contextPath}"></c:out>/editRole06" method='post'>
                <td>ID: ${role.id}<input type="hidden" value="${role.id}" name="roleid"></td>
                <td><input type="text" value="${role.role}" name="role"></td>
                <td><input type="submit" value="Save"></td>>
            </form>
            <form action="<c:out value="${pageContext.request.contextPath}"></c:out>/editRole06" method='get'>
                <input type='hidden' name='id' value='${role.id}'>
                <input type='hidden' name='role' value='${role.role}'>
                 <td><input type="submit" value="Delete"></td>>
             </form>
        </tr>
    </c:forEach>
</table>

<br><br>

    <form action="<c:out value="${pageContext.request.contextPath}"></c:out>/insertRole06" method='post'>
        <input type="text" name="role" value="">
        <input type="submit" value="New Role">
    </form>


</body>
</html>
