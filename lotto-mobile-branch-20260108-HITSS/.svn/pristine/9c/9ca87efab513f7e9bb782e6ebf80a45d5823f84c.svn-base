
// var globals

var changesData = {},
	enviarDataLayer = true,
	seleccionMetodoPago = "",
	TipoDispositivo ="Mobile",
	gameOption = {
		"btn_mobile_tinka_home" : "Tinka",
		"btn_mobile_teapuesto_home" : "Te Apuesto",
		"game_lapolla_show_menu":"La Polla - Te Apuesto",
		"btn_mobile_ddvv_home":"Deportes Virtuales",
		"btn_mobile_raspaditas_home":"RaspaYá",
		"btn_mobile_casino_home":"Casino",
		"btn_mobile_casino_home_live" : "Casino live",
		"btn_mobile_kinelo_home":"Kinelo",
		"btn_mobile_ganadiario_home":"Gana Diario",
		"btn_mobile_kabala_home":"Kábala",
		"btn_mobile_ganagol_home":"Ganagol",
		"btn_mobile_videoloteria_home":"Video Loteria"	
	},
	operationId = {
		"5586":"La Tinka",
		"5587": "La Polla - Te Apuesto",
		"5588":"Te Apuesto"
	},
	seccion = {
		"tabEfectivo":"POR EFECTIVO",
		"tabInternet":"POR INTERNET"
	},
	botonMetodoPago = {
		"accordion_visanet" : "Visa",
		"accordion_agora" : "Agora Pay",
		"accordion_Yape" : "Yape",
		"accordion_interbank" : "Interbank",
		"accordion_bcp" : "BCP",
		"accordion_bbva" : "BBVA",
		"accordion_Plin" : "Plin",
		"accordion_pagoefectivo" : "PagoEfectivo",
		"accordion_safetypay" : "SafetyPay",
		"accordion_efectivo_interbank" : "Interbank",
		"accordion_efectivo_lotocard" : "Lotocard",
		"accordion_efectivo_pagoefectivo" : "PagoEfectivo",
		"accordion_efectivo_safetypay" : "SafetyPay"
	},
	nombreJuegoPrincipal = {
		"home":"Home",
		"tinka":"La Tinka",
		"raspaya":"RaspaYa",
		"kabala":"Kabala",
		"ganadiario":"Gana diario",
		"kinelo":"Kinelo",
		"ganagol":"Ganagol",
		"virtuales":"Deportes Virtuales",
		"casino":"Casino",
	}
	;

// funciones universales

function seccionLoginRegister(input){
	href = $(input).attr('href');
	return href.indexOf("html") <=0 ? 'Header' : 'Menú Lateral Derecho';
}
function pagePath(){
	pathName = window.location.pathname;
	pathName = pathName.substring(pathName.lastIndexOf("/"),pathName.lastIndexOf(".html")); 
	return pathName;
}

function pagePathIframe(){
	pathName = window.parent.location.pathname;
	pathName = pathName.substring(pathName.lastIndexOf("/"),pathName.lastIndexOf(".html")); 
	return pathName;
}

function zonaUpdate(value){
	return ($("#"+value).val()== undefined || $("#"+value).val()=='') ? 'undefined' : $("#"+value).val();
}

function zonaUpdateIframe(value){
	try{
		var parentBody = window.parent.document.body;
		return ($("#"+value, parentBody).val()== undefined || $("#"+value, parentBody).val()=='') ? 'undefined' : $("#"+value, parentBody).val();
	}catch(e){
		return 'undefined';
	}
}

function isChecked(input){
	return $(input).is(':checked') ? 'Sí' : 'No';
}

function consoleLog(data,flag){
	var urlProd = window.location.host.includes('latinka.com.pe');
	
	if(urlProd && !flag) return;
	
	console.log(data);
	
}

