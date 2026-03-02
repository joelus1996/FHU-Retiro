var total = 0;
var count = 0;
var count1 = 0;
var sub_total = 0;
var contador1 = 0;
var cantin1 = 0;
var content_object = [];
var combo_fecha = "";
var status = "";
var value_number1 = [];
var algorithm = "";
var costoTotalBet = 0;
var costoTotalBetMensaje = 0;
var bets = 0;
var pay = 0;
var cost = 0;
var draw = 0;
var sorteos = 0;
var consecutive = 0;
var price_type = "";
var promo = "";
var v_data_value_bet = 0;
var new_content_object = [];
var array_no_procesados = [];
var idsession = 0;
var price_base = 0;

var run = {
setup: function () {
    status = $("#status").val();
    algorithm = $("#algorithm").val();
    bets = $("#bets").val();
    pay = $("#pay").val();
    cost = $("#cost").val();
    draw = $("#draw").val();
    price_type = $("#price_type").val();
    promo = $("#promo").val();
    v_data_value_bet = $("#simpleBetPrice_repeated").val();
    idsession = $("#clientId").val();
    price_base = parseFloat($("#base_price").val());
 
    $('#game-code-header').val(41); 
   
    if(idsession != '' && $("#agreement").val() == ''){
      $("#login_section").show();
    $('.img_zona_segura').css({"margin-top":"93px"});
      exe.opentyc(null);
    } else if (idsession == '') {
        $("#login_section").show();
    $('.img_zona_segura').css({"margin-top":"93px"});
    } else {
        $("#panel_finaliza_compra").show();
        flagFinalizar=true;
        $("#tab-item_4").show();
        $("#payments_section").show();
    $('.img_zona_segura').css({"margin-top":"0px"});
    }
    $(".label_2").html(fecha_actual());
    $("#plays-1").addClass("active");
}};
var $tinkaSubscription = function () {
  run.setup();
    $("input[type=checkbox]").change(function () {
        var id_value = $(this).attr("id");
        var first_letter_id = $(this).attr("name");
        var number_id = $(this).val();
        if($(this).is(":checked")) {
            if(count <= 15) {
                count = util(first_letter_id, 1);
                if(sub_total <= 5005) {
                   $(this).prop('checked', true);
                    array_number(number_id, first_letter_id);
                    $("#lbl"+ id_value).addClass("colorChecked");
                    combinatoria();
                }
                if(count > 15 || sub_total > 5005) {
                    $("#lbl" + id_value).removeClass("colorChecked");
                    $(this).prop('checked', false);
                    count = util(first_letter_id, 2);
                    delete_array_number(number_id, first_letter_id);
                    combinatoria();
                }
            }
        } else {
            count = util(first_letter_id, 2);
            $(this).prop('checked', false);
            delete_array_number(number_id, first_letter_id);
            $("#lbl" + id_value).removeClass("colorChecked");
            combinatoria();
        }
    });
    $(".clear").click(function () {
        if (status == "ACT") {
            var title = $(this).attr("id").substr(5);
            clear_for_ini(title);
            combinatoria();
            if(dataLayerlimpiar){
            	datalayerJugada(this,'Elige tu Combo Tinkero');
            }
        }
    });
    $(".azar").click(function () {
        if (status == "ACT") {
            if (sub_total < 5005) {
                var ini;
                var title = $(this).attr("id").substr(4);
                if(title == "chk1") count = count1;
                if(count >= 6) {
                    count = 0;
                    clear_for_ini(title);
                }
                while (count < 6) {
                    var number_azar = Math.round(1 + (Math.random() * (50 - 1)));
                    if(buscar_repetido(number_azar, title)) {
                      $("#"+title+"-"+number_azar).prop("checked", true);
                      $("#lbl"+title+"-"+number_azar).addClass("colorChecked");
                        array_number(number_azar, title);
                        count = util(title, 1);
                    }
                }
                combinatoria();
                try {
                	datalayerJugada(this,'Elige tu Combo Tinkero');
                	tagginAlAzar("Tinka");		
    			} catch (e) {
    				console.error(e);
    			}
                
            }
        }
    });
      $('.more').click(function () {
          if (status == "ACT") {
              if (sub_total < 5005) {
                  var more = [];
                  var title = $(this).attr("id").substr(4);
                  var more2;
                  more2 = $("#more_repeated").val();
                  more = more2.split(" ");
                  var size = more.length;
                  clear_for_ini(title);
                  count = util(title, 4);
                  for (i = 0; i < size; i++) {
                    $("#"+title+"-"+more[i]).prop("checked", true);
                    $("#lbl"+title+"-"+more[i]).addClass("colorChecked");
                      array_number(more[i], title);
                  }
                  combinatoria();
              }
          }
      });
      $('.less').click(function () {
          if (status == "ACT") {
              if (sub_total < 5005) {
                  var more = [];
                  var title = $(this).attr("id").substr(4);
                  var more2;
                  more2 = $("#less_repeated").val();
                  more = more2.split(" ");
                  var size = more.length;
                  clear_for_ini(title);
                  count = util(title, 4);
                  for (i = 0; i < size; i++) {
                    $("#"+title+"-"+more[i]).prop("checked", true);
                    $("#lbl"+title+"-"+more[i]).addClass("colorChecked");
                      array_number(more[i], title);
                  }
                  combinatoria();
              }
          }
      });
      $(".left-panel").on("click",".process-delete",function(){
    	  try {
    		  tagginTinkaRemoveFromCart(content_object[0]);
    		  datalayerRemoveFromCart(content_object[0],content_object[0][6]/content_object[0][9]);
			} catch (e) {
				console.error(e);
			}
    	  
    	  window.location.href = "juega-tinka.html";
    	  
    	  /******
    	  var pos = parseInt($(this).attr("rel"));
          content_object.splice(pos, 1);
      $("#content-subscribe-grid-result").html("");
          var costo_total = 0;
          for(var i in content_object) {
              costo_total += content_object[i][6]
          }
          $(".result1_subscribe").html("S/ 0.00");
        $('.step-play').removeClass('step-active');
        $('.step-status-1').addClass('step-active');
        $("#start_subscribe_play").removeClass("disabled");
        $(".finalize-subscribe-purchase").addClass("disabled");
        $('.subscription-disabled-sec1').addClass('subscription-disabled');
        $('.subscription-disabled-sec2').addClass('subscription-disabled');
        $('.option-subscription').removeClass('option-subscription-actived').removeClass('btn-active');
        $("#btn_desktop_combo_tinkero_azar_simple").removeClass("btn-active");
        $("#btn_desktop_combo_tinkero_misma_jugada").removeClass("btn-active");
          sorteos = 1;
          consecutive = 1;
          costoTotalBet = 0;
          costoTotalBetMensaje = 0;
         *****/ 
      });
      $(".left-panel").on("mouseover",".row-info",function(){
          var posicion = $(this).attr("rel");
          var content_info = "";
          var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
          for (var i = 0; i <= 3; i++) {
              content_object[posicion][i] = $.trim(content_object[posicion][i]);
              if (content_object[posicion][i] != "00") {
                  if (content_object[posicion][i] != "null") {
                      var test = (content_object[posicion][i] + "").split("-");
                      if (test[1] != "null") {
                          var numeros = (content_object[posicion][i] + "").split(",");
                          var result_ticket = "";
                          for (var num in numeros) {
                              if (numeros[num].length < 2) {
                                  numeros[num] = "0" + numeros[num]
                              }
                              result_ticket += numeros[num] + " "
                          }
                          content_info += nom_jugadas[i] + ": " + result_ticket + "<br>"
                      }
                  }
              }
          }
          $(".tooltip-info").eq(posicion).show();
          $(".tooltip-info").eq(posicion).html(content_info);
          $(".tooltip-info-arrow-img").eq(posicion).show()
      });
      $(".left-panel").on("mouseout",".row-info",function(){
          var posicion = $(this).attr("rel");
          $(".tooltip-info").eq(posicion).hide();
          $(".tooltip-info-arrow-img").eq(posicion).hide()
      });
      $('.left-panel').on('mouseover','.no-process',function(){
          var contenido_total = $(this).attr("rel");
          var contenido_temp = (contenido_total + "").split("#");
          var posicion = parseInt(contenido_temp[0]);
          var mensaje = (contenido_temp[1] + "").replace(/\*/g,"<br/>");
          $(".tooltip-no-process").eq(posicion).show();
          $(".tooltip-no-process").eq(posicion).html(mensaje);
          $(".tooltip-no-process-arrow-img").eq(posicion).show()
      });
      $('.left-panel').on('mouseout','.no-process',function(){
          var contenido_total = $(this).attr("rel");
          var contenido_temp = contenido_total.split("#");
          var posicion = parseInt(contenido_temp[0]);
          var mensaje = contenido_temp[1];
          $(".tooltip-no-process").eq(posicion).hide();
          $(".tooltip-no-process").eq(posicion).html(mensaje);
          $(".tooltip-no-process-arrow-img").eq(posicion).hide()
      });
      $('.left-panel').on('click','#btn-no-process',function(){
          $("#panel_keep-playing").hide();
          $("#panel_game-history").hide();
          $("#block-subscription").addClass("disabled");
          $("#sub_panel").show();
          $("#panel_finaliza_compra").show();
          var temp_jugada_2 = "<span class='label_1'>SUSCRIPCI&Oacute;N TINKA POR ADELANTADO</span><div id='content-subscribe-grid-result'></div><div id='num_subscribe_link'></div>";
          $(".left-panel").html(temp_jugada_2);
          if (status == "ACT") {
              $('.transition-one').hide();
              $('.transition-two').show();
              $('#start_play').hide();
              $('.finalize-purchase').show();
              var precio = costoTotalBet;
              var grilla = "<div id='grilla_boleto'><div class='boleto_cabecera'><div class='head_title_1'>N.</div><div class='head_title_2'>JUGADA</div><div class='head_title_3'>ANULAR</div></div>";
              var result_ticket = "";
              if(!content_object[0][0]) {
                result_ticket = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>AL AZAR</b>";
              } else {
                result_ticket = "<b>A</b>: ";
                var numeros = (content_object[0][0]+"").split(",");
                for(var num in numeros) {
                  if(numeros[num].length < 2) numeros[num] = "0" + numeros[num];
                  result_ticket += numeros[num] + " "
                }
                result_ticket = ((result_ticket.length>27)?result_ticket.substring(0, 25):result_ticket) + "&nbsp;&nbsp;<span class='row-info' rel='0'>[+]</span><div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div>";
              }
              grilla += "<div class='row_grid'><div class='column_1'>1</div><div class='column_2'>" + result_ticket + "</div><div class='column_3'><div class='delete process-delete' rel='0'>x</div></div></div></div></div>";
              $("#content-subscribe-grid-result").html(grilla);
              dataLayerlimpiar = false;
              $(".clear").click();
              dataLayerlimpiar = true;
              var percent = parseFloat(content_object[0][4]);
              var costo_total = parseFloat(content_object[0][6]);
            var costo_bruto = parseFloat(content_object[0][7]);
            var costo_desc = (percent/100)*costo_bruto;
            $(".right-panel .result_purchase").css("height","54px");
            $(".result1_subscribe").html("S/ " + peformat(costo_total));
            $(".result2_subscribe").html("S/ " + peformat(costo_bruto));
            $(".result3_subscribe").html("(S/ " + peformat(costo_desc)+")");
            $(".label_resu3_subscribe").html("Descuento de "+percent+"%:");
            $(".label_resu4_subscribe").html("");
              $(".result4_subscribe").html("");
            clear_all();
          }
      });
      $("#option-card-0").click(function () {
          $("#panel_transaccion_1").hide();
          $("#panel_transaccion_2").hide();
          $("#panel_transaccion_3").hide();
      $("#panel_transaccion_4").hide();
      $("#panel_transaccion_5").hide();
      });
      $("#option-card-1").click(function () {
          $("#panel_transaccion_1").show();
          $("#panel_transaccion_2").hide();
          $("#panel_transaccion_3").hide();
      $("#panel_transaccion_4").hide();
      $("#panel_transaccion_5").hide();
      });
      $("#option-card-2").click(function () {
          $("#panel_transaccion_1").hide();
          $("#panel_transaccion_2").show();
          $("#panel_transaccion_3").hide();
      $("#panel_transaccion_4").hide();
      $("#panel_transaccion_5").hide();
      });
      $("#option-card-3").click(function () {
          $("#panel_transaccion_1").hide();
          $("#panel_transaccion_2").hide();
          $("#panel_transaccion_3").show();
      $("#panel_transaccion_4").hide();
      $("#panel_transaccion_5").hide();
      })
    $("#option-card-4").click(function () {
      $("#panel_transaccion_1").hide();
      $("#panel_transaccion_2").hide();
      $("#panel_transaccion_3").hide();
      $("#panel_transaccion_4").show();
      $("#panel_transaccion_5").hide();
    })
    $("#option-card-5").click(function () {
      $("#panel_transaccion_1").hide();
      $("#panel_transaccion_2").hide();
      $("#panel_transaccion_3").hide();
      $("#panel_transaccion_5").show();
      $("#panel_transaccion_4").hide();
    })
    
    $("#pagoEfecHelp").click(function(e) {
      var pagoEfectivoHelp="layer-view-interface/client/como_funciona_pagoefectivo.jsp";
      dhtmlwindow.open('resultbox', 'iframe',pagoEfectivoHelp, '¿Cómo funciona PagoEfectivo?', 'width=600,height=635px,scrolling=0,center=1,resize=0', 'recal');
      });
    $(document).on("click", "#btn_desktop_combos_tinkeros", function(){
      clear_all();
      $(".panel-subscription").addClass("disabled");
      $(".panel-subscription-book").removeClass("disabled");
      try {
    	  tagginEligeJugadaComboTinka();				
    	  datalayerBtnsTipoJuego(this,'¡Combos Tinkeros! No te pierdas ni un sorteo');
		} catch (e) {
			console.error(e);
		}
      
    });
    $(document).on("click", "#btn_desktop_juega_tinka", function(){
      datalayerBtnsTipoJuego(this,'¡Combos Tinkeros! No te pierdas ni un sorteo');
      window.location.href = 'juega-tinka.html?state=1';
    });
    $(document).on("click", "#btn_desktop_combo_tinkero_misma_jugada", function(e){
      e.preventDefault();
      clear_all();
      $('.subscription-disabled-sec1').removeClass('subscription-disabled');
      $('.subscription-disabled-sec2').removeClass('subscription-disabled');
      $('.option-subscription').removeClass('option-subscription-actived')
      $(this).addClass('option-subscription-actived');
      $("#btn_desktop_combo_tinkero_misma_jugada").addClass("btn-active");
      $("#btn_desktop_combo_tinkero_azar_simple").removeClass("btn-active");
      datalayerJugada(this,'Elige tu Combo Tinkero');
    });
    $(document).on("click", "#btn_desktop_combo_tinkero_azar_simple", function(e){
      e.preventDefault();
      clear_all();
      $('.subscription-disabled-sec1').addClass('subscription-disabled');
      $('.subscription-disabled-sec2').removeClass('subscription-disabled');
      $('.option-subscription').removeClass('option-subscription-actived')
      $(this).addClass('option-subscription-actived');
      $("#btn_desktop_combo_tinkero_azar_simple").addClass("btn-active");
      $("#btn_desktop_combo_tinkero_misma_jugada").removeClass("btn-active");
      datalayerJugada("Jugada simple al 'Azar' para cada sorteo *",'Elige tu Combo Tinkero');
    });
    $(document).on("click", ".btn-discount10", function(){
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount30").removeClass("discount30-active");
      $(".btn-discount40").removeClass("discount40-active");
      $(".btn-discount10").addClass("discount10-active");
      $("#inp_desktop_combo_8_sorteos_tinka").prop("checked",true);
      combinatoria();
    });
    $(document).on("click", ".btn-discount20", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount30").removeClass("discount30-active");
      $(".btn-discount40").removeClass("discount40-active");
      $(".btn-discount20").addClass("discount20-active");
      $("#inp_desktop_combo_24_sorteos_tinka").prop("checked",true);
      combinatoria();
    });
    $(document).on("click", ".btn-discount30", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount40").removeClass("discount40-active");
      $(".btn-discount30").addClass("discount30-active");
      $("#inp_desktop_combo_48_sorteos_tinka").prop("checked",true);
      combinatoria();
    });
    $(document).on("click", ".btn-discount40", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount30").removeClass("discount30-active");
      $(".btn-discount40").addClass("discount40-active");
      $("#inp_desktop_combo_96_sorteos_tinka").prop("checked",true);
      combinatoria();
    });
    $(document).on("change", ".number-textarea-button2 input[name=discount]", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount30").removeClass("discount30-active");
      $(".btn-discount40").removeClass("discount40-active");
      $(".btn-"+$(this).attr("id")).addClass($(this).attr("id")+"-active");
      combinatoria();
      
    });
    
  $(document).on("click","#btn_desktop_comprar_combo_tinkero", function () {
		// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
		// es una function que se realizará en caso no tenga docs pendientes de confirmacion
		mainValidatePendingsDocsForAproval('lottoTinkaSubscriptionComprarComboTinkero');
  });
  
  var thisBtnFinalizarCompraComboTinkero = null;
  $(document).on("click", "#btn_desktop_finalizar_compra_combo_tinkero", function () {
	  	thisBtnFinalizarCompraComboTinkero = this;
	  	// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
		// es una function que se realizará en caso no tenga docs pendientes de confirmacion
		mainValidatePendingsDocsForAproval('lottoTinkaSubscriptionFinalizarCompraComboTinkero');
  });
  
  function comprarComboTinkero(){
	  if(status=="ACT"){

	      var percent = 0;
	      var message ="";
	      $("input[name=discount]:checked").each(function(i) {
	        percent = parseFloat($(this).data("discount").split("_")[0]);
	      });
	      if(!$("#btn_desktop_combo_tinkero_misma_jugada").hasClass("btn-active") && !$("#btn_desktop_combo_tinkero_azar_simple").hasClass("btn-active")) {
	    	  message= "No ha elegido ninguna jugada.";
	    	  try {
					tagginPopupError("Tinka",message);				
					datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
				} catch (e) {
					console.error(e);
				}
	    	  
	        jAlert(message, null);
	      } else if($("#btn_desktop_combo_tinkero_misma_jugada").hasClass("btn-active") && (total<1 || percent==0)) {
	    	  message="Elige correctamente tu apuesta.";
	    	  try {
	    		  var errorTagging="";
	    		  if(value_number1.length<=0){
	    			  errorTagging="Elegir bolillas";
	    		  }else{
	    			  errorTagging="Elegir combo";
	    		  }
	    		  datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',message);
	    		  tagginPopupError("Tinka",errorTagging);				
				} catch (e) {
					console.error(e);
				}
	    	  
	        jAlert(message, null);
	      } else if($("#btn_desktop_combo_tinkero_azar_simple").hasClass("btn-active") && percent==0) {
	    	  message="Elige un per&iacute;odo de suscripci&oacute;n.";
	    	  try {
	    		  var errorTagging="Elegir combo";
	    		  tagginPopupError("Tinka",errorTagging);				
	    		  datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar','Elige un período de suscripción');
				} catch (e) {
					console.error(e);
				}
	    	  
	        jAlert(message, null);
	      } else {
//	    	  setCaptchaJuego();
	    	  try {
	    		  tagginEEaddToCart("Tinka",consecutive,costoTotalBet);
				} catch (e) {
					console.error(e);
				}
	  		
//	  		console.log("consecutive "+consecutive);
//	  		console.log("costoTotalBet"+costoTotalBet);
	    	  
	    	  $("#index-btnlogin").prop("disabled",true);
	          $('.step-play').removeClass('step-active');
	          $('.step-status-2').addClass('step-active');
	        $("#start_subscribe_play").addClass("disabled");
	        $(".finalize-subscribe-purchase").removeClass("disabled");
	        
	        var object_boleto = [];
	        object_boleto.push(value_number1);
	          object_boleto.push(null);
	          object_boleto.push(null);
	          object_boleto.push(null);
	          object_boleto.push(percent);
	          object_boleto.push(consecutive);//(sorteos);
	          object_boleto.push(costoTotalBet);
	          object_boleto.push(costoTotalBetMensaje);
	          if($("#btn_desktop_combo_tinkero_misma_jugada").hasClass("btn-active")){
	        	  object_boleto.push(1);
	          }
	          if($("#btn_desktop_combo_tinkero_azar_simple").hasClass("btn-active")){
	        	  object_boleto.push(2);
	          } 
	          object_boleto.push($("#total-bets").text());
	          content_object.push(object_boleto);  
	          try {
	        	  tagginFinalizar();
	            	tagginTinkaEEcheckout(); 			
	            	datalayerAddToCart(object_boleto,object_boleto[6]/object_boleto[9]);
	            	datalayerFinalizaCompra1($('#btn_desktop_comprar_combo_tinkero'),'Comprar');
				} catch (e) {
					console.error(e);
				}
	          	         	
	          for (var v in content_object) {
	                  for (var w = 0; w <= 3; w++) {
	            var game = "";
	            if(content_object[v][w] != "") {
	              var games = (content_object[v][w] + "").split(",");
	              for(var t in games) {
	                              if(games[t].length < 2) games[t] = "0" + games[t];
	                              game += games[t] + " ";
	                          }
	                          content_object[v][w] = $.trim(game);
	                      } else {
	                          content_object[v][w] = "00";
	                      }
	                }
	          }
	          var grilla = "<div id='grilla_boleto'><div class='boleto_cabecera'><div class='head_title_1'>N.</div><div class='head_title_2'>JUGADA</div><div class='head_title_3'>ANULAR</div></div>";
	                var result_ticket = "";
	                if($("#btn_desktop_combo_tinkero_azar_simple").hasClass("btn-active")) {
	                  result_ticket = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>AL AZAR</b>";
	                } else {
	                          result_ticket = "<b>A</b>: ";
	                          var numeros = (value_number1+"").split(",");
	                          for(var num in numeros) {
	                              if(numeros[num].length < 2) numeros[num] = "0" + numeros[num];
	                              result_ticket += numeros[num] + " ";
	                          }
	                          result_ticket = ((result_ticket.length>27)?result_ticket.substring(0, 25):result_ticket) + "&nbsp;&nbsp;<span class='row-info' rel='0'>[+]</span><div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div>";
	                }
	                grilla += "<div class='row_grid'><div class='column_1'>1</div><div class='column_2'>" + result_ticket + "</div><div class='column_3'><div class='delete process-delete' rel='0'>x</div></div></div>";
	          grilla += "</div></div>";
	          $("#content-subscribe-grid-result").html(grilla);
	          
		          dataLayerlimpiar = false;
	              $(".clear").click();
		          dataLayerlimpiar = true; 
	              
	              var percent = parseFloat(content_object[0][4]);
	              var costo_total = parseFloat(content_object[0][6]);
	              var costo_bruto = parseFloat(content_object[0][7]);
	              var costo_desc = (percent/100)*costo_bruto;
	              $(".result1_subscribe").html("S/ " + peformat(costo_total));
	              $(".result2_subscribe").html("S/ " + peformat(costo_bruto));
	              $(".result3_subscribe").html("(S/ " + peformat(costo_desc)+")");
	              $(".label_resu3_subscribe").html("Descuento de "+percent+"%:");
	              clear_all();
	      }
	  }   
  }
  
  function finalizarCompraComboTinkero(){
	  var option = $("[name=option-card]:checked").val();
      var pin = $("[name=pin-number]").val();
      var message = "";
      var amount = 0.0;
      var newamount = 0.0;
      var msgres = [];
      if(option == 0) {
          message = "OK"
      } 
      if(message == "OK") {
          if(content_object.length != 0) {
              var content_grid_2 = "<div class='label-top label-top-min'></div><div class='label_1'>SUSCRIPCI&Oacute;N TINKA POR ADELANTADO</div><div class='label_info'></div><div id='ajax-loader'><img src='layer-view-image/game/ganadiario/ajax-loader.gif'></div><div id='content-grid-result'></div><div id='num_link'></div><div id='game-no-process-info'></div>";
              $(".left-panel").html(content_grid_2);
              $("#panel_keep-playing").show();
              $("#panel_game-history").show();
              $("#block-subscription").removeClass("disabled");
              $("#sub_panel").hide();
              $("#panel_finaliza_compra").hide();
              var result_ticket = "";
              var regular_price = parseFloat(content_object[0][7]);
              for (i in content_object) {
                  if (i != 0) {
                      result_ticket += "-"
                  }
                  for (j in content_object[i]) {
                      if (j != 0) {
                          result_ticket += "|"
                      }
                      var numeros = (content_object[i][j] + "").split(",");
                      for (var num = 0; num < numeros.length; num++) {
                          if (numeros[num].length < 2) {
                              if (numeros[num] != "0") {
                                  numeros[num] = "0" + numeros[num]
                              }
                          }
                          result_ticket += $.trim(numeros[num]) + " "
                      }
                  }
              }
              $("#ajax-loader").show();
              var contador = 0;
              datalayerFinalizaCompra2(thisBtnFinalizarCompraComboTinkero,'Finalizar Compra');
              datalayerCheckout(content_object[0],content_object[0][6]/content_object[0][9]);
              $.ajax({type: "POST", url: "jugadasSuscripcionTinka.html", data: "dato=" + result_ticket, dataType: "text", success: function (e) {
              	
              	
                  var fila = (e.toString()).split("#");
                  for (var n = 0; n < fila.length; n++) {
                      var items = (fila[n] + "").split("|");
                      var row_object = [];
                      for (var m = 0; m < items.length; m++) {
                          row_object.push($.trim(items[m]))
                      }
                      new_content_object.push(row_object)
                  }
                  $(".right-panel .result_purchase").css("height","70px");
                  $(".label_resu1_subscribe").html("TOTAL PAGADO");
                  if(new_content_object[0].length>13){
	                    $(".result1_subscribe").html("<b>S/ " + peformat(new_content_object[0][20]) + "</b>");
	                    $(".result2_subscribe").html("S/ " + peformat(new_content_object[0][22]));
	                    $(".label_resu3_subscribe").html("<b>Descuento de " + parseFloat(new_content_object[0][18]) + "%</b>");
	                    $(".result3_subscribe").html("<b>S/ " + peformat(new_content_object[0][21]) + "</b>");
	                    $(".label_resu4_subscribe").html("Saldo disponible:");
	                    $(".result4_subscribe").html("S/ " + peformat(new_content_object[0][19]));
	                    $(".label_info").html((new_content_object[0][17]).toLowerCase()+": "+(new_content_object[0][12])+" sorteos(Del sorteo N&ordm; "+(new_content_object[0][15])+" al N&ordm; "+(new_content_object[0][16])+")")
                  }
                  $("#clientSale-amount").text(peformat(new_content_object[0][10]));
                  $("#clientSale-amount-2").text(peformat(new_content_object[0][10]));
                  $("#ajax-loader").hide();
                  var no_process_message_count = 0;
                  var grilla = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>VER</div>" + "</div>";
                  +"<div id='total_filas'>";
                        var result_ticket = "<b>A</b>: ";
                              var numeros = ((new_content_object[0].length>13)?new_content_object[0][13]:new_content_object[0][0]).split(",");
                              for (var num in numeros) {
                                  if (numeros[num].length < 2) {
                                      numeros[num] = "0" + numeros[num];
                                  }
                                  result_ticket += numeros[num] + " ";
                              }
                      var style = "row_grid row_grid_mouseover";
                      var dato_proceso = (new_content_object[0][4] + "").split("&");
                      content_object[0][0] = ((new_content_object[0].length>13)?new_content_object[0][13]:new_content_object[0][0]);
                      
                      var process_resp = "";
                      if (dato_proceso[1] == "null") {
                          process_resp = "<div class='column3-no-process'><span class='no-process' rel='" + no_process_message_count + "#" + dato_proceso[0] + "'>No procesado&nbsp;&nbsp;[?]</span> </div>";
                          process_resp += "<div class='tooltip-no-process'></div><div class='tooltip-no-process-arrow-img'></div></div>";
                          no_process_message_count++;
                          
                          var relValue = dato_proceso[0]+ "";
                          var game_no_process_autocontrol = "";
                          // Verifica si mensaje de error contiene la palabra autoexclusion
                          if (relValue.includes("autoexclusion") || relValue.includes("autoexclusión") ) {
                              
                              game_no_process_autocontrol = "<div class='text-autocontrol' >Ir a la sección <a id='link-autocontrol'  href='mi-cuenta.html#yo-autocontrol'>Autocontrol</a></div>";
                          } 
                          
                          
                          var game_no_process_info = "<div class='title-text text-autocontrol'>" + "<div>Tienes jugadas que no se han podido procesar.</div> " + game_no_process_autocontrol  + "</div>" + "<div id='no-process-section'><a href='#' class='button button-block button-dark-green' id='btn-no-process' onclick='return false;'><b>VOLVER</b></a></div>";
                          $("#game-no-process-info").html(game_no_process_info);
                          $(".label-top").html("<div class='no-process-play'>JUGADAS NO PROCESADAS</div>");
                          $("#game-no-process-info").show()
                          $(".result1_subscribe").html("<b>S/ 0.00</b>");
                          try {
                          	if( dato_proceso[0].includes("CLIENTE NO EXISTE") == true ){
                          		taggingTinkaJugadaNoProcesada("No se ha encontrado el registro del cliente");
                          	}else if( dato_proceso[0].includes("CREDITO INSUFICIENTE") == true || dato_proceso[0].includes("Cuenta Lotocard ha expirado") == true ){
                          		taggingTinkaJugadaNoProcesada("No cuenta con saldo disponible para realizar este proceso");
                          	}else{
                          		taggingTinkaJugadaNoProcesada("Ocurrio un error intente nuevamente");
                          	}
							} catch (e) {
								console.error(e);
							}
                      } else {
                          process_resp = "<div class='column3-codigo'>" + dato_proceso[1] + "</div><div class='column3-search' onclick='openPreviewWindow(" + new_content_object[0][9] + ",\"" + new_content_object[0][8] + "\",\"" + dato_proceso[1] + "\")'></div>"
                          try {
                          	tagginTinkaCompraExitosa();				
                          	datalayerPurchase(content_object[0],
                          					content_object[0][6]/content_object[0][9],
                          					'¡Has Realizado tu Suscripción con Éxito!',
                          					content_object[0][6],
                          					'Tinka-'+dato_proceso[1],
                          					"Combo_"+content_object[0][5]);
              			} catch (e) {
              				console.error(e);
              			}
                          
                          new_content_object[0].push(content_object[0][8]);
                          new_content_object[0].push(content_object[0][9]);
                          try {
                          	tinkaTagginEEpurchase(new_content_object);				
                          	
              			} catch (e) {
              				console.error(e);
              			}
                          
                      }
                      grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + new_content_object[0][7] + "</div>" + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + 0 + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + process_resp + "</div>"
                  grilla += "</div></div>";
                  $("#content-grid-result").html(grilla)
                  var costo_total = 0;
                  for (var t in new_content_object) {
                      var procesos = (new_content_object[t][4] + "").split("&");
                      if (procesos[1] != "null") {
                          $(".label-top").html("&#161;HAS REALIZADO TU SUSCRIPCI&Oacute;N CON &Eacute;XITO!");
                          $(".play-help").hide();
                          costo_total += parseFloat(new_content_object[t][6]);
                          
                      }
                  }

                  
                  
                  
              }
              })
          } else {
              jAlert("No se tiene jugadas por procesar");
              taggingTinkaJugadaNoProcesada("No se tiene jugadas por procesar");
              datalayerErrores('Finalizar tu Compra 2','Paso 3','Finalizar Compra','No se tiene jugadas por procesar');
          }
          if (option == 1){
          	jAlert("Se ha realizado una recarga de saldo.\n\nMonto cargado: S/ " + amount + "\nTu saldo es: S/ " + newamount, null);
          }
      } else {
          if (option == 1){
          	jAlert("No se ha logrado realizar la recarga.\n" + message + "\n\nMonto cargado: S/ " + amount + "\nTu saldo es: S/ " + newamount, null);
          	datalayerErrores('Finalizar tu Compra 2','Paso 3','Finalizar Compra','No se ha logrado realizar la recarga.');
          }
      }
  }
  
  window.addEventListener("message", function(event) {
      if (event.data === "lottoTinkaSubscriptionComprarComboTinkero") {
    	  comprarComboTinkero(); 
      } else if (event.data === "lottoTinkaSubscriptionFinalizarCompraComboTinkero") {
    	  finalizarCompraComboTinkero(); 
      }
  });
  
  function viewNext(){
	  $('#password-client-header').val('');
      $('#password-client').val('');
      $(".logout").show();
      $(".unlogout").hide();
      $("#tab-item_4").show();
      $("#payments_section").show();
      $('.img_zona_segura').css({"margin-top":"0px"});
      $("#login_section").hide();
      $("#panel_finaliza_compra").show();
  }
};$($tinkaSubscription);
function show(first_letter_id, value_number) {
    value_number.sort(function (a, b) {
        return b - a;
    });
    value_number.reverse();
    $("#txt" + first_letter_id).val(value_number.join(', '));
}
function array_number(number_id, first_letter_id) {
  if(first_letter_id == "chk1") {
        value_number1.push(number_id);
        show(first_letter_id, value_number1);
    }
}
function delete_array_number(number_id, first_letter_id) {
  if(first_letter_id == "chk1") {
        var size = value_number1.length;
        for (ini = 0; ini <= size; ini++) {
            if (value_number1[ini] == number_id) {
                value_number1.splice(ini, 1);
                show(first_letter_id, value_number1);
            }
        }
    }
}
function clear_for_ini(title) {
    for (ini = 0; ini <= 50; ini++) {
      $("#"+title+"-"+ini).prop("checked", false);
      $("#lbl"+title+"-"+ini).removeClass("colorChecked");
      if(title == "chk1") {
        cantin1 = 0;
            value_number1.splice(0, 1);
            show(title, value_number1);
        }
    }
    count = util(title, 3);
}
function buscar_repetido(value, title) {
  if(title == "chk1") for(ini = 0; ini < 6; ini++) if(value_number1[ini] == value) return false
    return true;
}
function util(play, how_marca) {
  switch (play) {
    case "chk1":
            if(how_marca == 1) count1++;
            if(how_marca == 2) count1--;
            if(how_marca == 3) count1=0;
            if(how_marca == 4) count1=6;
            return count1;
            break;
    }
}
function combinatoria() {
	
  var sub_cantin1 = 0;
        var counter = 0;
        for(ini = 1; ini <= 50; ini++) {
          if($("#chk1-" + ini).is(":checked")) counter++;
        }
                contador1 = counter;
                if(counter >= 6) cantin1 = bin_newton(counter);
                else cantin1 = 0;
                if(contador1 <= 5 && contador1 > 0) sub_cantin1 = 1;
                else sub_cantin1 = cantin1;
    sub_total = sub_cantin1;
    if(sub_total <= 5005) total = cantin1;
    var subscription = new Array();
    var dis10 = new Array();
    var dis20 = new Array();
    var dis30 = new Array();
    var dis40 = new Array();
    var percent10 = 0, percent20 = 0, percent30 = 0, percent40 = 0;
    var priceundis10 = 0.0, priceundis20 = 0.0, priceundis30 = 0.0, priceundis40 = 0.0;
    var pricedis10 = 0.0, pricedis20 = 0.0, pricedis30 = 0.0, pricedis40 = 0.0;
    var draws10 = 0, draws20 = 0, draws30 = 0, draws40 = 0;
    var months10 = 0, months20 = 0, months30 = 0, months40 = 0;
    if($("input[name=discount]").length>0) {
      if(price_base != "") {
          dis10 = $("#inp_desktop_combo_8_sorteos_tinka").data("discount").split("_");
          dis20 = $("#inp_desktop_combo_24_sorteos_tinka").data("discount").split("_");
          dis30 = $("#inp_desktop_combo_48_sorteos_tinka").data("discount").split("_");
          dis40 = $("#inp_desktop_combo_96_sorteos_tinka").data("discount").split("_");
          percent10 = parseFloat(dis10[0]);
          percent20 = parseFloat(dis20[0]);
          percent30 = parseFloat(dis30[0]);
          percent40 = parseFloat(dis40[0]);
          months10 = parseFloat(dis10[1]);
          months20 = parseFloat(dis20[1]);
          months30 = parseFloat(dis30[1]);
          months40 = parseFloat(dis40[1]);
          draws10 = parseFloat(dis10[2]);
          draws20 = parseFloat(dis20[2]);
          draws30 = parseFloat(dis30[2]);
          draws40 = parseFloat(dis40[2]);
          priceundis10 = price_base*draws10*((total>0)?total:1);
          priceundis20 = price_base*draws20*((total>0)?total:1);
          priceundis30 = price_base*draws30*((total>0)?total:1);
          priceundis40 = price_base*draws40*((total>0)?total:1);
          pricedis10 = redondeo((1-percent10/100)*priceundis10,2);
          pricedis20 = redondeo((1-percent20/100)*priceundis20,2);
          pricedis30 = redondeo((1-percent30/100)*priceundis30,2);
          pricedis40 = redondeo((1-percent40/100)*priceundis40,2);
          $("#undiscounted10").text(peformat(priceundis10));
          $("#undiscounted20").text(peformat(priceundis20));
          $("#undiscounted30").text(peformat(priceundis30));
          $("#undiscounted40").text(peformat(priceundis40));
          $("#inp_desktop_combo_8_sorteos_tinka").text(peformat(pricedis10));
          $("#inp_desktop_combo_24_sorteos_tinka").text(peformat(pricedis20));
          $("#inp_desktop_combo_48_sorteos_tinka").text(peformat(pricedis30));
          
          $("#discounted10").text(peformat(pricedis10));
          $("#discounted20").text(peformat(pricedis20));
          $("#discounted30").text(peformat(pricedis30));
          $("#discounted40").text(peformat(pricedis40));          
        }
      $("input[name=discount]:checked").each(function(i) {
      subscription = $(this).attr("id");
    });
    }
    if(($("#btn_desktop_combo_tinkero_misma_jugada").hasClass("btn-active") && total >= 1 && subscription.length>0)||($("#btn_desktop_combo_tinkero_azar_simple").hasClass("btn-active") && subscription.length>0)) {
        if(total==0 && subscription.length>0 && $("#btn_desktop_combo_tinkero_azar_simple").hasClass("btn-active")){
        	total = 1;
        }
      consecutive = (subscription=="inp_desktop_combo_8_sorteos_tinka")?draws10:(subscription=="inp_desktop_combo_24_sorteos_tinka")?draws20:(subscription=="inp_desktop_combo_48_sorteos_tinka")?draws30:(subscription=="inp_desktop_combo_96_sorteos_tinka")?draws40:1;
      sorteos = (subscription=="inp_desktop_combo_8_sorteos_tinka")?total*draws10:(subscription=="inp_desktop_combo_24_sorteos_tinka")?total*draws20:(subscription=="inp_desktop_combo_48_sorteos_tinka")?total*draws30:(subscription=="inp_desktop_combo_96_sorteos_tinka")?total*draws40:1;
      costoTotalBetMensaje = (subscription=="inp_desktop_combo_8_sorteos_tinka")?priceundis10:(subscription=="inp_desktop_combo_24_sorteos_tinka")?priceundis20:(subscription=="inp_desktop_combo_48_sorteos_tinka")?priceundis30:(subscription=="inp_desktop_combo_96_sorteos_tinka")?priceundis40:0;
      costoTotalBet = (subscription=="inp_desktop_combo_8_sorteos_tinka")?pricedis10:(subscription=="inp_desktop_combo_24_sorteos_tinka")?pricedis20:(subscription=="inp_desktop_combo_48_sorteos_tinka")?pricedis30:(subscription=="inp_desktop_combo_96_sorteos_tinka")?pricedis40:0;
      $("#price-info").text((subscription=="inp_desktop_combo_8_sorteos_tinka")?months10:(subscription=="inp_desktop_combo_24_sorteos_tinka")?months20:(subscription=="inp_desktop_combo_48_sorteos_tinka")?months30:(subscription=="inp_desktop_combo_96_sorteos_tinka")?months40:0);
      $("#total-bets").text(peformatint(sorteos));
      $("#price-discount").text((subscription=="inp_desktop_combo_8_sorteos_tinka")?percent10:(subscription=="inp_desktop_combo_24_sorteos_tinka")?percent20:(subscription=="inp_desktop_combo_48_sorteos_tinka")?percent30:(subscription=="inp_desktop_combo_96_sorteos_tinka")?percent40:0);
        $("#total-pay").text(peformat(costoTotalBet));
    } else {
        total = 0;
        costoTotalBet=0;
        $("#comb").text(0);
        $("#total_apagar").text(0);
        $("#price-info").text(0);
        $("#total-bets").text(0);
        $("#price-discount").text(0);
        $("#total-pay").text(0.0);
    }
}
function bin_newton(cantidad) {
    var deduct_1 = 1;
    var deduct_2 = 1;
    var count_2 = cantidad - 6;
    variable = factorial(cantidad) / (720 * (factorial(count_2)));
    return variable;
}
function factorial(cantidad) {
    if (cantidad < 0)return 0; else if (cantidad > 1)return cantidad * factorial(cantidad - 1);
    return 1;
}
function fecha_actual() {
    var f = new Date();
    var mes = "";
    var dia = "";
    /*var temp_mes = f.getMonth() + "";*/
    var temp_mes = (f.getMonth() + 1) + "";
    var temp_dia = f.getDate() + "";
    if(temp_mes.length == 1) mes = "0" + (f.getMonth() + 1) + "";
    else mes = (f.getMonth() + 1) + "";
    if(temp_dia.length == 1) dia = "0" + f.getDate() + "";
    else dia = f.getDate() + "";
    return dia + "/" + mes + "/" + f.getFullYear();
}
function clear_all() {
  $("input[type=checkbox]").prop("checked", false);
  $("input[name=discount]").prop("checked", false);
  $(".btn-discount10").removeClass("discount10-active");
  $(".btn-discount20").removeClass("discount20-active");
  $(".btn-discount30").removeClass("discount30-active");
  $(".btn-discount40").removeClass("discount40-active");
  $("#btn_desktop_combo_tinkero_misma_jugada").removeClass("btn-active");
  $("#btn_desktop_combo_tinkero_azar_simple").removeClass("btn-active");
  $("#panel-disable1").removeClass("disabled");
  $("#panel-disable2").removeClass("disabled");
  $(".check_").removeClass("colorChecked");
  count = 0;
  value_number1 = [];
    show("chk1", value_number1);
    util("chk1", 3);
  value_numberJ1 = [];
    show("jchk1", value_numberJ1);
    util("jchk1", 3);
    value_numberJ2 = [];
    show("jchk2", value_numberJ2);
    util("jchk2", 3);
    value_numberJ3 = [];
    show("jchk3", value_numberJ3);
    util("jchk3", 3);
    value_numberJ4 = [];
    show("jchk4", value_numberJ4);
    util("jchk4", 3);
    combinatoria();
}
function redondeo(numero, decimales) {
  return Math.round(parseFloat(numero)*Math.pow(10,decimales))/Math.pow(10,decimales);
}
function peformat(numero) {
  return (numero!=null && numero!="")?parseFloat(numero).toFixed(2).replace(/\B(?=(\d{3})+\b)/g, ","):"0.00";
}
function peformatint(numero) {
  return (numero!=null && numero!="")?parseInt(numero).toFixed(0).replace(/\B(?=(\d{3})+\b)/g, ","):"0";
}

