<!DOCTYPE html>
<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="es">
<head>
	<!-- Google Tag Manager -->
    <script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
    new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
    j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
    'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
    <!-- End Google Tag Manager -->
    <script src="https://web-button.metamap.com/button.js"></script>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
	<title>Retirar Premio - La Tinka</title>	
	
		<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/mainCollectPrize.css?v=30">	
	<meta http-equiv="Permissions-Policy" content="geolocation=(https://signup.metamap.com) camera=(self 'https://signup.metamap.com') microphone=(https://signup.metamap.com)">
</head>
<body class="no-scroll">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L" height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
<input type="hidden" id="prizetoken" value="${prizetoken}" />
<section class="ipremio">
   <input type="hidden" id="numDiasExpiracion" value="">
   <input type="hidden" id="numCuentaSeleccionadaEliminar" value="">
   <input type="hidden" id="cid" value="${cid}" >
   
	<div style="display: none;">
		<mati-button
		      clientid="63c5aafb54916c001c517b3d"
		      flowId= <%=Constantes.KYC_FLOWID%>
		      metadata=''
		      id="metamap-button"
		  />
	</div>
	

   <div class="ioverlay modal-msg" id="modal-confirmar-eliminar-cuenta-transferencia">
      <div class="modal is-error">
        <div class="modal__boby" style="padding-bottom: 20px;" >  
        	<div>
	        	<p style='text-align: center; margin-bottom: 0px;'> 
		          	<span style='font-size: 16px; font-weight: 700;'>Eliminar</span>
	          	</p>
				<br>
	          	<p id="textoEliminarCuentaTransferencia" style='text-align: center; line-height: 20px;'> </p>
        	</div>
        	<button class="btn" style="background: #07663a; margin: 20px auto 0;" onclick="eliminarCuentaTransferencia()">ACEPTAR</button>
          	<button class="btn" style="margin-top: 12px; background: #ffffff; border: 2px solid #07663a; color: #77736f;" onclick="cancelarEliminarCuentaTransferencia()">CANCELAR</button>
        </div>
      </div>
    </div>
        
	<div class="ioverlay modal-msg" id="modal-confirmar-retiro-transferencia">
      <div class="modal is-error">
        <div class="modal__boby" style="padding-bottom: 20px;" >          
          <div>
          	<p style='text-align: center; margin-bottom: 0px;'> 
	          	<span style='font-size: 16px; font-weight: 700;'>Confirma tus datos</span> <br><br> 
          	</p>
          	
          	<table style="font-size: 13px; line-height: 13px;">
          		<tbody>
          			<tr><td>Monto de retiro</td><td>: S/ <span id="confirmaMontoTransferencia"></span></td></tr>
          			<tr><td>Banco</td><td>: <span id="confirmaBancoTransferencia"></span></td></tr>
          			<tr><td>Cuenta destino</td><td>: Ahorro soles</td></tr>
          			<tr><td> </td><td>&nbsp;&nbsp;<span id="confirmaNumCuentaTransferencia"></span></td></tr>
          			<tr id="filaJugadaGratisCD"><td>Jugadas gratis</td><td><span id="lblJugadaGratisCD"></span></td></tr>
          			<tr><td>Datos</td><td>: <span id="confirmaNombresTransferencia"></span></td></tr>
          			<tr><td> </td><td>&nbsp;&nbsp;<span id="confirmaDocumentoTransferencia"></span></td></tr>
          			<tr><td>Departamento</td><td>: <span id="confirmaDepartamentoTransferencia"></span></td></tr>
          		</tbody>
          	</table>
          	
          	<p style='text-align: left; line-height: 12px;'> 
				<br><span style="font-size: 10px;">Para que tu retiro sea aprobado, t� debes ser el titular de la cuenta y los datos de tu cuenta de La Tinka deben ser iguales a los de tu cuenta bancaria. Caso contrario, tu retiro ser� rechazado.</span><br> 
          	</p>
          	<div id="divRecurrencia">
	          	<hr>
	          		<div class="form__check">
	                  <input type="checkbox" name="recurrenteTra" id="recurrenteTra" value="Y" style="position: absolute; opacity: 0;">
	                  <label for="recurrenteTra" style="color: #086c46;font-size: 11px;">Guardar n�mero de cuenta como recurrente</label>
	                </div>
	          	<hr>
          	</div>
          </div>
          <button class="btn" id="aceptar-confirmar-retiro-transferencia" onclick="continuarRetiroTransferenciaPin()" style="background: #07663a; margin: 20px auto 0;">Confirmar retiro</button>
          <button class="btn" style="margin-top: 12px; background: #ffffff; border: 2px solid #07663a; color: #77736f;" id="regresar-transferencia" onclick="regresarRetiroTransferencia()">REGRESAR</button>
          <p style="margin-top: 20px; margin-bottom: 0px; font-size: 11px; text-align: justify;">Algunos bancos cobran una comisi�n interplaza del 0.05% del monto retirado, o un m�nimo de S/7.50. Si quieres actualizar tu nombre, apellidos o DNI,    
             <a href="derechos-arco.html" target="_blank" style="text-decoration: underline; color: #e30613;">solic�talo aqu�</a>
          </p>
        </div>
      </div>
    </div>

	<div class="ioverlay modal-msg" id="modal-confirmar-retiro-transferencia-pin">
	  <div class="modal is-error modal-otp-v2">
	    <div class="modal-otp-v2__topbar">
	      <div class="modal-otp-v2__nav">
	        <span class="modal-otp-v2__nav-back" aria-hidden="true"></span>
	        <div class="modal-otp-v2__nav-title">Solicitar retiro</div>
	        <button type="button" class="modal-otp-v2__nav-close" onclick="closeModal()" aria-label="Cerrar"></button>
	      </div>
	      <div class="modal-otp-v2__amount">
	        <div class="modal-otp-v2__amount-label">Monto a retirar</div>
	        <div class="modal-otp-v2__amount-icon" aria-hidden="true"></div>
	        <div class="modal-otp-v2__amount-channel">Efectivo / Puntos de Venta</div>
	      </div>
	    </div>
	    <div class="modal__boby modal-otp-v2__body">
	      <div class="modal-otp-v2__hero">
	        <img class="modal-otp-v2__hero-img" src="layer-view-image/v2/autorizacion.png" alt="" />
	      </div>
	      <h3 class="modal-otp-v2__title" id="ecoPinTitulo"></h3>
	      <p class="modal-otp-v2__message"><span id="ecoPinMensaje"></span></p>
	      <div class="ilot modal-otp-v2__otp" id="ecoPinInput">
	        <div class="activate">
	          <form class="form" id="form_activate" autocomplete="off" method="post">
	            <div class="form__code" id="idPinCode">
	              <div class="form__code-item"><input type="text" name="code-01" id="code-01" tabindex="31" maxlength="1"></div>
	              <div class="form__code-item"><input type="text" name="code-02" id="code-02" tabindex="32" maxlength="1"></div>
	              <div class="form__code-item"><input type="text" name="code-03" id="code-03" tabindex="33" maxlength="1"></div>
	              <div class="form__code-item"><input type="text" name="code-04" id="code-04" tabindex="34" maxlength="1"></div>
	              <div class="form__code-item"><input type="text" name="code-05" id="code-05" tabindex="35" maxlength="1"></div>
	            </div>
	            <div class="form__alert" id="ecoPinMensajeError"></div>
	            <button class="btn btn_green modal-otp-v2__submit" id="btactivatepin" type="submit" disabled>ENVIAR</button>
	          </form>
	        </div>
	      </div>
	      <div class="modal-otp-v2__resend">
	        <span class="modal-otp-v2__resend-text">&iquest;A&uacute;n no recibes el c&oacute;digo?</span>
	        <a id="btnReenvioCodeEmail" class="modal-otp-v2__resend-link" href="javascript:reenviarRetiroTransferenciaPinCorreo();">Reenviar c&oacute;digo</a>
	      </div>
	      <a id="btnReenvioCodeSMS" class="modal-otp-v2__sms" href="javascript:reenviarRetiroTransferenciaPinSms();">Enviar por SMS</a>
	    </div>
	  </div>
	</div>
    
	<div class="ioverlay modal-msg" id="modal-confirmar-retiro-efectivo">
      <div class="modal is-error">
        <div class="modal__boby" style="padding-left: 25px; padding-right: 25px;">          
          <div>
