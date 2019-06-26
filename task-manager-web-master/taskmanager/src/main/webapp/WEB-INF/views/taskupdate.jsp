<%@ page import="ru.anikanov.tmweb.entity.Task" %>
<html>
<head>
</head>
<body>
<% Task task = (Task) request.getAttribute("task"); %>
<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>Update<span>Task</span></div>
</div>
<div class="form">
    <form action="/task-manager/taskupdate" method="POST">
        Id: <input type="text" name="id" value=<%=task.getId()%> autocomplete="on"/></br>
        Name: <input type="text" name="name" value=<%=task.getName()%> autocomplete="on"/></br>
        Description: <input type="text" name="description" value=<%=task.getDescription()%> autocomplete="on"/></br>
        Date: <input type="date" name="dateEnd" value=<%=task.getDateEnd()%> autocomplete="on"/></br>
        <input type="submit" value="Update"></br>
    </form>
</div>
</body>
</html>