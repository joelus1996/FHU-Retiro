<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isKineloSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=kinelo"/></c:if>
<!DOCTYPE html>
<html lang="es">
<head>
<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
<script>
window.onload = function () {
	if(document.getElementById("clientId").value){
		dataLayer.splice(0,1,{
			'loginStatus': 'Sesión iniciada',
			'clientid': getClientID(),
			'userID': document.getElementById("clientId").value,
			});
	}
}
</script>
		<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->
<script type="application/ld+json">
{
  "@context": "https://schema.org/",
  "@type": "BreadcrumbList",
  "itemListElement": [{
    "@type": "ListItem",
    "position": 1,
    "name": "La Tinka",
    "item": "https://www.latinka.com.pe/p/" 
  },{
    "@type": "ListItem",
    "position": 2,
    "name": "Jugar Kinelo",
    "item": "https://www.latinka.com.pe/p/juega-kinelo.html" 
  }]
}
</script>
	<meta property="og:title" content="Kinelo: Juega y Gana cada 5 minutos">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://www.latinka.com.pe/p/juega-kinelo.html">
	<meta property="og:description" content="¿Qué es Kinelo? Es un juego de apuestas a la medida con 10 tipos de apuestas de diferentes premios mayores. Gana cada 5 minutos y multiplica tu apuesta.">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-kinelo.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=1024">
    <link media="screen" rel="stylesheet" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/kinelo/theme.css" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/kinelo/themeKinelo.css" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css" />

    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
  	<title>Kinelo: Juega y Gana cada 5 minutos</title>
	<meta name="description" content="¿Qué es Kinelo? Es un juego de apuestas a la medida con 10 tipos de apuestas de diferentes premios mayores. Gana cada 5 minutos y multiplica tu apuesta.">
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

</head>
<body>

