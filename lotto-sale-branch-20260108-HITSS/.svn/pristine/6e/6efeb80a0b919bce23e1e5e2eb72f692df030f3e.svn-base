
// funciones generales del popup

function openPopup(popup,ctrl) {
	let flagOpacity = document.getElementsByClassName('overlay opened'); 
	if(flagOpacity.length > 0)
		$(popup).css('background','none'); 
	
	$(popup).addClass('opened');
	
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function closePopup(id) {
	let popup;
	if(typeof id == 'string')
		popup = $("#"+id);
	else
		popup = id.parentNode.parentNode;
	
	$(popup).css('transition','none');
	$(popup).css('-webkit-transition','none');
	$(popup).removeClass('opened');
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

function activar_popup(popupId,expDays){
	var flagCookie = GetCookie(popupId);
	
	if (flagCookie != null) return;
	
	let fechaHoy = new Date();
	fechaHoy.setTime(fechaHoy.getTime() + (expDays*24*60*60*1000));
	flagCookie=true;
	SetCookie(popupId, flagCookie, fechaHoy);
	openPopup("#"+popupId, "");
	
}

function verifyPathNames(patNames,indexVerify=false){
	let verifyPathNames = false;
	patNames.forEach(pathName => {
		if(window.location.pathname.includes(pathName) || (!window.location.pathname.includes('html') && indexVerify ) ){
			verifyPathNames = true;
			return;
		}
		
		if(!window.location.pathname.includes('html') && pathName=="home.html" ){
			verifyPathNames = true;
			return;
		}
			
	});
	return verifyPathNames;
}

function verifyPopupsAllowedIsOpen(codsPopupAllowed) {
	  let allCodesExist = true;

	  codsPopupAllowed.forEach(codPopupAllowed => {
	    if ( GetCookie(codPopupAllowed) === null) {
	      allCodesExist = false;
	      return;
	    }
	  });

	  return allCodesExist;
}

function verifyPopupIsOpen(codPopup) {
	  return ( GetCookie(codPopup) !== null );
}


function parsePopupInformativo(popupInformativo){
	
	popupInformativo.linksAllowed = 
		popupInformativo.linksAllowed ? popupInformativo.linksAllowed.split(",") : [];
	
	popupInformativo.codsPopupAllowed = 
		popupInformativo.codsPopupAllowed ? popupInformativo.codsPopupAllowed.split(",") : [];
	
	popupInformativo.linkStyle = JSON.parse(popupInformativo.linkStyle) ;
	
	popupInformativo.buttonStyle = JSON.parse(popupInformativo.buttonStyle) ;
	
	popupInformativo.routeImage = JSON.parse(popupInformativo.routeImage) ;
	
	return popupInformativo;
}

function generatePopupInformativo(popupInformativo){
	let styleTop = '';
	
	let divPopup = `<div id="${popupInformativo.codigoPopup}" class="overlay">
	    <div class="popup popup-standard margen">
			<a class="close-popup" onclick="closePopup(this)" style="color: #dddddd;" >&times;</a> 
			<div class="popup-img-button">
				<img class="home-popup" 
					src="${popupInformativo.routeImage.route}" 
					alt="${popupInformativo.routeImage.alt}"> `;
	
	if(popupInformativo.buttonText !== undefined && popupInformativo.buttonText !== ''){
		
		if(popupInformativo.linkText == undefined || popupInformativo.linkText == ''){
			styleTop = 'style="top: 90%;"';
		}
			
		divPopup += ` <div class="footer-button accion-1" ${styleTop}>
			<button id="btn_${popupInformativo.codigoPopup}" 
				class="button-ingresar">
				${popupInformativo.buttonText}
			</button>
		</div> `;
	}
	
	if(popupInformativo.linkText !== undefined && popupInformativo.linkText !== ''){
		divPopup += ` <div class="footer-button accion-2">
			<a id="enlace_${popupInformativo.codigoPopup}">
				${popupInformativo.linkText}
			</a>
		</div> `;
	}
	
	divPopup += ` </div> </div> </div>`;

	$("#popups-generate").append(divPopup);
	
	$("#btn_"+popupInformativo.codigoPopup).css(popupInformativo.buttonStyle);
	
	$("#enlace_"+popupInformativo.codigoPopup).css(popupInformativo.linkStyle);
	
}

function generateRedireccionesPopup(popupInformativo){
	$(document).delegate(`#enlace_${popupInformativo.codigoPopup} , #btn_${popupInformativo.codigoPopup}`, 'click', function () {
		let id = $(this).attr('id');
		closePopup(popupInformativo.codigoPopup);
		
  	if(id.includes('enlace'))
  		window.open(popupInformativo.linkRedirect, '_blank');
  	else
  		window.location.href = popupInformativo.buttonRedirect;
	});
}

function obtenerPopupsInformativos(){
	// obtenerPopupsInfo
	
	let inicioTiempo = new Date();
	
	$.ajax({
        type: "POST",
        url: "obtenerPopupsInfo.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	
        	for (let popupInformativo of data.popupsInformativo) {
        		
        		// validando fechas
            	if(!popupInformativo.members.validDateRange) continue;
        		
        		popupInformativo = popupInformativo.members;
        		
        		popupInformativo = parsePopupInformativo(popupInformativo);
            	
            	// validando enlace si pertenece el popup
            	if( !verifyPathNames( popupInformativo.linksAllowed ) ) continue;
            		
            	// validando otros popups antes de mostrar el popup
            	if( !verifyPopupsAllowedIsOpen( popupInformativo.codsPopupAllowed ) ) continue;
            	
            	//validar si el popup ya se vio
            	if( verifyPopupIsOpen(popupInformativo.codigoPopup) ) continue;
            	
            	generatePopupInformativo(popupInformativo);
            	
            	generateRedireccionesPopup(popupInformativo);
            	
        		let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
        		
        		setTimeout(() => activar_popup(popupInformativo.codigoPopup, 1 ) , timeUp) ;
        	}

        	
        }
	});
	
	let finTiempo = new Date();
	
	console.log('Tiempo transcurrido en milisegundos: ' + (finTiempo - inicioTiempo) );
	
}

// funciones por popup
function popup_tinka_3x12(){
	
	if( $("#flagPromoTinka3x12").val() == undefined || !JSON.parse($("#flagPromoTinka3x12").val()) )
		return;
	
	if(verifyPathNames(['juega-tinka.html'],true) ){
		let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
		setTimeout(() => activar_popup('popup-tinka-3x12',1) , timeUp) ;
	}
	
	
	$(document).delegate('#enlace_ingresar_tinka_3x12 , #btn_juega_tinka_3x12', 'click', function () {
		let id = $(this).attr('id');
		$.ajax({
	        type: "POST", url: "popup-tinka-3x12.html", dataType: "json", async: false,
	        data:{ source: "E", device: "desktop" },
	        success: function (data) {
	        	closePopup("popup-tinka-3x12");
	        	if(id.includes('juega'))
	        		window.location.href = "juega-tinka.html";
	        	else
	        		window.open(data.URL_QW+'/promociones/tinka-3x12soles/');
	        },
	        error: function(e){
	        	console.error(e);
	        }
		});
	});
}

//funciones por popup
function popup_gd_3x5(){
	
	if( $("#flagPromoGD3x5").val() == undefined || !JSON.parse($("#flagPromoGD3x5").val()) )
		return;
	
	if(verifyPathNames(['juega-ganadiario.html'],false) ){
		let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
		setTimeout(() => activar_popup('popup-ganadiario-3x5',1) , timeUp) ;
	}
	
	
	$(document).delegate('#enlace_ingresar_ganadiario_3x5 , #btn_juega_ganadiario_3x5', 'click', function () {
		let id = $(this).attr('id');
		closePopup("popup-ganadiario-3x5");
		if(id.includes('juega'))
    		window.location.href = "juega-ganadiario.html";
    	else
    		window.open($('#urlQw').val()+'/promociones/gana-diario-3x5soles/');
	});
}

$(document).ready(function(){
	popup_tinka_3x12();
	popup_gd_3x5();
	obtenerPopupsInformativos();
});

function openSecurityPass() {
	$("#bocadillo-security-pass").show();
}

function closeSecurityPass() {
	$("#bocadillo-security-pass").hide();
}


function validateSession(){
		$.ajax({
	        type: "POST",
	        url: "validate-session.html",
	        dataType: "json",
	        async: false
		})
		.done(function(data) {
				if(data.status=="ERROR_EXPIRATION"){
					$.ajax({
				        type: "GET",
				        url: data.urlTA,
				        async: false
					})
					.done(function(dataTA) {
						setTimeout(function(){window.location.href = "inicio.html";}, 200);
					})
					.fail(function( jqXHR, textStatus, errorThrown ) {
						setTimeout(function(){window.location.href = "inicio.html";}, 200);
				    });
					
				
				}else if(data.status=="ERROR_TOKEN"){	
					setTimeout(function(){window.location.reload()}, 200);
				}else if(data.status!="OK"){
					$.ajax({
				        type: "GET",
				        url: data.urlTA,
				        async: false
					})
					.done(function(dataTA) {
						setTimeout(function(){window.location.reload()}, 200);
					})
					.fail(function( jqXHR, textStatus, errorThrown ) {
						setTimeout(function(){window.location.reload()}, 200);
				    });
				}else{
					console.log("Respuesta validate-session.html "+data.message);
					validateSessionTimeout('window');
				}
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
	    	console.log("error validate-session.html");
	    });
	
}

function validateSessionParent(){
 		$.ajax({
 	        type: "POST",
 	        url: "validate-session.html",
 	        dataType: "json",
 	        async: false
 		})
 		.done(function(data) {
 			if(data.status=="ERROR_EXPIRATION"){
 				$.ajax({
			        type: "GET",
			        url: data.urlTA,
			        async: false
				})
				.done(function(dataTA) {
					parent.location.href = "inicio.html";
				})
				.fail(function( jqXHR, textStatus, errorThrown ) {
					parent.location.href = "inicio.html";
			    });
			}else if(data.status=="ERROR_TOKEN"){
				parent.location.reload();
			}else if(data.status!="OK"){
				$.ajax({
			        type: "GET",
			        url: data.urlTA,
			        async: false
				})
				.done(function(dataTA) {
					parent.location.reload();
				})
				.fail(function( jqXHR, textStatus, errorThrown ) {
					parent.location.reload();
			    });
			}else{
				console.log("Respuesta validate-session.html "+data.message);
				validateSessionTimeout('parent');
			}
 		})
 		.fail(function( jqXHR, textStatus, errorThrown ) {
 	    	console.log("error validate-session.html");
 	    });
 	
 }

var closingTime=1000*60*90;
let sessionTimout;
function validateSessionTimeout(sender){
	if(sender=='window'){
		clearTimeout(sessionTimout);
		sessionTimout=setTimeout(validateSession,closingTime);
	}
	if(sender=='parent'){
		clearTimeout(parent.sessionTimout);
		sessionTimout=setTimeout(validateSessionParent,closingTime);
	}
	
}

function validateSession2(){
//	setTimeout(function(){
		$.ajax({
	        type: "POST",
	        url: "validate-session2.html",
	        dataType: "json",
	        async: false
		})
		.done(function(data) {
			console.log("Respuesta validate-session2.html "+data.message);
		})
		.fail(function( jqXHR, textStatus, errorThrown ) {
	    	console.log("error validate-session2.html");
	    });
//	}, 250);
	

}
