var jsonProds;
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

$(".close_f").on("click",function(){
	$(".f_error_mensaje").hide();			
});

function botonJuego(gameId, gameDemo, mainp) {
    var dataGameId = gameId;
    var dataGameDemo = gameDemo + '?language=es&currency=PEN';

    // Obtener el nombre del juego y mostrarlo si deseas
    $('.nombreJuego').html('');
    $('.nombreJuego').append($("#a-item-" + dataGameId).attr("data-game"));

    // Construir URL del juego
    if (dataGameId != "undefined") {
        var gameUrl = "game_video_loterias_show_menu.html?game=" + dataGameId + "&mode=live&mainp=" + mainp;
        openGameIframe(gameUrl); // Cargar en iframe
    }
}

function botonJuegoCasinoRaspaya(gameId){
	var dataGameId = gameId;
	$(document).ready(function() {
		$('.nombreJuego').html('');
		$('.nombreJuego').append($("#a-item-"+dataGameId).attr("data-game"));
			
		if( dataGameId != "undefined"){	
			$("#btnDemo").attr("data-href","game_casino_show_home_ry.html?game="+ dataGameId +"&mode=demo");
			$("#btnJuega").attr("data-href","game_casino_show_home_ry.html?game="+ dataGameId +"&mode=live");
			$('#popup1').addClass('opened');
		}
	});  	
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
	   //a partir de que punto del scroll vertical de la ventana mostrará el botón flotante
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
	
	$("#btnDemo").click(function () {
        var value = $(this).attr("data-href");
        var url = '';
        if(value.indexOf("mode=demo") == -1) url = "game_video_loterias_show_menu.html?demo="+ value;
        else url = value;
        
        $("#btnDemo").attr("href",url);
    });
    
    $("#btnJuega").click(function () {
        var url = $(this).attr("data-href");
        $("#btnJuega").attr("href",url);        
    });
	
    $(".btnLupa").click(function () {
    	$('#buscador').focus().trigger({ type : 'keyup', which : 13 });
    });
        
    let counter;
    
    function timer(){
        for (let x = 0; x < ajackpotids.length; x++) {
          $('.' + ajackpotids[x]).load('getJackpot.html?jackpotid=' + ajackpotids[x]);
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
    
    function actualizaFavoritos(){
		var item = '';
		$.ajax({ url: 'game_casino_favorite_product_list.html',
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
    	$('#buscador').val('');
    	$('#subtitulo'+opcion).show();
    	switch (opcion) {    	
	    	case "todos":
	    	 	//$('#buscador').trigger({ type : 'keyup', which : 13 });
	    		break;    	 
	    	case "favoritos": 
	    		$('#buscador').val('');
	    		$('#libroreclama').css('display', 'none');
	    		//buscar();
	    		$('.col-md-8-proveedor').hide();
	    		$('#games').css('margin-top', '12px');
	    		desactivam();
	    		$('#m-favoritos').addClass("active");$('#m-favoritos .star-submenu').addClass("star-on-submenu");
	    		$('#m-favoritos .star-submenu').attr('src','layer-view-image/game/casino/icon_star_on.svg');
	    		actualizaFavoritos();
	    		return ;
	        	break;
	    	case "live"	: 
	    		//nuevo subtitulo por agregar
	    		$('#games').css('margin-top', '0px');
	    		break;
		}
    	if (opcion != 'favoritos' && opcion != 'masjugados') {
    		actualizaProveedor(opcion,'');
    	}    		
    	mostrarScroll();    	
     }
      
   function actualizaProveedor(tipo, prov){
	    var idsession = $("#clientId").val();
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
		$('#listaGeneral').html('');$('#listaGeneral').append(itemJuegoGeneral);
		
		gcategoria = tipo;ocultaSubtitulo();
		if (tipo=='live') {desactivam();$('.col-md-8-search-subcategoria').css('display', 'initial');$('#m-live').addClass("active");return ;}
		if (tipo=='baccarat' || tipo=='blackjack' || tipo=='poker' || tipo=='roulette' || tipo=='otros') {desactivasm();$('.col-md-8-search-subcategoria').css('display', 'initial');$('#m-live').addClass("active");}
		else desactivam();
		$('#m-'+tipo+' .subcategoria').attr('src','layer-view-image/game/casino/' + tipo + '_on.svg');
		$('#m-'+tipo).addClass("active");$('#subtitulo'+tipo).show();
		if (tipo=='otros') {
			var left2 = $('.menu1').width();
    		$('.menu2').scrollLeft(left2);
		}
		
		if ( (tipo=='bingo' && idsession != '') || tipo=='mesa' || tipo=='jackpot' || tipo=='virtual') {
			var left1 = $('.menu1').width();
    		$('.menu1').scrollLeft(left1);
		}
		if (tipo!='todos') $('#libroreclama').css('display', 'none');else $('#libroreclama').css('display', 'block');
	}
 
 	function actualizaProveedorJuego(nombre){//casilla de busqueda por nombre
		var itemJuegoGeneral = item = '';
		if(jsonProds == null) return ;			  		
		for(var i = 0; i < jsonProds.length; i++) {	
			var val = jsonProds[i];			
			item = armaItemJuego(val);
			if(val.name.toLowerCase().indexOf(nombre.toLowerCase()) > -1) itemJuegoGeneral += item;
		}	
	
		$('#listaGeneral').html('');$('#listaGeneral').append(itemJuegoGeneral);
		$('#listaGeneral li a').css("display", "block");

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
		$('#listaGeneral').html('');$('#listaGeneral').append(itemJuegoGeneral);		
	}
 
	function armaItemJuego(val){
		var item = overlay = vbotonJuego = franjaNuevo = jackpot = class_favoritos_on = activo = '', display_none = 'display:none;';
		var src_star_off = 'src="layer-view-image/game/casino/icon_star_off.svg"';
		//es mayor a cero para marcar favoritos
		if( Object.keys(prodDisponibles).length > 0 ){// existe favoritos
			activo = prodDisponibles[val.gameproductid];
			if(activo == "1") class_favoritos_on = 'favoritos-on';	  		  			
			else class_favoritos_on = 'favoritos-off';				
		}else src_star_off = '';
		
		if( val.demolink === undefined ){
			overlay = '';
			if( val.provname != 'Hacksaw' ){
				if(val.type == 'live')
					vbotonJuego = ' href="game_video_loterias_show_menu.html?game='+ val.gameproductid +'&amp;mode=live&amp;category='+ val.type + '&amp;mainp='+ val.mainprovider + '" ';
				else
					vbotonJuego = ' href="game_video_loterias_show_menu.html?game='+ val.gameproductid +'&amp;mode=live' + '&amp;mainp='+ val.mainprovider + '" ';
				
			}else{
				vbotonJuego = ' href="game_casino_show_home_ry.html?game='+ val.gameproductid +'&amp;mode=live" ';
			}
		} else{
			overlay = 'casino-overlay';
			if( val.provname != 'Hacksaw' ){//spinmatic
				vbotonJuego = ' href="javascript:botonJuego(\''+ val.gameproductid+'\',\'' + val.demolink + '\',\'' + val.mainprovider + '\');"';
			}else{
				vbotonJuego = ' href="javascript:botonJuegoCasinoRaspaya(\''+ val.gameproductid+'\');"';
			}
		}

		if( val.newtag == '1' ){
			franjaNuevo = '<div class="franjaNuevo">Nuevo</div>';
		}
		
		if( val.jackpotid != '0' ){
			jackpot = '<div class="jackpot '+val.jackpotid+'" ></div>';				
		}
		
		item += '<li id="li-' + val.gameproductid + '" class="GridItem GridItem--match2 ' + class_favoritos_on + ' animado">';
		item += franjaNuevo;
		item += jackpot;		
		//item += '<div class="favoritos" onclick="setFavorito(\'' + val.gameproductid + '\')" ><div class="div-' + class_favoritos_on + '" id="img-favoritos' + val.gameproductid + '"   ' + src_star_off + ' ></div></div>';
		item += '<a id="a-item-' + val.gameproductid + '" data-gameDemo="' + val.demolink + '" data-game="'+ val.name+'" data-gameId="'+ val.gameproductid+ '"' + vbotonJuego + ' class="js-modal casino-game ' + overlay + '" style="' + display_none + 'background-image: url(\'' + val.image +'\')"></a>';
		item += '<div id="div-nombre-' + val.gameproductid + '" class="nombre ' + class_favoritos_on + '"><p>' + val.name + '</p></div>';
		item += '</li>';
		
		return item;
	}

	$.ajax({ url: 'game_videoloteria_product_list.html',
		type: 'get',
		dataType: 'json',
		success: function (response) {
			  	jsonProds = response;
			  	if(anuncioParam == null){ actualizaProveedor('todos','');initSelectProvider('todos');}
			  	else if(anuncioParam=='favoritos'){}
			  	else {actualizaProveedor(anuncioParam,'');initSelectProvider(anuncioParam);}
			  	mostrarScroll();
			}, error: function(e) {
			  	console.log('error obteniendo productos casino random...')
			}
	});

	 function activaTimer(){
		 timeractivo = true;
		 if (counter) clearInterval(counter);
         counter = setInterval(timer, 2000);
	 }
	 function openGameIframe(url) {
		    $("#frmLightboxRechargeIlot").attr("src", url);
		    $("#div-lightbox-recharge-ilot").fadeIn(); // muestra el iframe
		}
	 function closeLightboxRechargeIlotF() {
		    $("#frmLightboxRechargeIlot").attr("src", ""); // limpiar
		    $("#div-lightbox-recharge-ilot").fadeOut();
		}

	 
	 function closeVideoLoteriaIframe() {
		    history.back();
		}



	 