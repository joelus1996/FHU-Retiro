var jsonProds;
var jsonProdsVideoLoteria ;
var jsonProdsFix;
var gcategoria = '';
var timeractivo = true;
var asubcategorias = ["baccarat", "blackjack", "poker", "roulette", "otros"] ; 

var selectProvider = [];

function refreshScroll(){
	var t = document.documentElement.scrollTop;document.documentElement.scrollTop = t + 1;document.documentElement.scrollTop = t;
}

var ajackpotids = new Array();
if (temp !== '-') {
	ajackpotids = temp.slice(0, -1).split(',').filter(id => id.trim() !== '');
}

function ocultaSubtitulo(){
	$('#subtituloslots').hide();$('#subtitulojackpot').hide();$('#subtitulovirtual').hide();$('#subtitulobingo').hide();$('#subtitulomesa').hide();
	asubcategorias.forEach(function(sub) {
		$('#subtitulo'+sub).hide();
	});
}	
	click = false;
	ocultaSubtitulo();
	$(document).ready(function(){
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
      	ocultaSubtitulo();		
    	actualizaProveedorJuego(value);
    	refreshScroll();
  	  });
  	});
	
    $(".btnLupa").click(function () {
    	$('#buscador').focus().trigger({ type : 'keyup', which : 13 });
    });

    let counter;
    
    function timer(){
    	for (x=0;x<ajackpotids.length;x++){
        	$('.'+ajackpotids[x]).load('getJackpot.html?jackpotid='+ajackpotids[x]);
		}    	
   	}

    counter = setInterval(timer, 2000);

    $(document).idle({
        onIdle: function(){
            clearInterval(counter);
        },
        onActive: function(){
        	if(timeractivo){
	        	if (counter) clearInterval(counter);
	            counter = setInterval(timer, 2000);
        	}
        },
        onHide: function(){
			clearInterval(counter);
        },
        onShow: function(){
          // Add a slight pause so you can see the change
          if(timeractivo){
	          setTimeout(function(){
	        	  if (counter) clearInterval(counter);
	              counter = setInterval(timer, 2000);
	          }, 250);
          }   
        },
        idle: 10000, //DEFINIR CUAL SERÁ EL TIEMPO MÁXIMO DE INACTIVIDAD PARA OPTIMIZAR EL CONSUMO
        keepTracking: true
      });
        
    ////////
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
    	 $('#m-todos').removeClass("active");$('#m-favoritos').removeClass("active");$('#m-slots').removeClass("active");
    	 $('#m-jackpot').removeClass("active");$('#m-virtual').removeClass("active");$('#m-live').removeClass("active");
    	 $('#m-masjugados').removeClass("active");$('#m-bingo').removeClass("active");$('#m-mesa').removeClass("active");
    	 $('#m-favoritos .star-submenu').removeClass("star-on-submenu");
    	 $('#m-favoritos .star-submenu').attr('src','layer-view-image/game/casino/icon_star_off_menu.svg');
    	 $('.col-md-8-search-subcategoria').css('display', 'none');
    	 desactivasm();
     }
    
    function desactivasm(){
    	asubcategorias.forEach(function(sub) {
    		$('#m-'+sub).removeClass("active");
    		$('#m-'+sub+' .subcategoria').attr('src','layer-view-image/game/casino/'+sub+'.svg');
		});    	
    }
    
     function juegos(opcion){
    	$('#listaGeneralvl').html('');
    	$('.col-md-8-proveedor').show();
    	if(opcion==null) opcion = 'todos'; 
    	gcategoria = opcion;
    	ocultaSubtitulo();
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
	    		//buscar();
	    		$('.col-md-8-proveedor').hide();
	    		$('#games').css('margin-top', '12px');
	    		desactivam();
	    		$('#m-favoritos').addClass("active");$('#m-favoritos .star-submenu').addClass("star-on-submenu");
	    		$('#m-favoritos .star-submenu').attr('src','layer-view-image/game/casino/icon_star_on.svg');
	    		//actualizaFavoritos();
	    		return ;
	        	break;
	    	case "live"	: 
	    		//nuevo subtitulo por agregar
	    		$('#games').css('margin-top', '0px');
	    		break;
		}
    	actualizaProveedor(opcion,'');
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
				else if(tipo.includes(val.subtype)) itemJuegoGeneral += item;
			}else{
				if(prov.includes(val.provname)) itemJuegoGeneral += item;				
			}
		}	
		$('#listaGeneralvl').html('');$('#listaGeneralvl').append(itemJuegoGeneral);
		
		gcategoria = tipo;ocultaSubtitulo();
		if (tipo=='live') {desactivam();$('.col-md-8-search-subcategoria').css('display', 'initial');$('#m-live').addClass("active");return ;}
		if (tipo=='baccarat' || tipo=='blackjack' || tipo=='poker' || tipo=='roulette' || tipo=='otros') {desactivasm();$('.col-md-8-search-subcategoria').css('display', 'initial');$('#m-live').addClass("active");}
		else desactivam();
		$('#m-'+tipo+' .subcategoria').attr('src','layer-view-image/game/casino/' + tipo + '_on.svg');
		$('#m-'+tipo).addClass("active");$('#subtitulo'+tipo).show();
	}
 
 	function actualizaProveedorJuego(nombre){//casilla de busqueda por nombre
		var itemJuegoGeneral = item = '';
		if(jsonProds == null) return ;			  		
		for(var i = 0; i < jsonProds.length; i++) {	
			var val = jsonProds[i];			
			item = armaItemJuego(val);
			if(val.name.toLowerCase().indexOf(nombre.toLowerCase()) > -1) itemJuegoGeneral += item;
		}		
		$('#listaGeneralvl').html('');$('#listaGeneralvl').append(itemJuegoGeneral);		
	}
 
 	function actualizaProveedorCat(tipo, prov){//combo multiselect
		var itemJuegoGeneral = item = '';
		if(jsonProdsFix == null) return ;			  		
		for(var i = 0; i < jsonProdsFix.length; i++) {	
			var val = jsonProdsFix[i];
			item = armaItemJuego(val);			
			if(tipo.includes(val.type) && prov.includes(val.provname)) itemJuegoGeneral += item;
			if(tipo.includes(val.subtype) && prov.includes(val.provname)) itemJuegoGeneral += item;
		}		
		$('#listaGeneralvl').html('');$('#listaGeneralvl').append(itemJuegoGeneral);		
	}
 
	function armaItemJuego(val){
		var item = overlay = botonJuego = franjaNuevo = jackpot = class_favoritos_on = activo = '', display_none = 'display:none;';
		var src_star_off = 'src="layer-view-image/game/casino/icon_star_off.svg"';
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
			if( val.provname != 'Hacksaw' ){
				botonJuego += '		<a class="btn btn--secondary" href="javascript:openDemo(\'' + val.demolink + '\')">Modo pr&aacute;ctica</a>';
				botonJuego += ' 	<a class="btn btn--primary" href="javascript:openGame(\'' + val.gameproductid + '\',\'' + val.type + '\',\'' + val.mainprovider + '\')">Juega y Gana</a>';
			}else{
				botonJuego += '		<a class="btn btn--secondary" href="javascript:openCasinoRaspaya(\'' + val.gameproductid + '\',\'demo\')">Modo pr&aacute;ctica</a>';
				botonJuego += ' 	<a class="btn btn--primary" href="javascript:openCasinoRaspaya(\'' + val.gameproductid + '\',\'live\')">Juega y Gana</a>';
			}
			botonJuego += '	</div>';
			botonJuego += '</div>';
		}

		if( val.newtag == '1' ){
			if( val.provname != 'Hacksaw' ){
				franjaNuevo = '<div class="franjaNuevo" onclick="javascript:openGame(\'' + val.gameproductid + '\',\'' + val.type + '\',\'' + val.mainprovider + '\')" >Nuevo</div>';
			}else{
				franjaNuevo = '<div class="franjaNuevo" onclick="javascript:openCasinoRaspaya(\'' + val.gameproductid + '\',\'live\')" >Nuevo</div>';
			}
		}
		if( val.jackpotid != '0' ){
			if( val.provname != 'Hacksaw' ){
				jackpot = '<div class="jackpot '+val.jackpotid+'" onclick="javascript:openGame(\'' + val.gameproductid + '\',\'' + val.type + '\',\'' + val.mainprovider + '\')" ></div>';
			}else{
				jackpot = '<div class="jackpot '+val.jackpotid+'" onclick="javascript:openCasinoRaspaya(\'' + val.gameproductid + '\',\'live\')" ></div>';
			}
		}
		
		item += '<li id="li-' + val.gameproductid + '" class="' + class_favoritos_on + ' animado">';
		
		item += franjaNuevo;
		item += jackpot;
		//item += '<div class="favoritos" onclick="setFavorito(\'' + val.gameproductid + '\')" ><div class="' + class_favoritos_on + '" id="img-favoritos' + val.gameproductid + '"   ' + src_star_off + ' ></div></div>';
		item += '<div class="raspaditaItem ' + overlay + '">';
		item += '	<h3 id="div-nombre-' + val.gameproductid + '" class="nombre ' + class_favoritos_on + '">'+ val.name +'</h3>';
		if( val.provname != 'Hacksaw' ){
			item += '<a href="javascript:openGame(\'' + val.gameproductid + '\',\'' + val.type + '\',\'' + val.mainprovider + '\')" ><div class="imgcore" style="' + display_none + 'background-image:url(\''+ val.image +'\')"></div></a>';		
		}else{
			item += '<a href="javascript:openCasinoRaspaya(\'' + val.gameproductid + '\',\'live\')" ><div class="imgcore" style="' + display_none + 'background-image:url(\''+ val.image +'\')"></div></a>';
		}
		item += botonJuego;
		item += '</div>';
		item += '</li>';

		return item;
	}

	$.ajax({ url: 'game_videoloteria_product_list.html',
		type: 'get',
		dataType: 'json',
		success: function (response) {
			  	jsonProds = response;
			  	if(anuncioParam == null){ actualizaProveedor('todos','');initSelectProvider('todos');}
			  	else {actualizaProveedor(anuncioParam,'');initSelectProvider(anuncioParam);}
			  	mostrarScroll();
			}, error: function(e) {
			  	console.log('error obteniendo productos videoloteria random...')
			}
	});

		
	function openGame(gameId, type, mainp) {
	    url = "";
	    timeractivo = false;
	    $("div .box-main-game-alert-iivv").remove();
	    $('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
	    $('body').css('overflow-y', 'hidden');

	    $.ajax({
	        type: 'POST',
	        url: 'getLobbyVideoLoteria.html',
	        dataType: 'text',
	        data: "game=" + gameId + "&category=" + type + "&mainp=" + mainp,
	        success: function (e) {
	        
	            if (e.url != "-" && e.url != "" && e != "sinSesion") {
	            	$('body').append('<div id="div-lightbox-recharge-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 2147483000;overflow: auto;"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlotF();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" scrolling="no" frameborder="0" onload="retirar_loading();" src="open-videoloteria.html?url=' + e.url + '" class="lightbox-recharge" ></iframe></div>');
        			$("#frmLightboxRecharge").attr('style', 'height:100%');	
	            } else {
	                closeLightboxRechargeIlotF(); 
	                activaTimer();

	                var a = "";
	                if (e == "sinSesion") {
	                    a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Debes iniciar sesión para jugar</p></div>';
	                } else {
	                    a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Juego no disponible, elegir otro</p></div>';
	                }
	                $("div .main-panel").prepend(a);
	            }
	        }
	    });
	}

	
	
	function openDemo(demoUrl) {
		url = "";
		timeractivo = false;
		$("div .box-main-game-alert-iivv").remove();
		$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
		$('body').css('overflow-y', 'hidden');
		
		$.ajax({
            type: 'POST',
            url: 'getLobbyVideoLoteria.html',
            dataType: 'text',
            data: "demo=" + demoUrl,
            success: function (e) {
                if (e != "")  url = $.trim((e + "").toString());                   
                
            	if(url != "-" && url != "" && url != "sinSesion"){
        			$('body').append('<div id="div-lightbox-recharge-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 2147483000;overflow: auto;"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlotF();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" scrolling="no" frameborder="0" onload="retirar_loading();" src="open-videoloteria.html?url=' + url + '" class="lightbox-recharge" ></iframe></div>');
        			$("#frmLightboxRecharge").attr('style', 'height:100%');				
        		}else{
        			closeLightboxRechargeIlotF();
        			activaTimer();
        			var a = "";
        			if(url == "sinSesion") a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Debes iniciar sesión para jugar</p></div>';
        			else a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Juego no disponible, elegir otro</p></div>';
        			$("div .main-panel").prepend(a);
        		}
            }
        });		
	 }
	
	function openCasinoRaspaya(game, mode) {
		url = "";
		timeractivo = false;
		$("div .box-main-game-alert-iivv").remove();
		$('body').append('<div id="loading-ilot" class="loading-ilot"></div>');
		$('body').css('overflow-y', 'hidden');
		
		$.ajax({
            type: 'POST',
            url: 'getLobbyVideoloteria.html',
            dataType: 'text',
            data: "gameRaspaya=" + game + "&mode=" + mode,
            success: function (e) {
                if (e != "")  url = $.trim((e + "").toString());                                   
            	
                if(url != "" && url != "sinSesion"){
        			$('body').append('<div id="div-lightbox-recharge-ilot" style="position: fixed;top: 0;left: 0;right: 0;bottom: 0;z-index: 2147483000;overflow: auto;"><button id="lightbox-recharge-ilot-close" onclick="closeLightboxRechargeIlotF();" class="lightbox-recharge-ilot-close" ></button><iframe id="frmLightboxRecharge" scrolling="no" frameborder="0" onload="retirar_loading();" src="open-casino-raspaya.html?game=' + url + '&mode=' + mode + '" class="lightbox-recharge" ></iframe></div>');
        			$("#frmLightboxRecharge").attr('style', 'height:100%');				
        		}else{
        			closeLightboxRechargeIlotF();
        			activaTimer();
        			var a = "";
        			if(e == "sinSesion") a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Debes iniciar sesión para jugar</p></div>';
        			else a = '<div class="box-main-game-alert-iivv"><p class="message-game-alert">Juego no disponible, elegir otro</p></div>';
        			$("div .main-panel").prepend(a);
        		}
            }
        });		
	 }

	 function activaTimer(){
		 timeractivo = true;
		 if (counter) clearInterval(counter);
         counter = setInterval(timer, 2000);
	 }
	 
	 function actualizaMasJugados(){
		var item = '';
		$.ajax({ url: 'game_videoloteria_product_list.html',
			type: 'get',
			dataType: 'json',
			success: function (response) {
				listaDetalle = response;
				for(var i = 0; i < listaDetalle.length; i++) {	
					var val = listaDetalle[i];
					item += armaItemJuego(val);
				}		    			
				$('#listaGeneralvl').html('');$('#listaGeneralvl').append(item);
				refreshScroll();
			},
			error: function (e) {
				console.log(e);
			}		
		});
     }
	 