;
var v_content_object;
var $Kinelo = function() {   
	var costoTotalBetNor=0;
    $('#back_previous').remove();
    $("#menu-item-4").addClass("current-menu-item");  
    $("#plays-1").addClass("active");
    var price = $("#price-message").html().replace('Costo por jugada:','').replace('.',' ');
    $("#price-message").html(price);
    var your_betJ1 = 0;
    var your_betJ2 = 0;
    var multiplier_J1 = 1;
    var multiplier_J2 = 1;
    var total_betJ1 = 0;
    var total_betJ2 = 0;
    var sum_betJ1 = 0;
    var sum_betJ2 = 0;
    var earn_upJ1 = 0;
    var earn_upJ2 = 0;
    var sum_bet = 0;
    var total_bet = 0;   
    var array_betJ1 = [];
    var array_betJ2 = [];
    var array_numbers_more = [];
    var array_numbers_less = [];
    var array_markedJ1 = [];
    var array_markedJ2 = [];
    var object_ticket=[];
    var content_object_2=[];
    var new_object_ticket=[];
    var costoTotalBet = 0;
    var status = $('#status').val();
    var numbers_more = $('#numbersMore').val();
    var numbers_less = $('#numbersLess').val();
    var simple_bet_price = $('#simpleBetPrice').val();
    var algorithm = $('#algorithm').val();
    var bets = $('#bets').val();
    var pay = $('#pay').val();
    var draws = $('#draws').val();
    var cost = $('#cost').val();
    array_numbers_more = numbers_more.split(' ');
    array_numbers_less = numbers_less.split(' ');
    
    $('#J2').addClass('hide_play');
    $('.finalize-purchase').hide();    
    $('#arrow-image').on('click', function() {
        if(status=='ACT'){
            if ($(this).hasClass('arrow-next')) {
                $('#J1').removeClass('show_play').addClass('hide_play');
                $('#J2').removeClass('hide_play').addClass('show_play');
                $(this).removeClass().addClass('arrow-back');
                $('#arrow-warning').removeClass().addClass('warning-back');
            } else if ($(this).hasClass('arrow-back')) {
                $('#J2').removeClass('show_play').addClass('hide_play');
                $('#J1').removeClass('hide_play').addClass('show_play');
                $(this).removeClass().addClass('arrow-next');
                $('#arrow-warning').removeClass().addClass('warning-next');
            }
        }
    });
    $('.box-current-game').on('click', function(e){
        if(status=='ACT'){
            var game = $(this).data('game');
            if (game == "a") {
                $('#J1').removeClass('hide_play').addClass('show_play');
                $('#J2').removeClass('show_play').addClass('hide_play');
            } else if (game == "b") {
                $('#J1').removeClass('show_play').addClass('hide_play');
                $('#J2').removeClass('hide_play').addClass('show_play');
            }
        }
    });
    if(status=='CIE'){
        disabled_game();
    }
    $('#table-of-prize').on('click',function(){
        openPreviewWindowTableKinelo(); 
    });
    $('.checkYBA').on('click', function() {
        if(status=='ACT'){
            var play = $(this).attr('id').substr(0, 2);
            var your_bet = parseInt($(this).val());
            var label = $('label[for=' + $(this).attr('id') + ']');
            $('#' + play).find('.checkYBA').not($(this)).prop('checked', false);
            $('#' + play).find('.LcheckYBA').not(label).removeClass('colorChecked');
            label.toggleClass('colorChecked');
        
            if (play == 'J1') {
                if ($(this).is(':checked')) {
                    your_betJ1 = your_bet;
                } else {
                    your_betJ1 = 0;
                    clear(play);
                    jAlert('Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.', null);
                    datalayerErrores('Jugada','Paso 1','Jugar','Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.');
                }
            } else {
                if ($(this).is(':checked')) {
                    your_betJ2 = your_bet;
                } else {
                    your_betJ2 = 0;
                    clear(play);
                    jAlert('Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.', null);
                    datalayerErrores('Jugada','Paso 1','Jugar','Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.');
                }
            }
            your_bet = parseInt($(this).val());
            var count = update_array_bet(play);
            if (count > your_bet) {
                clear(play);
                $(this).prop('checked', true);
                label.addClass('colorChecked');
                if (play == 'J1') {
                    your_betJ1 = your_bet;
                }
                else{
                    your_betJ2 = your_bet;                    
                }
            }
          }
    });
    $('.checkYBB').on('click', function() {
        if(status=='ACT'){
            var play = $(this).attr('id').substr(0, 2);
            var label = $('label[for=' + $(this).attr('id') + ']');
            $('#' + play).find('.checkYBB').not($(this)).prop('checked', false);
            $('#' + play).find('.LcheckYBB').not(label).removeClass('colorChecked');
            label.toggleClass('colorChecked');
            if (play == 'J1') {
                if ($(this).is(':checked')) {
                    multiplier_J1 = $(this).val();
                } else {
                    multiplier_J1 = 1;
                }
            } else {
                if ($(this).is(':checked')) {
                    multiplier_J2 = $(this).val();
                } else {
                    multiplier_J2 = 1;
                }
            }
            calculate_bet(play);
           }
        });
    $('.check').on('click', function() {
        if(status=='ACT'){
            var id = $(this).attr('id');
            var play = id.substr(0, 2);
            var count = 0;
            var your_bet = 0;
            your_bet = find_your_bet(play);
            if (your_bet > 0) {
                if ($(this).is(':checked')) {
                    $(this).prop('checked', true);
                    count = update_array_bet(play);
                    if (count <= your_bet) {
                        $('#L' + id).addClass('colorChecked');
                        add_array_marked(play, $(this).val());
                    } else {
                        $(this).prop('checked', false);
                        jAlert('Se ha completado tu apuesta. Has elegido acertar un máximo de ' + your_bet + ' números', null);
                        datalayerErrores('Jugada','Paso 1','Jugar','Se ha completado tu apuesta. Has elegido acertar un máximo de ' + your_bet + ' números');
                    }
                } else {
                    $(this).attr('checked', false);
                    $('#L' + id).removeClass('colorChecked');
                    update_array_bet(play);
                    delete_array_marked(play, $(this).val());
                }
            } else {
                jAlert('Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.', null);
                datalayerErrores('Jugada','Paso 1','Jugar','Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.');
            }
            calculate_bet(play);
           }
    });
    $('.random').on('click', function() {
        if(status!='ACT')
        	return;
        
            var val = 0;
            var your_bet = 0;
            var count_random = 0;
            var play = $(this).attr('id').substr(0, 2);
            var your_bet = find_your_bet(play);
            var array_marked = find_array_marked(play);
            if (your_bet < array_marked.length) {
                array_marked = [];
            }
            if (your_bet == 0) {
                $('#' + play).find('.checkYBA').prop('checked', false);
                $('#' + play).find('.LcheckYBA').removeClass('colorChecked');
                your_bet = Math.floor(Math.random() * (10 - 1 + 1)) + 1;
                $('#' + play).find('#' + play + 'YBAcheck_' + your_bet).prop('checked', true);
                $('#' + play).find('#L' + play + 'YBAcheck_' + your_bet).addClass('colorChecked');
            }
            if (array_marked.length > 0) {
                clear_unmarket(play);
            } else {
                $('#' + play).find('.check').prop('checked', false);
                $('#' + play).find('.check_').removeClass('colorChecked');
            }
            while (array_marked.length + count_random < your_bet) {
                var random = Math.floor(Math.random() * (80 - 1 + 1)) + 1;
                $('#' + play).find('.check').each(function() {
                    if (random == $(this).val() && !$(this).is(':checked')) {
                        $(this).prop('checked', true);
                        $('#L' + $(this).attr('id')).addClass('colorChecked');
                        count_random++;
                    }
                });
            }
            update_array_marked(play, array_marked);
            update_your_bet(play, your_bet);
            update_array_bet(play);
            calculate_bet(play);
            try {
            tagginAlAzar("Kinelo");				
        	datalayerJugada(this,'Elige tu Jugada');
    			} catch (e) {
    				console.error(e);
    			}

        
    });
    $('.clear').on('click', function() {
        if(status!='ACT') return;
        
            var play = $(this).attr('id').substr(0, 2);
            clear(play);
        
        if(dataLayerlimpiar){
        	datalayerJugada(this,'Elige tu Jugada');
        }
        
    });
    $('.more').on('click', function() {
        if(status=='ACT'){
            var play = $(this).attr('id').substr(0, 2);
            clear(play);
            var your_bet = array_numbers_more.length;
            $('#' + play).find('#' + play + 'YBAcheck_' + your_bet).prop('checked', true);
            $('#' + play).find('#L' + play + 'YBAcheck_' + your_bet).addClass('colorChecked');
            $('#' + play).find('.check').each(function() {
                var val = $(this).val();
                for ( var i = 0; i < array_numbers_more.length; i++) {
                    if (val == array_numbers_more[i]) {
                        $('#' + play).find('#' + play + 'check_' + val).prop('checked', true);
                        $('#' + play).find('#L' + play + 'check_' + val).addClass('colorChecked');
                    }
                }
            });
            update_your_bet(play, your_bet);
            update_array_bet(play);
            calculate_bet(play);
         }
    });
    $('.less').on('click', function() {
        if(status=='ACT'){
            var play = $(this).attr('id').substr(0, 2);
            clear(play);
            var your_bet = array_numbers_less.length;
            $('#' + play).find('#' + play + 'YBAcheck_' + your_bet).prop('checked', true);
            $('#' + play).find('#L' + play + 'YBAcheck_' + your_bet).addClass('colorChecked');
            $('#' + play).find('.check').each(function() {
                var val = $(this).val();
                for ( var i = 0; i < array_numbers_less.length; i++) {
                    if (val == array_numbers_less[i]) {
                        $('#' + play).find('#' + play + 'check_' + val).prop('checked', true);
                        $('#' + play).find('#L' + play + 'check_' + val).addClass('colorChecked');
                    }
                }
            });
            update_your_bet(play, your_bet);
            update_array_bet(play);
            calculate_bet(play);
        }
    });

    $("#mySelectBox").on("change", function() {      
        if(status=='ACT'){
            var play = '';
            if ($('#J1').hasClass('show_play')) {
                play = 'J1';
            } else {
                play = 'J2';
            }
            calculate_bet(play);
        }
    });
    function disabled_game() {
        $('#J1').addClass('opacity');  
        $('#right-arrow').addClass('opacity');        
        $('.selectBox').addClass('opacity');
        $('.font').addClass('opacity');        
    }
    function clear(play) {
        $('#' + play).find('.check_').removeClass('colorChecked');
        $('#' + play).find('.check').prop('checked', false);
        $('#' + play).find('.LcheckYBA').removeClass('colorChecked');
        $('#' + play).find('.checkYBA').prop('checked', false);
        $('#' + play).find('.LcheckYBB').removeClass('colorChecked');
        $('#' + play).find('.checkYBB').prop('checked', false);
        $('#earn_up').html(0);
        if (play == 'J1') {
            your_betJ1 = 0;
            multiplier_J1 = 1;
            array_betJ1 = [];
            array_markedJ1 = [];
        } else {
            your_betJ2 = 0;
            multiplier_J2 = 1;
            array_betJ2 = [];
            array_markedJ2 = [];
        }
        update_array_bet(play);
        calculate_bet(play);
    }

    function update_array_bet(play) {
        var count = 0;
        var array_bet = [];  
        if(play=='J1'){
            array_betJ1 = [];
        }
        else{
            array_betJ2 = [];
        }       
        $('#' + play).find('.check').each(function() {
            if ($(this).is(':checked')) {
                if (play == 'J1') {
                    array_betJ1.push($(this).val());
                    array_bet = array_betJ1;
                } else {
                    array_betJ2.push($(this).val());
                    array_bet = array_betJ2;
                }
                count++;
            }
        });
        show_array(play, array_bet);
        return count;
    }

    function calculate_bet(play) {
        var draw = 0;
        if($('#mySelectBox').val()!=undefined){
            draw = parseInt($('#mySelectBox').val());
        } else {
            draw = 1;
        }
        var total_earn_up = 0;
        var count = update_array_bet(play);
        var your_bet = find_your_bet(play);
        var val_earn_up = find_earn_up(your_bet);
        if (play == 'J1') {
            if (count > 0 && count == your_bet) {
                total_betJ1 = (simple_bet_price * multiplier_J1);
                sum_betJ1 = 1;
                if (your_bet == 9) {
                    if (multiplier_J1 > 20) {
                        earn_upJ1 = 25 * val_earn_up;
                    } else {
                        earn_upJ1 = multiplier_J1 * val_earn_up;
                    }
                } else if (your_bet == 10) {
                    if (multiplier_J1 > 5) {
                        earn_upJ1 = 10 * val_earn_up;
                    } else {
                        earn_upJ1 = multiplier_J1 * val_earn_up;
                    }
                } else {
                    earn_upJ1 = multiplier_J1 * val_earn_up;
                }
            } else {
                total_betJ1 = 0;
                earn_upJ1 = 0;
                sum_betJ1 = 0;
            }
        } else {
            if (count > 0 && count == your_bet) {
                total_betJ2 = (simple_bet_price * multiplier_J2);
                sum_betJ2 = 1;
                if (your_bet == 9) {
                    if (multiplier_J2 > 20) {
                        earn_upJ2 = 25 * val_earn_up;
                    } else {
                        earn_upJ2 = multiplier_J2 * val_earn_up;
                    }
                } else if (your_bet == 10) {
                    if (multiplier_J2 > 5) {
                        earn_upJ2 = 10 * val_earn_up;
                    } else {
                        earn_upJ2 = multiplier_J2 * val_earn_up;
                    }
                } else {
                    earn_upJ2 = multiplier_J2 * val_earn_up;
                }
            } else {
                total_betJ2 = 0;
                earn_upJ2 = 0;
                sum_betJ2 = 0;
            }
        }
        total_bet = (total_betJ1 + total_betJ2) * draw;
        costoTotalBetNor=(total_betJ1 + total_betJ2) * draw;
        total_earn_up = earn_upJ1 + earn_upJ2;
        if(total_earn_up>1000000){total_earn_up=1000000;}
        sum_bet = sum_betJ1 + sum_betJ2;
        $('#total_bet').html(sum_bet);
        $('#total_apagar').html(floatFormat(total_bet));
        $('#earn_up').html(floatFormat(total_earn_up));
    }   
    function find_earn_up(your_bet) {
        var earn_up = 0;
        switch (parseInt(your_bet)) {
        case 1:
            earn_up = 3;
            break;
        case 2:
            earn_up = 6;
            break;
        case 3:
            earn_up = 25;
            break;
        case 4:
            earn_up = 120;
            break;
        case 5:
            earn_up = 380;
            break;
        case 6:
            earn_up = 2000;
            break;
        case 7:
            earn_up = 5000;
            break;
        case 8:
            earn_up = 20000;
            break;
        case 9:
            earn_up = 50000;
            break;
        case 10:
            earn_up = 100000;
            break;
        }
        return earn_up;
    }

    function find_your_bet(play) {
        if (play == 'J1') {
            return your_betJ1;
        } else {
            return your_betJ2;
        }
    }

    function update_your_bet(play, your_bet) {
        if (play == 'J1') {
            your_betJ1 = your_bet;
        } else {
            your_betJ2 = your_bet;
        }
    }

    function show_array(play, array_bet) {
        array_bet.sort(function(a, b) {
            return b - a;
        });
        array_bet.reverse();
        $("#" + play + "-text-area").val(array_bet);
    }

    function add_array_marked(play, val) {
        if (play == 'J1') {
            for (i = 0; i < array_markedJ1.length; i++) {
                if (array_markedJ1[i] == val) {
                    return;
                }
            }
            array_markedJ1.push(val);
            return;
        } else {
            for ( var i = 0; i < array_markedJ2.length; i++) {
                if (array_markedJ2[i] == val) {
                    return;
                }
            }
            array_markedJ2.push(val);
            return;
        }

    }

    function delete_array_marked(play, val) {
        if (play == 'J1') {
            for ( var i = 0; i < array_markedJ1.length; i++) {
                if (array_markedJ1[i] == val) {
                    array_markedJ1.splice(i, 1);
                }
            }
        } else {
            for ( var i = 0; i < array_markedJ2.length; i++) {
                if (array_markedJ2[i] == val) {
                    array_markedJ2.splice(i, 1);
                }
            }
        }
    }

    function find_array_marked(play) {
        if (play == 'J1') {
            return array_markedJ1;
        } else {
            return array_markedJ2;
        }
    }

    function update_array_marked(play, array_marked) {
        if (play == 'J1') {
            array_markedJ1 = array_marked;
        } else {
            array_markedJ2 = array_marked;
        }
    }

    function clear_unmarket(play) {
        var count = 0;
        var op = false;
        var array_marked = find_array_marked(play);
        $('#' + play).find('.check').each(function() {
            var val = $(this).val();
            for ( var i = 0; i < array_marked.length; i++) {
                if (val == array_marked[i]) {
                    op = true;
                    break;
                }
                op = false;
            }
            if (!op) {
                $(this).prop('checked', false);
                $('#L' + $(this).attr('id')).removeClass('colorChecked');
            }
        });
    }
    /**************************Buying Process************************************/
    var thisBtnComprarBoletoKinelo = null;
    $('#btn_desktop_comprar_boleto_kinelo').on('click', function() {
    	thisBtnComprarBoletoKinelo = this;
    	// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
    	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
    	mainValidatePendingsDocsForAproval('lottoKineloComprarBoletoKinelo');
    });  
         
   $('#more_plays').on('click',function(){       
       your_betJ1 = 0;
       your_betJ2 = 0;
       multiplier_J1 = 1;
       multiplier_J2 = 1;
       total_betJ1 = 0;
       total_betJ2 = 0;
       sum_betJ1 = 0;
       sum_betJ2 = 0;
       earn_upJ1 = 0;
       earn_upJ2 = 0;
       sum_bet = 0;
       total_bet = 0;   
       array_betJ1 = [];
       array_betJ2 = [];
       array_markedJ1 = [];
       array_markedJ2 = [];
       $('#mySelectBox').val('1');
       $('#box').text('1 sorteo');
       dataLayerlimpiar = false;
       $(".clear").click();
       dataLayerlimpiar = true;
       //
       $('#mySelectBox option').prop('selected', function() {
           return this.defaultSelected;
           });
       $('.step-play').removeClass('step-active');
       $('.step-status-1').addClass('step-active');
       $('.wrapper-playing').show();
       $('#iframe-kinelo').show();
       $('.wrapper-buying').hide();
       $('.box-current-game').removeClass('game-played');
       $('div[data-game="a"]').click();
       
       $('#total_apagar').html('0');
       costoTotalBet = 0;
       datalayerFinalizaCompra2(this,'Agregar Jugadas');
   });     
   $('.left-panel').on('click','.process-delete1',function(){
       var row=parseInt($(this).attr("rel"));
       
       let jugadaKinelo = [content_object_2[row][0],content_object_2[row][1],null,null];
       let precioUnitario = (content_object_2[row][5]) / (content_object_2[row][6] * content_object_2[row][3]) ;
       precioUnitario = parseFloat($("#simpleBetPrice").val());
       datalayerRemoveFromCart(jugadaKinelo,precioUnitario);
       
       tagginKineloEEremoveFromCart(content_object_2[row][4])
       content_object_2.splice(row,1);
       tickets_grid(content_object_2);
       paged_grid(content_object_2);  
      
       //object_ticket=content_object_2;
       if(content_object_2.length==0){
           $('#more_plays').click();
       } 
       calculate_total_cost(content_object_2);
       
       
   });            
   $('.left-panel').on('mouseover','.row-info',function(){
       var row = $(this).attr('rel');
       row=parseInt(row);
       var content_info = '';
       var nom_jugadas = ['<b>A</b>','<b>B</b>'];                            
       for(var i=0;i<2;i++){
           if ($.trim(object_ticket[row][i]) != 'null'){
                 var result_ticket = ''; 
                 result_ticket+=object_ticket[row][i];                             
                 content_info += nom_jugadas[i] + ': ' + result_ticket + '<br>';                               
           }                    
       }      
      $('.tooltip-info').eq(row).show();
      $('.tooltip-info').eq(row).html(content_info); 
      $('.tooltip-info-arrow-img').eq(row).show();  
    }).on('mouseout','.row-info',function(){
       var row=$(this).attr('rel'); 
       $('.tooltip-info').eq(row).hide();
       $('.tooltip-info-arrow-img').eq(row).hide();  
    }); 
   $('.left-panel').on('mouseover','.no-process',function(){
       var contenido_total = $(this).attr('rel');
       var contenido_temp = (contenido_total + '').split('#');
       var posicion = parseInt(contenido_temp[0]);
       var mensaje = (contenido_temp[1] + "").replace(/\*/g,"<br/>");
       $('.tooltip-no-process').eq(posicion).show();
       $('.tooltip-no-process').eq(posicion).html(mensaje);
       $('.tooltip-no-process-arrow-img').eq(posicion).show();
   }).on('mouseout','.no-process',function(){
       var contenido_total = $(this).attr('rel');
       var contenido_temp = contenido_total.split('#');
       var posicion = parseInt(contenido_temp[0]);
       var mensaje = contenido_temp[1];
       $('.tooltip-no-process').eq(posicion).hide();
       $('.tooltip-no-process').eq(posicion).html(mensaje);
       $('.tooltip-no-process-arrow-img').eq(posicion).hide();
   });
   $('.left-panel').on('click','.lnk-pag1',function(){
       var cadena_pos=$(this).attr('rel');
       var id=$(this).attr('id');
       var posiciones=cadena_pos.split('-');                
       $('.row_grid').removeClass('row_null');
       $('.row_grid').addClass('row_null');                
       for(var num in posiciones){
       $('.row_grid').eq(posiciones[num]).removeClass('row_null');    
       }
       $('.indice_page').html($('#'+id).html());
       $('.lnk').removeClass('num_page_on');
       $('.lnk').removeClass('num_page_off');
       $('.lnk').addClass('num_page_on');
       $('#'+$(this).attr('id')).removeClass('num_page_on');
       $('#'+$(this).attr('id')).addClass('num_page_off');
   });             
   $('.left-panel').on('click','.lnk-pag2',function(){
       var cadena_pos=$(this).attr('rel');
       var id=$(this).attr('id');
       var posiciones=cadena_pos.split('-');                
       $('.row_grid').removeClass('row_null');
       $('.row_grid').addClass('row_null');                
       for(var num in posiciones){
       $('.row_grid').eq(posiciones[num]).removeClass('row_null');    
       }
       $('.indice_page').html($('#'+id).html());
       $('.lnk').removeClass('num_page_on');
       $('.lnk').removeClass('num_page_off');
       $('.lnk').addClass('num_page_on');
       $('#'+$(this).attr('id')).removeClass('num_page_on');
       $('#'+$(this).attr('id')).addClass('num_page_off');
   });
   
   $('.label_2').html(fecha_actual());
   $('#game-code-header').val(1121);
   var thisBtnFinalizarCompraBoletoKinelo = null;
   $('#btn_desktop_finalizar_compra_kinelo').on('click',function(){
	    thisBtnFinalizarCompraBoletoKinelo = this;
		// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
		// es una function que se realizará en caso no tenga docs pendientes de confirmacion
		mainValidatePendingsDocsForAproval('lottoKineloFinalizarCompraKinelo');
   });
   
   $('#option-card-0').on('click',function(){
       $("#panel_transaccion_1").css("display","");
       $("#panel_transaccion_2").css("display","");
       $("#panel_transaccion_3").css("display","");
       $("#panel_transaccion_4").css("display","");
       $("#panel_transaccion_5").css("display","");
       $('.finalize-purchase').css({"height":"464px"});
   });
   $('#option-card-1').on('click',function(){
        $("#panel_transaccion_1").css("display","block");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","");
        $("#panel_transaccion_4").css("display","");
        $("#panel_transaccion_5").css("display","");
        $('.finalize-purchase').css({"height":"521px"});
   });
   $("#option-card-2").click(function(){
        $("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","block");
        $("#panel_transaccion_3").css("display","");
        $("#panel_transaccion_4").css("display","");
        $("#panel_transaccion_5").css("display","");
        $('.finalize-purchase').css({"height":"552px"});
    });

    $("#option-card-3").click(function(){
        $("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","block");
        $("#panel_transaccion_4").css("display","");
        $("#panel_transaccion_5").css("display","");
        $('.finalize-purchase').css({"height":"561px"});
    });
    
    $("#option-card-4").click(function () {
        $("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","");
        $("#panel_transaccion_4").css("display","block");
        $("#panel_transaccion_5").css("display","");
        $('.finalize-purchase').css({"height":"568px"});
    })
    
    $("#option-card-5").click(function () {
        $("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","");
        $("#panel_transaccion_5").css("display","block");
        $("#panel_transaccion_4").css("display","");
        $('.finalize-purchase').css({"height":"623px"});
    })
    
    
    $("#pagoEfecHelp").click(function(e) {
    var pagoEfectivoHelp="layer-view-interface/client/como_funciona_pagoefectivo.jsp";
    dhtmlwindow.open('resultbox', 'iframe',pagoEfectivoHelp, '¿Cómo funciona PagoEfectivo?', 'width=600,height=635px,scrolling=0,center=1,resize=0', 'recal');
    });
        
     $('#tab-item_5').on('click', function () {
        var content = '<div class="ajax-loader"></div>' + '<div>' + '<div id="scroll-grid">' + '<div id="grilla"></div>' + '</div></div>' + '<div id="num_link_cc"></div>';
        $('.tab-intro').eq(4).html(content);
        $('.ajax-loader').show();
        $.ajax({type: 'POST', url: 'clientBalance_find_idClient.html', dataType: 'text', success: function (e) {
            $('.ajax-loader').hide();
            if (e != "") {
                var rowClientResult = e.split('#');
                for (var i in rowClientResult) {
                    var columnClientResult = (rowClientResult[i] + '').split('|');
                    var rows = [];
                    for (var j in columnClientResult) {
                        rows.push(columnClientResult[j]);
                    }
                    dataClientResult.push(rows);
                }
                run.grilla(dataClientResult);
                run.grilla_paginada(dataClientResult);
                dataClientResult = [];
            }            
        }})
    });

    
    $('#keep-playing').on('click', function(event){
        event.preventDefault();            
     }); 
    $('#game-history').on('click',function(event){
        event.preventDefault();
    });
   var array_no_procesados=[];
   $('.left-panel').on('click','#btn-no-process',function(){
       var contador=0;
       for(var i in new_object_ticket){
           var procesos=(new_object_ticket[i][2]+'').split('&');      
           if(procesos[1]=='null'){
//               array_no_procesados.push(new_object_ticket[i]);
               array_no_procesados.push(object_ticket[i]);
               contador++;
           }   
       }
       $('#panel_keep-playing').hide();
       $('#panel_game-history').hide();
       $('#ico-block').hide();
       $('#panel_finaliza_compra').show();
       $('#panel_more_plays').show();
       $('#sub_panel').show();
       $('.left-panel').html('');
       $('#keep-playing').on('click', function(event){
           event.preventDefault();            
        });
       $('#game-history').on('click',function(event){
           event.preventDefault();
       });
       var temp_jugada_2="<span class='label_1'>SUPER 3</span>"
                           +"<div id='content-grid-result'></div>"
                           +"<div id='num_link'></div>";   
       $('.left-panel').html(temp_jugada_2);
       if(status=='ACT'){            
                   $('#start_play').hide();
                   $('#help-part1').hide();         
                   $('.finalize-purchase').show();
                   var cant_sorteo = 0;                            
                   if($('#mySelectBox').val()!=undefined){
                       cant_sorteo = parseInt($('#mySelectBox').val());
                   } else {
                       cant_sorteo = 1;
                   }
                   object_ticket=[];
                   object_ticket=array_no_procesados;                          
                   array_no_procesados=[];
                   new_object_ticket=[];                            
                   tickets_grid(object_ticket);
                   paged_grid(object_ticket);                      
                   dataLayerlimpiar = false;
                   $(".clear").click();
                   dataLayerlimpiar = true;
                   var costo_total=0;
                   for(var i in object_ticket){
                       costo_total+=parseFloat(object_ticket[i][4]);
                   }
                   $('.result1').html('S/ '+floatFormat(costo_total));
                   $("#totalPagar").text(costo_total);
                   $('.result2').html('S/ '+parseFloat($('#simpleBetPrice_repeated').val()));
                   $('.label_resu1').html('TOTAL A PAGAR:');
                   

                   //********
                   var idsession = $("#clientId").val();
                   if($.trim(idsession) != '') {
   		         
	   		         if($('.result5').text()==""){
	               	  $('.result5').html( (!isNaN($('#balanceQuantityGame').val()))?$('#balanceQuantityGame').val():"0" );
	               	}
   		      		$('.label_resu5').html("Jugadas gratis*:");             		   
   		          	$('.labelMsgJugadaGratis').html("* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto");
   		          	
   		          	/*if(costo_total <= $('#balanceAmountGame').val()){
   		          		$(".result1").html("S/ 0");
   		          		$(".label_resu2").html("S/ 0");
   	                } */  
                   } else {
               	   $('.result5').html("");
               	   $('.label_resu5').html("");
               	   $('.labelMsgJugadaGratis').html("");
                  }	
                   //*******
                   
           }
   });
   var idsession=$('#clientId').val();
   if(idsession != '' && $("#agreement").val() == ''){
       $('#login_section').show();
       $('.img_zona_segura').css({"margin-top":"93px"});
       $('.finalize-purchase').css({"height":"369px"});
       exe.opentyc(null);
   } else if(idsession==''){
       $('#login_section').show();
       $('.img_zona_segura').css({"margin-top":"93px"});
       $('.finalize-purchase').css({"height":"369px"});
   }else{
       $('#login_section').hide();
       $('#panel_finaliza_compra').show();
       $("#panel_finaliza_compra").css("display","block");
       $("#tab-item_4").show();
       $('#payments_section').show();
       $('.finalize-purchase').css({"height":"458px"});
       $('.img_zona_segura').css({"margin-top":"0px"});
   } 
   
   function finalizarCompraKinelo () {
	   var option = $('[name=option-card]:checked').val();
       var pin = $('[name=pin-number]').val();
       var message = '';
       var amount = 0.0;
       var newamount = 0.0;
       var msgres = new Array();
       if(option == 0) {
           message = 'OK';
       } 
       message = message.replace(/_/g,' ');
       if(message == 'OK') {              
    	   
    	   datalayerFinalizaCompra2(thisBtnFinalizarCompraBoletoKinelo,'Finalizar Compra');
    	   let pos = content_object_2.length - 1;
    	   let jugadaKinelo = [content_object_2[pos][0],content_object_2[pos][1],null,null];
           let precioUnitario = (content_object_2[pos][5]) / (content_object_2[pos][6] * content_object_2[pos][3]) ;
           precioUnitario = parseFloat($("#simpleBetPrice").val());
    	   datalayerCheckout(jugadaKinelo,precioUnitario);
    	   
           if(object_ticket.length!=0){
               $('.left-panel').html('');
               var content_grid_2="<div class='label-top'></div>"
                   +"<div class='label_1'>KINELO</div>"
                   +"<div id='ajax-loader'>"
                   +"<img src='layer-view-image/game/kinelo/ajax-loader.gif'>"
                   +"</div><div id='content-grid-result'></div>"
                   +"<div id='num_link'></div>";
               content_grid_2+="<div id='game-no-process-info'></div>";               
               $('.left-panel').html(content_grid_2);                
               $('#panel_more_plays').hide();
               $('#panel_finaliza_compra').hide();
               $('#panel_keep-playing').show();
               $('#panel_game-history').show();
               $('#ico-block').show();
               $('.label-top').show();
               $('#sub_panel').hide();
               var row_ticket='';
               var ticketsAjax='';
               
               for(var m=0;m<object_ticket.length;m++){
                   object_ticket[m][2]='null';
               }
               for(var n=0;n<object_ticket.length;n++){
                   row_ticket=(object_ticket[n]).toString().replace(/,/g, "|");                            
                   ticketsAjax+=row_ticket+'-';                            
                   row_ticket='';
               }
               ticketsAjax=ticketsAjax.substr(0,ticketsAjax.length-1);
               $('#ajax-loader').show();
               
               $.ajax({
                   type:'POST',
                   url:'ajaxJugadasKinelo.html',
                   dataType: 'text',
                   data:'dato='+ticketsAjax,
                   success:function(e) {                           
                       var row=(e.toString()).split('#');
                       for(var i=0;i<row.length;i++){
                           var items=(row[i]+'').split('|');
                           var new_row_ticket=[];
                           for(var j=0;j<items.length;j++){
                               new_row_ticket.push(items[j]);
                           }
                           new_object_ticket.push(new_row_ticket);
                       }
                       
                       $('.label_resu3').html("<b>Saldo Disponible: <div class='text-detail-pay detail-pay-monto'>S/ " + floatFormat(new_object_ticket[(new_object_ticket.length-1)][8]) + "</div>");
                       var promotional_balance=parseFloat(new_object_ticket[(new_object_ticket.length-1)][9]);
                       if(promotional_balance>0){
                           $('.label_resu4').html("<b>Saldo Promocional: <div class='text-detail-pay detail-pay-monto'>S/ " + floatFormat(new_object_ticket[(new_object_ticket.length-1)][9]) + "</div>");                 
                       }                       
                       $('#clientSale-amount').text(floatFormat(new_object_ticket[(new_object_ticket.length-1)][8])); 
                       $('#clientSale-amount-2').text(floatFormat(new_object_ticket[(new_object_ticket.length-1)][8])); 
                       $('#ajax-loader').css('display','none');                                
                       tickets_grid2(new_object_ticket);
                       paged_grid2(new_object_ticket);
                       var costo_juego = parseFloat(new_object_ticket[(new_object_ticket.length-1)][10]);
                       var costo_otro = parseFloat(new_object_ticket[(new_object_ticket.length-1)][11]);
                       var costo_total = 0;
                       for(var t in new_object_ticket){                                    
                           var procesos=(new_object_ticket[t][2]+'').split('&');                                    
                           if(procesos[1]!='null'){
                               $('.label-top').html('&#161;GRACIAS POR TU COMPRA!');
                               costo_total += parseFloat(new_object_ticket[t][4]);
                               
                           }   
                       }
                       
                       var pendientes_gratis3 = $('#balanceAmountGame').val();
                       
                       var costo_total3 = 0
                       var gratis_total3 = 0
                      
                       for (var v in new_object_ticket) {
                       	var precio_cu3 = parseFloat(new_object_ticket[v][4]);
                       	   
                       	if(parseFloat(content_object_2[v][4])!=parseFloat(content_object_2[v][5])){
                       		var cadena=new_object_ticket[v][2];
                			var cadenaPa=cadena.substring(0, 2);
                			if(cadenaPa=="OK"){
                       		costo_total3 =parseFloat(costo_total3)+ parseFloat(precio_cu3);
                			}
                       	}   
                       	else{
                           if(parseFloat(precio_cu3) <= parseFloat(pendientes_gratis3)){
                           	gratis_total3 =parseFloat(gratis_total3)+ parseFloat(precio_cu3);
                           	pendientes_gratis3 = parseFloat(pendientes_gratis3)-parseFloat(precio_cu3);
                           } else {
                        	   var cadena2=new_object_ticket[v][2];
                   			var cadenaPa2=cadena2.substring(0, 2);
                   			if(cadenaPa2=="OK"){
                           	costo_total3 =parseFloat(costo_total3)+ parseFloat(precio_cu3);
                   			}
                           }
                           
                       	}
                       }  
                       
                       $('.result1').html('S/ '+floatFormat(costo_total3));                                         
                       $('.label_resu1').html('TOTAL PAGADO:');
                    	   $('.result5').html((!isNaN(costo_juego))?costo_juego:"0");
                    	   $('.label_resu5').html("Jugadas gratis:");
                    	   $('.labelMsgJugadaGratis').html("");
                       if(!isNaN(costo_otro)) $("#billetera3-amount").text(costo_otro);
                       $('#keep-playing').off('click');
                       $('#game-history').off('click');
                       
                       finalizaCompra2 = false;
                       
                       if(!$('.label-top').find('div').length){                    	
							
                       	tagginKineloCompraExitosa();
                       	tagginKineloEEpurchase(object_ticket, new_object_ticket);
							var cupon =  "undefined";
							
							if($("#priceType").val() !== 'NOR')
								cupon = $("#priceMessage").val();
							
							
							for(let pos=0;pos<content_object_2.length;pos++){
								
								var procesos=(new_object_ticket[pos][2]+'').split('&');
								
		                        if(procesos[1]=='null')
		                        	continue;
		                        
								let jugadaKinelo = [object_ticket[pos][0],object_ticket[pos][1],null,null];
								let precioUnitario = ( object_ticket[pos][5] ) / ( object_ticket[pos][6] * object_ticket[pos][3] ) ;
								precioUnitario = parseFloat($("#simpleBetPrice").val());
								datalayerPurchase(jugadaKinelo,
												precioUnitario,
												  '¡Gracias por tu Compra!',
												  costo_total3,
												  'Kinelo-'+procesos[1],
												  cupon);
							}
							
                       }
                   }
               });
           } else {
               jAlert('No se tiene jugadas por procesar', null);
               datalayerErrores('Finalizar tu Compra 2','Paso 3','Finalizar Compra','No se tiene jugadas por procesar');
           }
           if(option == 1) {
        	   jAlert('Se ha realizado una recarga de saldo.\n\nMonto cargado: S/ '+amount+'\nTu saldo es: S/ '+newamount, null);
           }
       } else {
           if(option == 1){
        	   jAlert('No se ha logrado realizar la recarga.\n'+message+'\n\nMonto cargado: S/ '+amount+'\nTu saldo es: S/ '+newamount, null);
        	   datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar','No se ha logrado realizar la recarga.\n'+message+'\n\nMonto cargado: S/ '+amount+'\nTu saldo es: S/ '+newamount);
           }
       }
   }
   
   function comprarBoletoKinelo() {
	   if (status != 'ACT') 
       	return;

       let message = '';
       if ( sum_bet <= 0 || total_bet <= 0 ) {
       	message = "No ha realizado ninguna jugada.";
       	showErrorAndAlert(message);
       	datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
       	return;
   			}

       if(your_betJ1>array_betJ1.length & your_betJ2>array_betJ2.length){
       	message = "Completa los números que quieres acertar en la Jugada A y B";
       	showErrorAndAlert(message);
       	datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
       	return;
   			}
       if(your_betJ1>array_betJ1.length){
       	message = "Completa los números que quieres acertar en la Jugada A";
       	showErrorAndAlert(message);
       	datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
       	return;
           }
       if(your_betJ2>array_betJ2.length){
       	message = "Completa los números que quieres acertar en la Jugada B";
       	showErrorAndAlert(message);
       	datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
       	return;
   			}

       
       datalayerFinalizaCompra1(thisBtnComprarBoletoKinelo,'Comprar');
       $("#index-btnlogin").prop("disabled",true);
       process_buy();
   }
   
   window.addEventListener("message", function(event) {
      if (event.data === "lottoKineloComprarBoletoKinelo") {
    	  comprarBoletoKinelo(); 
      } else if (event.data === "lottoKineloFinalizarCompraKinelo") {
    	  finalizarCompraKinelo(); 
      }
  });

   function process_buy() {
               $('.step-play').removeClass('step-active');
               $('.step-status-2').addClass('step-active');
               $('.wrapper-playing').hide();
               $('#iframe-kinelo').hide();
               $('.wrapper-buying').show();
       
               var row_ticket=[];
               var array_betJ1_2=[];
               var array_betJ2_2=[];              
       
       array_betJ1_2 = array_betJ1.map(function(element) {
    	   return element.length === 1 ? '0' + element : element;
    	});
    	
       array_betJ2_2 = array_betJ2.map(function(element) {
    	   return element.length === 1 ? '0' + element : element;
    	});
       
       
       var multiDraws = parseInt($('#mySelectBox').val()) || 1;
       
       
       var string_betJ1=array_betJ1.join(" ");
       var string_betJ2=array_betJ2.join(" ");
       
               if(string_betJ1.length==0){
                   row_ticket.push('null');
                   row_ticket.push(string_betJ2+" x "+multiplier_J2);                   
               }
               else if(string_betJ2.length==0){
                   row_ticket.push(string_betJ1+" x "+multiplier_J1);
                   row_ticket.push('null');
               }
               else{
                   row_ticket.push(string_betJ1+" x "+multiplier_J1);
                   row_ticket.push(string_betJ2+" x "+multiplier_J2);
               }              
       
               var precioNormal=costoTotalBetNor;
               row_ticket.push('null');
               row_ticket.push(multiDraws);   
               row_ticket.push(total_bet); 
               row_ticket.push(precioNormal);//ruth
               row_ticket.push($("#total_bet").text());
               object_ticket.push(row_ticket);              
               tickets_grid(object_ticket);
               
               content_object_2=object_ticket.sort(function(prev,next){
                   return next[6]-prev[6];
                   });   
               var pendientes_gratis=0;
               if($('.result5').text()!=""){
               	  pendientes_gratis = $('.result5').text()*precioNormal;
               }
               else{
               	 pendientes_gratis = $('#balanceAmountGame').val();
               }
               
               costo_total = 0
               var gratis_total = 0
              
               for (var v in content_object_2) {
               	var precio_cu = parseFloat(content_object_2[v][4]);
               	if(parseFloat(content_object_2[v][4])!=parseFloat(content_object_2[v][5])){        		
               		object_ticket[v][7]=(parseFloat(precio_cu));
            		costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
            	}else{
                   if(parseFloat(precio_cu) <= parseFloat(pendientes_gratis)){
                	   object_ticket[v][7]=0;
                   	gratis_total =parseFloat(gratis_total)+ parseFloat(precio_cu);
                   	pendientes_gratis = parseFloat(pendientes_gratis)-parseFloat(precio_cu);
                   } else {
                	   object_ticket[v][7]=(parseFloat(precio_cu));
                   	costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
                   }
            	 } 
               }
                 
               tagginKineloEEaddToCart(total_bet);
               paged_grid(content_object_2);
               $(".result1").html("S/ " + floatFormat(costo_total));
               $('.label_resu2').html($('#price-message').text());               
               calculate_total_cost(content_object_2);       
               var idsession = $("#clientId").val();
               if($.trim(idsession) != '') {
            	   if($('.result5').text()==""){
                 	  $('.result5').html( (!isNaN($('#balanceQuantityGame').val()))?$('#balanceQuantityGame').val():"0" );
                 	}
             	   $('.label_resu5').html("Jugadas gratis*:");  
             	   $('.labelMsgJugadaGratis').html("* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto");
		          	
               } else {
            	   $('.result5').html("");
            	   $('.label_resu5').html("");
            	   $('.labelMsgJugadaGratis').html("");
               }
               $('#mySelectBox').val('1');      
               v_content_object=object_ticket;
               tagginFinalizar();
               tagginKineloEEcheckout();
       
       let pos = content_object_2.length - 1;
       let jugadaKinelo = [content_object_2[pos][0],content_object_2[pos][1],null,null];
       let precioUnitario = (content_object_2[pos][5]) / (content_object_2[pos][6] * content_object_2[pos][3]) ;
       precioUnitario = parseFloat($("#simpleBetPrice").val());
       datalayerAddToCart(jugadaKinelo,precioUnitario);
       
   }
   function fecha_actual(){
	   
       var f = new Date();
       var mes="";
       var dia="";
       var temp_mes=(f.getMonth()+1)+"";
       var temp_dia=f.getDate()+"";                
       if(temp_mes.length==1){
           mes="0"+(f.getMonth()+1)+"";
       }
       else{mes=(f.getMonth()+1)+"";}                
       if(temp_dia.length==1){
           dia="0"+f.getDate()+"";
       }
       else{dia=f.getDate()+"";}                
       return dia+ "/" + mes + "/" + f.getFullYear();
   }
   function paged_grid(data){       
       var count_rows= data.length;
       if(count_rows>0){
       var links="";
       var cont=0;
       var style="";
       var posx=0;
       var posy=1;
       var posz=2;           
       for(var i=0;i<count_rows;i++){                    
       if(i==0){
       style="num_page_off"; 
       }
       else{
       style="num_page_on"; 
       }
           if(i%3==0){
               cont++;
               links+="&nbsp;<a class='lnk-pag1 lnk "+style+" ' id='"+posx+"-"+posy+"-"+posz+"' rel='"+posx+"-"+posy+"-"+posz+"' >"+cont+"</a>&nbsp;";
               posx=posx+3;
               posy=posy+3;
               posz=posz+3;       
           }
       }
      $('#num_link').html("<span class='indice_page'>1</span> de "+cont+"<span class='pages-links'><"+links+"></span>");
       }
       else{
        $('#num_link').html('');
       }
   }              
   function paged_grid2(data){
       var count_rows= data.length;
       var links="";
       var cont=0;
       var style="";
       var posx=0;
       var posy=1;
       var posz=2;                
       for(var i=0;i<count_rows;i++){                    
       if(i==0){
       style="num_page_off"; 
       }
       else{
       style="num_page_on"; 
       }
           if(i%3==0){
               cont++;
               links+="&nbsp;<a class='lnk-pag2 lnk "+style+" ' id='id"+posx+"_"+posy+"_"+posz+"i' rel='"+posx+"-"+posy+"-"+posz+"' >"+cont+"</a>&nbsp;";
               posx=posx+3;
               posy=posy+3;
               posz=posz+3;
           }
       }
      $('#num_link').html("<span class='indice_page'>1</span> de "+cont+"<span class='pages-links'><"+links+"></span>");
   }
   function tickets_grid(data){                
       var nom_jugadas=["<b>A</b>","<b>B</b>"];               
       var grilla="<div>"
                        +"<div class='boleto_cabecera'>"
                             +"<div class='head_title_1'>N.</div>"
                             +"<div class='head_title_2'>JUGADAS</div>"
                             +"<div class='head_title_3'>ANULAR</div>"
                        +"</div>";
                  +"<div id='total_filas'>";              
                  for ( var x in data){ 
                      for(var i=0;i<2;i++){
                         if ($.trim(data[x][i])!='null') { 
                                 var result_ticket="";
                                 var result_ticket = nom_jugadas[i] + ": ";                                        
                                 result_ticket+=data[x][i];
                                 break;                                     
                        }                       
                     }  
                      var style = "row_grid";
                      if (x % 2 != 0) {
                          style += " row_grid_mouseover";
                      }
                      if (x > 2) {
                          style += " row_null";
                      }
                      grilla += "<div class='"+style+"'>"
                      +"<div class='column_1'>"+(parseInt(x)+1)+"</div>"
                      +"<div class='column_2'>"+result_ticket.substring(0,25)+"&nbsp;&nbsp;<span class='row-info' rel='"+x+"'>[+]</span>"
                      +"<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>"
                      +"<div class='column_3'>"
                      +"<div class='delete process-delete1' rel='"+x+"'>x</div>"
                      +"</div>"
                      +"</div>"; 
                     }
                  grilla += "</div>";
                  $('#content-grid-result').html(grilla);  
   }            
   function tickets_grid2(data){                
       var nom_jugadas=["<b>A</b>","<b>B</b>"];   
       var no_process_message_count=0;
       var grilla="<div>"
                        +"<div class='boleto_cabecera'>"
                             +"<div class='head_title_1'>N.</div>"
                             +"<div class='head_title_2'>BOLETOS</div>"
                             +"<div class='head_title_3'>VER</div>"
                        +"</div>";                          
       var label="";
        for ( var x in data) { 
            for(var i=0;i<2;i++){
               if ($.trim(data[x][i])!='null') { 
                       var result_ticket='';
                       var result_ticket = nom_jugadas[i] + ": ";                                        
                       result_ticket+=data[x][i];
                       break;                                     
              }                       
           }              
                    var style="row_grid";
                    if(x%2!=0){
                        style+=" row_grid_mouseover";
                        }
                    if(x>2){
                     style+=" row_null";
                    }                             
                    var dato_proceso=(data[x][2]).split("&");
                    var process_resp="";                             
                    if(dato_proceso[1]=="null"){
                        process_resp="<div class='column3-no-process'><span class='no-process' rel='"+no_process_message_count+"#"+dato_proceso[0]+"'>No procesado&nbsp;&nbsp;[?]</span> </div>";
                        process_resp+="<div class='tooltip-no-process'></div><div class='tooltip-no-process-arrow-img'></div>";
                        no_process_message_count++;
                        
                        var relValue = dato_proceso[0]+ "";
                        var game_no_process_autocontrol = "";
                        // Verifica si mensaje de error contiene la palabra autoexclusion
                        if (relValue.includes("autoexclusion") || relValue.includes("autoexclusión") ) {
                           
                            game_no_process_autocontrol = "<div class='text-autocontrol' >Ir a la sección <a id='link-autocontrol'  href='mi-cuenta.html#yo-autocontrol'>Autocontrol</a></div>";
                        } 
                        
                    var game_no_process_info= "<div class='title-text text-autocontrol'>"
                    	+"<div>Tienes jugadas que no se han podido procesar.</div> " + game_no_process_autocontrol  + "  </div>"
                                +"<div id='no-process-section'><a href='#' class='button button-block button-dark-green' id='btn-no-process' onclick='return false;'><b>VOLVER</b></a></div>";
                    $("#game-no-process-info").html(game_no_process_info);
                    $(".label-top").html("<div class='no-process-play'>JUGADAS NO PROCESADAS</div>");
                    $("#game-no-process-info").css("display","block");
                    label=dato_proceso[0];
                        
                    }else{
                        process_resp="<div class='column3-codigo'>"+dato_proceso[1]+"</div><div class='column3-search' onclick='openPreviewWindow("+data[x][7]+",\""+data[x][6]+"\",\""+dato_proceso[1]+"\")'></div>";               
                    }
                    grilla += "<div class='"+style+"'>"
                             +"<div class='column_1'>"+data[x][5]+"</div>"
                             +"<div class='column_2'>"+result_ticket.substring(0,25)+"&nbsp;&nbsp;<span class='row-info' rel='"+x+"'>[+]</span>"
                             +"<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>"
                             +process_resp
                             +"</div>";    
                    
            }              
        grilla +="</div>";                 
        $('#content-grid-result').html(grilla);
        
        //taggin jugadas no procesadas
        if($(".label-top > div").text()==='JUGADAS NO PROCESADAS'){
        	tagginJugadaNoProcesada("Kinelo", label);
        }
   }
    function calculate_total_cost(dato){

    	  var pendientes_gratis=0;
          if($('.result5').text()!=""){
          	  pendientes_gratis = $('.result5').text()*simple_bet_price;
          }
          else{
          	 pendientes_gratis = $('#balanceAmountGame').val();
          }
    	  
          costo_total = 0
          var gratis_total = 0
          
          for (var v in dato) {
          	var precio_cu = dato[v][4];
          	if( dato[v][4]!= dato[v][5]){        		
          		costo_total = parseFloat(costo_total)+ parseFloat(precio_cu);
          	}
          	else{
              if(precio_cu <= pendientes_gratis){
              	gratis_total =gratis_total+ precio_cu;
              	pendientes_gratis = pendientes_gratis-precio_cu;
              } else {
              	costo_total =costo_total+ precio_cu;
              }
            }
              
          }
          $(".result1").html("S/ "+floatFormat(costo_total));
    }
    
    function viewNext(){
        $('#password-client-header').val('');
        $('#password-client').val('');
        $('.logout').show();
        $('.unlogout').hide();
        $("#tab-item_4").show();
        $('#payments_section').show();
        $('.finalize-purchase').css({"height":"458px"});
        $('.img_zona_segura').css({"margin-top":"0px"});
        $('#login_section').hide();
        $('#btn_desktop_finalizar_compra_kinelo').show();
        $('#panel_finaliza_compra').show();
    }
    
    function showErrorAndAlert(message) {
        try {
            tagginPopupError("Kinelo", message);
        } catch (e) {
            console.error(e);
        }

        jAlert(message, null);
    }
    
};
$($Kinelo);

