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
	<title>La Tinka : Lista de jugadas</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<meta name="robots" content="noindex, nofollow">
</head>
<body>

	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<input type="hidden" id="golazo2002" value="${playCouponInfo.GTYPE}"/>
	
	<p>GAMEID: ${GAMEID}</p> <!-- Para verificar que se está mostrando correctamente -->
	
	 <c:choose>
	<c:when test="${playCouponInfo.GTYPE == 0}">
       <div>
		<div class="wrap-modal">

			<div class="content-modal golazo200">
			<c:if test="${empty GMATRIX2 && empty GMATRIX3 && empty GMATRIX4}">
				<div class="box-desc">
			</c:if>
			<c:if test="${!empty GMATRIX2 || !empty GMATRIX3 || !empty GMATRIX4 || STATUS eq 'Cobrar en Efectivo'}">
				<div class="box-desc" style="height: 60vh">
			</c:if>
					<div class="box-title box-field">
<!-- 						<h5>Juego</h5> -->
						<div class="field-desc">
							<h4 id="GNAME" class="GNAME">${GNAME} 
								<c:if test="${GSUSCRIPTION != ' ' }">
									${GSUSCRIPTION}
								</c:if>
							</h4>
						</div>
					</div>
					<div class="box-field">
<!-- 						<h5>Fecha de Compra</h5> -->
						<div class="field-desc">
							<h4><span>${GDATE}</span></h4>
						</div>
					</div>
					<div class="box-field">
						<h5>Precio</h5>
						<div class="field-desc">
							<h4>${GAMOUNT}</h4>
						</div>
					</div>
					<c:if test="${GDISCOUNT!='S/ 0.00'}">
					<div class="box-field">
						<h5>Descuento</h5>
						<div class="field-desc">
							<h4>${GDISCOUNT}</h4>
						</div>
					</div>
					</c:if>
					
						<c:choose>
						    <c:when test="${GAMEID != 7  && GAMEID != 10  &&  GAMEID != 8 && GAMEID != 4 && GAMEID != 108}">
						        <div class="box-field">
						            <h5>Jugada A</h5>
						            <div class="field-desc">
						                <h4>${GMATRIX1}</h4>
						            </div>
						        </div>
						    </c:when>
						    <c:otherwise>
						        <div class="box-field">
						            <h5>Jugada</h5>
						            <div class="field-desc">
						                <h4>${GMATRIX1}</h4>
						            </div>
						        </div>
						    </c:otherwise>
						</c:choose>

						<c:choose>
						    <c:when test="${GAMEID != 7  && GAMEID != 10 && GAMEID != 8 && GAMEID != 4 && GAMEID != 108 && GAMEID != 10}">
						        <c:if test="${!empty GMATRIX2}">
						            <div class="box-field">
						                <h5>Jugada B</h5>
						                <div class="field-desc">
						                    <h4><span class="play-game-result">${GMATRIX2}</span><span>${Addon2}</span></h4>
						                </div>
						            </div>
						        </c:if>
						    </c:when>
						    <c:otherwise>
						        <!-- no se muestra -->
						    </c:otherwise>
						</c:choose>

						<c:choose>
						    <c:when test="${GAMEID != 7  && GAMEID != 10 && GAMEID != 8 && GAMEID != 4 && GAMEID != 108 && GAMEID != 10}">
								<c:if test="${!empty GMATRIX3}">
									<div class="box-field">
										<h5>Jugada C</h5>
										<div class="field-desc">
											<h4><span class="play-game-result">${GMATRIX3}</span><span>${Addon3}</span></h4>
										</div>
									</div>
								</c:if>
						    </c:when>						
						<c:otherwise>
						     <!-- no se muestra -->
						    </c:otherwise>
						</c:choose>

						<c:choose>
						    <c:when test="${GAMEID != 7  && GAMEID != 10 && GAMEID != 8 && GAMEID != 4 && GAMEID != 108 && GAMEID != 10}">						
								<c:if test="${!empty GMATRIX4}">
									<div class="box-field">
										<h5>Jugada D</h5>
										<div class="field-desc">
											<h4><span class="play-game-result">${GMATRIX4}</span><span>${Addon4}</span></h4>
										</div>
									</div>
								</c:if>
						    </c:when>						
						<c:otherwise>
						     <!-- no se muestra -->
						    </c:otherwise>
						</c:choose>

						<div class="box-field">
							<h5>Ticket</h5>
							<div class="field-desc">
								<h4>${GTICKET}</h4>
							</div>
						</div>

						<c:if test="${GTYPE == 6}">

							<div class="box-field">
							    <h5>F. de Sorteo</h5>
							    <div class="field-desc">
							    	<h4>${GFROMDRAWDATE}</h4>
							    </div>
							</div>

						</c:if>
							
						<c:if test="${!empty GFROMDRAWDATE}">
							<div class="box-field">
							 	<h5>F. de Sorteo</h5>
							 	<div class="field-desc">
							 		<h4>${fn:substring(GFROMDRAWDATE,0,11)}</h4>
							 	</div>
							</div>
						</c:if>

						<c:if test="${!empty GFROMDRAWDATE}">
						<div class="box-field">
							<h5>Sorteo</h5>
							<div class="field-desc">
								<c:choose>
									<c:when test="${GFROMDRAW eq GTODRAW}">
						                <h4>${playCouponInfo.fdrwid}</h4>
									</c:when>
									<c:otherwise>
						                <h4>Del ${fdrwid}<c:if test="${!empty GTODRAW}"> al ${tdrwid}</c:if></h4>
									</c:otherwise>
								</c:choose>
							</div>
						</div>
						</c:if>

						<div class="box-field">
							<h5>Canal de Venta</h5>
							<div class="field-desc">
								<h4>${SALESCHANNEL}</h4>
							</div>
						</div>
						
						<div class="box-field">
							<h5>Estado</h5>
							<div class="field-desc">
								<h4>${STATUS}</h4>
							</div>
						</div>
						
						<c:if test="${STATUS eq 'Cobrar en Efectivo'}">
							<div id="divQR">
								<img id="imgQR" src="${base64Qr}" style="border: 7px solid black"/>
							</div>
						</c:if>
				</div>
			</div>
		</div>
	</div>
				<!-- -  -->
    </c:when>
    <c:otherwise>
        <div>

		<div class="wrap-modal">

			<div class="content-modal golazo200" style="height: 43em;margin-bottom: 0em;" >
				<div class="box-desc" style="padding-bottom: 0px;">
			
					<div class="box-title box-field">
