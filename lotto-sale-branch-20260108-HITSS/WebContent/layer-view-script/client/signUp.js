/**
 * User: george.minaya
 * Date: 11/06/13
 * Time: 10:33 AM
 */
;
var create = {
    optionItem: function (a, b) {
        return "<li class='option-item' data-option-value=" + b + ">" + a + "</li>"
    },
    optionsList: function (a) {
        var b = '';
        a.children('option').each(function () {
            if ($(this).val() != '') {
                b += create.optionItem($(this).text(), create.dataAttributeSelect($(this).val()))
            }
        });
        return b
    },
    dataAttributeSelect: function (a) {
        return a
    },
    documentTypeList: function () {
        var a = '<option value="">Seleccione</option>';
        var b = [{
            code: "DNI",
            description: "DNI"
        }, {
            code: "PASAP",
            description: "Pasaporte"
        }, {
            code: "CAREX",
            description: "Carnet de Extranjería"
        }];
        $.map(b, function (d) {
            a += '<option value="' + d.code + '">' + d.description + '</option>'
        });
        return a
    },
    dayList: function () {
        var a = '<option value="">Seleccione</option>';
        for (var x = 1; x <= 31; x++) {
            a += '<option value="' + x + '">' + x + '</option>'
        }
        return a
    },
    monthList: function () {
        var a = '<option value="">Seleccione</option>';
        var b = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Setiembre', 'Octubre', 'Noviembre', 'Diciembre'];
        for (var x in b) {
            var t = (parseInt(x) + 1);
            var m = ((parseInt(x) + 1) < 10) ? '0' + (parseInt(x) + 1) : (parseInt(x) + 1);
            a += '<option value="' + (((parseInt(x) + 1) < 10) ? '0' + (parseInt(x) + 1) : (parseInt(x) + 1)) + '">' + b[x] + '</option>'
        }
        return a
    },
    yearList: function () {
        var a = '<option value="">Seleccione</option>';
        for (var b = new Date().getFullYear() - 18; b >= new Date().getFullYear() - 100; b--) {
            a += '<option value="' + b + '">' + b + '</option>'
        }
        return a
    }
};
var run = {
    toJSON: function (a) {
        return ((a === '') ? '' : $.parseJSON($.trim(a)))
    },
    isDate: function (a) {
        if (a == '') {
            return false
        }
        var b = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;
        var c = a.match(b);
        if (c == null) {
            return false
        }
        var d = c[1];
        var e = c[3];
        var f = c[5];
        if (e < 1 || e > 12) {
            return false
        } else if (d < 1 || d > 31) {
            return false
        } else if ((e == 4 || e == 6 || e == 9 || e == 11) && d == 31) {
            return false
        } else if (e == 2) {
            var g = (f % 4 == 0 && (f % 100 != 0 || f % 400 == 0));
            if (d > 29 || (d == 29 && !g)) {
                return false
            }
        }
        return true
    },
    isOfAge: function () {},
    hashCheck: function () {
        if (location.hash && location.hash === '#activa-tu-cuenta') {
            $('#nav-bar').children('.indicator').removeClass('start').addClass('end');
            $('#register').remove();
            var DataUser = run.toJSON($('#DataUser').val());
            if ($("#clientId").val() == '') {
                window.location.href = 'inicio.html#activar'
            } else {
                if ($('#mailStatus').val() == 'DES') {
                    $('#activate').show();
                    if(DataUser.keycode != null && DataUser.keycode != "") {
                    	$('#msg-activate').css({display : 'none'});
                    	$('#btn-activate').prop("disabled",false);
                    	$('#btn-activate').css({backgroundPosition : 'center top'});
                    } else {
                    	$('#msg-activate').css({display : 'block'});
                    	$('#btn-activate').prop("disabled",true);
                    	$('#btn-activate').css({backgroundPosition : 'center -35px'});
                    }
                } else if ($('#mailStatus').val() == 'ACT') {
                    window.location.href = 'mi-cuenta.html'
                }
            }
            //$('#verification-code').focus();
            $('#id-client-verify').val(DataUser.clientId);
            $('#id-client-code').val(DataUser.clientId);
            $('#id-client-um').val(DataUser.clientId);
            $('#your-name').text(DataUser.name);
            $('#your-email').text(DataUser.email);
            $('#email-client-um').val(DataUser.email);
            $('#email-client-code').val(DataUser.email)
            $('#verification-code').val(DataUser.keycode)
        }
    },
    completeDate: function () {
        if ($('#DataUserClaim').exists()) {
            var DataUserClaim = run.toJSON($('#DataUserClaim').val());
            if (DataUserClaim != {}) {
                $('#name').val(DataUserClaim.name);
                $('#ap-paterno').val(DataUserClaim.ApPaterno);
                $('#ap-materno').val(DataUserClaim.ApMaterno);
                $('#document-number').val(DataUserClaim.numberId);
                $('#fixed-phone').val(DataUserClaim.fixedPhone);
                $('#mobile-phone').val(DataUserClaim.mobilePhone);
                $('#email').val(DataUserClaim.email)
            }
        }
    },
    cleanUpTheMess: function () {
        $('#DataUserClaim').remove()
    }
};
var $signUp = function () {
    run.hashCheck();
    run.completeDate();
    var d = $('#document-type');
    var e = $('#day');
    var f = $('#month');
    var g = $('#year');
    var h = $('#country');
    var i = $('#region');
    var j = $('#province');
    var k = $('#comMovil');
    d.html(create.documentTypeList());
    e.html(create.dayList());
    f.html(create.monthList());
    g.html(create.yearList());
    $('#x-document-type').html(create.optionsList(d));
    $('#x-day').html(create.optionsList(e));
    $('#x-month').html(create.optionsList(f));
    $('#x-year').html(create.optionsList(g));
    $('#x-country').html(create.optionsList(h));
    $('#x-region').html(create.optionsList(i));
    $('#x-province').html(create.optionsList(j));
    $('#x-comMovil').html(create.optionsList(k));
    $('.custom-select').on('click', function (a) {
        a.stopPropagation();
        $('#' + $(this).data('select')).focus();
        $('#x-' + $(this).data('select')).toggleClass('open');
        $('.option-list').not($(this).children('.option-list')).removeClass('open')
    });
    $('.option-list').on('click', '.option-item', function (a) {
        a.stopPropagation();
        var b = $(this).data('optionValue');
        var c = $(this).parent('ul').data('select');
        $('#' + c).children('option').filter(function () {
            return $(this).val() == b
        }).prop('selected', true);
        $('.custom-select').removeClass('ui-invalid-output');
        $('#op-sel-' + c).val($(this).text());
        $('.option-list').removeClass('open')
    });

    /*$(document).on("click", "#btnSMS", function (event) { 
    	$('#register').hide();
        $('#register-end').fadeIn();
    	
    });*/
   
    /*$(document).on("click", "#btnResendSmsRegister", function (event) {
    	event.preventDefault();
    	var container = $('#wrapper-form');
    	$.ajax({
            url: 'resend-sms-register.html',
            type: 'post',
            dataType: 'json',
            beforeSend: function () {
            	container.append('<div id="loader-frm-register"></div>')
            },
            error: function () {
            	container.find('#loader-frm-register').remove();
                jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.')
            },
            success: function (e) {
            	container.find('#loader-frm-register').remove();
            	jAlert(e.message) 
            }
        })
    	
    });*/
    
    /*$(document).on("click", "#btnActiveAccount", function (event) { 
    	event.preventDefault();
    	var container = $('#wrapper-form');
    	var code = $.trim($('#sms-code-register').val());
    	$.ajax({
            url: 'send-code-validation.html',
            type: 'post',
            data: "sms-code=" + code,
            dataType: 'jsonp',
            beforeSend: function () {
            	container.append('<div id="loader-frm-register"></div>')
            },
            error: function () {
            	container.find('#loader-frm-register').remove();
                jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.')
            },
            success: function (e) {
            	container.find('#loader-frm-register').remove();
            	if(e.status===1) {
            		$('#sms-code-register').attr("disabled","disabled");
            		$('#message-detail').text(e.message);
            		$('#btnActiveAccount').attr("disabled","disabled");
            		$('#btnResendSmsRegister').attr("disabled","disabled");
            	}
            	jAlert(e.message) 
            }
        })
    	
    });*/
    
    //register
    $('#frm-book-claim').on('submit', function (event) {
        var $form = $(this);
        event.preventDefault();
        var isValid = true;
        $('.select').each(function () {
            if ($(this).val() == '') {
                $('#switch-' + $(this).attr('id')).addClass('ui-invalid-output');
                isValid = false
            }
        });
        $('.text-in').each(function () {
            if ($(this).val() == '') isValid = false
        });
        if (isValid) {
            $.ajax({
                url: $(this).attr('action'),
                data: $(this).serialize(),
                type: $(this).attr('method'),
                dataType: 'json',
                beforeSend: function () {
                    $form.append('<div id="loader-frm-register"></div>')
                },
                error: function () {
                    $form.find('#loader-frm-register').remove();
                    jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.')
                },
                success: function (data) {
                    $form.find('#loader-frm-register').remove();
                    if (data.message === '1') {
                        jAlert(data.info, null, function (r) {
                            if (r) {
                                window.location.replace('mi-cuenta.html')
                            }
                        })
                    } else if (data.message === '2') {
                        jAlert(data.info)
                    }
                }
            })
        } else {
            jAlert('¡Por favor complete los campos obligatorios!')
        }
    });
    if ($('#DataUserClaim').exists()) {
        var DataUserClaim = run.toJSON($('#DataUserClaim').val());
        $('#x-region').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == DataUserClaim.region
        }).trigger('click');
        $('#x-document-type').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == DataUserClaim.typeId
        }).trigger('click');
        $('#x-day').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == DataUserClaim.day
        }).trigger('click');
        $('#x-month').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == DataUserClaim.month
        }).trigger('click');
        $('#x-year').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == DataUserClaim.year
        }).trigger('click')
    }
    $('#frm-user-verify').on('submit', function (event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('action'),
            data: $(this).serialize(),
            type: $(this).attr('method'),
            dataType: 'json',
            success: function (data) {
                if (data.message === 'OK') {
                    jAlert('El proceso de activacion se realizó satisfactoriamente');
                    window.location.replace('mi-cuenta.html')
                } else {
                    jAlert(data.message)
                }
            }
        })
    });
    $('#frm-email-update').on('submit', function (event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('action'),
            data: $(this).serialize(),
            type: $(this).attr('method'),
            dataType: 'json',
            success: function (data) {
                if (data.message === 'OK') {
                    jAlert('Su correo electrónico fue actualizado. Hemos enviado la solicitud para activar su cuenta, revise su bandeja de correo.')
                } else {
                    jAlert(data.message)
                }
            }
        })
    });
    /*$('#frm-new-code').on('submit', function (event) {
        event.preventDefault();
        $.ajax({
            url: $(this).attr('action'),
            data: $(this).serialize(),
            type: $(this).attr('method'),
            dataType: 'json',
            success: function (data) {
                if (data.message === 'OK') {
                    jAlert('Se le ha enviado un nuevo código de verificación, revise su bandeja de correo.')
                } else {
                    jAlert(data.message)
                }
            }
        })
    });*/
    $('#user-question').on('mouseover', function () {
        $('.tooltip-info-arrow-img').css({
            "display": "block",
            "position": "absolute",
            "top": "119px",
            "left": "86px"
        });
        $('.tooltip-info2').css({
            "display": "block",
            "position": "absolute",
            "top": "126px",
            "left": "78px"
        });
        $('.tooltip-info2').html('Tu usuario debe tener una<br>extensión entre 6 y 25 caracteres.')
    }).on("mouseleave", function () {
        $('.tooltip-info-arrow-img').hide();
        $('.tooltip-info2').hide()
    });
    $('#pass-question').on('mouseover', function () {
        $('.tooltip-info-arrow-img').css({
            "display": "block",
            "position": "absolute",
            "top": "149px",
            "left": "86px"
        });
        $('.tooltip-info2').css({
            "display": "block",
            "position": "absolute",
            "top": "156px",
            "left": "78px"
        });
        $('.tooltip-info2').html('La contrase&ntilde;a debe tener al menos<br> 6 caracteres, contener letras y<br> m&iacute;nimo un n&uacute;mero.')
    }).on("mouseleave", function () {
        $('.tooltip-info-arrow-img').hide();
        $('.tooltip-info2').hide()
    });
    $('#mail-question').on('mouseover', function () {
        $('.tooltip-info-arrow-img').css({
            "display": "block",
            "position": "absolute",
            "top": "218px",
            "left": "86px"
        });
        $('.tooltip-info2').css({
            "display": "block",
            "position": "absolute",
            "top": "225px",
            "left": "78px"
        });
        $('.tooltip-info2').html('Ingrese su correo electr&oacute;nico de<br> forma correcta, se le enviar&aacute;<br> un c&oacute;digo de seguridad para<br> activar su cuenta.')
    }).on("mouseleave", function () {
        $('.tooltip-info-arrow-img').hide();
        $('.tooltip-info2').hide()
    });
    $('#d-question').on('mouseover', function () {
        $('.tooltip-info-arrow-img').css({
            "display": "block",
            "position": "absolute",
            "top": "236px",
            "left": "345px"
        });
        $('.tooltip-info2').css({
            "display": "block",
            "position": "absolute",
            "top": "243px",
            "left": "334px"
        });
        $('.tooltip-info2').html('Los juegos son s&oacute;lo para<br> mayores de edad, por<br> este motivo, no se permite<br> el registro de menores<br> de 18 a&ntilde;os.')
    }).on("mouseleave", function () {
        $('.tooltip-info-arrow-img').hide();
        $('.tooltip-info2').hide()
    });
    $('#x-country').children('li.option-item').filter(function () {
        return $(this).data('optionValue') === 'PE'
    }).trigger('click');
    $('#term-cond').on('click', function (event) {
        event.preventDefault();
        document.body.scrollTop = document.body.scrollHeight;
        dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones.html', 'TÉRMINOS Y CONDICIONES', 'width=606,height=460,scrolling=1,center=1,resize=0', 'recal')
    });
    run.cleanUpTheMess()
};
$($signUp);