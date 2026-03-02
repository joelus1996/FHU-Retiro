/*globals $, window, document, console, setTimeout, ga, google_tag_manager */
'use strict';

var METHOD = 'GET';
var configLoaded;
var actualizarCelularAgora = -1;
var flagrecarga = "validated";
var timeoutTrMsg = "Se ha detectado inoperatividad en tu sesión de recarga, por favor cierra la ventana de Cargar Saldo y vuelve acceder.";

function validarMonto() {
	var montoPorDia = 0;
	var valorIngresado = $("#monto_visanet").val();
	var valorInt = parseInt(valorIngresado);
	$.ajax({
		type : "POST",
		url : "montoPorDia.html",
		dataType : "json",
		async : false,
		success : function(e) {
			montoPorDia = e + parseInt(valorIngresado);
		}
	});
	return montoPorDia;
}

function validarMontoAgora() {
	var montoPorDia = 0;
	var valorIngresado = $("#monto_agora").val();
	var valorInt = parseInt(valorIngresado);
	$.ajax({
		type : "POST",
		url : "montoPorDiaAgora.html",
		dataType : "json",
		async : false,
		success : function(e) {
			montoPorDia = e + parseInt(valorIngresado);
		}
	});
	return montoPorDia;
}

// function gaEvent(category, action, label, value) {
// try {
// if (typeof ga === 'function') {
// var command = '';
// if (typeof google_tag_manager !== 'undefined') {
// command = ga.getAll()[0].get('name') + '.';
// }
// command += 'send';
//
// ga(command, 'event', {
// 'eventCategory': category,
// 'eventAction': action,
// 'eventLabel': label,
// 'eventValue': typeof value === 'undefined' ? 1 : value
// });
//
// } else {
// console.log('ga() not defined');
// }
// } catch (e) {
//
// }
// }

/**
 * Get parameter from URL
 * @param {String} param name of parameter
 */
var getUrlParameter = function(param) {
	var sPageURL = decodeURIComponent(window.location.search.substring(1)), sURLVariables = sPageURL
			.split('&'), sParameterName, i;

	for (i = 0; i < sURLVariables.length; i = i + 1) {
		sParameterName = sURLVariables[i].split('=');

		if (sParameterName[0] === param) {
			return sParameterName[1] === undefined ? true : sParameterName[1];
		}
	}
};

var scrollToTop = function() {
	$('html, body').animate({
		scrollTop : 0
	});
};

var resizeIframes = function() {
	var $iframes = $('iframe.ilotframe');
	$iframes.each(function() {
		this.style.height = this.contentWindow.document.body.offsetHeight
				+ 'px';
	});
};

/**
 * Autoresize iframes when load content
 */
var initIframes = function() {
	var $iframes = $('iframe.ilotframe');
	$iframes.on('load', function() {
		this.style.height = this.contentWindow.document.body.offsetHeight
				+ 'px';
	});
};

var isInIframe = function() {
	try {
		return window.self !== window.top;
	} catch (e) {
		return true;
	}
};

/**
 * Render template using object params
 * 
 * @param {string}
 *            html html template to render
 * @param {object}
 *            obj Object with properties to replace
 * @returns {string} Html string
 */
