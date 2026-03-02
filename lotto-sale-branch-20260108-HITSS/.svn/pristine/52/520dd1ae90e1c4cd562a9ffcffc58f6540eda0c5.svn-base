<%@page import="pe.com.intralot.loto.util.Constants"%>
<!DOCTYPE html>
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<meta http-equiv="Cache-Control" content="max-age=0" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Expires" content="0" />
<meta http-equiv="Expires" content="Tue, 01 Jan 1980 1:00:00 GMT" />
<meta http-equiv="Pragma" content="no-cache" />

<!-- title>Te Apuesto | Lotería Virtual - Zona Segura</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4" -->
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/teapuesto-header.css">
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<% 
    boolean logged = false, agreement = false;
    String user = null; 
    Double saldo = null; 
    Double bono  = null; 
    HttpSession nsession = request.getSession(false);
    try {
    	
    	if(session != null && nsession!=null && session.getAttribute("User") != null) {
    		pe.com.intralot.loto.layer.model.bean.UserBean userBean = (pe.com.intralot.loto.layer.model.bean.UserBean)session.getAttribute("User");
    		Integer cid = userBean.getpClientid();
    		agreement = (userBean.getpAgreement()==null || userBean.getpAgreement().trim().equals(""))?false:true;
    		
    	    if (cid!=null) {
    	    	String token = userBean.getpToken();
    		    if (token!=null) {
    				user = userBean.getpUser();
    				pe.com.intralot.loto.lib.Dbms rs = new pe.com.intralot.loto.lib.Dbms();
    			    String sql = " select max(nvl(cl_balance_amount,0)) + sum(nvl(decode(cg_sale_type,0,cg_balance_amount,0),0)), sum(nvl(decode(cg_sale_type,1,cg_balance_amount,0),0)) from lotocard.client, lotocard.client_game where client_id = ? and client_id = cg_client_id(+) and cg_game_id(+) = 108 ";
    			    rs.setSql(sql);
    		        rs.setString(1,String.valueOf(cid));
    		        rs.executeQuery();
    		        if (rs.next()) {
    		        	saldo = rs.getDouble(1);
    		        	bono  = rs.getDouble(2);
    		        }
    		        rs.close();
    				//saldo = userBean.getpMonto();
    				logged = true;
    				
    		    } 
    	    } 
    	}
    } catch (Exception e) {
    	 user = null; 
    	 saldo = null; 
    	 bono  = null;
    	 if(session != null && nsession!=null) session.invalidate();
    }
	
%>
<div id="popupInfo" class="head-wrapper" style="display: none;">
	<div class="head-callout border-callout login">
		<p>ERROR</p>
		<div id="popup-arrow"><b class="border-notch notch login"></b><b class="notch"></b></div>
	</div>
