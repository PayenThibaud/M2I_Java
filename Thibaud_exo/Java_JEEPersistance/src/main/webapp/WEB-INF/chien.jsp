<%@ page import="entity.Chien" %>
<%@ page import="java.util.List" %>
<%@ page import="repository.ChienRepository" %><%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/08/2024
  Time: 09:18
  To change this template use File | Settings | File Templates.
--%>
<%
    ChienRepository chienRepository = new ChienRepository();
    List<Chien> chiens = chienRepository.findAll();
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
        <title>Chiens</title>
</head>
<body>

<header>
    <h1>Liste des chiens</h1>
</header>

<main class="container">

    <% if(!(chiens.isEmpty())){ %>
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Nom</th>
            <th>Race</th>
            <th>Date de naissance</th>
            <th>Detail</th>
        </tr>
        </thead>

        <tbody>
        <% for  (Chien chien : chiens){%>
        <tr>
            <td><%= chien.getNom()%></td>
            <td><%= chien.getRace()%></td>
            <td><%= chien.getDateDeNaissance()%></td>
            <td><a href="chienDetail?id=<%= chien.getId() %>">détail</a></td>

        </tr>

        <%}%>

        </tbody>

    </table>

    <% } else {%>
    <p>Vous n'avez aucun chien dans votre liste</p>
    <% }%>

    <hr/>

    <h2>Formulaire d'ajout de chien</h2>

    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="" method="post">
            <div class="mb-3">
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom">
            </div>
            <div class="mb-3">
                <label for="race">Race :</label>
                <input type="text" id="race" name="race">
            </div>
            <div class="mb-3">
                <label for="dateDeNaissance">Date de naissance :</label>
                <input type="date" id="dateDeNaissance" name="dateDeNaissance">
            </div>

            <button class="text-end">Ajouter</button>


        </form>
    </div>
</main>

</body>
</html>
