<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<!DOCTYPE html>
<html lang="es">
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta charset="utf-8">
<meta name="viewport" content="width=1024">

<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaditas/theme.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaditas/themeRaspaditas.css?v=2">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">

<!-- link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" / -->

<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>

<script src="<%=Constants.RASPADITAS_SOURCE%>"></script>

<title>¡RaspaYá!: Instantáneas virtuales, Perú - La Tinka</title>
<meta name="description" content="¡RaspaYá!">
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

<style>
html, body {
  height: 100%;
  padding: 0;
  margin: 0;
  width: 100%;
}
iframe {
  border: 0;
  height: 100%;
  width: 100%;
}
</style>

</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

	<%@ include file="../../include/header.jspf" %>
<script>
$("#plays-1").addClass("active");     	    	    
</script>
	<input type="hidden" value="${tinkaSale.numbersMore}" id="more_repeated">
	<input type="hidden" value="${tinkaSale.numbersLess}" id="less_repeated">
	<input type="hidden" value="${tinkaSale.status}" id="status">
	<input type="hidden" value="${tinkaSale.simpleBetPrice}" id="simpleBetPrice_repeated">
	<input type="hidden" value="${tinkaSale.promotionType}" id="promo">
	<input type="hidden" value="${tinkaSale.priceType}" id="price_type">
	<input type="hidden" value="${tinkaSale.algorithm}" id="algorithm">
	<input type="hidden" value="${tinkaSale.bets}" id="bets">
	<input type="hidden" value="${tinkaSale.pay}" id="pay">
	<input type="hidden" value="${tinkaSale.cost}" id="cost">
	<input type="hidden" value="${tinkaSale.draws}" id="draw">
	<input type="hidden" value="${tinkaSale.balanceAmountGame}" id="balanceAmountGame">
	<input type="hidden" value="${tinkaSale.balanceQuantityGame}" id="balanceQuantityGame">
	<input type="hidden" value="<%=Constants.iflexBonoTyC.toString().trim()%>" id="iflexBonoTyC" />
	<input type="hidden" value="<%=Constants.wbBonoTyC.toString().trim()%>" id="wbBonoTyC">
	<input type="hidden" value="<c:out value='${clientBalance}'/>" id="clientBalance" >
	<input type="hidden" value="<c:out value='${chargeData}'/>" id="chargeData">
	<input type="hidden" id="totalPagar">
	<input type="hidden" id="mode" value="${mode}">
		
	<div class="main-content">
		<div class="main-page">
			<div class="main-game main-raspaditas">				
				<div class="row">
					<div class="col-12 col-md-8">
						<div class="box-main-game top-box">
							<div class="top-banner top-tinka">
								<figure>
									<img src="layer-view-image/v2/header_lobby.png" alt="" />
								</figure>
								<div class="body-banner">
									<div class="left-banner">
										<div class="banner-price">
											<div class="sub-banner">
                                               
                                            </div>
										</div>
									</div>									
								</div>
							</div>
						</div>
						<div class="main-panel">							
							<div class="main-play">							
								<div id="games">    						
								    <div class="GridWrapper">
									    <div class="midiv">
									    <iframe  width="100%" height="100%" id="game"></iframe>
									    </div>								        
								    </div>
								</div> 																
							</div>									
						</div>
					</div>
					<div class="col-12 col-md-4">
						<aside class="banner">
		        			<div class="boxes-banner">
								<div id="iframeTool">
		        					<iframe id="myIframe" src="${iframeHomeRaspaYaURL}" frameborder="0" scrolling="no" ><p>Is imposible, your browser dont support iframe</p></iframe>
		        				</div>		        				
			        			<div class="box-banner">
			        				<a href="https://www.facebook.com/LaTinkaLoterias" target="_blank" class="box-social">
			        					<img src="./layer-view-image/v2/facebook.png" alt="" />
			        				</a>
			        			</div>
			        		</div>
			        	</aside>
					</div>
				</div>
			</div>
		</div>
	</div>		
	<script>	  
	  hacksaw.include('game', <c:out value="${config}" escapeXml="false"/>);

	  var source;
	  var messageSource;
	  var messageOrigin;	  
	  var origin;

	if ( window.addEventListener ) {
		    window.addEventListener('message', handleMessage, false);
	} else if ( window.attachEvent ) {
		    window.attachEvent('onmessage', handleMessage);
	}
	  
	var HacksawIntegrate = {
      updateInGameBalance: function(data) {
        var messageData = {
          actionType: 'updateInGameBalance'
        };
        messageSource.postMessage(messageData, messageOrigin);
      }
    };
	
	 function handleMessage(e) {
		 
		 messageSource = e.source;
		 messageOrigin = e.origin;
		 
		 if( $("#mode").val() == 'live' ){
			 switch (e.data.eventType) {
		         case 'onGameLoaded':
		             // Loaded will be the first event, set source and origin
		             source = e.source;
		             // origin is used when a message is posted
		             origin = e.origin;
		             console.log('The as onGameLoaded ');
		             break;
		         case 'onRoundStarted':
		             console.log('The round has started');
		             break;
		         case 'onBetAccepted':
		             console.log('The  has onBetAccepted');
		             $.ajax({
		                 type: "POST",
		                 url: "load_recharge.html",
		                 dataType: "json",
		                 async: false,
		                 success: function (data) {
		                 	$("#clientSale-amount").text(floatFormat(data.billetera1));
		                 	$("#billetera2-amount").text(data.billetera2);
		                 	$("#billetera3-amount").text(data.billetera3);
		                 	$("#clientSale-amount-2").text(floatFormat(data.billetera1));
		                 }
		         	 });
		             break; 
		         case 'onRoundEnded':
		             console.log('The round has ended');
		             $.ajax({
		                 type: "POST",
		                 url: "load_recharge.html",
		                 dataType: "json",
		                 async: false,
		                 success: function (data) {
		                 	$("#clientSale-amount").text(floatFormat(data.billetera1));
		                 	$("#billetera2-amount").text(data.billetera2);
		                 	$("#billetera3-amount").text(data.billetera3);
		                 	$("#clientSale-amount-2").text(floatFormat(data.billetera1));
		                 }
		         	 });
		             break;    
			 }
		 }	 
	 }
	 
	 function refreshBalance(){		 	 
		 window.HacksawIntegrate.updateInGameBalance();
	 }
	 
	</script>
    <script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='layer-view-script/common/jquery.scripts.js'></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<%@ include file="../../include/footer.jspf" %> 
</body>
</html>