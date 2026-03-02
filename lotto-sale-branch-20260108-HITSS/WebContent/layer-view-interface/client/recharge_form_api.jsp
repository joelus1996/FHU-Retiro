<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.util.Constants"%>
<html lang="es">
<head>    
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

	<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
	<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js?v=1"></script>
	<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
	<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=10"></script>
	<script type="text/javascript">
		$(document).ready(function() {		
			$("#clientSale-amount").text("S/ 0.00");
        	$("#billetera2-amount").text("S/ 0.00");
        	$("#billetera3-amount").text("0");
			renderPopup();
			loadRechargeAPI();
			$("#clientSale-amount").text(floatFormat($("#clientSale-amount").text()));
		});
	</script>
	
	<meta charset="utf-8">
    <meta name="viewport" content="width=1024">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/main.css?v=<%=Constants.main_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/popModal.css?v=<%=Constants.popModal_css%>">
    <style type="text/css">		
		body{
			background: fixed;
		}
		
		.overlay.opened {
		    visibility: visible;
		    opacity: 1;
		    z-index: 9999;
		}
		
		.overlay {
		    position: fixed;
		    top: 0;
		    bottom: 0;
		    left: 0;
		    right: 0;
		    background: rgba(0, 0, 0, 0.7);
		    -webkit-transition: opacity 500ms;
		    -moz-transition: opacity 500ms;
		    -o-transition: opacity 500ms;
		    transition: opacity 500ms;
		    visibility: hidden;
		    opacity: 0;
		    z-index: -1;
		}
		
		.button.button-orange-light.no-margin.green {
		    background-color: #07663a;
		    color: #fafafa;
		    font-family: AllerBold, Arial, sans-serif;
		    box-shadow: none;
		    border-radius: 30px;
		    text-transform: none;
		    display: inline-block;
		    height: 36px;
		    line-height: 36px;
		    padding: 0 18px;
		    font-size: 13px;
		    border: medium none;
		    text-decoration: none;
		    font-weight: normal;
		    transition: 0.5s;
		    position: relative;
		}
		
		.close-popup, .close-popup:hover {
		    position: absolute;
		    top: -0.7em;
		    right: 1px;
		    -webkit-transition: all 200ms;
		    -moz-transition: all 200ms;
		    -o-transition: all 200ms;
		    font-size: 3.25em;
		    color: #dddddd;
		    width: 0.5em;
		    line-height: 0.8em;
		    margin-left: -0.5em;
		    text-decoration: none;
		    font-family: ui-monospace;
		    cursor: pointer;
		}
    </style>
    <title>Recarga - La Tinka de Perú</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body class="noscroll">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-5WTQR7D"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->  
	
	<input type="hidden" id="rechargetoken" value="${rechargetoken}" />
	<input type="hidden" id="operatorIdApi" value="${operatorIdApi}" />
	<input type="hidden" id="maximoCodigosBCP" value="${maximoCodigosBCP}" />
    <input type="hidden" id="maximoCodigosBBVA" value="${maximoCodigosBBVA}" />
	<input type="hidden" id="vn-merchantlogo" value="<c:out value='${visanet_merchantlogo}'/>">
	<input type="hidden" id="vn-sk" />
	<input type="hidden" id="remote-addr" value="<%= request.getRemoteAddr() %>"/>
	
	<input type="hidden" id="cid" value="${cid}" >
	<input type="hidden" id="full-name" value="${fullName}" >
	<input type="hidden" id="last-name" value="${lastName}" >
	<input type="hidden" id="email" value="${email}" >
	<input type="hidden" id="hrefForAnalytics" value="<%=Constants.HREF_FOR_ANALYTICS%>">
	
	<input type="hidden" id="docTypeIzi" value="${docTypeIzi}" >
	<input type="hidden" id="docNumber" value="${docNumber}" >	
	<input type="hidden" id="mobilePhone" value="" >
	<div class="ilot">
		<div class="recharge">
	    <div class="pop-recharge" style="overflow: unset;">
	        <div class="pop-recharge__background"></div>
	        <div class="content">
	          <div class="pop-recharge__content">
	            <div class="recharge">
	              <div class="recharge__content">
	                <div class="recharge__header">
	                  <h2 class="recharge__header-title">Cargar saldo</h2>
	                  <ul class="recharge__header-info">
	                    <li><strong>Saldo Actual</strong> <span id="clientSale-amount">${sessionScope.User.pMonto}</span></li>
	                    <li><strong>Bono Te Apuesto</strong><span id="billetera2-amount">${sessionScope.User.pBilletera2}</span></li>
	                    <li><strong>Jugadas gratis</strong><span id="billetera3-amount">${sessionScope.User.pBilletera3Cant}</span></li>
	                  </ul>
	                </div>
	                <div class="recharge__body">
	                  <p class="recharge__body-text"><strong>Elige un método de pago</strong></p>
	                  <div class="tabs">
	                    <ul class="tabs__list">
	                      <li class="tabs__list-item selected" id="tabInternet" data-target="#internet" data-category="Recarga por internet-Decide" data-label="Cargar Saldo - tab por internet">POR INTERNET</li>
	                      <li class="tabs__list-item" id="tabEfectivo" data-target="#efectivo" data-category="Recarga fisica-Decide" data-label="Cargar saldo - tab en efectivo" onclick="tagginTabCargarSaldo('efectivoInterbank','flagEfectivo');">EN EFECTIVO</li>
	                    </ul>
	                    <div class="back" style="display: none;" onclick="datalayerVolverMetodoPago();"><a href="#">Volver a los métodos de recarga</a></div>
	                    <div class="tabs__container" id="tabs__container" style="margin-top: 30px;">
	                      <!-- tab internet-->
	                      <div class="tabs__container-item" id="internet" style="min-height: 400px !important;">
	                        <div class="tabs" data-category="Recarga por Internet-Decide">
	                          <div id="botonesInternet" class="buttoms__recharge">

							    <div id="tabInternetBCP" class="buttom__recharge" data-target="#bcp-internet" data-label="Cargar Saldo - tab BCP" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-bcp" src="layer-view-image/client/logo-bcp.png" style="height: auto; position: absolute; left: 40px; bottom: -12px; width: 60px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="minAmountBCPP"></span> a S/ <span id="maxAmountBCPP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table> 
	                          	</div>
								
								<div id="tabInternetInterbank" class="buttom__recharge" data-target="#interbank-internet" data-label="Cargar Saldo - tab interbank" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-interbank" src="layer-view-image/client/logo-interbank.png" style="height: auto; position: absolute; left: 30px; bottom: -9px; width: 80px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeIbkP"></span> a S/ <span id="amtMaxRechargeIbkP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table> 
	                          	</div>
                               
	                          	
                                  <div id="tabInternetBBVA" class="buttom__recharge" data-target="#bbva-internet" data-label="Cargar Saldo - tab BBVA" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-bcp" src="layer-view-image/client/logo-bbva.png" style="height: auto; position: absolute; left: 40px; bottom: -12px; width: 60px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="minAmountBBVAA"></span> a S/ <span id="maxAmountBBVAA"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table> 
	                          	</div>
									                          									
	                          	<div id="tabInternetYapeTupay" class="buttom__recharge" data-target="#yape-tupay-internet" data-label="Cargar Saldo - tab yape" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-yape" src="layer-view-image/client/yape2.png?v=1" style="height: auto; position: absolute;left: 20px; bottom: -26px; width: 115px">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeYapeTupayP"></span> a S/ <span id="amtMaxRechargeYapeTupayP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>  
	                          	</div>
	                          	                                                     	                          	
	                          	<div id="tabInternetPlinTupay" class="buttom__recharge" data-target="#plin-tupay-internet" data-label="Cargar Saldo - tab plin" onclick="datalayerMetodoPago(this.id);">	                          		
	                          		<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-yape" src="layer-view-image/client/plin2.png?v=1" style="height: auto; position: absolute; left: 20px; bottom: -26px; width: 115px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargePlinTupayP"></span> a S/ <span id="amtMaxRechargePlinTupayP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>                		
	                          	</div>
								
								<div id="tabInternetYape" class="buttom__recharge" data-target="#yape-internet" data-label="Cargar Saldo - tab yape" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-yape" src="layer-view-image/client/logo-yapev2.png?v=1" style="height: auto; position: absolute;left: 10px; bottom: -27px; width: 115px">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeYapeP"></span> a S/ <span id="amtMaxRechargeYapeP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>  
	                          	</div>
	                          	
	                          	<div id="tabInternetPlin" class="buttom__recharge" data-target="#plin-internet" data-label="Cargar Saldo - tab plin" onclick="datalayerMetodoPago(this.id);">	                          		
	                          		<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-yape" src="layer-view-image/client/logo-plinv2.png?v=1" style="height: auto; position: absolute; left: 10px; bottom: -27px; width: 115px">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargePlinP"></span> a S/ <span id="amtMaxRechargePlinP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>                		
	                          	</div>

								<div id="tabInternetPagoEfectivo" class="buttom__recharge" data-target="#pagoefectivo-internet" data-label="Cargar Saldo - tab pagoefectivo" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo-v4.png" style="height: auto; position: absolute; left: 19px; bottom: -20px; width: 100px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargePefeP"></span> a S/ <span id="amtMaxRechargePefeP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table> 
	                          	</div>
	                          	
								 <div id="tabInternetAgora" class="buttom__recharge" data-target="#agora-internet" data-label="Cargar Saldo - tab agora" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-agora" src="layer-view-image/client/logo-agora2.png?v=1" style="height: auto; position: absolute; left: 34px; bottom: -20px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeAgrP"></span> a S/ <span id="amtMaxRechargeAgrP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>  
	                          	</div>
	                          
	                          <div id="tabInternetIzi" class="buttom__recharge" data-target="#izipay-internet" data-label="Cargar Saldo - tab izipay" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-visanet" src="layer-view-image/client/logo-visa-mc.png" style="height: auto; position: absolute; left: 21px; bottom: -20px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeIziP"></span> a S/ <span id="amtMaxRechargeIziP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>  
	                          	</div>
	                          
	                          	<div id="tabInternetVisanet" class="buttom__recharge" data-target="#visanet-internet" data-label="Cargar Saldo - tab visanet" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-visanet" src="layer-view-image/client/logo-visa-mc.png" style="height: auto; position: absolute; left: 21px; bottom: -10px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeVisaP"></span> a S/ <span id="amtMaxRechargeVisaP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>  
	                          	</div>
                                	                          	                          	
	                          	<div id="tabInternetSafetyPay" class="buttom__recharge" data-target="#safetypay-internet" data-label="Cargar Saldo - tab safetypay" onclick="datalayerMetodoPago(this.id);">
									<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png" style="height: auto; position: absolute; left: 35px; bottom: -8px; width: 75px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeSpayP"></span> a S/ <span id="amtMaxRechargeSpayP"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>
	                          	</div>

                               
	                          	
	                          </div>
	                          
