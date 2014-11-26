<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Usuário | Projeto LEONA</title>
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
                        <li><a href="<c:url value='/'/>">Inicio</a>
                        </li>
                        <li><a href="<c:url value='/cadastro'/>">Cadastrar</a></li>
                        <li><a href="<c:url value='/login'/>">Login</a>
                        </li>
                        <li><a href="<c:url value='/contato'/>">Contato</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Cadastrar Novo Usuário </h1>
                </div>
            </div>
            <div class="row" id="1">
                <div class="col-sm-12" id="2">
                    <form id="form" action="<c:url value='/cadastrarUsuario'/>" method="post">
                        <div class="row" align="center">
                            <div class="form-group col-lg-4" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <input type="text" name="usuario.nome" placeholder="Nome" class="form-control" id="nome" value="${usuario.nome}"/> 
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-4" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <input type="text" name="usuario.email" value="${usuario.email}" class="form-control" id="email" placeholder="Email"/>                                
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-4" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <input type="text" name="usuario.senha" value="${usuario.senha}" class="form-control" id="senha" placeholder="Senha"/><small>Deve contar mais de 8 caracteres entre maiusculas, minusculas e números</small>
                            </div>
                            <div class="form-group col-lg-12">
                                <input type="submit" id="salvar" value="Salvar" class="btn btn-primary"/>
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

        <script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
        <script>
            $('.carousel').carousel({
                interval: 5000
            })
        </script>
    </body>
</html>
