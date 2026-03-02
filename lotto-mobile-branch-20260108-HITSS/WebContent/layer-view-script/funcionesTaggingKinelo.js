


function taggingJuegaKinelo(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-kinelo/paso1/',
		    'pageTitle': 'Elige tu Jugada - Kinelo'

		});
		console.log("taggingJuegaKinelo");		
	}catch(e){
		console.error(e);
	}

	
}

function taggingClicAzar(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'alAzar',
		    'category': 'UI :: Jugar',
		    'action': 'Kinelo :: Click', // Indicar el nombre del juego que corresponda.
		    'label': 'Al azar'
		});
			
		console.log("taggingClicAzar");
	}catch(e){
		console.error(e);
	}

	
}


function taggingPopupError(mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'popupError',
		    'category': 'UI :: Jugar',
		    'action': 'Error :: Kinelo',
		    'label': mensaje // aquí deben indicar el mensaje de error
		});
		console.log("taggingPopupError");
	}catch(e){
		console.error(e);
	}

}


function funcionesTagging() {
	try{
		var navigation = performance.navigation.type;
		if (navigation == 0) {		
			var op=$("#operation").val();
			if(op==="add"){
				taggingAddToCartSig();
				taggingFinaizarPaso2();
				taggingChekout();
			}
//			if(op==="haveBoleto"){
//				taggingFinaizarPaso2();
//			}
			if(op==="consecutive"){
				var num_draw=parseInt($("#num_draw").val());
				var costoTotal=parseInt($("#total_apagar2").val());
				if(num_draw>1 && costoTotal>0){
					taggingAddToCartSigConsecutive();
					taggingFinaizarPaso2();
					taggingChekout();
				}else{
					taggingFinaizarPaso2();
				}
				
			}
			if(op==="removeConsecutive"){
				var remove_num_draw=parseInt($("#remove_num_draw").val());
				var costoTotal=parseInt($("#total_apagar2").val());
				if(remove_num_draw>1 && costoTotal>0){
					taggingRemoveConsecutive();
					taggingFinaizarPaso2();
					taggingChekout();
				}else{
					taggingFinaizarPaso2();
				}
			}		
			if(op==="delete"){					
				taggingRemove();
				taggingFinaizarPaso2();
				var importePagar=$("#total_apagar2").val();
				if(parseFloat(importePagar)>0.00){
					taggingChekout();
				}					
			}
			if(op==="default"){
				taggingFinaizarPaso2();
			}
		}else{
			taggingFinaizarPaso2();
		}
	}catch(e){
		console.error(e);
	}
	

}

function taggingAddToCartSig(){	
	try{
		var lastPlay=$("#lastPlay").val();
		var costoTotal=$("#"+lastPlay).val();
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{        
		        'name': 'Kinelo Jugada Individual',   
		        'id': 'kinelo',
		        'price': costoTotal, //Indicar el Costo Total
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kinelo'         
		       }]
		    }
		  }
		});
		console.log("taggingAddToCartSig");
	}catch(e){
		console.error(e);
	}
}

function taggingAddToCartSigConsecutive(){	
	try{
		var num_draw=parseInt($("#num_draw").val());
		var costoTotal=parseInt($("#total_apagar2").val());
		costoTotal=(costoTotal-(costoTotal/num_draw)).toFixed(2);
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{        
		        'name': 'Kinelo Jugada Individual',   
		        'id': 'kinelo',
		        'price': costoTotal, //Indicar el Costo Total
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kinelo'         
		       }]
		    }
		  }
		});
		console.log("taggingAddToCartSigConsecutive");
	}catch(e){
		console.error(e);
	}
}



function taggingFinaizarPaso2(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-kinelo/paso2/',
		    'pageTitle': 'Finaliza tu compra - Kinelo'

		});
		console.log("taggingFinaizarPaso2");
	}catch(e){
		console.error(e);
	}	

}



function taggingChekout(){	
	try{
		var price=$("#total_apagar2").val();
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',

		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{ //Aquí se listan todas las jugadas individuales
		          'name': 'Kinelo Jugada Individual',   
		          'id': 'kinelo',
		          'price': price,
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Kinelo'      
		       }]
		    }
		  }
		});
		
		console.log("taggingChekout");
	}catch(e){
		console.error(e);
	}	
}


function taggingContinuar(){
	
	var price=$("#total_apagar2").val();
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'EEaddToCart',
	  'ecommerce': {
	    'currencyCode': 'PEN',
	    'add': {                   
	      'products': [{        
	        'name': 'Kinelo Jugada Individual',   
	        'id': 'kinelo',
	        'price': price, //Indicar el Costo Total
	        'brand': 'Juegos',
	        'quantity': '1',
	        'category': 'Kinelo'         
	       }]
	    }
	  }
	});

	
}


function taggingRemove(){
	try{
		var precioDesc=$("#lastDelete").val();
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{ 
		        'name': 'Kinelo Jugada Individual',   
		        'id': 'kinelo',
		        'price': precioDesc,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kinelo'  
		       }]
		    }
		  }
		});
		
		console.log("taggingRemove");
	}catch(e){
		console.error(e);
	}
}

function taggingRemoveConsecutive(){
	try{
		var remove_num_draw=parseInt($("#remove_num_draw").val());
		var precioDesc=parseInt($("#total_apagar2").val());
		precioDesc=(precioDesc*remove_num_draw - precioDesc).toFixed(2);
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{ 
		        'name': 'Kinelo Jugada Individual',   
		        'id': 'kinelo',
		        'price': precioDesc,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kinelo'  
		       }]
		    }
		  }
		});
		
		console.log("taggingRemoveConsecutive");
	}catch(e){
		console.error(e);
	}
}

