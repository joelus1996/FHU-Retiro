<%@ include file="../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${isLottoSale == true && isGanagolSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=ganagol"/></c:if>
<!DOCTYPE html>
<html lang="es">
<head>

	<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=1024">
    <title>Juego de apuestas deportivas en Perú - Ganagol </title>
    <meta name='description' content="Ganagol es uno de los juegos de apuestas deportivas más populares de La Tinka, que se enfoca principalmente en los partidos de fútbol locales y nacionales." />
    
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/ganagol/theme.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/ganagol/themeGanagol.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">   

    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    
    <script type="text/javascript" src="layer-view-script/game/ganagol/tagging-ganagol.js?v=2"></script>
    
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


    <%@ include file="../../include/header.jspf" %>
    <input type="hidden" value="${clientId}" id="clientId">
    
     <div class="main-content" style="top: 0px;padding-top: 0px;">
    			
			<div class="content">				
				<section class="main-section">														
					<div class="main-game copa-casa-results">
						<div class="copacasa-volver">
							  <div class="row">
							  	<div id="copacasa-retroceder" class="col-sm-2"><a href='#'><img class="img-volver" src="layer-view-image/game/copaentucasa/img-flecha.gif"></a></div>
							  	<div class="col-sm-3"><img class="img-volver-header" src="layer-view-image/game/copaentucasa/img-copa-en-tu-casa-header.gif"></div>							    
							    <div class="col-sm-5" style="left: -75px;top: 20px;padding: 0px;"><p style="font-family: TekturNarrow;font-size: 44px;">LA COPA EN TU CASA</p></div>
							    <div class="col-sm-2"><img class="img-logo-teapuesto" src="layer-view-image/game/copaentucasa/logo-teapuesto.gif"></div>
							  </div>				
						</div>
						
						<div class="f_linea-copacasa" >
						</div>
						
					 <div class="row" style="width: 950px;margin: 0px;">	
						<div class="col-sm-6" style="padding: 0px;">
						
						<div class="desc-sorteo"><h3>SORTEOS 07, 14, 21, 28 DE JUNIO, 05 Y 12 DE JULIO POR:</h3></div>
						<div class="desc-premio"><h3>¡TV Ultra HD 70", Soundbar, Kit Blanquirrojo y más premios!</h3></div>	
					
						<c:if test="${totalTicket >=0 && totalTicket<=9}">
						<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-calichin-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
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
							<img src="layer-view-image/game/copaentucasa/img-level-amateur-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
							<div class="desc-nivel-position">
								<span class="tipo-nivel">AMATEUR</span>
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
					 <c:if test="${totalTicket >=30 && totalTicket<=59}">
						<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-crack-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
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
							<img src="layer-view-image/game/copaentucasa/img-level-leyenda-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
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
						<img src="layer-view-image/game/copaentucasa/img-level-calichin.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=10 && totalTicket<=29}">
						<img src="layer-view-image/game/copaentucasa/img-level-amateur.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=30 && totalTicket<=59}">
						<img src="layer-view-image/game/copaentucasa/img-level-crack.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=60}">
						<img src="layer-view-image/game/copaentucasa/img-level-leyenda.png" style="margin-left: 50px;">
					</c:if>	
					</div>
					
					<div class="col-sm-6">
						<div class="desc-sorteo"><h3>TAMBIÉN PARTICIPA EN SORTEOS SEMANALES</h3></div>
						<c:if test="${win eq 0}">
							<div class="desc-premio"><h3>¡Son S/ 90,000 en saldo para seguir jugando!</h3></div>
						</c:if>
						<c:if test="${win eq 1}">
							<div class="desc-premio"><img class="copita-desktop" src="layer-view-image/game/copaentucasa/img-trofeo.png"><h3>¡Felicidades, ganaste S/ ${totalPremio} de ${tipoPremio}!</h3></div>
						</c:if>
						<table id="table-copacasa" style="width:80%;">
						  <tr>
						    <th style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px;">Sorteos</th>
						    <th style="font-family: GothamBold;">N° de Jugadas</th>
						  </tr>
						  
						  <c:forEach var="item" items="${listTickets}">
						  
							  <c:if test="${activaPremio  eq  item.promId }">
							  		
							  		<c:if  test="${item.promId  eq 'TAF301' }">					  	 														  
									  	<tr>						  
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-top: 10px">${item.promDate}</td>
										    <td style="color:#ff5d00;font-family:GothamBold;border-left: 1px solid black;padding-top: 10px">${item.promCount}</td> 
										</tr>
									</c:if>
									
									<c:if  test="${item.promId  eq 'TAF302'  or item.promId  eq 'TAF303'  or item.promId  eq 'TAF304'  or item.promId  eq 'TAF305'  or item.promId  eq 'TAF306' or item.promId  eq 'TAF307' or item.promId  eq 'TAF308'}">
									   <tr>	
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">${item.promDate}</td>
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								   
								   <c:if  test="${item.promId  eq 'TAF309' }">
									   <tr>	
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-bottom: 10px;">${item.promDate}</td>
										    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-bottom: 10px;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>														
																	     
							  </c:if>
							  
							   <c:if  test="${activaPremio  ne item.promId }">
							   	 
								  <c:if  test="${item.promId  eq 'TAF301' }">
									   <tr>	
										    <td style="border-left: 1px solid black;padding-top: 10px">${item.promDate}</td>
										    <td style="border-left: 1px solid black;padding-top: 10px">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								  
								  <c:if  test="${item.promId  eq 'TAF302'  or item.promId  eq 'TAF303'  or item.promId  eq 'TAF304'  or item.promId  eq 'TAF305'  or item.promId  eq 'TAF306' or item.promId  eq 'TAF307' or item.promId  eq 'TAF308'}">
									   <tr>	
										    <td style="border-left: 1px solid black;">${item.promDate}</td>
										    <td style="border-left: 1px solid black;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								   
								   <c:if  test="${item.promId  eq 'TAF309' }">
									   <tr>	
										    <td style="border-left: 1px solid black;padding-bottom: 10px;">${item.promDate}</td>
										    <td style="border-left: 1px solid black;padding-bottom: 10px;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								     
								    
							   </c:if>
							  	 
						  </c:forEach>
						  
						  <tr style="border-top: 1px solid black;">
						    <td style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px;">Total jugadas: </td>
						    <td style="font-family: GothamBold;"> ${totalTicket}</td>
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
							    <td style="color:#ff5d00; font-family:GothamBold;border-left: 1px solid black;padding-bottom: 10px;">28 de junio</td>
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
						<div class="desc-sorteo2"><h3>¡Sigue aumentado tus posibilidades de ganar!</h3>
							<div class="copa-jugar-teapuesto">
								<button type="button" id="btn_desktop_teapuesto_home" onclick="toTAV2();"class="button-teapuesto">Juega desde S/ 5</button>
							</div>
						</div>
					</div>
				</div>
											
					</div>
				</section>	
			</div>
			
    </div>				
    
        <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/copaentucasa/lotto-copaentucasa.js"></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<%@ include file="../../include/footer.jspf" %>

</body>
</html>