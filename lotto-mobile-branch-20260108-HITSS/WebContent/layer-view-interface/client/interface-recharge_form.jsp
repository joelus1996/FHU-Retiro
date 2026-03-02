<!DOCTYPE html>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<html lang="es">
<head>
    
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-5WTQR7D');</script>
<!-- End Google Tag Manager -->
	
	
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<meta name='description' content="La Tinka móvil, billetera" />
	<title>Recarga - La Tinka S.A.</title>
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/client/main-1.0.css?v=<%=Constantes.main_1_0_css%>" type="text/css"/>
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>

	
	<style type="text/css">		
		body{
			background: fixed !important;
		}
    </style>
</head>
<!-- <body class="noscroll"> -->
<body>
	
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-5WTQR7D"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	
	<input type="hidden" id="maximoCodigosBCP" value="${maximoCodigosBCP}" />
	<input type="hidden" id="remote-addr" value="<c:out value='<%= request.getRemoteAddr() %>'/>">
	<input type="hidden" id="vn-sk" />
	<input type="hidden" id="vn-merchantlogo" value="<c:out value='${visanet_merchantlogo}'/>">
	<input type="hidden" id="cid" value="<c:out value='${cid}'/>">
	<input type="hidden" id="client-name" value='${name}'>
	<input type="hidden" id="client-lastname" value='${lastname} ${maidenname}'>
	<input type="hidden" id="client-email" value='${mail}'>
	
<!-- 	<i id="cargando"></i> -->
	<div class="ilot">
      <div class="pop-recharge">
        <div class="pop-recharge__background"></div>
        <button class="pop-recharge__close" id="lightbox-recharge-ilot-pop-close" ></button>
        <div class="content" id="content">
          <div class="pop-recharge__content">
            <div class="recharge">
              <div class="recharge__content">
                <div class="recharge__header">
                  <h2 class="recharge__header-title">Cargar saldo</h2>
                  <ul class="recharge__header-info">
                    <li><strong>Saldo Actual</strong> <span id="clientSale-amount">S/ 0.00</span></li>
                    <li><strong>Bono Te Apuesto</strong> <span id="billetera2-amount">S/ 0.00</span></li>
                    <li><strong>Jugadas gratis</strong> <span id="billetera3-amount">S/ 0.00</span></li>
                  </ul>
                </div>
                <div class="recharge__body">
                  <p class="recharge__body-text"><strong>Elige un método de pago</strong></p>
                  <div class="tabs">
                    <ul class="tabs__list">
                      <li class="tabs__list-item selected" data-target="#internet" data-category="Recarga por internet-Decide" data-label="Cargar Saldo - tab por internet" id="tabInternet">POR INTERNET</li>
                      <li class="tabs__list-item" data-target="#efectivo" data-category="Recarga fisica-Decide" data-label="Cargar saldo - tab en efectivo" id="tabEfectivo">EN EFECTIVO</li>
                    </ul>
                    <div class="tabs__container">
                      <!-- tab internet-->
                      <div class="tabs__container-item" id="internet">
                        <ul class="accordion">
                          
                          <!-- accordion visanet-->
                          <li id="accordion_visanet" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetVisanet','accordion_visanet');"><img class="img-visanet" src="layer-view-image/client/logo-visa-mc.png"></div>
                            <div class="subcontent">
                              <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito VISA y/o MasterCard:</strong></p>
<!--                               <p class="subcontent-text">Recarga entre S/ <span id="amtMinRechargeVisa"></span> y S/ <span id="amtMaxRechargeVisa"></span> hasta en <span id="maxRechargeVisa"></span> transacciones diarias. Recarga máxima semanal S/ <span id="amtMaxRechargeWeekVisa"></span>.</p> -->
							  <p class="subcontent-text">Recarga entre S/ <span id="amtMinRechargeVisa"></span> y S/ <span id="amtMaxRechargeVisa"></span><span id="maxRechargeVisa"></span><span id="amtMaxRechargeWeekVisa"></span></p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Ingresa el monto que deseas recargar. Si tienes un código promocional aplícalo ahora.</li>
                                <li>Luego haz clic en "Cargar" para ingresar tu tarjeta VISA y/o Mastercard.
                                  <form class="form" action="data/recharge.json" id="form_recharge_visanet" autocomplete="off">
                                   	<input type="hidden" name="medio_pago" id="medio_pago_visanet" value="VISANET" />
									<input type="hidden" name="status_code" id="status_code_visanet" value="DES" />
									<input type="hidden" name="id_code" id="id_code_visanet" value="-1" />
                                    <input type="hidden" name="option-card" id="option-card_visanet" value="2" />
	                                      
	                                <div id="modal-visa" style="display:none; position:fixed; top:0; left:0;">
										<iframe id="frameButtonVisa" frameborder="0" style="z-index: 2147483661; width:100%; height:100%;"></iframe>
									</div>      
	                                      
                                    <div class="form__input form__input--small">
                                      <label for="monto_visanet">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_visanet" tabindex="117" maxlength="4" data-validation="number" data-validation-allowing="range[10;1000]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_visanet" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();"  type="text" name="codigo" id="codigo_visanet" tabindex="118" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab VISANET - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="subcontent-comision hide">
                                    	<p class="subcontent-text-comision" id="comision_visanet"><span class="monto-comision-visanet" id="monto_comision_visanet"></span></p>
                                    </div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar Saldo - tab VISANET - generar codigo" onclick="tagginSaldoEEaddToCart()">Cargar</button>
                                    </div>							
                                  </form>
                                </li>
                              </ol>
                              <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
                            </div>
                          </li>
                          
                          <!-- accordion agora-->
                          <li id="accordion_agora" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetAgora','accordion_agora');"><img class="img-agora" src="layer-view-image/client/logo-agora2.png"></div>
                            <div class="subcontent" style="padding-top: 0px;">
                              <div style="padding-top: 5px; padding-bottom: 4px; padding-left: 16px; background-color: #00cdff; margin-left: -16px; margin-right: -16px; font-family: 'Roboto', sans-serif; font-size: 12px;" >
                              	<form>
                              		<a href="https://ago.pe/descarga-agora" target="_blank" style="color: #5A5A5A;" ><span class="icono-download"><span style="vertical-align: super; margin-left: 5px;">Descarga la app</span></span></a>
                              	</form>
                              </div>
