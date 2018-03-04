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

webapp/WEB-INF/views/todo01/todoitems.jsp <br><br>

<% AllTodoItems allTodoItems = new AllTodoItems();
   List<TodoItem> allItems = allTodoItems.getAllItems();
%>

<div class="container">
   <h2>Need to do</h2>
   <p>Tale use Bootstrap CSS Tables Reference:</p>
   <div class="table-responsive">
      <table class="table">
         <thead>
            <tr>
                <td>ID</td>
                <td>Description</td>
                <td>Created</td>
                <td>Done</td>
            </tr>
         </thead>
         <tbody>
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
         </tbody>
</table>
   <br><br><br>
<table border="1" cellspacing="4">
   <h2>Add new task</h2>
   <thead>
      <tr>
         <td>Description</td>
         <td></td>
      </tr>
   </thead>
   <tbody>
      <tr><form action='todoinsert01' method='post'>
             <td><input type='text' name='descr' value=''></td>
             <td><button>Create</button></td>
          </form>
      </tr>
   </tbody>
</table><br><br>
</div>

</body>
</html>
