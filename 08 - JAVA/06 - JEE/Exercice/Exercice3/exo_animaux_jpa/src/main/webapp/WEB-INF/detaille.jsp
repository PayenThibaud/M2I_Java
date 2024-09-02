<%@ page import="entity.Chien" %>
<%@ page import="java.time.Period" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/08/2024
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<%
    Chien chien = (Chien) request.getAttribute("chien");
    String titre = (String) request.getAttribute("titre");
    Integer age = (Integer) request.getAttribute("age");

%>
<%--<jsp:useBean id="titre" type="java.lang.String" scope="request"/>--%>
<%--<jsp:useBean id="chien" type="entity.Chien" scope="request"/>--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=titre%> </title>
</head>
<body>

<main>
    <jsp:include page="component/nav.jsp"/>

    <% if (chien != null) { %>
    <p>Le nom du loulou est: <%= chien.getNomChien() %></p>
    <p>Il est né le: <%= chien.getDateNaissance() %> (<%= age %> ans)</p>
    <p>Et c'est un: <%= chien.getRace() %></p>
    <% } else { %>
    <p>besoin d'un loulou, aller sur ajouter <button><a href="${pageContext.request.contextPath}/affichage">ajouter</a> </button></p>
    <% } %>
</main>

</body>
</html>
