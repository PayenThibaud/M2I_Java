<%@ page import="entity.Chien" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Détail du Chien</title>
</head>
<body>

<header>
    <h1>Détails du chien</h1>
</header>

<main class="container">
    <% Chien chien = (Chien) request.getAttribute("chien"); %>

    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Date de naissance</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td><%= chien.getNom() %></td>
            <td><%= chien.getRace() %></td>
            <td><%= chien.getDateDeNaissance() %></td>
        </tr>
        </tbody>
    </table>

    <a href="chien">liste des chiens</a>
</main>

</body>
</html>
