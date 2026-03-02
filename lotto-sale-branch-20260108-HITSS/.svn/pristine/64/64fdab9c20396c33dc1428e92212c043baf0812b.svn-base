var msjverif = "";
var loginForm = undefined;
var smsMessage = "";
var isDataComplete ;
var exe = {
    opentyc: function () {
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
    	dhtmlwindow.open('resultboxtyc', 'inline', '<span class="tyc-span-text"><p class="tyc-p-text">Estimado cliente, hemos actualizado los t&eacute;rminos y condiciones de nuestra tienda virtual, por lo tanto le invitamos a informarse y aceptar el contenido de los mismos para que pueda continuar usando su cuenta de La Tinka.</p><br/><a href="#" id="lnkagreement" class="tyc-a-text">Ver t&eacute;rminos y condiciones</a><br/><br/><input type="checkbox" value="1" id="chkagreement" class="tyc-checkbox" checked /><label for="chkagreement" class="tyc-label-text">Acepto los t&eacute;rminos y condiciones.</label><input type="button" id="btnagreement" value="" class="tyc-button-text"  /></span>', '', 'width=420,height=180,center=1,resize=0', 'recal');
        $(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").css("display","block");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "try {console.log('cerrarDhtmlwindow');var responseMessage = 'cerrarMensaje|OK';	window.parent.postMessage(responseMessage,'*');	}catch(err) {console.log(err.message);}location.reload();return false;");//
    },
    openeml: function (msj) {
    	if(msj!=null) msjverif = msj;
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
    	dhtmlwindow.open('resultboxeml', 'inline', '<span class="eml-span-text"><p class="eml-p-text">'+msjverif+'</p><input type="text" name="cnfemail" id="cnfemail" class="eml-text-in" placeholder="Ingresa tu correo" required /><input type="button" id="btnmverified" value="" class="eml-button-text"  /></span>', '', 'width=420,height=180,scrolling=1,center=1,resize=0', 'recal');
        $(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "try {console.log('cerrarDhtmlwindow');var responseMessage = 'cerrarMensaje|OK';	window.parent.postMessage(responseMessage,'*');	}catch(err) {console.log(err.message);}location.reload();return false;");
    },
  
    openphn: function (msj, phone) {
    	if(msj!=null) msjverif = msj;
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
        var sendCodeHide = "";
        var sendSmsHide = "class='hide'";
        if (phone=='' || phone==null ) {
              var sendCodeHide = "class='hide'";
              var sendSmsHide = "";
        }
    	dhtmlwindow.open('resultboxphn', 'inline', '<span id="openphn" class="phn-span-text"><p class="phn-p-text">'+msjverif+'</p><div id="sendSms" '+sendSmsHide+'><input type="text" name="cnfphone" id="cnfphone" class="phn-text-in" placeholder="Ingresa tu celular" required '+((phone!=null && $.trim(phone)!='')?'value="'+$.trim(phone):' ')+'"/><input type="button" id="btnSendSmsValidation" value="ENVIAR SMS" class="btn btn-orange white phn-button-text" /><br/><input type="button" id="lnkActiveCode" value="YA TENGO CÓDIGO DE ACTIVACIÓN" class="btn btn-orange white phn-button-text" /></div><div id="sendCode" '+sendCodeHide+'><input type="text" name="cnfsmscode" id="cnfsmscode" class="phn-text-in" placeholder="Digita el c&oacute;digo" required /><input type="button" id="btnSendCodeValidation" value="CONFIRMAR" class="btn btn-orange white phn-button-text" /><br/><input type="button" id="lnkSendSms" value="ENVIAR CÓDIGO NUEVAMENTE" class="btn btn-orange white phn-button-text" /></div></span>', '', 'width=420,height=220,scrolling=0,center=1,resize=0', 'recal');
    	$(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "try {console.log('cerrarDhtmlwindow');var responseMessage = 'cerrarMensaje|OK';	window.parent.postMessage(responseMessage,'*');	}catch(err) {console.log(err.message);}location.reload();return false;");
    },
    
};

var $index = function () {	
	if ( window.addEventListener ) {
	    window.addEventListener('message', handleMessage, false);
	} else if ( window.attachEvent ) {
	    window.attachEvent('onmessage', handleMessage);
	}
		
	function handleMessage(e) {
		var arrayData = e.data.split("|");
		if(arrayData[0]==='login'){
			console.log("login");
			$("#user-client").val(arrayData[1]);
			$("#password-client").val(arrayData[2]);
			//$("#index-btnlogin").trigger( "click" );
			document.getElementById("index-btnlogin").click();
		}else if(arrayData[0]==='getData'){
			console.log("getData");
			$.ajax({
	            type: "POST",
	            url: "get_data.html",
	            dataType: "json",
	            async: false,
	            success: function (data) {
	            	if(data.status==="OK"){
	            		try {
	            			var chatbot_visible = "FALSE";
	            			var chatbot_url = "";
	            			var chatbot_url_active = "";
	            			try {
	            			     $.ajax({
	            			         type: "post",
	            			         url: "checkChatbot.html",
	            			         dataType: 'json',
	            			         async: false,
	            			         contentType: 'application/json',
	            			         success: function (e) {
	            			        	chatbot_visible = e.visible; 
	            			        	chatbot_url = e.src;
	            			        	chatbot_url_active = e.urls;
	            			         },
	            			         error: function () {
	            			         	jAlert('Ocurri&oacute; un problema inesperado al cargar el chatbot');
	            			         }
	            			     });
							} catch (err) {
								console.log(err.message);
							}
							
		                	var responseMessage = 'getData|'+data.status+'|'+data.cid+'|'+data.name+'|'+floatFormat(data.billetera1)+'|'+data.billetera2+'|'+data.billetera3+'|'+chatbot_visible+'|'+chatbot_url+'|'+chatbot_url_active+'|'+data.isDataComplete;
		                	window.parent.postMessage(responseMessage,'*');
		            	}catch(err) {
		            		console.log(err.message);
		            	}
	            	}else{
	            		try {
		                	var responseMessage = 'getData|'+data.status;
		            		window.parent.postMessage(responseMessage,'*');
		            	}catch(err) {
		            		console.log(err.message);
		            	}
	            	}
	            }
	    	});
		}else if(arrayData[0]==='toTAV2'){
			console.log("toTAV2");
			$.ajax({
		        type: 'post',
		        url: 'tav2-session.html',
		        dataType: 'json'
			}).done(function(d) {
				if(d.message=="OK") {
					try {
	                	var responseMessage = 'toTAV2|'+d.redireccion+"?authToken="+d.authToken;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
				} else{
					try {
	                	var responseMessage = 'toTAV2|'+d.redireccion;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
				}
		    });
		}else if(arrayData[0]==='toDDVV'){
			console.log("toDDVV");
			$.ajax({
		        type: 'post',
		        url: 'ddvv-session.html',
		        dataType: 'json'
			}).done(function(d) {
				if(d.message=="OK") {
					try {
	                	var responseMessage = 'toDDVV|'+d.redireccion+"?authToken="+d.authToken;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
				} else {
					try {
	                	var responseMessage = 'toDDVV|'+d.redireccion;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
				}
		    });
		}else if(arrayData[0]==='salir'){
			console.log("salir");
			$.ajax({
		        type: 'get',
		        url: 'salir_qw4.html',
			}).done(function() {
				try {
                	var responseMessage = 'salir|OK';
            		window.parent.postMessage(responseMessage,'*');
            	}catch(err) {
            		console.log(err.message);
            	}
		    });
		}else if(arrayData[0]==='dataSession'){
			console.log("dataSession");
			$.ajax({
	            type: "POST",
	            url: "data_session.html",
	            dataType: "json",
	            async: false,
	            success: function (data) {
	            	try {
	                	var responseMessage = 'dataSession|'+data.status;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
	            }
	    	});
		}else if(arrayData[0]==='openTerminosCondiciones'){
			console.log("openTerminosCondiciones");
			dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones.html', 'TÉRMINOS Y CONDICIONES', 'width=606,height=460,scrolling=1,center=1,resize=0', 'recal');
	    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "try {console.log('cerrarDhtmlwindow');var responseMessage = 'cerrarMensaje|OK';	window.parent.postMessage(responseMessage,'*');	}catch(err) {console.log(err.message);}location.reload();return false;");
		}
		
	}
	
    var $userInfo = $('#main-user');
    $('#back_previous').hide();
    if($("#clientId").val() != '' && $("#agreement").val() == '') {
    	$userInfo.children(".logout").hide();
        $userInfo.children(".unlogout").show();
    	exe.opentyc();
    } else if($("#clientId").val() == '') {
    	$userInfo.children(".logout").hide();
        $userInfo.children(".unlogout").show();
    } else {
        $userInfo.children(".logout").show();
        $userInfo.children(".unlogout").hide();
    }
	
    $('#frmLoginClientIndex').attr('id', 'frmLogin').attr('action', 'common_login.html').attr('data-response-type','json');
    $("#frmLogin").on("submit", function (event) {
        event.preventDefault();
        try {
    		$('button').prop('disabled', true);	
	        loginForm = $(this);
	        login(loginForm);
	        $('button').prop('disabled', false);
        } catch (e) {
			$('button').prop('disabled', false);
			console.log(e.message);
		}
    });
    
    $("#frmLoginDT").on("submit", function (event) {
    	event.preventDefault();
        try {
        		$('button').prop('disabled', true);	
    	        loginForm = $(this);
    	        closePopup('popup-message-dt');
    	        login(loginForm);
    	        $('button').prop('disabled', false);
        } catch (e) {
    		$('button').prop('disabled', false);
    		console.log(e.message);
    	}
    });
    
    function login(form, seccion, cargarSaldoTA){
    	var valida_session = "";
    	let frm = ((form!=undefined)?form.attr('id'):'frmLogin');
    	if(frm=='frmLogin') $('#game-code-header').val(1);
    	let url = form!=undefined?form.attr('action'):'common_login.html';
    	let type = form!=undefined?form.attr('method'):'post';
    	let data = form!=undefined?form.serialize():'';
    	let dataType = form!=undefined?form.attr('data-response-type'):'';
    	var paramSeccion = "";
    	var paramCargarSaldoTA = "";
    	if(seccion!=undefined && seccion!=null && seccion!=''){
    		paramSeccion = "&seccion=saldo";
    	}
    	
    	if(cargarSaldoTA!=undefined && cargarSaldoTA!=null && cargarSaldoTA!=''){
    		paramCargarSaldoTA = cargarSaldoTA;
    	}
    	
    	
        $.ajax({ 
            type: type, 
            url: url, 
            dataType: dataType, 
            data: data+"&user-client="+$("#user-client").val()+"&password-client="+$("#password-client").val()+"&user-browser="+navigator.appVersion+paramSeccion,
            async:false,
            success: function (e) {
            if(e.lapolla!=null && $.trim(e.lapolla)!="" && (seccion==undefined || seccion==null) ) {
        		cadena = e.lapolla.split("|");
        		window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1])+paramCargarSaldoTA,"_parent");
        	} else if(e.tav2!=null && $.trim(e.tav2)!="" && (seccion==undefined || seccion==null) ) {
            	cadena = e.tav2.split("|");
            	window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1])+paramCargarSaldoTA,"_parent");
        	} else {
        		var message = e.message;
	            valida_session = e.state;
	            if (valida_session === 'OK') {
	                var username = e.name;
	                var useramount = e.amount;
	                var userid = e.idclient;
	                var billetera2 = e.billetera2;
	                var billetera3Cant = e.billetera3Cant;
	                var isDataComplete = e.isDataComplete;
	                //var costo_juego = parseFloat(e.gameAmount);
	                //var costo_otro = parseFloat(e.otherAmount);
	                try {
	                	
	                	var chatbot_visible = "FALSE";
            			var chatbot_url = "";
            			var chatbot_url_active = "";
            			try {
            			     $.ajax({
            			         type: "post",
            			         url: "checkChatbot.html",
            			         dataType: 'json',
            			         async: false,
            			         contentType: 'application/json',
            			         success: function (e) {
            			        	chatbot_visible = e.visible; 
            			        	chatbot_url = e.src;
            			        	chatbot_url_active = e.urls;
            			         },
            			         error: function () {
            			         	jAlert('Ocurri&oacute; un problema inesperado al cargar el chatbot');
            			         }
            			     });
						} catch (err) {
							console.log(err.message);
						}
	                	
	                	var responseMessage = 'login|'+valida_session+'|'+userid+'|'+username+'|'+floatFormat(useramount)+'|'+floatFormat(billetera2)+'|'+billetera3Cant+'|'+chatbot_visible+'|'+chatbot_url+'|'+chatbot_url_active+'|'+isDataComplete;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}  
	            } else if (valida_session === 'TC'){
	            	exe.opentyc();
	            	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}  
	            } else if (valida_session === 'MV'){
	            	exe.openeml(message);
	            	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}  
	            } else if (valida_session === 'AC'){
	            	/*
	            	exe.openphn(message, e.phone);
	            	onlynumber();
	            	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}  */
	            	
	            	window.location.href = e.redirectActivate;
	            	
	            } else if(e.button=='120'){
            		var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error" onclick="goRegister()" type="button">Reg&iacute;strate</button></div>';
                    $('#close-popup-message').show();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	} else if(e.button=='122' || e.button=='146'){
            		var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error" onclick="goRecoverPassword()" type="button">&iquest;Olvidaste tu contrase&ntilde;a?</button></div>';
                    $('#close-popup-message').show();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
//                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	} else if(e.button=='123'){
            		var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div></div><br><br>'+
                    '<button class="btn btn-login-error"  type="button" onclick="closePopup(this)">Aceptar</button></div>';
                    $('#close-popup-message').hide();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	} else if(e.button=='124'){
            		var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error"  type="button" onclick="closePopup(this)">Aceptar</button></div>';
                    $('#close-popup-message').hide();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	} else if(e.button=='125'){
            		var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error" onclick="goRegister()" type="button">Reg&iacute;strate</button></div>';
                    $('#close-popup-message').show();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	}else if(e.button=='127'){
            		$("#titulo-dt").text(e.title);
            		$("#lrdn").val(e.lrdn);
            		$('#lg-document-type option[value="DNI"]').prop('selected', true);
                    $('#msg-message-dt').html(msgError);
                	openModal("#popup-message-dt","");
//                	if(frm==='frmLogin'){
//                		redirectdt=true;
//                	}
//                	if(frm==='frmLoginDT'){
//                		redirectdt=false;
//                	}
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	}else if(e.button=='132'){
            		var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error" onclick="goArcoRights()" type="button">Ir a Derechos Arco</button></div>';
                    $('#close-popup-message').show();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	}else if(e.button=='133'){
            		var titulo = e.title;
            		var mensaje = e.message;
            		var msgError = '<div><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+message+'</span><br><br><br>'+
                    '<button class="button button-orange-light no-margin green" onclick="goRecoverPassword();" type="button" style="width: 50%;">Cambiar contrase&ntilde;a</button></div>';
                    $('#close-popup-message').hide();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
//                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	}else if(e.button=='147' || e.button=='148'){
            		var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error" onclick="goRecoverPassword()" type="button">&iquest;Olvidaste tu contrase&ntilde;a?</button></div>';
                    $('#close-popup-message').hide();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
//                	$('#user-client-header').focus();
                	try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}
            	} else {
//	                jAlert(message, null, function(r){if(r){ 
//	                	try {
//    	                	var responseMessage = 'cerrarMensaje|OK';
//    	            		window.parent.postMessage(responseMessage,'*');
//    	            	}catch(err) {
//    	            		console.log(err.message);
//    	            	}  
//	                }});
	                var titulo = e.title;
            		var mensaje = e.message;
                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                    '<button class="btn btn-login-error"  type="button" onclick="closePopup(this)">Aceptar</button></div>';
                    $('#close-popup-message').hide();
                    $('#msg-message').html(msgError);
                	openModal("#popup-message","");
					$('#user-client-header').focus();
	                try {
	                	var responseMessage = 'login|'+valida_session;
	            		window.parent.postMessage(responseMessage,'*');
	            	}catch(err) {
	            		console.log(err.message);
	            	}  
	            }
        	}
        }});
    }
    
    function onlynumber(){
    	$(document).on("keypress", "#cnfphone, #cnfsmscode", function(event) {
            if(event.which != 8 && event.which != 0 && (event.which < 48 || event.which > 57)) return false;            
    	});
    	
    	$(document).on("keypress", "#cnfphone", function(event) {
            if(event.which != 8 && event.which != 0 && (event.which < 48 || event.which > 57)) return false;
            if( $('#cnfphone').val().length >= 9 ) return false;
    	});
    }
    
    $(document).on("click", "#btnSendCodeValidation", function (event) {
    	event.preventDefault();
    	var code = $.trim($("#cnfsmscode").val());
        	$.ajax({
        		type: "post",
                url: "send-code-validation.html",
                data: "sms-code=" + code,
                dataType: "jsonp",
                async:false,
                beforeSend: function () {
                	$("#resultboxphn").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>');
                },
                success: function (e) {
                	$("#resultboxphn").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
	                	top.dhtmlwindow.close(top.document.getElementById("resultboxphn"));
	                	jAlert(e.message,null,function(){login(loginForm);});
                	} else if(e.status===2) {
                		jAlert(e.message,null,function(){viewSmsSend();});
                	} else jAlert(e.message);
                	
                	$("#popup_container").css({
                        zIndex: 3000000000
                    });
                }, 
            });
        	$("#resultboxphn").find('#dhtmlwindowloader').remove();
        	
    });
    
    $(document).on("click", "#lnkSendSms", function (event) {
        event.preventDefault();
        viewSmsSend();
    });
    
    $(document).on("click", "#btnSendSmsValidation", function (event) {
    	event.preventDefault();
    	smsMessage = "Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.";
    	var phone = $.trim($("#cnfphone").val());
    	var phonePattern = new RegExp(/^([9]{1})([0-9]{8})$/);
        var phoneRes = phonePattern.test(phone);
        if(phoneRes){
        	$.ajax({
        		type: "post",
                url: "send-sms-validation.html",
                data: "phone-client=" + phone,
                dataType: "jsonp",
                async:false,
                beforeSend: function () {
                	$("#resultboxphn").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>');
                },
                success: function (e) {
                	$("#resultboxphn").find('#dhtmlwindowloader').remove();
                	if(e.status===200) {
                		viewSmsCode();
                	}
                	jAlert(e.message);
                }, 
            });
        } else {
        	$("#resultboxphn").find('#dhtmlwindowloader').remove();
        	jAlert("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.", null);
        }
        
        $("#popup_container").css({
            zIndex: 3000000000
        });
    });
    
    $(document).on("click", "#lnkActiveCode", function (event) {
        event.preventDefault();
        smsMessage = "Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.";
        viewSmsCode();
    });
    
    $(document).on("click", "#btnmverified", function (event) {
    	event.preventDefault();
    	var email = $("#cnfemail").val();
    	var emailPattern = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
        var emailRes = emailPattern.test(email);
        if(emailRes){
        	$.ajax({
        		type: "post",
                url: "update-mail.html",
                data: "email-client-um=" + email,
                dataType: "jsonp",
                async:false,
                beforeSend: function () {
                	$("#resultboxeml").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>');
                },
                success: function (e) {
                	$("#resultboxeml").find('#dhtmlwindowloader').remove();
                	if(e.status=='OK') {
            			top.dhtmlwindow.close(top.document.getElementById("resultboxeml"));
                		login(loginForm);
                	} else jAlert(e.message);
                }, 
            });
        } else {
        	$("#resultboxeml").find('#dhtmlwindowloader').remove();
        	jAlert("El correo electr&oacute;nico es incorrecto. Verifique si lo escribi&oacute; correctamente.", null);
        }
    });
    
    $(document).on("click", "#btnagreement", function (event) {
        event.preventDefault();
        var agreement = $("#chkagreement").is(":checked");
        if(agreement){
        	$.ajax({
                type: "post",
                url: "confirma-tyc.html",
                data: "agreement=" + agreement,
                dataType: "jsonp",
                async: false,
                success: function (e) {
                	if(e.message=='OK') {
            			top.dhtmlwindow.close(top.document.getElementById("resultboxtyc"));
                		login(loginForm);
                	} else jAlert("Por favor infórmese y confirme la aceptación de los Términos y Condiciones.", null);
                }
            });
        } else jAlert("Por favor infórmese y confirme la aceptación de los Términos y Condiciones.", null);
    });
    
    function viewSmsSend(){
    	smsMessage=$("#detailMessage").html();
    	$("#detailMessage").html("Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.<br/><br/>Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.");
        $("#sendCode").addClass('hide');
		$("#sendSms").removeClass('hide');
    }
    
    function viewSmsCode(){
    	$("#detailMessage").html(smsMessage);
		$("#sendSms").addClass('hide');
		$("#sendCode").removeClass('hide');
		$("#cnfsmscode").val("");
    }
    
    function loadRecharge(){
    	$.ajax({
            type: "POST",
            url: "load_recharge.html",
            dataType: "json",
            async: false,
            success: function (data) {
            	$("#clientSale-amount").text(floatFormat(data.billetera1));
            	$("#billetera2-amount").text(data.billetera2);
            	$("#billetera3-amount").text(data.billetera3Cant);
            }
    	});
    }
    
};$($index);
