var app = {
    responseType: "jsonp",
};
var ppsts = false;
var smsMessage = "";
var run = {
setup: function () {
	var flag = false;
	$.ajax({type: "post", url: "teapuesto-home.html", dataType: app.responseType
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
var $TeApuestoHeader = function () {

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

function login(f){
	var flag = false;
    var valid = true;
    var cadena = "";
    var baseUrl = "";
    var playerId = "";
    var language = "";
    var operatorId = "";
    var authToken = "";
    var currency = "";
    var mensaje = "Ocurrió un problema inesperado [12].";
    $.ajax({type: f.attr("method"), url: f.attr("action"), dataType: app.responseType, data: f.serialize(),async:false,
		beforeSend: function () {f.lockForm(true);}
    }).done(function(d) {
    	if(d.state === "OK" ) {
    		form = "";
    		$(".username").text(d.username);
    		$(".amount").text("S/. "+d.amount);
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
    		
    	} else if(d.state === "TC") {
            valid = false;
            f.lockForm(false);
            viewKept();
        } else if(d.state === "AC") {
            valid = false;
            f.lockForm(false);
            viewActiveAccount(d.phone);
            onlynumber();
        } else if(d.state === "MV") {
            valid = false;
            f.lockForm(false);
            viewUpdateMail();
        } else if(d.state === "CC") {
    		f.lockForm(false);
        	f.resetForm();
        	$("#user").focus();
            setCaptcha(true);
        	$("#btnEnter").bubble(d.message, 10000);
        } else if(d.state === "IB") {
            valid = false;
            f.lockForm(false);
            viewIBBonus(d.message);
        } else if(d.state === "RD") {
            valid = false;
            f.lockForm(false);
            viewRDBonus(d.message);
        } else {
        	f.lockForm(false);
        	f.resetForm();
        	$("#btnEnter").bubble(d.message, 10000);
        }
    }).fail(function() {
    	f.lockForm(false);
    	$("#btnEnter").bubble("Ocurrió un problema inesperado. [14]", 10000);
    }).always(function() {
    	if(flag && valid) {
        	var url = baseUrl+"?playerId="+playerId+"&language="+language+"&operatorId="+operatorId+"&authToken="+authToken+"&currency="+currency;
        	window.open(url, "_parent");
        } else if(valid) {
        	$("#btnOut").bubble(mensaje, 10000);
        }
    });
	
}
	
	$(document).on("click", "#btnEnter", function (event) {
    	event.preventDefault();
        $("#form-sign-in").validate(function () {
            form = $(this);
            login(form);
        });
	});
	
	$(document).on("click", "#btnOut", function (event) {
    	$.ajax({type: "post", url: "teapuesto-logout.html", dataType: app.responseType
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
		} else $("#btnAgree").bubble("Por favor infórmese y confirme la aceptación de los Términos y Condiciones.", 10000);//jAlert("Por favor lea y confirme los nuevos Términos y condiciones.", null);
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
        		data: "phone-client=" + phone, dataType: "jsonp",
                async:false,
            }).done(function(d) {
            	if(d.status===200) {
            		viewSmsCode();
            	} else {
            		//$("#btnEnter").bubble(d.message, 10000);
            		$("span#alertTelfVerify").html(d.message);
            	}
            });
        } else {
        	$("span#alertTelfVerify").html("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.");
        	 //$("#btnEnter").bubble("El teléfono celular es incorrecto. Verifique si escribió correctamente.", 10000);	
        }
	});
	
	$(document).on("click", "#btnSendCode", function (event) {
		event.preventDefault();
		var code = $.trim($("#user-code").val());
	    	$.ajax({
	    		type: "post",
	            url: "send-code-validation.html",
	            data: "sms-code=" + code,
	            dataType: "jsonp",
	            async:false,
	            success: function (e) {
	            	if(e.status===1) {
	            		$("#user-sms").html("<div id='detailMessage' class='top-column exactl' style='width:580px;text-align:right;'><br/>Su cuenta se encuentra correctamente activada</div><div class='top-column exactr' style='width:100px;'><a href='#' id='btnCloseSms' class='btn-orange loggedin'>CERRAR</a></div>");
	            		//login(form);
	            	} else {
	            		//viewSmsSend();
	            		//$("#btnEnter").bubble(e.message, 10000);
	            		$("span#alertCodeVerify").html(e.message);
	            	}
	            }, 
	        });	
	});
	$(document).on("click", "#btnCloseSms", function (event) {
        event.preventDefault();
        login(form);
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
    	$("#detailMessage").html("Ingresa el celular registrado en tu cuenta o actual&iacute;zalo aqu&iacute;.<br/><span class='error' id='alertTelfVerify'></span><span class='error' id='alertCodeVerify'></span>");//"<br/>Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.<br/><br/>");
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
	    var u = $("#wbBonoTyC").val();//"https://zonasegura.intralot.com.pe/minisite/recarga-bono/"
	    var win = window.open(u, "_blank","height="+h+",width="+w+",left="+l+",top="+t+",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,titlebar=no,toolbar=no",true);
	    win.focus();
	    return win;
	});
	
	$(document).on("click", "#lnkactivatebondrd, #lnkactivatebondib", function (event) {
		var w = 620;
		var h = 460;
		var l = (screen.availWidth - w) / 2;
	    var t = 50;
	    var u = $("#iflexBonoTyC").val();//"https://zonasegura.intralot.com.pe/minisite/recarga-bono/"
	    var win = window.open(u, "_blank","height="+h+",width="+w+",left="+l+",top="+t+",channelmode=no,directories=no,fullscreen=no,location=no,menubar=no,resizable=no,scrollbars=no,status=no,titlebar=no,toolbar=no",true);
	    win.focus();
	    return win;
	});
	
	$(document).on("click", "#btnaceptb", function (event) {
    	event.preventDefault();
    	//if (!$("#chkactivatebond").is(":checked")) {
    	if (($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && !$("#chkactivatewbbond").is(":checked"))) && ($("#chkactivatebond").length==0 || ($("#chkactivatebond").length>0 && !$("#chkactivatebond").is(":checked")))) {
            //$("div#alertVerify").html("Has clic en el check y luego activa el bono");
    		$("span.tooltip-info-img").show();
    		$("span.tooltip-info").html("Has clic en el check y luego activa el bono");
            return false;
        }
    	var item = $(this).data("balance");
    	var url = (($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked"))?"activate-wbpromotion.html":($("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked"))?"activate-promotion.html":"");
    	$("span.tooltip-info-img").hide();
    	//console.log("URL="+url);
        if(item!=""){
        	$.ajax({
        		type: "post",
                url: url,//"activate-promotion.html",
                data: "balanceItem=" + item,
                dataType: "jsonp",
                async: false,
                /*beforeSend: function () {
                	$("#resultboxrdb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>')
                },*/
                success: function (e) {
                	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		//top.dhtmlwindow.close(top.document.getElementById("resultboxrdb"));
                		//login(form);
                		//jAlert(e.message);
                		//$("#btnEnter").bubble(e.message, 10000);
                		$("#user-rdbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-rdbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");//$("#btnEnter").bubble(e.message, 10000);
                }, 
            });
        } else {
        	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);//jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    
	$(document).on("click", "#btncloseb", function (event) {
		//login(form);
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
                /*beforeSend: function () {
                	$("#resultboxrdb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>')
                },*/
                success: function (e) {
                	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		//top.dhtmlwindow.close(top.document.getElementById("resultboxrdb"));
                		//login(form);
                		//jAlert(e.message)
                		$("#user-rdbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><p style='text-align:right;'>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-rdbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><p style='text-align:right;'>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                }, 
            });
        } else {
        	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);//jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    
    $(document).on("click", "#btnaceptbibk", function (event) {
    	event.preventDefault();
    	//if (!$("#chkactivatebondibk").is(":checked")) {
    	if (($("#chkactivatewbbondibk").length==0 || ($("#chkactivatewbbondibk").length>0 && !$("#chkactivatewbbondibk").is(":checked"))) && ($("#chkactivatebondibk").length==0 || ($("#chkactivatebondibk").length>0 && !$("#chkactivatebondibk").is(":checked")))) {
            //$("div#alertVerify").html("Has clic en el check y luego activa el bono");
    		$("span.tooltip-info-img").show();
    		$("span.tooltip-info").html("Has clic en el check y luego activa el bono");
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
                /*beforeSend: function () {
                	$("#resultboxrdb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>')
                },*/
                success: function (e) {
                	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		//top.dhtmlwindow.close(top.document.getElementById("resultboxrdb"));
                		//login(form);
                		//jAlert(e.message);
                		//$("#btnEnter").bubble(e.message, 10000);
                		$("#user-ibbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-ibbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");//$("#btnEnter").bubble(e.message, 10000);
                }, 
            });
        } else {
        	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);//jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    
	$(document).on("click", "#btnclosebibk", function (event) {
		//login(form);
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
                /*beforeSend: function () {
                	$("#resultboxrdb").append('<div id="dhtmlwindowloader" class="dhtmlwindowloader"></div>')
                },*/
                success: function (e) {
                	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
                	if(e.status===1) {
                		//top.dhtmlwindow.close(top.document.getElementById("resultboxrdb"));
                		//login(form);
                		//jAlert(e.message)
                		$("#user-ibbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><br/><p style='text-align:right;'>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-ibbonus").html("<div class='top-saldo' style='width:580px;'><div class='top-right-saldo'><div class='saldo-add'><br/><p style='text-align:right;'>"+e.message+"</p></div></div></div><div class='control-form control-center'><i></i><input type='button' id='btncloseb' value='CERRAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                }, 
            });
        } else {
        	//$("#resultboxrdb").find('#dhtmlwindowloader').remove();
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);//jAlert("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
        }
    });
    
    $('#user-ibbonus, user-rdbonus').on('mouseover', '.tooltip-info-img', function () {
        var contenido_total = $(this).attr('rel');
        var contenido_temp = (contenido_total + '').split('#');
        var posicion = parseInt(contenido_temp[0]);
        var mensaje = contenido_temp[1] + "";
        $(".tooltip-info").show();
        $(".tooltip-info-arrow").show();
    }).on('mouseout', '.tooltip-info-img', function () {
        $(".tooltip-info").hide();
        $(".tooltip-info-arrow").hide();
    })
    
    $(document).on("mouseover", "#chkactivatebond, #chkactivatebondibk", function () {
    	//event.preventDefault();
    	$("span.tooltip-info-img").hide();
    	//return true;
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
		$("#user-phone").val((phone!=null && phone!='')?phone:"");
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
};$($TeApuestoHeader);
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
			if(!demon) $(this).bubble(message, 10000);
			return demon;
		});
		if(demon) a.call(this);
	};
})(jQuery, undefined);