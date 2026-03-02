var dataClientResult = [];
var valor=1;
//var conglobal=0;//ruth
//var cantidadJugadas="";
var cantidadJugadasGanGol=0;var cantidadJugadasTinka=0; var cantidadJugadasDepor=0; var cantidadJugadasKabala=0; var cantidadJugadasGanaDiario=0; var cantidadJugadasKinelo=0; var cantidadJugadasRaspaditas=0; var cantidadJugadasCasino=0; var cantidadJugadasVideoLoterias=0;
var container = $("#account-wrapper");
var dataClient;
var run = {
    setup: function () {
        $("#clientSale-amount").text(floatFormat(clientBalance.balanceAmount));
        $(".account-balance h4 b").text("S/ " + floatFormat(clientBalance.balanceAmount));
        $('#content-tab-item_4').find('.item-title-2').text("Disponible S/ " + clientBalance.balanceAmount);
        $(".body-account .saldo-bono").html("Bonos Te Apuesto: S/ "+clientBalance.bonusAmount);
        $(".body-account .saldo-otro").html(clientBalance.otherQuantity+" jugadas");
        if($.trim(clientBalance.promo) != "") {
        	$("#tab-item_8").show();
	        if($.trim(clientBalance.promoDraw) != "") {
		        $(".body-account .title-promo").html(clientBalance.promoDescription+" ("+clientBalance.promoDraw+")");
		        $(".body-account .tickets-promo").html("N&ordm; de jugadas: "+clientBalance.promoCount);
	        } else {
	        	$(".body-account .title-promo").html(clientBalance.promoDescription);
		        $(".body-account .tickets-promo").html("");
	        }
        } else $("#tab-item_8").hide();
        $("#billetera2-amount").text("S/ "+floatFormat(clientBalance.bonusAmount));
        $("#billetera3-amount").text(clientBalance.otherQuantity);
        $("#content-tab-item_4 .item_on").removeClass("it_on_balance");
        $("#content-tab-item_4 .item_on").removeClass("hidden");
        var origenLink = $("#origenLink").val();
        
        if($('#visanetTransaction').val()!=null && $('#visanetTransaction').val()!=""){
        	var visanetTransaction = run.toJSON($('#visanetTransaction').val());
        	var resultKey = visanetTransaction.resultKey;
        	var resultMessage = visanetTransaction.resultMessage;
        	var promotionMessage = visanetTransaction.promotionMessage;
        	var actbono = visanetTransaction.actbono;
        	var actwbbono = visanetTransaction.actwbbono;
        	var monto = visanetTransaction.monto;
        	
    		if(resultKey=='OK'){	
    			var commissionAmount = visanetTransaction.commissionAmount;
    			
    			var arrayResultMessage = resultMessage.split("|");
    			tagginSaldoEEpurchase(arrayResultMessage[2], monto);
    			var rptaTransaccion = '';
    			var result = "";
    			rptaTransaccion+="\nNº Transacción:"+arrayResultMessage[2];
    			rptaTransaccion+="\nVisa:"+arrayResultMessage[4];
    			rptaTransaccion+="\n"+arrayResultMessage[3];
    			if(commissionAmount>0){
    				rptaTransaccion+="\nComisión por recarga con Tarjeta Visa: S/ "+floatFormat(commissionAmount);
    			}
    			rptaTransaccion+='\n\n<span style="font-size: 11px;">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>';

    			if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
    				promotionMessage = "";
    			}
    			
    			if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true') {
                    if (promotionMessage.includes("insuficiente") == true ) {
                    	result = '<p style="text-align: justify;margin: 0px;">'+promotionMessage + '\n\nLa recarga ha sido abonada a su saldo principal.\n\nMonto cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+'\n'+rptaTransaccion+"</p>";
                    } else {    
                    	result = '<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente'+ "\n" + promotionMessage+'\n'+rptaTransaccion+"</p>";
                    }
                } else {
                	if($.trim(promotionMessage)!=='') {
                		promotionMessage="\n"+promotionMessage+"\n";
                	}else{
                		promotionMessage="\n";
                	}
                	result = '<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente \nSaldo cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+ promotionMessage+rptaTransaccion+"</p>";
                }
    			
    			$.ajax({
			        type: "POST",
			        url: "resetVisanetTransaction.html",
			        dataType: "json",
			        async: false,
			        success: function (data) {
			        	$("#visanetTransaction").val("");
			        }
				});
    			
				jAlert(result);
			}else{
				var arrayResultMessage = resultMessage.split("|");
				var rptaTransaccion = '';
				rptaTransaccion+= "\n"+arrayResultMessage[1];
				rptaTransaccion+= "\nNº Transacción:"+arrayResultMessage[2];
				rptaTransaccion+= "\n"+arrayResultMessage[3];
				tagginSaldoErrorRecarga('Internet Visa', rptaTransaccion);
				
				$.ajax({
			        type: "POST",
			        url: "resetVisanetTransaction.html",
			        dataType: "json",
			        async: false,
			        success: function (data) {
			        	$("#visanetTransaction").val("");
			        }
				});
				
				jAlert('<p style="text-align: justify;margin: 0px;">'+rptaTransaccion+"</p>");
			}
        }
        //if($.trim(clientBalance.welcomeBonusStatus)=='Reciente' && origenLink!='TA'){
        	//exe.openwcb(clientBalance.welcomeBonusMessagePor);
        //}
        
//        if(origenLink=='TA'){
//        	$('#tab-item_4').trigger('click');
//        }
//        if($.trim(clientBalance.welcomeBonusStatus)=='Activo') exe.openwcb(clientBalance.welcomeBonusMessagePor);
    },
    toJSON: function (a) {
        return ((a === '') ? '' : $.parseJSON($.trim(a)));
    },
    cleanUpTheMess: function () {
        $('#DataClient').remove();
    },
    openPreviewCollate: function (gameName, ticketId, gameId, clientId, undefined) {
        var _gameName = (gameName !== undefined) ? $.trim(gameName.toLowerCase().replace(/\s/g, '')) : '';
        var paramValues = '?';
        paramValues += (ticketId !== undefined) ? 'ticketId=' + ticketId + '&' : '';
        paramValues += (gameId !== undefined) ? 'gameId=' + gameId + '&' : '';
        paramValues += (clientId !== undefined) ? 'clientId=' + clientId : '';
        dhtmlwindow.open('resultbox', 'iframe', 'ticket_vista_previa_popup_' + _gameName + '.html' + paramValues, 'DETALLE DE PREMIO', 'width=744,height=450,scrolling=1,center=1,resize=1', 'recal');
    },
    openPreviewWindowPrize: function () {
        dhtmlwindow.open("resultbox", "iframe", "collect_prize.html", "¿CÓMO COBRAR TU PREMIO?", "width=517,height=448,scrolling=1,center=1,resize=1", "recal");
    },
    openPreviewWindowVPos: function (amount, mode) {
        var paramValues = '?';
        paramValues += 'pos-amount=' + amount;
        paramValues += '&pos-mode=' + mode;
        var title = 'CARGA SALDO CON TUS TARJETAS DE CR&Eacute;DITO O D&Eacute;BITO';
        dhtmlwindow.open('resultbox', 'iframe', 'cuenta-vpos.html' + paramValues, title, 'width=740,height=530,scrolling=0,center=1,resize=0', 'recal');
    },
    grilla: function (data) {
        var grilla = "<div id='grilla_result'>" + "<div class='ticket_header'>" + "<div class='header_title_1'>N.</div>" + "<div class='header_title_2'>DESCRIPCI&Oacute;N</div>" + "<div class='header_title_3'>FECHA</div>" + "<div class='header_title_4'>MONTO<br/>PREVIO</div>" + "<div class='header_title_5'>MONTO<br/>CARGADO </div>"  + "<div class='header_title_6'>NUEVO<br/>MONTO</div>" + "<div class='header_title_7'>PREMIOS<br/>ACUMULADOS</div>" /*+ "<div class='header_title_8'>PREMIOS<br/>LOTERIAS</div>"*/ + "</div><div id='paging3'>";
        for (var i in data) {
            var style = 'row_grid';
            if (i % 2 == 0) {
                style += " row_grid_mouseover";
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + (parseInt(data[i][0]) + 1) + "</div>" + "<div class='column_2'>" + data[i][1] + "</div>" + "<div class='column_3'>" + data[i][2] + "</div>" + "<div class='column_4'>" + data[i][3] + "</div>" + "<div class='column_5'>" + data[i][4] + "</div>" + "<div class='column_6'>" + data[i][5] + "</div>" + "<div class='column_7'>" + data[i][7] + "</div>" /*+ "<div class='column_8'>" + data[i][6] + "</div>"*/ + "</div>";
        }
        $('#grilla').html(grilla + "</div>");
       
    },
    grilla_mov: function (data) {
    	$("#msg-tabla2").css("display","block");
    	$("#mostrarFila2").css("display","block");
    	var grilla = "<div id='grilla_result_mov'>" + "<div class='ticket_header'>" + "<div class='header_title_1'>N.</div>" + "<div class='header_title_2'>DESCRIPCI&Oacute;N</div>" + "<div class='header_title_3'>FECHA</div>" + "<div class='header_title_4'>MONTO<br/>PREVIO</div>" + "<div class='header_title_5'>MONTO<br/>CARGADO </div>" + /* "<div class='header_title_6_c'>COMISI&Oacute;N POR RECARGA<br/>CON TARJETA VISA</div>" + "<div class='header_title_7_c'>COMISI&Oacute;N POR RETIRO<br/>CON TARJETA VISA</div>" + */"<div class='header_title_8_c'>NUEVO<br/>MONTO</div>" + "<div class='header_title_9_c'>PREMIOS<br/>ACUMULADOS</div>" /*+ "<div class='header_title_8'>PREMIOS<br/>LOTERIAS</div>"*/ + "</div><div id='paging3'>";      	
    		
    	for (var i in data) {
            var style = 'row_grid';
            if (i % 2 == 0) {
                style += " row_grid_mouseover";
            }
            grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + (parseInt(data[i][0]) + 1) + "</div>" + "<div class='column_2 puntos-suspensivos'>" + data[i][1] + "</div> <div class='column_2 price-info' style='left: 228px;width: 19px;border-right: 1px solid #BBBBBB;' rel='" + i + "#" + data[i][1] +"'>[+]</div><div class='tooltip-info-arrow-img tooltip-info-arrow-img-5' style='top:19px; left:100px;'></div><div class='tooltip-info2 tooltip-info-5' style='left:94px;top:26px;'></div>" + "<div class='column_3'>" + data[i][2] + "</div>" + "<div class='column_4'>" + data[i][3] + "</div>" + "<div class='column_5'>" + data[i][4] + "</div>" + /*"<div class='column_6'>" + data[i][11] + "</div>" + "<div class='column_7'>" + data[i][12] + "</div>" + */ "<div class='column_8'>" + data[i][5] + "</div>" + "<div class='column_9'>" + data[i][7] + "</div>" /*+ "<div class='column_8'>" + data[i][6] + "</div>"*/ + "</div>";
        }
        $('#grilla').html(grilla + "</div>");
       
    },
    grilla_bonus: function (data) {
        var grilla = "<div id='grilla_result'>" + "<div class='ticket_header'>" + "<div class='header_title_1'>N.</div>" + "<div class='header_title_2'>DESCRIPCI&Oacute;N</div>" + "<div class='header_title_3'>FECHA</div>" + "<div class='header_title_4'>MONTO<br/>PREVIO</div>" + "<div class='header_title_5'>MONTO<br/>CARGADO </div>" + "<div class='header_title_6'>NUEVO<br/>MONTO</div>" + "<div class='header_title_7'>VALIDACI&Oacute;N<br/>DE TICKET</div>" + "<div class='header_title_8'>ESTADO<br/>DEL PREMIO</div>" + "</div><div id='paging4'>";
        for (var i in data) {
            var style = 'row_grid';
            if(i % 2 == 0) style += " row_grid_mouseover";
            if((data[i][6]).substring(0,1).toLowerCase()=="x") grilla += "<div class='" + style + "'>" + "<div class='column_1'><b style='color:#000000;'>" + (parseInt(data[i][0]) + 1) + "</b></div>" + "<div class='column_2'><b style='color:#000000;'>" + data[i][1] + "</b></div>" + "<div class='column_3'><b style='color:#000000;'>" + data[i][2] + "</b></div>" + "<div class='column_4'><b style='color:#000000;'>" + data[i][3] + "</b></div>" + "<div class='column_5'><b style='color:#000000;'>" + data[i][4] + "</b></div>" + "<div class='column_6'><b style='color:#000000;'>" + data[i][5] + "</b></div>" + "<div class='column_7'><b style='color:#000000;'>" + data[i][8] + "</b></div>" + "<div class='column_8'><b style='color:#000000;'>" + data[i][9] + "</b></div>" + "</div>";
            else grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + (parseInt(data[i][0]) + 1) + "</div>" + "<div class='column_2'>" + data[i][1] + "</div>" + "<div class='column_3'>" + data[i][2] + "</div>" + "<div class='column_4'>" + data[i][3] + "</div>" + "<div class='column_5'>" + data[i][4] + "</div>" + "<div class='column_6'>" + data[i][5] + "</div>" + "<div class='column_7'>" + data[i][8] + "</div>" + "<div class='column_8'>" + data[i][9] + "</div>" + "</div>";
           }
        $('#grilla-bonus').html(grilla + "</div>");

    },
    grilla_other: function (data, game, expiredate, unit_price_bonus) {
    	var rowClientResult = data.split('¬');
    	var agame = game.split("_");
    	var gameid = agame[0];
    	var gamename = agame[1];
        for (var i in rowClientResult) {
            var columnClientResult = (rowClientResult[i] + '').split('|');
            var rows = [];
            for (var j in columnClientResult) {
                rows.push(columnClientResult[j]);
            }
            dataClientResult.push(rows);
        }
        var cnt = 1;
        var grilla="";
        if(parseInt(gameid)==30 || parseInt(gameid)==31 || parseInt(gameid)==29){
        	grilla = "<div id='grilla_result-jg' >" + "<div class='ticket_header' style='background-color: #939393;'>" + "<div class='header_title_2'>DESCRIPCI&Oacute;N</div>" + "<div class='header_title_9'>CANTIDAD</div>" + "<div class='header_title_10'>SALDO</div>" + "<div class='header_title_12'>MONTO S/</div>" + "<div class='header_title_11_b'>FECHA</div>" + "</div><div id='paging5'>";
        }else{
        	grilla = "<div id='grilla_result-jg' >" + "<div class='ticket_header' style='background-color: #939393;'>" + "<div class='header_title_2'>DESCRIPCI&Oacute;N</div>" + "<div class='header_title_9'>CANTIDAD</div>" + "<div class='header_title_10'>SALDO</div>" + "<div class='header_title_11'>FECHA</div>" + "</div><div id='paging5'>";
        }
        
        for (var i in dataClientResult) {
        	if(parseInt(dataClientResult[i][6]) == parseInt(gameid)) {
        		var style = 'row_grid';
        		if(i % 2 == 0) style += " row_grid_mouseover";
        		
        			
        		if(parseInt(gameid)==30 || parseInt(gameid)==31 || parseInt(gameid)==29){
        			grilla += "<div class='" + style + "'>" + "<div class='column_1 puntos-suspensivos'>" + dataClientResult[i][1].replace('K&aacute;Bala','K&aacute;bala') + "</div>" + "<div class='column_2'>" + parseInt(dataClientResult[i][4]) + "</div>" + "<div class='column_3'>" + parseInt(dataClientResult[i][5].split('@')[0]) + "</div>" +  "<div class='column_3_monto'>" + parseFloat(dataClientResult[i][5].split('@')[1]).toFixed(2) + "</div>" + "<div class='column_4jg_b'>" + dataClientResult[i][7] + "</div>"  + "</div>";
        		}else{
        			grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + dataClientResult[i][1].replace('K&aacute;Bala','K&aacute;bala') + "</div>" + "<div class='column_2'>" + parseInt(dataClientResult[i][4]) + "</div>" + "<div class='column_3'>" + parseInt(dataClientResult[i][5].split('@')[0]) + "</div>" + "<div class='column_4jg'>" + dataClientResult[i][7] + "</div>"  + "</div>";
        		}
        		 
        		 //console.log(" dataClientResult[i][1]-->"+ dataClientResult[i][1]);
                  
                  if(valor==0 & dataClientResult[i][6]==41){
                      $('#grilla-other').html("" + "</div>");
                      } 
                  else{
             		 $('#grilla-other').html(grilla + "</div>");
             	}
                  
        	}
        }
        dataClientResult = [];
 		$(".account-wrapper .body-account #content-tab-item_7 .body-move .top-move-jg .button-move .body-button-move").removeClass("button-active");
        $(".account-wrapper .body-account #content-tab-item_7 .body-move .top-move-jg .button-move #button-"+gameid).addClass("button-active");
        
	    $(".botonJugar").html("<a href='#' class='button button-lg button-no-shadow button-block button-orange jg'>Jugar ahora</a>");
        
	    $(".account-wrapper .body-account #content-tab-item_7 h3").text(gamename);
        
        if(parseInt(gameid)==31)
        	$(".account-wrapper .body-account #content-tab-item_7 p b").text("Todas tus jugadas gratis de Casino vencen el "+expiredate+".");
        else
        	$(".account-wrapper .body-account #content-tab-item_7 p b").text("Todas tus jugadas gratis vencen el "+expiredate+".");
        
        if(parseInt(gameid)==41){
        	$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada S/ "+unit_price_bonus);
        	$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "juega-tinka.html")
       	 }
       	 else if(parseInt(gameid)==164){
       		$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada S/ "+unit_price_bonus);
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "juega-ganadiario.html?state=1")
       	 }
       	 else if(parseInt(gameid)==4){
       		$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada S/ "+unit_price_bonus);
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "juega-ganagol.html")
       	 }
       	 else if(parseInt(gameid)==42){
       		$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada S/ "+unit_price_bonus);
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "juega-kabala.html?state=1")
       	 }
       	 else if(parseInt(gameid)==1121){
       		$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada referencial S/ "+unit_price_bonus);
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "juega-kinelo.html")
       	 }
       	 else if(parseInt(gameid)==29){
       		$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada referencial S/ "+unit_price_bonus);
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "#");
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("onClick","toJuegosVirtuales('virtuales')");
       	 }
       	 else if(parseInt(gameid)==31){
       		$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada referencial S/ "+unit_price_bonus);
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "#");
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("onClick","toJuegosVirtuales('casino')");
       	 }	
       	else if(parseInt(gameid)==33){
       		$(".account-wrapper .body-account #content-tab-item_7 h4").text("Costo por jugada referencial S/ "+unit_price_bonus);
       		$("a.button.button-lg.button-no-shadow.button-block.button-orange.jg").attr("href", "juega-latinka-video-loterias.html")
       	 }
        
    },
    /*grilla_promo: function (data) {
    	var rowClientResult = data.split('#');
    	for (var i in rowClientResult) {
            var columnClientResult = (rowClientResult[i] + '').split('|');
            var rows = [];
            for (var j in columnClientResult) {
                rows.push(columnClientResult[j]);
            }
            dataClientResult.push(rows);
    	}
    	var cnt = 1;
    	var grilla = "<div id='grilla-promo'><img src='./layer-view-image/v2/img-promoTA.jpg' alt='' width='100%' /><p>Las jugadas realizadas por Internet, que cumplen con las condiciones de la promoci&oacute;n, participan directamente.<br/>Sigue aqu&iacute; la cantidad de jugadas participantes e inf&oacute;rmate de los premios y ganadores en:<br/><a href='"+clientBalance.promoMessage+"' target='_blank'>"+clientBalance.promoMessage.replace("https://","").replace("http://","")+"</a></p>" +
		"<div class='columns-grid'><div class='column' style='left:8px;width:106px;text-align:center;'>N&ordm; DE SORTEO</div><div class='column' style='left:110px;width:156px;text-align:center;'>FECHA DE SORTEO</div><div class='column' style='left:255px;width:126px;text-align:center;line-height:normal;'>N&ordm; DE JUGADAS<br/>PARTICIPANTES</div><div class='column' style='left:371px;width:157px;text-align:center;'>ESTADO DE SORTEO</div></div><div id='paging6'>";
    	\*var grilla = "<div id='grilla-promo'><img src='./layer-view-image/v2/img-promoTA.jpg' alt='' width='100%' /><p>Las jugadas realizadas por Internet, que cumplen con las condiciones de la promoci&oacute;n, participan directamente.<br/>Sigue aqu&iacute; la cantidad de jugadas participantes e inf&oacute;rmate m&aacute;s <a href='"+clientBalance.promoMessage+"' target='_blank'>"+clientBalance.promoMessage.replace("https://","").replace("http://","")+"</a></p>" +
    			"<div class='columns-grid'><div class='column' style='left:8px;width:106px;text-align:center;'>N&ordm; DE SORTEO</div><div class='column' style='left:110px;width:156px;text-align:center;'>FECHA DE SORTEO</div><div class='column' style='left:255px;width:126px;text-align:center;line-height:normal;'>N&ordm; DE JUGADAS<br/>PARTICIPANTES</div><div class='column' style='left:371px;width:157px;text-align:center;'>ESTADO DE SORTEO</div></div><div id='paging6'>";*\
    	//var grilla = "<div id='grilla-promo'><div class='columns-grid'><div class='column' style='left:8px;width:10px;text-align:center;'>N.</div><div class='column' style='left:70px;width:66px;text-align:center;'>SORTEO</div><div class='column' style='left:295px;width:76px;text-align:center;'>DESCRIPCI&Oacute;N</div><div class='column' style='left:401px;width:57px;text-align:center;'></div></div><div id='paging6'>";
    	for (var i in dataClientResult) {
            var style = 'state-row_2';
            if(i % 2 == 0) style += " row-grid";
            else style += " row-grid2";
            if(dataClientResult[i][5]!=null && $.trim(dataClientResult[i][5])!="") {
	            if((dataClientResult[i][5])=="DES") {
	            	grilla += "<div class='" + style + "' style='display: block; opacity: 1; color: #b0b0b0;'><div class='row row-game' style='left:20px;width:90px;text-align:center;text-transform:uppercase;'>" + dataClientResult[i][1] + "</div><div class='row row-game' style='left:140px;width:101px;text-align:center;'>" + dataClientResult[i][4] + "</div><div class='row row-game' style='left:300px;width:72px;text-align:center;'>" + dataClientResult[i][2] + "</div><div class='row no-border' style='left:420px;width:90px;text-align:center;'><b>" + dataClientResult[i][3] + "</b></div></div>";
	            	//grilla += "<div class='" + style + "' style='display: block; opacity: 1;'><div class='row' style='left:1px;width:24px;text-align:center;'>" + (cnt++) + "</div><div class='row row-game' style='left:70px;width:90px;text-align:center;'>" + dataClientResult[i][1] + "</div><div class='row row-game no-border' style='left:180px;width:202px;text-align:center;'>Tickets participando: " + dataClientResult[i][2] + "</div><div class='row no-border' style='left:370px;width:150px;text-align:left;'><b style='color:#b0b0b0;'>" + dataClientResult[i][3] + "</b></div></div>";
	            } else if((dataClientResult[i][5])=="ACT") {
	            	grilla += "<div class='" + style + "' style='display: block; opacity: 1; color:#000000;'><div class='row row-game' style='left:20px;width:90px;text-align:center;text-transform:uppercase;'>" + dataClientResult[i][1] + "</div><div class='row row-game' style='left:140px;width:101px;text-align:center;'>" + dataClientResult[i][4] + "</div><div class='row row-game' style='left:300px;width:72px;text-align:center;'>" + dataClientResult[i][2] + "</div><div class='row no-border' style='left:420px;width:90px;text-align:center;'><b>" + dataClientResult[i][3] + "</b></div></div>";
	            	//grilla += "<div class='" + style + "' style='display: block; opacity: 1;'><div class='row' style='left:1px;width:24px;text-align:center;'>" + (cnt++) + "</div><div class='row row-game' style='left:70px;width:90px;text-align:center;'>" + dataClientResult[i][1] + "</div><div class='row row-game no-border' style='left:180px;width:202px;text-align:center;'>Tickets participando: " + dataClientResult[i][2] + "</div><div class='row no-border' style='left:370px;width:150px;text-align:left;'><b style='color:#ffffff;'>" + dataClientResult[i][3] + "</b></div></div>";
	            } else if((dataClientResult[i][5])=="PEN") {
	            	grilla += "<div class='" + style + "' style='display: block; opacity: 1; color:#808080;'><div class='row row-game' style='left:20px;width:90px;text-align:center;text-transform:uppercase;'>" + dataClientResult[i][1] + "</div><div class='row row-game' style='left:140px;width:101px;text-align:center;'>" + dataClientResult[i][4] + "</div><div class='row row-game' style='left:300px;width:72px;text-align:center;'>" + dataClientResult[i][2] + "</div><div class='row no-border' style='left:420px;width:90px;text-align:center;'>" + dataClientResult[i][3] + "</div></div>";
	            	//grilla += "<div class='" + style + "' style='display: block; opacity: 1;'><div class='row' style='left:1px;width:24px;text-align:center;'>" + (cnt++) + "</div><div class='row row-game' style='left:70px;width:90px;text-align:center;'>" + dataClientResult[i][1] + "</div><div class='row row-game no-border' style='left:180px;width:202px;text-align:center;'>Tickets participando: " + dataClientResult[i][2] + "</div><div class='row no-border' style='left:370px;width:150px;text-align:left; style='color:#808080;'>" + dataClientResult[i][3] + "</div></div>";
	            }
	    	}
        }
    	dataClientResult = [];
        $('.tab-intro').eq(7).html(grilla + "</div><div id='holder6' class='holder'></div>" + "<img src='./layer-view-image/v2/logos.jpg' alt='' width='199' class='logos' />");
    },*/
    hashCheck: function () {
        switch (location.hash) {
        case '#yo':
            $('#tab-item_1').trigger('click');
            break;
        case '#premios':
            $('#tab-item_2').trigger('click');
            break;
        case '#jugadas':
            $('#tab-item_3').trigger('click');
            break;
        case '#saldo':
            $('#tab-item_4').trigger('click');
            break;
        case '#movimientos':
            $('#tab-item_5').trigger('click');
            break;
        case '#movimientobono':
            $('#tab-item_6').trigger('click');
            break;
        case '#movimientootro':
            $('#tab-item_7').trigger('click');
            break;
        case '#movimientopromo':
            $('#tab-item_8').trigger('click');
            break;
        case '#yo-cambiar-pwd':
            $('#tab-item_1').trigger('click');
            $('#tab-item_1').trigger('click');
			$("#tab-item_1").click();
			$("#tabUpdatePassword").prop("checked",true);
			window.location.hash = 'yo-cambiar-pwd';
            break;
        case '#yo-autocontrol':
            $('#tab-item_1').trigger('click');
			$("#tab-item_1").click();
			$("#tabAutoControl").prop("checked",true);
			window.location.hash = 'yo-autocontrol';
            break;
        default:
            break;
        }
        if(estiloTA.defaultValue=="display: none;"){
      		 $("#tab-item_8").css("display", "none");
      		 $("#tab-item_8").removeClass("tab-item accordion-off");
      		 $("#idImage1").css("display", "none");
      		 $("#idImage2").css("display", "none");
      	}else{
      		 $("#tab-item_8").css("display", "block");
      		 $("#content-tab-item_8").css("display", "none");
      	}
    }
};


