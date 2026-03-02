// popup Data Complete 
var popup = {
	trazaPerfil : '', 
	
	close : function(){
		$('body').removeClass('modal');
		$('body').removeClass('menu_active');
		$('.jsBtnIcon').removeClass('active');
		$('.overlayData.opened').removeClass('opened');
	},	
	
	openModal : function (modal,ctrl) {
		$('#myCredit').hide();
		$('#myAbout').hide();
		$('body').removeClass('menu_active');
		$(modal).addClass('opened');
		$('.jsBtnIcon').removeClass('active');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	},
	
	validateDatacomplete : function(){
		
    	var isDataComplete = $("#isDataComplete").val();
    	if(isDataComplete.trim() == '0'){ 
    		popup.openModal("#popupDataComplete","");
    	}else{
    		popup.direccionar();
    	}
    },
	direccionar : function(){
		if(popup.trazaPerfil == 'agregarSaldo' || popup.trazaPerfil == 'client_lotocard_show_information')
			popUpAddSaldo(popup.trazaPerfil);
		else if(popup.trazaPerfil == 'showPaymentPrize' )
			popUpPaymentPrize();
		else if(popup.trazaPerfil == 'client_account_show_information')
		    $(location).attr('href','client_account_show_information.html');
	}
};

$(document).ready(function(){
	
	$('#closeDirec').click(function(event){ 
		popup.close();
		popup.direccionar();
	});
	
	$("#btnEditarPerfil").on('click',function(){
		rediccionarPerfil();
	});
	
});

function validatePerfil(identificador){

	var isCerrar = true;
	
	if($(identificador).prop('id') == 'showPaymentPrize')
		isCerrar = false;
		
	
	$("#popupDataMensaje").css('display',isCerrar ? 'none' :'block');
	$('.popup .js-close-modal').css('display',isCerrar ? 'block' :'none');
	popup.trazaPerfil = $(identificador).prop('id') ;
	popup.validateDatacomplete();
	
	// Aquí agregar una función para validar que el usuario no tenga T&C y PDP pendientes de pago
	
}

function rediccionarPerfil(){
	
	popup.close();
	var pathname = $(location).attr('pathname');
	
	if(pathname.indexOf("client_edit_show_information.html") == -1){
	 	$(location).attr('href','client_edit_show_information.html');
	}
	
}

function popUpAddSaldo(trazaPerfil){
	var marca = "logo-tinka.png";
	var button = 'client_lotocard_show_information';
	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483645 !important;"></i>');
	$('body').css('overflow-y', 'hidden');
	$('body').append('<div id="div-lightbox-recharge-ilot"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlot(\''+button+'\');" style="display: none;"></button><iframe id="frmLightboxRecharge" allowtransparency="true" frameborder="0" src="rechargei.html?marca='+marca+'" class="lightbox-recharge" style="margin-top: 0px;" ></iframe></div>');
	$('#myCredit').hide();
	$('#myAbout').hide();
	$('body').removeClass('menu_active');
	$('.jsBtnIcon').removeClass('active');
	datalayerCargarSaldo(trazaPerfil);
	try {
		cerrarMensajeNotificacion();
	} catch (e) {
		
	}
}

function popUpPaymentPrize(){
	$('body').append('<i id="cargando" class="loading" style="z-index: 1000 !important;"></i>');
	$('body').css('overflow-y', 'hidden');
	if(parametroPP!=undefined && parametroPP!=null && parametroPP=="historial"){
		$('body').append('<div id="div-lightbox-collect-prize-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 10000;"><iframe id="frmLightboxCollectPrize" scrolling="no" frameborder="0" src="pago-premio.html?redirige=historial" style="width:100%; height: 100%; z-index: 10000 !important; border:0;"></iframe></div>');
	}else{
		$('body').append('<div id="div-lightbox-collect-prize-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 10000;"><iframe id="frmLightboxCollectPrize" scrolling="no" frameborder="0" src="pago-premio.html" style="width:100%; height: 100%; z-index: 10000 !important; border:0;"></iframe></div>');
	}
}

//Inicio de la función para validar y obtener los documentos pendientes de confirmación del cliente
function mainValidatePendingsDocsForAproval(fnTraza = "") {
    $.ajax({
    	url: 'get-pending-docs-for-aproval.html',
    	type: 'post',
    	contentType: 'application/json',
    	dataType: 'json',
    	success: function(response) {
    		if (response.dataPendingDocs && response.dataPendingDocs.status == 'OK' && response.dataPendingDocs.documents.length > 0) {
    			$('body').append('<i id="cargando" class="loading" style="z-index: 2147483645 !important;"></i>');
    			$('body').css('overflow-y', 'hidden');
    			$('body').append(`
					<div id="div-lightbox-tyc-pdp">
						<iframe id="frmLightboxTYCPDP" allowtransparency="true" frameborder="0" src="tyc-pdp.html" class="lightbox-recharge" style="margin-top: 0px;" ></iframe>
					</div>
    			`);
    			$('body').removeClass('menu_active');
    			$('.jsBtnIcon').removeClass('active');
    			const iframe = document.getElementById('frmLightboxTYCPDP');
    			iframe.onload = function() {
    				updateformTycPdpWithRetry(response.dataPendingDocs, 3, fnTraza);
    			};
    		} else {
    			if (fnTraza != "") {
    				window.parent.postMessage(fnTraza, "*");			
    			}
    		}
    	},
    	error: function(xhr, status, error) {
    		reject("Error en la petición: " + status + " " + error);
    	}
    });
}
// Fin de la función para validar y obtener los documentos pendientes de confirmación del cliente

