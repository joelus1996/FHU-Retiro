<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<!DOCTYPE html>
<html>
<head>

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
  <title>Restablecer contraseña</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="layer-view-style/common/tav2-header.css?v=<%=Constantes.tav2_header_css%>" type="text/css" />
  
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
    try {
    	
    	if(session != null && nsession!=null && session.getAttribute("user") != null) {
    		session.invalidate();
    		/*ClientProcedureLogin clientProcedureLogin = (ClientProcedureLogin)session.getAttribute("user");
    		Integer cid = clientProcedureLogin.getClientId();
    		agreement = (clientProcedureLogin.getAgreement()==null || clientProcedureLogin.getAgreement().trim().equals(""))?false:true;
    		
    	    if (cid!=null) {
    	    	String token = clientProcedureLogin.getpToken();
    		    if (token!=null) {
    				user = clientProcedureLogin.getUser();
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
    	    } */
    	}
    } catch (Exception e) {
    	 user = null; 
    	 saldo = null; 
    	 bono  = null;
    	 if(session != null && nsession!=null) session.invalidate();
    }
    //System.out.println("agreement="+agreement+" logged="+logged);
%>
  <div class="nvs-header-row nvs-header-0">
	<div id="logo"><a href="<%= Constantes.tav2GameProviderCloseUrl%>" id="logo-href"></a></div>
	<div id="btn">
		<a href="tav2.html" id="register-btn3" class="register-btn3">
		<span>INGRESAR</span>
		</a>
		<a href="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" id="register-btn" class="register-btn">
		<span >REGÍSTRATE</span>
		</a>
	</div>
  </div>
  
  <div class="center-cambiar-password">
	  <div class="text-center top-login">
	      <h3 class="title-cambiar-password">Recupera o cambia tu contraseña</h3>      
	    </div>
	    <div class="dsc-recuperar-password">
		 <p>Ingresa tu nueva contraseña.</p>
		</div>
  </div>
  <div class="wrap-body">

    
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
				<input type="number" class="form-control" id="user-phone" placeholder="Ingresa tu celular"/>
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
	      	
	      <form class="form-cambiar-password" action="change_password.html" method="post" id="frm-restabler-password" data-response-type="json">
							<input type="hidden" id="codigoPass" name="codigoPass" value='${codigoPass}'>
							<input type="hidden" id="email" name="email" value='${email}'>
							 
							 <!--  <div style="margin-bottom: 20px; text-align: left;">
								<span class="icon-security-pass"></span><a href="javascript:void(0);"  class='link link__base' onclick="openSecurityPass();">Crea una contraseña segura</a>
							 </div> -->
							 
							 <div id="form-new-password" class="control-form">
							 	<label for="password">Nueva contraseña</label>
								<input type="password" class="new-password" name="password" id="password" autocomplete="new-password" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
								<button class="view-password" type="button" id="toglePassword"></button>
                  				<div class="strength-meter" style="margin-top: 13px;">&nbsp;</div>
							</div>
							
							<div id="form-confirmation-password" class="control-form" style="margin-bottom: 12px;">
							 	<label for="new-password">Confirmar contraseña</label>
								<input type="password" class="confirm-password" name="new-password" id="new-password" autocomplete="new-password2" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
								<button class="view-password2" type="button" id="toglePassword-confirmation"></button>
                  				<div class="strength-meter" style="margin-top: 13px;">&nbsp;</div>
							</div><br>
							
							<div class="error" id="alertChange"></div>							                            																				
							<div>
								<i></i>
								<button class="btn btn-recuperar-password" type="submit" id="btn-change-password">CAMBIAR</button><br/>
							</div>
							
		</form>
	    <span class="error" id="alertLogin">
	    <%nsession = request.getSession(false); if(session != null && nsession!=null ) {%>${alertLogin}<%}%>
	    </span>
	    
			
	    </div>
	<%-- } --%>
	
		<div id="popup-bond" class="overlay">
						<div class="popup popup-sm">
							<a class="close js-close-modal" href="#">&times;</a>
							<div class="wrap-modal"></div>
						</div>
		</div>
		
		<div id="popup-message" class="overlay">							
			<div class="popup popup-sm login-error">	
			<a class="close-popup " id="close-popup-message" onclick="closePopupMessageLoggin()">&times;</a>							
				<div class="main-modal" id="msg-message"></div>
				
			</div>
		</div>
		
		<footer id="footer">
					
			<div id="popup" class="overlay">
							<div class="popup popup-sm recuperar-password">								
								<div class="main-modal" id="msg-confirmacion"></div>
								
							</div>
			</div>
			
			<div id="logo-tinka"></div>
		</footer>
	
  </div>

