<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Estadisticas Tinka</title>
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/estadistica/estadisticas.css">
	<script language="javascript" type="text/javascript" src="layer-view-script/estadistica/jquery-1.4.2.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$.post('resultados_estadistica.html', {opcion:1 , marca: $("#marca").val() , fecha: $("#fecha").val() } , function(data) {
				$("#resultado1").html(data);
			});
			$.post('resultados_estadistica.html', {opcion:2 , marca: $("#marca").val() , fecha: 0 } , function(data) {
				$("#resultado2").html(data);
			});
			$("#fecha").change(function(){
				$.post('resultados_estadistica.html', {opcion:1 , marca: $("#marca").val() , fecha: $("#fecha").val() } , function(data) {
					  $("#resultado1").html(data);
				});				
			});
		});
	</script>
</head>
<body style="border:0; margin:0;">
	<div class="contenido tinka">
		<div class="controles">
			<div class="mensaje1">
				Revisa cu&aacute;ntas veces fueron extra&iacute;das cada una de las 50 bolillas en el sorteo de la Tinka.
			</div>
			<div class="formulario">
				<input type="hidden" id="marca" name="marca" value="${marca}" />
				<div class="combo">
					<select id="fecha" name="fecha" class="fecha">
						<option value="0">Todos</option>
						<c:forEach var="element" items="${anios}" >
							<option value="${element}">${element}</option>
						</c:forEach>
					</select>
				</div>
				<div class="mensaje2">Por Año</div>
			</div>
			<div style="clear:both"></div>
		</div>
		<div id="resultado1">
		</div>
		<div class="controles controles2">
			<div class="mensaje1">
				Ent&eacute;rate en qu&eacute; meses revent&oacute; el pozo millonario de la Tinka.
			</div>
			<div style="clear:both"></div>
		</div>
		<div id="resultado2">
		</div>
	</div>
</body>
</html>