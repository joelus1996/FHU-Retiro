<%@include file="include/taglibs.jspf"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>

<!DOCTYPE html>
<html lang="es">
<head>
<script>function getCookie(name) {var re = new RegExp(name + "=([^;]+)");var value = re.exec(document.cookie);return (value != null) ? unescape(value[1]) : null;}function getClientID() {try {var cookie = getCookie("_ga").split(".");return cookie[2] + "." + cookie[3];} catch(e) {console.log("No Universal Analytics cookie found");}}</script>
<script>dataLayer =[{'loginStatus': 'Sesión no iniciada','clientid': getClientID(),}];</script>
<script>
window.onload = function () {
	if(document.getElementById("clientId").value){
		dataLayer.splice(0,1,{
			'loginStatus': 'Sesión iniciada',
			'clientid': getClientID(),
			'userID': document.getElementById("clientId").value,
			});
	}
}
</script>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->
<script type="application/ld+json">
{
  "@context": "https://schema.org",
  "@type": "Corporation",
  "name": "La Tinka",
  "url": "https://www.latinka.com.pe/",
  "logo": "https://www.latinka.com.pe/p/layer-view-image/v2/landing/svg/tinka.svg",
  "sameAs": [
    "https://www.facebook.com/LaTinkaLoterias",
    "https://twitter.com/LaTinkaLoterias",
    "https://www.instagram.com/latinka_loterias/",
    "https://www.linkedin.com/company/latinka/"
  ]
}
</script>
	<meta property="og:title" content="La Tinka: La lotería líder del Perú | Loterías, Apuestas y Casino">
	<meta property="og:site_name" content="Juegos de loterías y apuestas deportivas en Perú - La Tinka">
	<meta property="og:url" content="https://www.latinka.com.pe/p/">
	<meta property="og:description" content="La Tinka es la compañía líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto.">
	<meta property="og:type" content="business.business">
	<meta property="og:image" content="https://www.latinka.com.pe/p/layer-view-image/v2/landing/svg/tinka.svg?v=1">
    <meta charset="UTF-8">
    <title>La Tinka: La lotería líder del Perú | Loterías, Apuestas y Casino</title>
    <meta name='description' content="La Tinka es la compañía líder en juegos de loterías y apuestas deportivas en Perú. La Tinka, Ganagol, Kábala, Gana Diario, Kinelo y Te Apuesto." />
    
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">

    <link rel="stylesheet" type="text/css" href="layer-view-style/v2/landing.css?v=11">
    <link rel="stylesheet" type="text/css" href="layer-view-style/v2/swiper.css">
    
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles-index.css?v=3">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/popModal.css?v=<%=Constants.popModal_css%>">
		
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/bannerCookies.css?v=6">
	<style type="text/css">
		.fade:not(.show) {
		    opacity: initial;
		}
	</style>	
     <%-- /*chatbot*/ --%>  
     <!-- <script type="application/javascript" charset="UTF-8" src="https://cdn.agentbot.net/core/56512f807294eae4d4093733fc35cd13.js"></script> -->
     <!-- <script type="application/javascript" charset="UTF-8" src="https://cdn.agentbot.net/core/fae07a18e1a39731de9829e00096fa95.js"></script> -->   
     <%-- /*fin chatbot*/ --%>  
     
   	<!--[if !IE]>
		<link rel="stylesheet" type="text/css" href="layer-view-style/v2/landing-not-ie.css">   
  	<![endif]-->
</head>
<body>
<!-- Google Tag Manager (noscript) -->
	<noscript>
		<iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
			height="0" width="0" style="display: none; visibility: hidden"></iframe>
	</noscript>
	<!-- End Google Tag Manager (noscript) -->
<h1 style="display: none;">La Tinka</h1>
<input type="hidden" value="${sessionScope.User.pClientid}" id="clientId">
<input type="hidden" value="${sessionScope.User.pAgreement}" id="agreement">
<input type="hidden" value="<%= Constants.flagPromoBicolor %>" id="flagPromoBicolor">
<%-- <input type="hidden" value="<%= Constants.flagPromoTinka %>" id="flagPromoTinka"> --%>
<input type="hidden" value="" id="flagPromoTinka">
<input type="hidden" value="<%= Constants.getBeanTinkaBo().isPopup3x12Active() %>" id="flagPromoTinka3x12">
<input type="hidden" value="<%= Constants.getBeanGanadiarioBo().isPopup3x5solesActive() %>" id="flagPromoGD3x5">
<input type="hidden" value="<%= Constants.URL_QW%>" id="urlQw">
<input type="hidden" value="<%= Constants.flagPromoCasino %>" id="flagPromoCasino">

<input id="gamesXML" type="hidden" value="<%=Constants.gamesXML.toString().trim()%>">
	<input type="hidden" value="Login" id="TipoZona">
	<input type="hidden" value="Login" id="Zona">
	<input type="hidden" value="Ingresar" id="SubZona">

<input type="hidden" id="closeSession" name="closeSession" value="${closeSession}">
<input type="hidden" id="urlTA" name="urlTA" value="${urlTA}">
<%
	session.removeAttribute("urlTA");
