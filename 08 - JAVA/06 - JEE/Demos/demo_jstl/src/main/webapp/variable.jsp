<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 02/09/2024
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>La balise c:if</h3>

<c:if test="${isTrue}">
    <p>La valeur est vrai !!!</p>
</c:if>

<c:if test="${isFalse}">
    <p>La valeur est fausse !!!</p>
</c:if>

<c:if test="${other}">
    <p>other!!!</p>
</c:if>


<h3>La balise c:out</h3>

<p>
    <c:out value="${nameDemo}" default="Au cas ou une valeur par défaut !!"/>
</p>

<p>
    <c:out value="${name}" default="Au cas ou une valeur par défaut !!" />
</p>

<h3>La balise c:forEach</h3>

<c:forEach var="prenom" items="${prenoms}">
    <p>${prenom}</p>
</c:forEach>

<h3>La balise c:import</h3>

<c:import url="WEB-INF/madiv.html" />

<h3>La balise c:set</h3>

<c:set var="maVariable" value="true" scope="session" />

<h3>Les balises c:choose c:when c:otherwise</h3>

<c:choose>
    <c:when test="${maVariable}">
        <p>La premiere condition est vrai</p>
    </c:when>
    <c:when test="${isTrue}">
        <p>La seconde condition est vrai</p>
    </c:when>
    <c:otherwise>
        <p>Aucune des valeurs precedentes est vrai</p>
    </c:otherwise>
</c:choose>



</body>
</html>
