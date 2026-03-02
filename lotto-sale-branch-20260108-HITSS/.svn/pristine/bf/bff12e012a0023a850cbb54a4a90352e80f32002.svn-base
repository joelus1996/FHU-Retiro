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
  
    <meta charset="utf-8">
    <meta name="viewport" content="width=1024">
    <meta name="description" content="Juega en l&iacute;nea la K&aacute;bala  la loter&iacute;a m&aacute;s econ&oacute;mica del Per&uacute;. &iexcl;Juega la K&aacute;bala y gana un pozo buenazo por s&oacute;lo S/ 0.50!">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/kabala/theme.css" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/kabala/themeKabala.css" />
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link rel="stylesheet" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>" type="text/css" />

    <!--video live-->
    <link rel="stylesheet" href="layer-view-style/game/kabala/live/video.css" type="text/css">
    <!--video live-->

    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <title>La Kábala: El mejor juego de lotería electrónica del Perú </title>
    <meta name='description' content="El juego de lotería electrónica en tiempo real más popular del Perú, el cual acumula pozos grandes que se sortean 3 veces por semana. " />
	
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
  </head>
  <body>
  <!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->
  
    <%@ include file="../../include/header.jspf" %>
        <input type="hidden" value="${kabalaSale.numbersMore}" id="more_repeated">
        <input type="hidden" value="${kabalaSale.numbersLess}" id="less_repeated">
        <input type="hidden" value="${kabalaSale.status}" id="status">
        <input type="hidden" value="${kabalaSale.simpleBetPrice}" id="simpleBetPrice_repeated">
        <input type="hidden" value="${kabalaSale.promotionType}" id="promo">
        <input type="hidden" value="${kabalaSale.priceType}" id="price_type">
        <input type="hidden" value="${kabalaSale.algorithm}" id="algorithm">
        <input type="hidden" value="${kabalaSale.bets}" id="bets">
        <input type="hidden" value="${kabalaSale.pay}" id="pay">
        <input type="hidden" value="${kabalaSale.cost}" id="cost">
        <input type="hidden" value="${kabalaSale.draws}" id="draw">
        <input type="hidden" value="" id="game-award" data-award='${awardList}'><div class="main-content">
      <div class="main-page">
        <div class="main-game main-kabala">
          <div class="action-float">
            <button class="button button-green" onclick="openKabalaCotejador();">COTEJA TU BOLETO</button>
          </div>
          <div class="row">
            <div class="col-12 col-md-8">
              <div class="box-main-game top-box" id="banner-kabala">
                <div class="top-banner top-kabala" id="top-kabala">
                  <figure>
                    <img id="logo-kabala" src="layer-view-image/v2/logo-kabala.svg" alt="Jugar Kabala" />
                    <span id="logo_chauchamba" hidden="">
                    	<img   src="layer-view-image/v2/logo_chauchamba.svg" alt="Jugar La Tinka"/>
                    </span>
                  </figure>
                  <div class="body-banner">
                    <div class="left-banner">
                      <div class="banner-price">
                        <div class="sub-banner" id='text-banner-kabala'>
                          <h4>POZO</h4>
                          <h4 class="sub-banner-min">BUENAZO</h4>
                        </div>
                        <h3 id='pozo-kabala'>S/ ${kabalaSale.prize}</h3>
                        <h3 id='pozo-chauchamba' hidden="">S/ 5,000</h3>
                        <div class="sub-banner" id='text2-banner-kabala' hidden="" style="margin-top: -5px">
                            <h4 style="font-size: 16px; color: #000000">MENSUALES</h4>
                            <h4 style="font-size: 16px; color: #000000">POR 20 AÑOS</h4>
                        </div>
                      </div>
                    </div>
                    <div class="right-banner">
                      <div class="banner-desc">
                        <c:if test="${kabalaSale.status == 'CIE'}">
                          <p class="color-banner-kabala">Próximo sorteo</p>
                          <p class="color-banner-kabala">Abre HOY</p>
                          <p class="color-banner-kabala">a las ${kabalaSale.openHour}</p>
                        </c:if>
                        <c:if test="${kabalaSale.status == 'ACT'}">
                          <p class="color-banner-kabala">Juégalo</p>
                          <p class="color-banner-kabala">hasta ${kabalaSale.closeHour}</p>
                          <p class="color-banner-kabala">${kabalaSale.closeDate}</p>
                        </c:if>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="main-panel">
                <div class="main-play">
                  <div class="steps-play">
                    <div class="row no-gutters">
                      <div class="col-6">
                        <div class="step-play step-status-1 step-active">PASO 1: COBRA EN LÍNEA</div>
                      </div>
                      <div class="col-6">
                        <div class="step-play step-status-2">PASO 2: PREMIO COBRADO</div>
                      </div>
                    </div>
                  </div>
                  <div class="body-play">
                    <div class="play-help">
                      <a href="<%=Constants.URL_QW%>/tutorial/como-jugar-kabala/" target="_blank" class="play-text"><span>?</span> Ayuda</a>
                    </div>
                    <div class="wrapper-playing">
                      <div class="boxes-playing">
                        <form name="start_play" id="start_play">
                          <div class="box-playing">
                            <div class="row no-gutters">
                              <div id="playing-panel" class="col-6">
                                <div class="box-wrapper-game box-content-left">
                                  <div class="box-content-game">
                                    <div class="box-play-main box-play-a">
                                      <div class="content-single-game">
                                        <div class="top-single-game">
                                          <h3>JUGADA A <span>Marca 6 bolillas</span></h3>
                                        </div>
                                        <div class="body-single-game">
                                          <div class="body-game">
                                            <div class="button-group checkboxes-ball clearfix">
                                              <label>
                                              <input class="J1check_1" type="checkbox" name="J1check" value="1" id="J1check_1" /><span class="button-group-item check_" id="LJ1check_1" for="J1check_1"><span class="label-item">1</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_2" type="checkbox" name="J1check" value="2" id="J1check_2" /><span class="button-group-item check_" id="LJ1check_2" for="J1check_2"><span class="label-item">2</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_3" type="checkbox" name="J1check" value="3" id="J1check_3" /><span class="button-group-item check_" id="LJ1check_3" for="J1check_3"><span class="label-item">3</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_4" type="checkbox" name="J1check" value="4" id="J1check_4" /><span class="button-group-item check_" id="LJ1check_4" for="J1check_4"><span class="label-item">4</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_5" type="checkbox" name="J1check" value="5" id="J1check_5" /><span class="button-group-item check_" id="LJ1check_5" for="J1check_5"><span class="label-item">5</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_6" type="checkbox" name="J1check" value="6" id="J1check_6" /><span class="button-group-item check_" id="LJ1check_6" for="J1check_6"><span class="label-item">6</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_7" type="checkbox" name="J1check" value="7" id="J1check_7" /><span class="button-group-item check_" id="LJ1check_7" for="J1check_7"><span class="label-item">7</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_8" type="checkbox" name="J1check" value="8" id="J1check_8" /><span class="button-group-item check_" id="LJ1check_8" for="J1check_8"><span class="label-item">8</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_9" type="checkbox" name="J1check" value="9" id="J1check_9" /><span class="button-group-item check_" id="LJ1check_9" for="J1check_9"><span class="label-item">9</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_10" type="checkbox" name="J1check" value="10" id="J1check_10" /><span class="button-group-item check_" id="LJ1check_10" for="J1check_10"><span class="label-item">10</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_11" type="checkbox" name="J1check" value="11" id="J1check_11" /><span class="button-group-item check_" id="LJ1check_11" for="J1check_11"><span class="label-item">11</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_12" type="checkbox" name="J1check" value="12" id="J1check_12" /><span class="button-group-item check_" id="LJ1check_12" for="J1check_12"><span class="label-item">12</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_13" type="checkbox" name="J1check" value="13" id="J1check_13" /><span class="button-group-item check_" id="LJ1check_13" for="J1check_13"><span class="label-item">13</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_14" type="checkbox" name="J1check" value="14" id="J1check_14" /><span class="button-group-item check_" id="LJ1check_14" for="J1check_14"><span class="label-item">14</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_15" type="checkbox" name="J1check" value="15" id="J1check_15" /><span class="button-group-item check_" id="LJ1check_15" for="J1check_15"><span class="label-item">15</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_16" type="checkbox" name="J1check" value="16" id="J1check_16" /><span class="button-group-item check_" id="LJ1check_16" for="J1check_16"><span class="label-item">16</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_17" type="checkbox" name="J1check" value="17" id="J1check_17" /><span class="button-group-item check_" id="LJ1check_17" for="J1check_17"><span class="label-item">17</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_18" type="checkbox" name="J1check" value="18" id="J1check_18" /><span class="button-group-item check_" id="LJ1check_18" for="J1check_18"><span class="label-item">18</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_19" type="checkbox" name="J1check" value="19" id="J1check_19" /><span class="button-group-item check_" id="LJ1check_19" for="J1check_19"><span class="label-item">19</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_20" type="checkbox" name="J1check" value="20" id="J1check_20" /><span class="button-group-item check_" id="LJ1check_20" for="J1check_20"><span class="label-item">20</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_21" type="checkbox" name="J1check" value="21" id="J1check_21" /><span class="button-group-item check_" id="LJ1check_21" for="J1check_21"><span class="label-item">21</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_22" type="checkbox" name="J1check" value="22" id="J1check_22" /><span class="button-group-item check_" id="LJ1check_22" for="J1check_22"><span class="label-item">22</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_23" type="checkbox" name="J1check" value="23" id="J1check_23" /><span class="button-group-item check_" id="LJ1check_23" for="J1check_23"><span class="label-item">23</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_24" type="checkbox" name="J1check" value="24" id="J1check_24" /><span class="button-group-item check_" id="LJ1check_24" for="J1check_24"><span class="label-item">24</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_25" type="checkbox" name="J1check" value="25" id="J1check_25" /><span class="button-group-item check_" id="LJ1check_25" for="J1check_25"><span class="label-item">25</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_26" type="checkbox" name="J1check" value="26" id="J1check_26" /><span class="button-group-item check_" id="LJ1check_26" for="J1check_26"><span class="label-item">26</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_27" type="checkbox" name="J1check" value="27" id="J1check_27" /><span class="button-group-item check_" id="LJ1check_27" for="J1check_27"><span class="label-item">27</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_28" type="checkbox" name="J1check" value="28" id="J1check_28" /><span class="button-group-item check_" id="LJ1check_28" for="J1check_28"><span class="label-item">28</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_29" type="checkbox" name="J1check" value="29" id="J1check_29" /><span class="button-group-item check_" id="LJ1check_29" for="J1check_29"><span class="label-item">29</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_30" type="checkbox" name="J1check" value="30" id="J1check_30" /><span class="button-group-item check_" id="LJ1check_30" for="J1check_30"><span class="label-item">30</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_31" type="checkbox" name="J1check" value="31" id="J1check_31" /><span class="button-group-item check_" id="LJ1check_31" for="J1check_31"><span class="label-item">31</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_32" type="checkbox" name="J1check" value="32" id="J1check_32" /><span class="button-group-item check_" id="LJ1check_32" for="J1check_32"><span class="label-item">32</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_33" type="checkbox" name="J1check" value="33" id="J1check_33" /><span class="button-group-item check_" id="LJ1check_33" for="J1check_33"><span class="label-item">33</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_34" type="checkbox" name="J1check" value="34" id="J1check_34" /><span class="button-group-item check_" id="LJ1check_34" for="J1check_34"><span class="label-item">34</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_35" type="checkbox" name="J1check" value="35" id="J1check_35" /><span class="button-group-item check_" id="LJ1check_35" for="J1check_35"><span class="label-item">35</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_36" type="checkbox" name="J1check" value="36" id="J1check_36" /><span class="button-group-item check_" id="LJ1check_36" for="J1check_36"><span class="label-item">36</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_37" type="checkbox" name="J1check" value="37" id="J1check_37" /><span class="button-group-item check_" id="LJ1check_37" for="J1check_37"><span class="label-item">37</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_38" type="checkbox" name="J1check" value="38" id="J1check_38" /><span class="button-group-item check_" id="LJ1check_38" for="J1check_38"><span class="label-item">38</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_39" type="checkbox" name="J1check" value="39" id="J1check_39" /><span class="button-group-item check_" id="LJ1check_39" for="J1check_39"><span class="label-item">39</span></span>
                                              </label>
                                              <label>
                                              <input class="J1check_40" type="checkbox" name="J1check" value="40" id="J1check_40" /><span class="button-group-item check_" id="LJ1check_40" for="J1check_40"><span class="label-item">40</span></span>
                                              </label>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="footer-single-game">
                                          <div class="row no-gutters">
                                            <div class="col-6">
                                              <div class="footer-single-left">
                                                <button type="button" id="J1azar" class="azar button button-block button-light-green button-sm button-no-shadow">Al Azar</button>
                                              </div>
                                            </div>
                                            <div class="col-6">
                                              <div class="footer-single-right">
                                                <button type="button" id="J1clear" class="clear button button-block button-light-green button-sm button-no-shadow">Limpiar</button>
                                              </div>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                      <div class="box-content-detail">
                                        <h5>Tus números son</h5>
                                        <textarea id="J1-text-area" class="current-numbers" readonly="readonly"></textarea>
                                      </div>
                                    </div>
                                    <div class="box-play-main box-play-b" style="display: none">
                                      <div class="content-single-game">
                                        <div class="top-single-game">
                                          <h3>JUGADA B <span>Marca 6 bolillas</span></h3>
                                        </div>
                                        <div class="body-single-game">
                                          <div class="body-game">
                                            <div class="button-group checkboxes-ball clearfix">
                                              <label>
                                              <input class="J2check_1" type="checkbox" name="J2check" value="1" id="J2check_1" /><span class="button-group-item check_" id="LJ2check_1" for="J2check_1"><span class="label-item">1</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_2" type="checkbox" name="J2check" value="2" id="J2check_2" /><span class="button-group-item check_" id="LJ2check_2" for="J2check_2"><span class="label-item">2</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_3" type="checkbox" name="J2check" value="3" id="J2check_3" /><span class="button-group-item check_" id="LJ2check_3" for="J2check_3"><span class="label-item">3</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_4" type="checkbox" name="J2check" value="4" id="J2check_4" /><span class="button-group-item check_" id="LJ2check_4" for="J2check_4"><span class="label-item">4</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_5" type="checkbox" name="J2check" value="5" id="J2check_5" /><span class="button-group-item check_" id="LJ2check_5" for="J2check_5"><span class="label-item">5</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_6" type="checkbox" name="J2check" value="6" id="J2check_6" /><span class="button-group-item check_" id="LJ2check_6" for="J2check_6"><span class="label-item">6</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_7" type="checkbox" name="J2check" value="7" id="J2check_7" /><span class="button-group-item check_" id="LJ2check_7" for="J2check_7"><span class="label-item">7</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_8" type="checkbox" name="J2check" value="8" id="J2check_8" /><span class="button-group-item check_" id="LJ2check_8" for="J2check_8"><span class="label-item">8</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_9" type="checkbox" name="J2check" value="9" id="J2check_9" /><span class="button-group-item check_" id="LJ2check_9" for="J2check_9"><span class="label-item">9</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_10" type="checkbox" name="J2check" value="10" id="J2check_10" /><span class="button-group-item check_" id="LJ2check_10" for="J2check_10"><span class="label-item">10</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_11" type="checkbox" name="J2check" value="11" id="J2check_11" /><span class="button-group-item check_" id="LJ2check_11" for="J2check_11"><span class="label-item">11</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_12" type="checkbox" name="J2check" value="12" id="J2check_12" /><span class="button-group-item check_" id="LJ2check_12" for="J2check_12"><span class="label-item">12</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_13" type="checkbox" name="J2check" value="13" id="J2check_13" /><span class="button-group-item check_" id="LJ2check_13" for="J2check_13"><span class="label-item">13</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_14" type="checkbox" name="J2check" value="14" id="J2check_14" /><span class="button-group-item check_" id="LJ2check_14" for="J2check_14"><span class="label-item">14</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_15" type="checkbox" name="J2check" value="15" id="J2check_15" /><span class="button-group-item check_" id="LJ2check_15" for="J2check_15"><span class="label-item">15</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_16" type="checkbox" name="J2check" value="16" id="J2check_16" /><span class="button-group-item check_" id="LJ2check_16" for="J2check_16"><span class="label-item">16</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_17" type="checkbox" name="J2check" value="17" id="J2check_17" /><span class="button-group-item check_" id="LJ2check_17" for="J2check_17"><span class="label-item">17</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_18" type="checkbox" name="J2check" value="18" id="J2check_18" /><span class="button-group-item check_" id="LJ2check_18" for="J2check_18"><span class="label-item">18</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_19" type="checkbox" name="J2check" value="19" id="J2check_19" /><span class="button-group-item check_" id="LJ2check_19" for="J2check_19"><span class="label-item">19</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_20" type="checkbox" name="J2check" value="20" id="J2check_20" /><span class="button-group-item check_" id="LJ2check_20" for="J2check_20"><span class="label-item">20</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_21" type="checkbox" name="J2check" value="21" id="J2check_21" /><span class="button-group-item check_" id="LJ2check_21" for="J2check_21"><span class="label-item">21</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_22" type="checkbox" name="J2check" value="22" id="J2check_22" /><span class="button-group-item check_" id="LJ2check_22" for="J2check_22"><span class="label-item">22</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_23" type="checkbox" name="J2check" value="23" id="J2check_23" /><span class="button-group-item check_" id="LJ2check_23" for="J2check_23"><span class="label-item">23</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_24" type="checkbox" name="J2check" value="24" id="J2check_24" /><span class="button-group-item check_" id="LJ2check_24" for="J2check_24"><span class="label-item">24</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_25" type="checkbox" name="J2check" value="25" id="J2check_25" /><span class="button-group-item check_" id="LJ2check_25" for="J2check_25"><span class="label-item">25</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_26" type="checkbox" name="J2check" value="26" id="J2check_26" /><span class="button-group-item check_" id="LJ2check_26" for="J2check_26"><span class="label-item">26</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_27" type="checkbox" name="J2check" value="27" id="J2check_27" /><span class="button-group-item check_" id="LJ2check_27" for="J2check_27"><span class="label-item">27</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_28" type="checkbox" name="J2check" value="28" id="J2check_28" /><span class="button-group-item check_" id="LJ2check_28" for="J2check_28"><span class="label-item">28</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_29" type="checkbox" name="J2check" value="29" id="J2check_29" /><span class="button-group-item check_" id="LJ2check_29" for="J2check_29"><span class="label-item">29</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_30" type="checkbox" name="J2check" value="30" id="J2check_30" /><span class="button-group-item check_" id="LJ2check_30" for="J2check_30"><span class="label-item">30</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_31" type="checkbox" name="J2check" value="31" id="J2check_31" /><span class="button-group-item check_" id="LJ2check_31" for="J2check_31"><span class="label-item">31</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_32" type="checkbox" name="J2check" value="32" id="J2check_32" /><span class="button-group-item check_" id="LJ2check_32" for="J2check_32"><span class="label-item">32</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_33" type="checkbox" name="J2check" value="33" id="J2check_33" /><span class="button-group-item check_" id="LJ2check_33" for="J2check_33"><span class="label-item">33</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_34" type="checkbox" name="J2check" value="34" id="J2check_34" /><span class="button-group-item check_" id="LJ2check_34" for="J2check_34"><span class="label-item">34</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_35" type="checkbox" name="J2check" value="35" id="J2check_35" /><span class="button-group-item check_" id="LJ2check_35" for="J2check_35"><span class="label-item">35</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_36" type="checkbox" name="J2check" value="36" id="J2check_36" /><span class="button-group-item check_" id="LJ2check_36" for="J2check_36"><span class="label-item">36</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_37" type="checkbox" name="J2check" value="37" id="J2check_37" /><span class="button-group-item check_" id="LJ2check_37" for="J2check_37"><span class="label-item">37</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_38" type="checkbox" name="J2check" value="38" id="J2check_38" /><span class="button-group-item check_" id="LJ2check_38" for="J2check_38"><span class="label-item">38</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_39" type="checkbox" name="J2check" value="39" id="J2check_39" /><span class="button-group-item check_" id="LJ2check_39" for="J2check_39"><span class="label-item">39</span></span>
                                              </label>
                                              <label>
                                              <input class="J2check_40" type="checkbox" name="J2check" value="40" id="J2check_40" /><span class="button-group-item check_" id="LJ2check_40" for="J2check_40"><span class="label-item">40</span></span>
                                              </label>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="footer-single-game">
                                          <div class="row no-gutters">
                                            <div class="col-6">
                                              <div class="footer-single-left">
                                                <button type="button" id="J2azar" class="azar button button-block button-light-green button-sm button-no-shadow">Al Azar</button>
                                              </div>
                                            </div>
                                            <div class="col-6">
                                              <div class="footer-single-right">
                                                <button type="button" id="J2clear" class="clear button button-block button-light-green button-sm button-no-shadow">Limpiar</button>
                                              </div>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                      <div class="box-content-detail">
                                        <h5>Tus números son</h5>
                                        <textarea class="current-numbers" id="J2-text-area" readonly="readonly"></textarea>
                                      </div>
                                    </div>
                                    <div class="box-play-main box-play-c" style="display: none">
                                      <div class="content-single-game">
                                        <div class="top-single-game">
                                          <h3>JUGADA C <span>Marca 6 bolillas</span></h3>
                                        </div>
                                        <div class="body-single-game">
                                          <div class="body-game">
                                            <div class="button-group checkboxes-ball clearfix">
                                              <label>
                                              <input class="J3check_1" type="checkbox" name="J3check" value="1" id="J3check_1" /><span class="button-group-item check_" id="LJ3check_1" for="J3check_1"><span class="label-item">1</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_2" type="checkbox" name="J3check" value="2" id="J3check_2" /><span class="button-group-item check_" id="LJ3check_2" for="J3check_2"><span class="label-item">2</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_3" type="checkbox" name="J3check" value="3" id="J3check_3" /><span class="button-group-item check_" id="LJ3check_3" for="J3check_3"><span class="label-item">3</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_4" type="checkbox" name="J3check" value="4" id="J3check_4" /><span class="button-group-item check_" id="LJ3check_4" for="J3check_4"><span class="label-item">4</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_5" type="checkbox" name="J3check" value="5" id="J3check_5" /><span class="button-group-item check_" id="LJ3check_5" for="J3check_5"><span class="label-item">5</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_6" type="checkbox" name="J3check" value="6" id="J3check_6" /><span class="button-group-item check_" id="LJ3check_6" for="J3check_6"><span class="label-item">6</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_7" type="checkbox" name="J3check" value="7" id="J3check_7" /><span class="button-group-item check_" id="LJ3check_7" for="J3check_7"><span class="label-item">7</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_8" type="checkbox" name="J3check" value="8" id="J3check_8" /><span class="button-group-item check_" id="LJ3check_8" for="J3check_8"><span class="label-item">8</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_9" type="checkbox" name="J3check" value="9" id="J3check_9" /><span class="button-group-item check_" id="LJ3check_9" for="J3check_9"><span class="label-item">9</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_10" type="checkbox" name="J3check" value="10" id="J3check_10" /><span class="button-group-item check_" id="LJ3check_10" for="J3check_10"><span class="label-item">10</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_11" type="checkbox" name="J3check" value="11" id="J3check_11" /><span class="button-group-item check_" id="LJ3check_11" for="J3check_11"><span class="label-item">11</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_12" type="checkbox" name="J3check" value="12" id="J3check_12" /><span class="button-group-item check_" id="LJ3check_12" for="J3check_12"><span class="label-item">12</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_13" type="checkbox" name="J3check" value="13" id="J3check_13" /><span class="button-group-item check_" id="LJ3check_13" for="J3check_13"><span class="label-item">13</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_14" type="checkbox" name="J3check" value="14" id="J3check_14" /><span class="button-group-item check_" id="LJ3check_14" for="J3check_14"><span class="label-item">14</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_15" type="checkbox" name="J3check" value="15" id="J3check_15" /><span class="button-group-item check_" id="LJ3check_15" for="J3check_15"><span class="label-item">15</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_16" type="checkbox" name="J3check" value="16" id="J3check_16" /><span class="button-group-item check_" id="LJ3check_16" for="J3check_16"><span class="label-item">16</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_17" type="checkbox" name="J3check" value="17" id="J3check_17" /><span class="button-group-item check_" id="LJ3check_17" for="J3check_17"><span class="label-item">17</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_18" type="checkbox" name="J3check" value="18" id="J3check_18" /><span class="button-group-item check_" id="LJ3check_18" for="J3check_18"><span class="label-item">18</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_19" type="checkbox" name="J3check" value="19" id="J3check_19" /><span class="button-group-item check_" id="LJ3check_19" for="J3check_19"><span class="label-item">19</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_20" type="checkbox" name="J3check" value="20" id="J3check_20" /><span class="button-group-item check_" id="LJ3check_20" for="J3check_20"><span class="label-item">20</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_21" type="checkbox" name="J3check" value="21" id="J3check_21" /><span class="button-group-item check_" id="LJ3check_21" for="J3check_21"><span class="label-item">21</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_22" type="checkbox" name="J3check" value="22" id="J3check_22" /><span class="button-group-item check_" id="LJ3check_22" for="J3check_22"><span class="label-item">22</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_23" type="checkbox" name="J3check" value="23" id="J3check_23" /><span class="button-group-item check_" id="LJ3check_23" for="J3check_23"><span class="label-item">23</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_24" type="checkbox" name="J3check" value="24" id="J3check_24" /><span class="button-group-item check_" id="LJ3check_24" for="J3check_24"><span class="label-item">24</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_25" type="checkbox" name="J3check" value="25" id="J3check_25" /><span class="button-group-item check_" id="LJ3check_25" for="J3check_25"><span class="label-item">25</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_26" type="checkbox" name="J3check" value="26" id="J3check_26" /><span class="button-group-item check_" id="LJ3check_26" for="J3check_26"><span class="label-item">26</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_27" type="checkbox" name="J3check" value="27" id="J3check_27" /><span class="button-group-item check_" id="LJ3check_27" for="J3check_27"><span class="label-item">27</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_28" type="checkbox" name="J3check" value="28" id="J3check_28" /><span class="button-group-item check_" id="LJ3check_28" for="J3check_28"><span class="label-item">28</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_29" type="checkbox" name="J3check" value="29" id="J3check_29" /><span class="button-group-item check_" id="LJ3check_29" for="J3check_29"><span class="label-item">29</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_30" type="checkbox" name="J3check" value="30" id="J3check_30" /><span class="button-group-item check_" id="LJ3check_30" for="J3check_30"><span class="label-item">30</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_31" type="checkbox" name="J3check" value="31" id="J3check_31" /><span class="button-group-item check_" id="LJ3check_31" for="J3check_31"><span class="label-item">31</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_32" type="checkbox" name="J3check" value="32" id="J3check_32" /><span class="button-group-item check_" id="LJ3check_32" for="J3check_32"><span class="label-item">32</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_33" type="checkbox" name="J3check" value="33" id="J3check_33" /><span class="button-group-item check_" id="LJ3check_33" for="J3check_33"><span class="label-item">33</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_34" type="checkbox" name="J3check" value="34" id="J3check_34" /><span class="button-group-item check_" id="LJ3check_34" for="J3check_34"><span class="label-item">34</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_35" type="checkbox" name="J3check" value="35" id="J3check_35" /><span class="button-group-item check_" id="LJ3check_35" for="J3check_35"><span class="label-item">35</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_36" type="checkbox" name="J3check" value="36" id="J3check_36" /><span class="button-group-item check_" id="LJ3check_36" for="J3check_36"><span class="label-item">36</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_37" type="checkbox" name="J3check" value="37" id="J3check_37" /><span class="button-group-item check_" id="LJ3check_37" for="J3check_37"><span class="label-item">37</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_38" type="checkbox" name="J3check" value="38" id="J3check_38" /><span class="button-group-item check_" id="LJ3check_38" for="J3check_38"><span class="label-item">38</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_39" type="checkbox" name="J3check" value="39" id="J3check_39" /><span class="button-group-item check_" id="LJ3check_39" for="J3check_39"><span class="label-item">39</span></span>
                                              </label>
                                              <label>
                                              <input class="J3check_40" type="checkbox" name="J3check" value="40" id="J3check_40" /><span class="button-group-item check_" id="LJ3check_40" for="J3check_40"><span class="label-item">40</span></span>
                                              </label>
                                              <label> 
                                            </div>
                                          </div>
                                        </div>
                                        <div class="footer-single-game">
                                          <div class="row no-gutters">
                                            <div class="col-6">
                                              <div class="footer-single-left">
                                                <button type="button" id="J3azar" class="azar button button-block button-light-green button-sm button-no-shadow">Al Azar</button>
                                              </div>
                                            </div>
                                            <div class="col-6">
                                              <div class="footer-single-right">
                                                <button type="button" id="J3clear" class="clear button button-block button-light-green button-sm button-no-shadow">Limpiar</button>
                                              </div>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                      <div class="box-content-detail">
                                        <h5>Tus números son</h5>
                                        <textarea class="current-numbers" id="J3-text-area" readonly="readonly"></textarea>
                                      </div>
                                    </div>
                                    <div class="box-play-main box-play-d" style="display: none">
                                      <div class="content-single-game">
                                        <div class="top-single-game">
                                          <h3>JUGADA D <span>Marca 6 bolillas</span></h3>
                                        </div>
                                        <div class="body-single-game">
                                          <div class="body-game">
                                            <div class="button-group checkboxes-ball clearfix">
                                              <label>
                                              <input class="J4check_1" type="checkbox" name="J4check" value="1" id="J4check_1" /><span class="button-group-item check_" id="LJ4check_1" for="J4check_1"><span class="label-item">1</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_2" type="checkbox" name="J4check" value="2" id="J4check_2" /><span class="button-group-item check_" id="LJ4check_2" for="J4check_2"><span class="label-item">2</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_3" type="checkbox" name="J4check" value="3" id="J4check_3" /><span class="button-group-item check_" id="LJ4check_3" for="J4check_3"><span class="label-item">3</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_4" type="checkbox" name="J4check" value="4" id="J4check_4" /><span class="button-group-item check_" id="LJ4check_4" for="J4check_4"><span class="label-item">4</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_5" type="checkbox" name="J4check" value="5" id="J4check_5" /><span class="button-group-item check_" id="LJ4check_5" for="J4check_5"><span class="label-item">5</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_6" type="checkbox" name="J4check" value="6" id="J4check_6" /><span class="button-group-item check_" id="LJ4check_6" for="J4check_6"><span class="label-item">6</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_7" type="checkbox" name="J4check" value="7" id="J4check_7" /><span class="button-group-item check_" id="LJ4check_7" for="J4check_7"><span class="label-item">7</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_8" type="checkbox" name="J4check" value="8" id="J4check_8" /><span class="button-group-item check_" id="LJ4check_8" for="J4check_8"><span class="label-item">8</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_9" type="checkbox" name="J4check" value="9" id="J4check_9" /><span class="button-group-item check_" id="LJ4check_9" for="J4check_9"><span class="label-item">9</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_10" type="checkbox" name="J4check" value="10" id="J4check_10" /><span class="button-group-item check_" id="LJ4check_10" for="J4check_10"><span class="label-item">10</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_11" type="checkbox" name="J4check" value="11" id="J4check_11" /><span class="button-group-item check_" id="LJ4check_11" for="J4check_11"><span class="label-item">11</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_12" type="checkbox" name="J4check" value="12" id="J4check_12" /><span class="button-group-item check_" id="LJ4check_12" for="J4check_12"><span class="label-item">12</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_13" type="checkbox" name="J4check" value="13" id="J4check_13" /><span class="button-group-item check_" id="LJ4check_13" for="J4check_13"><span class="label-item">13</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_14" type="checkbox" name="J4check" value="14" id="J4check_14" /><span class="button-group-item check_" id="LJ4check_14" for="J4check_14"><span class="label-item">14</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_15" type="checkbox" name="J4check" value="15" id="J4check_15" /><span class="button-group-item check_" id="LJ4check_15" for="J4check_15"><span class="label-item">15</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_16" type="checkbox" name="J4check" value="16" id="J4check_16" /><span class="button-group-item check_" id="LJ4check_16" for="J4check_16"><span class="label-item">16</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_17" type="checkbox" name="J4check" value="17" id="J4check_17" /><span class="button-group-item check_" id="LJ4check_17" for="J4check_17"><span class="label-item">17</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_18" type="checkbox" name="J4check" value="18" id="J4check_18" /><span class="button-group-item check_" id="LJ4check_18" for="J4check_18"><span class="label-item">18</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_19" type="checkbox" name="J4check" value="19" id="J4check_19" /><span class="button-group-item check_" id="LJ4check_19" for="J4check_19"><span class="label-item">19</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_20" type="checkbox" name="J4check" value="20" id="J4check_20" /><span class="button-group-item check_" id="LJ4check_20" for="J4check_20"><span class="label-item">20</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_21" type="checkbox" name="J4check" value="21" id="J4check_21" /><span class="button-group-item check_" id="LJ4check_21" for="J4check_21"><span class="label-item">21</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_22" type="checkbox" name="J4check" value="22" id="J4check_22" /><span class="button-group-item check_" id="LJ4check_22" for="J4check_22"><span class="label-item">22</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_23" type="checkbox" name="J4check" value="23" id="J4check_23" /><span class="button-group-item check_" id="LJ4check_23" for="J4check_23"><span class="label-item">23</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_24" type="checkbox" name="J4check" value="24" id="J4check_24" /><span class="button-group-item check_" id="LJ4check_24" for="J4check_24"><span class="label-item">24</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_25" type="checkbox" name="J4check" value="25" id="J4check_25" /><span class="button-group-item check_" id="LJ4check_25" for="J4check_25"><span class="label-item">25</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_26" type="checkbox" name="J4check" value="26" id="J4check_26" /><span class="button-group-item check_" id="LJ4check_26" for="J4check_26"><span class="label-item">26</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_27" type="checkbox" name="J4check" value="27" id="J4check_27" /><span class="button-group-item check_" id="LJ4check_27" for="J4check_27"><span class="label-item">27</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_28" type="checkbox" name="J4check" value="28" id="J4check_28" /><span class="button-group-item check_" id="LJ4check_28" for="J4check_28"><span class="label-item">28</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_29" type="checkbox" name="J4check" value="29" id="J4check_29" /><span class="button-group-item check_" id="LJ4check_29" for="J4check_29"><span class="label-item">29</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_30" type="checkbox" name="J4check" value="30" id="J4check_30" /><span class="button-group-item check_" id="LJ4check_30" for="J4check_30"><span class="label-item">30</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_31" type="checkbox" name="J4check" value="31" id="J4check_31" /><span class="button-group-item check_" id="LJ4check_31" for="J4check_31"><span class="label-item">31</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_32" type="checkbox" name="J4check" value="32" id="J4check_32" /><span class="button-group-item check_" id="LJ4check_32" for="J4check_32"><span class="label-item">32</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_33" type="checkbox" name="J4check" value="33" id="J4check_33" /><span class="button-group-item check_" id="LJ4check_33" for="J4check_33"><span class="label-item">33</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_34" type="checkbox" name="J4check" value="34" id="J4check_34" /><span class="button-group-item check_" id="LJ4check_34" for="J4check_34"><span class="label-item">34</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_35" type="checkbox" name="J4check" value="35" id="J4check_35" /><span class="button-group-item check_" id="LJ4check_35" for="J4check_35"><span class="label-item">35</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_36" type="checkbox" name="J4check" value="36" id="J4check_36" /><span class="button-group-item check_" id="LJ4check_36" for="J4check_36"><span class="label-item">36</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_37" type="checkbox" name="J4check" value="37" id="J4check_37" /><span class="button-group-item check_" id="LJ4check_37" for="J4check_37"><span class="label-item">37</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_38" type="checkbox" name="J4check" value="38" id="J4check_38" /><span class="button-group-item check_" id="LJ4check_38" for="J4check_38"><span class="label-item">38</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_39" type="checkbox" name="J4check" value="39" id="J4check_39" /><span class="button-group-item check_" id="LJ4check_39" for="J4check_39"><span class="label-item">39</span></span>
                                              </label>
                                              <label>
                                              <input class="J4check_40" type="checkbox" name="J4check" value="40" id="J4check_40" /><span class="button-group-item check_" id="LJ4check_40" for="J4check_40"><span class="label-item">40</span></span>
                                              </label>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="footer-single-game">
                                          <div class="row no-gutters">
                                            <div class="col-6">
                                              <div class="footer-single-left">
                                                <button type="button" id="J4azar" class="azar button button-block button-light-green button-sm button-no-shadow">Al Azar</button>
                                              </div>
                                            </div>
                                            <div class="col-6">
                                              <div class="footer-single-right">
                                                <button type="button" id="J4clear" class="clear button button-block button-light-green button-sm button-no-shadow">Limpiar</button>
                                              </div>
                                            </div>
                                          </div>
                                        </div>
                                      </div>
                                      <div class="box-content-detail">
                                        <h5>Tus números son</h5>
                                        <textarea class="current-numbers" id="J4-text-area" readonly="readonly"></textarea>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                              <div class="col-6">
                                <div class="box-wrapper-game box-content-right">
                                  <div class="box-content-game">
                                    <div class="current-games">
                                      <div class="boxes-current-games clearfix">
                                        <div id="box-play-a" data-game="a" class="box-current-game game-playing">
                                          <a href="#">A</a>
                                        </div>
                                        <div id="box-play-b" data-game="b" class="box-current-game">
                                          <a href="#">B</a>
                                        </div>
                                        <div id="box-play-c" data-game="c" class="box-current-game">
                                          <a href="#">C</a>
                                        </div>
                                        <div id="box-play-d" data-game="d" class="box-current-game">
                                          <a href="#">D</a>
                                        </div>
                                      </div>
                                    </div>
                                    <div class="current-game-detail-award">
                                      <div  id="info-final-panel" class="font-opac-bold detail-final">
                                      </div>
                                      <div id="detail-add-info" class="col-9 detail-add">
                                        <div  id="info-add-panel">
                                        </div>
                                      </div>
                                      <div id="detail-add-btn" class="col-3 detail-add">
                                        <div class="action-add-award">
                                          <button id="add" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block button-orange btn-ok"><b>Ok</b></button>
                                        </div>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="row no-gutters" style="margin-top: 10px;">
                            <div class="col-12">
                              <div class="box-wrapper-game center" id="award-group">
                                <div id="award-group-panel" class="color-text-award"></div>
                                <div class="color-text-finalize">
                                  <div id="award-amount-panel" style="float: left;">
                                  </div>
                                  <div id="finalize-panel" >
                                    <button id="finalize"  style="border-radius:10px;" type="button" onclick="return false;" class="button button-lg button-no-shadow button-block btn-disabled-award"><b>FINALIZAR</b></button>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                        </form>
                      </div>
                    </div>
                    <div class="wrapper-buying">
                      <div class="box-wrapper-game">
                        <div class="box-content-game">
                          <div class="top-single-game">
                          </div>
                          <div class="body-single-game">
                            <div class="row">
                              <div class="col-6">
                                <div class="left-panel">
                                  <div id="content-grid-result"></div>
                                  <div id="num_link"></div>
                                </div>
                              </div>
                              <div class="col-6">
                                <div class="detail-pay">
                                  <h5>TOTAL <span class="label_2 detail-pay-date"></span></h5>
                                </div>
                                <div class="box-detail-pay">
                                  <h4>
                                    <span class="text-detail-pay label_resu2"></span>
                                    <div class="text-detail-pay detail-pay-monto result2"></div>
                                  </h4>
                                  <h4>
                                    <span class="text-detail-pay label_resu3"></span>
                                    <div class="text-detail-pay detail-pay-monto result3"></div>
                                  </h4>
                                  <h4>
                                    <b><span class="label_resu1"></span></b>
                                    <div class="text-detail-pay detail-pay-monto result1"></div>
                                  </h4>
                                </div>
                                <div class="box-action-pay">
                                  <div id="panel_keep-playing">
                                    <a href="juega-kabala.html" id="keep-playing" class="button button-lg button-no-shadow button-block button-orange">
                                    <b>SEGUIR JUGANDO</b>
                                    </a>
                                  </div>
                                  <div id="panel_game-history">
                                    <a href="mi-cuenta.html#jugadas" id="game-history" class="button button-lg button-no-shadow button-block button-dark-green">
                                    <b>IR A MIS JUGADAS</b>
                                    </a>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <div class="wrapper-purchase">
                            <div class="clearfix"></div>
                            <div id="ico-block">
                              <div id="ico-title">¡SIGUE JUGANDO Y PROBANDO TU SUERTE!</div>
                              <div id="ico-panel" class="clearfix">
                                <a href="juega-tinka.html" class="button-ico ico-tinka" id='btn_desktop_home_tinka'>
									<img src="./layer-view-image/v2/logo-tinka.svg?v=3" alt="Jugar La Tinka Lotería" />
                                </a>
								<a href="juega-kabala.html" class="button-ico ico-kabala" id='btn_desktop_home_kabala'>
                                <img src="./layer-view-image/v2/logo-kabala.svg" alt="Jugar Kabala" />
                                </a>
								<a href="juega-ganadiario.html" class="button-ico ico-ganadiario" id='btn_desktop_home_ganadiario'>
                                <img src="./layer-view-image/v2/logo-ganadiario.svg" alt="Jugar Gana Diario" />
                                </a>
								<a href="juega-latinka-video-loterias.html" class="button-ico ico-videoloteria" id='btn_desktop_home_videoloteria'>
									<img src="./layer-view-image/v2/landing/svg/videoloterias.png?v=1" alt="Jugar Video Loteria" />
								</a>
								<a href="juega-kinelo.html" class="button-ico ico-kinelo" id='btn_desktop_home_kinelo'>
                                <img src="./layer-view-image/v2/logo-kinelo.png" alt="Jugar Kinelo" />
                                </a>                                
								<a href="juega-ganagol.html" class="button-ico ico-ganagol" id='btn_desktop_home_ganagol'>
                                <img src="./layer-view-image/v2/logo-ganagol.svg" alt="Jugar Ganagol Apuestas de Fútbol" />
                                </a>
								<a onclick="toTAV2();" class="button-ico ico-teapuesto hand" id='btn_desktop_home_teapuesto'>
									<img src="./layer-view-image/v2/logo-teapuesto.png?v=1" alt="Jugar Te Apuesto Apuestas Deportivas" />
                                </a>                                
                              </div>
                            </div>
                            <div class="save-zone-game">
                              <div class="text-zone-game">
                                <img src="layer-view-image/v2/zona-segura.svg" alt="" />
                                <span>TE ENCUENTRAS EN ZONA SEGURA</span>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <aside class="banner">
                <div class="boxes-banner">

                  <!--video live-->
                  <%@ include file="live/video_live_banners.jspf" %>
                  <!--video live-->

                  <div class="box-banner">
                    <div class="box-main-game">
                      <div class="box-main-desc">
                        <figure>
                          <img src="layer-view-image/v2/logo-kabala.svg" alt="Jugar Kabala" />
                        </figure>
                        <h3>PREMIOS ENTREGADOS<br />A LA FECHA</h3>
                        <div class="main-desc-prize" id="total-prize"></div>
                        <div class="main-desc-slogan">Tu vida, más chévere</div>
                      </div>
                    </div>
                  </div>
                  <div class="box-banner">
                    <div class="box-main-game">
                      <div class="box-last-game">
                        <h4>JUGADA GANADORA</h4>
                        <div class="boxes-last-result">
                          <div class="box-last-result">
                            <h3 id="kb-date3"></h3>
                            <div class="last-restuls">
                              <div class="result-with-label">
                                <div class="result-label">
                                  <b>POZO BUENAZO</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-balls3"></div>
                              </div>
                              <div class="result-with-label kabala-siosi hide">
                                <div class="result-label">
                                  <b>SI O SI</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-siosi3"></div>
                              </div>
                              <div class="result-with-label">
                                <div class="result-label">
                                  <b>CHAU CHAMBA</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-chauchamba3"></div>
                              </div>
                              
                            </div>
                          </div>
                          <div class="box-last-result">
                            <h3 id="kb-date2"></h3>
                            <div class="last-restuls">
                              <div class="result-with-label">
                                <div class="result-label">
                                  <b>POZO BUENAZO</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-balls2"></div>
                              </div>
                              <div class="result-with-label kabala-siosi hide">
                                <div class="result-label">
                                  <b>SI O SI</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-siosi2"></div>
                              </div>
                              <div class="result-with-label">
                                <div class="result-label">
                                  <b>CHAU CHAMBA</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-chauchamba2"></div>
                              </div>
                              
                            </div>
                          </div>
                          <div class="box-last-result">
                            <h3 id="kb-date1"></h3>
                            <div class="last-restuls">
                              <div class="result-with-label">
                                <div class="result-label">
                                  <b>POZO BUENAZO</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-balls1"></div>
                              </div>
                              <div class="result-with-label kabala-siosi hide">
                                <div class="result-label">
                                  <b>SI O SI</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-siosi1"></div>
                              </div>
                              <div class="result-with-label">
                                <div class="result-label">
                                  <b>CHAU CHAMBA</b>
                                </div>
                                <div class="results-balls clearfix" id="kb-chauchamba1"></div>
                              </div>
							  
                            </div>
                          </div>
                        </div>
                        <div class="action-box-banner">
                          <a class="button button-orange-light" href="javascript:openDivLayer('resultados','kabala','<%=Constants.resultsServerURI%>i.do?m=resultados&t=0&s=42',600,470);">RESULTADOS ANTERIORES</a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="box-banner">
                    <div class="box-main-game">
                      <div class="box-stats">
                        <a href="javascript:openDivLayer('estadisticas','kabala','estadistica.html?marca=42',708,470)">
                          <h4>Entérate de las <span>estadísticas</span></h4>
                        </a>
                      </div>
                    </div>
                  </div>
                  <div class="box-banner">
                    <div class="box-main-game">
                      <div class="box-video">
                        <div class="box-video-src">
                          <iframe width="100%" height="125px" src="<%=ConnectionFactory.operationProperty("iflexKabalaYoutubeUrl", Constants.contextSale).trim()%>" frameborder="0" allowfullscreen></iframe>
                        </div>
                        <div class="box-video-more">
                          <a target="_self" href="<%=Constants.URL_QW%>/kabala/ultimos-resultados/?origin=i"><img src="./layer-view-image/v2/view-more-white.png" alt="" /> Ver más videos</a>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="box-banner">
                    <a href="https://www.facebook.com/latinkaoficial" target="_blank" class="box-social">
                    <img src="./layer-view-image/v2/facebook.png" alt="" />
                    </a>
                  </div>
                </div>
              </aside>
            </div>
          </div>
        </div>
      </div>
    </div>

    <!--video live-->
    <%@ include file="live/video_live_popups.jspf" %>
    <!--video live-->

    <script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
    <script type='text/javascript' src='layer-view-script/common/jquery.scripts.js'></script>
    <script type='text/javascript' src='layer-view-script/game/kabala/lotto-award-kabala.js'></script>
    <script type='text/javascript' src='layer-view-script/game/kabala/lotto-kabala-chauchamba.js?v=3'></script>
    <script type='text/javascript' src='layer-view-script/common/loadBalanceGame.js?v=3'></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jPages.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>

    <!--video live-->
    <script type="text/javascript" src="layer-view-script/game/kabala/live/hls.js"></script>
    <script type="text/javascript" src="layer-view-script/game/kabala/live/glide.min.js"></script>
    <script type="text/javascript" src="layer-view-script/game/kabala/live/video.js"></script>
    <!--video live-->

    <%@ include file="../../include/footer.jspf" %>
    <script type="text/javascript">
    $(document).ready(function(){

        $.ajax({
          url: $("#gamesXML").val(),
          // url: "./games.xml",
          cache: false,
          success: function(res) {
            var xmlDoc = res;
            data = xmlDoc.getElementsByTagName("data");
            if (data[0]) {
                
                data = data[0];

                for (var i = 1; i <= 3; i++) {
                    var bolos_kabala = data.getElementsByTagName("kb_bolos_" + i)[0].childNodes[0].nodeValue.split(' ');
                    printBalls(bolos_kabala, "#kb-balls" + i);

                    var bolos_chauchamba = data.getElementsByTagName("kb_chauchamba_" + i)[0].childNodes[0].nodeValue.split(' ');
                    printBalls(bolos_chauchamba, "#kb-chauchamba" + i);

                    var bolos_siosi = ""; 
					try {
						bolos_siosi = data.getElementsByTagName("kb_siosi_" + i)[0].childNodes[0].nodeValue.split(' ');   
					} catch (e) {}
					
                    if(bolos_siosi.toString().trim().length > 0) $("#kb-siosi" + i).parent().removeClass('hide');
					printBalls(bolos_siosi, "#kb-siosi" + i);

                    var results_date_kabala = data.getElementsByTagName("kb_fecha_" + i)[0].childNodes[0].nodeValue;
                    printDate(results_date_kabala, "#kb-date" + i);
                }

                var total_prize = data.getElementsByTagName("kb_total_premios")[0].childNodes[0].nodeValue;
                $('#total-prize').html("S/ " + total_prize);

            } else {
                console.log('no data')
            }

          }, error: function(e) {
            console.log('error obteniendo xml...')
          }
        });

    });
      
    </script>
    <script type="text/javascript">
     
      awardPaid();
    </script>
  </body>
</html>