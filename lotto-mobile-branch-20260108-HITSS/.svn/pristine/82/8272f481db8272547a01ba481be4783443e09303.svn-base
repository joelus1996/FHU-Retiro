
function taggingOlvidasteContrasenia(){
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageTitle': 'Restablecer Password',
	    'pageUrl': '/restablecer-password/paso1/',
	    'category': 'UI :: Login',
	    'action': 'Restablecer Password',
	    'label': 'Ingresar Email'
	});
   console.log("Tagging olvidaste contrasenia");
}


function tagginErrorEnviarEmail(mensaje){
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'restablecerPasswordError',
	    'category': 'UI :: Login',
	    'action': 'Error :: Restablecer Password',
	    'label': mensaje  //Enviar el mensaje de error que corresponda

	});  

	  console.log("Tagging error enviar email");
	
}

function taggingEmailEnviado(){
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageTitle': 'Generar Nuevo Password',
	    'pageUrl': '/restablecer-password/paso2/',
	    'category': 'UI :: Login',
	    'action': 'Restablecer Password',
	    'label': 'Generar nuevo password'
	});
	 console.log("Tagging email enviado");
}

function taggingErrorIgualDatos(mensaje){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'restablecerPasswordError',
	    'category': 'UI :: Login',
	    'action': 'Error :: Restablecer Password',
	    'label': mensaje  //Enviar el mensaje de error que corresponda
	});

	 console.log("Tagging error igual datos");
	
}

function taggingContraseniaActualizada(){
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'passwordActualizado',
	    'category': 'UI :: Login',
	    'action': 'Restablecer Password',
	    'label': 'Password actualizado'
	});
	 console.log("Tagging contrasenia actualizada");
	
}

function taggingOlvidasteUsuario(){	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageTitle': 'Recordar Usuario',
	    'pageUrl': '/recordar-usuario/',
	    'category': 'UI :: Login',
	    'action': 'Recordar Usuario',
	    'label': 'Ingresar Email'
	});
	 console.log("Tagging olvidaste tu usuario");
}

function taggingTuUsuarioEnviado(){	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'usuarioEnviado',
	    'category': 'UI :: Login',
	    'action': 'Recordar Usuario',
	    'label': 'Usuario enviado'
	});
	 console.log("Tagging usuario ha sido enviado");
	
}

function taggingCorreoNoRegistrado(mensaje){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'errorRecordarUsuario',
	    'category': 'UI :: Login',
	    'action': 'Error :: Recordar Usuario',
	    'label': mensaje  //Enviar el mensaje de error que corresponda
	});

	 console.log("Tagging usuario error email no reg.");
}

//combos tinkeros

function taggingCombosTinkeros(numeroCombo){
	try{
		if(numeroCombo!=undefined && numeroCombo!=null && numeroCombo!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			    'event': 'virtualPageView',
			    'pageUrl': '/juega-tinka/combo/paso1/',
			    'pageTitle': 'Elige tu jugada - Combo - Tinka',
				'combo': numeroCombo // indicar número de combo seleccionado
			});
			console.log("taggingCombosTinkeros: "+numeroCombo);
		}
	}catch (e) {
		console.error(e);
	}		
}

function taggingCombosTinkerosBet(numeroComb){
	try{
		if(numeroComb!=undefined && numeroComb!=null && numeroComb!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			    'event': 'virtualPageView',
			    'pageUrl': '/juega-tinka/combo/paso2/',
			    'pageTitle': 'Elige tus Bolillas - Combo - Tinka',
			    'combo': numeroComb // indicar número de combo de seleccionado	
			});
			console.log("taggingCombosTinkerosBet: "+numeroComb);
		}
	}catch (e) {
		console.error(e);	
	}
}

