<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC Tutorial</title>
    </head>
    <body>

        Prueba
        <br/>

        <c:forEach var="i" begin="1" end="5">
            Item <c:out value="${i}"/><p>
        </c:forEach>

    </body>
</html>
