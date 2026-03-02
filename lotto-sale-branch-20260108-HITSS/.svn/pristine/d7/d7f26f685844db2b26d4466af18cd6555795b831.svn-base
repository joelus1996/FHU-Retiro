;

var v_content_object;
var v_nSorteos=0;
var $tinka = function () {
	var costoTotalBetNor=0;	
	var precioReg=$("#simpleBetPrice_repeated").val();
    var total = 0;
    var count = 0;
    var countJ1 = 0;
    var countJ2 = 0;
    var countJ3 = 0;
    var countJ4 = 0;
    var resultJ1 = 0;
    var resultJ2 = 0;
    var resultJ3 = 0;
    var resultJ4 = 0;
    var sub_total = 0;
    var contador_1 = 0;
    var contador_2 = 0;
    var contador_3 = 0;
    var contador_4 = 0;
    var cantin_1 = 0;
    var cantin_2 = 0;
    var cantin_3 = 0;
    var cantin_4 = 0;
    $('#back_previous').remove();
    $("#menu-item-1").addClass("main-nav-list-item current-menu-item");
    $("#plays-1").addClass("active");
    var price = $("#price-message").html().replace('Costo por jugada:','').replace('.',' ');
    $("#price-message").html(price);
    
    $('#game-code-header').val(41);
    var content_object = obtenerJugadaDesdeCookie("jugadaSessionTinka") ; 
    var content_object_2=[];
   
    var combo_fecha = $(".selectBox").html();
    var status = $("#status").val();
    $('.wrapper-buying').hide();
    $("#part2").hide();
    $(".flecha_back").hide();
    
    if(content_object.length > 0){
    	tinkaSession();
    }
    
    if (status == "ACT") {
        $('.flecha_next').click(function () {
            $("#part1").hide();
            $("#part2").show();
            $(".flecha_next").hide();
            $(".flecha_back").show();
            $(".play_go_3_4_gd").removeClass("play_go_3_4_gd").addClass("play_go_1_2_gd");
        });
        $('.flecha_back').click(function () {
            $("#part2").hide();
            $("#part1").show();
            $(".play_go_1_2_gd").addClass("play_go_3_4_gd");
            $('.flecha_back').addClass("flecha_next");
            $(".flecha_next").show();
            $(".flecha_back").hide();
        })
    }
    $('.transition-two').hide();
    if (status == 'CIE') {
        disabled_game();
    } 
    if (status == "ACT") {
        if (false) {
            var value_numberJ1 = [];
            var value_numberJ2 = [];
            var value_numberJ3 = [];
            var value_numberJ4 = [];
            $(".check_").click(function () {
                var id_value = $(this).attr("id").substr(1, 10);
                var first_letter_id = id_value.substr(0, 2);
                var number_id = id_value.substr(8, 2);
                if ($("#" + id_value).is(':checked')) {
                    count = util(first_letter_id, 2);
                    $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                    delete_array_number(number_id, first_letter_id);
                    $("#L" + id_value).removeClass("colorChecked");
                    combinatoria();
                } else {
                    if (count <= 15) {
                        count = util(first_letter_id, 1);
                        if (sub_total <= 5005) {
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', true);
                            array_number(number_id, first_letter_id);
                            $("#L" + id_value).addClass("colorChecked");
                            combinatoria();
                        }
                        if (count > 15 || sub_total > 5005) {
                            $("#L" + id_value).removeClass("colorChecked");
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                            count = util(first_letter_id, 2);
                            delete_array_number(number_id, first_letter_id);
                            combinatoria();
                        }
                    }
                }
            })
        } else {
            $("input[type=checkbox]").change(function () {
                var id_value = $(this).attr("id");
                var first_letter_id = id_value.substr(0, 2);
                var number_id = id_value.substr(8, 2);
                if ($("#" + id_value).is(':checked')) {
                    if (count <= 15) {
                        count = util(first_letter_id, 1);
                        if (sub_total <= 5005) {
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', true);
                            array_number(number_id, first_letter_id);
                            $("#L" + id_value).addClass("colorChecked");
                            combinatoria();
                        }
                        if (count > 15 || sub_total > 5005) {
                            $("#L" + id_value).removeClass("colorChecked");
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                            count = util(first_letter_id, 2);
                            delete_array_number(number_id, first_letter_id);
                            combinatoria();
                        }
                    }
                } else {
                    count = util(first_letter_id, 2);
                    $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                    delete_array_number(number_id, first_letter_id);
                    $("#L" + id_value).removeClass("colorChecked");
                }
                combinatoria();
                checkJugadasSeleccionadas();
            })
        }
    }
    var value_numberJ1 = [];
    var value_numberJ2 = [];
    var value_numberJ3 = [];
    var value_numberJ4 = [];
    
    function disabled_game() {
        $('.left').addClass('opacity');
        $('.right').addClass('opacity');
        $('.right_flecha').addClass('opacity');        
        $('.selectBox').addClass('opacity');
        $('.font').addClass('opacity');
    }
    function show(first_letter_id, value_number) {
        value_number.sort(function (a, b) {
            return b - a;
        });
        value_number.reverse();
        if($("#clientBalance").val() == undefined || $("#clientBalance").val() == null || $("#clientBalance").val() == ''   ){
        	$("#" + first_letter_id + "-text").text(value_number.join(', '));
        }else{
        	$("#" + first_letter_id + "-text-area").val(value_number.join(', '));
        }
    }

    function array_number(number_id, first_letter_id) {
        if (first_letter_id == "J1") {
            value_numberJ1.push(number_id);
            show(first_letter_id, value_numberJ1);
        }
        if (first_letter_id == "J2") {
            value_numberJ2.push(number_id);
            show(first_letter_id, value_numberJ2);
        }
        if (first_letter_id == "J3") {
            value_numberJ3.push(number_id);
            show(first_letter_id, value_numberJ3);
        }
        if (first_letter_id == "J4") {
            value_numberJ4.push(number_id);
            show(first_letter_id, value_numberJ4);
        }
    }

    function delete_array_number(number_id, first_letter_id) {
        if (first_letter_id == "J1") {
            var size = value_numberJ1.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ1[ini] == number_id) {
                    value_numberJ1.splice(ini, 1);
                    show(first_letter_id, value_numberJ1);
                }
            }
        }
        if (first_letter_id == "J2") {
            var size = value_numberJ2.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ2[ini] == number_id) {
                    value_numberJ2.splice(ini, 1);
                    show(first_letter_id, value_numberJ2);
                }
            }
        }
        if (first_letter_id == "J3") {
            var size = value_numberJ3.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ3[ini] == number_id) {
                    value_numberJ3.splice(ini, 1);
                    show(first_letter_id, value_numberJ3);
                }
            }
        }
        if (first_letter_id == "J4") {
            var size = value_numberJ4.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ4[ini] == number_id) {
                    value_numberJ4.splice(ini, 1);
                    show(first_letter_id, value_numberJ4);
                }
            }
        }
    }

    $(".clear").click(function () {
        if (status == "ACT") {
            var title = $(this).attr("id").substr(0,2);
            for (ini = 0; ini <= 50; ini++) {
                $("#" + title + "check_" + ini).prop('checked', false);
                $("#L" + title + "check_" + ini).removeClass("colorChecked");
                if (title == "J1") {
                    $('div[data-game="a"]').removeClass('game-played');
                    value_numberJ1.splice(0, 1);
                    show(title, value_numberJ1);
                }
                if (title == "J2") {
                    $('div[data-game="b"]').removeClass('game-played');
                    value_numberJ2.splice(0, 1);
                    show(title, value_numberJ2);
                }
                if (title == "J3") {
                    $('div[data-game="c"]').removeClass('game-played');
                    value_numberJ3.splice(0, 1);
                    show(title, value_numberJ3);
                }
                if (title == "J4") {
                    $('div[data-game="d"]').removeClass('game-played');
                    value_numberJ4.splice(0, 1);
                    show(title, value_numberJ4);
                }
            }
            count = util(title, 3);
            $('#comb').html(peformatint(0));
            combinatoria();
            checkJugadasSeleccionadas();
            if(dataLayerlimpiar){
            	datalayerJugada(this,'Elige tu Jugada');
            }
        }
    });
    function clear_for_ini(title) {
        for (ini = 0; ini <= 50; ini++) {
            $("#" + title + "check_" + ini).prop('checked', false);
            $("#L" + title + "check_" + ini).removeClass("colorChecked");
            if (title == "J1") {
                value_numberJ1.splice(0, 1);
                show(title, value_numberJ1);
            }
            if (title == "J2") {
                value_numberJ2.splice(0, 1);
                show(title, value_numberJ2);
            }
            if (title == "J3") {
                value_numberJ3.splice(0, 1);
                show(title, value_numberJ3);
            }
            if (title == "J4") {
                value_numberJ4.splice(0, 1);
                show(title, value_numberJ4);
            }
        }
        count = util(title, 3);
    }

    function buscar_repetido(value, title) {
        if (title == "J1") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ1[ini] == value) {
                    return false;
                }
            }
        }
        if (title == "J2") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ2[ini] == value) {
                    return false;
                }
            }
        }
        if (title == "J3") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ3[ini] == value) {
                    return false;
                }
            }
        }
        if (title == "J4") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ4[ini] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    function util(play, how_marca) {
        switch (play) {
            case"J1":
                if (how_marca == 1) {
                    countJ1++;
                }
                if (how_marca == 2) {
                    countJ1--;
                }
                if (how_marca == 3) {
                    countJ1 = 0;
                }
                if (how_marca == 4) {
                    countJ1 = 6;
                }
                return countJ1;
                break;
            case"J2":
                if (how_marca == 1) {
                    countJ2++;
                }
                if (how_marca == 2) {
                    countJ2--;
                }
                if (how_marca == 3) {
                    countJ2 = 0;
                }
                if (how_marca == 4) {
                    countJ2 = 6;
                }
                return countJ2;
                break;
            case"J3":
                if (how_marca == 1) {
                    countJ3++;
                }
                if (how_marca == 2) {
                    countJ3--;
                }
                if (how_marca == 3) {
                    countJ3 = 0;
                }
                if (how_marca == 4) {
                    countJ3 = 6;
                }
                return countJ3;
                break;
            case"J4":
                if (how_marca == 1) {
                    countJ4++;
                }
                if (how_marca == 2) {
                    countJ4--;
                }
                if (how_marca == 3) {
                    countJ4 = 0;
                }
                if (how_marca == 4) {
                    countJ4 = 6;
                }
                return countJ4;
                break;
        }
    }

    $(".azar").click(function () {
        if (status == "ACT") {
            if (sub_total < 5005) {
                var ini;
                var title = $(this).attr("id").substr(0,2);
                if (title == "J1") {
                    count = countJ1;
                }
                if (title == "J2") {
                    count = countJ2;
                }
                if (title == "J3") {
                    count = countJ3;
                }
                if (title == "J4") {
                    count = countJ4;
                }
                if (count >= 6) {
                    count = 0;
                    clear_for_ini(title);
                }
                while (count < 6) {
                    var number_azar = Math.round(1 + (Math.random() * (50 - 1)));
                    if (buscar_repetido(number_azar, title)) {
                        $("#" + title + "check_" + number_azar).prop('checked', true);
                        $("#L" + title + "check_" + number_azar).addClass("colorChecked");
                        array_number(number_azar, title);
                        count = util(title, 1);
                    }
                }
                combinatoria();
                checkJugadasSeleccionadas();
                try {
                	datalayerJugada(this,'Elige tu Jugada');
                	tagginAlAzar("Tinka");				
    			} catch (e) {
    				console.error(e);
    			}
                
            }
        }
    });
    var algorithm = $("#algorithm").val();
    var costoTotalBet = 0;
    var costoTotalBetMensaje = 0;

    function process_buy() {
        if (status == "ACT") {
            if (total <= 5005 && total >= 1) {
                $('.transition-one').hide();
                $('.transition-two').show();
                $('.step-play').removeClass('step-active');
                $('.step-status-2').addClass('step-active');
                $('.wrapper-playing').hide();
                $('.wrapper-buying').show();
                var cant_sorteo = $("#mySelectBox").val();
                var precio = costoTotalBet;
                
                var precioNormal=costoTotalBetNor;
                add_ticket(value_numberJ1, value_numberJ2, value_numberJ3, value_numberJ4, content_object, cant_sorteo, precio,precioNormal);
                
                for (var v in content_object) {
                    for (var w = 0; w <= 3; w++) {
                        var game = "";
                        if (content_object[v][w] != "") {
                            var games = (content_object[v][w] + "").split(",");
                            for (var t in games) {
                                if (games[t].length < 2) {
                                    games[t] = "0" + games[t];
                                }
                                game += games[t] + " ";
                            }
                            content_object[v][w] = trim(game);
                        } else {
                            content_object[v][w] = "00";
                        }
                    }
                }
                for (var i in content_object) {
                    content_object[i][4] = "null";
                }

                content_object_2=content_object.sort(function(prev,next){
                    return next[6]-prev[6];
                    }); 
                
                var pendientes_gratis=0;
                if($('.result5').text()!=""){  
                	  pendientes_gratis = $('.result5').text()* parseFloat(precioReg);
                }
                else{
                	var  pendientes_gratis = $('#balanceAmountGame').val();
                }
                costo_total = 0
                var gratis_total = 0 
                for (var v in content_object_2) {
                	var precio_cu = content_object_2[v][6];
                	if(content_object_2[v][6]!=content_object_2[v][8]){
                		content_object[v][10]=(parseFloat(precio_cu));
                		costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
                	}
                	else{
                    if(precio_cu <= pendientes_gratis){
                    	content_object[v][10]=(0);
                    	gratis_total =parseFloat(gratis_total)+ parseFloat(precio_cu);
                    	pendientes_gratis = parseFloat(pendientes_gratis)-parseFloat(precio_cu);
                    } else {
                    	content_object[v][10]=(parseFloat(precio_cu));
                    	costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
                      }
                	}
                }

                grilla_boletos(content_object_2);
                grilla_paginada(content_object_2);
                value_numberJ1 = [];
                value_numberJ2 = [];
                value_numberJ3 = [];
                value_numberJ4 = [];
                try {
                	tagginTinkaEEaddToCart(costoTotalBet);				
    			} catch (e) {
    				console.error(e);
    			}
                
    			dataLayerlimpiar = false;
                $(".clear").click();
                dataLayerlimpiar = true;
                
                $(".result1").html("S/ " + floatFormat(costo_total));
                $("#totalPagar").text(costo_total);
                $(".label_resu2").html($("#price-message").text());
                $("#mySelectBox").val("1");
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
	                }*/   
                } else {
            	   $('.result5').html("");
            	   $('.label_resu5').html("");
            	   $('.labelMsgJugadaGratis').html("");
               }
                               
                v_content_object=content_object; 
                rellenarSession();
                
                try {
                	let pos = content_object.length - 1;
                	tagginFinalizar();
                	tagginTinkaEEcheckout();	
                	let jugadas = content_object[pos][9];
                    let totalPagar = content_object[pos][6];
                    let consecutivas = content_object[pos][5];
                    let precioUnitario = totalPagar/(jugadas*consecutivas);
                	datalayerAddToCart(content_object[pos],precioUnitario);
                	datalayerFinalizaCompra1($('#btn_desktop_comprar_boleto_tinka'),'Comprar');
    			} catch (e) {
    				console.error(e);
    			}
                	
                
                
            }
            if (total > 5005) {
            	datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar','El total de apuestas no debe ser mayor a 5005');	
                jAlert("El total de apuestas no debe ser mayor a 5005");
            }
        }
    }

    function buy() {    
        if((0<value_numberJ1.length && value_numberJ1.length<6) || (0<value_numberJ2.length && value_numberJ2.length<6) || (0<value_numberJ3.length && value_numberJ3.length<6) || (0<value_numberJ4.length && value_numberJ4.length<6)){
        	var message='Elige correctamente tu apuesta.';
        	try {
        		tagginPopupError("Tinka",message);
        		datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
			} catch (e) {
				console.error(e);
			}
            jAlert(message, null);                     
       } else if (total<1 && costoTotalBet<=0) {
    	   	var message='No ha realizado ninguna jugada.';
    	   	try {
    	   		tagginPopupError("Tinka",message);
    	   		datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
			} catch (e) {
				console.error(e);
			}
       		
       		jAlert(message, null);
       } else {
//    	   setCaptchaJuego();
    	   $("#index-btnlogin").prop("disabled",true);
           process_buy();
       }   
    }
    
    $('#btn_desktop_comprar_boleto_tinka').click(function () {
      if(status=='ACT'){
//        if ((costoTotalBetMensaje <= costoTotalBet) && algorithm != "") {
//            jConfirm("No desaproveches hay promocion.", null, function (r) {
//                if (r) {
//                    buy();
//                }
//            })
//        } else {
//            buy();
//        }
    	  // Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
      	  // es una function que se realizará en caso no tenga docs pendientes de confirmacion.
    	  mainValidatePendingsDocsForAproval('lottoTinkaCompraTinka');
     }   
    });
   
    $('.more').click(function () {
        if (status == "ACT") {
            if (sub_total < 5005) {
                var more = [];
                var title = $(this).attr("id").substr(0,2);
                var more2;
                more2 = $("#more_repeated").val();
                more = more2.split(" ");
                var size = more.length;
                clear_for_ini(title);
                count = util(title, 4);
                for (i = 0; i < size; i++) {
                    $("#" + title + "check_" + more[i]).prop('checked', true);
                    $("#L" + title + "check_" + more[i]).addClass("colorChecked");
                    array_number(more[i], title);
                }
                combinatoria();
            }
        }
    });
    $('.less').click(function () {
        if (status == "ACT") {
            if (sub_total < 5005) {
                var more = [];
                var title = $(this).attr("id").substr(0,2);
                var more2;
                more2 = $("#less_repeated").val();
                more = more2.split(" ");
                var size = more.length;
                clear_for_ini(title);
                count = util(title, 4);
                for (i = 0; i < size; i++) {
                    $("#" + title + "check_" + more[i]).prop('checked', true);
                    $("#L" + title + "check_" + more[i]).addClass("colorChecked");
                    array_number(more[i], title);
                }
                combinatoria();
            }
        }
    });
    var bets = $("#bets").val();
    var pay = $("#pay").val();
    var cost = $("#cost").val();
    var draw = $("#draw").val();
    var sorteos = $("#mySelectBox").val();
    
    $(document).on('change', '#mySelectBox',changeSelectedBox);
    
    function changeSelectedBox(){
    	sorteos = $(this).val();
		combinatoria();
    	
    }
    
    var price_type;
    price_type = $("#price_type").val();
    var promo;
    promo = $("#promo").val();
    var v_data_value_bet = 0;
    v_data_value_bet = $("#simpleBetPrice_repeated").val();
    function combinatoria() {
        var sub_cantin_1 = 0;
        var sub_cantin_2 = 0;
        var sub_cantin_3 = 0;
        var sub_cantin_4 = 0;
        for (iniL = 1; iniL <= 4; iniL++) {
            var contador = 0;
            for (ini = 1; ini <= 50; ini++) {
                if ($("#J" + iniL + "check_" + ini).is(':checked')) {
                    contador++;
                }
            }
            if (iniL == 1) {
                contador_1 = contador;
                if (contador >= 6) {
                    cantin_1 = bin_newton(contador);
                } else {
                    cantin_1 = 0;
                }
                if (contador_1 <= 5 && contador_1 > 0) {
                    sub_cantin_1 = 1;
                } else {
                    sub_cantin_1 = cantin_1;
                }
            }
            if (iniL == 2) {
                contador_2 = contador;
                if (contador >= 6) {
                    cantin_2 = bin_newton(contador);
                } else {
                    cantin_2 = 0;
                }
                if (contador_2 <= 5 && contador_2 > 0) {
                    sub_cantin_2 = 1;
                } else {
                    sub_cantin_2 = cantin_2;
                }
            }
            if (iniL == 3) {
                contador_3 = contador;
                if (contador >= 6) {
                    cantin_3 = bin_newton(contador);
                } else {
                    cantin_3 = 0;
                }
                if (contador_3 <= 5 && contador_3 > 0) {
                    sub_cantin_3 = 1;
                } else {
                    sub_cantin_3 = cantin_3;
                }
            }
            if (iniL == 4) {
                contador_4 = contador;
                if (contador >= 6) {
                    cantin_4 = bin_newton(contador);
                } else {
                    cantin_4 = 0;
                }
                if (contador_4 <= 5 && contador_4 > 0) {
                    sub_cantin_4 = 1;
                } else {
                    sub_cantin_4 = cantin_4;
                }
            }
        }
        sub_total = sub_cantin_1 + sub_cantin_2 + sub_cantin_3 + sub_cantin_4;
        if (sub_total <= 5005) {
            total = cantin_1 + cantin_2 + cantin_3 + cantin_4;
        }
        if (total >= 1) {
            if (algorithm == "BETS") {
                costoTotalBetMensaje = callTransformByBets(parseInt(total) + 1, sorteos, v_data_value_bet, bets, pay);
                costoTotalBet = callTransformByBets(total, sorteos, v_data_value_bet, bets, pay);
            } else {
                if (algorithm == "COST") {
                    costoTotalBetMensaje = callTransformByCost(parseInt(total) + 1, sorteos, v_data_value_bet, bets, cost);
                    costoTotalBet = callTransformByCost(total, sorteos, v_data_value_bet, bets, cost);
                } else {
                    if (algorithm == "DRAW") {
                        costoTotalBetMensaje = callTransformByDraws(total, parseInt(sorteos) + 1, v_data_value_bet, draw, pay);
                        costoTotalBet = callTransformByDraws(total, sorteos, v_data_value_bet, draw, pay);
                    } else {
                        if (algorithm.substring(0, 3) == "ESC") {
                            var elem = algorithm.split(";");
                            var total_bet_consecutive = 0;
                            total_bet_consecutive = (total * sorteos);
                            if ( total_bet_consecutive < (elem.length - 1) ) {
                                costoTotalBet = elem[total_bet_consecutive];
                            } else {
                                costoTotalBet = elem[elem.length - 1]*total_bet_consecutive;
                            }
                            if (total_bet_consecutive > 1) {
                                costoTotalBetMensaje = costoTotalBet + 1;
                            }
                        } else {
                            costoTotalBet = v_data_value_bet * total * sorteos;
                        }    
                    }
                }
            }
            
            costoTotalBetNor=v_data_value_bet * total * sorteos;
            
            $('#comb').html(peformatint(total));
            $('#total_apagar').html(floatFormat(costoTotalBet));
        } else {
            total = 0;
            costoTotalBet=0;
            $('#comb').html(0);
            $('#total_apagar').html(0);
        }
    }

    function bin_newton(cantidad) {
        var deduct_1 = 1;
        var deduct_2 = 1;
        var count_2 = cantidad - 6;
        variable = factorial(cantidad) / (720 * (factorial(count_2)));
        return variable;
    }

    function factorial(cantidad) {
        if (cantidad < 0)return 0; else if (cantidad > 1)return cantidad * factorial(cantidad - 1);
        return 1;
    }

    function callTransformByDraws(p_sum_total_bet, p_number_consecutive, p_data_value_bet, p_draws, p_pay) {
        var var_total_cost = 0;
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = var_sum_total_bet_consecutive * p_data_value_bet;
        if (p_number_consecutive >= parseInt(p_draws))var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(p_number_consecutive / p_draws) * (p_draws - p_pay) * p_data_value_bet));
        return var_total_cost;
    }

    function callTransformByBets(p_sum_total_bet, p_number_consecutive, p_data_value_bet, p_bets, p_pay) {
        var var_total_cost = 0;
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(var_sum_total_bet_consecutive / p_bets) * (p_bets - p_pay) * p_data_value_bet));
        return var_total_cost;
    }
    
    function callTransformByCost(p_sum_total_bet, p_number_consecutive, p_data_value_bet, p_bets, p_cost) {
        var var_total_cost = 0;
        var var_sum_total_1_consecutive = 0;
        var_sum_total_1_consecutive = ( p_sum_total_bet * p_data_value_bet *p_number_consecutive ) - 
                                      ( Math.floor(p_number_consecutive*p_sum_total_bet / p_bets) * (p_bets * p_data_value_bet - p_cost) );
        var_total_cost = var_sum_total_1_consecutive ;
        return var_total_cost;  
    }
    
    
    
    function peformatint(numero) {
	  return (numero!=null && numero!="")?parseInt(numero).toFixed(0).replace(/\B(?=(\d{3})+\b)/g, ","):"0";
	}

    $('.left-panel').on('click','.lnk-pag1',function(){
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
    $('.left-panel').on('click','.lnk-pag2',function(){
        var cadena_pos = $(this).attr("rel");
        var id = $(this).attr("id");
        var posiciones = cadena_pos.split("-");
        $(".row_grid").removeClass("row_null");
        $(".row_grid").addClass("row_null");
        for (var num in posiciones) {
            $(".row_grid").eq(posiciones[num]).removeClass("row_null");
        }
        grilla_paginada2(new_content_object);
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#" + $(this).attr("id")).removeClass("num_page_on");
        $("#" + $(this).attr("id")).addClass("num_page_off");
    });
    $('.left-panel').on('click','.lnk-pag3',function(){
        var cadena_pos = $(this).attr("rel");
        var id = $(this).attr("id");
        var posiciones = cadena_pos.split("-");
        $(".row_grid").removeClass("row_null");
        $(".row_grid").addClass("row_null");
        for (var num in posiciones) {
            $(".row_grid").eq(posiciones[num]).removeClass("row_null");
        }
        grilla_paginada3(array_no_procesados);
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#" + $(this).attr("id")).removeClass("num_page_on");
        $("#" + $(this).attr("id")).addClass("num_page_off");
    });
    $('#keep-playing').on('click', function(event){
        event.preventDefault();            
     });  
    $('#game-history').on('click',function(event){
        event.preventDefault();
    });
    $("#more_plays").click(function () {
        $('.transition-two').hide();
        $('.transition-one').show();
        $('.step-play').removeClass('step-active');
        $('.step-status-1').addClass('step-active');
        $('.wrapper-playing').show();
        $('.wrapper-buying').hide();
        $('.box-current-game').removeClass('game-played');
        
        //$('div[data-game="a"]').click();  remover click por evento datalayer
        $('.box-current-game').removeClass('game-playing');
        $('div[data-game="a"]').addClass('game-playing');
        $('.box-play-main').hide();
        $('.box-play-a').show();
        
        $("#part2").hide();
        $("#part1").show();
        $(".play_go_1_2_gd").addClass("play_go_3_4_gd");
        $('.flecha_back').addClass("flecha_next");
        $(".flecha_next").show();
        $(".flecha_back").hide();
        $(".selectBox").html(combo_fecha);
        $("#total_apagar").html("0");
        sorteos = 1;
        costoTotalBet = 0;
        costoTotalBetMensaje = 0;
        datalayerFinalizaCompra2(this,'Agregar Jugadas');
    });
    $('.left-panel').on('click','.process-delete1',function(){
        var pos = parseInt($(this).attr("rel"));
        //Capturar precio del sorteo eliminado
        try {
        	tagginTinkaEEremoveFromCart(content_object_2[pos][6]);	
        	let jugadas = content_object_2[pos][9];
        	let totalPagar = content_object_2[pos][6];
        	let consecutivas = content_object_2[pos][5];
        	let precioUnitario = totalPagar/(jugadas*consecutivas);
        	datalayerRemoveFromCart(content_object_2[0],precioUnitario);
		} catch (e) {
			console.error(e);
		}
        
        content_object_2.splice(pos, 1);
        grilla_boletos(content_object_2);
        grilla_paginada(content_object_2);
        var pendientes_gratis2 = $('#balanceAmountGame').val();
        var costo_total2 = 0
        var gratis_total2 = 0 
        for (var v in content_object_2) {
        	var precio_cu2 = content_object_2[v][6];
        	if(content_object_2[v][6]!=content_object_2[v][8]){        		
        		costo_total2 =parseFloat(costo_total2)+ parseFloat(precio_cu2);
        	}
        	else{
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
            eliminarSessionTinka();
            
        }else{
        	 guardarJugadaEnCookie("jugadaSessionTinka",content_object, 365);
        }  
    });
    $('.left-panel').on('click','.process-delete2',function(){
        var pos = parseInt($(this).attr("rel"));
        array_no_procesados.splice(pos, 1);
        var costo_total = 0;
        for (var i in array_no_procesados) {
            costo_total += parseFloat(array_no_procesados[i][6]);
        }
        $(".result1").html("S/ " + floatFormat(costo_total));
        grilla_boletos3(array_no_procesados);
        grilla_paginada3(array_no_procesados);
    });
    var new_content_object = [];
    
    var thisBtnFinalizarCompraTinka = null;
    $("#btn_desktop_finalizar_compra_tinka").click(function () {
    	thisBtnFinalizarCompraTinka = this;
    	// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
    	// es una function que se realizará en caso no tenga docs pendientes de confirmacion.
    	mainValidatePendingsDocsForAproval('lottoTinkaFinalizarCompraTinka');
    });
    $('.left-panel').on('mouseover','.row-info',function(){
        var posicion = $(this).attr("rel");
        var content_info = "";
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        for (var i = 0; i <= 3; i++) {
            content_object[posicion][i] = trim(content_object[posicion][i]);
            if (content_object[posicion][i] != "00") {
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
        $(".tooltip-info").eq(posicion).show();
        $(".tooltip-info").eq(posicion).html(content_info);
        $(".tooltip-info-arrow-img").eq(posicion).show();
    });
    $('.left-panel').on('mouseout','.row-info',function(){
        var posicion = $(this).attr("rel");
        $(".tooltip-info").eq(posicion).hide();
        $(".tooltip-info-arrow-img").eq(posicion).hide();
    });
    $('.left-panel').on('mouseover','.row-info2',function(){
        var posicion = $(this).attr("rel");
        var content_info = "";
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        for (var i = 0; i <= 3; i++) {
            if (array_no_procesados[posicion][i] != "00") {
                if (array_no_procesados[posicion][i] != "null") {
                    var test = (array_no_procesados[posicion][i] + "").split("-");
                    if (test[1] != "null") {
                        var numeros = (array_no_procesados[posicion][i] + "").split(",");
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
        $(".tooltip-info").eq(posicion).show();
        $(".tooltip-info").eq(posicion).html(content_info);
        $(".tooltip-info-arrow-img").eq(posicion).show();
    });
    $('.left-panel').on('mouseout','.row-info2',function(){
        var posicion = $(this).attr("rel");
        $(".tooltip-info").eq(posicion).hide();
        $(".tooltip-info-arrow-img").eq(posicion).hide();
    });

    $('.left-panel').on('mouseover','.no-process',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = (contenido_total + "").split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = (contenido_temp[1] + "").replace(/\*/g,"<br/>");
        $(".tooltip-no-process").eq(posicion).show();
        $(".tooltip-no-process").eq(posicion).html(mensaje);
        
        $(".tooltip-no-process-arrow-img").eq(posicion).show();
    });

    $('.left-panel').on('mouseout','.no-process',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = contenido_total.split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1];
        $(".tooltip-no-process").eq(posicion).hide();
        $(".tooltip-no-process").eq(posicion).html(mensaje);
       
        $(".tooltip-no-process-arrow-img").eq(posicion).hide();
    });
    $('.left-panel').on('mouseover','.no-process2',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = (contenido_total + "").split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1] + "";
        $(".tooltip-no-process2").eq(posicion).show();
        $(".tooltip-no-process2").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img2").eq(posicion).show();
    });
    $('.left-panel').on('mouseover','.no-process2',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = contenido_total.split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1];
        $(".tooltip-no-process2").eq(posicion).hide();
        $(".tooltip-no-process-arrow-img2").eq(posicion).hide();
    });
    var array_no_procesados = [];
    $('.left-panel').on('click','#btn-no-process',function(){
        var contador = 0;
        for (var i in new_content_object) {
            var procesos = (new_content_object[i][4] + "").split("&");
            if (procesos[1] == "null") {
//                array_no_procesados.push(new_content_object[i]);
                array_no_procesados.push(content_object[i]);
                contador++;
            }
        }
        $("#panel_keep-playing").hide();
        $("#panel_game-history").hide();
        $("#ico-block").hide();
        $("#panel_finaliza_compra").show();
        $("#panel_more_plays").show();
        $("#sub_panel").show();
        $(".left-panel").html("");
        $('#keep-playing').on('click', function(event){
            event.preventDefault();            
         });
        $('#game-history').on('click',function(event){
            event.preventDefault();
        }); 
        var temp_jugada_2 = "<span class='label_1'>TINKA</span>" + "<div id='content-grid-result'></div>" + "<div id='num_link'></div>";
        $(".left-panel").html(temp_jugada_2);
        if (status == "ACT") {
            $('.transition-one').hide();
            $('.transition-two').show();
            $('.step-play').removeClass('step-active');
            $('.step-status-2').addClass('step-active');
            $('.wrapper-playing').hide();
            $('.wrapper-buying').show();
            var cant_sorteo = $("#mySelectBox").val();
            var precio = costoTotalBet;
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
                costo_total += parseFloat(content_object[i][6]);
            }
            $(".result1").html("S/ " + floatFormat(costo_total));
        }
    });
    
    function finalizarCompraTinka(){
    	var option = $("[name=option-card]:checked").val();
        var pin = $("[name=pin-number]").val();
        var message = "";
        var amount = 0.0;
        var newamount = 0.0;
        var msgres = [];
        if (option == 0) {
            message = "OK";
        } 
        message = message.replace(/_/g, ' ');
        $("#clientSale-amount").text(floatFormat(newamount));
        $("#field-balanceAmount").text(floatFormat(newamount));
        if (message == "OK") {
        	datalayerFinalizaCompra2(thisBtnFinalizarCompraTinka,'Finalizar Compra');
        	
        	let jugadas = content_object[0][9];
        	let totalPagar = content_object[0][6];
        	let consecutivas = content_object[0][5];
        	let precioUnitario = totalPagar/(jugadas*consecutivas);
        	datalayerCheckout(content_object[0],precioUnitario);
        	
            for (var i in content_object) {
                content_object[i][4] = "null";
            }
            if (content_object.length != 0) {
                var content_grid_2 = "<div class='label-top'></div>" + "<div class='label_1'>TINKA</div>" + "<div id='ajax-loader'>" + "<img src='layer-view-image/game/ganadiario/ajax-loader.gif'>" + "</div><div id='content-grid-result'></div>" + "<div id='num_link'></div>";
                content_grid_2 += "<div id='game-no-process-info'></div>";
                $(".left-panel").html(content_grid_2);
                $("#panel_more_plays").hide();
                $("#panel_keep-playing").show();
                $("#panel_game-history").show();
                $("#ico-block").show();
                $(".label-top").show();
                $("#sub_panel").hide();
                $("#panel_finaliza_compra").hide();
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
                            if (numeros[num].length < 2) {
                                if (numeros[num] != "0") {
                                    numeros[num] = "0" + numeros[num];
                                }
                            }
                            result_ticket += trim(numeros[num]) + " ";
                        }
                    }
                }
                $("#ajax-loader").show();
                var contador = 0;
                $.ajax({type: "POST", url: "ajaxJugadasTinka.html", data: "dato=" + result_ticket, dataType: "text", success: function (e) {
                    var fila = (e.toString()).split("#");
                    for (var n = 0; n < fila.length; n++) {
                        var items = (fila[n] + "").split("|");
                        var row_object = [];
                        for (var m = 0; m < items.length; m++) {
                            row_object.push(trim(items[m]));
                        }
                        new_content_object.push(row_object);
                    }
                    $(".label_resu3").html("<b>Saldo Disponible: </b><div class='text-detail-pay detail-pay-monto'>S/ " + floatFormat(new_content_object[(new_content_object.length - 1)][10]) + "</div>");
                    var promotional_balance=parseFloat(new_content_object[(new_content_object.length-1)][11]);
                    if(promotional_balance>0){
                     $(".label_resu4").html("<b>Saldo Promocional: </b><div class='text-detail-pay detail-pay-monto'>S/ " + floatFormat(new_content_object[(new_content_object.length-1)][11]) + "</div>");
                    }
                    $("#clientSale-amount").text(floatFormat(new_content_object[(new_content_object.length - 1)][10]));
                    $("#clientSale-amount-2").text(floatFormat(new_content_object[(new_content_object.length - 1)][10]));
                    $("#ajax-loader").hide();
                    grilla_boletos2(new_content_object);
                    grilla_paginada2(new_content_object);
                    var costo_juego = parseFloat(new_content_object[(new_content_object.length-1)][12]);
                    var costo_otro = parseFloat(new_content_object[(new_content_object.length-1)][13]);
                    var costo_total = 0;
                    for (var t in new_content_object) {
                        var procesos = (new_content_object[t][4] + "").split("&");
                        if (procesos[1] != "null") {
                            $(".label-top").html("&#161;GRACIAS POR TU COMPRA!");
                            costo_total += parseFloat(new_content_object[t][6]);
                            
                        }
                    }
                    
                    var pendientes_gratis3 = $('#balanceAmountGame').val();
                    var costo_total3 = 0
                    var gratis_total3 = 0 
                    for (var v in new_content_object) {
                    	var precio_cu3 = parseFloat(new_content_object[v][6]);
                    		if(parseFloat(content_object_2[v][6])!=parseFloat(content_object_2[v][8])){
                    			var cadena=new_content_object[v][4];
                    			var cadenaPa=cadena.substring(0, 2);
                    			if(cadenaPa=="OK"){
                    				costo_total3 =parseFloat(costo_total3)+ precio_cu3;
                    			}
                    	   }
                        else{
                        if(precio_cu3 <= pendientes_gratis3){
                        	gratis_total3 =parseFloat(gratis_total3+ precio_cu3);
                        	pendientes_gratis3 = parseFloat(pendientes_gratis3-precio_cu3);
                        } else {
                        	var cadena2=new_content_object[v][4];
                			var cadenaPa2=cadena2.substring(0, 2);
                			if(cadenaPa2=="OK"){
                        	costo_total3 =parseFloat(costo_total3)+ parseFloat(precio_cu3);
                			}
                          }
                    	}
                    }

                    $(".result1").html("S/ " + floatFormat(costo_total3));
                          
                    $(".label_resu1").html("TOTAL PAGADO:");
                 	$('.result5').html((!isNaN(costo_juego))?costo_juego:"0");
                 	$('.label_resu5').html("Jugadas gratis:");
                 	$('.labelMsgJugadaGratis').html("");
                    if(!isNaN(costo_otro)) $("#billetera3-amount").text(costo_otro);
                    $('#keep-playing').off('click');
                    $('#game-history').off('click');
                    
                    eliminarSessionTinka();
                    if(!$('.label-top').find('div').length){ 
                    	try {
                    		finalizaCompra2 = false;
                    		tagginTinkaCompraExitosa();
                        	tagginTinkaEEpurchase(content_object, new_content_object);			
                        	var cupon =  "undefined"; 
                        	var precioReal = parseFloat($("#balanceAmountGame").val());
                        		
                        	if($("#price_type").val() !== 'NOR')
								cupon = $("#priceMessage").val();
                        		
    						for(let pos=0;pos<content_object_2.length;pos++){
    							let jugadas = content_object_2[pos][9];
        						let totalPagar = content_object_2[pos][6];
        						let consecutivas = content_object_2[pos][5];
    						let precioUnitario = totalPagar/(jugadas*consecutivas);
    						
                            	datalayerPurchase(content_object_2[pos],
                        						precioUnitario,
                        					  '¡Gracias por tu Compra!',
                            					  content_object_2[pos][10],
                        					  'Tinka-'+procesos[1],
                        					  cupon);
    						}
            			} catch (e) {
            				console.error(e);
            			}
                    	
                    }
                    
                }})
            } else {
                jAlert("No se tiene jugadas por procesar");
                datalayerErrores('Finalizar tu Compra 2','Paso 3','Finalizar Compra','No se tiene jugadas por procesar');
            }
            if (option == 1)jAlert("Se ha realizado una recarga de saldo.\n\nMonto cargado: S/ " + amount + "\nTu saldo es: S/ " + newamount, null);
        } else {
            if (option == 1){
            	jAlert("No se ha logrado realizar la recarga.\n" + message + "\n\nMonto cargado: S/ " + amount + "\nTu saldo es: S/ " + newamount, null);
            	datalayerErrores('Finalizar tu Compra 2','Paso 3','Finalizar Compra','No se ha logrado realizar la recarga.');
            }
        }
    }
    
    window.addEventListener("message", function(event) {
        if (event.data === "lottoTinkaCompraTinka") {
            buy(); 
        } else if (event.data === "lottoTinkaFinalizarCompraTinka") {
        	finalizarCompraTinka(); 
        }
    });
    
    function add_ticket(juego1, juego2, juego3, juego4, content_object, cantidad_sorteo, precio,costoTotalBetNor) {
        var estado = "null";
        var object_boleto = [];
        object_boleto.push(juego1);
        object_boleto.push(juego2);
        object_boleto.push(juego3);
        object_boleto.push(juego4);
        object_boleto.push(estado);
        object_boleto.push(cantidad_sorteo);
        object_boleto.push(precio);
        object_boleto.push("0");
        object_boleto.push(costoTotalBetNor);
        object_boleto.push($("#comb").text());
        content_object.push(object_boleto);
    }

    function grilla_boletos(data) {
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var grilla = "<div>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>JUGADAS</div>" + "<div class='head_title_3'>ANULAR</div>" + "</div>";
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
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + (parseInt(x) + 1) + "</div>" + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + "<div class='column_3'>" + "<div class='delete process-delete1' rel='" + x + "'>x</div>" + "</div>" + "</div>";
        }
        grilla += "</div></div>";
        $('#content-grid-result').html(grilla);
    }

    function grilla_boletos2(data) {
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var no_process_message_count = 0;
        var grilla = "<div>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>VER</div>" + "</div>";
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
            var dato_proceso = (data[x][4] + "").split("&");
            var process_resp = "";
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
                

                var game_no_process_info = "<div class='title-text text-autocontrol'>" + "<div>Tienes jugadas que no se han podido procesar.</div> " + game_no_process_autocontrol  + "</div>" + "<div id='no-process-section'><a href='#' class='button button-block button-dark-green' id='btn-no-process' onclick='return false;'><b>VOLVER</b></a></div>";
                $("#game-no-process-info").html(game_no_process_info);
                $(".label-top").html("<div class='no-process-play'>JUGADAS NO PROCESADAS</div>");
                $("#game-no-process-info").show();
                label=dato_proceso[0];
            } else {
                process_resp = "<div class='column3-codigo'>" + dato_proceso[1] + "</div><div class='column3-search' onclick='openPreviewWindow(" + data[x][9] + ",\"" + data[x][8] + "\",\"" + dato_proceso[1] + "\")'></div>";
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + data[x][7] + "</div>" + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + process_resp + "</div>";
        }
        grilla += "</div></div>";
        $('#content-grid-result').html(grilla);
        
      //taggin jugadas no procesadas
        if($(".label-top > div").text()==='JUGADAS NO PROCESADAS'){
        	tagginJugadaNoProcesada("Tinka", label);
        }
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
            } else {
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

    function grilla_paginada2(data) {
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
            } else {
                style = "num_page_on";
            }
            if (i % 3 == 0) {
                cont++;
                links += "&nbsp;<a class='lnk-pag2 lnk " + style + " ' id='id" + posx + "_" + posy + "_" + posz + "i' rel='" + posx + "-" + posy + "-" + posz + "' >" + cont + "</a>&nbsp;";
                posx = posx + 3;
                posy = posy + 3;
                posz = posz + 3;
            }
        }
        $('#num_link').html("<span class='indice_page'>1</span> de " + cont + "<span class='pages-links'><" + links + "></span>");
    }
    
    var idsession = $("#clientId").val();
    if(idsession != '' && $("#agreement").val() == ''){
        $("#login_section").show();
        $('.img_zona_segura').css({"margin-top":"93px"});
        exe.opentyc(null);
    } else if (idsession == '') {
        $("#login_section").show();
        $('.img_zona_segura').css({"margin-top":"93px"});
    } else {
        $("#panel_finaliza_compra").show();
        flagFinalizar=true;
        $("#tab-item_4").show();
        $("#payments_section").show();
        $('.img_zona_segura').css({"margin-top":"0px"});
    }
   
    function fecha_actual() {
        var f = new Date();
        var mes = "";
        var dia = "";
        /*var temp_mes = f.getMonth() + "";*/
        var temp_mes = (f.getMonth() + 1) + "";
        var temp_dia = f.getDate() + "";
        if (temp_mes.length == 1) {
            mes = "0" + (f.getMonth() + 1) + "";
        } else {
            mes = (f.getMonth() + 1) + "";
        }
        if (temp_dia.length == 1) {
            dia = "0" + f.getDate() + "";
        } else {
            dia = f.getDate() + "";
        }
        return dia + "/" + mes + "/" + f.getFullYear();
    }

    $(".label_2").html(fecha_actual());
    function trim(string) {
        for (i = 0; i < string.length;) {
            if (string.charAt(i) == " ") {
                string = string.substring(i + 1, string.length);
            } else {
                break;
            }
        }
        for (i = string.length - 1; i >= 0; i = string.length - 1) {
            if (string.charAt(i) == " ") {
                string = string.substring(0, i);
            } else {
                break;
            }
        }
        return string;
    }

    $("#option-card-0").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
    });
    $("#option-card-1").click(function () {
        $("#panel_transaccion_1").show();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
    });
    $("#option-card-2").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").show();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
    });
    $("#option-card-3").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").show();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
    })
    $("#option-card-4").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").show();
        $("#panel_transaccion_5").hide();
    })
    $("#option-card-5").click(function () {
            $("#panel_transaccion_1").hide();
            $("#panel_transaccion_2").hide();
            $("#panel_transaccion_3").hide();
            $("#panel_transaccion_5").show();
            $("#panel_transaccion_4").hide();
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
     
    function viewNext(){
        $('#password-client-header').val('');
        $('#password-client').val('');
        $(".logout").show();
        $(".unlogout").hide();
        $("#tab-item_4").show();
        $("#payments_section").show();
        $('.img_zona_segura').css({"margin-top":"0px"});
        $("#login_section").hide();
        $("#panel_finaliza_compra").show();
    }
    
    // actualizando la pagina para ir al paso 2 automaticamente
    function tinkaSession(){
    	if (status != "ACT") return;
    	$('.wrapper-playing').hide();
    	$('.wrapper-buying').show();
    	$('.step-play').removeClass('step-active');
        $('.step-status-2').addClass('step-active');
    	$('.transition-one').hide();
        $('.transition-two').show();
        
        content_object_2=content_object.sort(function(prev,next){
            return next[6]-prev[6];
        }); 
        
        var pendientes_gratis= 0 ;
        if($('.result5').text()!=""){
        	  pendientes_gratis = $('.result5').text()* parseFloat(precioReg);
        }
        else{
        	var pendientes_gratis = $('#balanceAmountGame').val();
        }
        
        costo_total = 0
        var gratis_total = 0 
        for (var v in content_object_2) {
        	var precio_cu = content_object_2[v][6];
        	if(content_object_2[v][6]!=content_object_2[v][8]){
        		content_object[v][10]=(parseFloat(precio_cu));
        		costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
        	}
        	else{
            if(precio_cu <= pendientes_gratis){
            	content_object[v][10]=(0);
            	gratis_total =parseFloat(gratis_total)+ parseFloat(precio_cu);
            	pendientes_gratis = parseFloat(pendientes_gratis)-parseFloat(precio_cu);
            } else {
            	content_object[v][10]=(parseFloat(precio_cu));
            	costo_total =parseFloat(costo_total)+ parseFloat(precio_cu);
              }
        	}
        }

        grilla_boletos(content_object_2);
        grilla_paginada(content_object_2);
        value_numberJ1 = [];
        value_numberJ2 = [];
        value_numberJ3 = [];
        value_numberJ4 = [];
        
		dataLayerlimpiar = false;
        $(".clear").click();
        dataLayerlimpiar = true;
        
        $(".result1").html("S/ " + floatFormat(costo_total));
        $("#totalPagar").text(costo_total);
        
        if($('.label_resu2').parent('h4').text().includes("Costo por jugada"))
        	$(".label_resu2").html($("#price-message").text());
        
        //$("#mySelectBox").val("1");
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
                       
        v_content_object=content_object;
    }
    
function eliminarSessionTinka(){
    	
    	eliminarCookieDeJugada("jugadaSessionTinka");	
    	
        gameLink = $('#plays-1 > ul > li > a[href="juega-tinka.html"]');
        gameLink.children('.jugadaSession').remove();
        categoryElement = $('#plays-1');
        if (categoryElement.find('ul .jugadaSession').length == 0) {
            var categoryLink = categoryElement.find('> a');
            categoryLink.find('.jugadaSession').remove();
        }
    }
    
    function rellenarSession(){
    	guardarJugadaEnCookie("jugadaSessionTinka",content_object, 365);
        
        gameLink = $('#plays-1 > ul > li > a[href="juega-tinka.html"]');
        gameLink.prepend($('<span class="jugadaSession"></span>')); 
        categoryElement = $('#plays-1');
        
        if (categoryElement.find('ul .jugadaSession').length == 1) {
            var categoryLink = categoryElement.find('> a');
            categoryLink.prepend($('<span class="jugadaSession"></span>'));
        }
    }
    
};
$($tinka);
function pagoEfectivoF(redireccion){
    $("#option-card-0").prop("checked", "checked");
    $("#panel_transaccion_1").hide();
    $("#panel_transaccion_2").hide();
    $("#panel_transaccion_3").hide();
    $("#panel_transaccion_4").hide();
    dhtmlwindow.open('resultbox', 'iframe',redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal');

}
function safetyPay(redireccion){
    dhtmlwindow.open('resultbox', 'iframe',redireccion, 'SAFETYPAY', 'width=963,height=670,scrolling=1,center=1,resize=0', 'recal');
    $('#resultbox').append("<a id='return-comerce' Style='position: absolute; margin-top: -86px; width: 120px; margin-left: 508px; cursor:alias;'></a>");
}


function tagginTinkaEEaddToCart(costoTotalBet){
	costoTotalBet=costoTotalBet.toFixed(2);
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	  'event': 'EEaddToCart',
	  'ecommerce': {
	    'currencyCode': 'PEN',
	    'add': {                    
	      'products': [{        
	        'name': 'Tinka Jugada Individual',
	        'id': 'tinkaInd',
	        'price': costoTotalBet,    //Indicar aquí el “Costo total” de la jugada
	        'brand': 'Juegos',
	        'quantity': '1',
	        'category': 'Tinka'        
	       }]
	    }
	  }
	});
	
	var tag="Tinka Jugada Individual EEaddToCart";
	console.log("Taggin event: "+tag+", precio: "+costoTotalBet);

}

