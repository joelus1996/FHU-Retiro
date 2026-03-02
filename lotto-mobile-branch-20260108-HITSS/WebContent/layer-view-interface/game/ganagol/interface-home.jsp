<!--interface-home-->
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
    		"name": "Jugar GanaGol",
    		"item": "https://m.latinka.com.pe/game_ganagol_show_menu.html" 
  		}]
	}
</script>
	<meta property="og:title" content="Juega Ganagol: Programas, Resultados y más">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://m.latinka.com.pe/game_ganagol_show_menu.html">
	<meta property="og:description" content="¿Qué es Ganagol? Es uno de los juegos de apuestas deportivas más populares de La Tinka, enfocado principalmente en los partidos de fútbol nacionales e internacionales.">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-ganagol.png">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	<title>Juega Ganagol: Programas, Resultados y más</title>
    <meta name='description' content="¿Qué es Ganagol? Es uno de los juegos de apuestas deportivas más populares de La Tinka, enfocado principalmente en los partidos de fútbol nacionales e internacionales." />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/game/ganagol/styles-ganagol.css?v=2" type="text/css" />	
	
	
	<link rel="shortcut icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png" type="image/x-icon">
    <link rel="apple-touch-icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
    <link rel="icon" type="image/png" sizes="192x192" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
</head>
<body class="main-ganagol">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<h1 style="display: none;">Ganagol: ¿Cómo se juega Ganagol?</h1>
	<input type="hidden" id="golazo200" value="${ganagolSale.status}"/>

	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">

		<jsp:include page="../../include/header.jsp" />

		<input type="hidden" value="Apuestas Deportivas" id="TipoZona">
		<input type="hidden" value="Gana Gol" id="Zona">
		<input type="hidden" value="" id="SubZona">
		
		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game padding1">
						<img src="layer-view-image/v2/logo-ganagol.png" alt="tinka" class="cropimg">
						<div class="game-desc golazo200">
							<c:if test="${ganagolSale.status == 'ACT'}">
					             <!--<h5>PROGRAMA N° ${headerGame.drwid}</h5>-->
					        </c:if>
					        <c:if test="${ganagolSale.status == 'LST'}">
					           <!--   <h5>PROGRAMA EN JUEGO N° ${headerGame.drawId2}</h5>-->
					        </c:if>
 					        <h2><text>POZO ACUMULADO</text></h2>
							<%-- c:if test="${pozo != 'S/ 0'}">
								<h5>Programa N° ${headerGame.drwid}</h5>
								<h2>POZO ACUMULADO</h2>
							</c:if --%>
					 		<%-- c:if test="${pozo == 'S/ 0'}">
							 	<!-- h2>POZO POR DEFINIR</h2 -->
							 	<h5>Programa en juego N° ${headerGame.drawId2}</h5>
							 	<h2>POZO ACUMULADO</h2>
						 	</c:if --%>
						</div>
						<div class="game-price">
							<c:if test="${ganagolSale.status == 'ACT' || ganagolSale.status == 'LST'}">
								<c:choose>
					                <c:when test="${ganagolSale.prize == 'POZO ACUMULADO POR DEFINIR'}">
					                	<div class="current-price">${ganagolSale.lastPrize}</div>
					                    <div class="current-date">Cerrado a las ${ganagolSale.lastCloseHour} del día ${ganagolSale.lastCloseDate}</div><br/>
					                    <div class="f_linea"></div>
					                    <h5>PRÓXIMO PROGRAMA N° ${headerGame.drwid}</h5>
					                    <div class="current-date">Cierra a las ${headerGame.closeHour}:${headerGame.closeMinute} del día ${headerGame.closeDate1}</div>
					                </c:when>
					                <c:otherwise>
					                <div class="current-price">${pozo}</div>					                	
					                	<div class="current-muted">* Si revienta el pozo, inicia en S/ 400,000 </div><br>
					                	<div class="contenedor">					                		
					                		<div class="text">
					                			<h4 style="font-weight:400">PROGRAMA ${headerGame.drwid}</h4>
					                			<div class="current-date" style="color: #ffec13; font-size: 13px; font-weight:400;margin-right: 15px;">Cierra a las ${headerGame.closeHour}:${headerGame.closeMinute} del día ${headerGame.closeDate1}</div>
					                		</div>
					                		<div class="background trans">
					                		 	<h4 style="opacity: 0">PROGRAMA ${headerGame.drwid}</h4>
					                			<div class="current-date" style="color: #ffec13; font-size: 13px; margin-right: 12px; opacity: 0;">Cierra a las ${headerGame.closeHour}:${headerGame.closeMinute} del día ${headerGame.closeDate1}</div>
					                		</div>	
					                	</div>
					                </c:otherwise>            
					            </c:choose>
							</c:if>
							<c:if test="${ganagolSale.status == 'CIE'}">
								<div class="current-price">${ganagolSale.lastPrize}</div>
								<div class="current-muted p-yellow" style="color: rgb(255 255 255 / 80%);">*Si revienta el pozo, inicia en S/ 400,000 </div><br>
								 <div class="golazo200-apertura">
									<h4>PRÓXIMO PROGRAMA ${headerGame.drwid}</h4>
									<div class="current-muted p-yellow" style="color: #000000;"><b>Abre a las ${ganagolSale.openHour} del dia ${ganagolSale.openDate}</b></div>
								</div>
							</c:if>
							<%-- c:if test="${pozo != 'S/ 0'}" >
								<div class="current-price">${pozo}</div>
								<div class="current-date">Cierra a las ${headerGame.closeHour}:${headerGame.closeMinute} del día ${headerGame.closeDate1}</div>
							</c:if --%>
							<%-- c:if test="${pozo == 'S/ 0'}" >
								<div class="current-price">${jackpot}</div>
								<div class="current-date">Cierra a las ${headerGame.closeHour2}:${headerGame.closeMinute2} del día ${headerGame.closeDate2}</div><br/>
								<h5>Programa N° ${headerGame.drwid}</h5>
								<div class="current-date">Cierra a las ${headerGame.closeHour}:${headerGame.closeMinute} del día ${headerGame.closeDate1}</div>
							</c:if --%>
						</div>
							
						<button type="button" class="btn btn-red float-bottom" play="a"
							<%-- c:if test="${pozo == 'S/ 0'}" > disabled="disabled" </c:if --%>
							<%-- c:if test="${pozo != 'S/ 0'}" > id="game_ganagol_show_bet" </c:if --%>
							<c:if test="${ganagolSale.status == 'CIE'}" > disabled="disabled" </c:if>
