
var flag = '1';
var flagPopupAvionPeru ; 
var flagRevientaTinka = $("#flagPromoTinka").val() =="true" ? true : false ;
function activarPopupAvionPeru(){
	checkcount_avionPeru();
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

function checkcount_avionPeru() {
	var count_avionPeru = GetCookie('popup-avionPeru');
	if (count_avionPeru == null) {
		var expDays = 1;
		localStorage.removeItem("exp_avionPeru_mobile_nivel");
		var exp = new Date();
		exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
		count_avionPeru=1;
		SetCookie('popup-avionPeru', count_avionPeru, exp);
		localStorage.setItem("exp_avionPeru_mobile_nivel", exp);
		openModal("#popup-avionPeru", "");							
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

function VerMisJugadasAvionPeru() {
	if(idsession == '' || idsession == '0'){
		goSecurityLoginExecute('avionPeru');
	}else if(promo = "avionPeru"){
		 window.location.href = 'avion-del-hincha-te-lleva-eliminatorias-peru-resultados.html';
	}
}

function activarPopupAvionPeruNivel(){

	$.ajax({
        type: "POST",
        url: "avion-del-hincha-te-lleva-eliminatorias-peru-resultados-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	
        	let totalTickets = data.nivel;
        	let puntaje = data.puntajeNivel;
        	let activarPremio = data.activarPremio;
        	let listTickets= data.totalTickets;
        	let ticketsWin= data.ticketsWin;
        	
        	let nivel, imagen, mensajePremio;
        	if (activarPremio == 1) {
          	  mensajePremio = `	<p class="jugadas-popup-descripcion" style="color: #f75b1e; ">¡GANASTE S/ 5 DE SALDO AL INSTANTE!</p>
          		  				<p class="jugadas-popup-descripcion2" style="color:#000000;">con tus tickets: ${ticketsWin}</p>`;
          	} else if (activarPremio == 0) {
          	  mensajePremio = `	<p class="jugadas-popup-descripcion" style="color: #f75b1e; ">Tus jugadas WEB participan AUTOMÁTICAMENTE</p>
          		  				<p class="jugadas-popup-descripcion2" style="color: #000000">¡También premia con saldo al instante!</p>`;
          	}
        	
        	if (totalTickets >= 0 && totalTickets <= 200) {
          	  nivel = 'CALICHÍN';
          	  imagen = 'Calichin_popup.jpg';
          	} else if (totalTickets >= 201 && totalTickets <= 500) {
          	  nivel = 'AMATEUR';
          	  imagen = 'Amateur_popup.jpg';
          	} else if (totalTickets >= 501 && totalTickets <= 1000) {
          	  nivel = 'CRACK';
          	  imagen = 'Crack_popup.jpg';
          	} else if (totalTickets >= 1001) {
          	  nivel = 'LEYENDA';
          	  imagen = 'Leyenda_popup.jpg';
          	}
        	
        	let result = 
        		`<div class="posicion-nivel-img-popup">
        		 	<img src="layer-view-image/game/copaentucasa/${imagen}" class="level-header-copa-casa-popup">
          	  		<div class="desc-nivel-position-popup">
          	  			<span class="tipo-nivel-popup">${nivel}</span>
          	  			<br>
          	  			<span class="tipo-nivel-descripcion-superior-popup">Tienes </span>
          	  			<span class="puntaje-por-nivel-popup">${puntaje}</span>
          	  			<br>
          	  			<span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span>
          	  			<br>
          	  			<span class="tipo-nivel-descripcion-popup">de premios mayores</span>
          	  		</div>
          	  	 </div>
          	  	 <div class="message-button-popup-nivel" >
          	  	 	<button type="button" id="btnAvionPeruResultados" onclick="return false;"class="button-avion-qatar-blanco" style="width:133px;margin-right: 5px;">Ver mis puntos</button>
          	  		<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-avion-qatar-naranja" style="width:172px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 10</button>
          	  		${mensajePremio}
			     </div>`;

  			$("#nivel-avionPeru").html(result);
        	
			
			var count_copa = GetCookie('popupAvionPeru_nivel');
			
			if (count_copa != null) {//ya se mostro en el dia
				try { validarPromosActivarEvalPopupInformativo('popup-avionPeru-nivel'); } catch (e) {}
				return;
			}
			 
			var expDays = 1;
			localStorage.removeItem("exp_popup_nivel_mobile");
			var exp = new Date();
			exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
			count_copa=1;
			SetCookie('popupAvionPeru_nivel', count_copa, exp);
			localStorage.setItem("exp_popup_nivel_mobile", exp);
			openModal("#popup-avionPeru-nivel", "");
			 
						        			        	
        }
	});
}

function fechasPopup(){
	
	$.ajax({
        type: "POST",
        url: "avion-del-hincha-te-lleva-eliminatorias-peru-fechas-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	flagPopupAvionPeru = data.flagPopup;
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
	 
	$(document).delegate('#btnHomeAvionPeru', 'click', function () {
		 window.location.href = 'avion-del-hincha-te-lleva-eliminatorias-peru.html';		   
	});
	 
	fechasPopup();
	
	var pathname = window.location.pathname;  
	var fechafinPopupCasino = new Date(2022,8,30,23,59,59); // 30/09/22
	var fechaActual = new Date();
	
	var flagPromoGD3x5 = false;
	if( $("#flagPromoGD3x5").val() != undefined ){
		flagPromoGD3x5 = JSON.parse($("#flagPromoGD3x5").val());
	}
	
	if( loginUsuario()  && flagPopupAvionPeru &&  (verifyPathNames(['home.html','show_menu.html','show_home.html','tav2.html'])) ){
		if( ( !flagPromoGD3x5 || !verifyPathNames(['game_ganadiario_show_menu.html']) ) &&  !verifyPathNames(['game_kabala_show_menu.html']) ){
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(activarPopupAvionPeru , timeUp) ;
		}
	}
	
	if( ( loginUsuarioOk() ) && flagPopupAvionPeru && ( verifyPathNames(['/home.html','redirect.html']) ) ){ //esta activo pop up Peru
		
		$.ajax({
	        type: "POST",
	        url: "avion-del-hincha-te-lleva-eliminatorias-peru-verificar-promocion.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
				if( data.flagPromo ){//participa en la promocion Peru
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 1000;
					setTimeout(activarPopupAvionPeruNivel , timeUp) ;
				}else{
					try { validarPromosActivarEvalPopupInformativo('popup-avionPeru-nivel'); } catch (e) {}
				}
	        }
	    });							   				
	}else{
		try { validarPromosActivarEvalPopupInformativo('popup-avionPeru-nivel'); } catch (e) {}
	}

}); 