function pagoEfectivoF(redireccion){
    $("#option-card-0").prop("checked", "checked");
    $("#panel_transaccion_1").hide();
    $("#panel_transaccion_2").hide();
    $("#panel_transaccion_3").hide()
    $("#panel_transaccion_4").hide();
    dhtmlwindow.open('resultbox', 'iframe',redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal')

}

function safetyPay(redireccion){
    dhtmlwindow.open('resultbox', 'iframe',redireccion, 'SAFETYPAY', 'width=963,height=670,scrolling=1,center=1,resize=0', 'recal')
    $('#resultbox').append("<a id='return-comerce' Style='position: absolute; margin-top: -86px; width: 120px; margin-left: 508px; cursor:alias;'></a>");
}

function tagginKineloEEaddToCart(costoTotalBet) {
	try {
		costoTotalBet = costoTotalBet.toFixed(2);
		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'EEaddToCart',
			'ecommerce' : {
				'currencyCode' : 'PEN',
				'add' : {
					'products' : [ {
						'name' : 'Kinelo Jugada Individual',
						'id' : 'kinelo',
						'price' : costoTotalBet, //Indicar aquí el “Costo total” de la jugada
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Kinelo'
					} ]
				}
			}
		});

		var tag = "Kinelo  EEaddToCart";
		console.log("Taggin event: " + tag + ", precio: " + costoTotalBet);
	} catch (e) {
		console.error(e);
	}

}

