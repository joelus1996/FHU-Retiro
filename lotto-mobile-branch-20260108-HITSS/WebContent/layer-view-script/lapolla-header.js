var app = {
    responseType: "jsonp",
};
var ppsts = false;
var smsMessage = "";
var run = {
setup: function () {
	var flag = false;
	$.ajax({type: "post", url: "lapolla-home.html", dataType: app.responseType
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
var $LaPollaHeader = function () {
	
var form = "";	

function login(f){
	var flag = false;
    var valid = true;
    var cadena = "";
    var baseUrl = "";
    var authToken = "";
    var mensaje = "Ocurrió un problema inesperado [12].";
    $.ajax({type: f.attr("method"), url: f.attr("action"), dataType: app.responseType, data: f.serialize(),async:false,
		beforeSend: function () {f.lockForm(true);}
    }).done(function(d) {
    	if(d.error === "OK" ) {
    		form = "";
    		$(".username").text(d.username);
    		$(".amount").text("S/. "+d.amount);
    		flag = true;
    		f.resetForm();
    		f.lockForm(false);
    		viewNext();
    		cadena = d.lapolla.split("|");
    		if($.trim(cadena[0])!="") {
                baseUrl = $.trim(cadena[0]);
                authToken = $.trim(cadena[1]);
			} else {
          		mensaje = "No se ha logrado ingresar";
           	}
    		
    	} else if(d.error === "TC") {
            valid = false;
            f.lockForm(false);
            viewKept();
        } else if(d.error === "AC") {
            valid = false;
            f.lockForm(false);
            viewActiveAccount(d.phone);
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
        } else {
        	f.lockForm(false);
        	f.resetForm();
        	//$("#btnEnter").bubble(d.message, 10000);
        	$("span#alertLogin").html(d.message);
        }
    }).fail(function() {
    	f.lockForm(false);
    	//$("#btnEnter").bubble("Ocurrió un problema inesperado. [14]", 10000);
    }).always(function() {
    	if(flag && valid) {
    		window.open(baseUrl+"?authToken="+authToken,"_parent");
        } else if(valid) {
        	//$("#btnOut").bubble(mensaje, 10000);
        	$("span#alertLogin").mensaje(mensaje);
        }
    });
	
}

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
	
	$(document).on("click", "#btnEnter", function (event) {
    	event.preventDefault();
        $("#form-sign-in").validate(function () {
            form = $(this);
            login(form);
        });
	});
	
	$(document).on("click", "#btnOut", function (event) {
    	$.ajax({type: "post", url: "lapolla-logout.html", dataType: app.responseType
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
            }).done(function(d) {
            	if(d.status===200) {
            		viewSmsCode();
            	} else {
            		//$("#btnEnter").bubble(d.message, 10000);
            		$("span#alertTelfVerify").html(d.message);
            	}
            });
        } else {
        	//$("#btnEnter").bubble("El teléfono celular es incorrecto. Verifique si escribió correctamente.", 10000);
        	$("span#alertTelfVerify").html("El tel&eacute;fono celular es incorrecto. Verifique si lo escribi&oacute; correctamente.");
        }
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
	            		login(form);
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
    }
    
    function viewSmsCode(){
    	//smsMessage=$("#message-text").html();
    	//$("#message-text").html("Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.");
    	$("#detailMessage").html(smsMessage);
    	$('#message-sms').addClass("disabled");
    	$('#message-code').removeClass("disabled");
    	$("#user-code").val("");
    }
    function viewSmsSend(){
    	//$("#message-text").html(smsMessage);
    	smsMessage=$("#detailMessage").html();
    	$("#detailMessage").html("Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.");
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
	    	$("#btnEnter").bubble("El correo electrónico es incorrecto. Verifique si lo escribió correctamente.", 10000);
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
                		$("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
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
                		$("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-rdbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btncloseb' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
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
                		$("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btnclosebibk' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btnclosebibk' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
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
                		$("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btnclosebibk' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                	} else $("#user-ibbonus").html("<div class='top-saldo'><div class='top-right-saldo'><div class='saldo-add'><p>"+e.message+"</p></div></div></div><div class='control-form'><i></i><input type='button' id='btnclosebibk' value='ACEPTAR' class='js-close-modal btn btn-orange white rdb-button-text' /></div>");
                }, 
            });
        } else {
        	$("#btnEnter").bubble("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", 10000);
        }
    });
    
    $(document).on("click", "#loadbalance", function (event) {
    	event.preventDefault();
    	var childWindow = window.open("client_lotocard_show_information.html?operatorId=5587","_parent");
    });
    
    $(document).on("click", "#newaccount", function (event) {
    	event.preventDefault();
    	var childWindow = window.open("client_lotocard_show_form.html?operatorId=5587","_parent");
    });
    
    $(document).on("click", "#pwdreminder", function (event) {
    	event.preventDefault();
    	var childWindow = window.open("security_login_execute_authentication.html?operatorId=5587","_parent");
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
};$($LaPollaHeader);
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