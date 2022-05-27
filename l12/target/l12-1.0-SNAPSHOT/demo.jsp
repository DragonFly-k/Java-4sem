<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.05.2022
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="SED" uri="l12" %>
<html>

<head>
    <style>
        table {
            border-collapse:collapse;
        }
    </style>
    <title>L12</title>
</head>
<body>
<jsp:useBean id="now" class="java.util.Date"/>

<p><c:out value="JSTL подключена"/></p>

<fmt:setLocale value="ru-RU"/>
<p>Вывод даты в формате Russian<br/>
    Сегодня: <fmt:formatDate value="${now}"/></p>

<p>Беларусская валюта :
    <fmt:setLocale value="be-BY"/>
    <fmt:formatNumber value="100" type="currency"/><br/>
</p>

<p>Количество символов в строке "Сятковская Екатерина Дмитриевна" = ${fn:length('Сятковская Екатерина Дмитриевна')}</p>

<div><h4>Пользовательские теги</h4>
    <SED:auth/>
    <c:set var = "items" value = "${items}"/>
    <c:set var = "iter" value = "${items.iterator()}"/>

    <SED:table nameTable="Таблица" countItem="${fn:length(items)}">
        <c:out value="${iter.next()}"/>
    </SED:table>
</div>
</body>
</html>
