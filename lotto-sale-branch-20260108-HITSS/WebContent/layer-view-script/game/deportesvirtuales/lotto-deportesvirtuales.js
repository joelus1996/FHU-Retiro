var $Deportesvirtuales = function () {

    $('#back_previous').remove();
	var saldoUser = $("#saldoUser").val();
    $("#menu-item-5").addClass("current-menu-item");
    var user = '';
    var nickName = '';                   
    var sessionCode = '';
    
    $('.label_2').text(fecha_actual());
    $('#reload-balanace').hide();    
    $('#buy').on('click', function (event) {        
        event.preventDefault();
		if(saldoUser > 2){
		    $("#play").trigger("click")
		}
		$('#transition').removeClass().addClass('transition-two');
        $('#choose-content').hide();
        $('#reload-balanace').fadeIn('slow');
        generated_game_grid("","Fantastic League");
		
    });    
    $('#game_grid').on('click','.delete',function(){
        $('#transition').removeClass().addClass('transition-one');
        $('#reload-balanace').hide();
        $('#choose-content').fadeIn('slow');       
    });
    //SESSION DEPORTES VIRTUALES
    /*$('#frmLoginClientPuchase').on('submit', function (event) {
    	event.preventDefault();
    	 var user = $('#user-client').val();
         var pass = $('#password-client').val();
         var valida_session = "", _id = $(this).attr("id");
         if (user == '' || pass == '') {
             jAlert('Complete los datos de usuario')
         } else {
            $.ajax({
                type: "POST",
                url: "login_deportesvirtuales.html",
                dataType: "text",
                data: $("#frmLoginClient").serialize(),
                success: function (e) {
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
                        user = arrresp[6];
                        nickName = arrresp[7];
                        sessionCode = arrresp[8];
                        var nombrejs = arrresp[10];
                        var apPaternojs = arrresp[11];
                        var apMaternojs = arrresp[12];
                        var mailjs = arrresp[13];
                        var mobilePhonejs = arrresp[14];
                        var countryjs = arrresp[15];
                        var regionjs = arrresp[16];
                        var addressjs = arrresp[17];
                        var typeIdjs = arrresp[18];
                        var numberIdjs = arrresp[19];
                        var controlAmountjs = arrresp[20];
                        var emailjs = arrresp[21];
                        var sessionjs = arrresp[22];
                        $('#user').val(user);
                        $('#nickName').val(nickName);
                        $('#sessionCode').val(sessionCode);     
                        $('#field-balance-amount').html(monto1);
                        if (monto2 == '0.00') {
                            $('.saldo_promocional').html('')
                        } else {
                            $('.saldo_promocional').html('&oacute; de mi saldo promocional S/.' + monto2)
                        }
                        $('#clientId').val(userid);
                        $('#sessionCodeIndex').val(sessionCode);
                        $('#clientSale-name').text(username);
                        $('#clientSale-amount').text(floatFormat(useramount));
                        $('#user-ico').addClass(arrresp[9]);
                        
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
                }
            })
        }
    });*/
    $('#frmLoginClientIndex').attr('id', 'frmLoginClientDeportesvirtuales').attr('action','login_deportesvirtuales.html'); 
    $('#frmLoginClientDeportesvirtuales').on('submit',function (event) {
        event.preventDefault();
        var valida_session = "", _id = $(this).attr("id");
        $.ajax({ type: $(this).attr('method'), url: $(this).attr('action'), dataType: $(this).data('responseType'), data: $(this).serialize(), success: function (e) {
        	//$('#password-client-header').val('');
            var arrresp = $.trim(e).split('|');
            valida_session = arrresp[0];
            if (valida_session === 'OK' || valida_session === 'TC' || valida_session === 'MV' ) {
                var username = arrresp[1];
                var useramount = arrresp[2];
                var userid = arrresp[3];
                var monto1 = floatFormat(arrresp[4]);
                var monto2 = floatFormat(arrresp[5]);
                user = arrresp[6];
                nickName = arrresp[7];                    
                sessionCode = arrresp[8];
                $('#user').val(user);
                $('#nickName').val(nickName);
                $('#sessionCode').val(sessionCode);
                $('#field-balance-amount').text(monto1);
                if (monto2 == '0.00') {
                    $('.saldo_promocional').html('')
                } else {
                    $('.saldo_promocional').html('&oacute; de mi saldo promocional S/.' + floatFormat(monto2))
                }
                $('#clientId').val(userid);
                $('#sessionCodeIndex').val(sessionCode);
                $('#clientSale-name').text(username);
                $('#clientSale-amount').text(floatFormat(useramount));
                $('#user-ico').addClass(arrresp[9]);
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
				//$('#content').css({"height":"482px"});
				$('.img_zona_segura').css({"margin-top":"26px"});
                $('#login_section').hide();
                $('#play-panel').show();*/
            } else if(valida_session === 'CC'  ){
                jAlert(arrresp[1], null);
                $('#user-client-header').focus();
                setCaptcha(true);
            } else {
                jAlert(valida_session, null);
                $('#user-client-header').focus();
            }
        }});
    });
    $('#option-card-0').on('click', function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
		$("#panel_transaccion_4").hide();
		$("#panel_transaccion_5").hide();
		//$('#content').css({"height":"442px"});
    });
    $('#option-card-1').on('click', function () {
        $("#panel_transaccion_1").show();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
		//$('#content').css({"height":"500px"});
		$('.img_zona_segura').css({"margin-top":"0px"});
    });
    $("#option-card-2").on('click', function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "block");
        $("#panel_transaccion_3").css("display", "");
		//$('#content').css({"height":"530px"});
		$('.img_zona_segura').css({"margin-top":"0px"});
    });
    $("#option-card-3").on('click', function () {
        $("#panel_transaccion_1").css("display", "");
        $("#panel_transaccion_2").css("display", "");
        $("#panel_transaccion_3").css("display", "block");
		//$('#content').css({"height":"543px"});
		$('.img_zona_segura').css({"margin-top":"0px"});
    });
    
    var idsession = $('#clientId').val();
    if(idsession != '' && $("#agreement").val() == ''){
    	$('#login_section').show();
		$('.finalize-purchase').css({"min-height":"379px"});
		$('.img_zona_segura').css({"margin-top":"130px"});
    	exe.opentyc(null);
    } else if (idsession == '') {
        $('#login_section').show();
		$('.finalize-purchase').css({"min-height":"379px"});
		$('.img_zona_segura').css({"margin-top":"130px"});
    } else {        
        sessionCode=$("#sessionCodeIndex").val();
        $('#sessionCode').val(sessionCode);        
        $('#login_section').hide();
        $('#play-panel').show();
        $('#payments_section').show();
		//$('#content').css({"height":"482px"});
	    $('.img_zona_segura').css({"margin-top":"26px"});
    }
    
    function generated_game_grid(src,name_game){
        var grid='<div class="boleto_cabecera">' +
            '<div class="head_title_1">N.</div>'+
            '<div class="head_title_2">JUGADA</div>'+
            '<div class="head_title_3">ANULAR</div>'+
            '</div>'+
            '<div class="row_grid">'+
            '<div class="column_1">1</div>'+
            '<div class="column_2"><img src="layer-view-image/game/deportesvirtuales/icon-fantasticleague.jpg" alt="'+name_game+'" height="50" width="51"><span id="name_game">'+name_game+'</span></div>'+
            '<div class="column_3"><div class="delete"></div></div>'+
            '</div>';
        $('#game_grid').html(grid);
    }
    
    function fecha_actual() {
        var f = new Date();
        var mes = "";
        var dia = "";
        var temp_mes = f.getMonth() + "";
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
    
    function viewNext(){
    	$('#password-client-header').val('');
    	$('#password-client').val('');
    	$('.logout').show();
        $('.unlogout').hide();
        $('#payments_section').show();
		$('.img_zona_segura').css({"margin-top":"26px"});
        $('#login_section').hide();
        $('#play-panel').show();
    }
};
$($Deportesvirtuales);