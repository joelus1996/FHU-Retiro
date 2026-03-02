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
<body class="main-copaentucasa-results">
<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<c:set var="lapollaEnabled"><%=Boolean.valueOf(Constantes.lapollaEnabled.trim()).booleanValue()%></c:set>
	<c:set var="tav2Enabled"><%=Boolean.valueOf(Constantes.tav2Enabled.trim()).booleanValue()%></c:set>
	<c:set var="bannersUrl"><%=Constantes.bannersUrl.toString().trim()%></c:set>
	<c:set var="gamesXML"><%=Constantes.gamesXML.toString().trim()%></c:set>
	<input type="hidden" id="clientId" value='${clientId}'>
	<input type="hidden" id="totalTickets" value='${activaPremio}'>
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
				<c:if test="${totalTicket >=0 && totalTicket<=9}">
					<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-calichin-header.png" class="level-header-copa-casa">
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
							<img src="layer-view-image/game/copaentucasa/img-level-amateur-header.png" class="level-header-copa-casa">
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
							<img src="layer-view-image/game/copaentucasa/img-level-crack-header.png" class="level-header-copa-casa">
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
							<img src="layer-view-image/game/copaentucasa/img-level-leyenda-header.png" class="level-header-copa-casa">
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
				<div class="desc-total-tickets"><h3>VAS ${totalTicket} JUGADAS ACUMULADAS</h3></div>
				
				<c:if test="${totalTicket >=0 && totalTicket<=9}">
				<img class="responsive-imagenes" src="layer-view-image/game/copaentucasa/img-level-calichin.png">
				</c:if>
				<c:if test="${totalTicket >=10 && totalTicket<=29}">
				<img class="responsive-imagenes" src="layer-view-image/game/copaentucasa/img-level-amateur.png">
				</c:if>
				<c:if test="${totalTicket >=30 && totalTicket<=59}">
				<img class="responsive-imagenes" src="layer-view-image/game/copaentucasa/img-level-crack.png" >
				</c:if>
				<c:if test="${totalTicket >=60}">
				<img class="responsive-imagenes" src="layer-view-image/game/copaentucasa/img-level-leyenda.png">
				</c:if>
				
				<div class="desc-sorteo"><h3>SORTEOS 07, 14, 21, 28 DE JUNIO, 05 Y 12 DE JULIO POR:</h3></div>
				<img class="responsive-imagenes" src="layer-view-image/game/copaentucasa/img-premios.png">
				<div class="f_linea-copacasa"></div>
				<div class="desc-sorteo"><h3>TAMBIÉN PARTICIPA EN SORTEOS SEMANALES</h3></div>
				<c:if test="${win eq 0}">
					<div class="desc-premio"><h3>¡Son S/ 90,000 en saldo para seguir jugando!</h3></div>
				</c:if>
				<c:if test="${win eq 1}">
					<div class="desc-premio" style="position: relative;"><img class="copita-mobile" src="layer-view-image/game/copaentucasa/img-trofeo.png" style="position: absolute;top: -13px;left: 20px;">
						<h3>¡Felicidades, ganaste S/ ${totalPremio} de ${tipoPremio}!</h3>
					</div>
				</c:if>
				
						<div class="tabla-puntajes">				
						<!-- No mover estilos de la tabla copa en tu casa y th --> 					 
						<table id="table-copacasa" style="width:100%; border: 1px solid black;border-collapse: collapse;color: #2e2f30;font-size: 12px;">
						  <tr>
						    <th style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px; border: 1px solid black;border-collapse: collapse;text-align: center;">Sorteos</th>
						    <th style="font-family: GothamBold; border: 1px solid black;border-collapse: collapse;text-align: center;">N° de Jugadas</th>
						  </tr>
						  
						  <c:forEach var="item" items="${listTickets}">
						  
							  <c:if test="${activaPremio  eq  item.promId }">
							  		
							  		<c:if  test="${item.promId  eq 'TAF301' }">					  	 														  
									  	<tr>						  
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-top: 10px;text-align: center;">${item.promDate}</td>
										    <td style="color:#ff5d00;font-family:GothamBold;border-left: 1px solid black;padding-top: 10px;text-align: center;">${item.promCount}</td> 
										</tr>
									</c:if>
									
									<c:if  test="${item.promId  eq 'TAF302'  or item.promId  eq 'TAF303'  or item.promId  eq 'TAF304'  or item.promId  eq 'TAF305'  or item.promId  eq 'TAF306' or item.promId  eq 'TAF307' or item.promId  eq 'TAF308'}">
									   <tr>	
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding: 2px;text-align: center;">${item.promDate}</td>
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding: 2px;text-align: center;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								   
								   <c:if  test="${item.promId  eq 'TAF309' }">
									   <tr>	
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-bottom: 10px;text-align: center;">${item.promDate}</td>
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-bottom: 10px;text-align: center;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>														
																	     
							  </c:if>
							  
							   <c:if  test="${activaPremio  ne item.promId }">
							   	 
								  <c:if  test="${item.promId  eq 'TAF301' }">
									   <tr>	
										    <td style="border-left: 1px solid black;padding-top: 10px; text-align: center;font-family: GothamBook;">${item.promDate}</td>
										    <td style="border-left: 1px solid black;padding-top: 10px; text-align: center;font-family: GothamBook;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								  
								  <c:if  test="${item.promId  eq 'TAF302'  or item.promId  eq 'TAF303'  or item.promId  eq 'TAF304'  or item.promId  eq 'TAF305'  or item.promId  eq 'TAF306' or item.promId  eq 'TAF307' or item.promId  eq 'TAF308'}">
									   <tr>	
										    <td style="border-left: 1px solid black;padding: 2px;text-align: center;font-family: GothamBook;">${item.promDate}</td>
										    <td style="border-left: 1px solid black;padding: 2px;text-align: center;font-family: GothamBook;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								   
								   <c:if  test="${item.promId  eq 'TAF309' }">
									   <tr>	
										    <td style="border-left: 1px solid black;padding-bottom: 10px;text-align: center;font-family: GothamBook;">${item.promDate}</td>
										    <td style="border-left: 1px solid black;padding-bottom: 10px;text-align: center;font-family: GothamBook;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								     
								    
							   </c:if>
							  	 
						  </c:forEach>
						  
						  <tr style="border-top: 1px solid black;">
						    <td style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px;text-align: center;font-family">Total jugadas: </td>
						    <td style="font-family: GothamBold;text-align: center;font-family"> ${totalTicket}</td>
						  </tr>
						  
						  
						  <!--
						  <tr>
							<c:if test="${activaPremio  eq 1}">						  
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-top: 10px;">17 de mayo</td>
							    <td style="color:#ff5d00;font-family:GothamBold;border-left: 1px solid black;padding-top: 10px;">${cantSorteo01}</td> 
						    </c:if>
						    <c:if test="${activaPremio ne 1}">						  
							    <td style="border-left: 1px solid black;padding-top: 10px;">17 de mayo</td>
							    <td style="border-left: 1px solid black;padding-top: 10px;">${cantSorteo01}</td> 
						    </c:if>
						  </tr>
						   <tr>
						   <c:if test="${activaPremio  eq 2}">
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">24 de mayo</td>
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">${cantSorteo02}</td>
						    </c:if>
						    <c:if test="${activaPremio ne 2}">
							    <td style="border-left: 1px solid black;">24 de mayo</td>
							    <td style="border-left: 1px solid black;">${cantSorteo02}</td>
						    </c:if>
						  </tr>
						  <tr>
							  <c:if test="${activaPremio  eq 3}">
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">31 de mayo</td>
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">${cantSorteo03}</td>
							  </c:if>
							  <c:if test="${activaPremio  ne 3}">
							    <td style="border-left: 1px solid black;">31 de mayo</td>
							    <td style="border-left: 1px solid black;">${cantSorteo03}</td>
							  </c:if>  
						  </tr>
						  <tr>
						    <c:if test="${activaPremio  eq 4}">
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">07 de junio</td>
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">${cantSorteo04}</td>
							  </c:if>
							  <c:if test="${activaPremio  ne 4}">
							    <td style="border-left: 1px solid black;">07 de junio</td>
							    <td style="border-left: 1px solid black;">${cantSorteo04}</td>
							  </c:if>  
						  </tr>
						  <tr>
						    <c:if test="${activaPremio  eq 5}">
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">14 de junio</td>
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">${cantSorteo05}</td>
							 </c:if>
							 <c:if test="${activaPremio  ne 5}">
							    <td style="border-left: 1px solid black;">14 de junio</td>
							    <td style="border-left: 1px solid black;">${cantSorteo05}</td>
							 </c:if>  
						  </tr>
						   <tr>
						    <c:if test="${activaPremio  eq 6}">
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">21 de junio</td>
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">${cantSorteo06}</td>
							 </c:if>
							 <c:if test="${activaPremio  ne 6}">
							    <td style="border-left: 1px solid black;">21 de junio</td>
							    <td style="border-left: 1px solid black;">${cantSorteo06}</td>
							 </c:if>  
						  </tr>
						   <tr>
						    <c:if test="${activaPremio  eq 7}">
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black; padding-bottom: 10px;">28 de junio</td>
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-bottom: 10px;">${cantSorteo07}</td>
							 </c:if>
							 <c:if test="${activaPremio  ne 7}">
							    <td style="border-left: 1px solid black;padding-bottom: 10px;">28 de junio</td>
							    <td style="border-left: 1px solid black;padding-bottom: 10px;">${cantSorteo07}</td>
							 </c:if>  
						  </tr>
						   <tr style="border-top: 1px solid black;">
						    <td style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px;">Total jugadas: </td>
						    <td style="font-family: GothamBold;"> ${totalTicket}</td>
						  </tr>
						  
						  -->
					</table>
				</div>	
				 			
				<div class="desc-sorteo2"><h3>¡Sigue aumentado tus posibilidades de ganar!</h3>
					<div class="copa-jugar-teapuesto">
						<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-teapuesto">Juega desde S/ 5</button>
					</div>
				</div>
				</section>
			</div>
		</div>	
	</div>			
<jsp:include page="../../include/footer.jsp" />
</body>
</html>