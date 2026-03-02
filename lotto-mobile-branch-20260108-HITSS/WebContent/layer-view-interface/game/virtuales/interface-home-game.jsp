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
	    <title>Deportes Virtuales: Juego de Deportes virtuales, Perú - La Tinka</title>
    <meta name='description' content="Deportes Virtuales" />
	<meta name="viewport" content="width=device-width, height=device-height, initial-scale=1, shrink-to-fit=no">
	
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/virtuales/themeVirtuales.css?v=2">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />	
	<script src="layer-view-script/game/virtuales/font-awesome.js"></script>
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
  <link rel="canonical" href="https://www.latinka.com.pe/p/juega-virtuales.html">
</head>
<body >    
<div class="black-menu <c:set var = "black_menu" scope = "session" value = "black_menu"/>">
	<jsp:include page="../../include/header.jsp" />
</div>							  	
	
<div class="titular_home_casino">							 
	 <div>					 							 
	 	<div class="main-play">							
			<div id="games">
				<div class="modals">	
					<div id="popup2" class="overlay overlay-casino-game opened">
						<div class="popup popup-virtuales-game">		
							<div class="headerddvv"><a href="#" onclick="javascript:regresar()" class="link-ddvv"> ${regresarLobbyDDVV}</a></div>
							<iframe frameborder="0" allowfullscreen  width="100%" id="game" style="height:100vh;" src="${iframeVirtualesLobbyURL}"></iframe>										            										            																					
						</div>																					
					</div>										
				</div>
			</div> 	
		</div>		  							 
	 </div>							 							 
</div>						  	

<jsp:include page="../../include/footer.jsp" />
<script type='text/javascript' src='layer-view-script/game/virtuales/lotto-virtuales-game.js'></script>
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