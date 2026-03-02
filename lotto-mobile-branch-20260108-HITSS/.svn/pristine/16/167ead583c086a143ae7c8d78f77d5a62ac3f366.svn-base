<%@ include file="/layer-view-interface/include/taglib.jsp"%>
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
	<title>Restablecer contraseña</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=1" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
    
	<meta name="robots" content="noindex, nofollow">
</head>

<body class="white">
 	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<c:set var="lapollaEnabled"><%=Boolean.valueOf(Constantes.lapollaEnabled.trim()).booleanValue()%></c:set>
	<c:set var="tav2Enabled"><%=Boolean.valueOf(Constantes.tav2Enabled.trim()).booleanValue()%></c:set>
	<c:set var="bannersUrl"><%=Constantes.bannersUrl.toString().trim()%></c:set>
	<c:set var="iflexBonoTyC"><%=Constantes.iflexBonoTyC.toString().trim()%></c:set>
	<c:set var="wbBonoTyC"><%=Constantes.wbBonoTyC.toString().trim()%></c:set>

	<div class="container">
		
		<jsp:include page="../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="center-cambiar-password">
						<div>
								<h3 class="title-cambiar-password">Recupera o cambia tu constraseña</h3>
							</div>
							
							<div class="dsc-recuperar-password">
								<p>Ingresa tu nueva contraseña.</p>
							</div>
					</div>
					<div class="main-page" style="padding-top: 0px;">
						
						<form class="form-cambiar-password" action="change_password.html" method="post" id="frm-restabler-password" data-response-type="json" style="margin: 2.25em 0;padding: 0px;">
							<input type="hidden" id="codigoPass" name="codigoPass" value='${codigoPass}'>
							<input type="hidden" id="email" name="email" value='${email}'>							
							 
							 <!--  <div style="margin-bottom: 20px; text-align: left;">
								<span class="icon-security-pass"></span><a href="javascript:void(0);"  class='link link__base' onclick="openSecurityPass();">Crea una contraseña segura</a>
							 </div> -->
							 
							 <div id="form-new-password" class="control-form" style="margin: 1.25em 0;">
							 	<label for="password">Nueva contraseña</label>
								<input type="password" class="new-password" name="password" id="password" autocomplete="new-password" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
								<button class="view-password" type="button" id="toglePassword"></button>
                  				<div class="strength-meter">&nbsp;</div>
							</div>
							
							<div id="form-confirmation-password" class="control-form">
							 	<label for="new-password">Confirmar contraseña</label>
								<input type="password" class="confirm-password" name="new-password" id="new-password" autocomplete="new-password2" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
								<button class="view-password2" type="button" id="toglePassword-confirmation"></button>
                  				<div class="strength-meter">&nbsp;</div>
							</div><br>
							
							<div class="error" id="alertChange"></div>							                            																				
							<div class="control-form">
								<i></i>
								<button class="btn btn-recuperar-password" type="submit" id="btn-change-password">CAMBIAR</button><br/>
							</div>
							
						</form>
						<div id="popup" class="overlay">
							<div class="popup popup-sm recuperar-password">								
								<div class="main-modal" id="msg-confirmacion"></div>
								
							</div>
						</div>
						<div id="popup-message" class="overlay">							
							<div class="popup popup-sm login-error">	
							<a class="close-popup " id="close-popup-message" onclick="closePopupMessageLoggin()">&times;</a>							
								<div class="main-modal" id="msg-message"></div>
								
							</div>
						</div>
						
					</div>
				</section>
	
			    </div>
				
			</div>
		</div>
		
		<jsp:include page="../include/footer.jsp" />
	
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
	<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/v2/swiper.min.js"></script>
    <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=14"></script>	
		
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
	    	      
	    	      /*if ($('#form-new-password').hasClass('has-error') || $('#form-new-password').hasClass('has-success')) {
		    	      console.log('test');
		    	      $('#form-confirmation-password').addClass('view-space');
	    	      }*/
	    	      
	    	    }
    	  };

    	  
    	  		      	     	  
    	  $correo1.on('keyup', onChangeTerms);
    	  $correo2.on('keyup', onChangeTerms);
    	  		      	  
    	};

    	
    	 $('#btn-change-password').click(function(){
		      
	        	event.preventDefault();
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
                 			cadena = d.tav2.split("|");
                 			window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1]),"_parent");
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
	                   
                 	//$("div#alertChange").html(d.send);
//                  	var msjIgual= 'Verifica que tu nueva contraseña sea digitada por igual en Confirmar contraseña';
//                  	$("div#alertChange").html(msjIgual);
	                    var msgError = '<div><div class="titulo-login-error">'+d.title+'</div><br><div class="mensaje-login-error"><span>'+d.send+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
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

    	function goLogin(){			
   			window.location.href = 'security_login_execute_authentication.html';  
   		}
    		
	</script>	
		
</body>
</html>