var runPay = {
	grillaCode: function (amount, transact, actbono, actwbbono) {
        var data = '';
        var message = '';
        var newamount = 0.0;
        var msgres = [];
        $.ajax({
            type: "post",
            url: "verifica-codigo-bcp.html",
            dataType: "text",
            data: "bcp-amount=" + amount + "&bcp-transact=" + transact + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            //global: false,
            //async: false,
            beforeSend: function () {
            	container.append("<div id='loader-frm-register'></div>");
            },
            error: function () {
            	container.find('#loader-frm-register').remove();
            },
            success: function (e) {
            	try {
            		 msgres = $.trim(e.toString()).split("|||");
                     data = msgres[0];
                     message = msgres[1];
                     newamount = msgres[2]; 
                     if (newamount != "-1" && newamount != null && newamount != "0.0") {
                         $("#clientSale-amount").text(floatFormat(newamount));
                         $(".account-balance h4 b").text("S/ " + floatFormat(newamount));
                         $('#content-tab-item_4').find('.item-title-2').text("Disponible S/ " + newamount);
                         if(actwbbono==true) $('#grilla-saldo .wb-saldo').text("");
                     }
                     
                     var grilla = "<div id='grilla_bcp'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>C&OacuteDIGO</div>" + "<div class='head_title_3'>MONTO S/</div>" + "<div class='head_title_4'>Fec.EXPIRACI&OacuteN</div>" + "<div class='head_title_5'>ESTADO</div>" + "<div class='head_title_6'>ANULAR</div>" + "</div>";
                     var fila = data.split("||");
                     if (fila.length > 0 && fila[0] != '') {
                         for (var n = 0; n < fila.length; n++) {
                             var items = fila[n].split("|");
                             if (items.length > 0) {
                                 var style = "row_grid";
                                 if (n % 2 != 0) {
                                     style += " row_grid_mouseover";
                                 }
                                 grilla += "<div class='" + style + "'><div class='column_1'>" + (n + 1) + "</div><div class='column_2'><input class='ghost' value='" + items[0] + "'></div><div class='column_3'>" + items[1] + "</div><div class='column_4'>" + items[2] + "</div>";
                                 if (items[3] === "OKK") {
                                     grilla += "<div class='column_5'><a href='#' class='button_verificar' onclick='runPay.grillaCode(\"\",\"\",\"\",\"\")'></a></div>";
                                 } else if (items[3] === "PEN") {
                                     grilla += "<div class='column_5 verify btn-verificar'></div>";
                                 } else if (items[3] === "ACT") {
                                     grilla += "<div class='column_5'>PAGADO</div>";
                                 } else if (items[3] === "ANU") {
                                     grilla += "<div class='column_5'>ANULADO</div>";
                                 } else if (items[3] === "CAD") {
                                     grilla += "<div class='column_5'>CADUCADO</div>";
                                 }
                                 if (items[3] === "OKK") {
                                     grilla += "<div class='column_6'></div>";
                                 } else if (items[3] === "PEN") {
                                     grilla += "<div class='column_6'><div class='button_anular' data-pin='" + items[4] + "'></div></div>";
                                 }
                                 grilla += "</div>";
                             }
                         }
                         grilla += "</div></div>";
                         
                         $('#content-grid-result').html(grilla);
                     } else if($.trim(amount)!='' && $.trim(message)!='') jAlert(message);
                     container.find('#loader-frm-register').remove();
				} catch (e) {
					container.find('#loader-frm-register').remove();
					console.log(e.message);
				}
            }
        });
        
    },
    openPreviewWindowVPos: function (amount, mode) {
        var paramValues = '?';
        paramValues += 'pos-amount=' + amount;
        paramValues += '&pos-mode=' + mode;
        var title = 'CARGA SALDO CON TUS TARJETAS DE CR&Eacute;DITO O D&Eacute;BITO';
        dhtmlwindow.open('resultbox', 'iframe', 'cuenta-vpos.html' + paramValues, title, 'width=740,height=530,scrolling=0,center=1,resize=0', 'recal');
    }
};


