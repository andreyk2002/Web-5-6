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
<%@taglib prefix="ctg" uri="customTags" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local"/>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Список задержанных рейсов</title>
    <link href="static/css/styles.css" rel="stylesheet"/>
    <link
            crossorigin="anonymous"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            rel="stylesheet"
    />
</head>
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="p-4">
    <h1 class="text-center"><fmt:message key="local.freeWorkers"/>Вывести свободных работников.</h1>

    <div class="page-form">
        <form id="delayed-races-form"></form>
    </div>

  <ctg:workerInfo workers="${workers}"/>
    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">ID</th>
                <th scope="col"><fmt:message key="local.name"/>Name</th>
                <th scope="col"><fmt:message key="local.surname"/>Surname</th>
                <th scope="col"><fmt:message key="local.qualification"/>Qualification</th>
                <th scope="col"><fmt:message key="local.salary"/>Salary</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${workers}" var="worker">
                <tr>
                    <th scope="col">${worker.id}</th>
                    <th scope="col">${worker.name}</th>
                    <th scope="col">${worker.surname}</th>
                    <th scope="col">${worker.qualification}</th>
                    <th scope="col">${worker.salary}</th>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="${pageContext.request.contextPath}/controller?commandName=main"><fmt:message key="local.toMain"/></a>
</div>

<script src="../../static/js/script.js"></script>
</body>
</html>

