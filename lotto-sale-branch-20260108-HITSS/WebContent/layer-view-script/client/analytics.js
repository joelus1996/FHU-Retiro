
// var globals

var changesData = {},
	finalizaCompra2 = true,
	enviarDataLayer = true,
	dataLayerlimpiar=true,
	seleccionMetodoPago = "",
	TipoDispositivo ="Desktop",
	gameOption = {
		"game-tinka" : "Tinka",
		"game-teapuesto" : "Te Apuesto",
		"game-lapolla":"La Polla - Te Apuesto",
		"game-ddvv":"Deportes Virtuales",
		"game-raspaditas":"RaspaYá",
		"game-casino":"Casino",
		"game-kinelo":"Kinelo",
		"game-ganadiario":"Gana Diario",
		"game-kabala":"Kábala",
		"game-ganagol":"Ganagol"
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
		"tabInternetVisanet" : "Visa",
		"tabInternetAgora" : "Agora Pay",
		"tabInternetYape" : "Yape",
		"tabInternetInterbank" : "Interbank",
		"tabInternetBCP" : "BCP",
		"tabInternetBBVA": "BBVA",
		"tabInternetPlin" : "Plin",
		"tabInternetPagoEfectivo" : "PagoEfectivo",
		"tabInternetSafetyPay" : "SafetyPay",
		"tabEfectivoInterbank" : "Interbank",
		"tabEfectivoLotocard" : "Lotocard",
		"tabEfectivoPagoEfectivo" : "PagoEfectivo",
		"tabEfectivoSafetyPay" : "SafetyPay"
	},
	nombreJuegoPrincipal = {
		"mi-cuenta":"Mi cuenta",
		"juega-tinka":"La Tinka",
		"juega-raspaya":"RaspaYa",
		"juega-kabala":"Kabala",
		"juega-ganadiario":"Gana diario",
		"juega-kinelo":"Kinelo",
		"juega-ganagol":"Ganagol",
		"juega-virtuales":"Deportes Virtuales",
		"juega-casino":"Casino",
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

function consoleLog(data,flag = false){
	var urlProd = window.location.host.includes('latinka.com.pe');
	
	if(urlProd && !flag) return;
	
	console.log(data);
	
	return;
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
		item.price = Number(precio.toFixed(2));
		item.item_brand = zonaUpdate('Zona');
		item.item_category = zonaUpdate('TipoZona');
		item.item_variant = zonaUpdate('SubZona');
		item.quantity = 1;
		items.push(item);
	}
	return items;
}

function jugadaIsNull(jugada){
	return (jugada == "null" || jugada == null) ? "00" : jugada;
}

// funciones por interaccion del usuario

