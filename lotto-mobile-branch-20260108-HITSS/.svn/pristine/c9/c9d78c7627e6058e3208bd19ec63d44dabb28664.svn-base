<%--
<p> NAME:    form.jsp
</p>
<p> VERSION LOG
<pre>
VER   BY				DATE        COMMENT
001   angel.chata	18/04/2010  First comment
</pre>
</p>
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Language" content="es-PE">
<meta http-equiv="PRAGMA" content="NO-CACHE">
<meta http-equiv="CACHE-CONTROL" content="NO-CACHE">
<meta http-equiv="Expires" content="-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<meta name="description" content="Haga su queja o reclamo en el Libro de Reclamaciones de La Tinka " />
<meta name="keywords" content="libro, reclamaciones, intralot">
<meta name="author" content="La Tinka  S.A.">
<meta name="distribution" content="Global"> 
<meta name="copyright" content="(c) La Tinka  S.A.">
<meta name="robots" content="FOLLOW,INDEX">
<title>La Tinka | Libro de Reclamaciones La Tinka</title>

<link rel="stylesheet" type="text/css" href="layer-view-style/client/book/body.css?v=4">
<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>

<script type="text/javascript">
<!--
	function send() {
		var form = document.forms[0];
		var email   = form.email.value;
		var dni     = form.dni.value;
		var nombre  = form.nombre.value;
		var direccion = form.direccion.value;
		var telefono  = form.telefono.value;
		var tipobien  = form.tipobien.value;
		var bien      = form.bien.value;
		var tiporeclamo = form.tiporeclamo.value;
		var reclamo     = form.reclamo.value;
		
		if (validEmail(email) == false)        alert("Debe ingresar un correo de la forma: nombre@servidor.dominio -"+email,null);
		else if (dni==null || dni=="" )          alert("Debe ingresar su DNI/CE -"+dni,null);
		else if (nombre==null  || nombre=="")       alert("Debe ingresar su nombre -"+nombre,null);
		else if (direccion==null  || direccion=="")    alert("Debe ingresar su domicilio -"+direccion,null);
		else if (telefono==null  || telefono=="")     alert("Debe ingresar su telefono -"+telefono,null);
		else if (form.tipobien[0].checked == false && form.tipobien[1].checked == false )        alert("Debe ingresar tipo de bien contratado: Producto o Servicio",null);
		else if (bien==null  || bien=="")         alert("Debe ingresar descripcion del bien -"+bien,null);
		else if (form.tiporeclamo[0].checked == false && form.tiporeclamo[1].checked == false )  alert("Debe ingresar tipo de reclamo realizada: Reclamo o Queja",null);
		else if (reclamo==null  || reclamo=="")      alert("Debe ingresar el reclamo -"+reclamo,null);
		else form.submit();      
	}
//-->
</script>
</head>
<%
   java.util.Calendar now = new java.util.GregorianCalendar();
   java.text.SimpleDateFormat standar = new java.text.SimpleDateFormat("dd/MM/yyyy");
   String todayStandarFormat = standar.format( now.getTime() );
