<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<form:form modelAttribute="user" method="post" action="/admin/editAdmin">
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
            <form:label path="userRole">Role:</form:label>
            <form:radiobuttons path="userRole" items="${roles}"/>
        </li>
    </ul>
    <button type="submit">Zapisz</button>
</form:form>
<a href=<c:url value="/admin/listOfAdmins"/>><button>Cofnij</button></a>
</body>
</html>