%>

	<div class="main-content">
        <!-- seek modification 30/05 init -->
        <header id="main-header">
            <div class="left-header paid-methods">
                <div class="content-methods">
                    <img src="layer-view-image/v2/landing/img/paid-methods_latinka03.png?v=1" alt="" style="margin: 0px 30px;" />
                </div>
                <ul class="cards-info">
                    <li>
                        <img src="layer-view-image/v2/landing/img/cards.png">
                    </li>
                    <li>
                        <a href="juega-bien.html" target="_blank">
                            <img src="layer-view-image/v2/landing/img/+18.png">
                        </a>
                    </li>
                </ul>                   
            </div>           
            <div class="right-header" id="main-user">
                <div class="unlogout">
	                <ul class="right-header__list">
	                    <li class="right-header__list__item">
	                        <a class="button"  href="javascript:void(0)" id="login">
	                        	<i><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Capa_1" x="0px" y="0px" width="512px" height="512px" viewBox="0 0 95.667 95.667" style="enable-background:new 0 0 95.667 95.667;" xml:space="preserve"><g><path d="M39.173,72.344l39.447-22.777c0.619-0.356,1-1.018,1-1.731s-0.381-1.375-1-1.732L39.173,23.324c-0.619-0.357-1.381-0.357-2,0c-0.619,0.357-1,1.018-1,1.732v10.605H2.121c-1.104,0-2,0.896-2,2v20.344c0,1.104,0.896,2,2,2h34.053v10.604c0,0.716,0.381,1.375,1,1.732c0.31,0.18,0.655,0.268,1,0.268C38.519,72.609,38.864,72.521,39.173,72.344z" fill="#000000"/><path d="M80.775,0H40.026c-1.104,0-2,0.896-2,2v6c0,1.104,0.896,2,2,2h40.749c2.632,0,4.771,2.141,4.771,4.771v66.125c0,2.631-2.141,4.771-4.771,4.771H40.026c-1.104,0-2,0.896-2,2v6c0,1.104,0.896,2,2,2h40.749c8.146,0,14.771-6.627,14.771-14.771    V14.772C95.546,6.627,88.92,0,80.775,0z" fill="#000000"/></g></svg></i>
	                            <span class="login">Ingresa</span>
	                        </a>
	                        <div class="modal-auth">
	                            <div class="modal-auth__content">
	                                <form action="login.html" class="js-form-login" id="frmLoginClientIndex" method="post" data-response-type="text" autocomplete="off">
	                                    <div class="form-group">
	                                        <input type="text" class="form-control"  name="user-client" style="background-color: #fff0 !important; -webkit-text-fill-color: #07663a !important; " id="user-client-header" autocomplete="off" required>
	                                        <label for="user-client-header">Usuario o N° de documento de identidad</label>
	                                        <div class="errorTxt onlyuser"></div>
	                                    </div>
	                                    <div class="form-group">
	                                        <input type="password" class="form-control" name="password-client" style="background-color: #fff0 !important; -webkit-text-fill-color: #07663a !important; " id="password-client-header" autocomplete="off" required>	                                        
	                                        <label for="password-client-header" id="password-client-header-label">Contraseña</label>
	                                        <div class="errorTxt onlypass" id="errorTxt-onlypass"></div>
	                                        <button class="view-password" type="button" id="toglePassword"></button>
	                                    </div>
	                                    <button class="btn" id="index-btnlogin" style="box-shadow:none !important;">
	                                    	Ingresar
	                                    </button>
	                                </form>
	                            </div>
	                            <div class="modal-auth__footer">
	                                <a href="restablecer.html" class="recovery-password">Recupera o cambia tu contraseña</a>
	                            </div>
	                            <div class="modal-auth__footer" style="padding-top: 0px;">
	                                <a href="recordar-usuario.html" class="recovery-password">¿Olvidaste tu usuario?</a>
	                            </div>   
	                            <div id="popup-message" class="overlay">							
									<div class="popup popup-sm login-error">	
									<a class="close-popup " id="close-popup-message" onclick="closePopup(this)">&times;</a>							
										<div class="main-modal" id="msg-message"></div>
										
									</div>
								</div>     
								<div id="popup-message-dt" class="overlay">							
									<div class="popup popup-sm login-error" style="background-color: #f2f2f2;">	
									<a class="close-popup " id="close-popup-message-dt" onclick="closePopup(this)">&times;</a>							
										<div class="main-modal" id="msg-message-dt">
											<div><div class="titulo-login-error" id="titulo-dt"></div><br>
							                    <form class="form-login has-validation-callback" action="common_login_dt.html" method="post" id="frmLoginDT" style="padding: 0em 0;">
								                    <input type="hidden" value="" name="lrdn" id="lrdn">
								                    <div class="control-form form__select has-success">
								                    	<label for="document-type" style="background-color: #f2f2f2;">Tipo de documento</label>
								                    	<select  name="lg-document-type" id="lg-document-type" tabindex="10" data-validation="required" data-validation-error-msg="Seleccionar un tipo de documento" data-validation-depending-value="CAREX" style="background-color: #f2f2f2; height: 52px;">
								                    		<option value="DNI" selected="" >DNI</option>
								                    		<option value="PASAP" >Pasaporte</option>
								                    		<option value="CAREX" >Carnet de Extranjer&iacute;a</option>
								                    	</select>
								                    </div>
								                    <button class="btn btn-login-error"   id="ingresar_doc_type">Aceptar</button>
								                    
							                    </form>
							                    </div>
										</div>
										
									</div>
								</div>                         
	                        </div>
	                    </li>
	                    <li class="right-header__list__item">
	                            <a class="button" href="registro.html" id="registrarse">
	                        		<i><svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Layer_1" x="0px" y="0px" viewBox="0 0 258.75 258.75" style="enable-background:new 0 0 258.75 258.75;" xml:space="preserve" width="512px" height="512px"><g><circle cx="129.375" cy="60" r="60" fill="#000000"/><path d="M129.375,150c-60.061,0-108.75,48.689-108.75,108.75h217.5C238.125,198.689,189.436,150,129.375,150z" fill="#000000"/></g></svg></i>
	                            	<span>Regístrate</span>
	                            </a>
	                    </li>
	                </ul>
	            </div>
	            <div class="logout">
	            	<ul class="right-header__list">
	            		<li class="right-header__list__item">
                            <a class="button" href="salir.html">
                            	<i>
                                	<svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="Layer_11" x="0px" y="0px" viewBox="0 0 511.989 511.989" style="enable-background:new 0 0 511.989 511.989;" xml:space="preserve" width="512" height="512" class=""><g><g>
										<g>
											<g>
												<path d="M110.933,221.782c-4.71,0-8.533,3.823-8.533,8.533v51.2c0,4.71,3.823,8.533,8.533,8.533s8.533-3.823,8.533-8.533v-51.2     C119.467,225.605,115.644,221.782,110.933,221.782z" data-original="#000000" class="active-path" style="fill:#FFFFFF" data-old_color="#000000"></path>
												<path d="M111.855,2.304L31.172,34.586C8.448,43,0,54.418,0,76.715v358.477c0,22.298,8.448,33.715,30.959,42.061l81.058,32.427     c4.011,1.519,8.038,2.287,11.981,2.287c17.152,0,29.602-14.336,29.602-34.091V34.049C153.6,9.78,134.246-6.126,111.855,2.304z      M136.533,477.876c0,10.18-5.035,17.024-12.535,17.024c-1.869,0-3.883-0.401-5.803-1.118L37.103,461.33     c-16.102-5.965-20.036-11.102-20.036-26.138V76.715c0-15.036,3.934-20.164,20.241-26.206l80.725-32.29     c2.082-0.785,4.087-1.186,5.956-1.186c7.501,0,12.544,6.835,12.544,17.016V477.876z" data-original="#000000" class="active-path" style="fill:#FFFFFF" data-old_color="#000000"></path>
												<path d="M178.133,51.115h120.533c14.114,0,25.6,11.486,25.6,25.6v128c0,4.71,3.814,8.533,8.533,8.533     c4.719,0,8.533-3.823,8.533-8.533v-128c0-23.526-19.14-42.667-42.667-42.667H178.133c-4.71,0-8.533,3.823-8.533,8.533     S173.423,51.115,178.133,51.115z" data-original="#000000" class="active-path" style="fill:#FFFFFF" data-old_color="#000000"></path>
												<path d="M332.8,298.582c-4.719,0-8.533,3.823-8.533,8.533v128c0,14.114-11.486,25.6-25.6,25.6H179.2     c-4.71,0-8.533,3.823-8.533,8.533s3.823,8.533,8.533,8.533h119.467c23.526,0,42.667-19.14,42.667-42.667v-128     C341.333,302.405,337.519,298.582,332.8,298.582z" data-original="#000000" class="active-path" style="fill:#FFFFFF" data-old_color="#000000"></path>
												<path d="M511.343,252.655c-0.435-1.05-1.058-1.988-1.852-2.782l-85.325-85.333c-3.337-3.336-8.73-3.336-12.066,0     c-3.337,3.337-3.337,8.73,0,12.066l70.767,70.775H196.267c-4.71,0-8.533,3.823-8.533,8.533c0,4.71,3.823,8.533,8.533,8.533     h286.601L412.1,335.215c-3.337,3.337-3.337,8.73,0,12.066c1.664,1.664,3.849,2.5,6.033,2.5c2.185,0,4.369-0.836,6.033-2.5     l85.325-85.325c0.794-0.794,1.417-1.732,1.852-2.782C512.205,257.093,512.205,254.738,511.343,252.655z" data-original="#000000" class="active-path" style="fill:#FFFFFF" data-old_color="#000000"></path>
											</g>
										</g>
										</g></g> 
									</svg>
								</i>
                                <span>Cerrar Sesión</span>
                            </a>
	                    </li>
	            	</ul>
	            </div>
            </div> 
        </header>
        <!-- seek modification 30/05 end -->
    	
		<jsp:useBean id="now" class="java.util.Date" />

		<fmt:parseDate var="cutoff"
               value="2026-01-01 00:00:00"
               pattern="yyyy-MM-dd HH:mm:ss"
               timeZone="America/Lima" />
        <div id="slider" class="slider fade swiper-container">
            <div class="swiper-container">
                <div class="swiper-wrapper">
                	
                    <div class="slide swiper-slide game-tinka">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure id="main-animation" class="main-image">
											                                            
                                            <c:choose>
											    <c:when test="${now.time < cutoff.time}">
											        <!-- Hasta 31/12/2025 23:59:59 -->
											        <img src="layer-view-image/v2/landing/img/home-tinka.png?v=8"
											             alt="Jugar La Tinka Lotería" />
											    </c:when>
											    <c:otherwise>
											        <!-- Desde 01/01/2026 -->
											        <img src="layer-view-image/v2/landing/img/home-tinka-50K.png?v=1"
											             alt="Jugar La Tinka Lotería" />
											    </c:otherwise>
											</c:choose>
                                            
                                            <div class="mask-price">
                                                <h3 data-text="" id="pozo-tinka-0"></h3>
                                            </div>
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div id="js-main-desc" class="main-desc">
                                            <div class="last-results">
                                                <span class="text-results">RESULTADOS <span id="results-date-tinka"></span></span>
                                                <span class="ball-results" id="results-tinka"></span>
                                                <span class="text-results" id='text-tinka-siosi'>SI O SI </span>
                                                <span class="ball-results" id="results-tinka-siosi"></span>
                                                <span class="main-links">
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/tutorial/como-jugar-tinka/" class="ico-link ico-play">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14.53 14.53">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M7.26,0a7.26,7.26,0,1,0,7.26,7.26A7.28,7.28,0,0,0,7.26,0Zm.82,11.8H6.26V10H8.08ZM10,7.35A2.29,2.29,0,0,1,8.9,8c-.54.36-.73.18-.73,1.09H6.36A2.73,2.73,0,0,1,8.17,6.36,1.46,1.46,0,0,0,8.81,6a.48.48,0,0,0,.09-.64,1.61,1.61,0,0,0-1.54-.91A1.55,1.55,0,0,0,5.81,5.81L4,5.54a3.18,3.18,0,0,1,3.27-2.9,3.58,3.58,0,0,1,3.27,2A2.5,2.5,0,0,1,10,7.35Z"/></g></g>
                                                        </svg>
                                                        <b><span>¿CÓMO JUGAR?</span></b>
                                                    </a>
                                                    <a target="_blank" href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-tinka.pdf" class="ico-link ico-whistle">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.3 12.82">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><polygon class="ico-fill" points="8.12 3.29 8.81 4.16 10.67 3.04 9.83 2.25 8.12 3.29"/><path class="ico-fill" d="M16.29,7.28h0A79.82,79.82,0,0,0,10.11.9C8.3-.49,5-.4,1.94,2.09l-.42.34-.07.05A4.4,4.4,0,0,0,1.1,8.66a4.4,4.4,0,0,0,6.1,1.11,5.24,5.24,0,0,0,1-1.31l3.67,4.35,4.41-2.91.06-2.61h0Zm-.94,2.27-2.14,1.31v-.61l2.14-1.31Zm-3-.05L7.57,3.64l0-.05-.1-.12-.11-.13h0A4.81,4.81,0,0,0,3.83,1.69C6.09.49,8.32.34,9.68,1.43a77.52,77.52,0,0,1,6,6.19Z"/></g></g>
                                                        </svg>
                                                        <b><span>REGLAMENTOS</span></b>
                                                    </a>
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/puntos-de-venta/" class="ico-link ico-location">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10.29 15.16">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M5.15,0A5.13,5.13,0,0,0,0,5.11c0,1.45,1.42,4,1.42,4l3.54,6L8.65,9.22s1.64-2.47,1.64-4.1A5.13,5.13,0,0,0,5.15,0Zm0,7.93A2.95,2.95,0,1,1,8.07,5a2.95,2.95,0,0,1-2.95,3Zm0,0"/></g></g>
                                                        </svg>
                                                        <b><span>PUNTOS DE VENTA</span></b>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                        <a href="juega-tinka.html" id="main-button" class="btn btn-red bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px;">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="slide swiper-slide game-kabala">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure class="main-image">
                                            <img src="layer-view-image/v2/landing/img/home-kabala.png?v=2" alt="Jugar Kabala" />
                                            <div class="mask-price">
                                                <h3 data-text="" id="pozo-kabala"></h3>
                                            </div>
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div class="main-desc">
                                            <div class="last-results">
                                                <span class="text-results">RESULTADOS <span id="results-date-kabala"></span></span>
                                                <span class="ball-results" id="results-kabala"></span>
                                                <span class="text-results">CHAU CHAMBA</span>
                                                <span class="ball-results" id="results-chauchamba"></span>
                                                <span class="main-links">
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/tutorial/como-jugar-kabala-online/" class="ico-link ico-play">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14.53 14.53">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M7.26,0a7.26,7.26,0,1,0,7.26,7.26A7.28,7.28,0,0,0,7.26,0Zm.82,11.8H6.26V10H8.08ZM10,7.35A2.29,2.29,0,0,1,8.9,8c-.54.36-.73.18-.73,1.09H6.36A2.73,2.73,0,0,1,8.17,6.36,1.46,1.46,0,0,0,8.81,6a.48.48,0,0,0,.09-.64,1.61,1.61,0,0,0-1.54-.91A1.55,1.55,0,0,0,5.81,5.81L4,5.54a3.18,3.18,0,0,1,3.27-2.9,3.58,3.58,0,0,1,3.27,2A2.5,2.5,0,0,1,10,7.35Z"/></g></g>
                                                        </svg>
                                                        <b><span>¿CÓMO JUGAR?</span></b>
                                                    </a>
                                                    <a target="_blank" href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-kabala.pdf" class="ico-link ico-whistle">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.3 12.82">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><polygon class="ico-fill" points="8.12 3.29 8.81 4.16 10.67 3.04 9.83 2.25 8.12 3.29"/><path class="ico-fill" d="M16.29,7.28h0A79.82,79.82,0,0,0,10.11.9C8.3-.49,5-.4,1.94,2.09l-.42.34-.07.05A4.4,4.4,0,0,0,1.1,8.66a4.4,4.4,0,0,0,6.1,1.11,5.24,5.24,0,0,0,1-1.31l3.67,4.35,4.41-2.91.06-2.61h0Zm-.94,2.27-2.14,1.31v-.61l2.14-1.31Zm-3-.05L7.57,3.64l0-.05-.1-.12-.11-.13h0A4.81,4.81,0,0,0,3.83,1.69C6.09.49,8.32.34,9.68,1.43a77.52,77.52,0,0,1,6,6.19Z"/></g></g>
                                                        </svg>
                                                        <b><span>REGLAMENTOS</span></b>
                                                    </a>
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/puntos-de-venta/" class="ico-link ico-location">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10.29 15.16">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M5.15,0A5.13,5.13,0,0,0,0,5.11c0,1.45,1.42,4,1.42,4l3.54,6L8.65,9.22s1.64-2.47,1.64-4.1A5.13,5.13,0,0,0,5.15,0Zm0,7.93A2.95,2.95,0,1,1,8.07,5a2.95,2.95,0,0,1-2.95,3Zm0,0"/></g></g>
                                                        </svg>
                                                        <b><span>PUNTOS DE VENTA</span></b>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                        <a href="juega-kabala.html" class="btn btn-orange bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px;">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="slide swiper-slide game-ganadiario">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure class="main-image">
                                            <img src="layer-view-image/v2/landing/img/home-ganadiario.png" alt="Jugar Gana Diario" />
                                            <div class="mask-price">
                                                <h3 data-text="" id="pozo-ganadiario"></h3>
                                            </div>
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div class="main-desc">
                                            <div class="last-results">
                                                <span class="text-results">RESULTADOS <span id="results-date-ganadiario"></span></span>
                                                <span class="ball-results" id="results-ganadiario"></span>
                                                <span class="main-links">
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/tutorial/como-jugar-gana-diario/" class="ico-link ico-play">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14.53 14.53">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M7.26,0a7.26,7.26,0,1,0,7.26,7.26A7.28,7.28,0,0,0,7.26,0Zm.82,11.8H6.26V10H8.08ZM10,7.35A2.29,2.29,0,0,1,8.9,8c-.54.36-.73.18-.73,1.09H6.36A2.73,2.73,0,0,1,8.17,6.36,1.46,1.46,0,0,0,8.81,6a.48.48,0,0,0,.09-.64,1.61,1.61,0,0,0-1.54-.91A1.55,1.55,0,0,0,5.81,5.81L4,5.54a3.18,3.18,0,0,1,3.27-2.9,3.58,3.58,0,0,1,3.27,2A2.5,2.5,0,0,1,10,7.35Z"/></g></g>
                                                        </svg>
                                                        <b><span>¿CÓMO JUGAR?</span></b>
                                                    </a>
                                                    <a target="_blank" href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-ganadiario.pdf" class="ico-link ico-whistle">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.3 12.82">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><polygon class="ico-fill" points="8.12 3.29 8.81 4.16 10.67 3.04 9.83 2.25 8.12 3.29"/><path class="ico-fill" d="M16.29,7.28h0A79.82,79.82,0,0,0,10.11.9C8.3-.49,5-.4,1.94,2.09l-.42.34-.07.05A4.4,4.4,0,0,0,1.1,8.66a4.4,4.4,0,0,0,6.1,1.11,5.24,5.24,0,0,0,1-1.31l3.67,4.35,4.41-2.91.06-2.61h0Zm-.94,2.27-2.14,1.31v-.61l2.14-1.31Zm-3-.05L7.57,3.64l0-.05-.1-.12-.11-.13h0A4.81,4.81,0,0,0,3.83,1.69C6.09.49,8.32.34,9.68,1.43a77.52,77.52,0,0,1,6,6.19Z"/></g></g>
                                                        </svg>
                                                        <b><span>REGLAMENTOS</span></b>
                                                    </a>
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/puntos-de-venta/" class="ico-link ico-location">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10.29 15.16">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M5.15,0A5.13,5.13,0,0,0,0,5.11c0,1.45,1.42,4,1.42,4l3.54,6L8.65,9.22s1.64-2.47,1.64-4.1A5.13,5.13,0,0,0,5.15,0Zm0,7.93A2.95,2.95,0,1,1,8.07,5a2.95,2.95,0,0,1-2.95,3Zm0,0"/></g></g>
                                                        </svg>
                                                        <b><span>PUNTOS DE VENTA</span></b>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                        <a href="juega-ganadiario.html" class="btn btn-orange bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px;">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    <c:if test="${isLaPolla}">
                    <div class="slide swiper-slide game-lapolla">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure class="main-image">
                                            <img src="layer-view-image/v2/landing/img/la-polla-carrusel-desktop.png" alt="Polla del Mundial Qatar 2022" />
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div class="main-desc">
                                            <div class="last-results">
                                            </div>
                                        </div>
                                        <a href="#" onclick="toLaPolla();" class="btn btn-casino bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px; color: rgba(0, 0, 0, 0.8);">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                        <a href="https://www.lapollateapuesto.pe/" rel="dofollow" style="display: none; visibility: hidden;"></a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    </c:if>
                    <div class="slide swiper-slide game-videoloteria">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure id="main-animation" class="main-image">
                                            <img src="layer-view-image/v2/landing/img/home-videoloteria.png?v=1" alt="Jugar Video Lotería" />
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div id="js-main-desc" class="main-desc">
                                            <div class="last-results">
                                                <span class="main-links">
                                                    <a target="_blank" href="https://blog.latinka.com.pe/tutorial/como-jugar-video-loterias/" class="ico-link ico-play">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14.53 14.53">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M7.26,0a7.26,7.26,0,1,0,7.26,7.26A7.28,7.28,0,0,0,7.26,0Zm.82,11.8H6.26V10H8.08ZM10,7.35A2.29,2.29,0,0,1,8.9,8c-.54.36-.73.18-.73,1.09H6.36A2.73,2.73,0,0,1,8.17,6.36,1.46,1.46,0,0,0,8.81,6a.48.48,0,0,0,.09-.64,1.61,1.61,0,0,0-1.54-.91A1.55,1.55,0,0,0,5.81,5.81L4,5.54a3.18,3.18,0,0,1,3.27-2.9,3.58,3.58,0,0,1,3.27,2A2.5,2.5,0,0,1,10,7.35Z"/></g></g>
                                                        </svg>
                                                        <b><span>¿CÓMO JUGAR?</span></b>
                                                    </a>
                                                    <a target="_blank" href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-latinkavideoloterias.pdf" class="ico-link ico-whistle">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.3 12.82">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><polygon class="ico-fill" points="8.12 3.29 8.81 4.16 10.67 3.04 9.83 2.25 8.12 3.29"/><path class="ico-fill" d="M16.29,7.28h0A79.82,79.82,0,0,0,10.11.9C8.3-.49,5-.4,1.94,2.09l-.42.34-.07.05A4.4,4.4,0,0,0,1.1,8.66a4.4,4.4,0,0,0,6.1,1.11,5.24,5.24,0,0,0,1-1.31l3.67,4.35,4.41-2.91.06-2.61h0Zm-.94,2.27-2.14,1.31v-.61l2.14-1.31Zm-3-.05L7.57,3.64l0-.05-.1-.12-.11-.13h0A4.81,4.81,0,0,0,3.83,1.69C6.09.49,8.32.34,9.68,1.43a77.52,77.52,0,0,1,6,6.19Z"/></g></g>
                                                        </svg>
                                                        <b><span>REGLAMENTOS</span></b>
                                                    </a>
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/puntos-de-venta/" class="ico-link ico-location">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10.29 15.16">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M5.15,0A5.13,5.13,0,0,0,0,5.11c0,1.45,1.42,4,1.42,4l3.54,6L8.65,9.22s1.64-2.47,1.64-4.1A5.13,5.13,0,0,0,5.15,0Zm0,7.93A2.95,2.95,0,1,1,8.07,5a2.95,2.95,0,0,1-2.95,3Zm0,0"/></g></g>
                                                        </svg>
                                                        <b><span>PUNTOS DE VENTA</span></b>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                        <a href="juega-latinka-video-loterias.html" id="main-button" class="btn btn-green hand bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px;">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>                  
                    <div class="slide swiper-slide game-kinelo">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure class="main-image">
                                            <img src="layer-view-image/v2/landing/img/home-kinelo.png" alt="Jugar Kinelo" />
                                            <div class="mask-price">
                                                <!-- h3 data-text="100,000">100,000</h3 -->
                                            </div>
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div class="main-desc">
                                            <div class="last-results">
                                                <span class="main-links">
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/tutorial/como-jugar-kinelo/" class="ico-link ico-play">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14.53 14.53">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M7.26,0a7.26,7.26,0,1,0,7.26,7.26A7.28,7.28,0,0,0,7.26,0Zm.82,11.8H6.26V10H8.08ZM10,7.35A2.29,2.29,0,0,1,8.9,8c-.54.36-.73.18-.73,1.09H6.36A2.73,2.73,0,0,1,8.17,6.36,1.46,1.46,0,0,0,8.81,6a.48.48,0,0,0,.09-.64,1.61,1.61,0,0,0-1.54-.91A1.55,1.55,0,0,0,5.81,5.81L4,5.54a3.18,3.18,0,0,1,3.27-2.9,3.58,3.58,0,0,1,3.27,2A2.5,2.5,0,0,1,10,7.35Z"/></g></g>
                                                        </svg>
                                                        <b><span>¿CÓMO JUGAR?</span></b>
                                                    </a>
                                                    <a target="_blank" href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-kinelo.pdf" class="ico-link ico-whistle">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.3 12.82">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><polygon class="ico-fill" points="8.12 3.29 8.81 4.16 10.67 3.04 9.83 2.25 8.12 3.29"/><path class="ico-fill" d="M16.29,7.28h0A79.82,79.82,0,0,0,10.11.9C8.3-.49,5-.4,1.94,2.09l-.42.34-.07.05A4.4,4.4,0,0,0,1.1,8.66a4.4,4.4,0,0,0,6.1,1.11,5.24,5.24,0,0,0,1-1.31l3.67,4.35,4.41-2.91.06-2.61h0Zm-.94,2.27-2.14,1.31v-.61l2.14-1.31Zm-3-.05L7.57,3.64l0-.05-.1-.12-.11-.13h0A4.81,4.81,0,0,0,3.83,1.69C6.09.49,8.32.34,9.68,1.43a77.52,77.52,0,0,1,6,6.19Z"/></g></g>
                                                        </svg>
                                                        <b><span>REGLAMENTOS</span></b>
                                                    </a>
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/puntos-de-venta/" class="ico-link ico-location">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10.29 15.16">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M5.15,0A5.13,5.13,0,0,0,0,5.11c0,1.45,1.42,4,1.42,4l3.54,6L8.65,9.22s1.64-2.47,1.64-4.1A5.13,5.13,0,0,0,5.15,0Zm0,7.93A2.95,2.95,0,1,1,8.07,5a2.95,2.95,0,0,1-2.95,3Zm0,0"/></g></g>
                                                        </svg>
                                                        <b><span>PUNTOS DE VENTA</span></b>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                        <a href="juega-kinelo.html" class="btn btn-red bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px;">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="slide swiper-slide game-ganagol">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure class="main-image">
                                            <img src="layer-view-image/v2/landing/img/home-ganagol.png" alt="Jugar Ganagol" />
                                             <div class="mask-price">
                                                 <h3 data-text="" id="pozo-ganagol"></h3>
                                             </div>
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div class="main-desc">
                                            <div class="last-results">
                                                <span class="text-results">RESULTADOS <span id="results-date-ganagol"></span></span>
                                                <span class="ball-results">
                                                    <span class="result-match" id="results-ganagol"></span>
                                                </span>
                                                <span class="text-results">Golazo 200 </span>
                                                <span class="ball-results">
                                                    <span class="result-match" id="result-g200"></span>
                                                </span>
                                                <span class="main-links">
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/tutorial/como-jugar-ganagol/" class="ico-link ico-play">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14.53 14.53">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M7.26,0a7.26,7.26,0,1,0,7.26,7.26A7.28,7.28,0,0,0,7.26,0Zm.82,11.8H6.26V10H8.08ZM10,7.35A2.29,2.29,0,0,1,8.9,8c-.54.36-.73.18-.73,1.09H6.36A2.73,2.73,0,0,1,8.17,6.36,1.46,1.46,0,0,0,8.81,6a.48.48,0,0,0,.09-.64,1.61,1.61,0,0,0-1.54-.91A1.55,1.55,0,0,0,5.81,5.81L4,5.54a3.18,3.18,0,0,1,3.27-2.9,3.58,3.58,0,0,1,3.27,2A2.5,2.5,0,0,1,10,7.35Z"/></g></g>
                                                        </svg>
                                                        <b><span>¿CÓMO JUGAR?</span></b>
                                                    </a>
                                                    <a target="_blank" href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-ganagol.pdf" class="ico-link ico-whistle">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.3 12.82">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><polygon class="ico-fill" points="8.12 3.29 8.81 4.16 10.67 3.04 9.83 2.25 8.12 3.29"/><path class="ico-fill" d="M16.29,7.28h0A79.82,79.82,0,0,0,10.11.9C8.3-.49,5-.4,1.94,2.09l-.42.34-.07.05A4.4,4.4,0,0,0,1.1,8.66a4.4,4.4,0,0,0,6.1,1.11,5.24,5.24,0,0,0,1-1.31l3.67,4.35,4.41-2.91.06-2.61h0Zm-.94,2.27-2.14,1.31v-.61l2.14-1.31Zm-3-.05L7.57,3.64l0-.05-.1-.12-.11-.13h0A4.81,4.81,0,0,0,3.83,1.69C6.09.49,8.32.34,9.68,1.43a77.52,77.52,0,0,1,6,6.19Z"/></g></g>
                                                        </svg>
                                                        <b><span>REGLAMENTOS</span></b>
                                                    </a>
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/puntos-de-venta/" class="ico-link ico-location">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10.29 15.16">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M5.15,0A5.13,5.13,0,0,0,0,5.11c0,1.45,1.42,4,1.42,4l3.54,6L8.65,9.22s1.64-2.47,1.64-4.1A5.13,5.13,0,0,0,5.15,0Zm0,7.93A2.95,2.95,0,1,1,8.07,5a2.95,2.95,0,0,1-2.95,3Zm0,0"/></g></g>
                                                        </svg>
                                                        <b><span>PUNTOS DE VENTA</span></b>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                        <a href="juega-ganagol.html" class="btn btn-red bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px;">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="slide swiper-slide game-teapuesto">
                        <div class="slide-body">
                            <div class="item">
                                <div class="nested">
                                    <div class="slide-wrapper">
                                        <figure class="main-image">
                                            <img src="layer-view-image/v2/landing/img/home-teapuesto.png?v=2" alt="Jugar Te Apuesto Apuestas Deportivas" />
                                        </figure>
                                    </div>
                                    <div class="main-action">
                                        <div class="main-desc">
                                            <div class="last-results">
                                                <span class="main-links">
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/tutorial/como-jugar-te-apuesto/" class="ico-link ico-play">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 14.53 14.53">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M7.26,0a7.26,7.26,0,1,0,7.26,7.26A7.28,7.28,0,0,0,7.26,0Zm.82,11.8H6.26V10H8.08ZM10,7.35A2.29,2.29,0,0,1,8.9,8c-.54.36-.73.18-.73,1.09H6.36A2.73,2.73,0,0,1,8.17,6.36,1.46,1.46,0,0,0,8.81,6a.48.48,0,0,0,.09-.64,1.61,1.61,0,0,0-1.54-.91A1.55,1.55,0,0,0,5.81,5.81L4,5.54a3.18,3.18,0,0,1,3.27-2.9,3.58,3.58,0,0,1,3.27,2A2.5,2.5,0,0,1,10,7.35Z"/></g></g>
                                                        </svg>
                                                        <b><span>¿CÓMO JUGAR?</span></b>
                                                    </a>
                                                    <a target="_blank" href="https://www.latinka.com.pe/latinka/docs/reglamento/reglamento-teapuesto.pdf" class="ico-link ico-whistle">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.3 12.82">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><polygon class="ico-fill" points="8.12 3.29 8.81 4.16 10.67 3.04 9.83 2.25 8.12 3.29"/><path class="ico-fill" d="M16.29,7.28h0A79.82,79.82,0,0,0,10.11.9C8.3-.49,5-.4,1.94,2.09l-.42.34-.07.05A4.4,4.4,0,0,0,1.1,8.66a4.4,4.4,0,0,0,6.1,1.11,5.24,5.24,0,0,0,1-1.31l3.67,4.35,4.41-2.91.06-2.61h0Zm-.94,2.27-2.14,1.31v-.61l2.14-1.31Zm-3-.05L7.57,3.64l0-.05-.1-.12-.11-.13h0A4.81,4.81,0,0,0,3.83,1.69C6.09.49,8.32.34,9.68,1.43a77.52,77.52,0,0,1,6,6.19Z"/></g></g>
                                                        </svg>
                                                        <b><span>REGLAMENTOS</span></b>
                                                    </a>
                                                    <a target="_blank" href="<%=Constants.URL_QW%>/puntos-de-venta/" class="ico-link ico-location">
                                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 10.29 15.16">
                                                            <g id="Layer_2" data-name="Layer 2"><g id="bolillas"><path class="ico-fill" d="M5.15,0A5.13,5.13,0,0,0,0,5.11c0,1.45,1.42,4,1.42,4l3.54,6L8.65,9.22s1.64-2.47,1.64-4.1A5.13,5.13,0,0,0,5.15,0Zm0,7.93A2.95,2.95,0,1,1,8.07,5a2.95,2.95,0,0,1-2.95,3Zm0,0"/></g></g>
                                                        </svg>
                                                        <b><span>PUNTOS DE VENTA</span></b>
                                                    </a>
                                                </span>
                                            </div>
                                        </div>
                                         <a onclick="toTAV2();"   class="btn btn-green hand bounce-animated juega-ahora">
                                            <div class="wrap-btn">
                                                <span class="ghost-text" style="line-height: 50px;">JUEGA AHORA</span>
                                                <span class="mask-text" style="line-height: 50px;">JUEGA AHORA</span>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>		        
                </div>                
		        <div class="main-arrows">
		            <div class="wrap-arrows">
		                <a href="#" id="prevSlide" class="slick-prev arrow-prev slick-arrow" onclick=prevslideOnclick()><i></i></a>
		                <a href="#" id="nextSlide" class="slick-next arrow-next slick-arrow" onclick=nextslideOnclick()><i></i></a>
		            </div>
		        </div>
            </div>
        </div>
        <div class="swiper-pagination"></div>
        <div class="dock animation1 " id="dock2">
            <c:if test="${isLaPolla}">
            	<div class="dock-container2" style="width: 1130px;">
            </c:if>
            <c:if test="${!isLaPolla}">
            	  <div class="dock-container2" >
            	  
            </c:if>

              <a id="game-tinka" class="dock-item2 dock-tinka selected game-option" href="juega-tinka.html"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/tinka.svg?v=1" alt="contact" />
                </div>
              </a>
              <a id="game-kabala" class="dock-item2 dock-kabala game-option" href="juega-kabala.html"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/kabala.png" alt="music" />
                </div>
              </a>
              <a id="game-ganadiario" class="dock-item2 dock-ganadiario game-option" href="juega-ganadiario.html"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/ganadiario.svg" alt="video" />
                </div>
              </a> 
              <a id="game-videoloteria" class="dock-item2 dock-videoloteria game-option" href="juega-latinka-video-loterias.html"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/logo-videoloterias.png?v=1" alt="Jugar Video Loteria" />
                </div>
              </a>  
              <a id="game-kinelo" class="dock-item2 dock-kinelo game-option" href="juega-kinelo.html"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/kinelo.png" alt="history" />
                </div>
              </a>  
              <a id="game-ganagol" class="dock-item2 dock-ganagol game-option" href="juega-ganagol.html"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/ganagol.svg" alt="portfolio" />
                </div>
              </a>
              <a id="game-teapuesto" class="dock-item2 dock-teapuesto game-option" href="#" onclick="toTAV2();"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/teapuesto.png?v=1" alt="contact" />
                </div>
              </a>
              <c:if test="${isLaPolla}">
              <a id="game-lapolla" class="dock-item2 dock-lapolla game-option" href="#" onclick="toLaPolla();"><span></span>
                <div class="box-game">
                    <img src="layer-view-image/v2/landing/svg/lapolla.png" alt="contact" />
                </div>
              </a>
              </c:if>
              <a href="https://www.lapollateapuesto.pe/" ref="dofollow" style="display: none;cursor: not-allowed; pointer-events: none; "></a>                        
            </div>
        </div>

   

    <div class="preloader-wrapper">
      <div class="preloader-content">
        <div class="preloader">
          <div class="loading-content">
                <img src="layer-view-image/v2/logo-preload.png?v=1" alt="logo" class="preloader-logo" />
          
            <div class="loading-bar">
                <div class='time-part-wrapper'>
                    <div class='time-part seconds cents'>
                        <div class='digit-wrapper'>
                            <span class='digit'>0</span>
                            <span class='digit'>1</span>
                            <span class='digit'>0</span>
                        </div>
                    </div>
                    <div class='time-part seconds tens'>
                        <div class='digit-wrapper'>
                            <span class='digit'>0</span>
                            <span class='digit'>1</span>
                            <span class='digit'>2</span>
                            <span class='digit'>3</span>
                            <span class='digit'>4</span>
                            <span class='digit'>5</span>
                            <span class='digit'>6</span>
                            <span class='digit'>7</span>
                            <span class='digit'>8</span>
                            <span class='digit'>9</span>
                            <span class='digit'>0</span>
                        </div>
                    </div>
                    <div class='time-part seconds ones'>
                        <div class='digit-wrapper'>
                            <span class='digit'>0</span>
                            <span class='digit'>1</span>
                            <span class='digit'>2</span>
                            <span class='digit'>3</span>
                            <span class='digit'>4</span>
                            <span class='digit'>5</span>
                            <span class='digit'>6</span>
                            <span class='digit'>7</span>
                            <span class='digit'>8</span>
                            <span class='digit'>9</span>
                            <span class='digit'>0</span>
                        </div>
                    </div>
                    <div class='time-part seconds percentage'>
                        <div class='digit-wrapper'>
                            <span class='digit'>%</span>
                        </div>
                    </div>
                </div>
            </div>

          </div>
        </div>
      </div>
    </div>
    
    <!-- Desarrollo copa en tu casa DRUIZ no tocar

	<footer id="footer-copacasa">
    
    	           <div id="popup-copacasa" class="overlay">
						<div class="popup popup-sm-copacasa">
							<a class="close-copa js-close-modal" href="#">&times;</a>
							<div class="wrap-modal">
								<div class="gana-copa-header">
									<img class="img-logo-teapuesto-popup" src="layer-view-image/game/copaentucasa/logo-teapuesto.gif">
									<div class="descripcion-copa-casa">
										<span>¡GANA CON</span><br>
										<span>LA COPA EN TU CASA!</span>
									</div>
								</div>
								<div class="gana-copa-footer">
									<img class="home-popup" src="layer-view-image/game/copaentucasa/Home_popup.jpg">
									<div class="descripcion-footer">
										<span>Todas tus jugadas desde S/ 5</span><br>
										<span>participan AUTOMÁTICAMENTE</span>
									</div>
									<button type="button" id="btn_desktop_ingresar_copacasa" onclick="return false;"class="button-ingresar"><a href="#" style="text-decoration: none;color: white;">Ingresa aquí</a></button>								
								</div>
																							
							</div>
						</div>
					</div>
    
    </footer> -->
    
    <!-- Desarrollo copa bicolor en tu casa DRUIZ no tocar-->

