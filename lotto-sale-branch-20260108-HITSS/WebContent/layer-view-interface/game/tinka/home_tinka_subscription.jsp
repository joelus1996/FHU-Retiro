<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isTinkaSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}"/></c:if>
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
	<meta name="description" content="Juega en línea la Tinka,  la lotería líder del Perú que sortea un pozo millonario los miércoles y domingos. ¡Tinka, juégala y cambia tu vida!">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/tinka/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/tinka/themeSubscription.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
	<!-- link rel="stylesheet" href="layer-view-style/v2/styles.css" type="text/css" / -->

	<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
	<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
	<title>Jugar Tinka Online | Resultados y Pozo de la Tinka</title>
<meta name="description" content="Juega en línea Tinka, la lotería líder del Perú que sortea un pozo millonario los miércoles y domingos. ¡Tinka, juégala y cambia tu vida!">
	<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

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
	<input type="hidden" value="${tinkaSale.basePrice}" id="base_price">
	<input type="hidden" value="<%=Constants.iflexBonoTyC.toString().trim()%>" id="iflexBonoTyC" />
	<input type="hidden" value="<%=Constants.wbBonoTyC.toString().trim()%>" id="wbBonoTyC">
	<input type="hidden" value="<c:out value='${clientBalance}'/>" id="clientBalance" >
	<input type="hidden" value="<c:out value='${chargeData}'/>" id="chargeData">
	
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Tinka" id="Zona">
	<input type="hidden" value="Combos Tinkeros" id="SubZona">
		
	<div class="main-content">
		<div class="main-page">

			<div class="main-game main-tinka">

				<div class="main-banner-image">
					<img src="layer-view-image/v2/man.png" alt="jugar la tinka" />
				</div>

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
							<div class="panel-subscription">
								<div class="main-banner">
									<div class="main-banner-tinka">
										<img src="layer-view-image/v2/banner-tinka.gif?v=2" alt="Resultados La Tinka" />
									</div>
								</div>
								<div class="banner-actions">
									<div class="row no-gutters">
										<div class="col-12 col-md-6 box-banner-action">
<!-- 											<a class="button button-red button-inset button-md" href="#" id="btnAdvance">COMBOS TINKEROS</a> -->
											<a class="button button-red button-inset button-md" href="#" id="btn_desktop_combos_tinkeros">COMBOS TINKEROS</a>
											<div class="body-banner-action">
												<p><b>¡No te pierdas ni un solo sorteo!</b></p>
												<p>Juega sorteos por adelantado a un precio especial. Recibirás tu jugada y la jugada ganadora en tu correo o podrás revisarlas en tu Cuenta</p>
											</div>
										</div>
										<div class="col-12 col-md-6 box-banner-action">
<!-- 											<a class="button button-yellow button-inset button-md" id="juegaTinkaState" href="juega-tinka.html?state=1">JUEGA TINKA</a> -->
											<a class="button button-yellow button-inset button-md" id="btn_desktop_juega_tinka">JUEGA TINKA</a>
											<div class="body-banner-action">
												<p><b>Juega aquí tu Tinka de siempre.</b></p>
												<p>Elige tus números y los sorteos que quieras.</p>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-subscription-book disabled">
								<div class="main-play" <c:if test="${tinkaSale.status == 'CIE'}">style="pointer-events: none;"</c:if>>
									
									<div class="steps-play">
										<div class="row no-gutters">
											<div class="col-6">
												<div class="step-play step-status-1 step-active">PASO 1: ELIGE TU COMBO TINKERO</div>
											</div>
											<div class="col-6">
												<div class="step-play step-status-2">PASO 2: FINALIZAR TU COMPRA</div>
											</div>
										</div>
									</div>

									<div class="body-play">
										
										<div class="wrapper-playing" id="start_subscribe_play">
											<div class="boxes-playing">

												<form name="start_subscribe_play" id="start_subscribe_play">
													<div class="box-playing box-subscription">
														<div class="row no-gutters">
															<div class="col-6">
																<div class="box-content-left">
																	<div class="box-content-top">
																		<h4>1: ELIGE TU JUGADA</h4>
																	</div>
																	<div class="box-wrapper-game">
																		<div class="box-content-game">
																			<div class="box-play-main">
																				<div class="content-single-game">

																					<div class="top-subscription-game">
																						<div class="sub-top-single-game">Marca una opción</div>
																						<div class="options-subscriptions">
