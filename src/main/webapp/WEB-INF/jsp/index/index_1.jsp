<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto LEONA</title>
        <link href="<c:url value="./resources/css/bootstrap.css"/>" rel="stylesheet">
        <link href="<c:url value="./resources/css/half-slider.css"/>" rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse navbar-ex1-collapse ">
                    <ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/'/>">Inicio</a>
                        </li>
                        <li><a href="<c:url value='/cadastroUsuario'/>">Cadastrar</a></li>
                        <li><a href="<c:url value='/login'/>">Login</a>
                        </li>
                        <li><a href="<c:url value='/contato'/>">Contato</a>
                        </li>
                        <li><a href="<c:url value='/img'/>">Imagem</a>
                        </li>

                    </ul>
                </div>
            </div>
        </nav>
<br/><br/><br/><br/><br/><br/><br/>
<div class="container">
oi inicio
<p><img src="<c:url value='./resources/img/baixo.png'/>" width="100" height="80"></p>
<img src="file:///C:/node.png" width="100" height="80" ><br/>
oi fim
</div>

        <div class="container">
            
            <hr>
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p align="center">&copy; Grupo LEONA 2014</p>
                    </div>
                </div>
            </footer>
        </div>
        <script src="<c:url value="./resources/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="./resources/js/bootstrap.js"/>"></script>
        <script>
            $('.carousel').carousel({
                interval: 5000
            })
        </script>

    </body>
</html>