var your_betJ1 = 0;
var your_betJ2 = 0;
var multiplier_J1 = 1;
var multiplier_J2 = 1;
var total_betJ1 = 0;
var total_betJ2 = 0;
var sum_betJ1 = 0;
var sum_betJ2 = 0;
var earn_upJ1 = 0;
var earn_upJ2 = 0;
var sum_bet = 0;
var total_bet = 0;   
var array_betJ1 = [];
var array_betJ2 = [];
var array_numbers_more = [];
var array_numbers_less = [];
var array_markedJ1 = [];
var array_markedJ2 = [];
var object_ticket=[];
var new_object_ticket=[];
var costoTotalBet = 0;
var status = "";
var num_draw = 1;
var betJ1 = 0;
var betJ2 = 0;
var simple_bet_price = $('#simpleBetPrice').val();

var idTypePlay = "";
var typePlay = "";
//var precioAnterior="";
//var precioAntes="";

$(document).ready(function () {
	
//	precioAnterior=$("#precioAnterior").val();
//	precioAntes=$("#precioAntes").val();
	
	setVariables();
	kineloLastResult();
    minDate();
    
    $(document).delegate('#btn_mobile_comprar_boleto_kinelo', 'click', function () {
    	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
    	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
    	mainValidatePendingsDocsForAproval('lottoKineloComprarBoletoKinelo');
    });
    
    function lottoKineloComprarBoletoKinelo() {
    	var jugadasGratis=$("#quantityGame").val();
		var datos = total_bet;
		var parametros = {
				"total_bet" : total_bet,
				"jugadasGratis":jugadasGratis
		};
		var data = JSON.stringify(parametros);
		$.ajax({
			url: "game_kinelo_play_bet.html",
			cache: false,
			type : 'POST',
			data : data,
			dataType : 'json',
			contentType : 'application/json',
			success: function(json) {
				datalayerMisJugadas('COMPRAR','Mi Boleto','Jugar','Button');
				datalayerCheckout([array_markedJ1,array_markedJ2,null,null],$("#simpleBetPrice").val());
				window.location.href = json.redirect;
			}, error: function(e) {
				console.log('error obteniendo json...')
			}
		});
    }
    
    $(document).delegate('#btn_mobile_jugar_ahora_kinelo_a', 'click', function () {
    	//window.location.href = 'game_kinelo_show_bet.html'
    	jugarKinelo("A","J1");
    });
    
    $(document).delegate('#btn_mobile_jugar_ahora_kinelo_b', 'click', function () {
    	jugarKinelo("B","J2");
    	//window.location.href = 'game_kinelo_show_bet.html'
    });
    
    $(document).delegate('#btn_mobile_last_results', 'click', function () {
    	datalayerResultados(this,'Informativo','Última Jugada Ganadora');
    	window.location.href = 'game_kinelo_last_results.html'
    });
    
    $(document).delegate('#btn_mobile_return_last_results', 'click', function () {
    	window.location.href = 'game_kinelo_show_home.html'
    });
    
    $(document).delegate('#btn_kinelo_delete_consecutive', 'click', function () {
    
    	var total_apagar2=$("#total_apagar2").val();
    	window.location.href = 'game_kinelo_delete_consecutive.html?total_apagar2='+total_apagar2;
    });
     
    $(document).delegate('#btn_mobile_continue', 'click', function () {
    	//window.location.href = 'game_kinelo_show_home.html'
    	var parametros = {
				"num_draw" : num_draw
			};
		var data = JSON.stringify(parametros);
    	$.ajax({
            url: "game_kinelo_add_consecutive.html",
            cache: false,
            type : 'POST',
    		data : data,
    		dataType : 'json',
    		contentType : 'application/json',
            success: function(json) {
            	if(json!=undefined && json!=null && json!=""){
            		window.location.href = json.redirect;
            	}			
            }, error: function(e) {
              console.log('error obteniendo json...')
            }
          });
    });
    
    $(document).delegate('#btn_mobile_agregar_boleto_kinelo', 'click', function () {
    	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
    	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
    	mainValidatePendingsDocsForAproval('lottoKineloAgregarBoletoKinelo');
    });
    
    function lottoKineloAgregarBoletoKinelo() {
    	if (status != 'ACT') return;
		
		if ( your_betJ1 <= 0 && your_betJ2 <= 0 ) {
			message = "No ha realizado ninguna jugada.";
			desplegarModal(message); 
			taggingPopupError(message);
			datalayerErrores('Jugada','Paso 1','Jugar',message);
			return;
		}
		
		if(your_betJ1>array_betJ1.length & your_betJ2>array_betJ2.length){
			message = "Completa los números que quieres acertar en la Jugada A y B";
			datalayerErrores('Jugada','Paso 1','Jugar',message);
			return;
		}
		if(your_betJ1>array_betJ1.length){
			message = "Completa los números que quieres acertar en la Jugada A";
			desplegarModal(message); 
			taggingPopupError(message);
			datalayerErrores('Jugada','Paso 1','Jugar',message);
			return;
		} 
		if(your_betJ2>array_betJ2.length){
			message = "Completa los números que quieres acertar en la Jugada B";
			desplegarModal(message); 
			taggingPopupError(message);
			datalayerErrores('Jugada','Paso 1','Jugar',message);
			return;
		}
		
		var parametros = {
				//"knBetA" : array_betJ1,
				//"knBetB" : array_betJ2,
				"knBetA" : array_markedJ1,
				"knBetB" : array_markedJ2,
				"multiplierBetA": multiplier_J1,
				"multiplierBetB": multiplier_J2,
				"yourBetA": your_betJ1,
				"yourBetB": your_betJ2
		};
		
		var data = JSON.stringify(parametros);
		$.ajax({
			url: "game_kinelo_add_bet.html",
			cache: false,
			type : 'POST',
			data : data,
			dataType : 'json',
			contentType : 'application/json',
			success: function(json) {
				if(json!=undefined && json!=null && json!=""){
					datalayerTinkaJugada('SIGUIENTE','Jugada','Button','Jugar');
					datalayerAddToCart([array_markedJ1,array_markedJ2,null,null],$("#simpleBetPrice").val(),'Jugada');
					window.location.href = json.redirect;
				}			
			}, error: function(e) {
				console.log('error obteniendo json...')
			}
		});
    }
    
    window.addEventListener("message", function(event) {
        if (event.data === "lottoKineloAgregarBoletoKinelo") {
        	lottoKineloAgregarBoletoKinelo(); 
        } else if (event.data === "lottoKineloComprarBoletoKinelo") {
        	lottoKineloComprarBoletoKinelo()
        }
    });
    
    $(document).delegate('#btn_mobile_eliminar_boleto_a', 'click', function () {
    	deleteGame("gameKineloA");
	});
    
    $(document).delegate('#btn_mobile_eliminar_boleto_b', 'click', function () {
    	deleteGame("gameKineloB");
	});
    
    $(document).delegate('#btn_mobile_editar_boleto_a', 'click', function () {
    	editGame("gameKineloA","A","J1");
	});
    
    $(document).delegate('#btn_mobile_editar_boleto_b', 'click', function () {
    	editGame("gameKineloB","B","J2");
	});
   
    $(".close_f").on("click",function(){
		$(".f_error_mensaje").hide();
	});
    
    $('.checkYBA').on('click', function() {
        if(status=='ACT'){
        	$(".f_error_mensaje").hide();
            var play = $(this).attr('id').substr(0, 2);
            var your_bet = parseInt($(this).val());
            $('#' + play).find('.checkYBA').not($(this)).prop('checked', false);
            if (play == 'J1') {
                if ($(this).is(':checked')) {
                    your_betJ1 = your_bet;
                } else {
                    your_betJ1 = 0;
                    clear(play);
                    desplegarModal("Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                    taggingPopupError("Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                    datalayerErrores('Jugada','Paso 1','Jugar',"Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                }
            } else {
                if ($(this).is(':checked')) {
                    your_betJ2 = your_bet;
                } else {
                    your_betJ2 = 0;
                    clear(play);
                    desplegarModal("Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                    taggingPopupError("Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                    datalayerErrores('Jugada','Paso 1','Jugar',"Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                }
            }
            var count = update_array_bet(play);
            if (count > your_bet) {
                clear(play);
                $(this).prop('checked', true);
                if (play == 'J1') {
                    your_betJ1 = your_bet;
                }
                else{
                    your_betJ2 = your_bet;                    
                }
            }
         }
    });
    
    $('.checkYBB').on('click', function() {
	    if(status=='ACT'){
	        var play = $(this).attr('id').substr(0, 2);
	        $('#' + play).find('.checkYBB').not($(this)).prop('checked', false);
	        if (play == 'J1') {
	            if ($(this).is(':checked')) {
	                multiplier_J1 = $(this).val();
	            } else {
	                multiplier_J1 = 1;
	            }
	        } else {
	            if ($(this).is(':checked')) {
	                multiplier_J2 = $(this).val();
	            } else {
	                multiplier_J2 = 1;
	            }
	        }
	        
	     }
    });
    $('.clear').on('click', function() {
        if(status=='ACT'){
        	$(".f_error_mensaje").hide();
            var play = $(this).attr('id').substr(0, 2);
            clear(play);
            datalayerTinkaJugada(this,'Jugada','Button','Jugar');
        }
    });
    $('.random').on('click', function() {
        if(status!='ACT') return;
        
            var val = 0;
            var your_bet = 0;
            var count_random = 0;
            var play = $(this).attr('id').substr(0, 2);
            var your_bet = find_your_bet(play);
            var array_marked = find_array_marked(play);
            var array_marked_tmp = [];
            if (your_bet < array_marked.length) {
                array_marked = [];
            }
            if (your_bet == 0) {
                $('#' + play).find('.checkYBA').prop('checked', false);
                your_bet = Math.floor(Math.random() * (10 - 1 + 1)) + 1;
                $('#' + play).find('#' + play + 'YBAcheck_' + your_bet).prop('checked', true);
            }
            if (array_marked.length > 0) {
                clear_unmarket(play);
            } else {
                $('#' + play).find('.check').prop('checked', false);
            }
            while (count_random < your_bet) {
                var random = Math.floor(Math.random() * (80 - 1 + 1)) + 1;
                $('#' + play).find('.check').each(function() {
                    if (random == $(this).val() && !$(this).is(':checked')) {
                        $(this).prop('checked', true);
                        count_random++;
                    }
                });
            }
            update_your_bet(play, your_bet);
            update_array_bet(play);
            
            if (play == 'J1') {
            	update_array_marked(play, array_betJ1);
            }else{
            	update_array_marked(play, array_betJ2);
            }
            
            taggingClicAzar();
        datalayerTinkaJugada(this,'Jugada','Button','Jugar');
        
    });
    $('.check').on('click', function() {
        if(status=='ACT'){
        	$(".f_error_mensaje").hide();
            var id = $(this).attr('id');
            var play = id.substr(0, 2);
            var count = 0;
            var your_bet = 0;
            your_bet = find_your_bet(play);
            if (your_bet > 0) {
                if ($(this).is(':checked')) {
                    $(this).prop('checked', true);
                    count = update_array_bet(play);
                    if (count <= your_bet) {
                        add_array_marked(play, $(this).val());
                    } else {
                        $(this).prop('checked', false);
                        delete_array_marked(play, $(this).val());
                        desplegarModal("Se ha completado tu apuesta. Has elegido acertar un máximo de " + your_bet + " números");
                        taggingPopupError("Se ha completado tu apuesta. Has elegido acertar un máximo de " + your_bet + " números");
                        datalayerErrores('Jugada','Paso 1','Jugar',"Se ha completado tu apuesta. Has elegido acertar un máximo de " + your_bet + " números");
                    }
                } else {
                    $(this).attr('checked', false);
                    update_array_bet(play);
                    delete_array_marked(play, $(this).val());
                }
            } else {
                $(this).prop('checked', false);
                desplegarModal("Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                taggingPopupError("Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
                datalayerErrores('Jugada','Paso 1','Jugar',"Deberás elegir antes ¿cuántos números quieres acertar?  Y luego tus números.");
            }
          
         }
    });
    

    $('.chk-area').on('click', function() {
        jQuery("input[name='consecutive']").each(function() {
        	$(this).prop('checked', false);
        	$(this).parent().parent().removeClass("consecutive-seleccionado");
		});
        $(this).find("input").prop('checked', true);
        $(this).addClass("consecutive-seleccionado");
        num_draw = $(this).find("input").val();
    });
    
    $(document).delegate('#security_login_execute_authentication_kinelo', 'click', function () {
    	var datos = total_bet;
    	var parametros = {
				"total_bet" : total_bet
			};
		var data = JSON.stringify(parametros);
		$.ajax({
            url: "game_kinelo_total_bet.html",
            cache: false,
            type : 'POST',
    		data : data,
    		dataType : 'json',
    		contentType : 'application/json',
            success: function(json) {
            	goSecurityLoginExecute('kinelo');
            }, error: function(e) {
              console.log('error obteniendo json...')
            }
          });
        
    });
    
});

function goSecurityLoginExecute(game) {
	getFastTokenAndRedirect(game);
    //window.location.href = 'security_login_execute_authentication.html?display=' + game;
}

function setVariables(){
	
	var status_tmp = $('#status').val();
	var array_betJ1_tmp = $('#gameKineloA').val();
	var array_betJ2_tmp = $('#gameKineloB').val();
	var consecutive_checkbox_1 = $('#consecutive_checkbox_1').val();
	var view = $('#view').val();
	num_draw = $('#num_draw').val();
	if(status_tmp!=undefined && status_tmp!=null && status_tmp!=""){
		status = status_tmp;
	}
	if(array_betJ1_tmp!=undefined && array_betJ1_tmp!=null && array_betJ1_tmp!="" && array_betJ1_tmp.length>2){
		array_betJ1 = array_betJ1_tmp.replace("[","").replace("]","").split(",");
		array_markedJ1 = array_betJ1;
		betJ1 = 1;
	}
	if(array_betJ2_tmp!=undefined && array_betJ2_tmp!=null && array_betJ2_tmp!="" && array_betJ2_tmp.length>2){
		array_betJ2 = array_betJ2_tmp.replace("[","").replace("]","").split(",");
		array_markedJ2 = array_betJ2;
		betJ2 = 1;
	}
	if(consecutive_checkbox_1!=undefined && consecutive_checkbox_1!=null && consecutive_checkbox_1!="" && consecutive_checkbox_1==1){
		 $('#consecutive_checkbox_1').prop( "checked" , true);
		 $('#consecutive_checkbox_1').parent().parent().addClass("consecutive-seleccionado");
		 num_draw = 1;
	}
	if(view=="shoppingcart"){
		multiplier_J1 = parseInt($('#multiplierBetA').val());
		multiplier_J2 = parseInt($('#multiplierBetB').val());
		your_betJ1 = parseInt($('#yourBetA').val());
		your_betJ2 = parseInt($('#yourBetB').val());
		calculate_bet();
	}	
	if(view=="bet"){
		var your_betJ1_tmp =  $('#yourBetA').val();
		var your_betJ2_tmp =  $('#yourBetB').val();
		var multiplier_J1_tmp = $('#multiplierBetA').val();
		var multiplier_J2_tmp = $('#multiplierBetB').val();
		
		idTypePlay = $('#idTypePlay').val();

		typePlay = $('#typePlay').val();
		if(your_betJ1_tmp!=undefined && your_betJ1_tmp!=null && your_betJ1_tmp!=""){
			your_betJ1 = parseInt(your_betJ1_tmp);
		}
		if(your_betJ2_tmp!=undefined && your_betJ2_tmp!=null && your_betJ2_tmp!=""){
			your_betJ2 = parseInt(your_betJ2_tmp);
		}
		if(multiplier_J1_tmp!=undefined && multiplier_J1_tmp!=null && multiplier_J1_tmp!=""){
			multiplier_J1 = parseInt(multiplier_J1_tmp);
		}
		if(multiplier_J2_tmp!=undefined && multiplier_J2_tmp!=null && multiplier_J2_tmp!=""){
			multiplier_J2 = parseInt(multiplier_J2_tmp);
		}
		
		var id = $('.plays').attr('id');
		clear(id);
		if(typePlay=="A" && array_betJ1_tmp!=undefined && array_betJ1_tmp!=null && array_betJ1_tmp!="" && array_betJ1_tmp.length>2){
			array_betJ1 = array_betJ1_tmp.replace("[","").replace("]","").split(",");
			array_markedJ1 = array_betJ1;
			if(your_betJ1_tmp!=undefined && your_betJ1_tmp!=null && your_betJ1_tmp!=""){
				your_betJ1 = parseInt(your_betJ1_tmp);
			}
			if(multiplier_J1_tmp!=undefined && multiplier_J1_tmp!=null && multiplier_J1_tmp!=""){
				multiplier_J1 = parseInt(multiplier_J1_tmp);
			}
			$('#J1YBAcheck_' + array_betJ1.length).prop('checked', true);
			$('#J1YBBcheck_' + multiplier_J1).prop('checked', true);
			$.each(array_betJ1, function(i) {
				$('#J1check_' + $.trim(array_betJ1[i])).prop('checked', true);
			});
		}else if(typePlay=="B" && array_betJ2_tmp!=undefined && array_betJ2_tmp!=null && array_betJ2_tmp!="" && array_betJ2_tmp.length>2){
			array_betJ2 = array_betJ2_tmp.replace("[","").replace("]","").split(",");
			array_markedJ2 = array_betJ2;
			if(your_betJ2_tmp!=undefined && your_betJ2_tmp!=null && your_betJ2_tmp!=""){
				your_betJ2 = parseInt(your_betJ2_tmp);
			}
			if(multiplier_J2_tmp!=undefined && multiplier_J2_tmp!=null && multiplier_J2_tmp!=""){
				multiplier_J2 = parseInt(multiplier_J2_tmp);
			}
			$('#J2YBAcheck_' + array_betJ2.length).prop('checked', true);
			$('#J2YBBcheck_' + multiplier_J2).prop('checked', true);
			$.each(array_betJ2, function(i) {
				$('#J2check_' + $.trim(array_betJ2[i])).prop('checked', true);
			});
		}
	}
}

function calculate_bet() {
	
    var draw = 1;
    if(num_draw!=undefined && num_draw!=null && num_draw>0){
    	draw = num_draw;
    }
    var total_earn_up = 0;
    if(your_betJ1>0){
    	var val_earn_up = find_earn_up(your_betJ1);
    	total_betJ1 = (simple_bet_price * multiplier_J1);
    	sum_betJ1 = 1;
    	
    	if (your_betJ1 == 9) {
            if (multiplier_J1 > 20) {
                earn_upJ1 = 25 * val_earn_up;
            } else {
                earn_upJ1 = multiplier_J1 * val_earn_up;
            }
        } else if (your_betJ1 == 10) {
            if (multiplier_J1 > 5) {
                earn_upJ1 = 10 * val_earn_up;
            } else {
                earn_upJ1 = multiplier_J1 * val_earn_up;
            }
        } else {
            earn_upJ1 = multiplier_J1 * val_earn_up;
        }
    	
    }else{
    	total_betJ1 = 0;
    	earn_upJ1 = 0;
    	sum_betJ1 = 0;
    }
    
    if(your_betJ2>0){
    	var val_earn_up = find_earn_up(your_betJ2);
    	total_betJ2 = (simple_bet_price * multiplier_J2);
        sum_betJ2 = 1;
        if (your_betJ2 == 9) {
            if (multiplier_J2 > 20) {
                earn_upJ2 = 25 * val_earn_up;
            } else {
                earn_upJ2 = multiplier_J2 * val_earn_up;
            }
        } else if (your_betJ2 == 10) {
            if (multiplier_J2 > 5) {
                earn_upJ2 = 10 * val_earn_up;
            } else {
                earn_upJ2 = multiplier_J2 * val_earn_up;
            }
        } else {
            earn_upJ2 = multiplier_J2 * val_earn_up;
        }
    }else{
    	total_betJ2 = 0;
    	earn_upJ2 = 0;
    	sum_betJ2 = 0;
    }

    total_bet = (total_betJ1 + total_betJ2) * draw;
    total_earn_up = earn_upJ1 + earn_upJ2;
    if(total_earn_up>1000000){total_earn_up=1000000;}
    sum_bet = sum_betJ1 + sum_betJ2;
    
//    var precioDes="";

    if(total_bet>0){
 
    	$('#total_bet').html(sum_bet);
    	$('#total_bet2').val(sum_bet);
        $('#total_apagar').html(floatFormat(total_bet));
        $('#total_apagar2').val(floatFormat(total_bet));
        
        $('#jugadaA').val(floatFormat(total_betJ1*draw));
        $('#jugadaB').val(floatFormat(total_betJ2*draw));
        
        $('#earn_up').html(floatFormat(total_earn_up));
        
//        if(precioAnterior!="null"){
//        	  precioDes= precioAnterior-total_bet;
//              $('#precioDes').val(precioDes);
//        }
//        else if(precioAntes!="null"){
//        	precioDes=precioAntes-total_bet;
//        	$('#precioDes').val(precioDes);
//        }
      
        
    }else{
    	$('#total_bet').html("0");
        $('#total_apagar').html("0.00");
        $('#earn_up').html("0.00");
    }

    if( $('#quantityGame').val() >= total_bet ){
    	$('#total_apagar').html(floatFormat(0));
    	$('#price-message').html('S/ 0.00');
    }else{
    	$('#total_apagar').html(floatFormat(total_bet));
    	$('#price-message').html('S/ '+$('#simpleBetPrice').val());
    }
    
    
    
}   

function jugarKinelo(typePlay,idTypePlay){
	var parametros = {
			"typePlay" : typePlay,
			"idTypePlay" : idTypePlay
		};
	var data = JSON.stringify(parametros);
	$.ajax({
        url: "game_kinelo_show_bet_set_data.html",
        cache: false,
        type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json',
        success: function(json) {
        	if(json!=undefined && json!=null && json!=""){
        		datalayerMisJugadas('JUGADA '+typePlay,'Mi Boleto','Jugar','Button');
        		window.location.href = json.redirect;
        	}			
        }, error: function(e) {
          console.log('error obteniendo json...')
        }
     });
}

function deleteGame(game){
	var lastDelete="";
	if(game==="gameKineloA"){
		lastDelete=$("#jugadaA").val();
	}
	if(game==="gameKineloB"){
		lastDelete=$("#jugadaB").val();
	}
	
	var parametros = {
			"gameKinelo" : game,
			"lastDelete" :lastDelete
		};
	var data = JSON.stringify(parametros);
	$.ajax({
        url: "game_kinelo_delete_bet.html",
        cache: false,
        type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json',
        success: function(json) {
        	if(json!=undefined && json!=null && json!=""){
        		datalayerRemoveFromCart([array_markedJ1,array_markedJ2,null,null],$("#simpleBetPrice").val(),'Mi Boleto');
        		window.location.href = json.redirect;
        	}			
        }, error: function(e) {
          console.log('error obteniendo json...')
        }
     });
}

function editGame(game,typePlay,idTypePlay){
	var parametros = {
			"typePlay" : typePlay,
			"idTypePlay" : idTypePlay
		};
	var data = JSON.stringify(parametros);
	$.ajax({
        url: "game_kinelo_show_bet_set_data.html",
        cache: false,
        type : 'POST',
		data : data,
		dataType : 'json',
		contentType : 'application/json',
        success: function(json) {
        	if(json!=undefined && json!=null && json!=""){
        		window.location.href = json.redirect;
        	}			
        }, error: function(e) {
          console.log('error obteniendo json...')
        }
     });
}

function delete_array_marked(play, val) {
    if (play == 'J1') {
        for ( var i = 0; i < array_markedJ1.length; i++) {
            if ($.trim(array_markedJ1[i]) == val) {
                array_markedJ1.splice(i, 1);
            }
        }
    } else {
        for ( var i = 0; i < array_markedJ2.length; i++) {
            if ($.trim(array_markedJ2[i]) == val) {
                array_markedJ2.splice(i, 1);
            }
        }
    }
}

function add_array_marked(play, val) {
    if (play == 'J1') {
        for (i = 0; i < array_markedJ1.length; i++) {
            if ($.trim(array_markedJ1[i]) == val) {
                return;
            }
        }
        array_markedJ1.push(val);
        return;
    } else {
        for ( var i = 0; i < array_markedJ2.length; i++) {
            if ($.trim(array_markedJ2[i]) == val) {
                return;
            }
        }
        array_markedJ2.push(val);
        return;
    }
}

function update_array_marked(play, array_marked) {
    if (play == 'J1') {
        array_markedJ1 = array_marked;
    } else {
        array_markedJ2 = array_marked;
    }
}

function find_your_bet(play) {
    if (play == 'J1') {
        return your_betJ1;
    } else {
        return your_betJ2;
    }
}

function find_array_marked(play) {
    if (play == 'J1') {
        return array_markedJ1;
    } else {
        return array_markedJ2;
    }
}

function clear_unmarket(play) {
    var count = 0;
    var op = false;
    var array_marked = find_array_marked(play);
    $('#' + play).find('.check').each(function() {
        var val = $(this).val();
        for ( var i = 0; i < array_marked.length; i++) {
            if (val == $.trim(array_marked[i])) {
                op = true;
                break;
            }
            op = false;
        }
        if (op) {
            $(this).prop('checked', false);
        }
    });
}

function update_your_bet(play, your_bet) {
    if (play == 'J1') {
        your_betJ1 = your_bet;
    } else {
        your_betJ2 = your_bet;
    }
}

function update_array_bet(play) {
    var count = 0;
    var array_bet = [];  
    if(play=='J1'){
        array_betJ1 = [];
    }
    else{
        array_betJ2 = [];
    }       
    $('#' + play).find('.check').each(function() {
        if ($(this).is(':checked')) {
            if (play == 'J1') {
                array_betJ1.push($(this).val());
                array_bet = array_betJ1;
            } else {
                array_betJ2.push($(this).val());
                array_bet = array_betJ2;
            }
            count++;
        }
    });
    show_array(play, array_bet);
    return count;
}

function show_array(play, array_bet) {
    array_bet.sort(function(a, b) {
        return b - a;
    });
    array_bet.reverse();
//    $("#" + play + "-text-area").val(array_bet);
}

function clear(play) {
    $('#' + play).find('.check').prop('checked', false);
    $('#' + play).find('.checkYBA').prop('checked', false);
    $('#' + play).find('.checkYBB').prop('checked', false);
//    $('#earn_up').html(0);
    if (play == 'J1') {
        your_betJ1 = 0;
        multiplier_J1 = 1;
        array_betJ1 = [];
        array_markedJ1 = [];
    } else {
        your_betJ2 = 0;
        multiplier_J2 = 1;
        array_betJ2 = [];
        array_markedJ2 = [];
    }
    update_array_bet(play);
    
}

function find_earn_up(your_bet) {
    var earn_up = 0;
    switch (parseInt(your_bet)) {
    case 1:
        earn_up = 3;
        break;
    case 2:
        earn_up = 6;
        break;
    case 3:
        earn_up = 25;
        break;
    case 4:
        earn_up = 120;
        break;
    case 5:
        earn_up = 380;
        break;
    case 6:
        earn_up = 2000;
        break;
    case 7:
        earn_up = 5000;
        break;
    case 8:
        earn_up = 20000;
        break;
    case 9:
        earn_up = 50000;
        break;
    case 10:
        earn_up = 100000;
        break;
    }
    return earn_up;
}

function getLastResultsByFecha(){
	var fecha = $("#fecha").val();
	var hora = $("#hora").val();
	
	if(fecha!=undefined && fecha!=null && fecha!=""){
		$("#fecha").removeClass("select-itm-fecha");
		$("#fecha").addClass("select-fecha");
	}
	
	if(fecha!=undefined && fecha!=null && fecha!="" && 
			hora!=undefined && hora!=null && hora!="" && hora!="0"){
		
		var parametros = {
				"fecha" : fecha,
				"hora" : hora
			};
		var data = JSON.stringify(parametros);
        $.ajax({
            url: "showLastResultsByFechaJson.html",
            cache: false,
            type : 'POST',
    		data : data,
    		dataType : 'json',
    		contentType : 'application/json',
            success: function(json) {
            	if(json!=undefined && json!=null && json!=""){
            		
            	    var anio = fecha.substring(0, 4);
            	    var mes = fecha.substring(5, 7);
            	    var dia = fecha.substring(8, 10);
            	    $("#resultadosdel").html("Resultados del");
            	    $("#filtro").html(dia+"-"+mes+"-"+anio+" / "+hora+" HRS");
            	    var todo = "";
            		$.each(json.listado, function(i, draw) {
                        todo += '<div class="info-resultado">\
							<p class="info-resultado-sorteo">Sorteo '+draw.drawPk.drawId+' / '+ draw.additional + ' HRS</p>\
							<span>'+draw.result+'</span>\
                        </div>';
    				});
            		$('#resultados').html(todo);
            	}			
            }, error: function(e) {
              console.log('error obteniendo json...')
            }
          });
	}else{
		 $("#resultadosdel").html("");
		 $("#filtro").html("");
		 $("#resultados").html("");
		 
	}
}

function minDate(){
	var fecha = document.getElementById('fecha');
	if(fecha!=undefined){
		var date = new Date();
		date.setDate(date.getDate() - 30);
		var anio = date.getFullYear();
		var mes = date.getMonth()+1;
		var dia = date.getDate();
		if(mes<10){
			mes = "0"+mes;
		}
		fecha.setAttribute("min", anio+"-"+mes+"-"+dia);
	}	
}

function kineloLastResult(){
    $.ajax({
        url: "showLastResultsJson.html",
        cache: false,
        type : 'POST',
		contentType : 'application/json',
        success: function(res) {
        	if(res!=undefined && res!=null && res!="" && res.draw!=undefined){
	            $("#draw").html("SORTEO "+res.draw+" "+res.hour+" HRS");
	            var bolos = printKineloBalls(res.bolos.split(' '));
	            $("#bolos").html(bolos);
        	}else{
        		$("#lastDraw").html("");
        	}
        }, error: function(e) {
          console.log('error obteniendo json...')
        }
      });
}

function printKineloBalls(balls) {
    var html = "";
    for (var i = 0; i < balls.length; i++) {
        if (balls[i]) {
            html += '<li><div class="ball_st_home ball_large">' + balls[i] + '</div></li>';
        }
    }
    return html;
}


function desplegarModal(mensaje){
	$(".f_error_mensaje").show();
	$(".f_textoInterno").html(mensaje);				
}

function floatFormat(number) {
	  number = number += '';
	  var x1 = '',
	    x2 = '',
	    rgx = /(\d+)(\d{3})/;
	  if (number !== '') {
	    var x = number.split('.');
	    x1 = x[0];
	    if (x[1] != undefined) {
	      x[1] = x[1].length < 2 ? x[1] + '0' : x[1]
	    } else {
	      x[1] = '00'
	    }
	    x2 = x.length > 1 ? '.' + x[1] : '';
	    while (rgx.test(x1)) {
	      x1 = x1.replace(rgx, '$1' + ',' + '$2')
	    }
	  }
	  return x1 + x2
	}