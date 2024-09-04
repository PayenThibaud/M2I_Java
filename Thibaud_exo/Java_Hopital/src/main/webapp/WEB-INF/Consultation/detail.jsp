<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Détails de la consultation</title>
</head>
<body>
<h1>Détails de la consultation</h1>

<div>
    <label>Nom:</label>
    <a href="${pageContext.request.contextPath}/consultation/list?id=${consultation.patient.id}">Retour à la consultation du patient : ${consultation.patient.nom}</a>
</div>
<div>
    <label>Nom du médecin:</label>
    <span>${consultation.nomMedecin}</span>
</div>
<div>
    <label>Date de consultation:</label>
    <span>${consultation.dateDeConsultation}</span>
</div>
<div>
    <label>Prescription :</label>
    <span>${consultation.prescription}</span>
</div>
<div>
    <label>Fiche de soin :</label>
    <span>${consultation.ficheDeSoin}</span>
</div>

</body>
</html>
