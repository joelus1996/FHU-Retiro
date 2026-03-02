/*globals $, window, document, console, setTimeout, ga, google_tag_manager */
'use strict';

var METHOD = 'GET';
var configLoaded;
var actualizarCelularAgora=-1;
var flagrecarga="validated";
var timeoutTrMsg="Se ha detectado inoperatividad en tu sesión de recarga, por favor cierra la ventana de Cargar Saldo y vuelve acceder.";
//funcion tagging

function taggingErrorCodigoIn(){
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'errorCodigo',
	    'category': 'Form :: Registrate',
	    'action': 'Paso2 :: Error',
	    'label': 'Codigo incorrecto'
	});
 
	console.log("tagging registro error codigo");
	
}


function tagginReenvioSms(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageTitle': 'Reenviar SMS',
	    'pageUrl': '/registro/activar/reenvio_sms/',
	    'category': 'Form :: Registrate',
	    'action': 'Reenvio SMS',
	    'label': 'Activa tu cuenta'
	});
	console.log("tagging reenvio de sms");
}

function datalayerSendWhatsapp(){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({ 
		  'event': 'virtualEvent', 
		  'Proceso': 'Registro', 
		  'TipoEvento': 'Interacción', 
		  'TipoZona': 'Registro', 
		  'Zona': 'Registro', 
		  'SubZona': 'Activa tu cuenta', 
		  'Sección': 'Reenviar código – selección de canal', 
		  'SubSección': 'Paso 3', 
		  'TipoElemento': 'Button', 
		  'Intención': 'Registrarse', 
		  'CTA': 'WhatsApp', 
		  'Paso1': 0, 
		  'Paso2': 0, 
		  'Paso3': 1, 
		  'Paso4': 0, 
		  'ID_Juego': 0, 
		  'NombreJuego': '', 
		  'PagePath': operationId[$("#operatorIdApi").val()], 
		  'TimeStamp': new Date().getTime(), 
		  'TipoDispositivo': TipoDispositivo 
		}); 
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

function datalayerSendSMS(){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({ 
		  'event': 'virtualEvent', 
		  'Proceso': 'Registro', 
		  'TipoEvento': 'Interacción', 
		  'TipoZona': 'Registro', 
		  'Zona': 'Registro', 
		  'SubZona': 'Activa tu cuenta', 
		  'Sección': 'Reenviar código – selección de canal', 
		  'SubSección': 'Paso 3', 
		  'TipoElemento': 'Button', 
		  'Intención': 'Registrarse', 
		  'CTA': 'SMS', 
		  'Paso1': 0, 
		  'Paso2': 0, 
		  'Paso3': 1, 
		  'Paso4': 0, 
		  'ID_Juego': 0, 
		  'NombreJuego': '', 
		  'PagePath': operationId[$("#operatorIdApi").val()], 
		  'TimeStamp': new Date().getTime(), 
		  'TipoDispositivo': TipoDispositivo  
		}); 
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

function tagginActivarCuenta(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageTitle': 'Activa tu cuenta',
		    'pageUrl': '/registro/activar/',
		    'category': 'Form :: Registrate',
		    'action': 'Paso2 :: Continuar',
		    'label': 'Activa tu cuenta'
		});

		console.log("tagging tagginActivarCuenta");
	}catch(e){
		console.log(e);
	}
	
}

function tagginFelicitaciones(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageTitle': 'Felicitaciones Cuenta Activada',
	    'pageUrl': '/registro/cuenta-activada/',
	    'category': 'Form :: Registrate',
	    'action': 'Paso3',
	    'label': 'Cuenta activada'
	});

	console.log("tagging felicitaciones");
}




function validarMonto(){
	var montoPorDia=0;
  	 var valorIngresado=$("#monto_visanet").val();
  	 var valorInt=parseInt(valorIngresado);
  		$.ajax({
            type: "POST",
            url: "montoPorDia.html",
            dataType: "json",
            async: false,
            success: function (e) {
            	montoPorDia=e+parseInt(valorIngresado);
       	}    		
	}); 		
	return montoPorDia;	
}

function validarMontoAgora(){
	var montoPorDia=0;
  	var valorIngresado=$("#monto_agora").val();
  	var valorInt=parseInt(valorIngresado);
	$.ajax({
        type: "POST",
        url: "montoPorDiaAgora.html",
        dataType: "json",
        async: false,
        success: function (e) {
        	montoPorDia=e+parseInt(valorIngresado);
           	}    		
    	}); 		
  		return montoPorDia;	
}
//retirar este script tag antiguo
//function gaEvent(category, action, label, value) {
//  try {
//	  if (typeof ga === 'function') {
//		    var command = '';
//		    if (typeof google_tag_manager !== 'undefined') {
//		      command = ga.getAll()[0].get('name') + '.';
//		    }
//		    command += 'send';
//
//		    ga(command, 'event', {
//		      'eventCategory': category,
//		      'eventAction': action,
//		      'eventLabel': label,
//		      'eventValue': typeof value === 'undefined' ? 1 : value
//		    });
//
//		  } else {
//		    //console.log('ga() not defined');
//	  }
//	} catch (e) {
//
//	}
//}

/**
 * Get parameter from URL
 * @param {String} param  name of parameter
 */
var getUrlParameter = function (param) {
  var sPageURL = decodeURIComponent(window.location.search.substring(1)),
    sURLVariables = sPageURL.split('&'),
    sParameterName,
    i;

  for (i = 0; i < sURLVariables.length; i = i + 1) {
    sParameterName = sURLVariables[i].split('=');

    if (sParameterName[0] === param) {
      return sParameterName[1] === undefined ? true : sParameterName[1];
    }
  }
};

var scrollToTop = function() {
  $('html, body').animate({ scrollTop: 0 });
};

var resizeIframes = function () {
  var $iframes = $('iframe.ilotframe');
  $iframes.each(function () {
    this.style.height = this.contentWindow.document.body.offsetHeight + 'px';
  });
};

/**
 * Autoresize iframes when load content
 */
var initIframes = function () {
  var $iframes = $('iframe.ilotframe');
  $iframes.on('load', function () {
    this.style.height = this.contentWindow.document.body.offsetHeight + 'px';
  });
};

var isInIframe = function () {
  try {
    return window.self !== window.top;
  } catch (e) {
    return true;
  }
};

/**
 * Render template using object params
 * @param   {string} html html template to render
 * @param   {object} obj  Object with properties to replace
 * @returns {string} Html string
 */
var renderTemplate = function (html, obj) {
  var t = html,
    lWrap = '\\{\\{',
    rWrap = '\\}\\}',
    re = new RegExp(lWrap + '(\\w+)' + rWrap, 'g'),
    keys = t.match(re),
    onlyUnique,
    clearKeys,
    parseTemplate;

  onlyUnique = function (value, index, self) {
    return self.indexOf(value) === index;
  };

  clearKeys = function (key) {
    return key.replace(re, '$1');
  };

  parseTemplate = function (key) {
    if (Object.prototype.hasOwnProperty.call(obj, key)) {
      t = t.replace(new RegExp(lWrap + key + rWrap, 'g'), obj[key]);
    }
  };

  if (keys && keys.length > 0) {
    keys.filter(onlyUnique).map(clearKeys).forEach(parseTemplate);
  }

  return t;
};

/**
 * Render Grid based on URL parameter
 */
var renderGridView = function () {
  var showgrid = getUrlParameter('showgrid');
  if (showgrid === '1') {
    $('.gridview').show();
  }
};

/**
* Render all form fields (select, input, checkbox)
*/
var renderFormFields = function () {
  // pulldown
  $(".form__select select").each(function () {
    var $this = $(this),
      $pull = $this.parent();

    if ($pull.find("div").length === 0) {
      $pull.prepend("<div></div>");
    }

    if ($this.val() === "") {
      $pull.removeClass("selected");
    } else {
      $pull.children("div").text($this.children(":selected").text());
      $pull.addClass("selected");
    }

    $this.on('change', function () {
      $pull.children("div").text($this.children(":selected").text());
      if ($this.val() === "") {
        $pull.children("div").text('');
        $pull.removeClass("selected");
      } else {
        $pull.children("div").text($this.children(":selected").text());
        $pull.addClass("selected");
      }
    });
  });

  // input
  $(".form__input input, .form__area textarea").each(function () {
    var $input = $(this),
      $parent = $input.parent();

    if ($input.val() !== '') {
      $parent.addClass('filled');
    }

    $input.on('focus', function () {
      $parent.addClass('focus filled');
    });

    $input.on('blur', function () {
      if ($input.val() === '' && !$parent.hasClass('form__input-calendar')) {
        $parent.removeClass('focus filled');
      } else {
        $parent.removeClass('focus');
      }
    });
  });

  // checkbox
  $('.form__check input').on("click", function () {
    var $this = $(this);
    if ($this.is(":checked")) {
      $this.parent().addClass('checked');
    } else {
      $this.parent().removeClass('checked');
    }
  }).each(function () {
    var $this = $(this);
    if ($this.find('input').is(":checked")) {
      $this.addClass("checked");
    } else {
      $this.removeClass("checked");
    }
  }).each(function () {
    var $this = $(this);
    if ($this.is(":checked")) {
      $this.parent().addClass("checked");
    } else {
      $this.parent().removeClass("checked");
    }
  });

  // options
  var $thisOption,
    $thisInput = $('#horario');

  $('.form__opts-list-item').on('click', function () {
    if ($thisOption) {
      $thisOption.removeClass('checked');
    }
    $thisOption = $(this);
    $thisOption.addClass('checked');
    $thisInput.val($thisOption.find('.icon').attr('data-value'));
  });
};

/**
 * Render calendar over date field
 */
var renderDateField = function () {
  var $input = $('#dateBirth');
  var bdate = new Date();
  var sdate = new Date();
  bdate.setFullYear(bdate.getFullYear() - 18);
  sdate.setFullYear(sdate.getFullYear() - 100);

  $input.datepicker({
    language: 'es-ES',
    offset: 8,
    startDate: sdate,
    endDate: bdate,
    autoHide: true,
    //trigger: '#dateBirth'
  });

  $input.on('show.datepicker', function () {
    //$input.trigger('focus');
  });
  $input.on('hide.datepicker', function () {
	  $input.trigger('blur');
  });
};

/**
 * Render Tipo documento feature
 */
var renderDocumentFields = function () {
  var $select = $('#typeDoc'),
    $fields = $('.form__optional'),
    onChangeDocument;

  onChangeDocument = function () {
    var $input, isTipoDoc;

    switch ($select.val()) {
    case 'DNI':
      $input = $('#numberDoc');
      isTipoDoc = true;
      break;
    case 'PASAP':
      $input = $('#documento-pasap');
      isTipoDoc = true;
      break;
    case 'CAREX':
      $input = $('#documento-carex');
      isTipoDoc = true;
      break;
    case '':
      $input = $('#numberDoc');
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

/**
 * Show / Hide password
 */
var renderPasswordField = function () {
  var $input = $('#password'),
    $field = $input.parent(),
    $toggle = $('#toglePassword'),
    onTogglePassword;

  onTogglePassword = function () {
    $field.toggleClass('viewing');
    if ($field.hasClass('viewing')) {
      $input.attr("type", "text");
    } else {
      $input.attr("type", "password");
    }
  };

  $toggle.on('click', onTogglePassword);
};

/**
 * Send data to register user
 */
var submitRegisterForm = function () {
	
  var $form = $('#client_lotocard_register_form'),
    $button = $('#resgisterUser'),
    urlRegister = $form.attr('action');
  	$button.attr('disabled', true);  
};

var renderTermsField = function () {
  var $input = $('#terms'),
    $form = $('#client_lotocard_register_form'),
    onChangeTerms;
  
  var $name = $('#name');
  var $appaterno = $('#lastname');
  var $documentnumber = $('#numberDoc');
  var $documentopasap = $('#documento-pasap');
  var $documentocarex = $('#documento-carex');
  var $fechanac = $('#dateBirth');
  var $userclient = $('#user');
  var $passwordclient = $('#password');
  var $email = $('#email');
  var $mobilephone = $('#mobilePhone');
  var $nacionalidad = $('#nacionalidad');
  var $domicilio = $('#domicilio');
  var $departamento = $('#departamento');
  var $provincia = $('#provincia');
  var $distrito = $('#distrito');
  var $namemsg = $('#name_msg');
  var $appaternomsg = $('#last_name_msg');
  var $fechanacmsg = $('#dateBirth_msg');
  var $documentnumbermsg = $('#numberDoc_msg');
  var $document_numbercarexmsg = $('#documento_carex_msg');

	  onChangeTerms = function() {

		if ($form.isValid({}, {}, false)) {
			if ($namemsg.text() === ""
				&& $appaternomsg.text() === ""
				&& $fechanacmsg.text() === ""
				&& $documentnumbermsg.text() !== "INGRESE UN DNI VÁLIDO"
				&& $document_numbercarexmsg.text() !== "INGRESE UN CARNET DE EXTRANJERÍA VÁLIDO") {
			$('#resgisterUser').attr('disabled', false);
			}
		} else {
			$('#resgisterUser').attr('disabled', true);
		}
	};
	
	  
  $input.on('change', onChangeTerms);
  
  $name.on('keyup', onChangeTerms);
  $appaterno.on('keyup', onChangeTerms);
  $documentnumber.on('keyup', onChangeTerms);
  $documentopasap.on('keyup', onChangeTerms);
  $documentocarex.on('keyup', onChangeTerms);
  $fechanac.on('keyup', onChangeTerms);
  $userclient.on('keyup', onChangeTerms);
  $passwordclient.on('keyup', onChangeTerms);
  $email.on('keyup', onChangeTerms);
  $mobilephone.on('keyup', onChangeTerms);
  $nacionalidad.on('change', onChangeTerms);
  $domicilio.on('keyup', onChangeTerms);
  $departamento.on('change', onChangeTerms);
  $provincia.on('change', onChangeTerms);
  $distrito.on('change', onChangeTerms);
  
};

/**
 * Render form: Registro
 */
var validateMessagges = function () {
	  var nameMsgFilled = $('#name_msg').text().trim() === '';
	  var lastNameMsgFilled = $('#last_name_msg').text().trim() === '';
	  var dateBirthMsgFilled = $('#dateBirth_msg').text().trim() === '';
	    
	  if(nameMsgFilled && lastNameMsgFilled && dateBirthMsgFilled){
		  return true;
	  }
	  
	  return false;
}

var renderRegisterForm = function () {
  // render fields
  var validateInputReg, validateInputReg2, validateInputReg3, validateInputReg4;
  renderDocumentFields();
  renderDateField();
  renderPasswordField();
  renderTermsField();

  // restrict fields
//  $('#name, #lastname').alpha({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//  $('#user, #documento-pasap, #documento-carex').alphanum({allowSpace: false, disallow:'``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//  $('#email').alphanum({allowSpace: false, allow : '-_+@.'});
  $("#mobilePhone, #numberDoc").numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
  $('#dateBirth').alphanum({allow: '/', allowUpper: false, allowLower: false});

  $('#dateBirth').mask('00/00/0000');
  
//  $('#domicilio').alphanum({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©', allow : '#.,-'});
  
  validateInputReg = function () {
	  // Obtiene el valor actual del campo
      var inputValue = $(this).val();

      // Elimina caracteres no permitidos
      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ\s]/g, '');
      
      // Actualiza el valor del campo
      $(this).val(inputValue);
  };
  $('#name, #lastname').on('input', validateInputReg);
  
  validateInputReg2 = function () {
	  // Obtiene el valor actual del campo
      var inputValue = $(this).val();

      // Elimina caracteres no permitidos
      inputValue = inputValue.replace(/[^a-zA-Z\d]/g, '');
      
      // Actualiza el valor del campo
      $(this).val(inputValue);
	};
	$('#user, #documento-pasap, #documento-carex').on('input', validateInputReg2);
	
	validateInputReg3 = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();

	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-Z\d-_+@.]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
		};
		$('#email').on('input', validateInputReg3);
		
	validateInputReg4 = function () {
	  // Obtiene el valor actual del campo
      var inputValue = $(this).val();

      // Elimina caracteres no permitidos
      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\s#°.,-\d]/g, '');
      
      // Actualiza el valor del campo
      $(this).val(inputValue);
	};
	$('#domicilio').on('input', validateInputReg4);
  
  // validate fields
  $.validate({
    form: '#client_lotocard_register_form',
    modules: 'security, date, logic',
    scrollToTopOnError: false,
    onModulesLoaded: function () {
      var config = {
        bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@).</span>',
        weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@).</span>',
        good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
        strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
      };
      $('#password').displayPasswordStrength(config);
    },
    onElementValidate : function(valid, $el, $form) {
      if ($form.isValid({}, {}, false) ) {
    	  if(validateMessagges()){
    	        $('#resgisterUser').attr('disabled', false); //pintarse el boton guardado
    	  }else{
    	        $('#resgisterUser').attr('disabled', true); 
    	  }
      } else{
        $('#resgisterUser').attr('disabled', true); // inhabilitar boton guardado
      }
    },
    onError: function ($form) {
      var $error = $form.find('.has-error');
      if ($error.length > 0) {
        $error = $error.first();
        $('html, body').animate({ scrollTop: $error.offset().top - 16 });
      }
    },
    onSuccess: function () {
      submitRegisterForm();
      return false;
    }
  });
};

/**
 * Render form: activación
 */
var renderActivateForm = function () {
	window.location.hash="no-back-button";
	window.location.hash="Again-No-back-button";//esta linea es necesaria para chrome
	window.onhashchange=function(){
		
		window.location.hash="no-back-button";
		}
	
	var cel = $("#celhidden").val();
	if(cel==undefined || cel==null || cel==''){
	  location.href=$("#redirectHome").val();
	}
	
	 $.ajax({
			type: "post",
	        url: "validation-activation.html",
	        dataType: "jsonp",
	        async:false,
	        success: function (e) {
	        	if(e.mobileSmsStatus!=undefined && e.mobileSmsStatus=="ACT"){
	        		location.href=$("#redirectHome").val();
	        	}
	        }
	  });
	
  var $form = $('#form_activate'),
    $inputs = $(".form__code input"),
    $button = $('#btactivate'),
    $gotoLink = $('#gotoResendCode'),
    urlActivate = $form.attr('action'),
    onChangeCode,
    validateCode,
    onSubmitActivate,
    onResendCode;

  onChangeCode = function (e) {
    var $input = $(this),
      tcode = $input.val(),
      tindex = parseInt($input.attr('tabindex'), 10);

    if (e.type === 'keydown') {
      // keydown
      if (e.keyCode === 46 || e.keyCode === 8) {
        if (tcode === '') {
          $inputs.filter('[tabindex="' + (tindex - 1) + '"]').focus();
        }
      }
    } else {
      // keyup
      if (tcode !== '') {
        $inputs.filter('[tabindex="' + (tindex + 1) + '"]').focus();
      }
    }

    validateCode();
  };

  validateCode = function () {
    $button.attr('disabled', false);
    $inputs.each(function () {
      if ($(this).val() === '') {
        $button.attr('disabled', true);
        $form.removeClass('error-activate');
      }
    });
  };

  onSubmitActivate = function (e) {
    e.preventDefault();

    var ico = $("#cargando");
    $(ico).addClass('loading');
    
    $button.attr('disabled', true);
    var cod01 = $("#code-01").val();
    var cod02 = $("#code-02").val();
    var cod03 = $("#code-03").val();
    var cod04 = $("#code-04").val();
    var cod05 = $("#code-05").val();
    var code = cod01 + cod02 + cod03 + cod04 + cod05;
    
    if(code.toString().trim()==""){
        $('#alertCodeVerify').html("Ingrese un c&oacute;digo v&aacute;lido");
		return false;
    }

    var $frm = $("#form_activate");
    $.ajax({
        type: $frm.attr('method'),
        url: 'send-code-validation.html',
        data: "send-code="+code,
        dataType: $frm.data('response-type'),
        success: function(e){ 
        	$('#alertCodeNotify').html("");
        	$('#alertCodeVerify').html("");
        		if(e.status==1){       			
        			//gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - verificar');
            		$("#top_message").html("");
            		$("#top-message").css("display","none");
            		$("#celhidden").val("");
                    //$('.step-01').fadeOut(150, function () { $('.step-03').fadeIn(250); });              
                    $('body').find('#cargando').remove();
                    tagginFelicitaciones();
                    datalayerActivate();
                    $.ajax({
			            type: "POST",
			            url: "redirectAccountActive.html",
			            dataType: "json",
			            data: "data=0",
			    	})
			    	.done(function(data) {
			    		console.log("redirect: "+$("#operatorId").val());
		        		if( $.trim($("#operatorId").val())=="5588" ){//TA
		        			$('.step-01').fadeOut(150, function () { $('.step-03').fadeIn(250); })
		        			setTimeout(function() { toTAV2(); }, 1000);
		        		}else if( $.trim($("#operatorId").val())=="5587" ){//LA POLLA
		        			$('.step-01').fadeOut(150, function () { $('.step-03').fadeIn(250); })
		        			setTimeout(function() { toLaPolla(); }, 1000);
		        		}else{//LA TINKA
		        			setTimeout(function() { location.href = "bienvenido.html"; }, 100);
		        		}	
			    	})
			    	.fail(function( jqXHR, textStatus, errorThrown ) {
			        	console.log(errorThrown);
			        });
        		} else {
        			
        			$("#msjError").html(e.message);
            		$('#form_activate').addClass('error-activate');
            		taggingErrorCodigoIn();
            		datalayerErrores('Activa tu Cuenta','Paso 2','Activar Cuenta');
            		
        		}
            }
        }).always(function() {
        	 $(ico).removeClass('loading');
        });
    return false;
  };

  onResendCode = function (e) {
    e.preventDefault();
  
   // gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - reenviar codigo por sms');
    $('#form_activate').removeClass('error-activate');
    $("#form_resend").removeClass('error-activate');
    $('.step-01').fadeOut(150, function () { $('.step-02').fadeIn(250); });
    
    tagginReenvioSms();
  };

  $inputs.numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
  $inputs.on('keyup keydown', onChangeCode);
  $form.on('submit', onSubmitActivate);
  $gotoLink.on('click', onResendCode);
};

