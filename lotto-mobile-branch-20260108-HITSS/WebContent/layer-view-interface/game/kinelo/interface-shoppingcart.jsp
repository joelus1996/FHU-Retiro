<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
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
	<script type="application/ld+json">
	{
  		"@context": "https://schema.org/",
  		"@type": "BreadcrumbList",
  		"itemListElement": [{
    		"@type": "ListItem",
    		"position": 1,
    		"name": "La Tinka",
    		"item": "https://m.latinka.com.pe/" 
  		},{
    		"@type": "ListItem",
    		"position": 2,
    		"name": "Jugar Kinelo",
    		"item": "https://m.latinka.com.pe/game_kinelo_show_home.html" 
  		}]
	}
	</script>	
	<meta property="og:title" content="Kinelo: Juegos de Lotería Online | La Tinka">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://m.latinka.com.pe/game_raspaya_show_home.html">
	<meta property="og:description" content="¿Cómo se juega Kinelo? Es un juego de lotería online donde puedes apostar y ganar cada 5 minutos. ¡Entra ahora y empieza a jugar!">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-kinelo.png">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	    <title>Kinelo: Juego de apuesta más popular en Lima, Perú - La Tinka</title>
    <meta name='description' content="El Kinelo es un juego de apuestas a la medida con 10 tipos de apuestas de diferentes premios mayores. Gana cada 5 minutos y multiplica tu apuesta." />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

	<link rel="stylesheet" href="layer-view-style/game/kinelo/estilos.css" type="text/css" />	
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	 <script type="text/javascript" src="layer-view-script/funcionesTaggingKinelo.js?v=1"></script>  
	
	<%
	String totl_aux=request.getParameter("total_apagar2");
	
	
	%>
	
</head>
<body class="main-kinelo">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
 
	<div class="main-section black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		<jsp:include page="../../include/header.jsp" />
		<input type="hidden" value="${kineloSale.simpleBetPrice}" id="simpleBetPrice">
	    <input type="hidden" value="${gameKineloA}" id="gameKineloA">
		<input type="hidden" value="${gameKineloB}" id="gameKineloB">
		<input type="hidden" value="${multiplierBetA}" id="multiplierBetA">
		<input type="hidden" value="${multiplierBetB}" id="multiplierBetB">
		<input type="hidden" value="${num_draw}" id="num_draw">
		<input type="hidden" value="${yourBetA}" id="yourBetA">
		<input type="hidden" value="${yourBetB}" id="yourBetB">
		<input type="hidden" value="shoppingcart" id="view">
		<input type="hidden" value="${kineloSale.balanceQuantityGame}" id="quantityGame">
		
		<input type="hidden" id="operation" value="${operation}"/>
		<input type="hidden" value="${lastPlay}" id="lastPlay">
		<input type="hidden" value="${lastDelete}" id="lastDelete">
		<input type="hidden" value="${remove_num_draw}" id="remove_num_draw">
			
		<input type="hidden" value="Loterías" id="TipoZona">
		<input type="hidden" value="Kinelo" id="Zona">
		<input type="hidden" value="" id="SubZona">
			
