<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
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
    <title>Deportes Virtuales: Juego de Deportes virtuales, Perú - La Tinka</title>
    <meta name='description' content="Deportes Virtuales" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
</head>
<body style="background-color: #D7E2E4">
<!-- <body class="main-copaentucasa-results"> -->
<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<c:set var="lapollaEnabled"><%=Boolean.valueOf(Constantes.lapollaEnabled.trim()).booleanValue()%></c:set>
	<c:set var="tav2Enabled"><%=Boolean.valueOf(Constantes.tav2Enabled.trim()).booleanValue()%></c:set>
	<c:set var="bannersUrl"><%=Constantes.bannersUrl.toString().trim()%></c:set>
	<c:set var="gamesXML"><%=Constantes.gamesXML.toString().trim()%></c:set>
	<input type="hidden" id="clientId" value='${clientId}'>
	<div class="container">	
			<jsp:include page="../../../include/header.jsp" />
		<div class="content-wrap">		
			<div class="content">		
				<section class="main-section">
				<div id="JuegaGanaDDVV-retroceder" class="copacasa-volver" style="background-color: #000000; height:53px;">
					  <div class="row" style="width: 100%">
						    <div class="col-sm-4">
						    	<img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png">
						    </div>
						    <div class="col-sm-4" style="margin:0px auto">
						    	<img style="margin-top: 4px;" class="img-volver" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/header-mobile-virtuales.png" alt="Juega Deportes Virtuales">
						    </div>
						    <!-- <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div> -->
						  </div>					
				</div>
				
				<c:set var="nivel" value="" />
				<c:set var="imagen" value="" />
				
				<c:choose>
				  <c:when test="${totalTicket >= 0 && totalTicket <= 9}">
				    <c:set var="nivel" value="CALICHÍN" />
				    <c:set var="imagen" value="img-level-calichin-header.png" />
				  </c:when>
				  <c:when test="${totalTicket >= 10 && totalTicket <= 49}">
				    <c:set var="nivel" value="AMATEUR" />
				    <c:set var="imagen" value="img-level-amateur-header.png" />
				  </c:when>
				  <c:when test="${totalTicket >= 50 && totalTicket <= 99}">
				    <c:set var="nivel" value="CRACK" />
				    <c:set var="imagen" value="img-level-crack-header.png" />
				  </c:when>
				  <c:when test="${totalTicket >= 100}">
				    <c:set var="nivel" value="LEYENDA" />
				    <c:set var="imagen" value="img-level-leyenda-header.png" />
				  </c:when>
				</c:choose>
						
				<div class="posicion-nivel-img">
					<img src="layer-view-image/game/copaentucasa/${imagen}" class="level-header-copa-casa" >
					<div class="desc-nivel-position">
						<span class="tipo-nivel">${nivel}</span>
						<br>
						<span class="tipo-nivel-descripcion-superior">Tienes </span>
						<span class="puntaje-por-nivel">${puntajeNivel}</span>
						<br>
						<span class="tipo-nivel-descripcion">opciones para los sorteos</span>
						<br>
						<span class="tipo-nivel-descripcion">de premios mayores</span>
					</div>
				</div>
				 
				<div class="desc-total-tickets-avionQatar">
					<h3 style="font-family: AmsiPro-Ultra;">VAS ${totalTicket} JUGADAS ACUMULADAS</h3>
				</div>
				
				<c:if test="${totalTicket >=0 && totalTicket<=9}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-calichin.png">
				</c:if>
				<c:if test="${totalTicket >=10 && totalTicket<=49}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-amateur.png">
				</c:if>
				<c:if test="${totalTicket >=50 && totalTicket<=99}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-crack.png" >
				</c:if>
				<c:if test="${totalTicket >=100}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-leyenda.png">
				</c:if>
				 
				<div>
					<div class="desc-sorteo">
						<h3 style="font-size: 12px; color: #000000;font-family: AmsiPro-Bold;">SORTEOS <c:out value="${SORTEO1}"/> Y <c:out value="${SORTEO2}"/>:</h3>
					</div>	
					<img class="responsive-imagenes" style="width: 330px;margin-bottom: 30px;" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/banner-mobile-virtuales.png" alt="Juega Deportes Virtuales">		
					<div class="desc-sorteo"><h3 style="font-size: 14px; color: #000000;font-family: AmsiPro-Bold;">También puedes ganar S/ 5 de saldo al instante</h3></div>	
					<div class="desc-sorteo"><h3 style="font-size: 18px; color: #fb5300;font-family: AmsiPro-Ultra;margin-bottom: 2px;">¡Son S/ 10,000 en saldos para </h3></div>	
					<div class="desc-sorteo"><h3 style="font-size: 18px; color: #fb5300;font-family: AmsiPro-Ultra;">seguir jugando!</h3></div>
				</div>
						<div class="tabla-puntajes">				
						<!-- No mover estilos de la tabla copa en tu casa y th --> 					 
						<table class="table-result">
				    <tr>
				      <th class="header izq">Sorteos</th>
				      <th class="header der">N° de Jugadas</th>
				    </tr>
				    <c:forEach var="item" items="${listTickets}">
				      <c:choose>
				        <c:when test="${activaPremio eq item.promId}">
				          <tr>
				            <c:if test="${item.promId eq 'SORTEO1' || item.promId eq 'SORTEO2' || item.promId eq 'SORTEO3'}">
				              <td style="color:#f75b1e" class="center izq">${item.promDate}</td>
				              <td style="color:#f75b1e" class="center der">${item.promCount}</td>
				            </c:if>
				          </tr>
				        </c:when>
				        <c:otherwise>
				          <tr>
				            <c:if test="${item.promId eq 'SORTEO1' || item.promId eq 'SORTEO2' || item.promId eq 'SORTEO3'}">
				              <td class="center izq">${item.promDate}</td>
				              <td class="center der">${item.promCount}</td>
				            </c:if>
				          </tr>
				        </c:otherwise>
				      </c:choose>
				    </c:forEach>
				    <tr>
				      <th class="header izq">Total jugadas:</th>
				      <th class="header der">${totalTicket}</th>
				    </tr>
				  </table>
				</div>
				<div class="desc-sorteo2" style=" background-color: #d7e2e4;" ><h3 style="color:#000000" >¡Sigue aumentado tus posibilidades de ganar!</h3>
					<div style="text-align: center;">
						<button id="btn_mobile_virtuales_home" type="button" class="button-juegaGanaVirtuales-naranja" style="font-size: 16px;width:197px;padding-bottom: 7px;">Juega desde S/ 5</button>
					</div>
				</div>
				</section>
			</div>
		</div>	
	</div>			
<jsp:include page="../../../include/footer.jsp" />
</body>
</html>