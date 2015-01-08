<%@page contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Projeto LEONA</title>
        <link href="<c:url value="./resources/css/bootstrap.css"/>" rel="stylesheet">
        <link href="<c:url value="./resources/css/half-slider.css"/>" rel="stylesheet">
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
                        <li><a href="<c:url value='/img'/>">Imagem</a>
                        </li>
                        
                    </ul>
                </div>
            </div>
        </nav>

        <div id="myCarousel" class="carousel slide">
            <div class="carousel-inner">
                <div class="item active">
                    <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Projeto LEONA');"></div>
                    <div class="carousel-caption">
                        <h4>Rede Colaborativa na América Latina para a Investigação de Eventos Luminosos Transientes e Emissões de Alta Energia de Tempestades</h4>
                    </div>
                </div>
            </div>
            <a class="left carousel-control"></a>
            <a class="right carousel-control"></a>
        </div>

        <div class="container">
            <div class="row section">
                <div class="col-lg-12">
                    <h1>Detalhes</h1>
                    <p align="justify">Na Divisão de Aeronomia do INPE encontra-se o primeiro grupo de pesquisa desses fenômenos no Brasil, o grupo de Acoplamento Eletrodiâmico Atmosférico e Espacial - ACATMOS, coordenado pela orientadora. Uma das necessidades para a realização de uma pesquisa de qualidade sobre ELTs no Brasil, e na América do Sul em geral, é poder realizar uma coleta consistente de dados desses fenômenos sobre as tempestades elétricas que ocorrem no país e em todo o continente. Nesse intuito, concebemos a criação de uma rede de câmeras para realizar a observação desses fenômenos, que possam ser controladas remotamente via internet. Essas unidades de observação serão instaladas em toda a América do Sul em locais estratégicos para cobrir as regiões de tempestades mais intensas no continente. Irá ser desenvolvido um software centralizado para o armazenamento e gerenciamento para os dados obtidos das estações remotas. Ele irá consistir de uma aplicação web que interage com uma base de dados que irá armazenar informações relativas a observações, com todos os seus dados associados. A partir dela será possível relacionar e organizar as imagens obtidas em eventos, dando acesso aos pesquisadores que irão fazer as análises. A partir dessa aplicação web será também possível controlar as câmeras das estações remotas e fazer a observação dos eventos. Ao criar uma nova observação de eventos, deve ser possível associá-la a estações que irão participar da observação. A partir de um streaming de imagens enviadas, deve ser possível acompanhar a imagem das câmeras e redirecioná-las para ângulos mais adequados. Deve haver também um acesso as estações para o recebimento das imagens obtidas durante a observação.</p>
                </div>
            </div>
            <hr>
            <div class="row section">
                <div class="col-lg-12">
                    <h1>Resultados Esperados</h1>
                    <p align="justify">Como resultado do projeto como um todo espera-se a obtenção de um largo conjunto de dados de sprites e outros Eventos Luminosos Transientes (ELTs) ocorridos sobre o Brasil e outros países da América Latina. Os dados permitirão um mapeamento da ocorrência de ELTs na região de observação e de sua sazonalidade. Com esse conjunto de dados diversos estudos científicos poderão ser feitos, por exemplo: (A) Distribuição de ELTs na região sul do país num raio de 800 km do sítio de observação; (B) Estudos das características dos ELTs na região de observação e das características das tempestades geradoras; (C) Estudo comparativo de tempestades geradoras e não-geradoras de ELTs. Também espera-se uma melhor divulgação para a comunidade científica, e para a população de um modo geral, dos trabalhos de pesquisa realizados nessa nova área dentro do INPE. Espera-se o desenvolvimento de um software que execute em um servidor do INPE para o gerenciamento e armazenamento das informações das observações de fenômenos realizadas. A partir desse software deve ser possível o controle das câmeras nas estações remotas, o acompanhamento em tempo real dos fenômenos e o gerenciamento dos dados científicos associados. A partir dessas informações, os pesquisadores terão condições de ter acesso aos dados de observação para estudar esses fenômenos.</p>
                </div>
            </div>
            <a href="<c:url value='/pantilt'/>">Movimentar Pant Ilt</a>        
            <hr>
            <footer>
                <div class="row">
                    <div class="col-lg-12">
                        <p align="center">&copy; Grupo LEONA 2014</p>
                    </div>
                </div>
            </footer>
        </div>
        <script src="<c:url value="./resources/js/jquery-1.10.2.js"/>"></script>
        <script src="<c:url value="./resources/js/bootstrap.js"/>"></script>
        <script>
            $('.carousel').carousel({
                interval: 5000
            })
        </script>
        
    </body>
</html>