<!--                               <p class="subcontent-text"><strong>Con tu tarjeta Agora:</strong></p> -->
                              <p class="subcontent-text" style="padding-top: 10px;">Recarga desde S/<span id="amtMinRechargeAgr"></span> hasta S/<span id="amtMaxRechargeAgr"></span>.</p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li style="margin-bottom: 0px;">Ingresa el monto a recargar. Si tienes un código promocional, escríbelo ahora, y presiona "APLICAR" para hacerlo efectivo.
                                	<form class="form" style="padding-bottom: 0px;" action="data/recharge.json" id="form_recharge_agora" autocomplete="off">
	                                   	<input type="hidden" name="medio_pago" id="medio_pago_agora" value="AGORA" />
										<input type="hidden" name="status_code" id="status_code_agora" value="DES" />
										<input type="hidden" name="id_code" id="id_code_agora" value="-1" />
	                                    <input type="hidden" name="option-card" id="option-card_agora" value="2" />
		                                      
		                                <div id="modal-agora" style="display:none; position:fixed; top:0; left:0;">
											<iframe id="frameButtonAgora" frameborder="0" style="z-index: 2147483661; width:100%; height:100%;"></iframe>
										</div>      
		                                      
	                                    <div class="form__input form__input--small">
	                                      <label for="monto_agora">Monto S/</label>
	                                      <input type="tel" name="monto" id="monto_agora" tabindex="115" maxlength="4" data-validation="number" data-validation-allowing="range[10;1000]" data-validation-error-msg="&amp;nbsp;">
	                                    </div><br>
	                                    <div class="form__input form__input--small w40">
	                                      <label for="codigo_agora" name="lblCodPromo">Código prom.</label>
	                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_agora" tabindex="116" maxlength="20" disabled="true">
	                                    </div>
	                                    <div class="form__gift">
	                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab AGORA - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
	                                    </div>
	                                    <div class="form__alert_recharge"></div>
	                                    <div class="subcontent-comision hide">
	                                    	<p class="subcontent-text-comision" id="comision_agora"><span class="monto-comision-agora" id="monto_comision_agora"></span></p>
	                                    </div>
	                                    
	                                    <div class="form__button">
	                                    	<div id="seccion_agora_confirmada" style="display: none;">
	    	                               		<p class="subcontent-text" style="">Te llegará una notificación para validar tu recarga al app Agora asociado al número <span id="num_agora_confirmado"></span>.</p>
			                                    <button class="button button__base button--small" id="btnRecargaAgora" style="margin-bottom: 18px;" type="submit" disabled data-label="Cargar Saldo - tab AGORA - generar codigo" onclick="tagginSaldoAgoraEEaddToCart()">Recargar</button>
	                                    	</div>
	                                    </div>							
                                  	</form>
                                </li>
                                <li id="seccion_agora_xconfirmar" style="display: none;">Para efectuar esta recarga, deberás confirmarla desde tu app Agora, para lo cual te notificaremos al número <span id="num_agora"></span>. Si es correcto, recarga. Si no, <a onclick="actualizarCelular()" style="text-decoration: underline; color: #e30613;" >actualízalo aquí</a>
                              		<form class="form" style="padding: 0px;" id="form_recharge_agora_2" autocomplete="off">
	                              		<div class="form__input form__input--small" id="divCelularAgora" style="margin-top: 18px; display: none;">
		                                     <label for="cel_agora">Celular</label>
		                                     <input type="tel" name="celular" id="cel_agora" tabindex="117" maxlength="9" data-validation="length number" data-validation-length="9" data-validation-allowing="range[900000000;999999999]" data-validation-error-msg="&amp;nbsp;">
		                                </div><br>
	                              		
	                              		<p class="subcontent-text" id="pInfoAgoraOk" style="font-size: 10px; text-align: center; margin-left: -7px;">Mi información es correcta, solicitar recarga</p>
	                              
			                            <div class="form__button">
			                                <button class="button button__base_2 button--small btn_red_new" id="btnRecargaAgora2" onclick="recargaAgora2()" type="submit" disabled data-label="Cargar Saldo - tab AGORA - generar codigo">Recargar</button>
			                            </div> 
			                        </form>   
                                </li>                                                               
                              </ol>
                                                            
                              <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
                            </div>
                          </li>
                          
                          <!-- accordion yape-->
                          <li id="accordion_Yape" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetYape','accordion_Yape');"><img class="img-pagoefectivo" src="layer-view-image/client/yape.png" style="width: 70px"></div>
                            <div class="subcontent" style="padding-top: 0px;">
                              <div style="padding-top: 5px; padding-bottom: 4px; padding-left: 16px; background-color: #a90089; margin-left: -16px; margin-right: -16px; font-family: 'Roboto', sans-serif; font-size: 12px;" >
                              	<a href="https://az7pj.app.goo.gl/pruebaweb" target="_blank" style="color: white;" ><span class="icono-download"><span style="vertical-align: super; margin-left: 5px;">Descarga la app</span></span></a>
                              </div>
                              <p class="subcontent-text" style="padding-top: 10px;">Recarga en YAPE desde S/<span id="amtMinRechargeYape"></span> hasta S/<span id="amtMaxRechargeYape"></span>.</p>
                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img_viapagoefectivo.png" alt="Banca_por_Internet" ></p>							
                              <ol class="subcontent-list">
                                <li>Ingresa el monto a recargar. Si tienes un código promocional, escríbelo y presionar "APLICAR" para hacerlo efectivo. <br>Luego genera tu código QR.
                                  <form class="form" action="data/recharge-yape.json" id="form_recharge_yape" autocomplete="off" style="padding-bottom: 0px;">
                                    <input type="hidden" name="medio_pago" id="medio_pago_yape_i" value="YAPE" />
									<input type="hidden" name="status_code" id="status_code_yape_i" value="DES" />
									<input type="hidden" name="id_code" id="id_code_yape_i" value="-1" />
									<input type="hidden" name="option-card" id="option-card_yape_i" value="4" />
									<input type="hidden" name="type_token" id="type_token_yape_i" value="1" />
                                    
                                    <div class="form__input form__input--small">
                                      <label for="monto_yape">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_yape" tabindex="130" maxlength="4" data-validation="number" data-validation-allowing="range[15;500]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_yape" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_yape" tabindex="131" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab yape - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar Saldo - tab yape - generar codigo" onclick="tagginSaldoYAPEEEaddToCart()">GENERAR QR</button>
                                    </div>
                                                                        
                                  </form>
                                </li>
                              </ol>
                                   
                              <header id="frame_yapepefl" class="hide" style="margin-left: -16px; width: 111%;">
								<div class="embwrap">
									<div class="embcell">
										<div class="ifrwrap">
											<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
										</div>
									</div>
								</div>
							  </header>
							  <button type="button" id="close_yapepefl" class="btn btn-sm btn-black hide" style="margin-left: -16px; width: 111%;">CERRAR</button>
									                         
                              <div class="subcontent-footer" style="margin-top: 20px; display: none;" id="divVerificaRecargaYape">Luego de pagar en Yape <br>
                                <a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('YAPE','1');">verifica tu recarga aquí</a>
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
                          </li>                          
                          
                          <!-- accordion interbank-->
                          <li id="accordion_interbank" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetInterbank','accordion_interbank');"><img class="img-interbank" src="layer-view-image/client/logo-interbank.png"></div>
                            <div class="subcontent">
                              <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito Interbank:</strong></p>
