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
	<title>Juega La Tinka Online | Comprar La Tinka en línea</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	
	<meta name='description' content="Juega La Tinka en línea de forma sencilla y segura. Compra La Tinka en nuestra plataforma de forma totalmente online. ¡Entra ahora y empieza a ganar!" />
	
	
    <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script>  
               
</head>
<body class="main-tinka">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<h1 style="display: none;">Jugar La Tinka Online</h1>
	<input type="hidden" id="tinkaJugadas" value="${tinkaJugadas}"/>
	<input type="hidden" id="tinkaOvercomeJugadas" value="${tinkaOvercomeJugadas}"/>
	<input type="hidden" id="cartTemp" value="${cartTemp}"/>		
	<input type="hidden" id="typeBoleto" value="${typeBoleto}"/>
	<input type="hidden" id="precioFinal" value="${formatDiscountPayment}"/>
	<input type="hidden" id="precioRegular" value="${formatRegularPayment}"/>
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Tinka" id="Zona">
	<input type="hidden" value="Juega Tinka" id="SubZona">
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<form action="game_tinka_add_bet.html" method="post" id="game_tinka_add_bet">
							<a href="#" id="game_tinka_show_menu">
								<img src="layer-view-image/v2/logo-tinka.png?v=3" alt="tinka">
							</a>
							<div class="game-desc">
								<h2>ELIGE 6 NÚMEROS O MÁS</h2>
								<h4>Jugada ${typePlay}</h4>
							</div>
							<div class="body-game">
								<div class="button-group checkboxes-ball clearfix">
								  <label div="div_tk_chk_1">
								    <input type="checkbox" name="tk" value="1" id="tk_chk_1">
								    <span class="button-group-item" for="tk_chk_1"><span class="label-item">1</span></span>
								  </label>
								  <label div="div_tk_chk_2">
								    <input type="checkbox" name="tk" value="2" id="tk_chk_2">
								    <span class="button-group-item" for="tk_chk_2"><span class="label-item">2</span></span>
								  </label>
								  <label div="div_tk_chk_3">
								    <input type="checkbox" name="tk" value="3" id="tk_chk_3">
								    <span class="button-group-item" for="tk_chk_3"><span class="label-item">3</span></span>
								  </label>
								  <label div="div_tk_chk_4">
								    <input type="checkbox" name="tk" value="4" id="tk_chk_4">
								    <span class="button-group-item" for="tk_chk_4"><span class="label-item">4</span></span>
								  </label>
								  <label div="div_tk_chk_5">
								    <input type="checkbox" name="tk" value="5" id="tk_chk_5">
								    <span class="button-group-item" for="tk_chk_5"><span class="label-item">5</span></span>
								  </label>
								  <label div="div_tk_chk_6">
								    <input type="checkbox" name="tk" value="6" id="tk_chk_6">
								    <span class="button-group-item" for="tk_chk_6"><span class="label-item">6</span></span>
								  </label>
								  <label div="div_tk_chk_7">
								    <input type="checkbox" name="tk" value="7" id="tk_chk_7">
								    <span class="button-group-item" for="tk_chk_7"><span class="label-item">7</span></span>
								  </label>
								  <label div="div_tk_chk_8">
								    <input type="checkbox" name="tk" value="8" id="tk_chk_8">
								    <span class="button-group-item" for="tk_chk_8"><span class="label-item">8</span></span>
								  </label>
								  <label div="div_tk_chk_9">
								    <input type="checkbox" name="tk" value="9" id="tk_chk_9">
								    <span class="button-group-item" for="tk_chk_9"><span class="label-item">9</span></span>
								  </label>
								  <label div="div_tk_chk_10">
								    <input type="checkbox" name="tk" value="10" id="tk_chk_10">
								    <span class="button-group-item" for="tk_chk_10"><span class="label-item">10</span></span>
								  </label>
								  <label div="div_tk_chk_11">
								    <input type="checkbox" name="tk" value="11" id="tk_chk_11">
								    <span class="button-group-item" for="tk_chk_11"><span class="label-item">11</span></span>
								  </label>
								  <label div="div_tk_chk_12">
								    <input type="checkbox" name="tk" value="12" id="tk_chk_12">
								    <span class="button-group-item" for="tk_chk_12"><span class="label-item">12</span></span>
								  </label>
								  <label div="div_tk_chk_13">
								    <input type="checkbox" name="tk" value="13" id="tk_chk_13">
								    <span class="button-group-item" for="tk_chk_13"><span class="label-item">13</span></span>
								  </label>
								  <label div="div_tk_chk_14">
								    <input type="checkbox" name="tk" value="14" id="tk_chk_14">
								    <span class="button-group-item" for="tk_chk_14"><span class="label-item">14</span></span>
								  </label>
								  <label div="div_tk_chk_15">
								    <input type="checkbox" name="tk" value="15" id="tk_chk_15">
								    <span class="button-group-item" for="tk_chk_15"><span class="label-item">15</span></span>
								  </label>
								  <label div="div_tk_chk_16">
								    <input type="checkbox" name="tk" value="16" id="tk_chk_16">
								    <span class="button-group-item" for="tk_chk_16"><span class="label-item">16</span></span>
								  </label>
								  <label div="div_tk_chk_17">
								    <input type="checkbox" name="tk" value="17" id="tk_chk_17">
								    <span class="button-group-item" for="tk_chk_17"><span class="label-item">17</span></span>
								  </label>
								  <label div="div_tk_chk_18">
								    <input type="checkbox" name="tk" value="18" id="tk_chk_18">
								    <span class="button-group-item" for="tk_chk_18"><span class="label-item">18</span></span>
								  </label>
								  <label div="div_tk_chk_19">
								    <input type="checkbox" name="tk" value="19" id="tk_chk_19">
								    <span class="button-group-item" for="tk_chk_19"><span class="label-item">19</span></span>
								  </label>
								  <label div="div_tk_chk_20">
								    <input type="checkbox" name="tk" value="20" id="tk_chk_20">
								    <span class="button-group-item" for="tk_chk_20"><span class="label-item">20</span></span>
								  </label>
								  <label div="div_tk_chk_21">
								    <input type="checkbox" name="tk" value="21" id="tk_chk_21">
								    <span class="button-group-item" for="tk_chk_21"><span class="label-item">21</span></span>
								  </label>
								  <label div="div_tk_chk_22">
								    <input type="checkbox" name="tk" value="22" id="tk_chk_22">
								    <span class="button-group-item" for="tk_chk_22"><span class="label-item">22</span></span>
								  </label>
								  <label div="div_tk_chk_23">
								    <input type="checkbox" name="tk" value="23" id="tk_chk_23">
								    <span class="button-group-item" for="tk_chk_23"><span class="label-item">23</span></span>
								  </label>
								  <label div="div_tk_chk_24">
								    <input type="checkbox" name="tk" value="24" id="tk_chk_24">
								    <span class="button-group-item" for="tk_chk_24"><span class="label-item">24</span></span>
								  </label>
								  <label div="div_tk_chk_25">
								    <input type="checkbox" name="tk" value="25" id="tk_chk_25">
								    <span class="button-group-item" for="tk_chk_25"><span class="label-item">25</span></span>
								  </label>
								  <label div="div_tk_chk_26">
								    <input type="checkbox" name="tk" value="26" id="tk_chk_26">
								    <span class="button-group-item" for="tk_chk_26"><span class="label-item">26</span></span>
								  </label>
								  <label div="div_tk_chk_27">
								    <input type="checkbox" name="tk" value="27" id="tk_chk_27">
								    <span class="button-group-item" for="tk_chk_27"><span class="label-item">27</span></span>
								  </label>
								  <label div="div_tk_chk_28">
								    <input type="checkbox" name="tk" value="28" id="tk_chk_28">
								    <span class="button-group-item" for="tk_chk_28"><span class="label-item">28</span></span>
								  </label>
								  <label div="div_tk_chk_29">
								    <input type="checkbox" name="tk" value="29" id="tk_chk_29">
								    <span class="button-group-item" for="tk_chk_29"><span class="label-item">29</span></span>
								  </label>
								  <label div="div_tk_chk_30">
								    <input type="checkbox" name="tk" value="30" id="tk_chk_30">
								    <span class="button-group-item" for="tk_chk_30"><span class="label-item">30</span></span>
								  </label>
								  <label div="div_tk_chk_31">
								    <input type="checkbox" name="tk" value="31" id="tk_chk_31">
								    <span class="button-group-item" for="tk_chk_31"><span class="label-item">31</span></span>
								  </label>
								  <label div="div_tk_chk_32">
								    <input type="checkbox" name="tk" value="32" id="tk_chk_32">
								    <span class="button-group-item" for="tk_chk_32"><span class="label-item">32</span></span>
								  </label>
								  <label div="div_tk_chk_33">
								    <input type="checkbox" name="tk" value="33" id="tk_chk_33">
								    <span class="button-group-item" for="tk_chk_33"><span class="label-item">33</span></span>
								  </label>
								  <label div="div_tk_chk_34">
								    <input type="checkbox" name="tk" value="34" id="tk_chk_34">
								    <span class="button-group-item" for="tk_chk_34"><span class="label-item">34</span></span>
								  </label>
								  <label div="div_tk_chk_35">
								    <input type="checkbox" name="tk" value="35" id="tk_chk_35">
								    <span class="button-group-item" for="tk_chk_35"><span class="label-item">35</span></span>
								  </label>
								  <label div="div_tk_chk_36">
								    <input type="checkbox" name="tk" value="36" id="tk_chk_36">
								    <span class="button-group-item" for="tk_chk_36"><span class="label-item">36</span></span>
								  </label>
								  <label div="div_tk_chk_37">
								    <input type="checkbox" name="tk" value="37" id="tk_chk_37">
								    <span class="button-group-item" for="tk_chk_37"><span class="label-item">37</span></span>
								  </label>
								  <label div="div_tk_chk_38">
								    <input type="checkbox" name="tk" value="38" id="tk_chk_38">
								    <span class="button-group-item" for="tk_chk_38"><span class="label-item">38</span></span>
								  </label>
								  <label div="div_tk_chk_39">
								    <input type="checkbox" name="tk" value="39" id="tk_chk_39">
								    <span class="button-group-item" for="tk_chk_39"><span class="label-item">39</span></span>
								  </label>
								  <label div="div_tk_chk_40">
								    <input type="checkbox" name="tk" value="40" id="tk_chk_40">
								    <span class="button-group-item" for="tk_chk_40"><span class="label-item">40</span></span>
								  </label>
								  <label div="div_tk_chk_41">
								    <input type="checkbox" name="tk" value="41" id="tk_chk_41">
								    <span class="button-group-item" for="tk_chk_41"><span class="label-item">41</span></span>
								  </label>
								  <label div="div_tk_chk_42">
								    <input type="checkbox" name="tk" value="42" id="tk_chk_42">
								    <span class="button-group-item" for="tk_chk_42"><span class="label-item">42</span></span>
								  </label>
								  <label div="div_tk_chk_43">
								    <input type="checkbox" name="tk" value="43" id="tk_chk_43">
								    <span class="button-group-item" for="tk_chk_43"><span class="label-item">43</span></span>
								  </label>
								  <label div="div_tk_chk_44">
								    <input type="checkbox" name="tk" value="44" id="tk_chk_44">
								    <span class="button-group-item" for="tk_chk_44"><span class="label-item">44</span></span>
								  </label>
								  <label div="div_tk_chk_45">
								    <input type="checkbox" name="tk" value="45" id="tk_chk_45">
								    <span class="button-group-item" for="tk_chk_45"><span class="label-item">45</span></span>
								  </label>
								  <label div="div_tk_chk_46">
								    <input type="checkbox" name="tk" value="46" id="tk_chk_46">
								    <span class="button-group-item" for="tk_chk_46"><span class="label-item">46</span></span>
								  </label>
								  <label div="div_tk_chk_47">
								    <input type="checkbox" name="tk" value="47" id="tk_chk_47">
								    <span class="button-group-item" for="tk_chk_47"><span class="label-item">47</span></span>
								  </label>
								  <label div="div_tk_chk_48">
								    <input type="checkbox" name="tk" value="48" id="tk_chk_48">
								    <span class="button-group-item" for="tk_chk_48"><span class="label-item">48</span></span>
								  </label>
								  <label div="div_tk_chk_49">
								    <input type="checkbox" name="tk" value="49" id="tk_chk_49">
								    <span class="button-group-item" for="tk_chk_49"><span class="label-item">49</span></span>
								  </label>
								  <label div="div_tk_chk_50">
								    <input type="checkbox" name="tk" value="50" id="tk_chk_50">
								    <span class="button-group-item" for="tk_chk_50"><span class="label-item">50</span></span>
								  </label>	
								</div>
							</div>
							<div class="game-actions">
								<button type="button" id="azar" class="btn btn-green">AZAR</button>
								<button type="button" id="clean" class="btn btn-green">LIMPIAR</button>
								<!-- <button type="button" id="addShopingTinka" class="btn btn-red float-bottom">AGREGAR A BOLETO</button> -->
                               <button type="button" id="btn_mobile_agregar_boleto_tinka" class="btn btn-red float-bottom">SIGUIENTE</button>
							</div>
						</form>
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
				
			var $limiteJugadas = $('#tinkaJugadas').val();
			var $overcomeJugadas = $('#tinkaOvercomeJugadas').val();
			var count=0;
			var bets=0;
			var $array_tk_select =  new Array();
					
			if($overcomeJugadas==1){
					desplegarModal('Máximo '+ $limiteJugadas +' jugadas');
			
					taggingPopupError('Máximo '+ $limiteJugadas +' jugadas');
			}

			//$(document).delegate('#addShopingTinka', 'click', function() {
			$(document).delegate('#btn_mobile_agregar_boleto_tinka', 'click', function() {
		        mainValidatePendingsDocsForAproval('interfaceBetAgregarBoletoTinka');
		    });
			
			function interfaceBetAgregarBoletoTinka() {
				if(bets == 0){ 
					desplegarModal('No ha realizado ninguna jugada');
					taggingPopupError('No ha realizado ninguna jugada');
					datalayerErrores('Elige 6 números o más','Paso 1','Jugar','No ha realizado ninguna jugada');
				} else {						
					var price=parseInt($('#precioRegular').val().split(" ")[1]);
					document.forms["game_tinka_add_bet"].submit();
					datalayerTinkaJugada(this,'Elige 6 números o más','Button','Jugar');
				 } 
			} // 

			// Agrega un evento message para escuchar los mensajes enviados desde el iframe
			window.addEventListener("message", function(event) {
			    if (event.data === "interfaceBetAgregarBoletoTinka") {
			    	interfaceBetAgregarBoletoTinka();
			    }
			});
				

			$(document).delegate('#clean', 'click', function() { 
				$(".f_error_mensaje").hide();
		    	$("input[type=checkbox]:checked").each(
			  		function() {	
				  		$("#div_"+$(this).attr('id')).removeClass("button_select");
			  	 		$(this).prop('checked', false);
				   	}
				);
		    	count=0;
		    	bets=0;
		    	datalayerTinkaJugada(this,'Elige 6 números o más','Button','Jugar');
		  	});

			function bin_newton(cantidad) {
		        var deduct_1 = 1;
		        var deduct_2 = 1;
		        var count_2 = cantidad - 6;
		        variable = factorial(cantidad) / (720 * (factorial(count_2)));
		        return variable
		    }
		 
			function factorial(cantidad) {
			        if (cantidad < 0)return 0; else if (cantidad > 1)return cantidad * factorial(cantidad - 1);
			        return 1
			}

			$(".close_f").on("click",function(){
					$(".f_error_mensaje").hide();
				});

			function desplegarModal(mensaje){
					$(".f_error_mensaje").show();
					$(".f_textoInterno").html(mensaje);				
				}

			var aux = 0;
			$(' .checkboxes-ball input').on( 'change', function() {
				$(".f_error_mensaje").hide();
		  		var $this = $( this );
		  		var countballs = 0;
		  		 $("input[type=checkbox]:checked").each(
		  			function() {
		  				countballs++;
		  			}
				  );

		  		if (countballs > 6) {
	  				var jugadas = bin_newton(countballs);
	  				if (jugadas>$limiteJugadas) {		  								
	  					$this.prop('checked',false);
	  					
	  					desplegarModal('Máximo '+$limiteJugadas+' jugadas');
	  					taggingPopupError('Máximo '+$limiteJugadas+' jugadas');
	  				} else {
	  					bets = bin_newton(countballs);
			  		}
	  				
	  			} else if (countballs > 5){
	  				bets = bin_newton(countballs);
			  	} else {
					bets = 0;
				}
		  	});

			

			$(document).delegate('#azar', 'click', function() {
			
				$(".f_error_mensaje").hide();
		        var array_random = new Array();
		        var count_random_tinka= 0;
 
		        $("input[type=checkbox]:checked").each(
		            function() {
		            	$("#div_"+$(this).attr('id')).removeClass("button_select"); 
		            	$(this).prop('checked',false);          
		            }
		        );
		        while(count_random_tinka<6){  
		            var number =Math.round(1+(Math.random()*(50-1)));
		            if(array_random.indexOf(number) == -1) {
		                array_random.push(number);                        
                        count_random_tinka ++;
                        $("#div_tk_chk_"+number).addClass("button_select");
                        $("#tk_chk_"+number).prop('checked', true);                                               
		              } 
		        }

		        bets = bin_newton(6);

		        taggingTinkaAzar();
		        datalayerTinkaJugada(this,'Elige 6 números o más','Button','Jugar');
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

		   $(document).delegate('#game_tinka_show_menu', 'click', function(e){
			  
		   		e.preventDefault();
		   		window.location.href ='game_tinka_show_menu.html';
		   	});
		   taggingJuegaTinkaElige();   
		});	
			
		</script>
		

</body>
</html>