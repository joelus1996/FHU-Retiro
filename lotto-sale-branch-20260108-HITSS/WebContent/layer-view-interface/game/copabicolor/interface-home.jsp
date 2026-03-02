<%@ include file="../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<c:if test="${isLottoSale == true && isGanagolSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=ganagol"/></c:if>
<c:if test="${flagPromoBicolor == 0 }"><c:redirect url="/"/></c:if>
<!DOCTYPE html>
<html lang="es">
<head>

	<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->


    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=1024">
    <title>Juego de apuestas deportivas en Perú - Ganagol </title>
    <meta name='description' content="Ganagol es uno de los juegos de apuestas deportivas más populares de La Tinka, que se enfoca principalmente en los partidos de fútbol locales y nacionales." />
    
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/ganagol/theme.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/ganagol/themeGanagol.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">   

    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    
    <script type="text/javascript" src="layer-view-script/game/ganagol/tagging-ganagol.js"></script>
    
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


    <%@ include file="../../include/header.jspf" %>
    <input type="hidden" value="${clientId}" id="clientId">
    <input type="hidden" value="<%= Constants.flagPromoBicolor %>" id="flagPromoBicolor">
       
    <div class="main-content" style="top: 0px;padding-top: 0px;">   																							
					<div class="main-game copa-casa">
						<img src="layer-view-image/game/copabicolor/Banner-header-desktop.png" style="width: 100%;">
						<h2>Tus jugadas desde S/ 3 realizadas </h2>
						<h2>en la WEB</h2>
						<h3>¡Participan automáticamente!</h3>
						<div class="copa-opciones2">													
							<button style="width: 179px;" type="button" id="btn_desktop_ver_mis_jugadas" onclick="return false;"class="button-copa2" >Ver mis jugadas</button>
						</div>
						<div class="copa-opciones2">													
							<button style="width: 179px;" type="button" id="btn_desktop_como_participar_copa" onclick="return false;"class="button-copa1" >Términos y condiciones</button>											
						</div>	 
						<div class="copa-descripcion">
							<h3>Del martes 21 de junio al domingo 31 de julio del 2022</h3>
						</div>
										
					</div>														
    </div>
    
    <!--  Desarrollo copa bicolor en tu casa DRUIZ no tocar-->
<%-- 	        <div id="popup-copacasa-nivel" class="overlay">
				<div class="popup popup-sm-copacasa">
					<a class="close-copa js-close-modal" href="#">&times;</a>
					<div class="wrap-modal">
						<img src="layer-view-image/game/copabicolor/img-cabecera-popup.png" style="display: block;">
						<div id= "nivel-copa-casa" class="gana-copa-footer-nivel" style="background-color: #007c37"></div>
					</div>
				</div>
			</div> --%>
    
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/copabicolor/lotto-copabicolor.js"></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/captcha.js"></script>
	<%@ include file="../../include/footer.jspf" %>
	
	<script type="text/javascript">

/* Desarrollo copa bicolor en tu casa DRUIZ no tocar*/
$('.popup .js-close-modal').click(function(event){
	$('.overlay.opened').removeClass('opened');
	$('body').removeClass('modal');
});

$(document).on("click", "#btn_desktop_ver_jugadas_copa", function (event) {	 
	   window.location.href = 'premiazoganagol_resultados.html';   
	});

 
$(document).delegate('.btnEnlaceGanagol', 'click', function () {
	window.location.href = 'juega-ganagol.html'; 
});

function toTAV2() {
	$.ajax({
        type: 'post',
        url: 'tav2-session.html',
        dataType: 'json'
	}).done(function(d) {
		if(d.message=="OK") {
			window.open(d.redireccion+"?authToken="+d.authToken,"_parent");
		} else $(location).attr('href', d.redireccion);
    });
}

function openModal(popup,ctrl) {
	$(popup).addClass('opened');
	$('body').addClass('modal');
	if($.trim(ctrl).length>0) control = $.trim(ctrl);
}

		$(document).ready(function(){

			var idsession = $("#clientId").val();
			var flagPromoBicolor = $("#flagPromoBicolor").val();
			if(idsession !== ''){
				$.ajax({
			        type: "POST",
			        url: "verificar_promocion.html",
			        dataType: "json",
			        async: false,
			        success: function (data) {

					var promoBicolor = data.flagPromo;
					
					console.log('participa en la promo : ' +promoBicolor);

						if(promoBicolor == true && flagPromoBicolor == '1'){
							let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
							setTimeout(activarPopupBicolorNivel , timeUp) ; 
						}				
			        }
			    });								   				
			}				    
		});
	
	function activarPopupBicolorNivel(){

		$.ajax({
	        type: "POST",
	        url: "game_premiazoganagol_resultados_popup.html",
	        dataType: "json",
	        async: false,
	        success: function (data) {
	        	var totalTickets = data.nivel;
	        	var puntaje = data.puntajeNivel;
	        	var result = "";
	        	var nivel="";
	        	var activarPremio = data.activarPremio;
	        	var listTickets= data.totalTickets;
	        	var ticketsWin= data.ticketsWin;
	        	console.log('el total de tickets es: '+totalTickets);
	        	console.log('el nivel es: ' +puntaje);

	        	if(activarPremio == 1){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #f0c607; ">¡GANASTE S/ 4 DE SALDO AL INSTANTE!</p><p class="jugadas-popup-descripcion2" style="color:#ffffff;">con tus tickets: '+ticketsWin+'</p></div>';
				}else if (activarPremio == 0){
					result2 = '<p class="jugadas-popup-descripcion" style="color: #ffffff; ">Tus jugadas WEB participan automáticamente</p><p class="jugadas-popup-descripcion2" style="color: #f0c607">¡Son S/ 6,000 en saldo al instante!</p></div>';
				}
				
	        	if(totalTickets >=0 && totalTickets<=9){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Calichin_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CALICHÍN</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;"class="button-copa1" style="width:133px;margin-right: 5px;" >Ver mis jugadas</button>' +
					'<button type="button" onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;" >Juega desde S/ 3</button>';
  
				 	
				}else if(totalTickets >=10 && totalTickets<=29){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Amateur_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">AMATEUR</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;"class="button-copa1" style="width:133px;margin-right: 5px;" >Ver mis jugadas</button>' +
					'<button type="button" onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 3</button>';
 
					 
					
				}else if(totalTickets >=30 && totalTickets<=59){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Crack_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CRACK</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;" class="button-copa1" style="width:133px;margin-right: 5px;">Ver mis jugadas</button>' +
					'<button type="button"  onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 3</button>';
 
				 
					
				}else if(totalTickets >=60){
					result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Leyenda_popup.jpg" class="level-header-copa-casa-popup">' + 
					'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">LEYENDA</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
					'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
					'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' +
					'<button type="button" id="btn_desktop_ver_jugadas_copa" onclick="return false;" class="button-copa1" style="width:133px;margin-right: 5px;">Ver mis jugadas</button>' +
					'<button type="button"  onclick="return false;"class="btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 3</button>';
					 
														
				}

	        	result = result + result2;	
						
				$("#nivel-copa-casa").html(result);
					//if(puntaje != 0){
						checkcount_copa();
					//}
				
				function GetCookie (name) {
					var arg = name + "=";
					var alen = arg.length;
					var clen = document.cookie.length;
					var i = 0;
					while (i < clen) {
					var j = i + alen;
					if (document.cookie.substring(i, j) == arg)
					return getCookieVal (j);
					i = document.cookie.indexOf(" ", i) + 1;
					if (i == 0) break;
					}
					return null;
					}
					function SetCookie (name, value) {
					var argv = SetCookie.arguments;
					var argc = SetCookie.arguments.length;
					var expires = (argc > 2) ? argv[2] : null;
					var path = (argc > 3) ? argv[3] : null;
					var domain = (argc > 4) ? argv[4] : null;
					var secure = (argc > 5) ? argv[5] : false;
					document.cookie = name + "=" + escape (value) +
					((expires == null) ? "" : ("; expires=" + expires.toGMTString())) +
					((path == null) ? "" : ("; path=" + path)) +
					((domain == null) ? "" : ("; domain=" + domain)) +
					((secure == true) ? "; secure" : "");
					}
					function DeleteCookie (name) {
					var exp = new Date();
					exp.setTime (exp.getTime() - 1);
					var cval = GetCookie (name);
					document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
					}

					function amt(){
					var count_copa_desktop = GetCookie('count_copabicolor_desktop')
					if(count_copa_desktop == null) {
					SetCookie('count_copabicolor_desktop','1')
					return 1
					}
					else {
					var newcount = parseInt(count_copa_desktop) + 1;
					DeleteCookie('count_copabicolor_desktop')
					SetCookie('count_copabicolor_desktop',newcount,exp)
					return count_copa_desktop
					}
					}
					function getCookieVal(offset) {
					var endstr = document.cookie.indexOf (";", offset);
					if (endstr == -1)
					endstr = document.cookie.length;
					return unescape(document.cookie.substring(offset, endstr));
					}

					function checkcount_copa() {
					var count_copa_desktop = GetCookie('count_copabicolor_desktop');
					if (count_copa_desktop == null) {
						var expDays = 2;
						localStorage.removeItem("exp_copabicolor_desktop_nivel");
						var exp = new Date();
						exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
						//exp.setTime(exp.getTime() + (expDays*5*60*1000));
						count_copa_desktop=1;
						SetCookie('count_copabicolor_desktop', count_copa_desktop, exp);
						localStorage.setItem("exp_copabicolor_desktop_nivel", exp);
						openModal("#popup-copacasa-nivel", "");
						

					}
					else {
					count_copa_desktop++;
					var auxExp = localStorage.getItem("exp_copabicolor_desktop_nivel");
					try{
						SetCookie('count_copabicolor_desktop', count_copa_desktop, auxExp);
					}catch (e) {
						console.log(e.message);
						
					}			
					
					}
					}
				

	        	
	        }
	   });	
		
		
	}	


</script>

</body>
</html>