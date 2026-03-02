<!--interface-bet-->
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
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	<title>Ganagol: Juega con nuestros programas y gana el pozo millonario</title>	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="description" content="Juega Ganagol en línea de forma sencilla y segura. Compra Ganagol en nuestra plataforma de forma totalmente online. ¡Entra ahora y empieza a ganar!" />
	
	<!-- Tagging GTM eventos -->
	<script type="text/javascript" src="layer-view-script/funcionesTaggingGanagol.js"></script>
	
	<link rel="stylesheet" href="layer-view-style/game/ganagol/styles-ganagol.css?v=1" type="text/css" />
	
</head>
<body class="main-ganagol">

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<input type="hidden" id="ganagolJugadas" value="${ganagolJugadas}"/>
	<input type="hidden" id="ganagolOvercomeJugadas" value="${ganagolOvercomeJugadas}"/>
	<input type="hidden" id="ganagolOvercomeJugada2" value="${check200}"/>
	<div class="container black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">

	<input type="hidden" value="Apuestas Deportivas" id="TipoZona">
	<input type="hidden" value="Gana Gol" id="Zona">
	<input type="hidden" value="" id="SubZona">
		
		<jsp:include page="../../include/header.jsp" />

		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-game padding2">
						<a href="#" id="game_ganagol_show_menu">
							<img src="layer-view-image/v2/logo-ganagol.png" alt="tinka" class="cropimg">
						</a>
						<div class="game-desc">
							<h5>PROGRAMA ${headerGame.drwid}</h5>						
						</div>
						<!-- post para el submit -->
						<form id="game_ganagol_add_bet" action="game_ganagol_add_bet.html" method="post">
						<div class="program-list">
							<!-- en caso el partido este suspendido agregar la clase "suspendido" a f_item -->
							<c:forEach var="item" items="${resultListGanagol}">
								
								<div class="program-match item-match f_item" id="item_${item.drawpk.item}" data-number="${item.drawpk.item}.">								    
									<div class="program-match">
										<div class="desc-program">
											<div class="current-match">
												<!-- Backend EB 20171121 -->
												<span id="title-match">${item.di_cup_name}</span> <!-- Backend a las variables por favor  -->
											</div>
											<!-- <div class="current-league">
												<span>${torneo}</span>
											</div> -->
											<!-- Backend a la condicional por favor  "c:if" -->
											<!-- Backend EB 20171121 -->
											<c:if test="${not empty item.di_time_message}">
												<div class="current-league">
													<span>${item.di_time_message}</span>
												</div>
											</c:if>	
										</div>
										
										<div class="teams-match">
											<div class="table">
												<div class="left-match">
													<div class="team-match">${item.localName}</div>
												</div>
												<div class="center-match">
													<div class="team-match">-</div>
												</div>
												<div class="right-match">
													<div class="team-match">${item.visitorName}</div>
												</div>
											</div>
										</div>
										
										<div class="f_form">
											<!-- >form action="" method="post" -->
												<div class="body-make">
													<div class="box-play f_inline">
														<div class="box-checkbox">
															<input type="checkbox" name="bet_${item.drawpk.item}" id="bet_${item.drawpk.item}_l" value="L" class="valueDrop_L"/>
															<label for="bet_${item.drawpk.item}_l">L</label>
														</div>
													</div>
													<div class="box-play f_inline">
														<div class="box-checkbox">
															<input type="checkbox" name="bet_${item.drawpk.item}" id="bet_${item.drawpk.item}_e" value="E" class="valueDrop_E"/>
															<label for="bet_${item.drawpk.item}_e">E</label>
														</div>
													</div>
													<div class="box-play f_inline">
														<div class="box-checkbox">
															<input type="checkbox" name="bet_${item.drawpk.item}" id="bet_${item.drawpk.item}_v" value="V" class="valueDrop_V"/>
															<label for="bet_${item.drawpk.item}_v">V</label>
														</div>
													</div>
												</div>
											<!-- >/form-->
											<!-- requiere backend - pendiente -->
											<div style="display:none" class="f_suspendido">
												Suspendido <!-- L4 - E2 - V4 -->
											</div>	
										</div>
									</div>	
								
							

								
									<div class="program-bet">
									<span data="<c:choose>
									    		<c:when test='${item.drawpk.item==1}'>${playGanagolList.id_1}</c:when>
											    <c:when test='${item.drawpk.item==2}'>${playGanagolList.id_2}</c:when>
											    <c:when test='${item.drawpk.item==3}'>${playGanagolList.id_3}</c:when>
											    <c:when test='${item.drawpk.item==4}'>${playGanagolList.id_4}</c:when>
											    <c:when test='${item.drawpk.item==5}'>${playGanagolList.id_5}</c:when>
											    <c:when test='${item.drawpk.item==6}'>${playGanagolList.id_6}</c:when>
											    <c:when test='${item.drawpk.item==7}'>${playGanagolList.id_7}</c:when>
											    <c:when test='${item.drawpk.item==8}'>${playGanagolList.id_8}</c:when>
											    <c:when test='${item.drawpk.item==9}'>${playGanagolList.id_9}</c:when>
											    <c:when test='${item.drawpk.item==10}'>${playGanagolList.id_10}</c:when>
											    <c:when test='${item.drawpk.item==11}'>${playGanagolList.id_11}</c:when>
											    <c:when test='${item.drawpk.item==12}'>${playGanagolList.id_12}</c:when>
											    <c:when test='${item.drawpk.item==13}'>${playGanagolList.id_13}</c:when>
											    <c:when test='${item.drawpk.item==14}'>${playGanagolList.id_14}</c:when>											    											  											  			
										</c:choose>">
										 </span>  
									</div>
								</div>
							</c:forEach>							
							<div class="game-des-cgolazo200">
								<h4>¡Elige un rango de goles, aciértalo</h4>
								<h4>y sumarás S/200,000 a tu pozo!</h4>
							</div><br>
							<img src="layer-view-image/v2/logo-golazo200.png" style="width: 104px; height: 73px">
							<br>
							<div style="padding-bottom: 14px;"><span style="color: #000;font-size: 14px; ">Opcional: S/ 1.00 adicional</span></div>
							
							<div class="f_form" style="margin:0px;">
											<!-- >form action="" method="post" -->
												<div class="body-make" style="text-align: center; font-size:14px"><!-- 1 -->
														<div class="box-play f_inline golazo200_seccion">
															<div class="box-checkbox golazo200">
																<c:if test="${check200 == '08'}">	
																	<input type="checkbox" name="bet_15" id="bet_15G" value="08" checked	class="valueDrop_L"/>
																</c:if>
																<c:if test="${check200 ne '08'}">	
																	<input type="checkbox" name="bet_15" id="bet_15G" value="08" 																																																																																													
																	class="valueDrop_L"/>
																</c:if>															
																<label for="bet_15G">0-8</label>
															</div>
														</div>
														<div class="box-play f_inline golazo200_seccion">
															<div class="box-checkbox golazo200">
																<c:if test="${check200 == '915'}">
																	<input type="checkbox" name="bet_15" id="bet_16G" value="915" checked class="valueDrop_L"/>
																</c:if>
																<c:if test="${check200 ne '915'}">
																	<input type="checkbox" name="bet_15" id="bet_16G" value="915" class="valueDrop_L"/>
																</c:if>
																<label for="bet_16G">9-15</label>
															</div>
														</div>
														<div class="box-play f_inline golazo200_seccion">
															<div class="box-checkbox golazo200">
																<c:if test="${check200 == '1620'}">
																	<input type="checkbox" name="bet_15" id="bet_17G" value="1620" checked class="valueDrop_L"/>
																</c:if>
																<c:if test="${check200 ne '1620'}">
																	<input type="checkbox" name="bet_15" id="bet_17G" value="1620" class="valueDrop_L"/>
																</c:if>
																<label for="bet_17G">16-20</label>
															</div>
														</div>
														
														<div class="box-play f_inline golazo200_seccion">
															<div class="box-checkbox golazo200">
																<c:if test="${check200 == '2125'}">
																	<input type="checkbox" name="bet_15" id="bet_18G" value="2125" checked class="valueDrop_L"/>
																</c:if>
																<c:if test="${check200 ne '2125'}">
																	<input type="checkbox" name="bet_15" id="bet_18G" value="2125" class="valueDrop_L"/>
																</c:if>
																<label for="bet_18G">21-25</label>
															</div>
														</div>
														
														<div class="box-play f_inline golazo200_seccion">
																<div class="box-checkbox golazo200">
																<c:if test="${check200 == '2630'}">
																	<input type="checkbox" name="bet_15" id="bet_19G" value="2630" checked class="valueDrop_L"/>
																</c:if>
																<c:if test="${check200 ne '2630'}">
																	<input type="checkbox" name="bet_15" id="bet_19G" value="2630" class="valueDrop_L"/>
																</c:if>
																<label for="bet_19G">26-30</label>
															</div>
														</div>
													</div>
													<div class="body-make" style="text-align: center; font-size:14px"><!-- 2 -->
													
													<div class="box-play f_inline golazo200_seccion">
														<div class="box-checkbox golazo200">
															<c:if test="${check200 == '3135'}">
																<input type="checkbox" name="bet_15" id="bet_20G" value="3135" checked class="valueDrop_L"/>
															</c:if>
															<c:if test="${check200 ne '3135'}">
																<input type="checkbox" name="bet_15" id="bet_20G" value="3135" class="valueDrop_L"/>
															</c:if>
															<label for="bet_20G">31-35</label>
														</div>
													</div>
													<div class="box-play f_inline golazo200_seccion">
														<div class="box-checkbox golazo200">
															<c:if test="${check200 == '3640'}">
																<input type="checkbox" name="bet_15" id="bet_21G" value="3640" checked class="valueDrop_L"/>
															</c:if>
															<c:if test="${check200 ne '3640'}">
																<input type="checkbox" name="bet_15" id="bet_21G" value="3640" class="valueDrop_L"/>
															</c:if>
															<label for="bet_21G">36-40</label>
														</div>
													</div>
													<div class="box-play f_inline golazo200_seccion">
														<div class="box-checkbox golazo200">
															<c:if test="${check200 == '4143'}">
																<input type="checkbox" name="bet_15" id="bet_22G" value="4143" checked class="valueDrop_L"/>
															</c:if>
																<c:if test="${check200 ne '4143'}">
																<input type="checkbox" name="bet_15" id="bet_22G" value="4143" class="valueDrop_L"/>
															</c:if>
															<label for="bet_22G">41-43</label>
														</div>
													</div>
													<div class="box-play f_inline golazo200_seccion">
														<div class="box-checkbox golazo200">
															<c:if test="${check200 == '4446'}">
																<input type="checkbox" name="bet_15" id="bet_23G" value="4445" checked class="valueDrop_L"/>
															</c:if>
															<c:if test="${check200 ne '4446'}">
																<input type="checkbox" name="bet_15" id="bet_23G" value="4445" class="valueDrop_L"/>
															</c:if>		
															<label for="bet_23G">44-46</label>
														</div>
													</div>
													<div class="box-play f_inline golazo200_seccion">
														<div class="box-checkbox golazo200">
															<c:if test="${check200 == '47'}">
																<input type="checkbox" name="bet_15" id="bet_24G" value="47" checked class="valueDrop_L"/>
															</c:if>
															<c:if test="${check200 ne'47'}">
																<input type="checkbox" name="bet_15" id="bet_24G" value="47" class="valueDrop_L"/>
															</c:if>			
															<label for="bet_24G">47-a más</label>
														</div>
													</div>
													
												</div>
											<!-- >/form-->
											<!-- requiere backend - pendiente -->
											<div style="display:none" class="f_suspendido">
												Suspendido <!-- L4 - E2 - V4 -->
											</div>	
									<div class="program-bet">
									<span data="<c:choose>
									    		
											    <c:when test='bet_15 == 15'>08</c:when>												  			
										</c:choose>">
										 </span>  
									</div>		
											
							</div>

						</div> <!-- cierre de las jugadas -->
						</form>
						<div class="game-actions">
							<button id="f_azar" next="" class="btn btn-yellow">AL AZAR</button>
							<button id="f_clean" next="" class="btn btn-yellow">LIMPIAR</button>
							<br>
						</div>
						
						<!-- nsoe si ces necesario meter backend aqui -->
						<!-- <button type="button" id="f_enviar" class="btn btn-red float-bottom">AGREGAR JUGADA</button> -->
