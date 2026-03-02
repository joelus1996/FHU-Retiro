<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
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
})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
<!-- End Google Tag Manager -->
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>Regístrate en la Tinka y Juega tus loterías favoritas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
	
	<link rel="stylesheet" href="layer-view-style/common/tav2-header.css?v=<%=Constantes.tav2_header_css%>" type="text/css" />
	
	<style>
		.disabled {    display: block !important; 	}
	</style>
	
	<meta name='description' content="Regístrate hoy en La Tinka y juega por el pozo millonario. Recuerda que tus sueños están a una tinka de distancia." />
	
</head>

<body class="orange">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Registro" id="TipoZona">
	<input type="hidden" value="Registro" id="Zona">
	<input type="hidden" value="Formulario Registro" id="SubZona">
	<input type="hidden" id="operatorIdApi" value="${operatorId == '' ? 5586 : operatorId}">
	
	<input type="hidden" id="uri" value="${uri}">
	<div class="container">
		<c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
			<jsp:include page="../include/header.jsp" />
		</c:if>
		
		<c:if test="${OperatorId eq 5588}">
		  <input type="hidden" id="redirect558cancel" value="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" />
		  <div class="nvs-header-row nvs-header-0">
			<div id="logo"><a href="<%= Constantes.tav2GameProviderCloseUrl%>" id="logo-href"></a></div>
			<div id="btn">
				<a href="tav2.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" id="ingresar-btn" class="register-btn"> 
				<span>INGRESAR</span>
				</a>
				<a href="#" id="ingresar-btn2" class="register-btn2">
				<span >REGÍSTRATE</span>
				</a>
			</div>
		  </div>
		</c:if>
		
		<c:if test="${OperatorId eq 5587}">
		  <div class="nvs-header-row nvs-header-0">
			<div id="logo"><a href="<%= Constantes.lapollaGameProviderCloseUrl%>" id="logo-href"></a></div>
			<div id="btn">
				<a href="tav2.html?operatorId=5587&urlRedirect5587=<c:out value='${urlRedirect5587}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" id="ingresar-btn" class="register-btn"> 
				<span>INGRESAR</span>
				</a>
				<a href="#" id="ingresar-btn2" class="register-btn2">
				<span >REGÍSTRATE</span>
				</a>
			</div>
		  </div>
		</c:if>
		
		<c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
			<div class="content-wrap">
		</c:if>
		
		<c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
			<div class="content-wrap" style="padding-top: 0em;">
		</c:if>

			<div class="content">

	<div class="ilot">
      <div class="body__content">
        <div class="registro">
          <!--.registro__bg &nbsp;-->
          <div class="content">
          
            <c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
		        <!--             banner registro ecommerce -->
		        <input type="hidden" value="<%=Constantes.BANNER_REGISTRO%>" id="bannerRegistro">
            <img id="imgBannerRegistro" style="height: 140px; width: 100%;" alt="registrate-y-gana-con-te-apuesto" src="<%=Constantes.BANNER_REGISTRO%>">
			</c:if>			
			<c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
			    <!--             banner registro TA -->
			    <input type="hidden" value="<%=Constantes.BANNER_REGISTRO_TA%>" id="bannerRegistro">
				<img id="imgBannerRegistro" style="height: 140px; width: 100%;" alt="registrate-y-gana-con-te-apuesto" src="<%=Constantes.BANNER_REGISTRO_TA%>">
			</c:if>
            
            
            <div class="registro__sidebar" style="padding-top: 20px; margin-top: -10px; padding-bottom: 20px;">
              <h3 class="registro__sidebar-title">Regístrate</h3>
              <p class="registro__sidebar-text">Crea tu cuenta completando tus datos. Luego actívala ingresando el código que enviaremos a tu celular. Los juegos son válidos para mayores de 18 años.</p>
            </div>
            <div class="registro__form">
              <form class="form" autocomplete="off" action="client_lotocard_complete_registration_form.html" method="post" id="client_lotocard_register_form" data-response-type="json">
                <div class="form__section">Información personal</div>
                <div class="form__input ridisabledInput" style="background-color: #F7F7F7;">
                  <label for="typeDoc">Tipo de documento</label>
                  <input name="itypeDoc" id="itypeDoc" value="${typedoc}" >
