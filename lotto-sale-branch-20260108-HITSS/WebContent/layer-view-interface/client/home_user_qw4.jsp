<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/taglibs.jspf"%>
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

<meta charset="utf-8">
<meta name="viewport" content="width=1024">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">
<title>Mi cuenta</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<style>
.overlay {
    position: fixed;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    background: rgba(0, 0, 0, 0.7);
}
.popup.popup-sm.login-error {
    color: #5A5A5A;
    font-size: 16px;
    line-height: 19px;
    padding: 30px 30px 30px 30px;
    background: #F2F2F2;
    width: 90%;
    max-width: 350px;
    position: absolute;
    z-index: 220;
    left: 50%;
    top: 50%;
    margin: 0px;
    height: auto;
    transform: translate(-50%, -50%);
    text-align: center;
}
.titulo-login-error {
    font-size: 17.5px;
    font-weight: 900;
    font-family: "Roboto", sans-serif;
    text-align: center;
}
.mensaje-login-error {
    font-size: 16px;
    font-weight: 300;
    font-family: "Roboto", sans-serif;
}
.btn.btn-login-error {
    background-color: #07663a;
    color: #fafafa;
    box-shadow: none;
    font-size: 100%;
    width: 100%;
    height: 50px;
    border-radius: 30px;
    text-transform: none;
    font-family: 'AllerRegular';
}
</style>
</head>
<body style="background: transparent;">
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->


	<%@ include file="../include/header_qw4.jspf" %>
	
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery-migrate-3.1.0.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/index-qw4.js?v=5"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
<script type="text/javascript">
	function openModal(popup,ctrl) {
		$(popup).addClass('opened');
		$('body').addClass('modal');
		if($.trim(ctrl).length>0) control = $.trim(ctrl);
	}
	
	function closePopup(id) {
		let popup;
		if(typeof id == 'string')
			popup = $("#"+id);
		else
			popup = id.parentNode.parentNode;
		
		$(popup).css('transition','none');
		$(popup).css('-webkit-transition','none');
		$(popup).removeClass('opened');
		cerrarMensaje();
	}

	function goRegister(){
    	cerrarMensaje();
    	window.open('registro.html','_parent');
    }
    function goRecoverPassword(){
    	cerrarMensaje();
    	window.open('restablecer.html','_parent'); 	
    }
    function goArcoRights() {
    	cerrarMensaje();
    	window.open('derechos-arco.html','_parent');
    }
    function cerrarMensaje(){
    	try {
	       	var responseMessage = 'cerrarMensaje|OK';
	   		window.parent.postMessage(responseMessage,'*');
	   	}catch(err) {
	   		console.log(err.message);
	   	}
    }
</script>
</body>
</html>