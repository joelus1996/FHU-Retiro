<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<!DOCTYPE html>
<html lang="es">
<head>
<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
<script>
window.onload = function () {
	if(document.getElementById("clientId").value){
		dataLayer.splice(0,1,{
			'loginStatus': 'Sesión iniciada',
			'clientid': getClientID(),
			'userID': document.getElementById("clientId").value,
			});
	}
}
</script>
   	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	<script type="application/ld+json">
	{
  		"@context": "https://schema.org/",
  		"@type": "BreadcrumbList",
  		"itemListElement": [{
    		"@type": "ListItem",
    		"position": 1,
    		"name": "La Tinka",
    		"item": "https://m.latinka.com.pe/" 
  		},{
    		"@type": "ListItem",
    		"position": 2,
    		"name": "Jugar Kinelo",
    		"item": "https://m.latinka.com.pe/game_kinelo_show_home.html" 
  		}]
	}
	</script>
	<meta property="og:title" content="Kinelo: Juega y Gana cada 5 minutos">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://m.latinka.com.pe/game_raspaya_show_home.html">
	<meta property="og:description" content="¿Qué es Kinelo? Es un juego de apuestas a la medida con 10 tipos de apuestas de diferentes premios mayores. Gana cada 5 minutos y multiplica tu apuesta.">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-kinelo.png">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	    <title>Kinelo: Juega y Gana cada 5 minutos</title>
    <meta name='description' content="¿Qué es Kinelo? Es un juego de apuestas a la medida con 10 tipos de apuestas de diferentes premios mayores. Gana cada 5 minutos y multiplica tu apuesta." />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

	<link rel="stylesheet" href="layer-view-style/game/kinelo/estilos.css" type="text/css" />	
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	
	
	<link rel="shortcut icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png" type="image/x-icon">
    <link rel="apple-touch-icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
    <link rel="icon" type="image/png" sizes="192x192" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
</head>
<body class="main-kinelo">    
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
  
	<div class="main-section black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		<jsp:include page="../../include/header.jsp" />
		<input type="hidden" value="Loterías" id="TipoZona">
		<input type="hidden" value="Kinelo" id="Zona">
		<input type="hidden" value="" id="SubZona">
		
		<div class="black-menu content-wrap" >
			<div class="content" style="padding-top: 0px;">
				<div id="container-animation" style="padding-top: 0px;">
					<iframe src="https://www.latinka.com.pe/kinelo/mobile/" scrolling="no" frameborder="0" width="100%" height="600" allowtransparency="true" style="padding:0;margin:0;"></iframe>
				</div>
<!-- 				<p align="center"><button type="button" style="width: 85%;" class="btn btn-red" id="btn_mobile_jugar_ahora_kinelo_a">JUEGA AHORA</button></p> -->
				<div class="container">
					<h1 class="titular" id="lastDraw">última jugada ganadora</h1>
					<h2 class="info_res" id="draw"></h2>
					<div class="box_five" style="text-align:center;">
						<div class="numbers">
							<ul id="bolos" class="list-ball-large"></ul>
						</div>
						<div class="fix"></div>
						<a class="btns" style="margin-top:30px;" id="btn_mobile_last_results">Resultados anteriores</a>
						<a href="libro-reclamaciones.html" target="_self">
							<img src="layer-view-image/client/book/linkbook.png" alt="tinka" style="height: 49px;width: 84px;margin-top:40px;">
						</a>	
						</div>
						
				</div>
				
				<div style="margin-top: 50px;"></div>
				<button type="button" class="btn btn-red float-bottom" id="btn_mobile_jugar_ahora_kinelo_a">JUEGA AHORA</button>
			</div>
		</div>
	</div>
	<jsp:include page="../../include/footer.jsp" />
	<!-- <script src="layer-view-script/kinelo/jquery.min.js"></script> -->
	<script src="layer-view-script/kinelo/lotto-kinelo.js?v=2"></script>
	<script type="text/javascript">
		
		$("#btn_mobile_jugar_ahora_kinelo_a").on("click",function(){
			datalayerBtnJuegatinka(this,'Button','Juega Ahora');
		});
	
	</script>
	
</body>
</html>