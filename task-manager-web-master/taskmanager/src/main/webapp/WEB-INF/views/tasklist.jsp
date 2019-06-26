<%@ page import="ru.anikanov.tmweb.entity.Task" %>
<%@ page import="java.util.List" %>
<html>
<head>
</head>
<body>
<table class="rwd-table">
    <th>Number</th>
    <th>ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>DateBegin</th>
    <th>DateEnd</th>
    <% int index = 1; %>
    <% for (Task task : (List<Task>) request.getAttribute("tasks")) { %>
    <tr>
        <td align="center"><%= index %>
        </td>
        <td align="left"><%= task.getId() %>
        </td>
        <td align="left"><%= task.getName() %>
        </td>
        <td align="left"><%= task.getDescription() %>
        </td>
        <td align="left"><%= task.getDateBegin() %>
        </td>
        <td align="left"><%= task.getDateEnd() %>
        </td>
        <td align="left"><a href="/task-manager/taskremove?id=<%=task.getId()%>"> Remove</td>
        <td align="left"><a href="/task-manager/taskupdate?id=<%=task.getId()%>"> Update</td>
    </tr>
    <% index++; %>
    <% } %>
</table>
<form action="/task-manager/projectlist" method="GET">
    <button>Project List</button>
</form>
<%String projectId = (String) request.getAttribute("projectId");%>
<h1>id: <%=projectId%>
</h1>
<h2><a href="/task-manager/taskcreate?id=<%=projectId%>">Create Task</h2>
</body>
</html>
