    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Observações | Projeto LEONA</title>

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
                        <li><a href="<c:url value='/imagem'/>">Gestão de Imagem</a></li>   
                        <li><a href="<c:url value='/observacao'/>">Gestão de Observação</a></li> 
                        <li><a href="<c:url value='/usuario'/>">Gestão de Usuário</a></li> 
                        <li><a href="<c:url value='/estacao'/>">Gestão de Estacao</a></li> 
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
                <a href="<c:url value='/usuario/menuadm'/>">Menu Principal</a> / <a href="<c:url value='/'/>">Sair</a>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Observações </h1><br/>
                </div>
                <br/>
                <form action="<c:url value='/cadastroObservacao'/>"  method="get">
                    <div class="row" align="center">
                        <input type="submit" value="Cadastrar" class="btn btn-primary"/>
                    </div>
                </form>
            </div>

            <table align="center" id="tabelaObservacoes" class="table" >
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Estação</th>
                        <th>Inicio</th>
                        <th>Fim</th>
                    </tr>
                </thead>
                <tbody id="observacaoList">
                    <c:forEach items="${observacaoList}" var="item">
                        <tr>
                            <td>${item.nome}</td>
                            <td>${item.estacao}</td>
                            <td>${item.dataInicio} - ${item.horaInicio}</td>
                            <td>${item.dataFim} - ${item.horaFim}</td>
                            <td>
                                <form action="<c:url value='/verObservacao'/>" method="post">
                                    <input type='hidden' name='_method' value='post'/>
                                    <input type='hidden' name='observacao.id' value='${item.id}'/>
                                    <input type="submit" value="Ver Observacao"/>
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


