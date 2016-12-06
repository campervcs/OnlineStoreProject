<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin</title>
</head>
<body>
<%@include file="/views/index.html" %>
<%@include file="/views/header.jsp" %>
<div class="admin_nav">
    <p>
        <button class="btn btn-info" onclick="show_first_block()">add new product</button>
    </p>
    <p>
        <button class="btn btn-info" onclick="show_second_block()">show all users</button>
    </p>
</div>

<div class="admin_blocks" id="add_product">
    <div class="login-page">
        <div class="form">
            <form method="get" action="/createProduct">
                <select name="productType" class="somestyle">
                    <option selected value="Laptop">Laptop</option>
                    <option value="Phone">Phone</option>
                    <option value="Tablet">Tablet</option>
                </select>
                <input type="text" placeholder="Model" name="model" class="somestyle" required/>
                <input placeholder="Price" name="price" pattern="[0-9]{3,6}" class="somestyle" required/>
                <p>
                    <textarea class="form-control" placeholder="Description" name="description" rows="3"
                              required></textarea>
                </p>
                <input type="submit" value="create" class="submit"/>
            </form>
        </div>
    </div>
</div>
<div class="admin_blocks" id="show_users">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>First name</th>
            <th>Last name</th>
            <th>Mail</th>
            <th>Username</th>
            <th>Role</th>
            <th>Address</th>
            <th>Settings</th>
        </tr>
        </thead>
        <tbody>
        <% for (Customer user : (LinkedList<Customer>) request.getAttribute("USER_LIST")) {%>
        <tr>
            <td><%=user.getFname()%>
            </td>
            <td><%=user.getLname()%>
            </td>
            <td><%=user.getMail()%>
            </td>
            <td><%=user.getUsername()%>
            </td>
            <td><%=user.getRole().toString()%>
            </td>
            <td><%=user.getAdress()%>
            </td>
            <td>
                <div class="btn-group">
                    <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span
                            class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#"><i class="icon-pencil"></i> Редактировать</a></li>
                        <li><a href="#"><i class="icon-trash"></i> Удалить</a></li>
                        <li><a href="#"><i class="icon-ban-circle"></i> Запретить</a></li>
                        <li class="divider"></li>
                        <li><a href="#"><i class="i"></i> Назначить администратором</a></li>
                    </ul>
                </div>
            </td>
                <%}%>
        </tbody>
    </table>
</div>
</body>
</html>