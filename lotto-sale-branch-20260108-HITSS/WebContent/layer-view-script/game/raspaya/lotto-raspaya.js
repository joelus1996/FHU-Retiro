var jsonProds;
var jsonProdsFix;
var gcategoria = '';

var selectProvider = [];

function refreshScroll(){
	var t = document.documentElement.scrollTop;document.documentElement.scrollTop = t + 1;document.documentElement.scrollTop = t;
}

function accionfavoritos(flagDelete, gameId){
	switch (flagDelete) {    	 
		case false	: 
			$("#img-favoritos"+gameId).removeClass("favoritos-off");
    		$("#img-favoritos"+gameId).addClass("favoritos-on");
			$("#li-"+gameId).addClass("favoritos-on");
			$("#div-nombre-"+gameId).addClass("favoritos-on");
			prodDisponibles[gameId] = 1;
			break;    	 
		case true	: 
			$("#img-favoritos"+gameId).removeClass("favoritos-on");
			$("#li-"+gameId).removeClass("favoritos-on");
			$("#div-nombre-"+gameId).removeClass("favoritos-on");
			$("#img-favoritos"+gameId).addClass("favoritos-off");
			delete prodDisponibles[gameId];
			break;		  
	} 
}

function setFavorito(gameId){
	var idsession = $("#clientId").val();
	if(idsession == '') return ;
	flagDelete = $("#img-favoritos"+gameId).hasClass("favoritos-on");
	accionfavoritos(flagDelete, gameId);
	$.ajax({
		type: "post",
        url: "set-favorito-raspaya.html",
        data: "flagDelete=" + flagDelete + "&productId=" + gameId,
        async:false,
        dataType: "json",
        success: function (e) {
        	if(e.status===0) {//0=falla
        		accionfavoritos(flagDelete, gameId);
        	}
        } 
    });
	if (gcategoria=='favoritos') actualizaFavoritos();
}

$(document).ready(function(){

  //a partir de que punto del scroll vertical de la ventana mostrará el botón
   const ishow = 115
   const $divtop = document.getElementById("div-totop")
   window.addEventListener("scroll", function() {
	   if(document.documentElement.scrollTop > ishow) $divtop.style.opacity = "1";
       else $divtop.style.opacity = "0"; 
   });

   function fn_goup(){
       window.scrollTo(0, 0)
   }
   
   $('.cmn-btncircle').click(function(){
       var link = $(this);
       var anchor  = link.attr('href');
       $('html, body').stop().animate({
           scrollTop: jQuery(anchor).offset().top
       }, 400);
       return false;
   });
   
   $("#buscador").on("keyup", function() {
		var value = $(this).val().toLowerCase();  	    
 	    desactivam();
     	$('#m-todos').addClass("active");
     	gcategoria = 'todos';
     	initSelectProvider('todos');
     	actualizaProveedorJuego(value);
     	refreshScroll();
 	  });
});

$(".btnLupa").click(function () {
	$('#buscador').focus().trigger({ type : 'keyup', which : 13 });
});

let animado = document.querySelectorAll(".animado");

function mostrarScroll(){
	animado = document.querySelectorAll(".animado");
	let scrollTop = document.documentElement.scrollTop;
	for(var i = 0; i < animado.length; i++){
		let alturaAnimado = animado[i].offsetTop;    		
		if(alturaAnimado - $(window).height() + 130  < scrollTop){
			animado[i].style.opacity = 1;
			animado[i].querySelectorAll(".imgcore")[0].style.display = 'initial';
		}
	}
} 

window.addEventListener('scroll', mostrarScroll);