function datalayerLogin(input){
	dataLayer = window.dataLayer || [ ];
    dataLayer.push({
   	 'event': 'virtualEvent',
   	 'Proceso': 'Login',
   	 'TipoEvento': 'Interacción',
   	'TipoZona': zonaUpdate('TipoZona'),
	'Zona': zonaUpdate('Zona'),
	'SubZona': zonaUpdate('SubZona'),
   	 'Sección': 'Header',
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
    consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
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
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime()
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
}

function datalayerRegistro(input){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': 'undefined',
		'Sección': 'Header',
		'SubSección': 'Paso 1',
		'TipoElemento': 'Button',
		'Intención': 'Registrarse',
		'CTA': $(input).text().trim(),
		'Paso1': 1, 'Paso2': 0, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': pagePath(),
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		}); 
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
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
function datalayerRegistroOk(){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Registrar',
		'SubSección': 'Paso 2',
		'TipoElemento': 'Button',
		'Intención': 'Registrarse',
		'CTA': 'REGISTRAR',
		'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
		'ID_Juego': 0, 'NombreJuego': '',
		'PagePath': operationId[$("#operatorIdApi").val()],
      	 'TimeStamp': new Date().getTime(),
      	 'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
	}

function datalayerActivate(){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'userData',
		'userID': $("#user-client-id").val(),
		'PagePath': pagePath(),
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
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
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
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
}

function datalayerActivaCuenta(buttonText){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Registro',
		'TipoEvento': 'Interacción',
		'TipoZona': 'Registro',
		'Zona': 'Registro',
		'SubZona': 'Activa tu cuenta',
		'Sección': 'Activa tu cuenta',
		'SubSección': 'undefined',
		'TipoElemento': 'Button',
		'Intención': 'Registrarse',
		'CTA': buttonText,
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
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
}

function datalayerErroresIframe(seccion,subSeccion,intencion,textoError = "undefined"){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Errores',
		'TipoEvento': 'Error',
		'TipoZona': zonaUpdateIframe('TipoZona'),
		'Zona': zonaUpdateIframe('Zona'),
		'SubZona': zonaUpdateIframe('SubZona'),
		'Sección': seccion,
		'SubSección': subSeccion,
		'TipoElemento': 'Modal Dialog',
		'Intención': intencion,
		'CTA': textoError,
		'PagePath': pagePathIframe(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	//console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
}

$(".juega-ahora").on('click',function(){datalayerJuegaAhora(this)});

function datalayerJuegaAhora(button){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Navegación',
		'TipoEvento': 'Interacción',
		'TipoZona': 'Home',
		'Zona': 'Home',
		'SubZona': 'undefined',
		'Sección': 'Jugar Ahora',
		'SubSección': 'undefined',
		'TipoElemento': 'Button',
		'Intención': 'Jugar',
		'CTA': 'JUEGA AHORA',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

$(".game-option").on('click',function(){datalayerGameOption(this)});

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
		'TipoElemento': 'Graphic',
		'Intención': 'Jugar',
		'CTA': gameOption[button.id],
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));;
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	// console.log("datalayerGameOption");
}

function datalayerCargarSaldo(){
	let textPagePath = pagePath();
	let nombreJuego = nombreJuegoPrincipal[textPagePath.substring(1,textPagePath.length)];
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'virtualEvent',
		'Proceso': 'Cargar Saldo',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': 'undefined',
		'Sección': 'Header',
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
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
     	'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
     	'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

function datalayerVolverMetodoPago(){
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
		'TipoElemento': 'Arrow',
		'Intención': 'Navegar',
		'CTA': 'Volver a los métodos de recarga',
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'PagePath': operationId[$("#operatorIdApi").val()],
		'TimeStamp': new Date().getTime(),
     	'TipoDispositivo': TipoDispositivo
		});
	// console.log(dataLayer.filter(a => a.event == 'virtualEvent'));
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}




function datalayerFinalizaCompraAyuda(input,intencion){
	if($(".step-play.step-active").hasClass('step-status-1'))
		datalayerFinalizaCompra1(input,intencion);
	else{
		if(finalizaCompra2)
			datalayerFinalizaCompra2(input,intencion);
		else
			datalayerGraciasCompra(input,intencion);
	}
		
}

function datalayerGraciasCompraSeccion(){
	var textoSeccion = $(".label-top").text();
	return textoSeccion;
}