<!-- 																						    <a id="same-play" href="#" class="option-subscription"> -->
																							<a id="btn_desktop_combo_tinkero_misma_jugada" href="#" class="option-subscription">
																								Una misma jugada para todos los sorteos
																							</a>
<!-- 																							<a id="random-play" href="#" class="option-subscription"> -->
																							<a id="btn_desktop_combo_tinkero_azar_simple" href="#" class="option-subscription">
																								Jugada simple al "Azar" para cada sorteo *
																							</a>
																						</div>
																					</div>

																					<div class="subscription-disabled subscription-disabled-sec1">

																						<div class="top-single-game">
																							<div class="sub-top-single-game">Marca 6 bolillas o más</div>
																						</div>
																						<div class="body-single-game">
																							<div class="body-game">
																								<div class="button-group checkboxes-ball clearfix">
																									
																									<label>
																									  <input type="checkbox" name="chk1" value="1" id="chk1-1"/><span class="button-group-item check_" id="lblchk1-1" for="chk1-1"><span class="label-item">1</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="2" id="chk1-2"/><span class="button-group-item check_" id="lblchk1-2" for="chk1-2"><span class="label-item">2</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="3" id="chk1-3"/><span class="button-group-item check_" id="lblchk1-3" for="chk1-3"><span class="label-item">3</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="4" id="chk1-4"/><span class="button-group-item check_" id="lblchk1-4" for="chk1-4"><span class="label-item">4</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="5" id="chk1-5"/><span class="button-group-item check_" id="lblchk1-5" for="chk1-5"><span class="label-item">5</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="6" id="chk1-6"/><span class="button-group-item check_" id="lblchk1-6" for="chk1-6"><span class="label-item">6</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="7" id="chk1-7"/><span class="button-group-item check_" id="lblchk1-7" for="chk1-7"><span class="label-item">7</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="8" id="chk1-8"/><span class="button-group-item check_" id="lblchk1-8" for="chk1-8"><span class="label-item">8</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="9" id="chk1-9"/><span class="button-group-item check_" id="lblchk1-9" for="chk1-9"><span class="label-item">9</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="10" id="chk1-10"/><span class="button-group-item check_" id="lblchk1-10" for="chk1-10"><span class="label-item">10</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="11" id="chk1-11"/><span class="button-group-item check_" id="lblchk1-11" for="chk1-11"><span class="label-item">11</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="12" id="chk1-12"/><span class="button-group-item check_" id="lblchk1-12" for="chk1-12"><span class="label-item">12</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="13" id="chk1-13"/><span class="button-group-item check_" id="lblchk1-13" for="chk1-13"><span class="label-item">13</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="14" id="chk1-14"/><span class="button-group-item check_" id="lblchk1-14" for="chk1-14"><span class="label-item">14</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="15" id="chk1-15"/><span class="button-group-item check_" id="lblchk1-15" for="chk1-15"><span class="label-item">15</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="16" id="chk1-16"/><span class="button-group-item check_" id="lblchk1-16" for="chk1-16"><span class="label-item">16</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="17" id="chk1-17"/><span class="button-group-item check_" id="lblchk1-17" for="chk1-17"><span class="label-item">17</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="18" id="chk1-18"/><span class="button-group-item check_" id="lblchk1-18" for="chk1-18"><span class="label-item">18</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="19" id="chk1-19"/><span class="button-group-item check_" id="lblchk1-19" for="chk1-19"><span class="label-item">19</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="20" id="chk1-20"/><span class="button-group-item check_" id="lblchk1-20" for="chk1-20"><span class="label-item">20</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="21" id="chk1-21"/><span class="button-group-item check_" id="lblchk1-21" for="chk1-21"><span class="label-item">21</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="22" id="chk1-22"/><span class="button-group-item check_" id="lblchk1-22" for="chk1-22"><span class="label-item">22</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="23" id="chk1-23"/><span class="button-group-item check_" id="lblchk1-23" for="chk1-23"><span class="label-item">23</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="24" id="chk1-24"/><span class="button-group-item check_" id="lblchk1-24" for="chk1-24"><span class="label-item">24</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="25" id="chk1-25"/><span class="button-group-item check_" id="lblchk1-25" for="chk1-25"><span class="label-item">25</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="26" id="chk1-26"/><span class="button-group-item check_" id="lblchk1-26" for="chk1-26"><span class="label-item">26</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="27" id="chk1-27"/><span class="button-group-item check_" id="lblchk1-27" for="chk1-27"><span class="label-item">27</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="28" id="chk1-28"/><span class="button-group-item check_" id="lblchk1-28" for="chk1-28"><span class="label-item">28</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="29" id="chk1-29"/><span class="button-group-item check_" id="lblchk1-29" for="chk1-29"><span class="label-item">29</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="30" id="chk1-30"/><span class="button-group-item check_" id="lblchk1-30" for="chk1-30"><span class="label-item">30</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="31" id="chk1-31"/><span class="button-group-item check_" id="lblchk1-31" for="chk1-31"><span class="label-item">31</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="32" id="chk1-32"/><span class="button-group-item check_" id="lblchk1-32" for="chk1-32"><span class="label-item">32</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="33" id="chk1-33"/><span class="button-group-item check_" id="lblchk1-33" for="chk1-33"><span class="label-item">33</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="34" id="chk1-34"/><span class="button-group-item check_" id="lblchk1-34" for="chk1-34"><span class="label-item">34</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="35" id="chk1-35"/><span class="button-group-item check_" id="lblchk1-35" for="chk1-35"><span class="label-item">35</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="36" id="chk1-36"/><span class="button-group-item check_" id="lblchk1-36" for="chk1-36"><span class="label-item">36</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="37" id="chk1-37"/><span class="button-group-item check_" id="lblchk1-37" for="chk1-37"><span class="label-item">37</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="38" id="chk1-38"/><span class="button-group-item check_" id="lblchk1-38" for="chk1-38"><span class="label-item">38</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="39" id="chk1-39"/><span class="button-group-item check_" id="lblchk1-39" for="chk1-39"><span class="label-item">39</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="40" id="chk1-40"/><span class="button-group-item check_" id="lblchk1-40" for="chk1-40"><span class="label-item">40</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="41" id="chk1-41"/><span class="button-group-item check_" id="lblchk1-41" for="chk1-41"><span class="label-item">41</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="42" id="chk1-42"/><span class="button-group-item check_" id="lblchk1-42" for="chk1-42"><span class="label-item">42</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="43" id="chk1-43"/><span class="button-group-item check_" id="lblchk1-43" for="chk1-43"><span class="label-item">43</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="44" id="chk1-44"/><span class="button-group-item check_" id="lblchk1-44" for="chk1-44"><span class="label-item">44</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="45" id="chk1-45"/><span class="button-group-item check_" id="lblchk1-45" for="chk1-45"><span class="label-item">45</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="46" id="chk1-46"/><span class="button-group-item check_" id="lblchk1-46" for="chk1-46"><span class="label-item">46</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="47" id="chk1-47"/><span class="button-group-item check_" id="lblchk1-47" for="chk1-47"><span class="label-item">47</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="48" id="chk1-48"/><span class="button-group-item check_" id="lblchk1-48" for="chk1-48"><span class="label-item">48</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="49" id="chk1-49"/><span class="button-group-item check_" id="lblchk1-49" for="chk1-49"><span class="label-item">49</span></span>
																									</label>
																									<label>
																									  <input type="checkbox" name="chk1" value="50" id="chk1-50"/><span class="button-group-item check_" id="lblchk1-50" for="chk1-50"><span class="label-item">50</span></span>
																									</label>
																								</div>
																							</div>
																						</div>
																						<div class="footer-single-game">

																							<div class="footer-number">
																								<h5>Tus números son</h5>
																								<textarea class="current-numbers" id="txtchk1" readonly="readonly"></textarea>
																							</div>

																							<div class="row no-gutters">
																								<div class="col-6">
																									<div class="footer-single-left">
																										<button type="button" id="azarchk1" class="azar button button-block button-yellow button-sm button-no-shadow">Al Azar</button>
																									</div>
																								</div>
																								<div class="col-6">
																									<div class="footer-single-right">
																										<button type="button" id="clearchk1" class="clear button button-block button-yellow button-sm button-no-shadow">Limpiar</button>
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
															<div class="col-6">
																<div class="box-content-right">
																	<div class="box-content-top">
																		<h4>2: ELIGE TU COMBO</h4>
																	</div>
																	<div class="box-wrapper-game">

																		<div class="subscription-disabled subscription-disabled-sec2">

																			<div class="box-content-game">

																				<div class="boxes-periods number-textarea-button2">
																					<div class="box-period">
																						<label for="discount10" class="detail-period btn-discount10">
																							<div class="discount-period" onclick="datalayerFinalizaCompra1('8 SORTEOS: S/ 36.00','Elegir Combo');">
																							<!-- <a href="#" class="discount-period"> -->
