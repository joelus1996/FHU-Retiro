<%@ include file="/layer-view-interface/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="es">
<head>
<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
<script>
window.onload = function () {
	try{
	if(document.getElementById("clientId").value){
		dataLayer.splice(0,1,{
			'loginStatus': 'Sesión iniciada',
			'clientid': getClientID(),
			'userID': document.getElementById("clientId").value,
			});
	}
	}catch(e){}
}
</script>
	<!-- Google Tag Manager -->
	<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
	new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
	j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
	'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
	})(window,document,'script','dataLayer','GTM-58FNN4L');</script>
	<!-- End Google Tag Manager -->
	<script type="application/ld+json">
	{
  		"@context": "https://schema.org",
  		"@type": "Corporation",
  		"name": "La Tinka",
  		"url": "https://m.latinka.com.pe/home.html",
  		"logo": "https://www.latinka.com.pe/p/layer-view-image/v2/landing/svg/tinka.svg",
  		"sameAs": [
  		 	"https://www.facebook.com/LaTinkaLoterias",
    		"https://twitter.com/LaTinkaLoterias",
    		"https://www.instagram.com/latinka_loterias/",
    		"https://www.linkedin.com/company/latinka/",
			"https://www.tiktok.com/@latinka_loterias?lang=es"
  		]
	}
	</script>
	<meta property="og:title" content="La Tinka: La lotería líder del Perú | Loterías, Apuestas y Casino">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://m.latinka.com.pe/p/">
	<meta property="og:description" content="La Tinka es la compañía líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto.">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://www.latinka.com.pe/p/layer-view-image/v2/landing/svg/tinka.svg">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html">
    <title>La Tinka: La lotería líder del Perú | Loterías, Apuestas y Casino</title>
    <meta name='description' content="La Tinka es la compañía líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto." />	
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constantes.styles_css%>" type="text/css" />
	<link rel="stylesheet" href="layer-view-style/common/popModal.css?v=<%=Constantes.popModal_css%>" type="text/css"/>
	
    <link rel="shortcut icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png" type="image/x-icon">
    <link rel="apple-touch-icon" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
    <link rel="icon" type="image/png" sizes="192x192" href="http://latinkaportal.com.pe/wp-content/uploads/2025/11/icono_tk.png">
	<meta name="robots"  content="index,follow" /> 

	<!-- Twitter conversion tracking base code -->
	<script>
	!function(e,t,n,s,u,a){e.twq||(s=e.twq=function(){s.exe?s.exe.apply(s,arguments):s.queue.push(arguments);
	},s.version='1.1',s.queue=[],u=t.createElement(n),u.async=!0,u.src='https://static.ads-twitter.com/uwt.js',
	a=t.getElementsByTagName(n)[0],a.parentNode.insertBefore(u,a))}(window,document,'script');
	twq('config','ogi8m');
	</script>
	<!-- End Twitter conversion tracking base code -->
	
