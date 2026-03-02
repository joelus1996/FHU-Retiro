<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isClicyganaSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=clicygana"/></c:if>

<!DOCTYPE html>
<html lang="es">
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

    <meta charset="UTF-8">
    <title>Clic & Gana</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/clicygana/themeClicygana.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<%@ include file="../../include/header.jspf"%>
<div id="main-content-background">
<div id="main-content" class="group">
<%@ include file="../../include/menu.jspf"%>
<input type="hidden" id="idGameParameter" value="<c:out value='${idGameParameter}'/>">
<!-- HOME CLIC Y GANA -->
<%String clicYGanaURI = String.valueOf(ConnectionFactory.operationProperty("neogamesURI", Constants.contextCardWeb)).toString().trim();%>
<div id="clicygana" class="group">
<div id="banner">
    <p id="prize">
        <span id="prize_message1">¡Mucha diversión! ¡Muchos premios!</span><br>
        <span id="prize_message2">¡Son más de 50 juegos que te harán ganar hasta S/ 400,000 !</span>
    </p>
    <p id="horary">
        <span>Juégalos en</span><br>
        <span>cualquier momento</span>
    </p>
</div>

<div id="transition" class="transition-one"></div>
<a id="help" href="https://latinkaportal.com.pe/" target="_black"></a>

<div id="content">
<!-- HOME ELIGE TU CLICK Y GANA -->
<div id="choose-content">
<ul id="menu" class="group">
    <li id="instant">
        <a id="go-instant-games" href="#instant-games">
            <span id="image-instant">JUEGOS INSTANTÁNEOS</span>
        </a>
    </li>
    <li id="scrape">
        <a id="go-scrape-games" href="#scrape-games">
            <span id="image-scrape">JUEGOS DE RASPE</span>
        </a>
    </li>
</ul>
<div id="instant-games">
<div class="content-game">
<div id="menu-instant-games" class="">
    <a id="i-classic" class="sub-menu" href="#i-classic-game">Clásico</a><span class="separator">|</span>
    <a id="i-bingo" class="sub-menu" href="#i-bingo-game">Bingo</a><span class="separator">|</span>
    <a id="i-fantasy" class="sub-menu" href="#i-fantasy-game">Fantasía</a><span class="separator">|</span>
    <a id="i-new" class="sub-menu" href="#i-new-game">Nuevo</a>
</div>
<div class="tab-container">
<ul id="i-classic-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="1" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game01.jpg" alt="Yan Ken Po" width="113" height="111">
                <span>Yan Ken Po!</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="28" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game28.jpg" alt="Afina Punteria" width="113" height="111">
                <span>Afina Punteria</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="36" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game36.jpg" alt="Super Chance" width="113" height="111">
                <span>Super Chance</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="138" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game138.jpg" alt="Alfredo" width="113" height="111">
                <span>Alfredo</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="91" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game91.jpg" alt="Premio Veloz" width="113" height="111">
                <span>Premio Veloz</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="69" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game69.jpg" alt="Tigre Mahjong" width="113" height="111">
                <span>Tigre Mahjong</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="35" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game35.jpg" alt="Salta y Gana" width="113" height="111">
                <span>Salta y Gana</span>
            </a>
        </h3>
    </li>
</ul>
<ul id="i-bingo-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="49" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game49.jpg" alt="Discobolillas" width="113" height="111">
                <span>Discobolillas</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="29" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game29.jpg" alt="Bolibingo" width="113" height="111">
                <span>Bolibingo</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="23" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game23.jpg" alt="Bingo de la Suerte" width="113" height="111">
                <span>Bingo de la Suerte</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="100" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game100.jpg" alt="Hermosos 60's" width="113" height="111">
                <span>Hermosos 60's</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="110" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game110.jpg" alt="Espresso" width="113" height="111">
                <span>Espresso</span>
            </a>
        </h3>
    </li>
