var baseUrl = "";
var authToken = "";
var app = {
    responseType: "jsonp",
};
var ppsts = false;
var smsMessage = "";
var run = {
setup: function () {
	var flag = false;
	$.ajax({type: "post", url: "tav2-home.html", dataType: app.responseType
    }).done(function(d) {
    	if(d.message == "OK" || d.message === 'TC') {
    		var nombre = d.user;
    		if(nombre!=null && nombre.length>0 && nombre.indexOf("__")>-1) nombre = nombre.split("__")[1];
    		
    		$(".username").text(nombre);
    		$(".amount").text("S/. "+d.balanceAmount);
    		$(".total").text("S/. "+d.prizeAmount);
    		
        	if(typeof d.prizeAmount === 'undefined' || d.prizeAmount == "0.00" || d.prizeAmount == "0" || d.prizeAmount === null) {
        		$(".change").hide();
        		$(".total").hide();
        		$(".change").text(" ");
        	} else {
        		$(".change").show();
        		$(".total").show();
        		$(".change").text("PREMIOS");
        	}
    		
    		flag = true;
    		if(d.message === 'TC') viewKept();
            else viewNext();
   
    	} else {
    		viewLogin();
    	}
    }).always(function() {

    });
}};


var $TAV2Header = function () {
	/*
	setCaptcha();
	
	$("#reload").click(function() {
		setCaptcha();
    });
	*/
	/*
	$(document).on("click", "#btnEnter", function (event) {
    	event.preventDefault();
        $("#form-sign-in").validate(function () {
            var f = $(this);
            var flag = false;
            var agree = true;
            var cadena = "";
            var mensaje = "Ocurrió un problema inesperado [12].";
            $.ajax({type: f.attr("method"), url: f.attr("action"), dataType: app.responseType, data: f.serialize(),
        		beforeSend: function () {f.lockForm(true);}
            }).done(function(d) {
            	if(d.message === "OK" || d.message === 'TC') {
            		var nombre = d.user;
            		
            		$(".username").text(nombre);
            		$(".amount").text("S/. "+d.balanceAmount);
            		
            		if(d.message === 'TC') {
            			agree = false;
            			f.lockForm(false);
            			viewKept();
            		} else {
            			flag = true;
            			f.resetForm();
            			f.lockForm(false);
            			viewNext();
            			cadena = d.iflex.split("|");
            			if($.trim(cadena[0])!="") {
                            baseUrl = $.trim(cadena[0]);
                            language = $.trim(cadena[1]);
                            operatorId = $.trim(cadena[2]);
                            currency = $.trim(cadena[3]);
                            playerId = $.trim(cadena[4]);
                            authToken = $.trim(cadena[5]);
            			} else {
                    		mensaje = "No se ha logrado ingresar";
                    	}
            		}
            	} else if(d.message === "CC") {
            		f.lockForm(false);
                	f.resetForm();
                	$("#user").focus();
                    setCaptcha(true);
                	$("#btnEnter").bubble(d.info, 10000);
                } else {
                	f.lockForm(false);
                	f.resetForm();
                	$("#btnEnter").bubble(d.message, 10000);
                }
            }).fail(function() {
            	f.lockForm(false);
            	$("#btnEnter").bubble("Ocurrió un problema inesperado. [14]", 10000);
            }).always(function() {
            	if(flag && agree) {
                	var url = baseUrl+"?playerId="+playerId+"&language="+language+"&operatorId="+operatorId+"&authToken="+authToken+"&currency="+currency;
                	window.open(url, "_parent");
                } else if(agree) {
                	$("#btnOut").bubble(mensaje, 10000);
                }
            });
        });
	});*/
	
var form = "";	

function getUrlParameter(sParam) {
	var sPageURL = window.location;
	var sURLParts = sPageURL.href.split('?');
    var sURLVariables = sURLParts[1].split('&');
    var sParameterName;
    var i;

    for (i = 0; i < sURLVariables.length; i++) {
        sParameterName = sURLVariables[i].split('=');

        if (sParameterName[0] === sParam) {
            return sParameterName[1] === undefined ? true : decodeURIComponent(sParameterName[1]);
        }
    }
    return false;
}

function login(f){
	var flag = false;
    var valid = true;
    var cadena = "";
    var mensaje = "Ocurrió un problema inesperado [12].";
    var urlRedirect5587 = getUrlParameter('urlRedirect5587'); 
	$("#urlRedirect5587").val(urlRedirect5587);
	var flagPassword="", tituloPassword="",  mensajePassword="";
    $.ajax({type: f.attr("method"), url: f.attr("action"), dataType: app.responseType, data: f.serialize(),async:false,
		beforeSend: function () {f.lockForm(true);}
    }).done(function(d) {
//    	closeModalTA();
    	if(d.error === "OK" ) {
    		datalayerLoginOk(d.idclient);
    		form = "";
    		$(".username").text(d.username);
    		$(".amount").text("S/. "+d.amount);
    		flag = true;
    		f.resetForm();
    		f.lockForm(false);
    		viewNext();
    		cadena = d.tav2.split("|");
    		if($.trim(cadena[0])!="") {
                baseUrl = $.trim(cadena[0]);
                authToken = $.trim(cadena[1]);
                
                try {
    				enviarDatosUserName(obtenerFechaActual(), recuperarUUID(), d.username);
				} catch (e) {
					
				}
			} else {
          		mensaje = "No se ha logrado ingresar";
           	}
    		
    		// contraseña expirada
    		if(d.flagPassword==='145'){
    			flagPassword=d.flagPassword;
    			tituloPassword = d.tituloPassword;
        		mensajePassword = d.mensajePassword;
    		}
    		
    		//if(d.welcomeBonusStatus!=undefined && d.welcomeBonusStatus!=null && d.welcomeBonusStatus=='Reciente'){
    		//	valid = false;
    		//	var msgtext = d.welcomeBonusMessagePor.replace("\\","").replace("\\","");
        	//	$('#popup-bond .wrap-modal').html(msgtext);
            //	openModal("#popup-bond", "");
    		//}
    		
    	} else if(d.error === "TC") {
            valid = false;
            f.lockForm(false);
            viewKept();
        } else if(d.error === "AC") {
            valid = false;
            f.lockForm(false);
            viewActiveAccount(d.phone);
            if (d.phone==null || d.phone=='') {
            	viewSmsSend();	
            }
            onlynumber();
        //} else if(d.error === "MV") {
        } else if(d.error === "MR") {
            valid = false;
            f.lockForm(false);
            viewUpdateMail();
        /*} else if(d.error === "CC") {
    		f.lockForm(false);
        	f.resetForm();
        	$("#user").focus();
            setCaptcha(true);
        	$("#btnEnter").bubble(d.message, 10000);*/
        } else if(d.error === "IB") {
            valid = false;
            f.lockForm(false);
            viewIBBonus(d.content);
        } else if(d.error === "RD") {
            valid = false;
            f.lockForm(false);
            viewRDBonus(d.content);
        } else if(d.button=='120'){
    		var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error" onclick="goRegister()" type="button">Reg&iacute;strate</button></div>';
            $('#close-popup-message').show();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);
    	} else if(d.button=='122' || d.button=='146'){
    		var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error" onclick="goRecoverPassword()" type="button">&iquest;Olvidaste tu contrase&ntilde;a?</button></div>';
            $('#close-popup-message').show();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);
    	} else if(d.button=='123'){
    		var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div></div><br><br>'+
            '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
            $('#close-popup-message').hide();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);
    	} else if(d.button=='124'){
    		var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
            $('#close-popup-message').hide();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);
    	} else if(d.button=='125'){
    		var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error" onclick="goRegister()" type="button">Reg&iacute;strate</button></div>';
            $('#close-popup-message').show();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);
    	}else if(d.button=='127'){
    		var titulo = d.title;
    		var mensaje = d.message;
    		var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br>'+
            '<form class="form-login has-validation-callback" action="tav2-login-dt.html" method="post" id="form-sign-in-dt" style="padding: 0em 0;">'+
            '<input type="hidden" value="'+d.lrdn+'" name="lrdn" id="lrdn">'+
            '<div class="form__select selected" style="margin-bottom: 25px; margin-top: 0;"><div>DNI</div>'+
            	'<label for="typeDoc" style="background-color: #f2f2f2;">Tipo de documento</label>'+
            	'<select  name="typeDoc" id="typeDoc" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento" data-validation-depending-value="CAREX">'+
            		'<option value="DNI" selected="" >DNI</option>'+
            		'<option value="PASAP" onclick="renderFormFieldsDocType();">Pasaporte</option>'+
            		'<option value="CAREX" onclick="renderFormFieldsDocType();">Carnet de Extranjer&iacute;a</option>'+
            	'</select>'+
            '</div>'+
            '<button class="btn btn-login-error"  type="submit" id="ingresar_doc_type">Aceptar</button></div></form>'+
            '<script type="text/javascript">'+
            'renderFormFieldsDocType();'+
            '</script>';
//            $('#close-popup-message-dt').show();
            $('#msg-message-dt').html(msgError);
        	openModal("#popup-message-dt","");
    	}else if(d.button=='132'){
    		var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error" onclick="goArcoRights()" type="button">Ir a Derechos Arco</button></div>';
            $('#close-popup-message').show();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);
    	}else if(d.button=='133'){
    		var titulo = d.title;
    		var mensaje = d.message;
    		var msgError = '<div><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+mensaje+'</span><br><br><br>'+
            '<button class="btn btn-recuperar-password" onclick="goRecoverPassword();" type="button">Cambiar contrase&ntilde;a</button></div>';            	
            $('#close-popup-message').hide();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	datalayerErrores('Ingresar','undefined','Login',e.message);
    	}else if(d.button=='147' || d.button=='148'){
    		var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error" onclick="goRecoverPassword()" type="button">Cambiar contrase&ntilde;a</button></div>';
            $('#close-popup-message').hide();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);
    	}else {
			var titulo = d.title;
    		var mensaje = d.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
            $('#close-popup-message').hide();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	f.lockForm(false);        
	//        else {
	//        	f.lockForm(false);
	//        	$("span#alertLogin").html(d.message);
        }
    }).fail(function() {
    	f.lockForm(false);
    	//$("#btnEnter").bubble("Ocurrió un problema inesperado. [14]", 10000);
    }).always(function() {
    	if(flagPassword === '145'){
            var msgError = '<div><div class="titulo-login-error">'+tituloPassword+'</div><br><div class="mensaje-login-error"><span>'+mensajePassword+'</span></div><br><br>'+
            '<button class="btn btn-login-error" onclick="window.location.href = \'client_edit_password.html\'" type="button">Cambiar contrase&ntilde;a</button></div>';
            $('#close-popup-message').attr('onclick', 'window.open(baseUrl+"?authToken="+authToken,"_parent")');
            
            $('#close-popup-message').show();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");				
		}else
    	if(flag && valid) {

			var flagPromoHincha = $("#flagPromoHincha").val();
			var flagPromoTinka = $("#flagPromoTinka").val();
    		// SE ORDENA CADA IF PARA ORDEN DE PRIORIDAD DE POPUP
			if(flagPopupAvionPeru && getCookieBanner('popupAvionPeru_nivel') == ""){
    			$.ajax({
    		        type: "POST",
    		        url: "avion-del-hincha-te-lleva-eliminatorias-peru-verificar-promocion.html",
    		        dataType: "json",
    		        async: false,
    		        success: function (data) {
    					if( data.flagPromo){
    						let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
    						setTimeout(activarPopupAvionPeruNivel , timeUp) ;
    					}else{
    						window.open(baseUrl+"?authToken="+authToken,"_parent");
    					}
    		        }
    		    });	
    		}
			else if(flagPopupAvionEstambul && getCookieBanner('popupAvionEstambul_nivel') == ""){
    			$.ajax({
    		        type: "POST",
    		        url: "te-apuesto-te-lleva-final-estambul-verificar-promocion.html",
    		        dataType: "json",
    		        async: false,
    		        success: function (data) {
    		        	console.log("te-apuesto-te-lleva-final-estambul-verificar-promocion.html");
    		        	console.log(data);
    					if( data.flagPromo){
    						let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
    						setTimeout(activarPopupAvionEstambulNivel , timeUp) ;
    					}else{
    						window.open(baseUrl+"?authToken="+authToken,"_parent");
    					}
    		        }
    		    });	
    		}
			else if(flagPopupJuegaGanaDDVV && getCookieBanner(popUpJuegaGanaDDVVNivel) == ""){
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
							window.open(baseUrl+"?authToken="+authToken,"_parent");
						}
			        }
			    });
			}
			else if(flagPopupAvionQatar && getCookieBanner('popupAvionQatar_nivel') == ""){
    			$.ajax({
    		        type: "POST",
    		        url: "te-apuesto-te-lleva-final-qatar-verificar-promocion.html",
    		        dataType: "json",
    		        async: false,
    		        success: function (data) {
    		        	console.log("te-apuesto-te-lleva-final-qatar-verificar-promocion.html");
    		        	console.log(data);
    					if( data.flagPromo){
    						let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
    						setTimeout(activarPopupAvionQatarNivel , timeUp) ;
    					}else{
    						window.open(baseUrl+"?authToken="+authToken,"_parent");
    					}
    		        }
    		    });	
    		}
    		//popup tinka				
    		else if(flagPromoTinka == '1'){
				//activarPopupTinka('1');
    			window.open(baseUrl+"?authToken="+authToken,"_parent");
			}							
    		else if(flagPromoHincha == '1'){
				//popup hincha
				//$(document).ready(function(){
				 /*
					$.ajax({
				        type: "POST",
				        url: "verificar_promocion_hincha.html",
				        dataType: "json",
				        async: false,
				        success: function (data) {
		
							var clienteParticipa = data.flagParticipa;
							var flagPromoHincha = data.flagPromoHincha;
							console.log('participa en la promo hincha: ' +clienteParticipa);
			
							if(clienteParticipa == false && flagPromoHincha == '1'){
								var contador = activarPopupHincha('','participa');
								if(contador > 1){
									window.open(baseUrl+"?authToken="+authToken,"_parent");
								}
							}else{
								window.open(baseUrl+"?authToken="+authToken,"_parent");
							}
							
							
				        }
				    });		
					*/
				//});
			}else{
				window.open(baseUrl+"?authToken="+authToken,"_parent");
			}	//fin popup hincha	
			/*}else{
			//fin popup tinka
	    		$.ajax({
			        type: "POST",
			        url: "verificar_promocion.html",
			        dataType: "json",
			        async: false,
			        success: function (data) {
	
					var clientepromoBicolor = data.flagPromo;
					var flagPromoBicolor = data.flagPromoBicolor;
					console.log('participa en la promo : ' +clientepromoBicolor);
	
						if(clientepromoBicolor == true && flagPromoBicolor == '1'){
							open_modal_copa();
						}else{
							window.open(baseUrl+"?authToken="+authToken,"_parent");
						}
				
			        }
			    });
			}*/	
    		//open_modal_copa();//Activar copa en tu casa DRUIZ no tocar TAV
    		//window.open(baseUrl+"?authToken="+authToken,"_parent");
        } else if(valid) {
        	//$("#btnOut").bubble(mensaje, 10000);
        	//$("span#alertLogin").html(mensaje);
        }
    });
	
}

