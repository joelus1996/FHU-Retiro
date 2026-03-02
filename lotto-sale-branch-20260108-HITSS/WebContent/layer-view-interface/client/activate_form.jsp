<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="es">
<head>
<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta charset="utf-8">
<meta name="viewport" content="width=1024">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/client/signUp.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/carousel.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
<link rel="stylesheet" type="text/css"
	href="layer-view-style/common/tav2-header.css?v=<%=Constants.tav2_header_css%>">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/client/main.css?v=<%=Constants.main_css%>">
	
	

<script type="text/javascript"
	src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript"
	src="layer-view-script/common/modernizr.js"></script>
<title>Registro - La Tinka</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body>
	<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->



	<c:if test="${OperatorId eq 5588}">
		<header id="nvs-header">
			<div class="nvs-header-row nvs-header-0">
				<div class="nvs-logo">
					<a class="logo" href="<%=Constants.tav2GameProviderCloseUrl%>"></a>
				</div>
				<div class="nvs-register">
					<c:if test="${redirectGame ne 'DV'}">
						<a class="boton_personalizado" id="to-tav2-login"
							href="tav2.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />"><span
							class="header-login-icon"></span>&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
						<a class="boton_personalizado" id="to-tav2">&nbsp;&nbsp;&nbsp;INICIO&nbsp;&nbsp;&nbsp;</a>
						<input type="hidden" id="redirectHome"
							value="<%=Constants.tav2GameProviderCloseUrl%>">
					</c:if>
					<c:if test="${redirectGame eq 'DV'}">
						<a class="boton_personalizado" id="to-tav2-login-ddvv"
							href="tav2.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />"><span
							class="header-login-icon"></span>&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
						<a class="boton_personalizado" id="to-tav2-ddvv">&nbsp;&nbsp;&nbsp;INICIO&nbsp;&nbsp;&nbsp;</a>
						<input type="hidden" id="redirectHome"
							value="<%=Constants.ddvvGameProviderCloseUrl%>">
					</c:if>
				</div>
			</div>
			<div class="nvs-header-row nvs-header-1">&nbsp;</div>
			<div class="nvs-header-row nvs-header-2">&nbsp;</div>
		</header>
	</c:if>
	<c:if test="${OperatorId eq 5587}">
		<header id="nvs-header">
			<div class="nvs-header-row nvs-header-0">
				<div class="nvs-logo">
					<a class="logo" href="<%=Constants.lapollaGameProviderCloseUrl%>"></a>
				</div>
				<div class="nvs-register">
					<a class="boton_personalizado" id="to-tav2-login"
						href="tav2.html?operatorId=5587&urlRedirect5587=<c:out value='${urlRedirect5587}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />"><span
						class="header-login-icon"></span>&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
					<a class="boton_personalizado" id="to-tav2">&nbsp;&nbsp;&nbsp;INICIO&nbsp;&nbsp;&nbsp;</a>
					<input type="hidden" id="redirectHome" value="<%=Constants.tav2GameProviderCloseUrl%>">
				</div>
			</div>
			<div class="nvs-header-row nvs-header-1">&nbsp;</div>
			<div class="nvs-header-row nvs-header-2">&nbsp;</div>
		</header>
	</c:if>
	<c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
		<%@ include file="../include/header.jspf"%>
		<input type="hidden" id="redirectHome"
			value="<%=Constants.eCommerceHome%>">
	</c:if>

	<input type="hidden" id="celhidden" value="<c:out value='${cel}'/>">
	<input type="hidden" id="user" value="<c:out value='${user}'/>">
	<input type="hidden" id="password" value="<c:out value='${pass}'/>">
	<input type="hidden" id="user-client" value="<c:out value='${user}'/>">
	<input type="hidden" id="user-client-id" value="<c:out value='${clientId}'/>">
	<input type="hidden" id="password-client" value="<c:out value='${pass}'/>">
	<input type="hidden" name="urlRedirect5588" id="urlRedirect5588" value="<c:out value='${urlRedirect5588}' />">
	<input type="hidden" name="urlRedirect5587" id="urlRedirect5587" value="<c:out value='${urlRedirect5587}' />">
	<input type="hidden" name="operatorId" id="operatorId" value="<c:out value='${OperatorId}' />">
	<input type="hidden" name="ref" id="ref" value="<c:out value='${ref}' />">
	<input type="hidden" value="Registro" id="TipoZona">
	<input type="hidden" value="Registro" id="Zona">
	<input type="hidden" value="Activa tu Cuenta" id="SubZona">
	<input type="hidden" id="operatorIdApi" value="${operatorId == '' ? 5586 : operatorId}" >
	
	<div class="ilot">
		<div id="wrapper-form">
			<div class="body__content">
				<div class="top-message" id="top-message">
					<div class="content" id="top_message">Ya creaste tu cuenta,
						ahora debes activarla.</div>
				</div>
				<div class="activate">
					<div class="content">
						<div class="activate__content">
							<!-- step 01-->
							<div class="step step-01">
								<h3 class="activate__title">Activa tu cuenta</h3>
								<p class="activate__text">
									Hemos enviado un código a tu celular <strong id="celSMS">
  									${fn:substring(cel, 0, 2)}*****${fn:substring(cel, 7, 9)}
									</strong> para activar tu cuenta.
								</p>
								<form class="form" id="form_activate" autocomplete="off"
									method="post">
									<div class="form__label">Por favor revisa tu celular e
										ingresa el código:</div>
									<div class="form__code">
										<div class="form__code-item">
											<input type="text" name="code-01" id="code-01" tabindex="31"
												maxlength="1">
										</div>
										<div class="form__code-item">
											<input type="text" name="code-02" id="code-02" tabindex="32"
												maxlength="1">
										</div>
										<div class="form__code-item">
											<input type="text" name="code-03" id="code-03" tabindex="33"
												maxlength="1">
										</div>
										<div class="form__code-item">
											<input type="text" name="code-04" id="code-04" tabindex="34"
												maxlength="1">
										</div>
										<div class="form__code-item">
											<input type="text" name="code-05" id="code-05" tabindex="35"
												maxlength="1">
										</div>
									</div>
									<div class="form__alert" id="msjError"></div>
									<div class="form__button">
										<button class="button button__base_3" type="submit"
											id="btactivate" disabled>Activar</button>
									</div>
									<div class="form__help">
										 <a href='#' class="link link__base"
											id="gotoResendCode">¿No recibiste tu código?</a>
									</div>
								</form>
							</div>
							<!-- step 02-->
							<div class="step step-02 hide">
								<h3 class="activate__title">Activa tu cuenta</h3>
								<p class="activate__text">
									Verifica que tu celular esté correcto y elige un método para enviarte el código.
								</p>
								<form class="form" id="form_resend" autocomplete="off">
									<div class="form__input">
										<label for="celular">Número de celular</label> 										
							            <c:set var="sCelular" value="${cel}" />
							            <c:set var="aCelular" value="${fn:split(sCelular, ' ')}" />
							            <c:set var="scel" value="${aCelular[0]}" />
										<c:if test="${scel == '***'}">
				                    		<input readonly type="text" name="celular1" id="celular1" tabindex="18" 
				                    		maxlength="9" value="<c:out value='${cel}'/>" >
				                    	</c:if>
										<c:if test="${scel ne '***'}">
											<input type="text" name="celular" id="celular" tabindex="18"
											maxlength="9" value="<c:out value='${cel}'/>"
											data-validation="length number" data-validation-length="9"
											data-validation-allowing="range[900000000;999999999]"
											data-validation-error-msg="Ingrese su número de celular">
										</c:if>
									</div>
									<div class="activate__disclaimer_text" id="disclaimer">
    								Si tu operador es Bitel te sugerimos usar Whatsapp
									</div>
									<div class="form__alert__send" id="msjErrorSendCode"></div>
									<div class="form__button-stack">
										<button class="button button__base_4" type="submit"
											id="btresendwa">WHATSAPP</button>
										<button class="button button__base_4" type="submit"
											id="btresend">SMS</button>
									</div> 
								</form>
							</div>
							<!-- step 03-->
							<div class="step step-03 hide">
								<p>&nbsp;</p>
								<p>&nbsp;</p>
								<h3 class="activate__title">
									¡Felicitaciones!<br />tu cuenta ha sido activada
								</h3>
								<p class="activate__text">Ahora haz clic en Ingresar y
									accede a tu cuenta con tu usuario y contraseña</p>
								<!-- 								<div class="form"> -->
								<!-- 									<div class="form__button"> -->
								<%-- 										<c:if test="${OperatorId ne 5588}"> --%>
								<!-- 											<a class="button button__outline" href="#" id="lnkMiCuenta" -->
								<!-- 												data-name="Evaluate - Activa cuenta" -->
								<!-- 												data-category="Activacion-Evaluate" data-action="click" -->
								<!-- 												data-label="Activa cuenta - ir a mi cuenta">Ir a mi -->
								<!-- 												cuenta</a> -->
								<!-- 											<a class="button button__base" href="#" id="lnkCargarSaldo" -->
								<!-- 												data-name="Evaluate - Activa cuenta" -->
								<!-- 												data-category="Activacion-Evaluate" data-action="click" -->
								<!-- 												data-label="Activa cuenta - cargar saldo">Cargar Saldo</a> -->
								<%-- 										</c:if> --%>
								<%-- 										<c:if test="${OperatorId eq 5588}"> --%>
								<!-- 											<a class="button button__outline" href="#" id="lnkJuego" -->
								<!-- 												data-name="Evaluate - Activa cuenta" -->
								<!-- 												data-category="Activacion-Evaluate" data-action="click" -->
								<!-- 												data-label="Activa cuenta - ir al juego">Ir al juego</a> -->
								<!-- 											<a class="button button__base" href="#" id="lnkCargarSaldoTA" -->
								<!-- 												data-name="Evaluate - Activa cuenta" -->
								<!-- 												data-category="Activacion-Evaluate" data-action="click" -->
								<!-- 												data-label="Activa cuenta - cargar saldo">Cargar Saldo</a> -->
								<%-- 										</c:if> --%>
								<!-- 									</div> -->
								<!-- 								</div> -->
								<p>&nbsp;</p>
								<p>&nbsp;</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="layer-view-script/common/jquery-3.6.3.min.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.alerts.js"></script>
	<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.scripts.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.validator.js"></script>
	<script type="text/javascript" src="layer-view-script/client/signUp.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/keyboard.js"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript"
		src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>

	<script type="text/javascript"
		src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/client/main.js?v=<%=Constants.client_main_js%>"></script>
	<!-- 	<script type="text/javascript" src="layer-view-script/common/captcha.js"></script> -->
	<c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
		<%@ include file="../include/footer.jspf"%>
	</c:if>
	<c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
		<script type="text/javascript" charset="UTF-8" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
	</c:if>
	<%@ include file="../include/message.jspf"%>
	<script type="text/javascript">		
		$(document).ready(function() {
					
			renderActivateForm();
			renderResendCode();
			try {
				tagginViewActivar();				
			} catch (e) {
				console.error(e);
			}

		});
	</script>

 	

	



</body>
</html>