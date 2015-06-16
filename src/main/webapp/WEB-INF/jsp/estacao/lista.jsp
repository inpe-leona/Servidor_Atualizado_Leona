<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<html>

    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Esta��es | Projeto LEONA</title>

        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/half-slider.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/modern-business.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/>
    </head>
    <body>
        <nav class="navbar navbar-fixed-top navbar-inverse" role="navigation">
            <div class="container">
                <div class="collapse navbar-collapse navbar-ex1-collapse ">
                    <ul class="nav navbar-nav ">
                        <li><a href="<c:url value='/usuario/menuadm'/>">Inicio</a></li>
                        <li><a href="<c:url value='/relatorioUsuarios'/>">Usu�rios</a></li>   
                        <li><a href="<c:url value='/listagemEstacao'/>">Esta��es</a></li> 
                        <li><a href="<c:url value='/listagemObservacao'/>">Observa��es</a></li>
                    </ul>
                    <div class="right">
                        <ul class="nav navbar-nav navbar-right ">     
                            <li style="color: white; font: bold"><a href="<c:url value='/'/>">Sair</a></li>
                        </ul>    
                    </div>
                </div>
            </div>
        </nav>

        <div class="container">
            <br/>            
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Esta��es </h1><br/>
                    <a href="<c:url value='/cadastroEstacao'/>"><button type="button" class="btn btn-info">Cadastrar Esta��o</button></a>
                </div>
            </div>

            <table align="center" class="table" >
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>IP</th>
                        <th>Estado</th>
                        <th>Cidade</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${estacaoList}" var="item">
                        <tr>
                            <td>${item.nome}</td>
                            <td>${item.ip}</td>
                            <td>${item.estado}</td>
                            <td>${item.cidade}</td>
                            <td>${item.status}</td>
                            <!--<td>
                                <form action="<c:url value='/ping'/>" method="post">
                                    <input type='hidden' name='_method' value='post'/>
                                    <input type='hidden' name='estacao.id' value='${item.id}'/>
                                    <input type="submit" value="Ping"/>
                                </form>
                            </td>-->
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