</body>
<%-- /*chatbot*/ --%>	
<!-- <script type="application/javascript" charset="UTF-8" src="https://cdn.agentbot.net/core/56512f807294eae4d4093733fc35cd13.js"></script> -->	
<%-- /*fin chatbot*/ --%>

<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/jquery-migrate-3.1.0.min.js"></script>
<script type="text/javascript" src="layer-view-script/tav2-header.js?v=15"></script>
<script type="text/javascript" src="layer-view-script/common/chatbot.js"></script>
<script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=14"></script>
<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>	

<script>

$(document).ready(function(){
	
	 $('#btn-change-password').attr('disabled', true);
	 renderCambiarContraseniaForm();
	//taggingOlvidasteContrasenia();
			
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

var renderCambiarContraseniaForm = function () {
	  // render fields
	 $form = $('#frm-restabler-password');
	 renderTermsNewField();
	 renderNewPasswordField();
	  
	  // validate fields
	  $.validate({
	    form: '#frm-restabler-password',	
	  	modules: 'security, date, logic',	      	    
	    scrollToTopOnError: false,
	    onModulesLoaded: function () {
	        var config = {
	          bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@). No usar tus últimas 6 contraseñas.</span>',
	          weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@). No usar tus últimas 6 contraseñas.</span>',
	          good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
	          strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
	        };
	        $('#password').displayPasswordStrength(config);
	        $('#new-password').displayPasswordStrength(config);
	       
	      },		      	  			      	    
	    onElementValidate : function(valid, $el, $form) {
	      if ($form.isValid({}, {}, false)) {
	        $('#btn-change-password').attr('disabled', false);
	      } else {
	        $('#btn-change-password').attr('disabled', true);
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


	var renderTermsNewField = function () {
 	   
		var  $form = $('#frm-restabler-password'),
	    onChangeTerms;
	     	  
	  	var $correo1 = $('#password');
	  	var $correo2 = $('#new-password');
	  
	  	onChangeTerms = function () {
		
    	    if ($form.isValid({}, {}, false)) {
    	      $('#btn-change-password').attr('disabled', false);
    	    } else {
    	      $('#btn-change-password').attr('disabled', true);
    	         	        	      
    	    }
	  };

	  
	  		      	     	  
	  $correo1.on('keyup', onChangeTerms);
	  $correo2.on('keyup', onChangeTerms);
	  		      	  
	};

	$('#btn-change-password').click(function(){
	      
        var $form = $("#frm-restabler-password");
        var ico = $(this).siblings('i');
        $.ajax({
            url: $form.attr('action'),
            data: $form.serialize(),
            type: $form.attr('method'),
            dataType: $form.data('response-type'),
            beforeSend: function() {$('#btn-change-password').prop('disabled', true);$(ico).addClass('loading');}
               
        }).done(function(d) {
        	$(ico).removeClass('loading');
         if (d.message === 'OK') {
                
				if(d.lapolla!=null && $.trim(d.lapolla)!="") {
     			cadena = d.lapolla.split("|");
     			window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1]),"_parent");
				} else if(d.tav2!=null && $.trim(d.tav2)!="") {
//          			cadena = d.tav2.split("|");
//          			window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1]),"_parent");
         			urlTav2=d.tav2;
         			var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/Check.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">¡Contraseña cambiada!</span><br><br>'+
                	'<p class="descripcion-ok">Vuelve a ingresar con tu usuario y </p>'+
                	'<p class="descripcion-ok"> nueva contraseña </p><br><br>'+		                	
                    '<button class="btn btn-recuperar-password" onclick="window.open(\''+urlTav2+'\',\'_parent\');" type="button">OK</button></div>';	
                       $('#msg-confirmacion').html(msgOk);
        				openModal("#popup","");
                    	taggingContraseniaActualizada();
         			
     		} else {
					//$("div#alertChange").html("");
                    //$('#popup .main-modal').html("<div class='info'></div><p>"+d.send+"</p>");
                    var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/Check.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">¡Contraseña cambiada!</span><br><br>'+
                	'<p class="descripcion-ok">Vuelve a ingresar con tu usuario y </p>'+
                	'<p class="descripcion-ok"> nueva contraseña </p><br><br>'+		                	
                    '<button class="btn btn-recuperar-password" onclick="goLogin();" type="button">OK</button></div>';	
                       $('#msg-confirmacion').html(msgOk);
        				openModal("#popup","");
                    	taggingContraseniaActualizada();
				}
				
         } else if (d.message === 'KO') {

//             var msjIgual='Verifica que tu nueva contraseña sea digitada por igual en Confirmar contraseña'; 
         	//$("div#alertChange").html(d.send);
//          	$("div#alertChange").html(msjIgual);
          	var msgError = '<div><div class="titulo-login-error" style="text-align: center;">'+d.title+'</div><br><div class="mensaje-login-error" style="text-align: center; font-size: 15px; line-height: 19.3px;"><span>'+d.send+'</span></div><br><br>'+
            '<button class="btn btn-login-error"  type="button" onclick="closePopupMessagePassword()">Aceptar</button></div>';
            $('#close-popup-message').hide();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
          	
         	var men2=d.send;
         	 men2 = men2.replace("Contrase&ntilde;a" ,"	Contrase\u00F1a");
         	 men2 = men2.replace("Contrase&ntilde;a" ,"Contrase\u00F1a");
         	 men2 = men2.replace("caract&eacute;res" ,"caract\u00E9res");
                console.log("men2-->"+men2);
                
         	taggingErrorIgualDatos(men2);
         } else {
         	$("div#alertChange").html(d.message);
         	tagginErrorEnviarEmail(d.message);
         }
     
                                
         $('#btn-change-password').prop('disabled', false);

        }).fail(function() {
        	$(ico).removeClass('loading');
     	$("div#alert").html("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
         $('#btn-change-password').prop('disabled', false);
        
        }).always(function() {
        });
    });

	/**
	  * Show / Hide password
	  */
	 var renderNewPasswordField = function () {
	   var $input = $('#password'),
	   	 $input2 = $('#new-password'),
	     $field = $input.parent(),
	     $field2 = $input2.parent(),
	     $toggle = $('#toglePassword'),
	     $toggle2 = $('#toglePassword-confirmation'),    	     
	     onTogglePassword,onTogglePassword2;

	   onTogglePassword = function () {
	     $field.toggleClass('viewing');
	     if ($field.hasClass('viewing')) {
	       $input.attr("type", "text");
	     } else {
	       $input.attr("type", "password");
	     }
	   };

	   onTogglePassword2 = function () {
 	     $field2.toggleClass('viewing');
 	     if ($field2.hasClass('viewing')) {
 	       $input2.attr("type", "text");
 	     } else {
 	       $input2.attr("type", "password");
 	     }
 	   };

	   $toggle.on('click', onTogglePassword);
	   $toggle2.on('click', onTogglePassword2);
	 };



	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		$('body').addClass('modal');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	}

	function backPassword(){			
		window.location.href = 'recuperar-contrasenia-ta.html';  
	}

	function goLogin(){			
		window.location.href = 'tav2.html';  
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
			} window.open(d.redireccion,"_parent");
	    });
	}

	$('#password').on('input',inputPassword);
</script>

</html>