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
<title>Te Apuesto : Marcador Exacto</title>		
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"> 
<link rel="stylesheet" 	href="layer-view-style/common/jquery.mobile-1.0.min.css" type="text/css" />
<link rel="stylesheet" href="layer-view-style/game/teapuesto/theme.css" />
<script type="text/javascript" 	src="layer-view-script/jquery-1.6.4.min.js"></script>
<script type="text/javascript" 	src="layer-view-script/jquery.mobile-1.0.min.js"></script> 
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<meta name='description' content='Te Apuesto móvil, marcador exacto' />
	
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


<div style="text-align: center;font-size: 13px" ><b>MARCADORES EXACTOS</b></div>
<div data-role="fieldcontain" align="center" style="font-size: 12px;">
    <fieldset data-role="controlgroup" data-type="horizontal">
    <div style="width: 300px; text-align: center;" align="center">	
		<input type="radio" id="local" /><label for="local" style="height:37.6px;font-size: 11px;" id="local11" >&nbsp;&nbsp;Local</label>
		<input type="radio" id="empate" /><label for="empate" style="height:37.6px;font-size: 11px;" id="empate">&nbsp;&nbsp;Empate</label>
		<input type="radio" id="visita" /><label for="visita" style="height:37.6px;font-size: 11px;" id="visita">&nbsp;&nbsp;Visitante</label>
		
	</div>
    </fieldset>
    </div>
    
    
<script type="text/javascript">
$("#local_w").show();
$("#empate_w").hide();
$("#visita_w").hide();


 $("#empate").click(function(){
	 $("#local_w").hide();
	  $("#empate_w").show();
	  $("#visita_w").hide();
	  $("#empate").addclass("ui-lbl-up-f");
	 });


 $("#local").click(function(){
	 $("#local_w").show();
	  $("#empate_w").hide();
	  $("#visita_w").hide();
	  $("#local11").addclass("ui-lbl-up-f");
	  $("#local").addclass("ui-lbl-up-f");
	 });


 $("#visita").click(function(){
	 $("#local_w").hide();
	  $("#empate_w").hide();
	  $("#visita_w").show();
	  $("#visita").addclass("ui-lbl-up-f");
	 });

