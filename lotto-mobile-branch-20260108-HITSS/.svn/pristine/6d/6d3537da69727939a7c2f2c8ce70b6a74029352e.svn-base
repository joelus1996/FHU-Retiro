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
	<title>La Tinka : Registro de nuevo cliente</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
	
	<link rel="stylesheet" href="layer-view-style/common/tav2-header.css?v=<%=Constantes.tav2_header_css%>" type="text/css" />
	
	<meta name='description' content="La Tinka móvil, registra un nuevo cliente" />
	
</head>

<body class="orange">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Registro" id="TipoZona">
	<input type="hidden" value="Registro" id="Zona">
	<input type="hidden" value="Activa tu Cuenta" id="SubZona">
	<input type="hidden" id="operatorIdApi" value="${operatorId == '' ? 5586 : operatorId}" >
	<div class="container">
	    <c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
			<jsp:include page="../include/header.jsp" />
			<input type="hidden" id="redirectHome" value="<%=Constantes.eCommerceHome%>">
		</c:if>
		
		<c:if test="${OperatorId eq 5588}">
			<c:if test="${redirectGame ne 'DV'}">
				<input type="hidden" id="redirectHome" value="<%=Constantes.tav2GameProviderCloseUrl%>">
			</c:if>
			<c:if test="${redirectGame eq 'DV'}">	
				<input type="hidden" id="redirectHome" value="<%=Constantes.ddvvGameProviderCloseUrl%>">
			</c:if>
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
			<input type="hidden" id="redirectHome" value="<%=Constantes.lapollaGameProviderCloseUrl%>">
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
		
		<input type="hidden" id="celhidden" value="<c:out value='${cel}'/>">
		<input type="hidden" id="user" value="<c:out value='${user1}'/>">
		<input type="hidden" id="password01" value="<c:out value='${pass}'/>">
		<input type="hidden" id="user-client" value="<c:out value='${user1}'/>">
		<input type="hidden" id="user-client-id" value="<c:out value='${clientIdRegister}'/>">
		<input type="hidden" id="password-client" value="<c:out value='${pass}'/>">
		<input type="hidden" name="urlRedirect5588" id="urlRedirect5588" value="<c:out value='${urlRedirect5588}' />">	
		<input type="hidden" name="urlRedirect5587" id="urlRedirect5587" value="<c:out value='${urlRedirect5587}' />">
		<input type="hidden" name="operatorId" id="operatorId" value="<c:out value='${OperatorId}' />">
		<input type="hidden" name="ref" id="ref" value="<c:out value='${ref}' />">		

		<c:if test="${OperatorId ne 5588 and OperatorId ne 5587}">
			<div class="content-wrap">
		</c:if>
		
		<c:if test="${OperatorId eq 5588 or OperatorId eq 5587}">
			<div class="content-wrap" style="padding-top: 0em;">
		</c:if>
			<div class="content">
				
    <div class="ilot">
      <div class="body__content">
        <div class="top-message" id="top-message">
          <div class="content" id="top_message">Ya creaste tu cuenta, ahora debes activarla.</div>
        </div>
        <div class="activate">
          <div class="content">
            <i id="cargando"></i>
            <%
               	HttpSession sesion=request.getSession();
               	String scel=sesion.getAttribute("cel").toString();
               	scel=scel.split(" ")[0];
               	sesion.setAttribute("scel",scel);
            %>
            <div class="activate__content">
              <!-- step 01-->
              <div class="step step-01">
                <h3 class="activate__title">Activa tu cuenta</h3>
                <p class="activate__text">
									Hemos enviado un código a tu celular <strong id="celSMS">
  									${fn:substring(cel, 0, 2)}*****${fn:substring(cel, 7, 9)}
									</strong> para activar tu cuenta.
								</p>
                <form class="form" id="form_activate" autocomplete="off" method="post" data-response-type="jsonp">		
                  <div class="form__label">Por favor revisa tu celular e ingresa el código:</div>
                  <div class="form__code">
                    <div class="form__code-item">
                      <input type="tel" name="code-01" id="code-01" tabindex="31" maxlength="1">
                    </div>
                    <div class="form__code-item">
                      <input type="tel" name="code-02" id="code-02" tabindex="32" maxlength="1">
                    </div>
                    <div class="form__code-item">
                      <input type="tel" name="code-03" id="code-03" tabindex="33" maxlength="1">
                    </div>
                    <div class="form__code-item">
                      <input type="tel" name="code-04" id="code-04" tabindex="34" maxlength="1">
                    </div>
                    <div class="form__code-item">
                      <input type="tel" name="code-05" id="code-05" tabindex="35" maxlength="1">
                    </div>
                  </div>
                  <div class="form__alert" id="msjError"></div> 
                  <div class="form__button">
                    <button class="button button__base" type="submit" id="btactivate" disabled>Activar</button>
                  </div>
                  <div class="form__help"><a href='#' class="link link__base" id="gotoResendCode">¿No recibiste tu código?</a></div>
                </form>
              </div>
              <!-- step 02-->
              <div class="step step-02 hide">
                <h3 class="activate__title">Activa tu cuenta</h3>
                <p class="activate__text">Verifica que tu celular esté correcto y elige un método para enviarte el código.</p>
                
                <form class="form"  id="form_resend" autocomplete="off" data-response-type="jsonp" method="post">
                  <div class="form__input">
                    <label for="telf-sms">Número de celular</label>
                    <c:set var="sCelular" value="${cel}" />
					<c:set var="aCelular" value="${fn:split(sCelular, ' ')}" />
					<c:set var="scel" value="${aCelular[0]}" />
                    <c:if test="${scel == '***'}">
                    	<input readonly type="text" name="telf-sms1" id="telf-sms1" tabindex="18" maxlength="9" value="<c:out value='${cel}'/>" >
                    </c:if>
                    <c:if test="${scel ne '***'}">
                    	<input type="tel" name="telf-sms" id="telf-sms" tabindex="18" maxlength="9" value="<c:out value='${cel}'/>" data-validation="length number" data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="Ingrese su número de celular">
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
                <h3 class="activate__title">¡Felicitaciones!<br />tu cuenta ha sido activada</h3>
                <p class="activate__text">Ahora haz clic en Ingresar y accede a tu cuenta con tu usuario y contraseña</p>