<!--                   <select name="typeDoc" id="typeDoc" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento"  disabled> -->
<!--                     option(value='') Seleccionar -->
<%--                     <c:choose> --%>
<%--                     	<c:when test= "${typedoc eq 'DNI' }"> --%>
<!--                     		<option value="DNI" selected>DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
<%--                     	</c:when> --%>
<%--                     	<c:when test="${typedoc eq 'PASAP' }"> --%>
<!--                     		<option value="DNI" >DNI</option> -->
<!-- 		                    <option value="PASAP selected">Pasaporte</option> -->
<!-- 		                    <option value="CAREX">Carnet de Extranjería</option> -->
<%--                     	</c:when> --%>
<%--                     	<c:when test="${tupedoc eq 'CAREX'}"> --%>
<!--                     		<option value="DNI" >DNI</option> -->
<!-- 		                    <option value="PASAP">Pasaporte</option> -->
<!-- 		                    <option value="CAREX selected">Carnet de Extranjería</option> -->
<%--                     	</c:when> --%>
                    	
<%--                     </c:choose> --%>
<!--                   </select> -->
                </div>
                <c:choose>
               		<c:when test= "${typedoc eq 'DNI' }">
		                <div class="form__input form__optional show ridisabledInput"   id="divNumberDoc" style="background-color: #F7F7F7;">
		                  <label for="numberDoc">Número de documento</label>
		                  <input readonly  type="tel" name="numberDoc" tabindex="11" id="numberDoc" maxlength="8" data-validation="length number" 
		                  data-validation-length="8" data-validation-error-msg="Ingresa un DNI válido" data-validation-depends-on="typeDoc" 
		                  data-validation-depends-on-value="DNI" value="${ document}">
		                </div>
	            	</c:when>
                    <c:when test="${typedoc eq 'PASAP' }">
		                <div class="form__input form__optional show ridisabledInput" id="div-documento-pasap" style="background-color: #F7F7F7;">
		                  <label for="documento-pasap">Número de documento</label>
		                  <input readonly type="text" name="documento-pasap" tabindex="11" id="documento-pasap" maxlength="12" data-validation="length alphanumeric" 
		                  data-validation-length="min9max12" data-validation-error-msg="Ingresa un Pasaporte válido" data-validation-depends-on="typeDoc" 
		                  data-validation-depends-on-value="PASAP" value="${ document}">
		                </div>
	                </c:when>
                    <c:when test="${tupedoc eq 'CAREX'}">
		                <div class="form__input form__optional show ridisabledInput" id="div-documento-carex" style="background-color: #F7F7F7;">
		                  <label for="documento-carex">Número de documento</label>
		                  <input readonly type="text" name="documento-carex" tabindex="11" id="documento-carex" maxlength="12" data-validation="length alphanumeric" 
		                  data-validation-length="min9max12" data-validation-error-msg="Ingresa un Carnet de Extranjería válido" data-validation-depends-on="typeDoc" 
		                  data-validation-depends-on-value="CAREX" value="${ document}">
		                </div>
	                </c:when>                    	
               	</c:choose>
                
                <div class="form__input">
                  <label for="name">Nombres</label>
                  <input type="text" name="name" id="name" tabindex="12" maxlength="74" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres">
                </div>
                <div class="form__input">
                  <label for="lastname">Apellidos</label>
                  <input type="text" name="lastname" id="lastname" tabindex="13" maxlength="74" data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos">
                </div>
                <div class="form__select form__select4">
                  <label for="nacionalidad">Nacionalidad</label>
                  <select name="nacionalidad" id="nacionalidad" tabindex="20" data-validation="required" data-validation-error-msg="Seleccionar tu nacionalidad">
<!--                    <option value="" selected>Nacionalidad</option> -->
                  </select>
                </div>
                <div class="form__input form__input-calendar">
                  <label for="dateBirth">Fecha de nacimiento</label>
                  <input type="text" name="dateBirth" tabindex="14" id="dateBirth" maxlength="10" placeholder="dd/mm/aaaa" data-validation="date" data-validation-format="dd/mm/yyyy" data-validation-error-msg="Tu fecha de nacimiento es requerida. Debes ser mayor de 18 años." readonly>
                  <button type="button" id="showCalendar"></button>
                </div>
                <div class="form__section" style="margin-top: 35px; margin-bottom: 5px;">Datos de acceso</div>
