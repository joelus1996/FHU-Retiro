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

<meta charset="UTF-8">
<meta name="viewport" content="width=1024">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/normalize.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/style.css?v=<%=Constants.common_style_css%>">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/carousel.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/menu.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/client/chargeAccount.css">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/common/dhtmlwindow.css?v=<%=Constants.dhtmlwindow_css%>">
<script type="text/javascript" src="layer-view-script/common/prefixfree.min.js"></script>
<script type="text/javascript" src="layer-view-script/common/modernizr.js"></script>
<title>Datos Tarjeta de Crédito</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">
</head>
<body> 
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<c:choose>
 <c:when test="${ALERT_MSG != null && ALERT_MSG!=''}">	 
    <article id="charge-msg">  
        <br/><br/><h3 id="charge-msg-title" class="tab-title">${ALERT_MSG}</h3>
    </article>
 </c:when>
 <c:otherwise>
    <article id="charge-account">
        <h3 id="charge" class="tab-title">datos personales</h3>
        <section class="content">
            <div class="inner-content">
                <form id="frm-charge-account" action="pasarela-vpos.html" method="post">
                    <input type="hidden" name="pos-amount" value="<c:out value='${posAmount}'/>"/>
                    <input type="hidden" name="pos-mode" value="<c:out value='${posMode}'/>"/>
                    <fieldset class="personal-data-fields">
                        <legend class="hidden">personal data info</legend>
                        <table>
                            <tr>
                                <td class="clabel"><label for="name">Nombres</label></td>
                                <td class="cq"></td>
                                <td class="cinputs">
                                    <input type="text" class="text-in max" id="name" name="name" autocomplete="off" required>
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel"><label for="last-name-paternal">Apellidos</label></td>
                                <td class="cq"></td>
                                <td class="cinputs">
                                    <input type="text" class="text-in half" name="ap-paterno" id="last-name-paternal" placeholder="paterno" autocomplete="off"  required="required">
                                    <input type="text" class="text-in half" name="ap-materno" id="last-name-maternal" placeholder="materno" autocomplete="off"  required="required">
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel"><label for="email">Correo Electrónico</label></td>
                                <td class="cq"><span class="question-mark">[?]</span></td>
                                <td class="cinputss">
                                    <input type="text" class="text-in max" name="email" id="email" placeholder="name@example.com" autocomplete="off"  required="required">
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel"><label for="phone">Teléfonos</label></td>
                                <td class="cq"></td>
                                <td class="cinputs">
                                    <input type="text" class="text-in small" name="phone" id="phone" placeholder="fijo" required="required">
                                    <input type="text" class="text-in medium" name="fixed-phone" id="fixed-fone" placeholder="móvil">
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel"><label for="document-type">Tipo de documento</label></td>
                                <td class="cq"><span class="question-mark">[?]</span></td>
                                <td class="cinputs">
                                    <div class="custom-select" data-select="document-type" id="switch-document-type">
                                        <span id="op-sel-document-type" class="placeholder">seleccione:</span>
                                        <ul class="option-list" id="x-document-type" data-select="document-type"></ul>
                                    </div>
                                    <select class="select" name="document-type" id="document-type"></select>
                                    <input type="text" name="document-number" id="document-number" class="text-in medium">
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel"><label>Ubicación</label></td>
                                <td class="cq"></td>
                                <td class="cinputs">
                                    <div class="custom-select max" data-select="country" id="switch-country">
                                        <span id="op-sel-country" class="placeholder">País</span>
                                        <ul class="option-list" id="x-country" data-select="country"></ul>
                                    </div>
                                    <select class="select" name="country" id="country">
                                    <option value="">País</option>
                                        <c:forEach var="country" items="${countries}">
                                            <option value="<c:out value='${country.countryId}'/>">
                                            <c:out value="${country.countryName}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel">
                                    
                                </td>
                                <td class="cq"></td>
                                <td class="cinputs">
                                    <div class="custom-select half" data-select="region" id="switch-region">
                                        <span id="op-sel-region" class="placeholder">Región</span>
                                    <ul class="option-list" id="x-region" data-select="region"></ul>
                                    </div>
                                    <select class="select" name="region" id="region" required="required">
                                    <option value="">Región</option>
                                        <c:forEach var="region" items="${regions}">
                                            <option value="<c:out value='${region.regionId}'/>">
                                                <c:out value="${region.regionName}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                    <div class="custom-select half" data-select="province" id="switch-province">
                                        <span id="op-sel-province" class="placeholder">Provincia</span>
                                        <ul class="option-list" id="x-province" data-select="province"></ul>
                                    </div>
                                    <select class="select" name="province" id="province" required="required">
                                    <option value="">Provincia</option>
                                        <c:forEach var="province" items="${provinces}">
                                            <option value="<c:out value='${province.provinceId}'/>">
                                            <c:out value="${province.provinceName}"/>
                                            </option>
                                        </c:forEach>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel"><label for="address">Dirección</label></td>
                                <td class="cq"></td>
                                <td class="cinputs">
                                    <input type="text" class="text-in max" name="address" id="address" required="required">
                                </td>
                            </tr>
                            <tr>
                                <td class="clabel"><label for="zipcode">Código Postal</label></td>
                                <td class="cq"></td>
                                <td class="cinputs">
                                    <input type="text" class="text-in half" name="zipcode" id="zipcode" required="">
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                    <div class="additional-info">
                        <div class="detail-data-fields">
                            <table>
                                <caption><label>DETALLE DE CARGA DE SALDO</label></caption>
                                <tr>
                                    <td class="clabel"><label>Monto de Carga:</label></td>
                                    <td class="cq"></td>
                                    <td class="clabel"><span>S/. <c:out value="${posAmount}"/></span></td>
                                </tr>
                                <tr>
                                    <td class="clabel"><label>Tipo de Cambio:</label></td>
                                    <td class="cq"></td>
                                    <td class="clabel"><span>S/. <c:out value="${exchangeRate}"/></span></td>
                                </tr>
                                <tr>
                                    <td class="clabel"><label>Total en Dólares:</label></td>
                                    <td class="cq"></td>
                                    <td class="clabel"><span>$ <c:out value="${dollarAmount}"/></span></td>
                                </tr>
                            </table>
                        </div>
                        <fieldset class="other-fields">
                            <legend class="hidden">mandatory and optional options</legend>
                            <input id="to" type="checkbox" required>
                            <label for="to">Acepto la <a href="#" onclick="callPolicies();">Política de Ventas por Internet</a>.</label>
                            <br/>
                        </fieldset>
                        <p class="security-info">Para tu seguridad las recargas de saldo por tarjeta de crédito deben contar con el
                            control Verified By Visa.<br/>Si tu tarjeta no está activada ponte en contacto con tu banco.</p>
                        <p class="responsibility-info">El procesamiento de tu transacción estrá a cargo de Bizpay Secure Payment
                        Gateway. <span class="prominent">La Tinka S.A.</span> no se hace responsable de cualquier falla o deficiencia que pudiera
                            surgir en esta plataforma dado que se encuentra fuera de la esfera de control del mismo.</p>
                        <p class="last-info">Luego de dar clic en el botón <span class="prominent">Aceptar</span> por favor, no toque su
                            navegador de Internet hasta que finalice la transacci&oacute;n y reciba un mensaje de respuesta, el proceso
                            de Autorizaci&oacute;n del Pago puede tomar hasta un minuto. El proceso de recarga ser&aacute; verificado por las empresas intervinientes
                            por lo que podr&iacute;a demorar m&aacute;s de 24 horas.
							Inf&oacute;rmese de los T&eacute;rminos y Condiciones. Por favor, tome sus precauciones.</p>
                    </div>
                    
					<c:if test="${clientData.comStatus == 'BIZPAYOK'}">
                         <button id="btn-register" type="submit">Aceptar</button>
					</c:if>
					<c:if test="${clientData.comStatus != 'BIZPAYOK'}">					
                         <p class="clabel">${clientData.comStatus}. Debe esperar que se verifiquen sus transacciones</p><br/>
					</c:if>
                    
                </form>
                <img width="180" height="20" title="Zona Segura" alt="zona segura" src="layer-view-image/common/secure-zone.png">
            </div>
        </section>
    </article>
    <script type="text/javascript" src="layer-view-script/common/jquery-3.6.3.min.js"></script>
    <script type="text/javascript" src="layer-view-script/common/jquery.alerts.js"></script>
	<script type="text/javascript" src="layer-view-script/common/utils.js?v=<%=Constants.utils_js%>"></script>
	<script type="text/javascript" src="layer-view-script/common/dhtmlwindow.js"></script>
    <script type="text/javascript">
    var nombre = "<c:out value='${clientData.nombre}'/>";
    var paterno = "<c:out value='${clientData.apPaterno}'/>";
    var materno = "<c:out value='${clientData.apMaterno}'/>";
    var email = "<c:out value='${clientData.mail}'/>";
    var phone = "<c:out value='${clientData.mobilePhone}'/>";
    var doctype = "<c:out value='${clientData.typeId}'/>";
    var docnum = "<c:out value='${clientData.numberId}'/>";
    var country = "<c:out value='${clientData.country}'/>";
    var region = "<c:out value='${clientData.region}'/>";
    var address = "<c:out value='${clientData.address}'/>";
    var create = {
         optionItem: function (a, b) {
             return"<li class='option-item' data-option-value=" + b + ">" + a + "</li>"
         }, optionsList: function (a) {
             var b = '';
             a.children('option').each(function () {
                 if ($(this).val() != '') {
                     b += create.optionItem($(this).text(), create.dataAttributeSelect($(this).val()))
                 }
             });
             return b
         }, dataAttributeSelect: function (a) {
             return a
         },
         documentTypeList: function () {
             var a = '<option value="">seleccione</option>';
             var b = [
                 {code: "DNI", description: "DNI"},
                 {code: "PASAP", description: "Pasaporte"},
                 {code: "CAREX", description: "Carnet de Extranjería"}
             ];
             $.map(b, function (d) {
                 a += '<option value="' + d.code + '">' + d.description + '</option>'
             });
             return a
         }
    };
    var $vpos = function () {
        var $documentType = $('#document-type');
        $documentType.html(create.documentTypeList());
        $('#x-document-type').html(create.optionsList($documentType));        
        $('#x-country').html(create.optionsList($('#country')));
        $('#x-region').html(create.optionsList($('#region')));
        $('#x-province').html(create.optionsList($('#province')));
        $('.custom-select').on('click', function (event) {
            event.stopPropagation();
            $('#' + $(this).data('select')).focus();
            $('#x-' + $(this).data('select')).toggleClass('open');
            $('.option-list').not($(this).children('.option-list')).removeClass('open')
        });
        $('.option-list').on('click', '.option-item', function (event) {
            event.stopPropagation();
            var optionValue = $(this).data('optionValue');
            var select = $(this).parent('ul').data('select');
            $('#' + select).children('option').filter(function () {
                return $(this).val() == optionValue
            }).prop('selected', true);
            $('.custom-select').removeClass('ui-invalid-output');
            $('#op-sel-' + select).text($(this).text()).removeClass('placeholder');
            $('.option-list').removeClass('open')
        });
        $('html').on('click', function (event) {
            event.stopPropagation();
            if (event.target != $('.custon-select')) {
                $('.option-list').removeClass('open')
            }
        });
        $("#name").val(nombre);
        $("#last-name-paternal").val(paterno);
        $("#last-name-maternal").val(materno);
        $("#email").val(email);
        $("#phone").val(phone);
        $('#x-document-type').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == doctype
        }).trigger('click');
        $("#document-number").val(docnum);
        $("#address").val(address);
        $('#x-country').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == country
        }).trigger('click');
        $('#x-region').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == region
        }).trigger('click');
        $('#x-province').children('li.option-item').filter(function () {
            return $(this).data('optionValue') == province
        }).trigger('click')
        
    };
    $($vpos);
    </script>

    <%@ include file="../include/message.jspf"%>
  </c:otherwise>    
</c:choose>    
</body>
</html>