// Inicio de la función para actualizar el formulario del popup de los documentos pendientes de confirmación
function waitForIframe(iframeId, maxRetries = 20, interval = 250) {
    return new Promise((resolve, reject) => {
        let retries = 0;
        const iframe = document.getElementById(iframeId);

        if (!iframe) {
            reject(`No se encontró el iframe con ID ${iframeId}`);
            return;
        }

        const checkIframe = setInterval(() => {
            if (iframe.contentWindow && iframe.contentWindow.document.readyState === "complete") {
                clearInterval(checkIframe);
                console.log(`Iframe ${iframeId} cargado correctamente`);
                resolve(iframe.contentWindow.document);
            } else if (retries >= maxRetries) {
                clearInterval(checkIframe);
                reject(`El iframe ${iframeId} no cargó después de ${maxRetries * interval}ms`);
            }
            retries++;
        }, interval);
    });
}

async function updateformTycPdpWithRetry(data, retries = 3, fnTraza) {
    for (let i = 0; i < retries; i++) {
        try {
            let iframeDoc = await waitForIframe('frmLightboxTYCPDP');
            console.log('Iframe cargado correctamente');
            updateformTycPdp(data, fnTraza);
            return;
        } catch (error) {
            console.error(`Intento ${i + 1} fallido:`, error);
            if (i === retries - 1) {
                console.error('No se pudo actualizar el iframe después de varios intentos');
            } else {
                // Recargar el iframe en caso de fallo
                $('#frmLightboxTYCPDP').attr('src', $('#frmLightboxTYCPDP').attr('src'));
            }
        }
    }
}

function updateformTycPdp(data, fnTraza) {
    (async function () {
        try {
            let urlQWLocal = $("#urlQw").val();
            let arrTitleTYCPDP = [];
            let arrDescriptionTYCPDP = [];

            let iframeDoc = await waitForIframe('frmLightboxTYCPDP');

            let blockTyc = $(iframeDoc).find('#blockTyc');
            let blockPdp = $(iframeDoc).find('#blockPdp');
            let blockTitlePendingDocs = $(iframeDoc).find('#blockTitlePendingDocs');
            let blockDescriptionPendingDocs = $(iframeDoc).find('#blockDescriptionPendingDocs');
            let blockButtonTycPdp = $(iframeDoc).find('#blockButtonTycPdp');

            $.each(data.documents, function(index, doc) {
                if (doc.docType == "TYC") {
                    arrTitleTYCPDP.push("términos y condiciones");
                    arrDescriptionTYCPDP.push("los términos y condiciones");
                    blockTyc.append(`
                        <a class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más" href="${urlQWLocal}/terminos-y-condiciones/" target="_blank">
                            ${safeDecodeURIComponent('Ir a Términos y Condiciones')}
                        </a><br>
                        ${safeDecodeURIComponent('Versión')} ${doc.version}: ${formatDateEs(doc.publicationDate)}
                    `);
                } else if (doc.docType == "PDP") {
                    arrTitleTYCPDP.push("política de datos personales");
                    arrDescriptionTYCPDP.push("la política de datos personales");
                    blockPdp.append(`
                        <a class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más" href="${urlQWLocal}/politica-de-datos-personales/" target="_blank">
                            ${safeDecodeURIComponent('Ir a Política de privacidad')}
                        </a><br>
                        ${safeDecodeURIComponent('Versión')} ${doc.version}: ${formatDateEs(doc.publicationDate)}
                    `);
                }
            });

            let stringTitleTYCPDP = arrTitleTYCPDP.join(" y ");
            let stringDescriptionTYCPDP = arrDescriptionTYCPDP.join(" y ");

            blockTitlePendingDocs.append(safeDecodeURIComponent(`Actualización de ${stringTitleTYCPDP}`));
            blockDescriptionPendingDocs.append(safeDecodeURIComponent(`Hemos realizado actualizaciones a ${stringDescriptionTYCPDP}, desde tu última sesión. Por favor infórmate y confirma la aceptación para continuar usando nuestra plataforma virtual.`));
            blockButtonTycPdp.append(`
                <span>
                    <button class="btn btn-popup" style="background: #e30613; border: 2px solid #e30613; color: #fff; box-shadow: none; width: 158px; display: initial; margin-left: 0px;" onclick="saveAcceptedDocumentsTYCPDP('${fnTraza}')">
                        ACEPTAR
                    </button>
                </span>
            `);

        } catch (error) {
            console.error(error);
        }
    })();
}
// Fin de la función para actualizar el formulario del popup de los documentos pendientes de confirmación
function formatDateEs(fechaStr) {
    let fecha = new Date(fechaStr);
    return fecha.toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' }); // Formato dd/mm/yyyy
}

function safeDecodeURIComponent(str) {
    try {
        return decodeURIComponent(escape(str));
    } catch (e) {
        return str; // Devuelve la cadena original si falla
    }
}



// ------------------------------------------------------

