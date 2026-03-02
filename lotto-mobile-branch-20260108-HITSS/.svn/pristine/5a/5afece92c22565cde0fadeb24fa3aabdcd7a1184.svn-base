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
	<title>Ganagol : Jugada</title>	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Ganagol móvil, realiza una jugada consecutiva" />
	
</head>
<body class="main-ganagol">
 
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">

		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<div class="program-match">
							<div class="teams-match">
								<div class="table">
									<div class="left-match">
										<div class="team-match">${local}</div>
									</div>
									<div class="right-match">
										<div class="team-match">${visitante}</div>
									</div>
								</div>
							</div>
							<div class="desc-program">
								<div class="current-match">
									<span id="title-match">${title}</span> - <span>${torneo}</span>
								</div>
								<!-- <div class="current-league">
									<span>${torneo}</span>
								</div> -->
								<c:if test="${!empty tiempos}">
									<div class="current-league">
										<span>${tiempos}</span>
									</div>
								</c:if>
							</div>
						</div>
						<div class="make-game">
							<div class="top-make">
								<h2>HAZ TU JUGADA</h2>
								<p>Selecciona uno o más resultados</p>
							</div>
							<form action="game_ganagol_add_bet.html" method="post" id="game_ganagol_add_bet">
								<div class="body-make">
									<div class="box-play">
										<div class="box-checkbox">
											<input type="checkbox" name="bet" id="bet_l" value="L" />
											<label for="bet_l">${local} (L)</label>
										</div>
									</div>
									<div class="box-play">
										<div class="box-checkbox">
											<input type="checkbox" name="bet" id="bet_e" value="E" />
											<label for="bet_e">Empate (E)</label>
										</div>
									</div>
									<div class="box-play">
										<div class="box-checkbox">
											<input type="checkbox" name="bet" id="bet_v" value="V" />
											<label for="bet_v">${visitante} (V)</label>
										</div>
									</div>
								</div>
							</form>
						</div>
						<div class="game-actions">
							<c:if test="${itemPk != 14}">
<%-- 								<button type="button" id="addBetGanagol" next="${itemPk+1}" class="btn btn-red">SIGUIENTE ${itemPk+1}/14</button> --%>
								<button type="button" id="addBetGanagol" next="${itemPk+1}" class="btn btn-red float-bottom">SIGUIENTE ${itemPk+1}/14</button>
							</c:if>
							<button type="button" id="addBetGanagol" next="" class="btn btn-yellow">ACEPTAR</button>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../../include/footer.jsp" />

	<script type="text/javascript">
		
		$(document).ready(function(){
			replacematch("#title-match");
		})

	</script>

</body>
</html>