<%-- 	<footer id="footer-copacasa">
		<div id="popup-copacasa" class="overlay">
			<div class="popup popup-sm-copacasa" style="border-radius: 20px;">
				<a class="close-copa js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="gana-copa-footer" style="background-color:#fff;border-radius: 20px;">
						<img class="home-popup" src="layer-view-image/game/premiazoganagol/img-popup-premiazogg.png">
						<button type="button" id="btn_desktop_ingresar_copacasa" onclick="return false;"class="button-ingresar" ><a href="#" style="text-decoration: none;color: white;">Infórmate aquí</a></button>								
					</div> 														
				</div>
			</div>
		</div>
    </footer>  --%>

	<!-- Popup avion qatar -->
	<footer class="footerPromSorteo" >
		<div id="popup-avionQatar" class="overlay">
			<div class="popup popup-sm-PromSorteo" style="border-radius: 20px;">
				<a class="close-PromSorteo js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="gana-PromSorteo-footer" style="background-color:#fff;border-radius: 20px;">
						<img class="home-popup" src="layer-view-image/game/teapuesto/avionQatar/popup_taqatar.png" alt="Apuestas Mundial Qatar 2022 Te Apuesto">
						<button style="top: -86px;position: relative;cursor:pointer;" type="button" id="btnAvionqatarInfo" onclick="return false;"class="button-avion-qatar-amarillo" >Infórmate aquí</button>								
					</div> 														
				</div>
			</div>
		</div>
    </footer>
    
    <!-- Popup avion estambul -->
	<footer class="footerPromSorteo" >
		<div id="popup-avionEstambul" class="overlay">
			<div class="popup popup-sm-PromSorteo" style="border-radius: 20px;">
				<a class="close-PromSorteo js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="gana-PromSorteo-footer" style="background-color:#fff;border-radius: 20px;">
						<img class="home-popup" src="layer-view-image/game/teapuesto/avionEstambul/popup-estambul.png" alt="Te Apuesto te lleva a la Final de la Champions 2023">
						<button style="top: -60px;position: relative;cursor:pointer;" type="button" id="btnAvionEstambulInfo" onclick="return false;"class="button-avion-qatar-naranja" >Infórmate aquí</button>								
					</div> 														
				</div>
			</div>
		</div>
    </footer>
    
    <!-- Popup avion Peru -->
    <!-- Se comenta solicitado por NNDD 23/05/2024 -->
    <!-- --> <footer class="footerPromSorteo" >
		<div id="popup-avionPeru" class="overlay">
			<div class="popup popup-sm-PromSorteo" style="border-radius: 20px;">
				<a class="close-PromSorteo js-close-modal" href="#" onclick="evalPopupInformativo();">&times;</a>
				<div class="wrap-modal">
					<div class="gana-PromSorteo-footer" style="background-color:#fff;border-radius: 20px;">
						<img class="home-popup" src="layer-view-image/game/teapuesto/avionPeru/popup-peru.png" alt="Avión del Hincha Eliminatorias 2026.">
						<button style="top: -60px;position: relative;cursor:pointer;" type="button" id="btnAvionPeruInfo" onclick="return false;"class="button-avion-qatar-naranja" >Infórmate aquí</button>								
					</div> 														
				</div>
			</div>
		</div>
    </footer>
    
    
    <!-- Popup juegaddvv ddvv -->
	<!-- <footer class="footerPromSorteo" >
		<div id="popup-juegaddvv" class="overlay">
			<div class="popup popup-sm-PromSorteo" style="border-radius: 20px;">
				<a class="close-PromSorteo js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="gana-PromSorteo-footer" style="background-color:#fff;border-radius: 20px;">
						<img class="home-popup" src="layer-view-image/game/virtuales/juegaGanaConVirtuales/popup_juegaddvv.png" alt="Juega Deportes Virtuales">
						<button style="top: -50px;position: relative;cursor:pointer;" type="button" id="btnJuegaddvvInfo" onclick="return false;"class="button-juegaddvv-naranja" >Infórmate aquí</button>								
					</div> 														
				</div>
			</div>
		</div>
    </footer> -->
    
	<!-- Popup La Tinka -->
	<footer id="footer-popup-tinka">    
 	    <div id="popup-tinka" class="overlay">
			<div class="popup popup-sm-tinka">
				<a class="close-tinka js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-tinka-footer" style="background-color:#fff;">
						<img class="home-popup" src="layer-view-image/game/tinka/popup_siosi_100.jpg?v=1" alt="Jugar La Tinka Lotería">
						<button type="button" id="btn_desktop_ingresar_tinka" style="background-color:#E30613;" onclick="return false;"class="button-ingresar" ><a href="#" style="text-decoration: none;color: white;">Juega aquí</a></button>								
					</div>
				</div>
			</div>
		</div>
    
    </footer>
	<!-- fin popup La Tinka -->
	
	<!-- Popup La Tinka 3x12 -->
    <div id="popup-tinka-3x12" class="overlay">
	    <div class="popup popup-standard">
			<a class="close-popup" onclick="closePopup(this)" >&times;</a> 
			<div class="popup-img-button">
				<img class="home-popup" src="layer-view-image/game/tinka/popup_juega_tinka.jpg" alt="Juega Tinka">
				<div class="footer-button accion-1">
					<button id="btn_juega_tinka_3x12" class="button-ingresar">Juega aquí</button>
				</div>
				<div class="footer-button accion-2">
					<a id="enlace_ingresar_tinka_3x12">Infórmate de los términos y condiciones</a>
				</div>
			</div>
		</div>						
	</div> 
   	<!-- fin popup La Tinka 3x12 -->
   	
   	<!-- Popup Gana Diario 3x5 -->
    <div id="popup-ganadiario-3x5" class="overlay">
	    <div class="popup popup-standard">
			<a class="close-popup" onclick="closePopup(this)" >&times;</a> 
			<div class="popup-img-button">
				<img class="home-popup" src="layer-view-image/game/ganadiario/popup_juega_gana_diario_3x5.jpg" alt="Juega Gana Diario">
				<div class="footer-button accion-1">
					<button id="btn_juega_ganadiario_3x5" class="button-ingresar">Juega aquí</button>
				</div>
				<div class="footer-button accion-2">
					<a id="enlace_ingresar_ganadiario_3x5">Infórmate de los términos y condiciones</a>
				</div>
			</div>
		</div>						
	</div>
   	<!-- fin popup La Gana Diario 3x5 -->
   	
   	<%@ include file="include/popups.jspf" %>
   		
	<!-- Popup Casino -->
	<footer id="footer-popup-tinka">
 	    <div id="popup-casino" class="overlay">
			<div class="popup popup-sm-tinka">
				<a class="close-tinka js-close-modal" href="#">&times;</a>
				<div class="wrap-modal">
					<div class="popup-tinka-footer" style="background-color:#fff;">
						<img class="home-popup" src="layer-view-image/game/casino/popup_casino.jpg" alt="Jugar Casino Online">
						<button type="button" id="btn_desktop_ingresar_casino" onclick="return false;"class="button-ingresar" style="background-color:#febb05 ;margin-right: 15px;"><a href="#" style="text-decoration: none;color: #000000;">Juega aquí</a></button>								
					</div>																			
				</div>
			</div>
		</div>
    
    </footer>
	<!-- fin popup Casino -->
   
	<div id="popup-message-session" class="overlay">							
		<div class="popup popup-sm login-error">	
		<a class="close-popup " id="close-popup-session" onclick="closePopup(this)">&times;</a>							
			<div class="main-modal" id="msg-session"></div>
			
		</div>
	</div>
   
   
   <!-- Banner Cookies -->		
