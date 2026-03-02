<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@page import="com.google.gson.JsonObject"%>
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
						<div class="configuracion-edit" oncontextmenu="return false" onselectstart="return false" ondragtart="return false">
							<a class="volver"   href="client_account_show_information.html" >volver</a>
							<div class="tab ilot">
		                		<form class="form"	id="frm-user-update" action="user-update.html"  autocomplete="off" method="post" data-response-type="json">
	                				<div class="ilot-centro">
						                <div class="form__section">Información personal</div>
						                <div class="form__input">
						                  <label for="name">Nombres</label>
						                  <input type="text" name="name" id="name" maxlength="74" tabindex="10" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres" >
						                </div>                
						                <div class="form__input">
						                  <label for="ap-paterno">Apellidos</label>
						                  <input type="text" name="ap-paterno" id="ap-paterno"  maxlength="74" tabindex="11" data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos" >
						                </div> 
						                <div class="form__select">
						                  <label for="document-type">Tipo de documento</label>
						                  <select name="document-type" id="document-type" tabindex="12" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
						                    <!--option(value='') Seleccionar-->
						                    <option value="DNI" >DNI</option>
						                    <option value="PASAP">Pasaporte</option>
						                    <option value="CAREX">Carnet de Extranjería</option>
						                  </select>
						                </div>
						                <input type="hidden" value="" id="notvalidate">
						                <div class="form__input form__optional show">
						                  <label for="document-number">Número de documento</label>
						                  <input type="text" name="document-number" tabindex="13" id="document-number" maxlength="8" data-validation="length number" data-validation-length="8" data-validation-error-msg="Ingresa un DNI válido" data-validation-depends-on="document-type" data-validation-depends-on-value="DNI">
						                </div>
						                <div class="form__input form__optional">
						                  <label for="document-number-pasap">Número de documento</label>
						                  <input type="text" name="document-number-pasap" tabindex="13" id="document-number-pasap" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="Ingresa un Pasaporte válido" data-validation-depends-on="document-type" data-validation-depends-on-value="PASAP">
						                </div>
						                <div class="form__input form__optional">
						                  <label for="document-number-carex">Número de documento</label>
						                  <input type="text" name="document-number-carex" tabindex="13" id="document-number-carex" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="Ingresa un Carnet de Extranjería válido" data-validation-depends-on="document-type" data-validation-depends-on-value="CAREX">
						                </div>
						                <% 
						                	String jppe=((JsonObject)request.getAttribute("DataClient")).get("ppe").isJsonNull()==false?((JsonObject)request.getAttribute("DataClient")).get("ppe").getAsString():null;
						                    request.setAttribute("xppe", jppe);
						                %>
						                <c:if test="${empty xppe}">
							                <div class="form__select2 form__select4" id="div-nacionalidad">
									                  <label for="nacionalidad">Nacionalidad</label>
									                  <select name="nacionalidad" id="nacionalidad" tabindex="14"  data-validation="required" data-validation-error-msg="debes ingresar tu nacionalidad">
<!-- 									                      <option value=" ">Nacionalidad</option>  -->
									                  </select>
									        </div>
									    </c:if>	
								        <c:if test="${not empty xppe}">
								        	<input type="text" name="nacionalidad" id="nacionalidad" hidden="">
								        	<div class="form__input">
							                  <label for="tnacionalidad">Nacionalidad</label>
							                  <input type="text" name=tnacionalidad id="tnacionalidad" tabindex="14" data-validation="required" data-validation-error-msg="Seleccionar tu nacionalidad" >
							                </div> 
							            </c:if>	
							            <div id="div_nacionalidad2"></div>
						                <div class="form__input form__input-calendar">
						                  <label for="fechanac">Fecha de nacimiento</label>
						                   <input type="text" name="fechanac" tabindex="14" id="fechanac" maxlength="15" placeholder="dd/mm/aaaa" data-validation="date" data-validation-format="dd/mm/yyyy" data-validation-error-msg="Tu fecha de nacimiento es requerida" readonly>
						                   <button type="button" id="showCalendar"></button>
						                </div> 
						                <c:if test="${hiddenUser == false}">
							                <div class="form__section" >Datos de acceso</div>
							                <div class="form__input" >
							                  <label for="user-client">Usuario</label>
							<!--                   <input type="text" name="user-client" id="user-client" autocomplete="new-password" tabindex="15" data-validation="alphanumeric" data-validation-error-msg="El usuario es requerido"> -->
