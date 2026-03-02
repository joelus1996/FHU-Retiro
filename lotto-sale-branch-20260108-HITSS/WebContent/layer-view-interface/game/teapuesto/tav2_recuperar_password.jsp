<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.util.Constants"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />	
  <meta http-equiv="Cache-Control" content="max-age=0" />
  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
  <meta http-equiv="Expires" content="0" />
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
  <meta http-equiv="Pragma" content="no-cache" />
  <meta charset="utf-8">
  <title></title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="layer-view-style/common/tav2-header.css?v=<%=Constants.tav2_header_css%>">
  
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
  
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<% 
    boolean logged = false, agreement = false;
    String user = null; 
    Double saldo = null; 
    Double bono  = null; 
    HttpSession nsession = request.getSession(false);
    try {
    	
    	if(session != null && nsession!=null && session.getAttribute("User") != null) {
    		session.invalidate();
    		/*UserBean userBean = (UserBean)session.getAttribute("User");
    		Integer cid = userBean.getpClientid();
    		agreement = (userBean.getpAgreement()==null || userBean.getpAgreement().trim().equals(""))?false:true;
    		
    	    if (cid!=null) {
    	    	String token = userBean.getpToken();
    		    if (token!=null) {
    				user = userBean.getpUser();
    				pe.com.intralot.loto.lib.Dbms rs = new pe.com.intralot.loto.lib.Dbms();
    			    String sql = " select max(nvl(cl_balance_amount,0)) + sum(nvl(decode(cg_sale_type,0,cg_balance_amount,0),0)), sum(nvl(decode(cg_sale_type,1,cg_balance_amount,0),0)) from lotocard.client, lotocard.client_game where client_id = ? and client_id = cg_client_id(+) and cg_game_id(+) = 9 ";
    			    rs.setSql(sql);
    		        rs.setString(1,String.valueOf(cid));
    		        rs.executeQuery();
    		        if (rs.next()) {
    		        	saldo = rs.getDouble(1);
    		        	bono  = rs.getDouble(2);
    		        }
    		        rs.close();
    				//saldo = userBean.getpMonto();
    				logged = true;
    				
    		    } 
    	    }*/
    	}
    } catch (Exception e) {
    	 user = null; 
    	 saldo = null; 
    	 bono  = null;
    	 if(session != null && nsession!=null) session.invalidate();
    }
    //System.out.println("agreement="+agreement+" logged="+logged);
%>
  <header id="nvs-header">
	<div class="nvs-header-row nvs-header-0">
		<div class="nvs-logo"> <a class="logo" href="<%= Constants.tav2GameProviderCloseUrl%>"></a> </div>
		<div class="nvs-register"> 
<%-- 			<a class="boton_personalizado" href="https://www.intralot.com.pe/p/registro.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />">&nbsp;&nbsp;&nbsp;REGÍSTRATE&nbsp;&nbsp;&nbsp;</a>  --%>
		<input type="hidden" id="redirect558cancel" value="registro.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" />
		<a class="boton_personalizado" href="registro.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />">&nbsp;&nbsp;&nbsp;REGÍSTRATE&nbsp;&nbsp;&nbsp;</a>
		</div>
		<div class="nvs-ingresar"> 
<%-- 			<a class="boton_personalizado" href="https://www.intralot.com.pe/p/registro.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />">&nbsp;&nbsp;&nbsp;REGÍSTRATE&nbsp;&nbsp;&nbsp;</a>  --%>
		<a class="boton_personalizado2" href="tav2.html">&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
		</div>
	</div>	
	<div class="nvs-header-row nvs-header-1">&nbsp;</div>
	<div class="nvs-header-row nvs-header-2">&nbsp;</div>
	<div class="nvs-header-row">&nbsp;</div>
	<div class="nvs-header-row">&nbsp;</div>
  </header>
	
  <div class="wrap-body" id="wrap-body">

    <div class="text-center top-login">
      <h3 class="top-title">Recupera o cambia tu contraseña</h3>
      <div class="sub-head-form">
		<p class="no-upper"><span style="font-size: 16px;font-family: Roboto, sans-serif;">Confírmanos tu tipo y número de documento, enviaremos a tu correo registrado las instrucciones para cambiar tu contraseña.</span></p>
	  </div>      
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
				<input type="text" class="form-control" id="user-code" placeholder="Digita el código"/>
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
	    <i></i>	
<!-- 	      <form class="form-login" action="restablecer-mail.html" method="post" id="frm-user-send" data-response-type="json"> -->
	      <form class="form-login" action="send_password_mail.html" method="post" id="frm-user-send" data-response-type="json">
			<div class="row">
				<div class="offset-sm-0 col-sm-6  col-md-6">
					<div class="control-form form__select has-success" id="divNumberDoc" style="border: 0px;">
		              <label for="email-user">Tipo de documento</label>
		              <select name="document-type" id="document-type" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
		                <!--option(value='') Seleccionar-->
		                <option value="DNI" selected>DNI</option>
		                <option value="PASAP">Pasaporte</option>
		                <option value="CAREX">Carnet de Extranjería</option>
		              </select>
		            </div>
	            </div>
	            <div class="offset-sm-0 col-sm-6  col-md-6">
		            <div class="control-form form__input form__optional show" id="divNumberDoc" style="border: solid 1px #A5A5A5; margin: 1.25em 0;">
					 	<label for="document-number">Número de documento</label>
						<input type="text" name="document-number" id="document-number" autocomplete="off" 
						maxlength="8" data-validation="length number" data-validation-length="8" 
						data-validation-error-msg="Ingresa un DNI válido" data-validation-depends-on="document-type" 
						data-validation-depends-on-value="DNI" style="font-size: 16px !important;">
					</div>
					<div class="control-form form__input form__optional" id="div-documento-pasap" style="border: solid 1px #A5A5A5; margin: 1.25em 0;">
					 	<label for="document-number-pasap">Número de documento</label> 
		                <input type="text" name="document-number-pasap" autocomplete="off" 
		                id="document-number-pasap" maxlength="12" data-validation="length alphanumeric" 
		                data-validation-length="min9max12" data-validation-error-msg="Ingresa un Pasaporte válido" 
		                data-validation-depends-on="document-type" data-validation-depends-on-value="PASAP" 
		                style="font-size: 16px !important;">
					</div>
					<div class="control-form form__input form__optional" id="div-documento-carex" style="border: solid 1px #A5A5A5; margin: 1.25em 0;">
					 	<label for="document-number-carex">Número de documento</label> 
		                <input type="text" name="document-number-carex" autocomplete="off" id="document-number-carex" 
		                maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" 
		                data-validation-error-msg="Ingresa un Carnet de Extranjería válido" data-validation-depends-on="document-type" 
		                data-validation-depends-on-value="CAREX" style="font-size: 16px !important;">
					</div>
				</div>
			</div>
			
			<input type="hidden" id="game" name="game" value="2">
