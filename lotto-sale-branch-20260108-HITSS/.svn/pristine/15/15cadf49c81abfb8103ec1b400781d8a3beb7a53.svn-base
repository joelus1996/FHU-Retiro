<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:if test="${isDeportesvirtualesSale == false}"><c:redirect url="${lotocardSrv}"/></c:if>
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

    <meta charset="UTF-8">
    <title>Deportes Virtuales</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"/>
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/deportesvirtuales/theme-Deportesvirtuales.css"/>
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>"/>
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<%@ include file="../../include/header.jspf"%>
<div id="main-content-background">
<div id="main-content" class="group">
<%@ include file="../../include/menu.jspf"%>
<input type="hidden" id="dvURI" name="dvURI" value="${deportesVirtualesURI}">
<div id="deportesvirtuales" class="font-play group">
    <div id="banner">
        <p id="prize">
            <span id="prize_message1">Vive toda la emoción de tu</span><br>
            <span id="prize_message2">Deporte favorito en tiempo real</span>
        </p>
        <p id="horary">
            <span>Juégalos en</span><br>
            <span>cualquier momento</span>
        </p>
    </div>
    <div id="transition" class="transition-one"></div>
    <a id="help" href="https://latinkaportal.com.pe/" target="_black"></a>
    <div id="content" class="cont-align group">
        <!-- HOME ELIGE TU DEPORTE VIRTUAL -->
        <div id="choose-content">
            <div class="content-game">
            </div>
			<div class="footer-front">
				<div class="row-first"><img class="img-one" src="layer-view-image/game/deportesvirtuales/icon-reloj.png" width="36" height="29" /><span class="img-text-one">Partidos virtuales cada 5 minutos.</span> <img class="img-two" src="layer-view-image/game/deportesvirtuales/icon-camara.png" width="36" height="29"  /><span class="img-text-three">M&iacute;ralos en tiempo real.</span></div>
				<div class="row-second"><img class="img-one" src="layer-view-image/game/deportesvirtuales/icon-ball.png" width="36" height="29" /><span class="img-text-two">M&aacute;s de 15 tipos de apuesta (1er, 2do tiempo, Final, etc)</span> <img class="img-two" src="layer-view-image/game/deportesvirtuales/icon-star.png" width="36" height="29"  /><span class="img-text-four">Gana hasta S/ 100,000 desde S/ 0.50</span>
				<a onclick="return false;" id="buy" class="button-buy" href="#"></a>
				</div>
			
			</div>
        </div>
        <!-- END ELIGE TU DEPORTE VIRTUAL -->
        <!-- HOME RECARGA TU SALDO -->
        <div id="reload-balanace">
            <div class="finalize-purchase">
                <div id='content-purchase'>
                    <div id='left-panel' class='left-panel'>
                        <span class='label_1'>DEPORTES VIRTUALES</span>
                        <div id="game_grid"></div>
                    </div>
                    <div class='right-panel'>
                        <div class='label_2'>dd/mm/yy</div>
                        <div class="result_purchase">
                            <div class="label_resu1">JUEGAS DESDE:</div>
                            <div class="result1">S/ 0.50</div>
                        </div>
                    </div>
                    <div id="sub_purchase">
                        <div id="sub_panel">
                            <div id="login_section">
                                <div class="label1">LOGIN: Ingresa a tu cuenta para realizar tu pago.</div>
                                <div>
                                    <form id="frmLoginClient">
                                        <table>
                                            <tr>
                                                <td><span class='label-login'>Usuario:</span></td>
                                                <td>
                                                    <input id='user-client' type='text' name='user-client' class='text-pass'>
                                                </td>
                                                <td><span class='label-login'>Contrase&ntilde;a</span></td>
                                                <td>
                                                    <input id='password-client' type="password" name='password-client' class='text-pass'>
                                                </td>
                                                <td><input type="submit" value="Ingresar" class="button-ingresar" id="home-btnlogin"></td>
                                            </tr>
                                        </table>
                                    </form>
                                </div>
                                <div class="label2">
                                    <a href="#">¿Olvidaste tu usuario?</a> |
                                    <a href="restablecer.html">¿Olvidaste tu Contrase&ntilde;a?</a>
                                </div>
                            </div>
                            <form id="frmLoadBalance">
                                <div id="payments_section">
                                    <div id="pan_0">
                                    	<div class="label1">PAGAR</div>
                                        <table>
                                            <tr>
                                                <td>
                                                    <input type="radio" name="option-card" checked="checked" value="0" id="option-card-0"/>
                                                </td>
                                                <td><span>Quiero descontar de mi saldo disponible S/</span>
                                                    <span id="field-balance-amount">${deportesvirtualesSale.balanceAmount}</span>
                                                    <br>
                                    <span class="saldo_promocional">
                                        <c:if test="${deportesvirtualesSale.balanceAmountGame!='0.0'}">
                                            &oacute; de mi saldo promocional S/ ${deportesvirtualesSale.balanceAmountGame}
                                        </c:if>
                                    </span>
                                                </td>
                                            </tr>
                                        </table>
                                    </div>
                                 	<div id="separator_hr"></div>
									<div id="pan_1">
										<div class="label2">RECARGAS POR INTERNET</div>
										<table>
									<c:forTokens var="channel1Order" items="${deportesvirtualesSale.channel1Order}" delims=",">
										<%@ include file="../../include/balance1.jspf"%>
									</c:forTokens>
									</table>
									<div class="label2">RECARGAS F&Iacute;SICAS</div>
									<table>
									<c:forTokens var="channel2Order" items="${deportesvirtualesSale.channel2Order}" delims=",">
										<%@ include file="../../include/balance2.jspf"%>
									</c:forTokens>
									</table>
									</div>
									<div id="legal-180">El derecho al uso del saldo virtual caduca a los ciento ochenta (180) d&iacute;as calendario contados desde la fecha de activaci&oacute;n. El proceso de recarga a trav&eacute;s de: Interbank, Cuenta BCP, PagoEfectivo, SafetyPay y RedDigital, ser&aacute; verificado por las empresas intervinientes por lo que podr&iacute;a demorar m&aacute;s de 24 horas. El saldo cargado a trav&eacute;s de las diferentes modalidades de recarga, no se podr&aacute; cobrar en efectivo. S&oacute;lo se puede liquidar/cobrar en efectivo los montos de los premios. Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</div>
                                </div>
                            </form>
                        </div>
                        <div id="play-panel" class="text-distance" >
                        <input type="hidden" id="sessionCode" name="sessionCode" value="${sessionCode}">
                            <a id="play"  target="DeportesVirtuales" onclick="open_window(); return;"></a>
                        </div>                       
                    </div>
                </div>
			    <div id="ico-block">
				    <div id="ico-title">&iexcl;SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
				    <div id="ico-panel">
						<a href="juega-tinka.html" class="button-icotinka" id='icotinka'></a>
						<a href="juega-kabala.html" class="button-icokabala" id='icokabala'></a>
						<a href="juega-ganadiario.html" class="button-icoganadiario" id='icoganadiario'></a>
						<a href="juega-kinelo.html" class="button-icokinelo" id='icokinelo'></a>
						<a onclick="toTAV2();"  class="button-icoteapuesto hand" id='icoteapuesto'></a>
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
        </div>
        <!-- END RECARGA TU SALDO -->
    </div>
