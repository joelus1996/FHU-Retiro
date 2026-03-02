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
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaya/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaya/themeRaspaya.css">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	
	<style>   
    .mainContent {
      float:left;
      width:100%;
      height:87.5vh;
      border: hidden;
    }
    
    @media (orientation: landscape){
	    .mainContent {
	      float:left;
	      width:100%;
	      height:81vh;
	      border: hidden;
	    }
    }
    #header {
	  background-color: #f78f1e;
	  height: 64px;
	  position: relative;
	  overflow: hidden;
	  width: 100%;
	  z-index: 10;
	}
  </style>
</head>
<body >    
<h1 style="display: none;">RaspaYa: Juegos de Raspa y Gana Online</h1>
<div class="black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
	<jsp:include page="../../include/header.jsp" />
</div>							  	
	
<div class="titular_home_casino">							 
	 <div>					 							 
	 	<div class="main-play">							
			<div id="games">
				<div class="modals">	
					<div id="popup2" class="overlay overlay-casino-game opened">
						<div class="popup popup-casino-game">		
							<iframe frameborder="0" height="100%" width="100%" src="${lobbyIframe}">
							</iframe>										            										            																					
						</div>																					
					</div>										
				</div>
			</div> 	
		</div>		  							 
	 </div>							 							 
</div>						  	

<jsp:include page="../../include/footer.jsp" />
</body>
<script>

function actualiza_saldo(){
	$.ajax({
        type: "POST",
        url: "load_recharge.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	$("#clientSale-amount").text("S/ "+floatFormat(data.billetera1));
        	$("#billetera2-amount").text(data.billetera2);
        	$("#billetera3-amount").text(data.billetera3);
        	$("#clientSale-amount-menu-lateral").text("S/ "+floatFormat(data.billetera1));
        }
	});
}

$(".jsBtnIcon").click(function () {
	actualiza_saldo();
});

$("#open-button").click(function () {
	actualiza_saldo();
});

</script>
</html>