function JugadasXItems(jugadas,precio){
	let items = [];
	let jugada = ['A','B','C','D'];
	jugadas = [jugadaIsNull(jugadas[0]),jugadaIsNull(jugadas[1]),jugadaIsNull(jugadas[2]),jugadaIsNull(jugadas[3])];
	
	for(let i=0;i<jugadas.length;i++){
		if(jugadas[i].includes("00")) continue;
		let item = {};
		item.item_id = 'ID_' + jugada[i];
		item.item_name = 'Jugada ' + jugada[i];
		item.price = precio;
		item.item_brand = zonaUpdate('Zona');
		item.item_category = zonaUpdate('TipoZona');
		item.item_variant = zonaUpdate('SubZona');
		item.quantity = 1;
		items.push(item);
	}
	return items;
}

function jugadaIsNull(jugada){
	return (jugada == "null" || jugada == null || jugada.length == 0) ? "00" : jugada;
}

// funciones por interaccion del usuario
function datalayerIngresar(input){
		dataLayer = window.dataLayer || [ ];
    	dataLayer.push({
    		'event': 'virtualEvent',
    		'Proceso': 'Login',
    		'TipoEvento': 'Interacción',
    		'TipoZona': zonaUpdate('TipoZona'),
    		'Zona': zonaUpdate('Zona'),
    		'SubZona': zonaUpdate('SubZona'),
    		'Sección': seccionLoginRegister(input),
    		'SubSección': 'Paso 1',
    		'TipoElemento': 'Button',
    		'Intención': 'Login',
    		'CTA': $(input).text().trim(),
    		'Paso1': 1, 'Paso2': 0, 'Paso3': 0, 'Paso4': 0,
    		'ID_Juego': 0, 'NombreJuego': '',
    		'PagePath': pagePath(),
          	 'TimeStamp': new Date().getTime(),
          	 'TipoDispositivo': TipoDispositivo
    		});
    	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
}

function datalayerLoginForm(input){
	if(changesData[input.id]) return ;
	changesData[input.id] = true;
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Login',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Formulario',
		'SubSección': 'Paso 2',
		'TipoElemento': 'TextBox',
		'Intención': 'Login',
		'CTA': 'undefined',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		});  
}
 
function datalayerLoginLink(data){
		dataLayer = window.dataLayer || [ ];
    	dataLayer.push({
    		'event': 'virtualEvent',
    		'Proceso': 'Navegación',
    		'TipoEvento': 'Interacción',
    		'TipoZona': zonaUpdate('TipoZona'),
    		'Zona': zonaUpdate('Zona'),
    		'SubZona': zonaUpdate('SubZona'),
    		'Sección': 'Ingresar',
    		'SubSección': 'undefined',
    		'TipoElemento': 'Hyperlink',
    		'Intención': 'redirección',
    		'CTA': $(data).text(),
    		'PagePath': pagePath(),
          	 'TimeStamp': new Date().getTime(),
          	 'TipoDispositivo': TipoDispositivo
    		}); 
}

function datalayerLoginOk(user_id){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Login',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Ingresar',
		'SubSección': 'Paso 3',
		'TipoElemento': 'Button',
		'Intención': 'Login',
		'CTA': 'INGRESAR',
		'Paso1': 0, 'Paso2': 0, 'Paso3': 1, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		}); 
	
	dataLayer.push({
		'event': 'userData',
		'userID': user_id,
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime()
	});
}

function datalayerRegistrar(input){
		dataLayer = window.dataLayer || [ ]; 
    	dataLayer.push({
    		'event': 'virtualEvent',
    		'Proceso': 'Registro',
    		'TipoEvento': 'Interacción',
    		'TipoZona': zonaUpdate('TipoZona'),
    		'Zona': zonaUpdate('Zona'),
    		'SubZona': zonaUpdate('SubZona'),
    		'Sección': seccionLoginRegister(input),
    		'SubSección': 'Paso 1',
    		'TipoElemento': 'Button',
    		'Intención': 'Registrarse',
    		'CTA': $(input).text().trim(),
    		'PagePath': pagePath(),
          	 'TimeStamp': new Date().getTime(),
          	 'TipoDispositivo': TipoDispositivo
    		});
}

