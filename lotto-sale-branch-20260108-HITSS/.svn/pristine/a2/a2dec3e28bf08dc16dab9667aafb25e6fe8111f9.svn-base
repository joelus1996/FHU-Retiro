<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isTinkaSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=tinka"/></c:if>
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
    "name": "Jugar La Tinka",
    "item": "https://www.latinka.com.pe/p/juega-tinka.html" 
  }]
}
</script>

<meta property="og:title" content="Juega Tinka Online | Resultados y Pozo de la Tinka">
<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
<meta property="og:url" content="https://www.latinka.com.pe/p/juega-tinka.html">
<meta property="og:description" content="Juega en línea Tinka, la lotería líder del Perú que sortea un pozo millonario los miércoles y domingos. ¡Tinka, juégala y cambia tu vida!">
<meta property="og:type" content="business.business">
<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-tinka.png">	
<meta charset="utf-8">
<meta name="viewport" content="width=1024">

<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/tinka/theme.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/tinka/themeTinka.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/tinka/dialog.css?v=1">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/tinka/tinkaexpress-iframe.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
<!-- link rel="stylesheet" href="layer-view-style/v2/styles.css" type="text/css" / -->

<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
<title>Juega Tinka Online | Resultados y Pozo de la Tinka</title>
<meta name="description" content="Juega en línea Tinka, la lotería líder del Perú que sortea un pozo millonario los miércoles y domingos. ¡Tinka, juégala y cambia tu vida!">
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<style>


.main-play .body-play .wrapper-playing .box-content-game .text-body {
    font-family: 'Roboto', sans-serif;
    font-size: 14px;
    line-height: 20px;
    margin: 0;
    color: #000;
    margin-bottom: 4px;
    min-height: 20px;
}

.main-play .body-play .wrapper-playing .box-content-game .box-content-detail .text-numbers {
    font-family: AllerBold;
    font-size: 16px;
    line-height: 22px;
    font-weight: 700;
    margin: 0;
    color: #000;
}

.main-play .body-play .wrapper-playing .box-content-game .box-content-info p {
    font-family: AllerRegular;
    font-size: 12px;
    line-height: 16px;
    color: #000;
    margin: 0;
}

.main-play .body-play .wrapper-playing .box-content-game p.box-content-info-text {
    color: #818181;
    margin-bottom: 4px;
}

.main-play .body-play .wrapper-playing .box-content-game .box-content-info a {
    font-family: AllerBold, Arial, sans-serif;
    color: #000;
}

.button.button-dark-green:disabled {
    background-color: #b6b1aa;
}