</div>
<div class="ui-content">
	<div class="container">
	<% if (logged && agreement)  { %>
		<div id="user-login" class="row pull-right">
			<div class="top-column expand">
				<span class="username"><%=user%></span>
			</div>
			<div class="top-column expand" onClick="window.location.reload();">
				<img src="layer-view-image/client/img-refresh.gif" alt="Refrescar" title="Refrescar" width="33" height="33" border="0" style="margin:0 10px 0 0;cursor:pointer;cursor:hand;">
			</div>
			<div class="top-column" onClick="window.location.reload();"> <!--  -->
<!--  				<span class="name">SALDO<br/>BONO<br/></span> -->
 				<span class="name">SALDO<br/></span>
 				<span class="change"> </span>
			</div>
			<div class="top-column wide" onClick="window.location.reload();">
<%--  				<span class="amount">S/ <%=saldo%><br/>S/ <%=bono%></span> --%>
					<span class="amount">S/ <%=saldo%><br/></span>
 				<span class="total"> </span>
			</div>
			<div class="top-column expand">
				<a href="mi-cuenta.html" target="_top" class="btn-orange loggedin">MI CUENTA</a>
				<a href="#" id="btnOut" class="btn-black loggedin">SALIR</a>
			</div>
		</div>
	<% } else { %>
		<div id="user-kept" class="row pull-right disabled">
			<div class="top-column exactl">
				Estimado cliente, hemos actualizado los t&eacute;rminos y condiciones de nuestra tienda virtual, por lo tanto le invitamos a informarse y aceptar el contenido de los mismos para que pueda continuar usando su cuenta de La Tinka.
			</div>
			<div class="top-column exactr">
				<!-- a href="term_condiciones.html" target="_blank" class="lnktyc">Ver t&eacute;rminos y condiciones</a -->
				<a href="#" class="lnktyc">Ver t&eacute;rminos y condiciones</a>
				<div class="bottom-block">
				<input type="checkbox" value="1" id="chkagreement" checked /><label for="chkagreement">Acepto los t&eacute;rminos y condiciones</label>
				<a href="#" id="btnAgree" class="btn-orange loggedin">ACEPTAR</a>
				</div>
			</div>
		</div>
		
		<div id="user-sms" class="row pull-right disabled">
			<div id = "detailMessage" class="top-column exactl">
			<!-- Ingresa el celular registrado en tu cuenta (Ejm: 999112233) o actual&iacute;zalo aqu&iacute;.<br/>Recibir&aacute;s un SMS con un c&oacute;digo de activaci&oacute;n. -->
			<!-- Ingresa el celular registrado o actual&iacute;zalo aqu&iacute;.<br/>Te enviaremos un c&oacute;digo de activaci&oacute;n por SMS. -->
			<b>ACTIVA TU CUENTA:</b> Ingresa el c&oacute;digo de activaci&oacute;n, enviado v&iacute;a SMS a tu celular.<br/>
			<span class="error" id="alertTelfVerify"></span>
			<span class="error" id="alertCodeVerify"></span>
			</div>
			
			<div id="message-sms" class="top-column exactr disabled">
				<input type="text" id="user-phone" placeholder="Ingresa tu celular" style="width:140px;" />
				<a href="#" id="btnSendSms" class="btn-orange loggedin">ENVIAR SMS</a>
				<a href="#" id="lnkActiveCode" class="btn-orange loggedin">YA TENGO UN CÓDIGO</a>
			</div>
			<div id="message-code" class="top-column exactr">
				<input type="text" id="user-code" placeholder="Digita el código" style="width:160px;" />
				<a href="#" id="btnSendCode" class="btn-orange loggedin">CONFIRMAR</a>
				<a href="#" id="lnkSendSms" class="btn-orange loggedin">ENVIAR OTRO SMS</a>
			</div>
						
		</div>
		
		<div id="user-mail" class="row pull-right disabled">
			<div id="message-mail" class="top-column exactl">
			Hola, hemos verificado que el correo electr&oacute;nico, registrado en la cuenta ha sido registrado en otra cuenta.<br/><br/>Registra aqu&iacute; un nuevo correo electr&oacute;nico.
			<!-- Hola, hemos verificado que el correo electr&oacute;nico de la cuenta ha sido registrado y activado en otra cuenta de usuario. Registra aqu&iacute; un nuevo correo electr&oacute;nico. -->
			</div>
			<div class="top-column exactr">
				<div class="bottom-block-validation">
				<input type="text" id="user-new-mail" placeholder="Ingresa tu correo"/>
				<a href="#" id="btnUpdateMail" class="btn-orange loggedin">ACEPTAR</a>
				</div>
			</div>
		</div>
	
		<div id="user-ibbonus" class="row disabled"></div>
		<div id="user-rdbonus" class="row disabled"></div>
	
		<div id="user-logout" class="row pull-right">
			<form action="teapuesto-iflex.html" id="form-sign-in" method="post">
				<a href="registro.html" target="_top" class="btn-orange login register-trigger">REG&Iacute;STRATE</a>
				<input id="user" name="user-client" class="username ie7fix" type="text" placeholder="USUARIO" maxlength="25" autocomplete="on" required />
				<input id="password" name="password-client" class="password ie7fix" type="password" placeholder="CONTRASEÑA" maxlength="100" autocomplete="off" required />
				<input type="hidden" name="channel" value="1">
				<input type="hidden" id="iflexBonoTyC" value="<%=Constants.iflexBonoTyC.toString().trim()%>" />
				<input type="hidden" id="wbBonoTyC" value="<%=Constants.wbBonoTyC.toString().trim()%>" />
				<button id="btnEnter" class="btn-black login">INGRESAR</button>
			</form>
			<div class="bottom-line">
				<a href="restablecer.html" target="_top" class="forgot">¿Olvid&eacute; mi contrase&ntilde;a?</a>
			</div>
		</div>
	<% } %>
	</div>
</div>
</body>
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/teapuesto-header.js"></script>
</html>