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
	<script type="application/ld+json">
	{
  		"@context": "https://schema.org/",
  		"@type": "BreadcrumbList",
  		"itemListElement": [{
    		"@type": "ListItem",
    		"position": 1,
    		"name": "La Tinka",
    		"item": "https://m.latinka.com.pe/" 
  		},{
    		"@type": "ListItem",
    		"position": 2,
    		"name": "Jugar RaspaYa",
    		"item": "https://m.latinka.com.pe/game_raspaya_show_home.html" 
  		}]
	}
	</script>
	<meta name="robots" content="noindex">
	<meta property="og:title" content="RaspaYa: Juegos de Raspa y Gana Online | La Tinka">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://m.latinka.com.pe/game_raspaya_show_home.html">
	<meta property="og:description" content="¿Qué es RaspaYá? Encuentra diferentes juegos de raspa y gana online disponibles en cualquier momento en La Tinka. ¡Entra ahora y empieza a jugar!">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://m.latinka.com.pe/layer-view-image/v2/logo-ganagol.png">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
	    <title>RaspaYa: Juegos de Raspa y Gana Online | La Tinka</title>
    <meta name='description' content="¿Qué es RaspaYá? Encuentra diferentes juegos de raspa y gana online disponibles en cualquier momento en La Tinka. ¡Entra ahora y empieza a jugar!" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaya/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaya/themeRaspaya.css">
	<link rel="stylesheet"  href="layer-view-style/game/raspaya/categorias.css" type="text/css" media="all">
	<link rel="stylesheet"  href="layer-view-style/game/raspaya/main-raspaya.css" type="text/css" media="all">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaya/bootstrap-4.5.2.min.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaya/bootstrap-multiselect.min.css">

	<script src="layer-view-script/game/raspaya/font-awesome.js"></script>
<style>

/*Checkboxes styles*/
input[type="checkbox"] { display: none; }

input[type="checkbox"] + label {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 20px;
  font: 14px/20px 'Open Sans', Arial, sans-serif;
  color: #ddd;
  top: 9px;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
}

input[type="checkbox"] + label:last-child { margin-bottom: -11px; left: -30px;}

input[type="checkbox"] + label:before {
  content: '';
  display: block;
  width: 16px;
  height: 16px;
  border: 1px solid #01693F;
  position: absolute;
  left: 0;
  top: 2px;
  opacity: .6;
  -webkit-transition: all .12s, border-color .08s;
  transition: all .12s, border-color .08s;
}

input[type="checkbox"]:checked + label:before {
  width: 8px;
  top: 0px;
  left: 5px;
  border-radius: 0;
  opacity: 1;
  border-top-color: transparent;
  border-left-color: transparent;
  -webkit-transform: rotate(40deg);
  transform: rotate(40deg);
}

div::-webkit-scrollbar {
    display: none;
}
</style>	
<script>	
	var prodDisponibles = <c:out value="${productos}" escapeXml="false"/>;
	let aMasterProv = <c:out value="${providers}" escapeXml="false"/>;
	let aCategoryProviders = <c:out value="${categoryProviders}" escapeXml="false"/>;	
</script>
	
</head>
	
<body class="main-casino">    
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
  	<h1 style="display: none;">RaspaYa: Juegos de Raspa y Gana Online</h1>
    <span id="span-top"></span>
    <div id="div-totop" class="cmn-divfloat">
	    <a href="#span-top" target="_top" class="btn cmn-btncircle">
	        <i class="fas fa-chevron-up"></i>
	    </a>
	</div>
    
	<div class="black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
		<jsp:include page="../../include/header.jsp" />
	</div>	
	<div class="content-wrap">
	<input type="hidden" id="gameId"/>
			<div class="content">
				<section class="main-section">
					<div class="main-game-casino">
						<iframe id="myIframe" class="bannerMobile" src="<%= Constantes.iframeHomeBannerRaspaYaURL %>" frameborder="0" scrolling="no" style="overflow: hidden;width: 100%;"><p>Is imposible, your browser dont support iframe</p></iframe>						
					</div>					
					<div class="main-lobby">
						<input class="search"  placeholder="Buscar juego" id="buscador"  type="text"  />
						<button type="submit" class="btnLupa"><i></i></button>
						<div>
							<div id="tutorial" class="menu1">
								<ul class="list-categories">
									<li id="m-todos">
										<a href="javascript:juegos('todos');">Todos</a>
									</li>
									<li id="m-masjugados">
										<a href="javascript:juegos('masjugados');">Los m&aacute;s jugados</a>
									</li>
									<c:if test="${sesion eq 1 }">
									<li id="m-favoritos">
										<a href="javascript:juegos('favoritos');">Favoritos<img class="star-submenu" src="layer-view-image/game/casino/icon_star_off_menu.svg"></a>
									</li>
									</c:if>
								</ul>
							</div>
						</div>
						<div class="col-md-8-proveedor" style="margin-top: 8px;padding-left: 0;margin-bottom: 18px;text-align: left;">	
							<select name="sproveedor[]" multiple id="sproveedor">								   
							</select>								
						</div>
						<div class="titular_home_casino">							 
							 <div>					 							 
							 	<div class="main-play">							
									<div id="games">
	    								<div id="todos" style="display:block;">
											<jsp:include page="include_todos.jsp" />											
										</div>	
										<div class="modals">	
											<div id="popup1" class="overlay">
												<div class="popup">		
													<button class="pop-recharge__close-casino" id="lightbox-recharge-ilot-pop-close" onclick="closeLightboxRaspaditas()" ></button>																					
										            <div class="raspaditaContent">
														<ul>
															<li>
																<div class="casinoItem">
																	<div class="imgcore" id="raspaya-background"></div>
																	<div class="back2">
																		<div class="buttons">
																			<a class="btn btn--secondary" data-href="" id="btnDemo">Modo pr&aacute;ctica</a>
																			<a class="btn btn--primary" data-href="" id="btnJuega">Juega y Gana</a>
																		</div>																		
																	</div>
																</div>
															</li>															
														</ul>
													</div>										            										            																					
												</div>																					
											</div>										
										</div>
									</div> 	
								</div>	
							   <br><br><br><br><br><br><br><br>
							    <a href="libro-reclamaciones.html" target="_self" id="libroreclama">
									<img src="layer-view-image/client/book/linkbook.png" alt="tinka" style="height: 49px;width: 84px;">
								</a>		
							   <br><br><br><br>
							   <br><br><br><br><br><br><br><br><br>
							   <br><br><br><br><br>
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
<script src="layer-view-script/game/raspaya/bootstrap.min.js"></script>	
<script src="layer-view-script/game/raspaya/bootstrap-multiselect.min.js"></script>
<script type='text/javascript' src='layer-view-script/game/raspaya/lotto-raspaya.js'></script>
	
<script type="text/javascript">				 
	<c:if test="${nolive eq 1 }">
	  $('body').find('#cargando').remove();
	  $(".f_error_mensaje").show();
	  $(".f_textoInterno").html("Debes iniciar sesión para jugar");
    </c:if>    
    <c:if test="${nolive eq 2 }">
	  $('body').find('#cargando').remove();
	  $(".f_error_mensaje").show();
	  $(".f_textoInterno").html("Juego no disponible, elige otro");
    </c:if>	   
</script>	
</body>
</html>