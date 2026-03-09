<!DOCTYPE html>
<%@ include file="/layer-view-interface/include/taglib.jsp" %>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
		<html lang="es">

		<head>
			<!-- Google Tag Manager -->
			<script>(function (w, d, s, l, i) {
					w[l] = w[l] || []; w[l].push({
						'gtm.start':
							new Date().getTime(), event: 'gtm.js'
					}); var f = d.getElementsByTagName(s)[0],
						j = d.createElement(s), dl = l != 'dataLayer' ? '&l=' + l : ''; j.async = true; j.src =
							'https://www.googletagmanager.com/gtm.js?id=' + i + dl; f.parentNode.insertBefore(j, f);
				})(window, document, 'script', 'dataLayer', 'GTM-58FNN4L');</script>
			<!-- End Google Tag Manager -->
			<script src="https://web-button.metamap.com/button.js"></script>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
			<title>Retirar Premio</title>
			<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
			<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css" />
			<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/mainCollectPrize_ta.css?v=32">
			<meta http-equiv="Permissions-Policy" content="geolocation=(https://signup.metamap.com) camera=(self 'https://signup.metamap.com') microphone=(https://signup.metamap.com)">
		</head>
		<body class="no-scroll">
			<!-- Google Tag Manager (noscript) -->
			<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
			<!-- End Google Tag Manager (noscript) -->
			<input type="hidden" id="prizetoken" value="${prizetoken}" />
			<input type="hidden" id="operatorId" value="${operatorId}" />
			<section class="ipremio">
				<input type="hidden" id="numDiasExpiracion" value="">
				<input type="hidden" id="numCuentaSeleccionadaEliminar" value="">
				<input type="hidden" id="cid" value="${cid}">

				<div style="display: none;">
					<mati-button clientid="63c5aafb54916c001c517b3d" flowId=<%=Constantes.KYC_FLOWID%> metadata='' id="metamap-button" />
				</div>

				<div class="ioverlay modal-msg" id="modal-confirmar-eliminar-cuenta-transferencia">
					<div class="modal is-error">
						<div class="modal__boby" style="padding-bottom: 20px;">
							<div>
								<p style='text-align: center; margin-bottom: 0px;'>
									<span style='font-size: 16px; font-weight: 700;'>Eliminar</span>
								</p>
								<br>
								<p id="textoEliminarCuentaTransferencia" style='text-align: center; line-height: 20px;'></p>
							</div>
							<button class="btn" style="background: #07663a; margin: 20px auto 0;" onclick="eliminarCuentaTransferencia()">ACEPTAR</button>
							<button class="btn" style="margin-top: 12px; background: #ffffff; border: 2px solid #07663a; color: #77736f;" onclick="cancelarEliminarCuentaTransferencia()">CANCELAR</button>
						</div>
					</div>
				</div>

				<div class="ioverlay modal-msg" id="modal-confirmar-retiro-transferencia">
					<div class="modal is-error">
						<div class="modal__boby" style="padding-bottom: 20px;">
							<div>
								<p style='text-align: center; margin-bottom: 0px;'>
									<span style='font-size: 16px; font-weight: 700;'>Confirma tus datos</span> <br><br>
								</p>
								<table style="font-size: 13px; line-height: 13px;">
									<tbody>
										<tr><td>Monto de retiro</td><td>: S/ <span id="confirmaMontoTransferencia"></span></td></tr>
										<tr><td>Banco</td><td>: <span id="confirmaBancoTransferencia"></span></td></tr>
										<tr><td>Cuenta destino</td><td>: Ahorro soles</td></tr>
										<tr><td> </td><td>&nbsp;&nbsp;<span id="confirmaNumCuentaTransferencia"></span></td></tr>
										<tr id="filaJugadaGratisCD"><td>Jugadas gratis</td><td><span id="lblJugadaGratisCD"></span></td></tr>
										<tr><td>Datos</td><td>: <span id="confirmaNombresTransferencia"></span></td></tr>
										<tr><td> </td><td>&nbsp;&nbsp;<span id="confirmaDocumentoTransferencia"></span></td></tr>
										<tr><td>Departamento</td><td>: <span id="confirmaDepartamentoTransferencia"></span></td></tr>
									</tbody>
								</table>
								<p style='text-align: left; line-height: 12px;'>
									<br><span style="font-size: 10px;">Para que tu retiro sea aprobado, t� debes ser el titular de la cuenta y los datos de tu cuenta de La Tinka deben ser iguales a los de tu cuenta bancaria. Caso contrario, tu retiro ser� rechazado.</span><br>
								</p>
							</div>
							<button class="btn" style="background: #07663a; margin: 20px auto 0;" onclick="continuarRetiroTransferencia()">Confirmar retiro</button>
							<button class="btn" style="margin-top: 12px; background: #ffffff; border: 2px solid #07663a; color: #77736f;" onclick="regresarRetiroTransferencia()">REGRESAR</button>
							<p style="margin-top: 20px; margin-bottom: 0px; font-size: 11px; text-align: justify;">Algunos bancos cobran una comisi�n interplaza del 0.05% del monto retirado, o un m�nimo de S/7.50. Si quieres actualizar tu nombre, apellidos o DNI, <a href="derechos-arco.html" target="_blank" style="text-decoration: underline; color: #e30613;">solic�talo aqu�</a></p>
						</div>
					</div>
				</div>

				<div class="ioverlay modal-msg" id="modal-confirmar-retiro-transferencia-pin">
					<div class="modal is-error" style="width: 97%;  max-width: 433px;margin: 0 auto; ">
						<div class="modal__close" onclick="closeModal()"><span class="icon-cerrar"></span></div>
						<div class="modal__boby" style="padding: 20px 10%;">
							<div>
								<p style='text-align: center; margin-bottom: 0px;'>
									<span style='font-size: 16px; font-weight: 700;' id="ecoPinTitulo"></span> <br><br>
								</p>
								<p style="line-height: 14px;"><span id="ecoPinMensaje"></span>
								</p>
								<div class="ilot" id="ecoPinInput">
									<div class="activate">
										<form class="form" id="form_activate" autocomplete="off" method="post">
											<div class="form__code" id="idPinCode">
												<div class="form__code-item">
													<input type="text" name="code-01" id="code-01" tabindex="31"
														maxlength="1">
												</div>
												<div class="form__code-item">
													<input type="text" name="code-02" id="code-02" tabindex="32"
														maxlength="1">
												</div>
												<div class="form__code-item">
													<input type="text" name="code-03" id="code-03" tabindex="33"
														maxlength="1">
												</div>
												<div class="form__code-item">
													<input type="text" name="code-04" id="code-04" tabindex="34"
														maxlength="1">
												</div>
												<div class="form__code-item">
													<input type="text" name="code-05" id="code-05" tabindex="35"
														maxlength="1">
												</div>
											</div>

											<div class="form__alert" id="ecoPinMensajeError"></div>

											<button class="btn btn_green" id="btactivatepin" type="submit"
												style="background: #07663a; margin: 20px auto 0;"
												disabled>ENVIAR</button>

										</form>

									</div>
								</div>

							</div>
							<p style="margin-top: 20px; margin-bottom: 0px; font-size: 11px; text-align: center;">�No
								recibiste tu c�digo?
							</p>
							<p style="margin-top: 10px;margin-bottom: 0px;font-size: 11px;text-align: center;">
								<a id="btnReenvioCodeEmail"
									style="display: block; text-decoration: underline; color: #e30613;"
									href="javascript:reenviarRetiroTransferenciaPinCorreo();">Reenviar c�digo por
									Email</a>
								<a id="btnReenvioCodeSMS"
									style="display: block;text-decoration: underline;color: #e30613;margin-top: 8px;"
									href="javascript:reenviarRetiroTransferenciaPinSms();">Reenviar c�digo por SMS</a>
							</p>
						</div>
					</div>
				</div>
				</div>

				<div class="ioverlay modal-msg" id="modal-confirmar-retiro-efectivo">
					<div class="modal is-error">
						<div class="modal__boby" style="padding-left: 25px; padding-right: 25px;">
							<div>
								<!--           	<p style='text-align: center;'>  -->
								<!-- 	          	<span style='font-size: 16px; font-weight: 700;'>�Cobra tus premios sin salir de casa!</span> <br><br>  -->
								<!-- 	          	<span>Recuerda que para recibir el dinero en tu cuenta bancaria, s&oacute;lo necesitas ingresar la </span>  -->
								<!-- 	          	<span style='font-weight: 700;'>tarjeta Visa d&eacute;bito </span>  -->
								<!-- 	          	<span>asociada a esa cuenta.</span> <br><br>  -->
								<!-- 	          	<span>�A&uacute;n deseas retirar en efectivo</span> <br>  -->
								<!-- 	          	<span>o prefieres retirar a tu cuenta con Visa?</span>  -->
								<!--           	</p> -->
								<p style='text-align: center;'><span style='font-size: 16px; font-weight: 700;'>�Cobra
										tus premios sin salir de casa!</span></p>
								<p style='text-align: center;margin-bottom: 8px;'>Puedes retirar directo a tu cuenta
									bancaria.</p>
								<button class="btn" style="margin-top: 8px; background: #07663a;"
									id="aceptar-ir-transferencia" onclick="irTransferencia()">IR A TRANSFERENCIA
									BANCARIA</button>
								<br>
								<p style='text-align: center;margin-bottom: 8px;'>o enviando los datos de tu tarjeta
									d�bito VISA asociado a esa cuenta.</p>
								<button class="btn" style="margin-top: 8px; background: #07663a;" id="aceptar-ir-visa"
									onclick="irVisa()">IR A VISA</button>
								<br>
								<p style='text-align: center; font-weight: 700;margin-bottom: 8px;'>�A�n deseas retirar
									en efectivo?</p>
								<button class="btn" id="aceptar-confirmar-retiro-efectivo"
									style="margin-top: 8px;background: #ffffff; border: 2px solid #07663a; color: #77736f;"
									onclick="continuarRetiroEfectivo()">Confirmar retiro en efectivo</button>
							</div>
							<!--           <button class="btn" id="aceptar-confirmar-retiro-efectivo" onclick="continuarRetiroEfectivo()">Confirmar retiro en efectivo</button> -->
							<!--           <button class="btn" style="margin-top: 12px; background: #07663a;" id="aceptar-ir-visa" onclick="irVisa()">Ir a Visa</button> -->
						</div>
					</div>
				</div>

				<div class="ioverlay modal-msg" id="modal-msg-error-visa">
					<div class="modal is-error">
						<div class="modal__head" id="title-message-error-visa"></div>
						<div class="modal__boby">
							<p id="message-error-visa"></p>
							<button class="btn" id="aceptar-message-error-visa"
								onclick="closeMessageErrorVisa()">Aceptar</button>
						</div>
					</div>
				</div>
				<div class="ioverlay modal-msg" id="modal-msg-error-agora">
					<div class="modal is-error">
						<div class="modal__head" id="title-message-error-agora"></div>
						<div class="modal__boby">
							<p id="message-error-agora"></p>
							<button class="btn" id="aceptar-message-error-agora"
								onclick="closeMessageErrorAgora()">Aceptar</button>
						</div>
					</div>
				</div>
				<div class="ioverlay modal-msg" id="modal-msg-error">
					<div class="modal is-error">
						<div class="modal__head" id="title-message-error"></div>
						<div class="modal__boby">
							<p id="message-error"></p>
							<button class="btn" id="aceptar-message-error"
								onclick="closeMessageError()">Aceptar</button>
						</div>
					</div>
				</div>
				<div class="ioverlay modal-msg" id="modal-msg-info">
					<div class="modal is-success">
						<div class="modal__head" id="title-message-info"></div>
						<div class="modal__boby">
							<p id="message-info"></p>
							<button class="btn btn-message" id="aceptar-message-info"
								onclick="closeMessageInfo()">Aceptar</button>
						</div>
					</div>
				</div>

				<div class="ioverlay" id="modal-success">
					<div class="modal is-success">
						<div class="modal__close iclose"><span class="icon-cerrar icon-cerrar-token"
								style="display: none;"></span></div>
						<div class="modal__head" id="montoSolicitado"></div>
						<div class="modal__boby">
							<p id="message-modal-success"></p>
							<div class="modal__links" style="padding-top: 0px;">
								<div><a class="no-underline" style="color: #e30613;" href="#" id="historialRetiros"
										toggle-modal="#modal-premios"
										onclick="var t=document.querySelector('.tabs-retiro .tab-btn[data-tab=\'tab-historial\']'); if(t) t.click();"><span>Historial de retiros</span></a></div>
							</div>
							<hr>
							<div class="modal__links">
								<div><a class="no-underline" href="game_kinelo_show_home.html"><span>Jugar
											Kinelo</span></a></div>
								<div><a class="no-underline" href="#"
										onclick="toJuegosVirtuales('virtuales')"><span>Jugar Deportes
											Virtuales</span></a></div>
							</div>
						</div>
					</div>
				</div>

				<div class="ioverlay" id="modal-error">
					<div class="modal is-error">
						<div class="modal__close iclose"><span class="icon-cerrar icon-cerrar-token"
								style="display: none;"></span></div>
						<div class="modal__head" id="title-modal-error">No pudimos procesar tu solicitud</div>
						<div class="modal__boby">
							<p id="mensajeErrorSolicitud"></p>
							<button class="btn" onclick="showModalPremios()">Aceptar</button>
						</div>
					</div>
				</div>

				<div class="ioverlay" id="modal-premios" style="display: block;">
					<div class="modal is-iframe full">
						<div class="ipremio in-iframe">
							<div class="ipremio__head">
								<div class="top-saldo">

									<!-- Logo centrado -->
									<img class="brand-logo"
										src="<c:url value='/layer-view-image/v2/logo-teapuesto-pe.png'/>"
										alt="Te Apuesto" />

									<div class="top-right-saldo">


										<div class="saldo-add">
											<!-- Item: Saldo -->
											<div class="saldo-item">
												<!-- Icono Saldo (archivo .ico en layer-view-image/v2/) -->
												<img class="icon-svg" width="26" height="26"
													src="<c:url value='/layer-view-image/v2/icon-saldo.ico'/>" alt=""
													aria-hidden="true" />

												<div class="saldo-text">
													<span class="saldo-label">Saldo:</span>
													<strong id="balanceAmount" class="saldo-amount">0</strong>
													<!-- (Opcional) tercera l�nea peque�a -->
													<!-- <small class="saldo-hint">saldo</small> -->
												</div>
											</div>

											<!-- Item: Disponible -->
											<div class="saldo-item disponible-item">
												<!-- Icono Saldo (archivo .ico en layer-view-image/v2/) -->
												<img class="icon-svg" width="26" height="26"
													src="<c:url value='/layer-view-image/v2/icon-disponible.ico'/>"
													alt="" aria-hidden="true" />

												<div class="saldo-text">
													<span class="saldo-label">Disponible para retirar:</span>
													<strong id="saldoLiquidable" class="saldo-amount">0</strong>
													<!-- <small class="saldo-hint">saldo</small> -->
												</div>
											</div>
										</div>


									</div>
								</div>
								<span class="ipremio__title">Retirar</span>
								<div class="modal__close iclose">
									<span class="icon-cerrar icon-cerrar-token" style="display: none;">
									</span>
								</div>
							</div>

							<div class="ipremio__body">
								<div class="tabs-retiro">
									<button class="tab-btn active" data-tab="tab-retiro">
										Solicitar Retiro
									</button>
									<button class="tab-btn" data-tab="tab-historial">
										Historial de Retiros
									</button>
								</div>

								<ul class="accordion is-main">
									<li class="accordion__item opened is-modal">
										<div id="bodyPrincipal" class="accordion__body content_loading">
											<div id="tab-retiro" class="tab-content active">
												<div class="title-method">Medios de retiro</div>

												<div class="method-cards" aria-label="M�todo de cobro">
													<button type="button" class="method-card"
														data-accordion="#accordion_efectivo">
														<img class="method-card__icon"
															src="<c:url value='/layer-view-image/v2/icono-efectivo.png'/>"
															alt="" aria-hidden="true" />
														<span class="method-card__text">
															<span class="method-card__title">Efectivo / Puntos de
																Venta</span>
															<span class="method-card__subtitle"
																data-range-source="rangoMontosEfectivo"></span>
														</span>
														<span class="method-card__chev" aria-hidden="true">|</span>
													</button>

													<button type="button" class="method-card"
														data-accordion="#accordion_visa">
														<img class="method-card__icon"
															src="<c:url value='/layer-view-image/v2/icono-visa.png'/>"
															alt="" aria-hidden="true" />
														<span class="method-card__text">
															<span class="method-card__title">Tarjeta de cr�dito / d�bito</span>
															<span class="method-card__subtitle"
																data-range-source="rangoMontosVisa"></span>
														</span>
														<span class="method-card__chev" aria-hidden="true">|</span>
													</button>

													<button type="button" class="method-card"
														data-accordion="#accordion_transferencia">
														<img class="method-card__icon"
															src="<c:url value='/layer-view-image/v2/icono-transferencia.png'/>"
															alt="" aria-hidden="true" />
														<span class="method-card__text">
															<span class="method-card__title">Transferencia
																Bancaria</span>
															<span class="method-card__subtitle"
																data-range-source="rangoMontosTransferencia"></span>
														</span>
														<span class="method-card__chev" aria-hidden="true">|</span>
													</button>
												</div>
												<ul class="accordion is-method listaMetodosRetiro">

													<li class="accordion__item" id="accordion_efectivo"
														style="display: none;">
														<h2 class="accordion__title major-356"><span
																class="icon-efectivo"></span>Efectivo / Punto de venta
															<span class="info" id="rangoMontosEfectivo" data-min-label="Min" data-max-label="Máx"></span></h2>
														<h2 class="accordion__title minor-356"
															style="height: 21px !important;"><span
																class="icon-efectivo"></span>Efectivo / <br>Punto de
															venta <span class="info"
																id="rangoMontosEfectivo-356" data-min-label="Min" data-max-label="Máx"></span></h2>
														<div class="accordion__body">
															<div class="inner"></div>
														</div>
													</li>

													<li class="accordion__item" id="accordion_visa"
														style="display: none;">
														<h2 class="accordion__title major-356"><span
																class="icon-tarjeta"></span>Visa <span class="info"
																id="rangoMontosVisa" data-min-label="Min" data-max-label="Máx"></span></h2>
														<h2 class="accordion__title minor-356"
															style="height: 21px !important;"><span
																class="icon-tarjeta"></span>Visa <span class="info"
																id="rangoMontosVisa-356" data-min-label="Min" data-max-label="Máx"></span></h2>
														<div class="accordion__body">
															<div class="inner"></div>
														</div>
													</li>

													<li class="accordion__item" id="accordion_agora"
														style="display: none;">
														<h2 class="accordion__title"><span
																class="icon-tarjeta"></span>Agora <span class="info"
																id="rangoMontosAgora"></span></h2>
														<div class="accordion__body">
															<div class="inner">
																<form class="metodo-visa steps" autocomplete="off"
																	id="formagora">
																	<!--                               <div class="steps-title">Pasos a seguir:</div> -->

																	<div class="step"><i>1</i>Ingresa el monto a retirar
																		<div class="form-item ispad15"
																			id="divMontoAgora">
																			<div class="input">
																				<label>Monto en S/</label>
																				<input class="is-numeric" type="text"
																					name="iamount" maxlength="10"
																					id="amountAgora" data-min="0"
																					data-max="0" data-valid="amount">
																			</div>
																			<div class="input__error"
																				id="msgErrorRangoMontosAgora"></div>
																		</div>
																	</div>
																	<!--                        
                              <div id="divStepDNIAgora" class="step hidden"><i>2</i>
                                <div class="fileup-image" id="divImgDniAgora">
                                  <span id="stateDniPENAgora" style="display: none;">Registra tu DNI, por �nica vez, adjuntando el lado que muestra tu foto. (max <span id="pesoImgDniAgora"></span>MB)</span>
                                  <label id="stateDniPENLabelAgora" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
                                    <input class="upimage is-simple" type="file" name="iimage_1" id="imgDNIAgora" accept="image/jpeg, image/png" data-valid="required">
                                    <canvas id="canvasDNIAgora" style="display: none;" ></canvas>
                                  </label>
                                  <span id="stateDniACTAgora" style="display: none; line-height: 16px; margin-bottom: 10px;">
                          			<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
                          			<span style="vertical-align: top;">Tu DNI est� registrado</span>
                               	  </span>
                               	  <span id="stateDniACTLabelAgora" style="display: none;">
                           			<span>�Quieres actualizarlo?</span>
                           			<a id="updateDNIAgora" style="text-decoration: underline; color: #e30613;">
                           				hazlo aqu�
                           			</a>
                               	  </span>      
                                  <div class="filenames empty" id="filenamesDniAgora"><span class="filename-empty">No se adjunt� ninguna imagen</span>
                                    <div class="filename-simple"></div>
                                  </div>
                                </div>
                              </div> -->
																	<div class="step"><i
																			id="stepCardAgora">2</i>Selecciona o a�ade
																		tu tarjeta
																		<div class="form_visa" id="divAgora">
																			<img class="form_visa_agora"
																				src="layer-view-image/client/logo-agora1.png">
																			<label class="form_visa_card_button"
																				id="visaCardButtonAgora"
																				onclick="showTokenizationAgora()">Seleccionar
																				<input type="hidden"
																					id="txtTarjetaTokenizadaAgora"
																					data-valid="required">
																			</label>
																			<span class="form_visa_card_mask hidden"
																				id="visaCardTextAgora">
																				<img src="layer-view-image/client/icon-valid.svg"
																					width="16" height="16">
																				<span
																					id="tarjetaTokenizadaAgora"></span>
																			</span>
																		</div>
																		<!--  
                                <div style="margin-top: 10px;">Una vez confirmado tu retiro se har� el abono a tu tarjeta en menos de 30 minutos.</div>
                                -->
																		<div class="subcontent-comision hidden">
																			<p class="subcontent-text-comision"
																				id="comision_agora"><span
																					class="monto-comision-agora"
																					id="monto_comision_agora"></span>
																			</p>
																		</div>
																	</div>
																	<div class="step"><i id="stepCardSDKAgora">3</i>
																		<div class="form_visa" id="divAgoraKYC">
																			<img class="form_visa_logo"
																				src="layer-view-image/client/icon_dni.png?v=3"
																				style="margin-left: 5px; margin-top: -10px; margin-right: 32px;">
																			<label class="form_visa_card_button"
																				id="agoraSDKCardButton"
																				style="padding: 0px 12px !important; font-size: 10px !important;"
																				onclick="showSDK()">VERIFICA TU
																				IDENTIDAD
																				<input type="hidden"
																					id="txtAgoraSDKVerificado"
																					data-valid="required">
																			</label>

																			<span class="form_visa_card_mask hidden"
																				id="agoraSDKCardText">
																				<img src="layer-view-image/client/icon-valid.svg"
																					width="16" height="16">
																				<span id="agoraSDKVerificado"></span>
																			</span>
																		</div>
																		<div
																			style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">
																			Deber�s permitir el acceso a tu c�mara para
																			realizar la verificaci�n.</div>
																		<div style="margin-top: 5px;">Una vez confirmado
																			tu retiro se har� el abono a tu tarjeta en
																			menos de 30 minutos.</div>
																	</div>

																	<button class="btn btn-solicitar">Solicitar
																		Retiro</button>
																</form>
															</div>
														</div>
													</li>

																										<li class="accordion__item" id="accordion_transferencia" style="display: none;">
																											<h2 class="accordion__title"><span class="icon-transferencia"></span>Transferencia
																													<br>Bancaria <span class="info" id="rangoMontosTransferencia" data-min-label="Min" data-max-label="Máx"></span></h2>
																											<div class="accordion__body">
																												<div class="inner"></div>
																											</div>
																										</li>

												</ul>

											</div>
											<div id="tab-historial" class="tab-content">
												<div class="footlinks">
													<div>Historial</div><a class="linkbox" href="#"
														toggle-modal="#modal-listado"
														style="margin-left: 0px;">Retiros</a>
												</div>

												<div id="sin-retiros" style="display:none;">
													A�n no has hecho ning�n retiro
												</div>

												<div id="con-retiros" style="display:none;">
													<!-- aqu� va tu tabla -->
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- Nuevo modal para retiro efectivo -->

				<div class="ioverlay" id="modal-retiro-efectivo-pdv" style="display:none;">
					<div class="modal is-iframe full">
						<div class="ipremio in-iframe">
							<div class="ipremio__head ipremio__head--retiro-pdv">
								<div class="retiro-pdv__headbar">
									<span class="ipremio__title">
										<a class="ipremio__title-link" href="#"
											onclick="if (typeof simpleModal !== 'undefined') simpleModal.onToggleModalMsg('#modal-premios'); return false;"
											aria-label="Volver">
											<span class="ipremio__title-icon" aria-hidden="true">&lt;</span>
											<span class="ipremio__title-text">Solicitar retiro</span>
										</a>
									</span>
									<div class="modal__close iclose" aria-label="Cerrar">
										<span class="icon-cerrar" aria-hidden="true"></span>
									</div>
								</div>

								<div class="retiro-pdv__headline">Monto a retirar</div>

								<div class="retiro-pdv__iconbox" aria-hidden="true">
									<img class="retiro-pdv__icon"
									src="<c:url value='/layer-view-image/v2/icono-efectivo.png'/>" alt="" />
								</div>
							</div>

							<div class="ipremio__body">
								<div class="title-method">Efectivo / Puntos de Venta</div>
								<div class="retiro-disponible" aria-label="Disponible para retirar">
									<img class="retiro-disponible__icon" width="20" height="20"
										src="<c:url value='/layer-view-image/v2/disponible-retirar-2.svg'/>" alt=""
										aria-hidden="true" />
									<span class="retiro-disponible__label">Disponible para retirar:</span>
									<strong class="retiro-disponible__amount" data-saldo-liquidable-mirror>0</strong>
								</div>
								<div class="inner">
									<form class="metodo-efectivo steps" autocomplete="off" id="formefectivo">
										
											<div class="form-item" id="divMontoEfectivo">
												<div class="retiro-pdv__amount" aria-label="Ingresa el monto a retirar">
													
													<div class="retiro-pdv__amount-input">
														<span class="retiro-pdv__amount-currency" aria-hidden="true">S/</span>
														<input class="is-numeric" type="text" name="iamount" maxlength="10" id="amountEfectivo"
															data-min="0" data-max="0" data-valid="amount" placeholder="Ingresa el monto aqui">
													</div>
														<div class="retiro-pdv__amount-range" data-range-mirror="rangoMontosEfectivo" data-values-only="true" data-min-label="Minimo S/ " data-max-label="Maximo S/ "></div>
												</div>
											<!-- 	<div class="input__error" id="msgErrorRangoMontosEfectivo"></div> -->
											</div>
										

										<!-- Pedir DNI Efectivo -->
										<div id="divStepDNIEfectivo" class="step hidden">
											<i>2</i>
											<div class="fileup-image" id="divImgDniEfectivo">
												<span id="stateDniPENEfectivo" style="display: none;">Registra tu DNI, por �nica vez, adjuntando el lado que muestra tu foto. (max <span id="pesoImgDniEfectivo"></span>MB)</span>
												<label id="stateDniPENLabelEfectivo" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
													<input class="upimage is-simple" type="file" name="iimage_1" id="imgDNIEfectivo" accept="image/jpeg, image/png" data-valid="required">
													<canvas id="canvasDNIEfectivo" style="display: none;"></canvas>
												</label>
												<span id="stateDniACTEfectivo" style="display: none; line-height: 16px; margin-bottom: 10px;">
													<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
													<span style="vertical-align: top;">Tu DNI est� registrado</span>
												</span>
												<span id="stateDniACTLabelEfectivo" style="display: none;">
													<span>�Quieres actualizarlo?</span>
													<a id="updateDNIEfectivo" style="text-decoration: underline; color: #e30613;">hazlo aqu�</a>
												</span>
												<div class="filenames empty" id="filenamesDniEfectivo"><span class="filename-empty">No se adjunt� ninguna imagen</span>
													<div class="filename-simple"></div>
												</div>
											</div>
										</div>

										<div class="step hidden" id="stepKYCEfectivo"><i id="stepCardSDKVisa">2</i>Verifica tus datos por �nica vez cada 36 meses, si tus datos son correctos.
											<div class="form_visa" id="divEfectivoKYC">
												<img class="form_visa_logo" src="layer-view-image/client/icon_dni.png?v=3" style="margin-left: 5px; margin-top: -10px; margin-right: 32px;">
												<label class="form_visa_card_button" id="efectivoSDKCardButton" style="padding: 0px 12px !important; font-size: 10px !important;" onclick="showSDK()">VERIFICA TU IDENTIDAD
													<input type="hidden" id="txtEfectivoSDKVerificado" data-valid="required">
												</label>
												<span class="form_visa_card_mask hidden" id="sdkEfectivoCardText">
													<img id="iconKycE" src="layer-view-image/client/icon-valid.svg" width="16" height="16">
													<span class="span_mensaje_verificado" id="efectivoSDKVerificado"></span>
													<span id="efectivoSDKBtn" style="cursor: pointer;" class="verificarKYC"><u>Clic aqu� para actualizar</u></span>
												</span>
												<!-- 	                                	<button type="button" id="consultResultKyc4" class = "btn-verificar" >Verificar</button> -->
											</div>
											<div style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">Deber�s permitir el acceso a tu c�mara para realizar la verificaci�n.</div>
										</div>
										<div class="retiro-pdv__info" aria-label="Informacion del retiro en efectivo">
											<div class="retiro-pdv__info-icon" aria-hidden="true">
												<img src="<c:url value='/layer-view-image/v2/icono-informacion-modal.svg'/>" alt="" />
											</div>
											<ul class="retiro-pdv__info-list">
												<li class="retiro-pdv__info-item">
													<img class="retiro-pdv__info-item-icon" src="<c:url value='/layer-view-image/v2/icono-recargar-modal.svg'/>" alt="" aria-hidden="true" />
													<span>Solicitudes confirmadas en menos de <strong>30 minutos.</strong></span>
												</li>
												<li class="retiro-pdv__info-item">
													<img class="retiro-pdv__info-item-icon" src="<c:url value='/layer-view-image/v2/icono-calendario-modal.svg'/>" alt="" aria-hidden="true" />
													<span>De haber un problema con tu confirmaci&oacute;n, podr&iacute;a demorar <strong>hasta 72 horas.</strong></span>
												</li>
												<li class="retiro-pdv__info-item">
													<img class="retiro-pdv__info-item-icon" src="<c:url value='/layer-view-image/v2/icono-dinero-modal.svg'/>" alt="" aria-hidden="true" />
													<span>Este tipo de retiro se realiza &uacute;nicamente <strong>en efectivo.</strong></span>
												</li>
												<li class="retiro-pdv__info-item">
													<img class="retiro-pdv__info-item-icon" src="<c:url value='/layer-view-image/v2/icono-tienda-modal.svg'/>" alt="" aria-hidden="true" />
													<span>Debes acercarte a cualquiera de nuestros <strong>puntos de venta.</strong></span>
												</li>
											</ul>
										</div>

										<div class="retiro-pdv__footer">
											<button class="btn btn-solicitar" type="submit" disabled>Solicitar retiro</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- fin del nuevo Modal -->

				<!-- Nuevo modal para retiro tarjeta -->
				<div class="ioverlay" id="modal-retiro-tarjeta" style="display:none;">
				<div class="modal is-iframe full">
						<div class="ipremio in-iframe">
							<div class="ipremio__head ipremio__head--retiro-pdv">
								<div class="retiro-pdv__headbar">
									<span class="ipremio__title">
										<a class="ipremio__title-link" href="#"
											onclick="if (typeof simpleModal !== 'undefined') simpleModal.onToggleModalMsg('#modal-premios'); return false;"
											aria-label="Volver">
											<span class="ipremio__title-icon" aria-hidden="true">&lt;</span>
											<span class="ipremio__title-text">Solicitar retiro</span>
										</a>
									</span>
									<div class="modal__close iclose" aria-label="Cerrar">
										<span class="icon-cerrar" aria-hidden="true"></span>
									</div>
								</div>

								<div class="retiro-pdv__headline">Monto a retirar</div>

								<div class="retiro-pdv__iconbox" aria-hidden="true">
									<img class="retiro-pdv__icon"
										src="<c:url value='/layer-view-image/v2/icono-visa.png'/>" alt="" />
								</div>
							</div>

							<div class="ipremio__body">
								<div class="title-method">Tarjeta de cr�dito / d�bito</div>
								<div class="retiro-disponible" aria-label="Disponible para retirar">
									<img class="retiro-disponible__icon" width="20" height="20"
										src="<c:url value='/layer-view-image/v2/disponible-retirar-2.svg'/>" alt=""
										aria-hidden="true" />
									<span class="retiro-disponible__label">Disponible para retirar:</span>
									<strong class="retiro-disponible__amount" data-saldo-liquidable-mirror>0</strong>
								</div>
								<div class="inner" style="padding-top: 0px;">
									<form class="metodo-visa steps" autocomplete="off" id="formvisa">
										<div>
											<p style="font-size: 12px;">Retira entre S/
												<span id="minAmountVisa"></span> y S/ <span id="maxAmountVisa"></span> hasta en
												<span id="maxRequestPerDayVisa"></span>
												transacciones diarias.<br>Retiro m�ximo
												semanal S/ <span id="maxAmountPerWeekVisa"></span>.</p>
										</div>
										<div class="step"><i>1</i>Ingresa el monto a retirar
											<div class="form-item ispad15" id="divMontoVisa">
												<div class="input">
													<label>Monto en S/</label>
													<input class="is-numeric" type="text" name="iamount" maxlength="10" id="amountVisa" data-min="0" data-max="0" data-valid="amount">
												</div>
												<div class="input__error" id="msgErrorRangoMontosVisa"></div>
											</div>
										</div>

										<!--  Pedir DNI VSA -->
										<div id="divStepDNI" class="step hidden"><i>2</i>
											<div class="fileup-image" id="divImgDni">
												<span id="stateDniPEN" style="display: none;">Registra tu DNI,
													por �nica vez, adjuntando el lado que
													muestra tu foto. (max <span id="pesoImgDni"></span>MB)</span>
												<label id="stateDniPENLabel" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
													<input class="upimage is-simple" type="file" name="iimage_1" id="imgDNI" accept="image/jpeg, image/png" data-valid="required">
													<canvas id="canvasDNI" style="display: none;"></canvas>
												</label>
												<span id="stateDniACT" style="display: none; line-height: 16px; margin-bottom: 10px;">
													<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
													<span style="vertical-align: top;">Tu DNI est� registrado</span>
												</span>
												<span id="stateDniACTLabel" style="display: none;">
													<span>�Quieres actualizarlo?</span>
													<a id="updateDNI" style="text-decoration: underline; color: #e30613;">hazlo aqu�</a>
												</span>
												<div class="filenames empty" id="filenamesDniVisa"><span class="filename-empty">No se adjunt� ninguna imagen</span>
													<div class="filename-simple"></div>
												</div>
											</div>
										</div>

										<div class="step"><i id="stepCard">2</i>Selecciona o a�ade tu tarjeta
											<div class="form_visa" id="divVisa">
												<img class="form_visa_logo" src="layer-view-image/client/icon_visa.png">
												<label class="form_visa_card_button" id="visaCardButton" onclick="showTokenization()" style="padding: 0px 30px;">Seleccionar
													<input type="hidden" id="txtTarjetaTokenizada" data-valid="required">
												</label>
												<span class="form_visa_card_mask hidden" id="visaCardText">
													<img src="layer-view-image/client/icon-valid.svg" width="16" height="16">
													<span id="tarjetaTokenizada"></span>
												</span>
											</div>

											<div class="subcontent-comision hidden">
												<p class="subcontent-text-comision" id="comision_visanet"><span class="monto-comision-visanet" id="monto_comision_visanet"></span></p>
											</div>
										</div>

										<div class="step hidden" id="stepKYCVisa"><i id="stepCardSDKVisa">3</i>Verifica tus datos
											por �nica vez cada 36 meses, si tus datos son
											correctos.
											<div class="form_visa" id="divVisaKYC">
												<img class="form_visa_logo" src="layer-view-image/client/icon_dni.png?v=3" style="margin-left: 5px; margin-top: -10px; margin-right:32px;">
												<label class="form_visa_card_button" id="visaSDKCardButton" style="padding: 0px 12px !important; font-size: 10px !important;" onclick="showSDK()">VERIFICA TU
													IDENTIDAD
													<input type="hidden" id="txtVisaSDKVerificado" data-valid="required">
												</label>

												<span class="form_visa_card_mask hidden" id="visaSDKCardText">
													<img id="iconKyc" src="layer-view-image/client/icon-valid.svg" width="16" height="16">
													<span class="span_mensaje_verificado" id="visaSDKVerificado"></span>
													<span id="visaSDKBtn" style="cursor: pointer;" class="verificarKYC"><u>Clic aqu�
														para actualizar</u></span>
												</span>
												<!-- 	<button type="button" id="consultResultKyc1" class = "btn-verificar" >Verificar</button> -->
											</div>
											<div style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">
												Deber�s permitir el acceso a tu c�mara para
												realizar la verificaci�n.</div>
										</div>

										<div class="step" style="margin-top: 5px;font-size: 14px;">Una vez
											confirmado tu retiro se har� el abono a tu
											tarjeta en menos de 30 minutos. Si tienes
											tarjeta de cr�dito, esto puede tomar 2 d�as
											adicionales.</div>

										<button class="btn btn-solicitar">Solicitar
											Retiro</button>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- fin del nuevo Modal -->

				<!-- Nuevo modal para retiro transferencia -->
				<div class="ioverlay" id="modal-retiro-transferencia" style="display:none;">
					<div class="modal is-iframe full">
						<div class="ipremio in-iframe">
							<div class="ipremio__head ipremio__head--retiro-pdv">
								<div class="retiro-pdv__headbar">
									<span class="ipremio__title">
										<a class="ipremio__title-link" href="#"
											onclick="if (typeof simpleModal !== 'undefined') simpleModal.onToggleModalMsg('#modal-premios'); return false;"
											aria-label="Volver">
											<span class="ipremio__title-icon" aria-hidden="true">&lt;</span>
											<span class="ipremio__title-text">Solicitar retiro</span>
										</a>
									</span>
									<div class="modal__close iclose" aria-label="Cerrar">
										<span class="icon-cerrar" aria-hidden="true"></span>
									</div>
								</div>

								<div class="retiro-pdv__headline">Monto a retirar</div>

								<div class="retiro-pdv__iconbox" aria-hidden="true">
									<img class="retiro-pdv__icon"
										src="<c:url value='/layer-view-image/v2/icono-transferencia.png'/>" alt="" />
								</div>
							</div>

							<div class="ipremio__body">
								<div class="title-method">Transferencia Bancaria </div>
								<div class="retiro-disponible" aria-label="Disponible para retirar">
									<img class="retiro-disponible__icon" width="20" height="20"
										src="<c:url value='/layer-view-image/v2/disponible-retirar-2.svg'/>" alt=""
										aria-hidden="true" />
									<span class="retiro-disponible__label">Disponible para retirar:</span>
									<strong class="retiro-disponible__amount" data-saldo-liquidable-mirror>0</strong>
								</div>
