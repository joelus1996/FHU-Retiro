<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<!DOCTYPE html>
<html>
<head>
<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
<script>
window.onload = function () {
	try{
		if(document.getElementById("clientId").value){
			dataLayer.splice(0,1,{
				'loginStatus': 'Sesión iniciada',
				'clientid': getClientID(),
				'userID': document.getElementById("clientId").value,
				});
		}
	}catch(e){}
}
</script>
	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta http-equiv="Cache-Control" content="max-age=0" />
  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
  <meta http-equiv="Expires" content="0" />
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
  <meta http-equiv="Pragma" content="no-cache" />
  <meta charset="utf-8">
  <title></title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="layer-view-style/common/tav2-header.css?v=<%=Constantes.tav2_header_css%>" type="text/css" />
  <link rel="stylesheet" href="layer-view-style/game/virtuales/juegaGanaConVirtuales.css?v=2" type="text/css" />
  <style>
  	.popup.popup-standard {
	    height: 446px;
	    width: 338px;
	    display: table;
	    top: 50%;
	    transform: translateY(-50%);
	    background: none;
	    padding: 0px;
	}
	.popup-img-button{
	    display: inline-block;
	    position: relative;
	    height: 446px;
	}
	.home-popup {
	    width: 100%;
	}
	.footer-button {
	    position: absolute;
	    left: 0;
	    right: 0;
	    text-align: center;
	    bottom: 1.4rem;
	}
	.footer-button.accion-1 {
	    bottom: 3rem;
	} 
	.footer-button.accion-2{
		bottom: 1rem;
	} 
	.footer-button button {
	    border-radius: 17px;
	    border: medium none;
	}
  </style>
  <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/bannerCookies.css?v=6">
</head>
<body style="background-color: white !important;" >
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

<% 
    boolean logged = false, agreement = false;
    String user = null; 
    Double saldo = null; 
    Double bono  = null; 
    HttpSession nsession = request.getSession(false);