<!--                               <p class="subcontent-text">Recarga desde S/20 hasta S/10,000.</p> -->
                              <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeIbk"></span> hasta S/<span id="amtMaxRechargeIbk"></span>.</p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Desde Interbank.pe o tu App Interbank selecciona: <br><strong>Operaciones &gt; Pagos y Recargas &gt; Pago a Institución o Empresas &gt; La Tinka &gt; Recarga Web</strong></li>
                                <li>Ingresa tu DNI. En tipo de pago <strong>Parcial,</strong> ingresa el monto a depositar y confirma tu recarga.</li>
                                <li>Luego, si tienes un código promocional, ingrésalo aquí:</li>
                              </ol>
                              
                              <div class="subcontent-list">
                              	<form  class="form" id="form_recharge_ibk_i" autocomplete="off" style="padding: 0px 0;">
                                	<input type="hidden" name="medio_pago" id="medio_pago_ibk_i" value="IBK" />
									<input type="hidden" name="status_code" id="status_code_ibk_i" value="DES" />
									<input type="hidden" name="id_code" id="id_code_ibk_i" value="-1" />
									<input type="hidden" name="option-card" id="option-card_ibk_i" value="12" />
									
									<div class="form__input form__input--small w40">
                                      <label for="codigo_ibk_i" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_ibk_i" tabindex="119" maxlength="20" >
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab IBK - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
									<div class="form__alert_recharge"></div>
                              	</form>
                              </div>
                                                           
                              <p class="subcontent-link" style="margin-top: 80px;"><a class="link link__arrow" href="https://interbank.pe" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab interbank - ir interbank" target="_blank" style="color:#e30613; border-bottom: solid 1px #e30613;">Ir a Interbank</a></p>
                              <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>". Si hay una promoción vigente que quieras canjear podrás hacerlo después de recargar.</div>
                            </div>
                          </li>
                          <!-- accordion bcp-->
                          <li id="accordion_bcp" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetBCP','accordion_bcp');"><img class="img-bcp" src="layer-view-image/client/logo-bcp.png"></div>
                            <div class="subcontent">
                              <p class="subcontent-text"><strong>Con tu tarjeta de crédito o débito BCP:</strong></p>
                              <p class="subcontent-text">Recarga desde S/<span id="minAmountBCP"></span> hasta S/<span id="maxAmountBCP"></span>.</p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago BCP.
                                  <form class="form" action="data/recharge.json" id="form_recharge_bcp" autocomplete="off">
                                   	<input type="hidden" name="medio_pago" id="medio_pago_bcp" value="BCP" />
									<input type="hidden" name="status_code" id="status_code_bcp" value="DES" />
									<input type="hidden" name="id_code" id="id_code_bcp" value="-1" />
                                    <input type="hidden" name="option-card" id="option-card_bcp" value="2" />
	                                      
                                    <div class="form__input form__input--small">
                                      <label for="monto_bcp">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_bcp" tabindex="120" maxlength="5" data-validation="number" data-validation-allowing="range[0;0]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_bcp" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_bcp" tabindex="121" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <!--img.form__gift-icon(src='img/icon-gift.svg', width='18', height='18')-->
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab BCP - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar Saldo - tab BCP - generar codigo" onclick="tagginSaldoBCPEEaddToCart()">Continuar</button>
                                    </div>
                                 
                                   	<div class="subcontent" style="padding:0px; margin-right: -17px; margin-left: -41px; border: none;">
										<table class="subcontent-table" id="grillaBCP" style="margin-left:0px;width:100%;">
										</table>
									</div>
									
                                  </form>
                                  <template id="tpl-recharge-head">
                                    <tr>
                                      <th>Monto</th>
                                      <th style="line-height: 15px;">Código <br> BCP </th>
                                      <th>Vigencia</th>
                                      <th>Estado</th>
                                      <th>&nbsp;</th>
                                    </tr>
                                  </template>
                                  <template id="tpl-recharge-item">
                                    <tr class="row_grid">
                                      <td>{{amount}}</td>
                                      <td>{{code}}</td>
                                      <td>{{date}}</td>
                                      <td><a class="link link__base {{urlvalidate}}" style="cursor: pointer;" data-pin="{{pin}}">Verificar</a></td>
                                      <td><a class="link link__base {{urlcancel}}" style="cursor: pointer;" data-pin="{{pin}}">Anular</a></td>
                                    </tr>
                                  </template>
                                </li>
                                <li>Ingresa a tu cuenta BCP. Selecciona la opción <strong>Pago de servicios &gt; La Tinka (Compras) &gt; Recarga Web</strong>, e ingresa el código generado en el campo de "Código BCP".</li>
                              </ol>
                              <p class="subcontent-link"><a class="link link__arrow" href="https://www.viabcp.com" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab BCP - ir a BCP" target="_blank" style="color:#e30613; border-bottom: solid 1px #e30613;">Ir a BCP</a></p>
                              <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
                            </div>
                          </li>
                          <!-- accordion plin-->
                          <li id="accordion_Plin" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetPlin','accordion_Plin');"><img class="img-pagoefectivo" src="layer-view-image/client/plin.png" style="width: 37px"></div>
                            <div class="subcontent" style="padding-top: 0px;">
                              <p class="subcontent-text" style="padding-top: 10px;">Recarga en PLIN desde S/<span id="amtMinRechargePlin"></span> hasta S/<span id="amtMaxRechargePlin"></span>.</p>
                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img_viapagoefectivo.png" alt="Banca_por_Internet" ></p>							
                              <ol class="subcontent-list">
                                <li>Ingresa el monto a recargar. Si tienes un código promocional, escríbelo y presionar "APLICAR" para hacerlo efectivo. <br>Luego genera tu código QR.
                                  <form class="form" action="data/recharge-plin.json" id="form_recharge_plin" autocomplete="off" style="padding-bottom: 0px;">
                                    <input type="hidden" name="medio_pago" id="medio_pago_plin_i" value="PLIN" />
									<input type="hidden" name="status_code" id="status_code_plin_i" value="DES" />
									<input type="hidden" name="id_code" id="id_code_plin_i" value="-1" />
									<input type="hidden" name="option-card" id="option-card_plin_i" value="4" />
									<input type="hidden" name="type_token" id="type_token_plin_i" value="1" />
                                    
                                    <div class="form__input form__input--small">
                                      <label for="monto_plin">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_plin" tabindex="130" maxlength="4" data-validation="number" data-validation-allowing="range[15;500]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_plin" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_plin" tabindex="131" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab plin - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar Saldo - tab plin - generar codigo" onclick="tagginSaldoPLINEEaddToCart()">GENERAR QR</button>
                                    </div>
                                                                        
                                  </form>
                                </li>
                              </ol>
                                   
                              <header id="frame_plinpefl" class="hide" style="margin-left: -16px; width: 111%;">
								<div class="embwrap">
									<div class="embcell">
										<div class="ifrwrap">
											<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
										</div>
									</div>
								</div>
							  </header>
							  <button type="button" id="close_plinpefl" class="btn btn-sm btn-black hide" style="margin-left: -16px; width: 111%;">CERRAR</button>
									                         
                              <div class="subcontent-footer" style="margin-top: 20px; display: none;" id="divVerificaRecargaPlin">Luego de pagar en PLIN <br>
                                <a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('PLIN','1');">verifica tu recarga aquí</a>
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
                          </li>
                          <!-- accordion pagoefectivo-->
                          <li id="accordion_pagoefectivo" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetPagoEfectivo','accordion_pagoefectivo');"><img class="img-pagoefectivo" src="layer-view-image/client/logo_pe_mobile.png" style="width: 93px"></div>
                            <div class="subcontent">
                              <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargePefe"></span> hasta S/<span id="amtMaxRechargePefe"></span>.</p>
                              <p class="subcontent-text"><strong>Desde la banca por Internet o banca móvil</strong></p>
