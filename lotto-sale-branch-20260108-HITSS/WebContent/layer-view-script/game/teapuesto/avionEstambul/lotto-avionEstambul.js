var idsession = $("#clientId").val();
var expDays = 1; 
var promoEstambul="avionEstambul";
var popupEstambulInfo = "popup-avionEstambul"; 
var popupEstambulNivel = "popup-avionEstambul-nivel"; 
var flagPopupAvionEstambul ;

function eventAvionEstambul(){
	$(".btnEnlaceTeApuesto").click(function(){
		 toTAV2();
	});
	 
	$("#btnAvionEstambulResultados").click(function(){
		if(idsession == ''){
	    	 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
	    }else{
	    	 window.location.href = 'te-apuesto-te-lleva-final-estambul-resultados.html';
	    }
	});
	 
	$("#avionEstambul-retroceder").click(function(){ 
	    window.location.href = 'te-apuesto-te-lleva-final-estambul.html';   
	});
	 
	$("#btnAvionEstambulComoParticipar").click(function(){	 
	   window.location.href = 'te-apuesto-te-lleva-final-estambul-como-participar.html';   
	});
	 
	$("#btnAvionEstambulRegistrar").click(function(){
		if(idsession == ''){
			 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
		}else{
			 window.location.href = 'te-apuesto-te-lleva-final-estambul-registrar.html'; // 
		}
	});
	 
	//COPA CASA REGISTRO TICKET
	$(document).delegate('#btn_desktop_registra_ticket', 'click', function () {
	    window.open('https://www.programateapuesto.pe/', '_blank');
	});
	 
	$(document).delegate('#btnAvionEstambulInfo', 'click', function () {
		 window.location.href = 'te-apuesto-te-lleva-final-estambul.html';	   
	});
	
	$(document).delegate('#popup-avionEstambul .close-PromSorteo-ta', 'click', function () {
		$("#popup-avionEstambul").removeClass("opened");
	});
	
	$(document).delegate('#popup-avionEstambul-nivel .close-PromSorteo-ta', 'click', function () {
		window.open(baseUrl+"?authToken="+authToken,"_parent");
	});
	
	 
}


 //VALIDAR COPA EN CASA DESDE INTERFACE COMO PARTICIPAR
 
function VerMisJugadasEstambul() {
	if(idsession == '' || idsession == '0'){
		 jAlert("Para ver tus jugadas con las que participarás, debes aceptar participar de la promoción e ingresar a tu cuenta.","Aviso");
	}else if(promoEstambul = "avionEstambul"){
		 window.location.href = 'te-apuesto-te-lleva-final-estambul-resultados.html';
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
	if (count != null){//ya se mostro en el dia
		if(popup==popupEstambulNivel){//pop up post login
			try {
				//evalPopupInformativo();
			} catch (e) {
				
			}
		}
		return;
	}
	
	localStorage.removeItem("exp_"+popup);
	var exp = new Date();
	exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
	count=1;
	SetCookie(popup , count, exp);
	localStorage.setItem("exp_"+popup , exp);
	openModal("#"+popup , "");
		
}



function fechasPopupEstambul(){
	$.ajax({
        type: "POST",
        url: "te-apuesto-te-lleva-final-estambul-fechas-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	flagPopupAvionEstambul = data.flagPopup;
        	console.log(data);
        }
	});
}

function activarPopupAvionEstambulNivel(){

	$.ajax({
        type: "POST",
        url: "te-apuesto-te-lleva-final-estambul-resultados-popup.html",
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
        	
        	console.log('el total de tickets promo avion Estambul es: '+totalTickets);
        	console.log('el nivel es: ' +puntaje);
        	console.log('activarPremio: ' +activarPremio);
        	
        	if(activarPremio == 1){
				result2 = '<p class="jugadas-popup-descripcion" style="color: #f75b1e; ">¡GANASTE S/ 10 DE SALDO AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:#000000;">con tus tickets: '+ticketsWin+'</p></div>';
			}else if (activarPremio == 0){
				result2 = '<p class="jugadas-popup-descripcion" style="color: #f75b1e; ">Tus jugadas WEB participan automáticamente</p><p class="jugadas-popup-descripcion2" style="color: #000000">¡Son S/ 443,000 en saldo al instante!</p></div>';
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
			'<button type="button" onclick="VerMisJugadasEstambul()" class="button-avion-qatar-blanco" style="width:133px;margin-right: 5px;cursor:pointer;">Ver mis jugadas</button>' +
			'<button type="button" onclick="btnTA()" class="button-avion-qatar-naranja btnEnlaceTeApuesto" style="width:163px;margin-left: 5px;margin-bottom: 7px;cursor:pointer;">Juega desde S/ 10</button>';

			result = result + result2;

			$("#nivel-avionEstambul").html(result);
			 
			$(".btnEnlaceTeApuesto").click(function(){
				 toTAV2();
			});
			
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(()=>checkCountPopupPromocion(popupEstambulNivel) , timeUp) ;       	
        },
        error: function(Response, textStatus, errorThrown) {
        	console.log("Error en la solicitud : " + Response.status);
        }
	});
}

function loginUsuario(){
	return ($("#clientId").val() == '') || ( $("#clientId").val() == undefined );
}

function loginUsuarioOk(){
	return ($("#clientId").val() != '') && ($("#clientId").val() != undefined );
}

$(document).ready(function(){
	
	fechasPopupEstambul();
	var pathname = window.location.pathname; 
	var ref = window.document.referrer;
	console.log(ref);
	
	var flagPromoGD3x5 = false;
	if( $("#flagPromoGD3x5").val() != undefined ){
		flagPromoGD3x5 = JSON.parse($("#flagPromoGD3x5").val());
	}
	
	if( loginUsuario  && flagPopupAvionEstambul && verifyPathNames(['/juega-','inicio.html'],true) ){
		if( !verifyPathNames(['/juega-ganadiario.html'],false) || !flagPromoGD3x5){
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(()=>checkCountPopupPromocion(popupEstambulInfo) , timeUp) ;
		}
	}	
	
	if( loginUsuarioOk && flagPopupAvionEstambul && pathname.includes("mi-cuenta.html") && 
			(ref!='http://qa.intralotportal.com.pe/' && ref!='https://latinkalotportal.com.pe/')){//esta activo pop up estambul
		$.ajax({
	        type: "POST",
	        url: "te-apuesto-te-lleva-final-estambul-verificar-promocion.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
				if( data.flagPromo ){//participa en la promocion estambul
					activarPopupAvionEstambulNivel();
				}else{
					try {
						//evalPopupInformativo();
					} catch (e) {
						
					}
				}
	        }
	    });
	}else{
		try {
			//evalPopupInformativo();
		} catch (e) {
			
		}
	}
	
	eventAvionEstambul();
	
});
 
 
 