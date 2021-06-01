<%--Основные теги создания циклов, определения условий, вывода информации на страницу и т.д.--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--Теги для работы с XML-документами--%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<%-- Теги для работы с базами данных--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

<%--Теги для форматирования и интернационализации информации (i10n и i18n)--%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<%@ taglib prefix="t" uri="tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="x-UTF-16LE-BOM">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>12</title>
</head>
<body>
    <c:set var="user" scope="session" value="pasyagitka" />
    <c:out value="${user}" />
    <c:remove var="user" scope="session" />

    <c:set var="number" scope="session" value="${23}"/>
    <c:if test="${number > 20}">
        <p>Number = <c:out value="${number}"/><p>
    </c:if>

    <c:choose>
        <c:when test="${number < 22}">
            number < 22<br/>
        </c:when>
        <c:when test="${number > 24}">
            number > 24<br/>
        </c:when>
        <c:otherwise>
            otherwise<br/>
        </c:otherwise>
    </c:choose>

    <jsp:useBean id="Goods" class="meow.pasyagitka.model.Items"/>
    <c:set var="goods" value="${Goods}" />
    <c:set var="list"  value="${goods.itemsAsList}" />

    <c:forEach items="${list}" var="good">
        <c:out value="${good}"/>
    </c:forEach>

    <c:import url="import.jsp" />

    <h3>Formatting tags:</h3>

    <h3>Time Zone:</h3>
    <c:set var="date"  value="${goods.date}" />
    <f:formatDate value = "${date}" type = "both" timeStyle = "long" dateStyle = "long" />


    <c:set var = "balance" value = "120000.2309" />
    <h3>Number Format:</h3>
    <p>Formatted Number (1): <f:formatNumber value = "${balance}" type = "currency"/></p>
    <p>Formatted Number (2): <f:formatNumber type = "number" maxFractionDigits = "3" value = "${balance}" /></p>
    <p>Formatted Number (3): <f:formatNumber type = "percent" maxIntegerDigits="3" value = "${balance}" /></p>
    <p>Formatted Number (4): <f:formatNumber type = "number" pattern = "###.###E0" value = "${balance}" /></p>

    <h3>Number Parsing:</h3>
    <f:parseNumber var = "i" type = "number" value = "${balance}" />
    <p>Parsed Number (1) : <c:out value = "${i}" /></p>
    <f:parseNumber var = "i" integerOnly = "true" type = "number" value = "${balance}" />
    <p>Parsed Number (2) : <c:out value = "${i}" /></p>


    <f:requestEncoding value = "UTF-8" />
    <f:setLocale value = "es_ES"/>
    <f:setBundle basename = "com.tutorialspoint.Example" var = "lang"/> <%--Загружает пакет ресурсов--%>

   <sql:setDataSource var = "snapshot" driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"
                   url = "jdbc:sqlserver://localhost;database=Java10"
                   user = "JAVA"  password = "JAVA"/>
    <sql:query dataSource = "${snapshot}" sql = "select * from Records" var = "result" />

    <h3>XML tags</h3>
    <c:set var = "xmltext">
        <books>
            <book>
                <name>Name1</name>
                <author>author1</author>
                <price>100</price>
            </book>

            <book>
                <name>Name2</name>
                <author>author2</author>
                <price>200</price>
            </book>
        </books>
    </c:set>

    <x:parse xml = "${xmltext}" var = "output"/>
    <b>The title of the first book is</b>:
    <x:out select = "$output/books/book[1]/name" />
    <br>
    <b>The price of the second book</b>:
    <x:out select = "$output/books/book[2]/price" />
    <x:set var = "fragment" select = "$output/books/book[2]/price"/>
    <b>The price of the second book</b>:
    <c:out value = "${fragment}" />

    <x:if select = "$output//book">
        Document has at least one <book> element.
    </x:if>


    <h3>JSTL Functions</h3>
    <c:set var = "string" value = "This is String." />
    <p>Length of String : ${fn:length(string)}</p>

    <c:set var = "theString" value = "I am a test String"/>

    <c:if test = "${fn:contains(theString, 'test')}">
        <p>Found test string<p>
    </c:if>

    <c:set var = "string1" value = "This is first String."/>
    <c:set var = "string2" value = "${fn:split(string1, ' ')}" />
    <c:set var = "string3" value = "${fn:join(string2, '-')}" />

    <p>String (3) : ${string3}</p>

    <t:ZeiSubmit/>
    <t:ZeiPrintTable tableName="Records"/>
</body>
</html>
