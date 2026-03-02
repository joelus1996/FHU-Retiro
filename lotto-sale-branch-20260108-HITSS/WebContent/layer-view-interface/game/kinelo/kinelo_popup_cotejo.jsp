<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Google Tag Manager -->
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'https://www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-PWF5XVX');</script>
<!-- End Google Tag Manager -->

<meta name="viewport" content="width=1024">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link media="screen" rel="stylesheet" type="text/css" href="layer-view-style/game/kinelo/themeKinelo.css">
<script language="javascript" type="text/javascript" src="js/jquery-3.6.3.min.js"></script>
<title>Insert title here</title>
<link rel="shortcut icon" href="layer-view-image/common/favicon.ico?v=4">	

</head>
<body>
<!-- Google Tag Manager (noscript) -->
<noscript><iframe src="https://www.googletagmanager.com/ns.html?id=GTM-PWF5XVX"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<!-- End Google Tag Manager (noscript) -->

<br/>
<div class="logo_kinelo">
<img alt="Kinelo" title="Kinelo" src="layer-view-image/game/kinelo/premios-logo-kinelo.jpg">
</div>
<br/>
      <c:forEach items="${ListJugada}" var="lista">
      <span class="datos_enunciado_cotejo_right"><b>Nro de Sorteo:   </b>
      <span class="datos_enunciado_contenido_cotejo_right"><b>${lista.sorteo_jugada}</b></span></span>
      <span class="datos_enunciado_cotejo_right"><b>Fecha:  </b>
      <span class="datos_enunciado_contenido_cotejo_right"><b>${lista.fecha_jugada}</b></span></span>
	  <span class="datos_enunciado_cotejo_right"><b>Hora:  </b>
	  <span class="datos_enunciado_contenido_cotejo_right"><b>${lista.hora_jugada}</b></span></span>
	  
      <div class="datos_separador">
      <span><b>..........................................................................................................................................</b></span></div>
	
      <div class="datos_enunciado_cotejo_right">
	  <span><b>Resultado del Sorteo : </b><span style="color: #454545;"><b>${lista.resultado}</b></span></span></div>

	  <div class="datos_separador">
      <span><b>..........................................................................................................................................</b></span></div>

		<c:if test="${ctbm1>2 && ctbm2<6}">
		<div class="datos_enunciado_cotejo_right">
		<span><b>Jugada A : </b></span><span class="datos_enunciado_cotejo_left">Tipo de apuesta: ${lista.tipo_jugada_A} / Multiplica por: ${lista.multiplicador_A}</span></div>
		<div class="cotejadores">
		<span>Tus n&uacute;meros elegidos son : </span>${lista.jugada_completa_A}<span></span></div>

	    <div class="datos_separador">
	    <span><b>..........................................................................................................................................</b></span></div>
		
		<div class="calculo_premio">
		<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/kinelo/ico-calculo-premios.gif"></span><span><b> Calculo de Premios:</b></span> <span style="color: #454545">Costo(S/.) x Multiplicador x Factor base. </span></div>
		<span style="margin-bottom: 10px"></span>	
	     <table align="center" border="1" cellspacing="0" class="table_kinelo">
	      <th class="th_kinelo"><b>Jugada</b></th>
	      <th class="th_kinelo"><b>Tipo de Apuesta</b></th>
	      <th class="th_kinelo"><b>Aciertos</b></th>
	      <th class="th_kinelo"><b>Costo(S/.)</b></th>
	      <th class="th_kinelo"><b>Multiplicador</b></th>
	      <th class="th_kinelo"><b>Factor Base *</b></th>
	      <th class="th_kinelo"><b>Total(S/.)</b></th>
     
        <tr>
          <td class="td_kinelo"><c:out value="${lista.jugada_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.tipo_jugada_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.aciertos_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.costo_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.multiplicador_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.f_base_A}" /></td>
         <td class="td_kinelo"><c:out value="${lista.total_A}" /></td>
        </tr>
    
      <th colspan="7" class="table_result_kinelo"><b><span style="margin-left:310px">Ganastes en Efectivo (S/.)*</span><span style="margin:10px"> </span>   ${lista.efectivo_A}</b></th>
    </table>

