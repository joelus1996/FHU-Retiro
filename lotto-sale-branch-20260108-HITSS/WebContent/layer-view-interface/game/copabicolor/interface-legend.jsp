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
    <input type="hidden" value="${flagPromo}" id="clientId">
    
    <div class="main-content" style="top: 0px;padding-top: 0px;">
    				<div class="main-game copa-casa-participar">																																							
						<div class="copacasa-volver" style="background-color: #ce061f;">							  
							  <div class="row">
							  	<div id="copacasa-retroceder" class="col-sm-2"><a href='#'><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></a></div>
							  	<div class="col-sm-3"><img class="img-volver-header" src="layer-view-image/game/copabicolor/img-bicolor-en-tu-casa-header.png" style="right: 120px;"></div>							    
							    <div class="col-sm-5" style="left: -75px;top: 20px;padding: 0px;"><p style="font-family: TekturNarrow;font-size: 43px;">LA BICOLOR EN TU CASA</p></div>
							    <div class="col-sm-2"><img class="img-logo-teapuesto" src="layer-view-image/game/copabicolor/logo-teapuesto.gif" alt="Te Apuesto Logo"></div>
							  </div>
							  								  							  				
						</div>
																									
							<div class="f_linea-copacasa" style="margin-bottom: 5px"></div>
							<div style="margin-left: 20px; margin-top: 0px; margin-bottom: 0px">
							  	<div class="col-sm-2"><img class="" src="layer-view-image/game/copabicolor/img-soyleyenda.png"></div>
							</div>
							<div class="copacasa-leyenda" style="margin-top: 10px">
								<p style="margin-top:0px;margin-bottom: 0px;">
								La Bicolor en tu casa sorteará 4 camisetas oficiales autografiadas por los jugadores de la selección peruana, entre los participantes de la promoción "LA BICOLOR EN TU CASA" que tengan nivel "LEYENDA" (hayan acumulado más de 100 tickets participantes en la promoción) y hayan cumplido con la mecánica de participación del sorteo de las camisetas oficiales autografiadas. 
								</p>
							</div>
							<div class="copacasa-como-participar" style="margin-bottom:  0px">
								<h3>¿Cómo participar?</h3>
								<br><h4>Fechas para participar en el sorteo</h4>
								<p style="font-family: GothamBook; font-size: 12px">Desde el lunes 01 de noviembre del 2021 al domingo 19 de noviembre del 2021.</p>							
							</div>
							
							<div class="copacasa-terminos" >
								<h4>Mecánica de participación:</h4>
								<ol>
									<li>Pertenecer al nivel "Leyenda". Este nivel lo alcanzas acumulando 100 a más tickets participantes de la promoción "LA BICOLOR EN TU CASA"</li>
									<li>Enviar el mensaje "Soy Leyenda + Nombre + DNI" y la imagen donde demuestras tu nivel "Leyenda", al inbox de Facebook o Instagram de @teapuestooficial </li>
									<li>Para multiplicar tus opciones de ganar por 5: Sube la imagen de tu nivel "leyenda" a tus historias de Instagram etiquetando a @teapuestooficial.</li>
								</ol>
								<br>
								<div class="row" style="margin-bottom: 25px">	
									<div style="margin-left: 40px;">
										<a href="https://www.facebook.com/teapuestooficial" target="_blank">
										 	<div class="copacasa-img-facebook"></div>
										</a>
									</div>
									<div style="margin-left: 15px">
										<a href="https://www.instagram.com/teapuestooficial/" target="_blank">
										 	<div class="copacasa-img-instagram"></div>
										</a>
									</div>
									<div>
										<h4 style="margin-top: 12px; margin-left: 20px">TeApuestoOficial</h4>
									</div>
									
								</div>
								
							</div>
							
							<div class="copacasa-sorteos">
								<div class="premios1">
									<img class="copita" src="layer-view-image/game/copabicolor/img-trofeo.png">
									<span class="desc-premios1">Premios:</span>
								</div>														
								<p style="font-family: GothamBook;font-size:12px;line-height: 1.5em;margin-left: 40px;margin-bottom: 15px;margin-top: 15px;margin-right: 40px;">
									<b style="font-family: GothamBold;">CUATRO camisetas oficiales firmadas por los jugadores de la selección peruana</b> 
								</p>  
								
								<div class="row" style="margin-left: 20px">
							  		<div class="col-sm-2" style="margin-top: 20px">
							  			<img class="" src="layer-view-image/game/copabicolor/img-camiseta.png">
							  		</div>	
							  		<div class="col-sm-10">
							  			<div style="margin-left: 25px">
							  				<p style="margin: 0px;">1er sorteo de 1 camiseta: 5 de noviembre de 2021</p>
											<p style="margin: 0px;">2do sorteo de 1 camiseta: 12 de noviembre de 2021</p>
											<p style="margin: 0px; margin-bottom: 15px">3er sorteo de 2 camisetas: 19 de noviembre 2021</p>
							  			</div>
							  			<ul>
											<li style="margin-bottom: 15px">En cada sorteo elegiremos 1 ganador y 1 suplente que permanecerá como respaldo en caso el ganador no sea elegible para recibir el premio, salvo el tercer sorteo en el cual elegiremos 2 ganadores y 2 suplentes.</li>																				
											<li style="margin-bottom: 15px">En cada sorteo nos pondremos en contacto con los ganadores vía telefónica y validaremos sus datos contra Reniec para comprobar la veracidad de su información y su mayoría de edad. En caso no tengamos respuesta del ganador en un máximo de 24 horas procederemos a retirarlo de la lista de ganadores y en su lugar otorgaremos el premio al primero de los suplentes según el orden en que salió sorteado.</li>
											<li>Una vez validados los datos de los ganadores y estando en contacto con cada uno de ellos, coordinaremos los detalles del despacho y entrega de su premio.</li>																		
									</ul>
							  		</div>
							  								  		
								</div>
								<br>
						
						<div class="f_linea-copacasa-participar"></div>
						
							<c:if test="${clientId eq 0}">
							
