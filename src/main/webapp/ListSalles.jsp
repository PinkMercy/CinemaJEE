<%@ page import="modele.entities.SalleCinema" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des salles</title>
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
            <form class="d-flex">
                <input class="form-control me-sm-2" type="search" placeholder="Search Salle">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">

    <h1>Liste des salles</h1>

    <div class="row justify-content-end mb-3">

    </div>

    <table class="table">
        <thead >
        <tr>
            <th>#</th>
            <th>Nom de la salle</th>
            <th>Capacité de la salle</th>
            <th>Adresse de la salle</th>
            <th>Actions</th>
        </tr>
        </thead>
        <%
            List<SalleCinema> list = (List<SalleCinema>) request.getAttribute("list");
            if (list != null) {
                for (SalleCinema salle : list) {
        %>
        <tr>
            <td><%= salle.getId() %></td>
            <td><%= salle.getNom() %></td>
            <td><%= salle.getCapacite() %></td>
            <td><%= salle.getAdresse() %></td>
            <td>
                <a href="ModifierSalle.jsp?id=<%= salle.getId() %>" class="btn btn-primary">Modifier</a>
                <form action="ServletListSalle" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= salle.getId() %>">
                    <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cette salle?')" class="btn btn-danger">
                </form>
            </td>
        </tr>
        <%
                }
            }
        %>
    </table>

    <div class="row">
        <div class="col text-center">
            <a href="ajoutSalle.jsp" class="btn btn-success mb-3">Ajouter une salle</a>
        </div>
    </div>

</div>
</body>
</html>
