<<%@ page import="java.util.List" %>
<%@ page import="entity.Client" %>
<%@ page import="java.util.ArrayList" %>

<%
    List<Client> clients = (List<Client>) request.getAttribute("clients");
    if (clients == null) {
        clients = new ArrayList<>();
    }
%>

<html>
<head>
    <title>Clients</title>
</head>
<body>

<header>
    <h1>Liste des clients</h1>
</header>

<main class="container">
    <% if (!clients.isEmpty()) { %>
    <table class="table table-dark text-center align-middle">
        <thead>
        <tr>
            <th>Id</th>
            <th>Nom</th>
            <th>Mail</th>
        </tr>
        </thead>
        <tbody>
        <% for (Client client : clients) { %>
        <tr>
            <td><%= client.getId() %></td>
            <td><%= client.getNom() %></td>
            <td><%= client.getMail() %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
    <% } else { %>
    <p>Vous n'avez aucun client dans votre liste</p>
    <% } %>

    <hr/>

    <h2>Formulaire d'ajout du client</h2>

    <div class="col-8 offset-2 text-bg-dark p-3">
        <form action="" method="post">
            <div class="mb-3">
                <label for="nom">Nom :</label>
                <input type="text" id="nom" name="nom">
            </div>
            <div class="mb-3">
                <label for="mail">Mail :</label>
                <input type="text" id="mail" name="mail">
            </div>

            <button class="text-end">Ajouter</button>
        </form>
    </div>
</main>

</body>
</html>