function closeModalTA() {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
	$("#user").val("");
//	$("#user").prop('disabled', true);
	$("#password").val("");
//	$("#password").prop('disabled', true);
}

//TEAPUESTO HOME
$(document).on("click", "#btn_mobile_teapuesto_home", function (event) {	
	//window.open(baseUrl+"?authToken="+authToken,"_parent");
	toJuegosVirtuales('sport');
});

window.addEventListener("orientationchange", ()=> {
	console.log(window.screen.orientation.type);
    console.log('cambio horientazion');
    if(window.screen.orientation.type == "landscape-primary"){
    	$('#popup-scrool-copa-ta').removeClass("margen");
    	
	 }else if(window.screen.orientation.type == "portrait-primary" ){
		 $('#popup-scrool-copa-ta').addClass("margen");
	 }
});


function open_modal_copa(){
	
	$.ajax({
        type: "POST",
        url: "game_premiazoganagol_resultados_popup.html",
        dataType: "json",
        async: false,
        success: function (data) {

        	//console.log(data);
        	var totalTickets = data.nivel;
        	var puntaje = data.puntajeNivel;
        	var result = "";
        	var result2 = "";
        	var nivel="";
        	var activarPremio = data.activarPremio;
        	var listTickets= data.totalTickets;
        	var ticketsWin= data.ticketsWin;
        	console.log('el total de tickets es: '+totalTickets);
        	console.log('el nivel es: ' +puntaje);
        	
			if(totalTickets >=0 && totalTickets<=9){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Calichin_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CALICH&IacuteN</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
				'<button type="button" id="btn_mobile_ver_resultados_copabicolor" onclick="return false;"class="button-copa1">Ver mis jugadas</button>' +
				'<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-copa2">Juega desde s/ 5</button>';
				
				if(activarPremio == 1){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #ce061f;font-weight: 700;">&iexcl;GANASTE '+listTickets+' PREMIOS DE S/ 10 AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:black;">con tus tickets: '+ticketsWin+'</p></div>';
				}else if (activarPremio == 0){
					result2 = '<p class="jugadas-popup-descripcion" style="color: black;font-weight: 700;">Tus jugadas web participan autom&aacuteticamente</p><p class="jugadas-popup-descripcion2" style="color: #ce061f;font-weight: 700;">&iexcl;Adem&aacutes S/ 140,000 en saldo al instante!</p></div>';
				}
				
				result = result + result2;
				
				
			}else if(totalTickets >=10 && totalTickets<=29){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Amateur_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">AMATEUR</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
				'<button type="button" id="btn_mobile_ver_resultados_copabicolor" onclick="return false;"class="button-copa1">Ver mis jugadas</button>' +
				'<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-copa2">Juega desde s/ 5</button>';
				
				if(activarPremio == 1){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #ce061f;font-weight: 700;">&iexcl;GANASTE '+listTickets+' PREMIOS DE S/ 10 AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:black;">con tus tickets: '+ticketsWin+'</p></div>';
				}else if (activarPremio == 0){
					result2 = '<p class="jugadas-popup-descripcion" style="color: black;font-weight: 700;">Tus jugadas web participan autom&aacuteticamente</p><p class="jugadas-popup-descripcion2" style="color: #ce061f;font-weight: 700;">&iexcl;Adem&aacutes S/ 140,000 en saldo al instante!</p></div>';
				}
				
				result = result + result2;
				
				
			}else if(totalTickets >=30 && totalTickets<=59){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Crack_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CRACK</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
				'<button type="button" id="btn_mobile_ver_resultados_copabicolor" onclick="return false;"class="button-copa1">Ver mis jugadas</button>' +
				'<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-copa2">Juega desde s/ 5</button>';
				
				if(activarPremio == 1){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #ce061f;font-weight: 700;">&iexcl;GANASTE '+listTickets+' PREMIOS DE S/ 10 AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:black;">con tus tickets: '+ticketsWin+'</p></div>';
				}else if (activarPremio == 0){
					result2 = '<p class="jugadas-popup-descripcion" style="color: black;font-weight: 700;">Tus jugadas web participan autom&aacuteticamente</p><p class="jugadas-popup-descripcion2" style="color: #ce061f;font-weight: 700;">&iexcl;Adem&aacutes S/ 140,000 en saldo al instante!</p></div>';
				}
				
				result = result + result2;
				
				
			}else if(totalTickets >=60){
				result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Leyenda_popup.jpg" class="level-header-copa-casa-popup">' + 
				'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">LEYENDA</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
				'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
				'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
				'<button type="button" id="btn_mobile_ver_resultados_copabicolor" onclick="return false;"class="button-copa1">Ver mis jugadas</button>' +
				'<button type="button" id="btn_mobile_teapuesto_home" onclick="return false;"class="button-copa2">Juega desde s/ 5</button>';
				
				if(activarPremio == 1){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #ce061f;font-weight: 700;">&iexcl;GANASTE '+listTickets+' PREMIOS DE S/ 10 AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:black;">con tus tickets: '+ticketsWin+'</p></div>';
				}else if (activarPremio == 0){
					result2 = '<p class="jugadas-popup-descripcion" style="color: black;font-weight: 700;">Tus jugadas web participan autom&aacuteticamente</p><p class="jugadas-popup-descripcion2" style="color: #ce061f;font-weight: 700;">&iexcl;Adem&aacutes S/ 140,000 en saldo al instante!</p></div>';
				}
				
				result = result + result2;
				
							
			}
			
			
			$("#nivel-copa-casa").html(result);
			//if(puntaje !=0){
				checkcount_ta();
			//}else{
				//window.open(baseUrl+"?authToken="+authToken,"_parent");
			//}
			
			
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

			function amt(){
			var count_copa = GetCookie('count_copa')
			if(count_copa == null) {
			SetCookie('count_copa','1')
			return 1
			}
			else {
			var newcount = parseInt(count_copa) + 1;
			DeleteCookie('count_copa')
			SetCookie('count_copa',newcount,exp)
			return count_copa
			}
			}
			function getCookieVal(offset) {
			var endstr = document.cookie.indexOf (";", offset);
			if (endstr == -1)
			endstr = document.cookie.length;
			return unescape(document.cookie.substring(offset, endstr));
			}

			function checkcount_ta() {
			var count_copa = GetCookie('count_copa');
			if (count_copa == null) {
				var expDays = 2;
				localStorage.removeItem("exp_popup_nivel_mobile");
				var exp = new Date();
				exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
				//exp.setTime(exp.getTime() + (expDays*5*60*1000));
				count_copa=1;
				SetCookie('count_copa', count_copa, exp);
				localStorage.setItem("exp_popup_nivel_mobile", exp);
				openModal("#popup-copacasa-nivel", "");
				

			}
			else {
				count_copa++;
			var auxExp = localStorage.getItem("exp_popup_nivel_mobile");
			try{
				SetCookie('count_copa', count_copa, auxExp);
			}catch (e) {
				console.log(e.message);
				window.open(baseUrl+"?authToken="+authToken,"_parent");
			}			
			
			}
			}

						        	
        }
	});				
	
}


