<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="pe.com.intralot.loto.util.Constants"%>
<!DOCTYPE html>
<html>
<head>

  <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />	
  <meta http-equiv="Cache-Control" content="max-age=0" />
  <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
  <meta http-equiv="Expires" content="0" />
  <meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
  <meta http-equiv="Pragma" content="no-cache" />
  <meta charset="utf-8">
  <title></title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="layer-view-style/common/tav2-header.css?v=<%=Constants.tav2_header_css%>">
  
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
 
  
  <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/bannerCookies.css?v=6">
  
</head>
<body>
<input type="hidden" value="${sessionScope.User.pClientid}" id="clientId">
  <header id="nvs-header">
	<div class="nvs-header-row nvs-header-0">
		<div class="nvs-logo"> <a class="logo" href="<%= Constants.tav2GameProviderCloseUrl%>"></a> </div>
		<div class="nvs-register"> 
			<a class="boton_personalizado" onclick="datalayerRegistro(this);" href="registro.html?operatorId=5588&urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />">&nbsp;&nbsp;&nbsp;REGÍSTRATE&nbsp;&nbsp;&nbsp;</a>
		</div>
		<div class="nvs-ingresar"> 
			<a class="boton_personalizado2" onclick="datalayerLogin(this);" href="tav2.html?urlRedirect5588=<c:out value='${urlRedirect5588}' />&redirectGame=<c:out value='${redirectGame}' />&ref=<c:out value='${ref}' />">&nbsp;&nbsp;&nbsp;INGRESAR&nbsp;&nbsp;&nbsp;</a>
		</div>
		
		
		
	</div>	
	<div class="nvs-header-row nvs-header-1">&nbsp;</div>
	<div class="nvs-header-row nvs-header-2">&nbsp;</div>
	<div class="nvs-header-row">&nbsp;</div>
	<div class="nvs-header-row">&nbsp;</div>
  </header>
	
  <div class="wrap-body" id="wrap-body">

	<input type="hidden" value="<%= Constants.flagPromoHincha %>" id="flagPromoHincha">
    <div class="text-center top-login">
      <h3 class="top-title">Bienvenido</h3>      
    </div>
	
		
  </div>
  
  	<footer id="footer">
		
	<!-- Popup avion Peru -->
			<div id="popup-avionPeru" class="overlay-PromSorteo">
				<div class="popup popup-sm-PromSorteo" style="border-radius: 20px;">
					<a class="close-PromSorteo-ta js-close-modal">&times;</a>
					<div class="wrap-modal">
						<div class="gana-PromSorteo-footer" style="border-radius: 20px;">
							<img class="home-popup" src="layer-view-image/game/teapuesto/avionPeru/popup-peru.png" alt="">
							<button style="background-color: #e30613;top: -60px;position: relative;cursor:pointer;" type="button" id="btnAvionPeruInfo" class="button-avion-qatar-naranja" >Infórmate aquí</button>								
						</div> 														
					</div>
				</div>
			</div>
	    
			<div id="popup-avionPeru-nivel" class="overlay-PromSorteo">
				<div class="popup popup-sm-PromSorteo" style="border-radius: 20px;">
					<a class="close-PromSorteo-ta js-close-modal">&times;</a>
					<div class="wrap-modal">
						<div class="gana-PromSorteo-footer" style="border-radius: 20px;">
							<img src="layer-view-image/game/teapuesto/avionPeru/popup-categorias-peru.png" alt="" style="display: block;">
							<div id= "nivel-avionPeru" style="background-color: #d7e2e4;"></div>
						</div> 														
					</div>
				</div>
			</div>	
			
		<div class="nvs-logo-footer"></div>
	</footer>

</body>

<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/game/tinka/tinka-popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/common/tav2-header.js?v=15"></script>
<script type="text/javascript" src="layer-view-script/client/plugins.js?v=<%=Constants.plugins_js%>"></script>
<script type="text/javascript" src="layer-view-script/game/aviondelhincha/hincha-popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/common/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="layer-view-script/client/bannerCookies.js?v=16"></script>
<script type="text/javascript" src="layer-view-script/common/popup_time.js"></script>
<script type="text/javascript" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=10"></script>
<script type="text/javascript" src="layer-view-script/game/teapuesto/avionEstambul/lotto-avionEstambul.js?v=9"></script>
<script>
function getCookieBannerTA(cname) {
	let name = cname + "=";
	let decodedCookie = decodeURIComponent(document.cookie);
	let ca = decodedCookie.split(';');
	for(let i = 0; i <ca.length; i++) {
	  let c = ca[i];
	  while (c.charAt(0) == ' ') {
	    c = c.substring(1);
	  }
	  if (c.indexOf(name) == 0) {
	    return c.substring(name.length, c.length);
	  }
	}
	return "";
}
var p_producto = '${producto}';
function toJuegosVirtuales(producto) {
	//$(document).delegate('#game_tav2_show_menu', 'click', function () {
		$.ajax({
	        type: 'post',
	        url: 'juegos-virtuales-session.html',
	        dataType: 'json',
	        data: "producto="+producto
		}).done(function(d) {
			if(d.message=="OK") {
				window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
			} else $(location).attr('href', d.redireccion);
	    });
	//});
	}

$.ajax({
    type: "POST",
    url: "avion-del-hincha-te-lleva-eliminatorias-peru-verificar-promocion.html",
    dataType: "json",
    async: false,
    success: function (data) {
		if( data.flagPromo ){//participa en la promocion Peru
			if (getCookieBannerTA('popup-avionPeru-nivel') != ""){
				toJuegosVirtuales(p_producto);
			}else{
				toJuegosVirtuales(p_producto);
				
			}
		}else{
			toJuegosVirtuales(p_producto);
		}
    }
});		

</script>

<script type="text/javascript" src="layer-view-script/game/teapuesto/avionPeru/lotto-avionPeru.js?v=4"></script>


</html>