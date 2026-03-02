/*globals $, window, document, console, setTimeout, ga, google_tag_manager */
'use strict';

var METHOD = 'GET';

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
  bdate.setFullYear(bdate.getFullYear() - 18);

  $input.datepicker({
    language: 'es-ES',
    offset: 8,
    endDate: bdate,
    trigger: '#showCalendar'
  });

  $input.on('show.datepicker', function () {
    $input.trigger('focus');
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

  onChangeTerms = function () {
	
    if ($form.isValid({}, {}, false)) {
      $('#resgisterUser').attr('disabled', false);
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
  
};

/**
 * Render form: Registro
 */
var renderRegisterForm = function () {
  // render fields
  renderDocumentFields();
  renderDateField();
  renderPasswordField();
  renderTermsField();

  // restrict fields
  $('#name, #lastname').alpha({disallow:'áéíóúÁÉÍÓÚàèìòùÀÈÌÒÙ``´´'});
  $('#user, #documento-pasap, #documento-carex').alphanum({allowSpace: false});
  $('#email').alphanum({allowSpace: false, allow : '-_+@.'});
  $("#mobilePhone, #numberDoc").numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
  $('#dateBirth').alphanum({allow: '/', allowUpper: false, allowLower: false});

  $('#dateBirth').mask('00/00/0000');
  // validate fields
  $.validate({
    form: '#client_lotocard_register_form',
    modules: 'security, date, logic',
    scrollToTopOnError: false,
    onModulesLoaded: function () {
      var config = {
        bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Agrega letras, números y símbolos ($%&+!@).</span>',
        weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Agrega letras, números y símbolos ($%&+!@).</span>',
        good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
        strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
      };
      $('#password').displayPasswordStrength(config);
    },
    onElementValidate : function(valid, $el, $form) {
      if ($form.isValid({}, {}, false)) {
        $('#resgisterUser').attr('disabled', false);
      } else {
        $('#resgisterUser').attr('disabled', true);
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
                    $('.step-01').fadeOut(150, function () { $('.step-03').fadeIn(250); });              
                    $('body').find('#cargando').remove();
                    tagginFelicitaciones();
        		} else {
        			
        			$("#msjError").html(e.message);
            		$('#form_activate').addClass('error-activate');
            		taggingErrorCodigoIn();
            		
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
    $button = $('#btresend'),
    urlResend = $form.attr('action');

  $button.attr('disabled', true);

  var phone = $.trim($("#telf-sms").val());
  var phonePattern = new RegExp(/^([9]{1})([0-9]{8})$/);
  var phoneRes = phonePattern.test(phone);
	 
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
          		if(e.status!=200){
          			$("#msjErrorSendCode").html(e.message);
          			$form.addClass('error-activate');
          			$('#btresend').attr('disabled', false);
          		} else {
          			$('#btactivate').attr('disabled', true);
                    $(".form__code input").val('');
                    $('#btresend').attr('disabled', false);

                    $('#celSMS').html(phone);
          			
          			//gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - enviar sms');
          		    $('#form_activate').removeClass('error-activate');
          		    $("#form_resend").removeClass('error-activate');
                    $('.step-02').fadeOut(150, function () { $('.step-01').fadeIn(250); });
                    tagginActivarCuenta();
          		}
	       }
    }).always(function() {
   	 $(ico).removeClass('loading');
    });

  } else {
	$("#msjErrorSendCode").html("Ingrese un tel&eacute;fono v&aacute;lido");
	$form.addClass('error-activate');
	$('#btresend').attr('disabled', false);
  }
};

/**
 * Render Form: Resend code
 */
var renderResendCode = function () {
  var $input = $('#telf-sms'),
    $linkBack = $('#backToActivate'),
    onClickBack,onChangeCel;

  $input.numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
  
  onChangeCel = function () {
    if ($("#form_resend").isValid({}, {}, false)) {
      $('#btresend').attr('disabled', false);
    } else {
      $('#btresend').attr('disabled', true);
    }
  };
		  
  $input.on('keyup', onChangeCel);
  
  // validate fields
  $.validate({
    form : '#form_resend',
    onError : function () {
      //console.log('Error');
    },
    onSuccess : function () {
      submitResendForm();
      return false;
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
    renderTableRecharge,grillaCode,renderizarBCP;

  // restrict fields
  $('input[name="monto"]').numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
  $('input[name="codigo"]').alphanum({allowSpace: false});
  $('input[name="lotocard"]').numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});

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
  
  $('#grillaBCP').on('click', '.bcpverify', function (event) {	 
      var amount = $("#clientSale-amount").text().replace(',','');
      var trx = $(this).data('pin');
      $.ajax({
          type: "GET",
          url: "verificar.html",
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
	      },
          success: function (data) {
              if (data.state === 'OK') {
                  loadRecharge();
                  grillaCode(null,null,null,false,false,false,null,null,null,null,null,null,null,null,null);
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
          }
      });
      if ($('#grillaBCP').find('.bcpdelete').length == 1) {
          $('#grillaBCP').html('');
      }
  });
  
  renderizarBCP = function (data){
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
  };
  
  grillaCode = function (event,amount, transact, actbono, actwbbono,recharge,spanValid,btValidate,divError,form,inputStatusCode,inputIdCode,inputMonto,inputCode,btRecharge) {
	  	if (!$('#accordion_bcp').hasClass('opened') || (recharge!==undefined && (recharge===false || recharge===true) )) {
	  		if(!recharge){
	  			var data = '';
	  	        var msgres = [];
	  	        $.ajax({
	  	            type: "post",
	  	            url: "check-transaction-bcp.html",
	  	            dataType: "text",
	  	            data: "",
	  	            beforeSend: function () {
		            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
			        },
			        error: function () {
			        	$('body').find('#cargando').remove();
			        },
	  	            success: function (e) {
	  	                msgres = $.trim(e.toString()).split("|||");
	  	                data = msgres[0];
	  	                renderizarBCP(data);
	  	                $('body').find('#cargando').remove();
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
		  		
		        $.ajax({
		            type: "post",
		            url: "verifica-codigo-bcp.html",
		            dataType: "text",
		            data: "bcp-amount=" + amount + "&bcp-transact=" + transact + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
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
      rechargePEFE,
      rechargeSPAY,
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
          	  	$form.removeClass('error');
          	    $inputStatusCode.val('DES');
          	    $inputIdCode.val('-1');
            });
    	}else if ($inputStatusCode.val()==='ERR' && code_temp !=$inputCode.val()){
    		$divError.html('');
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

    onValidateCode = function () {
    	 var codePromotional = $inputCode.val();
         var channel = $inputMedioPago.val();
         var lotocard = $inputLoto.val();
         var amount = $inputMonto.val();
         
         code_temp = $inputCode.val();
         
         if(amount==undefined){
       	  amount=0;
         }
         
         if(lotocard==undefined){
       	  lotocard='';
         }

        if (codePromotional !== '') {
        	$btValidate.attr('disabled', true);
        	
        	$.ajax({
                url: "send-code-promotional-validation.html",
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
                 	  	 $form.removeClass('error');
                       
                        var dataLabel = $btValidate.attr('data-label');
                        //gaEvent(dataCategory, 'Clic', dataLabel);
                        $btValidate.fadeOut(150, function () {
                          $spanValid.fadeIn(200);
                          $btValidate.attr('code-sent', true)
                        });
                     } else if(data.status === 'APL') {
                   	  	loadRecharge();
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
                   	  	loadRecharge();
                   	  	$inputStatusCode.val(data.status);
                        $inputIdCode.val(data.idCode);
                        $divError.html('');
                   	  	$form.removeClass('error');
                   	  	alertMessage(data.message);            	  
                     } else {
                   	  	loadRecharge();
                   	  	$inputStatusCode.val('ERR');
                   	  	$inputIdCode.val('-1');
                   	  	$btValidate.attr('disabled', false);
                   	  	$divError.html(data.message);
                   	  	$form.addClass('error');
                     }
                     $('body').find('#cargando').remove();
                }
              });
        }
      };
      
    rechargeLotocard = function (option,pin,actbono,actwbbono) {
    	var cadena = "";
    	var baseUrl = "";
    	var authToken = "";
    	$.ajax({
            type:"post",
            url: "client_lotocard_load_balance.html",
            data: "numberCard="+pin+"&activ-bono="+actbono+"&activ-wbbono="+actwbbono,
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
            error: function () {
            	$('body').find('#cargando').remove();
            	$btRecharge.attr('disabled', false);
            	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
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
            		loadRecharge();
            		
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
            		
	      	    	if(data.message!=undefined && data.message!=null && data.message==="OK"){
	      	    		$("#montoCargado").text(floatFormat(data.amount));
	 	                //$("#saldoDisponible").text(floatFormat(data.newamount));
	 	      	    	$divForm.fadeOut(150, function() { $divConf.fadeIn(250); });
	      	    	}
                    alertMessage(data.alertPrepaidCard);
            	}
            	$('body').find('#cargando').remove();
            }
        });
    };
    
    rechargePEFE = function (type_token,amount,actbono,actwbbono) {
        $.ajax({
            type: "post",
            url: "portal_page.html",
            data: "posAmount=" + amount + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
            error: function () {
                $('body').find('#cargando').remove();
            	$btRecharge.attr('disabled', false);
            	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
            },
            success: function (e) {
                if (e != null && e != "") {
                    var redireccion = $.trim(e.toString()).split("|");
                    if (redireccion[1] != null && $.trim(redireccion[1]) != "") {
                    	$btRecharge.attr('disabled', false);
                    	alertMessage("<div class='info'></div><p>"+$.trim(redireccion[1])+"</p>");
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
            	
                    	if(type_token==1) {
                    		$("#frame_pefl iframe").attr("src", $.trim(redireccion[0]));
                        	$("#frame_pefl").removeClass("hide");
                        	$("#close_pefl").removeClass("hide");
                        } else if(type_token==2) {
                        	$("#frame_pefe iframe").attr("src", $.trim(redireccion[0]));
	                        $("#frame_pefe").removeClass("hide");
	                        $("#close_pefe").removeClass("hide");
	                    }
                    }
                } else {
                	$btRecharge.attr('disabled', false);
                	alertMessage("<div class='info'></div><p>Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos.</p>");
                }
                                
                $('body').find('#cargando').remove();
            }
        });
    };
    
    rechargeSPAY = function (type_token,amount,actbono,actwbbono) {
        $.ajax({
            type: "post",
            url: "safety_page_post.html",
            data: "posAmount=" + amount + "&typeToken=" + type_token + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            beforeSend: function () {
            	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
            },
            error: function () {
                $('body').find('#cargando').remove();
            	$btRecharge.attr('disabled', false);
            	alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
            },
            success: function (e) {
                if (e != null && e != "") {
                    var redireccion = $.trim(e.toString()).split("|");
                    if (redireccion[1] != null && $.trim(redireccion[1]) != "") {
                    	$btRecharge.attr('disabled', false);
                    	alertMessage("<div class='info'></div><p>"+$.trim(redireccion[1])+"</p>");
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
                }
                $('body').find('#cargando').remove();
            }
        });
    };
    
    rechargeVisanet = function (amount,actbono,actwbbono) {
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
    							merchantLogo: merchant_logo, timeoutUrl: timeout_url, actbono: actbono, actwbbono: actwbbono
    							};
    	
    	var promotionMessage = "";
    	
    	var intervalVisanet = 0;
    	var intervalTimeOutVisanet = 0;
    	
        $.ajax({
            type: "post",
            url: "buildVisaForm.html",
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
            		alertMessage(e.htmlText);
            		return;
            	}
            	
            	$("#frameButtonVisa").attr('srcdoc', e.htmlText);
                $('#modal-visa').css('display', 'block');
            	$('#modal-visa').css('z-index', '2147483660');
            	$("#modal-visa").css('width', "100%");
            	$("#modal-visa").css('height', "100%");
            	
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
                    		} else 
                    			if(countVisa>0){
                    			var transactionParameters = {amount: monto,actbono: actbono, actwbbono: actwbbono};
                    			$.ajax({
                                    type: "post",
                                    url: "findVisanetRecargaResult.html",
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
                                    			loadRecharge();
                                    			var arrayResultMessage = resultMessage.split("|");
                                    			var rptaTransaccion = "";
                                    			rptaTransaccion+="<br>Nº Transacción:"+arrayResultMessage[2];
                                    			rptaTransaccion+="<br>Visa:"+arrayResultMessage[4];
                                    			rptaTransaccion+="<br>"+arrayResultMessage[3];
                                    			//rptaTransaccion+="<br>Importe:"+arrayResultMessage[5];
                                    			//rptaTransaccion+="<br>Moneda:"+arrayResultMessage[6];
                                    			//rptaTransaccion+="<br>Descripción:";
                                    			rptaTransaccion+='<br><br><span style="font-size: 11px;">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>';
                                    			
                                    			if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
                                    				promotionMessage = "";
                                    			}
                                    			
                                    			if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true') {
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
                             	      	    	$btRecharge.attr('disabled', true);
                                			}else{
                                				var arrayResultMessage = resultMessage.split("|");
                                				var rptaTransaccion = "";
                                				rptaTransaccion+= "<br>"+arrayResultMessage[1];
                                				rptaTransaccion+= "<br>Nº Transacción:"+arrayResultMessage[2];
                                				rptaTransaccion+= "<br>"+arrayResultMessage[3];
                                				
                                				//alertMessage(resultMessage);
                                				alertMessage('<p style="text-align: justify;margin: 0px;">'+rptaTransaccion+"</p>");
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
                                    	}
                                    },
                                    error: function () {
                                    	$('body').find('#cargando').remove();
                                    	$("#frameButtonVisa").removeAttr('srcdoc');
                        				$('#modal-visa').css('display', 'none');
                                    	clearInterval(intervalResultVisanet);
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
	    case 'VISANET': 
	    	  if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
	    		  $("#confirmModal_content_id").html(msjValidacion);
					 $("#confirm_content").confirmModal({top : '30%', type : 'modal',  
						  onOkBut: 
						 	function(event, el) {
							  var vall=validarMonto();
							  if(vall<=2000){
								  rechargeVisanet(amount,actbono,actwbbono);
							  }else{
								  alertMessage("Excediste el monto máximo de recarga por día con este medio (S/ 2,000)");
							  }
						  	} , 
						  onCancelBut: 
							function(event, el) {
							  $btRecharge.attr('disabled', false);
						  	} 
					  });
	    	  }else{
	    		var  vall2=validarMonto();
				  if(vall2<=2000){
	    		  rechargeVisanet(amount,actbono,actwbbono);
				  }else{
					  alertMessage("Excediste el monto máximo de recarga por día con este medio (S/ 2,000)");
				  }
	    	  }
	    	  break;
      	case 'LOTOCARD':
			 if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				 $("#confirmModal_content_id").html(msjValidacion);
				 $("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  rechargeLotocard(option,lotocard,actbono,actwbbono);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				  });	
			 }else{
				 rechargeLotocard(option,lotocard,actbono,actwbbono);
			 }
      		 break;
      	case 'BCP': 
			if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  grillaCode(null, amount, "", actbono, actwbbono,true,$spanValid,$btValidate,$divError,$form,$inputStatusCode,$inputIdCode,$inputMonto,$inputCode,$btRecharge);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				grillaCode(null, amount, "", actbono, actwbbono,true,$spanValid,$btValidate,$divError,$form,$inputStatusCode,$inputIdCode,$inputMonto,$inputCode,$btRecharge);
			}
      		break;
      	case 'PEFE': 
			if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  rechargePEFE(type_token,amount,actbono,actwbbono);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				rechargePEFE(type_token,amount,actbono,actwbbono);
			}
      		break;
      	case 'SPAY': 
      		if(status_code==='DES' && codePromotional!=undefined && codePromotional!=null && codePromotional!=''){
				$("#confirmModal_content_id").html(msjValidacion);
				$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					  onOkBut: 
					 	function(event, el) {
						  rechargeSPAY(type_token,amount,actbono,actwbbono);
					  	} , 
					  onCancelBut: 
						function(event, el) {
						  $btRecharge.attr('disabled', false);
					  	} 
				 });	
			}else{
				rechargeSPAY(type_token,amount,actbono,actwbbono);
			}
      		break; 
      }
      
    };

    onChangeField = function () {
      if ($form.isValid({}, {}, false)) {
        $btRecharge.attr('disabled', false);
        $inputCode.attr('disabled', false);
      } else {
        $btRecharge.attr('disabled', true);
        $inputCode.attr('disabled', true);
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

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
}