</style>	
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	
	<h1 style="display: none;">Jugar La Tinka Online</h1>
	<%@ include file="../../include/header.jspf" %>
	<div id="mensajeNotificacion">
			
	</div>

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
	
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Tinka" id="Zona">
	<input type="hidden" value="Juega Tinka" id="SubZona">
	
	<input type="hidden" value="${tinkaSale.promotionMessage}" id="promotionMessage">
	<input type="hidden" value="${tinkaSale.flagPromotionMessage}" id="flagPromotionMessage">
	<input type="hidden" value="<%=ConnectionFactory.operationProperty("tinkaExpressIframe", Constants.contextSale).trim()%>" id="srcTinkaExpressIframe">

	<div class="main-content">
		<div class="main-page">

			<div class="main-game main-tinka">

				<div class="action-float">
					<button class="button button-yellow-gradient" onclick="openTinkaCotejador();">COTEJA TU BOLETO</button>
				</div>
			
				<div class="row">
					<div class="col-12 col-md-8">
						<div class="box-main-game top-box">
							<div class="top-banner top-tinka">
								<figure>
									<img src="layer-view-image/v2/logo-tinka.svg?v=3" alt="Jugar La Tinka Lotería" />
								</figure>
								<div class="body-banner">
									<div class="left-banner">
										<div class="banner-price">
											<h5>POZO MILLONARIO</h5>
											<h3>S/ ${tinkaSale.prize}</h3>
										</div>
									</div>
									<div class="right-banner">
										<div class="banner-desc">
											<c:if test="${tinkaSale.status == 'ACT'}">
												<p>Ju&eacute;galo</p>
												<p>hasta las ${tinkaSale.closeHour}</p>
												<p>${tinkaSale.closeDate}</p>
											</c:if>
											<c:if test="${tinkaSale.status == 'CIE'}">
												<p>Pr&oacute;ximo sorteo</p>
												<p>Abre ${tinkaSale.openDate}</p>
												<p>a las ${tinkaSale.openHour}</p>
											</c:if>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="main-panel">
							
							<div class="main-play" <c:if test="${tinkaSale.status == 'CIE'}">style="opacity: 0.6; pointer-events: none;"</c:if>>
								
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

								<div class="body-play">

									<div class="play-help">
                                         <a href="<%=Constants.URL_QW%>/tutorial/como-jugar-tinka/" onclick="datalayerFinalizaCompraAyuda(this,'Ayuda');" target="_blank" class="play-text"><span>?</span> Ayuda</a>
                                     </div>
									
									<div class="wrapper-playing">
										<div class="boxes-playing">

											<form name="start_play" id="start_play">
												<div class="box-playing">
													<div class="row no-gutters">
														<div class="col-6">
															<div class="box-wrapper-game box-content-left">
																<div class="box-content-game">
																	<div class="box-play-main box-play-a">
																		<div class="content-single-game">
																			<div class="top-single-game">
																				<h3>JUGADA A <span>Marca 6 bolillas o más</span></h3>
																			</div>
																			<div class="body-single-game">
																				<div class="body-game">
																					<div class="button-group checkboxes-ball clearfix">
																						
																						<c:forEach var="bolilla" begin="1" end="50">
																							<label>
																							  <input class="J1check_${bolilla}" type="checkbox" name="J1check" value="${bolilla}" id="J1check_${bolilla}"/>
																							  <span class="button-group-item check_" id="LJ1check_${bolilla}" for="J1check_${bolilla}">
																							  	<span class="label-item">${bolilla}</span>
																							  </span>
																							</label>
																						</c:forEach>
																						
																					</div>
																				</div>
																			</div>
																			<div class="footer-single-game">
																				<div class="row no-gutters">
																					<div class="col-6">
																						<div class="footer-single-left">
																							<button type="button" id="J1azar" class="azar button button-block button-yellow button-sm button-no-shadow">Al Azar</button>
																						</div>
																					</div>
																					<div class="col-6">
																						<div class="footer-single-right">
																							<button type="button" id="J1clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		<!-- texto de las bolillas elegidas para usuario conectado y no conectado -->
																		<c:if test="${clientBalance==null}">
																			<div class="box-content-detail" style="top: 12px;right: -271px;">
																				<p class="text-body">Tus números son</p>
																				<p id="J1-text" class="text-numbers"></p>
																			</div>
																		</c:if>	
																		
																		<c:if test="${clientBalance!=null}">
																			<div class="box-content-detail">
																				<h5>Tus números son</h5>
																				<textarea id="J1-text-area" class="current-numbers" readonly="readonly"></textarea>
																			</div>
																		</c:if>	
																		
																	</div>
																	<div class="box-play-main box-play-b" style="display: none">
																		<div class="content-single-game">
																			<div class="top-single-game">
																				<h3>JUGADA B <span>Marca 6 bolillas o más</span></h3>
																			</div>
																			<div class="body-single-game">
																				<div class="body-game">
																					<div class="button-group checkboxes-ball clearfix">
																						
																						<c:forEach var="bolilla" begin="1" end="50">
																							<label>
																							  <input class="J2check_${bolilla}" type="checkbox" name="J2check" value="${bolilla}" id="J2check_${bolilla}"/>
																							  <span class="button-group-item check_" id="LJ2check_${bolilla}" for="J2check_${bolilla}">
																							  	<span class="label-item">${bolilla}</span>
																							  </span>
																							</label>
																						</c:forEach>
																						
																					</div>
																				</div>
																			</div>
																			<div class="footer-single-game">
																				<div class="row no-gutters">
																					<div class="col-6">
																						<div class="footer-single-left">
																							<button type="button" id="J2azar" class="azar button button-block button-yellow button-sm button-no-shadow">Al Azar</button>
																						</div>
																					</div>
																					<div class="col-6">
																						<div class="footer-single-right">
																							<button type="button" id="J2clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		<!-- texto de las bolillas elegidas para usuario conectado y no conectado -->
																		<c:if test="${clientBalance==null}">
																			<div class="box-content-detail" style="top: 12px;right: -271px;">
																				<p class="text-body">Tus números son</p>
																				<p id="J2-text" class="text-numbers"></p>
																			</div>
																		</c:if>	
																		
																		<c:if test="${clientBalance!=null}">
																			<div class="box-content-detail">
																				<h5>Tus números son</h5>
																				<textarea id="J2-text-area" class="current-numbers" readonly="readonly"></textarea>
																			</div>
																		</c:if>	
																	</div>
																	<div class="box-play-main box-play-c" style="display: none">
																		<div class="content-single-game">
																			<div class="top-single-game">
																				<h3>JUGADA C <span>Marca 6 bolillas o más</span></h3>
																			</div>
																			<div class="body-single-game">
																				<div class="body-game">
																					<div class="button-group checkboxes-ball clearfix">
																						
																						<c:forEach var="bolilla" begin="1" end="50">
																							<label>
																							  <input class="J3check_${bolilla}" type="checkbox" name="J3check" value="${bolilla}" id="J3check_${bolilla}"/>
																							  <span class="button-group-item check_" id="LJ3check_${bolilla}" for="J3check_${bolilla}">
																							  	<span class="label-item">${bolilla}</span>
																							  </span>
																							</label>
																						</c:forEach>
																						
																					</div>
																				</div>
																			</div>
																			<div class="footer-single-game">
																				<div class="row no-gutters">
																					<div class="col-6">
																						<div class="footer-single-left">
																							<button type="button" id="J3azar" class="azar button button-block button-yellow button-sm button-no-shadow">Al Azar</button>
																						</div>
																					</div>
																					<div class="col-6">
																						<div class="footer-single-right">
																							<button type="button" id="J3clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		<!-- texto de las bolillas elegidas para usuario conectado y no conectado -->
																		<c:if test="${clientBalance==null}">
																			<div class="box-content-detail" style="top: 12px;right: -271px;">
																				<p class="text-body">Tus números son</p>
																				<p id="J3-text" class="text-numbers"></p>
																			</div>
																		</c:if>	
																		
																		<c:if test="${clientBalance!=null}">
																			<div class="box-content-detail">
																				<h5>Tus números son</h5>
																				<textarea id="J3-text-area" class="current-numbers" readonly="readonly"></textarea>
																			</div>
																		</c:if>	
																		
																		
																	</div>
																	<div class="box-play-main box-play-d" style="display: none">
																		<div class="content-single-game">
																			<div class="top-single-game">
																				<h3>JUGADA D <span>Marca 6 bolillas o más</span></h3>
																			</div>
																			<div class="body-single-game">
																				<div class="body-game">
																					<div class="button-group checkboxes-ball clearfix">
																						
																						<c:forEach var="bolilla" begin="1" end="50">
																							<label>
																							  <input class="J4check_${bolilla}" type="checkbox" name="J4check" value="${bolilla}" id="J4check_${bolilla}"/>
																							  <span class="button-group-item check_" id="LJ4check_${bolilla}" for="J4check_${bolilla}">
																							  	<span class="label-item">${bolilla}</span>
																							  </span>
																							</label>
																						</c:forEach>
																						
																					</div>
																				</div>
																			</div>
																			<div class="footer-single-game">
																				<div class="row no-gutters">
																					<div class="col-6">
																						<div class="footer-single-left">
																							<button type="button" id="J4azar" class="azar button button-block button-yellow button-sm button-no-shadow">Al Azar</button>
																						</div>
																					</div>
																					<div class="col-6">
																						<div class="footer-single-right">
																							<button type="button" id="J4clear" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		
																		<!-- texto de las bolillas elegidas para usuario conectado y no conectado -->
																		<c:if test="${clientBalance==null}">
																			<div class="box-content-detail" style="top: 12px;right: -271px;">
																				<p class="text-body">Tus números son</p>
																				<p id="J4-text" class="text-numbers"></p>
																			</div>
																		</c:if>	
																		
																		<c:if test="${clientBalance!=null}">
																			<div class="box-content-detail">
																				<h5>Tus números son</h5>
																				<textarea id="J4-text-area" class="current-numbers" readonly="readonly"></textarea>
																			</div>
																		</c:if>	
																		
																	</div>
																</div>
															</div>
														</div>
														<div class="col-6">
															<c:if test="${clientBalance==null}">
																<%@ include file="./jugada_resumen_no_conectado.jsp" %>
															</c:if>	
															
															<c:if test="${clientBalance!=null}">
																<%@ include file="./jugada_resumen_conectado.jsp" %>
															</c:if>	
															
															
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>

									<div class="wrapper-buying">

										<div class="box-wrapper-game">
											<div class="box-content-game">
												<div class="top-single-game">
													<!-- <h3>TINKA</h3> -->
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
																<h4>${tinkaSale.promotionMessage}<div class="text-detail-pay detail-pay-monto label_resu2"></div></h4>
																<h4><div class="text-detail-pay label_resu3"></div></h4>
																<h4><div class="text-detail-pay label_resu4"></div></h4>
																
																<h4 style="border-block-start: inherit;padding-top: 0.5rem;"><b><span class="label_resu1">Total a pagar</span></b><div class="text-detail-pay detail-pay-monto result1"></div></h4>
															</div>
															<div class="box-action-pay">
																<div id="panel_more_plays">
																	<span class="labelMsgJugadaGratis"></span>
																	<button type="button" id="more_plays" class="button button-lg button-no-shadow button-block button-green-new">
																		<b>AGREGAR JUGADAS</b>
																	</button>
																</div>
																<div id="panel_keep-playing">
																	<a onclick="datalayerGraciasCompra('SEGUIR JUGANDO','Seguir Jugando');" href="juega-tinka.html"  id="keep-playing" class="button button-lg button-no-shadow button-block button-orange">
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
											            <%@ include file="../../include/logintinkaexpress.jspf" %>
														<form id="frmLoadBalance">
									                        <div id="payments_section">
																<div class="tab-item accordion-off" id="tab-item_4" data-hash="saldo" style="display:block;">
													                <div class="accordion-ico">
													                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M9.5,16.72c-1.79,0-3.18-.55-3.83-2.16l1.38-.72a2.5,2.5,0,0,0,2.47,1.39c1,0,2-.36,2-1.32s-.87-1.17-2-1.29c-1.79-.21-3.45-.69-3.45-2.66,0-1.81,1.78-2.55,3.4-2.56a3.55,3.55,0,0,1,3.45,1.74l-1.32.68a2.52,2.52,0,0,0-2.08-1c-1.23,0-1.82.51-1.82,1.17s.9,1,2,1.1c1.83.23,3.54.7,3.54,2.8S11.46,16.72,9.5,16.72Zm5.38.65H13.6L17,8.81h1.29Z"/></g></g></svg>
													                </div>
													                <div class="title-accordion">CARGAR SALDO</div>
													                <i></i>
													                <input type="hidden" id="marca_logo" value="logo-tinka.png">
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
										            									<span id="field-balance-amount">${tinkaSale.balanceBill01}</span>
										            								</label>
										            							</td>
										            						</tr>
										            					</table>
										            				</div>
