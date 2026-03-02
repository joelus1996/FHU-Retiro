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
<body class="main-copaentucasa-como-participar">
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
		<div class="content-wrap">		
			<div class="content">		
				<section class="main-section">				
					<div id="copabicolor-retroceder" class="copacasa-volver" style="background-color: #ce061f;">
						  <div class="row">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						    <div class="col-sm-4"><h3 style="font-size: 25px;">LA BICOLOR EN TU CASA</h3></div>
						    <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div>
						  </div>					
					</div>
					<div>
						<img alt="" style="width: 100%" src="layer-view-image/game/copabicolor/header-soyleyenda.gif">
					</div>
					<div class="copacasa-leyenda">
						<h4>Alcanza el nivel "Soy Leyenda" y participa por una camiseta oficial autografiada</h4>
					</div>
					
					<div class="f_linea-leyenda"></div>
					<div class="copacasa-leyenda-intro">
						<p>
						La Bicolor en tu casa sorteará 4 camisetas oficiales autografiadas por los jugadores de la selección peruana, entre los participantes de la promoción "LA BICOLOR EN TU CASA" que tengan nivel "LEYENDA" (hayan acumulado más de 100 tickets participantes en la promoción) y hayan cumplido con la mecánica de participación del sorteo de las camisetas oficiales autografiadas. 
						</p>
					</div>
					<div class="copacasa-como-participar" style="margin-top: 0px; margin-left: 25px">
						<h3>¿Cómo participar?</h3>
						<h4 style="margin-top: 10px">Fechas para participar en el sorteo</h4>
						<p style="font-family: GothamBook; font-size: 12px; margin-top: 1px; line-height: 1.4em;">Desde el lunes 01 de noviembre del 2021 al domingo 19 de noviembre del 2021.</p>
					</div>
					<div class="copacasa-terminos">
						<h4 style="margin-left: 25px; font-family: TekturSemiBold; font-size: 14px; ">Mecánica de participación:</h4>
						<ol style="text-align: justify;">
							<li>Pertenecer al nivel "Leyenda". Este nivel lo alcanzas acumulando 100 a más tickets participantes de la promoción "LA BICOLOR EN TU CASA"</li>
							<li>Enviar el mensaje "Soy Leyenda + Nombre + DNI" y la imagen donde demuestras tu nivel "Leyenda", al inbox de Facebook o Instagram de @teapuestooficial </li>
							<li>Para multiplicar tus opciones de ganar por 5: Sube la imagen de tu nivel "leyenda" a tus historias de Instagram etiquetando a @teapuestooficial.</li>
						</ol>
						<table style="width:100%; margin-left: 25px">
							  <tr>
							    <th style="width: 39px">
							    	<a href="https://www.facebook.com/teapuestooficial" target="_blank">
									 	<div class="copacasa-img-facebook"></div>
									</a>
							    </th>
							    <th style="width: 10px"></th>
							    <th style="width: 39px">
							    	<a href="https://www.instagram.com/teapuestooficial/" target="_blank">
									 	<div class="copacasa-img-instagram"></div>
									</a>
							    </th>
							    <th>
							    	<h4 style="margin-top: 5px; margin-left: 10px; font-size: 13px"><b>TeApuestoOficial</h4>
							    </th>
							  </tr>
						  </table>
						  <br>
					</div>
															
					<div class="copacasa-sorteos">
						<div class="premios1">
							<img class="copita" src="layer-view-image/game/copabicolor/img-trofeo.png">
							<span class="desc-premios1">Premios:</span>
						</div>
						<p style="font-family: GothamBook;font-size:12px;line-height: 1.5em;margin-left: 25px;margin-bottom: 15px;margin-top: 15px;margin-right: 20px; text-align: justify;">
							<b style="font-family: GothamBold; ">CUATRO camisetas oficiales firmadas por los jugadores de la selección peruana</b> 
						</p> 
						<div class="col-sm-2" style="margin-top: 10px; text-align: center; margin-bottom: 20px;">
				  			<img class="" src="layer-view-image/game/copabicolor/img-camiseta.png">
				  		</div>
				  		<div class="col-sm-10">
					  		<div style="margin-left: 25px">
					  			<p style="margin: 0px;">1er sorteo de 1 camiseta: 5 de noviembre de 2021</p>
								<p style="margin: 0px;">2do sorteo de 1 camiseta: 12 de noviembre de 2021</p>
								<p style="margin: 0px; margin-bottom: 15px">3er sorteo de 2 camisetas: 19 de noviembre 2021</p>
							</div>
				  			<ul style="margin-left: 12px">								
								<li style="margin-bottom: 15px">En cada sorteo elegiremos 1 ganador y 1 suplente que permanecerá como respaldo en caso el ganador no sea elegible para recibir el premio, salvo el tercer sorteo en el cual elegiremos 2 ganadores y 2 suplentes.</li>																				
								<li style="margin-bottom: 15px">En cada sorteo nos pondremos en contacto con los ganadores vía telefónica y validaremos sus datos contra Reniec para comprobar la veracidad de su información y su mayoría de edad. En caso no tengamos respuesta del ganador en un máximo de 24 horas procederemos a retirarlo de la lista de ganadores y en su lugar otorgaremos el premio al primero de los suplentes según el orden en que salió sorteado.</li>
								<li>Una vez validados los datos de los ganadores y estando en contacto con cada uno de ellos, coordinaremos los detalles del despacho y entrega de su premio.</li>																		
							</ul>
				  		</div>						
					</div>
					
					
						<div class="copacasa-juegas-web">
							<c:if test="${empty clientId}">
							<h3>¿Quieres participar jugando en web?</h3>
							<h4>Tus jugadas de S/ 5 a más participarán automáticamente</h4>
							<button type="button" id="security_login_execute_authentication_copabicolor" onclick="return false;"class="button-participar-teapuesto" style="background-color: #ce061f;">Si quiero</button>
							</c:if>
							<c:if test="${!empty clientId}">
								<c:if test="${flagPromo == true}">
								<h3>¿Juegas en web?</h3>
								<h4 style="margin-left: 30px;margin-right: 30px;">Participas automáticamente y sigue acumulando tus opciones</h4>
								<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-participar-teapuesto" style="background-color: #ce061f;">Juega aquí­</button>
								</c:if>
								<c:if test="${flagPromo == false}">
								<h3>¿Quieres participar jugando en web?</h3>
								<h4>Tus jugadas de S/ 5 a más participarán automáticamente</h4>
								<button type="button" id="btn_mobile_promo_bicolor" onclick="return false;"class="button-participar-teapuesto" style="background-color: #ce061f;">Si quiero</button>
								</c:if>
							</c:if>
							
						</div>
						
						<div class="copacasa-punto-venta">
							<h3>¿Juegas en punto de venta?</h3>						
							<button type="button" id="btn_mobile_registra_ticket" onclick="return false;"class="button-registra-ticket" style="border-color: #ce061f;">Registra tu ticket aquí</button>
						</div>
				
				</section>
			</div>
		</div>
	</div>	
<jsp:include page="../../include/footer.jsp" />
<script type="text/javascript">
function mouseDown() {
	document.getElementById("myP").style.background = "red";	  
	}
function mouseUp() {
	  document.getElementById("myP").style.background = "";
	}
</script>

</body>
</html>