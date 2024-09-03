<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Liste des Patients</title>
</head>
<body>
<h1>Liste des Patients</h1>


<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Date de Naissance</th>
        <th>Detail</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="patient" items="${patients}">
        <tr>
            <td>${patient.id}</td>
            <td>${patient.nom}</td>
            <td>${patient.prenom}</td>
            <td>${patient.dateDeNaissance}</td>
            <td> <a href="${pageContext.request.contextPath}/patient/detail?id=${patient.id}">Voir Détail</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Ajouter un Nouveau Patient</h2>
<form action="${pageContext.request.contextPath}/patient/addPatient" method="post">
    <div>
        <label for="nom">Nom:</label>
        <input type="text" id="nom" name="nom" required>
    </div>
    <div>
        <label for="prenom">Prénom:</label>
        <input type="text" id="prenom" name="prenom" required>
    </div>
    <div>
        <label for="dateDeNaissance">Date de Naissance:</label>
        <input type="date" id="dateDeNaissance" name="dateDeNaissance" required>
    </div>
    <div>
        <button type="submit">Ajouter le Patient</button>
    </div>
</form>

</body>
</html>
