<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
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
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	    <title>Juega Kinelo: Gana cada 5 minutos</title>
    <meta name='description' content="Juega Kinelo en línea de forma sencilla y segura. Compra Kinelo en nuestra plataforma de forma totalmente online. ¡Premios cada 5 minutos!" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
	<link rel="stylesheet" href="layer-view-style/game/kinelo/estilos.css" type="text/css" />	
	
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	<script type="text/javascript" src="layer-view-script/funcionesTaggingKinelo.js?v=1"></script>  
	  
</head>
<body class="main-kinelo">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="main-section black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		<jsp:include page="../../include/header.jsp" />
		
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
		    <input type="hidden" value="${kineloSale.algorithm}" id="algorithm">
		    <input type="hidden" value="${kineloSale.bets}" id="bets">
		    <input type="hidden" value="${kineloSale.pay}" id="pay">
		    <input type="hidden" value="${kineloSale.draws}" id="draws">
		    <input type="hidden" value="${kineloSale.cost}" id="cost">
		    <input type="hidden" value="${gameKineloA}" id="gameKineloA">
		    <input type="hidden" value="${gameKineloB}" id="gameKineloB">
		   	<input type="hidden" value="${yourBetA}" id="yourBetA">
			<input type="hidden" value="${yourBetB}" id="yourBetB">
			<input type="hidden" value="${multiplierBetA}" id="multiplierBetA">
			<input type="hidden" value="${multiplierBetB}" id="multiplierBetB">
			<input type="hidden" value="${idTypePlay}" id="idTypePlay">
			<input type="hidden" value="${typePlay}" id="typePlay">
			<input type="hidden" value="bet" id="view">
			
			<input type="hidden" value="Loterías" id="TipoZona">
			<input type="hidden" value="Kinelo" id="Zona">
			<input type="hidden" value="" id="SubZona">
	</div>
	<div class="black-menu content-wrap">
			<div class="content">
				<div class="logo-brand" style="padding-top: 52px">
					<a href="game_kinelo_show_home_direct.html">
					<img src="layer-view-image/game/kinelo/logo-kinelo.png" alt="">
					</a>
				</div>
				<div id="${idTypePlay}" class="plays">
					<h1 class="titular">jugada ${typePlay}</h1>
					<div class="box_five">
						<div class="boxtitle">
							¿CUÁNTOS NÚMEROS QUIERES ACERTAR?
						</div>
						<div class="numbers" <c:if test="${kineloSale.status != 'ACT'}">style='pointer-events:none;'</c:if>>  
							<ul id="list_movil_jugadaA_compra_kinelo" class="list-ball-large">
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_1" value="1">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_1" for="${idTypePlay}YBAcheck_1">
					                     	<span class="label-item">1</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_2" value="2">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_2" for="${idTypePlay}YBAcheck_2">
					                     	<span class="label-item">2</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_3" value="3">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_3" for="${idTypePlay}YBAcheck_3">
					                     	<span class="label-item">3</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_4" value="4">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_4" for="${idTypePlay}YBAcheck_4">
					                     	<span class="label-item">4</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_5" value="5">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_5" for="${idTypePlay}YBAcheck_5">
					                     	<span class="label-item">5</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_6" value="6">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_6" for="${idTypePlay}YBAcheck_6">
					                     	<span class="label-item">6</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_7" value="7">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_7" for="${idTypePlay}YBAcheck_7">
					                     	<span class="label-item">7</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_8" value="8">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_8" for="${idTypePlay}YBAcheck_8">
					                     	<span class="label-item">8</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_9" value="9">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_9" for="${idTypePlay}YBAcheck_9">
					                     	<span class="label-item">9</span>
					                     </span>
			                        </label>
								</li>
								<li>
									<label>
					                     <input class="checkYBA" type="checkbox" id="${idTypePlay}YBAcheck_10" value="10">
					                     <span class="ball_st ball_large LcheckYBA" id="L${idTypePlay}YBAcheck_10" for="${idTypePlay}YBAcheck_10">
					                     	<span class="label-item">10</span>
					                     </span>
			                        </label>
								</li>
							</ul>
							
						</div>
						<div class="fix"></div>
					</div>
					<div class="box_five bg-blue">
						<div class="boxtitle">
							ELIGE TUS NÚMEROS
						</div>
						<div class="numbers" <c:if test="${kineloSale.status != 'ACT'}">style='pointer-events:none;'</c:if>>
							<ul id="elige-numero" class="list-ball-large big">
								<li>
									<label>
										<input class="check" type="checkbox" value="1" id="${idTypePlay}check_1">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_1" for="${idTypePlay}check_1">
											<span class="label-item">1</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="2" id="${idTypePlay}check_2">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_2" for="${idTypePlay}check_2">
											<span class="label-item">2</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="3" id="${idTypePlay}check_3">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_3" for="${idTypePlay}check_3">
											<span class="label-item">3</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="4" id="${idTypePlay}check_4">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_4" for="${idTypePlay}check_4">
											<span class="label-item">4</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="5" id="${idTypePlay}check_5">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_5" for="${idTypePlay}check_5">
											<span class="label-item">5</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="6" id="${idTypePlay}check_6">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_6" for="${idTypePlay}check_6">
											<span class="label-item">6</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="7" id="${idTypePlay}check_7">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_7" for="${idTypePlay}check_7">
											<span class="label-item">7</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="8" id="${idTypePlay}check_8">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_8" for="${idTypePlay}check_8">
											<span class="label-item">8</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="9" id="${idTypePlay}check_9">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_9" for="${idTypePlay}check_9">
											<span class="label-item">9</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="10" id="${idTypePlay}check_10">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_10" for="${idTypePlay}check_10">
											<span class="label-item">10</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="11" id="${idTypePlay}check_11">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_11" for="${idTypePlay}check_11">
											<span class="label-item">11</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="12" id="${idTypePlay}check_12">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_12" for="${idTypePlay}check_12">
											<span class="label-item">12</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="13" id="${idTypePlay}check_13">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_13" for="${idTypePlay}check_13">
											<span class="label-item">13</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="14" id="${idTypePlay}check_14">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_14" for="${idTypePlay}check_14">
											<span class="label-item">14</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="15" id="${idTypePlay}check_15">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_15" for="${idTypePlay}check_15">
											<span class="label-item">15</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="16" id="${idTypePlay}check_16">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_16" for="${idTypePlay}check_16">
											<span class="label-item">16</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="17" id="${idTypePlay}check_17">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_17" for="${idTypePlay}check_17">
											<span class="label-item">17</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="18" id="${idTypePlay}check_18">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_18" for="${idTypePlay}check_18">
											<span class="label-item">18</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="19" id="${idTypePlay}check_19">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_19" for="${idTypePlay}check_19">
											<span class="label-item">19</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="20" id="${idTypePlay}check_20">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_20" for="${idTypePlay}check_20">
											<span class="label-item">20</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="21" id="${idTypePlay}check_21">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_21" for="${idTypePlay}check_21">
											<span class="label-item">21</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="22" id="${idTypePlay}check_22">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_22" for="${idTypePlay}check_22">
											<span class="label-item">22</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="23" id="${idTypePlay}check_23">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_23" for="${idTypePlay}check_23">
											<span class="label-item">23</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="24" id="${idTypePlay}check_24">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_24" for="${idTypePlay}check_24">
											<span class="label-item">24</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="25" id="${idTypePlay}check_25">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_25" for="${idTypePlay}check_25">
											<span class="label-item">25</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="26" id="${idTypePlay}check_26">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_26" for="${idTypePlay}check_26">
											<span class="label-item">26</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="27" id="${idTypePlay}check_27">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_27" for="${idTypePlay}check_27">
											<span class="label-item">27</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="28" id="${idTypePlay}check_28">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_28" for="${idTypePlay}check_28">
											<span class="label-item">28</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="29" id="${idTypePlay}check_29">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_29" for="${idTypePlay}check_29">
											<span class="label-item">29</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="30" id="${idTypePlay}check_30">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_30" for="${idTypePlay}check_30">
											<span class="label-item">30</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="31" id="${idTypePlay}check_31">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_31" for="${idTypePlay}check_31">
											<span class="label-item">31</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="32" id="${idTypePlay}check_32">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_32" for="${idTypePlay}check_32">
											<span class="label-item">32</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="33" id="${idTypePlay}check_33">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_33" for="${idTypePlay}check_33">
											<span class="label-item">33</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="34" id="${idTypePlay}check_34">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_34" for="${idTypePlay}check_34">
											<span class="label-item">34</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="35" id="${idTypePlay}check_35">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_35" for="${idTypePlay}check_35">
											<span class="label-item">35</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="36" id="${idTypePlay}check_36">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_36" for="${idTypePlay}check_36">
											<span class="label-item">36</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="37" id="${idTypePlay}check_37">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_37" for="${idTypePlay}check_37">
											<span class="label-item">37</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="38" id="${idTypePlay}check_38">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_38" for="${idTypePlay}check_38">
											<span class="label-item">38</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="39" id="${idTypePlay}check_39">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_39" for="${idTypePlay}check_39">
											<span class="label-item">39</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="40" id="${idTypePlay}check_40">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_40" for="${idTypePlay}check_40">
											<span class="label-item">40</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="41" id="${idTypePlay}check_41">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_41" for="${idTypePlay}check_41">
											<span class="label-item">41</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="42" id="${idTypePlay}check_42">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_42" for="${idTypePlay}check_42">
											<span class="label-item">42</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="43" id="${idTypePlay}check_43">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_43" for="${idTypePlay}check_43">
											<span class="label-item">43</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="44" id="${idTypePlay}check_44">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_44" for="${idTypePlay}check_44">
											<span class="label-item">44</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="45" id="${idTypePlay}check_45">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_45" for="${idTypePlay}check_45">
											<span class="label-item">45</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="46" id="${idTypePlay}check_46">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_46" for="${idTypePlay}check_46">
											<span class="label-item">46</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="47" id="${idTypePlay}check_47">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_47" for="${idTypePlay}check_47">
											<span class="label-item">47</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="48" id="${idTypePlay}check_48">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_48" for="${idTypePlay}check_48">
											<span class="label-item">48</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="49" id="${idTypePlay}check_49">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_49" for="${idTypePlay}check_49">
											<span class="label-item">49</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="50" id="${idTypePlay}check_50">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_50" for="${idTypePlay}check_50">
											<span class="label-item">50</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="51" id="${idTypePlay}check_51">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_51" for="${idTypePlay}check_51">
											<span class="label-item">51</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="52" id="${idTypePlay}check_52">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_52" for="${idTypePlay}check_52">
											<span class="label-item">52</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="53" id="${idTypePlay}check_53">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_53" for="${idTypePlay}check_53">
											<span class="label-item">53</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="54" id="${idTypePlay}check_54">
										<span class="ball_st ball_small  check_" id="L${idTypePlay}check_54" for="${idTypePlay}check_54">
											<span class="label-item">54</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="55" id="${idTypePlay}check_55">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_55" for="${idTypePlay}check_55">
											<span class="label-item">55</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="56" id="${idTypePlay}check_56">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_56" for="${idTypePlay}check_56">
											<span class="label-item">56</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="57" id="${idTypePlay}check_57">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_57" for="${idTypePlay}check_57">
											<span class="label-item">57</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="58" id="${idTypePlay}check_58">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_58" for="${idTypePlay}check_58">
											<span class="label-item">58</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="59" id="${idTypePlay}check_59">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_59" for="${idTypePlay}check_59">
											<span class="label-item">59</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="60" id="${idTypePlay}check_60">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_60" for="${idTypePlay}check_60">
											<span class="label-item">60</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="61" id="${idTypePlay}check_61">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_61" for="${idTypePlay}check_61">
											<span class="label-item">61</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="62" id="${idTypePlay}check_62">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_62" for="${idTypePlay}check_62">
											<span class="label-item">62</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="63" id="${idTypePlay}check_63">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_63" for="${idTypePlay}check_63">
											<span class="label-item">63</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="64" id="${idTypePlay}check_64">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_64" for="${idTypePlay}check_64">
											<span class="label-item">64</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="65" id="${idTypePlay}check_65">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_65" for="${idTypePlay}check_65">
											<span class="label-item">65</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="66" id="${idTypePlay}check_66">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_66" for="${idTypePlay}check_66">
											<span class="label-item">66</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="67" id="${idTypePlay}check_67">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_67" for="${idTypePlay}check_67">
											<span class="label-item">67</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="68" id="${idTypePlay}check_68">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_68" for="${idTypePlay}check_68">
											<span class="label-item">68</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="69" id="${idTypePlay}check_69">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_69" for="${idTypePlay}check_69">
											<span class="label-item">69</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="70" id="${idTypePlay}check_70">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_70" for="${idTypePlay}check_70">
											<span class="label-item">70</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="71" id="${idTypePlay}check_71">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_71" for="${idTypePlay}check_71">
											<span class="label-item">71</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="72" id="${idTypePlay}check_72">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_72" for="${idTypePlay}check_72">
											<span class="label-item">72</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="73" id="${idTypePlay}check_73">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_73" for="${idTypePlay}check_73">
											<span class="label-item">73</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="74" id="${idTypePlay}check_74">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_74" for="${idTypePlay}check_74">
											<span class="label-item">74</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="75" id="${idTypePlay}check_75">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_75" for="${idTypePlay}check_75">
											<span class="label-item">75</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="76" id="${idTypePlay}check_76">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_76" for="${idTypePlay}check_76">
											<span class="label-item">76</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="77" id="${idTypePlay}check_77">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_77" for="${idTypePlay}check_77">
											<span class="label-item">77</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="78" id="${idTypePlay}check_78">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_78" for="${idTypePlay}check_78">
											<span class="label-item">78</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="79" id="${idTypePlay}check_79">
										<span class="ball_st ball_small mg-lf check_" id="L${idTypePlay}check_79" for="${idTypePlay}check_79">
											<span class="label-item">79</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="check" type="checkbox" value="80" id="${idTypePlay}check_80">
										<span class="ball_st ball_small check_" id="L${idTypePlay}check_80" for="${idTypePlay}check_80">
											<span class="label-item">80</span>
										</span>
									</label>
								</li>
			
							</ul>
							<div class="botones">
								<div>
									<a id="${idTypePlay}random" class="random_btn random">
										azar
									</a>
								</div>
								<div>
									<a id="${idTypePlay}clear"  class="limpiar clear">
										limpiar
									</a>
								</div>
							</div>
						</div>
						<div class="fix"></div>
					</div>
					<div class="box_five">
						<div class="boxtitle">
							MULTIPLICA TU PREMIO POR:(OPCIONAL)
						</div>
						<div class="numbers" <c:if test="${kineloSale.status != 'ACT'}">style='pointer-events:none;'</c:if>>
							<ul id="list_movil_jugadaA_compra_kinelo" class="list-ball-large">
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_1" value="1">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_1" for="${idTypePlay}YBBcheck_1">
											<span class="label-item">1</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_2" value="2">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_2" for="${idTypePlay}YBBcheck_2">
											<span class="label-item">2</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_3" value="3">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_3" for="${idTypePlay}YBBcheck_3">
											<span class="label-item">3</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_4" value="4">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_4" for="${idTypePlay}YBBcheck_4">
											<span class="label-item">4</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_5" value="5">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_5" for="${idTypePlay}YBBcheck_5">
											<span class="label-item">5</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_10" value="10">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_10" for="${idTypePlay}YBBcheck_10">
											<span class="label-item">10</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_20" value="20">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_20" for="${idTypePlay}YBBcheck_20">
											<span class="label-item">20</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_30" value="30">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_30" for="${idTypePlay}YBBcheck_30">
											<span class="label-item">30</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_40" value="40">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_40" for="${idTypePlay}YBBcheck_40">
											<span class="label-item">40</span>
										</span>
									</label>
								</li>
								<li>
									<label>
										<input class="checkYBB" type="checkbox" id="${idTypePlay}YBBcheck_50" value="50">
										<span class="ball_st ball_large LcheckYBB" id="L${idTypePlay}YBBcheck_50" for="${idTypePlay}YBBcheck_50">
											<span class="label-item">50</span>
										</span>
									</label>
								</li>
							</ul>
							
						</div>
						<div class="fix"></div>
					</div>

				</div>
<!-- 				<br><button type="button" class="btn btn-red" id="btn_mobile_agregar_boleto_kinelo">SIGUIENTE</button> -->
				<div class="espacio">
					
				</div>
					<button type="button" class="btn btn-red float-bottom" id="btn_mobile_agregar_boleto_kinelo">SIGUIENTE</button>
			</div>
		
	</div>
	
	<div style="display:none" class="f_error_mensaje">
	    <span class="close_f"></span>
		<div id="f_textoInterno" class="f_textoInterno"></div>
	</div>
	<jsp:include page="../../include/footer.jsp" />
	<script src="layer-view-script/jquery-3.6.3.min.js"></script>
	<script src="layer-view-script/kinelo/lotto-kinelo.js?v=2"></script>
	<script type="text/javascript">
		$(document).ready(function () {
			taggingJuegaKinelo();
		});
	</script>
</body>
</html>