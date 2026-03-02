<%@page import="java.util.HashMap"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@ page import="java.util.Map"%>
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
	<title>Tinka : Mi Boleto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Tinka Megabol móvil, boleto de jugada realizada" />

	
       <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script> 
       
       <%
       
       String precioJug=request.getParameter("precioJug");
       %>
</head>
<body class="main-tinka" ">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

    <input type="hidden" id="precioRegular" value="${formatRegularPayment}" />
    <input type="hidden" id="importePagar" value=" ${formatDiscountPayment}"/>
	<input type="hidden" id="jugadasActuales" value="${jugadasActuales}"/>
	<input type="hidden" id="consecutivas" value="${consecutiveTinkaValue_TK.NUM_DRAW}"/>
	<input type="hidden" id="ticketId" value="${ticketId}"/>
	<input type="hidden" id="priceSale" value="${priceSale}"/>
	<input type="hidden" id="jugadasGratis" value="${quantityGameInt}"/>
	<input type="hidden" id="valorRemo" value="${valorRemo}"/>
	<input type="hidden" id="operation" value="${operation}"/>
	<input type="hidden" id="priceJuegoDelete" value="${priceJuegoDelete}"/>
	<input type="hidden" id="lastPrice" value="${lastPrice}"/>
	<input type="hidden" id="consecutivePrice" value="${consecutivePrice}"/>
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Tinka" id="Zona">
	<input type="hidden" value="Juega Tinka" id="SubZona">
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<a href="#" id="game_tinka_show_menu">
							<img src="layer-view-image/v2/logo-tinka.png?v=3" alt="tinka">
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
									<input type="hidden" id="boleto" value="${boleto}"/>
									<% 								
// 										Map<String, Double> mprecios=(Map)session.getAttribute("precios_jugadas");
// 										Map <String,Map> mboleto=(Map)request.getAttribute("boleto");
										
// 									System.out.println("mboleto: "+mboleto);
// 									Map<String, Double> bprecios=new HashMap<String, Double>();
// 									for (Map.Entry<String, Map> entry : mboleto.entrySet()) {
// 										if(mprecios.containsKey(entry.getKey())){											
// 											bprecios.put("\""+entry.getKey()+"\"",mprecios.get(entry.getKey()));
// 										}
// 										System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
// 										System.out.println("bprecios: "+bprecios);
// 									}
									%>