<!--                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank"><img class="subcontent-logo subcontent-logo--fix" src="layer-view-image/client/img-pagoefectivo.png" alt="PagoEfectivo"></p> -->
                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-logosbancos-pefe-mobile.png" alt="Banca_por_Internet" style="height: 84px;"></p>							
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago PagoEfectivo.
                                  <form class="form" action="data/recharge-pagoefectivo.json" id="form_recharge_pagoefectivo" autocomplete="off">
                                    <input type="hidden" name="medio_pago" id="medio_pago_pefe_i" value="PEFE" />
									<input type="hidden" name="status_code" id="status_code_pefe_i" value="DES" />
									<input type="hidden" name="id_code" id="id_code_pefe_i" value="-1" />
									<input type="hidden" name="option-card" id="option-card_pefe_i" value="4" />
									<input type="hidden" name="type_token" id="type_token_pefe_i" value="1" />
                                    
                                    <div class="form__input form__input--small">
                                      <label for="monto_pagoefectivo">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_pagoefectivo" tabindex="130" maxlength="4" data-validation="number" data-validation-allowing="range[40;3000]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_pagoefectivo" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_pagoefectivo" tabindex="131" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab pagoefectivo - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar Saldo - tab pagoefectivo - generar codigo" onclick="tagginSaldoPEfectivoEEaddToCart()">Continuar</button>
                                    </div>
                                    <br>
                                    <header id="frame_pefl" class="hide" style="margin-left: -40px; width: 122%;">
										<div class="embwrap">
											<div class="embcell">
												<div class="ifrwrap">
													<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
												</div>
											</div>
										</div>
									</header>
									<button type="button" id="close_pefl" class="btn btn-sm btn-black hide" style="margin-left: -40px; width: 122%;">CERRAR</button>
                                    
                                  </form>
                                </li>
                                <li>Copia el código e ingresa a la página web o App de tu banco. En <strong>Pagos de Servicios</strong> busca la empresa <strong>PagoEfectivo &gt; PagoEfectivo Soles</strong>. Ingresa el código generado y sigue los pasos.</li>
                              </ol>
                              <p class="subcontent-link"><a class="link link__play" href="https://pagoefectivo.pe/como-pagar.html" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab pagoefectivo - como funciona" target="_blank" style="color: #e30613; border-bottom: solid 1px #e30613;">¿Cómo funciona?</a></p>                                                            
                              <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaPEFE">Luego de pagar vía PagoEfectivo<br>
                               	<a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('PEFE','1');">verifica tu recarga aquí</a>
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
                          </li>
                          <!-- tab safetypay-->
                          <li  id="accordion_safetypay" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('internetSafetyPay','accordion_safetypay');"><img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png"></div>
                            <div class="subcontent">
                              <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeSpay"></span> hasta S/<span id="amtMaxRechargeSpay"></span>.</p>
                              <p class="subcontent-text"><strong>Desde la web de tu banco con tu tarjeta de crédito o débito.</strong></p>
                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank">&nbsp;<img class="subcontent-logo" src="layer-view-image/client/img-safetypay.png" alt="SafetyPay"></p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago SafetyPay.
                                  <form class="form" action="data/recharge-safetypay.json" id="form_recharge_safetypay" autocomplete="off">
                                   	<input type="hidden" name="medio_pago" id="medio_pago_spay_i" value="SPAY" />
									<input type="hidden" name="status_code" id="status_code_spay_i" value="DES" />
									<input type="hidden" name="id_code" id="id_code_spay_i" value="-1" />
									<input type="hidden" name="option-card" id="option-card_spay_i" value="5" />
									<input type="hidden" name="type_token" id="type_token_spay_i" value="1" />
                                    
                                    <div class="form__input form__input--small">
                                      <label for="monto_safetypay">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_safetypay" tabindex="140" maxlength="4" data-validation="number" data-validation-allowing="range[80;3000]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_safetypay" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_safetypay" tabindex="141" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab safetypay - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar Saldo - tab safetypay - generar codigo" onclick="tagginSaldoSPayEEaddToCart();">Continuar</button>
                                    </div>
                                    <br>
                                    <header id="frame_sfpl" class="hide">
										<div class="embwrap">
											<div class="embcell">
												<div class="ifrwrap">
													<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
												</div>
											</div>
										</div>
									</header>
                                    <button type="button" id="close_sfpl" class="btn btn-sm btn-black hide">CERRAR</button>
                                  </form>
                                </li>
                                <li>Copia el código e ingresa a la página web o App de tu banco. En <strong>Pagos de Servicios</strong> busca la empresa <strong>SafetyPay &gt; SafetyPay Soles</strong>. Ingresa el código generado y sigue los pasos.</li>
                              </ol>
