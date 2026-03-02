<%@page contentType="text/html" pageEncoding="utf-8"%>
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


<!-- End Google Tag Manager -->  
<!-- <!--  <meta charset="utf-8">  --> 
<!-- <meta http-equiv='Content-Type' content='text/html; charset=iso-8859-1' > -->
<!-- <meta charset="UTF-8"> -->


<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- <meta http-equiv="Content-Type" content="text/html"> -->
<meta http-equiv="Cache-control" content="no-cache">
<meta http-equiv="Expires" content="-1">


<link href="layer-view-style/v2/pagination.css" rel="stylesheet"
	type="text/css">

<title>La Tinka : Bono Otros Juegos</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="layer-view-style/client/main.css?v=3" type="text/css" />	
<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	

<style type="text/css">
ul, li {
	list-style: none;
}

#wrapper {
	width: 900px;
	margin: 20px auto;
}



.data-container {
	margin-top: 5px;
}

.data-container ul {
	padding: 0;
	margin: 0;
}

.data-container li {
	margin-bottom: 5px;
	padding: 5px 10px;
	background: #eee;
	color: #666;
}
</style>



<script type="text/javascript" src="layer-view-script/jquery.js"></script>
<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>" charset="UTF-8"></script>


</head>
<body>

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
						<div class="main-page" id="billetera3-jg-main-page">
							<div class="main-wallet">
								<div class="top-wallet-jg">
									<div class="jg-wallet">
										<h2>JUGADAS GRATIS</h2>
									</div>
								</div>
							</div>
						</div>
						<div class="main-page" id="billetera3-tt-main-page">
							<div class="main-wallet">
								<div class="top-wallet-jg">
									<div class="jg-tt-wallet">
										<h3>Total de jugadas</h3>
										<h1>${bonoOtro}</h1> <input type="hidden" id="totJug" value="${bonoOtro}"/> 
									</div>

								</div>
							</div>
						</div>
						
						<div class="body-move" >
							<div class="margin-move">&nbsp;</div>
							<c:if test="${not empty bonoOtroFecha}">
								<div class="center-move">
									<p>* Revisar la fecha de expiración de las jugadas gratis.</p>
								</div>
							</c:if>
							<div class="body-wallet-jg">
								<ul class="accordion">

									<c:forEach var="item" items="${header_bono_otro}">
										<li class="accordion-item ${item.idGame}" style="${item.visible}"
											data-game='${item.idGame}'>
											  
											
											<div 
												class="accordion__title selected" data-game="${item.idGame}" >
												<input type="hidden" id="expira_${item.idGame}" value="${item.expireDate}">
												<c:if test="${item.idGame eq 29}">
													<h3>${fn:replace(item.nameGame, ' ', '<br>')} </h3>
												</c:if>
												<c:if test="${item.idGame ne 29}">
													<h3>${item.nameGame} </h3>
												</c:if>
												<c:if test="${item.games eq 1}">
													<h4>${item.games} jugada  </h4>
												</c:if>
												<c:if test="${item.games ne 1}">
													<h4>${item.games} jugadas </h4>
												</c:if>
											</div>
											
											
											<div class="subcontent" style="overflow: hidden; display: none;">
												<table class="subcontent-table" style="margin-left: 3px; width: 98%;">
													<thead>
														<tr><th>
														<c:if test="${item.idGame eq 41}">
															<div style="display: flex; justify-content: space-between;">
																Costo por jugada S/ ${item.unitPriceBonus} 
																<div style=" color: #FF0000; margin-left: -45px; font-size: 0.8em; margin-top: 0px;">												
																	<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
	        													</div>
															</div>
														</c:if>
														<c:if test="${item.idGame eq 164}">
														<div style="display: flex; justify-content: space-between;">
															Costo por jugada S/ ${item.unitPriceBonus}
															<div style=" color: #FF0000; margin-left: -45px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div>
														</div>
														</c:if>
														<c:if test="${item.idGame eq 4}">
														<div style="display: flex; justify-content: space-between;">
															Costo por jugada S/ ${item.unitPriceBonus}
															<div style=" color: #FF0000; margin-left: -45px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div> 
														</div>
														</c:if>
														<c:if test="${item.idGame eq 42}">
														<div style="display: flex; justify-content: space-between;">
															Costo por jugada S/ ${item.unitPriceBonus}
															<div style=" color: #FF0000; margin-left: -45px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div> 
														</div>
														</c:if>
														<c:if test="${item.idGame eq 1121}">
														<div style="display: flex; justify-content: space-between;">
															<p style=" margin: 0;">Costo por jugada referencial <br> S/ ${item.unitPriceBonus}</p>
															<div style=" color: #FF0000; margin-left: -45px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div>
														</div>
														</c:if>
														<c:if test="${item.idGame eq 29}">
														<div style="display: flex; justify-content: space-between;">
															<p style=" margin: 0;">Costo por jugada referencial<br> S/ ${item.unitPriceBonus}</p>
															<div style=" color: #FF0000; margin-left: -45px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div>
														</div>
														</c:if>
														<c:if test="${item.idGame eq 30}">
														<div style="display: flex; justify-content: space-between;">
															<p style=" margin: 0;">Costo por jugada referencial <br>S/ ${item.unitPriceBonus}</p>
															<div style=" color: #FF0000; margin-left: -45px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div>
														</div>
														</c:if>
														<c:if test="${item.idGame eq 31}">
														<div style="display: flex; justify-content: space-between;">
															Costo por jugada referencial S/ ${item.unitPriceBonus}
															<div style=" color: #FF0000; margin-left: 25px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div>
														</div>
														</c:if>
														<c:if test="${item.idGame eq 33}">
														<div style="display: flex; justify-content: space-between;">
															Costo por jugada S/ ${item.unitPriceBonus}
															<div style=" color: #FF0000; margin-left: 25px; font-size: 0.8em; margin-top: 0px;">												
																<img src="layer-view-image/client/icon_info_red.svg" style="height: 8px; width: 11px;">Expiran el ${bonoOtroFechaFormat}
        													</div>
														</div>
														</c:if>
														</th></tr>
													</thead>
												</table>
											</div>
											
											
											<div class="subcontent" >
												<input type='hidden' id="maxRows-${item.idGame}" />

												<div>
														<section>
															<div class="data-container"></div>
															<div id="pagination-${item.idGame}"></div>

														</section>
													</div>

												<c:if test="${item.idGame eq 4}">

													<div class="juega">
														<a href="game_ganagol_show_menu.html">Jugar ahora</a>
													</div>

													
												</c:if>
												<c:if test="${item.idGame eq 29}">


													<div class="juega">
														<a href="#" onclick="toJuegosVirtuales('virtuales')">Jugar ahora</a>
													</div>

													
												</c:if>
												<c:if test="${item.idGame eq 41}">
												
													<div class="juega">
														<a href="game_tinka_show_menu.html">Jugar ahora</a>
													</div>
												</c:if>
												<c:if test="${item.idGame eq 42}">
													
													<div class="juega">
														<a href="game_kabala_show_menu.html">Jugar ahora</a>
													</div>
												</c:if>
												<c:if test="${item.idGame eq 164}">
														
													<div class="juega">
														<a href="game_ganadiario_show_menu.html">Jugar ahora</a>
													</div>
												</c:if>
												<c:if test="${item.idGame eq 1121}">

													<div class="juega">
														<a href="game_kinelo_show_home.html">Jugar ahora</a>
													</div>
												</c:if>
												<c:if test="${item.idGame eq 30}">

													<div class="juega">
														<a href="#" onclick="toJuegosVirtuales('ganaya');">Jugar ahora</a>
													</div>
												</c:if>
												<c:if test="${item.idGame eq 31}">

													<div class="juega">
														<a href="#" onclick="toJuegosVirtuales('casino');">Jugar ahora</a>
													</div>
												</c:if>
												<c:if test="${item.idGame eq 33}">

													<div class="juega">
														<a href="game_video_loterias_show_menu.html">Jugar ahora</a>
													</div>
												</c:if>
											</div>
											  
											 
											
											
										</li>
									</c:forEach>
								</ul>
							</div>
							
							 <br/>
							 <br/>
							 <br/>
							 <br/>
                 			 <br/>
                 			  <br/>					    
							
						</div>
						
					</section>
				</c:if>
			</div>


		</div>

	</div>
		<jsp:include page="../include/footer.jsp" /> 


