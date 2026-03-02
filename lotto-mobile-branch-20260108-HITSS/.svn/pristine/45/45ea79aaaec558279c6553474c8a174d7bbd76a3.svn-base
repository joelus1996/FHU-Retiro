var jsonProds;
var jsonProdsFix;
var gcategoria = '';

var selectProvider = [];

function refreshScroll(){
	var t = document.documentElement.scrollTop;document.documentElement.scrollTop = t + 1;document.documentElement.scrollTop = t;
}

$(".close_f").on("click",function(){
	$(".f_error_mensaje").hide();			
});

function botonJuegoLeap(gameId){
	var dataGameId = gameId;
	$(document).ready(function() {
		$('.nombreJuego').html('');
		$('.nombreJuego').append($("#a-item-"+dataGameId).attr("data-game"));
		if( dataGameId != "undefined"){
			var game = gameId.split("-")[0];
			var default_sport = '';
			if(gameId.split("-").length == 2) default_sport = '&default=' + gameId.split("-")[1];							
			$("#btnDemo").attr("data-href","game_virtuales_show_home.html?game="+ game +"&mode=fun" + default_sport + '&type=' + gcategoria);
			$("#btnJuega").attr("data-href","game_virtuales_show_home.html?game="+ game +"&mode=real" + default_sport + '&type=' + gcategoria);
			$('#popup1').addClass('opened');
		}		
	});  
}

function accionfavoritos(flagDelete, gameId){
	switch (flagDelete) {    	 
		case false	: 
			$("#img-favoritos"+gameId).removeClass("div-favoritos-off");
    		$("#img-favoritos"+gameId).addClass("div-favoritos-on");
			$("#li-"+gameId).addClass("favoritos-on");
			$("#div-nombre-"+gameId).addClass("favoritos-on");
			prodDisponibles[gameId] = 1;
			break;    	 
		case true	: 
			$("#img-favoritos"+gameId).removeClass("div-favoritos-on");
			$("#li-"+gameId).removeClass("favoritos-on");
			$("#div-nombre-"+gameId).removeClass("favoritos-on");
			$("#img-favoritos"+gameId).addClass("div-favoritos-off");
			delete prodDisponibles[gameId];
			break;		  
	} 
}

function setFavorito(gameId){
	var idsession = $("#clientId").val();
	if(idsession == '') return ;
	flagDelete = $("#img-favoritos"+gameId).hasClass("div-favoritos-on");
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
    
    $(".casino-overlay").on("click",function(){
		var $this = $(this);
		var dataGame = $this.attr("data-game");
		var dataGameId = $this.attr("data-gameId");
		$('.nombreJuego').html('');
		$('.nombreJuego').append(dataGame);		
		if( dataGameId != undefined){
			var game = gameId.split("-")[0];
			var default_sport = '';
			if(gameId.split("-").length == 2) default_sport = '&default=' + gameId.split("-")[1];							
			$("#btnDemo").attr("data-href","game_virtuales_show_home.html?game="+ game +"&mode=fun" + default_sport + '&type=' + gcategoria);
			$("#btnJuega").attr("data-href","game_virtuales_show_home.html?game="+ game +"&mode=real" + default_sport + '&type=' + gcategoria);
			$('#popup1').addClass('opened');			
		}				
	});
			
});

$("#btnDemo").click(function () {
    var value = $(this).attr("data-href");
    $("#btnDemo").attr("href",value);
});

$("#btnJuega").click(function () {
    var url = $(this).attr("data-href");
    $("#btnJuega").attr("href",url);        
});

let animado = document.querySelectorAll(".animado");

function mostrarScroll(){
	animado = document.querySelectorAll(".animado");
	let scrollTop = document.documentElement.scrollTop;
	for(var i = 0; i < animado.length; i++){
		let alturaAnimado = animado[i].offsetTop;    		
		if(alturaAnimado - $(window).height() + 80  < scrollTop){
			animado[i].style.opacity = 1;
			animado[i].querySelectorAll(".casino-game")[0].style.display = 'block';
		}
	}
}    
window.addEventListener('scroll', mostrarScroll);

$('#sproveedor').multiselect({
	buttonWidth: '200px',
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
    	  //$('.btn-group .dropdown-menu').show();
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
    		$('#libroreclama').css('display', 'none');
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
	if (tipo!='todos') $('#libroreclama').css('display', 'none');else $('#libroreclama').css('display', 'block');
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
	var item = overlay = vbotonJuego = franjaNuevo = class_favoritos_on = activo = '', display_none = 'display:none;';
	var src_star_off = 'src="layer-view-image/game/virtuales/icon_star_off.svg"';
	//es mayor a cero para marcar favoritos
	if( Object.keys(prodDisponibles).length > 0 ){// existe favoritos
		activo = prodDisponibles[val.gameproductid];
		if(activo == "1") class_favoritos_on = 'favoritos-on';	  		  			
		else class_favoritos_on = 'favoritos-off';				
	}else src_star_off = '';
	
	if( val.demolink === undefined ){
		overlay = '';
		vbotonJuego = '';
		vbotonJuego = ' href="javascript:openGame(\'' + val.gameproductid + '\')" ';		
	} else{
		if( val.provid == '2' ){//Leap
			overlay = 'casino-overlay';
			vbotonJuego = ' href="javascript:botonJuegoLeap(\''+ val.gameproductid+'\');"';
		}			
	}
	
	if( val.newtag == '1' ){
		franjaNuevo = '<div class="franjaNuevo">Nuevo</div>';
	}
	
	
	item += '<li id="li-' + val.gameproductid + '" class="GridItem GridItem--match2 ' + class_favoritos_on + ' animado">';
	item += franjaNuevo;
	item += '<div class="favoritos" onclick="setFavorito(\'' + val.gameproductid + '\')" ><div class="div-' + class_favoritos_on + '" id="img-favoritos' + val.gameproductid + '"   ' + src_star_off + ' ></div></div>';
	item += '<a id="a-item-' + val.gameproductid + '" data-game="'+ val.name+'" data-gameId="'+ val.gameproductid+ '"' + vbotonJuego + ' class="js-modal casino-game ' + overlay + '"  style="' + display_none + 'background-image: url(\'' + val.image +'\')"></a>';
	item += '<div class="nombre virtual ' + class_favoritos_on + '"><p>' + val.name + '</p></div>';
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

$.ajax({ url: 'game_virtuales_product_list_order.html',
	type: 'get',
	dataType: 'json',
	success: function (response) {
			jsonProdsFix = response;			
	}, error: function(e) {
	  	console.log('error obteniendo productos virtuales orderfix...')
	}
});

function openGame(gameId) {
	if(anuncioParam != null )
		window.location.href="game_virtuales_show_home.html?game=" + gameId + '&type=' + gcategoria;
	else
		window.location.href="game_virtuales_show_home.html?game=" + gameId;
 }
	
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
	
window.addEventListener("orientationchange", ()=> {
	console.log(window.screen.orientation.type);
    console.log('cambio horientazion');
    if(window.screen.orientation.type == "landscape-primary"){
    	$('#popup-scrool-copa').removeClass("margen");
    	
	 }else if(window.screen.orientation.type == "portrait-primary" ){
		 $('#popup-scrool-copa').addClass("margen");
	 }
});

	
function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

var URLactual = window.location.pathname;
console.log(URLactual);
var estadoWeb = URLactual.includes("lacopaentucasa.html");

$(document).ready(function(){

//		var idsession = $("#clientId").val();
//		if(idsession == ''){
//			if(!estadoWeb){
//				checkCount();
//			}											
//											
//		}

					
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