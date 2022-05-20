<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
</h1>
<br/>
<form action="firstServlet" method="get">
    <input type="submit" value="getDate">
</form>
<a href="${pageContext.request.contextPath}/LoginPass.jsp">login Servlet</a>
</body>
</html>