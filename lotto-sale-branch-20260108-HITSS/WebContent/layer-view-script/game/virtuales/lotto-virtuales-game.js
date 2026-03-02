$(document).ready(function(){

	  //a partir de que punto del scroll vertical de la ventana mostrará el botón
       const ishow = 115
       const $divtop = document.getElementById("div-totop")
       window.addEventListener("scroll", function() {
           if(document.documentElement.scrollTop > ishow){
               $divtop.style.opacity = "1"
           }
           else {
               $divtop.style.opacity = "0"
           }
       });

       function fn_goup(){
           window.scrollTo(0, 0)
       }
       
  	});

//postMessage de Xpress/GoldenRace		
var eventMethod = window.addEventListener ? "addEventListener" : "attachEvent";
var eventer = window[eventMethod];
var messageEvent = eventMethod === "attachEvent" ? "onessage" : "message";

eventer(messageEvent, function (e){
	switch (e.data.action) {
		case "game.resize.height":
			document.getElementById("game").style.height = e.data.value;
			break;
		case "game.balance.changed":
			console.log('entra a game.balance.changed refresh saldo');
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
			break;
		case "game.get.clientrect":
            // iframe selector.
            e.source.postMessage({action: "game.clientrect", value: document.getElementById("game").getBoundingClientRect()}, '*');
            break;
        case "game.get.clientheight":
            // iframe selector.
            e.source.postMessage({action: "game.clientheight", value: document.getElementById("game").offsetHeight}, '*');
            break;
        case "game.get.innerheight":
            // general window selector.
            e.source.postMessage({action: "game.innerheight", value: window.innerHeight}, '*');
            break;
        case "game.cycle.end":
            // Ticket placed
        	setTimeout(function(){
        		$(".cmn-btncircle")[0].click();
            }, 2500);
        	break;    
	}
});

function regresar(){
	if(anuncioParam != null )
		window.location.href="juega-virtuales.html?type=" + anuncioParam;
	else
		window.location.href="juega-virtuales.html";
}
var urlParams = new URLSearchParams(location.search);
var anuncioParam = urlParams.get('type');
