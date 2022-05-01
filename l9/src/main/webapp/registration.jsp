<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.04.2022
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<p>${info}</p>
<form action="registration" method="post">
    <input type="text" name="login" placeholder="login">
    <br><br>
    <input type="password" name="password" placeholder="password">
    <br><br>
    <input type="submit" value="Create account">
</form>
<a href="login.jsp">Вход</a>
<br>
<a href='/l9-1.0-SNAPSHOT'>Назад</a>
</body>
</html>
