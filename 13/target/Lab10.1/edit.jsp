<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src = "https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="stylesheet" href="css/2.css">
    <title>Редактировать запись</title>
</head>
<body>
<h3>Редактировать запись</h3>
<form method="post">
    <label>Номер телефона</label><br>
    <input name="phonenumber" value="${record.phonenumber}" type="text" /><br><br>
    <label>Почта</label><br>
    <input name="email" value="${record.email}" type="text"/><br><br>
    <input type="submit" value="Send" class="btn-success"/>
</form>
</body>
</html>
