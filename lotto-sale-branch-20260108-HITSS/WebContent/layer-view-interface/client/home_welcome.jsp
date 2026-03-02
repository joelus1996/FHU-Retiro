<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="es">
<head>
<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
<script>
window.onload = function () {
	if(document.getElementById("clientId").value){
		dataLayer.splice(0,1,{
			'loginStatus': 'Sesión iniciada',
			'clientid': getClientID(),
			'userID': document.getElementById("clientId").value,
			});
	}
}
</script>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta charset="utf-8">
<meta name="viewport" content="width=1024">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/client/signUp.css">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/common/carousel.css">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css"	href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
<link rel="stylesheet" type="text/css"	href="layer-view-style/common/tav2-header.css?v=<%=Constants.tav2_header_css%>">
<link media="screen" rel="stylesheet" type="text/css"
	href="layer-view-style/client/main.css?v=<%=Constants.main_css%>">
	
	

<script type="text/javascript"
	src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript"
	src="layer-view-script/common/modernizr.js"></script>
<title>Bienvenido - La Tinka</title>
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
	<!-- Nuevos Inputs Ocultos para "Cargar Saldo" -->
	<input type="hidden" id="ID_Juego" value="<c:out value='${ID_Juego}' escapeXml='true' />">
	

<div class="main-content">
	<div class="main-page">
		<div class="row">
			<div class="col-12 col-md-8">
				<div id="account-wrapper" class="account-wrapper">

					<div class="box-content-message">
					
						<c:set var="formattedName" value="${fn:toUpperCase(fn:substring(aNombres[0], 0, 1))}${fn:toLowerCase(fn:substring(aNombres[0], 1, fn:length(aNombres[0])))}" />

						<h3 class="activate__title d-block center c_green">
							¡Felicitaciones<br />${formattedName}!
						</h3>
						
						<div class="box_message">
							
                            <h4>Bienvenido a la Tinka</h4>
                                <p class="activate__text">Estás a un clic de ser millonario.<br>Realiza tu primera recarga.</p>
							
							<div class="form"> 
                                    <div class="form__button">
                                        <c:if test="${OperatorId ne 5588}">
                                            <a class="button button__outline button_red" href="javascript:void(0)" id="addSaldoW"
                                               data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate"
                                               data-label="Activa cuenta - cargar saldo">
                                                Cargar saldo
                                            </a><br><br>
                                            <a class="link_green" href="javascript:void(0)" id="lnkInicio"
                                               data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate"
                                               data-action="click" data-label="Activa cuenta - ir al home">
                                                Continuar
                                            </a>
                                        </c:if>
                                        <c:if test="${OperatorId eq 5588}">
                                            <a class="button button__outline button_red" href="javascript:void(0)" id="addSaldoW"
                                               data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate"
                                               data-label="Activa cuenta - cargar saldo">
                                                Cargar saldo
                                            </a><br><br>
                                            <a class="link_green" href="javascript:void(0)" id="lnkInicio"
                                               data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate"
                                               data-action="click" data-label="Activa cuenta - ir al home">
                                                Continuar
                                            </a>
                                        </c:if>
                                    </div>
                                </div>
						</div>
						<p>&nbsp;</p>
					</div>

				</div>
			</div>
			<div class="col-12 col-md-4">
				<aside class="banner">

                		<div class="boxes-banner">
                				<c:if test="${isLaPolla}">
				      			<div class="box-banner">
									<div class="">
										<div align="center">
											<a href="#" onclick="toLaPolla();" target="_top">
												<img src="layer-view-image/v2/landing/img/ban-lapolla-teapuesto.png" alt="Polla del Mundial Qatar 2022">
											</a>
										</div>
									</div>
								</div>
								</c:if>

<!--                 			<div class="box-banner"> -->
<!--         		        		<div class="load-money"> -->
<!--         		        			<a href="#" id="load-money"><img src="layer-view-image/v2/logo-soles.png"><span>CARGAR MI SALDO</span></a> -->
<!--         		        		</div> -->
<!--         	        		</div> -->

        	        			<div id="iframeTool">
		        					<iframe id="myIframe" src="${iframeHomeMicuentaURL}" frameborder="0" scrolling="no" ><p>Is imposible, your browser dont support iframe</p></iframe>
		        				</div>
                                
        	        		

                		</div>

                	</aside>
			</div>
		</div>
	</div>
</div>
	


	<script type="text/javascript"
		src="layer-view-script/common/jquery-3.6.3.min.js"></script>
	<script type="text/javascript"
		src="layer-view-script/common/jquery.alerts.js"></script>
	<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/loadBalanceGame.js?v=2"></script>
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
</body>
</html>