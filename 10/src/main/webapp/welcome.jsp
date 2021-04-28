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
                    <li class="nav-item active"><a href="#" class="nav-link text-uppercase font-weight-bold">Главная <span class="sr-only">(current)</span></a></li>
                    <li class="nav-item"><a href="#" class="nav-link text-uppercase font-weight-bold">?</a></li>
                </ul>
            </div>
        </div>
    </nav>
</header>
<div class="container" style="display: flex; flex-direction: row-reverse; margin-top: 100px;">

    <div class="container" align="center"  style="height:350px; width:400px; background-size: cover; background-image: url('https://i.ya-webdesign.com/images/note-paper-png-16.png');">
        <form action="add-servlet" method="post">
            <input type="hidden" value="Добавить">
        </form>
        <form action="add-servlet" method="post">
            <p class="navbar-brand text-uppercase font-weight-bold">Добавить новую запись</p>
            <p><label>
                <input type="text" name="name" value="" placeholder="Имя" class="form-control">
            </label></p>
            <p><label >
                <input type="text" name="phonenumber" value="" placeholder="Номер" class="form-control">
            </label></p>
            <p><label >
                <input type="text" name="email" value="" placeholder="Почта" class="form-control">
            </label></p>
            <p class="submit"><input type="submit" name="commit" value="Добавить" class="btn-warning"></p>
        </form>
    </div>
    <div>
    <table class="table table-bordered table-striped table-light">
        <tr><th>Имя</th><th>Телефон</th><th>Почта</th><th>Изменить</th></tr>
        <c:forEach var="record" items="${requestScope.recordList}">
            <tr>
                <td>${record.name}</td>
                <td>${record.phonenumber}</td>
                <td>${record.email}</td>
                <td>
                    <a href='<c:url value="/edit?name=${record.name}" />'>Изменить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
