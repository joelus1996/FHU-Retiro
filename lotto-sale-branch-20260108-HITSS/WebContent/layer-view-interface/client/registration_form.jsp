<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
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
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/signUp.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/carousel.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
	<meta name="viewport" content="width=1024">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <title>Registro - La Tinka</title>
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

				<div id="wrapper-form" class="col-12 col-md-8">

			        <div  class="wrapper-form">

			        	<div id="register" style="display: block">

				        	<form id="frm-user-register" action="registrar.html" method="post">
				        	<c:if test="${OperatorId eq 5587}"><button type="button" id="to-lapolla" class="button button-light-orange"><span></span><b>VOLVER A LA POLLA</b></button></c:if>
							<c:if test="${OperatorId eq 5588}">
								<c:if test="${redirectGame ne 'DV'}">
								<button type="button" id="to-tav2" class="button button-light-orange"><span></span><b>VOLVER A TE APUESTO</b></button>
								</c:if>
								<c:if test="${redirectGame eq 'DV'}">
								<button type="button" id="to-tav2-ddvv" class="button button-light-orange"><span></span><b>VOLVER A DEPORTES VIRTUALES</b></button>
								</c:if>
							</c:if>
				        		<div class="head-main-form">
				        			<h2>REGÍSTRATE</h2>
				        			<div class="sub-head-form">
				        				<p>Completa tus datos en todos los campos. Luego te llegará un SMS a tu celular registrado con un código para activar tu cuenta.</p>
				        			</div>
				        		</div>

				        		<div class="body-main-form">

					        		<div class="box-main-form">

						        		<div class="row">

					        				<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="text" class="form-control" id="name" name="name" autocomplete="off" required="required" placeholder="Nombre">
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="text" class="form-control" name="user-client" id="user" autocomplete="off" maxlength="25" required="required" placeholder="USUARIO">
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="text" class="form-control" name="ap-paterno" id="last-name-paternal" autocomplete="off" required="required" placeholder="Apellido Paterno">
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="text" class="form-control" name="email" id="email" autocomplete="off" required="required" placeholder="nombre@correo.com.pe">
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="text" class="form-control" name="ap-materno" id="last-name-maternal" autocomplete="off" required="required" placeholder="Apellido Materno">
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="password" class="form-control" name="password-client" id="password" autocomplete="off" maxlength="30" required="required" placeholder="Contraseña">
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">

				        				  		<div class="row no-gutters">
				        				  			<div class="col-sm-2">
				        				  				<p class="form-control-static">SEXO</p>
				        				  			</div>
				        				  			<div class="col-sm-10">
				        				  				<div class="form-check form-main-check form-check-inline">
				        				  					<p class="form-control-static">
					        				  				  	<label class="form-check-label">
					        				  				    	<input class="form-check-input" type="radio" name="gender" value="M" id="male" required="required"> Masculino
					        				  				  	</label>
				        				  				  	</p>
				        				  				</div>
				        				  				<div class="form-check form-main-check form-check-inline">
				        				  					<p class="form-control-static">
				        				  				  		<label class="form-check-label">
					        				  				    	<input class="form-check-input" type="radio" name="gender" value="F" id="female" required="required"> Femenino
				        				  				  		</label>
				        				  				  	</p>
				        				  				</div>
				        				  			</div>
				        				  		</div>

			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="password" class="form-control" name="re-password" id="re-password" autocomplete="off" required="required" placeholder="Confirmar Contraseña">
			        				  		</div>

						        		</div>

					        		</div>

					        		<div class="box-main-form">

					        			<div class="row">
					        				
					        				<div class="form-group col-sm-12 col-md-6">
			        				  			<div class="row">
			        				  				<div class="col-sm-6">
			        				  					<p class="form-control-static">Fecha de nacimiento:</p>
			        				  				</div>
			        				  				<div class="col-sm-6">
			        				  					<div class="custom-select" data-select="day">
			        				  						<input type="text" style="border: none;" class="form-control" name="op-sel-day" id="op-sel-day" autocomplete="off" required="required" placeholder="Día" >
			        				  					    <ul class="option-list" id="x-day" data-select="day"></ul>
			        				  					</div>
			        				  					<select class="form-control select" name="day" id="day" required="required"></select>
			        				  				</div>
			        				  			</div>
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<div class="row">
			        				  				<div class="col-sm-6">
			        				  					<div class="custom-select" data-select="month">
			        				  						<input type="text" style="border: none;" class="form-control" name="op-sel-month" id="op-sel-month" autocomplete="off" required="required" placeholder="Mes">
			        				  					    <ul class="option-list" id="x-month" data-select="month"></ul>
			        				  					</div>
			        				  					<select class="form-control select" name="month" id="month" required="required"></select>
			        				  				</div>
			        				  				<div class="col-sm-6">
			        				  					<div class="custom-select" data-select="year">
			        				  						<input type="text" style="border: none;" class="form-control" name="op-sel-year" id="op-sel-year" autocomplete="off" required="required" placeholder="A&ntilde;o">
			        				  					   
			        				  					    <ul class="option-list" id="x-year" data-select="year"></ul>
			        				  					</div>
			        				  					<select class="form-control select" name="year" id="year" required="required"></select>
			        				  				</div>
			        				  			</div>
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<div class="row">
			        				  				<div class="col-sm-5" style="white-space: nowrap;">
			        				  					<p class="form-control-static">Tipo de Documento:</p>
			        				  				</div>
			        				  				<div class="col-sm-7">
			        				  					<div class="custom-select" data-select="document-type">
			        				  						<input type="text" style="border: none;" class="form-control" name="op-sel-document-type" id="op-sel-document-type" autocomplete="off" required="required" placeholder="seleccione">
			        				  					    <ul class="option-list" id="x-document-type" data-select="document-type"></ul>
			        				  					</div>
			        				  					<select class="form-control select" name="document-type" id="document-type" required="required"></select>
			        				  				</div>
			        				  			</div>
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="text" class="form-control" name="document-number" autocomplete="off" required="required" placeholder="Número de Documento">
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
				                                <div class="custom-select" data-select="country" id="switch-country">
				                                	<input type="text" style="border: none;" class="form-control" name="op-sel-country" id="op-sel-country" autocomplete="off" required="required" placeholder="País">
				                                    <ul class="option-list" id="x-country" data-select="country"></ul>
				                                </div>
				                                <select class="form-control select" name="country" id="country" required="required">
	                                            <option value="">seleccione</option>
				                                <c:forEach var="country" items="${countries}">
	                                            <option value="<c:out value="${country.countryId}"/>"><c:out value="${country.countryName}"/></option>
	                                            </c:forEach>
	                                            </select>
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
				                                <div class="custom-select" data-select="region" id="switch-region">
				                                	<input type="text" style="border: none;" class="form-control" name="op-sel-region" id="op-sel-region" autocomplete="off" required="required" placeholder="Departamentos">
				                                    <ul class="option-list" id="x-region" data-select="region"></ul>
				                                </div>
				                                <select class="form-control select" name="region" id="region" required="required">
	                                            <option value="">seleccione</option>
				                                <c:forEach var="region" items="${regions}">
	                                            <option value="<c:out value="${region.regionId}"/>"><c:out value="${region.regionName}"/></option>
	                                            </c:forEach>
	                                            </select>
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
				                               	<div class="custom-select" data-select="comMovil" id="switch-comMovil">
				                               		<input type="text" style="border: none;" class="form-control" name="op-sel-comMovil" id="op-sel-comMovil" autocomplete="off" required="required" placeholder="Operador">
	                                                <span id="op-sel-comMovil" class="placeholder"></span>
	                                                <ul class="option-list" id="x-comMovil" data-select="comMovil"></ul>
	                                            </div>
			                                   <select class="form-control select" name="comMovil" id="comMovil" required="required">
			                                   		<option value="0" selected="selected" disabled="disabled" hidden="true"></option>                  
	                                                <option value="TELEF">Telef&oacute;nica</option>
	        										<option value="CLARO">Claro</option>
	        										<option value="ENTEL">Entel</option>
	        										<option value="BITEL">Bitel</option>
	                                            </select>
			        				  		</div>

			        				  		<div class="form-group col-sm-12 col-md-6">
			        				  			<input type="text" class="form-control" name="mobile-phone" id="mobile-phone" placeholder="Número celular (ejem. 912345678) " required="required">
			        				  		</div>

					        			</div>

					        		</div>

				        	  	</div>

				        	  	<div class="footer-main-form">

				        	  		<div class="radios-main-form">
				        	  		
					        	  		<div class="form-check">
					        	  		  <label class="form-check-label">
					        	  		    <input class="form-check-input" id="terms" type="checkbox" name="terms" value="1" required="required" checked="checked">
					        	  		    <b><a class="js-terms footer-main-link" href="#">Acepto los Términos y Condiciones</a></b> * obligatorio
					        	  		  </label>
					        	  		</div>
					        	  		<div class="form-check">
					        	  		  <label class="form-check-label">
					        	  		    <input class="form-check-input" id="confirm" type="checkbox" name="confirm" value="Y" checked="checked">
					        	  		    <b>Deseo recibir promociones y noticias a mi correo electrónico y/o celular brindado.</b>
					        	  		  </label>
					        	  		</div>

				        	  		</div>

				        	  		<p>Los datos que registres deben ser verídicos. El pago de premios sólo se hará al titular de la cuenta virtual por lo que deberás presentar tu documento de identidad al momento de presentarte a cobrar tu premio sujetándote al proceso de verificación de tu cuenta.</p>

				        	  		<div class="action-main-form">
				        	  			
				        	  			<button type="submit" class="button button-orange-light">REGÍSTRAME</button>

				        	  		</div>

				        	  	</div>
							<input type="hidden" name="urlRedirect5588" id="urlRedirect5588" value="<c:out value='${urlRedirect5588}' />">	
							<input type="hidden" name="ref" id="ref" value="<c:out value='${ref}' />">						
				        	</form>

			        	</div>

			        	<div style="display: none;" id="register-end">

			        		<div class="head-main-form">
			        			<h2>BIENVENIDO A LA TINKA</h2>
			        		</div>

			        		<div class="body-result-main-form">
			        			<h2>¡Gracias por registrarte!</h2>
			        			<!--p id="message-detail">Ingresa el código SMS enviado al teléfono registrado para activar la cuenta.</p-->
			        			
			        		</div>
			        		<br>
			        		<br>
			        		<!--div class="row col-sm-6 center-auto" >
			        			<input type="number" class="form-control" id="sms-code-register"  autocomplete="off" required="required" placeholder="Código SMS">
			        		</div>

			        		<div class="footer-main-form row">
			        			<div class="action-main-form col-sm-6">
			        				<button id="btnActiveAccount" type="button" class="button button-orange-light">ACTIVAR</button>
			        			</div>
			        			<div class="action-main-form col-sm-6">
			        				<button id="btnResendSmsRegister" type="button" class="button button-orange-light">REENVIAR</button>
				        	  	</div>
			        		</div-->
			        		
			        		<br>
			        		
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
	</div>
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.validator.js"></script>
	<script type="text/javascript" src="layer-view-script/client/signUp.js"></script>
	<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
	<%@ include file="../include/footer.jspf"%>
    <%@ include file="../include/message.jspf"%>
	<script type="text/javascript">

		$(document).ready(function() {

			
			
			$( "html" ).keydown(function(e) {
				var key = e.key;
				var $xcountry = $('#x-country');
				var $xregion = $('#x-region');
				var $combo = '';
				var height = 35;
				var scrolltop = 0;
				if ($xcountry.hasClass('open')) {
					$combo = $xcountry;
				}
				if ($xregion.hasClass('open')) {
					$combo = $xregion;
				}
				if ($combo != '') {
				  	var list = $combo.find('li');
				  	for (var i = 0; i < list.length; i++) {
				  		if (($(list[i]).text().substring(0,1).indexOf(key) == 0) || ($(list[i]).text().substring(0,1).indexOf(key.toUpperCase()) == 0)) {
				  			$combo.animate({scrollTop: i * height});
				  			break;
				  		}
				  	}
			  	}
			});
			
			
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

		});

	</script>


    
    	
    
    
    
</body>
</html>