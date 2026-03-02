// variables
let jugadas = {
  jugada_A: { id: 'A', bolillas: [], totalJugada: 0, check: true },
  jugada_B: { id: 'B', bolillas: [], totalJugada: 0, check: false },
  jugada_C: { id: 'C', bolillas: [], totalJugada: 0, check: false },
  jugada_D: { id: 'D', bolillas: [], totalJugada: 0, check: false }
};

let totalJugadas = 0;
let totalPrecio = 0.00;
let consecutive = $('#game-consecutive option:selected').val().split('_');


const bolillasMinima = parseInt($("#bolillasMinima").val());
const n_bolillas = parseInt($("#n_bolillas").val());
const limiteJugadas = parseInt($("#limiteJugadas").val());
const precio = parseFloat($("#precioRegular").val().match(/\d+(\.\d+)?/)[0]);

const bets = $("#bets").val();
const pay = $("#pay").val();
const cost = $("#cost").val();
const draw = $("#draw").val();
const algorithm = $("#algorithm").val();

let algoritmos = {
	    BETS: () => callTransformByBets(totalJugadas, parseInt(consecutive[0]), precio, bets, pay),
	    COST: () => callTransformByCost(totalJugadas, parseInt(consecutive[0]), precio, bets, cost),
	    DRAW: () => callTransformByDraws(totalJugadas, parseInt(consecutive[0]), precio, draw, pay),
	    ESC: () => callTransformByEsc(totalJugadas, parseInt(consecutive[0]), precio, draw, pay),
	    default: () => calculateDefaultTotalPrecio(totalJugadas, parseInt(consecutive[0]), precio)
	};

// funcionalidades desde el front

// regresar a Tinka Home
$(document).on( 'click', '#game_tinka_show_menu',function(e){
	e.preventDefault();
	window.location.href ='game_tinka_show_menu.html';
});

//borra las bolillas marcadas
$(document).on( 'click', '#clean', function() {
	
	$(".f_error_mensaje").hide();
	
	limpiarBolillasJugadaCheck();

	calcularTotalJugadas();
	 
	datalayerTinkaJugada(this,'Elige '+bolillasMinima+' números o más','Button','Jugar');
	
	$("#contenedor_buttons_check").hide();
});

//marcar las bolillas al azar
$(document).on('click', '#azar', function() {
	
	$(".f_error_mensaje").hide();
    
    // remover las bolillas marcadas
	limpiarBolillasJugadaCheck();
    
    //marcar las bolillas al azar
    var array_random = new Array();
    for(let i=0;i<bolillasMinima;i++){
    	var number = randomBolilla(array_random);
    	array_random.push(number);
        $("#tk_chk_"+number).prop('checked', true);
    }
    
    agregarBolillasJugadaCheck(array_random);
    
	calcularTotalJugadas();

    taggingTinkaAzar();
    datalayerTinkaJugada(this,'Elige '+bolillasMinima+' números o más','Button','Jugar');
    
    $("#contenedor_buttons_check").show();
});

$(document).on( 'click', '#btn_eliminar_check', function() {
	$("#clean").click();
	
	if(jugadas.jugada_A.bolillas.length == 0 
			&& jugadas.jugada_B.bolillas.length == 0
			&& jugadas.jugada_C.bolillas.length == 0
			&& jugadas.jugada_D.bolillas.length == 0){
		eliminarJugadasSession(jugadas);
	}
});

//marcar una bolilla
$(document).on('click', 'input[type=checkbox]', function() {
	let numeroBolilla = parseInt($(this).val());
	if ($(this).is(':checked')) {
	    agregarBolillasJugadaCheck([numeroBolilla]);
	 }else{
		 eliminarBolillaJugadaCheck(numeroBolilla);
	 }
	
	 calcularTotalJugadas();

});

// cambiar de jugada
$(document).on( 'click', '.btnAddJugada button' , function() {
	
	//validar si la jugada antes de cambiar tiene jugadas o no
	var jugadaCheck = obtenerJugadaCheck();
	
	jugadaCheck.check = false;
	
	if(jugadaCheck.bolillas.length < bolillasMinima){
		jugadaCheck.bolillas = [];
		jugadaCheck.totalJugada = 0;
		$('#' + 'btnJugada' + jugadaCheck.id).show();
	}else{
		$('#' + 'jugada' + jugadaCheck.id).show();
	}
		
	// cambiando de jugada
	let btnId = $(this).attr('id');
	let jugada = btnId.substring('btnJugada'.length);
	$('.jugada-tinka').text(jugada);
	
	jugadas['jugada_' + jugada].check = true;
	
	limpiarBolillasJugadaCheck();
	
	$(".btnAddJugada #"+btnId).hide();
	
	// solo 1 jugada puede estar vacia para ocultar el div de botones de agregar jugadas
	ocultarDivButtonsAgregarJugadas(Object.keys(jugadas).length - 1);
	
});