<%-- 																								<input id="discount10" name="discount" type="radio" val="1" data-discount="${tinkaSale.firstDiscount}_${tinkaSale.firstMonths}_${tinkaSale.firstDraws}" /> --%>
																								<input id="inp_desktop_combo_8_sorteos_tinka" name="discount" type="radio" val="1" data-discount="${tinkaSale.firstDiscount}_${tinkaSale.firstMonths}_${tinkaSale.firstDraws}" />
																								<span>${tinkaSale.firstDraws} SORTEOS: S/ <label id="discounted10">27.20</label></span>
																							<!-- </a> -->
																							</div>
																							<!--  <div class="discount-mount">-15%</div> -->
																						</label>
																						<div class="descripction-period">
																							<!--  <p>Jugadas que participarán en ${tinkaSale.firstDraws} sorteos, que se llevarán a cabo dentro de dicho periodo.<br />Precio regular: S/ <label id="undiscounted10">32.00</label></p> -->
																							<p>Precio regular: S/ <label id="undiscounted10">32.00</label></p>
																						</div>
																					</div>
																					<div class="box-period">
																						<label for="discount20" class="detail-period btn-discount20">
																							<div class="discount-period" onclick="datalayerFinalizaCompra1('24 SORTEOS: S/ 96.00','Elegir Combo');">
