function taggingEligeCincoOmas(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-ganadiario/individual/paso1/',
		    'pageTitle': 'Elige tus Bolillas - Individual - Gana Diario'

		});
		
		console.log("taggingEligeCincoOmas");
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
		    'action': 'Gana Diario :: Click', // Indicar el nombre del juego que corresponda.
		    'label': 'Al azar'
		});
			
		console.log("taggingClicAzar");
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
				taggingSiguienteGD();
				taggingJuegaGDPaso2();
				taggingGanadiarioCheckout();
			}
			if(op==="haveBoleto"){
				taggingJuegaGDPaso2();
			}
			if(op==="consecutive"){
				var cantSorteos=$("#consecutivas").val();
				if(cantSorteos>1){
					taggingSiguienteGD();
				taggingJuegaGDPaso2();
					taggingGanadiarioCheckout();								
				}else{
					taggingJuegaGDPaso2();
				}	
				
			}
			if(op==="removeConsecutive"){
				var priceJuegoDelete=$("#priceJuegoDelete").val();
				if(parseFloat(priceJuegoDelete)>0.00){
					taggingRemoveFromCart();
				taggingJuegaGDPaso2();
					var importePagar=$("#importePagar").val();
					var importePagar=$("#importePagar").val();
					if(parseFloat(importePagar)>0.00){
						taggingGanadiarioCheckout();
					}								
				}else{
					taggingJuegaGDPaso2();
				}
			}		
			if(op==="delete"){					
				taggingRemoveFromCart();
				taggingJuegaGDPaso2();
				var importePagar=$("#importePagar").val();
				if(parseFloat(importePagar)>0.00){
					taggingGanadiarioCheckout();
				}					
			}			
		}else{
			taggingJuegaGDPaso2();
		}
	}catch(e){
		console.error(e);
	}
	

}



function taggingSiguienteGD(){
	try{
		var price=parseFloat($("#lastPrice").val()).toFixed(2);		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Gana Diario Jugada Individual',
		        'id': 'ganaInd',
		        'price': price,    //Indicar aquí el “Costo total” de la jugada
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Gana Diario'        
		       }]
		    }
		  }
		});
		console.log("taggingSiguienteGD");
	}catch(e){
		console.error(e);
	}
}


function taggingJuegaGDPaso2(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-ganadiario/individual/paso2/',
		    'pageTitle': 'Finaliza tu compra - Individual - Gana Diario'
		});
		
		console.log("taggingJuegaGDPaso2");
	}catch(e){
		console.error(e);
	}

}


function taggingGanadiarioCheckout(){
	try{
		var price = $("#importePagar").val(); 
		price = parseFloat(price).toFixed(2);
//		var cantidadJugadas=$("#jugadasActuales").val();
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',
		   'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{ // Aquí se listan todos los productos individuales
		          'name': 'Gana Diario Jugada Individual', 
		          'id': 'ganaInd',
		          'price': price,   //Indicar el precio de la jugada
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Gana Diario'
		       }]
		    }
		  }
		});
		
		console.log("taggingGanadiarioCheckout");
	}catch(e){
		
	}
		
}

function taggingGDContinuar(){

	var cantidadSorteos= $('#consecutiveParam').val();
    var importePagar=$('#importePagar').val();
    
    if(cantidadSorteos!=""){
	var costoTotal=$("#");
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	  'event': 'EEaddToCart',
	  'ecommerce': {
	    'currencyCode': 'PEN',
	    'add': {                    
	      'products': [{        
	        'name': 'Gana Diario Jugada Individual',
	        'id': 'ganaInd',
	        'price': importePagar,    //Indicar aquí el “Costo total” de la jugada
	        'brand': 'Juegos',
	        'quantity': '1', 
	        'category': 'Gana Diario'        
	       }]
	    }
	  }
	});
	 console.log("taggingGDContinuar");
	
    }
	
}

//eiminar en jugada
function taggingRemoveFromCart(){
	try{
		var price=parseFloat($("#priceJuegoDelete").val()).toFixed(2);		 	
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{ 
		          'name': 'Gana Diario Jugada Individual', 
		          'id': 'ganaInd',
		          'price': price,   //Indicar el precio a descontar
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Gana Diario'
		       }]
		    }
		  }
		});
		console.log("taggingRemoveFromCart");
	}catch(e){
		console.error(e);
	}
		
}