function taggingSiguienteAddToCart(name,id,price){
	try {
		price=parseFloat(price).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{
		        'name': name,
		        'id': id,
		        'price': price,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Tinka'        
		       }]
		    }
		  }
		});
		console.log("Tagging taggingSiguienteAddToCart: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosTinkerosError(nombreJuego,mensaje){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'popupError',
		    'category': 'UI :: Jugar',
		    'action': nombreJuego,  // Incluir el nombre del juego que corresponda
		    'label': mensaje // Aquí deberían indicar el mensaje de error.
		});
		console.log("Tagging taggingCombosTinkerosError: action:"+nombreJuego+", label:"+mensaje);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosTinkerosFinaliza(numeroComboSel){
	try {
		if(numeroComboSel!=undefined && numeroComboSel!=null && numeroComboSel!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			    'event': 'virtualPageView',
			    'pageUrl': '/juega-tinka/combo/paso3/',
			    'pageTitle': 'Finaliza tu compra - Combo - Tinka',
			    'combo': numeroComboSel // indicar número de combo seleccionado
	
			});
			console.log("Tagging taggingCombosTinkerosFinaliza: "+numeroComboSel);
		}
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosTinkerosEEcheckout(name,id,price){
	try {
		price=parseFloat(price).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',

		  'ecommerce': {
		     'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		           'name': name,
		           'id': id,
		           'price': price,
		           'brand': 'Juegos',
		           'quantity': '1',
		           'category': 'Tinka'
		         }]
		      }
		   }
		});
		console.log("Tagging taggingCombosTinkerosEEcheckout: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}
        
function taggingVirtualPageView2a(combo){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'virtualPageView',
		'pageUrl': '/juega-tinka/combo/paso2a/',
		'pageTitle': 'Finaliza tu compra - Combo Jugada al Azar - Tinka',
		'combo': combo // indicar numero de combo seleccionado
		});
		console.log("Tagging taggingVirtualPageView2a: combo:"+combo);
	} catch (e) {
		console.error(e);
	}
}

//tinka jugada individual

function taggingJuegaTinkaElige(){
	try{
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageUrl': '/juega-tinka/individual/paso1/',
	    'pageTitle': 'Elige tus Bolillas - Individual - Tinka'

	});
	 console.log("Tagging taggingJuegaTinkaElige");
	}catch(e){
		console.error(e);
	}

}
	
function taggingTinkaAzar(){
	try{
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'alAzar',
	    'category': 'UI :: Jugar',
	    'action': 'Tinka :: Click', // Indicar el nombre del juego que corresponda.//Siempre va ser tinka.
	    'label': 'Al azar'
	});

	 console.log("Tagging taggingTinkaAzar");
	}catch(e){
		console.error(e);
	}
}

function taggingJuegaTinkaSliderFinaliza(){
	try{
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageUrl': '/juega-tinka/individual/paso2/',
	    'pageTitle': 'Finaliza tu compra - Individual - Tinka'

	});

	console.log("Tagging taggingJuegaTinkaSliderFinaliza");	
	}catch(e){
		console.error(e);
	}
}

function taggingJuegaTinkaChekoutSlider(price){
	try{
		var price=$("#importePagar").val();
		price=price.split(" ")[2];
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	  'event': 'EEcheckout',
	   'ecommerce': {
	      'checkout': {
	        'actionField': {'step': 1},
		        'products': [{
	          'name': 'Tinka Jugada Individual', 
	          'id': 'tinkaInd',
				        'price': price,   //Indicar el precio de la jugada
	          'brand': 'Juegos',
	          'quantity': '1',
	          'category': 'Tinka'
	       }]
	    }
	  }
	});
	//
		console.log("Taggin tinka individual EEcheckout: ");
	}catch(e){
		console.error(e);
	}  

		
}

function taggingRemoveFromCart(){
	try{
		var price=parseFloat($("#priceJuegoDelete").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{ 
		          'name': 'Tinka Jugada Individual', 
		          'id': 'tinkaInd',
		          'price': price,   //Indicar el precio a descontar
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Tinka'
		       }]
		    }
		  }
		});
		console.log("tagging tinka individual EEremoveFromCart: ");
	}catch(e){
		console.error(e);
	}
	
	
}

function taggingRemove_sorteos(){
	try{
		var consecutivePrice=$('#consecutivePrice').val();
		   consecutivePrice=consecutivePrice.split(" ")[2];
		   	
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			  'event': 'EEremoveFromCart',
			  'ecommerce': {
			    'remove': {                             
			      'products': [{ 
			          'name': 'Tinka Jugada Individual', 
			          'id': 'tinkaInd',
			          'price': consecutivePrice,   //Indicar el precio a descontar
			          'brand': 'Juegos',
			          'quantity': '1',
			          'category': 'Tinka'
			       }]
			    }
			  }
			});
			
			console.log("tagging tinka individual EEremoveFromCart: ");
		
	}catch(e){
		console.error(e);
	}
}

