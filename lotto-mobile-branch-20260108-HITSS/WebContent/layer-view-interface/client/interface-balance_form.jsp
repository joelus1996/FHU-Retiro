<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ include file="/layer-view-interface/include/taglib.jsp" %>
		<!DOCTYPE html>
		<html lang="es">

		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
			<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
			<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>"
				type="text/css" />
			<link rel="stylesheet" href="layer-view-style/client/mainBalance.css?v=<%=Constantes.main_1_0_css%>"
				type="text/css" />
		</head>

		<body>
			<input type="hidden" id="token" value="${token}" />
			<input type="hidden" id="operatorId" value="${operatorId}" />
			<div class="movements-content-iframe">
				<div class="main-page" id="movements-total-balance-main-page">
					<div class="main-wallet">
						<div class="top-wallet-jg">
							<div class="jg-tt-wallet">
								<h3>Total</h3>
								<h1 id="total-balance">S/ 0.00</h1>
							</div>

						</div>
					</div>
				</div>
				<form class="form_filter_movimientos">
					<div class="movements-filter-box">
						<div class="sms_movimientos">
							<p style="margin: 2px;">Filtra tu búsqueda en un rango de 30 días como máximo, hasta con dos
								años de antigüedad. </p>
						</div>
						<div class="movements-form">
							<div class="form_filter form__input-filtro movements-form-filter"
								style="margin-right: 0px;">
								<label for="fechainicio">Desde</label>
								<input type="text" placeholder="Desde" id="fecha_inicio" name="fechainicio"
									maxlength="10" class="fecha-input" tabindex="15" readonly>
							</div>
							<div class="form_filter form__input-filtro movements-form-filter"
								style="margin-right: 0px;">
								<label for="fechafin">Hasta</label>
								<input type="text" placeholder="Hasta" id="fecha_fin" name="fechafin" maxlength="10"
									class="fecha-input" tabindex="15" readonly>
							</div>
						</div>
					</div>
				</form>
				<div class="movements-container" id="movements-contain-items">
					<div class="movements-filter-count" id="movements-filter-count">
						<label for="row-limit" class="movements-filter-label">Mostrar filas</label>
						<select id="row-limit" class="movements-filter-select">
							<option value="15" selected>15</option>
							<option value="20">20</option>
							<option value="25">25</option>
							<option value="50">50</option>
							<option value="100">100</option>
						</select>
					</div>
					<div class="movements-container-list" id="items-hispayment" data-show-items="4"></div>
					<div class="pagination" id="pagination-items-hispayment">
						<div class="pages"></div><a class="prev is-disabled" href=""><i class="icon-regresar"></i></a><a
							class="next" href=""><i class="icon-siguiente"></i></a>
					</div>
					<br><br><br>
					<div id="popup" class="overlay">
						<div class="popup popup-sm">
							<a class="close js-close-modal" href="#">&times;</a>
							<div class="main-modal"></div>
						</div>
					</div>
				</div>
			</div>
			
			<div id="loading">
				<div class="sk-circle">
				  <div class="sk-circle1 sk-child"></div>
				  <div class="sk-circle2 sk-child"></div>
				  <div class="sk-circle3 sk-child"></div>
				  <div class="sk-circle4 sk-child"></div>
				  <div class="sk-circle5 sk-child"></div>
				  <div class="sk-circle6 sk-child"></div>
				  <div class="sk-circle7 sk-child"></div>
				  <div class="sk-circle8 sk-child"></div>
				  <div class="sk-circle9 sk-child"></div>
				  <div class="sk-circle10 sk-child"></div>
				  <div class="sk-circle11 sk-child"></div>
				  <div class="sk-circle12 sk-child"></div>
				</div>
			</div>

			<jsp:include page="../include/footer.jsp" />
			<script type="text/javascript" src="layer-view-script/jquery.mobile-1.0.min.js"></script>
			<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
			<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
			<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>
			<script type="text/javascript"
				src="layer-view-script/client/mainBalance.js?v=<%=Constantes.main_1_0_js%>"></script>
		</body>

		</html>