<!--           	<p style='text-align: center;'>  -->
<!-- 	          	<span style='font-size: 16px; font-weight: 700;'>�Cobra tus premios sin salir de casa!</span> <br><br>  -->
<!-- 	          	<span>Recuerda que para recibir el dinero en tu cuenta bancaria, s&oacute;lo necesitas ingresar la </span>  -->
<!-- 	          	<span style='font-weight: 700;'>tarjeta Visa d&eacute;bito </span>  -->
<!-- 	          	<span>asociada a esa cuenta.</span> <br><br>  -->
<!-- 	          	<span>�A&uacute;n deseas retirar en efectivo</span> <br>  -->
<!-- 	          	<span>o prefieres retirar a tu cuenta con Visa?</span>  -->
<!--           	</p> -->
			<p style='text-align: center;'><span style='font-size: 16px; font-weight: 700;'>�Cobra tus premios sin salir de casa!</span></p>
			<p style='text-align: center;margin-bottom: 8px;'>Puedes retirar directo a tu cuenta bancaria.</p>
			<button class="btn" style="margin-top: 8px; background: #07663a;" id="aceptar-ir-transferencia" onclick="irTransferencia()">IR A TRANSFERENCIA BANCARIA</button>
			<br>
			<p style='text-align: center;margin-bottom: 8px;'>o enviando los datos de tu tarjeta d�bito VISA asociado a esa cuenta.</p>
			<button class="btn" style="margin-top: 8px; background: #07663a;" id="aceptar-ir-visa" onclick="irVisa()">IR A VISA</button>
			<br>
			<p style='text-align: center; font-weight: 700;margin-bottom: 8px;'>�A�n deseas retirar en efectivo?</p>
			<button class="btn" id="aceptar-confirmar-retiro-efectivo" style="margin-top: 8px;background: #ffffff; border: 2px solid #07663a; color: #77736f;" onclick="continuarRetiroEfectivo()">Confirmar retiro en efectivo</button>
          </div>
<!--           <button class="btn" id="aceptar-confirmar-retiro-efectivo" onclick="continuarRetiroEfectivo()">Confirmar retiro en efectivo</button> -->
<!--           <button class="btn" style="margin-top: 12px; background: #07663a;" id="aceptar-ir-visa" onclick="irVisa()">Ir a Visa</button> -->
        </div>
      </div>
    </div>
	
	<div class="ioverlay modal-msg" id="modal-msg-error-visa">
      <div class="modal is-error">
        <div class="modal__head" id="title-message-error-visa"></div>
        <div class="modal__boby" >
          <p id="message-error-visa"></p>
          <button class="btn" id="aceptar-message-error-visa" onclick="closeMessageErrorVisa()">Aceptar</button>
        </div>
      </div>
    </div>
    <div class="ioverlay modal-msg" id="modal-msg-error-agora">
      <div class="modal is-error">
        <div class="modal__head" id="title-message-error-agora"></div>
        <div class="modal__boby" >
          <p id="message-error-agora"></p>
          <button class="btn" id="aceptar-message-error-agora" onclick="closeMessageErrorAgora()">Aceptar</button>
        </div>
      </div>
    </div>
	<div class="ioverlay modal-msg" id="modal-msg-error">
      <div class="modal is-error">
        <div class="modal__head" id="title-message-error"></div>
        <div class="modal__boby" >
          <p id="message-error"></p>
          <button class="btn" id="aceptar-message-error" onclick="closeMessageError()">Aceptar</button>
        </div>
      </div>
    </div>
	 <div class="ioverlay modal-msg" id="modal-msg-info">
      <div class="modal is-success">
        <div class="modal__head" id="title-message-info"></div>
        <div class="modal__boby" >
          <p id="message-info"></p>
          <button class="btn btn-message" id="aceptar-message-info" onclick="closeMessageInfo()">Aceptar</button>
        </div>
      </div>
    </div>
    
      <div class="ioverlay" id="modal-success">
        <div class="modal is-success">
          <div class="modal__close iclose"><span class="icon-cerrar"></span></div>
          <div class="modal__head" id="montoSolicitado"></div>
          <div class="modal__boby">
            <p id="message-modal-success"></p>
            <div class="modal__links" style="padding-top: 0px;">
              <div><a class="no-underline" style="color: #e30613;" href="#" id="historialRetiros" toggle-modal="#modal-listado"><span>Historial de retiros</span></a></div>
            </div>
            <hr>
            <div class="modal__links">
              <div><a class="no-underline" href="game_kinelo_show_home.html"><span>Jugar Kinelo</span></a></div>
              <div><a class="no-underline" href="#" onclick="toJuegosVirtuales('virtuales')"><span>Jugar Deportes Virtuales</span></a></div>
            </div>
          </div>
        </div>
      </div>
      
      <div class="ioverlay" id="modal-error">
        <div class="modal is-error">
          <div class="modal__close iclose"><span class="icon-cerrar"></span></div>
          <div class="modal__head" id="title-modal-error">No pudimos procesar tu solicitud</div>
          <div class="modal__boby">
            <p id="mensajeErrorSolicitud"></p>
            <button class="btn" onclick="showModalPremios()">Aceptar</button>
          </div>
        </div>
      </div>

	<div class="ioverlay" id="modal-premios" style="display: block;">
        <div class="modal is-iframe full">
          <div class="ipremio in-iframe">
            <div class="ipremio__head">Retirar premios
              <div class="modal__close iclose"><span class="icon-cerrar"></span></div>
            </div>
            <div class="ipremio__body">
              <ul class="accordion is-main">
                <li class="accordion__item opened is-modal">
                  <div id="bodyPrincipal" class="accordion__body content_loading">
                  
                    <a class="linkbox" style="display: none;" href="#" toggle-modal="#modal-retiro-premio-mayor" id="modal-retiro-premio-mayor"></a>
                    
                    <div id="listaPremiosMayoresLoterias"></div>
                    <div class="title-method">Método de cobro</div>
                    <ul class="accordion is-method listaMetodosRetiro">
                      <li class="accordion__item" id="accordion_visa" style="display: none;">                      
                        <h2 class="accordion__title major-356"><span class="icon-tarjeta"></span>Visa <span class="info" id="rangoMontosVisa"></span></h2>
                        <h2 class="accordion__title minor-356" style="height: 21px !important;"><span class="icon-tarjeta"></span>Visa <span class="info" id="rangoMontosVisa-356"></span></h2>
                        <div class="accordion__body">
                          <div class="inner" style="padding-top: 0px;">
                            <form class="metodo-visa steps" autocomplete="off" id="formvisa">