<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	
	<h1 style="display: none;">Jugar Kinelo en vivo</h1>
    <%@ include file="../../include/header.jspf" %>
    <div id="mensajeNotificacion">
			
	</div>

    <input type="hidden" value="${kineloSale.status}" id="status">
    <input type="hidden" value="${kineloSale.message}" id="message">
    <input type="hidden" value="${kineloSale.activeDraw}" id="activeDraw">
    <input type="hidden" value="${kineloSale.closeDate}" id="closeDate">
    <input type="hidden" value="${kineloSale.closeHour}" id="closeHour">
    <input type="hidden" value="${kineloSale.nextDraw}" id="nextDraw">
    <input type="hidden" value="${kineloSale.openDate}" id="openDate">
    <input type="hidden" value="${kineloSale.openHour}" id="openHour">
    <input type="hidden" value="${kineloSale.numbersMore}" id="numbersMore">
    <input type="hidden" value="${kineloSale.numbersLess}" id="numbersLess">
    <input type="hidden" value="${kineloSale.priceType}" id="priceType">
    <input type="hidden" value="${kineloSale.priceMessage}" id="priceMessage">
    <input type="hidden" value="${kineloSale.simpleBetPrice}" id="simpleBetPrice">
    <input type="hidden" value="${kineloSale.promotionType}" id="promotionType">
    <input type="hidden" value="${kineloSale.balanceAmount}" id="balanceAmount">
    <input type="hidden" value="${kineloSale.balanceAmountGame}" id="balanceAmountGame">
    <input type="hidden" value="${kineloSale.balanceQuantityGame}" id="balanceQuantityGame">
    <input type="hidden" value="${kineloSale.algorithm}" id="algorithm">
    <input type="hidden" value="${kineloSale.bets}" id="bets">
    <input type="hidden" value="${kineloSale.pay}" id="pay">
    <input type="hidden" value="${kineloSale.draws}" id="draws">
    <input type="hidden" value="${kineloSale.cost}" id="cost">
    <input type="hidden" value="<%=Constants.iflexBonoTyC.toString().trim()%>" id="iflexBonoTyC" />
    <input type="hidden" value="<%=Constants.wbBonoTyC.toString().trim()%>" id="wbBonoTyC">
    <input type="hidden" value="<c:out value='${clientBalance}'/>" id="clientBalance" >
    <input type="hidden" value="<c:out value='${chargeData}'/>" id="chargeData">
    <input type="hidden" id="totalPagar">
        
    <input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Kinelo" id="Zona">
	<input type="hidden" value="" id="SubZona">
	
    <div class="main-content">
        <div class="main-page">

            <div class="main-game main-kinelo">
            
                <div class="row">
                    <div class="col-12 col-md-8">
                        <div class="box-main-game top-box">
                            <div class="top-banner">
                                <figure>
                                    <img src="layer-view-image/v2/logo-kinelo.png" alt="Jugar Kinelo" />
                                </figure>
                                <div class="body-banner">
                                    <div class="left-banner">
                                        <div class="banner-price">
                                            <div class="sub-banner">
                                                <h4>¡Gana cada 5 minutos!<span>&nbsp;</span> </h4>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="main-panel">
                            
                            <div class="main-play">

                                <div id="iframe-kinelo" style="overflow: hidden; border-radius: 10px; margin-bottom: 20px;">
                                    <!--  <iframe scrolling="no" allowtransparency="true" frameborder="0" height="340px" src="< % = ConnectionFactory.operationProperty("portalKineloWeb", Constants.contextSale).trim() % >" width="600px"></iframe> -->
                                    <iframe scrolling="no" allowtransparency="true" frameborder="0" height="340px" src="https://www.latinka.com.pe/kinelo/desktop/" width="600px"></iframe>
                                </div>
                                
                                <div class="steps-play">
                                    <div class="row no-gutters">
                                        <div class="col-6">
                                            <div class="step-play step-status-1 step-active">PASO 1: ELIGE TU JUGADA</div>
                                        </div>
                                        <div class="col-6">
                                            <div class="step-play step-status-2">PASO 2: FINALIZAR TU COMPRA</div>
                                        </div>
                                    </div>
                                </div>

                                <!-- <div class="body-play"> -->
                                <div class='body-play' <c:if test="${kineloSale.status != 'ACT'}">style='pointer-events:none'</c:if>>


                                    <div class="play-help">
                                        <a href="<%=Constants.URL_QW%>/tutorial/como-jugar-kinelo/" onclick="datalayerFinalizaCompraAyuda(this,'Ayuda');" target="_blank" class="play-text"><span>?</span> Ayuda</a>
                                    </div>
                                    
                                    <div class="wrapper-playing">
                                        <div class="boxes-playing">
                                            <div class="box-playing">
                                                <div class="row no-gutters">
                                                    <div class="col-6">
                                                        <div class="box-wrapper-game box-content-left">
                                                            <div class="box-content-game">
                                                                <div id="J1" class="plays">
                                                                    <div class="box-play-main box-play-a">
                                                                        <div class="content-single-game">
                                                                            <div class="top-single-game no-border">
                                                                                <h3>JUGADA A</h3>
                                                                            </div>
                                                                            <div class="single-box-game">
                                                                                <div class="top-single-box">
                                                                                    <div class="step-play">1: ELIGE TU JUGADA</div>
                                                                                    <div class="step-play-desc">¿Cuántos números quieres acertar?</div>
                                                                                </div>
                                                                                <div class="body-single-box">
                                                                                    <div class="body-game">
                                                                                        <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_1" value="1"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_1" for="J1YBAcheck_1"><span class="label-item">1</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_2" value="2"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_2" for="J1YBAcheck_2"><span class="label-item">2</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_3" value="3"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_3" for="J1YBAcheck_3"><span class="label-item">3</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_4" value="4"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_4" for="J1YBAcheck_4"><span class="label-item">4</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_5" value="5"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_5" for="J1YBAcheck_5"><span class="label-item">5</span></span>
                                                                                            </label>
                                                                                        </div>
                                                                                        <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_6" value="6"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_6" for="J1YBAcheck_6"><span class="label-item">6</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_7" value="7"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_7" for="J1YBAcheck_7"><span class="label-item">7</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_8" value="8"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_8" for="J1YBAcheck_8"><span class="label-item">8</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_9" value="9"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_9" for="J1YBAcheck_9"><span class="label-item">9</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J1YBAcheck_10" value="10"/><span class="button-group-item LcheckYBA" id="LJ1YBAcheck_10" for="J1YBAcheck_10"><span class="label-item">10</span></span>
                                                                                            </label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="single-box-game">
                                                                                <div class="top-single-box no-m-b">
                                                                                    <div class="step-play">2: ELIGE TUS NÚMEROS</div>
                                                                                    <!-- div class="step-play-desc">Marca 6 bolillas o más</div -->
                                                                                </div>
                                                                            </div>
                                                                            <div class="body-single-game">
                                                                                <div class="body-game">
                                                                                    <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                        
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="1" id="J1check_1"/><span class="button-group-item check_" id="LJ1check_1" for="J1check_1"><span class="label-item">1</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="2" id="J1check_2"/><span class="button-group-item check_" id="LJ1check_2" for="J1check_2"><span class="label-item">2</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="3" id="J1check_3"/><span class="button-group-item check_" id="LJ1check_3" for="J1check_3"><span class="label-item">3</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="4" id="J1check_4"/><span class="button-group-item check_" id="LJ1check_4" for="J1check_4"><span class="label-item">4</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="5" id="J1check_5"/><span class="button-group-item check_" id="LJ1check_5" for="J1check_5"><span class="label-item">5</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="6" id="J1check_6"/><span class="button-group-item check_" id="LJ1check_6" for="J1check_6"><span class="label-item">6</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="7" id="J1check_7"/><span class="button-group-item check_" id="LJ1check_7" for="J1check_7"><span class="label-item">7</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="8" id="J1check_8"/><span class="button-group-item check_" id="LJ1check_8" for="J1check_8"><span class="label-item">8</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="9" id="J1check_9"/><span class="button-group-item check_" id="LJ1check_9" for="J1check_9"><span class="label-item">9</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="10" id="J1check_10"/><span class="button-group-item check_" id="LJ1check_10" for="J1check_10"><span class="label-item">10</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="11" id="J1check_11"/><span class="button-group-item check_" id="LJ1check_11" for="J1check_11"><span class="label-item">11</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="12" id="J1check_12"/><span class="button-group-item check_" id="LJ1check_12" for="J1check_12"><span class="label-item">12</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="13" id="J1check_13"/><span class="button-group-item check_" id="LJ1check_13" for="J1check_13"><span class="label-item">13</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="14" id="J1check_14"/><span class="button-group-item check_" id="LJ1check_14" for="J1check_14"><span class="label-item">14</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="15" id="J1check_15"/><span class="button-group-item check_" id="LJ1check_15" for="J1check_15"><span class="label-item">15</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="16" id="J1check_16"/><span class="button-group-item check_" id="LJ1check_16" for="J1check_16"><span class="label-item">16</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="17" id="J1check_17"/><span class="button-group-item check_" id="LJ1check_17" for="J1check_17"><span class="label-item">17</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="18" id="J1check_18"/><span class="button-group-item check_" id="LJ1check_18" for="J1check_18"><span class="label-item">18</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="19" id="J1check_19"/><span class="button-group-item check_" id="LJ1check_19" for="J1check_19"><span class="label-item">19</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="20" id="J1check_20"/><span class="button-group-item check_" id="LJ1check_20" for="J1check_20"><span class="label-item">20</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="21" id="J1check_21"/><span class="button-group-item check_" id="LJ1check_21" for="J1check_21"><span class="label-item">21</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="22" id="J1check_22"/><span class="button-group-item check_" id="LJ1check_22" for="J1check_22"><span class="label-item">22</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="23" id="J1check_23"/><span class="button-group-item check_" id="LJ1check_23" for="J1check_23"><span class="label-item">23</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="24" id="J1check_24"/><span class="button-group-item check_" id="LJ1check_24" for="J1check_24"><span class="label-item">24</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="25" id="J1check_25"/><span class="button-group-item check_" id="LJ1check_25" for="J1check_25"><span class="label-item">25</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="26" id="J1check_26"/><span class="button-group-item check_" id="LJ1check_26" for="J1check_26"><span class="label-item">26</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="27" id="J1check_27"/><span class="button-group-item check_" id="LJ1check_27" for="J1check_27"><span class="label-item">27</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="28" id="J1check_28"/><span class="button-group-item check_" id="LJ1check_28" for="J1check_28"><span class="label-item">28</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="29" id="J1check_29"/><span class="button-group-item check_" id="LJ1check_29" for="J1check_29"><span class="label-item">29</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="30" id="J1check_30"/><span class="button-group-item check_" id="LJ1check_30" for="J1check_30"><span class="label-item">30</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="31" id="J1check_31"/><span class="button-group-item check_" id="LJ1check_31" for="J1check_31"><span class="label-item">31</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="32" id="J1check_32"/><span class="button-group-item check_" id="LJ1check_32" for="J1check_32"><span class="label-item">32</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="33" id="J1check_33"/><span class="button-group-item check_" id="LJ1check_33" for="J1check_33"><span class="label-item">33</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="34" id="J1check_34"/><span class="button-group-item check_" id="LJ1check_34" for="J1check_34"><span class="label-item">34</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="35" id="J1check_35"/><span class="button-group-item check_" id="LJ1check_35" for="J1check_35"><span class="label-item">35</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="36" id="J1check_36"/><span class="button-group-item check_" id="LJ1check_36" for="J1check_36"><span class="label-item">36</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="37" id="J1check_37"/><span class="button-group-item check_" id="LJ1check_37" for="J1check_37"><span class="label-item">37</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="38" id="J1check_38"/><span class="button-group-item check_" id="LJ1check_38" for="J1check_38"><span class="label-item">38</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="39" id="J1check_39"/><span class="button-group-item check_" id="LJ1check_39" for="J1check_39"><span class="label-item">39</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="40" id="J1check_40"/><span class="button-group-item check_" id="LJ1check_40" for="J1check_40"><span class="label-item">40</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="41" id="J1check_41"/><span class="button-group-item check_" id="LJ1check_41" for="J1check_41"><span class="label-item">41</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="42" id="J1check_42"/><span class="button-group-item check_" id="LJ1check_42" for="J1check_42"><span class="label-item">42</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="43" id="J1check_43"/><span class="button-group-item check_" id="LJ1check_43" for="J1check_43"><span class="label-item">43</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="44" id="J1check_44"/><span class="button-group-item check_" id="LJ1check_44" for="J1check_44"><span class="label-item">44</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="45" id="J1check_45"/><span class="button-group-item check_" id="LJ1check_45" for="J1check_45"><span class="label-item">45</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="46" id="J1check_46"/><span class="button-group-item check_" id="LJ1check_46" for="J1check_46"><span class="label-item">46</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="47" id="J1check_47"/><span class="button-group-item check_" id="LJ1check_47" for="J1check_47"><span class="label-item">47</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="48" id="J1check_48"/><span class="button-group-item check_" id="LJ1check_48" for="J1check_48"><span class="label-item">48</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="49" id="J1check_49"/><span class="button-group-item check_" id="LJ1check_49" for="J1check_49"><span class="label-item">49</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="50" id="J1check_50"/><span class="button-group-item check_" id="LJ1check_50" for="J1check_50"><span class="label-item">50</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="51" id="J1check_51"/><span class="button-group-item check_" id="LJ1check_51" for="J1check_51"><span class="label-item">51</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="52" id="J1check_52"/><span class="button-group-item check_" id="LJ1check_52" for="J1check_52"><span class="label-item">52</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="53" id="J1check_53"/><span class="button-group-item check_" id="LJ1check_53" for="J1check_53"><span class="label-item">53</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="54" id="J1check_54"/><span class="button-group-item check_" id="LJ1check_54" for="J1check_54"><span class="label-item">54</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="55" id="J1check_55"/><span class="button-group-item check_" id="LJ1check_55" for="J1check_55"><span class="label-item">55</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="56" id="J1check_56"/><span class="button-group-item check_" id="LJ1check_56" for="J1check_56"><span class="label-item">56</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="57" id="J1check_57"/><span class="button-group-item check_" id="LJ1check_57" for="J1check_57"><span class="label-item">57</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="58" id="J1check_58"/><span class="button-group-item check_" id="LJ1check_58" for="J1check_58"><span class="label-item">58</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="59" id="J1check_59"/><span class="button-group-item check_" id="LJ1check_59" for="J1check_59"><span class="label-item">59</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="60" id="J1check_60"/><span class="button-group-item check_" id="LJ1check_60" for="J1check_60"><span class="label-item">60</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="61" id="J1check_61"/><span class="button-group-item check_" id="LJ1check_61" for="J1check_61"><span class="label-item">61</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="62" id="J1check_62"/><span class="button-group-item check_" id="LJ1check_62" for="J1check_62"><span class="label-item">62</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="63" id="J1check_63"/><span class="button-group-item check_" id="LJ1check_63" for="J1check_63"><span class="label-item">63</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="64" id="J1check_64"/><span class="button-group-item check_" id="LJ1check_64" for="J1check_64"><span class="label-item">64</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="65" id="J1check_65"/><span class="button-group-item check_" id="LJ1check_65" for="J1check_65"><span class="label-item">65</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="66" id="J1check_66"/><span class="button-group-item check_" id="LJ1check_66" for="J1check_66"><span class="label-item">66</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="67" id="J1check_67"/><span class="button-group-item check_" id="LJ1check_67" for="J1check_67"><span class="label-item">67</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="68" id="J1check_68"/><span class="button-group-item check_" id="LJ1check_68" for="J1check_68"><span class="label-item">68</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="69" id="J1check_69"/><span class="button-group-item check_" id="LJ1check_69" for="J1check_69"><span class="label-item">69</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="70" id="J1check_70"/><span class="button-group-item check_" id="LJ1check_70" for="J1check_70"><span class="label-item">70</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="71" id="J1check_71"/><span class="button-group-item check_" id="LJ1check_71" for="J1check_71"><span class="label-item">71</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="72" id="J1check_72"/><span class="button-group-item check_" id="LJ1check_72" for="J1check_72"><span class="label-item">72</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="73" id="J1check_73"/><span class="button-group-item check_" id="LJ1check_73" for="J1check_73"><span class="label-item">73</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="74" id="J1check_74"/><span class="button-group-item check_" id="LJ1check_74" for="J1check_74"><span class="label-item">74</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="75" id="J1check_75"/><span class="button-group-item check_" id="LJ1check_75" for="J1check_75"><span class="label-item">75</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="76" id="J1check_76"/><span class="button-group-item check_" id="LJ1check_76" for="J1check_76"><span class="label-item">76</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="77" id="J1check_77"/><span class="button-group-item check_" id="LJ1check_77" for="J1check_77"><span class="label-item">77</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="78" id="J1check_78"/><span class="button-group-item check_" id="LJ1check_78" for="J1check_78"><span class="label-item">78</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="79" id="J1check_79"/><span class="button-group-item check_" id="LJ1check_79" for="J1check_79"><span class="label-item">79</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="80" id="J1check_80"/><span class="button-group-item check_" id="LJ1check_80" for="J1check_80"><span class="label-item">80</span></span>
                                                                                        </label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="footer-single-game">
                                                                                <div class="row no-gutters">
                                                                                    <div class="col-6">
                                                                                        <div class="footer-single-left">
                                                                                            <button type="button" id="J1random" class="random button button-block button-light-purple button-sm button-no-shadow">Azar</button>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-6">
                                                                                        <div class="footer-single-right">
                                                                                            <button type="button" id="J1clear" class="clear button button-block button-light-purple button-sm button-no-shadow">Limpiar</button>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="box-content-detail">

                                                                            <div class="optional-single-game">
                                                                                <div class="single-box-game">
                                                                                    <div class="top-single-box">
                                                                                        <div class="step-play-desc">Multiplica tu premio por: (Opcional)</div>
                                                                                    </div>
                                                                                    <div class="body-single-box">
                                                                                        <div class="body-game">
                                                                                            <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                            	<label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_1" value="1"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_1" for="J1YBBcheck_1"><span class="label-item">1</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_2" value="2"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_2" for="J1YBBcheck_2"><span class="label-item">2</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_3" value="3"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_3" for="J1YBBcheck_3"><span class="label-item">3</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_4" value="4"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_4" for="J1YBBcheck_4"><span class="label-item">4</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_5" value="5"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_5" for="J1YBBcheck_5"><span class="label-item">5</span></span>
                                                                                                </label>
                                                                                            </div>
                                                                                            <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                            	<label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_10" value="10"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_10" for="J1YBBcheck_10"><span class="label-item">10</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_20" value="20"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_20" for="J1YBBcheck_20"><span class="label-item">20</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_30" value="30"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_30" for="J1YBBcheck_30"><span class="label-item">30</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_40" value="40"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_40" for="J1YBBcheck_40"><span class="label-item">40</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J1YBBcheck_50" value="50"/><span class="button-group-item LcheckYBB" id="LJ1YBBcheck_50" for="J1YBBcheck_50"><span class="label-item">50</span></span>
                                                                                                </label>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                            <h5>Tus números son</h5>
                                                                            <textarea id="J1-text-area" class="current-numbers" readonly="readonly"></textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div id="J2" class="plays">
                                                                    <div class="box-play-main box-play-b" style="display: none;">
                                                                        <div class="content-single-game">
                                                                            <div class="top-single-game no-border">
                                                                                <h3>JUGADA B</h3>
                                                                            </div>
                                                                            <div class="single-box-game">
                                                                                <div class="top-single-box">
                                                                                    <div class="step-play">1: ELIGE TU JUGADA</div>
                                                                                    <div class="step-play-desc">¿Cuántos números quieres acertar?</div>
                                                                                </div>
                                                                                <div class="body-single-box">
                                                                                    <div class="body-game">
                                                                                        <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                        	<label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_1" value="1"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_1" for="J2YBAcheck_1"><span class="label-item">1</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_2" value="2"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_2" for="J2YBAcheck_2"><span class="label-item">2</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_3" value="3"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_3" for="J2YBAcheck_3"><span class="label-item">3</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_4" value="4"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_4" for="J2YBAcheck_4"><span class="label-item">4</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_5" value="5"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_5" for="J2YBAcheck_5"><span class="label-item">5</span></span>
                                                                                            </label>
                                                                                        </div>
                                                                                        <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_6" value="6"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_6" for="J2YBAcheck_6"><span class="label-item">6</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_7" value="7"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_7" for="J2YBAcheck_7"><span class="label-item">7</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_8" value="8"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_8" for="J2YBAcheck_8"><span class="label-item">8</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_9" value="9"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_9" for="J2YBAcheck_9"><span class="label-item">9</span></span>
                                                                                            </label>
                                                                                            <label>
                                                                                              <input class="checkYBA" type="checkbox" id="J2YBAcheck_10" value="10"/><span class="button-group-item LcheckYBA" id="LJ2YBAcheck_10" for="J2YBAcheck_10"><span class="label-item">10</span></span>
                                                                                            </label>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="single-box-game">
                                                                                <div class="top-single-box no-m-b">
                                                                                    <div class="step-play">2: ELIGE TUS NÚMEROS</div>
                                                                                    <!-- div class="step-play-desc">Marca 6 bolillas o más</div -->
                                                                                </div>
                                                                            </div>
                                                                            <div class="body-single-game">
                                                                                <div class="body-game">
                                                                                    <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                        
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="1" id="J2check_1"/><span class="button-group-item check_" id="LJ2check_1" for="J2check_1"><span class="label-item">1</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="2" id="J2check_2"/><span class="button-group-item check_" id="LJ2check_2" for="J2check_2"><span class="label-item">2</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="3" id="J2check_3"/><span class="button-group-item check_" id="LJ2check_3" for="J2check_3"><span class="label-item">3</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="4" id="J2check_4"/><span class="button-group-item check_" id="LJ2check_4" for="J2check_4"><span class="label-item">4</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="5" id="J2check_5"/><span class="button-group-item check_" id="LJ2check_5" for="J2check_5"><span class="label-item">5</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="6" id="J2check_6"/><span class="button-group-item check_" id="LJ2check_6" for="J2check_6"><span class="label-item">6</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="7" id="J2check_7"/><span class="button-group-item check_" id="LJ2check_7" for="J2check_7"><span class="label-item">7</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="8" id="J2check_8"/><span class="button-group-item check_" id="LJ2check_8" for="J2check_8"><span class="label-item">8</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="9" id="J2check_9"/><span class="button-group-item check_" id="LJ2check_9" for="J2check_9"><span class="label-item">9</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="10" id="J2check_10"/><span class="button-group-item check_" id="LJ2check_10" for="J2check_10"><span class="label-item">10</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="11" id="J2check_11"/><span class="button-group-item check_" id="LJ2check_11" for="J2check_11"><span class="label-item">11</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="12" id="J2check_12"/><span class="button-group-item check_" id="LJ2check_12" for="J2check_12"><span class="label-item">12</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="13" id="J2check_13"/><span class="button-group-item check_" id="LJ2check_13" for="J2check_13"><span class="label-item">13</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="14" id="J2check_14"/><span class="button-group-item check_" id="LJ2check_14" for="J2check_14"><span class="label-item">14</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="15" id="J2check_15"/><span class="button-group-item check_" id="LJ2check_15" for="J2check_15"><span class="label-item">15</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="16" id="J2check_16"/><span class="button-group-item check_" id="LJ2check_16" for="J2check_16"><span class="label-item">16</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="17" id="J2check_17"/><span class="button-group-item check_" id="LJ2check_17" for="J2check_17"><span class="label-item">17</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="18" id="J2check_18"/><span class="button-group-item check_" id="LJ2check_18" for="J2check_18"><span class="label-item">18</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="19" id="J2check_19"/><span class="button-group-item check_" id="LJ2check_19" for="J2check_19"><span class="label-item">19</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="20" id="J2check_20"/><span class="button-group-item check_" id="LJ2check_20" for="J2check_20"><span class="label-item">20</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="21" id="J2check_21"/><span class="button-group-item check_" id="LJ2check_21" for="J2check_21"><span class="label-item">21</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="22" id="J2check_22"/><span class="button-group-item check_" id="LJ2check_22" for="J2check_22"><span class="label-item">22</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="23" id="J2check_23"/><span class="button-group-item check_" id="LJ2check_23" for="J2check_23"><span class="label-item">23</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="24" id="J2check_24"/><span class="button-group-item check_" id="LJ2check_24" for="J2check_24"><span class="label-item">24</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="25" id="J2check_25"/><span class="button-group-item check_" id="LJ2check_25" for="J2check_25"><span class="label-item">25</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="26" id="J2check_26"/><span class="button-group-item check_" id="LJ2check_26" for="J2check_26"><span class="label-item">26</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="27" id="J2check_27"/><span class="button-group-item check_" id="LJ2check_27" for="J2check_27"><span class="label-item">27</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="28" id="J2check_28"/><span class="button-group-item check_" id="LJ2check_28" for="J2check_28"><span class="label-item">28</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="29" id="J2check_29"/><span class="button-group-item check_" id="LJ2check_29" for="J2check_29"><span class="label-item">29</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="30" id="J2check_30"/><span class="button-group-item check_" id="LJ2check_30" for="J2check_30"><span class="label-item">30</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="31" id="J2check_31"/><span class="button-group-item check_" id="LJ2check_31" for="J2check_31"><span class="label-item">31</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="32" id="J2check_32"/><span class="button-group-item check_" id="LJ2check_32" for="J2check_32"><span class="label-item">32</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="33" id="J2check_33"/><span class="button-group-item check_" id="LJ2check_33" for="J2check_33"><span class="label-item">33</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="34" id="J2check_34"/><span class="button-group-item check_" id="LJ2check_34" for="J2check_34"><span class="label-item">34</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="35" id="J2check_35"/><span class="button-group-item check_" id="LJ2check_35" for="J2check_35"><span class="label-item">35</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="36" id="J2check_36"/><span class="button-group-item check_" id="LJ2check_36" for="J2check_36"><span class="label-item">36</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="37" id="J2check_37"/><span class="button-group-item check_" id="LJ2check_37" for="J2check_37"><span class="label-item">37</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="38" id="J2check_38"/><span class="button-group-item check_" id="LJ2check_38" for="J2check_38"><span class="label-item">38</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="39" id="J2check_39"/><span class="button-group-item check_" id="LJ2check_39" for="J2check_39"><span class="label-item">39</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="40" id="J2check_40"/><span class="button-group-item check_" id="LJ2check_40" for="J2check_40"><span class="label-item">40</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="41" id="J2check_41"/><span class="button-group-item check_" id="LJ2check_41" for="J2check_41"><span class="label-item">41</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="42" id="J2check_42"/><span class="button-group-item check_" id="LJ2check_42" for="J2check_42"><span class="label-item">42</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="43" id="J2check_43"/><span class="button-group-item check_" id="LJ2check_43" for="J2check_43"><span class="label-item">43</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="44" id="J2check_44"/><span class="button-group-item check_" id="LJ2check_44" for="J2check_44"><span class="label-item">44</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="45" id="J2check_45"/><span class="button-group-item check_" id="LJ2check_45" for="J2check_45"><span class="label-item">45</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="46" id="J2check_46"/><span class="button-group-item check_" id="LJ2check_46" for="J2check_46"><span class="label-item">46</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="47" id="J2check_47"/><span class="button-group-item check_" id="LJ2check_47" for="J2check_47"><span class="label-item">47</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="48" id="J2check_48"/><span class="button-group-item check_" id="LJ2check_48" for="J2check_48"><span class="label-item">48</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="49" id="J2check_49"/><span class="button-group-item check_" id="LJ2check_49" for="J2check_49"><span class="label-item">49</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="50" id="J2check_50"/><span class="button-group-item check_" id="LJ2check_50" for="J2check_50"><span class="label-item">50</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="51" id="J2check_51"/><span class="button-group-item check_" id="LJ2check_51" for="J2check_51"><span class="label-item">51</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="52" id="J2check_52"/><span class="button-group-item check_" id="LJ2check_52" for="J2check_52"><span class="label-item">52</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="53" id="J2check_53"/><span class="button-group-item check_" id="LJ2check_53" for="J2check_53"><span class="label-item">53</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="54" id="J2check_54"/><span class="button-group-item check_" id="LJ2check_54" for="J2check_54"><span class="label-item">54</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="55" id="J2check_55"/><span class="button-group-item check_" id="LJ2check_55" for="J2check_55"><span class="label-item">55</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="56" id="J2check_56"/><span class="button-group-item check_" id="LJ2check_56" for="J2check_56"><span class="label-item">56</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="57" id="J2check_57"/><span class="button-group-item check_" id="LJ2check_57" for="J2check_57"><span class="label-item">57</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="58" id="J2check_58"/><span class="button-group-item check_" id="LJ2check_58" for="J2check_58"><span class="label-item">58</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="59" id="J2check_59"/><span class="button-group-item check_" id="LJ2check_59" for="J2check_59"><span class="label-item">59</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="60" id="J2check_60"/><span class="button-group-item check_" id="LJ2check_60" for="J2check_60"><span class="label-item">60</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="61" id="J2check_61"/><span class="button-group-item check_" id="LJ2check_61" for="J2check_61"><span class="label-item">61</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="62" id="J2check_62"/><span class="button-group-item check_" id="LJ2check_62" for="J2check_62"><span class="label-item">62</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="63" id="J2check_63"/><span class="button-group-item check_" id="LJ2check_63" for="J2check_63"><span class="label-item">63</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="64" id="J2check_64"/><span class="button-group-item check_" id="LJ2check_64" for="J2check_64"><span class="label-item">64</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="65" id="J2check_65"/><span class="button-group-item check_" id="LJ2check_65" for="J2check_65"><span class="label-item">65</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="66" id="J2check_66"/><span class="button-group-item check_" id="LJ2check_66" for="J2check_66"><span class="label-item">66</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="67" id="J2check_67"/><span class="button-group-item check_" id="LJ2check_67" for="J2check_67"><span class="label-item">67</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="68" id="J2check_68"/><span class="button-group-item check_" id="LJ2check_68" for="J2check_68"><span class="label-item">68</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="69" id="J2check_69"/><span class="button-group-item check_" id="LJ2check_69" for="J2check_69"><span class="label-item">69</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="70" id="J2check_70"/><span class="button-group-item check_" id="LJ2check_70" for="J2check_70"><span class="label-item">70</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="71" id="J2check_71"/><span class="button-group-item check_" id="LJ2check_71" for="J2check_71"><span class="label-item">71</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="72" id="J2check_72"/><span class="button-group-item check_" id="LJ2check_72" for="J2check_72"><span class="label-item">72</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="73" id="J2check_73"/><span class="button-group-item check_" id="LJ2check_73" for="J2check_73"><span class="label-item">73</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="74" id="J2check_74"/><span class="button-group-item check_" id="LJ2check_74" for="J2check_74"><span class="label-item">74</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="75" id="J2check_75"/><span class="button-group-item check_" id="LJ2check_75" for="J2check_75"><span class="label-item">75</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="76" id="J2check_76"/><span class="button-group-item check_" id="LJ2check_76" for="J2check_76"><span class="label-item">76</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="77" id="J2check_77"/><span class="button-group-item check_" id="LJ2check_77" for="J2check_77"><span class="label-item">77</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="78" id="J2check_78"/><span class="button-group-item check_" id="LJ2check_78" for="J2check_78"><span class="label-item">78</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="79" id="J2check_79"/><span class="button-group-item check_" id="LJ2check_79" for="J2check_79"><span class="label-item">79</span></span>
                                                                                        </label>
                                                                                        <label>
                                                                                          <input class="check" type="checkbox" value="80" id="J2check_80"/><span class="button-group-item check_" id="LJ2check_80" for="J2check_80"><span class="label-item">80</span></span>
                                                                                        </label>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                            <div class="footer-single-game">
                                                                                <div class="row no-gutters">
                                                                                    <div class="col-6">
                                                                                        <div class="footer-single-left">
                                                                                            <button type="button" id="J2random" class="random button button-block button-light-purple button-sm button-no-shadow">Azar</button>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="col-6">
                                                                                        <div class="footer-single-right">
                                                                                            <button type="button" id="J2clear" class="clear button button-block button-light-purple button-sm button-no-shadow">Limpiar</button>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="box-content-detail">

                                                                            <div class="optional-single-game">
                                                                                <div class="single-box-game">
                                                                                    <div class="top-single-box">
                                                                                        <div class="step-play-desc">Multiplica tu premio por: (Opcional)</div>
                                                                                    </div>
                                                                                    <div class="body-single-box">
                                                                                        <div class="body-game">
                                                                                            <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_1" value="1"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_1" for="J2YBBcheck_1"><span class="label-item">1</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_2" value="2"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_2" for="J2YBBcheck_2"><span class="label-item">2</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_3" value="3"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_3" for="J2YBBcheck_3"><span class="label-item">3</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_4" value="4"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_4" for="J2YBBcheck_4"><span class="label-item">4</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_5" value="5"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_5" for="J2YBBcheck_5"><span class="label-item">5</span></span>
                                                                                                </label>
                                                                                            </div>
                                                                                            <div class="button-group checkboxes-ball ball-sm clearfix">
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_10" value="10"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_10" for="J2YBBcheck_10"><span class="label-item">10</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_20" value="20"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_20" for="J2YBBcheck_20"><span class="label-item">20</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_30" value="30"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_30" for="J2YBBcheck_30"><span class="label-item">30</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_40" value="40"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_40" for="J2YBBcheck_40"><span class="label-item">40</span></span>
                                                                                                </label>
                                                                                                <label>
                                                                                                  <input class="checkYBB" type="checkbox" id="J2YBBcheck_50" value="50"/><span class="button-group-item LcheckYBB" id="LJ2YBBcheck_50" for="J2YBBcheck_50"><span class="label-item">50</span></span>
                                                                                                </label>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                </div>
                                                                            </div>

                                                                            <h5>Tus números son</h5>
                                                                            <textarea id="J2-text-area" class="current-numbers" readonly="readonly"></textarea>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="col-6">
                                                        <div class="box-wrapper-game box-content-right">
                                                            <div class="box-content-game">
                                                                <div class="current-games">
                                                                    <div class="boxes-current-games clearfix">
                                                                        <div data-game="a" class="box-current-game game-playing">
                                                                            <a href="#">A</a>
                                                                        </div>
                                                                        <div data-game="b" class="box-current-game">
                                                                            <a href="#">B</a>
                                                                        </div>
                                                                    </div>
                                                                </div>

                                                                <div class="current-game-detail big-spacing">
                                                                    <h5>Elige en cuántos sorteos consecutivos jugarás:</h5>
                                                                    <div class="selectBox">

                                                                        <c:forEach items="${kineloSaleList}" var="kineloDrawData" begin="0" end="0">
                                                                            <div class="box" id="box">${kineloDrawData.messageDraw}</div>
                                                                        </c:forEach>
                                                                        <select name="model" id="mySelectBox"
                                                                            onChange="this.parentNode.getElementsByTagName('div')[0].innerHTML=this.options[this.selectedIndex].text">
                                                                            <c:forEach items="${kineloSaleList}" var="kineloDrawData" >
	                                                                            <option value="${kineloDrawData.numDraws}" >${kineloDrawData.messageDraw}</option>
                                                                            </c:forEach>
                                                                        </select>

                                                                    </div>
                                                                    
                                                                    <div class="main-box-detail">
                                                                        <span class="main-single-detail">
                                                                            <span class="detail-text">
                                                                                Costo por jugada: <span class="detail-value" id="price-message">${kineloSale.priceMessage}</span>
                                                                            </span>
                                                                        </span>
                                                                        <div class="main-single-detail">
                                                                            <span class="detail-text">
                                                                                Total Apuestas <span class="detail-value" id="total_bet">0</span>
                                                                            </span>
                                                                        </div>
                                                                        <div class="main-single-detail">
                                                                            <span class="detail-text">
                                                                                Gana hasta <span class="detail-value">S/ <span id="earn_up">0</span></span>
                                                                            </span>
                                                                        </div>
                                                                        <div class="main-single-detail">
                                                                            <span class="detail-text">
                                                                                Costo total <span class="detail-value">S/ <b id="total_apagar">0</b></span>
                                                                            </span>
                                                                        </div>
                                                                    </div>

                                                                    <div class="action-buy">