</head>
<body><!-- version: combos tk,kb,gd -->
	<!-- Google Tag Manager (noscript) -->
	<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-58FNN4L"
	height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
	<!-- End Google Tag Manager (noscript) -->
	<h1 style="display: none;">La Tinka</h1>
	<c:set var="lapollaEnabled"><%=Boolean.valueOf(Constantes.lapollaEnabled.trim()).booleanValue()%></c:set>
	<c:set var="tav2Enabled"><%=Boolean.valueOf(Constantes.tav2Enabled.trim()).booleanValue()%></c:set>
	<c:set var="bannersUrl"><%=Constantes.bannersUrl.toString().trim()%></c:set>
	<c:set var="gamesXML"><%=Constantes.gamesXML.toString().trim()%></c:set>
	<input type="hidden" id="tutorialVisible" value='${tutorial.visible}'>
	<input type="hidden" id="totalTicket" value='${totalTicket}'>
	<input type="hidden" value="<%= Constantes.flagPromoBicolor %>" id="flagPromoBicolor">
	<input type="hidden" value="Home" id="TipoZona">
	<input type="hidden" value="Home" id="Zona">
	<input type="hidden"  id="SubZona">
	<input type="hidden" id="closeSession" name="closeSession" value="${closeSession}">
	<input type="hidden" id="urlTA" name="urlTA" value="${urlTA}">
	<input type="hidden" id="tycPdpInitLogin" value="${tycPdpInitLogin}">
	
	<%
		session.removeAttribute("urlTA");
	%>
	<%-- <input type="hidden" value="<%= Constantes.flagPromoTinka %>" id="flagPromoTinka"> --%>
			
	<div class="container">

		<jsp:include page="../include/header.jsp" />
		<input type="hidden" id="visanetTransaction" value="<c:out value='${visanetTransaction}'/>">
		
		<div id="mensajeNotificacion">
			
		</div>
		
		<div class="modalpp">
		<div class="ioverlay" id="modal-pp-informativo">
	      <div class="modal is-error">
	        <div class="modal__head">¡Ahora es más fácil retirar tus premios de Tinka, Kábala, Ganagol, Gana Diario y Kinelo!</div>
	        <div class="modal__boby" style="padding-bottom: 20px;" >  
	        	<div id="textoParte1">
	        		<ul>
						<li><b>Premios menores a S/10,000:</b> se cargarán automáticamente a tu saldo y los podrás cobrar cuando y como prefieras desde la sección "Retirar premios".</li><br>
						<li><b>Premios desde S/10,000:</b> los podrás cobrar a través de una transferencia bancaria desde la sección "Retirar premios"</li>    	
		        	</ul>
	        	</div>
	        	<div id="textoParte2" style="display: none;">
	        		<ul>
						<li><b>Jugadas Gratis:</b> se abonarán automáticamente como saldo a la sección "Jugadas Gratis" para que puedas jugarlo en cualquier momento.</li><br>
						<li><b>Todos los premios de Kinelo:</b> se cargarán automáticamente a tu saldo y los podrás cobrar desde la sección "Retirar premios"</li>    	
		        	</ul>
	        	</div>
	        	<div style="text-align: right;" id="opcionParte1">
	        		<span class="mod__text4 is-charge" text-down="Ver menos" text-up="Ver más" onclick="verParte2()">Ver más</span>
	        	</div>
	        	<div id="opcionParte2" style="display: none;">
	        		<div style="text-align: left; margin-top: 24px; margin-left: 23px;" >
	        			<span class="mod__text4 is-regresar" style="padding-left: 20px;" onclick="verParte1()">Volver</span>
	        		</div>
	        		<div style="text-align: right; width: 100%;">
	        			<span><button class="btn btn-popup" style="background: #e30613; border: 2px solid #e30613; color: #fff; box-shadow: none; width: 158px; display: initial; margin-left: 0px;" onclick="cerrarModalInformativo()">ENTENDIDO</button></span>
	        		</div>
	        	</div>
	        </div>
	      </div>
	    </div>
	    </div>
		
		<div class="content-wrap">
			<div class="content">
				<section class="main-section">
					<div class="main-home">						
						<div class="main-brands">
							<div class="row">
								<c:if test="${lapollaEnabled}">
								<div class="w-100 bb-gray">
									<a href="#" class="main-brand" id="game_lapolla_show_menu" onclick="datalayerGameOption(this)">
										<div class="main-brand-content">
										<figure class="main-img">
											<img src="layer-view-image/v2/banner-lapolla-te-apuesto.png" style="margin-bottom: 10px; max-height: none;" />
										</figure>
										</div>
									</a>
								</div>
								</c:if>

								<div class="w-100 bb-gray">
									<a href="#" class="main-brand" id="btn_mobile_tinka_home" onclick="datalayerGameOption(this)">
										<div class="main-brand-content">
										<figure class="main-img" style="height: 64px;">
											<img src="layer-view-image/v2/logo-tinka.png?v=3" alt="tinka" style="margin: 0px;" />
										</figure>
										<span class="brand-desc">Pozo Millonario</span><br />
										<span class="brand-price" id="pozo-tinka"></span>
										</div>
									</a>
								</div>
								<div class="w-50 br-gray  bb-gray">
									<a href="#" class="main-brand" id="btn_mobile_kabala_home" onclick="datalayerGameOption(this)">
										<div class="main-brand-content">
										<figure class="main-img">
											<img src="layer-view-image/v2/logo-kabala.png" alt="resultados kabala" />
										</figure>
										<span class="brand-desc">Pozo Buenazo</span><br />
										<span class="brand-price" id="pozo-kabala"></span>
										</div>
									</a>
								</div>
								<div class="w-50 bb-gray">
								    <a href="#" class="main-brand" id="btn_mobile_ganadiario_home" onclick="datalayerGameOption(this)">
								    	<div class="main-brand-content">
										<figure class="main-img">
											<img src="layer-view-image/v2/logo-ganadiario.png" alt="tinka" />
										</figure>
										<span class="brand-desc">Premio Diario</span><br />
										<span class="brand-price" id="pozo-ganadiario"></span>
										</div>
									</a>
									
								</div>
								<div class="w-50 br-gray bb-gray">
									<a href="#" class="main-brand" id="btn_mobile_videoloteria_home" onclick="datalayerGameOption(this)">
										<div class="main-brand-content">
										<figure class="main-img">
											<img src="layer-view-image/v2/logo-videoloterias.png?v=2" alt="tinka" style="max-height: 95px;" />
										</figure>
											<span class="brand-desc">Juega y gana al instante</span><br>
										</div>
									</a>
									
								</div>
								<div class="w-50 bb-gray">
									<a href="#" class="main-brand" id="btn_mobile_kinelo_home" onclick="datalayerGameOption(this)">
										<div class="main-brand-content">
										<figure class="main-img">
											<img src="layer-view-image/v2/logo-kinelo.png" alt="tinka" />
										</figure>
										<span class="brand-desc">Gana cada</span><br />
										<span class="brand-price">5 minutos</span>
										</div>
									</a>
								</div>
								<div class="w-50 br-gray bb-gray">
									<a href="#" class="main-brand" id="btn_mobile_ganagol_home" onclick="datalayerGameOption(this)">
										<div class="main-brand-content">
										<figure class="main-img">
											<img src="layer-view-image/v2/logo-ganagol.png" alt="tinka" />
										</figure>
 										<span class="brand-desc">Gana pozo de</span><br />
 										<span class="brand-price" id="pozo-ganagol"></span>
										</div>
									</a>
								</div>
								<div class="w-50 bb-gray">
									<a href="#" class="main-brand" id="btn_mobile_teapuesto_home" onclick="datalayerGameOption(this)">
										<div class="main-brand-content">
										<figure class="main-img ta">
											<img src="layer-view-image/v2/logo-teapuesto-pe.png?v=2" alt="tinka" src="layer-view-image/v2/logo-teapuesto-pe.png?v=2" style="max-height: 74px;margin-top: -21px;"/>
										</figure>
