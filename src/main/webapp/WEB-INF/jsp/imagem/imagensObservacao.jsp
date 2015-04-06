<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<jsp:useBean id="dao" class="br.leona.servidor.service.ImagemService" scope="session"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<link href="<c:url value="./resources/css/bootstrap.css"/>" rel="stylesheet">
<link href="<c:url value="./resources/css/half-slider.css"/>" rel="stylesheet">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <%
        String naame = (String) session.getAttribute("nome");
        %>
        <h1 align='center'><%=naame%></h1>
        <hr/>
        <div class="container">
            <%
                List<String> as = dao.pegarCaminhosImagens(naame);

                for (String contato : as) {
            %>
            <div class="col-md-4"><a href="<%=contato%>"><img src="<%=contato%>" style="height: 250px"></a><p></p></div>
                    <%
                        }
                    %>
        </div>
    </body>
</html>