<!--                                                                         <button type="button" id="buy" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange"><b>COMPRAR</b></button> -->
                                                                         <button type="button" id="btn_desktop_comprar_boleto_kinelo" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange"><b>COMPRAR</b></button>
                                                                    </div>

                                                                </div>

                                                                
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="wrapper-buying">

                                        <div class="box-wrapper-game">
                                            <div class="box-content-game">
                                                <div class="top-single-game">
                                                    <!-- <h3>KINELO</h3> -->
                                                </div>
                                                <div class="body-single-game">
                                                    <div class="row">
                                                        <div class="col-6">
                                                            
                                                            <div class="left-panel">
                                                                <div id="content-grid-result"></div>
                                                                <div id="num_link"></div>
                                                            </div>

                                                        </div>
                                                        <div class="col-6">
                                                            <div class="detail-pay">
                                                                <h5>TOTAL <span class="label_2 detail-pay-date"></span></h5>
                                                            </div>
															<div class="box-detail-pay">
                                                                <h4><span class="label_resu5"></span><div class="text-detail-pay detail-pay-monto result5"></div></h4>
                                                                <h4>Costo por jugada: <div class="text-detail-pay detail-pay-monto label_resu2"></div></h4>
                                                                <h4><div class="text-detail-pay label_resu3"></div></h4>
                                                                <h4><div class="text-detail-pay label_resu4"></div></h4>
                                                                <h4><b><span class="label_resu1">Total a pagar</span></b><div class="text-detail-pay detail-pay-monto result1"></div></h4>
                                                            </div>
                                                            <div class="box-action-pay">
                                                                <div id="panel_more_plays">
                                                                    <span class="labelMsgJugadaGratis"></span>
                                                                    <button type="button" id="more_plays" class="button button-lg button-no-shadow button-block button-green-new">
                                                                        <b>AGREGAR JUGADAS</b>
                                                                    </button>
                                                                </div>
                                                                <div id="panel_keep-playing">
                                                                    <a onclick="datalayerGraciasCompra('SEGUIR JUGANDO','Seguir Jugando');" href="juega-kinelo.html" id="keep-playing" class="button button-lg button-no-shadow button-block button-orange">
                                                                        <b>SEGUIR JUGANDO</b>
                                                                    </a>
                                                                </div>
                                                                <div id="panel_game-history">
                                                                    <a onclick="datalayerGraciasCompra('IR A MIS JUGADAS','ir a mis jugadas');" href="mi-cuenta.html#jugadas" id="game-history" class="button button-lg button-no-shadow button-block button-dark-green">
                                                                        <b>IR A MIS JUGADAS</b>
                                                                    </a>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="wrapper-purchase">
                                                    <div id="sub_panel">
                                                        <%@ include file="../../include/login.jspf" %>
														<form id="frmLoadBalance">
															<div id="payments_section">
																<div class="tab-item accordion-off" id="tab-item_4" data-hash="saldo" style="display:block;">
													                <div class="accordion-ico">
													                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M9.5,16.72c-1.79,0-3.18-.55-3.83-2.16l1.38-.72a2.5,2.5,0,0,0,2.47,1.39c1,0,2-.36,2-1.32s-.87-1.17-2-1.29c-1.79-.21-3.45-.69-3.45-2.66,0-1.81,1.78-2.55,3.4-2.56a3.55,3.55,0,0,1,3.45,1.74l-1.32.68a2.52,2.52,0,0,0-2.08-1c-1.23,0-1.82.51-1.82,1.17s.9,1,2,1.1c1.83.23,3.54.7,3.54,2.8S11.46,16.72,9.5,16.72Zm5.38.65H13.6L17,8.81h1.29Z"/></g></g></svg>
													                </div>
													                <div class="title-accordion">CARGAR SALDO</div>
													                <i></i>
													                <input type="hidden" id="marca_logo" value="logo-kinelo.png">
													            </div>
													            <div id="content-tab-item_4" class="tab-content accordion-on" style="display:none;">
													                <div class="head-tab-content group" data-tab="tab-item_4">
													                    <div class="accordion-ico">
													                    	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M9.5,16.72c-1.79,0-3.18-.55-3.83-2.16l1.38-.72a2.5,2.5,0,0,0,2.47,1.39c1,0,2-.36,2-1.32s-.87-1.17-2-1.29c-1.79-.21-3.45-.69-3.45-2.66,0-1.81,1.78-2.55,3.4-2.56a3.55,3.55,0,0,1,3.45,1.74l-1.32.68a2.52,2.52,0,0,0-2.08-1c-1.23,0-1.82.51-1.82,1.17s.9,1,2,1.1c1.83.23,3.54.7,3.54,2.8S11.46,16.72,9.5,16.72Zm5.38.65H13.6L17,8.81h1.29Z"/></g></g></svg>
													                    </div>
													                    <div class="title-accordion">CARGAR SALDO</div>
																		<i></i>
													                </div>
		                                                            <div id="pan_0">
		                                                                <div class="label1">PAGAR</div>
		                                                                <table>
		                                                                    <tr>
		                                                                        <td><input type="radio" name="option-card" checked="checked" value="0" id="option-card-0"/></td>
		                                                                        <td>
		                                                                            <label for="option-card-0">
		                                                                                <span>Quiero descontar de mi saldo disponible S/ </span>
		                                                                                <span id="field-balance-amount">${kineloSale.balanceBill01}</span>
		                                                                            </label>
		                                                                        </td>
		                                                                    </tr>
		                                                                </table>
		                                                            </div>
