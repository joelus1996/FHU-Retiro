<%@ include file="../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${isLottoSale == true && isGanagolSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=ganagol"/></c:if>
<c:if test="${flagPromoBicolor == 0 }"><c:redirect url="/"/></c:if>
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
    
    <script type="text/javascript" src="layer-view-script/game/ganagol/tagging-ganagol.js"></script>
    
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
					<div class="main-game copa-casa-results" style="background-color: #007D2E;padding-bottom: 65px;">
						<div class="copacasa-volver" style="background-color: #007D2E;">
							  <div class="row">
							  	<div id="copacasa-retroceder" class="col-sm-2"><a href='#'><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></a></div> 
							  	
							  </div>				
						</div>
					<div class="f_linea-copacasa" ></div>	 
					 <div class="row" style="width: 950px;margin: 0px;">	
						<div class="col-sm-6" style="padding: 0px;">
						
						<div class="desc-sorteo"><h3>SORTEOS 18 DE JULIO Y 01 DE AGOSTO POR:</h3></div>
						<div class="desc-premio"><h3>¡SON 4 PREMIOS DE S/ 25,000 CADA UNO!</h3></div>	
					
						<c:if test="${totalTicket >=0 && totalTicket<=9}">
						<div class="posicion-nivel-img">
							<img src="layer-view-image/game/copabicolor/img-level-calichin-header-gg.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
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
							<img src="layer-view-image/game/copabicolor/img-level-amateur-header-gg.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
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
							<img src="layer-view-image/game/copabicolor/img-level-crack-header-gg.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
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
							<img src="layer-view-image/game/copabicolor/img-level-leyenda-header-gg.png" style="max-width: 100%;margin-left: 30px;margin-right: 30px;">
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
						<img src="layer-view-image/game/copabicolor/img-GG-level-calichin.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=10 && totalTicket<=29}">
						<img src="layer-view-image/game/copabicolor/img-GG-level-amateur.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=30 && totalTicket<=59}">
						<img src="layer-view-image/game/copabicolor/img-GG-level-crack.png" style="margin-left: 50px;">
					</c:if>
					<c:if test="${totalTicket >=60}">
						<img src="layer-view-image/game/copabicolor/img-GG-level-leyenda.png" style="margin-left: 50px;">
					</c:if>	
					</div>
					
					<div class="col-sm-6">
						<div class="desc-sorteo" ><h3 style="font-size:14px;">También puedes ganar S/ 4 de saldo al instante</h3></div>
						<div class="desc-premio" ><h3 style="font-size:15px;">¡Son S/ 6,000 en saldo para seguir jugando!</h3></div>												
						<table id="table-copacasa" style="width:80%;">
						  <tr>
						    <th style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px;">Sorteos</th>
						    <th style="font-family: GothamBold;">N° de Jugadas</th>
						  </tr>
						  
						  <c:forEach var="item" items="${listTickets}">
						  
							  <c:if test="${activaPremio  eq  item.promId }">
							  		
							  		<c:if  test="${item.promId  eq 'PGG401' }">					  	 														  
									  	<tr>						  
										    <td style="color:#f0c607; font-family:GothamBold; padding-top: 10px">${item.promDate}</td>
										    <td style="color:#f0c607; font-family:GothamBold; padding-top: 10px">${item.promCount}</td> 
										</tr>
									</c:if>
									
									<%-- <c:if  test="${item.promId  eq 'TAF402'  or item.promId  eq 'TAF403'}">
									   <tr>	
										    <td style="color:#ce061f; font-family:GothamBold;border-left: 1px solid black;">${item.promDate}</td>
										    <td style="color:#ce061f; font-family:GothamBold;border-left: 1px solid black;">${item.promCount}</td>
									    </tr> 								 
								   </c:if> --%>
								   
								   <c:if  test="${item.promId  eq 'PGG402' }">
									   <tr>	
										    <td style="color:#f0c607; font-family:GothamBold;padding-bottom: 10px;">${item.promDate}</td>
										    <td style="color:#f0c607; font-family:GothamBold;padding-bottom: 10px;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>														
																	     
							  </c:if>
							  
							   <c:if  test="${activaPremio  ne item.promId }">
							   	 
								  <c:if  test="${item.promId  eq 'PGG401' }">
									   <tr>	
										    <td style=" padding-top: 10px">${item.promDate}</td>
										    <td style=" padding-top: 10px">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								  
								  <%-- <c:if  test="${item.promId  eq 'TAF402'  or item.promId  eq 'TAF403'}">
									   <tr>	
										    <td style="border-rigth: 1px solid #ffffff;">${item.promDate}</td>
										    <td style="border-rigth: 1px solid #ffffff;">${item.promCount}</td>
									    </tr> 								 
								   </c:if> --%>
								   
								   <c:if  test="${item.promId  eq 'PGG402' }">
									   <tr>	
										    <td style=" padding-bottom: 10px;">${item.promDate}</td>
										    <td style=" padding-bottom: 10px;">${item.promCount}</td>
									    </tr> 								 
								   </c:if>
								     
								    
							   </c:if>
							  	 
						  </c:forEach>
						  
						  <tr style="border-top: 1px solid #ffffff;">
						    <td style="font-family: GothamBold;padding-top: 10px;padding-bottom: 10px;">Total jugadas: </td>
						    <td style="font-family: GothamBold;"> ${totalTicket}</td>
						  </tr>
						  						 						  						  
					</table>
						<div class="desc-sorteo2"><h3>¡Sigue aumentado tus posibilidades de ganar!</h3>
							<div class="copa-opciones2">
								<button style="width: 181px; margin-right: 80px;" type="button" class="btnEnlaceGanagol button-copa2 button-display-texto" >Juega aquí desde S/ 3</button>
							</div>
						</div>
					</div>
				</div>
											
					</div>
				</section>	
			</div>
			
    </div>				
    
        <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/copabicolor/lotto-copabicolor.js"></script>
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