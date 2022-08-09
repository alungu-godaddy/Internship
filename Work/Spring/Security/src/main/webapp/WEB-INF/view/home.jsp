<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>luv2code Company Home Page</title>
    </head>
    <body>
        <h2>lu2Code company home page</h2>
        <hr>

        <p>
            Welcome to the luv2Code Company Home Page.
        </p>

        <hr>
        <security:authorize access="hasRole('MANAGER')">
            <!-- Add link to point to /leaders -->
            <p>
                <a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a> (Only for Manager peeps)
            </p>
        </security:authorize>

        <security:authorize access="hasRole('ADMIN')">
        <!-- Add link to point to /systems ... this is only for admins -->
            <p>
                <a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a> (Only for Admin peeps)
            </p>
        </security:authorize>

        <hr>
            <!-- display user name and role -->
        <p>
            User: <security:authentication property="principal.username" />
            <br><br>
            Role(s): <security:authentication property="principal.authorities" />
        </p>
        <hr>

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Logout" />
        </form:form>

    </body>
</html>