//JUGAR COPA EN TU CASA
$(document).delegate('#btn_mobile_ver_jugadas_copa', 'click', function () {
    window.location.href = 'game_copaentucasa_results.html';
});

//VER RESULTADOS COPA BICOLOR
$(document).delegate('#btn_mobile_ver_resultados_copabicolor', 'click', function () {
    window.location.href = 'premiazoganagol_resultados.html';
});

//VER RESULTADOS AVINON QATAR
$(document).delegate('#btnAvionQatarResultados', 'click', function () {
    window.location.href = 'te-apuesto-te-lleva-final-qatar-resultados.html';
});

//VER RESULTADOS AVINON ESTAMBUL
$(document).delegate('#btnAvionEstambulResultados', 'click', function () {
    window.location.href = 'te-apuesto-te-lleva-final-estambul-resultados.html';
});

//VER RESULTADOS AVINON PERU
$(document).delegate('#btnAvionPeruResultados', 'click', function () {
    window.location.href = 'avion-del-hincha-te-lleva-eliminatorias-peru-resultados.html';
});

$('.popup-copa-casa .js-close-modal').click(function(event){
	closeModal(1);
});

$('.popup-tinka .js-close-modal').click(function(event){
	closeModal(1);
});

$('.popup-hincha .js-close-modal').click(function(event){
	closeModal(1);
});


