<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="../include/taglibs.jspf" %>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="PRAGMA" content="NO-CACHE">
<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type='text/javascript' src='layer-view-script/common/jquery-migrate-3.1.0.min.js'></script>
<title>La Tinka | Tickets Golden</title>

<meta name="viewport" content="width=1024">
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

<style type="text/css">

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