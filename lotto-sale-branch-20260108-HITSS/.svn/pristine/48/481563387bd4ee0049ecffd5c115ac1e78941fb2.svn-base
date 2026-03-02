var activating = false;
var msjverif = "";
var loginForm = undefined;
var smsMessage = "";

var banner=false;
var banner2=true;
var banner3=true;

var flagCarrusel=true;

var exe = {
    hashCheck: function () {
        if (location.hash && location.hash === '#activar') {
            if ($("#clientId").val() == '') {
                $('#user-client-header').focus();
                activating = true;
            } else {
                window.location.href = 'registro.html#activa-tu-cuenta';
            }
        }
    },
    overwriteBalance: function () {
       $('#clientSale-amount').text(floatFormat($('#saldoUser').val()));
       $(".account-balance h4 b").text("S/ " + floatFormat($('#saldoUser').val()));
       $("#billetera2-amount").text(floatFormat($('#billetera2').val()));
       //$("#billetera3-amount").text(floatFormat($('#billetera3').val()));
       $("#billetera3-amount").text($('#billetera3Cant').val());
    },
    opentyc: function () {
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
    	dhtmlwindow.open('resultboxtyc', 'inline', '<span class="tyc-span-text"><p class="tyc-p-text">Estimado cliente, hemos actualizado los t&eacute;rminos y condiciones de nuestra tienda virtual, por lo tanto le invitamos a informarse y aceptar el contenido de los mismos para que pueda continuar usando su cuenta de La Tinka.</p><br/><a href="#" id="lnkagreement" class="tyc-a-text">Ver t&eacute;rminos y condiciones</a><br/><br/><input type="checkbox" value="1" id="chkagreement" class="tyc-checkbox" checked /><label for="chkagreement" class="tyc-label-text">Acepto los t&eacute;rminos y condiciones.</label><input type="button" id="btnagreement" value="" class="tyc-button-text"  /></span>', '', 'width=420,height=180,center=1,resize=0', 'recal');
        $(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").css("display","block");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "window.location.href = (window.location.href).substring(0,(window.location.href).lastIndexOf('/'))+'/salir.html';return false;");//
    },
    openeml: function (msj) {
    	if(msj!=null) msjverif = msj;
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
    	dhtmlwindow.open('resultboxeml', 'inline', '<span class="eml-span-text"><p class="eml-p-text">'+msjverif+'</p><input type="text" name="cnfemail" id="cnfemail" class="eml-text-in" placeholder="Ingresa tu correo" required /><input type="button" id="btnmverified" value="" class="eml-button-text"  /></span>', '', 'width=420,height=180,scrolling=1,center=1,resize=0', 'recal');
        $(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "window.location.href = (window.location.href).substring(0,(window.location.href).lastIndexOf('/'))+'/salir.html';return false;");
    },
    openrdb: function (msj) {
    	if(msj!=null) msjverif = msj;
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
    	dhtmlwindow.open('resultboxrdb', 'inline', '<span class="rdb-span-text">'+msjverif+'</span>', '', 'width=470,height=300,scrolling=1,center=1,resize=0', 'recal');
    	if($("#resultboxrdb input#chkactivatewbbond").length>0 && $("#resultboxrdb input#chkactivatebond").length>0) $("#resultboxrdb div.drag-contentarea").css({"height":"430px"});
        $(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").css("display","block");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "window.location.href = (window.location.href).substring(0,(window.location.href).lastIndexOf('/'))+'/salir.html';return false;");//
    },
    openibb: function (msj) {
    	if(msj!=null) msjverif = msj;
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
    	dhtmlwindow.open('resultboxibb', 'inline', '<span class="ibb-span-text">'+msjverif+'</span>', '', 'width=470,height=300,scrolling=1,center=1,resize=0', 'recal');
    	if($("#resultboxibb input#chkactivatewbbondibk").length>0 && $("#resultboxibb input#chkactivatebondibk").length>0) $("#resultboxibb div.drag-contentarea").css({"height":"430px"});
        $(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").css("display","block");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "window.location.href = (window.location.href).substring(0,(window.location.href).lastIndexOf('/'))+'/salir.html';return false;");//
    },
    openwcb: function (msj) {
    	if(msj!=null) msjverif = msj;
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
    	dhtmlwindow.open('resultboxwcb', 'inline', '<span class="wcb-span-text">'+msjverif+'</span>', '', 'width=470,height=430,scrolling=1,center=1,resize=0', 'recal');
    },
    openphn: function (msj, phone) {
    	/**
    	 * verificar si es registro o update
    	 */
    	if(msj!=null) msjverif = msj;
    	$("#keyboard").addClass("disabled");
    	if($("#resultbox").length>0) top.dhtmlwindow.close(top.document.getElementById("resultbox"));
        var sendCodeHide = "";
        var sendSmsHide = "class='hide'";
        if (phone=='' || phone==null ) {
              var sendCodeHide = "class='hide'";
              var sendSmsHide = "";
        }
        var phoneHide = "";
        if(($.trim(phone)).split(' ')[0]==='***'){
        	phoneHide = "disabled";
        }
    	//CCR: 06/06/2018
    	//dhtmlwindow.open('resultboxphn', 'inline', '<span id="openphn" class="eml-span-text"><p class="eml-p-text">'+msjverif+'</p><div id="sendSms" class="hide"><input type="text" name="cnfphone" id="cnfphone" class="eml-text-in" placeholder="Ingresa tu celular" required '+((phone!=null && $.trim(phone)!='')?'value="'+$.trim(phone):' ')+'"/><input type="button" id="btnSendSmsValidation" value="" class="eml-button-text"  /><br/><a href="#" id="lnkActiveCode" class="tyc-a-text">¿Cuentas con un código SMS activo?</a></div><div id="sendCode"><input type="text" name="cnfsmscode" id="cnfsmscode" class="eml-text-in" placeholder="Digita el c&oacute;digo" required /><input type="button" id="btnSendCodeValidation" value="" class="eml-button-text"  /><br/><a href="#" id="lnkSendSms" class="tyc-a-text">¿Deseas enviar el código SMS al teléfono?</a></div></span>', '', 'width=420,height=180,scrolling=1,center=1,resize=0', 'recal');
    	////dhtmlwindow.open('resultboxphn', 'inline', '<span id="openphn" class="phn-span-text"><p class="phn-p-text">'+msjverif+'</p><div id="sendSms" '+sendSmsHide+'><input type="text" name="cnfphone" id="cnfphone" class="phn-text-in" placeholder="Ingresa tu celular" required '+((phone!=null && $.trim(phone)!='')?'value="'+$.trim(phone):' ')+'"/><input type="button" id="btnSendSmsValidation" value="ENVIAR SMS" class="btn btn-orange white phn-button-text" /><br/><input type="button" id="lnkActiveCode" value="YA TENGO CÓDIGO DE ACTIVACIÓN" class="btn btn-orange white phn-button-text" /></div><div id="sendCode" '+sendCodeHide+'><input type="text" name="cnfsmscode" id="cnfsmscode" class="phn-text-in" placeholder="Digita el c&oacute;digo" required /><input type="button" id="btnSendCodeValidation" value="CONFIRMAR" class="btn btn-orange white phn-button-text" /><br/><input type="button" id="lnkSendSms" value="ENVIAR CÓDIGO NUEVAMENTE" class="btn btn-orange white phn-button-text" /></div></span>', '', 'width=420,height=220,scrolling=1,center=1,resize=0', 'recal');////
    	dhtmlwindow.open('resultboxphn', 'inline', '<span id="openphn" class="phn-span-text"><p class="phn-p-text">'+msjverif+'</p><div id="sendSms" '+sendSmsHide+'><input type="text" name="cnfphone" id="cnfphone" class="phn-text-in" placeholder="Ingresa tu celular" required '+phoneHide+' '+((phone!=null && $.trim(phone)!='')?'value="'+$.trim(phone):' ')+'"/><input type="button" id="btnSendSmsValidation" value="ENVIAR SMS" class="btn btn-orange white phn-button-text" /><br/><input type="button" id="lnkActiveCode" value="YA TENGO CÓDIGO DE ACTIVACIÓN" class="btn btn-orange white phn-button-text" /></div><div id="sendCode" '+sendCodeHide+'><input type="text" name="cnfsmscode" id="cnfsmscode" class="phn-text-in" placeholder="Digita el c&oacute;digo" required /><input type="button" id="btnSendCodeValidation" value="CONFIRMAR" class="btn btn-orange white phn-button-text" /><br/><input type="button" id="lnkSendSms" value="ENVIAR CÓDIGO NUEVAMENTE" class="btn btn-orange white phn-button-text" /></div></span>', '', 'width=420,height=220,scrolling=0,center=1,resize=0', 'recal');
    	$(".drag-handle .drag-controls a#lnkregresar").css("display","none");
    	$(".drag-handle .drag-controls a#lnkcerrar").attr("onclick", "window.location.href = (window.location.href).substring(0,(window.location.href).lastIndexOf('/'))+'/salir.html';return false;");
    },
    openChat: function() {
    	window.$zopim||(function(d,s){
    		var z=$zopim=function(c){z._.push(c)},
    			$=z.s=d.createElement(s),
    			e=d.getElementsByTagName(s)[0];
    		z.set=function(o){z.set._.push(o)};
    		z._=[];
    		z.set._=[];
    		$.async=!0;
    		$.setAttribute("charset","utf-8");
    		$.src="https://v2.zopim.com/?4s59sWRL7NgI8gKw0VgOhju4zA1d6jzl";
    		z.t=+new Date;
    		$.type="text/javascript";
    		e.parentNode.insertBefore($,e);
    	})(document,"script");
    }
};
var $index = function () {
	
    var dataTicketsResult = [];
    exe.hashCheck();
    var $userInfo = $('#main-user');
    $('#back_previous').hide();
    var redirectdt=false;
            	
    if($("#clientId").val() == '') {
    	$userInfo.children(".logout").hide();
        $userInfo.children(".unlogout").show();
    } else {
        $userInfo.children(".logout").show();
        $userInfo.children(".unlogout").hide();
    }
    
	try {
		var locationHref = location.href;
		var pagina = locationHref.charAt(locationHref.length-1);
		if (location.href.split("inicio.html").length > 1 || pagina == '/') {
			$.ajax({
	            type: "POST",
	            url: "usr_sesion.html",
	            dataType: "json",
	            async: false,
	            success: function (data) {
	            	try {
	            		if(data.clientId == '') {
	            	    	$userInfo.children(".logout").hide();
	            	        $userInfo.children(".unlogout").show();
	            	    } else {
	            	        $userInfo.children(".logout").show();
	            	        $userInfo.children(".unlogout").hide();
	            	    }
	            	}catch(err) {
	            		console.log(err.message);
	            	}
	            }
	    	});
		}
	}catch(error) {
		  console.log(error);
	}
    
    $('#frmLoginClient').attr('action', 'common_login.html').attr('data-response-type','json').attr('method','post');
    $('#frmLoginClientIndex').attr('id', 'frmLogin').attr('action', 'common_login.html').attr('data-response-type','json');
    $("#frmLogin").on("submit", function (event) {
        event.preventDefault();
        try {
        	if($('#user-client-header').val().trim()!='' && $('#password-client-header').val().trim()!=''){
        		$('button').prop('disabled', true);	
    	        loginForm = $(this);
    	        login(loginForm);
    	        $('button').prop('disabled', false);
        	}
        } catch (e) {
			$('button').prop('disabled', false);
			console.log(e.message);
		}
    });
    
    $("#frmLoginDT").on("submit", function (event) {
    	event.preventDefault();
        try {
//        	if($('#user-client-header').val().trim()!='' && $('#password-client-header').val().trim()!=''){
        		$('button').prop('disabled', true);	
    	        loginForm = $(this);
    	        closeModal($("#popup-message-dt"));
    	        login(loginForm);
    	        $('button').prop('disabled', false);
//        	}
        } catch (e) {
    		$('button').prop('disabled', false);
    		console.log(e.message);
    	}
    });
    
    
    $("#user-client-header").on("keypress", function (e) {
    	var letrasynumeros = /^[a-z0-9\.\-\_]+$/i;
    	if(!(e.key).match(letrasynumeros)){
    		e.preventDefault();
    		return;
    	}
    	
    	if($("#user-client-header").val().length>34){
    		e.preventDefault();
    		let inicio = $("#user-client-header")[0].selectionStart;
    		let fin = $("#user-client-header")[0].selectionEnd;
    		if($("#user-client-header").val() === $("#user-client-header").val().substring(0, fin)){
    			if(fin!=inicio){
    				$("#user-client-header").val(e.key);
    			}
    		}
    		return;
    	}
    });
    
    $("#password-client-header").on("keypress", function (e) {
    	if($("#password-client-header").val().length>69){
    		e.preventDefault();
    		let inicio = $("#password-client-header")[0].selectionStart;
    		let fin = $("#password-client-header")[0].selectionEnd;
    		if($("#password-client-header").val() === $("#password-client-header").val().substring(0, fin)){
    			if(fin!=inicio){
    				$("#password-client-header").val(e.key);
    			}
    		}
    		return;
    	}
    });
    
    $("#frmLoginClient").on("submit", function (event) {
        event.preventDefault();
        try {
        	$('button').prop('disabled', true);	
        	$('#home-btnlogin').attr('disabled', true);
	        loginForm = $(this);
	        login(loginForm);
	        $('button').prop('disabled', false);
	        $('#home-btnlogin').attr('disabled', false);
	        getPendingNotifications();
	        getLastNotifications();
        } catch (e) {
			console.log(err.message);
			$('button').prop('disabled', false);
			$('#home-btnlogin').attr('disabled', false);	
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
    	
    	let pathName = window.location.pathname;
    	pathName = pathName.substring(pathName.lastIndexOf('/') + 1);
    	
        $.ajax({ 
            type: type, 
            url: url, 
            dataType: dataType, 
            //data: data+"&user-client="+$("#user").val()+"&password-client="+$("#password").val()+"&user-browser="+navigator.appVersion,
            data: data+"&user-client="+$("#user-client").val()+"&password-client="+$("#password-client").val()+"&user-browser="+navigator.appVersion+paramSeccion+"&pathName="+pathName,
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
	             if (valida_session === 'ERROR_VALIDACION_DATOS') {
	            	  	var titulo = "Validación de datos";
	            	    var mensaje = "Ha ocurrido un inconveniente con tu sesión, ponte en contacto con la Tinka al 5135502.";
	            	    var msgValidacion = 
	            	        '<div>' +
	            	            '<div class="titulo-login-error">' + titulo + '</div><br>' +
	            	            '<div class="mensaje-login-error"><span>' + mensaje + '</span></div><br><br>' +
	            	            '<button class="btn btn-login-error" type="button" onclick="resetPage()">Aceptar</button>' +
	            	        '</div>';
	            	    $('#close-popup-message').hide();
	            	    $('#msg-message').html(msgValidacion);
	            	    openModal("#popup-message", "");
	            	    $('#user-client-header').focus();
	            	
				} else if (valida_session === 'OK') {
	            	try {
	            		loginOk();	
	            		datalayerLoginOk(e.idclient);
	    			} catch (e) {
	    				console.error(e);
	    			}
	            	
	            	
	                var username = e.username;
	                var useramount = e.amount;
	                var userid = e.idclient;
	                var billetera2 = e.billetera2;
	                var billetera3Cant = e.billetera3Cant;
	                var costo_juego = parseFloat(e.gameAmount);
	                var costo_otro = parseFloat(e.otherAmount);
	                var cantidad_otro = parseFloat(e.otherQuantity);
	                var cantidad_juego_gratis = e.gameQuantity;
	                $("#clientId").val(userid);
	                $("#clientSale-name").text(e.name);
	                $("#clientSale-amount").text(floatFormat(useramount));
	                $("#clientSale-amount-2").text(floatFormat(useramount));
	                $(".account-balance h4 b").text("S/ " + floatFormat(useramount));
	                $("#billetera2-amount").text(floatFormat(billetera2));
	                $("#field-balance-amount").html(floatFormat(useramount));
	                $(".saldo_promocional").html("");
	                
	                $("#clientBalance").val(e.clientBalance);
	                
	                try {
        				enviarDatosUserName(obtenerFechaActual(), recuperarUUID(), username);
					} catch (e) {
						
					}
	                
	                loginForm = undefined;
	                if(seccion!=undefined && seccion!=null && seccion!=''){
	                	viewNextIndex(frm, e.wbMessage, e.wbMessagePor,seccion);
	                }else{
	                	viewNextIndex(frm, e.wbMessage, e.wbMessagePor);
	                }
	                
	                $(".result5").html("S/ "+floatFormat((!isNaN(costo_juego))?costo_juego:"0"));
	                //$(".label_resu5").html("Bonos "+e.gameName+":");
	                
	                $(".label_resu5").html("Jugadas Gratis*:");
		            $('.labelMsgJugadaGratis').html("* No es posible combinar jugadas gratis con tu saldo principal en un mismo boleto");
		            $(".result5").html(cantidad_juego_gratis);
		            
		            $('#balanceAmountGame').val(costo_juego);
		            $('#balanceQuantityGame').val(cantidad_juego_gratis);
		            if($(".result1").text() <= costo_juego){ //costototal <= monto de jugadas gratis
							 $(".result1").html("S/ 0");
							 $(".label_resu2").html("S/ 0");
								}
		            else{
		            	 $(".result1").html($(".result1").text());
						 $(".label_resu2").html($(".label_resu2").text());
		            	
		               }
								if (!isNaN(cantidad_otro))
									$("#billetera3-amount").text(billetera3Cant);

								cargarSuertudito();
					
					//Llamar a url de TA para cerrar sesion
					$.ajax({
				        type: 'post',
				        url: 'tav2-session.html',
				        dataType: 'json'
					}).done(function(d) {
						if(d.message=="OK") {
							fetch(d.redireccion+"?authToken="+d.authToken)
						    .then(response => {
						      // Manejar la respuesta
						    })
						    .catch(error => {
						      // Manejar errores
						    });
						} 
				    });
								
				} 
	            else {
	            	if (valida_session === 'TC') {
						exe.opentyc();
					} else if (valida_session === 'MV') {
									exe.openeml(message);
					} else if (valida_session === 'AC' || e.error === "AC") {
									
									//exe.openphn(message, e.phone);
									//onlynumber();
									// if(e.info!='') jAlert(e.info);
									
									window.location.href = e.redirectActivate;				
									
					} else if (valida_session === 'CC') {
									jAlert(message, null);
									$('#user-client-header').focus();
									// var gameCodeCaptcha = e.gameCodeCaptcha;
									// if(gameCodeCaptcha==0 ||
									// gameCodeCaptcha==1){
									// $('button').prop('disabled', false);
									// setCaptcha();
									// }else{
									// setCaptchaJuego();
									// }
					} else if (valida_session === 'IB') {
									// exe.openibb(message);
					} else if (valida_session === 'RD') {
									// exe.openrdb(message);
					} else if(e.button=='120'){
	            		var titulo = e.title;
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error" onclick="goRegister()" type="button">Reg&iacute;strate</button></div>';
	                    $('#close-popup-message').show();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	} else if(e.button=='122' || e.button=='146'){
	            		var titulo = e.title;
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error" onclick="goRecoverPassword()" type="button">&iquest;Olvidaste tu contrase&ntilde;a?</button></div>';
	                    $('#close-popup-message').show();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	} else if(e.button=='123'){
	            		var titulo = e.title;
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div></div><br><br>'+
	                    '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
	                    $('#close-popup-message').hide();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	} else if(e.button=='124'){
	            		var titulo = e.title;
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
	                    $('#close-popup-message').hide();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	} else if(e.button=='125'){
	            		var titulo = e.title;
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error" onclick="goRegister()" type="button">Reg&iacute;strate</button></div>';
	                    $('#close-popup-message').show();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	}else if(e.button=='127'){
	            		$("#titulo-dt").text(e.title);
	            		$("#lrdn").val(e.lrdn);
	            		$('#lg-document-type option[value="DNI"]').prop('selected', true);
//	            		var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br>'+
//	                    '<form class="form-login has-validation-callback" action="common_login_dt.html" method="post" id="frmLoginDT" style="padding: 0em 0;">'+
//	                    '<input type="hidden" value="'+e.lrdn+'" name="lrdn" id="lrdn">'+
//	                    '<div class="control-form form__select has-success">'+
//	                    	'<label for="document-type">Tipo de documento</label>'+
//	                    	'<select  name="document-type" id="document-type" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento" data-validation-depending-value="CAREX">'+
//	                    		'<option value="DNI" selected="" >DNI</option>'+
//	                    		'<option value="PASAP" >Pasaporte</option>'+
//	                    		'<option value="CAREX" >Carnet de Extranjer&iacute;a</option>'+
//	                    	'</select>'+
//	                    '</div>'+
//	                    '<button class="btn btn-login-error"  onclick="submitfrmLoginDT();" id="ingresar_doc_type">Aceptar</button></div></form>'+
//	                    '';
//	                    $('#close-popup-message-dt').show();
	                    $('#msg-message-dt').html(msgError);
	                	openModal("#popup-message-dt","");
	                	if(frm==='frmLogin'){
	                		redirectdt=true;
	                	}
	                	if(frm==='frmLoginDT'){
	                		redirectdt=false;
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
	            	}else if(e.button=='133'){
	            		var titulo = e.title;
	            		var mensaje = e.message;
//	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
//	                    '<button class="btn btn-login-error" onclick="goRecoverPassword()" type="button">Cambiar contrase&ntilde;a</button></div>';
	            		var msgError = '<div><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password" style="font-weight: 700;">'+message+'</span><br><br><br>'+
                        '<button class="btn btn-login-error" onclick="goRecoverPassword();" type="button" style="width: 100%;">Cambiar contrase&ntilde;a</button></div>';
	                    $('#close-popup-message').hide();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	}else if(e.button=='147' || e.button=='148'){
	            		var titulo = e.title;
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error" onclick="goRecoverPassword()" type="button">Cambiar contrase&ntilde;a</button></div>';
	                    $('#close-popup-message').hide();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	}else if(e.button=='149'){
	            		var titulo = e.title;	            	
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error" style="text-align: justify;"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error"  type="button" onclick="redirectMincetur(this)">Informate aqu&iacute;</button></div>';
	                    $('#close-popup-message').show();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
	                	$('#user-client-header').focus();
	            	}else {
						var titulo = e.title;
	            		var mensaje = e.message;
	                    var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                    '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
	                    $('#close-popup-message').hide();
	                    $('#msg-message').html(msgError);
	                	openModal("#popup-message","");
						$('#user-client-header').focus();
									// var gameCodeCaptcha = e.gameCodeCaptcha;
									// if(gameCodeCaptcha==0 ||
									// gameCodeCaptcha==1 ||
									// gameCodeCaptcha===undefined){
									// $('button').prop('disabled', false);
									// setCaptcha();
									// }else{
									// setCaptchaJuego();
									// }
							}
	            	try {
	            		loginError(message);				
		            		datalayerErrores('Ingresar','undefined','Login',message);
	    			} catch (e) {
	    				console.error(e);
	    			}
	    			datalayerErrores('Ingresar','undefined','Login');
					}
				}
			}
		});
    }
    
    function loginLP (form) {
    	var valida_session = "";
    	var flag = false;
        var valid = true;
        var cadena = "";
        var baseUrl = "";
        var playerId = "";
        var operatorId = "";
        var authToken = "";
        var mensaje = "Ocurrió un problema inesperado [12].";
        $.ajax({type: "post", url: "lapolla-login.html", dataType: "jsonp",
        	success: function(e){
        		var message = e.message;
                valida_session = e.state;
	        	if(valida_session === "OK" ) {
	        		flag = true;
	        		cadena = e.lapolla.split("|");
	        		if($.trim(cadena[0])!="") {
	                    baseUrl = $.trim(cadena[0]);
	                    authToken = $.trim(cadena[1]);
	    			} else {
	              		mensaje = "No se ha logrado ingresar";
	               	}
	        	} else if(valida_session === "TC") {
	        		valid = false;
	        		exe.opentyc();
	            } else if(valida_session === "AC") {
	            	valid = false;
	            	exe.openphn(message, e.phone);
	            	onlynumber();
	            } else if(valida_session === "MV") {
	            	valid = false;
	            	exe.openeml(message);
	            } else if(valida_session === 'IB') {
	            	valid = false;
	            	//exe.openibb(message);
	            } else if(valida_session === "RD") {
	            	valid = false;
	            	//exe.openrdb(message);
	            } else {
	            	jAlert(message);
	                $('#user-client-header').focus();
	            }
	        	if(flag && valid) {
	        		window.open(baseUrl+"?authToken="+authToken,"_parent");
	            } else if(valid) {
	            	jAlert(message);
	            }
        	}
        });
    }
    
    function viewNext(){
		$("#user-kept").addClass("disabled");
		$("#user-logout").addClass("disabled");
		$("#user-sms").addClass("disabled");
		$("#user-mail").addClass("disabled");
		$("#user-rdbonus").addClass("disabled");
		$("#user-ibbonus").addClass("disabled");
		$("#user-login").removeClass("disabled");
	}
    
    function loginTAN (form) {
    	var valida_session = "";
    	var flag = false;
        var valid = true;
        var cadena = "";
        var baseUrl = "";
        var playerId = "";
        var operatorId = "";
        var authToken = "";
        var mensaje = "Ocurrió un problema inesperado [12].";
        
        let type = form!=undefined?form.attr('method'):'post';
    	let data = form!=undefined?form.serialize():'';
    	let dataType = form!=undefined?form.attr('data-response-type'):'';
        
        $.ajax({
        	//type: "post", 
        	type: type, 
        	url: "tav2-login.html", 
        	dataType: "jsonp",
        	//dataType: dataType,
        	data: data+"&user-client="+$("#user").val()+"&password-client="+$("#password").val()+"&user-browser="+navigator.appVersion+"&urlRedirect5588="+$("#urlRedirect5588").val()+"&ref="+$("#ref").val(),
        	async:false,
        	success: function(e){
        		var message = e.message;
                valida_session = e.state;
	        	if(valida_session === "OK" ) {
	        		flag = true;
	        		cadena = e.tav2.split("|");
	        		if($.trim(cadena[0])!="") {
	                    baseUrl = $.trim(cadena[0]);
	                    authToken = $.trim(cadena[1]);
	    			} else {
	              		mensaje = "No se ha logrado ingresar";
	               	}
	        	} else if(valida_session === "TC") {
	        		valid = false;
	        		exe.opentyc();
	            } else if(valida_session === "AC") {
	            	valid = false;
	            	exe.openphn(message, e.phone);
	            	onlynumber();
	            } else if(valida_session === "MV") {
	            	valid = false;
	            	exe.openeml(message);
	            } else if(valida_session === 'IB') {
	            	valid = false;
	            	//exe.openibb(message);
	            } else if(valida_session === "RD") {
	            	valid = false;
	            	//exe.openrdb(message);
	            } else {
	            	jAlert(message);
	                $('#user-client-header').focus();
	            }
	        	if(flag && valid) {
	        		window.open(baseUrl+"?authToken="+authToken,"_parent");
	            } else if(valid) {
	            	jAlert(message);
	            }
        	}
        });
    }
    
    function viewNextIndex(id, wbMessage, wbMessagePor,seccion){
		$('#password-client-header').val('');
    	$('#password-client').val('');
		$(".logout").show();
        $(".unlogout").hide();
        $("#payments_section").show();
        $("#login_section").css("display", "");
        $("#panel_finaliza_compra").show();
        if(id=='frmLogin' || redirectdt){
        	
        	var URLactual = window.location.pathname;
		    //console.log(URLactual);
		    var estadoBicolor = URLactual.includes("labicolorentucasa.html");
		    
		    var estadoJuegaGanaDDVV = URLactual.includes("juega-y-gana-con-virtuales");
		    
		    let estadoAvionEstambul = URLactual.includes("te-apuesto-te-lleva-final-estambul");
		    
		    let estadoAvionPeru = URLactual.includes("avion-del-hincha-te-lleva-eliminatorias-peru");
		    	
		    if(estadoAvionEstambul || estadoAvionPeru){
		    	$(parent.location).attr('href', URLactual);
		    	
		    }else{
		    	
		    	if(seccion!=undefined && seccion!=null && seccion!=''){
	        		$(parent.location).attr('href', 'mi-cuenta.html'+seccion);
	        	}else{
	        		$(parent.location).attr('href', 'mi-cuenta.html');
	        		
	        	}
		    	
		    }
		    
		    if(estadoJuegaGanaDDVV == true){
		    	$(parent.location).attr('href', URLactual);
		    }
        	
        	
        }
        //else {
        	//$('#content-tab-item_4 .wb-saldo').html($.trim(wbMessage));
        	//$('#content-tab-item-4 .wb-saldo').html($.trim(wbMessage));
    		//if($.trim(wbMessagePor)!="") exe.openwcb($.trim(wbMessagePor));
        //}
	}
    function viewSmsCode(){
    	$("#detailMessage").html(smsMessage);
		$("#sendSms").addClass('hide');
		$("#sendCode").removeClass('hide');
		$("#cnfsmscode").val("");
    }
    function viewSmsSend(){
    	//$("#detailMessage").html(smsMessage);
    	smsMessage=$("#detailMessage").html();
    	//$("#detailMessage").html("Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.");
    	var phone=$('#cnfphone').val();
    	if($.trim(phone).split(' ')[0]==='***'){
    		$("#detailMessage").html("Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.<br/>");
    	}else{
    		$("#detailMessage").html("Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.<br/><br/>Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.");
    	}
    	
        $("#sendCode").addClass('hide');
		$("#sendSms").removeClass('hide');
		//$("#cnfphone").val("");
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
    
    $("#lnkMiCuenta").click(function() {
    	login(loginForm);
    });
    
    $("#lnkJuego").click(function() {
    	//loginTAN(loginForm);
    	var flag = false;
        var valid = true;
        var cadena = "";
        var mensaje = "Ocurrió un problema inesperado.";
        $.ajax({type: "post", url: "tav2-login.html", dataType: "jsonp", 
           	data: "user-client="+$("#user").val()+"&password-client="+$("#password").val()+"&user-browser="+navigator.appVersion+"&urlRedirect5588="+$("#urlRedirect5588").val()+"&ref="+$("#ref").val(),
        	async:false,
    		beforeSend: function () {

    		}
        }).done(function(d) {
        	if(d.state === "OK" ) {
        		form = "";
        		$(".username").text(d.username);
        		$(".amount").text("S/. "+d.amount);
        		flag = true;
        		//viewNext();
        		cadena = d.tav2.split("|");
        		if($.trim(cadena[0])!="") {
                    baseUrl = $.trim(cadena[0]);
                    authToken = $.trim(cadena[1]);
    			} else {
              		mensaje = "No se ha logrado ingresar";
               	}        		
        	} 
        }).always(function() {
        	if(flag && valid) {
        		window.open(baseUrl+"?authToken="+authToken,"_parent");
            } else if(valid) {
            	$("span#alertLogin").html(mensaje);
            }
        });
    });
    
    $("#lnkCargarSaldo").click(function() {
    	login(loginForm,"#saldo");
    });
    
    $("#lnkCargarSaldoTA").click(function() {
    	login(loginForm,null,'&cargarSaldo=true');
    });
    
    //registrar cliente
    $('#frm-user-register').on('submit', function (event) {
        var $form = $(this);
        var container = $('#wrapper-form');
        event.preventDefault();
        var isValid = true;
        
        /*
        $('.select').each(function () {
            if ($(this).val() == '') {
                $('#switch-' + $(this).attr('id')).addClass('ui-invalid-output');
                isValid = false;
            }
        });
        */
        var jform = $(this).serializeArray();
        //var email = jform[3].value.trim();
        var email = $( "#email" ).val()
        //var telefono = jform[23].value.trim();
        var telefono = $( "#mobile-phone" ).val();
        //var dni = jform[16].value.trim();
        var dni = $( "#document-number" ).val();
        var pasap = $( "#document-number-pasap" ).val();
        var carex = $( "#document-number-carex" ).val();
        var pass = $('#password-client').val();
        
        //var dnitype = jform[15].value.trim();
//        var dnitype = jform[0].value.trim();
        var dnitype=$( "#document-type option:selected").val();
        if(dnitype===undefined){
        	dnitype=$( "#idocument-type").val();
        }
        
        var emailPattern = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
        var emailRes = emailPattern.test(email);
        var telfPattern = new RegExp(/^([9]{1})([0-9]{8})$/);
        var telfRes = telfPattern.test(telefono);        
        if($("#mobile-phone1").length>0){
        	telfRes = true;
        	telefono = $( "#mobile-phone1" ).val();
        }
        var dniPattern = new RegExp(/^\d{8}$/);
        var dniRes = false;
        
        if(dnitype!='' && dnitype!=null && dnitype!=undefined){
        	dniRes = (dnitype=='DNI')?dniPattern.test(dni):true;
        }	
        
        var passPattern = new RegExp(/^(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()+=\[\]\\';,/{}|\":<>?~`.\-_¬€£¦])([A-Za-z\d!@#$%^&*()+=\[\]\\';,/{}|\":<>?~`.\-_¬€£¦ ]){8,}$/);
        var passRes = passPattern.test(pass); 
        	
        let params = new URLSearchParams(location.search);
		var channel = params.get('channel') ? params.get('channel') : '';
		var formRegister = $(this).serialize();
		if(channel !='')
			formRegister += "&channel="+channel;
        	
        if (isValid && emailRes && telfRes && dniRes && passRes) {
            $.ajax({
                url: $(this).attr('action'),
                data: formRegister,
                type: $(this).attr('method'),
                dataType: 'json',
                beforeSend: function () {
                	container.append('<div id="loader-frm-register"></div>');
                },
                error: function () {
                	container.find('#loader-frm-register').remove();
                    jAlert('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
                },
                success: function (data) {
                	container.find('#loader-frm-register').remove();
                	
                	if(data.clientid!==undefined && data.clientid !='-'  ){
                		$.ajax({
            		  		type: "post",
            		          url: "create-novus-id.html",
            		          data: "client-id=" + data.clientid,
            		          dataType: "jsonp",
            		          async:true,
            		          beforeSend: function () {
            		        	  
            		          },
            		          success: function (e) {
            		        	  
            		          }, 
            		      });
                	}
                	
                	if(data.status==5587){
                		//jAlert(data.info,null,function(r){if(r)loginLP(loginForm)});
                		
                		  	$.ajax({
                		  		type: "post",
                		          url: "send-sms-validation.html",
                		          data: "phone-client=" + telefono,
                		          dataType: "jsonp",
                		          async:false,
                		          beforeSend: function () {
                		        	  
                		          },
                		          success: function (e) {
                		        	

                		          }, 
                		      });
                		  	datalayerRegistroOk();
                		location.href = "activar.html";
                	} else if(data.status==5588){
                		//jAlert(data.info,null,function(r){if(r)loginTAN(loginForm)});
                		if(data.code===200){
                			$.ajax({
                		  		type: "post",
                		          url: "send-sms-validation.html",
                		          data: "phone-client=" + telefono,
                		          dataType: "jsonp",
                		          async:false,
                		          beforeSend: function () {
                		        	  
                		          },
                		          success: function (e) {
                		        	

                		          }, 
                		      });
                    		datalayerRegistroOk();
                    		
                    		//remover cookie btag despues de rgistrar al cliente TeApuesto
               			    deleteBtagCookie();
                    		
                    		location.href = "activar.html";
                		}
                		if(data.code===201){
                			$.ajax({
                		  		type: "post",
                		          url: "send-sms-validation.html",
                		          data: "phone-client=" + "",
                		          dataType: "jsonp",
                		          async:false,
                		          beforeSend: function () {
                		        	  
                		          },
                		          success: function (e) {
                		        	

                		          }, 
                		      });
                    		datalayerRegistroOk();
                    		location.href = "activar.html";
                		}
                		
                	} else if (data.message === 'OK') {datalayerRegistroOk();
                		jAlert(data.info,null,function(r){if(r)login(loginForm)});
                    } else if (data.message === 'REGISTRO_OK') {
                    	if(data.code===200){
                    		$.ajax({
                		  		type: "post",
                		          url: "send-sms-validation.html",
                		          data: "phone-client=" + telefono,
                		          dataType: "jsonp",
                		          async:false,
                		          beforeSend: function () {
                		        	  
                		          },
                		          success: function (e) {
                		        	

                		          }, 
                		      });
                        	datalayerRegistroOk();
                    		location.href = "activar.html";
                    	}
                    	if(data.code===201){
                    		$.ajax({
                		  		type: "post",
                		          url: "send-sms-validation.html",
                		          data: "phone-client=" + "",
                		          dataType: "jsonp",
                		          async:false,
                		          beforeSend: function () {
                		        	  
                		          },
                		          success: function (e) {
                		        	

                		          }, 
                		      });
                        	datalayerRegistroOk();
                    		location.href = "activar.html";
                    	}
                    	
                    } else {
                    	if(data.rbutton=='149'){
                    		var titulo = data.rtitle;
                    		var mensaje = data.rmessage;
                            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error" style="text-align: justify;"><span>'+mensaje+'</span></div><br><br>'+
                            '<button class="btn btn-login-error"  type="button" onclick="redirectMincetur(this)">Informate aqu&iacute;</button></div>';
                            $('#close-popup-message').show();
                            $('#msg-message').html(msgError);
                        	openModal("#popup-message","");
                        	$("#password-client").val('');
                        	$("#password-client").trigger("keyup");
                        	var parser = new DOMParser();
                        	mensaje = parser.parseFromString(mensaje, 'text/html');
                        	mensaje = mensaje.documentElement.textContent;
                    	}else{
	                    	var titulo = data.rtitle;
	                		var mensaje = data.rmessage;
	                        var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
	                        '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
	                        $('#close-popup-message').hide();
	                        $('#msg-message').html(msgError);
	                    	openModal("#popup-message","");
	                    	$("#password-client").val('');
	                    	$("#password-client").trigger("keyup");
	                    	var parser = new DOMParser();
	                    	mensaje = parser.parseFromString(mensaje, 'text/html');
	                    	mensaje = mensaje.documentElement.textContent;
                    	}    
                    	datalayerErrores('Formulario Registro','Paso 1','Registrarse',mensaje);
//                    	jAlert(
//                    			data.info,
//                    			null,
//                    			function(r){
//                    				if(r){
//                    					$('#btsubmit').attr('disabled', false);
//                    					//login(loginForm);
//                    				}
//                    			}
//                    	);
                    }
                }
            })
        } else {
        	if(!emailRes && !telfRes){
                jAlert('Ingrese un email y teléfono válidos');
            } else if (!emailRes) {
                jAlert('Ingrese un email válido');
            }  else if (!telfRes) {
                jAlert('Ingrese un teléfono válido');
            }  else if (!dniRes) {
                jAlert('Ingrese un DNI válido');
            }  else if (!passRes) {
            	var titulo = "Validaci&oacute;n de datos";
        		var mensaje = "La contrase&ntilde;a debe tener al menos 8 caracteres y estar compuesta por letras, n&uacute;meros y simbolos ($%&+!@).";
                var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
                '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
                $('#close-popup-message').hide();
                $('#msg-message').html(msgError);
            	openModal("#popup-message","");
            	$("#password-client").val('');
            	$("#password-client").trigger("keyup");
//                jAlert('Ingrese un pass válido');
            }              
            //else if (comMovil!='0') {
            //	jAlert('Seleccione la teleoperadora de su celular');
            //} 
            
            else {
                jAlert('¡Por favor complete los campos obligatorios!');
            }
        }
    });
    
    $('#btn-save-changes').on('click', function (event) {
        event.preventDefault();
        var formUpdate = $("#frm-update-client");
        updateClient(formUpdate); 
    });
    
    function updateClient(form){
    	var jform = form.serializeArray();
		//if ( jform.length < 5) { // ya no se valida el telefono
    	if ( jform.length < 3) { // el param confirm no viene en caso la casilla no esté seleccionada
			jAlert('Completar datos');
			return;
		}
    	var email = jform[0].value.trim();
        //var telefono = jform[4].value.trim();
        var emailPattern = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
        var emailRes = emailPattern.test(email);
        var telfPattern = new RegExp(/^([9]{1})([0-9]{8})$/);
        //var telfRes = telfPattern.test(telefono);
        
        if($("#confirm").is(":checked")) { $("#confirm").attr("value","Y");}
        else {$("#confirm").attr("value","N");}
        
        var container = $('#account-wrapper');
        //if (emailRes && telfRes) {
        if (emailRes) {
	        $.ajax({
	            type: form.attr('method'),
	            url: form.attr('action'),
	            dataType: 'json',
	            async:false,
	            data: form.serialize(),
	            beforeSend: function () {
                	container.append('<div id="loader-frm-register"></div>');
	            },
	            success: function (data) {
	            	container.find('#loader-frm-register').remove();
	            	form.children('.head-tab-content').trigger('click');
	                if (data.state == 1) {
	                	jAlert(data.message);
	                } if (data.state == 707) {
	                	login(loginForm);
	                } else {
	                	jAlert(data.message);
	                }
	                
	                $("#popup_container").css({
                        zIndex: 3000000000
                    });
	            }
	        })
        } else {
     	   /*if(!emailRes && !telfRes){
                jAlert('Ingrese un email y teléfono válidos');
            } else*/ if (!emailRes) {
                jAlert('Ingrese un email válido');
            }/*  else if (!telfRes) {
                jAlert('Ingrese un teléfono válido');
            }*/  else {
            	jAlert('Completar datos')
            }
        }
    }
    
    $('#safety-zone').find('a').on('click', function (event) {
        event.preventDefault();
    });
    $('#security').on('click', function (event) {
        dhtmlwindow.open('resultbox', 'iframe', 'https://zonasegura.intralot.com.pe/intralot-seguridad/index.html', 'APOSTAMOS POR TU SEGURIDAD', 'width=614,height=375,scrolling=1,center=1,resize=0', 'recal');
    });
    $('#ic_abajo_derecho_0').on('click', function (event) {
        event.preventDefault();
        dhtmlwindow.open('resultbox', 'iframe', 'https://www.latinka.com.pe/latinka/minisite/intralot-seguridad/', 'APOSTAMOS POR TU SEGURIDAD', 'width=614,height=375,scrolling=1,center=1,resize=0', 'recal');
    });
    $('#footer-term').on('click', function (event) {
        event.preventDefault();
        dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones.html', 'TÉRMINOS Y CONDICIONES', 'width=606,height=460,scrolling=1,center=1,resize=0', 'recal');
        $("#resultbox").css('z-index', 2147483000);
    });
    $(document).on("click", ".js-terms", function(e) {
        e.preventDefault();
        dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones.html', 'TÉRMINOS Y CONDICIONES', 'width=606,height=460,scrolling=1,center=1,resize=0', 'recal');
    });
//    $('#reclama-premio').on('click', function (event) {
//        event.preventDefault();
//        dhtmlwindow.open('resultbox', 'iframe', 'reclama_premio.html', 'RECLAMA TU PREMIO', 'width=490,height=350,scrolling=1,center=1,resize=0', 'recal');
//        $("#resultbox").css('z-index', 2147483000);
//    });
    $('#register-cyber').on('click', function (event) {
        event.preventDefault();
        window.location.href = 'registro.html';
    });
    $('#ban-promocion').on('click', function (event) {
        event.preventDefault();
        window.location.href = 'registro.html';
    });
    $('#term-condiciones-cyber').on('click', function (event) {
        event.preventDefault();
        dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones_cyber_mdy.html', 'TÉRMINOS Y CONDICIONES', 'width=490,height=350,scrolling=1,center=1,resize=0', 'recal');
    });
    $('#tyc-promo-tinka, #tyc-promo-tinka-i').on('click', function (event) {
        event.preventDefault();
        dhtmlwindow.open('resultbox', 'iframe', $(this).attr('href'), 'TÉRMINOS Y CONDICIONES', 'width=610,height=400,scrolling=0,center=1,resize=0', 'recal');
    });
    exe.overwriteBalance();

 
    $(document).on("click", "#lnkActiveCode", function (event) {
        event.preventDefault();
        smsMessage = "Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.";
        viewSmsCode();
    });
   
    $(document).on("click", "#lnkSendSms", function (event) {
        event.preventDefault();
        datalayerActivaCuenta('ENVIAR CÓDIGO NUEVAMENTE');
        viewSmsSend();
    });
    $(document).on("click", "#lnkagreement", function (event) {
        event.preventDefault();
        top.dhtmlwindow.close(top.document.getElementById("resultboxtyc"));
        document.body.scrollTop = document.body.scrollHeight;
        dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones.html', 'TÉRMINOS Y CONDICIONES', 'width=606,height=460,scrolling=1,center=1,resize=0', 'recal');
        $(".drag-controls a#lnkcerrar").css("display","none");
        $(".drag-controls a#lnkregresar").css("display","block");
        $(".drag-controls a#lnkregresar").attr("data-mode","tyc");
    });
    $(document).on("click", "#lnkactivatewbbondrd, #lnkactivatewbbondib", function (event) {
        event.preventDefault();
        var mode = (($(this).attr("id")=="lnkactivatewbbondrd")?"rdb":(($(this).attr("id")=="lnkactivatewbbondib")?"ibb":""));
        var resultbox = (($(this).attr("id")=="lnkactivatewbbondrd")?"resultboxrdb":(($(this).attr("id")=="lnkactivatewbbondib")?"resultboxibb":""));
        top.dhtmlwindow.close(top.document.getElementById(resultbox));
        document.body.scrollTop = document.body.scrollHeight;
        var u = $("#wbBonoTyC", window.parent.document).val();
        dhtmlwindow.open('resultbox', 'iframe', u, 'TÉRMINOS Y CONDICIONES', 'width=620,height=460,scrolling=1,center=1,resize=0', 'recal');
        $(".drag-controls a#lnkcerrar").css("display","none");
        $(".drag-controls a#lnkregresar").css("display","block");
        $(".drag-controls a#lnkregresar").attr("data-mode",mode);
    });
    $(document).on("click", "#lnkactivatebondrd, #lnkactivatebondib", function (event) {
        event.preventDefault();
        var mode = (($(this).attr("id")=="lnkactivatebondrd")?"rdb":(($(this).attr("id")=="lnkactivatebondib")?"ibb":""));
        var resultbox = (($(this).attr("id")=="lnkactivatebondrd")?"resultboxrdb":(($(this).attr("id")=="lnkactivatebondib")?"resultboxibb":""));
        top.dhtmlwindow.close(top.document.getElementById(resultbox));
        document.body.scrollTop = document.body.scrollHeight;
        var u = $("#iflexBonoTyC", window.parent.document).val();
        dhtmlwindow.open('resultbox', 'iframe', u, 'TÉRMINOS Y CONDICIONES', 'width=620,height=460,scrolling=1,center=1,resize=0', 'recal');
        $(".drag-controls a#lnkcerrar").css("display","none");
        $(".drag-controls a#lnkregresar").css("display","block");
        $(".drag-controls a#lnkregresar").attr("data-mode",mode);
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
    $(document).on("click", "#lnkregresar", function (event) {
        event.preventDefault();
        if($(this).data("mode") == 'tyc') exe.opentyc();
        //if($(this).data("mode") == 'rdb') exe.openrdb(null);
        //if($(this).data("mode") == 'ibb') exe.openibb(null);
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
        	if(($.trim(phone)).split(' ')[0]==='***'){
        		$.ajax({
            		type: "post",
                    url: "send-sms-validation.html",
                    data: "phone-client=" + "",
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
            }else{
            	$("#resultboxphn").find('#dhtmlwindowloader').remove();
            	jAlert("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.", null);
            }
        	
        }
        
        $("#popup_container").css({
            zIndex: 3000000000
        });
    });
    
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
                		datalayerActivaCuenta('CONFIRMAR');
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
    
    $(document).on("click", "#btnaceptb", function (event) {
    	event.preventDefault();
    	if (($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && !$("#chkactivatewbbond").is(":checked"))) && ($("#chkactivatebond").length==0 || ($("#chkactivatebond").length>0 && !$("#chkactivatebond").is(":checked")))) {
            $("div#alertVerify").html("Has clic en el check y luego activa el bono");
            return false;
        }
    	var item = $(this).data("balance");
    	var url = (($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked"))?"activate-wbpromotion.html":($("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked"))?"activate-promotion.html":"");
    	$("div#alertVerify").html("");
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: url,
                data: "balanceItem=" + item,
                dataType: "jsonp",
                beforeSend: function () {
                	$("#resultboxrdb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>');
                },
                success: function (e) {
                	$("#resultboxrdb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		top.dhtmlwindow.close(top.document.getElementById("resultboxrdb"));
                		jAlert(e.message,null,function(){login(loginForm);});
                	} else jAlert(e.message);
                }, 
            });
        } else {
        	$("#resultboxrdb").find('#dhtmlwindowloader').remove();
        	jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    
    $(document).on("click", "#btncloseb", function (event) {
		event.preventDefault();
		$("#resultboxrdb").find('#dhtmlwindowloader').remove();
    	top.dhtmlwindow.close(top.document.getElementById("resultboxrdb"));
    	login(loginForm);
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
                beforeSend: function () {
                	$("#resultboxrdb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>');
                },
                success: function (e) {
                	$("#resultboxrdb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		top.dhtmlwindow.close(top.document.getElementById("resultboxrdb"));
                		jAlert(e.message,null,function(){login(loginForm);});
                	} else jAlert(e.message);
                }, 
            });
        } else {
        	$("#resultboxrdb").find('#dhtmlwindowloader').remove();
        	jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    
    $(document).on("click", "#btnaceptbibk", function (event) {
    	event.preventDefault();
    	if (($("#chkactivatewbbondibk").length==0 || ($("#chkactivatewbbondibk").length>0 && !$("#chkactivatewbbondibk").is(":checked"))) && ($("#chkactivatebondibk").length==0 || ($("#chkactivatebondibk").length>0 && !$("#chkactivatebondibk").is(":checked")))) {
            $("div#alertVerify").html("Has clic en el check y luego activa el bono");
            return false;
        }
    	var item = $(this).data("balance");
    	var url = (($("#chkactivatewbbondibk").length>0 && $("#chkactivatewbbondibk").is(":checked"))?"activate-wbpromotionibk.html":($("#chkactivatebondibk").length>0 && $("#chkactivatebondibk").is(":checked"))?"activate-promotionibk.html":"");
    	$("div#alertVerify").html("");
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: url,
                data: "balanceItem=" + item,
                dataType: "jsonp",
                beforeSend: function () {
                	$("#resultboxibb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>');
                },
                success: function (e) {
                	$("#resultboxibb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		top.dhtmlwindow.close(top.document.getElementById("resultboxibb"));
                		jAlert(e.message,null,function(){login(loginForm);});
                	} else jAlert(e.message);
                }, 
            });
        } else {
        	$("#resultboxibb").find('#dhtmlwindowloader').remove();
        	jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    
    $(document).on("click", "#btnclosebibk", function (event) {
		event.preventDefault();
		$("#resultboxibb").find('#dhtmlwindowloader').remove();
    	top.dhtmlwindow.close(top.document.getElementById("resultboxibb"));
    	login(loginForm);
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
                beforeSend: function () {
                	$("#resultboxibb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>');
                },
                success: function (e) {
                	$("#resultboxibb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		top.dhtmlwindow.close(top.document.getElementById("resultboxibb"));
                		jAlert(e.message,null,function(){login(loginForm);});
                	} else jAlert(e.message);
                }, 
            });
        } else {
        	$("#resultboxibb").find('#dhtmlwindowloader').remove();
        	jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    $(document).delegate('#to-lapolla', 'click', function () {
    	$.ajax({
            type: 'post',
            url: 'lapolla-nosession.html',
            dataType: 'json'
    	}).done(function(d) {
    		$(location).attr('href', d.redireccion);
        });
    });
    $(document).delegate('#to-tav2', 'click', function () {
    	$.ajax({
            type: 'post',
            url: 'tav2-nosession.html',
            data: 'redirectGame=TA',
            dataType: 'json'
    	}).done(function(d) {
    		$(location).attr('href', d.redireccion);
        });
    });
    $(document).delegate('#to-tav2-ddvv', 'click', function () {
    	$.ajax({
            type: 'post',
            data: 'redirectGame=DV',
            url: 'tav2-nosession.html',
            dataType: 'json'
    	}).done(function(d) {
    		$(location).attr('href', d.redireccion);
        });
    });
    $(document).on('change', '#resultboxrdb input#chkactivatebond, #resultboxrdb input#chkactivatewbbond', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebond" && $("#resultboxrdb input#chkactivatewbbond").length>0 && $("#resultboxrdb input#chkactivatewbbond").is(":checked")) $("#resultboxrdb input#chkactivatewbbond").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbond" && $("#resultboxrdb input#chkactivatebond").length>0 && $("#resultboxrdb input#chkactivatebond").is(":checked")) $("#resultboxrdb input#chkactivatebond").prop("checked",!chk);
    });
    $(document).on('change', '#resultboxibb input#chkactivatebondibk, #resultboxibb input#chkactivatewbbondibk', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebondibk" && $("#resultboxibb input#chkactivatewbbondibk").length>0 && $("#resultboxibb input#chkactivatewbbondibk").is(":checked")) $("#resultboxibb input#chkactivatewbbondibk").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbondibk" && $("#resultboxibb input#chkactivatebondibk").length>0 && $("#resultboxibb input#chkactivatebondibk").is(":checked")) $("#resultboxibb input#chkactivatebondibk").prop("checked",!chk);
    });
    
    $('#tab-item_1').on('click', function (event) {
    	try {
    		tagMyAccount("Mis Datos");				
		} catch (e) {
			console.error(e);
		}
        
    });
    
    $('#tab-item_2').on('click', function (event) {
    	try {
    		tagMyAccount("Cobrar Mis Premios")	;			
		} catch (e) {
			console.error(e);
		}
        
    });
    
    $('#tab-item_3').on('click', function (event) {
    	try {
    		tagMyAccount("Últimas Jugadas")	;			
		} catch (e) {
			console.error(e);
		}
        
    });
    
    $('#tab-item_4').on('click', function (event) {
    	try {
    		tagMyAccount("Cargar Saldo")	;			
		} catch (e) {
			console.error(e);
		}
        
    });
    
    $('#tab-item_5').on('click', function (event) {
    	try {
    		tagMyAccount("Movimientos")	;
		} catch (e) {
			console.error(e);
		}
        
    });
    
    $('#tab-item_6').on('click', function (event) {
    	try {
    		tagMyAccount("Movimientos De Bono (Te Apuesto)");
		} catch (e) {
			console.error(e);
		}
        
    });
    
    $('#tab-item_7').on('click', function (event) {
    	try {
    		tagMyAccount("Jugadas Gratis");
		} catch (e) {
			console.error(e);
		}
        
    });
    
    $('#lnkInicio').on('click', function (event) {
        event.preventDefault();
        window.location.href = 'inicio.html';
    })
    
};$($index);



function loginOk(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'loginOk',
	    'category': 'UI :: Login',
	    'action': 'Click',
	    'label': 'Login Ok'
	});
	
	var tag="loginOk";
	console.log("Taggin event: "+tag);
}
function loginError(label){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'errorLogin',
	    'category': 'UI :: Login',
	    'action': 'Error',
	    'label':label
	});
	var tag="errorLogin";
	console.log("Taggin event: "+tag);
}

function tagMyAccount(label){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	   'event': 'miCuenta',
	    'category': 'UI :: Mi Cuenta',
	    'action': 'Click',
	    'label': label   // Indicar el nombre del tab desplegado. 
	});
	var tag="miCuenta";
	console.log("Taggin event: "+tag+", Label: "+label);
}

function tagBanner(name, position){
	
	if(flagCarrusel==true){
		name='Banner '+name;
		position='Banner-'+position;
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEpromotionView',
		  'ecommerce': {
		    'promoView': {
		      'promotions': [{                  
		         'name': name,
		         'position': position
		       }]       
		       }
		    }
		});
		
		var tag="EEpromotionView";
		console.log("Taggin event: "+tag+", name: "+name+", position: "+position);
	}
	
	flagCarrusel=false;
}

function goRegister() {
	var operatorIdApi=$('#operatorIdApi').val();
	
	if(operatorIdApi==="5588"){
		window.location.href = $('#redirect558cancel').val();
	}else{
		window.location.href = 'registro.html';
	}
}
function goRecoverPassword() {
	var operatorIdApi=$("#operatorIdApi").val();
	
	if(operatorIdApi=="5588"){
		window.location.href = 'recuperar-contrasenia-ta.html';
	}else{
		window.location.href = 'restablecer.html';
	}
    
}

function clearDocument(){
	if($('#doc-is-registered').length>0){
		$('#document-number').val("");
		$('#document-number-pasap').val("");
		$('#document-number-carex').val("");
	}
}

function goArcoRights() {
	window.location.href = 'derechos-arco.html';
}

function getFastTokenAndRedirect() {
	$.ajax({
        type: 'post',
        url: 'get-fast-token.html',
        dataType: 'json'
	}).done((res) => {
		if(res.message=="OK") {
			console.log(res);
			window.location.assign(res.redirect+"&token="+res.token);
			return res;
		}
    });
}

function resetPage() {
    document.getElementById("frmLoginDT").reset();
    //window.location.assign('inicio.html');
   window.location.assign('salir.html');
}
