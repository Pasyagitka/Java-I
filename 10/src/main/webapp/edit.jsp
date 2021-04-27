<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 27.04.2021
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">
    <input name="name" value="${med.name}" type="hidden" /><br><br>
    <label>Price</label><br>
    <input name="price" value="${med.price}" type="number" /><br><br>
    <label>ReleaseDate</label><br>
    <input name="date" value="${med.releaseData}" type="date"/><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
