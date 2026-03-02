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
	<title>Restablecer usuario</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=1" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
    
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
				<div class="ilot">
				<section class="main-section">
					<div class="center-recuperar-usuario">
						<div>
							<h3 class="title-recuperar-password">Recuerda tu usuario</h3>
						</div>
						
						<div class="dsc-recuperar-password">
							<p>Confírmanos tu tipo y número de documento, enviaremos a tu  
								correo registrado tu usuario.</p>
							</div>
					</div>	
					
					<div class="main-page" >
						
						<form class="form-login" action="send_user_mail.html" method="post" id="frm-recuperar-user" data-response-type="json" style="margin: 1em 0;padding: 0px;">
						<input type="hidden" id="game" name="game" value="1">
							 <div class="control-form form__select">
			                  <label for="typeDoc">Tipo de documento</label>
			                  <select name="typeDoc" id="typeDoc" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento">
			                    <!--option(value='') Seleccionar-->
			                    <option value="DNI" selected>DNI</option>
			                    <option value="PASAP">Pasaporte</option>
			                    <option value="CAREX">Carnet de Extranjería</option>
			                  </select>
			                </div>
			                
<!-- 							 <div class="control-form" id="form-user-send-email"> -->
<!-- 							 	<label for="email-usr">Número de documento</label> -->
<!-- 								<input type="text" name="email-usr" id="email-usr" autocomplete="off" data-validation="required" data-validation-error-msg="Debes ingresar documento válido"> -->
<!-- 							</div> -->
							
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
														                            							
							<!--  <div class="error" id="alert"></div>	-->						
							<div>
								<i></i>
								<button class="btn btn-recuperar-password" type="submit" id="btn-recuperar-user">ENVIAR</button><br/>
							</div>
							
						</form>
						<div id="popup" class="overlay">
							<div class="popup popup-sm recuperar-password">		
								<a class="close-popup " id="close-popup-message" onclick="closePopupMessageLoggin()">&times;</a>						
								<div class="main-modal" id="msg-confirmacion"></div>
								
							</div>
						</div>
						
					</div>
				</section>
				</div>
			    </div>
				
			</div>
		</div>
		
		<jsp:include page="../include/footer.jsp" />
	
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
	<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/v2/swiper.min.js"></script>
    <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=14"></script>	
    <script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>
		
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
    	 renderTermsField();

//		 $('#email-usr').alphanum({allowSpace: false, allow : '-_+@.'});
      	  
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
		                	'<p class="descripcion-ok">'+ d.rmessage +'</p><br><br>'+			                	
		                    '<button class="btn btn-recuperar-password" onclick="goLogin();" type="button">OK</button></div>';	
	                $('#msg-confirmacion').html(msgOk);
                	openModal("#popup","");
                    taggingTuUsuarioEnviado();
                } else if (d.message === 'KO') {
                	//$("div#alert").html(d.send);
                	var msgOk = '<div class="mensaje-confirmacion-password"><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+d.message+'</span><br><br>'+               	
                    '<button class="btn btn-recuperar-password" onclick="goRecuperarUsuario();" type="button">Continuar</button></div>';	
		            $('#msg-confirmacion').html(msgOk);
		        	openModal("#popup","");
                	
                } else if (d.rbutton === '202') {
                	var msgOk = '<div class="mensaje-confirmacion-password"></div>'+
                	'<p class="descripcion-ok">'+ d.rmessage +'</p><br><br>'+			                	
                    '<button class="btn btn-recuperar-password" onclick="goLogin();" type="button">Aceptar</button></div>';	
		            $('#msg-confirmacion').html(msgOk);
		        	openModal("#popup","");
                	
                }else if (d.rbutton === '126') {
                	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+ d.rtitle+'</span><br><br>'+
                	'<p class="descripcion-ok">'+ d.rmessage +'</p><br><br>'+			                	
                    '<button class="btn btn-recuperar-password" onclick="goRegistro();" type="button">Regístrate</button></div>';	
            		$('#msg-confirmacion').html(msgOk);
		        	openModal("#popup","");
                	
                }else {
      
                	var msgOk = '<div class="mensaje-confirmacion-password"><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+d.rmessage+'</span><br><br>'+               	
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

      	
 
	
	</script>	
		
</body>
</html>