function datalayerInfoPerso(input){
	if(changesData[input.id]) return ;
	changesData[input.id] = true;
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Información personal',
		'SubSección': 'Paso 2',
		'TipoElemento': 'TextBox',
		'Intención': 'Registrarse',
		'CTA': 'undefined',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		});
}

function datalayerDatoAcceso(input){
	if(changesData[input.id]) return ;
	changesData[input.id] = true;
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Datos de acceso',
		'SubSección': 'Paso 2',
		'TipoElemento': 'TextBox',
		'Intención': 'Registrarse',
		'CTA': 'undefined',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		});
	}

function datalayerInfoContacto(input){
	if(changesData[input.id]) return ;
	changesData[input.id] = true;
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Información de contacto',
		'SubSección': 'Paso 2',
		'TipoElemento': 'TextBox',
		'Intención': 'Registrarse',
		'CTA': 'undefined',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		});
	}

function datalayerTyC(input){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Terminos y condiciones',
		'SubSección': 'Paso 2',
		'TipoElemento': 'Checkbox',
		'Intención': 'Registrarse',
		'CTA': 'undefined',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo,
      	'CheckTerminos': isChecked(input)
		});
	}

function datalayerPromo(input){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Recibir promociones',
		'SubSección': 'Paso 2',
		'TipoElemento': 'Checkbox',
		'Intención': 'Registrarse',
		'CTA': 'undefined',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo,
      	'CheckPromociones': isChecked(input)
		});
	}

function datalayerRegistro(){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': 'undefined',
		'Sección': 'Registrar',
		'SubSección': 'Paso 2',
		'TipoElemento': 'Button',
		'Intención': 'Registrarse',
		'CTA': 'undefined',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		});
	}

function datalayerActivate(){
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'userData',
			'userID': $("#user-client-id").val(),
			'PagePath': 'activar',
			'TimeStamp': new Date().getTime()
			});
		
    	dataLayer.push({
    		'event': 'virtualEvent',
    		'Proceso': 'Registro',
    		'TipoEvento': 'Interacción',
    		'TipoZona': zonaUpdate('TipoZona'),
    		'Zona': zonaUpdate('Zona'),
    		'SubZona': zonaUpdate('SubZona'),
    		'Sección': 'Confirmación cuenta activada',
    		'SubSección': 'Paso 3',
    		'TipoElemento': 'Button',
			'Intención': 'Registrarse',
			'CTA': 'ACTIVAR',
			'Paso1': 0, 'Paso2': 0, 'Paso3': 1, 'Paso4': 0,
			'ID_Juego': 0, 'NombreJuego': '',
			'PagePath': operationId[$("#operatorIdApi").val()],
          	 'TimeStamp': new Date().getTime(),
          	 'TipoDispositivo': TipoDispositivo
			});	
    	$("#SubZona").val('Registro Satisfactorio');
}
function datalayerResendCode(){
		dataLayer = window.dataLayer || [ ];
    	dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Registro',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdate('TipoZona'),
    		'Zona': zonaUpdate('Zona'),
    		'SubZona': zonaUpdate('SubZona'),
			'Sección': 'Reenviar código por SMS',
			'SubSección': 'Paso 3',
			'TipoElemento': 'Hyperlink',
			'Intención': 'Registrarse',
			'CTA': 'Reenviar código por SMS',
			'Paso1': 0, 'Paso2': 0, 'Paso3': 1, 'Paso4': 0,
			'ID_Juego': 0, 'NombreJuego': '',
			'PagePath': operationId[$("#operatorIdApi").val()],
          	 'TimeStamp': new Date().getTime(),
          	 'TipoDispositivo': TipoDispositivo
			});	
}
function datalayerErrores(seccion,subSeccion,intencion,textoError = "undefined"){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Errores',
		'TipoEvento': 'Error',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': seccion,
		'SubSección': subSeccion,
		'TipoElemento': 'Modal Dialog',
		'Intención': intencion,
		'CTA': textoError,
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
}

function datalayerGameOption(button){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Navegación',
		'TipoEvento': 'Interacción',
		'TipoZona': 'Home',
		'Zona': 'Home',
		'SubZona': 'undefined',
		'Sección': 'Lista de Juegos',
		'SubSección': 'undefined',
		'TipoElemento': 'Card',
		'Intención': 'Jugar',
		'CTA': gameOption[button.id],
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
	// console.log("datalayerGameOption");
}

