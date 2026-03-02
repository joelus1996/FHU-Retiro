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
		  	 $(this).attr('checked', false).checkboxradio('refresh');
		   }
		);   

    	count=0; 	  	   	
  });

    
	$(document).delegate('#azar', 'click', function() {	
		 	$("input[type=checkbox]:checked").each(
		  function() { 
		  	 $(this).attr('checked', false).checkboxradio('refresh');
		   }
		);	                
	 var count_random_tinka=0;
	 var array_random = new Array();		
	 while(count_random_tinka<6){	
		    var number =Math.round(1+(Math.random()*(45-1))); 
	        if (array_random.indexOf(number) == -1) {
	         	 array_random[count_random_tinka] = number; 		         		 	 
	                        count_random_tinka ++;
	      }
	}
	for (var i=0; i<array_random.length; i++){	$("#tk_chk_"+array_random[i]).attr('checked', true).checkboxradio('refresh');}
	$("#mg_chk_"+Math.round(1+(Math.random()*(5-1)))).attr('checked', true).checkboxradio('refresh');

	count=6;
	      
	});


	
	    
	   $(document).delegate('[type=checkbox]', "change", function( e ) {	      
	           if($(this).attr('id').substring(0,2)=='tk'){
		            if ( $(this).is(":checked") ){  
		                   count ++;
		                   if(count > 12){                                                              	
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
    <BR>
    <form action="game_tinkamegabol_add_bet.html" method="post" id="game_tinkamegabol_add_bet">
    <div  align="center" style="font-weight: bold;" >Jugada ${typePlay}</div>
    
    <div data-role="fieldcontain" align="center" style="font-size: 12px;">
    <fieldset data-role="controlgroup" data-type="horizontal">
    <div style="width: 200px;">	
		<input type="checkbox" name="tk" value="1" id="tk_chk_1" /><label for="tk_chk_1" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;1</label>
		<input type="checkbox" name="tk" value="2" id="tk_chk_2" /><label for="tk_chk_2" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;2</label>
		<input type="checkbox" name="tk" value="3" id="tk_chk_3" /><label for="tk_chk_3" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;3</label>
		<input type="checkbox" name="tk" value="4" id="tk_chk_4" /><label for="tk_chk_4" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;4</label>
		<input type="checkbox" name="tk" value="5" id="tk_chk_5" /><label for="tk_chk_5" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;5</label>
		<input type="checkbox" name="tk" value="6" id="tk_chk_6" /><label for="tk_chk_6" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;6</label>
		<input type="checkbox" name="tk" value="7" id="tk_chk_7" /><label for="tk_chk_7" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;7</label>
		<input type="checkbox" name="tk" value="8" id="tk_chk_8" /><label for="tk_chk_8" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;8</label>
		<input type="checkbox" name="tk" value="9" id="tk_chk_9" /><label for="tk_chk_9" style="height:37.6px;font-size: 11px;" >&nbsp;&nbsp;9</label>
		<input type="checkbox" name="tk" value="10" id="tk_chk_10" /><label for="tk_chk_10" style="height:37.6px;font-size: 11px;" >10</label>
		<input type="checkbox" name="tk" value="11" id="tk_chk_11" /><label for="tk_chk_11" style="height:37.6px;font-size: 11px;" >11</label>
		<input type="checkbox" name="tk" value="12" id="tk_chk_12" /><label for="tk_chk_12" style="height:37.6px;font-size: 11px;" >12</label>
		<input type="checkbox" name="tk" value="13" id="tk_chk_13" /><label for="tk_chk_13" style="height:37.6px;font-size: 11px;" >13</label>
		<input type="checkbox" name="tk" value="14" id="tk_chk_14" /><label for="tk_chk_14" style="height:37.6px;font-size: 11px;" >14</label>
		<input type="checkbox" name="tk" value="15" id="tk_chk_15" /><label for="tk_chk_15" style="height:37.6px;font-size: 11px;" >15</label>
		<input type="checkbox" name="tk" value="16" id="tk_chk_16" /><label for="tk_chk_16" style="height:37.6px;font-size: 11px;" >16</label>
		<input type="checkbox" name="tk" value="17" id="tk_chk_17" /><label for="tk_chk_17" style="height:37.6px;font-size: 11px;" >17</label>
		<input type="checkbox" name="tk" value="18" id="tk_chk_18" /><label for="tk_chk_18" style="height:37.6px;font-size: 11px;" >18</label>
		<input type="checkbox" name="tk" value="19" id="tk_chk_19" /><label for="tk_chk_19" style="height:37.6px;font-size: 11px;" >19</label>
		<input type="checkbox" name="tk" value="20" id="tk_chk_20" /><label for="tk_chk_20" style="height:37.6px;font-size: 11px;" >20</label>
		<input type="checkbox" name="tk" value="21" id="tk_chk_21" /><label for="tk_chk_21" style="height:37.6px;font-size: 11px;" >21</label>
		<input type="checkbox" name="tk" value="22" id="tk_chk_22" /><label for="tk_chk_22" style="height:37.6px;font-size: 11px;" >22</label>
		<input type="checkbox" name="tk" value="23" id="tk_chk_23" /><label for="tk_chk_23" style="height:37.6px;font-size: 11px;" >23</label>
		<input type="checkbox" name="tk" value="24" id="tk_chk_24" /><label for="tk_chk_24" style="height:37.6px;font-size: 11px;" >24</label>
		<input type="checkbox" name="tk" value="25" id="tk_chk_25" /><label for="tk_chk_25" style="height:37.6px;font-size: 11px;" >25</label>
		<input type="checkbox" name="tk" value="26" id="tk_chk_26" /><label for="tk_chk_26" style="height:37.6px;font-size: 11px;" >26</label>
		<input type="checkbox" name="tk" value="27" id="tk_chk_27" /><label for="tk_chk_27" style="height:37.6px;font-size: 11px;" >27</label>
		<input type="checkbox" name="tk" value="28" id="tk_chk_28" /><label for="tk_chk_28" style="height:37.6px;font-size: 11px;" >28</label>
		<input type="checkbox" name="tk" value="29" id="tk_chk_29" /><label for="tk_chk_29" style="height:37.6px;font-size: 11px;" >29</label>
		<input type="checkbox" name="tk" value="30" id="tk_chk_30" /><label for="tk_chk_30" style="height:37.6px;font-size: 11px;" >30</label>
		<input type="checkbox" name="tk" value="31" id="tk_chk_31" /><label for="tk_chk_31" style="height:37.6px;font-size: 11px;" >31</label>
		<input type="checkbox" name="tk" value="32" id="tk_chk_32" /><label for="tk_chk_32" style="height:37.6px;font-size: 11px;" >32</label>
		<input type="checkbox" name="tk" value="33" id="tk_chk_33" /><label for="tk_chk_33" style="height:37.6px;font-size: 11px;" >33</label>
		<input type="checkbox" name="tk" value="34" id="tk_chk_34" /><label for="tk_chk_34" style="height:37.6px;font-size: 11px;" >34</label>
		<input type="checkbox" name="tk" value="35" id="tk_chk_35" /><label for="tk_chk_35" style="height:37.6px;font-size: 11px;" >35</label>
		<input type="checkbox" name="tk" value="36" id="tk_chk_36" /><label for="tk_chk_36" style="height:37.6px;font-size: 11px;" >36</label>
		<input type="checkbox" name="tk" value="37" id="tk_chk_37" /><label for="tk_chk_37" style="height:37.6px;font-size: 11px;" >37</label>
		<input type="checkbox" name="tk" value="38" id="tk_chk_38" /><label for="tk_chk_38" style="height:37.6px;font-size: 11px;" >38</label>
		<input type="checkbox" name="tk" value="39" id="tk_chk_39" /><label for="tk_chk_39" style="height:37.6px;font-size: 11px;" >39</label>
		<input type="checkbox" name="tk" value="40" id="tk_chk_40" /><label for="tk_chk_40" style="height:37.6px;font-size: 11px;" >40</label>
		<input type="checkbox" name="tk" value="41" id="tk_chk_41" /><label for="tk_chk_41" style="height:37.6px;font-size: 11px;" >41</label>
		<input type="checkbox" name="tk" value="42" id="tk_chk_42" /><label for="tk_chk_42" style="height:37.6px;font-size: 11px;" >42</label>
		<input type="checkbox" name="tk" value="43" id="tk_chk_43" /><label for="tk_chk_43" style="height:37.6px;font-size: 11px;" >43</label>
		<input type="checkbox" name="tk" value="44" id="tk_chk_44" /><label for="tk_chk_44" style="height:37.6px;font-size: 11px;" >44</label>
		<input type="checkbox" name="tk" value="45" id="tk_chk_45" /><label for="tk_chk_45" style="height:37.6px;font-size: 11px;" >45</label>		
    </div>
    </fieldset>
    </div>
    
    <BR>	
		
	<div class="col_titulo"  style="font-weight: bold;">Megabolilla</div>
		
    <div align="center">
    <fieldset data-role="controlgroup" data-type="horizontal">
      <div style="width: 300px;">
      <input type="checkbox" id="mg_chk_1" name="mg" value="1"/><label for="mg_chk_1" style ="height:37.6px;font-size: 11px;">1</label>
      <input type="checkbox" id="mg_chk_2" name="mg" value="2"/><label for="mg_chk_2" style ="height:37.6px;font-size: 11px;">2</label>
      <input type="checkbox" id="mg_chk_3" name="mg" value="3"/><label for="mg_chk_3" style ="height:37.6px;font-size: 11px;">3</label>
      <input type="checkbox" id="mg_chk_4" name="mg" value="4"/><label for="mg_chk_4" style ="height:37.6px;font-size: 11px;">4</label>
      <input type="checkbox" id="mg_chk_5" name="mg" value="5"/><label for="mg_chk_5" style ="height:37.6px;font-size: 11px;">5</label>
      </div>
    </fieldset>
    </div>

	<a href="#" id="azar" data-role="button" data-theme="e"  style="width: 80%;font-size: 12px;"> Azar</a>
    <a href="#" id="clean" data-role="button" data-theme="e"   style="width: 80%;font-size: 12px;">Limpiar</a>	
    <a href="#" id="btn_mobile_agregar_boleto_tinka" data-role="button" data-theme="d" style="width: 80%;font-size: 12px;">Agregar a boleto</a>    
<!--     <a href="#" id="addShopingTinka" data-role="button" data-theme="d" style="width: 80%;font-size: 12px;">Agregar a boleto</a> -->
	
	</form>
	<BR>
	</li>
    </ul>
</div>

<jsp:include page="../../include/footer-shoppingcart.jsp" />
</body>
</html>