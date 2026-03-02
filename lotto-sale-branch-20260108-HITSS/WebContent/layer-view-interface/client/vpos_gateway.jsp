<%@ include file="../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Canal Internet de La Tinka provee juegos de lotería y entretenimiento al mercado peruano, haciendo realidad sus sue&ntilde;os, sobre la base de juegos de lotería y de entretenimiento con seguridad, confianza y transparencia." />
<title>La Tinka de Perú | Lotería Virtual - Zona Segura</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<link href="layer-view-style/common/normalize.css" rel="stylesheet" type="text/css" />
<link href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>" rel="stylesheet" type="text/css" />
<link href="layer-view-style/common/carousel.css" rel="stylesheet" type="text/css" />
<meta name="viewport" content="width=1024">
<link href="layer-view-style/common/menu.css" rel="stylesheet" type="text/css" />
<script src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>" type="text/javascript"></script>
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.carouFredSel.js"></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
<script type="text/javascript">
function enviarvpos(){
		//var form = document.forms[1];
		document.getElementById("loadvpos").style.display = "none";
		document.getElementById("imgloadvpos").style.display = "";
		var divModal = document.getElementById("modalvpos");
		document.frmPaymentProcess.target = "iframevpos";
		document.frmPaymentProcess.submit();
		divModal.style.visibility = "visible";
}
function cerrarvpos() {
	$(location).attr('href','cancela_vpos.html');
}
function HandleOnClose() {
	// toLogOut();
}
</script>
</head>
<body onbeforeunload="HandleOnClose();">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

    <c:set var="vPaymentURI"><%=ConnectionFactory.operationProperty("vpaymentURI",Constants.contextCardWeb)%></c:set>
	<form name="frmPaymentProcess" method="post" action="<c:out value='${vPaymentURI}'/>">
        <input type="hidden" name="IDACQUIRER" value="<c:out value='${idAcquirer}'/>" />
		<input type="hidden" name="IDCOMMERCE" value="<c:out value='${idCommerce}'/>" />
		<input type="hidden" name="XMLREQ" value="<c:out value='${xmlReq}'/>" />
		<input type="hidden" name="DIGITALSIGN" value="<c:out value='${digitalSign}'/>" />
		<input type="hidden" name="SESSIONKEY" value="<c:out value='${sessionKey}'/>" />
	</form>
	<div id="overlayvpos"></div>
	<div id="loadvpos">
        <div style="margin:150px 40px 0 40px; text-align: justify;">
            <div style="text-align: center; text-decoration: underline; font-weight: bold;">AVISO</div>
            <br/><br/>
            Estás ingresando a la plataforma de pago de BizPay Secure Payment Gateway.<br/>
            El procesamiento de tu transacción estará a cargo de BizPay Secure Payment Gateway. 
            La Tinka S.A., no se hace responsable de cualquier falla o deficiencia que pudiera surgir en esta plataforma dado que se encuentran fuera de la esfera de control de La Tinka.
            <br/><br/><br/><br/><br/>
        </div>
        <div style="text-align: center;">
            <a href="#" onclick="enviarvpos();" style="margin: 0 0 0 200px;">Aceptar</a>
            <a href="#" onclick="cerrarvpos();" style="margin: 0 0 0 40px;">Cancelar</a>
        </div>
    </div>
    <div id="imgloadvpos" style="display: none;" title="Cargando VPOS"><div style="margin:150px 40px 0 40px;">Por favor, no toque su navegador de Internet hasta que finalice la transacci&oacute;n y reciba un mensaje de respuesta, el proceso de Autorizaci&oacute;n del Pago puede tomar hasta un minuto.</div></div>
    <div id="modalvpos"><iframe id="iframevpos" name="iframevpos" scrolling="no" frameborder="0"></iframe></div>

</body>
</html>