$('#popup-avionqatar .close-avionqatar').click(function(event){
	$("#popup-avionqatar").removeClass("opened");
});

$('#popup-avionQatar-nivel .close-avionqatar').click(function(event){
	window.open(baseUrl+"?authToken="+authToken,"_parent");
});


$('#popup-avionestambul .close-avionestambul').click(function(event){
	$("#popup-avionestambul").removeClass("opened");
});

$('#popup-avionEstambul-nivel .close-avionestambul').click(function(event){
	window.open(baseUrl+"?authToken="+authToken,"_parent");
});


$('#popup-avionPeru .close-avionPeru').click(function(event){
	$("#popup-avionPeru").removeClass("opened");
});

$('#popup-avionPeru-nivel .close-avionPeru').click(function(event){
	//window.open(baseUrl+"?authToken="+authToken,"_parent");
	toJuegosVirtuales(p_producto);
});

/*function createCORSRequest(method, url){
    var xhr = new XMLHttpRequest();
    if ("withCredentials" in xhr){
        xhr.open(method, url, true);
    } else if (typeof XDomainRequest != "undefined"){
        xhr = new XDomainRequest();
        xhr.open(method, url);
    } else {
        xhr = null;
    }
    return xhr;
}*/
	$(document).on("keypress","#password",function(e) {
	    if(e.which == 13) {
	    	$('#btnEnter').trigger('click');
	    }
	});
	
	$(document).on("click", "#btnEnter", function (event) {
    	event.preventDefault();
    	try {
        	$('button').prop('disabled', true);	
	        	
		        if ($("#user").val() == '') {
		        	$("span#alertLogin").html("Ingrese su usuario");
		            return false
		        }
		        if ($("#password").val() == '') {
		            $("span#alertLogin").html("Ingrese su clave");
		            return false
		        }
		        
		        //if ($("#sentCaptcha").val() == '') {
		          //  $("span#alertLogin").html("Ingresar c&oacute;digo");
		            //return false
		        //}
	        	
	            form = $("#form-sign-in");
	            login(form); 
	            
	        $('button').prop('disabled', false);
    	} catch (e) {
  			$('button').prop('disabled', false);
  			console.log(e.message);
  		}
	});
	
	$(document).on("click", "#ingresar_doc_type", function (event) {
    	event.preventDefault();
    	try {
        	$('button').prop('disabled', true);		        	
		        
	            form = $("#form-sign-in-dt");
	            login(form); 
	            
	        $('button').prop('disabled', false);
    	} catch (e) {
  			$('button').prop('disabled', false);
  			console.log(e.message);
  		}
	});
	
	
	$(document).on("click", "#btnOut", function (event) {
    	$.ajax({type: "post", url: "tav2-logout.html", dataType: app.responseType
        }).done(function(d) {
        	if(d.message == "OK") {
        		window.open(d.logout, "_parent");
        	}
        });
	});
	$(document).on("click", "#btnAgree", function (event) {
		event.preventDefault();
		var agreement = $("#chkagreement").prop("checked");
		if(agreement==true){
    	$.ajax({type: "post", url: "confirma-tyc.html", 
    		data: "agreement=" + agreement, 
    		dataType: app.responseType,async:false,
        }).done(function(d) {
        	if(d.message == "OK") {
        		login(form);
        	} else $("#btnAgree").bubble("Por favor infórmese y confirme la aceptación de los Términos y Condiciones.", 10000);
        });
		} else $("#btnAgree").bubble("Por favor infórmese y confirme la aceptación de los Términos y Condiciones.", 10000);
	});
	$(document).on("click", ".lnktyc", function (event) {
		var w = 606;
		var h = 460;
		var l = (screen.availWidth - w) / 2;
	    var t = 50;
	    var win = window.open("term_condiciones.html", "_blank","height="+h+",width="+w+",left="+l+",top="+t+",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,titlebar=no,toolbar=no",true);
	    win.focus();
	    return win;
	});
	
	$(document).on("click", "#btnSendSms", function (event) {
		event.preventDefault();
		var phone = $.trim($("#user-phone").val());
    	var phonePattern = new RegExp(/^([9]{1})([0-9]{8})$/);
        var phoneRes = phonePattern.test(phone);
        if(phoneRes){
        	$.ajax({type: "post", url: "send-sms-validation.html", 
        		data: "telf-sms=" + phone, dataType: "jsonp",
                async:false,
                timeout: 10000
        	 }).done(function(d) {
             	if(d.status===200) {
             		viewSmsCode();
             	} else {
             		//$("#btnEnter").bubble(d.message, 10000);
             		$("span#alertTelfVerify").html(d.message);
             	}
             }).fail(function(jqXHR, textStatus){
                 if(textStatus === 'timeout')
                 {     
                 	$("span#alertTelfVerify").html("intente nuevamente");
                 }
             });
        } else if(($.trim(phone)).split(' ')[0]==='***'){
        	$.ajax({type: "post", url: "send-sms-validation.html", 
//        		data: "telf-sms=" + phone, 
        		dataType: "jsonp",
                async:false,
                timeout: 10000
        	 }).done(function(d) {
             	if(d.status===200) {
             		viewSmsCode();
             	} else {
             		//$("#btnEnter").bubble(d.message, 10000);
             		$("span#alertTelfVerify").html(d.message);
             	}
             }).fail(function(jqXHR, textStatus){
                 if(textStatus === 'timeout')
                 {     
                 	$("span#alertTelfVerify").html("intente nuevamente");
                 }
             });
        }else {
        	 //$("#btnEnter").bubble("El teléfono celular es incorrecto. Verifique si lo escribió correctamente.", 10000);
        	$("span#alertTelfVerify").html("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.");
        }
	});
	
	$(document).on("click", "#btnCloseSms", function (event) {
        event.preventDefault();
        login(form);
    });
	
	$(document).on("click", "#btnSendCode", function (event) {
		event.preventDefault();
		var code = $.trim($("#user-code").val());
	    	$.ajax({
	    		type: "post",
	            url: "send-code-validation.html",
	            data: "send-code=" + code,
	            dataType: "jsonp",
	            async:false,
	            success: function (e) {
	            	if(e.status===1) {
	            		//login(form);
	            		$("#user-sms").html("<div id='detailMessage' class='text-center bottom-login' style='text-align:left;'>Su cuenta se encuentra correctamente activada.</div><div class='text-center bottom-login'><a href='#' id='btnCloseSms' class='button button-block button-orange'>ACEPTAR</a></div>");
	            	} else {
	            		//viewSmsSend();
	            		//$("#btnEnter").bubble(e.message, 10000);
	            		$("span#alertCodeVerify").html(e.message);
	            	}
	            }, 
	        });	
	});
	
	$(document).on("click", "#lnkActiveCode", function (event) {
        event.preventDefault();
        $("span#alertTelfVerify").html("");
        $("span#alertCodeVerify").html("");
        viewSmsCode()
    });
   
    $(document).on("click", "#lnkSendSms", function (event) {
        event.preventDefault();
        $("span#alertTelfVerify").html("");
        $("span#alertCodeVerify").html("");
        viewSmsSend()
    });
    
    function onlynumber(){
    	$(document).on("keypress", "#user-phone, #user-code", function(event) {
            if(event.which != 8 && event.which != 0 && (event.which < 48 || event.which > 57)) return false;            
    	});
    	$(document).on("keypress", "#user-phone", function(event) {
            if(event.which != 8 && event.which != 0 && (event.which < 48 || event.which > 57)) return false;
            if( $('#user-phone').val().length >= 9 ) return false;
    	});
    }
    
    function viewSmsCode(){
    	//smsMessage=$("#detailMessage").html();
    	//$("#message-text").html("Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.");
    	$("#detailMessage").html(smsMessage);
    	$('#message-sms').addClass("disabled");
    	$('#message-code').removeClass("disabled");
    	$("#user-code").val("");
    }
    function viewSmsSend(){
    	//$("#message-text").html(smsMessage);
    	smsMessage=$("#detailMessage").html();
    	//$("#detailMessage").html("Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.");
    	$("#detailMessage").html("Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.<br/><br/>Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.");
    	$('#message-code').addClass("disabled");
    	$('#message-sms').removeClass("disabled");
    	//$("#user-phone").val("");
    }
    
	$(document).on("click", "#btnUpdateMail", function (event) {
		event.preventDefault();
		var email = $("#user-new-mail").val();
		var emailPattern = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
	    var emailRes = emailPattern.test(email);
	    if(emailRes){
	    	$.ajax({
	    		type: "post",
	            url: "update-mail.html",
	            data: "email-client-um=" + email,
	            dataType: "jsonp",
	            async:false,
	            success: function (e) {
	            	if(e.status=='OK') {
	            		login(form);
	            	} else $("#btnEnter").bubble(e.message, 10000);
	            }, 
	        });
	    } else {
	    	$("#btnEnter").bubble("El correo electrónico es incorrecto. Verifique si escribió correctamente.", 10000);
	    }
	});
	
	$(document).on('change', '#user-rdbonus input#chkactivatebond, #user-rdbonus input#chkactivatewbbond', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebond" && $("#user-rdbonus input#chkactivatewbbond").length>0 && $("#user-rdbonus input#chkactivatewbbond").is(":checked")) $("#user-rdbonus input#chkactivatewbbond").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbond" && $("#user-rdbonus input#chkactivatebond").length>0 && $("#user-rdbonus input#chkactivatebond").is(":checked")) $("#user-rdbonus input#chkactivatebond").prop("checked",!chk);
    });
    $(document).on('change', '#user-ibbonus input#chkactivatebondibk, #user-ibbonus input#chkactivatewbbondibk', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebondibk" && $("#user-ibbonus input#chkactivatewbbondibk").length>0 && $("#user-ibbonus input#chkactivatewbbondibk").is(":checked")) $("#user-ibbonus input#chkactivatewbbondibk").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbondibk" && $("#user-ibbonus input#chkactivatebondibk").length>0 && $("#user-ibbonus input#chkactivatebondibk").is(":checked")) $("#user-ibbonus input#chkactivatebondibk").prop("checked",!chk);
    });
    
    $(document).on("click", "#lnkactivatewbbondrd, #lnkactivatewbbondib", function (event) {
		var w = 620;
		var h = 460;
		var l = (screen.availWidth - w) / 2;
	    var t = 50;
	    var u = $("#wbBonoTyC").val();//"https://m.intralot.com.pe/minisite/recarga-bono/"
	    var win = window.open(u, "_blank","height="+h+",width="+w+",left="+l+",top="+t+",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,titlebar=no,toolbar=no",true);
	    win.focus();
	    return win;
	});
	
	$(document).on("click", "#lnkactivatebondrd, #lnkactivatebondib", function (event) {
		var w = 620;
		var h = 460;
		var l = (screen.availWidth - w) / 2;
	    var t = 50;
	    var u = $("#iflexBonoTyC").val();//"https://m.intralot.com.pe/minisite/recarga-bono/"
	    var win = window.open(u, "_blank","height="+h+",width="+w+",left="+l+",top="+t+",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,titlebar=no,toolbar=no",true);
	    win.focus();
	    return win;
	});
	
	$(document).on("click", "#btnaceptb", function (event) {
    	event.preventDefault();
    	//if (!$("#chkactivatebond").is(":checked")) {
    	if (($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && !$("#chkactivatewbbond").is(":checked"))) && ($("#chkactivatebond").length==0 || ($("#chkactivatebond").length>0 && !$("#chkactivatebond").is(":checked")))) {
            $("div#alertVerify").html("Has clic en el check y luego activa el bono");//"&#33;Tiene que aceptar los t&eacute;rminos y condiciones!");
            return false;
        }
    	var item = $(this).data("balance");
    	var url = (($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked"))?"activate-wbpromotion.html":($("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked"))?"activate-promotion.html":"");
    	$("div#alertVerify").html("");
    	//console.log("URL="+url);
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: url,//"activate-promotion.html",
                data: "balanceItem=" + item,
                dataType: "jsonp",
                async: false,
                success: function (e) {
                	if(e.status===1) {
                		$("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                }, 
            });
        } else {
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);
        }
    });
    
	$(document).on("click", "#btncloseb", function (event) {
		event.preventDefault();
		/*var item = $(this).data("balance");
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: "cancel-promotion.html",
                data: "balanceItem=" + item,
                dataType: "jsonp",
                success: function (e) {
                	login(form);
                }, 
            });
        } else {
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);
        }*/
		login(form);
	});
	
    $(document).on("click", "#btndenyb", function (event) {
    	event.preventDefault();
    	var item = $(this).data("balance");
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: "cancel-promotion.html",
                data: "balanceItem=" + item,
                dataType: "jsonp",
                async: false,
                success: function (e) {
                	if(e.status===1) {
                		$("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                }, 
            });
        } else {
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);
        }
    });
    
    $(document).on("click", "#btnaceptbibk", function (event) {
    	event.preventDefault();
    	//if (!$("#chkactivatebondibk").is(":checked")) {
    	if (($("#chkactivatewbbondibk").length==0 || ($("#chkactivatewbbondibk").length>0 && !$("#chkactivatewbbondibk").is(":checked"))) && ($("#chkactivatebondibk").length==0 || ($("#chkactivatebondibk").length>0 && !$("#chkactivatebondibk").is(":checked")))) {
            $("div#alertVerify").html("Has clic en el check y luego activa el bono");//"&#33;Tiene que aceptar los t&eacute;rminos y condiciones!");
            return false;
        }
    	var item = $(this).data("balance");
    	var url = (($("#chkactivatewbbondibk").length>0 && $("#chkactivatewbbondibk").is(":checked"))?"activate-wbpromotionibk.html":($("#chkactivatebondibk").length>0 && $("#chkactivatebondibk").is(":checked"))?"activate-promotionibk.html":"");
    	$("div#alertVerify").html("");
    	//console.log("URL="+url);
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: url,//"activate-promotionibk.html",
                data: "balanceItem=" + item,
                dataType: "jsonp",
                async: false,
                success: function (e) {
                	if(e.status===1) {
                		$("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                }, 
            });
        } else {
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);
        }
    });
    
	$(document).on("click", "#btnclosebibk", function (event) {
		event.preventDefault();
		/*var item = $(this).data("balance");
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: "cancel-promotionibk.html",
                data: "balanceItem=" + item,
                dataType: "jsonp",
                success: function (e) {
                	login(form);
                }, 
            });
        } else {
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);
        }*/
		login(form);
	});
	
    $(document).on("click", "#btndenybibk", function (event) {
    	event.preventDefault();
    	var item = $(this).data("balance");
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: "cancel-promotionibk.html",
                data: "balanceItem=" + item,
                dataType: "jsonp",
                async: false,
                success: function (e) {
                	if(e.status===1) {
                		$("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form' style='margin-top:1.25em;'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                }, 
            });
        } else {
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);
        }
    });
    
    $(document).on("click", "#loadbalance", function (event) {
    	event.preventDefault();
    	var childWindow = window.open("client_lotocard_show_information.html?operatorId=5588","_parent");
    });
    
    $(document).on("click", "#newaccount", function (event) {
    	event.preventDefault();
    	var childWindow = window.open("client_lotocard_show_form.html?operatorId=5588","_parent");
    });
    
    $(document).on("click", "#pwdreminder", function (event) {
    	event.preventDefault();
    	//var childWindow = window.open("security_login_execute_authentication.html?operatorId=5588","_parent");
    	window.location.href = 'recuperar-contrasenia-ta.html';
    });
    
    $(document).on("click", "#usereminder", function (event) {
    	event.preventDefault();
    	window.location.href = 'recuperar-user-ta.html';
    });
    
	function viewLogin(){
		$("#user-kept").addClass("disabled");
		$("#user-logout").removeClass("disabled");
		$("#user-login").addClass("disabled");
		$("#user-sms").addClass("disabled");
		$("#user-ibbonus").addClass("disabled");
		$("#user-rdbonus").addClass("disabled");
		$("#user-mail").addClass("disabled");
	}
	function viewNext(){
		$("#user-kept").addClass("disabled");
		$("#user-logout").addClass("disabled");
		$("#user-sms").addClass("disabled");
		$("#user-mail").addClass("disabled");
		$("#user-ibbonus").addClass("disabled");
		$("#user-rdbonus").addClass("disabled");
		$("#user-login").removeClass("disabled");
	}
	function viewKept(){
		$("#user-logout").addClass("disabled");
		$("#user-login").addClass("disabled");
		$("#user-sms").addClass("disabled");
		$("#user-mail").addClass("disabled");
		$("#user-ibbonus").addClass("disabled");
		$("#user-rdbonus").addClass("disabled");
		$("#user-kept").removeClass("disabled");
	}
	function viewActiveAccount(phone){
		$("#user-kept").addClass("disabled");
		$("#user-mail").addClass("disabled");
		$("#user-logout").addClass("disabled");
		$("#user-login").addClass("disabled");
		$("#user-ibbonus").addClass("disabled");
		$("#user-rdbonus").addClass("disabled");
		$("#user-sms").removeClass("disabled");
		if(($.trim(phone)).split(' ')[0]==='***'){
			$("#user-phone").prop('type', 'text');
        	$("#user-phone").prop('disabled', true);
        	$("#user-phone").val((phone!=null && phone!='')?phone:"");
        }else{
        	$("#user-phone").prop('type', 'number');
        	$("#user-phone").val((phone!=null && phone!='')?phone:"");
        }
		
		
	}
	function viewUpdateMail(){
		$("#user-kept").addClass("disabled");
		$("#user-sms").addClass("disabled");
		$("#user-logout").addClass("disabled");
		$("#user-login").addClass("disabled");
		$("#user-ibbonus").addClass("disabled");
		$("#user-rdbonus").addClass("disabled");
		$("#user-mail").removeClass("disabled");
	}
	function viewRDBonus(m){
		$("#user-kept").addClass("disabled");
		$("#user-sms").addClass("disabled");
		$("#user-logout").addClass("disabled");
		$("#user-login").addClass("disabled");
		$("#user-mail").addClass("disabled");
		$("#user-ibbonus").addClass("disabled");
		$("#user-rdbonus").html(m);
		$("#user-rdbonus").removeClass("disabled");
	}
	function viewIBBonus(m){
		$("#user-kept").addClass("disabled");
		$("#user-sms").addClass("disabled");
		$("#user-logout").addClass("disabled");
		$("#user-login").addClass("disabled");
		$("#user-mail").addClass("disabled");
		$("#user-rdbonus").addClass("disabled");
		$("#user-ibbonus").html(m);
		$("#user-ibbonus").removeClass("disabled");
	}
	
	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		$('body').addClass('modal');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	}
	
	$('.popup .js-close-modal').click(function(event){
		closeModal(1);
	});
	
	function closeModal(state) {
		$('.overlay.opened').removeClass('opened');
		$('body').removeClass('modal');
		window.open(baseUrl+"?authToken="+authToken,"_parent");
	}
	
};$($TAV2Header);
(function ($, e) {
	$.fn.exists = function () {
		return(this.length > 0);
	};
	$.fn.lockForm = function (a) {
		this.find("input, button, select").prop("disabled", a);
		return this;
	};
	$.fn.resetForm = function () {
		this.each(function () {this.reset();});
		$(".ui-input-clear").addClass("ui-input-clear-hidden");
		return this;
	};
	$.fn.bubble = function (b, n) {
		//$("span#alertLogin").html(b);
    	alert(b);
	};
	$.fn.popup = function (a, x, y) {
		switch (a) {
		case "open":
			$("#popupInfo").show();
			ppsts = true;
			break;
		default:
			$("#popupInfo").hide();
			ppsts = false;
			break;
		}
		$("#popupInfo").css({left:x, top:y});
	};
	$.fn.validate = function (a) {
		var demon = true;
		var message = "";
		this.find("input, select").each(function () {
			if($(this).val() === "" && $(this).attr("required") !== undefined && $(this).attr("type") !== "checkbox") {
				message = "Campo requerido";
				demon = false;
			} else {
				if($(this).data("type") !== undefined) {
					if($(this).data("type") === "decimal") {
						if($(this).val()<parseFloat($("#min").val())) {
							message = "El monto debe ser mayor o igual a S/."+parseFloat($("#min").val());
	                        demon = false;
						}else if(!regExp.decimal.test($(this).val())) {
	                        message = "Escriba un monto v&aacute;lido";
	                        demon = false;
						}
					} else if($(this).data("type") === "barcode") {
						if($(this).val().length < parseFloat($(this).attr("maxlength"))){
							message = "El c&oacute;digo de barras debe estar compuesto por "+$(this).attr("maxlength")+" caracteres";
	                        demon = false;
						}
					}
				} else if($(this).attr("type") !== undefined) {
					if($(this).attr("type") === "number" && !regExp.number.test($(this).val())) {
						message = "Escriba un n&uacute;mero";
						demon = false;
					} else if($(this).attr("type") === "email" && !regExp.email.test($(this).val())) {
						message = "Email no v&aacute;lido";
						demon = false;
					} else if($(this).attr("type") === "checkbox") {
						if(!$(this).is(':checked')) {
							message = "Opci&oacute;n requerida";
							demon = false;
						}
					}
				}
			}
			if(!demon) $("span#alertLogin").html(message);//$(this).bubble(message, 10000);
			return demon;
		});
		if(demon) a.call(this);
	};
})(jQuery, undefined);

