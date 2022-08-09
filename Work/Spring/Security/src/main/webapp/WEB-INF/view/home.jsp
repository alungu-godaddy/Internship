<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

        <form:form action="${pageContext.request.contextPath}/logout" method="POST">
            <input type="submit" value="Logout" />
        </form:form>

    </body>
</html>