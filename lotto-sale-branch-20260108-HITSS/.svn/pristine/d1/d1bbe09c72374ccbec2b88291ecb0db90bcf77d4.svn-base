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
						<div class="copacasa-volver" style="background-color: #007C37;">							  
							  <div class="row">
							  	<div id="copacasa-retroceder" class="col-sm-2"><a href='#'><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></a></div> 
							  </div>								  							  				
						</div>																			
							<div class="f_linea-copacasa" ></div>
							<div class="copacasa-como-participar">
								<h3>¿Cómo participar?</h3>
								<h4>Si juegas desde <a href="http://www.ganagol.com.pe/"  class="TyC_Enfatizar">www.ganagol.com.pe</a> todos tus tickets desde S/ 3 participan AUTOMÁTICAMENTE</h4>							
							</div>
							
							<div class="copacasa-terminos">
								<ul>
									<li>Válido para todos los clientes que acepten participar de la promoción.</li>
									<li>No participan tickets obtenidos con saldo bono.</li>
									<li>Válida desde el martes 21 de junio al domingo 31 de julio del 2022.</li>
									<li>Participan todos los tickets validos igual o mayor a S/ 3, jugados desde <a href="http://www.ganagol.com.pe/" class="TyC_Enfatizar">www.ganagol.com.pe</a> y puntos de venta, comprados durante la vigencia de la promoción.</li>
								</ul>
							</div>
							
							<div class="row">	
								<div class="col-sm-6" style="padding-right: 0px;">
									<div class="copacasa-reglas">
									<h3 >SI JUEGAS DESDE WWW.GANAGOL.COM.PE</h3>
										<ul>
											<li>Participas AUTOMÁTICAMENTE con tus tickets desde S/ 3</li>
											<li>Puedes revisar el avance de las oportunidades con que participas, en cada sorteo de premios mayores y secundarios, ingresando <a href="#" onclick="ValidarCopacasa();" class="TyC_Enfatizar">"Ver mis jugadas"</a> en la página de la promoción, una vez hayas aceptado participar.</li>								
										</ul>
									<h3 style="margin-top: 0px;padding-top: 15px;">SI JUEGAS EN PUNTO DE VENTA</h3>
										<ul>
											<li>Sube la foto de tu ticket registrándolo en el módulo promocional <a href="http://www.programateapuesto.pe/" style="color: #ffffff" >www.programateapuesto.pe</a>.</li>
											<li>Puedes revisar el avance de tu participación y premios obtenidos en la misma página de la promoción.</li>
											<br>
											
										</ul>
									</div>
								</div>
								<div class="col-sm-6" style="padding-left: 0px;">
									<div class="ranking" style="margin-top: 30px;">
										<img src="layer-view-image/game/copabicolor/img-terminos-niveles-desktop.png" style="    display: block;margin-left: 0px;margin-right: auto;padding-bottom: 15px;">								
									</div>
								</div>
							</div>
							
							<div class="copacasa-sorteos">
								<div class="premios1">
									<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa_gg.png">
									<span class="desc-premios1">PREMIOS MAYORES PARA 4 GANADORES</span>
								</div>	 
									<ul>
										<li>Son S/ 25,000 para cada ganador.</li>
										<li><b>Sorteos:</b> 18 de julio y 01 de agosto del 2022. En cada sorteo se eligirán 2 ganadores y 2 suplentes que parmanecerán como respaldo en caso uno o más de ganadores no responda al ser contactado o no cumple con los requisitos para recibir el premio.</li>
										<li>Participas en cada sorteo con el número de jugadas acumuladas hasta el día anterior al sorteo. Si juegas en la web, revísalos aquí <a href="#" onclick="ValidarCopacasa();" class="TyC_Enfatizar">"Ver mis jugadas"</a>. Si juegas en un punto de venta físico, revísalos en la sección "Ver mis premios" de la pagina donde ingresaste tus tickets.</li>																				
										<li>Nos pondremos en contacto con cada uno de los ganadores al celular registrado y se validarán en RENIEC la veracidad de sus datos y mayoría de edad.</li>
										<li>En caso de: 1: No obtener respuesta de alguno de los ganadores en un plazo de 24 horas desde realizado el sorteo, 2: Se verifique que no cumple con la mayoría de edad, 3: Que haya ganado antes uno de los premios mayores de esta promoción, y/o 4: Se verifique cualquier otra situación que impida otorgar uno de los premios, de acuerdo con los presentes Términos y Condiciones, así como el <a href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-ganagol.pdf" class="TyC_Enfatizar">Reglamento de Ganagol</a>, se procederá a retirarlo de la lista de ganadores y en su lugar se le otorgará el premio al primero de los suplentes según el orden en que salió sorteado. </li>
										<li>Los ganadores de cada sorteo serán publicados en el Facebook de <a href="https://www.facebook.com/GanagolOficial" class="TyC_Enfatizar">GanagolOficial</a> dentro de las 24 horas de haber realizado el sorteo.</li>
										<li><b>Entrega de premios y comunicación:</b> Coordinaremos todos los detalles de la entrega del premio a ser entregado en un plazo de 60 días útiles una vez formalizado el contacto con el ganador vía correo electrónico. A su vez como ganador te comprometes a brindar todos los accesos adecuados para poder hacer la entrega del premio y a firmar un acuerdo para poder comunicar el acontecimiento a través de Facebook.</li>								
									</ul>
								<div class="premios2">		
									<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa_gg.png">
									<span class="desc-premios2">PREMIOS SECUNDARIOS PARA JUGADORES DE WEB</span>
								</div>
								<p style="font-family: AmsiPro-Bold;font-size:12px;line-height: 1.5em;margin: 0px 40px;">S/ 6,000 en saldos para 1,500 ganadores Cada ganador se llevará un bono de S/ 4 AL INSTANTE para jugar Ganagol. Y se entregarán durante el período de vigencia de la promoción.</p><br>

								<div class="premios3">		
									<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa_gg.png">
									<span class="desc-premios3">PREMIOS SECUNDARIOS PARA JUGADORES DE PUNTO DE VENTA</span>
								</div>
								<p style="font-family: AmsiPro-Bold;font-size:12px;line-height: 1.5em;margin: 0px 40px;">
								12,000 vales al instante de S/ 2 por jugadas de Ganagol para puntos de ventas físicos. Los vales serán “al portador” y sólo se podrán canjear una vez. Se podrán redimir hasta el 14 de agosto de 2022.</p>
								<br><br>
