<%@ page import="ru.anikanov.tmweb.entity.Project" %>
<html>
<head>
</head>
<body>
<% Project project = (Project) request.getAttribute("project"); %>
<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>Update<span>Project</span></div>
</div>
<div class="form">
    <form action="/task-manager/projectupdate" method="POST">
        Id: <input type="text" name="id" value=<%=project.getId()%> autocomplete="on"/></br>
        Name: <input type="text" name="name" value=<%=project.getName()%> autocomplete="on"/></br>
        Description: <input type="text" name="description" value=<%=project.getDescription()%> autocomplete="on"/></br>
        Date: <input type="date" name="dateEnd" value=<%=project.getDateEnd()%> autocomplete="on"/></br>
        <input type="submit" value="Update"></br>
    </form>
</div>
</body>
</html>