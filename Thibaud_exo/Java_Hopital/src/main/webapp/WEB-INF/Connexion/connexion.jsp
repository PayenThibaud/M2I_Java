<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Connexion</title>
</head>
<body>
<h1>Connexion</h1>
<form action="${pageContext.request.contextPath}/get-session/connexion" method="post">
    <div>
        <label for="user">Nom d'utilisateur:</label>
        <input type="text" id="user" name="user" required>
    </div>
    <div>
        <label for="motsDePasse">Mot de passe:</label>
        <input type="text" id="motsDePasse" name="motsDePasse" required>
    </div>
    <div>
        <button type="submit">Se connecter</button>
    </div>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
</form>
</body>
</html>
