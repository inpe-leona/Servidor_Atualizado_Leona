<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<html>

    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Menu Principal | Projeto LEONA</title>

        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/half-slider.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/modern-business.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/>

    </head>

    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse navbar-ex1-collapse ">
                    <ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/'/>">Inicio</a></li>
                        <li><a href="<c:url value='/listagemEstacao'/>">Estações</a></li>
                        <li><a href="<c:url value='/listagemUsuarios'/>">Usuários</a></li>
                        <li><a href="<c:url value='/listagemObservacao'/>">Observações</a></li>
                    </ul>
                    <div class="right">
                        <ul class="nav navbar-nav navbar-right ">     
                            <li style="color: white; font: bold"><a name="username">${username}</a></li>
                        </ul>    
                    </div>
                </div>
            </div>
        </nav>

        <div class="container">

            <br/>
            <div class="row" align="right">
                <a href="<c:url value='/'/>">Sair</a>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Menu Principal do Administrador</h1><br/>
                </div>
            </div>            
            <hr/>
            <br/>
            <div align="center">
                <h4>Este é o Menu Principal</h4>
            </div>

            <div class="container">
                <footer>
                    <div class="row">
                        <div class="col-lg-12">
                            <hr/>
                            <p align="center">&copy; Grupo LEONA 2014</p>
                        </div>
                    </div>
                </footer>
            </div>

        </div>
        <script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>

        <script>
            $('.carousel').carousel({
                interval: 5000
            })
        </script>

    </body>

</html>