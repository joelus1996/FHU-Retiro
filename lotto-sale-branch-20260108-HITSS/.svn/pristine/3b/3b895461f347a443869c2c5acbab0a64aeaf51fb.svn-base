var create = {
    optionItem: function (a, b) {
        return"<li class='option-item' data-option-value=" + b + ">" + a + "</li>"
    }, optionsList: function (a) {
        var b = '';
        a.children('option').each(function () {
            if ($(this).val() != '') {
                b += create.optionItem($(this).text(), create.dataAttributeSelect($(this).val()))
            }
        });
        return b
    }, dataAttributeSelect: function (a) {
        return a
    }, documentTypeList: function () {
        var a = '<option value="">seleccione</option>';
        var b = [
            {code: "DNI", description: "DNI"},
            {code: "PASAP", description: "Pasaporte"},
            {code: "CAREX", description: "Carnet de Extranjería"}
        ];
        $.map(b, function (d) {
            a += '<option value="' + d.code + '">' + d.description + '</option>'
        });
        return a
    }, dayList: function () {
        var a = '<option value="">seleccione</option>';
        for (var x = 1; x <= 31; x++) {
            a += '<option value="' + x + '">' + x + '</option>'
        }
        return a
    }, monthList: function () {
        var a = '<option value="">seleccione</option>';
        var b = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Setiembre', 'Octubre', 'Noviembre', 'Diciembre']
        for (var x in b) {
            var t = (parseInt(x) + 1);
            var m = ((parseInt(x) + 1) < 10) ? '0' + (parseInt(x) + 1) : (parseInt(x) + 1);
            a += '<option value="' + (((parseInt(x) + 1) < 10) ? '0' + (parseInt(x) + 1) : (parseInt(x) + 1)) + '">' + b[x] + '</option>'
        }
        return a
    }, yearList: function () {
        var a = '<option value="">seleccione</option>';
        for (var b = new Date().getFullYear() - 18; b >= new Date().getFullYear() - 100; b--) {
            a += '<option value="' + b + '">' + b + '</option>'
        }
        return a
    }, comMovilList: function () {
        var a = '<option value="">seleccione</option>';
        var b = [
            {code: "CLARO", description: "Claro"},
            {code: "TELEF", description: "Telefonica"},
            {code: "ENTEL", description: "Entel"},
            {code: "BITEL", description: "Bitel"}
        ];
        $.map(b, function (d) {
            a += '<option value="' + d.code + '">' + d.description + '</option>'
        });
        return a }
		};
		
		
var run = {
    toJSON: function (a) {
        return ((a === '') ? '' : $.parseJSON($.trim(a)))
    }, isDate: function (a) {
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
    }, isOfAge: function () {
        // all code
    }, completeDate: function () {
        if ($('#DataClient').exists()) {
            var DataClient = run.toJSON($('#DataClient').val());
            if (DataClient != undefined && DataClient != null) {
				$('#name').attr("value",DataClient.name);
                $('#ap-paterno').attr("value",DataClient.ApPaterno);
                $('#ap-materno').attr("value",DataClient.ApMaterno);   
                $('#birth-date').text(DataClient.birthDate);
                $('#document-number').attr("value",DataClient.numberId);
                $('#mobile-phone').attr("value",DataClient.mobilePhone); 
                if(DataClient.name != null && DataClient.name != undefined)
                $('#name').prop( "disabled", true );
                if(DataClient.ApPaterno != null && DataClient.ApPaterno != undefined)
                $('#ap-paterno').prop( "disabled", true );
                if(DataClient.ApMaterno != null && DataClient.ApMaterno != undefined)
                $('#ap-materno').prop( "disabled", true );  
				$('#confirm').prop('checked', true);	
				
            }
        }
    },
    cleanUpTheMess: function () {
        $('#DataClient').remove()
    }
};