<!-- 	<div id="bannerCookies" class="BannerCookies closeBanner" > -->
<!-- 		<div class="txtBanner"> -->
<!-- 			 La Tinka utiliza cookies. Al hacer click en el botón Aceptar, aceptas su uso. -->
<!-- 				 Obtén más información sobre las cookies y cómo evitar su uso en este <span id="enlaceBanner">enlace.</Span> -->
<!-- 		</div> -->
<!-- 		<button type="button" id="btnBannerCookies" onclick="return false;" class="buttonBanner"> -->
<!-- 			Aceptar -->
<!-- 		</button> -->
<!-- 	</div>			 -->

<div>
	<div id="bannerCookiesModal"></div>
	<div id="bannerCookies" class="ck-font-family ck-banner-cookies"> 
		<div class="ck-cookie-bar shadow-lg z-50" id="cookieBanner" style="z-index: 100;">
	      <div>
	        <div class="ck-cookie-paragraph">
	          La Tinka utiliza cookies para ofrecer la mejor experiencia a nuestros usuarios. Al seguir navegando aceptas el uso de cookies.
	        </div>
	      </div>
	      <div class="ck-btn-container d-flex">
	        <button
	          class="ck-custom-botton ck-conf-btn"
	          data-bs-toggle="modal"
	          data-bs-target="#cookieModal"
	        >
	          Configurar cookies
	        </button>
	        <button id="acceptAllBtn" class="ck-custom-botton ck-accept-btn">
	          Aceptar todas
	        </button>
	      </div>
	    </div>
	<div class="ckb-modal fade" tabindex="-1" id="cookieModal" style="z-index: 2000;">
	      <div class="ckb-modal-dialog">
	        <div class="ckb-modal-content ck-custom-modal-content" style="text-align: justify !important;">
	          <div class="ckb-modal-header ck-custom-modal-header">
	            <h5 class="ck-custom-modal-title">Configuración de Cookies</h5>
	            <img class="ck-logo" src="layer-view-image/client/logo-banner-cookies.png" />
	          </div>
			  
	          <div class="ckb-modal-body">
	            <div class="ck-main-text">
	              Nuestros sitios web podrían obtener o guardar información en tu
	              navegador, mediante el uso de cookies. Respetando tu derecho a la
	              privacidad, puedes escoger no permitirnos usar ciertas cookies,
	              sin embargo, el bloqueo de algunos tipos de cookies puede afectar
	              tu experiencia en nuestros sitios y con los servicios que te
	              ofrecemos.
	            </div>
	            <div
	              class="accordion ck-accordion accordion-flush"
	              id="accordionFlushExample"
	            >
	              <div class="accordion-item">
	                <div
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseOne" aria-expanded="false" aria-controls="flush-collapseOne"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseOne"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseOne"
	                  >
	                    <label class="ck-color-gray">
	                      Estrictamente necesarias
	                    </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <label
	                      class="ck-siempre-label"
	                      onclick="event.stopPropagation()"
	                    >
	                      Siempre activas
	                    </label>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseOne"
	                      data-bs-target="#flush-collapseOne"
	                      class="accord ck-accord ck-arrow-1"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseOne"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies son necesarias para que el sitio web funcione,
	                    no se pueden desactivar en nuestro sistema. No guardan
	                    ninguna información personal identificable. Puedes
	                    configurar tu navegador para bloquear o alertar sobre estas
	                    cookies, pero algunas partes del sitio no funcionarán.
	                  </div>
	                </div>
	              </div>
	              <div class="accordion-item">
	                <div
	                  id="main-accord"
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseTwo" aria-expanded="false" aria-controls="flush-collapseTwo"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseTwo"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseTwo"
	                  >
	                    <label class="ck-color-gray"> Estadísticas </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <div class="ck-switch-container">
	                      <div class="ck-switch">
	                        <input
	                          id="userAcceptsStatistics"
	                          type="checkbox"
	                          class="ck-switch-input"
	                        />
	                        <label
	                          for="userAcceptsStatistics"
	                          class="ck-switch-label"
	                        ></label>
	                      </div>
	                    </div>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseTwo"
	                      data-bs-target="#flush-collapseTwo"
	                      class="accord ck-accord ck-arrow-2"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseTwo"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies registran el número de visitantes y su
	                    comportamiento en el sitio, para medir su actividad y
	                    elaborar perfiles de navegación de usuarios.
	                  </div>
	                </div>
	              </div>
	              <div class="accordion-item">
	                <div
	                  id="main-accord"
	                  class="accordion-header ck-accordion-header d-flex" data-bs-toggle="collapse" data-bs-target="#flush-collapseThree" aria-expanded="false" aria-controls="flush-collapseThree"
	                >
	                  <div
	                    class="collapsed d-flex ck-coll"
	                    type="button"
	                    data-bs-toggle="collapse"
	                    data-bs-target="#flush-collapseThree"
	                    aria-expanded="false"
	                    aria-controls="flush-collapseThree"
	                  >
	                    <label class="ck-color-gray"> Marketing </label>
	                  </div>
	                  <div class="ck-switch-arrow">
	                    <div class="ck-switch-container">
	                      <div class="ck-switch">
	                        <input
	                          id="userAcceptsMarketing"
	                          type="checkbox"
	                          class="ck-switch-input"
	                        />
	                        <label
	                          for="userAcceptsMarketing"
	                          class="ck-switch-label"
	                        ></label>
	                      </div>
	                    </div>
	                    <svg
	                      id="arrow"
	                      aria-expanded="false"
	                      data-bs-toggle="collapse"
	                      aria-controls="flush-collapseThree"
	                      class="accord ck-accord ck-arrow-3"
	                      data-bs-target="#flush-collapseThree"
	                      xmlns="http://www.w3.org/2000/svg"
	                      width="16"
	                      height="16"
	                      viewBox="0 0 16 16"
	                      fill="none"
	                    >
	                      <path
	                        d="M2 5C2 5 7.65625 11 8 11C8.34375 11 14 5 14 5"
	                        stroke="#404040"
	                        stroke-width="1.5"
	                        stroke-linecap="round"
	                      />
	                    </svg>
	                  </div>
	                </div>
	                <div
	                  id="flush-collapseThree"
	                  class="accordion-collapse collapse"
	                  data-bs-parent="#accordionFlushExample"
	                >
	                  <div class="accordion-body ck-accordion-body">
	                    Estas cookies son utilizadas para fines
	                    publicitarios (registrar una identificación geográfica en
	                    dispositivos móviles, medir la eficacia de un anuncio y
	                    almacenar preferencias del reproductor de video del
	                    usuario).
	                  </div>
	                </div>
	              </div>
	            </div>
	          </div>
	
	          <div class="ckb-modal-footer ck-modal-footer">
	            <div class="ck-modal-btns d-flex">
	              <button
	                id="rejectCustomizationsBtn"
	                class="ck-custom-botton ck-rechazar-btn"
	                data-bs-dismiss="modal" onclick="hideModalCK();"
	              >
	                Rechazar todas
	              </button>
	              <button
	                data-bs-dismiss="modal" onclick="hideModalCK();"
	                id="acceptCustomizationsBtn"
	                class="ck-custom-botton ck-guarder-btn"
	              >
	                Guardar cambios
	              </button>
	            </div>
	          </div>
	        </div>
	      </div>
	    </div>
	</div>    
