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
	<title>Alerta de seguridad - La Tinka</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=1" type="text/css" />
<!-- 	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/> -->
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
    
	<meta name="robots" content="noindex, nofollow">
</head>

<body class="white">
 	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<c:set var="lapollaEnabled"><%=Boolean.valueOf(Constantes.lapollaEnabled.trim()).booleanValue()%></c:set>
	<c:set var="tav2Enabled"><%=Boolean.valueOf(Constantes.tav2Enabled.trim()).booleanValue()%></c:set>
	<c:set var="bannersUrl"><%=Constantes.bannersUrl.toString().trim()%></c:set>
	<c:set var="iflexBonoTyC"><%=Constantes.iflexBonoTyC.toString().trim()%></c:set>
	<c:set var="wbBonoTyC"><%=Constantes.wbBonoTyC.toString().trim()%></c:set>
	<div class="container">
		
		<jsp:include page="../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<div class="ilot">
				<section class="main-section">
					<div class="center-recuperar-contrasenia">
							<div style = "text-align:center;" class="dsc-recuperar-password">
								<span style="font-size: 15.4px; font-family: Roboto, sans-serif;">Recibimos tu respuesta.<br><br>Confirma si no estás intentando acceder a tu cuenta y cambia tu contraseña por seguridad.</span>
							</div>
							<br>
							<button id="btn-no" style="width: 80%; font-size: 16px; height: 45px; border-radius: 1.45em; border: #e30613; background: #e30613; color: #fff;font-family: AllerBold, Arial, sans-serif;" type="submit" id="btn-send-password">Confirmar</button><br/>
					</div>	
				</section>
				</div>
			    </div>
				
			</div>
		</div>
		
		<jsp:include page="../include/footer.jsp" />
	
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
	<script type="text/javascript" src="layer-view-script/plugins.js"></script>
	<script type="text/javascript" src="layer-view-script/v2/swiper.min.js"></script>
    <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=14"></script>
    <script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>	
	<script type="text/javascript">

    document.getElementById("btn-no").addEventListener("click", function(event) {
        event.preventDefault();
     // Datos que se enviarán al controller
        const btn_no = "no_user"; // Reemplaza con el valor adecuado
 
		document.location.href = window.location.search + '&action='+ btn_no;
       
    });
    
    
    </script>
		
</body>
</html>