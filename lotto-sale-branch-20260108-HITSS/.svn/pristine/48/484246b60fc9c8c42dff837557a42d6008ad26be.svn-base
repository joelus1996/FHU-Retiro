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
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/carousel.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/restablecerUser.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
	<meta name="viewport" content="width=1024">
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <title>Restablecer Contraseña - La Tinka</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

    <%@ include file="../include/header.jspf"%>

	
<div class="ilot">
	<div class="main-content">
		<div class="main-page">

			<div class="row">

				<div class="col-12 col-md-8">

			        <div class="wrapper-form">

			        	<div id="send" style="display: block">
							
							<i></i>
				        	<form id="frm-user-send" action="send_password_mail.html" method="post">
				        	<input type="hidden" id="game" name="game" value="1">

				        		<div class="head-main-form">
				        			<h2>RECUPERA O CAMBIA TU CONTRASE&Ntilde;A</h2>
				        			<div class="sub-head-form">
				        				<p class="no-upper"><span style="font-size: 15.4px;font-family: Roboto, sans-serif;">Confírmanos tu tipo y número de documento, enviaremos a tu correo registrado las instrucciones para cambiar tu contraseña.</span></p>
				        			</div>
				        		</div>

				        		<div class="body-main-form">

					        		<div class="box-main-form" style="padding-top: 15px;">
						        		 
			        				  		<div class="form-group offset-sm-0 col-sm-12 offset-md-2 col-md-10" style="text-align: center;padding-right: 5px;padding-left: 5px; margin: 0 auto;">

				        				  				<div class="row">
				        				  					<div class="offset-sm-0 col-sm-6  col-md-6">
					        				  					<div class="control-form form__select has-success" id="divNumberDoc">		
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
												                <div class="control-form form__input form__optional show" id="divNumberDoc">
																 	<label for="document-number">Número de documento</label>
																	<input type="text" name="document-number" id="document-number" autocomplete="off" 
																	maxlength="8" data-validation="length number" data-validation-length="8" 
																	data-validation-error-msg="Ingresa un DNI válido" data-validation-depends-on="document-type" 
																	data-validation-depends-on-value="DNI" style="font-size: 16px !important;">
																</div>
																<div class="control-form form__input form__optional" id="div-documento-pasap">
																 	<label for="document-number-pasap">Número de documento</label> 
												                    <input type="text" name="document-number-pasap" autocomplete="off" 
												                    id="document-number-pasap" maxlength="12" data-validation="length alphanumeric" 
												                    data-validation-length="min9max12" data-validation-error-msg="Ingresa un Pasaporte válido" 
												                    data-validation-depends-on="document-type" data-validation-depends-on-value="PASAP" 
												                    style="font-size: 16px !important;">
																</div>
																<div class="control-form form__input form__optional" id="div-documento-carex">
																 	<label for="document-number-carex">Número de documento</label> 
												                    <input type="text" name="document-number-carex" autocomplete="off" id="document-number-carex" 
												                    maxlength="12" data-validation="length alphanumeric" data-validation-length="min9max12" 
												                    data-validation-error-msg="Ingresa un Carnet de Extranjería válido" data-validation-depends-on="document-type" 
												                    data-validation-depends-on-value="CAREX" style="font-size: 16px !important;">
																</div>
															</div>
										                </div>										                

														<br><br><br>
													<div class="offset-sm-0 col-sm-6  col-md-9" style="margin: 0 auto;">
														<button id="btn-send" type="submit" class="button button-orange-light no-margin green" style="width: 90%;font-size: 16px;height: 45px;border-radius: 1.45em;">ENVIAR</button>
													</div>		
			        				  		</div>
														        	  			
				        	 			        	  							        		
					        		</div>
					        		
					        						        		
				        	  	</div>

				        					        	  				        	 
				        	</form>

			        	</div>

			        	<div id="send2" style="display: none"><!-- none actual  -->

				        	<form id="frm-user-send2" action="update-password.html" method="post">
								<input type="hidden" id="email" name="email">
				        		<div class="head-main-form">
				        			<h2>RECUPERA TU CONTRASEÑA</h2>
				        			<div class="sub-head-form">
				        				<p>INGRESA TU NUEVA CONTRASEÑA.</p>
				        			</div>
				        		</div>

				        		<div class="body-main-form">

					        		<div class="box-main-form">

						        		<div class="row">

			        				  		<div class="form-group col-sm-12">

				        				  		<div class="row">
				        				  							        				  			
				        				  			<div class="form-group2 col-sm-12 col-md-6">
				        				  				<!-- <input type="password" class="form-control" id="new-pass" class="text-in" name="new-pass" autocomplete="off" required="required"> -->
				        				  				<label for="password">Nueva contraseña</label>
														<input type="password" name="password" id="password" autocomplete="new-password" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
														<button class="view-password" type="button" id="toglePassword"></button>
						                  				<div class="strength-meter">&nbsp;</div>
				        				  			</div>
				        				  			
				        				  			<div class="form-group2 col-sm-12 col-md-6">
				        				  				<!--  <input type="password" class="form-control" id="new-pass2" class="text-in" name="new-pass2" autocomplete="off" required="required">-->
				        				  				<label for="new-password">Confirmar contraseña</label>
														<input type="password" name="new-password" id="new-password" autocomplete="new-password2" data-validation="strength" data-validation-strength="1" data-validation-error-msg="&amp;nbsp;">
														<button class="view-password2" type="button" id="toglePassword-confirmation"></button>
						                  				<div class="strength-meter">&nbsp;</div>
				        				  			</div>
				        				  		</div>

			        				  		</div>

						        		</div>

					        		</div>

				        	  	</div>

				        	  	<div class="footer-main-form">

				        	  		<div class="action-main-form button-blocks">

				        	  			<div class="row">

				        	  				<div class="col-sm-6" style="margin-left: 150px;">
				        	  					<button id="btn-accept" type="submit" class="button button-orange-light btn-block no-margin green">CAMBIAR</button>		
				        	  				</div>				        	  				

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
				<a class="close-popup " id="close-popup-message" onclick="closePopup(this)">&times;</a>							
					<div class="main-modal" id="msg-confirmacion"></div>
								
				</div>
			</div>
        
        
	</div>
	</div>
	<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
     <script type="text/javascript" src="layer-view-script/common/jquery.validator.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.carouFredSel.js"></script>
    <script type="text/javascript" src="layer-view-script/client/restablecerUsers.js?v=4"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
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

			$('#btn-send').attr('disabled', true);
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

	    	  
	    	  // validate fields
	    	  $.validate({
	    	    form: '#frm-user-send',	
	    	  	modules: 'security, date, logic',	      	    
	    	    scrollToTopOnError: false,		      	  			      	    
	    	    onElementValidate : function(valid, $el, $form) {
	    	      if ($form.isValid({}, {}, false)) {
	    	        $('#btn-send').attr('disabled', false);
	    	      } else {
	    	        $('#btn-send').attr('disabled', true);
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
	    	     	  
	    		var $dni = $('#document-number');
	    	  	var $pasap = $('#document-number-pasap');
	    	  	var $carex = $('#document-number-carex');
	    	  
	    	  	onChangeTerms = function () {
	    		
		    	    if ($form.isValid({}, {}, false)) {
		    	      $('#btn-send').attr('disabled', false);
		    	    } else {
		    	      $('#btn-send').attr('disabled', true);
		    	    }
	    	  };
	    	  		      	     	  
	    	  $dni.on('keyup', onChangeTerms);
	    	  $pasap.on('keyup', onChangeTerms);
	    	  $carex.on('keyup', onChangeTerms);
	    	  		      	  
	    	};

	</script>
	
</body>
</html>