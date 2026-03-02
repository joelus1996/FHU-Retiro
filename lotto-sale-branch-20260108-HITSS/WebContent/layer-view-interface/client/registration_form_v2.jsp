<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/signUp.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/carousel.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">

<!-- 	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/ta.min.css"> -->

<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
<link rel="stylesheet" type="text/css" href="layer-view-style/common/tav2-header.css?v=<%=Constants.tav2_header_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/main.css?v=<%=Constants.main_css%>">

<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
<title>Regístrate en la Tinka y Juega tus loterías favoritas</title>
<meta name="description" content="Regístrate hoy en la tinka y juega por el pozo millonario. Recuerda que tus sueños están a una tinka de distancia.">
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body oncontextmenu="return false" onselectstart="return false" ondragtart="return false">
	<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	<input type="hidden" value="Registro" id="TipoZona">
	<input type="hidden" value="Registro" id="Zona">
	<input type="hidden" value="Formulario Registro" id="SubZona">
	<input type="hidden" id="operatorIdApi" value="${OperatorId}" />	
	
	
	<c:if test="${OperatorId eq 5588}">
		<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=10"></script>
		<input type="hidden" id="urlRedirect5588" />
	   	  <header id="nvs-header">
			<div class="nvs-header-row nvs-header-0">
				<div class="nvs-logo"> <a class="logo" href="<%= Constants.tav2GameProviderCloseUrl%>"></a> </div>
				<div class="nvs-register"> 
					<c:if test="${redirectGame ne 'DV'}">
						<a class="boton_personalizado" id="to-tav2-login" href="tav2.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />"><span class="header-login-icon"></span>&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
						<a class="boton_personalizado" id="to-tav2" >&nbsp;&nbsp;&nbsp;INICIO&nbsp;&nbsp;&nbsp;</a>
					</c:if>
					<c:if test="${redirectGame eq 'DV'}">
					    <a class="boton_personalizado" id="to-tav2-login-ddvv" href="tav2.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" ><span class="header-login-icon"></span>&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
						<a class="boton_personalizado" id="to-tav2-ddvv" >&nbsp;&nbsp;&nbsp;INICIO&nbsp;&nbsp;&nbsp;</a>
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
				<div class="nvs-logo"> <a class="logo" href="<%= Constants.lapollaGameProviderCloseUrl%>"></a> </div>
				<div class="nvs-register"> 
					<c:if test="${redirectGame ne 'DV'}">
						<a class="boton_personalizado" id="to-tav2-login" href="tav2.html?operatorId=5587&urlRedirect5587=<c:out value='${urlRedirect5587}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />"><span class="header-login-icon"></span>&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
						<a class="boton_personalizado" id="to-tav2" >&nbsp;&nbsp;&nbsp;INICIO&nbsp;&nbsp;&nbsp;</a>
					</c:if>
					<c:if test="${redirectGame eq 'DV'}">
					    <a class="boton_personalizado" id="to-tav2-login-ddvv" href="tav2.html?operatorId=5587&urlRedirect5587=<c:out value='${urlRedirect5587}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" ><span class="header-login-icon"></span>&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
						<a class="boton_personalizado" id="to-tav2-ddvv" >&nbsp;&nbsp;&nbsp;INICIO&nbsp;&nbsp;&nbsp;</a>
					</c:if>
				</div>
			</div>	
			<div class="nvs-header-row nvs-header-1">&nbsp;</div>
			<div class="nvs-header-row nvs-header-2">&nbsp;</div>
		  </header>
    </c:if>
    
    <c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
    	<%@ include file="../include/header.jspf"%>
    </c:if>
     
    <div class="ilot">
