<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.04.2022
  Time: 19:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<p>${info}</p>
<form action="auth" method="post">
    <input type="text" name="login" placeholder="login">
    <br><br>
    <input type="password" name="password" placeholder="password">
    <br><br>
    <input type="submit" value="Sign in">
</form>
<a href="registration.jsp">Выход</a>
<br>
<a href='/l9-1.0-SNAPSHOT'>Назад</a>
</body>
</html>
