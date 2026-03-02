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
	<title>Gana Diario: ¿Cómo se juega Gana Diario?</title>    
    <meta name="description" content="¿Qué es Gana Diario? Es un juego de lotería que te ofrece las opciones de jugada simple y múltiple por solo un sol. Gana más de 100,000 soles cada día del año.">	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	
</head>
<body class="main-ganadiario">
 
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<h1 style="display: none;">Gana Diario: ¿Cómo se juega Gana Diario?</h1>
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">

		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<img src="layer-view-image/v2/logo-ganadiario.png" alt="tinka">
						<div class="game-desc">
							<h2>PREMIO DIARIO</h2>
						</div>
						<div class="game-price">
							<div class="current-price" id="pozo-ganadiario">${pozo}</div>
							<div class="current-date">Cierra a las ${headerGame.closeHour}:${headerGame.closeMinute} del día ${headerGame.closeDate1}</div>
						</div>
						<form action="game_ganadiario_show_bet.html" method="post">
							    <input id="play" name="play" type="hidden" value="a">
							    <button <c:if test="${pozoMillonario == 'S/. 0'}"> disabled="disabled" </c:if>
							<c:if test="${pozoMillonario != 'S/. 0'}"> type="submit" </c:if>
							class="btn btn-red tinka">JUEGA GANADIARIO</button>	
						</form>
					</div>
					<div class="main-game">	
						<% /*
						<button type="button" class="btn btn-red float-bottom" 
							<c:if test="${pozo == 'S/. 0'}" > disabled="disabled" </c:if>
							<c:if test="${pozo != 'S/. 0'}" > id="btn_mobile_juega_ahora_ganadiario" </c:if>
						>JUEGA AHORA</button>
						*/ %>
						<!-- >QUIERO GANAR</button -->
						<div class="last-result">
							<div class="top-results-games">
								<div class="last-text">Resultados del último sorteo</div>
								<div class="last-date">N° ${headerResult.drwid}</div>
							</div>
							<div class="results-games">
								<div id="results1" class="hide">${headerResult.result}</div>
								<div id="resultsview1" class="results-balls clearfix"></div>
							</div>
							<button type="button" id="btn_mobile_ver_resultados_ganadiario" class="btn btn-purple" onclick="window.location.href='game_ganadiario_show_result.html';">Ver resultados anteriores</button>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../../include/footer.jsp" />

	<script type="text/javascript">

		$(document).ready(function(){

			replacehtml('#results1', '#resultsview1', '-');
			var pozo = $('#pozo-ganadiario').html();
			var new_pozo = pozo.replace(".", " ");
			$('#pozo-ganadiario').html(new_pozo);

			$(".contentRow").on("click",function(){
				var $this = $(this);
				var dataF = $this.attr("data-dom");
				$(".contentRow").removeClass("active");
				$this.addClass("active");
				try {
					$("#playSuscription").val(dataF);
					$("#game_ganadiario_bet_suscription").submit();
				} catch (e) {}
				
			});
			
		});

	</script>
	
	
	
	
</body>
</html>