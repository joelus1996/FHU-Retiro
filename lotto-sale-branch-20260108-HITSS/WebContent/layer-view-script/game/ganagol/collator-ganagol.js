var $cotejoGanagol = function () {
    // all source code here

	var run = {
			 toJSON: function (data) {
				return (data !== '') ? $.parseJSON($.trim(data)) : {}
			 }
			};
	
	var w = run.toJSON($('#jugadaCompletaGanagol').val());
	
	var bet1 ='';
	var bet2 ='';
	var bet3 ='';
	var bet4 ='';
	$.map(w,function(x){
	bet1 = x.ctbM1;
	bet2 = x.ctbM2;
	bet3 = x.ctbM3;
	bet4 = x.ctbM4;
	});
	
	var a='';
	var i=0,j=0,h=0,m=0;
		$.map(w, function (e) {
			$.map(e.datos_jugada, function (f) {
			i=0;j=0;h=0;m=0;
			a += '<span class="datos_enunciado_cotejo_right">Programa:  <span Style="color:#454545;">'+f.num_sorteo+'</span></span><span class="datos_enunciado_cotejo_right" >Fecha:  <span Style="color:#454545;">'+f.fecha+'</span></span>';
			a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
			a += '<span class="datos_enunciado_cotejo_right">Resultado del programa:   <span class="datos_enunciado_contenido_cotejo_right">'+f.resultados+'</span></span>';
			a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
		
			
			if(bet1>2){
				a += '<div Style="margin-bottom:15px"><span class="datos_enunciado_cotejo_right">Jugada 1: '+f.ctbM1+'</span></div></br>';
				
				$.map(f.cotejo_jugadaA, function (c) {
					i++;
					a += '<div ><span class="cotejador" Style="margin-top:-30px;">['+i+'] '+c+'</span></span></div></br>';	
					 });
			}if(bet2>6){
				a += '<div Style="margin-bottom:15px;margin-top:-25px"><span class="datos_enunciado_cotejo_right">Jugada 2: '+f.ctbM2+'</span></div></br>';
				$.map(f.cotejo_jugadaB, function (p) {
					j++;
					a += '<div ><span class="cotejador" Style="margin-top:-25px;">['+j+'] '+p+'</span></span></div></br>';	
					 });
			}if(bet3>6){
				a += '<div Style="margin-bottom:15px;margin-top:-25px"><span class="datos_enunciado_cotejo_right">Jugada 3: '+f.ctbM3+'</span></div></br>';
				$.map(f.cotejo_jugadaC, function (r) {
					h++;
					a += '<div ><span class="cotejador" Style="margin-top:-30px;">['+h+'] '+r+'</span></span></div></br>';	
					 });
			}if(bet4>6){
				a += '<div Style="margin-bottom:15px;margin-top:-25px"><span class="datos_enunciado_cotejo_right">Jugada 4: '+f.ctbM4+'</span></div></br>';
				$.map(f.cotejo_jugadaD, function (q) {
					m++;
					a += '<div ><span class="cotejador" Style="margin-top:-30px;">['+m+'] '+q+'</span></span></div></br>';	
					 });
			}
		
				 a +='<div class="datos_separador" Style="margin-top:-18px"><span>..........................................................................................................................................</span></div>';
			});
			
			});
			
			
			a+='<div class="calculo_premio">';
			a+='<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/fechaza/ico-calculo-premios.gif"></span><span><b> C&aacute;lculo de premio total:</b></span></div>';
			a+='<span style="margin-bottom: 10px"></span>';
			a+='<table align="center" border="1" cellspacing="0" class="table_ganagol">';
			a+='<th class="th_ganagol"><span class="th_ganagol"><b>Tus aciertos</b></span></th>';
			a+='<th class="th_ganagol"><span class="th_ganagol"><b>N&ordm; de jugadas Ganadoras</b></span></th>';
			a+='<th class="th_ganagol"><span class="th_ganagol"><b>Caduca</b></span></th>';
		
		
		
       		$.map(w,function(k){
				
       			$.map(k.tabla_datos, function (n) {
       				$.map(n.cotejo_jugada, function (z) {
							a+='<tr>';
							a+='<td class="td_ganagol"><c:out value=""/>'+z.aciertos+'</td>';
							a+='<td class="td_ganagol"><c:out value="" />'+z.total_aciertos+'</td>';
							a+='<td class="td_ganagol"><c:out value="" />'+z.caduca+'</td>';
							a+='</tr>';    		
       				});
														
							 
					});
					
						$.map(k.premio_tot, function (g) {
						a+='<th colspan="8" class="table_result_ganagol"><b>  <span Style="margin-left:160px">Ganastes en Efectivo (S/.)*</span><span style="margin:18px">'+g.premio+'</span> </b></th>';	
					});
       		});
						//a+='<th colspan="8" class="table_result_fechaza"><b>  <span Style="margin-left:446px">Ganastes en Efectivo (S/.)*</span><span style="margin:18px">'+p.premioTotal+'</span> </b></th>';	
						a+='</table>';   
						a+='<div style="margin: 10px;"></div>';
						a+='<span class="mensaje_ganagol" Style="margin-top="4px";">*Todos los premios estar&aacute;n afectos al 10% de descuento por concepto de impuestos y deducciones de ley municipal.</span><br/>';
						a+='<span class="mensaje_ganagol" Style="margin-top="4px";">Excepto el premio m&iacute;nimode 2 soles, que no ser&aacute;n afectados por dicho impuesto para el cliente, y que La Tinka pagar&aacute; el impuesto</span><br/>';
						a+='<span class="mensaje_ganagol" Style="margin-top="4px";"></span><br/>';
						a+='<div style="margin: 10px;"></div>';	
			
		$("#valor").html(a);

};
$($cotejoGanagol);