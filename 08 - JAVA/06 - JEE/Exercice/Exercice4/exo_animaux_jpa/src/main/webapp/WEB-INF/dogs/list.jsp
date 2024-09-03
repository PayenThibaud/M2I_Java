<%@ page import="entity.Chien" %>
<jsp:useBean id="dogs" type="java.util.ArrayList<entity.Chien>" scope="request" />
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
            <% if (!dogs.isEmpty()) { %>
            <table class="table table-dark align-middle table-striped text-center">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Breed</th>
                    <th>Birth date</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <% for (Chien d : dogs) {%>
                <tr>
                    <td><%= d.getIdChien() %></td>
                    <td><%= d.getNomChien() %></td>
                    <td><%= d.getRace() %></td>
                    <td><%= d.getDateNaissance().toString() %></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/dog/detail?id=<%= d.getIdChien() %>"
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
                <a href="${pageContext.request.contextPath}/dog/addForm" class="btn btn-outline-success"><i
                        class="bi bi-plus-circle"></i> Add a Dog</a>
            </div>
        </div>
    </div>
</main>
</body>
</html>
