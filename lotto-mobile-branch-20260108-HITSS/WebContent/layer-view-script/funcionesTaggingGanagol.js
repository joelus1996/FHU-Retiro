function taggingMarcaTuJugada(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-ganagol/paso1/',
		    'pageTitle': 'Elige tu Jugada - Ganagol'
		});
		
		console.log("taggingMarcaTuJugada");
	}catch(e){
		console.error(e);
	}
	
}

function taggingClickAzar(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'alAzar',
		    'category': 'UI :: Jugar',
		    'action': 'Ganagol :: Click', // Indicar el nombre del juego que corresponda.
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
		    'action': 'Error :: Ganagol',
		    'label': mensaje // aquí deben indicar el mensaje de error
		});
		console.log("taggingPopupError");
	}catch(e){
		console.eror(e);
	}
}

function funcionesTagging() {
	try{
		var navigation = performance.navigation.type;
		if (navigation == 0) {			
			
			var op=$("#operation").val();
			if(op==="add"){
				taggingGGAddToCart();
				taggingJuegaGGPaso2();
				taggingGGCheckout();
			}
			

			if (op === "delete") {
				taggingRemoveFromCart();
				taggingJuegaGGPaso2();
				var importePagar = $("#importePagar").val();
				if (parseFloat(importePagar) > 0.00) {
					taggingGGCheckout();
				}
			}
			
			if (op === "default") {
				taggingJuegaGGPaso2();
			}
//			if(op==="haveBoleto"){
//				taggingJuegaGDPaso2();
//			}
//			if(op==="consecutive"){
//				var cantSorteos=$("#consecutivas").val();
//				if(cantSorteos>1){
//					taggingSiguienteGD();
//					taggingJuegaGDPaso2();
//					taggingGanadiarioCheckout();								
//				}else{
//					taggingJuegaGDPaso2();
//				}	
//				
//			}
//			if(op==="removeConsecutive"){
//				var priceJuegoDelete=$("#priceJuegoDelete").val();
//				if(parseFloat(priceJuegoDelete)>0.00){
//					taggingRemoveFromCart();
//					taggingJuegaGDPaso2();
//					var importePagar=$("#importePagar").val();
//					var importePagar=$("#importePagar").val();
//					if(parseFloat(importePagar)>0.00){
//						taggingGanadiarioCheckout();
//					}								
//				}else{
//					taggingJuegaGDPaso2();
//				}
//			}		
			
		}else{
			taggingJuegaGGPaso2();
		}
	}catch(e){
		console.error(e);
	}	

}

function taggingGGAddToCart(){
	try{
		var price=parseFloat($("#lastPrice").val()).toFixed(2);		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{   
		        'name': 'Ganagol Jugada Individual',   
		        'id': 'ganagol',
		        'price': price,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Ganagol'  
		       }]
		    }
		  }
		});

		console.log("taggingGGAddToCart");
	}catch(e){
		console.error(e);
	}
}

function taggingJuegaGGPaso2(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-ganagol/paso2/',
		    'pageTitle': 'Finaliza tu compra - Ganagol'
		});		
		console.log("taggingJuegaGGPaso2");
	}catch(e){
		console.error(e);
	}

}

function taggingGGCheckout(){
	try{
		var price = $("#importePagar").val(); 
		price = parseFloat(price).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{ // Aquí se listan todas las jugadas individuales          
		          'name': 'Ganagol Jugada Individual',   
		          'id': 'ganagol',
		          'price': price,
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Ganagol'     
		       }]
		    }
		  }
		});
		
		console.log("taggingGGCheckout");
	}catch(e){
		
	}
		
}

function taggingRemoveFromCart(){
	try{
		var price=parseFloat($("#priceJuegoDelete").val()).toFixed(2);		 	
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{ 
		        'name': 'Ganagol Jugada Individual',   
		        'id': 'ganagol',
		        'price': price,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Ganagol'  
		       }]
		    }
		  }
		});
		console.log("taggingRemoveFromCart");
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
				taggingGGCompraExitosa();
				tagginPrepararParametrosGG();
			} else {
				var alertPlay = $("#alertPlay").val();
				taggingGGJugadaNoProcesada(alertPlay);
			}

		} else {
			if (status == "ok") {
				taggingGGCompraExitosa();
			} else {
				var alertPlay = $("#alertPlay").val();
				taggingGGJugadaNoProcesada(alertPlay);
			}

		}
	}catch(e){
		console.error(e);
	}	
}

function taggingGGCompraExitosa(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'compraExitosa',
		'pageUrl': '/juega-ganagol/confirmacion/',
		'pageTitle': 'Compra exitosa - Ganagol'
		});

		console.log("taggingGGCompraExitosa");
	}catch(e){
		console.error(e);
	}
}

