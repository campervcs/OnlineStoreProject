
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Group</title>
</head>
<body>
<%@include file="/views/index.html" %>
<%@include file="/views/header.jsp" %>
<div class="login-page">
    <div class="form">
        <form method="post" action="/CreateGroup">
            <label >Group name</label>
            <input type="text" name="groupName" class="somestyle" required />
            <input type="submit" value="Create" class="submit"/>
        </form>
    </div>
</div>
</body>
</html>