// editar la jugada elegida
$(document).on('click', '#jugadaA_editar , #jugadaB_editar , #jugadaC_editar , #jugadaD_editar', function() {

	//validar si la jugada antes de cambiar tiene jugadas o no
	var jugadaCheck = obtenerJugadaCheck();
	
	jugadaCheck.check = false;

	if(jugadaCheck.bolillas.length < bolillasMinima){
		jugadaCheck.bolillas = [];
		jugadaCheck.totalJugada = 0;
		$('#' + 'btnJugada' + jugadaCheck.id).show();
	}else{
		$('#' + 'jugada' + jugadaCheck.id).show();
	}
		
	// cambiando de jugada
	id = $(this).attr('id');
	jugada = id.split('_')[0].split('jugada')[1];
	$('.jugada-tinka').text(jugada);
	
	jugadas['jugada_' + jugada].check = true;
	
	$("input[type=checkbox]:checked").prop('checked', false);

	// seleccionando las bolillas de la jugada
	for (var i = 0; i < jugadas['jugada_' + jugada].bolillas.length; i++) {
		$("#tk_chk_" + jugadas['jugada_' + jugada].bolillas[i]).prop('checked', true);
	}

	imprimirTextJugadaCheck(jugadas['jugada_' + jugada].bolillas.join(', '));

	//ocultamos la Jugada donde permite editar y eliminar
	$('#' + 'jugada' + jugada).hide();

	// todas las jugadas deben estar completas para ocultar div de botones de agregar jugadas
	ocultarDivButtonsAgregarJugadas(jugadas.length);

	
});

// eliminar la jugada elegida
$(document).on('click', '#jugadaA_eliminar , #jugadaB_eliminar , #jugadaC_eliminar , #jugadaD_eliminar', function() {
	
	id = $(this).attr('id');
	jugada = id.split('_')[0].split('jugada')[1];

	eliminarJugada(jugadas['jugada_' + jugada]);	
});


function eliminarJugada(jugada){
	jugada.bolillas = [];
	jugada.totalJugada = 0;
	
	$("#agregarMasJugada").show();
	$('#' + 'btnJugada' + jugada.id).show();
	$('#' + 'jugada' + jugada.id).hide();
	
	calcularTotalJugadas();
	
	if(jugadas.jugada_A.bolillas.length == 0 
			&& jugadas.jugada_B.bolillas.length == 0
			&& jugadas.jugada_C.bolillas.length == 0
			&& jugadas.jugada_D.bolillas.length == 0){
		eliminarJugadasSession(jugadas);
	}
}

function eliminarJugadasSession(jugadas){
	$.ajax({
        type: "POST", url: "game-tinka-delete-jugada.html", dataType: "json", async: false,
        data: { jugadas: JSON.stringify(jugadas)},
        success: function (response) {
        	// console.log("game-tinka-delete-jugada",response);
        },
        error: function(e){
        	// console.error("game-tinka-delete-jugada",e);
        }
	});
}

//  se cambia la consecutiva y vuelve a calcular precio
$('#game-consecutive').on('change', function() {
	
	consecutive = $(this).val().split('_');
	
	$("#consecutive-text").text('Consecutivo de '+consecutive[0]+' hasta '+consecutive[1]);
	
	calcularTotalPrecio();

});

// comprar
$(document).on('click', '#btn_mobile_comprar_tinka', function() {

	if(totalJugadas == 0 ){
		desplegarModal('Debes tener al menos 1 jugada');
		return;
	}
	
	$.ajax({
        type: "POST", url: "game-tinka-add-jugadas.html", dataType: "json", async: false,
        data: { jugadas: JSON.stringify(jugadas) , consecutive: consecutive[0] },
        success: function () {
        	if( loginUsuarioOk() )
        		window.location.href = 'game_tinka_play_bet_result.html';
        	else
        		//se modifica display para tinkaexpress
        		goSecurityLoginExecuteTE('tinka_express', jugadas, consecutive[0]);
        },
        error: function(e){
        	window.location.href = 'game_tinka_show_shoppingcart.html';
        }
	});
	
});

