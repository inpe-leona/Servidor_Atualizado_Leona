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
                </div>
            </div>
        </nav>
                    
        <br/><br/><br/><br/> 
        <h1 align="center">Gestão de Observação</h1>
        
        <div class="container">
            <div class="row">
                <div class="col-sm-12">
                    <form action="<c:url value='/cadastrarObservacao'/>" method="post">
                        <div class="row" align="center">
                            <div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Nome: <input type="text" name="observacao.nome" placeholder="Nome" class="form-control" id="nome" value="${observacao.nome}"/> </h3>
                            </div>
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Estação: <input type="text" name="observacao.estacao" placeholder="Estação" class="form-control" id="nome" value="${observacao.estacao}"/></h3>
                            </div>
                            <div class="clearfix"></div> 
                            <div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Data Inicio: <input type="text" name="observacao.dataInicio" value="${observacao.dataInicio}" class="form-control" placeholder="Data Inicio"/></h3>
                            </div>                           
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Data Fim: <input type="text" name="observacao.dataFim" value="${observacao.dataFim}" class="form-control" id="cidade" placeholder="Data Fim"/></h3>
                            </div>
                            <hr/>
                            <div class="clearfix"></div><br/>
                            <div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Hora Inicio: <input type="text" name="observacao.horaInicio" value="${observacao.horaInicio}" class="form-control" placeholder="Hora Inicio"/></h3>
                            </div>                           
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Hora Fim: <input type="text" name="observacao.horaFim" value="${observacao.horaFim}" class="form-control" id="cidade" placeholder="Hora Fim"/></h3>
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
