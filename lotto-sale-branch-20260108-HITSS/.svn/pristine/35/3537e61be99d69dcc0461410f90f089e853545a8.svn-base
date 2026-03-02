;
var $awardGanadiario = function () {
    var total = 0;
    var count = 0;
    var countJ1 = 0;
    var countJ2 = 0;
    var countJ3 = 0;
    var countJ4 = 0;
    var sub_total = 0;
    var contador_1 = 0;
    var contador_2 = 0;
    var contador_3 = 0;
    var contador_4 = 0;
    var cantin_1 = 0;
    var cantin_2 = 0;
    var cantin_3 = 0;
    var cantin_4 = 0;
    var content_object = [];
    var status = $("#status").val();
    $('.finalize-purchase').hide();
    $('.wrapper-buying').hide();
    $("#plays-1").addClass("active");
    $("#part2").hide();
    $(".flecha_back").hide();
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
    $('.transition-two-award').hide();
    if (status == 'CIE') {
        disabled_game();
    } 
    if (status == "ACT") {
            $("input[type=checkbox]").change(function () {
                var id_value = $(this).attr("id");
                var first_letter_id = id_value.substr(0, 2);
                var number_id = id_value.substr(8, 2);
                if ($("#" + id_value).is(':checked')) {
                    if (count <= 5) {
                        count = util(first_letter_id, 1);
                        if (sub_total <= 4) {
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', true);
                            array_number(number_id, first_letter_id);
                            $("#L" + id_value).addClass("colorChecked");
                        }
                        if (count > 5 || sub_total > 4) {
                            $("#L" + id_value).removeClass("colorChecked");
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                            count = util(first_letter_id, 2);
                            delete_array_number(number_id, first_letter_id);
                        }
                    }
                } else {
                    count = util(first_letter_id, 2);
                    $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                    delete_array_number(number_id, first_letter_id);
                    $("#L" + id_value).removeClass("colorChecked");
                }
                combinatoria();
            })
    }
    var value_numberJ1 = [];
    var value_numberJ2 = [];
    var value_numberJ3 = [];
    var value_numberJ4 = [];
    function disabled_game() {
        $("#panel-disable-A").addClass("enabled");
        $("#panel-disable-B").addClass("enabled");
        $("#panel-disable-C").addClass("enabled");
        $("#panel-disable-D").addClass("enabled");
        $("#panel-disable-F").addClass("enabled");
    }
    function show(first_letter_id, value_number) {
        value_number.sort(function (a, b) {
            return b - a;
        });
        value_number.reverse();
        $("#" + first_letter_id + "-text-area").val(value_number.join(', '));
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
            var title = $(this).attr("id").substr(0, 2);
            for (ini = 0; ini <= 45; ini++) {
              $("#" + title + "check_" + ini).prop('checked', false);
              $("#L" + title + "check_" + ini).removeClass("colorChecked");
              if (title == "J1") {
                //
                $('div[data-game="a"]').removeClass('game-played');
                //
                value_numberJ1.splice(0, 1);
                show(title, value_numberJ1);
              }
              if (title == "J2") {
                //
                $('div[data-game="b"]').removeClass('game-played');
                //
                value_numberJ2.splice(0, 1);
                show(title, value_numberJ2)
              }
              if (title == "J3") {
                //
                $('div[data-game="c"]').removeClass('game-played');
                //
                value_numberJ3.splice(0, 1);
                show(title, value_numberJ3)
              }
              if (title == "J4") {
                //
                $('div[data-game="d"]').removeClass('game-played');
                //
                value_numberJ4.splice(0, 1);
                show(title, value_numberJ4)
              }
            }
            count = util(title, 3);
            combinatoria()
          } 	
    	/*
        if (status == "ACT") {
            var title = $(this).attr("id").substr(0,2);
            for (ini = 0; ini <= 35; ini++) {
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
            combinatoria();
        }
        */
    });
    function clear_for_ini(title) {
        for (ini = 0; ini <= 35; ini++) {
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
            for (ini = 0; ini < 5; ini++) {
                if (value_numberJ1[ini] == value) {
                    return false;
                }
            }
        }
        if (title == "J2") {
            for (ini = 0; ini < 5; ini++) {
                if (value_numberJ2[ini] == value) {
                    return false;
                }
            }
        }
        if (title == "J3") {
            for (ini = 0; ini < 5; ini++) {
                if (value_numberJ3[ini] == value) {
                    return false;
                }
            }
        }
        if (title == "J4") {
            for (ini = 0; ini < 5; ini++) {
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
                    countJ1 = 5;
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
                    countJ2 = 5;
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
                    countJ3 = 5;
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
                    countJ4 = 5;
                }
                return countJ4;
                break;
        }
    }

    $(".azar").click(function () {
        if (status == "ACT") {
            if (sub_total < 3003) {
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
                if (count >= 5) {
                    count = 0;
                    clear_for_ini(title);
                }
                while (count < 5) {
                    var number_azar = Math.round(1 + (Math.random() * (35 - 1)));
                    if (buscar_repetido(number_azar, title)) {
                        $("#" + title + "check_" + number_azar).prop('checked', true);
                        $("#L" + title + "check_" + number_azar).addClass("colorChecked");
                        array_number(number_azar, title);
                        count = util(title, 1);
                    }
                }
                combinatoria();
            }
        }
    });
    var algorithm = $("#algorithm").val();
    var costoTotalBet = 0;
    var costoTotalBetMensaje = 0;
    
    $('#add').click(function () {
        if(!$(this).hasClass("btn-disabled")) {
            if(status=='ACT'){ 
               if((0<value_numberJ1.length && value_numberJ1.length<5) || (0<value_numberJ2.length && value_numberJ2.length<5) || (0<value_numberJ3.length && value_numberJ3.length<5) || (0<value_numberJ4.length && value_numberJ4.length<5)) {
                   jAlert('Elige correctamente tu apuesta.', null);
               } else if (total<1 && costoTotalBet<=0) {
                   jAlert('No ha realizado ninguna jugada. total='+total+" costoTotalBet="+costoTotalBet, null);
               } else {
                   if (total <= 1716 && total >= 1) {
                       var cant_sorteo = 0;
                       var precio = costoTotalBet;
                       add_ticket(value_numberJ1, value_numberJ2, value_numberJ3, value_numberJ4, content_object, cant_sorteo, precio);
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
                       value_numberJ1 = [];
                       value_numberJ2 = [];
                       value_numberJ3 = [];
                       value_numberJ4 = [];
                       $(".clear").click();
                       var costo_total = 0;
                       for (var i in content_object) {
                           costo_total += parseFloat(content_object[i][6]);
                       }
                       $("#part2").hide();
                       $("#part1").show();
                       $('.flecha_back').addClass("flecha_next");
                       $(".flecha_next").show();
                       $(".flecha_back").hide();
                       sorteos = 1;
                       costoTotalBet = 0;
                       costoTotalBetMensaje = 0;
                       awardPaid();
                   }
               }
           }
        }
    });
    $('.more').click(function () {
        if (status == "ACT") {
            if (sub_total < 3003) {
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
            if (sub_total < 3003) {
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
    var sorteos = 1;
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
        var cnt = 0;
        for (var iniL = 1; iniL <= 4; iniL++) {
            var contador = 0;
            for (ini = 1; ini <= 35; ini++) {
                if ($("#J" + iniL + "check_" + ini).is(':checked')) {
                    contador++;
                }
            }
            if (iniL == 1) {
                contador_1 = contador;
                if (contador >= 5) {
                    cantin_1 = bin_newton(contador);
                    cnt++;
                } else {
                    cantin_1 = 0;
                }
                if (contador_1 <= 4 && contador_1 > 0) {
                    sub_cantin_1 = 1;
                } else {
                    sub_cantin_1 = cantin_1;
                }
            }
            if (iniL == 2) {
                contador_2 = contador;
                if (contador >= 5) {
                    cantin_2 = bin_newton(contador);
                    cnt++;
                } else {
                    cantin_2 = 0;
                }
                if (contador_2 <= 4 && contador_2 > 0) {
                    sub_cantin_2 = 1;
                } else {
                    sub_cantin_2 = cantin_2;
                }
            }
            if (iniL == 3) {
                contador_3 = contador;
                if (contador >= 5) {
                    cantin_3 = bin_newton(contador);
                    cnt++;
                } else {
                    cantin_3 = 0;
                }
                if (contador_3 <= 4 && contador_3 > 0) {
                    sub_cantin_3 = 1;
                } else {
                    sub_cantin_3 = cantin_3;
                }
            }
            if (iniL == 4) {
                contador_4 = contador;
                if (contador >= 5) {
                    cantin_4 = bin_newton(contador);
                    cnt++;
                } else {
                    cantin_4 = 0;
                }
                if (contador_4 <= 4 && contador_4 > 0) {
                    sub_cantin_4 = 1;
                } else {
                    sub_cantin_4 = cantin_4;
                }
            }
        }
        sub_total = sub_cantin_1 + sub_cantin_2 + sub_cantin_3 + sub_cantin_4;
        if (sub_total <= 3003) {
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
                        costoTotalBet = v_data_value_bet * total * sorteos;
                    }
                }
            }
        } else {
            total = 0;
            costoTotalBet=0;
        }
        if(cnt == top.groups) {
            $("#arr-add").removeClass("arr-disabled");
            $("#add").removeClass("btn-disabled");
        } else {
            if(!$("#arr-add").hasClass("arr-disabled")) $("#arr-add").addClass("arr-disabled");
            if(!$("#add").hasClass("btn-disabled")) $("#add").addClass("btn-disabled");
        }
    }

    function bin_newton(cantidad) {
        var deduct_1 = 1;
        var deduct_2 = 1;
        var count_2 = cantidad - 5;
        variable = factorial(cantidad) / (120 * (factorial(count_2)));
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
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(var_sum_total_bet_consecutive / p_bets) * (p_bets * p_data_value_bet - p_cost)));
        return var_total_cost;
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
        //grilla_paginada(content_object);
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
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#" + $(this).attr("id")).removeClass("num_page_on");
        $("#" + $(this).attr("id")).addClass("num_page_off");
    });
    var new_content_object = [];
    $("#finalize").click(function () {
        if(!$(this).hasClass("btn-disabled")) {
            //var amount = 0.0;
            //var newamount = 0.0;
            //var msgres = [];
            for (var i in content_object) {
                content_object[i][4] = "null";
            }
            if (content_object.length != 0) {
                var content_grid_2 = "<div class='label-top'></div>" + "<div class='label_1'>GANA DIARIO</div>" + "<div id='ajax-loader'>" + "<img src='layer-view-image/game/ganadiario/ajax-loader.gif'>" + "</div><div id='content-grid-result'></div>" + "<div id='num_link'></div>" + "<div id='game-no-process-info'></div>";
                $(".left-panel").html(content_grid_2);
                $('.step-status-1').removeClass("step-active");
                $('.step-status-2').addClass("step-active");
                //$('.transition-one-award').hide();
                //$('.transition-two-award').show();
                $('#start_play').hide();
                $('.finalize-purchase').show();
                $('.wrapper-buying').show();
                $('#award-panel').hide();
                $("#panel_keep-playing").show();
                //$("#panel_game-award").show();
                $("#panel_game-history").show();
                $("#ico-block").show();
                //$(".label-top").show();
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
                $.ajax({type: "POST", url: "pago_premio.html", data: "dato=" + result_ticket + "&desist=" + sdesist + "&credit=" + scredit + "&game=164", dataType: "text", success: function (e) {
                    var fila = e.split("#");
                    var mensaje = "";
                    for (var n = 0; n < fila.length; n++) {
                        var items = fila[n].split("|");
                        var procesos = items[4].split("&");
                        mensaje = procesos[0].trim();
                        if(mensaje == "OK" || mensaje == "TC") {
	                        var row_object = [];
	                        for (var m = 0; m < items.length; m++) {
	                            row_object.push(trim(items[m]));
	                        }
	                        new_content_object.push(row_object);
                        }
                    }
                    
                    if(new_content_object.length>0) {
                    	$(".label_resu3").html("<b>Saldo Disponible:<b>");
                        $(".result3").html("S/. " + floatFormat(new_content_object[(new_content_object.length - 1)][10]));
                        $("#clientSale-amount").text(floatFormat(new_content_object[(new_content_object.length - 1)][10]));
                        //$("#saldoUser").val()==new_content_object[(new_content_object.length - 1)][10];
                        $("#ajax-loader").hide();
                    	/*
    	                $(".label_resu3").html("<b>Saldo Disponible: S/. " + floatFormat(new_content_object[(new_content_object.length - 1)][10])+"</b>");
    	                $("#clientSale-amount").text(floatFormat(new_content_object[(new_content_object.length - 1)][10]));
    	                $("#ajax-loader").hide();
    	                */
    	                grilla_boletos2(new_content_object);
    	                grilla_paginada2(new_content_object);
    	                var costo_total = 0;
    	                var costo = 0;
    	                var procesos = [];
    	                for (var t in new_content_object) {
    	                    procesos = (new_content_object[t][4] + "").split("&");
    	                    if (procesos[1] != "null") {
    	                        costo = floatFormat(parseFloat(new_content_object[t][6]));
    	                    }
    	                }
    	                $(".label_resu2").html("<b>Costo por jugada:</b>");
    	                $(".result2").html("S/. " + costo);
    	                /*
    	                $(".label_resu2").html("Costo por jugada:");
    	                $(".label_resu4").html("S/. " + costo);
    	                */
    	                if (procesos[1] != "null") {
    	                    $(".label-top").html("&#161;FELICIDADES! COBRASTE TU PREMIO");
    	                    costo_total += parseFloat(new_content_object[(new_content_object.length-1)][11]);//parseFloat(new_content_object[t][6]);
    	                }
    	                $(".result1").html("S/. " + floatFormat(costo_total));
    	                $(".label_resu1").html("TOTAL DESCONTADO:");
                    } else {
                    	jAlert(mensaje, null, function(r){if(r){$(parent.location).attr('href', 'mi-cuenta.html#movimientos')}});
                    	//jAlert("No se tiene jugadas para procesar.", null, function(r){if(r){$(parent.location).attr('href', 'mi-cuenta.html#movimientos')}});
                    }
                    
                }})

            } else {
            	jAlert("No se tiene jugadas por procesar.", null, function(r){if(r){$(parent.location).attr('href', 'mi-cuenta.html#movimientos')}});
            }
        }
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
        $(".tooltip-no-process").eq(posicion).hide();//.css("display", "none");
        $(".tooltip-no-process").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img").eq(posicion).hide();//.css("display", "none")
    });
    var array_no_procesados = [];
    $('.left-panel').on('click','#btn-no-process',function(){
        var contador = 0;
        for (var i in new_content_object) {
            var procesos = (new_content_object[i][4] + "").split("&");
            if (procesos[1] == "null") {
                array_no_procesados.push(new_content_object[i]);
                contador++;
            }
        }
        $("#panel_keep-playing").hide();
        $("#panel_game-history").hide();
        $("#ico-block").hide();
        $(".left-panel").html("");
        var temp_jugada_2 = "<span class='label_1'>GANADIARIO</span>" + "<div id='content-grid-result'></div>" + "<div id='num_link'></div>";
        $(".left-panel").html(temp_jugada_2);
        if (status == "ACT") {
            $('.transition-one-award').hide();
            $('.transition-two-award').show();
            $('#start_play').hide();
            //$('#help-part1').hide();
            $('.finalize-purchase').show();
            $('.wrapper-buying').show();
            var cant_sorteo = 1;
            var precio = costoTotalBet;
            content_object = [];
            content_object = array_no_procesados;
            array_no_procesados = [];
            new_content_object = [];
            $(".clear").click();
            var costo_total = 0;
            for (var i in content_object) {
                costo_total += parseFloat(content_object[i][6]);
            }
            $(".result1").html("S/." + floatFormat(costo_total));
        }
    });
    function add_ticket(juego1, juego2, juego3, juego4, content_object, cantidad_sorteo, precio) {
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
        content_object.push(object_boleto);
    }

    function grilla_boletos2(data) {
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var no_process_message_count = 0;
        var grilla = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>VER</div>" + "</div>" + "<div id='total_filas'>";
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
                var game_no_process_info = "<div class='title-text'><div><b>Jugadas no procesadas</b></div>" + "<div>Tienes apuestas que no se han podido procesar.</div></div>" + "<div id='no-process-section'><a href='#' class='buttom-go' id='btn-no-process' onclick='return false;'></a></div>";
                $("#game-no-process-info").html(game_no_process_info);
                $("#game-no-process-info").show();
            } else {
                process_resp = "<div class='column3-codigo'>" + dato_proceso[1] + "</div><div class='column3-search' onclick='openPreviewWindow(" + data[x][9] + ",\"" + data[x][8] + "\",\"" + dato_proceso[1] + "\")'></div>";
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + data[x][7] + "</div>" + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + process_resp + "</div>";
        }
        grilla += "</div></div>";
        $('#content-grid-result').html(grilla);
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

    $('.img_zona_segura').css({"margin-top":"0px"});
    function fecha_actual() {
        var f = new Date();
        var mes = "";
        var dia = "";
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
};
$($awardGanadiario);