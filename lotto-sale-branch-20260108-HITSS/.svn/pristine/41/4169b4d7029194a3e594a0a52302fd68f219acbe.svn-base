<%--
<p> NAME:    form.jsp
</p>
<p> VERSION LOG
<pre>
VER   BY				DATE        COMMENT
001   angel.chata	18/04/2010  First comment
</pre>
</p> 
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
<!DOCTYPE html>
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
<meta http-equiv="Content-Language" content="es-PE">
<meta http-equiv="PRAGMA" content="NO-CACHE">
<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<meta http-equiv="Expires" content="-1">
<meta name="description" content="Haga su queja o reclamo en el Libro de Reclamaciones de La Tinka" />
<meta name="keywords" content="libro, reclamaciones, La Tinka">
<meta name="author" content="La Tinka S.A.">
<meta name="distribution" content="Global"> 
<meta name="copyright" content="(c) La Tinka S.A.">
<meta name="robots" content="FOLLOW,INDEX">
<title>La Tinka | Libro de Reclamaciones | Imprimir</title>
<!-- <script language="javascript" src="layer-view-script/client/book/utils.js"></script> -->
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css"/>
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />
	<link rel="stylesheet" type="text/css" href="layer-view-style/client/book/body.css?v=2">
</head>
<%
	String dni         = request.getParameter("document-number");
	String email       = request.getParameter("email");
	String nombre      = request.getParameter("nombre");
	String direccion   = request.getParameter("direccion");
	String telefono    = request.getParameter("telefono");
	String tipobien    = request.getParameter("tipobien");
	String monto     = request.getParameter("monto");
	String bien        = request.getParameter("bien");
	String tiporeclamo = request.getParameter("tiporeclamo");
	String reclamo     = request.getParameter("reclamo");
	String pedido     = request.getParameter("pedido"); 
	String secuencia = request.getParameter("secuencia"); 
	String fecha  = request.getParameter("fecha"); 
%>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

   	<%@ include file="../include/header.jspf" %> 
		<div id="form-book" class="container-fluid">
		<div class="content row">
			<div class="col-md-5 p-4 p-md-5 left">
				<div class="block">
					<p>Reclamaci&oacute;n registrada.</p>
					<h1>Hoja de Reclamaci&oacute;n 109951-<%=secuencia%></h1> 					
				</div>
			</div>
			<div class="col-md-7 p-4 p-md-5 right">
				<div class="text-ident-s">
					<div class="content-t">
						<p>Fecha : <%=fecha%></p>
						<p>LA TINKA. Av. José Pardo Nº 434, Piso 11, Miraflores - Lima</p>						
						<div class="title-form" style="padding-left: 0px;">
							1. Identificaci&oacute;n del consumidor reclamante
						</div>
						<p style="text-align: justify;"><b>Nombre </b>: <%=nombre%></p>
						<p style="text-align: justify;"><b>Domicilio</b> : <%=direccion%></p>
						<p style="text-align: justify;"><b>DNI/CE</b> : <%=dni%></p>
						<p style="text-align: justify;"><b>Tel&eacute;fono</b> : <%=telefono%></p>
						<p style="text-align: justify;"><b>E-mail</b> : <%=email%></p>
						<div class="title-form" style="padding-left: 0px;">2. Identificaci&oacute;n del bien contratado</div>
						<p style="text-align: justify;"><b>Tipo de bien</b> :<%=tipobien%></p>
						<p style="text-align: justify;"><b>Monto reclamado</b> : <%=monto%></p>
						<p style="text-align: justify;"><b>Descripci&oacute;n</b> : <%=bien%></p>
						<div class="title-form" style="padding-left: 0px;">3. Detalle de la reclamaci&oacute;n</div>
						<p style="text-align: justify;"><b>Tipo de reclamo</b> : <%=tiporeclamo%></p>
						<p style="text-align: justify;"><b>Detalle</b> : <%=reclamo%></p>
						<p style="text-align: justify;"><b>Pedido</b> : <%=pedido%></p>
						<div class="text-ident" style="padding: 0px;">
						<p style="text-align: justify;">La empresa tiene un plazo de 15 d&iacute;as h&aacute;biles para contestar su reclamo, el cual empieza a contar a partir del d&iacute;a siguiente de ingresado.</p>
						<p style="text-align: justify;">Estoy de acuerdo o conforme con lo ingresado en esta Hoja de Reclamaciones.</p>
						</div>
					</div>
			    	<a href="#" class="form-contact-button-limpiar buttonrc button__baserc" onclick="window.print();">Imprimir</a>
				</div>
			</div>
		</div>
	</div>

		
	
	<style>
		.text-ident {
		    padding-left: 0px !important;
		}
		.content-t p b {
		    font-family: 'Avenir';
		}
		.text-ident p {
		    font-size: 12px !important;
		    margin-bottom: 0px !important;
		    color: #636363 !important;
		    font-family: -apple-system,BlinkMacSystemFont,"Segoe UI",Roboto,"Helvetica Neue",Arial,"Noto Sans",sans-serif,"Apple Color Emoji","Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji" !important;
		}
	</style>
	<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
	<script type="text/javascript" src="layer-view-script/common/jquery-migrate-3.1.0.min.js"></script>
 	<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
 	<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.validator.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/jPages.js"></script>
    <script type="text/javascript" src="layer-view-script/client/main.js?v=<%=Constants.client_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/client/book/utils.js?v=4"></script>
	<%@ include file="../include/footer.jspf" %>	
	<script>
		$('.has-sub').removeClass('active');
		setTimeout(function(){
			$('.has-sub').removeClass('active');
	    },500);
	</script>
</body>

</html>