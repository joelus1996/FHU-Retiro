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
	<title>La Tinka : Bienvenido</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
	
	
</head>
<body class="body-perfil">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<div class="container">

    <jsp:include page="../include/header.jsp" />

    <div class="content-wrap">
        <div class="content">
            <section class="main-section">
                <div class="main-wallet-account">
                    <div class="col-12 col-md-12">
                        <div id="account-wrapper" class="account-wrapper">
                            <%@ include file="../include/banner.jsp"%>

                            <div class="box-content-message">
                                <h3 class="activate__title d-block center c_green">
						            ¡Felicitaciones<br />
						            <c:if test="${!empty clientId && agreement != ''}">
						                <c:set var="nombres" value="${fn:trim(name)}" />
						                <c:set var="aNombres" value="${fn:split(nombres, ' ')}" />
						                
						                <c:if test="${not empty aNombres}">
						                    <c:set var="formattedName" value="${fn:toUpperCase(fn:substring(aNombres[0], 0, 1))}${fn:toLowerCase(fn:substring(aNombres[0], 1, fn:length(aNombres[0])))}!" />
						                    ${formattedName}
						                </c:if>
						            </c:if>
						        </h3>
                                <div class="box_message">
                                    <h4>Bienvenido a la Tinka</h4>
                                	<p class="activate__text">Estás a un clic de ser millonario.<br>Realiza tu primera recarga.</p>

                                    <div class="form"> 
					                 <div class="form__button">
										<c:if test="${OperatorId ne 5588}">
					                 		<a class="button button__outline button_red" href="javascript:void(0)" id="addSaldoW"  data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - cargar saldo">Cargar saldo</a><br><br>
											<a class="link_green" href="home.html" data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - ir a mi cuenta">Continuar</a>
										</c:if>
										<c:if test="${OperatorId eq 5588}">
					                 		<a class="button button__outline button_red" href="javascript:void(0)" id="addSaldoW"  data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - cargar saldo">Cargar saldo</a><br><br>
											<a class="link_green" href="home.html" data-name="Evaluate - Activa cuenta" data-category="Activacion-Evaluate" data-action="click" data-label="Activa cuenta - ir a mi cuenta">Continuar</a>
										</c:if>
					                 </div>
					               </div>
                                </div>
                                <p>&nbsp;</p>
                            </div>

                        </div>
                    </div>

                </div>
            </section>
        </div>
    </div>
</div>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>