function fecha_actual_game() {
    var f = new Date();
    var mes = "";
    var dia = "";
    var temp_mes = f.getMonth() + "";
    var temp_dia = f.getDate() + "";
    if (temp_mes.length == 1) {
        mes = "0" + (f.getMonth() + 1) + ""
    } else {
        mes = (f.getMonth() + 1) + ''
    }
    if (temp_dia.length == 1) {
        dia = "0" + f.getDate() + ''
    } else {
        dia = f.getDate() + ''
    }
    return dia + "/" + mes + "/" + f.getFullYear()
}

function generated_game_grid_url (src,name_game,gameId) {
		var grid='<div class="boleto_cabecera">' +
        '<div class="head_title_1">N.</div>'+
        '<div class="head_title_2">JUGADA</div>'+
        '<div class="head_title_3">ANULAR</div>'+
        '</div>'+
        '<div class="row_grid">'+
        '<div class="column_1">1</div>'+
        '<div class="column_2"><img src="'+src+'" alt="'+name_game+'" height="50" width="51"><span id="name_game">'+name_game+'</span></div>'+
        '<div class="column_3"><div class="delete"></div></div>'+
        '</div>';			
		$('#transition').show();
		$('#help').show();
		$('#choose-content').css("display","none");
		$('#content').show();
		$('#reload-balanace-games').css("display","block");
		$('#transition').removeClass().addClass('transition-two');
		$('#game_grid').html(grid);
}
var $Clicygana = function () {
    $('#choose-content').hide();
    $('#reload-balanace-games').hide();
    $('#help').hide();
    $('.label_2').html(fecha_actual_game());
    $('#back_previous').remove();

    var idsession = $('#clientId').val();
    if(idsession != '' && $("#agreement").val() == ''){
    	$('#login_section').show();
        $('.finalize-purchase').css({"min-height":"398px"});
        $('.img_zona_segura').css({"margin-top":"127px"});
    	exe.opentyc(null);
    } else if(idsession == '') {
        $('#login_section').show();
        $('.finalize-purchase').css({"min-height":"398px"});
        $('.img_zona_segura').css({"margin-top":"127px"});
    } else {
        sessionCode=$("#sessionCodeIndex").val();
        $('#sessionCode').val(sessionCode);        
        $('#login_section').hide();
        $('#play-panel').show();
        $('#payments_section').show();
        $('.img_zona_segura').css({"margin-top":"0px"});
    }
    $("#menu-item-3").addClass("current-menu-item");
    var user = '';
    var nickName = '';
    var sessionCode='';
    var gameId='';
    $('#reload-balanace').hide();
    $('.label_2').html(fecha_actual());
    $('#scrape-games').hide();
    generate_pagination();
    start_instant_games();
    start_scrape_games();
	
    $('#go-instant-games').on('click', function (event) {
        event.preventDefault();
        $('#scrape-games').hide();
        $('#instant-games').fadeIn('slow');
        start_instant_games();
    });
    $('#go-scrape-games').on('click', function (event) {
        event.preventDefault();
        $('#instant-games').hide();
        $('#scrape-games').fadeIn('slow');
        start_scrape_games();
    });
    $('#menu-instant-games').children('.sub-menu').on('click', function (event) {
        event.preventDefault();
        show_sub_category('instant-games', '#' + $(this).attr('id'));
    });
    $('#menu-scrape-games').children('.sub-menu').on('click', function (event) {
        event.preventDefault();
        show_sub_category('scrape-games', '#' + $(this).attr('id'));
    });
    $('#choose-content').find('.page').on('click', function (event) {
        var pages = $(this).data('pages');
        if (pages > 1) {
            var id = $(this).attr('id');
            var pref_cat = id.substr(2, 1);
            var pref_sub_cat = id.substr(4, 1);
            var page = id.substr(6, 1);
            var sub_cat = '';
            if (pref_cat == 'i') {
                sub_cat = find_sub_category_instant(pref_sub_cat)
            } else {
                sub_cat = find_sub_category_scrape(pref_sub_cat)
            }
            show_page('#' + id, page, pages, sub_cat)
        }
    });
    
    $('#play').on('click', function(){
        $('#scrape-games').hide();
        $('#instant-games').show();
        start_instant_games();
        $('#transition').removeClass().addClass('transition-one');
        $('#choose-content').fadeIn('slow');
        $('#reload-balanace').hide();
		$('#choose-content').hide();
		$('#transition').removeClass().addClass('transition-two');
		$('#transition').show();
		
    });
    
			
    function show_page(id_page, page, pages, sub_cat) {
        $(id_page).parents('.pagination').children('.index_page').text(page + ' de ' + pages);
        $(id_page).parents('.pagination').find('.page').removeClass('page-selected').addClass('page-no-selected');
        $(id_page).removeClass('page-no-selected').addClass('page-selected');
        $(sub_cat).children('.item-game').hide().each(function (index, domEle) {
            if (index >= ((page * 8) - 8) && index < (page * 8)) {
                $(this).fadeIn('fast');
            }
        });
    }

    function find_sub_category_instant(pref_sub_cat) {
        var id_sub_category = '';
        switch (pref_sub_cat) {
            case 'c' :
                id_sub_category = '#i-classic-game';
                break;
            case 'b' :
                id_sub_category = '#i-bingo-game';
                break;
            case 'f' :
                id_sub_category = '#i-fantasy-game';
                break;
            case 'n' :
                id_sub_category = '#i-new-game';
                break;
        }
        return  id_sub_category;
    }

    function find_sub_category_scrape(pref_sub_cat) {
        var id_sub_category = '';
        switch (pref_sub_cat) {
            case 'c' :
                id_sub_category = '#s-classic-game';
                break;
            case 's' :
                id_sub_category = '#s-sports-game';
                break;
            case 'f' :
                id_sub_category = '#s-fantasy-game';
                break;
            case 'n' :
                id_sub_category = '#s-new-game';
                break;
        }
        return  id_sub_category;
    }

    function show_sub_category(cat, item_sub_cat) {
		
        $('#menu-' + cat).children('.sub-menu').removeClass('selected-sub-menu');
        $(item_sub_cat).addClass('selected-sub-menu');
        var sub_cat = $(item_sub_cat).attr('href');
        var pag = '#p-' + sub_cat.substr(1, 3);
        $('#' + cat).find('.tab').hide();
        $(sub_cat).fadeIn('fast');
        show_pagination('#' + cat, pag, 1);
        var pre_sub_cat = sub_cat.substr(1, 3);
        var page_id = "#" + "p-" + pre_sub_cat + "-1";
        var pages = $(page_id).data('pages');
        show_page(page_id, 1, pages, sub_cat);
		
    }

    function generate_pagination() {
        $('#instant-games').find('.sub-menu').each(function () {
            var sub_category = $(this).attr('href');
            pagination_sub_category(sub_category);
        });
        $('#scrape-games').find('.sub-menu').each(function () {
            var sub_category = $(this).attr('href');
            pagination_sub_category(sub_category);
        });
    }

    function pagination_sub_category(sub_category) {
        var num_item = $(sub_category).find('.item-game').length;
        var pages = 0;
        var links = '<span class="content_pages">';
        var cat = sub_category.substr(1, 1);
        if (num_item < 8) {
            pages = 1;
        } else {
            if (num_item % 8 == 0) {
                pages = num_item / 8;
            } else {
                pages = parseInt(num_item / 8);
                pages = pages + 1;
            }
        }
        for (var i = 1; i <= pages; i++) {
            if (pages > 1) {
                if (i == 1) {
                    links += '<a id="p-' + sub_category.substr(1, 3) + '-' + i + '" class="page page-selected" data-pages="' + pages + '">' + i + '</a>';
                }
                else {
                    links += '<a id="p-' + sub_category.substr(1, 3) + '-' + i + '" class="page page-no-selected" data-pages="' + pages + '">' + i + '</a>';
                }
            }
            else {
                links += '<a id="p-' + sub_category.substr(1, 3) + '-' + i + '" class="page page-selected" data-pages="' + pages + '">' + i + '</a>';
            }
        }
        links += '</span>';
        if (cat == 'i') {
            $('#instant-games').find('.tab-container').append('<div id="p-' + sub_category.substr(1, 3) + '" class="pagination" style="display:none;"><span class="index_page">1 de ' + pages + '</span>' + links + '</div>');
        } else {
            $('#scrape-games').find('.tab-container').append('<div id="p-' + sub_category.substr(1, 3) + '" class="pagination" style="display: none;"><span class="index_page">1 de ' + pages + '</span>' + links + '</div>');
        }
    }

    function show_pagination(cat, pag) {
        $(cat).find('.pagination').hide();
        $(pag).show();
    }

    function start_instant_games() {
        $('#i-bingo-game').hide();
        $('#i-fantasy-game').hide();
        $('#i-new-game').hide();
        $('#i-classic').show().addClass('selected-sub-menu');
        show_sub_category('instant-games', '#i-classic');
    }

    function start_scrape_games() {
        $('#s-fantasy-game').hide();
        $('#s-sports-game').hide();
        $('#s-new-game').hide();
        $('#s-classic').show().addClass('selected-sub-menu');
        show_sub_category('scrape-games', '#s-classic');
    }

    //IE
    $('#content').find('.item-game:nth-child(4n)').css('marginRight', 0);

    //-- RECARGA TU SALDO
   
    $('.game').on('click', function (event) {    	
        event.preventDefault();
        gameId=$(this).data('id');
        $('#gameId').val(gameId);
        $('#mode').val('M');
        var name_game=$(this).children('img').attr('alt');
        var src=$(this).children('img').attr('src');
        $('#transition').removeClass().addClass('transition-two');
		$('#transition').show();
        $('#choose-content').hide();
        $('#reload-balanace').fadeIn('slow');
        generated_game_grid(src,name_game);
    });
	
	var gameIdparamGnr= $('#idGameParameter').val();
	if(gameIdparamGnr!='0'){
	/*evaluarIdGame();*/
	param= $('#idGameParameter').val();
	$('.game').each(function(){
		var found = false;
		if($(this).data('id')==param){
		$(this).trigger('click');
		found = true;
		}
		return !found
		});
	}
	else{
	$('#choose-content').show();
	}
	
		
	/*EVALUAR ID*/
	
    function generated_game_grid(src,name_game){
        var grid='<div class="boleto_cabecera">' +
            '<div class="head_title_1">N.</div>'+
            '<div class="head_title_2">JUGADA</div>'+
            '<div class="head_title_3">ANULAR</div>'+
            '</div>'+
            '<div class="row_grid">'+
            '<div class="column_1">1</div>'+
            '<div class="column_2"><img src="'+src+'" alt="'+name_game+'" height="50" width="51"><span id="name_game">'+name_game+'</span></div>'+
            '<div class="column_3"><div class="delete"></div></div>'+
            '</div>';
			$('#reload-balanace-games').css("display","block");
        $('#game_grid').html(grid);
    }
    $('#game_grid').on('click','.delete',function(){
        $('#scrape-games').hide();
		$('#reload-balanace-games').css("display","none");
        $('#instant-games').show();
        start_instant_games();
        $('#transition').removeClass().addClass('transition-one');
		$('#transition').show();
        $('#choose-content').fadeIn('slow');
        $('#reload-balanace').hide();
    });

    //SESSION CLIC Y GANA
    /*$('#frmLoginClientPuchase').on('submit', function (event) {
    	event.preventDefault();
        var user = $('#user-client').val();
        var pass = $('#password-client').val();
        var valida_session = "", _id = $(this).attr("id");
        if (user == '' || pass == '') {
            jAlert('Complete los datos de usuario');
        }
        else {
            $.ajax({type: "POST", url: "login_clicygana.html", dataType: "text", data: $("#frmLoginClient").serialize(), success: function (e) {
            		//$('#password-client').val('');
                    var resp = $.trim(e);
                    var arrresp = resp.split("|");
                    valida_session = arrresp[0];
                    if (valida_session == 'OK' || valida_session === 'TC' || valida_session == 'MV') {
                        var username = arrresp[1];
                        var useramount = arrresp[2];
                        var userid = arrresp[3];
                        //var userid = floatFormat(arrresp[3]);
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
                            $('.saldo_promocional').html('');
                        } else {
                            $('.saldo_promocional').html('&oacute; de mi saldo promocional S/.' + monto2);
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
                        if(valida_session === 'TC') { exe.opentyc(_id); }
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
    
    $('#frmLoginClientIndex').attr('id', 'frmLoginClientClicygana').attr('action','login_clicygana.html');
    $('#frmLoginClientClicygana').on('submit', function (event) {
        event.preventDefault();
        var valida_session = "", _id = $(this).attr("id");
        $.ajax({ type: $(this).attr('method'), url: $(this).attr('action'), dataType: $(this).data('responseType'), data: $(this).serialize(), success: function (e) {
        	//$('#password-client-header').val('');
            var arrresp = $.trim(e).split('|');
            valida_session = arrresp[0];
            if(valida_session === 'OK' || valida_session === 'TC') {
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
                $('#field-balance-amount').html(monto1);
                if (monto2 == '0.00') {
                    $('.saldo_promocional').html('')
                } else {
                    $('.saldo_promocional').html('&oacute; de mi saldo promocional S/.' + monto2);
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
				$('.img_zona_segura').css({"margin-top":"0px"});
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

    $('#option-card-0').on('click', function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
		$('.finalize-purchase').css({"min-height":"398px"});
    });
    $('#option-card-1').on('click', function () {
        $("#panel_transaccion_1").show();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide()
    });
    $("#option-card-2").on('click', function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").show();
        $("#panel_transaccion_3").hide()
    });
    $("#option-card-3").on('click', function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").show()
    });
    function fecha_actual() {
        var f = new Date();
        var mes = "";
        var dia = "";
        var temp_mes = f.getMonth() + "";
        var temp_dia = f.getDate() + "";
        if (temp_mes.length == 1) {
            mes = "0" + (f.getMonth() + 1) + ""
        } else {
            mes = (f.getMonth() + 1) + ''
        }
        if (temp_dia.length == 1) {
            dia = "0" + f.getDate() + ''
        } else {
            dia = f.getDate() + ''
        }
        return dia + "/" + mes + "/" + f.getFullYear()
    }
    
    
    if($("#idTipGameParameter").val() == "0"){
    	$("#play").trigger("click");
	}
    
    function viewNext(){
    	$('#password-client-header').val('');
    	$('#password-client').val('');
    	$('.logout').show();
        $('.unlogout').hide();
        $('#payments_section').show();
		$('.img_zona_segura').css({"margin-top":"0px"});
        $('#login_section').hide();
        $('#play-panel').show();
    }
};
$($Clicygana);

