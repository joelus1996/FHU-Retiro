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
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>La Tinka : Registro de nuevo cliente</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	<meta name='description' content="La Tinka móvil, registra un nuevo cliente" />
	
</head>

<body class="orange">

 
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<div class="container">
		
		<jsp:include page="../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-page">
						<form class="form-register" action="client_lotocard_register_form.html" method="post" id="client_lotocard_register_form" data-response-type="json">
							<div class="control-form">
								<input class="control-custom" id="name" type="text" name="name" placeholder="Nombre">
							</div>
							<div class="control-form">
								<input class="control-custom" type="text" id="lastname" name="lastname" placeholder="Apellido Paterno">
							</div>
							<div class="control-form">
								<input class="control-custom" type="text" id="maidenname" name="maidenname" placeholder="Apellido Materno">
							</div>
							<div class="control-form">
								<input class="control-custom" type="email" id="email" name="email" placeholder="nombre@correo.com.pe">
							</div>
							<div class="control-form">
								<label>Fecha de Nacimiento</label>
								<div class="select-custom">
									<div class="selectdiv">
										<input style="width: 120%; padding: 0.8em 2em; line-height: 1.3em;" class="control-custom" type="date" id="dateBirth" name="dateBirth" placeholder="mm/dd/yyyy">
									</div>
								</div>
							</div>
							<div class="control-form">
								<input class="control-custom" type="text" id="user" name="user" placeholder="Usuario">
							</div>
							<div class="control-form">
								<input class="control-custom" type="password" id="password01" name="password" placeholder="Contraseña">
							</div>
							<div class="control-form">
								<input class="control-custom" type="password" id="password02" name="password02" placeholder="Confirmar Contraseña">
							</div>
							<div class="select-custom">
								<div class="selectdiv">
									<select name="typeDoc" class="control-custom" id="typeDoc" required>
										<option value="DNI">DNI</option>
										<option value="CAREX">Pasaporte</option>
										<option value="PASAP">Carnet de Extranjería</option>
									</select>
								</div>
							</div>
							<div class="control-form">
								<input class="control-custom" type="number" id="numberDoc" name="numberDoc" placeholder="Número de Documento">
							</div>
							<div class="control-form">
								<input class="control-custom" type="text" id="mobilePhone" name="mobilePhone" placeholder="Número de Celular">
							</div>
					   	 	<div class="error" id="alert">${alert}</div>
							<div class="control-form">
								<i></i>
								<button id="resgisterUser" class="btn btn-white" type="button">REGISTRAR</button>
							</div>
							<br/>
							<c:if test="${OperatorId eq 5587}">
							<div class="wrap-card">
				    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
				    		</div>
				    		</c:if>
				    		<c:if test="${OperatorId eq 5588}">
								<c:if test="${redirectGame eq 'TA'}">
								<div class="wrap-card">
					    			<button type="button" class="a_tav2 btn btn-sm btn-black">IR A TE APUESTO</button>
					    		</div>
					    		</c:if>
					    		<c:if test="${redirectGame eq 'DV'}">
								<div class="wrap-card">
					    			<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">IR A DEPORTES VIRTUALES</button>
					    		</div>
					    		</c:if>
				    		</c:if>
							<div class="control-form">
								<div class="box-checkbox checkbox-white checkbox-left">
									<input type="checkbox" name="agree" value="true" id="agree" checked />
									<label for="agree"><a href="#" id="agree_tyc">ACEPTO LOS TÉRMINOS Y CONDICIONES</a></label>
								</div>
							</div>
							<input type="hidden" name="urlRedirect5588" id="urlRedirect5588" value="<c:out value='${urlRedirect5588}' />">		
							<input type="hidden" name="ref" id="ref" value="<c:out value='${ref}' />">											
						</form>
						<div id="popup" class="overlay">
								<div class="popup popup-sm">
									<a class="close js-close-modal" href="#">&times;</a>
									<div class="main-modal"></div>
								</div>
						</div>
						<div id="popup-tyc" class="overlay">
							<div class="popup popup-sm">
								<a class="close js-close-modal" href="#">&times;</a>
								<div class="wrap-modal">
									<jsp:include page="../client/interface-term.jsp"/>
								</div>
							</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />

	<script type="text/javascript">
		
		$(document).ready(function(){
			$('#agree_tyc').click(function(){
				$("div#alert").html("");
        		openModal("#popup-tyc","");
			});
		
			$('#agree_terms').click(function(){
				$('#agree').prop('checked', true);
				closeModal();
			});
		})

	</script>

<div id="confirm_content" style="display:none">
		<div id="confirmModal_content_id" class="confirmModal_content">
		</div>
		<div class="confirmModal_footer">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">CERRAR</button>
			<!-- button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">ACEPTAR</button -->
		</div>
</div>

	
	
</body>
</html>