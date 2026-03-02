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
    		"name": "Jugar La Tinka",
    		"item": "https://m.latinka.com.pe/game_tinka_show_menu.html" 
  		}]
	}
	</script>
	<meta property="og:title" content="Juega Tinka Online | Resultados y Pozo de la Tinka">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content""=https://m.latinka.com.pe/game_tinka_show_menu.html">
	<meta property="og:description" content="¿Qué es La Tinka? Es un juego de lotería confiable que se sortea dos veces por semana, días en los cuales tienes la oportunidad de ganar un pozo millonario.">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-tinka.png?v=3">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<title>Juega Tinka Online | Resultados y Pozo de la Tinka</title>
	<meta name="description" content="¿Qué es La Tinka? Es un juego de lotería confiable que se sortea dos veces por semana, días en los cuales tienes la oportunidad de ganar un pozo millonario.">
	
	
	<link rel="shortcut icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png" type="image/x-icon">
    <link rel="apple-touch-icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
    <link rel="icon" type="image/png" sizes="192x192" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
</head>
<body class="main-tinka">
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Tinka" id="Zona">
	<input type="hidden" value id="SubZona">
	<h1 style="display: none;">La Tinka: ¿Cómo se juega la Tinka?</h1>
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/> <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<img src="layer-view-image/v2/logo-tinka.png?v=3" alt="tinka">
						<div class="game-desc">
							<h2>POZO MILLONARIO</h2>
						</div>
						<div class="game-price">
							<div class="current-price" id="tinka-pozo"><c:if test="${pozo != 'S/ 0'}"> ${pozo} </c:if></div>
							<!-- <div class="current-date"><c:if test="${pozo != 'S/ 0'}"> Cierra a las ${closeHour} del día ${closeDate} </c:if></div> -->
							<div class="current-date">
								<c:if test="${tinkaSale.status == 'ACT'}"> Cierra a las ${tinkaSale.closeHour} del día ${tinkaSale.closeDate} </c:if>
								<c:if test="${tinkaSale.status == 'CIE'}"> Abre a las ${tinkaSale.openHour} del día ${tinkaSale.openDate} </c:if>
							</div>
						</div>
						<form action="game_tinka_show_bet.html" method="post">
							    <input id="play" name="play" type="hidden" value="a">
							    <!-- 
							    <button <c:if test="${pozo == 'S/ 0'}"> disabled="disabled" </c:if>
								<c:if test="${pozo != 'S/ 0'}"> type="submit" </c:if>
								class="btn btn-red tinka" id="btn_mobile_juega_tinka">JUEGA TINKA</button>
							 	-->	
							 	<button <c:if test="${tinkaSale.status == 'CIE'}"> disabled="disabled" </c:if>
								<c:if test="${pozo != 'S/ 0'}"> type="submit" </c:if>
								class="btn btn-red tinka" id="btn_mobile_juega_tinka">JUEGA TINKA</button>
						</form>
					</div>
					<c:if test="${isTinkaSubscription == 'true'}">
					<div class="combos_tinkeros">
						<div class="titular_home_tinka">
							 <div class="bajada">¡COMBOS TINKEROS!</div>
							 <h2>NO TE PIERDAS NI UN SORTEO</h2>
						</div>
						<div class="row_four">
							<c:if test="${pozo != 'S/ 0'}">
								<form id="game_tinka_bet_suscription" action="game_tinka_show_bet.html" method="post">
								    <input id="playSuscription" name="play" type="hidden" >
								</form>
							</c:if>
							<div class="row_uno">
								<div class="descuento">${tkS08.formatDicount} <span><br>dscto</span></div>
