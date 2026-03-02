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
	<title>La Tinka : Lista de premios</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
	
	<script type="text/javascript" src="layer-view-script/client/interface-prize.js?v=4"></script>
</head>
<body>

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<div>

		<div class="wrap-modal" style="overflow: auto;">

			<div class="content-modal" <c:if test="${(!empty pendingPrizeInfo.GPRIZE && pendingPrizeInfo.GPRIZE > 0.0) && (empty pendingPrizeInfo.GFREE || pendingPrizeInfo.GFREE == 0.0) && (empty pendingPrizeInfo.GTWOXONE || pendingPrizeInfo.GTWOXONE == 0.0) && (pendingPrizeInfo.PRINT_PAY==pending)}"> id="has-action" </c:if>>
				<div id="divTicketData" class="box-desc">
					<div class="box-title box-field">
<!-- 						<h5>Juego</h5> -->
						<div class="field-desc">
							<h4>${pendingPrizeInfo.GNAME}</h4>
						</div>
					</div>
					<div class="box-field">
<!-- 						<h5>Fecha de Compra</h5> -->
						<div class="field-desc">
							<h4><span>${pendingPrizeInfo.GDATE}</span></h4>
						</div>
					</div>
					<c:if test="${pendingPrizeInfo.GTYPE == 1 || pendingPrizeInfo.GTYPE == 3 || pendingPrizeInfo.GTYPE == 6}">
						<div class="box-field">
							<h5>Jugada A</h5>
							<div class="field-desc">
								<h4><span>${pendingPrizeInfo.GMATRIX1} ${Addon1}</span></h4>
							</div>
						</div>
						
						<c:if test="${!empty pendingPrizeInfo.GMATRIX2}">
							<div class="box-field">
								<h5>Jugada B</h5>
								<div class="field-desc">
									<h4><span>${pendingPrizeInfo.GMATRIX2} ${Addon2}</span></h4>
								</div>
							</div>
						</c:if>
						
						<c:if test="${!empty pendingPrizeInfo.GMATRIX3}">
							<div class="box-field">
								<h5>Jugada C</h5>
								<div class="field-desc">
									<h4><span>${pendingPrizeInfo.GMATRIX3} ${Addon3}</span></h4>
								</div>
							</div>
						</c:if>
						
						<c:if test="${!empty pendingPrizeInfo.GMATRIX4}">
							<div class="box-field">
								<h5>Jugada D</h5>
								<div class="field-desc">
									<h4><span>${pendingPrizeInfo.GMATRIX4} ${Addon4}</span></h4>
								</div>
							</div>
						</c:if>
					</c:if>

					<c:if test="${pendingPrizeInfo.GTYPE == 2 || pendingPrizeInfo.GTYPE == 4}">
						<div class="box-field">
							<h5>Jugada</h5>
							<div class="field-desc">
								<h4>${pendingPrizeInfo.GAMEID} - ${pendingPrizeInfo.GMATRIX1} - ${pendingPrizeInfo.GTICKET}</h4>
							</div>
						</div>
					</c:if>
					
					<c:if test="${!empty pendingPrizeInfo.GRESUL && pendingPrizeInfo.GNAME=='Ganagol'}">
						<div class="box-field">
							<h5>Resultados</h5>
							<div class="field-desc">
								<h4>${pendingPrizeInfo.GRESULT}</h4>
							</div>
						</div>
					</c:if>

					<div class="box-field">
						<h5>Ticket</h5>
						<div class="field-desc">
							<h4>${pendingPrizeInfo.GTICKET}</h4>
						</div>
					</div>

					<c:if test="${pendingPrizeInfo.GTYPE == 5 || pendingPrizeInfo.GTYPE == 6}">
						<c:if test="${!empty pendingPrizeInfo.GDRDATE}">
							<div class="box-field">
							    <h5>F. de Sorteo</h5>
							    <div class="field-desc">
							    	<h4>${pendingPrizeInfo.GDRDATE}</h4>
							    </div>
							</div>
						</c:if>
					</c:if>
						
					<c:if test="${pendingPrizeInfo.GTYPE == 1 || pendingPrizeInfo.GTYPE == 2 || pendingPrizeInfo.GTYPE == 3 || pendingPrizeInfo.GTYPE == 4}">
						<c:if test="${!empty pendingPrizeInfo.GDRDATE}">
							<div class="box-field">
							 	<h5>F. de Sorteo</h5>
							 	<div class="field-desc">
							 		<h4>${fn:substring(pendingPrizeInfo.GDRDATE,0,11)}</h4>
							 	</div>
							</div>
						</c:if>
					</c:if>

					<div class="box-field">
						<h5>Sorteo</h5>
						<div class="field-desc">
							<c:choose>
								<c:when test="${pendingPrizeInfo.GFROMDRAW eq pendingPrizeInfo.GTODRAW}">
					                <h4>${pendingPrizeInfo.fdrwid}</h4>
								</c:when>
								<c:otherwise>
					                <h4>Del ${pendingPrizeInfo.fdrwid}<c:if test="${!empty pendingPrizeInfo.GTODRAW}"> al ${pendingPrizeInfo.tdrwid}</c:if></h4>
								</c:otherwise>
							</c:choose>
						</div>
					</div>

					<div class="box-field">
						<h5>Estado</h5>
						<div class="field-desc">
							<h4><span id="lblStatus">${pendingPrizeInfo.STATUS}</span></h4>
						</div>
					</div>

					<c:if test="${pendingPrizeInfo.GPRIZE > 0.0 || pendingPrizeInfo.GFREE > 0.0 || pendingPrizeInfo.GTWOXONE > 0.0}">
						<div class="box-field">
							<h5>Premio(s)</h5>
							<div class="field-desc">
								<c:if test="${pendingPrizeInfo.GPRIZE > 0.0}">
									<h4>* <span id="premio_prize">${GPRIZE}</span> <c:if test="${not empty pendingPrizeInfo.GPRIZEDATE}">(caduca el ${fn:substring(pendingPrizeInfo.GPRIZEDATE,0,11)})</c:if></h4>
								</c:if>
								<c:if test="${pendingPrizeInfo.GFREE > 0}">
									<h4>* ${pendingPrizeInfo.GFREE} jugada(s) gratis <c:if test="${not empty pendingPrizeInfo.GFREEDATE}">(caduca el ${fn:substring(pendingPrizeInfo.GFREEDATE,0,11)})</c:if></h4>
								</c:if>
								<c:if test="${pendingPrizeInfo.GTWOXONE > 0}">
									<h4>* ${pendingPrizeInfo.GTWOXONE*2} jugadas de 2x1 <c:if test="${not empty pendingPrizeInfo.GTWOXONEDATE}">(caduca el ${fn:substring(pendingPrizeInfo.GTWOXONEDATE,0,11)})</c:if></h4>
								</c:if>
							</div>
						</div>
					</c:if>

					<div class="box-footer">
						<div id="divMensaje" class="wrap-box-footer">
							<c:choose>
								<c:when test="${(not empty pendingPrizeInfo.GPRIZE && pendingPrizeInfo.GPRIZE > 0.0 && pendingPrizeInfo.GPRIZE <= dmaxMoney) && (empty pendingPrizeInfo.GFREE || pendingPrizeInfo.GFREE == 0.0) && (empty pendingPrizeInfo.GTWOXONE || pendingPrizeInfo.GTWOXONE == 0.0) && (pendingPrizeInfo.STATUS eq 'Con premio')}">
								    <p style="text-align:justify; font-size:12px">
								        * Si deseas cobrar tu premio al saldo haz clic en "Cargar al Saldo". 
								    </p>								    
									<c:if test="${(not empty pendingPrizeInfo.GPRIZE && pendingPrizeInfo.GPRIZE > 0.0 && pendingPrizeInfo.GPRIZE <= dmaxMoney) && (empty pendingPrizeInfo.GFREE || pendingPrizeInfo.GFREE == 0.0) && (empty pendingPrizeInfo.GTWOXONE || pendingPrizeInfo.GTWOXONE == 0.0) && (pendingPrizeInfo.STATUS eq 'Con premio')}">
										<div id="divBtnCargarSaldo" class="body-popup" style="margin-top: 15px;">
											<!-- <button class="btn btn-orange white" type="button" onclick="window.location.href='client_price_execute_collection.html';">COBRAR</button> -->
											<button class="btn btn-orange white" type="button" onclick="window.location.href='client_price_execute_collection.html';">CARGAR AL SALDO</button>
										</div>
									</c:if>
								    <p style="text-align:justify; font-size:12px">
								    	* Si deseas cobrar en efectivo haz clic en "Cobrar en Punto de venta" para activar el c&oacute;digo QR del ticket. 
										Si tu premio es mayor o igual a S/2,000, puedes solicitar una transferencia bancaria a tu cuenta Interbank, BCP, Continental o Interbancaria de ser otro banco.
										<br />
										Env&iacute;a la imagen de tu boleto con el c&oacute;digo de barras activado (punto 1), la foto de tu DNI (ambas caras), n&uacute;mero de cuenta bancaria a tu nombre y tel&eacute;fono contacto a <a href="mailto:cobratupremio@latinka.com.pe">cobratupremio@latinka.com.pe</a>
								    </p>
									<c:if test="${pendingPrizeInfo.STATUS ne 'Cobrar en Efectivo'}">
										<div id="divBtnCobrarQR" class="body-popup" style="margin-top:0.6em; margin-bottom: 15px;">
											<button id="btnCobrarQR" class="btn btn-orange white" type="button"
													data-ticket="${item.GTICKET}" data-play="${item.GAMEID}">COBRAR EN PUNTO DE VENTA</button>
										</div>
									</c:if>			
								</c:when>
								<c:when test="${(not empty pendingPrizeInfo.GPRIZE && pendingPrizeInfo.GPRIZE > 0.0 && pendingPrizeInfo.GPRIZE > dmaxMoney) && (empty pendingPrizeInfo.GFREE || pendingPrizeInfo.GFREE == 0.0) && (empty pendingPrizeInfo.GTWOXONE || pendingPrizeInfo.GTWOXONE == 0.0) && (pendingPrizeInfo.STATUS eq 'Con premio')}">
									    <p style="text-align:justify; font-size:12px">
									    	* Si deseas cobrar en efectivo haz clic en "Cobrar en Punto de venta" para activar el c&oacute;digo QR del ticket. 
											Si tu premio es mayor o igual a S/2,000, puedes solicitar una transferencia bancaria a tu cuenta Interbank, BCP, Continental o Interbancaria de ser otro banco.
											<br />
											Env&iacute;a la imagen de tu boleto con el c&oacute;digo de barras activado (punto 1), la foto de tu DNI (ambas caras), n&uacute;mero de cuenta bancaria a tu nombre y tel&eacute;fono contacto a <a href="mailto:cobratupremio@latinka.com.pe">cobratupremio@latinka.com.pe</a>
									    </p>
										<c:if test="${pendingPrizeInfo.STATUS ne 'Cobrar en Efectivo'}">
											<div id="divBtnCobrarQR" class="body-popup" style="margin-top:0.6em; margin-bottom: 15px;">
												<button id="btnCobrarQR" class="btn btn-orange white" type="button"
														data-ticket="${item.GTICKET}" data-play="${item.GAMEID}">COBRAR EN PUNTO DE VENTA</button>
											</div>
										</c:if>			
								</c:when>
								<c:when test="${pendingPrizeInfo.STATUS ne 'Cobrar en Efectivo' && ((not empty pendingPrizeInfo.GFREE && pendingPrizeInfo.GFREE > 0.0) || (not empty pendingPrizeInfo.GTWOXONE && pendingPrizeInfo.GTWOXONE > 0.0))}">
										<p style="text-align:justify; font-size:12px">
										    * Si deseas "Cobrar en l&iacute;nea" ingresa a tu cuenta desde una laptop o PC y sigue las indicaciones para el cobro.<br/><br/>
									    	* Si deseas cobrar en efectivo haz clic en "Cobrar en Punto de venta" para activar el c&oacute;digo QR del ticket. 
											Si tu premio es mayor o igual a S/2,000, puedes solicitar una transferencia bancaria a tu cuenta Interbank, BCP, Continental o Interbancaria de ser otro banco.
											<br />
											Env&iacute;a la imagen de tu boleto con el c&oacute;digo de barras activado (punto 1), la foto de tu DNI (ambas caras), n&uacute;mero de cuenta bancaria a tu nombre y tel&eacute;fono contacto a <a href="mailto:cobratupremio@latinka.com.pe">cobratupremio@latinka.com.pe</a>
									    </p>
										<c:if test="${pendingPrizeInfo.STATUS ne 'Cobrar en Efectivo'}">
											<div id="divBtnCobrarQR" class="body-popup" style="margin-top:0.6em; margin-bottom: 15px;">
												<button id="btnCobrarQR" class="btn btn-orange white" type="button"
														data-ticket="${item.GTICKET}" data-play="${item.GAMEID}">COBRAR EN PUNTO DE VENTA</button>
											</div>
										</c:if>		
								</c:when>
								<c:when test="${pendingPrizeInfo.STATUS eq 'Cobrar en Efectivo'}">
									<p style="text-align:center; font-size:12px">* Presenta este c&oacute;digo QR en el punto de venta.</p>
								</c:when>
							</c:choose>
						</div>
					</div>
					<c:if test="${pendingPrizeInfo.STATUS eq 'Cobrar en Efectivo'}">
					    <br/>
						<div id="divQR">
							<img id="imgQR" src="${base64Qr}" style="border: 7px solid black"/>
						</div>
					</c:if>
					 
				</div>
			</div>
		</div>
	</div>
</body>
</html>