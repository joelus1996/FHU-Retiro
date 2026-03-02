<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
	<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
	<script>
	window.onload = function () {
		if(document.getElementById("clientId").value){
			dataLayer.splice(0,1,{
				'loginStatus': 'Sesión iniciada',
				'clientid': getClientID(),
				'userID': document.getElementById("clientId").value,
				});
		}
	}
	</script>
	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	<script type="application/ld+json">
	{
  		"@context": "https://schema.org/",
  		"@type": "BreadcrumbList",
  		"itemListElement": [{
    		"@type": "ListItem",
    		"position": 1,
    		"name": "La Tinka",
    		"item": "https://m.latinka.com.pe/" 
  		},{
    		"@type": "ListItem",
    		"position": 2,
    		"name": "Jugar Gana Diario",
    		"item": "https://m.latinka.com.pe/game_ganadiario_show_menu.html" 
  		}]
	}
	</script>
	<meta property="og:title" content="Gana Diario: Juega hoy y Gana el Pozo Millonario">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://m.latinka.com.pe/game_ganadiario_show_menu.html">
	<meta property="og:description" content="¿Qué es Gana Diario? Es un juego de lotería que te ofrece las opciones de jugada simple y múltiple por solo un sol. Gana más de 100,000 soles cada día del año.">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-ganadiario.png">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	<title>Gana Diario: Juega hoy y Gana el Pozo Millonario</title>    
    <meta name="description" content="¿Qué es Gana Diario? Es un juego de lotería que te ofrece las opciones de jugada simple y múltiple por solo un sol. Gana más de 100,000 soles cada día del año.">	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />

	<!--video live-->
    <link rel="stylesheet" href="layer-view-style/game/ganadiario/live/video.css" type="text/css">
    <!--video live-->
	
	
	<link rel="shortcut icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png" type="image/x-icon">
    <link rel="apple-touch-icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
    <link rel="icon" type="image/png" sizes="192x192" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
</head>
<body class="main-ganadiario">


	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Gana Diario" id="Zona">
	<input type="hidden" value id="SubZona">
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
							<div class="current-price" id="pozo-ganadiario"><c:if test="${pozo != '0'}">S/ ${pozo} </c:if></div>
							<div class="current-date">
								<c:if test="${headerResult.status == 'ACT'}"> Cierra a las ${headerResult.closeHour} del día ${headerResult.closeDate} </c:if>
								<c:if test="${headerResult.status == 'CIE'}"> Abre a las ${headerResult.openHour} del día ${headerResult.openDate} </c:if>
							</div>
						</div>
						<form action="game_ganadiario_show_bet.html" method="post">
							    <input id="play" name="play" type="hidden" value="a">
