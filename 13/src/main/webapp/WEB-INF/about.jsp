<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 30.05.2021
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Main</title>
  <script src = "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
  <script src = "https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src = "js/welcome.js"></script>
  <link rel="stylesheet" href="css/mainpage.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<header class="header">
  <nav class="navbar navbar-expand-lg fixed-top py-3">
    <div class="container"><a href="#" class="navbar-brand text-uppercase font-weight-bold">Записная книжка</a>
      <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler navbar-toggler-right"><i class="fa fa-bars"></i></button>
      <div id="navbarSupportedContent" class="collapse navbar-collapse">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active"><a href="Controller?command=go_to_main_page" class="nav-link text-uppercase font-weight-bold">Главная <span class="sr-only">(current)</span></a></li>
          <li class="nav-item"><a href="Controller?command=go_to_about_page" class="nav-link text-uppercase font-weight-bold">?</a></li>
        </ul>
      </div>
    </div>
  </nav>
</header>
<div class="container" style="margin-top: 100px;">
  <h1>About...</h1>
</div>
</body>
</html>
