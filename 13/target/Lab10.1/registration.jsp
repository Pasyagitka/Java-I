<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="css/2.css">
    <script src = "https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <link rel="shortcut icon" href="http://vladmaxi.net/favicon.ico" type="image/x-icon">
    <title>Registration</title>
</head>
<body>
<div id="login">
    <form id="login_form" method="post" action="register-servlet">
        <div class="field_container">
            <label><h2>Register</h2></label>
        </div>
        <c:if test="${requestScope.message!=null}"><p>${requestScope.message}</p></c:if>
        <div class="field_container">
            <input type="text" name="login" placeholder="Login">
        </div>
        <div class="field_container">
            <input type="Password" placeholder="Password" name="password">
            <input type="submit"  name="commit" value="Enter" class="btn-success">
        </div>
    </form>
</div>
</div>
</body>
</html>
