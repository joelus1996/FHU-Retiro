<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script src="https://pay.button.epago.pe/web/latest/sdk.js"></script>
<script src="https://cdn.jsdelivr.net/gh/emn178/js-sha512/build/sha512.min.js"></script>
</head>
<body class="no-scroll" style="overflow-y: hidden;">	
	<input type="hidden" id="fullName" value="" >
	<input type="hidden" id="lastName" value="" >
	<input type="hidden" id="amount" value="" >
	<input type="hidden" id="actbono" value="" >
	<input type="hidden" id="actwbbono" value="" >
	<input type="hidden" id="codePromotional" value="" >
	<input type="hidden" id="identifer" value="" >
	<input type="hidden" id="channel" value="" >
	<input type="hidden" id="operatorId" value="" >
	<input type="hidden" id="docTypeIzi" value="" >
	<input type="hidden" id="docNumber" value="" >
	<input type="hidden" id="cid" value="" >
	<input type="hidden" id="environment" value="<%=Constantes.EPAGO_ENVIRONMENT%>" >
	<input type="hidden" id="paymentMethods" value="<%=Constantes.EPAGO_PAYMENT_METHODS%>" >
	<input type="hidden" id="mobilePhone" value="" >
	<input type="hidden" id="number" value="" >
	<input type="hidden" id="apiKey" value="" >
	<input type="hidden" id="signature" value="" >

<div class="header-logoWrap" style="text-align: center;">
<img id="logo" class="header-logoImage" src="" alt="Logo" style=" max-width: 180px; width: 90%; max-height: 100px;">
<button type="button" onclick="hideLightboxIzipay()" class="close" style="color: green;font-size: 30px;opacity: 1;margin-top: -6px;line-height: 1;background: 0 0;border: 0;float: right;cursor: pointer;">×</button>
</div>
<div id="cart-container" class="epago-container" style="overflow-y: hidden; padding-left: 8px; padding-right: 8px;">
  <!-- Contenedor donde se apertura la librería de pago -->
  <button id="btnPagar" onclick="startPayment();" style="display: none;">Pagar</button>
</div>
<script>

function startPayment() {
  // Seteo de los campos de transacción
  var transaction = buildTransaction();

  // Seteo de los campos de autenticación de seguridad
  var authenticator = buildAuthentication(transaction);

  // Manejo de los campos de respuesta
  var form = new Epago.Form({
    environment: $("#environment").val(),

    // Seteo de autenticación de seguridad y transacción
    authentication: authenticator,
    transaction: transaction,

    // Manejo de la respuesta
    listeners: {
      afterPay: function (response) {
        if (response.success) {
        	//console.info("transaction response-------------------------------------------->"+ JSON.stringify(response));
        	json_response = JSON.stringify(response);
            try {
            	var referenceNumber="000000000000000";
            	if (response.data.result.accepted) {
            		for(let i=0; i<response.data.result.processorResult.metadata.length; i++) {
            			if(response.data.result.processorResult.metadata[i].name=="referenceNumber"){
            				if(response.data.result.processorResult.metadata[i].value!=undefined){
            					referenceNumber+=response.data.result.processorResult.metadata[i].value;
            				}
            			}
            		}
            		referenceNumber = referenceNumber.substring(referenceNumber.length - 15);
            		
	          	  	window.parent.postMessage("hideLightboxIzipay|"+
	          			  "AUTHORIZED|"+
	          			response.data.order.uniqueIdentifier+"|"+
	          			response.data.order.number+"|"+
	          			response.data.payment.brand.code+"|"+
	          			$("#amount").val()+"|"+
	          			response.data.created+"|"+
	          			response.data.result.processorResult.code+"|"+
	          			response.data.result.processorResult.message+"|"+
	          			response.data.result.processorResult.operationNumber+"|"+
	          			$("#actbono").val()+"|"+
	          			$("#actwbbono").val()+"|"+
	          			$("#codePromotional").val()+"|"+
	          			$("#channel").val()+"|"+
	          			json_request+"|"+
	          			json_response+"|"+
	          			response.data.payment.card.bin+"******"+response.data.payment.card.lastPan+"|"+
	          			referenceNumber+response.data.payment.card.bin+response.data.payment.card.lastPan+response.data.result.processorResult.operationNumber,'*');
            	} else{
            		window.parent.postMessage("hideLightboxIzipay|ERRORIZI|"+
            				response.data.order.number+"|"+
            				response.data.payment.brand.code+"|"+
            				response.data.payment.card.bin+"******"+response.data.payment.card.lastPan+"|"+
            				response.data.order.uniqueIdentifier+"|"+
            				$("#amount").val()+"|"+
            				response.data.result.processorResult.code+"|"+
            				json_request+"|"+
    	          			json_response,'*');
            	}
      	  	} catch (e) {  
      	  	 window.parent.postMessage("hideLightboxIzipay|ERROR|",'*');
      	  	}
        }else {
          // Agregue el código de la experiencia que desee visualizar en un error
        	window.parent.postMessage("hideLightboxIzipay|ERROR|",'*');
        }
      }
      }
  });
  // Muestre el contenedor con la librería de pago
  form.render('#cart-container');
}

