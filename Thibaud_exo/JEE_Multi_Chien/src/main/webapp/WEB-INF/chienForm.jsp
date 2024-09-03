<jsp:useBean id="mode" type="java.lang.String" scope="request" />
<jsp:useBean id="chien" type="org.example.jee_multi_chien.entity.Chien" scope="request" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="/WEB-INF/bootstrapimports.html" %>
    <title><%= mode.substring(0,1).toUpperCase()+mode.substring(1).toLowerCase() %> a Dog</title>
</head>
<body>
<main class="container">
    <div class="my-3 row">
        <div class="col-8 offset-2 p-3 rounded text-bg-dark">
            <h1 class="fw-light">-<%= mode.substring(0, 1).toUpperCase() + mode.substring(1).toLowerCase() %> a Dog-</h1>
            <hr>
            <form action="<%= mode.equals("add") ? "add" : "" %>" method="post">
                <input type="number" class="d-none" name="id" readonly>
                <div class="mb-3">
                    <label for="nom" class="form-label">Name:</label>
                    <input type="text" name="nom" id="nom" class="form-control" value="<%= chien.getNom() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="race" class="form-label">Breed:</label>
                    <input type="text" name="race" id="race" class="form-control" value="<%= chien.getRace() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>
                <div class="mb-3">
                    <label for="dateDeNaissance" class="form-label">Birth date:</label>
                    <input type="date" name="dateDeNaissance" id="dateDeNaissance" class="form-control" value="<%= chien.getDateDeNaissance() %>" <% if (mode.equals("add")) { %> required <% } else { %> readonly <% } %>>
                </div>

                <hr>
                <div class="text-end">
                    <% if (mode.equals("add")) { %>
                    <button class="btn btn-outline-success"><i class="bi bi-plus-circle"></i> Add Dog</button>
                    <% } else { %>
                    <a href="${pageContext.request.contextPath}/chien/list" class="btn btn-outline-secondary"><i
                            class="bi bi-arrow-counterclockwise"></i>
                        Return</a>
                    <% }  %>
                </div>
            </form>
        </div>
    </div>
</main>
</body>
</html>