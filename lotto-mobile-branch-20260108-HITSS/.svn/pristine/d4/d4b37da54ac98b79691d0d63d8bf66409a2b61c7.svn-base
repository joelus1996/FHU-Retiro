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
	<title>Resultados de Ganagol | Últimos Resultados de Hoy</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Descubre los últimos resultados de Ganagol de forma online. ¡Entra ahora y descubre si fuiste uno de los ganadores!" />
	
</head>
<body class="main-ganagol">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<h1 style="display: none;">Resultados de Ganagol</h1>
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<a href="#" id="game_ganagol_show_menu">
							<img src="layer-view-image/v2/logo-ganagol.png" alt="tinka">
						</a>
						<div class="game-desc">
							<h2>RESULTADOS ANTERIORES</h2>
							<fmt:parseDate var="fecha" value="${title}" type='date' pattern="dd/MM/yyyy"/>
							<h4>PROG. ${drwid}: <fmt:formatDate type="both"  pattern="EEEE, dd MMMM " value="${fecha}" /></h4>
						</div>

						<div class="boxes-lots">

							<c:set value="15" var="pageSize" />

							<c:choose>
								<c:when test="${empty param.from}">
									<c:set var="rowBEGIN" value="1" />
								</c:when>
								<c:otherwise>
									<c:set var="rowBEGIN" value="${param.from}" />
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${empty param.to}">
									<c:set var="rowEnd" value="${pageSize}" />
								</c:when>
								<c:otherwise>
									<c:set var="rowEnd" value="${param.to}" />
								</c:otherwise>
							</c:choose>
							<c:forEach begin="${rowBEGIN-1}" step="1" end="${rowEnd-1}" var="item" varStatus="status" items="${resultGamesGanagol}">

								<div class="box-last-game">
									<div class="top-last-game">
										<h3>${item.drawpk.item}. ${item.localName} vs ${item.visitorName}</h3>
									</div>
									<div class="bottom-last-game">
										<h5>${item.localScore}-${item.visitorScore} (${item.result})</h5>
									</div>
								</div>

							</c:forEach>
							<div class="box-last-game">
									<div class="top-last-game">
										<h5>Golazo 200: ${resultadoG200}</h5>
									</div>
							</div>

							<c:set value="${fn:length(resultGamesGanagol)}" var="rLen" />

							<c:choose>
								<c:when test="${rLen lt rowEnd}">
									<c:set var="rCurrEnd" value="${rLen}" />
								</c:when>
								<c:otherwise>
									<c:set var="rCurrEnd" value="${rowEnd}" />
								</c:otherwise>
							</c:choose>

						</div>

						<c:forEach items="${dateResultGanagol}" var="item">

							<div class="game-desc">
								<fmt:parseDate var="fecha" value="${item.date}" type='date' pattern="dd/MM/yyyy"/>
								<h4>PROG. ${item.drwid}: <fmt:formatDate type="both"  pattern="EEEE, dd MMMM " value="${fecha}" /></h4>

								<div class="results-games">
									<a href="#" onclick="window.location.href='game_ganagol_filter_result.html?filter=${item.rawid}&date=${item.date}';" class="resuls-leters">${item.result} / G200: ${item.resultadoG200}</a>
								</div>

							</div>

						</c:forEach>

					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../../include/footer.jsp" />

	<script type="text/javascript">
		
		// $(document).ready(function(){

			// replacehtml2('#results1', '#resultsview1', '#resultsview2', ' ');
			// replacehtml2('#results2', '#resultsview3', '#resultsview4', ' ');
			// replacehtml2('#results3', '#resultsview5', '#resultsview6', ' ');
			// replacehtml2('#results4', '#resultsview7', '#resultsview8', ' ');

		// });

	</script>
	<script>
	$(document).delegate('#game_ganagol_show_menu', 'click', function(e){
   		e.preventDefault();
   		window.location.href ='game_ganagol_show_menu.html';
   	});
	</script>
</body>
</html>