<!--                 <div class="form"> -->
<!--                   <div class="form__button"> -->
<%--                   	<c:if test="${OperatorId ne 5588}"> --%>
<!--                   		<a class="button button__base" href="#" id="lnkInicio" data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - ir a mi cuenta">Ir a Inicio</a><br><br> -->
<!--                   		<a class="button button__outline" href="#" id="lnkCargarSaldo"  data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - cargar saldo">Cargar Saldo</a> -->
<%--                   	</c:if> --%>
<%--                   	<c:if test="${OperatorId eq 5588}"> --%>
<!--                   		<a class="button button__base" href="#" id="lnkInicio" data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - ir a mi cuenta">Ir al juego</a><br><br> -->
<!--                   		<a class="button button__outline" href="#" id="lnkCargarSaldoTA"  data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - cargar saldo">Cargar Saldo</a> -->
<%--                   	</c:if> --%>
<!--                   </div> -->
<!--                 </div> -->
                <p>&nbsp;</p>
              </div>
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
		
				<div style="background-color: #e0e1e2; text-align: center;" class="text-widget" ng-html-compile="vmTextWidget.htmlData"><p style="color:#f78e1f;font-size:15px;font-weight:bold;padding-top: 8px;" ng-translate="" translate="footer_terms_and_conditions_title" class="ng-scope ng-isolate-scope">La Tinka S.A.</p>
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

	<jsp:include page="../include/footer.jsp" />
	    
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>

	<script type="text/javascript">
		
		$(document).ready(function(){
			 renderActivateForm();
		     renderResendCode();
		     $("#gotoResendCode").on('click',function(){
		    	 datalayerResendCode();
			 });
		     
		}); 
		
	</script>

<div id="confirm_content" style="display:none">
		<div id="confirmModal_content_id" class="confirmModal_content">
		</div>
		<div class="confirmModal_footer">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">CERRAR</button>
			<!-- button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">ACEPTAR</button -->
		</div>
</div>


</body>
</html>