$('#sproveedor').multiselect({
	buttonWidth: '186px',
	numberDisplayed: 14,
	maxHeight: 200,
	nonSelectedText: ' Proveedores ',
    includeSelectAllOption: true,
    allSelectedText: " Todos",
	templates: {	
		button: '<button id="multiselectid" type="button" class="multiselect" data-toggle="dropdown"><span class="multiselect-selected-text"></span> &nbsp;<b class="fa fa-caret-down" style="float: right;margin-top: 3px;"></b></button>'
	},
	selectAllText: ' Todos',
	nSelectedText: 'Proveedores seleccionados',
	buttonText: function(options, select) {
		if (options.length == 0) {
        	//console.log('cero');
        	return this.nonSelectedText ;
        }
        else {
          if(options.length == select[0].length){
        	return 'Proveedores: Todos' ;
          }	
          if (options.length <= this.numberDisplayed) {
            return 'Proveedores: (' + options.length + ')';// + this.nSelectedText ;
          }
        }
      },
      onChange: function(option, checked) {
          //alert(option.length + ' options ' + (checked ? 'selected' : 'deselected'));
    	  var sprov = '';
    	  $('#sproveedor option:selected').each(function() {
	          sprov += $(this).val() + ',';        		  
	      });
    	  if(sprov == ''){
			  actualizaProveedor(gcategoria,'');
    	  }else{
        	  if(gcategoria == 'todos') actualizaProveedor(gcategoria,sprov);
        	  else actualizaProveedorCat(gcategoria,sprov);
        	  actualizaProveedorCat('scratch',sprov);//se fuerza a este filtro
    	  }
    	  refreshScroll();        	  
      },
      onSelectAll: function() {
          //alert('onSelectAll triggered!');
    	  actualizaProveedor(gcategoria,'');
          refreshScroll();
      },
      onDeselectAll: function() {
          //alert('onDeselectAll triggered!');
    	  actualizaProveedor(gcategoria,'');
    	  refreshScroll();
      },
      onInitialized: function(select, container) {
    	  //customCheck();        	  
      },
      onDropdownShow: function(event) {
    	  $('.btn-group .dropdown-menu').show();
      },
});

function customCheck(){
    var textinputs =  document.querySelectorAll("input[type=checkbox]");
  	$('input[type="checkbox"]').each(function(i, v) {
  	     $(this).attr("id", ("checkbox_" + i))
  	     $(this).after($("<label>").attr("for", $(this).attr("id")));	     
  	});
}

function initSelectProvider(type){
	selectProvider = [];
	$('#sproveedor').empty();
	if (type == 'favoritos' || type == 'masjugados') {
		
	}else{
		for (const [key, value] of Object.entries(aCategoryProviders[type])) {
			selectProvider.push({
			    label:   aMasterProv[value],
			    value: value
			});
		}    	
		$("#sproveedor").multiselect('dataprovider', selectProvider);
		customCheck();
	}
}

var urlParams = new URLSearchParams(location.search);
var anuncioParam = urlParams.get('type');
juegos(anuncioParam);
if(anuncioParam == null) initSelectProvider('todos');

function desactivam(){
	 $('#m-todos').removeClass("active");$('#m-favoritos').removeClass("active");
	 $('#m-favoritos .star-submenu').removeClass("star-on-submenu");
	 $('#m-masjugados').removeClass("active");
	 $('#m-favoritos .star-submenu').attr('src','layer-view-image/game/virtuales/icon_star_off_menu.svg');	 	
}

function actualizaFavoritos(){
	var item = '';
	$.ajax({ url: 'game_raspaya_favorite_product_list.html',
		type: 'get',
		dataType: 'json',
		success: function (response) {
			listaDetalle = response;
			for(var i = 0; i < listaDetalle.length; i++) {	
				var val = listaDetalle[i];
				item += armaItemJuego(val);
			}		    			
			$('#listaGeneral').html('');$('#listaGeneral').append(item);
			refreshScroll();
		},
		error: function (e) {
			console.log(e);
		}		
	});
 }

function juegos(opcion){
	$('#listaGeneral').html('');
	$('.col-md-8-proveedor').show();
	if(opcion==null) opcion = 'todos'; 
	gcategoria = opcion;
	//desactivam();
	initSelectProvider(opcion);
	$('#buscador').val('');
	$('#subtitulo'+opcion).show();
	switch (opcion) {    	
    	case "todos":
    	 	//$('#buscador').trigger({ type : 'keyup', which : 13 });
			break;    	 
    	case "masjugados": 
    		$('#buscador').val('');
    		$('.col-md-8-proveedor').hide();
    		$('#games').css('margin-top', '12px');
    		desactivam();
    		$('#m-masjugados').addClass("active");
    		actualizaMasJugados();
    		break;
    	case "favoritos": 
    		$('#buscador').val('');
    		$('.col-md-8-proveedor').hide();
    		$('#games').css('margin-top', '12px');
    		desactivam();
    		$('#m-favoritos').addClass("active");$('#m-favoritos .star-submenu').addClass("star-on-submenu");
    		$('#m-favoritos .star-submenu').attr('src','layer-view-image/game/virtuales/icon_star_on.svg');
    		actualizaFavoritos();
    		return ;
        	break;
	}
	if (opcion != 'favoritos' && opcion != 'masjugados') {
		actualizaProveedor(opcion,'');
	}	
	mostrarScroll();
 }

