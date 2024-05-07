<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un nouveau film</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body>
<h1>Ajouter un nouveau film</h1>
<form action="ServletFilm" method="post">
    <input type="hidden" name="action" value="add">

    <label for="titre">Titre :</label>
    <input type="text" id="titre" name="titre" required><br><br>

    <label for="realisateur">Réalisateur :</label>
    <input type="text" id="realisateur" name="realisateur" required><br><br>

    <label for="duree">Durée (en minutes) :</label>
    <input type="number" id="duree" name="duree" required><br><br>

    <label for="dateSortie">Date de sortie :</label>
    <input type="date" id="dateSortie" name="dateSortie" required><br><br>

    <label for="description">Description :</label>
    <textarea id="description" name="description" required></textarea><br><br>

    <label for="image">Image URL :</label>
    <input type="text" id="image" name="image"><br><br>

    <label for="cat">Categorie:</label>
    <input type="text" id="cat" name="IdCategorie"><br><br>
    <input type="submit" value="Ajouter">
</form>
</body>
</html>
