<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local"/>
<html>
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
<div class="error-wrapper">
    <h2 class="error-header text-center">
        ${requestScope.errorMessage}"
    </h2>
</div>
</body>
</html>
