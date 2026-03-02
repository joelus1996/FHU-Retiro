var $Ganagol = function () {

    var data = [];
    // variables y arrays por cada juego
    var content_object = [];
    var betJ1 = [];
    var betJ2 = [];
    var betJ3 = [];
    var betJ4 = [];
    var array_row_markJ1 = [];
    var sub_totalJ1 = 0;
    var optionJ1 = 0;
    var array_row_markJ2 = [];
    var sub_totalJ2 = 0;
    var optionJ2 = 0;
    var array_row_markJ3 = [];
    var sub_totalJ3 = 0;
    var optionJ3 = 0;
    var array_row_markJ4 = [];
    var sub_totalJ4 = 0;
    var optionJ4 = 0;
    var Sub_Total = 0;
    var array_row = [];
    var option = 0;
    var status = 'ACT';
    var simpleBetPrice = $('#simpleBetPrice').val();
    var algorithm = $('#algorithm').val();
    var bets = $('#bets').val();
    var pay = $('#pay').val();
    var cost = $('#cost').val();
    
    var golazoA="null";
    var golazoB="null";
    var golazoC="null";
    var golazoD="null";

    $("#menu-item-2").addClass("current-menu-item");
    $('#frmLoginClientIndex').attr('id', 'frmLoginClientGanagol').attr('action', 'login_ganagol.html');
    $("#frmLoginClientGanagol").on("submit", function (event) {
        event.preventDefault();
        $.ajax({ type: $(this).attr('method'), url: $(this).attr('action'), dataType: $(this).data('responseType'), data: $(this).serialize(), success: function (e) {
            var resp = $.trim(e);
            var arrresp = resp.split("|");
            var valida_session = arrresp[0];
            if (valida_session === 'OK') {
                var username = arrresp[1];
                var useramount = arrresp[2];
                var userid = arrresp[3];
                var monto1 = floatFormat(arrresp[4]);
                var monto2 = floatFormat(arrresp[5]);
                $("#field-balance-amount").html(monto1);
                if (monto2 == "0.00") {
                    $(".saldo_promocional").html('')
                } else {
                    $(".saldo_promocional").html("&oacute; de mi saldo promocional S/." + monto2)
                }
                $("#clientId").val(userid);
                $("#clientSale-name").html(username);
                $("#clientSale-amount").html(useramount);
                $('#user-ico').addClass(arrresp[6]);
                $(".logout").css("display", "");
                $(".unlogout").hide();
                $("#payments_section").show();
                $("#login_section").css("display", "");
                $("#panel_finaliza_compra").hide();
            } else {
                jAlert(valida_session)
            }
        }});
    });

    if (status == 'CIE') {
        disabled_game();
    }
    $('#part2').hide();
    $('#part3').hide();
    $('#part4').hide();

    

    if (status == 'ACT') {
        $('#next').on('click', function () {
            if ($(this).hasClass('flecha_next_J1')) {
                $('#part1').hide();
                $('#part2').show();
                $(this).removeClass().addClass('flecha_next_J2');
                $('#back').removeClass().addClass('flecha_back_J2');
            } else if ($(this).hasClass('flecha_next_J2')) {
                $('#part2').hide();
                $('#part3').show();
                $(this).removeClass().addClass('flecha_next_J3');
                $('#back').removeClass().addClass('flecha_back_J3');
            } else if ($(this).hasClass('flecha_next_J3')) {
                $('#part3').hide();
                $('#part4').show();
                $(this).removeClass().addClass('flecha_next_J4');
                $('#back').removeClass().addClass('flecha_back_J4');
            }
        });
        $('#back').on('click', function () {
            if ($(this).hasClass('flecha_back_J2')) {
                $('#part2').hide();
                $('#part1').show();
                $(this).removeClass().addClass('flecha_back_J1');
                $('#next').removeClass().addClass('flecha_next_J1');
            }
            if ($(this).hasClass('flecha_back_J3')) {
                $('#part3').hide();
                $('#part2').show();
                $(this).removeClass().addClass('flecha_back_J2');
                $('#next').removeClass().addClass('flecha_next_J2');
            }
            if ($(this).hasClass('flecha_back_J4')) {
                $('#part4').hide();
                $('#part3').show();
                $(this).removeClass().addClass('flecha_back_J3');
                $('#next').removeClass().addClass('flecha_next_J3');
            }
        });
    }

    if (status == 'ACT') {
        $('#back').on('mouseover',function () {
            if (!$(this).hasClass('flecha_back_J1')) {
                $(this).addClass('flecha-back-on');
                if ($(this).hasClass('flecha_back_J2')) {
                    $('#go_to_play').addClass('go_to_play_J1');
                }
                if ($(this).hasClass('flecha_back_J3')) {
                    $('#go_to_play').addClass('go_to_play_J2');
                }
                if ($(this).hasClass('flecha_back_J4')) {
                    $('#go_to_play').addClass('go_to_play_J3');
                }
            }
        }).on('mouseout', function () {
                if (!$(this).hasClass('flecha_back_J1')) {
                    $(this).removeClass('flecha-back-on');
                }
                $('#go_to_play').removeClass();
            });
        $('#next').on('mouseover',function () {
            if (!$(this).hasClass('flecha_next_J4')) {
                $(this).addClass('flecha-next-on');
            }
            if ($(this).hasClass('flecha_next_J1')) {
                $('#go_to_play').addClass('go_to_play_J2');
            }
            if ($(this).hasClass('flecha_next_J2')) {
                $('#go_to_play').addClass('go_to_play_J3');
            }
            if ($(this).hasClass('flecha_next_J3')) {
                $('#go_to_play').addClass('go_to_play_J4');
            }
        }).on('mouseout', function () {
                if (!$(this).hasClass('flecha_next_J4')) {
                    $(this).removeClass('flecha-next-on');
                }
                $('#go_to_play').removeClass();
            });
    }
    function grid_1() {
        var grid = '<div class="head">' + '<div class="head_title_1">N</div>' + '<div class="head_title_2">Local</div>' + '<div class="head_title_3"></div>'
            + '<div class="head_title_4"></div>' + '<div class="head_title_5">Visitante</div>' + '<div class="head_title_6">Torneo</div>' + '<div class="head_title_7"></div> '
            + '</div>';
        var count = 1;
        for (var i in data) {
            var tipo_fila = "";
            if (count % 2 == 0) {
                tipo_fila = "row1";
            } else {
                tipo_fila = "row2";
            }
            /*
             * ORDEN DE CELDAS
             * item,local,imageLocal,imageVisitor,visitor,imageCup,cup,odds,notes
             */
            grid += '<div class="content_row ' + tipo_fila + '">';
            grid += '<div class="col1">' + data[i][0] + '</div>';
            grid += '<div class="col2">' + data[i][1] + '</div>';
            grid += '<div class="col3 gg' + data[i][9] + '">-</div>';
            grid += '<div class="col4 gg' + data[i][10] + '">-</div>';            
            grid += '<div class="col5">' + data[i][4] + '</div>';
            var pos = parseInt(data[i][0]);
            pos = pos - 1;
            grid += '<div class="col6"><div class="image-cup" data="' + data[i][6] + '" pos="' + pos + '">Torneo</div> <div class="cup-info"> </div> <div class="cup-info-arrow-img"> </div> </div>';
            grid += '<div class="col7">' + data[i][8] + '</div>';
            grid += '</div>';
            count++;
        }
        $("#grid_ganagol").html(grid);
    }

    function grid_2() {
        var grid = '<div class="head">' + '<div class="head_title_1">N</div>' + '<div class="head_title_2">Local</div>' + '<div class="head_title_3"></div>'
            + '<div class="head_title_4"></div>' + '<div class="head_title_5">Visitante</div>' + '<div class="head_title_6">Asicnac.</div>' + '<div class="head_title_7"></div>   '
            + '</div>';
        var count = 1;
        for (var i in data) {
            var tipo_fila = "";
            if (count % 2 == 0) {
                tipo_fila = "row1";
            } else {
                tipo_fila = "row2";
            }
            /*
             * ORDEN DE CELDAS
             * item,local,imageLocal,imageVisitor,visitor,imageCup,cup,odds,notes
             */
            grid += '<div class="content_row ' + tipo_fila + '">';
            grid += '<div class="col1">' + data[i][0] + '</div>';
            grid += '<div class="col2">' + data[i][1] + '</div>';
            grid += '<div class="col3 gg' + data[i][9] + '">-</div>';
            grid += '<div class="col4 gg' + data[i][10] + '">-</div>';
            grid += '<div class="col5">' + data[i][4] + '</div>';
            var alloc = (data[i][7]).split(" ");
            var cell = " ";
            for (var c = 0; c < alloc.length; c++) {
                cell = cell + $.trim(alloc[c]);
            }
            grid += '<div class="col6">' + cell + '</div>';
            grid += '<div class="col7">' + data[i][8] + '</div>';
            grid += '</div>';
            count++;
        }
        $("#grid_ganagol").html(grid);
    }

    function disabled_game() {
        $('#right').addClass('opacity');
        $('#center').addClass('opacity');
        $('#next').addClass('opacity');
        //$('#next').stop().animate({opacity: 0.5}, 'slow');
        //$('#right').stop().animate({opacity: 0.5}, 'slow');
        //$('#center').stop().animate({opacity: 0.5}, 'slow');
    }

    $("#allocations").on('click', function () {
        var allocations = $("#allocations").text();
        if (allocations == "Ver asignaciones") {
            grid_2();
            $("#allocations").text("Ver Torneos");
        } else {
            grid_1();
            $("#allocations").text("Ver asignaciones");
        }

    });
    $('#primer-part').on('mouseover', '.image-cup', function () {
        var data = $(this).attr("data");
        var pos = $(this).attr("pos");
        $(".cup-info").eq(pos).css('display', 'inline');
        $(".cup-info").eq(pos).html(data);
        $(".cup-info-arrow-img").eq(pos).show();
    });
    $('#primer-part').on('mouseout', '.image-cup', function () {
        var pos = $(this).attr("pos");
        $(".cup-info").eq(pos).hide();
        $(".cup-info-arrow-img").eq(pos).hide();
    });
    if (status == 'ACT') {
        $('.check').on('click', function () {
            var id_value = $(this).attr('id');
            var play = id_value.substr(0, 2);
            var row = $(this).data('row');
            var idGolazo200 = id_value.substring(8).trim();
            //var cantCheckJ1 = 0;
            //var cantCheckJ2 = 0;
            //var cantCheckJ3 = 0;
            //var cantCheckJ4 = 0;
            
            if(play == 'J1'){
            	cantCheckJ1 = 0;
            	for(var i=1 ;i<=42;i++){
            		if ($('#'+ play + 'check_' + i).is(':checked')){
            		cantCheckJ1 ++
            		}	
            	}
            	if(cantCheckJ1<14){
            		flag200=false;           		
            		for(var i=43 ; i<=52 ; i++){	            	
            		    $('#' + play + 'check_' + i ).prop('checked', false);	            	
            		}
            		
            			//$('#ganagol200-text').html('');
            		 $('#L' + id_value).removeClass('colorChecked');
                     update_array_bet(play);
                     calculate_bet(play);
                     delete_array_row(play, row);
                     show_bet(play);
                     total_golazo200J1=0;
 	        		 process_add_ons();
            		
            	}
            }
            
            if(play == 'J2'){
            	cantCheckJ2 = 0;
            	for(var i=1 ;i<=42;i++){
            		if ($('#'+ play + 'check_' + i).is(':checked')){
            		cantCheckJ2 ++
            		}	
            	}
            	if(cantCheckJ2<14){
            		flag200=false;
            		            		
            		for(var i=43 ; i<=52 ; i++){	            	
            		    $('#' + play + 'check_' + i ).prop('checked', false);	            	
            		}
            		$('#L' + id_value).removeClass('colorChecked');
                    update_array_bet(play);
                    calculate_bet(play);
                    delete_array_row(play, row);
                    show_bet(play);
                    total_golazo200J1=0;
	        		 process_add_ons();
            	}
            }
            
            if(play == 'J3'){
            	cantCheckJ3 = 0;
            	for(var i=1 ;i<=42;i++){
            		if ($('#'+ play + 'check_' + i).is(':checked')){
            		cantCheckJ3 ++
            		}	
            	}
            	if(cantCheckJ3<14){
            		flag200=false;
            		
            		for(var i=43 ; i<=52 ; i++){	            	
            		    $('#' + play + 'check_' + i ).prop('checked', false);	            	
            		}
            		$('#L' + id_value).removeClass('colorChecked');
                    update_array_bet(play);
                    calculate_bet(play);
                    delete_array_row(play, row);
                    show_bet(play);
                    total_golazo200J1=0;
	        		 process_add_ons();
            	}
            }
            
            if(play == 'J4'){
            	cantCheckJ4 = 0;
            	for(var i=1 ;i<=42;i++){
            		if ($('#'+ play + 'check_' + i).is(':checked')){
            		cantCheckJ4 ++
            		}	
            	}
            	if(cantCheckJ4<14){
            		flag200=false;
            		
            		for(var i=43 ; i<=52 ; i++){	            	
            		    $('#' + play + 'check_' + i ).prop('checked', false);	            	
            		}
            		$('#L' + id_value).removeClass('colorChecked');
                    update_array_bet(play);
                    calculate_bet(play);
                    delete_array_row(play, row);
                    show_bet(play);
                    total_golazo200J1=0;
	        		 process_add_ons();
            	}
            }

                      
            if(parseInt(row) == 14 ||  parseInt(row) == 15  ){
	            for(var i=43 ; i<=52 ; i++){	            	
	            	if( parseInt(i) != parseInt(idGolazo200)){
	            		$('#' + play + 'check_' + i ).prop('checked', false);
	            	}else{
	            		if(play == 'J1'){
	            			golazoA='null'
	            			if($('#' + play + 'check_' + i ).prop('checked')){
	            				golazoA=$('#' + play + 'check_' + i ).val();
	            			}	            			
	            		}
	            		if(play == 'J2'){
	            			golazoB='null'
		            		if($('#' + play + 'check_' + i ).prop('checked')){
		            			golazoB= $('#' + play + 'check_' + i ).val();
		            		}
	            		}
	            		if(play == 'J3'){
	            			golazoC='null'
		            		if($('#' + play + 'check_' + i ).prop('checked')){
		            			golazoC= $('#' + play + 'check_' + i ).val();
		            		}
	            		}
	            		if(play == 'J4'){
	            			golazoD='null'
		            		if($('#' + play + 'check_' + i ).prop('checked')){
		            			golazoD= $('#' + play + 'check_' + i ).val();
		            		}
	            		}
	            	}	            		            	
	            }
            }
            
                     
	            if ($('#' + id_value).is(':checked')) {
	                $('#' + id_value).prop('checked', true);
	                update_array_bet(play);
	                calculate_bet(play);
	                if (Sub_Total <= 288) {
	                    $('#L' + id_value).addClass('colorChecked');
	                    if(row!=14 && row!=15 ){
	                    	 add_array_row(play, row);	
	                    }	                   
	                    show_bet(play);
	                    update_option(play, 0);
	                } else {
	                    $('#' + id_value).prop('checked', false);
	                    update_array_bet(play);
	                    calculate_bet(play);
	                    jAlert('No puede agregar al carrito de compras porque hay un límite de 288 apuestas en Ganagol');
	                    datalayerErroresIframe('Cotejar','Paso 2','Cotejar','No puede agregar al carrito de compras porque hay un límite de 288 apuestas en Ganagol');
	                }
	            } else {
	            	if(parseInt(row) == 14 ||  parseInt(row) == 15  ){
	            		flag200=false;
	            	}	            	
	                $('#' + id_value).prop('checked', false);
	                $('#L' + id_value).removeClass('colorChecked');
	                update_array_bet(play);
	                calculate_bet(play);
	                delete_array_row(play, row);
	                show_bet(play);
	            }
            
      
        });
    }

    
   
    if (status == 'ACT') {
        $('.clear').click(function () {
            var play = $(this).attr('id').substr(0, 2);
            clear(play);
            if(dataLayerlimpiar){
            	datalayerMarcarBolillasCotejar('Limpiar','Programa');
            }
        });
    }
    function row_marked(play, row) {
        var op = false;
        $('.check').each(function () {
            if ($(this).attr('id').substr(0, 2) == play && $(this).data('row') == row && $(this).is(':checked')) {
                return op = true;
            }
        });
        return op;
    }

    function clear(play) {
        $('.check').each(function () {
            if ($(this).attr('id').substr(0, 2) == play) {
                $(this).prop('checked', false);
                $('#L' + $(this).attr('id')).removeClass('colorChecked');
            }
        });
        array_row = [];
        array_row_markJ1 = [];
        array_row_markJ2 = [];
        array_row_markJ3 = [];
        array_row_markJ4 = [];
        option = 0;
        optionJ1 = 0;
        optionJ2 = 0;
        optionJ3 = 0;
        optionJ4 = 0;
        update_array_bet(play);
        calculate_bet(play);
        show_bet(play);
    }

    // Actualiza el arreglo de apuestas marcadas
    function update_array_bet(play) {
        if (play == 'J1') {
            betJ1 = [];
            var i = 0;
            var aux = '';
            var juego='';
            while (i < 14) {
                $('.check').each(function () {
                    if ($(this).attr('id').substr(0, 2) == play && $(this).is(':checked') && $(this).data('row') == i) {
                        aux = aux + $(this).val();
                    }
                });
                if (aux != '') {
                    aux = (i + 1) + aux;
                    betJ1.push(aux);
                }
                aux = '';
                i++;
            }
        }
        if (play == 'J2') {
            betJ2 = [];
            var i = 0;
            var aux = '';
            while (i < 14) {
                $('.check').each(function () {
                    if ($(this).attr('id').substr(0, 2) == play && $(this).is(':checked') && $(this).data('row') == i) {
                        aux = aux + $(this).val();
                    }
                });
                if (aux != '') {
                    aux = (i + 1) + aux;
                    betJ2.push(aux);
                }
                aux = '';
                i++;
            }
        }
        if (play == 'J3') {
            betJ3 = [];
            var i = 0;
            var aux = '';
            while (i < 14) {
                $('.check').each(function () {
                    if ($(this).attr('id').substr(0, 2) == play && $(this).is(':checked') && $(this).data('row') == i) {
                        aux = aux + $(this).val();
                    }
                });
                if (aux != '') {
                    aux = (i + 1) + aux;
                    betJ3.push(aux);
                }
                aux = '';
                i++;
            }
        }
        if (play == 'J4') {
            betJ4 = [];
            var i = 0;
            var aux = '';
            while (i < 14) {
                $('.check').each(function () {
                    if ($(this).attr('id').substr(0, 2) == play && $(this).is(':checked') && $(this).data('row') == i) {
                        aux = aux + $(this).val();
                    }
                });
                if (aux != '') {
                    aux = (i + 1) + aux;
                    betJ4.push(aux);
                }
                aux = '';
                i++;
            }
        }
    }

    function calculate_bet(play) {
        if (play == 'J1') {
            if (betJ1.length == 14) {
                var temp = 0;
                var ini = 0;
                for (var i = 0; i < betJ1.length; i++) {
                    if (i == 0) {
                        ini = (betJ1[i].length - 1) * (betJ1[i + 1].length - 1);
                    } else {
                        if (i + 1 < 9) {
                            temp = ini * (betJ1[i + 1].length - 1);
                            ini = temp;
                        } else if (i + 1 >= 9 && i + 1 < 14) {
                            temp = ini * (betJ1[i + 1].length - 2);
                            ini = temp;
                        }
                    }
                }
                sub_totalJ1 = ini;
            } else {
                sub_totalJ1 = 0;
            }
        }
        if (play == 'J2') {
            if (betJ2.length == 14) {
                var temp = 0;
                var ini = 0;
                for (var i = 0; i < betJ2.length; i++) {
                    if (i == 0) {
                        ini = (betJ2[i].length - 1) * (betJ2[i + 1].length - 1);
                    } else {
                        if (i + 1 < 9) {
                            temp = ini * (betJ2[i + 1].length - 1);
                            ini = temp;
                        } else if (i + 1 >= 9 && i + 1 < 14) {
                            temp = ini * (betJ2[i + 1].length - 2);
                            ini = temp;
                        }
                    }
                }
                sub_totalJ2 = ini;
            } else {
                sub_totalJ2 = 0;
            }
        }
        if (play == 'J3') {
            if (betJ3.length == 14) {
                var temp = 0;
                var ini = 0;
                for (var i = 0; i < betJ3.length; i++) {
                    if (i == 0) {
                        ini = (betJ3[i].length - 1) * (betJ3[i + 1].length - 1);
                    } else {
                        if (i + 1 < 9) {
                            temp = ini * (betJ3[i + 1].length - 1);
                            ini = temp;
                        } else if (i + 1 >= 9 && i + 1 < 14) {
                            temp = ini * (betJ3[i + 1].length - 2);
                            ini = temp;
                        }
                    }
                }
                sub_totalJ3 = ini;
            } else {
                sub_totalJ3 = 0;
            }
        }
        if (play == 'J4') {
            if (betJ4.length == 14) {
                var temp = 0;
                var ini = 0;
                for (var i = 0; i < betJ4.length; i++) {
                    if (i == 0) {
                        ini = (betJ4[i].length - 1) * (betJ4[i + 1].length - 1);
                    } else {
                        if (i + 1 < 9) {
                            temp = ini * (betJ4[i + 1].length - 1);
                            ini = temp;
                        } else if (i + 1 >= 9 && i + 1 < 14) {
                            temp = ini * (betJ4[i + 1].length - 2);
                            ini = temp;
                        }
                    }
                }
                sub_totalJ4 = ini;
            } else {
                sub_totalJ4 = 0;
            }
        }
        Sub_Total = sub_totalJ1 + sub_totalJ2 + sub_totalJ3 + sub_totalJ4;
        $('#total_bet').text(Sub_Total);
        var costoTotalBet = 0;
        if (Sub_Total >= 1) {
            if (algorithm == "BETS") {

                costoTotalBet = callTransformByBets(Sub_Total, simpleBetPrice, bets, pay);
            }
            else if (algorithm == "COST") {
                costoTotalBet = callTransformByCost(Sub_Total, simpleBetPrice, bets, cost);
            }
            else {
                costoTotalBet = Sub_Total * simpleBetPrice;
            }
            $('#total_apagar').html(floatFormat(costoTotalBet));
        } else {
            $('#total_apagar').html(0);
        }
    }

    function callTransformByBets(p_Sub_Total, p_simpleBetPrice, p_bets, p_pay) {
        var var_total_cost = 0;
        var_total_cost = ((p_Sub_Total * p_simpleBetPrice) - (Math.floor(p_Sub_Total / p_bets) * (p_bets - p_pay) * p_simpleBetPrice));
        return var_total_cost;
    }

    function callTransformByCost(p_Sub_Total, p_simpleBetPrice, p_bets, p_cost) {
        var var_total_cost = 0;
        var_total_cost = ((p_Sub_Total * p_simpleBetPrice) - (Math.floor(p_Sub_Total / p_bets) * (p_bets * p_simpleBetPrice - p_cost)));
        return var_total_cost;
    }

    function show_bet(play) {
        if (play == 'J1') {
            show(play, betJ1);
        }
        if (play == 'J2') {
            show(play, betJ2);
        }
        if (play == 'J3') {
            show(play, betJ3);
        }
        if (play == 'J4') {
            show(play, betJ4);
        }
    }

    function show(play, bet) {
        var aux_bet = (bet.toString()).replace(/,/g, ' / ');
        $('#' + play + '-text-area').val(aux_bet);
    }

    // Agrega un elemento al arreglo si este no existe aun
    function add_array_row(play, row) {
        if (play == 'J1') {
            for (i = 0; i < array_row_markJ1.length; i++) {
                if (array_row_markJ1[i] == row) {
                    return;
                }
            }
            array_row_markJ1.push(row);
            return;
        }
        if (play == 'J2') {
            for (var i = 0; i < array_row_markJ2.length; i++) {
                if (array_row_markJ2[i] == row) {
                    return;
                }
            }
            array_row_markJ2.push(row);
            return;
        }
        if (play == 'J3') {
            for (var i = 0; i < array_row_markJ3.length; i++) {
                if (array_row_markJ3[i] == row) {
                    return;
                }
            }
            array_row_markJ3.push(row);
            return;
        }
        if (play == 'J4') {
            for (var i = 0; i < array_row_markJ4.length; i++) {
                if (array_row_markJ4[i] == row) {
                    return;
                }
            }
            array_row_markJ4.push(row);
            return;
        }
    }

    // Elimina un elemento del arreglo si ya no existen otros con la misma fila
    function delete_array_row(play, row) {
        if (play == 'J1') {
            var aux_row = aux_delete_array_row(play, row);
            if (!aux_row) {
                for (var i = 0; i < array_row_markJ1.length; i++) {
                    if (array_row_markJ1[i] == row) {
                        array_row_markJ1.splice(i, 1);
                    }
                }
            }
        }
        if (play == 'J2') {
            var aux_row = aux_delete_array_row(play, row);
            if (!aux_row) {
                for (var i = 0; i < array_row_markJ2.length; i++) {
                    if (array_row_markJ2[i] == row) {
                        array_row_markJ2.splice(i, 1);
                    }
                }
            }
        }
        if (play == 'J3') {
            var aux_row = aux_delete_array_row(play, row);
            if (!aux_row) {
                for (var i = 0; i < array_row_markJ3.length; i++) {
                    if (array_row_markJ3[i] == row) {
                        array_row_markJ3.splice(i, 1);
                    }
                }
            }
        }
        if (play == 'J4') {
            var aux_row = aux_delete_array_row(play, row);
            if (!aux_row) {
                for (var i = 0; i < array_row_markJ4.length; i++) {
                    if (array_row_markJ4[i] == row) {
                        array_row_markJ4.splice(i, 1);
                    }
                }
            }
        }
    }

    function aux_delete_array_row(play, row) {
        var op = false;
        $('.check').each(function () {
            if ($(this).attr('id').substr(0, 2) == play && $(this).is(':checked') && $(this).data('row') == row) {
                return op = true;
            }
        });
        return op;
    }

    function find_array_row(play) {
        if (play == 'J1') {
            return array_row_markJ1;
        }
        if (play == 'J2') {
            return array_row_markJ2;
        }
        if (play == 'J3') {
            return array_row_markJ3;
        }
        if (play == 'J4') {
            return array_row_markJ4;
        }
    }

    // Limpiar los no clicleados
    function clear_unmarket(play) {
        $('.check').each(function () {
            if ($(this).attr('id').substr(0, 2) == play && $(this).is(':checked')) {
                var row = $(this).data('row');
                var aux_row = aux_clear_unmarket(play, row);
                if (!aux_row) {
                    $(this).prop('checked', false);
                    $('#L' + $(this).attr('id')).removeClass('colorChecked');
                }
            }
        });
    }

    function aux_clear_unmarket(play, row) {
        if (play == 'J1') {
            var op = false;
            for (var i = 0; i < array_row_markJ1.length; i++) {
                if (row == array_row_markJ1[i]) {
                    return op = true;
                }
            }
            return op;
        }
        if (play == 'J2') {
            var op = false;
            for (var i = 0; i < array_row_markJ2.length; i++) {
                if (row == array_row_markJ2[i]) {
                    return op = true;
                }
            }
            return op;
        }
        if (play == 'J3') {
            var op = false;
            for (var i = 0; i < array_row_markJ3.length; i++) {
                if (row == array_row_markJ3[i]) {
                    return op = true;
                }
            }
            return op;
        }
        if (play == 'J1') {
            var op = false;
            for (var i = 0; i < array_row_markJ4.length; i++) {
                if (row == array_row_markJ4[i]) {
                    return op = true;
                }
            }
            return op;
        }
    }

    function find_option(play) {
        if (play == 'J1') {
            return optionJ1;
        }
        if (play == 'J2') {
            return optionJ2;
        }
        if (play == 'J3') {
            return optionJ3;
        }
        if (play == 'J4') {
            return optionJ4;
        }
    }

    function update_option(play, option) {
        if (play == 'J1') {
            optionJ1 = option;
        }
        if (play == 'J2') {
            optionJ2 = option;
        }
        if (play == 'J3') {
            optionJ3 = option;
        }
        if (play == 'J4') {
            optionJ4 = option;
        }
    }
    
    
    //$("#buy").click(function () {
    $("#btn_desktop_cotejar_boleto_ganagol").click(function () {
    var indicadorJ1="correcto";
    var indicadorJ2="correcto";
    var indicadorJ3="correcto";
    var indicadorJ4="correcto";
    var Jug1="";
    var Jug2="";
    var Jug3="";
    var Jug4="";
    var JugCompletaA="";
    var JugCompletaB="";
    var JugCompletaC="";
    var JugCompletaD="";
    
        if (status == 'ACT') {
            if (Sub_Total >= 1) {
            	datalayerPaso2Cotejar('COTEJAR');
                $('#transition').removeClass().addClass('transition-two');
                $(".finalize-purchase").css("display", "block");
                $(".zona-juego").css("display", "none");
                add_ticket(content_object, betJ1, betJ2, betJ3, betJ4, $("#total_apagar").html());
                            
                if(betJ1!=null && betJ1!="" ){
                if(betJ1.length!=14){
                indicadorJ1="incorrecto"
                }else{
                for(var k=0;k<betJ1.length;k++){
                Jug1=betJ1[k];
                JugCompletaA=JugCompletaA+Jug1+" ";
                }
                for(var p=1;p<=betJ1.length;p++){
                JugCompletaA=JugCompletaA.replace(p,"");
                }
                }
                }else{
                JugCompletaA="null";
                }
                
                if(betJ3!=null && betJ3!="" ){
                if(betJ3.length!=14){
                indicadorJ3="incorrecto"
                }else{
                for(var k=0;k<betJ3.length;k++){
                Jug3=betJ3[k];
                JugCompletaC=JugCompletaC+Jug3+" ";
                }
                for(var p=1;p<=betJ3.length;p++){
                JugCompletaC=JugCompletaC.replace(p,"");
                }
                }
                }else{
                JugCompletaC="null";
                }
                
                if(betJ2!=null && betJ2!="" ){
                if(betJ2.length!=14){
                indicadorJ2="incorrecto"
                }else{
                for(var k=0;k<betJ2.length;k++){
                Jug2=betJ2[k];
                JugCompletaB=JugCompletaB+Jug2+" ";
                }
                for(var p=1;p<=betJ2.length;p++){
                JugCompletaB=JugCompletaB.replace(p,"");
                }
                }
                }else{
                JugCompletaB="null";
                }
                
                if(betJ4!=null && betJ4!="" ){
                if(betJ4.length!=14){
                indicadorJ4="incorrecto"
                }else{
                for(var k=0;k<betJ4.length;k++){
                Jug4=betJ4[k];
                JugCompletaD=JugCompletaD+Jug4+" ";
                }
                for(var p=1;p<=betJ4.length;p++){
                JugCompletaD=JugCompletaD.replace(p,"");
                }
                }
                }else{
                JugCompletaD="null";
                }
                
                if(indicadorJ1=="correcto" && indicadorJ2=="correcto" && indicadorJ3=="correcto" && indicadorJ4=="correcto"){
                	
                var posicion=document.getElementById('mySelectBox-2').options.selectedIndex;
                valorTeam=document.getElementById('mySelectBox-2').options[posicion].text; 
                valorTeam=valorTeam.substring(0,4);
                var jugadaCompleta=JugCompletaA+"/"+JugCompletaB+"/"+JugCompletaC+"/"+JugCompletaD+"/"+valorTeam+"/"+golazoA+"/"+golazoB+"/"+golazoC+"/"+golazoD+"/";
                
                
                
                $('#grid_ganagol_collator').hide();
                $('.validez_from_sorteo').hide();
                $('#cotejo').hide();
                $('.content_jugada').hide();
                $('.headerGanagolCotejador').hide();
                $('.footcotejar').show();
                $('#marca_collator').hide();
                $('#part1').hide();
                $('.right_collator').hide();
                $('#box-content-game-collate').hide();
                $('#part2').hide();
                $('#part3').hide();
                $('#part4').hide();
                $(".right_flecha_collator").css({'display': 'none'});
                $("#cotejar").css({'display': 'none'});
                $("#regresarCotejo").css({'display': 'block'});
                $('#jugadaCotejo').show();
                $('.team_contenidos_collater').show();
                
                
                $.ajax({type: "POST", url: "cotejo_ajax_ganagol.html", dataType: "text", data: "dato=" + jugadaCompleta ,async:false, success: function (e) {
                resultJson= $.parseJSON(e); 
                result=e;
                }})
                
                
                var a = '';
                var header_auxiliar = '<div class="box-playing"><div class="row no-gutters"><div class="col-12"><div class="box-wrapper-game box-content-left"><div class="box-content-game"><div class="box-play-main"><div class="content-single-game">';
                var footer_auxiliar = '</div></div></div></div></div></div></div>';
                
                var i=0,j=0,h=0,m=0;
                if(resultJson!=null){
                  $.map(resultJson, function (d) { 
                  $.map(d.datos_jugada_A, function (r) {
                    var juga1=r.ctbM1;
                    var juga2=r.ctbM2;
                    var juga3=r.ctbM3;
                    var juga4=r.ctbM4;
                    var golazo1=r.golazoA;
                    var golazo2=r.golazoB;
                    var golazo3=r.golazoC;
                    var golazo4=r.golazoD;
                    //console.log(r);
                    a += header_auxiliar+'<div class="top-single-game"><div class="row container"><div class="col-6"><h3>NRO DE PROGRAMA:<span>' + r.num_sorteo + '</span></h3></div><div class="col-6"><h3>FECHA: <span>' + r.fecha + '</span></h3></div></div></div>';							
					a += '<div class="top-single-game"><div class="row container"><div class="col-12"><h3>RESULTADO DEL PROGRAMA:<span>' + r.resultados + '</span></h3></div></div></div>';
					if(golazo1!=" null " || golazo2!=" null " || golazo3!=" null " || golazo4!=" null "){
						a += '<div class="top-single-game"><div class="row container"><div class="col-12"><h3>RESULTADO GOLAZO 200:<span>' + r.resultado_golazo200 + '</span></h3></div></div></div>';
					}
					
                               
                if(juga1!=" null "){   
                	if(golazo1!=" null "){
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix ganagol-g200"><h3>JUGADA 01</h3><span>' + r.ctbM1 +'/ G200'+golazo1+ '</span></div></div></div>';
                	}
                	else{
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix"><h3>JUGADA 01</h3><span>' + r.ctbM1 + '</span></div></div></div>';
                	}
                
                a += '<div class="kabala_jugada_acerts">';
                
                	$.map(r.cotejo_jugadaA, function (c) {
                		i++;
                		a += '<div class="row container"><span><span class="kabala_jugada-title">[' + i + ']</span> <span class="cotejador">' + c + '</span></span></div>';
                		
                     });
                a += '</div>';
                }
                
                if(juga2!=" null "){
                	if(golazo2!=" null "){
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix ganagol-g200"><h3>JUGADA 02</h3><span>' + r.ctbM2 +'/ G200'+golazo2+ '</span></div></div></div>';
                	}
                	else{
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix"><h3>JUGADA 02</h3><span>' + r.ctbM2 + '</span></div></div></div>';
                	}
                
                a += '<div class="kabala_jugada_acerts">';
                	$.map(r.cotejo_jugadaB, function (b) {
                		j++;                    
                		a += '<div class="row container"><span><span class="kabala_jugada-title">[' + j + ']</span> <span class="cotejador">' + b + '</span></span></div>';
                		
                     });
                a += '</div>';
                }
                
                if(juga3!=" null "){
                	if(golazo3!=" null "){
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix ganagol-g200"><h3>JUGADA 03</h3><span>' + r.ctbM3 +'/ G200'+golazo3+ '</span></div></div></div>';
                	}
                	else{
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix"><h3>JUGADA 03</h3><span>' + r.ctbM3 + '</span></div></div></div>';
                	}
                	
                    a += '<div class="kabala_jugada_acerts">';
                     $.map(r.cotejo_jugadaC, function (t) {
                    	h++;
                    	a += '<div class="row container"><span><span class="kabala_jugada-title">[' + h + ']</span> <span class="cotejador">' + t + '</span></span></div>';
                    	                    	
                     });
                    a += '</div>';
                }

                if(juga4!=" null "){
                	if(golazo4!=" null "){
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix ganagol-g200"><h3>JUGADA 04</h3><span>' + r.ctbM4 +'/ G200'+golazo4+ '</span></div></div></div>';
                	}
                	else{
                		a += '<div class="body-single-game"><div class="body-game"><div class="button-group checkboxes-ball clearfix"><h3>JUGADA 04</h3><span>' + r.ctbM4 + '</span></div></div></div>';
                	}
                	
                    a += '<div class="kabala_jugada_acerts">';
	                $.map(r.cotejo_jugadaD, function (w) {
	                    m++;
	                    a += '<div class="row container"><span><span class="kabala_jugada-title">[' + m + ']</span> <span class="cotejador">' + w + '</span></span></div>';
	                    	                    
	                     });
	                a += '</div>';
	                }
                
                a += footer_auxiliar;
                });
                });
                }



                $("#valorJugadaCotejo").html(a);
                
                }else{
                jAlert('Jugada incorrecta, revise su jugada', null);
                datalayerErroresIframe('Cotejar','Paso 2','Cotejar','Jugada incorrecta, revise su jugada');
                }
                
                $("#back").click();
                $("#back").click();
                $("#back").click();
                $("#back").click();

                var costo_total = 0;
                for (var i in content_object) {
                    costo_total += parseFloat(content_object[i][4]);
                }

                for (var v in content_object) {
                    for (var w = 0; w <= 3; w++) {
                        var game = "";
                        if (content_object[v][w] == "") {
                            content_object[v][w] = "00";
                        }
                    }
                }

                
            }
            else {
                jAlert('No ha realizado ninguna jugada.', null);
                datalayerErroresIframe('Cotejar','Paso 2','Cotejar','No ha realizado ninguna jugada.');
            }
        }
    });

    $("#more_plays").click(function () {
        $('#transition').removeClass().addClass('transition-one');
        $(".zona-juego").fadeIn('fast');
        $(".finalize-purchase").hide();
        dataLayerlimpiar = false;
        $(".clear").click();
        dataLayerlimpiar = true;
        $('.content_jugada').show();
        $('.headerGanagolCotejador').show();
        $('.footcotejar').hide();
        $('#grid_ganagol_collator').show();
        $('.validez_from_sorteo').show();
        $('#cotejo').show();
        $('.selectBox').show();
        $('#marca_collator').show();
        dataLayerlimpiar = false;
        $('.box-current-game').eq(0).find('a').trigger('click');
        dataLayerlimpiar = true;
        $('#mySelectBox').val($('#mySelectBox').find('option').eq(0).attr('value'));
        $('#mySelectBox').closest('.selectBox').find('.box').html($('#mySelectBox').find('option').eq(0).text());
        
        $('.right_collator').show();
        $('#box-content-game-collate').show();
        $('#part1').css({'display': 'block'});
        $('#part2').hide();
        $('#part3').hide();
        $('#part4').hide();
        $(".right_flecha_collator").css({'display': 'block'});
        $("#cotejar").css({'display': 'block'});
        $("#regresarCotejo").css({'display': 'none'});
        $('#jugadaCotejo').hide();
        $('.team_contenidos_collater').hide();      
        golazoA='null';golazoB='null';golazoC='null';golazoD='null'
    });
    $('#game-history').on('click', function (event) {
        event.preventDefault();
    });

    function add_ticket(content_object, juego1, juego2, juego3, juego4, precio) {
        var object_boleto = [];
        object_boleto.push(juego1);
        object_boleto.push(juego2);
        object_boleto.push(juego3);
        object_boleto.push(juego4);
        object_boleto.push(precio);
        content_object.push(object_boleto);
        juego1 = [];
        juego2 = [];
        juego3 = [];
        juego4 = [];
    }

    function grilla_boletos(data) {

        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var grilla = "<div id='grilla_boleto'>"
            + "<div class='boleto_cabecera'>"
            + "<div class='head_title_1'>N.</div>"
            + "<div class='head_title_2'>BOLETOS</div>"
            + "<div class='head_title_3'>ANULAR</div>"
            + "</div>";
        +"<div id='total_filas'>";

        for (var x in data) {
            for (var i = 0; i <= 3; i++) {
                if (data[x][i] != "") {
                    if (data[x][i] != "00") {
                        var result_ticket = nom_jugadas[i] + ": ";
                        var numeros = (data[x][i] + "").split(",");
                        for (var num in numeros) {
                            if (numeros[num].length < 2) {
                                numeros[num] = "0" + numeros[num];
                            }

                            result_ticket += numeros[num] + " ";
                        }
                        break;

                    }
                }

            }
            var style = "row_grid";
            if (x % 2 != 0) {
                style += " row_grid_mouseover";
            }

            if (x > 2) {
                style += " row_null";
            }
            /**data[x][5]---> CANTIDAD DE SORTEOS**/
            grilla += "<div class='" + style + "'>"
                + "<div class='column_1'>" + (parseInt(x) + 1) + "</div>"
                + "<div class='column_2'>" + result_ticket.substring(0, 36) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>"
                + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>"
                + "<div class='column_3'>"
                + "<div class='delete process-delete1' rel='" + x + "'></div>"
                + "</div>"
                + "</div>";
        }
        grilla += "</div></div>";

        $('#content-grid-result').html(grilla);
    }

   

    $('.left-panel').on('click', '.lnk-pag1', function () {
        var cadena_pos = $(this).attr("rel");
        var id = $(this).attr("id");
        var posiciones = cadena_pos.split("-");

        $(".row_grid").removeClass("row_null");
        $(".row_grid").addClass("row_null");

        for (var num in posiciones) {
            $(".row_grid").eq(posiciones[num]).removeClass("row_null");
        }
        grilla_paginada(content_object);
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#" + $(this).attr("id")).removeClass("num_page_on");
        $("#" + $(this).attr("id")).addClass("num_page_off");
    });

    $('.left-panel').on('mouseover', '.row-info', function () {
        var posicion = $(this).attr("rel");
        var content_info = "";
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        for (var i = 0; i <= 3; i++) {
            content_object[posicion][i] = $.trim(content_object[posicion][i] + "");
            if (content_object[posicion][i] != 0) {
                if (content_object[posicion][i] != "null") {
                    var test = (content_object[posicion][i] + "").split("-");
                    if (test[1] != "null") {
                        var numeros = (content_object[posicion][i] + "").split(",");
                        var result_ticket = "";
                        for (var num in numeros) {
                            if (numeros[num].length < 2) {
                                numeros[num] = "0" + numeros[num];
                            }
                            result_ticket += numeros[num] + " ";
                        }
                        content_info += nom_jugadas[i] + ": " + result_ticket + "<br>";
                    }
                }
            }
        }
        $(".tooltip-info").eq(posicion).css("display", "block");
        $(".tooltip-info").eq(posicion).html(content_info);
        $(".tooltip-info-arrow-img").eq(posicion).css("display", "block");
    });
    $('.left-panel').on('mouseout', '.row-info', function () {
        var posicion = $(this).attr("rel");
        $(".tooltip-info").eq(posicion).css("display", "none");
        $(".tooltip-info-arrow-img").eq(posicion).css("display", "none");
    });

    $('.left-panel').on('click', '.process-delete1', function () {
        var pos = parseInt($(this).attr("rel"));
        content_object.splice(pos, 1);
        grilla_boletos(content_object);
        grilla_paginada(content_object);

        var costo_total = 0;
        for (var i in content_object) {
            costo_total += parseFloat(content_object[i][4]);
        }
        $(".result1").html("S/." + floatFormat(costo_total));
        if(content_object.length==0){
            $('#more_plays').click();
        }
    });

    $('#content-purchase').on('click', '#btn_finaliza_compra', function () {
        var option = $("[name=option-card]:checked").val();
        var pin = $("[name=pin-number]").val();
        var message = "";
        var amount = 0.0;
        var newamount = 0.0;
        var msgres = new Array();
        if (option == 0) {
            message = "OK";
        } 
        message = message.replace(/_/g, ' ');
        if (message == "OK") {
            if (content_object.length != 0) {
                $(".left-panel").html("");
                var content_grid_2 = "<div class='label-top'></div>"
                    + "<div class='label_1'>GANAGOL</div>"
                    + "<div id='ajax-loader'>"
                    + "<img src='layer-view-image/game/ganadiario/ajax-loader.gif'>"
                    + "</div><div id='content-grid-result'></div>"
                    + "<div id='num_link'></div>";
                content_grid_2 += "<div id='game-no-process-info'></div>";

                $(".left-panel").html(content_grid_2);

                //$("#more_plays").css("display","none");
                $("#panel_more_plays").css("display", "none");
                //$(".class-keep-playing").css("display","block");
                $("#panel_keep-playing").css("display", "block");
                //$(".class-game-history").css("display","block");
                $("#panel_game-history").css("display", "block");
                $("#ico-block").css("display", "block");
                $(".label-top").css("display", "block");
                $("#sub_panel").css("display", "none");
                //$("#btn_finaliza_compra").css("display","none");
                $("#panel_finaliza_compra").css("display", "none");

                var result_ticket = "";
                for (i in content_object) {
                    if (i != 0) {
                        result_ticket += "-";
                    }
                    for (j in content_object[i]) {
                        if (j != 0) {
                            result_ticket += "|";
                        }
                        var numeros = (content_object[i][j] + "").split(",");
                        for (var num = 0; num < numeros.length; num++) {
                            result_ticket += numeros[num] + " ";
                        }
                    }
                }

                $("#ajax-loader").css("display", "block");

                var contador = 0;
                $.ajax({
                    type: "POST",
                    url: "ajaxGanagol.html",
                    dataType: "text",
                    data: "dato=" + result_ticket,
                    success: function (e) {
                        var new_content_object = [];
                        var filas = (e + "").split("#");
                        for (var i = 0; i < filas.length; i++) {
                            var columns = (filas[i] + "").split("&");
                            var jugadas = (columns[0] + "").split("|");
                            var row = [];
                            for (var j = 0; j <= 3; j++) {
                                if (jugadas[j] != null) {
                                    row.push(jugadas[j]);
                                } else {
                                    row.push("00");
                                }
                            }
                            row.push(columns[1]);
                            row.push(columns[2]);
                            row.push(columns[3]);
                            row.push(columns[4]);
                            row.push(columns[5]);
                            row.push(columns[6]);
                            row.push(columns[7]);

                            new_content_object.push(row);
                        }
                        content_object = [];
                        content_object = new_content_object;

                        grilla_boletos2(content_object);
                        grilla_paginada(content_object);

                        $(".label_resu3").html("<b>Saldo Disponible: S/. </b>" + floatFormat(content_object[(content_object.length - 1)][7]));
                        var promotional_balance = parseFloat(content_object[(content_object.length - 1)][8]);
                        if (promotional_balance > 0) {
                            $(".label_resu4").html("<b>Saldo Promocional: S/. </b>" + content_object[(content_object.length - 1)][8]);
                        }
                        $("#clientSale-amount").html(content_object[(content_object.length - 1)][7]);
                        $("#ajax-loader").css("display", "none");

                        var costo_total = 0;
                        for (var u = 0; u < content_object.length; u++) {
                            if (content_object[u][6] != "null") {
                                $(".label-top").html("&#161;GRACIAS POR TU COMPRA!");
                                costo_total += parseFloat(content_object[u][4]);
                            } else {
                                break;
                            }
                        }

                        $(".result1").html("S/." + floatFormat(costo_total));
                        $(".label_resu1").html("TOTAL PAGADO:");
                        $('#keep-playing').off('click');
                        $('#game-history').off('click');
                    }
                });

            } else {
                jAlert("No se tiene jugadas por procesar");
                datalayerErroresIframe('Cotejar','Paso 2','Cotejar','No se tiene jugadas por procesar');
            }
            if (option == 1) jAlert("Se ha realizado una recarga de saldo.\n\nMonto cargado: S/. " + amount + "\nTu saldo es: S/. " + newamount, null);
        } else {
            if (option == 1) jAlert("No se ha logrado realizar la recarga.\n" + message + "\n\nMonto cargado: S/. " + amount + "\nTu saldo es: S/. " + newamount, null);
        }
    });

 

    $('.left-panel').on('mouseover', '.no-process', function () {
        var contenido_total = $(this).attr("rel");
        var contenido_temp = (contenido_total + "").split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = (contenido_temp[1] + "").replace(/\*/g,"<br/>");
        $(".tooltip-no-process").eq(posicion).show();
        $(".tooltip-no-process").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img").eq(posicion).show();
    });
    $('.left-panel').on('mouseout', '.no-process', function () {
        var contenido_total = $(this).attr("rel");
        var contenido_temp = contenido_total.split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1];
        $(".tooltip-no-process").eq(posicion).hide();
        $(".tooltip-no-process").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img").eq(posicion).hide();
    });

    $('#keep-playing').on('click', function (event) {
        event.preventDefault();
    });
    $('.left-panel').on('click', '#btn-no-process', function () {
        var array_no_procesados = [];
        var contador = 0;
        for (var i in content_object) {

            if (content_object[i][6] == "null") {
                array_no_procesados.push(content_object[i]);
                contador++;
            }
        }

        //$("#keep-playing").css("display","none");
        $("#panel_keep-playing").css("display", "none");
        //$("#game-history").css("display","none");
        $("#panel_game-history").css("display", "none");
        $("#ico-block").css("display", "none");
        //$("#btn_finaliza_compra").css("display","block");
        $("#panel_finaliza_compra").css("display", "block");
        //$("#more_plays").css("display","block");
        $("#panel_more_plays").css("display", "block");
        $("#sub_panel").css("display", "block");
        $(".left-panel").html("");
        $('#keep-playing').on('click', function (event) {
            event.preventDefault();
        });
        $('#game-history').on('click', function (event) {
            event.preventDefault();
        });
        var temp_jugada_2 = "<span class='label_1'>GANAGOL</span>"
            + "<div id='content-grid-result'></div>"
            + "<div id='num_link'></div>";

        $(".left-panel").html(temp_jugada_2);

        $('.finalize-purchase').css("display", "block");


        content_object = [];
        content_object = array_no_procesados;

        array_no_procesados = [];
        new_content_object = [];

        grilla_boletos(content_object);
        grilla_paginada(content_object);

        dataLayerlimpiar = false;
        $(".clear").click();
        dataLayerlimpiar = true;
        var costo_total = 0;
        for (var i in content_object) {
            costo_total += parseFloat(content_object[i][4]);
        }
        $(".result1").html("S/." + floatFormat(costo_total));
        $(".label_resu1").html("TOTAL A PAGAR:");
        $(".label_resu3").html("");
        $(".label_resu4").html("");

    });


    function fecha_actual() {
        var f = new Date();
        var mes = "";
        var dia = "";
        var temp_mes = (f.getMonth() + 1) + "";
        var temp_dia = f.getDate() + "";

        if (temp_mes.length == 1) {
            mes = "0" + (f.getMonth() + 1) + "";
        }
        else {
            mes = (f.getMonth() + 1) + "";
        }

        if (temp_dia.length == 1) {
            dia = "0" + f.getDate() + "";
        }
        else {
            dia = f.getDate() + "";
        }


        return dia + "/" + mes + "/" + f.getFullYear();
    }

    $(".label_2").html(fecha_actual());

    $("#option-card-0").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "")
    });

    $("#option-card-1").click(function () {
        $("#panel_transaccion_1").css("display", "block");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "")
    });

    $("#option-card-2").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "block");
        $("#panel_transaccion_3").css("display", "")
    });

    $("#option-card-3").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "block")
    })
    