<!--                               <div class="steps-title">Pasos a seguir:</div> -->
                              <div><p style="font-size: 12px;">Retira entre S/ <span id="minAmountVisa"></span> y S/ <span id="maxAmountVisa"></span> hasta en <span id="maxRequestPerDayVisa"></span> transacciones diarias.<br>Retiro m�ximo semanal S/ <span id="maxAmountPerWeekVisa"></span>.</p></div>
                              <div class="step"><i>1</i>Ingresa el monto a retirar
                                <div class="form-item ispad15" id="divMontoVisa">
                                  <div class="input">
                                    <label>Monto en S/</label>
                                    <input class="is-numeric" type="tel" name="iamount" maxlength="10" id="amountVisa" data-min="0" data-max="0" data-valid="amount">
                                  </div>
                                  <div class="input__error" id="msgErrorRangoMontosVisa"></div>
                                </div>
                              </div>  
                                 
								    <!--  Pedir DNI VSA -->                 
                              <div id="divStepDNI" class="step hidden"><i>2</i>
                                <div class="fileup-image" id="divImgDni">
                                  <span id="stateDniPEN" style="display: none;">Registra tu DNI, por �nica vez, adjuntando el lado que muestra tu foto. (max <span id="pesoImgDni"></span>MB)</span>
                                  <label id="stateDniPENLabel" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
                                    <input class="upimage is-simple" type="file" name="iimage_1" id="imgDNI" accept="image/jpeg, image/png" data-valid="required">
                                    <canvas id="canvasDNI" style="display: none;" ></canvas>
                                  </label>
                                  <span id="stateDniACT" style="display: none; line-height: 16px; margin-bottom: 10px;">
                          			<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
                          			<span style="vertical-align: top;">Tu DNI est� registrado</span>
                               	  </span>
                               	  <span id="stateDniACTLabel" style="display: none;">
                           			<span>�Quieres actualizarlo?</span>
                           			<a id="updateDNI" style="text-decoration: underline; color: #e30613;">
                           				hazlo aqu�
                           			</a>
                               	  </span>      
                                  <div class="filenames empty" id="filenamesDniVisa"><span class="filename-empty">No se adjunt� ninguna imagen</span>
                                    <div class="filename-simple"></div>
                                  </div>
                                </div>
								 
                              </div> 
							  <div class="step"><i id="stepCard">2</i>Selecciona o a�ade tu tarjeta
                                <div class="form_visa" id="divVisa">
                                	<img  class="form_visa_logo" src="layer-view-image/client/icon_visa.png" >
                                	<label class="form_visa_card_button" id="visaCardButton" onclick="showTokenization()" style="padding: 0px 30px;">Seleccionar
                                		<input type="hidden" id="txtTarjetaTokenizada" data-valid="required">			
                                  	</label>
                                	<span class="form_visa_card_mask hidden" id="visaCardText">
                                		<img src="layer-view-image/client/icon-valid.svg" width="16" height="16">
                                		<span id="tarjetaTokenizada"></span>
                                	</span>
                                </div>
                                
                              	<div class="subcontent-comision hidden">
                                	<p class="subcontent-text-comision" id="comision_visanet"><span class="monto-comision-visanet" id="monto_comision_visanet"></span></p>
                                </div>
                              </div>   
							  
                              <div class="step hidden"  id="stepKYCVisa"><i id="stepCardSDKVisa">3</i>Verifica tus datos por �nica vez cada 36 meses, si tus datos son correctos.
                                <div class="form_visa" id="divVisaKYC">
                                	<img  class="form_visa_logo" src="layer-view-image/client/icon_dni.png?v=3" style="margin-left: 5px; margin-top: -10px; margin-right:32px;">
                                	<label class="form_visa_card_button" id="visaSDKCardButton"  style="padding: 0px 12px !important; font-size: 10px !important;" onclick="showSDK()">VERIFICA TU IDENTIDAD
                                		<input type="hidden" id="txtVisaSDKVerificado" data-valid="required">			
                                  	</label>
                                  	
                                	<span class="form_visa_card_mask hidden" id="visaSDKCardText">
                                		<img id="iconKyc" src="layer-view-image/client/icon-valid.svg" width="16" height="16">
                                		<span class="span_mensaje_verificado" id="visaSDKVerificado"></span>
                                		<span id="visaSDKBtn" style="cursor: pointer;" class="verificarKYC"><u>Clic aqu� para actualizar</u></span>
                                	</span>
<!--                                 	<button type="button" id="consultResultKyc1" class = "btn-verificar" >Verificar</button> -->
                                </div>
                                <div style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">Deber�s permitir el acceso a tu c�mara para realizar la verificaci�n.</div>
                                
                              </div>
                              
                              <div class="step" style="margin-top: 5px;font-size: 14px;">Una vez confirmado tu retiro se har� el abono a tu tarjeta en menos de 30 minutos. Si tienes tarjeta de cr�dito, esto puede tomar 2 d�as adicionales.</div>
                              
                              <button class="btn btn-solicitar">Solicitar Retiro</button>
                            </form>
                          </div>
                        </div>
                      </li>
                                            
                      <li class="accordion__item" id="accordion_agora" style="display: none;">                      
                        <h2 class="accordion__title"><span class="icon-tarjeta"></span>Agora <span class="info" id="rangoMontosAgora"></span></h2>
                        <div class="accordion__body">
                          <div class="inner">
                            <form class="metodo-visa steps" autocomplete="off" id="formagora">
