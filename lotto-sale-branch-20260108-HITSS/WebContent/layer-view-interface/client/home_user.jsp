<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isAccountSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}"/></c:if>
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
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/themeUser.css?v=5">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/carousel.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jPages.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/MiPerfil.css?v=8">
<!-- <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/mainCollectPrize.css?v=22"> -->
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/restablecerUser.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/premiador.css?v=4">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/bocadilloContrasena.css">
<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
<title>Mi cuenta</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<style>

.tinka-boleto-iframe {
	display: block;
	border: none;
	height: 100vh !important;
	width: 100vw !important;
	position: fixed;
	top: 0;
	left: 0;
	z-index: 999;
	transition: opacity 0.3s ease-in-out;
	opacity: 1;
}
.tinka-boleto-iframe.is-hidden {
	pointer-events: none;
	opacity: 0;
}
</style>
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


	<%@ include file="../include/header.jspf" %>
	
	<div id="mensajeNotificacion">
			
	</div>
		
	<div class="ioverlay" id="modal-pp-informativo">
      <div class="modal is-error">
        <div class="modal__head">¡Ahora es más fácil retirar tus premios de Tinka, Kábala, Ganagol, Gana Diario y Kinelo!</div>
        <div class="modal__boby" style="padding-bottom: 20px;" >  
        	<div id="textoParte1">
        		<ul>
					<li><b>Premios menores a S/10,000:</b> se cargarán automáticamente a tu saldo y los podrás cobrar cuando y como prefieras desde la sección "Retirar premios".</li><br>
					<li><b>Premios desde S/10,000:</b> los podrás cobrar a través de una transferencia bancaria desde la sección "Retirar premios"</li>    	
	        	</ul>
        	</div>
        	<div id="textoParte2" style="display: none;">
        		<ul>
					<li><b>Jugadas Gratis:</b> se abonarán automáticamente como saldo a la sección "Jugadas Gratis" para que puedas jugarlo en cualquier momento.</li><br>
					<li><b>Todos los premios de Kinelo:</b> se cargarán automáticamente a tu saldo y los podrás cobrar desde la sección "Retirar premios"</li>    	
	        	</ul>
        	</div>
        	<div style="text-align: right;" id="opcionParte1">
        		<span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más" onclick="verParte2()">Ver más</span>
        	</div>
        	<div id="opcionParte2" style="display: none;">
        		<div style="text-align: left; margin-top: 24px; margin-left: 23px;" >
        			<span class="mod__text4 is-regresar" style="padding-left: 20px; cursor: pointer;" onclick="verParte1()">Volver</span>
        		</div>
        		<div style="text-align: right;">
        			<span><button class="btn" style="margin-top: 22px; background: #e30613; border: 2px solid #e30613; color: #fff; margin-left: 304px; box-shadow: none; max-width: 150px; height: 30px; border-radius: 17px; cursor: pointer;" onclick="cerrarModalInformativo()">ENTENDIDO</button></span>
        		</div>
        	</div>
        </div>
      </div>
    </div>
	
	<div class="main-content">
		<div class="main-page">
			<input type="hidden" value="Mi Cuenta" id="TipoZona">
			<input type="hidden" value="Mi Cuenta" id="Zona">
			<input type="hidden" value="" id="SubZona">
			<input type="hidden" id="DataClient" value="<c:out value='${DataClient}'/>">
	        <input type="hidden" id="clientBalance" value="<c:out value='${clientBalance}'/>">
	        <input type="hidden" id="estiloTA" value="<c:out value='${estiloTA}'/>">
	        <input type="hidden" id="chargeData" value="<c:out value='${chargeData}'/>">
			<input type="hidden" id="operatorId" value="<c:out value='${OperatorId}'/>">
			<input type="hidden" id="iflexBonoTyC" value="<%=Constants.iflexBonoTyC.toString().trim()%>" />
			<input type="hidden" id="wbBonoTyC" value="<%=Constants.wbBonoTyC.toString().trim()%>" />
			<input type="hidden" id="origenLink" value="<c:out value='${origenLink}'/>">
			<input type="hidden" id="visanetTransaction" value="<c:out value='${visanetTransaction}'/>">
			<input type="hidden" value="<%= Constants.flagPromoBicolor %>" id="flagPromoBicolor">
			<input type="hidden" id="tycPdpInitLogin" value="${tycPdpInitLogin}">
			
			<div class="row">

				<div class="col-12 col-md-8">

			        <div id="account-wrapper" class="account-wrapper">

			        	<div class="head-account">

			        		<div class="row no-gutters">
			        			<div class="col text-left">
			        				<h1>MI CUENTA</h1>
			        			</div>
			        			<div class="col text-right">
			        				<div class="account-balance">
			        					<h4>Saldo: <b>S/ ${requestScope.clientSale.samount}</b></h4>
			        				</div>
			        			</div>
			        		</div>

			        	</div>

			        	<div class="body-account">

				            <div class="tab-item accordion-off" id="tab-item_1" data-hash="yo">
				                <div class="accordion-ico">
				                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_1-2" data-name="Capa 1"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M12.08,12.59h.08a2.29,2.29,0,0,0,1.75-.76,4.54,4.54,0,0,0,.78-3.1,2.53,2.53,0,0,0-1.2-2.25,2.76,2.76,0,0,0-1.33-.35h0a2.76,2.76,0,0,0-1.33.34A2.53,2.53,0,0,0,9.55,8.73a4.54,4.54,0,0,0,.78,3.1,2.28,2.28,0,0,0,1.75.76ZM10.21,8.79h0a1.81,1.81,0,0,1,1.89-2h0a1.81,1.81,0,0,1,1.89,2,0,0,0,0,0,0,0,3.93,3.93,0,0,1-.61,2.59,1.63,1.63,0,0,1-1.28.53h0a1.62,1.62,0,0,1-1.28-.53,4,4,0,0,1-.62-2.59Zm0,0"/><path class="ico-line" d="M17.22,15.65h0s0,0,0-.06a2,2,0,0,0-1.12-2h0A7.16,7.16,0,0,1,14,12.63a.33.33,0,0,0-.38.55,7.73,7.73,0,0,0,2.27,1c.58.21.64.82.66,1.39a.49.49,0,0,0,0,.06,4.52,4.52,0,0,1-.05.77,9.13,9.13,0,0,1-4.37,1,9.18,9.18,0,0,1-4.38-1,4.26,4.26,0,0,1-.05-.77s0,0,0-.06c0-.57.08-1.18.66-1.39a7.79,7.79,0,0,0,2.27-1,.33.33,0,1,0-.38-.55,7.08,7.08,0,0,1-2.06.94h0a2,2,0,0,0-1.12,2,.5.5,0,0,1,0,.06H7a3.8,3.8,0,0,0,.13,1.12.32.32,0,0,0,.13.16,9.38,9.38,0,0,0,4.84,1.19A9.41,9.41,0,0,0,17,16.93a.33.33,0,0,0,.13-.16,4,4,0,0,0,.12-1.12Zm0,0"/></g></g></svg>
				                </div>
				                <div class="title-accordion">MI PERFIL</div>
				                <a href="registro.html#activa-tu-cuenta" class="button-accordion" id="btn-activate">Activar</a>
				                <i></i>
				                <!-- div id="txt-activate" Aún no has activado tu cuenta div-->
				            </div>
				            <div class="tab-content accordion-on" id="content-tab-item_1">
					            <!-- <form name="frm-update-client" id="frm-update-client" action="update-client.html" method="post" data-response-type="json"> -->
					                <div class="head-tab-content group" data-tab="tab-item_1">
					                    <div class="accordion-ico">
					                    	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_1-2" data-name="Capa 1"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M12.08,12.59h.08a2.29,2.29,0,0,0,1.75-.76,4.54,4.54,0,0,0,.78-3.1,2.53,2.53,0,0,0-1.2-2.25,2.76,2.76,0,0,0-1.33-.35h0a2.76,2.76,0,0,0-1.33.34A2.53,2.53,0,0,0,9.55,8.73a4.54,4.54,0,0,0,.78,3.1,2.28,2.28,0,0,0,1.75.76ZM10.21,8.79h0a1.81,1.81,0,0,1,1.89-2h0a1.81,1.81,0,0,1,1.89,2,0,0,0,0,0,0,0,3.93,3.93,0,0,1-.61,2.59,1.63,1.63,0,0,1-1.28.53h0a1.62,1.62,0,0,1-1.28-.53,4,4,0,0,1-.62-2.59Zm0,0"/><path class="ico-line" d="M17.22,15.65h0s0,0,0-.06a2,2,0,0,0-1.12-2h0A7.16,7.16,0,0,1,14,12.63a.33.33,0,0,0-.38.55,7.73,7.73,0,0,0,2.27,1c.58.21.64.82.66,1.39a.49.49,0,0,0,0,.06,4.52,4.52,0,0,1-.05.77,9.13,9.13,0,0,1-4.37,1,9.18,9.18,0,0,1-4.38-1,4.26,4.26,0,0,1-.05-.77s0,0,0-.06c0-.57.08-1.18.66-1.39a7.79,7.79,0,0,0,2.27-1,.33.33,0,1,0-.38-.55,7.08,7.08,0,0,1-2.06.94h0a2,2,0,0,0-1.12,2,.5.5,0,0,1,0,.06H7a3.8,3.8,0,0,0,.13,1.12.32.32,0,0,0,.13.16,9.38,9.38,0,0,0,4.84,1.19A9.41,9.41,0,0,0,17,16.93a.33.33,0,0,0,.13-.16,4,4,0,0,0,.12-1.12Zm0,0"/></g></g></svg>
					                    </div>
					                    <div class="title-accordion">MI PERFIL</div>
					                    <i></i>
					                </div>
					                <div class="mytabs tab-intro" >
					                		<input type="radio" id="tabEditPerfil" name="mytabs" checked="checked">
					                		<label for="tabEditPerfil">Editar Perfil</label>
					                		<div class="tab ilot">
					                		<form class="form"	id="frm-user-update" action="user-update.html"  autocomplete="off" method="post" data-response-type="json">
					                				<div class="ilot-izq">
										                <div class="form__section">Información personal</div>
										                <div class="form__input" oncopy="return false" onpaste="return false" drop="return false" oncut="return false">
										                  <label for="name">Nombres</label>
										                  <input type="text" name="name" id="name" tabindex="10" maxlength="74" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres" >
										                </div>                
										                <div class="form__input">
										                  <label for="ap-paterno">Apellidos</label>
										                  <input type="text" name="ap-paterno" id="ap-paterno" tabindex="11" maxlength="74" data-validation="required" data-validation-error-msg="Debes ingresar tus apellidos" >
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
										                <c:if test="${empty dataClient.ppe}">
										                	<div class="form__input form__select4" id="div-nacionalidad">
											                  <label for="nacionalidad">Nacionalidad</label>
											                  <select name="nacionalidad" id="nacionalidad"  tabindex="14" data-validation="required" data-validation-error-msg="Seleccionar tu nacionalidad">