<div id="wrapper-form">
      <div class="body__content">
        <div class="registro">
          <div class="registro__bg">&nbsp;</div>
          <div class="content">
            <div class="registro__sidebar">
              <h3 class="registro__sidebar-title">Regístrate</h3>
              <p class="registro__sidebar-text">Crea tu cuenta completando tus datos. Luego actívala ingresando el código que enviaremos a tu celular. Los juegos son válidos para mayores de 18 años.</p>
              <br><br>
              
			  <c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
			    <!--               Banner de registro ecommerce -->
                <input type="hidden" value="<%=Constants.BANNER_REGISTRO%>" id="bannerRegistro">
              <img id="imgBannerRegistro" style="margin-left: 9.09091%; height: 235px; width: 245px;" alt="registrate-y-gana-con-te-apuesto" src="<%=Constants.BANNER_REGISTRO%>">
		      </c:if>
		      		      
              <c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
                <!--               Banner de registro TA -->
                <input type="hidden" value="<%=Constants.BANNER_REGISTRO_TA%>" id="bannerRegistro">
		    	<img id="imgBannerRegistro" style="margin-left: 9.09091%; height: 235px; width: 245px;" alt="registrate-y-gana-con-te-apuesto" src="<%=Constants.BANNER_REGISTRO_TA%>">
		      </c:if>
              
            </div>
            <div class="registro__form">
              <form class="form"	id="frm-user-register" action="registrar.html" 		autocomplete="off" method="post">
              
                <div class="form__section">Información personal</div>
                <div class="form__select">
                  <label for="document-type">Tipo de documento</label>
                  <select name="document-type" id="document-type" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
                    <!--option(value='') Seleccionar-->
                    <option value="DNI" selected>DNI</option>
                    <option value="PASAP">Pasaporte</option>
                    <option value="CAREX">Carnet de Extranjería</option>
                  </select>
                </div>
                <div class="form__input form__optional show" id="divNumberDoc">
                  <label for="document-number">Número de documento</label>
                  <input type="text" name="document-number" tabindex="11" id="document-number" maxlength="8" data-validation="length number" data-validation-length="8" data-validation-error-msg="Ingresa un DNI válido" data-validation-depends-on="document-type" data-validation-depends-on-value="DNI">
				  <div id='document_number_msg' style="margin-top: 23px; font-size:8.6px;color:#07663a;">ESTE DATO SERÁ USADO COMO TU USUARIO</div>																																		  
                </div>
				<div class="form__input form__optional" id="div-documento-pasap">
                  <label for="document-number-pasap">Número de documento</label>
                  <input type="text" name="document-number-pasap" tabindex="11" id="document-number-pasap" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="Ingresa un Pasaporte válido" data-validation-depends-on="document-type" data-validation-depends-on-value="PASAP">
				  <div id='document_number_pasap_msg' style="margin-top: 23px; font-size:8.6px;color:#07663a;">ESTE DATO SERÁ USADO COMO TU USUARIO</div>																																					
                </div>
                <div class="form__input form__optional" id="div-documento-carex">
                  <label for="document-number-carex">Número de documento</label>
                  <input type="text" name="document-number-carex" tabindex="11" id="document-number-carex" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="Ingresa un Carnet de Extranjería válido" data-validation-depends-on="document-type" data-validation-depends-on-value="CAREX">
				  <div id='document_number_carex_msg' style="margin-top: 23px; font-size:8.6px;color:#07663a;">ESTE DATO SERÁ USADO COMO TU USUARIO</div>																																				
                </div>
				<div class="form__input">
                  <label for="name">Nombres</label>
                  <input type="text" name="name" id="name" tabindex="12" maxlength="74" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres">
                  <div id='name_msg' style="margin-top: 23px; font-size:8.6px;color:#07663a;"></div>	
                </div>                
                <div class="form__input">
                  <label for="ap-paterno">Apellidos</label>
                  <input type="text" name="ap-paterno" id="ap-paterno" tabindex="13" maxlength="74" data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos">
                  <div id='ap-paterno_msg' style="margin-top: 23px; font-size:8.6px;color:#07663a;"></div>	
                </div>
                
                <div class="form__select form__select4">
                  <label for="nacionalidad">Nacionalidad</label>
                  <select name="nacionalidad" id="nacionalidad" tabindex="14" data-validation="required" data-validation-error-msg="Seleccionar tu nacionalidad">
