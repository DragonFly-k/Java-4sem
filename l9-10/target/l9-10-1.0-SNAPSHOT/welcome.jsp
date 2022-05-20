<%@ page import="java.time.LocalDate" %>
<%@ page import="com.example.l9_10.Components.List" %>
<%@ page import="com.example.l9_10.Components.Subject" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.l9_10.DB.ConnectorDb" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <style>
        table{
            border: 1px solid black;
            text-align: center;
            border-collapse: collapse;
        }
        td{
            border: 1px solid black;
            text-align: center;
            padding: 5px;
        }
        div > input{
            margin-top: 10px;
            display: inline-block;
        }
        .Info > input{
            margin-top: 10px;
            display: block;
        }
    </style>
</head>
<body>
<h1>Welcome ${username}</h1>
<p>role: ${role}</p>
<p>current date: <%= LocalDate.now() %></p>
<form action="AddServlet" method="get">
    <div class="Info">
        <h3>Refactor Form</h3>
        <input type="text" name="ID" placeholder="Enter id" />
        <input type="text" name="name" placeholder="Enter name" />
        <input type="text" name="course" placeholder="Enter course" />
        <input type="text" name="group" placeholder="Enter group" />
        <input type="submit" value="Add" />
    </div>
</form>

<h3>Students:</h3>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Course</td>
        <td>Group</td>
    </tr>
    <%
        try {
            ConnectorDb connectorDb = new ConnectorDb();
            List subjects = new List(connectorDb.getConnection("Users"));
            ArrayList<Subject> listChannel = subjects.getList();
            for (Subject subject : listChannel) {
    %>
    <tr>
        <td><%=subject.getAuditorium()%></td>
        <td><%=subject.getSubject()%></td>
        <td><%=subject.getTeacher()%></td>
        <td><%=subject.getGroup()%></td>
    </tr>
    <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
</table>
<a href="${pageContext.request.contextPath}/index.jsp">Выход</a>
</body>
</html>