<!-- 										<span class="brand-desc">Tu juego, tu pasión</span> -->
										</div>
									</a>
								</div>														
								<div>
							</div>
						</div>
					</div>
				</section>
			    <c:if test="${lapollaEnabled}">
				<div class="w-100 bb-gray">
				  
				<aside id="bannerp">
				    <div class="swiper-container">
				        <div class="swiper-wrapper"></div>
				        <div class="swiper-pagination"></div>
				    </div>
			    </aside>
			    
			    </div>
			    </c:if>
			    <div class="w-100 bb-gray">
			   
				<aside id="banner">
				    <div class="swiper-container">
				        <div class="swiper-wrapper"></div>
				        <div class="swiper-pagination"></div>
				    </div>
			    </aside>
			   
			    </div>
				<footer id="footer">
					<div class="content-footer">
						<div class="text-terms">
<!-- 							<a class="js-modal" href="#popup_terms" data-modal="#popup_terms">Ver Términos y Condiciones</a> -->
							<a class="link link__base" href="<%= Constantes.URL_QW%>/terminos-y-condiciones/" target="_blank" >Ver Términos y Condiciones</a>
						</div>
						<div class="footer-text">La Tinka S.A. RUC 20506035121<br>Juegos sólo para mayores de 18 años.<br>Infórmate del reglamento de los juegos 
                <a href="<%=Constantes.URL_QW%>/reglamentos/" target="_blank" style="color: #07663a; text-decoration: underline; font-weight: bold;">aquí</a> 
                o en<br>nuestros puntos de venta.<br>Los juegos y apuestas deportivas a distancia realizados en exceso pueden causar ludopatía.</div>
					</div>
					<div class="main-methods bt-gray">
						<img src="layer-view-image/v2/paid-methods_latinka02.png?v=1" style="height: auto;">
					</div>
					<div class="main-methods bt-gray">
						<a href="libro-reclamaciones.html" target="_self">
							<img src="layer-view-image/client/book/linkbook.png" alt="tinka" style="height: 49px;width: 84px; margin-bottom: 20px;">
						</a>
						<br>
						<img src="layer-view-image/v2/wla-certified-latinka.png" style="height: auto;" onclick="redirectWLA();">
						<img src="layer-view-image/v2/+18.svg" style="margin-left: 45px; margin-right: 20px;">
						<br>
						<img src="layer-view-image/v2/latinka_iso9001.png" style="height: auto; margin-top: 30px; margin-right: 10px;">
						<img src="layer-view-image/v2/latinka_iso37001.png" style="height: auto; margin-top: 30px; margin-left: 10px;">
						<img src="layer-view-image/v2/latinka_iqnet.png" style="height: auto; margin-top: 30px; margin-left: 10px;">
						<br>
						<a href="https://apuestasdeportivas.mincetur.gob.pe/" target="_self">
                        	<img src="layer-view-image/v2/logo_mincetur.png" alt="Logo Mincetur" style="height: auto; max-width: 170px;margin-top: 25px;" >
                        </a>
						<br><br><br><br>
					</div>
					<br>
					
					<div id="popup_terms" class="overlay">
						<div class="popup popup-sm">
							<a class="js-close-modal close" href="#">&times;</a>
							<div class="wrap-modal">
								<jsp:include page="../client/interface-term.jsp"/>
							</div>
						</div>
					</div>
					<div id="popup-bond" class="overlay">
						<div class="popup popup-sm">
							<a class="close js-close-modal" href="#">&times;</a>
							<div class="wrap-modal"></div>
						</div>
					</div>
					 					
<!-- 					<div id="popup-copacasa-nivel" class="overlay"> -->
<!-- 						<div id = "popup-scrool-copa2" class="popup popup-sm-copacasa margen2"> -->
<!-- 							<a class="close-copa js-close-modal" href="#">&times;</a> -->
<!-- 								<div class="wrap-modal"> -->
<!-- 									<div class="gana-copa-header"> -->
<!-- 										<img class="img-logo-teapuesto-popup" src="layer-view-image/game/copaentucasa/logo-teapuesto.gif"> -->
<!-- 										<div class="descripcion-copa-casa"> -->
<!-- 											<span>¡GANA CON</span><br> -->
<!-- 											<span>LA COPA EN TU CASA!</span> -->
<!-- 										</div> -->
<!-- 									</div> -->
								
<!-- 									<div id= "nivel-copa-casa" class="gana-copa-footer-nivel"> -->
										
