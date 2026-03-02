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
<title>Tinka Megabol : Jugada</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/tinkamegabol/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Tinka Megabol móvil, realiza una jugada consecutiva ' />
	
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
			<BR>
		Sorteos Consecutivos
		</div>
		</li>	
	 </ul>
	 	 
	 <ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">
	 <li>
	 <BR>
	  <form action="game_tinkamegabol_add_consecutive.html" method="post" id="game_tinkamegabol_add_consecutive">	 
     <div data-role="fieldcontain" style="width: 75%">

    <fieldset data-role="controlgroup">	
    <c:forEach 	var="item"  items="${consecutiveTinkaList}">   
    <input type="checkbox" name="consecutive" value="${item.NUM_DRAW}" id="consecutive_checkbox_${item.NUM_DRAW}" class="custom"  />
	<label for="consecutive_checkbox_${item.NUM_DRAW}" style="text-align: center;font-size: 12px;height: 38.5px;">De ${item.NUM_DRAW} hasta ${item.DR_DATE}</label>
    </c:forEach>
	</fieldset>		
	
	</div>
	<a href="#" data-role="button" id="addConsecutiveTinkamegabol" data-role="button" style="width: 80%;font-size: 12px;" data-theme="e">Aceptar</a>
	</form>
	<BR>
	</li>
	</ul>	 
	 		
   </div>
<jsp:include page="../../include/footer-shoppingcart.jsp" />
</body>
</html>