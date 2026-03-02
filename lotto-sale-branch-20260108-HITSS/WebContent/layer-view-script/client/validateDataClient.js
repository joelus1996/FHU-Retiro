// popup Data Complete 
var popup = {
	trazaPerfil : '',
	close : function(){
		$('.overlay.opened').removeClass('opened');
		$('body').removeClass('modal');
	},	
	
	openModal : function (modal,ctrl) {
		$(modal).addClass('opened');
		$('body').addClass('modal');
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
		
		if(popup.trazaPerfil == 'tab-item_4'  || popup.trazaPerfil == 'addSaldo')
			popUpAddSaldo();
		else if(popup.trazaPerfil == 'tab-item_1' || popup.trazaPerfil == 'tab-item_2' )
			$("#content-" + popup.trazaPerfil).show();
		else if(popup.trazaPerfil == 'popUpPaymentPrize')
			popUpPaymentPrize();
        	
	}
};

$(document).ready(function(){
	
	$('.popup .js-close-modal').click(function(event){
		popup.close();
		popup.direccionar();
	});
	
	$("#btnEditarPerfil").on('click',function(){
		rediccionarPerfil();
		
	});
	
});

function validatePerfil(identificador){
	var isCerrar = true;
	if($(identificador).prop('id') == 'popUpPaymentPrize')
		isCerrar = false;
	if(sessionStorage.getItem('DataComplete') != undefined){
		sessionStorage.removeItem('DataComplete');
		return;
	}
		
	$("#popupDataMensaje").css('display',isCerrar ? 'none' :'block'); 
	$('.popup .js-close-modal').css('display',isCerrar ? 'block' :'none'); 
	popup.trazaPerfil = $(identificador).prop('id') ; 
	popup.validateDatacomplete();
	
}

function rediccionarPerfil(){
	
	popup.close();
	var pathname = $(location).attr('pathname');
	 
	if(pathname.indexOf("mi-cuenta.html") == -1){
		sessionStorage.setItem('DataComplete', true); 
	 	$(location).attr('href','mi-cuenta.html#yo');
	}
		
	if(popup.trazaPerfil == 'addSaldo'){
		$(location).attr('href','mi-cuenta.html#yo');
		$("#tab-item_1").hide();
		$("#content-tab-item_1").show();
	}
	else if(popup.trazaPerfil == 'popUpPaymentPrize'){
		$("#content-tab-item_2").hide();
		$("#tab-item_2").show();
		$("#tab-item_1").hide();
		$("#content-tab-item_1").show();
	}
	else{ 
		$("#content-"+popup.trazaPerfil).hide();
		$("#"+popup.trazaPerfil).show();
		$("#tab-item_1").hide();
		$("#content-tab-item_1").show();
	}
	
	$("#tabEditPerfil").prop("checked",true);
	
}

function popUpAddSaldo(){
	$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
	$('body').css('overflow-y', 'hidden');
	var action = window.location.href;
	$('body').append('<div id="div-lightbox-recharge-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 2147483000;overflow: auto;"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlot();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" scrolling="no" frameborder="0" onload="retirar_loading();" src="rechargei.html?marca=logo-tinka.png&reference='+action+'" class="lightbox-recharge" ></iframe></div>');
	datalayerCargarSaldo();
	try {
		cerrarMensajeNotificacion();
	} catch (e) {
		
	}
}

function popUpPaymentPrize(){
	$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
	$('body').css('overflow-y', 'hidden');
	if(parametroPP!=undefined && parametroPP!=null && parametroPP=="historial"){
		$('body').append('<div id="div-lightbox-collect-prize-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 10000;"><iframe id="frmLightboxCollectPrize" scrolling="no" frameborder="0" onload="retirar_loading();" src="pago-premio.html?redirige=historial" style="width:100%; height: 100%; z-index: 10000 !important; border:0;"></iframe></div>');
	}else{
		$('body').append('<div id="div-lightbox-collect-prize-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 10000;"><iframe id="frmLightboxCollectPrize" scrolling="no" frameborder="0" onload="retirar_loading();" src="pago-premio.html" style="width:100%; height: 100%; z-index: 10000 !important; border:0;"></iframe></div>');
	}
}

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

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
}
