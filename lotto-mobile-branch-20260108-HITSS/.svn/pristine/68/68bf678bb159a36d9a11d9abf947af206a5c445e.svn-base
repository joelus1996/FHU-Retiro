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
	<title>Ganagol : Boleto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Ganagol móvil, boleto de jugada realizada" />
	<link rel="stylesheet" href="layer-view-style/game/ganagol/styles-ganagol.css?v=5" type="text/css" />
	
	<!-- Tagging GTM eventos -->
	<script type="text/javascript" src="layer-view-script/funcionesTaggingGanagol.js"></script>	
	
</head>
<body class="main-ganagol">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<input type="hidden" id="operation" value="${operation}"/>
	<input type="hidden" id="lastPrice" value="${lastPrice}"/>
	<input type="hidden" id="importePagar" value="${totalGanagol}"/> 
	<input type="hidden" id="costoTotalBet" value="${costoTotalBet}"/>
	<input type="hidden" id="ganagolTotal" value="${ganagolTotal}"/>
	<input type="hidden" id="jugadasGratis" value="${jugadasGratis}"/>
	<input type="hidden" id="numberPlay" value="${numberPlay}"/>
	<input type="hidden" id="simpleBetPrice" value="${simpleBetPrice}"/>

	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
	<input type="hidden" value="Apuestas Deportivas" id="TipoZona">
	<input type="hidden" value="Gana Gol" id="Zona">
	<input type="hidden" value="" id="SubZona">
	
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game padding1">
					
						<a href="#" id="game_ganagol_show_menu">
							<img src="layer-view-image/v2/logo-ganagol.png" alt="tinka" class="cropimg">
						</a>

						<div class="game-desc golazo200">
							<h2>MI BOLETO</h2>
						</div>
						
						<div class="boxes-game-ticket">
							<div class="box-game-ticket">
								<div class="my-games">

							   		<c:set var="jgda_A" value="false" />
					 		   		<c:set var="jgda_B" value="false" />
					 		   		<c:set var="jgda_C" value="false" />
					 		   		<c:set var="jgda_D" value="false" />

					 		   		<c:forEach var="item" items="${gameGanagolBoleto}">

					 		   			<c:if test="${item.key =='a'}">

					 		   				<c:set var="jgda_A" value="true" />

					 		   				<div class="my-game">
					 		   					<div class="number-game">
					 		   						<h3>Jugada A</h3>
					 		   					</div>
					 		   					<div class="results-games">
					 		   						<div class="result-title">
					 		   							
					 		   						</div>
					 		   						<div class="results-balls playing clearfix golazo200" hidden="">
					 		   							<c:forEach var="it" items="${item.value}" varStatus="loop">
					 		   								<c:if test="${loop.index <= 13}">					 		   								
						 		   								<div class="result-ball200">
						 		   									<div ><!--class="ball"-->
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>
						 		   							<c:if test="${loop.index == 14}">
						 		   								<br>					 		   								
						 		   								<div class="result-ball200">
						 		   									<div ><!--class="ball"-->
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>/ Golazo200</span>
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>						 		   								
					 		   							</c:forEach>
					 		   						</div>
					 		   						
				 		   							<c:forEach var="it" items="${item.value}" varStatus="loop">					 		   								
				 		   								<c:if test="${loop.index <= 13}">
					 		   							<span class="sp-resultados" hidden="">${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>						 		   									
					 		   							</c:if>				
					 		   							<c:if test="${loop.index == 14}">
					 		   							<span class="sp-resultado-g200" hidden="">Golazo 200:
					 		   										${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
					 		   							</c:if>						 		   													 		   								
				 		   							</c:forEach>					 		   								
					 		   						<br>
					 		   						<div class="contenedor">
								                		<div class="text2">
								                			<h4 class="trans-resultados" id="h4-resultados">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200" id="h4-resultado-g200">PROGRAMA</h4>
								                		</div>
								                		<div class="background2 trans">
								                		 	<h4 class="trans-resultados2" id="h4-resultados2">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200-2" id="h4-resultado-g200-2">PROGRAMA</h4>
								                		</div>	
								                	</div>		
								                		 		   						 		   											 		   						
					 		   					</div>
					 		   					<div class="game-options">
					 		   						<a href="#" class="game-option ico ico-close" onclick="window.location.href='game_ganagol_delete_bet.html?id=${item.key}';">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>delete</title>
					 		   								<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
					 		   							</svg> Eliminar
					 		   						</a>
					 		   						<a href="#" class="game-option ico ico-edit" id="btn_mobile_marcar_a_jugada_ganagol" onclick="marcarJugadaGanagol('a')" play="a">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>edit</title>
					 		   								<path d="M432 0c44.182 0 80 35.817 80 80 0 18.010-5.955 34.629-16 48l-32 32-112-112 32-32c13.371-10.045 29.989-16 48-16zM32 368l-32 144 144-32 296-296-112-112-296 296zM357.789 181.789l-224 224-27.578-27.578 224-224 27.578 27.578z"></path>
					 		   							</svg> Editar
					 		   						</a>
					 		   					</div>
					 		   					<div class="game-alert">
					 		   						<c:if test="${fn:length(item.value)<14}">
					 		   							<p>Debe completar la jugada</p>
					 		   						</c:if>
					 		   					</div>
					 		   				</div>

					 		   			</c:if>

					 		   			<c:if test="${item.key =='b'}">

					 		   				<c:set var="jgda_B" value="true" />

					 		   				<div class="my-game">
					 		   					<div class="number-game">
					 		   						<h3>Jugada B</h3>
					 		   					</div>
					 		   					<div class="results-games">
					 		   						<div class="result-title">
					 		   							
					 		   						</div>
					 		   						<div class="results-balls playing clearfix golazo200" hidden="">
					 		   							<c:forEach var="it" items="${item.value}" varStatus="loop">
					 		   								<c:if test="${loop.index <= 13}">					 		   								
						 		   								<div class="result-ball200">
						 		   									<div>
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>
						 		   							<c:if test="${loop.index == 14}">
						 		   								<br>					 		   								
						 		   								<div class="result-ball200">
						 		   									<div>
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>/ Golazo200</span>
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>		
					 		   							</c:forEach>
					 		   						</div>	
					 		   						
					 		   						<c:forEach var="it" items="${item.value}" varStatus="loop">					 		   								
				 		   								<c:if test="${loop.index <= 13}">
					 		   							<span class="sp-resultados-b" hidden="">${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>						 		   									
					 		   							</c:if>				
					 		   							<c:if test="${loop.index == 14}">
					 		   							<span class="sp-resultado-g200-b" hidden="">Golazo 200:
					 		   										${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
					 		   							</c:if>						 		   													 		   								
				 		   							</c:forEach>					 		   								
					 		   						<br>
					 		   						<div class="contenedor">
								                		<div class="text2">
								                			<h4 class="trans-resultados" id="h4-resultados-b">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200" id="h4-resultado-g200-b">PROGRAMA</h4>
								                		</div>
								                		<div class="background2 trans">
								                		 	<h4 class="trans-resultados2" id="h4-resultados2-b">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200-2" id="h4-resultado-g200-2-b">PROGRAMA</h4>
								                		</div>	
								                	</div>	
					 		   										 		   						
					 		   					</div>
					 		   					<div class="game-options">
					 		   						<a href="#" class="game-option ico ico-close" onclick="window.location.href='game_ganagol_delete_bet.html?id=${item.key}';">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>delete</title>
					 		   								<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
					 		   							</svg> Eliminar
					 		   						</a>
					 		   						<a href="#" class="game-option ico ico-edit" id="btn_mobile_marcar_b_jugada_ganagol" onclick="marcarJugadaGanagol('b')" play="b">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>edit</title>
					 		   								<path d="M432 0c44.182 0 80 35.817 80 80 0 18.010-5.955 34.629-16 48l-32 32-112-112 32-32c13.371-10.045 29.989-16 48-16zM32 368l-32 144 144-32 296-296-112-112-296 296zM357.789 181.789l-224 224-27.578-27.578 224-224 27.578 27.578z"></path>
					 		   							</svg> Editar
					 		   						</a>
					 		   					</div>
					 		   					<div class="game-alert">
					 		   						<c:if test="${fn:length(item.value)<14}">
					 		   							<p>Debe completar la jugada</p>
					 		   						</c:if>
					 		   					</div>
					 		   				</div>

					 		   			</c:if>

					 		   			<c:if test="${item.key =='c'}">

					 		   				<c:set var="jgda_C" value="true" />

					 		   				<div class="my-game">
					 		   					<div class="number-game">
					 		   						<h3>Jugada C</h3>
					 		   					</div>
					 		   					<div class="results-games">
					 		   						<div class="result-title">
					 		   							
					 		   						</div>
					 		   						<div class="results-balls playing clearfix golazo200" hidden="">
					 		   							<c:forEach var="it" items="${item.value}" varStatus="loop">
					 		   							<c:if test="${loop.index <= 13}">					 		   								
						 		   								<div class="result-ball200">
						 		   									<div>
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>
						 		   							<c:if test="${loop.index == 14}">
						 		   								<br>					 		   								
						 		   								<div class="result-ball200">
						 		   									<div>
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>/ Golazo200</span>
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>		
					 		   							</c:forEach>
					 		   						</div>	
					 		   						
					 		   						<c:forEach var="it" items="${item.value}" varStatus="loop">					 		   								
				 		   								<c:if test="${loop.index <= 13}">
					 		   							<span class="sp-resultados-c" hidden="">${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>						 		   									
					 		   							</c:if>				
					 		   							<c:if test="${loop.index == 14}">
					 		   							<span class="sp-resultado-g200-c" hidden="">Golazo 200:
					 		   										${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
					 		   							</c:if>						 		   													 		   								
				 		   							</c:forEach>					 		   								
					 		   						<br>
					 		   						<div class="contenedor">
								                		<div class="text2">
								                			<h4 class="trans-resultados" id="h4-resultados-c">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200" id="h4-resultado-g200-c">PROGRAMA</h4>
								                		</div>
								                		<div class="background2 trans">
								                		 	<h4 class="trans-resultados2" id="h4-resultados2-c">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200-2" id="h4-resultado-g200-2-c">PROGRAMA</h4>
								                		</div>	
								                	</div>	
					 		   										 		   						
					 		   					</div>
					 		   					<div class="game-options">
					 		   						<a href="#" class="game-option ico ico-close" onclick="window.location.href='game_ganagol_delete_bet.html?id=${item.key}';">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>delete</title>
					 		   								<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
					 		   							</svg> Eliminar
					 		   						</a>
					 		   						<a href="#" class="game-option ico ico-edit" id="btn_mobile_marcar_c_jugada_ganagol" onclick="marcarJugadaGanagol('c')" play="c">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>edit</title>
					 		   								<path d="M432 0c44.182 0 80 35.817 80 80 0 18.010-5.955 34.629-16 48l-32 32-112-112 32-32c13.371-10.045 29.989-16 48-16zM32 368l-32 144 144-32 296-296-112-112-296 296zM357.789 181.789l-224 224-27.578-27.578 224-224 27.578 27.578z"></path>
					 		   							</svg> Editar
					 		   						</a>
					 		   					</div>
					 		   					<div class="game-alert">
					 		   						<c:if test="${fn:length(item.value)<14}">
					 		   							<p>Debe completar la jugada</p>
					 		   						</c:if>
					 		   					</div>
					 		   				</div>

					 		   			</c:if>

					 		   			<c:if test="${item.key =='d'}">

					 		   				<c:set var="jgda_D" value="true" />

					 		   				<div class="my-game">
					 		   					<div class="number-game">
					 		   						<h3>Jugada D</h3>
					 		   					</div>
					 		   					<div class="results-games">
					 		   						<div class="result-title">
					 		   							
					 		   						</div>
					 		   						<div class="results-balls playing clearfix golazo200" hidden="">
					 		   							<c:forEach var="it" items="${item.value}" varStatus="loop">
					 		   							<c:if test="${loop.index <= 13}">					 		   								
						 		   								<div class="result-ball200">
						 		   									<div>
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>
						 		   							<c:if test="${loop.index == 14}">
						 		   								<br>					 		   								
						 		   								<div class="result-ball200">
						 		   									<div ><!--class="ball"-->
						 		   										<!-- ${fn:replace(it.key,'id_','')} -->
						 		   										<!-- <span>${it.value}</span> -->
						 		   										<span>/ Golazo200</span>
						 		   										<span>${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
						 		   									</div>
						 		   								</div>
						 		   							</c:if>		
					 		   							</c:forEach>
					 		   						</div>	
					 		   						
					 		   						<c:forEach var="it" items="${item.value}" varStatus="loop">					 		   								
				 		   								<c:if test="${loop.index <= 13}">
					 		   							<span class="sp-resultados-d" hidden="">${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>						 		   									
					 		   							</c:if>				
					 		   							<c:if test="${loop.index == 14}">
					 		   							<span class="sp-resultado-g200-d" hidden="">Golazo 200:
					 		   										${fn:replace(fn:replace(it.value,'[',''), ']', '')}</span>
					 		   							</c:if>						 		   													 		   								
				 		   							</c:forEach>					 		   								
					 		   						<br>
					 		   						<div class="contenedor">
								                		<div class="text2">
								                			<h4 class="trans-resultados" id="h4-resultados-d">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200" id="h4-resultado-g200-d">PROGRAMA</h4>
								                		</div>
								                		<div class="background2 trans">
								                		 	<h4 class="trans-resultados2" id="h4-resultados2-d">PROGRAMA</h4>
								                			<h4 class="trans-resultado-g200-2" id="h4-resultado-g200-2-d">PROGRAMA</h4>
								                		</div>	
								                	</div>
					 		   										 		   						
					 		   					</div>
					 		   					<div class="game-options">
					 		   						<a href="#" class="game-option ico ico-close" onclick="window.location.href='game_ganagol_delete_bet.html?id=${item.key}';">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>delete</title>
					 		   								<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
					 		   							</svg> Eliminar
					 		   						</a>
					 		   						<a href="#" class="game-option ico ico-edit" id="btn_mobile_marcar_d_jugada_ganagol" onclick="marcarJugadaGanagol('d')" play="d">
					 		   							<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
					 		   								<title>edit</title>
					 		   								<path d="M432 0c44.182 0 80 35.817 80 80 0 18.010-5.955 34.629-16 48l-32 32-112-112 32-32c13.371-10.045 29.989-16 48-16zM32 368l-32 144 144-32 296-296-112-112-296 296zM357.789 181.789l-224 224-27.578-27.578 224-224 27.578 27.578z"></path>
					 		   							</svg> Editar
					 		   						</a>
					 		   					</div>
					 		   					<div class="game-alert">
					 		   						<c:if test="${fn:length(item.value)<14}">
					 		   							<p>Debe completar la jugada</p>
					 		   						</c:if>
					 		   					</div>
					 		   				</div>

					 		   			</c:if>

					 		   		</c:forEach>
								</div>
							</div>

							<c:if test="${!jgda_A or !jgda_B or !jgda_C or !jgda_D}">

								<div class="box-game-ticket">
									<div class="title-game-ticket">
										<h3>¿AGREGAR MÁS JUGADAS?</h3>
									</div>
									<div class="game-actions">
										<c:if test="${!jgda_A}">
											<button id="btn_mobile_marcar_jugada_ganagol_a" onclick="datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');marcarJugadaGanagol('a')" play="a" type="button" class="btn btn-transparent">JUGADA A</button>
										</c:if>
										
										<c:if test="${!jgda_B}">
											<button id="btn_mobile_marcar_jugada_ganagol_b" onclick="datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');marcarJugadaGanagol('b')" play="b" type="button" class="btn btn-transparent">JUGADA B</button>
										</c:if>
										
										<c:if test="${!jgda_C}">
											<button id="btn_mobile_marcar_jugada_ganagol_c" onclick="datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');marcarJugadaGanagol('c')" play="c" type="button" class="btn btn-transparent">JUGADA C</button>
										</c:if>
										
										<c:if test="${!jgda_D}">
											<button id="btn_mobile_marcar_jugada_ganagol_d" onclick="datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');marcarJugadaGanagol('d')" play="d" type="button" class="btn btn-transparent">JUGADA D</button>
										</c:if>
									</div>
								</div>

							</c:if>

						</div>

						<div class="footer-game-tikect">
							<div class="content-game-ticket" style="margin-bottom: 100px;">
								<!-- Ruth inicio  -->

										<c:if test="${numberPlay == 0}" >										
										<c:if test="${fn:length(ganagolProcedureBetData.promotionMessage)>9}">
											<div class="field-ticket info-promotion">${ganagolProcedureBetData.promotionMessage}</div>
										</c:if>										
										<div class="field-ticket info"><div><span>Jugadas gratis:</span></div><div><span>${ganagolProcedureBetData.balanceQuantityGame}</span></div></div><!--bonoLoteria -->
										<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>S/.0</span></div></div><!-- precioJugada -->
										<div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>${numberPlay}</span></div></div><!-- totalBet_TK jugadas-->										
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>S/.0</span></div></div><!-- totalTinka_TK -->										
										</c:if> 

							   <c:if test="${numberPlay>0}">
							   
							        <c:if test="${(simpleBetPrice * (numberPlay + ganagolTotal*0.5))== costoTotalBet}" >
							        
							           <c:if test="${fn:length(ganagolProcedureBetData.promotionMessage)>9}">
											<div class="field-ticket info-promotion">${ganagolProcedureBetData.promotionMessage}</div><!-- priceMessage -->
										</c:if>
										<div class="field-ticket info"><div><span>Jugadas gratis:</span></div><div><span>${jugadasGratis}</span></div></div><!--bonoLoteria -->
										
<%-- 										<c:if test="${numberPlay+ganagolTotal*0.5<=jugadasGratis}"> --%>
<!-- 											<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>S/.0</span></div></div>precioJugada -->
<%-- 										</c:if> --%>
<%-- 										<c:if test="${numberPlay+ganagolTotal*0.5>jugadasGratis}"> --%>
<%-- 											<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${ganagolProcedureBetData.priceMessage}</span></div></div><!-- precioJugada --> --%>
<%-- 										</c:if> --%>
										
										<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${ganagolProcedureBetData.priceMessage}</span></div></div><!-- precioJugada -->

										<div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>${numberPlay}</span><span>GG</span><span>${numberGolazo200}</span></div></div><!-- totalBet_TK jugadas-->
										
										<c:if test="${numberPlay+ganagolTotal*0.5<=jugadasGratis}">
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>S/.0</span></div></div>
										</c:if>
										
										<c:if test="${numberPlay+ganagolTotal*0.5>jugadasGratis}">
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>${total}</span></div></div>
										</c:if>
										
						           </c:if>
						             
						              <c:if test="${(simpleBetPrice * (numberPlay + ganagolTotal*0.5))ne costoTotalBet}" >						              
						                <c:if test="${fn:length(ganagolProcedureBetData.promotionMessage)>9}">
											<div class="field-ticket info-promotion">${ganagolProcedureBetData.promotionMessage}</div><!-- priceMessage -->
										</c:if>
										<div class="field-ticket info"><div><span>Jugadas gratis:</span></div><div><span>${jugadasGratis}</span></div></div><!--bonoLoteria -->
										<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${ganagolProcedureBetData.priceMessage}</span></div></div><!-- precioJugada -->
										<div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>${numberPlay}</span><span>GG</span><span>${numberGolazo200}</span></div></div><!-- totalBet_TK jugadas-->
										<c:if test="${numberPlay+ganagolTotal*0.5>jugadasGratis}">
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>${total}</span></div></div><!-- totalTinka_TK -->
										</c:if>
										<c:if test="${numberPlay+ganagolTotal*0.5<=jugadasGratis}">
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>S/.0</span></div></div>
										</c:if>
						           </c:if>

								</c:if>

								<!-- Ruth Fin-->																
								<div class="field-ticket"><div class="alert">${alertNumberPlay}</div></div>
							</div>
							<div class="game-actions">

								<c:if test="${!empty clientId && agreement!=''}">
									<c:if test="${estado==yes && estado!='' && estado!=null}">
<!-- 										<button id="game_ganagol_play_bet_result" type="button" class="btn btn-red float-bottom">COMPRAR</button> -->
<!-- 										<button id="btn_mobile_comprar_ganagol" type="button" class="btn btn-red">COMPRAR</button> -->
										<button id="btn_mobile_comprar_ganagol" type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
									<c:if test="${estado==no && estado!='' && estado!=null}">
<!-- 										<button id="btn_mobile_comprar_ganagol_no" type="button" class="btn btn-red">COMPRAR</button> -->
										<button id="btn_mobile_comprar_ganagol_no" type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
									<c:if test="${empty estado}">
<!-- 										<button id="btn_mobile_comprar_ganagol_empty" type="button" class="btn btn-red">COMPRAR</button> -->
										<button id="btn_mobile_comprar_ganagol_empty" type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
								</c:if>

								<c:if test="${empty clientId or agreement==''}">
									<c:if test="${estado==yes && estado!='' && estado!=null}">
<!-- 										<button id="security_login_execute_authentication_ganagol" type="button" class="btn btn-red">COMPRAR</button> -->
										<button id="security_login_execute_authentication_ganagol" type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
									<c:if test="${estado==no && estado!='' && estado!=null}">
<!-- 										<button id="security_login_execute_authentication_ganagol_no" type="button" class="btn btn-red">COMPRAR</button> -->
										<button id="security_login_execute_authentication_ganagol_no" type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
									<c:if test="${empty estado}">
<!-- 										<button id="security_login_execute_authentication_ganagol_empty" type="button" class="btn btn-red">COMPRAR</button> -->
										<button id="security_login_execute_authentication_ganagol_empty" type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
								</c:if>

							</div>
							<br><br><br><br>
						</div>
					</div>
				</section>
			</div>
		</div>

	</div>

	<jsp:include page="../../include/footer.jsp" />
	
	<script type="text/javascript">
		$(document).ready(function(){
			var resultados=$(".sp-resultados").map(function(){
	               			return $.trim($(this).text());
            				}).get().toString().replaceAll(", ","").replaceAll(","," ");
            var resultado_g200=$(".sp-resultado-g200").map(function(){
	               				return $.trim($(this).text());
            				}).get().toString().replaceAll(", ","").replaceAll(","," ");
			$('#h4-resultados').text(resultados);
			$('#h4-resultado-g200').text(resultado_g200);
			$('#h4-resultados2').text(resultados);
			$('#h4-resultado-g200-2').text(resultado_g200);

			var resultados_b=$(".sp-resultados-b").map(function(){
			       			return $.trim($(this).text());
							}).get().toString().replaceAll(", ","").replaceAll(","," ");
			var resultado_g200_b=$(".sp-resultado-g200-b").map(function(){
			       				return $.trim($(this).text());
							}).get().toString().replaceAll(", ","").replaceAll(","," ");
			$('#h4-resultados-b').text(resultados_b);
			$('#h4-resultado-g200-b').text(resultado_g200_b);
			$('#h4-resultados2-b').text(resultados_b);
			$('#h4-resultado-g200-2-b').text(resultado_g200_b);

			var resultados_c=$(".sp-resultados-c").map(function(){
			       			return $.trim($(this).text());
							}).get().toString().replaceAll(", ","").replaceAll(","," ");
			var resultado_g200_c=$(".sp-resultado-g200-c").map(function(){
			       				return $.trim($(this).text());
							}).get().toString().replaceAll(", ","").replaceAll(","," ");
			$('#h4-resultados-c').text(resultados_c);
			$('#h4-resultado-g200-c').text(resultado_g200_c);
			$('#h4-resultados2-c').text(resultados_c);
			$('#h4-resultado-g200-2-c').text(resultado_g200_c);

			var resultados_d=$(".sp-resultados-d").map(function(){
			       			return $.trim($(this).text());
							}).get().toString().replaceAll(", ","").replaceAll(","," ");
			var resultado_g200_d=$(".sp-resultado-g200-d").map(function(){
			       				return $.trim($(this).text());
							}).get().toString().replaceAll(", ","").replaceAll(","," ");
			$('#h4-resultados-d').text(resultados_d);
			$('#h4-resultado-g200-d').text(resultado_g200_d);
			$('#h4-resultados2-d').text(resultados_d);
			$('#h4-resultado-g200-2-d').text(resultado_g200_d);
			
			funcionesTagging();			
			var jugadas = [resultados,resultados_b,resultados_c,resultados_d];

			if( $("#operation").val() == 'add'){
				datalayerAddToCart(jugadas,$("#simpleBetPrice").val(),'Mi Boleto');
			}

			$(document).delegate('.ico-close', 'click', function(e) {
				datalayerRemoveFromCart(jugadas,$("#simpleBetPrice").val(),'Mi Boleto');
			});

			$(document).delegate('#btn_mobile_comprar_ganagol', 'click', function () {
				datalayerCheckout(jugadas,$("#simpleBetPrice").val());
			});
			
		});	   	
	</script>

</body>

</html>