function buildTransaction() {
  var number = $('#number').val();
  var nombres = $('#fullName').val();
  var apellidos = $('#lastName').val();
  var monto = $("#amount").val();
  var identifer =  $("#identifer").val();
  var mobilePhone = $("#mobilePhone").val(); 
  var docTypeIzi =  $("#docTypeIzi").val();
  var docNumber =  $("#docNumber").val();
  var email =  "CID"+$("#cid").val()+"@latinka.com.pe";
  
  // Seteo de los datos de transacción
  var transaction = {
    "order": {
      // Seteo del número de pedido (tipo string)
      "number": number,
      // Seteo del código de país 
      "country": {
        "code": "PER"
      },
      // Seteo del código de moneda
      "currency": {
        "code": "PEN"
      },
      //Seteo del monto
      "amount": monto,
      // Seteo del cliente
      "customer": {
    	"identifer":identifer,
        "name": nombres,
        "lastName": apellidos,
        // Seteo del pais (country), niveles de ubicación geográfica (levels), dirección (line1 y line2) y código postal (zip)
        "address": {
          "country": "PER",
          "levels": [
            "LIMA",
            "LIMA",
            "MIRAFLORES"
          ],
          "line1": "Jose Pardo Nro. 434",
          "zip": "15074"
        },
        // Seteo del email y teléfono
        "email": email,
        "phone": mobilePhone,
        // Seteo del tipo y número de documento
        "document": {
          "type": docTypeIzi,
          "number": docNumber
        }
      },
      // Seteo de los datos de envío
      "shipping": {
        "name": nombres,
        "lastName": apellidos,
        "address": {
          "country": "PER",
          "levels": [
            "LIMA",
            "LIMA",
            "MIRAFLORES"
          ],
          "line1": "Jose Pardo Nro. 434",
          "zip": "15074"
        },
        "email": email,
        "phone": mobilePhone,
        "document": {
          "type": docTypeIzi,
          "number": docNumber
        }
      },
      // Seteo de los datos de facturación
      "billing": {
        "name": nombres,
        "lastName": apellidos,
        "address": {
          "country": "PER",
          "levels": [
            "LIMA",
            "LIMA",
            "MIRAFLORES"
          ],
          "line1": "Jose Pardo Nro. 434",
          "zip": "15074"
        },
        "email": email,
        "phone": mobilePhone,
        "document": {
          "type": docTypeIzi,
          "number": docNumber
        }
      },
      // Seteo de los datos de producto
      "products": [{
        "name": "Recarga",
        "quantity": 1,
        "unitAmount": monto,
        "amount": monto,
        "sku": "1020304005060",
        "category": "Recarga",
        "discount": 0,
        "shipping": 0,
      }],
    },
    // Seteo de los datos de configuración
    "settings": {
      "paymentMethods": [$("#paymentMethods").val()],
      "brands": ['VISA', 'MSCD'], // Marcas que serán visibles en el formulario de pago
      "language": "es_PE",
      "businessService": "WEB"
    }
  };
  //console.info("transaction request-------------------------------------------->"+ JSON.stringify(transaction));
  json_request = JSON.stringify(transaction);
  return transaction;
}

