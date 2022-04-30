<%--
  Created by IntelliJ IDEA.
  User: Andrei_Kuksa
  Date: 4/30/2022
  Time: 5:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Add project</title>
    <link href="static/css/styles.css" rel="stylesheet"/>
    <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
    />
</head>
<body>
<header class="bg-primary">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Конструкструкторское бюро <b class="text-danger">"Илон Маск"</b></a>
            </div>
            <ul class="nav navbar-nav">
                <li>
                    <a href="${pageContext.request.contextPath}/controller?commandName=order_project_page">Заказать проект</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controller?commandName=view_project">Просмотреть свои проекты</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/controller?commandName=view_workers">Просмотр работников</a>
                </li>
            </ul>
        </div>
    </nav>
</header>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>Welcome to admin page</h1>
</body>
</html>
