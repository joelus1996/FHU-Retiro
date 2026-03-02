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
<title>Te Apuesto : Partidos</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/teapuesto/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Te Apuesto móvil, lista de partidos disponibles para apostar ' />
	
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
					<c:if test="${empty title }">
					<img src="layer-view-image/game/teapuesto/logo_teapuesto_small.png" title="Te Apuesto" alt="Te Apuesto" />
					</c:if>	
					<c:if test="${!empty title }">Partidos del 			
					<fmt:formatDate  pattern="EEEE, dd MMMM " value="${title}" />
					</c:if>	
					</div>
				</li>
			</ul>
			
    <ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">		     
		<li>
		<BR>
		<c:if test="${empty filter}">
		<div  align="center" style="font-weight: bold;" >Partidos Destacados</div>
		</c:if>
		<c:if test="${!empty filter}">
		<div  align="center" style="font-weight: bold;" ></div>
		</c:if>
		<BR>
		<c:set value="15" var="pageSize" />
			<c:choose>
				<c:when test="${empty param.from}">
					<c:set var="rowBEGIN" value="1" />
				</c:when>
				<c:otherwise>
					<c:set var="rowBEGIN" value="${param.from}" />
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${empty param.to}">
					<c:set var="rowEnd" value="${pageSize}" />
				</c:when>
				<c:otherwise>
					<c:set var="rowEnd" value="${param.to}" />
				</c:otherwise>
			</c:choose>
			<c:forEach begin="${rowBEGIN-1}" step="1" end="${rowEnd-1}"
				var="item" varStatus="status" items="${resultListTeapuesto}">
				<a
					href="#" onclick="window.location.href='game_teapuesto_show_bet.html?event=${item.eventpk.event}&draw=${item.eventpk.draw}&game=${item.eventpk.game}';"
					data-role="button" style="width: 80%;" data-icon="plus" >
					
					<div style="font-weight: normal;text-align:center;float:right; font-size: 10px; color: #ffffff; padding:0 4px 1.5px 4px;
					
					<c:if test="${item.minimum == 1}" >
					background-color: red; 
					</c:if>
					<c:if test="${item.minimum == 2}" >
					background-color: orange; 
					</c:if>
					<c:if test="${item.minimum == 3}" >
					background-color: blue; 
					</c:if> 
										
					">
					${item.minimum}	
					</div>
					 
					<div style="font-size: 8.5px;">
				    ${item.teamLocal} vs ${item.teamVisitor} 
				    </div>
				    <div style="font-size: 8.5px;">
				    (L ${item.unoLoad})  (E ${item.xLoad})   (V ${item.dosLoad}) 	
					</div>
				</a>
			</c:forEach>
			<c:set value="${fn:length(resultListTeapuesto)}" var="rLen" />

			<c:choose>
				<c:when test="${rLen lt rowEnd}">
					<c:set var="rCurrEnd" value="${rLen}" />
				</c:when>
				<c:otherwise>
					<c:set var="rCurrEnd" value="${rowEnd}" />
				</c:otherwise>
			</c:choose>
			
			<div align="center">
			<span style="text-align:center; font-size: 10px; color: #ffffff;  background-color: red; margin-left: 3px; padding:0 0.4px 1.5px 4px;"> 1 </span>
			<span style="text-align:center;font-size: 10px; color: #ffffff;  background-color: orange; margin-left: 3px; padding:0 0.4px 1.5px 4px;"> 2 </span>
			<span style="text-align:center;font-size: 10px; color: #ffffff;  background-color: blue; margin-left: 3px; padding:0 0.4px 1.5px 4px;"> 3 </span>
			<span style="font-size: 10px; color: #000000;   margin-left: 3px; "> Indican la cantidad mínima de partidos a jugar. </span>
			</div>
		
			<br>
			<div align="center">
				<span style="font-size: 10px;">
				<b> Mostrando ${rCurrEnd} de ${rLen}</b>
				
				
				<c:if test="${rowBEGIN gt 1}">			
				<div>		
				<a href="#" onclick="window.location.href='${filter}&from=${rowBEGIN-pageSize}&to=${rowEnd-pageSize}';"
				class="ui-link ui-btn ui-btn-icon-notext ui-btn-corner-all ui-shadow ui-btn-up-d" 
				title="Previo" data-theme="d">
				<span class="ui-btn-inner ui-btn-corner-all" >
				<span class="ui-btn-text">Previo</span>
				<span class="ui-icon ui-icon-arrow-l ui-icon-shadow"></span></span></a>
				</div>
				</c:if>
						
				<c:if test="${rowEnd lt rLen}">
				<div>
				<a href="#" onclick="window.location.href='${filter}&from=${rowBEGIN+pageSize}&to=${rowEnd+pageSize}';" 
				class="ui-link ui-btn ui-btn-icon-notext ui-btn-corner-all ui-shadow ui-btn-up-d" 
				title="Siguiente" >
				<span class="ui-btn-inner ui-btn-corner-all" >
				<span class="ui-btn-text">Siguiente</span>
				<span class="ui-icon ui-icon-arrow-r ui-icon-shadow"></span>
				</span>				
				</a>
				</div>
				</c:if>
				
				
				</span>
			</div>
		
		<c:forEach items="${homeTapuesto}" var="item"> 
			<a	href="#" onclick="window.location.href='game_teapuesto_filter_game.html?filter=${fn:substring(item[1],0,10)}';" 
			data-role="button" style="width: 80%;" >
			<span style="font-size: 11px;">
			Partidos del <fmt:formatDate type="both"  pattern="EEEE, dd MMMM " value="${item[1]}" />
			</span>					    
			</a>		
		</c:forEach>
	
		 <BR>
		  <a href="#" onclick="window.location.href='game_teapuesto_show_result.html';" data-role="button"  style="width: 80%;font-size: 12px;" data-theme="b">		
		  Resultados	 
		  </a>
		<BR>
		</li>		    
	
    </ul>
   </div>
	
   <jsp:include page="../../include/footer.jsp" />
	
</body>
</html>