<!-- 									</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->


					<%--  <div id="popup-copacasa-nivel" class="overlay">
						<div id = "popup-scrool-copa2" class="popup popup-sm-copacasa margen2">
							<a class="close-copa js-close-modal" href="#">&times;</a>
								<div class="wrap-modal">
									<img src="layer-view-image/game/copabicolor/img-cabecera-popup.png" style="display: block;"> 
									<div id= "nivel-copa-casa" class="gana-copa-footer-nivel" style="background-color: #007c37">
										
									</div>																		
							</div>
						</div>
					</div>  --%>
					
				</footer>
			</div>
		</div>
	</div>
	
	<div id="alert_content" style="display:none">
		<div id="alertModal_content_id" class="confirmModal_content"></div>
		<div class="confirmModal_footer_alert">
			<button type="button" class="dialog d-btn d-btn-primary" data-confirmmodal-but="ok">OK</button>
		</div>
	</div>

	<div id="popup-message-session" class="overlay">
		<div class="popup popup-sm recuperar-password">								
			<a class="close-popup " id="close-popup-session" onclick="closePopupMessageLoggin()">&times;</a>
			<div class="main-modal" id="msg-session"></div>			
		</div>
	</div>

	<jsp:include page="../include/footer.jsp" />

	<script type="text/javascript" src="layer-view-script/v2/swiper.min.js"></script>
	<script type="text/javascript" src="layer-view-script/funcionesTaggingRecargas.js?v=4"></script>
	<script type="text/javascript">
		//if("<c:out value='${welcomeBonusMessagePor}' />" != "") {
		//	var msgtext = '<c:out value="${welcomeBonusMessagePor}" escapeXml="false" />';
		//	$('#popup-bond .wrap-modal').html(msgtext);
        //	openModal("#popup-bond", "");
		//}
		
		var promosSorteo = {
			"popup-juegaGanaVirtuales-nivel" : false,
			"popup-avionPeru-nivel" : false
		};
		
		function verParte2(){
			$("#textoParte1").css("display","none");
			$("#textoParte2").css("display","block");
			$("#opcionParte1").css("display","none");
			$("#opcionParte2").css("display","flex");
		}
		
		function verParte1(){
			$("#textoParte2").css("display","none");
			$("#textoParte1").css("display","block");
			$("#opcionParte2").css("display","none");
			$("#opcionParte1").css("display","block");
		}
		
		function cerrarModalInformativo(){
			$('#modal-pp-informativo').fadeOut(250);
			getLastNotifications();
		}
		
		function cerrarMensajeNotificacion(){
			$('#mensajeNotificacion').fadeOut(250);
		}
		
		function redirectWLA(){
			window.open("https://www.world-lotteries.org/services/industry-standards/security-and-risk-management/certified-lotteries?q=la+tinka","_self");
		}
		
		function tutorialInit(){
			$('.tutorial_hands').addClass('active');
			$('.close-menu-not-wrap').addClass('active');
			setTimeout(function(){
				$('.tutorialS').eq(0).addClass('active');
			},300);
			setTimeout(function(){
				$('.tutorialS').eq(0).removeClass('active');
			},1000);
			setTimeout(function(){
				$('.tutorialS').eq(1).addClass('active');
			},1700);
			setTimeout(function(){
				$('.tutorialS').eq(1).removeClass('active');
			},2400);
			setTimeout(function(){
				$('.tutorialS').eq(2).addClass('active');
			},3100);
			setTimeout(function(){
				$('.tutorialS').eq(2).removeClass('active');
			},3800);
			setTimeout(function(){
				$('.tutorial_hands').removeClass('active');
				$('.close-menu-not-wrap').removeClass('active');
			},4500);
		}

		function validarPromosActivarEvalPopupInformativo(promo){

			promosSorteo[promo] = true;

			let enciendePopup = true;
			
			for(var clave in promosSorteo){
				if( promosSorteo[clave] !== true ){
					enciendePopup = false;
					continue;
				}
			}
			
			if( !enciendePopup ) return;

			evalPopupInformativo();
		}
		
		function evalPopupInformativo(){
			$.ajax({
				type: "POST",
				url: "evalPopupInformativo.html",
				dataType: "json",
				async: false,
			})
		    .done(function(data) {
		    	if(data.status=='OK'){
				    $('#modal-pp-informativo').fadeIn(350);
				}else{
					getLastNotifications();
				}
		    })
		    .fail(function(jqXHR, textStatus, errorThrown) {
		    	console.log(textStatus||' '||errorThrown);
		    });
		}
		
		function getLastNotifications(){
			$.ajax({
		        type: "POST",
		        url: "getLastNotifications.html",
		        dataType: "json",
		        async: false
			})
			.done(function(data) {
				var htmlNotificaciones = '';
				if(data.status=="OK"){
					$.each(JSON.parse(data.lastNotifications), function( key,value ) {
						if(value.type!=undefined && value.type!=null){
							//htmlNotificaciones+='<div style="margin-left: 20px; margin-right: 20px; position: fixed; top: 44px; z-index: 10;">';
							htmlNotificaciones+='<div style="margin-left: 3%; margin-right: 3%; position: fixed; top: 44px; z-index: 10; width: 94%;">';
							//htmlNotificaciones+='<div style="width: 0; height: 0; position: absolute; top: 8px; margin-left: 315px; border-top: 8px solid transparent; border-bottom: 8px solid transparent; transform: rotate(90deg); border-right: 15px solid white;"></div>';
							htmlNotificaciones+='<div style="width: 0; height: 0; border-top: 8px solid transparent; border-bottom: 8px solid transparent; transform: rotate(90deg); border-right: 15px solid white; float: right; margin-right: 14px; margin-top: 7px;"></div>';
							//htmlNotificaciones+='<span onclick="cerrarMensajeNotificacion()" style="float: right; color: green; margin-top: 30px; margin-right: 8px; font-size: 12px; cursor: pointer;">X</span>';
							htmlNotificaciones+='<span onclick="cerrarMensajeNotificacion()" style="float: right; color: green; margin-top: 26px; margin-right: -10px; font-size: 12px; cursor: pointer;">X</span>';
							htmlNotificaciones+='<div style="margin-top: 20px; margin-bottom: 5px; box-shadow: 0px 2px 5px grey; padding: 10px; background: white; padding-top: 20px;">';
							htmlNotificaciones+='<div style="float: left;">';
							if(value.type!=4){
								htmlNotificaciones+='<svg viewBox="0 0 18 18"  xmlns="http://www.w3.org/2000/svg" style="width: 13px; height: 13px;">';
								htmlNotificaciones+='<path d="M16.418 4.219h-2.146c.332-.441.529-.99.529-1.582A2.64 2.64 0 0 0 12.164 0c-.876 0-1.521.314-2.032.987-.428.564-.74 1.351-1.132 2.345-.392-.994-.704-1.78-1.132-2.345C7.358.314 6.712 0 5.836 0a2.64 2.64 0 0 0-2.637 2.637c0 .593.197 1.14.529 1.582H1.582C.71 4.219 0 4.929 0 5.8v1.054c0 .688.44 1.274 1.055 1.492v8.071c0 .872.71 1.582 1.582 1.582h12.726c.873 0 1.582-.71 1.582-1.582V8.347A1.585 1.585 0 0 0 18 6.855V5.801c0-.873-.71-1.582-1.582-1.582zm-6.45-.466c.808-2.05 1.115-2.698 2.196-2.698.872 0 1.582.71 1.582 1.582 0 .872-.71 1.582-1.582 1.582h-2.38l.184-.466zM5.836 1.055c1.081 0 1.388.648 2.196 2.698l.184.466h-2.38c-.872 0-1.582-.71-1.582-1.582 0-.873.71-1.582 1.582-1.582zm1.055 15.89H2.637a.528.528 0 0 1-.528-.527v-7.98h4.782v8.507zm0-9.562H1.582a.528.528 0 0 1-.527-.528V5.801c0-.291.236-.528.527-.528h5.309v2.11zm3.164 9.562h-2.11V5.273h2.11v11.672zm5.836-.527c0 .29-.237.527-.528.527H11.11V8.437h4.782v7.981zm1.054-9.563c0 .291-.236.528-.527.528h-5.309v-2.11h5.309c.29 0 .527.237.527.528v1.054z" fill="#e02120"/>';
								htmlNotificaciones+='</svg>';
							}else{
								htmlNotificaciones+='<svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg" style="width: 13px; height: 13px;">';
								htmlNotificaciones+='<circle cx="12" cy="12" r="10" fill="none" stroke="#e02120" stroke-width="2"/><text x="12" y="17" font-size="13" font-weight="bold" fill="#e02120" text-anchor="middle">i</text>';
								htmlNotificaciones+='</svg>';
							}
							htmlNotificaciones+='</div>';
							if(value.type==1){
								htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
								htmlNotificaciones+='<b>¡Felicidades tienes premios!</b><br>';
								htmlNotificaciones+='<span>Revisa los movimientos de tu cuenta y, si aún tienes saldo disponible, recuerda que puedes seguir jugando o retirarlo cuando quieras.</span><br>';
								htmlNotificaciones+='</p>';
								htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
								htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
								htmlNotificaciones+='</div>';
							}else if(value.type==2){
								htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
								htmlNotificaciones+='<b>¡Felicidades tienes un premio mayor de '+value.game+'!</b><br>';
								htmlNotificaciones+='<span>Cóbralo antes de que venza el plazo de cobro. Hasta '+value.expirationDate+'</span><br>';
								htmlNotificaciones+='</p>';
								htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
								htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
								htmlNotificaciones+='</div>';	
							}else if(value.type==3){
								htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
								htmlNotificaciones+='Tu retiro N° '+value.requestNumber+' ya está en tu cuenta '+value.requestType+'<br>';
								htmlNotificaciones+='<span>Revisa los movimientos de tu cuenta '+value.requestType+' o tu historial de retiros</span><br>';
								htmlNotificaciones+='</p>';
								htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
								htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
								htmlNotificaciones+='</div>';
							}else if(value.type==4){
								htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px; color:#E02120;">';
								htmlNotificaciones+='<b>Tu contraseña expira en 5 días</b></p>';
								htmlNotificaciones+='<p style="margin-top: 0px; font-size: 12px; margin-left: 20px;">';
								htmlNotificaciones+='<span>Actualizalo ahora, ingresando a Mi Perfil</span><br>';
								htmlNotificaciones+='</p>';
								htmlNotificaciones+='<div style="text-align: right;" id="irNotificaciones">';
								htmlNotificaciones+='<a href="notificaciones.html" style="color: #00d4f8; text-decoration: underline; font-size: 12px;">Ver todos ></a>';
								htmlNotificaciones+='</div>';
							}
							htmlNotificaciones+='</div>';
							htmlNotificaciones+='</div>';
						}
						return false;
					});
				}
				$("#mensajeNotificacion").html(htmlNotificaciones);
			})
			.fail(function( jqXHR, textStatus, errorThrown ) {
		    	
		    });
		}
 
		$(document).ready(function(){
			if ($("#tycPdpInitLogin").val() == "1") {
				// Se valida si el usuario tiene documentos pendientes de confirmación, el parámetro que recibe
			  	// es una function que se realizará en caso no tenga docs pendientes de confirmacion(solo después del login)
			  	mainValidatePendingsDocsForAproval('documentReadyFunctionsHomeUser');
			} else {
				documentReadyFunctionsHomeUser();
			}
		});

		function documentReadyFunctionsHomeUser(){
			var urlTA = $('#urlTA').val();
        	if(urlTA!=''){
        		fetch(urlTA)
			    .then(response => {
			    })
			    .catch(error => {
			    });
            }
			var closeSession = $('#closeSession').val();
        	if(closeSession!=''){
        		var titulo = "Sesi&oacute;n expirada";
        		var mensaje = "Por tu seguridad tu sesi&oacute;n ha finalizado. Vuelve a iniciar sesi&oacute;n ";
        		var msgError = '<div class="mensaje-confirmacion-password"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"></div><span class="mensaje-recuperar-password">'+titulo+'</span><br><br>'+
            	'<p class="descripcion-ok"">'+mensaje+'</p><br><br>'+
                '<button class="button button-orange-light no-margin green" onclick="validateSession2(); getFastTokenAndRedirect();" type="button" style="width: 100%;">Ingresar</button></div>';
                $('#close-popup-session').hide();
                $('#msg-session').html(msgError);
            	openModal("#popup-message-session","");
            }
			
			//exe.openChat();
			console.log($('#tutorialVisible').val());
			if($('#tutorialVisible').val()!=undefined && $('#tutorialVisible').val()!=null && $('#tutorialVisible').val()=='true'){
				tutorialInit();
			}
			
			$.ajax({
				type: "POST",
				url: "offTutorial.html",
				dataType: "json",
				async: false,
				success: function (data) {}
			});
						
			//Desarrollo copa en tu casa DRUIZ no tocar
			
			window.addEventListener("orientationchange", ()=> {
				console.log(window.screen.orientation.type);
			    console.log('cambio horientazion');
			    if(window.screen.orientation.type == "landscape-primary"){
			    	console.log('quita margen');
			    	$('#popup-scrool-copa2').removeClass("margen2");
			    	
				 }else if(window.screen.orientation.type == "portrait-primary" ){
					 $('#popup-scrool-copa2').addClass("margen2");
				 }
			});
		
		
			$(document).delegate('#btn_mobile_ingresar_copacasa', 'click', function () {			
					 window.location.href = 'lacopaentucasa.html';		   
			});
			
						
			var idsession = $("#clientId").val();
			var flagPromoBicolor = $("#flagPromoBicolor").val();
											   				

			var ban = localStorage.getItem("ban");
			if(ban=="OK"){
				localStorage.removeItem("ban");
				var msgError = '<div style="font-family: \'Roboto\';"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"><p style="text-align: center;margin: 0px; line-height: 20px;"><b>Detectamos una irregularidad en tu cuenta</b><br><br>Por tu seguridad y de acuerdo con lo establecido en los T&C tu cuenta está bloqueada temporalmente.</p></div><br><br>'+
				'<button class="btn btn-recuperar-password" onclick="closePopupMessageLoggin()" type="button">OK</button></div>'; 
				$('#msg-session').html(msgError);
				openModal("#popup-message-session","");
			}
						
			if($('#visanetTransaction').val()!=null && $('#visanetTransaction').val()!=""){
	        	var visanetTransaction = $.parseJSON($.trim($('#visanetTransaction').val()));
	        	var resultKey = visanetTransaction.resultKey;
	        	var resultMessage = visanetTransaction.resultMessage;
	        	var promotionMessage = visanetTransaction.promotionMessage;
	        	var actbono = visanetTransaction.actbono;
	        	var actwbbono = visanetTransaction.actwbbono;
	        	var monto = visanetTransaction.monto;
	        	
	    		if(resultKey=='OK'){	
	    			var commissionAmount = visanetTransaction.commissionAmount;
	    			var arrayResultMessage = resultMessage.split("|");
	    			tagginSaldoEEpurchase(arrayResultMessage[2], monto);
	    			var rptaTransaccion = "";
	    			var result = "";
	    			rptaTransaccion+="<br>Nº Transacción:"+arrayResultMessage[2];
	    			rptaTransaccion+="<br>Visa:"+arrayResultMessage[4];
	    			rptaTransaccion+="<br>"+arrayResultMessage[3];
	    			if(commissionAmount>0){
	    				rptaTransaccion+="<br>Comisión por recarga con Tarjeta Visa: S/ "+floatFormat(commissionAmount);
        			}
	    			rptaTransaccion+='<br><br><span style="font-size: 11px;">Te recomendamos capturar la confirmación de la recarga ante cualquier inconveniente.</span>';
	    			
	    			if (promotionMessage == "" || promotionMessage == null || promotionMessage == undefined) {
	    				promotionMessage = "";
	    			}
	    			
	    			if($.trim(actbono).includes('true-casino') || $.trim(actbono)=='true') {
	                    if (promotionMessage.includes("insuficiente") == true ) {
	                    	result = '<p style="text-align: justify;margin: 0px;">'+promotionMessage + '<br><br>La recarga ha sido abonada a su saldo principal.<br>Monto cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+'<br>'+rptaTransaccion+"</p>";
	                    } else {      
	                    	result = '<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente <br>' + promotionMessage+'<br>'+rptaTransaccion+"</p>";
	                    }
	                } else {
	                	if($.trim(promotionMessage)!=='') {
	                		promotionMessage="<br>"+promotionMessage+"<br>";
	                	}else{
	                		promotionMessage="<br>";
	                	}
	                	result = '<p style="text-align: justify;margin: 0px;">'+'Su recarga se ha realizado exitosamente <br>Saldo cargado: <span style="font-weight: bold;">S/ '+floatFormat(monto)+"</span>"+ promotionMessage + rptaTransaccion+"</p>";
	                }
	    			
			    	$.ajax({
				        type: "POST",
				        url: "resetVisanetTransaction.html",
				        dataType: "json",
				        async: false,
				        success: function (data) {
				        	$("#visanetTransaction").val("");
				        }
					});
	    			
	    			$("#alertModal_content_id").html(result);
				    $("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: 
				    	function(event, el) {

				    	} 
				    });
				}else{
					var arrayResultMessage = resultMessage.split("|");
					var rptaTransaccion = "";
					rptaTransaccion+= "<br>"+arrayResultMessage[1];
					rptaTransaccion+= "<br>Nº Transacción:"+arrayResultMessage[2];
					rptaTransaccion+= "<br>"+arrayResultMessage[3];
					tagginSaldoErrorRecarga('Internet Visa', rptaTransaccion);
					$.ajax({
				        type: "POST",
				        url: "resetVisanetTransaction.html",
				        dataType: "json",
				        async: false,
				        success: function (data) {
				        	$("#visanetTransaction").val("");
				        }
					});
					
					$("#alertModal_content_id").html('<p style="text-align: justify;margin: 0px;">'+rptaTransaccion+"</p>");
				    $("#alert_content").confirmModal({top : '30%', type : 'modal',  onOkBut: 
				    	function(event, el) {
					    	
				    	} 
				    });
				}
			}
			
			$.ajax({
			  url: "${gamesXML}", //Produccion SSL
			  cache: false,
			  success: function(res) {
			  	var xmlDoc = res;
			  	data = xmlDoc.getElementsByTagName("data");
			  	if (data[0]) {
			  		data = data[0];
			  		var pozo_tinka = data.getElementsByTagName("tk_pozo")[0].childNodes[0].nodeValue;
			  		$("#pozo-tinka").html("S/ " + pozo_tinka);
			  		var pozo_kabala = data.getElementsByTagName("kb_pozo")[0].childNodes[0].nodeValue;
			  		$("#pozo-kabala").html("S/ " + pozo_kabala);
			  		var pozo_ganagol = data.getElementsByTagName("gg_pozo")[0].childNodes[0].nodeValue;
			  		$("#pozo-ganagol").html("S/ " + pozo_ganagol);
			  		var pozo_ganadiario = data.getElementsByTagName("gd_premio")[0].childNodes[0].nodeValue;
			  		$("#pozo-ganadiario").html("S/ " + pozo_ganadiario);

			  		if(pozo_ganagol === 'POZO ACUMULADO POR DEFINIR' ){
			  			var last_pozo_ganagol = data.getElementsByTagName("gg_last_pozo")[0].childNodes[0].nodeValue;
			  			$("#pozo-ganagol").html("S/ " + last_pozo_ganagol);
				  		};
			  	} else {
			  		console.log('no data')
			  	}

			  }, error: function(e) {
			  	console.log('error obteniendo xml...')
			  }
			});
			
