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
	<link rel="stylesheet" href="layer-view-style/client/mainBalance.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>	
	
</head>
<body>

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
				<section class="main-section" style="background-color: #fbe601;">	
					<div class="main-page" id="movements-title-total-main-page">
						<div class="main-wallet">
							<div class="top-wallet-jg">
								<div class="jg-wallet">
									<h2>MOVIMIENTOS DE SALDO</h2>
								</div>
							</div>
						</div>
					</div>
				</section>	
				<iframe id="iframeContent" src="client_balance_information_api.html?authToken=${token}" scrolling="no" frameborder="0" class="movements-iframe"> 
				</iframe>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	<script type="text/javascript" src="layer-view-script/jquery.mobile-1.0.min.js"></script>
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script> 
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>
	<script>
		function setIframeHeight() {
			  requestAnimationFrame(() => {
			    const iframe = document.getElementById('iframeContent');
			    if (!iframe) return;
	
			    const realHeight = document.documentElement.clientHeight - 118;
			    iframe.style.height = realHeight + 'px';
			  });
			}
		
		  window.addEventListener('resize', setIframeHeight);
		  window.addEventListener('orientationchange', setIframeHeight);
		  window.addEventListener('pageshow', setIframeHeight);
		  document.addEventListener('DOMContentLoaded', setIframeHeight);
	</script>
</body>
</html>