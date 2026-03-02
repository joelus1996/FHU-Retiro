var $cotejoSuper3 = function () {
    // all source code here

	  var run = {
     		 toJSON: function (data) {
     			return (data !== '') ? $.parseJSON($.trim(data)) : {}
     		 }
     		};
     var w = run.toJSON($('#jugadaCompletaSuperTres').val());
		
 	var bet1 ='';
 	var bet2 ='';
 	$.map(w,function(x){
 	bet1 = x.jugaA;
 	bet2 = x.jugadaB;
 	});
 	var a='';
 	var i=0,j=0,h=0,m=0;
 	
 	
 		$.map(w, function (e) {
			
 			$.map(e.datos_jugada, function (f) {
				$.map(f.datos_cotejo, function (r) {
				i=0;j=0;h=0;
 			a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+r.sorteo+'</span></span><span class="datos_enunciado_cotejo_left" >Fecha:  <span class="datos_enunciado_contenido_cotejo_left">'+r.fecha+'</span></span>';
 			a +='<div class="datos_separador"><span>..................................................................................................................................................................</span></div>';
 			a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+r.resultado+'</span></span>';
 			a +='<div class="datos_separador"><span>..................................................................................................................................................................</span></div>';
 			var b1='';
 			var b2='';
 			b1=r.tipo_jugada_A;
 			b2=r.tipo_jugada_B;
 			if(b1.length>0 && b1.length<0){
					a += '<div Style="margin-bottom:15px"><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right" Style="font-weight: normal";>Tipo de apuesta: '+r.tipo_jugada_A+' / Mulltiplicado por: '+r.multiplicador+'  </span></span></div></br>';
					a += '<div Style="margin-top: -30px;"><span class="cotejador" Style="margin-left:26px">Tus n&uacute;meros elegidos: </span><span class="cotejador">'+r.jugaA+'</span></span></div></br>';	
 				$.map(f.cotejo_jugadaA, function (p) {
 					i++;
 					a += '<div Style="margin-top: -20px;"><span class="indicador_cotejo"><b>['+i+']</b>  <span class="cotejador">'+p+'</span></span></div></br>';		
 				});
 			}else{
 				a += '<div Style="margin-bottom:15px"><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right" Style="font-weight: normal";>Tipo de apuesta: '+r.tipo_jugada_A+' / Mulltiplicado por: '+r.multiplicador+'  </span></span></div></br>';
					a += '<div Style="margin-top: -30px;"><span class="cotejador" Style="margin-left:26px">Tus n&uacute;meros elegidos: </span><span class="cotejador">'+r.jugaA+'</span></span></div></br>';
 				$.map(f.cotejo_jugadaA, function (q) {
 					j++;
 					a += '<div Style="margin-top: -20px;"><span class="indicador_cotejo"><b>['+j+']</b>  <span class="cotejador">'+q+'</span></span></div></br>';		
 				});
 				a += '<div Style="margin-bottom:15px;margin-top:-12px"><span class="datos_enunciado_cotejo_right">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right" Style="font-weight: normal";>Tipo de apuesta: '+r.tipo_jugada_B+' / Mulltiplicado por: '+r.multiplicador+'  </span></span></div></br>';
					a += '<div Style="margin-top: -30px;"><span class="cotejador" Style="margin-left:26px">Tus n&uacute;meros elegidos: </span><span class="cotejador">'+r.jugadaB+'</span></span></div></br>';
 				$.map(f.cotejo_jugadaB, function (s) {
 					h++;
 					a += '<div Style="margin-top: -20px;"><span class="indicador_cotejo"><b>['+h+']</b>  <span class="cotejador">'+s+'</span></span></div></br>';		
 				});
 			}
 		


 				 a +='<div class="datos_separador"><span>..................................................................................................................................................................</span></div>';
 			});
				});
 			});
 	
 		a+='<div class="calculo_premio">';
			a+='<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/fechaza/ico-calculo-premios.gif"></span><span><b> C&aacute;lculo de premios:</b></span><span class="cont_calculo"> N&deg; de jugadas Ganadoras x Premio por apuesta (S/.) x Multiplicador</span></div>';
			a+='<span style="margin-bottom: 10px"></span>';
			a+='<table align="center" border="1" cellspacing="0" class="table_superTres">';
			a+='<th class="th_superTres"><span class="th_superTres"><b>Jugada</b></span></th>';
			a+='<th class="th_superTres"><span class="th_superTres"><b>Tipo de Apuesta</b></span></th>';
			a+='<th class="th_superTres"><span class="th_superTres"><b>N&ordm; de jugadas Ganadoras</b></span></th>';
			a+='<th class="th_superTres"><span class="th_superTres"><b>Premio por apuesta</b></span></th>';
			a+='<th class="th_superTres"><span class="th_superTres"><b>Multiplicado por</b></span></th>';
			a+='<th class="th_superTres"><span class="th_superTres"><b>Premio Total</b></span></th>';
			a+='<th class="th_superTres"><span class="th_superTres"><b>Caduca</b></span></th>';
			
 		$.map(w,function(k){
			
 			$.map(k.resultado_jugada, function (p, i) {
 				$.map(p.datos_total_cotejo, function (z) {
						a+='<tr>';
						a+='<td class="td_superTres"><c:out value=""/>'+z.jugada+'</td>';
						a+='<td class="td_superTres"><c:out value="" />'+z.tipo_jugada+'</td>';
						a+='<td class="td_superTres"><c:out value="" />'+z.aciertos+'</td>';
						a+='<td class="td_superTres"><c:out value="" />'+z.premio_apuesta+'</td>';
						a+='<td class="td_superTres"><c:out value=""/>'+z.multiplicacion+'</td>';
						a+='<td class="td_superTres"><c:out value="" />'+z.premio_total+'</td>';
						a+='<td class="td_superTres"><c:out value="" />'+z.expira+'</td>';
						a+='</tr>';    		
 				});
													
						 
				});
				
					$.map(k.premio_tot, function (p, i) {
					a+='<th colspan="8" class="table_result_superTres"><b>  <span Style="margin-left:239px">Ganastes en Efectivo (S/.)*</span><span style="margin:18px">'+p.premio+'</span> </b></th>';	
				});
 		});
					//a+='<th colspan="8" class="table_result_fechaza"><b>  <span Style="margin-left:446px">Ganastes en Efectivo (S/.)*</span><span style="margin:18px">'+p.premioTotal+'</span> </b></th>';	
					a+='</table>';   
					a+='<div style="margin: 10px;"></div>';
					a+='<span class="mensaje_superTres" Style="margin-top="4px";">*Todos los premios estar&aacute;n afectos al 10% de descuento por concepto de impuestos y deducciones de ley municipal.Excepto el premio</span><br/>';
					a+='<span class="mensaje_superTres" Style="margin-top="4px";">m&iacute;nimode 2 soles, que no ser&aacute;n afectados por dicho impuesto para el cliente, y que La Tinka pagar&aacute; el impuesto</span><br/>';
					a+='<div style="margin: 10px;"></div>';		
     $("#valor").html(a);

};
$($cotejoSuper3);