<!--                               <p class="subcontent-link"><a class="link link__play" href="#" data-name="Decide - Cargar Saldo" data-category="Recarga por Internet-Decide" data-action="click" data-label="Cargar Saldo - tab safetypay - como funciona" target="_blank" >¿Cómo funciona?</a></p> -->
                              <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
                            </div>
                          </li>
                        </ul>
                      </div>
                      <!-- tab efectivo-->
                      <div class="tabs__container-item" id="efectivo">
                        <ul class="accordion">
                          <!-- accordion interbank-->
                          <li id="accordion_efectivo_interbank" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('efectivoInterbank','accordion_efectivo_interbank');"><img class="img-interbank" src="layer-view-image/client/logo-interbank.png"></div>
                            <div class="subcontent">
                              <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeIbkE"></span> hasta S/<span id="amtMaxRechargeIbkE"></span> en el banco o en un agente autorizado de Interbank.</p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Solicita tu recarga La Tinka, indica el código 0731802, el número de tu DNI y el monto a recargar</li>
                                <li>Luego, si tienes un código promocional, ingrésalo aquí:</li>
                              </ol>
                              
                              <div class="subcontent-list">
                              	<form  class="form" id="form_recharge_ibk_e" autocomplete="off" style="padding: 0px 0;">									
									<input type="hidden" name="medio_pago" id="medio_pago_ibk_e" value="IBK" />
									<input type="hidden" name="status_code" id="status_code_ibk_e" value="DES" />
									<input type="hidden" name="id_code" id="id_code_ibk_e" value="-1" />
									<input type="hidden" name="option-card" id="option-card_ibk_e" value="11" />
									
									<div class="form__input form__input--small w40">
                                      <label for="codigo_ibk_e" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_ibk_e" tabindex="190" maxlength="20">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar Saldo - tab IBK - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
									<div class="form__alert_recharge"></div>
                              	</form>
                              </div>
                              
                              <div class="subcontent-footer" style="margin-top: 80px;">Verifica tu recarga en la sección "<strong>Movimientos</strong>". Si hay una promoción vigente que quieras canjear podrás hacerlo después de recargar.</div>
                            </div>
                          </li>
                          <!-- accordion lotocard-->
                          <li id="accordion_efectivo_lotocard" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('efectivoLotocard','accordion_efectivo_lotocard');"><strong>Lotocard</strong></div>
                            <div class="subcontent">
                              <p class="subcontent-text"><strong>Con Lotocard:</strong></p>
                              <p class="subcontent-text">Recarga con tus Lotocard de S/10, S/20, S/50 ó S/100. <br>Encuéntralos en todos los puntos de venta La Tinka.</p>
                              <div class="subcontent-lotocard">
