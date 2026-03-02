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
	<meta http-equiv="Content-Type" content="text/html">
	<title>La Tinka : Inicio de sesion</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
    
	<meta name="robots" content="noindex, nofollow">
	<style>
	.btn-invitado-tk{
		display: flex;
	    flex-direction: column;
	    justify-content: center;
    }
	</style> 
</head>
<body class="white">
 	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Login" id="TipoZona">
	<input type="hidden" value="Login" id="Zona">
	<input type="hidden" value="Ingresar" id="SubZona">
	<c:set var="lapollaEnabled"><%=Boolean.valueOf(Constantes.lapollaEnabled.trim()).booleanValue()%></c:set>
	<c:set var="tav2Enabled"><%=Boolean.valueOf(Constantes.tav2Enabled.trim()).booleanValue()%></c:set>
	<c:set var="bannersUrl"><%=Constantes.bannersUrl.toString().trim()%></c:set>
	<c:set var="iflexBonoTyC"><%=Constantes.iflexBonoTyC.toString().trim()%></c:set>
	<c:set var="wbBonoTyC"><%=Constantes.wbBonoTyC.toString().trim()%></c:set>

	<jsp:include page="../include/footer.jsp" />
	
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
	<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/v2/swiper.min.js"></script>
    <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=14"></script>
    <script type="text/javascript">
	    $(document).ready(function () {
	      // Limpiar campos al cargar
	      $('#user').val('');
	      $('#password').val('');
	      $('#ingresar').attr('disabled', true);
	      renderRegisterForm();
			
	      let pathName = window.location.pathname;
	      pathName = pathName.substring(pathName.lastIndexOf("/") + 1, pathName.lastIndexOf(".html"));
	      let ruta = 'security_login_execute_authentication.html';
			
	      getFastTokenAndRedirect(pathName);
		});

		
    </script>
    
	<script type="text/javascript">

			//$(document).ready(function(){
var operatorId = "<c:out value='${OperatorId}'/>";
				/*
				$('#ingresar').click(function (event) {
			        if ($("#user").val() == '') {
			            $("span#alertLogin").html("Ingrese su usuario");
			            return false
			        }
			        if ($("#password").val() == '') {
			            $("span#alertLogin").html("Ingrese su clave");
			            return false
			        }
			        var frm = $("#security_login_execute_authentication");

			        frm.submit(function (e) {
			        	  e.preventDefault();
			        	  $.ajax({
					            type: frm.attr('method'),
					            url: frm.attr('action'),
					            data: frm.serialize(),
					            dataType: "json",
					            success: function(e){ 
					            	console.log(e.error);
					            	
					            	
					            	if(e.error!="none"){
					            		var msgtext = '<div class="content-modal has-action">' +
										'				<h2>REGULARIZACIÓN DE CUENTA</h2>' +
										'				<p><b>'+e.error+'</b></p><p>Ingresa el correo electrónico que has registrado en tu cuenta de La Tinka. No te preocupes, en caso te has olvidado ingresa un nuevo correo. Al cuál enviaremos un correo para que actives tu cuenta.</p>' +
										'			<form class="form-register" action="send_user_mail_verify_account.html" method="post" id="frm-user-send-verify-account" data-response-type="json">' +
										'				<div class="control-form">' +
										'					<input class="control-custom" type="email" id="email-usr" name="email-usr" autocomplete="off" placeholder="Correo electrónico" style="background-color: rgba(0, 0, 0, 0.4);" required />' +
										'                   <input type="hidden" name="clientId" value="'+e.clientId+'">'  +
										'                   <input type="hidden" name="clientMail" value="'+e.clientMail+'">'  +
										'                   <input type="hidden" name="clientMailCode" value="'+e.clientMailCode+'">'  +
										'                   <input type="hidden" name="clientName" value="'+e.clientName+'">'  +
										'				</div>' +
										'		   	 	<div class="error" id="alertVerify"></div>' +
										'				<div class="control-form"><i></i>' +
										'					<button id="btn-send-user-verify-account" class="js-close-modal btn btn-orange white" type="button">ENVIAR</button>' +
										'				</div>' +
										'			</form><br/><br/>' +
										'</div>';
					            		$('#popup .main-modal').html(msgtext);
							        	openModal("#popup","");

							        	 $('#btn-send-user-verify-account').click(function (event){
												//validamos el regex mail
								        		var emailPattern = new RegExp('/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/');
								                var emailRes = emailPattern.test($('#email-usr').val());

								                if(!emailRes){
									                $('#alertVerify').html("Ingrese un e-mail v&aacute;lido");
													return false;
										        }

								                var frm = $("#frm-user-send-verify-account");

										        frm.submit(function (e) {
										        	e.preventDefault();
										        	  $.ajax({
												            type: frm.attr('method'),
												            url: frm.attr('action'),
												            data: frm.serialize(),
												            dataType: "json",
												            success: function(e){ 

																	console.log(e.status);
																	console.log(e.message);				

													            }
												            });
											    	});
							        			});
					            	}
					            	
					            }
					        });
			        	});

			       
	
			        });

	        	*/

			        /*
			        $.ajax({
			            type: frm.attr('method'),
			            url: frm.attr('action'),
			            data: frm.serialize(),
			            success: function(e){ 
			            	console.log(e.error);
			            	
			            	if(e.error="none"){
			            		$('#popup .main-modal').html(response.error);
					        	openModal("#popup","");
			            	}
			            	
			            }
			        });
		        	*/ 
				//});

