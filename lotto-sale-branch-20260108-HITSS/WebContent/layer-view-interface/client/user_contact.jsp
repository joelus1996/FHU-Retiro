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

    <meta http-equiv="refresh" content="0; url=https://latinkaportal.com.pe/contactanos/" />
    <meta name="viewport" content="width=1024">
    <!-- 
    <meta charset="UTF-8">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/jquery.alerts.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/themeUser.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/keyboard.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/signUp.css">
    <link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/styleContact.css">
    <script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
    <title>Contactenos</title>
    <link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
    -->
</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<!-- 
< % @ include file="../include/header.jspf" % >

<div id="main-content-background">
    <div id="main-content">
        <input type="hidden" id="DataUserClaim" value="<c:out value='${DataUser}'/>">
        < % @ include file="../include/menu.jspf" % >
        <div class="content-contact-title">
            <span class="contact-icon-title"></span>
            <span class="contact-title-text">CONT&Aacute;CTANOS</span>
        </div>
        <div class="content-contact">
            <div class="content-contact-info">
                <span class="contact-icon-ubi"></span>

                <div class="contact-text-ubi"><span><b>UBICACI&Oacute;N</b></span><br><span>Av. Del Parque Norte N&ordm;
                    1180. Urb. Corpac, San Borja</span></div>
                <span class="contact-icon-call"></span>

                <div class="contact-text-call"><span><b>SERVICIO AL
                    CLIENTE</b></span><br><span>5135502 opci&oacute;n 9</span></div>
            </div>
            <span class="contact-text-form">Llena tus datos en el formulario y env&iacute;anos tu consulta. Todos los campos son obligatorios:</span>

            <form id="frm-book-claim" action="save-claims.html" method="post">

                <fieldset class="account-data-fields">
                    <legend class="hidden">account data info</legend>
                    <h4>TUS DATOS</h4>
                    <table id="table1">
                        <tr>
                            <td class="clabel" id="clabel"><label for="name">Nombres</label></td>
                            <td class="cq"></td>
                            <td class="cinputs"><input type="text" class="text-in max" id="name" name="name" placeholder="nombres" autocomplete="off" required="required">
                            </td>
                        </tr>
                        <tr>
                            <td class="clabel"><label for="ap-paterno">Apellidos</label></td>
                            <td class="cq"></td>
                            <td class="cinputs">
                                <input type="text" class="text-in half" name="ap-paterno" id="ap-paterno"
                                       placeholder="paterno" autocomplete="off" required="required">
                                <input type="text" class="text-in half" name="ap-materno" id="ap-materno"
                                       placeholder="materno" autocomplete="off" required="required">
                            </td>
                        </tr>
                        <tr>
                            <td class="clabel"><label>Tipo de documento</label></td>
                            <td class="cq"><span class="question-mark"></span></td>
                            <td class="cinputs">
                                <div class="custom-select" data-select="document-type" id="switch-document-type">
                                    <span id="op-sel-document-type" class="value-in placeholder">seleccione</span>
                                    <ul class="option-list" id="x-document-type" data-select="document-type"></ul>
                                </div>
                                <select class="select" name="document-type" id="document-type"></select>
                                <input onkeypress="return validar(event)" type="text" class="text-in medium" name="document-number" id="document-number"
                                       placeholder="número" maxlength="8" autocomplete="off" required="required">
                            </td>
                        </tr>
                        <tr>
                            <td class="clabel"><label>Fecha de nacimiento</label></td>
                            <td class="cq"><span class="question-mark" id="d-question">[?]</span></td>
                            <td class="cinputs">
                                <div class="custom-select" data-select="day" id="switch-day">
                                    <span id="op-sel-day" class="placeholder">Día</span>
                                    <ul class="option-list" id="x-day" data-select="day"></ul>
                                </div>
                                <select class="select" name="day" id="day"></select>

                                <div class="custom-select" data-select="month" id="switch-month">
                                    <span id="op-sel-month" class="placeholder">Mes</span>
                                    <ul class="option-list" id="x-month" data-select="month"></ul>
                                </div>
                                <select class="select" name="month" id="month"></select>

                                <div class="custom-select" data-select="year" id="switch-year">
                                    <span id="op-sel-year" class="placeholder">A&ntilde;o</span>
                                    <ul class="option-list" id="x-year" data-select="year"></ul>
                                </div>
                                <select class="select" name="year" id="year"></select>
                            </td>
                        </tr>

                        <tr>
                            <td class="clabel"><label for="region">Región</label></td>
                            <td class="cq"></td>
                            <td class="cinputs">
                                <div class="custom-select max" data-select="region" id="switch-region">
                                    <span id="op-sel-region" class="placeholder">seleccione</span>
                                    <ul class="option-list" id="x-region" data-select="region"></ul>
                                </div>
                                <select class="select" name="region" id="region" required="required">
                                    <option value="">seleccione</option>
                                    <c:forEach var="region" items="${regions}">
                                        <option value="<c:out value='${region.regionId}'/>">
                                        <c:out value="${region.regionName}"/>
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td class="clabel"><p class="movil"><label for="fixed-phone">Teléfonos</label></p></td>
                            <td class="cq"></td>
                            <td class="cinputs" id="cinputs">
                                <input type="text" onkeypress="return validar(event)" class="text-in small" name="fixed-phone" id="fixed-phone"
                                       placeholder="fijo">
                                <input type="text" onkeypress="return validar(event)" class="text-in medium" name="mobile-phone" id="mobile-phone"
                                       placeholder="celular">
                            </td>
                        </tr>
                        <tr>
                            <td class="clabel"><label for="email">Correo electrónico</label></td>
                            <td class="cq"><span class="question-mark" id="mail-question">[?]</span></td>
                            <td class="cinputss"><input type="text" class="text-in max" name="email" id="email"
                                                        placeholder="example@domain.com" autocomplete="off"
                                                        required="required"></td>
                        </tr>
                    </table>
                </fieldset>
                <fieldset class="personal-data-fields">
                    <legend class="hidden">personal data info</legend>
                    <h4>TU CONSULTA</h4>
                    <table>
                        <tr>
                            <td class="cinputs">
                                <table class="gread-box">
                                    <tr>
                                        <td>
                                            <input type="radio" class="radio-lucky margin-r option_1" name="opt"
                                                   id="SUGGESTION" value="SUGGESTION" required="required"
                                                   checked="checked"><label class="font-b" for="SUGGESTION">Sugerencias
                                            y preguntras</label><br>
                                            <input type="radio" class="radio-lucky margin-r option_1" name="opt"
                                                   id="SOLUTION" value="SOLUTION" required="required"><label
                                                class="font-b" for="SOLUTION">Soluci&oacute;n</label><br>
                                            <input type="radio" class="radio-lucky margin-r option_1" name="opt"
                                                   id="SUPPORT" value="SUPPORT" required="required"><label
                                                class="font-b" for="SUPPORT">Soporte t&eacute;cnico Web</label><br>
                                            <!-- input type="radio" class="radio-lucky margin-r option_2" name="opt"
                                                   id="OPENPOS" value="OPENPOS" required="required"><label
                                                class="font-b" for="OPENPOS">Para abrir un Punto de Venta</label><br - - >
                                            <input type="radio" class="radio-lucky margin-r option_3" name="opt"
                                                   id="PROMOTER" value="PROMOTER" required="required"><label
                                                for="PROMOTER" class="font-b">Comentarios sobre la vendedora</label><br>
                                            <input type="radio" class="radio-lucky margin-r option_1" name="opt"
                                                   id="OTHERS" value="OTHERS" required="required"><label class="font-b"
                                                                                                         for="OTHERS">Otro</label><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td class="line">--------------------------------------------</td>
                                    </tr>
                                    <tr class="option1">
                                        <td class="width-td">
                                            <table class="margin-r">
                                                <tr>
                                                    <td><input type="checkbox" class="ck_play" name="Tinka" id="Tinka"
                                                               value="Tinka"><label for="Tinka"
                                                                                    class="font-b">Tinka</label></td>
                                                    <td><input type="checkbox" class="ck_play" name="Teapuesto"
                                                               id="Teapuesto" value="Teapuesto"><label for="Teapuesto"
                                                                                                       class="font-b">Teapuesto</label>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" class="ck_play" name="Ganagol" id="Ganagol"
                                                               value="Ganagol"><label for="Ganagol"
                                                                                      class="font-b">Ganagol</label></td>
                                                    <td><input type="checkbox" class="ck_play" name="Ganadiario"
                                                               id="Ganadiario" value="Ganadiario"><label for="Ganadiario"
                                                                                                         class="font-b">Ganadiario</label>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" class="ck_play" name="Kabala" id="Kabala"
                                                               value="Kabala"><label for="Kabala" class="font-b">K&aacute;bala</label>
                                                    </td>
                                                    <td><input type="checkbox" class="ck_play" name="Super3" id="Super3"
                                                               value="Super3"><label for="Super3" class="font-b">S&uacute;per
                                                        3</label></td>
                                                </tr>
                                                <tr>
                                                    <td><input type="checkbox" class="ck_play" name="ClicGana"
                                                               id="ClicGana" value="ClicGana"><label for="ClicGana"
                                                                                                     class="font-b">Clic
                                                        & Gana</label></td>
                                                    <td class="width-td"><input type="checkbox" class="ck_play"
                                                                                name="Reventon" id="Reventon"
                                                                                value="Reventon"><label for="Reventon"
                                                                                                        class="font-b">El
                                                        revent&oacute;n</label></td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        <input type="checkbox" class="ck_play" name="RapTRapG" id="RapTRapG" value="RapTRapG">
                                                        <label for="RapTRapG" class="font-b">Rapitinka <br><span class="mar-text">y Rapigana</span></label>
                                                    </td>
                                                    <td>
                                                        <input type="checkbox" class="ck_play" name="Fechaza" id="Fechaza" value="Fechaza">
                                                        <label for="Fechaza" class="font-b">Fechaza</label><br>
                                                        <input type="checkbox" class="todos" name="todos" id="todos" value="todos">
                                                        <label for="todos" class="font-b">Todos</label>
                                                    </td>
                                                </tr>
                                            </table>
                                        </td>
                                    </tr>
                                    <tr class="option2">
                                        <td class="width-td">
                                            <table class="margin-r">
                                                <tr>
                                                    <td>
                                                        <span class="text-title-option"><b>Ubicaci&oacute;n del
                                                            local:</b> Especifique el lugar</span><br>
                                                        <input type="radio" class="radio-lucky" name="opt2"
                                                               id="SHOPCENTER" value="SHOPCENTER"><label
                                                            for="SHOPCENTER" class="font-b">Dentro de un centro
                                                        comercial</label><br>
                                                        <input type="radio" class="radio-lucky" name="opt2" id="MARKET"
                                                               value="MARKET"><label for="MARKET" class="font-b">Dentro
                                                        de un mercado</label><br>
                                                        <input type="radio" class="radio-lucky" name="opt2"
                                                               id="MAINROAD" value="MAINROAD"><label for="MAINROAD"
                                                                                                     class="font-b">En
                                                        una avenida principal</label><br>
                                                        <input type="radio" class="radio-lucky" name="opt2"
                                                               id="MAINSTREET" value="MAINSTREET"><label
                                                            for="MAINSTREET" class="font-b">En una calle secundaria /
                                                        jir&oacute;n</label><br>
                                                        <input type="radio" class="radio-lucky" name="opt2"
                                                               id="OTHERPOINT" value="OTHERPOINT"><label
                                                            for="OTHERPOINT" class="font-b">Otro</label><br>
                                                    </td>
                                                <tr>
                                            </table>
                                        </td>
                                    </tr>
                                </table>
                            </td>
                        </tr>
                    </table>
                </fieldset>
                <textarea class="text-in" id="block-text" name="coment" placeholder="Escribe tu texto aqu&iacute;"></textarea>
                <button id="btn-cancelar" type="reset"></button>
                <button id="btn-enviar" type="submit"></button>
            </form>
            <div>
            </div>
        </div>
        <iframe class="style-iframe" src="/web/home/right.html" frameborder="0" scrolling="no" width="300" height="516" style="visibility:hidden;" onload="this.style.visibility='visible';"></iframe>
        < % @ include file="../include/footer.jspf" % >
    </div>