function tagginEligeJugadaComboTinka(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageUrl': '/juega-tinka/combo/paso1/',
	    'pageTitle': 'Elige tu jugada - Combo - Tinka'
	});
	
	var tag="Elige tu jugada - Combo - Tinka";
	console.log("Taggin event: "+tag);

}

function tagginFinalizar(){
	
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	    'event': 'virtualPageView',
	    'pageUrl': '/juega-tinka/combo/paso2/',
	    'pageTitle': 'Finaliza tu compra - Combo - Tinka'

	});
	
	var tag="Finaliza tu compra - Combo - Tinka";
	console.log("Taggin event: "+tag);
}

function tagginTinkaEEcheckout(){
	var nCombos=content_object[0][5]; 	
	if(nCombos!=undefined && nCombos!=null && nCombos!=''){
		var price=content_object[0][6].toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEcheckout',
		  'ecommerce': {
		     'checkout': {
		        'actionField': {'step': 1},
		        'products': [{
		        	'name': 'Tinka Combo '+ nCombos +' jugadas',
			        'id': 'tinkaC'+nCombos,
			        'price': price,
			        'brand': 'Juegos',
			        'quantity': '1',
			        'category': 'Tinka'
		         }]
		      }
		   }
		});
		
		var tag="EEcheckout Tinka";
		console.log("Taggin event: "+tag+", Combo: "+nCombos+", precio: "+price);
	}
}

