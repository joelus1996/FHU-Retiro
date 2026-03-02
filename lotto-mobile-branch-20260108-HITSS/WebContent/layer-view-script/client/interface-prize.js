/**
 * 
 */
$('#viewmore').click(function() {

	openLoader();

	var from = $(this).data('from');
	var to = $(this).data('to');

	var jqxhr = $.ajax({
		type: "GET",
		url: "./client_price_show_information.html?from=" + from + "&to=" + to,
	})
	.done(function(res) {
		var $res = $(res);
		$('#results').append($res.find("#results ul"));
		if ($res.find("#viewmore").length) {
			$('#viewmore').data('from', $res.find("#viewmore").data('from')).data('to', $res.find("#viewmore").data('to'));
		} else {
			$('#viewmore').hide();
		}
	})
	.fail(function() {
		console.log('error')
	})
	.always(function() {
		closeLoader();
	});

});

$(document).delegate('#results li button', 'click', function(){
	var ico = $(this).siblings('i');
	$(ico).addClass('loading');
	
	var ticket = $(this).data('ticket');
	var play = $(this).data('play');

	var jqxhr = $.ajax({
		type: "GET",
		url: "./client_price_find_information.html?ticket=" + ticket + "&gameId=" + play,
	})
	.done(function(res) {
		var vres = $(res);
		$('#popup .main-modal').html(vres.find(".wrap-modal"));

		//
		if ($('#premio_prize').length) {
			var prize = ($('#premio_prize').html()).split(' ');
			var left = prize[0];
			var right = prize[1];
			left = left.replace(".", " ");
			$('#premio_prize').html(left + right);
		}
		//
		var base64Qr = $('#txtQR').val();

		openModal("#popup","");
	})
	.fail(function() {
		console.log('error')
	})
	.always(function() {
		$(ico).removeClass('loading');
	});

});

$(document).delegate('#btnCobrarQR', 'click', function (event) { 
	event.preventDefault();
    $.ajax({
        type: "post",
        url: "cobrarQR.html",
        //dataType: 'html',
        dataType: 'json',
        contentType: 'application/json',
        //data: JSON.stringify(buttonParameters),
        global: false,
        async: false,
        success: function (e) {
        	var status = e.status;
        	var htmlQrImage = e.htmlQrImage;
        	$("#lblStatus").text(status);
        	$("#divMensaje").html("<p style='text-align:center'>* Presenta este c&oacute;digo QR en el punto de venta.</p>");
        	$( "#divTicketData" ).append(htmlQrImage);
        	$( "#divBtnCargarSaldo" ).remove();
        	$( "#divBtnCobrarQR" ).remove();
        	return;
        },
        error: function (xhr, ajaxOptions, thrownError) {
            message = 'En este momento estamos presentando problemas. Por favor intenta nuevamente m&aacute;s tarde.';
            alert(message);
        }
    });
});

function showPaymentPrize(){
	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
	mainValidatePendingsDocsForAproval('interfacePrizeRetirarPremio');
}

function interfacePrizeRetirarPremio(){
	validatePerfil("#showPaymentPrize");
	datalayerMisPremiosRetirar('Retirar');
}

window.addEventListener("message", function(event) {
    if (event.data === "interfacePrizeRetirarPremio") {
    	interfacePrizeRetirarPremio(); 
    }
});

function confirmActivateModal() {
    $('#myToggleSwitch').prop('checked', true);
    editStateModal(true);
    closePopup('popup-message-recharge');
}

function confirmDesactivateModal() {
    $('#myToggleSwitch').prop('checked', false);
    editStateModal(false);
    closePopup('popup-message-recharge');
}

