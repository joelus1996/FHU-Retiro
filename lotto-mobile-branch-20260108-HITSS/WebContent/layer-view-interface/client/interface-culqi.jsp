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
	<title>La Tinka : Datos Tarjetahabiente</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
</head>
<body>

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<div>
		<div class="wrap-modal">
			<div class="content">
				<section class="main-section">
					<div class="main-page">
					<form class="form-register" action="save-card.html" method="post" id="culqi_register_form" data-response-type="json">
					<h1>DATOS DEL TARJETAHABIENTE</h1>
					<p>Completa todos los campos:</p>
					
						<div class="control-form">
							<input class="control-custom" type="text" value="${clientData.name}" id="name" name="name" placeholder="Nombre" required />
						</div>
						<div class="control-form">
							<input class="control-custom" type="text" value="${clientData.lastname}" id="ap-paterno" name="ap-paterno" placeholder="Apellido Paterno" required />
						</div>
						<div class="control-form">
							<input class="control-custom" type="text" value="${clientData.maidenname}" id="ap-materno" name="ap-materno" placeholder="Apellido Materno" required />
						</div>
						<div class="control-form">
							<input class="control-custom" type="email" value="${clientData.mail}" id="email" name="email" placeholder="Correo" required />
						</div>
						<div class="control-form">
							<input class="control-custom" type="text" value="${clientData.mobilePhone}" id="phone" name="phone" placeholder="Teléfono Celular" required />
						</div>
						<div class="control-form">
							<div class="select-custom">
								<div class="selectdiv">
									<select name="country" class="control-custom" id="country" required>
										<option value="">País</option>
										<c:forEach var="country" items="${countries}">
	                                        <option value="${country.countryId}">
                                         	${country.countryName}
                                         	</option>
	                                    </c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="control-form">
							<div class="select-custom">
								<div class="selectdiv">
									<select name="region" class="control-custom" id="region" required>
										<option value="">Ciudad</option>
										<c:forEach var="region" items="${regions}">
	                                        <option value="${region.regionId}">
                                            ${region.regionName}
                                         	</option>
	                                    </c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="control-form">
							<input class="control-custom" type="text" value="${clientData.address}" id="address" name="address" placeholder="Dirección" required>
						</div>
						<p>Para tu seguridad las recargas de saldo por tarjeta de crédito deben contar con el control Verified By Visa. Si tu tarjeta no está activada ponte en contacto con tu banco.</p>
				   	 	<div class="error" id="alert">${alertCulqi}</div>
						<div class="control-form">
							<button id="resgisterCulqi" class="js-close-modal btn btn-orange white" type="button">GUARDAR</button>
						</div>
						<!-- div class="control-form">
							<div class="box-checkbox checkbox-white checkbox-left">
								<input type="checkbox" name="agree" value="true" id="agree" />
								<label for="agree">ACEPTO LOS TÉRMINOS Y CONDICIONES</label>
							</div>
						</div -->
					</form>
					</div>
				</section>
			</div>
		</div>
	</div>
</body>
</html>