var renderTemplate = function(html, obj) {
	var t = html, lWrap = '\\{\\{', rWrap = '\\}\\}', re = new RegExp(lWrap
			+ '(\\w+)' + rWrap, 'g'), keys = t.match(re), onlyUnique, clearKeys, parseTemplate;

	onlyUnique = function(value, index, self) {
		return self.indexOf(value) === index;
	};

	clearKeys = function(key) {
		return key.replace(re, '$1');
	};

	parseTemplate = function(key) {
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
var renderGridView = function() {
	var showgrid = getUrlParameter('showgrid');
	if (showgrid === '1') {
		$('.gridview').show();
	}
};

/**
 * Render all form fields (select, input, checkbox)
 */
var renderFormFields = function() {
	// pulldown
	$(".form__select select").each(function() {
		var $this = $(this), $pull = $this.parent();

		if ($pull.find("div").length === 0) {
			$pull.prepend("<div></div>");
		}

		if ($this.val() === "") {
			$pull.removeClass("selected");
		} else {
			$pull.children("div").text($this.children(":selected").text());
			$pull.addClass("selected");
		}

		$this.on('change', function() {
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
	$(".form__input input, .form__area textarea").each(
			function() {
				var $input = $(this), $parent = $input.parent();

				if ($input.val() !== '') {
					$parent.addClass('filled');
				}

				$input.on('focus', function() {
					$parent.addClass('focus filled');
				});

				$input.on('blur', function() {
					if ($input.val() === ''
							&& !$parent.hasClass('form__input-calendar')) {
						$parent.removeClass('focus filled');
					} else {
						$parent.removeClass('focus');
					}
				});
			});

	// checkbox
	$('.form__check input').on("click", function() {
		var $this = $(this);
		if ($this.is(":checked")) {
			$this.parent().addClass('checked');
		} else {
			$this.parent().removeClass('checked');
		}
	}).each(function() {
		var $this = $(this);
		if ($this.find('input').is(":checked")) {
			$this.addClass("checked");
		} else {
			$this.removeClass("checked");
		}
	}).each(function() {
		var $this = $(this);
		if ($this.is(":checked")) {
			$this.parent().addClass("checked");
		} else {
			$this.parent().removeClass("checked");
		}
	});

	// options
	var $thisOption, $thisInput = $('#horario');

	$('.form__opts-list-item').on('click', function() {
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
var renderDateField = function() {
	var $input = $('#fechanac');
	var bdate = new Date();
	var sdate = new Date();
	bdate.setFullYear(bdate.getFullYear() - 18);
	sdate.setFullYear(sdate.getFullYear() - 100);

	$input.datepicker({
		language : 'es-ES',
		offset : 8,
		startDate : sdate,
		endDate : bdate,
		autoHide : true
	// trigger: '#fechanac'
	});

	$input.on('show.datepicker', function() {
		// $input.trigger('focus');
	});
	$input.on('hide.datepicker', function() {
		$input.trigger('blur');
	});

};

/**
 * Render Tipo documento feature
 */
var renderDocumentFields = function() {
	var $select = $('#document-type'), $fields = $('.form__optional'), onChangeDocument;

	onChangeDocument = function() {
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

/**
 * Render Tipo documento-legal feature
 */
var renderDocumentFieldsLegal = function() {
	var $select = $('#document-type-legal'), $fields = $('.form__optional2'), onChangeDocument2;

	onChangeDocument2 = function() {
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

/**
 * Show / Hide password
 */
var renderPasswordField = function() {
	var $input = $('#password-client'), $field = $input.parent(), $toggle = $('#toglePassword'), onTogglePassword;

	onTogglePassword = function() {
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
var submitRegisterForm = function() {
	var $form = $('#frm-user-register'), $button = $('#btsubmit'), urlRegister = $form
			.attr('action');
	$button.attr('disabled', true);
};

var renderTermsField = function() {
	var $input = $('#terms'), $form = $('#frm-user-register'), onChangeTerms, onChangeFechaNac;

	var $name = $('#name');
	var $appaterno = $('#ap-paterno');
	var $documentnumber = $('#document-number');
	var $documentopasap = $('#document-number-pasap');
	var $documentocarex = $('#document-number-carex');
	var $fechanac = $('#fechanac');
	var $userclient = $('#user-client');
	var $passwordclient = $('#password-client');
	var $email = $('#email');
	var $mobilephone = $('#mobile-phone');
	var $nacionalidad = $('#nacionalidad');
	var $domicilio = $('#domicilio');
	var $departamento = $('#departamento');
	var $provincia = $('#provincia');
	var $distrito = $('#distrito');
	var $namemsg = $('#name_msg');
	var $appaternomsg = $('#ap-paterno_msg');
	var $fechanacmsg = $('#fechanac_msg');
	var $documentnumbermsg = $('#document_number_msg');
	var $document_numbercarexmsg = $('#document_number_carex_msg');
	
	onChangeTerms = function() {
		if ($form.isValid({}, {}, false)) {
			if ($namemsg.text() === "" && $appaternomsg.text() === ""
					&& $fechanacmsg.text() === ""
					&& $documentnumbermsg.text() !== "INGRESE UN DNI VÁLIDO"
					&& $document_numbercarexmsg.text() !== "INGRESE UN CARNET DE EXTRANGERÍA VÁLIDO") {
				$('#btsubmit').attr('disabled', false);
			}
		} else {
			$('#btsubmit').attr('disabled', true);
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
var renderRegisterForm = function() {
	var validateInputReg, validateInputReg2, validateInputReg3, validateInputReg4, validateMessagges;
	// render fields
	renderDocumentFields();
	renderDateField();
	renderPasswordField();
	renderTermsField();

	// restrict fields
	// $('#name,
	// #ap-paterno').alpha({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
	// $('#user-client, #document-number-pasap,
	// #document-number-carex').alphanum({allowSpace: false,
	// disallow:'``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
	// $('#email').alphanum({allowSpace: false, allow : '-_+@.'});
	$("#mobile-phone, #document-number").numeric({
		allowThouSep : false,
		allowDecSep : false,
		allowMinus : false
	});
	$('#fechanac').alphanum({
		allow : '/',
		allowUpper : false,
		allowLower : false
	});

	$('#fechanac').mask('00/00/0000');
	// $('#domicilio').alphanum({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©',
	// allow : '#.,-'});

	validateInputReg = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ\s]/g,
				'');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$('#name, #ap-paterno').on('input', validateInputReg);

	validateInputReg2 = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue.replace(/[^a-zA-Z\d]/g, '');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$('#user-client, #document-number-pasap, #document-number-carex').on(
			'input', validateInputReg2);

	validateInputReg3 = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue.replace(/[^a-zA-Z\d-_+@.]/g, '');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$('#email').on('input', validateInputReg3);

	validateInputReg4 = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue
				.replace(/[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\s#°.,-\d]/g, '');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$('#domicilio').on('input', validateInputReg4);
	
	validateMessagges = function () {
		  var nameMsgFilled = $('#name_msg').text().trim() !== '';
		  var lastNameMsgFilled = $('#ap-paterno_msg').text().trim() !== '';
		  var dateBirthMsgFilled = $('#fechanac_msg').text().trim() !== '';
		  var dniNumberMsgFilled = $('#document_number_msg').text().trim() === 'INGRESE UN DNI VÁLIDO';
		  var carexNumberMsgFilled = $('#document_number_carex_msg').text().trim() === 'INGRESE UN CARNET DE EXTRANGERÍA VÁLIDO';

		  return nameMsgFilled || lastNameMsgFilled || dateBirthMsgFilled || dniNumberMsgFilled || carexNumberMsgFilled; 
	}
	$('#name, #ap-paterno, #fechanac').on('input', validateMessagges);

	// validate fields
	  $.validate({
		    form: '#frm-user-register',
		    modules: 'security, date, logic',
		    scrollToTopOnError: false,
		    onModulesLoaded: function () {
		      var config = {
		        bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@)</span>',
		        weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@)</span>',
		        good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
		        strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
		      };
		      $('#password-client').displayPasswordStrength(config);
		    },
		    onElementValidate : function(valid, $el, $form) {
		      if ($form.isValid({}, {}, false) && !validateMessagges()) {
		        $('#btsubmit').attr('disabled', false);
		      } else {
		        $('#btsubmit').attr('disabled', true);
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
var renderActivateForm = function() {
	window.location.hash = "no-back-button";
	window.location.hash = "Again-No-back-button";// esta linea es necesaria
													// para chrome
	window.onhashchange = function() {
		window.location.hash = "no-back-button";
	}

	$('#wrapper-form').append('<div id="loader-frm-register"></div>');
	var cel = $("#celhidden").val();
	if (cel == undefined || cel == null || cel == '') {
		location.href = $("#redirectHome").val();
	}
	$.ajax({
		type : "post",
		url : "validation-activation.html",
		dataType : "jsonp",
		async : false,
		success : function(e) {
			if (e.mobileSmsStatus != undefined && e.mobileSmsStatus == "ACT") {
				location.href = $("#redirectHome").val();
			}
		}
	});
	$('#wrapper-form').find('#loader-frm-register').remove();

	var $form = $('#form_activate'), $inputs = $(".form__code input"), $button = $('#btactivate'), $gotoLink = $('#gotoResendCode'), urlActivate = $form
			.attr('action'), onChangeCode, validateCode, onSubmitActivate, onResendCode;

	onChangeCode = function(e) {
		var $input = $(this), tcode = $input.val(), tindex = parseInt($input
				.attr('tabindex'), 10);

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

	validateCode = function() {
		$button.attr('disabled', false);
		$inputs.each(function() {
			if ($(this).val() === '') {
				$button.attr('disabled', true);
				$form.removeClass('error-activate');
			}
		});
	};

	onSubmitActivate = function(e) {
		e.preventDefault();

		$button.attr('disabled', true);
		var cod01 = $("#code-01").val();
		var cod02 = $("#code-02").val();
		var cod03 = $("#code-03").val();
		var cod04 = $("#code-04").val();
		var cod05 = $("#code-05").val();
		var code = cod01 + cod02 + cod03 + cod04 + cod05;
		var operatorIdActivate = $("#operatorId").val();
		$
				.ajax({
					type : "post",
					url : "send-code-validation.html",
					data : "sms-code=" + code,
					dataType : "jsonp",
					async : false,
					beforeSend : function() {
						$('#wrapper-form').append(
								'<div id="loader-frm-register"></div>');
					},
					success : function(e) {
						$('#wrapper-form').find('#loader-frm-register')
								.remove();
						if (e.status === 1) {
							// gaEvent('Activacion-Evaluate', 'Clic',
							// 'Activa cuenta - verificar');
							$("#top_message").html("");
							$("#top-message").css("display", "none");
							$("#celhidden").val("");

							try {
								datalayerActivate();
								tagginVAActivated();
							} catch (e) {
								console.error(e);
							}
							$
									.ajax({
										type : "POST",
										url : "redirectAccountActive.html",
										dataType : "json",
										data : "data=0",
										async : false,
									})
									.done(
											function(data) {
												console
														.log("operatorIdActivate: "
																+ operatorIdActivate);
												if ($.trim(operatorIdActivate) == "5588") {// TA
													$('.step-01')
															.fadeOut(
																	150,
																	function() {
																		$(
																				'.step-03')
																				.fadeIn(
																						250);
																	});
													setTimeout(function() {
														toTAV2();
													}, 1000);
												} else if ($
														.trim(operatorIdActivate) == "5587") {// LA
																								// POLLA
													$('.step-01')
															.fadeOut(
																	150,
																	function() {
																		$(
																				'.step-03')
																				.fadeIn(
																						250);
																	});
													setTimeout(function() {
														toLaPolla();
													}, 1000);
												} else {// LA TINKA
													setTimeout(
															function() {
																location.href = "bienvenido.html";
															}, 100);
												}
											}).fail(
											function(jqXHR, textStatus,
													errorThrown) {
												console.log("errorThrown: "
														+ errorThrown);
											});

						} else {
							if (e.status === 2) {
								$("#msjError").html(e.message);
								$('#form_activate').addClass('error-activate');

							} else {
								$("#msjError").html(e.message);
								$('#form_activate').addClass('error-activate');

							}

							try {
								tagginVAError();
								datalayerErrores('Activa tu cuenta', 'Paso 2',
										'Activar Cuenta', e.message);
							} catch (e) {
								console.error(e);
							}

						}
					}
				});
		$('#wrapper-form').find('#loader-frm-register').remove();

		return false;
	};

	onResendCode = function(e) {
		e.preventDefault();
		// gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - reenviar
		// codigo por sms');

		$('#form_activate').removeClass('error-activate');
		$("#form_resend").removeClass('error-activate');
		$('.step-01').fadeOut(150, function() {
			$('.step-02').fadeIn(250);
		});
		try {
			datalayerResendCode();
			tagginVAOnResendCode();
		} catch (e) {
			console.error(e);
		}
	};

	$inputs.numeric({
		allowThouSep : false,
		allowDecSep : false,
		allowMinus : false
	});
	$inputs.on('keyup keydown', onChangeCode);
	$form.on('submit', onSubmitActivate);
	$gotoLink.on('click', onResendCode);
};

/**
 * Send data to resend activation code
 */
var submitResendForm = function() {
	var $form = $('#form_resend'),  $disclaimer = $('#disclaimer'), $button = $('#btresend'), urlResend = $form
			.attr('action');

	$button.attr('disabled', true);

	var phone = $.trim($("#celular").val());
	var phonePattern = new RegExp(/^([9]{1})([0-9]{8})$/);
	var phoneRes = phonePattern.test(phone);
	if (!phoneRes && $("#celular1").length > 0 && $("#celular").length <= 0) {
		phoneRes = true;
	}
	if (phoneRes) {
		$.ajax({
			type : "post",
			url : "send-sms-validation.html",
			data : "phone-client=" + phone,
			dataType : "jsonp",
			async : false,
			beforeSend : function() {
				$('#wrapper-form').append(
						'<div id="loader-frm-register"></div>');
			},
			success : function(e) {
				if (e.status === 200) {
					$('#btactivate').attr('disabled', true);
					$(".form__code input").val('');
					$('#btresend').attr('disabled', false);

					var phoneMasked = phone.substring(0, 2) + '*****' + phone.substring(7);
	                $('#celSMS').html(phoneMasked);

					// gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta -
					// enviar sms');
					$('#form_activate').removeClass('error-activate');
					$("#form_resend").removeClass('error-activate');
					$('.step-02').fadeOut(150, function() {
						$('.step-01').fadeIn(250);
					});
					tagginViewActivar();

				} else {
					$("#msjErrorSendCode").html(e.message);
					$form.addClass('error-activate');
	                $('#btresend').attr('disabled', false);
				}
			}
		});
		$('#wrapper-form').find('#loader-frm-register').remove();
	} else {
		$form.find('#dhtmlwindowloader').remove();
		$("#msjErrorSendCode")
				.html(
						"El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.");
		$form.addClass('error-activate');
		$disclaimer.addClass('has-error');
	}
};

var submitResendFormWa = function () {
	  var $form = $('#form_resend'),
	  $disclaimer = $('#disclaimer'),
	  $button = $('#btresendwa'),
	  urlResend = $form.attr('action');

	  $button.attr('disabled', true);

	  var phone = $.trim($("#celular").val());
	  var phonePattern = new RegExp(/^([9]{1})([0-9]{8})$/);
	  var phoneRes = phonePattern.test(phone);
	  if(!phoneRes && $("#celular1").length>0 && $("#celular").length<=0){
		  phoneRes=true;
	  }
	  if(phoneRes){
		  $.ajax({
	  		  type: "post",
	          url: "send-wa-validation.html",
	          data: "phone-client=" + phone,
	          dataType: "jsonp",
	          async:false,
	          beforeSend: function () {
	        	  $('#wrapper-form').append('<div id="loader-frm-register"></div>');
	          },
	          success: function (e) {            
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
	                tagginViewActivar();
	                
	          	}else{
	          		$("#msjErrorSendCode").html(e.message);
	          		$form.addClass('error-activate');
	          		$('#btresendwa').attr('disabled', false);
	          	}
	          }
	      });
		  $('#wrapper-form').find('#loader-frm-register').remove();
	  }else {
		$form.find('#dhtmlwindowloader').remove();
		$("#msjErrorSendCode").html("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.");
		$form.addClass('error-activate');
		$disclaimer.addClass('has-error');
	  }
	};
	
/**
 * Render Form: Resend code
 */
	var renderResendCode = function () {
		 var $input = $('#celular'),
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
		    		datalayerSendWhatsapp();
		    	    submitResendFormWa();// Llama función para WhatsApp
		    	    return false;
		    	  } else {
		    		datalayerSendSMS();
		    	    submitResendForm();// Llama función para SMS
		    	    return false;
		    	  }
		    }
		  });

		  onClickBack = function (e) {
		    e.preventDefault();
//		    gaEvent('Activacion-Evaluate', 'Clic', 'Activa cuenta - ya tengo codigo verificacion');

		    // reset form
		    $('#btactivate').attr('disabled', true);
		    $(".form__code input").val('');

		    $("#form_resend").removeClass('error-activate');
		    $('#form_activate').removeClass('error-activate');
		    $('.step-02').fadeOut(150, function () { $('.step-01').fadeIn(250); });
		    try {
		    	tagginViewActivar();			
			} catch (e) {
				console.error(e);
			}
		    
		  };

		  $linkBack.on('click', onClickBack);
		};

/**
 * Render tabs
 */
var renderTabs = function() {
	var $tabs = $('.tabs');

	$tabs
			.each(function() {
				var $tab = $(this), $links = $tab.find('> ul > li'),
				// $links = $tab.find('> div > div'),
				dataTabCategory = $tab.attr('data-category'), $currentTab, onSelectTab;

				onSelectTab = function(e) {
					e.preventDefault();
					var $link = $(this), dataLabel = $link.attr('data-label'), dataCategory = (dataTabCategory === undefined) ? $link
							.attr('data-category')
							: dataTabCategory;

					// $links.removeClass('selected');
					// $link.addClass('selected');

					if ($currentTab) {
						$currentTab.fadeOut(150, function() {
							$currentTab = $($link.attr('data-target'));
							$currentTab.fadeIn(150, function() {
								if (isInIframe()) {
									// parent.resizeIframes();
								}
							});
						});
					} else {
						$currentTab = $($link.attr('data-target'));
						$currentTab.fadeIn(150, function() {
							if (isInIframe()) {
								// parent.resizeIframes();
							}
						});
					}
				};

				// events
				$links.on('click', onSelectTab);

				// init tabs
				$links.filter('.selected').trigger('click');

				var medioSeleccionado = "";
				var tipoMedioSeleccionado = "";

				$("#tabInternetIzi").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#izipay-internet").fadeIn(150);
						medioSeleccionado = "izipay-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});
				$("#tabInternetVisanet").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#visanet-internet").fadeIn(150);
						medioSeleccionado = "visanet-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});
				$("#tabInternetAgora").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#agora-internet").fadeIn(150);
						medioSeleccionado = "agora-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});
				$("#tabInternetInterbank").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#interbank-internet").fadeIn(150);
						medioSeleccionado = "interbank-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});
				$("#tabInternetBCP").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#bcp-internet").fadeIn(150);
						medioSeleccionado = "bcp-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});
				$("#tabInternetBBVA").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#bbva-internet").fadeIn(150);
						medioSeleccionado = "bbva-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});
				$("#tabInternetPagoEfectivo").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#pagoefectivo-internet").fadeIn(150);
						medioSeleccionado = "pagoefectivo-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});
				$("#tabInternetYape").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#yape-internet").fadeIn(150);
						medioSeleccionado = "yape-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$('#close_yapetupayl').click(function(event) {
					$("#frame_yapetupayl iframe").attr("src", "about:blank");
					$("#frame_yapetupayl").addClass("hide");
					$("#close_yapetupayl").addClass("hide");
				});
				$('#close_plintupayl').click(function(event) {
					$("#frame_plintupayl iframe").attr("src", "about:blank");
					$("#frame_plintupayl").addClass("hide");
					$("#close_plintupayl").addClass("hide");
				});

				$("#tabInternetYapeTupay").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#yape-tupay-internet").fadeIn(150);
						medioSeleccionado = "yape-tupay-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabInternetPlin").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#plin-internet").fadeIn(150);
						medioSeleccionado = "plin-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabInternetPlinTupay").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#plin-tupay-internet").fadeIn(150);
						medioSeleccionado = "plin-tupay-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabInternetSafetyPay").on('click', function() {
					$("#botonesInternet").fadeOut(150, function() {
						$("#safetypay-internet").fadeIn(150);
						medioSeleccionado = "safetypay-internet";
						tipoMedioSeleccionado = "botonesInternet";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabEfectivoInterbank").on('click', function() {
					$("#botonesEfectivo").fadeOut(150, function() {
						$("#interbank-efectivo").fadeIn(150);
						medioSeleccionado = "interbank-efectivo";
						tipoMedioSeleccionado = "botonesEfectivo";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabEfectivoLotocard").on('click', function() {
					$("#botonesEfectivo").fadeOut(150, function() {
						$("#lotocard-efectivo").fadeIn(150);
						medioSeleccionado = "lotocard-efectivo";
						tipoMedioSeleccionado = "botonesEfectivo";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabEfectivoPagoEfectivo").on('click', function() {
					$("#botonesEfectivo").fadeOut(150, function() {
						$("#pagoefectivo-efectivo").fadeIn(150);
						medioSeleccionado = "pagoefectivo-efectivo";
						tipoMedioSeleccionado = "botonesEfectivo";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabEfectivoSafetyPay").on('click', function() {
					$("#botonesEfectivo").fadeOut(150, function() {
						$("#safetypay-efectivo").fadeIn(150);
						medioSeleccionado = "safetypay-efectivo";
						tipoMedioSeleccionado = "botonesEfectivo";
						$("#tabs__container").css("margin-top", "0px");
						$(".back").css("display", "block");
					});
				});

				$("#tabInternet").on('click', function() {
					try {
						$(".back").trigger('click');
					} catch (e) {

					}
					$("#tabEfectivo").removeClass("selected");
					$("#tabInternet").addClass("selected");
				});

				$("#tabEfectivo").on('click', function() {
					try {
						$(".back").trigger('click');
					} catch (e) {

					}
					$("#tabInternet").removeClass("selected");
					$("#tabEfectivo").addClass("selected");
				});

				$(".back").on('click', function() {
					$("#" + medioSeleccionado).fadeOut(150, function() {
						$("#" + tipoMedioSeleccionado).fadeIn(150);
						$("#tabs__container").css("margin-top", "30px");
						$(".back").css("display", "none");
					});
				});

			});
};

/**
 * Render Recharge Forms
 */
var renderRechargeForms = function() {
	var $forms = $('form.form'), tplRechargeHead = document
			.getElementById('tpl-recharge-head').innerHTML, tplRechargeItem = document
			.getElementById('tpl-recharge-item').innerHTML, tplRechargeBBVAHead = document
			.getElementById('tpl-recharge-head-bbva').innerHTML, tplRechargeBBVAItem = document
			.getElementById('tpl-recharge-item-bbva').innerHTML, renderTableRecharge, grillaCode, renderTableRechargeBBVA, generarCodigoBBVA, renderizarBBVA, listarCodigosBBVA;

	// restrict fields
	$('input[name="monto"]').numeric({
		allowThouSep : false,
		allowDecSep : false,
		allowMinus : false
	});
	$('input[name="codigo"]').alphanum({
		allowSpace : false
	});
	$('input[name="lotocard"]').numeric({
		allowThouSep : false,
		allowDecSep : false,
		allowMinus : false
	});
	$('input[name="celular"]').numeric({
		allowThouSep : false,
		allowDecSep : false,
		allowMinus : false
	});

	// helper methods
	renderTableRecharge = function(items, $table) {
		var html = '';
		if (items.length > 0) {
			html += renderTemplate(tplRechargeHead, {});
			items.forEach(function(item) {
				html += renderTemplate(tplRechargeItem, {
					amount : item.amount,
					code : item.code,
					date : item.date,
					urlvalidate : item.urlvalidate,
					urlcancel : item.urlcancel
				});
			});

			$table.html(html);
			$table.fadeIn(200);
		}
	};

	renderTableRechargeBBVA = function(items, $table) {
		var html = '';
		if (items.length > 0) {
			html += renderTemplate(tplRechargeBBVAHead, {});
			items.forEach(function(item) {
				html += renderTemplate(tplRechargeBBVAItem, {
					amount : item.amount,
					code : item.code,
					date : item.date,
					urlvalidate : item.urlvalidate,
					urlcancel : item.urlcancel
				});
			});

			$table.html(html);
			$table.fadeIn(200);
		}
	};

	$('#grillaBCP')
			.on(
					'click',
					'.verify',
					function(event) {
						var $btnVerificar = $(this);
						var price = $btnVerificar.parents('.row_grid').text()
								.split(/\n/)[1].trim();
						var code = $btnVerificar.parents('.row_grid').text()
								.split(/\n/)[2].trim();
						var date = $btnVerificar.parents('.row_grid').text()
								.split(/\n/)[3].trim();

						var amount = $("#clientSale-amount").text().replace(
								',', '');
						var trx = $(this).data('pin');

						// recarga con sesion o con token
						var vurl = "verificar.html";
						var rechargetoken = $('#rechargetoken').val();
						var vheaders = {};
						if (rechargetoken != null && rechargetoken != "") {
							vurl = "verificarAPI.html";
							vheaders = {
								"rechargetoken" : $('#rechargetoken').val()
							};
						}

						$
								.ajax({
									type : "GET",
									url : vurl,
									headers : vheaders,
									dataType : "json",
									data : {
										amount : amount,
										pin : trx
									},
									beforeSend : function() {
										$('body')
												.append(
														'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
									},
									error : function() {
										$('body').find('#loading-recharge')
												.remove();
										jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
										tagginSaldoErrorRecarga('Internet BCP',
												'¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
									},
									success: function(data) {
									    debugger; // aquí se detiene antes de actualizar la tabla

										if (data.state === 'OK') {
											$("#clientSale-amount").text(
													floatFormat(data.amount));
											if (rechargetoken != null
													&& rechargetoken != "") {
												loadRechargeAPI(flagrecarga);
											} else {
												loadRecharge();
											}
											grillaCode();
											tagginSaldoBCPEEcheckout(price);
											tagginSaldoBCPEEpurchase(code,
													date, price);
										} else {
											try {
												tagginSaldoErrorRecarga(
														'Internet BCP', $(
																"<div/>").html(
																data.message)
																.text());
											} catch (e) {

											}

										}
										$('body').find('#loading-recharge')
												.remove();
										if (data.state == 'TIMEOUTTR') {
											jAlert(timeoutTrMsg);
										} else {
											jAlert(data.message);
										}

									}
								})
					});

	$('#grillaBCP')
			.on(
					'click',
					'.button_anular',
					function(event) {
						var $btnAnular = $(this);
						$
								.ajax({
									type : 'post',
									url : 'anular.html',
									dataType : 'text',
									data : {
										pin : $(this).data('pin')
									},
									beforeSend : function() {
										$('body')
												.append(
														'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
									},
									error : function() {
										$('body').find('#loading-recharge')
												.remove();
										jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
									},
									success : function(data) {
										$('body').find('#loading-recharge')
												.remove();
										$btnAnular.parents('.row_grid')
												.remove();
										var price = $btnAnular.parents(
												'.row_grid').text().split(/\n/)[1]
												.trim();
										tagginSaldoBCPEEremoveFromCart(price);

									}
								});
						if ($('#grillaBCP').find('.button_anular').length == 1) {
							$('#grillaBCP').html('');
						}

					});

	grillaCode = function(event, amount, transact, actbono, actwbbono, restart,
			spanValid, btValidate, divError, form, inputStatusCode,
			inputIdCode, inputMonto, inputCode, btRecharge, channel) {
		if (restart) {
			var maximoCodigosBCP = $("#maximoCodigosBCP").val();
			if (maximoCodigosBCP == undefined || maximoCodigosBCP == null
					|| maximoCodigosBCP == '') {
				maximoCodigosBCP = 3;
			} else {
				maximoCodigosBCP = parseInt(maximoCodigosBCP);
			}
			if ($('#grillaBCP').find('.row_grid').length >= maximoCodigosBCP) {
				btRecharge.attr('disabled', false);
				jAlert("Haz alcanzado el límite máximo de códigos BCP generados.");
				return;
			}
		}

		var data = '';
		var message = '';
		var newamount = 0.0;
		var msgres = [];
		var codePromotional = "";

		if (amount === undefined) {
			amount = "";
		}

		if (transact === undefined) {
			transact = "";
		}

		if (actbono === undefined) {
			actbono = "";
		}

		if (actwbbono === undefined) {
			actwbbono = "";
		}

		if (inputCode != undefined) {
			codePromotional = inputCode.val();
		}

		if (channel === undefined) {
			channel = "";
		}

		// recarga con sesion o con token
		var vurl = "verifica-codigo-bcp.html";
		var rechargetoken = $('#rechargetoken').val();
		var vheaders = {};
		if (rechargetoken != null && rechargetoken != "") {
			vurl = "verifica-codigo-bcp-api.html";
			vheaders = {
				"rechargetoken" : $('#rechargetoken').val()
			};
		}

		$
				.ajax({
					type : "post",
					url : vurl,
					headers : vheaders,
					dataType : "text",
					data : "codePromotional=" + codePromotional + "&channel="
							+ channel + "&lotocard=" + '' + "&bcp-amount="
							+ amount + "&bcp-transact=" + transact
							+ "&activ-bono=" + actbono + "&activ-wbbono="
							+ actwbbono,
					beforeSend : function() {
						$('body')
								.append(
										'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
					},
					error : function() {
						if (restart) {
							btRecharge.attr('disabled', false);
						}
						$('body').find('#loading-recharge').remove();
					},
					success : function(e) {
						msgres = $.trim(e.toString()).split("|||");
						data = msgres[0];
						message = msgres[1];
						newamount = msgres[2];
						if (newamount != "-1" && newamount != null
								&& newamount != "0.0") {
							$("#clientSale-amount")
									.text(floatFormat(newamount));
						}

						// getGrillaBCP();//obtener la grilla a verificar
						var fila = data.split("||");
						if (fila.length > 0 && fila[0] != '') {
							if (restart) {
								if ($.trim(actbono).includes('true-casino')
										|| $.trim(actbono) == 'true'
										|| $.trim(actwbbono) == 'true') {
									spanValid.fadeOut(150, function() {
										btValidate.fadeIn(200);
										btValidate.attr('code-sent', false)
										btValidate.attr('disabled', false);

										divError.html('');
										form.removeClass('error');
										inputStatusCode.val('DES');
										inputIdCode.val('-1');
									});
								} else {
									divError.html('');
									form.removeClass('error');
									inputStatusCode.val('DES');
									inputIdCode.val('-1');
								}
								inputMonto.val('');
								inputCode.val('');
							}

							var html = '';
							var $tableCodes = $("#grillaBCP");
							html += renderTemplate(tplRechargeHead, {});

							for (var n = (fila.length - 1); n >= 0; n--) {
								var items = fila[n].split("|");
								if (items.length > 0) {
									if (items[3] === "PEN") {
										html += renderTemplate(
												tplRechargeItem,
												{
													amount : floatFormat(items[1]),
													code : items[0],
													date : items[2],
													urlvalidate : "verify",
													urlcancel : "button_anular",
													pin : items[4]
												});
									}
								}
							}

							$tableCodes.html(html);
							$tableCodes.fadeIn(200);
						} else {
							var $tableCodes = $("#grillaBCP");
							$tableCodes.html('');
						}
						// taggingCheckoutAndPurchaseBCP();

						if ($.trim(amount) != '' && $.trim(message) != '') {
							if (message == 'TIMEOUTTR') {
								message = timeoutTrMsg;
							}
							jAlert(message);
							if (restart) {
								btRecharge.attr('disabled', false);
							}
						}

						$('body').find('#loading-recharge').remove();
					}
				});
	};

	$('#tabInternetBCP').on('click', grillaCode);

	generarCodigoBBVA = function(amount, actbono, actwbbono, spanValid,
			btValidate, divError, form, inputStatusCode, inputIdCode,
			inputMonto, inputCode, btRecharge, channel) {
		var maximoCodigosBBVA = $("#maximoCodigosBBVA").val();
		if (maximoCodigosBBVA == undefined || maximoCodigosBBVA == null
				|| maximoCodigosBBVA == '') {
			maximoCodigosBBVA = 3;
		} else {
			maximoCodigosBBVA = parseInt(maximoCodigosBBVA);
		}
		if ($('#grillaBBVA').find('.row_grid').length >= maximoCodigosBBVA) {
			btRecharge.attr('disabled', false);
			jAlert("Haz alcanzado el límite máximo de códigos BBVA generados.");
			return;
		}

		var notificacion = '';
		var data = '';
		var message = '';
		var newamount = 0.0;
		var msgres = [];
		var codePromotional = inputCode.val();

		if (codePromotional == undefined) {
			codePromotional = '';
		}

		if (amount === undefined) {
			amount = "";
		}

		if (actbono === undefined) {
			actbono = "";
		}

		if (actwbbono === undefined) {
			actwbbono = "";
		}

		var vurl = "genera-codigo-bbva-rt.html";
		var rechargetoken = $('#rechargetoken').val();
		var vheaders = {
			"rechargetoken" : $('#rechargetoken').val()
		};

		$
				.ajax({
					type : "post",
					url : vurl,
					headers : vheaders,
					dataType : "text",
					data : "codePromotional=" + codePromotional + "&channel="
							+ channel + "&lotocard=" + '' + "&bbva-amount="
							+ amount + "&activ-bono=" + actbono
							+ "&activ-wbbono=" + actwbbono,
					beforeSend : function() {
						$('body')
								.append(
										'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
					},
					error : function() {
						btRecharge.attr('disabled', false);
						$('body').find('#loading-recharge').remove();
					},
					success : function(e) {
						msgres = $.trim(e.toString()).split("|||");
						data = msgres[0];
						message = msgres[1];
						newamount = msgres[2];
						if (newamount != "-1" && newamount != null
								&& newamount != "0.0") {
							$("#clientSale-amount")
									.text(floatFormat(newamount));
							if ($.trim(actbono).includes('true-casino')
									|| $.trim(actbono) == 'true'
									|| $.trim(actwbbono) == 'true') {
								spanValid.fadeOut(150, function() {
									btValidate.fadeIn(200);
									btValidate.attr('code-sent', false)
									btValidate.attr('disabled', false);

									divError.html('');
									form.removeClass('error');
									inputStatusCode.val('DES');
									inputIdCode.val('-1');
								});
							} else {
								divError.html('');
								form.removeClass('error');
								inputStatusCode.val('DES');
								inputIdCode.val('-1');
							}
							inputMonto.val('');
							inputCode.val('');
							notificacion = "Para concretar el pago, cancele en BBVA indicando el c&oacute;digo generado.";
							renderizarBBVA(data)
						}

						if ($.trim(message) != "" && amount != "") {
							if (message == 'TIMEOUTTR') {
								message = timeoutTrMsg;
							}
							notificacion = "<div class='info'></div><p>"
									+ message + "</p>";
							btRecharge.attr('disabled', false);
						}
						if ($.trim(notificacion) != "")
							jAlert(notificacion);
						$('body').find('#loading-recharge').remove();
					}
				});
	};

	renderizarBBVA = function(data) {
		var fila = data.split("||");
		if (fila.length > 0 && fila[0] != '') {
			var html = '';
			var $tableCodes = $("#grillaBBVA");
			html += renderTemplate(tplRechargeBBVAHead, {});
			for (var n = (fila.length - 1); n >= 0; n--) {
				var items = fila[n].split("|");
				if (items.length > 0) {
					if (items[3] === "PEN" || items[3] === "OKK") {
						html += renderTemplate(tplRechargeBBVAItem, {
							amount : items[1],
							code : items[0],
							date : items[2],
							urlvalidate : "bbvaverify",
							urlcancel : "bbvadelete",
							pin : items[4]
						});
					}
				}
			}

			$tableCodes.html(html);
			$tableCodes.fadeIn(200);
		} else {
			var $tableCodes = $("#grillaBBVA");
			$tableCodes.html('');
		}
	};

	listarCodigosBBVA = function(verify) {
		// if (verify==true) {
		var data = '';
		var msgres = [];
		var vurl = "check-transaction-bbva-rt.html";
		var rechargetoken = $('#rechargetoken').val();
		var vheaders = {
			"rechargetoken" : $('#rechargetoken').val()
		};
		$
				.ajax({
					type : "post",
					url : vurl,
					headers : vheaders,
					dataType : "text",
					data : "",
					beforeSend : function() {
						$('body')
								.append(
										'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
					},
					error : function() {
						$('body').find('#loading-recharge').remove();
					},
					success : function(e) {
						msgres = e;
						if (msgres == 'TIMEOUTTR') {
							$('body').find('#loading-recharge').remove();
							jAlert(timeoutTrMsg);
						} else {
							msgres = $.trim(e.toString()).split("|||");
							data = msgres[0];
							renderizarBBVA(data);
							$('body').find('#loading-recharge').remove();
						}
					}
				});
		// }
	};

	$('#tabInternetBBVA').on('click', listarCodigosBBVA);

	$('#grillaBBVA')
			.on(
					'click',
					'.bbvaverify',
					function(event) {
						var $btnVerificar = $(this);
						var price = $btnVerificar.parents('.row_grid').text()
								.split(/\n/)[1].trim();
						var code = $btnVerificar.parents('.row_grid').text()
								.split(/\n/)[2].trim();
						var date = $btnVerificar.parents('.row_grid').text()
								.split(/\n/)[3].trim();

						var amount = $("#clientSale-amount").text().replace(
								',', '');
						var trx = $(this).data('pin');
						var vurl = "verificarBBVA-rt.html";
						var rechargetoken = $('#rechargetoken').val();
						var vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};

						$
								.ajax({
									type : "post",
									url : vurl,
									headers : vheaders,
									dataType : "json",
									data : {
										amount : amount,
										pin : trx
									},
									beforeSend : function() {
										$('body')
												.append(
														'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
									},
									error : function() {
										$('body').find('#loading-recharge')
												.remove();
										tagginSaldoErrorRecarga(
												'Internet BBVA',
												'¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
									},
									success : function(data) {
										if (data.state === 'OK') {
											loadRechargeAPI(flagrecarga);
											listarCodigosBBVA(true);
											tagginSaldoBBVAEEcheckout(price);
											tagginSaldoBBVAEEpurchase(code,
													date, price);
										} else {
											if (data.state == 'TIMEOUTTR') {
												data.message = timeoutTrMsg;
											}
											tagginSaldoErrorRecarga(
													'Internet BBVA',
													$("<div/>").html(
															data.message)
															.text());
										}
										$('body').find('#loading-recharge')
												.remove();
										jAlert("<div class='info'></div><p>"
												+ data.message + "</p>");
									}
								})

					});

	$('#grillaBBVA')
			.on(
					'click',
					'.bbvadelete',
					function(event) {
						var $btnAnular = $(this);
						var pin = $(this).data('pin');
						var rechargetoken = $('#rechargetoken').val();
						var vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};

						$
								.ajax({
									type : 'post',
									url : 'anularBBVA-rt.html',
									headers : vheaders,
									dataType : 'text',
									data : {
										pin : $(this).data('pin')
									},
									beforeSend : function() {
										$('body')
												.append(
														'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
									},
									error : function() {
										$('body').find('#loading-recharge')
												.remove();
									},
									success : function(data) {
										$('body').find('#loading-recharge')
												.remove();
										$btnAnular.parents('.row_grid')
												.remove()
										var price = $btnAnular.parents(
												'.row_grid').text().split(/\n/)[1]
												.trim();
										tagginSaldoBBVAEEremoveFromCart(price);
									}
								});
						if ($('#grillaBBVA').find('.bbvadelete').length == 1) {
							$('#grillaBBVA').html('');
						}
					});

	// render each forms
	$forms
			.each(function() {
				var $form = $(this),

				$inputMonto = $form.find('input[name="monto"]'), $inputCode = $form
						.find('input[name="codigo"]'), $inputLoto = $form
						.find('input[name="lotocard"]'), $inputTypeToken = $form
						.find('input[name="type_token"]'), $inputMedioPago = $form
						.find('input[name="medio_pago"]'), $inputStatusCode = $form
						.find('input[name="status_code"]'), $inputIdCode = $form
						.find('input[name="id_code"]'), $inputOptionCard = $form
						.find('input[name="option-card"]'),

				$divError = $form.find('.form__alert_recharge'),

				$divComision = $form.find('.subcontent-comision'),

				$btValidate = $form.find('.button__outline'), $btRecharge = $form
						.find('.button__base'),

				urlRecharge = $form.attr('action'), urlValidate = $btValidate
						.attr('data-action'), $spanValid = $form
						.find('.form__gift-valid'), $tableCodes = $form
						.find('.subcontent-table'), $divForm = $form
						.closest('.subcontent-lotocard'), $divConf = $divForm
						.parent().find('.subcontent-confirm'), $btBackForm = $divConf
						.find('.link__base'), dataCategory = $form.closest(
						'.tabs').attr('data-category'), onValidateCode, submitRecharge, rechargeLotocard, rechargePEFE, rechargeTUPAY, rechargeSPAY, rechargeBBVA, rechargeVisanet, rechargeIzipay, rechargeAgora, onBackLotocard, onChangeCode, onChangeMonto, onChangeField;

				var code_temp = '';

				onChangeMonto = function() {
					if ($inputStatusCode.val() === 'ERR') {
						$divError.html('');
		        		$divError.hide();
						$form.removeClass('error');
						$inputStatusCode.val('DES');
						$inputIdCode.val('-1');
					}
				};

				onChangeCode = function() {
					if (($inputStatusCode.val() === 'ACT' || $inputStatusCode
							.val() === 'APL')
							&& code_temp != $inputCode.val()) {
						$spanValid.fadeOut(150, function() {
							$btValidate.fadeIn(200);
							$btValidate.attr('code-sent', false)
							$btValidate.attr('disabled', false);

							$divError.html('');
							$divError.hide();
							$form.removeClass('error');
							$inputStatusCode.val('DES');
							$inputIdCode.val('-1');
						});
					} else if ($inputStatusCode.val() === 'ERR'
							&& code_temp != $inputCode.val()) {
						$divError.html('');
						$divError.hide();
						$form.removeClass('error');
						$inputStatusCode.val('DES');
						$inputIdCode.val('-1');
					}
				};

				$inputMonto.on('keyup', onChangeMonto);
				$inputLoto.on('keyup', onChangeMonto);
				$inputCode.on('keyup', onChangeCode);

				// validate fields
				$.validate({
					form : $form,
					validateOnBlur : true,
					showHelpOnFocus : true,
					scrollToTopOnError : false,
					onSuccess : function() {
						submitRecharge();
						return false;
					}
				});
				
			    $inputCode.on('input', function () {
			        var valor = $inputCode.val().trim();
			        const $btRechargeAgora = $('#btnRecargaAgora2');
			        
			        // Si el campo estÃ¡ vacÃ­o...
			        if (valor === '') {
			            $btRecharge.attr('disabled', false); // Habilita el botÃ³n de recarga
			            $btRechargeAgora.attr('disabled', false);
			        }
			    });

				onValidateCode = function() {
					var codePromotional = $inputCode.val();
					var channel = $inputMedioPago.val();
					var lotocard = $inputLoto.val();
					var amount = $inputMonto.val();
					
					const $btRechargeAgora = $('#btnRecargaAgora2');


					code_temp = $inputCode.val();

					if (amount == undefined) {
						amount = 0;
					}

					if (lotocard == undefined) {
						lotocard = '';
					}

					if (codePromotional !== '') {
						$btValidate.attr('disabled', true);
						
						// promocion con sesion o con token
						var vurl = "send-code-promotional-validation.html";
						var rechargetoken = $('#rechargetoken').val();
						var vheaders = {};
						if (rechargetoken != null && rechargetoken != "") {
							vurl = "send-code-promotional-validation-api.html";
							vheaders = {
								"rechargetoken" : $('#rechargetoken').val()
							};
						}

						$
								.ajax({
									url : vurl,
									headers : vheaders,
									type : "post",
									data : "codePromotional=" + codePromotional
											+ "&channel=" + channel
											+ "&amount=" + amount
											+ "&lotocard=" + lotocard,
									dataType : "jsonp",
									beforeSend : function() {
										$('body')
												.append(
														'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
									},
									error : function() {
										$('body').find('#loading-recharge')
												.remove();
										jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
									},
									success : function(data) {
										if (data.status === 'ACT'
												&& data.message === 'OK') {
											$inputStatusCode.val(data.status);
											$inputIdCode.val(data.idCode);
											$divError.html('');
											$divError.hide();
						               	  	$form.removeClass('error');
							               	$btRecharge.attr('disabled', false); 
							                $btRechargeAgora.attr('disabled', false);

											var dataLabel = $btValidate
													.attr('data-label');
											// gaEvent(dataCategory, 'Clic',
											// dataLabel);
											$btValidate.fadeOut(150,
													function() {
														$spanValid.fadeIn(200);
														$btValidate.attr(
																'code-sent',
																true)
													});
											datalayerAplicarCodigoPromo();
										} else if (data.status === 'APL') {
											if (rechargetoken != null
													&& rechargetoken != "") {
												loadRechargeAPI(flagrecarga);
											} else {
												loadRecharge();
											}
											$inputStatusCode.val(data.status);
											$inputIdCode.val(data.idCode);
											$divError.html('');
											$form.removeClass('error');

											var dataLabel = $btValidate
													.attr('data-label');
											// gaEvent(dataCategory, 'Clic',
											// dataLabel);
											$btValidate.fadeOut(150,
													function() {
														$spanValid.fadeIn(200);
														$btValidate.attr(
																'code-sent',
																true)
													});
											jAlert(data.message);
										} else if (data.status === 'NAPL') {
											if (rechargetoken != null
													&& rechargetoken != "") {
												loadRechargeAPI(flagrecarga);
											} else {
												loadRecharge();
											}
											$inputStatusCode.val(data.status);
											$inputIdCode.val(data.idCode);
											$divError.html('');
											$form.removeClass('error');
											jAlert(data.message);
										} else if (data.status === 'TIMEOUTTR') {
											if (rechargetoken != null
													&& rechargetoken != "") {
												loadRechargeAPI(flagrecarga);
											} else {
												loadRecharge();
											}
											$inputStatusCode.val('ERR');
											$inputIdCode.val('-1');
											$btValidate.attr('disabled', false);
											$divError.html(timeoutTrMsg);
											$form.addClass('error');
											// jAlert(timeoutTrMsg);
											$btRecharge.attr('disabled', true);
						     	            $btRechargeAgora.attr('disabled', true);
										} else {
											if (rechargetoken != null
													&& rechargetoken != "") {
												loadRechargeAPI(flagrecarga);
											} else {
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
										$('body').find('#loading-recharge')
												.remove();
									}
								});
					}
				};

				rechargeLotocard = function(option, pin, actbono, actwbbono,
						codePromotional, channel) {
					var message = "", alertmsg = "";
					var amount = 0.0;
					var newamount = 0.0;
					var promotionMessage = "";
					var baseUrl = "";
					var authToken = "";
					var cadena = "";
					var idTransaction = 0;

					// recarga con sesion o con token
					var vurl = "recarga_lotocard.html";
					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vurl = "recarga_lotocard_api.html";
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax({
								type : "POST",
								url : vurl,
								headers : vheaders,
								dataType : "json",
								data : "option-card=" + option + "&pin-number="
										+ pin + "&activ-bono=" + actbono
										+ "&activ-wbbono=" + actwbbono
										+ "&codePromotional=" + codePromotional
										+ "&channel=" + channel,
								beforeSend : function() {
									$('body')
											.append(
													'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
								},
								error : function() {
									$('body').find('#loading-recharge')
											.remove();
									$btRecharge.attr('disabled', false);
									jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
									tagginSaldoErrorRecarga(
											'Efectivo Lotocard',
											'¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
								},
								success : function(data) {
									if (rechargetoken != null
											&& rechargetoken != "") {
										loadRechargeAPI(flagrecarga);
									} else {
										loadRecharge();
									}

									message = data.message;
									amount = data.amount;

									newamount = data.newAmount;
									promotionMessage = data.promotionMessage;

									if ($.trim(actbono).includes('true-casino')
											|| $.trim(actbono) == 'true'
											|| $.trim(actwbbono) == 'true') {
										$spanValid
												.fadeOut(
														150,
														function() {
															$btValidate
																	.fadeIn(200);
															$btValidate
																	.attr(
																			'code-sent',
																			false)
															$btValidate.attr(
																	'disabled',
																	false);

															$divError.html('');
															$form
																	.removeClass('error');
															$inputStatusCode
																	.val('DES');
															$inputIdCode
																	.val('-1');
														});
									} else {
										$divError.html('');
										$form.removeClass('error');
										$inputStatusCode.val('DES');
										$inputIdCode.val('-1');
									}

									$inputLoto.val('');
									$inputCode.val('');

									message = message.replace(/_/g, ' ');
									if (promotionMessage == ""
											|| promotionMessage == null
											|| promotionMessage == undefined) {
										promotionMessage = "";
									}

									$("#clientSale-amount").text(
											floatFormat(newamount));

									if (message === "OK") {
										idTransaction = data.balanceItem;
										$("#montoCargado").text(
												floatFormat(amount));
										// $("#saldoDisponible").text(floatFormat(newamount));
										$divForm.fadeOut(150, function() {
											$divConf.fadeIn(250);
										});
										if (option == 1) {
											tagginSaldoLotocardEEaddToCart(amount);
											tagginSaldoLotocardEEcheckout(amount);
											if ($.trim(actbono).includes(
													'true-casino')
													|| $.trim(actbono) == 'true') {
												if (promotionMessage
														.includes("insuficiente") == true) {
													alertmsg = promotionMessage
															+ "\n\nLa recarga ha sido abonada a su saldo principal.\n\nMonto cargado: S/ "
															+ amount;
												} else {
													alertmsg = "Se ha realizado una recarga con éxito a su saldo.\n\nMonto cargado: S/ "
															+ amount
															+ "\n"
															+ promotionMessage;
												}
											} else {
												alertmsg = "Se ha realizado una recarga con éxito a su saldo.\n\nMonto cargado: S/ "
														+ amount
														+ "\nTu saldo disponible es: S/ "
														+ newamount
														+ "\n"
														+ promotionMessage;
											}

											jAlert(alertmsg, null);
											tagginSaldoLotocardEEpurchase(
													idTransaction, amount);
											datalayerContinuarCargarSaldo();
										}
									} else {
										if (option == 1) {
											if (data.status == 'TIMEOUTTR') {
												jAlert(timeouTrtMsg);
											} else {
												jAlert(
														"No se ha logrado realizar la recarga.\n"
																+ message
																+ "\n\nMonto cargado: S/ "
																+ amount
																+ "\nTu saldo disponible es: S/ "
																+ newamount,
														null);
											}
											tagginSaldoErrorRecarga(
													'Efectivo Lotocard',
													"No se ha logrado realizar la recarga. "
															+ message);
										}
									}

									$('body').find('#loading-recharge')
											.remove();
								}
							});
				};

				rechargeTUPAY = function(type_token, amount, actbono,
						actwbbono, codePromotional, channel) {
					var vurl = "tupay_api.html";
					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax({
								type : "post",
								url : vurl,
								headers : vheaders,
								data : "posAmount=" + amount + "&activ-bono="
										+ actbono + "&activ-wbbono="
										+ actwbbono + "&codePromotional="
										+ codePromotional + "&channel="
										+ channel,
								dataType : "text",
								beforeSend : function() {
									$('body')
											.append(
													'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
								},
								error : function() {
									$('body').find('#loading-recharge')
											.remove();
									$btRecharge.attr('disabled', false);
									jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
									if ($('#tabInternet').hasClass('selected')) {
										if (channel == "YAPE_TP") {
											tagginSaldoErrorRecarga(
													'Internet YAPE',
													"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
										} else if (channel == "PLIN_TP") {
											tagginSaldoErrorRecarga(
													'Internet PLIN',
													"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
										}
									} else {
										tagginSaldoErrorRecarga('TUPAY',
												"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
									}
								},
								success : function(e) {
									$('body').find('#loading-recharge')
											.remove();
									var redireccion = $.trim(e.toString())
											.split("|");
									if (redireccion[1] != null
											&& $.trim(redireccion[1]) != "") {
										$btRecharge.attr('disabled', false);
										var msj = $.trim(redireccion[1]);
										if (msj == 'TIMEOUTTR') {
											msj = timeoutTrMsg;
										} else if (msj == 'ERROR') {
											msj = "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos";
										}
										jAlert("<div class='info'></div><p>"
												+ msj + "</p>");
										if ($('#tabInternet').hasClass(
												'selected')) {
											if (channel == "YAPE_TP") {
												tagginSaldoErrorRecarga(
														'Internet YAPE',
														$("<div/>")
																.html(
																		$
																				.trim(redireccion[1]))
																.text());
											} else if (channel == "PLIN_TP") {
												tagginSaldoErrorRecarga(
														'Internet PLIN',
														$("<div/>")
																.html(
																		$
																				.trim(redireccion[1]))
																.text());
											}
										} else {
											tagginSaldoErrorRecarga('TUPAY', $(
													"<div/>").html(
													$.trim(redireccion[1]))
													.text());
										}
									} else {
										if ($.trim(actbono).includes(
												'true-casino')
												|| $.trim(actbono) == 'true'
												|| $.trim(actwbbono) == 'true') {
											$spanValid.fadeOut(150, function() {
												$btValidate.fadeIn(200);
												$btValidate.attr('code-sent',
														false)
												$btValidate.attr('disabled',
														false);

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
										if (channel == "YAPE_TP") {
											$("#divVerificaRecargaYapeTupay")
													.css("display", "block");
											$("#frame_yapetupayl iframe").attr(
													"src", $.trim(redireccion));
											$("#frame_yapetupayl").removeClass(
													"hide");
											$("#close_yapetupayl").removeClass(
													"hide");
										} else if (channel == "PLIN_TP") {
											$("#divVerificaRecargaPlinTupay")
													.css("display", "block");
											$("#frame_plintupayl iframe").attr(
													"src", $.trim(redireccion));
											$("#frame_plintupayl").removeClass(
													"hide");
											$("#close_plintupayl").removeClass(
													"hide");
										}
										// window.open(redireccion, "_blank");
									}
								}
							});
				};

				rechargePEFE = function(type_token, amount, actbono, actwbbono,
						codePromotional, channel) {
					// recarga con sesion o con token
					var vurl = "portal_page.html";
					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vurl = "portal_page_api.html";
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax({
								type : "post",
								url : vurl,
								headers : vheaders,
								data : "posAmount=" + amount + "&activ-bono="
										+ actbono + "&activ-wbbono="
										+ actwbbono + "&codePromotional="
										+ codePromotional + "&channel="
										+ channel + "&lotocard=" + '',
								dataType : "text",
								beforeSend : function() {
									$('body')
											.append(
													'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
								},
								error : function() {
									$('body').find('#loading-recharge')
											.remove();
									$btRecharge.attr('disabled', false);
									jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
									if ($('#tabInternet').hasClass('selected')) {
										if (channel == "PEFE") {
											tagginSaldoErrorRecarga(
													'Internet PagoEfectivo',
													"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
										} else if (channel == "YAPE") {
											tagginSaldoErrorRecarga(
													'Internet YAPE',
													"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
										} else if (channel == "PLIN") {
											tagginSaldoErrorRecarga(
													'Internet PLIN',
													"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
										}
									} else {
										tagginSaldoErrorRecarga(
												'Efectivo PagoEfectivo',
												"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
									}
								},
								success : function(e) {
									if (e != null && e != "") {
										// var redireccion = (e +
										// "").toString();
										var redireccion = $.trim(e.toString())
												.split("|");
										if (redireccion[1] != null
												&& $.trim(redireccion[1]) != "") {
											$btRecharge.attr('disabled', false);
											var msj = $.trim(redireccion[1]);
											if (msj == 'TIMEOUTTR') {
												msj = timeoutTrMsg;
											}
											jAlert("<div class='info'></div><p>"
													+ msj + "</p>");
											if ($('#tabInternet').hasClass(
													'selected')) {
												if (channel == "PEFE") {
													tagginSaldoErrorRecarga(
															'Internet PagoEfectivo',
															$("<div/>")
																	.html(
																			$
																					.trim(redireccion[1]))
																	.text());
												} else if (channel == "YAPE") {
													tagginSaldoErrorRecarga(
															'Internet YAPE',
															$("<div/>")
																	.html(
																			$
																					.trim(redireccion[1]))
																	.text());
												} else if (channel == "PLIN") {
													tagginSaldoErrorRecarga(
															'Internet PLIN',
															$("<div/>")
																	.html(
																			$
																					.trim(redireccion[1]))
																	.text());
												}
											} else {
												tagginSaldoErrorRecarga(
														'Efectivo PagoEfectivo',
														$("<div/>")
																.html(
																		$
																				.trim(redireccion[1]))
																.text());
											}
										} else {
											// if (redireccion != null &&
											// redireccion != "") {
											if ($.trim(actbono).includes(
													'true-casino')
													|| $.trim(actbono) == 'true'
													|| $.trim(actwbbono) == 'true') {
												$spanValid
														.fadeOut(
																150,
																function() {
																	$btValidate
																			.fadeIn(200);
																	$btValidate
																			.attr(
																					'code-sent',
																					false)
																	$btValidate
																			.attr(
																					'disabled',
																					false);

																	$divError
																			.html('');
																	$form
																			.removeClass('error');
																	$inputStatusCode
																			.val('DES');
																	$inputIdCode
																			.val('-1');
																});
											} else {
												$divError.html('');
												$form.removeClass('error');
												$inputStatusCode.val('DES');
												$inputIdCode.val('-1');
											}

											$inputMonto.val('');
											$inputCode.val('');

											if (channel == "YAPE") {
												$("#divVerificaRecargaYape")
														.css("display", "block");
											} else if (channel == "PLIN") {
												$("#divVerificaRecargaPlin")
														.css("display", "block");
											} else if (channel == "PEFE") {
												if (type_token == 1) {
													$("#divVerificaRecargaPEFE")
															.css("display",
																	"block");
												} else if (type_token == 2) {
													$(
															"#divVerificaRecargaPEFEE")
															.css("display",
																	"block");
												}
											}
											datalayerGenerarCodigoPago();
											window.open(redireccion, "_blank");
											// dhtmlwindow.open('resultbox',
											// 'iframe', redireccion,
											// 'PAGOEFECTIVO',
											// 'width=615,height=539,scrolling=1,center=1,resize=0',
											// 'recal');
										}
									} else {
										$btRecharge.attr('disabled', false);
										jAlert(
												"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos",
												null);
										if ($('#tabInternet').hasClass(
												'selected')) {
											if (channel == "PEFE") {
												tagginSaldoErrorRecarga(
														'Internet PagoEfectivo',
														"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
											} else if (channel == "YAPE") {
												tagginSaldoErrorRecarga(
														'Internet YAPE',
														"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
											} else if (channel == "PLIN") {
												tagginSaldoErrorRecarga(
														'Internet PLIN',
														"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
											}
										} else {
											tagginSaldoErrorRecarga(
													'Efectivo PagoEfectivo',
													"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
										}
									}
									$('body').find('#loading-recharge')
											.remove();
								}
							});
				};

				rechargeSPAY = function(type_token, amount, actbono, actwbbono,
						codePromotional, channel) {
					// recarga con sesion o con token
					var vurl = "safety_page_post.html";
					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vurl = "safety_page_api_post.html";
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax({
								type : "post",
								url : vurl,
								headers : vheaders,
								data : "posAmount=" + amount + "&typeToken="
										+ type_token + "&activ-bono=" + actbono
										+ "&activ-wbbono=" + actwbbono
										+ "&codePromotional=" + codePromotional
										+ "&channel=" + channel + "&lotocard="
										+ '',
								// dataType: "text",
								dataType : "json",
								beforeSend : function() {
									$('body')
											.append(
													'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
								},
								error : function() {
									$('body').find('#loading-recharge')
											.remove();
									$btRecharge.attr('disabled', false);
									jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
									if ($('#tabInternet').hasClass('selected')) {
										tagginSaldoErrorRecarga(
												'Internet SafetyPay',
												"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
									} else {
										tagginSaldoErrorRecarga(
												'Efectivo SafetyPay',
												"Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos");
									}
								},
								success : function(e) {
									var redireccion = $.trim(e.url);
									if (redireccion != null
											&& redireccion != ""
											&& redireccion != "null") {
										if ($.trim(actbono).includes(
												'true-casino')
												|| $.trim(actbono) == 'true'
												|| $.trim(actwbbono) == 'true') {
											$spanValid.fadeOut(150, function() {
												$btValidate.fadeIn(200);
												$btValidate.attr('code-sent',
														false)
												$btValidate.attr('disabled',
														false);

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
										datalayerGenerarCodigoPago();
										window.open(redireccion, "_blank");
									} else {
										$btRecharge.attr('disabled', false);
										var state = e.state;
										var message = $.trim(e.message);
										var msj = "";
										if (state == 'TIMEOUTTR') {
											msj = timeoutTrMsg;
										} else if (message != undefined
												&& message != null
												&& message != "") {
											msj = message;
										} else {
											msj = "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos";
										}

										jAlert(msj, null);
										if ($('#tabInternet').hasClass(
												'selected')) {
											tagginSaldoErrorRecarga(
													'Internet SafetyPay', msj);
										} else {
											tagginSaldoErrorRecarga(
													'Efectivo SafetyPay', msj);
										}
									}
									$('body').find('#loading-recharge')
											.remove();
								}
							});
				};

				rechargeIzipay = function(amount, actbono, actwbbono,
						codePromotional, channel) {
					$btRecharge.attr('disabled', false);
					var operatorIdApi = $("#operatorIdApi").val();

					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax(
									{
										type : "POST",
										url : "defineRechargeIzipay.html",
										dataType : "json",
										headers : vheaders,
										async : false,
										data : "amount=" + amount + "&actbono="
												+ actbono + "&actwbbono="
												+ actwbbono
												+ "&codePromotional="
												+ codePromotional + "&channel="
												+ channel + "&operatorId="
												+ operatorIdApi,
										beforeSend : function() {
											$('body')
													.append(
															'<div id="loading-recharge-1" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
										},
									})
							.done(
									function(data) {
										$('body').find('#loading-recharge-1')
												.remove();
										if (data.state == "OK") {
											var parametrosIzi = "?amountIzipay="
													+ amount
													+ "&actbono="
													+ actbono
													+ "&actwbbono="
													+ actwbbono
													+ "&fullName="
													+ $('#full-name').val()
													+ "&lastName="
													+ $('#last-name').val()
													+ "&identifer="
													+ "CID-"
													+ $("#cid").val()
													+ "-latinka.com.pe"
													+ "&codePromotional="
													+ codePromotional
													+ "&channel="
													+ channel
													+ "&operatorId="
													+ $("#operatorIdApi").val()
													+ "&docTypeIzi="
													+ $("#docTypeIzi").val()
													+ "&docNumber="
													+ $("#docNumber").val()
													+ "&cid="
													+ $("#cid").val()
													+ "&number="
													+ data.idTransactionIzipay
													+ "&apiKey="
													+ data.apiKey
													+ "&mobilePhone="
													+ $("#mobilePhone").val()
													+ "&signature="
													+ data.signature;
											$('body')
													.find(
															'#div-lightbox-izipay-ilot')
													.remove();
											$('body')
													.append(
															'<div id="loading-recharge-1" class="loading-ilot" style="z-index: 10001 !important;"></div>');

											if (operatorIdApi == "5588") {
												$('body')
														.append(
																'<div id="div-lightbox-izipay-ilot" style="position:fixed; top:18%; left:35%;z-index: 10002;width:30%; height: 50%; display: block; background-color: white; border-radius: 7px;"><iframe id="frmLightboxIzipay" frameborder="0" src="recarga-epago.html'
																		+ parametrosIzi
																		+ '" style="z-index: 10003; width:100%; height:100%;"></iframe></div>');
											} else {
												$('body')
														.append(
																'<div id="div-lightbox-izipay-ilot" style="position:fixed; top:18%; left:35%;z-index: 10002;width:30%; height: 42%; display: block; background-color: white; border-radius: 7px;"><iframe id="frmLightboxIzipay" frameborder="0" src="recarga-epago.html'
																		+ parametrosIzi
																		+ '" style="z-index: 10003; width:100%; height:100%;"></iframe></div>');
											}
										} else {
											jAlert('<p style="text-align: justify;margin: 0px;">'
													+ data.message + '</p>');
										}
									}).fail(function() {
								$('body').find('#loading-recharge-1').remove();
							});
				};

				rechargeVisanet = function(amount, actbono, actwbbono,
						codePromotional, channel) {
					$btRecharge.attr('disabled', false);

					var nombres = $('#full-name').val();
					var apellidos = $('#last-name').val();
					// var email = $('#email').val();
					var email = "0";
					var client_id = "0";

					var remote_addr = $('#remote-addr').val();
					var monto = amount;
					var merchant_logo = $('#vn-merchantlogo').val();
					var timeout_url = window.location.href;

					var buttonParameters = {
						clientId : client_id,
						amount : monto,
						remoteAddr : remote_addr,
						cardHolderName : nombres,
						cardHolderLastName : apellidos,
						cardHolderEmail : email,
						merchantLogo : merchant_logo,
						timeoutUrl : timeout_url,
						actbono : actbono,
						actwbbono : actwbbono,
						typeCard : 'VISA',
						codePromotional : codePromotional,
						channel : channel
					};

					var promotionMessage = "";

					var intervalVisanet = 0;
					var intervalTimeOutVisanet = 0;

					// recarga con sesion o con token
					var vurl = "buildVisaForm.html";
					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vurl = "buildVisaFormAPI.html";
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax({
								type : "post",
								url : vurl,
								headers : vheaders,
								dataType : 'json',
								contentType : 'application/json',
								data : JSON.stringify(buttonParameters),
								// global: false,
								// async: false,
								beforeSend : function() {
									$('body')
											.append(
													'<div id="loading-recharge-1" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
								},
								success : function(e) {
									$('#vn-sk').val(e.sessionKey);

									if (e.sessionKey != null
											&& e.sessionKey != ''
											&& e.sessionKey == '0') {
										$('body').find('#loading-recharge-1')
												.remove();
										var msj = e.htmlText;
										if (msj == 'TIMEOUTTR') {
											msj = timeoutTrMsg;
										}
										jAlert(msj);
										tagginSaldoErrorRecarga(
												'Internet Visa', e.htmlText);
										return;
									}

									// /$("#frameButtonVisa").attr('srcdoc',
									// e.htmlText);
									if (isEdge() || isIE()) {
										$("#modal-visa")
												.append(
														'<iframe id="frameButtonVisa" frameborder="0" style="width:100%; height:100%"></iframe>');
										var iframeDocument = document
												.querySelector('#frameButtonVisa').contentWindow.document;
										iframeDocument.open('text/html',
												'replace');
										iframeDocument.write(e.htmlText);
										iframeDocument.close();
									} else {
										$("#modal-visa")
												.append(
														'<iframe id="frameButtonVisa" frameborder="0" style="width:100%; height:100%"></iframe>');
										$("#frameButtonVisa").attr('srcdoc',
												e.htmlText);
									}

									$("#frameButtonVisa").attr('srcdoc',
											e.htmlText);
									$('#modal-visa').css('display', 'block');
									$('#modal-visa').css('z-index',
											'2147483649');
									$("#modal-visa").css('width',
											$(window).width());
									$("#modal-visa").css('height',
											$(window).height());

									tagginSaldoEEcheckout();
									datalayerButtonCargarSaldo();
									$("#frameButtonVisa")
											.on(
													'load',
													function() {
														$('body')
																.find(
																		'#loading-recharge-1')
																.remove();
														var frameVisa = document
																.getElementById("frameButtonVisa");
														// var iframeDocument =
														// frameVisa.contentDocument
														// ||
														// iframe.contentWindow.document;
														var iframeDocument = frameVisa.contentDocument;
														var framePago = iframeDocument
																.getElementById("visaNetJS");
														if (framePago != null) {
															if (intervalVisanet === 0) {
																intervalVisanet = setInterval(
																		checkFormVisanet,
																		1000);
																intervalTimeOutVisanet = setInterval(
																		checkFormTimeOutVisanet,
																		900000);// 15
																				// min
															} else {
																clearInterval(intervalVisanet);
																clearInterval(intervalTimeOutVisanet);
															}

															function checkFormTimeOutVisanet() {
																// $("#frameButtonVisa").removeAttr('srcdoc');
																var fVisa = document
																		.getElementById("frameButtonVisa");
																var modalVisa = document
																		.getElementById("modal-visa");
																modalVisa
																		.removeChild(fVisa);

																$('#modal-visa')
																		.css(
																				'display',
																				'none');
																clearInterval(intervalTimeOutVisanet);
															}

															function checkFormVisanet() {
																if (framePago.style.display == 'none') {
																	// $("#frameButtonVisa").removeAttr('srcdoc');
																	var fVisa = document
																			.getElementById("frameButtonVisa");
																	var modalVisa = document
																			.getElementById("modal-visa");
																	modalVisa
																			.removeChild(fVisa);

																	$(
																			'#modal-visa')
																			.css(
																					'display',
																					'none');
																	clearInterval(intervalVisanet);
																	clearInterval(intervalTimeOutVisanet);
																} else {
																	var fv1 = document
																			.getElementById("frameButtonVisa");
																	var id1 = fv1.contentDocument;
																	// var
																	// hiddenToken
																	// =
																	// iframeDocument.getElementsByName("transactionToken")[0];
																	var hiddenToken = id1
																			.getElementsByName("transactionToken")[0];
																	if (typeof hiddenToken !== 'undefined') {
																		clearInterval(intervalVisanet);
																		clearInterval(intervalTimeOutVisanet);
																		$(
																				'body')
																				.append(
																						'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
																		checkResultVisanet();
																	}
																}
															}
															;
														}

														function checkResultVisanet() {
															var intervalResultVisanet = setInterval(
																	resultVisanet,
																	5000);
															var countVisa = 0;

															function resultVisanet() {
																countVisa = countVisa + 1;
																if (countVisa >= 5) {
																	$('body')
																			.find(
																					'#loading-recharge')
																			.remove();
																	$(
																			"#frameButtonVisa")
																			.removeAttr(
																					'srcdoc');
																	$(
																			'#modal-visa')
																			.css(
																					'display',
																					'none');
																	clearInterval(intervalResultVisanet);
																	jAlert('El proceso de solicitud ha tomado más tiempo de lo permitido, por favor verifica el estado de tu transacción en tu cuenta.');
																	tagginSaldoErrorRecarga(
																			'Internet Visa',
																			'El proceso de solicitud ha tomado más tiempo de lo permitido, por favor verifica el estado de tu transacción en tu cuenta.');
																} else if (countVisa > 0) {
																	var transactionParameters = {
																		amount : monto,
																		actbono : actbono,
																		actwbbono : actwbbono,
																		codePromotional : codePromotional 
																	};

																	// recarga
																	// con
																	// sesion o
																	// con token
																	var vurl = "findVisanetRecargaResult.html";
																	var vheaders = {};
																	var rechargetoken = $(
																			'#rechargetoken')
																			.val();
																	if (rechargetoken != null
																			&& rechargetoken != "") {
																		vurl = "findVisanetRecargaResultAPI.html";
																		vheaders = {
																			"rechargetoken" : $(
																					'#rechargetoken')
																					.val()
																		};
																	}
																	$
																			.ajax({
																				type : "post",
																				url : vurl,
																				headers : vheaders,
																				dataType : 'json',
																				contentType : 'application/json',
																				data : JSON
																						.stringify(transactionParameters),
																				// global:
																				// false,
																				// async:
																				// false,
																				success : function(
																						jsonResult) {
																					var resultKey = jsonResult.resultKey;
																					var resultMessage = jsonResult.resultMessage;
																					promotionMessage = jsonResult.promotionMessage;

																					if (resultMessage != null) {
																						clearInterval(intervalResultVisanet);
																						// $("#frameButtonVisa").removeAttr('srcdoc');
																						var fVisa = document
																								.getElementById("frameButtonVisa");
																						var modalVisa = document
																								.getElementById("modal-visa");
																						modalVisa
																								.removeChild(fVisa);
																						$(
																								'#modal-visa')
																								.css(
																										'display',
																										'none');

																						if (resultKey == 'OK') {
																							if (rechargetoken != null
																									&& rechargetoken != "") {
																								loadRechargeAPI(flagrecarga);
																							} else {
																								loadRecharge();
																							}

																							var commissionAmount = jsonResult.commissionAmount;
																							var arrayResultMessage = resultMessage
																									.split("|");
																							tagginSaldoEEpurchase(
																									arrayResultMessage[2],
																									monto);
																							var rptaTransaccion = '';
																							rptaTransaccion += "\nNº Transacción:"
																									+ arrayResultMessage[2];
																							rptaTransaccion += "\nVisa:"
																									+ arrayResultMessage[4];
																							rptaTransaccion += "\n"
																									+ arrayResultMessage[3];
																							// rptaTransaccion+="\nImporte:"+arrayResultMessage[5];
																							// rptaTransaccion+="\nMoneda:"+arrayResultMessage[6];
																							// rptaTransaccion+="\nDescripción:";
																							if (commissionAmount > 0) {
																								rptaTransaccion += "\nComisión por recarga con Tarjeta Visa: S/ "
																										+ floatFormat(commissionAmount);
																							}
																							rptaTransaccion += '\n\n<span style="font-size: 11px;">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>';

																							if (promotionMessage == ""
																									|| promotionMessage == null
																									|| promotionMessage == undefined) {
																								promotionMessage = "";
																							}

																							if ($
																									.trim(
																											actbono)
																									.includes(
																											'true-casino')
																									|| $
																											.trim(actbono) == 'true'
																									|| $.trim(codePromotional) != null			) {
																								if (promotionMessage
																										.includes("insuficiente") == true) {
																									jAlert('<p style="text-align: justify;margin: 0px;">'
																											+ promotionMessage
																											+ '\n\nLa recarga ha sido abonada a su saldo principal.\n\nMonto cargado: <span style="font-weight: bold;">S/ '
																											+ floatFormat(monto)
																											+ "</span>"
																											+ '\n'
																											+ rptaTransaccion
																											+ "</p>");
																								} else {
																									jAlert('<p style="text-align: justify;margin: 0px;">'
																											+ 'Su recarga se ha realizado exitosamente'
																											+ "\n"
																											+ promotionMessage
																											+ '\n'
																											+ rptaTransaccion
																											+ "</p>");
																								}
																							} else {
																								if ($
																										.trim(promotionMessage) !== '') {
																									promotionMessage = "\n"
																											+ promotionMessage
																											+ "\n";
																								} else {
																									promotionMessage = "\n";
																								}
																								jAlert('<p style="text-align: justify;margin: 0px;">'
																										+ 'Su recarga se ha realizado exitosamente \nSaldo cargado: <span style="font-weight: bold;">S/ '
																										+ floatFormat(monto)
																										+ "</span>"
																										+ promotionMessage
																										+ rptaTransaccion
																										+ "</p>");
																							}

																							if ($
																									.trim(
																											actbono)
																									.includes(
																											'true-casino')
																									|| $
																											.trim(actbono) == 'true'
																									|| $
																											.trim(actwbbono) == 'true'
																									|| $.trim(codePromotional) != null			) {
																								$spanValid
																										.fadeOut(
																												150,
																												function() {
																													$btValidate
																															.fadeIn(200);
																													$btValidate
																															.attr(
																																	'code-sent',
																																	false)
																													$btValidate
																															.attr(
																																	'disabled',
																																	false);

																													$divError
																															.html('');
																													$form
																															.removeClass('error');
																													$inputStatusCode
																															.val('DES');
																													$inputIdCode
																															.val('-1');
																												});
																							} else {
																								$divError
																										.html('');
																								$form
																										.removeClass('error');
																								$inputStatusCode
																										.val('DES');
																								$inputIdCode
																										.val('-1');
																							}

																							$divComision
																									.addClass('hide');
																							$inputMonto
																									.val('');
																							$inputCode
																									.val('');
																							$btRecharge
																									.attr(
																											'disabled',
																											true);
																						} else {
																							var arrayResultMessage = resultMessage
																									.split("|");
																							// if($("#operatorIdApi").val()!="5586"){
																							// var
																							// rptaTransaccion
																							// =
																							// '';
																							// rptaTransaccion+=
																							// "\n"+arrayResultMessage[1];
																							// rptaTransaccion+=
																							// "\nNº
																							// Transacción:"+arrayResultMessage[2];
																							// rptaTransaccion+=
																							// "\n"+arrayResultMessage[3];
																							//                                    				
																							// //jAlert(resultMessage);
																							// jAlert('<p
																							// style="text-align:
																							// justify;margin:
																							// 0px;">'+rptaTransaccion+"</p>");
																							// tagginSaldoErrorRecarga('Internet
																							// Visa',
																							// rptaTransaccion);
																							// }else{
																							$
																									.ajax({
																										type : "post",
																										url : "registerCA.html",
																										headers : vheaders,
																										dataType : 'json',
																										data : "&medio=NIUBIZ&code="
																												+ arrayResultMessage[0]
																												+ "&description="
																												+ arrayResultMessage[1]
																												+ "&monto="
																												+ monto
																												+ "&operatorId="
																												+ $(
																														"#operatorIdApi")
																														.val(),
																										success : function(
																												data) {
																											if (data.ban != undefined
																													&& data.ban == "OK") {
																												$(
																														'body')
																														.find(
																																'#loading-recharge')
																														.remove();
																												localStorage
																														.setItem(
																																"ban",
																																"OK");
																												$
																														.ajax({
																															type : "post",
																															url : "salirCA.html",
																															dataType : 'json',
																															success : function(
																																	data) {
																																if ($(
																																		"#operatorIdApi")
																																		.val() != "5586") {
																																	// location.replace(data.eCommerceHome);
																																	// location.reload();
																																	var ban = localStorage
																																			.getItem("ban");
																																	if (ban == "OK") {
																																		localStorage
																																				.removeItem("ban");
																																		var msgError = '<div style="font-family: \'Roboto\';"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"><p style="text-align: center;margin: 0px;"><b>Detectamos una irregularidad en tu cuenta</b><br><br>Por tu seguridad y de acuerdo con lo establecido en los T&C tu cuenta está bloqueada temporalmente.</p></div><br><br>'
																																				+ '<button class="button button-orange-light no-margin green" style="cursor: pointer; width: 50%;" onclick="closePopupCA(\'popup-message-session\')" type="button">OK</button></div>';
																																		$(
																																				'#msg-session')
																																				.html(
																																						msgError);
																																		openModal(
																																				"#popup-message-session",
																																				"");
																																	}
																																} else {
																																	try {
																																		window.parent
																																				.postMessage(
																																						'closeLightboxRecharge',
																																						'*');
																																	} catch (e) {
																																	}
																																}
																															}
																														});
																											} else {
																												var rptaTransaccion = '';
																												rptaTransaccion += "\n"
																														+ arrayResultMessage[1];
																												rptaTransaccion += "\nNº Transacción:"
																														+ arrayResultMessage[2];
																												rptaTransaccion += "\n"
																														+ arrayResultMessage[3];

																												// jAlert(resultMessage);
																												jAlert('<p style="text-align: justify;margin: 0px;">'
																														+ rptaTransaccion
																														+ "</p>");
																												tagginSaldoErrorRecarga(
																														'Internet Visa',
																														rptaTransaccion);
																											}
																										}
																									});
																							// }
																						}
																						$
																								.ajax({
																									type : "POST",
																									url : "resetVisanetTransaction.html",
																									dataType : "json",
																									async : false,
																									success : function(
																											data) {

																									}
																								});
																						$(
																								'body')
																								.find(
																										'#loading-recharge')
																								.remove();
																					} else {
																						var status = jsonResult.status;
																						var msj = '¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.';
																						if (status == 'TIMEOUTTR') {
																							msj = timeoutTrMsg;
																						}
																						$(
																								'body')
																								.find(
																										'#loading-recharge')
																								.remove();
																						// $("#frameButtonVisa").removeAttr('srcdoc');
																						var fVisa = document
																								.getElementById("frameButtonVisa");
																						var modalVisa = document
																								.getElementById("modal-visa");
																						modalVisa
																								.removeChild(fVisa);
																						$(
																								'#modal-visa')
																								.css(
																										'display',
																										'none');
																						clearInterval(intervalResultVisanet);
																						jAlert(msj);
																						tagginSaldoErrorRecarga(
																								'Internet Visa',
																								msj);
																					}
																				},
																				error : function() {
																					$(
																							'body')
																							.find(
																									'#loading-recharge')
																							.remove();
																					// $("#frameButtonVisa").removeAttr('srcdoc');
																					var fVisa = document
																							.getElementById("frameButtonVisa");
																					var modalVisa = document
																							.getElementById("modal-visa");
																					modalVisa
																							.removeChild(fVisa);
																					$(
																							'#modal-visa')
																							.css(
																									'display',
																									'none');
																					clearInterval(intervalResultVisanet);
																					jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
																					tagginSaldoErrorRecarga(
																							'Internet Visa',
																							'¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
																				}
																			});
																}
															}

														}
														;

													});
								},
								error : function() {
									$('body').find('#loading-recharge-1')
											.remove();
									jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
								}
							});

				};

				rechargeAgora = function(amount, actbono, actwbbono,
						codePromotional, channel) {
					var cel_agora = $("#cel_agora").val();
					// recarga con sesion o con token
					var vurl = "rechargeAgora.html";
					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vurl = "rechargeAgoraAPI.html";
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax(
									{
										type : "POST",
										url : vurl,
										headers : vheaders,
										dataType : "json",
										data : "codePromotional="
												+ codePromotional + "&channel="
												+ channel + "&lotocard=" + ''
												+ "&monto=" + amount
												+ "&actbono=" + actbono
												+ "&actwbbono=" + actwbbono
												+ "&phoneUpdateAgora="
												+ actualizarCelularAgora
												+ "&phoneUpdate=" + cel_agora,
										beforeSend : function() {
											$('body')
													.append(
															'<div id="loading-recharge-1" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
										},
									})
							.done(
									function(data) {
										$('body').find('#loading-recharge-1')
												.remove();
										if (data.state === "OK") {
											var cerrarSesion = false;
											if (actualizarCelularAgora == 1
													&& data.stateUpdatePhone == 'OK') {
												cerrarSesion = true;
												$.ajax({
													type : "POST",
													url : "close-session.html",
													dataType : "json",
													async : false,
													success : function(data) {

													}
												});
											}
											actualizarCelularAgora = -1;
											if (!cerrarSesion) {
												jAlertAgora(
														"<p style='font-weight: 700; text-align: center;'>¡Tu solicitud ha sido enviada!</p>"
																+ data.message,
														data.btnName,
														function() {
														});
											} else {
												jAlertAgora(
														"<p style='font-weight: 700; text-align: center;'>¡Tu solicitud ha sido enviada!</p>"
																+ data.message,
														data.btnName,
														function() {
															try {
																parent.location
																		.reload();
															} catch (ex) {
															}
														});
											}
											datalayerContinuarCargarSaldo();
											$inputMonto.val('');
											$inputCode.val('');
											$("#btnRecargaAgora").attr(
													'disabled', true);
											$("#btnRecargaAgora2").attr(
													'disabled', true);
											$("#seccion_agora_xconfirmar").css(
													'display', 'none');
											$("#seccion_agora_confirmada").css(
													'display', 'block');
											if ($.trim(actbono).includes(
													'true-casino')
													|| $.trim(actbono) == 'true'
													|| $.trim(actwbbono) == 'true') {
												$spanValid
														.fadeOut(
																150,
																function() {
																	$btValidate
																			.fadeIn(200);
																	$btValidate
																			.attr(
																					'code-sent',
																					false)
																	$btValidate
																			.attr(
																					'disabled',
																					false);

																	$divError
																			.html('');
																	$form
																			.removeClass('error');
																	$inputStatusCode
																			.val('DES');
																	$inputIdCode
																			.val('-1');
																});
											} else {
												$divError.html('');
												$form.removeClass('error');
												$inputStatusCode.val('DES');
												$inputIdCode.val('-1');
											}

											$divComision.addClass('hide');
										} else {
											var msj = data.message;
											if (data.state == 'TIMEOUTTR') {
												msj = timeoutTrMsg;
											}
											jAlert("<p style='font-weight: 700; text-align: center;'>Tu solicitud no se ha generado</p><p style='text-align: justify;'>"
													+ msj + "</p>");
											$("#btnRecargaAgora").attr(
													'disabled', false);
											$("#btnRecargaAgora2").attr(
													'disabled', false);
										}
									})
							.fail(
									function() {
										$('body').find('#loading-recharge-1')
												.remove();
										tagginSaldoErrorRecarga(
												'Internet Agora',
												'¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.');
										jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
										$("#btnRecargaAgora").attr('disabled',
												false);
										$("#btnRecargaAgora2").attr('disabled',
												false);
									});
				};

				submitRecharge = function() {
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
					var msjValidacion = "No aplicaste tu código promocional ¿deseas continuar sin promoción?"// "Ingresaste
																												// un
																												// código
																												// promocional
																												// pero
																												// aún
																												// no
																												// lo
																												// has
																												// aplicado.\n
																												// ¿Deseas
																												// continuar
																												// sin
																												// aplicarlo?";

					if (status_code === 'ACT') {
						var idcasino = "0";
						if (id_code.split("|").length > 1) {
							idcasino = id_code.split("|")[0];
						}
						if (id_code === '33') {
							actbono = true;
						} else if (id_code === '34') {
							actwbbono = true;
						} else if (idcasino === '35') {
							actbono = 'true-casino|' + id_code.split("|")[1];
						}
					}

					switch (channel) {
					case 'IZIPAY':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(msjValidacion, null, function(r) {
								if (r) {
									rechargeIzipay(amount, actbono, actwbbono,
											codePromotional, channel);
								} else {
									$btRecharge.attr('disabled', false);
								}
							});
						} else {
							rechargeIzipay(amount, actbono, actwbbono,
									codePromotional, channel);
						}
						break;
					case 'VISANET':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(msjValidacion, null, function(r) {
								if (r) {
									/*
									 * var vall=validarMonto(); if(vall<=2000){
									 * rechargeVisanet(amount,actbono,actwbbono);
									 * }else{ jAlert("Excediste el monto máximo
									 * de recarga por día con este <br/> medio
									 * (S/ 2,000)","Aviso"); }
									 */
									rechargeVisanet(amount, actbono, actwbbono,
											codePromotional, channel);
								} else {
									$btRecharge.attr('disabled', false);
								}
							});
						} else {
							/*
							 * var vall2=validarMonto(); if(vall2<=2000){
							 * rechargeVisanet(amount,actbono,actwbbono); }else{
							 * jAlert("Excediste el monto máximo de recarga por
							 * día con este <br/> medio (S/ 2,000)","Aviso"); }
							 */
							rechargeVisanet(amount, actbono, actwbbono,
									codePromotional, channel);
						}
						break;
					case 'AGORA':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(msjValidacion, null, function(r) {
								if (r) {
									/*
									 * var vall=validarMontoAgora(); if(vall<=2000){
									 * rechargeAgora(amount,actbono,actwbbono);
									 * }else{ jAlert("Excediste el monto máximo
									 * de recarga por día con este <br/> medio
									 * (S/ 2,000)","Aviso"); }
									 */
									rechargeAgora(amount, actbono, actwbbono,
											codePromotional, channel);
								} else {
									$btRecharge.attr('disabled', false);
								}
							});
						} else {
							/*
							 * var vall2=validarMontoAgora(); if(vall2<=2000){
							 * rechargeAgora(amount,actbono,actwbbono); }else{
							 * jAlert("Excediste el monto máximo de recarga por
							 * día con este <br/> medio (S/ 2,000)","Aviso"); }
							 */
							rechargeAgora(amount, actbono, actwbbono,
									codePromotional, channel);
						}
						break;
					case 'LOTOCARD':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(
									msjValidacion,
									null,
									function(r) {
										if (r) {
											rechargeLotocard(option, lotocard,
													actbono, actwbbono,
													codePromotional, channel);
										} else {
											$btRecharge.attr('disabled', false);
										}
									});
						} else {
							rechargeLotocard(option, lotocard, actbono,
									actwbbono, codePromotional, channel);
						}
						break;
					case 'BCP':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(msjValidacion, null, function(r) {
								if (r) {
									grillaCode(null, amount, "", actbono,
											actwbbono, true, $spanValid,
											$btValidate, $divError, $form,
											$inputStatusCode, $inputIdCode,
											$inputMonto, $inputCode,
											$btRecharge, channel);
								} else {
									$btRecharge.attr('disabled', false);
								}
							});
						} else {
							grillaCode(null, amount, "", actbono, actwbbono,
									true, $spanValid, $btValidate, $divError,
									$form, $inputStatusCode, $inputIdCode,
									$inputMonto, $inputCode, $btRecharge,
									channel);
							datalayerGenerarCodigoPago();
						}
						break;
					case 'BBVA':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(msjValidacion, null, function(r) {
								if (r) {
									generarCodigoBBVA(amount, actbono,
											actwbbono, $spanValid, $btValidate,
											$divError, $form, $inputStatusCode,
											$inputIdCode, $inputMonto,
											$inputCode, $btRecharge, channel);
								} else {
									$btRecharge.attr('disabled', false);
								}
							});
						} else {
							generarCodigoBBVA(amount, actbono, actwbbono,
									$spanValid, $btValidate, $divError, $form,
									$inputStatusCode, $inputIdCode,
									$inputMonto, $inputCode, $btRecharge,
									channel);
							datalayerGenerarCodigoPago();
						}
						break;
					case 'PEFE':
					case 'YAPE':
					case 'PLIN':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(
									msjValidacion,
									null,
									function(r) {
										if (r) {
											rechargePEFE(type_token, amount,
													actbono, actwbbono,
													codePromotional, channel);
										} else {
											$btRecharge.attr('disabled', false);
										}
									});
						} else {
							rechargePEFE(type_token, amount, actbono,
									actwbbono, codePromotional, channel);
						}
						break;
					case 'YAPE_TP':
					case 'PLIN_TP':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(
									msjValidacion,
									null,
									function(r) {
										if (r) {
											rechargeTUPAY(type_token, amount,
													actbono, actwbbono,
													codePromotional, channel);
										} else {
											$btRecharge.attr('disabled', false);
										}
									});
						} else {
							rechargeTUPAY(type_token, amount, actbono,
									actwbbono, codePromotional, channel);
						}
						break;
					case 'SPAY':
						if (status_code === 'DES'
								&& codePromotional != undefined
								&& codePromotional != null
								&& codePromotional != '') {
							jConfirm(
									msjValidacion,
									null,
									function(r) {
										if (r) {
											rechargeSPAY(type_token, amount,
													actbono, actwbbono,
													codePromotional, channel);
										} else {
											$btRecharge.attr('disabled', false);
										}
									});
						} else {
							rechargeSPAY(type_token, amount, actbono,
									actwbbono, codePromotional, channel);
						}

						break;
					}
				};

				onChangeField = function() {
					if ($form.isValid({}, {}, false)) {
						$btRecharge.attr('disabled', false);
						$inputCode.attr('disabled', false);

						if ($inputMedioPago.val() == 'VISANET') {
							var comision = getComisionVisa(parseInt($inputMonto
									.val(), 10));
							if (comision > 0) {
								$divComision.removeClass('hide');
								$("#monto_comision_visanet").html(
										$.trim(configLoaded.msjComVisa) + ' '
												+ (floatFormat(comision)));
							} else {
								$divComision.addClass('hide');
							}
						} else if ($inputMedioPago.val() == 'AGORA') {
							var comision = getComisionAgora(parseInt(
									$inputMonto.val(), 10));
							if (comision > 0) {
								$divComision.removeClass('hide');
								$("#monto_comision_agora").html(
										$.trim(configLoaded.msjComAgr) + ' '
												+ floatFormat(comision));
							} else {
								$divComision.addClass('hide');
							}
							$("#btnRecargaAgora2").attr('disabled', false);
						}

					} else {
						$btRecharge.attr('disabled', true);
						$inputCode.attr('disabled', true);

						$divComision.addClass('hide');

						if ($inputMedioPago.val() == 'AGORA') {
							$("#btnRecargaAgora2").attr('disabled', true);
						}
					}

					if ($btValidate.attr('code-sent')) {
						$inputCode.removeAttr('readonly').val('');
						$spanValid.fadeOut(150, function() {
							$btValidate.removeAttr('disabled').fadeIn(200);
							$btValidate.attr('code-sent', false);
						});
					}
				};

				onBackLotocard = function(e) {
					e.preventDefault();
					$divConf.fadeOut(150, function() {
						$divForm.fadeIn(250);
					});
				};

				$btValidate.on('click', onValidateCode);
				$btBackForm.on('click', onBackLotocard);
				$inputMonto.on('change keyup', onChangeField);
				$inputLoto.on('change keyup', onChangeField);
			});
};

var openPopRecharge = function() {
	$('.pop-recharge').fadeIn(350);
};

var closePopRecharge = function() {
	try {
		reiniciar();
	} catch (err) {
		console.log(err.message);
	}
};

var renderPopup = function() {
	renderTabs();
	renderRechargeForms();
};

function reiniciar() {
	$('.tabs__list-item').removeClass('selected');
	$('.tabs__list-subitem').removeClass('selected');

	$('#tabInternet').addClass('selected');
	$('#tabInternetInterbank').addClass('selected');
	$('#tabEfectivoInterbank').addClass('selected');

	renderTabs();

	$('.ilot .form__input input[type="text"]').val("");

	$('.button__base').attr('disabled', true);
	$('.form__gift-valid').css('display', 'none');
	$('.button__outline').css('display', 'inline-block');
	$('.button__outline').attr('disabled', false);

	$('.ilot .form__input').removeClass('filled');
	$('.ilot .form__input').removeClass('has-error');
}

function handleMessage(e) {
	if (e != null && e != undefined && e.data != null && e.data != undefined) {
		try {
			var arrayData = e.data.split("|");
			var operacion = arrayData[0];
			if (operacion === 'hideLightboxIzipay') {
				$('body').find('#loading-recharge-1').remove();
				$('body').find('#div-lightbox-izipay-ilot').remove();
				var state = arrayData[1];
				if (state == "AUTHORIZED") {
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
					if (actbono == "true-casino") {
						actbono += "|" + arrayData[11];
						actwbbono = arrayData[12];
						codePromotional = arrayData[13];
						channel = arrayData[14];
						json_request = arrayData[15];
						json_response = arrayData[16];
						card = arrayData[17];
						idIzipay = arrayData[18];
					}

					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax(
									{
										type : "POST",
										url : "rechargeIzipay.html",
										dataType : "json",
										headers : vheaders,
										async : false,
										data : "state=" + state
												+ "&uniqueIdentifier="
												+ uniqueIdentifier + "&number="
												+ number + "&brand=" + brand
												+ "&amount=" + monto
												+ "&created=" + created
												+ "&code=" + code + "&message="
												+ message + "&operationNumber="
												+ operationNumber + "&actbono="
												+ actbono + "&actwbbono="
												+ actwbbono
												+ "&codePromotional="
												+ codePromotional + "&channel="
												+ channel + "&operatorId="
												+ $("#operatorIdApi").val()
												+ "&json_request="
												+ json_request
												+ "&json_response="
												+ json_response + "&idIzipay="
												+ idIzipay,
										beforeSend : function() {
											$('body')
													.append(
															'<div id="loading-recharge-1" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
										},
									})
							.done(
									function(data) {
										$('body').find('#loading-recharge-1')
												.remove();
										loadRechargeAPI(flagrecarga);
										var promotionMessage = data.promotionMessage;
										if (promotionMessage == ""
												|| promotionMessage == null
												|| promotionMessage == undefined) {
											promotionMessage = "";
										}

										var rptaTransaccion = '';
										rptaTransaccion += "\nNº Transacción:"
												+ number;
										rptaTransaccion += "\n" + brand + ":"
												+ card;
										rptaTransaccion += "\n" + data.fecha;

										rptaTransaccion += '\n\n<span style="font-size: 11px;">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>';

										if ($.trim(actbono).includes(
												'true-casino')
												|| $.trim(actbono) == 'true') {
											if (promotionMessage
													.includes("insuficiente") == true) {
												// jAlert('<p style="text-align:
												// justify;margin:
												// 0px;">'+promotionMessage +
												// '\n\nSe ha realizado una
												// recarga con éxito a tu
												// saldo.\n\nMonto cargado:
												// <span>S/
												// '+floatFormat(monto)+"</span></p>");
												jAlert('<p style="text-align: justify;margin: 0px;">'
														+ promotionMessage
														+ '\n\nLa recarga ha sido abonada a su saldo principal.\n\nMonto cargado: <span style="font-weight: bold;">S/ '
														+ floatFormat(monto)
														+ "</span>"
														+ '\n'
														+ rptaTransaccion
														+ "</p>");
											} else {
												// jAlert('<p style="text-align:
												// justify;margin: 0px;">'+'Se
												// ha realizado una recarga con
												// éxito a tu saldo.'+ "\n" +
												// promotionMessage+"</p>");
												jAlert('<p style="text-align: justify;margin: 0px;">'
														+ 'Su recarga se ha realizado exitosamente'
														+ "\n"
														+ promotionMessage
														+ '\n'
														+ rptaTransaccion
														+ "</p>");
											}
										} else {
											if ($.trim(promotionMessage) !== '') {
												promotionMessage = "\n"
														+ promotionMessage
														+ "\n";
											} else {
												// promotionMessage="\n Tu saldo
												// disponible es: S/
												// "+floatFormat(data.newAmount);
												promotionMessage = "\n";
											}
											// jAlert('<p style="text-align:
											// justify;margin: 0px;">'+'Se ha
											// realizado una recarga con éxito a
											// tu saldo. \n\nMonto cargado:
											// <span>S/
											// '+floatFormat(monto)+"</span>"+
											// promotionMessage+"</p>");
											jAlert('<p style="text-align: justify;margin: 0px;">'
													+ 'Su recarga se ha realizado exitosamente \nSaldo cargado: <span style="font-weight: bold;">S/ '
													+ floatFormat(monto)
													+ "</span>"
													+ promotionMessage
													+ rptaTransaccion + "</p>");
										}

										var $formIzi = $("#form_recharge_izi"), $inputMonto = $formIzi
												.find('input[name="monto"]'), $inputCode = $formIzi
												.find('input[name="codigo"]'), $btRecharge = $formIzi
												.find('.button__base'), $divError = $formIzi
												.find('.form__alert_recharge'), $inputStatusCode = $formIzi
												.find('input[name="status_code"]'), $inputIdCode = $formIzi
												.find('input[name="id_code"]'), $btValidate = $formIzi
												.find('.button__outline'), $spanValid = $formIzi
												.find('.form__gift-valid');

										if ($.trim(actbono).includes(
												'true-casino')
												|| $.trim(actbono) == 'true'
												|| $.trim(actwbbono) == 'true') {
											$spanValid.fadeOut(150, function() {
												$btValidate.fadeIn(200);
												$btValidate.attr('code-sent',
														false)
												$btValidate.attr('disabled',
														false);

												$divError.html('');
												$formIzi.removeClass('error');
												$inputStatusCode.val('DES');
												$inputIdCode.val('-1');
											});
										} else {
											$divError.html('');
											$formIzi.removeClass('error');
											$inputStatusCode.val('DES');
											$inputIdCode.val('-1');
										}

										$inputMonto.val('');
										$inputCode.val('');
										$btRecharge.attr('disabled', true);
									}).fail(function() {
								$('body').find('#loading-recharge-1').remove();
							});
				} else if (state == "CLOSE") {
					console.log("close");
				} else if (state == "ERRORIZI") {
					var number = arrayData[2];
					var brand = arrayData[3];
					var card = arrayData[4];
					var uniqueIdentifier = arrayData[5];
					var monto = arrayData[6];
					var code = arrayData[7];
					var json_request = arrayData[8];
					var json_response = arrayData[9];

					var rechargetoken = $('#rechargetoken').val();
					var vheaders = {};
					if (rechargetoken != null && rechargetoken != "") {
						vheaders = {
							"rechargetoken" : $('#rechargetoken').val()
						};
					}

					$
							.ajax(
									{
										type : "POST",
										url : "errorIzipay.html",
										dataType : "json",
										headers : vheaders,
										async : false,
										data : "&uniqueIdentifier="
												+ uniqueIdentifier + "&number="
												+ number + "&brand=" + brand
												+ "&amount=" + monto + "&code="
												+ code + "&operatorId="
												+ $("#operatorIdApi").val()
												+ "&json_request="
												+ json_request
												+ "&json_response="
												+ json_response,
										beforeSend : function() {
											$('body')
													.append(
															'<div id="loading-recharge-1" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
										},
									})
							.done(
									function(data) {
										var fechaError = data.fecha;
										// if($("#operatorIdApi").val()!="5586"){
										// $('body').find('#loading-recharge-1').remove();
										// var msg = "\nNº Transacción:"+number;
										// msg += "\n"+brand+":"+card;
										// msg += "\n"+fechaError;
										// msg += "\n\nTu transacción ha sido
										// denegada, por favor intenta\n
										// nuevamente con otra tarjeta o
										// comunícate con tu\n banco";
										//    							
										// jAlert('<p style="text-align:
										// justify;margin: 0px;">'+msg+'</p>');
										// }else{
										$
												.ajax({
													type : "post",
													url : "registerCA.html",
													headers : vheaders,
													dataType : 'json',
													data : "&medio=EPAGO&code=400&description=Tarjeta no valida"
															+ "&monto="
															+ monto
															+ "&operatorId="
															+ $(
																	"#operatorIdApi")
																	.val(),
													success : function(data) {
														$('body')
																.find(
																		'#loading-recharge-1')
																.remove();
														if (data.ban != undefined
																&& data.ban == "OK") {
															localStorage
																	.setItem(
																			"ban",
																			"OK");
															$
																	.ajax({
																		type : "post",
																		url : "salirCA.html",
																		dataType : 'json',
																		success : function(
																				data) {
																			if ($(
																					"#operatorIdApi")
																					.val() != "5586") {
																				// location.replace(data.eCommerceHome);
																				// location.reload();
																				var ban = localStorage
																						.getItem("ban");
																				if (ban == "OK") {
																					localStorage
																							.removeItem("ban");
																					var msgError = '<div style="font-family: \'Roboto\';"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"><p style="text-align: center;margin: 0px;"><b>Detectamos una irregularidad en tu cuenta</b><br><br>Por tu seguridad y de acuerdo con lo establecido en los T&C tu cuenta está bloqueada temporalmente.</p></div><br><br>'
																							+ '<button class="button button-orange-light no-margin green" style="cursor: pointer; width: 50%;" onclick="closePopupCA(\'popup-message-session\')" type="button">OK</button></div>';
																					$(
																							'#msg-session')
																							.html(
																									msgError);
																					openModal(
																							"#popup-message-session",
																							"");
																				}
																			} else {
																				try {
																					window.parent
																							.postMessage(
																									'closeLightboxRecharge',
																									'*');
																				} catch (e) {
																				}
																			}
																		}
																	});
														} else {
															var msg = "\nNº Transacción:"
																	+ number;
															msg += "\n" + brand
																	+ ":"
																	+ card;
															msg += "\n"
																	+ fechaError;
															msg += "\n\nTu transacción ha sido denegada, por favor intenta\n nuevamente con otra tarjeta o comunícate con tu\n banco";

															jAlert('<p style="text-align: justify;margin: 0px;">'
																	+ msg
																	+ '</p>');
														}
													}
												});
										// }
									}).fail(function() {
								$('body').find('#loading-recharge-1').remove();
							});
				} else {
					jAlert('<p style="text-align: justify;margin: 0px;">¡Ocurrió un problema inesperado! Por favor inténtelo nuevamente.</p>');
				}
			} else {
				reiniciar();
			}
		} catch (e) {
			reiniciar();
		}
	} else {
		reiniciar();
	}
}

// init scripts
$(document).ready(function() {
	renderGridView();
	initIframes();
	renderFormFields();

	// $('#formBook').on('submit', registrarReclamacion(event));

	if (window.addEventListener) {
		window.addEventListener('message', handleMessage, false);
	} else if (window.attachEvent) { // ie8
		window.attachEvent('onmessage', handleMessage);
	}

});

function registrarReclamacion(form) {
	if ($("#formBook").valid()) {
		$
				.ajax({
					url : 'registrarReclamacion.html',
					data : $("#formBook").serialize(),
					type : 'POST',
					dataType : 'json',
					beforeSend : function() {
						$('body')
								.append('<div id="loader-frm-register"></div>');
					},
					error : function() {
						$('body').find('#loader-frm-register').remove();
						jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
					},
					success : function(data) {
						$('body').find('#loader-frm-register').remove();
						if (data.message === "OK") {
							$("#secuencia").val(data.secuencia);
							$("#fecha").val(data.fecha);
							form.submit();
						} else {
							jAlert(data.error);
						}
					}
				});
	}
}

function verificaRecargaTupay(channel) {
	var vurl = "yapePlinTupayVerifyTransactionAPI.html";
	var rechargetoken = $('#rechargetoken').val();
	var vheaders = {};
	if (rechargetoken != null && rechargetoken != "") {
		vheaders = {
			"rechargetoken" : $('#rechargetoken').val()
		};
	}
	$
			.ajax({
				type : "post",
				url : vurl,
				headers : vheaders,
				data : "channel=" + channel,
				dataType : "json",
				beforeSend : function() {
					$('body')
							.append(
									'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
				},
				error : function() {
					$('body').find('#loading-recharge').remove();
					$btRecharge.attr('disabled', false);
					jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
				},
				success : function(data) {
					var status = data.status;
					if (status == "ACT") {
						if (channel == "YAPE") {
							$("#divVerificaRecargaYapeTupay").css("display",
									"none");
						} else if (channel == "PLIN") {
							$("#divVerificaRecargaPlinTupay").css("display",
									"none");
						}

						var billetera1 = floatFormat(data.billetera1);
						var amount = floatFormat(data.amount);
						var mensaje = "Se ha realizado una recarga con éxito a tu saldo.";
						mensaje += '\n\nMonto cargado: S/ ' + amount;
						mensaje += '\nTu saldo disponible es: S/ ' + billetera1;

						$("#clientSale-amount").text(
								floatFormat(data.billetera1));
						$("#clientSale-amount-2").text(
								floatFormat(data.billetera1));
						$("#billetera2-amount").text(data.billetera2);
						$("#billetera3-amount").text(data.billetera3Cant);

						var promotionMessage = data.promotionMessage;
						if (promotionMessage == "" || promotionMessage == null
								|| promotionMessage == undefined) {
							jAlert('<p style="text-align: justify;margin: 0px;">'
									+ mensaje + "</p>");
						} else {
							jAlert('<p style="text-align: justify;margin: 0px;">'
									+ 'Se ha realizado una recarga con éxito a su saldo.<br><br>Monto cargado: <span>S/ '
									+ floatFormat(amount)
									+ "</span><br>"
									+ promotionMessage + "</p>");
						}
					} else if (status == "PEN") {
						jAlert(data.message);
					} else if (status == "ERROR") {
						jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
					} else if (status == 'TIMEOUTTR') {
						jAlert(timeoutTrMsg);
					} else {
						jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
					}
					$('body').find('#loading-recharge').remove();
				}
			});
}

function verificaRecargaPE(channel, type) {
	// recarga con sesion o con token
	var vurl = "yapePlinVerifyTransaction.html";
	var rechargetoken = $('#rechargetoken').val();
	var vheaders = {};
	if (rechargetoken != null && rechargetoken != "") {
		vurl = "yapePlinVerifyTransactionAPI.html";
		vheaders = {
			"rechargetoken" : $('#rechargetoken').val()
		};
	}
	$
			.ajax({
				type : "post",
				url : vurl,
				headers : vheaders,
				data : "channel=" + channel,
				dataType : "json",
				beforeSend : function() {
					$('body')
							.append(
									'<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
				},
				error : function() {
					$('body').find('#loading-recharge').remove();
					$btRecharge.attr('disabled', false);
					jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
				},
				success : function(data) {
					var status = data.status;
					if (status == "ACT") {
						if (channel == "YAPE") {
							$("#divVerificaRecargaYape").css("display", "none");
						} else if (channel == "PLIN") {
							$("#divVerificaRecargaPlin").css("display", "none");
						} else if (channel == "PEFE") {
							if (type == "1") {
								$("#divVerificaRecargaPEFE").css("display",
										"none");
							} else {
								$("#divVerificaRecargaPEFEE").css("display",
										"none");
							}
						}

						var billetera1 = floatFormat(data.billetera1);
						var amount = floatFormat(data.amount);
						var mensaje = "Se ha realizado una recarga con éxito a tu saldo.";
						mensaje += '\n\nMonto cargado: S/ ' + amount;
						mensaje += '\nTu saldo disponible es: S/ ' + billetera1;

						$("#clientSale-amount").text(
								floatFormat(data.billetera1));
						$("#clientSale-amount-2").text(
								floatFormat(data.billetera1));
						$("#billetera2-amount").text(data.billetera2);
						$("#billetera3-amount").text(data.billetera3Cant);

						var promotionMessage = data.promotionMessage;
						if (promotionMessage == "" || promotionMessage == null
								|| promotionMessage == undefined) {
							jAlert('<p style="text-align: justify;margin: 0px;">'
									+ mensaje + "</p>");
						} else {
							jAlert('<p style="text-align: justify;margin: 0px;">'
									+ 'Se ha realizado una recarga con éxito a su saldo.<br><br>Monto cargado: <span>S/ '
									+ floatFormat(amount)
									+ "</span><br>"
									+ promotionMessage + "</p>");
						}
					} else if (status == "PEN") {
						jAlert(data.message);
					} else if (status == "ERROR") {
						jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
					} else if (status == 'TIMEOUTTR') {
						jAlert(timeoutTrMsg);
					} else {
						jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
					}
					$('body').find('#loading-recharge').remove();
				}
			});
}

function loadRecharge() {
	$
			.ajax({
				type : "POST",
				url : "load_recharge.html",
				dataType : "json",
				async : false,
				success : function(data) {
					$("#clientSale-amount").text(floatFormat(data.billetera1));
					$("#clientSale-amount-2")
							.text(floatFormat(data.billetera1));
					$("#billetera2-amount").text(data.billetera2);
					$("#billetera3-amount").text(data.billetera3Cant);
					$("#maximoCodigosBCP").val(data.maximoCodigosBCP);

					var amtMinRechargeAgrFormateado = floatFormat(
							data.amtMinRechargeAgr).replace(".00", "");
					var amtMaxRechargeAgrFormateado = floatFormat(
							data.amtMaxRechargeAgr).replace(".00", "");
					$("#amtMinRechargeAgr").html(amtMinRechargeAgrFormateado);
					$("#amtMaxRechargeAgr").html(amtMaxRechargeAgrFormateado);
					$("#amtMinRechargeAgrP").html(amtMinRechargeAgrFormateado);
					$("#amtMaxRechargeAgrP").html(amtMaxRechargeAgrFormateado);
					$('#monto_agora').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargeAgr + ";"
									+ data.amtMaxRechargeAgr + "]");

					var amtMinRechargeVisaFormateado = floatFormat(
							data.amtMinRechargeVisa).replace(".00", "");
					var amtMaxRechargeVisaFormateado = floatFormat(
							data.amtMaxRechargeVisa).replace(".00", "");
					$("#amtMinRechargeVisa").html(amtMinRechargeVisaFormateado);
					$("#amtMaxRechargeVisa").html(amtMaxRechargeVisaFormateado);
					$("#amtMinRechargeVisaP")
							.html(amtMinRechargeVisaFormateado);
					$("#amtMaxRechargeVisaP")
							.html(amtMaxRechargeVisaFormateado);
					$('#monto_visanet').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargeVisa + ";"
									+ data.amtMaxRechargeVisa + "]");
					var maxAmtPerWeekVisaFormateado = floatFormat(
							data.maxAmtPerWeekVisa).replace(".00", "");
					if (data.maxAmtPerWeekVisa != undefined
							&& data.maxAmtPerWeekVisa > 0) {
						// $("#amtMaxRechargeWeekVisa").html(maxAmtPerWeekVisaFormateado);
						$("#amtMaxRechargeWeekVisa").html(
								". Recarga máxima semanal S/ "
										+ maxAmtPerWeekVisaFormateado + ".");
					}
					if (data.maxRechargePerDayVisa != undefined
							&& data.maxRechargePerDayVisa > 0) {
						// $("#maxRechargeVisa").html(data.maxRechargePerDayVisa);
						$("#maxRechargeVisa").html(
								" hasta en " + data.maxRechargePerDayVisa
										+ " transacciones diarias");
					}

					var amtMinRechargeBcpFormateado = floatFormat(
							data.amtMinRechargeBcp).replace(".00", "");
					var amtMaxRechargeBcpFormateado = floatFormat(
							data.amtMaxRechargeBcp).replace(".00", "");
					$("#minAmountBCP").html(amtMinRechargeBcpFormateado);
					$("#maxAmountBCP").html(amtMaxRechargeBcpFormateado);
					$("#minAmountBCPP").html(amtMinRechargeBcpFormateado);
					$("#maxAmountBCPP").html(amtMaxRechargeBcpFormateado);
					$('#monto_bcp').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargeBcp + ";"
									+ data.amtMaxRechargeBcp + "]");

					var stateRechargeVisa = data.stateRechargeVisa;
					if (stateRechargeVisa != undefined
							&& stateRechargeVisa == 'ACTIVO') {
						$("#tabInternetVisanet").css('display', 'flex');
					}

					var stateRechargeAgr = data.stateRechargeAgr;
					if (stateRechargeAgr != undefined
							&& stateRechargeAgr == 'ACTIVO') {
						$("#tabInternetAgora").css('display', 'flex');
					}

					var stateRechargeIbk = data.stateRechargeIbk;
					if (stateRechargeIbk != undefined
							&& stateRechargeIbk == 'ACTIVO') {
						$("#tabInternetInterbank").css('display', 'flex');
						$("#tabEfectivoInterbank").css('display', 'flex');
					}

					var stateRechargeBcp = data.stateRechargeBcp;
					if (stateRechargeBcp != undefined
							&& stateRechargeBcp == 'ACTIVO') {
						$("#tabInternetBCP").css('display', 'flex');
					}

					var stateRechargePefe = data.stateRechargePefe;
					if (stateRechargePefe != undefined
							&& stateRechargePefe == 'ACTIVO') {
						$("#tabInternetPagoEfectivo").css('display', 'flex');
						$("#tabEfectivoPagoEfectivo").css('display', 'flex');
					}

					var stateRechargeSpay = data.stateRechargeSpay;
					if (stateRechargeSpay != undefined
							&& stateRechargeSpay == 'ACTIVO') {
						$("#tabInternetSafetyPay").css('display', 'flex');
						$("#tabEfectivoSafetyPay").css('display', 'flex');
					}

					var stateRechargeLoto = data.stateRechargeLoto;
					if (stateRechargeLoto != undefined
							&& stateRechargeLoto == 'ACTIVO') {
						$("#tabEfectivoLotocard").css('display', 'flex');
					}

					var stateRechargeYape = data.stateRechargeYape;
					if (stateRechargeYape != undefined
							&& stateRechargeYape == 'ACTIVO') {
						$("#tabInternetYape").css('display', 'flex');
					}

					var stateRechargePlin = data.stateRechargePlin;
					if (stateRechargePlin != undefined
							&& stateRechargePlin == 'ACTIVO') {
						$("#tabInternetPlin").css('display', 'flex');
					}

					var stateRechargeIzi = data.stateRechargeIzi;
					if (stateRechargeIzi != undefined
							&& stateRechargeIzi == 'ACTIVO') {
						$("#tabInternetIzi").css('display', 'flex');
					}

					var amtMinRechargeIbkFormateado = floatFormat(
							data.amtMinRechargeIbk).replace(".00", "");
					var amtMaxRechargeIbkFormateado = floatFormat(
							data.amtMaxRechargeIbk).replace(".00", "");
					$("#amtMinRechargeIbk").html(amtMinRechargeIbkFormateado);
					$("#amtMaxRechargeIbk").html(amtMaxRechargeIbkFormateado);
					$("#amtMinRechargeIbkE").html(amtMinRechargeIbkFormateado);
					$("#amtMaxRechargeIbkE").html(amtMaxRechargeIbkFormateado);
					$("#amtMinRechargeIbkP").html(amtMinRechargeIbkFormateado);
					$("#amtMaxRechargeIbkP").html(amtMaxRechargeIbkFormateado);
					$("#amtMinRechargeIbkPE").html(amtMinRechargeIbkFormateado);
					$("#amtMaxRechargeIbkPE").html(amtMaxRechargeIbkFormateado);

					var amtMinRechargePefeFormateado = floatFormat(
							data.amtMinRechargePefe).replace(".00", "");
					var amtMaxRechargePefeFormateado = floatFormat(
							data.amtMaxRechargePefe).replace(".00", "");
					$("#amtMinRechargePefe").html(amtMinRechargePefeFormateado);
					$("#amtMaxRechargePefe").html(amtMaxRechargePefeFormateado);
					$("#amtMinRechargePefeE")
							.html(amtMinRechargePefeFormateado);
					$("#amtMaxRechargePefeE")
							.html(amtMaxRechargePefeFormateado);
					$("#amtMinRechargePefeP")
							.html(amtMinRechargePefeFormateado);
					$("#amtMaxRechargePefeP")
							.html(amtMaxRechargePefeFormateado);
					$("#amtMinRechargePefePE").html(
							amtMinRechargePefeFormateado);
					$("#amtMaxRechargePefePE").html(
							amtMaxRechargePefeFormateado);
					$('#monto_pagoefectivo').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargePefe + ";"
									+ data.amtMaxRechargePefe + "]");
					$('#monto_pagoefectivo_efectivo').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargePefe + ";"
									+ data.amtMaxRechargePefe + "]");

					var amtMinRechargeSpayFormateado = floatFormat(
							data.amtMinRechargeSpay).replace(".00", "");
					var amtMaxRechargeSpayFormateado = floatFormat(
							data.amtMaxRechargeSpay).replace(".00", "");
					$("#amtMinRechargeSpay").html(amtMinRechargeSpayFormateado);
					$("#amtMaxRechargeSpay").html(amtMaxRechargeSpayFormateado);
					$("#amtMinRechargeSpayE")
							.html(amtMinRechargeSpayFormateado);
					$("#amtMaxRechargeSpayE")
							.html(amtMaxRechargeSpayFormateado);
					$("#amtMinRechargeSpayP")
							.html(amtMinRechargeSpayFormateado);
					$("#amtMaxRechargeSpayP")
							.html(amtMaxRechargeSpayFormateado);
					$("#amtMinRechargeSpayPE").html(
							amtMinRechargeSpayFormateado);
					$("#amtMaxRechargeSpayPE").html(
							amtMaxRechargeSpayFormateado);
					$('#monto_safetypay').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargeSpay + ";"
									+ data.amtMaxRechargeSpay + "]");
					$('#monto_safetypay_efectivo').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargeSpay + ";"
									+ data.amtMaxRechargeSpay + "]");

					$('#num_agora').html(data.mobilePhone);
					$('#num_agora_confirmado').html(data.mobilePhone);

					var amtMinRechargeYapeFormateado = floatFormat(
							data.amtMinRechargeYape).replace(".00", "");
					var amtMaxRechargeYapeFormateado = floatFormat(
							data.amtMaxRechargeYape).replace(".00", "");
					$("#amtMinRechargeYape").html(amtMinRechargeYapeFormateado);
					$("#amtMaxRechargeYape").html(amtMaxRechargeYapeFormateado);
					$("#amtMinRechargeYapeP")
							.html(amtMinRechargeYapeFormateado);
					$("#amtMaxRechargeYapeP")
							.html(amtMaxRechargeYapeFormateado);
					$('#monto_yape').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargeYape + ";"
									+ data.amtMaxRechargeYape + "]");

					var amtMinRechargePlinFormateado = floatFormat(
							data.amtMinRechargePlin).replace(".00", "");
					var amtMaxRechargePlinFormateado = floatFormat(
							data.amtMaxRechargePlin).replace(".00", "");
					$("#amtMinRechargePlin").html(amtMinRechargePlinFormateado);
					$("#amtMaxRechargePlin").html(amtMaxRechargePlinFormateado);
					$("#amtMinRechargePlinP")
							.html(amtMinRechargePlinFormateado);
					$("#amtMaxRechargePlinP")
							.html(amtMaxRechargePlinFormateado);
					$('#monto_plin').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargePlin + ";"
									+ data.amtMaxRechargePlin + "]");

					var amtMinRechargeIziFormateado = floatFormat(
							data.amtMinRechargeIzi).replace(".00", "");
					var amtMaxRechargeIziFormateado = floatFormat(
							data.amtMaxRechargeIzi).replace(".00", "");
					$("#amtMinRechargeIzi").html(amtMinRechargeIziFormateado);
					$("#amtMaxRechargeIzi").html(amtMaxRechargeIziFormateado);
					$("#amtMinRechargeIziP").html(amtMinRechargeIziFormateado);
					$("#amtMaxRechargeIziP").html(amtMaxRechargeIziFormateado);
					$('#monto_izi').attr(
							"data-validation-allowing",
							"range[" + data.amtMinRechargeIzi + ";"
									+ data.amtMaxRechargeIzi + "]");

					if (data.rechargeAgora != undefined) {
						if (data.rechargeAgora == '0') {
							$("#seccion_agora_xconfirmar").css('display',
									'block');
						} else {
							$("#seccion_agora_confirmada").css('display',
									'block');
						}
					}

					configLoaded = data;
				}
			});
}

function loadRechargeAPI(rstatus) {
	$.ajax({
		type : "POST",
		url : "load_recharge_api.html",
		headers : {
			'rechargetoken' : $('#rechargetoken').val()
		},
		data : {
			'rstatus' : rstatus
		},
		dataType : "json",
		async : false,
		success : function(data) {
			if (data.status == 'OK') {
				$("#clientSale-amount").text(floatFormat(data.billetera1));
				$("#clientSale-amount-2").text(floatFormat(data.billetera1));
				$("#billetera2-amount").text(data.billetera2);
				$("#billetera3-amount").text(data.billetera3);
				$("#maximoCodigosBCP").val(data.maximoCodigosBCP);

				var amtMinRechargeAgrFormateado = floatFormat(
						data.amtMinRechargeAgr).replace(".00", "");
				var amtMaxRechargeAgrFormateado = floatFormat(
						data.amtMaxRechargeAgr).replace(".00", "");
				$("#amtMinRechargeAgr").html(amtMinRechargeAgrFormateado);
				$("#amtMaxRechargeAgr").html(amtMaxRechargeAgrFormateado);
				$("#amtMinRechargeAgrP").html(amtMinRechargeAgrFormateado);
				$("#amtMaxRechargeAgrP").html(amtMaxRechargeAgrFormateado);
				$('#monto_agora').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeAgr + ";"
								+ data.amtMaxRechargeAgr + "]");

				var amtMinRechargeVisaFormateado = floatFormat(
						data.amtMinRechargeVisa).replace(".00", "");
				var amtMaxRechargeVisaFormateado = floatFormat(
						data.amtMaxRechargeVisa).replace(".00", "");
				$("#amtMinRechargeVisa").html(amtMinRechargeVisaFormateado);
				$("#amtMaxRechargeVisa").html(amtMaxRechargeVisaFormateado);
				$("#amtMinRechargeVisaP").html(amtMinRechargeVisaFormateado);
				$("#amtMaxRechargeVisaP").html(amtMaxRechargeVisaFormateado);
				$('#monto_visanet').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeVisa + ";"
								+ data.amtMaxRechargeVisa + "]");
				var maxAmtPerWeekVisaFormateado = floatFormat(
						data.maxAmtPerWeekVisa).replace(".00", "");
				if (data.maxAmtPerWeekVisa != undefined
						&& data.maxAmtPerWeekVisa > 0) {
					// $("#amtMaxRechargeWeekVisa").html(maxAmtPerWeekVisaFormateado);
					$("#amtMaxRechargeWeekVisa").html(
							". Recarga máxima semanal S/ "
									+ maxAmtPerWeekVisaFormateado + ".");
				}
				if (data.maxRechargePerDayVisa != undefined
						&& data.maxRechargePerDayVisa > 0) {
					// $("#maxRechargeVisa").html(data.maxRechargePerDayVisa);
					$("#maxRechargeVisa").html(
							" hasta en " + data.maxRechargePerDayVisa
									+ " transacciones diarias");
				}

				var amtMinRechargeBcpFormateado = floatFormat(
						data.amtMinRechargeBcp).replace(".00", "");
				var amtMaxRechargeBcpFormateado = floatFormat(
						data.amtMaxRechargeBcp).replace(".00", "");
				$("#minAmountBCP").html(amtMinRechargeBcpFormateado);
				$("#maxAmountBCP").html(amtMaxRechargeBcpFormateado);
				$("#minAmountBCPP").html(amtMinRechargeBcpFormateado);
				$("#maxAmountBCPP").html(amtMaxRechargeBcpFormateado);
				$('#monto_bcp').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeBcp + ";"
								+ data.amtMaxRechargeBcp + "]");

				var stateRechargeVisa = data.stateRechargeVisa;
				if (stateRechargeVisa != undefined
						&& stateRechargeVisa == 'ACTIVO') {
					$("#tabInternetVisanet").css('display', 'flex');
				}

				var stateRechargeAgr = data.stateRechargeAgr;
				if (stateRechargeAgr != undefined
						&& stateRechargeAgr == 'ACTIVO') {
					$("#tabInternetAgora").css('display', 'flex');
				}

				var stateRechargeIbk = data.stateRechargeIbk;
				if (stateRechargeIbk != undefined
						&& stateRechargeIbk == 'ACTIVO') {
					$("#tabInternetInterbank").css('display', 'flex');
					$("#tabEfectivoInterbank").css('display', 'flex');
				}

				var stateRechargeBcp = data.stateRechargeBcp;
				if (stateRechargeBcp != undefined
						&& stateRechargeBcp == 'ACTIVO') {
					$("#tabInternetBCP").css('display', 'flex');
				}

				var stateRechargePefe = data.stateRechargePefe;
				if (stateRechargePefe != undefined
						&& stateRechargePefe == 'ACTIVO') {
					$("#tabInternetPagoEfectivo").css('display', 'flex');
					$("#tabEfectivoPagoEfectivo").css('display', 'flex');
				}

				var stateRechargeSpay = data.stateRechargeSpay;
				if (stateRechargeSpay != undefined
						&& stateRechargeSpay == 'ACTIVO') {
					$("#tabInternetSafetyPay").css('display', 'flex');
					$("#tabEfectivoSafetyPay").css('display', 'flex');
				}

				var stateRechargeLoto = data.stateRechargeLoto;
				if (stateRechargeLoto != undefined
						&& stateRechargeLoto == 'ACTIVO') {
					$("#tabEfectivoLotocard").css('display', 'flex');
				}

				var stateRechargeYape = data.stateRechargeYape;
				if (stateRechargeYape != undefined
						&& stateRechargeYape == 'ACTIVO') {
					$("#tabInternetYape").css('display', 'flex');
				}

				var stateRechargePlin = data.stateRechargePlin;
				if (stateRechargePlin != undefined
						&& stateRechargePlin == 'ACTIVO') {
					$("#tabInternetPlin").css('display', 'flex');
				}

				var stateRechargeIzi = data.stateRechargeIzi;
				if (stateRechargeIzi != undefined
						&& stateRechargeIzi == 'ACTIVO') {
					$("#tabInternetIzi").css('display', 'flex');
				}

				var stateRechargePlinTupay = data.stateRechargePlinTupay;
				if (stateRechargePlinTupay != undefined
						&& stateRechargePlinTupay == 'ACTIVO') {
					$("#tabInternetPlinTupay").css('display', 'flex');
				}

				var stateRechargeYapeTupay = data.stateRechargeYapeTupay;
				if (stateRechargeYapeTupay != undefined
						&& stateRechargeYapeTupay == 'ACTIVO') {
					$("#tabInternetYapeTupay").css('display', 'flex');
				}

				var amtMinRechargeIbkFormateado = floatFormat(
						data.amtMinRechargeIbk).replace(".00", "");
				var amtMaxRechargeIbkFormateado = floatFormat(
						data.amtMaxRechargeIbk).replace(".00", "");
				$("#amtMinRechargeIbk").html(amtMinRechargeIbkFormateado);
				$("#amtMaxRechargeIbk").html(amtMaxRechargeIbkFormateado);
				$("#amtMinRechargeIbkE").html(amtMinRechargeIbkFormateado);
				$("#amtMaxRechargeIbkE").html(amtMaxRechargeIbkFormateado);
				$("#amtMinRechargeIbkP").html(amtMinRechargeIbkFormateado);
				$("#amtMaxRechargeIbkP").html(amtMaxRechargeIbkFormateado);
				$("#amtMinRechargeIbkPE").html(amtMinRechargeIbkFormateado);
				$("#amtMaxRechargeIbkPE").html(amtMaxRechargeIbkFormateado);

				var amtMinRechargePefeFormateado = floatFormat(
						data.amtMinRechargePefe).replace(".00", "");
				var amtMaxRechargePefeFormateado = floatFormat(
						data.amtMaxRechargePefe).replace(".00", "");
				$("#amtMinRechargePefe").html(amtMinRechargePefeFormateado);
				$("#amtMaxRechargePefe").html(amtMaxRechargePefeFormateado);
				$("#amtMinRechargePefeE").html(amtMinRechargePefeFormateado);
				$("#amtMaxRechargePefeE").html(amtMaxRechargePefeFormateado);
				$("#amtMinRechargePefeP").html(amtMinRechargePefeFormateado);
				$("#amtMaxRechargePefeP").html(amtMaxRechargePefeFormateado);
				$("#amtMinRechargePefePE").html(amtMinRechargePefeFormateado);
				$("#amtMaxRechargePefePE").html(amtMaxRechargePefeFormateado);
				$('#monto_pagoefectivo').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargePefe + ";"
								+ data.amtMaxRechargePefe + "]");
				$('#monto_pagoefectivo_efectivo').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargePefe + ";"
								+ data.amtMaxRechargePefe + "]");

				var amtMinRechargeSpayFormateado = floatFormat(
						data.amtMinRechargeSpay).replace(".00", "");
				var amtMaxRechargeSpayFormateado = floatFormat(
						data.amtMaxRechargeSpay).replace(".00", "");
				$("#amtMinRechargeSpay").html(amtMinRechargeSpayFormateado);
				$("#amtMaxRechargeSpay").html(amtMaxRechargeSpayFormateado);
				$("#amtMinRechargeSpayE").html(amtMinRechargeSpayFormateado);
				$("#amtMaxRechargeSpayE").html(amtMaxRechargeSpayFormateado);
				$("#amtMinRechargeSpayP").html(amtMinRechargeSpayFormateado);
				$("#amtMaxRechargeSpayP").html(amtMaxRechargeSpayFormateado);
				$("#amtMinRechargeSpayPE").html(amtMinRechargeSpayFormateado);
				$("#amtMaxRechargeSpayPE").html(amtMaxRechargeSpayFormateado);
				$('#monto_safetypay').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeSpay + ";"
								+ data.amtMaxRechargeSpay + "]");
				$('#monto_safetypay_efectivo').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeSpay + ";"
								+ data.amtMaxRechargeSpay + "]");

				$('#num_agora').html(data.mobilePhone);
				$('#num_agora_confirmado').html(data.mobilePhone);
				$('#mobilePhone').val(data.mobilePhone);

				var amtMinRechargeYapeFormateado = floatFormat(
						data.amtMinRechargeYape).replace(".00", "");
				var amtMaxRechargeYapeFormateado = floatFormat(
						data.amtMaxRechargeYape).replace(".00", "");
				$("#amtMinRechargeYape").html(amtMinRechargeYapeFormateado);
				$("#amtMaxRechargeYape").html(amtMaxRechargeYapeFormateado);
				$("#amtMinRechargeYapeP").html(amtMinRechargeYapeFormateado);
				$("#amtMaxRechargeYapeP").html(amtMaxRechargeYapeFormateado);
				$('#monto_yape').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeYape + ";"
								+ data.amtMaxRechargeYape + "]");

				var amtMinRechargePlinFormateado = floatFormat(
						data.amtMinRechargePlin).replace(".00", "");
				var amtMaxRechargePlinFormateado = floatFormat(
						data.amtMaxRechargePlin).replace(".00", "");
				$("#amtMinRechargePlin").html(amtMinRechargePlinFormateado);
				$("#amtMaxRechargePlin").html(amtMaxRechargePlinFormateado);
				$("#amtMinRechargePlinP").html(amtMinRechargePlinFormateado);
				$("#amtMaxRechargePlinP").html(amtMaxRechargePlinFormateado);
				$('#monto_plin').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargePlin + ";"
								+ data.amtMaxRechargePlin + "]");

				$('#rechargetoken').val(data.rechargetoken);
				$('#operatorIdApi').val(data.operatorIdApi);

				var stateRechargeBbva = data.stateRechargeBbva;
				if (stateRechargeBbva != undefined
						&& stateRechargeBbva == 'ACTIVO') {
					$("#tabInternetBBVA").css('display', 'flex');
				}
				var amtMinRechargeBbvaFormateado = floatFormat(
						data.amtMinRechargeBbva).replace(".00", "");
				var amtMaxRechargeBbvaFormateado = floatFormat(
						data.amtMaxRechargeBbva).replace(".00", "");
				$("#minAmountBBVA").html(amtMinRechargeBbvaFormateado);
				$("#maxAmountBBVA").html(amtMaxRechargeBbvaFormateado);
				$("#minAmountBBVAA").html(amtMinRechargeBbvaFormateado);
				$("#maxAmountBBVAA").html(amtMaxRechargeBbvaFormateado);
				$('#monto_bbva').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeBbva + ";"
								+ data.amtMaxRechargeBbva + "]");
				$("#maximoCodigosBBVA").val(data.maximoCodigosBBVA);

				var amtMinRechargeIziFormateado = floatFormat(
						data.amtMinRechargeIzi).replace(".00", "");
				var amtMaxRechargeIziFormateado = floatFormat(
						data.amtMaxRechargeIzi).replace(".00", "");
				$("#amtMinRechargeIzi").html(amtMinRechargeIziFormateado);
				$("#amtMaxRechargeIzi").html(amtMaxRechargeIziFormateado);
				$("#amtMinRechargeIziP").html(amtMinRechargeIziFormateado);
				$("#amtMaxRechargeIziP").html(amtMaxRechargeIziFormateado);
				$('#monto_izi').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeIzi + ";"
								+ data.amtMaxRechargeIzi + "]");

				var amtMinRechargePlinTupayFormateado = floatFormat(
						data.amtMinRechargePlinTupay).replace(".00", "");
				var amtMaxRechargePlinTupayFormateado = floatFormat(
						data.amtMaxRechargePlinTupay).replace(".00", "");
				$("#amtMinRechargePlinTupay").html(
						amtMinRechargePlinTupayFormateado);
				$("#amtMaxRechargePlinTupay").html(
						amtMaxRechargePlinTupayFormateado);
				$("#amtMinRechargePlinTupayP").html(
						amtMinRechargePlinTupayFormateado);
				$("#amtMaxRechargePlinTupayP").html(
						amtMaxRechargePlinTupayFormateado);
				$('#monto_PlinTupay').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargePlinTupay + ";"
								+ data.amtMaxRechargePlinTupay + "]");

				var amtMinRechargeYapeTupayFormateado = floatFormat(
						data.amtMinRechargeYapeTupay).replace(".00", "");
				var amtMaxRechargeYapeTupayFormateado = floatFormat(
						data.amtMaxRechargeYapeTupay).replace(".00", "");
				$("#amtMinRechargeYapeTupay").html(
						amtMinRechargeYapeTupayFormateado);
				$("#amtMaxRechargeYapeTupay").html(
						amtMaxRechargeYapeTupayFormateado);
				$("#amtMinRechargeYapeTupayP").html(
						amtMinRechargeYapeTupayFormateado);
				$("#amtMaxRechargeYapeTupayP").html(
						amtMaxRechargeYapeTupayFormateado);
				$('#monto_YapeTupay').attr(
						"data-validation-allowing",
						"range[" + data.amtMinRechargeYapeTupay + ";"
								+ data.amtMaxRechargeYapeTupay + "]");

				if (data.rechargeAgora != undefined) {
					if (data.rechargeAgora == '0') {
						$("#seccion_agora_xconfirmar").css('display', 'block');
					} else {
						$("#seccion_agora_confirmada").css('display', 'block');
					}
				}

				$("#full-name").val(data.nombre);
				$("#last-name").val(data.apellidos);
				$("#docTypeIzi").val(data.docTypeIzi);
				$("#docNumber").val(data.docNumber);
				$("#cid").val(data.cid);

				configLoaded = data;
			} else {
				var mensaje = data.message;
				console.log("error: " + mensaje);
				if (mensaje == 'TIMEOUTTR') {
					jAlert(timeouTrtMsg);
				}
			}
		}
	});
}

$('#footer-term').on(
		'click',
		function(event) {
			dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones.html',
					'TÉRMINOS Y CONDICIONES',
					'width=606,height=460,scrolling=1,center=1,resize=0',
					'recal');
		});

/*
 * Check Browser - Inicio
 */
function isIE() {
	// Internet Explorer 6-11
	var testIE = /* @cc_on!@ */false || !!document.documentMode;
	return testIE;
}

function isEdge() {
	// Internet Explorer 6-11
	var testIE = /* @cc_on!@ */false || !!document.documentMode;

	// Edge 20+
	var testEdge = !testIE && !!window.StyleMedia;
	return testEdge;
}
/*
 * Check Browser - Fin
 */

function tagginViewActivar() {
	window.dataLayer = window.dataLayer || [];
	dataLayer.push({
		'event' : 'virtualPageView',
		'pageTitle' : 'Activa tu cuenta',
		'pageUrl' : '/registro/activar/'

	});

	var tag = "virtualPageView";
	console.log("Taggin event: " + tag);
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

function tagginVAError() {
	// alert('evento tagginVAError');
	window.dataLayer = window.dataLayer || [];
	dataLayer.push({
		'event' : 'errorCodigo',
		'category' : 'Form :: Registrate',
		'action' : 'Paso2 :: Error',
		'label' : 'Codigo incorrecto'
	});

	var tag = "errorCodigo";
	console.log("Taggin event: " + tag);

}

function tagginVAOnResendCode() {
	window.dataLayer = window.dataLayer || [];
	dataLayer.push({
		'event' : 'virtualPageView',
		'pageTitle' : 'Reenviar SMS',
		'pageUrl' : '/registro/activar/reenvio_sms/',
		'category' : 'Form :: Registrate',
		'action' : 'Reenvio SMS',
		'label' : 'Activa tu cuenta'
	});

	var tag = "virtualPageView";
	console.log("Taggin event: " + tag);

}

function tagginVAActivated() {
	window.dataLayer = window.dataLayer || [];
	dataLayer.push({
		'event' : 'virtualPageView',
		'pageTitle' : 'Felicitaciones Cuenta Activada',
		'pageUrl' : '/registro/cuenta-activada/'
	});

	var tag = "virtualPageView";
	console.log("Taggin event: " + tag);
}

function getComisionVisa(monto) {
	var comision = 0;
	if (monto >= configLoaded.comMinRan1Visa
			&& monto <= configLoaded.comMaxRan1Visa) {
		comision = configLoaded.comAmtRan1Visa;
	} else if (monto >= configLoaded.comMinRan2Visa
			&& monto <= configLoaded.comMaxRan2Visa) {
		comision = configLoaded.comAmtRan2Visa;
	} else if (monto >= configLoaded.comMinRan3Visa
			&& monto <= configLoaded.comMaxRan3Visa) {
		comision = configLoaded.comAmtRan3Visa;
	} else if (monto >= configLoaded.comMinRan4Visa
			&& monto <= configLoaded.comMaxRan4Visa) {
		comision = configLoaded.comAmtRan4Visa;
	}
	return comision;
}

function getComisionAgora(monto) {
	var comision = 0;
	if (monto >= configLoaded.comMinRan1Agr
			&& monto <= configLoaded.comMaxRan1Agr) {
		comision = configLoaded.comAmtRan1Agr;
	} else if (monto >= configLoaded.comMinRan2Agr
			&& monto <= configLoaded.comMaxRan2Agr) {
		comision = configLoaded.comAmtRan2Agr;
	} else if (monto >= configLoaded.comMinRan3Agr
			&& monto <= configLoaded.comMaxRan3Agr) {
		comision = configLoaded.comAmtRan3Agr;
	} else if (monto >= configLoaded.comMinRan4Agr
			&& monto <= configLoaded.comMaxRan4Agr) {
		comision = configLoaded.comAmtRan4Agr;
	}
	return comision;
}

function actualizarCelular() {
	$("#divCelularAgora").css('display', 'block');
	$("#pInfoAgoraOk").css('display', 'none');
	actualizarCelularAgora = 1;
	datalayerActualizarNumTelf();
}

function recargaAgora2() {
	if (actualizarCelularAgora == -1
			|| (actualizarCelularAgora == 1 && $("#form_recharge_agora_2")
					.isValid({}, {}, false))) {
		$("#btnRecargaAgora").trigger('click');
	}
}
/**
 * Render form: Form Derechos Arco
 */
var renderRegisterFormDerechosArco = function() {
	var validateInputReg, validateInputReg2, validateInputReg3, validateInputReg4;

	// render fields
	renderDocumentFieldsDA();
	renderDocumentFieldsLegal();
	renderTermsFieldDA();

	// restrict fields
	// $('#name,
	// #ap-paterno').alpha({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
	// $('#user-client, #document-number-pasap,
	// #document-number-carex,#document-number-pasap-legal,
	// #document-number-carex-legal').alphanum({allowSpace: false,
	// disallow:'``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
	// $('#email').alphanum({allowSpace: false, allow : '-_+@.'});
	$("#mobile-phone, #document-number,#document-number-legal").numeric({
		allowThouSep : false,
		allowDecSep : false,
		allowMinus : false
	});
	$('#fechanac').alphanum({
		allow : '/',
		allowUpper : false,
		allowLower : false
	});

	$('#fechanac').mask('00/00/0000');

	// $('#domicilio').alphanum({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©',
	// allow : '#.,-'});

	validateInputReg = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ\s]/g,
				'');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$('#name, #ap-paterno').on('input', validateInputReg);

	validateInputReg2 = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue.replace(/[^a-zA-Z\d]/g, '');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$(
			'#user-client, #document-number-pasap, #document-number-carex, #document-number-pasap-legal, #document-number-carex-legal')
			.on('input', validateInputReg2);

	validateInputReg3 = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue.replace(/[^a-zA-Z\d-_+@.]/g, '');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$('#email').on('input', validateInputReg3);

	validateInputReg4 = function() {
		// Obtiene el valor actual del campo
		var inputValue = $(this).val();

		// Elimina caracteres no permitidos
		inputValue = inputValue
				.replace(/[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\s#°.,-\d]/g, '');

		// Actualiza el valor del campo
		$(this).val(inputValue);
	};
	$('#domicilio').on('input', validateInputReg4);

	// validate fields
	$
			.validate({
				form : '#frm-enviar-derechos-arco',
				modules : 'security, date, logic',
				scrollToTopOnError : false,
				onModulesLoaded : function() {
					var config = {
						bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Agrega letras, números y símbolos ($%&+!@).</span>',
						weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Agrega letras, números y símbolos ($%&+!@).</span>',
						good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
						strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
					};
					$('#password-client').displayPasswordStrength(config);
				},
				onElementValidate : function(valid, $el, $form) {
					if ($form.isValid({}, {}, false)) {
						$('#btsubmit').attr('disabled', false);
					} else {
						$('#btsubmit').attr('disabled', true);
					}
				},
				onError : function($form) {
					var $error = $form.find('.has-error');
					if ($error.length > 0) {
						$error = $error.first();
						$('html, body').animate({
							scrollTop : $error.offset().top - 16
						});
					}
				},
				onSuccess : function() {
					// submitRegisterFormDA();
					return false;
				}
			});
};

/**
 * Render Tipo documento feature
 */
var renderDocumentFieldsDA = function() {
	var $select = $('#document-type'), $fields = $('.form__optional'), onChangeDocument;

	onChangeDocument = function() {
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

var renderTermsFieldDA = function() {
	var $input = $('#solicitud_f'), $form = $('#frm-enviar-derechos-arco'), onChangeTerms, onChangeFechaNac;

	var $name = $('#name');
	var $appaterno = $('#ap-paterno');
	var $user = $('#usuario');
	var $documentnumber = $('#document-number');
	var $documentopasap = $('#document-number-pasap');
	var $documentocarex = $('#document-number-carex');
	var $documentnumberlegal = $('#document-number-legal');
	var $documentopasaplegal = $('#document-number-pasap-legal');
	var $documentocarexlegal = $('#document-number-carex-legal');
	var $razonsolicitud = $('#razon_solicitud_pd');
	var $domicilio = $('#domicilio');
	var $email = $('#email');
	var $mobilephone = $('#mobile-phone');

	onChangeTerms = function() {
		if ($form.isValid({}, {}, false)) {
			$('#btsubmit').attr('disabled', false);
		} else {
			$('#btsubmit').attr('disabled', true);
		}
	};

	$input.on('change', onChangeTerms);

	$name.on('keyup', onChangeTerms);
	$appaterno.on('keyup', onChangeTerms);
	$documentnumber.on('keyup', onChangeTerms);
	$documentopasap.on('keyup', onChangeTerms);
	$documentocarex.on('keyup', onChangeTerms);
	$documentnumberlegal.on('keyup', onChangeTerms);
	$documentopasaplegal.on('keyup', onChangeTerms);
	$documentocarexlegal.on('keyup', onChangeTerms);
	$user.on('keyup', onChangeTerms);
	$email.on('keyup', onChangeTerms);
	$mobilephone.on('keyup', onChangeTerms);
	$razonsolicitud.on('keyup', onChangeTerms);
	$domicilio.on('keyup', onChangeTerms);
};

/**
 * Send data to register user
 */
// var submitRegisterFormDA = function () {
// var $form = $('#frm-enviar-derechos-arco'),
// $button = $('#btsubmit'),
// urlRegister = $form.attr('action');
// $button.attr('disabled', true);
// };
var documentNumber = '';
// validacion de n° de documento
$("#document-number").keyup(
		function() {
			if ($("#document-number").val() != documentNumber) {
				if ($("#document-number").val().length == 8
						&& $('#name').length > 0) {
					validarDocumento($("#document-type option:selected").val(),
							$("#document-number").val());
				}
				if ($("#document-number").val().length == 8) {
					var docType = $("#document-type option:selected").val(); 
					var document = $("#document-number").val();
					var birthDate = $("#fechanac").val();
					var names = $("#name").val();
					var surnames = $("#ap-paterno").val();

					validarDocumentoReniec(docType, document, birthDate,
							names, surnames);
				} else {
					$('#document_number_msg').text(
							"ESTE DATO SERÁ USADO COMO TU USUARIO");
					$('#document_number_msg').css("color", "#07663a");
					$('#divNumberDoc').css("border", "1px solid #666666");
					$('#divNumberDoc label').css("color", "#666666");
				}		
			}
			documentNumber = $("#document-number").val();
		});

var documentNumberPasap = '';
$("#document-number-pasap").keyup(
		function() {
			if ($("#document-number-pasap").val() != documentNumberPasap) {
				if ($("#document-number-pasap").val().length >= 9
						&& $("#document-number-pasap").val().length <= 12
						&& $('#name').length > 0) { 
					validarDocumento($("#document-type option:selected").val(),
							$("#document-number-pasap").val());
				}if ($("#document-number-pasap").val().length >= 9 && $("#name").val().length >= 0 && $("#fechanac").val().length >= 8 && $("#ap-paterno").val().length >= 0) {
					var docType = $("#document-type option:selected").val(); 
					var document = $("#document-number-pasap").val();
					var birthDate = $("#fechanac").val();
					var names = $("#name").val();
					var surnames = $("#ap-paterno").val();

					validarDocumentoReniec(docType, document, birthDate,
							names, surnames);
				}else {
					// $('#div-documento-pasap').css("margin-bottom","28px");
					$('#document_number_pasap_msg').text(
							"ESTE DATO SERÁ USADO COMO TU USUARIO");
					$('#document_number_pasap_msg').css("color", "#07663a");
				}
			}
			documentNumberPasap = $("#document-number-pasap").val();
		});

var documentNumberCarex = '';
$("#document-number-carex").keyup(
		function() {
			if ($("#document-number-carex").val() != documentNumberCarex) {
				if ($("#document-number-carex").val().length >= 9
						&& $("#document-number-carex").val().length <= 12
						&& $('#name').length > 0) {
					validarDocumento($("#document-type option:selected").val(),
							$("#document-number-carex").val());
				}
				if ($("#document-number-carex").val().length >= 9) {
					var birthDate = $("#fechanac").val();
					var names = $("#name").val();
					var surnames = $("#ap-paterno").val();

					validarDocumentoReniec($("#document-type option:selected")
							.val(), $("#document-number-carex").val(),
							birthDate, names, surnames);
				} else {

					// $('#div-documento-carex').css("margin-bottom","28px");
					$('#document_number_carex_msg').text(
							"ESTE DATO SERÁ USADO COMO TU USUARIO");
					$('#document_number_carex_msg').css("color", "#07663a");
					$('#div-documento-carex').css("border", "1px solid #666666");
					$('#div-documento-carex label').css("color", "#666666");
				}
			}
			documentNumberCarex = $("#document-number-carex").val();
		});

var name = '';
var apPaterno = '';
var fechaNac = '';

// Validación de nombres
$("#name").keyup(function() {
    if ($("#name").val().length >= 1) {
        validarPorTipoDocumento();
    } else {
        $('#name_msg').text("").css("color", "#07663a");
    }
    name = $("#name").val();
});

// Validación de apellido paterno
$("#ap-paterno").keyup(function() {
    if ($("#ap-paterno").val().length >= 1) {
        validarPorTipoDocumento();
    } else {
        $('#ap-paterno_msg').text("").css("color", "#07663a");
    }
    apPaterno = $("#ap-paterno").val();
});

// Validación de fecha de nacimiento
$("#fechanac").on("change", function() {
    if ($("#fechanac").val() !== "") {
        validarPorTipoDocumento();
    }
    fechaNac = $("#fechanac").val();
});



function validarPorTipoDocumento() {
    var docType = $("#document-type").val();
    var birthDate = $("#fechanac").val();
    var names = $("#name").val();
    var surnames = $("#ap-paterno").val();

    var documentFields = {
        "CAREX": "#document-number-carex",
        "PASAP": "#document-number-pasap",
        "DNI": "#document-number"
    };
    

    if (documentFields[docType]) {
        var documentNumber = $(documentFields[docType]).val();

        if (docType === "PASAP" && (!documentNumber || birthDate.length < 1 || names.length < 2 || surnames.length < 1)) {
            console.log("Faltan llenar campos para PASAP");
            return;
        }

        validarDocumentoReniec(docType, documentNumber, birthDate, names, surnames);
    } else {
        console.log("Falta llenar campos o tipo de documento no reconocido");
    }
}



function validarDocumento(docType, document) {
	if ($('#notvalidate').length > 0) {
		return;
	}
	var ico = $(this).siblings('i');
	// var urlref=window.location.href;
	$
			.ajax({
				url : "documentvalidation.html",
				data : {
					"docType" : docType,
					"document" : document
				},
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
					$(ico).removeClass('loading');
					if (data.message === "OK") {
						if (data.flag === "9") {
							var url = "ESTE DOCUMENTO YA TIENE UNA CUENTA CREADA. PARA TERMINAR TU REGISTRO <a id=show_complete_registration href='completar-registro.html"
									+ "?typedoc="
									+ docType
									+ "&document="
									+ document
									+ "' style='color:red; font-weight:900;'><u>HAZ CLIC AQUÍ</u></a>";
							var operatorIdApi = $('#operatorIdApi').val();
							if (operatorIdApi === '5588') {
								var paramref = (window.location.href)
										.split('?')[1];
								url = "ESTE DOCUMENTO YA TIENE UNA CUENTA CREADA. PARA TERMINAR TU REGISTRO <a id=show_complete_registration href='completar-registro.html"
										+ "?typedoc="
										+ docType
										+ "&document="
										+ document
										+ "&"
										+ paramref
										+ "' style='color:red; font-weight:900;'><u>HAZ CLIC AQUÍ</u></a>";
							}
							switch (docType) {
							case "DNI":
								$('#document_number_msg').html(url);
								$('#document_number_msg').css("color", "red");
								break;
							case "PASAP":
								$('#document_number_pasap_msg').html(url);
								$('#document_number_pasap_msg').css("color",
										"red");
								break;
							case "CAREX":
								$('#document_number_carex_msg').html(url);
								$('#document_number_carex_msg').css("color",
										"red");
								break;
							}

						} else if (data.locked === "SI") {
							var titulo = "Usuario bloqueado";
							var mensaje = "Tu usuario ha sido bloqueado, comunícate con La Tinka al 5135502.";
							var msgError = '<div><div class="titulo-login-error">'
									+ titulo
									+ '</div><br><div class="mensaje-login-error"><span>'
									+ mensaje
									+ '</span></div><br><br>'
									+ '<button class="btn btn-login-error"  type="button" onclick="goRegister()">Aceptar</button></div>';

							$('#msg-message').html(msgError);
							$('#close-popup-message').hide();
							openModal("#popup-message", "");

						} else {
							var mensaje = "Este documento ya tiene una cuenta creada. Ingresa a tu cuenta con tu número de documento y contraseña. Si no lo recuerdas selecciona “¿Olvidaste tu contraseña?” para cambiarla.";
							var msgError = '<div id="doc-is-registered"><div class="mensaje-login-error"><span>'
									+ mensaje
									+ '</span></div><br><br>'
									+ '<button class="btn btn-login-error"  type="button" onclick="goRecoverPassword()">&iquest;Olvidaste tu contrase&ntilde;a?</button></div>';

							$('#msg-message').html(msgError);
							$('#close-popup-message').show();
							openModal("#popup-message", "");

						}

					} else {
						if (data.message === 'CONSULT') {
							console.log("documento no registrado");
						} else {
							// alertMessagePD(data.error,false);
							var msgError = '<div id="doc-is-registered"><div class="titulo-login-error">'
									+ data.titulo
									+ '</div><br><div class="mensaje-login-error"><span>'
									+ data.mensaje
									+ '</span></div><br><br>'
									+ '<button class="btn btn-login-error"  type="button" onclick="closePopup(\'popup-message\'); clearDocument();">Aceptar</button></div>';

							$('#msg-message').html(msgError);
							$('#close-popup-message').show();
							openModal("#popup-message", "");
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
				data : {
					"docType" : docType,
					"document" : document,
					"birthDate" : birthDate,
					"names" : names,
					"surnames" : surnames
				},
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
					if (data.error_code === 200) {
						console.log("Documento válido");

						if (data.error_message === "DNI No Valido") {
							
							$('#document_number_msg').text("INGRESE UN DNI VÁLIDO");
							$('#document_number_msg').css("color", "#E9041B");
							$('#divNumberDoc').css("border", "1px solid #E9041B");
							$('#divNumberDoc label').css("color", "#E9041B");
						}

						if (data.error_message === "CAREX No Valido") {
		
							$('#document_number_carex_msg').text("INGRESE UN CARNET DE EXTRANGERÍA VÁLIDO");
							$('#document_number_carex_msg').css("color", "#E9041B");
							$('#div-documento-carex').css("border", "1px solid #E9041B");
							$('#div-documento-carex label').css("color", "#E9041B");
						}

						if (names === "") {
							data.data.nombre = true;
						}
						if (surnames === "") {
							data.data.apellidos = true;
						}
						if (birthDate === "") {
							data.data.fechaNacimiento = true;
						}
						
						if (data.data.apellidos) {
							$('#ap-paterno_msg').text("");
							$('#ap-paterno_msg').css("color", "#07663a");
						} else {
							$('#ap-paterno_msg')
									.text(
											"INGRESA TUS APELLIDOS IGUAL A TU DOCUMENTO DE IDENTIDAD");
							$('#ap-paterno_msg').css("color", "#E9041B");
						}

						if (data.data.nombre) {
							$('#name_msg').text("");
							$('#name_msg').css("color", "#07663a");
						} else {
							$('#name_msg')
									.text(
											"INGRESA TUS NOMBRES IGUAL A TU DOCUMENTO DE IDENTIDAD");
							$('#name_msg').css("color", "#E9041B");
						}

						if (data.data.fechaNacimiento) {
							$('#fechanac_msg').text("");
							$('#fechanac_msg').css("color", "#07663a");
						} else {
							$('#fechanac_msg')
									.text(
											"INGRESA TU FECHA DE NACIMIENTO IGUAL A TU DOCUMENTO DE IDENTIDAD. DEBE SER MAYOR DE EDAD.");
							$('#fechanac_msg').css("color", "#E9041B");
						}

					} else if (data.error_code === 400
							|| data.error_code === 500) {
						console.log("Documento no válido");
						
						$('#ap-paterno_msg').text("");
						$('#name_msg').text("");
						$('#fechanac_msg').text("");

						switch (docType) {
						case "DNI":
							$('#document_number_msg').html(url);
							$('#document_number_msg').css("color", "#E9041B");
							break;
						case "CAREX":
							$('#document_number_carex_msg').html(url);
							$('#document_number_carex_msg').css("color", "#E9041B");
							break;
						}

						$('#document_number_msg').text(
								"INGRESE UN DOCUMENTO VÁLIDO");
						$('#document_number_msg').css("color", "#E9041B");
					} else {
						console.log("Servicio Caido");
					}
				},
				error : function() {
					console
							.log("Error en la validación del documento. Intente nuevamente.");
					$('#document_number_msg').text(
							"ESTE DATO SERÁ USADO COMO TU USUARIO");
					$('#document_number_msg').css("color", "#07663a");
				}
			});
}

// fin de vacidacion de n° de documento