<!--                 <div class="form__input"> -->
<!--                   <label for="user">Usuario</label> -->
<!--                   <input type="text" name="user" id="user" autocomplete="new-password" tabindex="15" data-validation="alphanumeric" data-validation-error-msg="Tu usuario es requerido"> -->
<!--                 </div> -->
                <!--  <div style="margin-bottom: 20px;">
					<span class="icon-security-pass"></span><a href="javascript:void(0);"  class='link link__base' onclick="openSecurityPass();">Crea una contraseña segura</a>
				</div> -->
				
                <div class="form__input form__input-password">
                  <label for="password">Contraseña</label>
                  <input type="password" name="password" id="password" autocomplete="new-password" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
                  <button type="button" id="toglePassword"></button>
                  <div class="strength-meter">&nbsp;</div>
                </div>
                <div class="form__section" style="margin-top: 60px">Información actual de contacto</div>
                <div class="form__input">
                  <label for="email">Correo electrónico</label>
                  <input type="text" name="email" id="email" tabindex="17" data-validation="email" data-validation-error-msg="Debes ingresar un correo válido">
                </div>
                <div class="form__input ridisabledInput" style="background-color: #F7F7F7;">
                  <label for="mobilePhone">Número de celular</label>
                  <input type="tel" name="mobilePhone1" id="mobilePhone1" tabindex="18" maxlength="9"  
                  data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="Tu celular es requerido"
                  readonly value="${cel}">
                </div>
                <div class="form__input">
                  <label for="domicilio">Dirección actual</label>
                  <input type="text" name="domicilio" id="domicilio" tabindex="19" maxlength="70" data-validation="required" data-validation-error-msg="Debes ingresar tu dirección actual">
                </div>
                <div class="form__select form__select4">
                  <label for="departamento">Departamento</label>
                  <select name="departamento" id="departamento" tabindex="20" data-validation="required" data-validation-error-msg="Seleccionar tu departamento">
<!--                    <option value="" selected>Departamento</option> -->
                  </select>
                </div>
                <div class="form__select form__select4">
                  <label for="provincia">Provincia</label>
                  <select name="provincia" id="provincia" tabindex="20" data-validation="required" data-validation-error-msg="Seleccionar tu provincia">
<!--                    <option value="" selected>Provincia</option> -->
                  </select>
                </div>
                <div class="form__select form__select4">
                  <label for="distrito">Distrito</label>
                  <select name="distrito" id=distrito tabindex="20" data-validation="required" data-validation-error-msg="Seleccionar tu distrito">
<!--                    <option value="" selected>Distrito</option> -->
                  </select>
                </div>
                <div id='documento_pasap_msg_l' style="margin-bottom: 20px; font-size:13px; color:#00bfff; text-align: justify;"><span class="icon-tarjeta"></span> Para poder cobrar un premio validaremos los datos de tu cuenta contra los datos de tu documento de identidad. <b>¡Asegúrate que sean correctos y que tu documento esté vigente!</b></div>
                <div class="form__check form__check2">
                  <input type="checkbox" name="terms" id="terms" value="1" data-validation="required" data-validation-error-msg="Esta aceptación es requerida">
             <!--      <label for="terms">Acepto los <a href='#' id="agre_tyc" class='link link__base'>Términos y condiciones</a>.</label> -->
                  <label for="terms" style="display: block; text-align: justify;">He leído y acepto los <a href="<%= Constantes.URL_QW%>/terminos-y-condiciones/" target="_blank" class='link link__base'>Términos y condiciones </a>y la <a href="<%= Constantes.URL_QW%>/politica-de-datos-personales/" target="_blank" class='link link__base'>Política de datos personales y fines adicionales</a> 
                  como envío de promociones y noticias, y declaro bajo juramento que no soy una <a href="persona-politicamente-expuesta.html" target="_blank" class='link link__base'>persona políticamente expuesta.</a></label>
                </div>
                