<!--                     <option value="">Nacionalidad</option>  -->
                  </select>
                </div>
                <div class="form__input form__input-calendar">                  
                  <label for="fechanac">Fecha de nacimiento</label>
                   <input type="text" name="fechanac" tabindex="15" id="fechanac" maxlength="10" placeholder="dd/mm/aaaa" data-validation="date" data-validation-format="dd/mm/yyyy" data-validation-error-msg="Tu fecha de nacimiento es requerida. Debes ser mayor de 18 años." readonly>
                   <button type="button" id="showCalendar"></button>
                   <div id='fechanac_msg' style="margin-top: 23px; font-size:8.6px;color:#07663a;"></div>	
                </div>
                                
                <div class="form__section">Datos de acceso</div>
                <!--  <div class="form__input" style="border:none; margin-bottom:10px;">
                  <span class="icon-security-pass"></span><a href="javascript:void(0);​" onclick="openSecurityPass();" class='link link__base' id=link-security-pass>Crea una contraseña segura</a>
                </div>                
                <div class="form__input" style="border:none; margin-bottom:10px;">
                  
                  <div class="bocadillo-security-pass"  id="bocadillo-security-pass" hidden=""> 
					<a class="close-popup-security-pass " id="close-popup-security-pass" onclick="closeSecurityPass()">&times;</a>
	             	<p style="margin-top: 10px; text-decoration: underline; font-weight: 600; margin-bottom: 8px;">EVITA DIGITAR:</p>
	            	<p>- Tu nombre, celular, DNI, cumpleaños.</p>
	            	<p>- Tus últimas 10 contraseñas.</p>
	            	<p>- Números o letras iguales, en secuencia,</p>
	            	<p>&nbsp;&nbsp;inversos: "1111111111", "zzzzzzzzzz",</p>
	            	<p>&nbsp;&nbsp;"1234567890", "abcdefghijkl" o</p>
	            	<p>&nbsp;&nbsp;"lkjihgfedcba".</p>
	            	<p>- Caracteres en orden de teclado: "qwerty".</p>
	            	<p>- Nombre de los juegos de La Tinka.</p>
	            	<div style="position: absolute; top: 35px; left: -9px;">
                  	  <svg width="20px" height="20px">
						<polygon fill="#F7F7F7" stroke="#07663a" stroke-width="1px" points="1 10, 10 1, 10 20" />
						<polygon fill="#F7F7F7" stroke="#F7F7F7" stroke-width="1px" points="9.5 0, 10.5 0, 10.5 21, 9.5 21" />
					  </svg>
                    </div>
	              </div>
	              
                </div>-->  
                
<!--                 <div class="form__input"> -->
<!--                   <label for="user-client">Usuario</label> -->
<!--                   <input type="text" name="user-client" id="user-client" autocomplete="new-password" tabindex="15" data-validation="alphanumeric" data-validation-error-msg="El usuario es requerido"> -->
<!-- 				  <input type="text" name="user-client" id="user-client" autocomplete="off"  tabindex="15" data-validation="alphanumeric" data-validation-error-msg="Tu usuario es requerido"> -->
<!--                 </div> -->
                <div class="form__input form__input-password" style="margin-bottom: 80px; margin-top: -8px;">
                  <label for="password-client">Contraseña</label>
                  <input type="password" name="password-client" id="password-client" autocomplete="off" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
                  <button type="button" id="toglePassword"></button>
                  <div class="strength-meter">&nbsp;</div>
                </div>
                <div class="form__section">Información actual de contacto</div>
                <div class="form__input">
                  <label for="email">Correo electrónico</label>
                  <input type="text" name="email" id="email" tabindex="17" data-validation="email" data-validation-error-msg="Debes ingresar un correo válido">
                </div>
                <div class="form__input">
                  <label for="mobile-phone">Número de celular</label>
                  <input type="text" name="mobile-phone" id="mobile-phone" tabindex="18" maxlength="9" data-validation="length number" data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="Tu celular es requerido">
                </div>
                <div class="form__input">
                  <label for="domicilio">Dirección actual</label>
                  <input type="text" name="domicilio" id="domicilio" tabindex="19" maxlength="70" data-validation="required"  data-validation-error-msg="Tu dirección actual es requerida">
                </div>
                <div class="form__select form__select4">
                  <label for="departamento">Departamento</label>
                  <select name="departamento" id="departamento" tabindex="20" data-validation="required" data-validation-error-msg="Seleccionar tu departamento">
