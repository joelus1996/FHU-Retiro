<%@ include file="../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>

	<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

	

    <meta charset="UTF-8">
    <meta name="description" content="La Tinka - Iversionistas">
    <meta name="viewport" content="width=1024">
    <link media="screen" rel="stylesheet" type="text/css" href="../../p/layer-view-style/common/normalize.css" />
    <link media="screen" rel="stylesheet" type="text/css" href="../../p/layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
    <link media="screen" rel="stylesheet" type="text/css" href="../../p/layer-view-style/common/jquery.alerts.css"/>
    <link media="screen" rel="stylesheet" type="text/css" href="../../p/layer-view-style/common/style.css?v=<%=Constants.common_style_css%>"/>
    <link media="screen" rel="stylesheet" type="text/css" href="../../p/layer-view-style/common/menu.css"/>
    <link media="screen" rel="stylesheet" type="text/css" href="../../p/layer-view-style/common/keyboard.css">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link rel="stylesheet" href="../../p/layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />
    
    <link href="//vjs.zencdn.net/6.4.0/video-js.css" rel="stylesheet">
    <link rel="stylesheet" href="../../p/layer-view-style/common/landing/daterangepicker.min.css?v=2">
    <link rel="stylesheet" href="../../p/layer-view-style/common/landing/common.css?v=<%=Constants.common_css%>">

    <script type="text/javascript" src="../../p/layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="../../p/layer-view-script/common/modernizr.js"></script>
    <title>Juego responsable La Tinka</title>
    <link rel="shortcut icon" href="../../p/layer-view-image/common/favicon.ico?v=4">
</head>
<body >

	<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	
    <%@ include file="../include/header.jspf" %>

   
	 <div class="main-content">
       <div class="main-page responsabilidad-social-single">
				<div>
					<h1>${title}</h1>
					<h4>${date}</h4>					
					<img src="${image}" alt="...">
					<p>${contenido}</p>
				</div>
			</div>
    </div>
		
	<div class="socialShared" style="display:none">
		<div class="single_social">
			<a href="javascript: void(0);" onclick="window.open('http://www.facebook.com/sharer.php?u='${link},'ventanacompartir', 'toolbar=0, status=0, width=650, height=450');" class="facebookSocial">
			 <i class="fa fa-facebook"></i> 
			</a>
			<a id="twitter" href="javascript: void(0);" onclick="window.open('http://twitter.com/home?status='${link},'ventanacompartir', 'toolbar=0, status=0, width=650, height=450');" class="twitterSocial">
				<i class="fa fa-twitter"></i> 
			</a>
			<a id="google" href="javascript: void(0);" onclick="window.open('https://plus.google.com/share?url='${link},'googleShare', 'toolbar=0, status=0, width=650, height=450');" class="googleSocial">
				<i class="fa fa-google-plus"></i> 
			</a>
		</div>
	</div>



		  <script type='text/javascript' src='../../p/layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='../../p/layer-view-script/common/jquery.scripts.js'></script>
    <script type="text/javascript" src="../../p/layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="../../p/layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="../../p/layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="../../p/layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="../../p/layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>	
<!-- 	<script type="text/javascript" src="layer-view-script/common/captcha.js"></script> -->
    <%@ include file="../include/footer.jspf" %>

 
    
    <script type="text/javascript" src="../../p/layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
	 <script  type="text/javascript">
	 	var $headerimg = $('header img');
	 	for (var a=0; a<$headerimg.length; a++) {
	 		var src = $headerimg.eq(a).attr('src');
	 		$headerimg.eq(a).attr('src','../'+src);
	 	}
	 	var $footerimg = $('footer img');
	 	for (var b=0; b<$footerimg.length; b++) {
	 		var src = $footerimg.eq(b).attr('src');
	 		$footerimg.eq(b).attr('src','../'+src);
	 	}

	 	var $headera = $('header a');
	 	for (var c=0; c<$headera.length; c++) {
	 		var href = $headera.eq(c).attr('href');
	 		$headera.eq(c).attr('href','../'+href);
	 	}
	 </script>

</body>
</html>