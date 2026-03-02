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


<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>La Tinka : Ubicación Puntos de la Suerte</title>	
<link rel="stylesheet" href="layer-view-style/client/theme.css" />  
<link rel="stylesheet" href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<script type="text/javascript" src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="layer-view-script/geolocation.js"></script>
<script type="text/javascript" src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='La Tinka móvil, muestra la ubicación de puntos de la suerte cercanos' />
<style type="text/css">
.section-map {
	font-size:19px;
	font-family:arial,helvetica,sans-serif;
	font-weight:normal;
	width:290px;
	height:430px;
	background:white;
	margin:20px 0 20px 0;
	padding:5px;
	border:1px solid #000;
}
#tabs ul {
	width:275px;
	height:20px;
	list-style: none;
	margin:0;
	padding: 4px 0 0 0;
	background-color: #d0d0d0;
}
.section-map .area-map {
	width:280px;
	height:400px;
	margin:0;
	padding:0;
}
.section-map .area-list {
	width:280px;
	height:375px;
	font-family:Arial, Helvetica, sans-serif;
	font-size:9px;
	overflow:auto;
	text-align:left;
	margin:0;
	padding:0;
}
.section-map .area-tab {
	font-size:13px;
	height:18px;
	width:50px;
	float:left;
	border-top:1px solid #000;
	border-left:1px solid #000;
	border-right:1px solid #000;
	background-color: #FFF;
	margin:0 0 0 5px;
	padding:2px 0 0 0;
	cursor: pointer;
	color:#000;
	text-align: center;
}
.section-map .unselected {
	background-color:#e9e9e9;
	color:#535353;
	border:0;
}
.section-map .area-head {
	width:280px;
	height:25px;
	background:url('layer-view-image/client/head.gif') no-repeat;
	margin:0;
	padding:0;
}
</style>
	
</head>
<body onload="getLocation(2)">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
   <jsp:include page="../include/header.jsp" />
	<div align="center" >
		<br/>
	   	<ul data-role="listview" data-inset="true" data-theme="e" style="margin-right: 42px; margin-left: 42px;">
			<li data-role="list-divider">						
				<div align="center">PUNTOS DE LA SUERTE</div>				
			</li>
		</ul>
	    <ul style="margin-right: 5px; margin-left: 5px;">
			<li>
				<div class="section-map">
					<div id="tabs" style="width:310px;">
						<ul>
							<li id="tab-1" class="area-tab">Mapa</li>
							<li id="tab-2" class="area-tab unselected">Lista</li>
						</ul>
						<div id="tabs-1" style="margin:5px; padding:0;">
							<div id="map_canvas" class="area-map"></div>
						</div>
						<div id="tabs-2" style="display: none; margin:5px; padding:0;">
							<div class="area-head"></div>
							<div id="listPoint" class="area-list" ></div>
						</div>
					</div>
				</div>
			</li>
		</ul>
	</div>
	<jsp:include page="../include/footer.jsp" />
</body>
</html>