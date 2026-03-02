<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	<title>Jugar Kábala Online | Comprar Kábala en línea</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script> 
	<meta name='description' content="Juega La Kábala en línea de forma sencilla y segura. Compra La Kábala en nuestra plataforma de forma totalmente online. ¡Entra ahora y empieza a ganar!" />
	
</head>
<body class="main-kabala">
<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Kábala" id="Zona">
	<input type="hidden" value="Combos Kábala" id="SubZona">
	
	<h1 style="display: none;">Jugar Kábala Online</h1>
   <input type="hidden" id="numeroBolilla" value="${draws}"/>
   <input type="hidden" id="precioFinal" value="${formatDiscountPayment}"/>
   <input type="hidden" id="precioFinalCombo" value="${formatDiscountPayment2}"/>
   
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<!-- esta no debe ser la accion a enviarser 
							debe de realizar de tal forma que al escoger entre elige tu jugada y al azar cambie el action
							del form-->
							<a href="#" id="game_kabala_show_menu">
								<img src="layer-view-image/v2/logo-kabala.png" alt="resultados kabala">
							</a>
							<div class="center_f titular_centerF">
								<div class="row_uno">
								    <div class="contentRow kabala2">
									   	<div class="primeraparteF2">
											<h3>${draws}</h3>
											<span class="h3F">Sorteos</span>
											<span class="tipo_sorteoF">
												${months} mes<c:if test="${months>1}">es</c:if>	
											 </span>
										</div>
									</div>
								</div>
							</div>
							
							<div class="contentRFT">
							<div class="titularf">
							<h2>¿Cómo quieres jugar?</h2>
							</div>
							<div class="row_trop">
								<div class="left_verde">
									<h3 style="pointer-events: none;">Elige tu jugada</h3>
									<div class="red_core" style="pointer-events: none;">
										Esta será tu jugada para todos los sorteos
									</div>
								</div>
								<div class="right_amarillo">
									<h3>Jugada al azar</h3>
									<div class="red_core">
										Se generará una jugada al azar para cada sorteo.
									</div>
								</div>
								<div class="precios_regularf">
									<div class="centrar_preciosf">
									    <div class="content_preciosrregular">
											<ul>
												<li>
													<span class="td_r">Precio Regular:</span>
													<span class="td_f3">${formatRegularPayment}</span>
												</li>
												<li>
													<span class="td_r">Total de jugadas:</span>
													<span class="td_f3">${jugadas}</span>
												</li>
												<li>
													<span class="td_r">Descuento:</span>
													<span class="td_f3">${discount}</span>
												</li>
											</ul>
											<span class="line_f"></span>
											<ul>
												<li>
													<span class="td_r">Precio Final:</span>
													<span class="td_f3">${formatDiscountPayment}</span>
												</li>
											</ul>
										</div>
										<div style="font-size: 14px;padding-bottom: 8px;margin-right: -31px;margin-left: -30px;">
											Las jugadas se generarán de manera automática y serán 
											enviadas con los resultados de cada sorteo a tu correo 
											registrado. También podrás revisarlas en tu Cuenta.
										</div>
										<a class="js-modal" href="#popup_terms" data-modal="#popup_terms" id="popup_terms_modal">Ver términos y condiciones aquí</a>									
									</div>
								</div>
								<form action="game_kabala_show_bet_suscripcion.html" id="formdefault">
									<input id="playdefault" name="boleto" type="hidden" value="boleto_${draws}">								
