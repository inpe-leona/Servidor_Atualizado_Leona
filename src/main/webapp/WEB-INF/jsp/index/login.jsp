<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Login | Projeto LEONA</title>
            <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
            <link href="<c:url value="/resources/css/half-slider.css"/>" rel="stylesheet"/>
            <link href="<c:url value="/resources/css/modern-business.css"/>" rel="stylesheet"/>
            <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">

                <div class="collapse navbar-collapse navbar-ex1-collapse">
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

        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center">Login </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <form action="<c:url value='/logarUsuario'/>" method="post">
                        <div class="row" align="center">
                            <div class="form-group col-lg-4" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <input type="text" name="usuario.email" placeholder="Email" class="form-control" id="input2" value="${usuario.email}"/> 
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-4" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <input type="password" name="usuario.senha" value="${usuario.senha}" class="form-control" id="input1" placeholder="Senha"/>
                            </div>
                            <div class="form-group col-lg-12">
                                <input type="submit" value="Login" class="btn btn-primary"/>
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-4" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h4>Esqueceu a senha?      <a href="<c:url value='/lembrarsenha'/>">Lembrar Senha</a></h4>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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
    </body>
</html>
