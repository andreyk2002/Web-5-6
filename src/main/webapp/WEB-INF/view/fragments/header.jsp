<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 5/16/2022
  Time: 5:54 PM
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
  <title>Список задержанных рейсов</title>
  <link href="../static/css/styles.css" rel="stylesheet"/>
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
        <a class="navbar-brand" href="#"><fmt:message key="local.constructor_agency"/> <b
          class="text-danger"><fmt:message key="local.ilon_musk"/></b></a>
      </div>
      <div class="languages" style="display: flex;justify-content: space-between;">
        <form class="change-lang" action="${pageContext.request.contextPath}/controller"
              method="post">
          <input class="change-lang-btn" type="submit" value="ru"/>
          <c:if test="${empty param.get('commandName')}">
            <input type="hidden" name="commandName" value="loginPage"/>
          </c:if>
          <c:if test="${not empty param.get('commandName')}">
            <input type="hidden" name="commandName" value="${param.get("commandName")}"/>
          </c:if>
          <input type="hidden" name="local" value="ru_RU"/>
          <c:forEach var="input" items="${param.entrySet()}">
            <input type="hidden" name="${input.getKey()}" value="${input.getValue()}"/>
          </c:forEach>
        </form>

        <form class="change-lang" action="${pageContext.request.contextPath}/controller"
              method="post">
          <input class="change-lang-btn" type="submit" value="en"/>
          <input type="hidden" name="local" value="en_US"/>
          <c:if test="${empty param.get('commandName')}">
            <input type="hidden" name="commandName" value="loginPage"/>
          </c:if>
          <c:if test="${not empty param.get('commandName')}">
            <input type="hidden" name="commandName" value="${param.get("commandName")}"/>
          </c:if>
          <c:forEach var="input" items="${param.entrySet()}">
            <input type="hidden" name="${input.getKey()}" value="${input.getValue()}"/>
          </c:forEach>
        </form>
      </div>
      <ul class="nav navbar-nav">
        <li>
          <a href="${pageContext.request.contextPath}/controller?commandName=order_project_page"><fmt:message
            key="local.orderProject"/></a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/controller?commandName=view_project"><fmt:message
            key="local.viewProjects"/></a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/controller?commandName=view_workers"><fmt:message
            key="local.viewWorkers"/></a>
        </li>
        <li>
          <a href="${pageContext.request.contextPath}/controller?commandName=view_chat"><fmt:message
            key="local.toChat"/></a>
        </li>
      </ul>
    </div>
  </nav>
</header>
</body>
</html>