function tagginTinkaRemoveFromCart(datos){
	var nCombos=datos[5];
	if(nCombos!=undefined && nCombos!=null && nCombos!=''){
		var price=datos[6].toFixed(2);
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		  'event': 'EEremoveFromCart',
		  'ecommerce': {
		    'remove': {                             
		      'products': [{                          
		          'name': 'Tinka Combo '+ nCombos +' jugadas',
		          'id': 'tinkaC'+nCombos,
		          'price': price,  //Indicar el precio de la jugada que se está eliminando.
		          'brand': 'Juegos',
		          'quantity': '1',
		          'category': 'Tinka'
		       }]
		    }
		  }
		});
		
		var tag="Tinka combo EEremoveFromCart";
		console.log("Taggin event: "+tag+", Combo: "+nCombos+", precio: "+price);
	}
}

function tagginTinkaCompraExitosa(){
	window.dataLayer = window.dataLayer || [ ];
	dataLayer.push({
	'event': 'compraExitosa',
	 'pageUrl': '/juega-tinka/combo/confirmacion/',
	 'pageTitle': 'Compra exitosa - Combo - Tinka' 
	});
	
	var tag="Tinka combo compraExitosa";
	console.log("Taggin event: "+tag);

}

function tinkaTagginEEpurchase(content_object){
	var idTransaction=content_object[0][4].split("&")[1];
	var nCombos=content_object[0][5]; 	
	if(nCombos!=undefined && nCombos!=null && nCombos!=''){
		var price=parseFloat(content_object[0][6]).toFixed(2);
		var opcionJugada=content_object[0][24];
		if(opcionJugada==1){
			opcionJugada="Elige tu jugada";
	    }else{
	    	opcionJugada="Jugada al azar";
	    }
		var nBolillas=""+content_object[0][13].split(" ").length;
		var nSorteos=content_object[0][25];
		
		if(nCombos=="08"){
			nCombos="8";
		}
		
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		'event': 'EEpurchase',
		 'ecommerce': {
		    'purchase': {
		      'actionField': {
		        'id': 'TK-'+idTransaction,               // Código de la transacción
		         'revenue': price,   // Monto total pagado
		      },
		      'products': [{ 
		        'name': 'Tinka Combo '+ nCombos +' jugadas',   
		        'id': 'tinkaC'+nCombos,
		        'price': price,
		        'brand': 'Juegos',
		        'quantity': '1',
		        'category': 'Tinka',
		        'dimension1': opcionJugada, // aquí indicar opción de jugada
		        'dimension2': nSorteos,               // aquí indicar el número de sorteos
		        'dimension4': nBolillas               // aquí indicar el número de bolillas
		       }]
		    }
		  }
		});
		
		var tag="Tinka combo EEpurchase";
		console.log("Taggin event: "+tag+", combo: "+nCombos+", precio: "+price+", opción de jugada: "+opcionJugada);
	}
}

function taggingTinkaJugadaNoProcesada(mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': 'Error :: Tinka',  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingTinkaJugadaNoProcesada: mensaje:"+mensaje);
	}catch(e){
		console.error(e);
	}
}