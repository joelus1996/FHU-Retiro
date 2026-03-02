<!--@ include file="../include/taglibs.jspf"%>
<@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="es">
<head>
    <meta charset="UTF-8">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/themeUser.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/signUp.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/styleUpdateDate.css">
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    
    <title>Actualizar Datos</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body>
<@ include file="../include/header.jspf" %>
	<div id="main-content-background">
	    <div id="main-content">		
	     <c:if test="${DataClient != null}" >	
			<input type="hidden" id="DataClient" value="<c:out value='${DataClient}'/>">
			</c:if>
						<@ include file="../include/menu.jspf" %>
							<div class="update-date-title">
								<span class="contact-icon-title"></span>
								<span class="update-date-title-text">&iexcl;ACTUALIZA TUS DATOS Y GANA&#33;</span>
							</div>
							<div class="content-update-date">
								<div class="content-update-date-info">
					            </div>
								<div id="content">
									<form id="frm-update-date" action="update-data-promotion.html" method="post">
										<fieldset class="account-data-fields">	
											<table id="table1">
												<tr>
													<td class="clabel" id="clabel"><label for="name">Nombres</label></td>
													<td class="cq"></td>
													<td class="cinputs"><input type="text" class="text-in max" id="name" name="name" placeholder="nombres" autocomplete="off" required="required">
													</td>
												</tr>
												<tr>
													<td class="clabel"><label for="ap-paterno">Apellidos</label></td>
													<td class="cq"></td>
													<td class="cinputs">
														<input type="text" class="text-in half" name="ap-paterno" id="ap-paterno"
															   placeholder="paterno" autocomplete="off" required="required">
														<input type="text" class="text-in half" name="ap-materno" id="ap-materno"
															   placeholder="materno" autocomplete="off" required="required">
													</td>
												</tr>
												<tr>
													<td class="clabel"><label>Sexo</label></td>
													<td class="cq"></td>
													<td class="cinputs">
														<input type="radio" name="gender" value="M" id="male" >
														<label for="male" class="internal-label">masculino</label>
														<input type="radio" name="gender" value="F" id="female" >
														<label for="female" class="internal-label">femenino</label>
													</td>
												</tr>
												<c:if test="${dataClient.birthDate != '' && dataClient.birthDate != null}">
														<tr>
															<td class="clabel"><label>Fecha de nacimiento</label></td>
															<td class="cq"></td>
															<td class="cinputs"><span class="text-out" id="birth-date"></span></td>
														</tr>
														</c:if>
														<c:if test="${dataClient.birthDate == '' || dataClient.birthDate == null }">
														<tr>
															<td class="clabel"><label>Fecha de nacimiento</label></td>
															<td class="cq"></td>														
															<td class="cinputs">
																<div class="custom-select" data-select="day" id="switch-day">
																	<span id="op-sel-day" class="placeholder">Día</span>
																	<ul class="option-list" id="x-day" data-select="day"></ul>
																</div>
																<select class="select" name="day" id="day" ></select>
								
																<div class="custom-select" data-select="month" id="switch-month">
																	<span id="op-sel-month" class="placeholder">Mes</span>
																	<ul class="option-list" id="x-month" data-select="month"></ul>
																</div>
																<select class="select" name="month" id="month"></select>
								
																<div class="custom-select" data-select="year" id="switch-year">
																	<span id="op-sel-year" class="placeholder">A&ntilde;o</span>
																	<ul class="option-list" id="x-year" data-select="year"></ul>
																</div>
																<select class="select" name="year" id="year"></select>
															</td>
														</tr>
														</c:if>
														<tr>
															<td class="clabel"><label>Documento:</label></td>
															<td class="cq"></td>
															<td class="cinputs">
																<div class="custom-select" data-select="document-type" id="switch-document-type">
																	<span id="op-sel-document-type" class="value-in placeholder">seleccione</span>
																	<ul class="option-list" id="x-document-type" data-select="document-type"></ul>
																</div>
																<select class="select" name="document-type" id="document-type"></select>
																<input type="text" class="text-in medium" name="document-number" id="document-number"
																	   placeholder="número" onkeypress="return validar(event)" maxlength="8" autocomplete="off" required="required">
															</td>
														</tr>	
														<tr>
															<td class="clabel"><p class="movil"><label for="fixed-phone">Teléfonos:</label></p></td>
															<td class="cq"></td>
															<td class="cinputs" id = "cinputs">
																<div class="custom-select min" data-select="comMovil" id="switch-comMovil">
																	<span id="op-sel-comMovil" class="placeholder">Operador</span>
																	<ul class="option-list" id="x-comMovil" data-select="comMovil"></ul>
																</div>
															   <select class="select" name="comMovil" id="comMovil">
															   </select>                               
																
																<input type="text" class="text-in medium" onkeypress="return validar(event)" name="mobile-phone" id="mobile-phone" placeholder="celular" required="required">						                                   					                                    
															</td>
														</tr>
												
											</table>							
										</fieldset>
										<fieldset class="personal-data-fields">
											<img src="layer-view-image/client/img-recuerda.png" height="193" width="181"/>
										</fieldset>
										<fieldset class="other-fields">
											
											<input id="terms" type="checkbox" name="terms" checked="checked" value="1" required="required">
											<label for="terms">Acepto los <a href="#" id="term-cond">T&eacute;rminos y Condiciones</a> de la promoci&oacute;n.</label><br>
											<c:if test="${dataClient.confirm != 'Y'}">
												<input  id="confirm" type="checkbox" name="confirm" value ="Y" checked="checked" >
												<label for="confirm">Deseo recibir promociones y noticias a mi correo electrónico.</label>
											</c:if>
										</fieldset>
										<input type="submit" id="update" value=""/>
								</form>
							</div>
							<div>
								<table id="table-style">
									<tr><th colspan="3"><hr size="8" width="75%"/></th></tr>
									<tr>
										<td>
											<p class="first-p"><span id="icon-protegido"></span><span>Sitio protegido, compras 100% seguro</span></p>
											<p><span id="icon-zona-segura"></span><span>Zona segura, encriptamos tus datos</span></p>
										</td>
										<td>
											<hr id="separador"/>
										</td>
										<td>
											<p class="first-p"><span id="icon-saber-zona-segura"></span><a href="#" id="security">&iquest;C&oacute;mo saber si esta p&aacute;gina es segura?</a></p>
											<p><span id="icon-promociones"></span><span>&iexcl;Accede a promociones y beneficios!</span></p>
										</td>
									</tr>
								</table>
								
							</div>
						</div>							
							
					<iframe class="style-iframe" src="/web/home/right.html" frameborder="0" scrolling="no" width="300" height="516" style="visibility:hidden;" onload="this.style.visibility='visible';"></iframe>
						<@ include file="../include/footer.jspf" %>
	    </div>
	</div>
	
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/client/updateData.js"></script>
<script type="text/javascript" src="layer-view-script/common/index.js
"></script>
</body>
</html-->