<!-- 	                          <ul class="tabs__list"> -->
<!-- 	                            <li class="tabs__list-subitem tab-type-1 selected" id="tabInternetVisanet" style="display: none;" data-target="#visanet-internet" data-label="Cargar Saldo - tab visanet" onclick="tagginTabCargarSaldo('internetVisanet');"><img class="img-visanet" src="layer-view-image/client/logo-visa-mc.png" ></li> -->
<!-- 	                            <li class="tabs__list-subitem tab-type-2" id="tabInternetAgora" style="display: none;" data-target="#agora-internet" data-label="Cargar Saldo - tab agora" onclick="tagginTabCargarSaldo('internetAgora');"><img class="img-agora" src="layer-view-image/client/logo-agora.png"></li> -->
<!-- 	                            <li class="tabs__list-subitem tab-type-2" id="tabInternetInterbank" style="display: none;" data-target="#interbank-internet" data-label="Cargar Saldo - tab interbank" onclick="tagginTabCargarSaldo('internetInterbank');"><img class="img-interbank" src="layer-view-image/client/logo-interbank-v2.png"></li> -->
<!-- 	                            <li class="tabs__list-subitem tab-type-2" id="tabInternetBCP" style="display: none;" data-target="#bcp-internet" data-label="Cargar Saldo - tab BCP" onclick="tagginTabCargarSaldo('internetBCP');"><img class="img-bcp" src="layer-view-image/client/logo-bcp.png"></li> -->
<!-- 	                            <li class="tabs__list-subitem tab-type-2" id="tabInternetPagoEfectivo" style="display: none;" data-target="#pagoefectivo-internet" data-label="Cargar Saldo - tab pagoefectivo" onclick="tagginTabCargarSaldo('internetPagoEfectivo');"><img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo-v2.png"></li> -->
<!-- 	                            <li class="tabs__list-subitem tab-type-2" id="tabInternetSafetyPay" style="display: none;" data-target="#safetypay-internet" data-label="Cargar Saldo - tab safetypay" onclick="tagginTabCargarSaldo('internetSafetyPay');"><img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png"></li> -->
<!-- 	                          </ul> -->
	                          
	                          <div class="tabs__container">
	                          	
	                          	<!-- tab izipay-->
	                            <div class="tabs__container-item" id="izipay-internet">
	                              <div class="subcontent">
	                              	<img class="img-visanet" src="layer-view-image/client/logo-visa-mc.png" style="margin-top: 10px;">
	                                <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito VISA y/o MasterCard:</strong></p>
	                                <p class="subcontent-text">Recarga entre S/ <span id="amtMinRechargeIzi"></span> y S/ <span id="amtMaxRechargeIzi"></span></p>
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora.</li>
	                                  <li>Luego haz clic en "Cargar" para ingresar tu tarjeta.
	                                  	<form class="form" id="form_recharge_izi" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_izi" value="IZIPAY" />
										  <input type="hidden" name="status_code" id="status_code_izi" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_izi" value="-1" />
	                                      <input type="hidden" name="option-card" id="option-card_izi" value="2" />
	                                      
	                                      <div id="modal-izi" style="display:none; position:fixed; top:0; left:0;">

        								  </div>
	                                       
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_izi">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_izi" tabindex="117" maxlength="5" data-validation="number" data-validation-allowing="range[10;1000]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_izi">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_izi" tabindex="118" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab IZIPAY - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      	                                      
	                                      <div class="form__button">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab IZIPAY - generar codigo" onclick="tagginSaldoEEaddToCart()">Cargar</button>
	                                      </div>
	                                    </form>
	                                  </li>
	                                </ol>
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
	                              </div>
	                            </div>	                          	
	                          	
	                          	<!-- tab visanet-->
	                            <div class="tabs__container-item" id="visanet-internet">
	                              <div class="subcontent">
	                              	<img class="img-visanet" src="layer-view-image/client/logo-visa-mc.png" style="margin-top: 10px;">
	                                <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito VISA y/o MasterCard:</strong></p>
<!-- 	                                <p class="subcontent-text">Recarga entre S/ <span id="amtMinRechargeVisa"></span> y S/ <span id="amtMaxRechargeVisa"></span> hasta en <span id="maxRechargeVisa"></span> transacciones diarias. Recarga máxima semanal S/ <span id="amtMaxRechargeWeekVisa"></span>.</p>	                                 -->
	                                <p class="subcontent-text">Recarga entre S/ <span id="amtMinRechargeVisa"></span> y S/ <span id="amtMaxRechargeVisa"></span><span id="maxRechargeVisa"></span><span id="amtMaxRechargeWeekVisa"></span></p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora.</li>
	                                  <li>Luego haz clic en "Cargar" para ingresar tu tarjeta VISA y/o Mastercard.
	                                  	<form class="form" id="form_recharge_visa" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_visanet" value="VISANET" />
										  <input type="hidden" name="status_code" id="status_code_visanet" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_visanet" value="-1" />
	                                      <input type="hidden" name="option-card" id="option-card_visanet" value="2" />
	                                      
	                                      <div id="modal-visa" style="display:none; position:fixed; top:0; left:0;">
<!--         								  	<iframe id="frameButtonVisa" frameborder="0" style="width:100%; height:100%"></iframe> -->
        								  </div>
	                                       
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_visanet">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_visanet" tabindex="117" maxlength="4" data-validation="number" data-validation-allowing="range[10;1000]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_visanet">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_visanet" tabindex="118" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab VISANET - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      
	                                      <div class="subcontent-comision hide">
	                                      	<p class="subcontent-text-comision" id="comision_visanet"><span class="monto-comision-visanet" id="monto_comision_visanet"></span></p>
	                                      </div>
	                                      
	                                      <div class="form__button">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab VISANET - generar codigo" onclick="tagginSaldoEEaddToCart()">Cargar</button>
	                                      </div>
	                                    </form>
	                                  </li>
	                                </ol>
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
	                              </div>
	                            </div>
	                            
	                            <!-- tab agora-->
	                            <div class="tabs__container-item" id="agora-internet">
	                              <div class="subcontent">