/*$.ajax({
	  url: "${bannersUrl}banners.xml",
	  cache: false,
	  success: function(res) {
	  	var xmlDoc = res;
	  	var data = xmlDoc.getElementsByTagName("data");
	  	if (data && data[0]) {
	  		data = data[0];
	  		var banners = data.getElementsByTagName("banner");

	  		createBanner(banners, '#banner .swiper-wrapper');

  	  	var swiper = new Swiper('#banner .swiper-container', {
        		pagination: '#banner .swiper-pagination',
        		paginationClickable: true,
        		autoplay: 2500,
        		autoplayDisableOnInteraction: false,
        		// autoplayStopOnLast: true,
        		loop: true
        	});
        	
	  	} else {
	  		console.log('no data')
	  	}

	  }, error: function(e) {
	  	console.log('error obteniendo xml...')
	  }
	});

		      	$.ajax({
			      	  url: "${bannersUrl}bannersp.xml",
			      	  cache: false,
			      	  success: function(res) {
			      	  	var xmlDoc = res;
			      	  	var data = xmlDoc.getElementsByTagName("data");
			      	  	if (data && data[0]) {
			      	  		data = data[0];
			      	  		var banners = data.getElementsByTagName("banner");

			      	  		createBanner(banners, '#bannerp .swiper-wrapper');

				    	  	var swiper = new Swiper('#bannerp .swiper-container', {
			              		pagination: '#bannerp .swiper-pagination',
			              		paginationClickable: true,
			              		autoplay: 2500,
			              		autoplayDisableOnInteraction: false,
			              		// autoplayStopOnLast: true,
			              		loop: true
				          	});
				          	
			      	  	} else {
			      	  		console.log('no data')
			      	  	}

			      	  }, error: function(e) {
			      	  	console.log('error obteniendo xml...')
			      	  }
			      	});*/


			      	$(document).ready(function(){
						
			      		$('#user').val('');
			      		$('#password').val('');
			      		 $('#ingresar').attr('disabled', true);
			      		renderRegisterForm();
						
						
					});

			      	
			      	

		      	/*$('#client_user_remminder').click(function(event) {
			      	
			      	var msgtext = '<div class="content-modal has-action over-visible">' +
					'				<h2>¿OLVIDASTE TU USUARIO?</h2>' +
					'				<p><b>Asegúrate que el usuario y contraseña que ingresaste estén correctamente digitados sin espacios entre los caracteres.</b></p><p>Si verificaste y aún así no puedes ingresar a tu Cuenta, descuida lo enviaremos a tu correo, ingresa el correo electrónico que has registrado en tu cuenta de La Tinka.</p>' +
					'			<form class="form-register" action="send_user_mail.html" method="post" id="frm-user-send" data-response-type="json">' +
					'				<div class="control-form">' +
					'					<input class="control-custom" type="email" id="email-usr" name="email-usr" autocomplete="off" placeholder="Correo electrónico" required />' +
					'				</div>' +
					'		   	 	<div class="error" id="alert"></div>' +
					'				<div class="control-form"><i></i>' +
					'					<button id="btn-send-user" class="js-close-modal btn btn-orange white" type="button">ENVIAR</button>' +
					'				</div>' +
					'			</form>' +
					'</div>';
					
		            $('#popup .main-modal').html(msgtext);
		        	openModal("#popup","");
		        	taggingOlvidasteUsuario();
		        	//$('#frm-user-reminder').on('submit', function(event) {
		        	$('#btn-send-user').click(function(){
			      		event.preventDefault();
			            var $form = $("#frm-user-send");
			            var ico = $(this).siblings('i');
			            $.ajax({
			                url: $form.attr('action'),
			                data: $form.serialize(),
			                type: $form.attr('method'),
			                dataType: $form.data('response-type'),
			                beforeSend: function() {$('#btn-send').prop('disabled', true);$(ico).addClass('loading');}
			                    //$("#btn-send").css({"background-position": "0 -35px"});
			                //},success: function(a) {
		                }).done(function(d) {
		                	$(ico).removeClass('loading');
		                    if (d.message === 'OK') {
		                        //$('#send').show();
		                        $("div#alert").html("");
		                        $('#popup .main-modal').html("<div class='info'></div><p>"+d.send+"</p>");
		                        taggingTuUsuarioEnviado();
		                    } else if (d.message === 'KO') {
		                    	$("div#alert").html(d.send);
		                    	
		                    } else {
		                    	$("div#alert").html(d.message);
		                    	taggingCorreoNoRegistrado(d.message);
		                    }
		                    $('#btn-send').prop('disabled', false);
		                    //$("#btn-send").css({"background-position": "0 0"});
		                  //},error: function() {
		                }).fail(function() {
		                	$(ico).removeClass('loading');
		                	$("div#alert").html("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
		                    $('#btn-send').prop('disabled', false);
		                    //$("#btn-send").css({"background-position": "0 0"});
		                }).always(function() {
		                });
			        });
		      	});*/
		      	$('#client_password_change').click(function(event) {
			      	
		      		var msgtext = '<div class="content-modal has-action">' +
					'				<h2>¿OLVIDASTE TU CONTRASEÑA?</h2>' +
					'				<p><b>No te preocupes, enviaremos un código de autorización a tu correo para crear tu nueva contraseña.</b></p><p>Ingresa el correo electrónico que has registrado en tu cuenta de La Tinka.</p>' +
					'			<form class="form-register" action="send_password_mail.html" method="post" id="frm-user-send" data-response-type="json">' +
					'				<div class="control-form">' +
					'					<input class="control-custom" type="email" id="email-usr" name="email-usr" autocomplete="off" placeholder="Correo electrónico" required />' +
					'				</div>' +
					'		   	 	<div class="error" id="alert"></div>' +
					'				<div class="control-form"><i></i>' +
					'					<button id="btn-send-password" class="js-close-modal btn btn-orange white" type="button">ENVIAR</button>' +
					'				</div>' +
					'			</form><br/><br/>' +
					'			<form class="form-register" action="change_password.html" method="post" id="frm-user-send2" data-response-type="json">' +
					'				<input type="hidden" id="email" name="email">' +
					'				<div class="control-form">' +
					'					<label>Con el código enviado a tu correo cambia tu contraseña aquí</label>' +
					'					<input class="control-custom" type="text" id="cod-autorizacion" name="cod-autorizacion" autocomplete="off" placeholder="Código de autorización" required />' +
					'				</div>' +
					'				<div class="control-form">' +
					'					<input class="control-custom" type="password" id="new-pass" name="new-pass" autocomplete="off" placeholder="Nueva contraseña" required />' +
					'				</div>' +
					'				<div class="control-form">' +
					'					<input class="control-custom" type="password" id="new-pass2" name="new-pass2" autocomplete="off" placeholder="Confirma contraseña" required />' +
					'				</div>' +
					'		   	 	<div class="error" id="alertChange"></div>' +
					'				<div class="control-form"><i></i>' +
					'					<button id="btn-accept" class="js-close-modal btn btn-orange white" type="button">ACEPTAR</button>' +
					'				</div>' +
					'			</form><br/>' +
					'</div>';
		            $('#popup .main-modal').html(msgtext);
		        	openModal("#popup","");
		        	taggingOlvidasteContrasenia();
			      	$('#btn-send-password').click(function(){
				      	
			      		event.preventDefault();
			            var $form = $("#frm-user-send");
			            var ico = $(this).siblings('i');
			            $.ajax({
			                url: $form.attr('action'),
			                data: $form.serialize(),
			                type: $form.attr('method'),
			                dataType: $form.data('response-type'),
			                beforeSend: function() {$('#btn-send').prop('disabled', true);$(ico).addClass('loading');}
			                    //$("#btn-send").css({"background-position": "0 -35px"});
			                //}, success: function(a) {
			            }).done(function(d) {
			            	$(ico).removeClass('loading');
		                    if (d.message === 'OK') {
		                        //$('#send').hide();
		                        //$('#send2').show();
		                        $("div#alert").html(d.send);
		                        $('#email').val(d.email);
		                        taggingEmailEnviado();
		                    } else if (d.message === 'KO') {
		                    	$("div#alert").html(d.send);
		                    } else {
		                    	$("div#alert").html(d.message);
		                    	tagginErrorEnviarEmail(d.message);
		                    }
		                    $('#btn-send').prop('disabled', false);
		                    //$("#btn-send").css({"background-position": "0 0"});
				          //}, error: function() {
			            }).fail(function() {
			            	$(ico).removeClass('loading');
		                	$("div#alert").html("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
		                    $('#btn-send').prop('disabled', false);
		                    //$("#btn-send").css({"background-position": "0 0"});
			            }).always(function() {
			            });
			        });
			        //$('#frm-user-send2').on('submit', function(event) {
			        $('#btn-accept').click(function(){
				      
			        	event.preventDefault();
			            var $form = $("#frm-user-send2");
			            var ico = $(this).siblings('i');
			            $.ajax({
			                url: $form.attr('action'),
			                data: $form.serialize(),
			                type: $form.attr('method'),
			                dataType: $form.data('response-type'),
			                beforeSend: function() {$('#btn-accept').prop('disabled', true);$(ico).addClass('loading');}
			                    /*$("#btn-accept").css({"background-position": "0 -35px"});
			                    $('#btn-cancel').prop('disabled', true);
			                    $("#btn-cancel").css({"background-position": "0 -35px"});*/
			                //},success: function(a) {
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
									$("div#alertChange").html("");
			                        $('#popup .main-modal').html("<div class='info'></div><p>"+d.send+"</p>");
			                        taggingContraseniaActualizada();
								}
								
		                    } else if (d.message === 'KO') {
			                   
		                    	$("div#alertChange").html(d.send);
		                    
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
		                  /*  if(d.message==){
		                    	var newstr = str.replace(d.message, "oranges");
			                    }*/
			                   
		                    
		                    $('#btn-accept').prop('disabled', false);
		                    /*$("#btn-accept").css({"background-position": "0 0"});
		                    $('#btn-cancel').prop('disabled', false);
		                    $("#btn-cancel").css({"background-position": "0 0"});*/
				          //},error: function() {
			            }).fail(function() {
			            	$(ico).removeClass('loading');
		                	$("div#alert").html("¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
		                    $('#btn-accept').prop('disabled', false);
		                    /*$("#btn-accept").css({"background-position": "0 0"});
		                    $('#btn-cancel').prop('disabled', false);
		                    $("#btn-cancel").css({"background-position": "0 0"});*/
			            }).always(function() {
			            });
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
		      	      //$('#alertLogin').addClass('remove-error');
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
				 $form = $('#security_login_execute_authentication');	
		      	 renderTermsField();
		      	renderNewPasswordField();
		      	  
		      	  // validate fields
		      	  $.validate({
		      	    form: '#security_login_execute_authentication',	
		      	  	modules: 'security, date, logic',	      	    
		      	    scrollToTopOnError: false,		      	  			      	    
		      	    onElementValidate : function(valid, $el, $form) {
		      	      if ($form.isValid({}, {}, false)) {
		      	        $('#ingresar').attr('disabled', false);
		      	      } else {
		      	        $('#ingresar').attr('disabled', true);
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
		      	   
		      		var  $form = $('#security_login_execute_authentication'),
		      	    onChangeTerms;
		      	  
		      	  var $user = $('#user');
		      	  var $password = $('#password');
		      	  

		      	  onChangeTerms = function () {
		      				      			
		      	    if ($form.isValid({}, {}, false)) {
		      	      $('#ingresar').attr('disabled', false);
		      	    
		      	    } else {
		      	      $('#ingresar').attr('disabled', true);
		      	      
		      	    }
							      	  	
		      	  };
		      	  		      	  
		      	  $user.on('keyup', onChangeTerms);
		      	  $password.on('keyup', onChangeTerms);
		      	  		      	  
		      	};

		      	 $("#client_password_change_new").click(function(){	 
		      	    window.location.href = 'recuperar-contrasenia.html';   
		      	});

		      	$("#client_user_remminder_new").click(function(){	 
		      	    window.location.href = 'recuperar-user.html';   
		      	});

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
		      	
				
		      	//if(operatorId!=null && (operatorId == "5587" || operatorId == "5588")) $('#client_password_change_new').trigger("click");
		      	if(operatorId!=null && (operatorId == "5587" || operatorId == "5588")) window.location.href = 'recuperar-contrasenia-ta.html';
		      	
  	</script>
  	<div id="confirm_content" style="display:none">
		<div id="confirmModal_content_id" class="confirmModal_content">
		</div>
		<div class="confirmModal_footer">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">CERRAR</button>
			<!-- button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">ACEPTAR</button -->
		</div>
	</div>
	
		
	
		<script>
		$('#btn_mobile_ingresar').addClass('desactive');
	</script>
	
</body>
</html>