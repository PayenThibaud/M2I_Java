<%@ page import="entity.Chat" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des Chats</title>
</head>
<body>

<form action="chat" method="post">
    <div>
        <label for="nom">Prenom</label>
        <input type="text" id="nom" name="nom"/>
    </div>
    <div>
        <label for="race">Race</label>
        <input type="text" id="race" name="race"/>
    </div>
    <div>
        <label for="repaFav">RepaFav</label>
        <input type="text" id="repaFav" name="repaFav"/>
    </div>
    <div>
        <label for="dateNaissance">DateNaissance</label>
        <input type="text" id="dateNaissance" name="dateNaissance"/>
    </div>
    <div>
        <button type="submit">Enregistrer</button>
    </div>
</form>

<h2>Liste des Chats</h2>

<%
    List<Chat> chats = (List<Chat>) request.getAttribute("chats");
    if (chats == null || chats.isEmpty()) {
%>
<p>Pas de chat à afficher.</p>
<%
} else {
%>
<table border="1">
    <thead>
    <tr>
        <th>Nom</th>
        <th>Race</th>
        <th>Repas Favori</th>
        <th>Date de Naissance</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Chat chat : chats) {
    %>
    <tr>
        <td><%= chat.getNom() %></td>
        <td><%= chat.getRace() %></td>
        <td><%= chat.getRepaFav() %></td>
        <td><%= chat.getDateNaissance() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>

</body>
</html>
