;
var $restablecerUsers = function() {
	$('#frm-user-reminder').on('submit', function(b) {
        var $form = $(this);
        var ico = $(this).siblings('i');
        b.preventDefault();
        $.ajax({
            url: $(this).attr('action'),
            data: $(this).serialize(),
            type: $(this).attr('method'),
            dataType: 'json',
            beforeSend: function() {
            	//$('#btn-send').prop('disabled', false);
            	$(ico).addClass('loading-ilot');
                $('#btn-send').prop('disabled', true);
                $("#btn-send").css({"background-position": "0 -35px"});
            },
            error: function() {
            	$(ico).removeClass('loading-ilot');
            	var message='¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.';
            	try {
            		userSentError(message);			
    			} catch (e) {
    				console.error(e);
    			}
            	
                jAlert(message);
                $('#btn-send').prop('disabled', false);
                $("#btn-send").css({"background-position": "0 0"});
            },
            success: function(a) {
            	$(ico).removeClass('loading-ilot');
                if (a.message === 'OK') {
                    //$('#send').show();
                    //jAlert(a.send);
                	var rtitle=a.rtitle;
                	var rmessage=a.rmessage;
                	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/Check.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+rtitle+'</span><br><br>'+
//                	'<p class="descripcion-ok">Si no lo encuentras, revisa tu bandeja</p>'+
//                	'<p class="descripcion-ok"> de no deseados o contáctate con</p>'+
                	'<p class="descripcion-ok"">'+rmessage+'</p><br><br>'+
                    '<button class="button button-orange-light no-margin green" onclick="goHome();" type="button" style="width: 50%;">Aceptar</button></div>';	
                   $('#msg-confirmacion').html(msgOk);
                	openModal("#popup","");
                    try {
                    	userSent();			
        			} catch (e) {
        				console.error(e);
        			}
                    
                } else{
                	if (a.message === 'KO') {
                		//jAlert(a.send);
                		$('#msg-confirmacion').html(a.send);
                    	openModal("#popup","");
                		try {
                			userSentError(a.send);			
            			} catch (e) {
            				console.error(e);
            			}
                		
                	} else if(a.rbutton==='202'){
                		var rmessage = a.rmessage;
                  		var msgError = '<div><p class="descripcion-ok"">'+rmessage+'</p><br><br>'+
                           '<button class="button button-orange-light no-margin green" onclick="goHome();" type="button" style="width: 50%;">Aceptar</button></div>';
                       	$('#msg-confirmacion').html(msgError);
                       	openModal("#popup","");
	               		try {
	               			userSentError(a.message);			
	           			} catch (e) {
	           				console.error(e);
	           			}
                	}else if(a.rbutton==='126'){
	                		var rtitle=a.rtitle;
	                    	var rmessage=a.rmessage;
	                    	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+rtitle+'</span><br><br>'+
	                    	'<p class="descripcion-ok"">'+rmessage+'</p><br><br>'+
	                        '<button class="button button-orange-light no-margin green" onclick="goRegistro();" type="button" style="width: 50%;">Regístrate</button></div>';	
	                       $('#msg-confirmacion').html(msgOk);
	                    	openModal("#popup","");
		               		try {
		               			userSentError(a.message);			
		           			} catch (e) {
		           				console.error(e);
		           			}
	           			}else{
                		//jAlert(a.message);
                		var rmessage = a.rmessage;
                   		 var msgError = '<div><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+rmessage+'</span><br><br><br>'+
                            '<button class="button button-orange-light no-margin green" onclick="backPassword();" type="button" style="width: 50%;">Regresar</button></div>';
                        	$('#msg-confirmacion').html(msgError);
                        	openModal("#popup","");
                		try {
                			userSentError(a.message);			
            			} catch (e) {
            				console.error(e);
            			}
                	}
                	
                }
                $('#btn-send').prop('disabled', false);
                $("#btn-send").css({"background-position": "0 0"});
            }
        })
    });
	
	function validateEmail(email) {
	    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	    return re.test(String(email).toLowerCase());
	}
	
	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		$('body').addClass('modal');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	}
	
		
    $('#frm-user-send').on('submit', function(b) {
        var $form = $(this);        
        b.preventDefault();
        
        // Validar formato correo electronico
//        var isValidEMail = validateEmail($('#email-user').val());
//        if(!isValidEMail){
//        	var message='Correo no v&aacute;lido';
//        	
//        	var msgError = '<div><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+message+'</span><br><br><br>'+
//            '<button class="button button-orange-light no-margin green" onclick="backPassword();" type="button" style="width: 50%;">' +
//            'REGRESAR</button></div>';
//        	$('#msg-confirmacion').html(msgError);        	
//        	try {
//        		mailError(message);				
//			} catch (e) {
//				console.error(e);
//			}    
//			openModal("#popup","");
//        	//jAlert(message);
//        	return;
//        }
        var ico = $(this).siblings('i');
        $.ajax({
            url: $(this).attr('action'),
            data: $(this).serialize(),
            type: $(this).attr('method'),
            dataType: 'json',
            beforeSend: function() {
            	//$('#btn-send').prop('disabled', false);
            	$(ico).addClass('loading-ilot');
                $('#btn-send').prop('disabled', true);
                $("#btn-send").css({"background-position": "0 -35px"});
            },
            error: function() {
            	$(ico).removeClass('loading-ilot');
            	var message='¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.';
                jAlert(message);
                $('#btn-send').prop('disabled', false);
                $("#btn-send").css({"background-position": "0 0"});
                try {
                	mailError(message);			
    			} catch (e) {
    				console.error(e);
    			}
                
            },
            success: function(a) {
            	$(ico).removeClass('loading-ilot');
                if (a.message === 'OK') {
	                    //$('#send').hide();
	                    //$('#send2').show();
	                    //$('#email').val(a.email);
                	var rtitle = a.rtitle;
                	var rmessage = a.rmessage;
                	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/Check.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+rtitle+'</span><br><br>'+
//                	'<p class="descripcion-ok">Si no lo encuentras, revisa tu bandeja</p>'+
//                	'<p class="descripcion-ok"> de no deseados o contáctate con</p>'+
                	'<p class="descripcion-ok"">'+rmessage+'</p><br><br>'+
                    '<button class="button button-orange-light no-margin green" onclick="goHome();" type="button" style="width: 50%;">Regresar</button></div>';	
                   $('#msg-confirmacion').html(msgOk);
                	openModal("#popup","");
	                    //jAlert(a.send);
	                    try {
	                    	newPassword();				
	        			} catch (e) {
	        				console.error(e);
	        			}
	                    
                } else{
                	if (a.message === 'KO') {
                		$('#msg-confirmacion').html(a.send);
                    	openModal("#popup","");
                		//jAlert(a.send);
                		try {
                			mailError(a.send);				
            			} catch (e) {
            				console.error(e);
            			}
                		
                	}else if(a.rbutton==='126'){
                		var rtitle=a.rtitle;
                    	var rmessage=a.rmessage;
                    	var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+rtitle+'</span><br><br>'+
                    	'<p class="descripcion-ok"">'+rmessage+'</p><br><br>'+
                        '<button class="button button-orange-light no-margin green" onclick="goRegistro();" type="button" style="width: 50%;">Regístrate</button></div>';	
                       $('#msg-confirmacion').html(msgOk);
                    	openModal("#popup","");
	               		try {
	               			userSentError(a.message);			
	           			} catch (e) {
	           				console.error(e);
	           			}
           			} else {
                		var rmessage = a.rmessage;
                		 var msgError = '<div><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+rmessage+'</span><br><br><br>'+
                         '<button class="button button-orange-light no-margin green" onclick="backPassword();" type="button" style="width: 50%;">Regresar</button></div>';
                     	$('#msg-confirmacion').html(msgError);
                     	openModal("#popup","");
                		//jAlert(a.message);
                		try {
                			mailError(a.message);			
            			} catch (e) {
            				console.error(e);
            			}
                		
                	}
                	
                }
                $('#btn-send').prop('disabled', false);
                $("#btn-send").css({"background-position": "0 0"});
            }
        })
    });
    $('#frm-user-send2').on('submit', function(b) {
        var $form = $(this);
        var ico = $(this).siblings('i');
        b.preventDefault();
        $.ajax({
            url: $(this).attr('action'),
            data: $(this).serialize(),
            type: $(this).attr('method'),
            dataType: 'json',
            beforeSend: function() {
                $('#btn-accept').prop('disabled', true);
                $("#btn-accept").css({"background-position": "0 -35px"});
                $('#btn-cancel').prop('disabled', true);
                $("#btn-cancel").css({"background-position": "0 -35px"});
                $(ico).addClass('loading-ilot');
            },
            error: function() {
            	$(ico).removeClass('loading-ilot');
            	var message='¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.';
                jAlert(message);
                $('#btn-accept').prop('disabled', false);
                $("#btn-accept").css({"background-position": "0 0"});
                $('#btn-cancel').prop('disabled', false);
                $("#btn-cancel").css({"background-position": "0 0"});
                try {
                	passworError(message);				
    			} catch (e) {
    				console.error(e);
    			}
                
            },
            success: function(a) {
            	$(ico).removeClass('loading-ilot');
                if (a.message === 'OK') {
                	if(a.lapolla!=null && $.trim(a.lapolla)!="") {
            			cadena = a.lapolla.split("|");
            			window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1]),"_parent");
                	} else if(a.tav2!=null && $.trim(a.tav2)!="") {
                			cadena = a.tav2.split("|");
                			window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1]),"_parent");
                	} else {
	                    //$('#send2').hide();
	                    //$('#send').hide();
	                    //jAlert(a.send);
	                    //window.location.href= 'juega-tinka.html';
	                    //jAlert(a.send, null, function(r){if(r){ window.location.href = 'juega-tinka.html'; }});
	                    //setTimeout(function() {window.location.href = 'juega-tinka.html';}, 3000);
                		var msgOk = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/Check.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">¡Contraseña cambiada!</span><br><br>'+
	                	'<p class="descripcion-ok">Vuelve a ingresar con tu usuario y </p>'+
	                	'<p class="descripcion-ok"> nueva contraseña </p><br><br>'+		                	
	                    '<button class="button button-orange-light no-margin green" onclick="goHome();" type="button" style="width: 50%;">OK</button></div>';
                		console.log(msgOk);
                           $('#msg-confirmacion').html(msgOk);
            				openModal("#popup","");
                	}
                	try {
                		passwordOk();				
        			} catch (e) {
        				console.error(e);
        			}
                	
                	
                } else{
                	if (a.message === 'KO') {
//                		var msjIgual = 'Verifica que tu nueva contraseña sea digitada por igual en Confirmar contraseña';
//                		jAlert(a.send);
//                		jAlert(msjIgual);
                		
                		var titulo = a.title;
	            		var mensaje = a.send;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
	                    $('#close-popup-message').hide();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
                		
                		try {
                			passworError(a.send);				
            			} catch (e) {
            				console.error(e);
            			}
                		
                	} else {
                		jAlert(a.message);
                		try {
                			passworError(a.message);				
            			} catch (e) {
            				console.error(e);
            			}
                	}
                	
                }
                $('#btn-accept').prop('disabled', false);
                $("#btn-accept").css({"background-position": "0 0"});
                $('#btn-cancel').prop('disabled', false);
                $("#btn-cancel").css({"background-position": "0 0"});
            }
        })
    })
};
$($restablecerUsers);

