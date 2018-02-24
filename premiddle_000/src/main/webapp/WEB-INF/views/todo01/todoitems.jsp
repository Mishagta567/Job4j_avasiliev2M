<%@ page import="ru.job4j.todo01.AllTodoItems" %>
<%@ page import="ru.job4j.todo01.TodoItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Items to do</title>
    <!-- bootstrap -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

webapp/WEB-INF/views/todo01/todoitems.jsp <br><br><br>

<% AllTodoItems allTodoItems = new AllTodoItems();
   List<TodoItem> allItems = allTodoItems.getAllItems();
%>

<table border="1" cellspacing="5">
        <tr>
            <td>ID</td>
            <td>Description</td>
            <td>Created</td>
            <td>Done</td>
        </tr>
    <% for (TodoItem todoItem : allItems) { %>
        <tr>
            <td><%=todoItem.getId()%></td>
            <td><%=todoItem.getDescr()%></td>
            <td><%=todoItem.getCreated()%></td>
            <td><input id="done" type="checkbox" value="<%=todoItem.getDone()%>" name="done"
                    <%if (todoItem.getDone()) { %>
                       checked
                    <%} %>
            </td>
        </tr>
    <% } %>
</table>

<br> Create new one: <br>
<table border="1" cellspacing="4">
    <tr>
        <td>Description</td>
        <td></td>
    </tr>
    <tr><form action='todoinsert01' method='post'>
            <td><input type='text' name='descr' value=''></td>
            <td><button>Create</button></td>
        </form>
    </tr>
</table><br><br>

<div class="container">
    <h2>Add new task</h2>
    <p>Добавыить новую задачу (bootstrap)</p>
    <form class="form-inline" action="todoinsert01" method="post">
        <div class="form-group">
            <label for="descr">Description:</label>
            <input type="text" class="form-control" id="descr" placeholder="Enter ew task" name="descr">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
    </form>
</div>



</body>
</html>