function  tagginGraciasCompraSlider(){
	try{
		var status=$("#status").val();
		if(status=="ok"){
			window.dataLayer = window.dataLayer || [ ];
			  dataLayer.push({
			  'event': 'compraExitosa',
			  'pageUrl': '/juega-tinka/individual/confirmacion/',
			  'pageTitle': 'Compra exitosa - Individual - Tinka'
			});
			console.log("tagging Gracias por Tu compra");
		}
	}catch(e){
		console.error(e);
	}
}

function tagginPrepararParametrosTK (){
	try{
	
	var codigoTran=$("#ticketId").val();
			codigoTran = "TK-" + codigoTran;
	var montoTotal=$("#importePagar").val();
	
	var cantidadJugadas=$("#jugadasActuales").val();
	var jugadasGratis=$("#jugadasGratis").val();

	var contJuRe=0;
    
	var cantSorteos=$("#consecutivas").val();
	if(cantSorteos==""){
		cantSorteos=1;
	}

	var promedioBolillas="";

	var cantA=0;
	//var numBoljugadaA=$("#jugadasA").val();
	var numBoljugadaA=$("#numBolJugadaA").val();
	
	if(numBoljugadaA!=""){
	cantA=numBoljugadaA;
	contJuRe=contJuRe+1;
			} else {
	cantA=0;
	}

	var cantB=0;
	var numBoljugadaB=$("#numBolJugadaB").val();
	
	if(numBoljugadaB!=""){
	cantB=numBoljugadaB;
	contJuRe=contJuRe+1;
			} else {
	cantB=0;
	}

	var cantC=0;
	var numBoljugadaC=$("#numBolJugadaC").val();
	
	if(numBoljugadaC!=""){
	cantC=numBoljugadaC;
	contJuRe=contJuRe+1;
			} else {
	cantC=0;
	}

	var cantD=0;
	var numBoljugadaD=$("#numBolJugadaD").val();
	
	if(numBoljugadaD!=""){
	cantD=numBoljugadaD;
	contJuRe=contJuRe+1;
			} else {
	cantD=0;
	}
		
			promedioBolillas = parseFloat(parseInt(cantA) + parseInt(cantB)
					+ parseInt(cantC) + parseInt(cantD))
					/ parseInt(contJuRe);
	promedioBolillas=promedioBolillas.toFixed(2);

	//preguntar por jugadas Gratis sino hay  hacer este evento 

	//var cantidadJGratis=;
			if (parseInt(jugadasGratis) >= (parseInt(cantidadJugadas)*parseInt(cantSorteos))) {
				tagginJuegaTKPurchaseGratis(codigoTran, cantidadJugadas,
						cantSorteos, promedioBolillas);
			} else {
				tagginJuegaTKPurchase(codigoTran, montoTotal, cantidadJugadas,
						cantSorteos, promedioBolillas);
	}
		
	}catch(e){
		console.error(e);
	}

	
}

	function tagginJuegaTKPurchase_1 (codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioBolillas){
	try{
		
		montoTotal=parseFloat(montoTotal).toFixed(2);
		promedioBolillas=parseFloat(promedioBolillas).toFixed(1);
		   window.dataLayer = window.dataLayer || [ ];
		   dataLayer.push({
		   'event': 'EEpurchase',
		     'ecommerce': {
		       'purchase': {
		         'actionField': {
		           'id': codigoTran,                             // Código de la transacción        
		           'revenue': montoTotal,                      // Monto total pagado
		         },
		         'products': [
	  	           {
	               //Aca se listan las jugadas individuales
		           'name': 'Tinka Jugada Individual',   
		           'id': 'tinkaInd',
		           'price': montoTotal,
		           'brand': 'Juegos',
		           'quantity': '1',
		           'category': 'Tinka',
		           'metric1':  cantidadJugadas, //indicar cantidad de jugadas
		           'dimension3': cantSorteos,           // Indicar cantidad de sorteos consecutivos
		           'dimension4': promedioBolillas// aquí indicar el número de bolillas es el promedio de las bolillas
		            }
	  	        
		          ]
		       }
		     }
		   });
		   console.log("tagging tagginJuegaTKPurchase");
		
		
	}catch(e){
		console.error(e);
	  }

}
	
	function tagginJuegaTKPurchase (codigoTran,montoTotal,cantidadJugadas,cantSorteos,promedioBolillas){
	try{
		
		montoTotal=parseFloat(montoTotal).toFixed(2);
		promedioBolillas=parseFloat(promedioBolillas).toFixed(1);
			
			var formatPricePerPlay2= $('#formatPricePerPlay2').val();
			var jugadasActuales= $('#jugadasActuales').val();
			var consecutive= $('#consecutive').val();
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
				         'products': [
			  	           {
			               //Aca se listan las jugadas individuales
				           'name': 'Tinka Jugada Individual',   
				           'id': 'tinkaInd',
				           'price': montoTotal,
				           'brand': 'Juegos',
				           'quantity': '1',
				           'category': 'Tinka',
				           'variant': promotionMessage,
				           'metric1':  cantidadJugadas, //indicar cantidad de jugadas
				           'dimension3': cantSorteos,           // Indicar cantidad de sorteos consecutivos
				           'dimension4': promedioBolillas// aquí indicar el número de bolillas es el promedio de las bolillas
				            }
			  	        
				          ]
				       }
				     }
				   });
			}
			//Si es jugada estandar
			else{
		   window.dataLayer = window.dataLayer || [ ];
		   dataLayer.push({
		   'event': 'EEpurchase',
		     'ecommerce': {
		       'purchase': {
		         'actionField': {
		           'id': codigoTran,                             // Código de la transacción        
		           'revenue': montoTotal,                      // Monto total pagado
		         },
		         'products': [
	  	           {
	               //Aca se listan las jugadas individuales
		           'name': 'Tinka Jugada Individual',   
		           'id': 'tinkaInd',
		           'price': montoTotal,
		           'brand': 'Juegos',
		           'quantity': '1',
		           'category': 'Tinka',
				           'variant': 'jugada estandar',
		           'metric1':  cantidadJugadas, //indicar cantidad de jugadas
		           'dimension3': cantSorteos,           // Indicar cantidad de sorteos consecutivos
		           'dimension4': promedioBolillas// aquí indicar el número de bolillas es el promedio de las bolillas
		            }
	  	        
		          ]
		       }
		     }
		   });
			}
			   
		   console.log("tagging tagginJuegaTKPurchase");
		
		
	}catch(e){
		console.error(e);
	  }

}


	function tagginJuegaTKPurchaseGratis (codigoTran,cantidadJugadas,cantSorteos,promedioBolillas){
	try{
		
		promedioBolillas=parseFloat(promedioBolillas).toFixed(1);
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	'event': 'EEpurchase',
	  'ecommerce': {
	    'purchase': {
	      'actionField': {
		        'id': codigoTran,                             // Código de la
																// transacción
		        'revenue': '0.00',                      // Para el caso de
														// jugadas gratis 0
	      },
	      'products': [{                            
	        'name': 'Tinka Jugada Individual',   
	        'id': 'tinkaInd',
	        'price': '0.00',
	        'brand': 'Juegos',
	        'quantity': '1',
	        'category': 'Tinka',
	        'variant': 'jugada gratis',
		        'metric1': cantidadJugadas,             // indicar cantidad de
														// jugadas gratis
		        'dimension3': cantSorteos,     // Indicar cantidad de sorteos
												// consecutivos
		        'dimension4': promedioBolillas     // aquí indicar el promedio
													// de número de bolillas
	       }]
	    }
	  }
	});
		console.log("tagging tagginJuegaTKPurchase");
	
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
		    'action': 'Error :: Tinka',
		    'label': mensaje // aqui deben indicar el mensaje de error
		});
		console.log("taggingPopupError");
	}catch(e){
		console.error(e);
	}
	}
	
