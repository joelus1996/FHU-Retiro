// JavaScript Document


$().ready(function () {
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

    var status = $("#status").val();

    $("#menu-item-1").addClass("main-nav-list-item current-menu-item");
    $("#menu-item-2").addClass("main-nav-list-item");
    $("#menu-item-3").addClass("main-nav-list-item");
    $("#menu-item-4").addClass("main-nav-list-item");
    $("#menu-item-5").addClass("main-nav-list-item");


    $("#part2").hide();
    $(".flecha_back").hide();
    if (status == "ACT") {
        $('.flecha_next').click(function () {
            $("#part1").hide();
            $("#part2").show();
            $(".flecha_next").hide();
            $(".flecha_back").show();
            $(".play_go_3_4_gd").addClass("play_go_1_2_gd");
            $(".play_go_3_4_gd").removeClass("play_go_3_4_gd");
        });

        $('.flecha_back').click(function () {
            $("#part2").hide();
            $("#part1").show();
            $(".play_go_1_2_gd").addClass("play_go_3_4_gd");
            $('.flecha_back').addClass("flecha_next");
            $(".flecha_next").show();
            $(".flecha_back").hide();
        });
    }
    $('.transition-two').hide();
    $('#help-part2').hide();


    if (status == "ACT") {


        $(".attribute-button").mouseover(function () {
            $(this).addClass("attribute-button-on");
        }).mouseout(function () {
                $(this).removeClass("attribute-button-on");
            });
        $(".flecha_back").mouseover(function () {
            $(this).addClass("flecha-back-on");
        }).mouseout(function () {
                $(this).removeClass("flecha-back-on");
            });
        $(".flecha_next").mouseover(function () {
            $(this).addClass("flecha-next-on");
        }).mouseout(function () {
                $(this).removeClass("flecha-next-on");
            });


        /*$(".button-buy-off").mouseover(function(){
         $(this).addClass("button-buy-on");
         }).mouseout(function(){
         $(this).removeClass("button-buy-on");});*/
        $(".help-off").mouseover(function () {
            $(this).addClass("help-on");
        }).mouseout(function () {
                $(this).removeClass("help-on");
            });
    }


    //codigo para los navegadores de internet explorer ver 7.0 y 8.0
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
                }
                else {
                    if (count <= 15) {
                        count = util(first_letter_id, 1);
                        if (sub_total <= 3003) {
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', true);
                            array_number(number_id, first_letter_id);
                            $("#L" + id_value).addClass("colorChecked");
                            combinatoria();
                        }

                        if (count > 15 || sub_total > 3003) {

                            $("#L" + id_value).removeClass("colorChecked");
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                            count = util(first_letter_id, 2);
                            delete_array_number(number_id, first_letter_id);
                            combinatoria();

                        }
                    }
                }

            });

        }
        //codigo para el resto de navegadores
        else {

            $("input[type=checkbox]").change(function () {

                var id_value = $(this).attr("id");
                var first_letter_id = id_value.substr(0, 2);
                var number_id = id_value.substr(8, 2);


                if ($("#" + id_value).is(':checked')) {
                    if (count <= 15) {

                        count = util(first_letter_id, 1);

                        if (sub_total <= 3003) {
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', true);
                            array_number(number_id, first_letter_id);
                            $("#L" + id_value).addClass("colorChecked");
                            combinatoria();
                        }
                        if (count > 15 || sub_total > 3003) {

                            $("#L" + id_value).removeClass("colorChecked");
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                            count = util(first_letter_id, 2);
                            delete_array_number(number_id, first_letter_id);
                            combinatoria();
                        }
                    }
                }

                else {

                    count = util(first_letter_id, 2);
                    $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                    delete_array_number(number_id, first_letter_id);
                    $("#L" + id_value).removeClass("colorChecked");
                }
                combinatoria();
            });


        }
    }
    //Array por cada juego  
    var value_numberJ1 = [];
    var value_numberJ2 = [];
    var value_numberJ3 = [];
    var value_numberJ4 = [];

    function show(first_letter_id, value_number) {
        value_number.sort(function (a, b) {
            return b - a;
        });
        value_number.reverse();
        $("#" + first_letter_id + "-text-area").val(value_number);
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

    //Clear 
    $(".clear").click(function () {
        if (status == "ACT") {
            var title = $(this).attr("id");
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

    //buscar repetidos   
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
            case "J1":
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
            case "J2":
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
            case "J3":
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
            case "J4":
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
                var title = $(this).attr("id");
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

    /*boton para comprar*/

    $('#buy').click(function () {
        if (status == "ACT") {
            if (total <= 3003 && total >= 1) {
                $('.transition-one').hide();
                $('.transition-two').show();
                $('#start_play').hide();
                $('#help-part1').hide();
            }
            if (total > 3003) {
                jAlert("El total de apuestas no debe ser mayor a 3003");
            }
        }
    });


    /*
     * boton de mas salidos
     * */
    $('.more').click(function () {
        if (status == "ACT") {
            if (sub_total < 3003) {
                var more = [];
                var title = $(this).attr("id");
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
                var title = $(this).attr("id");
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


    var sorteos = $("#mySelectBox").val();

    $("#mySelectBox").change(function () {
        sorteos = $(this).val();
        combinatoria();

    });

    var price_type;
    price_type = $("#price_type").val();
    var promo;
    promo = $("#promo").val();
    var v_data_value_bet = 0;
    v_data_value_bet = $("#simpleBetPrice_repeated").val();

    var costoTotalBet = 0;

    function combinatoria() {
        var sub_cantin_1 = 0;
        var sub_cantin_2 = 0;
        var sub_cantin_3 = 0;
        var sub_cantin_4 = 0;
        for (iniL = 1; iniL <= 4; iniL++) {
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
                }
                else {
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
                }
                else {
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

            if (price_type == "ALG" && promo == "7x5") {
                costoTotalBet = callTransformType7x5(total, sorteos);

            } else {
                costoTotalBet = v_data_value_bet * total * sorteos;
            }

            $('#comb').html(total);
            $('#total_apagar').html(costoTotalBet);
        }
        else {
            $('#comb').html(0);
            $('#total_apagar').html(0);
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
        if (cantidad < 0)
            return 0;
        else if (cantidad > 1)
            return cantidad * factorial(cantidad - 1);
        /* Recursividad */
        return 1;
        /* Condición de terminación, n == 1 */
    }


    function callTransformType7x5(p_sum_total_bet, p_number_consecutive) {
        var var_total_cost = 0;
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = var_sum_total_bet_consecutive * v_data_value_bet;
        if (p_number_consecutive >= 7)
            var_total_cost = ((var_sum_total_bet_consecutive * v_data_value_bet) - (Math.floor(p_number_consecutive / 7) * 2));
        return  var_total_cost;
    }


});
