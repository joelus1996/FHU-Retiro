<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!-- <script type="text/javascript" src="layer-view-script/jquery-1.6.4.min.js"></script> -->
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/jquery-migrate-3.1.0.min.js"></script>
<script type="text/javascript" src="layer-view-script/v2/main.js?v=5"></script>
<script type="text/javascript" src="layer-view-script/lotto-mobile-1.0.js?v=<%=Constantes.lotto_mobile_1_0_js%>"></script>
<script type="text/javascript" src="layer-view-script/popModal.js?v=1"></script>
<script type="text/javascript" charset="UTF-8" src="layer-view-script/client/analytics.js?v=9"></script>
<!-- <script src="https://cdn.jsdelivr.net/jquery/3.2.1/jquery.min.js"></script> -->
<script>
$('.slide').on('click', function (event) {
	event.preventDefault();
	var _this = $(this);
	_this.find('.submenu').slideToggle();
});


$('#addSaldoW').on('click', function() {
	datalayerCargarSaldoW();
    $('#agregarSaldo').trigger('click');
});


$('#agregarSaldo').on('click', function () {
	
	let idAgregarSaldo = $(this).prop('id');
	
	// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
	// es una function que se realizará en caso no tenga docs pendientes de confirmacion
	mainValidatePendingsDocsForAproval('footerAgregarSaldo');
});

function footerAgregarSaldo(){
	validatePerfil("#agregarSaldo");
}

window.addEventListener("message", function(event) {
    if (event.data === "footerAgregarSaldo") {
       footerAgregarSaldo();
    }
});

function closeLightboxRechargeIlot(button){	
	$('body').css('overflow-y', 'scroll');
	$('body').find('#div-lightbox-recharge-ilot').remove();
	$('body').find('#cargando').remove();
	
	if (location.href.split("client_balance_bono_games_show_information").length > 1) {
		location.reload();
		return;
	}
	
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
}

function handleMessageWP(e) {
	if (typeof e.data.split !== "function") { 
	    return 0;
	}
	
	var arrayData = e.data.split("|");
	if(arrayData[0]==='getRedirect'){
		window.location.href = arrayData[1];
	} else if(arrayData[0]==='hideButtonClose'){
		$("#lightbox-recharge-ilot-close").trigger('click');
	} else if(arrayData[0]==='agregarSaldo'){
		agregarSaldoClick();
	}
}

$( document ).ready(function() {
	if ( window.addEventListener ) {
	    window.addEventListener('message', handleMessageWP, false);
	} else if ( window.attachEvent ) {
	    window.attachEvent('onmessage', handleMessageWP);
	}
});
</script>
<script type="text/javascript" src="layer-view-script/jquery.mobile-1.0.min.js"></script>
<script type="text/javascript">
 
//   var _gaq = _gaq || [];
//   _gaq.push(['_setAccount', 'UA-16525433-10']);
//   _gaq.push(['_setDomainName', 'intralot.com.pe']);
//   _gaq.push(['_trackPageview']);
 
//   (function() {
//     var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
//     ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
//     var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
//   })();

 
  
  
</script>
<%-- /*chatbot*/ --%>	
<!-- <script type="application/javascript" charset="UTF-8" src="https://cdn.agentbot.net/core/56512f807294eae4d4093733fc35cd13.js"></script> -->
<script type="text/javascript" src="layer-view-script/common/chatbot.js"></script>	
<%-- /*fin chatbot*/ --%>    