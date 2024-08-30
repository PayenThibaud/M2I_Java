<%@ page import="entity.Cat" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/08/2024
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%
    List<Cat> cats = (List<Cat>) request.getAttribute("cats");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <title>Chats</title>
</head>
<body>

<header>
    <h1>Liste des chats</h1>
</header>

<main class="container">

    <% if(!(cats.isEmpty())){ %>
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Plat favoris</th>
            <th>Date de naissance</th>
        </tr>
        </thead>

        <tbody>
        <% for  (Cat cat : cats){%>
        <tr>
            <td><%= cat.getName()%></td>
            <td><%= cat.getBreed()%></td>
            <td><%= cat.getFavMeal()%></td>
            <td><%= cat.getDateOfBirth()%></td>
        </tr>

        <%}%>

        </tbody>

    </table>

    <% } else {%>
    <p>Vous n'avez aucun chat dans votre liste</p>
    <% }%>

    <hr/>

    <h2>Formulaire d'ajout de chat</h2>

    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="" method="post">
            <div class="mb-3">
                <label for="name">Nom :</label>
                <input type="text" id="name" name="name">
            </div>
            <div class="mb-3">
                <label for="breed">Race :</label>
                <input type="text" id="breed" name="breed">
            </div>
            <div class="mb-3">
                <label for="favMeal">Plat favoris :</label>
                <input type="text" id="favMeal" name="favMeal">
            </div>
            <div class="mb-3">
            <label for="dateOfBirth">Date de naissance :</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth">
        </div>

            <button class="text-end">Ajouter</button>


        </form>
    </div>
</main>

</body>
</html>