<!-- 		                                                            <div id="separator_hr"></div> -->
<!-- 		                                                            <div class="top-saldo wb-saldo"></div> -->
<!-- 		                                                            <div id="pan_1"> -->
<!-- 		                                                                <div class="label2">RECARGAS POR INTERNET</div> -->
<!-- 		                                                                <table> -->
<%-- 		                                                                    <c:forTokens var="channel1Order" items="${kineloSale.channel1Order}" delims=","> --%>
<%-- 		                                                                        <%@ include file="../../include/balance1.jspf"%> --%>
<%-- 		                                                                    </c:forTokens> --%>
<!-- 		                                                                </table> -->
<!-- 		                                                                <div class="label2">RECARGAS F&Iacute;SICAS</div> -->
<!-- 		                                                                <table> -->
<%-- 		                                                                    <c:forTokens var="channel2Order" items="${kineloSale.channel2Order}" delims=","> --%>
<%-- 		                                                                        <%@ include file="../../include/balance2.jspf"%> --%>
<%-- 		                                                                    </c:forTokens> --%>
<!-- 		                                                                </table> -->
<!-- 		                                                            </div> -->
<!-- 		                                                            <div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div> -->
																</div>
															</div>
	                                                    </form>
                                                    </div>
                                                    <div id="panel_finaliza_compra">
