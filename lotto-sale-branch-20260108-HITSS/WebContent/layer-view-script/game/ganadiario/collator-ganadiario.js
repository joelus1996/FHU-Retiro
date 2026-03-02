var $cotejoGanadiario = function () {
    // all source code here

	var run = {
			 toJSON: function (data) {
				return (data !== '') ? $.parseJSON($.trim(data)) : {}
			 }
			};

			var w = run.toJSON($('#jugadaCompletaGanadiario').val());
			var bet1 ='';
			var bet2 ='';
			var bet3 ='';
			var bet4 ='';
			$.map(w,function(x){
			bet1 = x.bet1;
			bet2 = x.bet2;
			bet3 = x.bet3;
			bet4 = x.bet4;
			});
			var gameA = '';
			var gameB = '';
			var gameC = '';
			var gameD = '';
			var a='';
			var i=0,j=0,h=0,m=0;
			if((bet1>2)&&(bet2<6)&&(bet3<6)&&(bet4<6)){
				$.map(w, function (e) {
					$.map(e.datos_jugada_A, function (f) {
					i=0;
					a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.sorteo+'</span></span><span class="datos_enunciado_cotejo_left" >Fecha:  <span class="datos_enunciado_contenido_cotejo_left">'+f.fecha+'</span></span>';
					a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
					a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.resultado+'</span></span>';
					a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
					a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaA+'</span></span></div></br>';
					$.map(f.cotejo_jugada_A, function (c) {
						i++;
						a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>['+i+']</b>  <span class="cotejador">'+c+'</span></span></div></br>';	
						 });
						 a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
					});
					});
				}else if((bet1>2)&&(bet2>6)&&(bet3<6)&&(bet4<6)){
					$.map(w, function (e) {
					
				$.map(e.datos_jugada_B, function (f) {
				
				i=0;j=0;
				a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.sorteo+'</span></span><span class="datos_enunciado_cotejo_left">Fecha:  <span class="datos_enunciado_contenido_cotejo_left">'+f.fecha+'</span></span>';
				a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
				a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.resultado+'</span></span>';
				a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
				a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaA+'</span></span></div></br>';
				$.map(f.cotejo_jugada_A, function (c) {
					i++;
					a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>['+i+']</b>  <span class="cotejador">'+c+'</span></span></div></br>';	
					 });
				a += '<div"><span class="datos_enunciado_cotejo_right">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaB+'</span></span></div></br>';
				$.map(f.cotejo_jugada_B, function (d) {
					j++;
					a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>['+j+']</b>  <span class="cotejador">'+d+'</span></span></div></br>';	
					 });
					 a +='<div class="datos_separador"  Style="margin-top: -8px;"><span>..........................................................................................................................................</span></div>';
				 });
				});
				
				}else if((bet1>2)&&(bet2>6)&&(bet3>6)&&(bet4<6)){
					$.map(w, function (e) {
						$.map(e.datos_jugada_C, function (f) {
						i=0;j=0,h=0;
						a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.sorteo+'</span></span><span class="datos_enunciado_cotejo_left" ">Fecha:  <span class="datos_enunciado_contenido_cotejo_left">'+f.fecha+'</span></span>';
						a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
						a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.resultado+'</span></span>';
						a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
						a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaA+'</span></span></div></br>';
						$.map(f.cotejo_jugada_A, function (c) {
							i++;
							a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>['+i+']</b>  <span class="cotejador">'+c+'</span></span></div></br>';	
							 });
						a += '<div><span class="datos_enunciado_cotejo_right" Style="margin-top: -10px;">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaB+'</span></span></div></br>';
						$.map(f.cotejo_jugada_B, function (d) {
							j++;
							a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>['+j+']</b>  <span class="cotejador">'+d+'</span></span></div></br>';	
							 });
						a += '<div"><span class="datos_enunciado_cotejo_right">Jugada C:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaC+'</span></span></div></br>';
						$.map(f.cotejo_jugada_C, function (e) {
							h++;
							a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>['+h+']</b>  <span class="cotejador">'+e+'</span></span></div></br>';	
							 });
							 a +='<div class="datos_separador"  Style="margin-top: -8px;"><span>..........................................................................................................................................</span></div>';
						 });
						});
				
				}

				else if((bet1>2)&&(bet2>6)&&(bet3>6)&&(bet4>6)){
					$.map(w, function (e) {
						$.map(e.datos_jugada_D, function (f) {
						i=0;j=0;h=0;m=0;
						a += '<span class="datos_enunciado_cotejo_right">Nro de Sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.sorteo+'</span></span><span class="datos_enunciado_cotejo_left">Fecha:  <span class="datos_enunciado_contenido_cotejo_left">'+f.fecha+'</span></span>';
						a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
						a += '<span class="datos_enunciado_cotejo_right">Resultado del sorteo:   <span class="datos_enunciado_contenido_cotejo_right">'+f.resultado+'</span></span>';
						a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
						a += '<div><span class="datos_enunciado_cotejo_right">Jugada A:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaA+'</span></span></div></br>';
						$.map(f.cotejo_jugada_A, function (c) {
							i++;
							a += '<div Style="margin-top: -10px;"><span class="indicador_cotejo"><b>['+i+']</b>  <span class="cotejador">'+c+'</span></span></div></br>';	
							 });
						a += '<div><span class="datos_enunciado_cotejo_right" Style="margin-top: -10px;">Jugada B:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaB+'</span></span></div></br>';
						$.map(f.cotejo_jugada_B, function (d) {
							j++;
							a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>['+j+']</b>  <span class="cotejador">'+d+'</span></span></div></br>';	
							 });
						a += '<div><span class="datos_enunciado_cotejo_right">Jugada C:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaC+'</span></span></div></br>';
						$.map(f.cotejo_jugada_C, function (e) {
							h++;
							a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>['+h+']</b>  <span class="cotejador">'+e+'</span></span></div></br>';	
							 });
						a += '<div><span class="datos_enunciado_cotejo_right">Jugada D:   <span class="datos_enunciado_contenido_cotejo_right">'+f.jugadaD+'</span></span></div></br>';
						$.map(f.cotejo_jugada_D, function (g) {
							m++;
							a += '<div Style="margin-top: -8px;"><span class="indicador_cotejo"><b>['+m+']</b>  <span class="cotejador">'+g+'</span></span></div></br>';	
							});
							a +='<div class="datos_separador"><span>..........................................................................................................................................</span></div>';
						 });
						});
						
				}
			$.map(w,function(k){
				$.map(k.resultado_jugada, function (t) {
						a+='<div class="calculo_premio">';
						a+='<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/ganadiario/ico-calculo-premios.gif"></span><span><b> Calculo de premio total:</b></span></div>';
						a+='<span style="margin-bottom: 10px"></span>';
						a+='<table align="center" border="1" cellspacing="0" class="table_ganadiario">';
						a+='<th class="th_ganadiario"><span class="th_ganadiario"><b>Tus Aciertos</b></span></th>';
						a+='<th class="th_ganadiario"><span class="th_ganadiario"><b>N&ordm; de jugadas Ganadoras</b></span></th>';
						a+='<th class="th_ganadiario"><span class="th_ganadiario"><b>Premio Total</b></span></th>';
						a+='<th class="th_ganadiario"><span class="th_ganadiario"><b>Caduca</b></span></th>';
						 
						if(t.dos>0){
						a+='<tr>';
						a+='<td class="td_ganadiario"><c:out value=""/>'+t.acierto_dos+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.dos+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.premio_total_dos+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.caduca_dos+'</td>';
						a+='</tr>';
						} 
						if(t.tres>0){
						a+='<tr>';
						a+='<td class="td_ganadiario"><c:out value=""/>'+t.acierto_tres+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.tres+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.premio_total_tres+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.caduca_tres+'</td>';
						a+='</tr>';
						}
						if(t.cuatro>0){
						a+='<tr>';
						a+='<td class="td_ganadiario"><c:out value=""/>'+t.acierto_cuatro+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.cuatro+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.premio_total_cuatro+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.caduca_cuatro+'</td>';
						a+='</tr>';
						}
						if(t.cinco>0){
						a+='<tr>';
						a+='<td class="td_ganadiario"><c:out value=""/>'+t.acierto_cinco+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.cinco+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.premio_total_cinco+'</td>';
						a+='<td class="td_ganadiario"><c:out value="" />'+t.caduca_cinco+'</td>';
						a+='</tr>';
						}	
						
						a+='<th colspan="7" class="table_result_ganadiario"><b>  <span>Ganastes en Efectivo (S/.)*</span><span style="margin:10px">'+t.totalPremio+'</span> </b></th>';
						a+='</table>';
						a+='<div style="margin: 10px;"></div>';
						a+='<span class="mensaje_ganadiario" Style="margin-top="4px";">*Todos los premios estar&aacute;n afectos al 10% de descuento por concepto de impuestos y deducciones de ley municipal.</span><br/>';
						a+='<div style="margin: 10px;"></div>';
				});
				});
				$("#valor").html(a);	

};
$($cotejoGanadiario);