<!-- 	                                <p class="subcontent-text"><strong>Con tu tarjeta Agora:</strong></p> -->
									<img class="img-agora" src="layer-view-image/client/logo-agora2.png?v=1" style="margin-top: 14px;">
	                                <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeAgr"></span> hasta S/<span id="amtMaxRechargeAgr"></span>.</p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li style="margin-bottom: 0px;">Ingresa el monto a recargar. Si tienes un código promocional, escríbelo ahora, y presiona "APLICAR" para hacerlo efectivo.
	                                  	<form class="form" style="padding-bottom: 0px;" id="form_recharge_agora" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_agora" value="AGORA" />
										  <input type="hidden" name="status_code" id="status_code_agora" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_agora" value="-1" />
	                                      <input type="hidden" name="option-card" id="option-card_agora" value="2" />
	                                      
	                                      <div id="modal-agora" style="display:none; position:fixed; top:0; left:0;">

        								  </div>
	                                       
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_agora">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_agora" tabindex="115" maxlength="4" data-validation="number" data-validation-allowing="range[10;1000]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_agora">Código promocional</label>
	                                        <input class="codigo_promocional"type="text" name="codigo" id="codigo_agora" tabindex="116" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab AGORA - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="subcontent-comision hide">
                                    	  	<p class="subcontent-text-comision" id="comision_agora"><span class="monto-comision-agora" id="monto_comision_agora"></span></p>
                                    	  </div>
	                                      <div class="form__button" style="width: 100%;">
	                                      	<div id="seccion_agora_confirmada" style="display: none;">
	    	                               		<p class="subcontent-text" style="">Te llegará una notificación para validar tu recarga al app Agora asociado al número <span id="num_agora_confirmado"></span>.</p>
	                                        	<button class="button button__base button--small" id="btnRecargaAgora" style="margin-bottom: 18px; width: 50%;" type="submit" disabled data-label="Cargar Saldo - tab AGORA - generar codigo" onclick="tagginSaldoAgoraEEaddToCart()">Recargar</button>
	                                        </div>	
	                                      </div>
	                                    </form>
	                                  </li>
	                                  <li id="seccion_agora_xconfirmar" style="display: none;">Para efectuar esta recarga, deberás confirmarla desde tu app Agora, para lo cual te notificaremos al número <span id="num_agora"></span>. Si es correcto, recarga. Si no, <a onclick="actualizarCelular()" style="text-decoration: underline; color: #e30613; cursor: pointer;" >actualízalo aquí</a>
		                              		<form class="form" style="padding: 0px;" id="form_recharge_agora_2" autocomplete="off">
			                              		<div class="form__input form__input--small" id="divCelularAgora" style="margin-top: 18px; display: none;">
				                                     <label for="cel_agora">Celular</label>
				                                     <input type="tel" name="celular" id="cel_agora" tabindex="117" maxlength="9" data-validation="length number" data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="&amp;nbsp;">
				                                </div><br>
			                              		
			                              		<p class="subcontent-text" id="pInfoAgoraOk" style="font-size: 10px; text-align: left; margin-left: 0px;">Mi información es correcta, solicitar recarga</p>
			                              
					                            <div class="form__button">
					                                <button class="button button__base_2 button--small" id="btnRecargaAgora2" onclick="recargaAgora2()" type="submit" disabled data-label="Cargar Saldo - tab AGORA - generar codigo">Recargar</button>
					                            </div> 
					                        </form>   
		                              </li>   
	                                </ol>
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
	                              </div>
	                            </div>
	                          
	                            <!-- tab interbank-->
	                            <div class="tabs__container-item" id="interbank-internet">
	                              <div class="subcontent">
	                              	<img class="img-interbank" src="layer-view-image/client/logo-interbank.png" style="margin-top: 15px; height: auto; width: 85px; margin-bottom: 3px;">
	                                <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito Interbank:</strong></p>
	                                <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeIbk"></span> hasta S/<span id="amtMaxRechargeIbk"></span>.</p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Desde Interbank.pe o tu App Interbank selecciona: <br><strong>Operaciones &gt; Pagos y Recargas &gt; Pago a Institución o Empresas &gt; La Tinka &gt; Recarga Web</strong></li>
	                                  <li>Ingresa tu DNI. En tipo de pago <strong>Parcial,</strong> ingresa el monto a depositar y confirma tu recarga.</li>
	                                  <li>Luego, si tienes un código promocional, ingrésalo aquí:</li>                         
	                                </ol>
									
									<div class="subcontent-list">
										<form  class="form" id="form_recharge_ibk_i" autocomplete="off">
		                                	<input type="hidden" name="medio_pago" id="medio_pago_ibk_i" value="IBK" />
											<input type="hidden" name="status_code" id="status_code_ibk_i" value="DES" />
											<input type="hidden" name="id_code" id="id_code_ibk_i" value="-1" />
											<input type="hidden" name="option-card" id="option-card_ibk_i" value="12" />
											
											<div class="form__input form__input--small">
		                                        <label for="codigo_ibk_i">Código promocional</label>
		                                        <input class="codigo_promocional_ibk"  type="text" name="codigo" id="codigo_ibk_i" tabindex="119" maxlength="20" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
		                                    </div>
		                                    <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
		                                        <button class="button button__outline button--small" type="button" data-label="Cargar Saldo - tab IBK - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
		                                    </div>
		                                    <div class="form__alert_recharge"></div>
	                                	</form>
									</div>

	                                <p class="subcontent-link" style="margin-top: 40px;"><a class="link link__arrow link_red_new" style="cursor: pointer;" href="https://interbank.pe/" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab interbank - ir interbank" target="_blank" onclick="datalayerIrEntidadBancaria(this);">Ir a Interbank</a></p>
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>". Si hay una promoción vigente que quieras canjear podrás hacerlo después de recargar.</div>
	                              </div>
	                              
	                            </div>
	                            <!-- tab bcp-->
	                            <div class="tabs__container-item" id="bcp-internet">
	                              <div class="subcontent">
	                              	<img class="img-bcp" src="layer-view-image/client/logo-bcp.png" style="margin-top: 12px; margin-bottom: 3px;">
	                                <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito BCP:</strong></p>
	                                <p class="subcontent-text">Recarga desde S/<span id="minAmountBCP"></span> hasta S/<span id="maxAmountBCP"></span>.</p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago BCP.
	                                    <form class="form" id="form_recharge_bcp" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_bcp" value="BCP" />
										  <input type="hidden" name="status_code" id="status_code_bcp" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_bcp" value="-1" />
	                                      <input type="hidden" name="option-card" id="option-card_bcp" value="2" />
	                                      
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_bcp">Monto S/</label>
	                                        <input class="monto_recarga"  type="text" name="monto" id="monto_bcp" tabindex="120" maxlength="5" data-validation="number" data-validation-allowing="range[0;0]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_bcp">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_bcp" tabindex="121" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab BCP - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab BCP - generar codigo" onclick="tagginSaldoBCPEEaddToCart()">Continuar</button>
	                                      </div>
	                                      <table class="subcontent-table" id="grillaBCP">

	                                      </table>
	                                    </form>
	                                    <%-- <template id="tpl-recharge-head"> --%>
	                                    <script type="text/x-template" id="tpl-recharge-head">
	                                      <tr>
	                                        <th>Monto</th>
	                                        <th style="line-height: 15px;">Código <br> BCP </th>
	                                        <th>Vigencia</th>
	                                        <th>Estado</th>
	                                        <th>&nbsp;</th>
	                                      </tr>
	                                    </script>
	                                    <%-- <template id="tpl-recharge-item"> --%>
	                                    <script type="text/x-template" id="tpl-recharge-item">
	                                      <tr class="row_grid">
	                                        <td>S/{{amount}}</td>
	                                        <td>{{code}}</td>
	                                        <td>{{date}}</td>
	                                        <td><a class="link link__base {{urlvalidate}}" style="cursor: pointer;" data-pin="{{pin}}" >Verificar</a></td>
	                                        <td><a class="link link__base {{urlcancel}}" style="cursor: pointer;" data-pin="{{pin}}">Anular</a></td>
	                                      </tr>
	                                    </script>
	                                  </li>
	                                  <li>Ingresa a tu cuenta BCP. Selecciona la opción <strong>Pago de servicios &gt; Compras &gt; La Tinka &gt; Recargas Web</strong>, e ingresa el código generado en el campo de "Código BCP".</li>
	                                </ol>
	                                <p class="subcontent-link"><a class="link link__arrow link_red_new" style="cursor: pointer;" href="https://www.viabcp.com/" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab BCP - ir a BCP" target="_blank" onclick="datalayerIrEntidadBancaria(this);">Ir a BCP</a></p>
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
	                              </div>
	                            </div>
                                <!-- tab bbva-->
	                            <div class="tabs__container-item" id="bbva-internet">
                                    <div class="subcontent">
                                    <img class="img-bcp" src="layer-view-image/client/logo-bbva.png" style="margin-top: 12px; margin-bottom: 3px;">
                                    <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito BBVA:</strong></p>
                                    <p class="subcontent-text">Recarga desde S/<span id="minAmountBBVA"></span> hasta S/<span id="maxAmountBBVA"></span>.</p>
                                    <ol class="subcontent-list">
                                        <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago BBVA.
                                        <form class="form" id="form_recharge_bbva" autocomplete="off">
                                            <input type="hidden" name="medio_pago" id="medio_pago_bbva" value="BBVA" />
                                            <input type="hidden" name="status_code" id="status_code_bbva" value="DES" />
                                            <input type="hidden" name="id_code" id="id_code_bbva" value="-1" />
                                            <input type="hidden" name="option-card" id="option-card_bbva" value="2" />

                                            <div class="form__input form__input--small">
                                                <label for="monto_bbva">Monto S/</label>
                                                <input class="monto_recarga" type="text" name="monto" id="monto_bbva" tabindex="120" maxlength="5" data-validation="number" data-validation-allowing="range[0;0]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
                                            </div><br>
                                            <div class="form__input form__input--small">
                                                <label for="codigo_bbva">Código promocional</label>
                                                <input class="codigo_promocional" type="text" name="codigo" id="codigo_bbva" tabindex="121" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
                                            </div>
                                            <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
                                                <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab BBVA - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
                                            </div>
                                            <div class="form__alert_recharge"></div>
                                            <div class="form__button">
                                                <button id="btnRecargaBBVA" class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab BBVA - generar codigo" onclick="tagginSaldoBBVAEEaddToCart()">Continuar</button>
                                            </div>
                                        <table class="subcontent-table" id="grillaBBVA">

                                        </table>
                                        </form>
                                        <%-- <template id="tpl-recharge-head"> --%>
                                        <script type="text/x-template" id="tpl-recharge-head-bbva">
                                        <tr>
                                            <th>Monto</th>
                                            <th style="line-height: 15px;">Código <br> BBVA </th>
                                            <th>Vigencia</th>
                                            <th>Estado</th>
                                            <th>&nbsp;</th>
                                        </tr>
                                        </script>
                                        <%-- <template id="tpl-recharge-item"> --%>
                                        <script type="text/x-template" id="tpl-recharge-item-bbva">
                                        <tr class="row_grid">
                                            <td>{{amount}}</td>
                                            <td>{{code}}</td>
                                            <td>{{date}}</td>
                                            <td><a class="link link__base {{urlvalidate}}" style="cursor: pointer;" data-pin="{{pin}}" >Verificar</a></td>
                                            <td><a class="link link__base {{urlcancel}}" style="cursor: pointer;" data-pin="{{pin}}">Anular</a></td>
                                        </tr>
                                        </script>
                                    </li>
                                    <li>Ingresa a tu cuenta BBVA. Selecciona la opción <strong>Pagar servicio &gt; Agregar servicio a pagar &gt; Recarga Web La Tinka</strong>, e ingresa el código generado en el campo de "Código BBVA".</li>
                                    </ol>
                                    <p class="subcontent-link"><a class="link link__arrow link_red_new" style="cursor: pointer;" href="https://www.bbva.pe" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab BBVA - ir a BBVA" target="_blank">Ir a BBVA</a></p>
                                    <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
                                </div>
                                    </div>
	                            <!-- tab pagoefectivo-->
	                            <div class="tabs__container-item" id="pagoefectivo-internet">
	                              <div class="subcontent">
	                               	<img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo-v4.png" style="margin-top: 15px; height: auto; width: 100px; margin-bottom: 5px;">
	                                <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargePefe"></span> hasta S/<span id="amtMaxRechargePefe"></span>.</p>
	                                <p class="subcontent-text"><strong>Desde la Banca móvil.</strong></p>
