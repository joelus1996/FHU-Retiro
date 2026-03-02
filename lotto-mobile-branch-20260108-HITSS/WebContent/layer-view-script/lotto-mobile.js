var count_multiply = 0;
var count_combination = 0;
var count_consecutive = 1;
var smsMessage = "";
var iflexWin = null;
var exe = {
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
			e.parentNode.insertBefore($,e)
		})(document,"script");
	},
 openModal: function(content, ctrl){
		$('#popup .main-modal').html(content);
		openModal("#popup",ctrl);
 } 

};
$(document).ready(function () {
	/******/
	/*
	setCaptcha();
	
	$("#reload").click(function() {
		setCaptcha();
    });
	*/
	if ( window.addEventListener ) {
	    window.addEventListener('message', handleMessage, true);
	} else if ( window.attachEvent ) { // ie8
	    window.attachEvent('onmessage', handleMessage);
	}
	
	loadRecharge();
	/******/
	$(document).delegate('#bcp', 'click', function () {
        var data = '';
        var msgres = [];
        var ico = $("#bcpcharge").siblings('i');
        $(ico).addClass('loading').removeClass('hide');
        $.ajax({
            type: "post",
            url: "check-transaction-bcp.html",
            dataType: "text",
            data: "",
            global: false,
            async: false,
            success: function (e) {
                msgres = $.trim(e.toString()).split("|||");
                data = msgres[0];
                renderizarBCP(data)
            }
        });
        $(ico).removeClass('loading').addClass('hide');		
	});
	
	$(document).delegate('#lottocard', 'click', function () {
		$('button').prop('disabled', true);	
		try {
			var ico = $(this).siblings('i');
	    	$(ico).addClass('loading').removeClass('hide');
	    	var frm = $("#client_lotocard_load_balance");
	    	var actbono = $("#chkactivatebond").is(":checked");
	    	var actwbbono = $("#chkactivatewbbond").is(":checked");
	    	var argument = "";
	    	frm.attr("action", "client_lotocard_load_balance.html?activ-bono="+actbono+"&activ-wbbono="+actwbbono);
	        if ($("#numberCard").val() == '') {
	            alertMessage("Ingrese el c&oacute;digo de su lottocard");
	            return false;
	        } else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
			        $("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ( $.trim($("#bonusChannel").val()) == "" || ( $.trim($("#bonusChannel").val()) != "" && $.trim($("#bonusChannel").val()).includes($(this).data("type"))))) {
	        	argument = "<p>Hoy ofrecemos Bono de "+$("#bonusPercentage").val()+"% para jugar en TeApuesto.pe y estas desaprovech&aacute;ndolo.</p><p>&iquest;Deseas continuar de todos modos con tu recarga?</p>";
	        	
	        	$("#confirmModal_content_id").html(argument);
	        	$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
	        		onOkBut: function(event, el) {rechargeLotocard(frm);} , 
	        		onCancelBut: function(event, el) {} });	
	        } else {
	        	//if(actwbbono==true) $('.content-wrap .wb-saldo').text("");
				//rechargeLotocard(frm,actwbbono);
	        	var pin = $("#numberCard").val();
	        	$.ajax({
	                type: "POST",
	                url: "find_lotocard.html",
	                dataType: "json",
	                data: "pin-number=" + pin,
	                success: function (data) {
	                	if(data.message==="Existe"){
							var amount = data.amount; 
							var stepAmount = $("#stepAmount").val();
							var bonusChannel = $("#bonusChannel").val();
							var bonusPercentage = $("#bonusPercentage").val();
							
							var welcomeBonusStepAmount = $("#welcomeBonusStepAmount").val();
							var welcomeBonusPercentaje = $("#welcomeBonusPercentaje").val();
							
							if($("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && 
							($.trim(bonusChannel)=="" || ($.trim(bonusChannel)!="" && $.trim(bonusChannel).includes("LOTOCARD"))) &&
							($.trim(stepAmount)!="" && parseFloat($.trim(stepAmount))>parseFloat(amount))) {
								argument = "<p>Has activado el Bono de "+bonusPercentage+"%, pero con un monto menor a S/ "+stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>";
								//$("#confirmModal_content_id").html(argument);	
								//$("#confirm_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {rechargeLotocard(frm);} , onCancelBut: function(event, el) {} });	
							}else if($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==true && 
									($.trim(bonusChannel)=="" || ($.trim(bonusChannel)!="" && $.trim(bonusChannel).includes("LOTOCARD"))) &&
									($.trim(welcomeBonusStepAmount)!="" && parseFloat($.trim(welcomeBonusStepAmount))>parseFloat(amount))){
								argument = "<p>Has activado el Bono de "+welcomeBonusPercentaje+"%, pero con un monto menor a S/ "+welcomeBonusStepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>";
							}
							else{
								rechargeLotocard(frm);
							}
							if (argument != "") {
					        	$("#confirmModal_content_id").html(argument);
					        	$("#confirm_content").confirmModal({top : '30%', type : 'modal',  
					        		onOkBut: function(event, el) {rechargeLotocard(frm);} , 
					        		onCancelBut: function(event, el) {} });			
							}
	                	}else{
	                		rechargeLotocard(frm);
	                	}
	                }
	        	})		
	        }
	        
	        $(ico).removeClass('loading').addClass('hide');
  			$('button').prop('disabled', false);
		} catch (e) {
			console.log(err.message);
  			$('button').prop('disabled', false);
		}       
        
    });
	/******/
    $("#listMenuFooter1").find("li").eq(0).css("border-top", "0px");
    $("#listMenuFooter2").find("li").eq(0).css("border-top", "0px");

    $(".ui-datepicker").hide();
    
    $("[name='consecutive']").click(function(){
	    if($(this).prop('checked')){

	        jQuery("input[name='consecutive']").each(function() {
	        	$(this).prop('checked', false);
			});

	        $(this).prop('checked', true);
         
	    }
    });
      
    $(document).delegate('#ingresar' ,'click', function (event) {
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
//	        if ($("#sentCaptcha").val() == '') {
//	            $("span#alertLogin").html("Ingresar c&oacute;digo");
//	            return false
//	        }
	        submitLogin(event)
    	} catch (e) {
  			$('button').prop('disabled', false);
  			console.log(e.message);
  		}finally{
  			$('button').prop('disabled', false);
  		}
    });
    
    function submitLogin (e,redirect,cargarSaldoTA) {
    	let frm = $("#security_login_execute_authentication");
    	var recursive = false;
    	let url = frm.attr('action')!=undefined?frm.attr('action'):'security_login_session.html';
    	let type = frm.attr('method')!=undefined?frm.attr('method'):'post';
    	let data = frm.serialize()!=undefined?frm.serialize():'';
    	var paramCargarSaldoTA = "";
    	if(cargarSaldoTA!=undefined && cargarSaldoTA!=null && cargarSaldoTA!=''){
    		paramCargarSaldoTA = cargarSaldoTA;
    	}
    	var cadena = "";
        	  e.preventDefault();
        	  $.ajax({
		            type: type,
		            url: url,
		            async:false,
		            data: data+"&user="+$("#user").val()+"&password="+$("#password01").val()+"&urlRedirect5588="+$("#urlRedirect5588").val()+"&ref="+$("#ref").val(),
		            dataType: "json",
		            success: function(e){ 
		            	$("span#alertLogin").html("");
		            	if(e.lapolla!=null && $.trim(e.lapolla)!="" && (redirect==undefined || redirect==null)) {
                    		cadena = e.lapolla.split("|");
                    		window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1])+paramCargarSaldoTA,"_parent");
                    	} else if(e.tav2!=null && $.trim(e.tav2)!="" && (redirect==undefined || redirect==null)) {
                        	cadena = e.tav2.split("|");
                        	window.open($.trim(cadena[0])+"?authToken="+$.trim(cadena[1])+paramCargarSaldoTA,"_parent");
                    	} else {
			            	if (e.error == "OK"){
			            		closeModal();
			            		if(redirect!=undefined && redirect!=null && redirect!=''){
			            			if(redirect=='recharge.html'){
			            				$('body').append('<i id="cargando" class="loading" style="z-index: 2147483645 !important;"></i>');
			            				$('body').css('overflow-y', 'hidden');
			            			    $('body').append('<div id="div-lightbox-recharge-ilot"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlot(\'login\');" class="lightbox-recharge-ilot-close"></button><iframe id="frmLightboxRecharge" frameborder="0" src="recharge.html" class="lightbox-recharge" style="margin-top: 0px;" ></iframe></div>');
			            			}else{
			            				window.location.href = redirect;
			            			}
			            		}else{
			            			window.location.href = e.redirect;
			            		}
			            	} else if (e.error == "LG"){
			            		$("span#alertLogin").html(e.alertLogin);
			            		$("#user").val('');
			            		$("#password").val('');
//			            		setCaptcha();
			            	} else if (e.error=="MR"){
			            		 exe.openModal(e.content, "btn_mobile_home");
			            		 validatePastEmails()
			            	} else if (e.error=="AC"){
			            		exe.openModal(e.content, "btn_mobile_home");
			            		if (e.phone==null || e.phone=='') {
			            			$("#detailMessage").css("margin-bottom","-16px");
			            			$("#detailMessage").html("Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.<br/><br/><br/><br/>Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.");
			            			$('#containerSendSms').removeClass("hide");
			            		} else {	
			            			$('#containerSendCode').removeClass("hide");
			            		}
			            		smsSendMessage();
			            		smsCodeValidation();
			            		onlynumber();
			            		$('#alertCodeVerify').html(e.alertLogin);
			            	} else if (e.error == "TC"){
			            		$("span#alertLogin").html(e.alertLogin);
			            		openModal("#popup_terms_cond_login","btn_mobile_home");
			            	} else if(e.error == "IB") {
			            		var msgtext = '<div class="content-modal has-action over-visible ibb-span-text">' + e.content + '</div>';
			            		$('#popup .main-modal').html(msgtext);
					        	openModal("#popup", "btn_mobile_home");
					        	aceptBonusIBK();
					        	denyBonusIBK();
					        	tycBonus();
			            	} else if(e.error == "RD") {
			            		var msgtext = '<div class="content-modal has-action over-visible rdb-span-text">' + e.content + '</div>';
			            		$('#popup .main-modal').html(msgtext);
					        	openModal("#popup", "btn_mobile_home");
					        	aceptBonusRD();
					        	denyBonusRD();
					        	tycBonus();
			            	}
                    	}
		            }
		        });   	  
    }
    
    function submitLoginLP (e) {
    	var flag = false;
        var valid = true;
        var cadena = "";
        var baseUrl = "";
        var playerId = "";
        var operatorId = "";
        var authToken = "";
        var mensaje = "Ocurrió un problema inesperado [12].";
        e.preventDefault();
        $.ajax({
        	type: "post", 
        	url: "lapolla-login.html", 
        	dataType: "jsonp",
        	success: function(d){
        		$("span#alertLogin").html("");
	        	if(d.error === "OK" ) {
	        		flag = true;
	        		cadena = d.lapolla.split("|");
	        		if($.trim(cadena[0])!="") {
	                    baseUrl = $.trim(cadena[0]);
	                    authToken = $.trim(cadena[1]);
	    			} else {
	              		mensaje = "No se ha logrado ingresar";
	               	}
	        		closeModal();
	        	} else if(d.error === "TC") {
	        		valid = false;
	        		$("span#alertLogin").html(d.alertLogin);
            		openModal("#popup_terms_cond_login", "btn_mobile_home");
	            } else if(d.error === "AC") {
	            	valid = false;
	            	exe.openModal(d.content, "btn_mobile_home");
	            	$('#containerSendCode').removeClass("hide");
            		smsSendMessage();
            		smsCodeValidation();
            		onlynumber();
	            } else if(d.error === "MR") {
	            	valid = false;
	            	exe.openModal(d.content, "btn_mobile_home");
	            	validatePastEmails();
	            } else if(d.error === "IB") {
	            	valid = false;
	            	var msgtext = '<div class="content-modal has-action over-visible">' + d.content + '</div>';
            		$('#popup .main-modal').html(msgtext);
		        	openModal("#popup", "btn_mobile_home");
		        	aceptBonusIBK();
		        	denyBonusIBK();
		        	tycBonus();
	            } else if(d.error === "RD") {
	            	valid = false;
	            	var msgtext = '<div class="content-modal has-action over-visible">' + d.content + '</div>';
            		$('#popup .main-modal').html(msgtext);
		        	openModal("#popup", "btn_mobile_home");
		        	aceptBonusRD();
		        	denyBonusRD();
		        	tycBonus();
	            } else {
	            	$("span#alertLogin").html(d.alertLogin);
	            }
	        	if(flag && valid) {
	        		window.open(baseUrl+"?authToken="+authToken,"_parent");
	            } else if(valid) {
	            	$("#btnOut").bubble(mensaje, 10000);
	            }
        	}
        });
    }
    
    function submitLoginTAN (e) {
    	var flag = false;
        var valid = true;
        var cadena = "";
        var baseUrl = "";
        var playerId = "";
        var operatorId = "";
        var authToken = "";
        var mensaje = "Ocurrió un problema inesperado [12].";
        let data = '';
        e.preventDefault();
        $.ajax({
        	type: "post", 
        	url: "tav2-login.html", 
        	dataType: "jsonp",
        	data: data+"&user="+$("#user").val()+"&password="+$("#password01").val()+"&urlRedirect5588="+$("#urlRedirect5588").val()+"&ref="+$("#ref").val(),
        	async:false,
        	success: function(d){
        		$("span#alertLogin").html("");
	        	if(d.error === "OK" ) {
	        		flag = true;
	        		cadena = d.tav2.split("|");
	        		if($.trim(cadena[0])!="") {
	                    baseUrl = $.trim(cadena[0]);
	                    authToken = $.trim(cadena[1]);
	    			} else {
	              		mensaje = "No se ha logrado ingresar";
	               	}
	        		closeModal();
	        	} else if(d.error === "TC") {
	        		valid = false;
	        		$("span#alertLogin").html(d.alertLogin);
            		openModal("#popup_terms_cond_login", "btn_mobile_home");
	            } else if(d.error === "AC") {
	            	valid = false;
	            	exe.openModal(d.content, "btn_mobile_home");
	            	$('#containerSendCode').removeClass("hide");
            		smsSendMessage()
            		smsCodeValidation()
            		onlynumber();
	            } else if(d.error === "MR") {
	            	valid = false;
	            	exe.openModal(d.content, "btn_mobile_home");
	            	validatePastEmails()
	            } else if(d.error === "IB") {
	            	valid = false;
	            	var msgtext = '<div class="content-modal has-action over-visible">' + d.content + '</div>';
            		$('#popup .main-modal').html(msgtext);
		        	openModal("#popup", "btn_mobile_home");
		        	aceptBonusIBK();
		        	denyBonusIBK();
		        	tycBonus();
	            } else if(d.error === "RD") {
	            	valid = false;
	            	var msgtext = '<div class="content-modal has-action over-visible">' + d.content + '</div>';
            		$('#popup .main-modal').html(msgtext);
		        	openModal("#popup", "btn_mobile_home");
		        	aceptBonusRD();
		        	denyBonusRD();
		        	tycBonus();
	            } else {
	            	$("span#alertLogin").html(d.alertLogin);
	            }
	        	if(flag && valid) {
	        		window.open(baseUrl+"?authToken="+authToken,"_parent");
	            } else if(valid) {
	            	$("#btnOut").bubble(mensaje, 10000);
	            }
        	}
        });
    }
  //CONFIRMA TYC
    $(document).delegate('#client_confirm_agreement', 'click', function (event) {
    	event.preventDefault();
    	var state = false;
	    $.ajax({
	        type: 'POST',
	        async:false,
	        url: 'confirma-tyc.html',
	        dataType: 'json',
	        success: function (e) {
		            	if(e.state===1) {
		            		state=true;
		            	} else {
		            		closeModal();
		            		$('#alertVerify').html(e.message);
		            	}
	           		}
		});
    	if(state) {submitLogin(event);}
    });
    
    function validatePastEmails(){
    	var recursive = false;
    	$('#btn-send-user-verify-account').click(function (event){
    		var emailPattern = new RegExp(/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/);
            var emailRes = emailPattern.test($('#email-usr').val());

            if(!emailRes){
                $('#alertVerify').html("Ingrese un e-mail v&aacute;lido");
				return false;
	        }

            var $frm = $("#frm-user-send-verify-account");
    
            event.preventDefault();
	        	  $.ajax({
			            type: $frm.attr('method'),
			            url: $frm.attr('action'),
			            data: $frm.serialize(),
			            async:false,
			            dataType: $frm.data('response-type'),
			            success: function(e){ 
			            	$('#alertNotify').html("");
			            	$('#alertVerify').html("");
			            		if(e.status!=1){
			            			$('#alertVerify').html(e.message);
			            		} else {
			            			recursive= true;
			            		}
				            }
			            });
	        	  if(recursive) submitLogin(event);
			}); 
    }
    function onlynumber(){
    	$(document).on("keypress", "#send-code, #telf-sms", function(event) {
            if(event.which != 8 && event.which != 0 && (event.which < 48 || event.which > 57)) return false;
    	});
    } 
    function smsSendMessage(){

   	 $('#btn-send-sms-validation').click(function (event){
   		event.preventDefault();
	   		 var telefono = $.trim($('#telf-sms').val());
	   		 var telfPattern = new RegExp(/^([9]{1})([0-9]{8})$/);
	   		 var telfRes = telfPattern.test(telefono);
   		 
               if(!telfRes){
	                $('#alertTelfVerify').html("Ingrese un tel&eacute;fono v&aacute;lido");
					return false;
		        }

               var $frm = $("#frm-user-active-sms");
       
               event.preventDefault();
		        	  $.ajax({
				            type: $frm.attr('method'),
				            url: 'send-sms-validation.html',
				            data: $frm.serialize(),
				            async:false,
				            dataType: $frm.data('response-type'),
				            success: function(e){ 
				            	$('#alertTelfNotify').html("");
				            	$('#alertTelfVerify').html("");
				            		if(e.status!=200){
				            			$('#alertTelfVerify').html(e.message);
				            		} else {
				            			smsMessage = "Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.";
				            			viewSmsCode();
				            			recursive= true;
				            		}
					            }
				      });
   			});
    }
    
    function smsCodeValidation(){
    	$('#btn-send-code-validation').click(function (event){
    		var code = $.trim($('#send-code').val());

            if(code.toString().trim()==""){
                $('#alertCodeVerify').html("Ingrese un c&oacute;digo v&aacute;lido");
				return false;
	        }

            var $frm = $("#frm-user-active-sms");
    
          event.preventDefault();
    	  $.ajax({
	            type: $frm.attr('method'),
	            url: 'send-code-validation.html',
	            data: $frm.serialize(),
	            async:false,
	            dataType: $frm.data('response-type'),
	            success: function(e){ 
	            	$('#alertCodeNotify').html("");
	            	$('#alertCodeVerify').html("");
	            		if(e.status==1){
	            			closeModal();
	            			$("#confirmModal_content_id").html(e.message);
	            			$("#confirm_content").confirmModal({top : '30%', type : 'modal', onCancelBut: function(event, el) {} ,  onOkBut: function(event, el) {submitLogin(event);} });
		            	} else if(e.status==2){
		            		$('#alertCodeVerify').html(e.message);
	            		} else {
	            			$('#alertCodeVerify').html(e.message);
	            		}
		            }
	            });
			}); 

    }
    $(document).on('change', '.content-wrap .main-section input#chkactivatebond, .content-wrap .main-section input#chkactivatewbbond', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebond" && $(".content-wrap .main-section input#chkactivatewbbond").length>0 && $(".content-wrap .main-section input#chkactivatewbbond").is(":checked")) $(".content-wrap .main-section input#chkactivatewbbond").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbond" && $(".content-wrap .main-section input#chkactivatebond").length>0 && $(".content-wrap .main-section input#chkactivatebond").is(":checked")) $(".content-wrap .main-section input#chkactivatebond").prop("checked",!chk);
    });
    $(document).on('change', '#popup input#chkactivatebond, #popup input#chkactivatewbbond', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebond" && $("#popup input#chkactivatewbbond").length>0 && $("#popup input#chkactivatewbbond").is(":checked")) $("#popup input#chkactivatewbbond").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbond" && $("#popup input#chkactivatebond").length>0 && $("#popup input#chkactivatebond").is(":checked")) $("#popup input#chkactivatebond").prop("checked",!chk);
    });
    $(document).on('change', '#popup input#chkactivatebondibk, #popup input#chkactivatewbbondibk', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebondibk" && $("#popup input#chkactivatewbbondibk").length>0 && $("#popup input#chkactivatewbbondibk").is(":checked")) $("#popup input#chkactivatewbbondibk").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbondibk" && $("#popup input#chkactivatebondibk").length>0 && $("#popup input#chkactivatebondibk").is(":checked")) $("#popup input#chkactivatebondibk").prop("checked",!chk);
    });
    
    $(document).on("keypress", "#telf-sms", function (event) {
    	if($('#alertTelfVerify').text().length>0) $('#alertTelfVerify').text("");
    });
    $(document).on("keypress", "#send-code", function (event) {
    	if($('#alertCodeVerify').text().length>0) $('#alertCodeVerify').text("");
    });
    
    $(document).on("click", "#lnkActiveCode", function (event) {
        event.preventDefault();
        $('#alertCodeNotify').html("");
    	$('#alertCodeVerify').html("");
        viewSmsCode()
    });
   
    $(document).on("click", "#lnkSendSms", function (event) {
        event.preventDefault();
        $('#alertCodeNotify').html("");
    	$('#alertCodeVerify').html("");
        viewSmsSend()
    });
    
    function viewSmsCode(){
    	$("#detailMessage").html(smsMessage);
    	$('#containerSendSms').addClass("hide");
		$('#containerSendCode').removeClass("hide");
		$('#send-code').val("");
    }
    function viewSmsSend(){
    	//$("#detailMessage").html(smsMessage);
    	smsMessage=$("#detailMessage").html();
    	//$("#detailMessage").html("Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.");
    	$("#detailMessage").html("Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS.<br/><br/>Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.");
    	$('#containerSendCode').addClass("hide");
    	$('#containerSendSms').removeClass("hide");
    	//$('#telf-sms').val("");
    }
    
    function tycBonus(){
    	$(document).on("click", "#lnkactivatewbbondrd, #lnkactivatewbbondib", function (event) {
    		$('#alertNotify').html("");
        	$('#alertVerify').html("");
    		if($('#popup .wrap-modal').length>0) {
    			$('#popup .main-modal').addClass('hide');
    			$('#popup .js-close-modal').addClass('hide');
    			$('#popup .wrap-modal').removeClass('hide');
    			$('#popup .wrap-modal #wbbono').removeClass('hide');
    			$('#popup .wrap-modal #ibono').addClass('hide');
    			$('#popup .js-back-modal').removeClass('hide');
    		}
        });
    	
    	$(document).on("click", "#lnkactivatebondrd, #lnkactivatebondib", function (event) {
    		$('#alertNotify').html("");
        	$('#alertVerify').html("");
    		if($('#popup .wrap-modal').length>0) {
    			$('#popup .main-modal').addClass('hide');
    			$('#popup .js-close-modal').addClass('hide');
    			$('#popup .wrap-modal').removeClass('hide');
    			$('#popup .wrap-modal #wbbono').addClass('hide');
    			$('#popup .wrap-modal #ibono').removeClass('hide');
    			$('#popup .js-back-modal').removeClass('hide');
    		}
        });
    }
    
    function aceptBonusRD(){
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
                    async:false,
                    dataType: "jsonp",
                    success: function (e) {
                    	$('#alertNotify').html("");
		            	$('#alertVerify').html("");
                    	if(e.status===1) {
                    		closeModal();
                    		$("#confirmModal_content_id").html(e.message);
    						$("#confirm_content").confirmModal({top : '30%', type : 'modal', onCancelBut: function(event, el) {} ,  onOkBut: function(event, el) {submitLogin(event);} });
                    	} else {
		            		$('#alertVerify').html(e.message);
                    	}
                    }, 
                });
            } else {
            	$('#alertVerify').html("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
            	return false;
            }
        });
    }
    
    function denyBonusRD(){
    	$(document).on("click", "#btndenyb", function (event) {
        	event.preventDefault();
        	var item = $(this).data("balance");
            if(item!=""){
            	$.ajax({
            		type: "post",
                    url: "cancel-promotion.html",
                    data: "balanceItem=" + item,
                    async:false,
                    dataType: "jsonp",
                    success: function (e) {
                    	$('#alertNotify').html("");
		            	$('#alertVerify').html("");
                    	if(e.status===1) {
                    		closeModal();
                    		$("#confirmModal_content_id").html(e.message);
    						$("#confirm_content").confirmModal({top : '30%', type : 'modal', onCancelBut: function(event, el) {} ,  onOkBut: function(event, el) {submitLogin(event);} });
                    	} else {
		            		$('#alertVerify').html(e.message);
                    	}
                    }, 
                });
            	
            } else {
            	$('#alertVerify').html("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.");
            	return false;
            }
        });
    	
    	$(document).on("click", "#btncloseb", function (event) {
    		event.preventDefault();
    		closeModal();
        	submitLogin(event);
    	});
    }
    
    function aceptBonusIBK(){
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
                    async:false,
                    dataType: "jsonp",
                    success: function (e) {
                    	$('#alertNotify').html("");
		            	$('#alertVerify').html("");
                    	if(e.status===1) {
                    		closeModal();
                    		$("#confirmModal_content_id").html(e.message);
    						$("#confirm_content").confirmModal({top : '30%', type : 'modal', onCancelBut: function(event, el) {} ,  onOkBut: function(event, el) {submitLogin(event);} });
                    	} else {
		            		$('#alertVerify').html(e.message);
                    	}
                    }, 
                });
            } else {
            	$('#alertVerify').html("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.", null);
            	return false;
            }
        });
    }
    
    function denyBonusIBK(){
    	$(document).on("click", "#btndenybibk", function (event) {
        	event.preventDefault();
        	var item = $(this).data("balance");
            if(item!=""){
            	$.ajax({
            		type: "post",
                    url: "cancel-promotionibk.html",
                    data: "balanceItem=" + item,
                    async:false,
                    dataType: "jsonp",
                    success: function (e) {
                    	$('#alertNotify').html("");
		            	$('#alertVerify').html("");
                    	if(e.status===1) {
                    		closeModal();
                    		$("#confirmModal_content_id").html(e.message);
    						$("#confirm_content").confirmModal({top : '30%', type : 'modal', onCancelBut: function(event, el) {} ,  onOkBut: function(event, el) {submitLogin(event);} });
                    	} else {
		            		$('#alertVerify').html(e.message);
                    	}
                    }, 
                });
            	
            } else {
            	$('#alertVerify').html("Ha ocurrido un error. Refresque la p&aacute;gina y vuelva a intentarlo.");
            	return false;
            }
        });
    	
    	$(document).on("click", "#btnclosebibk", function (event) {
    		event.preventDefault();
    		closeModal();
        	submitLogin(event);
    	});
    }
    
    $('.popup .js-login-modal').click(function(event){
    	event.preventDefault();
    	submitLogin(event);
    });
    
    $("#lnkInicio").click(function(event) {
    	submitLogin(event);
    });
    
    $("#lnkCargarSaldo").click(function(event) {
    	submitLogin(event,'recharge.html');
    });
    
	$("#lnkCargarSaldoTA").click(function(event) {
    	submitLogin(event,null,'&cargarSaldo=true');
    });

    $(document).delegate('#resgisterUser', 'click', function (e) {
    	var ico = $(this).siblings('i');

        e.preventDefault();
        $.ajax({
            type: $("#client_lotocard_register_form").attr('method'),
            url: $("#client_lotocard_register_form").attr('action'),
            dataType: $("#client_lotocard_register_form").data('response-type'),
            data: $("#client_lotocard_register_form").serialize(),
            beforeSend: function () {
            	$(ico).addClass('loading');
            }
		}).done(function(d) {
       		if(d.status==5587){
//       			closeModal();
//   			    $("div#alert").html("");
//   				$("#confirmModal_content_id").html(d.message);
//   				$("#confirm_content").confirmModal({top:'30%',type:'modal',onCancelBut:function(event,el){},onOkBut:function(event,el){submitLoginLP(event);}});
   				closeModal();
   			    $("div#alert").html("");
	   			var mobilePhone = $("#mobilePhone").val(); 
   			    $.ajax({
	   	          type: 'post',
	   	          url: 'send-sms-validation.html',
	   	          data: "telf-sms="+mobilePhone,
	   	          async:false,
	   	          dataType:'jsonp',
	   	          success: function(e){ 
	
	   		      }
			   	 });
   			    
   			    location.href = "activar.html";
       		} else if(d.status==5588) {
//       			closeModal();
//   			    $("div#alert").html("");
//   				$("#confirmModal_content_id").html(d.message);
//   				$("#confirm_content").confirmModal({top:'30%',type:'modal',onCancelBut:function(event,el){},onOkBut:function(event,el){submitLoginTAN(event);}});
   				closeModal();
   			    $("div#alert").html("");
	   			var mobilePhone = $("#mobilePhone").val(); 
   			    $.ajax({
	   	          type: 'post',
	   	          url: 'send-sms-validation.html',
	   	          data: "telf-sms="+mobilePhone,
	   	          async:false,
	   	          dataType:'jsonp',
	   	          success: function(e){ 
	
	   		      }
			   	 });
   			    
   			    location.href = "activar.html";
       		} else if(d.status==200) {
   				closeModal();
   			    $("div#alert").html("");
	   			var mobilePhone = $("#mobilePhone").val(); 
   			    $.ajax({
	   	          type: 'post',
	   	          url: 'send-sms-validation.html',
	   	          data: "telf-sms="+mobilePhone,
	   	          async:false,
	   	          dataType:'jsonp',
	   	          success: function(e){ 
	
	   		      }
			   	 });
   			    
   			    location.href = "activar.html";
   			} else {
   				closeModal();
   			    $("div#alert").html("");
   				$("#confirmModal_content_id").html(d.message);
   				$("#confirm_content").confirmModal({top:'30%',type:'modal',onCancelBut:function(event,el){},onOkBut:function(event,el){submitLogin(event);}});
   			}
       			
        }).fail(function() {
        	$('#popup .main-modal').html("<div class='info'></div><p>&iexcl;Ocurri&oacute; un problema inesperado! \nPor favor int&eacutentelo nuevamente.</p>");
        	openModal("#popup","");
        	$("div#alert").html("");
        }).always(function() {
        	$(ico).removeClass('loading');
        });
    });

    function cleanRegister(){
    	$("#name").val("");
    	$("#lastname").val("");
    	$("#maidenname").val("");
    	$("#email").val("");
    	$("#dateBirth").val("");
    	$("#user").val("");
    	$("#password01").val("");
    	$("#password02").val("");
    	$("#numberDoc").val("");
    	$("#mobilePhone").val("");
    	$("#typeDoc").val("DNI");
    }
    //VALIDA MAYORIA DE EDAD     
    function validateDate(cadena) {
        var currentDt = new Date();
        var yr1 = parseInt(cadena.substring(0, 4), 10);
        var mon1 = parseInt(cadena.substring(5, 7), 10);
        var dt1 = parseInt(cadena.substring(8, 10), 10);
        var date = currentDt.getDate();
		var month = currentDt.getMonth() + 1;
		var year = currentDt.getFullYear();
		var age = year - yr1;
		if(mon1 > month) age--;
		else if(mon1 == month && dt1 >= date) age--;
        
		return age < 18;
    }
    function validarEmail(valor) {
        var exr = /^[0-9a-z_\-\.]+@[0-9a-z\-\.]+\.[a-z]{2,4}$/i;
        return !exr.test(valor);
    }
    $(document).delegate('#addCombination', 'click', function () {
        count_combination = 0;
        document.forms["game_teapuesto_add_combined"].submit();
    });
    $(document).delegate('#addMultiply', 'click', function () {
        count_multiply = 0;
        document.forms["game_teapuesto_add_multiplier"].submit();
    });
    $(document).delegate('#addConsecutiveTinkamegabol', 'click', function () {
        document.forms["game_tinkamegabol_add_consecutive"].submit();
    });
    $(document).delegate('#addConsecutiveTinka', 'click', function () {
        document.forms["game_tinka_add_consecutive"].submit();
    });
    $(document).delegate('#addConsecutiveGanadiario', 'click', function () {
        document.forms["game_ganadiario_add_consecutive"].submit();
    });
    $(document).delegate('#addConsecutiveKabala', 'click', function () {
        document.forms["game_kabala_add_consecutive"].submit();
    })
});