<!--                                 <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                                <ol class="subcontent-list">
                                  <li>Digita el código PIN de 14 dígitos de tu Lotocard. <br>Si tienes un código promocional aplícalo ahora. <br>Luego, haz click en el botón "Cargar".
                                    <form class="form" action="data/recharge-lotocard.json" id="form_recharge_lotocard" autocomplete="off">
                                      <input type="hidden" name="medio_pago" id="medio_pago_lotocard" value="LOTOCARD" />
	                                  <input type="hidden" name="status_code" id="status_code_lotocard" value="DES" />
	                                  <input type="hidden" name="id_code" id="id_code_lotocard" value="-1" />
	                                  <input type="hidden" name="option-card" id="option-card_lotocard" value="1" />
                                      
                                      <div class="form__input form__input--small">
                                        <label for="lotocard">Código Lotocard</label>
                                        <input type="tel" name="lotocard" id="lotocard" tabindex="150" maxlength="14" data-validation="length number" data-validation-length="14" data-validation-error-msg="&amp;nbsp;">
                                      </div><br>
                                      <div class="form__input form__input--small w40">
                                        <label for="codigo_lotocard" name="lblCodPromo">Código prom.</label>
                                        <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_lotocard" tabindex="151" maxlength="20" disabled="true">
                                      </div>
                                      <div class="form__gift">
                                        <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar saldo - tab lotocard - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                      </div>
                                      <div class="form__alert_recharge"></div>
                                      <div class="form__button">
                                        <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar saldo - tab lotocard - cargar">Cargar</button>
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
                                    <td>S/ <span id="montoCargado"></span></td>
                                  </tr>
<!--                                   <tr> -->
<!--                                     <td>Saldo disponible</td> -->
<!--                                     <td><span id="saldoDisponible"></span></td> -->
<!--                                   </tr> -->
                                </table>
                                <p><img class="icon-reload" src="layer-view-image/client/icon-reload.svg"><a class="link link__base" href="#">Volver a recargar</a></p>
                              </div>
                              <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
                            </div>
                          </li>
                          <!-- accordion pagoefectivo-->
                          <li id="accordion_efectivo_pagoefectivo" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('efectivoPagoEfectivo','accordion_efectivo_pagoefectivo');"><img class="img-pagoefectivo" src="layer-view-image/client/logo_pe_mobile.png" style="width: 93px"></div>
                            <div class="subcontent">
                              <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargePefeE"></span> hasta S/<span id="amtMaxRechargePefeE"></span>.</p>
                              <p class="subcontent-text"><strong>En Agentes y Bodegas</strong></p>
