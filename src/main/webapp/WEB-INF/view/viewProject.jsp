<%--
  Created by IntelliJ IDEA.
  User: Andrei_Kuksa
  Date: 4/23/2022
  Time: 3:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>View projects</title>
    <link href="static/css/styles.css" rel="stylesheet"/>
    <link
            crossorigin="anonymous"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            rel="stylesheet"
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
<div class="wrapper text-center">
    <h1>Ваши проекты</h1>

    <div class="page-form">
        <form id="all-races-form"></form>
    </div>

    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col">Project Description</th>
                <th scope="col">Name</th>
                <th scope="col">Paid</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${projects}" var="project">
                <tr>
                    <th scope="col">${project.id}</th>
                    <th scope="col">${project.projectDescription}</th>
                    <th scope="col">${project.projectName}</th>
                    <th scope="col">${project.paidByCustomer}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="${pageContext.request.contextPath}/controller?commandName=main"> На главную</a>
</div>

<script src="../../static/js/script.js"></script>
</body>
</html>
