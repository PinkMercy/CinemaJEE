<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="bootstrap.css">
</head>
<body>
 <h1>Ajouter une nouvelle salle de cinéma</h1>
    <form action="ServletListSalle" method="post">
    <input type="hidden" name="action" value="add">
        <label for="nom">Nom :</label>
        <input type="text" id="nom" name="nom" required><br><br>
        
        <label for="adresse">Adresse :</label>
        <input type="text" id="adresse" name="adresse" required><br><br>
        
        <label for="capacite">Capacité :</label>
        <input type="number" id="capacite" name="capacite" required><br><br>
        
        <input type="submit" value="Ajouter">
    </form>
</body>
</html>