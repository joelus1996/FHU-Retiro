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
	<title>Kinelo: Gracias por su compra</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Kinelo mÃ³vil, gracias por su compra" />
	
                 <script type="text/javascript" src="layer-view-script/funcionesTaggingKinelo.js?v=1"></script>  
</head>
<body class="main-kinelo">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<input type="hidden" id="alertPlay" value="${alertPlay}">
		<input type="hidden" id="status" value="${status}">
	   
	    <input type="hidden" id="ticketId" value="${ticketId}">
	    <input type="hidden" id="importePagar" value="${importePagar}">
	    
	    <input type="hidden" id="multiplierBetAuxA" value="${multiplierBetAuxA}">
		<input type="hidden" id="multiplierBetAuxB" value="${multiplierBetAuxB}">
		<input type="hidden" id="num_drawAux" value="${num_drawAux}" > 
		<input type="hidden" id="numBolJugadaA" value="${numBolJugadaA}">
		<input type="hidden" id="numBolJugadaB" value="${numBolJugadaB}">
	    <input type="hidden" id="totalApuestas" value="${totalApuestas}">
	    <input type="hidden" id="jugadasGratis" value="${jugadasGratis}">
	    
	    <input type="hidden" id="simpleBetPrice" value="${kineloSale.simpleBetPrice}">
	    <input type="hidden" id="priceType" value="${kineloSale.priceType}">
		<input type="hidden" id="priceMessage" value="${kineloSale.priceMessage}">
	    
		<input type="hidden" value="result_game" id="view">

		<input type="hidden" value="Loterías" id="TipoZona">
		<input type="hidden" value="Kinelo" id="Zona">
		<input type="hidden" value="" id="SubZona">
			
		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<div class="logo-brand">
							<a href="game_kinelo_show_home.html">
								<img src="layer-view-image/game/kinelo/logo-kinelo.png">
							</a>
						</div>

						<div class="game-desc min-desc">
							<c:if test="${status == 'ok'}">
								
								<h2>GRACIAS POR TU COMPRA</h2>
								<br>
								<h3>OBTÉN PREMIOS</h3>
								<h1>HASTA <span>100,000</span></h1>
								<h3>VECES TU APUESTA</h3>
							</c:if>
							<c:if test="${status == 'error'}">
								<h2>En este momento estamos presentando problemas. Por favor intenta nuevamente más tarde</h2>
							</c:if>
							
							<c:if test="${status == 'autoexclusion'}">
								<h2>Límite de autoexclusión activado. Infórmate en la sección de <a href="client_edit_auto_control.html" onclick="window.location='client_edit_auto_control.html'">Autocontrol</a></h2>
							</c:if>
							
							<c:if test="${status == 'saldo'}">
								<h2>NO CUENTAS CON SALDO SUFICIENTE</h2><br/>
								<button id="kinelo-charge" class="btn lilac">RECARGA TU SALDO</button>
							</c:if>
						</div>

						<c:if test="${status == 'ok'}">
							<div class="wrapper-after-play">
								<div class="body-after-play">
									<div class="review-play">
										<h3>PUEDES REVISAR TU JUGADA EN:</h3>
										<button id="client_play_show_information" class="btn lilac">MIS JUGADAS</button>
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
										<button id="game_kinelo_show_shoppingcart" class="btn lilac">VOLVER</button>
									</div>
								</div>
							</div>
						</c:if>

					</div>
					<div class="footer-after-play">
						<jsp:include page="interface-result_game-cross-sell.jsp" />
					</div>
					<br><br>
				</section>
			</div>
		</div>
	</div>
 <input type="hidden" id="status2" value="${status}">
	<jsp:include page="../../include/footer.jsp" />
	<script >
		$(document).ready(function() {
			funcionesTaggingCompra();

			try {
				if($("#status").val() != 'ok') return;
				
				let jugada1 = ( $("#numBolJugadaA").val() != '0' && $("#numBolJugadaA").val() != '' ) ? [$("#numBolJugadaA").val()] : null;
				let jugada2 = ( $("#numBolJugadaB").val() != '0' && $("#numBolJugadaB").val() != '' ) ? [$("#numBolJugadaB").val()] : null;
				let jugadas = [jugada1,jugada2,null,null];
				let precioTotal = $("#importePagar").val();
				let ticketId = 'Kinelo-' + $("#ticketId").val();
				let precio = $("#simpleBetPrice").val();
				let cupon = 'undefined';
				if($("#priceType").val() != 'NOR')
					cupon = $("#priceMessage").val();
				
				datalayerPurchase(jugadas,precio,precioTotal,ticketId,cupon);
			} catch (error) {} 
			
		});
	
	</script>

</body>
</html>