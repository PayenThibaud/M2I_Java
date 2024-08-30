<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="repository.ArticleRepository" %>
<%@ page import="entity.Article" %>

<%
    ArticleRepository articleRepository = new ArticleRepository();
    List<Article> articles = articleRepository.findAll();
    String articleType = request.getParameter("type") != null ? request.getParameter("type") : "";
%>

<html>
<head>
    <title>Articles</title>
</head>
<body>

<header>
    <h1>Liste d'article</h1>
</header>

<main class="container">

    <% if (!(articles.isEmpty())) { %>
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Id</th>
            <th>Description</th>
            <th>Prix</th>
            <th>Quantité</th>
            <th>Date de restock</th>
        </tr>
        </thead>

        <tbody>
        <% for (Article article : articles) { %>
        <tr>
            <td><%= article.getId() %></td>
            <td><%= article.getDescription() %></td>
            <td><%= article.getPrix() %></td>
            <td><%= article.getQuantite() %></td>
            <td><%= article.getDateDeRestock() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>Vous n'avez aucun article dans votre liste</p>
    <% } %>

    <hr/>

    <h2>Formulaire d'ajout d'article nourriture</h2>
    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="article" method="post">
            <input type="hidden" name="type" value="nourriture">
            <div class="mb-3">
                <label for="description">Description :</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="mb-3">
                <label for="prix">Prix :</label>
                <input type="number" id="prix" name="prix" required min="0">
            </div>
            <div class="mb-3">
                <label for="quantite">Quantité :</label>
                <input type="number" id="quantite" name="quantite" required min="0">
            </div>
            <div class="mb-3">
                <label for="dateDeRestock">Date de restock :</label>
                <input type="date" id="dateDeRestock" name="dateDeRestock" required>
            </div>
            <div class="mb-3">
                <label for="datePeremption">Date de péremption :</label>
                <input type="date" id="datePeremption" name="datePeremption" required>
            </div>
            <button type="submit">Ajouter</button>
        </form>
    </div>

    <h2>Formulaire d'ajout d'article électronique</h2>
    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="article" method="post">
            <input type="hidden" name="type" value="electronique">
            <div class="mb-3">
                <label for="description">Description :</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="mb-3">
                <label for="prix">Prix :</label>
                <input type="number" id="prix" name="prix" required min="0">
            </div>
            <div class="mb-3">
                <label for="quantite">Quantité :</label>
                <input type="number" id="quantite" name="quantite" required min="0">
            </div>
            <div class="mb-3">
                <label for="dateDeRestock">Date de restock :</label>
                <input type="date" id="dateDeRestock" name="dateDeRestock" required>
            </div>
            <div class="mb-3">
                <label for="dureeBatterie">Durée de la batterie :</label>
                <input type="text" id="dureeBatterie" name="dureeBatterie" required>
            </div>
            <button type="submit">Ajouter</button>
        </form>
    </div>

    <h2>Formulaire d'ajout d'article mode</h2>
    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="article" method="post">
            <input type="hidden" name="type" value="mode">
            <div class="mb-3">
                <label for="description">Description :</label>
                <input type="text" id="description" name="description" required>
            </div>
            <div class="mb-3">
                <label for="prix">Prix :</label>
                <input type="number" id="prix" name="prix" required min="0">
            </div>
            <div class="mb-3">
                <label for="quantite">Quantité :</label>
                <input type="number" id="quantite" name="quantite" required min="0">
            </div>
            <div class="mb-3">
                <label for="dateDeRestock">Date de restock :</label>
                <input type="date" id="dateDeRestock" name="dateDeRestock" required>
            </div>
            <div class="mb-3">
                <label for="categorie">Catégorie :</label>
                <select id="categorie" name="categorie" required>
                    <option value="Homme">Homme</option>
                    <option value="Femme">Femme</option>
                    <option value="Enfant">Enfant</option>
                </select>
            </div>
            <div class="mb-3">
                <label for="taille">Taille :</label>
                <input type="number" id="taille" name="taille" required>
            </div>
            <button type="submit">Ajouter</button>
        </form>
    </div>
</main>
</body>
</html>

