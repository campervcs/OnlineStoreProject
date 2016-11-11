<%@ page import="model.customer.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <link rel="stylesheet" type="text/css" href="src/resource/css/stylesMain.css">
    <link rel="stylesheet" type="text/css" href="src/resource/css/stylesForm.css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

    <script src="src/resource/scripts/form.js"></script>
    <title>OnlineStore</title>
  </head>
  <body>
  <div class="cloud cloud1">
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>

  <div class="cloud cloud2">
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>

  <div class="sign">OPEN</div>
  <div class="store_roof">
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
    </ul>
  </div>
  <div class="store_roof_opening"></div>
  <div class="store_window"></div>
  <div class="store_door"></div>
  <div class="store_sign">MYSTORE</div>
  <div class="store_frame_shadow"></div>
  <div class="store_frame"></div>
  <div class="store_inner_wall"></div>
  <div class="store_wall"></div>
  <div class="store_floor"></div>
  <div class="kerb"><div class="left"></div><div class="right"></div></div>
  <div class="road"></div>
  <div class="floor"></div>

  <div class="login-page">
    <div class="form">
      <form class="register-form" action="controller.UserControllerServlet">
        <input type="text" placeholder="name" class="somestyle"/>
        <input type="password" placeholder="password" class="somestyle"/>
        <input type="text" placeholder="email address" class="somestyle"/>
        <input type="submit" value="create" class="submit"/>
        <p class="message">Already registered? <a href="#">Sign In</a></p>
      </form>
      <form class="login-form" action="controller.UserControllerServlet">
        <input type="text" placeholder="username" class="somestyle"/>
        <input type="password" placeholder="password" class="somestyle"/>
        <input type="submit" value="login" class="submit"/>
        <p class="message">Not registered? <a href="#">Create an account</a></p>
      </form>
    </div>
  </div>
  </body>
</html>
