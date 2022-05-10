<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<sec:authentication property="principal.username" var="user"/>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/userTable.css"/>>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css">
    <script src=<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>></script>
</head>
<body>
<h2>Lista administratorów</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Email</th>
            <th>Usuń</th>
            <th>Edytuj</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td><a href="/admin/deleteUser/${user.id}"><span id="delete" class="icon-minus"/></a></td>
            <td><a href="/admin/editUser/${user.id}"><span class="icon-settings"/></a></td>

        </tr>
        </c:forEach>
        <tbody>
    </table>
    <a href="/"><button>Powrót</button></a>
</div>
<script  type="text/javascript">
    $("#delete").click(function(event){
        if(confirm("Czy napewno chcesz usunąć tego użytkownika?")){
            return;
        } else {
            event.preventDefault();
        }
    })
</script>
</body>
</html>

