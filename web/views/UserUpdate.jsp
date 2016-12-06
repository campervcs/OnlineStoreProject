<%@ page import="models.customer.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserUpdate</title>
</head>
<body>
<%@include file="/views/index.html" %>
<%@include file="/views/header.jsp" %>
<div class="login-page">
    <div class="form">
<form method="post" action="/update">
    <label >first name</label>
    <input type="text" value="<%=((Customer)request.getAttribute("user")).getFname()%>" name="fname" class="somestyle" required />
    <label>last name</label>
    <input type="text" value="<%=((Customer)request.getAttribute("user")).getLname()%>" name="lname" class="somestyle" required />
    <label>address</label>
    <input type="text" value="<%=((Customer)request.getAttribute("user")).getAdress()%>" name="adress" class="somestyle" required />
    <label>password</label>
    <input type="password" value="<%=((Customer)request.getAttribute("user")).getPassword()%>" name="password" class="somestyle" required/>
    <input type="submit" value="update" class="submit"/>
</form>
    </div>
</div>
</body>
</html>
