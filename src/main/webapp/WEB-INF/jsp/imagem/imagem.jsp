<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão de Imagem</title>
        <link href="<c:url value="./resources/css/bootstrap.css"/>" rel="stylesheet">
        <link href="<c:url value="./resources/css/half-slider.css"/>" rel="stylesheet">
        <script src="http://code.jquery.com/jquery-latest.js"></script>
        <script>
            $(document).ready(function () {
                $('#iniciarGravacao').click(function (event) {
                    $.get('IniciarGravacaoServlet', function (responseText) {
                    });
                });
                $('#pararGravacao').click(function (event) {
                    $.get('PararGravacaoServlet', function (responseText) {
                    });
                });
                $('#ligarCamera').click(function (event) {
                    $.get('LigarCameraServlet', function (responseText) {
                    });
                });
                $('#desligarCamera').click(function (event) {
                    $.get('DesligarCameraServlet', function (responseText) {
                    });
                });
                $('#buscarImagem').click(function (event) {
                    $.get('BuscarImagemServlet', function (responseText) {
                    });
                });
            });
        </script>       
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse navbar-ex1-collapse ">
                    <ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/'/>">Inicio</a></li>
                        <li><a href="<c:url value='/imagem'/>">Gestão de Imagem</a></li>   
                        <li><a href="<c:url value='/observacao'/>">Gestão de Observação</a></li> 
                    </ul>
                </div>
            </div>
        </nav>

        <br/><br/><br/><br/> 

        <h1 align="center">Gestão de Imagem</h1>
        <hr/>
        <div id="body" class="container">
            <hr/>
            <div class="col-md-6" align="center">
                <input type="button" id="ligarCamera" class="btn btn-info" value="Ligar Camera"/>
            </div>
            <div class="col-md-6" align="center">
                <input type="button" id="desligarCamera" class="btn btn-info" value="Desligar Camera"/>
            </div>
            <hr/>
            <div class="col-md-6" align="center">
                <input type="button" id="iniciarGravacao" class="btn btn-info" value="Iniciar Captura"/>
            </div>
            <div class="col-md-6" align="center">
                <input type="button" id="pararGravacao" class="btn btn-info" value="Parar Captura"/>
            </div>
            <hr/>
            <div class="col-md-6" align="center">
                <input type="button" id="buscarImagem" class="btn btn-info" value="Salvar Imagens"/>
            </div>
            <div class="col-md-6" align="center">
                <a href="<c:url value='/listaObservacoes'/>"><input type="button" class="btn btn-info" value="Ver Imagens"/></a>
            </div>
        </div>

        <br/><br/>

        <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p align="center">&copy; Grupo LEONA 2014</p>
                </div>
            </div>
        </footer>

        <script src="<c:url value="./resources/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="./resources/js/bootstrap.js"/>"></script>
    </body>
</html>