<!--                                                         <a href="#" class="button button-dark-green" id='btn_desktop_finalizar_compra_kinelo' onclick="return false;">FINALIZAR TU COMPRA</a> -->
                                                        <a href="#" class="button button-dark-green button-red-new" id='btn_desktop_finalizar_compra_kinelo' onclick="return false;">FINALIZAR TU COMPRA</a>
                                                    </div>

                                                    <div class="clearfix"></div>

                                                    <div id="ico-block">
                                                        <div id="ico-title">¡SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
                                                        <div id="ico-panel" class="clearfix">
                                                        
                                                            <a href="juega-tinka.html" class="button-ico ico-tinka" id='icotinka'>
                                                                <img src="./layer-view-image/v2/logo-tinka.svg?v=3" alt="Jugar La Tinka Lotería" />
                                                            </a>
                                                            <a href="juega-kabala.html" class="button-ico ico-kabala" id='icokabala'>
                                                                <img src="./layer-view-image/v2/logo-kabala.svg" alt="Jugar Kabala" />
                                                            </a>
                                                            <a href="juega-ganadiario.html" class="button-ico ico-ganadiario" id='icoganadiario'>
                                                                <img src="./layer-view-image/v2/logo-ganadiario.svg" alt="Jugar Gana Diario" />
                                                            </a>
                                                            <a href="juega-latinka-video-loterias.html" class="button-ico ico-videoloteria" id='btn_desktop_home_videoloteria'>
													            <img src="./layer-view-image/v2/landing/svg/videoloterias.png?v=1" alt="Jugar Video Loteria" />
													        </a>
                                                            <a href="juega-kinelo.html" class="button-ico ico-kinelo" id='icokinelo'>
                                                                <img src="./layer-view-image/v2/logo-kinelo.png" alt="Jugar Kinelo" />
                                                            </a>
                                                            <a href="juega-ganagol.html" class="button-ico ico-ganagol" id='icoganagol'>
                                                                <img src="./layer-view-image/v2/logo-ganagol.svg" alt="Jugar Ganagol Apuestas de Fútbol" />
                                                            </a>
                                                            <a onclick="toTAV2();" class="button-ico ico-teapuesto hand" id='icoteapuesto'>
                                                                <img src="./layer-view-image/v2/logo-teapuesto.png?v=1" alt="Jugar Te Apuesto Apuestas Deportivas" />
                                                            </a>
                                                        </div>
                                                    </div>

                                                    <div class="save-zone-game">
                                                        <div class="text-zone-game">
                                                            <img src="layer-view-image/v2/zona-segura.svg" alt="" />
                                                            <span>TE ENCUENTRAS EN ZONA SEGURA</span>
                                                        </div>
                                                    </div>

                                                </div>
                                            </div>

                                        </div>

                                    </div>

                                </div>

                            </div>

                        </div>
                    </div>
                    <div class="col-12 col-md-4">
                        <aside class="banner">
                            <div class="boxes-banner">
								
								<c:set var = "comunicadoKinelo" scope = "session" value ='<%=ConnectionFactory.operationProperty("comunicadoKinelo", Constants.contextSale).trim()%>' />
								<c:if test="${comunicadoKinelo == true}">
									<div class="box-main-game-alert">
										<h2><%=ConnectionFactory.operationProperty("titleKineloMessage", Constants.contextSale)%></h2>
										<p class="message-game-alert"><%=ConnectionFactory.operationProperty("contentKineloMessage", Constants.contextSale)%></p>
									</div>
								</c:if>
								<div id="iframeTool">
		        					<iframe id="myIframe" src="${iframeHomeKineloURL}" frameborder="0" scrolling="no" ><p>Is imposible, your browser dont support iframe</p></iframe>
		        				</div>
                         		<!-- 
                                <div class="box-banner">
                                    <div class="box-main-game">
                                        <div class="box-main-desc">
                                            <figure>
                                                <img src="layer-view-image/v2/logo-kinelo.png" alt="Jugar Kinelo" />
                                            </figure>
                                            <div class="main-desc-slogan">¡JUÉGALO CADA 5 MINUTOS!</div>
                                        </div>
                                    </div>
                                </div>
								-->
                                <div class="box-banner">
                                    <div class="box-main-game">
                                        <div class="box-last-game">

                                            <h4>JUGADA GANADORA</h4>
                                            <div class="boxes-last-result" id="kinelo-results"></div>

                                            <div class="action-box-banner">
                                                <a href="javascript:openDivLayer('resultados','kinelo','<%=Constants.resultsServerURI%>i.do?m=resultados&t=0&s=1121',600,420);" class="button button-light-purple button-block">RESULTADOS ANTERIORES</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div class="box-banner">
                                    <div class="box-main-game">
										<a target="_self" href="<%=Constants.URL_QW%>/como-jugar/kinelo/?origin=i" class="how-to-play"></a>
                                    </div>
                                </div>
                                <div class="box-banner">
			        				<a href="https://www.facebook.com/latinkaoficial" target="_blank" class="box-social">
			        					<img src="./layer-view-image/v2/facebook.png" alt="" />
			        				</a>
			        			</div>

                            </div>
                        </aside>
                    </div>
                </div>

            </div>

        </div>
    </div>
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/kinelo/lotto-kinelo.js?v=3"></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js?v=3'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<%@ include file="../../include/footer.jspf" %>
    <script type="text/javascript">

        function printKineloBalls(balls) {
            var html = "";
            for (var i = 0; i < balls.length; i++) {
                if (balls[i]) {
                    html += '<div class="result-ball">\
                                <div class="ball"><span>' + balls[i] + '</span></div>\
                            </div> '
                }
            }
            return html;
        }

        $(document).ready(function(){

            $.ajax({
              url: $("#portalServiceKinelo").val(),
              cache: false,
              success: function(res) {

                var results = res.resultKinelo;

                var todo = "";

                for (var i = 0; i < results.length; i++) {
                    todo += '<div class="box-last-result">\
                                <h3><span>SORTEO <span>' + results[i].draw + '</span></span> <span><span>' + results[i].hour + '</span>Hrs</span></h3>\
                                <div class="last-restuls">\
                                    <div class="results-balls clearfix">' + printKineloBalls(results[i].bolos.split(' ')) + '</div>\
                                </div>\
                            </div>';
                }

                $('#kinelo-results').html(todo)

              }, error: function(e) {
                console.log('error obteniendo json...')
              }
            });

            renderNewPasswordFieldGame();

        });

        $('#tab-item_4').on('click', function (event) {
    		datalayerFinalizaCompra2(this,'Cargar Saldo');
        });

        $("#icoraspaya, #icocasino, #icokinelo, #icotinka, #icoteapuesto, #icoddvv, #icokabala, #icoganagol, #icoganadiario").on('click',function(){
        	var textoAlt = $(this).children("img").attr('alt');
        	datalayerGraciasCompra(textoAlt,'Seguir jugando');
        });

    </script>


    
    	
    
    
    
    
</body>
</html>