<!--                               <div class="steps-title">Pasos a seguir:</div> -->
                              
                              <div class="step"><i>1</i>Ingresa el monto a retirar
                                <div class="form-item ispad15" id="divMontoAgora">
                                  <div class="input">
                                    <label>Monto en S/</label>
                                    <input class="is-numeric" type="tel" name="iamount" maxlength="10" id="amountAgora" data-min="0" data-max="0" data-valid="amount">
                                  </div>
                                  <div class="input__error" id="msgErrorRangoMontosAgora"></div>
                                </div>
                              </div>  
                              <!--                        
                              <div id="divStepDNIAgora" class="step hidden"><i>2</i>
                                <div class="fileup-image" id="divImgDniAgora">
                                  <span id="stateDniPENAgora" style="display: none;">Registra tu DNI, por �nica vez, adjuntando el lado que muestra tu foto. (max <span id="pesoImgDniAgora"></span>MB)</span>
                                  <label id="stateDniPENLabelAgora" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
                                    <input class="upimage is-simple" type="file" name="iimage_1" id="imgDNIAgora" accept="image/jpeg, image/png" data-valid="required">
                                    <canvas id="canvasDNIAgora" style="display: none;" ></canvas>
                                  </label>
                                  <span id="stateDniACTAgora" style="display: none; line-height: 16px; margin-bottom: 10px;">
                          			<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
                          			<span style="vertical-align: top;">Tu DNI est� registrado</span>
                               	  </span>
                               	  <span id="stateDniACTLabelAgora" style="display: none;">
                           			<span>�Quieres actualizarlo?</span>
                           			<a id="updateDNIAgora" style="text-decoration: underline; color: #e30613;">
                           				hazlo aqu�
                           			</a>
                               	  </span>      
                                  <div class="filenames empty" id="filenamesDniAgora"><span class="filename-empty">No se adjunt� ninguna imagen</span>
                                    <div class="filename-simple"></div>
                                  </div>
                                </div>
                              </div> -->  
							  <div class="step"><i id="stepCardAgora">2</i>Selecciona o a�ade tu tarjeta
                                <div class="form_visa" id="divAgora">
                                	<img  class="form_visa_agora" src="layer-view-image/client/logo-agora1.png" >
                                	<label class="form_visa_card_button" id="visaCardButtonAgora" onclick="showTokenizationAgora()">Seleccionar
                                		<input type="hidden" id="txtTarjetaTokenizadaAgora" data-valid="required">			
                                  	</label>
                                	<span class="form_visa_card_mask hidden" id="visaCardTextAgora">
                                		<img src="layer-view-image/client/icon-valid.svg" width="16" height="16">
                                		<span id="tarjetaTokenizadaAgora"></span>
                                	</span>
                                </div>
                                <!--  
                                <div style="margin-top: 10px;">Una vez confirmado tu retiro se har� el abono a tu tarjeta en menos de 30 minutos.</div>
                                -->
                                <div class="subcontent-comision hidden">
                                	<p class="subcontent-text-comision" id="comision_agora"><span class="monto-comision-agora" id="monto_comision_agora"></span></p>
                                </div>
                              </div>  
                              <div class="step"><i id="stepCardSDKAgora">3</i>
								<div class="form_visa" id="divAgoraKYC">
                                	<img  class="form_visa_logo" src="layer-view-image/client/icon_dni.png?v=3" style="margin-left: 5px; margin-top: -10px; margin-right: 32px;">
                                	<label class="form_visa_card_button" id="agoraSDKCardButton" style="padding: 0px 12px !important; font-size: 10px !important;" onclick="showSDK()">VERIFICA TU IDENTIDAD
                                		<input type="hidden" id="txtAgoraSDKVerificado" data-valid="required">			
                                  	</label>
                                  	
                                	<span class="form_visa_card_mask hidden" id="agoraSDKCardText">
                                		<img src="layer-view-image/client/icon-valid.svg" width="16" height="16">
                                		<span id="agoraSDKVerificado"></span>
                                	</span>
                                </div>
                                <div style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">Deber�s permitir el acceso a tu c�mara para realizar la verificaci�n.</div>
                                <div style="margin-top: 5px;">Una vez confirmado tu retiro se har� el abono a tu tarjeta en menos de 30 minutos.</div>
                              </div>
                               
                              <button class="btn btn-solicitar">Solicitar Retiro</button>
                            </form>
                          </div>
                        </div>
                      </li>
                      
                      <li class="accordion__item" id="accordion_transferencia" style="display: none;">
                      	<h2 class="accordion__title"><span class="icon-transferencia"></span>Transferencia <br>Bancaria <span class="info" id="rangoMontosTransferencia"></span></h2>                     	
                      	<div class="accordion__body">
                      		<div class="inner" style="padding-top: 3px; padding-right: 0px; padding-left: 0px; width: 101%;">
                      			<div id="divTransRangos" style="margin-top: 0px;">

								</div>
                      			<form class="metodo-transferencia steps" autocomplete="off" id="formtransferencia" style="padding-right: 6.66667%; padding-left: 6.66667%;">
                      				<div class="step"><i style="top: 8px;">1</i>
									  <div class="form-item ispad15" style="padding-top: 0px;" id="divMontoTransferencia">
										<div class="input">
										  <label>Ingresa monto en S/</label>
										  <input class="is-numeric" type="tel" name="iamount" maxlength="10" id="amountTransferencia"  data-min="0" data-max="0" data-valid="amount"/>
										</div>
										<div class="input__error" id="msgErrorRangoMontosTransferencia"></div>
									  </div>
									</div>
									
									<div class="step hidden" id="stepRecurrentesTransferencia"><i>2</i>Selecciona tu cuenta de ahorros
									  <div id="listaCuentaAhorros" class="group-radio">
									    

									  </div>
									  <div class="addcard" onclick="desactivarPantallaRecurrenteTransferencia()" style="color:#e30613;font-family: Roboto, sans-serif;font-size: 12px; font-weight: 400;">Usa otra cuenta de ahorros</div>
									</div>
									
									<div class="step" id="stepBancoTransferencia"><i style="top: 8px;">2</i>
									  <div class="form-item ispad15" style="padding-top: 0px;" id="divBanco" >
										<div class="select">
										  <div class="opt-control"></div>
										  <select class="bybank" name="ibanco" id="ibanco" data-valid="required">
<!-- 											<option value="">Selecciona un banco</option> -->
<!-- 											<option value="1">Interbank</option> -->
<!-- 											<option value="2">BCP. Banco de Cr�dito del Per�</option> -->
<!-- 											<option value="3">BBVA. Banco Continental</option> -->
<!-- 											<option value="4">Scotiabank</option> -->
<!-- 											<option value="5">Otro banco - usa tu CCI (c�digo interbancario)</option> -->
										  </select>
										</div>
									  </div>
									</div>
									
									<div class="step" id="stepCuentaTransferencia"><i style="top: 8px;">3</i>
									  <div class="form-item ispad15" style="padding-top: 0px;" id="divCuenta">
										<div class="input">
										  <label>Ingresa tu n�mero de cuenta</label>
										  <input class="is-numeric" type="tel" name="inumacount" id="inumacount" maxlength="20" data-min="20" data-max="20" data-valid="account"/>
										</div>
										<div class="input__error">INGRESA UN N�MERO DE CUENTA CORRECTO</div>
									  </div>
									</div>									
									
									<!-- Pedir DNI Transferencia -->
									<div id="divStepDNITransferencia" class="step hidden"><i id="stepDniTransferencia">4</i>
		                                <div class="fileup-image" id="divImgDniTransferencia">
		                                  <span id="stateDniPENTransferencia" style="display: none;">Adjunta, por �nica vez, la foto de tu DNI por el lado que muestra tu rostro (max <span id="pesoImgDniTransferencia"></span>MB)</span>
		                                  <label id="stateDniPENLabelTransferencia" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
		                                    <input class="upimage is-simple" type="file" name="iimage_1" id="imgDNITransferencia" accept="image/jpeg, image/png" data-valid="required">
		                                    <canvas id="canvasDNITransferencia" style="display: none;" ></canvas>
		                                  </label>
		                                  <span id="stateDniACTTransferencia" style="display: none; line-height: 16px; margin-bottom: 10px;">
		                          			<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
		                          			<span style="vertical-align: top;">La foto de tu DNI ya esta registrado</span>
		                               	  </span>
		                               	  <span id="stateDniACTLabelTransferencia" style="display: none;">
		                           			<span>�Quieres actualizarlo?</span>
		                           			<a id="updateDNITransferencia" style="text-decoration: underline; color: #e30613;">
		                           				hazlo aqu�
		                           			</a>
		                               	  </span>      
		                                  <div class="filenames empty" id="filenamesDniTransferencia"><span class="filename-empty">No se adjunt� ninguna imagen</span>
		                                    <div class="filename-simple"></div>
		                                  </div>
		                                </div>
		                                
	                                </div> 
									
									<div id="divStepDeparmentTransferencia" class="step"><i id="stepDeparmentTransferencia">4</i>Selecciona el departamento donde abriste tu cuenta
									  <div class="form-item ispad15" id="divDepartamento">
										<div class="select">
										  <div class="opt-control"></div>
										  <select name="ideparment" id="ideparment" data-valid="required" onchange="if(enviarDataLayer) datalayerCobrarPremioMetodoCobroSelect(this,'Seleccionar departamento')">
											<option value="">Selecciona un departamento</option>
											<option value="1">Amazonas</option>
											<option value="2">�ncash</option>
											<option value="3">Apur�mac</option>
											<option value="4">Arequipa</option>
											<option value="5">Ayacucho</option>
											<option value="6">Cajamarca</option>
											<option value="7">Callao</option>
											<option value="8">Cuzco</option>
											<option value="9">Huancavelica</option>
											<option value="10">Hu�nuco</option>
											<option value="11">Ica</option>
											<option value="12">Jun�n</option>
											<option value="13">La Libertad</option>
											<option value="14">Lambayeque</option>
											<option value="15">Lima</option>
											<option value="16">Loreto</option>
											<option value="17">Madre de Dios</option>
											<option value="18">Moquegua</option>
											<option value="19">Pasco</option>
											<option value="20">Piura</option>
											<option value="21">Puno</option>
											<option value="22">San Mart�n</option>
											<option value="23">Tacna</option>
											<option value="24">Tumbes</option>
											<option value="25">Ucayali</option>
										  </select>
										</div>
									  </div>
									  <!--  <div style="margin-top: 10px; font-weight: 700; font-size: 10px; text-align: justify;">Aseg�rate de ser el titular de la cuenta y que los datos de tu cuenta de La Tinka sean iguales a los de tu cuenta bancaria. Caso contrario, tu retiro ser� rechazado.</div> -->
