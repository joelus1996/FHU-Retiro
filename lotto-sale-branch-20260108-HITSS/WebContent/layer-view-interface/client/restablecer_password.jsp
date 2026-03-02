<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isRestoreSale == false}"><c:redirect url="${lotocardSrv}i.do?m=inicio"/></c:if>
<!DOCTYPE html>
<html lang="es">
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

    <meta charset="utf-8">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=2">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/carousel.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/restablecerUser.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=12">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/bocadilloContrasena.css">
	<meta name="viewport" content="width=1024">
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <title>Restablecer Contraseña - Intralot de Perú</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

    <%@ include file="../include/header.jspf"%>

	

	<div class="main-content">
		<div class="main-page">

			<div class="row">

				<div class="col-12 col-md-8">

			        <div class="wrapper-form">
			        	
			        	<div id="send2" style="display: block">
							<i></i>
				        	<form class="form-cambiar-password" id="frm-user-send2" action="update-password.html" method="post">
				        		<input type="hidden" id="codigoPass" name="codigoPass" value='${codigoPass}'>
								<input type="hidden" id="email" name="email" value='${email}'>
				        		<div class="head-main-form">
				        			<h2>RECUPERA O CAMBIA TU CONTRASEÑA</h2>
				        			<div class="sub-head-form" style="padding-left: 0px;">
				        				<p style="text-align: left;">INGRESA TU NUEVA CONTRASEÑA.</p>
				        			</div>
				        		</div>

				        		<div class="body-main-form">

					        		<div class="box-main-form" style="padding-bottom: 0px; padding-top:0px;">

						        		<div class="row">
						        		
<!-- 						        			<div class="form-group col-sm-1"></div> -->

			        				  		<div class="form-group col-sm-6" style="text-align: center;padding-right: 10px;">
				        				  						        				  							        				  			
				        				  			<!-- <div  class="control-form link__security_pass" style="text-align: left; margin-bottom: 30px;">
													 	<span class="icon-security-pass"></span><a href="javascript:void(0);" onclick="openSecurityPass();" class='link link__base'>Crea una contraseña segura</a>
													</div>  -->
				        				  			
				        				  			<div id="form-new-password" class="control-form" style="font-size: 16px;">
													 	<label for="password">Nueva contraseña</label>
														<input type="password" class="new-password" name="password" id="password" autocomplete="new-password" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
														<button class="view-password" type="button" id="toglePassword"></button>
						                  				<div class="strength-meter">&nbsp;</div>
													</div>
				        				  			
				        				  			<div id="form-confirmation-password" class="control-form" style="font-size: 16px;">
													 	<label for="new-password">Confirmar contraseña</label>
														<input type="password" class="confirm-password" name="new-password" id="new-password" autocomplete="new-password2" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
														<button class="view-password2" type="button" id="toglePassword-confirmation"></button>
						                  				<div class="strength-meter">&nbsp;</div>
													</div><br>
				        				  		
				        				  		<button id="btn-accept" type="submit" class="button button-orange-light btn-block no-margin green" style="width: 100%;font-size: 16px;height: 45px;border-radius: 1.45em;">CAMBIAR</button>

			        				  		</div>
			        				  		
			        				  		<!--  <div class="form-group col-sm-6">
			        				  			<div  class="control-form">
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
												</div>
			        				  		</div> -->

						        		</div>

					        		</div>

				        	  	</div>

				        	  	

				        	</form>

				        </div>

			        </div>

		        </div>

		        <div class="col-12 col-md-4">
		        	
		        	<aside class="banner">

		        		<div class="boxes-banner">

			        			<div id="iframeTool">
		        					<iframe id="myIframe" src="${iframeHomeMicuentaURL}" frameborder="0" scrolling="no" ><p>Is imposible, your browser dont support iframe</p></iframe>
		        				</div>
                                

		        		</div>

		        	</aside>

		        </div>

	        </div>

        </div>
        
        <div id="popup" class="overlay">
				<div class="popup popup-sm recuperar-password">								
					<div class="main-modal" id="msg-confirmacion"></div>
								
				</div>
		</div>
        
        
	</div>
	<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=1"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
     <script type="text/javascript" src="layer-view-script/common/jquery.validator.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.carouFredSel.js"></script>
    <script type="text/javascript" src="layer-view-script/client/restablecerUsers.js?v=4"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=11"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
<!--     <script type="text/javascript" src="layer-view-script/common/captcha.js"></script> -->
	<%@ include file="../include/footer.jspf"%>
    <%@ include file="../include/message.jspf"%>
    <script type="text/javascript">

		$(document).ready(function(){

			$.ajax({
			  url: $("#gamesXML").val(),
			  cache: false,
			  success: function(res) {
			  	var xmlDoc = res;
			  	data = xmlDoc.getElementsByTagName("data");
			  	if (data[0]) {
			  		
			  		data = data[0];

			  		var pozo_tinka = "S/ " + data.getElementsByTagName("tk_pozo")[0].childNodes[0].nodeValue;
			  		$("#pozo-tinka").html(pozo_tinka);

			  		var pozo_kabala = "S/ " + data.getElementsByTagName("kb_pozo")[0].childNodes[0].nodeValue;
                    $("#pozo-kabala").html(pozo_kabala);

                    var pozo_ganadiario = "S/ " + data.getElementsByTagName("gd_premio")[0].childNodes[0].nodeValue;
                    $("#premio-ganadiario").html(pozo_ganadiario);

			  	} else {
			  		console.log('no data')
			  	}

			  }, error: function(e) {
			  	console.log('error obteniendo xml...')
			  }
			});

			$('#btn-accept').attr('disabled', true);
			renderCambiarContraseniaForm();

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
			 $form = $('#frm-user-send2');
	    	 renderTermsNewField();
	    	 renderNewPasswordField();
	    	  
	    	  // validate fields
	    	  $.validate({
	    	    form: '#frm-user-send2',	
	    	  	modules: 'security, date, logic',	      	    
	    	    scrollToTopOnError: false,
	    	    onModulesLoaded: function () {
	    	        var config = {
	    	          bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@). <br> No usar tus últimas 6 contraseñas.</span>',
	    	          weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@). <br> No usar tus últimas 6 contraseñas.</span>',
	    	          good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
	    	          strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
	    	        };
	    	        $('#password').displayPasswordStrength(config);
	    	        $('#new-password').displayPasswordStrength(config);
	    	       
	    	      },		      	  			      	    
	    	    onElementValidate : function(valid, $el, $form) {
	    	      if ($form.isValid({}, {}, false)) {
	    	        $('#btn-accept').attr('disabled', false);
	    	      } else {
	    	        $('#btn-accept').attr('disabled', true);
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
	     	   
	    		var  $form = $('#frm-user-send2'),
	    	    onChangeTerms;
	    	     	  
	    	  	var $correo1 = $('#password');
	    	  	var $correo2 = $('#new-password');
	    	  
	    	  	onChangeTerms = function () {
	    		
		    	    if ($form.isValid({}, {}, false)) {
		    	      $('#btn-accept').attr('disabled', false);
		    	    } else {
		    	      $('#btn-accept').attr('disabled', true);
		    	      		    	     
		    	      
		    	    }
	    	  };

	    	  
	    	  		      	     	  
	    	  $correo1.on('keyup', onChangeTerms);
	    	  $correo2.on('keyup', onChangeTerms);
	    	  		      	  
	    	};

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

	    	 function goHome(){			
		    		window.location.href = 'inicio.html';  
		      }

	</script>


</body>
</html>