function mostrarConfirmacionActivacion() {
    var titulo = "¿Quieres activar el pago automático de tus premios?";
    var mensaje = "Todos los premios se abonarán directamente a tu saldo disponible para retiro y los premios mayores o igual a S/10,000 estarán disponibles para transferirlos a tu cuenta bancaria.";
    var html = `
        <div class="mensaje-confirmacion-password">
            <span class="mensaje-recuperar-password">${titulo}</span><br><br>
            <p class="descripcion-ok">${mensaje}</p><br><br>
            <button class="button button-orange-light no-margin green btn-activar" type="button" style="width: 100%;">Si, Activar</button><br>
            <button class="button button-orange-reverse no-margin green btn-cancelar" type="button" style="width: 100%;">Cancelar</button>
        </div>`;
    $('#msg-session').html(html);
    openModal("#popup-message-recharge","");
}

function mostrarConfirmacionDesactivacion() {
    var titulo = "&iquest;Seguro que deseas desactivar el pago autom&aacute;tico?";
    var mensaje = "Si desactivas esta opci&oacute;n, los boletos comprados a partir de ahora y que obtengan premio deber&aacute;s presentarlo en los puntos de ventas autorizados para poder cobrarlos.";
    var html = `
        <div class="mensaje-confirmacion-password">
            <span class="mensaje-recuperar-password">${titulo}</span><br><br>
            <p class="descripcion-ok">${mensaje}</p><br><br>
            <button class="button button-orange-light no-margin green btn-desactivar" type="button" style="width: 100%;">Si, Desactivar</button><br>
            <button class="button button-orange-reverse no-margin green btn-cancelar" type="button" style="width: 100%;">Cancelar</button>
        </div>`;
    $('#msg-session').html(html);
    openModal("#popup-message-recharge","");
}

function mostrarErrorActivacion() {
    var titulo = "Esta opción no está disponible en este momento";
    var mensaje = "¡Vuelve a intentarlo más tarde!";
    var html = `
        <div class="mensaje-confirmacion-password">
            <span class="mensaje-recuperar-password">${titulo}</span><br><br>
            <p class="descripcion-ok">${mensaje}</p><br><br>
        </div>`;
    $('#msg-session').html(html);
    openModal("#popup-message-recharge","");
}

$(document).on('click', '.btn-activar', function () {
    confirmActivateModal();
});

$(document).on('click', '.btn-desactivar', function () {
    confirmDesactivateModal();
});

$(document).on('click', '.btn-cancelar', function () {
    closePopup('popup-message-recharge');
});

$(document).on('click', '#myToggleSwitch', function (event) {
    event.preventDefault();
    if ($(this).prop('checked')) {
        mostrarConfirmacionActivacion();
    } else {
        mostrarConfirmacionDesactivacion();
    }
});

function editStateModal(autoPayEnabled) {
    $('.ajax-loader').show();
    $.ajax({
        type: 'POST',
        url: 'edit_client_autopayment_flag.html',
        dataType: "json",
        async: false,
        data: { autoPayEnabled: autoPayEnabled },
        success: function (e) {
            $('.ajax-loader').hide();
            if (e.status === "OK") {
                $('#myToggleSwitch').prop('checked', autoPayEnabled);
            } else {
                closePopup('popup-message-recharge');
                console.log("No se pudo actualizar la configuración.");
                $('#myToggleSwitch').prop('checked', !autoPayEnabled);
                setTimeout(function() {
                    mostrarErrorActivacion();
                }, 300);
            }
        },
        error: function () {
            $('.ajax-loader').hide();
            console.log("Hubo un problema al actualizar la configuración.");
            $('#myToggleSwitch').prop('checked', !autoPayEnabled);
            setTimeout(function() {
                mostrarErrorActivacion();
            }, 300);
        }
    });
}

function getStateModal() {
    $('.ajax-loader').show();
    $.ajax({
        type: 'POST',
        url: 'get_client_autopayment_flag.html',
        dataType: "json",
        async: false,
        success: function (e) {
            $('.ajax-loader').hide();
            if (e.status === "OK" && e.clientInformation) {
                var prizeCollection = e.clientInformation.prizeCollection;
                $('#myToggleSwitch').prop('checked', (prizeCollection === "WEB"));
            } else {
                console.log("Error al obtener el estado de configuración.");
            }
        },
        error: function () {
            $('.ajax-loader').hide();
            console.log("Hubo un problema al obtener la configuración.");
        }
    });
}

getStateModal();