<!--	                                <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank"><img class="subcontent-logo subcontent-logo--fix" src="layer-view-image/client/img-pagoefectivo.png" alt="PagoEfectivo"></p> -->
									<p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-logosbancos-pefe-desktop.png" alt="Banca_por_internet" style="height: auto; margin: 0px;"></p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago PagoEfectivo.
	                                    <form class="form" id="form_recharge_pagoefectivo" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_pefe_i" value="PEFE" />
										  <input type="hidden" name="status_code" id="status_code_pefe_i" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_pefe_i" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_pefe_i" value="4" />
										  <input type="hidden" name="type_token" id="type_token_pefe_i" value="1" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_pagoefectivo">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_pagoefectivo" tabindex="130" maxlength="4" data-validation="number" data-validation-allowing="range[40;3000]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_pagoefectivo">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_pagoefectivo" tabindex="131" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab pagoefectivo - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab pagoefectivo - generar codigo" onclick="tagginSaldoPEfectivoEEaddToCart()">Continuar</button>
	                                      </div>
	                                      <label class="list-label"> Mantén habilitada la ventana emergente en tu navegador.</label>
	                                    </form>
	                                  </li>
	                                  <li>Copia el código e ingresa a la página web o App de tu banco. En <strong>Pagos de Servicios</strong> busca la empresa <strong>PagoEfectivo &gt; PagoEfectivo Soles</strong>. Ingresa el código generado y sigue los pasos.</li>
	                                </ol>
	                                <p class="subcontent-link" style="margin-bottom: 10px;"><a class="link link__play link_red_new" href="https://pagoefectivo.pe/como-pagar.html" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab pagoefectivo - como funciona" onclick="datalayerObtenerInfoUso(this);" target="_blank">¿Cómo funciona?</a></p><br>