<!-- 											                      <option value="">Nacionalidad</option>  -->
											                  </select>
											                </div>
											            </c:if>	
										                <c:if test="${not empty dataClient.ppe}">
										                	<input type="text" name="nacionalidad" id="nacionalidad" hidden="">
										                	<div class="form__input">
											                  <label for="tnacionalidad">Nacionalidad</label>		
							  								  <input type="text" name="tnacionalidad" id="tnacionalidad" tabindex="14" data-validation="required" data-validation-error-msg="Seleccionar tu nacionalidad">
											                </div>
											            </c:if>
											            <div id="div_nacionalidad2"></div>
										                <div class="form__input form__input-calendar">
										                  <label for="fechanac">Fecha de nacimiento</label>
<!-- 										                   <input type="text" name="fechanac" tabindex="15" id="fechanac" maxlength="10" placeholder="dd/mm/aaaa" data-validation="date" data-validation-format="dd/mm/yyyy" data-validation-error-msg="Tu fecha de nacimiento es requerida" readonly> -->
										                   <input type="text" name="fechanac" id="fechanac" tabindex="15" data-validation="required" data-validation-error-msg="Tu fecha de nacimiento es requerida" readonly>
										                   <button type="button" id="showCalendar"></button>
										                </div>										                
										                <c:if test="${hiddenUser == false}">
										                	<div class="form__section" >Datos de acceso</div>
										                	<div class="form__input" >
											                  <label for="user-client">Usuario</label>
															  <input type="text" name="user-client" id="user-client" autocomplete="off"  tabindex="16" data-validation="required" data-validation-error-msg="Tu usuario es requerido">
											                </div>
										                </c:if>
									                </div> 
									                <div class="ilot-der" id="contact-information">					                
										                <div class="form__section">Información de contacto</div>
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
						  								  <input type="text" name="domicilio" id="domicilio" tabindex="20" maxlength="70" autocomplete="off" data-validation="required" data-validation-error-msg="Tu dirección actual es requerida">
										                </div>
										                <c:if test="${empty dataClient.ppe}">
										                	<div class="form__input form__select4" id="div-departamento">
											                  <label for="departamento">Departamento</label>
											                  <select name="departamento" id="departamento"  tabindex="21" data-validation="required" data-validation-error-msg="Seleccionar tu departamento">
<!-- 											                      <option value="">Departamento</option>  -->
											                  </select>
											                </div>
											                <div class="form__select4" id="div-provincia">
											                  <label for="provincia">Provincia</label>
			                  								  <select name="provincia" id="provincia"  tabindex="22" data-validation="required" data-validation-error-msg="Seleccionar tu provincia">
<!-- 											                      <option value=" "></option>  -->
											                  </select>
											                </div>
											                <div class="form__select4" id="div-distrito">
											                  <label for="distrito">Distrito</label>
			                  								  <select name="distrito" id="distrito"  tabindex="23" data-validation="required" data-validation-error-msg="Seleccionar tu distrito">
<!-- 											                      <option value=" "></option>  -->
											                  </select>
										                	</div>
										                </c:if>	
										                <c:if test="${not empty dataClient.ppe}">
										                	<input type="text" name="departamento" id="departamento" hidden="">
										                	<div class="form__input">
											                  <label for="departamento">Departamento</label>		
							  								  <input type="text" name="tdepartamento" id="tdepartamento" tabindex="21" data-validation="required" data-validation-error-msg="Seleccionar tu departamento">
											                </div>
											                <input type="text" name="provincia" id="provincia" hidden="">
										                	<div class="form__input">
											                  <label for="provincia">Provincia</label>		
							  								  <input type="text" name="tprovincia" id="tprovincia" tabindex="22" data-validation="required" data-validation-error-msg="Seleccionar tu provincia">
											                </div>
											                <input type="text" name="distrito" id="distrito" hidden="">
										                	<div class="form__input">
											                  <label for="distrito">Distrito</label>		
							  								  <input type="text" name="tdistrito" id="tdistrito" tabindex="23" data-validation="required" data-validation-error-msg="Seleccionar tu distrito">
											                </div>
										                </c:if>	
										                
										                
<!-- 										                  <label id="PregProm" >¿Quieres recibir promociones y noticias a tu correo electronico y/o celular?</label> -->
<!-- 										                  <br></br> -->
										                
<!-- 										                <div class="form__button"> -->
<!-- 										                  <button class="button button__base_3" type="submit" id="btnUpdatePerfil" disabled>GUARDAR PERFIL</button> -->
<!-- 										                </div> -->
					                				</div>	
					                				<div class="form__section_footer link_ppe" style="padding-left: 5px;">	
					                					<c:if test="${hiddenPpe == false}">
										                	<div class="form__check form__check3">         
												                  <input type="checkbox" name="ppe" id="ppe" value="1" tabindex="24" data-validation="required" data-validation-error-msg="Esta aceptación es requerida">
												                  <label for="ppe">Declaro bajo juramente que no soy una</label> <b><a href="<%=Constants.URL_QW%>/persona-politicamente-expuesta/?origin=i​" target="_blank" class="link link__base">persona políticamente expuesta.</a></b>
										                	</div>
										                </c:if>			                				
						                				
											            <div class="form__check">               
											                  <!--.form__check-box-->
											                  <input type="checkbox" name="confirm" id="confirm" value="Y" tabindex="25">
											                  <label for="confirm">Quiero recibir promociones y noticias.</label>
											            </div>
										            </div>