function buildAuthentication(transaction) {
  var authenticator = {    
    identifier: $('#apiKey').val(),
    signature: $('#signature').val(),
  }

  return authenticator;
}
</script>

<style>
div[epago-identifier="payment-button"] {
    background-color: #00662b;
    color: white; 
}

div[epago-identifier="payment-form-container"]{

    height: 88%;
}

div[epago-container^="field-"] input{
	height: 30px;
    font-size: 12px;
}

div[epago-container^="field-"] select {
	height: 33px;
    font-size: 11px;
}

div[epago-identifier="payment-wrapper"] {
    min-height: 550px;
    min-width: auto;
    width: 100%;
    padding: 0px;
}

div[epago-identifier="epago-footer"]{
	bottom: 84px;
	width: 90%; 
}

div[epago-identifier="payment-button"] {
	padding-top: 8px;
    padding-bottom: 8px;
}
div[epago-identifier^="error-displayer-field"]{
	width: 50%;
}
div[epago-identifier="error-displayer-wrapper"] {
    padding: 4px 0;
}
</style>

<script type='text/javascript'>
var json_request;
var json_response;

$(document).ready(function(){
	const queryString = window.location.search;
	const urlParams = new URLSearchParams(queryString);
	const amountIzipay = urlParams.get('amountIzipay');
	const actbono = urlParams.get('actbono');
	const actwbbono = urlParams.get('actwbbono');
	const fullName = urlParams.get('fullName');
	const lastName = urlParams.get('lastName');
	const identifer = urlParams.get('identifer');
	const codePromotional = urlParams.get('codePromotional');
	const channel = urlParams.get('channel');
	const operatorId = urlParams.get('operatorId');
	const docTypeIzi = urlParams.get('docTypeIzi');
	const docNumber = urlParams.get('docNumber');
	const cid = urlParams.get('cid');
	const number = urlParams.get('number');
	const apiKey = urlParams.get('apiKey');
	const mobilePhone = urlParams.get('mobilePhone');
	const signature = urlParams.get('signature');
	if(operatorId=="5588"){
		$("#logo").attr("src","layer-view-image/v2/landing/img/logo-teapuesto_03_v2.png?v=1");
		$("#logo").css("max-width","110px");
	}else if(operatorId=="5586"){
		$("#logo").attr("src","layer-view-image/v2/logo-tinka.svg?v=1");
		$("#logo").css("max-width","180px");
	}else{
		$("#logo").attr("src","layer-view-image/v2/logo-tinka.svg?v=1");
		$("#logo").css("max-width","180px");
	}
	$('#amount').val(amountIzipay);
	$('#actbono').val(actbono);
	$('#actwbbono').val(actwbbono);
	$('#fullName').val(fullName);
	$('#lastName').val(lastName);
	$('#codePromotional').val(codePromotional);
	$('#identifer').val(identifer);
	$('#channel').val(channel);
	$('#operatorId').val(operatorId);
	$('#docTypeIzi').val(docTypeIzi);
	$('#docNumber').val(docNumber);
	$('#cid').val(cid);
	$('#number').val(number);
	$('#apiKey').val(apiKey);
	$('#mobilePhone').val(mobilePhone);
	$('#signature').val(signature);
	$("#btnPagar").trigger('click');
});

function hideLightboxIzipay(){
	window.parent.postMessage("hideLightboxIzipay|CLOSE|",'*');
}
</script>
	
</body>
</html>