// 			$("#pozo-tinka").html(" ");
// 	  		$("#pozo-kabala").html(" ");
// 	  		$("#pozo-ganagol").html(" ");
// 	  		$("#pozo-ganadiario").html(" ");
			
			
	      	$.ajax({
	      	  url: "${bannersUrl}banners.xml",
	      	  cache: false,
	      	  success: function(res) {
	      	  	var xmlDoc = res;
	      	  	var data = xmlDoc.getElementsByTagName("data");
	      	  	if (data && data[0]) {
	      	  		data = data[0];
	      	  		var banners = data.getElementsByTagName("banner");

	      	  		createBanner(banners, '#banner .swiper-wrapper');

		    	  	var swiper = new Swiper('#banner .swiper-container', {
	              		pagination: '#banner .swiper-pagination',
	              		paginationClickable: true,
	              		autoplay: 2500,
	              		autoplayDisableOnInteraction: false,
	              		// autoplayStopOnLast: true,
	              		loop: true
		          	});
		          	
	      	  	} else {
	      	  		console.log('no data')
	      	  	}

	      	  }, error: function(e) {
	      	  	console.log('error obteniendo xml...')
	      	  }
	      	});

	      	$.ajax({
		      	  url: "${bannersUrl}bannersp.xml",
		      	  cache: false,
		      	  success: function(res) {
		      	  	var xmlDoc = res;
		      	  	var data = xmlDoc.getElementsByTagName("data");
		      	  	if (data && data[0]) {
		      	  		data = data[0];
		      	  		var banners = data.getElementsByTagName("banner");

		      	  		createBanner(banners, '#bannerp .swiper-wrapper');

			    	  	var swiper = new Swiper('#bannerp .swiper-container', {
		              		pagination: '#bannerp .swiper-pagination',
		              		paginationClickable: true,
		              		autoplay: 2500,
		              		autoplayDisableOnInteraction: false,
		              		// autoplayStopOnLast: true,
		              		loop: true
			          	});
			          	
		      	  	} else {
		      	  		console.log('no data')
		      	  	}

		      	  }, error: function(e) {
		      	  	console.log('error obteniendo xml...')
		      	  }
		      	});  
	      	
	      	$("#game_lapolla_show_menu").css("height","auto");

		}
		
		window.addEventListener("message", function(event) {
		    if (event.data === "documentReadyFunctionsHomeUser") {
		    	documentReadyFunctionsHomeUser(); 
		    }
		});

		function activarPopupBicolorNivel(){

			$.ajax({
		        type: "POST",
		        url: "game_premiazoganagol_resultados_popup.html",
		        dataType: "json",
		        async: false,
		        success: function (data) {

		        	//console.log(data);
		        	var totalTickets = data.nivel;
		        	var puntaje = data.puntajeNivel;
		        	var result = "";
		        	var result2 = "";
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
						'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">'  ;
						
					}else if(totalTickets >=10 && totalTickets<=29){
						result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Amateur_popup.jpg" class="level-header-copa-casa-popup">' + 
						'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">AMATEUR</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
						'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
						'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">' ;
 
					}else if(totalTickets >=30 && totalTickets<=59){
						result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Crack_popup.jpg" class="level-header-copa-casa-popup">' + 
						'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">CRACK</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
						'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
						'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">'  ;

	 				}else if(totalTickets >=60){
						result = '<div class="posicion-nivel-img-popup"><img src="layer-view-image/game/copaentucasa/Leyenda_popup.jpg" class="level-header-copa-casa-popup">' + 
						'<div class="desc-nivel-position-popup"><span class="tipo-nivel-popup">LEYENDA</span><br><span class="tipo-nivel-descripcion-superior-popup">Tienes </span>' +
						'<span class="puntaje-por-nivel-popup">'+puntaje+'</span><br><span class="tipo-nivel-descripcion-popup">opciones para los sorteos</span><br>' +
						'<span class="tipo-nivel-descripcion-popup">de premios mayores</span></div></div><div class="copa-opciones-popup">'  ;
					 }
					
					result = result +
					'<button type="button" id="btn_mobile_ver_resultados_copabicolor" onclick="return false;"class="button-copa1" style="width:133px;margin-right: 5px;">Ver mis jugadas</button>' +
					'<button type="button" onclick="return false;"class=" btnEnlaceGanagol button-copa2" style="width:163px;margin-left: 5px;margin-bottom: 7px;">Juega desde S/ 3</button>';

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
					var count_copa = GetCookie('countbicolor_nivel')
					if(count_copa == null) {
					SetCookie('countbicolor_nivel','1')
					return 1
					}
					else {
					var newcount = parseInt(count_copa) + 1;
					DeleteCookie('countbicolor_nivel')
					SetCookie('countbicolor_nivel',newcount,exp)
					return count_copa
					}
					}
					function getCookieVal(offset) {
					var endstr = document.cookie.indexOf (";", offset);
					if (endstr == -1)
					endstr = document.cookie.length;
					return unescape(document.cookie.substring(offset, endstr));
					}

					function checkcount_copa() {
					var count_copa = GetCookie('countbicolor_nivel');
					if (count_copa == null) {
						var expDays = 2;
						localStorage.removeItem("exp_popup_nivel_mobile");
						var exp = new Date();
						exp.setTime(exp.getTime() + (expDays*24*60*60*1000));
						//exp.setTime(exp.getTime() + (expDays*5*60*1000));
						count_copa=1;
						SetCookie('countbicolor_nivel', count_copa, exp);
						localStorage.setItem("exp_popup_nivel_mobile", exp);
						openModal("#popup-copacasa-nivel", "");
						

					}
					else {
					count_copa++;
					var auxExp = localStorage.getItem("exp_popup_nivel_mobile");
					try{
						SetCookie('countbicolor_nivel', count_copa, auxExp);
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