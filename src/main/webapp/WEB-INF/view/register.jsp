<%--
  Created by IntelliJ IDEA.
  User: Andrei_Kuksa
  Date: 4/30/2022
  Time: 5:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local"/>
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
<html>
<head>
    <title>Title</title>
</head>
<body class="mt-5">
<h1 class="text-center"><fmt:message key="local.user_registration"/></h1>
<div class="page-form">
    <form method="post" id="create-project-form" class="w-75 ml-5" action="${pageContext.request.contextPath}/controller?commandName=register">
        <input required name="username" type="text"
               placeholder="<fmt:message key="local.your_username"/>"/>
        <br/>
        <br/>
        <input required name="password" type="password"
               placeholder="<fmt:message key="local.your_password"/>"/>
        <br/>
        <br/>
        <button type="submit" class="btn-primary"><fmt:message key="local.register"/></button>
    </form>
</div>
</body>
</html>
