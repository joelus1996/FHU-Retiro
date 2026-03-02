
var redirectCaseLoginCompraTYCPDP = "";

$(document).ready(function () {
	'use strict';
    redirectCaseLoginCompraTYCPDP = $("#redirectCaseLoginCompraTYCPDP").val();
    console.log("redirectCaseLoginCompraTYCPDP INIT>" + redirectCaseLoginCompraTYCPDP);
});

function saveAcceptedDocumentsTYCPDP(fnTraza) {
	$.ajax({
        url: 'save-accepted-documents.html',
        type: 'post',
        contentType: 'application/json',
        dataType: 'json',
        beforeSend: function () {
            $('body').append('<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
        }
    }).done(function (data) {
    	if (data.result == "OK") {
    		if (redirectCaseLoginCompraTYCPDP != "") {
    			window.top.location.href = redirectCaseLoginCompraTYCPDP;
    		} else {
    			window.parent.postMessage(fnTraza, "*");    			
    		}
    	}
    }).always(function () {
    	$('body').find('#loading-recharge').remove();
    	offRedirectLoginCompraTYCPDP();
    	closePopUpIframeTYCPDP();    	
    });
}

function closePopUpIframeTYCPDP() {
	offRedirectLoginCompraTYCPDP();
    const box = $(this).closest('.ioverlay');
    datalayerCerrarModal();
    box.fadeOut(250, function () {
        $('body').removeClass('no-scroll');
    });
    try {
        window.parent.postMessage('closeLightboxTYCPDP', '*');
        
    } catch (e) { }
}

function offRedirectLoginCompraTYCPDP () {
	$.ajax({
		type: "POST",
		url: "off-redirect-login-compra-typpdp.html",
		dataType: "json",
		async: false,
		success: function (data) {}
	});
}