var gCount = 0;



/*
function setCaptcha(){
	try {
		$("#imagen").attr("src","captcha.html?accion=" + gCount);
		gCount = gCount + 1;
	} catch (e) {
		console.log(e.message);
	}
}
*/

function goRecoverPassword() {
    window.location.href = 'recuperar-contrasenia-ta.html';
}

/**
 * Render Tipo documento feature
 */
var renderDocumentFields = function () {
  var $select = $('#typeDoc'),
    $fields = $('.form__optional'),
    onChangeDocument;

  onChangeDocument = function () {
    var $input, isTipoDoc;

    switch ($select.val()) {
    case 'DNI':
      $input = $('#numberDoc');
      isTipoDoc = true;
      break;
    case 'PASAP':
      $input = $('#documento-pasap');
      isTipoDoc = true;
      break;
    case 'CAREX':
      $input = $('#documento-carex');
      isTipoDoc = true;
      break;
    case '':
      $input = $('#numberDoc');
      isTipoDoc = false;
      break;
    }

    $fields.hide(0);
    if (isTipoDoc) {
      $input.parent().show(0);
      $input.val('').attr('disabled', false).focus();
    } else {
      $input.parent().show(0);
      $input.val('').attr('disabled', true);
    }
  };

  $select.on('change', onChangeDocument);
};