</script>

 					<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
					<div  align="center" id="local_w">
						<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
						<div style="font-size: 13px">
								 <b>LOCAL</b>								
						</div>
						</c:if>
							<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_1_0>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S1-0&valor=${teapuestoGameList.score_1_0}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_1_0>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_1_0}</div>
									<div>${teapuestoGameList.teamLocal} 1-0 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
					
							<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_2_0>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S2-0&valor=${teapuestoGameList.score_2_0}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_2_0>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_2_0}</div>
										<div > ${teapuestoGameList.teamLocal} 2-0 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
								<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_2_1>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S2-1&valor=${teapuestoGameList.score_2_1}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_2_1>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_2_1}</div>
										<div > ${teapuestoGameList.teamLocal} 2-1 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
					
					
									<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_3_0>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S3-0&valor=${teapuestoGameList.score_3_0}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_3_0>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_3_0}</div>
										<div > ${teapuestoGameList.teamLocal} 3-0 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
								<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_3_1>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S3-1&valor=${teapuestoGameList.score_3_1}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_3_1>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_3_1}</div>
										<div > ${teapuestoGameList.teamLocal} 3-1 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
								<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_3_2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S3-2&valor=${teapuestoGameList.score_3_2}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_3_2>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_3_2}</div>
										<div > ${teapuestoGameList.teamLocal} 3-2 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
										<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_4_0>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S4-0&valor=${teapuestoGameList.score_4_0}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_4_0>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_4_0}</div>
										<div > ${teapuestoGameList.teamLocal} 4-0 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
								<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_4_1>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S4-1&valor=${teapuestoGameList.score_4_1}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_4_1>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_4_1}</div>
										<div > ${teapuestoGameList.teamLocal} 4-1 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
										<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_4_2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S4-2&valor=${teapuestoGameList.score_4_2}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_4_2>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_4_2}</div>
										<div > ${teapuestoGameList.teamLocal} 4-2 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
									<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_4_3>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S4-3&valor=${teapuestoGameList.score_4_3}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_4_3>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_4_3}</div>
										<div > ${teapuestoGameList.teamLocal} 4-3 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
									<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_5m_0>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5+-0&valor=${teapuestoGameList.score_5m_0}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_5m_0>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_5m_0}</div>
										<div > ${teapuestoGameList.teamLocal} 5+-0 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
										<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_5m_1>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5-1&valor=${teapuestoGameList.score_5m_1}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_5m_1>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_5m_1}</div>
										<div > ${teapuestoGameList.teamLocal} 5+-1 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
										<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_5m_2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5-2&valor=${teapuestoGameList.score_5m_2}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_5m_2>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_5m_2}</div>
										<div > ${teapuestoGameList.teamLocal} 5+-2 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
										<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_5m_3>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5-3&valor=${teapuestoGameList.score_5m_3}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_5m_3>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_5m_3}</div>
										<div > ${teapuestoGameList.teamLocal} 5+-3 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
								<a  id="addShopingTeapuesto"
								
								<c:if test="${teapuestoGameList.score_5m_4>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5-4&valor=${teapuestoGameList.score_5m_4}${general}';"
									
								 </c:if>
									 	> 
							 
									 	
							 	<c:if test="${teapuestoGameList.score_5m_4>0}">
									 	<div style="float: left; width: 30px;">${teapuestoGameList.score_5m_4}</div>
										<div > ${teapuestoGameList.teamLocal} 5+-4 ${teapuestoGameList.teamVisitor}</div>
								</c:if>
								</a>
								
								
										<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_5_5>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5-5&valor=${teapuestoGameList.score_5_5}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_5_5>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_5_5}</div>
									<div>${teapuestoGameList.teamLocal} 5+-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
					</div> 
					</c:if>


					<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
					<div  align="center" id="empate_w">
						<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
						<div style="font-size: 13px">
								 <b>EMPATE</b>								
						</div>
						</c:if>
							<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.te_score_>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S0-0&valor=${teapuestoGameList.te_score_}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.te_score_>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.te_score_}</div>
									<div>${teapuestoGameList.teamLocal} 0-0 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_1_1>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S1-1&valor=${teapuestoGameList.score_1_1}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_1_1>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_1_1}</div>
									<div>${teapuestoGameList.teamLocal} 1-1 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
									<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_2_2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S2-2&valor=${teapuestoGameList.score_2_2}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_2_2>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_2_2}</div>
									<div>${teapuestoGameList.teamLocal} 2-2 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
									<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_3_3>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S3-3&valor=${teapuestoGameList.score_3_3}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_3_3>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_3_3}</div>
									<div>${teapuestoGameList.teamLocal} 3-3 ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
							
							
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_4_4>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S4-4&valor=${teapuestoGameList.score_4_4}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_4_4>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_4_4}</div>
									<div>${teapuestoGameList.teamLocal} 4-4 ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
								
										<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_5_5>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5-5&valor=${teapuestoGameList.score_5_5}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_5_5>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_5_5}</div>
									<div>${teapuestoGameList.teamLocal} 5+-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
							

					</div> 
					</c:if>

					
				
					<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
					<div  align="center" id="visita_w">
						<c:if test="${teapuestoGameList.unoXLoad>0 || teapuestoGameList.unoDosLoad>0 || teapuestoGameList.xDosLoad>0 }">
						<div style="font-size: 13px">
								 <b>VISITA</b>								
						</div>
						</c:if>
							<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_0_1>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S0-1&valor=${teapuestoGameList.score_0_1}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_0_1>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_0_1}</div>
									<div>${teapuestoGameList.teamLocal} 0-1 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_0_2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S0-2&valor=${teapuestoGameList.score_0_2}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_0_2>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_0_2}</div>
									<div>${teapuestoGameList.teamLocal} 0-2 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
									<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_1_2>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S1-2&valor=${teapuestoGameList.score_1_2}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_1_2>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_1_2}</div>
									<div>${teapuestoGameList.teamLocal} 1-2 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
									<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_0_3>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S0-3&valor=${teapuestoGameList.score_0_3}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_0_3>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_0_3}</div>
									<div>${teapuestoGameList.teamLocal} 0-3 ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
							
							
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_1_3>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S1-3&valor=${teapuestoGameList.score_1_3}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_1_3>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_1_3}</div>
									<div>${teapuestoGameList.teamLocal} 1-3 ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
								
										<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_2_3>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S2-3&valor=${teapuestoGameList.score_2_3}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_2_3>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_2_3}</div>
									<div>${teapuestoGameList.teamLocal} 2-3 ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
								
								
								
								
								
								
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_0_4>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S0-4&valor=${teapuestoGameList.score_0_4}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_0_4>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_0_4}</div>
									<div>${teapuestoGameList.teamLocal} 0-4 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_1_4>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S1-4&valor=${teapuestoGameList.score_1_4}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_1_4>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_1_4}</div>
									<div>${teapuestoGameList.teamLocal} 1-4 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
									<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_2_4>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S2-4&valor=${teapuestoGameList.score_2_4}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_2_4>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_2_4}</div>
									<div>${teapuestoGameList.teamLocal} 2-4 ${teapuestoGameList.teamVisitor} </div>
								</c:if>			
								
							</a>
							
									<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_3_4>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S3-4&valor=${teapuestoGameList.score_3_4}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_3_4>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_3_4}</div>
									<div>${teapuestoGameList.teamLocal} 3-4 ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
							
							
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_0_5m>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S0-5&valor=${teapuestoGameList.score_0_5m}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_0_5m>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_0_5m}</div>
									<div>${teapuestoGameList.teamLocal} 0-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
								
										<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_1_5m>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S1-5&valor=${teapuestoGameList.score_1_5m}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_1_5m>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_1_5m}</div>
									<div>${teapuestoGameList.teamLocal} 1-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
							
							
							<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_2_5m>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S2-5&valor=${teapuestoGameList.score_2_5m}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_2_5m>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_2_5m}</div>
									<div>${teapuestoGameList.teamLocal} 2-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
							
							
								<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_3_5m>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S3-5&valor=${teapuestoGameList.score_3_5m}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_3_5m>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_3_5m}</div>
									<div>${teapuestoGameList.teamLocal} 3-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
								
										<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_4_5m>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S4-5&valor=${teapuestoGameList.score_4_5m}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_4_5m>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_4_5m}</div>
									<div>${teapuestoGameList.teamLocal} 4-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>
								
										<a  id="addShopingTeapuesto"
							
								<c:if test="${teapuestoGameList.score_5_5>0}">	
									data-role="button" style="width: 85%;font-size: 10px;"
									href="#" onclick="window.location.href='game_teapuesto_show_shoppingcart.html?tipo=S5-5&valor=${teapuestoGameList.score_5_5}${general}';"
									
								 </c:if>
									 	> 
										
								<c:if test="${teapuestoGameList.score_5_5>0}">
									<div style="float: left; width: 30px;">${teapuestoGameList.score_5_5}</div>
									<div>${teapuestoGameList.teamLocal} 5+-5+ ${teapuestoGameList.teamVisitor} </div>
								</c:if>	
								</a>

					</div> 
					</c:if>
					
			    	<BR>
			    	<a href="#" onclick="window.location.href='game_teapuesto_show_bet.html?event=${teapuestoGameList.eventpk.event}&draw=${teapuestoGameList.eventpk.draw}&game=${teapuestoGameList.eventpk.game}';"
					data-role="button" style="width: 85%;font-size: 10px;" data-theme="b"  >
					Regresar 
					</a>
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
