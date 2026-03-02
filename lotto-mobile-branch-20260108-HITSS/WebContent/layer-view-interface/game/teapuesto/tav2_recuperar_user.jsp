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
  <title></title>
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
		<input type="hidden" id="redirect558cancel" value="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" />
		<a href="client_lotocard_show_form.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />" id="register-btn" class="register-btn">
		<span >REGÍSTRATE</span>
		</a>
	</div>
  </div>
  
  <div class="center-recordar-usuario">
	    <div class="text-center top-login">
	      <h3 class="title-cambiar-password">Recuerda tu usuario</h3>      
	    </div>
	    <div class="dsc-recuperar-password">
		 <p>Confírmanos tu tipo y número de documento, enviaremos a tu  
								correo registrado tu usuario</p>
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
	      <form class="form-login" action="send_user_mail.html" method="post" id="frm-recuperar-user" data-response-type="json">
	      					
							 <div class="control-form form__select" style="margin-top:2.3em;">
			                  <label for="typeDoc">Tipo de documento</label>
			                  <select name="typeDoc" id="typeDoc" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
			                    <!--option(value='') Seleccionar-->
			                    <option value="DNI" selected>DNI</option>
			                    <option value="PASAP">Pasaporte</option>
			                    <option value="CAREX">Carnet de Extranjería</option>
			                  </select>
			                </div>
			                <div class="form__input form__optional show"   id="divNumberDoc">
			                  <label for="numberDoc">Número de documento</label>
			                  <input type="tel" name="numberDoc" tabindex="11" id="numberDoc" maxlength="8" data-validation="length number" data-validation-length="8" data-validation-error-msg="Ingresa un DNI válido" data-validation-depends-on="typeDoc" data-validation-depends-on-value="DNI">
			                  
			                </div>
			                <div class="form__input form__optional" id="div-documento-pasap">
			                  <label for="documento-pasap">Número de documento</label>
			                  <input type="text" name="documento-pasap" tabindex="11" id="documento-pasap" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="Ingresa un Pasaporte válido" data-validation-depends-on="typeDoc" data-validation-depends-on-value="PASAP">
			                  
			                </div>
			                <div class="form__input form__optional" id="div-documento-carex">
			                  <label for="documento-carex">Número de documento</label>
			                  <input type="text" name="documento-carex" tabindex="11" id="documento-carex" maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" data-validation-error-msg="Ingresa un Carnet de Extranjería válido" data-validation-depends-on="typeDoc" data-validation-depends-on-value="CAREX">
			                  
			                </div>
