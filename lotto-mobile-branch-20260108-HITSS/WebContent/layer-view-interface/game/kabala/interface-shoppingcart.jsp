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
	<title>Kabala : Boleto</title>	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Kabala móvil, boleto de jugada realizada" />
	
      <script type="text/javascript" src="layer-view-script/funcionesTaggingKabala.js"></script>        
                
</head>
<body class="main-kabala" >
 <!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Kábala" id="Zona">
	<input type="hidden" value="Juega Kábala" id="SubZona">
	 <input type="hidden" id="importePagar" value="${totalkabala_KB}"/> 
	 <input type="hidden" id="jugadasActuales" value="${totalBet_KB}"/>
	 <input type="hidden" id="consecutivas" value="${consecutiveKabalaValue_KB.NUM_DRAW}"/>
	 <input type="hidden" id="precioDesc" value="${precioDesc}"/>
	 <input type="hidden" id="ticketId" value="${ticketId}"/>	 
	 <input type="hidden" id="jugadasGratis" value="${quantityGameint_KB}"/>
	 <input type="hidden" id="valorRemo" value="${valorRemo}"/>
	 <input type="hidden" id="precioPorJugada" value="${precioPorJugada}"/>
	
	 
	 <input type="hidden" id="consecutiveParam" value="${consecutiveParam}"/>
	 <input type="hidden" id="operation" value="${operation}"/>
	 <input type="hidden" id="priceJuegoDelete" value="${priceJuegoDelete}"/>
	 <input type="hidden" id="priceJuegoDeleteCC" value="${priceJuegoDeleteCC}"/>
	 <input type="hidden" id="lastPriceK" value="${lastPriceK}"/>
	 <input type="hidden" id="lastPriceCC" value="${lastPriceCC}"/>
	 <input type="hidden" id="consecutivePrice" value="${consecutivePrice}"/>
	<input type="hidden" id="priceK" value="${priceK}"/>
	 <input type="hidden" id="priceCC" value="${priceCC}"/>

	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<a href="#" id="game_kabala_show_menu">
							<img src="layer-view-image/v2/logo-kabala.png" alt="resultados kabala">
						</a>
						<div class="game-desc min-desc">
							<h2>MI BOLETO</h2>
						</div>
						
						<div class="boxes-game-ticket">
							<div class="box-game-ticket">
								<div class="my-games">

									<c:set var="jgda_A" value="false" />
									<c:set var="jgda_B" value="false" />
									<c:set var="jgda_C" value="false" />
									<c:set var="jgda_D" value="false" />

									<c:forEach var="item" items="${boleto}">

										<c:if test="${item.key =='jugada_a'}">

											<c:set var="jgda_A" value="true" />

											<div class="my-game">
												<div class="number-game">
													<h3>Jugada A</h3>
												</div>
												<div class="hide" id="results1">${item.value.kabala}</div>
												<input type="hidden" id="jugadasA" value="${item.value.kabala}"/>
												<div class="results-balls playing">
													<div id="resultsview1" class="clearfix"></div>
													<c:if test="${!empty item.value.chau_chamba}">
													
													   <input type="hidden" id="chauA" value="${item.value.chau_chamba}"/>
														<div class="result-ball result-logo">
															<img src="layer-view-image/v2/logo-chauchamba.png"  alt="kabala"/>
														</div>
													</c:if>
												</div>
												<div class="game-options">
													<a href="#" onclick="datalayerRemover();window.location.href='game_kabala_delete_bet.html?id=${item.key}';" class="game-option ico ico-close">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.kabala)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Kabala!</p>
													</div>
												</c:if>
											</div>

										</c:if>

										<c:if test="${item.key =='jugada_b'}">

											<c:set var="jgda_B" value="true" />

											<div class="my-game">
												<div class="number-game">
													<h3>Jugada B</h3>
												</div>
												<div class="hide" id="results2">${item.value.kabala}</div>
												<input type="hidden" id="jugadasB" value="${item.value.kabala}"/>
												<div class="results-balls playing">
													<div id="resultsview2" class="clearfix"></div>
													<c:if test="${!empty item.value.chau_chamba}">
													  <input type="hidden" id="chauB" value="${item.value.chau_chamba}"/>
														<div class="result-ball result-logo">
															<img src="layer-view-image/v2/logo-chauchamba.png" alt="kabala">
														</div>
													</c:if>
												</div>
												<div class="game-options">
													<a href="#" onclick="window.location.href='game_kabala_delete_bet.html?id=${item.key}';" class="game-option ico ico-close">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.kabala)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Kabala!</p>
													</div>
												</c:if>
											</div>

										</c:if>

										<c:if test="${item.key =='jugada_c'}">

											<c:set var="jgda_C" value="true" />

											<div class="my-game">
												<div class="number-game">
													<h3>Jugada C</h3>
												</div>
												<div class="hide" id="results3">${item.value.kabala}</div>
												<input type="hidden" id="jugadasC" value="${item.value.kabala}"/>
												<div class="results-balls playing">
													<div id="resultsview3" class="clearfix"></div>
													<c:if test="${!empty item.value.chau_chamba}">
													  <input type="hidden" id="chauC" value="${item.value.chau_chamba}"/>
														<div class="result-ball result-logo">
															<img src="layer-view-image/v2/logo-chauchamba.png" alt="kabala">
														</div>
													</c:if>
												</div>
												<div class="game-options">
													<a href="#" onclick="window.location.href='game_kabala_delete_bet.html?id=${item.key}';" class="game-option ico ico-close">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.kabala)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Kabala!</p>
													</div>
												</c:if>
											</div>

										</c:if>

										<c:if test="${item.key =='jugada_d'}">

											<c:set var="jgda_D" value="true" />

											<div class="my-game">
												<div class="number-game">
													<h3>Jugada D</h3>
												</div>
												<div class="hide" id="results4">${item.value.kabala}</div>
												<input type="hidden" id="jugadasD" value="${item.value.kabala}"/>
												<div class="results-balls playing">
													<div id="resultsview4" class="clearfix"></div>
													<c:if test="${!empty item.value.chau_chamba}">
													  <input type="hidden" id="chauD" value="${item.value.chau_chamba}"/>
														<div class="result-ball result-logo">
															<img src="layer-view-image/v2/logo-chauchamba.png" alt="kabala">
														</div>
													</c:if>
												</div>
												<div class="game-options">
													<a href="#" onclick="window.location.href='game_kabala_delete_bet.html?id=${item.key}';" class="game-option ico ico-close">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.kabala)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Kabala!</p>
													</div>
												</c:if>
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
<!-- 											<button type="button" id="game_kabala_show_bet_a" class="btn btn-transparent">JUGADA A</button> -->
											<button type="button" id="btn_mobile_jugar_ahora_kabala" class="btn btn-transparent">JUGADA A</button>
										</c:if>
										
										<c:if test="${!jgda_B}">
											<button type="button" id="game_kabala_show_bet_b" class="btn btn-transparent">JUGADA B</button>
										</c:if>
										
										<c:if test="${!jgda_C}">
											<button type="button" id="game_kabala_show_bet_c" class="btn btn-transparent">JUGADA C</button>
										</c:if>
										
										<c:if test="${!jgda_D}">
											<button type="button" id="game_kabala_show_bet_d" class="btn btn-transparent">JUGADA D</button>
										</c:if>

									</div>
								</div>

							</c:if>
							<c:if test="${flagConsecutivaKb==1}">
								<div class="box-game-ticket">
									<div class="title-game-ticket">
										<h3>¿PARA CUÁNTOS SORTEOS QUIERES JUGAR?</h3>
									</div>
									<div class="game-actions">
										<c:if test="${empty consecutiveKabalaValue_KB }">
											<button type="button" onclick="datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');window.location.href='game_kabala_show_consecutive.html';" class="btn btn-orange-light">AGREGAR SORTEOS</button>
										</c:if>
										<c:if test="${!empty consecutiveKabalaValue_KB }">
											<button type="button" onclick="window.location.href='game_kabala_delete_consecutive.html';" class="btn btn-orange-light">QUITAR SORTEOS CONSECUTIVOS</button>
										</c:if>	
									</div>
								</div>
							</c:if>
						</div>

						<div class="footer-game-tikect">
						
							<c:if test="${fn:length(consecutiveKabalaValue_KB)>=1}">
								<div class="content-game-ticket" style="margin-bottom: 40px;">
							</c:if>
							<c:if test="${fn:length(consecutiveKabalaValue_KB)<1}">
								<div class="content-game-ticket" style="margin-bottom: 85px;">
							</c:if>
							
								<c:if test="${fn:length(priceMessage)>12}">
									<div class="field-ticket">${priceMessage}</div>
								</c:if>
								<!-- Cambiar 'apuesta' por jugada -->
								<!-- <div class="field-ticket">${ganadiarioProcedureBetData.priceMessage}</div> -->
								<fmt:parseNumber var = "quantityGame_KB_" type = "number" value = "${quantityGameint_KB}" />
								<fmt:parseNumber var = "amountGame_KB_" type = "number" value = "${amountGameint_KB}" />
								<fmt:parseNumber var = "totalkabalamonto_KB_" type = "number" value = "${totalkabalamontoint_KB}" />
								
								<c:if test="${quantityGame_KB_ > 0}" >
									<div class="field-ticket info"><div><span>Jugadas gratis*:</span></div><div><span>${quantityGame_KB}</span></div></div><!-- bonoLoteria -->
									<c:if test="${amountGame_KB_ >= totalkabalamonto_KB_}" >
										<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>S/ 0</span></div></div><!-- precioJugada -->
									</c:if>
									<c:if test="${amountGame_KB_ < totalkabalamonto_KB_}" >
										<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${precioJugada}</span></div></div><!-- precioJugada -->
									</c:if>
								</c:if>
								<c:if test="${quantityGame_KB_ == 0}" >
									<div class="field-ticket info"><div><span>Jugadas gratis:</span></div><div><span>${quantityGame}</span></div></div><!-- bonoLoteria -->
									<c:choose>
									    <c:when test="${fn:length(precioJugada)>0}">
									      <div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${precioJugada}</span></div></div><!-- precioJugada -->
									    </c:when>    
									    <c:otherwise>
									        <div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>S/.0</span></div></div><!-- precioJugada -->
									    </c:otherwise>
									</c:choose>
								</c:if>		
								<c:choose>
								    <c:when test="${fn:length(totalBet_KB)>0}">
								   		<div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>${totalBet_KB}</span></div></div>
								    </c:when>    
									<c:otherwise>
									    <div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>0</span></div></div>
									</c:otherwise>
								</c:choose>
								<c:if test="${fn:length(consecutiveKabalaValue_KB)>1}">
									<div class="field-ticket">Consecutivo de ${consecutiveKabalaValue_KB.NUM_DRAW} hasta ${consecutiveKabalaValue_KB.DR_DATE}</div>
								</c:if>
								<c:if test="${quantityGame_KB_ > 0}" >
									<c:if test="${amountGame_KB_ >= totalkabalamonto_KB_}" >
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>S/ 0</span></div></div><!-- totalTinka_TK -->
									</c:if>
									<c:if test="${amountGame_KB_ < totalkabalamonto_KB_}" >
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>${totalkabala_KB}</span></div></div><!-- totalTinka_TK -->
									</c:if>
								</c:if>
								<c:if test="${quantityGame_KB_ == 0}" >
									<c:choose>
									    <c:when test="${fn:length(totalkabala_KB)>0}">
									       <div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>${totalkabala_KB}</span></div></div><!-- priceMessage -->
									    </c:when>    
									    <c:otherwise>
									      <div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>S/.0</span></div></div><!-- priceMessage -->
									    </c:otherwise>
									</c:choose>
								</c:if>			

							</div>
							<div class="game-actions">
								
								<c:if test="${fn:length(consecutiveKabalaValue_KB)>1}">
									<div class="field-ticket2"><p>* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto</p></div>
								</c:if>
								<c:if test="${fn:length(consecutiveKabalaValue_KB)<=1}">
									<div class="field-ticket2"><p>* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto</p></div>
								</c:if>
													
								<div class="field-ticket"><div class="alert">${alertNumberPlay_KB}</div></div>							
								
								<c:if test="${!empty clientId && agreement!=''}">
									<c:if test="${ind_kb==negacion}">