function tagginFinalizar() {
	try {
		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'virtualPageView',
			'pageUrl' : '/juega-kinelo/paso2/',
			'pageTitle' : 'Finaliza tu compra - Kinelo'

		});

		var tag = "Finaliza tu compra - Kinelo";
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}

}

function tagginKineloEEcheckout() {
	try {
		//Reiniciar tag checkout
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',
		   'ecommerce': {
		      'checkout': undefined
		    
		  }
		});

		//Enviar evento checkout
		var aproduct = [];
		for (var j = 0; j < v_content_object.length; j++) {

			var data = v_content_object[j];
			var price = data[4];
			price = price.toFixed(2);

			var productJson = {
				'name' : 'Kinelo Jugada Individual',
				'id' : 'kinelo',
				'price' : price, //Indicar el precio de la jugada
				'brand' : 'Juegos',
				'quantity' : '1',
				'category' : 'Kinelo'
			}
			aproduct.push(productJson);
		}

		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'EEcheckout',
			'ecommerce' : {
				'checkout' : {
					'actionField' : {
						'step' : 1
					},
					'products' : aproduct
				}
			}
		});

		var tag = "EEcheckout - Kinelo";
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}

}

function tagginKineloEEremoveFromCart(price) {
	try {
		price = price.toFixed(2);
		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'EEremoveFromCart',
			'ecommerce' : {
				'remove' : {
					'products' : [ {
						'name' : 'Kinelo Jugada Individual',
						'id' : 'kinelo',
						'price' : price, //Indicar el precio de la jugada
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Kinelo'
					} ]
				}
			}
		});

		var tag = "EEremoveFromCart - Kinelo";
		console.log("Taggin event: " + tag + ", precio: " + price);
	} catch (e) {
		console.error(e);
	}

}