<!-- 					                				<div class="ilot-izq"> -->
<!-- 					                					<p></p> -->
<!-- 					                				</div> -->
					                				<div class="ilot-izq">
					                					<div class="form__button">
										                  <button class="button button__base_3" type="submit" id="btnUpdatePerfil" disabled style="padding: 0 0px; width: 100%;">GUARDAR PERFIL</button>
										                </div>
					                				</div>
					                				<div class="form__section_footer">
						                				<span> * Tu número de celular solo podrás actualizarlo una vez. Si es necesario una nueva actualización has uso de tu <b>DERECHO ARCO,</b> <a href="derechos-arco.html">solicítalo aquí</a></span>	
						                			</div>  
						                			<div class="form__section_footer" style="padding-top: 0rem;">
						                				<a href="<%=Constants.URL_QW%>/politica-de-datos-personales/" target="_blank">Infórmate de la Política de Datos Personales</a>
						                			</div>
						                			
						                			
					                			</form>	
					                		</div>
					                		<input type="radio" id="tabUpdatePassword" name="mytabs" >
					                		<label for="tabUpdatePassword">Cambiar contraseña</label>
					                		<div class="  tab ilot">
						                		<form class="form-cambiar-password" id="frm-user-password" action="password-update.html" autocomplete="off" method="post" data-response-type="json">
					                				<div class="row" style="margin-top: 5px;">
						                				<div class="form-group col-sm-6" style="padding-left: 20px;">
						                					<!--  <div  class="control-form link__security_pass" style="text-align: left;">
															 	<span class="icon-security-pass"></span><a href="#​" onclick="openSecurityPass();" class='link link__base'>Crea una contraseña segura</a>
															</div> -->
						                					
						                					<div class="form__input form__input-password" style="margin-bottom: 1.5rem !important; width: 100%; margin-top: 24px;" >
											                  <label for="password-actual">Contraseña actual</label>
											                  <input type="password" name="password-actual" id="password-actual" autocomplete="off" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
											                  <button type="button" class="toglePasswordUpdate"></button>
											                  <div class="strength-meter">&nbsp;</div>
											                </div>
						                				
						                					<div class="form__input form__input-password" style=" width: 100%; margin-bottom: 56px !important;">
											                  <label for="new-password">Nueva contraseña</label>
											                  <input type="password" class="new-password" name="new-password" id="new-password" autocomplete="off" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
											                  <button type="button" class="toglePasswordUpdate"></button>
											                  <div class="strength-meter">&nbsp;</div>
											                </div>
					        				  			
						        				  			<div class="form__input form__input-password" style=" width: 100%; margin-bottom: 56px !important;">
											                  <label for="confirm-password">Confirmar contraseña</label>
											                  <input type="password" class="confirm-password" name="confirm-password" id="confirm-password" autocomplete="off" tabindex="16" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
											                  <button type="button" class="toglePasswordUpdate"></button>
											                  <div class="strength-meter">&nbsp;</div>
											                </div>
					        				  		
					        				  				<div class="form__button" style="text-align: center">
											                  <button  class="button button__base_3" type="submit" id="btnUpdatePassword" disabled>GUARDAR CONTRASEÑA</button>
											                </div>
						                				</div>
						                				<div class="form-group col-sm-6">
			        				  			<!-- <div  class="control-form">
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
												</div> -->
			        				  		</div>
					                				</div>
						                		</form>
					                		</div>
					                		<input type="radio" id="tabAutoControl" name="mytabs" >
					                		<label for="tabAutoControl">Autocontrol</label>
					                		<div class="tab ilot" style="padding-top: 1rem;">
					                			<div class="msg-control">
					                			    <div class="msg-control-title">TE AYUDAMOS A ESTABLECER TUS L&Iacute;MITES</div>
					                				<span class="msg-control-podras">Podrás gestionar de forma responsable tus actividades de juego en tu cuenta. Antes de configurar tus límites, por favor, lee cuidadosamente los siguientes términos y condiciones.</span>
					                			</div>
				                                <div class="inner-content group">
				                                    <section id="money-control" class="bounds">
				                                        <div class="icon"><label for="soles">soles</label></div>
				                                        <div class="msg-control-subtitle">L&iacutemite de gasto mensual:</div>
				                                        <p class="instruction">Establece un monto máximo que puedes gastar cada mes en tus actividades de juego.</p>
				                                        <form id="frm-define-money" action="define-limit.html" method="post" data-response-type="json">
				                                            <div class="request">
					                                            <span class="msg-control-soles"><label for="soles">Soles:</label></span>
					                                            <input   class="is-numeric" type="text" name="soles" id="soles" maxlength="7"  required>
																<button  type="submit"  >Guardar</button>
				                                            </div>
				                                        </form>
				                                        <div class="response" id="respuesta-monto">
				                                            <p>Has establecido tu límite en <span id="money-control-message" >S/. 500 el 01/04/2013 12:34pm</span></p>
				                                        </div>	
				                                        
				                                        <form class="frm-desactivar-limites"  id="frm-disable-monto"  action="define-limit.html" method="post" data-response-type="json">
															<div style="text-align: left; margin-top: 1.4rem; margin-left: 10px; margin-bottom: 15px;"> 
																<button id="frm-boton-disable-monto" type="submit" style="color:#e30613;font-weight: bold;cursor: pointer;border:none; text-decoration: underline; padding-left: 0px;" >Desactivar límite</button>
															</div>
														</form>
				                                        
				                                    </section>
				                                    <section id="time-control" class="bounds">
				                                        <div class="icon">horas</div>
				                                        <div class="msg-control-subtitle">Límite de tiempo diario</div>
				                                        <p class="instruction">Define la cantidad máxima de horas que puedes estar conectado a nuestra web.<br/><br/></p>
				                                        <form id="frm-define-time" action="define-limit.html" method="post" data-response-type="json">
				                                            <div class="request">
				                                                <span class="msg-control-soles"><label for="">Horas:</label></span>
				                                                <select name="hours" id="hours">
				                                                    <option selected="true" disabled="disabled" value="">Seleccione</option>
			                                                    </select>
				                                                <button type="submit"  >Guardar</button> 
				                                            </div>
				                                        </form>
				                                        
				                                        <div class="response" id="respuesta-hours">
	                                            					<p>Has establecido tu límite en <span id="time-control-message" >4 horas el 01/01/2013 12:34pm</span></p>
	                                       				</div>
				                                        
				                                        <form class="frm-desactivar-limites" id="frm-disable-hours"  action="define-limit.html" method="post" data-response-type="json">
															<div style="text-align: left; margin-top: 1.4rem; margin-left: 10px; margin-bottom: 15px;"> 
																<button id="frm-boton-disable-hours" type="submit" style="color:#e30613;font-weight: bold;cursor: pointer;border:none; text-decoration: underline;padding-left: 0px;" >Desactivar límite</button>
															</div>
														</form>
														
				                                    </section>
				                                    
				                                    <section id="autoexclusion-control" class="bounds2">
				                                        <div >
				                                        	<img class="img-visanet" style=" width: 40px;" src="layer-view-image/client/time.png" >
				                                        </div>
				                                        <div class="container-autoexclusion">
				                                        	<div class="msg-autoexclusion-subtitle">Autoexclusión</div>
					                                        <p class="instruction" style="width: 100% !important;">Establece la autoexclusión de tiempo indefinido para la recarga y compra de los juegos.<br/><br/></p>
					                                        <form  id="frm-define-autoexclusion" action="define-limit.html" method="post" data-response-type="json">
					                                            <div class="request">
					                                            	<input type="hidden" id="value-autoexclusion" value="1">
					                                                <button type="submit"  >Establecer</button> 
					                                            </div>
					                                        </form>
					                                        
					                                        <div class="response" id="respuesta-autoexclusion">
					                                            <p>Has establecido tu límite de autoexlusión<span id="autoexclusion-control-message" >S/. 500 el 01/04/2013 12:34pm</span></p>
					                                        </div>
					                                        
					                                        <form  class="frm-desactivar-limites" id="frm-disable-autoexlusion" class="boton-desactivar-limite" action="define-limit.html" method="post" data-response-type="json">
																<div style="text-align: left; margin-top: 0.5rem;"> 
																	<button type="submit" style="color:#e30613;font-weight: bold;cursor: pointer;border:none; text-decoration: underline; padding-left: 0px;" >Desactivar límite</button>
																</div>
															</form>
				                                        </div> 
				                                    </section>
				                                    
				                                    
				                                </div>
				                                <div class="terms">
				                                    <div class="msg-control-tyctitle">
				                                    <p class="no-upper"><b>Términos y Condiciones de Autocontrol</b></p>
				                                    </div>
				                                    <ul class="condition-list">
				                                        <li><p class="no-upper">
				                                        	Dispones de tres opciones de autocontrol, pero únicamente puedes elegir solo una de ellas a la vez: </br>
				                                        	<b>1. Límite de gasto mensual:</b> Si eliges esta opción podrás consumir hasta el monto límite que establezcas. La contabilización del gasto se reiniciará automáticamente el primer día de cada mes calendario, independientemente de cuando lo hayas configurado. Si deseas cambiar el monto o elegir el límite de tiempo diario, debes hacerlo antes del fin del mes en curso para que se aplique el cambio en el siguiente mes.​</p>
				                                        </li>
				                                        
				                                        <li><p class="no-upper"><b>2. Límite de tiempo diario:</b> Si eliges esta opción podrás jugar únicamente el tiempo diario establecido. Si cierras tu sesión antes de alcanzar el límite y luego vuelves a iniciar sesión podrás seguir jugando hasta que alcances dicho límite, en caso superes el tiempo ya no podrás jugar ese día y deberás esperar hasta el día siguiente.</p></li>
				                                        <li><p class="no-upper"><b>3. Autoexclusión indefinida:</b> No podrás jugar ni recargar saldo desde el momento que configures esta opción, pero esta opción no te impedirá retirar tus premios ganados.</p></li>
				                                        
				                                        <li><p class="no-upper"><b>Ten en cuenta que:</b></p></li>
				                                        
				                                        <li><p class="no-upper"><b>-</b>Una vez alcanzado el límite de tiempo diario o de gasto mensual no podrás realizar más apuestas o jugar en tu cuenta hasta que empiece el nuevo día o mes según sea el caso.</p></li>
				                                        <li><p class="no-upper"><b>-</b>Puedes cambiar o desactivar tus límites de autocontrol una vez cada 24 horas. </p> </li>
				                                        
				                                        <li><p class="no-upper">Si necesitas más información sobre nuestros sistemas de autocontrol y juego responsable, contacta nuestro servicio de atención al cliente al 5135502, opción 2.</p></li>
				                                    </ul>
				                                    <div class="msg-control-conoce"><p><b>Conoce tus límites y juega de manera responsable. Tu bienestar es nuestra prioridad.</b></p></div>
				                                </div>
							
					                		</div>
					                	</div> 
					            <!-- </form> -->
					        </div>
				            <div class="tab-item accordion-off" id="tab-item_2" data-hash="premios">
				                <div class="accordion-ico">
				                	<img src="./layer-view-image/v2/premios-orange.svg?v=1" alt="" />
				                </div>
				                <div class="title-accordion">RETIRAR MIS PREMIOS</div>
				                <i></i>
				            </div>
				            <div id="content-tab-item_2" class="tab-content accordion-on">
				                <div class="head-tab-content group" data-tab="tab-item_2">
				                    <div class="accordion-ico">
				                    	<img src="./layer-view-image/v2/premios.svg?v=2" alt="" />
				                    </div>
				                    <div class="title-accordion">RETIRAR MIS PREMIOS</div>
				                    <i></i>
				                </div>
				                <div class="tab-intro" style="min-height: auto;"></div>
				            </div>
				            <input id="hdPrizeRowSelected" type="hidden"/>
				            <div class="tab-item accordion-off" id="tab-item_3" data-hash="jugadas">
				                <div class="accordion-ico">
				                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M16,19.45a.35.35,0,0,1-.25-.1l-.71-.71-.7.7a.36.36,0,0,1-.49,0l-.7-.7-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.77-.77a.51.51,0,0,1-.15-.37V6.07a.51.51,0,0,1,.15-.37l.76-.76a.36.36,0,0,1,.49,0l.65.65.65-.65a.36.36,0,0,1,.49,0l.65.65L12,4.94a.36.36,0,0,1,.49,0l.65.65.7-.7a.36.36,0,0,1,.49,0l.7.7.71-.71A.34.34,0,0,1,16,4.79a.35.35,0,0,1,.24.09l.82.82a.51.51,0,0,1,.15.37v12.1a.51.51,0,0,1-.15.37l-.82.82A.35.35,0,0,1,16,19.45Zm-1-1.41a.35.35,0,0,1,.24.1l.46.46a.36.36,0,0,0,.5,0l.44-.44V6.07l-.44-.44a.36.36,0,0,0-.5,0l-.46.46a.36.36,0,0,1-.49,0l-.45-.45a.36.36,0,0,0-.25-.1.35.35,0,0,0-.25.1l-.45.45a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.38.38V18.16l.38.38a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.45.45a.36.36,0,0,0,.5,0l.45-.45A.34.34,0,0,1,15.07,18Z"/><path class="ico-line" d="M9.68,8.62a.26.26,0,1,1,0-.53h2.7a.26.26,0,0,1,0,.53Z"/><path class="ico-line" d="M9.68,11.16a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"/><path class="ico-line" d="M9.68,13.7a.26.26,0,1,1,0-.53H13.4a.26.26,0,1,1,0,.53Z"/><path class="ico-line" d="M9.68,16.24a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"/></g></g></svg>
				                </div>
				                <div class="title-accordion">ÚLTIMAS JUGADAS</div>
				                <i></i>
				            </div>
				            <div id="content-tab-item_3" class="tab-content accordion-on">
				                <div class="head-tab-content group" data-tab="tab-item_3" onclick="hideDatepicker()">
				                    <div class="accordion-ico">
				                    	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M16,19.45a.35.35,0,0,1-.25-.1l-.71-.71-.7.7a.36.36,0,0,1-.49,0l-.7-.7-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.77-.77a.51.51,0,0,1-.15-.37V6.07a.51.51,0,0,1,.15-.37l.76-.76a.36.36,0,0,1,.49,0l.65.65.65-.65a.36.36,0,0,1,.49,0l.65.65L12,4.94a.36.36,0,0,1,.49,0l.65.65.7-.7a.36.36,0,0,1,.49,0l.7.7.71-.71A.34.34,0,0,1,16,4.79a.35.35,0,0,1,.24.09l.82.82a.51.51,0,0,1,.15.37v12.1a.51.51,0,0,1-.15.37l-.82.82A.35.35,0,0,1,16,19.45Zm-1-1.41a.35.35,0,0,1,.24.1l.46.46a.36.36,0,0,0,.5,0l.44-.44V6.07l-.44-.44a.36.36,0,0,0-.5,0l-.46.46a.36.36,0,0,1-.49,0l-.45-.45a.36.36,0,0,0-.25-.1.35.35,0,0,0-.25.1l-.45.45a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.38.38V18.16l.38.38a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.45.45a.36.36,0,0,0,.5,0l.45-.45A.34.34,0,0,1,15.07,18Z"/><path class="ico-line" d="M9.68,8.62a.26.26,0,1,1,0-.53h2.7a.26.26,0,0,1,0,.53Z"/><path class="ico-line" d="M9.68,11.16a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"/><path class="ico-line" d="M9.68,13.7a.26.26,0,1,1,0-.53H13.4a.26.26,0,1,1,0,.53Z"/><path class="ico-line" d="M9.68,16.24a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"/></g></g></svg>
				                    </div>
				                    <div class="title-accordion">ÚLTIMAS JUGADAS</div>
				                    <i></i>
				                </div>
				                <form class="form_jugadas"	method="post" novalidate data-form-ajax>				         			           		
				                <div class="filter_jugadas" style="background-color: #e2e3e5; margin-bottom: 15px;">
				                	<div>
				                	   <div> <p style="margin: 5px 0;padding-left: 8px;"> Filtra tu búsqueda en un rango de 30 días como máximo, hasta con dos años de antigüedad. </p></div>
				                	<div class="form_filter-jugadas">
        								<div class="form_filter-j form__input-jugadas">
            								<label for="fecha_inicio" >Desde</label>
            								<input type="text" id="fecha_inicio" name="fechainicio" tabindex="14" maxlength="10" class="error" style="border-color: rgb(185, 74, 72);" data-validation-has-keyup-event="true" readonly>
       			 						</div>
        								<div class="form_filter-j form__input-jugadas">  
            								<label for="fecha_fin">Hasta</label>
            								<input type="text" id="fecha_fin" name="fechafin" maxlength="10"  class="fecha-input" tabindex="15" readonly>
        								</div>
        								<button class="form_filter-j btn button_jugadas" type="submit" id="btsubmi-jugadas">Buscar</button>
    								</div>
				                	</div>
								</div>
  								</form>
  								<div class="ajax-loader" style="margin-bottom: 15px; position: relative; top: 0%; display:none;"></div>
				                <div class="tab-intro"></div>
				                <div class="no-data-jugadas"></div>
				            </div>
				            <div class="tab-item accordion-off" id="tab-item_4" data-hash="saldo">
				                <div class="accordion-ico">
				                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M9.5,16.72c-1.79,0-3.18-.55-3.83-2.16l1.38-.72a2.5,2.5,0,0,0,2.47,1.39c1,0,2-.36,2-1.32s-.87-1.17-2-1.29c-1.79-.21-3.45-.69-3.45-2.66,0-1.81,1.78-2.55,3.4-2.56a3.55,3.55,0,0,1,3.45,1.74l-1.32.68a2.52,2.52,0,0,0-2.08-1c-1.23,0-1.82.51-1.82,1.17s.9,1,2,1.1c1.83.23,3.54.7,3.54,2.8S11.46,16.72,9.5,16.72Zm5.38.65H13.6L17,8.81h1.29Z"/></g></g></svg>
				                </div>
				                <div class="title-accordion">CARGAR SALDO</div>
				                <i></i>
				            </div>
				            <div id="content-tab-item_4" class="tab-content accordion-on">
				                <div class="head-tab-content group" data-tab="tab-item_4">
				                    <div class="accordion-ico">
				                    	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M9.5,16.72c-1.79,0-3.18-.55-3.83-2.16l1.38-.72a2.5,2.5,0,0,0,2.47,1.39c1,0,2-.36,2-1.32s-.87-1.17-2-1.29c-1.79-.21-3.45-.69-3.45-2.66,0-1.81,1.78-2.55,3.4-2.56a3.55,3.55,0,0,1,3.45,1.74l-1.32.68a2.52,2.52,0,0,0-2.08-1c-1.23,0-1.82.51-1.82,1.17s.9,1,2,1.1c1.83.23,3.54.7,3.54,2.8S11.46,16.72,9.5,16.72Zm5.38.65H13.6L17,8.81h1.29Z"/></g></g></svg>
				                    </div>
				                    <div class="title-accordion">CARGAR SALDO</div>
									<i></i>
				                </div>
				                <div class="tab-intro" style="min-height: 0px !important;"></div>
				            </div>
				            <div class="tab-item accordion-off" id="tab-item_5" data-hash="movimientos">
				                <div class="accordion-ico">
				                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M6.74,12.11A.24.24,0,0,0,7,11.87,2.59,2.59,0,0,1,9.56,9.28h5.65v2.11L18.43,9,15.21,6.7V8.81H9.56A3.06,3.06,0,0,0,6.5,11.87.24.24,0,0,0,6.74,12.11Zm8.94-4.48,2,1.42-2,1.42Z"/><path class="ico-line" d="M18,12.34a.24.24,0,0,0-.24.24,2.59,2.59,0,0,1-2.59,2.59H9.56V13.06L6.34,15.4l3.22,2.34V15.64h5.65a3.06,3.06,0,0,0,3.06-3.06A.24.24,0,0,0,18,12.34ZM9.09,16.82l-2-1.42,2-1.42Z"/></g></g></svg>
				                </div>
				                <div class="title-accordion">MOVIMIENTOS</div>
				                <i></i>
				            </div>
				            <div id="content-tab-item_5" class="tab-content accordion-on">
				                <div class="head-tab-content group" data-tab="tab-item_5">
				                    <div class="accordion-ico">
				                    	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M6.74,12.11A.24.24,0,0,0,7,11.87,2.59,2.59,0,0,1,9.56,9.28h5.65v2.11L18.43,9,15.21,6.7V8.81H9.56A3.06,3.06,0,0,0,6.5,11.87.24.24,0,0,0,6.74,12.11Zm8.94-4.48,2,1.42-2,1.42Z"/><path class="ico-line" d="M18,12.34a.24.24,0,0,0-.24.24,2.59,2.59,0,0,1-2.59,2.59H9.56V13.06L6.34,15.4l3.22,2.34V15.64h5.65a3.06,3.06,0,0,0,3.06-3.06A.24.24,0,0,0,18,12.34ZM9.09,16.82l-2-1.42,2-1.42Z"/></g></g></svg>
				                    </div>
				                    <div class="title-accordion">MOVIMIENTOS</div>
				                    <i></i>
				                </div>
				           		<div class="formfilter"	method="post" novalidate data-form-ajax>				         			           		
				                <div class="filter" style="background-color: #e2e3e5; margin-bottom: 15px;">
				                	
				                	<div>
				                	   <div> <p style="margin: 5px 0;padding-left: 8px;">Filtra tu búsqueda en un rango de 30 días como máximo, hasta con dos años de antigüedad.</p> </div>
					                	<div class="form-movimientos">
	        								<div class="form__filter form__input-filtro">
	            								<label for="filterfechainicio" >Desde</label>
	            								<input type="text" id="filterfechainicio" name="fechainicio" tabindex="14" maxlength="10" placeholder="dd/mm/aaaa" data-validation-format="date" data-validation-format="dd/mm/yyyy" class="error" style="border-color: rgb(185, 74, 72);" data-validation-has-keyup-event="true" readonly>
	       			 						</div>
	        								<div class="form__filter form__input-filtro">  
	            								<label for="filterfechafin">Hasta</label>
	            								<input type="text" id="filterfechafin" name="fechafin" maxlength="10" placeholder="dd/mm/aaaa" data-validation-format="dd/mm/yyyy" class="fecha-input" tabindex="15" readonly>
	        								</div>
	        								<button class="form__filter btn button_filter" type="submit" id="btsubmit">Buscar</button>
	    								</div>
				                	</div>
								</div>
  								</div>
  								<div class="ajax-loader" style="margin-bottom: 15px; position: relative; top: 0%; display:none;"></div>
				                <div class="tab-intro"></div>
				                <div class="no-data-movimientos"></div>
				            </div>
				            <div class="tab-item accordion-off" id="tab-item_6" data-hash="movimientobono">
				                <div class="accordion-ico">
				                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M18.35,10.85a.49.49,0,0,0-.27-.84l-3.55-.52a.49.49,0,0,1-.37-.27L12.56,6a.49.49,0,0,0-.89,0L10.09,9.22a.49.49,0,0,1-.37.27L6.17,10a.49.49,0,0,0-.27.84l2.57,2.51a.49.49,0,0,1,.14.44L8,17.33a.49.49,0,0,0,.72.52l3.18-1.67a.49.49,0,0,1,.46,0l3.18,1.67a.49.49,0,0,0,.72-.52l-.61-3.54a.49.49,0,0,1,.14-.44Zm-3.28,3,.58,3.38-3-1.59a1.07,1.07,0,0,0-1,0l-3,1.59.58-3.38a1.07,1.07,0,0,0-.31-.95L6.41,10.55l3.39-.49a1.07,1.07,0,0,0,.81-.59L12.12,6.4l1.52,3.07a1.07,1.07,0,0,0,.81.58l3.39.49-2.45,2.39A1.07,1.07,0,0,0,15.07,13.89Z"/></g></g></svg>
				                </div>
				                <div class="title-accordion">MOVIMIENTO DE BONO (TE APUESTO)</div>
				                <div id="panel-off-saldo-bono" class="saldo-bono">Bonos Te Apuesto: S/</div>
				                <i></i>
				            </div>
				            <div id="content-tab-item_6" class="tab-content accordion-on">
				                <div class="head-tab-content group" data-tab="tab-item_6">
				                    <div class="accordion-ico">
				                    	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M18.35,10.85a.49.49,0,0,0-.27-.84l-3.55-.52a.49.49,0,0,1-.37-.27L12.56,6a.49.49,0,0,0-.89,0L10.09,9.22a.49.49,0,0,1-.37.27L6.17,10a.49.49,0,0,0-.27.84l2.57,2.51a.49.49,0,0,1,.14.44L8,17.33a.49.49,0,0,0,.72.52l3.18-1.67a.49.49,0,0,1,.46,0l3.18,1.67a.49.49,0,0,0,.72-.52l-.61-3.54a.49.49,0,0,1,.14-.44Zm-3.28,3,.58,3.38-3-1.59a1.07,1.07,0,0,0-1,0l-3,1.59.58-3.38a1.07,1.07,0,0,0-.31-.95L6.41,10.55l3.39-.49a1.07,1.07,0,0,0,.81-.59L12.12,6.4l1.52,3.07a1.07,1.07,0,0,0,.81.58l3.39.49-2.45,2.39A1.07,1.07,0,0,0,15.07,13.89Z"/></g></g></svg>
				                    </div>
				                    <div class="title-accordion">MOVIMIENTO DE BONO (TE APUESTO)</div>
				                    <div id="panel-on-saldo-bono" class="saldo-bono">Bonos Te Apuesto: S/</div>
				                    <i></i>
				                </div>
				                <div class="tab-intro"></div>
				            </div>
							<div class="tab-item accordion-off" id="tab-item_7" data-hash="movimientootro">
				                <div class="accordion-ico">
				                	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M18.35,10.85a.49.49,0,0,0-.27-.84l-3.55-.52a.49.49,0,0,1-.37-.27L12.56,6a.49.49,0,0,0-.89,0L10.09,9.22a.49.49,0,0,1-.37.27L6.17,10a.49.49,0,0,0-.27.84l2.57,2.51a.49.49,0,0,1,.14.44L8,17.33a.49.49,0,0,0,.72.52l3.18-1.67a.49.49,0,0,1,.46,0l3.18,1.67a.49.49,0,0,0,.72-.52l-.61-3.54a.49.49,0,0,1,.14-.44Zm-3.28,3,.58,3.38-3-1.59a1.07,1.07,0,0,0-1,0l-3,1.59.58-3.38a1.07,1.07,0,0,0-.31-.95L6.41,10.55l3.39-.49a1.07,1.07,0,0,0,.81-.59L12.12,6.4l1.52,3.07a1.07,1.07,0,0,0,.81.58l3.39.49-2.45,2.39A1.07,1.07,0,0,0,15.07,13.89Z"/></g></g></svg>
				                </div>
				                <div class="title-accordion">JUGADAS GRATIS</div>
				                <div id="panel-off-saldo-otro" class="saldo-otro"></div>
				                <i></i>
				            </div>
				            <div id="content-tab-item_7" class="tab-content accordion-on">
				                <div class="head-tab-content group" data-tab="tab-item_7">
				                    <div class="accordion-ico">
				                    	<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><rect class="ico-body" width="24.24" height="24.24" rx="12.12" ry="12.12"/><path class="ico-line" d="M18.35,10.85a.49.49,0,0,0-.27-.84l-3.55-.52a.49.49,0,0,1-.37-.27L12.56,6a.49.49,0,0,0-.89,0L10.09,9.22a.49.49,0,0,1-.37.27L6.17,10a.49.49,0,0,0-.27.84l2.57,2.51a.49.49,0,0,1,.14.44L8,17.33a.49.49,0,0,0,.72.52l3.18-1.67a.49.49,0,0,1,.46,0l3.18,1.67a.49.49,0,0,0,.72-.52l-.61-3.54a.49.49,0,0,1,.14-.44Zm-3.28,3,.58,3.38-3-1.59a1.07,1.07,0,0,0-1,0l-3,1.59.58-3.38a1.07,1.07,0,0,0-.31-.95L6.41,10.55l3.39-.49a1.07,1.07,0,0,0,.81-.59L12.12,6.4l1.52,3.07a1.07,1.07,0,0,0,.81.58l3.39.49-2.45,2.39A1.07,1.07,0,0,0,15.07,13.89Z"/></g></g></svg>
				                    </div>
				                    <div class="title-accordion">JUGADAS GRATIS</div>
				                    <div id="panel-on-saldo-otro" class="saldo-otro"></div>
				                    <i></i>
				                </div>
				                <div class="tab-intro"></div>
				            </div>
				            <!--  
				            <div class="tab-item accordion-off" id="tab-item_8" data-hash="movimientopromo" style="${estiloTA}">
				                <div class="accordion-ico">
				                	<img id="idImage1" src="./layer-view-image/v2/img-ta01.svg" alt="" width="24" height="24" />
				                </div>
				                <div class="title-accordion title-promo"></div>
				                <div id="panel-off-tickets-promo" class="tickets-promo"></div>
				                <i></i>
				            </div>
				            
				            <div id="content-tab-item_8" class="tab-content accordion-on" style="${estiloTA}">
				                <div class="head-tab-content group" data-tab="tab-item_8">
				                    <div class="accordion-ico">
					                	<img id="idImage2" src="./layer-view-image/v2/img-ta02.svg" alt="" width="24" height="24" />
					                </div>
				                    <div class="title-accordion title-promo"></div>
				                    <div id="panel-on-tickets-promo" class="tickets-promo"></div>
				                    <i></i>
				                </div>
				                <div class="tab-intro"></div>
				            </div>
				            -->
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
	        
	        
	         <!--  Desarrollo copa en tu casa DRUIZ no tocar
	        <div id="popup-copacasa-nivel" class="overlay">
						<div class="popup popup-sm-copacasa">
							<a class="close-copa js-close-modal" href="#">&times;</a>
								<div class="wrap-modal">
									<div class="gana-copa-header">
										<img class="img-logo-teapuesto-popup" src="layer-view-image/game/copaentucasa/logo-teapuesto.gif">
										<div class="descripcion-copa-casa">
											<span>¡GANA CON</span><br>
											<span>LA COPA EN TU CASA!</span>
										</div>
									</div>
								
									<div id= "nivel-copa-casa" class="gana-copa-footer-nivel">
										
									</div>
							</div>
						</div>
			</div> -->
			
			
			<!--  Desarrollo copa bicolor en tu casa DRUIZ no tocar-->
		<%--	        <div id="popup-copacasa-nivel" class="overlay">
				<div class="popup popup-sm-copacasa">
					<a class="close-copa js-close-modal" href="#">&times;</a>
					<div class="wrap-modal">
						<img src="layer-view-image/game/copabicolor/img-cabecera-popup.png" style="display: block;">
						<div id= "nivel-copa-casa" class="gana-copa-footer-nivel" style="background-color: #007c37"></div>
					</div>
				</div>
			</div>