/********* TE APUESTO *********/      
$(document).delegate('fieldset input[type=checkbox]', 'change', function (event) {
    if ($(this).attr('id').substring(0, 8) == 'multiply') {
        if ($(this).is(":checked")) {
            count_multiply++;
            if (count_multiply > 3) {
                $(this).attr('checked', false);
                count_multiply--;
            }
        } else {
            count_multiply--;
        }
    }

    if ($(this).attr('id').substring(0, 11) == 'combination') {
        if ($(this).is(":checked")) {
            count_combination++;
            if (count_combination > 3) {
                $(this).attr('checked', false);
                count_combination--;
            }
        } else {
            count_combination--;
        }
    }

    if ($(this).attr('id').substring(0, 11) == 'consecutive') {
        if ($(this).is(":checked")) {
            count_consecutive++;
            if (count_consecutive > 1) {
                $(this).attr('checked', false);
                count_consecutive--;
            }
        } else {
            count_consecutive--;
        }
    }
});

//TINKA MEGABOL TIPO JUGADA
$(document).delegate('#game_tinkamegabol_show_bet_a', 'click', function () {
    goTinkamegabolShowBet('a');
});
$(document).delegate('#game_tinkamegabol_show_bet_b', 'click', function () {
    goTinkamegabolShowBet('b');
});
$(document).delegate('#game_tinkamegabol_show_bet_c', 'click', function () {
    goTinkamegabolShowBet('c');
});
$(document).delegate('#game_tinkamegabol_show_bet_d', 'click', function () {
    goTinkamegabolShowBet('d');
});
function goTinkamegabolShowBet(game) {
    window.location.href = 'game_tinkamegabol_show_bet.html?play=' + game;
}

