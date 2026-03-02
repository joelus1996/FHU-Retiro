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
	<title>Kabala : Jugada</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Kabala móvil, realiza una jugada consecutiva" />
	

     <%

     String price = request.getParameter("price");

      %>

</head>
<body class="main-kabala">
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
						<a href="#" id="game_kabala_show_menu">
							<img src="layer-view-image/v2/logo-kabala.png" alt="resultados kabala">
						</a>
						<div class="game-desc min-desc">
							<h2>ELIGE TUS SORTEOS</h2>
						</div>

						<form action="game_kabala_add_consecutive.html" method="post" id="game_kabala_add_consecutive">

							<div class="boxes-lots boxes-no-padding">

							    <c:forEach var="item" items="${consecutiveKabalaList_KB}">

							    	<div class="box-lot">
							    		<div class="btn btn-transparent">
							    			<div class="box-checkbox">
							    				<input type="checkbox"
							    				<c:if test="${item.NUM_DRAW == 1}"> checked </c:if>
							    				name="consecutive" value="${item.NUM_DRAW}" id="consecutive_checkbox_${item.NUM_DRAW}" />
							    				<label for="consecutive_checkbox_${item.NUM_DRAW}">De <span>${item.NUM_DRAW}</span> 
							    				<c:if test="${item.NUM_DRAW == 1}" >
							    					sorteo 
							    				</c:if>
							    				<c:if test="${item.NUM_DRAW > 1}" >
							    					sorteos 
							    				</c:if>
							    				 (hasta <span>${item.DR_DATE}</span>)</label>
							    			</div>
							    		</div>
							    	</div>

							    </c:forEach>
<!-- 								<button type="button" id="addConsecutiveKabala" class="btn btn-red">CONTINUAR</button><br> -->
							    <button type="button" id="addConsecutiveKabala" class="btn btn-red float-bottom">CONTINUAR</button>

						    </div>

						</form>

					</div>
				</section>
			</div>
		</div>

	</div>

	<jsp:include page="../../include/footer.jsp" />
	
	
	

</body>
</html>