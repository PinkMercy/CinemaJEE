<%--
  Created by IntelliJ IDEA.
  User: rahma
  Date: 5/6/2024
  Time: 11:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body>
<nav class="navbar navbar-expand-lg bg-primary" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Cinema</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link active" href="home.jsp">Home
                        <span class="visually-hidden">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ServletListSalle">liste salle</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="ServletFilm">liste film</a>
                    <%--                </li>--%>
                    <%--                <li class="nav-item">--%>
                    <%--                    <a class="nav-link" href="#">About</a>--%>
                    <%--                </li>--%>

            </ul>

        </div>
    </div>
</nav>
<div class="row">
    <div class="col text-center">
       <h1>Welcome to The Cinema</h1>
    </div>
</div>

</body>
</html>
