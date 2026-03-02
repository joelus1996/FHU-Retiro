;
var runPay = {
	setup: function () {
		var bcpMinAmount = ((chdata.bcpMinAmount!=null && chdata.bcpMinAmount!='' && !isNaN(chdata.bcpMinAmount))?parseFloat(chdata.bcpMinAmount):10);
		var sfpyMinAmount = ((chdata.sfpyMinAmount!=null && chdata.sfpyMinAmount!='' && !isNaN(chdata.sfpyMinAmount))?parseFloat(chdata.sfpyMinAmount):40);
		var pefeMinAmount = ((chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40);
		$("#bcp-amount").val(bcpMinAmount);
		$("#safetypay-valor").val(sfpyMinAmount);
		$("#safetypay-val").val(sfpyMinAmount);
		$("#pagoEfectivo-valor").val(pefeMinAmount);
		$("#pagoEfectivo-val").val(pefeMinAmount);
		$("#pagoEfectivo-label").text(pefeMinAmount);
		$("#pagoEfectivo-lbl").text(pefeMinAmount);
	},
    openPreviewWindowVPos: function (amount, mode) {
        var paramValues = '?';
        paramValues += 'pos-amount=' + amount;
        paramValues += '&pos-mode=' + mode;
        var title = 'CARGA SALDO CON TUS TARJETAS DE CRÉDITO O DÉBITO';
        dhtmlwindow.open('resultbox', 'iframe', 'cuenta-vpos.html' + paramValues, title, 'width=740,height=530,scrolling=0,center=1,resize=0', 'recal');
    },
    grillaCode: function (amount, transact, actwbbono) {
        var data = '';
        var message = '';
        var newamount = 0.0;
        var msgres = [];
        $.ajax({
            type: "post",
            url: "verifica-codigo-bcp.html",
            dataType: "text",
            data: "bcp-amount=" + amount + "&bcp-transact=" + transact + "&activ-wbbono=" + actwbbono,
            global: false,
            async: false,
            success: function (e) {
                msgres = $.trim(e.toString()).split("|||");
                data = msgres[0];
                message = msgres[1];
                newamount = floatFormat(msgres[2]);
                $("#clientSale-amount").text(floatFormat(newamount));
                $("#field-balance-amount").text(newamount);
                //if(actwbbono==true) $('#content-tab-item_4 .wb-saldo').text("");
            }
        });
        var grilla = "<div id='grilla_bcp'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>CÓDIGO</div>" + "<div class='head_title_3'>MONTO S/.</div>" + "<div class='head_title_4'>Fec.EXPIRACIÓN</div>" + "<div class='head_title_5'>ESTADO</div>" + "<div class='head_title_6'>ANULAR</div>" + "</div>";
        var fila = data.split("||");
        if (fila.length > 0 && fila[0] != '') {
            for (var n = 0; n < fila.length; n++) {
                var items = fila[n].split("|");
                if (items.length > 0) {
                    var style = "row_grid";
                    if (n % 2 != 0) {
                        style += " row_grid_mouseover";
                    }
                    grilla += "<div class='" + style + "'><div class='column_1'>" + (n + 1) + "</div><div class='column_2'>" + items[0] + "</div><div class='column_3'>" + items[1] + "</div><div class='column_4'>" + items[2] + "</div>";
                    if (items[3] === "OKK") {
                        grilla += "<div class='column_5'><a href='#' class='button_verificar' onclick='runPay.grillaCode(\"\",\"\",\"\")'></a></div>";
                    } else if (items[3] === "PEN") {
                        grilla += "<div class='column_5 verify btn-verificar'></div>";
                    } else if (items[3] === "ACT") {
                        grilla += "<div class='column_5'>PAGADO</div>";
                    } else if (items[3] === "ANU") {
                        grilla += "<div class='column_5'>ANULADO</div>";
                    } else if (items[3] === "CAD") {
                        grilla += "<div class='column_5'>CADUCADO</div>";
                    }
                    if (items[3] === "OKK") grilla += "<div class='column_6'></div>";
                    else if (items[3] === "PEN") grilla += "<div class='column_6'><div class='button_anular' data-pin='" + items[4] + "'></div></div>";
                    grilla += "</div>";
                }
            }
            grilla += "</div></div>";
            $('#content-grid-pin').html(grilla);
        } else if($.trim(amount)!='' && $.trim(message)!='') jAlert(message);
    }
};
var chdata = ($('#chargeData').length>0 && ($.trim($('#chargeData').val()) != '') ? $.parseJSON($.trim($('#chargeData').val())) : '');
var cbalance = ($('#clientBalance').length>0 && ($.trim($('#clientBalance').val()) != '') ? $.parseJSON($.trim($('#clientBalance').val())) : '');

var content_tab_item = "";
var tab_item = "";

var $loadBalanceGame = function () {
	runPay.setup();
    $('#btncargar1').on('click', function (event) {
        event.preventDefault();
        if ($('[name=pin-number]').val().length < 1) {
            jAlert('Ingresa el código')
        } else {
        	cargar1();
        }
    });
    function cargar1() {
    	var option = $("[name=option-card]:checked").val();
        var pin = $.trim($("[name=pin-number]").val());
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        var gamecode = $("#game-code-purchase").val();
        var message = "hello";
        var amount = 0.0;
        var newamount = 0.0;
        var promotionMessage = "";
        $.ajax({
            type: "POST",
            url: "recarga_lotocard.html",
            dataType: "json",
            data: "option-card=" + option + "&pin-number=" + pin + "&activ-wbbono=" + actwbbono + "&gamecode=" + gamecode,
            global: false,
            async: false,
            success: function (data) {
                message = data.message;
                amount = data.amount;
                newamount = data.newAmount;
                promotionMessage = data.promotionMessage;
                $("[name=pin-number]").val('');
                $("#clientSale-amount").text(floatFormat(newamount));
                if($.trim(data.bonusAmount) != "") $("#billetera2-amount").text(data.bonusAmount);
            	$(".result5").html("S/ "+floatFormat((!isNaN(data.gameAmount))?data.gameAmount:"0"));
                $(".label_resu5").html("Bonos "+data.gameName+":");
                if($.trim(data.bonusOther) != "") $("#billetera3-amount").text(data.bonusOther);
                $("#field-balance-amount").text(floatFormat(newamount));
                //$('#content-tab-item_4 .wb-saldo').html($.trim(data.wbMessage));
                if(actwbbono==true) $('#content-tab-item_4 .wb-saldo').text("");
                message = message.replace(/_/g, ' ');
                if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
                    promotionMessage = "";
                }
                if (message === "OK") {
                    if (option == 1) {
                    	if($.trim(actwbbono)=='true') {
                            if (promotionMessage.includes("insuficiente") == true ) {
                                alertmsg = promotionMessage + "\n\nLa recarga ha sido abonada a su saldo principal.\n\nMonto cargado: S/ " + amount ;                                  
                            } else {
                                alertmsg = "Se ha realizado una recarga con éxito a su saldo.\n\nMonto cargado: S/ " + amount + "\n" + promotionMessage;                               
                            }
                        } else {
                                alertmsg = "Se ha realizado una recarga con éxito a su saldo.\n\nMonto cargado: S/ " + amount + "\nTu saldo disponible es: S/ " + newamount + "\n" + promotionMessage;
                        }
                    	jAlert(alertmsg);
                    }
                    $('#option-card-0').prop('checked', true).change();
                } else {
                    if (option == 1) {
                        jAlert("No se ha logrado realizar la recarga.\n" + message + "\n\nMonto cargado: S/. " + amount + "\nTu saldo disponible es: S/. " + newamount, null);
                    }
                }
            }
        })
    }
    $('#content-grid-pin').on('click', '.verify', function (event) {
        var pin = $.trim($(this).siblings('.column_2').text());
        var $btnVerificar = $(this);
        var amount = $("#clientSale-amount").text();
        var gamecode = $("#game-code-purchase").val();
        $.ajax({
            type: "GET",
            url: "verificar.html",
            dataType: "json",
            data: {
                pin: pin,
                amount: amount,
                gamecode: gamecode
            },
            success: function (data) {
                if (data.state === 'OK') {
                    $("#clientSale-amount").text(floatFormat(data.amount));
                    if($.trim(data.bonusAmount) != "") $("#billetera2-amount").text(data.bonusAmount);
                	$(".result5").html("S/ "+floatFormat((!isNaN(data.gameAmount))?data.gameAmount:"0"));
                    $(".label_resu5").html("Bonos "+data.gameName+":");
                    if($.trim(data.bonusOther) != "") $("#billetera3-amount").text(data.bonusOther);
                    $("#field-balance-amount").text(floatFormat(data.amount));
                    //$('#content-tab-item_4 .wb-saldo').html($.trim(data.wbMessage));
                    $btnVerificar.parents('.row_grid').remove();
                    jAlert(data.message);
                } else {
                    jAlert(data.message);
                }
            }
        })
    });
    $('#content-grid-pin').on('click', '.button_anular', function (event) {
        event.preventDefault();
        var $btnAnular = $(this);
        $.ajax({
            type: 'post',
            url: 'anular.html',
            dataType: 'text',
            data: {
                pin: $(this).data('pin')
            },
            success: function (data) {
                $btnAnular.parents('.row_grid').remove()
            }
        });
        if ($('#content-grid-pin').find('.button_anular').length == 1) {
            $('#grilla_bcp').html('');
        }
    });
    $('#btncargar2').on('click', function (event) {
        event.preventDefault();
        
        if(cbalance==""){
        	cbalance = ($('#clientBalance').length>0 && ($.trim($('#clientBalance').val()) != '') ? $.parseJSON($.trim($('#clientBalance').val())) : '');
        }

        var amount = $("[name=bcp-amount]").val();
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        var bcpMinAmount = ((chdata.bcpMinAmount!=null && chdata.bcpMinAmount!='' && !isNaN(chdata.bcpMinAmount))?parseFloat(chdata.bcpMinAmount):10);
        var bcpMaxAmount = ((chdata.bcpMaxAmount!=null && chdata.bcpMaxAmount!='' && !isNaN(chdata.bcpMaxAmount))?parseFloat(chdata.bcpMaxAmount):10000);
        if (amount < bcpMinAmount || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/ '+bcpMinAmount+' soles.', null);
            $("#bcp-amount").val(bcpMinAmount);
        } else if(amount > bcpMaxAmount) {
        	jAlert('Debe ingresar un monto de carga no mayor de S/ '+bcpMaxAmount+' soles.', null);
            $("#bcp-amount").val(bcpMinAmount);
        } else {
        	if($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==true && ($.trim(cbalance.bonusChannel)=="" || ($.trim(cbalance.bonusChannel)!="" && $.trim(cbalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(cbalance.wbStepAmount)!="" && parseFloat($.trim(cbalance.wbStepAmount))>parseFloat(amount))){
        			jConfirm("<p>Has activado el Bono de "+cbalance.welcomeBonusPercentaje+"%, pero con un monto menor a S/ "+cbalance.wbStepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){runPay.grillaCode(amount, '',actwbbono);}});
        	}else{
            	runPay.grillaCode(amount, '', actwbbono);
        	}
        }
    });
    $('#option-card-0').on('click', function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "479px"
        });
        $('.img_zona_segura').css({
            "margin-top": "9px"
        });
        $('#content-grid-pin').html('');
    });
    $('#option-card-1').on('click', function () {
        $("#panel_transaccion_1").show();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "519px"
        });
        $('.img_zona_segura').css({
            "margin-top": "9px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-2").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").show();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "549px"
        });
        $('.img_zona_segura').css({
            "margin-top": "9px"
        });
        runPay.grillaCode('', '', '');
    });
    $("#option-card-3").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").show();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "561px"
        });
        $('.img_zona_segura').css({
            "margin-top": "9px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-4").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").show();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "566px"
        });
        $('.img_zona_segura').css({
            "margin-top": "0px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-5").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").show();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "626px"
        });
        $('.img_zona_segura').css({
            "margin-top": "0px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-6").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").show();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "626px"
        });
        $('.img_zona_segura').css({
            "margin-top": "0px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-7").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").show();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "626px"
        });
        $('.img_zona_segura').css({
            "margin-top": "0px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-8").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").show();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "626px"
        });
        $('.img_zona_segura').css({
            "margin-top": "0px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-9").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").show();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "626px"
        });
        $('.img_zona_segura').css({
            "margin-top": "0px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-10").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").show();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "479px"
        });
        $('.img_zona_segura').css({
            "margin-top": "9px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-11").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").show();
        $("#panel_transaccion_12").hide();
        $('#content').css({
            "height": "479px"
        });
        $('.img_zona_segura').css({
            "margin-top": "9px"
        });
        $('#content-grid-pin').html('');
    });
    $("#option-card-12").click(function () {
        $("#panel_transaccion_1").hide();
        $("#panel_transaccion_2").hide();
        $("#panel_transaccion_3").hide();
        $("#panel_transaccion_4").hide();
        $("#panel_transaccion_5").hide();
        $("#panel_transaccion_6").hide();
        $("#panel_transaccion_7").hide();
        $("#panel_transaccion_8").hide();
        $("#panel_transaccion_9").hide();
        $("#panel_transaccion_10").hide();
        $("#panel_transaccion_11").hide();
        $("#panel_transaccion_12").show();
        $('#content').css({
            "height": "479px"
        });
        $('.img_zona_segura').css({
            "margin-top": "9px"
        });
        $('#content-grid-pin').html('');
    });
    
    $("#pagoEfecHelp").click(function (event) {
        var pagoEfectivoHelp = "layer-view-interface/client/como_funciona_pagoefectivo.jsp";
        event.preventDefault();
        dhtmlwindow.open('resultbox', 'iframe', pagoEfectivoHelp, '¿QUÉ ES PAGOEFECTIVO?', 'width=600,height=635px,scrolling=0,center=1,resize=0', 'recal');
    });
    
    $("#btncargar4").click(function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=pagoEfectivo-amount]").val());
        var pefeMinAmount = ((chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40);
        var pefeMaxAmount = ((chdata.pefeMaxAmount!=null && chdata.pefeMaxAmount!='' && !isNaN(chdata.pefeMaxAmount))?parseFloat(chdata.pefeMaxAmount):3000);
        if (amount < pefeMinAmount || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/. '+pefeMinAmount+' soles.', null);
            $("#pagoEfectivo-valor").val(pefeMinAmount);
        } else if (amount > pefeMaxAmount) {
            jAlert('Debe ingresar un monto de carga no mayor de S/. '+pefeMaxAmount+' soles.', null);
            $("#pagoEfectivo-valor").val(pefeMinAmount);
        } else {
        	cargar4();
        }
    });
    function cargar4() {
    	var posAmount = document.getElementById("pagoEfectivo-valor").value;
    	var actwbbono = $("#chkactivatewbbond").is(":checked");
    	$.ajax({
            type: "post",
            url: "portal_page.html",
            data: "posAmount=" + posAmount + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            global: false,
            async: false,
            success: function (redireccion) {
                if (redireccion != null && redireccion != "") {
                	if(actwbbono==true) $('#content-tab-item_4 .wb-saldo').text("");
                    $("#option-card-0").prop("checked", "checked");
                    $("#panel_transaccion_1").hide();
                    $("#panel_transaccion_2").hide();
                    $("#panel_transaccion_3").hide();
                    $("#panel_transaccion_4").hide();
                    $("#panel_transaccion_5").show();
                    $("#panel_transaccion_6").hide();
                    $("#panel_transaccion_7").hide();
                    dhtmlwindow.open('resultbox', 'iframe', redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal');
                } else {
                    jAlert("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
                }
            }
        })
    }
    $("#btncargar3, #btncargar5").click(function (event) {
        event.preventDefault();
        var amount = ($(this).attr("id")=="btncargar5")?parseInt($("[name=safetypay-amount]").val()):parseInt($("[name=safetypay-amnt]").val());
        //var actwbbono = $("#chkactivatewbbond").is(":checked");
        var sfpyMinAmount = ((chdata.sfpyMinAmount!=null && chdata.sfpyMinAmount!='' && !isNaN(chdata.sfpyMinAmount))?parseFloat(chdata.sfpyMinAmount):40);
        var sfpyMaxAmount = ((chdata.sfpyMaxAmount!=null && chdata.sfpyMaxAmount!='' && !isNaN(chdata.sfpyMaxAmount))?parseFloat(chdata.sfpyMaxAmount):9999);
        if (amount < sfpyMinAmount || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/ '+sfpyMinAmount+' soles.', null);
            $("#safetypay-valor").val(sfpyMinAmount);
            $("#safetypay-val").val(sfpyMinAmount);
        } else if (amount > sfpyMaxAmount) {
            jAlert('Debe ingresar un monto de carga no mayor de S/ '+sfpyMaxAmount+' soles.', null);
            $("#safetypay-valor").val(sfpyMinAmount);
            $("#safetypay-val").val(sfpyMinAmount);
        } else {
            var posAmount = ($(this).attr("id")=="btncargar5")?document.getElementById("safetypay-valor").value:document.getElementById("safetypay-val").value;
            var typeToken = ($(this).attr("id")=="btncargar5")?1:2;
            cargar3(posAmount, typeToken);
        }
    });
    function cargar3(posAmount, typeToken) {
    	var clientId = $("#clientId").val();
        var sessionId = $("#sesionId").val();
        var actwbbono = $("#chkactivatewbbond").is(":checked");
    	$.ajax({
            type: "post",
            url: "safety_page_post.html",
            data: "clientId=" + clientId + "&sessionId=" + sessionId + "&posAmount=" + posAmount + "&typeToken=" + typeToken + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            global: false,
            async: false,
            success: function (e) {
                if (e != null && e != "") {
                    var redireccion = (e + "").toString();
                    if (redireccion != null && redireccion != "") {
                    	if(actwbbono==true) $('#content-tab-item_4 .wb-saldo').text("");
                        dhtmlwindow.open('resultbox', 'iframe', redireccion, 'SAFETYPAY', 'width=963,height=670,scrolling=1,center=1,resize=0', 'recal');
                        $('#resultbox').append("<a id='return-comerce' Style='position: absolute; margin-top: -86px; width: 120px; margin-left: 508px; cursor:alias;'></a>");
                    }
                } else {
                    jAlert("Ha ocurrido un error al crear la transacción SAFETYPAY. Vuelva a intentar en unos minutos", null);
                }
            }
        })
    }
    $("#btncargar6").click(function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=advais-amount]").val());
        if (amount < 20 || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/. 20 soles.', null);
        } else if (amount > 10000) {
            jAlert('Debe ingresar un monto de carga no mayor de S/. 10000 soles.', null);
        } else {
        	cargar6();
        }
    });
    function cargar6() {
    	var posAmount = document.getElementById("advais-valor").value;
        var clientId = $("#clientId").val();
        var sessionId = $("#sesionId").val();
        var advaisURL = $("#advaisURL").val();
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        $.ajax({
            type: "post",
            url: "advais_page_post.html",
            data: "clientId=" + clientId + "&sessionId=" + sessionId + "&posAmount=" + posAmount + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            global: false,
            async: false,
            success: function (e) {
                if (e != null && e != "" && e != "null") {
                    $("#option-card-0").prop("checked", "checked");
                    $("#panel_transaccion_1").hide();
                    $("#panel_transaccion_2").hide();
                    $("#panel_transaccion_3").hide();
                    $("#panel_transaccion_4").hide();
                    $("#panel_transaccion_5").hide();
                    $("#panel_transaccion_6").hide();
                    $("#panel_transaccion_7").hide();
                    
                    var msgres = $.trim(e.toString()).split("|||");
                    var par = msgres[0];
                    message = msgres[1];
                    redireccion = advaisURL + "?par="+par;
                    if (redireccion != null && redireccion != "" && redireccion != "null") {
                    	if(actwbbono==true) $('#content-tab-item_4 .wb-saldo').text("");
                    	var winjetpoint=dhtmlwindow.open('resultbox', 'iframe', redireccion, 'JET POINT', 'width=983,height=550,scrolling=1,center=1,resize=0', 'recal');
                    	winjetpoint.onclose=function(){
                            $.ajax({
                                type: "post",
                                url: "get-balance.html",
                                dataType: "text",
                                data: "clientId=" + clientId + "&sessionId=" + sessionId + "&posAmount=" + posAmount,
                                global: false,
                                async: false,
                                success: function (e) {
                                    if (e != null && e != "" && e != "null") {
                                    	var balanceAmount = floatFormat(e);
                                        $("#clientSale-amount").text(floatFormat(balanceAmount));
                                        $("#field-balance-amount").text(balanceAmount);
                                		jAlert("El saldo en su cuenta es "+balanceAmount, null);
                                    }  
                                }
                            });                       
                    		return true;
                    	}
                    } else {
                    	jAlert(message, null);
                    }
                } else {
                    jAlert("Ha ocurrido un error al crear la transacción JET POINT. Vuelva a intentar en unos minutos", null);
                }
            }
        })
    }
    $("#btncargar7").click(function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=paysafecard-amount]").val());
        if (amount < 20 || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/. 20 soles.', null);
        } else if (amount > 3000) {
            jAlert('Debe ingresar un monto de carga no mayor de S/. 3000 soles.', null);
        } else {
        	cargar7();
        }
    });
    function cargar7() {
    	var amount = document.getElementById("paysafecard-valor").value;
        var clientId = $("#clientId").val();
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        var sessionId = $("#sesionId").val();
        var redireccion = "createDisposition?clientId=" + clientId + "&amount=" + amount+"&shopLabel=WEBCO" + "&activ-wbbono=" + actwbbono;
    	var winpaysafecard=dhtmlwindow.open('resultbox', 'iframe', redireccion, 'paysafecard', 'width=600,height=750,scrolling=1,center=1,resize=1', 'recal');
    	winpaysafecard.onclose=function(){
            $.ajax({
                type: "post",
                url: "get-balance.html",
                dataType: "text",
                data: "clientId=" + clientId + "&sessionId=" + sessionId + "&amount=" + amount,
                global: false,
                async: false,
                success: function (e) {
                    if (e != null && e != "" && e != "null") {
                    	if(actwbbono==true) $('#content-tab-item_4 .wb-saldo').text("");
                    	var balanceAmount = floatFormat(e);
                        $("#clientSale-amount").text(floatFormat(balanceAmount));
                        $("#field-balance-amount").text(balanceAmount);
                		jAlert("El saldo en su cuenta es "+balanceAmount, null);
                    } else {
                        jAlert("Ha ocurrido un error al crear la transacción paysafecard. Vuelva a intentar en unos minutos", null);
                    }
                }
            });
            $("#option-card-0").prop("checked", "checked");
            $("#panel_transaccion_1").hide();
            $("#panel_transaccion_2").hide();
            $("#panel_transaccion_3").hide();
            $("#panel_transaccion_4").hide();
            $("#panel_transaccion_5").hide();
            $("#panel_transaccion_6").hide();
            $("#panel_transaccion_7").hide();
    		return true;
    	}
    }
    $("#btncargar9").click(function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=pagoEfectivo-amnt]").val());
        var pefeMinAmount = ((chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40);
        var pefeMaxAmount = ((chdata.pefeMaxAmount!=null && chdata.pefeMaxAmount!='' && !isNaN(chdata.pefeMaxAmount))?parseFloat(chdata.pefeMaxAmount):3000);
        if (amount < pefeMinAmount || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/. '+pefeMinAmount+' soles.', null);
            $("#pagoEfectivo-val").val(pefeMinAmount);
        } else if (amount > pefeMaxAmount) {
            jAlert('Debe ingresar un monto de carga no mayor de S/. '+pefeMaxAmount+' soles.', null);
            $("#pagoEfectivo-val").val(pefeMinAmount);
        } else {
        	cargar9();
        }
    });
    function cargar9() {
    	var posAmount = document.getElementById("pagoEfectivo-val").value;
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        $.ajax({
            type: "post",
            url: "portal_page.html",
            data: "posAmount=" + posAmount + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            global: false,
            async: false,
            success: function (redireccion) {
                if (redireccion != null && redireccion != "") {
                	if(actwbbono==true) $('#content-tab-item_4 .wb-saldo').text("");
                    $("#option-card-0").prop("checked", "checked");
                    $("#panel_transaccion_1").hide();
                    $("#panel_transaccion_2").hide();
                    $("#panel_transaccion_3").hide();
                    $("#panel_transaccion_4").hide();
                    $("#panel_transaccion_5").show();
                    $("#panel_transaccion_6").hide();
                    $("#panel_transaccion_7").hide();
                    dhtmlwindow.open('resultbox', 'iframe', redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal');
                } else {
                    jAlert("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
                }
            }
        })
    }
    $('#tab-item_5').on('click', function () {
        var content = '<div class="ajax-loader"></div>' + '<div>' + '<div id="scroll-grid">' + '<div id="grilla"></div>' + '</div></div>' + '<div id="num_link_cc"></div>';
        $('.tab-intro').eq(4).html(content);
        $('.ajax-loader').show();
        $.ajax({
            type: 'POST',
            url: 'clientBalance_find_idClient.html',
            dataType: 'text',
            success: function (e) {
                $('.ajax-loader').hide();
                if (e != "") {
                    var rowClientResult = e.split('#');
                    for (var i in rowClientResult) {
                        var columnClientResult = (rowClientResult[i] + '').split('|');
                        var rows = [];
                        for (var j in columnClientResult) {
                            rows.push(columnClientResult[j]);
                        }
                        dataClientResult.push(rows);
                    }
                    run.grilla(dataClientResult);
                    run.grilla_paginada(dataClientResult);
                    dataClientResult = [];
                }
            }
        })
    })
    
    var thisBtnDivTabItem = null;
    
    $("div.tab-item").on("click", function (event) {
    	thisBtnDivTabItem = this;
    	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
    	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
    	mainValidatePendingsDocsForAproval('loadBalanceGameRechage');
    });
    
    function loadBalanceGameRechage() {
        event.stopPropagation();
		$(thisBtnDivTabItem).hide();
		var val = $(thisBtnDivTabItem).attr("id");
        $("#content-" + val).show();

        content_tab_item = "#content-"+val;
        tab_item = "#"+val;
        
        var marca = $('#marca_logo').val();        
        $("#content-" + val).append('<div id="loading-ilot" class="loading-ilot"></div>');
        $('body').css('overflow-y', 'hidden');
        var action = window.location.href;
        $('body').append('<div id="div-lightbox-recharge-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 2147483000;overflow: auto;" ><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlot();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" onload="retirar_loading();" scrolling="no" frameborder="0" src="rechargei.html?marca='+marca+'&reference='+action+'"  class="lightbox-recharge" ></iframe></div>');
    }

    window.addEventListener("message", function(event) {
        if (event.data === "loadBalanceGameRechage") {
        	loadBalanceGameRechage(); 
        }
    });
    
    $("div.head-tab-content").on("click", function (event) {
        event.stopPropagation();
        var val = $(this).data("tab");
        $("#content-"+val).hide();
        $("#"+val).show();
        $("#option-card-0").trigger("click");
    });
    
    $('#content-tab-item_4').on('click', '#lnkactivatewbbond', function (event) {
        event.preventDefault();
        var u = $("#wbBonoTyC").val();
        dhtmlwindow.open('resultbox', 'iframe', u, 'TÉRMINOS Y CONDICIONES', 'width=620,height=460,scrolling=1,center=1,resize=0', 'recal');
    });
};
$($loadBalanceGame);

function closeLightboxRechargeIlot(){
	$('body').find('#loading-ilot').remove();
	$(content_tab_item).find('#loading-ilot').remove();
	$(content_tab_item).css('display', 'none');
	$(tab_item).css('display', 'block');
	$('body').css('overflow-y', 'scroll');
	$('body').find('#div-lightbox-recharge-ilot').remove();
	
	var ban = localStorage.getItem("ban");
	if(ban=="OK"){
		location.reload();
	}
	
	$.ajax({
        type: "POST",
        url: "load_recharge.html",
        dataType: "json",
        async: false,
        success: function (data) {
        	$("#clientSale-amount").text(floatFormat(data.billetera1));
        	$("#billetera2-amount").text(data.billetera2);
        	$("#billetera3-amount").text(data.billetera3);
        	$("#clientSale-amount-2").text(floatFormat(data.billetera1));
        }
	});
}