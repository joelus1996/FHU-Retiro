<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
	<script>dataLayer =[{'loginStatus': 'Sesi�n no iniciada','clientid': getClientID(),}];</script>
	<script>
	window.onload = function () {
		if(document.getElementById("clientId").value){
			dataLayer.splice(0,1,{
				'loginStatus': 'Sesi�n iniciada',
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
	<title>Tinka-Express</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
    <!-- Tinka Express Iframe -->
    <link rel="stylesheet" href="layer-view-style/game/tinka/tinkaexpress-iframe.css?v=1.0" />
    <link rel="stylesheet" href="layer-view-style/game/tinka/dialog.min.css?v=1.0" />
    
</head>
<body class="main-tinka">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<input type="hidden" id="typeBoleto" value="${typeBoleto}"/>
		
		<jsp:include page="../../include/header.jsp" />
		
		<input type="hidden" value="Loterias" id="TipoZona">
		<input type="hidden" value="Tinka" id="Zona">
		<input type="hidden" id="SubZona" value="undefined">

		<div class="content-wrap">
			<div class="content">
				<!-- Tinka Express iFramme -->
		        <iframe
		          class="tinka-express-iframe"
		          id="tinkaExpressIframe"
		          title="Tinka Express"
		          allowfullscreen="true"
		          allowpaymentrequest="true"
		          border="0"
		          src="${iframeSrc}"
		        ></iframe>
			</div>
		</div>
	</div>
	
	<!-- Modal Alert -->
    <div role="presentation" class="Dialog-root" id="tinka-express-alert-dialog">
      <div aria-hidden="true" class="Dialog-backdrop" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;"></div>
      <div class="Dialog-container" role="presentation" tabindex="-1" style="opacity: 1; transition: opacity 225ms cubic-bezier(0.4, 0, 0.2, 1) 0ms;">
        <div class="Dialog-paper AlertDialog-paper" role="dialog" aria-labelledby="alert-dialog">
          <div class="Dialog-content AlertDialog-content">
            <div class="AlertDialog-header">
              <button type="button" class="Dialog-close" id="alert-dialog-close" tabindex="0">
                <i class="icon">
                  <svg width="32" height="32" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  	<path d="M6 6L18 18M18 6L6 18" stroke="currentColor" stroke-width="1.6" stroke-linecap="round" stroke-linejoin="round"></path>
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
                  <svg width="32" height="32" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                  	<path d="M6 6L18 18M18 6L6 18" stroke="currentColor" stroke-width="1.6" stroke-linecap="round" stroke-linejoin="round"></path>
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
<%--       src="${urlTinkaExpress}checkout-button" --%>
<!--       loading="lazy" -->
<!--       frameborder="0" -->
<!--       allowtransparency="true" -->
<!--       allow="encrypted-media" -->
<!--       style="width: 100vw; height: 100vh; min-width: 100%; overflow: hidden;" -->
<!--     ></iframe> -->

<script type="text/javascript" src="layer-view-script/game/tinka/iframeResizer.min.js?v=1.0"></script>
<!-- <script type="text/javascript" src="layer-view-script/game/tinka/dialogs.js?v=1.0"></script> -->
<script type="text/javascript" src="layer-view-script/game/tinka/tinkaexpress-iframe.js?v=1.4"></script>

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