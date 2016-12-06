<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>OnlineStore</title>
  </head>
  <body>
  <%@include file="/views/index.html" %>
  <div class="login-page">
    <div class="form">
      <form class="register-form" method="post" action="/register">
        <input type="text" placeholder="first name" name="fname" class="somestyle" required/>
        <input type="text" placeholder="last name" name="lname" class="somestyle" required/>
        <input type="text" placeholder="address" name="adress" class="somestyle" required/>
        <input type="text" placeholder="login" name="username" class="somestyle" required/>
        <input type="password" placeholder="password" name="password" class="somestyle" required/>
        <input type="email" placeholder="email address" name="mail" class="somestyle" required/>
        <input type="submit" value="create" class="submit"/>
        <p class="message">Already registered? <a href="#">Sign In</a></p>
      </form>
      <form class="login-form" method="post" action="/login">
        <input type="text" placeholder="username" name="username" class="somestyle" required/>
        <input type="password" placeholder="password" name="password" class="somestyle" required/>
        <input type="submit" value="login" class="submit"/>
        <p class="message">Not registered? <a href="#">Create an account</a></p>
      </form>
    </div>
  </div>
  </body>
</html>
