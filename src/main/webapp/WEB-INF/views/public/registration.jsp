<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="headerRegister.jsp"/>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form modelAttribute="userDto" method="post">
        <div class="form-group">
            <form:input type="email" path="email" placeholder="Email" />
        </div>
        <div class="form-group">
            <form:input path="password" type="password" placeholder="Hasło" />
        </div>
        <div class="form-group">
            <form:input path="confirmPassword" type="password" placeholder="Powtórz hasło" />
        </div>
        <p><form:errors path="*"/> </p>

        <div class="form-group form-group--buttons">
            <a href="/login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>

<jsp:include page="footer.jsp"/>