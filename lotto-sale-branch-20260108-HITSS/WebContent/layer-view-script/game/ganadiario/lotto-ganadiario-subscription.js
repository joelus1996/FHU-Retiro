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
  //combo_fecha = $(".selectBox").html();
    status = $("#status").val();
    algorithm = $("#algorithm").val();
    bets = $("#bets").val();
    pay = $("#pay").val();
    cost = $("#cost").val();
    draw = $("#draw").val();
    price_type = $("#price_type").val();
    promo = $("#promo").val();
    //sorteos = $("#mySelectBox").val();
    v_data_value_bet = $("#simpleBetPrice_repeated").val();
    idsession = $("#clientId").val();
    price_base = parseFloat($("#base_price").val());
 
    $('#game-code-header').val(164); 
    //$('#frmLoginClientIndex').off('submit').attr('id', 'frmLoginClientTinka').attr('action', 'login_tinka.html');
   
    if(idsession != '' && $("#agreement").val() == ''){
      $("#login_section").show();
    $('.img_zona_segura').css({"margin-top":"93px"});
      exe.opentyc(null);
    } else if (idsession == '') {
        $("#login_section").show();
    $('.img_zona_segura').css({"margin-top":"93px"});
    } else {
        $("#panel_finaliza_compra").show();
        $("#tab-item-saldo").show();
        $("#payments_section").show();
    $('.img_zona_segura').css({"margin-top":"0px"});
    }
    $(".label_2").html(fecha_actual());
    //discounted(1);
    //
    $("#plays-1").addClass("active");
    //
}};
var $ganadiarioSubscription = function () {
  run.setup();
    $("input[type=checkbox]").change(function () {
        var id_value = $(this).attr("id");
        var first_letter_id = $(this).attr("name");
        var number_id = $(this).val();
        if($(this).is(":checked")) {
            if(count <= 15) {
                count = util(first_letter_id, 1);
                if(sub_total <= 3003) {
                   $(this).prop('checked', true);
                    array_number(number_id, first_letter_id);
                    $("#lbl"+ id_value).addClass("colorChecked");
                    combinatoria();
                }
                if(count > 15 || sub_total > 3003) {
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
            var title = $(this).attr("id").substr(5);//(0,2);
            //alert("title="+title);
            clear_for_ini(title);
            combinatoria();
            if(dataLayerlimpiar){
            	datalayerJugada(this,'Elige tu Combo Gana Diario');
            }
        }
    });
    $(".azar").click(function () {
        if (status == "ACT") {
            if (sub_total < 1716) {
                var ini;
                var title = $(this).attr("id").substr(4);//(0,2);
                if(title == "chk1") count = count1;
                
                if(count >= 5) {
                    count = 0;
                    clear_for_ini(title);
                }
                while (count < 5) {
                    var number_azar = Math.round(1 + (Math.random() * (35 - 1)));
                    if(buscar_repetido(number_azar, title)) {
                      $("#"+title+"-"+number_azar).prop("checked", true);//$("#" + title + "check_" + number_azar).prop('checked', true);
                      $("#lbl"+title+"-"+number_azar).addClass("colorChecked");//$("#L" + title + "check_" + number_azar).addClass("colorChecked");
                        array_number(number_azar, title);
                        count = util(title, 1);
                    }
                }
                combinatoria();
                try {
                	datalayerJugada(this,'Elige tu Combo Gana Diario');
                	 tagginAlAzar("Gana Diario");
    			} catch (e) {
    				console.error(e);
    			}

            }
        }
    });
  
      $('.more').click(function () {
          if (status == "ACT") {
              if (sub_total < 1716) {
                  var more = [];
                  var title = $(this).attr("id").substr(4);//(0,2);
                  var more2;
                  more2 = $("#more_repeated").val();
                  more = more2.split(" ");
                  var size = more.length;
                  clear_for_ini(title);
                  count = util(title, 4);
                  for (i = 0; i < size; i++) {
                    $("#"+title+"-"+more[i]).prop("checked", true);//$("#" + title + "check_" + more[i]).prop('checked', true);
                    $("#lbl"+title+"-"+more[i]).addClass("colorChecked");//$("#L" + title + "check_" + more[i]).addClass("colorChecked");
                      array_number(more[i], title);
                  }
                  combinatoria();
              }
          }
      });
      $('.less').click(function () {
          if (status == "ACT") {
              if (sub_total < 1716) {
                  var more = [];
                  var title = $(this).attr("id").substr(4);//(0,2);
                  var more2;
                  more2 = $("#less_repeated").val();
                  more = more2.split(" ");
                  var size = more.length;
                  clear_for_ini(title);
                  count = util(title, 4);
                  for (i = 0; i < size; i++) {
                    $("#"+title+"-"+more[i]).prop("checked", true);//$("#" + title + "check_" + more[i]).prop('checked', true);
                    $("#lbl"+title+"-"+more[i]).addClass("colorChecked");//$("#L" + title + "check_" + more[i]).addClass("colorChecked");
                      array_number(more[i], title);
                  }
                  combinatoria();
              }
          }
      });
    
      $(".left-panel").on("click",".process-delete",function(){
    	  tagginGanaDiarioRemoveFromCart(content_object[0]);
    	  
    	  let carrito = [];
    	  carrito = content_object[0];
    	  carrito[0] = carrito[0] == "00" ? "" : carrito[0];
    	  
    	  datalayerRemoveFromCart(carrito,carrito[6]/carrito[9]);
    	  window.location.href = "juega-ganadiario.html";
    	/**********  
        var pos = parseInt($(this).attr("rel"));
          content_object.splice(pos, 1);
          //grilla_boletos(content_object);
      $("#content-subscribe-grid-result").html("");
          //grilla_paginada(content_object);
          var costo_total = 0;
          for(var i in content_object) {
              costo_total += content_object[i][6]
          }
          $(".result1_subscribe").html("S/ 0.00");
          //if(content_object.length==0){
          //$("#more_plays").click();
          //
        //   $(".transition-subscription-one").removeClass("disabled");
        // $(".transition-subscription-two").addClass("disabled");
        $('.step-play').removeClass('step-active');
        $('.step-status-1').addClass('step-active');
        $("#start_subscribe_play").removeClass("disabled");
        $(".finalize-subscribe-purchase").addClass("disabled");
        $('.subscription-disabled-sec1').addClass('subscription-disabled');
        $('.subscription-disabled-sec2').addClass('subscription-disabled');
        $('.option-subscription-gd').removeClass('option-subscription-gd-actived').removeClass('btn-active');
        //$("#panel-disable1").removeClass("disabled");
        // $("#panel-disable2").addClass("disabled");
        //$("#random-play").removeClass("btn-active");
        //$("#same-play").removeClass("btn-active");
        $("#btn_desktop_combo_ganadiario_azar_simple").removeClass("btn-active");        
        $("#btn_desktop_combo_ganadiario_misma_jugada").removeClass("btn-active");

        //
          sorteos = 1;
          consecutive = 1;
          costoTotalBet = 0;
          costoTotalBetMensaje = 0;
          //}
          *********/
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
          //var contador = 0;
          /*for(var i in new_content_object) {
              var procesos = (new_content_object[i][4] + "").split("&");
              if (procesos[1] == "null") {
                  array_no_procesados.push(new_content_object[i]);
                  //contador++
              }
          }*/
        /*for (i in content_object) {
              for (j in content_object[i]) {
                alert("["+i+"]["+j+"]="+content_object[i][j]);
              }
        }*/
          $("#panel_keep-playing").hide();
          $("#panel_game-history").hide();
          $("#block-subscription").addClass("disabled");
          //$(".label-top").show();
          $("#sub_panel").show();
          $("#panel_finaliza_compra").show();
          
          var temp_jugada_2 = "<span class='label_1'>SUSCRIPCI&Oacute;N GANADIARIO POR ADELANTADO</span><div id='content-subscribe-grid-result'></div><div id='num_subscribe_link'></div>";
          $(".left-panel").html(temp_jugada_2);
          if (status == "ACT") {
              $('.transition-one').hide();
              $('.transition-two').show();
              $('#start_play').hide();
              $('.finalize-purchase').show();
              //var cant_sorteo = $("#mySelectBox").val();
              var precio = costoTotalBet;
              //content_object = [];
              //content_object = array_no_procesados;
              //array_no_procesados = [];
              //new_content_object = [];
              //grilla_boletos(content_object);
              var grilla = "<div id='grilla_boleto'><div class='boleto_cabecera'><div class='head_title_1'>N.</div><div class='head_title_2'>JUGADA</div><div class='head_title_3'>ANULAR</div></div>";
              var result_ticket = "";
              if(!content_object[0][0]) {
                result_ticket = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>AL AZAR</b>";
              } else {
                result_ticket = "<b>A</b>: ";
                //alert(value_number1);
                var numeros = (content_object[0][0]+"").split(",")//(content_object[x][0] + "").split(",");
                for(var num in numeros) {
                  if(numeros[num].length < 2) numeros[num] = "0" + numeros[num];
                  result_ticket += numeros[num] + " "
                }
                result_ticket = ((result_ticket.length>27)?result_ticket.substring(0, 25):result_ticket) + "&nbsp;&nbsp;<span class='row-info' rel='0'>[+]</span><div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div>";
              }
              grilla += "<div class='row_grid'><div class='column_1'>1</div><div class='column_2'>" + result_ticket + "</div><div class='column_3'><div class='delete process-delete' rel='0'>x</div></div></div></div></div>";
              $("#content-subscribe-grid-result").html(grilla);
              //grilla_paginada(content_object);
              dataLayerlimpiar = false;
              $(".clear").click();
              dataLayerlimpiar = true;
              /*var costo_total = 0;
              for (var i in content_object) {
                  costo_total += parseFloat(content_object[i][6])
              }
              $(".result1").html("S/." + floatFormat(costo_total))*/
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
      $('#frmLoginClientPuchase').on('submit', function (event) {
        event.preventDefault();
          var user = $('#user-client').val();
          var pass = $('#password-client').val();
          var valida_session = "", _id = $(this).attr("id");
          if (user == '' || pass == '') {
              jAlert('Complete los datos de usuario')
          } else {
              $.ajax({type: "POST", url: "login_tinka.html", dataType: "text", data: $("#frmLoginClient").serialize(), success: function (e) {
                //$('#password-client').val('');
                  var resp = $.trim(e);
                  var arrresp = resp.split("|");
                  valida_session = arrresp[0];
                  if (valida_session == 'OK' || valida_session === 'TC' || valida_session === 'MV' || valida_session === 'AC' || valida_session === 'RD') {
                      var username = arrresp[1];
                      var useramount = arrresp[2];
                      var userid = arrresp[3];
                      var monto1 = floatFormat(arrresp[4]);
                      var monto2 = floatFormat(arrresp[5]);
                      var nombrejs = arrresp[7];
                      var apPaternojs = arrresp[8];
                      var apMaternojs = arrresp[9];
                      var mailjs = arrresp[10];
                      var mobilePhonejs = arrresp[11];
                      var countryjs = arrresp[12];
                      var regionjs = arrresp[13];
                      var addressjs = arrresp[14];
                      var typeIdjs = arrresp[15];
                      var numberIdjs = arrresp[16];
                      var controlAmountjs = arrresp[17];
                      var emailjs = arrresp[18];
                      var sessionjs = arrresp[20];
                      
                      $("#field-balance-amount").text(monto1);
                      if (monto2 == "0.00") {
                          $(".saldo_promocional").html('')
                      } else {
                          $(".saldo_promocional").html("&oacute; de mi saldo promocional S/ " + monto2)
                      }
                      $("#clientId").val(userid);
                                         
                      $("#clientSale-name").text(username);
                      $("#clientSale-amount").text(floatFormat(useramount));
                      $("#clientSale-amount-2").text(floatFormat(useramount));
                      $('#user-ico').addClass(arrresp[6]);
                      
                      $("#nombre").val(nombrejs);
                      $("#apPaterno").val(apPaternojs);
                      $("#apMaterno").val(apMaternojs);
                      $("#mail").val(mailjs);
                      $("#phone").val(mobilePhonejs);
                      $("#country").val(countryjs);
                      $("#city").val(regionjs);
                      $("#addres").val(addressjs);
                      $("#typeId").val(typeIdjs);
                      $("#numberId").val(numberIdjs);
                      $("#amount").val(controlAmountjs);
                      $("#email").val(arrresp[18]);
                      $("#sesionId").val(sessionjs);
                      if(valida_session === 'MV') {
                      	exe.openeml(_id,arrresp[1]);
                      } else if(valida_session === 'AC') {
                      	exe.openphn(_id,arrresp[1]);
                      } else if(valida_session === 'TC') exe.opentyc(_id);
                      else if(valida_session === 'RD') { exe.openrdb(_id,arrresp[1]); }
                      else viewNext();
                   } else if(valida_session === 'CC'){
                      jAlert(arrresp[1], null);
                      $('#user-client').focus();
                      setCaptcha(true);
                  } else {
                      jAlert(valida_session);
                      $('#user-client').focus();
                  }
              }})
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
      
    
    //$(document).on("click", "#btnAdvance", function(){
    $(document).on("click", "#btn_desktop_combos_ganadiario", function(){
      clear_all();
      $(".panel-subscription").addClass("disabled");
      $(".panel-subscription-book").removeClass("disabled");
      tagginEligeJugadaComboGanaDiario();
      datalayerBtnsTipoJuego(this,'¡Combos Gana Diario! No te pierdas ni un sorteo');
      //$(".panel-book").addClass("disabled");
    });
    $(document).on("click", "#btn_desktop_juega_ganadiario", function(){
	    datalayerBtnsTipoJuego(this,'¡Combos Gana Diario! No te pierdas ni un sorteo');
	    window.location.href = 'juega-ganadiario.html?state=1';
	 });
    //$(document).on("click", "#same-play", function(e){
    $(document).on("click", "#btn_desktop_combo_ganadiario_misma_jugada", function(e){
      e.preventDefault();
      clear_all();
      $('.subscription-disabled-sec1').removeClass('subscription-disabled');
      $('.subscription-disabled-sec2').removeClass('subscription-disabled');
      $('.option-subscription-gd').removeClass('option-subscription-gd-actived')
      $(this).addClass('option-subscription-gd-actived');
      // $("#panel-disable1").addClass("disabled");
      // $("#panel-disable2").addClass("disabled");
      //$("#same-play").addClass("btn-active");
      //$("#random-play").removeClass("btn-active");
      $("#btn_desktop_combo_ganadiario_misma_jugada").addClass("btn-active");
      $("#btn_desktop_combo_ganadiario_azar_simple").removeClass("btn-active");
      datalayerJugada(this,'Elige tu Combo Gana Diario');
    });
    //$(document).on("click", "#random-play", function(e){
    $(document).on("click", "#btn_desktop_combo_ganadiario_azar_simple", function(e){
      e.preventDefault();
      clear_all();
      $('.subscription-disabled-sec1').addClass('subscription-disabled');
      $('.subscription-disabled-sec2').removeClass('subscription-disabled');
      $('.option-subscription-gd').removeClass('option-subscription-gd-actived')
      $(this).addClass('option-subscription-gd-actived');
      //$("#panel-disable1").removeClass("disabled");
      // $("#panel-disable2").addClass("disabled");
      //$("#random-play").addClass("btn-active");
      //$("#same-play").removeClass("btn-active");
      $("#btn_desktop_combo_ganadiario_azar_simple").addClass("btn-active");
      $("#btn_desktop_combo_ganadiario_misma_jugada").removeClass("btn-active");
      datalayerJugada("Jugada simple al 'Azar' para cada sorteo *",'Elige tu Combo Gana Diario');
    });
    $(document).on("click", ".btn-discount10", function(){
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount30").removeClass("discount30-active");
      $(".btn-discount40").removeClass("discount40-active");
      $(".btn-discount10").addClass("discount10-active");
      //$("#discount10").prop("checked",true);
      $("#inp_desktop_combo_30_sorteos_ganadiario").prop("checked",true);
      combinatoria();
    });
    $(document).on("click", ".btn-discount20", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount30").removeClass("discount30-active");
      $(".btn-discount40").removeClass("discount40-active");
      $(".btn-discount20").addClass("discount20-active");
      //$("#discount20").prop("checked",true);
      $("#inp_desktop_combo_90_sorteos_ganadiario").prop("checked",true);
      combinatoria();
    });
    $(document).on("click", ".btn-discount30", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount40").removeClass("discount40-active");      
      $(".btn-discount30").addClass("discount30-active");
      //$("#discount30").prop("checked",true);
      $("#inp_desktop_combo_180_sorteos_ganadiario").prop("checked",true);
      combinatoria();
    });
    $(document).on("click", ".btn-discount40", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount30").removeClass("discount30-active");      
      $(".btn-discount40").addClass("discount40-active");
      //$("#discount40").prop("checked",true);
      $("#inp_desktop_combo_365_sorteos_ganadiario").prop("checked",true);
      combinatoria();
    });
    $(document).on("change", ".number-textarea-button2 input[name=discount]", function(){
      $(".btn-discount10").removeClass("discount10-active");
      $(".btn-discount20").removeClass("discount20-active");
      $(".btn-discount30").removeClass("discount30-active");
      $(".btn-discount40").removeClass("discount40-active");      
      //if($(this).is(":checked")) 
      $(".btn-"+$(this).attr("id")).addClass($(this).attr("id")+"-active");
      //else $(".btn-"+$(this).attr("id")).removeClass($(this).attr("id")+"-active");
      combinatoria();
      
    });
    
  var thisBtnComprarComboGanadiario = null;
  //$(document).on("click","#buy-subscription", function () {
  $(document).on("click","#btn_desktop_comprar_combo_ganadiario", function () {
	    thisBtnComprarComboGanadiario = this;
		// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
		// es una function que se realizará en caso no tenga docs pendientes de confirmacion
		mainValidatePendingsDocsForAproval("lottoGanadiarioSuscriptionComprarComboGanadiario");
  });
  
  var thisBtnFinalizarCompraComboGanadiario = null;
  //$(document).on("click", "#btn_finaliza_compra", function () {
  $(document).on("click", "#btn_desktop_finalizar_compra_combo_ganadiario", function () {
	  	// Se valida si el usiuario tiene documentos pendientes de confirmación, el parámetro que recibe
		// es una function que se realizará en caso no tenga docs pendientes de confirmacion
		mainValidatePendingsDocsForAproval("lottoGanadiarioSuscriptionFinalizarCompraComboGanadiario");
  });
  
  function comprarComboGanadiario(){
	//alert("value_number1="+value_number1+" length="+value_number1.length+" total="+total+" costoTotalBet="+costoTotalBet);
	    if(status=="ACT"){
	      var percent = 0;
	      var label="";
	      $("input[name=discount]:checked").each(function(i) {
	        percent = parseFloat($(this).data("discount").split("_")[0]);
	      });
	      //if(!$("#same-play").hasClass("btn-active") && !$("#random-play").hasClass("btn-active")) {
	      if(!$("#btn_desktop_combo_ganadiario_misma_jugada").hasClass("btn-active") && !$("#btn_desktop_combo_ganadiario_azar_simple").hasClass("btn-active")) {
	    	  label="No ha elegido ninguna jugada.";
	    	  try {
	                	tagginPopupError("Gana Diario",label);
	                	datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',label);
	    			} catch (e) {
	    				console.error(e);
	    			}
	    	  
	        jAlert(label, null);
	      //} else if($("#same-play").hasClass("btn-active") && (total<1 || percent==0)) {
	      } else if($("#btn_desktop_combo_ganadiario_misma_jugada").hasClass("btn-active") && (total<1 || percent==0)) {	        
	    	  label="Elige correctamente tu apuesta.";
	    	  try {
	    		  var errorTagging="";
	    		  if(value_number1.length<=0){
	    			  errorTagging="Elegir bolillas";
	    		  }else{
	    			  errorTagging="Elegir combo";
	    		  }
	    		  tagginPopupError("Gana Diario",errorTagging);
	    		  datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar',label);
				} catch (e) {
					console.error(e);
				}
	    	  
	        jAlert(label, null);
	      //} else if($("#random-play").hasClass("btn-active") && percent==0) {
	      } else if($("#btn_desktop_combo_ganadiario_azar_simple").hasClass("btn-active") && percent==0) {
	    	  label="Elige un per&iacute;odo de suscripci&oacute;n.";
	    	  try {
	    		  var errorTagging="Elegir combo";
	    		  tagginPopupError("Gana Diario",errorTagging);
	    		  datalayerErrores('Finalizar tu Compra 1','Paso 2','Comprar','Elige un período de suscripción');
				} catch (e) {
					console.error(e);
				}
	    	  
	        jAlert(label, null);
	      } else {
	    	  tagginEEaddToCart("Gana Diario",consecutive,costoTotalBet);
	        //if(total <= 1716 && total >= 1) {
	          //
//	    	  setCaptchaJuego();
	    	  $("#index-btnlogin").prop("disabled",true);
	          $('.step-play').removeClass('step-active');
	          $('.step-status-2').addClass('step-active');
	        // $(".transition-subscription-one").addClass("disabled");
	        // $(".transition-subscription-two").removeClass("disabled");
	        $("#start_subscribe_play").addClass("disabled");
	        $(".finalize-subscribe-purchase").removeClass("disabled");
	            var object_boleto = [];
	          //if($("#same-play").hasClass("btn-active")) object_boleto.push(value_number1);
	          //else if($("#random-play").hasClass("btn-active")) object_boleto.push("AL AZAR");
	        object_boleto.push(value_number1);
	          object_boleto.push(null);
	          object_boleto.push(null);
	          object_boleto.push(null);
	          object_boleto.push(percent);
	          object_boleto.push(consecutive);//(sorteos);
	          object_boleto.push(costoTotalBet);
	          object_boleto.push(costoTotalBetMensaje);
	          if($("#btn_desktop_combo_ganadiario_misma_jugada").hasClass("btn-active")){
	        	  object_boleto.push(1);
	          }
	          if($("#btn_desktop_combo_ganadiario_azar_simple").hasClass("btn-active")){
	        	  object_boleto.push(2);
	          } 
	          object_boleto.push($("#total-bets").text());
	          content_object.push(object_boleto);
	          tagginFinalizar();
	          tagginGanaDiarioEEcheckout();
	          datalayerAddToCart(object_boleto,object_boleto[6]/object_boleto[9]);
	          datalayerFinalizaCompra1($('#btn_desktop_comprar_combo_ganadiario'),'Comprar');
	          for (var v in content_object) {
	                  for (var w = 0; w <= 3; w++) {
	            //alert(content_object[v][0]);
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
	              /*for(var i in content_object) {
	                  content_object[i][4] = "null";
	              }*/
	              //grilla_boletos(content_object);
	          //var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
	          var grilla = "<div id='grilla_boleto'><div class='boleto_cabecera'><div class='head_title_1'>N.</div><div class='head_title_2'>JUGADA</div><div class='head_title_3'>ANULAR</div></div>";
	          //+"<div id='total_filas'>";
	          //for(var x in content_object) {
	              //for (var i = 0; i <= 3; i++) {
	                  //if(content_object[x][0] != "") {
	                      //if(content_object[x][0] != "00") {
	                var result_ticket = "";
	                //if($("#random-play").hasClass("btn-active")) {
	                if($("#btn_desktop_combo_ganadiario_azar_simple").hasClass("btn-active")) {
	                  result_ticket = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>AL AZAR</b>";
	                } else {
	                          result_ticket = "<b>A</b>: ";
	                          //alert(value_number1);
	                          var numeros = (value_number1+"").split(",")//(content_object[x][0] + "").split(",");
	                          for(var num in numeros) {
	                              if(numeros[num].length < 2) numeros[num] = "0" + numeros[num];
	                              result_ticket += numeros[num] + " "
	                          }
	                          result_ticket = ((result_ticket.length>27)?result_ticket.substring(0, 25):result_ticket) + "&nbsp;&nbsp;<span class='row-info' rel='0'>[+]</span><div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div>";
	                }
	                  grilla += "<div class='row_grid'><div class='column_1'>1</div><div class='column_2'>" + result_ticket + "</div><div class='column_3'><div class='delete process-delete' rel='0'>x</div></div></div>"
	          //}
	          grilla += "</div></div>";
	          $("#content-subscribe-grid-result").html(grilla);
	              //grilla_paginada(content_object);
	   
		          dataLayerlimpiar = false;
	              $(".clear").click();
		          dataLayerlimpiar = true;
	              //for (var i in content_object) {
	              var percent = parseFloat(content_object[0][4]);
	              var costo_total = parseFloat(content_object[0][6]);
	              var costo_bruto = parseFloat(content_object[0][7]);
	              var costo_desc = (percent/100)*costo_bruto;
	              //}
	              $(".result1_subscribe").html("S/ " + peformat(costo_total));
	              //$(".label_resu2_subscribe").html($("#price-message").text());
	              $(".result2_subscribe").html("S/ " + peformat(costo_bruto));
	              $(".result3_subscribe").html("(S/ " + peformat(costo_desc)+")");
	              $(".label_resu3_subscribe").html("Descuento de "+percent+"%:");
	              //$("#mySelectBox").val("1");
	              clear_all();
	              /*}
	            if(total > 1716) {
	                jAlert("El total de apuestas no debe ser mayor a 3003.");
	            }*/
	      }
      }
  }
  
  function finalizarCompraComboGanadiario(){
	  var option = $("[name=option-card]:checked").val();
      var pin = $("[name=pin-number]").val();
      var message = "";
      var amount = 0.0;
      var newamount = 0.0;
      var msgres = [];
      if(option == 0) {
          message = "OK"
      } 
      //message = message.replace(/_/g, ' ');
      //$("#clientSale-amount").text(floatFormat(newamount));
      //$("#field-balanceAmount").text(floatFormat(newamount));
      if(message == "OK") {
          /*for(var i in content_object) {
              content_object[i][4] = "null";
          }*/
          if(content_object.length != 0) {
              var content_grid_2 = "<div class='label-top label-top-min'></div><div class='label_1'>SUSCRIPCI&Oacute;N TINKA POR ADELANTADO</div><div class='label_info'></div><div id='ajax-loader'><img src='layer-view-image/game/ganadiario/ajax-loader.gif'></div><div id='content-grid-result'></div><div id='num_link'></div><div id='game-no-process-info'></div>";
              $(".left-panel").html(content_grid_2);
              //$("#panel_more_plays").hide();
              $("#panel_keep-playing").show();
              $("#panel_game-history").show();
              $("#block-subscription").removeClass("disabled");/*$("#ico-block").show();*/
              //$(".label-top").show();
              $("#sub_panel").hide();
              $("#panel_finaliza_compra").hide();
              var result_ticket = "";
              var regular_price = parseFloat(content_object[0][7]);
              //var percentage = parseFloat(content_object[0][4]);
              //var net_costo = (percentage/100)*regular_price;
              //alert(regular_price);
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
              datalayerFinalizaCompra2(thisBtnFinalizarCompraComboGanadiario,'Finalizar Compra');
              
              let carrito = [];
        	  	carrito = content_object[0];
        	  	carrito[0] = carrito[0] == "00" ? "" : carrito[0];
              datalayerCheckout(carrito,carrito[6]/carrito[9]);
              
              $.ajax({type: "POST", url: "jugadasSuscripcionGanadiario.html", data: "dato=" + result_ticket, dataType: "text", success: function (e) {
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
	                //var promotional_balance=parseFloat(new_content_object[(new_content_object.length-1)][11]);
                  /*if(promotional_balance>0){
                   $(".label_resu4").html("<b>Saldo Promocional: S/. </b>" + floatFormat(new_content_object[(new_content_object.length-1)][11]));                 
                  }*/ 
                  $("#clientSale-amount").text(peformat(new_content_object[0][10]));
                  $("#clientSale-amount-2").text(peformat(new_content_object[0][10]));
                  $("#ajax-loader").hide();
                  //grilla_boletos2(new_content_object);
                  //var nom_jugadas = ["<b>A</b>", "<b>B</b>", "<b>C</b>", "<b>D</b>"];
                  var no_process_message_count = 0;
                  var grilla = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>VER</div>" + "</div>";
                  +"<div id='total_filas'>";
                  //for (var x in new_content_object) {
                      //for (var i = 0; i <= 3; i++) {
                          //if (new_content_object[x][i] != "00") {
                              //var result_ticket = nom_jugadas[i] + ": ";
                        var result_ticket = "<b>A</b>: ";
                              var numeros = ((new_content_object[0].length>13)?new_content_object[0][13]:new_content_object[0][0]).split(",");//(new_content_object[0][13]).split(",");
                              for (var num in numeros) {
                                  if (numeros[num].length < 2) {
                                      numeros[num] = "0" + numeros[num];
                                  }
                                  result_ticket += numeros[num] + " ";
                              }
                              //break
                          //}
                      //}
                      var style = "row_grid row_grid_mouseover";
                      /*if (x % 2 != 0) {
                          style += " row_grid_mouseover"
                      }
                      if (x > 2) {
                          style += " row_null"
                      }*/
                      var dato_proceso = (new_content_object[0][4] + "").split("&");
                      content_object[0][0] = ((new_content_object[0].length>13)?new_content_object[0][13]:new_content_object[0][0]);//(new_content_object[0][13]);
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
                          
                          var game_no_process_info = "<div class='title-text text-autocontrol'>" + "<div>Tienes jugadas que no se han podido procesar.</div> " + game_no_process_autocontrol  + " </div>" + "<div id='no-process-section'><a href='#' class='button button-block button-dark-green' id='btn-no-process' onclick='return false;'><b>VOLVER</b></a></div>";
                          $("#game-no-process-info").html(game_no_process_info);
                          $(".label-top").html("<div class='no-process-play'>JUGADAS NO PROCESADAS</div>");
                          $("#game-no-process-info").show()
                          $(".result1_subscribe").html("<b>S/ 0.00</b>");
                          try {
                          	if( dato_proceso[0].includes("CLIENTE NO EXISTE") == true ){
                          		taggingGanadiarioJugadaNoProcesada("No se ha encontrado el registro del cliente");
                          	}else if( dato_proceso[0].includes("CREDITO INSUFICIENTE") == true || dato_proceso[0].includes("Cuenta Lotocard ha expirado") == true ){
                          		taggingGanadiarioJugadaNoProcesada("No cuenta con saldo disponible para realizar este proceso");
                          	}else{
                          		taggingGanadiarioJugadaNoProcesada("Ocurrio un error intente nuevamente");
                          	}
							} catch (e) {
								console.error(e);
							}
                      } else {
                          process_resp = "<div class='column3-codigo'>" + dato_proceso[1] + "</div><div class='column3-search' onclick='openPreviewWindow(" + new_content_object[0][9] + ",\"" + new_content_object[0][8] + "\",\"" + dato_proceso[1] + "\")'></div>"
                          tagginGanaDiarioCompraExitosa();
                          datalayerPurchase(content_object[0],
              					content_object[0][6]/content_object[0][9],
              					'¡Has Realizado tu Suscripción con Éxito!',
              					content_object[0][6],
              					'Kabala-'+dato_proceso[1],
              					"Combo_"+content_object[0][5]);
                          new_content_object[0].push(content_object[0][8]);
                          new_content_object[0].push(content_object[0][9]);
                          ganaDiarioTagginEEpurchase(new_content_object);
                      }
                      grilla += "<div class='" + style + "'>" + "<div class='column_1'>" + new_content_object[0][7] + "</div>" + "<div class='column_2'>" + result_ticket.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + 0 + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + process_resp + "</div>"
                  //}
                  grilla += "</div></div>";
                  $("#content-grid-result").html(grilla)
                  //grilla_paginada2(new_content_object);
                  var costo_total = 0;
                  for (var t in new_content_object) {
                      var procesos = (new_content_object[t][4] + "").split("&");
                      if (procesos[1] != "null") {
                          $(".label-top").html("&#161;HAS REALIZADO TU SUSCRIPCI&Oacute;N CON &Eacute;XITO!");
                          $(".play-help").hide();
                          costo_total += parseFloat(new_content_object[t][6]);
                          
                      }
                  }
                  
                  
                  //$(".result1").html("S/." + floatFormat(costo_total));
                  //$(".label_resu1").html("TOTAL PAGADO:");
                  //$('#keep-playing').off('click');
                  //$('#game-history').off('click');    
              }})
          } else {
              jAlert("No se tiene jugadas por procesar");
              datalayerErrores('Finalizar tu Compra 2','Paso 3','Finalizar Compra','No se tiene jugadas por procesar');
          }
          if (option == 1)jAlert("Se ha realizado una recarga de saldo.\n\nMonto cargado: S/ " + amount + "\nTu saldo es: S/ " + newamount, null)
      } else {
          if (option == 1){
          	jAlert("No se ha logrado realizar la recarga.\n" + message + "\n\nMonto cargado: S/ " + amount + "\nTu saldo es: S/ " + newamount, null);
          	datalayerErrores('Finalizar tu Compra 2','Paso 3','Finalizar Compra','No se ha logrado realizar la recarga.');
          }
      }
  }
  
  window.addEventListener("message", function(event) {
		if (event.data === "lottoGanadiarioSuscriptionComprarComboGanadiario") {
			comprarComboGanadiario(); 
		} else if (event.data === "lottoGanadiarioSuscriptionFinalizarCompraComboGanadiario") {
			finalizarCompraComboGanadiario(); 
		}
  });
  
  function viewNext(){
   	  $('#password-client-header').val('');
      $('#password-client').val('');
      $(".logout").show();
      $(".unlogout").hide();
      $("#tab-item-saldo").show();
      $("#payments_section").show();
      $('.img_zona_segura').css({"margin-top":"0px"});
      $("#login_section").hide();
      $("#panel_finaliza_compra").show();
  }
};$($ganadiarioSubscription);

function show(first_letter_id, value_number) {
    value_number.sort(function (a, b) {
        return b - a;
    });
    value_number.reverse();
    $("#txt" + first_letter_id).val(value_number.join(', '));//$("#" + first_letter_id + "-text-area").val(value_number.join(', '))
}
function array_number(number_id, first_letter_id) {
    //if (first_letter_id == "J1") {
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
    for (ini = 0; ini <= 35; ini++) {
      $("#"+title+"-"+ini).prop("checked", false);
        //$("#" + title + "check_" + ini).prop('checked', false);
      $("#lbl"+title+"-"+ini).removeClass("colorChecked");
        //$("#L" + title + "check_" + ini).removeClass("colorChecked");
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
  //if (title == "J1") {
  //if(title == "jchk1") for(ini = 0; ini < 6; ini++) if(value_numberJ1[ini] == value) return false
    //if (title == "J2") {
  //if(title == "jchk2") for(ini = 0; ini < 6; ini++) if(value_numberJ2[ini] == value) return false
    //if (title == "J3") {
  //if(title == "jchk3") for(ini = 0; ini < 6; ini++) if(value_numberJ3[ini] == value) return false
    //if (title == "J4") {
  //if(title == "jchk4") for(ini = 0; ini < 6; ini++) if(value_numberJ4[ini] == value) return false
    return true;
}
function util(play, how_marca) {
  switch (play) {
        //case"J1":
    case "chk1":
            if(how_marca == 1) count1++;
            if(how_marca == 2) count1--;
            if(how_marca == 3) count1=0;
            if(how_marca == 4) count1=5;
            return count1;
            break;
   
    }
}

function combinatoria() {
  var sub_cantin1 = 0;
    /*var sub_cantin_1 = 0;
    var sub_cantin_2 = 0;
    var sub_cantin_3 = 0;
    var sub_cantin_4 = 0;*/
    //for(iniL = 1; iniL <= 4; iniL++) {
        //var contador = 0;
        var counter = 0;
        for(ini = 1; ini <= 35; ini++) {
            //if ($("#J" + iniL + "check_" + ini).is(':checked')) {
          //if($("#jchk" + iniL + "-" + ini).is(":checked")) contador++;
          if($("#chk1-" + ini).is(":checked")) counter++;
        }
        //if(counter>0) {
          //if(iniL == 1) {
                contador1 = counter;
                if(counter >= 5) cantin1 = bin_newton(counter);
                else cantin1 = 0;
                if(contador1 <= 4 && contador1 > 0) sub_cantin1 = 1;
                else sub_cantin1 = cantin1;
    
    sub_total = sub_cantin1;
    if(sub_total <= 3003) total = cantin1;
    /*if(sub_cantin1==0) {
      sub_total = sub_cantin_1 + sub_cantin_2 + sub_cantin_3 + sub_cantin_4;
      if(sub_total <= 1716) total = cantin_1 + cantin_2 + cantin_3 + cantin_4;
    }*/
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
      //discounted(total);
      if(price_base != "") {
          //dis10 = $("#discount10").data("discount").split("_");
          //dis20 = $("#discount20").data("discount").split("_");
          //dis30 = $("#discount30").data("discount").split("_");
          //dis40 = $("#discount40").data("discount").split("_");
          dis10 = $("#inp_desktop_combo_30_sorteos_ganadiario").data("discount").split("_");
          dis20 = $("#inp_desktop_combo_90_sorteos_ganadiario").data("discount").split("_");
          dis30 = $("#inp_desktop_combo_180_sorteos_ganadiario").data("discount").split("_");
          dis40 = $("#inp_desktop_combo_365_sorteos_ganadiario").data("discount").split("_");          
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
          //alert((1-parseFloat(dis10[0])/100)+"-"+(1-parseFloat(dis20[0])/100)+"-"+(1-parseFloat(dis30[0])/100));
          pricedis10 = redondeo((1-percent10/100)*priceundis10,2);
          pricedis20 = redondeo((1-percent20/100)*priceundis20,2);
          pricedis30 = redondeo((1-percent30/100)*priceundis30,2);
          pricedis40 = redondeo((1-percent40/100)*priceundis40,2);
          //alert("priceundis10="+priceundis10+" priceundis20="+priceundis20+" priceundis30="+priceundis30+" pricedis10="+pricedis10+" pricedis20="+pricedis20+" pricedis30="+pricedis30);
          $("#undiscounted10").text(peformat(priceundis10));
          $("#undiscounted20").text(peformat(priceundis20));
          $("#undiscounted30").text(peformat(priceundis30));
          $("#undiscounted40").text(peformat(priceundis40));
          $("#inp_desktop_combo_30_sorteos_ganadiario").text(peformat(pricedis10));
          $("#inp_desktop_combo_90_sorteos_ganadiario").text(peformat(pricedis20));
          $("#inp_desktop_combo_180_sorteos_ganadiario").text(peformat(pricedis30));
          
          $("#discounted10").text(peformat(pricedis10));
          $("#discounted20").text(peformat(pricedis20));
          $("#discounted30").text(peformat(pricedis30));
          $("#discounted40").text(peformat(pricedis40));
        }
      $("input[name=discount]:checked").each(function(i) {
      subscription = $(this).attr("id");//$(this).data("discount").split("_");
    });
    }
    //if(($("#same-play").hasClass("btn-active") && total >= 1 && subscription.length>0)||($("#random-play").hasClass("btn-active") && subscription.length>0)) {
    if(($("#btn_desktop_combo_ganadiario_misma_jugada").hasClass("btn-active") && total >= 1 && subscription.length>0)||($("#btn_desktop_combo_ganadiario_azar_simple").hasClass("btn-active") && subscription.length>0)) {
        //if(total==0 && subscription.length>0 && $("#random-play").hasClass("btn-active")){
        if(total==0 && subscription.length>0 && $("#btn_desktop_combo_ganadiario_azar_simple").hasClass("btn-active")){
        	total = 1;
        }
    	//if(total >= 1) {
      //costoTotalBetMensaje = callTransformByBets(parseInt(total) + 1, sorteos, v_data_value_bet, bets, pay);
        //costoTotalBet = callTransformByBets(total, sorteos, v_data_value_bet, bets, pay);
      //sorteos = (subscription=="discount10")?total*draws10:(subscription=="discount20")?total*draws20:(subscription=="discount30")?total*draws30:(subscription=="discount40")?total*draws40:1;//subscription[2];
      consecutive = (subscription=="inp_desktop_combo_30_sorteos_ganadiario")?draws10:(subscription=="inp_desktop_combo_90_sorteos_ganadiario")?draws20:(subscription=="inp_desktop_combo_180_sorteos_ganadiario")?draws30:(subscription=="inp_desktop_combo_365_sorteos_ganadiario")?draws40:1;
      sorteos = (subscription=="inp_desktop_combo_30_sorteos_ganadiario")?total*draws10:(subscription=="inp_desktop_combo_90_sorteos_ganadiario")?total*draws20:(subscription=="inp_desktop_combo_180_sorteos_ganadiario")?total*draws30:(subscription=="inp_desktop_combo_365_sorteos_ganadiario")?total*draws40:1;
      //costoTotalBetMensaje = (subscription=="discount10")?priceundis10:(subscription=="discount20")?priceundis20:(subscription=="discount30")?priceundis30:(subscription=="discount40")?priceundis40:0;//floatFormat(subscription[3]);
      costoTotalBetMensaje = (subscription=="inp_desktop_combo_30_sorteos_ganadiario")?priceundis10:(subscription=="inp_desktop_combo_90_sorteos_ganadiario")?priceundis20:(subscription=="inp_desktop_combo_180_sorteos_ganadiario")?priceundis30:(subscription=="inp_desktop_combo_365_sorteos_ganadiario")?priceundis40:0;      
      //costoTotalBet = (subscription=="discount10")?pricedis10:(subscription=="discount20")?pricedis20:(subscription=="discount30")?pricedis30:(subscription=="discount40")?pricedis40:0;//floatFormat(subscription[3]);//v_data_value_bet * total * sorteos;
      costoTotalBet = (subscription=="inp_desktop_combo_30_sorteos_ganadiario")?pricedis10:(subscription=="inp_desktop_combo_90_sorteos_ganadiario")?pricedis20:(subscription=="inp_desktop_combo_180_sorteos_ganadiario")?pricedis30:(subscription=="inp_desktop_combo_365_sorteos_ganadiario")?pricedis40:0;            
      $("#price-info").text((subscription=="inp_desktop_combo_30_sorteos_ganadiario")?months10:(subscription=="inp_desktop_combo_90_sorteos_ganadiario")?months20:(subscription=="inp_desktop_combo_180_sorteos_ganadiario")?months30:(subscription=="inp_desktop_combo_365_sorteos_ganadiario")?months40:0);
      //$("#price-info").text((subscription=="discount10")?months10:(subscription=="discount20")?months20:(subscription=="discount30")?months30:(subscription=="discount40")?months40:0);
      $("#total-bets").text(peformatint(sorteos));
      $("#price-discount").text((subscription=="inp_desktop_combo_30_sorteos_ganadiario")?percent10:(subscription=="inp_desktop_combo_90_sorteos_ganadiario")?percent20:(subscription=="inp_desktop_combo_180_sorteos_ganadiario")?percent30:(subscription=="inp_desktop_combo_365_sorteos_ganadiario")?percent40:0);
      //$("#price-discount").text((subscription=="discount10")?percent10:(subscription=="discount20")?percent20:(subscription=="discount30")?percent30:(subscription=="discount40")?percent40:0);
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
    var count_2 = cantidad - 5;
    variable = factorial(cantidad) / (120 * (factorial(count_2)));
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
    //$("#" + title + "check_" + ini).prop('checked', false);
  $(".btn-discount10").removeClass("discount10-active");
  $(".btn-discount20").removeClass("discount20-active");
  $(".btn-discount30").removeClass("discount30-active");
  $(".btn-discount40").removeClass("discount40-active");
  $("#btn_desktop_combo_ganadiario_misma_jugada").removeClass("btn-active");
  //$("#same-play").removeClass("btn-active");
  //$("#random-play").removeClass("btn-active");
  $("#btn_desktop_combo_ganadiario_azar_simple").removeClass("btn-active");
  $("#panel-disable1").removeClass("disabled");
  $("#panel-disable2").removeClass("disabled");
  //$(".panel-subscription").addClass("disabled");
  //$(".panel-subscription-book").addClass("disabled");
  //$(".panel-book").addClass("disabled");
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
  //alert(numero);
  return (numero!=null && numero!="")?parseFloat(numero).toFixed(2).replace(/\B(?=(\d{3})+\b)/g, ","):"0.00";
}
function peformatint(numero) {
  //alert(numero);
  return (numero!=null && numero!="")?parseInt(numero).toFixed(0).replace(/\B(?=(\d{3})+\b)/g, ","):"0";
}

function tagginEligeJugadaComboGanaDiario() {
	try {
		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'virtualPageView',
			'pageUrl' : '/juega-ganadiario/combo/paso1/',
			'pageTitle' : 'Elige tu jugada - Combo - Gana Diario'
		});

		var tag = "Elige tu jugada - Combo - Gana Diario";
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}

}

function tagginFinalizar() {
	try {
		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'virtualPageView',
			'pageUrl' : '/juega-ganadiario/combo/paso2/',
			'pageTitle' : 'Finaliza tu compra - Combo - Gana Diario'

		});

		var tag = "Finaliza tu compra - Combo - Gana Diario";
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}

}

function tagginGanaDiarioEEcheckout() {
	try {
		var nCombos = content_object[0][5];
		if(nCombos!=undefined && nCombos!=null && nCombos!=''){
			var price = content_object[0][6].toFixed(2);
			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEcheckout',
				'ecommerce' : {
					'checkout' : {
						'actionField' : {
							'step' : 1
						},
						'products' : [ {
							'name' : 'Gana Diario Combo ' + nCombos + ' jugadas',
							'id' : 'ganaC' + nCombos,
							'price' : price,
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Gana Diario'
						} ]
					}
				}
			});

			var tag = "EEcheckout Gana Diario";
			console.log("Taggin event: " + tag + ", Combo: " + nCombos	+ ", precio: " + price);
		}
	} catch (e) {
		console.error(e);
	}
}

function tagginGanaDiarioRemoveFromCart(datos) {
	try {
		var nCombos = datos[5];
		if(nCombos!=undefined && nCombos!=null && nCombos!=''){
			var price = datos[6].toFixed(2);
			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEremoveFromCart',
				'ecommerce' : {
					'remove' : {
						'products' : [ {
							'name' : 'Gana Diario Combo ' + nCombos + ' jugadas',
							'id' : 'ganaC' + nCombos,
							'price' : price, //Indicar el precio de la jugada que se está eliminando.
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Gana Diario'
						} ]
					}
				}
			});

			var tag = "Gana Diario combo EEremoveFromCart";
			console.log("Taggin event: " + tag + ", Combo: " + nCombos + ", precio: " + price);
		}
	} catch (e) {
		console.error(e);
	}

}