<!-- 									  <div style="margin-top: 10px; text-align: justify;">Una vez confirmado tu retiro, �ste ser� transferido a tu cuenta dentro de los siguientes 60 minutos, siempre que se confirme de lunes a viernes de 9:00 am a 7:00 pm y s�bados de 9:00 am a 2:00 pm.</div> -->
									</div>
									
									<div class="step hidden" id="stepKYCTrans"><i id="stepCardSDKTransferencia">5</i>Verifica tus datos por �nica vez cada 36 meses, si tus datos son correctos.
										<div class="form_visa" id="divTransferenciaKYC">
		                                	<img  class="form_visa_logo" src="layer-view-image/client/icon_dni.png?v=3" style="margin-left: 5px; margin-top: -10px; margin-right: 32px;">
		                                	<label class="form_visa_card_button" id="transferenciaSDKCardButton" style="padding: 0px 12px !important; font-size: 10px !important;" onclick="showSDK()">VERIFICA TU IDENTIDAD
		                                		<input type="hidden" id="txtTransferenciaSDKVerificado" data-valid="required">			
		                                  	</label>
		                                  	
		                                	<span class="form_visa_card_mask hidden" id="sdkTransferenciaCardText">
		                                		<img id="iconKycT" src="layer-view-image/client/icon-valid.svg" width="16" height="16">
		                                		<span class="span_mensaje_verificado"  id="transferenciaSDKVerificado"></span>
		                                		<span id="transferenciaSDKBtn" style="cursor: pointer;" class="verificarKYC"><u>Clic aqu� para actualizar</u></span>
		                                	</span>
<!-- 		                                	<button type="button" id="consultResultKyc3" class = "btn-verificar" >Verificar</button> -->
		                                </div>
		                                <div style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">Deber�s permitir el acceso a tu c�mara para realizar la verificaci�n.</div>
		                                
		                              </div>
		                              
		                              <div class="step" style="margin-top: 5px; font-size: 10px; font-weight: 700; ">Aseg�rate de ser el titular de la cuenta y que los datos de tu cuenta de La Tinka sean iguales a los de tu cuenta bancaria. Caso contrario, tu retiro ser� rechazado.</div>
									<button class="btn btn-solicitar">Solicitar Retiro</button>
                      			</form>
                      		</div>
                      	</div>
                      </li>
                      
                      <li class="accordion__item" id="accordion_efectivo" style="display: none;">
                        <h2 class="accordion__title major-356" ><span class="icon-efectivo"></span>Efectivo / Punto de venta <span class="info" id="rangoMontosEfectivo"></span></h2>
                        <h2 class="accordion__title minor-356" style="height: 21px !important;"><span class="icon-efectivo"></span>Efectivo / <br>Punto de venta <span class="info" id="rangoMontosEfectivo-356"></span></h2>                       
                        <div class="accordion__body">
                          <div class="inner">
                            <form class="metodo-efectivo steps" autocomplete="off" id="formefectivo">
                              <div id="step" class="step"><i  id="stepUnoEfectivo">1</i>
	                              <div class="form-item" id="divMontoEfectivo">
	                                <div class="input__title">Ingresa el monto que deseas retirar</div>
	                                <div class="input">
	                                  <label>Monto en S/</label>
	                                  <input class="is-numeric" type="tel" name="iamount" maxlength="10" id="amountEfectivo"  data-min="0" data-max="0" data-valid="amount">
	                                </div>
	                                <div class="input__error" id="msgErrorRangoMontosEfectivo"></div>
	                              </div>
                              </div>
                              
							  <!-- Pedir DNI Efectivo -->  
                              <div id="divStepDNIEfectivo" class="step hidden"><i>2</i>                          
                                <div class="fileup-image" id="divImgDniEfectivo">
                                  <span id="stateDniPENEfectivo" style="display: none;">Registra tu DNI, por �nica vez, adjuntando el lado que muestra tu foto. (max <span id="pesoImgDniEfectivo"></span>MB)</span>
                                  <label id="stateDniPENLabelEfectivo" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
                                    <input class="upimage is-simple" type="file" name="iimage_1" id="imgDNIEfectivo" accept="image/jpeg, image/png" data-valid="required">
                                    <canvas id="canvasDNIEfectivo" style="display: none;" ></canvas>
                                  </label>
                                  <span id="stateDniACTEfectivo" style="display: none; line-height: 16px; margin-bottom: 10px;">
                          			<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
                          			<span style="vertical-align: top;">Tu DNI est� registrado</span>
                               	  </span>
                               	  <span id="stateDniACTLabelEfectivo" style="display: none;">
                           			<span>�Quieres actualizarlo?</span>
                           			<a id="updateDNIEfectivo" style="text-decoration: underline; color: #e30613;">
                           				hazlo aqu�
                           			</a>
                               	  </span>      
                                  <div class="filenames empty" id="filenamesDniEfectivo"><span class="filename-empty">No se adjunt� ninguna imagen</span>
                                    <div class="filename-simple"></div>
                                  </div>
                                </div>
							  
                              </div> 

                              <div class="step hidden" id="stepKYCEfectivo"><i id="stepCardSDKVisa">2</i>Verifica tus datos por �nica vez cada 36 meses, si tus datos son correctos.
									<div class="form_visa" id="divEfectivoKYC">
	                                	<img  class="form_visa_logo" src="layer-view-image/client/icon_dni.png?v=3" style="margin-left: 5px; margin-top: -10px; margin-right: 32px;">
	                                	<label class="form_visa_card_button" id="efectivoSDKCardButton" style="padding: 0px 12px !important; font-size: 10px !important;" onclick="showSDK()">VERIFICA TU IDENTIDAD
	                                		<input type="hidden" id="txtEfectivoSDKVerificado" data-valid="required">			
	                                  	</label>
	                                  	
	                                	<span class="form_visa_card_mask hidden" id="sdkEfectivoCardText">
	                                		<img id="iconKycE" src="layer-view-image/client/icon-valid.svg" width="16" height="16">
	                                		<span class="span_mensaje_verificado" id="efectivoSDKVerificado"></span>
	                                		<span id="efectivoSDKBtn" style="cursor: pointer;" class="verificarKYC"><u>Clic aqu� para actualizar</u></span>
	                                	</span>