<!-- 										            				<div id="separator_hr"></div> -->
<!-- 										            				<div class="top-saldo wb-saldo"></div> -->
<!-- 										            				<div id="pan_1"> -->
<!-- 										            					<div class="label2">RECARGAS POR INTERNET</div> -->
<!-- 										            					<table> -->
<%-- 										            						<c:forTokens var="channel1Order" items="${tinkaSale.channel1Order}" delims=","> --%>
<%-- 										            							<%@ include file="../../include/balance1.jspf"%> --%>
<%-- 										            						</c:forTokens> --%>
<!-- 										            					</table> -->
<!-- 										            					<div class="label2">RECARGAS F&Iacute;SICAS</div> -->
<!-- 										            					<table> -->
<%-- 										            						<c:forTokens var="channel2Order" items="${tinkaSale.channel2Order}" delims=","> --%>
<%-- 										            							<%@ include file="../../include/balance2.jspf"%> --%>
<%-- 										            						</c:forTokens> --%>
<!-- 										            					</table> -->
<!-- 										            				</div> -->
<!-- 										            				<div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div> -->
													            </div>
											            	</div>
									            		</form>
													</div>
													<div id="panel_finaliza_compra">
<!-- 														<a href="#" class="button button-dark-green" id='btn_finaliza_compra' onclick="return false;">FINALIZAR TU COMPRA</a> -->
														<a href="#" class="button button-dark-green button-red-new" id='btn_desktop_finalizar_compra_tinka' onclick="return false;">FINALIZAR TU COMPRA</a>
													</div>

													<div class="clearfix"></div>

													<div id="ico-block">
													    <div id="ico-title">¡SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
													    <div id="ico-panel" class="clearfix">