function datalayerCargarSaldo(input){
	let textSeccion = ($("#"+input).attr("id") == 'agregarSaldo') ? 'Header' : 'Menú Lateral Derecho';
	let textPagePath = pagePath();
	let nombreJuego = textPagePath.substring(1,textPagePath.length);
	nombreJuego = (nombreJuego.split("_")[1] === undefined) ? nombreJuego : nombreJuego.split("_")[1];
	nombreJuego = nombreJuegoPrincipal[nombreJuego];
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': textSeccion,
		'SubSección': 'Paso 1',
		'TipoElemento': 'Button',
		'Intención': 'Cargar Saldo',
		'CTA': 'Cargar Saldo',
		'Paso1': 1, 'Paso2': 0, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': nombreJuego,
		'PagePath': textPagePath,
      	'TimeStamp': new Date().getTime(),
      	'TipoDispositivo': TipoDispositivo
		}); 
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	//console.log($("#operatorIdApi").val());
}

function datalayerMetodoPago(CTA){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	seleccionMetodoPago = CTA;
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': 'undefined',
		'TipoElemento': 'Button',
		'Intención': 'Cargar Saldo',
		'CTA': botonMetodoPago[CTA],
		'PagePath': operationId[$("#operatorId").val()],
     	'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	$(".monto_recarga").val('');
	$(".codigo_promocional").val('');
	$(".codigo_promocional_ibk").val('');
	$('.form__alert_recharge').hide();
	$('.form__gift-valid').hide();
	$('.button__outline').show();
	$('.button__outline').attr('disabled', false);
	$('.button__base').attr('disabled', true); 
    $('#btnRecargaAgora2').attr('disabled', true);
	$(".codigo_promocional").attr('disabled', true);
}