// ciera el modal que se mostro
$(".close_f").on("click",function(){
	$(".f_error_mensaje").hide();
});

// despliega el modal
function desplegarModal(mensaje){
	$(".f_error_mensaje").show();
	$(".f_textoInterno").html(mensaje);				
}

// imprime tanto en la jugada-check y en el div de jugada resumen
function imprimirJugadaCheck(jugadaCheck){

	// 	ordenamos la jugada ascendentemente
	jugadaCheck.bolillas.sort((a, b) => a - b);
	
	// agergamos "__" si las bolillas de la jugada son menor a las bolillas minimas
	let numEspaciosAgregar = Math.max(0, bolillasMinima - jugadaCheck.bolillas.length) ;
	let arrayDeEspacios = Array(numEspaciosAgregar).fill('__') ;
	let textBolillas = jugadaCheck.bolillas.concat(arrayDeEspacios);

	// convertimos el array textBolillas para imprimirlo con "," en el front
	textBolillas = textBolillas.join(', ');
	imprimirTextJugadaCheck(textBolillas); 
	
	$("#jugada"+jugadaCheck.id + " .text-body").text('JUGADA ' + jugadaCheck.id);
	$("#jugada"+jugadaCheck.id + " .heading-3").text(textBolillas);
	
}


// funcion logicas

// ocultar el div de los botones de "agregar jugadas"
function ocultarDivButtonsAgregarJugadas(totalJugadasAVerificar){
	// obtenemos las jugadas con bolillas
	let jugadasConBolillas = Object.values(jugadas).filter(function(jugada) {
        return jugada.bolillas.length > 0;
    });

    let ocultarDivButtons = jugadasConBolillas.length >= totalJugadasAVerificar;

	if( ocultarDivButtons ) $("#agregarMasJugada").hide();
	else $("#agregarMasJugada").show();
}

//generador de bolillas random
function randomBolilla(array_random){
	let numero = 0;
	do{
		numero = Math.floor(Math.random() * n_bolillas) + 1;
	}while(array_random.indexOf(numero) != -1);
	
	return numero;
}

// funcion eliminar una bolilla de la jugada que esta en true
function eliminarBolillaJugadaCheck(bolillaEliminar){
	
	var jugadaCheck = obtenerJugadaCheck();
	
	if(!jugadaCheck.bolillas.includes(bolillaEliminar)) return;
	
	var index = jugadaCheck.bolillas.indexOf(bolillaEliminar);
	jugadaCheck.bolillas.splice(index, 1);
	
	jugadaCheck.totalJugada = bin_newton(jugadaCheck.bolillas.length);
	
	$("#tk_chk_"+bolillaEliminar).prop('checked', false);
	
	imprimirJugadaCheck(jugadaCheck);
	
}

// limpiar la jugada que esta en true y tambien la jugada check del front
function limpiarBolillasJugadaCheck(){
		
	var jugadaCheck = obtenerJugadaCheck();
	
	jugadaCheck.bolillas = [];
	
	jugadaCheck.totalJugada = 0;
	
	$("input[type=checkbox]:checked").prop('checked', false);
	
	imprimirTextJugadaCheck('__, __, __, __, __, __');
	
}

function imprimirTextJugadaCheck(texto){
	$("#jugada-check").text(texto);
}

// agrega bolillas a la jugada
function agregarBolillasJugadaCheck(bolillas) {
	
	var jugadaCheck = obtenerJugadaCheck();
	
	bolillas.forEach(function(bolilla) {
		if (!jugadaCheck.bolillas.includes(bolilla)) {
			jugadaCheck.bolillas.push(bolilla);
		}
	});
	
	jugadaCheck.totalJugada = bin_newton(jugadaCheck.bolillas.length);
	
	if(esLimiteMax(jugadaCheck, bolillas)) return;
	
	imprimirJugadaCheck(jugadaCheck);
	 
}

function esLimiteMax(jugadaCheck, bolillas){
	let totalAuxJugadas = 0;
	let pasoLimite = false;
	for (var key in jugadas) {
		  if (jugadas.hasOwnProperty(key)) {
			  totalAuxJugadas += jugadas[key].totalJugada;
		  }
	}
	
	if(limiteJugadas<totalAuxJugadas){
		
		for (const bolilla of bolillas) {
			eliminarBolillaJugadaCheck(bolilla);
		}
		
		
		desplegarModal('Máximo '+limiteJugadas+' jugadas');
		taggingPopupError('Máximo '+limiteJugadas+' jugadas');
		//datalayerErrores(seccion,subSeccion,intencion,textoError = "undefined");
		pasoLimite = true;
	}
	
	
	return pasoLimite;
	
}

