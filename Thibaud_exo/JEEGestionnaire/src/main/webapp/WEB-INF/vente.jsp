<
<%@ page import="java.util.List" %>
<%@ page import="entity.Client" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Vente" %>

<%
    List<Vente> ventes = (List<Vente>) request.getAttribute("ventes");
    if (ventes == null) {
        ventes = new ArrayList<>();
    }
%>

<html>
<head>
    <title>Ventes</title>
</head>
<body>

<header>
    <h1>Liste des ventes</h1>
</header>

<main class="container">
    <% if (!ventes.isEmpty()) { %>
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Id</th>
            <th>Date</th>
            <th>Status</th>
            <th>ID Client</th>
        </tr>
        </thead>
        <tbody>
        <% for (Vente vente : ventes) { %>
        <tr>
            <td><%= vente.getId() %>
            </td>
            <td><%= vente.getDate() %>
            </td>
            <td><%= vente.getStatus() %>
            </td>
            <td><%= vente.getClient().getId()%>
            </td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>Vous n'avez aucune vente dans votre liste</p>
    <% } %>

    <hr/>

    <h2>Formulaire d'ajout d une vente</h2>

    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="" method="post">
            <div class="mb-3">
                <label for="date">Date :</label>
                <input type="text" id="date" name="date">
            </div>

            <div class="mb-3">
                <label for="status">Catégorie :</label>
                <select id="status" name="status" required>
                    <option value="En_cours">En_cours</option>
                    <option value="Finalisees">Finalisees</option>
                    <option value="Annulee">Annulee</option>
                </select>
            </div>

            <div class="mb-3">
                <label for="client">Client :</label>
                <input type="number" id="client" name="client">
            </div>

            <button class="text-end">Ajouter</button>
        </form>
    </div>
</main>

</body>
</html>
