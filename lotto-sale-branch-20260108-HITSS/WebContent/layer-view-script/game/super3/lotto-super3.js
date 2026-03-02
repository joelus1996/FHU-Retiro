;
var $super3 = function () {

    $('#back_previous').remove();
	$("#menu-item-4").addClass("current-menu-item");
    var total = 0;
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
    var object_ticket = [];
    var new_object_ticket = [];
    var string_ticket = '';
    var content_object = [];
    var combo_draws = $(".selectBox").html();
    var status = $("#status").val();
    $('.finalize-purchase').hide();
    var costoTotalBet = 0;
    var count = 0;
    var costo = $("#simpleBetPrice_repeated").val();
    var number_multiplicator_J1 = 1;
    var number_multiplicator_J2 = 1;
    if (status == 'CIE') {
        disabled_game();
    }    
    if (status == "ACT") {
        // if ($.browser.msie && $.browser.version <= "8.0") {
        if (false) {
            var buffer_number_J = 1;
            var value_numberJ1 = [];
            var value_numberJ2 = [];
            var value_numberJ3 = [];
            var value_numberJ4 = [];
            $(".check_").on("click", function () {
                var number_id;
                var id_value = $(this).attr("id");
                var id_value_2 = $(this).attr("id").substr(1, 12);
                var value = $("#" + id_value_2).val();
                var column_number = id_value.substr(4, 1);
                if (value != number_id && value < number_id && column_number == "M")buffer_number_J = number_id;
                var first_letter_id = id_value.substr(1, 2);
                number_id = id_value.substr(11, 2);
                if (column_number == 'M') {
                    cost(first_letter_id, '');
                    if ($("#" + id_value_2).is(':checked')) {
                        if (total <= 3003) {
                            delete_mutiplicator(first_letter_id);
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                            $("#L" + id_value).removeClass("colorChecked");
                            if (first_letter_id == 'J1')number_multiplicator_J1 = 1;
                            if (first_letter_id == 'J2')number_multiplicator_J2 = 1;
                            cost(first_letter_id, "")
                        }
                    } else {
                        if (total <= 3003) {
                            delete_mutiplicator(first_letter_id);
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', true);
                            $("#L" + id_value_2).addClass("colorChecked");
                            if (first_letter_id == 'J1')number_multiplicator_J1 = value;
                            if (first_letter_id == 'J2')number_multiplicator_J2 = value;
                            cost(first_letter_id, "");
                            if (total > 3003) {
                                $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                $("#L" + id_value_2).removeClass("colorChecked");
                                if (first_letter_id == 'J1') {
                                    number_multiplicator_J1 = buffer_number_J;
                                    cost(first_letter_id, "")
                                }
                                if (first_letter_id == 'J2') {
                                    number_multiplicator_J2 = buffer_number_J;
                                    cost(first_letter_id, "")
                                }
                            }
                        }
                    }
                } else {
                    if (column_number == 'O' || column_number == 'C' || column_number == 'D' || column_number == 'U') {
                        if ($("#" + id_value_2).is(':checked')) {
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                            $("#L" + id_value_2).removeClass("colorChecked");
                            delete_order(first_letter_id, column_number);
                            cost(first_letter_id, "")
                        } else {
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', true);
                            $("#L" + id_value_2).addClass("colorChecked");
                            insert_Orders(first_letter_id, column_number);
                            cost(first_letter_id, "");
                            if (total > 3003) {
                                $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                $("#L" + id_value).removeClass("colorChecked");
                                delete_order(first_letter_id, value);
                                cost(first_letter_id, "")
                            }
                        }
                    } else {
                        if (column_number != 'O' && column_number != 'C' && column_number != 'D' && column_number != 'U') {
                            if ($("#" + id_value_2).is(':checked')) {
                                $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                delete_array_number(number_id, first_letter_id, column_number);
                                $("#L" + id_value_2).removeClass("colorChecked");
                                count = util(first_letter_id, 1)
                            } else {
                                if (count <= 21 || total <= 3003) {
                                    $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', true);
                                    array_number(number_id, first_letter_id, column_number);
                                    $("#L" + id_value_2).addClass("colorChecked");
                                    count = util(first_letter_id, 1);
                                    if (count > 21) {
                                        $("#L" + id_value_2).removeClass("colorChecked");
                                        $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                        delete_array_number(number_id, first_letter_id, column_number);
                                        count = util(first_letter_id, 1)
                                    }
                                }
                                if (total > 3003) {
                                    $("#L" + id_value).removeClass("colorChecked");
                                    $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                    delete_array_number(number_id, first_letter_id, column_number);
                                    count = util(first_letter_id, 1)
                                }
                            }
                        }
                    }
                }
            })
        } else {
            var orders;
            var buffer_number_J = 1;
            var number_id;
            var id_value;
            var first_letter_id;
            $("input[type=checkbox]").change(function () {
                var number_id;
                var value = $(this).val();
                id_value = $(this).attr("id");
                var column_number = id_value.substr(3, 1);
                if (value != number_id && value < number_id && column_number == "M")buffer_number_J = number_id;
                first_letter_id_ant = first_letter_id;
                first_letter_id = id_value.substr(0, 2);
                number_id = id_value.substr(10, 2);
                if (column_number == 'M') {
                    cost(first_letter_id, "");
                    if ($("#" + id_value).is(':checked')) {
                        if (total <= 3003) {
                            delete_mutiplicator(first_letter_id);
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', true);
                            $("#L" + id_value).addClass("colorChecked");
                            if (first_letter_id == 'J1')number_multiplicator_J1 = value;
                            if (first_letter_id == 'J2')number_multiplicator_J2 = value;
                            cost(first_letter_id, "");
                            if (total > 3003) {
                                $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                $("#L" + id_value).removeClass("colorChecked");
                                if (first_letter_id == 'J1') {
                                    number_multiplicator_J1 = buffer_number_J;
                                    cost(first_letter_id, "")
                                }
                                if (first_letter_id == 'J2') {
                                    number_multiplicator_J2 = buffer_number_J;
                                    cost(first_letter_id, "")
                                }
                            }
                        }
                    } else {
                        if (total <= 3003) {
                            delete_mutiplicator(first_letter_id);
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                            $("#L" + id_value).removeClass("colorChecked");
                            if (first_letter_id == 'J1')number_multiplicator_J1 = 1;
                            if (first_letter_id == 'J2')number_multiplicator_J2 = 1;
                            cost(first_letter_id, "")
                        }
                    }
                } else {
                    if (value == 'O' || value == 'C' || value == 'D' || value == 'U') {
                        if ($("#" + id_value).is(':checked')) {
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', true);
                            $("#L" + id_value).addClass("colorChecked");
                            insert_Orders(first_letter_id, value);
                            cost(first_letter_id, "");
                            if (total > 3003) {
                                $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                $("#L" + id_value).removeClass("colorChecked");
                                delete_order(first_letter_id, value);
                                cost(first_letter_id, "")
                            }
                        } else {
                            $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                            $("#L" + id_value).removeClass("colorChecked");
                            delete_order(first_letter_id, value);
                            cost(first_letter_id, "")
                        }
                    } else {
                        if (value != 'O' && value != 'C' && value != 'D' && value != 'U') {
                            cost(first_letter_id, "");
                            if ($("#" + id_value).is(':checked')) {
                                if (count <= 21 || total <= 3003) {
                                    $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', true);
                                    array_number(number_id, first_letter_id, column_number);
                                    $("#L" + id_value).addClass("colorChecked");
                                    count = util(first_letter_id, 1);
                                    if (count > 21) {
                                        $("#L" + id_value).removeClass("colorChecked");
                                        $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                        delete_array_number(number_id, first_letter_id, column_number);
                                        count = util(first_letter_id, 1)
                                    }
                                }
                                if (total > 3003) {
                                    $("#L" + id_value).removeClass("colorChecked");
                                    $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                    delete_array_number(number_id, first_letter_id, column_number);
                                    count = util(first_letter_id, 1)
                                }
                            } else {
                                $("#" + first_letter_id + "_" + column_number + "check_" + number_id).prop('checked', false);
                                delete_array_number(number_id, first_letter_id, column_number);
                                $("#L" + id_value).removeClass("colorChecked");
                                count = util(first_letter_id, 1)
                            }
                        }
                    }
                }
            })
        }
    }
    var counter = 0;
    var countJ1 = 0;
    var countJ2 = 0;
    var buffer_number1 = [];
    var buffer_number2 = [];
    var value_numbersJ1 = [];
    var value_numbersJ2 = [];
    var value_numberJ1_1 = [];
    var value_numberJ1_2 = [];
    var value_numberJ1_3 = [];
    var value_numberJ2_1 = [];
    var value_numberJ2_2 = [];
    var value_numberJ2_3 = [];
    var value_letter_orders_J1 = [];
    var value_letter_orders_J2 = [];
    var sw1 = 0;
    var sw2 = 0;
    
    function disabled_game() {
        $('.left').addClass('opacity');
        $('.right').addClass('opacity');       
        $('.selectBox').addClass('opacity');
        $('.font').addClass('opacity');
    }
    function delete_mutiplicator(first_letter_id) {
        if (first_letter_id == 'J1')number_multiplicator_J1 = 1;
        if (first_letter_id == 'J2')number_multiplicator_J2 = 1;
        $("#" + first_letter_id + "_Mcheck_2").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_2").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_3").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_3").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_4").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_4").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_5").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_5").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_6").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_6").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_10").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_10").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_20").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_20").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_30").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_30").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_40").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_40").removeClass("colorChecked");
        $("#" + first_letter_id + "_Mcheck_50").prop('checked', false);
        $("#L" + first_letter_id + "_Mcheck_50").removeClass("colorChecked")
    }

    function insert_Orders(first_letter_id, column_number) {
        if (first_letter_id == 'J1') {
            if (column_number == 'O') {
                value_letter_orders_J1.push(column_number)
            }
            if (column_number == 'C') {
                value_letter_orders_J1.push(column_number)
            }
            if (column_number == 'D') {
                value_letter_orders_J1.push(column_number)
            }
            if (column_number == 'U') {
                value_letter_orders_J1.push(column_number)
            }
        }
        if (first_letter_id == 'J2') {
            if (column_number == 'O') {
                value_letter_orders_J2.push(column_number)
            }
            if (column_number == 'C') {
                value_letter_orders_J2.push(column_number)
            }
            if (column_number == 'D') {
                value_letter_orders_J2.push(column_number)
            }
            if (column_number == 'U') {
                value_letter_orders_J2.push(column_number)
            }
        }
    }

    function delete_order(first_letter_id, column_number) {
        if (first_letter_id == 'J1') {
            var size = value_letter_orders_J1.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_letter_orders_J1[ini] == column_number) {
                    value_letter_orders_J1.splice(ini, 1)
                }
            }
        }
        if (first_letter_id == 'J2') {
            var size = value_letter_orders_J2.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_letter_orders_J2[ini] == column_number) {
                    value_letter_orders_J2.splice(ini, 1)
                }
            }
        }
    }

    function util(play, how_marca) {
        switch (play) {
            case"J1":
                if (how_marca == 1) {
                    countJ1 = buffer_number1.length
                }
                return countJ1;
                break;
            case"J2":
                if (how_marca == 1) {
                    countJ2 = buffer_number2.length
                }
                return countJ2;
                break;
            default:
                return false
        }
    }

    var sorteos = $("#mySelectBox").val();
    $("#mySelectBox").on("change", function () {
        sorteos = $(this).val();
        cost("", "")
    });
    var totalJ1 = 0;
    var totalJ2 = 0;
    var total = 0;
    var totalcostJ1 = 0;
    var totalcostJ2 = 0;
    var totalcost = 0;

    function cost(first_letter_id, value_number) {
        if (first_letter_id == "J1") {
            totalJ1 = (buffer_number1.length) * (value_letter_orders_J1.length) * number_multiplicator_J1
        }
        if (first_letter_id == "J2") {
            totalJ2 = (buffer_number2.length) * (value_letter_orders_J2.length) * number_multiplicator_J2
        }
        total = totalJ1 + totalJ2;
        costoTotalBet = sorteos * total * parseFloat(costo);
        $('#comb').html(floatFormat(total));
        $('#total_apagar').html(floatFormat(costoTotalBet))
    }

    function show(first_letter_id, value_number) {
        cost(first_letter_id, value_number);
        value_number.sort(function (a, b) {
            return b - a
        });
        value_number.reverse();
        $("#" + first_letter_id + "-text-area").val(value_number.join(', '))
    }

    function array_number(number_id, first_letter_id, column_number, game_type) {
        var prueba = [];
        if (first_letter_id == "J1") {
            if (column_number == '1') {
                if (counter > 1 && game_type != 'azar') {
                    clear_for_ini(first_letter_id)
                }
                value_numberJ1_1.push(number_id)
            }
            if (column_number == '2') {
                if (counter > 1 && game_type != 'azar') {
                    clear_for_ini(first_letter_id)
                }
                value_numberJ1_2.push(number_id)
            }
            if (column_number == '3') {
                if (counter > 1 && game_type != 'azar') {
                    clear_for_ini(first_letter_id)
                }
                value_numberJ1_3.push(number_id)
            }
            if (game_type == 'azar') {
                if (value_numberJ1_1.length == value_numberJ1_3.length) {
                    prueba = insert_number_azar(first_letter_id, value_numberJ1_1, value_numberJ1_2, value_numberJ1_3)
                }
            } else {
                prueba = combinatoria(first_letter_id, value_numberJ1_1, value_numberJ1_2, value_numberJ1_3)
            }
            if (prueba != null) {
                buffer_number1 = prueba;
                show(first_letter_id, buffer_number1)
            }
            count = util(first_letter_id, 1)
        }
        if (first_letter_id == "J2") {
            if (counter > 1 && game_type != 'azar') {
                clear_for_ini(first_letter_id)
            }
            if (column_number == '1') {
                value_numberJ2_1.push(number_id)
            }
            if (column_number == '2') {
                if (counter > 1 && game_type != 'azar') {
                    clear_for_ini(first_letter_id)
                }
                value_numberJ2_2.push(number_id)
            }
            if (column_number == '3') {
                if (counter > 1 && game_type != 'azar') {
                    clear_for_ini(first_letter_id)
                }
                value_numberJ2_3.push(number_id)
            }
            if (game_type == 'azar') {
                if (value_numberJ2_1.length == value_numberJ2_3.length) {
                    prueba = insert_number_azar(first_letter_id, value_numberJ2_1, value_numberJ2_2, value_numberJ2_3)
                }
            } else {
                prueba = combinatoria(first_letter_id, value_numberJ2_1, value_numberJ2_2, value_numberJ2_3)
            }
            if (prueba != null) {
                buffer_number2 = prueba;
                show(first_letter_id, buffer_number2)
            }
            count = util(first_letter_id, 1)
        }
    }

    function combinatoria(first_letter_id, value1, value2, value3) {
        var value_number = [];
        var value_numbersJ1 = [];
        var value_numbersJ2 = [];
        if (first_letter_id == 'J1') {
            sw1 = 0
        }
        if (first_letter_id == 'J2') {
            sw2 = 0
        }
        if (value3.length > 0 && value2.length > 0 && value1.length > 0) {
            for (c1 = 0; c1 <= 9; c1++) {
                for (c2 = 0; c2 <= 9; c2++) {
                    for (c3 = 0; c3 <= 9; c3++) {
                        if (value1[c1] != null && value2[c2] != null && value3[c3] != null) {
                            if (first_letter_id == 'J1') {
                                value_numbersJ1.push(value1[c1] + value2[c2] + value3[c3]);
                                value_number = value_numbersJ1
                            }
                            if (first_letter_id == 'J2') {
                                value_numbersJ2.push(value1[c1] + value2[c2] + value3[c3]);
                                value_number = value_numbersJ2
                            }
                        }
                    }
                }
            }
            return duplicate(value_number)
        }
    }

    function duplicate(accumulator) {
        var i, len = accumulator.length, out = [], obj = {};
        for (i = 0; i < len; i++) {
            obj[accumulator[i]] = 0
        }
        for (i in obj) {
            out.push(i)
        }
        return out
    }

    function delete_array_number(number_id, first_letter_id, column_number) {
        var prueba = [];
        if (first_letter_id == "J1") {
            var size = value_numbersJ1.length;
            for (ini = 0; ini <= size; ini++) {
                value_numbersJ1.splice(ini, 1)
            }
            if (column_number == '1') {
                var size = value_numberJ1_1.length;
                for (ini = 0; ini <= size; ini++) {
                    if (value_numberJ1_1[ini] == number_id) {
                        value_numberJ1_1.splice(ini, 1)
                    }
                }
            }
            if (column_number == '2') {
                var size = value_numberJ1_2.length;
                for (ini = 0; ini <= size; ini++) {
                    if (value_numberJ1_2[ini] == number_id) {
                        value_numberJ1_2.splice(ini, 1)
                    }
                }
            }
            if (column_number == '3') {
                var size = value_numberJ1_3.length;
                for (ini = 0; ini <= size; ini++) {
                    if (value_numberJ1_3[ini] == number_id) {
                        value_numberJ1_3.splice(ini, 1)
                    }
                }
            }
            prueba = combinatoria(first_letter_id, value_numberJ1_1, value_numberJ1_2, value_numberJ1_3);
            if (prueba != null) {
                buffer_number1 = prueba;
                show(first_letter_id, prueba)
            }
            if (prueba == null) {
                prueba = [];
                buffer_number1 = prueba;
                show(first_letter_id, prueba)
            }
        }
        if (first_letter_id == "J2") {
            if (column_number == '1') {
                var size = value_numberJ2_1.length;
                for (ini = 0; ini <= size; ini++) {
                    if (value_numberJ2_1[ini] == number_id) {
                        value_numberJ2_1.splice(ini, 1)
                    }
                }
            }
            if (column_number == '2') {
                var size = value_numberJ2_2.length;
                for (ini = 0; ini <= size; ini++) {
                    if (value_numberJ2_2[ini] == number_id) {
                        value_numberJ2_2.splice(ini, 1)
                    }
                }
            }
            if (column_number == '3') {
                var size = value_numberJ2_3.length;
                for (ini = 0; ini <= size; ini++) {
                    if (value_numberJ2_3[ini] == number_id) {
                        value_numberJ2_3.splice(ini, 1)
                    }
                }
            }
            prueba = combinatoria(first_letter_id, value_numberJ2_1, value_numberJ2_2, value_numberJ2_3);
            if (prueba != null) {
                buffer_number2 = prueba;
                show(first_letter_id, prueba)
            }
            if (prueba == null) {
                prueba = [];
                buffer_number2 = prueba;
                show(first_letter_id, prueba)
            }
        }
    }

    $(".clear").click(function () {
        if (status == "ACT") {
            var first_letter_id = $(this).attr("id").substr(0,2);
            if (first_letter_id == "J1") {
                delete_mutiplicator(first_letter_id);
                var size = value_letter_orders_J1.length;
                for (ini = 0; ini <= size; ini++) {
                    value_letter_orders_J1.splice(ini, 1);
                    $("#" + first_letter_id + "_Ocheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Ocheck_1").removeClass("colorChecked");
                    $("#" + first_letter_id + "_Ccheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Ccheck_1").removeClass("colorChecked");
                    $("#" + first_letter_id + "_Dcheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Dcheck_1").removeClass("colorChecked");
                    $("#" + first_letter_id + "_Ucheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Ucheck_1").removeClass("colorChecked")
                }
                for (a = 0; a <= 21; a++) {
                    buffer_number1.splice(0, 1)
                }
                for (a = 0; a <= 21; a++) {
                    value_numbersJ1.splice(0, 1)
                }
                for (q = 0; q <= 9; q++) {
                    $("#" + first_letter_id + "_1check_" + q).prop('checked', false);
                    $("#L" + first_letter_id + "_1check_" + q).removeClass("colorChecked");
                    $("#" + first_letter_id + "_2check_" + q).prop('checked', false);
                    $("#L" + first_letter_id + "_2check_" + q).removeClass("colorChecked");
                    $("#" + first_letter_id + "_3check_" + q).prop('checked', false);
                    $("#L" + first_letter_id + "_3check_" + q).removeClass("colorChecked");
                    value_numberJ1_1.splice(0, 1);
                    value_numberJ1_2.splice(0, 1);
                    value_numberJ1_3.splice(0, 1)
                }
                show(first_letter_id, value_numbersJ1);
                sw1 = 0;
                counter = buffer_number1.length;
                count = util(first_letter_id, 1)
            }
            if (first_letter_id == "J2") {
                delete_mutiplicator(first_letter_id);
                var size = value_letter_orders_J2.length;
                for (ini = 0; ini <= size; ini++) {
                    value_letter_orders_J2.splice(ini, 1);
                    $("#" + first_letter_id + "_Ocheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Ocheck_1").removeClass("colorChecked");
                    $("#" + first_letter_id + "_Ccheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Ccheck_1").removeClass("colorChecked");
                    $("#" + first_letter_id + "_Dcheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Dcheck_1").removeClass("colorChecked");
                    $("#" + first_letter_id + "_Ucheck_1").prop('checked', false);
                    $("#L" + first_letter_id + "_Ucheck_1").removeClass("colorChecked")
                }
                for (a = 0; a <= 21; a++) {
                    buffer_number2.splice(0, 1)
                }
                for (a = 0; a <= 21; a++) {
                    value_numbersJ2.splice(0, 1)
                }
                for (w = 0; w <= 9; w++) {
                    $("#" + first_letter_id + "_1check_" + w).prop('checked', false);
                    $("#L" + first_letter_id + "_1check_" + w).removeClass("colorChecked");
                    $("#" + first_letter_id + "_2check_" + w).prop('checked', false);
                    $("#L" + first_letter_id + "_2check_" + w).removeClass("colorChecked");
                    $("#" + first_letter_id + "_3check_" + w).prop('checked', false);
                    $("#L" + first_letter_id + "_3check_" + w).removeClass("colorChecked");
                    value_numberJ2_1.splice(0, 1);
                    value_numberJ2_2.splice(0, 1);
                    value_numberJ2_3.splice(0, 1)
                }
                show(first_letter_id, value_numbersJ2);
                sw2 = 0;
                counter = buffer_number2.length;
                count = util(first_letter_id, 1)
            }
        }
    });
    function insert_number_azar(first_letter_id, value1, value2, value3) {
        var value_number = [];
        var value_numbersJ1 = [];
        var value_numbersJ2 = [];
        if (value3.length > 0 && value2.length > 0 && value1.length > 0) {
            for (r = 0; r <= 9; r++) {
                if (value1[r] != null && value2[r] != null && value3[r] != null) {
                    if (first_letter_id == 'J1') {
                        value_numbersJ1.push(value1[r] + value2[r] + value3[r]);
                        value_number = value_numbersJ1
                    }
                    if (first_letter_id == 'J2') {
                        value_numbersJ2.push(value1[r] + value2[r] + value3[r]);
                        value_number = value_numbersJ2
                    }
                }
            }
            return duplicate(value_number)
        }
    }

    var buffer_sw = [];
    $(".azar").click(function () {
        if (status == "ACT") {
            var first_letter_id = $(this).attr("id").substr(0,2);
            if (first_letter_id == "J1" && sw1 == 0) {
                clear_for_ini(first_letter_id);
                counter = 0
            }
            if (first_letter_id == "J2" && sw2 == 0) {
                clear_for_ini(first_letter_id)
            }
            if (counter <= 6) {
                for (ini = 1; ini <= 3; ini++) {
                    var number_azar = Math.round(1 + (Math.random() * (9 - 1)));
                    if (counter == 0) {
                        $("#" + first_letter_id + "_" + ini + "check_" + number_azar).prop('checked', true);
                        $("#L" + first_letter_id + "_" + ini + "check_" + number_azar).addClass("colorChecked")
                    }
                    if (counter == 1) {
                        if (first_letter_id == "J1") {
                            for (i = 0; i <= 9; i++) {
                                $("#" + first_letter_id + "_1check_" + value_numberJ1_1[i]).prop('checked', false);
                                $("#L" + first_letter_id + "_1check_" + value_numberJ1_1[i]).removeClass("colorChecked");
                                $("#" + first_letter_id + "_2check_" + value_numberJ1_2[i]).prop('checked', false);
                                $("#L" + first_letter_id + "_2check_" + value_numberJ1_2[i]).removeClass("colorChecked");
                                $("#" + first_letter_id + "_3check_" + value_numberJ1_3[i]).prop('checked', false);
                                $("#L" + first_letter_id + "_3check_" + value_numberJ1_3[i]).removeClass("colorChecked")
                            }
                        }
                        if (first_letter_id == "J2") {
                            for (i = 0; i <= 9; i++) {
                                $("#" + first_letter_id + "_1check_" + value_numberJ2_1[i]).prop('checked', false);
                                $("#L" + first_letter_id + "_1check_" + value_numberJ2_1[i]).removeClass("colorChecked");
                                $("#" + first_letter_id + "_2check_" + value_numberJ2_2[i]).prop('checked', false);
                                $("#L" + first_letter_id + "_2check_" + value_numberJ2_2[i]).removeClass("colorChecked");
                                $("#" + first_letter_id + "_3check_" + value_numberJ2_3[i]).prop('checked', false);
                                $("#L" + first_letter_id + "_3check_" + value_numberJ2_3[i]).removeClass("colorChecked")
                            }
                        }
                    }
                    if (first_letter_id == "J1") {
                        sw1 = 1;
                        array_number(number_azar.toString(), first_letter_id, ini, 'azar');
                        if (ini == 3)counter = buffer_number1.length
                    }
                    if (first_letter_id == "J2") {
                        sw2 = 1;
                        array_number(number_azar.toString(), first_letter_id, ini, 'azar');
                        if (ini == 3)counter = buffer_number2.length
                    }
                    if (counter == 7) {
                        if (first_letter_id == 'J1') {
                            sw1 = 0;
                            clear_for_ini(first_letter_id);
                            for (j = 1; j <= 3; j++) {
                                var number_azar = Math.round(1 + (Math.random() * (9 - 1)));
                                $("#" + first_letter_id + "_" + j + "check_" + number_azar).prop('checked', true);
                                $("#L" + first_letter_id + "_" + j + "check_" + number_azar).addClass("colorChecked");
                                array_number(number_azar.toString(), first_letter_id, j.toString(), 'azar')
                            }
                        }
                        if (first_letter_id == 'J2') {
                            sw2 = 0;
                            clear_for_ini(first_letter_id);
                            for (n = 1; n <= 3; n++) {
                                var number_azar = Math.round(1 + (Math.random() * (9 - 1)));
                                $("#" + first_letter_id + "_" + n + "check_" + number_azar).prop('checked', true);
                                $("#L" + first_letter_id + "_" + n + "check_" + number_azar).addClass("colorChecked");
                                array_number(number_azar.toString(), first_letter_id, n.toString(), 'azar')
                            }
                        }
                        counter = 0
                    }
                }
            }
        }
    });
    function clear_for_ini(first_letter_id) {
        if (first_letter_id == "J1") {
            var p = buffer_number1.length;
            for (a = 0; a <= p; a++) {
                buffer_number1.splice(0, 1)
            }
            var u = value_numbersJ1.length;
            for (a = 0; a <= u; a++) {
                value_numbersJ1.splice(0, 1)
            }
            counter = buffer_number1.length;
            for (m = 0; m <= 9; m++) {
                $("#" + first_letter_id + "_1check_" + m).prop('checked', false);
                $("#L" + first_letter_id + "_1check_" + m).removeClass("colorChecked");
                $("#" + first_letter_id + "_2check_" + m).prop('checked', false);
                $("#L" + first_letter_id + "_2check_" + m).removeClass("colorChecked");
                $("#" + first_letter_id + "_3check_" + m).prop('checked', false);
                $("#L" + first_letter_id + "_3check_" + m).removeClass("colorChecked");
                value_numberJ1_1.splice(0, 1);
                value_numberJ1_2.splice(0, 1);
                value_numberJ1_3.splice(0, 1)
            }
            show(first_letter_id, value_numbersJ1);
            count = util(first_letter_id, 1)
        }
        if (first_letter_id == "J2") {
            var t = buffer_number2.length;
            for (a = 0; a <= t; a++) {
                buffer_number2.splice(0, 1)
            }
            var f = value_numbersJ2.length;
            for (a = 0; a <= f; a++) {
                value_numbersJ2.splice(0, 1)
            }
            for (k = 0; k <= 9; k++) {
                $("#" + first_letter_id + "_1check_" + k).prop('checked', false);
                $("#L" + first_letter_id + "_1check_" + k).removeClass("colorChecked");
                $("#" + first_letter_id + "_2check_" + k).prop('checked', false);
                $("#L" + first_letter_id + "_2check_" + k).removeClass("colorChecked");
                $("#" + first_letter_id + "_3check_" + k).prop('checked', false);
                $("#L" + first_letter_id + "_3check_" + k).removeClass("colorChecked");
                value_numberJ2_1.splice(0, 1);
                value_numberJ2_2.splice(0, 1);
                value_numberJ2_3.splice(0, 1)
            }
            show(first_letter_id, value_numbersJ2);
            counter = buffer_number2.length;
            count = util(first_letter_id, 1)
        }
    }

    $('.more').click(function () {
        if (status == "ACT") {
            sw1 = 0;
            counter = 0;
            var more = [];
            var first_letter_id = $(this).attr("id").substr(0,2);
            var more2;
            more2 = $("#more_repeated").val();
            more = more2.split("");
            clear_for_ini(first_letter_id);
            var size = more.length;
            for (i = 1; i <= size; i++) {
                $("#" + first_letter_id + "_" + i + "check_" + more[i - 1]).prop('checked', true);
                $("#L" + first_letter_id + "_" + i + "check_" + more[i - 1]).addClass("colorChecked");
                array_number(more[i - 1], first_letter_id, i.toString(), 'azar')
            }
            count = util(first_letter_id, 1)
        }
    });
    $('.less').click(function () {
        if (status == "ACT") {
            sw2 = 0;
            counter = 0;
            var less = [];
            var first_letter_id = $(this).attr("id").substr(0,2);
            var less2;
            less2 = $("#less_repeated").val();
            less = less2.split("");
            var size = less.length;
            clear_for_ini(first_letter_id);
            for (i = 1; i <= size; i++) {
                $("#" + first_letter_id + "_" + i + "check_" + less[i - 1]).prop('checked', true);
                $("#L" + first_letter_id + "_" + i + "check_" + less[i - 1]).addClass("colorChecked");
                array_number(less[i - 1], first_letter_id, i.toString(), 'azar')
            }
            count = util(first_letter_id, 1)
        }
    });
    $('#buy').on('click', function () {
        if(status=='ACT'){ 
        if (((buffer_number1.length != 0 && value_letter_orders_J1.length != 0) && (buffer_number2.length == 0 && value_letter_orders_J2.length == 0)) || ((buffer_number2.length != 0 && value_letter_orders_J2.length != 0) && (buffer_number1.length == 0 && value_letter_orders_J1.length == 0)) || ((buffer_number2.length != 0 && value_letter_orders_J2.length != 0) && (buffer_number1.length != 0 && value_letter_orders_J1.length != 0))) {
            $("#noteSuper3").hide(); 
        	process_buy()
        } else {
            jAlert('Elige correctamente tu apuesta.',null); 
        }
       }
    });
    $('#more_plays').on('click', function () {
        buffer_number1 = [];
        buffer_number2 = [];
        value_numbersJ1 = [];
        value_numbersJ2 = [];
        value_numberJ1_1 = [];
        value_numberJ1_2 = [];
        value_numberJ1_3 = [];
        value_numberJ2_1 = [];
        value_numberJ2_2 = [];
        value_numberJ2_3 = [];
        value_letter_orders_J1 = [];
        value_letter_orders_J2 = [];
        sw1 = 0;
        sw2 = 0;
        $('.clear').click();
        $('#transition').removeClass().addClass('transition-one');
        $('.finalize-purchase').hide();
        $('#start_play').show();
        $('.selectBox').html(combo_draws);
        $('#total_apagar').html('0');
        costoTotalBet = 0
    });
    $('.left-panel').on('click', '.process-delete1', function () {
        var row = parseInt($(this).attr("rel"));
        object_ticket.splice(row, 1);
        tickets_grid(object_ticket);
        paged_grid(object_ticket);
        calculate_total_cost(object_ticket);
        if(object_ticket.length==0){
            $('#more_plays').click();
        }
    });
    $('.left-panel').on('mouseover', '.row-info',function () {
        var row = $(this).attr('rel');
        row = parseInt(row);
        var content_info = '';
        var nom_jugadas = ['<b>A</b>', '<b>B</b>'];
        for (var i = 0; i < 2; i++) {
            if (trim(object_ticket[row][i]) != 'null') {
                var result_ticket = '';
                result_ticket += object_ticket[row][i];
                content_info += nom_jugadas[i] + ': ' + result_ticket + '<br>'
            }
        }
        $('.tooltip-info').eq(row).html(content_info).show();
        $('.tooltip-info-arrow-img').eq(row).show()
    }).on('mouseout', '.row-info', function () {
        var row = $(this).attr('rel');
        $('.tooltip-info').eq(row).hide();
        $('.tooltip-info-arrow-img').eq(row).hide()
    });
    $('.left-panel').on('mouseover', '.no-process',function () {
        var contenido_total = $(this).attr('rel');
        var contenido_temp = (contenido_total + '').split('#');
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1] + '';
        $('.tooltip-no-process').eq(posicion).html(mensaje).show();
        $('.tooltip-no-process-arrow-img').eq(posicion).show()
    }).on('mouseout', '.no-process', function () {
        var contenido_total = $(this).attr('rel');
        var contenido_temp = contenido_total.split('#');
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1];
        $('.tooltip-no-process').eq(posicion).html(mensaje).hide();
        $('.tooltip-no-process-arrow-img').eq(posicion).hide()
    });
    $('.left-panel').on('click', '.lnk-pag1', function () {
        var cadena_pos = $(this).attr('rel');
        var id = $(this).attr('id');
        var posiciones = cadena_pos.split('-');
        $('.row_grid').removeClass('row_null').addClass('row_null');
        for (var num in posiciones) {
            $('.row_grid').eq(posiciones[num]).removeClass('row_null')
        }
        $('.indice_page').html($('#' + id).html());
        $('.lnk').removeClass('num_page_off').addClass('num_page_on');
        $('#' + $(this).attr('id')).removeClass('num_page_on').addClass('num_page_off')
    });
    $('.left-panel').on('click', '.lnk-pag2', function () {
        var cadena_pos = $(this).attr('rel');
        var id = $(this).attr('id');
        var posiciones = cadena_pos.split('-');
        $('.row_grid').removeClass('row_null').addClass('row_null')
        for (var num in posiciones) {
            $('.row_grid').eq(posiciones[num]).removeClass('row_null')
        }
        $('.indice_page').html($('#' + id).html());
        $('.lnk').removeClass('num_page_off').addClass('num_page_on');
        $('#' + $(this).attr('id')).removeClass('num_page_on').addClass('num_page_off')
    });
    $('.label_2').html(fecha_actual());
    /*$('#frmLoginClientPuchase').on('submit', function (event) {
        var user = $('#user-client').val();
        var pass = $('#password-client').val();
        var valida_session = "", _id = $(this).attr("id");
        event.preventDefault();
        if (user == '' || pass == '') {
            jAlert('Complete los datos de usuario')
        } else {
            $.ajax({type: $(this).attr('method'), url: $(this).attr('action'), dataType: 'text', data: $(this).serialize(), success: function (e) {
            	//$('#password-client').val('');
                var arrresp = $.trim(e).split("|");
                valida_session = arrresp[0];
                if (valida_session == 'OK' || valida_session === 'TC') {
                    var username = arrresp[1];
                    var useramount = arrresp[2];
                    var userid = arrresp[3];
                    var monto1 = floatFormat(arrresp[4]);
                    var monto2 = floatFormat(arrresp[5]);
                    
                    var nombrejs = arrresp[7];
                    var apPaternojs = arrresp[8];
                    var apMaternojs = arrresp[9];
                    var mailjs = arrresp[10];
                    var mobilePhonejs = arrresp[11];
                    var countryjs = arrresp[12];
                    var regionjs = arrresp[13];
                    var addressjs = arrresp[14];
                    var typeIdjs = arrresp[15];
                    var numberIdjs = arrresp[16];
                    var controlAmountjs = arrresp[17];
                    var emailjs = arrresp[18];
                    var sessionjs = arrresp[20];
                    
                    $('#field-balance-amount').text(monto1);
                    if (monto2 == '0.00') {
                        $('.saldo_promocional').html('')
                    } else {
                        $('.saldo_promocional').html('&oacute; de mi saldo promocional S/.' + monto2)
                    }
                    $('#clientId').val(userid);
                    $('#clientSale-name').text(username);
                    $('#clientSale-amount').text(floatFormat(useramount));
                    $('#user-ico').addClass(arrresp[6]);
                    
                    $("#nombre").val(nombrejs);
                    $("#apPaterno").val(apPaternojs);
                    $("#apMaterno").val(apMaternojs);
                    $("#mail").val(mailjs);
                    $("#phone").val(mobilePhonejs);
                    $("#country").val(countryjs);
                    $("#city").val(regionjs);
                    $("#addres").val(addressjs);
                    $("#typeId").val(typeIdjs);
                    $("#numberId").val(numberIdjs);
                    $("#amount").val(controlAmountjs);
                    $("#email").val(arrresp[18]);
                    $("#sesionId").val(sessionjs);
                    if(valida_session === 'TC') exe.opentyc(_id);//"#home-btnlogin");
                    else viewNext();
                } else if(valida_session === 'CC'){
                    jAlert(arrresp[1], null);
                    $('#user-client').focus();
                    setCaptcha(true);
                } else {
                    jAlert(valida_session, null);
                    $('#user-client').focus();
                }
            }})
        }
    });*/
    $('#frmLoginClientIndex').attr('id', 'frmLoginClientSuper3').attr('action', 'login_super3.html');
    $('#frmLoginClientSuper3').on('submit', function (event) {
        event.preventDefault();
        var valida_session = "", _id = $(this).attr("id");
        $.ajax({type: $(this).attr('method'), url: $(this).attr('action'), dataType: $(this).data('responseType'), data: $(this).serialize(), success: function (e) {
        	//$('#password-client-header').val('');
            var arrresp = $.trim(e).split('|');
            valida_session = arrresp[0];
            if (valida_session === 'OK' || valida_session === 'TC' || valida_session === 'MV' ) {
                var username = arrresp[1];
                var useramount = arrresp[2];
                var userid = arrresp[3];
                var monto1 = floatFormat(arrresp[4]);
                var monto2 = floatFormat(arrresp[5]);
                $('#field-balance-amount').text(monto1);
                if (monto2 == '0.00') {
                    $('.saldo_promocional').html('')
                } else {
                    $('.saldo_promocional').html('&oacute; de mi saldo promocional S/.' + monto2)
                }
                $('#clientId').val(userid);
                $('#clientSale-name').text(username);
                $('#clientSale-amount').text(floatFormat(useramount));
                $('#user-ico').addClass(arrresp[6]);
                /*
                if(valida_session === 'MV') {
                	jAlert(arrresp[1], null);
                	$('#user-client-header').focus();
                    setCaptcha(true);
                }
                */
                if(valida_session === 'TC') exe.opentyc(_id);//"#index-btnlogin");
                else viewNext();
                /*$('.logout').show();
                $('.unlogout').hide();
                $('#payments_section').show();
				$('.img_zona_segura').css({"margin-top":"0px"});
                $('#login_section').hide();
                $('#panel_finaliza_compra').show();*/
            } else if(valida_session === 'CC' ){
                jAlert(arrresp[1], null);
                $('#user-client-header').focus();
                setCaptcha(true);
            } else {
                jAlert(valida_session, null);
                $('#user-client-header').focus();
            }
        }})
    });
    $('#btn_finaliza_compra').on('click', function () {
        var option = $('[name=option-card]:checked').val();
        var pin = $('[name=pin-number]').val();
        var message = '';
        var amount = 0.0;
        var newamount = 0.0;
        var msgres = [];
        if (option == 0) {
            message = 'OK'
        } 
        message = message.replace(/_/g, ' ');
        if (message == 'OK') {
            if (object_ticket.length != 0) {
                var content_grid_2 = "<div class='label-top'></div>" + "<div class='label_1'>SUPER 3</div>" + "<div id='ajax-loader'>" + "<img src='layer-view-image/game/super3/ajax-loader.gif'>" + "</div><div id='content-grid-result'></div>" + "<div id='num_link'></div>";
                content_grid_2 += "<div id='game-no-process-info'></div>";
                $('.left-panel').html(content_grid_2);
                $('#panel_more_plays').hide();
                $('#panel_finaliza_compra').hide();
                $('#panel_keep-playing').show();
                $('#panel_game-history').show();
                $('#ico-block').show();
                $('.label-top').show();
                $('#sub_panel').hide();
                var row_ticket = '';
                var ticketsAjax = '';
                for (var m = 0; m < object_ticket.length; m++) {
                    object_ticket[m][2] = 'null'
                }
                for (var n = 0; n < object_ticket.length; n++) {
                    row_ticket = (object_ticket[n]).toString().replace(/,/g, "|");
                    ticketsAjax += row_ticket + '-';
                    row_ticket = ''
                }
                ticketsAjax = ticketsAjax.substr(0, ticketsAjax.length - 1);
                $('#ajax-loader').show();
                var contador = 0;
                $.ajax({type: 'POST', url: 'ajaxJugadasSuper3.html', dataType: 'text', data: 'dato=' + ticketsAjax, success: function (e) {
                    var row = (e.toString()).split('#');
                    for (var i = 0; i < row.length; i++) {
                        var items = (row[i] + '').split('|');
                        var new_row_ticket = [];
                        for (var j = 0; j < items.length; j++) {
                            new_row_ticket.push(items[j])
                        }
                        new_object_ticket.push(new_row_ticket)
                    }
                    $('.label_resu3').html('<b>Saldo Disponible: S/. </b>' + floatFormat(new_object_ticket[(new_object_ticket.length - 1)][8]));
                    var promotional_balance=parseFloat(new_object_ticket[(new_object_ticket.length-1)][9]);
                    if(promotional_balance>0){
                        $(".label_resu4").html("<b>Saldo Promocional: S/. </b>"+floatFormat(new_object_ticket[(new_object_ticket.length-1)][9]));                    
                    } 
                    $('#clientSale-amount').text(floatFormat(new_object_ticket[(new_object_ticket.length - 1)][8]));
                    $('#ajax-loader').css('display', 'none');
                    tickets_grid2(new_object_ticket);
                    paged_grid2(new_object_ticket);
                    var costo_total = 0;
                    for (var t in new_object_ticket) {
                        var procesos = (new_object_ticket[t][2] + '').split('&');
                        if (procesos[1] != 'null') {
                            $('.label-top').html('&#161;GRACIAS POR TU COMPRA!');
                            costo_total += parseFloat(new_object_ticket[t][4])
                            
                        }
                    }
                    
                    $('.result1').html('S/.' + floatFormat(costo_total));
                    $('.label_resu1').html('TOTAL PAGADO:')
                    $('#keep-playing').off('click');
                    $('#game-history').off('click');
                }})
            } else {
                jAlert('No se tiene jugadas por procesar', null)
            }
            if (option == 1)jAlert('Se ha realizado una recarga de saldo.\n\nMonto cargado: S/. ' + amount + '\nTu saldo es: S/. ' + newamount, null)
        } else {
            if (option == 1)jAlert('No se ha logrado realizar la recarga.\n' + message + '\n\nMonto cargado: S/. ' + amount + '\nTu saldo es: S/. ' + newamount, null)
        }
    });
    $('#option-card-0').on('click', function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    });
    $('#option-card-1').on('click', function () {
        $("#panel_transaccion_1").show();
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    });
    $("#option-card-2").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").show();
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    });
    $("#option-card-3").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").show();
        $("#panel_transaccion_4").css("display", "");
		$("#panel_transaccion_5").css("display", "");
    });
    $("#option-card-4").click(function () {
    	$("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_4").show();
		$("#panel_transaccion_5").css("display", "");
	})
	 $("#option-card-5").click(function () {
    	$("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "");
        $("#panel_transaccion_5").show();
		$("#panel_transaccion_4").css("display", "");
	})
	
	
	$("#pagoEfecHelp").click(function(e) {
	var pagoEfectivoHelp=$("#pagoEfectivoHelp").val();
    dhtmlwindow.open('resultbox', 'iframe',pagoEfectivoHelp, '¿Cómo funciona PagoEfectivo?', 'width=600,height=635px,scrolling=0,center=1,resize=0', 'recal');
    });
    
    /*
    $("#btncargar4").click(function(e) {
        var firstname=$("#nombre").val();
 	   var lastname=$("#apPaterno").val();
 	   var maidenname=$("#apMaterno").val();
 	   var email=$("#mail").val();
 	   var phone=$("#phone").val();
 	   var country=$("#country").val();
 	   var city=$("#city").val();
 	   var address=$("#addres").val();
 	   var typeId=$("#typeId").val();
 	   var numberid=$("#numberId").val();
 	   var posAmount=document.getElementById("pagoEfectivo-valor").value;
 	   var mail=$("#email").val();
 	   var clientId=$("#clientId").val();
 	   var sessionId=$("#sesionId").val();
 	   var mode=$("#mode").val();
 	   var typeidNum=0;
 						if(typeId=='DNI'){
 							typeidNum = 1;
 						}else{
 							if(typeId=='CAREX'){
 								typeidNum = 2;
 							}else{
 								if(typeId=='PASAP'){
 									typeidNum = 3;
 								}	
 							}
 						}
 						
 		$.ajax({
 						type:"post",
 						url:"portal_page.html",
 						data:"firstname="+firstname+"&lastname="+lastname+"&maidenname="+maidenname+"&email="+email+
 						"&phone="+phone+"&country="+country+"&city="+city+"&address="+address+
 						"&typeidNum="+typeidNum+"&numberid="+numberid+"&posAmount="+posAmount+
 						"&t="+mode+"&m="+mail+"&clientId="+clientId+"&sessionId="+sessionId,
 						dataType:"text",
 						global: false, 
 						async: false,
 						success:function(e){
 							if(e != null && e != ""){
 							var redireccion = (e+"").toString();
 							if(redireccion != null && redireccion != "")
 							{
 							pagoEfectivoF(redireccion);	}
 						//	callReportCurrentAccount();
 							}else{
 								jAlert( "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
 								}
 						}
 	
 					});
        
     });
    
	$("#btncargar5").click(function(e) {
		 var posAmount=document.getElementById("safetypay-valor").value;
		 var clientId=$("#clientId").val();
		 var sessionId=$("#sesionId").val();
		 
		 var apikey=$("#apikey").val();
		 var merchantSalesID=$("#merchantSalesID").val();
		 var transactionOkURL=$("#transactionOkURL").val();
		 var transactionErrorURL=$("#transactionErrorURL").val();
		 var signature=$("#signature").val();
		 var createExpressToken=$("#createExpressToken").val();
		 
		 
			$.ajax({
				type:"post",
				url:"safety_page_post.html",
				data:"clientId="+clientId+"&sessionId="+sessionId+"&posAmount="+posAmount+"&apikey="+apikey
				+"&merchantSalesID="+merchantSalesID+"&transactionOkURL="+transactionOkURL+"&transactionErrorURL="+transactionErrorURL
				+"&signature="+signature+"&createExpressToken="+createExpressToken,
				dataType:"text",
				global: false, 
				async: false,
				success:function(e){
					if(e != null && e != ""){
					var redireccion = (e+"").toString();
					if(redireccion != null && redireccion != "")
					{
						safetyPay(redireccion);
					}
					//pagoEfectivoF(redireccion);	}
				//	callReportCurrentAccount();
					}else{
						jAlert( "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
						}
				}

			});
			
			
	    });
		
		*/
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
	
	
    $('#keep-playing').on('click', function(event){
        event.preventDefault();            
     }); 
    $('#game-history').on('click',function(event){
        event.preventDefault();
    });
    var array_no_procesados = [];
    $('.left-panel').on('click', '#btn-no-process', function () {
        var contador = 0;
        for (var i in new_object_ticket) {
            var procesos = (new_object_ticket[i][2] + '').split('&');
            if (procesos[1] == 'null') {
                array_no_procesados.push(new_object_ticket[i]);
                contador++
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
        var temp_jugada_2 = "<span class='label_1'>SUPER 3</span>" + "<div id='content-grid-result'></div>" + "<div id='num_link'></div>";
        $('.left-panel').html(temp_jugada_2);
        if (status == 'ACT') {
            $('#start_play').hide();
            $('.finalize-purchase').show();
            var cant_sorteo = $('#mySelectBox').val();
            var precio = costoTotalBet;
            object_ticket = [];
            object_ticket = array_no_procesados;
            array_no_procesados = [];
            new_object_ticket = [];
            tickets_grid(object_ticket);
            paged_grid(object_ticket);
            $('.clear').click();
            var costo_total = 0;
            for (var i in object_ticket) {
                costo_total += parseFloat(object_ticket[i][4])
            }
            $('.result1').html('S/.' + floatFormat(costo_total));
            $('.result2').html('S/.' + parseFloat($('#simpleBetPrice_repeated').val()));
            $('.label_resu1').html('TOTAL A PAGAR:')
        }
    });
    var idsession = $('#clientId').val();
    if(idsession != '' && $("#agreement").val() == ''){
    	$('#login_section').show();
		$('.finalize-purchase').css({"min-height":"379px"});
		$('.img_zona_segura').css({"margin-top":"93px"});
    	exe.opentyc(null);
    } else if (idsession == '') {
        $('#login_section').show();
		$('.finalize-purchase').css({"min-height":"379px"});
		$('.img_zona_segura').css({"margin-top":"93px"});
    } else {
        $('#login_section').hide();
        $('#panel_finaliza_compra').show();
        $("#panel_finaliza_compra").show();
        $('#payments_section').show();
		$('.img_zona_segura').css({"margin-top":"0px"});
    }
    function process_buy() {
        if (status == 'ACT') {
            if (total <= 3003 && total >= 0) {
                var multiDraws = $('#mySelectBox').val();
                var row_ticket = [];
                var unArray = new Array(buffer_number1);
                var cadena_caracter_1 = new String(unArray);
                var unArray = new Array(value_letter_orders_J1);
                var cadena_buffer_number1 = new String(unArray);
                var unArray = new Array(buffer_number2);
                var cadena_caracter_2 = new String(unArray);
                var unArray = new Array(value_letter_orders_J2);
                var cadena_buffer_number2 = new String(unArray);
                cadena_caracter_1 = cadena_caracter_1.replace(/,/g, " ");
                cadena_caracter_2 = cadena_caracter_2.replace(/,/g, " ");
                cadena_buffer_number1 = cadena_buffer_number1.replace(/,/g, " ");
                cadena_buffer_number2 = cadena_buffer_number2.replace(/,/g, " ");
                if (cadena_caracter_1.length == 0) {
                    row_ticket.push('null');
                    row_ticket.push(cadena_caracter_2 + ' : ' + cadena_buffer_number2 + ' x ' + number_multiplicator_J2)
                } else if (cadena_caracter_2.length == 0) {
                    row_ticket.push(cadena_caracter_1 + ' : ' + cadena_buffer_number1 + ' x ' + number_multiplicator_J1);
                    row_ticket.push('null')
                } else {
                    row_ticket.push(cadena_caracter_1 + ' : ' + cadena_buffer_number1 + ' x ' + number_multiplicator_J1);
                    row_ticket.push(cadena_caracter_2 + ' : ' + cadena_buffer_number2 + ' x ' + number_multiplicator_J2)
                }
                
                var errorInData = false;
                if (cadena_buffer_number1.indexOf("C") >= 0) {
                    var bet1 = cadena_caracter_1.split(" ");
                    var size1 = bet1.length;
                    for (i = 0; i < size1; i++) {
                        var bet1_i = bet1[i];
                        if (bet1_i.charAt(0)==bet1_i.charAt(1) && bet1_i.charAt(1)==bet1_i.charAt(2) ) {
                        	errorInData = true;
                        }
                    }
                }
                if (cadena_buffer_number2.indexOf("C") >= 0) {
                    var bet2 = cadena_caracter_2.split(" ");
                    var size2 = bet2.length;
                    for (i = 0; i < size2; i++) {
                        var bet2_i = bet2[i];
                        if (bet2_i.charAt(0)==bet2_i.charAt(1) && bet2_i.charAt(1)==bet2_i.charAt(2) ) {
                        	errorInData = true;
                        }
                    }
                }
                if (errorInData == true) {
                	jAlert("Si deseas jugar 3 n&uacute;meros iguales debes marcar el tipo de apuesta '3 en orden'.<br/>Si aciertas podr&aacute;s ganar hasta 600 veces tu apuesta.");
                } else {
                    $('#transition').removeClass().addClass('transition-two');
                    $('#start_play').hide();
                    $('.finalize-purchase').show();
                    row_ticket.push('null');
                    row_ticket.push(multiDraws);
                    row_ticket.push(costoTotalBet);
                    object_ticket.push(row_ticket);
                    tickets_grid(object_ticket);
                    paged_grid(object_ticket);
                    calculate_total_cost(object_ticket);
                    $('.label_resu2').html($('#price-message').text());
                    $('#mySelectBox').val('1')
                }
                
            }
            if (total > 3003) {
                jAlert('El total de apuestas no debe ser mayor a 3003')
            }
        }
    }

    function trim(string) {
        for (i = 0; i < string.length;) {
            if (string.charAt(i) == " ") {
                string = string.substring(i + 1, string.length)
            } else {
                break
            }
        }
        for (i = string.length - 1; i >= 0; i = string.length - 1) {
            if (string.charAt(i) == " ") {
                string = string.substring(0, i)
            } else {
                break
            }
        }
        return string
    }

    function fecha_actual() {
        var f = new Date();
        var mes = "";
        var dia = "";
        var temp_mes = f.getMonth() + "";
        var temp_dia = f.getDate() + "";
        if (temp_mes.length == 1) {
            mes = "0" + (f.getMonth() + 1) + ""
        } else {
            mes = (f.getMonth() + 1) + ""
        }
        if (temp_dia.length == 1) {
            dia = "0" + f.getDate() + ""
        } else {
            dia = f.getDate() + ""
        }
        return dia + "/" + mes + "/" + f.getFullYear()
    }

    function paged_grid(data) {
        var count_rows = data.length;
        if (count_rows > 0) {
            var links = "";
            var cont = 0;
            var style = "";
            var posx = 0;
            var posy = 1;
            var posz = 2;
            for (var i = 0; i < count_rows; i++) {
                if (i == 0) {
                    style = "num_page_off"
                } else {
                    style = "num_page_on"
                }
                if (i % 3 == 0) {
                    cont++;
                    links += "&nbsp;<a class='lnk-pag1 lnk " + style + " ' id='" + posx + "-" + posy + "-" + posz + "' rel='" + posx + "-" + posy + "-" + posz + "' >" + cont + "</a>&nbsp;";
                    posx = posx + 3;
                    posy = posy + 3;
                    posz = posz + 3
                }
            }
            $('#num_link').html("<span class='indice_page'>1</span> de " + cont + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<" + links + ">")
        } else {
            $('#num_link').html('')
        }
    }

    function paged_grid2(data) {
        var count_rows = data.length;
        var links = "";
        var cont = 0;
        var style = "";
        var posx = 0;
        var posy = 1;
        var posz = 2;
        for (var i = 0; i < count_rows; i++) {
            if (i == 0) {
                style = "num_page_off"
            } else {
                style = "num_page_on"
            }
            if (i % 3 == 0) {
                cont++;
                links += "&nbsp;<a class='lnk-pag2 lnk " + style + " ' id='id" + posx + "_" + posy + "_" + posz + "i' rel='" + posx + "-" + posy + "-" + posz + "' >" + cont + "</a>&nbsp;";
                posx = posx + 3;
                posy = posy + 3;
                posz = posz + 3
            }
        }
        $('#num_link').html("<span class='indice_page'>1</span> de " + cont + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<" + links + ">")
    }

    function tickets_grid(data) {
        var nom_jugadas = ["<b>A</b>", "<b>B</b>"];
        var grilla = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>ANULAR</div>" + "</div>";
        for (var x in data) {
            for (var i = 0; i < 2; i++) {
                if (trim(data[x][i]) != 'null') {
                    var result_ticket = "";
                    result_ticket = nom_jugadas[i] + ": ";
                    result_ticket += data[x][i];
                    break
                }
            }
            var style = "row_grid";
            if (x % 2 != 0) {
                style += " row_grid_mouseover"
            }
            if (x > 2) {
                style += " row_null"
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + (parseInt(x) + 1) + "</div>" + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + "<div class='column_3'>" + "<div class='delete process-delete1' rel='" + x + "'></div>" + "</div>" + "</div>"
        }
        grilla += "</div>";
        $('#content-grid-result').html(grilla)
    }

    function tickets_grid2(data) {
        var nom_jugadas = ["<b>A</b>", "<b>B</b>"];
        var no_process_message_count = 0;
        var grilla = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>VER</div>" + "</div>";
        for (var x in data) {
            for (var i = 0; i < 2; i++) {
                if (trim(data[x][i]) != "null") {
                    var result_ticket = "";
                    result_ticket = nom_jugadas[i] + ": ";
                    result_ticket += data[x][i];
                    break
                }
            }
            var style = "row_grid";
            if (x % 2 != 0) {
                style += " row_grid_mouseover"
            }
            if (x > 2) {
                style += " row_null"
            }
            var dato_proceso = (data[x][2]).split("&");
            var process_resp = "";
            if (dato_proceso[1] == "null") {
                process_resp = "<div class='column3-no-process'>No procesado&nbsp;&nbsp;<span class='no-process' rel='" + no_process_message_count + "#" + dato_proceso[0] + "'>[?]</span> </div>";
                process_resp += "<div class='tooltip-no-process'></div><div class='tooltip-no-process-arrow-img'></div>";
                no_process_message_count++;
                var game_no_process_info = "<div class='title-text'><div><b>Jugadas no procesadas</b></div>" + "<div>Tienes apuestas que no se han podido procesar.</div></div>" + "<div id='no-process-section'><a href='#' class='buttom-go' id='btn-no-process' onclick='return false;'></a></div>";
                $("#game-no-process-info").html(game_no_process_info).show()
            } else {
                process_resp = "<div class='column3-codigo'>" + dato_proceso[1] + "</div><div class='column3-search' onclick='openPreviewWindow(" + data[x][7] + ",\"" + data[x][6] + "\",\"" + dato_proceso[1] + "\")'></div>"
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + data[x][5] + "</div>" + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + process_resp + "</div>"
        }
        grilla += "</div>";
        $('#content-grid-result').html(grilla)
    }

    function calculate_total_cost(dato) {
        var costo_total = 0;
        for (var i in dato) {
            costo_total += parseFloat(dato[i][4])
        }
        $(".result1").html("S/." + floatFormat(costo_total))
    }
    function viewNext(){
    	$('#password-client-header').val('');
    	$('#password-client').val('');
        $('.logout').show();
        $('.unlogout').hide();
        $('#payments_section').show();
		$('.img_zona_segura').css({"margin-top":"0px"});
        $('#login_section').hide();
        $('#btn_finaliza_compra').show();
        $('#panel_finaliza_compra').show();
    }
};
$($super3);

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