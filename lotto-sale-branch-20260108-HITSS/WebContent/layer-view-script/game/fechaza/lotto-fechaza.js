$(document).ready(function(){
    $('#back_previous').remove();
    $('.font-play').css({"height":"497px"});
    $("#menu-item-4").addClass("current-menu-item");
    $('#frmLoginClientIndex').off('submit').attr('id', 'frmLoginClientFechaza').attr('action','login_fechaza.html');
    $("#frmLoginClientFechaza").on("submit", function(event) {
        event.preventDefault();
        var valida_session = "", _id = $(this).attr("id");
        $.ajax({ type: $(this).attr('method'), url: $(this).attr('action'), dataType: $(this).data('responseType'), data:$("#frmLoginClientIndex").serialize(), success:function (e) {
        	//$('#password-client-header').val('');
            var arrresp = $.trim(e).split("|");
            valida_session = arrresp[0];
            if (valida_session === 'OK' || valida_session === 'TC' || valida_session === 'MV') {
                var username = arrresp[1];
                var useramount = arrresp[2];
                var userid=arrresp[3];
                var userid = floatFormat(arrresp[3]);
                var monto1 = floatFormat(arrresp[4]);
                $("#field-balance-amount").html(monto1);
                /*if(monto2=="0.0"){
                    $(".saldo_promocional").html("");
                }else{
                    $(".saldo_promocional").html("&oacute; de mi saldo promocional S/."+monto2);
                } */
                $("#clientId").val(userid);
                $("#clientSale-name").text(username);
                $("#clientSale-amount").text(floatFormat(useramount));
                $('#user-ico').addClass(arrresp[6]);
                /*
                if(valida_session === 'MV') {
                	jAlert(arrresp[1], null);
                	$('#user-client-header').focus();
                    setCaptcha(true);
                }
				*/
                if(valida_session === 'TC') exe.opentyc(_id);
                else viewNext();
                /*$(".logout").css("display","");
                $(".unlogout").hide();
                $("#payments_section").show();
				$('.font-play').css({"height":"487px"});
				$('.img_zona_segura').css({"height":"20px"});
				$('.img_zona_segura').css({"margin-top":"-8px"});
                $("#login_section").css("display","");
                //$("#btn_finaliza_compra").show();
                $("#panel_finaliza_compra").show();*/
            } else if(valida_session === 'CC' ){
                jAlert(arrresp[1], null);
                $('#user-client-header').focus();
                setCaptcha(true);
            } else {
                jAlert(valida_session, null);
                $('#user-client-header').focus();
            }
        }})
    });
    
    var array_jugadas=[];
    var id_value;
    var option_calendar="";  
    var array_calendar=[];
    var precio_total=0;
    var precio_unit=0;    
    var tot_apuestas=1;
    var multiplicador=1;
    var combo_sorteos=$(".selectBox").html();
    var status = $("#status").val();
    if(status=='CIE'){
        disabled_game();
    }
    $('#table-of-prize').on('click',function(){
        openPreviewWindowTableFechaza(); 
    });
    function disabled_game() {
        $('.left').addClass('opacity');       
        $('.selectBox').addClass('opacity');
        $('.font').addClass('opacity');
    }
    function formatNumber(number){
        if(number.length<2){
            number="0"+number
        }
        return number
    }
    function optioncalendar(option,array_number){
        
        var result="";
        
        switch(option){
            case "DMA":
                result=option+" ";
                if(array_number[0]){
                    result+=array_number[0];
                }
                if(array_number[1]){
                    result+="/"+array_number[1];
                }
                if(array_number[2]){
                    result+="/"+array_number[2];
                }
                if(array_number[3]){
                    if(array_number[2]==""){
                        result+="/";    
                    }
                    result+=array_number[3];
                }
                if(array_number[4]){
                    result+=" x "+array_number[4];
                }
                break;
                
            case "DM":
                result=option+" ";
                
                if(array_number[0]){
                    result+=array_number[0];
                }  
                if(array_number[1]){
                    result+="/"+array_number[1];
                }
                if(array_number[4]){
                    result+=" x "+array_number[4];
                }
                break;
                    
            case "D":
                result=option+" ";
                if(array_number[0]){
                result+=array_number[0];
                }
                if(array_number[4]){
                    result+=" x "+array_number[4];
                }
                break;
                
            case "M":
                result=option+" ";
                if(array_number[1]){
                 result+=array_number[1];
                }
                if(array_number[4]){
                    result+=" x "+array_number[4];
                }
                break;
                
            case "A":
                result=option+" ";
                
                if(array_number[2]){
                    result+=array_number[2];
                }
                if(array_number[3]){
                    result+=array_number[3];
                }
                if(array_number[4]){
                    result+=" x "+array_number[4];
                }
                break;
        }
        
        $(".attribute-textarea").text(result);
    }
    
  
    $(".option").click(function(){
        if(status=='ACT'){
            desmarcar();
            multiplicador=1;
            if($(this).attr("rel")=="off"){
                $(".clear").click();
                $(".option").attr("rel","off");
                $(this).attr("rel","on");
                id_value = $(this).attr("id");
                var ide=id_value.substring(0,1);
                $(".option").removeClass("botom-cli");          
                $(this).addClass("botom-cli");      
           
                precio_unit=1;
                array_calendar=[];
                var num_apuestas=0;
            
                //BEGIN ESTADOS VELADOS Y NO VELADOS    
                switch(ide){
                    case "1":   
                        option_calendar="DMA"; 
                        num_apuestas=15000;
                    
                        $(".day-number").removeClass("botom2");    
                        $(".month-number").removeClass("botom2");   
                        $(".year-number").removeClass("botom2");
                        $(".year-number2").removeClass("botom2");
                    
                        $("#title-day").removeClass("title-number2");
                        $("#title-month").removeClass("title-number2");
                        $("#title-year").removeClass("title-number2");
                    
                        $("#text-day").removeClass("text-number2");
                        $("#text-month").removeClass("text-number2");
                        $("#text-year").removeClass("text-number2");
                
                        $(".day-number").off("click");    
                        $(".month-number").off("click");   
                        $(".year-number").off("click");
                        $(".year-number2").off("click");
                
                        $(".day-number").on("click", function () {
                            if($(this).attr("rel")=="off"){    
                                $(".day-number").removeClass("botom-cli");
                                $(this).addClass("botom-cli");
                                array_calendar[0]=formatNumber(trim($(this).html()));
                                optioncalendar(option_calendar,array_calendar);
                                $(".day-number").attr("rel","off");
                                $(this).attr("rel","on")
                            } else {
                                $(this).removeClass("botom-cli");
                                $(this).attr("rel","off");
                                array_calendar[0]="";
                                optioncalendar(option_calendar,array_calendar)
                            }
                        });
    
                        $(".month-number").on("click",function(){
                            if($(this).attr("rel")=="off"){ 
                                $(".month-number").removeClass("botom-cli");
                                $(this).addClass("botom-cli");
                                array_calendar[1]=formatNumber(trim($(this).html()));
                                optioncalendar(option_calendar,array_calendar);
                                $(".month-number").attr("rel","off");
                                $(this).attr("rel","on");
                            }else{
                                $(this).removeClass("botom-cli");
                                $(this).attr("rel","off");
                                array_calendar[1]="";
                                optioncalendar(option_calendar,array_calendar);
                            }
                        });
        
                        $(".year-number").on("click",function(){
                            if($(this).attr("rel")=="off"){ 
                                $(".year-number").removeClass("botom-cli");
                                $(this).addClass("botom-cli");
                                array_calendar[2]=trim($(this).html());
                                optioncalendar(option_calendar,array_calendar);
                                $(".year-number").attr("rel","off");
                                $(this).attr("rel","on");
                            }else{
                                $(this).removeClass("botom-cli");
                                $(this).attr("rel","off");
                                array_calendar[2]="";
                                optioncalendar(option_calendar,array_calendar);   
                            }
                        });
                
                        $(".year-number2").on("click",function(){
                            if($(this).attr("rel")=="off"){ 
                                $(".year-number2").removeClass("botom-cli");
                                $(this).addClass("botom-cli");
                                array_calendar[3]=trim($(this).html());
                                optioncalendar(option_calendar,array_calendar);
                                $(".year-number2").attr("rel","off");
                                $(this).attr("rel","on");
                            }else{
                                $(this).removeClass("botom-cli");
                                $(this).attr("rel","off");
                                array_calendar[3]="";
                                optioncalendar(option_calendar,array_calendar);   
                            }
                        });
                 
                        break;
    
                    case "2":
                        option_calendar="DM"; 
                        num_apuestas=200;
                    
                        $(".day-number").removeClass("botom2");    
                        $(".month-number").removeClass("botom2");   
                        $(".year-number").removeClass("botom2");
                        $(".year-number2").removeClass("botom2");
                    
                        $("#title-day").removeClass("title-number2");
                        $("#title-month").removeClass("title-number2");
                        $("#title-year").removeClass("title-number2");
                    
                        $("#text-day").removeClass("text-number2");
                        $("#text-month").removeClass("text-number2");
                        $("#text-year").removeClass("text-number2");
                    
                        $(".year-number").addClass("botom2");
                        $(".year-number2").addClass("botom2");
                        $("#title-year").addClass("title-number2");
                        $("#text-year").addClass("text-number2");
                    
                    
                 
                    
                        $(".day-number").off("click");
                        $(".day-number").on("click",function(){
                            if($(this).attr("rel")=="off"){ 
                                $(".day-number").removeClass("botom-cli");
                                $(this).addClass("botom-cli");
                                array_calendar[0]=formatNumber(trim($(this).html()));
                                optioncalendar(option_calendar,array_calendar);
                                $(".day-number").attr("rel","off");
                                $(this).attr("rel","on");
                            }else{
                                $(this).removeClass("botom-cli");
                                $(this).attr("rel","off");
                                array_calendar[0]="";
                                optioncalendar(option_calendar,array_calendar);   
                            }
                        });
                
                        $(".month-number").off("click");
                        $(".month-number").on("click",function(){
                            if($(this).attr("rel")=="off"){ 
                                $(".month-number").removeClass("botom-cli");
                                $(this).addClass("botom-cli");
                                array_calendar[1]=formatNumber(trim($(this).html()));
                                optioncalendar(option_calendar,array_calendar);
                                $(".month-number").attr("rel","off");
                                $(this).attr("rel","on");
                            }else{
                                $(this).removeClass("botom-cli");
                                array_calendar[1]="";
                                optioncalendar(option_calendar,array_calendar);
                                $(this).attr("rel","off");
                            }
                        });
        
                        $(".year-number").off("click");
                        $(".year-number2").off("click");
                
                        break;
                
                    case "3":
                        option_calendar="D"; 
                        num_apuestas=20;
                    
                        $(".day-number").removeClass("botom2");    
                        $(".month-number").removeClass("botom2");   
                        $(".year-number").removeClass("botom2");
                        $(".year-number2").removeClass("botom2");
                    
                        $("#title-day").removeClass("title-number2");
                        $("#title-month").removeClass("title-number2");
                        $("#title-year").removeClass("title-number2");
                    
                        $("#text-day").removeClass("text-number2");
                        $("#text-month").removeClass("text-number2");
                        $("#text-year").removeClass("text-number2");
                    
                    
                        $(".month-number").addClass("botom2");   
                        $(".year-number").addClass("botom2");
                        $(".year-number2").addClass("botom2");
                    
                        $("#title-month").addClass("title-number2");
                        $("#title-year").addClass("title-number2");
                    
                        $("#text-month").addClass("text-number2");
                        $("#text-year").addClass("text-number2");
                    
                        $(".day-number").off("click");
                        $(".day-number").on("click",function(){
                        if($(this).attr("rel")=="off"){ 
                            $(".day-number").removeClass("botom-cli");
                            $(this).addClass("botom-cli");
                            array_calendar[0]=formatNumber(trim($(this).html()));
                            optioncalendar(option_calendar,array_calendar);
                            $(".day-number").attr("rel","off");
                            $(this).attr("rel","on");
                        }else{
                            $(this).removeClass("botom-cli");
                            array_calendar[0]="";
                            optioncalendar(option_calendar,array_calendar);
                            $(this).attr("rel","off");
                        }                    
                        });
    
                        $(".month-number").off("click");
                        $(".year-number").off("click");
                        $(".year-number2").off("click");
                        break;

                    case "4":
                        option_calendar="M"; 
                        num_apuestas=6;
                                
                        $(".day-number").removeClass("botom2");    
                        $(".month-number").removeClass("botom2");   
                        $(".year-number").removeClass("botom2");
                        $(".year-number2").removeClass("botom2");
                    
                        $("#title-day").removeClass("title-number2");
                        $("#title-month").removeClass("title-number2");
                        $("#title-year").removeClass("title-number2");
                    
                        $("#text-day").removeClass("text-number2");
                        $("#text-month").removeClass("text-number2");
                        $("#text-year").removeClass("text-number2");                    
                   
                        $(".day-number").addClass("botom2");  
                        $(".year-number").addClass("botom2");
                        $(".year-number2").addClass("botom2");
                    
                        $("#title-day").addClass("title-number2");
                        $("#title-year").addClass("title-number2");
                    
                        $("#text-day").addClass("text-number2");
                        $("#title-year").addClass("title-number2");
                        $("#text-year").addClass("text-number2");
                
                
                        $(".day-number").off("click");
                
                        $(".month-number").off("click");
                        $(".month-number").on("click",function(){
                            if($(this).attr("rel")=="off"){ 
                                $(".month-number").removeClass("botom-cli");
                                $(this).addClass("botom-cli");
                                array_calendar[1]=formatNumber(trim($(this).html()));
                                optioncalendar(option_calendar,array_calendar);
                                $(".month-number").attr("rel","off");
                                $(this).attr("rel","on");
                            }else{
                                $(this).removeClass("botom-cli");
                                array_calendar[1]="";
                                optioncalendar(option_calendar,array_calendar);
                                $(this).attr("rel","off");   
                            }
                        });
        
                        $(".year-number").off("click");
                        $(".year-number2").off("click");
                        break;

                    case "5":
                        option_calendar="A"; 
                        num_apuestas=60;
                    
                        $(".day-number").removeClass("botom2");    
                        $(".month-number").removeClass("botom2");   
                        $(".year-number").removeClass("botom2");
                        $(".year-number2").removeClass("botom2");
                    
                        $("#title-day").removeClass("title-number2");
                        $("#title-month").removeClass("title-number2");
                        $("#title-year").removeClass("title-number2");
                    
                        $("#text-day").removeClass("text-number2");
                        $("#text-month").removeClass("text-number2");
                        $("#text-year").removeClass("text-number2");
                    
                    
                        $(".day-number").addClass("botom2");    
                        $(".month-number").addClass("botom2");
                        $("#title-day").addClass("title-number2");
                        $("#title-month").addClass("title-number2");
                        $("#text-day").addClass("text-number2");
                        $("#text-month").addClass("text-number2");
                                        
                
                        $(".day-number").off("click");    
                        $(".month-number").off("click");   
                
                        $(".year-number").off("click");
                        $(".year-number").on("click",function(){
                        if($(this).attr("rel")=="off"){ 
                            $(".year-number").removeClass("botom-cli");
                            $(this).addClass("botom-cli");
                            array_calendar[2]=trim($(this).html());
                            optioncalendar(option_calendar,array_calendar);
                            $(".year-number").attr("rel","off");
                            $(this).attr("rel","on");
                            
                        }else{
                            $(this).removeClass("botom-cli");
                            array_calendar[2]="";
                            optioncalendar(option_calendar,array_calendar);
                            $(this).attr("rel","off");                          
                        }
                        });                
                        $(".year-number2").off("click");
                        $(".year-number2").on("click",function(){
                        if($(this).attr("rel")=="off"){ 
                            $(".year-number2").removeClass("botom-cli");
                            $(this).addClass("botom-cli");
                            array_calendar[3]=trim($(this).html());
                            optioncalendar(option_calendar,array_calendar);
                            $(".year-number2").attr("rel","off");
                            $(this).attr("rel","on");
                        }else{             
                            $(this).removeClass("botom-cli");
                            array_calendar[3]="";
                            optioncalendar(option_calendar,array_calendar);
                            $(this).attr("rel","off");    
                        }
                        });
                        break;            
                    default:
                        num_apuestas=0;
                        multiplicador=1;
                        $(".day-number").off("click");    
                        $(".month-number").off("click");   
                        $(".year-number").off("click");
                        $(".year-number2").off("click");
                        break;
                }
                tot_apuestas=parseFloat(num_apuestas);
          
        //END ESTADOS VELADOS Y NO VELADOS     
        
            }else{
                tot_apuestas=0;
                multiplicador=1;
                $(this).attr("rel","off");
                $(this).removeClass("botom-cli");
                option_calendar=""; 
                array_calendar=[];
                precio_unit=0;
                
            
                $(".day-number").addClass("botom2");    
                $(".month-number").addClass("botom2");   
                $(".year-number").addClass("botom2");
                $(".year-number2").addClass("botom2");
                    
                $("#title-day").addClass("title-number2");
                $("#title-month").addClass("title-number2");
                $("#title-year").addClass("title-number2");
                    
                $("#text-day").addClass("text-number2");
                $("#text-month").addClass("text-number2");
                $("#text-year").addClass("text-number2");
            
            
                $(".day-number").off("click");    
                $(".month-number").off("click");   
                $(".year-number").off("click");
                $(".year-number2").off("click");
         
                desmarcar();
            }
            var draw = 0;
            if($('#mySelectBox').val()!=undefined){
                draw = parseInt($('#mySelectBox').val()); 
            } 
            precio_total=precio_unit*parseFloat(draw);
            var win_to = numberWithCommas(tot_apuestas*parseFloat(draw));
            $("#num-apuestas").html(win_to);  
            $("#comb").html(draw);
            $("#total-game").html(floatFormat(precio_total));
        }
    });    
    
    $(".azar").click(function(){        
        if(status=='ACT'){
            var num_item= Math.floor(Math.random() * (5-1+1)) + 1;
            $(".option").removeClass("botom-cli");
            $(".option").attr("rel","off");
            $("#"+num_item+"F").click();
            $("#nano").html(num_item); 
            var dia,mes,anio1,anio2;       
            switch(option_calendar){
                            
                case "DMA":
                               
                    dia=ramdon_calendar("D");
                    mes=ramdon_calendar("M");
                    anio1=ramdon_calendar("A");
                    anio2=ramdon_calendar("A");
                    desmarcar();           
                    $("#"+dia+"D").click();
                    $("#"+mes+"M").click();
                    $("#"+anio1+"Y").click();
                    $("#"+anio2+"YT").click();
                
                
                    break;
                                
                case "DM":
                         
                    dia=ramdon_calendar("D");
                    mes=ramdon_calendar("M");
                    desmarcar(); 
                
                    $("#"+dia+"D").click();
                    $("#"+mes+"M").click();
                
                    break;
                
                case "D":
                
                    dia=ramdon_calendar("D");
                    desmarcar(); 
                
                    $("#"+dia+"D").click();
                
                    break;
 
                case "M":
                    desmarcar(); 
                
                    mes=ramdon_calendar("M");
                    $("#"+mes+"M").click();
                
                    break;
                
                case "A":
                    desmarcar();     
                
                    anio1=ramdon_calendar("A");
                    anio2=ramdon_calendar("A");
                                
                    $("#"+anio1+"Y").click();
                    $("#"+anio2+"YT").click();
                
                    break;                
                
            }
            $("#nano").html(dia+"-"+mes+"-"+anio1+anio2); 
        }
    });
        
        
    $(".clear").on("click",function(){
        if(status=='ACT'){
            precio_unit=0;
            $(".day-number").addClass("botom2");    
            $(".month-number").addClass("botom2");   
            $(".year-number").addClass("botom2");
            $(".year-number2").addClass("botom2");
                
            $("#title-day").addClass("title-number2");
            $("#title-month").addClass("title-number2");
            $("#title-year").addClass("title-number2");
                
            $("#text-day").addClass("text-number2");
            $("#text-month").addClass("text-number2");
            $("#text-year").addClass("text-number2");
            
        
            $(".day-number").off("click");    
            $(".month-number").off("click");   
            $(".year-number").off("click");
            $(".year-number2").off("click");
     
        
            $(".botom").removeClass("botom-cli");
            $(".botom").attr("rel","off");
            $(".multi-item").attr("rel","off");
            option_calendar="";  
            array_calendar=[];
            precio_total=0;
            $("#comb").html("0");
            $("#total-game").html(floatFormat(precio_total));
            $(".attribute-textarea").html("");
        }
    });    
    
    
    function ramdon_calendar(option){
        var MIN=0;
        var MAX=0;
        switch(option){
            case "D":
                MIN=1;
                MAX=31;
                break;
            case "M":
                MIN=1;
                MAX=12;
                break;
            case "A":
                MIN=0;
                MAX=9;
                break;
        }
        var option_num= Math.floor(Math.random() * (MAX-MIN+1)) + MIN;
        return option_num;
    }
    
    function desmarcar(){
        $(".day-number").attr("rel","off");    
        $(".month-number").attr("rel","off");
        $(".year-number").attr("rel","off");
        $(".year-number2").attr("rel","off");
        
        $(".day-number").removeClass("botom-cli");    
        $(".month-number").removeClass("botom-cli");
        $(".year-number").removeClass("botom-cli");
        $(".year-number2").removeClass("botom-cli");
        
        $(".attribute-textarea").html("");
    }
    
    $(".multi-item").click(function(){
        if(status=='ACT'){
            var draw = 0;
            if($('#mySelectBox').val()!=undefined){
                draw = parseInt($('#mySelectBox').val()); 
            } 
            $(".multi-item").removeClass("botom-cli");  
            if($(this).attr("rel")=="off"){
            var total=0;
            multiplicador=parseFloat($(this).html());
            total=tot_apuestas*multiplicador;
                if(total<=300000){
                    multiplicador=parseFloat($(this).html());
                    total=tot_apuestas*multiplicador;
                    $(".multi-item").attr("rel","off");
                    $(this).addClass("botom-cli");
                    array_calendar[4]=trim($(this).html());
                    $(this).attr("rel","on");
                    optioncalendar(option_calendar,array_calendar);                    
                    precio_total=precio_unit*parseFloat(array_calendar[4])*parseFloat(draw);
                    $("#comb").html(draw);
                    $("#total-game").html(floatFormat(precio_total));
                }else{
                    multiplicador=1;
                    total=tot_apuestas*multiplicador;
                    $(".multi-item").attr("rel","off");
                    array_calendar[4]=null;
                    optioncalendar(option_calendar,array_calendar);                    
                    precio_total=precio_unit*parseFloat(draw);
                    $("#comb").html(draw);
                    $("#total-game").html(floatFormat(precio_total));
                }
                var win_to = numberWithCommas(total*parseFloat(draw));
                $("#num-apuestas").html(win_to); 
        }else{
            multiplicador=1;
            array_calendar[4]=null;
            var win_to = numberWithCommas(tot_apuestas*multiplicador*parseFloat(draw));
            $("#num-apuestas").html(win_to);
            optioncalendar(option_calendar,array_calendar);
            $(".multi-item").attr("rel","off");
            precio_total=precio_unit*parseFloat(draw);
            $("#comb").html(draw);
            $("#total-game").html(floatFormat(precio_total));           
        }            
       }        
    });
    
    
    $("#mySelectBox").on("change",function(){
        if(status=='ACT'){        
            var val=0;
            if(array_calendar[4]){
                precio_total=precio_unit*parseFloat(array_calendar[4])*parseFloat($(this).val());
    
            }else{
                precio_total=precio_unit*parseFloat($(this).val());
            }
            $("#comb").html($(this).val());
            $("#total-game").html(floatFormat(precio_total));    
            val = numberWithCommas(tot_apuestas*parseFloat($(this).val())*multiplicador);
            $("#num-apuestas").html(val);
        }
    });
     
 var mensaje_error="";
 function valida_jugada(optioncalendar,arraycalendar){
        var respuesta=false;
        if(optioncalendar!=""){
        switch(optioncalendar){
        case "DMA":
            for(var i=0;i<=3;i++){
                if(arraycalendar[i]!="" && arraycalendar[i]!=null){
                    respuesta=true;
                    mensaje_error="";
                }else{
                    respuesta=false;
                    mensaje_error="Formato incorrecto. El formato correcto es: dd/mm/aa.";
                    break;
                }
            }
        break;
        case "DM":
            for(var i=0;i<=1;i++){
                if(arraycalendar[i]!="" && arraycalendar[i]!=null){
                    respuesta=true;
                    mensaje_error="";
                }else{
                    mensaje_error="Formato incorrecto. El formato correcto es: dd/mm.";
                    respuesta=false;break;
                }
            }
        break;
        case "D":
            if(arraycalendar[0]!="" && arraycalendar[0]!=null){
                respuesta=true;
                mensaje_error="";
            }else{
                mensaje_error="Formato incorrecto. Marque opción del día.";
                respuesta=false;
            }
        break;
        case "M":
            if(arraycalendar[1]!="" && arraycalendar[1]!=null){
                respuesta=true;
                mensaje_error="";
            }else{
                mensaje_error="Formato incorrecto. Marque opción del Mes.";
                respuesta=false;break;
            }
        break;
        case "A":
            for(var i=2;i<=3;i++){
                if(arraycalendar[i]!="" && arraycalendar[i]!=null){
                    respuesta=true;
                    mensaje_error="";
                }else{
                    mensaje_error="Formato incorrecto. Marque opción del A&ntilde;o.";
                    respuesta=false;break;
                }
            }
        break;
        }
            
        }else{
        respuesta=false;
        mensaje_error='No ha realizado ninguna jugada.';
        }
        return respuesta;
    }
    
    $("#btn-jugar").click(function(){       
        if(status=='ACT'){
            if(valida_jugada(option_calendar,array_calendar)){
                $("#panel-transition").removeClass("transition-one");
                $("#panel-transition").addClass("transition-two");
        
                $(".zona-juego").hide();
                $(".finalize-purchase").show();
                var jugada=[];
                var num_jugados=$(".attribute-textarea").html();
                var num_sorteos=parseFloat($("#mySelectBox").val());
                jugada=[num_jugados,num_sorteos,precio_total];
                array_jugadas.push(jugada);
                option_calendar="";  
                array_calendar=[];
                precio_total=0;
                precio_unit=0;      
                grilla_boletos(array_jugadas);
                grilla_paginada(array_jugadas);
        
        
                var costo_total=0;
                for(var i in array_jugadas){
                    costo_total+=parseFloat(array_jugadas[i][2]);
                }
                $(".result1").html("S/."+floatFormat(costo_total));
                $("#panel_more_plays").show();
                $("#panel_keep-playing").hide();
                $("#panel_game-history").hide();      
                $("#ico-block").hide();        
                $(".selectBox").html("");
                $(".selectBox").html(combo_sorteos);
				$('.font-play').css({"height":"470px"});
                $(".clear").click();
            }else{
                jAlert(mensaje_error);
            }
        }       
    });
        
    $("#more_plays").click(function(){
        $("#panel-transition").removeClass("transition-two");
        $("#panel-transition").addClass("transition-one");
        $('.font-play').css({"height":"497px"});
        $(".zona-juego").show();
        $(".finalize-purchase").hide();
        $(".clear").click();
    });
    
    function grilla_boletos2(data){
        var no_process_message_count=0; 
        var grilla="<div id='grilla_boleto'>"
                            +"<div class='boleto_cabecera'>"
                                 +"<div class='head_title_1'>N.</div>"
                                 +"<div class='head_title_2'>BOLETOS</div>"
                                 +"<div class='head_title_3'>VER</div>"
                            +"</div>";
                      +"<div id='total_filas'>";    
          for(var i in data){
              var style="row_grid";
              if(i%2!=0){
              style+=" row_grid_mouseover";
              }
              
              if(i>2){
                  style+=" row_null";
              }
              
              var process_resp="";
              if(data[i][3]=="null"){
                process_resp="<div class='column3-no-process'>No procesado&nbsp;&nbsp;<span class='no-process' rel='"+no_process_message_count+"#"+data[i][4]+"'>[?]</span> </div>";
                process_resp+="<div class='tooltip-no-process'></div><div class='tooltip-no-process-arrow-img'></div></div>";
                no_process_message_count++;
                
                var game_no_process_info= "<div class='title-text'><div><b>Jugadas no procesadas</b></div>"//"<div class='title-text'><div><b>Jugadas pendientes</b></div>"
                        +"<div>Tienes apuestas que no se han podido procesar.</div></div>"
                        //+"<div class='buttom-go' id='btn-no-process'></div>";
                        +"<div id='no-process-section'><a href='#' class='buttom-go' id='btn-no-process' onclick='return false;'></a></div>";
                $("#game-no-process-info").html(game_no_process_info);
                $("#game-no-process-info").show();      

                
              }else{

                    process_resp="<div class='column3-codigo'>"+data[i][3]+"</div><div class='column3-search' onclick='openPreviewWindow("+data[i][8]+",\""+data[i][7]+"\",\""+data[i][3]+"\")'></div>";    

              }
              
              
                  grilla += "<div class='"+style+"'>"
                      +"<div class='column_1'>"+(parseInt(i)+1)+"</div>"
                      +"<div class='column_2'>"+data[i][0]+"</div>"
                      +process_resp
                      +"</div>";  
              
          }      
         grilla +="</div></div>";
            
        $('#content-grid-result').html(grilla);
        }
    
    function grilla_boletos(data){
       var grilla="<div id='grilla_boleto'>"
                        +"<div class='boleto_cabecera'>"
                             +"<div class='head_title_1'>N.</div>"
                             +"<div class='head_title_2'>BOLETOS</div>"
                             +"<div class='head_title_3'>ANULAR</div>"
                        +"</div>";
                  +"<div id='total_filas'>";    
      for(var i in data){
          var style="row_grid";
           if(i%2!=0){
           style+=" row_grid_mouseover";
           }
           
           if(i>2){
               style+=" row_null";
           }
              grilla += "<div class='"+style+"'>"
                   +"<div class='column_1'>"+(parseInt(i)+1)+"</div>"
                   +"<div class='column_2'>"+data[i][0]+"</div>"
                   +"<div class='column_3'>"
                   +"<div class='delete process-delete1' rel='"+i+"'></div>"
                   +"</div>"
                   +"</div>";  
          
      }      
     grilla +="</div></div>";
        
    $('#content-grid-result').html(grilla);
    } 
    $('.left-panel').on('click', '#btn-no-process', function () {
        var contador=0;
        var array_no_procesados=[];
        for(var i in array_jugadas){
            if(array_jugadas[i][3]=="null"){
                array_no_procesados.push(array_jugadas[i]);
                contador++;
                }   
            }
        array_jugadas=[];
        array_jugadas=array_no_procesados;
        grilla_boletos(array_jugadas);
        grilla_paginada(array_jugadas);
        
        var costo_total=0;
        for(var i in array_jugadas){
            costo_total+=parseFloat(array_jugadas[i][2]);
        }
        $(".result1").html("S/."+floatFormat(costo_total));
        
        $("#game-no-process-info").hide();
        //$(".class_more_plays").show();
        $("#panel_more_plays").show();
        $("#sub_panel").show();
        //$(".btn_finaliza_compra").show();
        $("#panel_finaliza_compra").show();
        $('#panel_keep-playing').hide();
        //$(".class-game-history").hide();
        $("#panel_game-history").hide();
        $("#ico-block").hide();
        $(".label-top").html("");   
        $(".label_resu3").html("");
        //$(".label_resu4").html("");
        $('#keep-playing').on('click', function(event){
            event.preventDefault();            
         });
        $('#game-history').on('click',function(event){
            event.preventDefault();
        });
        $(".label_resu1").html("TOTAL A PAGAR:");
    });
    
    
    function grilla_paginada(data){
        var count_rows= data.length;
        var links="";
        var cont=0;
        var style="";
        var posx=0;
        var posy=1;
        var posz=2;
        
        for(var i=0;i<count_rows;i++){
            
        if(i==0){
        style="num_page_off"; 
        }
        else{
        style="num_page_on"; 
        }
            if(i%3==0){
                cont++;
                links+="&nbsp;<a class='lnk-pag1 lnk "+style+" ' id='"+posx+"-"+posy+"-"+posz+"' rel='"+posx+"-"+posy+"-"+posz+"' >"+cont+"</a>&nbsp;";
                posx=posx+3;
                posy=posy+3;
                posz=posz+3;
                
            }
        }
       $('#num_link').html("<span class='indice_page'>1</span> de "+cont+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<"+links+">");
    }
    
    $('.left-panel').on('click', '.lnk-pag1', function () {
        var cadena_pos=$(this).attr("rel");
        var id=$(this).attr("id");
        var posiciones=cadena_pos.split("-");
        
        $(".row_grid").removeClass("row_null");
        $(".row_grid").addClass("row_null");
        
        for(var num in posiciones){
        $(".row_grid").eq(posiciones[num]).removeClass("row_null");    
        }
        grilla_paginada(array_jugadas);
        $(".indice_page").html($("#"+id).html());
        $(".lnk").removeClass("num_page_on");
        $(".lnk").removeClass("num_page_off");
        $(".lnk").addClass("num_page_on");
        $("#"+$(this).attr("id")).removeClass("num_page_on");
        $("#"+$(this).attr("id")).addClass("num_page_off");
    });
    
    $('.left-panel').on('click', '.process-delete1', function () {
        var pos=parseInt($(this).attr("rel"));
        array_jugadas.splice(pos,1) ;
        grilla_boletos(array_jugadas);
        grilla_paginada(array_jugadas);        
            var costo_total=0;
            for(var i in array_jugadas){
                costo_total+=parseFloat(array_jugadas[i][2]);
            }
            $(".result1").html("S/."+floatFormat(costo_total));
            if(array_jugadas.length==0){
                $('#more_plays').click();
            }
    });
    
    $("#btn_finaliza_compra").on('click',function(){
        var option = $("[name=option-card]:checked").val();
        var pin = $("[name=pin-number]").val();
        var message = "";
        var amount = 0.0;
        var newamount = 0.0;
        var msgres = new Array();
        if(option == 0) {
            message = "OK";
        } 
        message = message.replace(/_/g,' ');
        if(message == "OK") {
            if(array_jugadas.length!=0){
            $("#sub_panel").hide();
            $("#panel_finaliza_compra").hide();
            
            
            $(".left-panel").html("");
               var content_grid_2="<div class='label-top'></div>"
                        +"<div class='label_1'>FECHAZA</div>"
                        +"<div id='ajax-loader'>"
                        +"<img src='layer-view-image/common/ajax-loader.gif'>"
                        +"</div><div id='content-grid-result'></div>"
                        +"<div id='num_link'></div>";
              content_grid_2+="<div id='game-no-process-info'></div>";
              $(".left-panel").html(content_grid_2);
             // $(".window-message").show();
             // $(".window-message").html('<div class="loading"></div>PROCESANDO');
             // $("#dhtmlwindowoverlay").show();
            //$(".class_more_plays").hide();
              $("#panel_more_plays").hide();
            //$(".class-keep-playing").show();
              $("#panel_keep-playing").show();
            //$(".class-game-history").show();
              $("#panel_game-history").show();
              $("#ico-block").show();
              $("#ajax-loader").show();
            
            var result_ticket="";
            for(var i in array_jugadas){
                if(i!=0){
                    result_ticket+="#";
                }
                    for(var j in array_jugadas[i]){
                        if(j!=0){
                            result_ticket+="|";
                        }
                        
                        result_ticket+=array_jugadas[i][j];
                        
                    }   
           }
            
        $.ajax({
                type:"POST",
                url:"ajaxFechaza.html",
                dataType: "text",
                data:"dato="+result_ticket,
                success:function(e){
                    array_jugadas=[];
                    var cadena_array=(e+"").split("#");
                    for(var v in cadena_array){
                        var fila=(cadena_array[v]+"").split("|");
                        var row_object=[];
                        for(var w in fila){
                            row_object.push(fila[w]);
                        }
                        array_jugadas.push(row_object);
                    }
                    $("#ajax-loader").hide(); 
                    // $(".window-message").html("");
                    // $(".window-message").hide();
                    //$("#dhtmlwindowoverlay").hide();
                    grilla_boletos2(array_jugadas);
                    grilla_paginada(array_jugadas);
                    
                    $(".label_resu3").html("<b>Saldo Disponible: S/. </b>"+floatFormat(array_jugadas[(array_jugadas.length-1)][5]));
                    //$(".label_resu4").html("<b>Saldo Promocional: S/. </b>"+array_jugadas[(array_jugadas.length-1)][6]);
                    $("#clientSale-amount").text(floatFormat(array_jugadas[(array_jugadas.length-1)][5]));
    
                    
                    var costo_total=0;
                    for(var t in array_jugadas){
                        if(array_jugadas[t][3]!="null"){
                        $(".label-top").html("&#161;GRACIAS POR TU COMPRA!");    
                        costo_total+=parseFloat(array_jugadas[t][2]);
                        
                        }   
                    }
                    
                    $(".result1").html("S/."+floatFormat(costo_total));
                    $(".label_resu1").html("TOTAL PAGADO:");
                    $('#keep-playing').off('click');
                    $('#game-history').off('click');
                }
            });  
            }else{
                jAlert("No se tiene jugadas por procesar");
            }
        if(option == 1) jAlert("Se ha realizado una recarga de saldo.\n\nMonto cargado: S/. "+amount+"\nTu saldo es: S/. "+newamount, null);
        } else {
            if(option == 1) jAlert("No se ha logrado realizar la recarga.\n"+message+"\n\nMonto cargado: S/. "+amount+"\nTu saldo es: S/. "+newamount, null);
        }
    });
    
    $('.left-panel').on('mouseover', '.no-process',function () {
        
        var contenido_total=$(this).attr("rel");
        var contenido_temp=(contenido_total+"").split("#");
        var posicion=parseInt(contenido_temp[0]);
        var mensaje=contenido_temp[1]+"";

            $(".tooltip-no-process").eq(posicion).show();
            $(".tooltip-no-process").eq(posicion).html(mensaje); 
            $(".tooltip-no-process-arrow-img").eq(posicion).show(); 

    });
    $('.left-panel').on('mouseout', '.no-process',function () {
            var contenido_total=$(this).attr("rel");
            var contenido_temp=contenido_total.split("#");
            var posicion=parseInt(contenido_temp[0]);
            var mensaje=contenido_temp[1];
        
            $(".tooltip-no-process").eq(posicion).hide();
            $(".tooltip-no-process").eq(posicion).html(mensaje); 
            $(".tooltip-no-process-arrow-img").eq(posicion).hide();  
     });
    $('#keep-playing').on('click', function(event){
        event.preventDefault();            
     }); 
    $('#game-history').on('click',function(event){
        event.preventDefault();
    });
    $("#numbersMore").click(function(){
        if(status=='ACT'){
            var massalieron=trim($("#fechazaNumbersMore").val())+"";
            var arraymassalieron=massalieron.split("/");
            var dia=parseInt(trim(arraymassalieron[0]));
            var mes=parseInt(trim(arraymassalieron[1]));
            var anio=(trim(arraymassalieron[2])+"").split("");
            var anio1=trim(anio[0]);
            var anio2=trim(anio[1]);
        
            $(".botom").attr("rel","off");
            $(".botom").removeClass("botom-cli");
        
            $("#1F").click();
            $("#"+dia+"D").click();
            $("#"+mes+"M").click();
            $("#"+anio1+"Y").click();
            $("#"+anio2+"YT").click();
        }
    
    });
    
    $("#numbersLess").click(function(){
        if(status=='ACT'){
            var menossalieron=trim($("#fechazaNumbersLess").val())+"";
            var arraymenossalieron=menossalieron.split("/");
            var dia=parseInt(trim(arraymenossalieron[0]));
            var mes=parseInt(trim(arraymenossalieron[1]));
            var anio=(trim(arraymenossalieron[2])+"").split("");
            var anio1=trim(anio[0]);
            var anio2=trim(anio[1]);
        
            $(".botom").attr("rel","off");
            $(".botom").removeClass("botom-cli");       
            $("#1F").click();
            $("#"+dia+"D").click();
            $("#"+mes+"M").click();
            $("#"+anio1+"Y").click();
            $("#"+anio2+"YT").click();
        }
    
    });
    /*SESSION JUEGOS*/
    /*$('#frmLoginClientPuchase').on('submit',function(event){
    	event.preventDefault();
        var user=$('#user-client').val();
        var pass=$('#password-client').val();  
        var valida_session = "", _id = $(this).attr("id");
        if(user=='' || pass==''){
            jAlert('Complete los datos de usuario');
        } else {
        $.ajax({
            type:"POST",
            url:"login_fechaza.html",
            dataType:"text",
            dataType:"text",
            data:$("#frmLoginClient").serialize(),
            success:function(e){
            	//$('#password-client').val('');
                var resp = $.trim(e);
                var arrresp = resp.split("|");
                valida_session = arrresp[0];
                if(valida_session == 'OK' || valida_session === 'TC') {
                    var username = arrresp[1];
                    var useramount = arrresp[2];
                    var userid=arrresp[3];
                    var monto1=floatFormat(arrresp[4]);
                    var monto2=floatFormat(arrresp[5]);       
                    
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
                    
                    $("#field-balance-amount").html(monto1);                   
                    $("#clientId").val(userid);
                    $("#clientSale-name").text(username);
                    $("#clientSale-amount").text(floatFormat(useramount));
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
                    if(valida_session === 'TC') exe.opentyc(_id);
                    else viewNext();
                } else if(valida_session === 'CC'){
                    jAlert(arrresp[1], null);
                    $('#user-client').focus();
                    setCaptcha(true);
                } else {
                    jAlert(valida_session, null);
                    $('#user-client').focus();
                }
            }
        });
        }
    });*/

        var idsession=$("#clientId").val();
        if(idsession != '' && $("#agreement").val() == ''){
        	$("#login_section").show();
            $('.img_zona_segura').css({"margin-top":"93px"});
        	exe.opentyc(null);
        } else if(idsession==''){
            $("#login_section").show();
            $('.img_zona_segura').css({"margin-top":"93px"});
        } else {
            $("#panel_finaliza_compra").show();
            $("#payments_section").show();
    		$('.font-play').css({"height":"487px"});
    		$('.img_zona_segura').css({"height":"20px"});
    		$('.img_zona_segura').css({"margin-top":"-8px"})
        }
                
    function fecha_actual(){
        var f = new Date();
        var mes="";
        var dia="";
        var temp_mes=f.getMonth()+"";
        var temp_dia=f.getDate()+"";
        
        if (temp_mes.length==1) {
            mes="0"+(f.getMonth()+1)+"";
        } else {
            mes=(f.getMonth()+1)+"";
        }
        
        if(temp_dia.length==1){
            dia="0"+f.getDate()+"";
        } else {
            dia=f.getDate()+"";
        }
        
        
        return dia+ "/" + mes + "/" + f.getFullYear();
    }
    $(".label_2").html(fecha_actual());

        
    function trim (string) {
        for (i=0; i<string.length; ) {
            if (string.charAt(i)==" ") {
                string=string.substring(i+1, string.length);
            } else {
                break;
            }
        }
        for (i=string.length-1; i>=0; i=string.length-1) {
            if (string.charAt(i)==" ") {
                string=string.substring(0,i);
            } else {
                break;
            }
        }
        return string;
    }        

    $("#option-card-0").click(function(){
        $("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","");
		 $("#panel_transaccion_4").css("display","");
		$("#panel_transaccion_5").css("display","");
		$('.font-play').css({"height":"486px"});
    });
    
    $("#option-card-1").click(function(){
        $("#panel_transaccion_1").css("display","block");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","");
        $("#panel_transaccion_4").css("display","");
		$("#panel_transaccion_5").css("display","");
		$('.font-play').css({"height":"543px"});
    });
    
    $("#option-card-2").click(function(){
        $("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","block");
        $("#panel_transaccion_3").css("display","");
        $("#panel_transaccion_4").css("display","");
		$("#panel_transaccion_5").css("display","");
		$('.font-play').css({"height":"572px"});
    });

    $("#option-card-3").click(function(){
        $("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","block");
        $("#panel_transaccion_4").css("display","");
		$("#panel_transaccion_5").css("display","");
		$('.font-play').css({"height":"584px"});
    });
    
	$("#option-card-4").click(function () {
		$("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","");
		$('.font-play').css({"height":"592px"});
        $("#panel_transaccion_4").css("display","block");
		$("#panel_transaccion_5").css("display","");
	})
	
	$("#option-card-5").click(function () {
		$("#panel_transaccion_1").css("display","");
        $("#panel_transaccion_2").css("display","");
        $("#panel_transaccion_3").css("display","");
		$('.font-play').css({"height":"644px"});
        $("#panel_transaccion_5").css("display","block");
		$("#panel_transaccion_4").css("display","");
	})
	
	
	$("#pagoEfecHelp").click(function(e) {
		var pagoEfectivoHelp=$("#pagoEfectivoHelp").val();
	    dhtmlwindow.open('resultbox', 'iframe',pagoEfectivoHelp, '¿Cómo funciona PagoEfectivo?', 'width=600,height=635px,scrolling=0,center=1,resize=0', 'recal');
	    });
	    
	/*
	$("#btncargar4").click(function(e) {
	       var firstname=$("#nombre").val();
		   var lastname=$("#apPaterno").val();
		   var maidenname=$("#apMaterno").val();
		   var email=$("#mail").val();
		   var phone=$("#phone").val();
		   var country=$("#country").val();
		   var city=$("#city").val();
		   var address=$("#addres").val();
		   var typeId=$("#typeId").val();
		   var numberid=$("#numberId").val();
		   var posAmount=document.getElementById("pagoEfectivo-valor").value;
		   var mail=$("#email").val();
		   var clientId=$("#clientId").val();
		   var sessionId=$("#sesionId").val();
		   var mode=$("#mode").val();
		   var typeidNum=0;
							if(typeId=='DNI'){
								typeidNum = 1;
							}else{
								if(typeId=='CAREX'){
									typeidNum = 2;
								}else{
									if(typeId=='PASAP'){
										typeidNum = 3;
									}	
								}
							}
							
			$.ajax({
							type:"post",
							url:"portal_page.html",
							data:"firstname="+firstname+"&lastname="+lastname+"&maidenname="+maidenname+"&email="+email+
							"&phone="+phone+"&country="+country+"&city="+city+"&address="+address+
							"&typeidNum="+typeidNum+"&numberid="+numberid+"&posAmount="+posAmount+
							"&t="+mode+"&m="+mail+"&clientId="+clientId+"&sessionId="+sessionId,
							dataType:"text",
							global: false, 
							async: false,
							success:function(e){
								if(e != null && e != ""){
								var redireccion = (e+"").toString();
								if(redireccion != null && redireccion != "")
								{
								pagoEfectivoF(redireccion);	}
							//	callReportCurrentAccount();
								}else{
									jAlert( "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
									}
							}
		
						});
	       
	    });
	
	$("#btncargar5").click(function(e) {
		 var posAmount=document.getElementById("safetypay-valor").value;
		 var clientId=$("#clientId").val();
		 var sessionId=$("#sesionId").val();
		 
		 var apikey=$("#apikey").val();
		 var merchantSalesID=$("#merchantSalesID").val();
		 var transactionOkURL=$("#transactionOkURL").val();
		 var transactionErrorURL=$("#transactionErrorURL").val();
		 var signature=$("#signature").val();
		 var createExpressToken=$("#createExpressToken").val();
		 
		 
			$.ajax({
				type:"post",
				url:"safety_page_post.html",
				data:"clientId="+clientId+"&sessionId="+sessionId+"&posAmount="+posAmount+"&apikey="+apikey
				+"&merchantSalesID="+merchantSalesID+"&transactionOkURL="+transactionOkURL+"&transactionErrorURL="+transactionErrorURL
				+"&signature="+signature+"&createExpressToken="+createExpressToken,
				dataType:"text",
				global: false, 
				async: false,
				success:function(e){
					if(e != null && e != ""){
					var redireccion = (e+"").toString();
					if(redireccion != null && redireccion != "")
					{
						safetyPay(redireccion);
					}
					//pagoEfectivoF(redireccion);	}
				//	callReportCurrentAccount();
					}else{
						jAlert( "Ha ocurrido un incidente inesperado. Vuelva a intentar en unos minutos", null);
						}
				}

			});
			
			
	    });
		
		*/
	 $('#tab-item_5').on('click', function () {
        var content = '<div class="ajax-loader"></div>' + '<div>' + '<div id="scroll-grid">' + '<div id="grilla"></div>' + '</div></div>' + '<div id="num_link_cc"></div>';
        $('.tab-intro').eq(4).html(content);
        $('.ajax-loader').show();
        $.ajax({type: 'POST', url: 'clientBalance_find_idClient.html', dataType: 'text', success: function (e) {
            $('.ajax-loader').hide();
            if (e != "") {
                var rowClientResult = e.split('#');
                for (var i in rowClientResult) {
                    var columnClientResult = (rowClientResult[i] + '').split('|');
                    var rows = [];
                    for (var j in columnClientResult) {
                        rows.push(columnClientResult[j])
                    }
                    dataClientResult.push(rows)
                }
                run.grilla(dataClientResult);
                run.grilla_paginada(dataClientResult);
                dataClientResult = []
            }            
        }})
    });
	
	function viewNext(){
		$('#password-client-header').val('');
    	$('#password-client').val('');
		$(".logout").show();
		$(".unlogout").hide();                    
		$("#payments_section").show();
		$('.font-play').css({"height":"487px"});
		$('.img_zona_segura').css({"height":"20px"});
		$('.img_zona_segura').css({"margin-top":"-8px"});
		$("#login_section").css("display","");
		$("#btn_finaliza_compra").show();
		$("#panel_finaliza_compra").show();
	}
});


function pagoEfectivoF(redireccion){
	$("#option-card-0").prop("checked", "checked");
	$("#panel_transaccion_1").hide();
    $("#panel_transaccion_2").hide();
    $("#panel_transaccion_3").hide()
	$("#panel_transaccion_4").hide();
	dhtmlwindow.open('resultbox', 'iframe',redireccion, 'PAGOEFECTIVO', 'width=615,height=539,scrolling=1,center=1,resize=0', 'recal')

}


function safetyPay(redireccion){
	dhtmlwindow.open('resultbox', 'iframe',redireccion, 'SAFETYPAY', 'width=963,height=670,scrolling=1,center=1,resize=0', 'recal')
	$('#resultbox').append("<a id='return-comerce' Style='position: absolute; margin-top: -86px; width: 120px; margin-left: 508px; cursor:alias;'></a>");
}