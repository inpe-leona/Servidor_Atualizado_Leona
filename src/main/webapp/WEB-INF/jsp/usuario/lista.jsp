<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html>

    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Usuários | Projeto LEONA</title>

        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/half-slider.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/modern-business.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/>

    </head>

    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">

                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <<ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/'/>">Inicio</a></li>
                        <li><a href="<c:url value='/imagem'/>">Gestão de Imagem</a></li>   
                        <li><a href="<c:url value='/observacao'/>">Gestão de Observação</a></li> 
                        <li><a href="<c:url value='/usuario'/>">Gestão de Usuário</a></li> 
                        <li><a href="<c:url value='/estacao'/>">Gestão de Estacao</a></li> 
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container" >
            <br/>
            <div class="row" align="right">
                <a href="<c:url value='/usuario/menuadm'/>">Menu Principal</a> / <a href="<c:url value='/'/>">Sair</a>
            </div>


            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Usuários </h1><br/>
                </div>
            </div>

            <table align="center" id="tabelaFuncionarios" class="table" >
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Status</th>
                        <th>E-mail</th>
                        <th>Tipo</th>

                    </tr>
                </thead>
                <tbody id="usuariolist">
                    <c:forEach items="${usuarioList}" var="item">
                        <tr>
                            <td>${item.nome}</td>
                            <td>${item.status}</td>
                            <td>${item.email}</td>
                            <td>${item.tipo}</td>
                            <td>
                                <form action="<c:url value='/alterarStatusUsuario'/>" method="post">
                                    <input type='hidden' name='_method' value='post'/>
                                    <input type='hidden' name='usuario.id' value='${item.id}'/>
                                    <input type="submit" value="Alterar Status"/>
                                </form>
                            </td>
                            <td>
                                <form action="<c:url value='/alterarTipoUsuario'/>" method="post">
                                    <input type='hidden' name='_method' value='post'/>
                                    <input type='hidden' name='usuario.id' value='${item.id}'/>
                                    <input type="submit" value="Alterar Tipo"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="container">
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