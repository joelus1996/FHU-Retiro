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
	    <title>Kinelo: Juego de apuesta más popular en Lima, Perú - La Tinka</title>
    <meta name='description' content="El Kinelo es un juego de apuestas a la medida con 10 tipos de apuestas de diferentes premios mayores. Gana cada 5 minutos y multiplica tu apuesta." />
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
				<img src="layer-view-image/game/kinelo/logo-kinelo.png" alt="">
			</div>
			<h1 class="game-desc">ELIGE TUS SORTEOS</h1>
			
			<div class="boxes-lots boxes-no-padding">
<%-- 				<c:forEach items="${kineloSaleList}" var="kineloDrawData" begin="0" end="0"> --%>
<%--                     <div class="box" id="box">${kineloDrawData.messageDraw}</div> --%>
<%--                 </c:forEach> --%>
                <c:forEach items="${kineloSaleList}" var="kineloDrawData" >
                 	<div class="box-lot">
						<div class="chk-area">
							<span>${kineloDrawData.messageDraw}</span>
							<div class="in-ck box-checkbox">
								<input type='checkbox' class="ckbx" name='consecutive' value="${kineloDrawData.numDraws}" id="consecutive_checkbox_${kineloDrawData.numDraws}"/>
								<label  for="consecutive_checkbox_${kineloDrawData.numDraws}"></label> 
							</div>
						</div>
					</div>
                </c:forEach>
                <!-- 
                <div class="label-resultado">
					<span id="resultadosdel"></span><br>
					<span id="filtro"></span>
				</div>
				
				<div id="resultados">
	
				</div>
				 -->
				<br>
<!-- 				<button type="button" class="btn btn-red" id="btn_mobile_continue" >CONTINUAR</button><br> -->
				<button type="button" class="btn btn-red float-bottom" id="btn_mobile_continue" >CONTINUAR</button>
			</div>
			
			
		</div>
	</div>
	<jsp:include page="../../include/footer.jsp" />
	<script src="layer-view-script/kinelo/jquery.min.js"></script>
	<script src="layer-view-script/kinelo/lotto-kinelo.js?v=2"></script>

</body>
</html>