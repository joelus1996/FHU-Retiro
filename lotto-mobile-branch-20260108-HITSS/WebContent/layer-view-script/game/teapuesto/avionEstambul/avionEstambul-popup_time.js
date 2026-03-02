
var flag = '1';
var flagPopupAvionEstambul ; 
var flagRevientaTinka = $("#flagPromoTinka").val() =="true" ? true : false ;
function activarPopupAvionEstambul(){
	checkcount_avionEstambul();
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

function checkcount_avionEstambul() {
	var count_avionEstambul = GetCookie('popup-avionEstambul');
	if (count_avionEstambul == null) {
		var expDays = 1;
		localStorage.removeItem("exp_avionEstambul_mobile_nivel");
		var exp = new Date();
		exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
		count_avionEstambul=1;
		SetCookie('popup-avionEstambul', count_avionEstambul, exp);
		localStorage.setItem("exp_avionEstambul_mobile_nivel", exp);
		openModal("#popup-avionestambul", "");							
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

function VerMisJugadasEstambul() {
	if(idsession == '' || idsession == '0'){
		goSecurityLoginExecute('avionEstambul');
	}else if(promo = "avionEstambul"){
		 window.location.href = 'te-apuesto-te-lleva-final-estambul-resultados.html';
	}
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
				result2 = '<p class="jugadas-popup-descripcion" style="color: #fb5300; ">¡GANASTE S/ 10 DE SALDO AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:#000000;">con tus tickets: '+ticketsWin+'</p></div>';
			}else if (activarPremio == 0){
				result2 = '<p class="jugadas-popup-descripcion" style="color: #fb5300; ">Tus jugadas WEB participan automáticamente</p><p class="jugadas-popup-descripcion2" style="color: #000000">¡Son S/ 443,000 en saldo al instante!</p></div>';
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
			'<button type="button" id="btnAvionEstambulResultados" onclick="return false;"class="button-avion-qatar-blanco" style="width:133px;margin-right: 5px;">Ver mis jugadas</button>' +
			'<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-avion-qatar-naranja" style="width:172px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 10</button>';

			result = result + result2;

			$("#nivel-avionEstambul").html(result);
			 
			 
			var count_copa = GetCookie('popupAvionEstambul_nivel');
			
			if (count_copa != null) {//ya se mostro en el dia
				try {
					//evalPopupInformativo();
				} catch (e) {
					
				}
				return;
			}
			 
			var expDays = 1;
			localStorage.removeItem("exp_popup_nivel_mobile");
			var exp = new Date();
			exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
			count_copa=1;
			SetCookie('popupAvionEstambul_nivel', count_copa, exp);
			localStorage.setItem("exp_popup_nivel_mobile", exp);
			openModal("#popup-avionEstambul-nivel", "");
			 
						        			        	
        }
	});
}

function fechasPopup(){
	
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

function loginUsuario(){
	return ($("#clientId").val() == '') || ( $("#clientId").val() == undefined );
}

function loginUsuarioOk(){
	return ($("#clientId").val() != '') && ($("#clientId").val() != undefined );
}

$(document).ready(function(){
	 
	$(document).delegate('#btn_home_avion_estambul', 'click', function () {
		 window.location.href = 'te-apuesto-te-lleva-final-estambul.html';		   
	});
	 
	fechasPopup();
	
	var pathname = window.location.pathname;  
	var fechafinPopupCasino = new Date(2022,8,30,23,59,59); // 30/09/22
	var fechaActual = new Date();
	
	var flagPromoGD3x5 = false;
	if( $("#flagPromoGD3x5").val() != undefined ){
		flagPromoGD3x5 = JSON.parse($("#flagPromoGD3x5").val());
	}
	
	if( loginUsuario  && flagPopupAvionEstambul &&  (verifyPathNames(['home.html','show_menu.html','show_home.html'])) ){
		if( !verifyPathNames(['game_ganadiario_show_menu.html']) || !flagPromoGD3x5 ){
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(activarPopupAvionEstambul , timeUp) ;
		} 
	}
	
	if( ( loginUsuarioOk ) && flagPopupAvionEstambul && ( verifyPathNames(['/home.html']) ) ){ //esta activo pop up estambul
		
		$.ajax({
	        type: "POST",
	        url: "te-apuesto-te-lleva-final-estambul-verificar-promocion.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
	        	console.log("te-apuesto-te-lleva-final-estambul-verificar-promocion.html");
	        	console.log(data);
				if( data.flagPromo ){//participa en la promocion estambul
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
					setTimeout(activarPopupAvionEstambulNivel , timeUp) ;
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

}); 



