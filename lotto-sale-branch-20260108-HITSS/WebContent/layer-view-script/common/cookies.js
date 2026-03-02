// Función para guardar una cookie
function setCookie(name, value, expirationDays) {
  var expirationDate = new Date();
  expirationDate.setDate(expirationDate.getDate() + expirationDays);

  document.cookie = name + "=" + value + "; expires=" + expirationDate.toUTCString() + "; path=/";
}

// Función para obtener el valor de una cookie
function getCookie(name) {
  var cookies = document.cookie.split("; ");
  var cookieValue = "";

  for (var i = 0; i < cookies.length; i++) {
    var cookie = cookies[i].split("=");
    if (cookie[0] === name) {
      cookieValue = cookie[1];
      break;
    }
  }

  return cookieValue;
}

// Función para eliminar una cookie
function deleteCookie(name) {
  document.cookie = name + "=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
}


// Jugadas en cookie
let categories = {
	    'plays-1': ['Tinka', 'RaspaYa', 'Kabala', 'GanaDiario', 'Kinelo'],
	    'plays-2': ['LaPolla', 'TeApuesto', 'Virtuales'],
	    'plays-3': ['Slots', 'Jackpots', 'Virtual', 'EnVivo', 'Ganagol']
	};


//Función para guardar la jugada en una cookie 
function guardarJugadaEnCookie(nameJugadaCookie,content_object, expirationDays) {
  setCookie(nameJugadaCookie, JSON.stringify(content_object), expirationDays);
}

// Función para obtener la jugada desde la cookie
function obtenerJugadaDesdeCookie(nameJugadaCookie) {
  var contentObjectString = getCookie(nameJugadaCookie);
  return contentObjectString !== "" ? JSON.parse(contentObjectString) : [];
}

// Función para eliminar la cookie de la jugada
function eliminarCookieDeJugada(nameJugadaCookie) {
  deleteCookie(nameJugadaCookie);
}


// validamos las jugadas en session y marcamos en rojo donde corresponda
function validarJugadasSession(){
	
		let hasNotification , sessionVar , 
		gameLink , windowLocationHref = window.location.href;
		
		// recorriendo la categories
		$.each(categories, function(category, games) {

		    hasNotification = false;

		    // recorriendo los games de la categorias
		    $.each(games, function(index, game) {
		        
		        sessionVar = 'jugadaSession' + game;

		        if (obtenerJugadaDesdeCookie(sessionVar).length > 0) {
		            
		        	if(windowLocationHref.includes("juega-tinka") && !windowLocationHref.includes("state=1")){
		            	window.location.href = window.location.href + "?state=1";
		            }
		        	
		        	// agregando el marcado de jugada en cookie
		            gameLink = $('#' + category + ' > ul > li > a[href="juega-' + game.toLowerCase() + '.html"]');
		            gameLink.prepend($('<span class="jugadaSession"></span>'));
		   
		            hasNotification = true;
		            
		        }
		    });

		    // verificando si al menos un game esta marcado en session para marcar la categoria
		    if (hasNotification) {
		        let categoryLink = $('#' + category + ' > a');
		        categoryLink.prepend($('<span class="jugadaSession"></span>'));
		    }
		});
		
}