function funcionesTaggingCompra() {
	try{
		var navigation = window.performance.navigation.type;
		var status = $("#status").val();
		if (navigation == 0) {
			if (status == "ok") {
				taggingGraciasPorCompra();
				tagginPrepararParametrosKN();
			} else {
				var alertPlay = $("#alertPlay").val();
				taggingJugadaNoProcesada(alertPlay);
			}

		} else {
			if (status == "ok") {
				taggingGraciasPorCompra();
			} else {
				var alertPlay = $("#alertPlay").val();
				taggingJugadaNoProcesada(alertPlay);
			}

		}
	}catch(e){
		console.error(e);
	}	
}




function taggingGraciasPorCompra(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'compraExitosa',
		'pageUrl': '/juega-kinelo/confirmacion/',
		'pageTitle': 'Compra exitosa - Kinelo',

		});
		console.log("taggingGraciasPorCompra");
	} catch(e){
		console.error(e);
	}
	
}

function tagginPrepararParametrosKN(){	

	var codigoTran=$("#ticketId").val();
	codigoTran="KN-"+codigoTran;
	var montoTotal=$("#importePagar").val();	
	montoTotal=parseFloat(montoTotal).toFixed(2);
	var cantidadJugadas=$("#totalApuestas").val();
	var jugadasGratis=$("#jugadasGratis").val();
	
	var multiplicaA=$("#multiplierBetAuxA").val();
	var multiplicaB=$("#multiplierBetAuxB").val();;
	
	if(multiplicaA==""){
		multiplicaA="1";		
	}
	
	if(multiplicaB==""){
		multiplicaB="1";		
	}	
		
	var contJuRe=0;
	var cantSorteos=$("#num_drawAux").val();
	if(cantSorteos==""){
		cantSorteos="1";
	}
	cantidadJugadas=""+(parseInt(cantidadJugadas)*parseInt(cantSorteos));

	var promedioBolillas="";
	var multiplicaProm="";


	var numBoljugadaA=$("#numBolJugadaA").val();	
	if(numBoljugadaA!="" && parseInt(numBoljugadaA)>0){
	contJuRe++;
	}

	var numBoljugadaB=$("#numBolJugadaB").val();	
	if(numBoljugadaB!="" && parseInt(numBoljugadaB)>0){
	contJuRe++;
	}
	
	promedioBolillas=parseFloat(parseInt(numBoljugadaA)+parseInt(numBoljugadaB))/parseInt(contJuRe);
	promedioBolillas=promedioBolillas.toFixed(1);
	
	if(parseInt(numBoljugadaA)==0){
		multiplicaA="0";
	}
	if(parseInt(numBoljugadaB)==0){
		multiplicaB="0";
	}	
	multiplicaProm=(parseInt(multiplicaA)+parseInt(multiplicaB))/parseInt(contJuRe);
	multiplicaProm=multiplicaProm.toFixed(1);

	//preguntar por jugadas Gratis sino hay  hacer este evento 

	//var cantidadJGratis=;
	if(parseInt(jugadasGratis)>=parseInt(cantidadJugadas)*parseFloat(multiplicaProm)){
		tagginKNPurchaseGratis (codigoTran,cantidadJugadas,cantSorteos,promedioBolillas,multiplicaProm);
	}
	else{
		taggingKNPurchase(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioBolillas,multiplicaProm);
	}
	
}

function taggingKNPurchase(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioBolillas,multiplicaProm){
	
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': codigoTran,                         //Código de la transacción        
		        'revenue': montoTotal,                      //Monto total pagado
		      },
		      'products': [{                         
		        'name': 'Kinelo Jugada Individual',   
		        'id': 'kinelo',
		        'price': montoTotal,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kinelo',
		        'variant': 'jugada estandar',
		        'dimension4': promedioBolillas,      // aquí indicar el promedio de número de bolilla
		        'metric1': cantidadJugadas,             // indicar número de jugadas
		        'dimension5': multiplicaProm,     // indicar multiplicador premio
		        'dimension3': cantSorteos      // indicar sorteos consecutivos
		       }]
		    }
		  }
		});
		
		console.log("taggingKNPurchase");
	}catch(e){
		console.error(e);
	}
	
}


function tagginKNPurchaseGratis(codigoTran,cantidadJugadas,cantSorteos,promedioBolillas,multiplicaProm){
	
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': codigoTran,                         //Código de la transacción        
		        'revenue': '0.00',                      //Monto total pagado
		      },
		      'products': [{                         
		        'name': 'Kinelo Jugada Individual',   
		        'id': 'kinelo',
		        'price': '0.00',
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kinelo',
		        'variant': 'jugada gratis',
		        'dimension4': promedioBolillas,      // aquí indicar el promedio de número de bolilla
		        'metric1': cantidadJugadas,             // indicar número de jugadas
		        'dimension5': multiplicaProm,     // indicar multiplicador premio
		        'dimension3': cantSorteos      // indicar sorteos consecutivos
		       }]
		    }
		  }
		});
		console.log("tagginKNPurchaseGratis");

	}catch(e){
		console.error(log);
	}	
}



function taggingJugadaNoProcesada(mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': 'Error :: Kinelo',  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingJugadaNoProcesada");
	}catch(e){
		console.error(e);
	}
	

}