<%-- 						<c:if test="${ganagolSale.status == 'ACT' || ganagolSale.status == 'LST'}" > id="game_ganagol_show_bet" </c:if> --%>
							<c:if test="${ganagolSale.status == 'ACT' || ganagolSale.status == 'LST'}" > id="btn_mobile_marcar_jugada_ganagol" </c:if>
						>MARCA TU JUGADA</button>																																												
						<div class="game-golazo200">
							<img src="layer-view-image/v2/logo-golazo200.png"><br><br>
							<h3>ACIERTA EL RANGO DE GOLES</h3>
							<h3>Y SUMALE A TU POZO</h3><br>
							<h2>S/ 200,000</h2>
							<h6 style="color: #a2a9a3;font-size: 13px;margin-top: 10px;margin-bottom: 40px;">(Jugando S/ 1.00 adicional)</h6>								
						</div>
						
						<c:if test="${ganagolSale.status ne 'CIE' or ganagolSale.prize ne 'POZO ACUMULADO POR DEFINIR'}">
							<div class="last-result">
								 <div class="f_linea"></div>
		<!-- 						<button type="button" class="btn btn-red" play="a" -->
									<%-- c:if test="${pozo == 'S/ 0'}" > disabled="disabled" </c:if --%>
									<%-- c:if test="${pozo != 'S/ 0'}" > id="game_ganagol_show_bet" </c:if --%>
		<%-- 							<c:if test="${ganagolSale.status == 'CIE'}" > disabled="disabled" </c:if> --%>
		<%-- 						<c:if test="${ganagolSale.status == 'ACT' || ganagolSale.status == 'LST'}" > id="game_ganagol_show_bet" </c:if> --%>
		<%-- 							<c:if test="${ganagolSale.status == 'ACT' || ganagolSale.status == 'LST'}" > id="btn_mobile_marcar_jugada_ganagol" </c:if> --%>
		<!-- 							>MARCA TU JUGADA</button> -->
									
									<div class="top-results-games">
										<div class="last-text">Resultados del último programa</div>
										<div class="last-date">N° ${headerResult.drwid}</div>
									</div>
									<div class="results-games">
										<div class="resuls-leters"><span>${headerResult.result}</span><br><span>GOLAZO200 : ${headerResult.drAddonResult1}<span></div>
									</div>
									<button type="button" id="btn_mobile_ver_resultados_ganagol" class="btn btn-white text-green" onclick="datalayerResultados(this,'Informativo','Resultados del último programa');window.location.href='game_ganagol_show_result.html';" style="margin-top: 1em;">
									Ver resultados anteriores
									</button>
								</div><br>								
						</c:if>
						<div style="margin-bottom: 40px;">	
							<a href="libro-reclamaciones.html" target="_self">
							<img src="layer-view-image/client/book/linkbook.png" alt="tinka" style="height: 49px;width: 84px;margin-top:40px;">
							</a>
						</div>																															
					</div>								
				</section>								
			</div>
		</div>
		
		
	</div>

	<jsp:include page="../../include/footer.jsp" />

	<script type="text/javascript">
		
		$(document).ready(function(){

			// replacehtml2('#results1', '#resultsview1', '#resultsview2', '-');

		});

	</script>
	

</body>
</html>