<!--                     <option value="">Departamento</option>  -->
                  </select>
                </div><br>
                <div class="form__select form__select4">
                  <label for="provincia">Provincia</label>
                  <select name="provincia" id="provincia" tabindex="21" data-validation="required" data-validation-error-msg="Seleccionar tu provincia">
<!--                     <option value="">Provincia</option>  -->
                  </select>
                </div>
                <div class="form__select form__select4">
                  <label for="distrito">Distrito</label>
                  <select name="distrito" id="distrito" tabindex="22" data-validation="required" data-validation-error-msg="Seleccionar tu distrito">
<!--                     <option value="">Distrito</option>  -->
                  </select>
                </div><br>
                <div id='documento_pasap_msg' style="margin-bottom: 20px; font-size:13px;color:#00bfff; margin-right: 2.9%; text-align: justify;">
	                <div class="row" style="margin-left: 0px;">
	                	<div class="col-1 col-md-1"  style="padding-right: 0px;max-width: 32px;padding-left: 0px;"><span class="icon-tarjeta"></span></div>	                
		                <div class="col-11 col-md-11" style="padding-left: 0px;">Para poder cobrar un premio validaremos los datos de tu cuenta contra los datos de tu documento de identidad. <b>¡Asegúrate que sean correctos y que tu documento esté vigente!</b></div> 
		            </div>    
                </div>
                
                <div class="form__check form__check2" style="margin-right: 2.9%; text-align: justify; padding-right: 15px;">
                  <input type="checkbox" name="terms" id="terms" value="1" data-validation="required" data-validation-error-msg="Esta aceptación es requerida">
                  <label for="terms">He leído y acepto los <a href="<%=Constants.URL_QW%>/terminos-y-condiciones/" target="_blank" class='link link__base'>Términos y condiciones</a> y la
                  <a href="<%=Constants.URL_QW%>/politica-de-datos-personales/" target="_blank" class='link link__base'>Política de datos personales y fines adicionales</a> como envío de promociones y noticias,
                  y declaro bajo juramento que no soy una <a href="<%=Constants.URL_QW%>/persona-politicamente-expuesta/?origin=i​" target="_blank" class='link link__base'>persona políticamente expuesta.</a>
                  </label>
                </div>
<!--                   <label>¿Quieres recibir promociones y noticias a tu correo electrónico y/o celular?</label> -->
                  <br>
                <div class="form__button">
                  <button class="button button__base_3" type="submit" id="btsubmit" disabled>Registrar</button>
                </div>
                <div id="popup-message" class="overlay">							
					<div class="popup popup-sm login-error">	
						<a class="close-popup " id="close-popup-message" onclick="closeModal(this); clearDocument();">&times;</a>							
						<div class="main-modal" id="msg-message"></div>						
					</div>
				</div>
              </form>
            </div>
          </div>
        </div>
      </div>
</div>	
    </div>

    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.mask.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.validator.js"></script>
    
<!-- 	<script type="text/javascript" src="layer-view-script/client/signUp.js"></script> -->

	<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
	
	<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/client/main.js?v=<%=Constants.client_main_js%>"></script>
