<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<html>

    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Cadastrar Estação | Projeto LEONA</title>

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
            <br/>  
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" align="center"> Cadastrar Estação </h1>
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
                                <h3><select name="estacao.estado" value="${estacao.estado}" name="Estados" id="estado" class="form-control">
                                        <option value="0">Selecione o Estado</option>
                                        <option value="Acre">Acre</option>
                                        <option value="Alagoas">Alagoas</option>
                                        <option value="Amapá">Amapá</option>
                                        <option value="Amazonas">Amazonas</option>
                                        <option value="Bahia">Bahia</option>
                                        <option value="Ceará">Ceará</option>
                                        <option value="Distrito Federal">Distrito Federal</option>
                                        <option value="Espirito Santo">Espirito Santo</option>
                                        <option value="Goiás">Goiás</option>
                                        <option value="Maranhão">Maranhão</option>
                                        <option value="Mato Grosso do Sul">Mato Grosso do Sul</option>
                                        <option value="Mato Grosso">Mato Grosso</option>
                                        <option value="Minas Gerais">Minas Gerais</option>
                                        <option value="Pará">Pará</option>
                                        <option value="Paraíba">Paraíba</option>
                                        <option value="Paraná">Paraná</option>
                                        <option value="Pernambuco">Pernambuco</option>
                                        <option value="Piauí">Piauí</option>
                                        <option value="Rio de Janeiro">Rio de Janeiro</option>
                                        <option value="Rio Grande do Norte">Rio Grande do Norte</option>
                                        <option value="Rio Grande do Sul">Rio Grande do Sul</option>
                                        <option value="Rondônia">Rondônia</option>
                                        <option value="Roraima">Roraima</option>
                                        <option value="Santa Catarina">Santa Catarina</option>
                                        <option value="São Paulo">São Paulo</option>
                                        <option value="Sergipe">Sergipe</option>
                                        <option value="Tocantins">Tocantins</option>
                                    </select>
                                    <!--<input type="text" name="estacao.estado" value="${estacao.estado}" class="form-control" id="estado" placeholder="Estado"/>-->
                                </h3>
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