function tagginPrepararParametrosGG (){
		var codigoTran=$("#ticketId").val();
		codigoTran="GG-"+codigoTran;
		var montoTotal=$("#importePagar").val();	
		montoTotal=parseFloat(montoTotal).toFixed(2);
		var cantidadJugadas=$("#jugadasActuales").val();
		var jugadasGratis=$("#jugadasGratis").val();		
		var contJuRe=0;	
		var cantSorteos=$("#consecutivas").val();
		if(cantSorteos==""){
			cantSorteos="1";
		}	
		var promedioResultados="";	
		
		var cantA=0;		
		var numResjugadaA=$("#numResJugadaA").val();		
		if(numResjugadaA!=""){
			cantA=numResjugadaA;
			contJuRe=contJuRe+1;
		}
		else{
			cantA=0;
		}
	
		var cantB=0;
		var numResjugadaB=$("#numResJugadaB").val();		
		if(numResjugadaB!=""){
			cantB=numResjugadaB;
			contJuRe=contJuRe+1;
		}
		else{
			cantB=0;
		}
	
		var cantC=0;
		var numResjugadaC=$("#numResJugadaC").val();		
		if(numResjugadaC!=""){
			cantC=numResjugadaC;
			contJuRe=contJuRe+1;
		}
		else{
			cantC=0;
		}
	
		var cantD=0;
		var numResjugadaD=$("#numResJugadaD").val();		
		if(numResjugadaD!=""){
			cantD=numResjugadaD;
			contJuRe=contJuRe+1;
		}
		else{
			cantD=0;
		}
			
		promedioResultados=parseFloat(parseInt(cantA)+parseInt(cantB)+parseInt(cantC)+parseInt(cantD))/parseInt(contJuRe);
		promedioResultados=promedioResultados.toFixed(1);
	
		//preguntar por jugadas Gratis sino hay  hacer este evento 
	
		//var cantidadJGratis=;
		if(parseInt(jugadasGratis)>=parseInt(cantidadJugadas)){
			tagginJuegaGGPurchaseGratis (codigoTran,cantidadJugadas,cantSorteos,promedioResultados);
		}
		else{
			taggingJuegaGGPurcharse(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioResultados);
		}
}

function taggingJuegaGGPurcharse(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioResultados){

	try{
		var formatPricePerPlay2= parseFloat($('#formatPricePerPlay2').val());
		var jugadasActuales= parseInt(cantidadJugadas);
		var discountPayment= parseFloat($('#discountPayment').val());
		var promotionMessage= 'Promo '+$('#promotionMessage').val();
		if((formatPricePerPlay2 * jugadasActuales) != discountPayment){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			'event': 'EEpurchase',
			  'ecommerce': {
			    'purchase': {
			      'actionField': {
			        'id': codigoTran,                             // Código de la transacción        
			        'revenue': montoTotal,                      // Monto total pagado
			      },
			      'products': [{                            //Aca se listan las jugadas individuales
			        'name': 'Ganagol Jugada Individual',   
			        'id': 'ganagol',
			        'price': montoTotal,
			        'brand': 'Juegos',		        
			        'category': 'Ganagol',
			        'variant': promotionMessage,
			        'quantity': '1',
			        'metric1': cantidadJugadas,                 //indicar cantidad de jugadas
			        'dimension4': promedioResultados    // aquí indicar el promedio de número de resultados
			       }]
			    }
			  }
			});
		}else{
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			'event': 'EEpurchase',
			  'ecommerce': {
			    'purchase': {
			      'actionField': {
			        'id': codigoTran,                             // Código de la transacción        
			        'revenue': montoTotal,                      // Monto total pagado
			      },
			      'products': [{                            //Aca se listan las jugadas individuales
			        'name': 'Ganagol Jugada Individual',   
			        'id': 'ganagol',
			        'price': montoTotal,
			        'brand': 'Juegos',		        
			        'category': 'Ganagol',
			        'variant': 'jugada estandar',
			        'quantity': '1',
			        'metric1': cantidadJugadas,                 //indicar cantidad de jugadas
			        'dimension4': promedioResultados    // aquí indicar el promedio de número de resultados
			       }]
			    }
			  }
			});
		}
		
		console.log("taggingJuegaGDPurcharse");
	}catch(e){
		console.error(e);
	}	
}

function taggingJuegaGGPurcharse_1(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioResultados){

	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': codigoTran,                             // Código de la transacción        
		        'revenue': montoTotal,                      // Monto total pagado
		      },
		      'products': [{                            //Aca se listan las jugadas individuales
		        'name': 'Ganagol Jugada Individual',   
		        'id': 'ganagol',
		        'price': montoTotal,
		        'brand': 'Juegos',		        
		        'category': 'Ganagol',
		        'quantity': '1',
		        'metric1': cantidadJugadas,                 //indicar cantidad de jugadas
		        'dimension4': promedioResultados    // aquí indicar el promedio de número de resultados
		       }]
		    }
		  }
		});
		console.log("taggingJuegaGDPurcharse");
	}catch(e){
		console.error(e);
	}	
}


function tagginJuegaGGPurchaseGratis(codigoTran,cantidadJugadas,cantSorteos,promedioResultados){

	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': codigoTran,                             // Código de la transacción        
		        'revenue': '0.00',                      // Para el caso de jugadas gratis 0
		      },
		      'products': [{                            
		        'name': 'Ganagol Jugada Individual',   
		        'id': 'ganagol',
		        'price': '0.00',
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Ganagol',
		        'variant': 'jugada gratis',
		        'metric1': cantidadJugadas,             //indicar cantidad de jugadas gratis
		        'dimension4': promedioResultados     // aquí indicar el promedio de número de bolillas
		       }]
		    }
		  }
		});

		console.log("tagginJuegaGGPurchaseGratis");
	}catch(e){
		console.error(e);
	}
	
	
}


function taggingGGJugadaNoProcesada(mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': 'Error :: Ganagol',  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingGGJugadaNoProcesada");
	}catch(e){
		console.eror(e);
	}
}

