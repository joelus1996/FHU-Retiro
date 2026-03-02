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
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/theme.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/themeVirtuales.css?v=11">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/categorias.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/main-virtuales.css?v=1">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">

<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/bootstrap-4.5.2.min.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/bootstrap-multiselect.min.css">

<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
<script src="layer-view-script/game/virtuales/font-awesome.js"></script>
<title>Deportes Virtuales: Juego de Deportes virtuales, Perú - La Tinka</title>
<meta name="description" content="Deportes Virtuales">
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
  border-radius: 10px;
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
$("#plays-2").addClass("active");     	  
var prodDisponibles = <c:out value="${productos}" escapeXml="false"/>;
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
	<input type="hidden" value="${sessionScope.User.pClientid}" id="clientId">
	
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
								<iframe id="myIframe" src="${iframeHomeBannerVirtualesURL}" frameborder="0" scrolling="no" ><p>Is imposible, your browser dont support iframe</p></iframe>
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
								<div class="col-12 panel-submenu" style="padding-left: 15px;"> 
									<div id="tutorial" >
										<ul class="list-categories">
											<li id="m-todos" class="active">
												<a href="javascript:juegos('todos');" data-category="Todos">Todos</a>
											</li>
											<li id="m-masjugados">
												<a href="javascript:juegos('masjugados');" data-category="Masjugados">Los m&aacute;s jugados</a>
											</li>
											<c:if test="${sesion eq 1 }">
											<li id="m-favoritos">
												<a href="javascript:juegos('favoritos');">Favoritos<img class="star-submenu" src="layer-view-image/game/casino/icon_star_off_menu.svg"></a>
											</li>
											</c:if>
											<li id="m-Deportes">
												<a href="javascript:juegos('Deportes');" data-category="Deportes">Deportes</a>
											</li>
											<li id="m-Instantaneas">
												<a href="javascript:juegos('Instantaneas');" data-category="Insta">Instant&aacute;neos</a>
											</li>
											<li id="m-Numeros">
												<a href="javascript:juegos('Numeros');" data-category="Numeros">Juegos de n&uacute;meros</a>
											</li>						
										</ul>
										<hr class="linea-submenu">
									</div>		
								</div>
								<div class="col-12 col-md-4-search col-md-8-proveedor" style="padding-left: 0;margin-top: -10px;margin-bottom: 27px;">	
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
	
<!-- 	<footer id="footer-copacasa"> -->
<!-- 		<div id="popup-copacasa" class="overlay"> -->
<!-- 			<div class="popup popup-sm-copacasa"> -->
<!-- 				<a class="close-copa js-close-modal-ddvv" href="#">&times;</a> -->
<!-- 				<div class="wrap-modal"> -->
<!-- 					<div class="gana-copa-footer"> -->
<!-- 						<img class="home-popup" src="layer-view-image/game/virtuales/popup-deportevirtuales.jpg">														 -->
<!-- 					</div>																			 -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div>     -->
<!--     </footer> -->
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
	
	<script src="layer-view-script/game/virtuales/bootstrap.min.js"></script>	
	<script src="layer-view-script/game/virtuales/bootstrap-multiselect.min.js"></script>
	
	<script type='text/javascript' src='layer-view-script/game/virtuales/lotto-virtuales.js?v=1'></script>
	
</body>
</html>