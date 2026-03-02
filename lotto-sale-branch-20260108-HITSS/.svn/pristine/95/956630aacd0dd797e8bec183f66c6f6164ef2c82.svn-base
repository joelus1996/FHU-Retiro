;
var $kabala= function () {
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
  //Plus+Chau Chamba
    var total_plus=0;
    var total_plusJ1=0;
    var total_plusJ2=0;
    var total_plusJ3=0;
    var total_plusJ4=0;
    var add_onsJ1='';
    var add_onsJ2='';
    var add_onsJ3='';
    var add_onsJ4='';
	
	var add_ChauCmb1=0;
    var add_ChauCmb2=0;
    var add_ChauCmb3=0;
    var add_ChauCmb4=0;   
		
    $('#J1-check-plus').prop("disabled",true);   
    $('#J2-check-plus').prop("disabled",true);   
    $('#J3-check-plus').prop("disabled",true);   
    $('#J4-check-plus').prop("disabled",true);   
	
	$('#J5-check-chauchamba').prop("disabled",true);
	$('#J6-check-chauchamba').prop("disabled",true);
	$('#J7-check-chauchamba').prop("disabled",true);
	$('#J8-check-chauchamba').prop("disabled",true);
	
    $("#menu-item-1").addClass("main-nav-list-item current-menu-item");
    $('#frmLoginClientIndex').attr('id', 'frmLoginClientKabala').attr('action', 'login_kabala.html');
    $("#frmLoginClientKabala").on('submit', function (event) {
        event.preventDefault();
        $.ajax({type: $(this).attr('method'), url: $(this).attr('action'), dataType: $(this).data('responseType'), data: $(this).serialize(), success: function (e) {
            var arrresp = $.trim(e).split("|");
            var valida_session = arrresp[0];
            if (valida_session === 'OK') {
                var username = arrresp[1];
                var useramount = arrresp[2];
                var userid = arrresp[3];
                var monto1 = floatFormat(arrresp[4]);
                var monto2 = floatFormat(arrresp[5]);
                $("#field-balanceAmount").html(monto1);
                if (monto2 == "0.00") {
                    $(".saldo_promocional").html('')
                } else {
                    $(".saldo_promocional").html("&oacute; de mi saldo promocional S/." + monto2)
                }
                $("#clientId").val(userid);
                $("#clientSale-name").html(username);
                $("#clientSale-amount").html(useramount);
                $(".logout").css("display", "");
                $(".unlogout").hide();
                $("#payments_section").show();
                $("#login_section").css("display", "");
                $("#panel_finaliza_compra").show()
            } else {
                jAlert(valida_session)
            }
        }})
    });
    

    var combo_fecha = $(".selectBox").html();
	var cant_fecha=$(".selectBoxCotejo").html();
	var tot_fechas=$(".cantFecha").html();
    /*var status = $("#status").val();*/
    var status = "ACT";
    $('.finalize-purchase').hide();
    $("#part2").hide();
    $(".flecha_back").hide();
    if (status == "ACT") {
        $('.flecha_next').click(function () {
            $("#part1").hide();
            $("#part2").show();
            $(".flecha_next").hide();
            $(".flecha_back").show();
            $(".play_go_3_4_gd").addClass("play_go_1_2_gd");
            $(".play_go_3_4_gd").removeClass("play_go_3_4_gd")
        });
        $('.flecha_back').click(function () {
            $("#part2").hide();
            $("#part1").show();
            $(".play_go_1_2_gd").addClass("play_go_3_4_gd");
            $('.flecha_back').addClass("flecha_next");
            $(".flecha_next").show();
            $(".flecha_back").hide()
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
                    combinatoria()
                } else {
                    if (count <= 15) {
                        count = util(first_letter_id, 1);
                        if (sub_total <= 6006) {
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', true);
                            array_number(number_id, first_letter_id);
                            $("#L" + id_value).addClass("colorChecked");
                            combinatoria()
                        }
                        if (count > 15 || sub_total > 6006) {
                            $("#L" + id_value).removeClass("colorChecked");
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                            count = util(first_letter_id, 2);
                            delete_array_number(number_id, first_letter_id);
                            combinatoria()
                        }
                    }
                }
            })
        } else {
            $("input[name=check]").on('change', function () {
                var id_value = $(this).attr("id");
                var first_letter_id = id_value.substr(0, 2);
                var number_id = id_value.substr(8, 2);
                if ($("#" + id_value).is(':checked')) {
                    if (count <= 15) {
                        count = util(first_letter_id, 1);
                        if (sub_total <= 6006) {
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', true);
                            array_number(number_id, first_letter_id);
                            $("#L" + id_value).addClass("colorChecked");
                            combinatoria()
                        }
                        if (count > 15 || sub_total > 6006) {
                            $("#L" + id_value).removeClass("colorChecked");
                            $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                            count = util(first_letter_id, 2);
                            delete_array_number(number_id, first_letter_id);
                            combinatoria()
                        }
                    }
                } else {
                    count = util(first_letter_id, 2);
                    $("#" + first_letter_id + "check_" + number_id).prop('checked', false);
                    delete_array_number(number_id, first_letter_id);
                    $("#L" + id_value).removeClass("colorChecked")
                }
                combinatoria()
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
            return b - a
        });
        value_number.reverse();
        $("#" + first_letter_id + "-text-area").val(value_number.join(', '))
    }

    function array_number(number_id, first_letter_id) {
        if (first_letter_id == "J1") {
            value_numberJ1.push(number_id);
            show(first_letter_id, value_numberJ1)
        }
        if (first_letter_id == "J2") {
            value_numberJ2.push(number_id);
            show(first_letter_id, value_numberJ2)
        }
        if (first_letter_id == "J3") {
            value_numberJ3.push(number_id);
            show(first_letter_id, value_numberJ3)
        }
        if (first_letter_id == "J4") {
            value_numberJ4.push(number_id);
            show(first_letter_id, value_numberJ4)
        }
    }

    function delete_array_number(number_id, first_letter_id) {
        if (first_letter_id == "J1") {
            var size = value_numberJ1.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ1[ini] == number_id) {
                    value_numberJ1.splice(ini, 1);
                    show(first_letter_id, value_numberJ1)
                }
            }
        }
        if (first_letter_id == "J2") {
            var size = value_numberJ2.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ2[ini] == number_id) {
                    value_numberJ2.splice(ini, 1);
                    show(first_letter_id, value_numberJ2)
                }
            }
        }
        if (first_letter_id == "J3") {
            var size = value_numberJ3.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ3[ini] == number_id) {
                    value_numberJ3.splice(ini, 1);
                    show(first_letter_id, value_numberJ3)
                }
            }
        }
        if (first_letter_id == "J4") {
            var size = value_numberJ4.length;
            for (ini = 0; ini <= size; ini++) {
                if (value_numberJ4[ini] == number_id) {
                    value_numberJ4.splice(ini, 1);
                    show(first_letter_id, value_numberJ4)
                }
            }
        }
    }

    $(".clear").click(function () {
        if (status == "ACT") {
            var title = $(this).attr("id").substr(0,2);
            $('#'+title+'-check-plus').prop("checked", false);
            $('#'+title+'-check-plus').prop("disabled",true); 
            for (ini = 0; ini <= 45; ini++) {
                $("#" + title + "check_" + ini).prop('checked', false);
                $("#L" + title + "check_" + ini).removeClass("colorChecked");                
 
                if (title == "J1") {
                    value_numberJ1.splice(0, 1);
                    show(title, value_numberJ1)
                }
                if (title == "J2") {
                    value_numberJ2.splice(0, 1);
                    show(title, value_numberJ2)
                }
                if (title == "J3") {
                    value_numberJ3.splice(0, 1);
                    show(title, value_numberJ3)
                }
                if (title == "J4") {
                    value_numberJ4.splice(0, 1);
                    show(title, value_numberJ4)
                }
            }
            count = util(title, 3);
            combinatoria()
        }
    });
    function clear_for_ini(title) {
        for (ini = 0; ini <= 40; ini++) {
            $("#" + title + "check_" + ini).prop('checked', false);
            $("#L" + title + "check_" + ini).removeClass("colorChecked");
            if (title == "J1") {
                value_numberJ1.splice(0, 1);
                show(title, value_numberJ1)
            }
            if (title == "J2") {
                value_numberJ2.splice(0, 1);
                show(title, value_numberJ2)
            }
            if (title == "J3") {
                value_numberJ3.splice(0, 1);
                show(title, value_numberJ3)
            }
            if (title == "J4") {
                value_numberJ4.splice(0, 1);
                show(title, value_numberJ4)
            }
        }
        count = util(title, 3)
    }

    function buscar_repetido(value, title) {
        if (title == "J1") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ1[ini] == value) {
                    return false
                }
            }
        }
        if (title == "J2") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ2[ini] == value) {
                    return false
                }
            }
        }
        if (title == "J3") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ3[ini] == value) {
                    return false
                }
            }
        }
        if (title == "J4") {
            for (ini = 0; ini < 6; ini++) {
                if (value_numberJ4[ini] == value) {
                    return false
                }
            }
        }
        return true
    }

    function util(play, how_marca) {
        switch (play) {
            case"J1":
                if (how_marca == 1) {
                    countJ1++
                }
                if (how_marca == 2) {
                    countJ1--
                }
                if (how_marca == 3) {
                    countJ1 = 0
                }
                if (how_marca == 4) {
                    countJ1 = 6
                }
                return countJ1;
                break;
            case"J2":
                if (how_marca == 1) {
                    countJ2++
                }
                if (how_marca == 2) {
                    countJ2--
                }
                if (how_marca == 3) {
                    countJ2 = 0
                }
                if (how_marca == 4) {
                    countJ2 = 6
                }
                return countJ2;
                break;
            case"J3":
                if (how_marca == 1) {
                    countJ3++
                }
                if (how_marca == 2) {
                    countJ3--
                }
                if (how_marca == 3) {
                    countJ3 = 0
                }
                if (how_marca == 4) {
                    countJ3 = 6
                }
                return countJ3;
                break;
            case"J4":
                if (how_marca == 1) {
                    countJ4++
                }
                if (how_marca == 2) {
                    countJ4--
                }
                if (how_marca == 3) {
                    countJ4 = 0
                }
                if (how_marca == 4) {
                    countJ4 = 6
                }
                return countJ4;
                break
        }
    }

    $(".azar").click(function () {
        if (status == "ACT") {
            if (sub_total < 6006) {
                var ini;
                var title = $(this).attr("id").substr(0,2);
                if (title == "J1") {
                    count = countJ1
                }
                if (title == "J2") {
                    count = countJ2
                }
                if (title == "J3") {
                    count = countJ3
                }
                if (title == "J4") {
                    count = countJ4
                }
                if (count >= 6) {
                    count = 0;
                    clear_for_ini(title)
                }
                while (count < 6) {
                    var number_azar = Math.round(1 + (Math.random() * (40 - 1)));
                    if (buscar_repetido(number_azar, title)) {
                        $("#" + title + "check_" + number_azar).prop('checked', true);
                        $("#L" + title + "check_" + number_azar).addClass("colorChecked");
                        array_number(number_azar, title);
                        count = util(title, 1)
                    }
                }
                combinatoria()
            }
        }
    });
    var algorithm = $("#algorithm").val();
    var costoTotalBet = 0;
    var costoTotalBetMensaje = 0;

    function process_buy() {
	
	var run_cotejo = {toJSON: function (data) {
				return(data !== '') ? $.parseJSON($.trim(data)) : {}
				}};
				
    	var content_object = [];
        if (status == "ACT") {
            if (total <= 6006 && total >= 1) {
                $('.transition-one').hide();
                $('.transition-two').show();
				$('#cotejar').hide();
				$("#regresarCotejo").css({'display': 'block'});
                $('#start_play').hide();
				$('#kabala-cotejo-logo').show();
				$('#cotejoKabala').show();
				$('#kabala-flecha-cotejo').hide();
				$('#kabala-fechas-cotejo').hide();
                $('.finalize-purchase').show();
                var cant_sorteo = $("#mySelectBox").val();
                var precio = costoTotalBet;
                add_ticket(value_numberJ1,value_numberJ2,value_numberJ3,value_numberJ4,content_object,cant_sorteo,precio,add_onsJ1,add_onsJ2,add_onsJ3,add_onsJ4,add_ChauCmb1,add_ChauCmb2,add_ChauCmb3,add_ChauCmb4);
                for (var v in content_object) {
                    for (var w = 0; w <= 3; w++) {
                        var game = "";
						//alert("content_object:"+content_object);
                        if (content_object[v][w] != "") {
                            var games = (content_object[v][w] + "").split(",");
                            for (var t in games) {
                                if (games[t].length < 2) {
                                    games[t] = "0" + games[t]
                                }
                                game += games[t] + " "
                            }
                            content_object[v][w] = trim(game)
                        } else {
                            content_object[v][w] = "00"
                        }
						//alert("content_object1:"+content_object);
                    }
                }
				//alert("content_object12:"+content_object);
                for (var i in content_object) {
                    content_object[i][4] = "null"
                }
				//alert("content_object123:"+content_object);
                grilla_boletos(content_object);
                grilla_paginada(content_object);
                value_numberJ1 = [];
                value_numberJ2 = [];
                value_numberJ3 = [];
                value_numberJ4 = [];
                $(".clear").click();
                var costo_total = 0;
                for (var i in content_object) {
                    costo_total += parseFloat(content_object[i][6])
                }
				//alert("content_object1234:"+content_object);
                $(".result1").html("S/." + floatFormat(costo_total));
                $(".label_resu2").html($("#price-message").text());
            }
            if (total > 6006) {
                jAlert("El total de apuestas no debe ser mayor a 6006")
            }
        }
		    var fecha_ini_1=$("#mySelectBox").val();
			var from=$("#mySelectBox-2").val();
			var to=parseInt(fecha_ini_1)+parseInt(from);
			
			
			
			
			
			
			
			
			
			
			//alert("entrastes");
        var option = $("[name=option-card]:checked").val();
        var pin = $("[name=pin-number]").val();
        var message = "";
        var amount = 0.0;
        var newamount = 0.0;
        var msgres = new Array();
		
		//alert("content_object: "+content_object);
		
            for (var i in content_object) {
                content_object[i][4] = "null"
           
            if (content_object.length != 0) {
			//alert("entro222");
               
			   
                var result_ticket = "";
                for (i in content_object) {
                    if (i != 0) {
                        result_ticket += "-"
                    }
                    for (j in content_object[i]) {
                        if (j != 0) {
                            result_ticket += "/"
                        }
                        var numeros = (content_object[i][j] + "").split(",");
                        for (var num = 0; num < numeros.length; num++) {
                            if (numeros[num].length < 2) {
                                if (numeros[num] != "0") {
                                    numeros[num] = "0" + numeros[num]
                                }
                            }
                            result_ticket += trim(numeros[num]) + " "
                        }
                    }
                }
                result_ticket=result_ticket+"/"+from+"/"+to;
                $("#ajax-loader").show();
				//alert("entro1");
				var result="";
                var resultJson="";
				var contador = 0;
				//alert("entro1111");
                $.ajax({type: "POST", url: "cotejo_ajax.html", dataType: "text", data: "dato=" + result_ticket,async:false, success: function (e) {
				resultJson= $.parseJSON(e);	
				result=e;
				}})
				//alert(result);
				var a = '';
				
				$.map(resultJson, function (d) { 
				$.map(d.datos_jugada_A, function (f) { 
				//alert(f);
				a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.sorteo + '</span></span><span class="datos_enunciado_cotejo_left" >Fecha:  <span class="datos_enunciado_contenido_cotejo_left">' + f.fecha + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.resultado + '</span></span></br>';
                
                if(f.resultadoChauchamba!="null" && f.resultadoChauchamba!=null){
                a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo Chau Chamba:   <span class="datos_enunciado_contenido_cotejo_right">' + f.resultadoChauchamba + '</span></span>';
                }
                
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
				
				var o=0;l=0;m=0;q=0;
				if(f.jugadaA!=null){
				a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaA + '</span></span></div></br>';
				 $.map(f.cotejo_jugada_A, function (c) {
                    q++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + q + ']</b>  <span class="cotejador">' + c + '</span></span></div></br>'
                });
				}
				
				if(f.jugadaB!=null){
				a += '<div><span class="datos_enunciado_cotejo_right">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaB + '</span></span></div></br>';
				 $.map(f.cotejo_jugada_B, function (s) {
                    o++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + o + ']</b>  <span class="cotejador">' + s + '</span></span></div></br>'
                });
				}
				
				
				if(f.jugadaC!=null){
				a += '<div><span class="datos_enunciado_cotejo_right">Jugada C:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaC + '</span></span></div></br>';
				 $.map(f.cotejo_jugada_C, function (t) {
                    l++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + l + ']</b>  <span class="cotejador">' + t + '</span></span></div></br>'
                });
				}
				
				if(f.jugadaD!=null){
				a += '<div><span class="datos_enunciado_cotejo_right">Jugada D:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaD + '</span></span></div></br>';
				 $.map(f.cotejo_jugada_D, function (h) {
                    m++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + m + ']</b>  <span class="cotejador">' + h + '</span></span></div></br>'
                });
				 a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>'
				}
				
				});
				});
				$("#valorJugada").html(a);
            } 
           
        }
		
		
			
    }

    /*function buy() {
        if ((value_numberJ1.length < 6 && value_numberJ1.length >= 1) || (value_numberJ2.length < 6 && value_numberJ2.length >= 1) || (value_numberJ3.length < 6 && value_numberJ3.length >= 1) || (value_numberJ4.length < 6 && value_numberJ4.length >= 1)) {
            jconfirm("Por favor marque todas las casillas de la jugada .", null, function (r) {
                if (r) {
                    process_buy()
                }
            })
        } else process_buy()
    }*/
    
    function buy() {
			
        if((0<value_numberJ1.length && value_numberJ1.length<6) || (0<value_numberJ2.length && value_numberJ2.length<6) || (0<value_numberJ3.length && value_numberJ3.length<6) || (0<value_numberJ4.length && value_numberJ4.length<6)){
            jAlert('Elige correctamente tu apuesta.', null);                     
       } else if (total<1 && costoTotalBet<=0) {
           jAlert('No ha realizado ninguna jugada.', null);
       } else {
           process_buy();
       }   
    }

    $('#buy').on('click',function () {
        if(status == 'ACT'){ 
            if ((costoTotalBetMensaje <= costoTotalBet) && algorithm != "") {
            jConfirm("No desaproveches hay promocion.", null, function (r) {
                if (r) {
                    buy()
                }
            })
            } else {
                buy()
            }
        }
    });
    $('.more').click(function () {
        if (status == "ACT") {
            if (sub_total < 6006) {
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
                    array_number(more[i], title)
                }
                combinatoria()
            }
        }
    });
    $('.less').click(function () {
        if (status == "ACT") {
            if (sub_total < 6006) {
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
                    array_number(more[i], title)
                }
                combinatoria()
            }
        }
    });
    var bets = $("#bets").val();
    var pay = $("#pay").val();
    var cost = $("#cost").val();
    var draw = $("#draw").val();
    var sorteos = $("#mySelectBox").val();
    $("#mySelectBox").on("change", function () {
        sorteos = $(this).val();
        combinatoria()
    });
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
            for (ini = 1; ini <= 40; ini++) {
                if ($("#J" + iniL + "check_" + ini).is(':checked')) {
                    contador++
                }
            }
            if (iniL == 1) {
                contador_1 = contador;
                if (contador >= 6) {
                    cantin_1 = bin_newton(contador)
                } else {
                    cantin_1 = 0
                }
                if (contador_1 <= 5 && contador_1 > 0) {
                    sub_cantin_1 = 1
                } else {
                    sub_cantin_1 = cantin_1
                }
            }
            if (iniL == 2) {
                contador_2 = contador;
                if (contador >= 6) {
                    cantin_2 = bin_newton(contador)
                } else {
                    cantin_2 = 0
                }
                if (contador_2 <= 5 && contador_2 > 0) {
                    sub_cantin_2 = 1
                } else {
                    sub_cantin_2 = cantin_2
                }
            }
            if (iniL == 3) {
                contador_3 = contador;
                if (contador >= 6) {
                    cantin_3 = bin_newton(contador)
                } else {
                    cantin_3 = 0
                }
                if (contador_3 <= 5 && contador_3 > 0) {
                    sub_cantin_3 = 1
                } else {
                    sub_cantin_3 = cantin_3
                }
            }
            if (iniL == 4) {
                contador_4 = contador;
                if (contador >= 6) {
                    cantin_4 = bin_newton(contador)
                } else {
                    cantin_4 = 0
                }
                if (contador_4 <= 5 && contador_4 > 0) {
                    sub_cantin_4 = 1
                } else {
                    sub_cantin_4 = cantin_4
                }
            }
        }
        sub_total = sub_cantin_1 + sub_cantin_2 + sub_cantin_3 + sub_cantin_4;
        
        if (sub_total <= 6006) {
            total = cantin_1 + cantin_2 + cantin_3 + cantin_4
        }
        process_add_ons();
        active_plus();
        if (total >= 1) {
           
            if (algorithm == "BETS") {
                costoTotalBetMensaje = callTransformByBets(parseInt(total) + 1, sorteos, v_data_value_bet, bets, pay);
                costoTotalBet = callTransformByBets(total, sorteos, v_data_value_bet, bets, pay) + (total_plus*sorteos);
            } else {
                if (algorithm == "COST") {
                    costoTotalBetMensaje = callTransformByCost(parseInt(total) + 1, sorteos, v_data_value_bet, bets, cost);
                    costoTotalBet = callTransformByCost(total, sorteos, v_data_value_bet, bets, cost) + (total_plus*sorteos);
                } else {
                    if (algorithm == "DRAW") {
                        costoTotalBetMensaje = callTransformByDraws(total, parseInt(sorteos) + 1, v_data_value_bet, draw, pay);
                        costoTotalBet = callTransformByDraws(total, sorteos, v_data_value_bet, draw, pay) + (total_plus*sorteos);
                    } else {
                        //costoTotalBet = v_data_value_bet * total * sorteos                        
                        costoTotalBet = ((v_data_value_bet * total) + total_plus) * sorteos
                    }
                }
            }
             
            $('#comb').html(floatFormat(total));
            $('#total_apagar').html(floatFormat(costoTotalBet));
        } else {
            total = 0;
            costoTotalBet=0;
            $('#comb').html(0);
            $('#total_apagar').html(0);
            $('#plus-text').html('');
        }       
        
    }
    
    $('.check-plus').on('click',function(){
        if(total >= 1){
            combinatoria();
        }
    });
    
    function process_add_ons(){
        total_plus=0;
        total_plusJ1=0;
        total_plusJ2=0;
        total_plusJ3=0;
        total_plusJ4=0;     
        add_onsJ1='null';
        add_onsJ2='null';
        add_onsJ3='null';
        add_onsJ4='null';       
        var plus='';
        
        $('#plus-text').html('');
        if($('#J1-check-plus').is(':checked') && cantin_1>0){
            total_plusJ1=cantin_1*0.5;
            add_onsJ1='AD1';
            plus='Plus+'
            $('#plus-text').html(' / '+plus);           
        }
        if($('#J2-check-plus').is(':checked') && cantin_2>0){
            total_plusJ2=cantin_2*0.5;
            add_onsJ2='AD1';
            plus='Plus+'
            $('#plus-text').html(' / '+plus);
        }
        if($('#J3-check-plus').is(':checked') && cantin_3>0){
            total_plusJ3=cantin_3*0.5;  
            add_onsJ3='AD1';
            plus='Plus+'
            $('#plus-text').html(' / '+plus);
        }
        if($('#J4-check-plus').is(':checked') && cantin_4>0){
            total_plusJ4=cantin_4*0.5;
            add_onsJ4='AD1';
            plus='Plus+'
            $('#plus-text').html(' / '+plus);
        }  
        total_plus = total_plusJ1 + total_plusJ2 + total_plusJ3 + total_plusJ4;
    }
    
    function active_plus(){
		add_ChauCmb1=0;
        add_ChauCmb2=0;
        add_ChauCmb3=0;
        add_ChauCmb4=0;    
		
        if(cantin_1>0){
            $('#J1-check-plus').prop("disabled",false);
		if($('#J1-check-plus').is(':checked')){
			$('#J5-check-chauchamba').prop("disabled",false);
		}else {
		$('#J5-check-chauchamba').prop("disabled",true);
		$('#J5-check-chauchamba').attr('checked', false); 
		}			
        }else{
            $('#J1-check-plus').prop("disabled",true);            
        }
        if(cantin_2>0){
            $('#J2-check-plus').prop("disabled",false);    
		if($('#J2-check-plus').is(':checked')){
			$('#J6-check-chauchamba').prop("disabled",false);
		}else {
		$('#J6-check-chauchamba').prop("disabled",true);
		$('#J6-check-chauchamba').attr('checked', false);
		}		
        }else{
            $('#J2-check-plus').prop("disabled",true);               
        }
        if(cantin_3>0){
            $('#J3-check-plus').prop("disabled",false);    
		if($('#J3-check-plus').is(':checked')){
			$('#J7-check-chauchamba').prop("disabled",false);
		}else {
		$('#J7-check-chauchamba').attr('checked', false);
		$('#J7-check-chauchamba').prop("disabled",true);
		}				
        }else{
            $('#J3-check-plus').prop("disabled",true);               
        }
        if(cantin_4>0){
            $('#J4-check-plus').prop("disabled",false);     
		if($('#J4-check-plus').is(':checked')){
			$('#J8-check-chauchamba').prop("disabled",false);
		}else {
		$('#J8-check-chauchamba').attr('checked', false);
		$('#J8-check-chauchamba').prop("disabled",true);
		}				
        }else{
            $('#J4-check-plus').prop("disabled",true);       
        }
		
		if($('#J5-check-chauchamba').is(':checked')){
		add_ChauCmb1=1;
		}else{
		add_ChauCmb1=0;
		}if($('#J6-check-chauchamba').is(':checked')){
		add_ChauCmb2=1;
		}else{
		add_ChauCmb2=0;
		}if($('#J7-check-chauchamba').is(':checked')){
		add_ChauCmb3=1;
		}else{
		add_ChauCmb3=0;
		}if($('#J8-check-chauchamba').is(':checked')){
		add_ChauCmb4=1;
		}else{
		add_ChauCmb4=0;
		}
    }

    function bin_newton(cantidad) {
        var deduct_1 = 1;
        var deduct_2 = 1;
        var count_2 = cantidad - 6;
        variable = factorial(cantidad) / (720 * (factorial(count_2)));
        return variable
    }

    function factorial(cantidad) {
        if (cantidad < 0)return 0; else if (cantidad > 1)return cantidad * factorial(cantidad - 1);
        return 1
    }

    function callTransformByDraws(p_sum_total_bet, p_number_consecutive, p_data_value_bet, p_draws, p_pay) {
        var var_total_cost = 0;
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = var_sum_total_bet_consecutive * p_data_value_bet;
        if (p_number_consecutive >= parseInt(p_draws))var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(p_number_consecutive / p_draws) * (p_draws - p_pay) * p_data_value_bet));
        return var_total_cost
    }

    function callTransformByBets(p_sum_total_bet, p_number_consecutive, p_data_value_bet, p_bets, p_pay) {
        var var_total_cost = 0;
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(var_sum_total_bet_consecutive / p_bets) * (p_bets - p_pay) * p_data_value_bet));
        return var_total_cost
    }

    function callTransformByCost(p_sum_total_bet, p_number_consecutive, p_data_value_bet, p_bets, p_cost) {
        var var_total_cost = 0;
        var var_sum_total_bet_consecutive = 0;
        var_sum_total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);
        var_total_cost = ((var_sum_total_bet_consecutive * p_data_value_bet) - (Math.floor(var_sum_total_bet_consecutive / p_bets) * (p_bets * p_data_value_bet - p_cost)));
        return var_total_cost
    }


    $('.left-panel').on('click','.lnk-pag1',function(){
        var cadena_pos = $(this).attr("rel");
        var id = $(this).attr("id");
        var posiciones = cadena_pos.split("-");
        $(".row_grid").removeClass("row_null");
        $(".row_grid").addClass("row_null");
        for (var num in posiciones) {
            $(".row_grid").eq(posiciones[num]).removeClass("row_null")
        }
        grilla_paginada(content_object);
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#" + $(this).attr("id")).removeClass("num_page_on");
        $("#" + $(this).attr("id")).addClass("num_page_off")
    });
    $('.left-panel').on('click','.lnk-pag2',function(){
        var cadena_pos = $(this).attr("rel");
        var id = $(this).attr("id");
        var posiciones = cadena_pos.split("-");
        $(".row_grid").removeClass("row_null");
        $(".row_grid").addClass("row_null");
        for (var num in posiciones) {
            $(".row_grid").eq(posiciones[num]).removeClass("row_null")
        }
        grilla_paginada2(new_content_object);
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#" + $(this).attr("id")).removeClass("num_page_on");
        $("#" + $(this).attr("id")).addClass("num_page_off")
    });
    $('.left-panel').on('click','.lnk-pag3',function(){
        var cadena_pos = $(this).attr("rel");
        var id = $(this).attr("id");
        var posiciones = cadena_pos.split("-");
        $(".row_grid").removeClass("row_null");
        $(".row_grid").addClass("row_null");
        for (var num in posiciones) {
            $(".row_grid").eq(posiciones[num]).removeClass("row_null")
        }
        grilla_paginada3(array_no_procesados);
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#" + $(this).attr("id")).removeClass("num_page_on");
        $("#" + $(this).attr("id")).addClass("num_page_off")
    });
    $('#keep-playing').on('click', function(event){
        event.preventDefault();            
     }); 
    $("#more_plays").click(function () {
        $('.check-plus').prop('checked', false);
        $('.transition-two').hide();
        $('.transition-one').show();
        $('#start_play').fadeIn('fast');
        $('.finalize-purchase').hide();
		$('#kabala-flecha-cotejo').show();
        $("#part2").hide();
        $("#part1").show();
        $(".play_go_1_2_gd").addClass("play_go_3_4_gd");
        $('.flecha_back').addClass("flecha_next");
        $(".flecha_next").show();
        $(".flecha_back").hide();
		$('#cotejar').show();
		$("#cotejoKabala").css({'display': 'none'});
		$("#regresarCotejo").css({'display': 'none'});
		$('#kabala-fechas-cotejo').show();
		$(".cantFecha").html(tot_fechas);
		$(".selectBoxCotejo").html(cant_fecha);
        $(".selectBox").html(combo_fecha);
        $("#total_apagar").html("0");
        sorteos = 1;
        costoTotalBet = 0;
        costoTotalBetMensaje = 0
    });
    $('#game-history').on('click',function(event){
        event.preventDefault();
    });
    $('.left-panel').on('click','.process-delete1',function(){
        var pos = parseInt($(this).attr("rel"));
        content_object.splice(pos, 1);
        grilla_boletos(content_object);
        grilla_paginada(content_object);
        var costo_total = 0;
        for (var i in content_object) {
            costo_total += content_object[i][6]
        }
        $(".result1").html("S/." + floatFormat(costo_total));
        if(content_object.length==0){
            $('#more_plays').click();
        }        
    });
    $('.left-panel').on('click','.process-delete2',function(){
        var pos = parseInt($(this).attr("rel"));
        array_no_procesados.splice(pos, 1);
        var costo_total = 0;
        for (var i in array_no_procesados) {
            costo_total += parseFloat(array_no_procesados[i][6])
        }
        $(".result1").html("S/." + floatFormat(costo_total));
        grilla_boletos3(array_no_procesados);
        grilla_paginada3(array_no_procesados)
    });
    var new_content_object = [];
   $("#btn_finaliza_compra").click(function () {
   
    });
    $('.left-panel').on('mouseover','.row-info',function(){
        var posicion = $(this).attr("rel");
        var content_info = "";       
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        for (var i = 0; i <= 3; i++) {
            content_object[posicion][i] = trim(content_object[posicion][i]);
            if (content_object[posicion][i] != "00") {
                if (content_object[posicion][i] != "null") {
                    var add_ons='';
                    add_ons=content_object[posicion][i+8];
                    var test = (content_object[posicion][i] + "").split("-");
                    if (test[1] != "null") {
                        var numeros = (content_object[posicion][i] + "").split(",");
                        var result_ticket = "";
                        for (var num in numeros) {
                            if (numeros[num].length < 2) {
                                numeros[num] = "0" + numeros[num]
                            }
                            result_ticket += numeros[num] + " "
                        }
                        if(add_ons!='null'){
                            content_info += nom_jugadas[i] + ': ' + result_ticket +' Plus+<br>'
                        }
                        else{
                            content_info += nom_jugadas[i] + ': ' + result_ticket + '<br>'                            
                        }
                        
                    }
                }
            }
        }
        $(".tooltip-info").eq(posicion).show();
        $(".tooltip-info").eq(posicion).html(content_info);
        $(".tooltip-info-arrow-img").eq(posicion).show()
    });
    $('.left-panel').on('mouseout','.row-info',function(){
        var posicion = $(this).attr("rel");
        $(".tooltip-info").eq(posicion).css("display", "none");
        $(".tooltip-info-arrow-img").eq(posicion).css("display", "none")
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
                                numeros[num] = "0" + numeros[num]
                            }
                            result_ticket += numeros[num] + " "
                        }
                        content_info += nom_jugadas[i] + ": " + result_ticket + "<br>"
                    }
                }
            }
        }
        $(".tooltip-info").eq(posicion).show();
        $(".tooltip-info").eq(posicion).html(content_info);
        $(".tooltip-info-arrow-img").eq(posicion).show()
    });
    $('.left-panel').on('mouseout','.row-info2',function(){
        var posicion = $(this).attr("rel");
        $(".tooltip-info").eq(posicion).css("display", "none");
        $(".tooltip-info-arrow-img").eq(posicion).css("display", "none")
    });
    $('.left-panel').on('mouseover','.no-process',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = (contenido_total + "").split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1] + "";
        $(".tooltip-no-process").eq(posicion).show();
        $(".tooltip-no-process").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img").eq(posicion).show()
    });
    $('.left-panel').on('mouseout','.no-process',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = contenido_total.split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1];
        $(".tooltip-no-process").eq(posicion).css("display", "none");
        $(".tooltip-no-process").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img").eq(posicion).css("display", "none")
    });
    $('.left-panel').on('mouseover','.no-process2',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = (contenido_total + "").split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1] + "";
        $(".tooltip-no-process2").eq(posicion).show();
        $(".tooltip-no-process2").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img2").eq(posicion).show()
    });
    $('.left-panel').on('mouseout','.no-process2',function(){
        var contenido_total = $(this).attr("rel");
        var contenido_temp = contenido_total.split("#");
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1];
        $(".tooltip-no-process2").eq(posicion).css("display", "none");
        $(".tooltip-no-process2").eq(posicion).html(mensaje);
        $(".tooltip-no-process-arrow-img2").eq(posicion).css("display", "none")
    });
    var array_no_procesados = [];
    $('.left-panel').on('click','#btn-no-process',function(){
        var contador = 0;
        for (var i in new_content_object) {
            var procesos = (new_content_object[i][4] + "").split("&");
            if (procesos[1] == "null") {                
                array_no_procesados.push(new_content_object[i]);
                contador++
            }
        }
        $("#panel_keep-playing").css("display", "none");
        $("#panel_game-history").css("display", "none");
        $("#ico-block").css("display", "none");
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
        var temp_jugada_2 = "<span class='label_1'>KABALA</span>" + "<div id='content-grid-result'></div>" + "<div id='num_link'></div>";
        $(".left-panel").html(temp_jugada_2);
        if (status == "ACT") {
            $('.transition-one').hide();
            $('.transition-two').show();
            $('#start_play').hide();
            $('.finalize-purchase').show();
            var cant_sorteo = $("#mySelectBox").val();
            var precio = costoTotalBet;
            content_object = [];
            content_object = array_no_procesados;
            array_no_procesados = [];
            new_content_object = [];
            grilla_boletos(content_object);
            grilla_paginada(content_object);
            $(".clear").click();
            var costo_total = 0;
            for (var i in content_object) {
                costo_total += parseFloat(content_object[i][6])
            }
            $(".result1").html("S/." + floatFormat(costo_total));
            $(".result2").html("S/." + parseFloat($("#simpleBetPrice_repeated").val()));
            $(".label_resu1").html("TOTAL A PAGAR")
        }
    });
    function add_ticket(juego1, juego2, juego3, juego4, content_object, cantidad_sorteo, precio,add_onsJ1,add_onsJ2,add_onsJ3,add_onsJ4,add_ChauCmb1,add_ChauCmb2,add_ChauCmb3,add_ChauCmb4) {
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
        object_boleto.push(add_onsJ1);
        object_boleto.push(add_onsJ2);
        object_boleto.push(add_onsJ3);
        object_boleto.push(add_onsJ4);
		object_boleto.push(add_ChauCmb1);
		object_boleto.push(add_ChauCmb2);
		object_boleto.push(add_ChauCmb3);
		object_boleto.push(add_ChauCmb4);        
        content_object.push(object_boleto);
    }

    function grilla_boletos(data) {
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var grilla = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>ANULAR</div>" + "</div>";
        var add_ons='';
        for (var x in data) {
            for (var i = 0; i <= 3; i++) {
                if (data[x][i] != "") {
                    if (data[x][i] != "00") {
                        add_ons=data[x][i+8];
                        var result_ticket = nom_jugadas[i] + ": ";
                        var numeros = (data[x][i] + "").split(",");
                        for (var num in numeros) {
                            if (numeros[num].length < 2) {
                                numeros[num] = "0" + numeros[num]
                            }
                            result_ticket += numeros[num] + " "
                        }
                        break
                    }
                }
            }
            if(add_ons!='null'){
                result_ticket=result_ticket+' Plus+';            
            }           
            var style = "row_grid";
            if (x % 2 != 0) {
                style += " row_grid_mouseover"
            }
            if (x > 2) {
                style += " row_null"
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + (parseInt(x) + 1) + "</div>" + "<div class='column_2'>" + result_ticket.substring(0,34) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + "<div class='column_3'>" + "<div class='delete process-delete1' rel='" + x + "'></div>" + "</div>" + "</div>"
        }
        grilla += "</div></div>";
        $('#content-grid-result').html(grilla)
    }

    function grilla_boletos2(data) {
        var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
        var no_process_message_count = 0;
        var grilla = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>VER</div>" + "</div>";
        var add_ons='';
        for (var x in data) {
            for (var i = 0; i <= 3; i++) {
                if (data[x][i] != "00") {
                    add_ons=$.trim(data[x][i+8]);
                    var result_ticket = nom_jugadas[i] + ": ";
                    var numeros = (data[x][i] + "").split(",");
                    for (var num in numeros) {
                        if (numeros[num].length < 2) {
                            numeros[num] = "0" + numeros[num]
                        }
                        result_ticket += numeros[num] + " "
                    }
                    break
                }
            }
            if(add_ons!='null'){
                result_ticket=result_ticket+' Plus+';            
            } 
            var style = "row_grid";
            if (x % 2 != 0) {
                style += " row_grid_mouseover"
            }
            if (x > 2) {
                style += " row_null"
            }
            var dato_proceso = (data[x][4] + "").split("&");
            var process_resp = "";
            if (dato_proceso[1] == "null") {
                process_resp = "<div class='column3-no-process'>No procesado&nbsp;&nbsp;<span class='no-process' rel='" + no_process_message_count + "#" + dato_proceso[0] + "'>[?]</span> </div>";
                process_resp += "<div class='tooltip-no-process'></div><div class='tooltip-no-process-arrow-img'></div></div>";
                no_process_message_count++;
                var game_no_process_info = "<div class='title-text'><div><b>Jugadas no procesadas</b></div>" + "<div>Tienes apuestas que no se han podido procesar.</div></div>" + "<div id='no-process-section'><a href='#' class='buttom-go' id='btn-no-process' onclick='return false;'></a></div>";
                $("#game-no-process-info").html(game_no_process_info);
                $("#game-no-process-info").show()
            } else {
                process_resp = "<div class='column3-codigo'>" + dato_proceso[1] + "</div><div class='column3-search' onclick='openPreviewWindow(" + data[x][13] + ",\"" + data[x][12] + "\",\"" + dato_proceso[1] + "\")'></div>"
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + data[x][7] + "</div>" + "<div class='column_2'>" + result_ticket.substring(0,34) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + process_resp + "</div>"
        }
        grilla += "</div></div>";
        $('#content-grid-result').html(grilla)
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

    /*$('#frmLoginClientPuchase').on('submit', function (event) {
        var user = $('#user-client').val();
        var pass = $('#password-client').val();
        event.preventDefault();
        if (user == '' || pass == '') {
            jAlert('Complete los datos de usuario')
        } else {
            $.ajax({type: "POST", url: "login_kabala.html", dataType: "text", data: $("#frmLoginClient").serialize(), success: function (e) {
                var resp = trim(e);
                var arrresp = resp.split("|");
                var valida_session = arrresp[0];
                if (valida_session == 'OK') {
                    var username = arrresp[1];
                    var useramount = arrresp[2];
                    var userid = arrresp[3];
                    var monto1 = floatFormat(arrresp[4]);
                    var monto2 = floatFormat(arrresp[5]);
                    $("#field-balanceAmount").html(monto1);
                    if (monto2 == "0.00") {
                        $(".saldo_promocional").html("")
                    } else {
                        $(".saldo_promocional").html("&oacute; de mi saldo promocional S/." + monto2)
                    }
                    $("#clientId").val(userid);
                    $("#clientSale-name").html(username);
                    $("#clientSale-amount").html(useramount);
                    $(".logout").show();
                    $(".unlogout").hide();
                    $("#payments_section").show();
                    $("#login_section").css("display", "");
                    $("#panel_finaliza_compra").show()
                } else {
                    jAlert(valida_session)
                }
            }})
        }
    });*/
    var idsession = $("#clientId").val();
    if (idsession == '') {
        $("#login_section").show()
    } else {
        $("#panel_finaliza_compra").show();
        $("#payments_section").show()
    }
    var run = {toJSON: function (data) {
        return(data !== '') ? $.parseJSON($.trim(data)) : {}
    }};
    var w = ($('#jugadaCompletaKabala').exists()) ? run.toJSON($('#jugadaCompletaKabala').val()) : [];
    var bet1 = '';
    var bet2 = '';
    var bet3 = '';
    var bet4 = '';
    $.map(w, function (x) {
        bet1 = x.bet1;
        bet2 = x.bet2;
        bet3 = x.bet3;
        bet4 = x.bet4
    });
    var gameA = '';
    var gameB = '';
    var gameC = '';
    var gameD = '';
    var a = '';
    var i = 0, j = 0, h = 0, m = 0;
    if ((bet1 > 2) && (bet2 < 6) && (bet3 < 6) && (bet4 < 6)) {
        $.map(w, function (e) {
            $.map(e.datos_jugada_A, function (f) {
                i = 0;
                a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.sorteo + '</span></span><span class="datos_enunciado_cotejo_left" >Fecha:  <span class="datos_enunciado_contenido_cotejo_left">' + f.fecha + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.resultado + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaA + '</span></span></div></br>';
                $.map(f.cotejo_jugada_A, function (c) {
                    i++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + i + ']</b>  <span class="cotejador">' + c + '</span></span></div></br>'
                });
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>'
            })
        })
    } else if ((bet1 > 2) && (bet2 > 6) && (bet3 < 6) && (bet4 < 6)) {
        $.map(w, function (e) {
            $.map(e.datos_jugada_B, function (f) {
                i = 0;
                j = 0;
                a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.sorteo + '</span></span><span class="datos_enunciado_cotejo_left">Fecha:  <span class="datos_enunciado_contenido_cotejo_left">' + f.fecha + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.resultado + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaA + '</span></span></div></br>';
                $.map(f.cotejo_jugada_A, function (c) {
                    i++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + i + ']</b>  <span class="cotejador">' + c + '</span></span></div></br>'
                });
                a += '<div><span class="datos_enunciado_cotejo_right">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaB + '</span></span></div></br>';
                $.map(f.cotejo_jugada_B, function (d) {
                    j++;
                    a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>[' + j + ']</b>  <span class="cotejador">' + d + '</span></span></div></br>'
                });
                a += '<div class="datos_separador"  Style="margin-top: -8px;"><span>..........................................................................................................................................</span></div>'
            })
        })
    } else if ((bet1 > 2) && (bet2 > 6) && (bet3 > 6) && (bet4 < 6)) {
        $.map(w, function (e) {
            $.map(e.datos_jugada_C, function (f) {
                i = 0;
                j = 0;
                h = 0;
                a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.sorteo + '</span></span><span class="datos_enunciado_cotejo_left" ">Fecha:  <span class="datos_enunciado_contenido_cotejo_left">' + f.fecha + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.resultado + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaA + '</span></span></div></br>';
                $.map(f.cotejo_jugada_A, function (c) {
                    i++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + i + ']</b>  <span class="cotejador">' + c + '</span></span></div></br>'
                });
                a += '<div><span class="datos_enunciado_cotejo_right" Style="margin-top: -10px;">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaB + '</span></span></div></br>';
                $.map(f.cotejo_jugada_B, function (d) {
                    j++;
                    a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>[' + j + ']</b>  <span class="cotejador">' + d + '</span></span></div></br>'
                });
                a += '<div><span class="datos_enunciado_cotejo_right">Jugada C:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaC + '</span></span></div></br>';
                $.map(f.cotejo_jugada_C, function (e) {
                    h++;
                    a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>[' + h + ']</b>  <span class="cotejador">' + e + '</span></span></div></br>'
                });
                a += '<div class="datos_separador"  Style="margin-top: -8px;"><span>..........................................................................................................................................</span></div>'
            })
        })
    } else if ((bet1 > 2) && (bet2 > 6) && (bet3 > 6) && (bet4 > 6)) {
        $.map(w, function (e) {
            $.map(e.datos_jugada_D, function (f) {
                i = 0;
                j = 0;
                h = 0;
                m = 0;
                a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.sorteo + '</span></span><span class="datos_enunciado_cotejo_left">Fecha:  <span class="datos_enunciado_contenido_cotejo_left">' + f.fecha + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">' + f.resultado + '</span></span>';
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
                a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaA + '</span></span></div></br>';
                $.map(f.cotejo_jugada_A, function (c) {
                    i++;
                    a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>[' + i + ']</b>  <span class="cotejador">' + c + '</span></span></div></br>'
                });
                a += '<div><span class="datos_enunciado_cotejo_right" Style="margin-top: -10px;">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaB + '</span></span></div></br>';
                $.map(f.cotejo_jugada_B, function (d) {
                    j++;
                    a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>[' + j + ']</b>  <span class="cotejador">' + d + '</span></span></div></br>'
                });
                a += '<div><span class="datos_enunciado_cotejo_right" Style="margin-top: -10px;">Jugada C:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaC + '</span></span></div></br>';
                $.map(f.cotejo_jugada_C, function (e) {
                    h++;
                    a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>[' + h + ']</b>  <span class="cotejador">' + e + '</span></span></div></br>'
                });
                a += '<div><span class="datos_enunciado_cotejo_right" Style="margin-top: -10px;">Jugada D:   <span class="datos_enunciado_contenido_cotejo_right">' + f.jugadaD + '</span></span></div></br>';
                $.map(f.cotejo_jugada_D, function (g) {
                    m++;
                    a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>[' + m + ']</b>  <span class="cotejador">' + g + '</span></span></div></br>'
                });
                a += '<div class="datos_separador"><span>..........................................................................................................................................</span></div>'
            })
        })
    }
    $.map(w, function (k) {
        $.map(k.resultado_jugada, function (t) {
            a += '<div class="calculo_premio">';
            a += '<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/kabala/ico-calculo-premios.gif"></span><span><b> Calculo de premio total:</b></span></div>';
            a += '<span style="margin-bottom: 10px"></span>';
            a += '<table align="center" border="1" cellspacing="0" class="table_kabala">';
            a += '<th class="th_kabala"><span class="th_kabala"><b>Tus Aciertos</b></span></th>';
            a += '<th class="th_kabala"><span class="th_kabala"><b>N&ordm; de jugadas Ganadoras</b></span></th>';
            a += '<th class="th_kabala"><span class="th_kabala"><b>Premio Total</b></span></th>';
            a += '<th class="th_kabala"><span class="th_kabala"><b>Caduca</b></span></th>';
            if (t.dos > 0) {
                a += '<tr>';
                a += '<td class="td_kabala"><c:out value=""/>' + t.acierto_dos + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.dos + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.premio_total_dos + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.caduca_dos + '</td>';
                a += '</tr>'
            }
            if (t.tres > 0) {
                a += '<tr>';
                a += '<td class="td_kabala"><c:out value=""/>' + t.acierto_tres + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.tres + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.premio_total_tres + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.caduca_tres + '</td>';
                a += '</tr>'
            }
            if (t.cuatro > 0) {
                a += '<tr>';
                a += '<td class="td_kabala"><c:out value=""/>' + t.acierto_cuatro + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.cuatro + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.premio_total_cuatro + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.caduca_cuatro + '</td>';
                a += '</tr>'
            }
            if (t.cinco > 0) {
                a += '<tr>';
                a += '<td class="td_kabala"><c:out value=""/>' + t.acierto_cinco + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.cinco + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.premio_total_cinco + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.caduca_cinco + '</td>';
                a += '</tr>'
            }
            if (t.seis > 0) {
                a += '<tr>';
                a += '<td class="td_kabala"><c:out value=""/>' + t.acierto_seis + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.seis + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.premio_total_seis + '</td>';
                a += '<td class="td_kabala"><c:out value="" />' + t.caduca_seis + '</td>';
                a += '</tr>'
            }
            a += '<th colspan="7" class="table_result_kabala"><b>  <span>Ganastes en Efectivo (S/.)*</span><span style="margin:10px">' + t.totalPremio + '</span> </b></th>';
            a += '</table>';
            a += '<div style="margin: 10px;"></div>';
            a += '<span class="mensaje_kabala" Style="margin-top="4px";">*Todos los premios estar&aacute;n afectos al 10% de descuento por concepto de impuestos y deducciones de ley municipal.</span><br/>';
            a += '<div style="margin: 10px;"></div>'
        })
    });
    $("#valor").html(a);
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

    $(".label_2").html(fecha_actual());
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

    $("#option-card-0").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "")
    });
    $("#option-card-1").click(function () {
        $("#panel_transaccion_1").show();
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "")
    });
    $("#option-card-2").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").show();
        $("#panel_transaccion_3").css("display", "")
    });
    $("#option-card-3").click(function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").show();
    }) 
};
$($kabala);