$('#btn-limpiar-contrasena').on('click', function(b) {
	$('#cod-autorizacion').val('');
	$('#new-pass').val('');
	$('#new-pass2').val('');
});


function mailError(label){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'restablecerPasswordError',
	    'category': 'UI :: Login',
	    'action': 'Error :: Restablecer Password',
	    'label': label
//	    'label': 'Correo no válido'  //Enviar el mensaje de error que corresponda
	});
	
	var tag="restablecerPasswordError";
	console.log("Taggin event: "+tag);
}

function newPassword(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageTitle': 'Generar Nuevo Password',
	    'pageUrl': '/restablecer-password/paso2/',
	    'category': 'UI :: Login',
	    'action': 'Restablecer Password',
	    'label': 'Generar nuevo password'
	});
	
	var tag="virtualPageView";
	console.log("Taggin event: "+tag);
	
}
function passworError(label){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'restablecerPasswordError',
	    'category': 'UI :: Login',
	    'action': 'Error :: Restablecer Password',
	    'label': label
//	    'label': '¡Ocurrio un problema inesperado!'  //Enviar el mensaje de error que corresponda
	});

	var tag="restablecerPasswordError";
	console.log("Taggin event: "+tag);

}

function passwordOk(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'passwordActualizado',
	    'category': 'UI :: Login',
	    'action': 'Restablecer Password',
	    'label': 'Password actualizado'
	});

	var tag="passwordActualizado";
	console.log("Taggin event: "+tag);

}