<%-- 							    <button <c:if test="${pozoMillonario == 'S/. 0'}"> disabled="disabled" </c:if> --%>
<%-- 							<c:if test="${pozoMillonario != 'S/. 0'}"> type="submit" </c:if> --%>
							<button <c:if test="${headerResult.status == 'CIE'}"> disabled="disabled" </c:if>
								<c:if test="${pozo != '0'}"> type="submit" </c:if>
							class="btn btn-red tinka" id="btn_mobile_juega_ganadiario">JUEGA GANADIARIO</button>	
						</form>
					</div>
					<c:if test="${isGanadiarioSubscription == 'true'}">
					<div class="combos_ganadiario">
						<div class="titular_home_ganadiario">
							 <div class="bajada">¡COMBOS GANADIARIO!</div>
							 <h2>NO TE PIERDAS NI UN SORTEO</h2>
						</div>
						<div class="row_four">
							<c:if test="${pozoMillonario != 'S/. 0'}">
								<form id="game_ganadiario_bet_suscription" action="game_ganadiario_show_bet.html" method="post">
								    <input id="playSuscription" name="play" type="hidden" >
								</form>
							</c:if>
							<div class="row_uno">
								<div class="descuento">${gdS30.formatDicount} <span><br>dscto</span></div>
							    <div <c:if test="${headerResult.status == 'ACT'}">class="contentRow ganadiario box-shadow-inset"</c:if> 
							    	 <c:if test="${headerResult.status == 'CIE'}">class="contentRowDisabled ganadiario box-shadow-inset"</c:if>
							    id="btn_mobile_combo30_sorteos" data-dom="${gdS30.draws}">
								   	<div class="primeraparteFGD">
										<h3>${gdS30.draws}</h3>
										<span class="h3FGD">Sorteos</span>
										<span class="tipo_sorteoF2">${gdS30.months} mes</span>
									</div>
									<div class="segundaparteF">
										<span class="costo_sorteoGD">Costo por jugada</span>
										<span class="costoEventoSorteoGD">${gdS30.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>		
							<div class="row_dos"></div>
							<div class="row_uno">
								<div class="descuento">${gdS90.formatDicount} <span><br>dscto</span></div>
								<div <c:if test="${headerResult.status == 'ACT'}">class="contentRow ganadiario box-shadow-inset"</c:if> 
							    	 <c:if test="${headerResult.status == 'CIE'}">class="contentRowDisabled ganadiario box-shadow-inset"</c:if>
							    id="btn_mobile_combo90_sorteos" data-dom="${gdS90.draws}">
								   	<div class="primeraparteFGD">
										<h3>${gdS90.draws}</h3>
										<span class="h3FGD">Sorteos</span>
										<span class="tipo_sorteoF2">${gdS90.months} meses</span>
									</div>
									<div class="segundaparteF">
										<span class="costo_sorteoGD">Costo por jugada</span>
										<span class="costoEventoSorteoGD">${gdS90.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>
							<div class="row_uno">
								<div class="descuento">${gdS180.formatDicount} <span><br>dscto</span></div>
							    <div <c:if test="${headerResult.status == 'ACT'}">class="contentRow ganadiario box-shadow-inset"</c:if> 
							    	 <c:if test="${headerResult.status == 'CIE'}">class="contentRowDisabled ganadiario box-shadow-inset"</c:if>
							    id="btn_mobile_combo180_sorteos" data-dom="${gdS180.draws}">
								   	<div class="primeraparteFGD">
										<h3>${gdS180.draws}</h3>
										<span class="h3FGD">Sorteos</span>
										<span class="tipo_sorteoF2">${gdS180.months} meses</span>
									</div>
									<div class="segundaparteF">
										<span class="costo_sorteoGD">Costo por jugada</span>
										<span class="costoEventoSorteoGD">${gdS180.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>
							<div class="row_dos"></div>
							<div class="row_uno">
								<div class="descuento">${gdS365.formatDicount} <span><br>dscto</span></div>
							    <div <c:if test="${headerResult.status == 'ACT'}">class="contentRow ganadiario box-shadow-inset"</c:if> 
							    	 <c:if test="${headerResult.status == 'CIE'}">class="contentRowDisabled ganadiario box-shadow-inset"</c:if>
							    id="btn_mobile_combo365_sorteos" data-dom="${gdS365.draws}">
								   	<div class="primeraparteFGD">
										<h3>${gdS365.draws}</h3>
										<span class="h3FGD">Sorteos</span>
										<span class="tipo_sorteoF2">${gdS365.months} meses</span>
									</div>
									<div class="segundaparteF">
										<span class="costo_sorteoGD">Costo por jugada</span>
										<span class="costoEventoSorteoGD">${gdS365.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>
						</div>							
						<div class="letras_pequenias" style="">*Las jugadas generadas serán enviadas con los resultados de cada sorteo a tu correo registrado o podrás revisarlas en tu Cuenta.</div>						
					</div>
					</c:if>

						<!--video live-->
						<%@ include file="live/video_live_banners.jspf" %>
					  	<!--video live-->

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
								<div class="last-date">N° ${drwid}</div>
							</div>
							<div class="results-games">
								<div id="results1" class="hide">${lastResult}</div>
								<div id="resultsview1" class="results-balls clearfix"></div>
							</div>
							<button type="button" id="btn_mobile_ver_resultados_ganadiario" class="btn btn-purple" onclick="datalayerResultados(this,'Informativo','Resultados del último sorteo');window.location.href='game_ganadiario_show_result.html';">Ver resultados anteriores</button>
						</div>
						<a href="libro-reclamaciones.html" target="_self">
							<img src="layer-view-image/client/book/libroGD.png" style="height: 49px;width: 84px;margin-top:40px;">
							</a>
					</div>
				</section>
			</div>
		</div>
	</div>

	<!--video live-->
    <%@ include file="live/video_live_popups.jspf" %>
    <!--video live-->

	<jsp:include page="../../include/footer.jsp" />

	<!--video live-->
    <script type="text/javascript" src="layer-view-script/game/ganadiario/live/hls.js"></script>
    <script type="text/javascript" src="layer-view-script/game/ganadiario/live/glide.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/ganadiario/live/video.js"></script>
    <!--video live-->

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

		$("#btn_mobile_juega_ganadiario").on("click",function(){
			datalayerBtnJuegatinka(this,'Button','Premio Diario');
		});

		$("#btn_mobile_combo30_sorteos , #btn_mobile_combo90_sorteos , #btn_mobile_combo180_sorteos , #btn_mobile_combo365_sorteos").on("click",function(){
			var textButton = $(this).attr('id').split("combo")[1];
			
			datalayerBtnJuegatinka(textButton,'Card','¡Combos Gana Diario! No te pierdas ni un sorteo');
		});

	</script>
	
	
	
	
</body>
</html>