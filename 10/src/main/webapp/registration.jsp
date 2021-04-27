<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 27.04.2021
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="css/style.css">
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <title>Registration</title>
</head>
<body>
<section class="container">
    <div class="login">
        <h1>Registration</h1>
        <form method="post" action="register-servlet">
            <c:if test="${requestScope.message!=null}">
                <p style="color: red; vertical-align: center" >${requestScope.message}</p>
            </c:if>
            <p><label>
                <input type="text" name="login" value="" placeholder="Login">
            </label></p>
            <p><label>
                <input type="password" name="password" value="" placeholder="Password">
            </label></p>
            <p class="submit"><input type="submit" name="commit" value="Enter"></p>
        </form>
    </div>

    <div class="login-help">
        <a href="index.jsp">Already have an account?</a>
    </div>
</section>
</body>
</html>