<%-- 									<input type="hidden" id="precios" value='<%=bprecios.toString()%>'/> --%>
								
									<c:forEach 	var="item"  items="${boleto}">

										<c:if test="${item.key =='jugada_a'}">

											<c:set var="jgda_A" value="true" />

											<div class="my-game">
												<div class="number-game">
													<h3>Jugada A</h3>
												</div>
												<div class="hide" id="results1">${item.value.tinka}</div>
												<input type="hidden" id="jugadasA" value="${item.value.tinka}"/>
												<div id="resultsview1" class="results-balls playing clearfix"></div>
												<div class="game-options">
													<a href="#" class="game-option ico ico-close" onclick="datalayerRemover();window.location.href='game_tinka_delete_bet.html?id=${item.key}';">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.tinka)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Tinka</p>
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
												<div class="hide" id="results2">${item.value.tinka}</div>
												<input type="hidden" id="jugadasB" value="${item.value.tinka}"/>
												<div id="resultsview2" class="results-balls playing clearfix"></div>
												<div class="game-options">
													<a href="#" class="game-option ico ico-close" onclick="window.location.href='game_tinka_delete_bet.html?id=${item.key}';">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.tinka)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Tinka</p>
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
												<div class="hide" id="results3">${item.value.tinka}</div>
												<input type="hidden" id="jugadasC" value="${item.value.tinka}"/>
												<div id="resultsview3" class="results-balls playing clearfix"></div>
												<div class="game-options">
													<a href="#" class="game-option ico ico-close" onclick="window.location.href='game_tinka_delete_bet.html?id=${item.key}';">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.tinka)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Tinka</p>
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
												<div class="hide" id="results4">${item.value.tinka}</div>
												<input type="hidden" id="jugadasD" value="${item.value.tinka}"/>
													<div id="resultsview4" class="results-balls playing clearfix"></div>
												<div class="game-options">
													<a href="#" class="game-option ico ico-close" onclick="window.location.href='game_tinka_delete_bet.html?id=${item.key}';">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.tinka)<6}">
													<div class="game-alert">
														<p>Debe elegir por lo menos seis opciones en Tinka</p>
													</div>
												</c:if>
											</div>

										</c:if>

									</c:forEach>

								</div>
							</div>
 <input type="hidden" id="precioPorJugada" value="${precioPorJugada}"/>
							<c:if test="${!jgda_A or !jgda_B or !jgda_C or !jgda_D}">

								<div class="box-game-ticket">
									<div class="title-game-ticket">
										<h3>¿AGREGAR MÁS JUGADAS?</h3>
									</div>
									<div class="game-actions">
										<c:if test="${!jgda_A}">
											<button type="button" id="game_tinka_show_bet_a" class="btn btn-transparent">JUGADA A</button>
										</c:if>
										
										<c:if test="${!jgda_B}">
											<button type="button" id="game_tinka_show_bet_b" class="btn btn-transparent">JUGADA B</button>
										</c:if>
										
										<c:if test="${!jgda_C}">
											<button type="button" id="game_tinka_show_bet_c" class="btn btn-transparent">JUGADA C</button>
										</c:if>
										
										<c:if test="${!jgda_D}">
											<button type="button" id="game_tinka_show_bet_d" class="btn btn-transparent">JUGADA D</button>
										</c:if>
									</div>
								</div>

							</c:if>
							<c:if test="${flagConsecutivaTk==1}">
								<div class="box-game-ticket">
									<div class="title-game-ticket">
										<h3>¿PARA CUÁNTOS SORTEOS QUIERES JUGAR?</h3>
									</div>
									<div class="game-actions">
										<c:if test="${empty consecutiveTinkaValue_TK }">
											<button type="button" onclick="datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');window.location.href='game_tinka_show_consecutive.html?price=${formatDiscountPayment}';" class="btn btn-green">AGREGAR SORTEOS</button>
										</c:if>
										<c:if test="${!empty consecutiveTinkaValue_TK }">
											<button type="button" onclick="window.location.href='game_tinka_delete_consecutive.html';" class="btn btn-green">QUITAR SORTEOS CONSECUTIVOS</button>
										</c:if>	
									</div>
								</div>
							</c:if>	
						</div>

						<div class="footer-game-tikect">
							<div class="content-game-ticket">
								
								<fmt:parseNumber var = "quantityGame_" type = "number" value = "${quantityGameInt}" />
								<fmt:parseNumber var = "amountGame_" type = "number" value = "${amountGameInt}" />
								<fmt:parseNumber var = "discountPayment_" type = "number" value = "${discountPaymentInt}" />
								<fmt:parseNumber var = "jugadasActuales_" type = "number" value = "${jugadasActuales}" />	
								<!-- Ruth inicio  -->

								<c:if test="${jugadasActuales == 0}" >
									
									<c:choose>
									    <c:when test="${fn:length(promotionMessage)>9}">
									       <div class="field-ticket info-promotion">${promotionMessage}</div><!-- priceMessage -->
									       
									    </c:when>    
									    <c:otherwise>
									      <div class="field-ticket info-promotion">&nbsp;</div><!-- priceMessage -->
									    
									    </c:otherwise>
									</c:choose>
									
										<div class="field-ticket info"><div><span>Jugadas gratis:</span></div><div><span>${quantityGame_}</span></div></div><!--bonoLoteria -->
										<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${formatRegularPayment}</span></div></div><!-- precioJugada -->
										<div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>${jugadasActuales}</span></div></div><!-- totalBet_TK jugadas-->
									<c:if test="${fn:length(consecutiveTinkaValue_TK)>1}">
										<div class="field-ticket">Consecutivo de ${consecutiveTinkaValue_TK.NUM_DRAW} hasta ${consecutiveTinkaValue_TK.DR_DATE}</div>
									 </c:if>
										<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>${formatDiscountPayment}</span></div></div><!-- totalTinka_TK -->
										
										<c:if test="${fn:length(consecutiveTinkaValue_TK)>1}">
											<div class="field-ticket2" style="margin-top: 30px;"><p>* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto</p></div>
										</c:if>
										<c:if test="${fn:length(consecutiveTinkaValue_TK)<=1}">
											<div class="field-ticket2" style="margin-top: 85px;"><p>* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto</p></div>
										</c:if>
								</c:if> 

							   <c:if test="${jugadasActuales>0}">
							   		<!--  No hay promoción-->
							   		
							   	     <div class="field-ticket info-promotion">&nbsp;</div><!-- priceMessage -->
							   		
							        <c:if test="${(formatPricePerPlay2 *jugadasActuales *consecutive)== discountPayment}" >
								    	<c:if test="${fn:length(promotionMessage)>9}">
											<div class="field-ticket info-promotion">${promotionMessage}</div><!-- priceMessage -->
										</c:if>
											<div class="field-ticket info"><div><span>Jugadas gratis:</span></div><div><span>${quantityGame_}</span></div></div><!--bonoLoteria -->
										<c:if test="${jugadasActuales_<=quantityGame_ }">
											<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>S/. 0</span></div></div><!-- precioJugada -->
										</c:if>
										<c:if test="${jugadasActuales_>quantityGame_ }">
											<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${formatRegularPayment}</span></div></div><!-- precioJugada -->
										</c:if>										
											<div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>${jugadasActuales}</span></div></div><!-- totalBet_TK jugadas-->
										<c:if test="${fn:length(consecutiveTinkaValue_TK)>1}">
											<div class="field-ticket">Consecutivo de ${consecutiveTinkaValue_TK.NUM_DRAW} hasta ${consecutiveTinkaValue_TK.DR_DATE}</div>
										</c:if>
										<c:if test="${jugadasActuales_*consecutive <= quantityGame_}">
											<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>S/. 0</span></div></div>      
							           	</c:if>
							           	<c:if test="${jugadasActuales_*consecutive  > quantityGame_}">
											<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>${formatDiscountPayment}</span></div></div>	   
							           	</c:if>
						           	</c:if>
						            <!--  Si hay promoción-->
						            <c:if test="${(formatPricePerPlay2 *jugadasActuales *consecutive)ne discountPayment}" >
						                <c:if test="${fn:length(promotionMessage)>9}">
											<div class="field-ticket info-promotion">${promotionMessage}</div><!-- priceMessage -->
										</c:if>
											<div class="field-ticket info"><div><span>Jugadas gratis:</span></div><div><span>${quantityGame_}</span></div></div><!--bonoLoteria -->
											<div class="field-ticket info"><div><span>Costo por jugada:</span></div><div><span>${formatRegularPayment}</span></div></div><!-- precioJugada -->
											<div class="field-ticket info"><div><span>Total de jugadas:</span></div><div><span>${jugadasActuales_}</span></div></div><!-- totalBet_TK jugadas-->
										<c:if test="${fn:length(consecutiveTinkaValue_TK)>1}">
											<div class="field-ticket">Consecutivo de ${consecutiveTinkaValue_TK.NUM_DRAW} hasta ${consecutiveTinkaValue_TK.DR_DATE}</div>
									  	</c:if>
											<div class="field-ticket info"><div><span>Importe a pagar:</span></div><div><span>${formatDiscountPayment}</span></div></div>
						           	</c:if>			
									
									<c:if test="${fn:length(consecutiveTinkaValue_TK)>1}">
										<div class="field-ticket2" style="margin-top: 30px;"><p>* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto</p></div>
									</c:if>
									<c:if test="${fn:length(consecutiveTinkaValue_TK)<=1}">
										<div class="field-ticket2" style="margin-top: 85px;"><p>* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto</p></div>
									</c:if>
												
								</c:if>
								<!-- Ruth Fin-->								
								<div class="field-ticket"><div class="alert">${alertNumberPlay_TK}</div></div>
							</div>
							<div class="game-actions">

								<c:if test="${!empty clientId && agreement!=''}">
									<c:if test="${ind_tk==negacion}">