<!-- 	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div> -->
                                    <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaPEFE">La carga de tu saldo puede demorar unos minutos. Para verificar que se realizó,
                                        <a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('PEFE','1');"> haz clic aquí</a>
	                                	<a style="cursor: pointer;" onclick="verificaRecargaPE('PEFE','1');">
		                                	<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													 viewBox="0 0 330 330" style="fill: #e30613; width: 12px; vertical-align: sub;" xml:space="preserve">
												<path id="XMLID_27_" d="M15,180h263.787l-49.394,49.394c-5.858,5.857-5.858,15.355,0,21.213C232.322,253.535,236.161,255,240,255
													s7.678-1.465,10.606-4.394l75-75c5.858-5.857,5.858-15.355,0-21.213l-75-75c-5.857-5.857-15.355-5.857-21.213,0
													c-5.858,5.857-5.858,15.355,0,21.213L278.787,150H15c-8.284,0-15,6.716-15,15S6.716,180,15,180z"/>
												<g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
											</svg>
										</a>
	                                </div>
	                              </div>
	                            </div>
	                            
	                            <!-- tab yape-->
	                            <div class="tabs__container-item" id="yape-internet">
	                              <div class="subcontent">
	                               	<img class="img-pagoefectivo" src="layer-view-image/client/yape.png" style="margin-top: 15px; height: auto; width: 75px;">
	                               	<img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo-v4.png?v=1" style="margin-top: 20px; height: auto; width: 105px; float: right;">	                                
	                                <p class="subcontent-text">Recarga en YAPE desde S/<span id="amtMinRechargeYape"></span> hasta S/<span id="amtMaxRechargeYape"></span>.</p>	                               
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto a recargar. Si tienes un código promocional, escríbelo y presiona "APLICAR" para hacerlo efectivo.<br>Luego genera tu código QR.
	                                    <form class="form" id="form_recharge_yape" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_yape_i" value="YAPE" />
										  <input type="hidden" name="status_code" id="status_code_yape_i" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_yape_i" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_yape_i" value="4" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_yape">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_yape" tabindex="130" maxlength="4" data-validation="number" data-validation-allowing="range[15;500]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_yape">Código promocional</label>
	                                        <input class="codigo_promocional"type="text" name="codigo" id="codigo_yape" tabindex="131" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab yape - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab yape - generar codigo" onclick="tagginSaldoYAPEEEaddToCart()">GENERAR QR</button>
	                                      </div>
	                                    </form>
	                                  </li>
	                                </ol>
	                                <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaYape">La carga de tu saldo puede demorar unos minutos.<br>Para verificar que se realizó,
	                                	<a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('YAPE','1');"> haz clic aquí</a>
	                                	<a style="cursor: pointer;" onclick="verificaRecargaPE('YAPE','1');">
		                                	<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													 viewBox="0 0 330 330" style="fill: #e30613; width: 12px; vertical-align: sub;" xml:space="preserve">
												<path id="XMLID_27_" d="M15,180h263.787l-49.394,49.394c-5.858,5.857-5.858,15.355,0,21.213C232.322,253.535,236.161,255,240,255
													s7.678-1.465,10.606-4.394l75-75c5.858-5.857,5.858-15.355,0-21.213l-75-75c-5.857-5.857-15.355-5.857-21.213,0
													c-5.858,5.857-5.858,15.355,0,21.213L278.787,150H15c-8.284,0-15,6.716-15,15S6.716,180,15,180z"/>
												<g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
											</svg>
										</a>
	                                </div>
	                              </div>
	                            </div>
	                            
	                             <!-- tab yape tupay-->
	                            <div class="tabs__container-item" id="yape-tupay-internet">
	                              <div class="subcontent">
	                               	<img class="img-pagoefectivo" src="layer-view-image/client/yape.png" style="margin-top: 15px; height: auto; width: 75px;">
	                               	<img class="img-pagoefectivo" src="layer-view-image/client/img_viatupay.png" style="margin-top: 20px; height: auto; width: 105px; float: right;">
	                                <p class="subcontent-text">Recarga en YAPE desde S/<span id="amtMinRechargeYapeTupay"></span> hasta S/<span id="amtMaxRechargeYapeTupay"></span>.</p>
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto a recargar. Si tienes un código promocional, escríbelo y presiona "APLICAR" para hacerlo efectivo.<br>Luego genera tu código QR.
	                                    <form class="form" id="form_recharge_yape_tupay" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_yape_tupay_i" value="YAPE_TP" />
										  <input type="hidden" name="status_code" id="status_code_yape_tupay_i" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_yape_tupay_i" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_yape_tupay_i" value="4" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_YapeTupay">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_YapeTupay" tabindex="200" maxlength="5" data-validation="number" data-validation-allowing="range[15;500]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_yape_tupay">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_yape_tupay" tabindex="201" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab yape - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab yape - generar codigo" onclick="tagginSaldoYAPEEEaddToCart()">GENERAR QR</button>
	                                      </div>
	                                    </form>
	                                  </li>
	                                </ol>
	                                
	                                 <header id="frame_yapetupayl" class="hide" style="width: 110%; margin-left: -5%; height:270px;">
										<div class="embwrap">
											<div class="embcell">
												<div class="ifrwrap">
													<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="270px"></iframe>
												</div>
											</div>
										</div>
									 </header>
									 <button type="button" id="close_yapetupayl" class="btn btn-sm btn-black hide" style="width: 110%; margin-left: -5%; background-color: rgba(56, 58, 53, 0.9); border: 1px solid #383a35; color: #fff; font-family: AllerBold, Arial, sans-serif;">CERRAR</button>
	                                
	                                <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaYapeTupay">La carga de tu saldo puede demorar unos minutos.<br>Para verificar que se realizó,
	                                	<a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaTupay('YAPE');"> haz clic aquí</a>
	                                	<a style="cursor: pointer;" onclick="verificaRecargaTupay('YAPE');">
		                                	<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													 viewBox="0 0 330 330" style="fill: #e30613; width: 12px; vertical-align: sub;" xml:space="preserve">
												<path id="XMLID_27_" d="M15,180h263.787l-49.394,49.394c-5.858,5.857-5.858,15.355,0,21.213C232.322,253.535,236.161,255,240,255
													s7.678-1.465,10.606-4.394l75-75c5.858-5.857,5.858-15.355,0-21.213l-75-75c-5.857-5.857-15.355-5.857-21.213,0
													c-5.858,5.857-5.858,15.355,0,21.213L278.787,150H15c-8.284,0-15,6.716-15,15S6.716,180,15,180z"/>
												<g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
											</svg>
										</a>
	                                </div>
	                              </div>                  
	                            </div>
	                          	<!-- tab plin-->
	                            <div class="tabs__container-item" id="plin-internet">
	                              <div class="subcontent">
	                               	<img class="img-pagoefectivo" src="layer-view-image/client/plin.png" style="margin-top: 15px; height: auto; width: 40px">
	                                <img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo-v4.png" style="margin-top: 20px; height: auto; width: 105px; float: right;">
	                                <p class="subcontent-text">Recarga en PLIN desde S/<span id="amtMinRechargePlin"></span> hasta S/<span id="amtMaxRechargePlin"></span>.</p>
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto a recargar. Si tienes un código promocional, escríbelo y presiona "APLICAR" para hacerlo efectivo.<br>Luego genera tu código QR.
	                                    <form class="form" id="form_recharge_plin" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_plin_i" value="PLIN" />
										  <input type="hidden" name="status_code" id="status_code_plin_i" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_plin_i" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_plin_i" value="4" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_plin">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_plin" tabindex="130" maxlength="4" data-validation="number" data-validation-allowing="range[15;500]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_plin">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_plin" tabindex="131" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab plin - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab plin - generar codigo" onclick="tagginSaldoPLINEEaddToCart()">GENERAR QR</button>
	                                      </div>
	                                    </form>
	                                  </li>
	                                </ol>
	                                <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaPlin">La carga de tu saldo puede demorar unos minutos.<br>Para verificar que se realizó, 
	                                	<a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('PLIN','1');"> haz clic aquí</a>
	                                	<a style="cursor: pointer;" onclick="verificaRecargaPE('PLIN','1');">
		                                	<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													 viewBox="0 0 330 330" style="fill: #e30613; width: 12px; vertical-align: sub;" xml:space="preserve">
												<path id="XMLID_27_" d="M15,180h263.787l-49.394,49.394c-5.858,5.857-5.858,15.355,0,21.213C232.322,253.535,236.161,255,240,255
													s7.678-1.465,10.606-4.394l75-75c5.858-5.857,5.858-15.355,0-21.213l-75-75c-5.857-5.857-15.355-5.857-21.213,0
													c-5.858,5.857-5.858,15.355,0,21.213L278.787,150H15c-8.284,0-15,6.716-15,15S6.716,180,15,180z"/>
												<g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
											</svg>
										</a>
	                                </div>
	                              </div>
	                            </div>
	                            <!-- tab plin tupay-->
	                            <div class="tabs__container-item" id="plin-tupay-internet">
	                              <div class="subcontent">
	                               	<img class="img-pagoefectivo" src="layer-view-image/client/plin.png" style="margin-top: 15px; height: auto; width: 40px;">
	                                <img class="img-pagoefectivo" src="layer-view-image/client/img_viatupay.png" style="margin-top: 20px; height: auto; width: 105px; float: right;">
	                                <p class="subcontent-text">Recarga en PLIN desde S/<span id="amtMinRechargePlinTupay"></span> hasta S/<span id="amtMaxRechargePlinTupay"></span>.</p>
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto a recargar. Si tienes un código promocional, escríbelo y presiona "APLICAR" para hacerlo efectivo.<br>Luego genera tu código QR.
	                                    <form class="form" id="form_recharge_plin_tupay" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_plin_tupay_i" value="PLIN_TP" />
										  <input type="hidden" name="status_code" id="status_code_plin_tupay_i" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_plin_tupay_i" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_plin_tupay_i" value="4" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_PlinTupay">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_PlinTupay" tabindex="130" maxlength="5" data-validation="number" data-validation-allowing="range[15;500]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_plin_tupay">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_plin_tupay" tabindex="131" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab plin - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab plin - generar codigo" onclick="tagginSaldoPLINEEaddToCart()">GENERAR QR</button>
	                                      </div>
	                                    </form>
	                                  </li>
	                                </ol>
	                                
	                                <header id="frame_plintupayl" class="hide" style="width: 110%; margin-left: -5%; height:270px;">
										<div class="embwrap">
											<div class="embcell">
												<div class="ifrwrap">
													<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="270px"></iframe>
												</div>
											</div>
										</div>
									 </header>
									 <button type="button" id="close_plintupayl" class="btn btn-sm btn-black hide" style="width: 110%; margin-left: -5%; background-color: rgba(56, 58, 53, 0.9); border: 1px solid #383a35; color: #fff; font-family: AllerBold, Arial, sans-serif;">CERRAR</button>
	                                
	                                
	                                <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaPlinTupay">La carga de tu saldo puede demorar unos minutos.<br>Para verificar que se realizó, 
	                                	<a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaTupay('PLIN');"> haz clic aquí</a>
	                                	<a style="cursor: pointer;" onclick="verificaRecargaTupay('PLIN');">
		                                	<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													 viewBox="0 0 330 330" style="fill: #e30613; width: 12px; vertical-align: sub;" xml:space="preserve">
												<path id="XMLID_27_" d="M15,180h263.787l-49.394,49.394c-5.858,5.857-5.858,15.355,0,21.213C232.322,253.535,236.161,255,240,255
													s7.678-1.465,10.606-4.394l75-75c5.858-5.857,5.858-15.355,0-21.213l-75-75c-5.857-5.857-15.355-5.857-21.213,0
													c-5.858,5.857-5.858,15.355,0,21.213L278.787,150H15c-8.284,0-15,6.716-15,15S6.716,180,15,180z"/>
												<g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
											</svg>
										</a>
	                                </div>
	                              </div>
	                            </div>
	                            <!-- tab safetypay-->
	                            <div class="tabs__container-item" id="safetypay-internet">
	                              <div class="subcontent">
	                              	<img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png" style="margin-top: 15px; margin-bottom: 5px; height: auto; width: 94px;">
	                                <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeSpay"></span> hasta S/<span id="amtMaxRechargeSpay"></span>.</p>
	                                <p class="subcontent-text"><strong>Desde la web de tu banco con tu tarjeta de crédito o débito.</strong></p>
	                                <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank">&nbsp;<img class="subcontent-logo" src="layer-view-image/client/img-safetypay.png" alt="SafetyPay"></p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago SafetyPay.
	                                    <form class="form" id="form_recharge_safetypay" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_spay_i" value="SPAY" />
										  <input type="hidden" name="status_code" id="status_code_spay_i" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_spay_i" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_spay_i" value="5" />
										  <input type="hidden" name="type_token" id="type_token_spay_i" value="1" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_safetypay">Monto S/</label>
	                                        <input class="monto_recarga"  type="text" name="monto" id="monto_safetypay" tabindex="140" maxlength="4" data-validation="number" data-validation-allowing="range[80;3000]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_safetypay">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_safetypay" tabindex="141" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab safetypay - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar Saldo - tab safetypay - generar codigo" onclick="tagginSaldoSPayEEaddToCart()">Continuar</button>
	                                      </div>
	                                      <label class="list-label"> Mantén habilitada la ventana emergente en tu navegador.</label>
	                                    </form>
	                                  </li>
	                                  <li>Copia el código e ingresa a la página web o App de tu banco. En <strong>Pagos de Servicios</strong> busca la empresa <strong>SafetyPay &gt; SafetyPay Soles</strong>. Ingresa el código generado y sigue los pasos.</li>
	                                </ol>