function actualizaProveedorJuego(nombre){//casilla de busqueda por nombre
	var itemJuegoGeneral = item = '';
	if(jsonProds == null) return ;
	if (tipo == 'favoritos' || tipo == 'masjugados') return;
	for(var i = 0; i < jsonProds.length; i++) {	
		var val = jsonProds[i];			
		item = armaItemJuego(val);
		if(val.title.toLowerCase().indexOf(nombre.toLowerCase()) > -1) itemJuegoGeneral += item;
	}		
	$('#listaGeneral').html('');$('#listaGeneral').append(itemJuegoGeneral);		
}

function actualizaProveedor(tipo, prov){
	var itemJuegoGeneral = item = '';
	if(jsonProds == null) return ;			  	
	for(var i = 0; i < jsonProds.length; i++) {	
		var val = jsonProds[i];
		item = armaItemJuego(val);
		if(prov == ''){
			if(tipo == 'todos') itemJuegoGeneral += item;
			else if(tipo.includes(val.type)) itemJuegoGeneral += item;
		}else{
			if(prov.includes(val.provid)) itemJuegoGeneral += item;				
		}
	}	
	$('#listaGeneral').html('');$('#listaGeneral').append(itemJuegoGeneral);
	
	gcategoria = tipo;
	desactivam();
	$('#m-'+tipo).addClass("active");
}

function actualizaProveedorCat(tipo, prov){//combo multiselect
	var itemJuegoGeneral = item = '';
	if(jsonProdsFix == null) return ;			  		
	for(var i = 0; i < jsonProdsFix.length; i++) {	
		var val = jsonProdsFix[i];
		item = armaItemJuego(val);
		if(tipo.includes(val.type) && prov.includes(val.provid)) itemJuegoGeneral += item;
	}		
	$('#listaGeneral').html('');$('#listaGeneral').append(itemJuegoGeneral);		
}
	
function armaItemJuego(val){
	var imgcore = item = overlay = botonJuego = franjaNuevo = class_favoritos_on = activo = '',display_none = 'display:none;';
	var src_star_off = 'src="layer-view-image/game/virtuales/icon_star_off.svg"';
	
	//es mayor a cero para marcar favoritos
	if( Object.keys(prodDisponibles).length > 0 ){// existe favoritos
		activo = prodDisponibles[val.gameproductid];
		if(activo == "1") class_favoritos_on = 'favoritos-on';	  		  			
		else class_favoritos_on = 'favoritos-off';				
	}else src_star_off = '';
	
	if( val.mainprovider === 'QTECH' ){
		overlay = 'sin-demo';
		botonJuego = '';
		jackpot = '<div class="jackpot" onclick="javascript:openGameQTech(\'' + val.gameproductid + '\',\'' + val.type + '\',\'' + val.mainprovider + '\')" >' + val.pozo + '</div>';
		imgcore = 'imgcore';
	} else{//HASCKSAW
		overlay = '';
		botonJuego += '<div class="back">';
		botonJuego += '	<div class="buttons">';
		//if( val.provid == '2' ){//Leap
		botonJuego += '		<a class="btn btn--secondary" href="javascript:openGameHacksaw(\'' + val.gameproductid + '\',\'demo\')">Modo pr&aacute;ctica</a>';
		botonJuego += ' 	<a class="btn btn--primary" href="javascript:openGameHacksaw(\'' + val.gameproductid + '\',\'live\')">Juega y Gana</a>';
		//}
		botonJuego += '	</div>';
		botonJuego += '</div>';
		imgcore = 'imgcoreH';
		jackpot = '<div class="jackpotH" >' + val.pozo + '</div>';
		
	}
	
	if( val.newtag == '1' ){
		if( val.mainprovider === 'QTECH' ){
			franjaNuevo = '<div class="franjaNuevo" onclick="javascript:openGameQTech(\'' + val.gameproductid + '\')" >Nuevo</div>';
		}else{
			franjaNuevo = '<div class="franjaNuevo">Nuevo</div>';
		}
	}
	
	item += '<li id="li-' + val.gameproductid + '" class="' + class_favoritos_on + ' animado">';
	item += franjaNuevo;	
	item += '<div class="favoritos" onclick="setFavorito(\'' + val.gameproductid + '\')" ><div class="' + class_favoritos_on + '" id="img-favoritos' + val.gameproductid + '"   ' + src_star_off + ' ></div></div>';
	item += '<div class="raspaditaItem ' + overlay + '">';
	item += jackpot;
	item += '	<h3 onclick="javascript:openGame(\'' + val.gameproductid + '\')" class="nombre">'+ val.title +'</h3>';
	item += '<a class="item-ddvv" href="javascript:openGameQTech(\'' + val.gameproductid + '\',\'' + val.type + '\',\'' + val.mainprovider + '\')" ><div class="imgcore ' + imgcore + '" style="' + display_none + 'background-image:url(\''+ val.image +'\')"></div></a>';
	item += botonJuego;
	item += '</div>';
	item += '</li>';

	return item;
}

