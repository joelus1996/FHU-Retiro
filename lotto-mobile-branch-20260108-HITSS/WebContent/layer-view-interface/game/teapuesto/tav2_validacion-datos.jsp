<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<!DOCTYPE html>
<html>
<head>

	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta http-equiv="Cache-Control" content="max-age=0" />
  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
  <meta http-equiv="Expires" content="0" />
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
  <meta http-equiv="Pragma" content="no-cache" />
  <meta charset="utf-8">
  <title></title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="layer-view-style/common/tav2-header.css?v=<%=Constantes.tav2_header_css%>" type="text/css" />
  <style>
  	.popup.popup-standard {
	    height: 446px;
	    width: 338px;
	    display: table;
	    top: 50%;
	    transform: translateY(-50%);
	    background: none;
	    padding: 0px;
	}
	.popup-img-button{
	    display: inline-block;
	    position: relative;
	    height: 446px;
	}
	.home-popup {
	    width: 100%;
	}
	.footer-button {
	    position: absolute;
	    left: 0;
	    right: 0;
	    text-align: center;
	    bottom: 1.4rem;
	}
	.footer-button.accion-1 {
	    bottom: 3rem;
	} 
	.footer-button.accion-2{
		bottom: 1rem;
	} 
	.footer-button button {
	    border-radius: 17px;
	    border: medium none;
	}
  </style>
</head>
<body style="background-color: white !important;" >
<input type="hidden" value="${clientId}" id="clientId">
  <div class="nvs-header-row nvs-header-0">
  	<div id="logo"><a href="<%= Constantes.tav2GameProviderCloseUrl%>" id="logo-href"></a></div>
		<div id="btn">
			<a href="#" id="register-btn2" class="register-btn2">
			</a>
			<input type="hidden" id="redirect558cancel" value="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" />
			<a href="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" id="register-btn" class="register-btn">
			</a>
		</div>
  </div>
  <div class="wrap-body">
<input type="hidden" value="<%= Constantes.flagPromoHincha %>" id="flagPromoHincha">
    <div class="text-center top-login">
      <div>
		<h3 style = "text-align:center;" class="title-recuperar-password">Validación de datos</h3>
		</div>  
		<div style = "text-align:center;" class="dsc-recuperar-password">
			<p>Ha ocurrido un inconveniente con su sesión, póngase en contacto con atención al cliente 5135502.</p>
			</div>
		<br>
		<button id="btn-aceptar-home" class="btn btn-recuperar-password" type="submit" id="btn-send-password">ACEPTAR</button><br/> 
    </div>
	      
	   
		
		<footer id="footer">
		<!-- Popup Avion Peru -->
		<!-- Se comenta solicitado por NNDD 23/05/2024 -->
		<!-- 	  -->
			<div id="popup-avionPeru" class="overlay">
				<div id = "popup-scrool-copa" class="popup popup-sm-avionPeru" style="text-align: center;">
				<a class="close-avionPeru">&times;</a>
					<div class="wrap-modal">
						<img class="home-popup" src="layer-view-image/game/teapuesto/avionPeru/popup-peru.png" alt="Avión del Hincha Eliminatorias 2026">
						<button style="background-color: #e30613; top: -62px;position: relative;background-color: #000000;" type="button" id="btnHomeAvionPeru" onclick="return false;"class="button-avion-qatar-naranja"  >Infórmate aquí</button>																				
					</div>
				</div>
			</div>
			
			<div id="popup-avionPeru-nivel" class="overlay">
				<div id = "popup-scrool-copa2" class="popup popup-sm-avionPeru">
					<a class="close-avionPeru">&times;</a>
						<div class="wrap-modal">
							<img src="layer-view-image/game/teapuesto/avionPeru/popup-categorias-peru.png" alt="Te Apuesto te lleva a los partidos de la Copa América 2024" style="display: block;"> 
							<div id= "nivel-avionPeru" style="background-color: #d7e2e4;">
							</div>																		
					</div>
				</div>
			</div>
			<!-- Popup Avion Peru -->
			<div id="logo-tinka"></div>
		</footer>
	
  </div>
	
			
</body>


<%-- /*chatbot*/ --%>	
<!-- <script type="application/javascript" charset="UTF-8" src="https://cdn.agentbot.net/core/56512f807294eae4d4093733fc35cd13.js"></script> -->	
<%-- /*fin chatbot*/ --%>
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/jquery-migrate-3.1.0.min.js"></script>
<script type="text/javascript" src="layer-view-script/game/tinka/tinka-popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/tav2-header.js?v=15"></script>
<script type="text/javascript" src="layer-view-script/common/chatbot.js"></script>
<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
<script type="text/javascript" src="layer-view-script/game/aviondelhincha/hincha-popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/common/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="layer-view-script/client/bannerCookies.js?v=14"></script>
<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=11"></script>
<script>
document.getElementById("btn-aceptar-home").addEventListener("click", function(event) {
    event.preventDefault();
    // Redirigir al usuario al home de la página
    window.location.href = "home.html";
});

</script>

<script type="text/javascript" src="layer-view-script/game/teapuesto/avionPeru/avionPeru.js?v=4"  charset="UTF-8"></script>

</html>