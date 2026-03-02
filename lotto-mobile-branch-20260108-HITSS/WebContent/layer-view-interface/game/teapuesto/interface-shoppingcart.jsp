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
<title>Te Apuesto : Boleto</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/teapuesto/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Te Apuesto móvil, boleto de jugada realizada' />
	
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
					<img src="layer-view-image/game/teapuesto/logo_teapuesto_small.png" title="Te Apuesto" alt="Te Apuesto" />
					<BR>
					Mi boleto</div>
				</li>
	</ul>
			
	 
	 		<ul style="margin-right: 5px; margin-left: 5px; padding-left: 10px; " class="listContent listContentCuadro">
				
				<c:forEach 	var="item"  items="${ShoppingListTeapuesto}">
					<li>
					<table style="width: 100%">
					<tr>				
					<td width="97%">				
					
					<span style="font-size: 11px">${item.value.local}  vs.  ${item.value.visit}</span>
					<BR>
					<span style="font-size: 11px">min ${item.value.min}</span> |
					<span style="font-size: 11px">
					<c:if test="${item.value.tipo == 'r'}">
					-
					</c:if> 
					<c:if test="${item.value.tipo == 's'}">
					+
					</c:if>
					<c:if test="${(item.value.tipo) != 's' && (item.value.tipo != 'r')}">
					${item.value.tipo}
					</c:if>
					${item.value.valor}
					</span>
					</td>
					<td width="3%">
					<a href="#" onclick="window.location.href='game_teapuesto_delete_bet.html?id=${item.value.event}-${item.value.draw}-${item.value.game}';"					
					data-role="button" data-icon="delete" data-iconpos="notext">Eliminar</a>
					</td>
					</tr>					
					</table>								
					</li>
				</c:forEach>				
				
			</ul>
			
			<ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">
			<li>
			<BR>
		    <a href="#" onclick="window.location.href='game_teapuesto_show_menu.html';" data-role="button"  style="width: 80%;font-size: 11px;">		
		    Elegir otro partido		 
		    </a>
		    
			<a href="#" onclick="window.location.href='game_teapuesto_delete_bet.html?id=all';"	data-role="button"  style="width: 80%;font-size: 11px;">
			Eliminar todo		
			</a>
			
			<c:if test="${empty arrayMultiply }">
			<a href="#" onclick="window.location.href='game_teapuesto_show_multiplier.html';"	data-role="button"  style="width: 80%;font-size: 11px;">		
			Multiplicar		
			</a>
			</c:if>
			<c:if test="${!empty arrayMultiply }">
			<a href="#" onclick="window.location.href='game_teapuesto_delete_multiplier.html';" 	data-role="button"  style="width: 80%;font-size: 11px;">		
			Quitar multiples		
			</a>
			</c:if>
			
			<c:if test="${empty arrayCombination }">
			<a href="#" onclick="window.location.href='game_teapuesto_show_combined.html';"	data-role="button"  style="width: 80%;font-size: 11px;">			
			Combinar		
			</a>
			</c:if>
			
		    <c:if test="${!empty arrayCombination }">
			<a href="#" onclick="window.location.href='game_teapuesto_delete_combined.html';" data-role="button"  style="width: 80%;font-size: 11px;">			
			Quitar combinaci&oacute;n			
			</a>
		    </c:if>
		   
	
		    <span style="color: red; font-size: 11px">${mensaje_alerta}</span>
			<div style="font-size: 11px;">Total partidos : 	${fn:length(ShoppingListTeapuesto)}	</div>
			
			<div style="font-size: 11px;"> <c:if test="${fn:length(arrayCombination)>0}">Combinadas  ${arrayCombination}  </c:if>	</div>
			
			<div style="font-size: 11px;"> <c:if test="${fn:length(arrayMultiply)>0}">Multiplica x ${arrayMultiply}
		    Total : ${totalMultiplier}
			</c:if>	</div>			
			
			<c:if test="${empty arrayCombination && empty arrayMultiply}">	
			<c:if test="${!empty amountMax}">
			<div style="font-size: 11px;"> Monto m&aacute;ximo a ganar : <limit:limit maxima="${amountMax}"/></div>
			</c:if>
			
			<c:if test="${empty amountMax}">
			<div style="font-size: 11px;"> Monto m&aacute;ximo a ganar : S/. 0</div>
			</c:if>
			 </c:if>	
		    
		    <c:if test="${empty arrayCombination && !empty arrayMultiply}">		
			<div style="font-size: 11px;"> Monto m&aacute;ximo a ganar : ${amountMax}</div>
			
			 </c:if>
		    
		    		    	        
		    <c:if test="${empty arrayCombination }">	
		    <c:if test="${!empty amountMax}">
			<div style="font-size: 11px;"> Importe	a pagar : ${total} </div>
			</c:if>		    
		    
		    
		    <c:if test="${empty amountMax}">
			<div style="font-size: 11px;"> Importe	a pagar : S/. 0</div>
			</c:if>	
		    </c:if>
		      
		    	  
		    	    
		    <c:if test="${!empty arrayCombination && empty arrayMultiply }">		    
		    <div style="font-size: 11px;"> Monto m&aacute;ximo a ganar : ${totalpago}</div>
		    <div style="font-size: 11px;"> Importe	a pagar : ${movimiento} </div>	
		    </c:if>
		
		    
		    
 			<c:if test="${!empty arrayMultiply && !empty arrayCombination}">		    
		  	<div style="font-size: 11px;"> Monto m&aacute;ximo a ganar: ${totalpago_M_C_M}</div>
		    <div style="font-size: 11px;"> Importe	a pagar : ${movimiento_M_C}</div>	
		    </c:if>
			
			<div>
			<c:if test="${!empty clientId && agreement!=''}">
			<a href="#" id="game_teapuesto_play_bet" style="width: 80%;font-size: 11px;" data-role="button"	data-icon="check" data-theme="b" >Comprar esta apuesta</a>
			</c:if>
			<c:if test="${empty clientId or agreement==''}">
			<a href="#" id="security_login_execute_authentication_teapuesto" data-role="button" style="width: 80%;font-size: 11px;" data-icon="check" data-theme="b">Comprar esta apuesta</a>
			</c:if>
			</div>
			<BR>
			</li>
			</ul>
 
   </div>   
   
   <jsp:include page="../../include/footer-shoppingcart.jsp" />
	
</body>
</html>