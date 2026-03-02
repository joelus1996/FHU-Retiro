<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	
<title>Jugar Kábala Online | Comprar Kábala en línea</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/kabala/theme.css" />
<link rel="stylesheet" href="layer-view-style/game/kabala/theme-bet.css" />  
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Juega La Kábala en línea de forma sencilla y segura. Compra La Kábala en nuestra plataforma de forma totalmente online. ¡Entra ahora y empieza a ganar!' />
<script type="text/javascript">
$(document).ready(function () {	
	$.mobile.defaultPageTransition = 'none';	
	
	$(document).delegate('#btn_mobile_agregar_boleto_kabala', 'click', function() {
			// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
			// es una function que se realizará en caso no tenga docs pendientes de confirmacion
		mainValidatePendingsDocsForAproval('interfaceBetClickwheelAgregarBoletoKabala');
	});

	function interfaceBetClickwheelAgregarBoletoKabala () {
		datalayerTinkaJugada(this,'Elige 6 números o más','Button','Jugar');
		document.forms["game_kabala_add_bet"].submit();
	}
	
	window.addEventListener("message", function(event) {
	    if (event.data === "interfaceBetClickwheelAgregarBoletoKabala") {
	    	interfaceBetClickwheelAgregarBoletoKabala(); 
	    }
	});    
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
    	datalayerTinkaJugada(this,'Elige 6 números o más','Button','Jugar');  	  	   	
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
		    var number =Math.round(1+(Math.random()*(40-1))); 
		     
	        if (jQuery.inArray(number,array_random) == -1) {
	         	 array_random[count_random_tinka] = number;	         			         	 	 
	                        count_random_tinka ++;
	                        $("#div_kb_chk_"+number).addClass("button_select"); 	                                              
	      }
	}
	
	 mgRandon=Math.round(1+(Math.random()*(5-1)));
	 $("#div_mg_chk_"+mgRandon).addClass("button_select"); 		 
	 $("#mg_chk_"+mgRandon).attr('checked', true);
	 	
	
	for (var i=0; i<array_random.length; i++){
			$("#kb_chk_"+array_random[i]).attr('checked', true);
	}		
	count=6;	      
	datalayerTinkaJugada(this,'Elige 6 números o más','Button','Jugar');        
	});	
	    
	   $(document).delegate('[type=checkbox]', "change", function( e ) {	      
	           if($(this).attr('id').substring(0,2)=='kb'){
		            if ( $(this).is(":checked") ){  
		                   count ++;		                    
		                   if(count > 12){ 			                                                                           	
		                   	$(this).attr('checked',false);   
		                   	count --;  
		                   } else{
		                	   $("#div_"+$(this).attr('id')).addClass("button_select"); 		                	  
			                }                 
		            }
		            else 
		            {
		            	$("#div_"+$(this).attr('id')).removeClass("button_select"); 		            	
		              count --;  
		            }
	            }   

	           if($(this).attr('id').substring(0,2)=='mg'){
		            if ( $(this).is(":checked") ){
		            	$("#div_"+$(this).attr('id')).addClass("button_select"); 			                                 
		            }
		            else 
		            {
		            	$("#div_"+$(this).attr('id')).removeClass("button_select"); 		               
		            }
	            } 	             
	    });

	   $(document).delegate('#game_kabala_show_menu', 'click', function(){window.location.href ='game_kabala_show_menu.html'; });

		$(document).delegate('#plus', 'change', function(e) {
			 $("#chau_chamba").prop("disabled", false).checkboxradio("refresh");
			 
			 if(document.getElementById("plus").checked){
				 $("#chau_chamba").prop("disabled", false).checkboxradio("refresh");}
				else {
				 $("#chau_chamba").prop("checked", false).checkboxradio("refresh");
				 $("#chau_chamba").prop("disabled", true).checkboxradio("refresh");}
			 //console.log(e.target);
			});
		
</script>
	
