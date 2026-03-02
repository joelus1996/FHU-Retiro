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
    		"name": "Jugar Kabala",
    		"item": "https://m.latinka.com.pe/game_kabala_show_menu.html" 
  		}]
	}
	</script>
	<meta property="og:title" content="Kábala: Juega con Kábala y Chau Chamba">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://m.latinka.com.pe/game_kabala_show_menu.html">
	<meta property="og:description" content="¿Qué es La Kábala? Es un juego de lotería electrónica en tiempo real más popular del Perú, el cual acumula pozos grandes que se sortean 3 veces por semana. ">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-kabala.png">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	    <title>Kábala: Juega con Kábala y Chau Chamba</title>
    <meta name='description' content="¿Qué es La Kábala? Es un juego de lotería electrónica en tiempo real más popular del Perú, el cual acumula pozos grandes que se sortean 3 veces por semana. " />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />

	<!--video live-->
    <link rel="stylesheet" href="layer-view-style/game/kabala/live/video.css" type="text/css">
    <!--video live-->
	
	
	<link rel="shortcut icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png" type="image/x-icon">
    <link rel="apple-touch-icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
    <link rel="icon" type="image/png" sizes="192x192" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
</head>
<body onload="newsKabala(<%=Constantes.epochTimeNewsKabala%>,<%= request.getAttribute("nowEpochKabala")%>);" class="main-kabala">
 	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" value="Loterías" id="TipoZona">
	<input type="hidden" value="Kábala" id="Zona">
	<input type="hidden" value id="SubZona">
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
							<div class="current-price" id="kabala-pozo">${pozo}</div>
