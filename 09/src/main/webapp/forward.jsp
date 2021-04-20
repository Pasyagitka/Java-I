<%--
  Created by IntelliJ IDEA.
  User: pasyagitka
  Date: 20.04.2021
  Time: 0:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forward</title>
</head>
<body>
<%
    out.println("Forward.jsp: " + request.getAttribute("param") + request.getAttribute("message"));
%>
<br/>
<button onclick="location.href='index.jsp'">На главную</button>
</body>
</html>
