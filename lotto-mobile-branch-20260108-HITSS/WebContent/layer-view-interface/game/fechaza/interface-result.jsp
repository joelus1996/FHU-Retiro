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
<title>Fechaza : Resultados</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">   
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/fechaza/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Fechaza móvil, muestra los ultimos resultados del juego' />
	
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
	        Resultados del <fmt:formatDate type="both"  pattern="EEEE, dd MMMM " value="${title}" />								
			</div>				
		</li>
	</ul>
			
    <ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">	
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
				var="item" varStatus="status" items="${resultGamesFechaza}">
			
				<li class="arrow">			
				<div style="font-size: 11px;">${item.drawPk.drawId} - <fmt:formatDate type="time" value="${item.drawDate}" />
				</div>
				<div style="font-size: 11px;">(${item.result})
				</div>
				
				</li>
			
			</c:forEach>
			<c:set value="${fn:length(resultGamesFechaza)}" var="rLen" />

			<c:choose>
				<c:when test="${rLen lt rowEnd}">
					<c:set var="rCurrEnd" value="${rLen}" />
				</c:when>
				<c:otherwise>
					<c:set var="rCurrEnd" value="${rowEnd}" />
				</c:otherwise>
			</c:choose>


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
    </ul>
       <c:forEach items="${dateResultFechaza}" var="item">
	    <a href="#" onclick="window.location.href='game_fechaza_filter_result.html?filter=${fn:substring(item,0,10)}';" 
			data-role="button" style="width: 80%;font-size: 11px;">		
			Resultados del <fmt:formatDate type="both"  pattern="EEEE, dd MMMM " value="${item}" />			
		</a>
		</c:forEach>
</div>
<jsp:include page="../../include/footer.jsp" />
</body>
</html>