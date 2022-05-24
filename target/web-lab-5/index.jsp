<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="${sessionScope.local}"/>
<fmt:setBundle basename="local"/>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Лабораторная 3</title>
    <link href="static/css/styles.css" rel="stylesheet"/>
    <link
            crossorigin="anonymous"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            rel="stylesheet"
    />
</head>
<body>
<jsp:include page="WEB-INF/view/fragments/header.jsp"/>
<div class="wrapper">
    <div class="section-first p-4">
        <h1 class="h1 heading text-center"><fmt:message key="local.constructor_agency"/>
          <b class="text-danger">"<fmt:message key="local.ilon_musk"/>"</b></h1>
        <div class="mt-5">
            <p class="h3">
              <fmt:message key="local.constructor_agency"/> <b class="text-danger">"<fmt:message key="local.ilon_musk"/>"</b>:
            <ul class="mt-2">
                <li>
                    <h4 class="text-primary"><fmt:message key="local.happyConsumers"/></h4>
                </li>
                <li>
                    <h4 class="text-info"><fmt:message key="local.developedProjects"/></h4>
                </li>
                <li>
                    <h4 class="text-success"><fmt:message key="local.newSystems"/></h4>
                </li>
            </ul>
        </div>
        <div class="image w-50">
            <img src="static/img/Image.jpg" class="img-fluid">
        </div>
    </div>
    <div class="section-second p-4 pb-5">
        <p class="">
            Больше здесь я ничего не придумал, но сайт выглядит пустовато, так что
            6. Конструкторское бюро. Заказчик представляет Техническое Задание (ТЗ), в котором перечислен перечень Работ
            с указанием квалификации и количества требуемых специалистов. Администратор рассматривает ТЗ и оформляет
            Проект, назначая на него незанятых Работников требуемой квалификации, после чего рассчитывается стоимость
            Проекта и Заказчику выставляется Счет из расчета заработной платы назначенных специалистов.
            Вывести информацию обо всех заданиях указанного заказчика.
            Вывести информацию о требуемых специалистах указанного задания.
            Назначить в проект работников.
            Вывести информацию о неоплаченных проектах.
        </p>
        <p>
            Михаил Юрьевич Лермонтов<br/>
            Парус<br/>
            Белеет парус одинокой<br/>
            В тумане моря голубом!..<br/>
            Что ищет он в стране далекой?<br/>
            Что кинул он в краю родном?..<br/>

            Играют волны — ветер свищет,<br/>
            И мачта гнется и скрыпит…<br/>
            Увы! он счастия не ищет<br/>
            И не от счастия бежит!<br/>

            Под ним струя светлей лазури,<br/>
            Над ним луч солнца золотой…<br/>
            А он, мятежный, просит бури,<br/>
            Как будто в бурях есть покой!<br/>
        </p>
    </div>
    <div class="h-50 bg-primary">

    </div>
</div>
</body>
</html>
