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
	<title>Gana Diario : Realizar apuesta</title>	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script> 
	<meta name="description" content="Gana Diario móvil, realiza la apuesta del juego" />
	
</head>
<body class="main-ganadiario">


	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Gana Diario" id="Zona">
	<input type="hidden" value="Combos Gana Diario" id="SubZona">
	
	<input type="hidden" id="ganadiarioJugadas" value="${ganadiarioJugadas}"/>
	<input type="hidden" id="ganadiarioOvercomeJugadas" value="${ganadiarioOvercomeJugadas}"/>    
	<input type="hidden" id="typeBoleto" value="${typeBoletoTemp}"/>
	<input type="hidden" id="numeroCombo" value="${draws}"/>
	<input type="hidden" id="precioFinalCombo" value="${formatDiscountPayment2}"/>
	
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
						<div class="game-desc">
							<h2 class="white">ELIGE 5 NÚMEROS O MÁS</h2>							
						</div>
						<form action="game_ganadiario_add_bet.html" method="post" id="game_ganadiario_add_bet">
							<div class="body-game">
								<div class="button-group checkboxes-ball clearfix">
									<label>
									  <input type="checkbox" name="gd" value="1" id="gd_chk_1"/><span class="button-group-item" for="gd_chk_1"><span class="label-item">1</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="2" id="gd_chk_2"/><span class="button-group-item" for="gd_chk_2"><span class="label-item">2</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="3" id="gd_chk_3"/><span class="button-group-item" for="gd_chk_3"><span class="label-item">3</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="4" id="gd_chk_4"/><span class="button-group-item" for="gd_chk_4"><span class="label-item">4</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="5" id="gd_chk_5"/><span class="button-group-item" for="gd_chk_5"><span class="label-item">5</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="6" id="gd_chk_6"/><span class="button-group-item" for="gd_chk_6"><span class="label-item">6</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="7" id="gd_chk_7"/><span class="button-group-item" for="gd_chk_7"><span class="label-item">7</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="8" id="gd_chk_8"/><span class="button-group-item" for="gd_chk_8"><span class="label-item">8</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="9" id="gd_chk_9"/><span class="button-group-item" for="gd_chk_9"><span class="label-item">9</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="10" id="gd_chk_10"/><span class="button-group-item" for="gd_chk_10"><span class="label-item">10</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="11" id="gd_chk_11"/><span class="button-group-item" for="gd_chk_11"><span class="label-item">11</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="12" id="gd_chk_12"/><span class="button-group-item" for="gd_chk_12"><span class="label-item">12</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="13" id="gd_chk_13"/><span class="button-group-item" for="gd_chk_13"><span class="label-item">13</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="14" id="gd_chk_14"/><span class="button-group-item" for="gd_chk_14"><span class="label-item">14</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="15" id="gd_chk_15"/><span class="button-group-item" for="gd_chk_15"><span class="label-item">15</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="16" id="gd_chk_16"/><span class="button-group-item" for="gd_chk_16"><span class="label-item">16</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="17" id="gd_chk_17"/><span class="button-group-item" for="gd_chk_17"><span class="label-item">17</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="18" id="gd_chk_18"/><span class="button-group-item" for="gd_chk_18"><span class="label-item">18</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="19" id="gd_chk_19"/><span class="button-group-item" for="gd_chk_19"><span class="label-item">19</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="20" id="gd_chk_20"/><span class="button-group-item" for="gd_chk_20"><span class="label-item">20</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="21" id="gd_chk_21"/><span class="button-group-item" for="gd_chk_21"><span class="label-item">21</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="22" id="gd_chk_22"/><span class="button-group-item" for="gd_chk_22"><span class="label-item">22</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="23" id="gd_chk_23"/><span class="button-group-item" for="gd_chk_23"><span class="label-item">23</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="24" id="gd_chk_24"/><span class="button-group-item" for="gd_chk_24"><span class="label-item">24</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="25" id="gd_chk_25"/><span class="button-group-item" for="gd_chk_25"><span class="label-item">25</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="26" id="gd_chk_26"/><span class="button-group-item" for="gd_chk_26"><span class="label-item">26</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="27" id="gd_chk_27"/><span class="button-group-item" for="gd_chk_27"><span class="label-item">27</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="28" id="gd_chk_28"/><span class="button-group-item" for="gd_chk_28"><span class="label-item">28</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="29" id="gd_chk_29"/><span class="button-group-item" for="gd_chk_29"><span class="label-item">29</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="30" id="gd_chk_30"/><span class="button-group-item" for="gd_chk_30"><span class="label-item">30</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="31" id="gd_chk_31"/><span class="button-group-item" for="gd_chk_31"><span class="label-item">31</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="32" id="gd_chk_32"/><span class="button-group-item" for="gd_chk_32"><span class="label-item">32</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="33" id="gd_chk_33"/><span class="button-group-item" for="gd_chk_33"><span class="label-item">33</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="34" id="gd_chk_34"/><span class="button-group-item" for="gd_chk_34"><span class="label-item">34</span></span>
									</label>
									<label>
									  <input type="checkbox" name="gd" value="35" id="gd_chk_35"/><span class="button-group-item" for="gd_chk_35"><span class="label-item">35</span></span>
									</label>
								</div>
							</div>
						</form>
						<div class="game-actions">
							<button type="button" id="clean" class="btn btn-purple">LIMPIAR</button>
							<button type="button" id="btn_mobile_agregar_boleto_ganadiario" class="btn btn-red float-bottom">SIGUIENTE</button>
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

	<script type="text/javascript">

		$(document).ready(function () {
			 // $.mobile.defaultPageTransition = 'none';
			var numeroCombo=$("#numeroCombo").val();
			taggingCombosGanadiarioBet(numeroCombo);
			
			var $limiteJugadas = $('#ganadiarioJugadas').val();
			var $overcomeJugadas = $('#ganadiarioOvercomeJugadas').val();
			var bets=0;
			if($overcomeJugadas==1){
					desplegarModal('Máximo '+ $limiteJugadas +' jugadas'); 
					taggingPopupError('Máximo '+ $limiteJugadas +' jugadas');
			}
			
			var btnAgregarBoletoGanadiario = null;
			$(document).delegate('#btn_mobile_agregar_boleto_ganadiario', 'click', function() {		
				btnAgregarBoletoGanadiario = this;   
				// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
				// es una function que se realizará en caso no tenga docs pendientes de confirmacion
				mainValidatePendingsDocsForAproval('interfaceBetSuscripcionAgregarBoletoGanadiario');
			});

			function interfaceBetSuscripcionAgregarBoletoGanadiario() {
				if(bets==0) {
					desplegarModal('No ha realizado ninguna jugada');
					var nombreJuego="Error :: Gana Diario";
					taggingCombosGanadiarioError(nombreJuego,'No ha realizado ninguna jugada');
					datalayerErrores('Elige 5 números o más','Paso 1','Jugar','No ha realizado ninguna jugada');
				} else {
					var numeroCombo =$("#numeroCombo").val();
					if(numeroCombo!=undefined && numeroCombo!=null && numeroCombo!=''){
						var name="Gana Diario Combo "+numeroCombo+" jugadas";
						var id="ganaC"+numeroCombo;
						var price=$("#precioFinalCombo").val();
						taggingCombosGanadiarioAddToCart(name,id,price);
					}
					
					document.forms["game_ganadiario_add_bet"].submit();
					datalayerTinkaJugada(btnAgregarBoletoGanadiario,'Elige 5 números o más','Button','Jugar','Paso 2');  
				}
			}

			window.addEventListener("message", function(event) {
			    if (event.data === "interfaceBetSuscripcionAgregarBoletoGanadiario") {
			    	interfaceBetSuscripcionAgregarBoletoGanadiario(); 
			    }
			});
						
			var countballs = 0;
		    var count=0;
		 	$(document).delegate('#clean', 'click', function() { 
	 			$(".f_error_mensaje").hide();
			    	$("input[type=checkbox]:checked").each(
			  		function() {
			  			$("#div_"+$(this).attr('id')).val();	
				  		$("#div_"+$(this).attr('id')).removeClass("button_select");
			  	 		$(this).prop('checked', false);
				   	}
				);
		    	bets=0;
		    	countballs=0;
		    	count=0;
		    	datalayerTinkaJugada(this,'Elige 5 números o más','Button','Jugar','Paso 2');
		  	});
			/*
			var count=0;	
	
	
			    $(document).delegate('#clean', 'click', function() {               
			    	$("input[type=checkbox]:checked").each(
					  function() { 
					  	$(this).attr('checked', false);
					  	 // $(this).attr('checked', false).checkboxradio('refresh');
					   }
					);  
			    	count=0; 	  	   	
			  });
			*/
	
			function bin_newton(cantidad) {
		        var deduct_1 = 1;
		        var deduct_2 = 1;
		        var count_2 = cantidad - 5;
		        variable = factorial(cantidad) / (120 * (factorial(count_2)));
		        return variable
		    }
		 
			function factorial(cantidad) {
			        if (cantidad < 0)return 0; else if (cantidad > 1)return cantidad * factorial(cantidad - 1);
			        return 1
			}
			
	        $(".close_f").on("click",function(){
				$(".f_error_mensaje").hide();
			});
	
	        var aux = 0;
		  	$(' .checkboxes-ball input').on( 'change', function() {
		  		$(".f_error_mensaje").hide();
		  		var $this = $( this );
		  		var countballs = 0;
		  		//if ($this.is(':checked')){
		  			$this.closest('label').addClass('checkedlabel');
		  			//countballs++;
		  			$("input[type=checkbox]:checked").each(
			  			function() {
			  				countballs++;
			  			}
					  );
		  			if (countballs > 5) {
		  				var jugadas = bin_newton(countballs);
		  				if (jugadas>$limiteJugadas) {		  						
		  					$this.prop('checked',false);
		  					desplegarModal('Máximo '+$limiteJugadas+' jugadas');
		  					taggingPopupError('Máximo '+$limiteJugadas+' jugadas');
		  				} else {
		  					bets=bin_newton(countballs);
				  		}
		  			} else if (countballs > 4) {
	  					bets=bin_newton(countballs);
			  		}
		  		/*}	
				else {
				    countballs--;
				    if(countballs>=5) bets=bin_newton(countballs);
				    else bets=0;
				    $this.closest('label').removeClass('checkedlabel');		    
				}*/	  		
		  	});
	
	        $(document).delegate('[type=checkbox]', "change", function( e ) {
	       		if($(this).attr('id').substring(0,2)=='gd') {
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
	
	        $(document).delegate('#game_ganadiario_show_menu', 'click', function () {
	            window.location.href = 'game_ganadiario_show_menu.html';
	       });
	
	       function desplegarModal(mensaje){
				$(".f_error_mensaje").show();
				$(".f_textoInterno").html(mensaje);				
			}
			});	
				/*
				    
				   $(document).delegate('[type=checkbox]', "change", function( e ) {	      
				           if($(this).attr('id').substring(0,2)=='gd'){
					            if ( $(this).is(":checked") ){  
					                   count ++;
					                   if(count > 15){                                                              	
					                   	$(this).attr('checked',false);
					                   	count --;  
					                   }                  
					            }
					            else 
					            {
					              count --;  
					            }
				            }    
				    });
				 */   
	</script>
	
</body>
</html>