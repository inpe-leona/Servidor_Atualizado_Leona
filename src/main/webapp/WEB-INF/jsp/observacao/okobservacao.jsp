<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Observação</title>
        <link href="<c:url value="./resources/css/bootstrap.css"/>" rel="stylesheet">
        <link href="<c:url value="./resources/css/half-slider.css"/>" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse navbar-ex1-collapse ">
                    <ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/usuario/menu'/>">Inicio</a></li>
                        <li><a href="<c:url value='/cadastroObservacao'/>">Cadastrar Observação</a></li>
                        <li><a href="<c:url value='/listagemObservacao'/>">Ver Observações</a></li>
                    </ul>
                    <div class="right">
                        <ul class="nav navbar-nav navbar-right ">     
                            <li style="color: white; font: bold"><a href="<c:url value='/'/>">Sair</a></li>
                        </ul>    
                    </div>
                </div>
            </div>
        </nav>

        <br/><br/><br/><br/> 
        
        <h1 align="center">Observacação Cadastrada com Sucesso!</h1>
    </body>
</html>