<!-- 			 <div class="control-form" id="form-recuperar-email"> -->
<!-- 			 	<label for="email-usr">Correo electrónico</label> -->
<!-- 				<input type="text" name="email-user" id="email-usr" autocomplete="off" data-validation="required" data-validation-error-msg="Debes ingresar un correo válido"> -->
<!-- 			</div> -->
														                            															        	        
			<input type="hidden" name="channel" value="1">
			<input type="hidden" id="iflexBonoTyC" value="<%=Constants.iflexBonoTyC.toString().trim()%>" />
			<input type="hidden" id="wbBonoTyC" value="<%=Constants.wbBonoTyC.toString().trim()%>" />
			<input type="hidden" name="urlRedirect5588" value="<c:out value='${urlRedirect5588}' />">
			<input type="hidden" name="redirectGame" value="<c:out value='${redirectGame}' />">
			<input type="hidden" name="ref" value="<c:out value='${ref}' />">
			
<!-- 			<div style="text-align: center;"> -->
<!--            		<img id="imagen" name="imagen" src="" style="padding-left: 15%; padding-right: 15%; margin-bottom: 1.2em;" width="100%" height="50px"> -->
<!--            		<a id="reload" href="#" style="font-family: inherit !important; font-size: 14px;">Generar otro código</a> -->
<!--            		<input name="sentCaptcha" id="sentCaptcha" type="text" placeholder="Ingresar código" class="form-control" maxlength="5" style="margin-top: 1.2em; font-family: inherit !important;"> -->
<!--         	</div> -->

			<div class="offset-sm-0 col-sm-6  col-md-9">				
				<button class="btn btn-recuperar-password" type="submit" id="btn-send-password" style="margin-top: 40px;">ENVIAR</button><br/>
			</div> 
        	
	      </form>	
	    	
	    <span class="error" id="alertLogin"></span>
	    <!--  <button type="button" id="btnEnter" class="button button-block button-orange" style="margin-bottom: 1.2em;">Ingresar</button>-->
	     
	    	
	    </div>
	<%-- } --%>
  </div>
  
  	<footer id="footer">
								
			<div class="nvs-logo-footer"></div>
		</footer>
		
		<div id="popup" class="overlay-recuperar-password">
							<div class="popup popup-sm recuperar-password">	
							<a class="close-popup " id="close-popup-message" onclick="closePopup(this)">&times;</a>							
								<div class="main-modal" id="msg-confirmacion"></div>
								
							</div>
						</div>

</body>
<%-- /*chatbot*/ --%>	
<!-- <script type="application/javascript" charset="UTF-8" src="https://cdn.agentbot.net/core/56512f807294eae4d4093733fc35cd13.js"></script> -->	
<%-- /*fin chatbot*/ --%>
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/common/tav2-header.js?v=15"></script>
<script type="text/javascript" src="layer-view-script/common/chatbot.js"></script>
<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>

<script>

$(document).ready(function(){
	
	 $('#btn-send-password').attr('disabled', true);
	renderRegisterForm();
				
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
 $form = $('#frm-user-send');	
 renderDocumentFields();
 renderTermsField();

 $('#email-usr').alphanum({allowSpace: false, allow : '-_+@.'});
  
  // validate fields
  $.validate({
    form: '#frm-user-send',	
  	modules: 'security, date, logic',	      	    
    scrollToTopOnError: false,		      	  			      	    
    onElementValidate : function(valid, $el, $form) {
      if ($form.isValid({}, {}, false)) {
        $('#btn-send-password').attr('disabled', false);
      } else {
        $('#btn-send-password').attr('disabled', true);
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
	   
	var  $form = $('#frm-user-send'),
    onChangeTerms;
     	  
//   	var $correo = $('#email-usr');
  	var $dni = $('#document-number');
  	var $pasap = $('#document-number-pasap');
  	var $carex = $('#document-number-carex');
  
  	onChangeTerms = function () {
	
	    if ($form.isValid({}, {}, false)) {
	      $('#btn-send-password').attr('disabled', false);
	    } else {
	      $('#btn-send-password').attr('disabled', true);
	    }
  };
  		      	     	  
//   $correo.on('keyup', onChangeTerms);
  $dni.on('keyup', onChangeTerms);
  $pasap.on('keyup', onChangeTerms);
  $carex.on('keyup', onChangeTerms);
  		      	  
};


	function backPassword(){			
		window.location.href = 'recuperar-contrasenia-ta.html';  
	}

	function goHome(){			
		toTAV2();  
	}

	
	//LA POLLA HOME
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

	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		$('body').addClass('modal');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	}


</script>

</html>