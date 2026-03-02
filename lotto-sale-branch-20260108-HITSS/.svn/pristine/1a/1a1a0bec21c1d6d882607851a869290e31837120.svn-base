<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:choose>
    <c:when test="${isAllowed == false}"><c:redirect url="/inicio.html"/></c:when><c:otherwise></c:otherwise>
</c:choose>
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

<meta charset="utf-8">
<meta name="viewport" content="width=1024">

<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/theme.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/themeCasino.css?v=6">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link rel="stylesheet"  href="layer-view-style/game/casino/categorias.css" type="text/css" media="all">
<link rel="stylesheet"  href="layer-view-style/game/casino/main-casino.css" type="text/css" media="all">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">

<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/bootstrap-4.5.2.min.css?v=1">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/bootstrap-multiselect.min.css">

<%-- <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>--%>
<script src="layer-view-script/game/casino/font-awesome.js"></script>
<title>Casino: Juego de Casino virtuales, Perú - La Tinka</title>
<meta name="description" content="Casino">
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

<style>
html, body {
  height: 100%;
  padding: 0;
  margin: 0;
  width: 100%;
  font-family: AllerRegular, Arial, sans-serif;
}
iframe {
  border: 0;
  height: 184px;
  width: 100%;
}

/*Checkboxes styles*/
input[type="checkbox"] { display: none; }

input[type="checkbox"] + label {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 20px;
  font: 14px/20px 'Open Sans', Arial, sans-serif;
  color: #ddd;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
}

input[type="checkbox"] + label:last-child { margin-bottom: -20px; left: -30px;}

input[type="checkbox"] + label:before {
  content: '';
  display: block;
  width: 16px;
  height: 16px;
  border: 1px solid #01693F;
  position: absolute;
  left: 0;
  top: 2px;
  opacity: .6;
  -webkit-transition: all .12s, border-color .08s;
  transition: all .12s, border-color .08s;
}

input[type="checkbox"]:checked + label:before {
  width: 8px;
  top: 0px;
  left: 5px;
  border-radius: 0;
  opacity: 1;
  border-top-color: transparent;
  border-left-color: transparent;
  -webkit-transform: rotate(40deg);
  transform: rotate(40deg);
}
</style>

