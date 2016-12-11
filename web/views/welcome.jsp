<%@ page import="models.product.Product" %>
<%@ page import="java.util.LinkedList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>OnlineStore</title>
</head>
<body>
<%@include file="/views/index.html" %>
<%@include file="/views/header.jsp" %>
<div class="product_list">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Model</th>
            <th>Description</th>
            <th>Type</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Product product : (LinkedList<Product>) request.getAttribute("PRODUCT_LIST")) {%>
        <tr>
            <td><%=product.getModel()%>
            </td>
            <td><%=product.getDescription()%>
            </td>
            <td><%=product.getType().toString()%>
            </td>
            <td><%=product.getPrice()%>
            </td>
            <td>
                <div class="btn-group">
                    <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#"><span
                            class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><button type="submit" class="btn btn-primary btn-xs">Купить</button></li>
                        <form class="cart" method="get" action="/cart">
                            <input type="hidden" name="ProductId" value="<%=product.getId()%>" >
                        <li><button type="submit" class="btn btn-primary btn-xs">В корзину</button></li>
                        </form>
                        <%if (((Customer) session.getAttribute("LOGIN_USER")).getRole().toString().equals("admin")) {%>
                        <li><button type="submit" class="btn btn-primary btn-xs">Удалить</button></li>
                        <li><button type="submit" class="btn btn-primary btn-xs">Редактировать</button></li>
                        <%}%>
                    </ul>
                </div>
            </td>
                <%}%>
        </tbody>
    </table>
</div>
</body>
</html>