//TINKA JUGADA
$(document).delegate('#game_tinka_show_bet_a', 'click', function () {
    goTinkaShowBet('a')
});
$(document).delegate('#game_tinka_show_bet_b', 'click', function () {
    goTinkaShowBet('b');
});
$(document).delegate('#game_tinka_show_bet_c', 'click', function () {
    goTinkaShowBet('c');
});
$(document).delegate('#game_tinka_show_bet_d', 'click', function () {
    goTinkaShowBet('d');
});
function goTinkaShowBet(game) {
    window.location.href = 'game_tinka_show_bet.html?play=' + game+'&cart=go';
}
function okAlert(){
	location.reload();
}
//GANADIARIO TIPO JUGADA
$(document).delegate('#btn_mobile_juega_ahora_ganadiario', 'click', function () {
    goGanadiarioShowBet('a');
});
$(document).delegate('#game_ganadiario_show_bet_b', 'click', function () {
    goGanadiarioShowBet('b');
});
$(document).delegate('#game_ganadiario_show_bet_c', 'click', function () {
    goGanadiarioShowBet('c');
});
$(document).delegate('#game_ganadiario_show_bet_d', 'click', function () {
    goGanadiarioShowBet('d');
});
function goGanadiarioShowBet(game) {
    window.location.href = 'game_ganadiario_show_bet.html?play=' + game+'&cart=go';
}