var clientBalance = run.toJSON($('#clientBalance').val());
var chdata = run.toJSON($('#chargeData').val());
var create = {
    optionItem: function (content, dataAttribute) {
        return "<li class='option-item' data-option-value=" + dataAttribute + ">" + content + "</li>";
    },
    optionsList: function ($select) {
        var list = '';
        $select.children('option').map(function () {
            if ($(this).val() != 0) {
                list += create.optionItem($(this).text(), create.dataAttributeSelect($(this).val()));
            }
        });
        return list;
    },
    dataAttributeSelect: function (value) {
        return value;
    },
    windowLiquidate: function (game_id) {
        var image_class = '';
        var game_name = '';
        var game_amount = '';
        if (game_id == 'dv') {
            image_class = 'image-dv';
            p_url = 'generate_ticket_deportesvirtuales.html';
            game_name = 'Deportes Virtuales';
            game_amount = clientBalance.kironPrizeAmount;
        } else {
            image_class = 'image-cyg';
            p_url = 'generate_ticket_clicygana.html';
            game_name = 'Clic & Gana';
            game_amount = clientBalance.neoprizeAmount;
        }
        var window = '<div id="back"></div>' + '<div id="window-liquidate-1">' + '<div class="title-window">LIQUIDA TUS PREMIOS ACUMULADOS</div>' + '<input type="button" id="close-liquidate-1" class="close">' + '<div id="content-liquidate-accumulated-prize-1" class="group">' + '<div class=""> </div>' + '<div id="right-panel" style="width:480px; text-align:justify;">' + '<span id="message-title">Tienes S/ ' + game_amount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + ' de premios acumulados</span>' + '<p>Estos se encuentran cargados en tu saldo y se descontar&aacute;n del mismo.<br/>Ingresa el monto a cobrar en efectivo y genera uno o m&aacute;s boletos. Una vez generados no podr&aacute;n ser cambiados o anulados.</p>' + '<form id="frm-charge" data-game="' + game_id + '" action="' + p_url + '" data-response-type="text" method="post">' + '<span id="amount-message">Monto a Cobrar S/ </span>' + '<input type="text" name="amount" id="amount" onKeyPress="return validar(event)" class="text-in">' + '<button type="submit" id="generate" class="btn btn-orange" style="font-size:13px;">Generar boletos</button>' + '</form>' + '<p class="p-top">Luego imprime tu boleto(s) y ac&eacute;rcate al Punto de Venta m&aacute;s cercano para cobrar en efectivo, a partir de ma&ntilde;ana.</p>' + '<p class="p-top">Si tu premio es mayor a S/5,000, puedes solicitar una transferencia bancaria a tu cuenta del Interbank o BCP. Env&iacute;a la imagen de tus boletos con el c&oacute;digo de barras, la foto de tu DNI (ambas caras), n&uacute;mero de cuenta bancaria a tu nombre y tel&eacute;fono de contacto a: <a href="mailto:premiosweb@latinka.com.pe">premiosweb@latinka.com.pe</a></p>' + '</div>' + '<div id="zona-segura">zona segura</div>' + '</div>' + '</div>';
        $('body').prepend(window);
    }
};
var $user = function () {
	
	$("div.tab-item").on("click", function (event) {
        event.stopPropagation();
        $(this).hide();
        var val = $(this).attr("id");
        if(val == 'tab-item_1' || val =='tab-tab-item_4' )
        	validatePerfil("#"+val);
        else
        	$("#content-" + val).show();
    });

	$("div.head-tab-content").on("click", function (event) {
        event.stopPropagation();
        var val = $(this).data("tab");
        $("#content-"+val).hide();
        $("#"+val).show();
    });
	
    run.setup();
    var dataTicketsResult = [];
    //
    $('#load-money').click(function (event) {
        event.preventDefault();
        $('#tab-item_4').trigger('click');
    });
    //
    $('div.tab-item').on('click', function (event) {
        event.stopPropagation();
        $('.tab-item').show();
        $('.tab-content').hide();
        $(this).hide();
        var val = $(this).attr('id');
        $('#content-' + val).show();
        window.location.hash = $(this).data('hash');
    });
    $('.mytabs').on('click', function (event) {
//    	var hash= $(this).data('hash');
//    	if(hash==='yo'){
        	var tab=$('.mytabs input[type="radio"]:checked').prop('id');
        	switch(tab) {
	        	case "tabEditPerfil":
	        		hash='yo';
	        		break;
	        	case "tabUpdatePassword":
	        		hash='yo-cambiar-pwd';
	        		break;
	        	case "tabAutoControl":
	        		hash='yo-autocontrol';
	        		break;
	        	default:
	        	    // Acciones para cualquier otro caso
	        	    console.log("Opción no válida");
//        	}
        	window.location.hash = $(this).data('hash');
        }

        window.location.hash = hash;
    });
    $('body').on('click', '.lnk-pag1', function () {
        var cadena_pos = $(this).attr("rel");
        var id = $(this).attr("id");
        var posiciones = cadena_pos.split("-");
        $('.row_grid').removeClass('row_null').addClass('row_null');
        for (var num in posiciones) {
            $('.row_grid').eq(posiciones[num]).removeClass('row_null');
        }
        $(".indice_page").html($("#" + id).html());
        $(".lnk").removeClass("num_page_on num_page_off").addClass("num_page_on");
        $("#" + $(this).attr('id')).removeClass('num_page_on').addClass('num_page_off');
    });
    var acumulados = [];
    var acu1 = ["Acumulado de Loterias", "S/ " + clientBalance.neoprizeAmount, "Liquidar", "cyg"];
    //var acu2 = ["Acumulado de Premios", "S/ " + clientBalance.kironPrizeAmount, "Liquidar", "dv"];
    var bolsaLiquidable = clientBalance.kironPrizeAmount+clientBalance.neoprizeAmount;
    var acu2 = ["Acumulado de Premios", "S/ " + (bolsaLiquidable.toFixed(2)), "Retirar y ver historial", "dv"];
    //acumulados.push(acu1);
    //acumulados.push(acu2);
    $('#tab-item_1').on('click', function () {hideDatepicker();});
    $('#tab-item_2').on('click', function () {
    	hideDatepicker();
    	var newBolsaLiquidable = clientBalance.kironPrizeAmount+clientBalance.neoprizeAmount;
    	var contenido = `
    		  <div class="ajax-loader"></div>
    		  <div style="height: 65px; background: #f7f6f5; border-radius: 10px; padding-left: 28px; padding-top: 15px; margin-bottom:7px;">
    		    <table>
    		      <tbody>
    		        <tr>
    		          <td>
    		            <span style="font-family: AllerRegular, Arial, sans-serif; font-size: 16px; color: #7f7d77; font-weight: 700;">
    		              Disponible para retirar:
    		            </span>
    		            <span style="font-family: AllerRegular, Arial, sans-serif; font-size: 18px; color: #7f7d77; font-weight: 700;">
    		              S/ ${(floatFormat(newBolsaLiquidable.toFixed(2))).replace(".00", "")}
    		            </span>
    		          </td>
    		          <td rowspan="2" style="padding-left: 25px;">
    		            <button
    		              id="popUpPaymentPrize"
    		              class="btn btn-solicitar liquidate"
    		              style="border: #e30613;
    		                     background: #e30613;
    		                     background-image: linear-gradient(#d63a43, #e30613);
    		                     color: #fff;
    		                     font-size: 14px;
    		                     width: 145px;
    		                     height: 30px;
    		                     border-radius: 7px;">
    		              Retirar
    		            </button>
    		          </td>
    		        </tr>
    		      </tbody>
    		    </table>
    		  </div>
    		  <div id="grilla_price"></div>
    		  <div class="auto-payment-container">
			    <table class="auto-payment-table">
			        <tbody>
			            <tr>
			                <td>
			                    <span class="title">
			                        Premios de Loterías Express
			                    </span><br>
			                    <span class="subtitle">
			                        Activa el pago automático de tus premios de las jugadas compradas como invitado:
			                    </span>
			                </td>
			                <td rowspan="2" class="switch-cell">
			                    <label class="switch">
			                        <input type="checkbox" id="myToggleSwitch">
			                        <span class="slider round"></span>
			                    </label>
			                </td>
			            </tr>
			            <tr><td colspan="2">&nbsp;</td></tr>
			            <tr>
			                <td colspan="2">
			                    <span class="description">
			                        Desde ahora, todos los premios pendientes y los que ganes se abonarán automáticamente a tu saldo disponible para retiro.<br>
			                        Recuerda que los premios mayores a S/10,000 estarán disponibles en la sección 'Retirar premios' para que puedas transferirlos a tu cuenta bancaria.
			                    </span>
			                </td>
			            </tr>
			        </tbody>
			    </table>
			</div>
			
			 <div id="popup-message-recharge" class="overlay">							
				<div class="popup popup-sm login-error">	
				<a class="close-popup " id="close-popup-session" onclick="closePopup(this)">&times;</a>							
					<div class="main-modal" id="msg-session"></div>
					
				</div>
			</div>
    		`;
    	
        $('.tab-intro').eq(1).html(contenido);
        getStateModal();
        cargarGrid();
    });
    
    function confirmActivateModal() {
        $('#myToggleSwitch').prop('checked', true);
        editStateModal(true);
        closePopup('popup-message-recharge');
    }

    function confirmDesactivateModal() {
        $('#myToggleSwitch').prop('checked', false);
        editStateModal(false);
        closePopup('popup-message-recharge');
    }

    function mostrarConfirmacionActivacion() {
        var titulo = "¿Quieres activar el pago automático de tus premios?";
        var mensaje = "Todos los premios se abonarán directamente a tu saldo disponible para retiro y los premios mayores o igual a S/10,000 estarán disponibles para transferirlos a tu cuenta bancaria.";
        var html = `
            <div class="mensaje-confirmacion-password">
                <span class="mensaje-recuperar-password">${titulo}</span><br><br>
                <p class="descripcion-ok">${mensaje}</p><br><br>
                <button class="button button-orange-light no-margin green btn-activar" type="button" style="width: 100%;">Si, Activar</button><br><br>
                <button class="button button-orange-reverse no-margin green btn-cancelar" type="button" style="width: 100%;">Cancelar</button>
            </div>`;
        $('#msg-session').html(html);
        openModal("#popup-message-recharge","");
    }

    function mostrarConfirmacionDesactivacion() {
        var titulo = "&iquest;Seguro que deseas desactivar el pago autom&aacute;tico?";
        var mensaje = "Si desactivas esta opci&oacute;n, los boletos comprados a partir de ahora y que obtengan premio deber&aacute;s presentarlo en los puntos de ventas autorizados para poder cobrarlos.";
        var html = `
            <div class="mensaje-confirmacion-password">
                <span class="mensaje-recuperar-password">${titulo}</span><br><br>
                <p class="descripcion-ok">${mensaje}</p><br><br>
                <button class="button button-orange-light no-margin green btn-desactivar" type="button" style="width: 100%;">Si, Desactivar</button><br><br>
                <button class="button button-orange-reverse no-margin green btn-cancelar" type="button" style="width: 100%;">Cancelar</button>
            </div>`;
        $('#msg-session').html(html);
        openModal("#popup-message-recharge","");
    }

    function mostrarErrorActivacion() {
        var titulo = "Esta opción no está disponible en este momento";
        var mensaje = "¡Vuelve a intentarlo más tarde!";
        var html = `
            <div class="mensaje-confirmacion-password">
                <span class="mensaje-recuperar-password">${titulo}</span><br><br>
                <p class="descripcion-ok">${mensaje}</p><br><br>
            </div>`;
        $('#msg-session').html(html);
        openModal("#popup-message-recharge","");
    }

    $(document).on('click', '.btn-activar', function () {
        confirmActivateModal();
    });

    $(document).on('click', '.btn-desactivar', function () {
        confirmDesactivateModal();
    });

    $(document).on('click', '.btn-cancelar', function () {
        closePopup('popup-message-recharge');
    });

    $(document).on('click', '#myToggleSwitch', function (event) {
        event.preventDefault();
        if ($(this).prop('checked')) {
            mostrarConfirmacionActivacion();
        } else {
            mostrarConfirmacionDesactivacion();
        }
    });

    function editStateModal(autoPayEnabled) {
        $('.ajax-loader').show();
        $.ajax({
            type: 'POST',
            url: 'edit_client_autopayment_flag.html',
            dataType: "json",
            async: false,
            data: { autoPayEnabled: autoPayEnabled },
            success: function (e) {
                $('.ajax-loader').hide();
                if (e.status === "OK") {
                    $('#myToggleSwitch').prop('checked', autoPayEnabled);
                } else {
                    closePopup('popup-message-recharge');
                    console.log("No se pudo actualizar la configuración.");
                    $('#myToggleSwitch').prop('checked', !autoPayEnabled);
                    setTimeout(function() {
                        mostrarErrorActivacion();
                    }, 300);
                }
            },
            error: function () {
                $('.ajax-loader').hide();
                console.log("Hubo un problema al actualizar la configuración.");
                $('#myToggleSwitch').prop('checked', !autoPayEnabled);
                setTimeout(function() {
                    mostrarErrorActivacion();
                }, 300);
            }
        });
    }

    function getStateModal() {
        $('.ajax-loader').show();
        $.ajax({
            type: 'POST',
            url: 'get_client_autopayment_flag.html',
            dataType: "json",
            async: false,
            success: function (e) {
                $('.ajax-loader').hide();
                if (e.status === "OK" && e.clientInformation) {
                    var prizeCollection = e.clientInformation.prizeCollection;
                    $('#myToggleSwitch').prop('checked', (prizeCollection === "WEB"));
                } else {
                    console.log("Error al obtener el estado de configuración.");
                }
            },
            error: function () {
                $('.ajax-loader').hide();
                console.log("Hubo un problema al obtener la configuración.");
            }
        });
    }
    
    function cargarGrid() {
        $('.ajax-loader').show();
        $.ajax({
            type: 'POST',
            url: 'clientBalance_findPrizesList.html',
            dataType: "text",
            success: function (e) {
                $('.ajax-loader').hide();
                if (e != '') {
                    var dataPrizesResult = [];
                    var rowClientResult = e.split('#');
                    for (var i in rowClientResult) {
                        var columnClientResult = (rowClientResult[i] + "").split("|");
                        var rows = [];
                        for (var j in columnClientResult) {
                            rows.push(columnClientResult[j]);
                        }
                        dataPrizesResult.push(rows);
                    }
                    $('#grilla_price').PriceGrid({
                        grid: dataPrizesResult,
                        acu: acumulados
                    });
                }
            }
        });
    }
    
    //TODO aqui se llama al menu de jugadas
    $("#tab-item_3").on('click', function () {
    	hideDatepicker();
    	var originalFormFilterContent = $('.form_filter-jugadas').html();
    	
    	$('.form_filter-jugadas').html(originalFormFilterContent);  
    	
    	var htmlS = "<div id='mostrarFila1' style='display:none;'><label>Mostrar filas: </label><select style='padding: 2px; border-radius: 3px;' id='fila-id' onchange='changeFila_grid2()' ><option>15</option><option>20</option><option>25</option><option>50</option><option>100</option></select></div>";
    	
    	var contenido = htmlS + 
        ' <div id="scroll-grid-jugadas">' +
            '<div id="grilla_my_games" style="margin-top:10px"></div>' +
        '</div>' +
        '<div>' +
            '<p id="msg-tabla1" style="padding: 2px; font-weight: 600; font-size: 11px; display:none;">' +
            '* El historial de Casino y Virtuales lo encontrarás en <a href="javascript:toTAV2();" id="" style="color: #343a40;" class="btnEnlaceTeApuesto">TeApuesto</a>' +
            '</p>' +
            '<p id="msg-tabla2" style="padding: 2px; font-weight: 600; font-size: 11px; display:none;">' +
            '* El historial de Video Loterías lo encontrarás dentro de cada juego.' +
            '</p>' +
        '</div>';
        $('.tab-intro').eq(2).html(contenido + "<div id='holder2' class='holder'></div>");

        var $inputinicio = $('#fecha_inicio');
        var $inputfin = $('#fecha_fin');
        var $btnBuscar = $('#btsubmi-jugadas');
        
        function loadData(url, data){
        $.ajax({
            type: 'POST',
            url: url,
            data:data,
            dataType: "text",
            beforeSend: function() {
            	$('.ajax-loader').show();
            	$('.tab-intro').eq(2).hide();
            	$('.no-data-jugadas').hide();
            },
            success: function (e) {
            	setTimeout(function() {
                $('.ajax-loader').hide();
                if (e != "" && e.split('$').length > 1) {
                    	$('.tab-intro').eq(2).show();
                	$('.no-data-jugadas').hide();
                    var rowClientResult = e.split('#');
                    for (var i in rowClientResult) {
                        var columnClientResult = (rowClientResult[i] + "").split("$");
                        
                        var rows = [];
                        for (var j in columnClientResult) {
                            rows.push(columnClientResult[j]);
                        }     
                        dataTicketsResult.push(rows);
                    }
                    $('#grilla_my_games').myGamesGrid({
                        grid: dataTicketsResult
                    });
                    dataTicketsResult = [];
                }else{
                	dataTicketsResult = [];
                	$('.tab-intro').eq(2).hide();
                	$('.no-data-jugadas').show();
                        $('.no-data-jugadas').html('<div>'+ e + "</div>" + '<div> <p style="padding: 2px; font-weight: 600; font-size: 11px; text-align: justify; margin-bottom: 15px;">* El historial de Casino y Virtuales lo encontrarás en <a href="javascript:toTAV2();" style="color: #343a40;"> TeApuesto </p> </div>');
               }
                }, 1000);

            }
        })
        
        }
        
      //Boton para realizar el filtro
        $btnBuscar.on('click', function (e) {
        	$('.ajax-loader').show();
            e.preventDefault();

            // Desactivar el botón
            $btnBuscar.prop('disabled', true);

            var inicio = $inputinicio.val();
            var fin = $inputfin.val();
            if (inicio && fin) {
                var data = "startdate=" + inicio + "&enddate=" + fin;
                loadData('clientBalance_TicketsListFilter.html', data);
            }

            // Esperar 1 segundos y luego reactivar el botón
            setTimeout(function() {
                $btnBuscar.prop('disabled', false);
            }, 1000);
        });
        
        loadData('clientBalance_TicketsList.html', null);
        
        // Asignar las fechas a los inputs de fecha
        var today = new Date();
        var dd = String(today.getDate()).padStart(2, '0');
        var mm = String(today.getMonth() + 1).padStart(2, '0'); // Enero es 0!
        var yyyy = today.getFullYear();

        var formattedDateFin = dd + '/' + mm + '/' + yyyy; // Formato 'DD-MM-YYYY'

        // Calcular la fecha de inicio (3 días antes)
        var startDate = new Date();
        startDate.setDate(startDate.getDate() - 29);
        var ddInicio = String(startDate.getDate()).padStart(2, '0');
        var mmInicio = String(startDate.getMonth() + 1).padStart(2, '0'); // Enero es 0!
        var yyyyInicio = startDate.getFullYear();

        var formattedDateInicio = ddInicio + '/' + mmInicio + '/' + yyyyInicio; // Formato 'DD-MM-YYYY'

        $inputinicio.val(formattedDateInicio);
        $inputfin.val(formattedDateFin);
        
    	renderDateJugadas();
        
    });
    var thisBtnCargarSaldoMiCuenta = null;
    $('#tab-item_4').on('click', function () {
    	thisBtnCargarSaldoMiCuenta = this;
    	mainValidatePendingsDocsForAproval('cargarSaldoMiCuenta');
    });
    function cargarSaldoMiCuenta() {
    	hideDatepicker();
    	validatePerfil("#"+$(thisBtnCargarSaldoMiCuenta).prop('id'));
    }
    window.addEventListener("message", function(event) {
        if (event.data === "cargarSaldoMiCuenta") {
        	cargarSaldoMiCuenta();
        }
    });
    $('#tab-item_5').on('click', function () {
    	hideDatepicker();
    	
    	//Obtiene el el html del filtrado
    	var originalFormFilterContent = $('.form-movimientos').html();
    	
    	$('.form-movimientos').html(originalFormFilterContent);  
    	var htmlS = "<div id='mostrarFila2' style='display:none;padding-bottom:4px;'><label>Mostrar filas: </label><select style='padding: 2px; border-radius: 3px;' id='fila-idmov' onchange='changeFila_grid3()' ><option>15</option><option>20</option><option>25</option><option>50</option><option>100</option></select></div>";
    	
        var content = htmlS + '<div id="scroll-grid">' + '<div id="grilla"></div>' + '</div>' + '<div id="num_link_cc"></div>';
        var msj = '<div><p id="msg-tabla2" style="padding: 2px; font-weight: 600; font-size: 11px;display:none;">* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas".</p></div>';       
        $('.tab-intro').eq(4).html(content+msj +"<div id='holder3' class='holder'></div>");
        
 
        // Obtiene los valores de los inputs de fechas.
        var $inputinicio = $('#filterfechainicio');
        var $inputfin = $('#filterfechafin');
        var $btnBuscar = $('#btsubmit');

        function loadData(url, data){
            $.ajax({
                type: 'POST',
                url: url,
                data:data,
                dataType: 'text',
                beforeSend: function() {
                	$('.ajax-loader').show();
                	$('.tab-intro').eq(4).hide();
                	$('.no-data-movimientos').hide();
                },
                success: function (e) {
                	setTimeout(function() {
                    $('.ajax-loader').hide();
                    if (e != "" && e.split('|').length > 1) {
                        $('.tab-intro').eq(4).show();
                    	$('.no-data-movimientos').hide();
                        var rowClientResult = e.split('#');
                        var saldo = rowClientResult[0].split('|');
                        //$("#clientSale-amount").text(floatFormat(saldo[5]));
                        //$(".account-balance h4 b").text("S/ " + floatFormat(saldo[5]));
                        //
                        $(".account-balance h4 b").text("S/ " + floatFormat(saldo[8]));
                        $("#clientSale-amount").text(floatFormat(saldo[8]));
                    	$("#clientSale-amount-2").text(floatFormat(saldo[8]));
                    	$("#billetera2-amount").text(saldo[9]);
                    	$("#billetera3-amount").text(saldo[10]);
                        //
                        for (var i in rowClientResult) {
                            var columnClientResult = (rowClientResult[i] + '').split('|');
                            var rows = [];
                            for (var j in columnClientResult) {
                                rows.push(columnClientResult[j]);
                            }
                            dataClientResult.push(rows);
                        }
                        run.grilla_mov(dataClientResult);
                        paginator_grid3();
                        dataClientResult = [];
                    }else{
                    	dataClientResult = [];
                    	$('.tab-intro').eq(4).hide();
                    	$('.no-data-movimientos').show();
                            $('.no-data-movimientos').html('<div>'+ e + "</div>" + '<div> <p style="padding: 2px; font-weight: 600; font-size: 11px; text-align: justify; margin-bottom: 15px;">* Únicamente se visualizan movimientos que afectan el saldo del cliente. Todas las jugadas realizadas las puedes encontrar en "Mis Jugadas".</p> </div>');
                    }
                	}, 1000);
                }
            })
        }
        
        $btnBuscar.on('click', function (e) {
        	$('.ajax-loader').show();
        	e.preventDefault();
        	$btnBuscar.prop('disabled', true);
        	
            var inicio = $inputinicio.val();
            var fin = $inputfin.val();
            if (inicio && fin) {
                var data = "startdate=" + inicio + "&enddate=" + fin;
                loadData('clientBalance_filter.html', data);
            }
            // Esperar 2 segundos y luego reactivar el botón
            setTimeout(function() {
                $btnBuscar.prop('disabled', false);
            }, 1000);
        });
        
           loadData('clientBalance_find_idClient.html', null);
           
        // Asignar las fechas a los inputs de fecha
           var today = new Date();
           var dd = String(today.getDate()).padStart(2, '0');
           var mm = String(today.getMonth() + 1).padStart(2, '0'); // Enero es 0!
           var yyyy = today.getFullYear();

           var formattedDateFin = dd + '/' + mm + '/' + yyyy; // Formato 'DD-MM-YYYY'

           // Calcular la fecha de inicio (30 días antes)
           var startDate = new Date();
           startDate.setDate(startDate.getDate() - 29);
           var ddInicio = String(startDate.getDate()).padStart(2, '0');
           var mmInicio = String(startDate.getMonth() + 1).padStart(2, '0'); // Enero es 0!
           var yyyyInicio = startDate.getFullYear();

           var formattedDateInicio = ddInicio + '/' + mmInicio + '/' + yyyyInicio; // Formato 'DD-MM-YYYY'

           $inputinicio.val(formattedDateInicio);
           $inputfin.val(formattedDateFin);
           
           renderDateMovimientos();
        
    });
    function paginator_grid3(){
        $("div#holder3").jPages({
            containerID: "paging3",
            previous: "\u25C4",
            next: "\u25BA",
            perPage: 15,
            midRange: 10
        });
    };
    $('#content-tab-item_6').on('click','#btnRefresh',function(event){event.preventDefault();$('#tab-item_6').trigger('click');});
    $('#tab-item_6').on('click', function () {
    	hideDatepicker();
        $('.ajax-loader').show();
        $.ajax({
            type: 'POST',
            url: 'bonusBalance_find_idClient.html',
            dataType: 'text',
            success: function (e) {
                $('.ajax-loader').hide();
                if (e != "") {
                    bonus_grid(e.substr(e.lastIndexOf("¬")+1));
                    var data = e.substr(0,e.lastIndexOf("¬"));
                    var rowClientResult = data.split('¬');
                    var saldoBono = rowClientResult[0].split('|');
                    for (var i in rowClientResult) {
                        var columnClientResult = (rowClientResult[i] + '').split('|');
                        var rows = [];
                        for (var j in columnClientResult) {
                            rows.push(columnClientResult[j]);
                        }
                        dataClientResult.push(rows);
                    }
                    run.grilla_bonus(dataClientResult);
                    paginator_grid4();
                    dataClientResult = [];
                }
            }
        })
    });
    function bonus_grid(clbl){
        $("#clientBalance").val(clbl);
        clientBalance = run.toJSON(clbl);
        run.setup();
        var bonusClientStatus = clientBalance.bonusClientStatus;
        var bonusAddedBalance = clientBalance.bonusAddedBalance;
        var bonusForPlay = clientBalance.bonusForPlay;
        var bonusLastDate = clientBalance.bonusLastDate;
        var minOdd = clientBalance.minOdd;
        var bonusLimit = clientBalance.bonusLimit;
        var content = '<div class="ajax-loader"></div>';
        if($.trim(bonusClientStatus)=='Pendiente') {
            content += '<div class="body-move">\
                            <div class="top-move">\
                                <div class="buttons-move">\
                                    <div class="button-move">\
                                        <img src="layer-view-image/v2/stop.svg" />\
                                        <div class="body-button-move">\
                                            <h4>S/ ' + bonusLimit + '</h4>\
                                            <p>es tu monto total a apostar *</p>\
                                        </div>\
                                    </div>\
                                    <div class="button-move">\
                                        <img src="layer-view-image/v2/refresh.svg" />\
                                        <div class="body-button-move">\
                                            <h4>S/ ' + bonusForPlay + '<span>pendiente por jugar</span></h4>\
                                            <p>para liberar tu monto promocional **</p>\
                                        </div>\
                                    </div>\
                                </div>\
                            </div>\
                            <div class="bot-move">\
                                <p>* Recuerda que los dividendos deben ser iguales o mayores a ' + minOdd + '</p>\
                                <p>** Tu plazo para liberar tu monto promocional es hasta el ' + bonusLastDate + '.</p>\
                                <p><a href="javascript:location.reload()">Refresca tu navegador</a> para actualizar el monto pendiente por jugar.</p>\
                            </div>\
                        </div>';
        }
        else if($.trim(bonusClientStatus)=='Liquidado') {
            content += '<div class="body-move">\
                            <div class="top-move">\
                                <div class="buttons-move">\
                                    <div class="button-move button-move-liquidado">\
                                        <img src="layer-view-image/common/img-check.gif" />\
                                        <div class="body-button-move">\
                                            <h4 style="font-size: 14px; line-height: 24px;">¡Liberaste tu monto promocional!</h4>';
                                            if(parseFloat(bonusAddedBalance)>0) {
                                                content += '<p style="text-align: left;">S/' + bonusAddedBalance + ' se agregaron a tu saldo.</p>';
                                            }
                            content += '</div>\
                                    </div>\
                                    <div class="button-move button-move-liquidado">\
                                        <div class="body-button-move" style="margin: 0;">\
                                            <h4>Puedes liquidar</h4>\
                                            <p>¡Cóbralo en efectivo o juégalo ya!</p>\
                                        </div>\
                                    </div>\
                                </div>\
                            </div>\
                        </div>';
        }
        content += '<div id="scroll-grid">' + '<div id="grilla-bonus"></div>' + '</div>' + '<div id="num_link_cc"></div>';
        $('.tab-intro').eq(5).html(content+"<div id='holder4' class='holder'></div>");
    }
    function paginator_grid4(){
        $("div#holder4").jPages({
            containerID: "paging4",
            previous: "\u25C4",
            next: "\u25BA",
            perPage: 7,
            midRange: 10
        });
    };
    function expire_date()
    {
     this.date = '';
    }
    function unit_price_bonus(){
    	this.price='';
    }
    var oexpiredate = new expire_date();
    var ounit_price_bonus = new unit_price_bonus();
    $('#tab-item_7').on('click', function () {
    	hideDatepicker();
        var cantTinka=0;
        var arrayDeCadenas=0;
          $('.ajax-loader').show();
          $.ajax({
              type: 'POST',
              url: 'otherBalance_find_idClient.html',
              dataType: 'text',
              success: function (e) {
                  $('.ajax-loader').hide();
                  if (e != "") {
                    var data = e.substr(0,e.lastIndexOf("¬"));
                    var expiredate='';
                    var unit_price_bonus='';
                      var game = other_grid(data, e.substr(e.lastIndexOf("¬")+1),oexpiredate,ounit_price_bonus);
                      arrayDeCadenas = data.split("¬");
                      for(var a=0; a<arrayDeCadenas.length;a++){
                      var valorr2=arrayDeCadenas[a].split("|");
                           if(valorr2[6]==41){
                                cantTinka=cantTinka+1;
                           }
                      }
                      if(cantTinka>0){      
                       run.grilla_other(data,game,oexpiredate.date, ounit_price_bonus.price);
                       paginator_grid5();  
                      }

                     
                  }
              }
          })
      });

    function other_grid(data, clbl, oexpiredate, ounit_price_bonus){
        $("#clientBalance").val(clbl);
        clientBalance = run.toJSON(clbl);
        run.setup();
        var bonusGame = clientBalance.bonusGame;
        var otherExpire = clientBalance.otherExpire;
        var gameid = 0;
        var gamename = "";
        if($.trim(bonusGame)!='') {
        	var content = '<div class="ajax-loader"></div><div class="body-move"><div class="top-move-jg">\
        		<div class="buttons-move"><div class="button-move"><div class="body-button-move"><a href="#" id="button-x" class="body-button-move" data-game="xxx"><div class="col_1 header"><span>4</span>JUEGO</div></a></div></div>';
        	
        	content += '<div class="button-move"><div class="body-button-move"><a href="#" id="button-x" class="body-button-move" data-game="xxx"><div class="col_1 header"><span>4</span>JUEGO 2</div></a></div></div>'; 
        	content += '<div class="button-move"><div class="body-button-move"><a href="#" id="button-x" class="body-button-move" data-game="xxx"><div class="col_1 header"><span>4</span>JUEGO 2</div></a></div></div></div>';
        	content += '<div class="buttons-move"><div class="button-move"><div class="body-button-move"><a href="#" id="button-x" class="body-button-move" data-game="xxx"><div class="col_1 header"><span>4</span>JUEGO 2</div></a></div></div></div>';
        	
        	//anterior
        	/*content = '<div class="ajax-loader"></div><div class="body-move"><div class="top-move"><div class="buttons-move"><div class="button-move">\
        		<div class="body-button-move"><div class="col_1 header">JUEGO</div><div class="col_2 header">JUGADAS POR COBRAR<br/><span>(Equivalente del bono en S/)</span></div><div class="col_3 header">BONO EN S/</div></div>';
            */
        	
        	content = '<div class="ajax-loader"></div><div class="body-move"><div class="top-move-jg">\
        			   <div class="buttons-move">';
        	//console.log('bonusGameeee.length-->'+bonusGame.length);
            var arrBonusGame = bonusGame.split("|");         
            var arrGamee=data.split("¬");
            var canttink=0;  var cantGanaDiario=0;var cantGanagol=0;var cantKabala=0;var cantKinelo=0;var cantDeporVi=0;var cantRaspaditas=0;var cantCasino=0;var cantVideoLoterias=0;
            var cadenaJunta="";
            
            for(var i in arrGamee){
            	
            	arrGame2= arrGamee[i].split("|");
            	
            	 if(arrGame2[6]==41){
            		 canttink=canttink+1;
            	 }
            	 else if(arrGame2[6]==164){
            		 cantGanaDiario=cantGanaDiario+1;
            	 }
            	 else if(arrGame2[6]==4){
            		 cantGanagol=cantGanagol+1;	 
				            	 }
            	 else if(arrGame2[6]==42){
            		 cantKabala=cantKabala+1;
				 }
            	 else if(arrGame2[6]==1121){
            		 cantKinelo=cantKinelo+1;
				 }
            	 else if(arrGame2[6]==29){
            		  cantDeporVi=cantDeporVi+1;
				 }
            	 else if(arrGame2[6]==31){
              		  cantCasino=cantCasino+1;
   				 }
            	 else if(arrGame2[6]==33){
            		 cantVideoLoterias=cantVideoLoterias+1;
   				 }
            }
            
            cadenaJunta=41+"_"+canttink+","+164+"_"+cantGanaDiario+","+4+"_"+cantGanagol+","+42+"_"+cantKabala+","+1121+"_"+cantKinelo+","+29+"_"+cantDeporVi+","+31+"_"+cantCasino+","+33+"_"+cantVideoLoterias ;            
            var arrCantidadDet=cadenaJunta.split(",");
            var arrCantidadDet2="";
   
         
            
            for (var i in arrBonusGame) {
            	var arrBonus = arrBonusGame[i].split("_");            	
            	var arrBonus2 = arrBonusGame[i].split("_");  
            	var arrCantidadDet2 = arrCantidadDet[i].split("_");            	
            	          	
            	if(i==0) {
            		gameid = arrBonus[0];           		
            		gamename = arrBonus[1];
            		oexpiredate.date = arrBonus[4];
            		ounit_price_bonus.price = arrBonus[5];
            	}            	  
            	if( i != 0 && i%3 == 0 ){
            		content += '</div><div class="buttons-move">';
            		  
            	}
            	
            	//console.log("arrCantidadDet2[1]--->"+arrCantidadDet2[1]);
            	
            	if(arrBonus[0]==4){
            		cantidadJugadasGanGol=arrBonus[2];
            	}
            	 else if (arrBonus[0]==41){
            		cantidadJugadasTinka=arrBonus[2];
            	}
            	 else if (arrBonus[0]==29){
					cantidadJugadasDepor=arrBonus[2];           		
				}
            	 else if (arrBonus[0]==42){
            		 cantidadJugadasKabala=arrBonus[2];
					}
            	 else if (arrBonus[0]==164){
            		 cantidadJugadasGanaDiario=arrBonus[2];
				}
            	 else if (arrBonus[0]==1121){
            		 cantidadJugadasKinelo=arrBonus[2];
				}
            	 else if (arrBonus[0]==31){
            		 cantidadJugadasCasino=arrBonus[2];
				}
            	 else if (arrBonus[0]==33){
            		 cantidadJugadasVideoLoterias=arrBonus[2];
				}
            	//console.log("arrBonus[1]--->"+arrBonus[1])
            	//console.log("arrBonus[2]--->"+arrBonus[2])
            	//console.log("arrCantidadDet2[1]--->"+arrCantidadDet2[1])
            	
            	
       			 if(arrCantidadDet2[1]==0 && arrBonus[2]==0){
       			 content += '<div class="button-move"  style="pointer-events: none;cursor: default;background:#BFC9CA ;" ><div class="body-button-move"><a  href="#"  id="button-'+arrBonus[0]+'" class="body-button-move" style="pointer-events: none;cursor: default;background:#BFC9CA ;" data-expiredate=' + arrBonus[4] + ' data-unitpricebonus=' + arrBonus[5] + ' data-game="'+arrBonus[0]+"_"+arrBonus[1]+'"><div class="col_1 header" ><span>' + arrBonus[2] + '</span>' + arrBonus[1].toUpperCase().replace("&AACUTE;","&Aacute;") + '</div></a></div></div>';
       			 console.log("puso en 0");	 
       			   if(arrBonus[1]=="Tinka"){
       				   valor=0;
       			   }
       			 }
       			 else{
       			
       			 content += '<div class="button-move" ><div class="body-button-move"><a  href="#"  id="button-'+arrBonus[0]+'" class="body-button-move" data-expiredate=' + arrBonus[4] + ' data-unitpricebonus=' + arrBonus[5] + '  data-game="'+arrBonus[0]+"_"+arrBonus[1]+'"><div class="col_1 header" ><span>' + arrBonus[2] + '</span>' + arrBonus[1].toUpperCase().replace("&AACUTE;","&Aacute;") + '</div></a></div></div>';
       			
       			 }
            	if( (i+1)%3 == 0  &&  (i+1) < arrBonusGame.length){
            		 //console.log("cuando enetra aquyiii..");	 
            		content += '</div>';
            	}            	
            }
            
            //anterior
            /*
            for (var i in arrBonusGame) {
            	var arrBonus = arrBonusGame[i].split("_");
            	if(i==0) {
            		gameid = arrBonus[0];
            		gamename = arrBonus[1];
            	}
            	content += '<a href="#" id="button-'+arrBonus[0]+'" class="body-button-move" data-game="'+arrBonus[0]+"_"+arrBonus[1]+'"><div class="col_1">' + arrBonus[1] + '</div><div class="col_2">' + arrBonus[2] + '</div><div class="col_3"><span>S/</span><label>' + arrBonus[3] + '</label></div></a>';
            }
            content += '</div></div></div><div>\
            			<p>- Tu plazo para hacer efectivo el cobro de tus jugadas es hasta el '+otherExpire+'.</p>\
            			<p>- En caso de adquirir jugadas, en un solo boleto, con un monto total mayor al abonado, este se descontar&aacute; del saldo principal de tu cuenta.</p>\
                        <p>- Intralot tiene el derecho de modificar los costos de sus juegos, por lo que el n&uacute;mero equivalente en jugadas estar&aacute;n sujetas al monto en soles abonado.</p></div></div>\
                        <h3>&nbsp;</h3>';
            */
            //fin anterior
            
            content += '</div></div></div>\
            			<h3>&nbsp;</h3>\
            			<h4>&nbsp;</h4>';
        }
        content += '<div id="scroll-grid-jg">' + '<div id="grilla-other"></div>' + '</div>' + '<div id="num_link_cc"></div>';
        $('.tab-intro').eq(6).html(content+"<div id='holder5' class='holder-jg'></div><div class='botonJugar'></div><p><b> Revisar la fecha de expiración de las jugadas gratis.</b></p>");  /*+otherExpire+ */
        otherGame(data);
        return gameid+"_"+gamename;
    }
    function paginator_grid5(){
        $("div#holder5").jPages({
            containerID: "paging5",
            previous: "\u25C4",
            next: "\u25BA",
            perPage: 7,
            midRange: 10
        });
    };
    function otherGame(dataClientResult){
    	var data = dataClientResult;
    	$("a.body-button-move").on('click', function(event) {
        	event.preventDefault();
        	var game = $(this).data("game");
        	var expiredate = $(this).data("expiredate");
        	var unit_price_bonus = $(this).data("unitpricebonus");
        	run.grilla_other(data,game,expiredate, unit_price_bonus);
        	paginator_grid5();
        });
    }
    $('#tab-item_8').on('click', function () {
    	hideDatepicker();
        $('.ajax-loader').show();
        $.ajax({
            type: 'POST',
            url: 'promoBalance_find_idClient.html',
            dataType: 'text',
            success: function (e) {
                $('.ajax-loader').hide();
                if (e != "") {
                	var data = e.substr(0,e.lastIndexOf("#"));
                	run.grilla_promo(data);
                	paginator_grid6();
                }
            }
        })
    });
    function paginator_grid6(){
        $("div#holder6").jPages({
            containerID: "paging6",
            previous: "\u25C4",
            next: "\u25BA",
            perPage: 7,
            midRange: 10
        });
    };
    $('.head-tab-content').on('click', function() {});
    $('#content-tab-item_2').on('click', '.enlace', function (event) {
        event.preventDefault();
        run.openPreviewWindowPrize();
    });
    $('#content-tab-item_2').on('click', '.liquidate', function (event) {
        //var game_id = $(this).attr('id');
        //create.windowLiquidate(game_id);
    	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
		// es una function que se realizará en caso no tenga docs pendientes de confirmacion
		mainValidatePendingsDocsForAproval('scriptUserPopUpPaymentPrize');
    });
    
	function scriptUserPopUpPaymentPrize() {
    	validatePerfil("#popUpPaymentPrize");
	}

	window.addEventListener("message", function(event) {
	    if (event.data === "scriptUserPopUpPaymentPrize") {
	    	scriptUserPopUpPaymentPrize(); 
	    }
    });
    
    $('#content-tab-item_4').on('click', '#btncargar1', function (event) {
        event.preventDefault();
        var actbono = $("#chkactivatebond").is(":checked");
        if ($('[name=pin-number]').val().length < 1) {
            jAlert('¡Ingresa el c&oacute;digo!');
        } else {
        	var pin = $("[name=pin-number]").val();
        	var container = $("#account-wrapper");
        	        	   
            if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) && 
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ( $.trim(clientBalance.bonusChannel) == "" || ( $.trim(clientBalance.bonusChannel) != "" && $.trim(clientBalance.bonusChannel).includes($(this).data("type"))))) 
                jConfirm("Hoy ofrecemos Bono de "+clientBalance.bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovechándolo.\n¿Deseas continuar de todos modos con tu recarga?", null, function(r){if(r){cargar1();}});
            else {
            	$.ajax({
                    type: "POST",
                    url: "find_lotocard.html",
                    dataType: "json",
                    data: "pin-number=" + pin,
                    success: function (data) {
                    	if(data.message==="Existe"){
    						var amount = data.amount;                                      	 	
    						if($("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && 
    						($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes("LOTOCARD"))) &&
    						($.trim(clientBalance.stepAmount)!="" && parseFloat($.trim(clientBalance.stepAmount))>parseFloat(amount))){
    							jConfirm("<p>Has activado el Bono de "+clientBalance.bonusPercentage+"%, pero con un monto menor a S/ "+clientBalance.stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){cargar1();}});
    						}else if($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==true && 
    								($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes("LOTOCARD"))) &&
    							    ($.trim(clientBalance.wbStepAmount)!="" && parseFloat($.trim(clientBalance.wbStepAmount))>parseFloat(amount))){
    							jConfirm("<p>Has activado el Bono de "+clientBalance.welcomeBonusPercentaje+"%, pero con un monto menor a S/ "+clientBalance.wbStepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){cargar1();}});
    						}	
    						else{
    							cargar1();
    						}
                    	}else{
                    		cargar1();
                    	}
                    }
            	})
            }
        }
    });
    function cargar1() {
        var option = $("[name=option-card]:checked").val();
        var pin = $("[name=pin-number]").val();
        var actbono = $("#chkactivatebond").is(":checked");
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        var message = "", alertmsg = "";
        var amount = 0.0;
        var newamount = 0.0;
        var promotionMessage = "";
        var container = $("#account-wrapper");
        var baseUrl = "";
        var authToken = "";
        $.ajax({
            type: "POST",
            url: "recarga_lotocard.html",
            dataType: "json",
            data: "option-card=" + option + "&pin-number=" + pin + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            beforeSend: function () {
            	$("#btncargar1").prop("disabled", true);
            	container.append("<div id='loader-frm-register'>Cargando LOTOCARD ...</div>");
            },
            success: function (data) {
            	if(data.lapolla!=null && $.trim(data.lapolla)!="" && data.message == 'OK') {
            		cadena = data.lapolla.split("|");
            		window.open($.trim(cadena[0]),"_parent");
            	} else if(data.tav2!=null && $.trim(data.tav2)!="" && data.message == 'OK') {
                		cadena = data.tav2.split("|");
                		baseUrl = $.trim(cadena[0]);
                    	authToken = $.trim(cadena[1]);
                    	window.open(baseUrl+"?authToken="+authToken,"_parent");
                		//window.open($.trim(cadena[0]),"_parent");
            	} else {
	                message = data.message;
	                amount = data.amount;
	                newamount = data.newAmount;
	                promotionMessage = data.promotionMessage;
	                $("[name=pin-number]").val('');
	                $("#clientSale-amount").text(floatFormat(newamount));
	                $(".account-balance h4 b").text("S/ " + floatFormat(newamount));
	                $('#content-tab-item_4').find('.item-title-2').text("Disponible S/ " + newamount);
	                //if(actwbbono==true) $('#grilla-saldo .wb-saldo').text("");
	                message = message.replace(/_/g, ' ');
	                if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
	                    promotionMessage = "";
	                }
	                if (message === "OK") {
	                    if (option == 1) {
	                        if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true') {
	                            if (promotionMessage.includes("insuficiente") == true ) {
	                                alertmsg = promotionMessage + "\n\nLa recarga ha sido abonada a su saldo principal.\n\nMonto cargado: S/ " + amount ;                                  
	                            } else {
	                                alertmsg = "Se ha realizado una recarga con éxito a su saldo.\n\nMonto cargado: S/ " + amount + "\n" + promotionMessage;                               
	                            }
	                        } else {
	                        	    if(actwbbono==true) $('#grilla-saldo .wb-saldo').text("");
	                                alertmsg = "Se ha realizado una recarga con éxito a su saldo.\n\nMonto cargado: S/ " + amount + "\nTu saldo disponible es: S/ " + newamount + "\n" + promotionMessage;
	                        }
	                        jAlert(alertmsg, null, function (r) {if(r) {$(parent.location).attr('href', 'mi-cuenta.html');}});
	                    }
	                } else {
	                    if (option == 1) {
	                        jAlert("No se ha logrado realizar la recarga.\n" + message + "\n\nMonto cargado: S/ " + amount + "\nTu saldo disponible es: S/ " + newamount, null);
	                    }
	                }
	                $("#btncargar1").prop("disabled", false);
	                container.find('#loader-frm-register').remove();
	            }
            }
        })
    }
    $('#content-tab-item_4').on('click', '.verify', function (event) {
        var pin = $.trim($(this).siblings('.column_2').text());
        var $btnVerificar = $(this);
        var amount = $("#clientSale-amount").text();
        $.ajax({
            type: "GET",
            url: "verificar.html",
            dataType: "json",
            data: {
                pin: pin,
                amount: amount
            },
            beforeSend: function () {
            	container.append("<div id='loader-frm-register'></div>");
            },
            error: function () {
            	container.find('#loader-frm-register').remove();
            },
            success: function (data) {
            	try {
            		 if (data.state === 'OK') {
                         $("#clientSale-amount").text(floatFormat(data.amount));
                         $(".account-balance h4 b").text("S/ " + floatFormat(data.amount));
                         $('#content-tab-item_4').find('.item-title-2').text("Disponible S/ " + data.amount);
                         $btnVerificar.parents('.row_grid').remove();
                         jAlert(data.message, null, function (r) {if(r) {$(parent.location).attr('href', 'mi-cuenta.html');}});
                     } else {
                         jAlert(data.message);
                     }
            		 container.find('#loader-frm-register').remove();
				} catch (e) {
					container.find('#loader-frm-register').remove();
					console.log(e.message);
				}
            }
        })
        if ($('#content-tab-item_4').find('.button_anular').length == 1) {
            $('#grilla_bcp').html('');
        }
    });
    $('#content-tab-item_4').on('click', '#btncargar2', function (event) {
        event.preventDefault();
        var amount = $("[name=bcp-amount]").val();
        var actbono = $("#chkactivatebond").is(":checked");
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
			if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(clientBalance.bonusChannel) == "" || ( $.trim(clientBalance.bonusChannel) != "" && $.trim(clientBalance.bonusChannel).includes($(this).data("type"))))){ 
                jConfirm("Hoy ofrecemos Bono de "+clientBalance.bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovechándolo.\n¿Deseas continuar de todos modos con tu recarga?", null, function(r){if(r){runPay.grillaCode(amount, '', actbono, actwbbono);}});
            }else if($("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(clientBalance.stepAmount)!="" && parseFloat($.trim(clientBalance.stepAmount))>parseFloat(amount))){ 
            	jConfirm("<p>Has activado el Bono de "+clientBalance.bonusPercentage+"%, pero con un monto menor a S/ "+clientBalance.stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){runPay.grillaCode(amount, '', actbono, actwbbono);}});
            }else if($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==true &&
            		($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(clientBalance.wbStepAmount)!="" && parseFloat($.trim(clientBalance.wbStepAmount))>parseFloat(amount))){ 
            	jConfirm("<p>Has activado el Bono de "+clientBalance.welcomeBonusPercentaje+"%, pero con un monto menor a S/ "+clientBalance.wbStepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){runPay.grillaCode(amount, '', actbono, actwbbono);}});
            }
			else{
				runPay.grillaCode(amount, '', actbono, actwbbono);
			}
            
        }
    });
   
    $('#content-tab-item_4').on('click', '#btncargar4', function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=pagoEfectivo-amount]").val());
        var pefeMinAmount = ((chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40);
        var pefeMaxAmount = ((chdata.pefeMaxAmount!=null && chdata.pefeMaxAmount!='' && !isNaN(chdata.pefeMaxAmount))?parseFloat(chdata.pefeMaxAmount):3000);
        if (amount < pefeMinAmount || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/ '+pefeMinAmount+' soles.', null);
            $("#pagoEfectivo-valor").val(pefeMinAmount);
        } else if (amount > pefeMaxAmount) {
            jAlert('Debe ingresar un monto de carga no mayor de S/ '+pefeMaxAmount+' soles.', null);
            $("#pagoEfectivo-valor").val(pefeMinAmount);
        } else {
            if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(clientBalance.bonusChannel) == "" || ( $.trim(clientBalance.bonusChannel) != "" && $.trim(clientBalance.bonusChannel).includes($(this).data("type"))))) 
                jConfirm("Hoy ofrecemos Bono de "+clientBalance.bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovechándolo.\n¿Deseas continuar de todos modos con tu recarga?", null, function(r){if(r){cargar4();}});
            else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(clientBalance.stepAmount)!="" && parseFloat($.trim(clientBalance.stepAmount))>parseFloat(amount))) 
            	jConfirm("<p>Has activado el Bono de "+clientBalance.bonusPercentage+"%, pero con un monto menor a S/ "+clientBalance.stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){cargar4();}});
            else cargar4();
        }
    });
    function cargar4() {
        var firstname = $("#nombre").val();
        var lastname = $("#apPaterno").val();
        var maidenname = $("#apMaterno").val();
        var email = $("#mail").val();
        var phone = $("#phone").val();
        var country = $("#country").val();
        var city = $("#city").val();
        var address = $("#addres").val();
        var typeId = $("#typeId").val();
        var numberid = $("#numberId").val();
        var posAmount = document.getElementById("pagoEfectivo-valor").value;
        var mail = $("#emailUser").val();
        var clientId = $("#clientId").val();
        var sessionId = $("#sesionId").val();
        var mode = $("#mode").val();
        var actbono = $("#chkactivatebond").is(":checked");
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        var typeidNum = 0;
        if (typeId == 'DNI') {
            typeidNum = 1;
        } else if (typeId == 'CAREX') {
            typeidNum = 2;
        } else if (typeId == 'PASAP') {
            typeidNum = 3;
        }
        $.ajax({
            type: "post",
            url: "portal_page.html",
            data: "firstname=" + firstname + "&lastname=" + lastname + "&maidenname=" + maidenname + "&email=" + email + "&phone=" + phone + "&country=" + country + "&city=" + city + "&address=" + address + "&typeidNum=" + typeidNum + "&numberid=" + numberid + "&posAmount=" + posAmount + "&t=" + mode + "&m=" + mail + "&clientId=" + clientId + "&sessionId=" + sessionId + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            //global: false,
            //async: false,
            beforeSend: function () {
            	container.append("<div id='loader-frm-register'></div>");
            },
            error: function () {
            	container.find('#loader-frm-register').remove();
            },
            success: function (e) {
            	try {
            		if (e != null && e != "") {
                        var redireccion = (e + "").toString();
                        if (redireccion != null && redireccion != "") {
                        	if(actwbbono==true) $('#grilla-saldo .wb-saldo').text("");
                            dhtmlwindow.open('resultbox', 'iframe', redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal');
                        }
                    } else {
                        jAlert("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
                    }
            		container.find('#loader-frm-register').remove();
				} catch (e) {
					container.find('#loader-frm-register').remove();
					console.log(e.message);
				}
            }
        })
    }
    $('#content-tab-item_4').on('click', '#btncargar3, #btncargar5', function (event) {
        var amount = ($(this).attr("id")=="btncargar5")?parseInt($("[name=safetypay-amount]").val()):parseInt($("[name=safetypay-amnt]").val());
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
            if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(clientBalance.bonusChannel) == "" || ( $.trim(clientBalance.bonusChannel) != "" && $.trim(clientBalance.bonusChannel).includes($(this).data("type"))))) 
                jConfirm("Hoy ofrecemos Bono de "+clientBalance.bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovechándolo.\n¿Deseas continuar de todos modos con tu recarga?", null, function(r){if(r){cargar3(posAmount, typeToken);}});
            else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(clientBalance.stepAmount)!="" && parseFloat($.trim(clientBalance.stepAmount))>parseFloat(amount))) 
            	jConfirm("<p>Has activado el Bono de "+clientBalance.bonusPercentage+"%, pero con un monto menor a S/ "+clientBalance.stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){cargar3(posAmount, typeToken);}});
            else cargar3(posAmount, typeToken);
        }
    });
    function cargar3(posAmount, typeToken) {
        var clientId = $("#clientId").val();
        var sessionId = $("#sesionId").val();
        var actbono = $("#chkactivatebond").is(":checked");
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        $.ajax({
            type: "post",
            url: "safety_page_post.html",
            data: "clientId=" + clientId + "&sessionId=" + sessionId + "&posAmount=" + posAmount + "&typeToken=" + typeToken + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            //global: false,
            //async: false,
            beforeSend: function () {
            	container.append("<div id='loader-frm-register'></div>");
            },
            error: function () {
            	container.find('#loader-frm-register').remove();
            },
            success: function (e) {
            	try {
            		var redireccion = $.trim((e + "").toString());
                    if (redireccion != null && redireccion != "" && redireccion != "null") {
                    	if(actwbbono==true) $('#grilla-saldo .wb-saldo').text("");
                    	var winjetpoint = dhtmlwindow.open('resultbox', 'iframe', redireccion, 'SAFETYPAY', 'width=963,height=670,scrolling=1,center=1,resize=0', 'recal');
                        $('#resultbox').append("<a id='return-comerce' Style='position: absolute; margin-top: -86px; width: 120px; margin-left: 508px; cursor:alias;'></a>");
                        //}
                    } else {
                        jAlert("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
                    }
                    container.find('#loader-frm-register').remove();
				} catch (e) {
					container.find('#loader-frm-register').remove();
					console.log(e.message);
				}
            }
        })
    }
    $('#content-tab-item_4').on('click', '#btncargar6', function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=advais-amount]").val());
        if (amount < 20 || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/ 20 soles.', null);
        } else if (amount > 10000) {
            jAlert('Debe ingresar un monto de carga no mayor de S/ 10000 soles.', null);
        } else {
            if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(clientBalance.bonusChannel) == "" || ( $.trim(clientBalance.bonusChannel) != "" && $.trim(clientBalance.bonusChannel).includes($(this).data("type"))))) 
                jConfirm("Hoy ofrecemos Bono de "+clientBalance.bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovechándolo.\n¿Deseas continuar de todos modos con tu recarga?", null, function(r){if(r){cargar6();}});
            else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(clientBalance.stepAmount)!="" && parseFloat($.trim(clientBalance.stepAmount))>parseFloat(amount))) 
            	jConfirm("<p>Has activado el Bono de "+clientBalance.bonusPercentage+"%, pero con un monto menor a S/ "+clientBalance.stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){cargar6();}});
            else cargar6();
        }
    });
    function cargar6() {
        var posAmount = document.getElementById("advais-valor").value;
        var clientId = $("#clientId").val();
        var sessionId = $("#sesionId").val();
        var advaisURL = $("#advaisURL").val();
        var actbono = $("#chkactivatebond").is(":checked");
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        $.ajax({
            type: "post",
            url: "advais_page_post.html",
            data: "clientId=" + clientId + "&sessionId=" + sessionId + "&posAmount=" + posAmount + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            global: false,
            async: false,
            success: function (e) {
                if (e != null && e != "" && e != "null") {
                    
                    var msgres = $.trim(e.toString()).split("|||");
                    var par = msgres[0];
                    message = msgres[1];
                    redireccion = advaisURL + "?par="+par;
                    if (redireccion != null && redireccion != "" && redireccion != "null") {
                    	if(actwbbono==true) $('#grilla-saldo .wb-saldo').text("");
                        var winjetpoint=dhtmlwindow.open('resultbox', 'iframe', redireccion, 'JET POINT', 'width=983,height=550,scrolling=1,center=1,resize=0', 'recal');
                        winjetpoint.onclose=function(){
                            $(parent.location).attr('href', 'mi-cuenta.html');
                            return true;
                        }
                    } else {
                        jAlert(message, null);
                    }
                } else {
                    jAlert("Ha ocurrido un error al crear la transacci&oacute;n JET POINT. Vuelva a intentar en unos minutos", null);
                }
            }
        })
    }
    $('#content-tab-item_4').on('click', '#btncargar7', function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=paysafecard-amount]").val());
        if (amount < 20 || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/ 20 soles.', null);
        } else if (amount > 3000) {
            jAlert('Debe ingresar un monto de carga no mayor de S/ 3000 soles.', null);
        } else {
            if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(clientBalance.bonusChannel) == "" || ( $.trim(clientBalance.bonusChannel) != "" && $.trim(clientBalance.bonusChannel).includes($(this).data("type"))))) 
                jConfirm("Hoy ofrecemos Bono de "+clientBalance.bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovechándolo.\n¿Deseas continuar de todos modos con tu recarga?", null, function(r){if(r){cargar7();}});
            else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(clientBalance.stepAmount)!="" && parseFloat($.trim(clientBalance.stepAmount))>parseFloat(amount))) 
            	jConfirm("<p>Has activado el Bono de "+clientBalance.bonusPercentage+"%, pero con un monto menor a S/ "+clientBalance.stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){cargar7();}});
            else cargar7();
        }
    });
    function cargar7() {
        var amount = document.getElementById("paysafecard-valor").value;
        var clientId = $("#clientId").val(); 
        var actbono = $("#chkactivatebond").is(":checked");
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        var redireccion = "createDisposition?clientId=" + clientId + "&amount=" + amount+"&shopLabel=WEBCO" + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono;
        var winpaysafecard=dhtmlwindow.open('resultbox', 'iframe', redireccion, 'paysafecard', 'width=600,height=750,scrolling=1,center=1,resize=1', 'recal');
        winpaysafecard.onclose=function(){
            var ran = Math.random().toString(36);
            $(parent.location).attr('href', 'mi-cuenta.html?'+ran+'#movimientos');
            return true; 
        } 
    }
    $('#content-tab-item_4').on('click', '#btncargar9', function (event) {
        event.preventDefault();
        var amount = parseInt($("[name=pagoEfectivo-amnt]").val());
        var pefeMinAmount = ((chdata.pefeMinAmount!=null && chdata.pefeMinAmount!='' && !isNaN(chdata.pefeMinAmount))?parseFloat(chdata.pefeMinAmount):40);
        var pefeMaxAmount = ((chdata.pefeMaxAmount!=null && chdata.pefeMaxAmount!='' && !isNaN(chdata.pefeMaxAmount))?parseFloat(chdata.pefeMaxAmount):3000);
        if (amount < pefeMinAmount || amount == '') {
            jAlert('Debe ingresar un monto de carga a partir de S/ '+pefeMinAmount+' soles.', null);
            $("#pagoEfectivo-val").val(pefeMinAmount);
        } else if (amount > pefeMaxAmount) {
            jAlert('Debe ingresar un monto de carga no mayor de S/ '+pefeMaxAmount+' soles.', null);
            $("#pagoEfectivo-val").val(pefeMinAmount);
        } else {
            if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==false && ($.trim(clientBalance.bonusChannel) == "" || ( $.trim(clientBalance.bonusChannel) != "" && $.trim(clientBalance.bonusChannel).includes($(this).data("type"))))) 
                jConfirm("Hoy ofrecemos Bono de "+clientBalance.bonusPercentage+"% para jugar en TeApuesto.pe y estas desaprovechándolo.\n¿Deseas continuar de todos modos con tu recarga?", null, function(r){if(r){cargar9();}});
            else if(($("#chkactivatewbbond").length==0 || ($("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")==false)) &&
            		$("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")==true && ($.trim(clientBalance.bonusChannel)=="" || ($.trim(clientBalance.bonusChannel)!="" && $.trim(clientBalance.bonusChannel).includes($(this).data("type")))) &&
        			($.trim(clientBalance.stepAmount)!="" && parseFloat($.trim(clientBalance.stepAmount))>parseFloat(amount))) 
            	jConfirm("<p>Has activado el Bono de "+clientBalance.bonusPercentage+"%, pero con un monto menor a S/ "+clientBalance.stepAmount+".</p><p>Tu recarga proceder&aacute; sin el bono.</p>", null, function(r){if(r){cargar9();}});
            else cargar9();
        }
    });
    function cargar9() {
        var firstname = $("#nombre").val();
        var lastname = $("#apPaterno").val();
        var maidenname = $("#apMaterno").val();
        var email = $("#mail").val();
        var phone = $("#phone").val();
        var country = $("#country").val();
        var city = $("#city").val();
        var address = $("#addres").val();
        var typeId = $("#typeId").val();
        var numberid = $("#numberId").val();
        var posAmount = document.getElementById("pagoEfectivo-val").value;
        var mail = $("#emailUser").val();
        var clientId = $("#clientId").val();
        var sessionId = $("#sesionId").val();
        var mode = $("#mode").val();
        var actbono = $("#chkactivatebond").is(":checked");
        var actwbbono = $("#chkactivatewbbond").is(":checked");
        var typeidNum = 0;
        if (typeId == 'DNI') {
            typeidNum = 1;
        } else if (typeId == 'CAREX') {
            typeidNum = 2;
        } else if (typeId == 'PASAP') {
            typeidNum = 3;
        }
        $.ajax({
            type: "post",
            url: "portal_page.html",
            data: "firstname=" + firstname + "&lastname=" + lastname + "&maidenname=" + maidenname + "&email=" + email + "&phone=" + phone + "&country=" + country + "&city=" + city + "&address=" + address + "&typeidNum=" + typeidNum + "&numberid=" + numberid + "&posAmount=" + posAmount + "&t=" + mode + "&m=" + mail + "&clientId=" + clientId + "&sessionId=" + sessionId + "&activ-bono=" + actbono + "&activ-wbbono=" + actwbbono,
            dataType: "text",
            //global: false,
            //async: false,
            beforeSend: function () {
            	container.append("<div id='loader-frm-register'></div>");
	        },
	        error: function () {
	        	container.find('#loader-frm-register').remove();
	        },
            success: function (e) {
            	try {
            		 if (e != null && e != "") {
                         var redireccion = (e + "").toString();
                         if (redireccion != null && redireccion != "") {
                         	if(actwbbono==true) $('#grilla-saldo .wb-saldo').text("");
                             dhtmlwindow.open('resultbox', 'iframe', redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal');
                         }
                     } else {
                         jAlert("Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
                     }
            		 container.find('#loader-frm-register').remove();
				} catch (e) {
					container.find('#loader-frm-register').remove();
					console.log(e.message);
				}
            }
        })
    }
    $('#content-tab-item_4').on('click', '#pagoEfecHelp', function (event) {
        event.preventDefault();
        var pagoEfectivoHelp = "layer-view-interface/client/como_funciona_pagoefectivo.jsp";
        dhtmlwindow.open('resultbox', 'iframe', pagoEfectivoHelp, '¿Cómo funciona PagoEfectivo?', 'width=510,height=518px,scrolling=0,center=1,resize=0', 'recal');
    });
    $('#content-tab-item_4').on('keypress', '[name=bcp-amount]', function (event) {
        var c = event.which,
            d = event.keyCode,
            e = String.fromCharCode(c).toLowerCase(),
            f = '0123456789';
        (-1 != f.indexOf(e) || 9 == d || 37 != c && 37 == d || 39 == d && 39 != c || 8 == d || 46 == d && 46 != c) && 161 != c || event.preventDefault()
    });
    $('#content-tab-item_4').on('click', '#lnkactivatebond', function (event) {
        event.preventDefault();
        var u = $("#iflexBonoTyC").val();
        dhtmlwindow.open('resultbox', 'iframe', u, 'TÉRMINOS Y CONDICIONES', 'width=620,height=460,scrolling=1,center=1,resize=0', 'recal');
    });
    $('#content-tab-item_4').on('click', '#lnkactivatewbbond', function (event) {
        event.preventDefault();
        var u = $("#wbBonoTyC").val();
        dhtmlwindow.open('resultbox', 'iframe', u, 'TÉRMINOS Y CONDICIONES', 'width=620,height=460,scrolling=1,center=1,resize=0', 'recal');
    });
    $('#content-tab-item_4').on('change', '#chkactivatebond, #chkactivatewbbond', function (event) {
    	var chk = $(this).is(":checked");
    	if($(this).attr("id")=="chkactivatebond" && $("#chkactivatewbbond").length>0 && $("#chkactivatewbbond").is(":checked")) $("#chkactivatewbbond").prop("checked",!chk);
    	else if($(this).attr("id")=="chkactivatewbbond" && $("#chkactivatebond").length>0 && $("#chkactivatebond").is(":checked")) $("#chkactivatebond").prop("checked",!chk);
    });
    $.fn.PriceGrid = function (opciones) {
        var defec = {
            grid: [],
            columns: [{
                title: "N.",
                left: "0px",
                width: "25px",
                align: "center"
            }, {
                title: "JUEGO",
                left: "29px",
                width: "69px",
                align: "center"
            }, {
                title: "Fc.COMPRA",
                left: "114px",
                width: "70px",
                align: "center"
            }, {
                title: "PREMIOS",
                left: "195px",
                width: "110px",
                align: "center"
            }, {
                title: "COBRAR",
                left: "338px",
                width: "80px",
                align: "center"
            }, {
                title: "ESTADO",
                left: "440px",
                width: "90px",
                align: "center"
            }]
        };
        $.extend(defec, opciones);
        $('#grilla_price').on('click', '.row.ico-search', function () {
            var dataTicket = $(this).data('ticket');
            openPreviewWindow_award(dataTicket.gameId, dataTicket.gameName, dataTicket.parameterId, dataTicket.printPay, dataTicket.prizesSet);
            
            // set prize row selected
            let rownum = $(this).data('row');
            $('#hdPrizeRowSelected').val(rownum);
        }).on('click', '.row.ico-collate', function () {
            var dataCollate = $(this).data('collate');
            run.openPreviewCollate(dataCollate.gameName, dataCollate.ticketId, dataCollate.gameId, dataCollate.clientId, undefined);
        }).html(dibuja_grilla() + acumulados() + "<div id='holder1' class='holder'></div>");//html(dibuja_grilla() + acumulados() + paginator_grid());
        paginator_grid1();

        function dibuja_grilla() {
            var dato = defec.columns;
            var count_column = 0;
            var cabecera = "<div class='columns-grid'>";
            var count_row = 0;
            for (var i in dato) {
                cabecera += "<div class='column' style='" + "left:" + dato[i].left + ";" + "width:" + dato[i].width + ";" + "text-align:" + dato[i].align + ";'>" + dato[i].title + "</div>";
                count_column++;
            }
            cabecera += "</div><div id='paging1'>";
            var content = '';
            var contador = 0;
            for (var v in defec.grid) {
                contador++;
                var classCss = 'row-grid';
                var style = '';
                if ((parseInt(v) + 1) % 2 == 0) {
                    classCss += '2';
                }
                if (contador > 5) {
                    style = "";
                }
                content += "<div class='state-row " + classCss + "'" + style + ">";
                content += "<div class='row' style='left:" + dato[0].left + ";width:" + dato[0].width + ";text-align:" + dato[0].align + ";'>" + (parseInt(v) + 1) + "</div>";
                content += "<div class='row row-game' style='left:" + dato[1].left + ";width:" + dato[1].width + ";text-align:" + dato[1].align + ";'>" + defec.grid[v][0] + "</div>";
                content += "<div class='row' style='left:" + dato[2].left + ";width:" + dato[2].width + ";text-align:" + dato[2].align + ";'>" + defec.grid[v][1] + "</div>";
                content += "<div class='row' style='left:" + dato[3].left + ";width:" + dato[3].width + ";text-align:" + dato[3].align + ";'>" + defec.grid[v][2];
                content += "<span class='price-info' rel='" + count_row + "#" + defec.grid[v][3] + "'> [+]</span>";
                content += "</div>";
                content += "<div class='tooltip-info' style='left:199px;top:25px;'></div>";
                content += "<div class='tooltip-info-arrow-img' style='top:18px;left: 245px;'></div>";
                var dataAttributeCollate = '{"gameId":"' + $.trim(defec.grid[v][7]) + '","gameName":"' + $.trim(defec.grid[v][0]) + '","ticketId":"' + $.trim(defec.grid[v][5]) + '","clientId":"' + $('#clientId').val() + '"}';
                content += (defec.grid[v][10] == 'YES') ? "<div class='row ico-collate' data-collate='" + dataAttributeCollate + "' style='left:300px'></div>" : "<div class='row no-border' style='left:300px'></div>";
                count_row++;
                if ($.trim(defec.grid[v][6]) == "YES") {
                    content += "<div class='row no-border' style='text-align: right; width: 78px; left: 320px;'>Ticket " + defec.grid[v][5] + "</div>";
                    var dataAttributeTicket = '{"gameId":"' + $.trim(defec.grid[v][7]) + '","gameName":"' + $.trim(defec.grid[v][0]) + '","parameterId":"' + $.trim(defec.grid[v][11]) + '","printPay":"' + $.trim(defec.grid[v][6]) + '","prizesSet":"' + $.trim(defec.grid[v][8]) + '"}';
                    content += "<div class='row ico-search' style='width: 16px; left: 400px; top: 2px;' data-ticket='" + dataAttributeTicket +"' data-row='"+v+"'><img src='layer-view-image/v2/search.png?v=2' /></div>";
                } else {
                    content += "<div class='row' style='left:326px;top:2px;width:" + dato[5].width + ";text-align:" + dato[5].align + ";'> </div>";
                }
                content += "<div "+ "id='prize_status_"+v+"' class='row no-border' style='left:423px;width:100px;text-align:right;'>" + defec.grid[v][9] + "</div>";
                content += "</div>";
            }
            return cabecera + content + "</div>";
        }

        function acumulados() {
            var acumulados = defec.acu;
            var resp = "<div class='rows-acu'>";
            for (var t in acumulados) {
                resp += "<div  class='row-acu'>";
                resp += "<div class='acu-item' style='line-height: 30px;left:35px;width:190px;text-align:left' ><b>" + acumulados[t][0] + "</b></div>";
                resp += "<div class='acu-item' style='line-height: 30px;left:200px;width:117px;text-align:center'>" + floatFormat(acumulados[t][1]) + "</div>";
                resp += "<div id =" + acumulados[t][3] + " class='acu-item liquidate'  data-index='" + t + "' style='line-height: 30px;text-decoration:underline;left:390px;width:140px;text-align:left;cursor:pointer'>" + acumulados[t][2] + "</div> <div class='liquidate-info'>Podr&aacute;s emitir un boleto, para cobrar<br>tus premios acumulados en el punto de venta, de forma total o parcial.</div>" + "<div class='liquidate-info-img'> </div>";
                resp += "</div>";
            }
            resp += "</div>";
            return resp;
        }
        function paginator_grid1(){
            $("div#holder1").jPages({
                containerID: "paging1",
                previous: "\u25C4",
                next: "\u25BA",
                perPage: 5,
                midRange: 10
            });
        };
        
        $('.num-pag').on('click', function () {
            var cadena_pos = $(this).attr('rel');
            var id = $(this).attr('id');
            var posiciones = cadena_pos.split('-');
            $('.state-row').hide();
            for (var num in posiciones) {
                $('.state-row').eq(posiciones[num]).show();
            }
            $('.indice_page').html($('#' + id).html());
            $('.lnk').removeClass('num_page_on num_page_off').addClass('num_page_on');
            $('#' + $(this).attr('id')).removeClass('num_page_on').addClass('num_page_off');
        });
        $('#content-tab-item_2').on('mouseover', '.price-info', function () {
            var contenido_total = $(this).attr("rel");
            var contenido_temp = (contenido_total + "").split("#");
            var posicion = parseInt(contenido_temp[0]);
            var mensaje = contenido_temp[1] + "";
            $(".tooltip-info").eq(posicion).show().html(mensaje);
            $(".tooltip-info-arrow-img").eq(posicion).show();
        }).on('mouseout', '.price-info', function () {
            var contenido_total = $(this).attr("rel");
            var contenido_temp = contenido_total.split("#");
            var posicion = parseInt(contenido_temp[0]);
            var mensaje = contenido_temp[1];
            $(".tooltip-info").eq(posicion).hide().html(mensaje);
            $(".tooltip-info-arrow-img").eq(posicion).hide();
        })
    };
    $.fn.myGamesGrid = function (opciones) {
        var defec = {
            grid: [],
            columns: [{
                title: "N.",
                left: "8px",
                width: "10px",
                align: "center"
            }, {
                title: "JUEGO",
                left: "30px",
                width: "66px",
                align: "center"
            }, {
                title: "Fc.COMPRA",
                left: "123px",
                width: "140px",
                align: "center"
            }, {
                title: "JUGADA",
                left: "270px",
                width: "60px",
                align: "center"
            }, {
                title: "TICKET",
                left: "500px",
                width: "60px",
                align: "center"
            }, {
                title: "ESTADO",
                left: "650px",
                width: "74px",
                align: "center"
            }, {
                title: "CANAL DE VENTA",
                left: "750px",
                width: "95px",
                align: "center"
            }
            ]
        };
        $.extend(defec, opciones);
        $("#grilla_my_games").html(dibuja_grilla() );//dibuja_grilla() + paginator_grid());
        paginator_grid2();

        function dibuja_grilla() {
        	$("#msg-tabla1").css("display","block");
        	$("#msg-tabla2").css("display", "block");
        	$("#mostrarFila1").css("display","block");
            var dato = defec.columns;
            var count_column = 0;
            var cabecera = "<div class='columns-grid'>";
            for (var i in dato) {
                cabecera += "<div class='column' style='" + "left:" + dato[i].left + ";" + "width:" + dato[i].width + ";" + "text-align:" + dato[i].align + ";'>" + dato[i].title + "</div>";
                count_column++;
            }
            cabecera += "</div><div id='paging2'>";
            var content = "";
            var contador = 0;
            var count_row = 0;
            for (var v in defec.grid) {
                contador++;
                var classCss = "row-grid";
                var style = "";
                if ((parseInt(v) + 1) % 2 == 0) {
                    classCss += "2";
                }
                if (contador > 8) {
                    style = "";
                }
                
                content += "<div class='state-row_2 " + classCss + "'" + style + ">";
                content += "<div class='row' style='left:-6px;width:24px;text-align:" + dato[0].align + ";'>" + (parseInt(v) + 1) + "</div>"; /*id*/
                content += "<div class='row row-game' style='left:23px;width:108px;text-align:" + dato[1].align + ";'>" + defec.grid[v][0] + "</div>"; /*game*/
                content += "<div class='row' style='left:132px;width:112px;text-align:" + dato[2].align + ";'>" + defec.grid[v][1] + "</div>"; /*fecha*/
                /* content += "<div class='row' style='left:201px;width:162px;text-align:left;'>" + defec.grid[v][2] + "</div>"; */
                content += "<div class='row' style='left:248px;width:239px;text-align:left;flex-wrap:nowrap !important; white-space: pre-wrap'>" + defec.grid[v][2] + "</div>"; /*cod-juego*/
                // border:none;
                if ($.trim(defec.grid[v][3]) != "null") {
                    content += " <div class='row no-border price-info' style='left:468px;' rel='" + count_row + "#" + $.trim(defec.grid[v][3]) + "'>[+]</div>"; 
                    content += "<div class='tooltip-info-arrow-img tooltip-info-arrow-img-3' style='top:18px; left:320px;'></div>";
                    content += "<div class='tooltip-info2 tooltip-info-3' style='left:310px;top:25px;'></div>";
                    count_row++;
                }
                content += "<div class='row' style='left:490px;width:155px;text-align:right;'>" + defec.grid[v][4] + "</div>"; /*cod-tinka*/
                if ($.trim(defec.grid[v][8]) == "YES") { // loterias web y retail | ganagol y te apuesto iflex
                    content += "<div class='row no-border ico-search' style='left:630px;width:12px;' onclick='openWindowGames(" + $.trim(defec.grid[v][6]) + ",\"" + $.trim(defec.grid[v][0]) + "\",\"" + $.trim(defec.grid[v][7]) + "\",\"" + $.trim(defec.grid[v][13]) + "\")'><img src='layer-view-image/v2/search.png?v=2' /></div>";
                }
                else if ($.trim(defec.grid[v][8]) == "XP"){ // TODO Tinka Express
                	content += "<div class='row no-border ico-search' style='left:630px;width:12px;' onclick='openTicketTinkaExpress(\"" + $.trim(defec.grid[v][18]) + "\",\"" + $.trim(defec.grid[v][19]) + "\")'><img src='layer-view-image/v2/search.png?v=2' /></div>";
                } 
                else {
                    if ($.trim(defec.grid[v][8]) == "URL") {
                    	content += "<div class='row no-border ico-search' style='left:630px;width:12px;' onclick='openIflexWindow(\"" + $.trim(defec.grid[v][11])+"web/guest/coupon-details?couponId="+$.trim(defec.grid[v][7])+"&authToken="+$.trim(defec.grid[v][9])+"&playerId="+$.trim(defec.grid[v][10])+ "\",\"" + $.trim(defec.grid[v][0]) + "\",\""+$.trim(defec.grid[v][7])+ "\")'><img src='layer-view-image/v2/search.png?v=2' /></div>";                        
                    } if($.trim(defec.grid[v][8]) == "VIRT") {
                  		content += "<div class='row no-border ico-search' style='left:630px;width:12px;' onclick='openVirtualesWindow(\"" + $.trim(defec.grid[v][11])+"web/guest/coupon-details?couponId="+$.trim(defec.grid[v][4])+"&authToken="+$.trim(defec.grid[v][9])+"&playerId="+$.trim(defec.grid[v][10])+ "\",\"" + $.trim(defec.grid[v][0]) + "\",\""+$.trim(defec.grid[v][15])+ "\")'><img src='layer-view-image/v2/search.png?v=2' /></div>";   
                    } if($.trim(defec.grid[v][8]) == "NOV") { //Te apuesto novus
                    	if($.trim(defec.grid[v][12]) == 'OK' ){
                    		content += "<div class='row no-border ico-search' style='left:630px;width:12px;' onclick='openTeApuestoNovus(\"" + $.trim(defec.grid[v][11])+"web/guest/coupon-details?couponId="+$.trim(defec.grid[v][14])+"&authToken="+$.trim(defec.grid[v][9])+"&playerId="+$.trim(defec.grid[v][10])+ "\",\"" + $.trim(defec.grid[v][0]) + "\",\""+$.trim(defec.grid[v][14]) + "\")'><img src='layer-view-image/v2/search.png?v=2' /></div>";  	
                    	}
                    } if($.trim(defec.grid[v][8]) == "IFLEX") { // Te apuesto grecia
                    	
                    	 content += "<div class='row no-border ico-search' style='left:630px;width:12px;' onclick='openWindowGameIflex(" + $.trim(defec.grid[v][6]) + ",\"" + $.trim(defec.grid[v][0]) + "\",\"" + $.trim(defec.grid[v][7]) + "\",\"" + $.trim(defec.grid[v][13]) + "\",\"" + $.trim(defec.grid[v][15]) + "\",\"" + $.trim(defec.grid[v][16])  + "\")'><img src='layer-view-image/v2/search.png?v=2' /></div>";
                    	
                    } else {
                    	
                    	if ($.trim(defec.grid[v][8]) == "NTA") {
                    		content += "<div class='row no-border ico-search' style='left:630px;width:12px;' onclick='openIflexWindow(\"" + $.trim(defec.grid[v][11])+"web/guest/coupon-details?couponId="+$.trim(defec.grid[v][7])+"&authToken="+$.trim(defec.grid[v][9])+"&playerId="+$.trim(defec.grid[v][10])+ "\",\"" + $.trim(defec.grid[v][0]) + "\",\""+$.trim(defec.grid[v][2])+ "\")'><img src='layer-view-image/v2/search.png?v=2' /></div>";                        
                    	} else {
                        	content += "<div style='left:381px;width:16px;'></div>";
                        }                        
                    }
                }
                if ($.trim(defec.grid[v][5]) == "Verificar") {
                    content += "<div class='btn-verificar' onclick='message(" + $.trim(defec.grid[v][6]) + ",\"" + $.trim(defec.grid[v][7]) + "\")'></div>";

                } else {
                    content += "<div class='row' style='font-size:10px;left:650px;width:69px;text-align:" + dato[5].align + ";'>" + defec.grid[v][5] + "</div>" /*estado*/
                    if(defec.grid[v][5] == "Expirado") {
                    	content += " <div class='row price-info' style='left:468px;width: 47px;' rel='" + count_row + "#" + $.trim(defec.grid[v][12]) + "'>[+]</div>";
                        content += "<div class='tooltip-info-arrow-img tooltip-info-arrow-img-3' style='top:18px; left:320px;'></div>";
                        content += "<div class='tooltip-info2 tooltip-info-3' style='left:310px;top:25px;'></div>";
                        count_row++;
                    }
                }
                content += "<div class='row no-border' style='font-size:10px;left:724px;width:285px;text-align:center;'>" + defec.grid[v][13] + "</div>";  /*canal de venta*/
                content += "</div>";    
            
            }

            return cabecera + content + "</div>";
        }
        function paginator_grid2(){
            $("div#holder2").jPages({
                containerID: "paging2",
                previous: "\u25C4",
                next: "\u25BA",
                perPage: 15,
                midRange: 10
            });
        }
        
        $('.num-pag2').on('click', function () {
            var cadena_pos = $(this).attr('rel');
            var id = $(this).attr('id');
            var posiciones = cadena_pos.split('-');
            $('.state-row_2').hide();
            for (var num in posiciones) {
                $(".state-row_2").eq(posiciones[num]).css("display", "block");
            }
            $('.indice_page').html($('#' + id).html());
            $('.lnk').removeClass('num_page_on num_page_off').addClass("num_page_on");
            $('#' + $(this).attr('id')).removeClass('num_page_on').addClass('num_page_off');
        });
        
    };
    $('#content-tab-item_4').on('click', '.button_anular', function (event) {
        event.preventDefault();
        var $btnAnular = $(this);
        $.ajax({
            type: 'post',
            url: 'anular.html',
            dataType: 'text',
            data: {
                pin: $(this).data('pin')
            },
            beforeSend: function () {
            	container.append("<div id='loader-frm-register'></div>");
            },
            error: function () {
            	container.find('#loader-frm-register').remove();
            },
            success: function (data) {
            	try {
            		$btnAnular.parents('.row_grid').remove();
                    location.reload();
                    container.find('#loader-frm-register').remove();
				} catch (e) {
					container.find('#loader-frm-register').remove();
					console.log(e.message);
				}
            }
        });
        if ($('#content-tab-item_4').find('.button_anular').length == 1) {
            $('#grilla_bcp').html('');
        }
    });
    var $region = $('#region');
    $('#x-region').html(create.optionsList($region));
    var $comMovil = $('#comMovil');
    $('#x-comMovil').html(create.optionsList($comMovil));
    $('.custom-select').on('click', function (a) {
        a.stopPropagation();
        $('#x-' + $(this).data('select')).toggleClass('open');
        $('.option-list').not($(this).children('.option-list')).removeClass('open');
    });
    $('.option-list').on('click', '.option-item', function (a) {
        a.stopPropagation();
        var b = $(this).data('optionValue');
        var c = $(this).parent('ul').data('select');
        $('#' + c).children('option').filter(function () {
            return $(this).val() == b;
        }).prop('selected', true);
        $('.custom-select').removeClass('ui-invalid-output');
        $('#op-sel-' + c).text($(this).text()).removeClass('placeholder');
        $('.option-list').removeClass('open');
    });
    dataClient = run.toJSON($('#DataClient').val());
    initPerfil();
    
    var mailStatus = $('#mailStatus').val();
    if (mailStatus === 'DES') {
        $('#btn-activate').remove();
        $('#txt-activate').remove();
    } else if (mailStatus === 'ACT') {
        $('#btn-activate').remove();
        $('#txt-activate').remove();
    }
   
    $('body').on('mouseover', '.liquidate', function () {
        var index = $(this).data('index');
        $('.liquidate-info').eq(index).css('display', 'inline').eq(index).show();
        $('.liquidate-info-img').eq(index).show();
    });
    $('body').on('mouseout', '.liquidate', function () {
        var index = $(this).data('index');
        $('.liquidate-info').eq(index).hide();
        $('.liquidate-info-img').eq(index).hide();
    });
    $('body').on('click', '#close-liquidate-1', function () {
        $('#back').remove();
        $('#window-liquidate-1').remove();
    });
    $('body').on('click', '#close-liquidate-2', function () {
        $('#back').remove();
        $('#window-liquidate-2').remove();
        window.location.reload();
    });
    $('body').on('submit', '#frm-charge', function (event) {
        event.preventDefault();
        var game = $(this).data('game');
        var amount = parseFloat($.trim($('#amount').val()));
        var p_url = '';
        var image_class = '';
        var accumulated = 0;
        if (game == 'dv') {
            accumulated = parseFloat($.trim(clientBalance.kironPrizeAmount));
            image_class = 'image-dv';
        } else {
            accumulated = parseFloat($.trim(clientBalance.neoprizeAmount));
            image_class = 'image-cyg';
        } if (amount <= accumulated && amount > 0) {
            $.ajax({
                type: $(this).attr('method'),
                url: $(this).attr('action'),
                dataType: $(this).data('response-type'),
                data: $(this).serialize(),
                success: function (e) {
                    var message = $.trim(e);
                    var message_result = '';
                    $('#window-liquidate-1').remove();
                    if (message == 'OK') {
                        message_result = '&iexcl;Felicidades tu boleto de pago ha sido generado! Encu&eacute;ntralo en Mi Cuenta > Mis premios. Impr&iacute;melo y ac&eacute;rcate a partir de ma&ntilde;ana al Punto de Venta m&aacute;s cercano para cobrar tu premio.';
                    } else {
                        message_result = message;
                    }
                    var w = '<div id="window-liquidate-2">' + '<div class="title-window">LIQUIDA TUS PREMIOS ACUMULADOS</div>' + '<input type="button"id="close-liquidate-2" class="close">' + '<div id="content-liquidate-accumulated-prize-2">' + '<div id="message-result-sl"> ' + message_result + '</div>' + '</div>' + '</div>';
                    $('body').append(w);
                }
            })
        } else {
            jAlert('Ingresar un monto V&aacute;lido');
        }
    });
    run.cleanUpTheMess();
    run.hashCheck();
    
};$($user);

function closeLightboxRechargeIlot(){
	$('body').find('#loading-ilot').remove();
	$('#content-tab-item_4').find('#loading-ilot').remove();
	$('#content-tab-item_4').css('display', 'none');
	$('#tab-item_4').css('display', 'block');
	
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
        	$("#billetera3-amount").text(data.billetera3Cant);
        	$("#clientSale-amount-2").text(floatFormat(data.billetera1));
            $(".body-account .saldo-bono").html("Bonos Te Apuesto: "+data.billetera2);
            $(".body-account .saldo-otro").html("Jugadas gratis: "+data.billetera3Cant);
        }
	});
}

