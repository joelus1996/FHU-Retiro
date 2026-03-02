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
			<link rel="stylesheet" href="layer-view-style/client/mainGame.css?v=<%=Constantes.main_1_0_css%>"
				type="text/css" />
			<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.main_1_0_css%>"
				type="text/css" />
		</head>

		<body>
			<input type="hidden" id="token" value="${token}" />
			<input type="hidden" id="operatorId" value="${operatorId}" />
			<input type="hidden" id="dataSession" value="${dataSession}" />
			<input type="hidden" id="dataSessionCoupon" value="${dataSessionCoupon}" />

			<div class="game-content-iframe">
				<form class="form_filter_movimientos">
					<div class="game-filter-box">
						<div class="game-sms">
							<p style="margin: 2px;">Filtra tu búsqueda en un rango de 30 días como máximo, hasta con dos
								años de antigüedad. </p>
						</div>
						<div class="tabs-jugadas">
							<button type="button" class="tab-btn active" data-type="pendientes">Pendiente</button>
							<button type="button" class="tab-btn" data-type="finalizadas">Finalizado</button>
						</div>
						<div class="game-form">
							<div class="form_filter form__input-filtro game-form-filter" style="margin-right: 0px;">
								<label for="fechainicio">Desde</label>
								<input type="text" placeholder="Desde" id="fecha_inicio" name="fechainicio"
									maxlength="10" class="fecha-input" tabindex="15" readonly>
							</div>
							<div class="form_filter form__input-filtro game-form-filter" style="margin-right: 0px;">
								<label for="fechafin">Hasta</label>
								<input type="text" placeholder="Hasta" id="fecha_fin" name="fechafin" maxlength="10"
									class="fecha-input" tabindex="15" readonly>
							</div>
							<div class="button-group" style="display: none;">
								<button type="button" id="button-filter" containerclass="filter-popover" triggers=""
									container="body" boundarieselement="viewport" placement="bottom"
									class="btn btn-border btn-submit ng-star-inserted">
									<svg id="Capa_1" xmlns="http://www.w3.org/2000/svg" version="1.1" viewBox="0 0 150 150" style="width: 14px;">
									  <rect x="14.1" y="32.4" width="48.7" height="12.2"/>
									  <rect x="50.6" y="8" width="12.2" height="60.9"/>
									  <rect x="75" y="32.4" width="60.9" height="12.2"/>
									  <rect x="87.2" y="81.1" width="12.2" height="60.9"/>
									  <rect x="87.2" y="105.5" width="48.7" height="12.2"/>
									  <rect x="14.1" y="105.5" width="60.9" height="12.2"/>
									</svg>
									<span>Filtro</span>
								</button>
							</div>
						</div>
					</div>
				</form>
				<div class="game-container" id="game-contain-items">
					<div class="game-filter-count" id="game-filter-count">
						<label for="row-limit" class="game-filter-label">Mostrar filas</label>
						<select id="row-limit" class="game-filter-select">
							<option value="15" selected>15</option>
							<option value="20">20</option>
							<option value="25">25</option>
							<option value="50">50</option>
							<option value="100">100</option>
						</select>
					</div>
					<div class="game-container-list" id="items-hispayment" data-show-items="4"></div>
					<div class="game-footer">
					    <p>* Encuentra Casino y Virtuales web en 
					        <a href="https://www.teapuesto.pe/" target="_blank">teapuesto.pe</a>
					    </p>
					    <p>* El historial de Video Loterías lo encontrarás dentro de cada juego.</p>
					</div>
					<div class="pagination" id="pagination-items-hispayment">
						<div class="pages"></div><a class="prev is-disabled" href=""><i class="icon-regresar"></i></a><a
							class="next" href=""><i class="icon-siguiente"></i></a>
					</div>
					<br><br><br>
				</div>

				<div id="filtro-popover" class="popover-filter" style="display: none;">
					<ul class="filter-list">
						<li><label><input type="checkbox" value="todo"> Todo</label></li>
						<li><label><input type="checkbox" value="Ganado"> Ganado</label></li>
						<li><label><input type="checkbox" value="Sin Premio"> Sin premio</label></li>
						<li><label><input type="checkbox" value="Pagado"> Pagado</label></li>
						<li><label><input type="checkbox" value="Expirado"> Expirado</label></li>
					</ul>
					<button id="aplicar-filtro" class="btn-aplicar-filtro">Aplicar</button>
				</div>
			</div>
			<div id="popup" class="overlay">
				<div class="popup popup-sm">
					<a class="close js-close-modal" href="#">&times;</a>
					<div class="main-modal"></div>
				</div>
			</div>

			<div id="popup2" class="overlay">
				<div class="popup2 popup-sm2">
					<a class="close js-close-modal2" href="#">&times;</a>
					<div class="main-modal"></div>
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
			<script type="text/javascript" src="layer-view-script/client/mainGame.js?v=<%=Constantes.main_1_0_js%>"></script>
		</body>

		</html>