<!-- 						<h5>Juego</h5> -->
						<div class="field-desc">
							<h4 id="GNAME" class="GNAME">${playCouponInfo.GNAME} 
								<c:if test="${playCouponInfo.GSUSCRIPTION != ' ' }">
									${playCouponInfo.GSUSCRIPTION}
								</c:if>
							</h4>
						</div>
					</div>
					<div class="box-field">
<!-- 						<h5>Fecha de Compra</h5> -->
						<div class="field-desc">
							<h4><span>${playCouponInfo.GDATE}</span></h4>
						</div>
					</div>
					<div class="box-field">
						<h5>Precio</h5>
						<div class="field-desc">
							<h4>${GAMOUNT}</h4>
						</div>
					</div>
					<c:if test="${GDISCOUNT!='S/ 0.00'}">
					<div class="box-field">
						<h5>Descuento</h5>
						<div class="field-desc">
							<h4>${GDISCOUNT}</h4>
						</div>
					</div>
					</c:if>
					<c:if test="${playCouponInfo.GTYPE == 1 || playCouponInfo.GTYPE == 3 || playCouponInfo.GTYPE == 6}">
						<div class="box-field">
							<h5>Jugada A</h5>
							
							<div class="field-desc">
								<h4><span class="play-game-result">${playCouponInfo.GMATRIX1}</span><span>${Addon1}</span></h4>
							</div>
							
						</div>
						
						<c:if test="${!empty playCouponInfo.GMATRIX2}">
							<div class="box-field">
								<h5>Jugada B</h5>
								<div class="field-desc">
									<h4><span class="play-game-result">${playCouponInfo.GMATRIX2}</span><span>${Addon2}</span></h4>
								</div>
							</div>
						</c:if>
						
						<c:if test="${!empty playCouponInfo.GMATRIX3}">
							<div class="box-field">
								<h5>Jugada C</h5>
								<div class="field-desc">
									<h4><span class="play-game-result">${playCouponInfo.GMATRIX3}</span><span>${Addon3}</span></h4>
								</div>
							</div>
						</c:if>
						
						<c:if test="${!empty playCouponInfo.GMATRIX4}">
							<div class="box-field">
								<h5>Jugada D</h5>
								<div class="field-desc">
									<h4><span class="play-game-result">${playCouponInfo.GMATRIX4}</span><span>${Addon4}</span></h4>
								</div>
							</div>
						</c:if>

						<c:if test="${playCouponInfo.GTYPE == 2 || playCouponInfo.GTYPE == 4}">
							<div class="box-field">
								<h5>Jugada</h5>
								<div class="field-desc">
									<h4>${playCouponInfo.GAMEID} - ${playCouponInfo.GMATRIX1} - ${playCouponInfo.GTICKET}</h4>
								</div>
							</div>
						</c:if>

						<c:if test="${!empty playCouponInfo.GRESULT && playCouponInfo.GNAME=='Ganagol'}">
							<div class="box-field">
								<h5>Resultados</h5>
								<div class="field-desc">
									<h4>${playCouponInfo.GRESULT}</h4>
								</div>
							</div>
						</c:if>

						<div class="box-field">
							<h5>Ticket</h5>
							<div class="field-desc">
								<h4>${playCouponInfo.GTICKET}</h4>
							</div>
						</div>

						<c:if test="${playCouponInfo.GTYPE == 6}">

							<div class="box-field">
							    <h5>F. de Sorteo</h5>
							    <div class="field-desc">
							    	<h4>${playCouponInfo.GFROMDRAWDATE}</h4>
							    </div>
							</div>

						</c:if>
							
						<c:if test="${playCouponInfo.GTYPE == 1 || playCouponInfo.GTYPE == 2 || playCouponInfo.GTYPE == 3 || playCouponInfo.GTYPE == 4}">

							<div class="box-field">
							 	<h5>F. de Sorteo</h5>
							 	<div class="field-desc">
							 		<h4>${fn:substring(playCouponInfo.GFROMDRAWDATE,0,11)}</h4>
							 	</div>
							</div>

						</c:if>

						<div class="box-field">
							<h5>Sorteo</h5>
							<div class="field-desc">
								<c:choose>
									<c:when test="${playCouponInfo.GFROMDRAW eq playCouponInfo.GTODRAW}">
						                <h4>${playCouponInfo.fdrwid}</h4>
									</c:when>
									<c:otherwise>
						                <h4>Del ${playCouponInfo.fdrwid}<c:if test="${!empty playCouponInfo.GTODRAW}"> al ${playCouponInfo.tdrwid}</c:if></h4>
									</c:otherwise>
								</c:choose>
							</div>
						</div>

						<div class="box-field">
							<h5>Canal de Venta</h5>
							<div class="field-desc">
								<h4>${playCouponInfo.SALESCHANNEL}</h4>
							</div>
						</div>
						
						<div class="box-field">
							<h5>Estado</h5>
							<div class="field-desc">
								<h4>${playCouponInfo.STATUS}</h4>
							</div>
						</div>
						
						<c:if test="${playCouponInfo.STATUS eq 'Cobrar en Efectivo'}">
							<div id="divQR">
								<img id="imgQR" src="${base64Qr}" style="border: 7px solid black"/>
							</div>
						</c:if>
						<c:if test="${fn:contains(playCouponInfo.STATUS, 'Cobrar en Punto de Venta')}">
						    <div id="divQR">
						        <img id="imgQR" src="${base64Qr}" style="border: 7px solid black"/>
						    </div>
						</c:if>

					</c:if>
				</div>

			</div>
		</div>
	</div>
    </c:otherwise>
  </c:choose>

</body>
</html>