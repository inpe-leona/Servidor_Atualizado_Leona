<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastrar Observação | Projeto Leona</title>

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
                        <li><a href="<c:url value='/estacao'/>">Estações</a></li>
                        <li><a href="<c:url value='/listagem'/>">Usuários</a></li>
                        <li><a href="<c:url value='/observacao'/>">Observações</a></li>
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
                <a href="<c:url value='/usuario/menu'/>">Menu Principal</a> / <a href="<c:url value='/'/>">Sair</a>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Cadastrar Observação </h1>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <form action="<c:url value='/cadastrarObservacao'/>" method="post">
                        <div class="row" align="center">
                            <div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <!--<h3>Nome: <input type="text" name="obs.nome" placeholder="Nome" class="form-control" id="nome" value="${obs.nome}"/> </h3>-->
                                <h3>Nome: <input type="text" name="observacao.nome" placeholder="Nome" class="form-control" id="nome" value="${observacao.nome}"/> </h3>
                            </div>
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Estação: <input type="text" name="observacao.Estacoes" value="${observacao.estacoes}" class="form-control" id="cidade" placeholder="Estação"/></h3>                                
                                <!--<h3>Estação: <input type="text" name="obs.Estacoes" value="${obs.estacao}" class="form-control" id="cidade" placeholder="Estação"/></h3>-->
                            </div>
                            <div class="clearfix"></div>         
                            <!--<div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Data: <br/>
                                    <input type="text" placeholder="Dia" name="obs.dia" value="${obs.dia}" style="width: 20%"/> / 
                                    <input type="text" placeholder="Mês" name="obs.mes" value="${obs.mes}" style="width: 20%"/> / 
                                    <input type="text" placeholder="Ano" name="obs.ano" value="${obs.ano}" style="width: 20%"/>                                
                                </h3>
                            </div>                           
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>
                                    Hora Início: <br/><input type="text" name="obs.horaInicio" style="width: 20%" value="${obs.horaInicio}" placeholder="Hora"/> - <input type="text" name="obs.minutoInicio" value="${obs.minutoInicio}" style="width: 20%" placeholder="Min"/> <br/><hr>
                                    Hora Término: <br/><input type="text" name="obs.horaFim" style="width: 20%" value="${obs.horaFim}" placeholder="Hora"/> - <input type="text" name="obs.minutoFim" value="${obs.minutoFim}" style="width: 20%" placeholder="Min"/> <br/>
                                </h3>
                            </div>-->
                            <div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Data e Hora Inicio: <input type="datetime-local" name="observacao.dataHoraInicio" value="${observacao.dataHoraInicio}" class="form-control" placeholder="Data e Hora Inicio"/></h3>
                            </div>                           
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Data e Hora Fim: <input type="datetime-local" name="observacao.dataHoraFim" value="${observacao.dataHoraFim}" class="form-control" id="cidade" placeholder="Data e Hora Fim"/></h3>
                            </div>
                            <hr/>
                            <div class="clearfix"></div><br/>
                            <div class="form-group col-lg-12">
                                <input type="submit" value="Salvar" id="salvar" class="btn btn-primary"/>
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
