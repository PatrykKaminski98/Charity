<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<jsp:include page="../public/headerLoggedIn.jsp"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.5.5/css/simple-line-icons.min.css">

<section class="help">
    <h2>Komu pomagamy?</h2>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy.
            Możesz sprawdzić czym się zajmują.</p>

        <ul class="help--slides-items">
            <c:forEach var="institution" items="${institutions}">
                    <li>
                        <div class="col">
                            <div class="title">Fundacja "${institution.name}"</div>
                            <div class="subtitle">Cel i misja: ${institution.description}</div>
                        </div>
                        <sec:authorize access="hasRole('ADMIN')">
                            <div class="col">
                                <div class="subtitle"><a href="/institutions/edit/${institution.id}"><span class="icon-settings">Edytuj</span></a></div>
                                <div class="subtitle"><a href="/institutions/delete/${institution.id}"><span class="icon-minus">Usuń</span></a></div>
                            </div>
                        </sec:authorize>
                    </li>
            </c:forEach>
            <li>
                <div class="col">
                    <div class="title"><a href="/institutions/add"><span class="icon-plus">Dodaj</span></a></div>
                </div>
            </li>
        </ul>
    </div>

</section>

<jsp:include page="../public/footer.jsp"/>

