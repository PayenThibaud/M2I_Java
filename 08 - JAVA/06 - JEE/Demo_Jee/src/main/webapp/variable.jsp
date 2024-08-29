<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 29/08/2024
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Date" %>
<jsp:useBean id="nom" type="java.lang.String" scope="request"/>
<jsp:useBean id="prenom" type="java.lang.String" scope="request"/>
<jsp:useBean id="prenoms" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Affichage de mes variables</h1>

<h2>Bonjour ${nom.toUpperCase()}</h2>
<h2>${prenom}</h2>

<% for (String p: prenoms){%>
  <p><%= p %> </p>
  <p><%= new Date()%></p>
<%}%>

</body>
</html>