--%>	         
        </div>
	</div>
	<%
	String appArea = String.valueOf(ConnectionFactory.operationProperty("applicationArea","SALE")).toString().trim().toLowerCase();
	%>
	<c:if test="<%=appArea.equals(\"production\")%>">
		<iframe
		class="tinka-boleto-iframe is-hidden"
		id="tinkaBoletoIframe"
		title="Boleto Digital Tinka"
		src="https://jugadas.latinka.com.pe/t/boleto"		
		allowfullscreen="true"
		allowpaymentrequest="true"
		allowtransparency="true"
		border="0"
		frameborder="0"
		style="width: 100vw; height: 100vh; min-width: 100%; overflow: hidden;"
		></iframe>
	</c:if>
	<c:if test="<%=!appArea.equals(\"production\")%>">
		<iframe
		class="tinka-boleto-iframe is-hidden"
		id="tinkaBoletoIframe"
		title="Boleto Digital Tinka"
		src="https://ticket-digital.seekdev.com/t/boleto"		
		allowfullscreen="true"
		allowpaymentrequest="true"
		allowtransparency="true"
		border="0"
		frameborder="0"
		style="width: 100vw; height: 100vh; min-width: 100%; overflow: hidden;"
		></iframe>
	</c:if>
	
	
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.mask.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery-migrate-3.1.0.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.validator.js"></script>
<script type="text/javascript" src="layer-view-script/common/jPages.js"></script>
<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
<script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
<script type="text/javascript" src="layer-view-script/client/main.js?v=<%=Constants.client_main_js%>"></script>
<script type="text/javascript" src="layer-view-script/client/script_user.js?v=44"></script>
<script type="text/javascript" src="layer-view-script/client/selfControl.js?v=9"></script>
<script type="text/javascript" src="layer-view-script/game/tinka/iframeResizer.min.js"></script>
<script type="text/javascript" src="layer-view-script/game/tinka/tinkaexpress-iframe-ticket.js"></script>