$.ajax({ url: 'game_raspaya_product_list.html',
	type: 'get',
	dataType: 'json',
	success: function (response) {
		  	jsonProds = response;
		  	if(anuncioParam == null){ actualizaProveedor('todos','');initSelectProvider('todos');}
		  	else if(anuncioParam=='favoritos' || anuncioParam=='masjugados'){}
		  	else {actualizaProveedor(anuncioParam,'');initSelectProvider(anuncioParam);}
		  	mostrarScroll();
		  		
		}, error: function(e) {
		  	console.log('error obteniendo productos raspaya random...')
		}
});

//ajax para proveedores con orden fijo
$.ajax({ url: 'game_raspaya_product_list_order.html',
	type: 'get',
	dataType: 'json',
	success: function (response) {
			jsonProdsFix = response;			
	}, error: function(e) {
	  	console.log('error obteniendo productos raspaya orderfix...')
	}
});
//fin ajax proveedores orden fijo

function openGameQTech(gameId, type, mainp) {
	url = "";
	$("div .box-main-game-alert-iivv").remove();
	$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
	$('body').css('overflow-y', 'hidden');
	
	$.ajax({
        type: 'POST',
        url: 'getLobbyRaspaya.html',
        dataType: 'text',
        data: "game=" + gameId + "&category=" + type + "&mainp=" + mainp,
        success: function (e) {
            if (e != "")  url = $.trim((e + "").toString());                   
            
        	if(url != "-" && url != "" && url != "sinSesion"){
    			$('body').append('<div id="div-lightbox-recharge-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 2147483000;overflow: auto;"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlotF();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" scrolling="no" frameborder="0" onload="retirar_loading();" src="open-raspaya.html?url=' + url + '" class="lightbox-recharge" ></iframe></div>');
    			$("#frmLightboxRecharge").attr('style', 'height:100%');				
    		}else{
    			closeLightboxRechargeIlotF();
    			var a = "";        				
    			if(url == "sinSesion") a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Debes iniciar sesión para jugar</p></div>';
    			else a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Juego no disponible, elegir otro</p></div>';	        			
    			$("div .main-panel").prepend(a);
    		}
        }
    });		
 }

function openGameHacksaw(game, mode) {
	url = "";
	$("div .box-main-game-alert-iivv").remove();
	$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
	$('body').css('overflow-y', 'hidden');
	
	$.ajax({
        type: 'POST',
        url: 'getLobbyRaspaya.html',
        dataType: 'text',
        data: "gameHacksaw=" + game + "&mode=" + mode,
        success: function (e) {
            if (e != "")  url = $.trim((e + "").toString());                                   
        	
            if(url != "" && url != "sinSesion"){
    			$('body').append('<div id="div-lightbox-recharge-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 2147483000;overflow: auto;"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlotF();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" scrolling="no" frameborder="0" onload="retirar_loading();" src="open-raspaya-hacksaw.html?game=' + url + '&mode=' + mode + '" class="lightbox-recharge" ></iframe></div>');
    			$("#frmLightboxRecharge").attr('style', 'height:100%');				
    		}else{
    			closeLightboxRechargeIlotF();
    			var a = "";
    			if(url == "sinSesion") a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Debes iniciar sesión para jugar</p></div>';
    			else a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Juego no disponible, elegir otro</p></div>';
    			$("div .main-panel").prepend(a);
    		}
        }
    });		
 }

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

$('.popup .js-close-modal-ddvv').click(function(event){
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
});
	
function actualizaMasJugados(){
	var item = '';
	$.ajax({ url: 'game_raspaya_most_played_list.html',
		type: 'get',
		dataType: 'json',
		success: function (response) {
			listaDetalle = response;
			for(var i = 0; i < listaDetalle.length; i++) {	
				var val = listaDetalle[i];
				item += armaItemJuego(val);
			}		    			
			$('#listaGeneral').html('');$('#listaGeneral').append(item);
			refreshScroll();
		},
		error: function (e) {
			console.log(e);
		}		
	});
 }