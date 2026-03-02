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
	<title>La Tinka : Datos del cliente</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
	
	
</head>
<body class="body-perfil">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	<div class="container">
		
		<jsp:include page="../include/header.jsp" />

		 <div class="content-wrap">
			<div class="content">
				<section class="main-section"> 
					<div class="main-wallet-account">
						<div class="title-wallet">
							<h3>MI PERFIL</h3>
						</div> 
						<div class="configuracion">
							
							<a href="client_edit_show_information.html" >Editar perfil</a>
							<a href="client_edit_password.html" >Cambiar contraseña</a>
							<a href="client_edit_auto_control.html" >Autocontrol</a>
						
						</div>

					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	
		
	
	
	

</body>
</html>