<!-- 	<script type="text/javascript" src="layer-view-script/common/captcha.js"></script> -->
	<c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
	  <script type="text/javascript" charset="UTF-8" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
	</c:if>
	
	<c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
		<%@ include file="../include/footer.jspf"%>
	</c:if>
	
    <%@ include file="../include/message.jspf"%>
	<script type="text/javascript">

		$(document).ready(function() {
			$("#name , #ap-paterno , #document-type , #document-number , #fechanac, #nacionalidad ").on('focusout',function(){
				if($(this).val() != '') datalayerInfoPerso(this); 
			}); 
			$("#user-client , #password-client ").on('focusout',function(){
				if($(this).val() != '') datalayerDatoAcceso(this); 
			});
			$("#email , #mobile-phone, #domicilio, #departamento, #provincia, #distrito ").on('focusout',function(){
				if($(this).val() != '') datalayerInfoContacto(this); 
			});
			$("#terms ").on('click',function(){
				datalayerTyC(this); 
			});
			$("#confirm").on('click',function(){
				datalayerPromo(this); 
			});
			 
			
			renderRegisterForm();
			setTimeout(function(){
				$('input').val('');
				$("#TipoZona").val('Registro');
				$("#Zona").val('Registro');
				$("#SubZona").val('Formulario Registro');
				$("#operatorIdApi").val(`${operatorId == '' ? 5586 : operatorId}`);
			},200);
			
			$("#name").on("drop copy paste", function(){
            	return false;
             });
            $("#ap-paterno").on("drop copy paste", function(){
             	return false;
             });
			$("#email").on("drop copy paste", function(){
            	return false;
             });
			$("#domicilio").on("drop copy paste", function(){
             	return false;
             });
			
			try{
				var urlBannerRegistro = $("#bannerRegistro").val();
				$.get(urlBannerRegistro)
			    .done(function() {
			    	$("#imgBannerRegistro").css("display","block");
			    }).fail(function(jqXHR, textStatus, errorThrown ) { 
			    	$("#imgBannerRegistro").css("display","none");
			    });
			}catch(err) {
				console.log(err);
			}
		});

	</script>
	<script type="text/javascript" src="layer-view-script/client/locationData.js?v=2"></script>
	<script type="text/javascript" src="layer-view-script/client/tracking.js?v=1"></script>

	<c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
		<script type="text/javascript" src="layer-view-script/common/bootstrap.bundle.min.js"></script>
    	
    	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/popModal.css?v=<%=Constants.popModal_css%>">
    	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/bannerCookies.css?v=6">
    	<!-- Banner Cookies registro-->		
<!-- 		<div id="bannerCookies" class="BannerCookies closeBanner" > -->
<!-- 			<div class="txtBanner"> -->
<!-- 				La Tinka utiliza cookies. Al hacer click en el botón Aceptar, aceptas su uso. -->
<!-- 				 Obtén más información sobre las cookies y cómo evitar su uso en este <span id="enlaceBanner">enlace.</Span> -->
<!-- 			</div> -->
<!-- 			<button type="button" id="btnBannerCookies" onclick="return false;" class="buttonBanner"> -->
<!-- 				Aceptar -->
<!-- 			</button> -->
<!-- 		</div>			 -->
		
