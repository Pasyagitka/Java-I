<%--
  Created by IntelliJ IDEA.
  User: Professional
  Date: 27.04.2021
  Time: 19:14
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
    <link rel="stylesheet" href="css/welcome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>

<header class="header">
    <nav class="navbar navbar-expand-lg fixed-top py-3">
        <div class="container"><a href="#" class="navbar-brand text-uppercase font-weight-bold">Main page</a>
            <button type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation" class="navbar-toggler navbar-toggler-right"><i class="fa fa-bars"></i></button>

            <div id="navbarSupportedContent" class="collapse navbar-collapse">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item active"><a href="#" class="nav-link text-uppercase font-weight-bold">Home <span class="sr-only">(current)</span></a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">About</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">Gallery</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">Portfolio</a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">Contact</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>

<div style="margin-top: 100px" class="container">

    <table class="table table-striped-table-bordered">
        <tr><th>Name</th><th>Price</th><th>releaseData</th></tr>
        <c:forEach var="med" items="${requestScope.meds}">
            <tr>
                <td>${med.name}</td>
                <td>${med.price}</td>
                <td>${med.releaseData}</td>
                <td>
                    <a href='<c:url value="/edit?name=${med.name}" />'>Edit</a>
                </td>
            </tr>
        </c:forEach>
    </table
    <form action="add-servlet" method="post">

        <p class="submit"><input type="submit" name="commit" value="Add"></p>
    </form>
    <form action="add-servlet" method="post">
        <p><label >
            <input type="text" name="name" value="" placeholder="Name">
        </label></p>
        <p><label >
            <input type="text" name="price" value="" placeholder="Price">
        </label></p>
        <p><lavle>
            <input type="date" name="date" value="">
        </lavle></p>
        <p class="submit"><input type="submit" name="commit" value="Add"></p>
    </form>
</div>
</body>
</html>
