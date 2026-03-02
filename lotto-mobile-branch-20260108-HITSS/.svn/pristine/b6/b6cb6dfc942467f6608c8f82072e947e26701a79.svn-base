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
	<title>La Tinka : Lista de jugadas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
	
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


	//function cerrar() {
	//	top.dhtmlwindow.close(top.document.getElementById("resultbox"))
	//}

	</script>
	
	
</head>
<body onload="doOnload();" class="table-iflex">


					
					

	
					
</body>
</html>