function tagginKineloCompraExitosa() {
	try {
		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'compraExitosa',
			'pageUrl' : '/juega-kinelo/confirmacion/',
			'pageTitle' : 'Compra exitosa - Individual - Kinelo'
		});

		var tag = "Kinelo  compraExitosa";
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}

}

function tagginKineloEEpurchase(content_object, new_content) {
	try {
		var idTransaction = 0;
		var total_price = 0;
		var aproduct = [];
		var idTransaction = "KN";
		for (var i = 0; i < content_object.length; i++) {
			var product = content_object[i];
			var nproduct = new_content[i];
			var idt = nproduct[2];
			var ok = idt.split("&")[0];
			//Verificar si se procesó jugada
			if (ok === "OK") {
				idTransaction = idTransaction + "-" + idt.split("&")[1];
				var nCosecutivos = product[3] + "";
				var nJugadas = (product[6]*product[3])+"";
				
				var price = product[4];
				
				var n = 0;
				var nBolillas = 0;
				var multiplicador = 0;
				for (var m = 0; m < 2; m++) {
					if (product[m].length > 4) {
						n++;
						//Obtener bolillas y multiplicador
						var bm = product[m].split("x");
						nBolillas = nBolillas + bm[0].trim().split(" ").length;
						multiplicador = multiplicador + parseInt(bm[1].trim());
					}
				}
				nBolillas = "" + (nBolillas / n).toFixed(1);
				multiplicador = (multiplicador / n).toFixed(1);
				//			n = "" + n;
				//Verificar si es una jugada gratuita
				if (product[7] > 0) {
					total_price = total_price + price;
					price = price.toFixed(2);
					var jproduct = { //Aca se listan las jugadas individuales
						'name' : 'Kinelo Jugada Individual',
						'id' : 'kinelo',
						'price' : price,
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Kinelo',
						'variant' : 'jugada estandar',
						'dimension4' : nBolillas,
						'metric1' : nJugadas, //indicar cantidad de jugadas
						'dimension5' : multiplicador, // indicar multiplicador premio
						'dimension3' : nCosecutivos, // Indicar cantidad de sorteos consecutivos

					// aquí indicar el número de bolillas
					}
				} else {
					price = 0;
					price = price.toFixed(2);
					var jproduct = { //Aca se listan las jugadas individuales
						'name' : 'Kinelo Jugada Individual',
						'id' : 'kinelo',
						'price' : price,
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Kinelo',
						'variant' : 'jugada gratis',
						'dimension4' : nBolillas,
						'metric1' : nJugadas, //indicar cantidad de jugadas
						'dimension5' : multiplicador, // indicar multiplicador premio
						'dimension3' : nCosecutivos, // Indicar cantidad de sorteos consecutivos
					// aquí indicar el número de bolillas
					}
				}

				aproduct.push(jproduct);
			}

		}
		total_price = total_price.toFixed(2);

		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'EEpurchase',
			'ecommerce' : {
				'purchase' : {
					'actionField' : {
						'id' : idTransaction, // Código de la transacción        
						'revenue' : total_price, // Monto total pagado
					},
					'products' : aproduct
				}
			}
		});

		var tag = "Kinelo  EEpurchase";
		console.log("Taggin event: " + tag, dataLayer);

	} catch (e) {
		console.error(e);
	}

}

