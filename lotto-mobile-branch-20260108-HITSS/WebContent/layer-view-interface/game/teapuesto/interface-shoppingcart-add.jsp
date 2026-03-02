<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>

	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<title>Te Apuesto : Jugada</title>	
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/teapuesto/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Te Apuesto móvil, Agrega jugada adicional al boleto' />
	
</head>
<body>
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->

   <jsp:include page="../../include/header.jsp" />
   
   <div align="center" >  
   
   <BR>
   	<ul data-role="listview" data-inset="true" data-theme="e" style="margin-right: 5px; margin-left: 5px;">
		<li data-role="list-divider">
		<div align="center">
		<c:if test="${teapuestoGameList.positionLocal>0}">
		<span style="font-size: 9px"> &nbsp;(Pos ${teapuestoGameList.positionLocal} )&nbsp; </span>
		</c:if>
		<span style="font-size: 9px">
		${teapuestoGameList.teamLocal} vs. ${teapuestoGameList.teamVisitor} </span>
		<c:if test="${teapuestoGameList.positionLocal>0}">
		<span style="font-size: 9px"> &nbsp;(Pos ${teapuestoGameList.positionVisitor} )&nbsp; </span>
		</c:if>
		</div>
		</li>	
	 </ul>
	 
	 
	 		<ul style="margin-right: 5px; margin-left: 5px;" class="listContent listContentCuadro">
				<li>
                  <BR>
					<div>
						<span style="font-size: 11px"> <fmt:formatDate
								value="${teapuestoGameList.datePrincipal}" pattern="E" /> <fmt:formatDate
								value="${teapuestoGameList.datePrincipal}" pattern="dd" /> <fmt:formatDate
								value="${teapuestoGameList.datePrincipal}" pattern="MMM" /> |
							    <fmt:formatNumber pattern="00" value="${teapuestoGameList.closeHour}" /> : 
							    <fmt:formatNumber pattern="00" value="${teapuestoGameList.closeMinute}" /> 
							    &nbsp; min 
							    <span style="font-size:10px; color:#ffffff; text-shadow:none; padding: 2px;
							    
							    <c:if test="${teapuestoGameList.minimum == 1}" >
					              background-color: red; 
					            </c:if>
					            <c:if test="${teapuestoGameList.minimum == 2}" >
					              background-color: orange; 
					            </c:if>
					            <c:if test="${teapuestoGameList.minimum == 3}" >
					              background-color: blue; 
					            </c:if> 
					            "
							     >${teapuestoGameList.minimum}</span>
						</span>

                    <c:set var="general" 
                    value="&hour=${teapuestoGameList.closeHour}&minute=${teapuestoGameList.closeMinute}&date=${teapuestoGameList.datePrincipal}&event=${teapuestoGameList.eventpk.event}&draw=${teapuestoGameList.eventpk.draw}&game=${teapuestoGameList.eventpk.game}&local=${teapuestoGameList.teamLocal}&visit=${teapuestoGameList.teamVisitor}&min=${teapuestoGameList.minimum}" />
					</div> <BR>

					<c:if test="${teapuestoGameList.unoLoad>0 || teapuestoGameList.xLoad>0 || teapuestoGameList.dosLoad>0 }">
					<div>
						<c:if test="${teapuestoGameList.unoLoad>0 || teapuestoGameList.xLoad>0 || teapuestoGameList.dosLoad>0 }">
							<div style="font-size: 13px">
								<b>Resultado Final</b>
							</div>
							</c:if>
							<a  id="addShopingTeapuesto"
									<c:if test="${teapuestoGameList.unoLoad<=0}">
								     href="#"
								    </c:if>
								    
								    
								    <c:if test="${teapuestoGameList.unoLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=L&valor=${teapuestoGameList.unoLoad}${general}';"
									
								 	</c:if>
									 	> 
										
									<c:if test="${teapuestoGameList.unoLoad>0}">
									<div style="float: left; width: 30px;">L</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.unoLoad}</div>
									<div>${teapuestoGameList.teamLocal} </div>
									</c:if>			
								
									</a>
								    
								 <%--  
									<c:if test="${teapuestoGameList.unoLoad>0}">
									href="game_teapuesto_show_shoppingcart.html?tipo=L&valor=${teapuestoGameList.unoLoad}${general}"
									</c:if>
									data-role="button" style="width: 85%;font-size: 10px;"
									title="${teapuestoGameList.teamLocal}" 
									 >	
									<div style="float: left; width: 30px;">
									L
									</div>
									<div style="float: left; width: 30px;" >
									${teapuestoGameList.unoLoad}
									</div>
									<div>
									${teapuestoGameList.teamLocal}		
									</div>			
								</a> --%>
					
								<a  id="addShopingTeapuesto"
								
									<c:if test="${teapuestoGameList.xLoad<=0}">
								     href="#"
								    </c:if>
								    
								    
								    <c:if test="${teapuestoGameList.xLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=E&valor=${teapuestoGameList.xLoad}${general}';"
									
								 	</c:if>
									 	> 
										
									<c:if test="${teapuestoGameList.xLoad>0}">
									<div style="float: left; width: 30px;">E</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.xLoad}</div>
									<div>EMPATE </div>
									</c:if>			
								
									</a>
								
								<%--  
									<c:if test="${teapuestoGameList.xLoad<=0}">
								     href="#"
								    </c:if>
									<c:if test="${teapuestoGameList.xLoad>0}">
									href="game_teapuesto_show_shoppingcart.html?tipo=E&valor=${teapuestoGameList.xLoad}${general}"
									</c:if>
									data-role="button" style="width: 85%; font-size: 10px;"
									title="EMPATE"
									>
									<div style="float: left; width: 30px;">E</div>
									<div style="float: left; width: 30px;">${teapuestoGameList.xLoad} </div>
									<div>EMPATE</div>									
																	
								</a> --%>
					
					
					
								<a  id="addShopingTeapuesto"
								
								
								<c:if test="${teapuestoGameList.dosLoad<=0}">
								     href="#"
								    </c:if>
								    
								    
								    <c:if test="${teapuestoGameList.dosLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=V&valor=${teapuestoGameList.dosLoad}${general}';"
									
								 	</c:if>
									 	> 
										
									<c:if test="${teapuestoGameList.dosLoad>0}">
									<div style="float: left; width: 30px;">V</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.dosLoad}</div>
									<div>${teapuestoGameList.teamVisitor}</div>
									</c:if>			
								
									</a>
								
								<%--  
									<c:if test="${teapuestoGameList.dosLoad<=0}">
								     href="#"
								    </c:if>
									<c:if test="${teapuestoGameList.dosLoad>0}">
									href="game_teapuesto_show_shoppingcart.html?tipo=V&valor=${teapuestoGameList.dosLoad}${general}"
									</c:if>
									data-role="button" style="width: 85%;font-size: 10px;"
									title="${teapuestoGameList.teamVisitor}">	
									<div style="float: left; width: 30px;">V</div>
									<div style="float: left; width: 30px;">${teapuestoGameList.dosLoad}</div>
									<div>${teapuestoGameList.teamVisitor}</div>									
								</a>--%>
					</div> 
					</c:if>
					<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
					<div  align="center">
						<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
						<div style="font-size: 13px">
								 <b>Opci&oacute;n Doble</b>								
						</div>
						</c:if>
							<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.unoXLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=LE&valor=${teapuestoGameList.unoXLoad}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.unoXLoad>0}">
									<div style="float: left; width: 30px;">LE</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.unoXLoad}</div>
									<div>${teapuestoGameList.teamLocal} / EMPATE </div>
								</c:if>			
								
							</a>
					
							<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.unoDosLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=EV&valor=${teapuestoGameList.unoDosLoad}${general}';"
									title="${teapuestoGameList.teamVisitor} "
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.unoDosLoad>0}">
									 	<div style="float: left; width: 30px;">EV</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.unoDosLoad}</div>
										<div > EMPATE / ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
									<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.xDosLoad>0}">
									data-role="button" style="width: 85%; font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=LV&valor=${teapuestoGameList.xDosLoad}${general}';"
									title="${teapuestoGameList.teamLocal} ${teapuestoGameList.teamVisitor}"
									</c:if>
									>		
									<c:if test="${teapuestoGameList.xDosLoad>0}">
									<div style="float: left; width: 30px;">LV</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.xDosLoad}</div>
									<div>${teapuestoGameList.teamLocal} / ${teapuestoGameList.teamVisitor}</div>
									</c:if>
								</a>
					
					</div> 
					</c:if>


					<c:if test="${teapuestoGameList.lower2>0 || teapuestoGameList.ower2>0 }">
					<div  align="center">
						<c:if test="${teapuestoGameList.lower2>0 || teapuestoGameList.ower2>0 }">
						<div style="font-size: 13px">
								<b>Resultado Goles</b>								
						</div>
						</c:if>
						
							<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.lower2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=r&valor=${teapuestoGameList.lower2}${general}';"
									title="DOS GOLES O MENOS"
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.teSum01Load>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.lower2}</div>
									<div style="float: left; width: 30px;">DOS GOLES O MENOS</div>
								</c:if>			
								
							</a>
							<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.ower2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=s&valor=${teapuestoGameList.ower2}${general}';"
									title="TRES GOLES O MAS"
								 </c:if>
									 	> 
									 	
							 	<c:if test="${teapuestoGameList.ower2>0}">
									 <div style="float: left; width: 30px;">${teapuestoGameList.ower2}</div>								
									 <div style="float: left; width: 30px;">TRES GOLES O MAS</div>
								</c:if>
										
								</a>
					
					
					</div>
					</c:if>
					
					
					<c:if test="${teapuestoGameList.teH1Load>0 || teapuestoGameList.teHXLoad>0 || teapuestoGameList.teH2Load>0}">
					<div  align="center">
						<c:if test="${teapuestoGameList.teH1Load>0 || teapuestoGameList.teHXLoad>0 || teapuestoGameList.teH2Load>0}">
							<div style="font-size: 13px">
								 <b>Primer Tiempo</b>								
							</div>
						</c:if>
							<a  id="addShopingTeapuesto"
								
									<c:if test="${teapuestoGameList.teH1Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=L/&valor=${teapuestoGameList.teH1Load}${general}';"
									
									 </c:if>
									 	> 
										
									<c:if test="${teapuestoGameList.teH1Load>0}">
									<div style="float: left; width: 30px;">L/</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.teH1Load}</div>
									<div>${teapuestoGameList.teamLocal} </div>
									</c:if>			
								
								</a>
					


								<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHXLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=E/&valor=${teapuestoGameList.teHXLoad}${general}';"
									title="Empate"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHXLoad>0}">
									 	<div style="float: left; width: 30px;">E/</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHXLoad}</div>
										<div >EMPATE</div>
										</c:if>
										
								</a>
					

								<a  id="addShopingTeapuesto"
								
									<c:if test="${teapuestoGameList.teH2Load>0}">
									data-role="button" style="width: 85%; font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=V/&valor=${teapuestoGameList.teH2Load}${general}';"
									title="${teapuestoGameList.teamVisitor}"
									</c:if>
									>		
									<c:if test="${teapuestoGameList.teH2Load>0}">
									<div style="float: left; width: 30px;">V/</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.teH2Load}</div>
									<div>${teapuestoGameList.teamVisitor}</div>
									</c:if>
								</a>
					
					</div>
					</c:if>
					
					<c:if test="${teapuestoGameList.teHf11Load>0 || teapuestoGameList.teHfX1Load>0 || teapuestoGameList.teHf21Load>0 || teapuestoGameList.teHf1xLoad>0 || teapuestoGameList.teHfXxLoad>0 || teapuestoGameList.teHf2xLoad>0 || teapuestoGameList.teHf12Load>0 || teapuestoGameList.teHfX2Load>0 || teapuestoGameList.teHf22Load>0  }">
							<div  align="center">
							<c:if test="${teapuestoGameList.teHf11Load>0 || teapuestoGameList.teHfX1Load>0 || teapuestoGameList.teHf21Load>0 || teapuestoGameList.teHf1xLoad>0 || teapuestoGameList.teHfXxLoad>0 || teapuestoGameList.teHf2xLoad>0 || teapuestoGameList.teHf12Load>0 || teapuestoGameList.teHfX2Load>0 || teapuestoGameList.teHf22Load>0  }">
							<div style="font-size: 13px">
								 <b>Primer Tiempo / Resultado Final</b>								
							</div>
							</c:if>

								<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHf11Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=L/L&valor=${teapuestoGameList.teHf11Load}${general}';"
									
									 </c:if>
									 	> 
										
									<c:if test="${teapuestoGameList.teHf11Load>0}">
									<div style="float: left; width: 30px;">L/L</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.teHf11Load}</div>
									<div>${teapuestoGameList.teamLocal} / ${teapuestoGameList.teamLocal} </div>
									</c:if>			
								
								</a>
					


								<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHfX1Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=E/L&valor=${teapuestoGameList.teHfX1Load}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHfX1Load>0}">
									 	<div style="float: left; width: 30px;">E/L</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHfX1Load}</div>
										<div >EMPATE / ${teapuestoGameList.teamLocal}</div>
										</c:if>
										
								</a>
					
									<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHf21Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=V/L&valor=${teapuestoGameList.teHf21Load}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHf21Load>0}">
									 	<div style="float: left; width: 30px;">V/L</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHf21Load}</div>
										<div >${teapuestoGameList.teamVisitor} / ${teapuestoGameList.teamLocal}</div>
										</c:if>
										
								</a>
					
					
								<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHf1xLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=L/E&valor=${teapuestoGameList.teHf1xLoad}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHf1xLoad>0}">
									 	<div style="float: left; width: 30px;">L/E</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHf1xLoad}</div>
										<div >${teapuestoGameList.teamLocal} / EMPATE</div>
										</c:if>
										
								</a>
								
								<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHfXxLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=E/E&valor=${teapuestoGameList.teHfXxLoad}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHfXxLoad>0}">
									 	<div style="float: left; width: 30px;">E/E</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHfXxLoad}</div>
										<div >EMPATE / EMPATE</div>
										</c:if>
										
								</a>
								
									<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHf2xLoad>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=V/E&valor=${teapuestoGameList.teHf2xLoad}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHf2xLoad>0}">
									 	<div style="float: left; width: 30px;">V/E</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHf2xLoad}</div>
										<div >${teapuestoGameList.teamVisitor} / EMPATE</div>
										</c:if>
										
								</a>
								
									<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHf12Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=L/V&valor=${teapuestoGameList.teHf12Load}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHf12Load>0}">
									 	<div style="float: left; width: 30px;">L/V</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHf12Load}</div>
										<div >${teapuestoGameList.teamLocal} / ${teapuestoGameList.teamVisitor}</div>
										</c:if>
										
								</a>
								
								
									<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHfX2Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=E/V&valor=${teapuestoGameList.teHfX2Load}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHfX2Load>0}">
									 	<div style="float: left; width: 30px;">E/V</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHfX2Load}</div>
										<div >EMPATE / ${teapuestoGameList.teamVisitor}</div>
										</c:if>
										
								</a>
								
								<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teHf22Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=V/V&valor=${teapuestoGameList.teHf22Load}${general}';"
									 </c:if>
									 	> 
									 	
									 	<c:if test="${teapuestoGameList.teHf22Load>0}">
									 	<div style="float: left; width: 30px;">V/V</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teHf22Load}</div>
										<div >${teapuestoGameList.teamVisitor} / ${teapuestoGameList.teamVisitor}</div>
										</c:if>
										
								</a>
								</div>
								</c:if>

						<c:if test="${teapuestoGameList.teSum01Load>0 || teapuestoGameList.teSum23Load>0 || teapuestoGameList.teSum4mLoad>0}">
						<div  align="center">
						<c:if test="${teapuestoGameList.teSum01Load>0 || teapuestoGameList.teSum23Load>0 || teapuestoGameList.teSum4mLoad>0}">
						<div style="font-size: 13px">
								<b>Rango Goles</b>								
						</div>
						</c:if>
						
							<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.teSum01Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=G01&valor=${teapuestoGameList.teSum01Load}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.teSum01Load>0}">
									<div style="float: left; width: 30px;">G01</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.teSum01Load}</div>
									<div>0 - 1 GOLES </div>
								</c:if>			
								
							</a>
					


							<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.teSum23Load>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=G23&valor=${teapuestoGameList.teSum23Load}${general}';"
								 </c:if>
									 	> 
									 	
							 	<c:if test="${teapuestoGameList.teSum23Load>0}">
									 	<div style="float: left; width: 30px;">G23</div>
									 	<div style="float: left; width: 30px;">${teapuestoGameList.teSum23Load}</div>
										<div>2 - 3 GOLES </div>
								</c:if>
										
								</a>
					


					
								<a  id="addShopingTeapuesto"
									
									<c:if test="${teapuestoGameList.teSum4mLoad>0}">
									data-role="button" style="width: 85%; font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=G4+&valor=${teapuestoGameList.teSum4mLoad}${general}';"
									</c:if>
									>		
									<c:if test="${teapuestoGameList.teSum4mLoad>0}">
									<div style="float: left; width: 30px;">G4+</div>	
									<div style="float: left; width: 30px;">${teapuestoGameList.teSum4mLoad}</div>
									<div>CUATRO A MAS GOLES </div>
									</c:if>
								</a>
					
					</div> 
					</c:if>
					<BR>
					<c:if test="${teapuestoGameList.te_score_>0 && !empty teapuestoGameList.te_score_ }">
					<a href="#" onclick="window.location.href='game_teapuesto_show_bet_exact.html?event=${teapuestoGameList.eventpk.event}&draw=${teapuestoGameList.eventpk.draw}&game=${teapuestoGameList.eventpk.game}';"
					   data-role="button"  style="width: 85%;font-size: 10px;" data-theme="b">		
		             Marcador Exacto		 
		              </a>
		              </c:if>
			
					  <a href="#" onclick="window.location.href='game_teapuesto_show_menu.html';" data-role="button"  style="width: 85%;font-size: 10px;" data-theme="b">		
		              Elegir otro partido		 
		              </a>
					<BR>
					
					
				</li>
			</ul>
 
   </div>
    <BR>
   
	<jsp:include page="../../include/footer.jsp" />
 
 
	
</body>
</html>
