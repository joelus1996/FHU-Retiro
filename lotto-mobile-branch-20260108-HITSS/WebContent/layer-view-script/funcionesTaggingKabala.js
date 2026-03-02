  
function taggingJuegaKabalaSlider(){
	try{
		var pageTitle="Elige tu jugada - Individual - K\u00E1bala";
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-kabala/individual/paso1/',
		    'pageTitle': pageTitle

		});
	   console.log("taggingJuegaKabalaSlider");
	}catch(e){
		console.error(e);
	}
	
}

function taggingKabalaAzar(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'alAzar',
		    'category': 'UI :: Jugar',
		    'action': 'Kabala :: Click',
		    'label': 'Al azar'
		});
		console.log(" taggingKabalaAzar ");
	}catch(e){
		console.error(e);
	}
	
}


function taggingFinalizaTuCompra(){
	try{
		var pageTitle="Finaliza tu compra - Individual - K\u00E1bala";
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-kabala/individual/paso2/',
		    'pageTitle': pageTitle

		});
		console.log("taggingFinalizaTuCompra");
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
				taggingAddToCartSiguiente();
				taggingFinalizaTuCompra();
				taggingCheckout();
			}
			if(op==="consecutive"){
				
				var cantSorteos=$("#consecutivas").val();
				if(cantSorteos>1){
					taggingAddToCartSiguiente();
					taggingFinalizaTuCompra();
					taggingCheckout();								
				}else{
				taggingFinalizaTuCompra();
			}
			}
			if(op==="removeConsecutive"){
				var priceJuegoDelete=$("#priceJuegoDelete").val();
				if(parseFloat(priceJuegoDelete)>0.00){
					taggingRemoveSlider60();
				taggingFinalizaTuCompra();
					var importePagar=$("#importePagar").val();
					importePagar=parseFloat(importePagar.split(" ")[1]);
					if(importePagar>0){
						taggingCheckout();
					}								
				}else{
					taggingFinalizaTuCompra();
				}	
			}		
			if(op==="delete"){					
				taggingRemoveSlider60();
				taggingFinalizaTuCompra();
				var importePagar=$("#importePagar").val();
				importePagar=parseFloat(importePagar.split(" ")[1]);
				if(importePagar>0){
					taggingCheckout();
					}					
			}	
			if(op==="default"){
				taggingFinalizaTuCompra();
			}
		}else{
			taggingFinalizaTuCompra();
		}
	}catch(e){
		console.error(e);
	}
	

}

function taggingAddToCartSiguiente() {
	try{
		var priceCC=$("#lastPriceCC").val();
		var priceK=$("#lastPriceK").val();
		priceK=parseFloat(priceK).toFixed(2);
					
		if(priceCC>0){
			priceCC=parseFloat(priceCC).toFixed(2);				
			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEaddToCart',
				'ecommerce' : {
					'currencyCode' : 'PEN',
					'add' : {
						'products' : [ {
							'name' : 'Kabala Jugada Individual',
							'id' : 'kabalaInd',
							'price' : priceK, //precio de la jugada
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						},
						{
							'name' : 'Chau Chamba',
							'id' : 'chauchamba',
							'price' : priceCC, //precio de la jugada
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						}]
					}
				}
			});
				
		}else{
			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEaddToCart',
				'ecommerce' : {
					'currencyCode' : 'PEN',
					'add' : {
						'products' : [ {
							'name' : 'Kabala Jugada Individual',
							'id' : 'kabalaInd',
							'price' : priceK, //precio de la jugada
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						} ]
					}
				}
			});
			
		}
		console.log("taggingAddToCartSiguiente");
	}catch(e){
		console.error(e);
	}

}

