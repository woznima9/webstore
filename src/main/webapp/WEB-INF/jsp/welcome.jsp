<%--
  Created by IntelliJ IDEA.
  User: Komp
  Date: 2018-08-06
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Witaj</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>${greeting}</h1>
            <p>${tagline}</p>
        </div>
    </div>
</section>


</body>
</html>
