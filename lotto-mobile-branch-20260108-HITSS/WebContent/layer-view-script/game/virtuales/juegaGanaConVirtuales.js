

var flag = '1';
var flagPopupJuegaGanaDDVV ; 

var flagRevientaTinka = $("#flagPromoTinka").val() =="true" ? true : false ;

var pathname = window.location.pathname;

var popUpJuegaGanaDDVV = 'popup-juegaGanaVirtuales';
var popUpJuegaGanaDDVVNivel = 'popup-juegaGanaVirtuales-nivel';

var CategoriaPopupJuegaGanaDDVV = [{
			"src":"layer-view-image/game/copaentucasa/Calichin_popup.jpg",
			"nombre" : "CALICHÍN"
		},{
			"src":"layer-view-image/game/copaentucasa/Amateur_popup.jpg",
			"nombre" : "AMATEUR"	
		},{
			"src":"layer-view-image/game/copaentucasa/Crack_popup.jpg",
			"nombre" : "CRACK"
		},{
			"src":"layer-view-image/game/copaentucasa/Leyenda_popup.jpg",
			"nombre" : "LEYENDA"
		}] ;

$(document).delegate('#security_login_execute_authentication_juegaGanaDDVV', 'click', function () {
    goSecurityLoginExecute('juegaGanaDDVV');
});

$(document).delegate('#btn_home_juegaGanaVirtuales , #JuegaGanaDDVV-retroceder', 'click', function () {
	 window.location.href = 'juega-y-gana-con-virtuales.html';		   
});

$(document).delegate('#btnJuegaGanaDDVVResultados', 'click', function () {
    window.location.href = 'juega-y-gana-con-virtuales-resultados.html';
});

$(document).delegate('#btnJuegaGanaDDVVRegistrar', 'click', function () {
    window.location.href = 'juega-y-gana-con-virtuales-registrar.html';
});

$(document).delegate('#btnJuegaGanaDDVVComoParticipar', 'click', function () {
    window.location.href = 'juega-y-gana-con-virtuales-como-participar.html';
});

$(document).delegate('#btn_mobile_virtuales_home , .btnLinkDeportesVirtuales', 'click', function () {
    window.location.href = 'game_virtuales_show_home.html';
});


function activarPopupJuegaGanaDDVV(idPopUpJuegaGanaDDVV){
	let count_JuegaGanaDDVV = GetCookie(idPopUpJuegaGanaDDVV);
	if (count_JuegaGanaDDVV != null) return;
	
	let expDays = 1;
	localStorage.removeItem(idPopUpJuegaGanaDDVV);
	let exp = new Date();
	exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
	count_JuegaGanaDDVV=1;
	SetCookie(idPopUpJuegaGanaDDVV, count_JuegaGanaDDVV, exp);
	localStorage.setItem(idPopUpJuegaGanaDDVV, exp);
	openModal("#"+idPopUpJuegaGanaDDVV, "");
}

function activarInfoJuegaGanaDDVV(){
	activarPopupJuegaGanaDDVV(popUpJuegaGanaDDVV);
}

function activarNivelJuegaGanaDDVV(){
	
	let count_JuegaGanaDDVV = GetCookie(popUpJuegaGanaDDVVNivel);
	if (count_JuegaGanaDDVV != null) {
		try { validarPromosActivarEvalPopupInformativo(popUpJuegaGanaDDVVNivel); } catch (e) {}
		return;
	}
	
	$.ajax({
        type: "POST",
        url: "juega-y-gana-con-virtuales-resultados-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	let result = "";
        	let nivel = 0;
        	
        	$("#nivel-juegaGanaVirtuales .posicion-nivel-img-popup div .puntaje-por-nivel-popup").html(data.puntajeNivel);
        	if(data.activarPremio == 1){
        		$("#nivel-juegaGanaVirtuales .copa-opciones-popup .jugadas-popup-descripcion").css('color',' #e16e1a');
        		$("#nivel-juegaGanaVirtuales .copa-opciones-popup .jugadas-popup-descripcion").html('¡GANASTE S/ 5 DE SALDO AL INSTANTE!');
        		$("#nivel-juegaGanaVirtuales .copa-opciones-popup .jugadas-popup-descripcion2").css('color',' #000000');
        		$("#nivel-juegaGanaVirtuales .copa-opciones-popup .jugadas-popup-descripcion2").html('con tus tickets: '+data.ticketsWin);
        	}
        	
        	nivel = popupCategoriaNivelArray(data.nivel);
        	
        	$("#nivel-juegaGanaVirtuales .posicion-nivel-img-popup img").attr("src",CategoriaPopupJuegaGanaDDVV[nivel]["src"]);
			$("#nivel-juegaGanaVirtuales .posicion-nivel-img-popup div .tipo-nivel-popup").html(CategoriaPopupJuegaGanaDDVV[nivel]["nombre"]);
			 
			setTimeout(() => activarPopupJuegaGanaDDVV(popUpJuegaGanaDDVVNivel) , 500) ;
			        			        	
        }
	});
}

