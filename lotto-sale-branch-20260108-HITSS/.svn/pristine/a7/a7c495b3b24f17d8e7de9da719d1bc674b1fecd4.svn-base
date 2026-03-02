<%@ include file="../../../include/taglibs.jspf"%>
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
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/ganagol/themeGanagol.css?v=1">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">   

    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    
    <script type="text/javascript" src="layer-view-script/game/ganagol/tagging-ganagol.js"></script>
    
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


    <%@ include file="../../../include/header.jspf" %>
    <input type="hidden" value="${clientId}" id="clientId">
    
     <div class="main-content" style="top: 0px;padding-top: 0px;">
    			
			<div class="content">				
				<section class="main-section">														
					<div class="main-game copa-casa-results" style="background-color: #d7e2e4;padding-bottom: 65px;">
						<div class="avionEstambul-volver" style="background-color: #d7e2e4;">
							  <div class="row">
							  	<div id="avionEstambul-retroceder" class="col-sm-2"><a href='#'><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></a></div> 
							  	
							  </div>				
						</div>
					<div class="f_linea-copacasa" ></div>	 
					 <div class="row" style="width: 950px;margin: 0px;">	
						<div class="col-sm-6" style="padding: 0px;">
						
						<div class="desc-sorteo" ><h3 style="color: #000000;">SORTEOS 05 Y 22 DE MAYO:</h3></div>
						<div class="desc-premio" ><h3 style="color: #f75b1e;margin-left: 30px; margin-right: -30px;font-size: 14px;">¡10 GANADORES DE UN PAQUETE PARA IR A LA FINAL EN ESTAMBUL!</h3></div>	
					
						<c:if test="${totalTicket >=0 && totalTicket<=9}">
						<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-calichin-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;" alt="Te Apuesto te lleva a la Final de la Champions 2023">
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
							<img src="layer-view-image/game/copaentucasa/img-level-amateur-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;" alt="Te Apuesto te lleva a la Final de la Champions 2023">
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
					 <c:if test="${totalTicket >=50 && totalTicket<=99}">
						<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copaentucasa/img-level-crack-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;" alt="Te Apuesto te lleva a la Final de la Champions 2023">
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
							<img src="layer-view-image/game/copaentucasa/img-level-leyenda-header.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;" alt="Te Apuesto te lleva a la Final de la Champions 2023">
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
					<div class="desc-total-tickets"><h3 style="color: #f75b1e;">VAS ${totalTicket} JUGADAS ACUMULADAS</h3></div>
					
					<c:if test="${totalTicket >=0 && totalTicket<=9}">
						<img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-calichin.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=10 && totalTicket<=49}">
						<img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-amateur.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=50 && totalTicket<=99}">
						<img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-crack.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=100}">
						<img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-leyenda.png" style="margin-left: 50px;">
					</c:if>	
					</div>
					
					<div class="col-sm-6">
						<div class="desc-sorteo" ><h3 style="font-size:14px; color: #000000;">También puedes ganar S/ 10 de saldo al instante</h3></div>
						<div class="desc-premio" ><h3 style="font-size:15px; color: #f75b1e;">¡Son S/ 443,000 en saldos para seguir jugando!</h3></div>												
						<table class="table-result" style="width: 80%" >
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
						<div class="desc-sorteo2"><h3 style="color: #000000;">¡Sigue aumentado tus posibilidades de ganar!</h3>
							<div class="copa-opciones2">
								<button style="width: 181px; margin-right: 80px;padding: 5px 5px 5px 5px;" type="button" class="btnEnlaceTeApuesto button-avion-qatar-naranja button-display-texto" >Juega aquí desde S/ 10</button>
							</div>
						</div>
					</div>
				</div>
											
					</div>
				</section>	
			</div>
			
    </div>				
    
        <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/teapuesto/avionQatar/lotto-avionQatar.js?v=3"></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<%@ include file="../../../include/footer.jspf" %>

</body>
</html>