<!-- 									<button type="submit" class="btn btn-red">SIGUIENTE</button><br> -->
									<button type="submit" class="btn btn-red float-bottom" id="formdefaultButton">SIGUIENTE</button>
								</form>
								<div id="formalazar" style="display:none">
									<div class="game-actions">

										<c:if test="${!empty clientId && agreement!=''}">
											<c:if test="${indicadorPurchase==negacion}">
												<button id="btn_mobile_comprar_combo_kabala" type="button" class="btn btn-red float-bottom">COMPRAR</button>
											</c:if>
										
											<c:if test="${indicadorPurchase==afirmacion}">
												<form action="game_kabala_play_bet_result_suscription.html" method="post" id="game_kabala_play_bet_result_suscription_res_susc">
													<input id="play" name="boleto" type="hidden" value="boleto_${draws}">								
													<button id="btn_mobile_comprar_combo_kabala" type="button" class="btn btn-red float-bottom">COMPRAR</button>
												</form>
											</c:if>
										</c:if>
										
										<c:if test="${empty clientId or agreement==''}">
											<c:if test="${indicadorPurchase==negacion}">
												<button id="btn_mobile_comprar_combo_kabala" type="button" class="btn btn-red float-bottom">COMPRAR</button>
											</c:if>
		
											<c:if test="${indicadorPurchase==afirmacion}">
												<form action="security_login_execute_authentication.html">
													<input  name="boleto" type="hidden" value="boleto_${draws}">
													<input  name="display" type="hidden" value="kabalaSuscripcion">								
													<button id="btn_mobile_comprar_combo_kabala_login" type="button" class="btn btn-red float-bottom">COMPRAR</button>
												</form>
											</c:if>
										</c:if>

									</div>
								</div>
								<div id="popup_terms" class="overlay">
									<div class="popup popup-sm"  style="height: 95%;">
										<a class="js-close-modal close" href="#">&times;</a>
										<div class="wrap-modal">
											<jsp:include page="../../client/interface-term-kabala-subscription.jsp"/>
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
		var clickAzar = 0;
		$(document).ready(function () {	
			var btnComprarComboKabalaSeleccion = null;
			$(document).delegate('#btn_mobile_comprar_combo_kabala', 'click', function() {
				btnComprarComboKabalaSeleccion = this;
				// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
				// es una function que se realizará en caso no tenga docs pendientes de confirmacion
	 			mainValidatePendingsDocsForAproval('interfaceSuscripcionTypeComprarComboKabala');
			});

			$(document).delegate('#btn_mobile_agregar_boleto_kabala', 'click', function() {
				// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
				// es una function que se realizará en caso no tenga docs pendientes de confirmacion
				mainValidatePendingsDocsForAproval('interfaceSuscripcionTypeAgregarBoletoKabala');
			});
			
			window.addEventListener("message", function(event) {
			    if (event.data === "interfaceSuscripcionTypeAgregarBoletoKabala") {
			    	document.forms["game_kabala_add_bet"].submit();
			    } else if (event.data === "interfaceSuscripcionTypeComprarComboKabala") {
			    	document.forms["game_kabala_play_bet_result_suscription_res_susc"].submit();
				}
			}); 

			$("#terminos").on("click",function(){
				$(".popupcrop").addClass("open");
			});
			$(".closepopupc, .close_pop").on("click",function(){
				$(".popupcrop").removeClass("open");
			});
			//var valorRen = 0;
			$(".content_preciosrregular").hide();
			$(".right_amarillo").on("click",function(){
				$(".left_verde").addClass("transparente");
				$(".right_amarillo").addClass("verdeF");
				$("#formdefault").hide();
				$("#formalazar").show();
				$(".content_preciosrregular").show();
				clickAzar++;
				var numeroCombo =$("#numeroBolilla").val();
				datalayerTinkaJugada('Jugada al azar','¿Cómo quieres jugar?','Card','Elegir Tipo Jugada');
				if(numeroCombo!=undefined && numeroCombo!=null && numeroCombo!=''){
					var name="Kabala Combo "+numeroCombo+" jugadas";
					var id="kabalaC"+numeroCombo;
					var price=$("#precioFinalCombo").val();
					taggingCombosKabalaAddToCart(name,id,price);//paso1
					taggingKabalaVirtualPageView2a(numeroCombo);//paso2
					taggingCombosKabalaEEcheckout(name,id,price);//paso3	
				}
			});
			$(".left_verde").on("click",function(){
				$(".left_verde").removeClass("transparente");
				$(".right_amarillo").removeClass("verdeF");
				$("#formdefault").show();
				$("#formalazar").hide();
				$(".content_preciosrregular").hide();
				datalayerTinkaJugada('Elige tu Jugada','¿Cómo quieres jugar?','Card','Elegir Tipo Jugada');
				var numeroCombo =$("#numeroBolilla").val();
				var name="Kabala Combo "+numeroCombo+" jugadas";
				var id="kabalaC"+numeroCombo;
				var price=$("#precioFinalCombo").val();
				if(clickAzar>0){
					if(numeroCombo!=undefined && numeroCombo!=null && numeroCombo!=''){
						taggingCombosKabalaRemoveFromCart(name,id,price);	
					}
					clickAzar=0;
				}
			});
			
			var numeroCombo=$('#numeroBolilla').val();
			taggingCombosKabala(numeroCombo);
		});

		var count=0;
	    $(document).delegate('#clean', 'click', function() { 

	    	$("input[type=checkbox]:checked").each(
		  		function() {	
			  		$("#div_"+$(this).attr('id')).removeClass("button_select");
		  	 		$(this).attr('checked', false);
			   	}
			);
	    	count=0;
	  	});
		    
		$(document).delegate('#azar', 'click', function() {
			$("input[type=checkbox]:checked").each(
			  	function() {		
				 	$("#div_"+$(this).attr('id')).removeClass("button_select");	 
			  	 	$(this).attr('checked', false);
			   	}
			);
		 	var count_random_tinka=0;
		 	var array_random = new Array();		
		 	while(count_random_tinka<6){	
		    	var number =Math.round(1+(Math.random()*(45-1)));
		    	if(array_random.indexOf(number) == -1) {//if (jQuery.inArray(number,array_random) == -1) {
	         	 	array_random[count_random_tinka] = number;	         			         	 	 
                    count_random_tinka ++;
                    $("#div_tk_chk_"+number).addClass("button_select");
                    $("#tk_chk_"+number).attr('checked', true);
		      	}
			}
			 /*mgRandon=Math.round(1+(Math.random()*(5-1)));
			 $("#div_mg_chk_"+mgRandon).addClass("button_select"); 		 
			 $("#mg_chk_"+mgRandon).attr('checked', true);
			 	
			for (var i=0; i<array_random.length; i++){		   
				$("#tk_chk_"+array_random[i]).attr('checked', true);
			}*/
			count=6;  
		});
	   	$(document).delegate('[type=checkbox]', "change", function( e ) {

       		if($(this).attr('id').substring(0,2)=='tk') {
	            if ( $(this).is(":checked") ){
                   	count ++;		                    
               		if(count > 12) {
               			$(this).attr('checked',false);   
                   		count --;  
                   	} else {
                	   $("#div_"+$(this).attr('id')).addClass("button_select"); 		                	  
	                }                 
	            } else {
            		$("#div_"+$(this).attr('id')).removeClass("button_select"); 		            	
              		count --;
	            }
            }

           	if ($(this).attr('id').substring(0,2)=='mg') {
	            if ( $(this).is(":checked") ){
	            	$("#div_"+$(this).attr('id')).addClass("button_select"); 			                                 
	            } else {
            		$("#div_"+$(this).attr('id')).removeClass("button_select"); 		               
	            }
            }       
		});

	   $(document).delegate('#game_kabala_show_menu', 'click', function(e){
	   		e.preventDefault();
	   		window.location.href ='game_kabala_show_menu.html';
	   	});

	   $("#popup_terms_modal").on('click',function(){
		   //if()
	   		datalayerTinkaJugada(this,'¿Cómo quieres jugar?','Link','Informarse T&C');
		   //else
			   
		});

	   $("#formdefaultButton").on('click',function(){
			datalayerTinkaJugada(this,'¿Cómo quieres jugar?','Button','Siguiente');
		});

	   $(document).delegate('#btn_mobile_agregar_boleto_tinka', 'click', function() {
		   datalayerMisJugadas(this,'¿Cómo quieres jugar?','Comprar','Button','Paso 3');
		});
	   
	   $("#btn_mobile_comprar_combo_kabala_login").on('click',function(){
		   datalayerMisJugadas(this,'¿Cómo quieres jugar?','Comprar','Button','Paso 3');
		   goSecurityLoginExecuteSus($("input[name='display']").val(), $("input[name='boleto']").val());
		});

	</script>
	
</body>
</html>