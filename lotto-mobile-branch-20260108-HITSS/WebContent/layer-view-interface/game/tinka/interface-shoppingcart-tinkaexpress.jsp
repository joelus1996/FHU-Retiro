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
	<link rel="stylesheet" href="layer-view-style/game/tinka/styles.css" />
    <link rel="stylesheet" href="layer-view-style/game/tinka/layout.css" />
    <link rel="stylesheet" href="layer-view-style/game/tinka/custom.css" />
	<meta name="description" content="Tinka Megabol móvil, boleto de jugada realizada" />

	
       <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script> 
       
       <%
       
       String precioJug=request.getParameter("precioJug");
       %>
</head>
<body class="main-tinka">
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
	<input type="hidden" id="typeBoleto" value="${typeBoleto}"/>
	<input type="hidden" id="promotionMessage" value="${promotionMessage}">
	<input type="hidden" id="bolillasMinima" value="${bolillasMinima}">
	<input type="hidden" id="n_bolillas" value="${n_bolillas}">
	<input type="hidden" id="limiteJugadas" value="${limiteJugadas}">
	<input type="hidden" value="${tinkaSale.algorithm}" id="algorithm">
	<input type="hidden" value="${tinkaSale.bets}" id="bets">
	<input type="hidden" value="${tinkaSale.pay}" id="pay">
	<input type="hidden" value="${tinkaSale.cost}" id="cost">
	<input type="hidden" value="${tinkaSale.draws}" id="draw">
	
	<input type="hidden" value="${consecutiveParam}" id="consecutiveParam">
	<input type="hidden" value='${jsonJugadas}' id="jsonJugadas">
		
	<!-- parametros de analytics -->
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
	  
						<div class="game-desc">
							<h2>ELIGE 6 NÚMEROS O MÁS</h2>
							<h4>Jugada <span class="jugada-tinka">A</span> </h4>
						</div>
							
						<div class="body-game">
							<div class="button-group checkboxes-ball clearfix">
								<c:forEach var="i" begin="1" end="50">
									<label div="div_tk_chk_${i}"> 
										<input type="checkbox" name="tk" value="${i}" id="tk_chk_${i}">
								 		<span class="button-group-item" for="tk_chk_${i}"><span class="label-item">${i}</span></span>
									</label> 
								</c:forEach>
							</div>
						</div>
						
						<div class="game-actions">
							<button type="button" id="azar" class="btn btn-green">AZAR</button>
							<button type="button" id="clean" class="btn btn-green">LIMPIAR</button>
						</div>
						
						<div class="text-center mb-40">
					        <p class="text-body mb-12">Tus números son</p>
					        <p class="text-body font-bold text-green mb-4">JUGADA <span class="jugada-tinka">A</span></p>
					        <p class="heading-3 font-display " id="jugada-check">__, __, __, __, __, __</p>
					        
					        <div class="flex-center" style="display: none;" id="contenedor_buttons_check">
								<button type="button" class="btn-icon btn-icon-red mr-8" id="btn_eliminar_check">
								  <i class="flex mr-8">
								    <svg width="19" height="18" viewBox="0 0 19 18" fill="none" xmlns="http://www.w3.org/2000/svg">
								      <path d="M12.5 6L6.5 12" stroke="currentColor" stroke-linecap="square" stroke-linejoin="round"/>
								      <path d="M6.5 6L12.5 12" stroke="currentColor" stroke-linecap="square" stroke-linejoin="round"/>
								      <circle cx="9.5" cy="9" r="8.5" stroke="currentColor"/>
								    </svg>
								  </i>
								  Eliminar
								</button>
							</div>
				        </div>
				        
				        <!-- Jugadas Editar/Eliminar aca debe haber un for--> 
						<div id="listJugadas">
						<c:set var="jugadas" value='jugadaA,jugadaB,jugadaC,jugadaD' />
						<c:forEach var="jugada" items="${jugadas}">
							<div class="text-center mb-40" id="${jugada}" style="display: none;">
								<p class="text-body font-bold text-green mb-4">JUGADA</p>
								<p class="heading-3 font-display">__, __, __, __, __, __</p>
								<div class="flex-center">
									<button type="button" class="btn-icon btn-icon-red mr-8" id="${jugada}_eliminar">
									  <i class="flex mr-8">
									    <svg width="19" height="18" viewBox="0 0 19 18" fill="none" xmlns="http://www.w3.org/2000/svg">
									      <path d="M12.5 6L6.5 12" stroke="currentColor" stroke-linecap="square" stroke-linejoin="round"/>
									      <path d="M6.5 6L12.5 12" stroke="currentColor" stroke-linecap="square" stroke-linejoin="round"/>
									      <circle cx="9.5" cy="9" r="8.5" stroke="currentColor"/>
									    </svg>
									  </i>
									  Eliminar
									</button>
									<button type="button" class="btn-icon btn-icon-green ml-8" id="${jugada}_editar">
									  <i class="flex mr-8">
									    <svg width="19" height="18" viewBox="0 0 19 18" fill="none" xmlns="http://www.w3.org/2000/svg">
									      <g clip-path="url(#clip0_282_9186)">
									      <path d="M5 11.6262V13.5013H6.875L12.405 7.97125L10.53 6.09625L5 11.6262ZM13.855 6.52125C14.05 6.32625 14.05 6.01125 13.855 5.81625L12.685 4.64625C12.49 4.45125 12.175 4.45125 11.98 4.64625L11.065 5.56125L12.94 7.43625L13.855 6.52125Z" fill="#0D6639"/>
									      </g>
									      <circle cx="9.5" cy="9" r="8.5" stroke="#036436"/>
									      <defs>
									      <clipPath id="clip0_282_9186">
									      <rect width="12" height="12" fill="white" transform="translate(3.5 3)"/>
									      </clipPath>
									      </defs>
									    </svg>
									  </i>
									  Editar
									</button>
								</div>
							</div>
						</c:forEach>									
						</div>
				        
				      <!-- Agregar más jugadas aca debe haber un for -->
			          <div class="mb-40 game-actions" id="agregarMasJugada">
			            <div class="text-center mb-16">
			              <p class="text-body font-bold">¿Quieres agregar más jugadas?</p>
			            </div>
						<div class="btnAddJugada">
							<button type="button" id="btnJugadaA" class="btn btn-with-icon btn-outline-green shadow-none mb-16 " style="display: none;">
				              <span class="flex-1">JUGADA A</span>
				              <i class="ml-8">
				                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
				                  <path d="M6 12H18M12 6V18" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
				                </svg>
				              </i>
				            </button>
				            
				            <button type="button" id="btnJugadaB" class="btn btn-with-icon btn-outline-green shadow-none mb-16">
				              <span class="flex-1">JUGADA B</span>
				              <i class="ml-8">
				                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
				                  <path d="M6 12H18M12 6V18" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
				                </svg>
				              </i>
				            </button>
				
				            <button type="button" id="btnJugadaC" class="btn btn-with-icon btn-outline-green shadow-none mb-16">
				              <span class="flex-1">JUGADA C</span>
				              <i class="ml-8">
				                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
				                  <path d="M6 12H18M12 6V18" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
				                </svg>
				              </i>
				            </button>
				
				            <button type="button" id="btnJugadaD" class="btn btn-with-icon btn-outline-green shadow-none mb-16">
				              <span class="flex-1">JUGADA D</span>
				              <i class="ml-8">
				                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
				                  <path d="M6 12H18M12 6V18" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
				                </svg>
				              </i>
				            </button>
						</div>									
			          </div>
				      <!-- Jugadas consecutivas -->
			          <div class="mb-40 game-actions">
			            <div class="text-center mb-16">
			              <p class="text-body font-bold">¿Para cuántos sorteos quieres jugar?</p>
			            </div>
			            <div class="select-field w-full">
			            	<select name="game-consecutive" id="game-consecutive" class="w-full">
							    <c:forEach items="${consecutiveTinkaList_TK}" var="consecutiva">
							        <option value="${consecutiva.NUM_DRAW}_${consecutiva.DR_DATE}">
										<c:choose>
											<c:when test="${consecutiva.NUM_DRAW eq 1}">
												<c:set var="gameConsecutiveText">${consecutiva.NUM_DRAW} el ${consecutiva.DR_DATE}</c:set>
											</c:when>
											<c:otherwise>
												<c:set var="gameConsecutiveText"> ${consecutiva.NUM_DRAW} hasta el ${consecutiva.DR_DATE}</c:set>
											</c:otherwise>
										</c:choose>
										${gameConsecutiveText}
									</option>
								</c:forEach>
							</select>
			              <i>
			                <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
			                  <path d="M6 9L12 15L18 9" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
			                </svg>
			              </i>
			            </div>
			          </div> 
				      <div class ="footer-game-summary">
				      		<!-- Titulo Resumen -->  
					      <div class="text-center mb-16">
				            <p class="text-body font-bold">Resumen</p>
				          </div>  
							
					       <!-- Resumen de jugadas -->
				          <div class="game-summary">
				            <div class="game-summary-item">
				              <p>${promocion}</p>
							
				            </div>
				
				            <div class="game-summary-item">
				              <p class="mr-4">Costo por jugada:</p>
				              <p>${formatRegularPayment}</p>
				            </div>
				            <div class="game-summary-item">
				              <p class="mr-4">Total de jugadas:</p>
				              <p id="total-jugadas">0</p>
				 
				            </div>
				            <div class="game-summary-item">
				              <p id="consecutive-text">Consecutivo de ${consecutiveTinkaList_TK[0].NUM_DRAW} hasta ${consecutiveTinkaList_TK[0].DR_DATE}</p>
				            </div>
				            <div class="line"></div>
				            <div class="game-summary-item">
				              <p class="mr-4"><strong>Importe a pagar:</strong></p>
				              <p><strong id="total-pagar">S/ 0.00</strong></p>
				            </div>

							</div>		  
				          <div class="btn-footer">
				          	<button type="button" id="btn_mobile_comprar_tinka" class="btn btn-red float-bottom">COMPRAR</button>
				          </div>
					   
				      </div>
						
					</div>
				</section>
			</div>
		</div>

	</div>

	<div style="display:none" class="f_error_mensaje">
	    <span class="close_f"></span>
		<div class="f_textoInterno"></div>
	</div>

	<jsp:include page="../../include/footer.jsp" />

	<script type="text/javascript" charset="UTF-8" src="layer-view-script/game/tinka/interface-shoppingcart-tinkaexpress.js?v=1"></script>

</body>
</html>