<!--                  <div style="margin-top: 10px;font-size:14px;color:#818181;font-weight: bold">¿Quieres recibir promociones y noticias a tu correo electrónico y/o celular?</div> -->
                  
                <div class="error" id="alert">${alert}</div>
                <div class="form__button">
                  <i></i>
                  <button class="button button__base" type="button" id="resgisterUser" disabled>Registrar</button>
                </div>
                <br>
                <div id="popup-tyc" class="overlay">
							<div class="popup popup-sm">
								<a class="close js-close-modal"  href="#">&times;</a>
								<div class="wrap-modal">
									<jsp:include page="../client/interface-term.jsp"/>
								</div>
							</div>
						</div>
				<div id="popup-message" class="overlay">							
							<div class="popup popup-sm login-error">	
							<a class="close-popup " id="close-popup-message" onclick="closeModal(this)">&times;</a>							
								<div class="main-modal" id="msg-message"></div>
								
							</div>
				</div>
                
              </form>
              <div class="form__button" style="margin: 0 7.69231%; padding: 0 0px;">                  
                  <button class="button button__base" type="button" id="cancelCompleteRegister" 
                  style="background-color:#808080; border: solid 2px #808080; " onclick='goRegistro();'>Cancelar</button>
              </div>
              <br><br><br><br>
            </div>
          </div>
        </div>
      </div>
    </div>
				
			</div>
		</div>

	</div>
	
	<c:if test="${false}">
		<div style="background-color: #e0e1e2; text-align: center;">
		<apt-footer class="ng-isolate-scope">
			<nvs-widget-group-generator layout="vmFooterMenu.layout" class="footer ng-isolate-scope"><!-- ngRepeat: widget_group in ctrl.layout track by $index -->
			
				<div class="widget-group-container ng-scope" ng-repeat="widget_group in ctrl.layout track by $index"><!-- ngRepeat: widget in widget_group.widgets track by $index --><!-- ngIf: !widget_group.is_container --><nvs-widget-list-manager ng-repeat="widget in widget_group.widgets track by $index" ng-class="ctrl.class" ng-if="!widget_group.is_container" directive-name="widget.directive" attributes="widget.settings" class="ng-scope ng-isolate-scope footer"><apt-text-widget settings="attributes" class="ng-scope ng-isolate-scope">
		
				<div style="background-color: #e0e1e2; text-align: center;" class="text-widget" ng-html-compile="vmTextWidget.htmlData">
				<p style="color:#f78e1f;font-size:15px;font-weight:bold;padding-top: 8px;" ng-translate="" translate="footer_terms_and_conditions_title" class="ng-scope ng-isolate-scope">La Tinka S.A.</p>
				<p ng-translate="" translate="footer_terms_and_conditions_text" class="ng-scope ng-isolate-scope" style="font-size: 13px;">Regístrate, juega y diviértete en m.latinka.com.pe</p>
				<p ng-translate="" translate="footer_telephone_number" class="ng-scope ng-isolate-scope" style="font-size: 13px;">Servicio al cliente 513 5502 opción 2</p></div></apt-text-widget></nvs-widget-list-manager><!-- end ngIf: !widget_group.is_container --><!-- end ngRepeat: widget in widget_group.widgets track by $index --><!-- ngIf: widget_group.is_container --></div><!-- end ngRepeat: widget_group in ctrl.layout track by $index -->
				
				<div class="widget-group-container ng-scope" ng-repeat="widget_group in ctrl.layout track by $index"><!-- ngRepeat: widget in widget_group.widgets track by $index --><!-- ngIf: !widget_group.is_container --><nvs-widget-list-manager ng-repeat="widget in widget_group.widgets track by $index" ng-class="ctrl.class" ng-if="!widget_group.is_container" directive-name="widget.directive" attributes="widget.settings" class="ng-scope ng-isolate-scope footer">
				
				<!-- 			<apt-social-media settings="attributes" class="ng-scope ng-isolate-scope"><div class="social-media-container"><ul class="social-media">ngRepeat: item in ctrl.productMenu<li ng-repeat="item in ctrl.productMenu" class="ng-scope"><a href="https://www.facebook.com/teapuestooficial" target="_blank"><i class="fa fa-facebook"></i></a></li>end ngRepeat: item in ctrl.productMenu</ul></div></apt-social-media> -->
				
				</nvs-widget-list-manager><!-- end ngIf: !widget_group.is_container --><!-- end ngRepeat: widget in widget_group.widgets track by $index --><!-- ngIf: widget_group.is_container --></div><!-- end ngRepeat: widget_group in ctrl.layout track by $index -->
				
				<div class="widget-group-container ng-scope" ng-repeat="widget_group in ctrl.layout track by $index"><!-- ngRepeat: widget in widget_group.widgets track by $index --><!-- ngIf: !widget_group.is_container --><nvs-widget-list-manager ng-repeat="widget in widget_group.widgets track by $index" ng-class="ctrl.class" ng-if="!widget_group.is_container" directive-name="widget.directive" attributes="widget.settings" class="ng-scope ng-isolate-scope footer">
				
				<apt-text-widget settings="attributes" class="ng-scope ng-isolate-scope">
				<div style="background-color: #e0e1e2; text-align: center;" class="text-widget" ng-html-compile="vmTextWidget.htmlData"><img style="width: 90%;" src="https://assets.mybetarena.com/teapuesto/payment_methods.png" class="ng-scope"></div></apt-text-widget></nvs-widget-list-manager><!-- end ngIf: !widget_group.is_container --><!-- end ngRepeat: widget in widget_group.widgets track by $index --><!-- ngIf: widget_group.is_container --></div><!-- end ngRepeat: widget_group in ctrl.layout track by $index -->
				
				<div class="widget-group-container ng-scope" ng-repeat="widget_group in ctrl.layout track by $index"> 
					<nvs-widget-list-manager ng-repeat="widget in widget_group.widgets track by $index" ng-class="ctrl.class" ng-if="!widget_group.is_container" directive-name="widget.directive" attributes="widget.settings" class="ng-scope ng-isolate-scope footer">
						<apt-text-widget settings="attributes" class="ng-scope ng-isolate-scope">
							<div class="text-widget" ng-html-compile="vmTextWidget.htmlData">
								<p style="text-align: center;margin:0;font-size:16px;display:inline-block;vertical-align:middle" ng-translate="" translate="footer_bookmaker_copyright_mobile" class="ng-scope ng-isolate-scope">Te Apuesto 2018</p>
								<img style="width:50px;display:inline-block;vertical-align:middle;    margin: auto; padding: 0 10px;" src="https://assets.mybetarena.com/teapuesto/responsible.png" class="ng-scope">
							</div>
						</apt-text-widget>
					</nvs-widget-list-manager><!-- end ngIf: !widget_group.is_container --><!-- end ngRepeat: widget in widget_group.widgets track by $index --><!-- ngIf: widget_group.is_container -->
				</div><!-- end ngRepeat: widget_group in ctrl.layout track by $index -->
			</nvs-widget-group-generator>
		</apt-footer>
		</div>
	</c:if>
	<div id="alert_content" style="display:none">
		<div id="alertModal_content_id" class="confirmModal_content"></div>
		<div class="confirmModal_footer_alert">
			<button type="button" id="btnAlertContent" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">OK</button>
		</div>
	</div>
	<jsp:include page="../include/footer.jsp" />
	
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>

	<script type="text/javascript">
		
		$(document).ready(function(){			
			$('#agre_tyc').click(function(){
				$("div#alert").html("");
        		openModal("#popup-tyc","");
			});
		
			$('#agree_terms').click(function(){
				$('#terms').prop('checked', true);
				$('#terms').removeClass("error");
				$('#terms').addClass("valid");
	
				if ($('#client_lotocard_register_form').isValid({}, {}, false)) {
			      $('#resgisterUser').attr('disabled', false);
			    } else {
			      $('#resgisterUser').attr('disabled', true);
			    }
				closeModal();
			});
			
			renderRegisterForm();
			
			$("#name").on("copy paste", function(){
            	return false;
             });
            $("#lastname").on("copy paste", function(){
             	return false;
             });
			$("#email").on("copy paste", function(){
            	return false;
             });
			$("#domicilio").on("copy paste", function(){
            	return false;
             });

			$("#name , #lastname , #typeDoc , #numberDoc , #dateBirth, #nacionalidad ").on('focusout',function(){
				if($(this).val() != '') datalayerInfoPerso(this);
			}); 
			$("#user , #password ").on('focusout',function(){
				if($(this).val() != '') datalayerDatoAcceso(this);
			});
			$("#email , #mobilePhone, #domicilio, #departamento, #provincia, #distrito ").on('focusout',function(){
				if($(this).val() != '') datalayerInfoContacto(this);
			});
			$("#terms ").on('click',function(){
				datalayerTyC(this);
			});
			$("#promos").on('click',function(){
				datalayerPromo(this);
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
<div id="confirm_content" style="display:none">
		<div id="confirmModal_content_id" class="confirmModal_content">
		</div>
		<div class="confirmModal_footer">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">CERRAR</button>
			<!-- button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">ACEPTAR</button -->
		</div>
</div>
	
	<c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
    	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>">
    	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/bannerCookies.css?v=6">
    	
    	<!-- Banner Cookies -->		
<!-- 		<div id="bannerCookies" class="BannerCookies closeBanner" > -->
<!-- 			<div class="txtBanner"> -->
<!-- 				La Tinka utiliza cookies. Al hacer click en el botón Aceptar, aceptas su uso. -->
<!-- 				 Obtén más información sobre las cookies y cómo evitar su uso en este <span id="enlaceBanner">enlace.</Span>  -->
<!-- 			</div> -->
<!-- 			<button type="button" id="btnBannerCookies" onclick="return false;" class="buttonBanner"> -->
<!-- 				Aceptar -->
<!-- 			</button> -->
<!-- 		</div>			 -->

<div>
	<div id="bannerCookiesModal"></div>
	<div id="bannerCookies" class="ck-font-family ck-banner-cookies" style="text-align: left; letter-spacing: normal;" > 
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
		
		<script type="text/javascript" src="layer-view-script/common/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="layer-view-script/client/bannerCookies.js?v=15"></script>
		
		<!-- fin Banner Cookies -->	
    </c:if>

	<script>
		$('#btn_mobile_registrate').addClass('desactive');
	</script>
</body>
</html>