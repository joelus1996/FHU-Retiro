var $cotejoFechaza = function () {
    // all source code here

	var run = {
			 toJSON: function (data) {
				return (data !== '') ? $.parseJSON($.trim(data)) : {}
			 }
			};
	
	var w = run.toJSON($('#jugadaCompletaFechaza').val());
	
	var bet1 ='';
	var bet2 ='';
	var bet3 ='';
	var bet4 ='';
	$.map(w,function(x){
	bet1 = x.bet1;
	
	});
	var gameA = '';
	var gameB = '';
	var gameC = '';
	var gameD = '';
	var a='';
	var i=0,j=0,h=0,m=0;
		$.map(w, function (e) {
			$.map(e.datos_jugada, function (f) {
			i=0;
			a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:  <span Style="color:#454545;">'+f.sorteo+'</span></span><span class="datos_enunciado_cotejo_right" >Fecha:  <span Style="color:#454545;">'+f.fecha+'</span></span> <span class="datos_enunciado_cotejo_right" >Hora:  <span Style="color:#454545;">'+f.hora+'</span></span>';
			a +='<div class="datos_separador"><span>..................................................................................................................................................................</span></div>';
			a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.resultado+'</span></span>';
			a +='<div class="datos_separador"><span>..................................................................................................................................................................</span></div>';
			a += '<div Style="margin-bottom:15px"><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right" Style="font-weight: normal";>Tipo de apuesta: '+f.jugadaA+' / Mulltiplicado por: '+f.multiplicador+'  </span></span></div></br>';
			$.map(f.cotejo_jugada, function (c) {
				i++;
				a += '<div ><span class="cotejador" Style="margin-top:-30px;">'+c+'</span></span></div></br>';	
				 });

				 a +='<div class="datos_separador" Style="margin-top:-18px"><span>..................................................................................................................................................................</span></div>';
			});
			
			});
		
		a+='<div class="calculo_premio">';
		a+='<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/fechaza/ico-calculo-premios.gif"></span><span><b> C&aacute;lculo de premios:</b></span><span class="cont_calculo"> Factor de premio x Costo(S/.) apuesta m&iacute;nima x Multiplicador</span></div>';
		a+='<span style="margin-bottom: 10px"></span>';
		a+='<table align="center" border="1" cellspacing="0" class="table_fechaza">';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>Jugada</b></span></th>';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>N&ordm; de jugadas Ganadoras</b></span></th>';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>Tipo de Apuesta</b></span></th>';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>Aciertos</b></span></th>';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>Factor de premio ("x" veces tu apuesta)</b></span></th>';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>Costo (S/.) Apuesta m&iacute;nima</b></span></th>';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>Multiplicador</b></span></th>';
		a+='<th class="th_fechaza"><span class="th_fechaza"><b>Premio en S/.</b></span></th>';
		
		$.map(w,function(k){
			$.map(k.resultado_jugada, function (t) {
				$.map(t.acierto_jugada, function (r) {
		a+='<tr>';
		a+='<td class="td_fechaza"><c:out value=""/>'+r.A+'</td>';
		a+='<td class="td_fechaza"><c:out value="" />'+r.acierto+'</td>';
		a+='<td class="td_fechaza"><c:out value="" />'+r.tipo_A+'</td>';
		a+='<td class="td_fechaza"><c:out value="" />'+r.jugada+'</td>';
		a+='<td class="td_fechaza"><c:out value=""/>'+r.factor+'</td>';
		a+='<td class="td_fechaza"><c:out value="" />'+r.apuesta+'</td>';
		a+='<td class="td_fechaza"><c:out value="" />'+r.multiplicador+'</td>';
		a+='<td class="td_fechaza"><c:out value="" />'+r.premio+'</td>';
		a+='</tr>';
				});
		a+='<th colspan="8" class="table_result_fechaza"><b>  <span Style="margin-left:446px">Ganastes en Efectivo (S/.)*</span><span style="margin:18px">'+t.totalPremio+'</span> </b></th>';
		a+='</table>';
		a+='<div style="margin: 10px;"></div>';
		a+='<span class="mensaje_fechaza" Style="margin-top="4px";">*Todos los premios estar&aacute;n afectos al 10% de descuento por concepto de impuestos y deducciones de ley municipal.</span><br/>';
		a+='<div style="margin: 10px;"></div>';
				
				});
		});
		$("#valor").html(a);

};
$($cotejoFechaza);