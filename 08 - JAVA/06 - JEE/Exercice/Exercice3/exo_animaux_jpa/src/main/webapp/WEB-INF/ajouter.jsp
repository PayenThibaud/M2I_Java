<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 30/08/2024
  Time: 10:06
  To change this template use File | Settings | File Templates.
--%>
<jsp:useBean id="titre" type="java.lang.String" scope="request"/>
<jsp:useBean id="chien" type="entity.Chien" scope="request"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%= titre %> </title>
</head>
<body>
<main>
    <jsp:include page="component/nav.jsp"/>
    <form action="ajouter" method="post">
        <input name="id" id="id" <%=chien.getIdChien() != 0 ? "value='"+chien.getIdChien()+"'":"" %> hidden="hidden">
        <label for="nom">Nom du chat</label>
        <input type="text" id="nom" name="nom" required <%=chien.getNomChien() != null ? "value='"+chien.getNomChien()+"'":"" %>  >
        <label for="race">Race</label>
        <input type="text" id="race" name="race" required <%=chien.getRace() != null ? "value='"+chien.getRace()+"'":"" %> >
        <label for="dateDeNaissance">date de naissance </label>
        <input type="date" id="dateDeNaissance" name="dateDeNaissance" required <%=chien.getDateNaissance() != null ? "value='"+chien.getDateNaissance()+"'":"" %> >
        <button>send</button>

    </form>
</main>
</body>
</html>
