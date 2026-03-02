<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<div class="box-content-img" id="box-content-img"></div>

<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>

<script>
$.ajax({    		  
	url: "<%=Constantes.BANNER_CONFIG_XML%>",
	cache: false,
	success: function(res) {
	  	var xmlDoc = res;
	  	var data = xmlDoc.getElementsByTagName("config");

	  	if (data[0]) {
	  		$(res).find('config').children('mobile').children('banner').each(function(){  			
	  			var itemJuego = '<a href="' + $(this).find("c_link").text() + '" >';
	  			itemJuego += '<img src="' + $(this).find("c_image").text() + '" alt="" />';															  			
	  			itemJuego += '</a>';
	  			
	            $('#box-content-img').append(itemJuego);
	  	    });	  				  		
	  	} else {
	  		console.log('no data');
	  	}
	}, error: function(e) {
	  	console.log('error obteniendo bannerConfigXML.xml...');
	}
});
</script>