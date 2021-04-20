<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <title>Title</title>
</head>
<body>
<%
    out.println("<h1>" + request.getAttribute("time") + "</h1>");
    out.print("<h2>"+getServletInfo()+"</h2>");
%>
<br/>
<button onclick="location.href='index.jsp'">На главную</button>
<h1>Версия и номер протокола - ${p}</h1>
<h1>IP-адрес клиента - ${address}</h1>
<h1>Имя клиента - ${name}</h1>
<h1>Имя метода - ${requestType}</h1>
<h1>URL - ${requestURL}</h1>
<h1>headers - ${headers}</h1>

</body>
</html>