<!-- 										<button type="button" id="" class="btn btn-red">COMPRAR</button> -->
										<button type="button" id="" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
									
									<c:if test="${ind_kb==afirmacion}">
<!-- 										<button type="button" id="game_kabala_play_bet_result" class="btn btn-red float-bottom">COMPRAR</button> -->
										<button type="button" id="btn_mobile_comprar_kabala" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
									
								</c:if>
								
								<c:if test="${empty clientId or agreement==''}">
									<c:if test="${ind_kb==negacion}">
<!-- 										<button type="button" id="" class="btn btn-red">COMPRAR</button> -->
										<button type="button" id="" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
									<c:if test="${ind_kb==afirmacion}">
<!-- 										<button type="button" id="security_login_execute_authentication_kabala" class="btn btn-red">COMPRAR</button> -->
										<button type="button" id="security_login_execute_authentication_kabala" class="btn btn-red float-bottom">COMPRAR</button>
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
			replacehtml('#results1', '#resultsview1', ',');
			replacehtml('#results2', '#resultsview2', ',');
			replacehtml('#results3', '#resultsview3', ',');
			replacehtml('#results4', '#resultsview4', ',');
			funcionesTagging();
			var navigation=window.performance.navigation.type;
			var jugadas = [4];
			jugadas[0] = $("#jugadasA").val() != undefined ? $("#jugadasA").val() : null;
			jugadas[1] = $("#jugadasB").val() != undefined ? $("#jugadasB").val() : null;
			jugadas[2] = $("#jugadasC").val() != undefined ? $("#jugadasC").val() : null;
			jugadas[3] = $("#jugadasD").val() != undefined ? $("#jugadasD").val() : null;
			var importPagar = parseFloat($("#importePagar").val().split(" ")[1]);
			var jugadasActuales = $("#jugadasActuales").val().split(" ")[0];
			if(navigation==0){
				var op=$("#operation").val();			
				if(op==="add"){
					datalayerAddToCart(jugadas,importPagar/jugadasActuales,'Elige 6 números o más'); 
				}
			}
			$("#btn_mobile_comprar_kabala").on('click',function(){
				datalayerCheckout(jugadas,importPagar/jugadasActuales);
			});

			
			
		});

		function datalayerRemover(){
			var jugadas = [4];
			jugadas[0] = $("#jugadasA").val() != undefined ? $("#jugadasA").val() : null;
			jugadas[1] = $("#jugadasB").val() != undefined ? $("#jugadasB").val() : null;
			jugadas[2] = $("#jugadasC").val() != undefined ? $("#jugadasC").val() : null;
			jugadas[3] = $("#jugadasD").val() != undefined ? $("#jugadasD").val() : null;
			var importPagar = parseFloat($("#importePagar").val().split(" ")[1]);
			var jugadasActuales =  parseFloat($("#jugadasActuales").val().split(" ")[0]);
			
			datalayerRemoveFromCart(jugadas,importPagar/jugadasActuales,'Mi Boleto');

		}

// 		function deshabilitaRetroceso(){
// 			window.location.hash="no-back-button";
// 		    window.location.hash="Again-No-back-button" //chrome
// 		    window.onhashchange=function(){window.location.hash="no-back-button";}
// 		}

		
	$("#btn_mobile_jugar_ahora_kabala , #game_kabala_show_bet_b , #game_kabala_show_bet_c , #game_kabala_show_bet_d , #btn_mobile_comprar_kabala").on('click',function(){
		datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');
	});
		
	</script>
	

</body>
</html>