</head>
<body>
<span id="span-top"></span>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	<%@ include file="../../include/header.jspf" %>
<script>
$("#plays-3").addClass("active");     	  
var prodDisponibles = <c:out value="${productos}" escapeXml="false"/>;
var temp = '<c:out value="${jackpotids}" escapeXml="false"/>';
let aMasterProv = <c:out value="${providers}" escapeXml="false"/>;
let aCategoryProviders = <c:out value="${categoryProviders}" escapeXml="false"/>;
</script>
	<input type="hidden" value="${tinkaSale.numbersMore}" id="more_repeated">
	<input type="hidden" value="${tinkaSale.numbersLess}" id="less_repeated">
	<input type="hidden" value="${tinkaSale.status}" id="status">
	<input type="hidden" value="${tinkaSale.simpleBetPrice}" id="simpleBetPrice_repeated">
	<input type="hidden" value="${tinkaSale.promotionType}" id="promo">
	<input type="hidden" value="${tinkaSale.priceType}" id="price_type">
	<input type="hidden" value="${tinkaSale.algorithm}" id="algorithm">
	<input type="hidden" value="${tinkaSale.bets}" id="bets">
	<input type="hidden" value="${tinkaSale.pay}" id="pay">
	<input type="hidden" value="${tinkaSale.cost}" id="cost">
	<input type="hidden" value="${tinkaSale.draws}" id="draw">
	<input type="hidden" value="${tinkaSale.balanceAmountGame}" id="balanceAmountGame">
	<input type="hidden" value="${tinkaSale.balanceQuantityGame}" id="balanceQuantityGame">
	<input type="hidden" value="<%=Constants.iflexBonoTyC.toString().trim()%>" id="iflexBonoTyC" />
	<input type="hidden" value="<%=Constants.wbBonoTyC.toString().trim()%>" id="wbBonoTyC">
	<input type="hidden" value="<c:out value='${clientBalance}'/>" id="clientBalance" >
	<input type="hidden" value="<c:out value='${chargeData}'/>" id="chargeData">
	<input type="hidden" id="totalPagar">
	
    <div id="div-totop" class="cmn-divfloat">
	    <a href="#span-top" class="btn cmn-btncircle">
	        <i class="fas fa-chevron-up"></i>
	    </a>
	</div>
		
	<div class="main-content">
		<div class="main-page">
			<div class="main-game main-raspaditas">				
				<div class="row">
					<div class="col-12 col-md-12">
						<div class="box-main-game top-box" style="height: 140px;">
							<div class="top-banner top-tinka">
								<!--  <figure>
									<img src="layer-view-image/v2/header_lobby_casino.jpg" alt="" />
								</figure>-->
								<iframe id="myIframe" src="${iframeHomeBannerCasinoURL}" frameborder="0" scrolling="no" ><p>Is imposible, your browser dont support iframe</p></iframe>
								<div class="body-banner">
									<div class="left-banner">
										<div class="banner-price">
											<div class="sub-banner">                                                
                                            </div>
										</div>
									</div>									
								</div>
							</div>
						</div>
						<div class="main-panel" style="margin-top: 59px;">
							<c:if test="${nolive eq 1}">
								<div class="box-main-game-alert-iivv">
									<p class="message-game-alert">Debes iniciar sesión para jugar</p>
								</div>
							</c:if>
							<div class="row">
								<div class="col-12 col-md-4-search-v">
									<input class="search" placeholder="Buscar juego" id="buscador" type="text">
									<button type="submit" class="btnLupa"><i></i></button>
								</div>
								<div class="col-12 col-md-9-search-casino panel-submenu"> 
									<div id="tutorial" >
										<ul class="list-categories">
											<li id="m-todos">
												<a href="javascript:juegos('todos');">Todos</a>
											</li>
											<li id="m-masjugados">
												<a href="javascript:juegos('masjugados');">Los m&aacute;s jugados</a>
											</li>
											<c:if test="${sesion eq 1 }">
											<li id="m-favoritos">
												<a href="javascript:juegos('favoritos');">Favoritos<img class="star-submenu" src="layer-view-image/game/casino/icon_star_off_menu.svg"></a>
											</li>
											</c:if>
											<li id="m-slots">
												<a href="javascript:juegos('slots');">Slots</a>
											</li>
											<li id="m-live">
												<a href="javascript:juegos('live');">En Vivo</a>
											</li>
											<li id="m-bingo">
												<a href="javascript:juegos('bingo');">Bingo</a>
											</li>
											<li id="m-mesa">
												<a href="javascript:juegos('mesa');">Juegos de mesa</a>
											</li>
											<li id="m-jackpot">
												<a href="javascript:juegos('jackpot');">Jackpots</a>
											</li>
											<li id="m-virtual">
												<a href="javascript:juegos('virtual');">Virtual</a>
											</li>																	
										</ul>
										<hr class="linea-submenu">
									</div>		
								</div>
								<div class="col-12 col-md-8-search-subcategoria panel-submenu" style="display:none">
									<div id="tutorial" >	
										<ul class="list-categories subcategoria">
											<li id="m-baccarat">
												<a href="javascript:juegos('baccarat');"><img class="subcategoria" src="layer-view-image/game/casino/baccarat.svg">Baccarat</a>
											</li>
											<li id="m-blackjack">
												<a href="javascript:juegos('blackjack');"><img class="subcategoria" src="layer-view-image/game/casino/blackjack.svg">Blackjack</a>
											</li>
											<li id="m-poker">
												<a href="javascript:juegos('poker');"><img class="subcategoria" src="layer-view-image/game/casino/poker.svg">Poker</a>
											</li>						
											<li id="m-roulette">
												<a href="javascript:juegos('roulette');"><img class="subcategoria" src="layer-view-image/game/casino/roulette.svg">Roulette</a>
											</li>
											<li id="m-otros">
												<a href="javascript:juegos('otros');"><img class="subcategoria" src="layer-view-image/game/casino/otros.svg">Otros</a>
											</li>
										</ul>
									</div>	
								</div>	
								<div class="col-12 col-md-4-search col-md-8-proveedor" style="padding-left: 8px;margin-top: -10px;margin-bottom: 27px;">	
									<select name="sproveedor[]" multiple id="sproveedor">								   
									</select>								
								</div>																															
							</div>
							<div id="todos" style="display:block;margin-top: -14px;">
								<jsp:include page="include_todos.jsp" />
							</div>							
						</div>
					</div>					
				</div>
			</div>
		</div>
	</div>	
	<%@ include file="../../include/footer.jspf" %>
    <script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='layer-view-script/common/jquery.scripts.js'></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js?v=2'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>    
	<script type="text/javascript" src="layer-view-script/common/fastclick.js"></script>
	<script type="text/javascript" src="layer-view-script/common/jquery.idle.js"></script>
	
	<script src="layer-view-script/game/casino/bootstrap.min.js"></script>	
	<script src="layer-view-script/game/casino/bootstrap-multiselect.min.js"></script>	
	
    <script type='text/javascript' src='layer-view-script/game/casino/lotto-casino.js?v=3'></script>	
</body>
</html>