function taggingJugadaNoProcesada(mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': 'Error :: Tinka',  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingJugadaNoProcesada");
	}catch(e){
		console.error(e);
	}
}
	
function  taggingCombosTinkerosCompraExitosa(combo){
	try{
		if(combo!=undefined && combo!=null && combo!=''){
			window.dataLayer = window.dataLayer || [ ];
			  dataLayer.push({
			  'event': 'compraExitosa',
			  'pageUrl': '/juega-tinka/combo/confirmacion/',
			  'pageTitle': 'Compra exitosa - Combo - Tinka',
			  'combo': combo
			});
			console.log("tagging taggingCombosTinkerosCompraExitosa: combo:"+combo);
		}
	}catch(e){
		console.error(e);
	}
}

function taggingCombosTinkerosEEpurchase(numCombo,ticket,precio,sorteos,bolillas,tipoJugada){
	try {
		if(numCombo!=undefined && numCombo!=null && numCombo!=''){
			if(tipoJugada=="SUS_IGUAL"){
				tipoJugada="Elige tu jugada";
			}else{
				tipoJugada="Jugada al azar";
			}
			precio=parseFloat(precio).toFixed(2);
			
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			'event': 'EEpurchase',
			 'ecommerce': {
			    'purchase': {
			      'actionField': {
			        'id': 'TK-'+ticket,   // Código de la transacción
			         'revenue': precio,   // Monto total pagado
			      },
			      'products': [{ 
			        'name': 'Tinka Combo '+numCombo+' jugadas',   
			        'id': 'tinkaC'+numCombo,
			        'price': precio,
			        'brand': 'Juegos',
			        'quantity': '1',
			        'category': 'Tinka',
			        'dimension1': tipoJugada, 	// aquí indicar opción de jugada
			        'dimension2': sorteos,              // aquí indicar el número de sorteos
			        'dimension4': bolillas    			// aquí indicar el promedio  de número de bolillas
			       }]
			    }
			  }
			});
			var tag="Tinka combo EEpurchase";
			console.log("Taggin event: "+tag+", combo: "+numCombo+", precio: "+precio+", opcion de jugada: "+tipoJugada+", bolillas: "+bolillas+", sorteos: "+sorteos);
		}
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosTinkerosRemoveFromCart(name,id,price){
	try {	
		price=parseFloat(price).toFixed(2);
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': name,
		          'id': id,
		          'price': price,  //Indicar el precio de la jugada que se está eliminando.
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Tinka'
		       }]
		    }
		  }
		});
		console.log("Tagging taggingCombosTinkerosRemoveFromCart: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

//combos kabala
function taggingCombosKabala(numeroCombo){
	try{
		if(numeroCombo!=undefined && numeroCombo!=null && numeroCombo!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
				'event': 'virtualPageView',
			    'pageUrl': '/juega-kabala/combo/paso1/',
			    'pageTitle': 'Elige tu jugada - Combo - Kabala',
				'combo': numeroCombo // indicar número de combo seleccionado
			});
			console.log("taggingCombosKabala: "+numeroCombo);
		}
	}catch (e) {
		console.error(e);
	}		
}