<!-- 											  <input type="text" name="user-client" id="user-client" autocomplete="off"  tabindex="15" data-validation="alphanumeric" data-validation-error-msg="Tu usuario es requerido"> -->
											    <input type="text" name="user-client" id="user-client" autocomplete="off"  tabindex="15" data-validation="required" data-validation-error-msg="Tu usuario es requerido">
							                </div>
						                </c:if>
						                
						                <div class="form__section">Información de contacto</div>						                
						                <div id="contact-information">
						                <div class="form__input">
						                  <label for="email">Correo electrónico</label>
						                  <input type="text" name="email" id="email" autocomplete="off" tabindex="17" data-validation="email" data-validation-error-msg="Debes ingresar un correo válido">
						                </div>
						                <div class="form__input">
						                  <label for="mobile-phone">Número de celular</label>
						                  <input type="text" name="mobile-phone" id="mobile-phone" tabindex="18" maxlength="9" data-validation="length number" data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="Tu celular es requerido">
						                </div>
						                <div class="form__input">
						                  <label for="domicilio">Dirección actual</label>
						                  <input type="text" name="domicilio" id="domicilio" maxlength="70" tabindex="19" data-validation="required" data-validation-error-msg="Debes ingresar tu dirección actual" >
						                </div>  
						                
						                <c:if test="${empty xppe}">
							                <div class="form__select2 form__select4" id="div-departamento">
									                  <label for="departamento">Departamento</label>
									                  <select name="departamento" id="departamento" tabindex="20"  data-validation="required" data-validation-error-msg="debes ingresar tu departamento">
<!-- 									                      <option value=" ">Departamento</option>  -->
									                  </select>
									        </div>
									        <div class="form__select2 form__select4" id="div-provincia">
									                  <label for="provincia">Provincia</label>
									                  <select name="provincia" id="provincia" tabindex="21" data-validation="required" data-validation-error-msg="debes ingresar tu provincia">
<!-- 									                      <option value=" "></option>  -->
									                  </select>
									        </div>
									        <div class="form__select2 form__select4" id="div-distrito">
									                  <label for="distrito">Distrito</label>
									                  <select name="distrito" id="distrito" tabindex="22" data-validation="required" data-validation-error-msg="debes ingresar tu distrito">
<!-- 									                      <option value=" "></option>  -->
									                  </select>
									        </div>
								        </c:if>	
								        <c:if test="${not empty xppe}">
								        	<input type="text" name="departamento" id="departamento" hidden="">
								        	<div class="form__input">
							                  <label for="tdepartamento">Departamento</label>
							                  <input type="text" name=tdepartamento id="tdepartamento" tabindex="20" data-validation="required" data-validation-error-msg="Seleccionar tu departamento" >
							                </div> 
							                <input type="text" name="provincia" id="provincia" hidden="">
							                <div class="form__input">
							                  <label for="tprovincia">Provincia</label>
							                  <input type="text" name="tprovincia" id="tprovincia" tabindex="21" data-validation="required" data-validation-error-msg="Seleccionar tu provincia" >
							                </div>
							                <input type="text" name="distrito" id="distrito" hidden="">
							                <div class="form__input">
							                  <label for="tdistrito">Distrito</label>
							                  <input type="text" name="tdistrito" id="tdistrito"  tabindex="22" data-validation="required" data-validation-error-msg="Seleccionar tu distrito" >
							                </div>
								        </c:if>
								        </div>
								        <c:if test="${hiddenPpe == false}">
									        <div class="form__check form__check3">
							                  <input type="checkbox" name="ppe" id="ppe" value="1" data-validation="required" data-validation-error-msg="Esta aceptación es requerida">						             
							                  <label for="ppe">Declaro bajo juramento que no soy una </label><a href="persona-politicamente-expuesta.html" target="_blank" class='link link__base'>persona políticamente expuesta.</a>	
							                </div>
						                </c:if>	
<!-- 						                <div style="margin-top: 10px;font-size: 14px;color: #818181;font-weight: bold;margin-bottom: 0.5rem;">¿Quieres recibir promociones y noticias a tu correo electronico y/o celular?</div> -->
						                <div class="form__check">               
						                  <!--.form__check-box-->
						                  <input type="checkbox" name="confirm" id="confirm">
						                  <label for="confirm">Quiero recibir promociones y noticias.</label>
						                </div>
						                <div class="form__button">
						                  <button class="button button__base_3" type="submit" id="btnUpdatePerfil" disabled>GUARDAR PERFIL</button>
						                </div>
		                				<div class="form__footer">
			                				<div class="form__section_footer">
				                				<span> * Tu número de celular solo podrás actualizarlo una vez. Si es necesario una nueva actualización has uso de tu <b>DERECHO ARCO,</b> <a href="derechos-arco.html" target="_blank">solicítalo aquí</a></span>	
				                			</div>  
				                			<div class="form__section_footer" style="padding-top: 0rem;">
				                				<a href="<%= Constantes.URL_QW%>/politica-de-datos-personales/" target="_blank">Infórmate de la Política de Datos Personales</a>
				                			</div> 
		                				</div>
		                				
					            	</div> 
					            	<div id="popup-message" class="overlay">							
										<div class="popup popup-sm login-error">	
										<a class="close-popup " id="close-popup-message" onclick="closePopupMessageLoggin()">&times;</a>							
											<div class="main-modal" id="msg-message"></div>											
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
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
	<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" charset="UTF-8" src="layer-view-script/client/clientResponse.js?v=9"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#frm-user-update').bind("cut copy paste", function(e) {
				e.preventDefault();
		    });
		});
		
	</script>
	<script type="text/javascript" src="layer-view-script/client/locationData.js?v=2"></script>
</body>
</html>