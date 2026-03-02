var idsession = $("#clientId").val();
var expDays = 1; 
var promo="avionQatar";
var popupInfo = "popup-avionQatar"; 
var popupNivel = "popup-avionQatar-nivel"; 
var flagPopupAvionQatar ;
var flagRevientaTinka = $("#flagPromoTinka").val() =="true" ? true : false ;

function eventAvionQatar(){
	$(".btnEnlaceTeApuesto").click(function(){
		 toTAV2();
	});
	 
	$("#btnAvionQatarResultados").click(function(){
		if(idsession == ''){
	    	 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
	    }else{
	    	 window.location.href = 'te-apuesto-te-lleva-final-qatar-resultados.html';
	    }
	});
	 
	$("#avionQatar-retroceder").click(function(){
	    window.location.href = 'te-apuesto-te-lleva-final-qatar.html';   
	});
	 
	$("#btnAvionQatarComoParticipar").click(function(){	 
	   window.location.href = 'te-apuesto-te-lleva-final-qatar-como-participar.html';   
	});
	 
	$("#btnAvionQatarRegistrar").click(function(){
		if(idsession == ''){
			 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
		}else{
			 window.location.href = 'te-apuesto-te-lleva-final-qatar-registrar.html'; // 
		}
	});
	 
	//COPA CASA REGISTRO TICKET
	$(document).delegate('#btn_desktop_registra_ticket', 'click', function () {
	    window.open('https://www.programateapuesto.pe/', '_blank');
	});
	 
	$(document).delegate('#btnAvionqatarInfo', 'click', function () {
		 window.location.href = 'te-apuesto-te-lleva-final-qatar.html';	   
	});
	
	$(document).delegate('#popup-avionQatar .close-PromSorteo-ta', 'click', function () {
		$("#popup-avionQatar").removeClass("opened");
	});
	
	$(document).delegate('#popup-avionQatar-nivel .close-PromSorteo-ta', 'click', function () {
		window.open(baseUrl+"?authToken="+authToken,"_parent");
	});
	
	 
}


 //VALIDAR COPA EN CASA DESDE INTERFACE COMO PARTICIPAR
 
function VerMisJugadas() {
	if(idsession == '' || idsession == '0'){
		 jAlert("Para ver tus jugadas con las que participarás, debes aceptar participar de la promoción e ingresar a tu cuenta.","Aviso");
	}else if(promo = "avionQatar"){
		 window.location.href = 'te-apuesto-te-lleva-final-qatar-resultados.html';
	}
}

function btnTA() {
	var pathname = window.location.pathname; 
	if(pathname.includes("/tav2.html") ){
		window.open(baseUrl+"?authToken="+authToken,"_parent");
	}else{
		 toTAV2();
	}
	
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	 
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function checkCountPopupPromocion(popup) {
	
	var count = GetCookie(popup);
	console.log(' GetCookie ' + popup + " : " + count);
	if (count != null) return;
	
	localStorage.removeItem("exp_"+popup);
	var exp = new Date();
	exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
	count=1;
	SetCookie(popup , count, exp);
	localStorage.setItem("exp_"+popup , exp);
	openModal("#"+popup , "");
		
}



function fechasPopup(){
	$.ajax({
        type: "POST",
        url: "te-apuesto-te-lleva-final-qatar-fechas-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	flagPopupAvionQatar = data.flagPopup;
        	console.log(data);
        }
	});
}

function activarPopupAvionQatarNivel(){

	$.ajax({
        type: "POST",
        url: "te-apuesto-te-lleva-final-qatar-resultados-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
 
        	var totalTickets = data.nivel;
        	var puntaje = data.puntajeNivel;
        	var result = "";
        	var result2 = "";
        	var nivel="";
        	var activarPremio = data.activarPremio;
        	var listTickets= data.totalTickets;
        	var ticketsWin= data.ticketsWin;
        	
        	console.log('el total de tickets promo avion Qatar es: '+totalTickets);
        	console.log('el nivel es: ' +puntaje);
        	console.log('activarPremio: ' +activarPremio);
        	
        	if(activarPremio == 1){
				result2 = '<p class="jugadas-popup-descripcion" style="color: #f0c607; ">¡GANASTE S/ 10 DE SALDO AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:#ffffff;">con tus tickets: '+ticketsWin+'</p></div>';
			}else if (activarPremio == 0){
				result2 = '<p class="jugadas-popup-descripcion" style="color: #ffffff; ">Tus jugadas WEB participan automáticamente</p><p class="jugadas-popup-descripcion2" style="color: #f0c607">¡Son S/ 110,000 en saldo al instante!</p></div>';
			}
        	
			if(totalTickets >=0 && totalTickets<=9){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Calichin_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CALICHÍN</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">'  ;
				
			}else if(totalTickets >=10 && totalTickets<=49){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Amateur_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">AMATEUR</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' ;

			}else if(totalTickets >=50 && totalTickets<=99){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Crack_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CRACK</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">'  ;

			}else if(totalTickets >=100){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Leyenda_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">LEYENDA</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">'  ;
			 }
			
			result = result +
			'<button type="button" onclick="VerMisJugadas()" class="button-avion-qatar-blanco" style="width:133px;margin-right: 5px;cursor:pointer;">Ver mis jugadas</button>' +
			'<button type="button" onclick="btnTA()" class="button-avion-qatar-amarillo btnEnlaceTeApuesto" style="width:163px;margin-left: 5px;margin-bottom: 7px;cursor:pointer;">Juega desde S/ 10</button>';

			result = result + result2;

			$("#nivel-avionQatar").html(result);
			 
			$(".btnEnlaceTeApuesto").click(function(){
				 toTAV2();
			});
			
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(()=>checkCountPopupPromocion(popupNivel) , timeUp) ;       	
        },
        error: function(Response, textStatus, errorThrown) {
        	console.log("Error en la solicitud : " + Response.status);
        }
	});
}

$(document).ready(function(){
	
	fechasPopup();
	var pathname = window.location.pathname; 
	pathname += "artificio";
	var ref = window.document.referrer;
	console.log(ref);
	
	
	if(($("#clientId").val() == '' || $("#clientId").val() == undefined ) && flagPopupAvionQatar &&  !pathname.includes("juega-casino.html") && 
	(pathname.includes("/juega-") || pathname.includes("/artificio") || pathname.includes("/inicio.html") || pathname.includes("/tav2.html")) 
	){
		if(!flagRevientaTinka || ( !pathname.includes("/artificio") && !pathname.includes("/inicio.html") && !pathname.includes("juega-tinka.html") ) ){
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(()=>checkCountPopupPromocion(popupInfo) , timeUp) ; 
		}
	}	
	
	if( pathname.includes("juega-casino.html") ){
		var fechafinPopupCasino = new Date(2022,7,18,23,59,59);
		var fechaActual = new Date();
		if(fechafinPopupCasino.getTime() < fechaActual.getTime() && flagPopupAvionQatar){
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(()=>checkCountPopupPromocion(popupInfo) , timeUp) ; 
		}
	}
	
	if(($("#clientId").val() != '' && $("#clientId").val() != undefined ) && flagPopupAvionQatar && pathname.includes("mi-cuenta.html") && 
			(ref!='http://qa.intralotportal.com.pe/' && ref!='https://latinkalotportal.com.pe/')){
		$.ajax({
	        type: "POST",
	        url: "te-apuesto-te-lleva-final-qatar-verificar-promocion.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
	        	console.log(data);
				if( data.flagPromo ){
					activarPopupAvionQatarNivel();
				}
	        }
	    });
	}
	
	eventAvionQatar();
	
});
 
 
 