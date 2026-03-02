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

	<div class="container">	
			<jsp:include page="../../include/header.jsp" />		
		<div class="content-wrap">		
			<div class="content">		
				<section class="main-section">				
					<div id="copacasa-retroceder" class="copacasa-volver">
						  <div class="row">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copaentucasa/img-flecha.gif"></div>
						    <div class="col-sm-4"><h3>LA COPA EN TU CASA</h3></div>
						    <div class="col-sm-4"><img class="img-logo-teapuesto" src="layer-view-image/game/copaentucasa/logo-teapuesto.gif"></div>
						  </div>					
					</div>
					
					<div class="copacasa-como-participar">
						<h3>¿Cómo participar?</h3>
						<h4>Si juegas desde www.teapuesto.pe, todas tus jugadas desde S/ 5 participan automáticamente</h4>
						
					</div>
					<div class="f_linea-copacasa"></div>
					<div class="copacasa-terminos">
						<ul>
							<li>Válida desde sábado 08 de mayo al domingo 11 de julio del 2021.</li>
							<li>Participan todos los tickets validos igual o mayor a S/5, jugados desde <a href="#" onclick="toTAV2();" style="color: #ff5d00;">www.teapuesto.pe</a> y puntos de venta, comprados durante la vigencia de la promoción.</li>
							<li>No participan tickets obtenidos con saldo bono desde <a href="#" onclick="toTAV2();" style="color: #ff5d00;">www.teapuesto.pe</a>.</li>
						</ul>
					</div>
					
					<div class="copacasa-reglas">
						<h3>Si juegas desde www.teapuesto.pe</h3>
							<ul>
								<li>Participas AUTOMÁTICAMENTE.</li>
								<li>Puedes revisar el avance de las oportunidades con que participas, en cada sorteo de premios mayores y secundarios, ingresando <a href="#" onclick="validateMisJugadas();" style="color: #ff5d00;">Ver mis jugadas</a> en la página de la promoción.</li>								
							</ul>
						<h3>Si juegas en punto de venta</h3>
							<ul>
								<li>Sube la foto de tu ticket registrándolo en el módulo promocional <a href="https://www.programateapuesto.pe/" target="_blank" style="color: #ff5d00;">www.programateapuesto.pe</a>.</li>
								<li>Puedes revisar el avance de tu participación y premios obtenidos.</li>
							</ul>
					</div>
					
					<div class="copacasa-reglas">
						<h3>Colócate en el Ranking</h3>
							<ul>
								<li>Multiplica tus opciones, aumentando tu nivel, para participar de los sorteos de premios mayores.</li>								
							</ul>
							<img class="niveles-participar" src="layer-view-image/game/copaentucasa/img-levels2.png">
					</div>
										
					<div class="copacasa-sorteos">
						<div class="premios1">
							<img class="copita" src="layer-view-image/game/copaentucasa/img-trofeo.png">
							<span class="desc-premios1">Premios mayores para 20 ganadores</span>
						</div>						
						<p class="premios-descripcion"><b style="font-family: GothamBold;">Un paquete de 1 Televisor Ultra HD de 70 pulgadas</b> 
							(Samsung, LG, Panasonic o similares según disponibilidad de la zona),<b style="font-family: GothamBold"> 1 Soundbar, 1 frigobar</b> 
							(100 litros o similar)<b style="font-family: GothamBold"> lleno de bebidas y 1 kit blanquirrojo MARATHON</b> 
							(camiseta, casaca y gorra oficial de nuestra selección).</p>  							
								<ul>
									<li><b style="font-family: GothamBold;">Sorteos: </b> 07, 14, 21 y 28 de junio.</li>
									<p style="margin: 0px;">En cada sorteo se elegirán 5 ganadores y 2 suplentes que permanecerán como respaldo en caso uno o más de los 5 ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio.</p>
									<li><b style="font-family: GothamBold;">Sorteos adicionales:</b> 05 y 12 de julio.</li>
									<p style="margin: 0px;">En cada sorteo se elegirá solo 1 ganador 2 suplentes que permanecerán como respaldo en caso el ganador seleccionado no sea elegible para recibir el premio.</p>
									<li>Nos pondremos en contacto con cada uno de los ganadores al celular registrado y se validarán en Reniec la veracidad de sus datos y mayoría de edad.</li>
									<li>En caso de: 1: No obtener respuesta de alguno de los ganadores en un plazo de 24 horas desde realizado el sorteo, 2: Se verifique que no cumple con la mayoría de edad, 3: Que haya ganado antes uno de los premios mayores de esta promoción, y/o 4: Se verifique cualquier otra situación que impida otorgar uno de los premios, de acuerdo a los presentes Términos y Condiciones, así como el Reglamento de Te Apuesto, se procederá a retirarlo de la lista de ganadores y en su lugar se le otorgará el premio al primero de los suplentes según el orden en que salió sorteado. </li>
									<li>Los ganadores de cada sorteo serán publicados en las redes sociales de Te Apuesto (Facebook e Instagram) dentro de las 24 horas de haber realizado el sorteo.</li>
									<li><b style="font-family: GothamBold;">Entrega de premios y comunicación:</b> Coordinaremos los detalles de despacho y entrega de los premios en tu domicilio en un plazo no mayor a 12 días útiles. A su vez como ganador te comprometes a brindar todos los accesos adecuados para poder hacer el despacho y a firmar un acuerdo para poder comunicar el acontecimiento a través de las redes sociales de nuestra marca (Facebook e Instagram).</li>								
								</ul>
						<div class="premios2">		
							<img class="copita" src="layer-view-image/game/copaentucasa/img-trofeo.png">
							<span class="desc-premios2">Premios secundarios para jugadores web</span>
						</div>
						<p class="premios-descripcion"><b style="font-family: GothamBold;">S/ 90,000 en saldos para 4,500 ganadores</b></p>
						<p style="margin: 0px;text-align: justify;margin-left: 30px;margin-right: 30px;">Cada ganador se llevará S/20 de saldo en su billetera principal.</p>
						<p class="premios-descripcion"><b style="font-family: GothamBold;">Sorteos: </b>17, 24, 31 de mayo, 07, 14, 21, 28 de junio, 05 y 12 de julio.</p>
						<p class="premios-descripcion"><b style="font-family: GothamBold;">S/ 90,000 en bono para 4,500 ganadores</b></p>
						<p style="margin: 0px;text-align: justify;margin-left: 30px;margin-right: 30px;">Cada ganador se llevará S/20 de saldo en su saldo bono.</p>
						<p class="premios-descripcion"><b style="font-family: GothamBold;">Sorteos: </b>17, 24 y 31 de mayo.</p>
								
							<ul>
									<li>Participas en cada sorteo con el número de jugadas acumuladas hasta el día anterior al sorteo y se reinician para cada nueva fecha de sorteo. Revísalos en  <a href="#" onclick="validateMisJugadas();" style="color: #ff5d00;">"Ver mis jugadas"</a></li>
									<li>Sólo podrás acceder a los S/20 de saldo o bono por cada sorteo, teniendo la posibilidad de ganar nuevamente en los siguientes sorteos.</li>
									<li>Los premios de saldos entregados a la billetera de los ganadores no podrán ser retirados inmediatamente y deberán jugarse al menos una vez en su totalidad a cualquier cuota para poder liquidarlos.</li>
									<li>Los premios de bono entregados al saldo bono, deberán jugarse con las condiciones del bono. </li>
									<li>Entregaremos el saldo o bono a la cuenta del ganador en un plazo de 48 horas después de realizado el sorteo.</li>							
							</ul>
						<div class="premios3">		
							<img class="copita" src="layer-view-image/game/copaentucasa/img-trofeo.png">
							<span class="desc-premios3">Premios secundarios para jugadores de punto de venta</span>
						</div>
							
							<ul>
									<li><b style="font-family: GothamBold;">1,000 cupones de PLAZA VEA de S/ 50 de consumo en sus tiendas. </b> 
									Estos cupones son redimibles hasta el 27 de junio de 2021 y para hacer efectivo el cupón de descuento se debe realizar 
									una sola transacción por un valor mínimo de S/ 51. Los cupones descuento no son acumulables, sólo se podrá utilizar una 
									vez para una sola transacción. Estos cupones sólo se podrán redimir en tiendas físicas de Plaza Vea. No son válidos para 
									E-COMMERCE. Estos cupones de descuento son "al portador" y no necesitan verificación documentaria. Sólo se podrán utilizar 
									una vez.</li>
									<li><b style="font-family: GothamBold;">72,500 vales de S/ 5, 10,000 vales de S/ 10 y 6,500 vales de S/ 20 por jugadas de Te Apuesto para puntos de ventas físicos.</b>
									Los vales serán "al portador" y sólo se podrán canjear una vez. Se podrán redimir hasta el 31 de agosto de 2021. Para mayor información de los premios
									para jugadores de punto de venta ingresa a <a href="https://www.programateapuesto.pe/" target="_blank" style="color: #ff5d00;">www.programateapuesto.pe</a>.</li>
																
							</ul>
															
					
					</div>
					
					
						<div class="copacasa-juegas-web">
							<h3>¿Juega en web?</h3>
							<h4>Participas automáticamente</h4>
							<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-participar-teapuesto">Juega aquí­</button>
						</div>
						
						<div class="copacasa-punto-venta">
							<h3>¿Juega en punto de venta?</h3>						
							<button type="button" id="btn_mobile_registra_ticket" onclick="return false;"class="button-registra-ticket">Registra tu ticket aquí</button>
						</div>
				
				</section>
			</div>
		</div>
	</div>	
<jsp:include page="../../include/footer.jsp" />
</body>
</html>