</ul>
<ul id="i-fantasy-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="33" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game33.jpg" alt="Club de Perlas" width="113" height="111">
                <span>Club de Perlas</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="13" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game13.jpg" alt="Piedra Preciosa" width="113" height="111">
                <span>Piedra Preciosa</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="30" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game30.jpg" alt="Riconejo" width="113" height="111">
                <span>Riconejo</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="99" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game99.jpg" alt="Vecinos" width="113" height="111">
                <span>Vecinos</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="84" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game84.jpg" alt="Ganto Ganador" width="113" height="111">
                <span>Ganto Ganador</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="6" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game06.jpg" alt="Genio Magico" width="113" height="111">
                <span>Genio Magico</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="25" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game25.jpg" alt="Pesca Plata" width="113" height="111">
                <span>Pesca Plata</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="26" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game26.jpg" alt="Super Navidad" width="113" height="111">
                <span>Super Navidad</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="87" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game87.jpg" alt="Piensa Rapido" width="113" height="111">
                <span>Piensa Rapido</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="12" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game12.jpg" alt="Piensa Rapido" width="113" height="111">
                <span>Piensa Rapido</span>
            </a>
        </h3>
    </li>
</ul>
<ul id="i-new-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="1" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game01.jpg" alt="Yan Ken Po!" width="113" height="111">
                <span>Yan Ken Po!</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="123" href="#" class="game">
                <img src="layer-view-image/game/clicygana/instantanea/instantanea-game123.jpg" alt="Canasta" width="113" height="111">
                <span>Canasta</span>
            </a>
        </h3>
    </li>
</ul>
</div>
</div>
</div>
<div id="scrape-games">
<div class="content-game">
<ul id="menu-scrape-games">
    <a id="s-classic" class="sub-menu" href="#s-classic-game">Clásico</a><span class="separator">|</span>
    <a id="s-fantasy" class="sub-menu" href="#s-fantasy-game">Fantasía</a><span class="separator">|</span>
    <a id="s-sports" class="sub-menu" href="#s-sports-game">Deportes</a><span class="separator">|</span>
    <a id="s-new" class="sub-menu" href="#s-new-game">Nuevo</a>
</ul>
<div class="tab-container">
<ul id="s-classic-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="179" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game179.jpg" alt="Poder Ganador" width="113" height="111">
                <span>Poder Ganador</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="164" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game164.jpg" alt="Número uno" width="113" height="111">
                <span>Número uno</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="172" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game172.jpg" alt="¡Conoce a Max!" width="113" height="111">
                <span>¡Conoce a Max!</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="134" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game134.jpg" alt="Horóscopo" width="113" height="111">
                <span>Horóscopo</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="149" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game149.jpg" alt="Postales" width="113" height="111">
                <span>Postales</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="58" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game58.jpg" alt="3 veces 7" width="113" height="111">
                <span>3 veces 7</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="46" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game46.jpg" alt="3 en línea" width="113" height="111">
                <span>3 en línea</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="96" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game96.jpg" alt="¡Felíz Cumple!" width="113" height="111">
                <span>¡Felíz Cumple!</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="111" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game111.jpg" alt="Duende Mágico" width="113" height="111">
                <span>Duende Mágico</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="45" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game45.jpg" alt="Mono Loco" width="113" height="111">
                <span>Mono Loco</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="158" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game158.jpg" alt="7 Boom" width="113" height="111">
                <span>7 Boom</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="90" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game90.jpg" alt="Suerte Dorada" width="113" height="111">
                <span>Suerte Dorada</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="40" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game40.jpg" alt="Bar El Ganador" width="113" height="111">
                <span>Bar "El Ganador"</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="64" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game64.jpg" alt="Súper Agentes" width="113" height="111">
                <span>Súper Agentes</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="116" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game116.jpg" alt="Vivir como rey" width="113" height="111">
                <span>Vivir como rey</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="54" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game54.jpg" alt="Torneo Medieval" width="113" height="111">
                <span>Torneo Medieval</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="18" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game18.jpg" alt="Bingo" width="113" height="111">
                <span>Bingo</span>
            </a>
        </h3>
    </li>
</ul>
<ul id="s-fantasy-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="50" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game50.jpg" alt="Granja Suertuda" width="113" height="111">
                <span>Granja Suertuda</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="04" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game04.jpg" alt="Bosque de Fantasía" width="113" height="111">
                <span>Bosque de Fantasía</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="56" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game56.jpg" alt="Tortolitos" width="113" height="111">
                <span>Tortolitos</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="59" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game59.jpg" alt="Esmeralda" width="113" height="111">
                <span>Esmeralda</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="48" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game48.jpg" alt="Castillo mágico" width="113" height="111">
                <span>Castillo mágico</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="5" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game05.jpg" alt="Caja fuerte" width="113" height="111">
                <span>Caja fuerte</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="15" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game15.jpg" alt="Zodiaco Online" width="113" height="111">
                <span>Zodiaco Online</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="63" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game63.jpg" alt="El gran Chaman" width="113" height="111">
                <span>El gran Chaman</span>
            </a>
        </h3>
    </li>
