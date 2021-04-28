<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<head>
    <title>09</title>
</head>
<body>
<form action = hello-servlet>
    <button>Узнать время</button>
</form>
<form action = Login>
    <label>Войти</label></br></br>
    <input name="login" type="text" placeholder="enter your login"></input>
    <input name="password" type="password" placeholder="*******"></input>
    <input type="submit"/>
</form>
<form action = registerServlet>
    <label>Зарегистрироваться</label></br></br>
    <input name="login" type="text" placeholder="enter your login"></input>
    <input name="password" type="password" placeholder="*******"></input>
    <input type="submit"/>
</form>
<br/>
<form action = cookieServlet>
    <input type="submit">Cookies</input>
</form>
<form action = FirstServlet method="get">
    <input type="submit">Первый сервлет GET</input>
</form>
<form action = FirstServlet method="post">
    <input type="submit">Первый сервлет POST</input>
</form>
<form>
    <input type="button" onclick="location.href='secondary.jsp'" value="Перейти"></input>
</form>
</body>
</html>