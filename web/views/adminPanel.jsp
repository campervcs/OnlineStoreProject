<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="../src/resources/css/stylesMain.css">
    <link rel="stylesheet" type="text/css" href="../src/resources/css/stylesForm.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="../src/resources/scripts/form.js"></script>
    <title>admin</title>
</head>
<body>
<%@include file="/views/index.html" %>
<div class="login-page">
    <div class="form">
        <form  method="get" action="/createProduct">
            <select name="productType" class="somestyle">
                <option selected value="Laptop">Laptop</option>
                <option value="Phone">Phone</option>
                <option value="Tablet">Tablet</option>
            </select>
            <input type="text" placeholder="Description" name="description" class="somestyle" required/>
            <input type="text" placeholder="Model" name="model" class="somestyle" required/>
            <input type="number" placeholder="Price" name="price" class="somestyle" required/>
            <input type="submit" value="create" class="submit"/>
        </form>
        </div>
    </div>
</body>
</html>