function popupCategoriaNivelArray(totalTickets){
	if(totalTickets >=0 && totalTickets<=9){
		return 0;
	}else if(totalTickets >=10 && totalTickets<=49){
		return 1;
	}else if(totalTickets >=50 && totalTickets<=99){
		return 2;
	}else if(totalTickets >=100){
		return 3;
	}
}

function VerMisJugadasJuegaGanaDDVV() {
	if(!usuarioConexion()){
		goSecurityLoginExecute('juegaGanaDDVV');
	}else{
		 window.location.href = 'juega-y-gana-con-virtuales-resultados.html';
	}
}

function fechasPopupJuegaGanaDDVV(){
	$.ajax({
        type: "POST",
        url: "juega-y-gana-con-virtuales-fechas-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	flagPopupJuegaGanaDDVV = data.flagPopup;
        }
	});
	
}

function usuarioConexion(){
	return ($("#clientId").val() != '' && $("#clientId").val() != undefined);
}

function pathnameIncludeJuegaGanaDDVV(){
	return ( pathname.includes("/home.html") || pathname.includes("show_menu.html") || pathname.includes("show_home.html") );
}

function pathnameCondicionTinkaSioSi(){
	return ( !flagRevientaTinka || ( !pathname.includes("/home.html") && !pathname.includes("/game_tinka") )  );
}

$(document).ready(function(){

	
	fechasPopupJuegaGanaDDVV();
	
	if( ( loginUsuarioOk() ) && flagPopupJuegaGanaDDVV && ( verifyPathNames(['/home.html']) ) ){
		$.ajax({
	        type: "POST",
	        url: "juega-y-gana-con-virtuales-verificar-promocion.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
				if( data.flagPromo ){
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
					setTimeout(activarNivelJuegaGanaDDVV , timeUp) ;
				}else{
					try { validarPromosActivarEvalPopupInformativo(popUpJuegaGanaDDVVNivel); } catch (e) {}
				}
	        }
	    });
	}else{
		try { validarPromosActivarEvalPopupInformativo(popUpJuegaGanaDDVVNivel); } catch (e) {}
	}
	/*
	if(!usuarioConexion() && pathnameIncludeJuegaGanaDDVV() && pathnameCondicionTinkaSioSi() ){
		let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
		setTimeout(activarInfoJuegaGanaDDVV , timeUp) ; 
	}  
	 */
}); 




// funciones cookies
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

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
	window.open(baseUrl+"?authToken="+authToken,"_parent");
}


function htmlSubString(palabra,cambiador){
	$.expr[":"].xcontains = $.expr.createPseudo(function(arg){
	    arg=arg.replace(/([\.\+\?\^\$\\])/g,'\$1').replace(/[*%]/g,'.*');
	    var prex=new RegExp(arg,'i');
	    return function(elem){
	        return jQuery(elem).text().search(prex)>=0;
	    };
	});
	
    if(jQuery.trim(palabra) != ''){
    	let tagHtml = $("*:xcontains('" + palabra + "')");
    	tagHtml[tagHtml.length - 1].innerHTML = cambiador;
    }
};

