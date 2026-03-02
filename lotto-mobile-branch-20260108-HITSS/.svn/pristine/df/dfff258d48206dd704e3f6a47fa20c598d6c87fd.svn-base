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
    <title>Juegos de loterías y apuestas deportivas en Perú - La Tinka </title>
    <meta name='description' content="La Tinka es la compañía líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto." />	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
</head>
<body style="background-color: #007D2E">
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
			<jsp:include page="../../include/header.jsp" />		
		<div class="content-wrap">		
			<div class="content">		
				<section class="main-section">				
				<div id="copabicolor-retroceder" class="copacasa-volver" style="background-color: #007D2E;">
					  <div class="row" style="width: 100%">
						    <div class="col-sm-4"><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></div>
						    <div class="col-sm-4" style="margin:0px auto"><img style="margin-top: 11px;" class="img-volver" src="layer-view-image/game/copabicolor/img-logo-premiazogg-mobile.png"></div>
						    <!-- <div class="col-sm-4"><img class="img-logo-teapuesto" style="right: 10px;" src="layer-view-image/game/copabicolor/logo-teapuesto.gif"></div> -->
						  </div>					
				</div>
				<c:if test="${totalTicket >=0 && totalTicket<=9}">
					<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-calichin-header-gg.png" class="level-header-copa-casa">
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
				<c:if test="${totalTicket >=10 && totalTicket<=29}">
					<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-amateur-header-gg.png" class="level-header-copa-casa">
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
				<c:if test="${totalTicket >=30 && totalTicket<=59}">
					<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-crack-header-gg.png" class="level-header-copa-casa">
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
				<c:if test="${totalTicket >=60}">											
						<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-leyenda-header-gg.png" class="level-header-copa-casa">
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
				<div class="desc-total-tickets"><h3 >VAS ${totalTicket} JUGADAS ACUMULADAS</h3></div>
				
				<c:if test="${totalTicket >=0 && totalTicket<=9}">
				<img class="responsive-imagenes" src="layer-view-image/game/copabicolor/img-GG-level-calichin.png">
				</c:if>
				<c:if test="${totalTicket >=10 && totalTicket<=29}">
				<img class="responsive-imagenes" src="layer-view-image/game/copabicolor/img-GG-level-amateur.png">
				</c:if>
				<c:if test="${totalTicket >=30 && totalTicket<=59}">
				<img class="responsive-imagenes" src="layer-view-image/game/copabicolor/img-GG-level-crack.png" >
				</c:if>
				<c:if test="${totalTicket >=60}">
				<img class="responsive-imagenes" src="layer-view-image/game/copabicolor/img-GG-level-leyenda.png">
				</c:if>
				
				<!-- <div>
				<div class="desc-sorteo"><h3 style="font-size: 18px;font-family: 'TekturSemiBold';color: #ce061f;margin-top: 40px;">¡Ya estás participando por S/ 140,000</h3></div>			
				<div class="desc-sorteo"><h3 style="font-size: 18px;font-family: 'TekturSemiBold';color: #ce061f;margin-bottom: 10px;">en saldo para seguir jugando!</h3></div><br>
				<div class="desc-sorteo"><h3 style="font-size: 13px;color: #ce061f;margin-top: 0px;font-family: 'GothamBold';">Cada jugada de S/5 a más es una nueva</h3></div>
				<div class="desc-sorteo"><h3 style="font-size: 13px;color: #ce061f;font-family: 'GothamBold';margin-bottom: 35px;">oportunidad para ganar.</h3></div>
				<div class="desc-sorteo"><h3 style="font-size: 13px;color: #2e2f30;font-family: 'GothamBold';">Además, cada jugada se acumula para participar </h3></div>
				<div class="desc-sorteo"><h3 style="font-size: 13px; color: #2e2f30;font-family: 'GothamBold';">de nuestros sorteos semanales por TV Ultra HD 70",</h3></div>
				<div class="desc-sorteo"><h3 style="font-size: 13px; color: #2e2f30;font-family: 'GothamBold';">Soundbar, Kit Bicolor, ¡y más premios!</h3></div>
					<div class="desc-sorteo"><h3>SORTEOS 01, 08, 15 Y 22 DE NOVIEMBRE POR:</h3></div>
					<img class="responsive-imagenes" style="width: 330px;margin-bottom: 30px;" src="layer-view-image/game/copabicolor/img-premios.png">				
					<div class="desc-sorteo"><h3>TAMBIÉN PUEDES GANAR S/ 10 DE SALDO AL INSTANTE</h3></div>				
					<div class="desc-premio"><h3 style="color:#ce061f;margin-bottom: 40px;">¡Son S/ 140,000 en saldo para seguir jugando!</h3></div>
				</div> -->
				<div>
					<div class="desc-sorteo"><h3 style="font-size: 12px; color: #ffffff;font-family: AmsiPro-Bold;">SORTEOS 18 DE JULIO Y 01 DE AGOSTO POR:</h3></div>	
					<img class="responsive-imagenes" style="width: 330px;margin-bottom: 30px;" src="layer-view-image/game/copabicolor/img-banner_mid.png">		
					<div class="desc-sorteo"><h3 style="font-size: 14px; color: #ffffff;font-family: AmsiPro-Bold;">También puedes ganar S/ 4 de saldo al instante</h3></div>	
					<div class="desc-sorteo"><h3 style="font-size: 18px; color: #f0c607;font-family: AmsiPro-Ultra;margin-bottom: 2px;">¡Son S/ 6,000 en saldos para </h3></div>	
					<div class="desc-sorteo"><h3 style="font-size: 18px; color: #f0c607;font-family: AmsiPro-Ultra;">seguir jugando!</h3></div>
				</div>
						<div class="tabla-puntajes">				
						<!-- No mover estilos de la tabla copa en tu casa y th --> 					 
						<table id="table-copacasa" style="width:100%; border: 1px solid #ffffff;border-collapse: collapse;color: #ffffff;font-size: 12px;">
						  <tr>
						    <th style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px; border: 1px solid #ffffff;border-collapse: collapse;text-align: center;">Sorteos</th>
						    <th style="font-family: GothamBold; border: 1px solid #ffffff;border-collapse: collapse;text-align: center;">N° de Jugadas</th>
						  </tr>
						  
						  <c:forEach var="item" items="${listTickets}">
						  
							  <c:if test="${activaPremio  eq  item.promId }">
							  		
							  		<c:if  test="${item.promId  eq 'PGG401' }">					  	 														  
									  	<tr>						  
										    <td style="color:#f0c607; font-family:GothamBold;border-left: 1px solid #ffffff;padding-top: 10px;text-align: center;">${item.promDate}</td>
										    <td style="color:#f0c607; font-family:GothamBold;border-left: 1px solid #ffffff;padding-top: 10px;text-align: center;">${item.promCount}</td> 
										</tr>
									</c:if>
									
									<%-- <c:if  test="${item.promId  eq 'TAF402'  or item.promId  eq 'TAF403'}">
									   <tr>	
										    <td style="color:#ce061f; font-family:GothamBold;border-left: 1px solid black;padding: 2px;text-align: center;">${item.promDate}</td>
										    <td style="color:#ce061f; font-family:GothamBold;border-left: 1px solid black;padding: 2px;text-align: center;">${item.promCount}</td>
									    </tr> 								 
								   </c:if> --%>
								   
								   <c:if  test="${item.promId  eq 'PGG402' }">
									   <tr>	
										    <td style="color:#f0c607; font-family:GothamBold;border-left: 1px solid #ffffff;padding-bottom: 10px;text-align: center;">${item.promDate}</td>
										    <td style="color:#f0c607; font-family:GothamBold;border-left: 1px solid #ffffff;padding-bottom: 10px;text-align: center;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>														
																	     
							  </c:if>
							  
							   <c:if  test="${activaPremio  ne item.promId }">
							   	 
								  <c:if  test="${item.promId  eq 'PGG401' }">
									   <tr>	
										    <td style="border-left: 1px solid #ffffff;padding-top: 10px; text-align: center;font-family: GothamBook;">${item.promDate}</td>
										    <td style="border-left: 1px solid #ffffff;padding-top: 10px; text-align: center;font-family: GothamBook;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								  
								  <%-- <c:if  test="${item.promId  eq 'TAF402'  or item.promId  eq 'TAF403'}">
									   <tr>	
										    <td style="border-left: 1px solid black;padding: 2px;text-align: center;font-family: GothamBook;">${item.promDate}</td>
										    <td style="border-left: 1px solid black;padding: 2px;text-align: center;font-family: GothamBook;">${item.promCount}</td>
									    </tr> 								 
								   </c:if> --%>
								   
								   <c:if  test="${item.promId  eq 'PGG402' }">
									   <tr>	
										    <td style="border-left: 1px solid #ffffff;padding-bottom: 10px;text-align: center;font-family: GothamBook;">${item.promDate}</td>
										    <td style="border-left: 1px solid #ffffff;padding-bottom: 10px;text-align: center;font-family: GothamBook;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								     
								    
							   </c:if>
							  	 
						  </c:forEach>
						  
						  <tr style="border-top: 1px solid #ffffff;">
						    <td style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px;text-align: center;">Total jugadas: </td>
						    <td style="font-family: GothamBold;text-align: center;"> ${totalTicket}</td>
						  </tr>
					</table>
				</div>	
				 			
				<div class="desc-sorteo2" style=" background-color: #007c37;" ><h3 >¡Sigue aumentado tus posibilidades de ganar!</h3>
					<div class="copa-jugar-teapuesto">
						<button type="button"   onclick="return false;"class=" btnEnlaceGanagol button-copa2" style="font-size: 16px;width:197px;padding-bottom: 7px;">Juega aquí</button>
					</div>
				</div>
				</section>
			</div>
		</div>	
	</div>			
<jsp:include page="../../include/footer.jsp" />
</body>
</html>