function taggingCheckout() {
	try{
//		var price = $("#importePagar").val().split(" ")[1];
//		var cantidadJugadas=$("#jugadasActuales").val();
//		var arrayJug = cantidadJugadas.split("+");			
//		var cantidadJugadasSinChau= arrayJug[0];
//		cantidadJugadasSinChau=cantidadJugadasSinChau.replace("KB","").trim();
//		
//		var cantidadJugadasConChau= arrayJug[1];	
		
		var priceK	=$("#priceK").val();
		priceK=	parseFloat(priceK).toFixed(2);
		var priceCC=	$("#priceCC").val();
		
		if(priceCC>0.0){
			priceCC=parseFloat(priceCC).toFixed(2);

			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEcheckout',
				'ecommerce' : {
					'checkout' : {
						'actionField' : {
							'step' : 1
						},
						'products' : [ {
							'name' : 'Kabala Jugada Individual',
							'id' : 'kabalaInd',
							'price' : priceK, //precio de la jugada
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						},{
							'name' : 'Chau Chamba',
							'id' : 'chauchamba',
							'price' : priceCC, //precio de la jugada
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
							} ]
					}
				}
			});				
				
		}else{
			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEcheckout',

				'ecommerce' : {
					'checkout' : {
						'actionField' : {
							'step' : 1
						},
						'products' : [ {
							'name' : 'Kabala Jugada Individual',
							'id' : 'kabalaInd',
							'price' : priceK, //precio de la jugada
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						} ]
					}
				}
			});
		}
		console.log("taggingCheckout");
	}catch(e){
		console.error(e);
	}
	
}

function taggingRemoveSlider60() {
	try{
		var priceCC	=parseFloat($("#priceJuegoDeleteCC").val()).toFixed(2);
		var priceK=	parseFloat($("#priceJuegoDelete").val()).toFixed(2);			
		if(priceCC>0.00){
			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEremoveFromCart',
				'ecommerce' : {
					'remove' : {
						'products' : [ {
							'name' : 'Kabala Jugada Individual',
							'id' : 'kabalaInd',
							'price' : priceK, //valor descontado
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						},
						{
							'name' : 'Chau Chamba',
							'id' : 'chauchamba',
							'price' : priceCC, //valor descontado
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						}]
					}
				}
			});
		}else{
			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEremoveFromCart',
				'ecommerce' : {
					'remove' : {
						'products' : [ {
							'name' : 'Kabala Jugada Individual',
							'id' : 'kabalaInd',
							'price' : priceK, //valor descontado
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						} ]
					}
				}
			});
		}

		console.log("taggingRemoveSlider60");
	}catch(e){
		console.error(e);
	}

}

function taggingRemoveSlider60_sorteos() {
	try{
		var cantidadSorteos = $('#consecutivas').val();
		var importePagar = $('#importePagar').val();
		importePagar = importePagar.substr(3, importePagar.length);
		var precioDesc = 0;
		var price = 0;
		if (cantidadSorteos > 1) {
			precioDesc = parseFloat(importePagar)
					/ parseFloat(cantidadSorteos);
			price = parseFloat(importePagar) - precioDesc;
		}

		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'EEremoveFromCart',
			'ecommerce' : {
				'remove' : {
					'products' : [ {
						'name' : 'Kabala Jugada Individual',
						'id' : 'kabalaInd',
						'price' : price, //precio de la jugada
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Kabala'
					} ]
				}
			}
		});

		console.log("taggingRemoveSlider60 sorteos");
	}catch(e){
		console.error(e);
	}
}

//continuar
function taggingContinuarConsecutivos() {
	try{
		var cantidadSorteos = $('#consecutiveParam').val();
		var importePagar = $('#importePagar').val();
		importePagar = importePagar.substr(3, importePagar.length);

		if (cantidadSorteos != "") {

			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEcheckout',

				'ecommerce' : {
					'checkout' : {
						'actionField' : {
							'step' : 1
						},
						'products' : [ {
							'name' : 'Kabala Jugada Individual',
							'id' : 'kabalaInd',
							'price' : importePagar, //precio de la jugada
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Kabala'
						} ]
					}
				}
			});

			console.log("taggingContinuarCons");
		}
	}catch(e){
		console.error(e);
	}
	
}


function  tagginGraciasCompraSlider62(){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'compraExitosa',
		'pageUrl': '/juega-kabala/individual/confirmacion/',
		'pageTitle': 'Compra exitosa - Individual - Kabala',
		});
		console.log("tagginGraciasCompraSlider62");
	}catch(e){
		console.error(e);
	}
				
}


