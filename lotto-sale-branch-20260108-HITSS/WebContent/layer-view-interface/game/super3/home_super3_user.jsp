<%@ include file="../../include/taglibs.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<c:if test="${isLottoSale == true && isSuper3Sale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=super3"/></c:if>
<meta charset="utf-8">
<meta name="description" content="Juega en línea la única lotería que sortea todos los días cien mil soles (S/.100,000) en el Perú. ¡Juega Gana Diario y mejora tu vida hoy!">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>" />
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/super3/theme.css" />
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/super3/themeSuper3.css" />
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css"/>
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"/>
<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
<title>Super3</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<%@ include file="../../include/header.jspf" %>
<div id='main-content-background'>
<div id='main-content' class="group">

<!--
<a onclick="openSuper3Cotejador();">
<div class="PortletContent">
</div>	
</a>
-->

<%@ include file="../../include/menu.jspf" %>
<input type="hidden" value="${super3SaleBean.numbersMore}" id="more_repeated">
<input type="hidden" value="${super3SaleBean.numbersLess}" id="less_repeated">
<input type="hidden" value="${super3SaleBean.status}" id="status">
<input type="hidden" value="${super3SaleBean.simpleBetPrice}" id="simpleBetPrice_repeated">
<input type="hidden" value="${super3SaleBean.promotionType}" id="promo">
<input type="hidden" value="${super3SaleBean.priceType}" id="price_type">
<input type="hidden" value="${super3SaleBean.algorithm}" id="algorithm">
<input type="hidden" value="${super3SaleBean.bets}" id="bets">
<input type="hidden" value="${super3SaleBean.pay}" id="pay">
<input type="hidden" value="${super3SaleBean.cost}" id="cost">
<input type="hidden" value="${super3SaleBean.draws}" id="draw">

<div class="super3 group">
<div id="center-text">
    <div id="premio"> Elige cómo jugar y cuánto ganar</div>
</div>
<!--<c:if test="${super3SaleBean.status == 'CIE'}">
 		<div id="hora-ini-juego">
			     	<div>Próximo sorteo</div>
				  	<div>Abre HOY</div>
				    <div>a las ${super3SaleBean.openHour}</div>
	    </div>
   </c:if> -->   
<div id="hora-fin-juego">
	<div class="center-text-time">Juégalo cada 5 minutos</div>
	<div class="center-text-time">desde las 6:00 am hasta</div>
	<div class="center-text-time">2:00 am del día siguiente</div>  
</div>
<div class="">
<div>
<div style="position:relative;">
<div id="transition" class="transition-one"></div>

<a id ="help" href="https://latinkaportal.com.pe/" target="_black"></a>
</div>
<div class="font-play group">

<!-- HOME PURCHASE --> 
<div class="finalize-purchase">
	<div id='content-purchase'>
		<div class='left-panel' class='left-panel'>
			<span class='label_1'>SUPER 3</span>
			<div id="content-grid-result"></div>
			<div id="num_link"></div>
		</div>
		<div class='right-panel'>
			<div class='label_2'>dd/mm/yy</div>
			<div class="result_purchase">
				<div class="label_resu1">TOTAL A PAGAR</div>
				<div class="label_resu2"></div>
				<div class="label_resu3"></div>
				<div class="label_resu4"></div>
				<div class="result1">S/. 0.00</div>
			</div>
			<!-- div id="more_plays" class="class_more_plays"></div>
			<div id="keep-playing" class="class-keep-playing"></div>
			<div id="game-history" class="class-game-history"></div -->
			<div id="panel_more_plays"><a href="#" class="class_more_plays" id='more_plays' onclick="return false;"></a></div>
			<div id="panel_keep-playing"><a href="juega-super3.html" class="class-keep-playing" id='keep-playing'></a></div>
			<div id="panel_game-history"><a href="mi-cuenta.html#jugadas" class="class-game-history" id='game-history'></a></div>
		</div>
		<!-- div style="clear: both; padding-top: 10px;" -->
		<div class="title-descripcion-apuesta">Tipos de Apuestas</div>
		<div class="descripcion-apuesta">O:3 en orden, C:3 en desorden, D:2 en orden y U:1 en orden</div>
		<div id="sub_purchase">
			<div id="sub_panel">
				<div id="login_section">
					<div class="label1">LOGIN: Ingresa a tu cuenta para realizar tu pago.</div>
					<div>
						<form id="frmLoginClient" action="login_super3.html" method="post">
							<table border='0'>
								<tr>
									<td><span class='label-login'>Usuario</span></td>
									<td><input id='user-client' type='text' name='user-client' class='text-pass'></td>
									<td><span class='label-login'>Contrase&ntilde;a</span></td>
									<td><input id='password-client' type="password" name='password-client' class='text-pass'></td>
									<td><input type="submit" value="Ingresar" class="button-ingresar" id="home-btnlogin"></td>									
								</tr>
							</table>
							
						</form>
					</div>
					<div class="label2">
					   <a href="#">¿Olvidaste tu usuario?</a> | <a href="restablecer.html">¿Olvidaste tu Contrase&ntilde;a?</a>
					</div>
				</div>
				<form id="frmLoadBalance">
					<div id="payments_section">
						<div id="pan_0">
							<div class="label1">PAGAR</div>
							<table>
								<tr>
									<td style="vertical-align: top;"><input type="radio" name="option-card" checked="checked" value="0" id="option-card-0" /></td>
									<td style="vertical-align: top;">
									<label for="option-card-0"><span>Quiero descontar de mi saldo disponible S/.</span>
									<span id="field-balance-amount">${super3SaleBean.balanceAmount}</span><br>
									<span class="saldo_promocional"> <c:if test="${super3SaleBean.balanceAmountGame!='0.0'}">
									&oacute; de mi saldo promocional S/.${super3SaleBean.balanceAmountGame}
              					</c:if>
									</span>
									</label>
									</td>
								</tr>
							</table>
						</div>
                    	<div id="separator_hr"></div>
						<div id="pan_1">
							<div class="label2">RECARGAS POR INTERNET</div>
							<table>
						<c:forTokens var="channel1Order" items="${super3SaleBean.channel1Order}" delims=",">
							<%@ include file="../../include/balance1.jspf"%>
						</c:forTokens>
						</table>
						<div class="label2">RECARGAS F&Iacute;SICAS</div>
						<table>
						<c:forTokens var="channel2Order" items="${super3SaleBean.channel2Order}" delims=",">
							<%@ include file="../../include/balance2.jspf"%>
						</c:forTokens>
						</table>
						</div>
						<div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div>
					</div>
				</form>
			</div>
			<div id="panel_finaliza_compra"><a href="#" class="btn_finaliza_compra" id='btn_finaliza_compra' onclick="return false;"></a></div>
		</div>
	</div>     
    <div id="ico-block">
	    <div id="ico-title">&iexcl;SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
	    <div id="ico-panel">
			<a href="juega-tinka.html" class="button-icotinka" id='icotinka'></a>
			<a href="juega-kabala.html" class="button-icokabala" id='icokabala'></a>
			<a href="juega-ganadiario.html" class="button-icoganadiario" id='icoganadiario'></a>
			<a href="juega-kinelo.html" class="button-icokinelo" id='icokinelo'></a>
			<a onclick="toTAV2();" class="button-icoteapuesto hand" id='icoteapuesto'></a>
			<a href="juega-ganagol.html" class="button-icoganagol" id='icoganagol'></a>
			<!-- a href="juega-clicygana.html" class="button-icoclicygana" id='icoclicygana'></a -->
			<!-- a href="juega-deportesvirtuales.html" class="button-icodeportesvirtuales" id='icodeportesvirtuales'></a -->
			<!-- a href="juega-super3.html" class="button-icosuper3" id='icosuper3'></a -->
			<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/reventon" class="button-icoelreventon" id='icoelreventon'></a -->
			<!-- a href="juega-rapitinkas.html" class="button-icorapitinkas" id='icorapitinkas'></a -->
			<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/instantaneas" class="button-icorapigana" id='icorapigana'></a -->
			<!-- a target='_blank' href="http://www.intralot.com.pe/intralotportal/giromagico" class="button-icogiromagico" id='icogiromagico'></a -->
			<!-- a href="juega-fechaza.html" class="button-icofechaza" id='icofechaza'></a --> 
		</div> 
    </div>
	<div class="img_zona_segura"></div>
</div>
  <!-- END PURCHASE --> 
  
<form name="start_play" id="start_play">
<div class="linear">

<div id="part1">
<div class="left">
<div class="text-play">JUGADA A</div>


<div class="number-textarea-button">
<div class="paso"></div>
<div class="step_one"><span class="text-number"> Marca una casilla</span><span class="text-number"> o más, c/u S/. 1.00</span>
<input type="checkbox" name="J1_Ocheck"
	id="J1_Ocheck_1" value="O" class="J1_Ocheck_1" /><label id="LJ1_Ocheck_1"
	for="J1_Ocheck_1" class="check_" style="
    margin-top: 5px;
    width: 80px;
"><b>3 en orden</b></label>

<input type="checkbox" name="J1_Ccheck"
	id="J1_Ccheck_1" value="C" class="J1_Ccheck_1" /><label id="LJ1_Ccheck_1"
	for="J1_Ccheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>3 en desorden</b></label>

<input type="checkbox" name="J1_Dcheck"
	id="J1_Dcheck_1" value="D" class="J1_Dcheck_1" /><label id="LJ1_Dcheck_1"
	for="J1_Dcheck_1" class="check_" style="margin-top: 3px;
    width: 80px;
"><b>2 en orden</b></label>

<input type="checkbox" name="J1_Ucheck"
	id="J1_Ucheck_1" value="U" class="J1_Ucheck_1" /><label id="LJ1_Ucheck_1"
	for="J1_Ucheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>1 en orden</b></label>


<div class="group-number">
<div class="order">
Multiplica tu
premio por:
(opcional)
</div>
<div class="margin"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_2" value="2" class="J1_Mcheck_2" /><label id="LJ1_Mcheck_2"
	for="J1_Mcheck_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J1_Mcheck" id="J1_Mcheck_3" value="3" class="J1_Mcheck_3" /><label
	for="J1_Mcheck_3" id="LJ1_Mcheck_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J1_Mcheck" id="J1_Mcheck_4" value="4"
	class="J1_Mcheck_4" /><label for="J1_Mcheck_4" id="LJ1_Mcheck_4"
	class="check_"><b>4</b></label> </div>

<div class="margin"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_5" value="5" class="J1_Mcheck_5" /><label for="J1_Mcheck_5"
	id="LJ1_Mcheck_5" class="check_"><b>5</b></label> <input type="checkbox"
	name="J1_Mcheck" id="J1_Mcheck_6" value="6" class="J1_Mcheck_6" /><label
	for="J1_Mcheck_6" id="LJ1_Mcheck_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J1Mcheck" id="J1_Mcheck_10" value="10"
	class="J1_Mcheck_10" /><label for="J1_Mcheck_10" id="LJ1_Mcheck_10"
	class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_20" value="20" class="J1_Mcheck_20" /><label
	for="J1_Mcheck_20" id="LJ1_Mcheck_20" class="check_"><b>20</b></label> <input
	type="checkbox" name="J1_Mcheck" id="J1_Mcheck_30" value="30"
	class="J1_Mcheck_30" /><label for="J1_Mcheck_30" id="LJ1_Mcheck_30"
	class="check_"><b>30</b></label> <input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_40" value="40" class="J1_Mcheck_40" /><label
	for="J1_Mcheck_40" id="LJ1_Mcheck_40" class="check_"><b>40</b></label> </div>

<div style="margin-left: -45px;"><input type="checkbox" name="J1_Mcheck"
	id="J1_Mcheck_50" value="50" class="J1_Mcheck_50" /><label
	for="J1_Mcheck_50" id="LJ1_Mcheck_50" class="check_"><b>50</b></label></div>

</div>
</div>




<div style="margin-left: 100px;">
	<div class="text-number">Marca una casilla o más en cada columna</div>
<div class="linear">
<div class="container">
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_0" value="0" class="J1_1check_0" /><label id="LJ1_1check_0"
	for="J1_1check_0" class="check_"><b>0</b></label> <input type="checkbox"
	name="J1_2check" id="J1_2check_0" value="0" class="J1_2check_0" /><label
	for="J1_2check_0" id="LJ1_2check_0" class="check_"><b>0</b></label> <input
	type="checkbox" name="J1_3check" id="J1_3check_0" value="0"
	class="J1_3check_0" /><label for="J1_3check_0" id="LJ1_3check_0"
	class="check_"><b>0</b></label> </div>

<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_1" value="1" class="J1_1check_1" /><label id="LJ1_1check_1"
	for="J1_1check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J1_2check" id="J1_2check_1" value="1" class="J1_2check_1" /><label
	for="J1_2check_1" id="LJ1_2check_1" class="check_"><b>1</b></label> <input
	type="checkbox" name="J1_3check" id="J1_3check_1" value="1"
	class="J1_3check_1" /><label for="J1_3check_1" id="LJ1_3check_1"
	class="check_"><b>1</b></label> </div>

<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_2" value="2" class="J1_1check_2" /><label for="J1_1check_2"
	id="LJ1_1check_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J1_2check" id="J1_2check_2" value="2" class="J1_2check_2" /><label
	for="J1_2check_2" id="LJ1_2check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J1_3check" id="J1_3check_2" value="2"
	class="J1_3check_2" /><label for="J1_3check_2" id="LJ1_3check_2"
	class="check_"><b>2</b></label></div>


<div class="margin"><input type="checkbox" name="J1check"
	id="J1_1check_3" value="" class="J1_1check_3" /><label
	for="J1_1check_3" id="LJ1_1check_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_3" value="3"
	class="J1_2check_3" /><label for="J1_2check_3" id="LJ1_2check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_3" value="3" class="J1_3check_3" /><label
	for="J1_3check_3" id="LJ1_3check_3" class="check_"><b>3</b></label> </div>
    
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_4" value="4" class="J1_1check_4" /><label
	for="J1_1check_4" id="LJ1_1check_4" class="check_"><b>4</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_4" value="4"
	class="J1_2check_4" /><label for="J1_2check_4" id="LJ1_2check_4"
	class="check_"><b>4</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_4" value="4" class="J1_3check_4" /><label
	for="J1_3check_4" id="LJ1_3check_4" class="check_"><b>4</b></label> </div>
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_5" value="5" class="J1_1check_5" /><label
	for="J1_1check_5" id="LJ1_1check_5" class="check_"><b>5</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_5" value="5"
	class="J1_2check_5" /><label for="J1_2check_5" id="LJ1_2check_5"
	class="check_"><b>5</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_5" value="5" class="J1_3check_5" /><label
	for="J1_3check_5" id="LJ1_3check_5" class="check_"><b>5</b></label></div>
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_6" value="6" class="J1_1check_6" /><label
	for="J1_1check_6" id="LJ1_1check_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_6" value="6"
	class="J1_2check_6" /><label for="J1_2check_6" id="LJ1_2check_6"
	class="check_"><b>6</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_6" value="6" class="J1_3check_6" /><label
	for="J1_3check_6" id="LJ1_3check_6" class="check_"><b>6</b></label> </div>
<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_7" value="7" class="J1_1check_7" /><label
	for="J1_1check_7" id="LJ1_1check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_7" value="7"
	class="J1_2check_7" /><label for="J1_2check_7" id="LJ1_2check_7"
	class="check_"><b>7</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_7" value="7" class="J1_3check_7" /><label
	for="J1_3check_7" id="LJ1_3check_7" class="check_"><b>7</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_8" value="8" class="J1_1check_8" /><label
	for="J1_1check_8" id="LJ1_1check_8" class="check_"><b>8</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_8" value="8"
	class="J1_2check_8" /><label for="J1_2check_8" id="LJ1_2check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_8" value="8" class="J1_3check_8" /><label
	for="J1_3check_8" id="LJ1_3check_8" class="check_"><b>8</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J1_1check"
	id="J1_1check_9" value="9" class="J1_1check_9" /><label
	for="J1_1check_9" id="LJ1_1check_9" class="check_"><b>9</b></label> <input
	type="checkbox" name="J1_2check" id="J1_2check_9" value="9"
	class="J1_2check_9" /><label for="J1_2check_9" id="LJ1_2check_9"
	class="check_"><b>9</b></label> <input type="checkbox" name="J1_3check"
	id="J1_3check_9" value="9" class="J1_3check_9" /><label
	for="J1_3check_9" id="LJ1_3check_9" class="check_"><b>9</b></label></div>
    
</div>
</div>

<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" 
	 id="J1-text-area" readonly="readonly"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J1azar"><img
	src="layer-view-image/game/super3/flecha-s3.gif" height="5"
	width="5" class="icon" /><span class="text">Agregar al azar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button" >
<div class="clear" id="J1clear"><img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>

<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="more" id="J1more">
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">M&#225;s
salieron</span>
</div>
</div>


<div class="separate-bottun"></div>
<div class="attribute-button">
<div id="J1less" class="less" >
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div>
</div>


</div>
</div>

</div>





</div>

</div>


<div class="right">

<div class="text-play">JUGADA B</div>



<div class="number-textarea-button">
<div class="paso"></div>
<div class="step_one"><span class="text-number"> Marca una casilla</span><span class="text-number"> o más, c/u S/. 1.00</span>
<input type="checkbox" name="J2_Ocheck"
	id="J2_Ocheck_1" value="O" class="J2_Ocheck_1" /><label id="LJ2_Ocheck_1"
	for="J2_Ocheck_1" class="check_" style="
    margin-top: 5px;
    width: 80px;
"><b>3 en orden</b></label>

<input type="checkbox" name="J2_Ccheck"
	id="J2_Ccheck_1" value="C" class="J2_Ccheck_1" /><label id="LJ2_Ccheck_1"
	for="J2_Ccheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>3 en desorden</b></label>

<input type="checkbox" name="J2_Dcheck"
	id="J2_Dcheck_1" value="D" class="J2_Dcheck_1" /><label id="LJ2_Dcheck_1"
	for="J2_Dcheck_1" class="check_" style="margin-top: 3px;
    width: 80px;
"><b>2 en orden</b></label>

<input type="checkbox" name="J2_Ucheck"
	id="J2_Ucheck_1" value="U" class="J2_Ucheck_1" /><label id="LJ2_Ucheck_1"
	for="J2_Ucheck_1" class="check_" style="
    margin-top: 3px;
    width: 80px;
"><b>1 en orden</b></label>


<div class="group-number">
<div class="order">
Multiplica tu
premio por:
(opcional)
</div>
<div class="margin"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_2" value="2" class="J2_Mcheck_2" /><label id="LJ2_Mcheck_2"
	for="J2_Mcheck_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J2_Mcheck" id="J2_Mcheck_3" value="3" class="J2_Mcheck_3" /><label
	for="J2_Mcheck_3" id="LJ2_Mcheck_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J2_Mcheck" id="J2_Mcheck_4" value="4"
	class="J2_Mcheck_4" /><label for="J2_Mcheck_4" id="LJ2_Mcheck_4"
	class="check_"><b>4</b></label> </div>

<div class="margin"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_5" value="5" class="J2_Mcheck_5" /><label for="J2_Mcheck_5"
	id="LJ2_Mcheck_5" class="check_"><b>5</b></label> <input type="checkbox"
	name="J2_Mcheck" id="J2_Mcheck_6" value="6" class="J2_Mcheck_6" /><label
	for="J2_Mcheck_6" id="LJ2_Mcheck_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J2_Mcheck" id="J2_Mcheck_10" value="10"
	class="J2_Mcheck_10" /><label for="J2_Mcheck_10" id="LJ2_Mcheck_10"
	class="check_"><b>10</b></label></div>


<div class="margin"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_20" value="20" class="J2_Mcheck_20" /><label
	for="J2_Mcheck_20" id="LJ2_Mcheck_20" class="check_"><b>20</b></label> <input
	type="checkbox" name="J2_Mcheck" id="J2_Mcheck_30" value="30"
	class="J2_Mcheck_30" /><label for="J2_Mcheck_30" id="LJ2_Mcheck_30"
	class="check_"><b>30</b></label> <input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_40" value="40" class="J2_Mcheck_40" /><label
	for="J2_Mcheck_40" id="LJ2_Mcheck_40" class="check_"><b>40</b></label> </div>

<div style="margin-left: 18px;
text-align: left;"><input type="checkbox" name="J2_Mcheck"
	id="J2_Mcheck_50" value="50" class="J2_Mcheck_50" /><label
	for="J2_Mcheck_50" id="LJ2_Mcheck_50" class="check_"><b>50</b></label></div>

</div>
</div>




<div style="margin-left: 100px;">
	<div class="text-number">Marca una casilla o más en cada columna
	</div>
<div class="linear">
<div class="container">
<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_0" value="0" class="J2_1check_0" /><label id="LJ2_1check_0"
	for="J2_1check_0" class="check_"><b>0</b></label> <input type="checkbox"
	name="J2_2check" id="J2_2check_0" value="0" class="J2_2check_0" /><label
	for="J2_2check_0" id="LJ2_2check_0" class="check_"><b>0</b></label> <input
	type="checkbox" name="J2_3check" id="J2_3check_0" value="0"
	class="J2_3check_0" /><label for="J2_3check_0" id="LJ2_3check_0"
	class="check_"><b>0</b></label> </div>

<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_1" value="1" class="J2_1check_1" /><label id="LJ2_1check_1"
	for="J2_1check_1" class="check_"><b>1</b></label> <input type="checkbox"
	name="J2_2check" id="J2_2check_1" value="1" class="J2_2check_1" /><label
	for="J2_2check_1" id="LJ2_2check_1" class="check_"><b>1</b></label> <input
	type="checkbox" name="J2_3check" id="J2_3check_1" value="1"
	class="J2_3check_1" /><label for="J2_3check_1" id="LJ2_3check_1"
	class="check_"><b>1</b></label> </div>

<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_2" value="2" class="J2_1check_2" /><label for="J2_1check_2"
	id="LJ2_1check_2" class="check_"><b>2</b></label> <input type="checkbox"
	name="J2_2check" id="J2_2check_2" value="2" class="J2_2check_2" /><label
	for="J2_2check_2" id="LJ2_2check_2" class="check_"><b>2</b></label> <input
	type="checkbox" name="J2_3check" id="J2_3check_2" value="2"
	class="J2_3check_2" /><label for="J2_3check_2" id="LJ2_3check_2"
	class="check_"><b>2</b></label></div>


<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_3" value="" class="J2_1check_3" /><label
	for="J2_1check_3" id="LJ2_1check_3" class="check_"><b>3</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_3" value="3"
	class="J2_2check_3" /><label for="J2_2check_3" id="LJ2_2check_3"
	class="check_"><b>3</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_3" value="3" class="J2_3check_3" /><label
	for="J2_3check_3" id="LJ2_3check_3" class="check_"><b>3</b></label> </div>
    
<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_4" value="4" class="J2_1check_4" /><label
	for="J2_1check_4" id="LJ2_1check_4" class="check_"><b>4</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_4" value="4"
	class="J2_2check_4" /><label for="J2_2check_4" id="LJ2_2check_4"
	class="check_"><b>4</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_4" value="4" class="J2_3check_4" /><label
	for="J2_3check_4" id="LJ2_3check_4" class="check_"><b>4</b></label> </div>
<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_5" value="5" class="J2_1check_5" /><label
	for="J2_1check_5" id="LJ2_1check_5" class="check_"><b>5</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_5" value="5"
	class="J2_2check_5" /><label for="J2_2check_5" id="LJ2_2check_5"
	class="check_"><b>5</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_5" value="5" class="J2_3check_5" /><label
	for="J2_3check_5" id="LJ2_3check_5" class="check_"><b>5</b></label></div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_6" value="6" class="J2_1check_6" /><label
	for="J2_1check_6" id="LJ2_1check_6" class="check_"><b>6</b></label> <input
	type="checkbox" name="J2check" id="J2_2check_6" value="6"
	class="J2_2check_6" /><label for="J2_2check_6" id="LJ2_2check_6"
	class="check_"><b>6</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_6" value="6" class="J2_3check_6" /><label
	for="J2_3check_6" id="LJ2_3check_6" class="check_"><b>6</b></label> </div>
<div class="margin"><input type="checkbox" name="J2check"
	id="J2_1check_7" value="7" class="J2_1check_7" /><label
	for="J2_1check_7" id="LJ2_1check_7" class="check_"><b>7</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_7" value="7"
	class="J2_2check_7" /><label for="J2_2check_7" id="LJ2_2check_7"
	class="check_"><b>7</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_7" value="7" class="J2_3check_7" /><label
	for="J2_3check_7" id="LJ2_3check_7" class="check_"><b>7</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_8" value="8" class="J2_1check_8" /><label
	for="J2_1check_8" id="LJ2_1check_8" class="check_"><b>8</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_8" value="8"
	class="J2_2check_8" /><label for="J2_2check_8" id="LJ2_2check_8"
	class="check_"><b>8</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_8" value="8" class="J2_3check_8" /><label
	for="J2_3check_8" id="LJ2_3check_8" class="check_"><b>8</b></label></div>
	
	<div class="margin"><input type="checkbox" name="J2_1check"
	id="J2_1check_9" value="9" class="J2_1check_9" /><label
	for="J2_1check_9" id="LJ2_1check_9" class="check_"><b>9</b></label> <input
	type="checkbox" name="J2_2check" id="J2_2check_9" value="9"
	class="J2_2check_9" /><label for="J2_2check_9" id="LJ2_2check_9"
	class="check_"><b>9</b></label> <input type="checkbox" name="J2_3check"
	id="J2_3check_9" value="9" class="J2_3check_9" /><label
	for="J2_3check_9" id="LJ2_3check_9" class="check_"><b>9</b></label></div>
    
</div>
</div>

<div class="separate-textarea-number">

<div class="height-div"><span class="text-number-marcado">Tus
n&#250;meros son:</span> <textarea class="attribute-texarea" 
	 id="J2-text-area" readonly="readonly"></textarea></div>

<div class="separate-textarea-bottuns">
<div class="attribute-button">
<div class="azar" id="J2azar"><img
	src="layer-view-image/game/super3/flecha-s3.gif" height="5"
	width="5" class="icon" /><span class="text">Agregar al azar</span></div>
</div>
<div class="separate-bottun"></div>
<div class="attribute-button" >
<div class="clear" id="J2clear"><img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Limpiar</span></div>
</div>

<div class="separate-bottun"></div>
<div class="attribute-button">
<div class="more" id="J2more">
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">M&#225;s
salieron</span>
</div>
</div>


<div class="separate-bottun"></div>
<div class="attribute-button">
<div id="J2less" class="less" >
<img src="layer-view-image/game/super3/flecha-s3.gif"
	height="5" width="5" class="icon" /><span class="text">Menos
salieron</span></div>
</div>


</div>
</div>

</div>


</div>


</div>

</div>






</div>



<div style="color: #818181; font-family: arial; font-size: 11px;">

<div class="linear" style="margin-left: 2px; margin-top: 19px;">Elige en
cu&#225;ntos sorteos consecutivos jugar&#225;s:</div>
<div style="padding: 0px 234px; margin-bottom: 18px;">

<div class="selectBox">
<c:forEach items="${super3SaleList}" var="super3SaleList" begin="0" end="0">

   <div class="box" id="box">${super3SaleList.messageDraw}</div> 

   </c:forEach>
	<select  name="model" id="mySelectBox" 
	onChange="this.parentNode.getElementsByTagName('div')[0].innerHTML=this.options[this.selectedIndex].text">
	<c:forEach items="${super3SaleList}" var="super3SaleList" >
		<option value="${super3SaleList.numDraws}">${super3SaleList.messageDraw}</option>
	</c:forEach>
	</select>

</div>
</div>
</div>

<div class="font">
	<div class="center">
		<div class="color-text">
			<div><span id='price-message'>${super3SaleBean.priceMessage}</span> | Total de Apuestas: <span id="comb">0</span></div>
			<div class="bold-type">Total: S/.<span id="total_apagar">0</span></div>
		</div>
		<!-- div class="text-distance"><input type="button" name="buy" id="buy" class="button-buy-off"/></div -->
		<div id="buy-panel"><a href="#" class="button-buy" id='buy' onclick="return false;"></a></div>
	</div>
</div>
<div id="noteSuper3"> 
        <span class="text-number">Nota: El estado de los premios de tu boleto S&uacute;per 3 se actualizan en tu Cuenta todos los d&iacute;as a las 12:00 m y 3:00 am</span>
</div>
</form>	
</div>
</div>
</div>

</div>


<iframe class="style-iframe" src="/web/home/right.html" frameborder="0" scrolling="no" width = "300" height="516" style="visibility:hidden;" onload="this.style.visibility='visible';"></iframe>



<%@ include file="../../include/footer.jspf" %>




</div>


</div>
<script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
<script type="text/javascript" src="layer-view-script/game/super3/lotto-super3.js"></script>
<script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>

</body>
</html>