<%@ page import="models.customer.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>header</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="/myStore">Home</a></li>
        <li><a href="/CreateGroup">Create Group</a></li>
        <%if (((Customer)session.getAttribute("LOGIN_USER")).getRole().toString().equals("admin")) {%>
            <li ><a href = "/AdminPanel" > AdminPanel </a ></li >
        <%}%>
        <li><a href="/update">Profile</a></li>
        <li><a href="/logout">logout</a></li>
    </ul>
    <div class="button">
        <a class="btn-open" href="#"></a>
    </div>
</nav>
<div class="overlay">
    <div class="wrap">

        <div class="social">

        </div>
    </div>
</div>
<div class="content">

</div>
</body>
</html>