<!-- 	                                <p class="subcontent-link"><a class="link link__play" href="#" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab safetypay - como funciona" target="_blank">¿Cómo funciona?</a></p> -->
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
	                              </div>
	                            </div>
	                          </div>
	                        </div>
	                      </div>
	                      <!-- tab efectivo-->
	                      <div class="tabs__container-item" id="efectivo" style="min-height: 190px !important;">
	                        <div class="tabs" data-category="Recarga fisica-Decide">
	                          <div id="botonesEfectivo" class="buttoms__recharge">
	                          	<div id="tabEfectivoInterbank" class="buttom__recharge" data-target="#interbank-efectivo" data-label="Cargar saldo - tab interbank" onclick="datalayerMetodoPago(this.id);">
<!-- 	                          		<div> -->
<!-- 	                          			<img class="img-interbank" src="layer-view-image/client/logo-interbank.png" style="padding-top: 18px; height: auto; width: 80px;"> -->
<!-- 	                          			<span><img src="layer-view-image/client/arrow.png"></span> -->
<!-- 	                          			<p style="font-weight: 700 !important;" class="subcontent-text"> -->
<!-- 	                          				De S/ <span id="amtMinRechargeIbkPE"></span> a S/ <span id="amtMaxRechargeIbkPE"></span> -->
<!-- 	                          			</p> -->
<!-- 	                          		</div> -->
	                          		
	                          		<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-interbank" src="layer-view-image/client/logo-interbank.png" style="height: auto; position: absolute; left: 30px; bottom: -9px; width: 80px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeIbkPE"></span> a S/ <span id="amtMaxRechargeIbkPE"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>
	                          	</div>
	                          	<div id="tabEfectivoLotocard" class="buttom__recharge" data-target="#lotocard-efectivo" data-label="Cargar saldo - tab lotocard" onclick="datalayerMetodoPago(this.id);">
<!-- 	                          		<div> -->
<!-- 	                          			<p style="padding-top: 8px; margin-bottom: 5px;">Lotocard</p> -->
<!-- 	                          			<span><img src="layer-view-image/client/arrow.png" style="margin-top: -28px; float: right; position: relative; left: -5px;"></span> -->
<!-- 	                          			<p style="font-weight: 700 !important;" class="subcontent-text" style="margin-left: 21px;"> -->
<!-- 	                          				De S/ 10 a S/ 100 -->
<!-- 	                          			</p> -->
<!-- 	                          		</div> -->
	                          		
	                          		<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<p style="height: auto; position: absolute; left: 46px; bottom: -21px; width: 80px;">Lotocard</p>
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ 10 a S/ 100
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>
	                          	</div>
	                          	<div id="tabEfectivoPagoEfectivo" class="buttom__recharge" data-target="#pagoefectivo-efectivo" data-label="Cargar saldo - tab pagoefectivo" onclick="datalayerMetodoPago(this.id);">
<!-- 	                          		<div> -->
<!-- 	                          			<img class="img-pagoefectivo" src="layer-view-image/client/logo_pe_desktop.png" style="height: auto; width: 75px; padding-top: 13px;"> -->
<!-- 	                          			<span><img src="layer-view-image/client/arrow.png"></span> -->
<!-- 	                          			<p style="font-weight: 700 !important;" class="subcontent-text"> -->
<!-- 	                          				De S/ <span id="amtMinRechargePefePE"></span> a S/ <span id="amtMaxRechargePefePE"></span> -->
<!-- 	                          			</p> -->
<!-- 	                          		</div> -->
	                          		
	                          		<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo-v4.png" style="height: auto; position: absolute; left: 19px; bottom: -15px; width: 100px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargePefePE"></span> a S/ <span id="amtMaxRechargePefePE"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>
	                          	</div>
	                          	<div id="tabEfectivoSafetyPay" class="buttom__recharge" data-target="#safetypay-efectivo" data-label="Cargar saldo - tab safetypay" onclick="datalayerMetodoPago(this.id);">
<!-- 	                          		<div> -->
<!-- 	                          			<img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png" style="height: auto; width: 75px; padding-top: 15px;"> -->
<!-- 	                          			<span><img src="layer-view-image/client/arrow.png"></span> -->
<!-- 	                          			<p style="font-weight: 700 !important;" class="subcontent-text"> -->
<!-- 	                          				De S/ <span id="amtMinRechargeSpayPE"></span> a S/ <span id="amtMaxRechargeSpayPE"></span> -->
<!-- 	                          			</p> -->
<!-- 	                          		</div> -->
	                          		
	                          		<table>
	                          			<tr style="height: 47px;">
	                          				<td style="width: 300px;">
	                          					<a class="img-recharge">
	                          						<img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png" style="height: auto; position: absolute; left: 35px; bottom: -8px; width: 75px;">
	                          					</a>
											</td>
	                          			</tr>
	                          			<tr>
	                          				<td colspan="2" style="text-align: center;">
                          						<p style="font-weight: 700 !important; margin-top: 0px; margin-bottom: 0px;" class="subcontent-text">
                          							De S/ <span id="amtMinRechargeSpayPE"></span> a S/ <span id="amtMaxRechargeSpayPE"></span>
                          						</p>
	                          				</td>
	                          			</tr>
	                          		</table>
	                          	</div>
	                          </div>
	                        
