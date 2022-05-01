<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.04.2022
  Time: 19:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<html>
<head>
    <title>Useer</title>
</head>
<body>
<h2>Hello, ${login}</h2>
<p>Role ${role}</p>
<p>
    <%
        Date date = new Date();
        response.addCookie(new Cookie("date", date.toString()));
    %>
    <%= date %>
</p>
<a href="logout">Выход</a>
</body>
</html>
