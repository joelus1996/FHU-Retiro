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
	
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Te Apuesto : Combinadas</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/teapuesto/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<script type="text/javascript">
//TE APUESTO         
$(document).delegate('fieldset input[type=checkbox]', 'change', function (event) {
    console.log('teapuesto');
    if ($(this).attr('id').substring(0, 8) == 'multiply') {
        if ($(this).is(":checked")) {
            count_multiply++;
            if (count_multiply > 3) {
                $(this).attr('checked', false);
                count_multiply--
            }
        } else {
            count_multiply--
        }
    }

    if ($(this).attr('id').substring(0, 11) == 'combination') {
        if ($(this).is(":checked")) {
            count_combination++;
            if (count_combination > 3) {
                $(this).attr('checked', false);
                count_combination--
            }
        } else {
            count_combination--
        }
    }

    if ($(this).attr('id').substring(0, 11) == 'consecutive') {
        if ($(this).is(":checked")) {
            count_consecutive++;
            if (count_consecutive > 1) {
                $(this).attr('checked', false);
                count_consecutive--;
            }
        } else {
            count_consecutive--
        }
    }
});
</script>
<meta name='description' content='Te Apuesto móvil, agregando Combinación a boleto de jugadas ' />
	
</head>
<body>
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

<jsp:include page="../../include/header.jsp" />
   
   <div align="center" >    
   <BR>   
   	<ul data-role="listview" data-inset="true" data-theme="e" style="margin-right: 42px; margin-left: 42px;">
		<li data-role="list-divider">
		<div align="center">
		COMBINADAS
		</div>
	</li>	
	 </ul>
	 <ul style="margin-right: 5px; margin-left: 5px;">
	 <li>
	 <BR> 
	 <form action="game_teapuesto_add_combined.html" method="post" id="game_teapuesto_add_combined">
    <div style="width: 75%">
    <fieldset data-role="controlgroup" >	
     
     <input type="checkbox"  id="combination_1" name="combination" value="1" />
	 <label for="combination_1" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 1</label>
	   <input type="checkbox"  id="combination_2" name="combination" value="2"/>
	 <label for="combination_2" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 2</label>
	   <input type="checkbox"  id="combination_3"  name="combination" value="3"/>
	 <label for="combination_3" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 3</label>
	   <input type="checkbox"  id="combination_4"  name="combination" value="4"/>
	 <label for="combination_4" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 4</label>
	   <input type="checkbox"  id="combination_5"  name="combination" value="5"/>
	 <label for="combination_5" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 5</label>
	   <input type="checkbox"  id="combination_6"  name="combination" value="6"/>
	 <label for="combination_6" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 6</label>
	   <input type="checkbox"  id="combination_7"  name="combination" value="7"/>
	 <label for="combination_7" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 7</label>
	   <input type="checkbox"  id="combination_8"  name="combination" value="8"/>
	 <label for="combination_8" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 8</label>
	   <input type="checkbox"  id="combination_9"  name="combination" value="9"/>
	 <label for="combination_9" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 9</label>
	   <input type="checkbox"  id="combination_10"  name="combination" value="10"/>
	 <label for="combination_10" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 10</label>
	   <input type="checkbox"  id="combination_11"  name="combination" value="11"/>
	 <label for="combination_11" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 11</label>
	   <input type="checkbox"  id="combination_12"  name="combination" value="12"/>
	 <label for="combination_12" style="text-align: center;font-size: 12px;height:38.5px;">Combinar de 12</label>
	
	</fieldset>  
	</div> 
	 <a href="#" id="addCombination" data-role="button" data-mini="true" style="width: 80%;font-size: 12px;">Aceptar</a>	      
    </form>	
    <BR> 
	</li>
	
	</ul>
   </div>
   
	  	<ul style="margin-right: 5px; margin-left: 5px;"> 	
  	        <li class="arrow"><small><img src="layer-view-image/common/arrow.png" /></small><a href="home.html"><span style="font-size: 13px;">Juegos</span></a> </li>
  	        <li class="arrow"><small><img src="layer-view-image/common/arrow.png" /></small><a href="#"><span style="font-size: 13px;">Ayuda</span></a> </li>	
   </ul>

</body>
</html>