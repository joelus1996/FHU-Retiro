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
	<title>La Tinka : Registro de nuevo cliente</title>
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
				 <form class="form_filter_movimientos">				         			           		
				                <div class="filter_movimientos" style="background-color: #ffff; position: absolute; margin-top: 7rem; padding: 0.9em 2.25em;">
				                	   <div class="sms_movimientos"> <p style="margin: 2px;">Filtra tu búsqueda en un rango de 30 días como máximo, hasta con dos años de antigüedad. </p></div>
				                	<div class="form-movimientos">
        								<div class="form_filter form__input-filtro" style="margin-right: 0px;">
            								<label for="filterfechainicio" >Desde</label>
            								<input type="text" id="filterfechainicio" name="fechainicio" maxlength="10" class="fecha-input" tabindex="15" readonly>
       			 						</div>
        								<div class="form_filter form__input-filtro" style="margin-right: 0px;">  
            								<label for="filterfechafin">Hasta</label>
            								<input type="text" id="filterfechafin" name="fechafin" maxlength="10" class="fecha-input" tabindex="15" readonly>
        								</div>
        								<button class="form_filter btn button_filter" type="submit" id="btsubmit">Buscar</button>
				                	</div>
								</div>
  					</form>					
					<div class="main-page">

						<div class="main-wallet">
							<div class="top-wallet">
								<div class="title-wallet">
									<h3>MIS MOVIMIENTOS</h3>
								</div>
								<h4>(Detalle)</h4>
							</div>
						</div>
					</div>
					<div class="main-page">
						<div class="main-wallet">
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
														var="item" varStatus="status" items="${client_balance_show_informationList}">
														<li class="single">
														<i></i>
														<button type="button" data-modal="#popup" data-date="${item.balanceDate}" data-bi="${item.balanceItem}" data-desc="${item.description}" class="btn btn-trans">
															<div>${item.description} <span class="desc-single"></span></div>
															<span class="date-year">${item.balanceDate}</span>
														</button>
														</li>
													</c:forEach>
												</c:when>
												<c:otherwise>
													<div>${listavacia}</div>																																															
												</c:otherwise>
											</c:choose>
												<c:set value="${fn:length(client_balance_show_informationList)}" var="rLen" />
										</ul>
									</div>
									<div> <p id="msg-data1" style="padding: 2px; font-weight: 600; font-size: 13.5px; display:block;">* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas". </p> </div>
									
									<!--Boton para ver más-->
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
														var="item" varStatus="status" items="${client_balance_show_informationListFilter}">
														
														<li class="single">
															<i></i>
															<button type="button" data-modal="#popup" data-date="${item.balanceDate}" data-bi="${item.balanceItem}" data-desc="${item.description}" class="btn btn-trans">
															<div>${item.description} <span class="desc-single"></span></div>
															<span class="date-year">${item.balanceDate}</span>
															</button>
														</li>
														
									
											</c:forEach> 
							
										<c:set var="conditionResult" value="${rowEndFilter lt r_List}" />
										<div> <p id="msg-data2" style="padding: 2px; font-weight: 600; font-size: 13.5px; display:block;">* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas". </p> </div>
																		
										<c:if test="${rowEndFilter lt r_List}">
										<button type="button" onclick="verMasFilter()" id="viewmore_filter" data-from="${rowBEGINF+pageSize}" data-to="${rowEndFilter+pageSize}" class="btn btn-white">VER MÁS</button>
										</c:if>	
													</c:when>
													<c:otherwise>
													<div>${listavacia}</div>
													<div> <p id="msg-data2" style="padding: 2px; font-weight: 600; font-size: 13.5px; display:block;">* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas". </p> </div>
										</c:otherwise>
													</c:choose>	
												</c:when>
															
												
												<c:otherwise>
													<div>${rangosuperadofechas}</div>
												<div> <p id="msg-data2" style="padding: 2px; font-weight: 600; font-size: 13.5px; display:block;">* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas". </p> </div>																						
												</c:otherwise>
													</c:choose>
												</c:when>
												
												<c:otherwise>
													<div>${fechasincorrectas}</div>
												<div> <p id="msg-data2" style="padding: 2px; font-weight: 600; font-size: 13.5px; display:block;">* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas". </p> </div>																					
												</c:otherwise>
												
												
												
											</c:choose>											
													
										</ul>
										
									</div>

								</div>					
								<!-- Fin lista filtrada -->								
							</div>
							<br><br><br>
							<div id="popup" class="overlay">
								<div class="popup popup-sm">
									<a class="close js-close-modal" href="#">&times;</a>
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

		/*OBTENER LA LISTA FILTRA*/
		 $('#btsubmit').click(function(){
            document.getElementById("listaOriginal").style.display = "none";
            
            var listaOriginal = document.getElementById("listaOriginal");
            while (listaOriginal.firstChild) {
                listaOriginal.removeChild(listaOriginal.firstChild);
            }
        	openLoader();
        	
        	var startdate = $("#filterfechainicio").val();
        	var enddate = $("#filterfechafin").val();

        	$.ajax({
        		type: "GET",
        		url: "./client_balance_show_information_filter.html?startdate=" + startdate + "&enddate=" + enddate,
        		beforeSend: function() {$('#btsubmit').prop('disabled', true);}
        	})
        	.done(function(res) {
        		var $res = $(res);
        	        $('#listaFiltrada').html($res.find("#listaFiltrada ul"));
        	        $('#listaFiltrada').show();
        	        //$('#viewmorevm').show(); 
        	})
        	.fail(function() {
        		console.log('error')
        	})
        	.always(function() {
        		closeLoader();
        		$('#btsubmit').prop('disabled', false);
        	});	
    	});
		
		/* LISTA FILTRADA - SE ACTIVA CUANDO EL TAMAÑO DE LA LISTA FILTRADA ES MAYOR A 15*/
		function verMasFilter() {
	    openLoader();
	    $('#msg-data2').css("display","none");
	    var startdate = $("#filterfechainicio").val();
	    var enddate = $("#filterfechafin").val();
	    var from = $("#viewmore_filter").data('from');
	    var to = $("#viewmore_filter").data('to');

	    var url = "./client_balance_show_information_filter.html?startdate=" + startdate + "&enddate=" + enddate;

	    if (from !== undefined && to !== undefined) {
	        url += "&from=" + from + "&to=" + to;
	    }

	    var jqxhr = $.ajax({
	        type: "GET",
	        url: url,
	    })
	    .done(function(res) {

	        var $res = $(res);

	        var $lastUl = $('#listaFiltrada ul').last();

	        $lastUl.find('#viewmore_filter').hide();
	        $lastUl.find('#msg-data2').css("display","none");
	        
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
		
		/*LISTA GENERAL - VER MAS*/
		$('#viewmore').click(function() {
			openLoader();
			var from = $(this).data('from');
			var to = $(this).data('to');
			$('#msg-data1').css("display","none");
			var jqxhr = $.ajax({
				type: "GET",
				url: "./client_balance_show_information.html?from=" + from + "&to=" + to,
			})
			.done(function(res) {
				var $res = $(res);
				$('#results').append($res.find("#results ul"));
				$('#msg-data1').css("display","none");
				if ($res.find("#viewmore").length) {
					$('#viewmore').data('from', $res.find("#viewmore").data('from')).data('to', $res.find("#viewmore").data('to'));
					$('#msg-data1').css("display","block");
				} else {
					$('#viewmore').hide();
					$('#msg-data1').css("display","block");
				}
			})
			.fail(function() {
				console.log('error')
			})
			.always(function() {
				closeLoader();
			});

		});

		/*Lista general - obtener el detalle*/
		$(document).delegate('#results li button', 'click', function(){
			var ico = $(this).siblings('i');
			$(ico).addClass('loading');
			
			var date = $(this).data('date');
			var desc = $(this).data('desc');
			var balanceItemData = $(this).data('bi');
			var jqxhr = $.ajax({
				type: "GET",
				url: "./client_balance_find_information.html?date=" + date + "&desc=" + desc+"&balanceItemData="+balanceItemData,
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
		
		/*Lista filtrada - obtener el detalle*/
		$(document).delegate('#listaFiltrada li button', 'click', function(){
				var ico = $(this).siblings('i');
				$(ico).addClass('loading');
				
				var date = $(this).data('date');
				var desc = $(this).data('desc');
				var balanceItemData = $(this).data('bi');
				
				var startdate = $("#filterfechainicio").val();
				
				if(startdate !== ""){
					url= "./client_balance_find_information.html?date=" + date + "&desc=" + desc+"&balanceItemData="+balanceItemData + "&startdate=" + startdate;
				}
				var jqxhr = $.ajax({
					type: "GET",
					url: url,
				})
				.done(function(res) {
					 var modalContent = $(res).find(".wrap-modal").html(); 
					    $('#popup .main-modal').html(modalContent);
					    openModal("#popup", "");
				})
				.fail(function() {
					console.log('error')
				})
				.always(function() {
					$(ico).removeClass('loading');
				});

		});
		
		/*INICIO*/
		$(document).ready(function(){
		    var $inputinicio = $('#filterfechainicio');
		    var $inputfin = $('#filterfechafin');
	 		
	 		// Asignar las fechas a los inputs de fecha
	        var today = new Date();
	        var dd = String(today.getDate()).padStart(2, '0');
	        var mm = String(today.getMonth() + 1).padStart(2, '0'); // Enero es 0!
	        var yyyy = today.getFullYear();

	        var formattedDateFin = dd + '/' + mm + '/' + yyyy; // Formato 'DD-MM-YYYY'

	        // Calcular la fecha de inicio (29 días antes)
	        var startDate = new Date();
	        startDate.setDate(startDate.getDate() - 29);
	        var ddInicio = String(startDate.getDate()).padStart(2, '0');
	        var mmInicio = String(startDate.getMonth() + 1).padStart(2, '0'); // Enero es 0!
	        var yyyyInicio = startDate.getFullYear();

	        var formattedDateInicio = ddInicio + '/' + mmInicio + '/' + yyyyInicio; // Formato 'DD-MM-YYYY'

	        $inputinicio.val(formattedDateInicio);
	        $inputfin.val(formattedDateFin);

		 		renderDateMovimientos();

		});
			
		var renderDateMovimientos = function () {
			
			var $inputinicio = $('#filterfechainicio');
		    var $inputfin = $('#filterfechafin');
		    
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

	</script>

</body>
</html>