//Eliminar en sorteos

function taggingRemoveSlider_sorteos(){
	
	   var cantidadSorteos= $('#consecutivas').val(); 
	   var importePagar=$('#importePagar').val();
	   
	   var precioDesc=0;
	   var price=0;
	   if(cantidadSorteos>1){
		   precioDesc=parseFloat(importePagar)/parseFloat(cantidadSorteos); 
		   price=parseFloat(importePagar)-precioDesc;
	 	   }
			
	   window.dataLayer = window.dataLayer || [ ];
	   dataLayer.push({
	     'event': 'EEremoveFromCart',
	     'ecommerce': {
	       'remove': {                             
	         'products': [{ 
	             'name': 'Gana Diario Jugada Individual', 
	             'id': 'ganaInd',
	             'price': price,   //Indicar el precio a descontar
	             'brand': 'Juegos',
	             'quantity': '1',
	             'category': 'Gana Diario'
	          }]
	       }
	     }
	   });

     console.log("taggingRemoveSlider sorteos");

		}


//function funcionestTaggingResult(){
//	taggingGracisPorTuCompra();
//	tagginPrepararParametrosGD();
//}

function funcionesTaggingCompra() {
	try{
		var navigation = window.performance.navigation.type;
		var status = $("#status").val();
		if (navigation == 0) {
			if (status == "ok") {
				taggingGracisPorTuCompra();
				tagginPrepararParametrosGD();
			} else {
				var alertPlay = $("#alertPlay").val();
				taggingJugadaNoProcesada(alertPlay);
			}

		} else {
			if (status == "ok") {
				taggingGracisPorTuCompra();
			} else {
				var alertPlay = $("#alertPlay").val();
				taggingJugadaNoProcesada(alertPlay);
			}

		}
	}catch(e){
		console.error(e);
	}	
}

function taggingGracisPorTuCompra(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		  dataLayer.push({
		  'event': 'compraExitosa',
		  'pageUrl': '/juega-ganadiario/individual/confirmacion/',
		  'pageTitle': 'Compra exitosa - Individual - Gana Diario'
		});
		console.log("taggingGraciasPorTuCompra");
	}catch(e){
		console.error(e);
	}
}


function tagginPrepararParametrosGD (){

	var status=$("#status").val();
	 if (status=="ok"){
		var codigoTran=$("#ticketId").val();
		codigoTran="GD-"+codigoTran;
		var montoTotal=$("#importePagar").val();	
		montoTotal=parseFloat(montoTotal).toFixed(2);
		var cantidadJugadas=$("#jugadasActuales").val();
		var jugadasGratis=$("#jugadasGratis").val();		
		var contJuRe=0;	
		var cantSorteos=$("#consecutivas").val();
		if(cantSorteos==""){
			cantSorteos="1";
		}	
		var promedioBolillas="";	
		
		var cantA=0;		
		var numBoljugadaA=$("#numBolJugadaA").val();		
		if(numBoljugadaA!=""){
			cantA=numBoljugadaA;
			contJuRe=contJuRe+1;
		}
		else{
			cantA=0;
		}
	
		var cantB=0;
		var numBoljugadaB=$("#numBolJugadaB").val();		
		if(numBoljugadaB!=""){
			cantB=numBoljugadaB;
			contJuRe=contJuRe+1;
		}
		else{
			cantB=0;
		}
	
		var cantC=0;
		var numBoljugadaC=$("#numBolJugadaC").val();		
		if(numBoljugadaC!=""){
			cantC=numBoljugadaC;
			contJuRe=contJuRe+1;
		}
		else{
			cantC=0;
		}
	
		var cantD=0;
		var numBoljugadaD=$("#numBolJugadaD").val();		
		if(numBoljugadaD!=""){
			cantD=numBoljugadaD;
			contJuRe=contJuRe+1;
		}
		else{
			cantD=0;
		}
			
		promedioBolillas=parseFloat(parseInt(cantA)+parseInt(cantB)+parseInt(cantC)+parseInt(cantD))/parseInt(contJuRe);
		promedioBolillas=promedioBolillas.toFixed(1);
	
		//preguntar por jugadas Gratis sino hay  hacer este evento 
	
		//var cantidadJGratis=;
		if(parseInt(jugadasGratis)>= (parseInt(cantidadJugadas))*parseInt(cantSorteos)){
			tagginJuegaGDPurchaseGratis (codigoTran,cantidadJugadas,cantSorteos,promedioBolillas);
		}
		else{
			taggingJuegaGDPurcharse(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioBolillas);
		}

	 }
	 else if(status=="error"){
			var mensaje="OCURRI\u00F3 UN ERROR, INT\u00E9NTALO NUEVAMENTE";
			taggingJugadaNoProcesada(mensaje);
		}
		 else if(status=="saldo"){
			taggingJugadaNoProcesada("NO CUENTAS CON SALDO SUFICIENTE");
		}
	
}


