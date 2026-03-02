var idsession = $("#clientId").val();

var expDays = 1; 

var promoAvionPeru="avionPeru";

var popupAvionPeruInfo = "popup-avionPeru"; 

var popupAvionPeruNivel = "popup-avionPeru-nivel"; 

var flagPopupAvionPeru ;

var URL_HOME_PROMO = "avion-del-hincha-te-lleva-eliminatorias-peru";

var URL_RESULTADOS = URL_HOME_PROMO + "-resultados.html";

var URL_TYC = URL_HOME_PROMO + "-como-participar.html";

var URL_REGISTRAR =URL_HOME_PROMO + "-registrar.html";

var URL_FECHAS_POPUP = URL_HOME_PROMO + "-fechas-popup.html";

var URL_RESULTADOS_POPUP = URL_HOME_PROMO + "-resultados-popup.html";

var URL_VERIFICAR_PROMOCION = URL_HOME_PROMO + "-verificar-promocion.html";

function eventAvionPeru(){
	$(".btnEnlaceTeApuesto").click(function(){
		 toTAV2();
	});
	 
	$("#btnAvionPeruResultados").click(function(){
		if(idsession == ''){
	    	 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
	    }else{
	    	 window.location.href = URL_RESULTADOS;
	    }
	});
	 
	$("#avionPeru-retroceder").click(function(){
	    window.location.href = URL_HOME_PROMO + ".html";
	});
	 
	$("#btnAvionPeruComoParticipar").click(function(){	 
	   window.location.href = URL_TYC;   
	});
	 
	$("#btnAvionPeruRegistrar").click(function(){
		if(idsession == ''){
			 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
		}else{
			 window.location.href = URL_REGISTRAR;
		}
	});
	 
	//COPA CASA REGISTRO TICKET
	$(document).delegate('#btn_desktop_registra_ticket', 'click', function () {
	    window.open('https://www.programateapuesto.pe/', '_blank');
	});
	 
	$(document).delegate('#btnAvionPeruInfo', 'click', function () {
		 window.location.href = URL_HOME_PROMO + ".html";	   
	});
	
	$(document).delegate('#'+popupAvionPeruInfo+' .close-PromSorteo-ta', 'click', function () {
		$("#"+popupAvionPeruInfo).removeClass("opened");
	});
	
	$(document).delegate('#'+popupAvionPeruNivel+' .close-PromSorteo-ta', 'click', function () {
		//window.open(baseUrl+"?authToken="+authToken,"_parent");
		toJuegosVirtuales(p_producto);
	});
	
	 
}


 //VALIDAR COPA EN CASA DESDE INTERFACE COMO PARTICIPAR
 
function VerMisJugadasAvionPeru() {
	if(idsession == '' || idsession == '0'){
		 jAlert("Para ver tus jugadas con las que participarás, debes aceptar participar de la promoción e ingresar a tu cuenta.","Aviso");
	}else if(promoAvionPeru = "avionPeru"){
		 window.location.href = URL_RESULTADOS;
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

// refatorizar el tema del ecendido del popup
function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	 
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function checkCountPopupPromocion(popup) {
	
	var count = GetCookie(popup);
	console.log(' GetCookie ' + popup + " : " + count);
	if (count != null){//ya se mostro en el dia
		if(popup==popupAvionPeruNivel){//pop up post login
			try { validarPromosActivarEvalPopupInformativo(popupAvionPeruNivel); } catch (e) { }
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
//refatorizar el tema del ecendido del popup


function fechasPopupAvionPeru(){
	$.ajax({
        type: "POST",
        url: URL_FECHAS_POPUP,
        dataType: "json",
        async: false,
        success: function (data) {
        	flagPopupAvionPeru = data.flagPopup;
        }
	});
}

function activarPopupAvionPeruNivel(){

	$.ajax({
        type: "POST",
        url: URL_RESULTADOS_POPUP,
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
        	  mensajePremio = ` <p class="jugadas-popup-descripcion" style="color: #f75b1e;">¡GANASTE S/ 5 DE SALDO AL INSTANTE!</p>
        		  				<p class="jugadas-popup-descripcion2" style="color:#000000;">con tus tickets: ${ticketsWin} </p>`;
        	} else if (activarPremio == 0) {
        	  mensajePremio = `	<p class="jugadas-popup-descripcion" style="color: #f75b1e;">Tus jugadas WEB participan AUTOMÁTICAMENTE</p>
        		  				<p class="jugadas-popup-descripcion2" style="color: #000000;">¡También premia con saldo al instante!</p>`;
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
			     	<button type="button" onclick="VerMisJugadasAvionPeru()" class="button-avion-qatar-blanco" style="width:133px;margin-right: 5px;cursor:pointer;">Ver mis puntos</button>
			        <button type="button" onclick="btnTA()" class="button-avion-qatar-naranja btnEnlaceTeApuesto" style="width:163px;margin-left: 5px;margin-bottom: 7px;cursor:pointer;">Juega desde S/ 10</button>
			       	${mensajePremio}
			     </div>`;

			$("#nivel-avionPeru").html(result);
			 
			$(".btnEnlaceTeApuesto").click(function(){
				 toTAV2();
			});
			
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 1000;
			setTimeout(()=>checkCountPopupPromocion(popupAvionPeruNivel) , timeUp) ;       	
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
	
	fechasPopupAvionPeru();
	var pathname = window.location.pathname; 
	var ref = window.document.referrer;
	console.log(ref);
	
	var flagPromoGD3x5 = false;
	if( $("#flagPromoGD3x5").val() != undefined ){
		flagPromoGD3x5 = JSON.parse($("#flagPromoGD3x5").val());
	}
	
	
	if( loginUsuario()  && flagPopupAvionPeru && verifyPathNames(['/juega-','inicio.html','tav2.html'],true) ){
		if( ( !flagPromoGD3x5 || !verifyPathNames(['/juega-ganadiario.html'],false) ) && !verifyPathNames(['juega-kabala.html' , 'juega-tinka.html'],false) ){
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(()=>checkCountPopupPromocion(popupAvionPeruInfo) , timeUp) ;
		}
	}	
	
	if( loginUsuarioOk() && flagPopupAvionPeru && verifyPathNames(['mi-cuenta.html','redirect.html'],false) && 
			(ref!='http://qa.intralotportal.com.pe/' && ref!='https://latinkalotportal.com.pe/')){ //esta activo pop up Avion Peru
		$.ajax({
	        type: "POST",
	        url: URL_VERIFICAR_PROMOCION,
	        dataType: "json",
	        async: false,
	        success: function (data) {
				if( data.flagPromo ){//participa en la promocion Avion Peru
					activarPopupAvionPeruNivel();
				}else{
					try { validarPromosActivarEvalPopupInformativo(popupAvionPeruNivel); } catch (e) { }
				}
	        }
	    });
	}else{
		try { validarPromosActivarEvalPopupInformativo(popupAvionPeruNivel); } catch (e) { }
	}
	
	eventAvionPeru();
	
});
 
 
 