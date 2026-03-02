<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	    <title>Casino: Juego de apuesta más popular en Lima, Perú - La Tinka</title>
    <meta name='description' content="Casino" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/theme.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/casino/themeCasino.css?v=2">
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
  <script>
  window.location.replace("${lobbyIframe}");
  </script>
  
</head>
<body >    
<div class="titular_home_casino">							 
	 <div>					 							 
	 	<div class="main-play">							
			<div id="games">
				<div class="modals">	
					<div id="popup2" class="overlay opened">
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
</body>
</html>