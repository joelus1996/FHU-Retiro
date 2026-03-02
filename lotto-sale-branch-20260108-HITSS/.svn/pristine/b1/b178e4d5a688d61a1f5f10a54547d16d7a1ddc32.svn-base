/**
 * User: george.minaya
 * Date: 05/08/13
 * Time: 10:43 AM
 */
;
var creater = {
    optionItem: function(content, dataAttribute) {
        return "<li class='option-item' data-option-value=" + dataAttribute + ">" + content + "</li>"
    },
    optionsList: function($select) {
        var list = '';
        $select.children('option').map(function() {
            if ($(this).val() != 0) {
                list += creater.optionItem($(this).text(), creater.dataAttributeSelect($(this).val()))
            }
        });
        return list
    },
    dataAttributeSelect: function(value) {
        return value
    },
    hoursList : function() {
        var list = '<option selected="true" disabled="disabled" value="">Seleccione</option>';
        for (var x = 1; x <= 6; x++) {
            list += '<option value="' + x + '">' + x + '</option>';
        }
        return list;
    },
    today: function() {
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1;
        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd
        }
        if (mm < 10) {
            mm = '0' + mm
        }
        today = mm + '/' + dd + '/' + yyyy;
        return today
    }
};

$selfControl = function() {
    var $hours = $('#hours'); 
    
    $hours.html(creater.hoursList());
    
    $('#x-hours').html(creater.optionsList($hours));
    
    $('.custom-select').on('click', function(event) {
        event.stopPropagation();
        $('#x-' + $(this).data('select')).toggleClass('open');
        $('.option-list').not($(this).children('.option-list')).removeClass('open')
    });
    
    $('.option-list').on('click', '.option-item', function(event) {
        event.stopPropagation();
        var optionValue = $(this).data('optionValue');
        var $dataSelect = $(this).parent('ul').data('select');
        $('#' + $dataSelect).children('option').filter(function() {
            return $(this).val() == optionValue
        }).prop('selected', true);
        $('.custom-select').removeClass('ui-invalid-output');
        $('#op-sel-' + $dataSelect).text($(this).text()).removeClass('placeholder');
        $('.option-list').removeClass('open')
    });
    
    $('#frm-define-money').on('submit', function(event) {
        event.preventDefault();
        var $frm = $(this);
     // Serializar los datos del formulario
        var formData = $frm.serialize();
        // Agregar datos adicionales al objeto formData
        formData += '&type=POR_MONTO'; 
        
        $.ajax({
            url: $(this).attr('action'),	
            type: $(this).attr('method'),
            data: formData,
            dataType: $(this).data('responseType'),
            success: function(a) {
            	
                if (a.message === 'OK') {
                	var number2  = parseInt ( $('#soles').val() ) ;
                	var solesVal = number2.toLocaleString('es-MX');
                    $('#money-control-message').text('S/ '+  solesVal + ' el ' + a.lastDate);    
                    $('#respuesta-monto').addClass('received-msg-autocontrol');
                    

                	$('#frm-disable-monto').addClass('frm-desactivar-limites');              	
                	$('#frm-disable-hours').addClass('frm-desactivar-limites');
                	$('#frm-disable-autoexlusion').addClass('frm-desactivar-limites');
                	
                	$('#respuesta-hours').removeClass('received-msg-autocontrol');
                	$('#respuesta-autoexclusion').removeClass('received-msg-autocontrol');
                	
                	$('#soles').val('');
                	
                } else if (a.message === 'ERROR_POR_FECHA') {
                    jAlert(a.info, "Importante");
                    $('#soles').val('');
                } else {
                    jAlert(a.info, "Importante");
                    $('#soles').val('');
                }
                
            }
        });
        
        setDefaultSelectedValue('hours');
    });
    
    $('#frm-define-time').on('submit', function(event) {
        event.preventDefault();
        
        var $frm = $(this);
        // Serializar los datos del formulario
        var formData = $frm.serialize();
        // Agregar datos adicionales al objeto formData
        formData += '&type=POR_HORAS';
        
        var valorHora= $('#hours').val();
        
        if (valorHora === '' || valorHora === null || valorHora === undefined) {
        	jAlert("Debes seleccionar un valor", "Importante")
        }else{
        	
        	$.ajax({
                url: $(this).attr('action'),
                type: $(this).attr('method'),
                data: formData,
                dataType: $(this).data('responseType'),
                success: function(a) {
                    if (a.message === 'OK') {
                       
                    	$('#time-control-message').text($('#hours').val() + ' horas desde el ' + a.lastDate);      
                        $('#respuesta-hours').addClass('received-msg-autocontrol');
                        
                        $('#frm-disable-hours').addClass('frm-desactivar-limites');
                        $('#frm-disable-monto').addClass('frm-desactivar-limites');
                        $('#frm-disable-autoexlusion').addClass('frm-desactivar-limites');
                        
                        $('#respuesta-monto').removeClass('received-msg-autocontrol');
                        $('#respuesta-autoexclusion').removeClass('received-msg-autocontrol');
                        
                        $('#soles').val('');
                        setDefaultSelectedValue('hours');
                    	
                    } else if (a.message === 'ERROR_POR_FECHA') {
                        jAlert(a.info, "Importante");
                        $('#soles').val('');
                        setDefaultSelectedValue('hours');
                    } else {
                        jAlert(a.info, "Importante");
                        $('#soles').val('');
                        setDefaultSelectedValue('hours');
                    }
                }
            })
        	
        }
        
        
    });
    
    $('#frm-define-autoexclusion').on('submit', function(event) {
        event.preventDefault();
        var $frm = $(this);
        // Serializar los datos del formulario
        var formData = $frm.serialize();
        // Agregar datos adicionales al objeto formData
        formData += '&type=POR_AUTOEXCLUSION&value-autoexclusion=1';
        
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: formData,
            dataType: $(this).data('responseType'),
            success: function(a) {
                if (a.message === 'OK') {
                    $('#autoexclusion-control-message').text( ' desde el ' + a.lastDate);                          
                    $('#respuesta-autoexclusion').addClass('received-msg-autocontrol');
                    
                    $('#frm-disable-autoexlusion').addClass('frm-desactivar-limites');
                    $('#frm-disable-hours').addClass('frm-desactivar-limites');
                    $('#frm-disable-monto').addClass('frm-desactivar-limites');
                    
                    $('#respuesta-monto').removeClass('received-msg-autocontrol');
                    $('#respuesta-hours').removeClass('received-msg-autocontrol');
                    
                    $('#soles').val('');
      
                    
                } else if (a.message === 'ERROR_POR_FECHA') {
                    jAlert(a.info, "Importante");
                    $('#soles').val('');
                    
                } else {
                    jAlert(a.info, "Importante");
                    $('#soles').val('');
                }
            }
        });
        
        setDefaultSelectedValue('hours');
    });
    
    
    $('#frm-disable-hours').on('submit', function(event) {
        event.preventDefault();
     // Serializar los datos del formulario
        var formData = '&type=POR_HORAS&hours=0';
 
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: formData,
            dataType: $(this).data('responseType'),
            success: function(a) {
                if (a.message === 'OK') {
                	console.log("disable hours ok");
                	$('#frm-disable-hours').addClass('frm-desactivar-limites');
                	$('#respuesta-hours').removeClass('received-msg-autocontrol');

                } 
                
            }
        });
        
        $('#soles').val('');
        setDefaultSelectedValue('hours');
        
    });
    
    $('#frm-disable-monto').on('submit', function(event) {
        event.preventDefault();
        // Serializar los datos del formulario
        var formData = '&type=POR_MONTO&soles=0';
        
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: formData,
            dataType: $(this).data('responseType'),
            success: function(a) {
                if (a.message === 'OK') {
                	
                	console.log("disable monto ok");
                	$('#frm-disable-monto').addClass('frm-desactivar-limites');
                	$('#respuesta-monto').removeClass('received-msg-autocontrol');     
                	
                } 
               
            }
        });
        
        $('#soles').val('');
        setDefaultSelectedValue('hours');
    });
    
    
    $('#frm-disable-autoexlusion').on('submit', function(event) {
        event.preventDefault();
     // Serializar los datos del formulario
        var formData = '&type=POR_AUTOEXCLUSION&value-autoexclusion=0';
        
        $.ajax({
            url: $(this).attr('action'),
            type: $(this).attr('method'),
            data: formData,
            dataType: $(this).data('responseType'),
            success: function(a) {
                if (a.message === 'OK') {
                	
                	console.log("disable autoexlusion ok");
                	$('#frm-disable-autoexlusion').addClass('frm-desactivar-limites');
                	$('#respuesta-autoexclusion').removeClass('received-msg-autocontrol');   
                	
                	
                } 
               
            }
        });
        $('#soles').val('');
        setDefaultSelectedValue('hours');
    });
    
    
    
};

$($selfControl);

$("#soles").on("keypress", function (e) {
    var soles = $("#soles").val(); 

    if(e.key == '.' && soles.includes('.')){
        e.preventDefault();
        return;
    }
    var numeros = /^[0-9\.]+$/;
    if(!(e.key).match(numeros)){
        e.preventDefault();
        return;
    }
    var nuevoValor = soles + e.key;
    if(!numeros.test(e.key) && e.key !== '.') {
        return;
    }

});

//Funcion para establecer resetear el valor en combobox hours
function setDefaultSelectedValue(selectId) {
    var selectElement = document.getElementById(selectId);
    selectElement.selectedIndex = 0;
}


