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
	<title>La Tinka : Lista de Premios</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/client/mainPrize.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>	
	
</head>
<body style="background: #ffffff;">
	
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<div class="container">

		<jsp:include page="../include/header.jsp" />
		<div class="content-wrap">
			<div class="content">
				<section class="main-section" style="background-color: #fbe601;">	
					<div class="main-page" id="prize-title-total-main-page">
						<div class="main-wallet">
							<div class="top-wallet-jg">
								<div class="jg-wallet">
									<h2>MIS PREMIOS</h2>
								</div>
							</div>
						</div>
					</div>
				</section>	
				<div class="prize-content-iframe">
					<div class="main-page" id="prize-total-balance-main-page">
						<div class="main-wallet">
							<div class="top-wallet-jg">
								<div class="jg-tt-wallet">
									<h3>Disponible para retirar</h3>
									<h1 id="total-balance">${saldoLiquidableCompleto}</h1>
									<button id="showPaymentPrize" class="prizebox btn_red_new" style="margin: 6px auto;" onclick="showPaymentPrize()">Retirar Premios</button>
								</div>
							</div>
						<c:set value="5" var="pageSize" />
						<div class=" wrap-accordion">
							<div class="custom-accordion">
							<div id="results">
								<ul>
									<c:choose>
										<c:when test="${empty param.from}">
											<c:set var="rowBEGIN" value="1" />
										</c:when>
										<c:otherwise>
											<c:set var="rowBEGIN" value="${param.from}" />
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${empty param.to}">
											<c:set var="rowEnd" value="${pageSize}" />
										</c:when>
										<c:otherwise>
											<c:set var="rowEnd" value="${param.to}" />
										</c:otherwise>
									</c:choose>
									<c:forEach begin="${rowBEGIN-1}" step="1" end="${rowEnd-1}"
										var="item" varStatus="status" items="${pendingPrizeList}">
	
										<li class="single">
											<i></i>
											<button onclick="datalayerMisPremiosVerContenido('${item.GNAME}')" type="button" data-modal="#popup" data-ticket="${item.GTICKET}" data-play="${item.GAMEID}" class="btn btn-trans">
												${item.GNAME} <span class="desc-single">${item.GMATRIX1}</span>
											</button>
										</li>
										
									</c:forEach>
									<c:set value="${fn:length(pendingPrizeList)}" var="rLen" />
	
									<c:choose>
										<c:when test="${rLen lt rowEnd}">
											<c:set var="rCurrEnd" value="${rLen}" />
										</c:when>
										<c:otherwise>
											<c:set var="rCurrEnd" value="${rowEnd}" />
										</c:otherwise>
									</c:choose>
								</ul>
							</div>
							<c:if test="${rowEnd lt rLen}">
								<button type="button" id="viewmore" data-from="${rowBEGIN+pageSize}" data-to="${rowEnd+pageSize}" class="btn btn-white">VER MÁS</button>
							</c:if>
						</div>
						</div>
					</div>
					</div>
					<div id="popup" class="overlay">
						<div class="popup popup-sm" style="height: 95%"> 
							<a class="close js-close-modal" href="#">&times;</a>
							<div class="main-modal" style="height: 100%"></div>
						</div>
					</div>
					<div style="padding: 25px;">
	    		    <table class="auto-payment-table">
					    <tbody>
					        <tr>
					            <td>
					                <span class="title">
					                    Premios de Loterías Express
					                </span>
					            </td>
					            <td class="right">
					                <label class="switch">
					                    <input type="checkbox" id="myToggleSwitch">
					                    <span class="slider round"></span>
					                </label>
					            </td>
					        </tr>
					        <tr><td colspan="2" class="spacer"></td></tr>
					        <tr>
					            <td colspan="2">
					                <span class="subtitle">
					                    <p class="justify-text">Activa el pago automático de tus premios de las jugadas compradas como invitado:</p>
					                </span>
					            </td>
					        </tr>
					        <tr>
					            <td colspan="2">
					                <span class="description">
					                    <p class="justify-text">Desde ahora, todos los premios pendientes y los que ganes se abonarán automáticamente a tu saldo disponible para retiro.<br>
					                    Recuerda que los premios mayores a S/10,000 estarán disponibles en la sección 'Retirar premios' para que puedas transferirlos a tu cuenta bancaria.</p>
					                </span>
					            </td>
					        </tr>
					    </tbody>
					</table>
    		  	</div>
    		  	<div id="popup-message-recharge" class="overlay">							
				<div class="popup popup-sm login-error">	
				<a class="close-popup " id="close-popup-session" onclick="closePopup(this)">&times;</a>							
					<div class="main-modal" id="msg-session"></div>
					
				</div>
			</div>
			</div>
		</div>
	</div>
</div>
	<jsp:include page="../include/footer.jsp" />
	<script type="text/javascript" src="layer-view-script/client/validateDataClient.js?v=8" > </script>
	<script type="text/javascript" src="layer-view-script/client/interface-prize.js?v=4" > </script>

<script type="text/javascript">
var parametroPP="";
$(document).ready(function(){
	var redirige = getUrlParameter('redirige'); 
  	if(redirige=="premios"){
  	  parametroPP="";
	  $("#showPaymentPrize").trigger("click");
  	}else if(redirige=="historial"){
  	  parametroPP="historial"
	  $("#showPaymentPrize").trigger("click");  
  	}else{
  		parametroPP="";
  	}
});

function getUrlParameter(sParam) {
    var sPageURL = window.location.search.substring(1),
        sURLVariables = sPageURL.split('&'),
        sParameterName,
        i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
}
</script>
	

</body>
</html>