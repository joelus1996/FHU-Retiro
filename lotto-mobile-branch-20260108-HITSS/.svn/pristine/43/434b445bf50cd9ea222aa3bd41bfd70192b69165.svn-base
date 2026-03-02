<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<!DOCTYPE html>
<html>
<head>
	
  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta http-equiv="Cache-Control" content="max-age=0" />
  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
  <meta http-equiv="Expires" content="0" />
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
  <meta http-equiv="Pragma" content="no-cache" />
  <meta charset="utf-8">
  <title></title>
 
<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/jquery-migrate-3.1.0.min.js"></script>
<script>

function toJuegosVirtuales(producto) {
	
	$.ajax({
        type: 'post',
        url: 'juegos-virtuales-session.html',
        dataType: 'json',
        data: "producto="+producto
	}).done(function(d) {
		if(d.message=="OK") {
			window.open("https://api.teapuestobet.com/api/v1/intralot/mobile?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
//});
}

toJuegosVirtuales('sport');

</script>

</html>