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

function botonJuego(gameId, gameDemo, mainp){
	var dataGameId = gameId;
	var dataGameDemo = gameDemo + '?language=es&currency=PEN';
	$(document).ready(function() {
		$('.nombreJuego').html('');
		$('.nombreJuego').append($("#a-item-"+dataGameId).attr("data-game"));
			
		if( dataGameId != "undefined"){	
			$("#raspaya-background").attr("style","background-image: url('layer-view-image/game/raspaditas/thumbnails/"+dataGameId+"-overlay.png');");
			$("#btnDemo").attr("data-href",dataGameDemo);
			$("#btnJuega").attr("data-href","game_raspaya_show_home.html?game="+ dataGameId +"&mode=live&mainp=" + mainp);
			$('#popup1').addClass('opened');
		}
	});  	
}

function botonJuegoCasinoRaspaya(gameId){
	var dataGameId = gameId;
	$(document).ready(function() {
		$('.nombreJuego').html('');
		$('.nombreJuego').append($("#a-item-"+dataGameId).attr("data-game"));
			
		if( dataGameId != "undefined"){
			$("#raspaya-background").attr("style","background-image: url('layer-view-image/game/raspaditas/thumbnails/"+dataGameId+"-overlay.png');");
			$("#btnDemo").attr("data-href","game_raspaya_show_home_ry.html?game="+ dataGameId +"&mode=demo");
			$("#btnJuega").attr("data-href","game_raspaya_show_home_ry.html?game="+ dataGameId +"&mode=live");
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
       
       $(".casino-overlay").on("click",function(){
			var $this = $(this);
			var dataGame = $this.attr("data-game");
			var dataGameId = $this.attr("data-gameId");
			var dataGameDemo = $this.attr("data-gameDemo") + '?language=es&currency=PEN';
			$('.nombreJuego').html('');
			$('.nombreJuego').append(dataGame);
			
			if( dataGameId != undefined){
				$("#btnDemo").attr("data-href",dataGameDemo);
				$("#btnJuega").attr("data-href","game_raspaya_show_home.html?game="+ dataGameId +"&mode=live");
				$('#popup1').addClass('opened');
			}				
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
	
	$("#btnDemo").click(function () {
        var value = $(this).attr("data-href");
        var url = '';
        if(value.indexOf("mode=demo") == -1) url = "game_raspaya_show_home.html?demo="+ value;
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
    	 $('#m-todos').removeClass("active");$('#m-favoritos').removeClass("active");
    	 $('#m-masjugados').removeClass("active");
    	 $('#m-favoritos .star-submenu').removeClass("star-on-submenu");
    	 $('#m-favoritos .star-submenu').attr('src','layer-view-image/game/casino/icon_star_off_menu.svg');    	 
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
		
		gcategoria = tipo;
		desactivam();
		$('#m-'+tipo).addClass("active");
		if (tipo!='todos') $('#libroreclama').css('display', 'none');else $('#libroreclama').css('display', 'block');
	}
 
 	function actualizaProveedorJuego(nombre){//casilla de busqueda por nombre
		var itemJuegoGeneral = item = '';
		if(jsonProds == null) return ;			  		
		for(var i = 0; i < jsonProds.length; i++) {	
			var val = jsonProds[i];			
			item = armaItemJuego(val);
			if(val.title.toLowerCase().indexOf(nombre.toLowerCase()) > -1) itemJuegoGeneral += item;
		}		
		$('#listaGeneral').html('');$('#listaGeneral').append(itemJuegoGeneral);		
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
		var item = overlay = vbotonJuego = franjaNuevo = jackpot = class_favoritos_on = activo = '', display_none = 'display:none;';
		var src_star_off = 'src="layer-view-image/game/casino/icon_star_off.svg"';
		//es mayor a cero para marcar favoritos
		if( Object.keys(prodDisponibles).length > 0 ){// existe favoritos
			activo = prodDisponibles[val.gameproductid];
			if(activo == "1") class_favoritos_on = 'favoritos-on';	  		  			
			else class_favoritos_on = 'favoritos-off';				
		}else src_star_off = '';
		
		if( val.mainprovider === 'QTECH' ){
			overlay = '';
			vbotonJuego = ' href="game_raspaya_show_home.html?game='+ val.gameproductid +'&amp;mode=live' + '&amp;mainp='+ val.mainprovider + '" ';			
		} else{
			overlay = 'casino-overlay';
			vbotonJuego = ' href="javascript:botonJuegoCasinoRaspaya(\''+ val.gameproductid+'\');"';
		}

		if( val.newtag == '1' ){
			franjaNuevo = '<div class="franjaNuevo">Nuevo</div>';
		}
		
		jackpot = '<div class="jackpot" >'+val.pozo+'</div>';				
		
		item += '<li id="li-' + val.gameproductid + '" class="GridItem GridItem--match2 ' + class_favoritos_on + ' animado">';
		item += franjaNuevo;
		item += jackpot;		
		item += '<div class="favoritos" onclick="setFavorito(\'' + val.gameproductid + '\')" ><div class="div-' + class_favoritos_on + '" id="img-favoritos' + val.gameproductid + '"   ' + src_star_off + ' ></div></div>';
		item += '<a id="a-item-' + val.gameproductid + '" data-gameDemo="' + val.demolink + '" data-game="'+ val.title+'" data-gameId="'+ val.gameproductid+ '"' + vbotonJuego + ' class="js-modal casino-game ' + overlay + '" style="' + display_none + 'background-image: url(\'' + val.image +'\')"></a>';
		item += '<div id="div-nombre-' + val.gameproductid + '" class="nombre ' + class_favoritos_on + '"><p>' + val.title + '</p></div>';
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

	$.ajax({ url: 'game_raspaya_product_list_order.html',
		type: 'get',
		dataType: 'json',
		success: function (response) {
			  	jsonProdsFix = response;
			}, error: function(e) {
			  	console.log('error obteniendo productos raspaya orderfix...')
			}
	});
	
	$(document).ready(function(){			
		$(".casino-game").on("click",function(){
			var $this = $(this);
			var dataGameId = $this.attr("data-gameId");
			
			if( dataGameId != "undefined"){
				$("#raspaya-background").attr("style","background-image: url('layer-view-image/game/raspaditas/thumbnails/"+dataGameId+"-overlay.png');");
				$("#btnDemo").attr("data-href","game_raspaya_show_home_ry.html?game="+ dataGameId +"&mode=demo");
				$("#btnJuega").attr("data-href","game_raspaya_show_home_ry.html?game="+ dataGameId +"&mode=live");
				$('#popup1').addClass('opened');
			}
		});
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
	