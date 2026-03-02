<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<%@page import="pe.com.intralot.loto.lib.ConnectionFactory"%>
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
	<title>La Tinka : Cargar saldo a la cuenta</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	<meta name='description' content="La Tinka móvil, billetera" />
	
</head>
<body class="orange">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="container">
		<jsp:include page="../include/header.jsp" />
        <input type="hidden" id="chargeData" value="<c:out value='${chargeData}'/>" />
        <input type="hidden" id="bonusChannel" value="<c:out value='${bonusChannel}'/>">
        <input type="hidden" id="bonusPercentage" value="<c:out value='${bonusPercentage}'/>">
        <input type="hidden" id="welcomeBonusPercentaje" value="<c:out value='${welcomeBonusPercentaje}'/>">
        <input type="hidden" id="welcomeBonusStepAmount" value="<c:out value='${welcomeBonusStepAmount}'/>">
        <input type="hidden" id="stepAmount" value="<c:out value='${stepAmount}'/>">
        <c:set var="iflexBonoTyC"><%=Constantes.iflexBonoTyC.toString().trim()%></c:set>
        <c:set var="wbBonoTyC"><%=Constantes.wbBonoTyC.toString().trim()%></c:set>
        
        <div id="cargando"></div>
        
		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-page">

						<div class="main-wallet">
							<div class="top-wallet">
								<div class="title-wallet">
									<h3>CARGAR SALDO</h3>
								</div>
								<h5>Saldo: <span id="mi-saldo">${balanceAmount}</span></h5>
								<h5>Bono Te Apuesto: <span id="mi-saldo-bono">${bonoTeApuesto}</span></h5>
								<h5>Bono Loter&iacute;as: <span id="mi-otro-bono">${bonoOtro}</span></h5>
							</div>

							<c:if test="${indicador==1}">
								<input type="hidden" id="alertPrepaidCard" value="<c:out value='${alertPrepaidCard}'/>">
							</c:if>		
							 
							 <c:if test="${indicador!=1}">
							 	<input type="hidden" id="alertPrepaidCard" value="<c:out value='${alertPrepaidCard}'/>">
							 </c:if>
						</div>
					</div>
					<c:if test="${welcomeBonusMessage != ''}">
						<div class="top-saldo wb-saldo">
							<div class="top-right-saldo">
								<div class="saldo-add">
								<input type="checkbox" name="chkactivatewbbond" value="1" id="chkactivatewbbond" /><h3><label for="chkactivatewbbond">${welcomeBonusMessage}</label></h3>
								<p class="p-white"><b>${welcomeBonusPercentaje}% de Bono + jugadas gratis de loter&iacute;as.</b></p>
								<p class="p-white">Disponible hasta el ${welcomeBonusLastDate}.</p>
								<a id="term_wbbono_id" class="js-modal" href="#" data-modal="#popup_terms_wbbono">Al activar el bono aceptas los t&eacute;rminos y condiciones.</a>
								</div>
							</div>
						</div>	
					</c:if>
					<c:choose>
					<c:when test="${bonoStatus == 'Activo'}">
						<div class="top-saldo">
							<div class="top-right-saldo">
								<div class="saldo-add">
								<input type="checkbox" name="chkactivatebond" value="1" id="chkactivatebond" /><h3><label for="chkactivatebond">${bonoMensaje}</label></h3>
								<a id="term_bono_id" class="js-modal" href="#" data-modal="#popup_terms_bono">Al activar el bono aceptas los t&eacute;rminos y condiciones.</a>
<%-- 								<c:if test="${bonoMensajePor != ''}"><p class="p-white"><c:out value="${bonoMensajePor}"></c:out> para jugar Te Apuesto.</p></c:if> --%>
<%-- 								<p class="p-white">Disponible solo por hoy ${bonoDate} hasta agotar stock.</p> --%>
								<p class="p-white">Disponible solo por hoy ${bonoDate} o hasta agotar stock, para jugar exclusivamente en TeApuesto.pe</p>
								</div>
							</div>
						</div>
					</c:when>
					<c:when test="${bonoStatus == 'Cerrado'}">
						<div class="top-saldo">
							<div class="top-right-saldo">
								<div class="saldo-add">
									<h3><label>${bonoMensaje} </label></h3>
									<p class="p-white">Tu recarga a partir de este momento no aplica al bono.</p> 
									<a id="term_bono_id" class="js-modal" href="#" data-modal="#popup_terms_bono">Ver t&eacute;rminos y condiciones.</a>
								</div>
							</div>
						</div>
					</c:when>
					<c:when test="${bonoStatus == 'Obtenido'}">
						<div class="top-saldo">
							<div class="top-right-saldo">
								<div class="saldo-add">
									<h3><label>${bonoMensaje} </label></h3>
									<p class="p-white">Tu recarga a partir de este momento no aplica al bono.</p> 
									<a id="term_bono_id" class="js-modal" href="#" data-modal="#popup_terms_bono">Ver t&eacute;rminos y condiciones.</a>
								</div>
							</div>
						</div>
					</c:when>
					<c:otherwise></c:otherwise>
					</c:choose>
				</section>

				<section class="main-section">
					<div class="main-page">

						<div class="main-wallet">
							
							<div class="charge-options">
								<div class="custom-accordion">
								<p><b>&iexcl;Recarga saldo a tu cuenta en 3 pasos, es sencillo y r&aacute;pido!</b><br/>Elige c&oacute;mo quieres recargar tu cuenta:
								</p>
									<ul>
									  <c:if test="${ibnkflag}">
									  <li>
									    <input id="interbankEnLinea" type="radio" name="accordion"  />
									    <i></i>
									    <h2 class="btn btn-pm btn-white">INTERBANK<br/>EN L&Iacute;NEA<span>NUEVO</span> <img src="layer-view-image/common/icons-interbank.png" /></h2>
									    <div class="body-accordion">
									    	<div class="wrap-card">
									    	<p>Se permite cargas a partir de S/ 10 hasta S/ 5,000</p>
										    <div class="sub-accordion">
										    <ul>
										    <li>1. Ingresa a tu Interbank App o tu <a href="https://interbank.pe/" target="_blank">Banca por Internet</a></li>
										    <li>2. Operaciones</li>
										    <li>3. Pagos y Recargas</li>
										    <li>4. Pago a Institución o Empresas</li>
										    <li>5. Intralot</li>
										    <li>6. Recarga Web</li>
										    <li>7. Ingresa tu DNI y el monto a recargar</li>
										    <li>8. Paga y listo</li>
										    </ul>
										    </div>
								    		</div>
								    		<c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  </c:if>
									  <li>
									    <input id="bcp" type="radio" name="accordion"  />
									    <i></i>
										<h2 class="btn btn-pm btn-white">DESDE TU<br/>CUENTA BCP <img src="layer-view-image/common/icons-bcp.png" /></h2>
									    <div class="body-accordion">
									    	<form>
									    		<div class="wrap-card">
									    			<p><b>&iexcl;Recarga saldo de manera r&aacute;pida y sencilla!</b></p>
									    			<p>1. Digita el monto que deseas cargar:</p>
										    		<div class="control-form">
										    			<input class="control-custom" type="text" name="bcpAmount" id="bcpAmount" value="S/ 10" maxlength="12" placeholder="Monto de Carga S/">
										    		</div>
										    		<p>2. Presiona el bot&oacute;n para generar tu c&oacute;digo de recarga:</p>
										    		<div class="control-form">
