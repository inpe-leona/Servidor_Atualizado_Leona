<%-- 
    Document   : ReceptCam
    Created on : 15/12/2014, 10:57:19
    Author     : LEONA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Receptor</title>
    </head>
    <body>
        <center>
            <applet code="org.receptor.form.AppletReceptor"               
                    codetype="application/java"
                    archive="ReceptorCam.jar" width="300" height="250">             
                <PARAM NAME="server" VALUE="150.163.46.138"/>
                <PARAM NAME="port" VALUE="1235"/>
            </applet> 
        </center>
    </body>
</html>
