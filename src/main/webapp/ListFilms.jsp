<%@ page import="modele.entities.Film" %>
<%@ page import="java.util.List" %>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des films</title>
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
                <input class="form-control me-sm-2" type="search" placeholder="Search film">
                <button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container">
    <h1>Liste des films</h1>
    <table class="table">
        <thead>
        <tr>
            <th>#</th>
            <th>Titre</th>
            <th>Réalisateur</th>
            <th>Durée</th>
            <th>Date de Sortie</th>
            <th>Actions</th>
        </tr>
        </thead>
        <%
            List<Film> list = (List<Film>) request.getAttribute("list");
            if (list != null) {
                for (Film film : list) {
        %>
        <tr>
            <td><%= film.getId() %></td>
            <td><%= film.getTitre() %></td>
            <td><%= film.getRealisateur() %></td>
            <td><%= film.getDuree() %></td>
            <td><%= film.getDateSortie() %></td>
            <td>
                <a href="ModifierFilm.jsp?id=<%= film.getId() %>" class="btn btn-primary">Modifier</a>
                <form action="ServletFilm" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="<%= film.getId() %>">
                    <input type="submit" value="Supprimer" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce film?')" class="btn btn-danger">
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
            <a href="ajoutFilm.jsp" class="btn btn-success mb-3">Ajouter un film</a>
        </div>
    </div>
</div>
</body>
</html>