<!--                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank">&nbsp;<img class="subcontent-logo" src="layer-view-image/client/img-pagoefectivo.png" alt="PagoEfectivo"></p> -->
                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/mobile_efectivo.png" alt="Agentes_y_Bodegas" style="height: 135px"></p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago PagoEfectivo.
                                  <form class="form" action="data/recharge-pagoefectivo.json" id="form_recharge_pagoefectivo" autocomplete="off">
                                    <input type="hidden" name="medio_pago" id="medio_pago_pefe_e" value="PEFE" />
									<input type="hidden" name="status_code" id="status_code_pefe_e" value="DES" />
									<input type="hidden" name="id_code" id="id_code_pefe_e" value="-1" />
									<input type="hidden" name="option-card" id="option-card_pefe_e" value="9" />
									<input type="hidden" name="type_token" id="type_token_pefe_e" value="2" />
                                    
                                    <div class="form__input form__input--small">
                                      <label for="monto_pagoefectivo_efectivo">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_pagoefectivo_efectivo" tabindex="160" maxlength="4" data-validation="number" data-validation-allowing="range[40;3000]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_pagoefectivo_efectivo" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_pagoefectivo_efectivo" tabindex="161" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar saldo - tab pagoefectivo - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar saldo - tab pagoefectivo - cargar" onclick="tagginSaldoEEPEfectivoEEaddToCart()">Continuar</button>
                                    </div>
                                    <br>
                                    <header id="frame_pefe" class="hide">
										<div class="embwrap">
											<div class="embcell">
												<div class="ifrwrap">
													<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
												</div>
											</div>
										</div>
									</header>
                                    <button type="button" id="close_pefe" class="btn btn-sm btn-black hide">CERRAR</button>
                                  </form>
                                </li>
                                <li>Copia el código de la ventana emergente, acércate a cualquier agente o bodega autorizada y realiza el pago.</li>
                              </ol>
                              <p class="subcontent-link"><a class="link link__arrow" href="https://ubicanos.pagoefectivo.pe/" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab pagoefectivo - ver lugares" target="_blank" style="color: #e30613; border-bottom: solid 1px #e30613">Ver lugares</a></p>
                              <p class="subcontent-link"><a class="link link__play" href="https://pagoefectivo.pe/como-pagar.html" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab pagoefectivo - como funciona" target="_blank" style="color: #e30613; border-bottom: solid 1px #e30613">¿Cómo funciona?</a></p>                             
                              <div class="subcontent-footer" style="display: none;" id="divVerificaRecargaPEFEE">Luego de pagar vía PagoEfectivo<br>
                               	<a style="cursor: pointer; color: #e30613; border-bottom: solid 1px #e30613; font-weight: 500;" onclick="verificaRecargaPE('PEFE','2');">verifica tu recarga aquí</a>
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
                          </li> 
                          <!-- accordion safetypay-->
                          <li id="accordion_efectivo_safetypay" style="display: none;">
                            <div class="accordion__title" onclick="tagginTabCargarSaldo('efectivoSafetyPay','accordion_efectivo_safetypay');"><img class="img-safetypay" src="layer-view-image/client/logo-safety-pay.png"></div>
                            <div class="subcontent">
                              <p class="subcontent-text">Recarga desde S/<span id="amtMinRechargeSpayE"></span> hasta S/<span id="amtMaxRechargeSpayE"></span>.</p>
                              <p class="subcontent-text"><strong>En un banco o agente autorizado vía SafetyPay.</strong></p>
                              <p class="subcontent-text"><img class="subcontent-logo" src="layer-view-image/client/img-interbank.png" alt="Interbank"><img class="subcontent-logo" src="layer-view-image/client/img-bcp.png" alt="BCP"><img class="subcontent-logo" src="layer-view-image/client/img-bbva.png"  alt="BBVA"><img class="subcontent-logo" src="layer-view-image/client/img-scotiabank.png" alt="Scotiabank">&nbsp;<img class="subcontent-logo" src="layer-view-image/client/img-safetypay.png" alt="SafetyPay"></p>
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
                              <ol class="subcontent-list">
                                <li>Ingresa el monto que deseas recargar. <br>Si tienes un código promocional aplícalo ahora. <br>Luego genera tu código de pago SafetyPay.
                                  <form class="form" action="data/recharge-safetypay.json" id="form_recharge_safetypay" autocomplete="off">
                                    <input type="hidden" name="medio_pago" id="medio_pago_spay_e" value="SPAY" />
									<input type="hidden" name="status_code" id="status_code_spay_e" value="DES" />
									<input type="hidden" name="id_code" id="id_code_spay_e" value="-1" />
									<input type="hidden" name="option-card" id="option-card_spay_e" value="3" />
									<input type="hidden" name="type_token" id="type_token_spay_e" value="2" />
                                    
                                    <div class="form__input form__input--small">
                                      <label for="monto_safetypay_efectivo">Monto S/</label>
                                      <input type="tel" name="monto" id="monto_safetypay_efectivo" tabindex="170" maxlength="4" data-validation="number" data-validation-allowing="range[80;3000]" data-validation-error-msg="&amp;nbsp;">
                                    </div><br>
                                    <div class="form__input form__input--small w40">
                                      <label for="codigo_safetypay_efectivo" name="lblCodPromo">Código prom.</label>
                                      <input oninput="this.value = this.value.toUpperCase();" type="text" name="codigo" id="codigo_safetypay_efectivo" tabindex="171" maxlength="20" disabled="true">
                                    </div>
                                    <div class="form__gift">
                                      <button class="button button__outline button--small" type="button" data-action="data/validate.json" data-label="Cargar saldo - tab safetypay - aplicar código promocional">Aplicar</button><span class="form__gift-valid"><img src="layer-view-image/client/icon-valid.svg" width="16" height="16">Cod. correcto</span>
                                    </div>
                                    <div class="form__alert_recharge"></div>
                                    <div class="form__button">
                                      <button class="button button__base button--small btn_red_new" type="submit" disabled data-label="Cargar saldo - tab safetypay - generar codigo" onclick="tagginSaldoEESPayEEaddToCart()">Continuar</button>
                                    </div>
                                    <br>
                                    <header id="frame_sfpe" class="hide">
										<div class="embwrap">
											<div class="embcell">
												<div class="ifrwrap">
													<iframe src="about:blank" webkitallowfullscreen="true" mozallowfullscreen="true" allowfullscreen="true" allowtransparency="true" scrolling="yes" frameborder="0" width="100%" height="100%"></iframe>
												</div>
											</div>
										</div>
									</header>
                                    <button type="button" id="close_sfpe" class="btn btn-sm btn-black hide">CERRAR</button>
                                  </form>
                                </li>
                                <li>Copia el código de la ventana emergente, acércate a cualquier banco o agente autorizado y realiza el pago.</li>
                              </ol>