</div>
	<!-- fin Banner Cookies -->	

    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery-migrate-3.1.0.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
    <script type="text/javascript" src="layer-view-script/v2/swiper.js?v1"></script>
    <script type="text/javascript" src="layer-view-script/common/popup_time.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/landing/interface.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/landing/slick.min.js"></script>
    <script type="text/javascript" src="layer-view-script/v2/landing/jpreloader.js"></script>
    <script type="text/javascript" src="layer-view-script/client/book/validate.js"></script>
    <script type="text/javascript" src="layer-view-script/common/chatbot.js"></script>
    <script type="text/javascript" src="layer-view-script/common/popModal.js"></script>
    <script type="text/javascript" src="layer-view-script/game/copabicolor/popup_time.js?v=1"></script>
    <script type="text/javascript" src="layer-view-script/game/tinka/tinka-popup_time.js"></script>
    <script type="text/javascript" src="layer-view-script/game/casino/casino-popup_time.js"></script>
    <script type="text/javascript" src="layer-view-script/game/teapuesto/avionQatar/lotto-avionQatar.js?v=3"></script>
    <script type="text/javascript" src="layer-view-script/game/virtuales/juegaGanaConVirtuales.js?v=2"></script>
    <script type="text/javascript" src="layer-view-script/common/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="layer-view-script/client/bannerCookies.js?v=16"></script>
	<script type="text/javascript" charset="UTF-8" src="layer-view-script/client/analytics.js?v=<%=Constants.analytics_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/popupGenerate.js?v=10"></script>
	    <script type="text/javascript" src="layer-view-script/game/teapuesto/avionEstambul/lotto-avionEstambul.js?v=9"></script>
	    <script type="text/javascript" src="layer-view-script/game/teapuesto/avionPeru/lotto-avionPeru.js?v=4"></script>
    <script type="text/javascript">    
    
	    $("#password-client-header").bind("change keyup",function(){
	    	if( $("#password-client-header").val().length==0 ){
	    		$("#password-client-header-label").removeClass("fixeds-input-manual");
	    	}else if( $("#password-client-header").val().length>0 ){
	    		$("#password-client-header-label").addClass("fixeds-input-manual");
	    		$("#password-client-header").removeClass("error");
	    		$("#password-client-header").addClass("valid");
	    		$("#password-client-header").addClass("active");
	    		$("#errorTxt-onlypass").css("display","none");
	    	}
	    });
    
	    $('.popup .js-close-modal').click(function(event){
	    	$('.overlay.opened').removeClass('opened');
	    	$('body').removeClass('modal');
	    });


	    function openModal(popup,ctrl) {
	    	$(popup).addClass('opened');
	    	$('body').addClass('modal');
	    	if($.trim(ctrl).length>0) control = $.trim(ctrl);
	    }

	    $(document).delegate('#btn_desktop_ingresar_copacasa', 'click', function () {			
			 window.location.href = 'premiazoganagol.html';		   
		});

	    // boton popup avion qatar
	    $(document).delegate('#btn_desktop_ingresar_avionqatar', 'click', function () {			
			 window.location.href = 'te-apuesto-te-lleva-final-qatar.html';		   
		});
    
        $(document).ready(function(){        	
        	
        	var ban = localStorage.getItem("ban");
        	if(ban=="OK"){
        		localStorage.removeItem("ban");
        		var msgError = '<div style="font-family: \'Roboto\';"><div><img src="layer-view-image/client/alerta.png" style="margin-bottom:20px;"><p style="text-align: center;margin: 0px;"><b>Detectamos una irregularidad en tu cuenta</b><br><br>Por tu seguridad y de acuerdo con lo establecido en los T&C tu cuenta está bloqueada temporalmente.</p></div><br><br>'+
        		'<button class="button button-orange-light no-margin green" style="cursor: pointer; width: 50%;" onclick="closePopup(\'popup-message-session\')" type="button">OK</button></div>'; 
        		$('#msg-session').html(msgError);
        		openModal("#popup-message-session","");
        		$(".lightbox-recharge-ilot-close").css("display","none");
        		$(".iclose").css("display","none");
        	}

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
                '<button class="button button-orange-light no-margin green" onclick="validateSession2();getFastTokenAndRedirect();" type="button" style="width: 100%;">Ingresar</button></div>';
                $('#close-popup-session').hide();
                $('#msg-session').html(msgError);
            	openModal("#popup-message-session","");
            	
            }   

        	      	 		
               	
            var monthNames = ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set", "Oct", "Nov", "Dic"];

            function printBalls(balls, to) {
                var html = "";
                for (var i = 0; i < balls.length; i++) {
                	var special='';
                    if(i>5 && to!='#results-tinka-siosi'){
                        special=' result-ball-special';
                        }
//                     var special = ((i > 5) ? ' result-ball-special' : '');
                    html += '<span class="result-ball' + special + '"><span class="ball">' + balls[i] + '</span></span>';
                }
                $(to).html(html);
            }
          
            //popup tinka
            var flagPromoTinka = $("#flagPromoTinka").val();
            $.ajax({type: "POST", url: "flag-popup-siosi.html",async:false, success: function (e) {
            	flagPromoTinka = e;
			}})
	
			//if(flagPromoTinka == '1'){
				//activarPopupTinka('');
			//}		
			if(flagPromoTinka == 'true'){
				let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
				setTimeout(activarPopupTinka , timeUp) ;									
			}
			//fin popup tinka

            //popup casino
			var flagPromoCasino = $("#flagPromoCasino").val();
			var fechaFinCasino = new Date(2022,7,18,23,59,59);
			var fechaActualCasino = new Date();
			if( (fechaActualCasino.getTime() < fechaFinCasino.getTime() ) ){
				if(flagPromoCasino == '1' && flagPromoTinka == 'false'){
					let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
					setTimeout(activarPopupCasino , timeUp) ;
				}
			}else{
				flagPromoCasino = '0';
			}
			//fin popup casino
			
/*             var idsession = $("#clientId").val();
            var flagPromoBicolor = $("#flagPromoBicolor").val();
			if(idsession == ''){
					if(flagPromoBicolor == '1' && flagPromoTinka == 'false' && flagPromoCasino == '0'){
						let timeUp = (getCookieBanner('bannerCookies') != "") ? 0 : 3000;
						setTimeout(checkCount , timeUp) ;
					}																	
			} */
			
            function printDate(date, to) {
                var date = date.split("/");
                var datelocale = new Date(date[1] + "/" + date[0] + "/" + date[2]);
                $(to).html((datelocale.getDate() < 10 ? '0' + datelocale.getDate() : datelocale.getDate()) + ' ' + monthNames[datelocale.getMonth()]);
            }

            $.ajax({
              url: $("#gamesXML").val(),
              cache: false,
              success: function(res) {
                var xmlDoc = res;
                data = xmlDoc.getElementsByTagName("data");
                if (data[0]) {
                    
                    data = data[0];

                    var pozo_tinka = "S/ " + (data.getElementsByTagName("tk_pozo")[0]!=null && data.getElementsByTagName("tk_pozo")[0].hasChildNodes())?data.getElementsByTagName("tk_pozo")[0].childNodes[0].nodeValue:0;
                    $("#pozo-tinka").html(pozo_tinka).attr('data-text',pozo_tinka);
                    $("#pozo-tinka-0").html(pozo_tinka).attr('data-text',pozo_tinka);

                    var pozo_kabala;
                    
                    try{
	                    pozo_kabala = "S/ " + (data.getElementsByTagName("kb_pozo")[0]!=null && data.getElementsByTagName("kb_pozo")[0].hasChildNodes())?data.getElementsByTagName("kb_pozo")[0].childNodes[0].nodeValue:0;
	                    $("#pozo-kabala").html(pozo_kabala).attr('data-text',pozo_kabala);
                    }catch(error){
                    	
                    }
                    
                    var pozo_ganagol = (data.getElementsByTagName("gg_pozo")[0]!=null && data.getElementsByTagName("gg_pozo")[0].hasChildNodes())?data.getElementsByTagName("gg_pozo")[0].childNodes[0].nodeValue:0;

                    var last_pozo_ganagol = (data.getElementsByTagName("gg_last_pozo")[0]!=null && data.getElementsByTagName("gg_last_pozo")[0].hasChildNodes())?data.getElementsByTagName("gg_last_pozo")[0].childNodes[0].nodeValue:0;

                    if (pozo_ganagol == "POZO ACUMULADO POR DEFINIR") {
                        pozo_ganagol = "S/ " + last_pozo_ganagol;
                    } else {
                        pozo_ganagol = "S/ " + pozo_ganagol;
                    }

                    $("#pozo-ganagol").html(pozo_ganagol).attr('data-text',pozo_ganagol);

                    var pozo_ganadiario = "S/ " + (data.getElementsByTagName("gd_premio")[0]!=null && data.getElementsByTagName("gd_premio")[0].hasChildNodes())?data.getElementsByTagName("gd_premio")[0].childNodes[0].nodeValue:0;
                    $("#pozo-ganadiario").html(pozo_ganadiario).attr('data-text',pozo_ganadiario);

                    var bolos_tinka = (data.getElementsByTagName("tk_bolos")[0]!=null && data.getElementsByTagName("tk_bolos")[0].hasChildNodes())?data.getElementsByTagName("tk_bolos")[0].childNodes[0].nodeValue.split(' '):null;
                    var bolo_tinka_yapa = (data.getElementsByTagName("tk_yapa")[0]!=null && data.getElementsByTagName("tk_yapa")[0].hasChildNodes())?data.getElementsByTagName("tk_yapa")[0].childNodes[0].nodeValue:"";
                    bolos_tinka.push(bolo_tinka_yapa);

                    printBalls(bolos_tinka, "#results-tinka")
                    
                    //bolillas si o si
                    if(!data.getElementsByTagName("tk_siosi")[0].hasChildNodes()){
                    	$("#text-tinka-siosi").hide();
                    	$("#results-tinka-siosi").hide();
                        }
                    else{
                    	var bolos_tinka_siosi = (data.getElementsByTagName("tk_siosi")[0]!=null && data.getElementsByTagName("tk_siosi")[0].hasChildNodes())?data.getElementsByTagName("tk_siosi")[0].childNodes[0].nodeValue.split(' '):null;
                        printBalls(bolos_tinka_siosi, "#results-tinka-siosi")
                        }
                    

                    var results_date_tinka = (data.getElementsByTagName("tk_fecha")[0]!=null && data.getElementsByTagName("tk_fecha")[0].hasChildNodes())?data.getElementsByTagName("tk_fecha")[0].childNodes[0].nodeValue:"";
                    printDate(results_date_tinka, "#results-date-tinka");

                    var results_ganagol = (data.getElementsByTagName("gg_resultados")[0]!=null && data.getElementsByTagName("gg_resultados")[0].hasChildNodes())?data.getElementsByTagName("gg_resultados")[0].childNodes[0].nodeValue.split(' ').join(' - '):"";
                    $("#results-ganagol").html(results_ganagol);

                    var results_ganagol = (data.getElementsByTagName("gg_resultado_g200")[0]!=null && data.getElementsByTagName("gg_resultado_g200")[0].hasChildNodes())?data.getElementsByTagName("gg_resultado_g200")[0].childNodes[0].nodeValue.split(' ').join(' - '):"";
                    $("#result-g200").html(results_ganagol);

                    var results_date_ganagol = (data.getElementsByTagName("gg_fecha")[0]!=null && data.getElementsByTagName("gg_fecha")[0].hasChildNodes())?data.getElementsByTagName("gg_fecha")[0].childNodes[0].nodeValue:"";
                    printDate(results_date_ganagol, "#results-date-ganagol");

                    var bolos_kabala = (data.getElementsByTagName("kb_bolos_3")[0]!=null && data.getElementsByTagName("kb_bolos_3")[0].hasChildNodes())?data.getElementsByTagName("kb_bolos_3")[0].childNodes[0].nodeValue.split(' '):null;

                    printBalls(bolos_kabala, "#results-kabala");

                    var bolos_chauchamba = (data.getElementsByTagName("kb_chauchamba_3")[0]!=null && data.getElementsByTagName("kb_chauchamba_3")[0].hasChildNodes())?data.getElementsByTagName("kb_chauchamba_3")[0].childNodes[0].nodeValue.split(' '):null;

                    printBalls(bolos_chauchamba, "#results-chauchamba");

                    var results_date_kabala = (data.getElementsByTagName("kb_fecha_3")[0]!=null && data.getElementsByTagName("kb_fecha_3")[0].hasChildNodes())?data.getElementsByTagName("kb_fecha_3")[0].childNodes[0].nodeValue:"";
                    printDate(results_date_kabala, "#results-date-kabala");

                    var bolos_ganadiario = (data.getElementsByTagName("gd_resultados_6")[0]!=null && data.getElementsByTagName("gd_resultados_6")[0].hasChildNodes())?data.getElementsByTagName("gd_resultados_6")[0].childNodes[0].nodeValue.split(' '):null;

                    printBalls(bolos_ganadiario, "#results-ganadiario");

                    var results_date_ganadiario = (data.getElementsByTagName("gd_fecha_6")[0]!=null && data.getElementsByTagName("gd_fecha_6")[0].hasChildNodes())?data.getElementsByTagName("gd_fecha_6")[0].childNodes[0].nodeValue:"";
                    printDate(results_date_ganadiario, "#results-date-ganadiario");
                    
                    //30/10
                    var swiper = new Swiper('.swiper-container', {
                        effect: 'fade',
                        slidesPerView: 1,
                        initialSlide: 0,
                        loop: true,
                        pagination: {
                          el: '.swiper-pagination',
                          clickable: true,
                        },
                        navigation: {
                          nextEl: '.arrow-next',
                          prevEl: '.arrow-prev'
                        },
                        on: {
                      	  slideChangeTransitionEnd: function () {
                                let $slide = $('.swiper-pagination-bullet');
                                for (let i = 0; i < $slide.length; i++) {
                                    if ($slide.eq(i).hasClass('swiper-pagination-bullet-active')) {
                                        //add my pagination
                                        	var $this = $('#dock2 .dock-container2 a').eq(i);
          				                var slideIndex = $this.index();
          				                var id = $this.attr('id');
          				                $('#dock2 .dock-container2 a').removeClass('selected');
          				                $this.addClass('selected');               
          				                if (id == 'game-tinka') {$('#main-header .right-header__list__item').addClass('tinka');}
          				                else {$('#main-header .right-header__list__item').removeClass('tinka');}
                                    }
                                }
                            }
                        }
                      });
                              
                      $('.swiper-pagination-bullet').hover(function(e) {
                    	  e.stopPropagation();
                        $( this ).trigger( "click" );
                      });
                    
                } else {
                    console.log('no data')
                }

              }, error: function(e) {
                console.log('error obteniendo xml...')
              }
            });

            $('body').jpreLoader({}, function () {
              setTimeout(function(){
                $('.preloader-wrapper').addClass('fadeout');
                try {
                	tagBanner("game-tinka", 1);			
    			} catch (e) {
    				console.error(e);
    			}
                
                initAnimation();
                setTimeout(function(){
                    $('.preloader-wrapper').remove();
                }, 1000);
              },300);
            }).on('percentUpdate', function( e, progress ) {
                var ones = 0;
                var tens = 0;
                var cents = 0;
                ones = (progress % 10) * 110;
                tens = (Math.floor(progress/10)) * 110;
                cents = (Math.floor(progress/100)) * 110;
                $('.time-part.ones .digit-wrapper').css({
                    'transform': 'translateY(-' + ones + 'px)'
                });
                $('.time-part.tens .digit-wrapper').css({
                    'transform': 'translateY(-' + tens + 'px)'
                });
                $('.time-part.cents .digit-wrapper').css({
                    'transform': 'translateY(-' + cents + 'px)'
                });
            });

            /*$('#slider').slick({
                dots: true,
                arrows: false,
                infinite: true,
                speed: 500,
                fade: true,
                cssEase: 'linear',
                // autoplay: true,
                // autoplaySpeed: 2000
            });*/

           

            /*$('#dock2').Fisheye({
                maxWidth: 40,
                items: '.dock-item2',
                itemsText: 'span',
                container: '.dock-container2',
                itemWidth: 120,
                proximity: 70,
                halign: 'center',
                valign: 'middle'
            });*/

           /* $('#dock2 .dock-container2 a').on('click', function(e){
                e.preventDefault();
                var slideIndex = $(this).index();
                $('#slider').slick('slickGoTo', parseInt(slideIndex));
            });*/

            $('#dock2 .dock-container2').on('mouseenter', 'a', function(e){
            	e.stopPropagation();
                var $this = $(this);
                var slideIndex = $this.index();
               
                //$('#slider').slick('slickGoTo', parseInt(slideIndex));
                /*$('.slick-dots li').eq(slideIndex).find('button').trigger('click');*/
//                flagCarrusel=true;
                $('.swiper-pagination-bullet').eq(slideIndex).trigger('click');
            });
            $('#main-header .right-header__list__item').addClass('tinka');
            $('#login').on('click', function(e) {
                e.preventDefault();
                e.stopPropagation();
                 // var modal = $('.modal-auth');
                 // modal.toggleClass('show');
                 datalayerLogin(this);  
                 getFastTokenAndRedirect();
            });
            $('#registrarse').on('click', function(e) { 
                datalayerRegistro(this);      
            });
            $('#user-client-header , #password-client-header').on('focusout', function(e) { 
            	if($(this).val() != '') datalayerLoginForm(this);     
            });  
            
            $('.slick-arrow').on('click', function(e) {
                 var modal = $('.modal-auth');
                 modal.removeClass('show');
            });
            $('#slider').on('click', function(e) {
//                 e.preventDefault();
                e.stopPropagation();
                 var modal = $('.modal-auth');
                 modal.removeClass('show');
            });
            /*$('#slider').on('beforeChange', function(event, slick, currentSlide, nextSlide){
              $('#dock2 .dock-container2 a').removeClass('selected');
              $('#dock2 .dock-container2 a:nth-child(' + (nextSlide + 1) + ')').addClass('selected');
              if (nextSlide == 0 || nextSlide == 4) {$('#main-header .right-header__list__item').addClass('tinka');}
              else {$('#main-header .right-header__list__item').removeClass('tinka');}
            });*/
    
            /*$('#prevSlide').on('click', function(e) {
                e.preventDefault();
                $('#slider').slick('slickPrev');
            });*/

            /*$('#nextSlide').on('click', function(e) {
                e.preventDefault();
                $('#slider').slick('slickNext');
            });*/

            // $('#slider').on('mousewheel', function(event) {
            //  console.log(event)
            //     console.log(event.deltaX, event.deltaY, event.deltaFactor);
            // });

            $main = $('#main-animation');
            $button = $('#main-button');
            $buttons = $('.main-action .btn');
            $slider = $('#slider');
            $body = $("body");

            var wheelEvent = "mousewheel.home";
            var keyEvent = "keydown.home";

            /*$slider.on(wheelEvent, function(e) {
                if (e.originalEvent.wheelDelta < 0) {
                    $slider.slick('slickPrev');
                } else {
                    $slider.slick('slickNext');
                }
            });*/

            $body.on(keyEvent, function(b) {
                switch (b.which) {
                    case 40:
                        return $slider.slick('slickNext');
                    case 38:
                        return $slider.slick('slickPrev');
                    case 39:
                        return $slider.slick('slickNext');
                    case 37:
                        return $slider.slick('slickPrev');
                }
            });


            // Animations

            var gradient_percent = 0,
                gradient_offset = {
                  min: -40,
                  max: 140
                },
                speed = 2,
                gradient_color = 'rgba(255, 255, 255, 1)',
                empty_color = 'rgba(0, 0, 0 , 0)';

            setInterval(function() {
              gradient_percent += speed;
              
              if (gradient_percent > gradient_offset.max) {
                gradient_percent = gradient_offset.min;
              }
              
              $('.bounce-animated .mask-text').css('background-image', '-webkit-radial-gradient('+ gradient_percent +'% 50%, 3em 2em, ' + gradient_color + ' 0%, ' + empty_color + ' 100%)')
            }, 17);
			
            $("#frmLogin").validate({
            	rules: {
            		"user-client": "required",
            		"password-client": "required"
            	},
            	messages: {
            		"user-client": "DEBES INGRESAR TU USUARIO",
            		"password-client": "DEBES INGRESAR TU CONTRASEÑA"
            	},
    		  	onfocusout: function(element) {
    		         this.element(element);  
    		    },
            	errorElement : 'p',
                errorLabelContainer: '.errorTxt'
            });
            
            var lapolla = $('#game-lapolla'),
                tinka = $('#game-tinka'),
            	kabala = $('#game-kabala'),
                ganadiario = $('#game-ganadiario'),
                videoloterias = $('#game-videoloteria'),
                kinelo = $('#game-kinelo'),
                ganagol = $('#game-ganagol'),
                teapuesto = $('#game-teapuesto'), 
                //ddvv = $('#game-ddvv'),
                //casino = $('#game-casino'),
                logo = $('#main-logo'),
                container2 = $('.dock-container2'),
                arrows = $('.slick-arrow'),
                desc = $('#js-main-desc');
                /*tl = new TimelineLite({onComplete: function(){
                    $buttons.addClass('bounce-animated');
                }});*/

            function initAnimation() {
                $('#dock2').removeClass('animation1');
                setTimeout(function(){
                    $('#dock2').addClass('animation2');
                },1100);
                /*TweenLite.from(container2, 1.5, {opacity:0})
                TweenLite.from(arrows, 2, {opacity:0})

                tl
                    .from(logo, 0.8, {x: -200, autoAlpha: 1, ease:Sine.easeIn})
                    .from(tinka, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn}, "-=0.4")
                    .from(teapuesto, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn, delay: -0.3})
                    .from(ddvv, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn, delay: -0.3})
                    .from(ganagol, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn, delay: -0.3})
                    .from(kabala, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn, delay: -0.3})
                    .from(ganadiario, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn, delay: -0.3})
                    .from(kinelo, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn, delay: -0.3})
                    .from(raspaditas, .4, {y: 120, autoAlpha: 1, ease:Sine.easeIn, delay: -0.3})
                    .from($main, 1, {scale: 0.01, ease:Back.easeOut.config(1.5), opacity: 0})
                    .from(desc, .5, {opacity: 0})
                    .from($button, .5, {opacity: 0})*/
                    
                

            };

            renderNewPasswordField();

            
           	 
        });

        

        function prevslideOnclick(){
        	flagCarrusel=true;
        	banner2=false;
        }

        function nextslideOnclick(){
        	flagCarrusel=true;
        	banner2=true;
        }
        
        $(document).ready(function(){
			var clientIdSesion= $('#clientId').val();
			 if(clientIdSesion!=''){
				 validateSession();
				document.addEventListener("click", validateSession);
				document.addEventListener("keypress", validateSession);
			 }
			
		});

//         function mouseEvent(){
//         	banner3=true, banner2=true;
//         }
    </script>

    <script type="text/javascript">
        (function ($,undefined) {
           // var messagePromo = "<c:out value='${sessionScope.messagePromo}' />";
           var messagePromo = "<c:out value='${messagePromo}' />";
           if (messagePromo != undefined && $.trim(messagePromo)!= "") {
                jAlert(messagePromo, null);
            }
            //para destruir session
           // messagePromo = "<c:out value='${sessionScope.messagePromo}' />";
            // else  jAlert(messagePromo, null);
            //desplegable();
           //$('.tab-item').eq(0).trigger('click')
        }(jQuery));

        
    </script>


    
    
        

</body>
</html>