<!-- 													   <a href="juega-tinka.html" class="button-ico ico-tinka" id='icotinka'> -->
															<a href="juega-tinka.html" class="button-ico ico-tinka" id='btn_desktop_home_tinka'>
													            <img src="./layer-view-image/v2/logo-tinka.svg?v=3" alt="Jugar La Tinka Lotería" />
													        </a>
													        <a href="juega-kabala.html" class="button-ico ico-kabala" id='btn_desktop_home_kabala'>
													            <img src="./layer-view-image/v2/logo-kabala.svg" alt="Jugar Kabala" />
													        </a>
													        <a href="juega-ganadiario.html" class="button-ico ico-ganadiario" id='btn_desktop_home_ganadiario'>
													            <img src="./layer-view-image/v2/logo-ganadiario.svg" alt="Jugar Gana Diario" />
													        </a>
													        <a href="juega-latinka-video-loterias.html" class="button-ico ico-videoloteria" id='btn_desktop_home_videoloteria'>
													            <img src="./layer-view-image/v2/landing/svg/videoloterias.png?v=1" alt="Jugar Video Loteria" />
													        </a>
													        <a href="juega-kinelo.html" class="button-ico ico-kinelo" id='btn_desktop_home_kinelo'>
													            <img src="./layer-view-image/v2/logo-kinelo.png" alt="Jugar Kinelo" />
													        </a>
													        <a href="juega-ganagol.html" class="button-ico ico-ganagol" id='btn_desktop_home_ganagol'>
													            <img src="./layer-view-image/v2/logo-ganagol.svg" alt="Jugar Ganagol Apuestas de Fútbol" />
													        </a>
													        <a onclick="toTAV2();" class="button-ico ico-teapuesto hand" id='btn_desktop_home_teapuesto'>
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

									  <!-- Tinka Express iFrame -->
						              <iframe
						                class="tinka-express-iframe"
						                id="tinkaExpressIframe"
						                title="Tinka Express"
						                allowfullscreen="true"
						                allowpaymentrequest="true"
						                border="0"></iframe>
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
											<a href="https://www.lapollateapuesto.pe/" rel="dofollow" style="display: none; visibility: hidden;"></a>
										</div>
									</div>
								</div>
								</c:if>

								<c:set var = "comunicadoTinka" scope = "session" value ='<%=ConnectionFactory.operationProperty("comunicadoTinka", Constants.contextSale).trim()%>' />
								<c:if test="${comunicadoTinka == true}">
									<div class="box-main-game-alert">
										<h2><%=ConnectionFactory.operationProperty("titleTinkaMessage", Constants.contextSale)%></h2>
										<p class="message-game-alert"><%=ConnectionFactory.operationProperty("contentTinkaMessage", Constants.contextSale)%></p>
									</div>
								</c:if>
								
		        				<div id="iframeTool">
		        					<iframe id="myIframe" src="${iframeHomeTinkaURL}" frameborder="0" scrolling="no" ><p>Is imposible, your browser dont support iframe</p></iframe>
		        				</div>
		        				
		        				<div class="box-banner">
			        				<div class="box-main-game">
			        					<div class="box-video">
			        						<div class="box-video-src">
			        							<iframe id="tinkaYoutube" width="100%" height="125px" src="<%=ConnectionFactory.operationProperty("iflexTinkaYoutubeUrl", Constants.contextSale).trim()%>" frameborder="0" allowfullscreen></iframe>
			        						</div>
			        						<div class="box-video-more">
			        							<a target="_self" href="<%=Constants.URL_QW%>/tinka/ultimos-resultados/?origin=i"><img src="./layer-view-image/v2/view-more-tinka.png" alt="Jugar Casino Online" /> Ver más videos</a>
			        						</div>
			        					</div>
			        				</div>
			        			</div>
		        				
			        			<div class="box-banner">
			        				<div class="box-main-game">
			        					<div class="box-last-game">
			        						<h4>JUGADA GANADORA</h4>
			        						<h3 id="tk-date"></h3>
			        						<div class="last-restuls">
				        						<div class="results-balls clearfix" id="tk-balls"></div>
				        						<img id="siosi-img" class="hide siosi-img" src="layer-view-image/game/tinka/siosi-tinka.png?v=2" alt="jugar la tinka"/>
				        						<div class="results-balls siosi clearfix" id="siosi-balls"></div>				        						
			        						</div>
			        						<div class="action-box-banner">
			        							<a class="button button-red button-block" href="javascript:openDivLayer('resultados','tinka','<%=Constants.resultsServerURI%>i.do?m=resultados&amp;t=0&amp;s=41',600,470);">RESULTADOS ANTERIORES</a>
			        						</div>
			        					</div>
			        				</div>
			        			</div>
			        			<div class="box-banner">
			        				<div class="box-main-game">
			        					<div class="box-stats">
			        						<a href="javascript:openDivLayer('estadisticas','tinka','estadistica.html?marca=41',708,490)"><h4>Entérate de las <span>estadísticas</span></h4></a>
			        					</div>
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

	<!-- Continuacion de Tinka Express -->
	<!-- Modal Alert -->
    <div role="presentation" class="Dialog-root" id="tinka-express-alert-dialog">
      <div aria-hidden="true" class="Dialog-backdrop" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;"></div>
      <div class="Dialog-container" role="presentation" tabindex="-1" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;">
        <div class="Dialog-paper AlertDialog-paper" role="dialog" aria-labelledby="alert-dialog">
          <div class="Dialog-content AlertDialog-content">
            <div class="AlertDialog-header">
              <button type="button" class="Dialog-close" id="alert-dialog-close" tabindex="0">
                <i class="icon">
                  <svg width="30" height="30" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M6 6L18 18M18 6L6 18" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                  </svg>
                </i>
              </button>
            </div>
            <figure class="AlertDialog-image">
              <img class="is-error is-hidden" src="layer-view-image/game/tinka/alert/error.png" alt="Icon Dialog" width="56" height="56" />
              <img class="is-success is-hidden" src="layer-view-image/game/tinka/alert/success.png" alt="Icon Dialog" width="56" height="56" />
            </figure>
            <div class="AlertDialog-title">
              <h2 id="alert-dialog-title">Title</h2>
            </div>
            <div class="AlertDialog-paragraph">
              <p id="alert-dialog-paragraph">Paragraph</p>
            </div>
          </div>
          <div class="Dialog-actions AlertDialog-actions">
            <button type="button" class="btn-alert btn-alert-dialog-primary" id="btn-agree-dialog">
              Agree
            </button>
            <button type='button' class='btn-alert btn-alert-dialog-outline-primary' id="btn-disagree-dialog">
              Disagree
            </button>
          </div>
        </div>
      </div>
    </div>

    <!-- Modal Guide -->
    <div role="presentation" class="Dialog-root" id="tinka-express-help-dialog">
      <div aria-hidden="true" class="Dialog-backdrop" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;"></div>
      <div class="Dialog-container" role="presentation" tabindex="-1" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;">
        <div class="Dialog-paper HelpDialog-paper" role="dialog" aria-labelledby="help-dialog">
          <div class="Dialog-content HelpDialog-content">
            <div class="HelpDialog-header">
              <button type="button" class="Dialog-close" id="help-dialog-close" tabindex="0">
                <i class="icon">
                  <svg width="30" height="30" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <path d="M6 6L18 18M18 6L6 18" stroke="currentColor" stroke-width="1.5" stroke-linecap="round" stroke-linejoin="round"></path>
                  </svg>
                </i>
              </button>
            </div>
            <p>
			  &iexcl;Cobra tus premios f&aacute;cil y r&aacute;pido, est&eacute;s donde est&eacute;s!<br>
			  Si recibiste un boleto digital, elige la opci&oacute;n que prefieras:
			</p>
            <p>
			  Para cobrar en efectivo premios menores a S/&nbsp;2,000, en cualquier Punto de Venta autorizado.<br>
			  De forma digital, para premios de cualquier monto, escaneando o subiendo tu boleto en 
			  <a href="https://tinkanet.pe/" class="font-semi-bold underline" target="_blank" rel="noopener noreferrer">www.tinkanet.pe</a><br>
			  Si realizaste una compra Express (invitado web), puedes activar el pago autom&aacute;tico desde la secci&oacute;n &ldquo;Retirar premios&rdquo; en 
			  <a href="https://www.latinka.com.pe/" class="font-semi-bold underline" target="_blank" rel="noopener noreferrer">www.latinka.com.pe</a>
			</p>
			<p>
			  Tus premios estar&aacute;n seguros y disponibles cuando quieras. Y tus boletos, siempre protegidos.
			</p>
            
