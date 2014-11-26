
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
        <title>Visualizar Observação | Projeto LEONA</title>
        <meta name="author" content="An Xiao Mina and Elizabeth Gin" />

        <meta name="description" content="Tech Survey for Uganda" />

        <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/half-slider.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/css/modern-business.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/resources/font-awesome/css/font-awesome.min.css"/>" rel="stylesheet"/>
        <script src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="resources/_webCam/js/jquery.webcam.js"></script>
        <style type="text/css">



            #canvas {
                margin-top: 45px;
            }

            #webcam {

                alignment-baseline: central;
                margin-top:50px;
                margin-bottom:500px;
            }

            #webcam > span {
                z-index:2;
                position:absolute;
                color:#eee;
                font-size:10px;
                bottom: -16px;
                left:152px;
            }

            #webcam > img {
                z-index:1;
                position:absolute;
                border:0px none;
                padding:0px;
                bottom:-40px;
                left:40px;
            }

            #filter {
                border:5px solid #82394C;
                padding:5px;
                -webkit-border-radius: 8px;
                -moz-border-radius: 8px;
                border-radius: 8px;
                cursor:pointer;
                float: left;
            }

            #webcam a {
                background:#fff;
                font-weight:bold;
            }

            #webcam a > img {
                border:0px none;
            }

            #canvas {
                border:20px solid #AD2B4E;
                background:#eee;
            }

            #flash {
                position:absolute;
                top:0px;
                left:0px;
                z-index:5000;
                width:100%;
                height:500px;
                background-color:#c00;
                display:none;
            }

            object {
                display:block; /* HTML5 fix */
                position:relative;
                z-index:1000;
            }

        </style>
        <script src="http://code.jquery.com/jquery-latest.js">
        </script>
        <script>
            $(document).ready(function () {
                $('#left').click(function (event) {
                    var graus = $('#graus').val();
                    $.get('PantiltLeftServlet', {graus: graus}, function (responseText) {
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
    </head>
    <body>
        <div class="span12">
            <nav class="navbar navbar-fixed-top navbar-inverse " role="navigation">
                <div class="container">
                    <div class="collapse navbar-collapse navbar-ex1-collapse ">
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
            <br/><br/><br/>
            <table align="center">
                <tr>
                    <td>

                    </td>
                    <td align="center">
                        <form id="form" action="<c:url value='/movimentaron'/>" method="post">
                            <!--<input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>-->
                            <input type="submit" value="Ligar Câmera" id="enviar">
                        </form>
                    </td>
                    <td align="center">
                        <form id="form" action="<c:url value='/movimentarreset'/>" method="post">
                            <!--<input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>-->
                            <input type="submit" value="RESET" id="enviar">
                        </form>
                    </td>
                    <td align="center">
                        <form id="form" action="<c:url value='/movimentaroff'/>" method="post">
                            <!--<input type="text" placeholder="Graus" name="pantilt.graus" value="${pantilt.graus}" id="graus"/>-->
                            <input type="submit" value="Desligar Câmera" id="enviar">
                        </form>
                    </td>
                    <td>

                    </td>
                </tr>
                <tr>
                    <td align="center">

                    </td>
                    <td align="center">

                    </td>
                    <td align="center">
                        <input type="button" id="up" value="UP"/>
                    </td>
                    <td align="center">

                    </td>
                    <td align="center">

                    </td>
                </tr>
                <tr>
                    <td align="center">

                    </td>
                    <td align="left">
                        <input type="button" id="left" value="Left"/>
                    </td>
                    <td align="center">
                        <input type="text" placeholder="Digite os Graus" id="graus"/>
                    </td>
                    <td align="right">
                        <input type="button" id="right" value="Right"/>
                    </td>
                    <td align="center">

                    </td>
                </tr>
                <tr>
                    <td align="center">

                    </td>
                    <td align="center">

                    </td>
                    <td align="center">
                        <input type="button" id="down" value="DOWN"/>
                    </td>
                    <td align="center">

                    </td>
                    <td align="center">

                    </td>
                </tr>
            </table>

            <h2 style="color:black">Nome da Observação: ${observation.nome}</h2>
            <hr>

            <div >
                <p id="status"></p>
                <div id="webcam"></div>
                <script type="text/javascript">

                    var pos = 0;
                    var ctx = null;
                    var cam = null;
                    var image = null;

                    var filter_on = false;
                    var filter_id = 0;

                    function changeFilter() {
                        if (filter_on) {
                            filter_id = (filter_id + 1) & 7;
                        }
                    }

                    function toggleFilter(obj) {
                        if (filter_on = !filter_on) {
                            obj.parentNode.style.borderColor = "#007046";
                        } else {
                            obj.parentNode.style.borderColor = "#82394C";
                        }
                    }

                    jQuery("#webcam").webcam({
                        width: 1600,
                        height: 240,
                        mode: "callback",
                        swffile: "resources/_webCam/download/jscam_canvas_only.swf",
                        onTick: function (remain) {

                            if (0 == remain) {
                                jQuery("#status").text("Cheese!");
                            } else {
                                jQuery("#status").text(remain + " seconds remaining...");
                            }
                        },
                        onSave: function (data) {

                            var col = data.split(";");
                            var img = image;

                            if (false == filter_on) {

                                for (var i = 0; i < 320; i++) {
                                    var tmp = parseInt(col[i]);
                                    img.data[pos + 0] = (tmp >> 16) & 0xff;
                                    img.data[pos + 1] = (tmp >> 8) & 0xff;
                                    img.data[pos + 2] = tmp & 0xff;
                                    img.data[pos + 3] = 0xff;
                                    pos += 4;
                                }

                            } else {

                                var id = filter_id;
                                var r, g, b;
                                var r1 = Math.floor(Math.random() * 255);
                                var r2 = Math.floor(Math.random() * 255);
                                var r3 = Math.floor(Math.random() * 255);

                                for (var i = 0; i < 320; i++) {
                                    var tmp = parseInt(col[i]);

                                    /* Copied some xcolor methods here to be faster than calling all methods inside of xcolor and to not serve complete library with every req */

                                    if (id == 0) {
                                        r = (tmp >> 16) & 0xff;
                                        g = 0xff;
                                        b = 0xff;
                                    } else if (id == 1) {
                                        r = 0xff;
                                        g = (tmp >> 8) & 0xff;
                                        b = 0xff;
                                    } else if (id == 2) {
                                        r = 0xff;
                                        g = 0xff;
                                        b = tmp & 0xff;
                                    } else if (id == 3) {
                                        r = 0xff ^ ((tmp >> 16) & 0xff);
                                        g = 0xff ^ ((tmp >> 8) & 0xff);
                                        b = 0xff ^ (tmp & 0xff);
                                    } else if (id == 4) {

                                        r = (tmp >> 16) & 0xff;
                                        g = (tmp >> 8) & 0xff;
                                        b = tmp & 0xff;
                                        var v = Math.min(Math.floor(.35 + 13 * (r + g + b) / 60), 255);
                                        r = v;
                                        g = v;
                                        b = v;
                                    } else if (id == 5) {
                                        r = (tmp >> 16) & 0xff;
                                        g = (tmp >> 8) & 0xff;
                                        b = tmp & 0xff;
                                        if ((r += 32) < 0)
                                            r = 0;
                                        if ((g += 32) < 0)
                                            g = 0;
                                        if ((b += 32) < 0)
                                            b = 0;
                                    } else if (id == 6) {
                                        r = (tmp >> 16) & 0xff;
                                        g = (tmp >> 8) & 0xff;
                                        b = tmp & 0xff;
                                        if ((r -= 32) < 0)
                                            r = 0;
                                        if ((g -= 32) < 0)
                                            g = 0;
                                        if ((b -= 32) < 0)
                                            b = 0;
                                    } else if (id == 7) {
                                        r = (tmp >> 16) & 0xff;
                                        g = (tmp >> 8) & 0xff;
                                        b = tmp & 0xff;
                                        r = Math.floor(r / 255 * r1);
                                        g = Math.floor(g / 255 * r2);
                                        b = Math.floor(b / 255 * r3);
                                    }

                                    img.data[pos + 0] = r;
                                    img.data[pos + 1] = g;
                                    img.data[pos + 2] = b;
                                    img.data[pos + 3] = 0xff;
                                    pos += 4;
                                }
                            }

                            if (pos >= 0x4B000) {
                                ctx.putImageData(img, 0, 0);
                                pos = 0;
                            }
                        },
                        onCapture: function () {
                            webcam.save();

                            jQuery("#flash").css("display", "block");
                            jQuery("#flash").fadeOut(100, function () {
                                jQuery("#flash").css("opacity", 1);
                            });
                        },
                        debug: function (type, string) {
                            jQuery("#status").html(type + ": " + string);
                        },
                        onLoad: function () {

                            var cams = webcam.getCameraList();
                            for (var i in cams) {
                                jQuery("#cams").append("<li>" + cams[i] + "</li>");
                            }
                        }
                    });

                    function getPageSize() {

                        var xScroll, yScroll;

                        if (window.innerHeight && window.scrollMaxY) {
                            xScroll = window.innerWidth + window.scrollMaxX;
                            yScroll = window.innerHeight + window.scrollMaxY;
                        } else if (document.body.scrollHeight > document.body.offsetHeight) { // all but Explorer Mac
                            xScroll = document.body.scrollWidth;
                            yScroll = document.body.scrollHeight;
                        } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari
                            xScroll = document.body.offsetWidth;
                            yScroll = document.body.offsetHeight;
                        }

                        var windowWidth, windowHeight;

                        if (self.innerHeight) { // all except Explorer
                            if (document.documentElement.clientWidth) {
                                windowWidth = document.documentElement.clientWidth;
                            } else {
                                windowWidth = self.innerWidth;
                            }
                            windowHeight = self.innerHeight;
                        } else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode
                            windowWidth = document.documentElement.clientWidth;
                            windowHeight = document.documentElement.clientHeight;
                        } else if (document.body) { // other Explorers
                            windowWidth = document.body.clientWidth;
                            windowHeight = document.body.clientHeight;
                        }

                        // for small pages with total height less then height of the viewport
                        if (yScroll < windowHeight) {
                            pageHeight = windowHeight;
                        } else {
                            pageHeight = yScroll;
                        }

                        // for small pages with total width less then width of the viewport
                        if (xScroll < windowWidth) {
                            pageWidth = xScroll;
                        } else {
                            pageWidth = windowWidth;
                        }

                        return [pageWidth, pageHeight];
                    }

                    window.addEventListener("load", function () {

                        jQuery("body").append("<div id=\"flash\"></div>");

                        var canvas = document.getElementById("canvas");

                        if (canvas.getContext) {
                            ctx = document.getElementById("canvas").getContext("2d");
                            ctx.clearRect(0, 0, 320, 240);

                            var img = new Image();
                            img.src = "resources/_webCam/image/smiley.png";
                            img.onload = function () {
                                ctx.drawImage(img, 115, 70);
                            }
                            image = ctx.getImageData(0, 0, 320, 240);
                        }

                        var pageSize = getPageSize();
                        jQuery("#flash").css({height: pageSize[1] + "px"});

                    }, false);

                    window.addEventListener("resize", function () {

                        var pageSize = getPageSize();
                        jQuery("#flash").css({height: pageSize[1] + "px"});

                    }, false);

                </script>

            </div>
            <br>
        </div>
    </body>   
</html>