</div>
<!-- END DEPORTES VIRTUALES -->


<iframe class="style-iframe" src="/web/home/right.html" frameborder="0" scrolling="no" width = "278" height="516" style="visibility:hidden;" onload="this.style.visibility='visible';"></iframe>
<%@ include file="../../include/footer.jspf"%>
</div>
</div>
<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/game/deportesvirtuales/lotto-deportesvirtuales.js"></script>
<script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript">
        function open_window() {
            var x = screen.availWidth;
            var y = screen.availHeight;                 
            var sessionCod=$('#sessionCode').val(); 
            var ventana = window.open($('#dvURI').val()+'/?token='+sessionCod+'&lang=es&mode=real','Deportes Virtuales', "width="+x+", height="+y+", status=no, scrollbars=no, toolbars=no, menubar=no");
            ventana.moveTo(0,0);
         //   window.location.reload(); 
        }
    </script>
    <!--[if IE]>
    <script type="text/javascript">
        function open_window() {
            var x = screen.availWidth;
            var y = screen.availHeight;                 
            var sessionCod=$('#sessionCode').val();
            var ventana = window.open($('#dvURI').val()+'/?token='+sessionCod+'&lang=es&mode=real','Deportes Virtuales', "width="+x+", height="+y+", status=no, scrollbars=no, toolbars=no, menubar=no");
            ventana.moveTo(0,0);
            ventana.moveTo(-10,35);
            /*window.location.reload();*/ 
        }
    </script>
    <![endif]-->

</body>
</html>