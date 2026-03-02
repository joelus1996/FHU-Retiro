<%@ include file="../../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="variables.jspf" %>
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
    <title>Avión del Hincha: Te Apuesto te lleva a las Eliminatorias del Mundial 2026.</title>
    <meta name='description' content="¡Vive la emoción del fútbol en vivo! Te Apuesto te lleva a los emocionantes partidos de las Eliminatorias del Mundial 2026 en Perú." />
    
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">   

    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <style>
    	.avionPeru-volver{
    		color:#ffffff;
			background-color: #F1650a;
			height: 107px;
			background-image: url('./layer-view-image/game/teapuesto/avionPeru/header-desktop-peru.png');
		}
    </style>
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
						<div class="avionPeru-volver">
							  <div class="row">
							  	<div id="avionPeru-retroceder" class="col-sm-2"><a href='#'><img class="img-volver" src="layer-view-image/game/copabicolor/img-flecha.png"></a></div> 
							  	
							  </div>				
						</div>
					<div class="f_linea-copacasa" ></div>	 
					 <div class="row" style="width: 950px;margin: 0px;">	
						<div class="col-sm-6" style="padding: 0px;">
						
						<div class="desc-sorteo" ><h3 style="margin-bottom: 15px;color: #f75b1e;margin-top: 15px; font-size: 14px;">¡10 GANADORES PARA VER A PERÚ EN LAS ELIMINATORIAS!
						</h3>
						</div>
						<!--<div class="desc-premio" ><h3 style="color: #f75b1e;margin-left: 30px; margin-right: -30px;font-size: 14px;">¡20 GANADORES PARA VER A PERÚ EN LAS ELIMINATORIAS!</h3></div> -->	
					
						<c:set var="nivel" value="" />
						<c:set var="imagen" value="" />
						
						<c:choose>
						  <c:when test="${totalTicket >= 0 && totalTicket <= 200}">
						    <c:set var="nivel" value="CALICHÍN" />
						    <c:set var="imagen" value="img-level-calichin-header.png?v=1" />
						  </c:when>
						  <c:when test="${totalTicket >= 201 && totalTicket <= 500}">
						    <c:set var="nivel" value="AMATEUR" />
						    <c:set var="imagen" value="img-level-amateur-header.png?v=1" />
						  </c:when>
						  <c:when test="${totalTicket >= 501 && totalTicket <= 1000}">
						    <c:set var="nivel" value="CRACK" />
						    <c:set var="imagen" value="img-level-crack-header.png?v=1" />
						  </c:when>
						  <c:when test="${totalTicket >= 1001}">
						    <c:set var="nivel" value="LEYENDA" />
						    <c:set var="imagen" value="img-level-leyenda-header.png?v=1" />
						  </c:when>
						</c:choose>
						
						<div class="posicion-nivel-img">
						  <img src="layer-view-image/game/copaentucasa/${imagen}" style="max-width: 100%; margin-left: 30px; margin-right: 30px;" alt="Avión del Hincha Eliminatorias 2026.">
						  <div class="desc-nivel-position">
						    <span class="tipo-nivel">${nivel}</span>
						    <br>
						    <span class="tipo-nivel-descripcion-superior">Tienes </span>
						    <span class="puntaje-por-nivel">${puntajeNivel}</span>
						    <br>
						    <span class="tipo-nivel-descripcion">opciones para los sorteos</span>
						    <br>
						    <span class="tipo-nivel-descripcion">de premios mayores</span>
						  </div>
						</div>
					
					<div class="desc-total-tickets">
					  <h3 style="color: #f75b1e;">TUS ${totalTicket} PUNTOS ACUMULADOS<br> SE MULTIPLICAN DE ACUERDO A TU NIVEL</h3>
					</div>

					<c:choose>
					  <c:when test="${totalTicket >= 0 && totalTicket <= 200}">
					    <img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-calichin.png?v=1" style="margin-left: 50px;" alt="Avión del Hincha Eliminatorias 2026.">
					  </c:when>
					  <c:when test="${totalTicket >= 201 && totalTicket <= 500}">
					    <img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-amateur.png?v=1" style="margin-left: 50px;" alt="Avión del Hincha Eliminatorias 2026.">
					  </c:when>
					  <c:when test="${totalTicket >= 501 && totalTicket <= 1000}">
					    <img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-crack.png?v=1" style="margin-left: 50px;" alt="Avión del Hincha Eliminatorias 2026.">
					  </c:when>
					  <c:when test="${totalTicket >= 1001}">
					    <img src="layer-view-image/game/teapuesto/avionQatar/img-taqatar-level-leyenda.png?v=1" style="margin-left: 50px;" alt="Avión del Hincha Eliminatorias 2026.">
					  </c:when>
					</c:choose>
					
					</div>
					
					<div class="col-sm-6">
						<div class="desc-sorteo" ><h3 style="font-size:14px; color: #000000;">También puedes ganar S/ 5 de saldo al instante</h3></div>
						<div class="desc-premio" ><h3 style="font-size:15px; color: #f75b1e;">SORTEO <c:out value="${SORTEO1}"/> </h3></div>												
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
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js?v=1'></script>
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