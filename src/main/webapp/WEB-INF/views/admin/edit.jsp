<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <script src=<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"/>></script>

</head>
<body>
<form:form modelAttribute="user" method="post" action="/admin/edit">
    <form:hidden path="id"/>
    <form:hidden path="password"/>
    <ul>
        <li>
            <form:label path="email">Email</form:label>
            <form:input path="email"/>
        </li>
        <li>
            <form:label path="enabled">Enabled:</form:label>
            <form:checkbox path="enabled"/>
        </li>
        <li>
            <form:label path="locked">Locked:</form:label>
            <form:checkbox path="locked"/>
        </li>
        <li>
            <form:label path="userRole">Role:</form:label>
            <form:radiobuttons path="userRole" items="${roles}"/>
        </li>
    </ul>
    <button type="submit">Zapisz</button>
</form:form>
<a href=<c:url value="/admin/list"/>><button>Cofnij</button></a>
<script type="text/javascript">
    $()
</script>
</body>
</html>