function tagginGanaDiarioCompraExitosa() {
	try {
		window.dataLayer = window.dataLayer || [];
		dataLayer.push({
			'event' : 'compraExitosa',
			'pageUrl' : '/juega-ganadiario/combo/confirmacion/',
			'pageTitle' : 'Compra exitosa - Combo - Gana Diario'
		});

		var tag = "Gana Diario combo compraExitosa";
		console.log("Taggin event: " + tag);
	} catch (e) {
		console.error(e);
	}

}

function ganaDiarioTagginEEpurchase(content_object) {
	try {
		var idTransaction = content_object[0][4].split("&")[1];
		var nCombos = content_object[0][5];
		if(nCombos!=undefined && nCombos!=null && nCombos!=''){
			var price = parseFloat(content_object[0][6]).toFixed(2);
			var opcionJugada = content_object[0][24];
			if (opcionJugada == 1) {
				opcionJugada = "Elige tu jugada";
			} else {
				opcionJugada = "Jugada al azar";
			}
			var nBolillas = "" + content_object[0][13].split(" ").length;
			var nSorteos = content_object[0][25];

			window.dataLayer = window.dataLayer || [];
			dataLayer.push({
				'event' : 'EEpurchase',
				'ecommerce' : {
					'purchase' : {
						'actionField' : {
							'id' : 'GD-' + idTransaction, // Código de la transacción
							'revenue' : price, // Monto total pagado
						},
						'products' : [ {
							'name' : 'Gana Diario Combo ' + nCombos + ' jugadas',
							'id' : 'ganaC' + nCombos,
							'price' : price,
							'brand' : 'Juegos',
							'quantity' : '1',
							'category' : 'Gana Diario',
							'dimension1' : opcionJugada, // aquí indicar opción de jugada
							'dimension2' : nSorteos, // aquí indicar el número de sorteos
							'dimension4' : nBolillas
						// aquí indicar el número de bolillas
						} ]
					}
				}
			});

			var tag = "Gana Diario combo EEpurchase";
			console.log("Taggin event: " + tag + ", combo: " + nCombos + ", precio: " + price + ", opción de jugada: " + opcionJugada);
		}
	} catch (e) {
		console.error(e);
	}

}

function taggingGanadiarioJugadaNoProcesada(mensaje){
	try{
		window.dataLayer = window.dataLayer || [ ];
		dataLayer.push({
		    'event': 'jugadaNoProcesada',
		    'category': 'UI :: Jugada no procesada',
		    'action': 'Error :: Gana Diario',  //Indicar el juego donde sucedió el error
		    'label': mensaje  //Enviar el mensaje de error que corresponda
		});
		console.log("taggingGanadiarioJugadaNoProcesada: mensaje:"+mensaje);
	}catch(e){
		console.error(e);
	}
}