function tagginPrepararParametrosKabala(){
	try{
		var codigoTran=$("#ticketId").val();
		codigoTran="KB-"+codigoTran;
		var montoTotal=$("#importePagar").val();

		
		var cantidadJugadas=$("#jugadasActuales").val();
		var jugaGratisEnDinero=$("#jugadasGratis").val()*1.00;
		
		 var arrayJug = cantidadJugadas.split(" + ");
		var cantidadJugadasSinChau= arrayJug[0];
		cantidadJugadasSinChau=cantidadJugadasSinChau.replace("KB","").trim();
		
		var cantidadJugadasConChau= arrayJug[1];
		
		if(cantidadJugadasConChau!=undefined){
			cantidadJugadasConChau=cantidadJugadasConChau.replace("KB CC","").trim();
			
		}
		else{
			
			cantidadJugadasConChau="0";
		}
		var cantSorteos=$("#consecutivas").val();
		if(cantSorteos==""){
			cantSorteos="1";
		}
		var montoTotalConChau=cantidadJugadasConChau*1.00 * cantSorteos;
		montoTotalConChau=montoTotalConChau+'';
		var montoTotalSinChau=cantidadJugadasSinChau*1.00 * cantSorteos;
		montoTotalSinChau=montoTotalSinChau+'';
		
		var jugadasGratis=$("#jugadasGratis").val();

		var price=montoTotal;
		var contJuRe=0;
		var contJuReChau=0;

		

		var promedioBolillas=0.0;
		var promedioBolillasConChau=0.0;

		var cantA=0;
		var cantAchau=0;
		var numBoljugadaA=$("#numBolJugadaA").val();
		
		
		
		if(numBoljugadaA!=""){
		cantA=numBoljugadaA;
		contJuRe=contJuRe+1;
		
		var conChauA=$("#chauA").val();
		if(conChauA!=""){
			cantAchau=cantAchau+1;
			contJuReChau=contJuReChau+1;
		}
		
		
		}
		else{
		cantA=0;
		}

		var cantB=0;
		var cantBchau=0;
		var numBoljugadaB=$("#numBolJugadaB").val();
		
		if(numBoljugadaB!=""){
		cantB=numBoljugadaB;
		contJuRe=contJuRe+1;
		
		
		var conChauB=$("#chauB").val();
		if(conChauB!=""){
			cantBchau=cantBchau+1;
			contJuReChau=contJuReChau+1;
		}
		
		}
		else{
		cantB=0;
		}

		var cantC=0;
		var cantCchau=0;
		var numBoljugadaC=$("#numBolJugadaC").val();
		
		var numBoljugadaCConChau=$("#chauC").val();
		
		if(numBoljugadaC!=""){
		cantC=numBoljugadaC;
		contJuRe=contJuRe+1;
		
		var conChauC=$("#chauC").val();
		if(conChauC!=""){
			cantCchau=cantCchau+1;
			contJuReChau=contJuReChau+1;
		}
		
		}
		else{
		cantC=0;
		}

		var cantD=0;
		var cantDchau=0;
		var numBoljugadaD=$("#numBolJugadaD").val();
		
		var numBoljugadaDConChau=$("#chauD").val();
		if(numBoljugadaD!=""){
		
		cantD=numBoljugadaD;
		contJuRe=contJuRe+1;
		
		var conChauD=$("#chauD").val();
		if(conChauD!=""){
			cantDchau=cantDchau+1;
			contJuReChau=contJuReChau+1;
		}
		
		}
		else{
		cantD=0;
		}
			
		promedioBolillas=parseFloat(parseInt(cantA)+parseInt(cantB)+parseInt(cantC)+parseInt(cantD))/parseInt(contJuRe);
		promedioBolillas=promedioBolillas.toFixed(1);
		if(contJuReChau!=0){
			var cc_a=cantAchau>0?parseInt(cantA):0;
			var cc_b=cantBchau>0?parseInt(cantB):0;
			var cc_c=cantCchau>0?parseInt(cantC):0;
			var cc_d=cantDchau>0?parseInt(cantD):0;
			promedioBolillasConChau=(cc_a+cc_b+cc_c+cc_d)/parseInt(contJuReChau);
			promedioBolillasConChau=promedioBolillasConChau.toFixed(1);
		}

		cantidadJugadasSinChau=cantidadJugadasSinChau+'';
		cantidadJugadasConChau=cantidadJugadasConChau+'';
		
		//preguntar por jugadas Gratis sino hay  hacer este evento		
		montoTotal=parseFloat(montoTotal).toFixed(2);
		montoTotalSinChau=parseFloat(montoTotalSinChau).toFixed(2);
		montoTotalConChau=parseFloat(montoTotalConChau).toFixed(2);
		if(montoTotal>jugaGratisEnDinero){
			//sin jugadas gratis
			if(contJuReChau>0){//con chau chamba
				tagginPurchaseSlider63(codigoTran,montoTotal,montoTotalConChau,montoTotalSinChau,cantidadJugadasSinChau,cantidadJugadasConChau,cantSorteos,promedioBolillas,promedioBolillasConChau);
		
			}
			else{
			//sin chau chamba			
			 tagginPurchaseSlider(codigoTran,montoTotal,cantidadJugadasSinChau,cantSorteos,promedioBolillas);
			}
			
		}
		else {
			//con jugdas gratis
			if(contJuReChau>0){//si hay chau chamba
				taggingPurchaseSlide65(codigoTran,cantidadJugadasSinChau,cantidadJugadasConChau,cantSorteos,promedioBolillas,promedioBolillasConChau)
		
			}
			else{
			//con chau chamba
			 tagginPurchaseSlider64(codigoTran,cantidadJugadasSinChau,cantSorteos,promedioBolillas);
			}
			
		  }
	}catch(e){
		console.error(e);
	}
}