<!-- 										    			<i class="hide"></i> -->
														<button type="button" id="bcpcharge" class="btn btn-red" data-type="BCP">GENERAR C&Oacute;DIGO</button>
													</div>
												</div>
													<div id="grilla_bcp"></div>
												<div class="wrap-card">
													<p>3. Ingresa a tu cuenta en el <a href="https://www.viabcp.com/" title="Banco de Crédito>>BCP>>" target="_blank">BCP</a> para completar la recarga:</pi>
														<ul>
														<li>a. Ingresa a Pago de Servicios</li>
														<li>b. Busca Intralot / Recarga Lotocard</li>
														<li>c. Digita tu C&oacute;digo de Recarga</li>
														<li>d. Paga y Listo!</li>
														</ul>
													<p>Espera pacientemente. En 10 minutos tu recarga aparecerá en tu cuenta.</p>
											    </div>
											</form>
											<c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  <c:if test="${pefeFlag}">
									  <li>
									    <input id="pagoEfectivoEnLinea" type="radio" name="accordion" />
									    <i></i>
										<h2 class="btn btn-pm btn-white">CON PAGOEFECTIVO<br/>EN LINEA <img src="layer-view-image/common/icons-pagoefectivo.png" /></h2>
									    <div class="body-accordion">
									    	<form>
									    		<div class="charge-methods"></div>
									    		<div class="wrap-card">
									    			<p><b>&iexcl;Recarga saldo de manera r&aacute;pida y sencilla!</b></p>
									    			<p>1. Digita el monto que deseas cargar:</p>
										    		<div class="control-form">
										    			<input class="control-custom" type="text" name="peflAmount" id="peflAmount" value="S/ 40" placeholder="Monto de Carga S/">
										    		</div>
										    		<p>2. Presiona el bot&oacute;n para generar tu c&oacute;digo de recarga (aparecer&aacute; en 10 segundos):</p>
										    		<div class="control-form">
										    			<i class="hide"></i>
														<button type="button" id="peflcharge" class="btn btn-red" data-type="PEFE">GENERAR C&Oacute;DIGO</button>
													</div>
												</div>
													<header id="frame_pefl" class="hide">
												    <div class="embwrap">
												    <div class="embcell">
												    <div class="ifrwrap">
												    <iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe></div>
													</div>
													</div>
													</header>
													<button type="button" id="close_pefl" class="btn btn-sm btn-black hide">CERRAR</button>
												<div class="wrap-card">
													<p>3. Ingresa a tu cuenta en el BCP/Interbank/BBVA o Scotiabank para completar la recarga.</p>
														<ul>
														<li>a. Ingresa a Pago de Instituci&oacute;n o Servicios</li>
														<li>b. Busca PagoEfectivo</li>
														<li>c. Digita tu c&oacute;digo de recarga de PagoEfectivo</li>
														<li>d. Paga y Listo!</li>
														</ul>							
													<p>Espera pacientemente. En 10 minutos tu recarga aparecer&aacute; en tu cuenta.</p>
											    </div>
											</form>
											<c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  </c:if>
									  <c:if test="${sfpyFlag}">
									  <li>
									    <input id="safetypayEnLinea" type="radio" name="accordion" />
									    <i></i>
									    <h2 class="btn btn-pm btn-white">SAFETYPAY<br/>EN LINEA <img src="layer-view-image/common/icons-safetypay.png" /></h2>
									    <div class="body-accordion">
									    	<form>
									    		<div class="charge-methods">
									    		</div>
									    		<div class="wrap-card">
									    			<p><b>&iexcl;Recarga saldo de manera r&aacute;pida y sencilla!</b></p>
									    			<p>1. Digita el monto que deseas cargar:</p>
										    		<div class="control-form">
										    			<input class="control-custom" type="text" name="sfplAmount" id="sfplAmount" value="S/ 40" placeholder="Monto de Carga S/">
										    		</div>
										    		<p>2. Presiona el bot&oacute;n para generar tu c&oacute;digo de recarga (aparecer&aacute; en 10 segundos):</p>
										    		<div class="control-form">
										    			<i class="hide"></i>
														<button type="button" id="sfplcharge" class="btn btn-red" data-type="SPAY">GENERAR C&Oacute;DIGO</button>
													</div>
												</div>
													<header id="frame_sfpl" class="hide">
												    <div class="embwrap">
												    <div class="embcell">
												    <div class="ifrwrap">
												    <iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe></div>
													</div>
													</div>
													</header>
													<button type="button" id="close_sfpl" class="btn btn-sm btn-black hide">CERRAR</button>
												<div class="wrap-card">
													 <p>3. Ingresa a tu cuenta en el BCP/Interbank/BBVA o Scotiabank para completar la recarga.</p>
														<ul>
														<li>a. Ingresa a Pago de Instituci&oacute;n o Servicios</li>
														<li>b. Busca SafetyPay</li>
														<li>c. Digita tu c&oacute;digo de recarga de SafetyPay</li>
														<li>d. Paga y Listo!</li>
														</ul>							
													<p>Espera pacientemente. En 10 minutos tu recarga aparecer&aacute; en tu cuenta.</p>
											    </div>
											</form>
											<c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  </c:if>
									  <c:if test="${ibnkflag}">
									  <li>
									    <input id="interbankAgentes" type="radio" name="accordion"  />
									    <i></i>
									    <h2 class="btn btn-pm btn-white">INTERBANK<br/>AGENTES<span>NUEVO</span> <img src="layer-view-image/common/icons-interbank.png" /></h2>
									    <div class="body-accordion">
									    	<div class="wrap-card">
										    	<p>Se permite cargas a partir de S/ 10 hasta S/ 5,000</p>
										    	<div class="sub-accordion">
											    <ul>
											    <li>1. Solicita tu recarga Intralot indicando tu DNI y el monto a recargar</li>
											    <li>2. Paga y listo</li>
											    </ul>
											    </div>
											    <p>Encuentra aquí tu Punto donde pagar</p>
											    <div class="sub-button">
									    			<button type="button" id="idBtnIbk" class="btn btn-sm btn-black">PUNTOS DE PAGO</button>
									    		</div>
								    		</div>
								    		<c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  </c:if>
									  <li>
									    <input id="lotocard" type="radio" name="accordion" />
									    <i></i>
									    <h2 class="btn btn-lf btn-white">LOTOCARD <img src="layer-view-image/common/logo-lotocard.png" /></h2>
									    <div class="body-accordion">
									    	<form action="client_lotocard_load_balance.html" method="post" id="client_lotocard_load_balance">
									    		<div class="wrap-card">
									    			<p><b>&iexcl;Recarga saldo de manera r&aacute;pida y sencilla!</b></p>
									    			<p>1. Compra tus tarjetas LOTOCARD en nuestros puntos de venta.</p>
									    			<p>2. Raspa la zona posterior y digita los 14 d&iacute;gitos:</p>
										    		<div class="control-form">
										    			<input class="control-custom" type="text" name="numberCard" id="numberCard" placeholder="Digita tu código">
										    		</div>
										    		<p>3. Presiona el bot&oacute;n para cargar tu Lotocard:</p>
										    		<div class="control-form">
														<button type="button" id="lottocard" class="btn btn-red" data-type="LOTOCARD">CARGAR LOTOCARD</button>
													</div>
													<div class="sub-accordion">
											    		<p>Encuentra aqu&iacute; tu Punto de Venta m&aacute;s cercano</p>
											    		<div class="sub-button">
											    			<button type="button" id="idMenuPoint2" class="btn btn-sm btn-black">PUNTOS DE VENTA</button>
											    		</div>
											    	</div>
											    </div>
										    </form>
									    </div>
									  </li>
									  <c:if test="${pefeFlag}">
									  <li>
									    <input id="pagoEfectivoEnEfectivo" type="radio" name="accordion" />
									    <i></i>
										<h2 class="btn btn-pm btn-white">CON PAGOEFECTIVO<br/>EN EFECTIVO <img src="layer-view-image/common/icons-pagoefectivo.png" /></h2>
									    <div class="body-accordion">
									    	<form>
									    		<div class="charge-methods"></div>
									    		<div class="wrap-card">
									    			<p><b>&iexcl;Recarga saldo de manera r&aacute;pida y sencilla!</b></p>
									    			<p>1. Digita el monto que deseas cargar:</p>
										    		<div class="control-form">
										    			<input class="control-custom" type="text" name="pefeAmount" id="pefeAmount" value="S/ 40" placeholder="Monto de Carga S/">
										    		</div>
										    		<p>2. Presiona el bot&oacute;n para generar tu c&oacute;digo de recarga (aparecerá en 10 segundos):</p>
										    		<div class="control-form">
										    			<i class="hide"></i>
														<button type="button" id="pefecharge" class="btn btn-red" data-type="PEFE">GENERAR C&Oacute;DIGO</button>
													</div>
												</div>
													<header id="frame_pefe" class="hide">
												    <div class="embwrap">
												    <div class="embcell">
												    <div class="ifrwrap">
												    <iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe></div>
													</div>
													</div>
													</header>
													<button type="button" id="close_pefe" class="btn btn-sm btn-black hide">CERRAR</button>
												<div class="wrap-card">
													<p>3. Con tu c&oacute;digo ac&eacute;rcate al BCP/Interbank/BBVA o Scotiabank para depositar la recarga.</p>
													<p>4. Paga y Listo!</p>																									
													<p>Espera pacientemente. En 10 minutos tu recarga aparecer&aacute; en tu cuenta.</p>
											    </div>
											</form>
											<c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  </c:if>
									  <c:if test="${sfpyFlag}">
									  <li>
									    <input id="safetypayEnEfectivo" type="radio" name="accordion" />
									    <i></i>
									    <h2 class="btn btn-pm btn-white">SAFETYPAY<br/>EN EFECTIVO <img src="layer-view-image/common/icons-safetypay.png" /></h2>
									    <div class="body-accordion">
									    	<form>
									    		<div class="charge-methods"></div>
									    		<div class="wrap-card">
									    			<p><b>&iexcl;Recarga saldo de manera r&aacute;pida y sencilla!</b></p>
									    			<p>1. Digita el monto que deseas cargar:</p>
										    		<div class="control-form">
										    			<input class="control-custom" type="text" name="sfpeAmount" id="sfpeAmount" value="S/ 40" placeholder="Monto de Carga S/">
										    		</div>
										    		<p>2. Presiona el bot&oacute;n para generar tu c&oacute;digo de recarga (aparecer&aacute; en 10 segundos):</p>
										    		<div class="control-form">
										    			<i class="hide"></i>
														<button type="button" id="sfpecharge" class="btn btn-red" data-type="SPAY">GENERAR C&Oacute;DIGO</button>
													</div>
												</div>
													<header id="frame_sfpe" class="hide">
												    <div class="embwrap">
												    <div class="embcell">
												    <div class="ifrwrap">
												    <iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe></div>
													</div>
													</div>
													</header>
													<button type="button" id="close_sfpe" class="btn btn-sm btn-black hide">CERRAR</button>
												<div class="wrap-card">
													<p>3. Con tu c&oacute;digo ac&eacute;rcate al BCP/Interbank/BBVA o Scotiabank para depositar la recarga.</p>
													<p>4. Paga y Listo!</p>		
													<p>Espera pacientemente. En 10 minutos tu recarga aparecer&aacute; en tu cuenta.</p>
											    </div>
											</form>
											<c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  </c:if>
									  <c:if test="${rddgflag}">
									  <li>
									    <input id="redDigital" type="radio" name="accordion" />
									    <i></i>
									    <h2 class="btn btn-lf btn-white">RED DIGITAL <img src="layer-view-image/common/logo-reddigital-2.png" /></h2>
									    <div class="body-accordion">
								    		<div class="wrap-card">
								    			<p>Deposita en efectivo en todos sus agentes autorizados.</p>
										    	<div class="sub-accordion">
										    		<p>Se permite cargas a partir de S/ 10 hasta S/ 150.<br/>Solicita la recarga Te Apuesto o Intralot. Indica tu DNI, n&uacute;mero de celular y el monto a recargar. &iexcl;Listo!</p>
										    	</div>
										    	<p>Encuentra aquí tu Punto de recarga más cercano</p>
									    		<div class="sub-button">
									    			<button type="button" id="idBtnPuntosRedDigital" class="btn btn-sm btn-black">PUNTOS DE RECARGA</button>
									    		</div>
										    </div>
										    <c:if test="${OperatorId eq 5587}">
											<div class="wrap-card">
								    			<button type="button" class="a_lapolla btn btn-sm btn-black">IR A LA POLLA</button>
								    		</div>
								    		</c:if>
								    		<c:if test="${OperatorId eq 5588}">
											<div class="wrap-card">
								    			<c:if test="${redirectGame ne 'DV'}">
													<button type="button" class="a_tav2 btn btn-sm btn-black">VOLVER A TA</button>								    			
												</c:if>
												<c:if test="${redirectGame eq 'DV'}">
													<button type="button" class="a_tav2_ddvv btn btn-sm btn-black">VOLVER A DEPORTES VIRTUALES</button>
												</c:if>
								    		</div>
								    		</c:if>
									    </div>
									  </li>
									  </c:if>
									</ul>
								</div>
							</div>
							<div id="popup_terms_bono" class="overlay">
								<div class="popup popup-sm">
								<a class="js-close-modal close" href="#">&times;</a>
									<div class="wrap-modal">
										<div class="content-modal">
											<c:import url='${iflexBonoTyC}' />
										</div>
									</div>
								</div>
							</div>
							<div id="popup_terms_wbbono" class="overlay">
								<div class="popup popup-sm">
								<a class="js-close-modal close" href="#">&times;</a>
									<div class="wrap-modal">
										<div class="content-modal">
											<c:import url='${wbBonoTyC}' />
										</div>
									</div>
								</div>
							</div>
							<div id="popup" class="overlay">
								<div class="popup popup-sm">
									<a class="close js-close-modal" href="#">&times;</a>
									<div class="main-modal"></div>
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
			bcpCharge("", "", "");
			var state = 0;
			var bonusChannel = $('#bonusChannel').val();
			var bonusPercentage = $('#bonusPercentage').val();
			var welcomeBonusPercentaje = $('#welcomeBonusPercentaje').val();
			var welcomeBonusStepAmount = $('#welcomeBonusStepAmount').val();
			var stepAmount = $('#stepAmount').val();
			var chdata = toJSON($('#chargeData').val());
			$("#bcpAmount").val("S/ "+((chdata.bcpMinAmount!=null && chdata.bcpMinAmount!='' && !isNaN(chdata.bcpMinAmount))?parseFloat(chdata.bcpMinAmount):10));
			$("#sfpeAmount").val("S/ "+((chdata.sfpyMinAmount!=null && chdata.sfpyMinAmount!='' && !isNaN(chdata.sfpyMinAmount))?parseFloat(chdata.sfpyMinAmount):40));
            $("#sfplAmount").val("S/ "+((chdata.sfpyMinAmount!=null && chdata.sfpyMinAmount!='' && !isNaN(chdata.sfpyMinAmount))?parseFloat(chdata.sfpyMinAmount):40));
            $("#pefeAmount").val("S/ "+((chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40));
            $("#peflAmount").val("S/ "+((chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40));
			(function ($,undefined) {
			   var messagePromo = "<c:out value='${messagePromo}' />" 
			   if (messagePromo != undefined && $.trim(messagePromo)!= "") {
			       alertMessage("<div class='info'></div><p>"+messagePromo+"</p>");
			    }
			})(jQuery);
			
// 			$(document).delegate('#lottocard', 'click', function () {
// 		    	var ico = $(this).siblings('i');
// 		    	$(ico).addClass('loading').removeClass('hide');
// 		    	var frm = $("#client_lotocard_load_balance");
// 		    	var actbono = $("#chkactivatebond").is(":checked");
// 		    	var actwbbono = $("#chkactivatewbbond").is(":checked");
// 		    	var argument = "";
// 		    	frm.attr("action", "client_lotocard_load_balance.html?activ-bono="+actbono+"&activ-wbbono="+actwbbono);
// 		        if ($("#numberCard").val() == '') {
// 		            alertMessage("Ingrese el c&oacute;digo de su lottocard");
// 		            return false;
// 		        } else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
// 				        $("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ( $.trim($("#bonusChannel").val()) == "" || ( $.trim($("#bonusChannel").val()) != "" && $.trim($("#bonusChannel").val()).includes($(this).data("type"))))) {
// 		        	argument = "<p>Hoy ofrecemos Bono de "+$("#bonusPercentage").val()+"% para jugar Te Apuesto y estas desaprovech&aacute;ndolo.</p><p>&iquest;Deseas continuar de todos modos con tu recarga?</p>";
// 		        } else {
// 		        	if(actwbbono==true) $('.content-wrap .wb-saldo').text("");
// 					rechargeLotocard(frm);
// 		        }
// 		        if (argument != "") {
// 		        	$("#confirmModal_content_id").html(argument);
// 		        	$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
// 		        		onOkBut: function(event, el) {rechargeLotocard(frm);} , 
// 		        		onCancelBut: function(event, el) {} });			
// 				}
// 		        $(ico).removeClass('loading').addClass('hide');
// 		    });
// 			function rechargeLotocard(e){
// 				var cadena = "";
// 				$.ajax({
//                     type: e.attr('method'),
//                     url: e.attr('action'),
//                     data: e.serialize(),
//                     success: function (data) {
//                     	$("#numberCard").val("");
//                     	if(data.lapolla!=null && $.trim(data.lapolla)!="" && data.indicador == 1) {
//                     		cadena = data.lapolla.split("|");
//                     		window.open($.trim(cadena[0]),"_parent");
//                     	} else if(data.tav2!=null && $.trim(data.tav2)!="" && data.indicador == 1) {
//                         	cadena = data.tav2.split("|");
//                         	window.open($.trim(cadena[0]),"_parent");
//                     	} else {
// 	                    	$("#header .text-money:eq(0) span").text(data.newamount);
// 	                    	$("#header .text-money:eq(1) span").text(data.bonusAmount);
// 	                    	$("#header .text-money:eq(2) span").text(data.bonusOther);
// 			                $("#mi-saldo").text(data.newamount);
// 			                $("#mi-saldo-bono").text(data.bonusAmount);
// 			                $("#mi-otro-bono").text(data.bonusOther);
// 	                        alertMessage(data.alertPrepaidCard);
//                     	}
//                     },
//                     error: function (data) {
//                         console.log('An error occurred.');
//                     },
//                 });
// 			}
			$(document).delegate('#grilla_bcp div .bcpverify', 'click', function(){
				$('button').prop('disabled', true);	
				try {
					var $btnVerificar = $(this);
			        var amount = $("#mi-saldo").text();
			        var trx = $(this).data('pin');
			        $.ajax({
			            type: "GET",
			            url: "verificar.html",
			            dataType: "json",
			            data: {
			            	amount: amount,
			                pin: trx
			            },
			            beforeSend: function () {
			            	$("#cargando").addClass('loading');
			            },
			            error: function () {
			            	$("#cargando").removeClass('loading');
			            	$('button').prop('disabled', false);
			            },
			            success: function (data) {
			            	try {
			            		if (data.state === 'OK') {
				                    $("#header .text-money:eq(0) span").text(data.amount);
			                    	$("#header .text-money:eq(1) span").text(data.bonusAmount);
			                    	$("#header .text-money:eq(2) span").text(data.bonusOther);
				                    $("#mi-saldo").text(data.amount);
				                    $("#mi-saldo-bono").text(data.bonusAmount);
				                    $("#mi-otro-bono").text(data.bonusOther);
				                }
				                alertMessage("<div class='info'></div><p>"+data.message+"</p>");
				                $("#cargando").removeClass('loading');
				            	$('button').prop('disabled', false);
			            	}catch (e) {
					  			console.log(err.message);
					  			$("#cargando").removeClass('loading');
				            	$('button').prop('disabled', false);
					  		}
			            }
			        })
				} catch (e) {
		  			console.log(err.message);
		  			$('button').prop('disabled', false);
		  		}
		    });
			$(document).delegate('#grilla_bcp div .bcpdelete', 'click', function(){
				$('button').prop('disabled', true);	
				try {
			        var $btnAnular = $(this);
			        $.ajax({
			            type: 'post',
			            url: 'anular.html',
			            dataType: 'text',
			            data: {
			                pin: $(this).data('pin')
			            },
			            beforeSend: function () {
			            	$("#cargando").addClass('loading');
			            },
			            error: function () {
			            	$("#cargando").removeClass('loading');
			            	$('button').prop('disabled', false);
			            },
			            success: function (data) {
			            	try {
			                	$btnAnular.parents('#grilla_bcp .wrap-card .row').remove();
			                	
			                	if($(document).find('.bcpdelete').length == 0) {
						            $('#grilla_bcp .wrap-card').html('')
						        }
			                	
			                	$("#cargando").removeClass('loading');
				            	$('button').prop('disabled', false);
			            	} catch (e) {
					  			console.log(err.message);
					  			$("#cargando").removeClass('loading');
				            	$('button').prop('disabled', false);
					  		}
			            }
			        });
				} catch (e) {
		  			console.log(err.message);
		  			$('button').prop('disabled', false);
		  		}
		    });
		    $('#bcpcharge').click(function(event) {
		        event.preventDefault();
		        var minAmount = (chdata.bcpMinAmount!=null && chdata.bcpMinAmount!='' && !isNaN(chdata.bcpMinAmount))?parseFloat(chdata.bcpMinAmount):10;
		        var maxAmount = (chdata.bcpMaxAmount!=null && chdata.bcpMaxAmount!='' && !isNaN(chdata.bcpMaxAmount))?parseFloat(chdata.bcpMaxAmount):10000;
		        var amount = parseInt($("#bcpAmount").val().replace(/[S/ ,]/g,""));
		        var actbono = $("#chkactivatebond").is(":checked");
		        var actwbbono = $("#chkactivatewbbond").is(":checked");
		        var argument = "";
		        if(amount < minAmount || amount == '' || isNaN(amount)) {
		            alertMessage("<div class='info'></div><p>Debes ingresar un monto de carga m&iacute;nima de S/ "+minAmount+".</p>");
	                $("#bcpAmount").val("S/ "+minAmount);
		        } else if(amount > maxAmount) {
		        	alertMessage("<div class='info'></div><p>Debe ingresar un monto de carga no mayor de S/ "+maxAmount+".</p>");
	                $("#bcpAmount").val("S/ "+minAmount);
		        } else {
		        	if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
				        	$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(bonusChannel) == "" || ( $.trim(bonusChannel) != "" && $.trim(bonusChannel).includes($(this).data("type"))))) {
		        		argument = "<p>Hoy ofrecemos Bono de "+bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovech&aacute;ndolo.<br/>&iquest;Deseas continuar de todos modos con tu recarga?</p>";
					} else if($("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(bonusChannel)=="" || ($.trim(bonusChannel)!="" && $.trim(bonusChannel).includes($(this).data("type")))) &&
		        			($.trim(stepAmount)!="" && parseFloat($.trim(stepAmount))>parseFloat(amount))){ 
		        			argument = "<p>Has activado el Bono de "+bonusPercentage+"%, pero con un monto menor a S/ "+stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>";
		        	}else if($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==true && ($.trim(bonusChannel)=="" || ($.trim(bonusChannel)!="" && $.trim(bonusChannel).includes($(this).data("type")))) &&
		        			($.trim(welcomeBonusStepAmount)!="" && parseFloat($.trim(welcomeBonusStepAmount))>parseFloat(amount))){
		        			argument = "<p>Has activado el Bono de "+welcomeBonusPercentaje+"%, pero con un monto menor a S/ "+welcomeBonusStepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>";
		        	}
		        	else {bcpCharge(amount, '', actbono, actwbbono);}

		        	if (argument != "") {
		            	$("#confirmModal_content_id").html(argument);
						$("#confirm_content").confirmModal({top : '30%', type : 'modal', onCancelBut: function(event, el) {} ,  onOkBut: function(event, el) {bcpCharge(amount, '', actbono, actwbbono);} });			
					}
		        	
		        }
		    });

		    $('#sfplcharge, #sfpecharge').click(function(event) {
		    	event.preventDefault();
		    	var minAmount = (chdata.sfpyMinAmount!=null && chdata.sfpyMinAmount!='' && !isNaN(chdata.sfpyMinAmount))?parseFloat(chdata.sfpyMinAmount):40;
		        var maxAmount = (chdata.sfpyMaxAmount!=null && chdata.sfpyMaxAmount!='' && !isNaN(chdata.sfpyMaxAmount))?parseFloat(chdata.sfpyMaxAmount):9999;
		        var amount = ($(this).attr("id")=="sfpecharge")?parseInt($("#sfpeAmount").val().replace(/[S/ ,]/g,"")):parseInt($("#sfplAmount").val().replace(/[S/ ,]/g,""));
		        var argument = "";
		        if (amount < minAmount || amount == '' || isNaN(amount)) {
		        	alertMessage("<div class='info'></div><p>Debes ingresar un monto de carga m&iacute;nima de S/ "+minAmount+".</p>");
		            $("#sfpeAmount").val("S/ "+minAmount);
		            $("#sfplAmount").val("S/ "+minAmount);
		        } else if (amount > maxAmount) {
		        	alertMessage("<div class='info'></div><p>Debe ingresar un monto de carga no mayor de S/. "+maxAmount+".</p>");
		            $("#sfpeAmount").val("S/ "+minAmount);
		            $("#sfplAmount").val("S/ "+minAmount);
		        } else {
		        	var posAmount = ($(this).attr("id")=="sfpecharge")?$("#sfpeAmount").val().replace(/[S/ ,]/g,""):$("#sfplAmount").val().replace(/[S/ ,]/g,"");
		        	var typeToken = ($(this).attr("id")=="sfpecharge")?2:1;
		        	if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
				        	$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(bonusChannel) == "" || ( $.trim(bonusChannel) != "" && $.trim(bonusChannel).includes($(this).data("type"))))) { 
		        		argument = "<p>Hoy ofrecemos Bono de "+bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovech&aacute;ndolo.<br/>&iquest;Deseas continuar de todos modos con tu recarga?</p>";
		        	} else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
				        	$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(bonusChannel)=="" || ($.trim(bonusChannel)!="" && $.trim(bonusChannel).includes($(this).data("type")))) &&
        				($.trim(stepAmount)!="" && parseFloat($.trim(stepAmount))>parseFloat(amount))) {
		        		argument = "<p>Has activado el Bono de "+bonusPercentage+"%, pero con un monto menor a S/ "+stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>";
		        	} else {safetypayCharge(posAmount, typeToken);}
		            if (argument != "") {
		            	$("#confirmModal_content_id").html(argument);
						$("#confirm_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {safetypayCharge(posAmount, typeToken);} , onCancelBut: function(event, el) {} });			
					}
		        }
		    });
		    $('#peflcharge, #pefecharge').click(function(event) {
		        event.preventDefault();
		        var minAmount = (chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40;
		        var maxAmount = (chdata.pefeMaxAmount!=null && chdata.pefeMaxAmount!='' && !isNaN(chdata.pefeMaxAmount))?parseFloat(chdata.pefeMaxAmount):3000;
		        var amount = ($(this).attr("id")=="pefecharge")?parseInt($("#pefeAmount").val().replace(/[S/ ,]/g,"")):parseInt($("#peflAmount").val().replace(/[S/ ,]/g,""));
		        var argument = "";
		        if (amount < minAmount || amount == '' || isNaN(amount)) {
		        	alertMessage("<div class='info'></div><p>Debes ingresar un monto de carga m&iacute;nima de S/ "+minAmount+".</p>");
		            $("#pefeAmount").val("S/ "+minAmount);
		            $("#peflAmount").val("S/ "+minAmount);
		        } else if (amount > maxAmount) {
		        	alertMessage("<div class='info'></div><p>Debe ingresar un monto de carga no mayor de S/. "+maxAmount+".</p>");
		            $("#pefeAmount").val("S/ "+minAmount);
		            $("#peflAmount").val("S/ "+minAmount);
		        } else {
		        	var posAmount = ($(this).attr("id")=="pefecharge")?$("#pefeAmount").val().replace(/[S/ ,]/g,""):$("#peflAmount").val().replace(/[S/ ,]/g,"");
		        	var typeToken = ($(this).attr("id")=="pefecharge")?2:1;
		        	if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
				        	$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(bonusChannel) == "" || ( $.trim(bonusChannel) != "" && $.trim(bonusChannel).includes($(this).data("type"))))) {
		        		argument = "<p>Hoy ofrecemos Bono de "+bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovech&aacute;ndolo.<br/>&iquest;Deseas continuar de todos modos con tu recarga?</p>";
		        	} else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
				        	$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(bonusChannel)=="" || ($.trim(bonusChannel)!="" && $.trim(bonusChannel).includes($(this).data("type")))) &&
		                	($.trim(stepAmount)!="" && parseFloat($.trim(stepAmount))>parseFloat(amount))) {
		        		argument = "<p>Has activado el Bono de "+bonusPercentage+"%, pero con un monto menor a S/ "+stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>";
		        	} else {pagoefectivoCharge(posAmount, typeToken);}

		            if (argument != "") {
		            	$("#confirmModal_content_id").html(argument);
						$("#confirm_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {pagoefectivoCharge(posAmount, typeToken);} , onCancelBut: function(event, el) {} });			
					}
		        }
		    });
		    $(document).delegate("#bcpAmount, #peflAmount, #sfplAmount, #pefeAmount, #sfpeAmount, #numberCard, #culqAmount, input[name=culqNumber], input[name=culqCvv], input[name=culqExp_month], input[name=culqExp_year]", "keypress", function (event) {
	    		if(event.which != 8 && event.which != 0 && (event.which < 48 || event.which > 57)) {
	    	        return false;
	    	    }
	    	});
    		$(document).delegate("#bcpAmount, #peflAmount, #sfplAmount, #pefeAmount, #sfpeAmount", "keyup", function() {
        		var foo = $(this).val().replace(/[S/ ,]/g,"");
        		if(foo.length > 0) foo = "S/ "+foo.replace(/\B(?=(\d{3})+(?!\d))/g, ",");//.match(new RegExp('.{1,3}', 'g')).join(",");
        		$(this).val(foo);
    		});
    		$('#close_sfpl').click(function(event) {
		        event.preventDefault();
		        $("#frame_sfpl iframe").attr("src", "about:blank");
                $("#frame_sfpl").addClass("hide");
                $("#close_sfpl").addClass("hide");
    		});
    		$('#close_pefl').click(function(event) {
		        event.preventDefault();
		        $("#frame_pefl iframe").attr("src", "about:blank");
                $("#frame_pefl").addClass("hide");
                $("#close_pefl").addClass("hide");
    		});
    		$('#close_sfpe').click(function(event) {
		        event.preventDefault();
		        $("#frame_sfpe iframe").attr("src", "about:blank");
                $("#frame_sfpe").addClass("hide");
                $("#close_sfpe").addClass("hide");
    		});
    		$('#close_pefe').click(function(event) {
		        event.preventDefault();
		        $("#frame_pefe iframe").attr("src", "about:blank");
                $("#frame_pefe").addClass("hide");
                $("#close_pefe").addClass("hide");
    		});
		})
		
		function toJSON(a) {
	        return ((a === '') ? '' : $.parseJSON($.trim(a)));
	    }
		
		function bcpCharge(amount, transact, actbono, actwbbono) {
			$('button').prop('disabled', true);	
			try {
				var notificacion='';
		        var data = '';
		        var message = '';
		        var newamount = 0.0;
		        var msgres = [];
		        //var ico = $("#bcpcharge").siblings('i');
		        //$(ico).addClass('loading').removeClass('hide');
		        if($(".wrap-card .row").length < 5) {
			        $.ajax({
			            type: "post",
			            url: "verifica-codigo-bcp.html",
			            dataType: "text",
			            data: "bcp-amount=" + amount + "&bcp-transact=" + transact + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
			            //global: false,
			            //async: false,
			            beforeSend: function () {
			            	$("#cargando").addClass('loading');
			            },
			            error: function () {
			            	$("#cargando").removeClass('loading');
			            	$('button').prop('disabled', false);
			            },
			            success: function (e) {
			            	try{
			            		msgres = $.trim(e.toString()).split("|||");
				                data = msgres[0];
				                message = msgres[1];
				                newamount = msgres[2]; 
				                bono = msgres[3]; console.log('debug bono='+bono);
				                bonosAmount = msgres[4];
				                bonosOtro = msgres[5];
				                if(newamount != "-1" && newamount != null && newamount != "0.0") {
				                	//if(actwbbono==true) $('.content-wrap .wb-saldo').text("");
									if(bono.includes('CASINO') || bono=="TARECARGATE"){
										$("#mi-saldo-bono").text(bonosAmount);
										$("#mi-otro-bono").text(bonosOtro);
										$("#header .text-money:eq(1) span").text(bonosAmount);
										$("#header .text-money:eq(2) span").text(bonosOtro);
									}
									$("#header .text-money:eq(0) span").text(data.newamount);
									$("#mi-saldo").text(newamount);
						                 notificacion="Para concretar el pago, cancele en BCP indicando el c&oacute;digo generado.";
						     		    renderizarBCP(data)
						                
				                }
				                if($.trim(message)!="" && amount!="") {
						        	notificacion="<div class='info'></div><p>"+message+"</p>";
						        }
						        if($.trim(notificacion)!="") alertMessageBCP(notificacion);
						        $("#cargando").removeClass('loading');
						        $('button').prop('disabled', false);
			            	} catch (e) {
			    	  			console.log(err.message);
			    	  			$("#cargando").removeClass('loading');
			    	  			$('button').prop('disabled', false);
			    	  		}
			            }
			        });
		        } else {
		        	message = "Haz alcanzado el l&iacute;mite m&aacute;ximo de c&oacute;digos BCP generados.";
		        	if($.trim(message)!="" && amount!="") {
			        	notificacion="<div class='info'></div><p>"+message+"</p>";
			        }
			        if($.trim(notificacion)!="") alertMessageBCP(notificacion);
			        $('button').prop('disabled', false);
		        }
		        //$(ico).removeClass('loading').addClass('hide');
			} catch (e) {
	  			console.log(err.message);
	  			$('button').prop('disabled', false);
	  		}
		}	
		
        	function renderizarBCP(data){
		        var grilla = "<div class='wrap-card'>";
		        var fila = data.split("||");
		        if(fila.length>0 && fila[0]!='') {
		            for (var n = 0; n < fila.length; n++) {
		                var items = fila[n].split("|");
		                if (items.length > 0) {
		                    grilla += "<div class='row'><div class='w-50'><div class='text-label'><label>C&OacuteDIGO DE "+items[1]+"</label></div></div><div class='w-50'><div class='text-label'><label>FECHA DE EXPIRACI&OacuteN</label></div></div><div class='w-50'>"+items[0]+"</div><div class='w-50'>"+items[2]+"</div><div class='w-50 btop'><div class='sub-accordion pr-1'><div class='sub-button'>";
		                    if (items[3] === "OKK") {
		                        grilla += "<button type='button' class='btn btn-sm btn-black' onclick='runPay.grillaCode(\"\",\"\",\"\")'>REFRESCAR</button>";
		                    } else if (items[3] === "PEN") {
		                    	grilla += "<button type='button' class='btn btn-sm btn-black bcpverify'>VERIFICAR</button>";
		                    } else if (items[3] === "ACT") {
		                    	grilla += "<button type='button' class='btn btn-sm btn-black bcpverify' disabled>PAGADO</button>";
		                    } else if (items[3] === "ANU") {
		                    	grilla += "<button type='button' class='btn btn-sm btn-black bcpverify' disabled>ANULADO</button>";
		                    } else if (items[3] === "CAD") {
		                    	grilla += "<button type='button' class='btn btn-sm btn-black bcpverify' disabled>CADUCADO</button>";
		                    }
		                    grilla += "</div></div></div><div class='w-50 btop'><div class='sub-accordion pl-1'><div class='sub-button'>";
		                    if (items[3] === "OKK") {
		                    	grilla += "<button type='button' class='btn btn-sm btn-black bcpverify' disabled>ANULAR</button>";
		                    } else if (items[3] === "PEN") {
		                    	grilla += "<button type='button' class='btn btn-sm btn-black bcpdelete' data-pin='"+items[4]+"'>ANULAR</button>";
		                    }
		                    grilla += "</div></div></div></div>"
		                }
		            }
		            grilla += "</div>";
		            $('#grilla_bcp').html(grilla)
		        }
	        
	    }
		function safetypayCharge(posAmount, typeToken) {
			$('button').prop('disabled', true);	
			try {
		        var actbono = $("#chkactivatebond").is(":checked");
		        var actwbbono = $("#chkactivatewbbond").is(":checked");
		        //var ico = (typeToken==1)?$("#sfplcharge").siblings('i'):$("#sfpecharge").siblings('i');
		        //$(ico).addClass('loading').removeClass('hide');
		        $.ajax({
		            type: "post",
		            url: "safety_page_post.html",
		            data: "posAmount=" + posAmount + "&typeToken=" + typeToken + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
		            dataType: "text",
		            //global: false,
		            //async: false,
		            beforeSend: function () {
		            	$("#cargando").addClass('loading');
		            },
		            error: function () {
		            	$("#cargando").removeClass('loading');
		            	$('button').prop('disabled', false);
		            },
		            success: function (e) {
		            	try{
			                if (e != null && e != "") {
			                    var redireccion = $.trim(e.toString()).split("|");
			                    if (redireccion[1] != null && $.trim(redireccion[1]) != "") {
			                    	if(actwbbono==true) $('.content-wrap .wb-saldo').text("");
			                    	alertMessage("<div class='info'></div><p>"+$.trim(redireccion[1])+"</p>");
			                    } else {
			                        if(typeToken==1) {
			                        	$("#frame_sfpl iframe").attr("src", $.trim(redireccion[0]));
			                        	$("#frame_sfpl").removeClass("hide");
			                        	$("#close_sfpl").removeClass("hide");
			                        } else if(typeToken==2) {
			                        	$("#frame_sfpe iframe").attr("src", $.trim(redireccion[0]));
				                        $("#frame_sfpe").removeClass("hide");
				                        $("#close_sfpe").removeClass("hide");
				                    }
			                    }
			                } else {
			                	alertMessage("<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
			                }
			                $("#cargando").removeClass('loading');
			            	$('button').prop('disabled', false);
		            	} catch (e) {
		    	  			console.log(err.message);
		    	  			$("#cargando").removeClass('loading');
			            	$('button').prop('disabled', false);
		    	  		}
		            }
		        });
		        //$(ico).removeClass('loading').addClass('hide');
			} catch (e) {
	  			console.log(err.message);
	  			$('button').prop('disabled', false);
	  		}
	    }
		
		function pagoefectivoCharge(posAmount, typeToken) {
			$('button').prop('disabled', true);	
			try {
		        var actbono = $("#chkactivatebond").is(":checked");
		        var actwbbono = $("#chkactivatewbbond").is(":checked");
		        //var ico = (typeToken==1)?$("#peflcharge").siblings('i'):$("#pefecharge").siblings('i');
		        //$(ico).addClass('loading').removeClass('hide');
		        
		        $.ajax({
		            type: "post",
		            url: "portal_page.html",
		            data: "posAmount=" + posAmount + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
		            dataType: "text",
		            //global: false,
		            //async: false,
		            beforeSend: function () {
		            	$("#cargando").addClass('loading');
		            },
		            error: function () {
		            	$("#cargando").removeClass('loading');
		            	$('button').prop('disabled', false);
		            },
		            success: function (e) {
		            	try{
			                if (e != null && e != "") {
			                    var redireccion = $.trim(e.toString()).split("|");
			                    if (redireccion[1] != null && $.trim(redireccion[1]) != "") {
			                    	if(actwbbono==true) $('.content-wrap .wb-saldo').text("");
			                    	alertMessage("<div class='info'></div><p>"+$.trim(redireccion[1])+"</p>");
			                    } else {
			                    	if(typeToken==1) {
			                    		$("#frame_pefl iframe").attr("src", $.trim(redireccion[0]));
			                        	$("#frame_pefl").removeClass("hide");
			                        	$("#close_pefl").removeClass("hide");
			                        } else if(typeToken==2) {
			                        	$("#frame_pefe iframe").attr("src", $.trim(redireccion[0]));
				                        $("#frame_pefe").removeClass("hide");
				                        $("#close_pefe").removeClass("hide");
				                    }
			                    }
			                } else {
			                	alertMessage("<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
			                }
			                $("#cargando").removeClass('loading');
			            	$('button').prop('disabled', false);
		            	} catch (e) {
		    	  			console.log(err.message);
		    	  			$("#cargando").removeClass('loading');
			            	$('button').prop('disabled', false);
		    	  		}
		            }
		        });
		        //$(ico).removeClass('loading').addClass('hide');
			} catch (e) {
	  			console.log(err.message);
	  			$('button').prop('disabled', false);
	  		}
	    }

	    function alertMessage(e){
	    	$("#alertModal_content_id").html(e);
		    $("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {} });
		}
	    
	    function alertMessageBCP(e){
	    	$("#alertModal_BCP_content_id").html(e);
		    $("#alert_BCP_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {} });
		}
	</script>
<div id="confirm_content" style="display:none">
	<div id="confirmModal_content_id" class="confirmModal_content">
	</div>
	<div class="confirmModal_footer">
		<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">Continuar</button>
		<button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">Retornar</button>
	</div>
</div>

<div id="alert_BCP_content" style="display:none">
	<div id="alertModal_BCP_content_id" class="confirmModal_content">
	</div>
	<div class="confirmModal_footer_alert">
		<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">OK</button>
	</div>
</div>

<div id="alert_content" style="display:none">
	<div id="alertModal_content_id" class="confirmModal_content">
	</div>
	<div class="confirmModal_footer_alert">
		<button type="button" class="dialog d-btn d-btn-primary" onclick="okAlert()" data-confirmmodal-but="ok">OK</button>
	</div>
</div>


</body>

</html>