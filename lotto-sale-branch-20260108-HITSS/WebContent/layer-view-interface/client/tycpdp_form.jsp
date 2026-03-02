<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="pe.com.intralot.loto.util.Constants"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="es">
<head>
	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
	<script src="https://web-button.metamap.com/button.js"></script>
	<!-- End Google Tag Manager -->
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<title>Validación de Documentos de terminos y condiciones y Política de datos personales</title>	
	<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/mainDocsPendings.css?v=2">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
	<meta name="_csrf" content="${_csrf.token}"/>
	<meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
<body class="no-scroll">
<!-- Google Tag Manager (noscript) -->

<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
<section class="tyc-pdp">
    <div class="ioverlay" id="popupTYCPDPPending" style="display: none;">
		<div class="modal is-iframe align-modal-v-center">
			<div>
				<div class="modal__close iclose align-x-button-v-center"><span class="icon-cerrar"></span></div>
				<div class="tyc-pdp in-iframe">
					<div class="ipremio__body">
						<ul class="accordion is-main">
							<li class="accordion__item opened is-modal">						
								<h2 class="accordion__title" id="blockTitlePendingDocs">
								</h2>
								<div id="bodyPrincipal" class="accordion__body content_loading">
									<div class="inner">
										<div id="blockDescriptionPendingDocs"></div>
										<br>
										<div id="blockTyc" class="record"></div>						
										<div id="blockPdp" class="record"></div>
										<br>
										<br>
										<div class="popupDataButton" id="blockButtonTycPdp" style="text-align: center">
										</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js?v=2"></script>
<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
<script type="text/javascript" src="layer-view-script/client/mainPendingDocs.js?v=1"></script>
<script type="text/javascript" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=10"></script>

<script type="text/javascript">		
	$(document).ready(function() {
		$('#popupTYCPDPPending').fadeIn(250);
	});
</script>
	
</body>
</html>
