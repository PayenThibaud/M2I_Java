
<%@ page import="java.util.List" %>
<%@ page import="entity.Article_vente" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Article" %>
<%@ page import="entity.Vente" %>

<%
    List<Article_vente> articleVentes = (List<Article_vente>) request.getAttribute("articleVentes");
    if (articleVentes == null) {
        articleVentes = new ArrayList<>();
    }
%>

<html>
<head>
    <title>Article_Ventes</title>
</head>
<body>

<header>
    <h1>Liste des jointures Article - Vente</h1>
</header>

<main class="container">
    <% if (!articleVentes.isEmpty()) { %>
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>ID Article</th>
            <th>ID Vente</th>
            <th>Quantité</th>
        </tr>
        </thead>
        <tbody>
        <% for (Article_vente articleVente : articleVentes) { %>
        <tr>
            <td><%= articleVente.getArticle().getId() %></td>
            <td><%= articleVente.getVente().getId() %></td>
            <td><%= articleVente.getQuantiteArticle() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>Vous n'avez aucune jointure entre vente et article</p>
    <% } %>

    <hr/>

    <h2>Formulaire d'ajout de jointure Article - Vente</h2>

    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="" method="post">

            <div class="mb-3">
                <label for="article">Article :</label>
                <input type="number" id="article" name="article" required>
            </div>

            <div class="mb-3">
                <label for="vente">Vente :</label>
                <input type="number" id="vente" name="vente" required>
            </div>

            <div class="mb-3">
                <label for="quantiteArticle">Quantité Article :</label>
                <input type="number" id="quantiteArticle" name="quantiteArticle" required>
            </div>

            <button class="text-end">Ajouter</button>
        </form>
    </div>
</main>

</body>
</html>
