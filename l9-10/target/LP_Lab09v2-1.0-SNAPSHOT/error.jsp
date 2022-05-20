<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<h3>Error:${pageContext.errorData.statusCode}</h3>
<h4>${pageContext.exception}</h4>
<a href="${pageContext.request.contextPath}/index.jsp">Выход</a>
</body>
</html>
