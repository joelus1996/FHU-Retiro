<%@ include file="/layer-view-interface/include/taglib.jsp"%>
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
    <title>Juegos de loterías y apuestas deportivas en Perú - La Tinka </title>
    <meta name='description' content="La Tinka es la compañía líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto." />	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	
</head>
<body style="background-color: #D7E2E4;">
<!-- <body class="main-copaentucasa"> -->
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
			
	<input type="hidden" id="clientId" value='${clientId}'>
	
	<div class="container">	
			<jsp:include page="../../../include/header.jsp" />		
		<div class="content-wrap">		
			<div class="content">
				<img src="layer-view-image/game/teapuesto/avionQatar/Banner-header-mobile_taqatar.png" style="display: block;margin-left: auto;margin-right: auto;width: 100%;">			
				<section class="main-section">										
					<div class="main-game avion-qatar">
						<h2 >Tus jugadas desde S/ 10 realizadas en la WEB </h2>
						<h3 style="font-size: 18px;">¡Participan automáticamente!</h3>							
					
					<div class="copa-opciones">
						  		
						<button style="margin-top:1rem;width:185px;" type="button" id="btnAvionQatarResultados" onclick="return false;"class="button-avion-qatar-naranja">Ver mis jugadas</button>
							 
						<button style="margin-top:1rem;width:185px;" type="button" id="btnAvionQatarComoParticipar" onclick="return false;"class="button-avion-qatar-blanco">Términos y condiciones</button>
					
					</div>
					
					<div class="copa-descripcion">
						<h3>Del jueves 01 de setiembre al domingo 20 de noviembre del 2022</h3>
					</div>
					</div>
				</section>
			</div>
		</div>	
	</div>
	
	<jsp:include page="../../../include/footer.jsp" />
	
</body>	