<%--						<div class="f_linea-copacasa-participar"></div>
 							<div class="row" style="padding-bottom: 40px;">	
								<div class="col-sm-6">
									<div class="copacasa-juegas-web">
										<c:if test="${clientId eq 0 || flagPromo == false}">  
											<span style="font-family: AmsiPro-Bold;font-size: 18px;color:#f0c607; ">¡Participa con tus tickets desde S/ 3!</span><br>
											<span style="font-family: AmsiPro-Bold;font-size: 13px;color:#ffffff; ">¿Quieres participar en la promoción?</span><br><br>
											<button type="button" id="btn_desktop_promo_bicolor" onclick="return false;"class="button-copa2 button-display-texto" style="width:190px;">Si quiero</button><br><br><br><br>
										</c:if>
										<c:if test="${clientId ne 0 && flagPromo == true}">  
											<span style="font-family: AmsiPro-Bold;font-size: 18px;color:#ffffff; ">¿Juega en web?</span><br>
											<span style="font-family: AmsiPro-Bold;font-size: 13px;color:#f0c607; ">Tus jugadas desde S/ 3 participan automáticamente</span><br><br>
											<button type="button"  class="btnEnlaceGanagol button-copa2 button-display-texto" style="width:190px;">Juega aquí</button>
										</c:if>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="copacasa-punto-venta">
										<span style="font-family: AmsiPro-Bold;font-size: 18px;color:#ffffff;">¿Juega en punto de venta?</span><br><br><br>				
										<button type="button" id="btn_desktop_registra_ticket" onclick="return false;"class="button-copa1 button-display-texto" style="width:190px;">Registra tu ticket aquí</button>
									</div>
								</div>
							</div> --%>
							
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