//Tinka        	1.3 #01
//Kabala       	1.7 #01
//GanaDiario   	1.10 #01
function datalayerBtnsTipoJuego(input,seccion){
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({ 	
		'event': 'virtualEvent',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
	   	'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': 'undefined',
		'Sección': seccion,
		'SubSección': 'undefined',
		'TipoElemento': 'Button',
		'Intención': 'Jugar',
		'CTA': $(input).text().trim(),
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'));
}

//Tinka         1.2 #01 o 1.1 #01
//Kabala  		1.6 #01 o 1.5 #01
//GanaDiario    1.9 #01 o 1.8 #01
//Kinelo 		1.11 #01
//Ganagol		2.1  #01
function datalayerJugada(input,seccion){
	
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
		'SubSección': 'Paso 1',
		'TipoElemento': 'Button',
		'Intención': 'Jugar',
		'CTA': input,
		'Paso1': 1, 'Paso2': 0, 'Paso3': 0, 'Paso4': 0,
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'));
}

//Tinka 		1.2 #02 o 1.1 #02
//Kabala 		1.6 #02 o 1.5 #02
//GanaDiario 	1.9 #02 o 1.8 #02
//Kinelo 		1.11 #02
//Ganagol		2.1  #02
function datalayerFinalizaCompra1(input,intencion){

	try{
		input = (typeof input == "string") ? input : $(input).text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({ 	
			'event': 'virtualEvent',
			'Proceso': 'Compra',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdate('TipoZona'),
			'Zona': zonaUpdate('Zona'),
			'SubZona': zonaUpdate('SubZona'),
			'Sección': 'Finalizar tu Compra 1',
			'SubSección': 'Paso 2',
			'TipoElemento': 'Button',
			'Intención': intencion,
			'CTA': input,
			'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0,
			'PagePath': pagePath(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
		consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'));
    }catch(e){
    	console.error(e);
    }
}

//Tinka  		1.2 #03 o 1.1 #03
//Kabala 		1.6 #03 o 1.5 #03
//GanaDiario 	1.9 #03 o 1.8 #03
//Kinelo 		1.11 #03
function datalayerFinalizaCompra2(input,intencion){
	try{
		input = (typeof input == "string") ? input : $(input).text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({ 	
			'event': 'virtualEvent',
			'Proceso': 'Compra',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdate('TipoZona'),
			'Zona': zonaUpdate('Zona'),
			'SubZona': zonaUpdate('SubZona'),
			'Sección': 'Finalizar tu Compra 2',
			'SubSección': 'Paso 3',
			'TipoElemento': 'Button',
			'Intención': intencion,
			'CTA': input,
			'Paso1': 0, 'Paso2': 0, 'Paso3': 1, 'Paso4': 0,
			'PagePath': pagePath(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
		consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
		consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
	}catch(e){
		console.error(e);
	}
}

//Tinka  		1.2 #04 o 1.1 #04
//Kabala 		1.6 #04 o 1.5 #04
//GanaDiario 	1.9 #04 o 1.8 #04
//Kinelo 		1.11 #04
//Ganagol 		2.1  #04
function datalayerGraciasCompra(input,intencion){
	
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
		'SubSección': 'Paso 4',
		'TipoElemento': 'Button',
		'Intención': intencion,
		'CTA': input,
		'Paso1': 0, 'Paso2': 0, 'Paso3': 0, 'Paso4': 1,
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo
		});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}



function datalayerAddToCart(jugadas,precio){
	let items = JugadasXItems(jugadas,precio);
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'add_to_cart',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Finalizar tu Compra 1',
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
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

function datalayerRemoveFromCart(jugadas,precio){
	let items = JugadasXItems(jugadas,precio);
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'remove_from_cart',
		'Proceso': 'Compra',
		'TipoEvento': 'Interacción',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': 'Finalizar tu Compra 2',
		'SubSección': 'Paso 3',
		'TipoElemento': 'Button',
		'Intención': 'Compra',
		'CTA': 'x',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo,
		'ecommerce':{
			'items':items
		}
	});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
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
		'Sección': 'Finalizar tu Compra 2',
		'SubSección': 'Paso 3',
		'TipoElemento': 'Button',
		'Intención': 'Compra',
		'CTA': 'Finalizar tu Compra',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo,
		'ecommerce':{
			'items':items
		}
	});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

function datalayerPurchase(jugadas,precio,seccion,precioTotal,ticketId,cupon){
	let items = JugadasXItems(jugadas,precio);
	
	dataLayer = window.dataLayer || [ ];
	dataLayer.push({
		'event': 'purchase',
		'Proceso': 'Compra',
		'TipoEvento': 'Visualización',
		'TipoZona': zonaUpdate('TipoZona'),
		'Zona': zonaUpdate('Zona'),
		'SubZona': zonaUpdate('SubZona'),
		'Sección': seccion,
		'SubSección': 'Paso 4',
		'TipoElemento': 'Screen',
		'Intención': 'Compra',
		'CTA': 'undefined',
		'PagePath': pagePath(),
		'TimeStamp': new Date().getTime(),
		'TipoDispositivo': TipoDispositivo,
		'ecommerce':{
			'transaction_id': ticketId,
			'coupon': cupon,
			'value': precioTotal,
			'currency': 'PEN',
			'items':items
		}
	});
	consoleLog(dataLayer.filter(a => a.event == 'virtualEvent'),false);
}

/***********************************************************************************/
/******************************  SPRINT 8  *****************************************/
/***********************************************************************************/

// [9.4 #01] 
function datalayerCobrarPremioMetodoCobro(tagLi,intencion){
	try{

		// Como la cadena también contiene el texto del elemento span, podemos eliminar ese contenido.
		let titleText = tagLi.find('.accordion__title').text().trim();

		titleText = titleText.replace(tagLi.find('.accordion__title .info').text(), '').trim();

		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Cobrar Mis Premios',
			'SubZona': 'undefined',
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

//[9.4 #02] 
function datalayerCobrarPremioMetodoCobroRetiro(){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Cobrar Mis Premios',
			'SubZona': 'undefined',
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

//[9.5 #01] 
//[9.7 #01]
//[9.8 #01] 
function datalayerCobrarPremioMetodoCobroIngresarMonto(input,metodo){
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
			'Zona': 'Cobrar Mis Premios',
			'SubZona': metodo,
			'Sección': 'Método de cobro',
			'SubSección': metodo,
			'TipoElemento': 'TextBox',
			'Intención': 'Ingresar monto',
			'CTA': 'undefined',
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
			});
	}catch(error){
		console.error(error);
	}
}


//[9.5 #02] Cobrar Mis Premios / Método de cobro - Subir imagen
function datalayerCobrarPremioMetodoCobroSubirImg(metodo){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Cobrar Mis Premios',
			'SubZona': metodo,
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


//[9.5 #03] Cobrar Mis Premios / Método de cobro - Seleccionar o añadir tarjeta
function datalayerCobrarPremioMetodoCobroSelectTarjeta(metodo){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Cobrar Mis Premios',
			'SubZona': metodo,
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


//[9.6 #01] Cobrar Mis Premios / Método de cobro – Retirar
function datalayerCobrarPremioMetodoCobroRetirar(metodo){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Cobrar Mis Premios',
			'SubZona': metodo,
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



// [9.7 #02] Cobrar Mis Premios / Método de cobro - Seleccionar un banco
// [9.7 #04] Cobrar Mis Premios / Método de cobro - Seleccionar departamento
function datalayerCobrarPremioMetodoCobroSelect(opcion,intencion){
	try{
		
		opcion = (typeof opcion == "string") ? opcion : $(opcion).find('option:selected').text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Cobrar Mis Premios',
			'TipoEvento': 'Interacción',
			'TipoZona': 'Mi Cuenta',
			'Zona': 'Cobrar Mis Premios',
			'SubZona': 'Transferencia Bancaria',
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



// [9.7 #03] Cobrar Mis Premios / Método de cobro - Ingresar número de cuenta
function datalayerCobrarPremioMetodoCobroIngNumCuenta(input,metodo){
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
			'Zona': 'Cobrar Mis Premios',
			'SubZona': metodo,
			'Sección': 'Método de cobro',
			'SubSección': metodo,
			'TipoElemento': 'TextBox',
			'Intención': 'Ingresar número de cuenta',
			'CTA': 'undefined',
			'PagePath': pagePathIframe(),
			'TimeStamp': new Date().getTime(),
			'TipoDispositivo': TipoDispositivo
		});
		
	}catch(error){
		console.error(error);
	}
}

// [9.13 #01] Pop-Up Cobrar premios / undefined - Retirar
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

// [4.1 #09] {Zona} / {Sección} - Cerrar Modal
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


// [1.3 #02] Tinka / ¡Combos Tinkeros! No te pierdas ni un sorteo - Cotejar
// [1.7 #02] Kábala / ¡Combos Kábala! No te pierdas ni un sorteo – Cotejar
// [1.10 #02] Gana Diario / ¡Combos Gana Diario! No te pierdas ni un sorteo – Cotejar
function datalayerComboCotejar(seccion){
	try{
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Coteja',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdate('TipoZona'),
			'Zona': zonaUpdate('Zona'),
			'SubZona': zonaUpdate('SubZona'),
			'Sección': seccion,
			'SubSección': 'undefined',
			'TipoElemento': 'Button',
			'Intención': 'Cotejar',
			'CTA': 'COTEJA TU BOLETO',
			'PagePath': pagePath(),
	      	'TimeStamp': new Date().getTime(),
	      	'TipoDispositivo': TipoDispositivo
		});

	}catch(error){
		console.error(error);
	}
}

// [1.3 #03] Tinka / Marca 6 bolillas o más – Cotejar
// [1.7 #03] Kábala / Marca 6 bolillas o más - Cotejar
// [1.10 #03] Gana Diario / Marca 5 bolillas o más – Cotejar
// [2.1 #05] Gana Gol / Programa - Cotejar
function datalayerMarcarBolillasCotejar(input,seccion){
	try{
		
		input = (typeof input == "string") ? input : $(input).text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Coteja',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdateIframe('TipoZona'),
			'Zona': zonaUpdateIframe('Zona'),
			'SubZona': 'undefined',
			'Sección': seccion,
			'SubSección': 'Paso 1',
			'TipoElemento': 'Button',
			'Intención': 'Cotejar',
			'CTA': input,
			'Paso1': 1, 'Paso2': 0, 'Paso3': 0, 'Paso4': 0, 
			'PagePath': pagePathIframe(),
	      	'TimeStamp': new Date().getTime(),
	      	'TipoDispositivo': TipoDispositivo
		});

	}catch(error){
		console.error(error);
	}
} 


//[1.3 #04] Tinka / Cotejar – Cotejar
//[1.7 #04] Kábala / Cotejar - Cotejar
//[1.10 #04] Gana Diario / Cotejar – Cotejar
//[2.1 #06] Gana Gol / Cotejar – Cotejar
function datalayerPaso2Cotejar(input){
	try{
		
		input = (typeof input == "string") ? input : $(input).text().trim();
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Coteja',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdateIframe('TipoZona'),
			'Zona': zonaUpdateIframe('Zona'),
			'SubZona': 'undefined',
			'Sección': 'Cotejar',
			'SubSección': 'Paso 2',
			'TipoElemento': 'Button',
			'Intención': 'Cotejar',
			'CTA': input,
			'Paso1': 0, 'Paso2': 1, 'Paso3': 0, 'Paso4': 0, 
			'PagePath': pagePathIframe(),
	      	'TimeStamp': new Date().getTime(),
	      	'TipoDispositivo': TipoDispositivo
		});

	}catch(error){
		console.error(error);
	}
} 


