<%-- 
    Document   : pastaImagem
    Created on : 12/02/2015, 10:40:57
    Author     : Nicolas Leona
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <h1 align='center'>Observações</h1>
        <hr/>
        <div class="col-md-3"></div>
        <div class="col-md-6">
            <table align="center" id="tabelaObservacoes" class="table" >
                <thead>
                    <tr>
                        <th>Nome</th>

                    </tr>
                </thead>
                <tbody id="pastas">
                    <c:forEach items="${pastas}" var="item">
                        <tr>
                            <td>${item.nome}</td>

                            <td>
                                <form action="<c:url value='/verImagensNome'/>" method="post">
                                    <input type='hidden' name='_method' value='post'/>
                                    <input type='hidden' name='observacao.nome' value='${item.nome}'/>
                                    <input type="submit" value="Ver Imagens"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