<!-- 	                          <ul class="tabs__list"> -->
<!-- 	                            <li class="tabs__list-subitem selected" id="tabEfectivoInterbank" style="display: none;" data-target="#interbank-efectivo" data-label="Cargar saldo - tab interbank" onclick="tagginTabCargarSaldo('efectivoInterbank');"><img class="img-interbank" src="layer-view-image/client/logo-interbank.png"></li> -->
<!-- 	                            <li class="tabs__list-subitem" id="tabEfectivoLotocard" style="display: none;" data-target="#lotocard-efectivo" data-label="Cargar saldo - tab lotocard" onclick="tagginTabCargarSaldo('efectivoLotocard');"><strong>Lotocard</strong></li> -->
<!-- 	                            <li class="tabs__list-subitem" id="tabEfectivoPagoEfectivo" style="display: none;" data-target="#pagoefectivo-efectivo" data-label="Cargar saldo - tab pagoefectivo" onclick="tagginTabCargarSaldo('efectivoPagoEfectivo');"><img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo.png"></li> -->
<!-- 	                            <li class="tabs__list-subitem" id="tabEfectivoSafetyPay" style="display: none;" data-target="#safetypay-efectivo" data-label="Cargar saldo - tab safetypay" onclick="tagginTabCargarSaldo('efectivoSafetyPay');"><img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png"></li> -->
<!-- 	                            <li class="tabs__list-subitem" data-target="#reddigital-efectivo" data-label="Cargar saldo - tab red digital"><img class="img-safetypay" src="layer-view-image/client/logo-red-digital.png"></li> -->
<!-- 	                          </ul> -->
	                          <div class="tabs__container">
	                            <!-- tab interbank-->
	                            <div class="tabs__container-item" id="interbank-efectivo">
	                              <div class="subcontent">
	                              	<img class="img-interbank" src="layer-view-image/client/logo-interbank.png" style="margin-top: 15px; height: auto; width: 85px; margin-bottom: 3px;">
	                                <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeIbkE"></span> hasta S/<span id="amtMaxRechargeIbkE"></span> en el banco o en un agente autorizado de Interbank.</p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Solicita tu recarga La Tinka, indica el código 0731802, el número de tu DNI y el monto a recargar</li>
	                                  <li>Luego, si tienes un código promocional, ingrésalo aquí:</li>
	                                </ol>
	                                
	                                <div class="subcontent-list">
										<form class="form" id="form_recharge_ibk_e" autocomplete="off">
		                                	<input type="hidden" name="medio_pago" id="medio_pago_ibk_e" value="IBK" />
											<input type="hidden" name="status_code" id="status_code_ibk_e" value="DES" />
											<input type="hidden" name="id_code" id="id_code_ibk_e" value="-1" />
											<input type="hidden" name="option-card" id="option-card_ibk_e" value="11" />
											
											<div class="form__input form__input--small">
		                                        <label for="codigo_ibk_e">Código promocional</label>
		                                        <input class="codigo_promocional_ibk"  type="text" name="codigo" id="codigo_ibk_e" tabindex="121" maxlength="20" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
		                                    </div>
		                                    <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
		                                        <button class="button button__outline button--small" type="button" data-label="Cargar Saldo - tab IBK - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
		                                    </div>
		                                    <div class="form__alert_recharge"></div>
	                                	</form>
									</div>

	                                <div class="subcontent-footer" style="margin-top: 40px;">Verifica tu recarga en la sección "<strong>Movimientos</strong>". Si hay una promoción vigente que quieras canjear podrás hacerlo después de recargar.</div>
	                              </div>
	                            </div>
	                            <!-- tab lotocard-->
	                            <div class="tabs__container-item" id="lotocard-efectivo">
	                              <div class="subcontent" style="padding-top: 15px;">
	                                <p class="subcontent-text"><strong>Con Lotocard:</strong></p>
	                                <p class="subcontent-text">Recarga con tus Lotocard de S/10, S/20, S/50 ó S/100. <br>Encuéntralos en todos los puntos de venta La Tinka.</p>
	                                <div class="subcontent-lotocard">
<!-- 	                                  <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                  <ol class="subcontent-list">
	                                    <li>Digita el código PIN de 14 dígitos de tu Lotocard. <br>Si tienes un código promocional aplícalo ahora. <br>Luego, haz click en el botón "Cargar".
	                                      <form class="form" id="form_recharge_lotocard" autocomplete="off">
	                                      	<input type="hidden" name="medio_pago" id="medio_pago_lotocard" value="LOTOCARD" />
	                                      	<input type="hidden" name="status_code" id="status_code_lotocard" value="DES" />
	                                      	<input type="hidden" name="id_code" id="id_code_lotocard" value="-1" />
	                                      	<input type="hidden" name="option-card" id="option-card_lotocard" value="1" />
	                                        <div class="form__input form__input--small">
	                                          <label for="lotocard">Código Lotocard</label>
	                                          <input type="text" name="lotocard" id="lotocard" tabindex="150" maxlength="14" data-validation="length number" data-validation-length="14" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerCodigoLotocard(this);">
	                                        </div><br>
	                                        <div class="form__input form__input--small">
	                                          <label for="codigo_lotocard">Código promocional</label>
	                                          <input type="text" name="codigo" id="codigo_lotocard" tabindex="151" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                        </div>
	                                        <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                          <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar saldo - tab lotocard - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                        </div>
	                                        <div class="form__alert_recharge"></div>
	                                        <div class="form__button">
	                                          <button class="button button__base button--small" type="submit" disabled data-label="Cargar saldo - tab lotocard - cargar">Cargar</button>
	                                        </div>
	                                      </form>
	                                    </li>
	                                  </ol>
	                                </div>
	                                <div class="subcontent-confirm hide">
	                                  <p><img class="icon-confirm" src="layer-view-image/client/icon-valid.svg"><strong>Recarga exitosa</strong></p>
	                                  <table>
	                                    <tr>
	                                      <td>Monto cargado</td>
	                                      <td>S/<span id="montoCargado"></span></td>
	                                    </tr>
<!-- 	                                    <tr style="display: none;"> -->
<!-- 	                                      <td>Saldo disponible</td> -->
<!-- 	                                      <td>S/<span id="saldoDisponible"></span></td> -->
<!-- 	                                    </tr> -->
	                                  </table>
	                                  <p><img class="icon-reload" src="layer-view-image/client/icon-reload.svg?v=2"><a class="link link__base" href="#">Volver a recargar</a></p>
	                                </div>
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
	                              </div>
	                            </div>
	                            <!-- tab pagoefectivo-->
	                            <div class="tabs__container-item" id="pagoefectivo-efectivo">
	                              <div class="subcontent">
	                                <img class="img-pagoefectivo" src="layer-view-image/client/logo-pago-efectivo-v4.png" style="margin-top: 15px; height: auto; width: 100px; margin-bottom: 5px;">
	                                <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargePefeE"></span> hasta S/<span id="amtMaxRechargePefeE"></span>.</p>
	                                <p class="subcontent-text"><strong>En Agentes y Bodegas</strong></p>