//[1.3 #05] Tinka / {Jugada} - {Intención}
//[1.7 #05] Kábala / {Jugada} - {Intención}
//[1.10 #05] Gana Diario / {Jugada} - {Intención}
//[2.1 #07] Gana Gol / {Jugada} - {Intención}
function datalayerJuegoJugadaIntencion(jugada,intencion,boton){
	try{
		
		dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualEvent',
			'Proceso': 'Coteja',
			'TipoEvento': 'Interacción',
			'TipoZona': zonaUpdateIframe('TipoZona'),
			'Zona': zonaUpdateIframe('Zona'),
			'SubZona': 'undefined',
			'Sección': jugada,
			'SubSección': 'Paso 3',
			'TipoElemento': 'Button',
			'Intención': intencion,
			'CTA': boton,
			'Paso1': 0, 'Paso2': 0, 'Paso3': 1, 'Paso4': 0,
			'PagePath': pagePathIframe(),
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

        if (userId === 'undefined' || ID_Juego === 0) {
            console.warn('Algunos valores para Cargar Saldo están indefinidos.');
        }

        var TimeStamp = new Date().getTime();

        dataLayer.push({
            'event': 'userData',
            'userID': userId,
            'PagePath': PagePath,
            'TimeStamp': TimeStamp
        });

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