<!-- 	                                	<button type="button" id="consultResultKyc4" class = "btn-verificar" >Verificar</button> -->
	                                </div>
	                                <div style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">Deber�s permitir el acceso a tu c�mara para realizar la verificaci�n.</div>
	                                
	                           </div>
	                           <div class="step" style="margin-top: 5px; font-size: 11px; ">Podr�s cobrar tu retiro �nicamente en efectivo, en nuestros Puntos de Venta</div>
	                           
                              <button class="btn btn-solicitar">Solicitar Retiro</button>
                            </form>
                          </div>
                        </div>
                      </li>
                    </ul>
                    <div class="footlinks">
                      <div>Historial</div><a class="linkbox" href="#" toggle-modal="#modal-listado" style="margin-left: 0px;">Retiros</a>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>      
      
    <div class="ioverlay" id="modal-pm">
    	<div class="modal is-iframe full">
          <div class="ipremio in-iframe">
            <div class="ipremio__head">Retirar premios
              <div class="modal__close iclose"><span class="icon-cerrar"></span></div>
            </div>
            <div class="ipremio__body">
              <ul class="accordion record">
                <li class="accordion__item opened is-modal" style="margin-bottom: 0px;">
                  <div class="accordion__body">
                    <div class="inner">
                      <div class="back"><a href="#" toggle-modal="#modal-premios">Volver</a></div>
                      <div class="record__content" style="border: 1px solid #E2E2E2; margin-top: 18px; padding-top: 0px;">               	
                      	<div>
                      		<div class="inner" style="padding-top: 7px; padding-right: 0px; padding-left: 0px; width: 101%;">	
                      			<table style="width: 100%;">
                   					<tbody>
                   						<tr>
                   							<td style="vertical-align: text-top; width: 30%;">
                   								<div style="margin-top: -12px;" id="logoProductoPPML"></div>
                   							</td>
                   							<td style="text-align: right; width: 70%;">
	                   							<span style="padding-right: 6.66667%; font-family: Avenir; font-weight: 900; font-size: 18px;" id="monto_base"></span><br>
	                   							<span style="font-size: 14px; float: left;">Impuesto (10%): S/ </span><span style="padding-right: 6.66667%; font-size: 14px;" id="impuesto"></span><br>
	                   							<span style="font-size: 14px; font-weight: 700; float: left;">Monto a cobrar: S/ </span><span style="padding-right: 6.66667%; font-size: 14px; font-weight: 700;" id="neto"></span>
	                   							<span style="font-size: 14px; font-weight: 700; float: left;" id="txtJugadasGratis">Jugadas gratis:</span><span style="padding-right: 6.66667%; font-size: 14px; font-weight: 700;" id="lblJugadasGratis"></span>
                   							</td>
                   						</tr>
                   					</tbody>
                   				</table>
                      			<div style="background-color: #c0e4d6;float: left;width: 99%;font-family: Roboto, sans-serif;font-size: 11.5px;text-align: justify;color: #006841;"><p style="padding-right: 6.66667%;padding-left: 6.66667%;" id="lblConsideraciones">Por tu seguridad, un representante de La Tinka se contactar� contigo para coordinar tu pago que se realizar� en un plazo m�ximo de 30 d�as</p></div>  		
                      			<form class="metodo-transferencia steps" autocomplete="off" id="formtransferenciapml" style="padding-right: 6.66667%; padding-left: 6.66667%; margin-top: 75px;">
                      				
