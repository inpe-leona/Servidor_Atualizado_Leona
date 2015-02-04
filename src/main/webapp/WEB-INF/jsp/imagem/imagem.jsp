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
                    $.get('IniciarGravacaoServlet', function (responseText) {});
                });
                $('#pararGravacao').click(function (event) {
                    $.get('PararGravacaoServlet', function (responseText) {});
                });
            });
        </script>       
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse navbar-ex1-collapse ">
                    <ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/'/>">Inicio</a>
                        </li>
                        <li><a href="<c:url value='/imagem'/>">Gestão de Imagem</a></li>
                        <!--<li><a href="<c:url value='/login'/>">Login</a>
                        </li>
                        <li><a href="<c:url value='/contato'/>">Contato</a>
                        </li>
                        <li><a href="<c:url value='/img'/>">Imagem</a>
                        </li>-->

                    </ul>
                </div>
            </div>
        </nav>

        <br/><br/><br/><br/> 

        <h1 align="center">Gestão de Imagem</h1>
        <hr/>
        <div id="body" class="container">
            <div class="col-md-6" align="center">
                <input type="button" id="iniciarGravacao" class="btn btn-info" value="Iniciar Gravação"/>
            </div>
            <div class="col-md-6" align="center">
                <input type="button" id="pararGravacao" class="btn btn-info" value="Parar Gravação"/>
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
