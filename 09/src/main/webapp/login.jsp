<%--
  Created by IntelliJ IDEA.
  User: pasyagitka
  Date: 12.04.2021
  Time: 20:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logged in</title>
</head>
<body>
<%
    out.println("<h1>Привет, " + request.getAttribute("login") + "</h1>");
%>
<button onclick="location.href='index.jsp'">На главную</button>
</body>
</html>