<%-- 																								<input id="discount20" name="discount" type="radio" val="2" data-discount="${tinkaSale.secondDiscont}_${tinkaSale.secondMonths}_${tinkaSale.secondDraws}" /> --%>
																								<input id="inp_desktop_combo_24_sorteos_tinka" name="discount" type="radio" val="2" data-discount="${tinkaSale.secondDiscont}_${tinkaSale.secondMonths}_${tinkaSale.secondDraws}" />
																								<span>${tinkaSale.secondDraws} SORTEOS: S/ <label id="discounted20">72.60</label></span>
																							</div>
																							<!-- <div class="discount-mount">-25%</div> -->
																						</label>
																						<div class="descripction-period">
																							<!--  <p>Jugadas que participarán en ${tinkaSale.secondDraws} sorteos, que se llevarán a cabo dentro de dicho periodo.<br />Precio regular: S/ <label id="undiscounted20">96.00</label></p>-->
																							<p>Precio regular: S/ <label id="undiscounted20">96.00</label></p>
																						</div>
																					</div>
																					<div class="box-period">
																						<label for="discount30" class="detail-period btn-discount30">
																							<div class="discount-period" onclick="datalayerFinalizaCompra1('48 SORTEOS: S/ 168.00','Elegir Combo');">
<%-- 																								<input id="discount30" name="discount" type="radio" val="3" data-discount="${tinkaSale.tirdDiscount}_${tinkaSale.tirdMonths}_${tinkaSale.tirdDraws}" /> --%>
																								<input id="inp_desktop_combo_48_sorteos_tinka" name="discount" type="radio" val="3" data-discount="${tinkaSale.tirdDiscount}_${tinkaSale.tirdMonths}_${tinkaSale.tirdDraws}" />
																								<span>${tinkaSale.tirdDraws} SORTEOS: S/ <label id="discounted30">124.80</label></span>
																							</div>
																							<!-- <div class="discount-mount">-35%</div> -->
																						</label>
																						<div class="descripction-period">
																							<!-- <p>Jugadas que participarán en ${tinkaSale.tirdDraws} sorteos, que se llevarán a cabo dentro de dicho periodo.<br />Precio regular: S/ <label id="undiscounted30">192.00</label></p> -->
																							<p>Precio regular: S/ <label id="undiscounted30">192.00</label></p>
																						</div>
																					</div>
																					<div class="box-period">
																						<label for="discount40" class="detail-period btn-discount40">
																							<div class="discount-period" onclick="datalayerFinalizaCompra1('96 SORTEOS: S/ 288.00','Elegir Combo');">
																								<input id="inp_desktop_combo_96_sorteos_tinka" name="discount" type="radio" val="4" data-discount="${tinkaSale.fourthDiscount}_${tinkaSale.fourthMonths}_${tinkaSale.fourthDraws}" />
																								<span>${tinkaSale.fourthDraws} SORTEOS: S/ <label id="discounted40">0</label></span>
																							</div>
																							<!-- <div class="discount-mount">-35%</div> -->
																						</label>
																						<div class="descripction-period">
																							<!-- <p>Jugadas que participarán en ${tinkaSale.fourthDraws} sorteos, que se llevarán a cabo dentro de dicho periodo.<br />Precio regular: S/ <label id="undiscounted30">192.00</label></p> -->
																							<p>Precio regular: S/ <label id="undiscounted40">0.00</label></p>
																						</div>
																					</div>
																				</div>

																				<div class="preview-periods">
																					<p>*Las jugadas se generarán de manera automática y serán enviadas con los resultados de cada sorteo a tu correo registrado. También podrás revisarlas en tu Cuenta. <a href="#" onclick="openTyCWindow('<%=Constants.tinkaSuscriptionUrl%>'); return false;">Ver términos y condiciones aquí</a></p>
																				</div>

																				<div class="current-game-detail small-spacing">
																					<div class="main-box-detail">
																						<div class="main-single-detail">
																							<span class="detail-text">
																								Costo por jugada <span class="detail-value">S/ ${tinkaSale.simpleBetPrice}</span>
																							</span>
																						</div>
																						<div class="main-single-detail">
																							<span class="detail-text">
																								Jugadas <span class="detail-value" id="total-bets">0</span>
																							</span>
																						</div>
																						<div class="main-single-detail">
																							<span class="detail-text">
																								Descuento <span class="detail-value">% <span id="price-discount">0</span></span>
																							</span>
																						</div>
																						<div class="main-single-detail">
																							<span class="detail-text">
																								Costo total <span class="detail-value">S/ <b id="total-pay">0</b></span>
																							</span>
																						</div>
																					</div>
																					<div class="action-buy">
