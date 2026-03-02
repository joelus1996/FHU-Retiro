var idsession = $("#clientId").val();
var expDays = 1; 
var promo="juegaddvv";
var popupInfo = "popup-juegaddvv"; 
var popupNivel = "popup-juegaddvv-nivel"; 
var flagPopupJuegaddvv ;
var flagRevientaTinka = $("#flagPromoTinka").val() =="true" ? true : false ;

$.ajax({type: "POST", url: "flag-popup-siosi.html",async:false, success: function (e) {
	flagRevientaTinka = e;
	flagRevientaTinka = flagRevientaTinka =="true" ? true : false ;
}})

function eventJuegaddvv(){
	$(".btnEnlaceDDVV").click(function(){
		window.location.href = 'juega-virtuales.html';
	});
	
	$(".verListaDealer").click(function(){
		window.open("https://www.latinka.com.pe/latinka/minisite/promo-virtuales/Dealers-Autorizados.pdf" , '_blank');
	});
	
	$(".verReglamentoDDVV").click(function(){
		window.open("https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-deportes-virtuales.pdf" , '_blank');
	});
	
	$("#btnJuegaddvvResultados").click(function(){
		if(idsession == ''){
	    	 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
	    }else{
	    	 window.location.href = 'juega-y-gana-con-virtuales-resultados.html';
	    }
	});
	
	$(".verMisJugadasddvv").click(function(){
		if(idsession == ''){
			jAlert("Para ver tus jugadas con las que participarás, debes aceptar participar de la promoción e ingresar a tu cuenta.","Aviso");
	    }else{
	    	 window.location.href = 'juega-y-gana-con-virtuales-resultados.html';
	    }
	});
	
	$("#juegaddvv-retroceder").click(function(){ 
	    window.location.href = 'juega-y-gana-con-virtuales.html';   
	});
	 
	$("#btnJuegaddvvComoParticipar").click(function(){	 
	   window.location.href = 'juega-y-gana-con-virtuales-como-participar.html';   
	});
	 
	$("#btnJuegaddvvRegistrar").click(function(){
		if(idsession == ''){
			 jAlert("Ingresa a tu cuenta y luego acepta participar en la promoción.","Aviso");
		}else{
			 window.location.href = 'juega-y-gana-con-virtuales-registrar.html'; // 
		}
	});
	 
	//COPA CASA REGISTRO TICKET
	$(document).delegate('#btn_desktop_registra_ticket', 'click', function () {
	    window.open('https://www.programateapuesto.pe/', '_blank');
	});
	 
	$(document).delegate('#btnJuegaddvvInfo', 'click', function () {
		 window.location.href = 'juega-y-gana-con-virtuales.html';	   
	});
	
	$(document).delegate('#popup-juegaddvv .close-PromSorteo-ta', 'click', function () {
		$("#popup-juegaddvv").removeClass("opened");
	});
	
	$(document).delegate('#popup-juegaddvv-nivel .close-PromSorteo-ta', 'click', function () {
		window.open(baseUrl+"?authToken="+authToken,"_parent");
	});
	
	 
}


 //VALIDAR COPA EN CASA DESDE INTERFACE COMO PARTICIPAR
 
function VerMisJugadas() {
	/*if(idsession == '' || idsession == '0'){
		 jAlert("Para ver tus jugadas con las que participarás, debes aceptar participar de la promoción e ingresar a tu cuenta.","Aviso");
	}else if(promo = "juegaddvv"){
		 window.location.href = 'juega-y-gana-con-virtuales-resultados.html';
	}*/
	window.location.href = 'juega-y-gana-con-virtuales-resultados.html';
}

function btnDeportesVirtuales() {
	window.location.href = 'juega-virtuales.html';
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	 
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function checkCountPopupPromocionVirtuales(popup) {
	
	var count = GetCookie(popup);
	console.log(' GetCookie ' + popup + " : " + count);
	if (count != null) {
		if(popup==popupNivel){
			try { validarPromosActivarEvalPopupInformativo(popupNivel); } catch (e) {}
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



function fechasPopupVirtuales(){
	$.ajax({
        type: "POST",
        url: "juega-y-gana-con-virtuales-fechas-popup.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	flagPopupJuegaddvv = data.flagPopup;
        }
	});
}

function activarPopupJuegaddvvNivel(){

	$.ajax({
        type: "POST",
        url: "juega-y-gana-con-virtuales-resultados-popup.html",
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
          	  mensajePremio = ` <p class="jugadas-popup-descripcion" style="color: #e16e1a; ">¡GANASTE S/ 5 DE SALDO AL INSTANTE!</p>
          		  				<p class="jugadas-popup-descripcion2" style="color:#000000;">con tus tickets: ${ticketsWin} </p>`;
          	} else if (activarPremio == 0) {
          	  mensajePremio = `	<p class="jugadas-popup-descripcion" style="color: #e16e1a;">Tus jugadas WEB participan AUTOMÁTICAMENTE</p>
          		  				<p class="jugadas-popup-descripcion2" style="color: #000000;">¡Son S/ 10,000 en saldo al instante!</p>`;
          	}
        	
        	if (totalTickets >= 0 && totalTickets <= 9) {
          	  nivel = 'CALICHÍN';
          	  imagen = 'Calichin_popup.jpg';
          	} else if (totalTickets >= 10 && totalTickets <= 49) {
          	  nivel = 'AMATEUR';
          	  imagen = 'Amateur_popup.jpg';
          	} else if (totalTickets >= 50 && totalTickets <= 99) {
          	  nivel = 'CRACK';
          	  imagen = 'Crack_popup.jpg';
          	} else if (totalTickets >= 100) {
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
			     	<button type="button" onclick="VerMisJugadas()" class="button-juegaddvv-blanco" 
			     			style="width:133px;margin-right: 5px;cursor:pointer;">
			     			Ver mis jugadas
			     	</button>
			        <button type="button" onclick="btnDeportesVirtuales()" class="button-juegaddvv-naranja btnEnlaceDDVV" 
			        		style="width:163px;margin-left: 5px;margin-bottom: 7px;cursor:pointer;">
			        		Juega desde S/ 5
			        </button>
			       	${mensajePremio}
			     </div>`;

        	$("#nivel-juegaddvv").html(result);
			
			$(".btnEnlaceDDVV").click(function(){
				window.location.href = 'juega-virtuales.html';
			});
			
			let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
			setTimeout(()=>checkCountPopupPromocionVirtuales(popupNivel) , timeUp) ;       	
        },
        error: function(Response, textStatus, errorThrown) {
        	console.log("Error en la solicitud : " + Response.status);
        }
	});
}

$(document).ready(function(){
	
	fechasPopupVirtuales();
	
	var pathname = window.location.pathname; 
	pathname += "artificio";
	var ref = window.document.referrer;
	
	if( loginUsuarioOk() && flagPopupJuegaddvv && pathname.includes("mi-cuenta.html") && 
			(ref!='http://qa.intralotportal.com.pe/' && ref!='https://latinkalotportal.com.pe/')){
		$.ajax({
	        type: "POST",
	        url: "juega-y-gana-con-virtuales-verificar-promocion.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
				if( data.flagPromo ){
					activarPopupJuegaddvvNivel();
				}else{
					try { validarPromosActivarEvalPopupInformativo(popupNivel); } catch (e) {}
				}
	        }
	    });
	}else{
		try { validarPromosActivarEvalPopupInformativo(popupNivel); } catch (e) {}
	}
	
	eventJuegaddvv();
	
});
 
 
 