<!-- 										<button type="button" class="btn btn-red">COMPRAR</button> -->
										<button type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
								
									<c:if test="${ind_tk==afirmacion}">
										<button type="button" id="btn_mobile_comprar_boleto_tinka" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>
								</c:if>
								
								<c:if test="${empty clientId or agreement==''}">
									<c:if test="${ind_tk==negacion}">
<!-- 										<button type="button" class="btn btn-red">COMPRAR</button> -->
										<button type="button" class="btn btn-red float-bottom">COMPRAR</button>
									</c:if>

									<c:if test="${ind_tk==afirmacion}">
<!-- 										<button type="button" id="security_login_execute_authentication_tinka" class="btn btn-red">COMPRAR</button> -->
										<button type="button" id="security_login_execute_authentication_tinka" class="btn btn-red float-bottom">COMPRAR</button>
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
			var navigation=window.performance.navigation.type;
			var jugadas = [4];
			jugadas[0] = $("#jugadasA").val() != undefined ? $("#jugadasA").val() : null;
			jugadas[1] = $("#jugadasB").val() != undefined ? $("#jugadasB").val() : null;
			jugadas[2] = $("#jugadasC").val() != undefined ? $("#jugadasC").val() : null;
			jugadas[3] = $("#jugadasD").val() != undefined ? $("#jugadasD").val() : null;
			var importPagar = parseFloat($("#importePagar").val().split(" ")[2]);
			var jugadasActuales = $("#jugadasActuales").val();
			if(navigation==0){
				var op=$("#operation").val();			
				if(op==="add"){
					var lastPrice=$("#lastPrice").val();
					taggingSiguienteAddToCart('Tinka Jugada Individual','tinkaInd',lastPrice);
					taggingJuegaTinkaSliderFinaliza();
					taggingJuegaTinkaChekoutSlider();
					
					datalayerAddToCart(jugadas,importPagar/jugadasActuales,'Elige 6 números o más');
				}
				if(op==="delete"){
					taggingRemoveFromCart();
					taggingJuegaTinkaSliderFinaliza();
					if(importePagar>0){
						taggingJuegaTinkaChekoutSlider();
						}
				}					
				if(op==="consecutive"){
					var cantSorteos=$("#consecutivas").val();
					var consecutivePrice=$("#consecutivePrice").val();
					if(parseInt(cantSorteos)>1 && parseFloat(consecutivePrice)>0.00){

						taggingSiguienteAddToCart('Tinka Jugada Individual','tinkaInd',consecutivePrice);			
						taggingJuegaTinkaSliderFinaliza();
						taggingJuegaTinkaChekoutSlider();								
					}else{
						taggingJuegaTinkaSliderFinaliza();
					}					
					}
				if(op==="removeConsecutive"){
					var priceJuegoDelete=$("#priceJuegoDelete").val();
					if(parseFloat(priceJuegoDelete)>0.00){
						taggingRemoveFromCart();
					taggingJuegaTinkaSliderFinaliza();
						var importePagar=$("#importePagar").val();
						importePagar=parseFloat(importePagar.split(" ")[2]);
						if(importePagar>0){
							taggingJuegaTinkaChekoutSlider();
						}
					}else{
						taggingJuegaTinkaSliderFinaliza();
					}					
				}				
				if(op===""){
					taggingJuegaTinkaSliderFinaliza();
					}
			}else{
				taggingJuegaTinkaSliderFinaliza();
	}
			$("#btn_mobile_comprar_boleto_tinka").on('click',function(){
				var $btn = $(this);
				$btn.prop('disabled', true);
				datalayerCheckout(jugadas,importPagar/jugadasActuales);
				window.location.href = 'game_tinka_play_bet_result.html';
			});
		});

		function datalayerRemover(){
			var jugadas = [4];
			jugadas[0] = $("#jugadasA").val() != undefined ? $("#jugadasA").val() : null;
			jugadas[1] = $("#jugadasB").val() != undefined ? $("#jugadasB").val() : null;
			jugadas[2] = $("#jugadasC").val() != undefined ? $("#jugadasC").val() : null;
			jugadas[3] = $("#jugadasD").val() != undefined ? $("#jugadasD").val() : null;
			var importPagar = parseFloat($("#importePagar").val().split(" ")[2]);
			var jugadasActuales = $("#jugadasActuales").val();
			
			datalayerRemoveFromCart(jugadas,importPagar/jugadasActuales,'Mi Boleto');

		}
		

	$("#game_tinka_show_bet_a , #game_tinka_show_bet_b , #game_tinka_show_bet_c , #game_tinka_show_bet_d , #btn_mobile_comprar_boleto_tinka").on('click',function(){
		datalayerMisJugadas(this,'Mi Boleto','Jugar','Button');
	});
	</script>
	
	
</body>
</html>