<!-- 																						<button type="button" id="buy-subscription" class="button button-lg button-no-shadow button-block button-orange"><b>COMPRAR</b></button> -->
																						<button type="button" id="btn_desktop_comprar_combo_tinkero" class="button button-lg button-no-shadow button-block button-orange"><b>COMPRAR</b></button>
																					</div>
																				</div>
																			</div>

																		</div>

																	</div>
																</div>
															</div>
														</div>
													</div>
												</form>
											</div>
										</div>
										<div class="finalize-subscribe-purchase disabled">

											<div class="box-wrapper-game">

												<div class="box-content-game">
													<div class="top-single-game">
														<!-- <h3>TINKA</h3> -->
													</div>
													<div class="body-single-game">
														<div class="row">
															<div class="col-6">
																
																<div class="left-panel">
																	<div id="content-subscribe-grid-result"></div>
																	<div id="num_subscribe_link"></div>
																</div>

															</div>
															<div class="col-6">
																<div class="detail-pay">
																	<h5>TOTAL <span class="label_2 detail-pay-date"></span></h5>
																</div>
																<div class="box-detail-pay">
																	<h4><span class="label_resu2_subscribe">Precio regular:</span><div class="text-detail-pay detail-pay-desc result2_subscribe"></div></h4>
																	<h4><span class="label_resu3_subscribe">Descuento de 0%</span><div class="text-detail-pay detail-pay-desc result3_subscribe"></div></h4>
																	<h4><b><span class="label_resu1_subscribe">TOTAL A PAGAR</span></b><div class="text-detail-pay detail-pay-desc result1_subscribe"></div></h4>
																	<h4><span class="label_resu4_subscribe"></span><div class="text-detail-pay detail-pay-desc result4_subscribe"></div></h4>
																</div>
																<div class="box-action-pay">
																	<div id="panel_keep-playing">
																		<a href="juega-tinka.html" id="subscribe_keep-playing" class="button button-lg button-no-shadow button-block button-orange">
																			<b>SEGUIR JUGANDO</b>
																		</a>
																	</div>
																	<div id="panel_game-history">
																		<a href="mi-cuenta.html#jugadas" id="subscribe_game-history" class="button button-lg button-no-shadow button-block button-dark-green">
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
<!-- 											            				<div id="separator_hr"></div> -->
<!-- 											            				<div class="top-saldo wb-saldo"></div> -->
<!-- 											            				<div id="pan_1"> -->
<!-- 											            					<div class="label2">RECARGAS POR INTERNET</div> -->
<!-- 											            					<table> -->
<%-- 											            						<c:forTokens var="channel1Order" items="${tinkaSale.channel1Order}" delims=","> --%>
<%-- 											            							<%@ include file="../../include/balance1.jspf"%> --%>
<%-- 											            						</c:forTokens> --%>
<!-- 											            					</table> -->
<!-- 											            					<div class="label2">RECARGAS F&Iacute;SICAS</div> -->
<!-- 											            					<table> -->
<%-- 											            						<c:forTokens var="channel2Order" items="${tinkaSale.channel2Order}" delims=","> --%>
<%-- 											            							<%@ include file="../../include/balance2.jspf"%> --%>
<%-- 											            						</c:forTokens> --%>
<!-- 											            					</table> -->
<!-- 											            				</div> -->
<!-- 											            				<div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div> -->
																	</div>
																</div>
											            	</form>
														</div>
														<div id="panel_finaliza_compra">
