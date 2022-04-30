<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="wrapper">
    <div class="section-first p-4">
        <h1 class="h1 heading text-center">Конструкструкторское бюро <b class="text-danger">"Илон Маск"</b></h1>
        <div class="mt-5">
            <p class="h3">
                Конструкторское бюро <b class="text-danger">"Илон Маск"</b> это:
            <ul class="mt-2">
                <li>
                    <h4 class="text-primary">0+ довольных заказчиков</h4>
                </li>
                <li>
                    <h4 class="text-info">0+ реализованных проектов</h4>
                </li>
                <li>
                    <h4 class="text-success">Разработка с помощью новейших систем принятия решений</h4>
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
