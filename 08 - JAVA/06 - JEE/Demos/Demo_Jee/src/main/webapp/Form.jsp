<%--
  Created by IntelliJ IDEA.
  User: Administrateur
  Date: 29/08/2024
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="form" method="post">
  <div>
    <label for="firstname"> Firstname :</label>
    <input type="text" id="firstname" name="firstname">
  </div>

  <div>
    <label for="lastname"> Lastnema :</label>
    <input type="text" id="lastname" name="lastname">
  </div>

  <div>
    <label for="age"> Age :</label>
    <input type="number" id="age" name="age">
  </div>

<button>Send</button>
</form>

</body>
</html>
