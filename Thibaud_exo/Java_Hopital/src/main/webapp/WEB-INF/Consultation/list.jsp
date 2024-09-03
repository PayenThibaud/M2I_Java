<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Liste des Consultations</title>
</head>
<body>
<h1>Liste des Consultations</h1>

<label>Patient :</label>
<span>${patient.nom}</span>

<label>Prénom:</label>
<span>${patient.prenom}</span>

<label>Liste de patient :</label>
<a href="${pageContext.request.contextPath}/patient/list">ici</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom Médecin</th>
        <th>Date de Consultation</th>
        <th>Prescription</th>
        <th>Fiche de Soin</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="consultation" items="${consultations}">
        <tr>
            <td>${consultation.id}</td>
            <td>${consultation.nomMedecin}</td>
            <td>${consultation.dateDeConsultation}</td>
            <td>${consultation.prescription}</td>
            <td>${consultation.ficheDeSoin}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h2>Ajouter une Nouvelle Consultation</h2>
<form action="${pageContext.request.contextPath}/consultation/addConsultation" method="post">
    <input type="hidden" name="patientId" value="${patient.id}">
    <div>
        <label for="nomMedecin">Nom Médecin:</label>
        <input type="text" id="nomMedecin" name="nomMedecin" required>
    </div>
    <div>
        <label for="dateDeConsultation">Date de Consultation:</label>
        <input type="date" id="dateDeConsultation" name="dateDeConsultation" required>
    </div>
    <div>
        <label for="prescription">Prescription:</label>
        <textarea id="prescription" name="prescription"></textarea>
    </div>
    <div>
        <label for="ficheDeSoin">Fiche de Soin:</label>
        <textarea id="ficheDeSoin" name="ficheDeSoin"></textarea>
    </div>
    <div>
        <button type="submit">Ajouter la Consultation</button>
    </div>
</form>


</body>
</html>
