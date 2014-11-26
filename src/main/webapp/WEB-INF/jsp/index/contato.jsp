<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
<html>

    <head>        
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <title>Contato | Projeto LEONA</title>
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
                        <li><a href="<c:url value='/cadastroUsuario'/>">Cadastrar</a></li>
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
                    <h1 class="page-header">Contato </h1>
                </div>
                <div class="col-lg-12">
                    <iframe width="100%" height="400px" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com.br/maps?f=q&amp;source=s_q&amp;hl=pt-BR&amp;geocode=&amp;q=INPE+-+INSTITUTO+NACIONAL+DE+PESQUISAS+ESPACIAIS+-+Avenida+dos+Astronautas,+S%C3%A3o+Jos%C3%A9+dos+Campos+-+SP&amp;aq=0&amp;oq=IN&amp;sll=-23.206922,-45.859394&amp;sspn=0.00851,0.007403&amp;ie=UTF8&amp;hq=INPE+-+INSTITUTO+NACIONAL+DE+PESQUISAS+ESPACIAIS+-&amp;hnear=Avenida+dos+Astronautas,+S%C3%A3o+Jos%C3%A9+dos+Campos+-+S%C3%A3o+Paulo&amp;t=m&amp;ll=-23.206922,-45.859394&amp;spn=0.006295,0.006295&amp;output=embed"></iframe><br /><small><a href="https://www.google.com.br/maps?f=q&amp;source=embed&amp;hl=pt-BR&amp;geocode=&amp;q=INPE+-+INSTITUTO+NACIONAL+DE+PESQUISAS+ESPACIAIS+-+Avenida+dos+Astronautas,+S%C3%A3o+Jos%C3%A9+dos+Campos+-+SP&amp;aq=0&amp;oq=IN&amp;sll=-23.206922,-45.859394&amp;sspn=0.00851,0.007403&amp;ie=UTF8&amp;hq=INPE+-+INSTITUTO+NACIONAL+DE+PESQUISAS+ESPACIAIS+-&amp;hnear=Avenida+dos+Astronautas,+S%C3%A3o+Jos%C3%A9+dos+Campos+-+S%C3%A3o+Paulo&amp;t=m&amp;ll=-23.206922,-45.859394&amp;spn=0.006295,0.006295" style="color:#0000FF;text-align:left">Exibir mapa ampliado</a></small>                    
                </div>
            </div>

            <div class="row" ng-controller="ObjetoEmail">
                <div class="col-sm-8">
                    <h3>Formulário de Contato</h3>
                    <form ng-controller="MandarEmail">
                        <div class="row">
                            <div class="form-group col-lg-6">
                                <label for="input1">Nome</label>
                                <input type="text" name="contact_name" class="form-control" id="input1" ng-model="EMAIL.Nome">
                            </div>
                            <div class="form-group col-lg-6">
                                <label for="input3">Email</label>
                                <input type="phone" name="contact_phone" class="form-control" id="input3" ng-model="EMAIL.Email">
                            </div>
                            <div class="clearfix"></div>
                            <div class="form-group col-lg-12">
                                <label for="input4">Messagem</label>
                                <textarea name="contact_message" class="form-control" rows="6" id="input4" ng-model="EMAIL.Mensagem"></textarea>
                            </div>
                            <div class="form-group col-lg-12">
                                <input type="hidden" name="save" value="contact">
                                    <button type="submit" class="btn btn-primary" ng-click="EnvioEmailServer()" onclick="Ativar()">Enviar</button>
                                    <label id="lblMensagem" style="color:red; visibility: hidden">Enviando...</label>
                                    <label id="lblok" style="color:red; visibility: hidden">Mensagem Enviada com sucesso!</label>
                                    <label id="lblErro" style="color:red; visibility: hidden">Houve um erro! Entre em contato pelo e-mail ao lado!</label>
                                    <label id="lblValidacao" style="color:red; visibility: hidden">Todos os Campos são Obrigatórios</label>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="col-sm-4">
                    <h3>Integrantes do Projeto</h3>
                    <li>Eduardo Guerra</li>
                    <li>Fernanda São Sabbas</li>
                    <li>Jean Negrão</li>
                    <li>Livia Miura</li>
                    <li>Marcela Façanha</li>
                    <li>Nicolas Fontes</li>
                    <hr>
                        <h3>Contato</h3>
                        <p><i class="fa fa-envelope-o"></i> <abbr title="Email">Email</abbr>: <a href="mailto:nicolas.rfontes@gmail.com">nicolas.rfontes@gmail.com</a></p>
                </div>
            </div>
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

        <script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="/resources/js/bootstrap.js"/>"></script>

        <script>
                        $('.carousel').carousel({
                            interval: 5000
                        })
        </script>

    </body>

</html>