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
        url: "set-favorito-virtuales.html",
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

function ocultaSubtitulo(){
	$('#subtituloDeportes').hide();$('#subtituloInstantaneas').hide();$('#subtituloNumeros').hide();
}
ocultaSubtitulo();

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
	 $('#m-todos').removeClass("active");$('#m-favoritos').removeClass("active");$('#m-Deportes').removeClass("active");
	 $('#m-Instantaneas').removeClass("active");$('#m-Numeros').removeClass("active");
	 $('#m-masjugados').removeClass("active");
	 $('#m-favoritos .star-submenu').removeClass("star-on-submenu");
	 $('#m-favoritos .star-submenu').attr('src','layer-view-image/game/virtuales/icon_star_off_menu.svg');	 	
}

function actualizaFavoritos(){
	var item = '';
	$.ajax({ url: 'game_virtuales_favorite_product_list.html',
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
	ocultaSubtitulo();
	//desactivam();
	initSelectProvider(opcion);
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

function actualizaProveedor(tipo, prov){
	var itemJuegoGeneral = item = '';
	if(jsonProds == null) return ;	
	if (tipo == 'favoritos' || tipo == 'masjugados') return;
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
	
	gcategoria = tipo;ocultaSubtitulo();
	desactivam();
	$('#m-'+tipo).addClass("active");$('#subtitulo'+tipo).show();
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
	var item = overlay = botonJuego = franjaNuevo = class_favoritos_on = activo = '',display_none = 'display:none;';
	var src_star_off = 'src="layer-view-image/game/virtuales/icon_star_off.svg"';
	
	//es mayor a cero para marcar favoritos
	if( Object.keys(prodDisponibles).length > 0 ){// existe favoritos
		activo = prodDisponibles[val.gameproductid];
		if(activo == "1") class_favoritos_on = 'favoritos-on';	  		  			
		else class_favoritos_on = 'favoritos-off';				
	}else src_star_off = '';
	
	if( val.demolink === undefined ){
		overlay = 'sin-demo';
		botonJuego = '';
	} else{
		overlay = '';
		botonJuego += '<div class="back">';
		botonJuego += '	<div class="buttons">';
		if( val.provid == '2' ){//Leap
			botonJuego += '		<a class="btn btn--secondary" href="javascript:openGameLeap(\'' + val.gameproductid + '\',\'fun\')">Modo pr&aacute;ctica</a>';
			botonJuego += ' 	<a class="btn btn--primary" href="javascript:openGameLeap(\'' + val.gameproductid + '\',\'real\')">Juega y Gana</a>';
		}
		botonJuego += '	</div>';
		botonJuego += '</div>';
	}
	
	if( val.newtag == '1' ){
		if( val.provid != '2' ){//Leap
			franjaNuevo = '<div class="franjaNuevo" onclick="javascript:openGame(\'' + val.gameproductid + '\')" >Nuevo</div>';
		}else{
			franjaNuevo = '<div class="franjaNuevo">Nuevo</div>';
		}
	}
	
	item += '<li id="li-' + val.gameproductid + '" class="' + class_favoritos_on + ' animado">';
	item += franjaNuevo;
	item += '<div class="favoritos" onclick="setFavorito(\'' + val.gameproductid + '\')" ><div class="' + class_favoritos_on + '" id="img-favoritos' + val.gameproductid + '"   ' + src_star_off + ' ></div></div>';
	item += '<div class="raspaditaItem ' + overlay + '">';
	item += '	<h3 onclick="javascript:openGame(\'' + val.gameproductid + '\')" class="nombre">'+ val.name +'</h3>';
	item += '<a class="item-ddvv" href="javascript:openGame(\'' + val.gameproductid + '\')" ><div class="imgcore" style="' + display_none + 'background-image:url(\''+ val.image +'\')"></div></a>';
	item += botonJuego;
	item += '</div>';
	item += '</li>';

	return item;
}

$.ajax({ url: 'game_virtuales_product_list.html',
	type: 'get',
	dataType: 'json',
	success: function (response) {
		  	jsonProds = response;
		  	if(anuncioParam == null){ actualizaProveedor('todos','');initSelectProvider('todos');}
		  	else if(anuncioParam=='favoritos' || anuncioParam=='masjugados'){}
		  	else {actualizaProveedor(anuncioParam,'');initSelectProvider(anuncioParam);}
		  	mostrarScroll();
		  		
		}, error: function(e) {
		  	console.log('error obteniendo productos virtuales random...')
		}
});

//ajax para proveedores con orden fijo
$.ajax({ url: 'game_virtuales_product_list_order.html',
	type: 'get',
	dataType: 'json',
	success: function (response) {
			jsonProdsFix = response;			
	}, error: function(e) {
	  	console.log('error obteniendo productos virtuales orderfix...')
	}
});
//fin ajax proveedores orden fijo

function openGame(gameId) {
	if(anuncioParam != null )
		window.location.href="juega-virtuales.html?game=" + gameId + '&type=' + gcategoria;
	else
		window.location.href="juega-virtuales.html?game=" + gameId;
}

function openGameLeap(gameId,mode) {
	var game = gameId.split("-")[0];
	var default_sport = '';
	if(gameId.split("-").length == 2){
		default_sport = gameId.split("-")[1];
		window.location.href="juega-virtuales.html?game=" + game + '&mode=' + mode + '&default=' + default_sport  + '&type=' + gcategoria;
	}else{
		window.location.href="juega-virtuales.html?game=" + gameId + '&mode=' + mode  + '&type=' + gcategoria;
	}			
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

var idsession = $("#clientId").val();
if(idsession == ''){											
	//checkCount();						
}

$('.popup .js-close-modal-ddvv').click(function(event){
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
});
	
function actualizaMasJugados(){
	var item = '';
	$.ajax({ url: 'game_virtuales_most_played_list.html',
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