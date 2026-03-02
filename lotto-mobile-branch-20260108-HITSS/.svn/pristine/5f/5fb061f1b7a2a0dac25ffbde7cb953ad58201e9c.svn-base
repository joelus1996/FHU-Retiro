<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<div class="GridWrapper">								    
    <ul class="GridList" id="listaTodos" data-liststyle="thumbnail">								    
	         								                   
	</ul>
</div>
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script>
$.ajax({ url: 'game_raspaya_product_list.html',
	type: 'get',
	dataType: 'json',
	success: function (response) {
		listaDetalle = response;
		var itemJuego = '';
		for(var i = 0; i < listaDetalle.length; i++) {
			var val = listaDetalle[i];
			itemJuego  = '<li class="GridItem GridItem--match2">';
  			itemJuego += '<a data-modal="#popup1" data-game="'+ val.name+'" data-gameId="'+ val.gameproductid+'" data-gamePrecio="'+ val.price+'" data-gamePozo="'+ val.pozo+'"  href="javascript:botonJuego(\''+ val.gameproductid+'\', \''+ val.name+'\', \''+ val.price+'\', \''+ val.pozo+'\');"  class="js-modal iivv-game cintillo" style="background-image: url(\'layer-view-image/game/raspaditas/thumbnails/'+ val.cintillo +'-soles.svg\')"></a>';
  			itemJuego += '<a data-modal="#popup1" data-game="'+ val.name+'" data-gameId="'+ val.gameproductid+'" data-gamePrecio="'+ val.price+'" data-gamePozo="'+ val.pozo+'"  href="javascript:botonJuego(\''+ val.gameproductid+'\', \''+ val.name+'\', \''+ val.price+'\', \''+ val.pozo+'\');"  class="js-modal iivv-game" style="background-image: url(\'layer-view-image/game/raspaditas/thumbnails/'+ val.gameproductid +'.png\')"></a>';														
  			itemJuego += '</li>'; 
  			
            $('#listaTodos').append(itemJuego);
		}

	}, error: function(e) {
	  	console.log('error obteniendo productos raspaya...')
	}
});
</script>