var renderUpdateTermsField = function () {
	
	var $input = $('#confirm'),
	    $form = $('#frm-user-update'),
	    $name = $('#name'),
	    $appaterno = $('#ap-paterno'),
	    $documentnumber = $('#document-number'),
	    $documentopasap = $('#document-number-pasap'),
	    $documentocarex = $('#document-number-carex'),
	    $fechanac = $('#fechanac'),
	    $userclient = $('#user-client'),
	    $email = $('#email'),
	    $mobilephone = $('#mobile-phone'),
	    
	    $nacionalidad = $('#nacionalidad'),
	    $domicilio = $('#domicilio'),
	    $departamento = $('#departamento'),
	    $provincia = $('#provincia'),
	    $distrito = $('#distrito'),
	    $ppe = $('#ppe'),
	    
	    onChangeTerms;
	  
	  onChangeTerms = function () {
		 
	    if ($form.isValid({}, {}, false)) {
	      $('#btnUpdatePerfil').attr('disabled', false);
	    } else {
	      $('#btnUpdatePerfil').attr('disabled', true);
	    }
	  };
	
	  $input.on('change', onChangeTerms);
	  
	  $name.on('keyup', onChangeTerms);
	  $appaterno.on('keyup', onChangeTerms);
	  $documentnumber.on('keyup', onChangeTerms);
	  $documentopasap.on('keyup', onChangeTerms);
	  $documentocarex.on('keyup', onChangeTerms);
	  $fechanac.on('change', onChangeTerms);
	  $userclient.on('change', onChangeTerms);
	  $email.on('change', onChangeTerms);
	  $mobilephone.on('change', onChangeTerms);
	  
	  $nacionalidad.on('change', onChangeTerms);
	  $domicilio.on('keyup', onChangeTerms);
	  $departamento.on('change', onChangeTerms);
	  $provincia.on('change', onChangeTerms);
	  $distrito.on('change', onChangeTerms);
	  $ppe.on('change', onChangeTerms);
	  
	  $fechanac.focus(function(){
		  if ( $(this).val()!=''){
			  $(this).blur();
		 }
	  }); 
	  
	  var $select = $('#document-type');
	  
	  $select.focus(function(){
		  if($documentnumber.val()!= '') $select.blur();
		  else if($documentopasap.val()!= '') $select.blur();
		  else if($documentocarex.val()!= '') $select.blur();   
	  });
	  
};