%>
<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
<input type="hidden" value="Login" id="TipoZona">
<input type="hidden" value="Login" id="Zona">
<input type="hidden" value="Ingresar" id="SubZona">
<input type="hidden" id="operatorIdApi" value="${operatorId == '' ? 5586 : operatorId}" >
  <div class="nvs-header-row nvs-header-0">
  	<c:if test="${OperatorId eq 5588}">
		<div id="logo"><a href="<%= Constantes.tav2GameProviderCloseUrl%>" id="logo-href"></a></div>
		<div id="btn">
			<a href="#" id="register-btn2" class="register-btn2">
			<span>INGRESAR</span>
			</a>
			<input type="hidden" id="redirect558cancel" value="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" />
			<a href="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" id="register-btn" class="register-btn">
			<span >REGÍSTRATE</span>
			</a>
		</div>
	</c:if>
	<c:if test="${OperatorId eq 5587}">
		<div id="logo"><a href="<%= Constantes.lapollaGameProviderCloseUrl%>" id="logo-href"></a></div>
		<div id="btn">
			<a href="#" id="register-btn2" class="register-btn2">
			<span>INGRESAR</span>
			</a>
			<a href="client_lotocard_show_form.html?operatorId=5587&urlRedirect5587=<c:out value='${urlRedirect5587}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" id="register-btn" class="register-btn">
			<span >REGÍSTRATE</span>
			</a>
		</div>
	</c:if>
  </div>
  
  <div class="wrap-body">

    <div class="text-center top-login">
      <h3 class="top-title">Bienvenido</h3>      
    </div>
	<%-- if (logged && agreement)  { --%
    	<div id="user-login" class="body-login">
			<div class="text-center bottom-login">
				<span class="username"><%=user%></span>
			</div>
			<div class="text-center bottom-login" id="loadbalance">
				<img src="layer-view-image/client/img-refresh.gif" alt="Recargar" title="Recargar" width="33" height="33" border="0" style="margin:0 10px 0 0;cursor:pointer;cursor:hand;">
			</div>
			<div class="text-center bottom-login" onClick="window.location.reload();"> <!--  -->
 				<span class="name">SALDO </span><span class="amount">S/ <%=saldo%></span><br/>
 				<span class="name">BONO </span><span class="amount">S/ <%=bono%></span><br/> 				
 				<span class="change"> </span>
			</div>
			<div class="text-center bottom-login">
				<a href="mi-cuenta.html" target="_top" class="button button-block button-orange">MI CUENTA</a>				
				<a href="#" id="btnOut" class="button button-block button-red">SALIR</a>
			</div>
		</div>
    %-- } else { --%>
	    <div id="user-kept" class="text-center bottom-login disabled">
			<div class="text-center bottom-login">
				Estimado cliente, hemos actualizado los t&eacute;rminos y condiciones de nuestra tienda virtual, por lo tanto le invitamos a informarse y aceptar el contenido de los mismos para que pueda continuar usando su cuenta de La Tinka.
			</div>
			<div class="text-center bottom-login">
				<!-- a href="term_condiciones.html" target="_blank" class="lnktyc">Ver t&eacute;rminos y condiciones</a -->
				<a href="#" class="lnktyc">Ver t&eacute;rminos y condiciones</a>
				<div class="text-center bottom-login">
				<input type="checkbox" value="1" id="chkagreement" checked /><label for="chkagreement">Acepto los t&eacute;rminos y condiciones</label>
				<a href="#" id="btnAgree" class="button button-block button-orange">ACEPTAR</a>
				</div>
			</div>
		</div>
    	
    	<div id="user-sms" class="text-center bottom-login disabled">
			<div id = "detailMessage" class="text-center bottom-login">
			<!-- Ingresa el celular registrado en tu cuenta (Ejem: 999112233) o actual&iacute;zalo aqu&iacute;.<br/>Recibir&aacute;s un SMS con un c&oacute;digo de activaci&oacute;n. -->
			<!-- Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS. -->
			Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.
			</div>
			
			<div id="message-sms" class="text-center bottom-login disabled">
				<input type="text" class="form-control" id="user-phone" placeholder="Ingresa tu celular"/>
				<span class="error" id="alertTelfVerify"></span>
				<a href="#" id="btnSendSms" class="button button-block button-orange">ENVIAR SMS</a><br/>
				<!-- a href="#" id="lnkActiveCode" class="tyc-a-text">¿Cuentas con un código SMS activo?</a -->
				<a href="#" id="lnkActiveCode" class="button button-block button-orange">YA TENGO CÓDIGO DE ACTIVACIÓN</a>
			</div>
			
			<div id="message-code" class="text-center bottom-login">
				<input type="number" class="form-control" id="user-code" placeholder="Digita el código"/>
				<span class="error" id="alertCodeVerify"></span>
				<a href="#" id="btnSendCode" class="button button-block button-orange">CONFIRMAR</a><br/>
				<!-- a href="#" id="lnkSendSms" class="tyc-a-text">¿Deseas enviar el código SMS al teléfono?</a -->
				<a href="#" id="lnkSendSms" class="button button-block button-orange">ENVIAR CÓDIGO NUEVAMENTE</a>
			</div>
			
		</div>
		
		<div id="user-mail" class="text-center bottom-login disabled">
			<div id="message-mail" class="text-center bottom-login">
			Hola, hemos verificado que el correo electr&oacute;nico de la cuenta ha sido registrado en otra cuenta. Registra aqu&iacute; un nuevo correo electr&oacute;nico.
			<!-- Hola, hemos verificado que el correo electr&oacute;nico de la cuenta ha sido registrado y activado en otra cuenta de usuario. Registra aqu&iacute; un nuevo correo electr&oacute;nico. -->
			</div>
			<div class="top-column exactr">
				<div class="text-center bottom-login">
				<input type="text" class="form-control" id="user-new-mail" placeholder="Ingresa tu correo"/>
				<a href="#" id="btnUpdateMail" class="button button-block button-orange">ACEPTAR</a>
				</div>
			</div>
		</div>
	
		<div id="user-ibbonus" class="text-center bottom-login disabled"></div>
		<div id="user-rdbonus" class="text-center bottom-login disabled"></div>
	    
	    <div id="user-logout" class="body-login">	
	      <form novalidate action="tav2-login.html" id="form-sign-in" method="post">
			  <!--<div class="form-group">
	          <div class="input-group icon-user">
	            <input id="user" name="user" type="text" class="form-control" placeholder="USUARIO" aria-label="USUARIO" style="font-family: inherit !important;">
	            <div class="invalid-feedback">
	              Invalid field
	            </div>
	            <div class="valid-feedback">
	              Valid field
	            </div>
	          </div>
	        </div>	
	        <div class="form-group">
	          <div class="input-group icon-pass">
	            <input id="password" name="password" type="password" class="form-control"  placeholder="CONTRASEÑA" aria-label="CONTRASEÑA" style="font-family: inherit !important;" maxlength="100" autocomplete="off">
	            <i class="fa fa-key" aria-hidden="true"></i>
	          </div>
	        </div>-->
	        
	         <div class="control-form" id="form-login-user-new" style="margin-top: 10px;">
				<label for="user">Usuario o N° de documento de identidad</label>
				<input type="text" name="user" id="user" data-validation="required" data-validation-error-msg="Debes ingresar tu usuario">
			</div>
							
			<div class="control-form" id="form-login-password-new" style="margin-bottom: 15px;">
				<label for="password">Contraseña</label>
				<input type="password" name="password" id="password" data-validation="required" data-validation-error-msg="Debes ingresar tu contraseña">
				<button class="view-password" type="button" id="toglePassword"></button>
			</div> 
	        
	        
			<input type="hidden" name="channel" value="1" />
			<input type="hidden" id="iflexBonoTyC" value="<%=Constantes.iflexBonoTyC.toString().trim()%>" />
			<input type="hidden" id="wbBonoTyC" value="<%=Constantes.wbBonoTyC.toString().trim()%>" />
			<input type="hidden" name="urlRedirect5588" value="<c:out value='${urlRedirect5588}' />">
			<input type="hidden" name="redirectGame" value="<c:out value='${redirectGame}' />">
			<input type="hidden" name="ref" value="<c:out value='${ref}' />">
			<input type="hidden" value="<%= Constantes.flagPromoTinka %>" id="flagPromoTinka">
			<input type="hidden" value="<%= Constantes.flagPromoHincha %>" id="flagPromoHincha">
			<input type="hidden" name="urlRedirect5587" id="urlRedirect5587" value="<c:out value='${urlRedirect5587}' />">
			
<!-- 			<div style="text-align: center;"> -->
<!--            		<img id="imagen" name="imagen" src="" style="padding-left: 15%; padding-right: 15%; margin-bottom: 1.2em;" width="100%" height="50px" > -->
<!--            		<a id="reload" href="#" style="font-family: inherit !important;">Generar otro código</a> -->
<!--            		<input name="sentCaptcha" id="sentCaptcha" type="text" placeholder="Ingresar código" class="form-control" maxlength="5" style="margin-top: 1.2em; font-family: inherit !important;"> -->
<!--         	</div> -->
			
			 <span class="error" id="alertLogin" style="margin-bottom: 15px;">
	    		<%nsession = request.getSession(false); if(session != null && nsession!=null ) {%>${alertLogin}<%}%>
	    	</span>
        	
	      </form>	

	   
	     <!--<button type="button" id="btnEnter" class="button button-block button-orange" style="font-family: inherit !important; margin-bottom: 1.2em;" >Ingresar</button>--> 
	      <div>
				
				<button class="btn btn-recuperar-password" id="btnEnter">INGRESAR</button><br/>
			</div> 
	    
			<div class="text-center bottom-login">
				<p class="text-sm" style="margin-bottom: 10px;"><span style="font-family: Roboto, sans-serif;font-size:16px;">¿Eres nuevo? </span><a id="client_show_register" style="color: black;font-family: Roboto, sans-serif;font-size:16px;text-decoration: underline;" href="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />">Regístrate aquí</a></p><br>      		
	      		<p class="text-sm" style="margin-bottom: 10px;"><a href="#" target="_top" id="usereminder" style="color: #006a42;font-family: Roboto, sans-serif;font-size:16px;">¿Olvidaste tu usuario?</a></p>
	      		<p class="text-sm" style="margin-bottom: 90px;"><a style="color: #006a42;font-family: Roboto, sans-serif;font-size:16px;" href="#" target="_top" id="pwdreminder">Recupera o cambia tu contrase&ntilde;a</a></p>
	    	</div>
	    </div>
	<%-- } --%>
	
		<div id="popup-bond" class="overlay">
						<div class="popup popup-sm">
							<a class="close js-close-modal" href="#">&times;</a>
							<div class="wrap-modal"></div>
						</div>
		</div>
		
		<footer id="footer">
		
			<!--  Desarrollo copa en tu casa DRUIZ no tocar
			<div id="popup-copacasa-nivel" class="overlay-copa-casa">
							<div id = "popup-scrool-copa-ta" class="popup-copa-casa popup-sm-copacasa margen">
								<a class="close-copa js-close-modal" href="#" style="text-decoration: auto;">&times;</a>
									<div class="wrap-modal">
										<div class="gana-copa-header">
											<img class="img-logo-teapuesto-popup" src="layer-view-image/game/copaentucasa/logo-teapuesto.gif">
											<div class="descripcion-copa-casa">
												<h3>¡GANA CON</h3>
												<h3>LA COPA EN TU CASA!</h3>
											</div>
										</div>
									
										<div id= "nivel-copa-casa" class="gana-copa-footer-nivel">
											
										</div>
								</div>
							</div>
			</div>-->
			
			
			
			
			<!--  Desarrollo copa bicolor en tu casa DRUIZ no tocar-->
			<div id="popup-copacasa-nivel" class="overlay-copa-casa">
							<div id = "popup-scrool-copa-ta" class="popup-copa-casa popup-sm-copacasa margen">
								<a class="close-copa js-close-modal" href="#" style="text-decoration: auto;">&times;</a>
									<div class="wrap-modal">
										<div class="gana-copa-header" style="background-color: #ce061f;">
											<img class="img-logo-teapuesto-popup" src="layer-view-image/game/copabicolor/logo-teapuesto.gif">
											<div class="descripcion-copa-casa">
												<h3>¡GANA CON</h3>
												<h3>LA BICOLOR EN TU CASA!</h3>
											</div>
										</div>
									
										<div id= "nivel-copa-casa" class="gana-copa-footer-nivel">
											
										</div>
								</div>
							</div>
			</div>
			
			<!-- Popup Avion Qatar -->	  
			<div id="popup-avionqatar" class="overlay">
				<div id = "popup-scrool-copa" class="popup popup-sm-avionqatar" style="text-align: center;">
				<a class="close-avionqatar">&times;</a>
					<div class="wrap-modal">
						<img class="home-popup" src="layer-view-image/game/teapuesto/avionQatar/popup_taqatar.png" alt="Apuestas Mundial Qatar 2022 Te Apuesto">
						<button style="background-color: #e30613;top: -87px;position: relative;" type="button" id="btn_home_avion_qatar" onclick="return false;"class="button-avion-qatar-amarillo"  >Infórmate aquí</button>																				
					</div>
				</div>
			</div>
			<div id="popup-avionQatar-nivel" class="overlay">
			<div id = "popup-scrool-copa2" class="popup popup-sm-avionqatar">
				<a class="close-avionqatar">&times;</a>
					<div class="wrap-modal">
						<img src="layer-view-image/game/teapuesto/avionQatar/cabecera_popup.png" alt="Apuestas Mundial Qatar 2022 Te Apuesto" style="display: block;"> 
						<div id= "nivel-avionQatar">
						</div>																		
				</div>
			</div>
		</div>
			<!-- Popup Avion Qatar -->
			
			<!-- Popup Avion Estambul -->	  
			<div id="popup-avionestambul" class="overlay">
				<div id = "popup-scrool-copa" class="popup popup-sm-avionestambul" style="text-align: center;">
				<a class="close-avionestambul">&times;</a>
					<div class="wrap-modal">
						<img class="home-popup" src="layer-view-image/game/teapuesto/avionEstambul/popup-estambul.png" alt="Te Apuesto te lleva a la Final de la Champions 2023">
						<button style="background-color: #e30613;top: -62px;position: relative;" type="button" id="btn_home_avion_estambul" onclick="return false;"class="button-avion-qatar-naranja"  >Infórmate aquí</button>																				
					</div>
				</div>
			</div>
			<div id="popup-avionEstambul-nivel" class="overlay">
			<div id = "popup-scrool-copa2" class="popup popup-sm-avionestambul">
				<a class="close-avionestambul">&times;</a>
					<div class="wrap-modal">
						<img src="layer-view-image/game/teapuesto/avionEstambul/popup-categorias-estambul.png" alt="Te Apuesto te lleva a la Final de la Champions 2023" style="display: block;"> 
						<div id= "nivel-avionEstambul" style="background-color: #d7e2e4;">
						</div>																		
				</div>
			</div>
		</div>
			<!-- Popup Avion Estambul -->
			
			<!-- Popup Avion Peru -->
			<!-- Se comenta solicitado por NNDD 23/05/2024 -->
			<!-- 	  -->
			<div id="popup-avionPeru" class="overlay">
				<div id = "popup-scrool-copa" class="popup popup-sm-avionPeru" style="text-align: center;">
				<a class="close-avionPeru">&times;</a>
					<div class="wrap-modal">
						<img class="home-popup" src="layer-view-image/game/teapuesto/avionPeru/popup-peru.png" alt="Avión del Hincha Eliminatorias 2026">
						<button style="background-color: #e30613; top: -62px;position: relative;background-color: #000000;" type="button" id="btnHomeAvionPeru" onclick="return false;"class="button-avion-qatar-naranja"  >Infórmate aquí</button>																				
					</div>
				</div>
			</div>
			
			<div id="popup-avionPeru-nivel" class="overlay">
				<div id = "popup-scrool-copa2" class="popup popup-sm-avionPeru">
					<a class="close-avionPeru">&times;</a>
						<div class="wrap-modal">
							<img src="layer-view-image/game/teapuesto/avionPeru/popup-categorias-peru.png" alt="Avión del Hincha Eliminatorias 2026" style="display: block;"> 
							<div id= "nivel-avionPeru" style="background-color: #d7e2e4;">
							</div>																		
					</div>
				</div>
			</div>
			<!-- Popup Avion Peru -->
			
			<!-- Popup Juega Gana con Virtuales -->
		
		<div id="popup-juegaGanaVirtuales-nivel" class="overlay">
			<div id = "popup-scrool-copa2" class="popup popup-sm-juegaGanaVirtuales">
				<a class="close-juegaGanaVirtuales js-close-modal" >&times;</a>
				<div class="wrap-modal">
						<img src="layer-view-image/game/virtuales/juegaGanaConVirtuales/popup-categorias-virtuales.png"  alt="Juega Deportes Virtuales" style="display: block;"> 
						<div id= "nivel-juegaGanaVirtuales">
							<div class="posicion-nivel-img-popup">
								<img   class="level-header-copa-casa-popup">
								<div class="desc-nivel-position-popup">
									<span class="tipo-nivel-popup">typeLevel</span><br>
									<span class="tipo-nivel-descripcion-superior-popup">Tienes </span>
									<span class="puntaje-por-nivel-popup">Score</span><br>
									<span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>
									<span class="tipo-nivel-descripcion-popup">de premios mayores</span>
								</div>
							</div>
							<div class="copa-opciones-popup">
								<button type="button" id="btnJuegaGanaDDVVResultados" onclick="return false;" class="button-juegaGanaVirtuales-blanco" style="width:140px;margin-right: 5px;border-color: #e16e1a;">Ver mis puntos</button>
								<button type="button" id="btn_mobile_virtuales_home" onclick="return false;" class="button-juegaGanaVirtuales-naranja" style="width:158px;margin-bottom: 7px;">Juega desde S/ 5</button>
								<p class="jugadas-popup-descripcion" style="color: #e16e1a; ">Tus jugadas WEB participan automáticamente</p>
								<p class="jugadas-popup-descripcion2" style="color: #000000">¡Son S/ 10,000 en saldo al instante!</p>
							</div>
						</div>																		
				</div>
			</div>
		</div>
		
		<!-- Popup Juega Gana con Virtuales -->
			<!-- Popup La Tinka -->	    
		    <div id="popup-tinka" class="overlay-tinka">
			    <div class="popup-tinka popup-sm-tinka margen" style="text-align: center;">
					<a class="close-tinka js-close-modal" href="#">&times;</a>
					<div class="wrap-modal">
						<div class="popup-tinka-footer" style="background-color:#fff;">
							<img class="home-popup" src="layer-view-image/game/tinka/popup_siosi.jpg">
							<button type="button" id="btn_mobile_ingresar_tinka_ta" onclick="return false;"class="button-ingresar" style="background-color:#ce061f;margin-right: 15px;"><a href="#" style="text-decoration: none;color: white;">Juega aquí</a></button>								
						</div>																			
					</div>
				</div>						
			</div>			
		   	<!-- fin popup La Tinka -->
			
			<!-- Popup avion del hincha -->
			<div id="popup-hincha-informate" class="overlay-hincha">
				<div class="popup-hincha popup-sm-hincha margen" style="border-radius: 7px;">
					<a class="close-hincha js-close-modal" href="#">&times;</a>
					<div class="wrap-modal">
						<div class="popup-hincha-footer" style="background-color:#fff;">
							<img class="home-popup" style="border-radius: 7px;" src="layer-view-image/game/aviondelhincha/popup-informate.jpg">
							<button type="button" id="btn_mobile_informate_hincha" onclick="return false;"class="button-informate" style="margin-right: 15px;"><a href="#" style="text-decoration: none;color: white;">INFÓRMATE AQUÍ</a></button>								
						</div>																			
					</div>
				</div>
			</div>
		    <div id="popup-hincha-participa" class="overlay-hincha">
				<div class="popup-hincha popup-sm-hincha margen" style="border-radius: 7px;">
					<a class="close-hincha js-close-modal" href="#">&times;</a>
					<div class="wrap-modal">
						<div class="popup-hincha-footer" style="background-color:#fff;">
							<img class="home-popup" style="border-radius: 7px;" src="layer-view-image/game/aviondelhincha/popup-participa.jpg" alt="tinka">
							<button type="button" id="btn_mobile_participa_hincha_ta" onclick="return false;"class="button-participa" style="margin-right: 15px;"><a href="#" style="text-decoration: none;color: white;">PARTICIPA AQUÍ<img src="layer-view-image/game/aviondelhincha/check.png" style="margin-left: 10px;vertical-align: text-bottom;"></a></button>								
						</div>																			
					</div>
				</div>
			</div>		    
			<!-- fin popup avion del hincha -->
			
			<%@ include file="../../include/popups.jsp" %>
			
			<div id="popup-message" class="overlay">							
				<div class="popup popup-sm login-error">	
				<a class="close-popup " id="close-popup-message" onclick="closeModal(this)">&times;</a>							
					<div class="main-modal" id="msg-message"></div>
					
				</div>
			</div>
			<div id="popup-message-dt" class="overlay">							
				<div class="popup popup-sm login-error" style="background-color: #F2F2F2;">	
				<a class="close-popup " id="close-popup-message-dt" onclick="closeModal(this)">&times;</a>							
					<div class="main-modal" id="msg-message-dt" style="font-family: AllerRegular, Arial, sans-serif;"></div>
					
				</div>
			</div>
			<div id="logo-tinka"></div>
		</footer>
	
  </div>
	<!-- Banner Cookies -->		
