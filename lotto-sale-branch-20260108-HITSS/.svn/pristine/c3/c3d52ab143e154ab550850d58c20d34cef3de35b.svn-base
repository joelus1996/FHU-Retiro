<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="subtitulo">
	ESTAD&Iacute;STICA
	<span>
		<c:choose>
			<c:when test="${anio == 0}">A LA FECHA</c:when>
			<c:otherwise>${anio}</c:otherwise>
		</c:choose>
	</span>
</div>
<div class="datos datos-por-mes">
	<div class="col col-margen">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<th align="left" colspan="3">
					<div class="tabla-cabecera">
						<div class="titulo3">Mes</div>
						<div class="titulo4">Veces</div>
						<div style="clear:both"></div>
					</div>
				</th>
			</tr>
			<c:forEach var="element" items="${lista1}">
			<tr class="tabla-fila">
				<td width="66"><div class="celdai celda-mes">${element.mesAsString}</div></td>
				<td width="81">
					<div class="celdai celda-barra" align="left">
						<div class="barra" style="width:${element.ancho}px"></div>
					</div>
				</td>
				<td width="54">
					<div class="celdad celda-numero">${element.cantidad}</div>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col col-margen">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<th align="left" colspan="3">
					<div class="tabla-cabecera">
						<div class="titulo3">Mes</div>
						<div class="titulo4">Veces</div>
						<div style="clear:both"></div>
					</div>
				</th>
			</tr>
			<c:forEach var="element" items="${lista2}">
			<tr class="tabla-fila">
				<td width="66"><div class="celdai celda-mes">${element.mesAsString}</div></td>
				<td width="81">
					<div class="celdai celda-barra" align="left">
						<div class="barra" style="width:${element.ancho}px"></div>
					</div>
				</td>
				<td width="54">
					<div class="celdad celda-numero">${element.cantidad}</div>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div class="col">
		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<th align="left" colspan="3">
					<div class="tabla-cabecera">
						<div class="titulo3">Mes</div>
						<div class="titulo4">Veces</div>
						<div style="clear:both"></div>
					</div>
				</th>
			</tr>
			<c:forEach var="element" items="${lista3}">
			<tr class="tabla-fila">
				<td width="66"><div class="celdai celda-mes">${element.mesAsString}</div></td>
				<td width="81">
					<div class="celdai celda-barra" align="left">
						<div class="barra" style="width:${element.ancho}px"></div>
					</div>
				</td>
				<td width="54">
					<div class="celdad celda-numero">${element.cantidad}</div>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	<div style="clear:both;"></div>
</div>