</c:if>
<c:if test="${ctbm2>6}">
	<div class="datos_enunciado_cotejo_right">
	<span><b>Jugada A : </b></span><span class="datos_enunciado_cotejo_left">Tipo de apuesta: ${lista.tipo_jugada_A} / Multiplica por: ${lista.multiplicador_A}</span></div>
	<div class="cotejadores">
	<span>Tus n&uacute;meros elegidos son : </span>${lista.jugada_completa_A}<span></span></div>
	<div class="datos_enunciado_cotejo_right">
	<span><b>Jugada B : </b></span><span class="datos_enunciado_cotejo_left">Tipo de apuesta: ${lista.tipo_jugada_B} / Multiplica por: ${lista.multiplicador_B}</span></div>
	<div class="cotejadores">
	<span>Tus n&uacute;meros elegidos son : </span>${lista.jugada_completa_B}<span></span></div>
	<div class="datos_separador">
    <span><b>..........................................................................................................................................</b></span></div>
	<div class="calculo_premio">
	<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/kinelo/ico-calculo-premios.gif"></span><span><b> Calculo de Premios:</b></span> <span style="color: #454545">Costo(S/.) x Multiplicador x Factor base. </span></div>
	<span style="margin-bottom: 10px"></span>	
   	<table align="center" border="1" cellspacing="0" class="table_kinelo">
	      <th class="th_kinelo"><b>Jugada</b></th>
	      <th class="th_kinelo"><b>Tipo de Apuesta</b></th>
	      <th class="th_kinelo"><b>Aciertos</b></th>
	      <th class="th_kinelo"><b>Costo(S/.)</b></th>
	      <th class="th_kinelo"><b>Multiplicador</b></th>
	      <th class="th_kinelo"><b>Factor Base *</b></th>
	      <th class="th_kinelo"><b>Total(S/.)</b></th>
     
        <tr>
          <td class="td_kinelo"><c:out value="${lista.jugada_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.tipo_jugada_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.aciertos_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.costo_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.multiplicador_A}" /></td>
          <td class="td_kinelo"><c:out value="${lista.f_base_A}" /></td>
         <td class="td_kinelo"><c:out value="${lista.total_A}" /></td>
        </tr>
         <tr>
          <td class="td_kinelo"><c:out value="${lista.jugada_B}" /></td>
          <td class="td_kinelo"><c:out value="${lista.tipo_jugada_B}" /></td>
          <td class="td_kinelo"><c:out value="${lista.aciertos_B}" /></td>
          <td class="td_kinelo"><c:out value="${lista.costo_B}" /></td>
          <td class="td_kinelo"><c:out value="${lista.multiplicador_B}" /></td>
         <td  class="td_kinelo"><c:out value="${lista.f_base_B}" /></td>
         <td  class="td_kinelo"><c:out value="${lista.total_B}" /></td>
        </tr>
    
      <th colspan="7" class="table_result_kinelo"><b>  <span style="margin-left:310px">Ganastes en Efectivo (S/.)*</span><span style="margin:10px"> </span>   ${lista.efectivo_total}</b></th>
    </table>

</c:if>

	 <div class="mensaje_kinelo">
	<span>*<u>Factor base:</u> los números no son cantidades en soles; son premios entregados por cada S/. 1 apostado.</span><br/>
	<span>** Todos los premios estarán afectos al 10% por concepto de impuestos y deducciones de ley municipal.La única</span><br/>
	<span>excepción será para los premios cuyo total corresponda exactamente a la cantidad de una(1) apuesta m&iacute;nima, en cuyo </span><br/>
	<span>caso INTRALOT asumirá el costo de éstos impuestos y entregará el premio neto de S/.1 al jugador.</span><br/>
	</div>
	<div class="datos_separador">
    <span><b>..........................................................................................................................................</b></span></div>

</c:forEach>
<!--  <div style="margin-top: 10px">
<span style="margin-left: 55px;"><span style="font-family: Arial;font-size: 15px;color: #E0732B;"><b>Resultado :   </b></span></span><br/>
<span style="margin-left: 55px;"><span style="font-family: Arial;font-size: 15px;color: black;margin-top: 10px;"><span style="color: #E0732B;">Total Ganado :  </span><b>S/. ${resultado}</b> </span></span><br/>
</div>
-->

</body>
</html>