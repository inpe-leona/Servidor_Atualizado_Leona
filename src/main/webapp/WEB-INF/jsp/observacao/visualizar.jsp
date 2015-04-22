<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Ver Observação | LEONA</title>
        <script src="http://code.jquery.com/jquery-latest.js">
        </script>
        
        <script>
            $(document).ready(function () {
                $('#iniciarGravacao').click(function (event) {
                    alert("oi");
                    $.get('PantiltGravacaoServlet', {variavel: 1}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('#pararGravacao').click(function (event) {
                    var iniciarGravacao = $('#pararGravacao').val();
                    $.get('PantiltGravacaoServlet', {variavel: 0}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('#azimute').click(function (event) {
                    var azimute = $('#azimuteGraus').val();
                    $.get('PantiltAzimuteServlet', {azimute: azimute}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>

        <script>
            $(document).ready(function () {
                $('#elevacao').click(function (event) {
                    var elevacao = $('#elevacaoGraus').val();
                    $.get('PantiltElevacaoServlet', {elevacao: elevacao}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>

        <script>
            $(document).ready(function () {
                $('#right').click(function (event) {
                    var graus = $('#graus').val();
                    $.get('PantiltRightServlet', {graus: graus}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('#up').click(function (event) {
                    var graus = $('#graus').val();
                    $.get('PantiltUpServlet', {graus: graus}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('#down').click(function (event) {
                    var graus = $('#graus').val();
                    $.get('PantiltDownServlet', {graus: graus}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>
        <script>
            $(document).ready(function () {
                $('#reset').click(function (event) {
                    var graus = $('#graus').val();
                    $.get('PantiltResetServlet', {graus: graus}, function (responseText) {
                        $('#welcometext').text(responseText);
                    });
                });
            });
        </script>
        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/half-slider.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/modern-business.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/> 
    </head>
    <body>
        <div class="span12">
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
            <br/>
            <table align="center">    
                
                <tr>
                    <td align="center">
                    </td>
                    <td align="left">
                        <h4>Azimute: </h4>
                    </td>
                    <td align="center">
                        <input type="text" placeholder="" id="azimuteGraus"/>
                    </td>
                    <td align="left">
                        Range: 0º a 350º
                    </td>
                    <td align="left">
                        <input type="button" id="azimute" value="Mover"/>
                    </td>
                </tr>
                <tr>
                    <td align="center">

                    </td>
                    <td align="left">
                        <!--<input type="button" id="left" value="Left"/>-->
                        <h4>Elevação: </h4>
                    </td>
                    <td align="center">
                        <input type="text" placeholder="" id="elevacaoGraus"/>
                    </td>
                    <td align="left">
                        <!--<input type="button" id="right" value="Right"/>-->
                        Range: 0º a 60º
                    </td>
                    <td align="center">
                        <input type="button" id="elevacao" value="Mover"/>
                    </td>
                </tr>                
                <tr>
                    <td align="center">

                    </td>
                    <td align="center">
                        <p>Posição atual azimut: ${positionazi}</p>
                    </td>
                    <td align="center">

                    </td>
                    <td align="center">
                        <p>Posição atual elevação: ${positionele}</p>
                    </td>
                    <td align="center">

                    </td>
                </tr>
            </table>
                    
            <h2 style="color:black">Nome da Observação: ${observation.nome}</h2>
            <h4><input type="button" id="reset" value="Reset"/></h4>
            <hr>            
            <br>
            <div align="center">
            
                <applet code="org.receptor.form.FormReceptApplet"               
                       codetype="application/java"
                       archive="ReceptorCam.jar" width="600" height="450">            
                   <param name="server" value="150.163.46.137">
                   <param name="port" value="1235">
               </applet> 
            
            </div>
        </div>
    </body>   
</html>