</ul>
<ul id="s-sports-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="14" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game14.jpg" alt="Preparados, Listos, Ya!" width="113" height="111">
                <span>Preparados,Listos,Ya!</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="166" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game166.jpg" alt="Copa Europea" width="113" height="111">
                <span>Copa Europea</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="27" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game27.jpg" alt="Caballitos" width="113" height="111">
                <span>Caballitos</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="16" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game16.jpg" alt="Apunta y Gana" width="113" height="111">
                <span>Apunta y Gana</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="34" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game34.jpg" alt="Dinero Rápido" width="113" height="111">
                <span>Dinero Rápido</span>
            </a>
        </h3>
    </li>
</ul>
<ul id="s-new-game" class="tab group">
    <li class="item-game">
        <h3>
            <a data-id="164" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game164.jpg" alt="Número Uno" width="113" height="111">
                <span>Número Uno</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="172" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game172.jpg" alt="¡Conoce a Max!" width="113" height="111">
                <span>¡Conoce a Max!</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="179" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game179.jpg" alt="Poder Ganador" width="113" height="111">
                <span>Poder Ganador</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="134" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game134.jpg" alt="Horóscopo" width="113" height="111">
                <span>Horóscopo</span>
            </a>
        </h3>
    </li>
    <li class="item-game">
        <h3>
            <a data-id="149" href="#" class="game">
                <img src="layer-view-image/game/clicygana/raspe/raspe-game149.jpg" alt="Postales" width="113" height="111">
                <span>Postales</span>
            </a>
        </h3>
    </li>
</ul>
</div>
</div>
</div>
</div>