function taggingJuegaGDPurcharse_1(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioBolillas){

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
		        'name': 'Gana Diario Jugada Individual',   
		        'id': 'ganaInd',
		        'price': montoTotal,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Gana Diario',
		        'metric1': cantidadJugadas,                 //indicar cantidad de jugadas
		        'dimension3': cantSorteos,        // Indicar cantidad de sorteos consecutivos
		        'dimension4': promedioBolillas    // aquí indicar el promedio de número de bolillas
		       }]
		    }
		  }
		});
		console.log("taggingJuegaGDPurcharse");
	}catch(e){
		console.error(e);
	}
	
	
}

function taggingJuegaGDPurcharse(codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioBolillas){

	try{
		var formatPricePerPlay2= $('#formatPricePerPlay2').val();
		var jugadasActuales= parseInt(cantidadJugadas);
		var consecutive= parseInt(cantSorteos);
		var discountPayment= $('#discountPayment').val();
		var promotionMessage= 'Promo '+$('#promotionMessage').val();
		//Si es jugada MxN		
		if((formatPricePerPlay2 * jugadasActuales * consecutive) != discountPayment){
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
		        'name': 'Gana Diario Jugada Individual',   
		        'id': 'ganaInd',
		        'price': montoTotal,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Gana Diario',
			        'variant': promotionMessage,
		        'metric1': cantidadJugadas,                 //indicar cantidad de jugadas
		        'dimension3': cantSorteos,        // Indicar cantidad de sorteos consecutivos
		        'dimension4': promedioBolillas    // aquí indicar el promedio de número de bolillas
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
			        'name': 'Gana Diario Jugada Individual',   
			        'id': 'ganaInd',
			        'price': montoTotal,
			        'brand': 'Juegos',
			        'quantity': '1',
			        'category': 'Gana Diario',
			        'variant': 'jugada estandar',
			        'metric1': cantidadJugadas,                 //indicar cantidad de jugadas
			        'dimension3': cantSorteos,        // Indicar cantidad de sorteos consecutivos
			        'dimension4': promedioBolillas    // aquí indicar el promedio de número de bolillas
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


function tagginJuegaGDPurchaseGratis(codigoTran,cantidadJugadas,cantSorteos,promedioBolillas){

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
		        'name': 'Gana Diario Jugada Individual',   
		        'id': 'ganaInd',
		        'price': '0.00',
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Gana Diario',
		        'variant': 'jugada gratis',
		        'metric1': cantidadJugadas,             //indicar cantidad de jugadas gratis
		        'dimension3': cantSorteos,     // Indicar cantidad de sorteos consecutivos
		        'dimension4': promedioBolillas     // aquí indicar el promedio de número de bolillas
		       }]
		    }
		  }
		});

		console.log("tagginJuegaTKPurchaseGratis");
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
	    'action': 'Error :: Gana Diario',
	    'label': mensaje // aquí deben indicar el mensaje de error
	});
  console.log("taggingPopupError");
	}catch(e){
		console.eror(e);
	}

}

function taggingJugadaNoProcesada(mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': 'Error :: Gana Diario',  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingJugadaNoProcesada");
	}catch(e){
		console.eror(e);
	}
}