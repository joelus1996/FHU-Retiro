<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<c:if test="${flagPromoBicolor == 0 }"><c:redirect url="/"/></c:if>
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
    <title>Juego de apuestas deportivas en Perú - Ganagol</title>
    <meta name='description' content="La Tinka es la compañia líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto." />	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
</head>
<body style="background-color: #007c37">
<!-- <body class="main-copaentucasa-como-participar"> -->
<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<c:set var="lapollaEnabled"><%=Boolean.valueOf(Constantes.lapollaEnabled.trim()).booleanValue()%></c:set>
	<c:set var="tav2Enabled"><%=Boolean.valueOf(Constantes.tav2Enabled.trim()).booleanValue()%></c:set>
	<c:set var="bannersUrl"><%=Constantes.bannersUrl.toString().trim()%></c:set>
	<c:set var="gamesXML"><%=Constantes.gamesXML.toString().trim()%></c:set>
	<input type="hidden" id="clientId" value='${clientId}'>
	<input type="hidden" id="flagPromo" value='${flagPromo}'>

	<div class="container">	
			<jsp:include page="../../include/header.jsp" />		
		<div class="content-wrap" style=" color: #ffffff;" >		
			<div class="content">		
				<section class="main-section">				
					<div id="copabicolor-retroceder" class="copacasa-volver" style="background-color: #007c37;">
						  <div class="row" style="width: 100%;">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						    <div class="col-sm-4" style="margin: 0px auto;">
						    	<img class="img-volver" style="margin-top: 11px;" src="layer-view-image/game/copabicolor/img-logo-premiazogg-mobile.png">
						    </div>
						    <!-- <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div> -->
						  </div>					
					</div>
					
					<div class="copacasa-como-participar">
						<h3>¿Cómo participar?</h3>
						<h4>Si juegas desde <a href="http://www.ganagol.com.pe/"  class="TyC_Enfatizar">www.ganagol.com.pe</a>, todos tus tickets S/ 3 participan AUTOMÁTICAMENTE</h4>
						
					</div>
					<div style="background: #ffffff;" class="f_linea-copacasa"></div>
					<div  class="copacasa-terminos">
						<ul>
							<li>Válida solo para todos los clientes que acepten participar de la promoción.</li> 
							<li>No participan tickets obtenidos con saldo bono.</li>
							<li>Válido desde el martes 21 de junio al domingo 31 de julio del 2022.</li>
							<li>Participan todos los tickets validos igual o mayor a S/ 3, jugados desde <a href="http://www.ganagol.com.pe/"  class="TyC_Enfatizar" >www.ganagol.com.pe</a> y puntos de venta, comprados durante la vigencia de la promoción.</li>
						</ul>
					</div>
					
					<div class="copacasa-reglas">
						<h3 >SI JUEGAS DESDE WWW.GANAGOL.COM.PE</h3>
							<ul>
								<li>Participas AUTOMÁTICAMENTE con tus tickets desde S/ 3.</li>
								<li>Puedes revisar el avance de las oportunidades con que participas, en cada sorteo de premios mayores ingresando <a href="#" onclick="validateMisJugadas();" class="TyC_Enfatizar">"Ver mis jugadas"</a> en la página de la promoción, una vez hayas aceptado participar.</li>								
							</ul>
						<h3>SI JUEGAS EN PUNTO DE VENTA</h3>
							<ul>
								<li>Sube la foto de tu ticket registrándolo en el módulo promocional "Premiazo Ganagol" en <a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar">www.programateapuesto.pe</a>.</li>
								<li>Puedes revisar el avance de tu participación y premios obtenidos en la misma página de la promoción.</li>
							</ul>
					</div>
					
					<div style="margin-top: 30px;margin-left: 22px;margin-right: 22px;margin-bottom: 10px;font-size: 13px;padding-bottom: 20px;"> 
						<img class="niveles-participar" src="layer-view-image/game/copabicolor/img-terminos-niveles-mobile.png">
					</div>
										
					<div class="copacasa-sorteos">
						<div class="premios1">
							<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa.png">
							<span class="desc-premios1">PREMIOS MAYORES PARA 4 GANADORES</span>
						</div>			
								<ul>
									<li>Son S/ 25,000 para cada ganador.</li>
									<li><b>Sorteos:</b> 18 de julio y 01 de agosto del 2022.</li>
									<p style="margin: 0px;">En cada sorteo se elegirán 2 ganadores y 2 suplentes que permanecerán como respaldo en caso uno o más de ganadores no respondan al ser contactado o no cumpla con los requisitos para recibir el premio.</p>
									
									<li>Participas en cada sorteo con el número de tickets acumuladas hasta el día anterior al sorteo. Si juegas en la web, revísalos aquí <a href="#" onclick="validateMisJugadas();" class="TyC_Enfatizar">"Ver mis jugadas"</a>. Si juegas en un punto de venta físico, revísalos en la sección "Ver mis premios" de la página donde ingresaste tu tickets.</li>
									<li>Nos pondremos en contacto con cada uno de los ganadores al celular registrado y se validarán en Reniec la veracidad de sus datos y mayoría de edad.</li>
									<li>En caso de: 1: No obtener respuesta de alguno de los ganadores en un plazo de 24 horas desde realizado el sorteo, 2: Se verifique que no cumple con la mayoría de edad, 3: Que haya ganado antes uno de los premios mayores de esta promoción, y/o 4: Se verifique cualquier otra situación que impida otorgar uno de los premios, de acuerdo a los presentes Términos y Condiciones, así como el <a href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-ganagol.pdf" class="TyC_Enfatizar">Reglamento de Ganagol<a>, se procederá a retirarlo de la lista de ganadores y en su lugar se le otorgará el premio al primero de los suplentes según el orden en que salió sorteado. </li>
									<li>Los ganadores de cada sorteo serán publicados en el Facebook de <a href="https://www.facebook.com/GanagolOficial" class="TyC_Enfatizar">GanagolOficial</a> dentro de las 24 horas de haber realizado el sorteo.</li>
									<li><b>Entrega de premios y comunicación:</b> Coordinaremos todos los detalles de la entrega del premio a ser entregado en un plazo de 60 días útiles una vez formalizado el contacto con el ganador via correo electrónico. A su vez como ganador te comprometes a brindar todos los accesos adecuados para poder hacer la entrega del premio y a firmar un acuerdo para poder comunicar el acontecimiento a través de Facebook.</li>								
								</ul>
						<div class="premios2">		
							<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa.png">
							<span class="desc-premios2">PREMIOS SECUNDARIOS PARA JUGADORES WEB</span>
						</div>
						<ul style="padding-bottom: 0px; ">
							<li>S/ 6,000 en saldos para 1,500 ganadores Cada ganador se llevará un bono de S/ 4 AL INSTANTE para jugar Ganagol. 
						Y se entregarán durante el período de vigencia de la promoción.</li>
						</ul> 
						<br>	 
						<div class="premios3">		
							<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa.png">
							<span class="desc-premios3">PREMIOS SECUNDARIOS PARA JUGADORES DE PUNTA DE VENTA</span>
						</div>
						<ul>
							<li>12,000 vales al instante de S/ 2 por jugadas de Ganagol para puntos de ventas físicos. 
							Los vales serán "al portador" y sólo se podrán canjear una vez. 
							Se podrán redimir hasta el 14 de agosto de 2022.</li>
						</ul> 
					</div>
						<%-- <div class="copacasa-juegas-web">
							<c:if test="${flagPromo == false}">
								<h3 style="color:#f0c607">¡Participa con tus tickets desde S/ 3!</h3>
								<h4 style="color:#ffffff;margin-bottom: 10px;">¿Quieres participar en la promoción?</h4>
								<c:if test="${empty clientId}">
									<button type="button" id="security_login_execute_authentication_copabicolor" onclick="return false;"class="button-copa2" style="width: 190px">Si quiero</button>
								</c:if>
								<c:if test="${!empty clientId}">
									<button type="button" id="btn_mobile_promo_bicolor" onclick="return false;"class="button-copa2" style="width: 190px">Si quiero</button>
								</c:if>
							</c:if>
							<c:if test="${!empty clientId && flagPromo == true}"> 
									<h3>¿Juegas en web?</h3>
									<h4 style="margin-left: 30px;margin-right: 30px;margin-bottom: 10px;">Tus jugadas desde S/ 3 participan automáticamente</h4>
									<button type="button"   onclick="return false;"class=" btnEnlaceGanagol button-copa2" style="width: 190px;">Juega aquí­</button>
							</c:if> 
						</div> 
						<div class="copacasa-punto-venta">
							<h3>¿Juegas en punto de venta?</h3>						
							<button type="button" id="btn_mobile_registra_ticket" onclick="return false;"class="button-copa1" style="width: 190px">Registra tu ticket aquí</button>
						</div>
						--%>
				</section>
			</div>
		</div>
	</div>	
<jsp:include page="../../include/footer.jsp" />
</body>
</html>