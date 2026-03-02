<%@ include file="../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${isLottoSale == true && isGanagolSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=ganagol"/></c:if>
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
    "name": "Jugar Ganagol",
    "item": "https://www.latinka.com.pe/p/juega-ganagol.html" 
  }]
}
</script>
	<meta property="og:title" content="Juega Ganagol: Programas, Resultados y más ">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://www.latinka.com.pe/p/juega-ganagol.html">
	<meta property="og:description" content="¿Qué es Ganagol? Es uno de los juegos de apuestas deportivas más populares de La Tinka. ¡Encuentra los resultados de Ganagol aquí!">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-ganagol.png">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=1024">
	<title>Ganagol: Juega y gana pozos milonarios en la cancha. ¡Programas, Resultados y más! </title>
    <meta name='description' content="¿Qué es Ganagol? Es uno de los juegos de apuestas deportivas más populares de La Tinka. ¡Encuentra los resultados de Ganagol aquí!" />

<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/ganagol/theme.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/ganagol/themeGanagol.css?v=1">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">   

    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />

    <%--<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script> 
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>--%>
    <script type="text/javascript" src="layer-view-script/game/ganagol/tagging-ganagol.js?v=2"></script>

</head>
<body>
	<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
<h1 style="display: none;">Jugar Ganagol</h1>

	<%@ include file="../../include/header.jspf"%>
	<div id="mensajeNotificacion">
			
	</div>

	<%-- <input type="hidden" value="${ganagolSale.status}" id="status"> --%>
	<input type="hidden" value="ACT" id="status">
	<input type="hidden" value="${ganagolSale.priceType}" id="priceType">
    <input type="hidden" value="${ganagolSale.simpleBetPrice}" id="simpleBetPrice">
    <input type="hidden" value="${ganagolSale.promotionType}" id="promotionType">
    <input type="hidden" value="${ganagolSale.balanceAmount}" disabled="disabled" class="visible" id="balanceAmount">
    <input type="hidden" value="${ganagolSale.balanceAmountGame}" id="balanceAmountGame">
    <input type="hidden" value="${ganagolSale.balanceQuantityGame}" id="balanceQuantityGame">
	<input type="hidden" value="${ganagolSale.algorithm}" id="algorithm">
	<input type="hidden" value="${ganagolSale.bets}" id="bets">
	<input type="hidden" value="${ganagolSale.pay}" id="pay">
	<input type="hidden" value="${ganagolSale.draws}" id="draws">
	<input type="hidden" value="${ganagolSale.cost}" id="cost">
	<input type="hidden" value="${ganagolSale.prize}" id="prize">
    <input type="hidden" value="<%=Constants.iflexBonoTyC.toString().trim()%>" id="iflexBonoTyC" />
    <input type="hidden" value="<%=Constants.wbBonoTyC.toString().trim()%>" id="wbBonoTyC">
    <input type="hidden" value="<c:out value='${clientBalance}'/>" id="clientBalance" >
    <input type="hidden" value="<c:out value='${chargeData}'/>" id="chargeData">
	<input type="hidden" id="totalPagar">

	<input type="hidden" value="Apuestas Deportivas" id="TipoZona">
	<input type="hidden" value="Gana Gol" id="Zona">
	<input type="hidden" value="" id="SubZona">

    <input type="hidden" value="${ganagolSale.promotionMessage}" id="promotionMessage">


    <c:forEach items="${ganagolSaleList}" var="ganagolSaleList" begin="0" end="13">
		<input type='hidden' class='ganagolList'
			value="${ganagolSaleList.item}|${ganagolSaleList.local}|${ganagolSaleList.imageLocal}|${ganagolSaleList.imageVisitor}|${ganagolSaleList.visitor}|${ganagolSaleList.imageCup}|${ganagolSaleList.cup}|${ganagolSaleList.odds}|${ganagolSaleList.notes}|${ganagolSaleList.imageLocal}|${ganagolSaleList.imageVisitor}">
	</c:forEach>

	<div class="main-content">
		<div class="main-page">

			<div class="main-game main-ganagol">

				<div class="action-float">
					<button class="button button-black-linear"
						onclick="openGanagolCotejador();">COTEJA TU BOLETO</button>
				</div>

				<div class="row">
					<div class="col-12 col-md-8">
						<div class="box-main-game top-box">
							<div class="top-banner top-ganagol">
								<figure>
									<img src="layer-view-image/v2/logo-ganagol.svg" alt="Jugar Ganagol Apuestas de Fútbol" />
								</figure>
								<div class="body-banner">
									<div class="left-banner">
										<div class="banner-price">
											<c:choose>
												<c:when
													test="${ganagolSale.prize == 'POZO ACUMULADO POR DEFINIR'}">
													<div class="sub-banner">
														<h4>Programa ${ganagolSale.lastDraw}</h4>
														<h4>POZO EN JUEGO</h4>
													</div>
													<h3>S/ ${ganagolSale.lastPrize}</h3>
												</c:when>
												<c:otherwise>
													<div class="sub-banner">
														<h4>POZO</h4>
														<h4>ACUMULADO</h4>
													</div>
													<h3>S/ ${ganagolSale.prize}</h3>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
									<div class="right-banner">
										<div class="banner-desc">
											<c:if test="${ganagolSale.status == 'ACT'}">
												<p>Juégalo</p>
												<p>hasta ${ganagolSale.closeHour}</p>
												<p>${ganagolSale.closeDate}</p>
											</c:if>
											<c:if test="${ganagolSale.status == 'LST'}">
												<p>Cerrado a las</p>
												<p>${ganagolSale.lastCloseHour}</p>
											</c:if>
											<c:if test="${ganagolSale.status == 'CIE'}">
												<!-- <p>Próximo sorteo</p> -->
												<p>Abre ${ganagolSale.openDate}</p>
												<p>a las ${ganagolSale.openHour}</p>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="main-panel">

							<div class="main-play">

								<div class="steps-play">
									<div class="row no-gutters">
										<div class="col-6">
											<div class="step-play step-status-1 step-active">PASO
												1: ELIGE TU JUGADA</div>
										</div>
										<div class="col-6">
											<div class="step-play step-status-2">PASO 2: FINALIZAR
												TU COMPRA</div>
										</div>
									</div>
								</div>

								<div class="body-play">

									<div class="wrapper-playing">

										<div class="wrapper-top-playing">
											<div class="box-wrapper-game">
												<div class="box-content-game">
													<div class="games-playing-ganagol">
														<div class="game-playing-ganagol">
															<h2>
																<b>JUGADA <span id="game-ganagol">01</span></b>
															</h2>
														</div>
														<c:if
															test="${ganagolSale.status == 'ACT' || ganagolSale.status == 'LST'}">
															<h3>
																Programa <b>${ganagolSale.program}</b>
															</h3>
														</c:if>
														<c:if test="${ganagolSale.status == 'CIE'}">
															<h3>
																Programa <b>${ganagolSale.nextDraw}</b>
															</h3>
														</c:if>
													</div>
													<div class="current-games">
														<div class="boxes-current-games clearfix">
															<div data-game="a" data-number="01"
																class="box-current-game game-playing">
																<a href="#">01</a>
															</div>
															<div data-game="b" data-number="02"
																class="box-current-game">
																<a href="#">02</a>
															</div>
															<div data-game="c" data-number="03"
																class="box-current-game">
																<a href="#">03</a>
															</div>
															<div data-game="d" data-number="04"
																class="box-current-game">
																<a href="#">04</a>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>

										<div class="boxes-playing clearfix">
											<div class="box-playing box-grilla">
												<div class="box-wrapper-game" style="height: 510px;">
													<div class="box-content-grid">
														<div id="grid_ganagol">
															<div id="message-next-programming">
																<div class="message-middle">
																	<p id="message-n-p1">¡Estamos en el entretiempo!</p>
																	<p class="mess-n-p">Ingresa nuevamente en unos
																		minutos,</p>
																	<p class="mess-n-p">la programación se encuentra en
																		proceso de publicación.</p>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="box-playing box-select-games">
												<div class="box-wrapper-game">
													<div class="box-content-grid">
														<div class="box-play-main box-play-a">
															<div class="content-single-game">
																<div class="content-help">
																	<a
																		href="<%=Constants.URL_QW%>/tutorial/como-jugar-ganagol/"
																		onclick="datalayerJugada('Ayuda','Elige tu Jugada');"
																		target="_blank" class="play-text"><span>?</span>
																		Ayuda</a>
																</div>
																<div class="body-content-grid">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">

																			<label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_1" value="L" data-row="0"
																				data-col="0" /><span
																				class="button-group-item check_" for="J1check_1"
																				id="LJ1check_1"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_2" value="E" data-row="0"
																				data-col="1" /><span
																				class="button-group-item check_" for="J1check_2"
																				id="LJ1check_2"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_3" value="V" data-row="0"
																				data-col="2" /><span
																				class="button-group-item check_" for="J1check_3"
																				id="LJ1check_3"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_4" value="L" data-row="1"
																				data-col="0" /><span
																				class="button-group-item check_" for="J1check_4"
																				id="LJ1check_4"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_5" value="E" data-row="1"
																				data-col="1" /><span
																				class="button-group-item check_" for="J1check_5"
																				id="LJ1check_5"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_6" value="V" data-row="1"
																				data-col="2" /><span
																				class="button-group-item check_" for="J1check_6"
																				id="LJ1check_6"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_7" value="L" data-row="2"
																				data-col="0" /><span
																				class="button-group-item check_" for="J1check_7"
																				id="LJ1check_7"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_8" value="E" data-row="2"
																				data-col="1" /><span
																				class="button-group-item check_" for="J1check_8"
																				id="LJ1check_8"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_9" value="V" data-row="2"
																				data-col="2" /><span
																				class="button-group-item check_" for="J1check_9"
																				id="LJ1check_9"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_10" value="L"
																				data-row="3" data-col="0" /><span
																				class="button-group-item check_" for="J1check_10"
																				id="LJ1check_10"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_11" value="E"
																				data-row="3" data-col="1" /><span
																				class="button-group-item check_" for="J1check_11"
																				id="LJ1check_11"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_12" value="V"
																				data-row="3" data-col="2" /><span
																				class="button-group-item check_" for="J1check_12"
																				id="LJ1check_12"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_13" value="L"
																				data-row="4" data-col="0" /><span
																				class="button-group-item check_" for="J1check_13"
																				id="LJ1check_13"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_14" value="E"
																				data-row="4" data-col="1" /><span
																				class="button-group-item check_" for="J1check_14"
																				id="LJ1check_14"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_15" value="V"
																				data-row="4" data-col="2" /><span
																				class="button-group-item check_" for="J1check_15"
																				id="LJ1check_15"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_16" value="L"
																				data-row="5" data-col="0" /><span
																				class="button-group-item check_" for="J1check_16"
																				id="LJ1check_16"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_17" value="E"
																				data-row="5" data-col="1" /><span
																				class="button-group-item check_" for="J1check_17"
																				id="LJ1check_17"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_18" value="V"
																				data-row="5" data-col="2" /><span
																				class="button-group-item check_" for="J1check_18"
																				id="LJ1check_18"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_19" value="L"
																				data-row="6" data-col="0" /><span
																				class="button-group-item check_" for="J1check_19"
																				id="LJ1check_19"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_20" value="E"
																				data-row="6" data-col="1" /><span
																				class="button-group-item check_" for="J1check_20"
																				id="LJ1check_20"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_21" value="V"
																				data-row="6" data-col="2" /><span
																				class="button-group-item check_" for="J1check_21"
																				id="LJ1check_21"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_22" value="L"
																				data-row="7" data-col="0" /><span
																				class="button-group-item check_" for="J1check_22"
																				id="LJ1check_22"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_23" value="E"
																				data-row="7" data-col="1" /><span
																				class="button-group-item check_" for="J1check_23"
																				id="LJ1check_23"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_24" value="V"
																				data-row="7" data-col="2" /><span
																				class="button-group-item check_" for="J1check_24"
																				id="LJ1check_24"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_25" value="L"
																				data-row="8" data-col="0" /><span
																				class="button-group-item check_" for="J1check_25"
																				id="LJ1check_25"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_26" value="E"
																				data-row="8" data-col="1" /><span
																				class="button-group-item check_" for="J1check_26"
																				id="LJ1check_26"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_27" value="V"
																				data-row="8" data-col="2" /><span
																				class="button-group-item check_" for="J1check_27"
																				id="LJ1check_27"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_28" value="L"
																				data-row="9" data-col="0" /><span
																				class="button-group-item check_" for="J1check_28"
																				id="LJ1check_28"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_29" value="E"
																				data-row="9" data-col="1" /><span
																				class="button-group-item check_" for="J1check_29"
																				id="LJ1check_29"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_30" value="V"
																				data-row="9" data-col="2" /><span
																				class="button-group-item check_" for="J1check_30"
																				id="LJ1check_30"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_31" value="L"
																				data-row="10" data-col="0" /><span
																				class="button-group-item check_" for="J1check_31"
																				id="LJ1check_31"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_32" value="E"
																				data-row="10" data-col="1" /><span
																				class="button-group-item check_" for="J1check_32"
																				id="LJ1check_32"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_33" value="V"
																				data-row="10" data-col="2" /><span
																				class="button-group-item check_" for="J1check_33"
																				id="LJ1check_33"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_34" value="L"
																				data-row="11" data-col="0" /><span
																				class="button-group-item check_" for="J1check_34"
																				id="LJ1check_34"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_35" value="E"
																				data-row="11" data-col="1" /><span
																				class="button-group-item check_" for="J1check_35"
																				id="LJ1check_35"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_36" value="V"
																				data-row="11" data-col="2" /><span
																				class="button-group-item check_" for="J1check_36"
																				id="LJ1check_36"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_37" value="L"
																				data-row="12" data-col="0" /><span
																				class="button-group-item check_" for="J1check_37"
																				id="LJ1check_37"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_38" value="E"
																				data-row="12" data-col="1" /><span
																				class="button-group-item check_" for="J1check_38"
																				id="LJ1check_38"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_39" value="V"
																				data-row="12" data-col="2" /><span
																				class="button-group-item check_" for="J1check_39"
																				id="LJ1check_39"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_40" value="L"
																				data-row="13" data-col="0" /><span
																				class="button-group-item check_" for="J1check_40"
																				id="LJ1check_40"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_41" value="E"
																				data-row="13" data-col="1" /><span
																				class="button-group-item check_" for="J1check_41"
																				id="LJ1check_41"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J1check" id="J1check_42" value="V"
																				data-row="13" data-col="2" /><span
																				class="button-group-item check_" for="J1check_42"
																				id="LJ1check_42"><span class="label-item">V</span></span>
																			</label>
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-6">
																			<div class="footer-single-left">
																				<button type="button" id="J1random"
																					class="random button button-block button-gray button-sm button-no-shadow">Azar</button>
																			</div>
																		</div>
																		<div class="col-6">
																			<div class="footer-single-right">
																				<button type="button" id="J1clear"
																					class="clear button button-block button-gray button-sm button-no-shadow">Limpiar</button>
																			</div>
																		</div>
																	</div>
																</div>
															</div>

														</div>
														<div class="box-play-main box-play-b"
															style="display: none;">
															<div class="content-single-game">
																<div class="content-help">
																	<a
																		href="<%=Constants.URL_QW%>/tutorial/como-jugar-ganagol/"
																		target="_blank" class="play-text"><span>?</span>
																		Ayuda</a>
																</div>
																<div class="body-content-grid">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">

																			<label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_1" value="L" data-row="0"
																				data-col="0" /><span
																				class="button-group-item check_" for="J2check_1"
																				id="LJ2check_1"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_2" value="E" data-row="0"
																				data-col="1" /><span
																				class="button-group-item check_" for="J2check_2"
																				id="LJ2check_2"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_3" value="V" data-row="0"
																				data-col="2" /><span
																				class="button-group-item check_" for="J2check_3"
																				id="LJ2check_3"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_4" value="L" data-row="1"
																				data-col="0" /><span
																				class="button-group-item check_" for="J2check_4"
																				id="LJ2check_4"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_5" value="E" data-row="1"
																				data-col="1" /><span
																				class="button-group-item check_" for="J2check_5"
																				id="LJ2check_5"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_6" value="V" data-row="1"
																				data-col="2" /><span
																				class="button-group-item check_" for="J2check_6"
																				id="LJ2check_6"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_7" value="L" data-row="2"
																				data-col="0" /><span
																				class="button-group-item check_" for="J2check_7"
																				id="LJ2check_7"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_8" value="E" data-row="2"
																				data-col="1" /><span
																				class="button-group-item check_" for="J2check_8"
																				id="LJ2check_8"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_9" value="V" data-row="2"
																				data-col="2" /><span
																				class="button-group-item check_" for="J2check_9"
																				id="LJ2check_9"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_10" value="L"
																				data-row="3" data-col="0" /><span
																				class="button-group-item check_" for="J2check_10"
																				id="LJ2check_10"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_11" value="E"
																				data-row="3" data-col="1" /><span
																				class="button-group-item check_" for="J2check_11"
																				id="LJ2check_11"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_12" value="V"
																				data-row="3" data-col="2" /><span
																				class="button-group-item check_" for="J2check_12"
																				id="LJ2check_12"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_13" value="L"
																				data-row="4" data-col="0" /><span
																				class="button-group-item check_" for="J2check_13"
																				id="LJ2check_13"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_14" value="E"
																				data-row="4" data-col="1" /><span
																				class="button-group-item check_" for="J2check_14"
																				id="LJ2check_14"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_15" value="V"
																				data-row="4" data-col="2" /><span
																				class="button-group-item check_" for="J2check_15"
																				id="LJ2check_15"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_16" value="L"
																				data-row="5" data-col="0" /><span
																				class="button-group-item check_" for="J2check_16"
																				id="LJ2check_16"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_17" value="E"
																				data-row="5" data-col="1" /><span
																				class="button-group-item check_" for="J2check_17"
																				id="LJ2check_17"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_18" value="V"
																				data-row="5" data-col="2" /><span
																				class="button-group-item check_" for="J2check_18"
																				id="LJ2check_18"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_19" value="L"
																				data-row="6" data-col="0" /><span
																				class="button-group-item check_" for="J2check_19"
																				id="LJ2check_19"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_20" value="E"
																				data-row="6" data-col="1" /><span
																				class="button-group-item check_" for="J2check_20"
																				id="LJ2check_20"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_21" value="V"
																				data-row="6" data-col="2" /><span
																				class="button-group-item check_" for="J2check_21"
																				id="LJ2check_21"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_22" value="L"
																				data-row="7" data-col="0" /><span
																				class="button-group-item check_" for="J2check_22"
																				id="LJ2check_22"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_23" value="E"
																				data-row="7" data-col="1" /><span
																				class="button-group-item check_" for="J2check_23"
																				id="LJ2check_23"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_24" value="V"
																				data-row="7" data-col="2" /><span
																				class="button-group-item check_" for="J2check_24"
																				id="LJ2check_24"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_25" value="L"
																				data-row="8" data-col="0" /><span
																				class="button-group-item check_" for="J2check_25"
																				id="LJ2check_25"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_26" value="E"
																				data-row="8" data-col="1" /><span
																				class="button-group-item check_" for="J2check_26"
																				id="LJ2check_26"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_27" value="V"
																				data-row="8" data-col="2" /><span
																				class="button-group-item check_" for="J2check_27"
																				id="LJ2check_27"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_28" value="L"
																				data-row="9" data-col="0" /><span
																				class="button-group-item check_" for="J2check_28"
																				id="LJ2check_28"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_29" value="E"
																				data-row="9" data-col="1" /><span
																				class="button-group-item check_" for="J2check_29"
																				id="LJ2check_29"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_30" value="V"
																				data-row="9" data-col="2" /><span
																				class="button-group-item check_" for="J2check_30"
																				id="LJ2check_30"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_31" value="L"
																				data-row="10" data-col="0" /><span
																				class="button-group-item check_" for="J2check_31"
																				id="LJ2check_31"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_32" value="E"
																				data-row="10" data-col="1" /><span
																				class="button-group-item check_" for="J2check_32"
																				id="LJ2check_32"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_33" value="V"
																				data-row="10" data-col="2" /><span
																				class="button-group-item check_" for="J2check_33"
																				id="LJ2check_33"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_34" value="L"
																				data-row="11" data-col="0" /><span
																				class="button-group-item check_" for="J2check_34"
																				id="LJ2check_34"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_35" value="E"
																				data-row="11" data-col="1" /><span
																				class="button-group-item check_" for="J2check_35"
																				id="LJ2check_35"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_36" value="V"
																				data-row="11" data-col="2" /><span
																				class="button-group-item check_" for="J2check_36"
																				id="LJ2check_36"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_37" value="L"
																				data-row="12" data-col="0" /><span
																				class="button-group-item check_" for="J2check_37"
																				id="LJ2check_37"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_38" value="E"
																				data-row="12" data-col="1" /><span
																				class="button-group-item check_" for="J2check_38"
																				id="LJ2check_38"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_39" value="V"
																				data-row="12" data-col="2" /><span
																				class="button-group-item check_" for="J2check_39"
																				id="LJ2check_39"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_40" value="L"
																				data-row="13" data-col="0" /><span
																				class="button-group-item check_" for="J2check_40"
																				id="LJ2check_40"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_41" value="E"
																				data-row="13" data-col="1" /><span
																				class="button-group-item check_" for="J2check_41"
																				id="LJ2check_41"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J2check" id="J2check_42" value="V"
																				data-row="13" data-col="2" /><span
																				class="button-group-item check_" for="J2check_42"
																				id="LJ2check_42"><span class="label-item">V</span></span>
																			</label>
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-6">
																			<div class="footer-single-left">
																				<button type="button" id="J2random"
																					class="random button button-block button-gray button-sm button-no-shadow">Azar</button>
																			</div>
																		</div>
																		<div class="col-6">
																			<div class="footer-single-right">
																				<button type="button" id="J2clear"
																					class="clear button button-block button-gray button-sm button-no-shadow">Limpiar</button>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="box-play-main box-play-c"
															style="display: none;">
															<div class="content-single-game">
																<div class="content-help">
																	<a
																		href="<%=Constants.URL_QW%>/tutorial/como-jugar-ganagol/"
																		target="_blank" class="play-text"><span>?</span>
																		Ayuda</a>
																</div>
																<div class="body-content-grid">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">

																			<label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_1" value="L" data-row="0"
																				data-col="0" /><span
																				class="button-group-item check_" for="J3check_1"
																				id="LJ3check_1"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_2" value="E" data-row="0"
																				data-col="1" /><span
																				class="button-group-item check_" for="J3check_2"
																				id="LJ3check_2"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_3" value="V" data-row="0"
																				data-col="2" /><span
																				class="button-group-item check_" for="J3check_3"
																				id="LJ3check_3"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_4" value="L" data-row="1"
																				data-col="0" /><span
																				class="button-group-item check_" for="J3check_4"
																				id="LJ3check_4"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_5" value="E" data-row="1"
																				data-col="1" /><span
																				class="button-group-item check_" for="J3check_5"
																				id="LJ3check_5"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_6" value="V" data-row="1"
																				data-col="2" /><span
																				class="button-group-item check_" for="J3check_6"
																				id="LJ3check_6"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_7" value="L" data-row="2"
																				data-col="0" /><span
																				class="button-group-item check_" for="J3check_7"
																				id="LJ3check_7"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_8" value="E" data-row="2"
																				data-col="1" /><span
																				class="button-group-item check_" for="J3check_8"
																				id="LJ3check_8"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_9" value="V" data-row="2"
																				data-col="2" /><span
																				class="button-group-item check_" for="J3check_9"
																				id="LJ3check_9"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_10" value="L"
																				data-row="3" data-col="0" /><span
																				class="button-group-item check_" for="J3check_10"
																				id="LJ3check_10"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_11" value="E"
																				data-row="3" data-col="1" /><span
																				class="button-group-item check_" for="J3check_11"
																				id="LJ3check_11"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_12" value="V"
																				data-row="3" data-col="2" /><span
																				class="button-group-item check_" for="J3check_12"
																				id="LJ3check_12"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_13" value="L"
																				data-row="4" data-col="0" /><span
																				class="button-group-item check_" for="J3check_13"
																				id="LJ3check_13"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_14" value="E"
																				data-row="4" data-col="1" /><span
																				class="button-group-item check_" for="J3check_14"
																				id="LJ3check_14"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_15" value="V"
																				data-row="4" data-col="2" /><span
																				class="button-group-item check_" for="J3check_15"
																				id="LJ3check_15"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_16" value="L"
																				data-row="5" data-col="0" /><span
																				class="button-group-item check_" for="J3check_16"
																				id="LJ3check_16"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_17" value="E"
																				data-row="5" data-col="1" /><span
																				class="button-group-item check_" for="J3check_17"
																				id="LJ3check_17"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_18" value="V"
																				data-row="5" data-col="2" /><span
																				class="button-group-item check_" for="J3check_18"
																				id="LJ3check_18"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_19" value="L"
																				data-row="6" data-col="0" /><span
																				class="button-group-item check_" for="J3check_19"
																				id="LJ3check_19"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_20" value="E"
																				data-row="6" data-col="1" /><span
																				class="button-group-item check_" for="J3check_20"
																				id="LJ3check_20"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_21" value="V"
																				data-row="6" data-col="2" /><span
																				class="button-group-item check_" for="J3check_21"
																				id="LJ3check_21"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_22" value="L"
																				data-row="7" data-col="0" /><span
																				class="button-group-item check_" for="J3check_22"
																				id="LJ3check_22"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_23" value="E"
																				data-row="7" data-col="1" /><span
																				class="button-group-item check_" for="J3check_23"
																				id="LJ3check_23"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_24" value="V"
																				data-row="7" data-col="2" /><span
																				class="button-group-item check_" for="J3check_24"
																				id="LJ3check_24"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_25" value="L"
																				data-row="8" data-col="0" /><span
																				class="button-group-item check_" for="J3check_25"
																				id="LJ3check_25"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_26" value="E"
																				data-row="8" data-col="1" /><span
																				class="button-group-item check_" for="J3check_26"
																				id="LJ3check_26"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_27" value="V"
																				data-row="8" data-col="2" /><span
																				class="button-group-item check_" for="J3check_27"
																				id="LJ3check_27"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_28" value="L"
																				data-row="9" data-col="0" /><span
																				class="button-group-item check_" for="J3check_28"
																				id="LJ3check_28"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_29" value="E"
																				data-row="9" data-col="1" /><span
																				class="button-group-item check_" for="J3check_29"
																				id="LJ3check_29"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_30" value="V"
																				data-row="9" data-col="2" /><span
																				class="button-group-item check_" for="J3check_30"
																				id="LJ3check_30"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_31" value="L"
																				data-row="10" data-col="0" /><span
																				class="button-group-item check_" for="J3check_31"
																				id="LJ3check_31"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_32" value="E"
																				data-row="10" data-col="1" /><span
																				class="button-group-item check_" for="J3check_32"
																				id="LJ3check_32"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_33" value="V"
																				data-row="10" data-col="2" /><span
																				class="button-group-item check_" for="J3check_33"
																				id="LJ3check_33"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_34" value="L"
																				data-row="11" data-col="0" /><span
																				class="button-group-item check_" for="J3check_34"
																				id="LJ3check_34"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_35" value="E"
																				data-row="11" data-col="1" /><span
																				class="button-group-item check_" for="J3check_35"
																				id="LJ3check_35"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_36" value="V"
																				data-row="11" data-col="2" /><span
																				class="button-group-item check_" for="J3check_36"
																				id="LJ3check_36"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_37" value="L"
																				data-row="12" data-col="0" /><span
																				class="button-group-item check_" for="J3check_37"
																				id="LJ3check_37"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_38" value="E"
																				data-row="12" data-col="1" /><span
																				class="button-group-item check_" for="J3check_38"
																				id="LJ3check_38"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_39" value="V"
																				data-row="12" data-col="2" /><span
																				class="button-group-item check_" for="J3check_39"
																				id="LJ3check_39"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_40" value="L"
																				data-row="13" data-col="0" /><span
																				class="button-group-item check_" for="J3check_40"
																				id="LJ3check_40"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_41" value="E"
																				data-row="13" data-col="1" /><span
																				class="button-group-item check_" for="J3check_41"
																				id="LJ3check_41"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J3check" id="J3check_42" value="V"
																				data-row="13" data-col="2" /><span
																				class="button-group-item check_" for="J3check_42"
																				id="LJ3check_42"><span class="label-item">V</span></span>
																			</label>
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-6">
																			<div class="footer-single-left">
																				<button type="button" id="J3random"
																					class="random button button-block button-gray button-sm button-no-shadow">Azar</button>
																			</div>
																		</div>
																		<div class="col-6">
																			<div class="footer-single-right">
																				<button type="button" id="J3clear"
																					class="clear button button-block button-gray button-sm button-no-shadow">Limpiar</button>
																			</div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="box-play-main box-play-d"
															style="display: none;">
															<div class="content-single-game">
																<div class="content-help">
																	<a
																		href="<%=Constants.URL_QW%>/tutorial/como-jugar-ganagol/"
																		target="_blank" class="play-text"><span>?</span>
																		Ayuda</a>
																</div>
																<div class="body-content-grid">
																	<div class="body-game">
																		<div class="button-group checkboxes-ball clearfix">

																			<label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_1" value="L" data-row="0"
																				data-col="0" /><span
																				class="button-group-item check_" for="J4check_1"
																				id="LJ4check_1"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_2" value="E" data-row="0"
																				data-col="1" /><span
																				class="button-group-item check_" for="J4check_2"
																				id="LJ4check_2"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_3" value="V" data-row="0"
																				data-col="2" /><span
																				class="button-group-item check_" for="J4check_3"
																				id="LJ4check_3"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_4" value="L" data-row="1"
																				data-col="0" /><span
																				class="button-group-item check_" for="J4check_4"
																				id="LJ4check_4"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_5" value="E" data-row="1"
																				data-col="1" /><span
																				class="button-group-item check_" for="J4check_5"
																				id="LJ4check_5"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_6" value="V" data-row="1"
																				data-col="2" /><span
																				class="button-group-item check_" for="J4check_6"
																				id="LJ4check_6"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_7" value="L" data-row="2"
																				data-col="0" /><span
																				class="button-group-item check_" for="J4check_7"
																				id="LJ4check_7"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_8" value="E" data-row="2"
																				data-col="1" /><span
																				class="button-group-item check_" for="J4check_8"
																				id="LJ4check_8"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_9" value="V" data-row="2"
																				data-col="2" /><span
																				class="button-group-item check_" for="J4check_9"
																				id="LJ4check_9"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_10" value="L"
																				data-row="3" data-col="0" /><span
																				class="button-group-item check_" for="J4check_10"
																				id="LJ4check_10"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_11" value="E"
																				data-row="3" data-col="1" /><span
																				class="button-group-item check_" for="J4check_11"
																				id="LJ4check_11"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_12" value="V"
																				data-row="3" data-col="2" /><span
																				class="button-group-item check_" for="J4check_12"
																				id="LJ4check_12"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_13" value="L"
																				data-row="4" data-col="0" /><span
																				class="button-group-item check_" for="J4check_13"
																				id="LJ4check_13"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_14" value="E"
																				data-row="4" data-col="1" /><span
																				class="button-group-item check_" for="J4check_14"
																				id="LJ4check_14"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_15" value="V"
																				data-row="4" data-col="2" /><span
																				class="button-group-item check_" for="J4check_15"
																				id="LJ4check_15"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_16" value="L"
																				data-row="5" data-col="0" /><span
																				class="button-group-item check_" for="J4check_16"
																				id="LJ4check_16"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_17" value="E"
																				data-row="5" data-col="1" /><span
																				class="button-group-item check_" for="J4check_17"
																				id="LJ4check_17"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_18" value="V"
																				data-row="5" data-col="2" /><span
																				class="button-group-item check_" for="J4check_18"
																				id="LJ4check_18"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_19" value="L"
																				data-row="6" data-col="0" /><span
																				class="button-group-item check_" for="J4check_19"
																				id="LJ4check_19"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_20" value="E"
																				data-row="6" data-col="1" /><span
																				class="button-group-item check_" for="J4check_20"
																				id="LJ4check_20"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_21" value="V"
																				data-row="6" data-col="2" /><span
																				class="button-group-item check_" for="J4check_21"
																				id="LJ4check_21"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_22" value="L"
																				data-row="7" data-col="0" /><span
																				class="button-group-item check_" for="J4check_22"
																				id="LJ4check_22"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_23" value="E"
																				data-row="7" data-col="1" /><span
																				class="button-group-item check_" for="J4check_23"
																				id="LJ4check_23"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_24" value="V"
																				data-row="7" data-col="2" /><span
																				class="button-group-item check_" for="J4check_24"
																				id="LJ4check_24"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_25" value="L"
																				data-row="8" data-col="0" /><span
																				class="button-group-item check_" for="J4check_25"
																				id="LJ4check_25"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_26" value="E"
																				data-row="8" data-col="1" /><span
																				class="button-group-item check_" for="J4check_26"
																				id="LJ4check_26"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_27" value="V"
																				data-row="8" data-col="2" /><span
																				class="button-group-item check_" for="J4check_27"
																				id="LJ4check_27"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_28" value="L"
																				data-row="9" data-col="0" /><span
																				class="button-group-item check_" for="J4check_28"
																				id="LJ4check_28"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_29" value="E"
																				data-row="9" data-col="1" /><span
																				class="button-group-item check_" for="J4check_29"
																				id="LJ4check_29"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_30" value="V"
																				data-row="9" data-col="2" /><span
																				class="button-group-item check_" for="J4check_30"
																				id="LJ4check_30"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_31" value="L"
																				data-row="10" data-col="0" /><span
																				class="button-group-item check_" for="J4check_31"
																				id="LJ4check_31"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_32" value="E"
																				data-row="10" data-col="1" /><span
																				class="button-group-item check_" for="J4check_32"
																				id="LJ4check_32"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_33" value="V"
																				data-row="10" data-col="2" /><span
																				class="button-group-item check_" for="J4check_33"
																				id="LJ4check_33"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_34" value="L"
																				data-row="11" data-col="0" /><span
																				class="button-group-item check_" for="J4check_34"
																				id="LJ4check_34"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_35" value="E"
																				data-row="11" data-col="1" /><span
																				class="button-group-item check_" for="J4check_35"
																				id="LJ4check_35"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_36" value="V"
																				data-row="11" data-col="2" /><span
																				class="button-group-item check_" for="J4check_36"
																				id="LJ4check_36"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_37" value="L"
																				data-row="12" data-col="0" /><span
																				class="button-group-item check_" for="J4check_37"
																				id="LJ4check_37"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_38" value="E"
																				data-row="12" data-col="1" /><span
																				class="button-group-item check_" for="J4check_38"
																				id="LJ4check_38"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_39" value="V"
																				data-row="12" data-col="2" /><span
																				class="button-group-item check_" for="J4check_39"
																				id="LJ4check_39"><span class="label-item">V</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_40" value="L"
																				data-row="13" data-col="0" /><span
																				class="button-group-item check_" for="J4check_40"
																				id="LJ4check_40"><span class="label-item">L</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_41" value="E"
																				data-row="13" data-col="1" /><span
																				class="button-group-item check_" for="J4check_41"
																				id="LJ4check_41"><span class="label-item">E</span></span>
																			</label> <label> <input class="check" type="checkbox"
																				name="J4check" id="J4check_42" value="V"
																				data-row="13" data-col="2" /><span
																				class="button-group-item check_" for="J4check_42"
																				id="LJ4check_42"><span class="label-item">V</span></span>
																			</label>
																		</div>
																	</div>
																</div>
																<div class="footer-single-game">
																	<div class="row no-gutters">
																		<div class="col-6">
																			<div class="footer-single-left">
																				<button type="button" id="J4random"
																					class="random button button-block button-gray button-sm button-no-shadow">Azar</button>
																			</div>
																		</div>
																		<div class="col-6">
																			<div class="footer-single-right">
																				<button type="button" id="J4clear"
																					class="clear button button-block button-gray button-sm button-no-shadow">Limpiar</button>
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

										<div class="wrapper-footer-playing">
											<div class="box-wrapper-game">
												<div class="box-content-game box-content-game-g200">
													<div class="box-play-main box-play-a">
														<div class="row no-gutters">

															<div class="col-sm-3 ">
																<div class="extra-game left-extra-game-g200">
																	<div class="right-extra-game ">
																		<span class="value-extra-game"><b>¡Acierta el rango de goles</b></span><br /> 
																		<span class="value-extra-game"><b>y s&uacute;male S/200,000 a tu pozo!</b></span><br />
																	</div>
																	<div class="left-extra-game logo-g200">
																		<div class="content-left-extra">
																			<label for="J1-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">S/1.00 adicional</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix right-extra-game-g200">
																	<label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J1check_43"
																		id="LJ1check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J1check_44"
																		id="LJ1check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J1check_45"
																		id="LJ1check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J1check_46"
																		id="LJ1check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J1check_47"
																		id="LJ1check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J1check_48"
																		id="LJ1check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J1check_49"
																		id="LJ1check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J1check_50"
																		id="LJ1check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J1check_51"
																		id="LJ1check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J1checkG200" id="J1check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J1check_52"
																		id="LJ1check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
													<div class="box-play-main box-play-b" style="display: none;">
														<div class="row no-gutters">

															<div class="col-sm-3">
																<div class="extra-game left-extra-game-g200">
																	<div class="right-extra-game">
																		<span class="value-extra-game"><b>¡Acierta el rango de goles</b></span><br /> 
																		<span class="value-extra-game"><b>y s&uacute;male S/200,000 a tu pozo!</b></span><br />
																	</div>
																	<div class="left-extra-game logo-g200">
																		<div class="content-left-extra">
																			<label for="J2-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">S/1.00 adicional</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix right-extra-game-g200">
																	<label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J2check_43"
																		id="LJ2check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J2check_44"
																		id="LJ2check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J2check_45"
																		id="LJ2check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J2check_46"
																		id="LJ2check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J2check_47"
																		id="LJ2check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J2check_48"
																		id="LJ2check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J2check_49"
																		id="LJ2check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J2check_50"
																		id="LJ2check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J2check_51"
																		id="LJ2check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J2checkG200" id="J2check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J2check_52"
																		id="LJ2check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
													<div class="box-play-main box-play-c" style="display: none;">
														<div class="row no-gutters">

															<div class="col-sm-3">
																<div class="extra-game left-extra-game-g200">
																	<div class="right-extra-game">
																		<span class="value-extra-game"><b>¡Acierta el rango de goles</b></span><br /> 
																		<span class="value-extra-game"><b>y s&uacute;male S/200,000 a tu pozo!</b></span><br />
																	</div>
																	<div class="left-extra-game logo-g200">
																		<div class="content-left-extra">
																			<label for="J3-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">S/1.00 adicional</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix right-extra-game-g200">
																	<label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J3check_43"
																		id="LJ3check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J3check_44"
																		id="LJ3check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J3check_45"
																		id="LJ3check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J3check_46"
																		id="LJ3check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J3check_47"
																		id="LJ3check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J3check_48"
																		id="LJ3check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J3check_49"
																		id="LJ3check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J3check_50"
																		id="LJ3check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J3check_51"
																		id="LJ3check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J3checkG200" id="J3check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J3check_52"
																		id="LJ3check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
													<div class="box-play-main box-play-d" style="display: none;">
														<div class="row no-gutters">

															<div class="col-sm-3">
																<div class="extra-game left-extra-game-g200">
																	<div class="right-extra-game">
																		<span class="value-extra-game"><b>¡Acierta el rango de goles</b></span><br /> 
																		<span class="value-extra-game"><b>y s&uacute;male S/200,000 a tu pozo!</b></span><br />
																	</div>
																	<div class="left-extra-game logo-g200">
																		<div class="content-left-extra">
																			<label for="J4-check-golazo200"> <img
																				src="layer-view-image/v2/logo-golazo200.png" style="width: 70px;height: 49px;" alt="Jugar La Tinka" />
																			</label>
																		</div>
																	</div>
																	<div class="right-extra-game">
																		<span class="value-extra-game">S/1.00 adicional</span><br />

																	</div>
																</div>
															</div>
															<div class="col-sm-9">
																<div class="button-group checkboxes-ball clearfix right-extra-game-g200">
																	<label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_43" value="0-8"
																		data-row="14" data-col="0" /><span
																		class="button-group-item" for="J4check_43"
																		id="LJ4check_43"><span class="label-item">0-8</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_44" value="9-15"
																		data-row="14" data-col="1" /><span
																		class="button-group-item" for="J4check_44"
																		id="LJ4check_44"><span class="label-item">9-15</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_45" value="16-20"
																		data-row="14" data-col="2" /><span
																		class="button-group-item" for="J4check_45"
																		id="LJ4check_45"><span class="label-item">16-20</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_46" value="21-25"
																		data-row="14" data-col="3" /><span
																		class="button-group-item" for="J4check_46"
																		id="LJ4check_46"><span class="label-item">21-25</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_47" value="26-30"
																		data-row="14" data-col="4" /><span
																		class="button-group-item" for="J4check_47"
																		id="LJ4check_47"><span class="label-item">26-30</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_48" value="31-35"
																		data-row="15" data-col="0" /><span
																		class="button-group-item" for="J4check_48"
																		id="LJ4check_48"><span class="label-item">31-35</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_49" value="36-40"
																		data-row="15" data-col="1" /><span
																		class="button-group-item" for="J4check_49"
																		id="LJ4check_49"><span class="label-item">36-40</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_50" value="41-43"
																		data-row="15" data-col="2" /><span
																		class="button-group-item" for="J4check_50"
																		id="LJ4check_50"><span class="label-item">41-43</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_51" value="44-46"
																		data-row="15" data-col="3" /><span
																		class="button-group-item" for="J4check_51"
																		id="LJ4check_51"><span class="label-item">44-46</span></span>
																	</label> <label> <input class="check" type="checkbox"
																		name="J4checkG200" id="J4check_52" value="47-a mas"
																		data-row="15" data-col="4" /><span
																		class="button-group-item" for="J4check_52"
																		id="LJ4check_52"><span class="label-item">47
																				a más</span></span>
																	</label>
																</div>
															</div>

														</div>
													</div>
												</div>
											</div>
										</div>


										<div class="wrapper-footer-playing">
											<div class="box-wrapper-game">
												<div class="box-content-game">
													<div class="row no-gutters">

														<div class="col-sm-6">
															<div class="box-detail-ganagol">
																<span class="main-single-detail"> <span
																	class="detail-text">
																		${ganagolSale.promotionMessage} <span
																		class="detail-value" id="price-message">${ganagolSale.priceMessage}</span>
																</span>
																</span>
																<div class="main-single-detail">
																	<span class="detail-text"> 
																	Jugadas <span class="detail-value">
																		<span id="total_bet">0</span>
																		<span id="ganagol200-text"></span>
																	</span>
																	</span>
																</div>
																<div class="main-single-detail">
																	<span class="detail-text"> Costo total <span
																		class="detail-value">S/ <b id="total_apagar">0</b></span>
																	</span>
																</div>
															</div>
														</div>
														<div class="col-sm-6">
															<div class="action-buy-ganagol">
																<!--                                                             	<button type="button" id="buy" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange"><b>COMPRAR</b></button> -->
																<button type="button"
																	id="btn_desktop_comprar_boleto_ganagol"
																	onclick="return false;"
																	class="button button-lg button-no-shadow button-block button-orange">
																	<b>COMPRAR</b>
																</button>
															</div>
														</div>
													</div>

												</div>
											</div>
										</div>

									</div>

									<div class="wrapper-buying">

										<div id="content-purchase">

											<div class="box-wrapper-game">
												<div class="box-content-game">
													<div class="top-single-game">
														<!-- <h3>GANAGOL</h3> -->
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
																	<h5>
																		TOTAL <span class="label_2 detail-pay-date"></span>
																	</h5>
																</div>
																<div class="box-detail-pay">
																	<h4>
																		<span class="label_resu5"></span>
																		<div class="text-detail-pay detail-pay-monto result5"></div>
																	</h4>
																	<h4>${ganagolSale.promotionMessage}<div
																			class="text-detail-pay detail-pay-monto label_resu2">${ganagolSale.priceMessage}</div>
																	</h4>
																	<h4>
																		<div class="text-detail-pay label_resu3"></div>
																	</h4>
																	<h4>
																		<div class="text-detail-pay label_resu4"></div>
																	</h4>
																	<h4>
																		<b><span class="label_resu1">Total a pagar</span></b>
																		<div class="text-detail-pay detail-pay-monto result1"></div>
																	</h4>
																</div>

																<div class="box-action-pay">
																	<div id="panel_more_plays">
																		<span class="labelMsgJugadaGratis"></span>
																		<button type="button" id="more_plays"
																			class="button button-lg button-no-shadow button-block button-green-new">
																			<b>AGREGAR JUGADAS</b>
																		</button>
																	</div>
																	<div id="panel_keep-playing">
																		<a href="juega-ganagol.html" id="keep-playing" onclick="datalayerGraciasCompra('SEGUIR JUGANDO','Seguir Jugando');"
																			class="button button-lg button-no-shadow button-block button-orange">
																			<b>SEGUIR JUGANDO</b>
																		</a>
																	</div>
																	<div id="panel_game-history">
																		<a href="mi-cuenta.html#jugadas" id="game-history" onclick="datalayerGraciasCompra('IR A MIS JUGADAS','ir a mis jugadas');"
																			class="button button-lg button-no-shadow button-block button-dark-green">
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
																	<div class="tab-item accordion-off" id="tab-item_4"
																		data-hash="saldo" style="display: block;">
																		<div class="accordion-ico">
																			<svg xmlns="http://www.w3.org/2000/svg"
																				viewBox="0 0 24.24 24.24">
																				<g id="Capa_2" data-name="Capa 2">
																				<g id="Capa_2-2" data-name="Capa 2">
																				<rect class="ico-body" width="24.24" height="24.24"
																					rx="12.12" ry="12.12" />
																				<path class="ico-line"
																					d="M9.5,16.72c-1.79,0-3.18-.55-3.83-2.16l1.38-.72a2.5,2.5,0,0,0,2.47,1.39c1,0,2-.36,2-1.32s-.87-1.17-2-1.29c-1.79-.21-3.45-.69-3.45-2.66,0-1.81,1.78-2.55,3.4-2.56a3.55,3.55,0,0,1,3.45,1.74l-1.32.68a2.52,2.52,0,0,0-2.08-1c-1.23,0-1.82.51-1.82,1.17s.9,1,2,1.1c1.83.23,3.54.7,3.54,2.8S11.46,16.72,9.5,16.72Zm5.38.65H13.6L17,8.81h1.29Z" /></g></g></svg>
																		</div>
																		<div class="title-accordion">CARGAR SALDO</div>
																		<i></i> <input type="hidden" id="marca_logo"
																			value="logo-ganagol.png">
																	</div>
																	<div id="content-tab-item_4"
																		class="tab-content accordion-on"
																		style="display: none;">
																		<div class="head-tab-content group"
																			data-tab="tab-item_4">
																			<div class="accordion-ico">
																				<svg xmlns="http://www.w3.org/2000/svg"
																					viewBox="0 0 24.24 24.24">
																					<g id="Capa_2" data-name="Capa 2">
																					<g id="Capa_2-2" data-name="Capa 2">
																					<rect class="ico-body" width="24.24" height="24.24"
																						rx="12.12" ry="12.12" />
																					<path class="ico-line"
																						d="M9.5,16.72c-1.79,0-3.18-.55-3.83-2.16l1.38-.72a2.5,2.5,0,0,0,2.47,1.39c1,0,2-.36,2-1.32s-.87-1.17-2-1.29c-1.79-.21-3.45-.69-3.45-2.66,0-1.81,1.78-2.55,3.4-2.56a3.55,3.55,0,0,1,3.45,1.74l-1.32.68a2.52,2.52,0,0,0-2.08-1c-1.23,0-1.82.51-1.82,1.17s.9,1,2,1.1c1.83.23,3.54.7,3.54,2.8S11.46,16.72,9.5,16.72Zm5.38.65H13.6L17,8.81h1.29Z" /></g></g></svg>
																			</div>
																			<div class="title-accordion">CARGAR SALDO</div>
																			<i></i>
																		</div>
																		<div id="pan_0">
																			<div class="label1">PAGAR</div>
																			<table>
																				<tr>
																					<td><input type="radio" name="option-card"
																						checked="checked" value="0" id="option-card-0" /></td>
																					<td><label for="option-card-0"> <span>Quiero
																								descontar de mi saldo disponible S/.</span> <span
																							id="field-balance-amount">${ganagolSale.balanceBill01}</span>
																					</label></td>
																				</tr>
																			</table>
																		</div>
																		<!-- 	                                                                    <div id="separator_hr"></div> -->
																		<!-- 	                                                                    <div class="top-saldo wb-saldo"></div> -->
																		<!-- 	                                                                    <div id="pan_1"> -->
																		<!-- 	                                                                        <div class="label2">RECARGAS POR INTERNET</div> -->
																		<!-- 	                                                                        <table> -->
																		<%-- 	                                                                            <c:forTokens var="channel1Order" items="${ganagolSale.channel1Order}" delims=","> --%>
																		<%-- 	                                                                                <%@ include file="../../include/balance1.jspf"%> --%>
																		<%-- 	                                                                            </c:forTokens> --%>
																		<!-- 	                                                                        </table> -->
																		<!-- 	                                                                        <div class="label2">RECARGAS F&Iacute;SICAS</div> -->
																		<!-- 	                                                                        <table> -->
																		<%-- 	                                                                            <c:forTokens var="channel2Order" items="${ganagolSale.channel2Order}" delims=","> --%>
																		<%-- 	                                                                                <%@ include file="../../include/balance2.jspf"%> --%>
																		<%-- 	                                                                            </c:forTokens> --%>
																		<!-- 	                                                                        </table> -->
																		<!-- 	                                                                    </div> -->
																		<!-- 	                                                                    <div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div> -->
																	</div>
																</div>
															</form>
														</div>
														<div id="panel_finaliza_compra">
															<a href="#" class="button button-dark-green button-red-new"
																id='btn_desktop_finalizar_compra_ganagol'
																onclick="return false;">FINALIZAR TU COMPRA</a>
															<!--                                                             <a href="#" class="button button-dark-green" id='btn_finaliza_compra' onclick="return false;">FINALIZAR TU COMPRA</a> -->
														</div>

														<div class="clearfix"></div>

														<div id="ico-block">
															<div id="ico-title">¡SIGUE JUGANDO Y PROBANDO TU
																SUERTE!</div>
															<div id="ico-panel" class="clearfix">
																 
																<a href="juega-tinka.html" class="button-ico ico-tinka"
																	id='btn_desktop_home_tinka'> <img
																	src="./layer-view-image/v2/logo-tinka.svg?v=3"
																	alt="Jugar La Tinka Lotería" />
																</a> <a href="juega-kabala.html"
																	class="button-ico ico-kabala"
																	id='btn_desktop_home_kabala'> <img
																	src="./layer-view-image/v2/logo-kabala.svg"
																	alt="Jugar Kabala" />
																</a> <a href="juega-ganadiario.html"
																	class="button-ico ico-ganadiario"
																	id='btn_desktop_home_ganadiario'> <img
																	src="./layer-view-image/v2/logo-ganadiario.svg"
																	alt="Jugar Gana Diario" />
																</a> <a href="juega-latinka-video-loterias.html"
																	class="button-ico ico-videoloteria"
																	id='btn_desktop_home_videoloteria'> <img
																	src="./layer-view-image/v2/landing/svg/videoloterias.png?v=1"
																	alt="Jugar Video Loteria" />
																</a> <a href="juega-kinelo.html"
																	class="button-ico ico-kinelo"
																	id='btn_desktop_home_kinelo'> <img
																	src="./layer-view-image/v2/logo-kinelo.png"
																	alt="Jugar Kinelo" />
																</a> <a href="juega-ganagol.html"
																	class="button-ico ico-ganagol"
																	id='btn_desktop_home_ganagol'> <img
																	src="./layer-view-image/v2/logo-ganagol.svg"
																	alt="Jugar Ganagol Apuestas de Fútbol" />
																</a> <a onclick="toTAV2();"
																	class="button-ico ico-teapuesto hand"
																	id='btn_desktop_home_teapuesto'> <img
																	src="./layer-view-image/v2/logo-teapuesto.png?v=2"
																	alt="Jugar Te Apuesto Apuestas Deportivas" />
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
					</div>
					<div class="col-12 col-md-4">
						<aside class="banner">
							<div class="boxes-banner">

								<c:if test="${isLaPolla}">
				      			<div class="box-banner">
									<div class="">
										<div align="center">
											<a href="#" onclick="toLaPolla();" target="_top">
												<img src="layer-view-image/v2/landing/img/ban-lapolla-teapuesto.png" alt="Polla del Mundial Qatar 2022">
											</a>
										</div>
									</div>
								</div>
								</c:if>
								
								<c:set var="comunicadoGanagol" scope="session"
									value='<%=ConnectionFactory.operationProperty("comunicadoGanagol", Constants.contextSale).trim()%>' />
								<c:if test="${comunicadoGanagol == true}">
									<div class="box-main-game-alert">
										<h2><%=ConnectionFactory.operationProperty("titleGanagolMessage", Constants.contextSale)%></h2>
										<p class="message-game-alert"><%=ConnectionFactory.operationProperty("contentGanagolMessage", Constants.contextSale)%></p>
									</div>
								</c:if>
								<div id="iframeTool">
									<iframe id="myIframe" src="${iframeHomeGanagolURL}"
										frameborder="0" scrolling="no">
										<p>Is imposible, your browser dont support iframe</p>
									</iframe>
								</div>
								<div class="box-banner">
									<div class="box-main-game">
										<a
											href="javascript:openDivLayer('ggresultados','null','https://resultados.latinka.com.pe/i.do?m=resultados&t=1&s=4',700,450);"
											class="box-ganagol-results"></a>
									</div>
								</div>

								<div class="box-banner">
									<div class="box-main-game">
										<a target="_self"
											id="btn_desktop_comentarios_de_partido_ganagol"
											href="<%=Constants.URL_QW%>/comentarios-partidos/?origin=i"
											class="box-ganagol-comments"></a>
									</div>
								</div>

								<div class="box-banner">
									<div class="box-main-game">
										<div class="box-video">
											<div class="box-video-src">
												<iframe width="100%" height="125px"
													src="<%=ConnectionFactory.operationProperty("iflexGanagolYoutubeUrl", Constants.contextSale).trim()%>"
													frameborder="0" allowfullscreen></iframe>
											</div>
											<div class="box-video-more">
												<a target="_self"
													href="<%=Constants.URL_QW%>/ganagol/ultimos-resultados/?origin=i"><img
													src="./layer-view-image/v2/view-more-white.png" alt="" />
													Ver más videos</a>
											</div>
										</div>
									</div>
								</div>

								<div class="box-banner">
									<a target="_blank"
										href="https://www.facebook.com/GanagolOficial"
										class="box-social"> <img
										src="./layer-view-image/v2/facebook.png" alt="" />
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
    <script type="text/javascript" src="layer-view-script/game/ganagol/lotto-ganagol.js?v=9"></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js?v=3'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<%@ include file="../../include/footer.jspf"%>
	<script type="text/javascript">

    	$(document).ready(function(){
    		renderNewPasswordFieldGame();
    	});

		$('#tab-item_4').on('click', function (event) {
			datalayerFinalizaCompra2(this,'Cargar Saldo');
	    });
	
		$("#btn_desktop_home_raspaya , #btn_desktop_home_casino , #btn_desktop_home_kinelo , #btn_desktop_home_tinka, #btn_desktop_home_teapuesto, #btn_desktop_home_ddvv, #btn_desktop_home_kabala, #btn_desktop_home_ganagol , #btn_desktop_home_ganadiario").on('click',function(){
        	var textoAlt = $(this).children("img").attr('alt');
        	datalayerGraciasCompra(textoAlt,'Seguir jugando');
        });
    
	</script>

</body>
</html>