function taggingCombosKabalaBet(numeroComb){
	try{
		if(numeroComb!=undefined && numeroComb!=null && numeroComb!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
				'event': 'virtualPageView',
			    'pageUrl': '/juega-Kabala/combo/paso2/',
			    'pageTitle': 'Elige tus Bolillas - Combo - Kabala',
			    'combo': numeroComb // indicar número de combo de seleccionado	
			});
			console.log("taggingCombosKabalaBet: "+numeroComb);
		}
	}catch (e) {
		console.error(e);	
	}
}

function taggingCombosKabalaAddToCart(name,id,price){
	try {
		price=parseFloat(price).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{
		        'name': name,
		        'id': id,
		        'price': price,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'kabala'        
		       }]
		    }
		  }
		});
		console.log("Tagging taggingCombosKabalaAddToCart: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosKabalaError(nombreJuego,mensaje){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'popupError',
		    'category': 'UI :: Jugar',
		    'action': nombreJuego,  // Incluir el nombre del juego que corresponda
		    'label': mensaje // Aquí deberían indicar el mensaje de error.
		});
		console.log("Tagging taggingCombosKabalaError: action:"+nombreJuego+", label:"+mensaje);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosKabalaFinaliza(numeroComboSel){
	try {
		if(numeroComboSel!=undefined && numeroComboSel!=null && numeroComboSel!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			    'event': 'virtualPageView',
			    'pageUrl': '/juega-kabala/combo/paso3/',
			    'pageTitle': 'Finaliza tu compra - Combo - Kabala',
			    'combo': numeroComboSel // indicar número de combo seleccionado
			});
			console.log("Tagging taggingCombosKabalaFinaliza: "+numeroComboSel);
		}
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosKabalaEEcheckout(name,id,price){
	try {
		price=parseFloat(price).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',
		  'ecommerce': {
		     'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		           'name': name,
		           'id': id,
		           'price': price,
		           'brand': 'Juegos',
		           'quantity': '1',
		           'category': 'kabala'
		         }]
		      }
		   }
		});
		console.log("Tagging taggingCombosKabalaEEcheckout: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

function  taggingCombosKabalaCompraExitosa(combo){
	try{
		if(combo!=undefined && combo!=null && combo!=''){
			window.dataLayer = window.dataLayer || [ ];
			  dataLayer.push({
			  'event': 'compraExitosa',
			  'pageUrl': '/juega-kabala/combo/confirmacion/',
			  'pageTitle': 'Compra exitosa - Combo - Kabala',
			  'combo': combo
			});
			console.log("tagging taggingCombosKabalaCompraExitosa: combo:"+combo);
		}
	}catch(e){
		console.error(e);
	}
}

function taggingCombosKabalaEEpurchase(numCombo,ticket,precio,sorteos,bolillas,tipoJugada){
	try {
		if(numCombo!=undefined && numCombo!=null && numCombo!=''){
			if(tipoJugada=="SUS_IGUAL"){
				tipoJugada="Elige tu jugada";
			}else{
				tipoJugada="Jugada al azar";
			}
			precio=parseFloat(precio).toFixed(2);
			
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			'event': 'EEpurchase',
			 'ecommerce': {
			    'purchase': {
			      'actionField': {
			        'id': 'KB-'+ticket,   // Código de la transacción
			         'revenue': precio,   // Monto total pagado
			      },
			      'products': [{ 
			        'name': 'Kabala Combo '+numCombo+' jugadas',   
			        'id': 'kabalaC'+numCombo,
			        'price': precio,
			        'brand': 'Juegos',
			        'quantity': '1',
			        'category': 'kabala',
			        'dimension1': tipoJugada, 	// aquí indicar opción de jugada
			        'dimension2': sorteos,              // aquí indicar el número de sorteos
			        'dimension4': bolillas    			// aquí indicar el promedio  de número de bolillas
			       }]
			    }
			  }
			});
			var tag="Kabala combo EEpurchase";
			console.log("Taggin event: "+tag+", combo: "+numCombo+", precio: "+precio+", opcion de jugada: "+tipoJugada+", bolillas: "+bolillas+", sorteos: "+sorteos);
		}
	} catch (e) {
		console.error(e);
	}
}

