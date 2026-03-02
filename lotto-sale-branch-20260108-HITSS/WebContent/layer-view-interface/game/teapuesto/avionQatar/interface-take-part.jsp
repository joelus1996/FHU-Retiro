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


    <%@ include file="../../../include/header.jspf" %>
    <input type="hidden" value="${clientId}" id="clientId">
    <input type="hidden" value="${flagPromo}" id="clientId">
    
    <div class="main-content" style="top: 0px;padding-top: 0px;">
    				<div class="main-game copa-casa-participar" style="background-color: #841144;">																																							
						<div class="avionQatar-volver" style="background-color: #841144;">							  
							  <div class="row">
							  	<div id="avionQatar-retroceder" class="col-sm-2"><a href='#'><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></a></div> 
							  </div>								  							  				
						</div>																			
							<div class="f_linea-copacasa" ></div>
							<div class="copacasa-como-participar">
								<h3>¿Cómo participar?</h3>
								<h4>Las jugadas válidas de Te Apuesto para participar de esta promoción 
							serán aquellas compradas del 01 de setiembre hasta el 20 de noviembre de 2022 en nuestra página web 
							<a href="#" id="" class="TyC_Enfatizar btnEnlaceTeApuesto">www.teapuesto.pe</a>
							o en cualquiera de nuestros puntos de ventas físicos y que tengan un valor igual o mayor a S/ 10.00.		
							</div>
							
							<div class="copacasa-terminos">
								<ul>
									<li>Válido desde el jueves 01 de setiembre al domingo 20 de noviembre del 2022.</li>
									<li>Válido para todos los clientes mayores de 18 años que acepten participar de la promoción.</li>
									<li>Participan todos los tickets validos igual o mayor a S/ 10 jugados desde 
										<a href="#" id="" class="TyC_Enfatizar btnEnlaceTeApuesto">www.teapuesto.pe</a> 
										y puntos de venta, comprados durante la vigencia de la promoción.
									</li>
									<li>No participan tickets obtenidos con saldo bono, anulados o cashout.</li>
									<li>Los juegos y apuestas deportivas a distancia realizados en exceso pueden causar ludopatía.</li>
								</ul>
							</div>
							
							<div class="row">	
								<div class="col-sm-6" style="padding-right: 0px;">
									<div class="copacasa-reglas">
									<h3 style="padding-top: 6px;">SI JUEGAS DESDE WWW.TEAPUESTO.PE</h3>
										<ul>
											<li>Participas AUTOMÁTICAMENTE con tus tickets desde S/ 10</li>
											<li>Puedes revisar el avance de las oportunidades con que participas, 
												en cada sorteo de premios mayores ingresando 
												<a href="#" onclick="VerMisJugadas();" class="TyC_Enfatizar">"Ver mis jugadas"</a> 
												en la página de la promoción, una vez hayas aceptado participar.
											</li>								
										</ul>
									<h3 style="margin-top: 0px;padding-top: 15px;">SI JUEGAS EN PUNTO DE VENTA</h3>
										<ul>
											<li>Sube la foto de tu ticket registrándolo en el módulo promocional "Te Apuesto te lleva a la final en Qatar" en 
												<a href="http://www.programateapuesto.pe/" style="color: #ffffff" >www.programateapuesto.pe</a>.
											</li>
											<li>En esta página también puedes revisar el avance de tu participación y premios obtenidos.</li>
											<br>
											
										</ul>
									</div>
								</div>
								<div class="col-sm-6" style="padding-left: 0px;">
									<div class="ranking" style="margin-top: 30px;">
										<img src="layer-view-image/game/teapuesto/avionQatar/img-terminos-niveles-desktop.png" style="display: block;margin-left: 0px;margin-right: auto;padding-bottom: 15px;">								
									</div>
								</div>
							</div>
							
							<div class="copacasa-sorteos">
								<div class="premios1">
									<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa_gg.png">
									<span class="desc-premios1">PREMIOS MAYORES PARA 10 GANADORES</span>
								</div>	 
								<ul>
									<li>Son 10 ganadores de un paquete para ir a Qatar, el paquete incluye 1 pasaje Lima - Qatar - Lima, 
										con estadía en un hotel dentro de la ciudad, transportes internos y seguro de viaje.</li>
									<li><b>Sorteos:</b> 24 de octubre y 21 de noviembre del 2022.</li>
									<li>En el 1er sorteo, se elegirán 2 ganadores y 2 suplentes que permanecerán como respaldo 
										en caso uno o más de los dos ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio del PAQUETE PARA IR A QATAR.</li>
									<li>En el 2do sorteo, se elegirán 8 ganadores y 8 suplentes que permanecerán como respaldo
										 en caso uno o más de los ocho ganadores no responda al ser contactado o no cumpla con los requisitos para recibir el premio del PAQUETE PARA IR A QATAR.</li>
									<li>El premio es personal e intransferible.</li>
									<li>Cada ganador es responsable de contar con toda la documentación necesaria para el viaje y requisitos sanitarios vigentes.</li>
									<li>Participas en cada sorteo con el número de tickets acumuladas hasta el día anterior al sorteo. 
										Si juegas en la web, revísalos aquí 
										<a href="#" onclick="VerMisJugadas();" class="TyC_Enfatizar">"Ver mis jugadas"</a>. 
										Si juegas en un punto de venta físico, revísalos en la sección "Ver mis premios" de la página donde ingresaste tu tickets.
									</li>
									<li>Nos pondremos en contacto con cada uno de los ganadores al celular registrado sin perjuicio de validar sus datos y mayoría de edad con Reniec.</li>
									<li>En caso de: 
										1: No obtener respuesta de alguno de los ganadores en un plazo de 12 horas desde realizado el sorteo, 
										2: Se verifique que no cumple con la mayoría de edad, 
										3: Que haya ganado antes uno de los premios mayores de esta promoción, 
										4: Se verifique cualquier otra situación que impida otorgar uno de los premios, de acuerdo a los presentes Términos y Condiciones, así como el 
										<a href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-teapuesto.pdf" class="TyC_Enfatizar">Reglamento de Te Apuesto</a>, 
										se procederá a retirarlo de la lista de ganadores y en su lugar se le otorgará el premio al primero de los suplentes 
										según el orden en que salió sorteado. 
									</li>
									<li>Los ganadores de cada sorteo serán publicados en el Facebook de 
										<a  href="https://www.facebook.com/teapuestooficial" class="TyC_Enfatizar">TeApuestoOficial</a> e Instagram 
										<a href="https://www.instagram.com/teapuestooficial" class="TyC_Enfatizar">@teapuestooficial</a>
										dentro de las 12 horas de haber realizado el sorteo.</li>
									<li><b>Entrega de premios y comunicación:</b>
										Coordinaremos todos los detalles de la entrega del premio, 
										en un plazo de 12 días útiles una vez formalizado el contacto con el ganador vía correo electrónico. 
										A su vez el ganador se compromete a brindar las facilidades para llevar a cabo la entrega del premio y 
										utilizar su imagen para posterior difusión a través de Facebook 
										<a  href="https://www.facebook.com/teapuestooficial" class="TyC_Enfatizar">TeApuestoOficial</a> e Instagram 
										<a href="https://www.instagram.com/teapuestooficial" class="TyC_Enfatizar">@teapuestooficial</a>.  
										Además, el ganador se compromete a asistir a las oficinas de La Tinka, previa coordinación con la marca, 
										para genera un contenido audiovisual de ganadores para las redes de la marca. 
										El ganador deberá entregar los documentos requeridos para el viaje en un plazo máximo de 24 horas 
										después de solicitado por parte de La Tinka.
									</li>								
								</ul>
								<div class="premios2">		
									<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa_gg.png">
									<span class="desc-premios2">PREMIOS SECUNDARIOS PARA JUGADORES DE WEB</span>
								</div>
								<ul style="padding-bottom: 0px; ">
									<li>S/ 110,000 en bonos de S/ 10. Cada ganador se llevará S/ 10 de saldo en su billetera principal AL INSTANTE. 
										Estos se entregarán de forma aleatoria mediante el sistema 
										durante el período de vigencia de la promoción directo a la billetera de bono.
									</li>
								</ul> 
								<div class="premios3">		
									<img class="copita" src="layer-view-image/game/copabicolor/img-iconocopa_gg.png">
									<span class="desc-premios3">PREMIOS SECUNDARIOS PARA JUGADORES DE PUNTO DE VENTA</span>
								</div>
								<ul>
									<li>S/ 440,000 en bonos al instante de S/ 5, por jugadas de Te Apuesto para puntos de ventas físicos. 
										Estos serán otorgados de forma aleatoria y se visualizarán en la web 
										<a href="https://www.programateapuesto.pe/" target="_blank" class="TyC_Enfatizar">www.programateapuesto.pe</a>. 
										Los vales serán "al portador" y sólo se podrán canjear una vez. Se podrán redimir hasta el 27 de noviembre de 2022.</li>
								</ul>
								<div style="margin-bottom: 40px;" class="notaPromocion">
									<ul style="list-style-type: none;">
										<li>La promoción podrá ser suspendida o eliminada anticipadamente 
											por razones de caso fortuito o de fuerza mayor sin responsabilidad para La Tinka S.A., 
											informando oportunamente a los participantes a través de los canales de difusión que se estimen convenientes.
										</li>
									</ul>
								</div>
						<div class="f_linea-copacasa-participar"></div>
							<div class="row" style="padding-bottom: 40px;">	
								<div class="col-sm-6">
									<div class="copacasa-juegas-web">
										<c:if test="${clientId eq 0 || flagPromo == false}">  
											<span style="font-family: AmsiPro-Bold;font-size: 18px;color:#ffffff; ">¡Participa con tus tickets desde S/ 10!</span><br>
											<span style="font-family: AmsiPro-Bold;font-size: 13px;color:#f0c607; ">¿Quieres participar en la promoción?</span><br><br>
											<button type="button" id="btnAvionQatarRegistrar" onclick="return false;"class="button-avion-qatar-amarillo button-display-texto" style="width:190px; padding: 5px 5px 5px 5px;">Si quiero</button><br><br><br><br>
										</c:if>
										<c:if test="${clientId ne 0 && flagPromo == true}">  
											<span style="font-family: AmsiPro-Bold;font-size: 18px;color:#f0c607; ">¿Juega en web?</span><br>
											<span style="font-family: AmsiPro-Bold;font-size: 13px;color:#ffffff; ">Tus jugadas desde S/ 10 participan automáticamente</span><br><br>
											<button type="button"  class="btnEnlaceTeApuesto button-avion-qatar-amarillo button-display-texto" style="width:190px; padding: 5px 5px 5px 5px;">Juega aquí</button>
										</c:if>
									</div>
								</div>
								<div class="col-sm-6">
									<div class="copacasa-punto-venta">
										<span style="font-family: AmsiPro-Bold;font-size: 18px;color:#ffffff;">¿Juega en punto de venta?</span><br><br><br>				
										<button type="button" id="btn_desktop_registra_ticket" onclick="return false;"class="button-avion-qatar-blanco button-display-texto" style="width:190px; padding: 5px 5px 5px 5px;">Registra tu ticket aquí</button>
									</div>
								</div>
							</div>
							
						</div>
												
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