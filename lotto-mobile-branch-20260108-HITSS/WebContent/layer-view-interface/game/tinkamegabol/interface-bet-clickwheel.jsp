<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	
<title>Tinka Megabol : Realizar apuesta</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/tinkamegabol/theme.css" />
<link rel="stylesheet" href="layer-view-style/game/tinkamegabol/theme-bet.css" />  
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Tinka Megabol móvil,  realiza la apuesta del juego' />
<script type="text/javascript">
$(document).ready(function () {	
	 $.mobile.defaultPageTransition = 'none';	

	 //$(document).delegate('#addShopingTinka', 'click', function() {		
	 $(document).delegate('#btn_mobile_agregar_boleto_tinka', 'click', function() {		   
		   
		 document.forms["game_tinkamegabol_add_bet"].submit();               
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
		     
	        if (jQuery.inArray(number,array_random) == -1) {
	         	 array_random[count_random_tinka] = number;	         			         	 	 
	                        count_random_tinka ++;
	                        $("#div_tk_chk_"+number).addClass("button_select"); 	                                              
	      }
	}
	
	 mgRandon=Math.round(1+(Math.random()*(5-1)));
	 $("#div_mg_chk_"+mgRandon).addClass("button_select"); 		 
	 $("#mg_chk_"+mgRandon).attr('checked', true);
	 	
	
	for (var i=0; i<array_random.length; i++){		   
			$("#tk_chk_"+array_random[i]).attr('checked', true);
	}		
	count=6;	      
	});	
	    
	   $(document).delegate('[type=checkbox]', "change", function( e ) {	      
	           if($(this).attr('id').substring(0,2)=='tk'){
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

	   $(document).delegate('#game_tinkamegabol_show_menu', 'click', function(){window.location.href ='game_tinkamegabol_show_menu.html'; });
</script>
	
</head>
<body>        
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
        
   <jsp:include page="../../include/header.jsp" />
		
		<div align="center" >
		<BR>
		
		<ul data-role="listview" data-inset="true" data-theme="e" style="margin-right: 5px; margin-left: 5px;">
		
		<li data-role="list-divider">
		<div align="center">
		 <img src="layer-view-image/game/tinkamegabol/logo_tinka_megabol_small.png" title="Tinka Megabol" alt="Tinka Megabol" />
		</div>
		</li>
		</ul>
		<ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">
		<li>
		<form action="game_tinkamegabol_add_bet.html" method="post" id="game_tinkamegabol_add_bet">
		<div align="center" ><b>Jugada ${typePlay}</b></div>
		
		<div  align="center" >
		<div style="width:200px;height:630px;">	
		<div class="button" id="div_tk_chk_1" ><input type="checkbox" data-role="none" id="tk_chk_1" name="tk" value="1"/><label  for="tk_chk_1" >1</label></div>
		<div class="button" id="div_tk_chk_2" ><input type="checkbox" data-role="none" id="tk_chk_2" name="tk" value="3"/><label  for="tk_chk_2" >2</label></div>
		<div class="button" id="div_tk_chk_3" ><input type="checkbox" data-role="none" id="tk_chk_3" name="tk" value="3"/><label  for="tk_chk_3" >3</label></div>
		<div class="button" id="div_tk_chk_4" ><input type="checkbox" data-role="none" id="tk_chk_4" name="tk" value="4"/><label  for="tk_chk_4" >4</label></div>
		<div class="button" id="div_tk_chk_5" ><input type="checkbox" data-role="none" id="tk_chk_5" name="tk" value="5"/><label  for="tk_chk_5" >5</label></div>
		<div class="button" id="div_tk_chk_6" ><input type="checkbox" data-role="none" id="tk_chk_6" name="tk" value="6"/><label  for="tk_chk_6" >6</label></div>
		<div class="button" id="div_tk_chk_7" ><input type="checkbox" data-role="none" id="tk_chk_7" name="tk" value="7"/><label  for="tk_chk_7" >7</label></div>
		<div class="button" id="div_tk_chk_8" ><input type="checkbox" data-role="none" id="tk_chk_8" name="tk" value="8"/><label  for="tk_chk_8" >8</label></div>
		<div class="button" id="div_tk_chk_9" ><input type="checkbox" data-role="none" id="tk_chk_9" name="tk" value="9"/><label  for="tk_chk_9" >9</label></div>
		<div class="button" id="div_tk_chk_10" ><input type="checkbox" data-role="none" id="tk_chk_10" name="tk" value="10"/><label  for="tk_chk_10" >10</label></div>
		<div class="button" id="div_tk_chk_11" ><input type="checkbox" data-role="none" id="tk_chk_11" name="tk" value="11"/><label  for="tk_chk_11" >11</label></div>
		<div class="button" id="div_tk_chk_12" ><input type="checkbox" data-role="none" id="tk_chk_12" name="tk" value="12"/><label  for="tk_chk_12" >12</label></div>
		<div class="button" id="div_tk_chk_13" ><input type="checkbox" data-role="none" id="tk_chk_13" name="tk" value="13"/><label  for="tk_chk_13" >13</label></div>
		<div class="button" id="div_tk_chk_14" ><input type="checkbox" data-role="none" id="tk_chk_14" name="tk" value="14"/><label  for="tk_chk_14" >14</label></div>
		<div class="button" id="div_tk_chk_15" ><input type="checkbox" data-role="none" id="tk_chk_15" name="tk" value="15"/><label  for="tk_chk_15" >15</label></div>
		<div class="button" id="div_tk_chk_16" ><input type="checkbox" data-role="none" id="tk_chk_16" name="tk" value="16"/><label  for="tk_chk_16" >16</label></div>
		<div class="button" id="div_tk_chk_17" ><input type="checkbox" data-role="none" id="tk_chk_17" name="tk" value="17"/><label  for="tk_chk_17" >17</label></div>
		<div class="button" id="div_tk_chk_18" ><input type="checkbox" data-role="none" id="tk_chk_18" name="tk" value="18"/><label  for="tk_chk_18" >18</label></div>
		<div class="button" id="div_tk_chk_19" ><input type="checkbox" data-role="none" id="tk_chk_19" name="tk" value="19"/><label  for="tk_chk_19" >19</label></div>
		<div class="button" id="div_tk_chk_20" ><input type="checkbox" data-role="none" id="tk_chk_20" name="tk" value="20"/><label  for="tk_chk_20" >20</label></div>
		<div class="button" id="div_tk_chk_21" ><input type="checkbox" data-role="none" id="tk_chk_21" name="tk" value="21"/><label  for="tk_chk_21" >21</label></div>
		<div class="button" id="div_tk_chk_22" ><input type="checkbox" data-role="none" id="tk_chk_22" name="tk" value="22"/><label  for="tk_chk_22" >22</label></div>
		<div class="button" id="div_tk_chk_23" ><input type="checkbox" data-role="none" id="tk_chk_23" name="tk" value="23"/><label  for="tk_chk_23" >23</label></div>
		<div class="button" id="div_tk_chk_24" ><input type="checkbox" data-role="none" id="tk_chk_24" name="tk" value="24"/><label  for="tk_chk_24" >24</label></div>
		<div class="button" id="div_tk_chk_25" ><input type="checkbox" data-role="none" id="tk_chk_25" name="tk" value="25"/><label  for="tk_chk_25" >25</label></div>
		<div class="button" id="div_tk_chk_26" ><input type="checkbox" data-role="none" id="tk_chk_26" name="tk" value="26"/><label  for="tk_chk_26" >26</label></div>
		<div class="button" id="div_tk_chk_27" ><input type="checkbox" data-role="none" id="tk_chk_27" name="tk" value="27"/><label  for="tk_chk_27" >27</label></div>
		<div class="button" id="div_tk_chk_28" ><input type="checkbox" data-role="none" id="tk_chk_28" name="tk" value="28"/><label  for="tk_chk_28" >28</label></div>
		<div class="button" id="div_tk_chk_29" ><input type="checkbox" data-role="none" id="tk_chk_29" name="tk" value="29"/><label  for="tk_chk_29" >29</label></div>
		<div class="button" id="div_tk_chk_30" ><input type="checkbox" data-role="none" id="tk_chk_30" name="tk" value="30"/><label  for="tk_chk_30" >30</label></div>
		<div class="button" id="div_tk_chk_31" ><input type="checkbox" data-role="none" id="tk_chk_31" name="tk" value="31"/><label  for="tk_chk_31" >31</label></div>
		<div class="button" id="div_tk_chk_32" ><input type="checkbox" data-role="none" id="tk_chk_32" name="tk" value="32"/><label  for="tk_chk_32" >32</label></div>
		<div class="button" id="div_tk_chk_33" ><input type="checkbox" data-role="none" id="tk_chk_33" name="tk" value="33"/><label  for="tk_chk_33" >33</label></div>
		<div class="button" id="div_tk_chk_34" ><input type="checkbox" data-role="none" id="tk_chk_34" name="tk" value="34"/><label  for="tk_chk_34" >34</label></div>
		<div class="button" id="div_tk_chk_35" ><input type="checkbox" data-role="none" id="tk_chk_35" name="tk" value="35"/><label  for="tk_chk_35" >35</label></div>
		<div class="button" id="div_tk_chk_36" ><input type="checkbox" data-role="none" id="tk_chk_36" name="tk" value="36"/><label  for="tk_chk_36" >36</label></div>
		<div class="button" id="div_tk_chk_37" ><input type="checkbox" data-role="none" id="tk_chk_37" name="tk" value="37"/><label  for="tk_chk_37" >37</label></div>
		<div class="button" id="div_tk_chk_38" ><input type="checkbox" data-role="none" id="tk_chk_38" name="tk" value="38"/><label  for="tk_chk_38" >38</label></div>
		<div class="button" id="div_tk_chk_39" ><input type="checkbox" data-role="none" id="tk_chk_39" name="tk" value="39"/><label  for="tk_chk_39" >39</label></div>
		<div class="button" id="div_tk_chk_40" ><input type="checkbox" data-role="none" id="tk_chk_40" name="tk" value="40"/><label  for="tk_chk_40" >40</label></div>
		<div class="button" id="div_tk_chk_41" ><input type="checkbox" data-role="none" id="tk_chk_41" name="tk" value="41"/><label  for="tk_chk_41" >41</label></div>
		<div class="button" id="div_tk_chk_42" ><input type="checkbox" data-role="none" id="tk_chk_42" name="tk" value="42"/><label  for="tk_chk_42" >42</label></div>
		<div class="button" id="div_tk_chk_43" ><input type="checkbox" data-role="none" id="tk_chk_43" name="tk" value="43"/><label  for="tk_chk_43" >43</label></div>
		<div class="button" id="div_tk_chk_44" ><input type="checkbox" data-role="none" id="tk_chk_44" name="tk" value="44"/><label  for="tk_chk_44" >44</label></div>
		<div class="button" id="div_tk_chk_45" ><input type="checkbox" data-role="none" id="tk_chk_45" name="tk" value="45"/><label  for="tk_chk_45" >45</label></div> 
			     
						
		</div>
		</div> 
		<BR> 
		
		<div>
		<b>Megabolilla</b>
		</div>
		
		<div align="center">
		<div style="width: 300px;height:50px;" id="content_Megabol">
		 <div class="button" id="div_mg_chk_1"><input type="checkbox" data-role="none" id="mg_chk_1" name="mg" value="1"/><label  for="mg_chk_1">1</label></div> 
	     <div class="button" id="div_mg_chk_2"><input type="checkbox" data-role="none" id="mg_chk_2" name="mg" value="2"/><label  for="mg_chk_2">2</label></div> 
	     <div class="button" id="div_mg_chk_3"><input type="checkbox" data-role="none" id="mg_chk_3" name="mg" value="3"/><label  for="mg_chk_3">3</label></div> 
	    <div class="button" id="div_mg_chk_4"><input type="checkbox" data-role="none" id="mg_chk_4" name="mg" value="4"/><label  for="mg_chk_4">4</label></div> 
	    <div class="button" id="div_mg_chk_5"><input type="checkbox" data-role="none" id="mg_chk_5" name="mg" value="5"/><label  for="mg_chk_5">5</label></div>
		</div>
		</div>
		
		<a href="#" id="azar" data-role="button" data-mini="true" data-theme="e" style="width: 80%;font-size: 12px;"> Azar</a> 
	    <a href="#" id="clean" data-role="button" data-mini="true" data-theme="e"  style="width: 80%;font-size: 12px;">Limpiar</a>
<!-- 	    <a href="#" id="addShopingTinka" data-role="button" data-theme="d" data-mini="true" style="width: 80%;font-size: 12px;">Agregar a boleto</a>  -->	     		
	    <a href="#" id="btn_mobile_agregar_boleto_tinka" data-role="button" data-theme="d" data-mini="true" style="width: 80%;font-size: 12px;">Agregar a boleto</a> 
		
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