function taggingKabalaVirtualPageView2a(combo){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualPageView',
	    	'pageUrl': '/juega-kabala/combo/paso2a/',
	    	'pageTitle': 'Finaliza tu compra - Combo Jugada al Azar - Kabala',
	    	'combo': combo // indicar numero de combo seleccionado
		});
		console.log("Tagging taggingKabalaVirtualPageView2a: combo:"+combo);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosKabalaRemoveFromCart(name,id,price){
	try {	
		price=parseFloat(price).toFixed(2);
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': name,
		          'id': id,
		          'price': price,  //Indicar el precio de la jugada que se está eliminando.
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'kabala'
		       }]
		    }
		  }
		});
		console.log("Tagging taggingCombosKabalaRemoveFromCart: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

//combos ganadiario
function taggingCombosGanadiario(numeroCombo){
	try{
		if(numeroCombo!=undefined && numeroCombo!=null && numeroCombo!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
				'event': 'virtualPageView',
			    'pageUrl': '/juega-ganadiario/combo/paso1/',
			    'pageTitle': 'Elige tu jugada - Combo - Gana Diario',
				'combo': numeroCombo // indicar número de combo seleccionado
			});
			console.log("taggingCombosGanadiario: "+numeroCombo);
		}
	}catch (e) {
		console.error(e);
	}		
}

function taggingCombosGanadiarioBet(numeroComb){
	try{
		if(numeroComb!=undefined && numeroComb!=null && numeroComb!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
				'event': 'virtualPageView',
			    'pageUrl': '/juega-ganadiario/combo/paso2/',
			    'pageTitle': 'Elige tus Bolillas - Combo - Gana Diario',
			    'combo': numeroComb // indicar número de combo de seleccionado	
			});
			console.log("taggingCombosGanadiarioBet: "+numeroComb);
		}
	}catch (e) {
		console.error(e);	
	}
}

