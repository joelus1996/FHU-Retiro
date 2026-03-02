;
var $cotejoTeApuesto = function () {
    var run = {
        toJSON: function (data) {
            return (data !== '') ? $.parseJSON($.trim(data)) : {}
        }
    };
    var w = run.toJSON($('#jugadaCompletaTeApuesto').val());
    var gameA = '';
    var gameB = '';
    var gameC = '';
    var gameD = '';
    var a = '';
    var i = 0,
        j = 0,
        h = 0,
        m = 0;
    $.map(w, function (k) {
        $.map(k.resultado_tabla, function (t) {
            a += '<div class="calculo_premio">';
            a += '<span><img alt="calculo premio" title="calculo premio" src="layer-view-image/game/fechaza/ico-calculo-premios.gif"></span><span><b> C&aacute;lculo de premios:</b></span><span Style="color:#454545">  Partidos elegidos ' + t.numero_jugada + '/ Combinadas :' + t.tipo_combinaciones + ' => Aciertos ' + t.aciertos + '</span></div>'
        })
    });
    $.map(w, function (k) {
        $.map(k.datos_jugada, function (t) {
            a += '<div class="calculo_premio" Style="color:#f3771f"><span><b> Combinada ' + t.combinada + ':</b></span><span Style="color:#454545">  ' + t.acierto + '</span></div>';
            a += '<span style="margin-bottom: 10px"></span>';
            a += '<table align="center" border="1" cellspacing="0" class="table_teapuesto">';
            a += '<th class="th_teapuesto" Style="width:40px"><span class="th_fechaza"><b>Cod.</b></span></th>';
            a += '<th class="th_teapuesto" Style="width:80px"><span class="th_fechaza"><b>Fecha de partido</b></span></th>';
            a += '<th class="th_teapuesto" Style="width:300px"><span class="th_fechaza"><b>Partido</b></span></th>';
            a += '<th class="th_teapuesto" Style="width:70px"><span class="th_fechaza"><b>Probabilidad</b></span></th>';
            a += '<th class="th_teapuesto" Style="width:50px"><span class="th_fechaza"><b>Jugada</b></span></th>';
            a += '<th class="th_teapuesto" Style="width:50px"><span class="th_fechaza"><b>Resultado</b></span></th>';
            $.map(t.acierto_jugada, function (r) {
                a += '<tr>';
                a += '<td class="td_teapuesto"><c:out value=""/>' + r.ticket + '</td>';
                a += '<td class="td_teapuesto"><c:out value="" />12/02/2013</td>';
                a += '<td class="td_teapuesto"><c:out value="" />' + r.partido + '</td>';
                a += '<td class="td_teapuesto"><c:out value="" />' + r.factor + '</td>';
                a += '<td class="td_teapuesto"><c:out value=""/>' + r.apuesta + '</td>';
                a += '<td class="td_teapuesto"><c:out value="" />' + r.resultado + '</td>';
                a += '</tr>'
            });
            a += '</table>';
            a += '<div style="margin: 10px;"></div>'
        })
    });
    $.map(w, function (k) {
        $.map(k.resultado_tabla, function (t) {
            a += '<table frame="border" align="center" Style="background:#4a4b4f;color:white" class="table_teapuesto">';
            a += '<tr>';
            a += '<td><span Style="margin-left:10px"><b>Probabilidades ganadas : ' + t.probabilidades_ganadas + '</b></span></td>';
            a += '</tr>';
            a += '<tr>';
            a += '<td><span Style="margin-left:10px"><b>Multiplicador : ' + t.multiplicador + '</b></span></td>';
            a += '</tr>';
            a += '<tr>';
            a += '<td><span Style="margin-left:10px"><b>Ganastes en efectivo (S/.) : ' + t.premio + '</b></span></td>';
            a += '</tr>';
            a += '</table>'
        })
    });
    $("#valor").html(a)
};
$($cotejoTeApuesto);