function tagginFinalizar(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageUrl': '/juega-tinka/individual/paso2/',
	    'pageTitle': 'Finaliza tu compra - Individual - Tinka'

	});
	
	var tag="Finaliza tu compra - Individual - Tinka";
	console.log("Taggin event: "+tag);

}

function tagginTinkaEEcheckout(){	
	//Reiniciar tag checkout
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	  'event': 'EEcheckout',
	   'ecommerce': {
	      'checkout': undefined
	
	  }
	});
	
	//Enviar evento checkout
	var aproduct=[];	
	for(var j=0; j<v_content_object.length; j++){
		
		var data=v_content_object[j];
		var price=data[6];
		price=price.toFixed(2);
	
		var productJson={
				'name': 'Tinka Jugada Individual', 
		        'id': 'tinkaInd',
		        'price': price,   //Indicar el precio de la jugada
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Tinka'
			}	
		aproduct.push(productJson);
	}	
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	  'event': 'EEcheckout',
	   'ecommerce': {
	      'checkout': {
	        'actionField': {'step': 1},
	        'products': aproduct
	    }
	  }
	});
	
	var tag="EEcheckout - Individual - Tinka";
	console.log("Taggin event: "+tag);

}

function tagginTinkaEEremoveFromCart(price){
	price=price.toFixed(2);
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	  'event': 'EEremoveFromCart',
	  'ecommerce': {
	    'remove': {                             
	      'products': [{ 
	          'name': 'Tinka Jugada Individual', 
	          'id': 'tinkaInd',
	          'price': price,   //Indicar el precio de la jugada
	          'brand': 'Juegos',
	          'quantity': '1',
	          'category': 'Tinka'
	       }]
	    }
	  }
	});
	
	var tag="EEremoveFromCart - Individual - Tinka";
	console.log("Taggin event: "+tag+", precio: "+price);

}