<!-- 								<div class="row" style="padding-bottom: 40px;">	 -->
<!-- 								<div class="col-sm-6">	 -->
<!-- 									<div class="copacasa-juegas-web"> -->
<!-- 									 <div class="row" style="margin-left: 70px; margin-bottom: 2px"> -->
<!-- 										<span style="font-size: 18px;color:#2e2f30;">¿Juega en web?</span><br> -->
<!-- 										<span style="font-size: 14px;color:#ce061f;">&nbsp;Participa automáticamente</span><br> -->
<!-- 									 </div> -->
<!-- 										<button type="button" id="btn_desktop_promo_bicolor" onclick="return false;"class="button-participar-teapuesto" style="background-color: #ce061f;">Juega aquí</button><br><br><br><br> -->
<!-- 									</div> -->
<!-- 								</div>	 -->
<!-- 								<div class="col-sm-6"> -->
<!-- 									<div class="copacasa-punto-venta"> -->
<!-- 											<span style="font-size: 18px;color:#2e2f30;">¿Juega en punto de venta?</span><br>					 -->
<!-- 											<button type="button" id="btn_desktop_registra_ticket" onclick="return false;"class="button-registra-ticket" style="margin-bottom: 40px;border-color:#ce061f;">Registra tu ticket aquí</button> -->
<!-- 									</div> -->
									
<!-- 								</div> -->
<!-- 								</div>	 -->
								
								<div class="row" style="padding-bottom: 40px;">	
								<div class="col-sm-6">	
									<div class="copacasa-juegas-web">
										<span style="font-size: 18px;color:#2e2f30;">¿Quieres participar jugando en web?</span><br>
										<span style="font-size: 14px;color:#ce061f;">Tus jugadas de S/5 a más participarán automáticamente</span><br>
										<button type="button" id="btn_desktop_promo_bicolor" onclick="return false;"class="button-participar-teapuesto" style="background-color: #ce061f;">Si quiero</button><br><br><br><br>
									</div>
								</div>	
								<div class="col-sm-6">
									<div class="copacasa-punto-venta">
											<span style="font-size: 18px;color:#2e2f30;">¿Juega en punto de venta?</span><br><br>						
											<button type="button" id="btn_desktop_registra_ticket" onclick="return false;"class="button-registra-ticket" style="margin-bottom: 40px;border-color:#ce061f;">Registra tu ticket aquí</button>
									</div>
									
								</div>
								</div>	
							</c:if>
							<c:if test="${clientId ne 0}">
								<c:if test="${flagPromo == true}">
									<div class="row" style="padding-bottom: 40px;">	
										<div class="col-sm-6">
											<div class="copacasa-juegas-web">
												<span style="font-size: 18px;color:#2e2f30;">¿Juega en web?</span>
												<span style="font-size: 14px;color:#ce061f;">Participas automáticamente</span>
												<button type="button" onclick="toTAV2();"class="button-participar-teapuesto" style="background-color: #ce061f;">Juega aquí</button>
										 </div>
										</div>
										<div class="col-sm-6">
											<div class="copacasa-punto-venta">
												<span style="font-size: 18px;color:#2e2f30;">¿Juega en punto de venta?</span>						
												<button type="button" id="btn_desktop_registra_ticket" onclick="return false;"class="button-registra-ticket" style="border-color:#ce061f;">Registra tu ticket aquí</button>
											</div>
										</div>
									</div>
								</c:if>
								<c:if test="${flagPromo == false}">
							
									<div class="row" style="padding-bottom: 40px;">	
									<div class="col-sm-6">
										<div class="copacasa-juegas-web">
											<span style="font-size: 18px;color:#2e2f30;">¿Quieres participar jugando en web?</span><br>
											<span style="font-size: 14px;color:#ce061f;">Tus jugadas de S/5 a más participarán automáticamente</span><br>
											<button type="button" id="btn_desktop_promo_bicolor" onclick="return false;"class="button-participar-teapuesto" style="background-color: #ce061f;">Si quiero</button><br><br><br><br>
										</div>	
									</div>
									<div class="col-sm-6">
										<div class="copacasa-punto-venta">
											<span style="font-size: 18px;color:#2e2f30;">¿Juega en punto de venta?</span><br><br>						
											<button type="button" id="btn_desktop_registra_ticket" onclick="return false;"class="button-registra-ticket" style="margin-bottom: 40px;border-color:#ce061f;">Registra tu ticket aquí</button>
										</div>
										</div>
									</div>	
								
								</c:if>
							</c:if>
						</div>
												
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