<!--                               <p class="subcontent-link"><a class="link link__play" href="#" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab safetypay - como funciona" target="_blank">¿Cómo funciona?</a></p> -->
                              <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>"</div>
                            </div>
                          </li>
                          <!-- accordion red digital-->
<!--                           <li> -->
<!--                             <div class="accordion__title"><img class="img-safetypay" src="layer-view-image/client/logo-red-digital.png"></div> -->
<!--                             <div class="subcontent"> -->
<!--                               <p class="subcontent-text"><strong>Con Red Digital:</strong></p> -->
<!--                               <p class="subcontent-text">Deposita desde S/10 hasta S/150.</p> -->
<!--                               <p class="subcontent-text"><strong>¿Cómo Recargar?</strong></p> -->
<!--                               <ol class="subcontent-list"> -->
<!--                                 <li>Solicita la recarga Te Apuesto o La Tinka. Indica tu DNI, número de celular y el monto a recargar ¡Listo!</li> -->
<!--                               </ol> -->
<!--                               <p class="subcontent-link"><a class="link link__arrow fixlong" href="https://mapa.intralot.com.pe/" data-name="Decide - Cargar Saldo" data-category="Recarga fisica-Decide" data-action="click" data-label="Cargar saldo - tab red digital - encuentra red digital cercano" target="_blank">Encuentre los puntos <br>más cercano aquí</a></p> -->
<!--                               <div class="subcontent-footer">Verifica tu recarga en la sección "<strong>Movimientos</strong>". Si hay una promoción vigente que quieras canjear podrás hacerlo después de recargar.</div> -->
<!--                             </div> -->
<!--                           </li> -->
                        </ul>
                      </div>
                    </div>
                  </div>
                  <p class="recharge__body-legal"><a class="link link__base" href="<%= Constantes.URL_QW%>/terminos-y-condiciones/" target="_blank" id="agre_tyc_deprecated" style="color: #e30613; border-bottom: solid 1px #e30613;">Términos del uso del saldo virtual</a></p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="error" id="alert">${alert}</div>
      
      <div id="popup-tyc" class="overlay" style="z-index:10000;">
			<div class="popup popup-sm">
				<a class="close js-close-modal"  href="#">&times;</a>
				<div class="wrap-modal">
					<jsp:include page="../client/interface-term.jsp"/>
				</div>
			</div>
	  </div>
      
<!--       <footer class="footer">footer</footer> -->
      <div class="gridview">
        <div class="content">
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
          <div class="gridview__col">&nbsp;</div>
        </div>
      </div>
    </div>
    
	<div id="alert_content" style="display:none">
		<div id="alertModal_content_id" class="confirmModal_content"></div>
		<div class="confirmModal_footer_alert">
			<button type="button" id="btnAlertContent" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">OK</button>
		</div>
	</div>
	
	<div id="confirm_content" style="display:none">
		<div id="confirmModal_content_id" class="confirmModal_content"></div>
		<div class="confirmModal_footer">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">Continuar</button>
			<button type="button" class="dialog d-btn d-btn-default" data-confirmmodal-but="cancel">Retornar</button>
		</div>
	</div>
	
	<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
	<script type="text/javascript" src="layer-view-script/main-1.0.js?v=<%=Constantes.main_1_0_js%>" charset="UTF-8"></script>
	<script type="text/javascript" src="layer-view-script/popModal.js"></script>
	<script type="text/javascript" src="layer-view-script/funcionesTaggingRecargas.js?v=4"></script>
	
	<script>
	  var lastHeight=0, newHeight=0;
      $(document).ready(function() {
        renderPopup();
        loadRecharge();        
        
        //setInterval(bodyHeightCheck, 1000);
        
      });
      
      function bodyHeightCheck(){
    	  try {
    		newHeight = $("#content").height();
    		if(newHeight !== lastHeight) {
    			window.parent.postMessage('{"setHeight":"'+ newHeight +'px"}','*');
    		}
    		lastHeight = newHeight;
    	  } catch (e) {   
    	  	console.log(e);
    	  }
      }
    </script>
	
</body>
</html>