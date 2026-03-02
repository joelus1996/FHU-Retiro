<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="es" style="background: #fbe601;">
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
	<title>La Tinka : Lista de jugadas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
	
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
				<section class="main-section" style="background-color: #fbe601;">
				 <form class="form_jugadas">				         			           		
				                <div class="filter_jugadas" style="background-color: #ffff; position: absolute; margin-top: 7rem; padding: 0.9em 2.25em;">
				                	<div class="sms_jugadas"> 
				                		<p style="margin: 2px;">Filtra tu búsqueda en un rango de 30 días como máximo, hasta con dos años de antigüedad. </p>
				                	</div>
				                	<div class="form_filter-jugadas">
        								<div class="form_filter-j form__input-jugadas" style="margin-right: 0px;">
            								<label for="fecha_inicio" >Desde</label>
            								<input type="text" id="fecha_inicio" name="fechainicio" tabindex="14" maxlength="10" class="error" style="border-color: rgb(185, 74, 72);" data-validation-has-keyup-event="true" readonly>
       			 						</div>
        								<div class="form_filter-j form__input-jugadas" style="margin-right: 0px;">  
            								<label for="fecha_fin">Hasta</label>
            								<input type="text" id="fecha_fin" name="fechafin" maxlength="10"  class="fecha-input" tabindex="15" readonly>
        								</div>
        								<button class="form_filter-j btn button_jugadas" type="submit" id="btsubmi-jugadas">Buscar</button>
				                	</div>
								</div>
  					</form>
  					<div class="main-page">
  						<div class="main-wallet">
  							<div class="top-wallet">
								<div class="title-wallet">
									<h3>MIS JUGADAS</h3>
								</div>
								<h4>(Detalle)</h4>
							</div>
  						</div>
  					</div>
					<div class="main-page">

						<div class="main-wallet">

					    	<c:if test="${not empty alert}">
								<div align="center">
									<BR>
									<c:if test="${not empty alert2}">
										<span style="font-size: 11px;"><b>${alert}</b></span>
										<BR>
										<span style="font-size: 11px;">${alert2}</span>
									</c:if>
									<c:if test="${empty alert2}">
										<span style="color: red; font-size: 11px;"><b>${alert}</b></span>
									</c:if>
								</div>
							</c:if>

							<div class="wrap-accordion" style="margin-top: 13em;">
								<div id="listaOriginal" class="custom-accordion">
								
									<c:set value="15" var="pageSize" />

									<div id="results">
										<ul class="center-list">
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
											<c:choose>
												<c:when test="${empty listavacia}">
												
												<c:forEach begin="${rowBEGIN-1}" step="1" end="${rowEnd-1}"
													var="item" varStatus="status" items="${client_play_show_informationList}">
													<li class="single">
            											<i></i>
														<c:if test="${item.GTYPE eq 99}">
															<button type="button" data-modal="#popup" data-game="${item.GAMEID}" data-ticket="${item.GCODE}" data-canal="${item.SALESCHANNEL}" data-pidticket="${item.CT_PID_TICKET}" data-programa="${item.GPROGRAM}" data-cpn="${item.GCPN}" class="btn btn-trans">	
																<div>${item.GNAME} Ticket : <span>${item.GCODE}</span></div>
																<span class="desc-single">${item.GDATE}</span>
															</button>
														</c:if>
														<c:if test="${item.GTYPE ne 99}">
															<button type="button" data-modal="#popup" data-game="${item.GAMEID}" data-ticket="${item.GTICKET}" data-canal="${item.SALESCHANNEL}" data-pidticket="${item.CT_PID_TICKET}" data-programa="${item.GPROGRAM}" data-cpn="${item.GCPN}" class="btn btn-trans">
																<div>${item.GNAME} Ticket : <span>${item.GTICKET}</span></div>
																<span class="desc-single">${item.GDATE}</span>
															</button>	
														</c:if>
													</li>
													
												</c:forEach>
									
												</c:when>
												
											<c:otherwise>
											<div>${listavacia}</div>
											</c:otherwise>
											</c:choose>
											
											<c:set value="${fn:length(client_play_show_informationList)}" var="rLen" />

										</ul>
									</div>

								<!-- BOTON PARA VER MÁS ITEMS -->
									<div> <p id="msg-mov1" style="padding: 2px; font-weight: 600; font-size: 13.5px;">* El historial de Casino y Virtuales lo encontrarás en <a href="#" onclick="toJuegosVirtuales('casino')" style="color: #000;"><u>TeApuesto</u></a> </p> </div>
									<c:if test="${rowEnd lt rLen}">

										<button type="button" id="viewmore" data-from="${rowBEGIN+pageSize}" data-to="${rowEnd+pageSize}" class="btn btn-white">VER MÁS</button>

									</c:if>

								</div>
								
								<!-- Obtener la lista filtrada  -->
								
								<div class="custom-accordion" >
								
								<div id="listaFiltrada" style="display: none;">
								
								<!-- Boton Filter -->
									<c:set value="15" var="pageSize" />
										<ul class="center-list">
											<c:choose>
												<c:when test="${empty param.from}">
													
													<c:set var="rowBEGINF" value="1" />
												</c:when>
												<c:otherwise>
													<c:set var="rowBEGINF" value="${param.from}" />
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${empty param.to}">
													<c:set var="rowEndFilter" value="${pageSize}" />
												</c:when>
												<c:otherwise>
													<c:set var="rowEndFilter" value="${param.to}" />
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${empty fechasincorrectas}">
													<c:choose>
															<c:when test="${empty rangosuperadofechas}">
																<c:choose>
																	<c:when test="${empty listavacia}">
																		<c:forEach begin="${rowBEGINF-1}" step="1" end="${rowEndFilter-1}"
																		var="item" varStatus="status" items="${client_play_show_informationListFilter}">
																	
																	<li class="single">
						            										<i></i>
																			<c:if test="${item.GTYPE eq 99}">
																				<button type="button" data-modal="#popup" data-game="${item.GAMEID}" data-ticket="${item.GCODE}" data-canal="${item.SALESCHANNEL}" data-pidticket="${item.CT_PID_TICKET}" data-programa="${item.GPROGRAM}" data-cpn="${item.GCPN}" class="btn btn-trans">	
																				<div>${item.GNAME} Ticket : <span>${item.GCODE}</span></div>
																				<span class="desc-single">${item.GDATE}</span>
																				</button>
																			</c:if>
																			<c:if test="${item.GTYPE ne 99}">
																				<button type="button" data-modal="#popup" data-game="${item.GAMEID}" data-ticket="${item.GTICKET}" data-canal="${item.SALESCHANNEL}" data-pidticket="${item.CT_PID_TICKET}" data-programa="${item.GPROGRAM}" data-cpn="${item.GCPN}" class="btn btn-trans">
																				<div>${item.GNAME} Ticket : <span>${item.GTICKET}</span></div>
																				<span class="desc-single">${item.GDATE}</span>
																				</button>	
																			</c:if>
																		</li>
																		</c:forEach> 
											
																		<c:set var="conditionResult" value="${rowEndFilter lt r_List}" />
																		<div> <p id="msg-mov2" style="padding: 2px; font-weight: 600; font-size: 13.5px;">* El historial de Casino y Virtuales lo encontrarás en <a href="#" onclick="toJuegosVirtuales('casino')" style="color: #000;"><u>TeApuesto</u></a></p> </div>
																		<c:if test="${rowEndFilter lt r_List}">
																		<button type="button" onclick="verMasJugadasFiltradas()" id="viewmore_filter" data-from="${rowBEGINF+pageSize}" data-to="${rowEndFilter+pageSize}" class="btn btn-white">VER MÁS</button>
																		</c:if>	
																	</c:when>
																	
																	<c:otherwise>
																	<div>${listavacia}</div>
																		<div> <p id="msg-mov2" style="padding: 2px; font-weight: 600; font-size: 13.5px;">* El historial de Casino y Virtuales lo encontrarás en <a href="#" onclick="toJuegosVirtuales('casino')" style="color: #000;"><u>TeApuesto</u></a></p> </div>																								
																	</c:otherwise>
																</c:choose>	
															</c:when>																	
															<c:otherwise>
																<div>${rangosuperadofechas}</div>
																		<div> <p id="msg-mov2" style="padding: 2px; font-weight: 600; font-size: 13.5px;">* El historial de Casino y Virtuales lo encontrarás en <a href="#" onclick="toJuegosVirtuales('casino')" style="color: #000;"><u>TeApuesto</u></a></p> </div>																								
															</c:otherwise>
														</c:choose>
												</c:when>
												
												<c:otherwise>
													<div>${fechasincorrectas}</div>
													<div> <p id="msg-mov2" style="padding: 2px; font-weight: 600; font-size: 13.5px;">* El historial de Casino y Virtuales lo encontrarás en <a href="#" onclick="toJuegosVirtuales('casino')" style="color: #000;"><u>TeApuesto</u></a></p> </div>																								
												</c:otherwise>
												
												
												
											</c:choose>											
													
										</ul>
										
									</div>

								</div>
								<!-- Fin lista filtrada -->

							</div>
							<br><br><br>				
								<div id="popup" class="overlay">
									<div class="popup popup-sm" style="padding: 0px 0px;">
											<a class="close js-close-modal" href="#">&times;</a>									
										<div class="main-modal"></div>
									</div>
								</div>
								<div id="popup2" class="overlay">
									<div class="popup2 popup-sm2">									
											<a class="close js-close-modal2" href="#">&times;</a>									
										<div class="main-modal"></div>
									</div>
								</div>
						</div>
					</div>
				</section>
			</div>
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />
	<script type="text/javascript" src="layer-view-script/jquery.mobile-1.0.min.js"></script>
	<script type="text/javascript" src="layer-view-script/jquery.mask.js"></script>
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script> 
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>"></script>
	
	<script type="text/javascript">

		/*Boton para realizar el filtro*/
		$('#btsubmi-jugadas').click(function(){
            document.getElementById("listaOriginal").style.display = "none";
            
            var listaOriginal = document.getElementById("listaOriginal");
            while (listaOriginal.firstChild) {
                listaOriginal.removeChild(listaOriginal.firstChild);
            }
            
        	openLoader();

        	var startdate = $("#fecha_inicio").val();
        	var enddate = $("#fecha_fin").val();

        	$.ajax({
        		type: "GET",
        		url: "./client_play_show_information_filter.html?startdate=" + startdate + "&enddate=" + enddate,
        		beforeSend: function() {$('#btsubmi-jugadas').prop('disabled', true);}
        	})
        	.done(function(res) {
        		var $res = $(res);
        	        $('#listaFiltrada').html($res.find("#listaFiltrada ul"));
        	        $('#listaFiltrada').show();
        	})
        	.fail(function() {
        		console.log('error')
        	})
        	.always(function() {
        		closeLoader();
        		$('#btsubmi-jugadas').prop('disabled', false);
        	});	       	
    	});
		
		/*Se activa cuando el tamaño de la lista filtrada es mayor a 15*/
		function verMasJugadasFiltradas() {
		    openLoader();
		    $('#msg-mov2').css("display","none");
		    var startdate = $("#fecha_inicio").val();
		    var enddate = $("#fecha_fin").val();
		    var from = $("#viewmore_filter").data('from');
		    var to = $("#viewmore_filter").data('to');

		    var urls = "./client_play_show_information_filter.html?startdate=" + startdate + "&enddate=" + enddate;

		    if (from !== undefined && to !== undefined) {
		        urls += "&from=" + from + "&to=" + to;
		    }

		    var jqxhr = $.ajax({
		        type: "GET",
		        url: urls,
		    })
		    .done(function(res) {
		        var $res = $(res);
		        var $lastUl = $('#listaFiltrada ul').last();

		        $lastUl.find('#viewmore_filter').hide();
		        $lastUl.find('#msg-mov2').css("display","none");
		        var $newUl = $lastUl.clone();
		        
		        $newUl.html($res.find("#listaFiltrada ul").html());

		        $('#listaFiltrada').append($newUl);
		        if ($res.find("#viewmore_filter").length) {
		            $('#viewmore_filter').data('from', $res.find("#viewmore_filter").data('from')).data('to', $res.find("#viewmore_filter").data('to'));
		        } else {
		            $('#viewmore_filter').hide();
		        }
		    })
		    .fail(function() {
		        console.log('Error al cargar más resultados');
		    })
		    .always(function() {
		        closeLoader();
		    });
		}
		
		
		/*Se activa cuando el tamaño de lista obtenida es mayor a 15*/
		$('#viewmore').click(function() {
			openLoader();
			$('#msg-mov1').css("display","none");
			var from = $(this).data('from');
			var to = $(this).data('to');

			var jqxhr = $.ajax({
				type: "GET",
				url: "./client_play_show_information.html?from=" + from + "&to=" + to,
			})
			.done(function(res) {
				var $res = $(res);
				$('#results').append($res.find("#results ul"));
				$('#msg-mov1').css("display","none");
				if ($res.find("#viewmore").length) {
					$('#viewmore').data('from', $res.find("#viewmore").data('from')).data('to', $res.find("#viewmore").data('to'));
					$('#msg-mov1').css("display","block");
				} else {
					$('#viewmore').hide();
					$('#msg-mov1').css("display","block");
				}
				
			})
			.fail(function() {
				console.log('error')
			})
			.always(function() {
				closeLoader();
			});

		});
		
		// Ver el detalle de una jugada
		$(document).delegate('#results li button', 'click', function(){
		// $('#results li button').click(function() {

			var ico = $(this).siblings('i');
			var game = $(this).data('game');
			var ticket = $(this).data('ticket');
			var isweb = $(this).data('canal');
			var pid_ticket = $(this).data('pidticket');
			var programa = $(this).data('programa');
			var cpn = $(this).data('cpn');
			
			if(isweb == 'Web' || isweb == 'Web Invitado'){
				$(ico).addClass('loading');	
				if(game!=108){
					
					var jqxhr = $.ajax({
						type: "GET",
						url: "./client_play_find_information.html?gameId=" + game + "&ticket=" + ticket,
					})
					.done(function(res) {
						var $res = $(res);
						$('#popup .main-modal').html($res.find(".wrap-modal"));
						var GNAME = $.trim($(".GNAME").html());
						if(GNAME!="Kinelo"){
							$(".play-game-result").each(function() {
								$(this).html($(this).html().split(" ").join(" - "));
							});
						}
						openModal("#popup","");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});
					
				} else {					
					$.ajax({
						type: "GET",
						data: { 'ticket': ticket },
			            dataType: "json",
						url: "client_play_show_detail_teapuesto.html",
					})
					.done(function(res) {
						$('#popup2 .main-modal').html('<iframe src= "'+res.url+'" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%;  width: 99.5%; position: absolute; padding-top: 20px; left: 1px; right: 0px; bottom: 0px;"></iframe>');
						$('#popup2 ').addClass('opened');
						$('.popup-sm2').css("max-width", "70vh");
						$('.popup2').css("height", "70vh");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});
				}
			
			}else{
				//retail
				if(game===108){
					$.ajax({
					    url: "consultarDataTeApuestoGrecia.html",
					    method: 'GET',
					    data: {
					        programa: programa,
					        cpn: cpn
					    }
					})
					.done(function(response, textStatus, jqXHR) {
						
						$(ico).addClass('loading');	
					    var url = "./client_play_show_detail_teapuesto_grecia.html?gameId=" + game + "&ticket=" + ticket + "&programa=" + programa + "&cpn=" + cpn;
					    $('#popup2 .main-modal').html('<iframe src="' + url + '" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%; width: 99.5%; position: absolute; padding-top: 20px; left: 1px; right: 0px; bottom: 0px;"></iframe>');
					    $('#popup2').addClass('opened');
					    $('.popup-sm2').css("max-width", "70vh");
					    $('.popup2').css("height", "70vh");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
					    $(ico).removeClass('loading');
					});
					
				} else if(game===7 || game===10){ 
					
					if(pid_ticket == "") {
						$(ico).removeClass('loading');
						styleButton(ticket);
						return;
					}
					$(ico).addClass('loading');
					$.ajax({
						type: "GET",
						data: { 'ticket': pid_ticket },
			            dataType: "json",
						url: "client_play_show_detail_teapuesto.html",
					})
					.done(function(res) {
						$('#popup2 .main-modal').html('<iframe src= "'+res.url+'" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%;  width: 99.5%; position: absolute; padding-top: 20px; left: 1px; right: 0px; bottom: 0px;"></iframe>');
						$('#popup2 ').addClass('opened');
						$('.popup-sm2').css("max-width", "70vh");
						$('.popup2').css("height", "70vh");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});
				} else if(game===9 || game===8) {//tickets golden en lista general

					console.log('entra a tickets golden');
					console.log('ticket:' + cpn );
					if(cpn == "") {
						console.log('el id ticket es nulo');
						$(ico).removeClass('loading');
						return;
					}
					$.ajax({
					    type: "GET",
					    data: { 'ticket': cpn },
					    dataType: "json",
					    url: "consultaDetalleVirtuales.html",
					})
					.done(function(res) {
					    console.log('Entra a golden ok');
					    console.log('Respuesta del servidor:', res.status);
					    if (res.status !== "OK") {
					    	console.log('no da ok rpta');
					        $(ico).removeClass('loading');
					        return;
					    }
					    var url = "detalleVirtualesTicket.html?ticket=" + cpn;
					    $('#popup2 .main-modal').html('<iframe src="' + url + '" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%; width: 99.5%; position: absolute; padding-top: 20px; left: 1px; right: 0px; bottom: 0px;"></iframe>');
					    $('#popup2').addClass('opened');
					    $('.popup-sm2').css("max-width", "70vh");
					    $('.popup2').css("height", "70vh");
					})
					.fail(function(jqXHR, textStatus, errorThrown) {
					    console.log('Error en la solicitud AJAX');
					    console.log('Estado:', textStatus);
					    console.log('Error:', errorThrown);
					    console.log('Respuesta del servidor:', jqXHR.responseText);
					})
					.always(function() {
					    $(ico).removeClass('loading');
					});
										


				}else if(game!=108 || game!=7 || game!=10 || game!=9 || game!=8) {
					var jqxhr = $.ajax({
						type: "GET",
						url: "./client_play_find_information_retail.html?gameId=" + game + "&ticket=" + ticket,
					})
					.done(function(res) {
						var $res = $(res);
						$('#popup .main-modal').html($res.find(".wrap-modal"));
						var GNAME = $.trim($(".GNAME").html());
						if(GNAME!="Kinelo"){
							$(".play-game-result").each(function() {
								$(this).html($(this).html().split(" ").join(" - "));
							});
						}
						openModal("#popup","");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});
				}
			}
		});

		function openDialog(e){
	    	
		    $("#dialog_content").dialogModal({ top : '10%', type : 'modal', onCancelBut : function(event, el) {} });
		}
		
		$('.popup2 .js-close-modal2').click(function(event){
		  	event.preventDefault();
		  	closeModal(1);
		});
		
		/*Obtener el detalle para cada jugada de la lista filtrada*/
		$(document).delegate('#listaFiltrada li button', 'click', function(){

			var ico = $(this).siblings('i');
			var game = $(this).data('game');
			var ticket = $(this).data('ticket');
			var startdate = $("#fecha_inicio").val();
			var isweb = $(this).data('canal');
			var listaFiltrada = 'OK';
			var pid_ticket = $(this).data('pidticket');
			var programa = $(this).data('programa');
			var cpn = $(this).data('cpn');
			
			if(isweb == 'Web' || isweb == 'Web Invitado'){
				$(ico).addClass('loading');
				if(game!=108){
					
					var jqxhr = $.ajax({
						type: "GET",
						url: "./client_play_find_information.html?gameId=" + game + "&ticket=" + ticket + "&startdate=" + startdate + "&listaFiltrada=" + listaFiltrada,
					})
					.done(function(res) {
						var $res = $(res);
						$('#popup .main-modal').html($res.find(".wrap-modal"));
						var GNAME = $.trim($(".GNAME").html());
						if(GNAME!="Kinelo"){
							$(".play-game-result").each(function() {
								$(this).html($(this).html().split(" ").join(" - "));
							});
						}
						openModal("#popup","");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});
					
				} else {
					//te apuesto 
					$.ajax({
						type: "GET",
						data: { 'ticket': ticket },
			            dataType: "json",
						url: "client_play_show_detail_teapuesto.html",
					})
					.done(function(res) {
						//openDialog(res.url);
						$('#popup2 .main-modal').html('<iframe src= "'+res.url+'" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%;  width: 99.5%; position: absolute; padding-top: 20px; left: 0px; right: 0px; bottom: 0px;"></iframe>');
						$('#popup2 ').addClass('opened');
						$('.popup-sm2').css("max-width", "70vh");
						$('.popup2').css("height", "70vh");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});
					

				}
			}else{
				// lista filtrada
				if(game===108){
					/*window.open("/mandar url del ajax");*/
						$.ajax({
						    url: "consultarDataTeApuestoGrecia.html",
						    method: 'GET',
						    data: {
						        programa: programa,
						        cpn: cpn
						    }
						})
						.done(function(response, textStatus, jqXHR) {
							
							$(ico).addClass('loading');
						    var url ="./client_play_show_detail_teapuesto_grecia.html?gameId=" + game + "&ticket=" + ticket + "&programa=" + programa + "&cpn=" + cpn;
						    $('#popup2 .main-modal').html('<iframe src="' +url+'" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%;width: 99.5%; position: absolute; padding-top: 20px; left: 1px; right: 0px; bottom: 0px;"></iframe>');
						    $('#popup2').addClass('opened');
						    $('.popup-sm2').css("max-width", "70vh");
						    $('.popup2').css("height", "70vh");
						})
						.fail(function() {
							console.log('error')
						})
						.always(function() {
						    $(ico).removeClass('loading');
						});

				} else if(game===7 || game===10) {
					if(pid_ticket == "") {
						$(ico).removeClass('loading');
						styleButton(ticket);
						return;
					}
					$(ico).addClass('loading');
					$.ajax({
						type: "GET",
						data: { 'ticket': pid_ticket },
			            dataType: "json",
						url: "client_play_show_detail_teapuesto.html",
					})
					.done(function(res) {
						$('#popup2 .main-modal').html('<iframe src= "'+res.url+'" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%;  width: 99.5%; position: absolute; padding-top: 20px; left: 1px; right: 0px; bottom: 0px;"></iframe>');
						$('#popup2 ').addClass('opened');
						$('.popup-sm2').css("max-width", "80vh");
						$('.popup2').css("height", "70vh");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});
				}else if(game===9 || game===8) {//tickets golden en filtrada

					console.log('entra a tickets golden');
					console.log('ticket:' + cpn );
					if(cpn == "") {
						console.log('el id ticket es nulo');
						$(ico).removeClass('loading');
						return;
					}
					$.ajax({
					    type: "GET",
					    data: { 'ticket': cpn },
					    dataType: "json",
					    url: "consultaDetalleVirtuales.html",
					})
					.done(function(res) {
					    console.log('Entra a golden ok');
					    console.log('Respuesta del servidor:', res.status);
					    if (res.status !== "OK") {
					    	console.log('no da ok rpta');
					        $(ico).removeClass('loading');
					        return;
					    }
					    var url = "detalleVirtualesTicket.html?ticket=" + cpn;
					    $('#popup2 .main-modal').html('<iframe src="' + url + '" frameborder="0" style="overflow: hidden; overflow-x: hidden; overflow-y: hidden; height: 100%; width: 99.5%; position: absolute; padding-top: 20px; left: 1px; right: 0px; bottom: 0px;"></iframe>');
					    $('#popup2').addClass('opened');
					    $('.popup-sm2').css("max-width", "70vh");
					    $('.popup2').css("height", "70vh");
					})
					.fail(function(jqXHR, textStatus, errorThrown) {
					    console.log('Error en la solicitud AJAX');
					    console.log('Estado:', textStatus);
					    console.log('Error:', errorThrown);
					    console.log('Respuesta del servidor:', jqXHR.responseText);
					})
					.always(function() {
					    $(ico).removeClass('loading');
					});


				} else if(game!=108 || game!=7 || game!=10 || game!=9 || game!=8){
					var jqxhr = $.ajax({
						type: "GET",
						url: "./client_play_find_information_retail.html?gameId=" + game + "&ticket=" + ticket + "&startdate=" + startdate + "&isweb=" + isweb,
					})
					.done(function(res) {
						var $res = $(res);
						$('#popup .main-modal').html($res.find(".wrap-modal"));
						var GNAME = $.trim($(".GNAME").html());
						if(GNAME!="Kinelo"){
							$(".play-game-result").each(function() {
								$(this).html($(this).html().split(" ").join(" - "));
							});
						}
						openModal("#popup","");
					})
					.fail(function() {
						console.log('error')
					})
					.always(function() {
						$(ico).removeClass('loading');
					});	
				}
			}
		});
		
		function openPopup(content) {
		    // Mostrar el contenido del popup en un contenedor existente en tu página
		    $('#popupContainer').html(content);
		    $('#popupContainer').fadeIn(); // Mostrar el contenedor del popup
		}
		
		
		/*INICIO*/
		$(document).ready(function(){
	 		var $inputinicio = $('#fecha_inicio');
	 		var $inputfin = $('#fecha_fin');
	 		
	 		// Asignar las fechas a los inputs de fecha
	        var today = new Date();
	        var dd = String(today.getDate()).padStart(2, '0');
	        var mm = String(today.getMonth() + 1).padStart(2, '0'); // Enero es 0!
	        var yyyy = today.getFullYear();

	        var formattedDateFin = dd + '/' + mm + '/' + yyyy; // Formato 'DD-MM-YYYY'

	        // Calcular la fecha de inicio (30 días antes)
	        var startDate = new Date();
	        startDate.setDate(startDate.getDate() - 29);
	        var ddInicio = String(startDate.getDate()).padStart(2, '0');
	        var mmInicio = String(startDate.getMonth() + 1).padStart(2, '0'); // Enero es 0!
	        var yyyyInicio = startDate.getFullYear();

	        var formattedDateInicio = ddInicio + '/' + mmInicio + '/' + yyyyInicio; // Formato 'DD-MM-YYYY'

	        $inputinicio.val(formattedDateInicio);
	        $inputfin.val(formattedDateFin);

				renderDateJugadas();

		});
				
		var renderDateJugadas = function () {
			
			var $inputinicio = $('#fecha_inicio');
	 		var $inputfin = $('#fecha_fin');
	 		
		    var maxDate = new Date();
		    var minDate = new Date();
		    minDate.setFullYear(maxDate.getFullYear() - 2);

		    var isUpdating = false; //Evitar recursión infinita

		    function formatDate(date) {
		        return date.toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' });
		    }

		    function calculateEndDate(startDate) {
		        var thirtyDaysLater = new Date(startDate);
		        thirtyDaysLater.setDate(startDate.getDate() + 29); // Sumamos 29 días al día de inicio (inclusivo)
		        return thirtyDaysLater;
		    }

		    function calculateStartDate(endDate) {
		        var thirtyDaysBefore = new Date(endDate);
		        thirtyDaysBefore.setDate(endDate.getDate() - 29); // Restar 29 días al día de fin (inclusivo)
		        return thirtyDaysBefore;
		    }

		    // Actualiza fecha fin cuando seleccionas fecha de inicio
		    function updateEndDate(startDate) {
		        var endDate = calculateEndDate(startDate);
		        if (endDate > maxDate) {
		            $inputfin.datepicker('setDate', maxDate); // Establece la fecha fin como la fecha actual
		            $inputfin.val(formatDate(maxDate)); // Muestra la fecha actual en el input
		        } else {
		            $inputfin.datepicker('setDate', endDate); // Establece la fecha fin calculada
		            $inputfin.val(formatDate(endDate)); // Muestra la fecha calculada en el input
		        }

		        if (!isUpdating) {
		            isUpdating = true;
		            $inputinicio.datepicker('setDate', startDate);
		            $inputinicio.val(formatDate(startDate));
		            isUpdating = false;
		        }
		    }

		    //Actualizar fecha de inicio cuando seleccionas fecha fin
		    function updateStartDate(endDate) {
		    	
		    	// Obtener la fecha de inicio desde el input #fecha_inicio
		        var startDate = new Date($inputinicio.val().split('/').reverse().join('-'));
		        
		        // Calcular la diferencia de días entre las fechas de inicio y fin
		        var diffTime = Math.abs(endDate - startDate);
		        var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)); // Convertir la diferencia a días
		        
		        console.log("diffTime: " + diffTime);
		        console.log("diffDays: " + diffDays);
		    	
		    	if(diffDays > 30){
		            var startDate = calculateStartDate(endDate);
		            if (!isUpdating) {
		                isUpdating = true;
		                $inputinicio.datepicker('setDate', startDate);
		                $inputinicio.val(formatDate(startDate));
		                isUpdating = false;
		            }
		    	}

		    }

		    function initializeDatePicker(element, isStartDate) {
		        element.datepicker({
		            language: 'es-ES',
		            autoHide: true,
		            format: 'dd/mm/yyyy',
		            startDate: minDate,
		            endDate: maxDate,
		            autoclose: true,
		            startView: 'days',
		            minView: 'days'
		        }).on('pick.datepicker', function (e) {
		            e.preventDefault();
		            var selectedDate = e.date;
		            element.val(formatDate(selectedDate));         
		            isStartDate ? updateEndDate(selectedDate) : updateStartDate(selectedDate);
		        });
		    }

		    initializeDatePicker($inputinicio, true);
		    initializeDatePicker($inputfin, false);

		};

		function styleButton(ticket) {
			$('button.btn-trans[data-ticket="'+ticket+'"]').css({
		        "background-color": "rgba(255, 255, 255, 0.4)",
		        "color": "#07663a",
		        "box-shadow": "none"
		    });
		}
				
		/*topOffset : 0, onLoad : function(el, current) {
    	$.ajax({url : e}).done(function(content){
		el.find('.dialogModal_content').html(content);
		});
	},*/
	</script>
	<div id="dialog_content" class="dialog_content" style="display:none">
		<div class="dialogModal_header">Boleto Te Apuesto</div>
		<div class="dialogModal_content">
		</div>
		<div class="dialogModal_footer">
			<button type="button" class="btn btn-default" data-dialogmodal-but="cancel">Cerrar</button>
		</div>
	</div>
	
	
	
</body>
</html>