<!--                       				<div style="display: inline; vertical-align: middle;"> -->
<!--                       					<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24" style="margin-left: -20px; height: 50px;"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><path class="ico-line" style="fill: #07663a;" d="M16,19.45a.35.35,0,0,1-.25-.1l-.71-.71-.7.7a.36.36,0,0,1-.49,0l-.7-.7-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.77-.77a.51.51,0,0,1-.15-.37V6.07a.51.51,0,0,1,.15-.37l.76-.76a.36.36,0,0,1,.49,0l.65.65.65-.65a.36.36,0,0,1,.49,0l.65.65L12,4.94a.36.36,0,0,1,.49,0l.65.65.7-.7a.36.36,0,0,1,.49,0l.7.7.71-.71A.34.34,0,0,1,16,4.79a.35.35,0,0,1,.24.09l.82.82a.51.51,0,0,1,.15.37v12.1a.51.51,0,0,1-.15.37l-.82.82A.35.35,0,0,1,16,19.45Zm-1-1.41a.35.35,0,0,1,.24.1l.46.46a.36.36,0,0,0,.5,0l.44-.44V6.07l-.44-.44a.36.36,0,0,0-.5,0l-.46.46a.36.36,0,0,1-.49,0l-.45-.45a.36.36,0,0,0-.25-.1.35.35,0,0,0-.25.1l-.45.45a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.38.38V18.16l.38.38a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.45.45a.36.36,0,0,0,.5,0l.45-.45A.34.34,0,0,1,15.07,18Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,8.62a.26.26,0,1,1,0-.53h2.7a.26.26,0,0,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,11.16a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,13.7a.26.26,0,1,1,0-.53H13.4a.26.26,0,1,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,16.24a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"></path></g></g></svg> -->
<!--                       					<p style="vertical-align: top; display: inline; font-size: 12px; margin-left: -15px;" id="ticketId"></p> -->
<!--                       					<p style="font-size: 12px; text-align: right;vertical-align: top; display: inline; float: right; margin-top: 20px; color: #ff2123; font-weight: 600;" id="fechaExpiracion"></p> -->
<!--                       				</div> -->
                      					
                      				<table>
                      					<tr>
                      						<td style="width: 5%;" onclick="verTicket()">
                      							<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24.24 24.24" style="margin-left: -20px; height: 50px;"><g id="Capa_2" data-name="Capa 2"><g id="Capa_2-2" data-name="Capa 2"><path class="ico-line" style="fill: #07663a;" d="M16,19.45a.35.35,0,0,1-.25-.1l-.71-.71-.7.7a.36.36,0,0,1-.49,0l-.7-.7-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.65-.65-.65.65a.36.36,0,0,1-.49,0l-.77-.77a.51.51,0,0,1-.15-.37V6.07a.51.51,0,0,1,.15-.37l.76-.76a.36.36,0,0,1,.49,0l.65.65.65-.65a.36.36,0,0,1,.49,0l.65.65L12,4.94a.36.36,0,0,1,.49,0l.65.65.7-.7a.36.36,0,0,1,.49,0l.7.7.71-.71A.34.34,0,0,1,16,4.79a.35.35,0,0,1,.24.09l.82.82a.51.51,0,0,1,.15.37v12.1a.51.51,0,0,1-.15.37l-.82.82A.35.35,0,0,1,16,19.45Zm-1-1.41a.35.35,0,0,1,.24.1l.46.46a.36.36,0,0,0,.5,0l.44-.44V6.07l-.44-.44a.36.36,0,0,0-.5,0l-.46.46a.36.36,0,0,1-.49,0l-.45-.45a.36.36,0,0,0-.25-.1.35.35,0,0,0-.25.1l-.45.45a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.4.4a.36.36,0,0,1-.49,0l-.4-.4a.36.36,0,0,0-.5,0l-.38.38V18.16l.38.38a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.4.4a.36.36,0,0,0,.5,0l.4-.4a.36.36,0,0,1,.49,0l.45.45a.36.36,0,0,0,.5,0l.45-.45A.34.34,0,0,1,15.07,18Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,8.62a.26.26,0,1,1,0-.53h2.7a.26.26,0,0,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,11.16a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,13.7a.26.26,0,1,1,0-.53H13.4a.26.26,0,1,1,0,.53Z"></path><path class="ico-line" style="fill: #07663a;" d="M9.68,16.24a.26.26,0,1,1,0-.53h5.24a.26.26,0,1,1,0,.53Z"></path></g></g></svg>
                      						</td>
                      						<td><span id="ticketId" onclick="verTicket()" style="font-size: 12px; margin-left: -10px;"></span></td>
                      						<td><span id="fechaExpiracion" style="font-size: 12px; float: right; color: #ff2123; font-weight: 600;"></span></td>
                      					</tr>
                      				</table>								
									<div class="step hidden" id="stepRecurrentesTransferenciaPML"><i>1</i>Selecciona tu cuenta de ahorros
									  <div id="listaCuentaAhorrosPML" class="group-radio">
									  </div>
									  <div class="addcard" onclick="desactivarPantallaRecurrenteTransferenciaPML()" style="color:#e30613;font-family: Roboto, sans-serif;font-size: 12px; font-weight: 400;">Usa otra cuenta de ahorros</div>
									</div>
									
									<div class="step" id="stepBancoTransferenciaPML"><i style="top: 8px;">1</i>
									  <div class="form-item ispad15" style="padding-top: 0px;" id="divBancoPML" >
										<div class="select">
										  <div class="opt-control"></div>
										  <select class="bybank" name="ibancoPML" id="ibancoPML" data-valid="required">
										  </select>
										</div>
									  </div>
									</div>
									
									<div class="step" id="stepCuentaTransferenciaPML"><i style="top: 8px;">2</i>
									  <div class="form-item ispad15" style="padding-top: 0px;" id="divCuentaPML">
										<div class="input">
										  <label>Ingresa tu n�mero de cuenta</label>
										  <input class="is-numeric" type="tel" name="inumacountPML" id="inumacountPML" maxlength="20" data-min="20" data-max="20" data-valid="account"/>
										</div>
										<div class="input__error">INGRESA UN N�MERO DE CUENTA CORRECTO</div>
									  </div>
									</div>									
									
									<!-- Pedir DNI Premio Mayor -->
									<div id="divStepDNITransferenciaPML" class="step hidden"><i id="stepDniTransferenciaPML">3</i>
		                                <div class="fileup-image" id="divImgDniTransferenciaPML">
		                                  <span id="stateDniPENTransferenciaPML" style="display: none;">Adjunta, por �nica vez, la foto de tu DNI por el lado que muestra tu rostro (max <span id="pesoImgDniTransferenciaPML"></span>MB)</span>
		                                  <label id="stateDniPENLabelTransferenciaPML" class="btn is-secondary img-simple" style="margin-top: 16px; display: none;"><span class="text">Subir imagen</span>
		                                    <input class="upimage is-simple" type="file" name="iimage_1" id="imgDNITransferenciaPML" accept="image/jpeg, image/png" data-valid="required">
		                                    <canvas id="canvasDNITransferenciaPML" style="display: none;" ></canvas>
		                                  </label>
		                                  <span id="stateDniACTTransferenciaPML" style="display: none; line-height: 16px; margin-bottom: 10px;">
		                          			<img src="layer-view-image/client/icon-valid.svg" width="20" height="20">
		                          			<span style="vertical-align: top;">La foto de tu DNI ya esta registrado</span>
		                               	  </span>
		                               	  <span id="stateDniACTLabelTransferenciaPML" style="display: none;">
		                           			<span>�Quieres actualizarlo?</span>
		                           			<a id="updateDNITransferenciaPML" style="text-decoration: underline; color: #e30613;">
		                           				hazlo aqu�
		                           			</a>
		                               	  </span>      
		                                  <div class="filenames empty" id="filenamesDniTransferenciaPML"><span class="filename-empty">No se adjunt� ninguna imagen</span>
		                                    <div class="filename-simple"></div>
		                                  </div>
		                                </div>
		                                
	                                </div>
	                                 
	                                 <div id="divStepSDKPML"  class="step hidden"><i id="stepSDKPML">3</i>Verifica tus datos por �nica vez cada 36 meses, si tus datos son correctos.
										<div class="form_visa" id="divPMKYC">
		                                	<img  class="form_visa_logo" src="layer-view-image/client/icon_dni.png?v=3" style="margin-left: 5px; margin-top: -10px; margin-right: 38px;">
		                                	<label class="form_visa_card_button" id="PMSDKCardButton" onclick="showSDK()">VERIFICA TU IDENTIDAD 
		                                		<input type="hidden" id="txtPMSDKVerificado" data-valid="required">			
		                                  	</label>
		                                  	
		                                	<span class="form_visa_card_mask hidden" id="sdkPMCardText">
		                                		<img id="iconKycPM" src="layer-view-image/client/icon-valid.svg" width="16" height="16">
		                                		<span class="span_mensaje_verificado" id="PMSDKVerificado"></span>
		                                		<span id="PMSDKBtn" style="cursor: pointer;" class="verificarKYC"><u>Clic aqu� para actualizar</u></span>
		                                	</span>
