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
	<meta http-equiv="Cache-control" content="no-cache">
	<meta http-equiv="Expires" content="-1">
	<title>La Tinka : Promo Te Apuesto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	
	
</head>
<body class="orange">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<div class="container">
		
		<!-- jsp:include page="../include/header.jsp" / -->
		
		<div class="content-wrap">
			<div class="content">
			<c:if test="${!empty clientId }">
				<section class="main-section">
					<div class="main-page">
						<div class="main-promo">
							<div class="top-wallet">
								<div class="title-promo">
									<h3>${promoDescription}</h3>
								</div>
								<h4>N&ordm; de jugadas participantes: ${promoCount}</h4>
							</div>
						</div>
					 </div>
					 <div class="top-promo">
							<div class="top-right-promo">
								<div class="promo-add">
								<!-- h3><label>&iexcl;TE LLEVAMOS A LA COPA A VER A PER&Uacute; CON TODO PAGADO!</label></h3 -->
								<h3><label>&iexcl;TE LLEVAMOS AL ESTADIO A VER EL <span>PER&Uacute; VS BRASIL</span>!</label></h3>
								<p class="p-white">Las jugadas realizadas por Internet que cumplen con las condiciones de la promoci&oacute;n participan directamente.<br/>Sigue aqu&iacute; la cantidad de jugadas participantes e inf&oacute;rmate de los premios y ganadores en:</p>
								<a href="${promoMessage}" target="_blank">${fn:replace(fn:replace(promoMessage,'https://',''),'http://','')}</a>
								</div>
							</div>
						</div>	
						<div class="main-wallet">
							<div class="ajax-loader"></div>
						<div class="main-page" id="billetera2-main-page-list">

	
										<div class="my-promo">
												<c:forEach var="item" varStatus="status" items="${client_promo_te_apuesto_balance_show_informationList}">
													<div class="field-data">
														<!-- button type="button" data-modal="#popup" data-date="${item.promDate}" data-desc="${item.description}" class="btn btn-trans" -->
														<div class="top-data">
															<h5>${item.description}: ${item.promCount} tickets</h5>
														</div>
															<div class="bottom-data">
															<c:choose>
																<c:when test="${item.status == 'DES'}">
																	<h5><b style="color:#b0b0b0;">${item.state} al ${item.promDate}</b></h5>
																</c:when>
																<c:when test="${item.status == 'ACT'}">
																	<h5><b style="color:#ffffff;">${item.state} al ${item.promDate}</b></h5>
																</c:when>
																<c:when test="${item.status == 'PEN'}">
																	<h5 style="color:#808080;">${item.state} al ${item.promDate}</h5>
																</c:when>
																<c:otherwise></c:otherwise>
															</c:choose>
															</div>
													</div>
												</c:forEach>
										</div>
	
								</div>
								<div id="popup" class="overlay">
									<div class="popup popup-sm">
										<a class="close js-close-modal" href="#">&times;</a>
										<div class="main-modal"></div>
									</div>
								</div>
							</div>
				</section>
				</c:if>
			</div>
		</div>
	<jsp:include page="../include/footer.jsp" />

	<script type="text/javascript">

		$('#viewmore').click(function() {

			openLoader();

			var from = $(this).data('from');
			var to = $(this).data('to');

			var jqxhr = $.ajax({
				type: "GET",
				url: "./client_balance_promo_te_apuesto_show_information.html?from=" + from + "&to=" + to
			})
			.done(function(res) {
				var $res = $(res);
				$('#results').append($res.find("#results ul"));
				if ($res.find("#viewmore").length) {
					$('#viewmore').data('from', $res.find("#viewmore").data('from')).data('to', $res.find("#viewmore").data('to'));
				} else {
					$('#viewmore').hide();
				}
			})
			.fail(function() {
				console.log('error')
			})
			.always(function() {
				closeLoader();
			});

		});

		$(document).delegate('#results li button', 'click', function(){
		// $('#results li button').click(function() {

			var ico = $(this).siblings('i');
			$(ico).addClass('loading');
			
			var date = $(this).data('date');
			var desc = $(this).data('desc');

			var jqxhr = $.ajax({
				type: "GET",
				url: "./client_balance_promo_te_apuesto_find_information.html?date=" + date + "&desc=" + desc,
			})
			.done(function(res) {
				var $res = $(res);
				$('#popup .main-modal').html($res.find(".wrap-modal"));
				openModal("#popup","");
			})
			.fail(function() {
				console.log('error')
			})
			.always(function() {
				$(ico).removeClass('loading');
			});

		});

	</script>
	
	
	

</body>
</html>