function calcularTotalJugadas(){
	totalJugadas = 0;
	for (let key in jugadas) {
		totalJugadas += jugadas[key].totalJugada;
	}
	
	$("#total-jugadas").text(totalJugadas);

	calcularTotalPrecio();
}

function calcularTotalPrecio(){
	totalPrecio = 0.00;
	
	let calcular = algoritmos[algorithm] || algoritmos.default;
	
    totalPrecio = calcular();
	
	$("#total-pagar").text( "S/ "+totalPrecio.toLocaleString('en-US',{minimumFractionDigits: 2}) );
	
}

function bin_newton(cantidad) {
    let deduct_1 = 1;
    let deduct_2 = 1;
    let count_2 = cantidad - bolillasMinima;
    
    if(cantidad < bolillasMinima || count_2 < 0) return 0;
    
    let factorialCantidad = factorial(cantidad);
    let factorialCount2 = factorial(count_2); 
    
    let variable = factorialCantidad / (720 * factorialCount2);
    return variable;
}

function factorial(numero) {
	if (numero < 0) 
		return 0;
	
	if (numero > 1)
		return numero * factorial(numero - 1);
	
	return 1;
}

function obtenerJugadaCheck(){
	return Object.values(jugadas).find(function(jugada) {
		return jugada.check === true;
	});
}
 
// inicializando parametros
$(document).ready(function(){
	consecutive = $('#game-consecutive option:selected').val().split('_');
	let jugadaSession = $("#jsonJugadas").val();
	let consecutiveParam = $("#consecutiveParam").val();
	$("#jsonJugadas, #consecutiveParam").val('');
	
	// cambiamos los parametros por default
	if(jugadaSession != "" && consecutiveParam != ""){
		jugadas.jugada_A.check = false;
		$(".btnAddJugada #btnJugadaA").show();
		rellenarJugadasSession(JSON.parse(jugadaSession), consecutiveParam);
		$("#contenedor_buttons_check").show();
	}
	
	calcularTotalJugadas();
	
});


function rellenarJugadasSession(jugadasSession, consecutiveParam) {
    var btnAddJugadaButtons = $('.btnAddJugada button');
    var tkCheckboxes = $('[id^="tk_chk_"]');

    for (var clave in jugadas) {
        if (!jugadasSession.hasOwnProperty(clave) || jugadasSession[clave].totalJugada <= 0) {
            continue;
        }

        var jugadaSession = jugadasSession[clave];
        jugadas[clave] = jugadaSession;

        imprimirJugadaCheck(jugadaSession);

        $(".btnAddJugada #btnJugada" + jugadaSession.id).hide();

        if (!jugadaSession.check) {
            $('#' + 'jugada' + jugadaSession.id).show();
            continue;
        }

        $('.jugada-tinka').text(jugadaSession.id);

        for (var i = 0; i < jugadaSession.bolillas.length; i++) {
            $("#tk_chk_" + jugadaSession.bolillas[i]).prop('checked', true);
        }
    }

    var hiddenBtnCount = 0;

    btnAddJugadaButtons.each(function() {
        if ($(this).is(':hidden')) {
            hiddenBtnCount++;
        }
    });

    if (hiddenBtnCount === btnAddJugadaButtons.length) {
        $("#agregarMasJugada").hide();
    }

    $('#game-consecutive option').each(function() {
        var consecutiva = $(this).val().split('_')[0];

        if (consecutiva === consecutiveParam) {
        	$(this).prop('selected', true);
        	consecutive = $(this).val().split('_');
            return false;
        }
    });
    
	calcularTotalJugadas();

}

function filtrarPropiedades(objeto, propiedades) {
    return Object.keys(objeto)
        .filter(prop => propiedades.includes(prop))
        .reduce((resultado, prop) => {
            resultado[prop] = objeto[prop];
            return resultado;
        }, {});
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

function callTransformByEsc(p_sum_total_bet, p_number_consecutive){
	let elem = algorithm.split(";").slice(1);

	let total_bet_consecutive = (p_sum_total_bet * p_number_consecutive);

	if ( total_bet_consecutive < (elem.length) ) {
		return elem[total_bet_consecutive - 1];
	} else {
		return elem[elem.length] * total_bet_consecutive;
	}
}

function calculateDefaultTotalPrecio(p_sum_total_bet, p_number_consecutive, p_data_value_bet){
	return p_sum_total_bet * p_number_consecutive * p_data_value_bet;
}