<div>
	<div id="bannerCookiesModal"></div>
	<div id="bannerCookies" class="ck-font-family ck-banner-cookies" style="letter-spacing: normal;"> 
		<div class="ck-cookie-bar shadow-lg z-50" id="cookieBanner" style="z-index: 100;">
	      <div>
	        <div class="ck-cookie-paragraph">
	          La Tinka utiliza cookies para ofrecer la mejor experiencia a nuestros usuarios. Al seguir navegando aceptas el uso de cookies.
	        </div>
	      </div>
	      <div class="ck-btn-container d-flex">
	        <button
	          class="ck-custom-botton ck-conf-btn"
	          data-bs-toggle="modal"
	          data-bs-target="#cookieModal"
	        >
	          Configurar cookies
	        </button>
	        <button id="acceptAllBtn" class="ck-custom-botton ck-accept-btn">
	          Aceptar todas
	        </button>
	      </div>
	    </div>
	<div class="ckb-modal fade" tabindex="-1" id="cookieModal" style="z-index: 2000;">
	      <div class="ckb-modal-dialog">
	        <div class="ckb-modal-content ck-custom-modal-content" style="text-align: justify !important;">
	          <div class="ckb-modal-header ck-custom-modal-header">
	            <h5 class="ck-custom-modal-title">Configuración de Cookies</h5>
	            <img class="ck-logo" src="layer-view-image/client/logo-banner-cookies.png" />
	          </div>
			  
	          <div class="ckb-modal-body">
	            <div class="ck-main-text">
	              Nuestros sitios web podrían obtener o guardar información en tu
	              navegador, mediante el uso de cookies. Respetando tu derecho a la
	              privacidad, puedes escoger no permitirnos usar ciertas cookies,
	              sin embargo, el bloqueo de algunos tipos de cookies puede afectar
	              tu experiencia en nuestros sitios y con los servicios que te
	              ofrecemos.
	            </div>
	            <div
	              class="accordion ck-accordion accordion-flush"
	              id="accordionFlushExample"
	            >
	              <div class="accordion-item">
	                <div
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseOne"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseOne"
	                  >
	                    <label class="ck-color-gray">
	                      Estrictamente necesarias
	                    </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <label
	                      class="ck-siempre-label"
	                      onclick="event.stopPropagation()"
	                    >
	                      Siempre activas
	                    </label>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseOne"
	                      data-bs-target="#flush-collapseOne"
	                      class="accord ck-accord ck-arrow-1"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseOne"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies son necesarias para que el sitio web funcione,
	                    no se pueden desactivar en nuestro sistema. No guardan
	                    ninguna información personal identificable. Puedes
	                    configurar tu navegador para bloquear o alertar sobre estas
	                    cookies, pero algunas partes del sitio no funcionarán.
	                  </div>
	                </div>
	              </div>
	              <div class="accordion-item">
	                <div
	                  id="main-accord"
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseTwo"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseTwo"
	                  >
	                    <label class="ck-color-gray"> Estadísticas </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <div class="ck-switch-container">
	                      <div class="ck-switch">
	                        <input
	                          id="userAcceptsStatistics"
	                          type="checkbox"
	                          class="ck-switch-input"
	                        />
	                        <label
	                          for="userAcceptsStatistics"
	                          class="ck-switch-label"
	                        ></label>
	                      </div>
	                    </div>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseTwo"
	                      data-bs-target="#flush-collapseTwo"
	                      class="accord ck-accord ck-arrow-2"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseTwo"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies registran el número de visitantes y su
	                    comportamiento en el sitio, para medir su actividad y
	                    elaborar perfiles de navegación de usuarios.
	                  </div>
	                </div>
	              </div>
	              <div class="accordion-item">
	                <div
	                  id="main-accord"
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseThree"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseThree"
	                  >
	                    <label class="ck-color-gray"> Marketing </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <div class="ck-switch-container">
	                      <div class="ck-switch">
	                        <input
	                          id="userAcceptsMarketing"
	                          type="checkbox"
	                          class="ck-switch-input"
	                        />
	                        <label
	                          for="userAcceptsMarketing"
	                          class="ck-switch-label"
	                        ></label>
	                      </div>
	                    </div>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseThree"
	                      class="accord ck-accord ck-arrow-3"
	                      data-bs-target="#flush-collapseThree"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseThree"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies son utilizadas para fines
	                    publicitarios (registrar una identificación geográfica en
	                    dispositivos móviles, medir la eficacia de un anuncio y
	                    almacenar preferencias del reproductor de video del
	                    usuario).
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	
	          <div class="ckb-modal-footer ck-modal-footer">
	            <div class="ck-modal-btns d-flex">
	              <button
	                id="rejectCustomizationsBtn"
	                class="ck-custom-botton ck-rechazar-btn"
	                data-bs-dismiss="modal" onclick="hideModalCK();"
	              >
	                Rechazar todas
	              </button>
	              <button
	                data-bs-dismiss="modal" onclick="hideModalCK();"
	                id="acceptCustomizationsBtn"
	                class="ck-custom-botton ck-guarder-btn"
	              >
	                Guardar cambios
	              </button>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	</div> 
</div>
		<!-- fin Banner Cookies -->	
		
<script type="text/javascript" src="layer-view-script/client/bannerCookies.js?v=17"></script>

    </c:if>
    
    	
</body>
</html>