<%-- 			<input type="hidden"  id="precioAnterior" value ="<%=totl_aux%>" > --%>
<%-- 			<input type="hidden"  id="precioAntes" value ="${precioAntes}" > --%>
<!-- 			<input type="hidden"  id=precioDes  > -->
			
		
	</div>
	<div class="black-menu content-wrap" >
		<div class="content" style="padding-top: 0px;">
			<div class="logo-brand">
				<img src="layer-view-image/game/kinelo/logo-kinelo.png" alt="">
			</div>
			<h1 class="titular">Mi boleto</h1>
			<h2></h2>
			<div class="boxes-game-ticket">
				<div class="box-game-ticket">
					<div class="my-games">
						<div class="my-game">
							<c:if test="${!empty gameKineloA}">
								<div class="number-game">
									<div class="boxtitle add-size" style="font-size: 22px !important;">
										Jugada A
									</div>
								</div>
								<div id="resultsview1" class="results-balls playing clearfix">
									<c:forEach var="item" items="${gameKineloA}">
										<div class="result-ball">
											<span class="ball_st ball_large">
							                    <span class="label-item">${item}</span>
							                </span>
										</div>
									</c:forEach>
								</div>
								<div class="game-options delete">
									<a id="btn_mobile_eliminar_boleto_a" class="game-option ico  ico-close" style="cursor: pointer;">
										<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
											<title>delete</title>
											<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
										</svg> 
										<span style="font-family: AllerRegular, Arial, sans-serif;">Eliminar</span>
									</a>
									<a id="btn_mobile_editar_boleto_a" class="game-option ico ico-edit" style="cursor: pointer;">
	 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
	 		   								<title>edit</title>
	 		   								<path d="M432 0c44.182 0 80 35.817 80 80 0 18.010-5.955 34.629-16 48l-32 32-112-112 32-32c13.371-10.045 29.989-16 48-16zM32 368l-32 144 144-32 296-296-112-112-296 296zM357.789 181.789l-224 224-27.578-27.578 224-224 27.578 27.578z"></path>
	 		   							</svg> 
	 		   							<span style="font-family: AllerRegular, Arial, sans-serif;">Editar</span>
					 		   		</a>
								</div>
							</c:if>
						</div>
						<div class="my-game">
							<c:if test="${!empty gameKineloB}">
								<div class="number-game">
									<div class="boxtitle add-size" style="font-size: 22px !important;">
										Jugada B
									</div>
								</div>
								<div id="resultsview1" class="results-balls playing clearfix">
									<c:forEach var="item" items="${gameKineloB}">
										<div class="result-ball">
											<span class="ball_st ball_large">
							                    <span class="label-item">${item}</span>
							                </span>
										</div>
									</c:forEach>
								</div>
								<div class="game-options delete">
									<a id="btn_mobile_eliminar_boleto_b" class="game-option ico ico-close" style="cursor: pointer;">
										<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
											<title>delete</title>
											<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
										</svg> 
										<span style="font-family: AllerRegular, Arial, sans-serif;">Eliminar</span>
									</a>
									<a id="btn_mobile_editar_boleto_b" class="game-option ico ico-edit" style="cursor: pointer;">
	 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
	 		   								<title>edit</title>
	 		   								<path d="M432 0c44.182 0 80 35.817 80 80 0 18.010-5.955 34.629-16 48l-32 32-112-112 32-32c13.371-10.045 29.989-16 48-16zM32 368l-32 144 144-32 296-296-112-112-296 296zM357.789 181.789l-224 224-27.578-27.578 224-224 27.578 27.578z"></path>
	 		   							</svg> 
	 		   							<span style="font-family: AllerRegular, Arial, sans-serif;">Editar</span>
					 		   		</a>
								</div>
							</c:if>
						</div>
						<hr>
					</div>
				</div>
				<div class="box-game-ticket">
				    <c:if test="${(empty gameKineloA) || (empty gameKineloB)}">
				    	<div class="title-game-ticket">
							<div class="title-game-ticket">
								¿Agregar más jugadas?
							</div>
						</div>
				    </c:if>
					
					<c:if test="${empty gameKineloA}">
						<div class="game-actions">
							<a id="btn_mobile_jugar_ahora_kinelo_a" class="btns trans" style="box-shadow: none !important;">Jugada A</a>
						</div>
					</c:if>
					
					<c:if test="${empty gameKineloB}">
						<div class="game-actions">
							<a id="btn_mobile_jugar_ahora_kinelo_b" class="btns trans" style="box-shadow: none !important;">Jugada B</a>
						</div>
					</c:if>
					<c:if test="${(empty gameKineloA) || (empty gameKineloB)}">
						<hr class="blue">
					</c:if>
				</div>
				<div class="box-game-ticket">
					<div class="title-game-ticket">
					<h4 style="margin-right: 27px;margin-left: 27px;">¿PARA CUÁNTOS SORTEOS QUIERES JUGAR? </h4>
					</div>
					<div class="game-actions">
						<c:if test="${empty num_draw}">
							<a onclick="datalayerMisJugadas('AGREGAR SORTEOS','Mi Boleto','Jugar','Button');window.location.href='game_kinelo_show_consecutive.html';" class="btns">agregar sorteos</a>
						</c:if>
						<c:if test="${!empty num_draw}">
							<a id="btn_kinelo_delete_consecutive" class="btns">QUITAR SORTEOS CONSECUTIVOS</a>
						</c:if>
					</div>
					<hr class="blue" style="margin-bottom: 0px">
				</div>
			</div>
			<div class="footer-game-tikect">
				<c:if test="${kineloSale.balanceQuantityGame > 0}" >
					<div class="info">
						<div><span>Jugadas gratis*:</span></div>
						<div><span class="detail-value" id="jugadas-gratis">${kineloSale.balanceQuantityGame}</span></div>
						<input type="hidden"  id="jugadasGratis" value="${kineloSale.balanceQuantityGame}" >	
						<div class="fix"></div>
					</div>					
				</c:if>
				<c:if test="${kineloSale.balanceQuantityGame == 0}" >
					  <div class="content-game-ticket">
						<div class="info">
						<div style="margin-top: 8px;"><span>Costo por jugada:</span></div>
						<div style="margin-top: 8px;"><span class="detail-value" id="price-message">S/ </span></div>
						<div class="fix"></div>
					   </div>
					</div>	
				</c:if>			
				<div class="info" style="margin-top: 10px;">
					<div><span>Total de apuestas:</span></div>
					<div><span class="detail-value" id="total_bet"></span></div>
					<input type="hidden"  id="total_bet2" >
					<div class="fix"></div>
				</div>
				<div class="info">
					<div><span>Gana hasta:</span></div>
					<div><span>S/ <span id="earn_up"></span></span></div>
					<div class="fix"></div>
				</div>
				<c:if test="${(num_draw)>1}">
				<div class="field-ticket" style="text-align:center;">Consecutivo de ${num_draw}</div>
				 </c:if>
				<div class="info" style="margin-button: 30px;">
					<div><span>Costo total:</span></div>
					<div><span>S/ <span id="total_apagar"></span></span></div>
					<input type="hidden"  id="total_apagar2" >	
					<input type="hidden"  id="jugadaA" >	
					<input type="hidden"  id="jugadaB" >					
					<div class="fix"></div>
				</div>
				</div>
			</div>	
			<br/>
			<div class="field-ticket2" style="margin-right: 25px;margin-left: 25px;margin-top: 60px;"><p>* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto</p></div>	
				
			<div style="margin-top: 30px;"></div>		
			<c:if test="${!empty clientId}">
<!-- 				<p align="center"><button type="button" style="width: 76%;" class="btn btn-red" id="btn_mobile_comprar_boleto_kinelo">COMPRAR</button></p> -->
				<button type="button" class="btn btn-red float-bottom" id="btn_mobile_comprar_boleto_kinelo">COMPRAR</button>
			</c:if>
			<c:if test="${empty clientId}">
<!-- 				<p align="center"><button type="button" style="width: 76%;" class="btn btn-red" id="security_login_execute_authentication_kinelo">COMPRAR</button></p> -->
				<button type="button" class="btn btn-red float-bottom" id="security_login_execute_authentication_kinelo">COMPRAR</button>
			</c:if>
			<div style="margin-top: 80px;"></div>
		</div>
	</div>
	<jsp:include page="../../include/footer.jsp" />
	<!-- <script src="layer-view-script/kinelo/jquery.min.js"></script> -->
	<script src="layer-view-script/kinelo/lotto-kinelo.js?v=2"></script>
	<script type="text/javascript">
	$(document).ready(function(){
		funcionesTagging();
	});
	</script>

</body>
</html>