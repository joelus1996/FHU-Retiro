<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@ include file="variables.jsp" %>

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
    <title>Avión del Hincha: Te Apuesto te lleva a las Eliminatorias del Mundial 2026.</title>
    <meta name='description' content="¡Vive la emoción del fútbol en vivo! Te Apuesto te lleva a los emocionantes partidos de las Eliminatorias del Mundial 2026 en Perú." />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css" type="text/css"/>
	
</head>
<body style="background-color: #d7e2e4">
<!-- <body class="main-copaentucasa-results"> -->
<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->


	<input type="hidden" id="clientId" value='${clientId}'>
	<div class="container">	
			<jsp:include page="../../../include/header.jsp" />
		<div class="content-wrap">		
			<div class="content">		
				<section class="main-section">				
				<div id="avionPeru-retroceder" class="copacasa-volver" style="background-color: #F77425;">
					<div class="row" style="width: 100%">
						<div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						<div class="col-sm-4" style="margin:0px auto"><img style="margin-top: 4px;" class="img-volver" src="layer-view-image/game/teapuesto/avionPeru/header-mobile-peru.png" ></div>
					</div>					
				</div>
				
				<c:set var="nivel" value="" />
				<c:set var="imagen" value="" />
				
				<c:choose>
				  <c:when test="${totalTicket >= 0 && totalTicket <= 200}">
				    <c:set var="nivel" value="CALICHÍN" />
				    <c:set var="imagen" value="img-level-calichin-header.png" />
				  </c:when>
				  <c:when test="${totalTicket >= 201 && totalTicket <= 500}">
				    <c:set var="nivel" value="AMATEUR" />
				    <c:set var="imagen" value="img-level-amateur-header.png" />
				  </c:when>
				  <c:when test="${totalTicket >= 501 && totalTicket <= 1000}">
				    <c:set var="nivel" value="CRACK" />
				    <c:set var="imagen" value="img-level-crack-header.png" />
				  </c:when>
				  <c:when test="${totalTicket >= 1001}">
				    <c:set var="nivel" value="LEYENDA" />
				    <c:set var="imagen" value="img-level-leyenda-header.png" />
				  </c:when>
				</c:choose>
						
				<div class="posicion-nivel-img">
					<img src="layer-view-image/game/copaentucasa/${imagen}" class="level-header-copa-casa" alt="Avión del Hincha Eliminatorias 2026">
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
					<h3 >TUS ${totalTicket} PUNTOS ACUMULADOS<br> SE MULTIPLICAN DE ACUERDO A TU NIVEL</h3>
				</div>
				
				<c:if test="${totalTicket >=0 && totalTicket<=200}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-calichin.png" alt="Avión del Hincha Eliminatorias 2026">
				</c:if>
				<c:if test="${totalTicket >=201 && totalTicket<=500}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-amateur.png" alt="Avión del Hincha Eliminatorias 2026">
				</c:if>
				<c:if test="${totalTicket >=501 && totalTicket<=1000}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-crack.png" alt="Avión del Hincha Eliminatorias 2026">
				</c:if>
				<c:if test="${totalTicket >=1001}">
				<img class="responsive-imagenes" src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-leyenda.png" alt="Avión del Hincha Eliminatorias 2026">
				</c:if>
				 
				<div>
					<img class="responsive-imagenes" style="width: 330px;margin-bottom: 30px;" src="layer-view-image/game/teapuesto/avionPeru/banner-mobile-peru.png" alt="Avión del Hincha Eliminatorias 2026.">		
					<div class="desc-sorteo"><h3 style="font-size: 14px; color: #000000;font-family: AmsiPro-Bold;">También puedes ganar S/ 5 de saldo al instante</h3></div>	
					<div class="desc-sorteo"><h3 style="font-size: 15px; color: #fb5300;font-family: AmsiPro-Bold;margin-bottom: 2px;">SORTEO <c:out value="${SORTEO1}"/> </h3></div>
				</div>
				
				<div class="desc-sorteo2" style=" background-color: #d7e2e4;" ><h3 style="color:#000000" >¡Sigue aumentado tus posibilidades de ganar!</h3>
					<div style="text-align: center;">
						<button id="btn_mobile_teapuesto_home" type="button"   onclick="return false;"class="button-avion-qatar-naranja" style="font-size: 16px;width:197px;padding-bottom: 7px;">Juega desde S/ 10</button>
					</div>
				</div>
				</section>
			</div>
		</div>	
	</div>			
<jsp:include page="../../../include/footer.jsp" />
</body>
</html>