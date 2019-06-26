<html>
<head>
</head>
<body>
<%String projectId = (String) request.getAttribute("projectId");%>
<div class="body"></div>
<div class="grad"></div>
<div class="header">
    <div>Create<span>Task</span></div>
</div>
<div class="form">
    <form action="/task-manager/taskcreate" method="POST">
        projectId: <input type="text" name="projectId" value=<%=projectId%> autocomplete="off"/></br>
        Name: <input type="text" name="name" autocomplete="off"/></br>
        Description: <input type="text" name="description" autocomplete="off"/></br>
        Date: <input type="date" name="dateEnd" autocomplete="off"/></br>
        <input type="submit" value="Create"></br>
    </form>
</div>

</body>
</html>