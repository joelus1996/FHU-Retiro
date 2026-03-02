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
    <title>Juegos de loterías y apuestas deportivas en Perú - La Tinka </title>
    <meta name='description' content="La Tinka es la compañía líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto." />	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
</head>
<body style="background-color: #d7e2e4">
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
				<div id="avionEstambul-retroceder" class="copacasa-volver" style="background-color: #004d89;">
					  <div class="row" style="width: 100%">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						    <div class="col-sm-4" style="margin:0px auto"><img style="margin-top: 4px;" class="img-volver" src="layer-view-image/game/teapuesto/avionEstambul/header-mobile-estambul.png" alt="Te Apuesto te lleva a la Final de la Champions 2023"></div>
						    <!-- <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div> -->
						  </div>					
				</div>
				<c:if test="${totalTicket >=0 && totalTicket<=9}">
					<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-calichin-header.png" class="level-header-copa-casa" alt="Te Apuesto te lleva a la Final de la Champions 2023">
							<div class="desc-nivel-position">
								<span class="tipo-nivel">CALICHÍN</span>
								<br>
								<span class="tipo-nivel-descripcion-superior">Tienes </span>
								<span class="puntaje-por-nivel">${puntajeNivel}</span>
								<br>
								<span class="tipo-nivel-descripcion">opciones para los sorteos</span>
								<br>
								<span class="tipo-nivel-descripcion">de premios mayores</span>
							</div>
						</div>
				</c:if>
				<c:if test="${totalTicket >=10 && totalTicket<=49}">
					<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-amateur-header.png" class="level-header-copa-casa" alt="Te Apuesto te lleva a la Final de la Champions 2023">
							<div class="desc-nivel-position">
								<span class="tipo-nivel">AMATEUR</span>
								<br>
								<span class="ttipo-nivel-descripcion-superior">Tienes </span>
								<span class="puntaje-por-nivel">${puntajeNivel}</span>
								<br>
								<span class="tipo-nivel-descripcion">opciones para los sorteos</span>
								<br>
								<span class="tipo-nivel-descripcion">de premios mayores</span>
							</div>
						</div>
				</c:if>
				<c:if test="${totalTicket >=50 && totalTicket<=99}">
					<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-crack-header.png" class="level-header-copa-casa" alt="Te Apuesto te lleva a la Final de la Champions 2023">
							<div class="desc-nivel-position">
								<span class="tipo-nivel">CRACK</span>
								<br>
								<span class="tipo-nivel-descripcion-superior">Tienes </span>
								<span class="puntaje-por-nivel">${puntajeNivel}</span>
								<br>
								<span class="tipo-nivel-descripcion">opciones para los sorteos</span>
								<br>
								<span class="tipo-nivel-descripcion">de premios mayores</span>
							</div>
						</div>
				</c:if>
				<c:if test="${totalTicket >=100}">											
						<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-leyenda-header.png" class="level-header-copa-casa" alt="Te Apuesto te lleva a la Final de la Champions 2023">
							<div class="desc-nivel-position">
								<span class="tipo-nivel">LEYENDA</span>
								<br>
								<span class="tipo-nivel-descripcion-superior">Tienes </span>
								<span class="puntaje-por-nivel">${puntajeNivel}</span>
								<br>
								<span class="tipo-nivel-descripcion">opciones para los sorteos</span>
								<br>
								<span class="tipo-nivel-descripcion">de premios mayores</span>
							</div>
						</div>
				</c:if>	
				<div class="desc-total-tickets-avionQatar"><h3 >VAS ${totalTicket} JUGADAS ACUMULADAS</h3></div>
				
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
					<div class="desc-sorteo"><h3 style="font-size: 12px; color: #000000;font-family: AmsiPro-Bold;">SORTEOS 05 Y 22 DE MAYO:</h3></div>	
					<img class="responsive-imagenes" style="width: 330px;margin-bottom: 30px;" src="layer-view-image/game/teapuesto/avionEstambul/banner-mobile-virtuales.png" alt="Te Apuesto te lleva a la Final de la Champions 2023">		
					<div class="desc-sorteo"><h3 style="font-size: 14px; color: #000000;font-family: AmsiPro-Bold;">También puedes ganar S/ 10 de saldo al instante</h3></div>	
					<div class="desc-sorteo"><h3 style="font-size: 18px; color: #fb5300;font-family: AmsiPro-Bold;margin-bottom: 2px;">¡Son S/ 443,000 en saldos para </h3></div>	
					<div class="desc-sorteo"><h3 style="font-size: 18px; color: #fb5300;font-family: AmsiPro-Bold;">seguir jugando!</h3></div>
				</div>
						<div class="tabla-puntajes">				
						<!-- No mover estilos de la tabla copa en tu casa y th --> 					 
						<table class="table-result" >
						  <tr>
						    <th class="header izq" >Sorteos</th>
						    <th class="header der" >N° de Jugadas</th>
						  </tr>
						  <c:forEach var="item" items="${listTickets}">
						  
							  <c:if test="${activaPremio  eq  item.promId }">
							  		
							  		<c:if  test="${item.promId  eq 'SORTEO1' }">					  	 														  
									  	<tr>						  
										    <td style="color:#f75b1e" class="center izq">${item.promDate}</td>
										    <td style="color:#f75b1e" class="center der">${item.promCount}</td> 
										</tr>
									</c:if>
								   
								   <c:if  test="${item.promId  eq 'SORTEO2' }">
									   <tr>	
										    <td style="color:#f75b1e" class="center izq">${item.promDate}</td>
										    <td style="color:#f75b1e" class="center der">${item.promCount}</td>
									    </tr> 								 
								   </c:if>														
																	     
							  </c:if>
							  
							   <c:if  test="${activaPremio  ne item.promId }">
							   	 
								  <c:if  test="${item.promId  eq 'SORTEO1' }">
									   <tr>	
										    <td class="center izq">${item.promDate}</td>
										    <td class="center der">${item.promCount}</td>
									    </tr> 								 
								   </c:if> 
								   
								   <c:if  test="${item.promId  eq 'SORTEO2' }">
									   <tr>	
										    <td class="center izq">${item.promDate}</td>
										    <td class="center der">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								     
								    
							   </c:if>
							  	 
						  </c:forEach>
						  
						  <tr>
						    <th class="header izq">Total jugadas: </th>
						    <th class="header der"> ${totalTicket}</th>
						  </tr>
					</table>
				</div>
				<div class="desc-sorteo2" style=" background-color: #d7e2e4;" ><h3 style="color:#000000" >¡Sigue aumentado tus posibilidades de ganar!</h3>
					<div style="text-align: center;">
						<button id="btn_mobile_teapuesto_home" type="button"   onclick="return false;"class="button-avion-qatar-naranja" style="font-size: 16px;width:197px;padding-bottom: 7px;">Juega aquí</button>
					</div>
				</div>
				</section>
			</div>
		</div>	
	</div>			
<jsp:include page="../../../include/footer.jsp" />
</body>
</html>