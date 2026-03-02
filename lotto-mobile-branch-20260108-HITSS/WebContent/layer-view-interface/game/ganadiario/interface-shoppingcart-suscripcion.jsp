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
	<title>Ganadiario : Mi Boleto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script> 
	<meta name="description" content="Ganadiario Megabol móvil, boleto de jugada realizada" />
</head>
	
</head>
<body class="main-ganadiario" onload="deshabilitaRetroceso()">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Gana Diario" id="Zona">
	<input type="hidden" value="Combos Gana Diario" id="SubZona">
	
	<input type="hidden" id="numeroCombo" value="${draws}"/>
	<input type="hidden" id="precioFinalCombo" value="${formatDiscountPayment2}"/>
	<input type="hidden" id="jugadasActuales" value="${jugadasActuales}"/>
	
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<a href="#" id="game_ganadiario_show_menu">
							<img src="layer-view-image/v2/logo-ganadiario.png" alt="tinka">
						</a>
							<div class="center_f titular_centerF">
								<div class="row_uno">
								    <div class="contentRow ganadiario2">
									   	<div class="primeraparteF3">
											<h3>${draws}</h3>
											<span class="h3F3">Sorteos</span>
											<span class="tipo_sorteoF">
												${months} mes<c:if test="${months>1}">es</c:if>	
											 </span>
										</div>
									</div>
								</div>
							</div>
							<div class="titularf jaguarF">
								<h2>Tu jugada para todos los sorteos</h2>
							</div>
							
						
						<div class="boxes-game-ticket">
							<div class="box-game-ticket border_bottom_green">
								<div class="my-games">
								
									<c:forEach 	var="item"  items="${boleto}">

											<div class="my-game">
										
												<div class="hide" id="results1">${item.value.ganadiario}</div>
												<div id="resultsview1" class="results-balls playing clearfix"></div>
												<div class="game-options">
													<a href="#" class="game-option ico ico-close" onclick="datalayerRemover();taggingCombosGanadiarioRemove();window.location.href='game_ganadiario_delete_bet.html?id=${item.key}';">
														<svg version="1.1" xmlns="http://www.w3.org/2000/svg" width="512" height="512" viewBox="0 0 512 512">
															<title>delete</title>
															<path d="M491.536 108.384l-147.152 148.048 147.152 147.168c6.16 6.144 6.16 16.112 0 22.272l-66.816 66.8c-6.128 6.16-16.096 6.16-22.256 0l-146.912-146.912-146.032 146.912c-6.144 6.16-16.112 6.16-22.272 0l-66.8-66.8c-6.144-6.16-6.144-16.128 0-22.272l146.032-146.912-146.016-146.016c-6.144-6.144-6.144-16.112 0-22.272l66.8-66.8c6.144-6.16 16.112-6.16 22.272 0l145.76 145.76 147.184-148.048c6.16-6.16 16.128-6.16 22.256 0l66.816 66.8c6.128 6.16 6.128 16.128-0.016 22.272z"></path>
														</svg> Eliminar
													</a>
												</div>
												<c:if test="${fn:length(item.value.ganadiario)<5}">
													<div class="game-alert">
														<p>Debe elegir por lo menos cinco opciones en Ganadiario</p>
													</div>
												</c:if>
											</div>

									</c:forEach>

								</div>
							</div>


						</div>



						<div class="footer-game">
							
							<div class="game-actions">

								<div class="precios_regularf" style="float:none">
									<div class="centrar_preciosf">
										<ul>
											<li>
												<span class="td_r2">Precio Regular:</span>
												<span class="td_f2">${formatRegularPayment}</span>
											</li>
											<li>
												<span class="td_r2">Total de jugadas:</span>
												<span class="td_f2">${jugadasActuales}</span>
											</li>
											<li>
												<span class="td_r2">Descuento:</span>
												<span class="td_f2">${discount}</span>
											</li>
										</ul>
										<span class="line_f"></span>
										<ul>
											<li>
												<span class="td_r2">Precio Final:</span>
												<span class="td_f2">${formatDiscountPayment}</span>
											</li>
										</ul>
																			
										<a class="js-modal moretag" href="#popup_terms" data-modal="#popup_terms" id="popup_terms_modal">Infórmate de los términos y condiciones</a>									
									</div>
								</div>
								
								<div class="game-actions">

									<c:if test="${!empty clientId && agreement!=''}">
										<c:if test="${indicadorPurchase==negacion}">
											<button type="button" id="btn_mobile_comprar_combo_ganadiario" class="btn btn-red float-bottom">COMPRAR</button>
										</c:if>
									
										<c:if test="${indicadorPurchase==afirmacion}">
											<form action="game_ganadiario_play_bet_result_suscription.html" method="post" id="game_ganadiario_play_bet_result_suscription">
												<input id="play" name="boleto" type="hidden" value="boleto_${draws}">								
												<button type="button" id="btn_mobile_comprar_combo_ganadiario_s" class="btn btn-red float-bottom">COMPRAR</button>
											</form>
										</c:if>
									</c:if>
									
									<c:if test="${empty clientId or agreement==''}">
										<c:if test="${indicadorPurchase==negacion}">
											<button type="button" id="btn_mobile_comprar_combo_ganadiario" class="btn btn-red float-bottom">COMPRAR</button>
										</c:if>
	
										<c:if test="${indicadorPurchase==afirmacion}">
											<form action="security_login_execute_authentication.html">
												<input  name="boleto" type="hidden" value="boleto_${draws}">
												<input  name="display" type="hidden" value="ganadiarioSuscripcion">								
												<button type="button" id="btn_mobile_comprar_combo_ganadiario" class="btn btn-red float-bottom">COMPRAR</button>
											</form>
										</c:if>
									</c:if>

								</div>
								<br><br><br><br>
								<div id="popup_terms" class="overlay">
									<div class="popup popup-sm" style="height: 95%;">
										<a class="js-close-modal close" href="#">&times;</a>
										<div class="wrap-modal">
											<jsp:include page="../../client/interface-term-ganadiario-subscription.jsp"/>
										</div>
									</div>
								</div>
							</div>
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
			$("#terminos").on("click",function(){
				$(".popupcrop").addClass("open");
			});
			$(".closepopupc, .close_pop").on("click",function(){
				$(".popupcrop").removeClass("open");
			});
			var jugadas = [$("#results1").text(),null,null,null];
			var importPagar = $("#precioFinalCombo").val();
			var jugadasActuales = $("#jugadasActuales").val();
			var draws =$("#numeroCombo").val();
			if(draws!=undefined && draws!=null && draws!=''){
				var name="Gana Diario Combo "+draws+" jugadas"
				var id="ganaC"+draws;
				var price =$("#precioFinalCombo").val();
				datalayerAddToCart(jugadas,importPagar/jugadasActuales,'Elige 5 números o más');
				taggingCombosGanadiarioFinaliza(draws);
				taggingCombosGanadiarioEEcheckout(name,id,price);
			}	
		});

		function datalayerRemover(){
			var jugadas = [$("#results1").text(),null,null,null];
			var importPagar = $("#precioFinalCombo").val();
			var jugadasActuales = $("#jugadasActuales").val();
			datalayerRemoveFromCart(jugadas,importPagar/jugadasActuales,'Tu jugada para todos los sorteos');
		}
		
		function taggingCombosGanadiarioRemove(){
			try {
				var draws =$("#numeroCombo").val();
				if(draws!=undefined && draws!=null && draws!=''){
					var name="Gana Diario Combo "+draws+" jugadas"
					var id="ganaC"+draws;
					var price =$("#precioFinalCombo").val();
					price=parseFloat(price).toFixed(2);
					
					window.dataLayer = window.dataLayer || [ ];
					dataLayer.push({
					  'event': 'EEremoveFromCart',
					  'ecommerce': {
					    'remove': {                             
					      'products': [{                          
					          'name': name,
					          'id': id,
					          'price': price,  //Indicar el precio de la jugada que se está eliminando.
					          'brand': 'Juegos',
					          'quantity': '1',
					          'category': 'Gana Diario'
					       }]
					    }
					  }
					});
					console.log("Tagging taggingCombosGanadiarioRemove: name:"+name+", id:"+id+", price:"+price);	
				}
			} catch (e) {
				console.error(e);
			}
		}
		
		function deshabilitaRetroceso(){
			window.location.hash="no-back-button";
		    window.location.hash="Again-No-back-button" //chrome
		    window.onhashchange=function(){window.location.hash="no-back-button";}
		}

		$("#popup_terms_modal").on('click',function(){
			datalayerMisJugadas(this,'Tu jugada para todos los sorteos','Informarse T&C','Link','Paso 3');
		});

		$(document).delegate('#btn_mobile_comprar_combo_ganadiario', 'click', function() {
			var btnComprarComboGanadiario = this;
			var jugadas = [$("#results1").text(),null,null,null];
			var importPagar = $("#precioFinalCombo").val();
			var jugadasActuales = $("#jugadasActuales").val();
			document.forms["game_ganadiario_play_bet_result_suscription"].submit();
			datalayerMisJugadas(btnComprarComboGanadiario,'Tu jugada para todos los sorteos','Comprar','Button','Paso 3');
			datalayerCheckout(jugadas,importPagar/jugadasActuales);
			goSecurityLoginExecuteSus($("input[name='display']").val(), $("input[name='boleto']").val());
		});

		var btnComprarComboGanadiarioS = null;
		
		$(document).delegate('#btn_mobile_comprar_combo_ganadiario_s', 'click', function() {
			btnComprarComboGanadiarioS = this;
			// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
			// es una function que se realizará en caso no tenga docs pendientes de confirmacion
			mainValidatePendingsDocsForAproval('interfaceShoppingcartSuscripcionComprarComboGanaDiarioS');
		});

		function interfaceShoppingcartSuscripcionComprarComboGanaDiarioS() {
			var jugadas = [$("#results1").text(),null,null,null];
			var importPagar = $("#precioFinalCombo").val();
			var jugadasActuales = $("#jugadasActuales").val();
			document.forms["game_ganadiario_play_bet_result_suscription"].submit();
			datalayerMisJugadas(btnComprarComboGanadiarioS,'Tu jugada para todos los sorteos','Comprar','Button','Paso 3');
			datalayerCheckout(jugadas,importPagar/jugadasActuales);
		}

		window.addEventListener("message", function(event) {
		    if (event.data === "interfaceShoppingcartSuscripcionComprarComboGanaDiarioS") {
		    	interfaceShoppingcartSuscripcionComprarComboGanaDiarioS(); 
		    }
		});

		
	</script>
		
</body>
</html>