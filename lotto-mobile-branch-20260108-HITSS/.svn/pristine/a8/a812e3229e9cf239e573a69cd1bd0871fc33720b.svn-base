<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@taglib uri="http://www.latinka.com.pe/verifica" prefix="verifica" %>
<%@taglib uri="http://www.latinka.com.pe/verificaMB" prefix="verificaMB" %>
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
<title>La Tinka-Mobile</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/tinkamegabol/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Tinka Megabol móvil, boleto de jugada realizada' />
	
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
			Mi Boleto
			</div>
		</li>
	</ul>
			
	 
	 		<ul style="margin-right: 5px; margin-left: 5px; padding-left: 10px;" class="listContent listContentCuadro">
	 		
	 		   <c:set var="jgda_A" value="false" />
	 		   <c:set var="jgda_B" value="false" />
	 		   <c:set var="jgda_C" value="false" />
	 		   <c:set var="jgda_D" value="false" />
				
				<c:forEach 	var="item"  items="${gameTinkaBoleto}" >

					<li>
					<table style="width: 100%">
					<c:if test="${item.key =='jugada_a'}" >					
					<tr>					
					<td width="97%">
					<span style="font-size: 11px">
					Jugada A : 	${item.value.tinka} Megabolilla ${item.value.megabolilla} </span>	
					 <c:set var="jgda_A" value="true" />
					<br>
					
					<span style="color: red;font-size: 10px">
					<c:if test="${fn:length(item.value.tinka)<6}">
					Debe elegir por lo menos seis opciones en Tinka !
					</c:if>
					<c:if test="${fn:length(item.value.megabolilla)==0}">					
					Debe elegir por lo menos una Megabolilla !
					</c:if>
					</span>	
					
					</td>					
					<td width="3%">
				    <a href="#" onclick="window.location.href='game_tinkamegabol_delete_bet.html?id=${item.key}';"					
					data-role="button" data-icon="delete" data-iconpos="notext">Eliminar</a>
					</td>					
					</tr>
					</c:if>	
					
			        <c:if test="${item.key =='jugada_b'}" >					
					<tr>					
					<td width="97%">
					<span style="font-size: 11px">
					Jugada B : 	${item.value.tinka} Megabolilla ${item.value.megabolilla} </span>	
					 <c:set var="jgda_B" value="true" />
					<br>
					<span style="color: red;font-size: 10px">
					<c:if test="${fn:length(item.value.tinka)<6}">
					Debe elegir por lo menos seis opciones en Tinka !
					</c:if>
					<c:if test="${fn:length(item.value.megabolilla)==0}">					
					Debe elegir por lo menos una Megabolilla !
					</c:if>
					</span>	
						
					</td>					
					<td width="3%">
				    <a href="#" onclick="window.location.href='game_tinkamegabol_delete_bet.html?id=${item.key}';"					
					data-role="button" data-icon="delete" data-iconpos="notext">Eliminar</a>
					</td>					
					</tr>
					</c:if>	
					
					<c:if test="${item.key =='jugada_c'}" >					
					<tr>					
					<td width="97%">
					<span style="font-size: 11px">
					Jugada C : 	${item.value.tinka} Megabolilla ${item.value.megabolilla} </span>	
					<c:set var="jgda_C" value="true" />
					<br>
					<span style="color: red;font-size: 10px">
					<c:if test="${fn:length(item.value.tinka)<6}">
					Debe elegir por lo menos seis opciones en Tinka !
					</c:if>
					<c:if test="${fn:length(item.value.megabolilla)==0}">					
					Debe elegir por lo menos una Megabolilla !
					</c:if>
					</span>	
						
					</td>					
					<td width="3%">
				    <a href="#" onclick="window.location.href='game_tinkamegabol_delete_bet.html?id=${item.key}';"					
					data-role="button" data-icon="delete" data-iconpos="notext">Eliminar</a>
					</td>					
					</tr>
					</c:if>	
					
					<c:if test="${item.key =='jugada_d'}" >					
					<tr>					
					<td width="97%">
					<span style="font-size: 11px">
					Jugada D : 	${item.value.tinka} Megabolilla ${item.value.megabolilla} </span>
					<c:set var="jgda_D" value="true" />
					<br>
					<span style="color: red;font-size: 10px">
					<c:if test="${fn:length(item.value.tinka)<6}">
					Debe elegir por lo menos seis opciones en Tinka !
					</c:if>
					<c:if test="${fn:length(item.value.megabolilla)==0}">					
					Debe elegir por lo menos una Megabolilla !
					</c:if>
					</span>	
							
					</td>					
					<td width="3%">
				    <a href="#" onclick="window.location.href='game_tinkamegabol_delete_bet.html?id=${item.key}';"					
					data-role="button" data-icon="delete" data-iconpos="notext">Eliminar</a>
					</td>					
					</tr>
					</c:if>					    
				    </table>  
					</li>
				</c:forEach>
				
			</ul>

			<ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">
			<li>
			<BR>
			
			<c:if test="${empty consecutiveTinkaValue }">
			<a href="#" onclick="window.location.href='game_tinkamegabol_show_consecutive.html';"	data-role="button" style="width: 80%;font-size: 11px;" data-theme="e">Sorteos consecutivos</a>
			</c:if>
			<c:if test="${!empty consecutiveTinkaValue }">
			<a href="#" onclick="window.location.href='game_tinkamegabol_delete_consecutive.html';"	data-role="button" style="width: 80%;font-size: 11px;" data-theme="e">Quitar Sorteos consecutivos</a>
			</c:if>			
			
			<c:if test="${!jgda_A}">
			<a 	href="#" id="game_tinkamegabol_show_bet_a" data-role="button"  style="width: 80%;font-size: 11px;">Elegir Jugada A</a>
			</c:if>
			
			<c:if test="${!jgda_B}">
			<a 	href="#" id="game_tinkamegabol_show_bet_b" data-role="button"  style="width: 80%;font-size: 11px;">Elegir Jugada B</a>
			</c:if>
			
			<c:if test="${!jgda_C}">
			<a 	href="#" id="game_tinkamegabol_show_bet_c" data-role="button"  style="width: 80%;font-size: 11px;">Elegir Jugada C</a>
			</c:if>
			
			<c:if test="${!jgda_D}">
			<a 	href="#" id="game_tinkamegabol_show_bet_d" data-role="button"  style="width: 80%;font-size: 11px;">Elegir Jugada D</a>
			</c:if>

			<div style="font-size: 11px;">Precio por apuesta : 	S/ 4.00 </div>			
			<div style="font-size: 11px;">Total apuestas : 	${totalBet}	</div>			
			<div style="font-size: 11px;"> <c:if test="${fn:length(consecutiveTinkaValue)>1}">Consecutivo  De ${consecutiveTinkaValue.NUM_DRAW} hasta ${consecutiveTinkaValue.DR_DATE}  </c:if>	</div>			 
		    <div style="font-size: 11px;"> Importe	a Pagar : ${totalTinka}
		    <div style="font-size: 11px;color: red;">${alertNumberPlay}</div>	
		    </div>	
	
			
			<div>
			<c:if test="${!empty clientId && agreement!=''}">
			
			<c:if test="${ind_tk==afirmacion && ind_mb==afirmacion}">
			<a href="#" id="game_tinkamegabol_play_bet"  style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="d" >Comprar esta apuesta </a>
			</c:if>
			
			<c:if test="${ind_tk==negacion && ind_mb==negacion}">
			<a href="#" id=""  style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="d" >Comprar esta apuesta </a>
			</c:if>
			
			<c:if test="${ind_tk==afirmacion && ind_mb==negacion}">
			<a href="#" id=""  style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="d" >Comprar esta apuesta </a>
			</c:if>
			
		   <c:if test="${ind_tk==negacion && ind_mb==afirmacion}">
			<a href="#" id=""  style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="d" >Comprar esta apuesta </a>
			</c:if>
			
			</c:if>
			
			
			
			<c:if test="${empty clientId or agreement==''}">
			<c:if test="${ind_tk==afirmacion && ind_mb==afirmacion}">
			<a href="#" id="security_login_execute_authentication_tinkamegabol" data-role="button" style="width: 80%;font-size: 11px;" data-icon="check" data-theme="d">Comprar esta apuesta </a>
			</c:if>
			
		    <c:if test="${ind_tk==negacion && ind_mb==negacion}">
			<a href="#" id=""  style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="d" >Comprar esta apuesta </a>
			</c:if>
			
			<c:if test="${ind_tk==afirmacion && ind_mb==negacion}">
			<a href="#" id=""  style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="d" >Comprar esta apuesta </a>
			</c:if>
			
		   <c:if test="${ind_tk==negacion && ind_mb==afirmacion}">
			<a href="#" id=""  style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="d" >Comprar esta apuesta </a>
			</c:if>
			</c:if>
			
			</div>
			<BR>
			</li>
			</ul>
 
   </div>
<jsp:include page="../../include/footer-shoppingcart.jsp" />
</body>
</html>