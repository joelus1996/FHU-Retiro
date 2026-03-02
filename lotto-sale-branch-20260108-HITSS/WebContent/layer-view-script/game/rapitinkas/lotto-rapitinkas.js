var Rapitinkas = function () {
var availableAmount;
    $("#menu-item-3").addClass("current-menu-item");
    $('#reload-balanace').hide();
    $('#contenido_three').hide();
    $('#back_previous').remove();
    var idsession = $('#clientId').val();
    
    if(idsession != '' && $("#agreement").val() == ''){
    	$('#login_section').show();
    	exe.opentyc(null);
    } else if (idsession == '') {
        $('#login_section').show();
    } else {
        $('#login_section').hide();
        $('#play-panel').show();
        $('#payments_section').show();
    }
    
    // TEST
    var name=urlParam('name');
    if (name != null) {
            $("#transition").hide();
            $("#transition-two").css("display", "block");
            $('.contenido').hide();
            $('.elige').hide();
            $('#reload-balanace').show();
            // name="DuendeDeLaSuerte712_01";
            var direc="layer-view-image/game/rapitinkas/faces_small/"+name+".jpg";
            $(".label_2").html(fecha_actual());
            generated_game_grid(direc);
    } 
    //
    
    function generated_game_grid(src) {
        var grid = '<div class="boleto_cabecera">' + '<div class="head_title_1">N.</div>' + '<div class="head_title_2">JUGADA</div>' + '<div class="head_title_3" style="left:220px;">ANULAR</div>' + '</div>' + '<div class="row_grid">' + '<div class="column_1">1</div>' + '<div class="column_2" style="left:75px;"><img src="' + src + '"height="50" width="100"></div>' + '<div class="column3" style="left:240px;"><div class="delete"></div></div>' + '</div>';
        $('#game_grid').html(grid)
    }
    

    function urlParam(sParam) {
    	try {
		    var sPageURL = window.location.search.substring(1);
		    var sURLVariables = sPageURL.split('&');
		    for (var i = 0; i < sURLVariables.length; i++) 
		    {
		        var sParameterName = sURLVariables[i].split('=');
		        if (sParameterName[0] == sParam) 
		        {
		            return sParameterName[1];
		        }
		    }
    	}
    	catch(err) {
    		return null;
    	}
		return null;
    }

    
  //SESSION RAPITINKAS
    /*$('#frmLoginClientPuchase').on('submit', function (event) {
    	event.preventDefault();
        var user = $('#user-client').val();
        var pass = $('#password-client').val();
        var valida_session = "", _id = $(this).attr("id");
        if (user == '' || pass == '') {
            jAlert('Complete los datos de usuario')
        } else {
            $.ajax({type: $(this).attr('method'), url: $(this).attr('action'), dataType: 'text', data: $(this).serialize(), success: function (e) {
            	//$('#password-client').val('');
                var resp = $.trim(e);
                var arrresp = resp.split("|");
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
					availableAmount=monto1;
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
                    if(valida_session === 'TC') exe.opentyc(_id);
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
    $('#frmLoginClientIndex').attr('id', 'frmLoginClientRapitinkas').attr('action', 'login_rapitinkas.html');
    $('#frmLoginClientRapitinkas').on('submit', function (event) {
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
				availableAmount=monto1;
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
                if(valida_session === 'TC') exe.opentyc(_id);
                else viewNext();
                /*$('.logout').show();
                $('.unlogout').hide();
                $('#payments_section').show();
                $('#login_section').hide();
                $('#play-panel').show();*/
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
    // var name = "";
    $("#play").on("click", function () {
    	var saldo=$('#available-amount').val();
		if(availableAmount=='null' || availableAmount<1){
		   jAlert('No cuentas con saldo disponible.\nPara continuar carga tu saldo con cualquiera de las opciones.', null)
		}else{
		   resultFash(name);
           $(".rapitinkas").css({"margin-bottom": "0px"});
           $(".font-play").css({"height": "445px"});
		}
    });
    var cadena;

    function callLeftPad(val, size, ch) {
        var result = new String(val);
        if (!ch) {
            ch = ' '
        }
        while (result.length < size) {
            result = ch + result
        }
        return result.toString();
    }

    function NumberTicket(boleto) {
        var ticket = boleto.split("||");
        v_id_edition = callLeftPad(ticket[0], 3, '0');
        v_ticket_book = callLeftPad(ticket[1], 6, '0');
        v_ticket_number = callLeftPad(ticket[2], 3, '0');
        v_result_ticket_leftpad = v_id_edition + '-' + v_ticket_book + '-' + v_ticket_number;
        $("#boleto").html(v_result_ticket_leftpad)
    }

    var c0, c1;

    function value_pay(cad0, cad1) {
        c0 = cad0.split("||");
        c1 = cad1.split("||")
    }


    var NewAmount;
    $(".msg_state").on("click", "#cobro_sal", function () {
        $.ajax({type: "post", url: "pay_rapitinkas_user.html", data: "amount=" + c1[4] + "&editionId=" + c0[0] + "&prizeBook=" + c0[1] + "&prizeNum=" + c0[2], dataType: "text", global: false, async: false, success: function (e) {
            dinero = e.split("||");
            LoadAmount = dinero[0];
            NewAmount = dinero[1];
            $(".label_resu1").text("Monto del premio");
            $("#clientSale-amount").text(NewAmount);
            $(".result1").html("S/. " + floatFormat(LoadAmount));
            $(".result_sal_dis").html("S/. " + floatFormat(NewAmount));
            statePlay(-1, "intralot", "");
            jAlert("Tu premio se ha cargado a tu saldo.", null);
        }})
    });
    function resultFash(p_game) {
        $.ajax({type: "post", url: "play_rapitinkas_user.html", dataType: "text", data: "name=" + p_game, async: false, success: function (data) {
            if (data != '') {
                cadena = data.split("**");
                if (cadena.length > 2 ) {
                    var data = cadena[1];
                    var imgstt = cadena[5];
                    var datasplit = data.split("||");
                    var path = datasplit[0];
                    var face = path + "_" + datasplit[1].leftPad(2);
                    var fonts = datasplit[2];
                    var flashvars = {};
                    NumberTicket(cadena[0]);
                    value_pay(cadena[0], cadena[1]);
                    $(".result_sal_dis").text("S/. " + floatFormat(cadena[3]));
                    $("#clientSale-amount").text(floatFormat(cadena[3]));
                    $("#clientSale-amount-2").text(floatFormat(cadena[3]));
                    flashvars.img = face;
                    flashvars.val = fonts;
                    flashvars.stt = imgstt;
                    var params = {};
                    params.wmode = "transparent";
                    params.bgcolor = "#ffffff";
                    params.allowscriptaccess = "always";
                    var attributes = {};
                    swfobject.embedSWF("layer-view-media/game/rapitinkas/" + path + ".swf", "card", "580", "300", "9.0.28.0", "../../../layer-view-media/game/rapitinkas/expressInstall.swf", flashvars, params, attributes)
                    $('#contenido_three').show();
                    $("#transition").hide();
                    $("#transition-two").hide();
                    $("#transition-three").show();
                    $('#reload-balanace').hide()                	
                } else {
                	jAlert(cadena);
                }
            }
        }});
    }

    $(".msg_state").on("click", "#scrapeAll", function () {
    	
        var data0 = cadena[0];
        var datasplit0 = data0.split("||");
        var parameterId = callLeftPad(datasplit0[0], 3, '0')+callLeftPad(datasplit0[1], 6, '0')+callLeftPad(datasplit0[2], 3, '0');
        var gameId = 249;
         
    	$.ajax({
            type: "post",
            url: "verifyByTicket.html",
            data: "parameterId=" + parameterId + "&gameId=" + gameId,
            dataType: "text",
            global: false,
            async: false,
            success: function (e) {
            	
		        var data = cadena[1];
		        var imgstt = 0;
		        var datasplit = data.split("||");
		        var path = datasplit[0];
		        var face = path + "_" + datasplit[1].leftPad(2);
		        var fonts = datasplit[2];
		        var flashvars = {};
		        var verify = datasplit[3];
		        var v_prize_net = callValidateFormatCurrency(datasplit[4]);
		        var v_prize_printed = callValidateFormatCurrency(datasplit[6]);
		        statePlay(verify, v_prize_printed, v_prize_net);
		        flashvars.img = face;
		        flashvars.val = fonts;
		        flashvars.stt = imgstt;
		        value_pay(cadena[0], cadena[1]);
		        var params = {};
		        params.wmode = "transparent";
		        params.bgcolor = "#FFFFFF";
		        params.allowscriptaccess = "always";
		        var attributes = {};
		        swfobject.embedSWF("layer-view-media/game/rapitinkas/" + path + ".swf", "card", "580", "300", "9.0.28.0", "layer-view-media/game/rapitinkas/expressInstall.swf", flashvars, params, attributes);
		        
            }
        })
    });
    function statePlay(verify, v_prize_printed, v_prize_net) {
        string = "";
        if (verify >= 1) {
            string = '<div class="ganaste">' + '<div style="width:180px">' + '<span style="color: #8D2D92; font-family: arial;font-size: 12px; font-weight: bold;">FELICIDADES GANASTE S/.' + v_prize_net + '&nbsp;&nbsp;</span>' + '</div>' + '<span>Neto a cobrar S/.</span><span>' + v_prize_net + '</span>' + '</div>' + '<div class="btn_cob_rec" style="position: absolute; margin-left: 371px; margin-top: -63px;">' + '<div id="ir_premio"></div>' + '</div>' + '<div class="btn_cob_sal" style="position: absolute; margin-left: 400px; margin-top: -63px;">' + '<div id="cobro_sal"></div>' + '</div>' + '</div>'
        }
        if (verify <= 0) {
            string += '<div class="perdite">';
            if (v_prize_printed == "intralot") {
                string += '<span>Tu premio se ha cargado a tu saldo.</span>'
            } else {
                string += '<span>No ha obtenido premio.</span>'
            }
            string += '</span></div>';
            string += '<div class="jue_nue" style="position: absolute; margin-left: 371px; margin-top: -55px;">' + '<div id="play_again"></div>' + '</div>' + '<div class="nue_dis" style="position: absolute; margin-left: 400px; margin-top: -55px;">' + '<div id="new_design"></div>' + '</div>'
        }
        $(".msg_state").html(string)
    }

    function callValidateFormatCurrency(number) {
        var numberformat = number.toString().replace(/\$|\,/g, '');
        if (isNaN(numberformat))numberformat = '0';
        var sign = (numberformat == (numberformat = Math.abs(numberformat)));
        numberformat = Math.floor(numberformat * 100 + 0.50000000001);
        var cents = numberformat % 100;
        numberformat = Math.floor(numberformat / 100).toString();
        if (cents < 10)cents = '0' + cents;
        for (var i = 0; i < Math.floor((numberformat.length - (1 + i)) / 3); i++)numberformat = numberformat.substring(0, numberformat.length - (4 * i + 3)) + ',' + numberformat.substring(numberformat.length - (4 * i + 3));
        return(((sign) ? '' : '-') + numberformat + '.' + cents)
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

    var op = 0;
    $("#select_option").on("change", function () {
        op = $(this).val();
        if (op == "0") {
            $("#part").removeClass("hide").addClass("show");
            $("#part1").removeClass("show").addClass("hide");
            $("#part2").removeClass("show").addClass("hide");
            $("#part3").removeClass("show").addClass("hide")
        }
        if (op == "1") {
            $("#part1").removeClass("hide").addClass("show");
            $("#part").removeClass("show").addClass("hide");
            $("#part2").removeClass("show").addClass("hide");
            $("#part3").removeClass("show").addClass("hide")
        }
        if (op == "2") {
            $("#part3").removeClass("show").addClass("hide");
            $("#part1").removeClass("show").addClass("hide");
            $("#part").removeClass("show").addClass("hide");
            $("#part2").removeClass("hide").addClass("show")
        }
        if (op == "3") {
            $("#part1").removeClass("show").addClass("hide");
            $("#part").removeClass("show").addClass("hide");
            $("#part2").removeClass("show").addClass("hide");
            $("#part3").removeClass("hide").addClass("show")
        }
    });
    $('#game_grid').on('click', '.delete', function () {
        $("#transition-two").css("display", "none");
        $("#transition").show();
        $('.contenido').show();
        $('.elige').show();
        $('#reload-balanace').hide()
    });
    $('#contenido').on("click", '.imgs', function () {
        $("#transition").hide();
        $("#transition-two").css("display", "block");
        $('.contenido').hide();
        $('.elige').hide();
        $('#reload-balanace').show();
        var src = $(this).attr('src');
        var src_small = src.split("faces");
        var direc = src_small[0] + "faces_small" + src_small[1];
        var v = src_small[1].split("/");
        var value = v[1].split(".");
        name = value[0];
        $(".label_2").html(fecha_actual());
        generated_game_grid(direc)
    });
    $('#option-card-0').on('click', function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $(".super3").css("height", "505px")
    });
    $('#option-card-1').on('click', function () {
        $("#panel_transaccion_1").show();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $(".super3").css("height", "575px")
    });
    $("#option-card-2").on('click', function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").show();
        $("#panel_transaccion_3").hide();
        $(".super3").css("height", "610px")
    });
    $("#option-card-3").on('click', function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "block");
        $(".super3").css("height", "590px")
    });
    $(".msg_state").on("click", "#play_again", function () {
    	jConfirm("Has elegido jugar de nuevo el mismo dise\u00f1o. Se descontar\u00e1 el costo de tu saldo.", null , function(r){
			if(r){
				resultFash(name);
				$(".label_resu1").html("TOTAL PAGADO");
				$(".result1").text("S/. 1.00");
				string = '<div  style="width:275px; margin-left: 25px;">' + '<span>Si una cantidad se repite tres veces, con sola una ganas ese premio.</span>' + '<span style="font-weight:bold;">Gana hasta S/.10,000</span>' + '</div>' + '<div style="position: absolute; margin-left: 371px; margin-top: -47px;">' + '<div id="scrapeAll">' + '</div>' + '</div>';
				$(".msg_state").html(string);
			}
    	})
    });
    $(".msg_state").on("click", "#new_design", function () {
        window.location.href = 'juega-rapitinkas.html'
    });
    $(".msg_state").on("click", "#ir_premio", function () {
        window.location.href = 'mi-cuenta.html#premios'
    })
    
    function viewNext(){
    	$('#password-client-header').val('');
    	$('#password-client').val('');
    	$('.logout').show();
        $('.unlogout').hide();
        $('#payments_section').show();
        $('#login_section').hide();
        $('#play-panel').show();
	}
};
$(Rapitinkas);