<div class="inner"
																style="padding-top: 3px; padding-right: 0px; padding-left: 0px; width: 100%;">
																<div id="divTransRangos" style="margin-top: 0px;">

																</div>
																<form class="metodo-transferencia steps"
																	autocomplete="off" id="formtransferencia"
																	style="padding-right: 6.66667%; padding-left: 6.66667%;">
																	<div class="step"><i style="top: 8px;">1</i>
																		<div class="form-item ispad15"
																			style="padding-top: 0px;"
																			id="divMontoTransferencia">
																			<div class="input">
																				<label>Ingresa monto en S/</label>
																				<input class="is-numeric" type="text"
																					name="iamount" maxlength="10"
																					id="amountTransferencia"
																					data-valid="amount" />
																			</div>
																			<div class="input__error"
																				id="msgErrorRangoMontosTransferencia">
																			</div>
																		</div>
																	</div>

																	<div class="step hidden"
																		id="stepRecurrentesTransferencia">
																		<i>2</i>Selecciona tu cuenta de ahorros
																		<div id="listaCuentaAhorros"
																			class="group-radio">


																		</div>
																		<div class="addcard"
																			onclick="desactivarPantallaRecurrenteTransferencia()"
																			style="color:#e30613;font-family: Roboto, sans-serif;font-size: 12px; font-weight: 400;">
																			Usa otra cuenta de ahorros</div>
																	</div>

																	<div class="step" id="stepBancoTransferencia"><i
																			style="top: 8px;">2</i>
																		<div class="form-item ispad15"
																			style="padding-top: 0px;" id="divBanco">
																			<div class="select">
																				<div class="opt-control"></div>
																				<select class="bybank" name="ibanco"
																					id="ibanco" data-valid="required">
																					<!-- 											<option value="">Selecciona un banco</option> -->
																					<!-- 											<option value="1">Interbank</option> -->
																					<!-- 											<option value="2">BCP. Banco de Cr�dito del Per�</option> -->
																					<!-- 											<option value="3">BBVA. Banco Continental</option> -->
																					<!-- 											<option value="4">Scotiabank</option> -->
																					<!-- 											<option value="5">Otro banco - usa tu CCI (c�digo interbancario)</option> -->
																				</select>
																			</div>
																		</div>
																	</div>

																	<div class="step" id="stepCuentaTransferencia"><i
																			style="top: 8px;">3</i>
																		<div class="form-item ispad15"
																			style="padding-top: 0px;" id="divCuenta">
																			<div class="input">
																				<label>Ingresa tu n�mero de
																					cuenta</label>
																				<input class="is-numeric" type="tel"
																					name="inumacount" id="inumacount"
																					maxlength="20" data-min="20"
																					data-max="20"
																					data-valid="account" />
																			</div>
																			<div class="input__error">INGRESA UN N�MERO
																				DE CUENTA CORRECTO</div>
																		</div>
																	</div>

																	<!-- Pedir DNI Transferencia -->
																	<div id="divStepDNITransferencia"
																		class="step hidden"><i
																			id="stepDniTransferencia">4</i>
																		<div class="fileup-image"
																			id="divImgDniTransferencia">
																			<span id="stateDniPENTransferencia"
																				style="display: none;">Adjunta, por
																				�nica vez, la foto de tu DNI por el lado
																				que muestra tu rostro (max <span
																					id="pesoImgDniTransferencia"></span>MB)</span>
																			<label id="stateDniPENLabelTransferencia"
																				class="btn is-secondary img-simple"
																				style="margin-top: 16px; display: none;"><span
																					class="text">Subir imagen</span>
																				<input class="upimage is-simple"
																					type="file" name="iimage_1"
																					id="imgDNITransferencia"
																					accept="image/jpeg, image/png"
																					data-valid="required">
																				<canvas id="canvasDNITransferencia"
																					style="display: none;"></canvas>
																			</label>
																			<span id="stateDniACTTransferencia"
																				style="display: none; line-height: 16px; margin-bottom: 10px;">
																				<img src="layer-view-image/client/icon-valid.svg"
																					width="20" height="20">
																				<span style="vertical-align: top;">La
																					foto de tu DNI ya esta
																					registrado</span>
																			</span>
																			<span id="stateDniACTLabelTransferencia"
																				style="display: none;">
																				<span>�Quieres actualizarlo?</span>
																				<a id="updateDNITransferencia"
																					style="text-decoration: underline; color: #e30613;">
																					hazlo aqu�
																				</a>
																			</span>
																			<div class="filenames empty"
																				id="filenamesDniTransferencia"><span
																					class="filename-empty">No se adjunt�
																					ninguna imagen</span>
																				<div class="filename-simple"></div>
																			</div>
																		</div>

																	</div>

																	<div id="divStepDeparmentTransferencia"
																		class="step"><i
																			id="stepDeparmentTransferencia">4</i>Selecciona
																		el departamento donde abriste tu cuenta
																		<div class="form-item ispad15"
																			id="divDepartamento">
																			<div class="select">
																				<div class="opt-control"></div>
																				<select name="ideparment"
																					id="ideparment"
																					data-valid="required"
																					onchange="if(enviarDataLayer) datalayerCobrarPremioMetodoCobroSelect(this,'Seleccionar departamento')">
																					<option value="">Selecciona un
																						departamento</option>
																					<option value="1">Amazonas</option>
																					<option value="2">�ncash</option>
																					<option value="3">Apur�mac</option>
																					<option value="4">Arequipa</option>
																					<option value="5">Ayacucho</option>
																					<option value="6">Cajamarca</option>
																					<option value="7">Callao</option>
																					<option value="8">Cuzco</option>
																					<option value="9">Huancavelica
																					</option>
																					<option value="10">Hu�nuco</option>
																					<option value="11">Ica</option>
																					<option value="12">Jun�n</option>
																					<option value="13">La Libertad
																					</option>
																					<option value="14">Lambayeque
																					</option>
																					<option value="15">Lima</option>
																					<option value="16">Loreto</option>
																					<option value="17">Madre de Dios
																					</option>
																					<option value="18">Moquegua</option>
																					<option value="19">Pasco</option>
																					<option value="20">Piura</option>
																					<option value="21">Puno</option>
																					<option value="22">San Mart�n
																					</option>
																					<option value="23">Tacna</option>
																					<option value="24">Tumbes</option>
																					<option value="25">Ucayali</option>
																				</select>
																			</div>
																		</div>
																		<!--  <div style="margin-top: 10px; font-weight: 700; font-size: 10px; text-align: justify;">Aseg�rate de ser el titular de la cuenta y que los datos de tu cuenta de La Tinka sean iguales a los de tu cuenta bancaria. Caso contrario, tu retiro ser� rechazado.</div> -->
																		<!-- 									  <div style="margin-top: 10px; text-align: justify;">Una vez confirmado tu retiro, �ste ser� transferido a tu cuenta dentro de los siguientes 60 minutos, siempre que se confirme de lunes a viernes de 9:00 am a 7:00 pm y s�bados de 9:00 am a 2:00 pm.</div> -->
																	</div>

																	<div class="step hidden" id="stepKYCTrans"><i
																			id="stepCardSDKTransferencia">5</i>Verifica
																		tus datos por �nica vez cada 36 meses, si tus
																		datos son correctos.
																		<div class="form_visa" id="divTransferenciaKYC">
																			<img class="form_visa_logo"
																				src="layer-view-image/client/icon_dni.png?v=3"
																				style="margin-left: 5px; margin-top: -10px; margin-right: 32px;">
																			<label class="form_visa_card_button"
								 												id="transferenciaSDKCardButton"
																				style="padding: 0px 12px !important; font-size: 10px !important;"
																				onclick="showSDK()">VERIFICA TU
																				IDENTIDAD
																				<input type="hidden"
																					id="txtTransferenciaSDKVerificado"
																					data-valid="required">
																			</label>

																			<span class="form_visa_card_mask hidden"
																				id="sdkTransferenciaCardText">
																				<img id="iconKycT"
																					src="layer-view-image/client/icon-valid.svg"
																					width="16" height="16">
																				<span class="span_mensaje_verificado"
																					id="transferenciaSDKVerificado"></span>
																				<span id="transferenciaSDKBtn"
																					style="cursor: pointer;"
																					class="verificarKYC"><u>Clic aqu�
																						para actualizar</u></span>
																			</span>
																			<!-- 		                                	<button type="button" id="consultResultKyc3" class = "btn-verificar" >Verificar</button> -->
																		</div>
																		<div
																			style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">
																			Deber�s permitir el acceso a tu c�mara para
																			realizar la verificaci�n.</div>

																	</div>

																	<div class="step"
																		style="margin-top: 5px; font-size: 10px; font-weight: 700; ">
																		Aseg�rate de ser el titular de la cuenta y que
																		los datos de tu cuenta de La Tinka sean iguales
																		a los de tu cuenta bancaria. Caso contrario, tu
																		retiro ser� rechazado.</div>
																	<button class="btn btn-solicitar">Solicitar
																		Retiro</button>
																</form>
															</div>
														</div>
													</li>

												</ul>

											</div>
												<!-- 1.1 Inicio Jhon Conopuma - 2026-03-06 - Tab Historial: filtros, lista, paginación y vacío -->
												<div id="tab-historial" class="tab-content">
												<div class="ta-historial">
														<!-- 1.6 Inicio Jhon Conopuma - 2026-03-06 - Cabecera fija de Historial: título "Estado de solicitud" + control "Mostrar filas" -->
														<div class="ta-historial__header" aria-label="Cabecera de historial de retiros">
															<div class="ta-historial__heading">Estado de solicitud</div>
															<label class="ta-rows ta-rows--header">
																<span class="ta-rows__label">Mostrar filas</span>
																<select id="taHistRows">
																	<option value="15" selected>15</option>
																</select>
															</label>
														</div>
														<!-- 1.6 Fin Jhon Conopuma -->

													<div class="ta-historial__filters" aria-label="Filtros de historial de retiros">
															<button type="button" class="ta-chip ta-chip--active" data-ta-chip="lastWeek" aria-pressed="true">&Uacute;ltima semana</button>
															<button type="button" class="ta-chip ta-chip--search" id="taHistSearchBtn" data-ta-chip="search" aria-pressed="false">Fecha y/o Tipo de b&uacute;squeda</button>
													</div>

														<!-- 1.2 Inicio Jhon Conopuma - 2026-03-06 - Panel avanzado: filtros por fecha y tipo de retiro (multi-selección) -->
														<div class="ta-advanced" id="taAdvancedFilters" aria-hidden="true">
															<!-- 1.7 Inicio Jhon Conopuma - 2026-03-06 - Texto guía con énfasis en "30 días" -->
															<div class="ta-advanced__hint">Filtra tu b&uacute;squeda en un rango de <strong>30 d&iacute;as</strong> como m&aacute;ximo, hasta con 2 a&ntilde;os de antig&uuml;edad.</div>
															<!-- 1.7 Fin Jhon Conopuma -->
															<div class="ta-advanced__dates">
																<div class="form-item">
																	<div class="ta-dateLabel">Desde:</div>
																	<div class="input is-calendar">
																		<input type="text" id="taStartDate" name="taStartDate" autocomplete="off" inputmode="numeric" maxlength="10" placeholder="dd/mm/aaaa">
																	</div>
																</div>
																<div class="form-item">
																	<div class="ta-dateLabel">Hasta:</div>
																	<div class="input is-calendar">
																		<input type="text" id="taEndDate" name="taEndDate" autocomplete="off" inputmode="numeric" maxlength="10" placeholder="dd/mm/aaaa">
																	</div>
																</div>
															</div>

															<div class="ta-methods" role="group" aria-label="Tipo de retiro">
																<label class="ta-method">
																	<input type="checkbox" name="taMethod" value="cash">
																	<span class="ta-method__box" aria-hidden="true"></span>
																	<span class="ta-method__text">Efectivo</span>
																</label>
																<label class="ta-method">
																	<input type="checkbox" name="taMethod" value="transfer">
																	<span class="ta-method__box" aria-hidden="true"></span>
																	<span class="ta-method__text">Transferencia</span>
																</label>
																<label class="ta-method">
																	<input type="checkbox" name="taMethod" value="visa">
																	<span class="ta-method__box" aria-hidden="true"></span>
																	<span class="ta-method__text">Visa</span>
																</label>
															</div>
														</div>
														<!-- 1.2 Fin Jhon Conopuma -->

													<button type="button" class="ta-states" aria-label="Estados de retiro">
														<span class="ta-states__icon" aria-hidden="true"></span>
														<span class="ta-states__text">Estados de retiro</span>
														<span class="ta-states__chev" aria-hidden="true"></span>
													</button>

													<div class="ta-historial__list">
														<div class="items" id="ta-items-hispayment" data-show-items="15">
															<!-- Mock estructural (se reemplaza por JS en el 2do paso) -->
																	<button type="button" class="ta-hist-item" aria-label="Detalle de retiro">
																<div class="ta-hist-item__top">
																	<div class="ta-hist-item__left">
																		<div class="ta-hist-item__title">Efectivo / Punto de Venta</div>
																		<span class="ta-badge ta-badge--pending">Pendiente</span>
																	</div>
																	<div class="ta-hist-item__right">
																		<div class="ta-hist-item__amount">S/ 100</div>
																		<span class="ta-hist-item__chev" aria-hidden="true"></span>
																	</div>
																</div>
																	<div class="ta-hist-item__meta"><span>Solicitud N&deg; 5623567</span><span>20 Octubre</span></div>
																</button>
																<button type="button" class="ta-hist-item" aria-label="Detalle de retiro">
																<div class="ta-hist-item__top">
																	<div class="ta-hist-item__left">
																		<div class="ta-hist-item__title">Transferencia Bancaria</div>
																		<span class="ta-badge ta-badge--paid">Abonado</span>
																	</div>
																	<div class="ta-hist-item__right">
																		<div class="ta-hist-item__amount">S/ 100</div>
																		<span class="ta-hist-item__chev" aria-hidden="true"></span>
																	</div>
																</div>
																	<div class="ta-hist-item__meta"><span>Solicitud N&deg; 5623567</span><span>16 Octubre</span></div>
																</button>
														</div>

														<div class="pagination" id="ta-pagination-items-hispayment">
															<div class="pages"></div>
															<a class="prev is-disabled" href=""><i class="icon-regresar"></i></a>
															<a class="next" href=""><i class="icon-siguiente"></i></a>
														</div>

														<div id="ta-sin-retiros" class="ta-historial__empty" style="display:none;">
															A&uacute;n no has hecho ning&uacute;n retiro
														</div>
													</div>
												</div>
												<!-- 1.1 Fin Jhon Conopuma -->
											</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<!-- Nuevo modal para retiro efectivo -->

				<div class="ioverlay" id="modal-retiro-efectivo-pdv" style="display:none;">
					<div class="modal is-iframe full">
						<div class="ipremio in-iframe">
							<div class="ipremio__head ipremio__head--retiro-pdv">
								<div class="retiro-pdv__headbar">
									<span class="ipremio__title">
										<a class="ipremio__title-link" href="#"
											onclick="if (typeof simpleModal !== 'undefined') simpleModal.onToggleModalMsg('#modal-premios'); return false;"
											aria-label="Volver">
											<span class="ipremio__title-icon" aria-hidden="true">&lt;</span>
											<span class="ipremio__title-text">Solicitar retiro</span>
										</a>
									</span>
									<div class="modal__close iclose" aria-label="Cerrar">
										<span class="icon-cerrar" aria-hidden="true"></span>
									</div>
								</div>

								<div class="retiro-pdv__headline">Monto a retirar</div>

								<div class="retiro-pdv__iconbox" aria-hidden="true">
									<img class="retiro-pdv__icon"
										src="<c:url value='/layer-view-image/v2/icono-efectivo.png'/>" alt="" />
								</div>
							</div>

							<div class="ipremio__body">
								<div class="title-method">Efectivo / Puntos de Venta</div>
								<button class="btn btn-solicitar" type="button" disabled>Solicitar retiro</button>
							</div>
						</div>
					</div>
				</div>

				<!-- fin del nuevo Modal -->

				<!-- Nuevo modal para retiro tarjeta -->
				<div class="ioverlay" id="modal-retiro-tarjeta" style="display:none;">
				<div class="modal is-iframe full">
						<div class="ipremio in-iframe">
							<div class="ipremio__head ipremio__head--retiro-pdv">
								<div class="retiro-pdv__headbar">
									<span class="ipremio__title">
										<a class="ipremio__title-link" href="#"
											onclick="if (typeof simpleModal !== 'undefined') simpleModal.onToggleModalMsg('#modal-premios'); return false;"
											aria-label="Volver">
											<span class="ipremio__title-icon" aria-hidden="true">&lt;</span>
											<span class="ipremio__title-text">Solicitar retiro</span>
										</a>
									</span>
									<div class="modal__close iclose" aria-label="Cerrar">
										<span class="icon-cerrar" aria-hidden="true"></span>
									</div>
								</div>

								<div class="retiro-pdv__headline">Monto a retirar</div>

								<div class="retiro-pdv__iconbox" aria-hidden="true">
									<img class="retiro-pdv__icon"
										src="<c:url value='/layer-view-image/v2/icono-visa.png'/>" alt="" />
								</div>
							</div>

							<div class="ipremio__body">
								<div class="title-method">Tarjeta de cr�dito / d�bito</div>
								<button class="btn btn-solicitar" type="button" disabled>Solicitar retiro</button>
							</div>
						</div>
					</div>
				</div>
				<!-- fin del nuevo Modal -->

				<!-- Nuevo modal para retiro transferencia -->
				<div class="ioverlay" id="modal-retiro-transferencia" style="display:none;">
					<div class="modal is-iframe full">
						<div class="ipremio in-iframe">
							<div class="ipremio__head ipremio__head--retiro-pdv">
								<div class="retiro-pdv__headbar">
									<span class="ipremio__title">
										<a class="ipremio__title-link" href="#"
											onclick="if (typeof simpleModal !== 'undefined') simpleModal.onToggleModalMsg('#modal-premios'); return false;"
											aria-label="Volver">
											<span class="ipremio__title-icon" aria-hidden="true">&lt;</span>
											<span class="ipremio__title-text">Solicitar retiro</span>
										</a>
									</span>
									<div class="modal__close iclose" aria-label="Cerrar">
										<span class="icon-cerrar" aria-hidden="true"></span>
									</div>
								</div>

								<div class="retiro-pdv__headline">Monto a retirar</div>

								<div class="retiro-pdv__iconbox" aria-hidden="true">
									<img class="retiro-pdv__icon"
										src="<c:url value='/layer-view-image/v2/icono-transferencia.png'/>" alt="" />
								</div>
							</div>

							<div class="ipremio__body">
								<div class="title-method">Tarjeta de cr�dito / d�bito</div>
								<button class="btn btn-solicitar" type="button" disabled>Solicitar retiro</button>
							</div>
						</div>
					</div>
				</div>
				<!-- fin del nuevo Modal -->

				<div class="ioverlay" id="modal-pm">
					<div class="modal-dialog modal-fullscreen">
						<div class="ipremio in-iframe">
							<div class="ipremio__head">Retirar premios
								<div class="modal__close iclose"><span class="icon-cerrar icon-cerrar-token"
										style="display: none;"></span></div>
							</div>
							<div class="ipremio__body">
								<ul class="accordion record">
									<li class="accordion__item opened is-modal" style="margin-bottom: 0px;">
										<div class="accordion__body">
											<div class="inner">
												<div class="back"><a href="#" toggle-modal="#modal-premios">Volver</a>
												</div>
												<div class="record__content"
													style="border: 1px solid #E2E2E2; margin-top: 18px; padding-top: 0px;">
													<div>
														<div class="inner"
															style="padding-top: 7px; padding-right: 0px; padding-left: 0px; width: 100%;">
															<table style="width: 100%;">
																<tbody>
																	<tr>
																		<td
																			style="vertical-align: text-top; width: 30%;">
																			<div style="margin-top: -12px;"
																				id="logoProductoPPML"></div>
																		</td>
																		<td style="text-align: right; width: 70%;">
																			<span
																				style="padding-right: 6.66667%; font-family: Avenir; font-weight: 900; font-size: 18px;"
																				id="monto_base"></span><br>
																			<span
																				style="font-size: 14px; float: left;">Impuesto
																				(10%): S/ </span><span
																				style="padding-right: 6.66667%; font-size: 14px;"
																				id="impuesto"></span><br>
																			<span
																				style="font-size: 14px; font-weight: 700; float: left;">Monto
																				a cobrar: S/ </span><span
																				style="padding-right: 6.66667%; font-size: 14px; font-weight: 700;"
																				id="neto"></span>
																			<span
																				style="font-size: 14px; font-weight: 700; float: left;"
																				id="txtJugadasGratis">Jugadas
																				gratis:</span><span
																				style="padding-right: 6.66667%; font-size: 14px; font-weight: 700;"
																				id="lblJugadasGratis"></span>
																		</td>
																	</tr>
																</tbody>
															</table>
															<div
																style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;">
																<p style="padding-right: 6.66667%;padding-left: 6.66667%;"
																	id="lblConsideraciones">Por tu seguridad, un
																	representante de La Tinka se contactar� contigo para
																	coordinar tu pago que se realizar� en un plazo
																	m�ximo de 30 d�as</p>
															</div>
															<form class="metodo-transferencia steps" autocomplete="off"
																id="formtransferenciapml"
																style="padding-right: 6.66667%; padding-left: 6.66667%; margin-top: 75px;">

																<!--                       				<div style="display: inline; vertical-align: middle;"> -->
																<!--                       					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24" style="margin-left: -20px; height: 50px;"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><path class="ico-line" style="fill: #07663a;" d="M16,19.45a.35.35,0,0,1-.25-.1l-.71-.71-.7.7a.36.36,0,0,1-.49,0l-.7-.7-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.77-.77a.51.51,0,0,1-.15-.37V6.07a.51.51,0,0,1,.15-.37l.76-.76a.36.36,0,0,1,.49,0l.65.65.65-.65a.36.36,0,0,1,.49,0l.65.65L12,4.94a.36.36,0,0,1,.49,0l.65.65.7-.7a.36.36,0,0,1,.49,0l.7.7.71-.71A.34.34,0,0,1,16,4.79a.35.35,0,0,1,.24.09l.82.82a.51.51,0,0,1,.15.37v12.1a.51.51,0,0,1-.15.37l-.82.82A.35.35,0,0,1,16,19.45Zm-1-1.41a.35.35,0,0,1,.24.1l.46.46a.36.36,0,0,0,.5,0l.44-.44V6.07l-.44-.44a.36.36,0,0,0-.5,0l-.46.46a.36.36,0,0,1-.49,0l-.45-.45a.36.36,0,0,0-.25-.1.35.35,0,0,0-.25.1l-.45.45a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.38.38V18.16l.38.38a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.45.45a.36.36,0,0,0,.5,0l.45-.45A.34.34,0,0,1,15.07,18Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,8.62a.26.26,0,1,1,0-.53h2.7a.26.26,0,0,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,11.16a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,13.7a.26.26,0,1,1,0-.53H13.4a.26.26,0,1,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,16.24a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"></path></g></g></svg> -->
																<!--                       					<p style="vertical-align: top; display: inline; font-size: 12px; margin-left: -15px;" id="ticketId"></p> -->
																<!--                       					<p style="font-size: 12px; text-align: right;vertical-align: top; display: inline; float: right; margin-top: 20px; color: #ff2123; font-weight: 600;" id="fechaExpiracion"></p> -->
																<!--                       				</div> -->

																<table>
																	<tr>
																		<td style="width: 5%;" onclick="verTicket()">
																			<svg xmlns="http://www.w3.org/2000/svg"
																				viewBox="0 0 24.24 24.24"
																				style="margin-left: -20px; height: 50px;">
																				<g id="Capa_2" data-name="Capa 2">
																					<g id="Capa_2-2" data-name="Capa 2">
																						<path class="ico-line"
																							style="fill: #07663a;"
																							d="M16,19.45a.35.35,0,0,1-.25-.1l-.71-.71-.7.7a.36.36,0,0,1-.49,0l-.7-.7-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.77-.77a.51.51,0,0,1-.15-.37V6.07a.51.51,0,0,1,.15-.37l.76-.76a.36.36,0,0,1,.49,0l.65.65.65-.65a.36.36,0,0,1,.49,0l.65.65L12,4.94a.36.36,0,0,1,.49,0l.65.65.7-.7a.36.36,0,0,1,.49,0l.7.7.71-.71A.34.34,0,0,1,16,4.79a.35.35,0,0,1,.24.09l.82.82a.51.51,0,0,1,.15.37v12.1a.51.51,0,0,1-.15.37l-.82.82A.35.35,0,0,1,16,19.45Zm-1-1.41a.35.35,0,0,1,.24.1l.46.46a.36.36,0,0,0,.5,0l.44-.44V6.07l-.44-.44a.36.36,0,0,0-.5,0l-.46.46a.36.36,0,0,1-.49,0l-.45-.45a.36.36,0,0,0-.25-.1.35.35,0,0,0-.25.1l-.45.45a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.38.38V18.16l.38.38a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.45.45a.36.36,0,0,0,.5,0l.45-.45A.34.34,0,0,1,15.07,18Z">
																						</path>
																						<path class="ico-line"
																							style="fill: #07663a;"
																							d="M9.68,8.62a.26.26,0,1,1,0-.53h2.7a.26.26,0,0,1,0,.53Z">
																						</path>
																						<path class="ico-line"
																							style="fill: #07663a;"
																							d="M9.68,11.16a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z">
																						</path>
																						<path class="ico-line"
																							style="fill: #07663a;"
																							d="M9.68,13.7a.26.26,0,1,1,0-.53H13.4a.26.26,0,1,1,0,.53Z">
																						</path>
																						<path class="ico-line"
																							style="fill: #07663a;"
																							d="M9.68,16.24a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z">
																						</path>
																					</g>
																				</g>
																			</svg>
																		</td>
																		<td><span id="ticketId" onclick="verTicket()"
																				style="font-size: 12px; margin-left: -10px;"></span>
																		</td>
																		<td><span id="fechaExpiracion"
																				style="font-size: 12px; float: right; color: #ff2123; font-weight: 600;"></span>
																		</td>
																	</tr>
																</table>
																<div class="step hidden"
																	id="stepRecurrentesTransferenciaPML">
																	<i>1</i>Selecciona tu cuenta de ahorros
																	<div id="listaCuentaAhorrosPML" class="group-radio">
																	</div>
																	<div class="addcard"
																		onclick="desactivarPantallaRecurrenteTransferenciaPML()"
																		style="color:#e30613;font-family: Roboto, sans-serif;font-size: 12px; font-weight: 400;">
																		Usa otra cuenta de ahorros</div>
																</div>

																<div class="step" id="stepBancoTransferenciaPML"><i
																		style="top: 8px;">1</i>
																	<div class="form-item ispad15"
																		style="padding-top: 0px;" id="divBancoPML">
																		<div class="select">
																			<div class="opt-control"></div>
																			<select class="bybank" name="ibancoPML"
																				id="ibancoPML" data-valid="required">
																			</select>
																		</div>
																	</div>
																</div>

																<div class="step" id="stepCuentaTransferenciaPML"><i
																		style="top: 8px;">2</i>
																	<div class="form-item ispad15"
																		style="padding-top: 0px;" id="divCuentaPML">
																		<div class="input">
																			<label>Ingresa tu n�mero de cuenta</label>
																			<input class="is-numeric" type="tel"
																				name="inumacountPML" id="inumacountPML"
																				maxlength="20" data-min="20"
																				data-max="20" data-valid="account" />
																		</div>
																		<div class="input__error">INGRESA UN N�MERO DE
																			CUENTA CORRECTO</div>
																	</div>
																</div>

																<!-- Pedir DNI Premio Mayor -->
																<div id="divStepDNITransferenciaPML"
																	class="step hidden"><i
																		id="stepDniTransferenciaPML">3</i>
																	<div class="fileup-image"
																		id="divImgDniTransferenciaPML">
																		<span id="stateDniPENTransferenciaPML"
																			style="display: none;">Adjunta, por �nica
																			vez, la foto de tu DNI por el lado que
																			muestra tu rostro (max <span
																				id="pesoImgDniTransferenciaPML"></span>MB)</span>
																		<label id="stateDniPENLabelTransferenciaPML"
																			class="btn is-secondary img-simple"
																			style="margin-top: 16px; display: none;"><span
																				class="text">Subir imagen</span>
																			<input class="upimage is-simple" type="file"
																				name="iimage_1"
																				id="imgDNITransferenciaPML"
																				accept="image/jpeg, image/png"
																				data-valid="required">
																			<canvas id="canvasDNITransferenciaPML"
																				style="display: none;"></canvas>
																		</label>
																		<span id="stateDniACTTransferenciaPML"
																			style="display: none; line-height: 16px; margin-bottom: 10px;">
																			<img src="layer-view-image/client/icon-valid.svg"
																				width="20" height="20">
																			<span style="vertical-align: top;">La foto
																				de tu DNI ya esta registrado</span>
																		</span>
																		<span id="stateDniACTLabelTransferenciaPML"
																			style="display: none;">
																			<span>�Quieres actualizarlo?</span>
																			<a id="updateDNITransferenciaPML"
																				style="text-decoration: underline; color: #e30613;">
																				hazlo aqu�
																			</a>
																		</span>
																		<div class="filenames empty"
																			id="filenamesDniTransferenciaPML"><span
																				class="filename-empty">No se adjunt�
																				ninguna imagen</span>
																			<div class="filename-simple"></div>
																		</div>
																	</div>

																</div>

																<div id="divStepSDKPML" class="step hidden"><i
																		id="stepSDKPML">3</i>Verifica tus datos por
																	�nica vez cada 36 meses, si tus datos son correctos.
																	<div class="form_visa" id="divPMKYC">
																		<img class="form_visa_logo"
																			src="layer-view-image/client/icon_dni.png?v=3"
																			style="margin-left: 5px; margin-top: -10px; margin-right: 38px;">
																		<label class="form_visa_card_button"
																			id="PMSDKCardButton"
																			onclick="showSDK()">VERIFICA TU IDENTIDAD
																			<input type="hidden" id="txtPMSDKVerificado"
																				data-valid="required">
																		</label>

																		<span class="form_visa_card_mask hidden"
																			id="sdkPMCardText">
																			<img id="iconKycPM"
																				src="layer-view-image/client/icon-valid.svg"
																				width="16" height="16">
																			<span class="span_mensaje_verificado"
																				id="PMSDKVerificado"></span>
																			<span id="PMSDKBtn" style="cursor: pointer;"
																				class="verificarKYC"><u>Clic aqu� para
																					actualizar</u></span>
																		</span>
																		<!-- 		                                	<button type="button" id="consultResultKyc3" class = "btn-verificar" >Verificar</button> -->
																	</div>
																	<div
																		style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">
																		Deber�s permitir el acceso a tu c�mara para
																		realizar la verificaci�n.</div>

																</div>

																<div id="divStepDeparmentTransferenciaPML" class="step">
																	<i
																		id="stepDeparmentTransferenciaPML">4</i>Selecciona
																	el departamento donde abriste tu cuenta
																	<div class="form-item ispad15"
																		id="divDepartamentoPML">
																		<div class="select">
																			<div class="opt-control"></div>
																			<select name="ideparmentPML"
																				id="ideparmentPML"
																				data-valid="required">
																				<option value="">Selecciona un
																					departamento</option>
																				<option value="1">Amazonas</option>
																				<option value="2">�ncash</option>
																				<option value="3">Apur�mac</option>
																				<option value="4">Arequipa</option>
																				<option value="5">Ayacucho</option>
																				<option value="6">Cajamarca</option>
																				<option value="7">Callao</option>
																				<option value="8">Cuzco</option>
																				<option value="9">Huancavelica</option>
																				<option value="10">Hu�nuco</option>
																				<option value="11">Ica</option>
																				<option value="12">Jun�n</option>
																				<option value="13">La Libertad</option>
																				<option value="14">Lambayeque</option>
																				<option value="15">Lima</option>
																				<option value="16">Loreto</option>
																				<option value="17">Madre de Dios
																				</option>
																				<option value="18">Moquegua</option>
																				<option value="19">Pasco</option>
																				<option value="20">Piura</option>
																				<option value="21">Puno</option>
																				<option value="22">San Mart�n</option>
																				<option value="23">Tacna</option>
																				<option value="24">Tumbes</option>
																				<option value="25">Ucayali</option>
																			</select>
																		</div>
																	</div>

																</div>

																<div class="step"
																	style="margin-top: 5px; font-size: 10px; font-weight: 700; ">
																	Aseg�rate de ser el titular de la cuenta y que los
																	datos de tu cuenta de La Tinka sean iguales a los de
																	tu cuenta bancaria. Caso contrario, tu retiro ser�
																	rechazado.</div>

																<button class="btn btn-solicitar">Solicitar</button>
															</form>
														</div>
													</div>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<!-- aca sale el historial de retiros -->

				<div class="ioverlay" id="modal-historial-sin-retiro">
					<div class="modal-dialog modal-fullscreen">
						<div class="ipremio in-iframe">
							<div class="ipremio__head">Retirar premios
								<div class="modal__close iclose"><span class="icon-cerrar icon-cerrar-token"
										style="display: none;"></span></div>
							</div>
							<div class="ipremio__body">
								<ul class="accordion record">
									<li class="accordion__item opened is-modal">
										<div class="accordion__body">
											<div class="inner">
												<div class="record__head">Historial de retiros</div>
												<div class="back"><a href="#" toggle-modal="#modal-premios">Volver a
														Retirar premios</a></div>
												<div class="record__content nofound">
													<div class="nofound__title">A�n no has hecho <br>ning�n retiro</div>
													<img class="nofound__img"
														src="layer-view-image/client/no-retiros.svg" alt="Sin retiros">
													<div class="nofound__alert">�Sigue jugando!</div>
													<div class="nofound__links"><a class="no-underline"
															href="game_kinelo_show_home.html"><span>Jugar
																Kinelo</span></a><a class="no-underline" href="#"
															onclick="toJuegosVirtuales('virtuales')"><span>Jugar
																Deportes Virtuales</span></a></div>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div id="popup" class="overlay" style="z-index: 211;">
					<div class="popup popup-sm">
						<a class="close js-close-modal" href="#">&times;</a>
						<div class="main-modal"></div>
					</div>
				</div>

				<div class="ioverlay" id="modal-listado">
					<div class="modal-dialog modal-fullscreen">
						<div class="ipremio in-iframe">
							<div class="ipremio__head">Retirar premios
								<div class="modal__close iclose"><span class="icon-cerrar icon-cerrar-token"
										style="display: none;"></span></div>
							</div>
							<div class="ipremio__body">
								<ul class="accordion record">
									<li class="accordion__item opened is-modal">
										<div class="accordion__body">
											<div class="inner">
												<div class="record__head">Historial de retiros</div>
												<div class="back"><a href="#" toggle-modal="#modal-premios">Volver a
														Retirar premios</a></div>
												<div class="record__content">
													<div class="filter">
														<div class="filter__title">Filtrar</div>
														<div class="filter__content">
															<form method="post" novalidate data-form-ajax>
																<div class="filter__clear">Borrar filtros</div>
																<div class="filter__mod">
																	<div class="filter__subtitle">Por fecha</div>
																	<div class="form-item">
																		<div class="select">
																			<label>Por fecha</label>
																			<div class="opt-control"></div>
																			<select class="bydate" name="name"
																				id="typeFilterHisPayment">
																				<option value="1">Ver todos</option>
																				<option value="2">La �ltima semana
																				</option>
																				<option value="3">El �ltimo mes</option>
																				<option value="4">Rango espec�fico
																				</option>
																			</select>
																		</div>
																	</div>
																</div>
																<div class="forrange">
																	<div class="form-item">
																		<div class="input is-calendar">
																			<label>Desde</label>
																			<input type="text" id="startdate"
																				name="startdate" autocomplete="off"
																				maxlength="10">
																		</div>
																	</div>
																	<div class="form-item">
																		<div class="input is-calendar">
																			<label>Hasta</label>
																			<input type="text" id="enddate"
																				name="enddate" autocomplete="off"
																				maxlength="10">
																		</div>
																	</div>
																</div>
																<button class="btn">Aplicar</button>
															</form>
														</div>
													</div>
													<div class="items" id="items-hispayment" data-show-items="4">

													</div>
													<div class="pagination" id="pagination-items-hispayment">
														<div class="pages"></div><a class="prev is-disabled" href=""><i
																class="icon-regresar"></i></a><a class="next" href=""><i
																class="icon-siguiente"></i></a>
													</div>
												</div>
											</div>
										</div>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>

				<div class="ioverlay" id="modal-ticket3">
					<div class="modal is-ticket">
						<div class="modal__close iclose"><span class="icon-cerrar icon-cerrar-token"
								style="display: none;"></span></div>
						<div class="modal__head">
							<ul>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>Cod. de Retiro: </strong></td>
												<td><span id="tkRequestNumberDebitIdQR"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>Fecha y hora: </strong></td>
												<td><span id="tkRequestDateHourDebitIdQR"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>ID: </strong></td>
												<td><span id="idClienteDebitIdQR"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>DNI: </strong></td>
												<td><span id="tkDocNumberDebitIdQR"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>Ganador: </strong></td>
												<td><span id="ganadorDebitIdQR"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
							</ul>
						</div>
						<div class="back" style="max-width: 712px; margin: 0px;"><a href="#"
								id="volverModalRetirosDebitIdQR" onclick="volverModalRetirosDebitIdQR()">Volver a
								retiros</a></div>
						<div class="content_loading">
							<div class="modal__body" style="padding-top: 0px;">
								<div>
									<div class="label-total">Monto de retiro:</div>
									<div class="total"><strong>Total: </strong>S/<span
											id="tkRequestAmountDebitIdQR"></span></div>
									<div class="codqr" id="items-tickets-payment-prizes-DebitIdQR">

									</div>
								</div>
							</div>

							<div class="modal__footer">
								<form class="form frm-newsletterDebitIdQR" action="downloadTicketsPPDebitIdQR.html"
									method="post" name="formDownloadDebitIdQR" id="formDownloadDebitIdQR">
									<input type="hidden" id="requestNumberPDFDebitIdQR" value="">
									<input type="hidden" id="requestDateHourPDFDebitIdQR" value="">
									<input type="hidden" id="docNumberPDFDebitIdQR" value="">
									<input type="hidden" id="requestAmountPDFDebitIdQR" value="">
									<input type="hidden" id="nombresPDFDebitIdQR" value="">
									<input type="hidden" id="clientIdPDFDebitIdQR" value="">
									<span class="down is-cian no-underline" style="margin-right: 0px;"><span
											onclick="downloadTicketsPPDebitIdQR()">Descargar</span></span>
									<div class="form-item is-sendmail">
										<button class="btn btn-sendemail"
											style="position: inherit; border-radius: 5px;">Enviar por email</button>
									</div>
								</form>
								<p>C�bralo en un punto de venta cercano presentando tu DNI.</p>
							</div>
						</div>
					</div>
				</div>

				<div class="ioverlay" id="modal-ticket2">
					<div class="modal is-ticket">
						<div class="modal__close iclose"><span class="icon-cerrar icon-cerrar-token"
								style="display: none;"></span></div>
						<div class="modal__head">
							<ul>
								<!--               <li><strong>Cod. de Retiro: </strong><span id="tkRequestNumber"></span></li> -->
								<!--               <li><strong>Fecha y hora: </strong><span id="tkRequestDateHour"></span></li> -->
								<!--               <li><strong>ID: </strong><span id="idCliente"></span></li> -->
								<!--               <li><strong>DNI: </strong><span id="tkDocNumber"></span></li> -->
								<!--               <li><strong>Ganador: </strong><span id="ganador"></span></li> -->
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>Cod. de Retiro: </strong></td>
												<td><span id="tkRequestNumber"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>Fecha y hora: </strong></td>
												<td><span id="tkRequestDateHour"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>ID: </strong></td>
												<td><span id="idCliente"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>DNI: </strong></td>
												<td><span id="tkDocNumber"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
								<li>
									<table style="margin-left: -6px;">
										<tbody>
											<tr valign="top">
												<td rowspan="2"><strong>Ganador: </strong></td>
												<td><span id="ganador"></span></td>
											</tr>
										</tbody>
									</table>
								</li>
							</ul>
						</div>
						<div class="back" style="max-width: 712px; margin: 0px;"><a href="#" id="volverModalRetiros"
								onclick="volverModalRetiros()">Volver a retiros</a></div>
						<div class="content_loading">
							<div class="modal__body" style="padding-top: 0px;">
								<div>
									<div class="label-total">Monto de retiro:</div>
									<div class="total"><strong>Total: </strong>S/<span id="tkRequestAmount"></span>
									</div>
									<div class="codqr" id="items-tickets-payment-prizes">

									</div>
								</div>
							</div>

							<div class="modal__footer">
								<form class="form frm-newsletter" action="downloadTicketsPP.html" method="post"
									name="formDownload" id="formDownload">
									<span class="down is-cian no-underline" style="margin-right: 0px;"><span
											onclick="downloadTicketsPP()">Descargar</span></span>
									<div class="form-item is-sendmail">
										<button class="btn btn-sendemail"
											style="position: inherit; border-radius: 5px;">Enviar por email</button>
									</div>
								</form>
								<p>C�bralo en un punto de venta cercano presentando tu DNI.</p>
							</div>
						</div>
					</div>
				</div>

			</section>
			<a id="pdf_tmp"></a>
			<div id="popup-message-session" class="overlay">
				<div class="popup popup-sm recuperar-password">
					<a class="close-popup " id="close-popup-session" onclick="closePopupMessage()">&times;</a>
					<div class="main-modal" id="msg-session"></div>
				</div>
			</div>
			<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
			<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
			<script type="text/javascript" src="layer-view-script/popModal.js?v=1"></script>
			<script type="text/javascript" src="layer-view-script/client/libsCollectPrize.js?v=3"></script>
			<script type="text/javascript" src="layer-view-script/client/mainCollectPrize_ta.js?v=125"
				charset="UTF-8"></script>
			<script type="text/javascript" src="layer-view-script/client/analytics.js?v=6" charset="UTF-8"></script>
			<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=11"></script>

			<script type="text/javascript">
				$(document).ready(function () {

					renderActivateFormPin();

				});
			</script>

			<!-- validar cierre de sesion -->
			<script>
				$(document).ready(function () {
					var clientIdSesion = $('#cid').val();
					if (clientIdSesion != '') {
						validateSessionParent();
						document.addEventListener("click", validateSessionParent);
						document.addEventListener("keypress", validateSessionParent);
					}
					// 		 else{
					// 			 parent.location.href = "home.html";
					// 		 }

				});

				document.querySelectorAll(".tab-btn").forEach(button => {
					button.addEventListener("click", function () {

						// Quitar activo a botones
						document.querySelectorAll(".tab-btn")
							.forEach(btn => btn.classList.remove("active"));

						// Ocultar todos los contenidos
						document.querySelectorAll(".tab-content")
							.forEach(tab => tab.classList.remove("active"));

						// Activar bot�n clickeado
						this.classList.add("active");

						// Mostrar contenido correspondiente
						document.getElementById(this.dataset.tab)
							.classList.add("active");
					});
				});

				/* 1.3 Inicio Jhon Conopuma - 2026-03-06 - Comportamiento de chips del Historial (toggle panel avanzado) */
				(function () {
					function syncRangeMirrors() {
document.querySelectorAll('[data-range-mirror]').forEach(function (el) {
var sourceId = el.getAttribute('data-range-mirror');
var source = sourceId ? document.getElementById(sourceId) : null;
if (!source) return;

var valuesOnly = (el.getAttribute('data-values-only') || '').toLowerCase() === 'true';
var sourceText = (source.textContent || '').trim();

var minLabel = (el.getAttribute('data-min-label') || '').trim();
var maxLabel = (el.getAttribute('data-max-label') || '').trim();
if (!minLabel) minLabel = (source.getAttribute('data-min-label') || '').trim();
if (!maxLabel) maxLabel = (source.getAttribute('data-max-label') || '').trim();
var hasCustomLabels = !!(minLabel || maxLabel);

function renderRange(minValue, maxValue) {
	var min = minValue != null ? String(minValue).trim() : '';
	var max = maxValue != null ? String(maxValue).trim() : '';
	if (min && max) {
		if (minLabel && maxLabel) return (minLabel + ' ' + min + ' - ' + maxLabel + ' ' + max).trim();
		if (minLabel && !maxLabel) return (minLabel + ' ' + min + ' - ' + max).trim();
		if (!minLabel && maxLabel) return (min + ' - ' + maxLabel + ' ' + max).trim();
		return (min + ' - ' + max).trim();
	}
	if (min && !max) {
		return (minLabel ? (minLabel + ' ' + min) : min).trim();
	}
	if (!min && max) {
		return (maxLabel ? (maxLabel + ' ' + max) : max).trim();
	}
	return '';
}

function extractMinMax(text) {
	// Extract the first two numeric-like tokens (supports 1, 1.00, 1,000.50)
	var matches = String(text || '').match(/\d+(?:[\.,]\d+)*(?:[\.,]\d+)?/g);
	if (!matches || !matches.length) return { min: null, max: null };
	return { min: matches[0] || null, max: matches[1] || null };
}

var minValue = source.getAttribute('data-min-value');
var maxValue = source.getAttribute('data-max-value');
if ((minValue == null || maxValue == null) && sourceText) {
	var parsed = extractMinMax(sourceText);
	if (minValue == null) minValue = parsed.min;
	if (maxValue == null) maxValue = parsed.max;
}

if (valuesOnly) {
	var rendered = '';
	if (minValue != null || maxValue != null) {
		// If custom labels were provided, show them; otherwise keep the old "values-only" format.
		rendered = hasCustomLabels
			? renderRange(minValue, maxValue)
			: renderRange(minValue, maxValue);
		if (!hasCustomLabels) {
			// renderRange() without labels already returns "min - max".
		}
	}
	if (rendered) {
		el.textContent = rendered;
		return;
	}
	// Fallback: if we can't resolve values yet, copy the source text (or empty).
}

// If the element wants custom labels but is not valuesOnly, prefer rebuilding the text from min/max.
if (!valuesOnly && hasCustomLabels && (minValue != null || maxValue != null)) {
	var labeled = renderRange(minValue, maxValue);
	if (labeled) {
		el.textContent = labeled;
		return;
	}
}

// Default behavior: copy source text (keeps compatibility)
el.textContent = sourceText;
});
}

function syncSaldoDisponible() {
var source = document.getElementById('saldoLiquidable');
var value = source ? (source.textContent || '').trim() : '';
document.querySelectorAll('[data-saldo-liquidable-mirror]').forEach(function (el) {
el.textContent = value;
});
}

function syncMethodCards() {
document.querySelectorAll('.method-card').forEach(function (card) {
					function setupTaHistChips() {
						var scope = document.getElementById('tab-historial');
						if (!scope) return;
						var chips = scope.querySelectorAll('.ta-chip[data-ta-chip]');
						if (!chips || !chips.length) return;
							var advanced = scope.querySelector('#taAdvancedFilters');

						/* 1.4 Inicio Jhon Conopuma - 2026-03-06 - Reinicializa datepicker al abrir panel (mejor posición + auto-oculta al elegir) */
						function initAdvancedDatepickers() {
							if (!advanced) return;
							if (!window.jQuery || !jQuery.fn || typeof jQuery.fn.datepicker !== 'function') return;
							var $inputs = jQuery(advanced).find('#taStartDate, #taEndDate');
							if (!$inputs.length) return;

							$inputs.each(function () {
								var $input = jQuery(this);
								try {
									$input.datepicker('destroy');
								} catch (e) { }

								$input.datepicker({
									language: 'es-ES',
									autoHide: true,
									format: 'dd/mm/yyyy',
									zIndex: 9999
								});

								$input.off('pick.datepicker.ta').on('pick.datepicker.ta', function () {
									try { $input.datepicker('hide'); } catch (e) { }
								});
							});
						}
						/* 1.4 Fin Jhon Conopuma */

						function setActive(activeChip) {
								var activeKey = activeChip ? activeChip.getAttribute('data-ta-chip') : null;
							chips.forEach(function (chip) {
								var isActive = chip === activeChip;
								chip.classList.toggle('ta-chip--active', isActive);
								chip.setAttribute('aria-pressed', isActive ? 'true' : 'false');
							});

								if (advanced) {
									var showAdvanced = activeKey === 'search';
									advanced.classList.toggle('is-open', showAdvanced);
									advanced.setAttribute('aria-hidden', showAdvanced ? 'false' : 'true');
									/* 1.5 Inicio Jhon Conopuma - 2026-03-06 - Clase global para controlar z-index/ancho del datepicker */
									document.documentElement.classList.toggle('ta-hist-advanced-open', !!showAdvanced);
									/* 1.5 Fin Jhon Conopuma */
									if (showAdvanced) {
										initAdvancedDatepickers();
									}

									if (!showAdvanced && window.jQuery && jQuery.fn && typeof jQuery.fn.datepicker === 'function') {
										jQuery(advanced).find('.is-calendar input').datepicker('hide');
									}
								}
						}

							chips.forEach(function (chip) {
							chip.addEventListener('click', function () {
								setActive(chip);
							});
						});

							// Estado inicial
							var initial = scope.querySelector('.ta-chip.ta-chip--active[data-ta-chip]') || chips[0];
							if (initial) setActive(initial);
					}

					if (document.readyState === 'loading') {
						document.addEventListener('DOMContentLoaded', setupTaHistChips);
					} else {
						setupTaHistChips();
					}
				})();
				/* 1.3 Fin Jhon Conopuma */

				/* 1.3 Inicio Jhon Conopuma - 2026-03-06 - Comportamiento de chips del Historial (toggle panel avanzado) */
				(function () {

					function setupTaHistChips() {
						var scope = document.getElementById('tab-historial');
						if (!scope) return;
						var chips = scope.querySelectorAll('.ta-chip[data-ta-chip]');
						if (!chips || !chips.length) return;
							var advanced = scope.querySelector('#taAdvancedFilters');

						/* 1.4 Inicio Jhon Conopuma - 2026-03-06 - Reinicializa datepicker al abrir panel (mejor posición + auto-oculta al elegir) */
						function initAdvancedDatepickers() {
							if (!advanced) return;
							if (!window.jQuery || !jQuery.fn || typeof jQuery.fn.datepicker !== 'function') return;
							var $inputs = jQuery(advanced).find('#taStartDate, #taEndDate');
							if (!$inputs.length) return;

							$inputs.each(function () {
								var $input = jQuery(this);
								try {
									$input.datepicker('destroy');
								} catch (e) { }

								$input.datepicker({
									language: 'es-ES',
									autoHide: true,
									format: 'dd/mm/yyyy',
									zIndex: 9999
								});

								$input.off('pick.datepicker.ta').on('pick.datepicker.ta', function () {
									try { $input.datepicker('hide'); } catch (e) { }
								});
							});
						}
						/* 1.4 Fin Jhon Conopuma */

						function setActive(activeChip) {
								var activeKey = activeChip ? activeChip.getAttribute('data-ta-chip') : null;
							chips.forEach(function (chip) {
								var isActive = chip === activeChip;
								chip.classList.toggle('ta-chip--active', isActive);
								chip.setAttribute('aria-pressed', isActive ? 'true' : 'false');
							});

								if (advanced) {
									var showAdvanced = activeKey === 'search';
									advanced.classList.toggle('is-open', showAdvanced);
									advanced.setAttribute('aria-hidden', showAdvanced ? 'false' : 'true');
									/* 1.5 Inicio Jhon Conopuma - 2026-03-06 - Clase global para controlar z-index/ancho del datepicker */
									document.documentElement.classList.toggle('ta-hist-advanced-open', !!showAdvanced);
									/* 1.5 Fin Jhon Conopuma */
									if (showAdvanced) {
										initAdvancedDatepickers();
									}

									if (!showAdvanced && window.jQuery && jQuery.fn && typeof jQuery.fn.datepicker === 'function') {
										jQuery(advanced).find('.is-calendar input').datepicker('hide');
									}
								}
						}

							chips.forEach(function (chip) {
							chip.addEventListener('click', function () {
								setActive(chip);
							});
						});

							// Estado inicial
							var initial = scope.querySelector('.ta-chip.ta-chip--active[data-ta-chip]') || chips[0];
							if (initial) setActive(initial);
					}

					if (document.readyState === 'loading') {
						document.addEventListener('DOMContentLoaded', setupTaHistChips);
					} else {
						setupTaHistChips();
					}
				})();
				/* 1.3 Fin Jhon Conopuma */

				(function () {
function syncRangeMirrors() {
document.querySelectorAll('[data-range-mirror]').forEach(function (el) {
var sourceId = el.getAttribute('data-range-mirror');
var source = sourceId ? document.getElementById(sourceId) : null;
if (!source) return;

var valuesOnly = (el.getAttribute('data-values-only') || '').toLowerCase() === 'true';
var sourceText = (source.textContent || '').trim();

var minLabel = (el.getAttribute('data-min-label') || '').trim();
var maxLabel = (el.getAttribute('data-max-label') || '').trim();
if (!minLabel) minLabel = (source.getAttribute('data-min-label') || '').trim();
if (!maxLabel) maxLabel = (source.getAttribute('data-max-label') || '').trim();
var hasCustomLabels = !!(minLabel || maxLabel);

function renderRange(minValue, maxValue) {
	var min = minValue != null ? String(minValue).trim() : '';
	var max = maxValue != null ? String(maxValue).trim() : '';
	if (min && max) {
		if (minLabel && maxLabel) return (minLabel + ' ' + min + ' - ' + maxLabel + ' ' + max).trim();
		if (minLabel && !maxLabel) return (minLabel + ' ' + min + ' - ' + max).trim();
		if (!minLabel && maxLabel) return (min + ' - ' + maxLabel + ' ' + max).trim();
		return (min + ' - ' + max).trim();
	}
	if (min && !max) {
		return (minLabel ? (minLabel + ' ' + min) : min).trim();
	}
	if (!min && max) {
		return (maxLabel ? (maxLabel + ' ' + max) : max).trim();
	}
	return '';
}

function extractMinMax(text) {
	// Extract the first two numeric-like tokens (supports 1, 1.00, 1,000.50)
	var matches = String(text || '').match(/\d+(?:[\.,]\d+)*(?:[\.,]\d+)?/g);
	if (!matches || !matches.length) return { min: null, max: null };
	return { min: matches[0] || null, max: matches[1] || null };
}

var minValue = source.getAttribute('data-min-value');
var maxValue = source.getAttribute('data-max-value');
if ((minValue == null || maxValue == null) && sourceText) {
	var parsed = extractMinMax(sourceText);
	if (minValue == null) minValue = parsed.min;
	if (maxValue == null) maxValue = parsed.max;
}

if (valuesOnly) {
	var rendered = '';
	if (minValue != null || maxValue != null) {
		// If custom labels were provided, show them; otherwise keep the old "values-only" format.
		rendered = hasCustomLabels
			? renderRange(minValue, maxValue)
			: renderRange(minValue, maxValue);
		if (!hasCustomLabels) {
			// renderRange() without labels already returns "min - max".
		}
	}
	if (rendered) {
		el.textContent = rendered;
		return;
	}
	// Fallback: if we can't resolve values yet, copy the source text (or empty).
}

// If the element wants custom labels but is not valuesOnly, prefer rebuilding the text from min/max.
if (!valuesOnly && hasCustomLabels && (minValue != null || maxValue != null)) {
	var labeled = renderRange(minValue, maxValue);
	if (labeled) {
		el.textContent = labeled;
		return;
	}
}

// Default behavior: copy source text (keeps compatibility)
el.textContent = sourceText;
});
}

function syncSaldoDisponible() {
var source = document.getElementById('saldoLiquidable');
var value = source ? (source.textContent || '').trim() : '';
document.querySelectorAll('[data-saldo-liquidable-mirror]').forEach(function (el) {
el.textContent = value;
});
}

function syncMethodCards() {
document.querySelectorAll('.method-card').forEach(function (card) {
							var accordionSelector = card.getAttribute('data-accordion');
							var accordionItem = accordionSelector ? document.querySelector(accordionSelector) : null;
							if (accordionItem) {
								var display = window.getComputedStyle(accordionItem).display;
								card.style.display = display === 'none' ? 'none' : '';
							}

							var subtitle = card.querySelector('[data-range-source]');
							if (subtitle) {
								var sourceId = subtitle.getAttribute('data-range-source');
								var source = sourceId ? document.getElementById(sourceId) : null;
								if (source) {
									subtitle.textContent = (source.textContent || '').trim();
								}
							}
						});
						syncRangeMirrors();
						syncSaldoDisponible();
					}

					document.querySelectorAll('.method-card').forEach(function (card) {
						card.addEventListener('click', function () {
							var accordionSelector = card.getAttribute('data-accordion');
							if (accordionSelector === '#accordion_efectivo') {
								syncRangeMirrors();
								syncSaldoDisponible();
								if (typeof simpleModal !== 'undefined' && typeof simpleModal.onToggleModalMsg === 'function') {
									simpleModal.onToggleModalMsg('#modal-retiro-efectivo-pdv');
								}
								return;
							}
							if (accordionSelector === '#accordion_visa') {
								syncRangeMirrors();
								syncSaldoDisponible();
								if (typeof simpleModal !== 'undefined' && typeof simpleModal.onToggleModalMsg === 'function') {
									simpleModal.onToggleModalMsg('#modal-retiro-tarjeta');
								}
								return;
							}
							if (accordionSelector === '#accordion_transferencia') {
								if (typeof simpleModal !== 'undefined' && typeof simpleModal.onToggleModalMsg === 'function') {
										syncRangeMirrors();
										syncSaldoDisponible();
									simpleModal.onToggleModalMsg('#modal-retiro-transferencia');
								}
								return;
							}
							var accordionItem = accordionSelector ? document.querySelector(accordionSelector) : null;
							if (!accordionItem) return;
							var titles = accordionItem.querySelectorAll('.accordion__title');
							var title = null;
							for (var i = 0; i < titles.length; i++) {
								if (window.getComputedStyle(titles[i]).display !== 'none') {
									title = titles[i];
									break;
								}
							}
							if (!title && titles.length) title = titles[0];
							if (title && typeof title.click === 'function') title.click();
						});
					});

					// Initial + delayed sync (ranges and method availability can be set asynchronously)
					if (document.readyState === 'loading') {
						document.addEventListener('DOMContentLoaded', syncMethodCards);
					} else {
						syncMethodCards();
					}
					window.addEventListener('load', syncMethodCards);
					setTimeout(syncMethodCards, 500);
					setTimeout(syncMethodCards, 1500);

					// Observe method availability toggles
					['accordion_efectivo', 'accordion_visa', 'accordion_transferencia'].forEach(function (id) {
						var item = document.getElementById(id);
						if (!item || typeof MutationObserver === 'undefined') return;
						var obs = new MutationObserver(syncMethodCards);
						obs.observe(item, { attributes: true, attributeFilter: ['style', 'class'] });
					});

					// Observe range text updates
					['rangoMontosEfectivo', 'rangoMontosVisa', 'rangoMontosTransferencia'].forEach(function (id) {
						var el = document.getElementById(id);
						if (!el || typeof MutationObserver === 'undefined') return;
						var obs = new MutationObserver(syncMethodCards);
						obs.observe(el, { childList: true, subtree: true, characterData: true });
					});

					// Observe saldoLiquidable updates (so it "travels" to the other modals)
					var saldoEl = document.getElementById('saldoLiquidable');
					if (saldoEl && typeof MutationObserver !== 'undefined') {
						var saldoObs = new MutationObserver(syncSaldoDisponible);
						saldoObs.observe(saldoEl, { childList: true, subtree: true, characterData: true });
					}
					syncSaldoDisponible();
				})();
			</script>

		</body>

		</html>