<%-- 							<div class="current-date">Cierra a las ${closeDraw} del día ${closeDate1}</div> --%>
							<div class="current-date">
								<c:if test="${status == 'ACT'}"> Cierra a las ${closeHour} del día ${closeDate} </c:if>
								<c:if test="${status == 'CIE'}"> Abre a las ${openHour} del día ${openDate} </c:if>
							</div>
						</div>
						<form action="game_kabala_show_bet.html" method="post">
							    <input id="play" name="play" type="hidden" value="a">
							    <button <c:if test="${status == 'CIE'}"> disabled="disabled" </c:if>
							<c:if test="${pozoMillonario != 'S/. 0'}"> type="submit" </c:if>
							class="btn btn-red tinka" id="btn_mobile_juega_kabala">JUEGA KÁBALA</button>	
						</form>
						<c:if test="${isKabalaSubscription == 'true'}">
						<div class="combos_kabala">
							<div class="titular_home_kabala">
								 <div class="bajada">¡COMBOS KÁBALA!</div>
								 <h2>NO TE PIERDAS NI UN SORTEO</h2>
							</div>
							<div class="row_four">
								<c:if test="${pozoMillonario != 'S/. 0'}">
									<form id="game_kabala_bet_suscription" action="game_kabala_show_bet.html" method="post">
									    <input id="playSuscription" name="play" type="hidden" >
									</form>
								</c:if>
								<div class="row_uno">
									<div class="descuento-kabala">${kbS12.formatDicount} <span><br>dscto</span></div>
								    <div <c:if test="${status == 'ACT'}">class="contentRow kabala box-shadow-inset"</c:if> 
							    	 <c:if test="${status == 'CIE'}">class="contentRowDisabled kabala box-shadow-inset"</c:if>
								     id="btn_mobile_combo12_sorteos" data-dom="${kbS12.draws}">
									   	<div class="primeraparteF">
											<h3>${kbS12.draws}</h3>
											<span class="h3F">Sorteos</span>
											<span class="tipo_sorteoF">${kbS12.months} mes</span>
										</div>
										<div class="segundaparteF">
											<span class="costo_sorteo">Costo por jugada</span>
											<span class="costoEventoSorteo">${kbS12.formatPricePerPlay}</span>				
										</div>
									</div>
								</div>		
								<div class="row_dos"></div>
								<div class="row_uno">
									<div class="descuento-kabala">${kbS36.formatDicount} <span><br>dscto</span></div>
									<div <c:if test="${status == 'ACT'}">class="contentRow kabala box-shadow-inset"</c:if> 
							    	 <c:if test="${status == 'CIE'}">class="contentRowDisabled kabala box-shadow-inset"</c:if>
								    id="btn_mobile_combo36_sorteos" data-dom="${kbS36.draws}">
									   	<div class="primeraparteF">
											<h3>${kbS36.draws}</h3>
											<span class="h3F">Sorteos</span>
											<span class="tipo_sorteoF">${kbS36.months} meses</span>
										</div>
										<div class="segundaparteF">
											<span class="costo_sorteo">Costo por jugada</span>
											<span class="costoEventoSorteo">${kbS36.formatPricePerPlay}</span>				
										</div>
									</div>
								</div>
								<div class="row_uno">
									<div class="descuento-kabala">${kbS72.formatDicount} <span><br>dscto</span></div>
									<div <c:if test="${status == 'ACT'}">class="contentRow kabala box-shadow-inset"</c:if> 
							    	 <c:if test="${status == 'CIE'}">class="contentRowDisabled kabala box-shadow-inset"</c:if>
								    id="btn_mobile_combo72_sorteos" data-dom="${kbS72.draws}">
									   	<div class="primeraparteF">
											<h3>${kbS72.draws}</h3>
											<span class="h3F">Sorteos</span>
											<span class="tipo_sorteoF">${kbS72.months} meses</span>
										</div>
										<div class="segundaparteF">
											<span class="costo_sorteo">Costo por jugada</span>
											<span class="costoEventoSorteo">${kbS72.formatPricePerPlay}</span>				
										</div>
									</div>
								</div>
								<div class="row_dos"></div>
								<div class="row_uno">
									<div class="descuento-kabala">${kbS144.formatDicount} <span><br>dscto</span></div>
									<div <c:if test="${status == 'ACT'}">class="contentRow kabala box-shadow-inset"</c:if> 
							    	 <c:if test="${status == 'CIE'}">class="contentRowDisabled kabala box-shadow-inset"</c:if>
								    id="btn_mobile_combo144_sorteos" data-dom="${kbS144.draws}">
									   	<div class="primeraparteF">
											<h3>${kbS144.draws}</h3>
											<span class="h3F">Sorteos</span>
											<span class="tipo_sorteoF">${kbS144.months} meses</span>
										</div>
										<div class="segundaparteF">
											<span class="costo_sorteo">Costo por jugada</span>
											<span class="costoEventoSorteo">${kbS144.formatPricePerPlay}</span>				
										</div>
									</div>
								</div>
							</div>							
							<div class="letras_pequenias" style="">*Las jugadas generadas serán enviadas con los resultados de cada sorteo a tu correo registrado o podrás revisarlas en tu Cuenta.</div>
						</div>
						</c:if>
						<div class="game-price border-chch">
							<img src="layer-view-image/v2/logo-chauchamba.png" alt="kabala">
							<div class="game-price">
								<div class="current-price">S/ 5,000</div>
								<div class="current-desc">Mensuales por 20 años.</div>
								<div class="current-sub-desc">(Jugando un S/ 1.00 adicional)</div>
								</br>
								<form action="game_kabala_show_bet.html" method="post">
							    <input id="play" name="play" type="hidden" value="a">
							    <button <c:if test="${status == 'CIE'}"> disabled="disabled" </c:if>
								<c:if test="${pozoMillonario != 'S/. 0'}"> type="submit" </c:if>
								class="btn btn-red tinka" id="btn_mobile_juega_kabala">JUEGA KÁBALA + CHAU CHAMBA</button>	
							</form>
							</div>							
						</div>
						<br/>

						<!--video live-->
						<%@ include file="live/video_live_banners.jspf" %>
					  	<!--video live-->
						
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
							<button type="button" id="btn_mobile_ver_resultados_kabala" class="btn btn-orange-light" onclick="datalayerResultados(this,'Compra','Resultados del último sorteo');window.location.href='game_kabala_show_result.html';">Ver resultados anteriores</button>
						</div>
						<a href="libro-reclamaciones.html" target="_self">
							<img src="layer-view-image/client/book/linkbook.png" alt="tinka" style="height: 49px;width: 84px;margin-top:40px;">
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
    <script type="text/javascript" src="layer-view-script/game/kabala/live/hls.js"></script>
    <script type="text/javascript" src="layer-view-script/game/kabala/live/glide.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/kabala/live/video.js"></script>
    <!--video live-->

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

		$("#btn_mobile_juega_kabala").on("click",function(){
			datalayerBtnJuegatinka(this,'Button','Pozo Próximo Sorteo');
		});

		$("#btn_mobile_combo12_sorteos , #btn_mobile_combo36_sorteos , #btn_mobile_combo72_sorteos , #btn_mobile_combo144_sorteos").on("click",function(){
			var textButton = $(this).attr('id').split("combo")[1];
			
			datalayerBtnJuegatinka(textButton,'Card','¡Combos Kábala! No te pierdas ni un sorteo');
		});

	</script>
	
	

</body>
</html>