<!--	                                <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank">&nbsp;<img class="subcontent-logo" src="layer-view-image/client/img-pagoefectivo.png" alt="PagoEfectivo"></p> -->
									<p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/desktop_efectivo.png" alt="Agentes_y_Bodegas" style="height: 67px"></p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago PagoEfectivo.
	                                    <form class="form" id="form_recharge_pagoefectivo" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_pefe_e" value="PEFE" />
										  <input type="hidden" name="status_code" id="status_code_pefe_e" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_pefe_e" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_pefe_e" value="9" />
										  <input type="hidden" name="type_token" id="type_token_pefe_e" value="2" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_pagoefectivo_efectivo">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_pagoefectivo_efectivo" tabindex="160" maxlength="4" data-validation="number" data-validation-allowing="range[40;3000]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_pagoefectivo_efectivo">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_pagoefectivo_efectivo" tabindex="161" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar saldo - tab pagoefectivo - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar saldo - tab pagoefectivo - cargar" onclick="tagginSaldoEEPEfectivoEEaddToCart()">Continuar</button>
	                                      </div>
	                                      <label class="list-label"> Mantén habilitada la ventana emergente en tu navegador.</label>
	                                    </form>
	                                  </li>
	                                  <li>Copia el código de la ventana emergente, acércate a cualquier agente o bodega autorizada y realiza el pago.</li>
	                                </ol>
	                                <p class="subcontent-link"><a class="link link__arrow link_red_new" href="https://ubicanos.pagoefectivo.pe/" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab pagoefectivo - ver lugares" onclick="datalayerLugaresPago();" target="_blank">Ver lugares</a></p>
	                                <p class="subcontent-link" style="padding-bottom: 20px;"><a class="link link__play link_red_new" href="https://pagoefectivo.pe/como-pagar.html" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab pagoefectivo - como funciona" onclick="datalayerObtenerInfoUso(this);" target="_blank">¿Cómo funciona?</a></p>
	                                <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaPEFEE">La carga de tu saldo puede demorar unos minutos. Para verificar que se realizó,
	                                	<a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('PEFE','2');"> haz clic aquí</a>
	                                	<a style="cursor: pointer;" onclick="verificaRecargaPE('PEFE','2');">
		                                	<svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
													 viewBox="0 0 330 330" style="fill: #e30613; width: 12px; vertical-align: sub;" xml:space="preserve">
												<path id="XMLID_27_" d="M15,180h263.787l-49.394,49.394c-5.858,5.857-5.858,15.355,0,21.213C232.322,253.535,236.161,255,240,255
													s7.678-1.465,10.606-4.394l75-75c5.858-5.857,5.858-15.355,0-21.213l-75-75c-5.857-5.857-15.355-5.857-21.213,0
													c-5.858,5.857-5.858,15.355,0,21.213L278.787,150H15c-8.284,0-15,6.716-15,15S6.716,180,15,180z"/>
												<g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g><g></g>
											</svg>
										</a>
	                                </div>
	                              </div>
	                            </div>
	                            <!-- tab safetypay-->
	                            <div class="tabs__container-item" id="safetypay-efectivo">
	                              <div class="subcontent">
	                                <img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png" style="margin-top: 15px; margin-bottom: 5px; height: auto; width: 94px;">
	                                <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeSpayE"></span> hasta S/<span id="amtMaxRechargeSpayE"></span>.</p>
	                                <p class="subcontent-text"><strong>En un banco o agente autorizado vía SafetyPay.</strong></p>
	                                <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank">&nbsp;<img class="subcontent-logo" src="layer-view-image/client/img-safetypay.png" alt="SafetyPay"></p>
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
	                                <ol class="subcontent-list">
	                                  <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago SafetyPay.
	                                    <form class="form" id="form_recharge_safetypay" autocomplete="off">
	                                      <input type="hidden" name="medio_pago" id="medio_pago_spay_e" value="SPAY" />
										  <input type="hidden" name="status_code" id="status_code_spay_e" value="DES" />
										  <input type="hidden" name="id_code" id="id_code_spay_e" value="-1" />
										  <input type="hidden" name="option-card" id="option-card_spay_e" value="3" />
										  <input type="hidden" name="type_token" id="type_token_spay_e" value="2" />
										  
	                                      <div class="form__input form__input--small">
	                                        <label for="monto_safetypay_efectivo">Monto S/</label>
	                                        <input class="monto_recarga" type="text" name="monto" id="monto_safetypay_efectivo" tabindex="170" maxlength="4" data-validation="number" data-validation-allowing="range[80;3000]" data-validation-error-msg="&amp;nbsp;" onfocusout="datalayerIngresarMonto(this);">
	                                      </div><br>
	                                      <div class="form__input form__input--small">
	                                        <label for="codigo_safetypay_efectivo">Código promocional</label>
	                                        <input class="codigo_promocional" type="text" name="codigo" id="codigo_safetypay_efectivo" tabindex="171" maxlength="20" disabled="true" oninput="this.value = this.value.toUpperCase();" onfocusout="datalayerCodigoPromo(this);">
	                                      </div>
	                                      <div class="form__gift"><img class="form__gift-icon" src="layer-view-image/client/icon-gift.svg" width="18" height="18">
	                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar saldo - tab safetypay - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Código correcto</span>
	                                      </div>
	                                      <div class="form__alert_recharge"></div>
	                                      <div class="form__button" style="margin-bottom: 10px;">
	                                        <button class="button button__base button--small" type="submit" disabled data-label="Cargar saldo - tab safetypay - generar codigo" onclick="tagginSaldoEESPayEEaddToCart()">Continuar</button>
	                                      </div>
	                                      <label class="list-label"> Mantén habilitada la ventana emergente en tu navegador.</label>
	                                    </form>
	                                  </li>
	                                  <li>Copia el código de la ventana emergente, acércate a cualquier banco o agente autorizado y realiza el pago.</li>
	                                </ol>
<!-- 	                                <p class="subcontent-link"><a class="link link__play" href="#" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab safetypay - como funciona" target="_blank">¿Cómo funciona?</a></p> -->
	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
	                              </div>
	                            </div>
	                            <!-- tab red digital-->
<!-- 	                            <div class="tabs__container-item" id="reddigital-efectivo"> -->
<!-- 	                              <div class="subcontent"> -->
<!-- 	                                <p class="subcontent-text"><strong>Con Red Digital:</strong></p> -->
<!-- 	                                <p class="subcontent-text">Deposita desde S/10 hasta S/150.</p><br> -->
<!-- 	                                <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
<!-- 	                                <ol class="subcontent-list"> -->
<!-- 	                                  <li>Solicita la recarga Te Apuesto o La Tinka. Indica tu DNI, número de celular y el monto a recargar ¡Listo!</li> -->
<!-- 	                                </ol> -->
<!-- 	                                <p class="subcontent-link"><a class="link link__arrow" href="https://mapa.intralot.com.pe/" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab red digital - encuentra red digital cercano" target="_blank">Encuentra tu agente Red Digital más cercano aquí</a></p> -->
<!-- 	                                <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>". Si hay una promoción vigente que quieras canjear podrás hacerlo después de recargar.</div> -->
<!-- 	                              </div> -->
<!-- 	                            </div> -->
	                          </div>
	                        </div>
	                      </div>
	                    </div>
	                  </div>
	                  <p class="recharge__body-legal"><a id="footer-term-deprecated" style="cursor: pointer;" onclick="datalayerTerminosSaldoVirtual();" class="link link__base link_red_new" href="<%=Constants.URL_QW%>/terminos-y-condiciones/" target="_blank">Términos del uso del saldo virtual</a></p>
	                </div>
	              </div>
	            </div>
	          </div>
	        </div>
	    </div>
	    </div>
    </div>
    
    <div id="popup-message-session" class="overlay">							
		<div class="popup popup-sm login-error" style="max-width: 290px;">	
		<a class="close-popup " id="close-popup-session" onclick="closePopupCA(this)">&times;</a>							
			<div class="main-modal" id="msg-session"></div>		
		</div>
	</div>
	
    <script type="text/javascript" src="layer-view-script/client/main.js?v=<%=Constants.client_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
    <script>
    $(document).ready(function(){
		var clientIdSesion= $('#cid').val();
		 if(clientIdSesion!=''){
			 validateSessionParent();
			document.addEventListener("click", validateSessionParent);
			document.addEventListener("keypress", validateSessionParent);
		 }
// 		 else{
// 			 parent.location.href = "inicio.html";
// 		 }
		
	});
    
    function openModal(popup,ctrl) {
    	$(popup).addClass('opened');
    	$('body').addClass('modal');
    	if($.trim(ctrl).length>0) control = $.trim(ctrl);
    }
    
    function closePopupCA(id) {
    	let popup;
    	if(typeof id == 'string')
    		popup = $("#"+id);
    	else
    		popup = id.parentNode.parentNode;
    	
    	$(popup).css('transition','none');
    	$(popup).css('-webkit-transition','none');
    	$(popup).removeClass('opened');
    	parent.parent.location.href = "tav2.html";
    }
    </script>
</body>
</html>