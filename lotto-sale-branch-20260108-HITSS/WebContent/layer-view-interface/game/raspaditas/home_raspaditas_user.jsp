<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:choose>
    <c:when test="${isAllowed == false}"><c:redirect url="/inicio.html"/></c:when><c:otherwise></c:otherwise>
</c:choose>
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
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/raspaditas/nice-select.css?v=2">
<!-- link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" / -->

<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>


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
							<c:if test="${nolive eq 1}">
								<div class="box-main-game-alert-iivv">
									<p class="message-game-alert">Debes iniciar sesión para jugar</p>
								</div>
							</c:if>
							<c:if test="${nogame eq 1}">
								<div class="box-main-game-alert-iivv">
									<p class="message-game-alert">El juego no está disponible</p>
								</div>
							</c:if>
							<div>
							<table>
								<tbody>
									<tr>
								    	<td>
											<div class="title-raspaditas">ELIGE UN JUEGO Y EMPIEZA A GANAR! &nbsp;&nbsp;&nbsp;&nbsp;Ordenar por:</div>								
								        </td>
								    	<td>
								        	<div class="raspaFiltro">
									        	<div class="box">
									   				  <select id="filtro" style="display: none;">
												        <option value="todos">Ver todos</option>
												        <option value="porPrecio">Menor precio</option>
												        <option value="porPremio">Mayor premio</option>
												      </select>												
												</div>
											</div>
								        </td>    
								    </tr>
								    </tbody>
								</table>
							</div>
						    <br>
							<div id="todos" style="display:block;">
								<jsp:include page="include_todos.jsp" />
							</div>
							<div id="porPrecio" style="display:none;">
								<jsp:include page="include_por_precio.jsp" />
							</div>	
							<div id="porPremio" style="display:none;">
								<jsp:include page="include_por_premio.jsp" />
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
    
    <script type="text/javascript" src="layer-view-script/common/jquery.nice-select.min.js"></script>
	<script type="text/javascript" src="layer-view-script/common/fastclick.js"></script>
	
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
	
	<%@ include file="../../include/footer.jspf" %> 

</body>
</html>