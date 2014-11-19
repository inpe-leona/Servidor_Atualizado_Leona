<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>
            <input type="submit" value="LEFT" id="enviar">
        </form>
           <hr/> 
            <form id="form" action="<c:url value='/movimentardireita'/>" method="post">
            <input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>
            <input type="submit" value="RIGHT" id="enviar">
        </form>
           <hr/> 
            <form id="form" action="<c:url value='/movimentarcima'/>" method="post">
            <input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>
            <input type="submit" value="UP" id="enviar">
        </form>
           <hr/> 
            <form id="form" action="<c:url value='/movimentarbaixa'/>" method="post">
            <input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>
            <input type="submit" value="DOWN" id="enviar">
        </form>
           <hr/> 
            <form id="form" action="<c:url value='/movimentarreset'/>" method="post">
            <input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>
            <input type="submit" value="RESET" id="enviar">
        </form>
           <hr/> 
            <form id="form" action="<c:url value='/movimentaron'/>" method="post">
            <input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>
            <input type="submit" value="ON" id="enviar">
        </form>
           <hr/> 
            <form id="form" action="<c:url value='/movimentaroff'/>" method="post">
            <input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>
            <input type="submit" value="OFF" id="enviar">
        </form>
    </body>
</html>