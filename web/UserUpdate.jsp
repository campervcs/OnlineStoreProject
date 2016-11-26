<%@ page import="models.customer.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="src/resources/css/stylesMain.css">
    <link rel="stylesheet" type="text/css" href="src/resources/css/stylesForm.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="src/resources/scripts/form.js"></script>
    <title>UserUpdate</title>
</head>
<body>
<%@include file="/index.html" %>
<div class="login-page">
    <div class="form">
<form method="post" action="/update">
    <label>first name</label>
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