//KABALA TIPO JUGADA
$(document).delegate('#btn_mobile_jugar_ahora_kabala', 'click', function () {
    goKabalaShowBet('a');
});
$(document).delegate('#game_kabala_show_bet_b', 'click', function () {
    goKabalaShowBet('b');
});
$(document).delegate('#game_kabala_show_bet_c', 'click', function () {
    goKabalaShowBet('c');
});
$(document).delegate('#game_kabala_show_bet_d', 'click', function () {
    goKabalaShowBet('d');
});
function goKabalaShowBet(game) {
    window.location.href = 'game_kabala_show_bet.html?play=' + game+'&cart=go';
}

//GANAGOL
$(document).delegate('#addBetGanagol', 'click', function () {
    count_multiply = 0;
    var form = document.forms['game_ganagol_add_bet'];
    if ($(this).attr('next') != '') {
        var el = document.createElement("input");
        el.type = "hidden";
        el.name = "next";
        el.value = $(this).attr('next');
        form.appendChild(el)
    }
    form.submit()
});

$(document).delegate('#btn_mobile_marcar_jugada_ganagol', 'click', function () {
    window.location.href = 'game_ganagol_show_bet.html?play=' + $(this).attr('play');
});

function marcarJugadaGanagol(play){
	window.location.href = 'game_ganagol_show_bet.html?play=' + play;
}

