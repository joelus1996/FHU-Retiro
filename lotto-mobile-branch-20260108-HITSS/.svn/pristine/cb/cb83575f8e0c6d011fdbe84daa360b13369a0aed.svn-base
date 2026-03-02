<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="es" style="background: #fbe601;">
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
	<title>La Tinka : Mis Movimientos</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
	<link rel="stylesheet" href="layer-view-style/client/mainGame.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>	
	
</head>
<body class="orange">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<input type="hidden" id="token" value="${token}" />
	<input type="hidden" id="operatorId" value="${operatorId}" />

	<div class="container">
		
		<jsp:include page="../include/header.jsp" />
		<div class="content-wrap">
			<div class="content">
				<section class="main-section">	
					<div class="main-page" id="game-not-allowed">
						<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24">
						  <path d="M12 2C6.48 2 2 6.48 2 12s4.48 10 10 10
						           10-4.48 10-10S17.52 2 12 2zm0 18
						           c-4.41 0-8-3.59-8-8 0-1.85.63-3.55
						           1.69-4.9L16.9 18.31C15.55 19.37
						           13.85 20 12 20zm6.31-3.1L7.1 5.69C8.45
						           4.63 10.15 4 12 4c4.41 0 8 3.59
						           8 8 0 1.85-.63 3.55-1.69 4.9z"/>
						</svg>
						<p class="error-text-bold">Acceso denegado</p>
						<p class="error-text">No tienes los permisos para visualizar esta sección.</p>
						<p class="error-text">${message}</p>
				          <a href="javascript:void(0)" id="back-button" class="error-button">
				            Volver al inicio
				          </a>
					</div>
				</section>	
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	<script type="text/javascript" src="layer-view-script/jquery.mobile-1.0.min.js"></script>
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script> 
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>
	<script>
	  document.getElementById('back-button').addEventListener('click', function () {
	    window.location.href = 'home.html';
	  });
	</script>
</body>
</html>