/**
 * Send data to resend activation code
 */
var submitResendForm = function () {
	  var $form = $('#form_resend'),
	    $disclaimer = $('#disclaimer'),
	    $button = $('#btresend'),
	    urlResend = $form.attr('action');

	  $button.attr('disabled', true);

	  var phone = $.trim($("#telf-sms").val());
	  var phonePattern = new RegExp(/^([9]{1})([0-9]{8})$/);
	  var phoneRes = phonePattern.test(phone);
		if(!phoneRes && $("#telf-sms1").length>0 && $("#telf-sms").length<=0){
		  phoneRes=true;
	  }
	  if(phoneRes){
		var ico = $("#cargando");
		$(ico).addClass('loading');
			
		var $frm = $("#form_resend");
		  
		$.ajax({
	          type: $frm.attr('method'),
	          url: 'send-sms-validation.html',
	          data: $frm.serialize(),
	          dataType: $frm.data('response-type'),
	          success: function(e){            
      	if(e.status===200) {
      		$('#btactivate').attr('disabled', true);
            $(".form__code input").val('');
            $('#btresend').attr('disabled', false);
            
            var phoneMasked = phone.substring(0, 2) + '*****' + phone.substring(7);
            $('#celSMS').html(phoneMasked);
            
//      		gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - enviar sms');
      	    $('#form_activate').removeClass('error-activate');
      	    $("#form_resend").removeClass('error-activate');
            $('.step-02').fadeOut(150, function () { $('.step-01').fadeIn(250); });
    	   	$(ico).removeClass('loading');
            tagginViewActivar();			
            
      	}else{
      		$("#msjErrorSendCode").html(e.message);
      		$form.addClass('error-activate');
      		$('#btresend').attr('disabled', false);
      		$(ico).removeClass('loading');
      	}
      }
	    }).always(function() {
	    });

	  } else {
	$("#msjErrorSendCode").html("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.");
	$form.addClass('error-activate');
	$disclaimer.addClass('has-error');
	$(ico).removeClass('loading');
}
	};



	var submitResendFormWa = function () {
		  var $form = $('#form_resend'),
		    $disclaimer = $('#disclaimer'),
		    $button = $('#btresendwa'),
		    urlResend = $form.attr('action');

		  $button.attr('disabled', true);

		  var phone = $.trim($("#telf-sms").val());
		  var phonePattern = new RegExp(/^([9]{1})([0-9]{8})$/);
		  var phoneRes = phonePattern.test(phone);
			
	    if(!phoneRes && $("#telf-sms1").length>0 && $("#telf-sms").length<=0){
		  phoneRes=true;
	    }
		  if(phoneRes){
			var ico = $("#cargando");
			$(ico).addClass('loading');
				
			var $frm = $("#form_resend");
			  
			$.ajax({
		          type: $frm.attr('method'),
		          url: 'send-wa-validation.html',
		          data: $frm.serialize(),
		          dataType: $frm.data('response-type'),
		          success: function(e){              
	          	if(e.status===200) {
	          		$('#btactivate').attr('disabled', true);
	                $(".form__code input").val('');
	                $('#btresendwa').attr('disabled', false);
	                
	                var phoneMasked = phone.substring(0, 2) + '*****' + phone.substring(7);
	                $('#celSMS').html(phoneMasked);
	                
//	          		gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - enviar sms');
	          	    $('#form_activate').removeClass('error-activate');
	          	    $("#form_resend").removeClass('error-activate');
	                $('.step-02').fadeOut(150, function () { $('.step-01').fadeIn(250); });
	   		   	 	$(ico).removeClass('loading');
	                tagginViewActivar();			
	                
	          	}else{
	          		$("#msjErrorSendCode").html(e.message);
	          		$form.addClass('error-activate');
	          		$('#btresendwa').attr('disabled', false);
	          		$(ico).removeClass('loading');
	          	}
			       }
		    }).always(function() {
		    });
		  }else{
		$("#msjErrorSendCode").html("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.");
		$form.addClass('error-activate');
		$disclaimer.addClass('has-error');
		$(ico).removeClass('loading');
		  }
		};

/**
* Render Form: Resend code
*/
		var renderResendCode = function () {
			  var $input = $('#telf-sms'),
			 	$disclaimer = $('#disclaimer'),
			    $linkBack = $('#backToActivate'),
			    onClickBack,onChangeCel;

			  $input.numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
			  
	      onChangeCel = function () {
			    if ($("#form_resend").isValid({}, {}, false)) {
			      $('#btresend').attr('disabled', false);
			      $('#btresendwa').attr('disabled', false);
				  $disclaimer.removeClass('has-error');
			    } else {
			      $('#btresend').attr('disabled', true);
			      $('#btresendwa').attr('disabled', true);
				  $disclaimer.addClass('has-error');
			    }
			  };

			  $input.on('keyup', onChangeCel);

			   $('#form_resend button[type=submit]').click(function () {
			    $('#form_resend button[type=submit]').removeAttr('clicked');
			    $(this).attr('clicked', 'true');
			  });
			  
			  // validate fields
			  $.validate({
			    form : '#form_resend',
			    onError : function () {
			      //console.log('Error');
			    },
			    onSuccess : function () {
			    	var clickedButton = $('#form_resend button[type=submit][clicked=true]').attr('id');
			    	if (clickedButton === 'btresendwa') {
			    	    submitResendFormWa();// Llama función para WhatsApp
			    		datalayerSendWhatsapp();
			    	    return false;
			    	  } else {
			    	    submitResendForm();// Llama función para SMS
			    		datalayerSendSMS();
			    	    return false;
			    	  }
			    	}
			  });

			  onClickBack = function (e) {
				 
			    e.preventDefault();
			    //gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - ya tengo codigo verificacion');

			    // reset form
			    $('#btactivate').attr('disabled', true);
			    $(".form__code input").val('');

			    $("#form_resend").removeClass('error-activate');
			    $('#form_activate').removeClass('error-activate');
			    $('.step-02').fadeOut(150, function () { $('.step-01').fadeIn(250); });
			    tagginActivarCuenta();
			  };

			  $linkBack.on('click', onClickBack);
			};


/**
 * Render tabs
 */
var renderTabs = function () {
  var $tabs = $('.tabs');

  $tabs.each(function () {
    var $tab = $(this),
      $links = $tab.find('> ul > li'),
      dataTabCategory = $tab.attr('data-category'),
      $currentTab,
      onSelectTab;

    onSelectTab = function (e) {
      e.preventDefault();
      var $link = $(this),
        dataLabel = $link.attr('data-label'),
        dataCategory = (dataTabCategory === undefined) ? $link.attr('data-category') : dataTabCategory;

      $links.removeClass('selected');
      $link.addClass('selected');
     // gaEvent(dataCategory, 'Clic', dataLabel);

      if ($currentTab) {
        $currentTab.fadeOut(150, function () {
          $currentTab = $($link.attr('data-target'));
          $currentTab.fadeIn(150, function () {
            if (isInIframe()) {
              //parent.resizeIframes();
            }
          });
        });
      } else {
        $currentTab = $($link.attr('data-target'));
        $currentTab.fadeIn(150, function () {
          if (isInIframe()) {
            //parent.resizeIframes();
          }
        });
      }
    };

    // events
    $links.on('click', onSelectTab);

    // init tabs
    $links.filter('.selected').trigger('click');
  });
};

/**
 * Render accordion
 */
var renderAccordion = function () {

      $('.accordion .accordion__title').on('click', function () {
        var li = $(this),
          li = $(this).parent(),
          content = li.find('.subcontent'),
          sibling = li.siblings();

          if (!li.hasClass('opened')) {
            content.slideDown(300, function () {
              li.addClass('opened');
            });
          } else {
            content.slideUp(300, function () {
              li.removeClass('opened');
            });
          }

          sibling.find('.subcontent').slideUp(300);
          sibling.removeClass('opened');
      });

};

/**
 * Render Recharge Forms
 */