// sin jugadas gratis y con chau chamba
	   
function tagginPurchaseSlider63 (codigoTran,montoTotal,montoTotalConChau,montoTotalSinChau,cantidadJugadasSinChau,cantidadJugadasConChau,cantSorteos,promedioBolillas,promedioBolillasConChau){
	try{
		var status=$("#status").val();
		if(status=="ok"){		
			 window.dataLayer = window.dataLayer || [ ];
			 dataLayer.push({
			 'event': 'EEpurchase',
			   'ecommerce': {
			     'purchase': {
			       'actionField': {
			         'id': codigoTran,                          //{transactionID} código de la transacción        
			         'revenue': montoTotal,              //{revenue} Monto total pagado
			       },
			       'products': [{ 
			         'name': 'Kabala Jugada Individual', 
			         'id': 'kabalaInd',
			         'price': montoTotalSinChau,   //precio de la jugada
			         'brand': 'Juegos',
			         'quantity': '1',
			         'category': 'Kabala',
			         'variant': 'jugada estandar',
			         'metric1': cantidadJugadasSinChau,                 //indicar cantidad de jugadas
			         'dimension3': cantSorteos,        // indicar cantidad de sorteos consecutivos
			         'dimension4': promedioBolillas               // aquí indicar el número de bolillas  
			       },
			       {                         
			         'name': 'Chau Chamba',   //Consideramos “Chau Chamba” como un producto individual
			         'id': 'chauchamba',
			         'price': montoTotalConChau,       
			         'brand': 'Juegos',
			         'quantity': '1',
			         'category': 'Kabala',
			         'variant': 'jugada estandar',
			         'metric1': cantidadJugadasConChau,                 //indicar cantidad de jugadas
			         'dimension3': cantSorteos,       // indicar cantidad de sorteos consecutivos 
			         'dimension4': promedioBolillasConChau       // aquí indicar el promedio de número de bolilla
			        }]
			     }
			   }
			 });
			 console.log("tagginPurchaseSlider63");
		}
	}catch(e){
		console.error(e);
	}
	
}

