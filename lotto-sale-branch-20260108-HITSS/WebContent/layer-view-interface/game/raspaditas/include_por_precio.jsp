<%@page import="pe.com.intralot.loto.util.Constants"%>
<div class="main-play">
	<div id="games">
		<div class="raspaditaContent">								    
	        <ul class="" id="listaPorPrecio" data-liststyle="thumbnail">
	            								                   
	        </ul>
	    </div>
	</div> 	
</div>
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script>
$.ajax({ url: 'game_raspaya_productprice_list.html',
	type: 'get',
	dataType: 'json',
	success: function(response) {
	  	var itemJuego = '';
	  	listaDetalle = response;
	  	for(var i = 0; i < listaDetalle.length; i++) {
	  			var val = listaDetalle[i];
	  			itemJuego = '<li>';
	  		    itemJuego += '<div class="raspaditaItem">';
	  		    itemJuego += '<div class="imgcore" style="background-image:url(\'layer-view-image/game/raspaditas/thumbnails/'+ val.gameproductid +'.png\')"></div>';
	  		    itemJuego += '<div class="front">';
	  		    itemJuego += '	<p class="gana">Gana hasta</p>';
	  		    itemJuego += '	<p class="monto">'+ val.pozo +'</p>';
	  		    itemJuego += '</div>';								
	  		  	itemJuego += '<div class="cintillo" style="background-image: url(\'layer-view-image/game/raspaditas/thumbnails/' + val.cintillo + '-soles.svg\')"></div>';
	  		    itemJuego += '<div class="back">';
	  		    itemJuego += '	<h3>'+ val.title +'</h3>';
	  		    itemJuego += '	<div class="buttons">';
	  		    itemJuego += '		<a class="btn btn--secondary" href="juega-raspaya.html?game='+ val.name +'&amp;mode=demo">Modo pr&aacute;ctica</a>';
	  		    itemJuego += ' 		<a class="btn btn--primary" href="juega-raspaya.html?game='+ val.name +'&amp;mode=live">Juega y Gana</a>';
	  		    itemJuego += '	</div>';
	  		    itemJuego += '</div>';
	  		    itemJuego += '</div>';
	  		    itemJuego += '</li>';  			
	  			
	             $('#listaPorPrecio').append(itemJuego);
	  	    }		  				  				  				  	
	}, error: function(e) {
	  	console.log('error obteniendo productos precio raspaYa...')
	}
});
</script>