<%@ include file="../include/footer.jspf" %>
<script type="text/javascript">

var promosSorteo = {
	"popup-juegaddvv-nivel" : false,
	"popup-avionPeru-nivel" : false
};

function verParte2(){
	$("#textoParte1").css("display","none");
	$("#textoParte2").css("display","block");
	$("#opcionParte1").css("display","none");
	$("#opcionParte2").css("display","inline-flex");
}

function verParte1(){
	$("#textoParte2").css("display","none");
	$("#textoParte1").css("display","block");
	$("#opcionParte2").css("display","none");
	$("#opcionParte1").css("display","block");
}

function cerrarModalInformativo(){
	$('#modal-pp-informativo').fadeOut(250);
	getLastNotifications();
}

/* Desarrollo copa bicolor en tu casa DRUIZ no tocar*/
$('.popup .js-close-modal').click(function(event){
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
});

$(document).on("click", "#btn_desktop_ver_jugadas_copa", function (event) {	 
	 window.location.href = 'premiazoganagol_resultados.html';   
	});

//TEAPUESTO HOME
$(document).delegate('#btn_desktop_teapuesto_home', 'click', function () {
	//toIflex();
	toTAV2();
});

$(document).delegate('.btnEnlaceGanagol', 'click', function () {
	window.location.href = 'juega-ganagol.html'; 
});