function tagginTinkaCompraExitosa(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	'event': 'compraExitosa',
	'pageUrl': '/juega-tinka/individual/confirmacion/',
	'pageTitle': 'Compra exitosa - Individual - Tinka'
	});
	
	var tag="Tinka  compraExitosa";
	console.log("Taggin event: "+tag);

}

function tagginTinkaEEpurchase_1(content_object, new_content) {
	var idTransaction = 0;
	var total_price = 0;
	var aproduct = [];
	var idTransaction = "TK";
	for (var i = 0; i < content_object.length; i++) {
		var product = content_object[i];
		var nproduct = new_content[i];
		var idt = nproduct[4];
		var ok=idt.split("&")[0];
		//Verificar si se procesó jugada
		if (ok==="OK") {
			idTransaction = idTransaction + "-" + idt.split("&")[1];
			var nCosecutivos = product[5];
			var price = product[6];
			var nJugadas = product[9] + "";
			var n = 0;
			var nBolillas = 0;
			for (var m = 0; m < 4; m++) {
				if (product[m].length > 2) {
					n++;
					nBolillas = nBolillas + product[m].split(" ").length;
				}
			}
			nBolillas = "" + (nBolillas / n).toFixed(1);
			n = "" + n;
			//Verificar si es una jugada gratuita
			if (product[10] > 0) {
				total_price = total_price + price;
				price = price.toFixed(2);
				var jproduct = { //Aca se listan las jugadas individuales
					'name' : 'Tinka Jugada Individual',
					'id' : 'tinkaInd',
					'price' : price,
					'brand' : 'Juegos',
					'quantity' : '1',
					'category' : 'Tinka',
					'metric1' : nJugadas, //indicar cantidad de jugadas
					'dimension3' : nCosecutivos, // Indicar cantidad de sorteos consecutivos
					'dimension4' : nBolillas
				// aquí indicar el número de bolillas
				}
			} else {
				price = 0;
				price = price.toFixed(2);
				var jproduct = { //Aca se listan las jugadas individuales
					'name' : 'Tinka Jugada Individual',
					'id' : 'tinkaInd',
					'price' : price,
					'brand' : 'Juegos',
					'quantity' : '1',
					'category' : 'Tinka',
					'variant' : 'jugada gratis',
					'metric1' : nJugadas, //indicar cantidad de jugadas
					'dimension3' : nCosecutivos, // Indicar cantidad de sorteos consecutivos
					'dimension4' : nBolillas
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

	var tag = "Tinka  EEpurchase";
	console.log("Taggin event: " + tag);

}

function tagginTinkaEEpurchase(content_object, new_content) {
	var idTransaction = 0;
	var total_price = 0;
	var aproduct = [];
	var idTransaction = "TK";
	for (var i = 0; i < content_object.length; i++) {
		var product = content_object[i];
		var nproduct = new_content[i];
		var idt = nproduct[4];
		var ok=idt.split("&")[0];
		//Verificar si se procesó jugada
		if (ok==="OK") {
			idTransaction = idTransaction + "-" + idt.split("&")[1];
			var nCosecutivos = product[5];
			var price = product[6];
			var nJugadas = product[9] + "";
			var n = 0;
			var nBolillas = 0;
			for (var m = 0; m < 4; m++) {
				if (product[m].length > 2) {
					n++;
					nBolillas = nBolillas + product[m].split(" ").length;
				}
			}
			nBolillas = "" + (nBolillas / n).toFixed(1);
			n = "" + n;
			//Verificar si es una jugada gratuita
			if (product[10] > 0) {
				var tipoPromocion='Promo '+$('#promotionMessage').val();
				var precioNormal= product[8];
				if((tipoPromocion!="" || tipoPromocion!=null) && (parseFloat(precioNormal) > parseFloat(price)) ){
				total_price = total_price + price;
				price = price.toFixed(2);
				var jproduct = { //Aca se listan las jugadas individuales
					'name' : 'Tinka Jugada Individual',
					'id' : 'tinkaInd',
					'price' : price,
					'brand' : 'Juegos',
					'quantity' : '1',
					'category' : 'Tinka',
						'variant' : tipoPromocion,
					'metric1' : nJugadas, //indicar cantidad de jugadas
					'dimension3' : nCosecutivos, // Indicar cantidad de sorteos consecutivos
					'dimension4' : nBolillas
				// aquí indicar el número de bolillas
				}
				}else{
					total_price = total_price + price;
					price = price.toFixed(2);
					var jproduct = { //Aca se listan las jugadas individuales
						'name' : 'Tinka Jugada Individual',
						'id' : 'tinkaInd',
						'price' : price,
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Tinka',
						'variant' : 'jugada estandar',
						'metric1' : nJugadas, //indicar cantidad de jugadas
						'dimension3' : nCosecutivos, // Indicar cantidad de sorteos consecutivos
						'dimension4' : nBolillas
					// aquí indicar el número de bolillas
					}
				}
				
			} else {
				price = 0;
				price = price.toFixed(2);
				var jproduct = { //Aca se listan las jugadas individuales
					'name' : 'Tinka Jugada Individual',
					'id' : 'tinkaInd',
					'price' : price,
					'brand' : 'Juegos',
					'quantity' : '1',
					'category' : 'Tinka',
					'variant' : 'jugada gratis',
					'metric1' : nJugadas, //indicar cantidad de jugadas
					'dimension3' : nCosecutivos, // Indicar cantidad de sorteos consecutivos
					'dimension4' : nBolillas
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

	var tag = "Tinka  EEpurchase";
	console.log("Taggin event: " + tag);

}

function LoginInvitadoTinkaExpress(){
	var content_object = obtenerJugadaDesdeCookie("jugadaSessionTinka") ; 
	var total_jugadas=content_object[0][9];
	var total_consecutivas=content_object[0][5];
	if(total_jugadas>4 || total_consecutivas>1){
		var titulo = "";
		var mensaje = "Para realizar jugadas m&uacute;ltiples o consecutivas, debes registrarte o inicias sesi&oacute;n.";
        var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error" style="font-size: 17px;"><span>'+mensaje+'</span></div><br><br>'+
        '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">OK</button></div>';
        $('#close-popup-message').hide();
        $('#msg-message').html(msgError);
    	openModal("#popup-message","");
//    	document.addEventListener("click", validateSession);
//		document.addEventListener("keypress", validateSession);
//		alert("Para realizar jugadas múltiples o consecutivas, debes registrarte o inicias sesión.");
		return;
	}
	
	let carrito = {};
	carrito.a = v_content_object[0][0].replace(/ /g, "-").replace(/00/g, "").replace(/\b0(\d)\b/g, "$1");
	carrito.b = v_content_object[0][1].replace(/ /g, "-").replace(/00/g, "").replace(/\b0(\d)\b/g, "$1");
	carrito.c = v_content_object[0][2].replace(/ /g, "-").replace(/00/g, "").replace(/\b0(\d)\b/g, "$1");
	carrito.d = v_content_object[0][3].replace(/ /g, "-").replace(/00/g, "").replace(/\b0(\d)\b/g, "$1");
	carrito.price = parseFloat($("#price-message").text().replace(/S\/ /g, "")).toFixed(2);
	carrito.quantity = v_content_object[0][9].replace(",", "");
	carrito.total = parseFloat(v_content_object[0][6]).toFixed(2);
	carrito.total_draws = v_content_object[0][5];
	
	carrito.date_to = $("#mySelectBox").find("option:selected").text().match(/(\d{2})\/(\d{2})\/(\d{4})/);

	// Verificar si se encontró una coincidencia y extraer la fecha
	carrito.date_to = carrito.date_to ? `${carrito.date_to[1]}-${carrito.date_to[2]}-${carrito.date_to[3]}` : null;

	carrito.promo = $("#flagPromotionMessage").val() == 'true' ? $("#promotionMessage").val() : '';
	let iframe = $("#tinkaExpressIframe");
	let params = new URLSearchParams(carrito).toString() ;
	params = params + "&crc="+calculateCRC(params);
	iframe.attr("src", $("#srcTinkaExpressIframe").val()  + "?" + params);
	
	let boxContentGame = $(".wrapper-buying"); 
	boxContentGame.find(".box-wrapper-game").hide();
	$(".play-help").hide();
	iframe.show(); 
}

function calculateCRC(data) {
	  const polynomial = 0xEDB88320; // Polinomio generador para CRC-32
	  let crc = 0xFFFFFFFF;

	  for (let i = 0; i < data.length; i++) {
	    let byte = data.charCodeAt(i) & 0xFF;
	    crc ^= byte;

	    for (let j = 0; j < 8; j++) {
	      if (crc & 1) {
	        crc = (crc >>> 1) ^ polynomial;
	      } else {
	        crc >>>= 1;
	      }
	    }
	  }

	  crc ^= 0xFFFFFFFF;
	  crc = crc >>> 0; // Convertir a un entero sin signo de 32 bits
	  return crc.toString(16).toUpperCase().padStart(8, '0');
	}


function isValidLength(value) {
    return 0 < value.length && value.length < 6;
}

function showErrorAndAlert(message) {
    try {
        tagginPopupError("Tinka", message);
    } catch (e) {
        console.error(e);
    }

    jAlert(message, null);				  
}

function checkJugadasSeleccionadas() {
    const j1 = $('input[name="J1check"]:checked').length >= 6;
    const j2 = $('input[name="J2check"]:checked').length >= 6;
    const j3 = $('input[name="J3check"]:checked').length >= 6;
    const j4 = $('input[name="J4check"]:checked').length >= 6;
    if (j1 && j2 && j3 && j4) {
        $('#morePlaysText').hide();
    } else {
        $('#morePlaysText').show();
    }
}


//$(window).on('beforeunload', function() {
//	alert("¿Estás seguro de que quieres salir?");
//	let contador = 0;
//	while (contador < 500000) {
//	    contador++;
//	    if (contador === 3) {
//	        continue;  // Salta la iteración cuando contador sea igual a 3
//	    }
//	    console.log(contador);
//	}
//    return '¿Estás seguro de que quieres salir?';
//});