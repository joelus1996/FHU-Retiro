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
	<title>La Tinka : Inicio</title>	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name='description' content="La Tinka móvil, muestra la ubicación de puntos de venta cercanos" />
	
</head>
<body class="orange" onload="getLocation(1);">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<div class="container">

		<jsp:include page="../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-actions map-actions">
						<div class="row">
							<div class="main-action w-100 br-white">
								<a href="#" class="tablink actived" data-id="map">MAPA</a>
							</div>							
						</div>
					</div>
					<div class="map-body">
						<div class="map-view actived" id="map">
							<div id="map_canvas" class="area-map"></div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />

	<script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCcBJvjPVyljL0ErfTjP14Y6AINCap-WoU"></script>
	<script type="text/javascript" src="layer-view-script/geolocationRedDigital.js"></script>

</body>
</html>