var renderFormFields = function () {
	  // pulldown
	  $(".form__select select").each(function () {
	    var $this = $(this),
	      $pull = $this.parent();

	    if ($pull.find("div").length === 0) {
	      $pull.prepend("<div></div>");
	    }

	    if ($this.val() === "") {
	      $pull.removeClass("selected");
	    } else {
	      $pull.children("div").text($this.children(":selected").text());
	      $pull.addClass("selected");
	    }

	    $this.on('change', function () {
	      $pull.children("div").text($this.children(":selected").text());
	      if ($this.val() === "") {
	        $pull.children("div").text('');
	        $pull.removeClass("selected");
	      } else {
	        $pull.children("div").text($this.children(":selected").text());
	        $pull.addClass("selected");
	      }
	    });
	  });

	  // input
	  $(".form__input input, .form__area textarea").each(function () {
	    var $input = $(this),
	      $parent = $input.parent();

	    if ($input.val() !== '') {
	      $parent.addClass('filled');
	    }

	    $input.on('focus', function () {
	      $parent.addClass('focus filled');
	    });

	    $input.on('blur', function () {
	      if ($input.val() === '' && !$parent.hasClass('form__input-calendar')) {
	        $parent.removeClass('focus filled');
	      } else {
	        $parent.removeClass('focus');
	      }
	    });
	  });

	  // checkbox
	  $('.form__check input').on("click", function () {
	    var $this = $(this);
	    if ($this.is(":checked")) {
	      $this.parent().addClass('checked');
	    } else {
	      $this.parent().removeClass('checked');
	    }
	  }).each(function () {
	    var $this = $(this);
	    if ($this.find('input').is(":checked")) {
	      $this.addClass("checked");
	    } else {
	      $this.removeClass("checked");
	    }
	  }).each(function () {
	    var $this = $(this);
	    if ($this.is(":checked")) {
	      $this.parent().addClass("checked");
	    } else {
	      $this.parent().removeClass("checked");
	    }
	  });

	  // options
	  var $thisOption,
	    $thisInput = $('#horario');

	  $('.form__opts-list-item').on('click', function () {
	    if ($thisOption) {
	      $thisOption.removeClass('checked');
	    }
	    $thisOption = $(this);
	    $thisOption.addClass('checked');
	    $thisInput.val($thisOption.find('.icon').attr('data-value'));
	  });
	};


	$('#numberDoc').on('input', function () { 
	    this.value = this.value.replace(/[^0-9]/g,'');
	});

	var renderFormFieldsDocType = function () {
		  // pulldown
		  $(".form__select select").each(function () {
		    var $this = $(this),
		      $pull = $this.parent();

		    if ($pull.find("div").length === 0) {
		      $pull.prepend("<div></div>");
		    }

		    if ($this.val() === "") {
		      $pull.removeClass("selected");
		    } else {
		      $pull.children("div").text($this.children(":selected").text());
		      $pull.addClass("selected");
		    }

		    $("#typeDoc").on('change', function () {
		      $pull.children("div").text($this.children(":selected").text());
		      if ($this.val() === "") {
		        $pull.children("div").text('');
		        $pull.removeClass("selected");
		      } else {
		        $pull.children("div").text($this.children(":selected").text());
		        $pull.addClass("selected");
		      }
		    });
		  });
	};

	function closePopupMessageLoggin(){
		$('.overlay.opened').removeClass('opened');
		$('body').removeClass('modal');
		$("#user").val("");
		$("#password").val("");
	}
	
	function goRegister(){
		window.location.href = $('#redirect558cancel').val();
	}
	
	function goArcoRights() {
		window.location.href = 'derechos-arco.html';
	}

