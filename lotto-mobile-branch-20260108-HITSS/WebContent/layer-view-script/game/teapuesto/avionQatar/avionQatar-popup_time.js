
var flag = '1';
var flagPopupAvionQatar ; 
var flagRevientaTinka = $("#flagPromoTinka").val() =="true" ? true : false ;
function activarPopupAvionQatar(){
	checkcount_avionQatar();
}


function getCookieVal(offset) {
	var endstr = document.cookie.indexOf (";", offset);
	if (endstr == -1)
		endstr = document.cookie.length;
	return unescape(document.cookie.substring(offset, endstr));
}

function GetCookie (name) {
	var arg = name + "=";
	var alen = arg.length;
	var clen = document.cookie.length;
	var i = 0;
	while (i < clen) {
	var j = i + alen;
	if (document.cookie.substring(i, j) == arg)
	return getCookieVal (j);
	i = document.cookie.indexOf(" ", i) + 1;
	if (i == 0) break;
	}
	return null;
}

function SetCookie (name, value) {
	var argv = SetCookie.arguments;
	var argc = SetCookie.arguments.length;
	var expires = (argc > 2) ? argv[2] : null;
	var path = (argc > 3) ? argv[3] : null;
	var domain = (argc > 4) ? argv[4] : null;
	var secure = (argc > 5) ? argv[5] : false;
	document.cookie = name + "=" + escape (value) +
	((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
	((path == null) ? "" : ("; path=" + path)) +
	((domain == null) ? "" : ("; domain=" + domain)) +
	((secure == true) ? "; secure" : "");
}

function DeleteCookie (name) {
	var exp = new Date();
	exp.setTime (exp.getTime() - 1);
	var cval = GetCookie (name);
	document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
}

function checkcount_avionQatar() {
	var count_avionQatar = GetCookie('popup-avionQatar');
	if (count_avionQatar == null) {
		var expDays = 1;
		localStorage.removeItem("exp_avionQatar_mobile_nivel");
		var exp = new Date();
		exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
		count_avionQatar=1;
		SetCookie('popup-avionQatar', count_avionQatar, exp);
		localStorage.setItem("exp_avionQatar_mobile_nivel", exp);
		openModal("#popup-avionqatar", "");							
	}
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
	window.open(baseUrl+"?authToken="+authToken,"_parent");
}

function VerMisJugadas() {
	if(idsession == '' || idsession == '0'){
		goSecurityLoginExecute('avionQatar');
	}else if(promo = "avionQatar"){
		 window.location.href = 'te-apuesto-te-lleva-final-qatar-resultados.html';
	}
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
			'<button type="button" id="btnAvionQatarResultados" onclick="return false;"class="button-avion-qatar-blanco" style="width:133px;margin-right: 5px;">Ver mis jugadas</button>' +
			'<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-avion-qatar-amarillo" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 10</button>';

			result = result + result2;

			$("#nivel-avionQatar").html(result);
			 
			 
			var count_copa = GetCookie('popupAvionQatar_nivel');
			
			if (count_copa != null) return;
			 
			var expDays = 1;
			localStorage.removeItem("exp_popup_nivel_mobile");
			var exp = new Date();
			exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
			count_copa=1;
			SetCookie('popupAvionQatar_nivel', count_copa, exp);
			localStorage.setItem("exp_popup_nivel_mobile", exp);
			openModal("#popup-avionQatar-nivel", "");
			 
						        			        	
        }
	});
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

$(document).ready(function(){
	 
	$(document).delegate('#btn_home_avion_qatar', 'click', function () {
		 window.location.href = 'te-apuesto-te-lleva-final-qatar.html';		   
	});
	 
	fechasPopup();
	
	var pathname = window.location.pathname;  
	var fechafinPopupCasino = new Date(2022,8,30,23,59,59); // 30/09/22
	var fechaActual = new Date();
	
	if( ($("#clientId").val() == '' || $("#clientId").val() == undefined ) && flagPopupAvionQatar &&  !pathname.includes("game_casino_show_home.html") &&
		(pathname.includes("home.html") || pathname.includes("tav2.html") || pathname.includes("show_menu.html") || pathname.includes("show_home.html") ) 
		){
		if( !flagRevientaTinka || ( !pathname.includes("home.html") && !pathname.includes("game_tinka_show_menu.html") )  ){
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(activarPopupAvionQatar , timeUp) ;
		} 
	}
	
	if( fechafinPopupCasino.getTime() < fechaActual.getTime() && pathname.includes("game_casino_show_home.html") && flagPopupAvionQatar ){
		let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
		setTimeout(activarPopupAvionQatar , timeUp) ;
	}
	
	if( ($("#clientId").val() != '' && $("#clientId").val() != undefined ) && flagPopupAvionQatar && (window.location.pathname.includes("/home.html") )){
		
		$.ajax({
	        type: "POST",
	        url: "te-apuesto-te-lleva-final-qatar-verificar-promocion.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
	        	console.log("te-apuesto-te-lleva-final-qatar-verificar-promocion.html");
	        	console.log(data);
				if( data.flagPromo ){
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
					setTimeout(activarPopupAvionQatarNivel , timeUp) ;
				}
	        }
	    });							   				
	}

}); 