%>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


	<%@ include file="../include/header.jsp" %>

	<div id="form-book" class="container-fluid">
		<div class="content row content-wrap">
			<div class="col-md-5 p-4 p-md-5 left">
				<div class="block">
					<h1 style="font-family: -apple-system,BlinkMacSystemFont,'Segoe UI',Roboto,'Helvetica Neue',Arial ;">Hoja de Reclamación 109951</h1> 					
					<p>Fecha: <%=todayStandarFormat%></p>
					<p>LA TINKA S.A. R.U.C. 20506035121.</br>Av. José Pardo Nº 434, Piso 11, Miraflores - Lima</p>
				</div>
			</div>
			<div class="col-md-7 p-4 p-md-5 right" style="background-color: white;">
				<form name="form" id="formBook" action="libro-reclamaciones-respuesta.html" method="post" class="row">
					<input type="hidden" name='secuencia' value='' id="secuencia"/>
					<input type="hidden" name='fecha' value='' id="fecha"/>
					<div class="title-form">
						<i>1.</i> Identificaci&oacute;n del consumidor reclamante
					</div>
					<div class="form-group col-12">
						<input type='text' class="form-control onlyletters" name='nombre' value='' id="full_name" size='100' maxlength="200" autocomplete="off" data-validation="required" data-validation-error-msg="Debes ingresar tus nombres y apellidos"/>
						<label for="full_name">Nombres y Apellidos</label>
					</div>
					<div class="form-group col-12">
						<input type='text' class="form-control" name='direccion' value='' size='100' id="address" maxlength="200" autocomplete="off" data-validation="required" data-validation-error-msg="Debes ingresar tu dirección"/>
						<label for="address">Domicilio</label>
					</div>
					<div class="form-group col-12 col-md-6">
						<input type='text' class="form-control" name="document-number" value='' id="document-number"  maxlength="12" data-validation="length number" data-validation-length="min8max12" data-validation-error-msg="Ingresa un DNI/C.E válido">
						<label for="document">DNI/C.E:</label>
					</div>
					<div class="form-group col-12 col-md-6">
						<input type='tel' class="form-control onlynumbers" name='telefono' value='' size='20' id="phone" maxlength="20" autocomplete="off" data-validation="required" data-validation-error-msg="tu teléfono fijo o celular es requerido"/>
						<label for="phone">Tel&eacute;fono</label>
					</div>
					<div class="form-group col-12 col-md-6">
						<input type='text' class="form-control" name='email'  id="email" size='100' maxlength="200" autocomplete="off" data-validation="email" data-validation-error-msg="debes ingresar un correo válido"/>
						<label for="email">E-mail</label>
					</div>
					<div class="form-group col-12 col-md-6"></div>
					<div class="title-form">
						<i>2.</i> Identificaci&oacute;n del bien contratado
					</div>
					<div class="form-group col-12 col-md-12">
						<p class="radio-button">
							<input type="radio" name='tipobien' value='Producto' id="produc_check" checked/> 
							<label for="produc_check">Producto</label>
						</p>
						<p class="radio-button">
							<input type="radio" name='tipobien' value='Servicio' id="service_check"/> 
							<label for="service_check">Servicio</label>
						</p>
					</div>
					<div class="form-group col-12 col-md-6">
						<input name="monto" class="form-control onlynumbers" size="100" type="tel" id="amount" maxlength="100" autocomplete="off" data-validation="required" data-validation-error-msg="debes ingresar el monto">
						<label for="amount">Monto reclamado</label>
					</div>
					<div class="form-group col-12 col-md-6">
						<input type='text' class="form-control" name='bien' value='' size='100' id="description" maxlength="100" autocomplete="off" data-validation="required" data-validation-error-msg="debes ingresar una descripción"/>
						<label for="description">Descripci&oacute;n</label>
					</div>
					<div class="title-form">
						<i>3.</i> Detalle de la reclamaci&oacute;n
					</div>
					<div class="form-group col-12 col-md-12">
						<p class="radio-button">
							<input type="radio" name='tiporeclamo' value='Reclamo' id="reclamo_check" checked/> 
							<label for="reclamo_check">Reclamo</label>
						</p>
						<p class="radio-button">
							<input type="radio" name='tiporeclamo' value='Queja' id="queja_check" /> 
							<label for="queja_check">Queja</label>
						</p>
					</div>
					<div class="form-group col-12">
						<textarea name="reclamo" cols="100" rows="3" class="form-control" id="detail" name="detail" maxlength="1000" data-validation="required" data-validation-error-msg="debes ingresar tu reclamo"></textarea>
						<label for="detail">Detalle</label>
					</div>
					<div class="form-group col-12">
						<textarea cols="100" rows="3" class="form-control" id="request" name="pedido" maxlength="1000" data-validation="required" data-validation-error-msg="debes ingresar el pedido"></textarea>
						<label for="request">Pedido</label>
					</div>
					<!-- SUBIENDO IMAGEN -->
					<div id="divStepDNI" class="step">
                     <div class="fileup-image" id="divImgDni">
                       <span id="stateDniPEN" style="display: flex;">Si tienes alguna evidencia sobre tu reclamo o queja, sube hasta un máximo de 3 imágenes en formato jpeg o png.(max. 10mb)</span>
                       <label id="stateDniPENLabel" class="btn is-secondary img-simple" style="margin-top: 16px; display: flex;"><span class="text">Subir imágenes</span>
                         <input class="upimage " type="file" name="iimage_1" id="imgEvi" accept="image/jpeg, image/png" data-valid="required" multiple>
                         <canvas id="canvasDNI" style="display: none;" ></canvas>
                       </label>     
                       <div class="filenames empty" id="filenamesDniVisa"><span class="filename-empty">No se adjuntó ninguna imagen</span>
                         <div class="filename-multiple"></div>
                       </div>
                     </div>
                   </div>
						
					<div class="text-ident">
						<p>RECLAMO: Disconformidad relacionada a los productos o servicios.</p>
						<p>QUEJA: Disconformidad no relacionada a los productos o servicios; o, malestar o descontento respecto a la atención del público. </p>
						</br>
						<ul style="text-align: justify;">
						<li>La formulación del reclamo no impide acudir a otras vías de solución de controversias ni es requisito previo para interponer una denuncia ante INDECOPI.</li>
						<li>El proveedor deberá dar respuesta al reclamo en un plazo máximo de quince (15) días hábiles.</li>
						</ul>
					</div>				    			
				<div class="form__check" style="padding-left:15px;padding-right:15px;font-size: 11px;color: #636363;margin-bottom: 40px;">
                  <input type="checkbox" name="terms" id="terms" value="1" data-validation="required" data-validation-error-msg="debes aceptar la política de datos personales">            
                  <label for="terms" style="margin-bottom: 0px;">He leído y acepto la <a href="<%= Constantes.URL_QW%>/politica-de-datos-personales/" target="_blank" class='link link__base'>Política de Datos Personales </a>de LA TINKA.</label>
                  </div>
					<div class="align-g-recaptcha">
				  <div class="g-recaptcha" data-sitekey="6LelcgkcAAAAAOZT1dJlIKBBP0Rgnjvbs5_t0MkY" style="padding: 0px 15px;"></div>	
				</div>	
					<div class="form-group col-12">
						<button class="btn-submit button button__base color_green" id="enviar">Enviar</button>
					</div>			   
				</form>
			</div>
		</div>
	</div>
	<%@ include file="../include/footer.jsp" %>	
		
	<div id="alert_content" style="display:none">
		<div id="alertModal_content_id" class="confirmModal_content" style="text-align: center;padding-bottom: 5px;"></div>
		<div class="confirmModal_footer_alert">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">Cerrar</button>
		</div>
	</div>
	      
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>	
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/client/book/formBook.js?v=4"></script>
	<script type="text/javascript">
	
// 	var _gaq = _gaq || [];
// 	_gaq.push(['_setAccount', 'UA-16525433-4']);
// 	_gaq.push(['_setDomainName', 'intralot.com.pe']);
// 	_gaq.push(['_trackPageview']);
	
// 	(function() {
// 	var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
// 	//ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
// 	ga.src = ('https:' == document.location.protocol ? 'https://' : 'http://') + 'stats.g.doubleclick.net/dc.js';
// 	var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
// 	})();
		
	</script>


    <script>
    
    
</script>
</body>

</html>