<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/taglibs.jspf" %>
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="PRAGMA" content="NO-CACHE">
<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type='text/javascript' src='layer-view-script/common/jquery-migrate-3.1.0.min.js'></script>
<title>La Tinka | Impresión tickets</title>
<meta name="viewport" content="width=1024">
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<style type="text/css">
/*.form-button:link, .form-button:visited, .form-button:hover, .form-button:active {
	float: left;
	width: 105px;
	height: 22px;
	padding: 7px 0 0 0;
	margin: 8px 10px 0 0;
	border: 0;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	color: #3c3c3c;
	text-decoration: none;
	text-align: center;
	background: url(img/home/bg-button-agregar-carrito.gif) no-repeat center;
}*/
.option-item {
	float: left;
	/*width: auto;*/
	/*display: inline;*/
	padding: 4px 0 0 5px;
	margin: 0;
	border: 0;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: bold;
	/*text-align: left;*/
	color: #808080;
	line-height: 12px;
}
.option-box {
	float: left;
	/*width: 16px;*/
	/*height: 16px;*/
	/*padding: 0;*/
	margin: 0 0 5px 145px;
	/*border: 0;*/
	/*color: #0681bb;*/
	/*background-color: #0681bb;*/
	/*border-color: #0681bb;*/
	
}
/*.grid-row {
	float: left;
	padding: 1px 1px 1px 1px;
	width: 190px;
	border: 0;
	margin: 0;
	background: #FFFFFF;
}
.grid-cell-item {
	width: 190px;
	height: 20px;
	padding: 0;
	border: 0;
	margin: 0;
	background: #FEDB7E;
}*/
.grid-block div a.form-button_print {
	float:left;
	width:80px;
	height:22px;
	text-decoration:none;
	background: url(layer-view-image/common/btn-imprimir-off.png) top left no-repeat;
	margin: 0 0 0 260px;/*0 0 0 261px;*/
	padding: 0;
	border: 0;
}
.grid-block div a.form-button_print:hover {
	background: url(layer-view-image/common/btn-imprimir-over.png) top left no-repeat;
}
.grid-block div a.form-button_send {
	float:left;
	width:118px;
	height:22px;
	text-decoration:none;
	background: url(layer-view-image/common/btn-enviar-a-correo-off.png) top left no-repeat;
	margin: 0 0 0 19px;
	padding: 0;
	border: 0;
}
.grid-block div a.form-button_send:hover {
	background: url(layer-view-image/common/btn-enviar-a-correo-over.png) top left no-repeat;
}
.content-box {
	display: block;
	width: 100%;
	height: 100%;
	padding: 0;
	margin: 0;
	border: 0;
	/*background: #FFBA00;*/
}
.content-box-data {
	display: block;
	padding: 0;/*5px;*/
	margin: 0;
	border: 0;
	/*background: #FFBA00;*/
}
.grid-block {
	float: left;
	width: 740px;/*729px;*/
	/*width: 708px;*/
	/*height: 66px;*/
	padding: 14px 0 0 0;/*0 0 5px 5px;*/
	margin: 0;
	border: 0;
	/*background: #FFBA00;*/
	font-family: Arial, Helvetica, sans-serif;
	font-size: 11px;
	font-weight: normal;
	text-align: center;
}
/*.cerrar a {
    background: url("layer-view-image/common/btn-cerrar-off.png") no-repeat scroll left top #F99631;
    float: left;
    height: 20px;
    text-decoration: none;
    width: 58px;
    border-radius : 4px;
}
.cerrar a:hover {
    background: url("layer-view-image/common/btn-cerrar-over.png") no-repeat scroll left top #F9A144;
}*/
</style>
<link rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"/>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript">
	<%
        String htmlTextS = "";
        if(request.getAttribute("htmlText") != null) htmlTextS = (String)request.getAttribute("htmlText");
        session.removeAttribute("htmlTextS");
        session.setAttribute("htmlTextS",htmlTextS);
	%>
	function doClose() {
		window.close()
	}

	function doOnload() {
		try {
			var htmlText = "<%=htmlTextS%>";
			var doc = window.document;//document.all?document.coupon.body:window.frames['coupon'].document.body;
			doc.body.innerHTML = htmlText;
		} catch(e) {
			alert("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos. Error: "+e)
		}
	}

	function cerrar() {
		top.dhtmlwindow.close(top.document.getElementById("resultbox"))
    }
</script>

</head>
<body onload="doOnload();">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


<%@ include file="../include/message.jspf"%>

</body>
</html>