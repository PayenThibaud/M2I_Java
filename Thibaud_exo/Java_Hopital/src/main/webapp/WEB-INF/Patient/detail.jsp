<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Détails du Patient</title>
</head>
<body>
<h1>Détails du Patient</h1>

<div>
    <label>Nom:</label>
    <a href="${pageContext.request.contextPath}/patient/list">${patient.nom}</a>
</div>
<div>
    <label>Prénom:</label>
    <span>${patient.prenom}</span>
</div>
<div>
    <label>Date de Naissance:</label>
    <span>${patient.dateDeNaissance}</span>
</div>


</body>
</html>
