<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../include/taglibs.jspf"%>
<c:if test="${isLottoSale == true && isTeapuestoSale == false && isAllowed == false}"><c:redirect url="${lotocardSrv}i.do?m=teapuesto"/></c:if>
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
<title>Te Apuesto | Lotería Virtual - Zona Segura</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/teapuesto/themeTeApuesto.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>" />
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
            <article id="te-apuesto">
				<div class="banner-game">
				    <img src="layer-view-image/game/teapuesto/banner_teapuesto.png" alt="TE APUESTO">
                    <div class="game-motto">Tu juego, Tu pasión</div>
                    <div class="game-message">¡Tu eliges qué partidos jugar y cuánto ganar!</div>
				</div>
				<div id="nav-bar" class="group">
				    <div class="indicator group start">
				        <div class="half">
				            <span class="one">1</span>
				            <span class="choose">Elige tu Te Apuesto</span>
				        </div>
				        <div class="half">
				            <span class="two">2</span>
				            <span class="finalize">Finaliza tu compra</span>
				        </div>
				    </div>
				</div>				
<a id="help" href="https://latinkaportal.com.pe/" title="Necesita ayuda?" target="_black">ayuda</a>
				<ul id="menu" class="group">
				    <li class="tab">
				        <a id="go-daily-programs" href="#daily-programs">programas diarios</a>
				    </li>
				    <li class="tab">
				        <a id="go-exact-maker" href="#exact-maker">marcador exacto</a>
				    </li>
				    <li class="tab">
				        <a id="go-special-bets" href="#special-bets">apuestas especiales</a>
				    </li>
				</ul>
				<div id="content" class="group">
				    <div id="loading">Cargando</div>
				    <section id="daily-programs" class="top-box" style="display: none">
				        <div class="top-bar group">
				            <div id="section-programs">
				                <span class="title">programas:</span>
				            </div>
				            <div id="section-info">
				                <span class="title">selección mínima:</span>
				            <span class="color-info">
				                <span class="number">3</span>
				                <span class="three"></span>
				                <span class="number">2</span>
				                <span class="two"></span>
				                <span class="number">1</span>
				                <span class="one"></span>
				            </span>
				            </div>
				        </div>
				        <div class="top-panel">
				            <div id="game-list">
				                <div id="dp-head" class="head-list">
				                    <ul id="he" class="header-events">
				                        <li class="row em">
				                            <h4 id="date-program" class="cell"></h4>
				                        </li>
				                        <li class="row"><div class="cell hour">Hora</div><div class="cell code">Cod.</div><div class="cell tourney">Torn.</div><div class="cell sel"></div><div class="cell vs">LOCAL - VISITA</div><div class="cell ball"></div>
				                        </li>
				                    </ul>
				                    <ul id="ho" class="header-options">
				                        <li class="row">
				                            <div class="cell head">opción simple</div><div class="cell head">opción doble</div><div class="cell head">1er tiempo</div><div class="cell head gread">1er tiempo - resultado final</div><div class="cell head short">goles</div><div class="cell head">rango de goles</div>
				                        </li>
				                        <li class="row">
				                            <div class="cell op">L</div><div class="cell op">E</div><div class="cell op">V</div><div class="cell op">LoE</div><div class="cell op">LoV</div><div class="cell op">EoV</div><div class="cell op">L</div><div class="cell op">E</div><div class="cell op">V</div><div class="cell op">L/L</div><div class="cell op">E/L</div><div class="cell op">V/L</div><div class="cell op">L/E</div><div class="cell op">E/E</div><div class="cell op">V/E</div><div class="cell op">L/V</div><div class="cell op">E/V</div><div class="cell op">V/V</div><div class="cell op">2ó-</div><div class="cell op">3ó+</div><div class="cell op">(0-1)</div><div class="cell op">(2-3)</div><div class="cell op">(4+)</div>
				                        </li>
				                    </ul>
				                </div>
				                <div id="dp-body" class="body-list">
				                    <div id="dp-body-list" class="inner-body-list group"></div>
				                </div>
				            </div>
				        </div>
				    </section>
				    <section id="exact-maker" class="top-box" style="display: none">
				        <div class="top-panel">
				            <div class="general-info">
				                <div class="info-game">juégalos también como partidos únicos</div>
				                <ul class="header-game-info">
				                    <li class="row">
				                        <div id="DateGame" class="cell"></div>
				                    </li>
				                    <li class="row em">
				                        <div id="title-game" class="cell"></div>
				                    </li>
				                </ul>
				            </div>
				            <ul id="em-ugl" class="unique-game-list"></ul>
				            <div id="exact-list" class="game-maker">
				                <div id="eg-local-win" class="column large">
				                    <div class="header-list">
				                        <div class="row">
				                            <div class="cell head gread">local ganador</div>
				                        </div>
				                        <div class="row">
				                            <div class="cell op">marc.</div><div class="cell op">prob.</div><div class="cell op">marc.</div><div class="cell op">prob.</div>
				                        </div>
				                    </div>
				                    <ul class="body-list"><li class="row"><div class="cell op">1 - 0</div><div class="cell op"></div><div class="cell op">4 - 2</div><div class="cell op"></div></li><li class="row"><div class="cell op">2 - 0</div><div class="cell op"></div><div class="cell op">4 - 3</div><div class="cell op"></div></li><li class="row"><div class="cell op">2 - 1</div><div class="cell op"></div><div class="cell op">5+ - 0</div><div class="cell op"></div></li><li class="row"><div class="cell op">3 - 0</div><div class="cell op"></div><div class="cell op">5+ - 1</div><div class="cell op"></div></li><li class="row"><div class="cell op">3 - 1</div><div class="cell op"></div><div class="cell op">5+ - 2</div><div class="cell op"></div></li><li class="row"><div class="cell op">3 - 2</div><div class="cell op"></div><div class="cell op">5+ - 3</div><div class="cell op"></div></li><li class="row"><div class="cell op">4 - 0</div><div class="cell op"></div><div class="cell op">5+ - 4</div><div class="cell op"></div></li><li class="row"><div class="cell op">4 - 1</div><div class="cell op"></div><div class="cell op">5+ - 5+</div><div class="cell op"></div></li></ul>
				                </div>
				                <div id="eg-equals" class="column small">
				                    <div class="header-list">
				                        <div class="row">
				                            <div class="cell head short">empates</div>
				                        </div>
				                        <div class="row">
				                            <div class="cell op">marc.</div><div class="cell op">prob.</div>
				                        </div>
				                    </div>
				                    <ul class="body-list"><li class="row"><div class="cell op">0 - 0</div><div class="cell op"></div></li><li class="row"><div class="cell op">1 - 1</div><div class="cell op"></div></li><li class="row"><div class="cell op">2 - 2</div><div class="cell op"></div></li><li class="row"><div class="cell op">3 - 3</div><div class="cell op"></div></li><li class="row"><div class="cell op">4 - 4</div><div class="cell op"></div></li><li class="row"><div class="cell op">5+ - 5+</div><div class="cell op"></div></li></ul>
				                </div>
				                <div id="eg-visitor-win" class="column large">
				                    <div class="header-list">
				                        <div class="row">
				                            <div class="cell head gread">visitante ganador</div>
				                        </div>
				                        <div class="row">
				                            <div class="cell op">marc.</div><div class="cell op">prob.</div><div class="cell op">marc.</div><div class="cell op">prob.</div>
				                        </div>
				                    </div>
				                    <ul class="body-list"><li class="row"><div class="cell op">1 - 0</div><div class="cell op"></div><div class="cell op">4 - 2</div><div class="cell op"></div></li><li class="row"><div class="cell op">2 - 0</div><div class="cell op"></div><div class="cell op">4 - 3</div><div class="cell op"></div></li><li class="row"><div class="cell op">2 - 1</div><div class="cell op"></div><div class="cell op">5+ - 0</div><div class="cell op"></div></li><li class="row"><div class="cell op">3 - 0</div><div class="cell op"></div><div class="cell op">5+ - 1</div><div class="cell op"></div></li><li class="row"><div class="cell op">3 - 1</div><div class="cell op"></div><div class="cell op">5+ - 2</div><div class="cell op"></div></li><li class="row"><div class="cell op">3 - 2</div><div class="cell op"></div><div class="cell op">5+ - 3</div><div class="cell op"></div></li><li class="row"><div class="cell op">4 - 0</div><div class="cell op"></div><div class="cell op">5+ - 4</div><div class="cell op"></div></li><li class="row"><div class="cell op">4 - 1</div><div class="cell op"></div><div class="cell op">5+ - 5+</div><div class="cell op"></div></li></ul>
				                </div>
				            </div>
				        </div>
				    </section>
				    <section id="special-bets" class="top-box" style="display: none">
				        <div class="top-panel group">
				            <div id="special-bets-header" class="sports"></div>
				            <div id="special-bets-title" class="title"></div>
				            <a id="collapse-all" href="#collapse" title="Cerrar todos los items abiertos">collapse all</a>
				            <div id="special-bets-menu" class="menu-game-list"></div>
				            <div id="special-list"></div>
				        </div>
				    </section>
				    <div class="bottom-box" style="display: none">
				        <div class="bottom-panel">
				            <div class="sub-panel group">
				                <div class="area-name">Tu apuesta es</div>
				                <div class="area-content">
				                    <div id="bet-result" class="inner-area-content"></div>
				                </div>
				            </div>
				            <div id="bmg" class="sub-panel group">
				                <div class="area-name">multiplicador</div>
				                <div class="group-button">
				                    <input class="btn-multiplier" type="button" value="100">
				                    <input class="btn-multiplier" type="button" value="50">
				                    <input class="btn-multiplier" type="button" value="40">
				                    <input class="btn-multiplier" type="button" value="30">
				                    <input class="btn-multiplier" type="button" value="20">
				                    <input class="btn-multiplier" type="button" value="10">
				                    <input class="btn-multiplier" type="button" value="7">
				                    <input class="btn-multiplier" type="button" value="6">
				                    <input class="btn-multiplier" type="button" value="5">
				                    <input class="btn-multiplier" type="button" value="4">
				                    <input class="btn-multiplier" type="button" value="3">
				                    <input class="btn-multiplier" type="button" value="2">
				                </div>
				            </div>
				            <div id="bcg" class="sub-panel group">
				                <div class="area-name">combinados</div>
				                <div class="group-button">
				                    <input class="btn-combined" type="button" value="1">
				                    <input class="btn-combined" type="button" value="2">
				                    <input class="btn-combined" type="button" value="3">
				                    <input class="btn-combined" type="button" value="4">
				                    <input class="btn-combined" type="button" value="5">
				                    <input class="btn-combined" type="button" value="6">
				                    <input class="btn-combined" type="button" value="7">
				                    <input class="btn-combined" type="button" value="8">
				                    <input class="btn-combined" type="button" value="9">
				                    <input class="btn-combined" type="button" value="10">
				                    <input class="btn-combined" type="button" value="11">
				                    <input class="btn-combined" type="button" value="12">
				                </div>
				            </div>
				        </div>
				    </div>
				    <div class="bottom-bar" style="display: none">
				        <div class="info-bet">
				            <ul class="cost group">
				                <li id="field-price-message"></li>
				                <li id="field-total-bet" class="invisible">Total de apuestas: <span id="total-bet">0</span></li>
				                <li id="field-multiplier" class="invisible">Multiplicador: <span id="multiplier">0</span></li>
				                <li id="field-combined" class="invisible">Combinadas: <span id="combined">0</span></li>
				            </ul>
				            <ul class="total group">
				                <li>TOTAL: S/. <span id="full-amount">0</span></li>
				                <li>Monto máximo ganador (aprox.): S/. <span id="winning-amount">0.00</span></li>
				            </ul>
				        </div>
				        <div class="section-buy">
				            <button id="buy" value="0">comprar</button>
				        </div>
				    </div>
				</div>
				<div id="shopping-cart" class="group">
				    <!-- HOME PURCHASE -->
				    <div class="finalize-purchase">
				        <div id='content-purchase'>
				            <div id='left-panel' class='left-panel'>
				                <span class='label_1'>TEAPUESTO</span>
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
				                <div id="panel_more_plays">
				                    <a href="#more-plays" class="class_more_plays" id='more_plays' onclick="return false;"></a>
				                </div>
				                <div id="panel_keep-playing">
				                    <a href="juega-teapuesto.html" class="class-keep-playing" id="keep-playing"></a>
				                </div>
				                <div id="panel_game-history">
				                    <a href="mi-cuenta.html#jugadas" class="class-game-history" id="game-history"></a>
				                </div>
				            </div>
				            <div id="sub_purchase" class="group">
				                <div id="sub_panel">
				                    <div id="login_section">
				                        <div class="label1">LOGIN: Ingresa a tu cuenta para realizar tu pago.</div>
				                        <div>
				                            <form id="frmLoginClient">
				                                <table>
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
				                            <a href="recordar-usuario.html">¿Olvidaste tu usuario?</a> | <a href="restablecer.html">¿Olvidaste tu Contrase&ntilde;a?</a>
				                        </div>
				                    </div>
                                    <form id="frmLoadBalance">
                                        <div id="payments_section">
                                            <div id="pan_0">
                                            	<div class="label1">PAGAR</div>
                                                <table>
                                                    <tr>
                                                        <td style="vertical-align: top;">
                                                            <input type="radio" name="option-card" checked="checked" value="0" id="option-card-0">
                                                        </td>
                                                        <td style="vertical-align: top;">
                                                            <label for="option-card-0"><span>Quiero descontar de mi saldo disponible S/.</span><span id="field-balance-amount"></span><br><span id="saldo-promocional"></span></label>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </div>
                                            <%@ include file="../../include/balance.jspf"%>
                                        </div>
                                    </form>
				                </div>
				                <div id="panel_finaliza_compra">
				                    <a href="#" class="btn_finaliza_compra" id="btn_finaliza_compra"></a>
				                </div>
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
				    <!-- END PURCHASE -->
				</div>
                <input type="hidden" id="b5435566a27c88b4745c39e0b3d91da7" value='${b5435566a27c88b4745c39e0b3d91da7}'>
            </article>
            <iframe class="style-iframe" src="/web/home/right.html" frameborder="0" scrolling="no" width = "300" height="516" style="visibility:hidden;" onload="this.style.visibility='visible';"></iframe>
            <%@ include file="../../include/footer.jspf"%>
        </div>
    </div>
    <script type="text/javascript">
        Modernizr.load({
            test: Modernizr.rgba && Modernizr.cssgradients && Modernizr.opacity && Modernizr.borderradius,
            nope: ['layer-view-style/game/teapuesto/old-browser.css', 'layer-view-script/common/jquery.roundOff.js', 'layer-view-script/game/teapuesto/old-browser.js']
        });
    </script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
    <script type='text/javascript' src='layer-view-script/game/teapuesto/lotto-te-apuesto.js'></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js'></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>

    <%@ include file="../../include/message.jspf"%>
</body>
</html>