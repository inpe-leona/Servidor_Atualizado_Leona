<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<html>

    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Cadastrar Esta��o | Projeto LEONA</title>

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
                        <li><a href="<c:url value='/imagem'/>">Gest�o de Imagem</a></li>   
                        <li><a href="<c:url value='/observacao'/>">Gest�o de Observa��o</a></li> 
                        <li><a href="<c:url value='/usuario'/>">Gest�o de Usu�rio</a></li> 
                        <li><a href="<c:url value='/estacao'/>">Gest�o de Estacao</a></li> 
                    </ul>                    
                </div>
            </div>
        </nav>

        <div class="container">
            <br/>  
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Cadastrar Esta��o </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <form action="<c:url value='/cadastrarEstacao'/>" method="post">
                        <div class="row" align="center">
                            <div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Nome: <input type="text" name="estacao.nome" placeholder="Nome" class="form-control" id="nome" value="${estacao.nome}"/> </h3>
                            </div>
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>IP: <input type="text" name="estacao.ip" value="${estacao.ip}" class="form-control" id="ip" placeholder="IP"/></h3>
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-1" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Estado: <!--<select value="estacao.estado" name="Estados" class="form-control">
                                        <option value="0">Selecione o Estado</option>
                                        <option value="ac">Acre</option>
                                        <option value="al">Alagoas</option>
                                        <option value="ap">Amap�</option>
                                        <option value="am">Amazonas</option>
                                        <option value="ba">Bahia</option>
                                        <option value="ce">Cear�</option>
                                        <option value="df">Distrito Federal</option>
                                        <option value="es">Espirito Santo</option>
                                        <option value="go">Goi�s</option>
                                        <option value="ma">Maranh�o</option>
                                        <option value="ms">Mato Grosso do Sul</option>
                                        <option value="mt">Mato Grosso</option>
                                        <option value="mg">Minas Gerais</option>
                                        <option value="pa">Par�</option>
                                        <option value="pb">Para�ba</option>
                                        <option value="pr">Paran�</option>
                                        <option value="pe">Pernambuco</option>
                                        <option value="pi">Piau�</option>
                                        <option value="rj">Rio de Janeiro</option>
                                        <option value="rn">Rio Grande do Norte</option>
                                        <option value="rs">Rio Grande do Sul</option>
                                        <option value="ro">Rond�nia</option>
                                        <option value="rr">Roraima</option>
                                        <option value="sc">Santa Catarina</option>
                                        <option value="sp">S�o Paulo</option>
                                        <option value="se">Sergipe</option>
                                        <option value="to">Tocantins</option>
                                    </select>--> 
                                    <input type="text" name="estacao.estado" value="${estacao.estado}" class="form-control" id="estado" placeholder="Estado"/></h3>
                            </div>
                            <div class="form-group col-lg-2" align="center"></div>
                            <div class="form-group col-lg-4" align="center">
                                <h3>Cidade: <input type="text" name="estacao.cidade" value="${estacao.cidade}" class="form-control" id="cidade" placeholder="Cidade"/></h3>
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
