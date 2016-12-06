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
        <ul class="wrap-nav">
            <li><a href="#">About</a>
                <ul>
                    <li><a href="#">About Company</a></li>
                    <li><a href="#">Designers</a></li>
                    <li><a href="#">Developers</a></li>
                    <li><a href="#">Pets</a></li>
                </ul>
            </li>
            <li><a href="#">Services</a>
                <ul>
                    <li><a href="#">Web Design</a></li>
                    <li><a href="#">Development</a></li>
                    <li><a href="#">Apps</a></li>
                    <li><a href="#">Graphic design</a></li>
                    <li><a href="#">Branding</a></li>
                </ul>
            </li>
            <li><a href="#">Work</a>
                <ul>
                    <li><a href="#">Web</a></li>
                    <li><a href="#">Graphic</a></li>
                    <li><a href="#">Apps</a></li>
                </ul>
            </li>
        </ul>
        <div class="social">
            <a href="#">
                <div class="social-icon">
                    <i class="fa fa-facebook"></i>
                </div>
            </a>
            <a href="#">
                <div class="social-icon">
                    <i class="fa fa-twitter"></i>
                </div>
            </a>
            <a href="#">
                <div class="social-icon">
                    <i class="fa fa-codepen"></i>
                </div>
            </a>
            <a href="#">
                <div class="social-icon">
                    <i class="fa fa-behance"></i>
                </div>
            </a>
            <a href="#">
                <div class="social-icon">
                    <i class="fa fa-dribbble"></i>
                </div>
            </a>
        </div>
    </div>
</div>
<div class="content">

</div>
</body>
</html>