<script src="layer-view-script/jquery-1.8.2.min.js"></script>
<script src="layer-view-script/pagination.js"></script>

<script type="text/javascript">
	
	var gameid = "";
	var gamename = "";
	var listDetalle="";
	var expiredate = "";
	$('.accordion-item').on("click", function (){ 
		gameid = $(this).attr("data-game");
		expiredate = $("#expira_"+gameid).val();
		
		if ($('.accordion-item').attr('class').indexOf(' '+gameid+' opened') == -1){			
			//var listDetalle = "";		
			$.ajax({ url: 'client_balance_bono_games_show_other.html',
				data: "gameId=" + gameid,
				type: 'get',
				dataType: 'json',
				success: function (response) {
					
					listDetalle = response;
					data = response;
					var string = '<p>* Revisar la fecha de expiración de las jugadas gratis.</p>';  
					$(".body-move .center-move").html(string);
		 			pagination(gameid,listDetalle);
		 			
				},
				error: function (e) {
					console.log(e);
				}
	
			});
		}

	});


function reempazar(desc){
	
}
	

function pagination(name,source){
$(function(){

		  (function(name) {
		    var container = $('#pagination-' + name);
			  
		    var sources = function () {
		      var result = [];
		      return source;
		    }();

		    var options = {
		      dataSource: sources,
		      callback: function (response, pagination) {
		        //window.console && console.log(response, pagination);

		        var dataHtml ="<table class='subcontent-table' style='margin-left: 3px; width: 98%;'>";
									
		        if(parseInt(name)==30 || parseInt(name)==31 || parseInt(name)==29){
		        	dataHtml +=  "<thead>"+
					"<tr>"+
	        		"<th>Descripción</th>"+
	        		"<th>Cant.</th>"+
	        		"<th><center>Saldo</center></th>"+
	        		"<th><center>Monto S/</center></th>"+
	        		"<th><center>Fecha</center></th>"+
	        		"</tr>"+
	        		"</thead>";
		        }else{
		        	dataHtml +=  "<thead>"+
					"<tr>"+
	        		"<th>Descripción</th>"+
	        		"<th>Cant.</th>"+
	        		"<th><center>Saldo</center></th>"+        		
	        		"<th><center>Fecha</center></th>"+
	        		"</tr>"+
	        		"</thead>";	
		        }
		        
		        
        		
        		dataHtml+= "<tbody>";

		        $.each(response, function (index, item) {
		        	dataHtml +='<tr  class="row_grid">';
		        	var descripcion= item.description;
		          dataHtml += '<td align="left">' + descripcion + '</td>';
		          dataHtml += '<td align="left">' + item.loadAmount + '</td>';
		          dataHtml += '<td align="center">' + item.newAmount + '</td>';
		          if(parseInt(item.gameId)==30 || parseInt(item.gameId)==31 || parseInt(item.gameId)==29){
		        	  dataHtml += '<td align="center">' + item.newAmountMoney.toFixed(2) + '</td>';  
		          }
		          dataHtml += '<td align="center">' + item.balanceDateFormat + '</td>';
		          dataHtml +='</tr align="center">';
		          
		        });

		        dataHtml += '</tbody>';
		        dataHtml += '</table>';
        
		        container.prev().html(dataHtml);

		      }
		    };

		    container.addHook('beforeInit', function () {
		      window.console && console.log('beforeInit...');
		    });
		    container.pagination(options);

		    container.addHook('beforePageOnClick', function () {
		      window.console && console.log('beforePageOnClick...');
		    
		    });
		  
		  })(name);
	  })
		  
}

		$('a.body-button-move').click(function() {

			//valido si es el mismo
			if($(this).data("game")!=null && $.trim($(this).data("game"))!=""){
				var agame = $(this).data("game").split("_");
				
				if (gameid == agame[0]){
					//console.log("Entro aca validacion")
					$("#detalle-"+gameid).html("");
					gameid = "";
					return;
				}
				
				gameid = "";
				gamename = "";
				
				gameid = agame[0];
				gamename = agame[1];
			}
			
			var pageSize = 15;
			var from = 1;
			var to = pageSize;
			
			$("[class^=detalle-]").html("");
			openLoader();			
			//console.log("1)game=["+$(this).data("game")+"] gameid=["+gameid+"] gamename=["+gamename+"]");
// 			if($(this).data("game")!=null && $.trim($(this).data("game"))!=""){
// 				var agame = $(this).data("game").split("_");
// 				gameid = agame[0];
// 				gamename = agame[1];
// 			}						
			var listDetalle = "";		
			$.ajax({ url: 'client_balance_bono_games_show_other.html',
				data: "gameId=" + gameid + "&gameName=" + gamename,
				type: 'get',
				dataType: 'json',
				success: function (response) {
					listDetalle = response;
					data = response;					
		 			var html = "<div class='main-page' id='billetera3-main-page-list'>";
		 			html+= "<div class='wrap-accordion' id='billetera3-wrap-accordion-list'>";
		 			html+= "<div class='custom-accordion'>";
		 			html+= "<div id='results'>";
		 			html+= "<ul>"		 			
					//console.log(listDetalle);
		 			for(var i = 0; i < listDetalle.length; i++) {
		 				if (i > pageSize-1){break;}
		 				var val = listDetalle[i];
						html+= "<li class='single'>";
						html+= "<i></i>";
						html+= "<button type='button' data-modal='#popup' ";
						html+= "data-date='"+val.balanceDate+"'";
						html+= "data-desc='"+val.description+"'";
						html+= "class='btn btn-trans'>"+val.description;
						html+= "<span class='desc-single'><span class='date-year'>"+val.balanceDate+"</span></span>";
						html += "</button>";
						html += "</li>";
					}
		 			html += "</ul></div>";
		 			
		 			if (to < listDetalle.length){
		 				html += "<button type='button' id='viewmore' data-from="+(from+pageSize)+" data-to="+(to+pageSize)+" class='btn btn-white'>VER MÁS</button>";
		 			}
		 			
		 			html += "</div></div>";
		 			html += "<div id='popup' class='overlay'>";
		 			html += "<div class='popup popup-sm'>";
		 			html += "<a class='close js-close-modal' href='#'>&times;</a>";
		 			html += "<div class='main-modal'></div>";
		 			html += "</div>";
		 			html += "</div>";
		 			html += "</div>";
					$("#detalle-"+gameid).append(html);
				},
				error: function (e) {
					console.log(e);
				},
				complete: function(){
					closeLoader();
				}
			});
				
		});
		
	
		$('body').on('click', '#results li button' ,function(){

			var ico = $(this).siblings('i');
			$(ico).addClass('loading');
			
			var date = $(this).data('date');
			var desc = $(this).data('desc');

			var jqxhr = $.ajax({
				type: "GET",
				url: "./client_balance_bono_games_find_information.html?date=" + date + "&desc=" + desc,
			})
			.done(function(res) {
				//console.log("res: "+res);
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
		
		$('body').on('click', '#popup a' ,function(){
				
			closeModal();
		});
	

		$('body').on('click', '#viewmore', function () {
			//console.log("gameId="+gameid+"&gameName="+gamename);
		
			openLoader();
			var pageSize = 15;
			var from = $(this).data('from');
			var to = $(this).data('to');
			var listaDetalle = "";
			var jqxhr = $.ajax({
				type: "GET",
				url: "./client_balance_bono_games_show_other.html?from="+from+"&to="+to+"&gameId="+gameid+"&gameName="+gamename,
				dataType: 'json',
			})
			.done(function(res) {
				//console.log(res)
				listaDetalle = res;
				var html = "";
				var count = 0;
				//lista detalle 
				for(var i = from-1; i < listaDetalle.length; i++) {	
					count++;
					if (count <= pageSize){
						var val = listaDetalle[i];
						html+= "<li class='single'>";
						html+= "<i></i>";
						html+= "<button type='button' data-modal='#popup' data-date='"+val.balanceDate+"' data-desc='"+val.description+"' class='btn btn-trans'>"+val.description;
						html+= "<span class='desc-single'><span class='date-year'>"+val.balanceDate+"</span></span>";
						html += "</button>";
						html += "</li>";
					}else{break;}							
				}				
				$('#results ul').append(html);
				if (to < listaDetalle.length){
					//console.log("to "+to + "tamano lista"+ listaDetalle.length);
					from = to + 1;
					to = pageSize+to;
					$('#viewmore').data('from', from).data('to', to);
				}else{
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

</script>





</body>
</html>