<!-- 			<div id="bannerCookies" class="BannerCookies closeBanner" > -->
<!-- 				<div class="txtBanner"> -->
<!-- 					La Tinka utiliza cookies. Al hacer click en el botón Aceptar, aceptas su uso. -->
<!-- 				 	Obtén más información sobre las cookies y cómo evitar su uso en este <span id="enlaceBanner">enlace.</Span> -->
<!-- 				</div> -->
<!-- 				<button type="button" id="btnBannerCookies" onclick="return false;" class="buttonBanner"> -->
<!-- 					Aceptar -->
<!-- 				</button> -->
<!-- 			</div>			 -->

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
			<!-- fin Banner Cookies -->	
</body>
<%-- /*chatbot*/ --%>	
<!-- <script type="application/javascript" charset="UTF-8" src="https://cdn.agentbot.net/core/56512f807294eae4d4093733fc35cd13.js"></script> -->	
<%-- /*fin chatbot*/ --%>
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/jquery-migrate-3.1.0.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/popup_time.js?v=2"></script>
<script type="text/javascript" src="layer-view-script/game/teapuesto/avionQatar/avionQatar-popup_time.js?v=3"  charset="UTF-8"></script>
<script type="text/javascript" src="layer-view-script/game/virtuales/juegaGanaConVirtuales.js?v=2"  charset="UTF-8"></script>
<script type="text/javascript" src="layer-view-script/tav2-header.js?v=15"></script>
<script type="text/javascript" src="layer-view-script/game/tinka/tinka-popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/common/chatbot.js"></script>
<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
<script type="text/javascript" src="layer-view-script/game/aviondelhincha/hincha-popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/common/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="layer-view-script/client/bannerCookies.js?v=15"></script>
<script type="text/javascript" src="layer-view-script/client/analytics.js?v=9"></script>
<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=11"></script>
<script type="text/javascript" src="layer-view-script/game/teapuesto/avionEstambul/avionEstambul-popup_time.js?v=7"  charset="UTF-8"></script>
<script type="text/javascript" src="layer-view-script/game/teapuesto/avionPeru/avionPeru.js?v=5"  charset="UTF-8"></script>
<script>

