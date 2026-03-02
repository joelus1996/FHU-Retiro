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
	<title>Tinka : Gracias por su compra</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Tinka mÃ³vil, gracias por su compra" />

	
    <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script>  
    
    
</head>
<body class="main-tinka">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

<%-- 		<input type="hidden" name="alertPlay" val="${alertPlay}"/> --%>
<%-- 		<input type="hidden" name="alertPlay" val="${status}"/> --%>
		<input type="hidden" name="typeBoleto" value="${typeBoletoTemp}" />
		
		 <input type="hidden" id="status" value="${status}">
		 <input type="hidden" id="importePagar" value="${importeTotal}"/>
	     <input type="hidden" id="ticketId" value="${ticketId}"/>
	     <input type="hidden" id="jugadasGratis" value="${jugadasGratis}"/>
	     <input type="hidden" id="jugadasActuales" value="${jugadasActuales}"/>
	     <input type="hidden" id="alertPlay" value="${alertPlay}"/>  
	     <input type="hidden" id="tipoCompra" value="${tipoCompra}"/>
	     <input type="hidden" id="numCombo" value="${numCombo}"/>
	     <input type="hidden" id="ticketIdCombo" value="${ticketIdCombo}"/>
	     <input type="hidden" id="precioCombo" value="${precioCombo}"/>
	     <input type="hidden" id="sorteosCombo" value="${sorteosCombo}"/> 
	     <input type="hidden" id="bolillasCombo" value="${bolillasCombo}"/>  
	     <input type="hidden" id="tipoJugadaCombo" value="${tipoJugadaCombo}"/>  
	     <input type="hidden" id="numBolJugadaA" value="${numBolJugadaA}"/>
	     <input type="hidden" id="numBolJugadaB" value="${numBolJugadaB}"/>
	     <input type="hidden" id="numBolJugadaC" value="${numBolJugadaC}"/>
	     <input type="hidden" id="numBolJugadaD" value="${numBolJugadaD}"/>
		 <input type="hidden" id="consecutivas" value="${consecu}"/>
		 
		<input type="hidden" id="formatPricePerPlay2" value="${formatPricePerPlay2}" />
		<input type="hidden" id="consecutive" value="${consecutive}" />
		<input type="hidden" id="discountPayment" value="${discountPayment}" />
		<input type="hidden" id="promotionMessage" value="${promotionMessage}" />
		<input type="hidden" value="Loterías" id="TipoZona">
		<input type="hidden" value="Tinka" id="Zona">
		<input type="hidden" id="SubZona" value="${SubZona}">

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<!-- <a href="#" id="game_tinka_show_menu"> -->
						<a href="game_tinka_show_menu.html" id="game_tinka_show_menu">
							<img src="layer-view-image/v2/logo-tinka.png?v=3" alt="tinka">
						</a>

						<div class="game-desc min-desc">
							<c:if test="${status == 'ok'}">
								<h2>GRACIAS POR TU COMPRA</h2>
							</c:if>
							<c:if test="${status == 'error'}">
								<c:choose>
									<c:when test="${alertPlay == 'Limite autoexclusion activado'}">
										<h2>Límite de autoexclusión activado. Infórmate en la sección de <a href="client_edit_auto_control.html" onclick="window.location='client_edit_auto_control.html'">Autocontrol</a></h2>
									</c:when>
									<c:otherwise>
										<h2>En este momento estamos presentando problemas. Por favor intenta nuevamente más tarde</h2>
									</c:otherwise>
								</c:choose>
							</c:if>
							<c:if test="${status == 'saldo'}">
								<h2>NO CUENTAS CON SALDO SUFICIENTE</h2><br/>
								<!-- a href="#" id="tinka-charge" class="btn btn-green">RECARGA TU SALDO</a -->
								<c:if test="${sessionScope.tipoTinka == 'suscripcion'}">
									<button id="tinka-suscripcion-charge" class="btn btn-green">RECARGA TU SALDO</button>
								</c:if>
								<c:if test="${sessionScope.tipoTinka != 'suscripcion'}">
									<button id="tinka-charge" class="btn btn-green">RECARGA TU SALDO</button>
								</c:if>
							</c:if>
						</div>
						<c:if test="${status == 'ok'}">
							<div class="wrapper-after-play">
								<div class="top-after-play">
									<h5>ESTÁS A UN PASO DE</h5>
									<h4>SER MILLONARIO</h4>
								</div>
								<div class="body-after-play">
									<div class="review-play">
										<h3>PUEDES REVISAR TU JUGADA EN:</h3>
										<!-- a href="#" id="client_play_show_information" class="btn btn-green">MIS JUGADAS</a -->
										<button id="client_play_show_information" class="btn btn-green">MIS JUGADAS</button>
									</div>
									<div class="keep-playing">
										<h3>¿TE SIENTES CON SUERTE?</h3>
										<h4>¡SIGUE JUGANDO!</h4>
									</div>
								</div>
							</div>
						</c:if>

						<c:if test="${status == 'error'}">
							<div class="wrapper-after-play">
								<div class="body-after-play">
									<div class="review-play">
										<h3>REVISA TU JUGADA:</h3>
										<!-- a href="#" id="game_tinka_show_shoppingcart" class="btn btn-green">VOLVER</a -->
										<button id="game_tinka_show_shoppingcart" class="btn btn-green">VOLVER</button>
									</div>
								</div>
							</div>
						</c:if>

					</div>

					<div class="footer-after-play">
						<jsp:include page="interface-result_game-cross-sell.jsp" />
					</div>
					<br><br>
					<div id="popup-bond" class="overlay">
						<div class="popup popup-sm">
							<a class="close js-close-modal" href="#">&times;</a>
							<div class="wrap-modal"></div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>


	<jsp:include page="../../include/footer.jsp" />
	
	<script>
		
		$(document).ready(function() {
			var tipoCompra = $("#tipoCompra").val();
			var status = $("#status").val();
			var jugadas = [null,null,null,null];
			var importPagar;
			var jugadaActuales;
			if(tipoCompra==="combo"){
				if (status == "ok") {
					jugadas = [$("#bolillasCombo").val(),null,null,null];
					importPagar = parseFloat($("#precioCombo").val());
					jugadaActuales = $("#sorteosCombo").val();
					var numCombo = $("#numCombo").val();
					var ticketIdCombo = $("#ticketIdCombo").val();
					var precioCombo = $("#precioCombo").val();
					var sorteosCombo = $("#sorteosCombo").val();
					var bolillasCombo = $("#bolillasCombo").val();
					var tipoJugadaCombo = $("#tipoJugadaCombo").val();
					taggingCombosTinkerosCompraExitosa(numCombo);
					taggingCombosTinkerosEEpurchase(numCombo,ticketIdCombo,precioCombo,sorteosCombo,bolillasCombo,tipoJugadaCombo);
					datalayerPurchase(jugadas,
									importPagar/jugadaActuales,
									importPagar,
									'Tinka-'+$("#ticketIdCombo").val(),
									"Combo_"+numCombo);
				}else{
					var alertPlay = $("#alertPlay").val();
					taggingCombosJugadaNoProcesada("Error :: Tinka", alertPlay);
					datalayerErrores('Gracias por tu Compra','Paso 3','Compra',alertPlay);
				}
			}else{
				var navigation = window.performance.navigation.type;
				if (navigation == 0) {
					if (status == "ok") {
						jugadas[0] = $("#numBolJugadaA").val() != "" ? $("#numBolJugadaA").val() : null;
						jugadas[1] = $("#numBolJugadaB").val() != "" ? $("#numBolJugadaB").val() : null;
						jugadas[2] = $("#numBolJugadaC").val() != "" ? $("#numBolJugadaC").val() : null;
						jugadas[3] = $("#numBolJugadaD").val() != "" ? $("#numBolJugadaD").val() : null;
						importPagar = parseFloat($("#importePagar").val());
						jugadaActuales = $("#jugadasActuales").val();
						var cupon =  "undefined"; 
						var precioReal = parseFloat($("#formatPricePerPlay2").val());
						if(precioReal >= importPagar/jugadaActuales){
							cupon = $("#promotionMessage").val();
						}
						if(jugadaActuales < $("#jugadasGratis").val()){
							cupon = "Jugadas Gratis";
						}

						datalayerPurchase(jugadas,
										importPagar/jugadaActuales,
										importPagar,
										'Tinka-'+$("#ticketId").val(),
										cupon);
						tagginGraciasCompraSlider();
						tagginPrepararParametrosTK();
					} else {
						var alertPlay = $("#alertPlay").val();
						taggingJugadaNoProcesada(alertPlay);
						datalayerErrores('Gracias por tu Compra','Paso 3','Compra',alertPlay);
					}

				} else {
					if (status == "ok") {
						tagginGraciasCompraSlider();
					} else {
						var alertPlay = $("#alertPlay").val();
						taggingJugadaNoProcesada(alertPlay);
						datalayerErrores('Gracias por tu Compra','Paso 3','Compra',alertPlay);
					}
				}	
			}
		});
	</script>
</body>
</html>