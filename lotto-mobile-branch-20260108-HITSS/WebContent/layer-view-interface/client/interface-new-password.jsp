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
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
	<style>
		.ilot .form {
		    margin: 0 7.69231%;
		}
	</style>
	
</head>
<body class="body-perfil" >
<input type="hidden" id="DataClient" value="<c:out value='${DataClient}'/>">
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
						<div class="configuracion-edit">
							<a class="volver" href="client_account_show_information.html" >volver</a>
							<div class="  tab ilot">
		                		<form class="form" id="frm-user-password" action="password-update.html" autocomplete="off" method="post" data-response-type="json">
	                				<div class="ilot-centro">
	                					<div class="form__section">Cambiar contraseña</div>
	                					<!--  <div style="margin-bottom: 20px;">
											<span class="icon-security-pass"></span><a href="javascript:void(0);"  class='link link__base' onclick="openSecurityPass();">Crea una contraseña segura</a>
										</div>  -->
	                					<div class="form__input form__input-password" style="margin-bottom: 1.5rem !important;" >
						                  <label for="password-actual">Contraseña actual</label>
						                  <input type="password" name="password-actual" id="password-actual" autocomplete="off" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
						                  <button type="button" class="toglePasswordUpdate"></button>
						                  <div class="strength-meter">&nbsp;</div>
						                </div>
	                				
	                					<div class="form__input form__input-password">
						                  <label for="new-password">Nueva contraseña</label>
						                  <input type="password" class="new-password" name="new-password" id="new-password" autocomplete="off" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
						                  <button type="button" class="toglePasswordUpdate"></button>
						                  <div class="strength-meter">&nbsp;</div>
						                </div>
	       				  			
	        				  			<div class="form__input form__input-password">
						                  <label for="confirm-password">Confirmar contraseña</label>
						                  <input type="password" class="confirm-password" name="confirm-password" id="confirm-password" autocomplete="off" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
						                  <button type="button" class="toglePasswordUpdate"></button>
						                  <div class="strength-meter">&nbsp;</div>
						                </div>
	       				  		
	       				  				<div class="form__button" style="text-align: center">
						                  <button  class="button button__base_3" type="submit" id="btnUpdatePassword" disabled>GUARDAR CONTRASEÑA</button>
						                </div>
	                				</div>
		                		</form>
	                		</div>
						</div>

					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	
	 <div id="alert_content" style="display:none">
		<div id="alertModal_content_id" class="confirmModal_content" style="text-align: center;padding-bottom: 5px;"></div>
		<div class="confirmModal_footer_alert">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">Cerrar</button>
		</div>
	</div>
	<div id="popup-message" class="overlay">							
				<div class="popup popup-sm login-error">	
				<a class="close-popup " id="close-popup-message" onclick="closeModal(this)">&times;</a>							
					<div class="main-modal" id="msg-message"></div>
					
				</div>
	</div>
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
	<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" charset="UTF-8" src="layer-view-script/client/clientResponse.js?v=9"></script>
	<script type="text/javascript">
		$('#new-password, #confirm-password').on('input',inputPassword);
	</script>
</body>
</html>