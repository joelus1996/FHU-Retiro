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
	}
});	

$(function(){
    $('a[href*=#]').click(function() {			
     if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'')
        && location.hostname == this.hostname) {
            var $target = $(this.hash);
            $target = $target.length && $target || $('[name=' + this.hash.slice(1) +']');
            if ($target.length) {
                var targetOffset = $target.offset().top;
                $('html,body').animate({scrollTop: targetOffset}, 1000);
                return false;
           }
      }
  });
});

refresh();

$(window).bind("resize", function(){
    refresh();
});

function refresh(){
	var viewportHeight = $('.popup-virtuales-game').outerHeight() - $('.headerddvv').outerHeight();
	$('#game').css({ height: viewportHeight });
}

function regresar(){
	if(anuncioParam != null )
		window.location.href="game_virtuales_show_home.html?type=" + anuncioParam;
	else
		window.location.href="game_virtuales_show_home.html";
}
var urlParams = new URLSearchParams(location.search);
var anuncioParam = urlParams.get('type');