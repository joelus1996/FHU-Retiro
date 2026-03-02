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
	<style>
		.containerRakingImg{
			margin-top: 30px;
			margin-left: auto;
			margin-right: auto;
			margin-bottom: 10px;
			font-size: 13px;
			padding-bottom: 20px;
		}
	</style>
</head>
<body style="background-color: #D7E2E4">
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
		<div class="content-wrap" >		
			<div class="content">		
				<section class="main-section">
					<div id="JuegaGanaDDVV-retroceder" class="copacasa-volver" style="background-color: #000000; height:53px;">
						  <div class="row" style="width: 100%;">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						    <div class="col-sm-4" style="margin: 0px auto;">
						    	<img class="img-volver" style="margin-top: 0px;margin-right: 40px" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/header-mobile-virtuales.png" alt="Juega Deportes Virtuales">
						    </div>
						    <!-- <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div> -->
						  </div>					
					</div>
					
					<div class="copacasa-como-participar">
						<h3>¿Cómo participar?</h3>
						<h4 style="font-size: 13px;">
							Si juegas desde la web de 
							<a href="#" id="" class="TyC_Enfatizar_JuegaGanaVirtuales btnLinkDeportesVirtuales">Deportes Virtuales</a> 
							todos tus tickets de S/ 5 a más participan AUTOMÁTICAMENTE.
						</h4>
						
					</div>
					<div style="background: #ffffff;" class="f_linea-copacasa"></div>
					<div style="font-size: 12px; color: #000000;" class="copacasa-terminos">
						<ul>
							<li>Válido desde el <c:out value="${fechaPromo}" />.</li>
							<li>Válido para todos los clientes que acepten participar de la promoción.</li>
							<li>No participan tickets obtenidos con saldo bono.</li>
							<li>Participan todos los tickets válidos igual o mayor a S/ 5 jugados desde la web de  
								<a href="#" class="TyC_Enfatizar_JuegaGanaVirtuales btnLinkDeportesVirtuales" >Deportes Virtuales</a>
								 y puntos de venta, comprados durante la vigencia de la promoción.</li>
							<li>No es acumulable con otras promociones.</li>
							<li>Válido solo para mayores de 18 años.</li>
							<li>Los juegos y apuestas deportivas a distancia realizados en exceso pueden causar ludopatía.</li>
						</ul>
					</div>
					
					<div class="juegaGanaConVirtuales-reglas">
						<h3 >SI JUEGAS DESDE <a href="#" class="TyC_Enfatizar_JuegaGanaVirtuales btnLinkDeportesVirtuales" >DEPORTES VIRTUALES</a></h3>
							<ul>
								<li>Participas AUTOMÁTICAMENTE con tu ticket desde S/ 5 a excepción de los juegos Spin2Win y Spin2Win Royale.</li>
								<li>Puedes revisar el avance de las oportunidades con que participas en cada sorteo de la promoción, ingresando a 
									<a href="#" onclick="VerMisJugadasJuegaGanaDDVV();" class="TyC_Enfatizar_JuegaGanaVirtuales">"Ver mis jugadas"</a> 
									en la página de la promoción "Juega y Gana con Virtuales".
								</li>								
							</ul>
						<h3>SI JUEGAS EN PUNTO DE VENTA</h3>
							<ul>
								<li>Participas con tus tickets desde S/ 5 a excepción de los juegos Spin2Win.</li>
								<li>Sube la foto de tu ticket registrándolo en el módulo promocional "Juega y Gana con Virtuales" en 
									<a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">www.programateapuesto.pe</a> 
									con tu sesión iniciada desde tu celular. Aplica aceptación de la política de privacidad y la política de protección de datos personales.
								</li>
								<li>En esta página también puedes revisar el avance de tu participación y premios obtenidos.</li>
							</ul>
					</div>
					
					<div class="containerRakingImg"> 
						<img class="niveles-participar" 
							 src="layer-view-image/game/virtuales/juegaGanaConVirtuales/ranking-mobile-virtuales.png" 
							 alt="Juega Deportes Virtuales">
					</div>
										
					<div class="juegaGanaConVirtuales-sorteos">
						<div class="premios1">
							<img class="copita" 
								 src="layer-view-image/game/virtuales/juegaGanaConVirtuales/icono-copa-virtuales.png" 
								 alt="Juega Deportes Virtuales">
							<span class="desc-premios1">PREMIOS MAYOR</span>
						</div>
						
						<ul>
							<li>5 GANADORES DE UNA MOTO SUZUKI GIXXER SF 150</li>
						</ul>
						
						<div class="premios2">
						    <span class="desc-premios2">Sorteos De Premios Mayores</span>
						</div>			
						
						<ul>
							<li>1er Sorteo: <c:out value="${SORTEO1}"/> </li>
							
							<li>2do Sorteo: <c:out value="${SORTEO2}"/> </li>
							
							<li>En el 1er sorteo, se elegirán 2 ganadores y 2 suplentes que permanecerán como respaldo 
							 	 en caso uno o más de los ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio.</li>
							
							<li>En el 2do sorteo, se elegirán 3 ganadores y 3 suplentes que permanecerán como respaldo 
								 en caso uno o más de los ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio.</li>
							
							<li>Participas en cada sorteo con el número de tickets acumuladas hasta el día anterior al sorteo. 
								Si juegas en la web, revísalos aquí 
								<a href="#" onclick="VerMisJugadasJuegaGanaDDVV();" class="TyC_Enfatizar_JuegaGanaVirtuales">"Ver mis jugadas"</a>. 
								Si juegas en un punto de venta físico, revísalos en la sección "Ver mis premios" de la web <a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">www.programateapuesto.pe</a>.</li>
							
							<li>Nos pondremos en contacto con cada uno de los ganadores al celular registrado y se validarán en RENIEC la veracidad de sus datos y mayoría de edad.</li>
							
							<li>En total serán 5 ganadores, cada uno se llevará 1 motocicleta marca Suzuki Gixxer SF 150 de color azul o negro, 
								sujeto a la disponibilidad del dealer más cercano al lugar de residencia del ganador</li>
							
							<li>Los ganadores que no cumplan con los siguientes puntos no podrán ser acreedores de los premios mayores:  
								1. No obtener respuesta de alguno de los ganadores en un plazo de 24 horas desde realizado el sorteo. 
								2. Se verifique que no cumple con la mayoría de edad. 
								3. Haya sido ganador en esta promoción de un premio mayor. 
								4. Se verifique cualquier otra situación que impida otorgar uno de los premios, de acuerdo con los presentes Términos y Condiciones, así como el 
								<a href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-deportes-virtuales.pdf" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">Reglamento de Virtuales</a>.  
								 Se procederá a retirarlo de la lista de ganadores de premio mayor y en su lugar se le otorgará el premio al primero de los suplentes según el orden en que salió sorteado.  
							</li>
							
							<li>Los ganadores de cada sorteo serán publicados en el Facebook  
								<a  href="https://www.facebook.com/teapuestooficial" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">TeApuestoOficial</a> e Instagram 
								<a href="https://www.instagram.com/teapuestooficial" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">@teapuestooficial</a>
								dentro de las 24 horas de haber realizado el sorteo.</li>								
						</ul>
						<div class="premios2">		
							<img class="copita" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/icono-copa-virtuales.png" alt="Juega Deportes Virtuales">
							<span class="desc-premios2">ENTREGA DE PREMIOS Y COMUNICACIÓN</span>
						</div>
						<ul style="padding-bottom: 0px; ">
							<li>Los premios solo podrán ser entregados y transferidos a nombre del ganador del sorteo. El proveedor de las motocicletas, Intermotors del Perú S.A.C.,
								se pondrá en contacto con los ganadores para coordinar los detalles de la entrega y concretar ésta en un plazo no mayor a 60 días calendario.
								Este tiempo se podrá extender por causas atribuibles al ganador o factores externos no atribuibles a La Tinka S.A.
								Como ganador te comprometes a brindar todos los accesos adecuados para poder hacer la entrega del premio,
								a brindar toda la información correspondiente y suscribir toda la documentación necesaria para poder realizar los trámites de transferencia de propiedad a su nombre,
								firmar un acuerdo para poder comunicar el acontecimiento, asistir a las oficinas de LA Tinka S.A. 
								o al lugar acordado previa coordinación con la marca para generar contenido audiovisual de ganadores para las redes de la marca a través de Facebook
								<a  href="https://www.facebook.com/teapuestooficial" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">TeApuestoOficial</a> e Instagram 
								<a href="https://www.instagram.com/teapuestooficial" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">@teapuestooficial</a>.
							</li>
							<li>Se deja constancia que La Tinka S.A. no será responsable por los trámites relativos a la transferencia de propiedad de las motocicletas,
								ni por la calidad e idoneidad de estas, en tanto que será la empresa Intermotors del Perú S.A.C.
								la única y exclusiva responsable frente a los ganadores de cumplir con dichas obligaciones una vez que La tinka S.A.
								comunica quienes serán las personas acreedoras de los premios.
							</li>
						</ul> 
						<br>
						<div class="premios2">
							<img class="copita" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/icono-copa-virtuales.png" alt="Juega Deportes Virtuales">
							<span class="desc-premios2">DEALERS AUTORIZADOS PARA LA ENTREGA DEL PREMIO MAYOR</span>
						</div>
						<ul style="padding-bottom: 0px; ">
							<li>Los premios mayores serán entregados a nivel nacional únicamente en los establecimientos autorizados por Intermotors del Perú S.A.C
								<a href="https://www.latinka.com.pe/latinka/minisite/promo-virtuales/Dealers-Autorizados.pdf" target="_blank" class="TyC_Enfatizar_JuegaGanaVirtuales">"Ver lista"</a>.
								La información de la lista referencial puede variar de acuerdo con la disponibilidad de los distribuidores. 
								Los ganadores deberán acercarse al dealer más cercano a su lugar de domicilio previa coordinación y confirmación del proveedor.
							</li>
						</ul> 
						<br>
						<div class="premios2">
							<img class="copita" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/icono-copa-virtuales.png" alt="Juega Deportes Virtuales">
							<span class="desc-premios2">PREMIOS SECUNDARIOS PARA JUGADORES DE WEB</span>
						</div>
						<ul style="padding-bottom: 0px; ">
							<li>S/ 10,000 en bonos de S/ 5. 
								Cada ganador se llevará S/ 5 de bono que deberá ser jugado AL INSTANTE en Virtuales. Estos se entregarán de forma aleatoria mediante el sistema durante el período de vigencia de la promoción directo a la billetera de bono. 
								 Estos bonos tienen una caducidad de 7 días desde que son otorgados.
							</li>
						</ul> 
						<br>	 
						<div class="premios3">		
							<img class="copita" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/icono-copa-virtuales.png" alt="Juega Deportes Virtuales">
							<span class="desc-premios3">PREMIOS SECUNDARIOS PARA JUGADORES DE PUNTO DE VENTA</span>
						</div>
						<ul>
							<li>S/ 20,000 en bonos al instante de S/ 2, por jugadas de Virtuales para puntos de ventas físicos. 
								 Estos serán otorgados de forma aleatoria y se visualizarán en la web www.programateapuesto.pe. 
								 Los vales serán "al portador" y sólo se podrán canjear una vez. Se podrán redimir hasta el 17 de diciembre de 2023.</li>
						</ul> 
						<div class="notaPromocion">
							<ul style="list-style-type: none;">
								<li>La presente promoción podrá ser suspendida o eliminada anticipadamente por razones de caso fortuito o de fuerza mayor sin responsabilidad para La Tinka S.A., 
								 	informando oportunamente a los participantes a través de los canales de difusión que se estimen convenientes.
								</li>
								<li>Razón Social: LA TINKA S.A.</li>
								<li>RUC: 20506035121</li>
							</ul>
							
						</div>
					</div>
						<div class="juegaGanaConVirtuales-juegas-web">
							<c:if test="${flagPromo == false}">
								<h3 style="color:#e16e1a">¡Participa con tus tickets desde S/ 5!</h3>
								<h4 style="margin-bottom: 10px;">¿Quieres participar en la promoción?</h4>
								<c:if test="${empty clientId}">
									<button type="button" id="security_login_execute_authentication_juegaGanaDDVV" 
											class="button-juegaGanaVirtuales-naranja" 
											style="width: 190px">
											Sí quiero
									</button>
								</c:if>
								<c:if test="${!empty clientId}">
									<button type="button" id="btnJuegaGanaDDVVRegistrar" 
											class="button-juegaGanaVirtuales-naranja" 
											style="width: 190px">
											Sí quiero
									</button>
								</c:if>
							</c:if>
							<c:if test="${!empty clientId && flagPromo == true}">
									<h3>¿Juegas en web?</h3>
									<h4 style="margin-left: 30px;margin-right: 30px;margin-bottom: 10px;">
										Tus jugadas desde S/ 5 participan automáticamente
									</h4>
									<button type="button" 
											class="button-juegaGanaVirtuales-naranja btnLinkDeportesVirtuales" 
											style="width: 190px;">
											Juega aquí
									</button>
							</c:if> 
						</div>
						<div class="juegaGanaConVirtuales-punto-venta">
							<h3>¿Juegas en punto de venta?</h3>						
							<button type="button" id="btn_mobile_registra_ticket" 
									onclick="return false;"
									class="button-juegaGanaVirtuales-blanco" 
									style="width: 190px">
									Registra tu ticket aquí
							</button>
						</div>
				
				</section>
			</div>
		</div>
	</div>	
<jsp:include page="../../../include/footer.jsp" />
</body>
</html>