var $Ganagol = function () {
	var costoTotalBetNor=0;
	var precioReg=$("#simpleBetPrice").val();
    var data = [];
    var content_object = [];
    var content_object_3 = [];
    var content_object_2 =[];
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
    var status = $('#status').val();
    var simpleBetPrice = $('#simpleBetPrice').val();
    var algorithm = $('#algorithm').val();
    var bets = $('#bets').val();
    var pay = $('#pay').val();
    var cost = $('#cost').val();
    var total_golazo200 = 0;
    var add_ongJ1 = '';
    var add_ongJ2 = '';
    var add_ongJ3 = '';
    var add_ongJ4 = '';
    var flag200 = false;
    var cantCheckJ1=0;
    var cantCheckJ2=0;
    var cantCheckJ3=0;
    var cantCheckJ4=0;
    

    $('#back_previous').remove();
    $("#menu-item-2").addClass("current-menu-item");
    $("#plays-3").addClass("active");
    var price = $("#price-message").html().replace('Costo por jugada:','').replace('.',' ');
    $("#price-message").html(price);
    
    $('#game-code-header').val(4);
    $('.box-current-game').on('click', function(e){
        if(status!='ACT') return;
        
            var number = $(this).data('number');
            $("#game-ganagol").html(number);
        datalayerJugada(this,'Elige tu Jugada');
        
    });

    if (status == 'CIE') {
        disabled_game();
    }
    $('#part2').hide();
    $('#part3').hide();
    $('#part4').hide();

    if (status == 'ACT' && $('.ganagolList').val() != undefined) {
        for (var i = 0; i < 14; i++) {
            var rows = '';
            rows = $('.ganagolList').eq(i).val();
            var items = '';
            items = rows.split('|');
            var row_object = [];
            for (var j = 0; j < items.length; j++) {
                row_object.push(items[j]);
            }
            data.push(row_object);
        }
        grid_1();
    }
    else {
        $('#allocations').hide();
        disabled_game();
        status='DES';
        $(":checkbox").attr("disabled", true);
    }
    
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
        var grid = '<div class="head">' + '<div class="head_title_1">N°</div>' + '<div class="head_title_2">Local</div>' + '<div class="head_title_3"></div>'
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

            checkPlay(id_value, play, row, idGolazo200);
                      
            if(parseInt(row) == 14 ||  parseInt(row) == 15  ){
	            for(var i=43 ; i<=52 ; i++){	            	
	            	if( parseInt(i) != parseInt(idGolazo200)){
	            		$('#' + play + 'check_' + i ).prop('checked', false);
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
                    
                    if(idGolazo200>= 43 && idGolazo200 <= 52)
                    	datalayerFinalizaCompra1(this.value,'Jugar');
                
	                } else {
	                    $('#' + id_value).prop('checked', false);
	                    update_array_bet(play);
	                    calculate_bet(play);
	                    jAlert('No puede agregar al carrito de compras porque hay un límite de 288 apuestas en Ganagol');
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
        $('.random').on('click', function () {
            if (Sub_Total > 288) {
            	jAlert('No puede agregar al carrito de compras porque hay un límite de 288 apuestas en Ganagol');
            	return;
            }
                var count = 1;
                flag200 = false;
                var play = $(this).attr('id').substr(0, 2);
                option = find_option(play);
                array_row = find_array_row(play);
                if (option == 0 && array_row.length > 0) {
                    clear_unmarket(play);
                    process_add_ons();
                } else {
                	if(total_golazo200<0){
                		clear(play);
                	}else{
                		clear(play);
                		update_array_bet(play);
                        calculate_bet(play);
                        show_bet(play);
                	}
                    
                }
                while (array_row.length + count <= 14) {
                    var random = Math.floor(Math.random() * (42 - 1 + 1)) + 1;
                    $('.check').each(function () {
                        if ($(this).attr('id').substr(0, 2) == play && $(this).attr('id').substr(8, 2) == random && !$(this).is(':checked')) {
                            var row = $(this).data('row');
                            var row_mark = row_marked(play, row);
                            if (!row_mark) {
                                $(this).prop('checked', true);
                                $('#L' + $(this).attr('id')).addClass('colorChecked');
                                count++;
                            }
                        }
                    });
                }
                update_array_bet(play);
                calculate_bet(play);
                show_bet(play);
                if (array_row.length > 0) {
                    update_option(play, 0);
                } else {
                    update_option(play, 1);
                }            
            datalayerJugada(this,'Elige tu Jugada');
                tagginAlAzar("Ganagol");
             
        });
    }
    if (status == 'ACT') {
        $('.local').on('click', function () {
            if (Sub_Total < 288) {
            var play = $(this).attr('id').substr(0, 2);
            option = find_option(play);
            array_row = find_array_row(play);
            if (option == 0 && array_row.length > 0) {
                clear_unmarket(play);
            } else {
                clear(play);
            }
            $('.check').each(function () {
                if ($(this).attr('id').substr(0, 2) == play && $(this).val() == 'L') {
                    var row = $(this).data('row');
                    var row_mark = row_marked(play, row);
                    if (!row_mark) {
                        $(this).prop('checked', true);
                        $('#L' + $(this).attr('id')).addClass('colorChecked');
                    }
                }
            });
            update_array_bet(play);
            calculate_bet(play);
            show_bet(play);
            if (array_row.length > 0) {
                update_option(play, 0);
            } else {
                update_option(play, 2);
            }
            }
            else{
                jAlert('No puede agregar al carrito de compras porque hay un límite de 288 apuestas en Ganagol');
            }
        });
    }
    if (status == 'ACT') {
        $('.equal').on('click', function () {
            if (Sub_Total < 288) {
            var play = $(this).attr('id').substr(0, 2);
            option = find_option(play);
            array_row = find_array_row(play);
            if (option == 0 && array_row.length > 0) {
                clear_unmarket(play);
            } else {
                clear(play);
            }
            $('.check').each(function () {
                if ($(this).attr('id').substr(0, 2) == play && $(this).val() == 'E') {
                    var row = $(this).data('row');
                    var row_mark = row_marked(play, row);
                    if (!row_mark) {
                        $(this).prop('checked', true);
                        $('#L' + $(this).attr('id')).addClass('colorChecked');
                    }
                }
            });
            update_array_bet(play);
            calculate_bet(play);
            show_bet(play);
            if (array_row.length > 0) {
                update_option(play, 0);
            } else {
                update_option(play, 3);
            }
            }
            else{
                jAlert('No puede agregar al carrito de compras porque hay un límite de 288 apuestas en Ganagol');
            }
        });
    }
    if (status == 'ACT') {
        $('.visit').click(function () {
            if (Sub_Total < 288) {
            var play = $(this).attr('id').substr(0, 2);
            option = find_option(play);
            array_row = find_array_row(play);
            if (option == 0 && array_row.length > 0) {
                clear_unmarket(play);
            } else {
                clear(play);
            }
            $('.check').each(function () {
                if ($(this).attr('id').substr(0, 2) == play && $(this).val() == 'V') {
                    var row = $(this).data('row');
                    var row_mark = row_marked(play, row);
                    if (!row_mark) {
                        $(this).prop('checked', true);
                        $('#L' + $(this).attr('id')).addClass('colorChecked');
                    }
                }
            });
            update_array_bet(play);
            calculate_bet(play);
            show_bet(play);
            if (array_row.length > 0) {
                update_option(play, 0);
            } else {
                update_option(play, 4);
            }
            }
            else{
                jAlert('No puede agregar al carrito de compras porque hay un límite de 288 apuestas en Ganagol');
            }
        });
    }
    if (status == 'ACT') {
        $('.clear').click(function () {
            var play = $(this).attr('id').substr(0, 2);
            if(play=='J1'){
                $('div[data-game="a"]').removeClass('game-played');
            }else if(play=='J2'){
                $('div[data-game="b"]').removeClass('game-played');
            }else if(play=='J3'){
                $('div[data-game="c"]').removeClass('game-played');
            }else if(play=='J4'){
                $('div[data-game="d"]').removeClass('game-played');
            }
            clear(play);
            datalayerJugada(this,'Elige tu Jugada');
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
        
        
        $('#total_bet').html('0');
        $('#ganagol200-text').html('');
        cantCheckJ1=0;
        cantCheckJ2=0;
        cantCheckJ3=0;
        cantCheckJ4=0;
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
        optionJ4 = 0;
        optionJ4 = 0;
        flag200=false;
        
        update_array_bet(play)
        process_add_ons();
        calculate_bet(play);       
        show_bet(play);
    }

    // Actualiza el arreglo de apuestas marcadas
    function update_array_bet(play) {
        if (play == 'J1') {
            betJ1 = [];
            var i = 0;
            var aux = '';
            while (i < 16) {
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
            while (i < 16) {
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
            while (i < 16) {
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
            while (i < 16) {
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

    var costoTotalBet = 0;

    function calculate_bet(play) {
    	    	   	
	        if (play == 'J1') {	        	
	        	if(!flag200){	        	
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
		                process_add_ons();//test
		                
		        	}else {
		            	if(betJ1.length < 15){            		
		            		sub_totalJ1 = 0;
		            		flag200 = false;
		            	}else{
		            		flag200 = true;
		                	process_add_ons();
		            	}		               		            	
		            }       
	        	}else{
	        		
	        		 var temp = 0;
		                var ini = 0;
		                for (var i = 0; i < 14; i++) {
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
		                process_add_ons();
	        		
	        		if (($('#J1check_43').prop('checked') || $('#J1check_44').prop('checked') || $('#J1check_45').prop('checked') 
	        	        	|| $('#J1check_46').prop('checked') || $('#J1check_47').prop('checked') || $('#J1check_48').prop('checked') 
	        	        	|| $('#J1check_49').prop('checked') || $('#J1check_50').prop('checked') || $('#J1check_51').prop('checked') || $('#J1check_52').prop('checked')) ) {
	        			flag200 = true;	        	            
	        	     }else{
	        	    	 flag200 = false;
	        	    	 total_golazo200J1=0;
	 	        		 process_add_ons();
	        	     }	        		        		
	        	}
	        } 	
        
	        if (play == 'J2') {	        	
	        	if(!flag200){	        	
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
		                process_add_ons();//test
		        	}else {
		            	if(betJ2.length < 15){            		
		            		sub_totalJ2 = 0;
		            		flag200 = false;
		            	}else{
		            		flag200 = true;
		                	process_add_ons();
		            	}		               		            	
		            }       
	        	}else{
	        		
	        		var temp = 0;
	                var ini = 0;
	                for (var i = 0; i < 14; i++) {
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
	                process_add_ons();
	        		
	        		if (($('#J2check_43').prop('checked') || $('#J2check_44').prop('checked') || $('#J2check_45').prop('checked') 
	        	        	|| $('#J2check_46').prop('checked') || $('#J2check_47').prop('checked') || $('#J2check_48').prop('checked') 
	        	        	|| $('#J2check_49').prop('checked') || $('#J2check_50').prop('checked') || $('#J2check_51').prop('checked') || $('#J2check_52').prop('checked')) ) {
	        			flag200 = true;	        	            
	        	     }else{
	        	    	 flag200 = false;
	        	    	 total_golazo200J2=0;
	 	        		 process_add_ons();
	        	     }	        		        		
	        	}
	        } 	
	        if (play == 'J3') {	        	
	        	if(!flag200){	        	
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
		                process_add_ons();//test
		        	}else {
		            	if(betJ3.length < 15){            		
		            		sub_totalJ3 = 0;
		            		flag200 = false;
		            	}else{
		            		flag200 = true;
		                	process_add_ons();
		            	}		               		            	
		            }       
	        	}else{	
	        		
	        		var temp = 0;
	                var ini = 0;
	                for (var i = 0; i < 14; i++) {
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
	                process_add_ons();
	        		
	        		if (($('#J3check_43').prop('checked') || $('#J3check_44').prop('checked') || $('#J3check_45').prop('checked') 
	        	        	|| $('#J3check_46').prop('checked') || $('#J3check_47').prop('checked') || $('#J3check_48').prop('checked') 
	        	        	|| $('#J3check_49').prop('checked') || $('#J3check_50').prop('checked') || $('#J3check_51').prop('checked') || $('#J3check_52').prop('checked')) ) {
	        			flag200 = true;	        	            
	        	     }else{
	        	    	 flag200 = false;
	        	    	 total_golazo200J3=0;
	 	        		 process_add_ons();
	        	     }	        		        		
	        	}
	        } 	
	        if (play == 'J4') {	        	
	        	if(!flag200){	        	
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
		                process_add_ons();//test
		        	}else {
		            	if(betJ4.length < 15){            		
		            		sub_totalJ4 = 0;
		            		flag200 = false;
		            	}else{
		            		flag200 = true;
		                	process_add_ons();
		            	}		               		            	
		            }       
	        	}else{	
	        		
	        		var temp = 0;
	                var ini = 0;
	                for (var i = 0; i < 14; i++) {
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
	                process_add_ons();
	        		
	        		if (($('#J4check_43').prop('checked') || $('#J4check_44').prop('checked') || $('#J4check_45').prop('checked') 
	        	        	|| $('#J4check_46').prop('checked') || $('#J4check_47').prop('checked') || $('#J4check_48').prop('checked') 
	        	        	|| $('#J4check_49').prop('checked') || $('#J4check_50').prop('checked') || $('#J4check_51').prop('checked') || $('#J4check_52').prop('checked')) ) {
	        			flag200 = true;	        	            
	        	     }else{
	        	    	 flag200 = false;
	        	    	 total_golazo200J4=0;
	 	        		 process_add_ons();
	        	     }	        		        		
	        	}
	        } 	
        
        Sub_Total = sub_totalJ1 + sub_totalJ2 + sub_totalJ3 + sub_totalJ4;
        
        if(!flag200){
        	if(Sub_Total == parseInt(0)){
        		$('#total_bet').text(Sub_Total);
        	}else{
        		$('#total_bet').text(Sub_Total + 'GG');
        	}
        	          	 
        }else{
        	$('#total_bet').text(Sub_Total + 'GG');
        }
        
        
        
       
//        var costoTotalBet = 0;
        if (Sub_Total >= 1) {
            if (algorithm == "BETS") {

                costoTotalBet = callTransformByBets(Sub_Total, simpleBetPrice, bets, pay);
            }
            else if (algorithm == "COST") {
                costoTotalBet = callTransformByCostGanagol(Sub_Total + total_golazo200*0.5, simpleBetPrice, bets, cost);
            }
            else {
                costoTotalBet = Sub_Total  * simpleBetPrice + total_golazo200;
            }
            $('#total_apagar').html(floatFormat(costoTotalBet));
        
            costoTotalBetNor= Sub_Total * simpleBetPrice;
            
        } else {
            $('#total_apagar').html(0);
        }
    }
    
    function callTransformByCostGanagol(p_Sub_Total, p_simpleBetPrice, p_bets, p_cost){
    	var var_total_cost = 0;
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(var_sum_total_bet_consecutive / p_bets) * (p_bets * p_data_value_bet - p_cost)));
        return var_total_cost;
    }
    
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
    
    var thisBtnComprarGanagol = null;
    $("#btn_desktop_comprar_boleto_ganagol").click(function () {
    	thisBtnComprarGanagol = this;
    	// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
    	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
    	mainValidatePendingsDocsForAproval('lottoGanagolComprarBoletoGanagol');
    });

    $("#more_plays").click(function () {
        //
    	add_ongJ1 ='';
    	add_ongJ2 ='';
    	add_ongJ3 ='';
    	add_ongJ4 ='';
    	sub_totalJ1 = 0;
        sub_totalJ2 = 0;
        sub_totalJ3 = 0;
        sub_totalJ4 = 0;
        total_golazo200=0;
        $('#ganagol200-text').text('');
        $('.step-play').removeClass('step-active');
        $('.step-status-1').addClass('step-active');
        $('.wrapper-playing').show();
        $('.wrapper-buying').hide();
        $('.box-current-game').removeClass('game-played');
        dataLayerlimpiar = false;
        $(".clear").click();
        dataLayerlimpiar = true;
        $('div[data-game="a"]').click();
        //$(".clear").click();
        datalayerFinalizaCompra2(this,"Agregar Jugadas");
    });
    $('#game-history').on('click', function (event) {
        event.preventDefault();
    });
    
    function comprarBoletoGanagol() {
    	if (status != 'ACT') {
        	return;
        }
        if (Sub_Total < 1) {
        	let message = 'No ha realizado ninguna jugada.';
        	jAlert(message, null);
            tagginPopupError("Ganagol", message);
            datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar', message);
            return;
        }
        
            	$("#index-btnlogin").prop("disabled",true);
                //
                $('.step-play').removeClass('step-active');
                $('.step-status-2').addClass('step-active');
                $('.wrapper-playing').hide();
                $('.wrapper-buying').show();
                var precioNormal=costoTotalBetNor;               
                var cant_sorteo = $("#mySelectBox").val();
                add_ticket(content_object, betJ1, betJ2, betJ3, betJ4,cant_sorteo, $("#total_apagar").html(),add_ongJ1,add_ongJ2,add_ongJ3,add_ongJ4,precioNormal);
               
        
        
                $("#back").click();
                $("#back").click();
                $("#back").click();
                $("#back").click();

                var costo_total = 0;
                for (var i in content_object) {
                    costo_total += parseFloat(content_object[i][6].replaceAll(',',''));
                }

                for (var v in content_object) {
                    for (var w = 0; w <= 3; w++) {
                        var game = "";
                        if (content_object[v][w] == "") {
                            content_object[v][w] = "00";
                        }
                    }
                }

                content_object_2=content_object.sort(function(prev,next){
                    return next[4]-prev[4];
                    });                
                var pendientes_gratis=0;
                if($('.result5').text()!=""){
                	pendientes_gratis = $('.result5').text()*precioReg;
                	
                }
                else{
                	 pendientes_gratis = $('#balanceAmountGame').val();
                }
                costo_total = 0
                var gratis_total = 0
                 
                for (var v in content_object_2) {
                	var precio_cu = parseFloat(content_object_2[v][6].replaceAll(',',''));
                	var precioNor=parseFloat(content_object_2[v][12]);
                	if(precio_cu!=precioNor){                		
                		if(content_object_2[v][8]=="AD1" || content_object_2[v][9]=="AD1" 
                			|| content_object_2[v][10]=="AD1" || content_object_2[v][11]=="AD1"){
               		 
                			 if(precio_cu <= pendientes_gratis){
                				 content_object[v][19]=0;
                             	gratis_total =parseFloat(gratis_total)+ parseFloat(precio_cu);
                             	pendientes_gratis = parseFloat(pendientes_gratis)-parseFloat(precio_cu);
                             } else {
                            	 content_object[v][19]=(parseFloat(precio_cu));
                             	costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
                              }
                		}
                			
                		
                	}else{
                    if(precio_cu <= pendientes_gratis){
                    	gratis_total =parseFloat(gratis_total)+parseFloat(precio_cu);
                    	pendientes_gratis = parseFloat(pendientes_gratis)-parseFloat(precio_cu);
                    } else {
                    	costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
                    }
                    }
                }
                
                grilla_boletos(content_object_2);
                grilla_paginada(content_object_2);
                tagginGGEEaddToCart(costoTotalBet);
                
                $(".result1").html("S/ " + floatFormat(costo_total));
                $("#totalPagar").text(costo_total);
                $(".label_resu2").html($("#price-message").text());
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
               
                taggingGGFinalizar();
                tagginGGEEcheckout(content_object);
        
        let pos = content_object_2.length - 1;
        let jugadas = content_object_2[pos][14];
        
        let jugadaGanagol = [content_object_2[pos][0],content_object_2[pos][1],content_object_2[pos][2],content_object_2[pos][3]];
        let precioUnitario = (content_object_2[pos][12]) / jugadas ;
        datalayerAddToCart(jugadaGanagol,precioUnitario);
        
    	datalayerFinalizaCompra1(thisBtnComprarGanagol,'Comprar');
    }

    function add_ticket(content_object, juego1, juego2, juego3, juego4,cant_sorteo, precio,add_ongJ1,add_ongJ2,add_ongJ3,add_ongJ4,costoTotalBetNor) {
    	var estado = "null";
        var object_boleto = [];
        object_boleto.push(juego1);
        object_boleto.push(juego2);
        object_boleto.push(juego3);
        object_boleto.push(juego4);
		object_boleto.push(estado);
        object_boleto.push("1");
        object_boleto.push(precio);
		object_boleto.push("0");
        object_boleto.push(add_ongJ1);
        object_boleto.push(add_ongJ2);
        object_boleto.push(add_ongJ3);
        object_boleto.push(add_ongJ4);
        object_boleto.push(costoTotalBetNor);
        object_boleto.push($('#ganagol200-text').text());
		object_boleto.push(total_golazo200);
        
        content_object.push(object_boleto);
        juego1 = [];
        juego2 = [];
        juego3 = [];
        juego4 = [];
    }

    function grilla_boletos(data) {

        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var grilla = "<div>"
            + "<div class='boleto_cabecera'>"
            + "<div class='head_title_1'>N.</div>"
            + "<div class='head_title_2'>JUGADAS</div>"
            + "<div class='head_title_3'>ANULAR</div>"
            + "</div>";
        +"<div id='total_filas'>";
        var add_ong = '';

        for (var x in data) {
            for (var i = 0; i <= 3; i++) {
                if (data[x][i] != "") {
                    if (data[x][i] != "00") {
                    	add_ong= $.trim(data[x][i + 8]);
                    	if(add_ong == ''){
                   		 add_ong = 'null';
                   	 	}
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
            
            if (add_ong != 'null') {
                result_ticket = result_ticket + ' / G200'
            }
            
            if (x % 2 != 0) {
                style += " row_grid_mouseover";
            }

            if (x > 2) {
                style += " row_null";
            }
            grilla += "<div class='" + style + "'>"
                + "<div class='column_1'>" + (parseInt(x) + 1) + "</div>"
                + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>"
                + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>"
                + "<div class='column_3'>"
                + "<div class='delete process-delete1' rel='" + x + "'>x</div>"
                + "</div>"
                + "</div>";
        }
        grilla += "</div></div>";

        $('#content-grid-result').html(grilla);
    }

    function grilla_paginada(data) {
        var count_rows = data.length;
        var links = "";
        var cont = 0;
        var style = "";
        var posx = 0;
        var posy = 1;
        var posz = 2;


        for (var i = 0; i < count_rows; i++) {

            if (i == 0) {
                style = "num_page_off";
            }
            else {
                style = "num_page_on";
            }
            if (i % 3 == 0) {
                cont++;
                links += "&nbsp;<a class='lnk-pag1 lnk " + style + " ' id='" + posx + "-" + posy + "-" + posz + "' rel='" + posx + "-" + posy + "-" + posz + "' >" + cont + "</a>&nbsp;";
                posx = posx + 3;
                posy = posy + 3;
                posz = posz + 3;

            }
        }
        $('#num_link').html("<span class='indice_page'>1</span> de " + cont + "<span class='pages-links'><" + links + "></span>");
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
        var content_infoAux= "";
        var content_infoFinal = "";
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        for (var i = 0; i <= 3; i++) {
            content_object[posicion][i] = $.trim(content_object[posicion][i] + "");
            if (content_object[posicion][i] != 0) {
                if (content_object[posicion][i] != "null") {
                	var add_ong = '';
                	 add_ong = $.trim(content_object[posicion][i + 8]);
                	 if(add_ong == ''){
                		 add_ong = 'null';
                	 }
                    var test = (content_object[posicion][i] + "").split("-");
                    if (test[1] != "null") {
                        var numeros = (content_object[posicion][i] + "").split(",");
                        var result_ticket = "";
                        for (var num in numeros) {
                            if (numeros[num].length < 2) {
                                numeros[num] = "0" + numeros[num];
                            }
                            if(num==14){
                            	numeros[num]='/ G200 '+numeros[num].substring(2);
                            }
                            result_ticket += numeros[num] + " ";
                        }
                        content_info = nom_jugadas[i] + ": " + result_ticket;
                        content_info = content_info.trim();
                                                                              
	                        if (add_ong != 'null') { 	                        	
	                            content_infoFinal += content_info + "<br>";
	                        }else{
	                        	content_infoFinal += content_info + "<br>";
	                        }
                        
    
                    }
                }
            }
        }
        $(".tooltip-info").eq(posicion).css("display", "block");
        $(".tooltip-info").eq(posicion).html(content_infoFinal);
        $(".tooltip-info-arrow-img").eq(posicion).css("display", "block");
    });
    $('.left-panel').on('mouseout', '.row-info', function () {
        var posicion = $(this).attr("rel");
        $(".tooltip-info").eq(posicion).css("display", "none");
        $(".tooltip-info-arrow-img").eq(posicion).css("display", "none");
    });

    $('.left-panel').on('click', '.process-delete1', function () {
        var pos = parseInt($(this).attr("rel"));
        
        let jugadas = content_object_2[pos][14];
        let jugadaGanagol = [content_object_2[pos][0],content_object_2[pos][1],content_object_2[pos][2],content_object_2[pos][3]];
        let precioUnitario = (content_object_2[pos][12]) / jugadas ;
        datalayerRemoveFromCart(jugadaGanagol,precioUnitario);
        
        tagginGGEEremoveFromCart(content_object_2[pos][4]);
        content_object_2.splice(pos, 1);
        grilla_boletos(content_object_2);
        grilla_paginada(content_object_2);

        var pendientes_gratis2 = $('#balanceAmountGame').val();
        var costo_total2 = 0
        var gratis_total2 = 0

        for (var v in content_object_2) {
        	var precio_cu2 = parseFloat(content_object_2[v][6]);
        	if(content_object_2[v][6]!=parseFloat(content_object_2[v][19])){
        		
        		costo_total2 =parseFloat(costo_total2)+ parseFloat(precio_cu2);
        	}else{
            if(precio_cu2 <= pendientes_gratis2){
            	gratis_total2 =parseFloat(gratis_total2)+ parseFloat(precio_cu2);
            	pendientes_gratis2 = parseFloat(pendientes_gratis2)-parseFloat(precio_cu2);
            } else {
            	costo_total2 =parseFloat(costo_total2)+ parseFloat(precio_cu2);
            }
         }
        }

         $(".result1").html("S/ " + floatFormat(costo_total2)); 	    
 	     $("#totalPagar").text(costo_total2);
        content_object=content_object_2;
        if(content_object.length==0){
            $('#more_plays').click();
        }
    });
    var new_content_object = [];
    var thisBtnFinalizaCompraGanagol = null;
    $('#content-purchase').on('click', '#btn_desktop_finalizar_compra_ganagol', function () {
    	thisBtnFinalizaCompraGanagol = this;
    	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
    	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
    	mainValidatePendingsDocsForAproval('lottoGanagolFinalizarCompraGanagol');
    });
    
    function finalizarCompraGanagol() {
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
        	datalayerFinalizaCompra2(thisBtnFinalizaCompraGanagol,'Finalizar Compra');
        	let pos = content_object_2.length - 1;
        	let jugadas = content_object_2[pos][14];
            let jugadaGanagol = [content_object_2[pos][0],content_object_2[pos][1],content_object_2[pos][2],content_object_2[pos][3]];
            let precioUnitario = (content_object_2[pos][12]) / jugadas ;
            datalayerCheckout(jugadaGanagol,precioUnitario);
        	
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

                $("#panel_more_plays").css("display", "none");
                $("#panel_keep-playing").css("display", "block");
                $("#panel_game-history").css("display", "block");
                $("#ico-block").css("display", "block");
                $(".label-top").css("display", "block");
                $("#sub_panel").css("display", "none");
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
                            if(num == numeros.length-1){
                            	numeros[num]=numeros[num].replace('-','');
                            }
                            result_ticket += numeros[num] + " ";
                        }
                    }
                }

                $("#ajax-loader").show();

                var contador = 0;
                $.ajax({
                    type: "POST",
                    url: "ajaxGanagol.html",
                    dataType: "text",
                    data: "dato=" + $.trim(result_ticket),
                    success: function (data) {
                    	    var out = (data + "");
                    	    if (out=='') {
                                jAlert("No se cuenta con una sesion para realizar su jugada.");
                    	    } else {
                    	    	//var new_content_object = [];
                    	    	/* var filas = (e + "").split("#");
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
		                            for(var m = 1; m < columns.length; m++) {
		                            	row.push($.trim(columns[m]));
		                            }
		
		                            new_content_object.push(row);
		                        }
		                        content_object = [];
		                        content_object = new_content_object;*/
                    	    	content_object_3=content_object;
                    	    	
                    	    	 var fila = data.split("#");
                                 for (var n = 0; n < fila.length; n++) {
                                     var items = (fila[n] + "").split("|");
                                     var row_object = [];
                                     for (var m = 0; m < items.length; m++) {
                                         row_object.push(items[m].trim());
                                     }
                                      
                                     new_content_object.push(row_object);
                                 }
                    	    	
		
		                        grilla_boletos2(new_content_object);
		                        grilla_paginada(new_content_object);
		
		                        $(".label_resu3").html("<b>Saldo Disponible: <div class='text-detail-pay detail-pay-monto'>S/ " + floatFormat(new_content_object[(new_content_object.length - 1)][14]) + "</div>");
		                        var promotional_balance = parseFloat(new_content_object[(new_content_object.length - 1)][11]);
		                        if (promotional_balance > 0) {
		                            $(".label_resu4").html("<b>Saldo Promocional: <div class='text-detail-pay detail-pay-monto'>S/ " + new_content_object[(new_content_object.length - 1)][11] + "</div>");
		                        }
		                        $("#clientSale-amount").text(floatFormat(new_content_object[(new_content_object.length - 1)][14]));
		                        $("#clientSale-amount-2").text(floatFormat(new_content_object[(new_content_object.length - 1)][14]));
		                        $("#billetera3-amount").text(floatFormat(new_content_object[(new_content_object.length - 1)][17]));
		                        $("#ajax-loader").css("display", "none");
		                        var costo_juego = parseFloat(new_content_object[(new_content_object.length - 1)][16]);
		                        var costo_otro = parseFloat(new_content_object[(new_content_object.length - 1)][17]);
		                        var costo_total = 0;
		                        for (var u = 0; u < new_content_object.length; u++) {
		                        	 var procesos = (new_content_object[u][4] + "").split("&");
		                            if (procesos[1] != "null") {
		                                $(".label-top").html("&#161;GRACIAS POR TU COMPRA!");
		                                costo_total += parseFloat(new_content_object[u][6]);
		                               
		                            } else {
		                                break;
		                            }
		                        }
		                        
		                        
		                        var pendientes_gratis3 = $('#balanceAmountGame').val();
		                        var costo_total3 = 0
		                        var gratis_total3 = 0
		                        for (var v in new_content_object) {
			                        	var precio_cu3 = parseFloat(new_content_object[v][6]);
			                        	if(parseFloat(content_object_2[v][6])!=parseFloat(content_object_2[v][12])){
											if(content_object_2[v][8]=="AD1" || content_object_2[v][9]=="AD1" 
												|| content_object_2[v][10]=="AD1" || content_object_2[v][11]=="AD1"){
											
												var cadena=new_content_object[v][4];
												var cadenaPa=cadena.substring(0, 2);
												if(cadenaPa=="OK"){
													
													if(precio_cu3 <= pendientes_gratis3){	
													gratis_total3 =parseFloat(gratis_total3)+ parseFloat(precio_cu3);
													content_object_3[v][7]=0;													
													pendientes_gratis3 = parseFloat(pendientes_gratis3)-parseFloat(precio_cu3);
													}else {
														costo_total3 =parseFloat(costo_total3)+ parseFloat(precio_cu3);
														content_object_3[v][7]=parseFloat(precio_cu3);
													}
												
												}
											}
			                        	}
			                        	else{
				                            if(precio_cu3 <= pendientes_gratis3){
				                            	gratis_total3 =parseFloat(gratis_total3+ precio_cu3);
				                            	pendientes_gratis3 = parseFloat(pendientes_gratis3-precio_cu3);
				                            	content_object_3[v][7]=0;
				                            } else {
				                            	var cadena2=new_content_object[v][4];
				                    			var cadenaPa2=cadena2.substring(0, 2);
				                    			if(cadenaPa2=="OK"){
				                            	costo_total3 =parseFloat(costo_total3)+ parseFloat(precio_cu3);
				                            	content_object_3[v][7]=parseFloat(precio_cu3);
				                    			}
				                            }
			                        }
		                        }
		                        
		                        
		                        
		                        $(".result1").html("S/ " + floatFormat(costo_total3));

		                        $(".label_resu1").html("TOTAL PAGADO:");
		                        //if(floatFormat(costo_juego)>0){
		                      	$('.result5').html((!isNaN(costo_juego))?costo_juego:"0");
		                      	$('.label_resu5').html("Jugadas gratis:");
		                      	$('.labelMsgJugadaGratis').html("");
		                        //}
		                      	if(!isNaN(costo_otro)) $("#billetera3-amount").text(costo_otro);
		                        $('#keep-playing').off('click');
		                        $('#game-history').off('click');
		                    }
                    	    
                    	    if(!$('.label-top').find('div').length){                    	
                            	tagginGGCompraExitosa();
                            	tagginGGEEpurchase(new_content_object, content_object_3);
                            	finalizaCompra2 = false;
                            	var cupon =  "undefined";
                            	if($("#priceType").val() !== 'NOR')
    								cupon = $("#priceMessage").val();
                            	
                            	for(let pos=0;pos<content_object_2.length;pos++){
                            		let jugadas = content_object_2[pos][14];
                                	let jugadaGanagol = [content_object_2[pos][0],content_object_2[pos][1],content_object_2[pos][2],content_object_2[pos][3]];
                                	let precioUnitario = (content_object_2[pos][12]) / jugadas ;
                                	
        							datalayerPurchase(jugadaGanagol,
        												precioUnitario,
        											  '¡Gracias por tu Compra!',
        											  costo_total3,
        											  'Ganagol-'+procesos[1],
        											  cupon);
                            	}
                            }
	                    }
                });

            } else {
                jAlert("No se tiene jugadas por procesar");
            }
            if (option == 1) jAlert("Se ha realizado una recarga de saldo.\n\nMonto cargado: S/  " + amount + "\nTu saldo es: S/ " + newamount, null);
        } else {
            if (option == 1) jAlert("No se ha logrado realizar la recarga.\n" + message + "\n\nMonto cargado: S/ " + amount + "\nTu saldo es: S/ " + newamount, null);
        }
    }
    
    window.addEventListener("message", function(event) {
        if (event.data === "lottoGanagolComprarBoletoGanagol") {
        	comprarBoletoGanagol(); 
        } else if (event.data === "lottoGanagolFinalizarCompraGanagol") {
        	finalizarCompraGanagol(); 
        }
    });

    function grilla_boletos2(data) {

        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var no_process_message_count = 0;
        var grilla = "<div>"
            + "<div class='boleto_cabecera'>"
            + "<div class='head_title_1'>N.</div>"
            + "<div class='head_title_2'>BOLETOS</div>"
            + "<div class='head_title_3'>VER</div>"
            + "</div>";
        +"<div id='total_filas'>";

        var label="";
        for (var x in data) {
            for (var i = 0; i <= 3; i++) {
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
            var style = "row_grid";
            if (x % 2 != 0) {
                style += " row_grid_mouseover";
            }
            if (x > 2) {
                style += " row_null";
            }

            var process_resp = "";
            var dato_proceso = data[x][4].split("&");

            if (dato_proceso[1] == "null") {
                process_resp = "<div class='column3-no-process'><span class='no-process' rel='" + no_process_message_count + "#" + dato_proceso[0] + "'>No procesado&nbsp;&nbsp;[?]</span> </div>";
                process_resp += "<div class='tooltip-no-process'></div><div class='tooltip-no-process-arrow-img'></div></div>";
                no_process_message_count++;

                var relValue = dato_proceso[0]+ "";
                var game_no_process_autocontrol = "";
                // Verifica si mensaje de error contiene la palabra autoexclusion
                if (relValue.includes("autoexclusion") || relValue.includes("autoexclusión") ) {
                    
                    game_no_process_autocontrol = "<div class='text-autocontrol' >Ir a la sección <a id='link-autocontrol'  href='mi-cuenta.html#yo-autocontrol'>Autocontrol</a></div>";
                } 
                
                var game_no_process_info = "<div class='title-text text-autocontrol'>"
                	+ "<div>Tienes jugadas que no se han podido procesar.</div> " + game_no_process_autocontrol  + " </div>"
                    + "<div id='no-process-section'><a href='#' class='button button-block button-dark-green' id='btn-no-process' onclick='return false;'><b>VOLVER</b></a></div>";
                $("#game-no-process-info").html(game_no_process_info);
                $(".label-top").html("<div class='no-process-play'>JUGADAS NO PROCESADAS</div>");
                $("#game-no-process-info").css("display", "block");
                label=dato_proceso[0];
            } else {

                process_resp = "<div class='column3-codigo'>" + dato_proceso[1] + "</div><div class='column3-search' onclick='openPreviewWindow(openPreviewWindow(" + data[x][13] + ",\"" + data[x][12] + "\",\"" + dato_proceso[1] + "\"))'></div>";

            }

            grilla += "<div class='" + style + "'>"
                + "<div class='column_1'>" + (parseInt(x) + 1) + "</div>"
                + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>"
                + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>"
                + process_resp
                + "</div>";
        }


        grilla += "</div></div>";

        $('#content-grid-result').html(grilla);
        
      //taggin jugadas no procesadas
        if($(".label-top > div").text()==='JUGADAS NO PROCESADAS'){
        	tagginJugadaNoProcesada("Ganagol", label);
        }
    }

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
        for (var i in new_content_object) {
        	//Obtenemos mensaje y ticket
        	var procesos=(new_content_object[i][4]+'').split('&');
            if (procesos[1] == "null") {
                array_no_procesados.push(content_object[i]);
                contador++;
            }
        }
        $("#panel_keep-playing").css("display", "none");
        $("#panel_game-history").css("display", "none");
        $("#ico-block").css("display", "none");
        $("#panel_finaliza_compra").css("display", "block");
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
            costo_total += parseFloat(content_object[i][6].replaceAll(',',''));
        }
        $(".result1").html("S/ " + floatFormat(costo_total));
        $(".label_resu1").html("TOTAL A PAGAR:");
        $(".label_resu3").html("");
        $(".label_resu4").html("");

    });

    var idsession = $("#clientId").val();
    if(idsession != '' && $("#agreement").val() == ''){
    	$("#login_section").css("display", "block");
    	exe.opentyc(null);
    } else if (idsession == '') {
        $("#login_section").css("display", "block");
    } else {
        $("#panel_finaliza_compra").css("display", "block");
        $("#tab-item_4").show();
        $("#payments_section").css("display", "block");
    }

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
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    });

    $("#option-card-1").click(function () {
        $("#panel_transaccion_1").css("display", "block");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    });

    $("#option-card-2").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "block");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    });

    $("#option-card-3").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "block");
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    })
    
    	$("#option-card-4").click(function () {
		$("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").css("display", "block");
		$("#panel_transaccion_5").css("display", "");
	})
	
	$("#option-card-5").click(function () {
		$("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_5").css("display", "block");
		$("#panel_transaccion_4").css("display", "");
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
                        rows.push(columnClientResult[j])
                    }
                    dataClientResult.push(rows)
                }
                run.grilla(dataClientResult);
                run.grilla_paginada(dataClientResult);
                dataClientResult = []
            }            
        }})
    });
	 
	 /*$('.button-group-item .ejemplo').on('click', function(e){
	        e.preventDefault();
	        //$('.box-current-game').removeClass('game-playing');
			console.log('test');
	       
	    });*/
	
	function viewNext(){
		$('#password-client-header').val('');
    	$('#password-client').val('');
		$(".logout").show();
        $(".unlogout").hide();
        $("#tab-item_4").show();
        $("#payments_section").show();
        $("#login_section").css("display", "");
        $("#panel_finaliza_compra").show();
	}
	
	function checkPlay(id_value, play, row, idGolazo200){
		var cantCheck = 0;
		for (var i = 1; i <= 42; i++) {
			if ($('#' + play + 'check_' + i).is(':checked')) {
				cantCheck++;
			}
		}

		if (cantCheck >= 14) return;
		
		flag200 = false;

		for (var i = 43; i <= 52; i++) {
			$('#' + play + 'check_' + i).prop('checked', false);
		}

		$('#L' + id_value).removeClass('colorChecked');
		update_array_bet(play);
		calculate_bet(play);
		delete_array_row(play, row);
		show_bet(play);
		total_golazo200J1 = 0;
		process_add_ons();
		
	}
	
};
$($Ganagol);

function pagoEfectivoF(redireccion){
	$("#option-card-0").prop("checked", "checked");
	$("#panel_transaccion_1").hide();
    $("#panel_transaccion_2").hide();
    $("#panel_transaccion_3").hide();
	$("#panel_transaccion_4").hide();
	dhtmlwindow.open('resultbox', 'iframe',redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal')

}


function safetyPay(redireccion){
	dhtmlwindow.open('resultbox', 'iframe',redireccion, 'SAFETYPAY', 'width=963,height=670,scrolling=1,center=1,resize=0', 'recal')
	$('#resultbox').append("<a id='return-comerce' Style='position: absolute; margin-top: -86px; width: 120px; margin-left: 508px; cursor:alias;'></a>");
}