function userSent(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'usuarioEnviado',
	    'category': 'UI :: Login',
	    'action': 'Recordar Usuario',
	    'label': 'Usuario envíado'
	});

	var tag="usuarioEnviado";
	console.log("Taggin event: "+tag);

}

function userSentError(label){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'errorRecordarUsuario',
	    'category': 'UI :: Login',
	    'action': 'Error :: Recordar Usuario',
	    'label': label
//	    'label': 'Correo no ha sido registrado'  //Enviar el mensaje de error que corresponda
	});

	var tag="errorRecordarUsuario";
	console.log("Taggin event: "+tag);

}

/**
 * Render Tipo documento feature
 */
var renderDocumentFields = function () {
  var $select = $('#document-type'),
    $fields = $('.form__optional'),
    onChangeDocument;

  onChangeDocument = function () {
    var $input, isTipoDoc;

    switch ($select.val()) {
    case 'DNI':
      $input = $('#document-number');
      isTipoDoc = true;
      break;
    case 'PASAP':
      $input = $('#document-number-pasap');
      isTipoDoc = true;
      break;
    case 'CAREX':
      $input = $('#document-number-carex');
      isTipoDoc = true;
      break;
    case '':
      $input = $('#document-number');
      isTipoDoc = false;
      break;
    }

    $fields.hide(0);
    if (isTipoDoc) {
      $input.parent().show(0);
      $input.val('').attr('disabled', false).focus();
    } else {
      $input.parent().show(0);
      $input.val('').attr('disabled', true);
    }
  };

  $select.on('change', onChangeDocument);
};



function backPassword(){			
	window.location.href = 'recordar-usuario.html';  
}

	function goHome(){			
	window.location.href = 'inicio.html';  
}

	function goRegistro(){
		var operatorIdApi=$('#operatorIdApi').val();
		if(operatorIdApi==='5588'){
			window.location.href = $('#redirect558').val();
		}else{
			window.location.href = 'registro.html'; 
		}
	 
}

$('#document-number').on('input', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});
