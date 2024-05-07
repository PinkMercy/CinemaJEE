<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Modifier une salle</title>

    <link rel="stylesheet" href="bootstrap.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
          integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
          crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body style="display:flex; align-items:center; justify-content:center;">
<div class="form">
    <h3><i class="fa-solid fa-pen-to-square"></i>Modifier</h3><br>
    <form action="ServletListSalle" method="post">
        <input type="hidden" name="action" value="update">
        <input type="hidden" id="id" name="id" value="<%= request.getParameter("id") %>">
        <div class="form-group">
            <label for="titrefilm">Nom du film :</label><br>
            <input type="text" id="titrefilm" name="nom" value="${film.nom}" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="date">Date de projection :</label><br>
            <input type="date" id="date" name="date" value="${film.date}" class="form-control" required>
        </div>
        <div class="form-group">
            <label for="heure">Heure de projection :</label><br>
            <input type="time" id="heure" name="heure" value="${film.heure}" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-success">Modifier</button>
    </form>
</div>
</body>
</html>