<!--             <p>Si ya tienes una cuenta en La Tinka, ingresa a <a href="https://www.latinka.com.pe/" class="font-semi-bold underline" target="_blank" rel="noopener noreferrer">www.latinka.com.pe</a>, tu premio estar&aacute; disponible para cobrarlo.</p> -->
<!--             <p>Si no tienes cuenta en La Tinka, ingresa a <a href="https://www.tinkanet.pe/" class="font-semi-bold underline" target="_blank" rel="noopener noreferrer">www.tinkanet.pe</a> y sube la imagen de tu boleto para poder cobrar el premio.</p> -->
<!--             <p>Adicionalmente, si tu premio es menor S/&nbsp;2,000, puedes acercarte a cualquier Punto de Venta de La Tinka y cobrarlo en efectivo.</p> -->
          </div>
        </div>
      </div>
    </div>

    <!-- Modal Ticket -->
    <div role="presentation" class="Dialog-root" id="tinka-express-ticket-dialog">
      <div aria-hidden="true" class="Dialog-backdrop" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;"></div>
      <div class="Dialog-container" role="presentation" tabindex="-1" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;">
        <div class="Dialog-paper TicketDialog-paper Dialog-paperScrollPaper Dialog-paperWidthSm Dialog-paperFullScreen" role="dialog" aria-labelledby="ticket-dialog">
          <div class="TicketDialog-header">
            <button type="button" class="btn-icon" id="ticket-dialog-close">
              <i class="icon">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <path d="M6 6L18 18M18 6L6 18" stroke="var(--color-black)" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"></path>
                </svg>
              </i>
            </button>
            <button type="button" class="btn-icon" id="ticket-dialog-download">
              <i class="icon">
                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  <line x1="4.85" y1="20.15" x2="19.15" y2="20.15" stroke="var(--color-black)" stroke-width="1.7" stroke-linecap="round"></line>
                  <path d="M7 11L11.9754 16L17 11" stroke="var(--color-black)" stroke-width="1.7" stroke-linecap="round" stroke-linejoin="round"></path>
                  <line x1="11.85" y1="3.85" x2="11.85" y2="15.15" stroke="var(--color-black)" stroke-width="1.7" stroke-linecap="round"></line>
                </svg>
              </i>
            </button>
          </div>
          <div class="Dialog-content TicketDialog-content">
            <div class="flex-center">
              <figure class="TicketDialog-image">
                <img 
                  id="ticket-dialog-image"
                  src="layer-view-image/game/tinka/ticket-placeholder.jpg"
                  alt="Boleto digital" 
                  loading="lazy"
                  width="346" 
                  height="705" 
                />
              </figure>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!-- Tinka Express Checkout -->
