<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<div class="row" id=list_cross_ganagol>								        
</div>
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script>
$.ajax({    		  
	url: "<%= Constantes.ventaCruzadaLoteriasXML %>",
	cache: false,
	success: function(res) {
	  	var xmlDoc = res;
	  	var data = xmlDoc.getElementsByTagName("crossSell");
	  	var itemJuego = '';			  
	  	if (data[0]) {  		  		
	  		$(res).find('crossSell').children('crossGanagol').each(function(){
	  			itemJuego  = '<div class="w-50">';
	  			itemJuego += 	'<div class="box-after-play">';
	  			itemJuego += 		'<a href="#" onclick="datalayerGraciasCompra(\''+$(this).find("c_id").text().substr(11,30)+'\',\'seguir jugando\',\'Link\');" id="' + $(this).find("c_id").text() + '">';
	  			itemJuego += 			'<img src="' + $(this).find("c_src").text() + '" alt="" />';															  			
	  			itemJuego += 		'</a>';
	  			itemJuego += 	'</div>';
	  			itemJuego += '</div>'; 
	  			
	            $('#list_cross_ganagol').append(itemJuego);
	  	    });	  				  		
	  	} else {
	  		console.log('no data')
	  	}
	}, error: function(e) {
	  	console.log('error obteniendo ventaCruzadaLoterias.xml...')
	}
});
</script>