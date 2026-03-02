(function() {

	var bodyEl = document.body,
		content = document.querySelector( '.content-wrap' ),
		openbtn = document.getElementById( 'open-button' ),
		openbtncard = document.getElementById( 'open-button-card' ),
		closebtn = document.getElementById( 'close-button' ),
		isOpen = false;

	function init() {
		initEvents();
	}

	function initEvents() {
		if(openbtn!=undefined){
			openbtn.addEventListener( 'click', toggleMenu );
		}
		
		if(openbtncard!=undefined && openbtncard!=null) {
			openbtncard.addEventListener( 'click', toggleMenu );
		}
		
		if(closebtn!=undefined && closebtn ) {
			closebtn.addEventListener( 'click', toggleMenu );
		}

		// close the menu element if the target it´s not the menu element or one of its descendants..
		if(content!=undefined){
			content.addEventListener( 'click', function(ev) {
				var target = ev.target;
				if( isOpen && target !== openbtn && target !== openbtncard ) {
					toggleMenu();
				}
			} );
		}

	}

	function toggleMenu() {
		if( isOpen ) {
			$('body').removeClass('show-menu').removeClass('opened-menu');
		}
		else {
			$('body').addClass('show-menu');
			setTimeout(function(){
				$('body').addClass('opened-menu');
			}, 1000);
		}
		isOpen = !isOpen;
		$('#myCredit').hide();
		$('#myAbout').hide();
		$('body').removeClass('menu_active');
		$('.jsBtnIcon').removeClass('active');
	}

	init();

})();

$('.icon-list a').click(function(e){
	e.preventDefault();
});

$('.main-action a').click(function(e){
	e.preventDefault();
});

$('.main-brands a').click(function(e){
	e.preventDefault();
});

$('.game-option').click(function(e){
	e.preventDefault();
});

$('.tablink').click(function(event){
	event.preventDefault();
	$(".map-view").removeClass('actived');
	$(".tablink").removeClass('actived');
	$(this).addClass('actived');
	var id = $(this).attr('data-id');
	$("#"+id).addClass('actived');
});

$('.js-modal').click(function(event){
	event.preventDefault();
	// console.log($(this).data('modal'), 'modal');
	openModal($(this).data('modal'),"");
});

$('.popup .js-close-modal').click(function(event){
	event.preventDefault();
	closeModal(1);
});

$('.popup .js-back-modal').click(function(event){
	event.preventDefault();
	backModal();
});


//addfrank
$("#f_clean").click(function(){
  $(".box-checkbox").find("input").prop("checked",false);
  datalayerTinkaJugada(this,'Programa','Button','Jugar');
});
$("#f_azar").click(function(){
	var $item = $('.f_item');
	for (var i=0;i<$item.length;i++){
	  var $te = $item.eq(i);
	  var $boxinput = $te.find("input");	
	  if (!$te.hasClass('userChecked')) {
	  	$boxinput.prop("checked",false);
		var new_numb = Math.floor(Math.random() * 3);
		$boxinput.eq(new_numb).prop("checked",true);		
	  }	  
	}
	taggingClickAzar();
	datalayerTinkaJugada(this,'Programa','Button','Jugar');
});

let heigh_body = $(window).height()-92;
let cuarto_body = (heigh_body/4)-50;

$('.main-home .main-brands .main-brand').height(cuarto_body+'px');
$('.jsBtnIcon').click(function(e){
	e.preventDefault();
	let $this = $(this);
	let id = $this.attr('href');	
	//let clicks = $this.data('clicks');
	if ($this.hasClass('active')) {
	    $('.jsBtnIcon').removeClass('active');
		$('.menu-not-wrap').hide();
		$('body').removeClass('menu_active');
	} else {
	    $('.jsBtnIcon').removeClass('active');
		$this.addClass('active');
		$('.menu-not-wrap').hide();
		$(id).show();
		$('body').addClass('menu_active');
	}
	//$this.data("clicks", !clicks);
});
$('.close-menu-not-wrap').click(function(e){
	e.preventDefault();
	$('.jsBtnIcon').removeClass('active');
	$('.menu-not-wrap').hide();
	$('body').removeClass('menu_active');
});