function taggingCombosGanadiarioAddToCart(name,id,price){
	try {
		price=parseFloat(price).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{
		        'name': name,
		        'id': id,
		        'price': price,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Gana Diario'        
		       }]
		    }
		  }
		});
		console.log("Tagging taggingCombosGanadiarioAddToCart: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosGanadiarioError(nombreJuego,mensaje){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'popupError',
		    'category': 'UI :: Jugar',
		    'action': nombreJuego,  // Incluir el nombre del juego que corresponda
		    'label': mensaje // Aquí deberían indicar el mensaje de error.
		});
		console.log("Tagging taggingCombosGanadiarioError: action:"+nombreJuego+", label:"+mensaje);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosGanadiarioFinaliza(numeroComboSel){
	try {
		if(numeroComboSel!=undefined && numeroComboSel!=null && numeroComboSel!=''){
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			    'event': 'virtualPageView',
			    'pageUrl': '/juega-ganadiario/combo/paso3/',
			    'pageTitle': 'Finaliza tu compra - Combo - Gana Diario',
			    'combo': numeroComboSel // indicar número de combo seleccionado
			});
			console.log("Tagging taggingCombosGanadiarioFinaliza: "+numeroComboSel);
		}
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosGanadiarioEEcheckout(name,id,price){
	try {
		price=parseFloat(price).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',
		  'ecommerce': {
		     'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		           'name': name,
		           'id': id,
		           'price': price,
		           'brand': 'Juegos',
		           'quantity': '1',
		           'category': 'Gana Diario'
		         }]
		      }
		   }
		});
		console.log("Tagging taggingCombosGanadiarioEEcheckout: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

function  taggingCombosGanadiarioCompraExitosa(combo){
	try{
		if(combo!=undefined && combo!=null && combo!=''){
			window.dataLayer = window.dataLayer || [ ];
			  dataLayer.push({
			  'event': 'compraExitosa',
			  'pageUrl': '/juega-ganadiario/combo/confirmacion/',
			  'pageTitle': 'Compra exitosa - Combo - Gana Diario',
			  'combo': combo
			});
			console.log("tagging taggingCombosGanadiarioCompraExitosa: combo:"+combo);
		}
	}catch(e){
		console.error(e);
	}
}

function taggingCombosGanadiarioEEpurchase(numCombo,ticket,precio,sorteos,bolillas,tipoJugada){
	try {
		if(numCombo!=undefined && numCombo!=null && numCombo!=''){
			if(tipoJugada=="SUS_IGUAL"){
				tipoJugada="Elige tu jugada";
			}else{
				tipoJugada="Jugada al azar";
			}
			precio=parseFloat(precio).toFixed(2);
			
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			'event': 'EEpurchase',
			 'ecommerce': {
			    'purchase': {
			      'actionField': {
			        'id': 'GD-'+ticket,   // Código de la transacción
			         'revenue': precio,   // Monto total pagado
			      },
			      'products': [{ 
			        'name': 'Gana Diario Combo '+numCombo+' jugadas',   
			        'id': 'ganaC'+numCombo,
			        'price': precio,
			        'brand': 'Juegos',
			        'quantity': '1',
			        'category': 'Gana Diario',
			        'dimension1': tipoJugada, 	// aquí indicar opción de jugada
			        'dimension2': sorteos,              // aquí indicar el número de sorteos
			        'dimension4': bolillas    			// aquí indicar el promedio  de número de bolillas
			       }]
			    }
			  }
			});
			var tag="Gana Diario combo EEpurchase";
			console.log("Taggin event: "+tag+", combo: "+numCombo+", precio: "+precio+", opcion de jugada: "+tipoJugada+", bolillas: "+bolillas+", sorteos: "+sorteos);
		}
	} catch (e) {
		console.error(e);
	}
}

function taggingGanadiarioVirtualPageView2a(combo){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
			'event': 'virtualPageView',
	    	'pageUrl': '/juega-ganadiario/combo/paso2a/',
	    	'pageTitle': 'Finaliza tu compra - Combo Jugada al Azar - Gana Diario',
	    	'combo': combo // indicar numero de combo seleccionado
		});
		console.log("Tagging taggingGanadiarioVirtualPageView2a: combo:"+combo);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosGanadiarioRemoveFromCart(name,id,price){
	try {	
		price=parseFloat(price).toFixed(2);
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': name,
		          'id': id,
		          'price': price,  //Indicar el precio de la jugada que se está eliminando.
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Gana Diario'
		       }]
		    }
		  }
		});
		console.log("Tagging taggingCombosGanadiarioRemoveFromCart: name:"+name+", id:"+id+", price:"+price);
	} catch (e) {
		console.error(e);
	}
}

function taggingCombosJugadaNoProcesada(action,mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': action,  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingCombosJugadaNoProcesada: action:"+action+", mensaje:"+mensaje);
	}catch(e){
		console.error(e);
	}
}