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
	<title>Gana Diario Resultados | Últimos Resultados de Hoy</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Descubre los últimos resultados de Gana Diario de forma online. ¡Entra ahora y descubre si fuiste uno de los ganadores!" />
	
</head>
<body class="main-ganadiario">


	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<h1 style="display: none;">Gana Diario Resultados</h1>
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<a href="#" id="game_ganadiario_show_menu">
							<img src="layer-view-image/v2/logo-ganadiario.png" alt="tinka">
						</a>
						<div class="game-desc min-desc">
							<h2>ÚLTIMOS RESULTADOS</h2>
						</div>

						<div class="boxes-lots">

							<c:forEach	var="item"  items="${getListResult}">

								<div class="box-last-game">
									<div class="top-last-game">
										<h3>Sorteo ${item.drwid} - ${item.date}</h3>
									</div>
									<div class="bottom-last-game">
										<h5>Bolillas: ${item.result}</h5>
									</div>
								</div>

							</c:forEach>
							
						</div>

					</div>
				</section>
			</div>
		</div>

	</div>

	<jsp:include page="../../include/footer.jsp" />
	<script>
	$(document).delegate('#game_ganadiario_show_menu', 'click', function(e){
   		e.preventDefault();
   		window.location.href ='game_ganadiario_show_menu.html';
   	});
	</script>
</body>
</html>