function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
}

function toTAV2() {
	$.ajax({
        type: 'post',
        url: 'tav2-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}

function cerrarMensajeNotificacion(){
	$('#mensajeNotificacion').fadeOut(250);
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function validarPromosActivarEvalPopupInformativo(promo){

	promosSorteo[promo] = true;

	let enciendePopup = true;
	
	for(var clave in promosSorteo){
		if( promosSorteo[clave] !== true ){
			enciendePopup = false;
			continue;
		}
	}
	
	if( !enciendePopup ) return;

	evalPopupInformativo();
}

function evalPopupInformativo(){
		
	$.ajax({
		type: "POST",
		url: "evalPopupInformativo.html",
		dataType: "json",
		async: false,
	})
    .done(function(data) {
    	if(data.status=='OK'){
		    $('#modal-pp-informativo').fadeIn(350);
		}else{
			getLastNotifications();
		}
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
    	console.log(textStatus||' '||errorThrown);
    });
}

function getLastNotifications(){
	$.ajax({
        type: "POST",
        url: "getLastNotifications.html",
        dataType: "json",
        async: false
	})
	.done(function(data) {
		var htmlNotificaciones = '';
		if(data.status=="OK"){
			$.each(JSON.parse(data.listaNotificaciones), function( key,value ) {
				if(value.type!=undefined && value.type!=null){
					htmlNotificaciones+='<div class="mensaje-notificacion">'; 
					htmlNotificaciones+='<div style="width: 0; height: 0; position: absolute; bottom: 80px; left: 281px; border-right: 28px solid transparent; border-top: 28px solid transparent; border-left: 30px solid transparent; border-bottom: 37px solid white;"></div>';
					htmlNotificaciones+='<span onclick="cerrarMensajeNotificacion()" style="float: right; color: green; margin-top: 25px; margin-right: 5px; font-size: 12px; cursor: pointer;">X</span>';
					htmlNotificaciones+='<div style="margin-top: 20px; margin-bottom: 5px; box-shadow: 0px 2px 5px grey; padding: 10px; background: white; padding-top: 20px;">';
					htmlNotificaciones+='<div style="float: left;">';
					if(value.type!=4){
						htmlNotificaciones+='<svg viewBox="0 0 18 18"  xmlns="http://www.w3.org/2000/svg" style="width: 13px; height: 13px;">';
						htmlNotificaciones+='<path d="M16.418 4.219h-2.146c.332-.441.529-.99.529-1.582A2.64 2.64 0 0 0 12.164 0c-.876 0-1.521.314-2.032.987-.428.564-.74 1.351-1.132 2.345-.392-.994-.704-1.78-1.132-2.345C7.358.314 6.712 0 5.836 0a2.64 2.64 0 0 0-2.637 2.637c0 .593.197 1.14.529 1.582H1.582C.71 4.219 0 4.929 0 5.8v1.054c0 .688.44 1.274 1.055 1.492v8.071c0 .872.71 1.582 1.582 1.582h12.726c.873 0 1.582-.71 1.582-1.582V8.347A1.585 1.585 0 0 0 18 6.855V5.801c0-.873-.71-1.582-1.582-1.582zm-6.45-.466c.808-2.05 1.115-2.698 2.196-2.698.872 0 1.582.71 1.582 1.582 0 .872-.71 1.582-1.582 1.582h-2.38l.184-.466zM5.836 1.055c1.081 0 1.388.648 2.196 2.698l.184.466h-2.38c-.872 0-1.582-.71-1.582-1.582 0-.873.71-1.582 1.582-1.582zm1.055 15.89H2.637a.528.528 0 0 1-.528-.527v-7.98h4.782v8.507zm0-9.562H1.582a.528.528 0 0 1-.527-.528V5.801c0-.291.236-.528.527-.528h5.309v2.11zm3.164 9.562h-2.11V5.273h2.11v11.672zm5.836-.527c0 .29-.237.527-.528.527H11.11V8.437h4.782v7.981zm1.054-9.563c0 .291-.236.528-.527.528h-5.309v-2.11h5.309c.29 0 .527.237.527.528v1.054z" fill="#e02120"/>';
						htmlNotificaciones+='</svg>';
					}else{
						htmlNotificaciones+='<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 23 23" fill="none" stroke="#e02120" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">';
						htmlNotificaciones+='<circle cx="12" cy="12" r="10"></circle><line x1="12" y1="16" x2="12" y2="12"></line><line x1="12" y1="8" x2="12.01" y2="8"></line>';
						htmlNotificaciones+='</svg>';
					}
					htmlNotificaciones+='</div>';
					if(value.type==1){
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='<b>¡Felicidades tienes premios!</b><br>';
						htmlNotificaciones+='<span>Revisa los movimientos de tu cuenta y, si aún tienes saldo disponible, recuerda que puedes seguir jugando o retirarlo cuando quieras.</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
						htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
						htmlNotificaciones+='</div>';
					}else if(value.type==2){
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='<b>¡Felicidades tienes un premio mayor de '+value.game+'!</b><br>';
						htmlNotificaciones+='<span>Cóbralo antes de que venza el plazo de cobro. Hasta '+value.expirationDate+'</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
						htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
						htmlNotificaciones+='</div>';	
					}else if(value.type==3){
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='Tu retiro N° '+value.requestNumber+' ya está en tu cuenta '+value.requestType+'<br>';
						htmlNotificaciones+='<span>Revisa los movimientos de tu cuenta '+value.requestType+' o tu historial de retiros</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
						htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
						htmlNotificaciones+='</div>';
					}else if(value.type==4){
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px; color:#E02120;">';
						htmlNotificaciones+='<b>Tu contraseña expira en 5 días</b></p>';
						htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
						htmlNotificaciones+='<span>Actualizalo ahora, ingresando a Mi Perfil</span><br>';
						htmlNotificaciones+='</p>';
						htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
						htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
						htmlNotificaciones+='</div>';
					}
					htmlNotificaciones+='</div>';
					htmlNotificaciones+='</div>';
				}
				return false;
			});
		}
		$("#mensajeNotificacion").html(htmlNotificaciones);
	})
	.fail(function( jqXHR, textStatus, errorThrown ) {
    	
    });
}

const setNumeric = function () {
    $('.is-numeric').numeric({
        allowMinus: false,
        allowPlus: false,
        allowThouSep: false,
        allowDecSep: false
    });

    // Añadir la validacion para no permitir solo el número 0
    $('.is-numeric').on('input', function() {
        var value = $(this).val();
        
        // Si el valor es '0', limpiar el campo
        if (value === '0') {
            $(this).val('');
        }

        // Si el valor no es un numero, eliminar los caracteres no numéricos
        if (!/^\d*$/.test(value)) {
            $(this).val(value.replace(/[^0-9]/g, ''));
        }
    });
};

//Campos para autocontrol
var showDisable = "";
var typeLimit = "";
var valueLimit = "";
var dateLimit = "";

//obtener data de autocontrol
var getDataSelfControl = function(){
	
	$.ajax({
		type: "POST",
		url: "getDataSelfControl.html",
		dataType: "json",
		async: false,
	})
    .done(function(data) {

    	console.log("getDataSelfControl");


    	showDisable=data.showDisable;
    	typeLimit=data.typeLimit;
    	valueLimit=data.valueLimit;
    	dateLimit=data.dateLimit;
    	
    	 console.log("showDisable:"+ showDisable );
    	 console.log("type:"+ typeLimit );
    	 console.log("valueLimit:"+ valueLimit.toString() );
    	 if (typeLimit == 'MONTO'){
    		 var solesVal = valueLimit.toLocaleString('es-MX');
    		 $('#money-control-message').text('S/ '+  solesVal  + ' el ' + dateLimit);
    		 $('#respuesta-monto').addClass('received-msg-autocontrol');
    		//mostrar u ocultar los boton de desactivar limite
    		 if(showDisable=='OK'){
    			 console.log("se muestra boton");
    			 $('#frm-disable-monto').removeClass('frm-desactivar-limites');
    		 }

         }else if (typeLimit == 'HOURS'){
        	 $('#time-control-message').text( valueLimit + ' horas desde el ' + dateLimit);
        	 $('#respuesta-hours').addClass('received-msg-autocontrol');
        	//mostrar u ocultar los boton de desactivar limite
    		 if(showDisable=='OK'){
    			 console.log("se muestra boton");
    			 $('#frm-disable-hours').removeClass('frm-desactivar-limites');
    		 }

         }else if (typeLimit == 'AUTOEXCLUSION'){
        	 $('#autoexclusion-control-message').text(  ' desde el ' + dateLimit);
        	 $('#respuesta-autoexclusion').addClass('received-msg-autocontrol');
        	//mostrar u ocultar los boton de desactivar limite
    		 if(showDisable=='OK'){	 
             	$('#frm-disable-autoexlusion').removeClass('frm-desactivar-limites');
    		 }
        	 
         }
         

    	
    })
    .fail(function(jqXHR, textStatus, errorThrown) {
    	console.log(textStatus||' '||errorThrown);
    });
}

var parametroPP="";

		$(document).ready(function(){
		if ($("#tycPdpInitLogin").val() == "1") {
			 // Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
		  	 // es una function que se realizará en caso no tenga docs pendientes de confirmacion(solo después del login)
		  	 mainValidatePendingsDocsForAproval('documentReadyFunctionsHomeUser');
		} else {
			documentReadyFunctionsHomeUser();
		}
	});

	function documentReadyFunctionsHomeUser(){
			$('#frm-user-update').bind("cut copy paste", function(e) {
				e.preventDefault();
		    });
						 
			var idsession = $("#clientId").val();
			var flagPromoBicolor = $("#flagPromoBicolor").val();
			renderUpdateDataForm();
			renderUpdatePasswordForm();
			renderFormFields();
			MiPerfilLink();

			setNumeric();
			getDataSelfControl();
			
			if(idsession !== ''){
				$.ajax({
			        type: "POST",
			        url: "verificar_promocion.html",
			        dataType: "json",
			        async: false,
			        success: function (data) {

					var clientepromoBicolor = data.flagPromo;
					console.log('participa en la promo : ' +clientepromoBicolor);

						if(clientepromoBicolor == true && flagPromoBicolor == '1'){
							let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
							setTimeout(activarPopupBicolorNivel , timeUp) ; 
						}				
			        }
			    });								   				
			}	
			
			var redirige = getUrlParameter('redirige'); 
		  	if(redirige=="premios"){
		      parametroPP="";
		  	  $("#tab-item_2").trigger("click");
			  $("#popUpPaymentPrize").trigger("click");
		  	}else if(redirige=="historial"){
		  	  parametroPP="historial"
		  	  $("#tab-item_2").trigger("click");
			  $("#popUpPaymentPrize").trigger("click");
			  $("#historialRetiros").trigger("click");
		  	}else{
		  		parametroPP="";
		  	}
		  	//Llamar a url de TA para cerrar sesion
// 		  	var flagTA=true;
// 			if(flagTA){
// 				$.ajax({
// 			        type: 'post',
// 			        url: 'tav2-session.html',
// 			        dataType: 'json'
// 				}).done(function(d) {
// 					if(d.message=="OK") {
// 						fetch(d.redireccion+"?authToken="+d.authToken,"_parent")
// 					    .then(response => {
// 					      // Manejar la respuesta
// 					    })
// 					    .catch(error => {
// 					      // Manejar errores
// 					    });
// 					} 
// 			    });
// 			}
	}
		  	
	window.addEventListener("message", function(event) {
	    if (event.data === "documentReadyFunctionsHomeUser") {
	    	documentReadyFunctionsHomeUser(); 
	    }
		});

	

	function MiPerfilLink(){
// 		var autocontrol = sessionStorage.getItem('autocontrol');
// 		if(autocontrol != null ){
// 			sessionStorage.removeItem('autocontrol');
// 			$("#tabAutoControl").prop("checked",true);
// 		}
		$("#tab-item_1").on("click",function(){
			$("#tabEditPerfil").prop("checked",true);
		});
	}
		
	function activarPopupBicolorNivel(){

		$.ajax({
	        type: "POST",
	        url: "game_premiazoganagol_resultados_popup.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
	        	var totalTickets = data.nivel;
	        	var puntaje = data.puntajeNivel;
	        	var result = "";
	        	var nivel="";
	        	var activarPremio = data.activarPremio;
	        	var listTickets= data.totalTickets;
	        	var ticketsWin= data.ticketsWin;
	        	console.log('el total de tickets es: '+totalTickets);
	        	console.log('el nivel es: ' +puntaje);

	        	if(activarPremio == 1){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #f0c607; ">¡GANASTE S/ 4 DE SALDO AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:#ffffff;">con tus tickets: '+ticketsWin+'</p></div>';
				}else if (activarPremio == 0){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #ffffff; ">Tus jugadas WEB participan automáticamente</p><p class="jugadas-popup-descripcion2" style="color: #f0c607">¡Son S/ 6,000 en saldo al instante!</p></div>';
				}
				
	        	if(totalTickets >=0 && totalTickets<=9){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Calichin_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CALICHÍN</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;"class="button-copa1" style="width:133px;margin-right: 5px;" >Ver mis jugadas</button>' +
					'<button type="button" onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;" >Juega desde S/ 3</button>';
  
					result = result + result2;
					
				}else if(totalTickets >=10 && totalTickets<=29){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Amateur_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">AMATEUR</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;"class="button-copa1" style="width:133px;margin-right: 5px;" >Ver mis jugadas</button>' +
					'<button type="button" onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 3</button>';
 
					result = result + result2;
					
				}else if(totalTickets >=30 && totalTickets<=59){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Crack_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CRACK</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;" class="button-copa1" style="width:133px;margin-right: 5px;">Ver mis jugadas</button>' +
					'<button type="button"  onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 3</button>';
 
					result = result + result2;
					
				}else if(totalTickets >=60){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Leyenda_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">LEYENDA</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;" class="button-copa1" style="width:133px;margin-right: 5px;">Ver mis jugadas</button>' +
					'<button type="button"  onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 3</button>';
					 
					result = result + result2;										
				}
								
				$("#nivel-copa-casa").html(result);
					//if(puntaje != 0){
						checkcount_copa();
					//}
				
				function GetCookie (name) {
					var arg = name + "=";
					var alen = arg.length;
					var clen = document.cookie.length;
					var i = 0;
					while (i < clen) {
					var j = i + alen;
					if (document.cookie.substring(i, j) == arg)
					return getCookieVal (j);
					i = document.cookie.indexOf(" ", i) + 1;
					if (i == 0) break;
					}
					return null;
					}
					function SetCookie (name, value) {
					var argv = SetCookie.arguments;
					var argc = SetCookie.arguments.length;
					var expires = (argc > 2) ? argv[2] : null;
					var path = (argc > 3) ? argv[3] : null;
					var domain = (argc > 4) ? argv[4] : null;
					var secure = (argc > 5) ? argv[5] : false;
					document.cookie = name + "=" + escape (value) +
					((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
					((path == null) ? "" : ("; path=" + path)) +
					((domain == null) ? "" : ("; domain=" + domain)) +
					((secure == true) ? "; secure" : "");
					}
					function DeleteCookie (name) {
					var exp = new Date();
					exp.setTime (exp.getTime() - 1);
					var cval = GetCookie (name);
					document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
					}

					function amt(){
					var count_copa_desktop = GetCookie('count_copabicolor_desktop')
					if(count_copa_desktop == null) {
					SetCookie('count_copabicolor_desktop','1')
					return 1
					}
					else {
					var newcount = parseInt(count_copa_desktop) + 1;
					DeleteCookie('count_copabicolor_desktop')
					SetCookie('count_copabicolor_desktop',newcount,exp)
					return count_copa_desktop
					}
					}
					function getCookieVal(offset) {
					var endstr = document.cookie.indexOf (";", offset);
					if (endstr == -1)
					endstr = document.cookie.length;
					return unescape(document.cookie.substring(offset, endstr));
					}

					function checkcount_copa() {
					var count_copa_desktop = GetCookie('count_copabicolor_desktop');
					if (count_copa_desktop == null) {
						var expDays = 2;
						localStorage.removeItem("exp_copabicolor_desktop_nivel");
						var exp = new Date();
						exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
						//exp.setTime(exp.getTime() + (expDays*5*60*1000));
						count_copa_desktop=1;
						SetCookie('count_copabicolor_desktop', count_copa_desktop, exp);
						localStorage.setItem("exp_copabicolor_desktop_nivel", exp);
						openModal("#popup-copacasa-nivel", "");
						

					}
					else {
					count_copa_desktop++;
					var auxExp = localStorage.getItem("exp_copabicolor_desktop_nivel");
					try{
						SetCookie('count_copabicolor_desktop', count_copa_desktop, auxExp);
					}catch (e) {
						console.log(e.message);
						
					}			
					
					}
					}
				

	        	
	        }
	   });	
		
		
	}


</script>
<script type="text/javascript">
	onChangeTerms = function () {
    if ($('#frm-user-password').isValid({}, {}, false)) {
    	if($('#new-password').val()===$('#confirm-password').val()){
        	$('#btnUpdatePassword').attr('disabled', false);
        } else{
        	$('#btnUpdatePassword').attr('disabled', true);
        }
    } else {
    	$('#btnUpdatePassword').attr('disabled', true);      
    }
  };
  $('#new-password, #confirm-password').on('input', onChangeTerms);
</script>

<script type="text/javascript" src="layer-view-script/client/locationData.js?v=2"></script>

</body>
</html>