function process_add_ons(){
    	
    	total_golazo200 = 0;
        total_golazo200J1 = 0;
        total_golazo200J2 = 0;
        total_golazo200J3 = 0;
        total_golazo200J4 = 0;
        
        add_ongJ1 = 'null';
        add_ongJ2 = 'null';
        add_ongJ3 = 'null';
        add_ongJ4 = 'null';
        
        var golazo200 = " G200";
        
        if (($('#J1check_43').prop('checked') || $('#J1check_44').prop('checked') || $('#J1check_45').prop('checked') 
        	|| $('#J1check_46').prop('checked') || $('#J1check_47').prop('checked') || $('#J1check_48').prop('checked') 
        	|| $('#J1check_49').prop('checked') || $('#J1check_50').prop('checked') || $('#J1check_51').prop('checked') || $('#J1check_52').prop('checked')) && sub_totalJ1>0) {
        	total_golazo200J1 = sub_totalJ1;
            add_ongJ1 = 'AD1';
        }
        
        if (($('#J2check_43').prop('checked') || $('#J2check_44').prop('checked') || $('#J2check_45').prop('checked') 
            	|| $('#J2check_46').prop('checked') || $('#J2check_47').prop('checked') || $('#J2check_48').prop('checked') 
            	|| $('#J2check_49').prop('checked') || $('#J2check_50').prop('checked') || $('#J2check_51').prop('checked') || $('#J2check_52').prop('checked')) && sub_totalJ2>0) {
            	total_golazo200J2 = sub_totalJ2;
                add_ongJ2 = 'AD1';
            }
        
        if (($('#J3check_43').prop('checked') || $('#J3check_44').prop('checked') || $('#J3check_45').prop('checked') 
            	|| $('#J3check_46').prop('checked') || $('#J3check_47').prop('checked') || $('#J3check_48').prop('checked') 
            	|| $('#J3check_49').prop('checked') || $('#J3check_50').prop('checked') || $('#J3check_51').prop('checked') || $('#J3check_52').prop('checked')) && sub_totalJ3>0) {
            	total_golazo200J3 = sub_totalJ3;
                add_ongJ3 = 'AD1';
            }
        
        if (($('#J4check_43').prop('checked') || $('#J4check_44').prop('checked') || $('#J4check_45').prop('checked') 
            	|| $('#J4check_46').prop('checked') || $('#J4check_47').prop('checked') || $('#J4check_48').prop('checked') 
            	|| $('#J4check_49').prop('checked') || $('#J4check_50').prop('checked') || $('#J4check_51').prop('checked') || $('#J4check_52').prop('checked')) && sub_totalJ4>0) {
            	total_golazo200J4 = sub_totalJ4;
                add_ongJ4 = 'AD1';
            }
        
        total_golazo200 =  total_golazo200J1 + total_golazo200J2 + total_golazo200J3 +  total_golazo200J4;
        if(total_golazo200 >0){ 
        	$('#ganagol200-text').html(' + ' + total_golazo200 + golazo200);
        }else{
        	$('#ganagol200-text').html('');
        }	
    	
    }
    
    $('.box-current-game').on('click', function(e){
        e.preventDefault();        
        $('.box-current-game').removeClass('game-playing');
        var v=$('.box-current-game');
        $(this).addClass('game-playing');
        var game = $(this).data('game');
        //game=game.substring(1,game.length);
        // console.log(game);
        $('.box-play-main').hide();
        $('.box-play-'+game).show();

        datalayerMarcarBolillasCotejar( $(this).data('name') , 'Programa' );
        //
        $('input[name="J1check"]:checkbox:checked').length > 0 ? $('div[data-game="primer-part-collator"]').addClass('game-played') : '';
        $('input[name="J2check"]:checkbox:checked').length > 0 ? $('div[data-game="segunda-part-collator"]').addClass('game-played') : '';
        $('input[name="J3check"]:checkbox:checked').length > 0 ? $('div[data-game="tercera-part-collator"]').addClass('game-played') : '';
        $('input[name="J4check"]:checkbox:checked').length > 0 ? $('div[data-game="cuarta-part-collator"]').addClass('game-played') : '';
    });
};
$($Ganagol);


 function partidosDraw(draw){
        var a = '';
         $.ajax({type: "POST", url: "equipos_ganadiario_ajax.html", dataType: "text", data: "dato=" + draw ,async:false, success: function (e) {
                resultJson= $.parseJSON(e); 
                result=e;
                }})
                
                if(resultJson!=null){
                  $.map(resultJson, function (d) { 
                  a += '<div id="grid_ganagol">';
                  a += '<div class="head"><div class="head_title_1">N°</div><div class="head_title_2">Local</div><div class="head_title_3"></div><div class="head_title_4"></div><div class="head_title_5">Visitante</div></div>';

                 $.map(d.idEquipos, function (c,indC) {
                    if(indC%2==0){
                    a += '<div class="content_row row2">' 
                    }else{
                    a += '<div class="content_row row1">' 
                    }
                    
                    a += '<div class="col1">' + c + '</div>'
                    
                    $.map(d.localEq, function (l,indK) {
                    if(indC==indK){
                    a += '<div class="col2">'+l+'</div>'
                    }
                    });
                    
                    $.map(d.localImg, function (li,indKi) {
                        if (indC==indKi) {
                            a += '<div class="col3 gg'+li+'">-</div>'
                        }
                    });
                      
                    $.map(d.visitanteImg, function (vi,indVi) {
                        if (indC==indVi) {
                            a += '<div class="col4 gg'+vi+'">-</div>'
                        }
                    });

                    $.map(d.visitanteEq, function (v,indV) {
                    if(indC==indV){
                    a += '<div class="col5">'+v+'</div>'
                    }
                    });
                    
                    a += '</div>'
                });
                 a += '</div>'
                });
                
                }else{
                $(".row1_collator").hide();
                }
                
                
                
                $("#valorEquipo").html(a);
    }
    