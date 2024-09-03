<%@ page import="org.example.jee_multi_chien.entity.Chien" %>
<jsp:useBean id="chiens" type="java.util.ArrayList<org.example.jee_multi_chien.entity.Chien>" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title>Dogs List</title>
</head>
<body>
<main class="container">
    <div class="row my-3">
        <div class="col-8 offset-2 rounded text-bg-dark p-3">
            <h1 class="fw-light">- Dogs List -</h1>
            <hr>
            <% if (!chiens.isEmpty()) { %>
            <table class="table table-dark align-middle table-striped text-center">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Nom</th>
                    <th>Race</th>
                    <th>Date de naissance</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (Chien d : chiens) {%>
                <tr>
                    <td><%= d.getId() %></td>
                    <td><%= d.getNom() %></td>
                    <td><%= d.getRace() %></td>
                    <td><%= d.getDateDeNaissance().toString() %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/chien/detail?id=<%= d.getId() %>"
                           class="btn btn-outline-info"><i class="bi bi-eye"></i> Details</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
            <%  } else { %>
            <p>There is no dog in the database yet!</p>
            <%  }  %>
            <hr>
            <div class="text-end">
                <a href="${pageContext.request.contextPath}/chien/addForm" class="btn btn-outline-success"><i
                        class="bi bi-plus-circle"></i> Add a Dog</a>
            </div>
        </div>
    </div>
</main>
</body>
</html>
