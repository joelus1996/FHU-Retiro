<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isRestoreSale == false}">
	<c:redirect url="${lotocardSrv}i.do?m=inicio" />
</c:if>
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

<meta charset="utf-8">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/carousel.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/client/restablecerUser.css">
<meta name="viewport" content="width=1024">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">

<script type="text/javascript"
	src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript"
	src="layer-view-script/common/modernizr.js"></script>
<title>Alerta de seguridad - La Tinka</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body>
	<!-- Google Tag Manager (noscript) -->
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<!-- End Google Tag Manager (noscript) -->

	<%@ include file="../include/header.jspf"%>

	<div class="ilot">
		<div class="main-content">
			<div class="main-page">

				<div class="row">

					<div class="col-12 col-md-8">

						<div class="wrapper-form">

							<div id="send" style="display: block">
								<i></i>
								<form id="frm-user-reminder" action="send_user_mail.html"
									method="post">

									<div class="head-main-form">
										<div class="sub-head-form">
											<p class="no-upper">
												<span
													style="font-size: 18px; font-family: AllerBold, Arial, sans-serif;">Validación de datos</span>
											</p>
											<br>
											<br>
											<p class="no-upper">
												<span
													style="font-size: 15.4px; font-family: Roboto, sans-serif;">Ha ocurrido un inconveniente con tu sesión, ponte en contacto con la Tinka al 5135502.</span>
											</p>
										</div>
									</div>

									<div class="body-main-form">

										<div class="box-main-form" style="padding-top: 0px;">
											<div
												class="form-group offset-sm-0 col-sm-12 offset-md-2 col-md-10"
												style="text-align: center; padding-right: 5px; padding-left: 5px; margin: 0 auto;">

												<br>
												<br>
												<div class="offset-sm-0 col-sm-6  col-md-9"
													style="margin: 0 auto;">
													<button id="btn-aceptar" type="submit"
														style="width: 90%; font-size: 16px; height: 45px; border-radius: 1.45em; color: #fff; background-color: #07663a;border: #07663a;">Aceptar</button>
												</div>

											</div>

										</div>

									</div>

								</form>

							</div>

						</div>

					</div>
					<div class="col-12 col-md-4">

						<aside class="banner">


							<div class="boxes-banner">

								<div id="iframeTool">
									<iframe id="myIframe" src="${iframeHomeMicuentaURL}"
										frameborder="0" scrolling="no">
										<p>Is imposible, your browser dont support iframe</p>
									</iframe>
								</div>
							</div>
						</aside>
					</div>
					
					</div>

				</div>

			</div>
	</div>
	<script type="text/javascript"
		src="layer-view-script/common/jquery-3.6.3.min.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.alerts.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.scripts.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.carouFredSel.js"></script>
	<script type="text/javascript"
		src="layer-view-script/client/restablecerUsers.js?v=4"></script>
	<script type="text/javascript"
		src="layer-view-script/common/keyboard.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript"
		src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
	<script type="text/javascript"
		src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
	<%@ include file="../include/footer.jspf"%>
	<%@ include file="../include/message.jspf"%>

	<script type="text/javascript">
	document.getElementById("btn-aceptar").addEventListener("click", function(event) {
	    event.preventDefault();
	    // Redirigir al usuario al home de la página
	    window.location.href = "inicio.html";
	});
    
    </script>

</body>
</html>