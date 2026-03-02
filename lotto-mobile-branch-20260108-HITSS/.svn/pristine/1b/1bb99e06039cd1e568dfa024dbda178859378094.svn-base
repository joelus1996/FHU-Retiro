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
	<title>La Tinka : Bono Te Apuesto</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	
</head>
<body class="orange">


	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

	<div class="container">
		
		<jsp:include page="../include/header.jsp" />
		
		<div class="content-wrap">
			<div class="content">
			<c:if test="${!empty clientId }">
				<section class="main-section">
					<div class="main-page" id="billetera2-main-page">
						
						<div class="main-wallet">
							<div class="top-wallet">
								<div class="title-wallet">
									<h2>MI MOVIMIENTO DE BONO</h2>
								</div>
								<!-- h4>(TE APUESTO)</h4 -->
								<br/>
								<h3>Bono Te Apuesto: ${bonoTeApuesto}</h3>
							</div>
						</div>
					 </div>
						<div class="main-wallet">
							<div class="ajax-loader"></div>
						<c:if test="${bonoClientStatus == 'Pendiente'}">
							
							<div class="body-move">
								<div class="top-move">
									<div class="buttons-move">
										<div class="button-move">
											<img src="layer-view-image/v2/stop.svg" />
											<div class="body-button-move">
	                                            <h4>${bonoLimit}</h4>
	                                            <p>Es tu monto total a apostar *</p>
                                        	</div>
										</div>
										<div class="white-space">
										</div>
										<div class="button-move">
											<img src="layer-view-image/v2/refresh.svg" />
	                                        <div class="body-button-move">
	                                            <h4>${bonoForPlay}</h4>
	                                            <p>pendiente por apostar.</p>
	                                            <p>Para liberar tu monto promocional **</p>
	                                        </div>
										</div>
									</div>
								</div>
								<div class="bot-move">
										<p>* Válido sólo para jugadas en TeApuesto.pe y con cuotas iguales o mayores a ${bonoMinOdd}</p>
		                                <p>** Tu plazo para liberar tu monto promocional es hasta el ${bonoLastDate}.</p>
		                        </div>
							</div>
						</c:if>
						<c:if test="${bonoClientStatus == 'Liquidado'}">
							<div class="body-move">
								<div class="top-move">
									<div class="buttons-move">
										<div class="button-move button-move-liquidado">
											<img src="layer-view-image/v2/check.svg" />
											<div class="body-button-move">
	                                            <h4>¡Liberaste tu monto promocional!</h4>
	                                            <c:if test="${!empty bonoAddedBalance || bonoAddedBalance != '' }">
	                                            	<h4 class="h4-inline">${bonoAddedBalance}</h4>                                            	
	                                            	<p class="p-inline">  se agregaron a tu saldo.</p>
	                                            </c:if>
                                        	</div>
										</div>
										<div class="white-space"></div>
										<div class="button-move button-move-liquidado">
											<div class="body-button-move" >
                                            <h4>Puedes liquidar</h4>
                                            <p>¡C&oacute;bralo en efectivo o ju&eacute;galo ya!</p>
                                        </div>
										</div>
									</div>
								</div>
								<div class="bot-move">
										<p>* Válido sólo para jugadas en TeApuesto.pe y con cuotas iguales o mayores a ${bonoMinOdd}</p>
		                                <p>** Tu plazo para liberar tu monto promocional es hasta el ${bonoLastDate}.</p>
		                        </div>
							</div>
						</c:if>
						<div class="main-page" id="billetera2-main-page-list">
							<c:set value="15" var="pageSize" />
	
								<div class="wrap-accordion" id="billetera2-wrap-accordion-list">
									<div class="custom-accordion">
	
										<div id="results">
											<ul>
												<c:choose>
													<c:when test="${empty param.from}">
														<c:set var="rowBEGIN" value="1" />
													</c:when>
													<c:otherwise>
														<c:set var="rowBEGIN" value="${param.from}" />
													</c:otherwise>
												</c:choose>
												<c:choose>
													<c:when test="${empty param.to}">
														<c:set var="rowEnd" value="${pageSize}" />
													</c:when>
													<c:otherwise>
														<c:set var="rowEnd" value="${param.to}" />
													</c:otherwise>
												</c:choose>
												<c:forEach begin="${rowBEGIN-1}" step="1" end="${rowEnd-1}"
													var="item" varStatus="status" items="${client_bonus_te_apuesto_balance_show_informationList}">
													<li class="single">
														<i></i>
														<button type="button" data-modal="#popup" data-date="${item.balanceDate}" data-desc="${item.description}" class="btn btn-trans">
															${item.description} <span class="desc-single"><span class="date-year">${item.balanceDate}</span></span>
														</button>
													</li>
												</c:forEach>
												<c:set value="${fn:length(client_bonus_te_apuesto_balance_show_informationList)}" var="rLen" />
	
												<c:choose>
													<c:when test="${rLen lt rowEnd}">
														<c:set var="rCurrEnd" value="${rLen}" />
													</c:when>
													<c:otherwise>
														<c:set var="rCurrEnd" value="${rowEnd}" />
													</c:otherwise>
												</c:choose>
											</ul>
										</div>
	
										<c:if test="${rowEnd lt rLen}">
	
											<button type="button" id="viewmore" data-from="${rowBEGIN+pageSize}" data-to="${rowEnd+pageSize}" class="btn btn-white">VER MÁS</button>
	
										</c:if>
	
									</div>
								</div>
								<div id="popup" class="overlay">
									<div class="popup popup-sm">
										<a class="close js-close-modal" href="#">&times;</a>
										<div class="main-modal"></div>
									</div>
								</div>
							</div>
						</div>
				</section>
				</c:if>
			</div>
		
		
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
				url: "./client_balance_bono_te_apuesto_show_information.html?from=" + from + "&to=" + to
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
				url: "./client_balance_bono_te_apuesto_find_information.html?date=" + date + "&desc=" + desc,
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