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
	    <title>Kábala: Juega con Kábala y Chau Chamba</title>
    <meta name='description' content="¿Qué es La Kábala? Es un juego de lotería electrónica en tiempo real más popular del Perú, el cual acumula pozos grandes que se sortean 3 veces por semana. " />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	
</head>
<body class="main-kabala">
<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<h1 style="display: none;">La Kabala: ¿Cómo se juega La Kábala?</h1>
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<img class="logo" src="layer-view-image/v2/logo-kabala.png" alt="resultados kabala">
						<div class="game-desc">
							<h2>POZO PRÓXIMO SORTEO</h2>
						</div>
						<div class="game-price">
							<div class="current-price" id="kabala-pozo">${pozoMillonario}</div>
							<div class="current-date">Cierra a las ${closeDraw} del día ${closeDate1}</div>
						</div>
						<form action="game_kabala_show_bet.html" method="post">
							    <input id="play" name="play" type="hidden" value="a">
							    <button <c:if test="${pozoMillonario == 'S/. 0'}"> disabled="disabled" </c:if>
							<c:if test="${pozoMillonario != 'S/. 0'}"> type="submit" </c:if>
							class="btn btn-red tinka" id="btn_mobile_juega_kabala">JUEGA KÁBALA</button>	
						</form>						
						<div class="game-price border-chch">
							<img src="layer-view-image/v2/logo-chauchamba.png"  alt="kabala">
							<div class="game-price">
								<div class="current-price">S/ 5,000</div>
								<div class="current-desc">Mensuales por 20 años.</div>
								<div class="current-sub-desc">(Jugando un S/ 1.00 adicional)</div>
							</div>
						</div>
						<br/>
						
						<!-- >QUIERO SER BILLETÓN</button -->
						<div class="last-result">
							<div class="top-results-games">
								<div class="last-text">Resultados del último sorteo</div>
								<div class="last-date">N° ${headerResult.drwid}</div>
							</div>
							<div class="results-games">
								<div id="results1" class="hide">${headerResult.result}</div>
								<div class="result-title">
									<h3>Kábala</h3>
								</div>
								<div id="resultsview1" class="results-balls clearfix"></div>
							</div>
							<c:if test="${!empty headerResult.drAddonResult2}">
								<div class="results-games">
									<div id="results2" class="hide">${headerResult.drAddonResult2}</div>
									<div class="result-title">
										<h3>Chau Chamba</h3>
									</div>
									<div id="resultsview2" class="results-balls clearfix"></div>
								</div>
							</c:if>
							<button type="button" id="btn_mobile_ver_resultados_kabala" class="btn btn-orange-light" onclick="window.location.href='game_kabala_show_result.html';">Ver resultados anteriores</button>
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
			replacehtml('#results2', '#resultsview2', '-');

			var pozo = $('#kabala-pozo').html();
			var new_pozo = pozo.replace(".", " ");
			$('#kabala-pozo').html(new_pozo);

			$(".contentRow").on("click",function(){
				var $this = $(this);
				var dataF = $this.attr("data-dom");
				$(".contentRow").removeClass("active");
				$this.addClass("active");
				try {
					$("#playSuscription").val(dataF);
					$("#game_kabala_bet_suscription").submit();
				} catch (e) {}
				
			});

		});

	</script>
	
	

</body>
</html>