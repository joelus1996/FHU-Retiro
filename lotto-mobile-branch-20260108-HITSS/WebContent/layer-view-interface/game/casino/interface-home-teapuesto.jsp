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
	<title>Casino: Juego de apuesta más popular en Lima, Perú - La Tinka</title>
    <meta name='description' content="Casino" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/themeCasino.css?v=2">
	<link rel="stylesheet"  href="layer-view-style/game/casino/categorias.css?v=2" type="text/css" media="all">
	<link rel="stylesheet"  href="layer-view-style/game/casino/main-casino.css?v=3" type="text/css" media="all">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/bootstrap-4.5.2.min.css?v=1">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/bootstrap-multiselect.min.css">

	<script src="layer-view-script/game/casino/font-awesome.js"></script>
	
</head>

<jsp:include page="../../include/footer.jsp" />
<script type="text/javascript" src="layer-view-script/jquery.idle.js"></script>
<script src="layer-view-script/game/casino/bootstrap.min.js"></script>	
<script src="layer-view-script/game/casino/bootstrap-multiselect.min.js"></script>
<script type='text/javascript' src='layer-view-script/game/casino/lotto-casino.js?v=4'></script>
	
<script>
var juego = '<c:out value="${type}" escapeXml="false"/>';
toJuegosVirtuales(juego);
</script>

</html>