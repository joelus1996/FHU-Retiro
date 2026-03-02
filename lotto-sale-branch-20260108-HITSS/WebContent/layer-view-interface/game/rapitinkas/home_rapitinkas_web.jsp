<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
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

    <meta charset="UTF-8">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/rapitinkas/themeRapitinka.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/styleRapitinkas.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
	<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/rapitinkas/imageflow.css">
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <title>Rapitinka</title> 
	<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <script type="text/javascript">		
	    var $image = function(){
			$('body').on({
				click : function() {$('#myImageFlowTwo_scrollbar').css("margin-top", "52px"); $('#myImageFlowTwo_scrollbar').css("position", "absolute");
				 $('#myImageFlowTwo_caption').css("width", "560px"); $('#myImageFlowTwo_caption').css("position", "absolute");
				 $('#myImageFlowTwo_caption').css("margin-left", "15px");}/*,
				mouseenter: function() {$('#myImageFlow_scrollbar').css("width", "380px"); $('#myImageFlowTwo_scrollbar').css("margin-left", "98px");
				 $('#myImageFlowTwo_scrollbar').css("margin-top", "52px"); $('#myImageFlowTwo_scrollbar').css("position", "absolute");
				 $('#myImageFlowTwo_caption').css("width", "590px"); $('#myImageFlowTwo_caption').css("position", "absolute");},
				mouseleave: function() {$('#myImageFlow_scrollbar').css("width", "380px"); $('#myImageFlowTwo_scrollbar').css("margin-left", "98px");
				 $('#myImageFlowTwo_scrollbar').css("margin-top", "52px"); $('#myImageFlowTwo_scrollbar').css("position", "absolute");
				 $('#myImageFlowTwo_caption').css("width", "590px"); $('#myImageFlowTwo_caption').css("position", "absolute");}*/
			}, '#myImageFlowTwo_scrollbar');

			$('body').on({
				click : function() {$('#myImageFlowFour_scrollbar').css("margin-top", "52px"); $('#myImageFlowFour_scrollbar').css("position", "absolute");
				 $('#myImageFlowFour_caption').css("width", "560px"); $('#myImageFlowFour_caption').css("position", "absolute");
				 $('#myImageFlowFour_caption').css("margin-left", "15px");}
			}, '#myImageFlowFour_scrollbar');
		};		
		$($image);
    </script>
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<div id="contenido" class="contenido">
		<div style="text-align:center; color:#8d2d92; font-family:Arial; font-weight:bold; font-size:14px; margin-top:15px;">¡RASPA Y GANA AL INSTANTE!</div>
         <div id= "part" class="show" style=" position: absolute; width:530px; height:200px; margin-top:20px;">    	
		<div id="myImageFlowTwo" class="imageflow" >
			<img id="i1" src="layer-view-image/game/rapitinkas/faces/MapaDelTesoro711_01.jpg"  class="imgs" width="290" height="146"  alt="<b>EL MAPA DEL TESORO - Costo S/.1</b><br>Si salen tres imágenes iguales, ganas la cantidad indicada  ¡Gana hasta S/.10,000!"/>
     		<img id="i2" src="layer-view-image/game/rapitinkas/faces/DientesDeOro710_01.jpg"   class="imgs" width="290" height="146" alt="<b>PIRATA DIENTES DE ORO - Costo S/.1</b><br>Si salen tres imágenes iguales, ganas la cantidad indicada  ¡Gana hasta S/.10,000!" />
     		<!-- 
	 		<img id="i3" src="layer-view-image/game/rapitinkas/faces/RapiMagdyel_01.jpg"   class="imgs" width="290" height="146" alt="<b>RAPIMAGDYEL PLAYERA - Costo S/.1</b><br>Si una cantidad se repite tres veces, ganas ese premio. ¡Gana hasta S/.10,000!"  />
			<img  id="i4" src="layer-view-image/game/rapitinkas/faces/RapiMagdyel_02.jpg"   class="imgs" width="290" height="146" alt="<b>RAPIMAGDYEL SAFARI - Costo S/.1</b><br>Si una cantidad se repite tres veces, ganas ese premio. ¡Gana hasta S/.10,000!" />
			<img  id="i5" src="layer-view-image/game/rapitinkas/faces/RapiMagdyel_03.jpg"   class="imgs" width="290" height="146" alt="<b>RAPIMAGDYEL FESTEJO - Costo S/.1</b><br>Si una cantidad se repite tres veces, ganas ese premio. ¡Gana hasta S/.10,000!"/>
				<img  id="i6" src="layer-view-image/game/rapitinkas/faces/RapiMagdyel_04.jpg" class="imgs" width="290" height="146"  alt="<b>RAPIMAGDYEL CARRERAS - Costo S/.1</b><br>Si una cantidad se repite tres veces, ganas ese premio. ¡Gana hasta S/.10,000!" />
				<img  id="i7" src="layer-view-image/game/rapitinkas/faces/RapiMagdyel_05.jpg"  class="imgs" width="290" height="146"  alt="<b>RAPIMAGDYEL REINA - Costo S/.1</b><br>Si una cantidad se repite tres veces, ganas ese premio. ¡Gana hasta S/.10,000!"/>
				-->
                <img  id="i8" src="layer-view-image/game/rapitinkas/faces/Michi_01.jpg"   class="imgs" width="290" height="146" alt="<b>MICHI - Costo S/.1</b><br>Si haces una línea vertical, horizontal o diagonal de tres montos iguales, ganas ese premio ¡Gana hasta S/.10,000!" />
				<img  id="i9" src="layer-view-image/game/rapitinkas/faces/Tragamonedas_01.jpg"   class="imgs" width="290" height="146"  alt="<b>TRAGAMONEDAS - Costo S/.1</b><br>Si encuentras tres imágenes iguales en una misma fila horizontal, ganas la cantidad indicada ¡Gana hasta S/.10,000!"/>
				<img  id="i10" src="layer-view-image/game/rapitinkas/faces/DuendeDeLaSuerte712_01.jpg"   class="imgs" width="290" height="146"  alt="<b>EL DUENDE DE LA SUERTE - Costo S/.1</b><br>Si salen tres imágenes iguales, ganas la cantidad indicada ¡Gana hasta S/.10,000!"/>        
  		 </div>
      </div>	 
	  </div>
 
    <script type="text/javascript" src="layer-view-script/game/rapitinkas/imageflow.js"></script>   
    <script type="text/javascript" src="layer-view-script/game/rapitinkas/swfobject.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
</body>
</html>