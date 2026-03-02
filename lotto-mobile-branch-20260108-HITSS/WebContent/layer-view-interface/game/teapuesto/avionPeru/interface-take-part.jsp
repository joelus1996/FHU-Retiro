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
	<style>
	    .desc-premios1.sub{
		    color: #f75b1e;
		    font-size: 14px;
		    padding-left: 32px;
		    line-height: 1.4em;
		    font-family: AmsiPro-Bold;
	    }
	    .avionPeru-volver{
    		color:#ffffff;
			background-color: #ff5d00;
			height: 107px;
			background-image: url('./layer-view-image/game/teapuesto/avionPeru/header-desktop-peru.png');
		}
		.avionEstambul-reglas {
		    margin-top: 30px;
		    margin-left: auto;
		    margin-right: auto;
		    margin-bottom: 10px;
		    font-size: 13px;
		    background-color: rgba(255, 255, 255, 1);
		    padding-bottom: 20px;
		    width: 339px;
		    height: 520px;
		    border-radius: 11px;
		}
    
    </style>
</head>
<body style="background-color: #d7e2e4">
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
					<div id="avionPeru-retroceder" class="copacasa-volver" style="background-color: #F77425;">
						  <div class="row" style="width: 100%;">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						    <div class="col-sm-4" style="margin: 0px auto;">
						    	<img class="img-volver" style="margin-top: 4px;" src="layer-view-image/game/teapuesto/avionPeru/header-mobile-peru.png" alt="Avión del Hincha Eliminatorias 2026">
						    </div>
						    <!-- <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div> -->
						  </div>					
					</div>
					
					<div class="avionEstambul-como-participar">
						<h3>¿Cómo participar?</h3>
						<h4 style="font-family: AmsiPro-Bold;">
							Si juegas desde <a href="#" id="" class="TyC_Enfatizar_naranja btnLinkteapuesto">www.teapuesto.pe</a>, todas tus jugadas desde S/ 10 participan AUTOMÁTICAMENTE.
						</h4>
						
					</div>
					<div style="background: #ffffff;" class="f_linea-copacasa"></div>
					
					<div class="avionEstambul-sorteos">
						<div class="premios1">
							<img class="copita" src="layer-view-image/game/teapuesto/avionPeru/icono-copa-virtuales.png" alt="Avión del Hincha Eliminatorias 2026">
							<span class="desc-premios1">VIGENCIA</span>
						</div>
							<ul style="padding-bottom: 0px; margin-top: 2px;">
								<li> La promoción de Te Apuesto, denominada "AVIÓN DEL HINCHA", entrará en vigor desde el <c:out value="${fechaPromo}" />, inclusive.
								</li>
						</ul>
					</div>
					<div class="avionEstambul-sorteos">
						<div class="premios1">
							<img class="copita" src="layer-view-image/game/teapuesto/avionPeru/icono-copa-virtuales.png" alt="Avión del Hincha Eliminatorias 2026">
							<span class="desc-premios1">JUGADAS PARTICIPANTES</span>
						</div>
							<ul style="padding-bottom: 0px; margin-top: 2px;">
								<li>Para participar de esta promoción, los clientes deberán encontrarse registrados previamente en nuestras plataformas detalladas más adelante y realizar sus jugadas dentro del periodo de vigencia, señalado en el artículo anterior, en nuestra página web <a href="#" id="" class="TyC_Enfatizar_naranja btnLinkteapuesto">www.teapuesto.pe</a> o en cualquiera de nuestros puntos de venta físicos (en ambos casos los usuarios deberán registrarse previamente en las plataformas que se detallan en los siguientes párrafos) y que tengan un valor igual o mayor a S/ 10.00 (diez y 00/100 soles). Participan todos los tickets comprados hasta el día de cierre de la promoción. Solo participarán jugadas realizadas con saldo real. No aplican jugadas realizadas con bonos o apuestas gratuitas (freebets), otra promoción, ni beneficios o cashout.</li>
							<li>Los juegos y apuestas deportivas a distancia realizados en exceso pueden causar ludopatía.</li>
						</ul>
					</div>
					
					<div class="avionEstambul-reglas">
						<h3 >SI JUEGAS DESDE WWW.TEAPUESTO.PE</h3>
							<ul>
								<li>Participas AUTOMÁTICAMENTE con tus jugadas desde S/ 10 (diez y 00/100 soles).</li>
								<li>Válido solo para todos los clientes registrados y que acepten participar de la promoción desde la página de la promoción, que podrás acceder desde la web de La Tinka y Te Apuesto.</li>
								<li>Válido solo para mayores de 18 (dieciocho) años.</li>
								<li>No participan tickets obtenidos con saldo bono, apuestas gratuitas (freebets), anulados o cashout.</li>
								<li>Puedes revisar el avance de las oportunidades con que participas en el sorteo de la promoción, ingresando <a href="#" onclick="VerMisJugadasAvionPeru();" class="TyC_Enfatizar_naranja">"Ver mis puntos"</a> en la página de la promoción "AVIÓN DEL HINCHA".</li>
								<li>No es acumulable con otras promociones.</li>
							</ul>
						<h3>SI JUEGAS EN PUNTO DE VENTA AUTORIZADO</h3>
							<ul>
								<li>Participan las jugadas desde S/ 10 (diez y 00/100 soles).</li>
								<li>Válido solo para todos los clientes registrados en <a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar_naranja">www.programateapuesto.pe</a> y que acepten participar de la promoción.</li>
								<li>Sube la foto de tu ticket registrándolo en el módulo promocional "AVIÓN DEL HINCHA" en www.programateapuesto.pe con tu sesión iniciada desde tu celular.</li> 
								<li>En esta página también puedes revisar el avance de tu participación y premios obtenidos.</li>
								<li>Válido solo para mayores de 18 (dieciocho) años.</li>
							</ul>
					</div>
					
					<div style="margin-top: 17px;margin-left: 22px;margin-right: 22px;margin-bottom: 0px;font-size: 13px;padding-bottom: 10px;"> 
						<img class="niveles-participar" src="${rutaAvionPeru}/ranking-mobile-peru.png" alt="Avión del Hincha Eliminatorias 2026">
					</div>
										
					<div class="avionEstambul-sorteos">
						<div class="premios1">
							<img class="copita" src="layer-view-image/game/teapuesto/avionEstambul/icono-copa-virtuales.png" alt="Avión del Hincha Eliminatorias 2026">
							<span class="desc-premios1">PREMIOS</span>
						</div>
						<span class="desc-premios1 sub">SORTEO PREMIO MAYOR</span>
						    <ul  style="list-style-type: none; margin-top: 3px">
							<li>SERÁN 10 (diez) GANADORES.</li>
							</ul>
							<ul style="padding-bottom: 0px; margin-top: 2px;">
								<li> Paquete Avión del Hincha: Se realizará la entrega de 1 (un) pasaje ida y vuelta a Buenos Aires, Argentina, así como la estadía en un hotel dentro de dicha ciudad, transportes internos, seguro de viaje y entrada al evento: Argentina - Perú, por las clasificatorias al mundial 2026. En caso el ganador esté domiciliado en provincia, se cubrirá el traslado de ida y vuelta a Lima.
								</li>
							</ul><br>
						<span class="desc-premios1 sub">SORTEO PREMIO SECUNDARIO</span>
						<ul  style="padding-bottom: 0px; margin-top: 2px;">
							<li>Además, tendremos 40 (cuarenta) entradas dobles a tribuna popular para el Perú vs Chile, por las clasificatorias al mundial 2026.</li>
						</ul><br>
						<span class="desc-premios1 sub">Sorteos:</span>
						<ul style="padding-bottom: 0px; ">
							<li>Fecha de los sorteos y publicación de ganadores será el <c:out value="${SORTEO1}"/>.</li>
													
							<li>Los sorteos serán realizados a través de un sistema de tómbola electrónica a cargo de personal de la agencia contratada, quienes evaluarán que los ganadores hayan cumplido con los requisitos que se establecen mecánica de estas bases. Si la persona sorteada no cumpliese con los requisitos establecidos, se seleccionarán (sortearán) ganadores suplentes hasta obtener el ganador definitivo. La elección será en una transmisión en vivo. Posteriormente, los resultados serán publicados a través de nuestras Redes Sociales.</li>
													
							<li>En el sorteo del premio mayor, se elegirán 10 (diez)  ganadores y 20 (veinte) suplentes que permanecerán como respaldo en caso 1 (uno) o más de los ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio mayor del sorteo de la promoción "AVIÓN DEL HINCHA".</li>
								
							<li>En el sorteo del premio secundario, se elegirán 40 (cuarenta) y 80 (ochenta) suplentes que permanecerán como respaldo en caso uno o más de los ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio mayor del sorteo de la promoción "AVIÓN DEL HINCHA".</li>
								
							<li>El premio es personal e intransferible.</li>
							
							<li>Los ganadores serán contactados vía llamada telefónica o Whatsapp. Se realizarán 2 (dos) intentos para contactarlo(s), de lo contrario, y de no recibir respuesta a través del Whatsapp, SMS o llamada telefónica al contacto de Te Apuesto dentro del plazo de 12 (doce) horas de la realización del sorteo, se contactará al siguiente ganador. </li>
								
							<li>Cada ganador es responsable de contar con toda la documentación necesaria para el viaje.</li>
							
							<li>Participas en el sorteo con el número de puntos acumulados hasta el día anterior al sorteo. 
								Si juegas en la web <a href="#" id="" class="TyC_Enfatizar_naranja btnLinkteapuesto">www.teapuesto.pe</a>, revísalos ingresando a <a href="#" onclick="VerMisJugadasAvionPeru();" class="TyC_Enfatizar_naranja">"Ver mis puntos"</a>, en la página de la promoción "AVIÓN DEL HINCHA".
								Si juegas en un punto de venta físico, revísalos en la sección "Ver mis premios" de la web 
								<a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar_naranja">www.programateapuesto.pe</a>. </li>
								
							<li>Nos pondremos en contacto con cada uno de los ganadores al celular registrado y se validarán en RENIEC la veracidad de sus datos y mayoría de edad.</li>
							
							<li>Los ganadores que no cumplan con los siguientes puntos no podrán ser acreedores de los premios mayores: 
								1. No obtener respuesta a través del Whatsapp, SMS o llamada telefónica de alguno de los ganadores en un plazo de 12 horas desde realizado el sorteo. 
								2. Se verifique que no cumple con la mayoría de edad. 
								3. Que no cuente con pasaporte o DNI en vigencia. 
								4. Que no envíe, en el tiempo indicado por La Tinka S.A., por correo electrónico su pasaporte o DNI. Te Apuesto se reserva el derecho de solicitar documentos adicionales. 
								5. Que cuente con alguna restricción de viaje.
								6. Se verifique la incapacidad legal o incumplimiento que impida otorgar uno de los premios, de acuerdo con los presentes Términos y Condiciones, 
								así como el <a href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-teapuesto.pdf" target="_blank" class="TyC_Enfatizar_naranja">Reglamento de Te Apuesto</a>, se procederá a retirarlo de la lista de ganadores y en su lugar se le otorgará el premio al primero de los suplentes según el orden en que salió sorteado.
								7. Que alguno de los ganadores,  ya declarados, no responda a través del Whatsapp, SMS o llamada telefónica al contacto de Te Apuesto, hasta un plazo máximo de 24 horas de la realización del del 1er contacto, Te Apuesto podrá otorgar el premio vacante al suplente respectivo o realizar un nuevo sorteo. 
								8. En caso el ganador no conteste durante el plazo mencionado, este perderá el derecho al premio y a reclamar cualquier tipo de compensación.
								9. Estar impedidos de viajar por factores internos ajenos a TE APUESTO. 
								10. El premio mayor no podrá ser canjeado por otra especie. 
								11. Que alguno de los ganadores sea colaborador, franquiciado, agente, o algún familiar directo de alguno de los antes mencionados.</li>			
						</ul>
							
						<br>
						<span class="desc-premios1 sub">Entrega de premios y comunicación:</span>
						<ul style="padding-bottom: 0px; ">
							<li>Para la entrega de los premios, luego de ubicar a los ganadores, (i) los ganadores del PREMIO MAYOR deberán proporcionar los documentos requeridos para la gestión de su viaje en un plazo máximo de un (1) días y, posterior a ello, se coordinará la entrega del premio en un plazo de dos (2) días, luego de emitidos los documentos; por otro lado, respecto del (ii) PREMIO SECUNDARIO, luego de contactado a los ganadores , en un plazo de tres (3) días se les dará las indicaciones para la entrega de su premio a través de Whatsapp o al correo que indiquen para el envío de su entrada.  
							</li>
						</ul> 
						<br>
						<span class="desc-premios1 sub">PREMIOS EN BONO DE S/5.</span>
						<ul style="padding-bottom: 0px; ">
							<li>S/ 410,000 en (cuatrocientos diez mil y 00/100 soles) en bonos de S/ 5 (cinco y 00/100 soles).</li>
							
							<li>Durante la vigencia de la promoción, de forma aleatoria, se entregarán bonos de S/ 5 (cinco y 00/100 soles) a los clientes que se encuentren participando de la promoción. En el caso de la web, los tickets participantes deberán tener una cuota igual o mayor a 1.30 y los bonos obtenidos serán cargados en su billetera principal AL INSTANTE, y deberá ser jugado una vez. Para el caso de los bonos obtenidos desde el punto de venta físico autorizado, estos serán otorgados al portador y sólo se podrán canjear una vez, hasta el 31 de diciembre de 2024.</li>
							
							<li>La Tinka se reserva el derecho de acortar, prorrogar, modificar o cancelar este concurso por fuerza mayor, siendo informado a los participantes mediante una story publicada en las redes oficiales de Instagram y Facebook de Te apuesto. De igual manera, se reserva el derecho de eliminar de la Promoción al participante que no cumpla con las obligaciones establecidas en estas Bases o incurra en alguna acción fraudulenta.
								</li>
						</ul><br> 
		
						<div class="premios2">		
							<img class="copita" src="layer-view-image/game/teapuesto/avionEstambul/icono-copa-virtuales.png" alt="Avión del Hincha Eliminatorias 2026">
							<span class="desc-premios2">TRATAMIENTO DE DATOS PERSONALES</span>
						</div>
						<ul style="padding-bottom: 0px; ">						
						<li>Los datos personales proporcionados por los participantes serán tratados de acuerdo con la Ley N°29733, Ley de Protección de Datos Personales. Los datos se utilizarán únicamente para fines relacionados con el sorteo y al participar en la encuesta está brindando su consentimiento. </li>
						<li>Les informamos que sus datos son compartidos con las siguientes personas, empresas, entidades públicas distintas a nosotros: Destinatario: TYPEFORM SL, País: España, Finalidad: Gestión del Sorteo y Encuesta, Datos: Nombres, Apellidos, Número de Celular, Correo Electrónico, Tipo y Número de Documento de Identidad.</li>
						</ul><br>
						
					</div>
						<div class="avionEstambul-juegas-web">
							<c:if test="${flagPromo == false}">
								<h3 style="color:#f75b1e">¡Participa con tus jugadas desde S/ 10!</h3>
								<h4 style="color:#000000;margin-bottom: 10px;">¿Quieres participar en la promoción?</h4>
								<c:if test="${empty clientId}">
									<button type="button" id="security_login_execute_authentication_avionPeru" onclick="return false;"class="button-avion-qatar-naranja" style="width: 190px">Sí quiero</button>
								</c:if>
								<c:if test="${!empty clientId}">
									<button type="button" id="btnAvionPeruRegistrar" onclick="return false;"class="button-avion-qatar-naranja" style="width: 190px">Sí quiero</button>
								</c:if>
							</c:if>
							<c:if test="${!empty clientId && flagPromo == true}">
									<h3>¿Juegas en web?</h3>
									<h4 style="margin-left: 30px;margin-right: 30px;margin-bottom: 10px;">Tus jugadas desde S/ 10 participan automáticamente</h4>
									<button type="button"   onclick="return false;"class="button-avion-qatar-naranja btnLinkteapuesto" style="width: 190px;">Juega aquí</button>
							</c:if> 
						</div>
						<div class="avionEstambul-punto-venta">
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