<!--     <iframe -->
<!--       class="tinka-express-checkout is-hidden" -->
<!--       id="tinkaExpressCheckout" -->
<!--       title="Payment button" -->
<!--       allowfullscreen="true" -->
<!--       allowpaymentrequest="true" -->
<!--       border="0" -->
<%--       src="<%=ConnectionFactory.operationProperty("tinkaExpressIframe", Constants.contextSale).trim()%>checkout-button" --%>
<!--       loading="lazy" -->
<!--       frameborder="0" -->
<!--       allowtransparency="true" -->
<!--       allow="encrypted-media" -->
<!--       style="width: 100vw; height: 100vh; min-width: 100%; overflow: hidden;" -->
<!--     ></iframe> -->
<!--  <a onclick="openPreviewWindow_tinka();">popup2TINKA</a> -->
    <script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='layer-view-script/common/jquery.scripts.js'></script>
    <script type='text/javascript' src='layer-view-script/game/tinka/lotto-tinka.js?v=10'></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js?v=2'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<script type='text/javascript' src='layer-view-script/game/tinka/iframeResizer.min.js'></script>
<!-- 	<script type='text/javascript' src='layer-view-script/game/tinka/dialogs.js?v=1'></script> -->
    <script type='text/javascript' src='layer-view-script/game/tinka/tinkaexpress-iframe.js?v=1.5'></script>														
	<%@ include file="../../include/footer.jspf" %>
    <script type="text/javascript">

    	$(document).ready(function(){
    		try {
    			tagginEligeJugadaIndividualTinka();				
			} catch (e) {
				console.error(e);
			}
    		
			// validar token e iniciar sesion
			validarTokenLogin();
			
			if( !loginUsuarioTinkaOk() ){
    			$("#panel_more_plays").hide();
            }
			
    		$.ajax({
    		  url: $("#gamesXML").val(),
    		  // url: "./games.xml",
    		  cache: false,
    		  success: function(res) {
    		  	var xmlDoc = res;
    		  	data = xmlDoc.getElementsByTagName("data");
    		  	if (data[0]) {
    		  		
    		  		data = data[0];

    		  		var bolos_tinka = data.getElementsByTagName("tk_bolos")[0].childNodes[0].nodeValue.split(' ');
    		  		var bolo_tinka_yapa = data.getElementsByTagName("tk_yapa")[0].childNodes[0].nodeValue;
    		  		bolos_tinka.push(bolo_tinka_yapa);

    		  		printBalls(bolos_tinka, "#tk-balls")

    		  		var results_date_tinka = data.getElementsByTagName("tk_fecha")[0].childNodes[0].nodeValue;
    		  		printDate(results_date_tinka, "#tk-date");

    		  		var bolos_siosi = data.getElementsByTagName("tk_siosi")[0].childNodes[0];

    		  		if (bolos_siosi) {
    		  			printBalls(bolos_siosi.nodeValue.split(' '), "#siosi-balls");
    		  			$("#siosi-img").removeClass("hide");
    		  		}

    		  		var total_prize = data.getElementsByTagName("tk_total_premios")[0].childNodes[0].nodeValue;
			  		$('#total-prize').html("S/ " + total_prize);

    		  	} else {
    		  		console.log('no data')
    		  	}

    		  }, error: function(e) {
    		  	console.log('error obteniendo xml...')
    		  }
    		});

    		renderNewPasswordFieldGame();

    	});

    	function tagginEligeJugadaIndividualTinka(){
    		window.dataLayer = window.dataLayer || [ ];
    		dataLayer.push({
    		    'event': 'virtualPageView',
    		    'pageUrl': '/juega-tinka/individual/paso1/',
    		    'pageTitle': 'Elige tu jugada - Individual - Tinka'

    		});

    		var tag="Elige tu jugada - Individual - Tinka";
    		console.log("Taggin event: "+tag);
    		        	
        }
    	
    	$('#tab-item_4').on('click', function (event) {
    		datalayerFinalizaCompra2(this,'Cargar Saldo');
        });

        $('#btnLoginGuest').on('click', function (event) {
        	LoginInvitadoTinkaExpress();
        });

        $("#frmLoginClient").on("submit", function (event) {
        	$("#panel_more_plays").show();
        });

        $('#home-btnlogin').attr('disabled', true);

        $("#frmLoginClient").find("input").on("keyup", function() {
        	var userField = $("#user-client");
            var passwordField = $("#password-client");
			var form = $("#frmLoginClient");
            if (userField.val() && passwordField.val() && form.valid()) {
            	$('#home-btnlogin').prop("disabled", false);
            } else {
            	$('#home-btnlogin').prop("disabled", true);
            }
        });
        
        $("#btn_desktop_home_raspaya , #btn_desktop_home_casino , #btn_desktop_home_kinelo , #btn_desktop_home_tinka, #btn_desktop_home_teapuesto, #btn_desktop_home_ddvv, #btn_desktop_home_kabala, #btn_desktop_home_ganagol , #btn_desktop_home_ganadiario").on('click',function(){
        	var textoAlt = $(this).children("img").attr('alt');
        	datalayerGraciasCompra(textoAlt,'Seguir jugando');
        });


        function validarTokenLogin(){

			// Crea un objeto URLSearchParams con la URL actual
			var urlSearchParams = new URLSearchParams(document.location.search);

			// Obtiene el valor del parámetro 'token' de la URL
			var token = urlSearchParams.get('token');

			console.log("token:: " + token);
			if(token != null){

				$.ajax({
					type: "POST",
					url: "validarTokenLogin.html",
					dataType: "json",
					data: {"token": token},
					async: false,
				})
			    .done(function(data) {
			    	console.log("data: " , data);
			    	if(data.status=='OK'){
			    		$("#user-client").val("user");
			    		$("#password-client").val("password");

			    		var lrdnField = $("<input>").attr({
			                type: "password",
			                id: "lrdn",
			                name: "lrdn",
			                value: data.lrdn
			            });
			    		$("#frmLoginClient").append(lrdnField);
			    		$("#frmLoginClient").submit();
						
					}
			    })
			    .fail(function(jqXHR, textStatus, errorThrown) {
			    	console.log(textStatus||' '||errorThrown);
			    });
			    
			}
			
        }
        
        function datalayerGraciasCompraSeccion(){
        	var textoSeccion = $(".label-top").text();
			return textoSeccion;
        }

        function loginUsuarioTinkaOk(){
        	return ($("#clientId").val() != '') && ($("#clientId").val() != undefined );
        }

    </script>


		
	
</body>
</html>