function datalayerTerminosSaldoVirtual(){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': 'undefined',
		'TipoElemento': 'Hyperlink',
		'Intención': 'Ver términos del uso del saldo virtual',
		'CTA': 'Ver términos del uso del saldo virutal',
		'PagePath': operationId[$("#operatorId").val()],
     	'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerIngresarMonto(input){
	if($(input).val() == '') return;
	if(changesData[input.id]) return ;
	changesData[input.id] = true;
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'TextBox',
		'Intención': 'Ingresar monto',
		'CTA': 'undefined',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerCodigoPromo(input){
	if($(input).val() == '') return;
	if(changesData[input.id]) return ;
	changesData[input.id] = true;
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'TextBox',
		'Intención': 'Ingresar código promocional',
		'CTA': 'undefined',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerAplicarCodigoPromo(){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Button',
		'Intención': 'Aplicar código promocional',
		'CTA': 'Aplicar código promocional',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerButtonCargarSaldo(){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Button',
		'Intención': 'Cargar Saldo',
		'CTA': 'Ingresar tarjeta VISA y/o Mastercard',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerActualizarNumTelf(){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Hyperlink',
		'Intención': 'Actualizar número de teléfono',
		'CTA': 'Actualízalo aquí',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerContinuarCargarSaldo(){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Button',
		'Intención': 'Cargar Saldo',
		'CTA': 'Recargar saldo',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}


function datalayerIrEntidadBancaria(input){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Hyperlink',
		'Intención': 'Ir a web de entidad bancaria ',
		'CTA': $(input).text(),
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}


function datalayerGenerarCodigoPago(){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Button',
		'Intención': 'Generar código de pago',
		'CTA': 'Generar código de pago',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerObtenerInfoUso(input){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Hyperlink',
		'Intención': 'Obtener información de uso',
		'CTA': $(input).text(),
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerCodigoLotocard(input){
	if($(input).val() == '') return;
	if(changesData[input.id]) return ;
	changesData[input.id] = true;
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'TextBox',
		'Intención': 'Ingresar código de Lotocard',
		'CTA': 'undefined',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

function datalayerLugaresPago(){
	seccionId = $(".tabs__list").children(".selected").attr("id");
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion[seccionId],
		'SubSección': botonMetodoPago[seleccionMetodoPago],
		'TipoElemento': 'Hyperlink',
		'Intención': 'Ver lugares de pago',
		'CTA': 'Ver lugares',
		'PagePath': operationId[$("#operatorId").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
}

/********** sprint 5 *************/ 
//tinka     		1.3 #06 o 1.3 #07
//Kabala    		1.7 #06 o 1.7 #07
//GanaDiario		1.10 #06 o 1.10 #07
//Kinelo			1.11 #06
//Ganagol			2.1 #09
function datalayerBtnJuegatinka(input,tipoElemento,seccion){
	input = (typeof input == "string") ? input : $(input).text().trim();

	dataLayer = window.dataLayer || [ ];
	dataLayer.push({ 	
		'event': 'virtualEvent',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
	   	'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': seccion,
		'SubSección': 'undefined',
		'TipoElemento': tipoElemento,
		'Intención': 'Jugar',
		'CTA': input,
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

//Tinka 			1.2 #05 o 1.1 #05
//Kabala			1.6 #05 o 1.5 #05 o 1.5 #06
//GanaDiario		1.9 #05 o 1.8 #05 o 1.8 #06
//Kinelo			1.11 #07
//Ganagol			2.1 #10
function datalayerTinkaJugada(input,seccion,tipoElemento,itencion,paso = "Paso 1"){
	input = (typeof input == "string") ? input : $(input).text().trim();
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({ 	
		'event': 'virtualEvent',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': seccion,
		'SubSección': pasoCheck(paso,"SubSección"),
		'TipoElemento': tipoElemento,
		'Intención': itencion,
		'CTA': input,
		'Paso1': pasoCheck(paso,"Paso 1"), 'Paso2': pasoCheck(paso,"Paso 2"), 'Paso3': pasoCheck(paso,"Paso 3"), 'Paso4': pasoCheck(paso,"Paso 4"),
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

//TINKA				1.2 #06 o 1.1 #06
//Kabala			1.6 #06 o 1.5 #07
//GanaDiario		1.9 #06 o 1.8 #07
//Kinelo			1.11 #08
function datalayerMisJugadas(input,seccion,intencion,tipoElemento,paso = "Paso 2"){
	input = (typeof input == "string") ? input : $(input).text().trim();

	try{
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({ 	
			'event': 'virtualEvent',
			'Proceso': 'Compra',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdate('TipoZona'),
			'Zona': zonaUpdate('Zona'),
			'SubZona': zonaUpdate('SubZona'),
			'Sección': seccion,
			'SubSección': pasoCheck(paso,"SubSección"),
			'TipoElemento': 'Button',
			'Intención': 'Jugar',
			'CTA': input,
			'Paso1': pasoCheck(paso,"Paso 1"), 'Paso2': pasoCheck(paso,"Paso 2"), 'Paso3': pasoCheck(paso,"Paso 3"), 'Paso4': pasoCheck(paso,"Paso 4"),
			'PagePath': pagePath(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
		consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
    }catch(e){
    	console.error(e);
    }
}

//TINKA				1.2 #07 o 1.1 #07
//Kabala			1.6 #07 o 1.5 #08
//GanaDiario		1.9 #07 o 1.8 #08
//Kinelo			1.11 #09
//Ganagol 			2.1 #12
function datalayerGraciasCompra(input,intencion,TipoElemento,paso = "Paso 3"){
	input = (typeof input == "string") ? input : $(input).text().trim();
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({ 	
		'event': 'virtualEvent',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': datalayerGraciasCompraSeccion(),
		'SubSección': pasoCheck(paso,"SubSección"),
		'TipoElemento': TipoElemento,
		'Intención': intencion,
		'CTA': input,
		'Paso1': pasoCheck(paso,"Paso 1"), 'Paso2': pasoCheck(paso,"Paso 2"), 'Paso3': pasoCheck(paso,"Paso 3"), 'Paso4': pasoCheck(paso,"Paso 4"),
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

//TINKA				1.3 #08
//Kabala			1.7 #09
//GanaDiario		1.10 #08
//Kinelo			1.11 #05
//Ganagol			2.1 #08
function datalayerResultados(input,proceso,seccion){
	
	input = (typeof input == "string") ? input : $(input).text().trim();
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': proceso,
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': seccion,
		'SubSección': 'undefined',
		'TipoElemento': 'Button',
		'Intención': 'Ver listado de jugadas',
		'CTA': input,
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

function datalayerAddToCart(jugadas,precio,seccion){
	let items = JugadasXItems(jugadas,precio);
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'add_to_cart',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': seccion,
		'SubSección': 'Paso 1',
		'TipoElemento': 'Button',
		'Intención': 'Compra',
		'CTA': 'Siguiente',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo,
		'ecommerce':{
			'items':items
		}
	});
	consoleLog(dataLayer.filter(a => a.event == 'add_to_cart'),false);
}

function datalayerRemoveFromCart(jugadas,precio,seccion){
	let items = JugadasXItems(jugadas,precio);
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'remove_from_cart',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': seccion,
		'SubSección': 'Paso 2',
		'TipoElemento': 'Button',
		'Intención': 'Compra',
		'CTA': 'Eliminar',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo,
		'ecommerce':{
			'items':items
		}
	});
	consoleLog(dataLayer.filter(a => a.event == 'remove_from_cart'),false);
}

function datalayerCheckout(jugadas,precio){
	let items = JugadasXItems(jugadas,precio);
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'begin_checkout',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Mi Boleto',
		'SubSección': 'Paso 2',
		'TipoElemento': 'Button',
		'Intención': 'Compra',
		'CTA': 'Comprar',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo,
		'ecommerce':{
			'items':items
		}
	});
	consoleLog(dataLayer.filter(a => a.event == 'begin_checkout'),false);
}

function datalayerPurchase(jugadas,precio,precioTotal,ticketId,coupon = "undefined"){
	let items = JugadasXItems(jugadas,precio);
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'purchase',
		'Proceso': 'Compra',
		'TipoEvento': 'Visualización',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Gracias por tu Compra',
		'SubSección': 'Paso 3',
		'TipoElemento': 'Screen',
		'Intención': 'Compra',
		'CTA': 'undefined',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo,
		'ecommerce':{
			'transaction_id': ticketId,
			'value': precioTotal,
			'coupon': coupon,
			'currency': 'PEN',
			'items':items
		}
	});
	consoleLog(dataLayer.filter(a => a.event == 'purchase'),false);
}



function datalayerGraciasCompraSeccion(){
	var textoSeccion = $(".game-desc h2").text();
	return textoSeccion;
}

function pasoCheck(paso,atributo){
	var pasoReturn = "";
	if(atributo == "SubSección")
		pasoReturn = paso;
	else
		pasoReturn = (paso == atributo) ? 1 : 0;
	
	return pasoReturn;
}

/***********************************************************************************/
/******************************  SPRINT 8  *****************************************/
/***********************************************************************************/

//[9.2 #02] Mi Cuenta / Mis Premios - Retirar
function datalayerMisPremiosRetirar(boton){
	try{
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Navegación',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar mis premios',
			'Sección': 'Mis Premios',
			'SubSección': 'Paso 1',
			'TipoElemento': 'Button',
			'Intención': 'Retirar',
			'CTA': boton,
			'Paso1': 1, 'Paso2': 0, 'Paso3': 0, 'Paso4': 0,
			'PagePath': pagePath(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
		});

	}catch(error){
		console.error(error);
	}
}


// [9.2 #03] Mi Cuenta / Mis Premios - Ver contenido
function datalayerMisPremiosVerContenido(opcion){
	try{
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Navegación',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar mis premios',
			'Sección': 'Mis Premios',
			'SubSección': 'undefined',
			'TipoElemento': 'DropDownList',
			'Intención': 'Ver contenido',
			'CTA': opcion,
			'PagePath': pagePath(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
		});

	}catch(error){
		console.error(error);
	}
}


//[9.11 #01] Mi Cuenta / Método de cobro - {Método de cobro}
function datalayerCobrarPremioMetodoCobro(tagLi,intencion){
	try{
		
		// Como la cadena también contiene el texto del elemento span, podemos eliminar ese contenido.
		let titleText = tagLi.find('.accordion__title').text().trim();
		
		let textoquitar = tagLi.find('.accordion__title .info').text();
		
		titleText = titleText.replace( textoquitar , '').trim();

		if( titleText.includes( 'Visa' ) )
			titleText = 'Visa';
		
		if( titleText.includes( 'Efectivo / Punto de venta' ) )
			titleText = 'Efectivo / Punto de venta';
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar Premios',
			'Sección': 'Método de cobro',
			'SubSección': 'undefined',
			'TipoElemento': 'DropDownList',
			'Intención': titleText,
			'CTA': titleText,
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}

//[9.11 #02] Mi Cuenta / Método de cobro - Ver retiros
function datalayerCobrarPremioMetodoCobroRetiro(){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar Premios',
			'Sección': 'Método de cobro',
			'SubSección': 'undefined',
			'TipoElemento': 'Button',
			'Intención': 'Ver retiros',
			'CTA': 'Retiros',
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}

// [9.11 #03] Mi Cuenta / Método de cobro - Ingresar monto
// [9.11 #07] Mi Cuenta / Método de cobro - Ingresar monto
// [9.11 #12] Mi Cuenta / Método de cobro - Ingresar monto
// [9.11 #09] Mi Cuenta / Método de cobro - Ingresar número de cuenta
function datalayerCobrarPremioInput(input,metodo,intencion){
	try{
		
		if($(input).val() == '') return;
		
		if(changesData[input.attr("id")]) return ;
		
		changesData[input.attr("id")] = true;
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar Premios',
			'Sección': 'Método de cobro',
			'SubSección': metodo,
			'TipoElemento': 'TextBox',
			'Intención': intencion,
			'CTA': 'undefined',
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}


// [9.11 #04] Mi Cuenta / Método de cobro - Subir imagen
function datalayerCobrarPremioMetodoCobroSubirImg(metodo){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar Premios',
			'Sección': 'Método de cobro',
			'SubSección': metodo,
			'TipoElemento': 'Button',
			'Intención': 'Subir imagen',
			'CTA': 'Subir imagen',
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}


// [9.11 #05] Mi Cuenta / Método de cobro - Seleccionar o añadir tarjeta
function datalayerCobrarPremioMetodoCobroSelectTarjeta(metodo){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar Premios',
			'Sección': 'Método de cobro',
			'SubSección': metodo,
			'TipoElemento': 'Button',
			'Intención': 'Seleccionar o añadir tarjeta',
			'CTA': 'Seleccionar tarjeta',
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}


// [9.11 #08] Mi Cuenta / Método de cobro - Seleccionar un banco
// [9.11 #10] Mi Cuenta / Método de cobro - Seleccionar departamento
function datalayerCobrarPremioMetodoCobroSelect(opcion,intencion){
	try{
		
		opcion = (typeof opcion == "string") ? opcion : $(opcion).find('option:selected').text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar Premios',
			'Sección': 'Método de cobro',
			'SubSección': 'Transferencia Bancaria',
			'TipoElemento': 'DropDownList',
			'Intención': intencion,
			'CTA': opcion,
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
		});
		
	}catch(error){
		console.error(error);
	}
}


//[9.13 #01] Pop-Up Cobrar premios / undefined - Retirar
function datalayerPopupCobrarPremioRetirar(input){
	try{
		
		input = (typeof input == "string") ? input : $(input).text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Pop-Up Cobrar premios',
			'SubZona': 'Pop-Up Solicitar retiro',
			'Sección': 'undefined',
			'SubSección': 'undefined',
			'TipoElemento': 'Button',
			'Intención': 'Retirar',
			'CTA': input,
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
		
	}catch(error){
		console.error(error);
	}
}


//[4.1 #10] {Zona} / {Sección} - Cerrar Modal
function datalayerCerrarModal(){
	try{
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cerrar',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdateIframe('TipoZona'),
			'Zona': zonaUpdateIframe('Zona'),
			'SubZona': zonaUpdateIframe('SubZona'),
			'Sección': 'undefined',
			'SubSección': 'undefined',
			'TipoElemento': 'Close',
			'Intención': 'Cerrar Modal',
			'CTA': 'cerrar',
			'PagePath': pagePathIframe(),
	      	'TimeStamp': new Date().getTime(),
	      	'TipoDispositivo': TipoDispositivo
		});
	}catch(error){
		console.error(error);
	}
}

//[9.11 #06] Mi Cuenta / Método de cobro – Retirar
//[9.11 #11] Mi Cuenta / Método de cobro – Retirar
//[9.11 #13] Mi Cuenta / Método de cobro - Retirar
function datalayerCobrarPremioMetodoCobroRetirar(metodo){
	try{
		
		if(metodo == 'EFECTIVO')
			metodo = 'Efectivo / Punto de Venta';
		else if(metodo == 'TRANSFERENCIA')
			metodo = 'Transferencia Bancaria';
		else
			metodo = metodo;
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Mi Cuenta',
			'SubZona': 'Cobrar Premios',
			'Sección': 'Método de cobro',
			'SubSección': metodo,
			'TipoElemento': 'Button',
			'Intención': 'Retirar',
			'CTA': 'SOLICITAR RETIRO',
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}

// [4.1 #06] {Zona} / Menú Lateral Derecho - {Intención}
function datalayerMenuLateralDerecho(input){
	try{
		
		input = (typeof input == "string") ? input : $(input).text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Navegación',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdate('TipoZona'),
			'Zona': zonaUpdate('Zona'),
			'SubZona': zonaUpdate('SubZona'),
			'Sección': 'Menú Lateral Derecho',
			'SubSección': 'undefined',
			'TipoElemento': 'Option Menu',
			'Intención': 'navegar',
			'CTA': input,
			'PagePath': pagePath(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}


function datalayerCargarSaldoW() {
    try {
        // Obtener los valores necesarios desde el DOM
        var PagePath = pagePath();
        var userId = $('#user-client-id').val() || 'undefined';
        var ID_Juego = $('#ID_Juego').val() || 0;
        var nombreJuegoKey = PagePath.substring(1, PagePath.length);
        //var NombreJuego = nombreJuegoPrincipal[nombreJuegoKey] || 'undefined';
        //var TipoDispositivo = 'Mobile'; // Puedes asignar dinámicamente si es necesario

        // Validar valores esenciales
        if (userId === 'undefined' || ID_Juego === 0) {
            console.warn('Algunos valores para Cargar Saldo están indefinidos.');
        }

        var TimeStamp = new Date().getTime();

        // Primer push al dataLayer para 'userData'
        dataLayer.push({
            'event': 'userData',
            'userID': userId,
            'PagePath': PagePath,
            'TimeStamp': TimeStamp
        });

        // Segundo push al dataLayer para 'virtualEvent'
        dataLayer.push({  
            'event': 'virtualEvent',  
            'Proceso': 'Cargar Saldo',  
            'TipoEvento': 'Interacción',  
            'TipoZona': zonaUpdate('TipoZona'), 
            'Zona': zonaUpdate('Zona'),      
            'SubZona': zonaUpdate('SubZona'),  
            'Sección': 'PostRegistro',  
            'SubSección': 'Paso 2',  
            'TipoElemento': 'Button',  
            'Intención': 'Cargar Saldo',  
            'CTA': 'Cargar Saldo',    
            'Paso1': 0,  
            'Paso2': 1,  
            'Paso3': 0,  
            'Paso4': 0,  
            'ID_Juego': ID_Juego,  
            'NombreJuego': NombreJuego,  
            'PagePath': PagePath,  
            'TimeStamp': TimeStamp,  
            'TipoDispositivo': TipoDispositivo  
        });
    } catch (error) {
        console.error('Error al enviar eventos de Cargar Saldo:', error);
    }
}







