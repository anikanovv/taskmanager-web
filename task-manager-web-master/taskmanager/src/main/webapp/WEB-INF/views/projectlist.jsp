<%@ page import="ru.anikanov.tmweb.entity.Project" %>
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
    <% for (Project project : (List<Project>) request.getAttribute("projects")) { %>
    <tr>
        <td align="center"><%= index %>
        </td>
        <td align="left"><%= project.getId() %>
        </td>
        <td align="left"><%= project.getName() %>
        </td>
        <td align="left"><%= project.getDescription() %>
        </td>
        <td align="left"><%= project.getDateBegin() %>
        </td>
        <td align="left"><%= project.getDateEnd() %>
        </td>
        <td align="left"><a href="/task-manager/tasklist?projectId=<%=project.getId()%>"> Tasks</td>
        <td align="left"><a href="/task-manager/projectremove?projectId=<%=project.getId()%>"> Remove</td>
        <td align="left"><a href="/task-manager/projectupdate?projectId=<%=project.getId()%>"> Update</td>
    </tr>
    <% index++; %>
    <% } %>

</table>
<form action="/task-manager/projectcreate" method="GET">
    <button>Create Project</button>
</form>
<form action="/task-manager/endsession" method="GET">
    <button>Session end Project</button>
</form>

</body>
</html>