//LOGIN
$(document).delegate('#btn_mobile_ingresar', 'click', function () {
    window.location.href = 'security_login_execute_authentication.html';
});

//CARRITO GANAGOL
$(document).delegate('#game_ganagol_show_shoppingcart', 'click', function () {
    window.location.href = 'game_ganagol_show_shoppingcart.html';
});

//CARRITO GANADIARIO
$(document).delegate('#game_ganadiario_show_shoppingcart', 'click', function () {
    window.location.href = 'game_ganadiario_show_shoppingcart.html';
});

//CARRITO TE APUESTO
$(document).delegate('#game_teapuesto_show_shoppingcart_resume', 'click', function () {
    window.location.href = 'game_teapuesto_show_shoppingcart_resume.html';
});

//CARRITO TINKA MEGABOL
$(document).delegate('#game_tinkamegabol_show_shoppingcart', 'click', function () {
    window.location.href = 'game_tinkamegabol_show_shoppingcart.html';
});

//CARRITO TINKA
$(document).delegate('#game_tinka_show_shoppingcart', 'click', function () {
    window.location.href = 'game_tinka_show_shoppingcart.html';
});

//CARRITO TINKA
$(document).delegate('#game_kabala_show_shoppingcart', 'click', function () {
    window.location.href = 'game_kabala_show_shoppingcart.html';
});