<!-- 		                                	<button type="button" id="consultResultKyc3" class = "btn-verificar" >Verificar</button> -->
		                                </div>
		                                <div style="margin-top: 10px; font-size: 10px; font-weight: 700; text-align: justify;">Deber�s permitir el acceso a tu c�mara para realizar la verificaci�n.</div>
		                                
		                              </div>
									
									<div id="divStepDeparmentTransferenciaPML" class="step"><i id="stepDeparmentTransferenciaPML">4</i>Selecciona el departamento donde abriste tu cuenta
									  <div class="form-item ispad15" id="divDepartamentoPML">
										<div class="select">
										  <div class="opt-control"></div>
										  <select name="ideparmentPML" id="ideparmentPML" data-valid="required">
											<option value="">Selecciona un departamento</option>
											<option value="1">Amazonas</option>
											<option value="2">�ncash</option>
											<option value="3">Apur�mac</option>
											<option value="4">Arequipa</option>
											<option value="5">Ayacucho</option>
											<option value="6">Cajamarca</option>
											<option value="7">Callao</option>
											<option value="8">Cuzco</option>
											<option value="9">Huancavelica</option>
											<option value="10">Hu�nuco</option>
											<option value="11">Ica</option>
											<option value="12">Jun�n</option>
											<option value="13">La Libertad</option>
											<option value="14">Lambayeque</option>
											<option value="15">Lima</option>
											<option value="16">Loreto</option>
											<option value="17">Madre de Dios</option>
											<option value="18">Moquegua</option>
											<option value="19">Pasco</option>
											<option value="20">Piura</option>
											<option value="21">Puno</option>
											<option value="22">San Mart�n</option>
											<option value="23">Tacna</option>
											<option value="24">Tumbes</option>
											<option value="25">Ucayali</option>
										  </select>
										</div>
									  </div>
									  
									  </div>
									
									  <div class="step" style="margin-top: 5px; font-size: 10px; font-weight: 700; ">Aseg�rate de ser el titular de la cuenta y que los datos de tu cuenta de La Tinka sean iguales a los de tu cuenta bancaria. Caso contrario, tu retiro ser� rechazado.</div>
									
									<button class="btn btn-solicitar">Solicitar</button>
                      			</form>
                      		</div>
                      	</div>                   
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
    </div>  
    
	<div class="ioverlay" id="modal-historial-sin-retiro">
        <div class="modal is-iframe full">
          <div class="ipremio in-iframe">
            <div class="ipremio__head">Retirar premios
              <div class="modal__close iclose"><span class="icon-cerrar"></span></div>
            </div>
            <div class="ipremio__body">
              <ul class="accordion record">
                <li class="accordion__item opened is-modal">
                  <div class="accordion__body">
                    <div class="inner">
                      <div class="record__head">Historial de retiros</div>
                      <div class="back"><a href="#" toggle-modal="#modal-premios">Volver a Retirar premios</a></div>
                      <div class="record__content nofound">
                        <div class="nofound__title">A�n no has hecho <br>ning�n retiro</div><img class="nofound__img" src="layer-view-image/client/no-retiros.svg" alt="Sin retiros">
                        <div class="nofound__alert">�Sigue jugando!</div>
                        <div class="nofound__links"><a class="no-underline" href="game_kinelo_show_home.html"><span>Jugar Kinelo</span></a><a class="no-underline" href="#" onclick="toJuegosVirtuales('virtuales')"><span>Jugar Deportes Virtuales</span></a></div>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      
    
    <div id="popup" class="overlay" style="z-index: 211;">
		<div class="popup popup-sm">									
				<a class="close js-close-modal" href="#">&times;</a>									
			<div class="main-modal"></div>
		</div>
	</div>

	<div class="ioverlay" id="modal-listado">
        <div class="modal is-iframe full">
          <div class="ipremio in-iframe">
            <div class="ipremio__head">Retirar premios
              <div class="modal__close iclose"><span class="icon-cerrar"></span></div>
            </div>
            <div class="ipremio__body">
              <ul class="accordion record">
                <li class="accordion__item opened is-modal">
                  <div class="accordion__body">
                    <div class="inner">
                      <div class="record__head">Historial de retiros</div>
                      <div class="back"><a href="#" toggle-modal="#modal-premios">Volver a Retirar premios</a></div>
                      <div class="record__content">
                        <div class="filter">
                          <div class="filter__title">Filtrar</div>
                          <div class="filter__content">
                            <form method="post" novalidate data-form-ajax>
                              <div class="filter__clear">Borrar filtros</div>
                              <div class="filter__mod">
                                <div class="filter__subtitle">Por fecha</div>
                                <div class="form-item">
                                  <div class="select">
                                    <label>Por fecha</label>
                                    <div class="opt-control"></div>
                                    <select class="bydate" name="name" id="typeFilterHisPayment">
                                      <option value="1">Ver todos</option>
                                      <option value="2">La �ltima semana</option>
                                      <option value="3">El �ltimo mes</option>
                                      <option value="4">Rango espec�fico</option>
                                    </select>
                                  </div>
                                </div>
                              </div>
                              <div class="forrange">
                                <div class="form-item">
                                  <div class="input is-calendar">
                                    <label>Desde</label>
                                    <input type="text" id="startdate" name="startdate" autocomplete="off" maxlength="10">
                                  </div>
                                </div>
                                <div class="form-item">
                                  <div class="input is-calendar">
                                    <label>Hasta</label>
                                    <input type="text" id="enddate" name="enddate" autocomplete="off" maxlength="10">
                                  </div>
                                </div>
                              </div>
                              <button class="btn">Aplicar</button>
                            </form>
                          </div>
                        </div>
                        <div class="items" id="items-hispayment" data-show-items="4">

                        </div>
                        <div class="pagination" id="pagination-items-hispayment">
                          <div class="pages"></div><a class="prev is-disabled" href=""><i class="icon-regresar"></i></a><a class="next" href=""><i class="icon-siguiente"></i></a>
                        </div>
                      </div>
                    </div>
                  </div>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
      
      <div class="ioverlay" id="modal-ticket2">
        <div class="modal is-ticket">
          <div class="modal__close iclose"><span class="icon-cerrar"></span></div>
          <div class="modal__head">
            <ul>
<!--               <li><strong>Cod. de Retiro: </strong><span id="tkRequestNumber"></span></li> -->
<!--               <li><strong>Fecha y hora: </strong><span id="tkRequestDateHour"></span></li> -->
<!--               <li><strong>ID: </strong><span id="idCliente"></span></li> -->
<!--               <li><strong>DNI: </strong><span id="tkDocNumber"></span></li> -->
<!--               <li><strong>Ganador: </strong><span id="ganador"></span></li> -->
			  <li>
			  	<table style="margin-left: -6px;">
   					<tbody>
   						<tr valign="top">
   							<td rowspan="2"><strong>Cod. de Retiro: </strong></td>
   							<td><span id="tkRequestNumber"></span></td>
   						</tr>
   					</tbody>
   				</table>
			  </li>
              <li>
              	<table style="margin-left: -6px;">
   					<tbody>
   						<tr valign="top">
   							<td rowspan="2"><strong>Fecha y hora: </strong></td>
   							<td><span id="tkRequestDateHour"></span></td>
   						</tr>
   					</tbody>
   				</table>
              </li>
              <li>
              	<table style="margin-left: -6px;">
   					<tbody>
   						<tr valign="top">
   							<td rowspan="2"><strong>ID: </strong></td>
   							<td><span id="idCliente"></span></td>
   						</tr>
   					</tbody>
   				</table>
              </li>
              <li>
              	<table style="margin-left: -6px;">
   					<tbody>
   						<tr valign="top">
   							<td rowspan="2"><strong>DNI: </strong></td>
   							<td><span id="tkDocNumber"></span></td>
   						</tr>
   					</tbody>
   				</table>
              </li>
			  <li>
			  	<table style="margin-left: -6px;">
   					<tbody>
   						<tr valign="top">
   							<td rowspan="2"><strong>Ganador: </strong></td>
   							<td><span id="ganador"></span></td>
   						</tr>
   					</tbody>
   				</table>
   			  </li>
            </ul>
          </div>
		 <div class="back" 	style="max-width: 712px; margin: 0px;"><a href="#" id="volverModalRetiros" onclick="volverModalRetiros()">Volver a retiros</a></div>
		<div class="content_loading"> 
          <div class="modal__body" style="padding-top: 0px;">
            <div>
              <div class="label-total">Monto a retirar en efectivo:</div>
              <div class="total"><strong>Total: </strong>S/<span id="tkRequestAmount"></span></div>
              <div class="codqr" id="items-tickets-payment-prizes">
                
              </div>
            </div>
          </div>
		  
          <div class="modal__footer">
            <form class="form frm-newsletter" action="downloadTicketsPP.html" method="post" name="formDownload" id="formDownload">
              <span class="down is-cian no-underline" style="margin-right: 0px;"><span onclick="downloadTicketsPP()">Descargar</span></span>
              <div class="form-item is-sendmail">
                <button class="btn btn-sendemail" style="position: inherit; border-radius: 5px;">Enviar por email</button>
              </div>
            </form>
            <p>C�bralo en un punto de venta cercano presentando tu DNI.</p>
          </div>
        </div>
      </div>	
    </div>	
</section>
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/plugins.js?v=<%=Constantes.plugins_js%>"></script>
<script type="text/javascript" src="layer-view-script/popModal.js?v=1"></script>
<script type="text/javascript" src="layer-view-script/client/libsCollectPrize.js?v=3"></script>
<script type="text/javascript" src="layer-view-script/client/mainCollectPrize.js?v=108" charset="UTF-8"></script>
<script type="text/javascript" src="layer-view-script/client/analytics.js?v=10" charset="UTF-8"></script>
<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=11"></script>

	<script type="text/javascript">		
		$(document).ready(function() {
					
			renderActivateFormPin();

		});
	</script>

<!-- validar cierre de sesion -->
<script>
    $(document).ready(function(){
		var clientIdSesion= $('#cid').val();
		 if(clientIdSesion!=''){
			 validateSessionParent();
			document.addEventListener("click", validateSessionParent);
			document.addEventListener("keypress", validateSessionParent);
		 }
// 		 else{
// 			 parent.location.href = "home.html";
// 		 }
		
	});
</script>
	
</body>
</html>