//jQuery.fn.reset = function () {
//  $(this).each(function() {
//      this.reset()
//  })
//}
var $updateData = function () {
  //  run.hashCheck();
    run.completeDate();
    var d = $('#document-type');
    var e = $('#day');
    var f = $('#month');
    var g = $('#year');
    var k = $('#comMovil');
    d.html(create.documentTypeList());
    e.html(create.dayList());
    f.html(create.monthList());
    g.html(create.yearList());
	k.html(create.comMovilList());
    $('#x-document-type').html(create.optionsList(d));	
	$('#x-day').html(create.optionsList(e));
    $('#x-month').html(create.optionsList(f));
    $('#x-year').html(create.optionsList(g));
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
        $('#op-sel-' + c).text($(this).text()).removeClass('placeholder');
        $('.option-list').removeClass('open')
    });
    $('html').on('click', function (a) {
        a.stopPropagation();
        if (a.target != $('.custon-select')) {
            $('.option-list').removeClass('open')
        }
    });
   
    $("#term-cond").on("click", function(){
        var printwin_01 = dhtmlwindow.open("resultbox", "iframe", "update-promo-Condiciones.html", "ACTUALIZA TUS DATOS Y GANA", "width=654,height=505,scrolling=1,center=1,resize=1", "recal");
    })
    
    
    
    $('#frm-update-date').on('submit', function(b){
	b.preventDefault();
      
		var $form = $(this);
        
        var isValid = true;
     		var sw;	
			var dia;
			var mes;
			var anio;
			var confir; 				
			if(DataClient.birthDate != null && DataClient.birthDate != undefined ) {
			   fecha  = DataClient.birthDate.split("/");
				dia = fecha[0];
				mes = fecha[1];
				anio = fecha[2];
			}else{
				dia = $('#day').val();
				mes = $('#month').val();
				anio = $('#year').val();
			}
			
			if(DataClient.confirm != null &&  DataClient.confirm != undefined  ){
				confir = DataClient.confirm;
			}else
				confir = $('#confirm').val(); 
			
        if($("#name").val().length == 0)
        	isValid = false;			
        if($("#ap-paterno").val().length == 0)
        	isValid = false;
        if($("#ap-materno").val().length == 0)
        	isValid = false;		
        if($("#mobile-phone").val().length < 9 ){
        	isValid = false;		
			jAlert('¡Complete su celular!');
			}

		var check = $("#terms").prop("checked");	
			if(!check){
				jAlert('¡Para proseguir debe aceptar los terminos y condiciones!');
				return isValid = false;
				}
		
        
        if($("#document-number").val().length <= 8){		
        	var num = $("#document-number").val();        	
        	if(num.length<8){
        		isValid = false;
        	}
			if(num.length==8){
					if(num == "12345678"){
						isValid = false;sw=1;
					}else if(num == "87654321"){
						isValid = false;sw=1;
					} else if(num == "98765432"){
						isValid = false;sw=1;
					} else if(num == "23456789"){
						isValid = false;sw=1;
					} else 	if(num == "01234567"){
						isValid = false;sw=1;
					} else	if(num == "76543210"){
						isValid = false;sw=1;
					} else 	if(num == "11111111"){
						isValid = false;sw=1;
					} else if(num == "22222222"){
						isValid = false;sw=1;
					} else if(num == "33333333"){
						isValid = false;sw=1;
					} else if(num == "44444444"){
						isValid = false;sw=1;
					} else if(num == "55555555"){
						isValid = false;sw=1;
					} else if(num == "66666666"){
						isValid = false;sw=1;
					} else if(num == "77777777"){
						isValid = false;sw=1;
					} else if(num == "88888888"){
						isValid = false;sw=1;
					} else if(num == "99999999"){
						isValid = false;sw=1;
					} else if(num == "00000000"){
						isValid = false;sw=1;
					}
			}
        }  else  isValid = false;   
        var genero = "";
		$('input[name="gender"]').each(function () {
				if ($(this).prop('checked')) {					
					genero = $(this).val();
				}				
		}); 
		if(genero == ""){
			ga('send', 'pageview', '/btn_error.html');
			jAlert('Seleccione genero.');
			isValid = false;
		}
		
		 $('.select').each(function () {
            if ($(this).val() == '') {
                $('#switch-' + $(this).attr('id')).addClass('ui-invalid-output');
                isValid = false;
				sw=0;
            }
        });
		var rrrr = "name="+$('#name').val()+"&ap-paterno="+$('#ap-paterno').val()+"&ap-materno="+$('#ap-materno').val()+"&gender="+genero+
					"&typeId="+$('#document-type').val()+"&numberId="+$('#document-number').val()+"&day="+dia+"&month="+mes+"&year="+anio+
					"&comPhones="+$('#comMovil').val()+"&mobile-phone="+$('#mobile-phone').val()+"&confirm="+confir;		

		if (isValid) {
        	
        		var urls = "name="+$('#name').val()+"&ap-paterno="+$('#ap-paterno').val()+"&ap-materno="+$('#ap-materno').val()+"&gender="+genero+
					"&typeId="+$('#document-type').val()+"&numberId="+$('#document-number').val()+"&day="+dia+"&month="+mes+"&year="+anio+
					"&comPhones="+$('#comMovil').val()+"&mobile-phone="+$('#mobile-phone').val()+"&confirm="+confir;		
            $.ajax({url: $(this).attr('action'), data: urls, type: $(this).attr('method'), dataType: 'json',
                beforeSend: function () {
                    $form.append('<div id="loader-frm-register"></div>')
                },
                error: function () {
                    $form.find('#loader-frm-register').remove();
                    jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.')
                },
                success: function (a) {
                   $form.find('#loader-frm-register').remove();
                    if (a.message == 'OK') {
                    	/* ga('send', 'pageview', '/btn_gracias.html'); */
                        $("#content").html('<div id="content-message"><p class="title"><br><br>¡Gracias por participar, tus datos se actualizaron correctamente!</p><p class="text"><br>Recuerda que el sorteo es el 05 de Junio del 2014 y estaremos enviando<br><br>la relación de ganadores vía e-mail al día siguiente del sorteo.</p><b class="text"><br>¡Mucha suerte!<b><a id="my-cuenta" href="mi-cuenta.html#jugadas"></a></div>');
				   } else  {
                        jAlert(a.message, null)
                    }
                }
            })
        } else {
        	if(sw == 0){
			isValid = true;
			  /* ga('send', 'pageview', '/btn_error.html'); */
        	  jAlert('¡Por favor complete los campos obligatorios!');
        	}
        	if(sw == 1){
			isValid = true;
			/* ga('send', 'pageview', '/btn_error.html'); */
      		  jAlert('¡El Documento no es correcto!');
      	}
        }

    });
	
    if ($('#DataClient').exists() ) {
	var DataClient = run.toJSON($('#DataClient').val());
		if(DataClient != undefined && DataClient != null){
			var DataClient = run.toJSON($('#DataClient').val());

			$('input[name="gender"]').each(function () {
				if ($(this).val() === DataClient.gender) {
					$(this).prop('checked', true);
				$('input[name="gender"]').prop( "disabled", true );
					return false
				}
			});        
					
			if(DataClient.typeId != null && DataClient.typeId != undefined){
		   $('#x-document-type').children('li.option-item').filter(function () {
				return $(this).data('optionValue') == DataClient.typeId;
			}).trigger('click');}

			if(DataClient.comPhones != null && DataClient.comPhones != undefined){
			$('#x-comMovil').children('li.option-item').filter(function () {
				return $(this).data('optionValue') == DataClient.comPhones
			}).trigger('click');
			}
		}
    }


    run.cleanUpTheMess();
    
    
};
$($updateData);
$(document).on('load', function () {
    // optional code
});