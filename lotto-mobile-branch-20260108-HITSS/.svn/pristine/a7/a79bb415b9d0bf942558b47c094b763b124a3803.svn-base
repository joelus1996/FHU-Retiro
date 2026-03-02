<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
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
	    <title>Resultados de Kinelo: Últimos resultados de Hoy</title>
    <meta name='description' content="Descubre los últimos resultados de Kinelo de forma online. ¡Entra ahora y descubre los últimos ganadores!" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

	<link rel="stylesheet" href="layer-view-style/game/kinelo/estilos.css" type="text/css" />	
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	
</head>
<body class="main-kinelo">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
 
	<div class="main-section black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		<jsp:include page="../../include/header.jsp" />
	</div>
	<div class="black-menu content-wrap" >
		<div class="content" style="padding-top: 0px;">
			<div class="logo-brand">
				<a href="game_kinelo_show_home_direct.html">
				<img src="layer-view-image/game/kinelo/logo-kinelo.png" alt="">
				</a>
			</div>
			<h1 class="titular">RESULTADOS ANTERIORES</h1>
			<div class="select-bx">
			    <input class="select-itm fecha select-itm-fecha" type="date" id="fecha" name="fecha" onchange="getLastResultsByFecha()">
				<select class="select-itm hora" id="hora" onchange="getLastResultsByFecha()" style="padding-left:40px">
				  <option value="0">HORA</option>
				  <option value="00:00">00:00</option>
				  <option value="01:00">01:00</option>
				  <option value="06:00">06:00</option>
				  <option value="07:00">07:00</option>
				  <option value="08:00">08:00</option>
				  <option value="09:00">09:00</option>
				  <option value="10:00">10:00</option>
				  <option value="11:00">11:00</option>
				  <option value="12:00">12:00</option>
				  <option value="13:00">13:00</option>
				  <option value="14:00">14:00</option>
				  <option value="15:00">15:00</option>
				  <option value="16:00">16:00</option>
				  <option value="17:00">17:00</option>
				  <option value="18:00">18:00</option>
				  <option value="19:00">19:00</option>
				  <option value="20:00">20:00</option>
				  <option value="21:00">21:00</option>
				  <option value="22:00">22:00</option>
				  <option value="23:00">23:00</option>
				</select>
				<div class="fix"></div>
			</div>
			<div class="label-resultado">
				<span id="resultadosdel"></span><br>
				<span id="filtro"></span>
			</div>
			
			<div id="resultados" style="margin-bottom:75px">

			</div>
			
			<!-- <div style="margin-top: 75px;"></div> -->
<!-- 			<button type="button" class="btn btn-red" id="btn_mobile_return_last_results" style="margin-bottom:75px">VOLVER</button> -->
			
			<button type="button" class="btn btn-red float-bottom" id="btn_mobile_return_last_results" >VOLVER</button>
		</div>
	</div>
	<jsp:include page="../../include/footer.jsp" />
	<script src="layer-view-script/kinelo/jquery.min.js"></script>
	<script src="layer-view-script/kinelo/lotto-kinelo.js?v=2"></script>

</body>
</html>