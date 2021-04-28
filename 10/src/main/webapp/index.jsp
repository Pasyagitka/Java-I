<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="stylesheet" href="css/2.css">
    <script src = "https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <link rel="apple-touch-icon" type="image/png" href="https://cpwebassets.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png" />
    <meta name="apple-mobile-web-app-title" content="CodePen">
    <link rel="shortcut icon" type="image/x-icon" href="https://cpwebassets.codepen.io/assets/favicon/favicon-aec34940fbc1a6e787974dcd360f2c6b63348d4b1f4e06c77743096d55480f33.ico" />
    <link rel="mask-icon" type="" href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg" color="#111" />
    <meta charset="utf-8">
    <title>Login</title>
</head>
<body>
<div id="login">
    <form id="login_form" method="post" action="logging-servlet">
        <div class="field_container">
            <label><h2>Login</h2></label>
        </div>
        <c:if test="${requestScope.message!=null}"><p>${requestScope.message}</p></c:if>
        <div class="field_container">
            <input type="text" name="login" placeholder="Login">
        </div>
        <div class="field_container">
            <input type="Password" placeholder="Password" name="password">
                <input type="submit"  name="commit" value="Enter" class="btn-success">
        </div>
        <div class="dont_have_an_account">
            <a href="registration.jsp">Do not have an account?</a>
        </div>
    </form>
    </div>
</div>
</body>
</html>