$(document).ready(function(){	
	$('#user').val('');	
	$('#password').val('');
	 $('#btnEnter').attr('disabled', true);
		renderRegisterForm();
	
	$("#user , #password").on('focusout',function(){
		if($(this).val() != '') datalayerLoginForm(this);
	});
	
	$("#client_show_register , #usereminder , #pwdreminder").on('click',function(){
		datalayerLoginLink(this);
	});
			
});

$(".control-form input").each(function () {
	    var $input = $(this),
	      $parent = $input.parent();

	    if ($input.val() !== '') {
	      $parent.addClass('filled');
	    }

	    $input.on('focus', function () {
	      $parent.addClass('focus filled');
	    });

	    $input.on('blur', function () {
	      if ($input.val() === '') {
	        $parent.removeClass('focus filled');
	      } else {
	        $parent.removeClass('focus');
	      }
	    });
	  });

var renderRegisterForm = function () {
	  // render fields
	 $form = $('#form-sign-in');	
	 renderTermsField();
	 renderNewPasswordField();

	  
	  // validate fields
	  $.validate({
	    form: '#form-sign-in',	
	  	modules: 'security, date, logic',	      	    
	    scrollToTopOnError: false,		      	  			      	    
	    onElementValidate : function(valid, $el, $form) {
	      if ($form.isValid({}, {}, false)) {
	        $('#btnEnter').attr('disabled', false);
	      } else {
	        $('#btnEnter').attr('disabled', true);
	      }
	    },
	    onError: function ($form) {
	      var $error = $form.find('.has-error');
	      if ($error.length > 0) {
	        $error = $error.first();
	        $('html, body').animate({ scrollTop: $error.offset().top - 16 });
	      }
	    },
	    onSuccess: function () {   	      
	      return false;
	    }
	  });
	};

	var renderTermsField = function () {
   	   
  		var  $form = $('#form-sign-in'),
  	    onChangeTerms;
  	  
  	  var $user = $('#user');
  	  var $password = $('#password');
  	  

  	  onChangeTerms = function () {
  		
  	    if ($form.isValid({}, {}, false)) {
  	      $('#btnEnter').attr('disabled', false);
  	    } else {
  	      $('#btnEnter').attr('disabled', true);
  	    }
  	  };
  	  		      	  
  	  $user.on('keyup', onChangeTerms);
  	  $password.on('keyup', onChangeTerms);
  	  		      	  
  	};

 	/**
  	  * Show / Hide password
  	  */
  	 var renderNewPasswordField = function () {
  	   var $input = $('#password'),		   	   	 
  	     $field = $input.parent(),		   	     
  	     $toggle = $('#toglePassword'),		   	     	     
  	     onTogglePassword;

  	   onTogglePassword = function () {
  	     $field.toggleClass('viewing');
  	     if ($field.hasClass('viewing')) {
  	       $input.attr("type", "text");
  	     } else {
  	       $input.attr("type", "password");
  	     }
  	   };
  	  
  	   $toggle.on('click', onTogglePassword);
  
  	 };
  	 
</script>

</html>