function tagginGGEEaddToCart(costoTotalBet){
	try {
		costoTotalBet=costoTotalBet.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{   
		        'name': 'Ganagol Jugada Individual',   
		        'id': 'ganagol',
		        'price': costoTotalBet,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Ganagol'  
		       }]
		    }
		  }
		});
		
		console.log("tagginGGEEaddToCart");				
	} catch (e) {
		console.error(e);
	}	

}

function taggingGGFinalizar(){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'virtualPageView',
		    'pageUrl': '/juega-ganagol/paso2/',
		    'pageTitle': 'Finaliza tu compra - Ganagol'
		});
		
		console.log("taggingGGFinalizar");				
	} catch (e) {
		console.error(e);
	}	

}

function tagginGGEEcheckout(content_object){	
	try {
		//Reiniciar tag checkout
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',
		   'ecommerce': {
		      'checkout': undefined
		
		  }
		});
		
		//Enviar evento checkout
		var aproduct=[];		
		for(var j=0; j<content_object.length; j++){
			
			var data=content_object[j];
			var price=data[6];
		
			var productJson={
					'name': 'Ganagol Jugada Individual',   
			          'id': 'ganagol',
			          'price': price,
			          'brand': 'Juegos',
			          'quantity': '1',
			          'category': 'Ganagol' 

				}	
			aproduct.push(productJson);
		}	
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',
		   'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': aproduct
		    }
		  }
		});
		
		console.log("tagginGGEEcheckout");				
	} catch (e) {
		console.error(e);
	}	

}

function tagginGGEEremoveFromCart(price){
	try {
//		price=price.toFixed(2);
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

		
		console.log("tagginGGEEremoveFromCart");				
	} catch (e) {
		console.error(e);
	}	

}

function tagginGGCompraExitosa(){
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'compraExitosa',
		'pageUrl': '/juega-ganagol/confirmacion/',
		'pageTitle': 'Compra exitosa - Ganagol'
		});
		
		console.log("tagginGGCompraExitosa");				
	} catch (e) {
		console.error(e);
	}

}

function tagginGGEEpurchase_1(content_object, content_object_3) {
	try {
		var idTransaction = 0;
		var total_price = 0.00;
		var aproduct = [];
		var idTransaction = "GG";
		for (var i = 0; i < content_object.length; i++) {
			var product = content_object[i];
			var nproduct = content_object_3[i];
			var idt = product[6];
			var ok=product[5];
			//Verificar si se procesó jugada
			if (ok==="OK") {
				idTransaction = idTransaction+"-" + idt;
				var price = product[4];
				var nJugadas = nproduct[6]+"";
				var n = 0;
				var nBolillas = 0;
				for (var m = 0; m < 4; m++) {
					if (product[m].length > 2) {
						n++;
						nBolillas = nBolillas + product[m].trim().split(" ").length;
					}
				}
				nBolillas = "" + (nBolillas / n).toFixed(1);
				n = "" + n;
				//Verificar si es una jugada gratuita
				if (nproduct[7] > 0) {
					price=parseFloat(price);
					total_price = total_price + price;
					price = price.toFixed(2);
					var jproduct = { //Aca se listan las jugadas individuales
						'name' : 'Ganagol Jugada Individual',
						'id' : 'ganagol',
						'price' : price,
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Ganagol',
						'metric1' : nJugadas, //indicar cantidad de jugadas
						'dimension4' : nBolillas
					// aquí indicar el número de bolillas
					}
				} else {
					price = 0;
					price = price.toFixed(2);
					var jproduct = { //Aca se listan las jugadas individuales
						'name' : 'Ganagol Jugada Individual',
						'id' : 'ganagol',
						'price' : price,
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Ganagol',
						'variant' : 'jugada gratis',
						'metric1' : nJugadas, //indicar cantidad de jugadas
						'dimension4' : nBolillas
					// aquí indicar el número de bolillas
					}
				}

				aproduct.push(jproduct);
			}

		}
		total_price = total_price.toFixed(2);

		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'EEpurchase',
			'ecommerce' : {
				'purchase' : {
					'actionField' : {
						'id' : idTransaction, // Código de la transacción        
						'revenue' : total_price, // Monto total pagado
					},
					'products' : aproduct
				}
			}
		});

		console.log("tagginGGEEpurchase");				
	} catch (e) {
		console.error(e);
	}
	

}

function tagginGGEEpurchase(content_object, content_object_3) {
	try {
		var total_price = 0.00;
		var aproduct = [];
		var idTransaction = "GG";
		for (var i = 0; i < content_object.length; i++) {
			var product = content_object[i];
			var nproduct = content_object_3[i];
			var ok_idt=product[4].split('&');
			var idt = ok_idt[1];
			var ok=ok_idt[0];
			//Verificar si se procesó jugada
			if (ok==="OK") {
				idTransaction = idTransaction+"-" + idt;
				var price = product[6];
				var nJugadas = nproduct[5]+"";
				var n = 0;
				var nBolillas = 0;
				for (var m = 0; m < 4; m++) {
					if (product[m].length > 2) {
						n++;
						nBolillas = nBolillas + product[m].trim().replace(/ /g, "").replace(/[0-9]/g, "").length;
					}
				}
				nBolillas = "" + (nBolillas / n).toFixed(1);
				n = "" + n;
				//Verificar si no es una jugada gratuita
				if (nproduct[7] > 0) {
					var tipoPromocion='Promo '+$('#promotionMessage').val();
					var precioNormal= nproduct[5];
					if((tipoPromocion!="" || tipoPromocion!=null) && (parseFloat(precioNormal) > parseFloat(price)) ){
						price=parseFloat(price);
						total_price = total_price + price;
						price = price.toFixed(2);
						var jproduct = { //Aca se listan las jugadas individuales
							'name' : 'Ganagol Jugada Individual',
							'id' : 'ganagol',
							'price' : price,
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Ganagol',
							'variant' : tipoPromocion,
							'metric1' : nJugadas, //indicar cantidad de jugadas
							'dimension4' : nBolillas
						// aquí indicar el número de bolillas
						}							
					}else{
						price=parseFloat(price);
						total_price = total_price + price;
						price = price.toFixed(2);
						var jproduct = { //Aca se listan las jugadas individuales
							'name' : 'Ganagol Jugada Individual',
							'id' : 'ganagol',
							'price' : price,
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Ganagol',
							'variant' : 'jugada estandar',
							'metric1' : nJugadas, //indicar cantidad de jugadas
							'dimension4' : nBolillas
						// aquí indicar el número de bolillas
						}						
					}
					
				} else {
					price = 0;
					price = price.toFixed(2);
					var jproduct = { //Aca se listan las jugadas individuales
						'name' : 'Ganagol Jugada Individual',
						'id' : 'ganagol',
						'price' : price,
						'brand' : 'Juegos',
						'quantity' : '1',
						'category' : 'Ganagol',
						'variant' : 'jugada gratis',
						'metric1' : nJugadas, //indicar cantidad de jugadas
						'dimension4' : nBolillas
					// aquí indicar el número de bolillas
					}
				}

				aproduct.push(jproduct);
			}

		}
		total_price = total_price.toFixed(2);

		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'EEpurchase',
			'ecommerce' : {
				'purchase' : {
					'actionField' : {
						'id' : idTransaction, // Código de la transacción        
						'revenue' : total_price, // Monto total pagado
					},
					'products' : aproduct
				}
			}
		});

		console.log("tagginGGEEpurchase");				
	} catch (e) {
		console.error(e);
	}
	

}

