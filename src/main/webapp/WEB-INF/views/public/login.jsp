<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="headerRegister.jsp"/>
<section class="login-page">
    <h2>Zaloguj się</h2>
    <form method="post">
        <c:if test="${confirmationSuccess}">
            <div class="ui-state-error-text">
                Email został potwierdzony. Możesz sie teraz zalogować<br>
            </div>
        </c:if>
        <div class="form-group">
            <input type="email" name="username" placeholder="Email" />
        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło" />
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>
            <c:if test="${invalidCredentials}">
                <div class="ui-state-error-text">
                    Niepoprawny adres email lub hasło
                </div>
            </c:if>
        <c:if test="${userDisabled}">
            <div class="ui-state-error-text">Twoje konto nie zostało jeszcze aktywowane. Proszę sprawdź swoją skrzynkę pocztową</div>
        </c:if>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</section>

<jsp:include page="footer.jsp"/>
