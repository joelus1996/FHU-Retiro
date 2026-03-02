//Funcione de tagging cargar saldo
//enarro - 25/05/2020

function tagginTabCargarSaldo(label, id) {
	try {
		if(!$("#"+id).hasClass('opened')){
			var action = document.referrer;
			action=action.split('/');
			var length=action.length;
			action=action[length-1].split('.')[0];
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			    'event': 'Click boton',
			    'category': 'UI :: Recarga',
			    'action': action,
			    'label': label
			});

			console.log("tagginTabCargarSaldo: "+label);			
		}		

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEEaddToCart() {
	try {
		var price=parseInt($("#monto_visanet").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet Visa',
		        'id': 'int-visa',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});

		console.log("tagginSaldoEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEEcheckout() {
	try {
		var price=parseInt($("#monto_visanet").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet Visa',
		          'id': 'int-visa',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoEEcheckout : " + price);

	} catch (e) {
		console.error(e);
	}
 }

function tagginSaldoErrorRecarga(action, label) {
	try {
		label=label.replace(/\n/g,' ').replace(/<br\/>/g,' ');
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'errorRecarga',
		    'category': 'UI :: Recarga',
		    'action': 'Error :: '+action,  //Indicar la modalidad de recarga donde sucedió el error ejm. Efectivo Lotocard
		    'label': label  //Enviar el mensaje de error que corresponda
		});
		
		console.log("tagginSaldoErrorRecarga: " + label);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEEpurchase(id, price) {	
	try {		
		var lastIdTransaction=localStorage.getItem("lastIdTransaction");
		if(!(lastIdTransaction===id)){
			price=parseFloat(price).toFixed(2);
			var idTransaction="VS-"+id;
			window.dataLayer = window.dataLayer || [ ];
			dataLayer.push({
			'event': 'EEpurchase',
			  'ecommerce': {
			    'purchase': {
			      'actionField': {
			        'id': idTransaction,               //  Código de la transacción       
			        'revenue': price,    // Monto total cargado
			      },
			      'products': [{                            
			        'name': 'Recarga Internet Visa',   
			        'id': 'int-visa',
			        'price': price,       // Monto de la recarga
			        'brand': 'Saldo',
			        'quantity': '1',
			        'category': 'Recarga Saldo'
			       }]
			    }
			  }
			});
			
			localStorage.setItem("lastIdTransaction",id);
			console.log("tagginSaldoEEpurchase: " + idTransaction);
		}
		
	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBCPEEaddToCart() {
	try {		
		var price=parseInt($("#monto_bcp").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet BCP',
		        'id': 'int-bcp',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBCPEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBCPEEremoveFromCart(price) {
	try {		
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': 'Recarga Internet BCP',
		          'id': 'int-bcp',
		          'price': price,      // Indicar el monto a remover
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});

		console.log("tagginSaldoBCPEEremoveFromCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBCPEEcheckout(price) {
	try {		
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet BCP',
		          'id': 'int-bcp',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBCPEEcheckout: " + price);

	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoBCPEEpurchase(code, date, price) {
	try {
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		date=(date.split(" ")[0]).split("/");
		date=date[2]+date[1]+date[0];
		var idTransaction="BC-"+code+date;
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Internet BCP',   
		        'id': 'int-bcp',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBCPEEpurchase: " + idTransaction);

	} catch (e) {
		console.error(e);
	}

}

var agrillaBCP=[];
function getGrillaBCP(){
	try{
		agrillaBCP=[];
		var igrillaBCP=$("#grillaBCP");
		var irows = $('#grillaBCP>tr');
		var icountRows = $('#grillaBCP>tr').length;
		for (var i = 1; i < icountRows; i++) {
			var price=irows[i].cells[0].innerHTML;	  
			var code=irows[i].cells[1].innerHTML;
			var date=irows[i].cells[2].innerHTML;
			var aobject=[];
			aobject["price"]=price;
			aobject["date"]=date;
			agrillaBCP[code]=aobject;		
		}
	}catch (e) {
		console.error(e);
	}	
}

function taggingCheckoutAndPurchaseBCP(){
	try{
		var fgrillaBCP=$("#grillaBCP");
		var rows = $('#grillaBCP>tr');
		var countRows = $('#grillaBCP>tr').length;
		
		for (var i = 1; i < countRows; i++) {	  
			var code=rows[i].cells[1].innerHTML;
			delete agrillaBCP[code];
		}
		
		for (var code in agrillaBCP) {
			var price=agrillaBCP[code]["price"];
			var date=agrillaBCP[code]["date"];			
			tagginSaldoBCPEEcheckout(price);
			tagginSaldoBCPEEpurchase(code, date, price);
		}
	}catch (e) {
		console.error(e);
	}
}

function tagginSaldoPEfectivoEEaddToCart() {
	try {
		var price=parseInt($("#monto_pagoefectivo").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{       
		        'name': 'Recarga Internet Pago Efectivo',
		        'id': 'int-pagoefectivo',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoPEfectivoEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoYAPEEEaddToCart() {
	try {
		var price=parseInt($("#monto_yape").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{       
		        'name': 'Recarga Internet Yape',
		        'id': 'int-yape',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoYAPEEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoPLINEEaddToCart() {
	try {
		var price=parseInt($("#monto_plin").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{       
		        'name': 'Recarga Internet Plin',
		        'id': 'int-plin',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		var tag = "tagginSaldoPLINEEaddToCart, precio: "+price;
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoSPayEEaddToCart() {
	try {
		var price=parseInt($("#monto_safetypay").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{        
		        'name': 'Recarga Internet Safety Pay',
		        'id': 'int-safetypay',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoSPayEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoLotocardEEaddToCart(price) {
	try {
//		var price=parseInt($("#monto_safetypay_efectivo").val());
//		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                   
		      'products': [{        
		        'name': 'Recarga Efectivo Lotocard',
		        'id': 'efe-lotocard',
		        'price': price,    //Deben indicar el monto asociado a la tarjeta
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});

		console.log("tagginSaldoLotocardEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoLotocardEEcheckout(price) {
	try {
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Efectivo Lotocard',
		          'id': 'efe-lotocard',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});

		console.log("tagginSaldoLotocardEEcheckout: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoLotocardEEpurchase(idTransaction, price) {
	try {
		idTransaction="LC-"+idTransaction;
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Efectivo Lotocard',   
		        'id': 'efe-lotocard',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});

		console.log("tagginSaldoLotocardEEpurchase: " + idTransaction);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEEPEfectivoEEaddToCart() {
	try {
		var price=parseInt($("#monto_pagoefectivo_efectivo").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Efectivo Pago Efectivo',
		        'id': 'efe-pagoefectivo',
		        'price': price,    //Indicar el monto a cargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoEEPEfectivoEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoEESPayEEaddToCart() {
	try {
		var price=parseInt($("#monto_safetypay_efectivo").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Efectivo Safety Pay',
		        'id': 'efe-safetypay',
		        'price': price,    // Indicar el monto a cargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoEESPayEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoAgoraEEaddToCart() {
	try {
		var price=parseInt($("#monto_agora").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet Agora',
		        'id': 'int-agora',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		console.log("tagginSaldoAgoraEEaddToCart: " + price);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoAgoraEEcheckout() {
	try {
		var price=parseInt($("#monto_agora").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet Agora',
		          'id': 'int-agora',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		console.log("tagginSaldoAgoraEEcheckout : " + price);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoAgoraEEpurchase(idTransaction, price) {
	try {		
		price=parseFloat(price).toFixed(2);
		idTransaction="AG-"+idTransaction;
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Internet Agora',   
		        'id': 'int-agora',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		console.log("tagginSaldoAgoraEEpurchase: " + idTransaction);
	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoBBVAEEaddToCart() {
	try {		
		var price=parseInt($("#monto_bbva").val());
		price=price.toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		   'event': 'EEaddToCart',
		  'ecommerce': {
		    'currencyCode': 'PEN',
		    'add': {                    
		      'products': [{        
		        'name': 'Recarga Internet BBVA',
		        'id': 'int-bbva',
		        'price': price,    //Indicar el monto a recargar
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'        
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBBVAEEaddToCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBBVAEEremoveFromCart(price) {
	try {		
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': 'Recarga Internet BBVA',
		          'id': 'int-bbva',
		          'price': price,      // Indicar el monto a remover
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});

		console.log("tagginSaldoBBVAEEremoveFromCart: " + price);

	} catch (e) {
		console.error(e);
	}

}

function tagginSaldoBBVAEEcheckout(price) {
	try {		
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEcheckout',
		    'ecommerce': {
		      'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		          'name': 'Recarga Internet BBVA',
		          'id': 'int-bbva',
		          'price': price,       //Indicar el monto a cargar 
		          'brand': 'Saldo',
		          'quantity': '1',
		          'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBBVAEEcheckout: " + price);

	} catch (e) {
		console.error(e);
	}
}

function tagginSaldoBBVAEEpurchase(code, date, price) {
	try {
		price=parseFloat(price.split(" ")[1]).toFixed(2);
		date=(date.split(" ")[0]).split("/");
		date=date[2]+date[1]+date[0];
		var idTransaction="BC-"+code+date;
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		  'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': idTransaction,               //  Código de la transacción       
		        'revenue': price,    // Monto total cargado
		      },
		      'products': [{                            
		        'name': 'Recarga Internet BBVA',   
		        'id': 'int-bbva',
		        'price': price,       // Monto de la recarga
		        'brand': 'Saldo',
		        'quantity': '1',
		        'category': 'Recarga Saldo'
		       }]
		    }
		  }
		});
		
		console.log("tagginSaldoBBVAEEpurchase: " + idTransaction);

	} catch (e) {
		console.error(e);
	}

}