<!-- 						<button type="button" id="btn_mobile_agregar_jugada_ganagol" class="btn btn-red">SIGUIENTE</button><br><br><br> -->
						<button type="button" id="btn_mobile_agregar_jugada_ganagol" class="btn btn-red float-bottom">SIGUIENTE</button>
					</div>
				</section>
			</div>
		</div>																																																																																																							
	</div>
	<div style="display:none" class="f_error_mensaje">
	    <span class="close_f"></span>
		<div class="f_textoInterno"></div>
	</div>
	<jsp:include page="../../include/footer.jsp" />
	<!-- solo para mostrar esta parte debe de ser retirada cuando se implemente la condicional de partido suspendido -->	
	<script type="text/javascript">
	$(document).ready(function(){
		//retirar en backend
				//$("#item_2").addClass("suspendido");
		//envio ajax
		var $limiteJugadas = $('#ganagolJugadas').val();
		var $overcomeJugadas = $('#ganagolOvercomeJugadas').val();
		if($overcomeJugadas==1)	{
			desplegarModal('Máximo '+ $limiteJugadas +' jugadas');
			taggingPopupError('Máximo '+$limiteJugadas+' jugadas');
		}
		
		
				function evaluarArray(array){
					var x=0;
					for (var a=0;a<array.length;a++){
						if (array[a]==0){
							x++;
						}
					}
					return x;
				}
				//esta es la funcion de enviar el ajax puedes editarla si lo necesitas
				function enviarAjax(url,valor){
					//console.log(valor);
					$.ajax({
						url: url,
						method: 'post',
					    data: {'bet':valor},
					    dataType: 'json',
					    success: function(data){

						    /*
					    	if (data){
					    		console.log("Enviado correctamente");
					    	}
					    	else{
					    		desplegarModal("Error interno espere unos minutos y vuelva intentarlo");
					    	}
					    	*/
					    },
					});
				}

				function validarJugadasMaximas(array){
					//var valorTotal = 14;
					var jugadas = 1;
					for (var a=0;a<array.length;a++){
						var valor = array[a];												
						jugadas = jugadas*valor;
					}
					return jugadas;
				}

				function desplegarModal(mensaje){
					$(".f_error_mensaje").show();
					$(".f_textoInterno").html(mensaje);				
				}

				$(".close_f").on("click",function(){
					$(".f_error_mensaje").hide();
				});
				


		  	$(' .program-list input').on( 'change', function() {
		  		var $this = $( this );
		  		var evaluar_jugadas = [];
		  		var flag=true;
				var $item = $('.f_item');	
				var idbetAux = $this.attr('id').replace("bet_","");
				var idbet=idbetAux.replace("_e","").replace("G","").replace("_l","").replace("_v","");
				var idGolazo200 = $this.attr('id').substring(4).trim().replace("G","");
				if(parseInt(idbet) <= parseInt(14)){
					flag=false;
				}

				if(flag){
					for(var i=15 ; i<=24 ; i++){						
						if( parseInt(i) != parseInt(idGolazo200)){
							$('#bet_' + i + 'G' ).prop('checked', false);
						}
					}
					if(idGolazo200 < 24 && idGolazo200 > 14){
						datalayerTinkaJugada(this.parentElement.querySelector('label').textContent,'Programa','Button','Jugar');
					}
				}	
					for (var i=0;i<$item.length;i++){
					  var $te = $item.eq(i);
					  var $boxinput = $te.find("input");
					  var addJugada = 0;	
					  for (var a=0;a<$boxinput.length;a++){
						  if ($boxinput.eq(a).is(':checked')){		
							addJugada++;
						  }
					  }	
					  //guardardatos
					  evaluar_jugadas.push(addJugada);				  
					}	
					//console.log(validarJugadasMaximas(evaluar_jugadas));
					if (validarJugadasMaximas(evaluar_jugadas) > $limiteJugadas) {
						//$( 'body' ).addClass('notCheckout');
						$this.prop('checked',false);
						let message = 'Máximo '+ $limiteJugadas +' jugadas';
			  			desplegarModal(message);
			  			taggingPopupError(message);
						datalayerErrores('Programa','Paso 1','Jugar',message);
					}
					if ($this.is(':checked')){
						$this.closest('.f_item').addClass("userChecked");
					}
					else {
						$this.closest('.f_item').removeClass("userChecked");	
					}		
		  	});

			var thisBtnAgregarJugadaGanagol = null;
		  	$(document).delegate('#btn_mobile_agregar_jugada_ganagol', 'click', function(e) {
		  		thisBtnAgregarJugadaGanagol = this;
		  		//$("#btn_mobile_agregar_jugada_ganagol2").on("click",function(e){
			  	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
			  	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
			  	mainValidatePendingsDocsForAproval('interfaceBetAgregarJugadaGanagol');
			});

			function interfaceBetAgregarJugadaGanagol() {
				$(".f_error_mensaje").hide();
				var $form = $("#game_ganagol_add_bet");
				var $data = $form.serialize();
				var jugadas_envio = '';
				var evaluar_jugadas = [];
				var jugadas_totales = [];
				let message = '';
				var $item = $('.f_item');
				for (var i=0;i<$item.length;i++){
				  var $te = $item.eq(i);
				  var $boxinput = $te.find("input");
				  var addJugada = 0;	
				  var indice = parseInt(i)+1;
				  var jugada = indice;
				  for (var a=0;a<$boxinput.length;a++){
					  if ($boxinput.eq(a).is(':checked')){						
						jugada = jugada + $boxinput.eq(a).val();
						addJugada++;
					  }
				  }	
				  //guardardatos
				  jugadas_totales.push(jugada);
				  evaluar_jugadas.push(addJugada);
				}
				//condicionales
				//console.log(evaluarArray(evaluar_jugadas));
				if (evaluarArray(evaluar_jugadas) == 0){
					if (validarJugadasMaximas(evaluar_jugadas) <= $limiteJugadas){
						datalayerTinkaJugada(thisBtnAgregarJugadaGanagol,'Programa','Button','Jugar');
						$form.submit();
						//enviarAjax('game_ganagol_add_bet.html',jugadas_totales);
					} else {
						message = 'Haz excedido el número de jugadas permitido';
						datalayerErrores('Programa','Paso 1','Jugar',message);
						desplegarModal(message);
						taggingPopupError(message);
					}										
				} else {		
					message = 'Todos los campos deben estar seleccionados';
					datalayerErrores('Programa','Paso 1','Jugar',message);
					desplegarModal(message);
					taggingPopupError(message);
				}
			}

			window.addEventListener("message", function(event) {
			    if (event.data === "interfaceBetAgregarJugadaGanagol") {
			    	interfaceBetAgregarJugadaGanagol(); 
			    }
			});

				var $span = $('.program-bet span');
				for (var b=0; b<$span.length;b++){
				  var valor = $span.eq(b).attr("data").trim();
				  valor = valor.replace("[","").replace("]","").replaceAll(", ",",");
				  valor = valor.split(',');
				  for (var c=0;c<valor.length;c++){
					var classextend = '.valueDrop_'+valor[c];
					$span.eq(b).closest('.f_item').find(classextend).attr('checked',true)
				  }
				}

				taggingMarcaTuJugada();
	});
		

	</script>
	
</body>
</html>