<!-- 							 <div class="control-form" id="form-recuperar-user-email"> -->
<!-- 							 	<label for="email-usr">Correo electrónico</label> -->
<!-- 								<input type="email" name="email-usr" id="email-usr" autocomplete="off" data-validation="required" data-validation-error-msg="Debes ingresar un correo válido"> -->
<!-- 							</div> -->
														                            							
							<!--  <div class="error" id="alert"></div>	-->						
							<div>
								<i></i>
								<button class="btn btn-recuperar-password" type="submit" id="btn-recuperar-user">ENVIAR</button><br/>
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
		
		<footer id="footer">
				
			<div id="popup" class="overlay">
							<div class="popup popup-sm recuperar-password">		
								<a class="close-popup " id="close-popup-message" onclick="closePopupMessageLoggin()">&times;</a>						
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
	
	 $('#btn-recuperar-user').attr('disabled', true);
	renderRegisterForm();
	taggingOlvidasteUsuario();
			
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
	 $form = $('#frm-recuperar-user');	
	 renderDocumentFields();
	 renderFormFields();
	 renderTermsField();

	 $('#email-usr').alphanum({allowSpace: false, allow : '-_+@.'});
 	  
	  // validate fields
	  $.validate({
	    form: '#frm-recuperar-user',	
	  	modules: 'security, date, logic',	      	    
	    scrollToTopOnError: false,		      	  			      	    
	    onElementValidate : function(valid, $el, $form) {
	      if ($form.isValid({}, {}, false)) {
	        $('#btn-recuperar-user').attr('disabled', false);
	      } else {
	        $('#btn-recuperar-user').attr('disabled', true);
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
	   
		var  $form = $('#frm-recuperar-user'),
	    onChangeTerms;
	     	  
// 	  	var $correo = $('#email-usr');
	  	var $dni = $('#numberDoc');
	  	var $pasap = $('#documento-pasap');
	  	var $carex = $('#documento-carex');
	  
	  	onChangeTerms = function () {
		
   	    if ($form.isValid({}, {}, false)) {
   	      $('#btn-recuperar-user').attr('disabled', false);
   	    } else {
   	      $('#btn-recuperar-user').attr('disabled', true);
   	    }
	  };
	  		      	     	  
// 	  $correo.on('keyup', onChangeTerms);
	  $dni.on('keyup', onChangeTerms);
	  $pasap.on('keyup', onChangeTerms);
	  $carex.on('keyup', onChangeTerms);
	  		      	  
	};

	$('#btn-recuperar-user').click(function(){
 		
       var $form = $("#frm-recuperar-user");
       var ico = $(this).siblings('i');
       $.ajax({
           url: $form.attr('action'),
           data: $form.serialize(),
           type: $form.attr('method'),
           dataType: $form.data('response-type'),
           beforeSend: function() {$('#btn-recuperar-user').prop('disabled', true);$(ico).addClass('loading');}

       }).done(function(d) {
       	$(ico).removeClass('loading');
           if (d.message === 'OK') {

               var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/Check.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+ d.rtitle+'</span><br><br>'+
// 	                	'<p class="descripcion-ok">Si no lo encuentras, revisa tu bandeja</p>'+
// 	                	'<p class="descripcion-ok"> de no deseados o contáctate con </p>'+
	                	'<p class="descripcion-ok">'+ d.rmessage +'</p><br><br>'+			                	
	                    '<button class="btn btn-recuperar-password" onclick="goLogin();" type="button">OK</button></div>';	
               $('#msg-confirmacion').html(msgOk);
           	openModal("#popup","");
               taggingTuUsuarioEnviado();
           } else if (d.message === 'KO') {
           	//$("div#alert").html(d.send);
           	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">El correo enviado no está registrado</span><br><br>'+               	
               '<button class="btn btn-recuperar-password" onclick="goRecuperarUsuario();" type="button">Continuar</button></div>';	
	            $('#msg-confirmacion').html(msgOk);
	        	openModal("#popup","");
           	
           } else if (d.rbutton === '126') {
	           	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+ d.rtitle+'</span><br><br>'+
	        	'<p class="descripcion-ok">'+ d.rmessage +'</p><br><br>'+			                	
	            '<button class="btn btn-recuperar-password" onclick="goRegistro();" type="button">Regístrate</button></div>';	
	    		$('#msg-confirmacion').html(msgOk);
	        	openModal("#popup","");
	        	
	        }else if (d.rbutton === '202') {
	           	var msgOk = '<div class="mensaje-confirmacion-password"></div>'+
	        	'<p class="descripcion-ok">'+ d.rmessage +'</p><br><br>'+			                	
	            '<button class="btn btn-recuperar-password" onclick="goLogin();" type="button">Aceptar</button></div>';	
	            $('#msg-confirmacion').html(msgOk);
	        	openModal("#popup","");
        	
        	}else {
 
	           	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+d.rmessage+'</span><br><br>'+               	
		                    '<button class="btn btn-recuperar-password" onclick="goRecuperarUsuario();" type="button">Regresar</button></div>';	
	               $('#msg-confirmacion').html(msgOk);
	           	openModal("#popup","");
	           	taggingCorreoNoRegistrado(d.message);
           }
           $('#btn-recuperar-user').prop('disabled', false);

       }).fail(function() {
       	$(ico).removeClass('loading');
       	$("msg-confirmacion").html("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
       	openModal("#popup","");
           $('#btn-recuperar-user').prop('disabled', false);
   
       }).always(function() {
       });
   });

 	function goRecuperarUsuario(){			
		window.location.href = 'recuperar-user-ta.html';  
   }

 	function goLogin(){			
		window.location.href = 'tav2.html';  
   }

 	function goRegistro(){
 		window.location.href = $('#redirect558cancel').val();  
 	}

 	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		$('body').addClass('modal');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	}


</script>

</html>