<%-- 							    <div class="contentRow box-shadow-inset" id="extra_segunda" data-dom="${tkS08.draws}"> --%>
							    <div <c:if test="${tinkaSale.status == 'ACT'}">class="contentRow box-shadow-inset"</c:if> 
							    	 <c:if test="${tinkaSale.status == 'CIE'}">class="contentRowDisabled box-shadow-inset"</c:if> 
							    	 id="btn_mobile_combo8_sorteos" data-dom="${tkS08.draws}">
								   	<div class="primeraparteF" style="pointer-events: none;">
										<h3>${tkS08.draws}</h3>
										<span class="h3F">Sorteos</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="tipo_sorteoF">${tkS08.months} mes</span>
									</div>
									<div class="segundaparteF" style="pointer-events: none;">
										<span class="costo_sorteo">Costo por jugada</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="costoEventoSorteo">${tkS08.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>		
							<div class="row_dos"></div>
							<div class="row_uno">
								<div class="descuento">${tkS24.formatDicount} <span><br>dscto</span></div>
<%-- 							    <div class="contentRow box-shadow-inset" id="extra_tercera" data-dom="${tkS24.draws}"> --%>
 								<div <c:if test="${tinkaSale.status == 'ACT'}">class="contentRow box-shadow-inset"</c:if>
 									 <c:if test="${tinkaSale.status == 'CIE'}">class="contentRowDisabled box-shadow-inset"</c:if> 
 									 id="btn_mobile_combo24_sorteos" data-dom="${tkS24.draws}">
								   	<div class="primeraparteF" style="pointer-events: none;">
										<h3>${tkS24.draws}</h3>
										<span class="h3F">Sorteos</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="tipo_sorteoF">${tkS24.months} meses</span>
									</div>
									<div class="segundaparteF" style="pointer-events: none;">
										<span class="costo_sorteo">Costo por jugada</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="costoEventoSorteo">${tkS24.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>
							<div class="row_uno">
								<div class="descuento">${tkS48.formatDicount} <span><br>dscto</span></div>
<%-- 							    <div class="contentRow box-shadow-inset" id="extra_cuarta" data-dom="${tkS48.draws}"> --%>
							    <div <c:if test="${tinkaSale.status == 'ACT'}">class="contentRow box-shadow-inset"</c:if>
							    	 <c:if test="${tinkaSale.status == 'CIE'}">class="contentRowDisabled box-shadow-inset"</c:if> 
							    	 id="btn_mobile_combo48_sorteos" data-dom="${tkS48.draws}">
								   	<div class="primeraparteF" style="pointer-events: none;">
										<h3>${tkS48.draws}</h3>
										<span class="h3F">Sorteos</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="tipo_sorteoF">${tkS48.months} meses</span>
									</div>
									<div class="segundaparteF" style="pointer-events: none;">
										<span class="costo_sorteo">Costo por jugada</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="costoEventoSorteo">${tkS48.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>
							<div class="row_dos"></div>
							<div class="row_uno">
								<div class="descuento">${tkS96.formatDicount} <span><br>dscto</span></div>
							    <div <c:if test="${tinkaSale.status == 'ACT'}">class="contentRow box-shadow-inset"</c:if>
							    	 <c:if test="${tinkaSale.status == 'CIE'}">class="contentRowDisabled box-shadow-inset"</c:if>
							    	  id="btn_mobile_combo96_sorteos" data-dom="${tkS96.draws}">
								   	<div class="primeraparteF" style="pointer-events: none;">
										<h3>${tkS96.draws}</h3>
										<span class="h3F">Sorteos</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="tipo_sorteoF">${tkS96.months} meses</span>
									</div>
									<div class="segundaparteF" style="pointer-events: none;">
										<span class="costo_sorteo">Costo por jugada</span><c:if test="${tinkaSale.status == 'CIE'}"><br/></c:if>
										<span class="costoEventoSorteo">${tkS96.formatPricePerPlay}</span>				
									</div>
								</div>
							</div>
						</div>							
						<div class="letras_pequenias" style="">*Las jugadas generadas serán enviadas con los resultados de cada sorteo a tu correo registrado o podrás revisarlas en tu Cuenta.</div>
					</div>
					</c:if>
					<div class="main-game">
						<div class="last-result-tinka">
							<div class="top-results-games-tinka">
								<div class="last-text">Resultados del último sorteo</div>
								<div class="last-date">N° ${drwid}</div>
							</div>
							<div class="results-games">
								<div id="results1" data-game="tinka" class="hide">${lastResult}</div>
								<div id="resultsview1" class="results-balls clearfix"></div>
							</div>
							<div class="results-siosi">
								<div id="siosi1" data-game="tinka" class="hide">${lastSiosi}</div>								
								<div id="siosiview1" class="results-balls clearfix"></div>
							</div>
							<button type="button" id="btn_mobile_ver_resultados_anteriores" class="btn btn-green" onclick="datalayerResultados(this,'Informativo','Resultados del último sorteo');window.location.href='game_tinka_show_result.html';" style="margin-top: 1em;">Ver resultados anteriores</button>
						</div>
							<a href="libro-reclamaciones.html" target="_self">
								<img src="layer-view-image/client/book/linkbook.png" alt="tinka" style="height: 49px;width: 84px;">
							</a>						
					</div>

				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../../include/footer.jsp" />
   <script type="text/javascript" src="layer-view-script/funcionesTagging.js?v=12"></script>

	<script type="text/javascript">

		$(document).ready(function(){
			replacehtml('#results1', '#resultsview1', '-');
			if($('#siosi1').text()!=''){
				replacehtml('#siosi1', '#siosiview1', '-');
			}

			var pozo = $('#tinka-pozo').html();
			var new_pozo = pozo.replace(".", " ");
			$('#tinka-pozo').html(new_pozo);

			
			$(".contentRow").on("click",function(){
			
				var $this = $(this);
				var dataF = $this.attr("data-dom");
				$(".contentRow").removeClass("active");
				$this.addClass("active");
				try {
					$("#playSuscription").val(dataF);
					$("#game_tinka_bet_suscription").submit();
					
				} catch (e) {}
				
			});

		});

		$("#btn_mobile_juega_tinka").on("click",function(){
			datalayerBtnJuegatinka(this,'Button','Pozo Millonario');
		});

		$("#btn_mobile_combo8_sorteos , #btn_mobile_combo24_sorteos , #btn_mobile_combo48_sorteos , #btn_mobile_combo96_sorteos").on("click",function(){
			var textButton = $(this).attr('id').split("combo")[1];
			
			datalayerBtnJuegatinka(textButton,'Card','¡Combos Tinkeros! No te pierdas ni un sorteo');
		});
		
	</script>
	
	

</body>
</html>