//CARRITO KINELO
$(document).delegate('#game_kinelo_show_shoppingcart', 'click', function () {
    window.location.href = 'game_kinelo_show_home.html';
});

//MIS DATOS
$(document).delegate('#client_account_show_information', 'click', function () {
    window.location.href = 'client_account_show_information.html';
});

//MI CUENTA CORRIENTE
$(document).delegate('#client_balance_show_information', 'click', function () {
    window.location.href = 'client_balance_show_information.html';
});

//MI CUENTA PROMO TE APUESTO
$(document).delegate('#client_balance_promo_te_apuesto_show_information', 'click', function () {
    window.location.href = 'client_balance_promo_te_apuesto_show_information.html';
});

//MI CUENTA BONO TE APUESTO
$(document).delegate('#client_balance_bono_te_apuesto_show_information', 'click', function () {
    window.location.href = 'client_balance_bono_te_apuesto_show_information.html';
});

//MI CUENTA BONO OTROS JUEGOS
$(document).delegate('#client_balance_bono_games_show_information', 'click', function () {
    window.location.href = 'client_balance_bono_games_show_information.html';
});

//MIS PREMIOS
$(document).delegate('#client_price_show_information', 'click', function () {
    window.location.href = 'client_price_show_information.html';
});

//MIS JUGADAS
$(document).delegate('#client_play_show_information', 'click', function () {
    window.location.href = 'client_play_show_information.html';
});

//CARGAR SALDO
$(document).delegate('#client_lotocard_show_information, #kabala-charge, #ganagol-charge, #ganadiario-charge, #tinka-charge, #kinelo-charge, #tinka-suscripcion-charge, #kabala-suscripcion-charge, #ganadiario-suscripcion-charge', 'click', function () {
	var button = $(this).attr('id');
	var marca = "logo-tinka.png";
	switch ($.trim(button)) {
		case 'client_lotocard_show_information': 
			marca = "logo-tinka.png";
			$("#close-button").trigger('click');
			break;
		case 'tinka-charge': 
		case 'tinka-suscripcion-charge': marca = "logo-tinka.png"; break;
		case 'kabala-charge': 
		case 'kabala-suscripcion-charge': marca = "logo-kabala.png"; break;
		case 'ganadiario-charge': 
		case 'ganadiario-suscripcion-charge': marca = "logo-ganadiario.png"; break;
		case 'ganagol-charge': marca = "logo-ganagol.png"; break;
		case 'kinelo-charge': marca = "logo-kinelo.png"; break;
	}
	
	$('body').append('<i id="cargando" class="loading" style="z-index: 2147483645 !important;"></i>');
	$('body').css('overflow-y', 'hidden');
	$('body').append('<div id="div-lightbox-recharge-ilot"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlot(\''+button+'\');" style="display: none;"></button><iframe id="frmLightboxRecharge" allowtransparency="true" frameborder="0" src="rechargei.html?marca='+marca+'" class="lightbox-recharge" style="margin-top: 0px;" ></iframe></div>');
});

//PUNTOS DE LA SUERTE DINAMICO
$(document).delegate('#client_lotocard_show_dynamicmap, #idMenuPoint,#idMenuPoint2', 'click', function () {
    window.location.href = 'client_lotocard_show_geolocation_dynamicmap.html';
});

$(document).delegate('#idBtnPuntosRedDigital', 'click', function () {
	window.open('http://mapa.intralot.com.pe','_blank');
});

$(document).delegate('#idBtnIbk', 'click', function () {
	window.open('https://interbank.pe/puntos-de-atencion?rfid=navegacion:menu-home:link', '_blank');
});

//PUNTOS DE LA SUERTE ESTATICO
$(document).delegate('#client_lotocard_show_staticmap', 'click', function () {
    window.location.href = 'client_lotocard_show_geolocation_staticmap.html';
});

//REGISTRATE
$(document).delegate('#client_lotocard_show_form', 'click', function () {
    window.location.href = 'client_lotocard_show_form.html';
});

//REGISTRATE
$(document).delegate('#btn_mobile_registrate, #client_lotocard_show_register', 'click', function () {
    window.location.href = 'client_lotocard_show_form.html';
});

//REGISTRATE
$(document).delegate('#security-close-session', 'click', function () {
    window.location.href = 'security-close-session.html';
});

//HOME, JUEGOS
$(document).delegate('#btn_mobile_home", #gamehtml', 'click', function () {
    window.location.href = 'home.html';
});

//HOME, JUEGOS
$(document).delegate('#q', 'click', function () {
    window.location.href = 'q.html';
});

//Blank
$(document).delegate('#android', 'click', function () {
    window.location.href = 'android.html';
});

//Blank
$(document).delegate('#blank', 'click', function () {
    window.location.href = 'blank.html';
});

//TINKAMEGABOL HOME
$(document).delegate('#game_tinkamegabol_show_menu', 'click', function () {
    window.location.href = 'game_tinkamegabol_show_menu.html';
});

//TEAPUESTO HOME
$(document).delegate('#btn_mobile_teapuesto_home', 'click', function () {
	//toIflex();
	toTAV2();
});

//DDVV HOME
$(document).delegate('#btn_mobile_ddvv_home', 'click', function () {
   //toIflex();
	window.location.href = 'game_virtuales_show_home.html';	
});

//GANAGOL HOME
$(document).delegate('#btn_mobile_ganagol_home', 'click', function () {
	var ico = $(this).siblings('i');
	$.ajax({
        type: 'post',
        url: 'routeLastPlayed.html',
        dataType: 'json',
        data: { game: "ganagol" },
	}).done(function(d) {
			if(d.message=='OK') {
	   		window.location.href = d.redireccion;

			} else $("div#alert").html(d.info);

    }).fail(function() {
    	$(ico).removeClass('loading');
    	$('#popup .main-modal').html("<div class='info'></div><p>&iexcl;Ocurri&oacute; un problema inesperado! \nPor favor int&eacutentelo nuevamente.</p>");
    	openModal("#popup","");
    	$("div#alert").html("");
    }).always(function() {
    });
});

