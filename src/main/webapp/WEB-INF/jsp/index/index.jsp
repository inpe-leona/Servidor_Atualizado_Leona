<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" language="java"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>VRaptor!</h1>
        <form id="form" action="<c:url value='/movimentaresquerda'/>" method="post">
            <input type="text" placeholder="Graus" name="PantIlt.graus" value="${PantIlt.graus}"/>
            <input type="submit" value="ESQUERDA" id="enviar">
        </form>
    </body>
</html>