</head>
<body>      

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
      <h1 style="display: none;">Jugar Kábala Online</h1>
   <jsp:include page="../../include/header.jsp" />
		
		<div align="center" >
		<BR>
		
		<ul data-role="listview" data-inset="true" data-theme="e" style="margin-right: 5px; margin-left: 5px;">
		
		<li data-role="list-divider">
		<div align="center">
		 <img src="layer-view-image/game/kabala/logo_kabala_small.png" title="Kabala" alt="Kabala" />
		</div>
		</li>
		</ul>
		<ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">
		<li>
		<form action="game_kabala_add_bet.html" method="post" id="game_kabala_add_bet">
		<div align="center" ><b>Jugada ${typePlay}</b></div>
		
		<div  align="center" >
		<div style="width:200px;height:630px;">	
		<div class="button" id="div_kb_chk_1" ><input type="checkbox" data-role="none" id="kb_chk_1" name="kb" value="1"/><label  for="kb_chk_1" >1</label></div>
		<div class="button" id="div_kb_chk_2" ><input type="checkbox" data-role="none" id="kb_chk_2" name="kb" value="2"/><label  for="kb_chk_2" >2</label></div>
		<div class="button" id="div_kb_chk_3" ><input type="checkbox" data-role="none" id="kb_chk_3" name="kb" value="3"/><label  for="kb_chk_3" >3</label></div>
		<div class="button" id="div_kb_chk_4" ><input type="checkbox" data-role="none" id="kb_chk_4" name="kb" value="4"/><label  for="kb_chk_4" >4</label></div>
		<div class="button" id="div_kb_chk_5" ><input type="checkbox" data-role="none" id="kb_chk_5" name="kb" value="5"/><label  for="kb_chk_5" >5</label></div>
		<div class="button" id="div_kb_chk_6" ><input type="checkbox" data-role="none" id="kb_chk_6" name="kb" value="6"/><label  for="kb_chk_6" >6</label></div>
		<div class="button" id="div_kb_chk_7" ><input type="checkbox" data-role="none" id="kb_chk_7" name="kb" value="7"/><label  for="kb_chk_7" >7</label></div>
		<div class="button" id="div_kb_chk_8" ><input type="checkbox" data-role="none" id="kb_chk_8" name="kb" value="8"/><label  for="kb_chk_8" >8</label></div>
		<div class="button" id="div_kb_chk_9" ><input type="checkbox" data-role="none" id="kb_chk_9" name="kb" value="9"/><label  for="kb_chk_9" >9</label></div>
		<div class="button" id="div_kb_chk_10" ><input type="checkbox" data-role="none" id="kb_chk_10" name="kb" value="10"/><label  for="kb_chk_10" >10</label></div>
		<div class="button" id="div_kb_chk_11" ><input type="checkbox" data-role="none" id="kb_chk_11" name="kb" value="11"/><label  for="kb_chk_11" >11</label></div>
		<div class="button" id="div_kb_chk_12" ><input type="checkbox" data-role="none" id="kb_chk_12" name="kb" value="12"/><label  for="kb_chk_12" >12</label></div>
		<div class="button" id="div_kb_chk_13" ><input type="checkbox" data-role="none" id="kb_chk_13" name="kb" value="13"/><label  for="kb_chk_13" >13</label></div>
		<div class="button" id="div_kb_chk_14" ><input type="checkbox" data-role="none" id="kb_chk_14" name="kb" value="14"/><label  for="kb_chk_14" >14</label></div>
		<div class="button" id="div_kb_chk_15" ><input type="checkbox" data-role="none" id="kb_chk_15" name="kb" value="15"/><label  for="kb_chk_15" >15</label></div>
		<div class="button" id="div_kb_chk_16" ><input type="checkbox" data-role="none" id="kb_chk_16" name="kb" value="16"/><label  for="kb_chk_16" >16</label></div>
		<div class="button" id="div_kb_chk_17" ><input type="checkbox" data-role="none" id="kb_chk_17" name="kb" value="17"/><label  for="kb_chk_17" >17</label></div>
		<div class="button" id="div_kb_chk_18" ><input type="checkbox" data-role="none" id="kb_chk_18" name="kb" value="18"/><label  for="kb_chk_18" >18</label></div>
		<div class="button" id="div_kb_chk_19" ><input type="checkbox" data-role="none" id="kb_chk_19" name="kb" value="19"/><label  for="kb_chk_19" >19</label></div>
		<div class="button" id="div_kb_chk_20" ><input type="checkbox" data-role="none" id="kb_chk_20" name="kb" value="20"/><label  for="kb_chk_20" >20</label></div>
		<div class="button" id="div_kb_chk_21" ><input type="checkbox" data-role="none" id="kb_chk_21" name="kb" value="21"/><label  for="kb_chk_21" >21</label></div>
		<div class="button" id="div_kb_chk_22" ><input type="checkbox" data-role="none" id="kb_chk_22" name="kb" value="22"/><label  for="kb_chk_22" >22</label></div>
		<div class="button" id="div_kb_chk_23" ><input type="checkbox" data-role="none" id="kb_chk_23" name="kb" value="23"/><label  for="kb_chk_23" >23</label></div>
		<div class="button" id="div_kb_chk_24" ><input type="checkbox" data-role="none" id="kb_chk_24" name="kb" value="24"/><label  for="kb_chk_24" >24</label></div>
		<div class="button" id="div_kb_chk_25" ><input type="checkbox" data-role="none" id="kb_chk_25" name="kb" value="25"/><label  for="kb_chk_25" >25</label></div>
		<div class="button" id="div_kb_chk_26" ><input type="checkbox" data-role="none" id="kb_chk_26" name="kb" value="26"/><label  for="kb_chk_26" >26</label></div>
		<div class="button" id="div_kb_chk_27" ><input type="checkbox" data-role="none" id="kb_chk_27" name="kb" value="27"/><label  for="kb_chk_27" >27</label></div>
		<div class="button" id="div_kb_chk_28" ><input type="checkbox" data-role="none" id="kb_chk_28" name="kb" value="28"/><label  for="kb_chk_28" >28</label></div>
		<div class="button" id="div_kb_chk_29" ><input type="checkbox" data-role="none" id="kb_chk_29" name="kb" value="29"/><label  for="kb_chk_29" >29</label></div>
		<div class="button" id="div_kb_chk_30" ><input type="checkbox" data-role="none" id="kb_chk_30" name="kb" value="30"/><label  for="kb_chk_30" >30</label></div>
		<div class="button" id="div_kb_chk_31" ><input type="checkbox" data-role="none" id="kb_chk_31" name="kb" value="31"/><label  for="kb_chk_31" >31</label></div>
		<div class="button" id="div_kb_chk_32" ><input type="checkbox" data-role="none" id="kb_chk_32" name="kb" value="32"/><label  for="kb_chk_32" >32</label></div>
		<div class="button" id="div_kb_chk_33" ><input type="checkbox" data-role="none" id="kb_chk_33" name="kb" value="33"/><label  for="kb_chk_33" >33</label></div>
		<div class="button" id="div_kb_chk_34" ><input type="checkbox" data-role="none" id="kb_chk_34" name="kb" value="34"/><label  for="kb_chk_34" >34</label></div>
		<div class="button" id="div_kb_chk_35" ><input type="checkbox" data-role="none" id="kb_chk_35" name="kb" value="35"/><label  for="kb_chk_35" >35</label></div>
		<div class="button" id="div_kb_chk_36" ><input type="checkbox" data-role="none" id="kb_chk_36" name="kb" value="36"/><label  for="kb_chk_36" >36</label></div>
		<div class="button" id="div_kb_chk_37" ><input type="checkbox" data-role="none" id="kb_chk_37" name="kb" value="37"/><label  for="kb_chk_37" >37</label></div>
		<div class="button" id="div_kb_chk_38" ><input type="checkbox" data-role="none" id="kb_chk_38" name="kb" value="38"/><label  for="kb_chk_38" >38</label></div>
		<div class="button" id="div_kb_chk_39" ><input type="checkbox" data-role="none" id="kb_chk_39" name="kb" value="39"/><label  for="kb_chk_39" >39</label></div>
		<div class="button" id="div_kb_chk_40" ><input type="checkbox" data-role="none" id="kb_chk_40" name="kb" value="40"/><label  for="kb_chk_40" >40</label></div>		     						
		</div>
		</div> 
		<BR>
	
	
		 <input type="checkbox" name="plus" id="plus" value="Plus+" />
		 <label for="plus" style="text-align:center;font-size: 12px;height:38.5px;width: 80%">Plus</label>
		
		<!-- 
		 <input type="checkbox" name="chau_chamba" id="chau_chamba" value="Chau Chamba" disabled="true"/>
		 <label for="chau_chamba" style="text-align:center;font-size: 12px;height:38.5px;width: 80%">Chau Chamba</label>
		  -->
	    <BR>
			
		<a href="#" id="azar" data-role="button" data-mini="true" data-theme="e" style="color:white;width: 80%;font-size: 12px;"> Azar</a>  
	    <a href="#" id="clean" data-role="button" data-mini="true" data-theme="e"  style="color:white;width: 80%;font-size: 12px;">Limpiar</a> 		
	    <!-- 	    <a href="#" id="addShopingKabala" data-role="button" data-theme="d" data-mini="true" style="width: 80%;font-size: 12px;">Agregar a boleto</a> 		 -->
	    <a href="#" id="btn_mobile_agregar_boleto_kabala" data-role="button" data-theme="d" data-mini="true" style="width: 80%;font-size: 12px;">Siguiente</a>  
		
		</form>
		</li>
		</ul>
		</div>
		
		<ul style="margin-right: 5px; margin-left: 5px;">
		<li class="arrow"><small><img src="layer-view-image/common/arrow.png" /></small><a href="home.html"><span style="font-size: 13px;">Juegos</span></a> </li>
		<li class="arrow"><small><img src="layer-view-image/common/arrow.png" /></small><a href="#"><span style="font-size: 13px;">Ayuda</span></a> </li>
		</ul>
		

</body>
</html>