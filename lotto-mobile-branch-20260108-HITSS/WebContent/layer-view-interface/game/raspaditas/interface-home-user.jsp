<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
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
	    <title>¡RaspaYá!: Juego de apuesta más popular en Lima, Perú - La Tinka</title>
    <meta name='description' content="Raspa y gana al instante" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaditas/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaditas/themeRaspaditas.css?v=2">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaditas/nice-select.css?v=2">
	
	<script src="<%=Constantes.RASPADITAS_SOURCE%>"></script>
	
	<script>
	function botonJuego(gameId, game, gamePrecio, gamePozo){    	
			var dataGame = game;
			var dataGameId = gameId;
			var dataGamePrecio = gamePrecio;
			var dataGamePozo = gamePozo;
			var precio_pozo = '<p>Gana hasta '+ dataGamePozo +'</p><p>Costo: '+ dataGamePrecio +'</p>';
			$(document).ready(function() {
				
			 if( dataGameId != "undefined"){	
					$('#gameId').val(dataGameId);
					$("#raspaditas-background").attr("style","background-image: url('layer-view-image/game/raspaditas/thumbnails/"+dataGameId+"-overlay.png');");
					$("#btnDemo").attr("href","game_raspaya_show_home.html?game="+ dataGame +"&mode=demo");
					$("#btnJuega").attr("href","game_raspaya_show_home.html?game="+ dataGame +"&mode=live");
					$('#precio-pozo').html('');
					$('#precio-pozo').append(precio_pozo);
					
					$('#popup1').addClass('opened');
			  }
			});  	
	}
	</script>
	
</head>
<body class="main-raspaditas">    
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
    
	<div class="black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		<jsp:include page="../../include/header.jsp" />
	</div>	
	<div class="content-wrap">
	<input type="hidden" id="gameId"/>
			<div class="content">
				<section class="main-section">
					<div class="main-game">
						<img src="layer-view-image/v2/header-raspaya.png">						
					</div>					
					<div class="main-lobby">
						<div class="game-desc">
						<h2>¡ELIGE UN JUEGO Y EMPIEZA A GANAR!</h2>
						</div>						
						<div>
							<div class="box">
				   				  <select id="filtro" style="display: none;">
							        <option value="todos">Ver todos</option>
							        <option value="porPrecio">Menor precio</option>
							        <option value="porPremio">Mayor premio</option>
							      </select>												
							</div>
						</div>						
						<div class="titular_home_raspaya">							 
							 <div>					 							 
							 	<div class="main-play">							
									<div id="games">
	    								<div id="todos" style="display:block;">
											<jsp:include page="include_todos.jsp" />											
										</div>										
										<div id="porPrecio" style="display:none;">
											<jsp:include page="include_por_precio.jsp" />
										</div>	
										<div id="porPremio" style="display:none;">
											<jsp:include page="include_por_premio.jsp" />
										</div>									    
									    <div class="modals">	
											<div id="popup1" class="overlay">
												<div class="popup">		
													<button class="pop-recharge__close" id="lightbox-recharge-ilot-pop-close" onclick="closeLightboxRaspaditas()" ></button>																					
										            <div class="raspaditaContent">
														<ul>
															<li>
																<div class="raspaditaItem">
																	<div class="imgcore" id="raspaditas-background"></div>
																	<div class="back1">
																		<div class="buttons">
																			<a class="btn btn--secondary" id="btnDemo">Modo pr&aacute;ctica</a>
																			<a class="btn btn--primary" id="btnJuega">Juega y Gana</a>
																		</div>																		
																	</div>
																</div>
															</li>															
														</ul>
													</div>										            										            																					
												</div>	
												<div id="precio-pozo" class="front">
													
												</div>											
											</div>										
										</div>	
									</div> 	
								</div>
								<br><br><br>
								<a href="libro-reclamaciones.html" target="_self">
									<img src="layer-view-image/client/book/linkbook.png" alt="tinka" style="height: 49px;width: 84px;">
								</a>		
							   <br><br><br>						 
							 </div>
							 						 							 
						</div>
					</div>
												
				</section>
			</div>
	</div>					
	<div style="display:none" class="f_error_mensaje">
	    <span class="close_f"></span>
		<div class="f_textoInterno msgraspa"></div>
	</div>
	<jsp:include page="../../include/footer.jsp" />
	<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
	<script type="text/javascript" src="layer-view-script/jquery.nice-select.min.js"></script>
	<script type="text/javascript" src="layer-view-script/fastclick.js"></script>
	
	<script type="text/javascript">		
		$(document).ready(function(){			
			$(".iivv-game").on("click",function(){
				var $this = $(this);
				var dataGame = $this.attr("data-game");
				var dataGameId = $this.attr("data-gameId");
				var dataGamePrecio = $this.attr("data-gamePrecio");
				var dataGamePozo = $this.attr("data-gamePozo");
				var precio_pozo = '<p>Gana hasta '+ dataGamePozo +'</p><p>Costo: '+ dataGamePrecio +'</p>';
				if( dataGameId != undefined){
					$('#gameId').val(dataGameId);
					$("#raspaditas-background").attr("style","background-image: url('layer-view-image/game/raspaditas/thumbnails/"+dataGameId+"-overlay.png');");
					$("#btnDemo").attr("href","game_raspaya_show_home.html?game="+ dataGame +"&mode=demo");
					$("#btnJuega").attr("href","game_raspaya_show_home.html?game="+ dataGame +"&mode=live");
					$('#precio-pozo').html('');
					$('#precio-pozo').append(precio_pozo);
					
					$('#popup1').addClass('opened');
				}	
			});
		});
		
		$(".close_f").on("click",function(){
			$(".f_error_mensaje").hide();			
		});
		
	    <c:if test="${nolive eq 1 }">
		  $('body').find('#cargando').remove();
		  $(".f_error_mensaje").show();
		  $(".f_textoInterno").html("Debes iniciar sesión para jugar");
	    </c:if>
	    
	    <c:if test="${nolive ne 1 && not empty config}">
	      $('body').append('<i id="cargando" class="loading" style="z-index: 2147483645 !important;"></i>');
	  	  hacksaw.include('game', <c:out value="${config}" escapeXml="false"/>);
	    </c:if>
	    
	    <c:if test="${nogame eq 1 }">
		  $('body').find('#cargando').remove();
		  $(".f_error_mensaje").show();
		  $(".f_textoInterno").html("El juego no está disponible");
	    </c:if>
	</script>	
	<script>
	    $(document).ready(function() {
	    $('select:not(.ignore)').niceSelect();      
	    FastClick.attach(document.body);
	  });    
	    $('#filtro').on('change', function () {
            switch (this.value) {
            case 'todos':
            	$('#'+this.value).show();
            	$('#porPrecio').hide();
            	$('#porPremio').hide();
                break;
            case 'porPrecio':
            	$('#'+this.value).show();
            	$('#todos').hide();
            	$('#porPremio').hide();
                break;            
            case 'porPremio':
            	$('#'+this.value).show();
            	$('#todos').hide();
            	$('#porPrecio').hide();
                break;
            default:
            	$('#'+this.value).show();
        		$('#porPrecio').hide();
        		$('#porPremio').hide();
                break;
          }
        });	    	    
	</script>  	
</body>
</html>