<!-- 															<a href="#" class="button button-dark-green" id='btn_finaliza_compra' onclick="return false;">FINALIZAR TU COMPRA</a> -->
															<a href="#" class="button button-dark-green button-red-new" id='btn_desktop_finalizar_compra_combo_tinkero' onclick="return false;">FINALIZAR TU COMPRA</a>
														</div>

														<div class="clearfix"></div>	

													    <div id="block-subscription" class="disabled">
														    <div id="ico-title">¡SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
														    <div id="ico-panel" class="clearfix">
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
		        								<iframe width="100%" height="125px" src="<%=ConnectionFactory.operationProperty("iflexTinkaYoutubeUrl", Constants.contextSale).trim()%>" frameborder="0" allowfullscreen></iframe>
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
	
<!--  <a onclick="openPreviewWindow_tinka();">popup2TINKA</a> -->
    <script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='layer-view-script/common/jquery.scripts.js'></script>
    <script type='text/javascript' src='layer-view-script/game/tinka/lotto-tinka-subscription.js?v=17'></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js?v=3'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<%@ include file="../../include/footer.jspf" %>
    <script type="text/javascript">

    	$(document).ready(function(){

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

    	$('#tab-item_4').on('click', function (event) {
    		datalayerFinalizaCompra2(this,'Cargar Saldo');
        });

    	$('#subscribe_keep-playing').on('click', function (event) {
    		datalayerGraciasCompra('SEGUIR JUGANDO','Seguir jugando');
        });

    	$('#subscribe_game-history').on('click', function (event) {
    		datalayerGraciasCompra('IR A MIS JUGADAS','ir a mis jugadas');
        });

    	$("#btn_desktop_home_raspaya , #btn_desktop_home_casino , #btn_desktop_home_kinelo , #btn_desktop_home_tinka, #btn_desktop_home_teapuesto, #btn_desktop_home_ddvv, #btn_desktop_home_kabala, #btn_desktop_home_ganagol , #btn_desktop_home_ganadiario").on('click',function(){
    		var textoAlt = $(this).children("img").attr('alt');
        	datalayerGraciasCompra(textoAlt,'Seguir jugando');
        });
        

    </script>



	

</body>
</html>