<!-- END ELIGE TU CLICK Y GANA -->
<!-- HOME RECARGA TU SALDO -->
<div id="reload-balanace-games" >
    <div class="finalize-purchase group">
        <div id='content-purchase'>
            <div id='left-panel' class='left-panel'>
                <span class='label_1'>CLIC & GANA</span>
                <div id="game_grid"></div>
            </div>
            <div class='right-panel'>
                <div class='label_2'>dd/mm/yy</div>
                <div class="result_purchase">
                    <div class="label_resu1">JUEGAS DESDE:</div>
                    <div class="result1">S/ 1.00</div>
                </div>
            </div>
            <div id="sub_purchase">
                <div id="sub_panel">
                    <div id="login_section">
                        <div class="label1">LOGIN: Ingresa a tu cuenta para realizar tu pago.</div>
                        <div>
                            <form id="frmLoginClient" action="login_clicygana.html" method="post">
                                <table>
                                    <tr>
                                        <td><span class='label-login'>Usuario:</span></td>
                                        <td><input id='user-client' type='text' name='user-client' class='text-pass'>
                                        </td>
                                        <td><span class='label-login'>Contrase&ntilde;a</span></td>
                                        <td>
                                            <input id='password-client' type="password" name='password-client' class='text-pass'>
                                        </td>
                                        <td><input type="submit" value="Ingresar" class="button-ingresar" id="home-btnlogin"></td>
                                    </tr>
                                </table>
                            </form>
                        </div>
                        <div class="label2">
                            <a href="recordar-usuario.html">¿Olvidaste tu usuario?</a> |
                            <a href="restablecer.html">¿Olvidaste tu Contrase&ntilde;a?</a>
                        </div>
                    </div>
                    <form id="frmLoadBalance">
                        <div id="payments_section">
                            <div id="pan_0">
                            	<div class="label1">PAGAR</div>
                                <table>
                                    <tr>
                                        <td>
                                            <input type="radio" name="option-card" checked="checked" value="0" id="option-card-0">
                                        </td>
                                        <td><label for="option-card-0"><span>Quiero descontar de mi saldo disponible S/</span>
                                            <span id="field-balance-amount">${clicyganaSale.balanceAmount}</span>
                                            <br>
                                    <span class="saldo_promocional">
                                        <c:if test="${clicyganaSale.balanceAmountGame!='0.0'}">
                                            &oacute; de mi saldo promocional S/ ${clicyganaSale.balanceAmountGame}
                                        </c:if>
                                    </span></label>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        	<div id="separator_hr"></div>
							<div id="pan_1">
								<div class="label2">RECARGAS POR INTERNET</div>
								<table>
							<c:forTokens var="channel1Order" items="${clicyganaSale.channel1Order}" delims=",">
								<%@ include file="../../include/balance1.jspf"%>
							</c:forTokens>
							</table>
							<div class="label2">RECARGAS F&Iacute;SICAS</div>
							<table>
							<c:forTokens var="channel2Order" items="${clicyganaSale.channel2Order}" delims=",">
								<%@ include file="../../include/balance2.jspf"%>
							</c:forTokens>
							</table>
							</div>
							<div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div>
                        </div>
                    </form>
                </div>
                <!-- <div id="play-panel" class="text-distance">
                    <a id='play' target="_blank"></a>
                </div> -->
                <div id="play-panel" class="text-distance">
                <form id="frmPlay" name="frmPlay" action="play_clicygana_user.html" method="post" target="showWindow" onsubmit="open_window('showWindow');">
                    <input type="hidden" id="sessionCode" name="sessionCode">
                    <input type="hidden" id="user" name="user" value="${clicyganaSale.user}">
                    <input type="hidden" id="mode" name="mode">
                    <input type="hidden" id="nickName" name="nickName" value="${clicyganaSale.nickName}">
                    <input type="hidden" id="idTipGameParameter" name="idTipGameParameter" value="${idTipGameParameter}">
                    <input type="hidden" id="gameId" name="gameId">
                    <input type="submit" id="play" value="play">              
                </form>                    
                </div>
            </div>
        </div>
	    <div id="ico-block">
		    <div id="ico-title">&iexcl;SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
		    <div id="ico-panel">
				<a href="juega-tinka.html" class="button-icotinka" id='icotinka'></a>
				<a href="juega-kabala.html" class="button-icokabala" id='icokabala'></a>
				<a href="juega-ganadiario.html" class="button-icoganadiario" id='icoganadiario'></a>
				<a href="juega-kinelo.html" class="button-icokinelo" id='icokinelo'></a>
				<a onclick="toTAV2();" class="button-icoteapuesto hand" id='icoteapuesto'></a>
				<a href="juega-ganagol.html" class="button-icoganagol" id='icoganagol'></a>
				<!-- a href="juega-clicygana.html" class="button-icoclicygana" id='icoclicygana'></a -->
				<!-- a href="juega-deportesvirtuales.html" class="button-icodeportesvirtuales" id='icodeportesvirtuales'></a -->
				<!-- a href="juega-super3.html" class="button-icosuper3" id='icosuper3'></a -->
				<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/reventon" class="button-icoelreventon" id='icoelreventon'></a -->
				<!-- a href="juega-rapitinkas.html" class="button-icorapitinkas" id='icorapitinkas'></a -->
				<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/instantaneas" class="button-icorapigana" id='icorapigana'></a -->
				<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/giromagico" class="button-icogiromagico" id='icogiromagico'></a -->
				<!-- a href="juega-fechaza.html" class="button-icofechaza" id='icofechaza'></a --> 
			</div> 
	    </div>
        <div class="img_zona_segura"></div>
    </div>
</div>
<!-- END RECARGA TU SALDO -->
</div>
</div>
<!-- END CLIC Y GANA -->
<iframe class="style-iframe" src="/web/home/right.html" frameborder="0" scrolling="no" width = "300" height="516" style="visibility:hidden;" onload="this.style.visibility='visible';"></iframe>
<%@ include file="../../include/footer.jspf"%>
</div>
</div>
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/game/clicygana/lotto-clicygana.js"></script>
<script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript"  src="<%=clicYGanaURI%>"></script>
<script type="text/javascript">
      
		
			
        function open_window(target_name) {
            var t = target_name;
            var x = screen.availWidth;
            var y = screen.availHeight;
            var ventana = window.open('', t, "width="+x+", height="+y+", status=no, scrollbars=no, toolbars=no, menubar=no");
            ventana.moveTo(0,0);
        }
		/*evaluarIdGame();*/
    </script>
	
    <!--[if IE]>
    <script type="text/javascript">
        function Imprimir(target_name) {
            var t = target_name;
            var x = screen.availWidth-10;
            var y = screen.availHeight-35;
            var ventana = window.open('', t, "width="+x+", height="+y+", status=no, scrollbars=no, toolbars=no, menubar=no");
            ventana.moveTo(-10,35)
        }
    </script>
    <![endif]-->

</body>
</html>