<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href=<c:url value="/resources/css/userTable.css"/>>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css">
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
        <c:forEach items="${admins}" var="admin">
        <tr>
            <td>${admin.id}</td>
            <td>${admin.email}</td>
            <td><a href="/admin/delete/${admin.id}"><span class="icon-minus"/></a></td>
            <td><a href="/admin/edit/${admin.id}"><span class="icon-settings"/></a></td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
</body>
</html>

