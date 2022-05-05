<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<jsp:include page="../public/headerLoggedIn.jsp"/>
<section class="form--steps">

    <div class="form--steps-container">

        <form:form modelAttribute="institution" method="post" action="/institutions/edit">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Dodaj / edytuj fundację:</h3>

                <div class="form-group form-group--inline">
                    <form:label path="name"> Nazwa fundacji: </form:label>
                    <form:input path="name"/>
                </div>
                <div class="form-group form-group--inline">
                    <form:label path="description"> Opis fundacji: </form:label>
                    <form:textarea path="description"/>
                </div>
                <form:errors path="*" cssClass="ui-state-error-text"/>
                <div class="form-group form-group--buttons">
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
                <form:hidden path="id"/>
            </div>
        </form:form>
    </div>
</section>

<jsp:include page="../public/footer.jsp"/>