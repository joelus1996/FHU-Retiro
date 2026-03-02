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
	<title>La Tinka : Lista de jugadas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
</head>
<body class="table-iflex">

					<table class="table-gracia table-bordered table-hover">
					    <tbody><tr class="table-active tableHead">
					        <th colspan="2">Cupón</th>
					    </tr>
					    <tr>
					        <th>Cód. De Apuesta</th>
					        <td>${playCouponInfo.GTICKET}</td>
					    </tr>
					    <tr>
					        <th>ID de cupón</th>
					        <td>${playCouponInfo.GTICKET}</td>
					    </tr>
					    <tr>
					        <th>Estado del cupón</th>
					        <td>${playCouponInfo.GSTATUS}</td>
					    </tr>
					    <tr>
					        <th>Fecha</th>
					        <td>${playCouponInfo.GDATE}</td>
					    </tr>
					    <tr>
					        <th>Importe</th>
					        <td>${GAMOUNT}</td>
					    </tr>
					    <tr>
					        <th>Ganancias Max.</th>
					        <td>${GMAX_AMOUNT_WINNER}</td>
					    </tr>
					    <tr>
					        <th>Ganancias Totales</th>
					        <td>${GPRIZE}</td>
					    </tr>
					</tbody></table>
					<table class="table-gracia  table-bordered  table-hover">
    <tbody><tr class="table-active tableHead">
        <th>Apuestas</th>
    </tr>
    	<tr>
		<td>
			<table class="table-gracia table-bordered table-hover">
			<tbody><tr>
				<th class="tableSubHead">Combinada</th>
				<td>${playCouponInfo.GCOMBINATION}</td>
			</tr>
			<tr>
				<th class="tableSubHead">Multiplicador</th>
				<td>${playCouponInfo.GMULTIPLICADOR}</td>
			</tr>
			<tr>
				<th class="tableSubHead">Importe</th>
				<td>${GAMOUNT}</td>
			</tr>
			<tr>
				<th class="tableSubHead">Gan. Potencial</th>
				<td>${GMAX_AMOUNT_WINNER}</td>
			</tr>
			</tbody></table>
		</td>
	</tr>
	</tbody></table>
	
	<table class="table-gracia  table-bordered  table-hover">
    <tbody><tr class="table-active tableHead">
        <th>Eventos</th>
    </tr>
    <c:forEach var="eventos" items="${eventosInfo}">
	    <tr>
			<td>
				<table class="table-gracia table-bordered table-hover">
					<tbody><tr>
						<th class="tableSubHead">Evento</th>
						
						<td><c:out value="${eventos['W_EQUIPOS']}"/></td>
					</tr>
					<tr>
						<th class="tableSubHead">Mercados</th>
						<td><c:out value="${eventos['W_MERCADO']}"/></td>
					</tr>
					<tr>
						<th class="tableSubHead">Tipo</th>
						<td><c:out value="${eventos['W_CODIGO_SELECCION']}"/></td>
					</tr>
					<tr>
						<th class="tableSubHead">Hnd</th>
						<td>-</td>
					</tr>
					<tr>
						<th class="tableSubHead">Cuotas</th>
						<td><c:out value="${eventos['W_ODD']}"/></td>
					</tr>
				</tbody></table>
			</td>
		</tr>
	</c:forEach> 
</tbody></table>					
</body>
</html>