//GANADIARIO HOME
$(document).delegate('#btn_mobile_ganadiario_home', 'click', function () {
	var ico = $(this).siblings('i');
	$.ajax({
        type: 'post',
        url: 'routeLastPlayed.html',
        dataType: 'json',
        data: { game: "ganadiario" },
	}).done(function(d) {
			if(d.message=='OK') {
	   		window.location.href = d.redireccion;

			} else $("div#alert").html(d.info);

    }).fail(function() {
    	$(ico).removeClass('loading');
    	$('#popup .main-modal').html("<div class='info'></div><p>&iexcl;Ocurri&oacute; un problema inesperado! \nPor favor int&eacutentelo nuevamente.</p>");
    	openModal("#popup","");
    	$("div#alert").html("");
    }).always(function() {
    });
});

//KABALA HOME
$(document).delegate('#btn_mobile_kabala_home', 'click', function () {
	var ico = $(this).siblings('i');
	$.ajax({
        type: 'post',
        url: 'routeLastPlayed.html',
        dataType: 'json',
        data: { game: "kabala" },
	}).done(function(d) {
			if(d.message=='OK') {
	   		window.location.href = d.redireccion;

			} else $("div#alert").html(d.info);

    }).fail(function() {
    	$(ico).removeClass('loading');
    	$('#popup .main-modal').html("<div class='info'></div><p>&iexcl;Ocurri&oacute; un problema inesperado! \nPor favor int&eacutentelo nuevamente.</p>");
    	openModal("#popup","");
    	$("div#alert").html("");
    }).always(function() {
    });
});

//SUPER3 HOME
$(document).delegate('#game_super3_show_result', 'click', function () {
    window.location.href = 'game_super3_show_result.html';
});

//EL REVENTON HOME
$(document).delegate('#game_elreventon_show_result', 'click', function () {
    window.location.href = 'game_elreventon_show_result.html';
});

//KINELO HOME
$(document).delegate('#btn_mobile_kinelo_home', 'click', function (event) {
	window.location.href = 'game_kinelo_show_home.html'
});

//FECHAZA HOME
$(document).delegate('#game_fechaza_show_result', 'click', function () {
    window.location.href = 'game_fechaza_show_result.html';
});

//RASPADITAS HOME
$(document).delegate('#btn_mobile_raspaya_home', 'click', function (event) {
	window.location.href = 'game_raspaya_show_home.html'
});

$(document).delegate('#btn_mobile_raspaditas_home', 'click', function (event) {
	window.location.href = 'game_raspaya_show_home.html'
});

$(document).delegate('#btn_mobile_casino_home', 'click', function (event) {
	window.location.href = 'game_casino_show_home.html'
});

$(document).delegate('#btn_mobile_casino_home_live', 'click', function (event) {
	window.location.href = 'game_casino_show_home.html?type=live'
});
//TINKA HOME
$(document).delegate('#btn_mobile_tinka_home', 'click', function () {
	var ico = $(this).siblings('i');
	$.ajax({
        type: 'post',
        url: 'routeLastPlayed.html',
        dataType: 'json',
        data: { game: "tinka" },
	}).done(function(d) {
			if(d.message=='OK') {
	   		window.location.href = d.redireccion;

			} else $("div#alert").html(d.info);

    }).fail(function() {
    	$(ico).removeClass('loading');
    	$('#popup .main-modal').html("<div class='info'></div><p>&iexcl;Ocurri&oacute; un problema inesperado! \nPor favor int&eacutentelo nuevamente.</p>");
    	openModal("#popup","");
    	$("div#alert").html("");
    }).always(function() {
    });
});

