<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Estação</title>
        <link href="<c:url value="./resources/css/bootstrap.css"/>" rel="stylesheet">
        <link href="<c:url value="./resources/css/half-slider.css"/>" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse navbar-ex1-collapse ">
                    <ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/'/>">Inicio</a></li>
                        <li><a href="<c:url value='/imagem'/>">Gestão de Imagem</a></li>   
                        <li><a href="<c:url value='/observacao'/>">Gestão de Observação</a></li> 
                        <li><a href="<c:url value='/usuario'/>">Gestão de Usuário</a></li> 
                        <li><a href="<c:url value='/estacao'/>">Gestão de Estacao</a></li> 
                    </ul>
                </div>
            </div>
        </nav>

        <br/><br/><br/><br/> 
        
        <h1 align="center">Gestão de Estação</h1>
        <div id="body" class="container">
            <hr/>
            <div class="col-md-6" align="center">
                <a href="<c:url value='/cadastroEstacao'/>"><input type="button" class="btn btn-info" value="Cadastrar Estação"/></a>
            </div>
            <div class="col-md-6" align="center">
                <a href="<c:url value='/relatorioEstacoes'/>"><input type="button" class="btn btn-info" value="Relatórios de Estações"/></a>
            </div>
            <div class="clearfix"></div>
            <hr/>            
        </div>
    </body>
</html>