function tagginPurchaseSlider (codigoTran,montoTotal,cantidadJugadasSinChau,cantSorteos,promedioBolillas){
	try{
		var status=$("#status").val();
		if(status=="ok"){		
			 window.dataLayer = window.dataLayer || [ ];
			 dataLayer.push({
			 'event': 'EEpurchase',
			   'ecommerce': {
			     'purchase': {
			       'actionField': {
			         'id': codigoTran,                          //{transactionID} código de la transacción        
			         'revenue': montoTotal,              //{revenue} Monto total pagado
			       },
			       'products': [{ 
			         'name': 'Kabala Jugada Individual', 
			         'id': 'kabalaInd',
			         'price': montoTotal,   //precio de la jugada
			         'brand': 'Juegos',
			         'quantity': '1',
			         'category': 'Kabala',
			         'variant': 'jugada estandar',
			         'metric1': cantidadJugadasSinChau,                 //indicar cantidad de jugadas
			         'dimension3': cantSorteos,        // indicar cantidad de sorteos consecutivos
			         'dimension4': promedioBolillas               // aquí indicar el número de bolillas  
			       }]
			     }
			   }
			 });
			 console.log("tagginPurchaseSlider");
		}
	}catch(e){
		console.error(e);
	}
}


//GRATIS sin chau chamba
        
function tagginPurchaseSlider64(codigoTran,cantidadJugadasSinChau,cantSorteos,promedioBolillas){
	try{
		var status=$("#status").val();
		if(status=="ok"){
		 window.dataLayer = window.dataLayer || [ ];
		 dataLayer.push({
		 'event': 'EEpurchase',
		   'ecommerce': {
		     'purchase': {	
		       'actionField': {
		         'id': codigoTran,                          //{transactionID} código de la transacción        
		         'revenue': '0.00',              //{revenue} Monto total pagado
		       },
		       'products': [{ 
		    	   'name': 'Kabala Jugada Individual',   
		           'id': 'kabalaInd',
		           'price': '0.00',
		           'brand': 'Juegos',
		           'quantity': '1',
		           'category': 'Kabala',
		           'variant': 'jugada gratis',
		           'metric1': cantidadJugadasSinChau,             //indicar cantidad de jugadas gratis
		           'dimension3': cantSorteos,     // Indicar cantidad de sorteos consecutivos
		           'dimension4': promedioBolillas    // aquí indicar el promedio de número de bolillas
		       }
		      ]
		     }
		   }
		 })
		 console.log("tagginPurchaseSlider 64");
		}
	}catch(e){
		console.error(e);
	}
	
	 
}

//gratis con chau chamba y gratis
		
function taggingPurchaseSlide65(codigoTran,cantidadJugadasSinChau,cantidadJugadasConChau,cantSorteos,promedioBolillas,promedioBolillasConChau){
	try{
		var status=$("#status").val();
		if(status=="ok"){
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': codigoTran,                          //{transactionID} código de la transacción        
		        'revenue': '0.00',            // para jugadas gratis será 0.00
		      },
		      'products': [{ 
		        'name': 'Kabala Jugada Individual', 
		        'id': 'kabalaInd',
		        'price': '0.00',   //precio de la jugada
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kabala',
		        'variant': 'jugada gratis',
		        'metric1': cantidadJugadasSinChau,                 //indicar cantidad de jugadas gratis
		        'dimension3': cantSorteos,        // indicar cantidad de sorteos consecutivos
		        'dimension4': promedioBolillas              // aquí indicar el número de bolillas  
		      },
		      {                         
		        'name': 'Chau Chamba',   //Consideramos “Chau Chamba” como un producto individual
		        'id': 'chauchamba',
		        'price': '0.00',       
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Kabala',
		        'variant': 'jugada gratis',
		        'metric1': cantidadJugadasConChau,                 //indicar cantidad de jugadas gratis
		        'dimension3': cantSorteos,       // indicar cantidad de sorteos consecutivos 
		        'dimension4': promedioBolillasConChau       // aquí indicar el promedio de número de bolilla
		       }]
		    }
		  }
		});

		
		   console.log("tagginPurchaseSlider 65");
		}
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
		    'action': 'Error :: Kabala',
		    'label': mensaje // aquí deben indicar el mensaje de error
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
		    'action': 'Error :: Kabala',  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingJugadaNoProcesada");
	}catch(e){
		console.error(e);
	}

}