var renderRechargeForms = function () {
  var $forms = $('form.form'),
    tplRechargeHead = document.getElementById('tpl-recharge-head').innerHTML,
    tplRechargeItem = document.getElementById('tpl-recharge-item').innerHTML,
    tplRechargeBBVAHead = document.getElementById('tpl-recharge-head-bbva').innerHTML,
    tplRechargeBBVAItem = document.getElementById('tpl-recharge-item-bbva').innerHTML,
    renderTableRecharge,grillaCode,renderizarBCP, renderTableRechargeBBVA, generarCodigoBBVA, renderizarBBVA, 
    listarCodigosBBVA;

  // restrict fields
  $('input[name="monto"]').numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
  $('input[name="codigo"]').alphanum({allowSpace: false});
  $('input[name="lotocard"]').numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
  $('input[name="celular"]').numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});

  // helper methods
  renderTableRecharge = function (items, $table) {
    var html = '';
    if (items.length > 0) {
      html += renderTemplate(tplRechargeHead, {});
      items.forEach(function (item) {
        html += renderTemplate(tplRechargeItem, {amount: item.amount, code: item.code, date: item.date, urlvalidate: item.urlvalidate, urlcancel: item.urlcancel});
      });

      $table.html(html);
      $table.fadeIn(200);
    }
  };
  
  renderTableRechargeBBVA = function (items, $table) {
    var html = '';
    if (items.length > 0) {
      html += renderTemplate(tplRechargeBBVAHead, {});
      items.forEach(function (item) {
        html += renderTemplate(tplRechargeBBVAItem, {amount: item.amount, code: item.code, date: item.date, urlvalidate: item.urlvalidate, urlcancel: item.urlcancel});
      });

      $table.html(html);
      $table.fadeIn(200);
    }
  };
  
  $('#grillaBCP').on('click', '.bcpverify', function (event) {	 
	  var $btnVerificar = $(this);
	  var price=$btnVerificar.parents('.row_grid').text().split(/\n/)[1].trim();
	  var code=$btnVerificar.parents('.row_grid').text().split(/\n/)[2].trim();
	  var date=$btnVerificar.parents('.row_grid').text().split(/\n/)[3].trim();
      
      var amount = $("#clientSale-amount").text().replace(',','');
      var trx = $(this).data('pin');
      var vurl="verificar.html";    	
  	  var rechargetoken = $('#rechargetoken').val();
  	  var vheaders={};
  	  if(rechargetoken!=null && rechargetoken!=""){
  		  vurl="verificar-rt.html";
  		  vheaders={"rechargetoken":$('#rechargetoken').val()};
  	  }
      $.ajax({
          type: "GET",
          url: vurl,
          headers: vheaders,
          dataType: "json",
          data: {
        	  amount: amount,
              pin: trx
          },
          beforeSend: function () {
           	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
	      },
	      error: function () {
	       	$('body').find('#cargando').remove();
	       	tagginSaldoErrorRecarga('Internet BCP', '¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
	      },
          success: function (data) {
              if (data.state === 'OK') {
            	  if(rechargetoken!=null && rechargetoken!=""){
                 		loadRechargeRT(flagrecarga);
               	  }else{
               		  loadRecharge();
               	  }
                  grillaCode(null,null,null,false,false,false,null,null,null,null,null,null,null,null,null);
                  tagginSaldoBCPEEcheckout(price);
                  tagginSaldoBCPEEpurchase(code, date, price);
              }else{
            	  if(data.state=='TIMEOUTTR'){
            		  data.message=timeoutTrMsg;
            	  }
            	  tagginSaldoErrorRecarga('Internet BCP', $("<div/>").html(data.message).text());
              }
              $('body').find('#cargando').remove();
              alertMessage("<div class='info'></div><p>"+data.message+"</p>");
          }
      })
  });
  
  $('#grillaBCP').on('click', '.bcpdelete', function (event) {	 
	  var $btnAnular = $(this);
      $.ajax({
          type: 'post',
          url: 'anular.html',
          dataType: 'text',
          data: {
              pin: $(this).data('pin')
          },
          beforeSend: function () {
        	  $('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
  	      },
  	      error: function () {
  	    	  $('body').find('#cargando').remove();
  	      },
          success: function (data) {
        	  $('body').find('#cargando').remove();
        	  $btnAnular.parents('.row_grid').remove()
        	  var price=$btnAnular.parents('.row_grid').text().split(/\n/)[1].trim();
              tagginSaldoBCPEEremoveFromCart(price);
          }
      });
      if ($('#grillaBCP').find('.bcpdelete').length == 1) {
          $('#grillaBCP').html('');
      }
  });
  
  renderizarBCP = function (data){
	  //getGrillaBCP();//obtener la grilla a verificar
  	  var fila = data.split("||");
	  if (fila.length > 0 && fila[0] != '') {
		  var html = '';
	  	  var $tableCodes = $("#grillaBCP");
	  	  html += renderTemplate(tplRechargeHead, {});
		  for (var n = (fila.length-1); n >= 0 ; n--) {
			  var items = fila[n].split("|");
	          if (items.length > 0) {
	        	  if (items[3] === "PEN") {
	        		  html += renderTemplate(tplRechargeItem, {amount: items[1], code: items[0], date: items[2].substring(0, 10), urlvalidate: "bcpverify", urlcancel: "bcpdelete", pin: items[4]});
	        	  }
	          }
		  }       		
			
		  $tableCodes.html(html);
		  $tableCodes.fadeIn(200);
	  }else{
		  var $tableCodes = $("#grillaBCP");
		  $tableCodes.html('');
	  }
	  //taggingCheckoutAndPurchaseBCP();
  };
  
  grillaCode = function (event,amount, transact, actbono, actwbbono,recharge,spanValid,btValidate,divError,form,inputStatusCode,inputIdCode,inputMonto,inputCode,btRecharge,channel) {
	  	if (!$('#accordion_bcp').hasClass('opened') || (recharge!==undefined && (recharge===false || recharge===true) )) {
	  		if(!recharge){
	  			var data = '';
	  	        var msgres = [];	  	        
	  	        var vurl="check-transaction-bcp.html";    	
	        	var rechargetoken = $('#rechargetoken').val();
	        	var vheaders={};
	        	if(rechargetoken!=null && rechargetoken!=""){
	        		vurl="check-transaction-bcp-rt.html";
	        		vheaders={"rechargetoken":$('#rechargetoken').val()};
	        	}
	  	        $.ajax({
	  	            type: "post",
	  	            url: vurl,
	  	            headers: vheaders,
	  	            dataType: "text",
	  	            data: "",
	  	            beforeSend: function () {
		            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
			        },
			        error: function () {
			        	$('body').find('#cargando').remove();
			        },
	  	            success: function (e) {
	  	            	msgres=e;
	  	            	if(msgres=='TIMEOUTTR'){
	  	            		$('body').find('#cargando').remove();
	  	            		alertMessage(timeoutTrMsg);
	  	            	}else{
	  	            		msgres = $.trim(e.toString()).split("|||");
		  	                data = msgres[0];
		  	                renderizarBCP(data);
		  	                $('body').find('#cargando').remove();
	  	            	}
	  	                
	  	            }
	  	        });
	  		}else{
  		  		var maximoCodigosBCP = $("#maximoCodigosBCP").val();
  		  		if(maximoCodigosBCP==undefined || maximoCodigosBCP==null || maximoCodigosBCP==''){
  		  			maximoCodigosBCP = 3;
  		  		}else{
  		  			maximoCodigosBCP = parseInt(maximoCodigosBCP);
  		  		}
  		  		if($('#grillaBCP').find('.row_grid').length>=maximoCodigosBCP){
  		  			btRecharge.attr('disabled', false);
  		  			alertMessage("Haz alcanzado el límite máximo de códigos BCP generados.");
  		  			return;
  		  		}
	  		 
				var notificacion='';
		        var data = '';
		        var message = '';
		        var newamount = 0.0;
		        var msgres = [];
		        var codePromotional = "";
	  	        if (inputCode!=undefined) {
	  	        	codePromotional=inputCode.val();
	  	        }	  	    
		  	    if(channel===undefined){
		  	    	channel="";
		  	    }
	  		  	
	  			if(amount===undefined){
		  			amount="";
			    }
			    
			    if(transact===undefined){
			    	transact="";
			    }
			    
			    if(actbono===undefined){
			    	actbono="";
			    }
			    
			    if(actwbbono===undefined){
			    	actwbbono="";
			    }
			    
			    var vurl="verifica-codigo-bcp.html";    	
	        	var rechargetoken = $('#rechargetoken').val();
	        	var vheaders={};
	        	if(rechargetoken!=null && rechargetoken!=""){
	        		vurl="verifica-codigo-bcp-rt.html";
	        		vheaders={"rechargetoken":$('#rechargetoken').val()};
	        	}
		  		
		        $.ajax({
		            type: "post",
		            url: vurl,
		            headers: vheaders,
		            dataType: "text",
		            data: "codePromotional="+codePromotional+"&channel="+channel+"&lotocard="+''+
		            	"&bcp-amount=" + amount + "&bcp-transact=" + transact + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
		            beforeSend: function () {
		            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
			        },
			        error: function () {
			        	btRecharge.attr('disabled', false);
			        	$('body').find('#cargando').remove();
			        },
		            success: function (e) {
		                msgres = $.trim(e.toString()).split("|||");
		                data = msgres[0];
		                message = msgres[1];
		                newamount = msgres[2]; 
		                if(newamount != "-1" && newamount != null && newamount != "0.0") {
		                	$("#clientSale-amount").text(floatFormat(newamount));
		                	if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {		      	    	
		            			spanValid.fadeOut(150, function () {
		            				btValidate.fadeIn(200);
		            				btValidate.attr('code-sent', false)
		            				btValidate.attr('disabled', false);
		            				
		            				divError.html('');
		            				form.removeClass('error');
		            				inputStatusCode.val('DES');
		            				inputIdCode.val('-1');
		            			});
		            		}else{
		            			divError.html('');
		            			form.removeClass('error');
		            			inputStatusCode.val('DES');
		            			inputIdCode.val('-1');
		            		}
		            		inputMonto.val('');
		            		inputCode.val('');
				            notificacion="Para concretar el pago, cancele en BCP indicando el c&oacute;digo generado.";
				     		renderizarBCP(data)    
		                }
		                
		                if($.trim(message)!="" && amount!="") {
		                	if(message=='TIMEOUTTR'){
		                		message=timeoutTrMsg;
		                	}
				        	notificacion="<div class='info'></div><p>"+message+"</p>";
				        	btRecharge.attr('disabled', false);
				        }
				        if($.trim(notificacion)!="") alertMessage(notificacion);
				        $('body').find('#cargando').remove();
		            }
		        });
			    
			   
	  		}
	  	}
  };

  $('#accordion_bcp').on('click', grillaCode);
  
  generarCodigoBBVA = function (amount, actbono, actwbbono,spanValid,btValidate,divError,form,inputStatusCode,inputIdCode,inputMonto,inputCode,btRecharge,channel) {
  	if ($('#accordion_bbva').hasClass('opened') ) {
  		var maximoCodigosBBVA = $("#maximoCodigosBBVA").val();
  		if(maximoCodigosBBVA==undefined || maximoCodigosBBVA==null || maximoCodigosBBVA==''){
  			maximoCodigosBBVA = 3;
  		}else{
  			maximoCodigosBBVA = parseInt(maximoCodigosBBVA);
  		}
  		if($('#grillaBBVA').find('.row_grid').length>=maximoCodigosBBVA){
  			btRecharge.attr('disabled', false);
  			alertMessage("Haz alcanzado el límite máximo de códigos BBVA generados.");
  			return;
  		}
	 
		var notificacion='';
        var data = '';
        var message = '';
        var newamount = 0.0;
        var msgres = [];
        var codePromotional = inputCode.val();
        
        if (codePromotional==undefined) {
        	codePromotional='';
        }
	  	
		if(amount===undefined){
  			amount="";
	    }
	    		    
	    if(actbono===undefined){
	    	actbono="";
	    }
	    
	    if(actwbbono===undefined){
	    	actwbbono="";
	    }
	    
	    var vurl="genera-codigo-bbva-rt.html";  	
    	var rechargetoken = $('#rechargetoken').val();
    	var vheaders={"rechargetoken":$('#rechargetoken').val()};

        $.ajax({
            type: "post",
            url: vurl,
            headers: vheaders,
            dataType: "text",
            data: "codePromotional="+codePromotional+"&channel="+channel+"&lotocard="+''+
            	"&bbva-amount=" + amount + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
	        },
	        error: function () {
	        	btRecharge.attr('disabled', false);
	        	$('body').find('#cargando').remove();
	        },
            success: function (e) {
                msgres = $.trim(e.toString()).split("|||");
                data = msgres[0];
                message = msgres[1];
                newamount = msgres[2]; 
                if(newamount != "-1" && newamount != null && newamount != "0.0") {
                	$("#clientSale-amount").text(floatFormat(newamount));
                	if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {		      	    	
            			spanValid.fadeOut(150, function () {
            				btValidate.fadeIn(200);
            				btValidate.attr('code-sent', false)
            				btValidate.attr('disabled', false);
            				
            				divError.html('');
            				form.removeClass('error');
            				inputStatusCode.val('DES');
            				inputIdCode.val('-1');
            			});
            		}else{
            			divError.html('');
            			form.removeClass('error');
            			inputStatusCode.val('DES');
            			inputIdCode.val('-1');
            		}
            		inputMonto.val('');
            		inputCode.val('');
		            notificacion="Para concretar el pago, cancele en BBVA indicando el c&oacute;digo generado.";
		     		renderizarBBVA(data)    
                }
                
                if($.trim(message)!="" && amount!="") {
                	if(message=='TIMEOUTTR'){
                		message=timeoutTrMsg;
                	}
		        	notificacion="<div class='info'></div><p>"+message+"</p>";
		        	btRecharge.attr('disabled', false);
		        }
		        if($.trim(notificacion)!="") alertMessage(notificacion);
		        $('body').find('#cargando').remove();
            }
        });
  	}
  };
  
  renderizarBBVA = function (data){
  	  var fila = data.split("||");
	  if (fila.length > 0 && fila[0] != '') {
		  var html = '';
	  	  var $tableCodes = $("#grillaBBVA");
	  	  html += renderTemplate(tplRechargeBBVAHead, {});
		  for (var n = (fila.length-1); n >= 0 ; n--) {
			  var items = fila[n].split("|");
	          if (items.length > 0) {
	        	  if (items[3] === "PEN" || items[3] === "OKK") {
	        		  html += renderTemplate(tplRechargeBBVAItem, {amount: items[1], code: items[0], date: items[2].substring(0, 10), urlvalidate: "bbvaverify", urlcancel: "bbvadelete", pin: items[4]});
	        	  }
	          }
		  }       		
			
		  $tableCodes.html(html);
		  $tableCodes.fadeIn(200);
	  }else{
		  var $tableCodes = $("#grillaBBVA");
		  $tableCodes.html('');
	  }
  };
  
  listarCodigosBBVA = function (verify) {
	  if (!$('#accordion_bbva').hasClass('opened') || verify==true) {
		var data = '';
        var msgres = [];
        var vurl="check-transaction-bbva-rt.html";    	
    	var rechargetoken = $('#rechargetoken').val();
    	var vheaders={"rechargetoken":$('#rechargetoken').val()};
        $.ajax({
            type: "post",
            url: vurl,
            headers: vheaders,
            dataType: "text",
            data: "",
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
	        },
	        error: function () {
	        	$('body').find('#cargando').remove();
	        },
            success: function (e) {
            	msgres=e;
            	if(msgres=='TIMEOUTTR'){
            		$('body').find('#cargando').remove();
            		alertMessage(timeoutTrMsg);
            	}else{
            		msgres = $.trim(e.toString()).split("|||");
  	                data = msgres[0];
  	                renderizarBBVA(data);
  	                $('body').find('#cargando').remove();
            	}
                
            }
        });
	  }
	};
  
  $('#accordion_bbva').on('click', listarCodigosBBVA);
  
  $('#grillaBBVA').on('click', '.bbvaverify', function (event) {	 
	  var $btnVerificar = $(this);
	  var price=$btnVerificar.parents('.row_grid').text().split(/\n/)[1].trim();
	  var code=$btnVerificar.parents('.row_grid').text().split(/\n/)[2].trim();
	  var date=$btnVerificar.parents('.row_grid').text().split(/\n/)[3].trim();
      
      var amount = $("#clientSale-amount").text().replace(',','');
      var trx = $(this).data('pin');
      var vurl="verificarBBVA-rt.html";    	
  	  var rechargetoken = $('#rechargetoken').val();
  	  var vheaders={"rechargetoken":$('#rechargetoken').val()};
  	  
      $.ajax({
          type: "post",
          url: vurl,
          headers: vheaders,
          dataType: "json",
          data: {
          	  amount: amount,
              pin: trx
          },
          beforeSend: function () {
           	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
	      },
	      error: function () {
	       	$('body').find('#cargando').remove();
	       	tagginSaldoErrorRecarga('Internet BBVA', '¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
	      },
          success: function (data) {
              if (data.state === 'OK') {
            	  if(rechargetoken!=null && rechargetoken!=""){
                 		loadRechargeRT(flagrecarga);
               	  }else{
               		  loadRecharge();
               	  }
            	  listarCodigosBBVA(true);
            	  tagginSaldoBBVAEEcheckout(price);
            	  tagginSaldoBBVAEEpurchase(code, date, price);
              }else{
            	  if(data.state=='TIMEOUTTR'){
            		  data.message=timeoutTrMsg;
            	  }
            	  tagginSaldoErrorRecarga('Internet BBVA', $("<div/>").html(data.message).text());
              }
              $('body').find('#cargando').remove();
              alertMessage("<div class='info'></div><p>"+data.message+"</p>");
          }
      })
      
  });
  
  $('#grillaBBVA').on('click', '.bbvadelete', function (event) {	 
	  var $btnAnular = $(this);
	  var pin = $(this).data('pin');
  	  var rechargetoken = $('#rechargetoken').val();
  	  var vheaders={"rechargetoken":$('#rechargetoken').val()};
	  
      $.ajax({
          type: 'post',
          url: 'anularBBVA-rt.html',
          headers: vheaders,
          dataType: 'text',
          data: {
              pin: $(this).data('pin')
          },
          beforeSend: function () {
        	  $('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
  	      },
  	      error: function () {
  	    	  $('body').find('#cargando').remove();
  	      },
          success: function (data) {
        	  $('body').find('#cargando').remove();
        	  $btnAnular.parents('.row_grid').remove()
        	  var price=$btnAnular.parents('.row_grid').text().split(/\n/)[1].trim();
        	  tagginSaldoBBVAEEremoveFromCart(price);
          }
      });
      if ($('#grillaBBVA').find('.bbvadelete').length == 1) {
          $('#grillaBBVA').html('');
      }
  });
  
  // render each forms
  $forms.each(function () {
    var $form = $(this),

      $inputMonto = $form.find('input[name="monto"]'),
      $inputCode = $form.find('input[name="codigo"]'),
      $inputLoto = $form.find('input[name="lotocard"]'),
      $inputTypeToken = $form.find('input[name="type_token"]'),
      $inputMedioPago = $form.find('input[name="medio_pago"]'),
      $inputStatusCode = $form.find('input[name="status_code"]'),
      $inputIdCode = $form.find('input[name="id_code"]'),
      $inputOptionCard = $form.find('input[name="option-card"]'),
      
      $divError = $form.find('.form__alert_recharge'), 
      
      $divComision = $form.find('.subcontent-comision'),

      $btValidate = $form.find('.button__outline'),
      $btRecharge = $form.find('.button__base'),

      urlRecharge = $form.attr('action'),
      urlValidate = $btValidate.attr('data-action'),
      $spanValid = $form.find('.form__gift-valid'),
      $tableCodes = $form.find('.subcontent-table'),
      $divForm = $form.closest('.subcontent-lotocard'),
      $divConf = $divForm.parent().find('.subcontent-confirm'),
      $btBackForm = $divConf.find('.link__base'),
      dataCategory = $form.closest('.tabs').attr('data-category'),
      onValidateCode,
      submitRecharge,
      rechargeLotocard,
      rechargeVisanet,
      rechargeIzipay,
      rechargeAgora,
      rechargePEFE,
      rechargeTUPAY,
      rechargeSPAY,
      rechargeBBVA,
      onBackLotocard,
      onChangeCode,
      onChangeField;
    
    var code_temp='';
    
    onChangeCode = function () {
    	if( ($inputStatusCode.val()==='ACT' || $inputStatusCode.val()==='APL') && code_temp !=$inputCode.val()){
      	  	$spanValid.fadeOut(150, function () {
      	    	$btValidate.fadeIn(200);
      	    	$btValidate.attr('code-sent', false)
      	    	$btValidate.attr('disabled', false);
      	    	
      	    	$divError.html('');
        		$divError.hide();
          	  	$form.removeClass('error');
          	    $inputStatusCode.val('DES');
          	    $inputIdCode.val('-1');
            });
    	}else if ($inputStatusCode.val()==='ERR' && code_temp !=$inputCode.val()){
    		$divError.html('');
     		$divError.hide();
      	  	$form.removeClass('error');
      	    $inputStatusCode.val('DES');
      	 	$inputIdCode.val('-1');
    	}
    };
    
    $inputCode.on('keyup', onChangeCode);
    
    // validate fields
    $.validate({
      form : $form,
      validateOnBlur: true,
      showHelpOnFocus: true,
      scrollToTopOnError: false,
      onSuccess: function () {
        submitRecharge();
        return false;
      }
    });
    
    $inputCode.on('input', function () {
        var valor = $inputCode.val().trim();
        const $btRechargeAgora = $('#btnRecargaAgora2');
        // Si el campo está vacío...
        if (valor === '') {
            $btRecharge.attr('disabled', false); // Habilita el botón de recarga
            $btRechargeAgora.attr('disabled', false);
        }
    });
    
    $inputMonto.on('input', function() {
        $divError.hide();
    });

    onValidateCode = function () {
    	 var codePromotional = $inputCode.val();
         var channel = $inputMedioPago.val();
         var lotocard = $inputLoto.val();
         var amount = $inputMonto.val();
         
         const $btRechargeAgora = $('#btnRecargaAgora2');
         
         code_temp = $inputCode.val();
         
         if(amount==undefined){
       	  amount=0;
          $divError.hide();
         }
         
         if(lotocard==undefined){
       	  lotocard='';
         }
        
	    if (codePromotional === '') {
	          $btRecharge.attr('disabled', false); // Habilita el botón de recarga
	    }
	    
        if (codePromotional !== '') {
        	$btValidate.attr('disabled', true);
        	$divError.html('');
        	//recarga visa con sesion o con token
        	var vurl="send-code-promotional-validation.html";    	
        	var rechargetoken = $('#rechargetoken').val();
        	var vheaders={};
        	if(rechargetoken!=null && rechargetoken!=""){
        		vurl="send-code-promotional-validation-rt.html";
        		vheaders={"rechargetoken":$('#rechargetoken').val()};
        	}
        	$.ajax({
                url: vurl,
                headers: vheaders,
                type: "post",
                data: "codePromotional="+codePromotional+"&channel="+channel+"&amount="+amount+"&lotocard="+lotocard,
                dataType: "jsonp",
                beforeSend: function () {
                	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
                },
                error: function () {
                	$('body').find('#cargando').remove();
                	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
                },
                success: function (data) {
                    if (data.status === 'ACT' && data.message === 'OK') {
                        $inputStatusCode.val(data.status);
                        $inputIdCode.val(data.idCode);
                        $divError.html('');
                        $divError.hide();
                 	  	$form.removeClass('error');
   	               	    $btRecharge.attr('disabled', false); 
	                    $btRechargeAgora.attr('disabled', false);
	                    
                        var dataLabel = $btValidate.attr('data-label');
                        
                        //gaEvent(dataCategory, 'Clic', dataLabel);
                        $btValidate.fadeOut(150, function () {
                          $spanValid.fadeIn(200);
                          $btValidate.attr('code-sent', true)
                        });
                        datalayerAplicarCodigoPromo();
                     } else if(data.status === 'APL') {                   	  	
	                   	if(rechargetoken!=null && rechargetoken!=""){
	                   		loadRechargeRT(flagrecarga);
	                 	}else{
	                 		loadRecharge();
	                 	}
                   	  	$inputStatusCode.val(data.status);
                        $inputIdCode.val(data.idCode);
                        $divError.html('');
                   	  	$form.removeClass('error');
                         
                        var dataLabel = $btValidate.attr('data-label');
                        //gaEvent(dataCategory, 'Clic', dataLabel);
                        $btValidate.fadeOut(150, function () {
                        	$spanValid.fadeIn(200);
                        	$btValidate.attr('code-sent', true)
                        });
                        alertMessage(data.message);
                     } else if(data.status === 'NAPL') {
                    	 if(rechargetoken!=null && rechargetoken!=""){
 	                   		loadRechargeRT(flagrecarga);
 	                 	}else{
 	                 		loadRecharge();
 	                 	}
                   	  	$inputStatusCode.val(data.status);
                        $inputIdCode.val(data.idCode);
                        $divError.html('');
                   	  	$form.removeClass('error');
                   	  	alertMessage(data.message);            	  
                     } else if(data.status === 'TIMEOUTTR'){
                    	 if(rechargetoken!=null && rechargetoken!=""){
  	                   		loadRechargeRT(flagrecarga);
  	                 	}else{
  	                 		loadRecharge();
  	                 	}
                    	  	$inputStatusCode.val('ERR');
                    	  	$inputIdCode.val('-1');
                    	  	$btValidate.attr('disabled', false);
                    	  	$divError.html(timeoutTrMsg);
                    	  	$form.addClass('error');
                     }else {
                    	 if(rechargetoken!=null && rechargetoken!=""){
 	                   		loadRechargeRT(flagrecarga);
 	                 	}else{
 	                 		loadRecharge();
 	                 	}
                    	$divError.show();
                   	  	$inputStatusCode.val('ERR');
                   	  	$inputIdCode.val('-1');
                   	  	$btValidate.attr('disabled', false);
                   	  	$divError.html(data.message);
                   	  	
                   	    $btRecharge.attr('disabled', true);
                   	    $btRechargeAgora.attr('disabled', true);
                   	    
                   	    $form.addClass('error');
                     }
                     $('body').find('#cargando').remove();
                }
              });
        } 
      };
      
    rechargeLotocard = function (option,pin,actbono,actwbbono, codePromotional, channel) {
    	var cadena = "";
    	var baseUrl = "";
    	var authToken = "";
    	var rechargetoken = $('#rechargetoken').val();
    	var vurl="client_lotocard_load_balance.html";
    	var vheaders={};
    	if(rechargetoken!=null && rechargetoken!=""){
    		vurl="client_lotocard_load_balance_rt.html";
    		vheaders={"rechargetoken":$('#rechargetoken').val()};
    	}
    	$.ajax({
            type:"post",
            url: vurl,
            headers: vheaders,
            data: "numberCard="+pin+"&activ-bono="+actbono+"&activ-wbbono="+actwbbono +
            	"&codePromotional=" + codePromotional + "&channel=" + channel,
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
            error: function () {
            	$('body').find('#cargando').remove();
            	$btRecharge.attr('disabled', false);
            	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
            	tagginSaldoErrorRecarga('Efectivo Lotocard', '¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
            },
            success: function (data) {
            	if(data.lapolla!=null && $.trim(data.lapolla)!="" && data.indicador == 1) {
            		cadena = data.lapolla.split("|");
            		window.open($.trim(cadena[0]),"_parent");
            	} else if(data.tav2!=null && $.trim(data.tav2)!="" && data.indicador == 1) {
                	cadena = data.tav2.split("|");
    				baseUrl = $.trim(cadena[0]);
    				authToken = $.trim(cadena[1]);
    				window.open(baseUrl+"?authToken="+authToken,"_parent");				
            	} else {
            		if(rechargetoken!=null && rechargetoken!=""){
                   		loadRechargeRT(flagrecarga);
                 	}else{
                 		loadRecharge();
                 	}
            		
	                if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {		      	    	
		      	    	$spanValid.fadeOut(150, function () {
		          	    	$btValidate.fadeIn(200);
		          	    	$btValidate.attr('code-sent', false)
		          	    	$btValidate.attr('disabled', false);
		          	    	
		          	    	$divError.html('');
		              	  	$form.removeClass('error');
		              	    $inputStatusCode.val('DES');
		              	    $inputIdCode.val('-1');
		                });
	                }else{
	                	$divError.html('');
		          	  	$form.removeClass('error');
		          	    $inputStatusCode.val('DES');
		          	    $inputIdCode.val('-1');
	                }
	                
	      	    	$inputLoto.val('');
	      	    	$inputCode.val('');
                    datalayerContinuarCargarSaldo();
	      	    	if(data.message!=undefined && data.message!=null){
	      	    		if(data.message==="OK"){
	      	    			var idTransaction=data.balanceItem;
	      	    		$("#montoCargado").text(floatFormat(data.amount));
	 	                //$("#saldoDisponible").text(floatFormat(data.newamount));
	 	      	    	$divForm.fadeOut(150, function() { $divConf.fadeIn(250); });
		 	      	    	var amount=parseFloat(data.amount).toFixed(2);
		 	      	    	tagginSaldoLotocardEEaddToCart(amount);
		 	      	    	tagginSaldoLotocardEEcheckout(amount);
		 	      	    	alertMessage(data.alertPrepaidCard);
		 	      	    	tagginSaldoLotocardEEpurchase(idTransaction, amount);
	      	    		}else{
	      	    			var msj=data.alertPrepaidCard
	      	    			if(msj=='TIMEOUTTR'){
	      	    				msj=timeoutTrMsg;
	      	    			}
	      	    			alertMessage(msj);
	      	    			tagginSaldoErrorRecarga('Efectivo Lotocard',msj);
	      	    		}
	      	    	}
                    
            	}
            	$('body').find('#cargando').remove();
            }
        });
    };
    
    rechargeTUPAY = function (type_token,amount,actbono,actwbbono,codePromotional,channel) {
        var vurl="tupay_api.html";
        var rechargetoken = $('#rechargetoken').val();
        var vheaders={};

        if(rechargetoken!=null && rechargetoken!=""){
            vheaders={"rechargetoken":$('#rechargetoken').val()};
        }

        $.ajax({
            type: "post",
            url: vurl,
            headers: vheaders,
            data: "posAmount="+amount+"&activ-bono="+actbono+"&activ-wbbono="+actwbbono+
                  "&codePromotional="+codePromotional+"&channel="+channel,
            dataType: "text",

            beforeSend: function () {
                $('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
            },

            error: function () {
                $('body').find('#cargando').remove();
                $btRecharge.attr('disabled', false);
                alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');

                if($('#tabInternet').hasClass('selected')){
                    if(channel=="YAPE_TP"){
                        tagginSaldoErrorRecarga('Internet YAPE', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    }else if(channel=="PLIN_TP"){
                        tagginSaldoErrorRecarga('Internet PLIN', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    }
                }else{
                    tagginSaldoErrorRecarga('TUPAY', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                }
            },

            success: function (e) {
                $('body').find('#cargando').remove();
                $btRecharge.attr('disabled', true);

                let responseJson = null;

                try {
                    responseJson = JSON.parse(e);
                } catch (err) {
                    console.error("Respuesta no es JSON válido:", e);
                    alertMessage("Ocurrió un error al procesar la respuesta del servidor.");
                    return;
                }

                if(responseJson.error){
                    alertMessage("<div class='info'></div><p>"+responseJson.error+"</p>");
                    return;
                }

                if(!responseJson.qrCode){
                    alertMessage("No se recibió el código QR. Intente nuevamente.");
                    return;
                }
                if(channel === "PLIN_TP"){
                    $('#qrImagePlin').attr('src', responseJson.qrCode);
                    $('#amountPlin').text('S/' + parseInt(responseJson.amount));
                    const [fecha, hora] = responseJson.expiration_date.split(' ');
                    $('#expirationDatePlin').text(fecha.split('-').reverse().join('/'));
                    $('#expirationTimePlin').text(hora);
                } else if(channel === "YAPE_TP"){
                    $('#qrImageYape').attr('src', responseJson.qrCode);
                    $('#amountYape').text('S/' + parseInt(responseJson.amount));
                    const [fecha, hora] = responseJson.expiration_date.split(' ');
                    $('#expirationDateYape').text(fecha.split('-').reverse().join('/'));
                    $('#expirationTimeYape').text(hora);
                }

                if(channel=="PLIN_TP"){
                	$("#divVerificaRecargaPlinTupay").css("display","block");
                	$("#frame_plintupayl").removeClass("hide");
                	$("#close_plintupayl").removeClass("hide");
                	//$('#downloadQrButtonPlin').show();
                } 
                else if(channel=="YAPE_TP"){
                	$("#divVerificaRecargaYapeTupay").css("display","block");
                	$("#frame_yapetupayl").removeClass("hide");
                	$("#close_yapetupayl").removeClass("hide");
                	//$('#downloadQrButtonYape').show();
                }

                if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {		      	    	
                    $spanValid.fadeOut(150, function () {
                        $btValidate.fadeIn(200);
                        $btValidate.attr('code-sent', false)
                        $btValidate.attr('disabled', false);

                        $divError.html('');
                        $form.removeClass('error');
                        $inputStatusCode.val('DES');
                        $inputIdCode.val('-1');
                    });
                } else {
                    $divError.html('');
                    $form.removeClass('error');
                    $inputStatusCode.val('DES');
                    $inputIdCode.val('-1');
                }

                $inputMonto.val('');
                $inputCode.val('');

            }
        });
    };

    
    rechargePEFE = function (type_token,amount,actbono,actwbbono,codePromotional,channel) {
    	//recarga visa con sesion o con token
    	var vurl="portal_page.html";    	
    	var rechargetoken = $('#rechargetoken').val();
    	var vheaders={};
    	if(rechargetoken!=null && rechargetoken!=""){
    		vurl="portal_page_rt.html";
    		vheaders={"rechargetoken":$('#rechargetoken').val()};
    	}
        $.ajax({
            type: "post",
            url: vurl,
            headers: vheaders,
            data: "posAmount=" + amount + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono + 
            	"&codePromotional="+codePromotional + "&channel="+channel + "&lotocard="+'',
            dataType: "text",
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
            error: function () {
                $('body').find('#cargando').remove();
            	$btRecharge.attr('disabled', false);
            	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
            	if($('#tabInternet').hasClass('selected')){                	
                	if(channel=="PEFE"){
                		tagginSaldoErrorRecarga('Internet PagoEfectivo', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                	}else if(channel=="YAPE"){
                		tagginSaldoErrorRecarga('Internet YAPE', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                	}else if(channel=="PLIN"){
                		tagginSaldoErrorRecarga('Internet PLIN', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                	}
                }else{
                	tagginSaldoErrorRecarga('Efectivo PagoEfectivo', "¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.");
                }
            },
            success: function (e) {
                if (e != null && e != "") {
                    var redireccion = $.trim(e.toString()).split("|");
                    if (redireccion[1] != null && $.trim(redireccion[1]) != "") {
                    	if(redireccion[1]=='TIMEOUTTR'){
                    		redireccion[1]=timeoutTrMsg;
                    	}
                    	$btRecharge.attr('disabled', false);
                    	alertMessage("<div class='info'></div><p>"+$.trim(redireccion[1])+"</p>");
                    	if($('#tabInternet').hasClass('selected')){                        	
                        	if(channel=="PEFE"){
                        		tagginSaldoErrorRecarga('Internet PagoEfectivo', $("<div/>").html($.trim(redireccion[1])).text());
                        	}else if(channel=="YAPE"){
                        		tagginSaldoErrorRecarga('Internet YAPE', $("<div/>").html($.trim(redireccion[1])).text());
                        	}else if(channel=="PLIN"){
                        		tagginSaldoErrorRecarga('Internet PLIN', $("<div/>").html($.trim(redireccion[1])).text());
                        	} 
                        }else{
                        	tagginSaldoErrorRecarga('Efectivo PagoEfectivo', $("<div/>").html($.trim(redireccion[1])).text());
                        }
                    } else {
		                if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {		      	    	
			      	    	$spanValid.fadeOut(150, function () {
			          	    	$btValidate.fadeIn(200);
			          	    	$btValidate.attr('code-sent', false)
			          	    	$btValidate.attr('disabled', false);
			          	    	
			          	    	$divError.html('');
			              	  	$form.removeClass('error');
			              	    $inputStatusCode.val('DES');
			              	    $inputIdCode.val('-1');
			                });
		                }else{
		                	$divError.html('');
			          	  	$form.removeClass('error');
			          	    $inputStatusCode.val('DES');
			          	    $inputIdCode.val('-1');
		                }
		                
		                $inputMonto.val('');
		      	    	$inputCode.val('');
		      	    	datalayerGenerarCodigoPago();
		      	    	if(channel=="YAPE"){
    	      	    		$("#divVerificaRecargaYape").css("display","block");
    	      	    		
    	      	    		if(type_token==1) {
                        		$("#frame_yapepefl iframe").attr("src", $.trim(redireccion[0]));
                            	$("#frame_yapepefl").removeClass("hide");
                            	$("#close_yapepefl").removeClass("hide");
                            }
    	      	    	}else if(channel=="PLIN"){
                    		$("#divVerificaRecargaPlin").css("display","block");
                    		
                    		if(type_token==1) {
                        		$("#frame_plinpefl iframe").attr("src", $.trim(redireccion[0]));
                            	$("#frame_plinpefl").removeClass("hide");
                            	$("#close_plinpefl").removeClass("hide");
                            }
                    	}else if(channel=="PEFE"){                   		
                    		if(type_token==1) {
                        		$("#frame_pefl iframe").attr("src", $.trim(redireccion[0]));
                            	$("#frame_pefl").removeClass("hide");
                            	$("#close_pefl").removeClass("hide");
                            	$("#divVerificaRecargaPEFE").css("display","block");  
                            } else if(type_token==2) {
                            	$("#frame_pefe iframe").attr("src", $.trim(redireccion[0]));
    	                        $("#frame_pefe").removeClass("hide");
    	                        $("#close_pefe").removeClass("hide");
    	                        $("#divVerificaRecargaPEFEE").css("display","block");  
    	                    }
                    	}
                    }
                } else {
                	$btRecharge.attr('disabled', false);
                	alertMessage("<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
                	if($('#tabInternet').hasClass('selected')){                    	
                    	if(channel=="PEFE"){
                    		tagginSaldoErrorRecarga('Internet PagoEfectivo', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    	}else if(channel=="YAPE"){
                    		tagginSaldoErrorRecarga('Internet YAPE', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    	}else if(channel=="PLIN"){
                    		tagginSaldoErrorRecarga('Internet PLIN', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    	}     	
                    }else{
                    	tagginSaldoErrorRecarga('Efectivo PagoEfectivo', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    }
                }
                                
                $('body').find('#cargando').remove();
            }
        });
    };
    
    rechargeSPAY = function (type_token,amount,actbono,actwbbono,codePromotional,channel) {
    	//recarga spay con sesion o con token
    	var vurl="safety_page_post.html";    	
    	var rechargetoken = $('#rechargetoken').val();
    	var vheaders={};
    	if(rechargetoken!=null && rechargetoken!=""){
    		vurl="safety_page_post_rt.html";
    		vheaders={"rechargetoken":$('#rechargetoken').val()};
    	}
        $.ajax({
            type: "post",
            url: vurl,
            headers: vheaders,
            data: "posAmount=" + amount + "&typeToken=" + type_token + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono +
            	"&codePromotional=" + codePromotional + "&channel=" + channel + "&lotocard=" + '',
            dataType: "text",
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
            error: function () {
                $('body').find('#cargando').remove();
            	$btRecharge.attr('disabled', false);
            	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
            	if($('#tabInternet').hasClass('selected')){
                	tagginSaldoErrorRecarga('Internet SafetyPay', "¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
                }else{
                	tagginSaldoErrorRecarga('Efectivo SafetyPay', "¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.");
                }
            },
            success: function (e) {
                if (e != null && e != "") {
                    var redireccion = $.trim(e.toString()).split("|");
                    if (redireccion[1] != null && $.trim(redireccion[1]) != "") {
                    	if(redireccion[1]=='TIMEOUTTR'){
                    		redireccion[1]=timeoutTrMsg;
                    	}
                    	$btRecharge.attr('disabled', false);
                    	alertMessage("<div class='info'></div><p>"+$.trim(redireccion[1])+"</p>");
                    	if($('#tabInternet').hasClass('selected')){
                        	tagginSaldoErrorRecarga('Internet SafetyPay', $("<div/>").html($.trim(redireccion[1])).text());
                        }else{
                        	tagginSaldoErrorRecarga('Efectivo SafetyPay', $("<div/>").html($.trim(redireccion[1])).text());
                        }
                    } else {
                    	if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {		      	    	
     		      	    	$spanValid.fadeOut(150, function () {
     		          	    	$btValidate.fadeIn(200);
     		          	    	$btValidate.attr('code-sent', false)
     		          	    	$btValidate.attr('disabled', false);
     		          	    	
     		          	    	$divError.html('');
     		              	  	$form.removeClass('error');
     		              	    $inputStatusCode.val('DES');
     		              	    $inputIdCode.val('-1');
     		                });
     	                }else{
     	                	$divError.html('');
     		          	  	$form.removeClass('error');
     		          	    $inputStatusCode.val('DES');
     		          	    $inputIdCode.val('-1');
     	                }
     	                
     	                $inputMonto.val('');
     	      	    	$inputCode.val('');
     	      	    	datalayerGenerarCodigoPago();
                        if(type_token==1) {
                        	$("#frame_sfpl iframe").attr("src", $.trim(redireccion[0]));
                        	$("#frame_sfpl").removeClass("hide");
                        	$("#close_sfpl").removeClass("hide");
                        } else if(type_token==2) {
                        	$("#frame_sfpe iframe").attr("src", $.trim(redireccion[0]));
	                        $("#frame_sfpe").removeClass("hide");
	                        $("#close_sfpe").removeClass("hide");
	                    }
                    }
                } else {
                	$btRecharge.attr('disabled', false);
                	alertMessage("<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
                	if($('#tabInternet').hasClass('selected')){
                    	tagginSaldoErrorRecarga('Internet SafetyPay', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    }else{
                    	tagginSaldoErrorRecarga('Efectivo SafetyPay', "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
                    }
                }
                $('body').find('#cargando').remove();
            }
        });
    };
    
    rechargeIzipay = function (amount,actbono,actwbbono, codePromotional, channel) {
    	$btRecharge.attr('disabled', false);   	   
    	var rechargetoken = $('#rechargetoken').val();
    	var vheaders={};
    	if(rechargetoken!=null && rechargetoken!=""){
    		vheaders={"rechargetoken":$('#rechargetoken').val()};
    	}
    	
    	$.ajax({
    		type: "POST",
    		url: "defineRechargeIzipay.html",
    		dataType: "json",
    		headers: vheaders,
    		async: false,
    		data: "amount="+amount+"&actbono="+actbono+"&actwbbono="+actwbbono+"&codePromotional="+codePromotional+"&channel="+channel+"&operatorId="+$("#operatorId").val(),
    		beforeSend: function () {
    			$('body').append('<div id="loading-recharge-1" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
    		},
    	})
    	.done(function(data) {
    		$('body').find('#loading-recharge-1').remove();
    		if(data.state=="OK"){    	    	
    	       	var parametrosIzi = "?amountIzipay="+amount+"&actbono="+actbono+"&actwbbono="+actwbbono+"&fullName="+$('#client-name').val()+"&lastName="+$('#client-lastname').val()+
    	       	"&identifer="+"CID-"+$("#cid").val()+"-latinka.com.pe"+"&codePromotional="+codePromotional+"&channel="+channel+"&operatorId="+$("#operatorId").val()+
    	       	"&docTypeIzi="+$("#docTypeIzi").val()+"&docNumber="+$("#docNumber").val()+"&cid="+$("#cid").val()+"&number="+data.idTransactionIzipay+"&apiKey="+data.apiKey+"&mobilePhone="+$("#mobilePhone").val()+"&signature="+data.signature;
    	    	$('body').find('#div-lightbox-izipay-ilot').remove();	
    	    	$('body').append('<div id="loading-recharge-1" class="loading" style="z-index: 10001 !important;"></div>');
    	    	$('body').append('<div id="div-lightbox-izipay-ilot" style="position:fixed; top:13%; left:6%;z-index: 10002;width:87%; height: 530px; display: block; background-color: white; border-radius: 7px;"><iframe id="frmLightboxIzipay" frameborder="0" src="recarga-epago.html'+parametrosIzi+'" style="z-index: 10003; width:100%; height:100%;"></iframe></div>');	
    		}else{
    			alertMessage(data.message);
    		}
    	})
    	.fail(function() {
    		$('body').find('#loading-recharge-1').remove();
    	});  
    };
    
    rechargeVisanet = function (amount,actbono,actwbbono, codePromotional, channel) {    	
    	$btRecharge.attr('disabled', false);
    	window.scrollTo(0, 0);
    	var nombres = $('#full-name').val();
    	var apellidos = $('#last-name').val();
    	//var email = $('#email').val();
    	var email = "0"; 
    	var client_id = "0";
    	
    	var remote_addr = $('#remote-addr').val();
    	var monto = amount;
    	var merchant_logo = $('#vn-merchantlogo').val();
    	var timeout_url = window.location.href;
    	
    	var buttonParameters = { clientId: client_id, amount: monto, remoteAddr: remote_addr, 
    							cardHolderName: nombres, cardHolderLastName: apellidos, cardHolderEmail: email,
    							merchantLogo: merchant_logo, timeoutUrl: timeout_url, actbono: actbono, actwbbono: actwbbono, typeCard: 'VISA',
    							codePromotional: codePromotional, channel: channel
    							};
    	
    	var promotionMessage = "";
    	
    	var intervalVisanet = 0;
    	var intervalTimeOutVisanet = 0;
    	
    	//recarga visa con sesion o con token
    	var vurl="buildVisaForm.html";    	
    	var rechargetoken = $('#rechargetoken').val();
    	var vheaders={};
    	if(rechargetoken!=null && rechargetoken!=""){
    		vurl="buildVisaFormRT.html";
    		vheaders={"rechargetoken":$('#rechargetoken').val()};
    	}
    	
        $.ajax({
            type: "post",
            url: vurl,
            headers: vheaders,
            dataType: 'json',
            contentType: 'application/json',
            data: JSON.stringify(buttonParameters),
            //global: false,
            //async: false,
            beforeSend: function () {
            	$('body').append('<i id="cargando-1" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
            success: function (e) {
            	$('#vn-sk').val(e.sessionKey);
            	
            	if(e.sessionKey!=null && e.sessionKey!='' && e.sessionKey=='0'){
            		$('body').find('#cargando-1').remove();
            		var htmlText=e.htmlText;
            		if(htmlText=='TIMEOUTTR'){
            			htmlText=timeoutTrMsg;
            		}
            		tagginSaldoErrorRecarga('Internet Visa', htmlText);
            		alertMessage(htmlText);
            		return;
            	}
            	
            	$("#frameButtonVisa").attr('srcdoc', e.htmlText);
                $('#modal-visa').css('display', 'block');
            	$('#modal-visa').css('z-index', '2147483660');
            	$("#modal-visa").css('width', "100%");
            	$("#modal-visa").css('height', "100%");
            	
            	tagginSaldoEEcheckout();
            	datalayerButtonCargarSaldo();
            	$("#frameButtonVisa").on('load', function() {
                	$('body').find('#cargando-1').remove();
            		var frameVisa = document.getElementById("frameButtonVisa");
                	//var iframeDocument = frameVisa.contentDocument || iframe.contentWindow.document;
            		var iframeDocument = frameVisa.contentDocument;
                	var framePago = iframeDocument.getElementById("visaNetJS");
                	if(framePago != null){
                		if(intervalVisanet===0){
                			intervalVisanet = setInterval(checkFormVisanet, 1000);
                			intervalTimeOutVisanet = setInterval(checkFormTimeOutVisanet, 900000);//15 min
                		}else{
                			clearInterval(intervalVisanet);
                			clearInterval(intervalTimeOutVisanet);
                		}
                		
                		function checkFormTimeOutVisanet(){
            				$("#frameButtonVisa").removeAttr('srcdoc');
            				$('#modal-visa').css('display', 'none');
            				clearInterval(intervalTimeOutVisanet);
                		}
                		
                		function checkFormVisanet(){
                    		if(framePago.style.display == 'none'){
                    			$("#frameButtonVisa").removeAttr('srcdoc');
                    			$('#modal-visa').css('display', 'none');
                    			clearInterval(intervalVisanet);
                    			clearInterval(intervalTimeOutVisanet);
                    		}else{
                    			var hiddenToken = iframeDocument.getElementsByName("transactionToken")[0];
                    			if(typeof hiddenToken !== 'undefined'){
                    				clearInterval(intervalVisanet);
                    				clearInterval(intervalTimeOutVisanet);
                    				$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
                        			checkResultVisanet();
                    			}
                    		}
                		};
                	}
                	
                	function checkResultVisanet(){
                    	var intervalResultVisanet = setInterval(resultVisanet, 5000);
                    	var countVisa = 0;
                    	
                    	function resultVisanet(){
                    		countVisa = countVisa + 1;
                    		if (countVisa>=5){
                    			$('body').find('#cargando').remove();
                    			$("#frameButtonVisa").removeAttr('srcdoc');
                				$('#modal-visa').css('display', 'none');
                    			clearInterval(intervalResultVisanet);
                    			alertMessage('El proceso de solicitud ha tomado más tiempo de lo permitido, por favor verifica el estado de tu transacción en tu cuenta.');
                    			tagginSaldoErrorRecarga('Internet Visa', 'El proceso de solicitud ha tomado más tiempo de lo permitido, por favor verifica el estado de tu transacción en tu cuenta.');
                    		} else 
                    			if(countVisa>0){
                    			var transactionParameters = {amount: monto,actbono: actbono, actwbbono: actwbbono,codePromotional: codePromotional};
                    			
                    			//recarga visa con sesion o con token
                    	    	var vurl="findVisanetRecargaResult.html";
                    	    	var vheaders={};
                    	    	var rechargetoken = $('#rechargetoken').val();                    	    	
                    	    	if(rechargetoken!=null && rechargetoken!=""){
                    	    		vurl="findVisanetRecargaResultRT.html";
                    	    		vheaders={"rechargetoken":$('#rechargetoken').val()};
                    	    	}
                    			$.ajax({
                                    type: "post",
                                    url: vurl,
                                    headers: vheaders,
                                    dataType: 'json',
                                    contentType: 'application/json',
                                    data: JSON.stringify(transactionParameters),
                                    //global: false,
                                    //async: false,
                                    success: function (jsonResult) {
                                    	var resultKey = jsonResult.resultKey;
                                    	var resultMessage = jsonResult.resultMessage;
                                    	promotionMessage = jsonResult.promotionMessage;
                                    	
                                    	if(resultMessage != null){
                                    		clearInterval(intervalResultVisanet);
                            				$("#frameButtonVisa").removeAttr('srcdoc');
                            				$('#modal-visa').css('display', 'none');
                            				
                                    		if(resultKey=='OK'){	
                                    			if(rechargetoken!=null && rechargetoken!=""){
                                    				loadRechargeRT(flagrecarga);
                                    			}else{
                                    				loadRecharge();
                                    			}
                                    			
                                    			var commissionAmount = jsonResult.commissionAmount;
                                    			var arrayResultMessage = resultMessage.split("|");
                                    			tagginSaldoEEpurchase(arrayResultMessage[2], monto);
                                    			var rptaTransaccion = "";
                                    			rptaTransaccion+="<br>Nº Transacción:"+arrayResultMessage[2];
                                    			rptaTransaccion+="<br>Visa:"+arrayResultMessage[4];
                                    			rptaTransaccion+="<br>"+arrayResultMessage[3];
                                    			//rptaTransaccion+="<br>Importe:"+arrayResultMessage[5];
                                    			//rptaTransaccion+="<br>Moneda:"+arrayResultMessage[6];
                                    			//rptaTransaccion+="<br>Descripción:";
                                    			if(commissionAmount>0){
                                    				rptaTransaccion+="<br>Comisión por recarga con Tarjeta Visa: S/ "+floatFormat(commissionAmount);
                                    			}
                                    			
                                    			rptaTransaccion+='<br><br><span style="font-size: 11px;">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>';
                                    			
                                    			if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
                                    				promotionMessage = "";
                                    			}
                                    			
                                    			
                                    			
                                    			if($.trim(codePromotional) != null) {
                    	                            if (promotionMessage.includes("insuficiente") == true ) {
                    	                            	
                    	                            	alertMessage('<p style="text-align: justify;margin: 0px;">'+promotionMessage + '<br><br>La recarga ha sido abonada a su saldo principal.<br>Monto cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+'<br>'+rptaTransaccion+"</p>");
                    	                            } else {      
                    	                            	alertMessage('<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente <br>' + promotionMessage+'<br>'+rptaTransaccion+"</p>");
                    	                            }
                    	                        } else {
                    	                        	if($.trim(promotionMessage)!=='') {
                    	                        		promotionMessage="<br>"+promotionMessage+"<br>";
                    	                        	}else{
                    	                        		promotionMessage="<br>";
                    	                        	}
                    	                        	alertMessage('<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente <br>Saldo cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+ promotionMessage + rptaTransaccion+"</p>");
                    	                        }
                                    			
                                    			if($.trim(codePromotional) != null) {		      	    	
                             		      	    	$spanValid.fadeOut(150, function () {
                             		          	    	$btValidate.fadeIn(200);
                             		          	    	$btValidate.attr('code-sent', false)
                             		          	    	$btValidate.attr('disabled', false);
                             		          	    	
                             		          	    	$divError.html('');
                             		              	  	$form.removeClass('error');
                             		              	    $inputStatusCode.val('DES');
                             		              	    $inputIdCode.val('-1');
                             		                });
                             	                }else{
                             	                	$divError.html('');
                             		          	  	$form.removeClass('error');
                             		          	    $inputStatusCode.val('DES');
                             		          	    $inputIdCode.val('-1');
                             	                }
                                    			
                                    			$divComision.addClass('hide');
                                    			$inputMonto.val('');
                             	      	    	$inputCode.val('');
                             	      	    	$btRecharge.attr('disabled', true);
                                			}else{
                                				var arrayResultMessage = resultMessage.split("|");
//                                				if($("#operatorId").val()!="5586"){
//                                					var rptaTransaccion = "";
//                                    				rptaTransaccion+= "<br>"+arrayResultMessage[1];
//                                    				rptaTransaccion+= "<br>Nº Transacción:"+arrayResultMessage[2];
//                                    				rptaTransaccion+= "<br>"+arrayResultMessage[3];
//                                    				
//                                    				tagginSaldoErrorRecarga('Internet Visa', rptaTransaccion);
//                                    				alertMessage('<p style="text-align: justify;margin: 0px;">'+rptaTransaccion+"</p>");
//                                				}else{
                                					$.ajax({
                                                        type: "post",
                                                        url: "registerCA.html",
                                                        headers: vheaders,
                                                        dataType: 'json',
                                                        data: "&medio=NIUBIZ&code="+arrayResultMessage[0]+"&description="+arrayResultMessage[1]+"&monto="+monto+"&operatorId="+$("#operatorId").val(),
                                                        success: function (data) {
                                                        	if(data.ban!=undefined && data.ban=="OK"){
                                                        		$('body').find('#cargando').remove();
                                        						localStorage.setItem("ban", "OK");
                                        						if($("#operatorId").val()!="5586"){
                                        							var ban = localStorage.getItem("ban");
                                	    							if(ban=="OK"){
                                	    								localStorage.removeItem("ban");
                                	    								var msgError = '<div style="font-family: \'Roboto\';"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"><p style="text-align: center;margin: 0px; line-height: 20px;"><b>Detectamos una irregularidad en tu cuenta</b><br><br>Por tu seguridad y de acuerdo con lo establecido en los T&C tu cuenta está bloqueada temporalmente.</p></div><br><br>'+
                                	    								'<button class="btn btn-recuperar-password" onclick="closePopupCA()" type="button">OK</button></div>'; 
                                	    								$('#msg-session').html(msgError);
                                	    								openModal("#popup-message-session","");
                                	    							}
                                    	                    	}else{
                                    	                    		window.location.href = 'security-close-session.html';
                                    	                    	}	
                                        					}else{
                                                				var rptaTransaccion = "";
                                                				rptaTransaccion+= "<br>"+arrayResultMessage[1];
                                                				rptaTransaccion+= "<br>Nº Transacción:"+arrayResultMessage[2];
                                                				rptaTransaccion+= "<br>"+arrayResultMessage[3];
                                                				
                                                				tagginSaldoErrorRecarga('Internet Visa', rptaTransaccion);
                                                				alertMessage('<p style="text-align: justify;margin: 0px;">'+rptaTransaccion+"</p>");
                                        					}
                                                        }
                                    				});
//                                				}
                                			}
                                    		$.ajax({
                            			        type: "POST",
                            			        url: "resetVisanetTransaction.html",
                            			        dataType: "json",
                            			        async: false,
                            			        success: function (data) {

                            			        }
                            				});
                                    		$('body').find('#cargando').remove();
                                    	}else{
                                    		var status=jsonResult.status;
                                    		var msj='¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.';
                                    		if(status=='TIMEOUTTR'){
                                    			msj=timeoutTrMsg;
                                    		}
                                    		$('body').find('#cargando').remove();
                                        	$("#frameButtonVisa").removeAttr('srcdoc');
                            				$('#modal-visa').css('display', 'none');
                                        	clearInterval(intervalResultVisanet);
                                        	tagginSaldoErrorRecarga('Internet Visa', msj);
                                        	alertMessage(msj);
                                    	}
                                    },
                                    error: function () {
                                    	$('body').find('#cargando').remove();
                                    	$("#frameButtonVisa").removeAttr('srcdoc');
                        				$('#modal-visa').css('display', 'none');
                                    	clearInterval(intervalResultVisanet);
                                    	tagginSaldoErrorRecarga('Internet Visa', '¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
                                    	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
                                    }
                                });
                    		}
                    	}
            			
            		};
                	
                });
            },
            error: function () {
            	$('body').find('#cargando-1').remove();
            	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
            }
        });
        
    };
    
    rechargeAgora = function (amount,actbono,actwbbono, codePromotional, channel) {    
    	var cel_agora = $("#cel_agora").val();
    	//recarga visa con sesion o con token
    	var vurl="rechargeAgora.html";    	
    	var rechargetoken = $('#rechargetoken').val();
    	var vheaders={};
    	if(rechargetoken!=null && rechargetoken!=""){
    		vurl="rechargeAgoraRT.html";
    		vheaders={"rechargetoken":$('#rechargetoken').val()};
    	}
    	$.ajax({
            type: "POST",
            url: vurl,
            headers: vheaders,
            dataType: "json",
            data: "codePromotional="+codePromotional+"&channel="+channel+"&lotocard="+''+
            	"&monto="+amount+"&actbono="+actbono+"&actwbbono="+actwbbono+"&phoneUpdateAgora="+actualizarCelularAgora+"&phoneUpdate="+cel_agora,
            beforeSend: function () {
            	$('body').append('<i id="cargando-1" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
        })
        .done(function(data) {
        	$('body').find('#cargando-1').remove();
        	if(data.state==="OK"){
        		var cerrarSesion = false;
        		if(actualizarCelularAgora==1 && data.stateUpdatePhone=='OK'){
        			cerrarSesion = true;
        			
        			/*
        			$.ajax({
    				  type: 'post',
    				  url: 'send-sms-validation.html',
    				  data: "telf-sms="+cel_agora,
    				  async:false,
    				  dataType:'jsonp',
    				  success: function(e){ 

    				  }
    				});
    				*/
        			        			
        			$.ajax({
    			        type: "POST",
    			        url: "close-session.html",
    			        dataType: "json",
    			        async: false,
    			        success: function (data) {
    			        	
    			        }
    				});
        		}
        		actualizarCelularAgora=-1;
        		alertMessage("<p style='font-weight: 700; text-align: center;'>¡Tu solicitud ha sido enviada!</p>"+data.message,data.btnName,cerrarSesion);
        		$inputMonto.val('');
	      	    $inputCode.val('');
	      	    $("#btnRecargaAgora").attr('disabled', true);
	      	    $("#btnRecargaAgora2").attr('disabled', true);
	      	    $("#seccion_agora_xconfirmar").css('display','none');
	      	    $("#seccion_agora_confirmada").css('display','block');
        		if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {		      	    	
	      	    	$spanValid.fadeOut(150, function () {
	          	    	$btValidate.fadeIn(200);
	          	    	$btValidate.attr('code-sent', false)
	          	    	$btValidate.attr('disabled', false);
	          	    	
	          	    	$divError.html('');
	              	  	$form.removeClass('error');
	              	    $inputStatusCode.val('DES');
	              	    $inputIdCode.val('-1');
	                });
                }else{
                	$divError.html('');
	          	  	$form.removeClass('error');
	          	    $inputStatusCode.val('DES');
	          	    $inputIdCode.val('-1');
                }
    			$divComision.addClass('hide');
    			datalayerContinuarCargarSaldo();
        	}else{
        		var msj=data.message;
        		if(data.state=='TIMEOUTTR'){
        			msj=timeoutTrMsg;
        		}
        		alertMessage("<p style='font-weight: 700; text-align: center;'>Tu solicitud no se ha generado</p><p style='text-align: justify;'>"+msj+"</p>");
        		$("#btnRecargaAgora").attr('disabled', false);
	      	    $("#btnRecargaAgora2").attr('disabled', false);
        	}
        })
    	.fail(function() {
    		$('body').find('#cargando-1').remove();
        	tagginSaldoErrorRecarga('Internet Agora', '¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
        	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        	$("#btnRecargaAgora").attr('disabled', false);
      	    $("#btnRecargaAgora2").attr('disabled', false);
    	});   
    };
    
    submitRecharge = function () {
      $btRecharge.attr('disabled', true);
      var channel = $inputMedioPago.val();
      var status_code = $inputStatusCode.val();
      var codePromotional = $inputCode.val();
      var id_code = $inputIdCode.val();
      var amount = $inputMonto.val();
      var lotocard = $inputLoto.val();
      var option = $inputOptionCard.val();
      var type_token = $inputTypeToken.val();
      
      var actbono = false;
      var actwbbono = false;
      var msjValidacion = "No aplicaste tu código promocional ¿deseas continuar sin promoción?"//"Ingresaste un código promocional pero aún no lo has aplicado.\n ¿Deseas continuar sin aplicarlo?";
      
      if(status_code==='ACT'){
    	  var idcasino = "0";
    	  if(id_code.split("|").length>1){
    		  idcasino = id_code.split("|")[0];
    	  }
    	  if(id_code==='33'){
    		  actbono=true;
    	  }else if(id_code==='34'){
    		  actwbbono=true;
    	  }else if(idcasino==='35'){
    		  actbono='true-casino|'+id_code.split("|")[1];
    	  }
      }
      
      switch (channel) {
      	case 'IZIPAY': 
    	  if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){    		  
    		 $("#confirmModal_content_id").html(msjValidacion);
			 $("#confirm_content").confirmModal({top : '30%', type : 'modal',  
				  onOkBut: 
				 	function(event, el) {
					  rechargeIzipay(amount,actbono,actwbbono, codePromotional, channel);
				  	} , 
				  onCancelBut: 
					function(event, el) {
					  $btRecharge.attr('disabled', false);
				  	} 
			  });
    	  }else{
    		  rechargeIzipay(amount,actbono,actwbbono, codePromotional, channel);
    	  }
    	  		break;
	    case 'VISANET': 
	    	  if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
	    		  $("#confirmModal_content_id").html(msjValidacion);
					 $("#confirm_content").confirmModal({top : '30%', type : 'modal',  
						  onOkBut: 
						 	function(event, el) {
							  /*
							  var vall=validarMonto();
							  if(vall<=2000){
								  rechargeVisanet(amount,actbono,actwbbono);
							  }else{
								  alertMessage("Excediste el monto máximo de recarga por día con este medio (S/ 2,000)");
							  }
							  */
							  rechargeVisanet(amount,actbono,actwbbono, codePromotional, channel);
						  	} , 
						  onCancelBut: 
							function(event, el) {
							  $btRecharge.attr('disabled', false);
						  	} 
					  });
	    	  }else{
	    		  /*
	    		  var  vall2=validarMonto();
				  if(vall2<=2000){
	    		  rechargeVisanet(amount,actbono,actwbbono);
				  }else{
					  alertMessage("Excediste el monto máximo de recarga por día con este medio (S/ 2,000)");
				  }
				  */
				  rechargeVisanet(amount,actbono,actwbbono, codePromotional, channel);
	    	  }
	    	  break;
	    case 'AGORA': 
	    	  if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
	    		  $("#confirmModal_content_id").html(msjValidacion);
					 $("#confirm_content").confirmModal({top : '30%', type : 'modal',  
						  onOkBut: 
						 	function(event, el) {
							  /*
							  var vall=validarMontoAgora();
							  if(vall<=2000){
								  rechargeAgora(amount,actbono,actwbbono);
							  }else{
								  alertMessage("Excediste el monto máximo de recarga por día con este medio (S/ 2,000)");
							  }
							  */
							  rechargeAgora(amount,actbono,actwbbono, codePromotional, channel);
						  	} , 
						  onCancelBut: 
							function(event, el) {
							  $btRecharge.attr('disabled', false);
						  	} 
					  });
	    	  }else{
	    		  /*
	    		  var  vall2=validarMontoAgora();
				  if(vall2<=2000){
					  rechargeAgora(amount,actbono,actwbbono);
				  }else{
					  alertMessage("Excediste el monto máximo de recarga por día con este medio (S/ 2,000)");
				  }
				  */
				  rechargeAgora(amount,actbono,actwbbono, codePromotional, channel);
	    	  }
	    	  break;
      	case 'LOTOCARD':
			 if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				 $("#confirmModal_content_id").html(msjValidacion);
				 $("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  rechargeLotocard(option,lotocard,actbono,actwbbono, codePromotional, channel);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				  });	
			 }else{
				 rechargeLotocard(option,lotocard,actbono,actwbbono, codePromotional, channel);
			 }
      		 break;
      	case 'BCP': 
			if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  grillaCode(null, amount, "", actbono, actwbbono,true,$spanValid,$btValidate,$divError,$form,$inputStatusCode,$inputIdCode,$inputMonto,$inputCode,$btRecharge,channel);
                          datalayerGenerarCodigoPago();
                        } , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				grillaCode(null, amount, "", actbono, actwbbono,true,$spanValid,$btValidate,$divError,$form,$inputStatusCode,$inputIdCode,$inputMonto,$inputCode,$btRecharge,channel);
                datalayerGenerarCodigoPago();
            }
      		break;
      	 case 'BBVA': 
      		if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  generarCodigoBBVA(amount, actbono, actwbbono,$spanValid,$btValidate,$divError,$form,$inputStatusCode,$inputIdCode,$inputMonto,$inputCode,$btRecharge,channel);
                          datalayerGenerarCodigoPago();
                        } , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				generarCodigoBBVA(amount, actbono, actwbbono,$spanValid,$btValidate,$divError,$form,$inputStatusCode,$inputIdCode,$inputMonto,$inputCode,$btRecharge,channel);
                datalayerGenerarCodigoPago();
            }
      		break;
      	 case 'PEFE':
	     case 'YAPE':
	     case 'PLIN': 
			if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  rechargePEFE(type_token,amount,actbono,actwbbono,codePromotional,channel);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				rechargePEFE(type_token,amount,actbono,actwbbono,codePromotional,channel);
			}
      		break;
	   case 'YAPE_TP':
	   case 'PLIN_TP': 
			if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  rechargeTUPAY(type_token,amount,actbono,actwbbono,codePromotional,channel);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				rechargeTUPAY(type_token,amount,actbono,actwbbono,codePromotional,channel);
			}
      		break;
      	case 'SPAY': 
      		if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  rechargeSPAY(type_token,amount,actbono,actwbbono,codePromotional,channel);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				rechargeSPAY(type_token,amount,actbono,actwbbono,codePromotional,channel);
			}
      		break; 
      }
      
    };

    onChangeField = function () {
      if ($form.isValid({}, {}, false)) {
        $btRecharge.attr('disabled', false);
        $inputCode.attr('disabled', false);
        
        if($inputMedioPago.val()=='VISANET'){
        	var comision = getComisionVisa(parseInt($inputMonto.val(), 10));
        	if(comision>0){
        		$divComision.removeClass('hide');
        		$("#monto_comision_visanet").html( $.trim(configLoaded.msjComVisa)+ ' ' + floatFormat(comision));
        	}else{
        		$divComision.addClass('hide');
        	}
        }else if($inputMedioPago.val()=='AGORA'){
        	var comision = getComisionAgora(parseInt($inputMonto.val(), 10));
        	if(comision>0){
        		$divComision.removeClass('hide');
        		$("#monto_comision_agora").html( $.trim(configLoaded.msjComAgr)+ ' ' + floatFormat(comision));
        	}else{
        		$divComision.addClass('hide');
        	}
        	$("#btnRecargaAgora2").attr('disabled', false);
        }
        
      } else {
        $btRecharge.attr('disabled', true);
        $inputCode.attr('disabled', true);
        
        $divComision.addClass('hide');
        
        if($inputMedioPago.val()=='AGORA'){
        	$("#btnRecargaAgora2").attr('disabled', true);
        }
      }
//      console.log($btValidate.attr('code-sent'));
//      if($btValidate.attr('code-sent')) {
        $inputCode.removeAttr('readonly').val('');
        $spanValid.fadeOut(150, function () {
          $btValidate.removeAttr('disabled').fadeIn(200);
          $btValidate.attr('code-sent', false);
        });
        
        $divError.html('');
  	  	$form.removeClass('error');
  	    $inputStatusCode.val('DES');
  	 	$inputIdCode.val('-1');
//      }
    };

    onBackLotocard = function (e) {
      e.preventDefault();
      $divConf.fadeOut(150, function() { $divForm.fadeIn(250); });
    };

    $btValidate.on('click', onValidateCode);
    $btBackForm.on('click', onBackLotocard);
    $inputMonto.on('change keyup', onChangeField);
    $inputLoto.on('change keyup', onChangeField);
  });
};

var openPopRecharge = function () {
	  //$('body').addClass('noscroll');
	  $('.pop-recharge').fadeIn(350);
	};

var closePopRecharge = function () {
	try {
		//parent.hideButtonClose();
		window.parent.postMessage('hideButtonClose','*');
	}catch(err) {
		console.log(err.message);
	}
};

var renderPopup = function () {
	var $btclose = $('.pop-recharge__close');	
	
	/*try { parent.showButtonClose(); } catch (e) { }*/
	var autoexclusion = $("#autoexclusion").val();
	
	if ( autoexclusion != undefined && autoexclusion != "true"){
		renderTabs();
	  	renderRechargeForms();
	  
	  	$('#agre_tyc').click(function(){
			$("div#alert").html("");
			openModal("#popup-tyc","");
	  	});
	  
		$('.popup .js-close-modal').click(function(event){
		  	event.preventDefault();
		  	closeModal(1);
		});
	  
	  	$('#close_sfpl').click(function(event) {
			event.preventDefault();
			$("#frame_sfpl iframe").attr("src", "about:blank");
			$("#frame_sfpl").addClass("hide");
			$("#close_sfpl").addClass("hide");
		});
		$('#close_pefl').click(function(event) {
			event.preventDefault();
			$("#frame_pefl iframe").attr("src", "about:blank");
			$("#frame_pefl").addClass("hide");
			$("#close_pefl").addClass("hide");
		});
		$('#close_yapepefl').click(function(event) {
			event.preventDefault();
			$("#frame_yapepefl iframe").attr("src", "about:blank");
			$("#frame_yapepefl").addClass("hide");
			$("#close_yapepefl").addClass("hide");
		});
		$('#close_plinpefl').click(function(event) {
			event.preventDefault();
			$("#frame_plinpefl iframe").attr("src", "about:blank");
			$("#frame_plinpefl").addClass("hide");
			$("#close_plinpefl").addClass("hide");
		});
		$('#close_yapetupayl').click(function(event) {
			event.preventDefault();
			$("#frame_yapetupayl iframe").attr("src", "about:blank");
			$("#frame_yapetupayl").addClass("hide");
			$("#close_yapetupayl").addClass("hide");
		});
		$('#close_plintupayl').click(function(event) {
			event.preventDefault();
			$("#frame_plintupayl iframe").attr("src", "about:blank");
			$("#frame_plintupayl").addClass("hide");
			$("#close_plintupayl").addClass("hide");
		});
		$('#close_sfpe').click(function(event) {
			event.preventDefault();
			$("#frame_sfpe iframe").attr("src", "about:blank");
			$("#frame_sfpe").addClass("hide");
			$("#close_sfpe").addClass("hide");
		});
		$('#close_pefe').click(function(event) {
			event.preventDefault();
			$("#frame_pefe iframe").attr("src", "about:blank");
			$("#frame_pefe").addClass("hide");
			$("#close_pefe").addClass("hide");
		});
		
	}
	
	
  
	$btclose.on('click', closePopRecharge);
};

function reiniciar(){	
	console.log("reiniciado");
}

function handleMessage(e) {
	var arrayData = e.data.split("|");
	if(arrayData[0]==='toTAV2'){
		console.log("toTAV2");
		$.ajax({
	        type: 'post',
	        url: 'tav2-session.html',
	        dataType: 'json'
		}).done(function(d) {
			if(d.message=="OK") {
				window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
			} else $(location).attr('href', d.redireccion);
	    });
	}else if(arrayData[0]==='toDDVV'){
		console.log("toDDVV");
		$.ajax({
	        type: 'post',
	        url: 'ddvv-session.html',
	        dataType: 'json'
		}).done(function(d) {
			if(d.message=="OK") {
				window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
			} else $(location).attr('href', d.redireccion);
	    });
	}else if(arrayData[0]==='showSectionChat'){
		var clientId = $("#clientId").val();
		if(!clientId){
			try{
				$aivo.chat.close();
			}catch(error){ 	}
		}
		var responseMessage = 'showSectionChat|'+clientId;
		var iframe = document.getElementById("iframeWP");
		iframe.contentWindow.postMessage(responseMessage,'*');
	}else if(arrayData[0]==='showChatbot'){
		try{
			var uid = arrayData[1];
			$aivo.user.set("ILOTID", uid );
			$aivo.chat.open(); 
		}catch(error){ 	}
	}else if(arrayData[0]==='closeLightboxCollectPrize'){
		try{
			$('body').css('overflow-y', 'scroll');
			$('body').find('#div-lightbox-collect-prize-ilot').remove();
			$('body').find('#cargando').remove();
			location.reload();
		}catch(error){ 	}
	} else if (arrayData[0]==='closeLightboxTYCPDP') {
		try {
			$('body').css('overflow-y', 'scroll');
			$('body').find('#div-lightbox-tyc-pdp').remove();
			$('body').find('#cargando').remove();
		} catch(error) {}	
	}else if(arrayData[0]==='hideLightboxIzipay'){
		$('body').find('#loading-recharge-1').remove();	
		$('body').find('#div-lightbox-izipay-ilot').remove();	
		var state = arrayData[1];
		if(state=="AUTHORIZED"){
			var uniqueIdentifier = arrayData[2];
			var number = arrayData[3];
			var brand = arrayData[4];
			var monto = arrayData[5];
			var created = arrayData[6];
			var code = arrayData[7];
			var message = arrayData[8];
			var operationNumber = arrayData[9];
			var actbono = arrayData[10];
			var actwbbono = arrayData[11];
			var codePromotional = arrayData[12];
			var channel = arrayData[13];
			var json_request = arrayData[14];
			var json_response = arrayData[15];
			var card = arrayData[16];
			var idIzipay = arrayData[17];
			if(actbono=="true-casino"){
				actbono+="|"+arrayData[11];
				actwbbono = arrayData[12];
				codePromotional = arrayData[13];
				channel = arrayData[14];
				json_request = arrayData[15];
				json_response = arrayData[16];
				card = arrayData[17];
				idIzipay = arrayData[18];
			}
			
			var rechargetoken = $('#rechargetoken').val();
			var vheaders={};
			if(rechargetoken!=null && rechargetoken!=""){
				vheaders={"rechargetoken":$('#rechargetoken').val()};
			}
			
			$.ajax({
	            type: "POST",
	            url: "rechargeIzipay.html",
	            dataType: "json",
	            headers: vheaders,
	            async: false,
	            data: "state="+state+"&uniqueIdentifier="+uniqueIdentifier+"&number="+number+"&brand="+brand+"&amount="+monto+
	            "&created="+created+"&code="+code+"&message="+message+"&operationNumber="+operationNumber+"&actbono="+actbono+
	            "&actwbbono="+actwbbono+"&codePromotional="+codePromotional+"&channel="+channel+"&operatorId="+$("#operatorId").val()+
	            "&json_request="+json_request+"&json_response="+json_response+"&idIzipay="+idIzipay,
	            beforeSend: function () {
	            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
	            },
	        })
	        .done(function(data) {
	        	$('body').find('#cargando').remove();
	        	loadRechargeRT(flagrecarga);
	        	var promotionMessage = data.promotionMessage;
	        	if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
    				promotionMessage = "";
    			}
	        	
	        	var rptaTransaccion = "";
    			rptaTransaccion+="<br>Nº Transacción:"+number;
    			rptaTransaccion+="<br>"+brand+":"+card;
    			rptaTransaccion+="<br>"+data.fecha;
    			
    			rptaTransaccion+='<br><br><span style="font-size: 11px;">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>';

    			
	        	if($.trim(codePromotional) !=='') {
                    if (promotionMessage.includes("insuficiente") == true ) {
                    	//alertMessage('<p style="text-align: justify;margin: 0px;">'+promotionMessage + '<br><br>Se ha realizado una recarga con éxito a tu saldo.<br>Monto cargado: <span>S/ '+floatFormat(monto)+"</span>"+"</p>");
                    	alertMessage('<p style="text-align: justify;margin: 0px;">'+promotionMessage + '<br><br>La recarga ha sido abonada a su saldo principal.<br>Monto cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+'<br>'+rptaTransaccion+"</p>");
                    } else {      
                    	//alertMessage('<p style="text-align: justify;margin: 0px;">'+'Se ha realizado una recarga con éxito a tu saldo. <br>' + promotionMessage+"</p>");
                    	alertMessage('<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente <br>' + promotionMessage+'<br>'+rptaTransaccion+"</p>");
                    }
                } else {
                	if($.trim(promotionMessage)!=='') {
                		//promotionMessage="<br>"+promotionMessage+"<br>";
                		promotionMessage="<br>"+promotionMessage+"<br>";
                	}else{
                		//promotionMessage="<br> Tu saldo disponible es: S/ "+floatFormat(data.newAmount);
                		promotionMessage="<br>";
                	}
                	//alertMessage('<p style="text-align: justify;margin: 0px;">'+'Se ha realizado una recarga con éxito a tu saldo. <br>Monto cargado: <span>S/ '+floatFormat(monto)+"</span>"+ promotionMessage+"</p>");
                	alertMessage('<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente <br>Saldo cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+ promotionMessage + rptaTransaccion+"</p>")
                }
				
				var $formIzi = $("#form_recharge_izi"),	
			      $inputMonto = $formIzi.find('input[name="monto"]'),
			      $inputCode = $formIzi.find('input[name="codigo"]'),
				  $btRecharge = $formIzi.find('.button__base'),
				  $divError = $formIzi.find('.form__alert_recharge'),
				  $inputStatusCode = $formIzi.find('input[name="status_code"]'),
				  $inputIdCode = $formIzi.find('input[name="id_code"]'),
				  $btValidate = $formIzi.find('.button__outline'),
				  $spanValid = $formIzi.find('.form__gift-valid');
				
				if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true' || $.trim(actwbbono)=='true') {
					$spanValid.fadeOut(150, function () {
		          	   	$btValidate.fadeIn(200);
		          	   	$btValidate.attr('code-sent', false)
		          	   	$btValidate.attr('disabled', false);
		          	    	
		          	   	$divError.html('');
		          	    $formIzi.removeClass('error');
		                $inputStatusCode.val('DES');
		                $inputIdCode.val('-1');
		            });
				}else{
                	$divError.html('');
                	$formIzi.removeClass('error');
	          	    $inputStatusCode.val('DES');
	          	    $inputIdCode.val('-1');
 	            }
				
				$inputMonto.val('');
	   	    	$inputCode.val('');
	   	    	$btRecharge.attr('disabled', true);
		 	})
	    	.fail(function() {
	    		$('body').find('#loading-recharge-1').remove();
	    		$('body').find('#cargando').remove();
	    	}); 
	    	
			
		} else if(state=="CLOSE"){
			console.log("close");
		} else if(state=="ERRORIZI"){
			var number = arrayData[2];
			var brand = arrayData[3];
			var card = arrayData[4];	
			var uniqueIdentifier = arrayData[5];
			var monto = arrayData[6];
			var code = arrayData[7];
			var json_request = arrayData[8];
			var json_response = arrayData[9];
			
			var rechargetoken = $('#rechargetoken').val();
			var vheaders={};
			if(rechargetoken!=null && rechargetoken!=""){
				vheaders={"rechargetoken":$('#rechargetoken').val()};
			}
			
			$.ajax({
	            type: "POST",
	            url: "errorIzipay.html",
	            dataType: "json",
	            headers: vheaders,
	            async: false,
	            data: "&uniqueIdentifier="+uniqueIdentifier+"&number="+number+"&brand="+brand+"&amount="+monto+
	            "&code="+code+"&operatorId="+$("#operatorId").val()+"&json_request="+json_request+"&json_response="+json_response,
	            beforeSend: function () {
	            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
	            },
	        })
	        .done(function(data) {		
	        	var fechaError = data.fecha;
//	        	if($("#operatorId").val()!="5586"){
//	        		$('body').find('#cargando').remove();
//	        		var msg = "<br>Nº Transacción:"+number;
//					msg += "<br>"+brand+":"+card;
//					msg += "<br>"+fechaError;
//					msg += "<br><br>Tu transacción ha sido denegada, por favor intenta nuevamente con otra tarjeta o comunícate con tu banco";
//						
//					alertMessage('<p style="text-align: justify;margin: 0px;">'+msg+'</p>');
//	        	}else{
	        		$.ajax({
	                    type: "post",
	                    url: "registerCA.html",
	                    headers: vheaders,
	                    dataType: 'json',
	                    data: "&medio=EPAGO&code=400&description=Tarjeta no valida&monto="+monto+"&operatorId="+$("#operatorId").val(),
	                    success: function (data) {
							$('body').find('#cargando').remove();
	                    	if(data.ban!=undefined && data.ban=="OK"){
	    						localStorage.setItem("ban", "OK");					
	    						if($("#operatorId").val()!="5586"){
	    							var ban = localStorage.getItem("ban");
	    							if(ban=="OK"){
	    								localStorage.removeItem("ban");
	    								var msgError = '<div style="font-family: \'Roboto\';"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"><p style="text-align: center;margin: 0px; line-height: 20px;"><b>Detectamos una irregularidad en tu cuenta</b><br><br>Por tu seguridad y de acuerdo con lo establecido en los T&C tu cuenta está bloqueada temporalmente.</p></div><br><br>'+
	    								'<button class="btn btn-recuperar-password" onclick="closePopupCA()" type="button">OK</button></div>'; 
	    								$('#msg-session').html(msgError);
	    								openModal("#popup-message-session","");
	    							}
		                    	}else{
		                    		window.location.href = 'security-close-session.html';
		                    	}						
	    					}else{	        	
	    			        	var msg = "<br>Nº Transacción:"+number;
	    						msg += "<br>"+brand+":"+card;
	    						msg += "<br>"+fechaError;
	    						msg += "<br><br>Tu transacción ha sido denegada, por favor intenta nuevamente con otra tarjeta o comunícate con tu banco";
	    							
	    						alertMessage('<p style="text-align: justify;margin: 0px;">'+msg+'</p>');
	    					}
	                    }
					});
//	        	}
	        })
	    	.fail(function() {
	    		$('body').find('#cargando').remove();
	    	}); 	
		}else{
			alertMessage('<p style="text-align: justify;margin: 0px;">¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.</p>');
		}
	} else{
		//reiniciar(); 
	}
}

// init scripts
$(document).ready(function () {
  renderGridView();
  //initIframes();  
  renderFormFields();
  renderAccordion(); 
  	if ( window.addEventListener ) {
	    window.addEventListener('message', handleMessage, false);
	} else if ( window.attachEvent ) { // ie8
	    window.attachEvent('onmessage', handleMessage);
	}
  
});

function verificaRecargaTupay(channel){
	var vurl="yapePlinTupayVerifyTransactionAPI.html";    	
	var rechargetoken = $('#rechargetoken').val();
	var vheaders={};
	if(rechargetoken!=null && rechargetoken!=""){
		vheaders={"rechargetoken":$('#rechargetoken').val()};
	}
	$.ajax({
        type: "post",
        url: vurl,
        headers: vheaders,
        data: "channel="+channel,
        dataType: "json",
        beforeSend: function () {
        	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
        },
        error: function () {
        	$('body').find('#cargando').remove();
        	$btRecharge.attr('disabled', false);
        	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        },
        success: function (data) {
        	var status = data.status;
        	if(status=="ACT"){
        		if(channel=="YAPE"){
      	    		$("#divVerificaRecargaYapeTupay").css("display","none");
      	    	}else if(channel=="PLIN"){
            		$("#divVerificaRecargaPlinTupay").css("display","none");
            	}
        		
        		var billetera1 = floatFormat(data.billetera1);
        		var amount = floatFormat(data.amount);
        		var mensaje="Se ha realizado una recarga con éxito a tu saldo.";
        		mensaje+='<br><br>Monto cargado: S/ '+amount;
        		mensaje+='<br>Tu saldo disponible es: S/ '+billetera1;
        		            	
            	$("#clientSale-amount").text("S/ "+floatFormat(data.billetera1));
            	$("#billetera2-amount").text(data.billetera2);
            	$("#billetera3-amount").text(data.billetera3);
        		
            	var promotionMessage = data.promotionMessage;
            	if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
            		alertMessage('<p style="text-align: justify;margin: 0px;">'+mensaje+"</p>");
            	}else{
            		alertMessage('<p style="text-align: justify;margin: 0px;">'+'Se ha realizado una recarga con éxito a su saldo.<br><br>Monto cargado: <span style="font-weight: bold;">S/ '+floatFormat(amount)+"</span><br>"+ promotionMessage+"</p>");
            	}
        	}else if(status=="PEN"){
        		alertMessage(data.message);
        	}else if(status=="ERROR"){
        		alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        	}else if(status=='TIMEOUTTR'){
        		alertMessage(timeoutTrMsg);
        	}else{
        		alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        	}
        	$('body').find('#cargando').remove();
        }
    });
}

function verificaRecargaPE(channel,type){
	var vurl="yapePlinVerifyTransaction.html";    	
	var rechargetoken = $('#rechargetoken').val();
	var vheaders={};
	if(rechargetoken!=null && rechargetoken!=""){
		vurl="yapePlinVerifyTransactionRT.html";
		vheaders={"rechargetoken":$('#rechargetoken').val()};
	}
	$.ajax({
        type: "post",
        url: vurl,
        headers: vheaders,
        data: "channel="+channel,
        dataType: "json",
        beforeSend: function () {
        	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
        },
        error: function () {
        	$('body').find('#cargando').remove();
        	$btRecharge.attr('disabled', false);
        	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        },
        success: function (data) {
        	var status = data.status;
        	if(status=="ACT"){
        		if(channel=="YAPE"){
      	    		$("#divVerificaRecargaYape").css("display","none");
      	    	}else if(channel=="PLIN"){
            		$("#divVerificaRecargaPlin").css("display","none");
            	}else if(channel=="PEFE"){
            		if(type=="1"){
            			$("#divVerificaRecargaPEFE").css("display","none");
            		}else{
            			$("#divVerificaRecargaPEFEE").css("display","none");
            		}       		                   		
            	}
        		
        		var billetera1 = floatFormat(data.billetera1);
        		var amount = floatFormat(data.amount);
        		var mensaje="Se ha realizado una recarga con éxito a tu saldo.";
        		mensaje+='<br><br>Monto cargado: S/ '+amount;
        		mensaje+='<br>Tu saldo disponible es: S/ '+billetera1;
        		            	
            	$("#clientSale-amount").text("S/ "+floatFormat(data.billetera1));
            	$("#billetera2-amount").text(data.billetera2);
            	$("#billetera3-amount").text(data.billetera3);
        		
            	var promotionMessage = data.promotionMessage;
            	if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
            		alertMessage('<p style="text-align: justify;margin: 0px;">'+mensaje+"</p>");
            	}else{
            		alertMessage('<p style="text-align: justify;margin: 0px;">'+'Se ha realizado una recarga con éxito a su saldo.<br><br>Monto cargado: <span style="font-weight: bold;">S/ '+floatFormat(amount)+"</span><br>"+ promotionMessage+"</p>");
            	}
        	}else if(status=="PEN"){
        		alertMessage(data.message);
        	}else if(status=="ERROR"){
        		alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        	}else if(status=='TIMEOUTTR'){
        		alertMessage(timeoutTrMsg);
        	}else{
        		alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        	}
        	$('body').find('#cargando').remove();
        }
    });
}

function loadRecharge(){
	$.ajax({
        type: "POST",
        url: "load_recharge.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	$("#clientSale-amount").text("S/ "+floatFormat(data.billetera1));
        	$("#billetera2-amount").text(data.billetera2);
        	$("#billetera3-amount").text(data.billetera3);
        	$("#maximoCodigosBCP").val(data.maximoCodigosBCP);
        	
        	var amtMinRechargeAgrFormateado = floatFormat(data.amtMinRechargeAgr).replace(".00","");
			var amtMaxRechargeAgrFormateado = floatFormat(data.amtMaxRechargeAgr).replace(".00","");
			$("#amtMinRechargeAgr").html(amtMinRechargeAgrFormateado);
			$("#amtMaxRechargeAgr").html(amtMaxRechargeAgrFormateado);
			$('#monto_agora').attr("data-validation-allowing", "range["+data.amtMinRechargeAgr+";"+data.amtMaxRechargeAgr+"]");
			
        	var amtMinRechargeVisaFormateado = floatFormat(data.amtMinRechargeVisa).replace(".00","");
			var amtMaxRechargeVisaFormateado = floatFormat(data.amtMaxRechargeVisa).replace(".00","");
			$("#amtMinRechargeVisa").html(amtMinRechargeVisaFormateado);
			$("#amtMaxRechargeVisa").html(amtMaxRechargeVisaFormateado);
			$('#monto_visanet').attr("data-validation-allowing", "range["+data.amtMinRechargeVisa+";"+data.amtMaxRechargeVisa+"]");
			var maxAmtPerWeekVisaFormateado = floatFormat(data.maxAmtPerWeekVisa).replace(".00","");
			if(data.maxAmtPerWeekVisa!= undefined && data.maxAmtPerWeekVisa>0){
				//$("#amtMaxRechargeWeekVisa").html(maxAmtPerWeekVisaFormateado);
				$("#amtMaxRechargeWeekVisa").html(". Recarga máxima semanal S/ "+maxAmtPerWeekVisaFormateado+".");
			}
			if(data.maxRechargePerDayVisa!=undefined && data.maxRechargePerDayVisa>0){
				//$("#maxRechargeVisa").html(data.maxRechargePerDayVisa);
				$("#maxRechargeVisa").html(" hasta en "+data.maxRechargePerDayVisa+" transacciones diarias");
			}
			
			var amtMinRechargeBcpFormateado = floatFormat(data.amtMinRechargeBcp).replace(".00","");
			var amtMaxRechargeBcpFormateado = floatFormat(data.amtMaxRechargeBcp).replace(".00","");
			$("#minAmountBCP").html(amtMinRechargeBcpFormateado);
			$("#maxAmountBCP").html(amtMaxRechargeBcpFormateado);
			$('#monto_bcp').attr("data-validation-allowing", "range["+data.amtMinRechargeBcp+";"+data.amtMaxRechargeBcp+"]");
			
			var stateRechargeVisa = data.stateRechargeVisa;
			if(stateRechargeVisa!=undefined && stateRechargeVisa=='ACTIVO'){
				$("#accordion_visanet").css('display','block');
			}
			
			var stateRechargeAgr = data.stateRechargeAgr;
			if(stateRechargeAgr!=undefined && stateRechargeAgr=='ACTIVO'){
				$("#accordion_agora").css('display','block');
			}
			
			var stateRechargeIbk = data.stateRechargeIbk;
			if(stateRechargeIbk!=undefined && stateRechargeIbk=='ACTIVO'){
				$("#accordion_interbank").css('display','block');
				$("#accordion_efectivo_interbank").css('display','block');
			}
			
			var stateRechargeBcp = data.stateRechargeBcp;
			if(stateRechargeBcp!=undefined && stateRechargeBcp=='ACTIVO'){
				$("#accordion_bcp").css('display','block');
			}
			
			var stateRechargePefe = data.stateRechargePefe;
			if(stateRechargePefe!=undefined && stateRechargePefe=='ACTIVO'){
				$("#accordion_pagoefectivo").css('display','block');
				$("#accordion_efectivo_pagoefectivo").css('display','block');
			}
			
			var stateRechargeSpay = data.stateRechargeSpay;
			if(stateRechargeSpay!=undefined && stateRechargeSpay=='ACTIVO'){
				$("#accordion_safetypay").css('display','block');
				$("#accordion_efectivo_safetypay").css('display','block');
			}
			
			var stateRechargeLoto = data.stateRechargeLoto;
			if(stateRechargeLoto!=undefined && stateRechargeLoto=='ACTIVO'){
				$("#accordion_efectivo_lotocard").css('display','block');
			}
			
			var stateRechargeYape = data.stateRechargeYape;
			if(stateRechargeYape!=undefined && stateRechargeYape=='ACTIVO'){
				$("#accordion_Yape").css('display','block');
			}
			
			var stateRechargePlin = data.stateRechargePlin;
			if(stateRechargePlin!=undefined && stateRechargePlin=='ACTIVO'){
				$("#accordion_Plin").css('display','block');
			}
			
			var amtMinRechargeIbkFormateado = floatFormat(data.amtMinRechargeIbk).replace(".00","");
			var amtMaxRechargeIbkFormateado = floatFormat(data.amtMaxRechargeIbk).replace(".00","");
			$("#amtMinRechargeIbk").html(amtMinRechargeIbkFormateado);
			$("#amtMaxRechargeIbk").html(amtMaxRechargeIbkFormateado);
			$("#amtMinRechargeIbkE").html(amtMinRechargeIbkFormateado);
			$("#amtMaxRechargeIbkE").html(amtMaxRechargeIbkFormateado);
			
			var amtMinRechargePefeFormateado = floatFormat(data.amtMinRechargePefe).replace(".00","");
			var amtMaxRechargePefeFormateado = floatFormat(data.amtMaxRechargePefe).replace(".00","");
			$("#amtMinRechargePefe").html(amtMinRechargePefeFormateado);
			$("#amtMaxRechargePefe").html(amtMaxRechargePefeFormateado);
			$("#amtMinRechargePefeE").html(amtMinRechargePefeFormateado);
			$("#amtMaxRechargePefeE").html(amtMaxRechargePefeFormateado);
			$('#monto_pagoefectivo').attr("data-validation-allowing", "range["+data.amtMinRechargePefe+";"+data.amtMaxRechargePefe+"]");
			$('#monto_pagoefectivo_efectivo').attr("data-validation-allowing", "range["+data.amtMinRechargePefe+";"+data.amtMaxRechargePefe+"]");
			
			var amtMinRechargeSpayFormateado = floatFormat(data.amtMinRechargeSpay).replace(".00","");
			var amtMaxRechargeSpayFormateado = floatFormat(data.amtMaxRechargeSpay).replace(".00","");
			$("#amtMinRechargeSpay").html(amtMinRechargeSpayFormateado);
			$("#amtMaxRechargeSpay").html(amtMaxRechargeSpayFormateado);
			$("#amtMinRechargeSpayE").html(amtMinRechargeSpayFormateado);
			$("#amtMaxRechargeSpayE").html(amtMaxRechargeSpayFormateado);
			$('#monto_safetypay').attr("data-validation-allowing", "range["+data.amtMinRechargeSpay+";"+data.amtMaxRechargeSpay+"]");
			$('#monto_safetypay_efectivo').attr("data-validation-allowing", "range["+data.amtMinRechargeSpay+";"+data.amtMaxRechargeSpay+"]");
									
			$('#num_agora').html(data.mobilePhone);
			$('#num_agora_confirmado').html(data.mobilePhone);
			
			var amtMinRechargeYapeFormateado = floatFormat(data.amtMinRechargeYape).replace(".00","");
			var amtMaxRechargeYapeFormateado = floatFormat(data.amtMaxRechargeYape).replace(".00","");
			$("#amtMinRechargeYape").html(amtMinRechargeYapeFormateado);
			$("#amtMaxRechargeYape").html(amtMaxRechargeYapeFormateado);
			$('#monto_yape').attr("data-validation-allowing", "range["+data.amtMinRechargeYape+";"+data.amtMaxRechargeYape+"]");
			
			var amtMinRechargePlinFormateado = floatFormat(data.amtMinRechargePlin).replace(".00","");
			var amtMaxRechargePlinFormateado = floatFormat(data.amtMaxRechargePlin).replace(".00","");
			$("#amtMinRechargePlin").html(amtMinRechargePlinFormateado);
			$("#amtMaxRechargePlin").html(amtMaxRechargePlinFormateado);
			$('#monto_plin').attr("data-validation-allowing", "range["+data.amtMinRechargePlin+";"+data.amtMaxRechargePlin+"]");
		
			if(data.rechargeAgora!=undefined){
				if(data.rechargeAgora=='0'){
					$("#seccion_agora_xconfirmar").css('display','block');
				}else{
					$("#seccion_agora_confirmada").css('display','block');
				}
			}
			
			configLoaded=data;
        }
	});
}

function loadRechargeRT(rstatus){
	$.ajax({
        type: "POST",
        url: "load_recharge_rt.html",
        headers: {'rechargetoken': $('#rechargetoken').val()},
        data: { 'rstatus': rstatus} ,
        dataType: "json",
        async: false,
        success: function (data) {
        	if(data.status=='OK'){
	        	$("#clientSale-amount").text("S/ "+floatFormat(data.billetera1));
	        	$("#billetera2-amount").text(data.billetera2);
	        	$("#billetera3-amount").text(data.billetera3);
	        	$("#maximoCodigosBCP").val(data.maximoCodigosBCP);
	        	
	        	var amtMinRechargeAgrFormateado = floatFormat(data.amtMinRechargeAgr).replace(".00","");
				var amtMaxRechargeAgrFormateado = floatFormat(data.amtMaxRechargeAgr).replace(".00","");
				$("#amtMinRechargeAgr").html(amtMinRechargeAgrFormateado);
				$("#amtMaxRechargeAgr").html(amtMaxRechargeAgrFormateado);
				$("#limitesRecargaAgora").html("De S/"+ amtMinRechargeAgrFormateado + "<br> a S/"+amtMaxRechargeAgrFormateado);
				$('#monto_agora').attr("data-validation-allowing", "range["+data.amtMinRechargeAgr+";"+data.amtMaxRechargeAgr+"]");
				
	        	var amtMinRechargeVisaFormateado = floatFormat(data.amtMinRechargeVisa).replace(".00","");
				var amtMaxRechargeVisaFormateado = floatFormat(data.amtMaxRechargeVisa).replace(".00","");
				$("#amtMinRechargeVisa").html(amtMinRechargeVisaFormateado);
				$("#amtMaxRechargeVisa").html(amtMaxRechargeVisaFormateado);
				$("#limitesRecargaVisa").html("De S/"+ amtMinRechargeVisaFormateado + "<br> a S/"+amtMaxRechargeVisaFormateado);
				$('#monto_visanet').attr("data-validation-allowing", "range["+data.amtMinRechargeVisa+";"+data.amtMaxRechargeVisa+"]");
				var maxAmtPerWeekVisaFormateado = floatFormat(data.maxAmtPerWeekVisa).replace(".00","");
				if(data.maxAmtPerWeekVisa!= undefined && data.maxAmtPerWeekVisa>0){
					//$("#amtMaxRechargeWeekVisa").html(maxAmtPerWeekVisaFormateado);
					$("#amtMaxRechargeWeekVisa").html(". Recarga máxima semanal S/ "+maxAmtPerWeekVisaFormateado+".");
				}
				if(data.maxRechargePerDayVisa!=undefined && data.maxRechargePerDayVisa>0){
					//$("#maxRechargeVisa").html(data.maxRechargePerDayVisa);
					$("#maxRechargeVisa").html(" hasta en "+data.maxRechargePerDayVisa+" transacciones diarias");
				}
				
				var amtMinRechargeBcpFormateado = floatFormat(data.amtMinRechargeBcp).replace(".00","");
				var amtMaxRechargeBcpFormateado = floatFormat(data.amtMaxRechargeBcp).replace(".00","");
				$("#minAmountBCP").html(amtMinRechargeBcpFormateado);
				$("#maxAmountBCP").html(amtMaxRechargeBcpFormateado);
				$("#limitesRecargaBCP").html("De S/"+ amtMinRechargeBcpFormateado + "<br> a S/"+amtMaxRechargeBcpFormateado);
				$('#monto_bcp').attr("data-validation-allowing", "range["+data.amtMinRechargeBcp+";"+data.amtMaxRechargeBcp+"]");
				
				var stateRechargeVisa = data.stateRechargeVisa;
				if(stateRechargeVisa!=undefined && stateRechargeVisa=='ACTIVO'){
					$("#accordion_visanet").css('display','block');
				}
				
				var stateRechargeAgr = data.stateRechargeAgr;
				if(stateRechargeAgr!=undefined && stateRechargeAgr=='ACTIVO'){
					$("#accordion_agora").css('display','block');
				}
				
				var stateRechargeIbk = data.stateRechargeIbk;
				if(stateRechargeIbk!=undefined && stateRechargeIbk=='ACTIVO'){
					$("#accordion_interbank").css('display','block');
					$("#accordion_efectivo_interbank").css('display','block');
				}
				
				var stateRechargeBcp = data.stateRechargeBcp;
				if(stateRechargeBcp!=undefined && stateRechargeBcp=='ACTIVO'){
					$("#accordion_bcp").css('display','block');
				}
				
				var stateRechargePefe = data.stateRechargePefe;
				if(stateRechargePefe!=undefined && stateRechargePefe=='ACTIVO'){
					$("#accordion_pagoefectivo").css('display','block');
					$("#accordion_efectivo_pagoefectivo").css('display','block');
				}
				
				var stateRechargeSpay = data.stateRechargeSpay;
				if(stateRechargeSpay!=undefined && stateRechargeSpay=='ACTIVO'){
					$("#accordion_safetypay").css('display','block');
					$("#accordion_efectivo_safetypay").css('display','block');
				}
				
				var stateRechargeLoto = data.stateRechargeLoto;
				if(stateRechargeLoto!=undefined && stateRechargeLoto=='ACTIVO'){
					$("#accordion_efectivo_lotocard").css('display','block');
				}
				
				var stateRechargeYape = data.stateRechargeYape;
				if(stateRechargeYape!=undefined && stateRechargeYape=='ACTIVO'){
					$("#accordion_Yape").css('display','block');
				}
				
				var stateRechargePlin = data.stateRechargePlin;
				if(stateRechargePlin!=undefined && stateRechargePlin=='ACTIVO'){
					$("#accordion_Plin").css('display','block');
				}
   
				var stateRechargeIzi = data.stateRechargeIzi;
				if(stateRechargeIzi!=undefined && stateRechargeIzi=='ACTIVO'){
					$("#accordion_izipay").css('display','block');
				}
				
				var stateRechargePlinTupay = data.stateRechargePlinTupay;
				if(stateRechargePlinTupay!=undefined && stateRechargePlinTupay=='ACTIVO'){
					$("#accordion_Plin_Tupay").css('display','block');
				}
				
				var stateRechargeYapeTupay = data.stateRechargeYapeTupay;
				if(stateRechargeYapeTupay!=undefined && stateRechargeYapeTupay=='ACTIVO'){
					$("#accordion_Yape_Tupay").css('display','block');
				}
				
				var amtMinRechargeIbkFormateado = floatFormat(data.amtMinRechargeIbk).replace(".00","");
				var amtMaxRechargeIbkFormateado = floatFormat(data.amtMaxRechargeIbk).replace(".00","");
				$("#amtMinRechargeIbk").html(amtMinRechargeIbkFormateado);
				$("#amtMaxRechargeIbk").html(amtMaxRechargeIbkFormateado);
				$("#amtMinRechargeIbkE").html(amtMinRechargeIbkFormateado);
				$("#amtMaxRechargeIbkE").html(amtMaxRechargeIbkFormateado);
				$("#limitesRecargaInterbank").html("De S/"+ amtMinRechargeIbkFormateado + "<br> a S/"+amtMaxRechargeIbkFormateado);
				$("#limitesRecargaEfeInterbank").html("De S/"+ amtMinRechargeIbkFormateado + "<br> a S/"+amtMaxRechargeIbkFormateado);
				
				var amtMinRechargePefeFormateado = floatFormat(data.amtMinRechargePefe).replace(".00","");
				var amtMaxRechargePefeFormateado = floatFormat(data.amtMaxRechargePefe).replace(".00","");
				$("#amtMinRechargePefe").html(amtMinRechargePefeFormateado);
				$("#amtMaxRechargePefe").html(amtMaxRechargePefeFormateado);
				$("#amtMinRechargePefeE").html(amtMinRechargePefeFormateado);
				$("#amtMaxRechargePefeE").html(amtMaxRechargePefeFormateado);
				$("#limitesRecargaPEFE").html("De S/"+ amtMinRechargePefeFormateado + "<br> a S/"+amtMaxRechargePefeFormateado);
				$("#limitesRecargaEfePEFE").html("De S/"+ amtMinRechargePefeFormateado + "<br> a S/"+amtMaxRechargePefeFormateado);
				$('#monto_pagoefectivo').attr("data-validation-allowing", "range["+data.amtMinRechargePefe+";"+data.amtMaxRechargePefe+"]");
				$('#monto_pagoefectivo_efectivo').attr("data-validation-allowing", "range["+data.amtMinRechargePefe+";"+data.amtMaxRechargePefe+"]");
				
				var amtMinRechargeSpayFormateado = floatFormat(data.amtMinRechargeSpay).replace(".00","");
				var amtMaxRechargeSpayFormateado = floatFormat(data.amtMaxRechargeSpay).replace(".00","");
				$("#amtMinRechargeSpay").html(amtMinRechargeSpayFormateado);
				$("#amtMaxRechargeSpay").html(amtMaxRechargeSpayFormateado);
				$("#amtMinRechargeSpayE").html(amtMinRechargeSpayFormateado);
				$("#amtMaxRechargeSpayE").html(amtMaxRechargeSpayFormateado);
				$("#limitesRecargaSPAY").html("De S/"+ amtMinRechargeSpayFormateado + "<br> a S/"+amtMaxRechargeSpayFormateado);
				$("#limitesRecargaEfeSPAY").html("De S/"+ amtMinRechargeSpayFormateado + "<br> a S/"+amtMaxRechargeSpayFormateado);
				$('#monto_safetypay').attr("data-validation-allowing", "range["+data.amtMinRechargeSpay+";"+data.amtMaxRechargeSpay+"]");
				$('#monto_safetypay_efectivo').attr("data-validation-allowing", "range["+data.amtMinRechargeSpay+";"+data.amtMaxRechargeSpay+"]");
										
				$('#num_agora').html(data.mobilePhone);
				$('#num_agora_confirmado').html(data.mobilePhone);
				$('#mobilePhone').val(data.mobilePhone);
				
				var amtMinRechargeYapeFormateado = floatFormat(data.amtMinRechargeYape).replace(".00","");
				var amtMaxRechargeYapeFormateado = floatFormat(data.amtMaxRechargeYape).replace(".00","");
				$("#amtMinRechargeYape").html(amtMinRechargeYapeFormateado);
				$("#amtMaxRechargeYape").html(amtMaxRechargeYapeFormateado);
				$("#limitesRecargaYape").html("De S/"+ amtMinRechargeYapeFormateado + "<br> a S/"+amtMaxRechargeYapeFormateado);
				$('#monto_yape').attr("data-validation-allowing", "range["+data.amtMinRechargeYape+";"+data.amtMaxRechargeYape+"]");
				
				var amtMinRechargePlinFormateado = floatFormat(data.amtMinRechargePlin).replace(".00","");
				var amtMaxRechargePlinFormateado = floatFormat(data.amtMaxRechargePlin).replace(".00","");
				$("#amtMinRechargePlin").html(amtMinRechargePlinFormateado);
				$("#amtMaxRechargePlin").html(amtMaxRechargePlinFormateado);
				$("#limitesRecargaPlin").html("De S/"+ amtMinRechargePlinFormateado + "<br> a S/"+amtMaxRechargePlinFormateado);
				$('#monto_plin').attr("data-validation-allowing", "range["+data.amtMinRechargePlin+";"+data.amtMaxRechargePlin+"]");
				
				var amtMinRechargeYapeTupayFormateado = floatFormat(data.amtMinRechargeYapeTupay).replace(".00","");
				var amtMaxRechargeYapeTupayFormateado = floatFormat(data.amtMaxRechargeYapeTupay).replace(".00","");
				$("#amtMinRechargeYapeTupay").html(amtMinRechargeYapeTupayFormateado);
				$("#amtMaxRechargeYapeTupay").html(amtMaxRechargeYapeTupayFormateado);
				$("#limitesRecargaYapeTupay").html("De S/"+ amtMinRechargeYapeTupayFormateado + "<br> a S/"+amtMaxRechargeYapeTupayFormateado);
				$('#monto_YapeTupay').attr("data-validation-allowing", "range["+data.amtMinRechargeYapeTupay+";"+data.amtMaxRechargeYapeTupay+"]");
				
				var amtMinRechargePlinTupayFormateado = floatFormat(data.amtMinRechargePlinTupay).replace(".00","");
				var amtMaxRechargePlinTupayFormateado = floatFormat(data.amtMaxRechargePlinTupay).replace(".00","");
				$("#amtMinRechargePlinTupay").html(amtMinRechargePlinTupayFormateado);
				$("#amtMaxRechargePlinTupay").html(amtMaxRechargePlinTupayFormateado);
				$("#limitesRecargaPlinTupay").html("De S/"+ amtMinRechargePlinTupayFormateado + "<br> a S/"+amtMaxRechargePlinTupayFormateado);
				$('#monto_PlinTupay').attr("data-validation-allowing", "range["+data.amtMinRechargePlinTupay+";"+data.amtMaxRechargePlinTupay+"]");
				
				$('#rechargetoken').val(data.rechargetoken);
				$('#operatorId').val(data.operatorId);
				
				var stateRechargeBbva = data.stateRechargeBbva;
				if(stateRechargeBbva!=undefined && stateRechargeBbva=='ACTIVO'){
					$("#accordion_bbva").css('display','block');
				}
				var amtMinRechargeBbvaFormateado = floatFormat(data.amtMinRechargeBbva).replace(".00","");
				var amtMaxRechargeBbvaFormateado = floatFormat(data.amtMaxRechargeBbva).replace(".00","");
				$("#minAmountBBVA").html(amtMinRechargeBbvaFormateado);
				$("#maxAmountBBVA").html(amtMaxRechargeBbvaFormateado);
				$("#limitesRecargaBBVA").html("De S/"+ amtMinRechargeBbvaFormateado + "<br> a S/"+amtMaxRechargeBbvaFormateado);
				$('#monto_bbva').attr("data-validation-allowing", "range["+data.amtMinRechargeBbva+";"+data.amtMaxRechargeBbva+"]");		
				$("#maximoCodigosBBVA").val(data.maximoCodigosBBVA);
				
				var amtMinRechargeIziFormateado = floatFormat(data.amtMinRechargeIzi).replace(".00","");
				var amtMaxRechargeIziFormateado = floatFormat(data.amtMaxRechargeIzi).replace(".00","");
				$("#amtMinRechargeIzi").html(amtMinRechargeIziFormateado);
				$("#amtMaxRechargeIzi").html(amtMaxRechargeIziFormateado);
				$("#amtMinRechargeIziP").html(amtMinRechargeIziFormateado);
				$("#amtMaxRechargeIziP").html(amtMaxRechargeIziFormateado);
				$("#limitesRecargaIzipay").html("De S/"+ amtMinRechargeIziFormateado + "<br> a S/"+amtMaxRechargeIziFormateado);
				$('#monto_izi').attr("data-validation-allowing", "range["+data.amtMinRechargeIzi+";"+data.amtMaxRechargeIzi+"]");
				
				if(data.rechargeAgora!=undefined){
					if(data.rechargeAgora=='0'){
						$("#seccion_agora_xconfirmar").css('display','block');
					}else{
						$("#seccion_agora_confirmada").css('display','block');
					}
				}
				
				$("#client-name").val(data.nombre);
				$("#client-lastname").val(data.apellidos);
				$("#docTypeIzi").val(data.docTypeIzi);
				$("#docNumber").val(data.docNumber);
				$("#cid").val(data.cid);
				
				configLoaded=data;
            }else{
            	var mensaje=data.message;
        		console.log("error: "+mensaje);
        		if(mensaje=='TIMEOUTTR'){
        			alertMessage(timeoutTrMsg);
        		}            		        	
            }
        }
	});
}



function floatFormat(number) {
	  number = number += '';
	  var x1 = '',
	    x2 = '',
	    rgx = /(\d+)(\d{3})/;
	  if (number !== '') {
	    var x = number.split('.');
	    x1 = x[0];
	    if (x[1] != undefined) {
	      x[1] = x[1].length < 2 ? x[1] + '0' : x[1]
	    } else {
	      x[1] = '00'
	    }
	    x2 = x.length > 1 ? '.' + x[1] : '';
	    while (rgx.test(x1)) {
	      x1 = x1.replace(rgx, '$1' + ',' + '$2')
	    }
	  }
	  return x1 + x2
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function alertMessage(e){
	$("#alertModal_content_id").html(e);
    $("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {} });
}

function alertMessage(e, textoButton, cerrarSesion){
	$("#alertModal_content_id").html(e);
	$("#btnAlertContent").html(textoButton);
	if(!cerrarSesion){
		$("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {} });
	}else{
		$("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) { try { parent.location.reload();	} catch (ex) { 	} } });
	}
}

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
}

function getComisionVisa(monto){
	var comision = 0;
	if(monto>=configLoaded.comMinRan1Visa && monto<=configLoaded.comMaxRan1Visa){
		comision=configLoaded.comAmtRan1Visa;
	}else if(monto>=configLoaded.comMinRan2Visa && monto<=configLoaded.comMaxRan2Visa){
		comision=configLoaded.comAmtRan2Visa;
	}else if(monto>=configLoaded.comMinRan3Visa && monto<=configLoaded.comMaxRan3Visa){
		comision=configLoaded.comAmtRan3Visa;
	}else if(monto>=configLoaded.comMinRan4Visa && monto<=configLoaded.comMaxRan4Visa){
		comision=configLoaded.comAmtRan4Visa;
	}
	return comision;
}

function getComisionAgora(monto){
	var comision = 0;
	if(monto>=configLoaded.comMinRan1Agr && monto<=configLoaded.comMaxRan1Agr){
		comision=configLoaded.comAmtRan1Agr;
	}else if(monto>=configLoaded.comMinRan2Agr && monto<=configLoaded.comMaxRan2Agr){
		comision=configLoaded.comAmtRan2Agr;
	}else if(monto>=configLoaded.comMinRan3Agr && monto<=configLoaded.comMaxRan3Agr){
		comision=configLoaded.comAmtRan3Agr;
	}else if(monto>=configLoaded.comMinRan4Agr && monto<=configLoaded.comMaxRan4Agr){
		comision=configLoaded.comAmtRan4Agr;
	}
	return comision;
}

function actualizarCelular(){
	$("#divCelularAgora").css('display','block');
	$("#pInfoAgoraOk").css('display','none');
	actualizarCelularAgora=1;
    datalayerActualizarNumTelf();
}

function recargaAgora2(){
	if(actualizarCelularAgora==-1 || (actualizarCelularAgora==1 && $("#form_recharge_agora_2").isValid({}, {}, false))){
		$("#btnRecargaAgora").trigger('click');
	}
}
/**
 * Render form: Derechos Arco
 */
var renderDerechosArcoFormDA = function () {
  // render fields
  var validateInputReg, validateInputReg2, validateInputReg3, validateInputReg4;
  renderDocumentFieldsDA();
  renderTermsFieldDA();
  renderDocumentFieldsLegal();

  // restrict fields
//  $('#name, #lastname').alpha({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//  $('#user, #documento-pasap, #documento-carex,#document-number-pasap-legal, #document-number-carex-legal').alphanum({allowSpace: false, disallow:'``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//  $('#email').alphanum({allowSpace: false, allow : '-_+@.'});
  $("#mobilePhone, #numberDoc,#document-number-legal").numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
 
  $('#dateBirth').mask('00/00/0000');
  
//  $('#domicilio').alphanum({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©', allow : '#.,-'});
  
	validateInputReg = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();
	
	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ\s]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
	  };
	  $('#name, #lastname').on('input', validateInputReg);
	  
	validateInputReg2 = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();

	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-Z\d]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
		};
		$('#user, #documento-pasap, #document-carex, #document-number-pasap-legal, #document-number-carex-legal').on('input', validateInputReg2);
			
	validateInputReg3 = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();

	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-Z\d-_+@.]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
		};
		$('#email').on('input', validateInputReg3);
		
	validateInputReg4 = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();

	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\s#°.,-\d]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
		};
		$('#domicilio').on('input', validateInputReg4);
  
  // validate fields
  $.validate({
    form: '#derechos_arco_register_form',
    modules: 'security, date, logic',
    scrollToTopOnError: false,
    onModulesLoaded: function () {
      var config = {
        bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@).</span>',
        weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@).</span>',
        good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
        strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
      };
      $('#password').displayPasswordStrength(config);
    },
    onElementValidate : function(valid, $el, $form) {
      if ($form.isValid({}, {}, false)) {
        $('#enviarPD').attr('disabled', false);
      } else {
        $('#enviarPD').attr('disabled', true);
      }
    },
    onError: function ($form) {
      var $error = $form.find('.has-error');
      if ($error.length > 0) {
        $error = $error.first();
        $('html, body').animate({ scrollTop: $error.offset().top - 16 });
      }
    },
    onSuccess: function () {
      //submitRegisterForm();
      return false;
    }
  });
};

/**
 * Render Tipo documento feature Derechos Arco
 */
var renderDocumentFieldsDA = function () {
  var $select = $('#typeDoc'),
    $fields = $('.form__optional'),
    onChangeDocument3;

  onChangeDocument3 = function () {
    var $input, isTipoDoc;

    switch ($select.val()) {
    case 'DNI':
      $input = $('#numberDoc');
      isTipoDoc = true;
      break;
    case 'PASAP':
      $input = $('#documento-pasap');
      isTipoDoc = true;
      break;
    case 'CAREX':
      $input = $('#documento-carex');
      isTipoDoc = true;
      break;
    case '':
      $input = $('#numberDoc');
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

  $select.on('change', onChangeDocument3);
};

/**
 * Render Tipo documento-legal feature
 */
var renderDocumentFieldsLegal = function () {
  var $select = $('#document-type-legal'),
    $fields = $('.form__optional2'),
    onChangeDocument2;

  onChangeDocument2 = function () {
    var $input, isTipoDoc;

    switch ($select.val()) {
    case 'DNI':
      $input = $('#document-number-legal');
      isTipoDoc = true;
      break;
    case 'PASAP':
      $input = $('#document-number-pasap-legal');
      isTipoDoc = true;
      break;
    case 'CAREX':
      $input = $('#document-number-carex-legal');
      isTipoDoc = true;
      break;
    case '':
      $input = $('#document-number-legal');
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

  $select.on('change', onChangeDocument2);
};

var renderTermsFieldDA = function () {
  var $input = $('#terms'),
    $form = $('#derechos_arco_register_form'),
    onChangeTerms;
  var $input2= $('#solicitud_f');
  
  var $name = $('#name');
  var $appaterno = $('#lastname');
  var $documentnumber = $('#numberDoc');
  var $documentopasap = $('#documento-pasap');
  var $documentocarex = $('#documento-carex');
  var $userclient = $('#user');
  var $email = $('#email');
  var $mobilephone = $('#mobilePhone');
  var $domicilio = $('#domicilio');
  var $documentnumberlegal = $('#document-number-legal');
  var $documentopasaplegal = $('#document-number-pasap-legal');
  var $documentocarexlegal = $('#document-number-carex-legal');	
  var $razonsolicitud = $('#razon_solicitud_pd');
  var $mobilephone = $('#mobile-phone');

  onChangeTerms = function () {
	
    if ($form.isValid({}, {}, false)) {
      $('#enviarPD').attr('disabled', false);
    } else {
      $('#enviarPD').attr('disabled', true);
    }
  };

  $input.on('change', onChangeTerms);
  $input2.on('change', onChangeTerms);
  
  $name.on('keyup', onChangeTerms);
  $appaterno.on('keyup', onChangeTerms);
  $documentnumber.on('keyup', onChangeTerms);
  $documentopasap.on('keyup', onChangeTerms);
  $documentocarex.on('keyup', onChangeTerms);
  $userclient.on('keyup', onChangeTerms);
  $email.on('keyup', onChangeTerms);
  $mobilephone.on('keyup', onChangeTerms);
  $domicilio.on('keyup', onChangeTerms);
  $documentnumberlegal.on('keyup', onChangeTerms);
  $documentopasaplegal.on('keyup', onChangeTerms);
  $documentocarexlegal.on('keyup', onChangeTerms);
  $razonsolicitud.on('keyup', onChangeTerms);
  $domicilio.on('keyup', onChangeTerms);

};

//img		

$('#tipo_solicitudes input[type="checkbox"]').on('change', function() {
	
	 var x =$(this).val();
	if(x == "1"){
		tipsoli = "Acceso";
	}else if(x == "2"){
		tipsoli = "Rectificación";
	}else if(x == "3"){
		tipsoli = "Cancelación";
	}else if(x == "4"){
		tipsoli = "Oposición";
	}

	 $( "#solicitud_f" ).on( "click", function() {
		 //$( "#solicitud_f" ).addClass("selected");
		});
	
	 
	 if($(this).prop('checked')){

		 //trigger
		 
		 if( !$( "#solicitud_f" ).prop('checked')){
			 $( "#solicitud_f" ).trigger( "click" );
			 }
		 				 
					
	if( x == "1"){ 	
		$('#razon_solicitud').html('<span">III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">ACCESO</span>');
	}else if(x== "2"){	
		$('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">RECTIFICACIÓN</span>');				
	}else if(x == "3"){ 		
		$('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">CANCELACIÓN</span>');
	}else if(x == "4"){ 			
		$('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span style="color:#1a6d30">OPOSICIÓN</span>');				
	}

	 }else{
		 $('#razon_solicitud').html('<span">III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span><span></span>');
		 $( "#solicitud_f" ).trigger( "click" );

	}											
	   $('#tipo_solicitudes input[type="checkbox"]').not(this).prop('checked', false);
	
	});


$("#legal-form").change(function() {
    if(this.checked) {
        $('#form-legal').removeClass('view-legal');
        $('#tipo_2').html('<label>III.TIPO DE SOLICITUD A INGRESAR.</label>');
        $('#razon_solicitud').html('<span>IV.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span>  ');
        
    }else{
    	$('#form-legal').addClass('view-legal');
    	$('#tipo_2').html('<label>II.TIPO DE SOLICITUD A INGRESAR.</label>');
        $('#razon_solicitud').html('<span>III.COMÉNTANOS EL DETALLE DE TU SOLICITUD DE </span>  ');

        $('#name-legal').val('');
        $('#ap-paterno-legal').val('');
        $('#document-number-legal').val('');
        $('#document-number-pasap-legal').val('');
        $('#document-number-carex-legal').val('');
        $('#img_legal').html('');
        $('#img_legal2').html('');
        imgBase64P3Trans = "";
		imgBase64P4Trans = "";	
	}

    var $form = $('#derechos_arco_register_form');
    if ($form.isValid({}, {}, false)) {
	      $('#enviarPD').attr('disabled', false);
	    } else {
	      $('#enviarPD').attr('disabled', true);
	    }
	
});


var renderFormFields2 = function () {
	  // pulldown
	  $(".form__select2 select").each(function () {
	    var $this = $(this),
	      $pull = $this.parent();

	    if ($pull.find("div").length === 0) {
	      $pull.prepend("<div></div>");
	    }

	    if ($this.val() === "") {
	      $pull.removeClass("selected");
	    } else {
//	      $pull.children("div").text($this.children(":selected").text());
//	      $pull.addClass("selected");
	    }

	    $this.on('change', function () {
	      $pull.children("div").text($this.children(":selected").text());
	      if ($this.val() === "") {
	        $pull.children("div").text('');
	        $pull.removeClass("selected");
	      } else {
	        $pull.children("div").text($this.children(":selected").text());
	        $pull.addClass("selected");
	      }
	    });
	  });

};

var dep;
var depart;
var provi;
var distri;
//if($('#notvalidate').length>0){
//	$('#departamento').on('change',function(){
//		var $this = $(this)
//		depart = $this.children(":selected").text()
//		dep = $('#departamento').val();
//		
//		console.log(dep);
//		
//		$('#provincia').parent().removeClass('selected');
//		$('#provincia').siblings('div').html('');
//		$('#provincia').empty().append('<option value="" >Provincia</option> ');
//	
//		$('#distrito').parent().removeClass('selected');
//		$('#distrito').siblings('div').html('');
//		$('#distrito').empty().append('<option value="" >Distrito</option> ');
//	
//	
//		$.ajax({
//			type: "GET",
//			url: "getProvincias.html?departamento=" + dep,
//			dataType: "json",
//		        async: false,
//	      success: function (data) {
//	
//		        	$.each(data,function(i,obj){
//		        		$('#provincia').append('<option value='+obj.provinceId+'>'+obj.provinceName+'</option>');
//		     	
//		        	 });					
//		        }    
//		        
//			});  
//								
//	});
//	
//	$('#provincia').change(function(){
//		var $this = $(this)
//		provi = $this.children(":selected").text()
//		var prov = $('#provincia').val();
//		console.log(prov);
//					
//	
//		$.ajax({
//			type: "GET",
//			url: "getDistritos.html?provincia=" + prov +"&&departamento=" + dep,
//			dataType: "json",
//		        async: false,
//	        success: function (data) {
//	
//		        	$.each(data,function(i,obj){
//		        		$('#distrito').append('<option value='+obj.districId+'>'+obj.districtName+'</option>');
//		     	
//		        	 });					
//		        }    
//	  	        
//			});  
//								
//	});
//	
//	$('#distrito').change(function(){
//		var $this = $(this)
//		distri = $this.children(":selected").text()
//	
//	});	
//
//}

$('#enviarPD').click(function(){
	  
	var response = grecaptcha.getResponse();
	var ico = $(this).siblings('i');
	var nacion = $('#nacionalidad').children(":selected").text();
	if(response.length !=0){
				
		 $.ajax({
              url: "enviarDerechosArco.html",
              data: {"imgBase64P1Trans":imgBase64P1Trans,"imgBase64P2Trans":imgBase64P2Trans,"nombres":$('#name').val(),"apellidos":$('#lastname').val(),
	              "email":$('#email').val(),"dni":$('#numberDoc').val(),"document-number-pasap":$('#documento-pasap').val(),"document-number-carex":$('#documento-carex').val(),"usuario":$('#user').val(),"telefono":$('#mobilePhone').val(),"departamento":depart,
	              "provincia":provi,"distrito":distri,"domicilio":$('#domicilio').val(),"solicitud":tipsoli,"razon":$('#razon_solicitud_pd').val(), "name-legal":$('#name-legal').val(),
	              "ap-paterno-legal":$('#ap-paterno-legal').val(),"document-number-legal":$('#document-number-legal').val(),"document-number-pasap-legal":$('#document-number-pasap-legal').val(),
	              "document-number-carex-legal":$('#document-number-carex-legal').val(),"imgBase64P3Trans":imgBase64P3Trans,"imgBase64P4Trans":imgBase64P4Trans, "document-type": $("#typeDoc").val(), "document-type-legal": $("#document-type-legal").val(), 
	              "is-representante": $('#legal-form').prop("checked"), "nacionalidad":nacion
	              },
              type: 'POST',
              dataType: 'json',
              beforeSend: function () {            	 
            	  $(ico).addClass('loading');
              },
              error: function () {           	 
            	  $(ico).removeClass('loading');
            	  alertMessagePD('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
              },
              success: function (data) {            	 
            	  $(ico).removeClass('loading');
            	  if(data.message==="OK"){            		
            		  alertMessagePD("Tu solicitud de Derechos Arco ha sido enviada, te responderemos dentro del plazo establecido.",false);
            	  }else if(data.message ==="IMGKO"){
            		  alertMessagePD(data.errorimg,true);
            	  }else if(data.message ==="KO"){
	            	 alertMessagePD('¡No se envio el correo! \nPor favor inténtelo nuevamente.',true);  
	              } else{
	            		  alertMessagePD(data.error,true);	            		  
	            	  }           	 
              }
		  });

	}else{
		alertMessagePD('Por seguridad, debes seleccionar el código captcha.',true);
		
	}
});


$('#imgDNITransferencia').on("click",function(){
	$(this).val('');
	console.log(this);
	
});

$('#imgDNITransferencia2').on("click",function(){
	$(this).val('');
	console.log(this);
	
});

$('#imgDNITransferencia3').on("click",function(){
	$(this).val('');
	console.log(this);
	
});

$('#imgDNITransferencia4').on("click",function(){
	$(this).val('');
	console.log(this);
	
});

function alertMessagePD(e,direccion){
	$("#alertModal_content_id").html(e);
	if(direccion){
		$("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {} });
	}else{
		$("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) { try { $(parent.location).attr('href', 'home.html');	} catch (ex) { 	} } });
	} 
}

var numberDoc='';
//validacion de n° de documento
$( "#numberDoc" ).keyup(function() {
	if($( "#numberDoc" ).val()!=numberDoc){
		if($( "#numberDoc" ).val().length==8 && $('#name').length>0){
			validarDocumento($("#typeDoc option:selected").val(),$("#numberDoc").val());
			numberDoc=$( "#numberDoc" ).val();
		}if ($("#numberDoc").val().length == 8) {
			var docType = $("#typeDoc option:selected").val(); 
			var document = $("#numberDoc").val();
			var birthDate = $("#dateBirth").val();
			var names = $("#name").val();
			var surnames = $("#lastname").val();

			validarDocumentoReniec(docType, document, birthDate,
					names, surnames);
		}else{
				$('#divNumberDoc').css("margin-bottom","28px");
				$('#numberDoc_msg').text("ESTE DATO SERÁ USADO COMO TU USUARIO");
				$('#numberDoc_msg').css("color","#07663a");
				$('#divNumberDoc').css("border", "1px solid #666666");
				$('#divNumberDoc label').css("color", "#666666");
		}
	}
	numberDoc=$( "#numberDoc" ).val();
});

var documentoPasap='';
$( "#documento-pasap" ).keyup(function() {
	if($( "#documento-pasap" ).val()!=documentoPasap){
		if($( "#documento-pasap" ).val().length>=9 && $( "#documento-pasap" ).val().length<=12 && $('#name').length>0){
			validarDocumento($("#typeDoc option:selected").val(),$("#documento-pasap").val());
			documentoPasap=$( "#documento-pasap" ).val();
		}if ($( "#documento-pasap" ).val().length>=9 && $("#name").val().length >= 0 && $("#dateBirth").val().length >= 8 && $("#lastname").val().length >= 0) {
			var docType = $("#typeDoc option:selected").val(); 
			var document = $("#documento-pasap").val();
			var birthDate = $("#dateBirth").val();
			var names = $("#name").val();
			var surnames = $("#lastname").val();

			validarDocumentoReniec(docType, document, birthDate,
					names, surnames);
		}
		else{			
				$('#div-documento-pasap').css("margin-bottom","28px");
				$('#documento_pasap_msg').text("ESTE DATO SERÁ USADO COMO TU USUARIO");
				$('#documento_pasap_msg').css("color","#07663a");
		}
		documentoPasap=$( "#documento-pasap" ).val();
	}
	
});

var documentoCarex='';
$( "#documento-carex" ).keyup(function() {
	if($( "#documento-carex" ).val()!=documentoCarex){
		if($( "#documento-carex" ).val().length>=9 && $( "#documento-carex" ).val().length<=12 && $('#name').length>0){
			validarDocumento($("#typeDoc option:selected").val(),$("#documento-carex").val());
			documentoCarex=$( "#documento-carex" ).val();
		}if ($( "#documento-carex" ).val().length>=9) {
			var docType = $("#typeDoc option:selected").val(); 
			var document = $("#documento-carex").val();
			var birthDate = $("#dateBirth").val();
			var names = $("#name").val();
			var surnames = $("#lastname").val();

			validarDocumentoReniec(docType, document, birthDate,
					names, surnames);
		}
		
		else{
				$('#div-documento-carex').css("margin-bottom","28px");
				$('#documento_carex_msg').text("ESTE DATO SERÁ USADO COMO TU USUARIO");
				$('#documento_carex_msg').css("color","#07663a");	
				$('#div-documento-carex').css("border", "1px solid #666666");
				$('#div-documento-carex label').css("color", "#666666");
		}
	}
	documentoCarex=$( "#documento-carex" ).val();
});


var name = '';
var lastName = '';
var dateBirth = '';

// Validación de nombres
$("#name").keyup(function() {            
    if ($("#name").val().length >= 1) {
        validarPorTipoDocumento();
    } else {
        $('#name_msg').css("margin-bottom", "28px").text("").css("color", "#07663a");
    }
    name = $("#name").val();
});

// Validación de apellidos
$("#lastname").keyup(function() {
    if ($("#lastname").val().length >= 1) {
        validarPorTipoDocumento();
    } else {
        $('#last_name_msg').css("margin-bottom", "28px").text("").css("color", "#07663a");
    }
    lastName = $("#lastname").val();
});

// Validación de fecha de nacimiento
$("#dateBirth").on("change", function() {
    dateBirth = $("#dateBirth").val();
    if (dateBirth) {
        validarPorTipoDocumento();
    } else {
        $('#dateBirth_msg').css("margin-bottom", "28px").text("").css("color", "#07663a");
    }
});

function validarPorTipoDocumento() {
    var docType = $("#typeDoc").val();
    var birthDate = $("#dateBirth").val();
    var names = $("#name").val();
    var surnames = $("#lastname").val();

    // Mapeo de los inputs según el tipo de documento
    var documentFields = {
        "CAREX": "#documento-carex",
        "PASAP": "#documento-pasap",
        "DNI": "#numberDoc"
    };

    // Validar si el tipo de documento tiene un campo asociado
    if (documentFields[docType]) {
        var documentNumber = $(documentFields[docType]).val();
        if (docType === "PASAP" && (!documentNumber || birthDate.length < 1 || names.length < 2 || surnames.length < 1)) {
            console.log("Falta llenar campos para PASAP");
            return;
        }
        validarDocumentoReniec(docType, documentNumber, birthDate, names, surnames);
    } else {
        console.log("Falta llenar campos o tipo de documento no reconocido");
    }
}




function validarDocumento(docType, document){
	if($('#notvalidate').length>0){
		return;
	}
	var ico = $(this).siblings('i');
//	var urlref=window.location.href;
	$.ajax({
        url: "documentvalidation.html",
        data: {"docType":docType,"document":document},
        type: 'POST',
        dataType: 'json',
        beforeSend: function () {            	 
      	  $(ico).addClass('loading');
        },
        error: function () {           	 
      	  $(ico).removeClass('loading');
      	  alertMessagePD('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
        },
        success: function (data) {            	 
      	  $(ico).removeClass('loading');
      	  if(data.message==="OK"){  
      		  if(data.flag==="9"){
      			var operatorIdApi=$("#operatorIdApi").val();
      			var url="ESTE DOCUMENTO YA TIENE UNA CUENTA CREADA. PARA TERMINAR TU REGISTRO <a id=show_complete_registration href='client_lotocard_complete_form.html"+"?typedoc="+docType+"&document="+document+
			  		"' style='color:red; font-weight:900;'><u>HAZ CLIC AQUÍ</u></a>";      			  		
  			  	if(operatorIdApi==='5588'){
			  			var paramref=(window.location.href).split('?')[1];
			  		url="ESTE DOCUMENTO YA TIENE UNA CUENTA CREADA. PARA TERMINAR TU REGISTRO <a id=show_complete_registration href='client_lotocard_complete_form.html"+"?typedoc="+docType+"&document="+document+
			  		"&"+paramref+"' style='color:red; font-weight:900;'><u>HAZ CLIC AQUÍ</u></a>";
			  		}
      			  switch(docType){
      			  	case "DNI":
      			  		$('#divNumberDoc').css("margin-bottom",50);      			  		
      			  		$('#numberDoc_msg').html(url);
      			  		$('#numberDoc_msg').css("color","red");
      			  		break;
      			  	case "PASAP":
      			  		$('#div-documento-pasap').css("margin-bottom",50);      			  		
      			  		$('#documento_pasap_msg').html(url);
      			  		$('#documento_pasap_msg').css("color","red");
      			  		break;
      			  	case "CAREX":
      			  		$('#div-documento-carex').css("margin-bottom",50);      			  		
      			  		$('#documento_carex_msg').html(url);
      			  		$('#documento_carex_msg').css("color","red");
      			  		break;
      			  }
      			
      		  }else if(data.locked==="SI"){
	      			var titulo = "Usuario bloqueado";
            		var mensaje = "Tu usuario ha sido bloqueado, comunícate con La Tinka al 5135502.";
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error"  type="button" onclick="goRegister()">Aceptar</button></div>';
                    $('#close-popup-message').hide();
                    $('#msg-message').html(msgError);                    
                	openModal("#popup-message","");
      		  }else{      			  
      			var mensaje = "Este documento ya tiene una cuenta creada. Ingresa a tu cuenta con tu número de documento y contraseña. Si no lo recuerdas selecciona “¿Olvidaste tu contraseña?” para cambiarla.";
                var msgError = '<div id="doc-is-registered"><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                '<button class="btn btn-login-error"  type="button" onclick="goRecoverPassword()">&iquest;Olvidaste tu contrase&ntilde;a?</button></div>';
                $('#close-popup-message').show();
                $('#msg-message').html(msgError);
            	openModal("#popup-message","");      			
      					
      		  }              		
      		  
      	  } else{
      		  if(data.message==='CONSULT'){
      			console.log("documento no registrado");
      		  }else{
//      		  	alertMessagePD(data.error,false);
      			var titulo = data.titulo;
        		var mensaje = data.mensaje;
                var msgError = '<div id="doc-is-registered"><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                '<button class="btn btn-login-error"  type="button" onclick="closeModal(\'popup-message\'); clearDocument();">Aceptar</button></div>';
                $('#close-popup-message').show();
                $('#msg-message').html(msgError);
          	    openModal("#popup-message","");
      		  }
           }           	 
        }
	  });
}

function validarDocumentoReniec(docType, document, birthDate, names, surnames) {
	var ico = $(this).siblings('i');
	$
			.ajax({
				url : "reniecvalidation.html",
				data :{
					"docType" : docType,
					"document" : document,
					"birthDate" : birthDate,
					"names" : names,
					"surnames" : surnames
				} ,
				type : 'POST',
				dataType : 'json',
				beforeSend : function() {
					$(ico).addClass('loading');
				},
				error : function() {
					$(ico).removeClass('loading');
					alertMessagePD('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
				},
				success : function(data) {
					
					var $form = $('#client_lotocard_register_form');
					
					if (data.error_code === 200) {
						console.log("Documento válido");
						
						if(data.error_message === "DNI No Valido" && data.data === null){
							$('#numberDoc_msg').text("INGRESE UN DNI VÁLIDO");
							$('#numberDoc_msg').css("color", "#E9041B");
							$('#divNumberDoc').css("border", "1px solid #E9041B");
							$('#divNumberDoc label').css("color", "#E9041B");
						}
						
						if(data.error_message === "CAREX No Valido" && data.data === null){
							$('#documento_carex_msg').text(
							"INGRESE UN CARNET DE EXTRANJERÍA VÁLIDO");
							$('#documento_carex_msg').css("color", "#E9041B");
							$('#div-documento-carex').css("border", "1px solid #E9041B");
							$('#div-documento-carex label').css("color", "#E9041B");
						}
						
						if(names === ""){
							data.data.nombre = true;
						}
						if(surnames === ""){
							data.data.apellidos = true;
						}
						if(birthDate === ""){
							data.data.fechaNacimiento = true;
						}

						if (data.data.apellidos) {
							$('#last_name_msg')
									.text("");
							$('#last_name_msg').css("color", "#07663a");
						} else {
							$('#last_name_msg').css("margin-bottom",50);  
							$('#last_name_msg')
									.text("INGRESA TUS APELLIDOS IGUAL A TU DOCUMENTO DE IDENTIDAD");
							$('#last_name_msg').css("color", "#E9041B");
						}

						if (data.data.nombre) {
							$('#name_msg')
									.text("");
							$('#name_msg').css("color", "#07663a");
						} else {
							$('#name_msg').css("margin-bottom",50); 
							$('#name_msg')
									.text("INGRESA TUS NOMBRES IGUAL A TU DOCUMENTO DE IDENTIDAD");
							$('#name_msg').css("color", "#E9041B");
						}

						if (data.data.fechaNacimiento) {
							$('#dateBirth_msg')
									.text("");
							$('#dateBirth_msg').css("color", "#07663a");
						    	  if(validateMessagges()){
						    		  if ($form.isValid({}, {}, false) ) {
						    	        $('#resgisterUser').attr('disabled', false); //pintarse el boton guardado     
						    	  }		
							}
						} else {
							$('#dateBirth_msg').css("margin-bottom",50); 
							$('#dateBirth_msg').text("INGRESA TU FECHA DE NACIMIENTO IGUAL A TU DOCUMENTO DE IDENTIDAD. DEBES SER MAYOR DE EDAD.");
							$('#dateBirth_msg').css("color", "#E9041B");
							
						    	  if(!validateMessagges()){
										if ($form.isValid({}, {}, false) ) {
						    	        $('#resgisterUser').attr('disabled', true); //pintarse el boton guardado
						    	        
						    	  }
					    	  }
						}

						
					} else if (data.error_code === 400
							|| data.error_code === 500) {
						console.log("Documento no válido");

						switch (docType) {
						case "DNI":
							$('#numberDoc_msg').css("margin-bottom",50); 
							$('#numberDoc_msg').html(url);
							$('#numberDoc_msg').css("color", "#E9041B");
							break;
						case "CAREX":
							$('#documento_carex_msg').css("margin-bottom",50); 
							$('#documento_carex_msg').html(url);
							$('#documento_carex_msg').css("color", "#E9041B");
							break;
						}

						$('#numberDoc_msg').text(
								"INGRESE UN DOCUMENTO VÁLIDO");
						$('#numberDoc_msg').css("color", "#E9041B");
					}else{
						$('#numberDoc_msg').text(
							"ESTE DATO SERÁ USADO COMO TU USUARIO");
						$('#numberDoc_msg').css("color", "#07663a");
						console.log("Servicio Caido");
					}
				},
				error : function() {
					console.log("Error en la validación del documento. Intente nuevamente.");
					$('#numberDoc_msg').text("ESTE DATO SERÁ USADO COMO TU USUARIO");
					$('#numberDoc_msg').css("color", "#07663a");
				}
			});
}

//fin de vacidacion de n° de documento

function goRecuperarUsuario(){			
	window.location.href = 'recuperar-user.html';  
}

function goLogin(){			
	//window.location.href = 'security_login_execute_authentication.html';
	getFastTokenAndRedirect('');
}

function goRegistro(){
	var operatorIdApi=$('#operatorIdApi').val();
	if(operatorIdApi==='5588'){
		window.location.href = $('#redirect558cancel').val();
	}else{
		window.location.href = 'client_lotocard_show_form.html';
	}
	  
}

$('#numberDoc').on('input', function () { 
    this.value = this.value.replace(/[^0-9]/g,'');
});

function clearDocument(){
	if($("#doc-is-registered").length>0){
		$("#numberDoc").val("");
		$("#documento-pasap").val("");
		$("#documento-carex").val("");	
	}
}