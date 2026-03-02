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
    <title>Juego de apuestas deportivas en Perú - Ganagol</title>
    <meta name='description' content="La Tinka es la compañia líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto." />	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
</head>
<body style="background-color: #841144">
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
			<jsp:include page="../../../include/header.jsp" />		
		<div class="content-wrap" style=" color: #ffffff;" >		
			<div class="content">		
				<section class="main-section">				
					<div id="avionQatar-retroceder" class="copacasa-volver" style="background-color: #841144;">
						  <div class="row" style="width: 100%;">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						    <div class="col-sm-4" style="margin: 0px auto;">
						    	<img class="img-volver" style="margin-top: 11px;" src="layer-view-image/game/teapuesto/avionQatar/logo_taqatar_mobile.png">
						    </div>
						    <!-- <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div> -->
						  </div>					
					</div>
					
					<div class="copacasa-como-participar">
						<h3>¿Cómo participar?</h3>
						<h4 style="font-family: AmsiPro-Bold;">
							Las jugadas válidas de Te Apuesto para participar de esta promoción 
							serán aquellas compradas del 01 de setiembre hasta el 20 de noviembre de 2022 en nuestra página web 
							<a href="#" id="" class="TyC_Enfatizar btnLinkteapuesto">www.teapuesto.pe</a>
							o en cualquiera de nuestros puntos de ventas físicos y que tengan un valor igual o mayor a S/ 10.00.
						</h4>
						
					</div>
					<div style="background: #ffffff;" class="f_linea-copacasa"></div>
					<div style="font-size: 12px;" class="copacasa-terminos">
						<ul>
							<li>Válido desde el jueves 01 de setiembre al domingo 20 de noviembre del 2022.</li> 
							<li>Válido para todos los clientes mayores de 18 años que acepten participar de la promoción.</li>
							
							<li>Participan todos los tickets validos igual o mayor a S/ 10, jugados desde 
								<a href="#" class="TyC_Enfatizar btnLinkteapuesto" >www.teapuesto.pe</a>
								 y puntos de venta, comprados durante la vigencia de la promoción.</li>
							<li>No participan tickets obtenidos con saldo bono, anulados o cashout.</li>
							<li>Los juegos y apuestas deportivas a distancia realizados en exceso pueden causar ludopatía.</li>
						</ul>
					</div>
					
					<div class="copacasa-reglas">
						<h3 >SI JUEGAS DESDE WWW.TEAPUESTO.PE</h3>
							<ul>
								<li>Participas AUTOMÁTICAMENTE con tus tickets desde S/ 10.</li>
								<li>Puedes revisar el avance de las oportunidades con que participas, 
									en cada sorteo de premios mayores ingresando 
									<a href="#" onclick="VerMisJugadas();" class="TyC_Enfatizar">"Ver mis jugadas"</a> 
									en la página de la promoción, una vez hayas aceptado participar.
								</li>								
							</ul>
						<h3>SI JUEGAS EN PUNTO DE VENTA</h3>
							<ul>
								<li>Sube la foto de tu ticket registrándolo en el módulo promocional "Te Apuesto te lleva a la final en Qatar" en 
									<a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar">www.programateapuesto.pe</a>.
								</li>
								<li>Puedes revisar el avance de tu participación y premios obtenidos en la misma página de la promoción.</li>
							</ul>
					</div>
					
					<div style="margin-top: 30px;margin-left: 22px;margin-right: 22px;margin-bottom: 10px;font-size: 13px;padding-bottom: 20px;"> 
						<img class="niveles-participar" src="layer-view-image/game/teapuesto/avionQatar/niveles_taqatar_mobile.png">
					</div>
										
					<div class="copacasa-sorteos">
						<div class="premios1">
							<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa.png">
							<span class="desc-premios1">PREMIOS MAYORES PARA 10 GANADORES</span>
						</div>			
						<ul>
							<li>Son 10 ganadores de un paquete para ir a Qatar, el paquete incluye 1 pasaje Lima - Qatar - Lima, 
							con estadía en un hotel dentro de la ciudad, transportes internos y seguro de viaje.</li>
							<li><b>Sorteos:</b> 24 de octubre y 21 de noviembre del 2022.</li>
							<li>En el 1er sorteo, se elegirán 2 ganadores y 2 suplentes que permanecerán como respaldo 
								en caso uno o más de los dos ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio del PAQUETE PARA IR A QATAR.</li>
							<li>En el 2do sorteo, se elegirán 8 ganadores y 8 suplentes que permanecerán como respaldo
								 en caso uno o más de los ocho ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio del PAQUETE PARA IR A QATAR.</li>
							<li>El premio es personal e intransferible.</li>
							<li>Cada ganador es responsable de contar con toda la documentación necesaria para el viaje y requisitos sanitarios vigentes.</li>
							<li>Participas en cada sorteo con el número de tickets acumuladas hasta el día anterior al sorteo. 
								Si juegas en la web, revísalos aquí 
								<a href="#" onclick="VerMisJugadas();" class="TyC_Enfatizar">"Ver mis jugadas"</a>. 
								Si juegas en un punto de venta físico, revísalos en la sección "Ver mis premios" de la página donde ingresaste tu tickets.
							</li>
							<li>Nos pondremos en contacto con cada uno de los ganadores al celular registrado sin perjuicio de validar sus datos y mayoría de edad con Reniec.</li>
							<li>En caso de: 
								1: No obtener respuesta de alguno de los ganadores en un plazo de 12 horas desde realizado el sorteo, 
								2: Se verifique que no cumple con la mayoría de edad, 
								3: Que haya ganado antes uno de los premios mayores de esta promoción, 
								4: Se verifique cualquier otra situación que impida otorgar uno de los premios, de acuerdo a los presentes Términos y Condiciones, así como el 
								<a href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-teapuesto.pdf" class="TyC_Enfatizar">Reglamento de Te Apuesto</a>, 
								se procederá a retirarlo de la lista de ganadores y en su lugar se le otorgará el premio al primero de los suplentes 
								según el orden en que salió sorteado. 
							</li>
							<li>Los ganadores de cada sorteo serán publicados en el Facebook de 
								<a  href="https://www.facebook.com/teapuestooficial" class="TyC_Enfatizar">TeApuestoOficial</a> e Instagram 
								<a href="https://www.instagram.com/teapuestooficial" class="TyC_Enfatizar">@teapuestooficial</a>
								dentro de las 12 horas de haber realizado el sorteo.</li>								
						</ul>
						<div class="premios2">		
							<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa.png">
							<span class="desc-premios2">ENTREGA DE PREMIOS Y COMUNICACIÓN</span>
						</div>
						<ul style="padding-bottom: 0px; ">
							<li>Coordinaremos todos los detalles de la entrega del premio, 
								en un plazo de 12 días útiles una vez formalizado el contacto con el ganador vía correo electrónico. 
								A su vez el ganador se compromete a brindar las facilidades para llevar a cabo la entrega del premio y 
								utilizar su imagen para posterior difusión a través de Facebook 
								<a  href="https://www.facebook.com/teapuestooficial" class="TyC_Enfatizar">TeApuestoOficial</a> e Instagram 
								<a href="https://www.instagram.com/teapuestooficial" class="TyC_Enfatizar">@teapuestooficial</a>.  
								Además, el ganador se compromete a asistir a las oficinas de La Tinka, previa coordinación con la marca, 
								para genera un contenido audiovisual de ganadores para las redes de la marca. 
								El ganador deberá entregar los documentos requeridos para el viaje en un plazo máximo de 24 horas 
								después de solicitado por parte de La Tinka.
							</li>
						</ul> 
						<br>
						<div class="premios2">		
							<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa.png">
							<span class="desc-premios2">PREMIOS SECUNDARIOS PARA JUGADORES WEB</span>
						</div>
						<ul style="padding-bottom: 0px; ">
							<li>S/ 110,000 en bonos de S/ 10. Cada ganador se llevará S/ 10 de saldo en su billetera principal AL INSTANTE. 
								Estos se entregarán de forma aleatoria mediante el sistema 
								durante el período de vigencia de la promoción directo a la billetera de bono.
							</li>
						</ul> 
						<br>	 
						<div class="premios3">		
							<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa.png">
							<span class="desc-premios3">PREMIOS SECUNDARIOS PARA JUGADORES DE PUNTA DE VENTA</span>
						</div>
						<ul>
							<li>S/ 440,000 en bonos al instante de S/ 5, por jugadas de Te Apuesto para puntos de ventas físicos. 
								Estos serán otorgados de forma aleatoria y se visualizarán en la web 
								<a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar">www.programateapuesto.pe</a>. 
								Los vales serán "al portador" y sólo se podrán canjear una vez. Se podrán redimir hasta el 27 de noviembre de 2022.</li>
						</ul> 
						<div class="notaPromocion">
							<ul style="list-style-type: none;">
								<li>La promoción podrá ser suspendida o eliminada anticipadamente 
									por razones de caso fortuito o de fuerza mayor sin responsabilidad para La Tinka S.A., 
									informando oportunamente a los participantes a través de los canales de difusión que se estimen convenientes.
								</li>
							</ul>
							
						</div>
					</div>
						<div class="copacasa-juegas-web">
							<c:if test="${flagPromo == false}">
								<h3 style="color:#f0c607">¡Participa con tus tickets desde S/ 10!</h3>
								<h4 style="color:#ffffff;margin-bottom: 10px;">¿Quieres participar en la promoción?</h4>
								<c:if test="${empty clientId}">
									<button type="button" id="security_login_execute_authentication_avionQatar" onclick="return false;"class="button-avion-qatar-amarillo" style="width: 190px">Si quiero</button>
								</c:if>
								<c:if test="${!empty clientId}">
									<button type="button" id="btnAvionQatarRegistrar" onclick="return false;"class="button-avion-qatar-amarillo" style="width: 190px">Si quiero</button>
								</c:if>
							</c:if>
							<c:if test="${!empty clientId && flagPromo == true}">
									<h3>¿Juegas en web?</h3>
									<h4 style="margin-left: 30px;margin-right: 30px;margin-bottom: 10px;">Tus jugadas desde S/ 10 participan automáticamente</h4>
									<button type="button"   onclick="return false;"class="button-avion-qatar-amarillo btnLinkteapuesto" style="width: 190px;">Juega aquí</button>
							</c:if> 
						</div>
						<div class="copacasa-punto-venta">
							<h3>¿Juegas en punto de venta?</h3>						
							<button type="button" id="btn_mobile_registra_ticket" onclick="return false;"class="button-avion-qatar-blanco" style="width: 190px">Registra tu ticket aquí</button>
						</div>
				
				</section>
			</div>
		</div>
	</div>	
<jsp:include page="../../../include/footer.jsp" />
</body>
</html>