function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

function closeModal(state) {
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
	if(state!=undefined &&  control!=undefined && control.length>0 && control=='btn_mobile_home' && state!=null && state==1) {
		window.location.href = 'home.html';
		//$("#"+control).trigger("click");
		control = "";
	}
}

function backModal() {
	if($('#popup .wrap-modal').length>0) {
		$('#popup .main-modal').removeClass('hide');
		$('#popup .js-close-modal').removeClass('hide');
		$('#popup .wrap-modal').addClass('hide');
		$('#popup .js-back-modal').addClass('hide');
	}
}

function openLoader() {
	$('#loading').addClass('showed');
}

function closeLoader() {
	$('#loading').removeClass('showed');
}

var numberPattern = /\d+/g;
var yapaPattern = /Boliyapa\:\s(\d+$)/;
var control="";

function replacehtml(from, to, regex) {
	if ($(from).length) {
		var html = "";
		var r = $(from).text().split(regex);
		if(from=='#siosi1' && r.length>0){
			html='<img id="siosi-img" class="siosi-img" src="layer-view-image/game/tinka/siosi-tinka.png" style="height:40px; margin: 0px 5px 5px 0px;"/>';
		}
		for (var i = 0; i < r.length; i++) {
			html += '<div class="result-ball">\
						<div class="ball">\
							<span>' + r[i].match( numberPattern )[0] + '</span>\
						</div>\
					</div> '
		}
		var game = $(from).data('game');
		if (game == 'tinka' && from!='#siosi1') {
			var m = $(from).html().match(yapaPattern);
			html += '<div class="result-ball special-ball">\
						<div class="ball">\
							<span>' + m[1] + '</span>\
						</div>\
					</div>'
		}
		$(to).html(html);
	}
}

function replacematch(from) {
	if ($(from).length) {
		$(from).html( $(from).html().split(' ')[0] );
	}
}

function createBanner(banners, to) {
	var html = "";
	for (var i = 0; i < banners.length; i++) {
		var url_jpg = "",
			url_destino = "";
		if (banners[i].getElementsByTagName("hora")[0]) {
			hora = banners[i].getElementsByTagName("hora")[0].childNodes[0].nodeValue;
		}
		if (banners[i].getElementsByTagName("url-jpg")[0]) {
			url_jpg = banners[i].getElementsByTagName("url-jpg")[0].childNodes[0].nodeValue;
		}
		if (banners[i].getElementsByTagName("url-destino")[0]) {
			url_destino = banners[i].getElementsByTagName("url-destino")[0].childNodes[0].nodeValue;
		}
		html += '<div class="swiper-slide"><article>';
		if(to.substr(0, 8)=="#bannerp") html += '<a href="#" onclick="toLaPolla();"><img src="' + url_jpg + '" /></a>';
		else html += '<a target="_blank" href="' + url_destino + '"><img src="' + url_jpg + '" /></a>';
		html += '</article></div>';
		/*html += '<div class="swiper-slide">\
            		<article>\
						<a target="_blank" href="' + url_destino + '"><img src="' + url_jpg + '" /></a>\
	        		</article>\
	        	</div>';*/

	}
	$(to).html(html)
}

function registrarReclamacion(form){
	if($("#formBook").valid()){
		  $.ajax({
              url: 'registrarReclamacion.html',
              data: $("#formBook").serialize(),
              type: 'POST',
              dataType: 'json',
              beforeSend: function () {
            	  $('body').append('<i id="cargando" class="loading" style="z-index: 2147483648 !important;"></i>');
              },
              error: function () {
            	  $('body').find('#cargando').remove();
            	  alertMessage('¡Ocurrió un problema inesperado! \nPor favor inténtelo nuevamente.');
              },
              success: function (data) {
            	  $('body').find('#cargando').remove();
            	  if(data.message==="OK"){
            		  $("#secuencia").val(data.secuencia);
            		  $("#fecha").val(data.fecha);
            		  form.submit();
            	  }else{
            		  alertMessage(data.error);
            	  }
              }
		  });
	}
}

function alertMessage(e){
	$("#alertModal_content_id").html(e);
    $("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: function(event, el) {} });
}