</div>

<script type='text/javascript' src='layer-view-script/common/jquery-3.6.3.min.js'></script>
<script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
<script type="text/javascript" src="layer-view-script/common/jquery.scripts.js"></script>
<script type="text/javascript" src="layer-view-script/common/keyboard.js"></script>
<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
<script type="text/javascript" src="layer-view-script/client/signUp.js"></script>
<script type="text/javascript" src="layer-view-script/common/index.js?v=<%=Constants.index_js%>"></script>
<script type="text/javascript">;
var $contact = function () {
    $(".option1").show();
    $(".option2").hide();
    $(".option2").addClass("block-none");
    $(".option_1").on("click", function () {
        $(".option1").show();
        $(".option2").hide();
        $(".option1").removeClass("block-none");
        $(".option2").addClass("block-none")
    });
    $(".option_2").on("click", function () {
        $(".option1").hide();
        $(".option2").show();
        $(".option2").removeClass("block-none");
        $(".option1").addClass("block-none")
    });
    $(".option_3").on("click", function () {
        $(".option1").hide();
        $(".option2").hide();
        $(".option1").addClass("block-none");
        $(".option2").addClass("block-none")
    });
    $(".todos").on("change", function () {
        $(this).prop('checked') ? $(".ck_play").prop("checked", true) : $(".ck_play").prop("checked", false)
    });
    $(".ck_play").on("change", function () {
        $(".todos").prop("checked", false)
    });
    $("#btn-cancelar").on("click", function () {
        //window.location.replace('mi-cuenta.html')
    })
};
$($contact);
</script>
-->
</body>
</html>