var renderUpdateDataForm = function () {
	var validateInputReg, validateInputReg2, validateInputReg3, validateInputReg4;
	
	  // render fields
	renderDocumentFields();
	if(onCanlendar){
		renderUpdateDateField();
	}	
	//renderPasswordField();
	renderUpdateTermsField();
	
	// restrict fields
//	$('#name, #ap-paterno').alpha({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//	$('#user-client, #document-number-pasap, #document-number-carex').alphanum({allowSpace: false, disallow:'``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©'});
//	$('#email').alphanum({allowSpace: false, allow : '-_+@.'});
	$("#mobile-phone, #document-number").numeric({allowThouSep: false, allowDecSep: false, allowMinus: false});
	$('#fechanac').alphanum({allow: '/', allowUpper: false, allowLower: false});
	
	$('#fechanac').mask('00/00/0000');
	
//	$('#domicilio').alphanum({disallow:'àèìòùÀÈÌÒÙāēīōūĀĒĪŌŪäëïöÄËÏÖâêîôûÂÊÎÔÛãõÃÕåÅąęįĄĘĮæœÆŒªºėĖøØđĐńŃčČçÇćĆšŠ•¥``´´¿¡¨¨‽•√π÷×§∆¢¥✓™®©', allow : '#.,-'});
	
	validateInputReg = function () {
		  // Obtiene el valor actual del campo
	      var inputValue = $(this).val();
	
	      // Elimina caracteres no permitidos
	      inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚäëïöüÄËÏÖÜñÑ\s]/g, '');
	      
	      // Actualiza el valor del campo
	      $(this).val(inputValue);
	  };
	  $('#name, #ap-paterno').on('input', validateInputReg);
	  
	validateInputReg2 = function () {
	  // Obtiene el valor actual del campo
    var inputValue = $(this).val();

    // Elimina caracteres no permitidos
    inputValue = inputValue.replace(/[^a-zA-Z\d]/g, '');
    
    // Actualiza el valor del campo
    $(this).val(inputValue);
	};
	$('#user-client, #document-number-pasap, #document-number-carex').on('input', validateInputReg2);
 
	validateInputReg3 = function () {
	  // Obtiene el valor actual del campo
    var inputValue = $(this).val();

    // Elimina caracteres no permitidos
    inputValue = inputValue.replace(/[^a-zA-Z\d-_+@.]/g, '');
    
    // Actualiza el valor del campo
    $(this).val(inputValue);
	};
	$('#email').on('input', validateInputReg3);
	  
	validateInputReg4 = function () {
	  // Obtiene el valor actual del campo
    var inputValue = $(this).val();

    // Elimina caracteres no permitidos
    inputValue = inputValue.replace(/[^a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\s#°.,-\d]/g, '');
    
    // Actualiza el valor del campo
    $(this).val(inputValue);
	};
	$('#domicilio').on('input', validateInputReg4);
	
	// validate fields
	$.validate({
	 form: '#frm-user-update',
	 modules: 'security, date, logic',
	 scrollToTopOnError: false,
	 onElementValidate : function(valid, $el, $form) {
	   if ($form.isValid({}, {}, false)) {
	     $('#btnUpdatePerfil').attr('disabled', false);
	   } else {
	     $('#btnUpdatePerfil').attr('disabled', true);
	   }
	 },
	 onError: function ($form) {
	   var $error = $form.find('.has-error');
	   if ($error.length > 0) {
	     $error = $error.first();
	     $('html, body').animate({ scrollTop: $error.offset().top - 16 });
	   }
	 },
	 onSuccess: function ($form) {
	   UpdateDataForm($form);
	   return false;
	 }
	});
};

var UpdateDataForm = function($form){
	document.removeEventListener("click", validateSession);
	document.removeEventListener("keypress", validateSession);
	$.ajax({
        url: $form.attr('action'),
        type: $form.attr('method'),
        data: $form.serialize(),
        dataType: $form.data('responseType'),
        beforeSend: function () {
        	$('body').append('<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
        }
	}).done(function(response){
		
    	if(response.result == "OK"){
    		dataClient =  response.DataClient ;
        	initPerfil();
        	$("#isDataComplete").val("1");
        	$("#btnUpdatePerfil").prop("disabled",true);
        	$("#imgPopupPerfil").attr("src","layer-view-image/client/icon-ok.png");
    		$("#popupPerfilTitulo").html('Se actualiz&oacute correctamente los datos de tu perfil');
        	if(response.status == 200){
            	$("#popupPerfilButton").html('<button onclick="closePopupProfile()" class="my-button" type="button" style="width: 50%;">OK</button>');
        	}else if(response.status == 201){
        		$("#popupPerfilButton").html('<button onclick="cerrarSession(\'phone\')" class="my-button" type="button" style="width: 50%;">CERRAR SESI&OacuteN</button>');
        		$("#popupPerfilMensaje").html('Cierra tu sesi&oacuten, vuelve a iniciarla, y activa tu cuenta con el c&oacutedigo que te enviamos por SMS.');
        	} 
        	popup.openModal("#popupMiPerfil","");
        	
    	}else{
//    		jAlert(response.message);
    		var titulo = response.title;
    		var mensaje = response.message;
            var msgError = '<div><div class="titulo-login-error">'+titulo+'</div><br><div class="mensaje-login-error"><span>'+mensaje+'</span></div><br><br>'+
            '<button class="btn btn-login-error"  type="button" onclick="closeModal(this)">Aceptar</button></div>';
            $('#close-popup-message').hide();
            $('#msg-message').html(msgError);
        	openModal("#popup-message","");
        	document.addEventListener("click", validateSession);
			document.addEventListener("keypress", validateSession);
    	}
	}).fail(function(){
		var msg = 'Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.';
		jAlert(msg);
		document.addEventListener("click", validateSession);
		document.addEventListener("keypress", validateSession);
	}).always(function() {
		$('body').find('#loading-recharge').remove();
	});
       
}


var renderUpdatePasswordForm = function () {
	  // render fields
	renderPasswordUpdateField();

	//validate fields
	$.validate({
	form: '#frm-user-password',
	modules: 'security, date, logic',
	scrollToTopOnError: false,
	onModulesLoaded: function () {
	 var config = {
	   bad : '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@). <br> No usar tus últimas 6 contraseñas.</span>',
	   weak : '<ul class="status-level weak"><li></li><li></li><li></li></ul><span>Mínimo 8 caracteres, mayúsculas, minúsculas, números y símbolos ($%&+!@).<br> No usar tus últimas 6 contraseñas.</span>',
	   good : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>',
	   strong : '<ul class="status-level good"><li></li><li></li><li></li></ul><span>CONTRASEÑA SEGURA.</span>'
	 };
	
	 $('#new-password').displayPasswordStrength(config);
	 $('#confirm-password').displayPasswordStrength(config);
	},
	onElementValidate : function(valid, $el, $form) {
	 if ($form.isValid({}, {}, false)) {
	   $('#btnUpdatePassword').attr('disabled', false);
	 } else {
	   $('#btnUpdatePassword').attr('disabled', true);
	 }
	},
	onError: function ($form) {
	 var $error = $form.find('.has-error');
	 if ($error.length > 0) {
	   $error = $error.first();
	   $('html, body').animate({ scrollTop: $error.offset().top - 16 });
	 }
	},
	onSuccess: function ($form) {
	 updatePassForm($form);
	 return false;
	}
	});
};	

var renderPasswordUpdateField = function(){
	var $toggle = $('.toglePasswordUpdate'),
	$input, $field,
	onTogglePasswordUp; 
	
	onTogglePasswordUp = function () {
		$input = $(this).prev();
		$field = $input.parent();

		$field.toggleClass('viewing'); 
		$input.attr("type",$field.hasClass('viewing') ? "text" : "password");
		
	};
	
	$toggle.on('click', onTogglePasswordUp ); 
}

var updatePassForm = function($form){
	
	$.ajax({
        url: $form.attr('action'),
        type: $form.attr('method'),
        data: $form.serialize(),
        dataType: $form.data('responseType'),
        beforeSend: function () {
        	$('body').append('<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
        }
	}).done(function(response){
		
    	if(response.result == "OK"){
        	
			$("#imgPopupPerfil").attr("src","layer-view-image/client/icon-exito.png");
			$("#popupPerfilTitulo").html("&iexcl;Contrase&ntilde;a cambiada!");
			$("#popupPerfilMensaje").html("Vuelve a ingresar con tu usuario y nueva contrase&ntilde;a");
			$("#popupPerfilButton").html('<button onclick="cerrarSession(\'password\')" class="my-button" type="button" style="width: 50%;">OK</button>');
			popup.openModal("#popupMiPerfil","");
        		
    	}else{
    		jAlert(response.message);
    	}
	}).fail(function(){
		var msg = 'Ocurri&oacute; un problema inesperado. Por favor int&eacute;ntelo m&aacute;s tarde.';
		jAlert(msg);
	}).always(function() {
		$('body').find('#loading-recharge').remove();
	});
	
	
}

var cerrarSession = function (data){ 
	if(data == "phone"){
		$.ajax({
		    type: "POST",
		    url: "close-session.html",
		    dataType: "json",
		    async: false,
		    success: function(response){
		    	window.location.href = 'salir.html';
		    }
		});
	}else{
		window.location.href = 'salir.html';
	}
	 
  popup.close();
  
}

var renderUpdateDateField = function () {
	  var $input = $('#fechanac');
	  var bdate = new Date();
	  var sdate = new Date();
	  bdate.setFullYear(bdate.getFullYear() - 18);
	  sdate.setFullYear(sdate.getFullYear() - 100);
	  
	  $input.datepicker({
	    language: 'es-ES',
	    offset: 8,
	    startDate: sdate,
	    endDate: bdate,
	    autoHide: true
	    //trigger: '#dateBirth'
	  });

	  $input.on('show.datepicker', function () {
	    //$input.trigger('focus');
	  });
	  $input.on('hide.datepicker', function () { 
		  $input.trigger('blur');
	  });
	  
	  
	  	
	  
	};

var onCanlendar=true;
var initPerfil = function (){
 
    var userClient = $('#user-client').val(dataClient.user);
//    userClient.parents(".form__input").addClass( userClient.val()!='' ?  'disabledInput' : '');
    userClient.parents(".form__input").addClass('disabledInput');
    userClient.prop('readonly', userClient.val()!='');
    
    var email = $('#email').val(dataClient.email);
    email.parents(".form__input").addClass( (email.val()!='' && dataClient.mailUpdate!='Y') ?  'disabledInput' : '') ;
    email.prop('readonly', (email.val()!='' && dataClient.mailUpdate!='Y'));
    
    var name = $('#name').val(dataClient.fullName); 
    name.parents(".form__input").addClass( name.val()!='' ?  'disabledInput' : '') ;
    name.prop('readonly', name.val()!='');
    
    var lastName = $('#ap-paterno').val(dataClient.lastName);
    lastName.parents(".form__input").addClass( lastName.val()!='' ?  'disabledInput' : '') ;
    lastName.prop('readonly', lastName.val()!='');
    
    renderDocumentPerfil();
    
    var fechaNac = $('#fechanac').val( dataClient.birthDate!='' ?  dataClient.birthDate : ''); 
    fechaNac.parents(".form__input").addClass(fechaNac.val()!='' ?  'disabledInput' : '') ;
    fechaNac.prop('readonly', true);
    $("#showCalendar").css('display',(fechaNac.val()!='') ? 'none' : 'block');
    if(fechaNac.val()!=''){
   	 fechaNac.datepicker('destroy');
    }
    onCanlendar=fechaNac.val()!='' ?  false : true;
    
    var mobilePhone = $('#mobile-phone').val(dataClient.mobilePhone);
    mobilePhone.parents(".form__input").addClass( (mobilePhone.val()!='' && dataClient.mobileUpdate!='Y') ?  'disabledInput' : '') ;
    mobilePhone.prop('readonly', (mobilePhone.val()!='' && dataClient.mobileUpdate!='Y'));
     
    if(dataClient.ppe === '1'){
    	$('#nacionalidad').val(dataClient.nacionalidad);
    	var tnacionalidad = $('#tnacionalidad').val(dataClient.nnacionalidad);
    	tnacionalidad.parents(".form__input").addClass( tnacionalidad.val()!='' ?  'disabledInput' : '') ;
    	tnacionalidad.prop('readonly', tnacionalidad.val()!='');
    	tnacionalidad.parents(".form__input").prop('hidden', tnacionalidad.val()=='');
    	
    	var domicilio = $('#domicilio').val(dataClient.domicilio); 
        domicilio.parents(".form__input").addClass( domicilio.val()!='' ?  'disabledInput' : '') ;
        domicilio.prop('readonly', domicilio.val()!='');
        
    	$('#departamento').val(dataClient.region);
    	var tdepartamento = $('#tdepartamento').val(dataClient.nregion);
    	tdepartamento.parents(".form__input").addClass( tdepartamento.val()!='' ?  'disabledInput' : '') ;
    	tdepartamento.prop('readonly', tdepartamento.val()!='');
    	tdepartamento.parents(".form__input").prop('hidden', tdepartamento.val()=='');
        
    	$('#provincia').val(dataClient.provincia);
        var tprovincia = $('#tprovincia').val(dataClient.nprovincia); 
        tprovincia.parents(".form__input").addClass( tprovincia.val()!='' ?  'disabledInput' : '') ;
        tprovincia.prop('readonly', tprovincia.val()!='');
        tprovincia.parents(".form__input").prop('hidden', tprovincia.val()=='');
        
        $('#distrito').val(dataClient.distrito);
        var tdistrito = $('#tdistrito').val(dataClient.ndistrito); 
        tdistrito.parents(".form__input").addClass( tdistrito.val()!='' ?  'disabledInput' : '') ;
        tdistrito.prop('readonly', tdistrito.val()!='');
        tdistrito.parents(".form__input").prop('hidden', tdistrito.val()=='');
    }
    if($('#ppe').length>0){
    	var ppe = $('#ppe').prop('checked', (dataClient.ppe === '1'));
    	ppe.parents(".form__check").addClass( dataClient.ppe === '1' ?  'disabledInput2' : '') ;
    	ppe.prop('readonly', dataClient.ppe === '1');
    	
    }
    
    
    $('#confirm').prop('checked', (dataClient.confirm === 'Y'));
    
}

var renderDocumentPerfil = function () {
	 
  var $select = $('#document-type'),
    $fields = $('.form__optional'),
    $input=$('#document-number'),
    isTipoDoc = false;
    //dataClient.typeId dataClient.numberId
  	if(dataClient.typeId != null)
  		$select.val(dataClient.typeId);
  	else
  		$select.val('');
  	
    switch ($select.val()) {
    case 'DNI':
      $input = $('#document-number');
      isTipoDoc = true;
      break;
    case 'PASAP':
      $input = $('#document-number-pasap');
      isTipoDoc = true;
      break;
    case 'CAREX':
      $input = $('#document-number-carex');
      isTipoDoc = true;
      break;
    }

    $fields.hide(0);
    
    if (isTipoDoc) {
      $input.parent().show(0);
      $input.val(dataClient.numberId).attr('disabled', false);
      $input.parents(".form__input").addClass( $input.val()!='' ?  'disabledInput' : '');
      $input.prop("readonly",$input.val()!='');
      $select.parents(".form__select").addClass( $select.val()!='' ?  'disabledInput' : '');
      $select.prop("readonly",$select.val()!='');
    } else {
      $select.val('DNI');
      $input.parent().show(0);
      $input.val('').attr('disabled', false).focus();
    } 
};

function closePopupProfile(){
	if($('#departamento')[0].tagName === 'SELECT'){
		//nacionalidad
		var valor=$("#nacionalidad").val();
		var texto=$("#nacionalidad option[value='"+valor+"']").text();
		$( "#div-nacionalidad" ).remove();
		$( "#div_nacionalidad2" ).append( '<input type="text" name="nacionalidad" id="nacionalidad" hidden="">' );
		$( "#div_nacionalidad2" ).append( '<div class="form__input">'+
	            '<label for="tnacionalidad">Nacionalidad</label>'+	
				  '<input type="text" name="tnacionalidad" id="tnacionalidad" tabindex="19" data-validation="required" data-validation-error-msg="Seleccionar tu pa&iacute;s">'+
	          '</div>' );					
		$('#nacionalidad').val(valor);
		$('#tnacionalidad').val(texto);
		var tnacionalidad = $('#tnacionalidad'); 
		tnacionalidad.parents(".form__input").addClass( tnacionalidad.val()!='' ?  'disabledInput' : '') ;
		tnacionalidad.parents(".form__input").addClass( tnacionalidad.val()!='' ?  'filled' : '') ;
		tnacionalidad.prop('readonly', tnacionalidad.val()!='');
		
		//departamento
		var valor=$("#departamento").val();
		var texto=$("#departamento option[value='"+valor+"']").text();
		$( "#div-departamento" ).remove();
		$( "#contact-information" ).append( '<input type="text" name="departamento" id="departamento" hidden="">' );
		$( "#contact-information" ).append( '<div class="form__input">'+
	            '<label for="departamento">Departamento</label>'+	
				  '<input type="text" name="tdepartamento" id="tdepartamento" tabindex="21" data-validation="required" data-validation-error-msg="Seleccionar tu departamento">'+
	          '</div>' );	
		$('#departamento').val(valor);
		$('#tdepartamento').val(texto);
		var tdepartamento = $('#tdepartamento'); 
		tdepartamento.parents(".form__input").addClass( tdepartamento.val()!='' ?  'disabledInput' : '') ;
		tdepartamento.parents(".form__input").addClass( tdepartamento.val()!='' ?  'filled' : '') ;
		tdepartamento.prop('readonly', tdepartamento.val()!='');
		
		//provincia
		valor=$("#provincia").val();
		texto=$("#provincia option[value='"+valor+"']").text();
		$( "#div-provincia" ).remove();
		$( "#contact-information" ).append( '<input type="text" name="provincia" id="provincia" hidden="">' );
		$( "#contact-information" ).append( '<div class="form__input">'+
	            '<label for="provincia">Provincia</label>'+	
				  '<input type="text" name="tprovincia" id="tprovincia" tabindex="22" data-validation="required" data-validation-error-msg="Seleccionar tu provincia">'+
	          '</div>' );	
		$('#provincia').val(valor);
		$('#tprovincia').val(texto);
		var tprovincia = $('#tprovincia'); 
		tprovincia.parents(".form__input").addClass( tprovincia.val()!='' ?  'disabledInput' : '') ;
		tprovincia.parents(".form__input").addClass( tprovincia.val()!='' ?  'filled' : '') ;
		tprovincia.prop('readonly', tprovincia.val()!='');
		
		//distrito
		valor=$("#distrito").val();
		texto=$("#distrito option[value='"+valor+"']").text();
		$( "#div-distrito" ).remove();
		$( "#contact-information" ).append( '<input type="text" name="distrito" id="distrito" hidden="">' );
		$( "#contact-information" ).append( '<div class="form__input">'+
	            '<label for="distrito">Distrito</label> '+	
				  '<input type="text" name="tdistrito" id="tdistrito" tabindex="23" data-validation="required" data-validation-error-msg="Seleccionar tu distrito">'+
	          '</div>' );			
		$('#distrito').val(valor);
		$('#tdistrito').val(texto);
		var tdistrito = $('#tdistrito'); 
		tdistrito.parents(".form__input").addClass( tdistrito.val()!='' ?  'disabledInput' : '') ;
		tdistrito.parents(".form__input").addClass( tdistrito.val()!='' ?  'filled' : '') ;
		tdistrito.prop('readonly', tdistrito.val()!='');
	}
	$('#clientSale-name').text($('#name').val());
	popup.close();
}

var renderDateJugadas = function () {
    // Seleccionar los elementos
    var $inputinicio = $('#fecha_inicio');
    var $inputfin = $('#fecha_fin');
    
    // Inicializar el módulo de calendario
    calendarModule($inputinicio, $inputfin);
};

var calendarModule = function ($inputinicio, $inputfin) {
	
    var maxDate = new Date();
    var minDate = new Date();
    minDate.setFullYear(maxDate.getFullYear() - 2);

    var isUpdating = false; //Evitar recursión infinita

    function formatDate(date) {
        return date.toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' });
    }

    function calculateEndDate(startDate) {
        var thirtyDaysLater = new Date(startDate);
        thirtyDaysLater.setDate(startDate.getDate() + 29); // Sumamos 29 días al día de inicio (inclusivo)
        return thirtyDaysLater;
    }

    function calculateStartDate(endDate) {
        var thirtyDaysBefore = new Date(endDate);
        thirtyDaysBefore.setDate(endDate.getDate() - 29); // Restar 29 días al día de fin (inclusivo)
        return thirtyDaysBefore;
    }

    // Actualiza fecha fin cuando seleccionas fecha de inicio
    function updateEndDate(startDate) {
        var endDate = calculateEndDate(startDate);
        if (endDate > maxDate) {
            $inputfin.datepicker('setDate', maxDate); // Establece la fecha fin como la fecha actual
            $inputfin.val(formatDate(maxDate)); // Muestra la fecha actual en el input
        } else {
            $inputfin.datepicker('setDate', endDate); // Establece la fecha fin calculada
            $inputfin.val(formatDate(endDate)); // Muestra la fecha calculada en el input
        }

        if (!isUpdating) {
            isUpdating = true;
            $inputinicio.datepicker('setDate', startDate);
            $inputinicio.val(formatDate(startDate));
            isUpdating = false;
        }
    }

    //Actualizar fecha de inicio cuando seleccionas fecha fin
    function updateStartDate(endDate) {
    	
    	// Obtener la fecha de inicio desde el input #fecha_inicio
        var startDate = new Date($inputinicio.val().split('/').reverse().join('-'));
        
        // Calcular la diferencia de días entre las fechas de inicio y fin
        var diffTime = Math.abs(endDate - startDate);
        var diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24)); // Convertir la diferencia a días
        
        console.log("diffTime: " + diffTime);
        console.log("diffDays: " + diffDays);
    	
    	if(diffDays > 30){
            var startDate = calculateStartDate(endDate);
            if (!isUpdating) {
                isUpdating = true;
                $inputinicio.datepicker('setDate', startDate);
                $inputinicio.val(formatDate(startDate));
                isUpdating = false;
            }
    	}

    }

    function initializeDatePicker(element, isStartDate) {
        element.datepicker({
            language: 'es-ES',
            autoHide: true,
            format: 'dd/mm/yyyy',
            startDate: minDate,
            endDate: maxDate,
            autoclose: true,
            startView: 'days',
            minView: 'days'
        }).on('pick.datepicker', function (e) {
            e.preventDefault();
            var selectedDate = e.date;
            element.val(formatDate(selectedDate));         
            isStartDate ? updateEndDate(selectedDate) : updateStartDate(selectedDate);
        });
    }

    initializeDatePicker($inputinicio, true);
    initializeDatePicker($inputfin, false);

};


function changeFila_grid2() {
	var newPerPage = parseInt($("#fila-id").val());
	$("div#holder2").jPages("destroy").jPages({
	    containerID: "paging2",
	    previous: "\u25C4",
	    next: "\u25BA",
	    perPage: newPerPage,
	    midRange: 10
	});
}

function changeFila_grid3() {
	var newPerPage = parseInt($("#fila-idmov").val());
	$("div#holder3").jPages("destroy").jPages({
	    containerID: "paging3",
	    previous: "\u25C4",
	    next: "\u25BA",
	    perPage: newPerPage,
	    midRange: 10
	});
}

function hideDatepicker() {
	if($(".datepicker-container").is(':visible')) {  
	    $(".datepicker-container").hide();
	}
}

/*Invocar calendario de fechas para ver mis movimientos*/
var renderDateMovimientos = function () {
    // Seleccionar los elementos
    var $inputinicio = $('#filterfechainicio');
    var $inputfin = $('#filterfechafin');
    
    // Inicializar el módulo de calendario
    calendarModule($inputinicio, $inputfin); 
};


$('#content-tab-item_3').on('mouseover', '.price-info', function () {
    var contenido_total = $(this).attr('rel');
    var contenido_temp = (contenido_total + '').split('#');
    var posicion = parseInt(contenido_temp[0]);
    var mensaje = contenido_temp[1] + "";

    $(".tooltip-info-3").eq(posicion).show().html(mensaje.replace('__', '<br>'));
    $(".tooltip-info-arrow-img-3").eq(posicion).show();
    let tablaHeight = parseInt(document.getElementById("content-tab-item_3").querySelectorAll('.state-row_2[style*="opacity: 1"]').length)*17+10;
    let cItem = document.getElementById("content-tab-item_3").querySelectorAll('.price-info').length;
    let paginador = parseInt($("#fila-id").val());
    	
    let toolsize =   parseInt($(".tooltip-info-3").eq(posicion).height())+ parseInt($(".tooltip-info-arrow-img-3").eq(posicion).height());
    let pos = posicion +1;
    let posHeight = 0;
    posHeight = (paginador > pos) ? ((Math.floor(pos % paginador) * 17) +20) : ((pos * 17) + 20);
    posHeight+=toolsize;
    if(posHeight > tablaHeight) {
    	$("#paging2").css("padding-bottom", (posHeight-tablaHeight) + "px");
    }
}).on('mouseout', '.price-info', function () {
    var contenido_total = $(this).attr("rel");
    var contenido_temp = contenido_total.split("#");
    var posicion = parseInt(contenido_temp[0]);
    var mensaje = contenido_temp[1];
    $(".tooltip-info-3").eq(posicion).hide().html(mensaje.replace('__', '<br>'));
    $(".tooltip-info-arrow-img-3").eq(posicion).hide();
    $("#paging2").css("padding-bottom","0px");
})

$('#content-tab-item_5').on('mouseover', '.price-info', function () {
    var contenido_total = $(this).attr('rel');
    var contenido_temp = (contenido_total + '').split('#');
    var posicion = parseInt(contenido_temp[0]);
    var mensaje = contenido_temp[1] + "";
    $(".tooltip-info-5").eq(posicion).show().html(mensaje.replace('__', '<br>'));
    $(".tooltip-info-arrow-img-5").eq(posicion).show();
    let cItem = document.getElementById("content-tab-item_5").querySelectorAll('.price-info').length;
    let paginador = parseInt($("#fila-idmov").val());
    let pos = posicion +1;
    if(paginador < cItem) {
    	
    	if((pos+1)%paginador==0) {
    		$("#paging3").css("padding-bottom","19px");
    	} else if(pos%paginador==0) {
    		$("#paging3").css("padding-bottom","39px");
    	}
    	
    } else {
    	if(posicion==(cItem-1)) {
    		$("#paging3").css("padding-bottom","39px");
        } else if(posicion==(cItem-2)) {
        	$("#paging3").css("padding-bottom","19px");
        }
    }
    
}).on('mouseout', '.price-info', function () {
    var contenido_total = $(this).attr("rel");
    var contenido_temp = contenido_total.split("#");
    var posicion = parseInt(contenido_temp[0]);
    var mensaje = contenido_temp[1];
    $(".tooltip-info-5").eq(posicion).hide().html(mensaje.replace('__', '<br>'));
    $(".tooltip-info-arrow-img-5").eq(posicion).hide();
    $("#paging3").css("padding-bottom","0px");
})
