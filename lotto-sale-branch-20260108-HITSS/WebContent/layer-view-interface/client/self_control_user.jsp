<%@ include file="../include/taglibs.jspf"%>
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

    <meta charset="utf-8">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/selfControl.css?v=2">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css"> 
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/carousel.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
	<meta name="viewport" content="width=1024">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/v2/styles.css?v=<%=Constants.css_v2_styles_v%>">

	<script type="text/javascript">
		window.location.href = "mi-cuenta.html#yo-autocontrol";
	</script>
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <title>Autocontrol</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body>

<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

    <%@ include file="../include/header.jspf"%>

    <div class="main-content">
        <div class="main-page">

            <div class="row">

                <div class="col-12 col-md-8">

                    <div class="wrapper-form">

                        <div class="head-main-form">
                            <h2>AUTOCONTROL</h2>
                            <div class="sub-head-form">
                                <p class="no-upper"><b>¿Sientes que tienes problemas de autocontrol?</b></p>
                                <p class="no-upper"><span>Te ayudamos establecer tus límites. Lee los términos y condiciones antes de elegir. Tienes dos opciones de autocontrol:</span></p>
                            </div>
                        </div>

                        <div class="body-main-form">

                            <div class="box-main-form">

                                <div class="inner-content group">
                                    <section id="money-control" class="bounds">
                                        <div class="icon"><label for="soles">soles</label></div>
                                        <p class="instructions">Define el monto máximo mensual para realizar tus compras.</p>
                                        <form id="frm-define-money" action="define-limit.html" method="post" data-response-type="json">
                                            <fieldset>
                                                <legend class="hidden">monto máximo</legend>
                                                <label for="soles">Soles:</label>
                                                <div class="box-bound">
                                                    <input class="text-in" type="text" name="soles" id="soles" placeholder="0.00" required>
                                                    <button class="btn btn-orange">Guardar</button>
                                                </div>
                                            </fieldset>
                                        </form>
                                        <div class="response">
                                            <p>Haz definido tu límite de consumo mensual a</p>
                                            <p id="money-control-message" class="prominent">S/. 500 el 01/04/2013 12:34pm</p>
                                            <p>Para modificarlo deberás esperar 7 días a partir de la fecha especificada.</p>
                                        </div>
                                    </section>
                                    <section id="time-control" class="bounds">
                                        <div class="icon">horas</div>
                                        <p class="instructions">Escoge el tiempo máximo diario para permanecer conectado en tu cuenta</p>
                                        <form id="frm-define-time" action="define-limit.html" method="post" data-response-type="json">
                                            <fieldset>
                                                <legend class="hidden"></legend>
                                                <label for="">Horas:</label>
                                                <div class="box-bound">
                                                    <div class="custom-select custom-select-2" data-select="hours" id="switch-hours">
                                                        <span id="op-sel-hours" class="placeholder">ninguno</span>
                                                        <ul class="option-list" id="x-hours" data-select="hours"></ul>
                                                    </div>
                                                    <select class="select" name="hours" id="hours">
                                                        <option value="0">seleccione:</option>
                                                    </select>
                                                    <button class="btn btn-orange">Guardar</button>
                                                </div>
                                            </fieldset>
                                        </form>
                                        <div class="response">
                                            <p>Haz definido tu límite de conexión diaria a</p>
                                            <p id="time-control-message" class="prominent">4 horas el 01/01/2013 12:34pm</p>
                                            <p>Para modificarlo deberás esperar 7 días a partir de la fecha especificada.</p>
                                        </div>
                                    </section>
                                </div>

                                <div class="terms">
                                    <p class="no-upper"><b>Términos y condiciones</b></p>
                                    <ul class="condition-list">
                                        <li><p class="no-upper">Solo se podrá escoger una opción de autocontrol, no se puede tener vigentes ambas al mismo tiempo.</p></li>
                                        <li><p class="no-upper">Superado el tiempo y/o monto escogido no podrás realizar más jugadas en tu cuenta de usuario.</p></li>
                                        <li><p class="no-upper">Si quisieras modificar tus límites hay un periodo de espera de 7 días calendarios. Este periodo permite considerar tu cambio. No te olvides de actualizar mensualmente tus límites.</p></li>
                                        <li><p class="no-upper">Para mayor información sobre nuestros sistemas de autoexclusión llama al 5135502 opc. 2. Conoce tus límites. Juega responsablemente.</p></li>
                                    </ul>
                                </div>

                            </div>

                        </div>

                    </div>

                </div>

                <div class="col-12 col-md-4">
                    
                    <aside class="banner">

                        <div class="boxes-banner">