function closePopupMessageSecurityPass(){
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
}

function openSecurityPass(){
	var titulo = 'EVITA DIGITAR:';
	var mensaje = '- Tu nombre, celular, DNI, cumplea&ntilde;os.<br>' +
			'- Tus &uacute;ltimas 10 contrase&ntilde;as.<br>' +
			'- N&uacute;meros o letras iguales, en secuencia,<br>' +
			'&nbsp;&nbsp;inversos: "1111111111", "zzzzzzzzzz",<br>'+
			'&nbsp;&nbsp;"1234567890", "abcdefghijkl" o<br>'+
			'&nbsp;&nbsp;"lkjihgfedcba".<br>'+
			'- Caracteres en orden de teclado: "qwerty".<br>'+
			'- Nombre de los juegos de La Tinka.';
    var msgError = '<div><div class="titulo-login-error" style="font-size: 14px; text-align: left; text-decoration: underline;">'+titulo+
    '</div><br><div class="mensaje-login-error" style="font-size: 14px; text-align: left; line-height: 19px;"><span>'+mensaje+'</span></div></div><br><br>'+
    '<button class="btn btn-login-error"  type="button" onclick="closePopupMessageSecurityPass()" style="width: 70%; transform: translateX(21%);">OK</button></div>';
    $('#close-popup-message').hide();
    $('#msg-message').html(msgError);
	openModal("#popup-message","");
}

function inputPassword(){
	var inputValue = $(this).val();
	var parent = $(this).parent();
	if(inputValue.length>0){
		parent.css({
			"margin-bottom": "60px"
		});
	}else{
		parent.css({
			"margin-bottom": "35px"
		});
	}
}

function closePopupMessagePassword(){
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
}
