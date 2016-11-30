<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="../src/resources/css/stylesMain.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/normalize/3.0.2/normalize.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="../src/resources/scripts/mainPage.js"></script>
    <title>OnlineStore</title>
</head>
<body>
<%@include file="/views/index.html" %>
<nav>
    <ul>
        <li><a href="#">About</a></li>
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
                    <li><a href="https://www.google.hr/">Web Design</a></li>
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
            <a href="http://mario-loncarek.from.hr/">
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