<!--                             <div class="box-banner"> -->
<!--                                 <div class="load-money"> -->
<!--                                     <a href="./mi-cuenta.html#saldo"><img src="layer-view-image/v2/logo-soles.png"><span>CARGAR MI SALDO</span></a> -->
<!--                                 </div> -->
<!--                             </div> -->

                            <div class="main-tinka">
                                <div class="box-banner">
                                    <div class="box-main-game">
                                        <div class="box-main-desc-min">
                                            <figure>
                                                <a href="./juega-tinka.html">
                                                    <img src="layer-view-image/v2/logo-tinka.svg?v=3" alt="Jugar La Tinka Lotería" />
                                                </a>
                                            </figure>
                                            <h3>POZO</h3>
                                            <div class="main-desc-prize" id="pozo-tinka"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="main-kabala">
                                <div class="box-banner">
                                    <div class="box-main-game">
                                        <div class="box-main-desc-min">
                                            <figure>
                                                <a href="./juega-kabala.html">
                                                    <img src="layer-view-image/v2/logo-kabala.svg" alt="Jugar Kabala" />
                                                </a>
                                            </figure>
                                            <h3>POZO MARTES</h3>
                                            <div class="main-desc-prize" id="pozo-kabala"></div>
                                            <div class="sub-box-main-desc-min">
                                                <figure>
                                                    <img src="layer-view-image/v2/logo-chauchamba.png" alt="Jugar La Tinka" />
                                                </figure>
                                                <div class="right-sub-box">
                                                    <div class="main-desc-prize">S/ 5,000</div>
                                                    <h3>MENSUALES POR 20 AÑOS</h3>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="main-ganadiario">
                                <div class="box-banner banner">
                                    <div class="box-main-game">
                                        <div class="box-main-desc">
                                            <figure>
                                                <a href="./juega-ganadiario.html">
                                                    <img src="layer-view-image/v2/logo-ganadiario.svg" alt="Jugar Gana Diario" />
                                                </a>
                                            </figure>
                                            <h3>¡EMPIEZA A GANAR HOY!</h3>
                                            <h4>PREMIO MAYOR</h4>
                                            <div class="main-desc-prize big-prize" id="premio-ganadiario"></div>
                                        </div>
                                    </div>
                                </div>
                            </div>

                        </div>

                    </aside>

                </div>

            </div>

        </div>
    </div>
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
    <script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
    <script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
    <script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
    <script type="text/javascript" src="layer-view-script/client/selfControl.js?v=9"></script>
    <script type="text/javascript" src="layer-view-script/v2/main.js?v=<%=Constants.v2_main_js%>"></script>
	<%@ include file="../include/footer.jspf"%>
    <%@ include file="../include/message.jspf"%>
    <script type="text/javascript">
//     	sessionStorage.setItem('autocontrol', 'autocontrol');
    	window.location.href = "mi-cuenta.html#yo-autocontrol";
        $(document).ready(function(){
			
            $.ajax({
              url: $("#gamesXML").val(),
              cache: false,
              success: function(res) {
                var xmlDoc = res;
                data = xmlDoc.getElementsByTagName("data");
                if (data[0]) {
                    
                    data = data[0];

                    var pozo_tinka = "S/ " + data.getElementsByTagName("tk_pozo")[0].childNodes[0].nodeValue;
                    $("#pozo-tinka").html(pozo_tinka);

                    var pozo_kabala = "S/ " + data.getElementsByTagName("kb_pozo")[0].childNodes[0].nodeValue;
                    $("#pozo-kabala").html(pozo_kabala);

                    var pozo_ganadiario = "S/ " + data.getElementsByTagName("gd_premio")[0].childNodes[0].nodeValue;
                    $("#premio-ganadiario").html(pozo_ganadiario);

                } else {
                    console.log('no data')
                }

              }, error: function(e) {
                console.log('error obteniendo xml...')
              }
            });

        });

    </script>


</body>
</html>