//LA POLLA HOME
function toLaPolla() {
	$.ajax({
        type: 'post',
        url: 'lapolla-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}
$(document).delegate('button.a_lapolla', 'click', function () {
	$.ajax({
        type: 'post',
        url: 'lapolla-nosession.html',
        dataType: 'json'
	}).done(function(d) {
		$(location).attr('href', d.redireccion);
    });
});

//LA POLLA HOME
function toTAV2() {
	$.ajax({
        type: 'post',
        url: 'tav2-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}
$(document).delegate('button.a_tav2', 'click', function () {
	$.ajax({
        type: 'post',
        data: 'redirectGame=TA',
        url: 'tav2-nosession.html',
        dataType: 'json'
	}).done(function(d) {
		$(location).attr('href', d.redireccion);
    });
});

$(document).delegate('button.a_tav2_ddvv', 'click', function () {
	$.ajax({
        type: 'post',
        data: 'redirectGame=DV',
        url: 'tav2-nosession.html',
        dataType: 'json'
	}).done(function(d) {
		$(location).attr('href', d.redireccion);
    });
});

function toDDVV() {
	//$(document).delegate('#game_tav2_show_menu', 'click', function () {
		$.ajax({
	        type: 'post',
	        url: 'ddvv-session.html',
	        dataType: 'json'
		}).done(function(d) {
			if(d.message=="OK") {
				window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
			} else $(location).attr('href', d.redireccion);
	    });
	//});
	}
//OTRO HOME
$(document).delegate('#game_otro_show_menu', 'click', function () {
	return false;
});

//HELP HOME
$(document).delegate('#helphtml', 'click', function () {
    window.location.href = 'help.html';
});

//JUGAR TINKAMEGABOL
$(document).delegate('#game_tinkamegabol_play_bet', 'click', function () {
    window.location.href = 'game_tinkamegabol_play_bet.html';
});

//JUGAR TE APUESTO
$(document).delegate('#game_teapuesto_play_bet', 'click', function () {
    window.location.href = 'game_teapuesto_play_bet.html';
});

//JUGAR GANADIARIO
$(document).delegate('#game_ganadiario_play_bet', 'click', function () {
    window.location.href = 'game_ganadiario_play_bet.html';
});

//NUEVO JUGAR GANADIARIO
$(document).delegate('#btn_mobile_comprar_boleto_ganadiario', 'click', function () {
    window.location.href = 'game_ganadiario_play_bet_result.html';
});

//JUGAR GANAGOL
$(document).delegate('#game_ganagol_play_bet', 'click', function () {
    window.location.href = 'game_ganagol_play_bet.html';
});

//NUEVO JUGAR GANAGOL
$(document).delegate('#btn_mobile_comprar_ganagol', 'click', function () {
    window.location.href = 'game_ganagol_play_bet_result.html';
});

//JUGAR TINKA
$(document).delegate('#game_tinka_play_bet', 'click', function () {
    window.location.href = 'game_tinka_play_bet.html';
});

//NUEVO JUGAR TINKA
$(document).delegate('#btn_mobile_comprar_boleto_tinka', 'click', function () {
    window.location.href = 'game_tinka_play_bet_result.html';
});

//JUGAR KABALA
$(document).delegate('#game_kabala_play_bet', 'click', function () {
    window.location.href = 'game_kabala_play_bet.html';
});

//NUEVO JUGAR KABALA
$(document).delegate('#btn_mobile_comprar_kabala', 'click', function () {
    window.location.href = 'game_kabala_play_bet_result.html';
});


// LOGUEO ANTES DE JUGAR
$(document).delegate('#security_login_execute_authentication_tinkamegabol', 'click', function () {
    goSecurityLoginExecute('tinkamegabol');
});

$(document).delegate('#security_login_execute_authentication_tinka', 'click', function () {
    goSecurityLoginExecute('tinka');
});

$(document).delegate('#security_login_execute_authentication_teapuesto', 'click', function () {
    goSecurityLoginExecute('teapuesto');
});

$(document).delegate('#security_login_execute_authentication_ganadiario', 'click', function () {
    goSecurityLoginExecute('ganadiario');
});

$(document).delegate('#security_login_execute_authentication_ganagol', 'click', function () {
    goSecurityLoginExecute('ganagol');
});

$(document).delegate('#security_login_execute_authentication_kabala', 'click', function () {
    goSecurityLoginExecute('kabala');
});

$(document).delegate("#pnl-comunication","click",function(){
	$("#pnl-comunication").addClass("disable");
	$("#pnl-information").removeClass("disable");
});

function goSecurityLoginExecute(game) {
    window.location.href = 'security_login_execute_authentication.html?display=' + game;
}

function toIflex() {
	if (iflexWin != null) iflexWin.close();
	var baseUrl = "";
	var playerId = "";
	var language = "";
	var operatorId = "";
	var authToken = "";
	var currency = "";
	var flag = false;
	$.ajax({
		type: "post",
		url: "iflex_launch.html",
		data: "channel=1",
		dataType: "text",
		global: false,
		async: false,
		success: function (e) {
			var cadena = "";
			if (e != null && e != "") {
				cadena = e.split("|");
				mensaje = (cadena[6].trim() != "null") ? cadena[6].trim() : "";
				baseUrl = cadena[0].trim();
				if (mensaje == "LOGGED") {
					flag = true;
					language = cadena[1].trim();
					operatorId = cadena[2].trim();
					currency = cadena[3].trim();
					playerId = cadena[4].trim();
					authToken = cadena[5].trim();
				}
			}
		}
	});
	if (flag === true) {
		var url = baseUrl + "?playerId=" + playerId + "&language=" + language + "&operatorId=" + operatorId + "&authToken=" + authToken + "&currency=" + currency;
		iflexWin = window.open(url, "_self");
	} else {
		iflexWin = window.open(baseUrl, "_self");
	}
	return false;
}

function rechargeLotocard(e,actwbbono){
	var cadena = "";
	var baseUrl = "";
	var authToken = "";
	console.log(e.attr('action'));
	$.ajax({
        type: e.attr('method'),
        url: e.attr('action'),
        data: e.serialize(),
        success: function (data) {
        	$("#numberCard").val("");
        	if(data.lapolla!=null && $.trim(data.lapolla)!="" && data.indicador == 1) {
        		cadena = data.lapolla.split("|");
        		window.open($.trim(cadena[0]),"_parent");
        	} else if(data.tav2!=null && $.trim(data.tav2)!="" && data.indicador == 1) {
            	cadena = data.tav2.split("|");
				baseUrl = $.trim(cadena[0]);
				authToken = $.trim(cadena[1]);
				window.open(baseUrl+"?authToken="+authToken,"_parent");				
        	} else {
            	$("#header .text-money:eq(0) span").text(data.newamount);
            	$("#header .text-money:eq(1) span").text(data.bonusAmount);
            	$("#header .text-money:eq(2) span").text(data.bonusOther);
                $("#mi-saldo").text(data.newamount);
                $("#mi-saldo-bono").text(data.bonusAmount);
                $("#mi-otro-bono").text(data.bonusOther);
                if(data.message!=undefined && data.message!=null && data.message==="OK"){
                	if(actwbbono==true) $('.content-wrap .wb-saldo').text("");
                }
                alertMessage(data.alertPrepaidCard);
        	}
        },
        error: function (data) {
            console.log('An error occurred.');
        },
    });
}

/*
function showButtonClose(){
	var btn = document.getElementById('frmLightboxRecharge').contentWindow.document.getElementById('lightbox-recharge-ilot-pop-close');
	btn.classList.add("showClose");
}
*/

/*
function hideButtonClose(){
	$("#lightbox-recharge-ilot-close").trigger('click');
}
*/

function closeLightboxRechargeIlot(button){	
	$('body').css('overflow-y', 'scroll');
	$('body').find('#div-lightbox-recharge-ilot').remove();
	$('body').find('#cargando').remove();
	
	$.ajax({
        type: "POST",
        url: "load_recharge.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	$("#clientSale-amount").text("S/ "+floatFormat(data.billetera1));
        	$("#billetera2-amount").text(data.billetera2);
        	$("#billetera3-amount").text(data.billetera3);
        	$("#clientSale-amount-menu-lateral").text("S/ "+floatFormat(data.billetera1));
        }
	});
	
	switch ($.trim(button)) {
		case 'kabala-charge': 
			window.location.href = 'game_kabala_show_shoppingcart.html';
			break;
		case 'kabala-suscripcion-charge': 
			window.location.href = 'game_kabala_show_shoppingcart_suscripcion.html?boleto='+$("#tipoBoletoSuscripcion").val();
			break;
		case 'ganadiario-charge': 
			window.location.href = 'game_ganadiario_show_shoppingcart.html';
			break;
		case 'ganadiario-suscripcion-charge': 
			window.location.href = 'game_ganadiario_show_shoppingcart_suscripcion.html?boleto='+$("#tipoBoletoSuscripcion").val();
			break;
		case 'tinka-charge': 
			window.location.href = 'game_tinka_show_shoppingcart.html';
			break;
		case 'tinka-suscripcion-charge': 
			window.location.href = 'game_tinka_show_shoppingcart_suscripcion.html?boleto='+$("#tipoBoletoSuscripcion").val();
			break;
		case 'kinelo-charge': 
			window.location.href = 'game_kinelo_show_home.html';
			break;
		case 'ganagol-charge': 
			window.location.href = 'game_ganagol_show_shoppingcart.html';
			break;
		case 'login': break;
	}
}

function floatFormat(number) {
	  number = number += '';
	  var x1 = '',
	    x2 = '',
	    rgx = /(\d+)(\d{3})/;
	  if (number !== '') {
	    var x = number.split('.');
	    x1 = x[0];
	    if (x[1] != undefined) {
	      x[1] = x[1].length < 2 ? x[1] + '0' : x[1]
	    } else {
	      x[1] = '00'
	    }
	    x2 = x.length > 1 ? '.' + x[1] : '';
	    while (rgx.test(x1)) {
	      x1 = x1.replace(rgx, '$1' + ',' + '$2')
	    }
	  }
	  return x1 + x2
}

function loadRecharge(){
	$.ajax({
        type: "POST",
        url: "load_recharge.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	$("#clientSale-amount").text("S/ "+floatFormat(data.billetera1));
        	$("#billetera2-amount").text(data.billetera2);
        	$("#billetera3-amount").text(data.billetera3);
        }
	});
}

var gCount = 0;

//function setCaptcha(){
//	try {
//		$("#imagen").attr("src","captcha.html?accion=" + gCount);
//		gCount = gCount + 1;
//	} catch (e) {
//		console.log(e.message);
//	}
//}

function handleMessage(e) {
	var operacion = e.data;
	if(operacion==='hideButtonClose'){
		$("#lightbox-recharge-ilot-close").trigger('click');
	}
}

function newsKabala(epochTimeNewsKabala, nowEpochKabala){
	if(nowEpochKabala >= epochTimeNewsKabala){	
		$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
		$('body').css('overflow-y', 'hidden');
		$('body').append('<div id="div-lightbox-recharge-ilot"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxNewsKabala();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" allowtransparency="true" frameborder="0" src="newsKabala.html" class="lightbox-recharge" ></iframe></div>');
	}
}

function closeLightboxNewsKabala(){
	$('body').find('#loading-ilot').remove();	
	$('body').css('overflow-y', 'scroll');
	$('body').find('#div-lightbox-recharge-ilot').remove();
	
}
