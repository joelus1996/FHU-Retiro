$(document).ready(function(){
    var buttonlogin = $('#loginButton');
    var boxlogin = $('#loginBox');
    var formlogin = $('.js-form-login');
    buttonlogin.removeAttr('href');
    buttonlogin.on('click',function() {
        boxlogin.toggle();
        buttonlogin.toggleClass('active');
    });
    formlogin.mouseup(function() { 
        return false;
    });
    
   
    
    var buttonuser = $('#userButton');
    var boxuser = $('#userBox');
    var formuser = $('.js-list-user');
    buttonuser.removeAttr('href');
    buttonuser.mouseup(function(login) {
        boxuser.toggle();
        buttonuser.toggleClass('active');
    });
    formuser.mouseup(function() { 
        return false;
    });

    /*$(this).mouseup(function(login) {
        if(!($(login.target).parent('#loginButton').length > 0)) {
            buttonlogin.removeClass('active');
            boxlogin.hide();
        }
        if(!($(login.target).parent('.user-data').length > 0) && !($(login.target).parent('#userButton').length > 0)) {
            buttonuser.removeClass('active');
            boxuser.hide();
        }
    });*/

    // Main Games
    $('.box-current-game').on('click', function(e){
        e.preventDefault();
        $('.box-current-game').removeClass('game-playing');
        $(this).addClass('game-playing');
        var game = $(this).data('game');

        $('.box-play-main').hide();
        $('.box-play-'+game).show();

        //
        $('input[name="J1check"]:checkbox:checked').length > 0 ? $('div[data-game="a"]').addClass('game-played') : '';
        $('input[name="J2check"]:checkbox:checked').length > 0 ? $('div[data-game="b"]').addClass('game-played') : '';
        $('input[name="J3check"]:checkbox:checked').length > 0 ? $('div[data-game="c"]').addClass('game-played') : '';
        $('input[name="J4check"]:checkbox:checked').length > 0 ? $('div[data-game="d"]').addClass('game-played') : '';
        
        if( zonaUpdate('Zona') != 'Gana Gol')
        datalayerFinalizaCompra1(this,'Marcar jugada');
    
    });

    $(".main-content").on('click', '.js-terms', function(e){
        e.preventDefault();
        dhtmlwindow.open('resultbox', 'iframe', 'term_condiciones.html', 'TÉRMINOS Y CONDICIONES', 'width=606,height=460,scrolling=1,center=1,resize=0', 'recal');
    });

});

var days = ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"];
// var monthNames = ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set", "Oct", "Nov", "Dic"];
var monthNames = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"];

function printBalls(balls, to) {
    var html = "";
    for (var i = 0; i < balls.length; i++) {
    	var special=''
    	if(i>5 && to!='#siosi-balls'){
            special='special';
            }
        html += '<div class="result-ball ' + special + '">\
                    <div class="ball"><span>' + balls[i] + '</span></div>\
                </div> '
    }
    $(to).html(html);
}

function printDate(date, to) {
    var date = date.split("/");
    var datelocale = new Date(date[1] + "/" + date[0] + "/" + date[2]);
    $(to).html( days[datelocale.getDay()] + ' ' + (datelocale.getDate() < 10 ? '0' + datelocale.getDate() : datelocale.getDate()) + ' de ' + monthNames[datelocale.getMonth()] + ' ' + datelocale.getFullYear());
}

function openDivLayer(a,b,c,d,e){
    //console.log("a="a+" b="+b+" c="+c+" d="+d+" e="+e);
	var url;
	if(a=="resultados" || a=="ggresultados"){
		$.ajax({ 
            type: "post", 
            url: "resultados_juego.html", 
            dataType: "json", 
            data: "game="+b,
            global: false,
            async: false,
            success: function (e) {
            	url=e.url;
            }});
	} else url = c;
    var f=document.getElementById("generic-div-layer"),g=document.getElementById("generic-iframe");if(f!=null&&g!=null){g.src=url;g.width=d;g.height=e;f.className="div-layer div-layer-"+a;if(b!=null)f.className=f.className+" div-layer-"+a+"-"+b;f.style.display="block"}
}

function closeDivLayer(){
    var a=document.getElementById("generic-div-layer"),b=document.getElementById("generic-iframe");if(a!=null&&b!=null){b.src="";b.width=0;b.height=0;a.className="div-layer";a.style.display="none"}
}

function openTANwindows(url1, couponId){
    var url;
    var tan;
	$.ajax({ 
        type: "post", 
        url: "detalle_ticket.html", 
        dataType: "json", 
        data: "couponId="+couponId,
        global: false,
        async: false,
        success: function (e) {
        	url=e.url;
        	tan=e.tan;
        }});
	
	if(tan=='true'){
		dhtmlwindow.open("resultbox", "iframe", url, "boleto Te Apuesto" , "width=980,height=470,scrolling=1,center=1,resize=1", "recal");
	}else{
		dhtmlwindow.open("resultbox", "iframe", url1, "boleto Te Apuesto" , "width=980,height=470,scrolling=1,center=1,resize=1", "recal");
	}
    //var f=document.getElementById("generic-div-layer"),g=document.getElementById("generic-iframe");if(f!=null&&g!=null){g.src=url;g.width=d;g.height=e;f.className="div-layer div-layer-"+a;if(b!=null)f.className=f.className+" div-layer-"+a+"-"+b;f.style.display="block"}
	
}

function openTANovusWindows(url1, couponId){
	var gameId = 7;
    var url;
    var tan;
	$.ajax({ 
        type: "post", 
        url: "detalle_ticket_tanovus.html", 
        dataType: "json", 
        data: "couponId="+couponId + "&gameId="+gameId ,
        global: false,
        async: false,
        success: function (e) {
        	url=e.url;
        	tan=e.tan;
        }});
	
	if(tan=='true'){
		dhtmlwindow.open("resultbox", "iframe", url, "boleto Te Apuesto" , "width=980,height=470,scrolling=1,center=1,resize=1", "recal");
	}else{
		dhtmlwindow.open("resultbox", "iframe", url1, "boleto Te Apuesto" , "width=980,height=470,scrolling=1,center=1,resize=1", "recal");
	}
    //var f=document.getElementById("generic-div-layer"),g=document.getElementById("generic-iframe");if(f!=null&&g!=null){g.src=url;g.width=d;g.height=e;f.className="div-layer div-layer-"+a;if(b!=null)f.className=f.className+" div-layer-"+a+"-"+b;f.style.display="block"}
	
}

function openVIRTwindows(url1, couponId){
    var url;
    var tan;
    console.log('deportes virtuales id--> '+couponId);
    dhtmlwindow.open("resultbox", "iframe", "detalle_virtuales_ticket.html?couponId=" + couponId , "BOLETO DE DEPORTES VIRTUALES" , "width=1023,height=470,scrolling=1,center=1,resize=1", "recal");

}
