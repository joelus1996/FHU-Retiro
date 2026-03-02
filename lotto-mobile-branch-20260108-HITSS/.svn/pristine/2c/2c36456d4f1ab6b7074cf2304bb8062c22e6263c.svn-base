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
<!DOCTYPE html>
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
<!-- End Google Tag Manager -->


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="es-PE">
<meta http-equiv="PRAGMA" content="NO-CACHE">
<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<meta http-equiv="Expires" content="-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Haga su queja o reclamo en el Libro de Reclamaciones de La Tinka " />
<meta name="keywords" content="libro, reclamaciones, intralot">
<meta name="author" content="La Tinka  S.A.">
<meta name="distribution" content="Global"> 
<meta name="copyright" content="(c) La Tinka  S.A.">
<meta name="robots" content="FOLLOW,INDEX">
<title>La Tinka | Libro de Reclamaciones | Imprimir</title>
<script language="javascript" src="layer-view-script/client/book/utils.js"></script>
<link rel="stylesheet" type="text/css" href="layer-view-style/client/book/body.css?v=2">
<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />

</head>


<%
	
	request.setCharacterEncoding("UTF-8");
	
	String dni         = request.getParameter("document-number");
	String email       = request.getParameter("email");
	String nombre      = request.getParameter("nombre");
	nombre = new String(nombre.getBytes("ISO-8859-1"), "UTF-8");
	
	String direccion   = request.getParameter("direccion");
	direccion = new String(direccion.getBytes("ISO-8859-1"), "UTF-8");
	 
	String telefono    = request.getParameter("telefono");
	String tipobien    = request.getParameter("tipobien");
	String monto     = request.getParameter("monto");
	String bien        = request.getParameter("bien");
	bien = new String(bien.getBytes("ISO-8859-1"), "UTF-8");
	
	String tiporeclamo = request.getParameter("tiporeclamo");
	String reclamo     = request.getParameter("reclamo");
	reclamo = new String(reclamo.getBytes("ISO-8859-1"), "UTF-8");
	
	String pedido     = request.getParameter("pedido"); 
	pedido = new String(pedido.getBytes("ISO-8859-1"), "UTF-8");
	
	String secuencia = request.getParameter("secuencia"); 
	String fecha  = request.getParameter("fecha"); 
%>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


   	<%@ include file="../include/header.jsp" %> 
		<div id="form-book" class="container-fluid">
		<div class="content content-wrap row">
			<div class="col-md-5 p-4 p-md-5 left">
				<div class="block">
					<p>Reclamaci&oacute;n registrada.</p>
					<h1 style="font-family: -apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,'Helvetica Neue',Arial ;">Hoja de Reclamaci&oacute;n 109951-<%=secuencia%></h1> 					
				</div>
			</div>
			<div class="col-md-7 p-4 p-md-5 right" style="background-color: white;">
				<div class="text-ident-s">
					<div class="content-t">
						<p>Fecha : <%=fecha%></p>
						<p>LA TINKA . Av. José Pardo Nº 434, Piso 11, Miraflores - Lima</p>						
						<div class="title-form mobile-form-title">
							<i>1.</i>Identificaci&oacute;n del consumidor reclamante
						</div>
						<p><b>Nombre </b>: <%=nombre%></p>
						<p><b>Domicilio</b> : <%=direccion%></p>
						<p><b>DNI/CE</b> : <%=dni%></p>
						<p><b>Tel&eacute;fono</b> : <%=telefono%></p>
						<p><b>E-mail</b> : <%=email%></p>
						<div class="title-form mobile-form-title"><i>2.</i> Identificaci&oacute;n del bien contratado</div>
						<p><b>Tipo de bien</b> :<%=tipobien%></p>
						<p><b>Monto reclamado</b> : <%=monto%></p>
						<p><b>Descripci&oacute;n</b> : <%=bien%></p>
						<div class="title-form mobile-form-title"><i>3.</i> Detalle de la reclamaci&oacute;n</div>
						<p><b>Tipo de reclamo</b> : <%=tiporeclamo%></p>
						<p><b>Detalle</b> : <%=reclamo%></p>
						<p><b>Pedido</b> : <%=pedido%></p>
						<div class="text-ident">
						<p style="text-align: justify;">La empresa tiene un plazo de 15 d&iacute;as h&aacute;biles para contestar su reclamo,</br> el cual empieza a contar a partir del d&iacute;a siguiente de ingresado.</p>
						<p style="text-align: justify;">Estoy de acuerdo o conforme con lo ingresado en esta Hoja de Reclamaciones.</p>
						</div>
					</div>
			    	<a href="#" class="form-contact-button-limpiar button button__base" onclick="window.print();">Imprimir</a>
				</div>
			</div>
		</div>
	</div>		
	<script type="text/javascript">
	
// 	var _gaq = _gaq || [];
// 	_gaq.push(['_setAccount', 'UA-16525433-4']);
// 	_gaq.push(['_setDomainName', 'intralot.com.pe']);
// 	_gaq.push(['_trackPageview']);
	
// 	(function() {
// 	var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
// 	//ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
// 	ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
// 	var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
// 	})();
		
	</script>
	
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
	<%@ include file="../include/footer.jsp" %>	
	<script>
		$('.has-sub').removeClass('active');
		setTimeout(function(){
			$('.has-sub').removeClass('active');
	    },500);
	</script>
</body>

</html>