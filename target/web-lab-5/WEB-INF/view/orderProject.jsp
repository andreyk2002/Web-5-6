<%--
  Created by IntelliJ IDEA.
  User: Andrei_Kuksa
  Date: 4/23/2022
  Time: 3:40 PM
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
<body>
<jsp:include page="fragments/header.jsp"/>
<div class="p-4">
    <h1><fmt:message key="local.orderProject"/></h1>

    <div class="page-form">
        <form method="post" id="create-project-form" class="w-75" action="${pageContext.request.contextPath}/controller?commandName=order_project">
            <input required name="projectName" type="text"
                   placeholder="<fmt:message key="local.projectName"/>"/>
            <br/>
            <br/>
            <textarea class="film-description-admin film-input" rows="7" cols="55" name="projectDescription"
                      placeholder="<fmt:message key="local.projectDescription"/>"></textarea>
            <br/>
            <br/>
            <button type="submit" class="btn-primary"><fmt:message key="local.order"/></button>
        </form>
    </div>

    <a href="${pageContext.request.contextPath}/controller?commandName=main"><fmt:message key="local.toMain"/></a>

    <script src="../../static/js/script.js"></script>
</div>
</body>
</html>

