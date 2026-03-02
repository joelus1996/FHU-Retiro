;
var TeApuesto = {};
var gameItems = [];
var specialItems = [];
var winningAmount = 0;
var totalBets = 0;
var multiplier = 1;
var aCombinations = [];
var simpleBetPrice = 0;
var fullAmount = 0;
var costoTotalBet = 0;
var teApuestoJson = [];
var nteApuestoJson = [];
var teApuestoPlay = '';
var config = {
    maxGame: 30,
    maxMultiplier: 3
};
var create = {
    programButton: function (a, b) {
        return '<input type="button" class="btn-program" value="' + a + '" data-date="' + b + '">'
    },
    sportButton: function (a, b, c) {
        return '<button class="btn-sport" value="' + a + '">' + c + '<span class="btn-content">' + b + '</span>' + '</button>'
    },
    row: function (a) {
        return '<li class="row">' + a + '</li>'
    },
    list: function (a) {
        return '<ul class="list">' + a + '</li>'
    },
    customCell: function (a, b) {
        return '<div class="cell' + ' ' + run.validate(b) + '">' + run.validate(a) + '</div>'
    },
    optionCell: function (a, b) {
        return '<div class="cell op' + ((run.validate(b) === '') ? '' : ' ' + b) + '">' + run.validate(a) + '</div>'
    },
    iconBox: function (a, b) {
        return '<span class="icon' + ' ' + run.validate(a) + ' ' + run.validate(b) + '" title="' + run.validate(b) + '">' + run.validate(b) + '</span>'
    },
    gameItemTag: function (a, b) {
        return "<span data-game-item='" + b + "' class='" + ((a === '-') ? 'no-game' : 'game') + "'>" + a + "</span>"
    },
    exactGolTag: function (a, b) {
        return (a === '-') ? '' : "<span data-title='Juégalo también como Marcador Exacto' data-exact-goal='" + b + "' class='icon sA" + ((a === '-') ? '' : ' ' + a) + "'>" + a + "</span>"
    },
    tooltip: function (a) {
        return '<div class="tooltip">' + a + '</div>'
    },
    dataAttributeGame: function (a, b, c, d, e, f) {
        return (e === '-') ? '{}' : '{"drawId":' + a + ',"eventId":' + b + ',"minimun":' + c + ',"type":"' + d + '","probability":' + e + ',"tab":' + f + '}'
    },
    dataAttributeExactGoal: function (a, b, c) {
        return (a === '-') ? '{}' : '{"drawId":' + b + ',"eventId":' + c + '}'
    },
    dataAttirbuteUniqueGame: function (a, b, c, d) {
        return '{"drawId":' + a + ',"eventId":' + b + ',"hour":"' + c + '","date":"' + d + '"}'
    },
    dataAttributeSpecialGame: function (a, b, c, d, e, f) {
        return (e === '-') ? '{}' : '{"groupCode":"' + a + '","itemCode":' + b + ',"minimun":' + c + ',"probability":' + e + ',"tab":' + f + ',"itemDescription":"' + d + '"}'
    }
};
var run = {
    prepareGame: function () {
        TeApuesto = run.toJSON($('#b5435566a27c88b4745c39e0b3d91da7').val());
        run.cleanUpTheMess();
        simpleBetPrice = parseInt(TeApuesto.BetData.simpleBetPrice)
    },
    setup: function () {
        $('#back_previous').remove();
        $('#menu-item-2').addClass('current-menu-item');
        $('#loading').remove();
        $('.bottom-bar').delay(200).fadeIn();
        $('#menu').find('.tab a').eq(0).trigger('click');
        $('#section-programs').children('.btn-program').eq(0).trigger('click');
        $('#special-bets-header').children('.btn-sport').eq(0).trigger('click');
        $('#special-bets-menu').children('ul').eq(0).children('li.menu-item').eq(0).trigger('click');
        $('#field-price-message').text(TeApuesto.BetData.priceMessage);
        $('#field-balance-amount').text(TeApuesto.BetData.balanceAmount);
        $('#saldo-promocional').text((parseInt(TeApuesto.BetData.balanceAmountGame) === 0) ? '' : ' ' + 'ó de mi saldo promocional S/.' + TeApuesto.BetData.balanceAmountGame)
    },
    resetGame: function () {
        gameItems = [];
        specialItems = [];
        winningAmount = 0;
        totalBets = 0;
        multiplier = 1;
        aCombinations = [];
        $('.game, .btn-multiplier, .btn-combined').removeClass('on');
        $('#bet-result').text('');
        run.invisibleToggle($('#field-multiplier'), 0);
        run.invisibleToggle($('#field-combined'), 0);
        run.calculateWinningAmount()
    },
    cleanUpTheMess: function () {
        $('#b5435566a27c88b4745c39e0b3d91da7').remove()
    },
    validate: function (u) {
        return ((u === undefined) ? '' : u)
    },
    toJSON: function (a) {
        return ((a === '') ? '' : $.parseJSON($.trim(a)))
    },
    getTimeStamp: function () {
        return new Date().getTime()
    },
    decimalFormat: function (a) {
        a += '';
        var x = a.split('.');
        var b = x[0];
        var c = x.length > 1 ? '.' + x[1] : '';
        var d = /(\d+)(\d{3})/;
        while (d.test(b)) {
            b = b.replace(d, '$1' + ',' + '$2')
        }
        return b + c
    },
    findGame: function (c, d, e) {
        var f = false;
        $.each(c, function (a, b) {
            if (!f) {
                if (b[d] == e) {
                    f = true
                }
            }
            return !f
        });
        return f
    },
    findAndRemoveGame: function (c, d, e) {
        var f = false;
        $.each(c, function (a, b) {
            if (!f) {
                if (b[d] == e) {
                    c.splice(a, 1);
                    f = true
                }
            }
            return !f
        });
        return f
    },
    buildItemsListGame: function (b) {
        var c = (b[0] === undefined) ? 0 : b[0].tab;
        var d = [];
        $.map(b, function (a) {
            if (c === 1 || c === 2) {
                d.push(a.eventId + ' ' + a.type)
            } else if (c === 3) {
                d.push(a.groupCode + ' ' + a.itemCode)
            }
        });
        return d.join(' : ')
    },
    invisibleToggle: function (a, b) {
        (b > 0) ? a.removeClass('invisible') : a.addClass('invisible')
    },
    alertAnimation: function (a) {
        $('body').prepend(a);
        $('html').addClass('no-scroll');
        $('.action').on('click', function () {
            $('#alert-message').animate({
                top: '-50%'
            }, 30, function () {
                $(this).remove();
                $('#back-layer').remove();
                $('html').removeClass('no-scroll')
            })
        });
        $('#back-layer').show();
        $('#alert-message').animate({
            top: '50%'
        }, 50)
    },
    showAlertMessage: function (a) {
        var b = '<div id="back-layer" style="display:none"></div>';
        var c = '<div id="alert-message">' + '<div id="message">' + $.trim(a) + '</div>' + '<div class="confirm"><button type="button" id="ok" class="action">ok</button></div>' + '</div>';
        run.alertAnimation(b + c)
    },
    leaveConfirmTab: function (a) {
        var b = '¿Está seguro de abandonar esta pesta&ntilde;a? <br> Si es así perderá las jugadas marcadas.';
        var c = 'confirmar';
        var d = 'abandonar';
        var e = 'permanecer';
        var f = '<div id="back-layer" style="display:none"></div>';
        var g = '<div id="alert-message">' + '<div class="title">' + c + '</div>' + '<div id="message">' + b + '</div>' + '<div class="confirm">' + '<button type="button" id="leave" class="action">' + d + '</button>' + '<button type="button" id="remain" class="action">' + e + '</button>' + '</div>' + '</div>';
        run.alertAnimation(f + g);
        $('#leave').on('click', function () {
            run.resetGame();
            $('.top-box').hide();
            $('#menu').find('.tab').removeClass('current');
            $(a.attr('href')).stop().fadeIn();
            a.parent('li').addClass('current')
        });
        $('#remain').on('click', function () {})
    },
    goTo: function (a) {
        $('.top-box').hide();
        $('#menu').find('.tab').removeClass('current');
        $(a.attr('href')).stop().fadeIn();
        a.parent('li').addClass('current')
    },
    walk: function (s, a, c, d, e) {
        if (c == 0) {
            s = s.substr(0, (s.length - 1));
            return (s + ' ')
        }
        var f = '';
        var x = 0;
        for (; x < a.length; x++) {
            var b = [];
            if (d) {
                b = a.slice(0);
                if (!e) {
                    b.splice(x, 1)
                }
            } else {
                b = a.slice(x);
                if (!e) {
                    b.splice(0, 1)
                }
            }
            f = f + run.walk((s + a[x]) + ',', b, c - 1, d, e)
        }
        return (f)
    },
    combine: function (a, b) {
        var c = [];
        for (var x in b) {
            if (b[x] <= 12) {
                var w = run.walk('', a, b[x], false, false);
                var d = w.substr(0, (w.length - 1)).split(' ');
                var e = [];
                for (var y in d) {
                    e.push(d[y].split(','))
                }
                c.push(e)
            }
        }
        return c
    },
    calculateWinningAmount: function (d) {
        d = (d === undefined) ? [] : d;
        run.allowMultiplier(d);
        run.allowCombination(d);
        var e = 0;
        var f = [];
        $.map(d, function (a) {
            f.push(parseFloat(a.probability).toFixed(2));
            e = a.tab
        });
        if (aCombinations.length > 0) {
            totalBets = 0;
            var g = run.combine(f, aCombinations);
            var h = 0;
            $.map(g, function (c) {
                $.map(c, function (b) {
                    var o = 1;
                    $.map(b, function (a) {
                        o *= a
                    });
                    h += o
                });
                totalBets += c.length
            });
            winningAmount = h
        } else {
            var o = 1;
            for (var x in f) {
                o *= f[x]
            }
            winningAmount = o;
            totalBets = 1
        } if (f.length === 0) {
            totalBets = 0;
            winningAmount = 0
        }
        winningAmount = winningAmount * multiplier;
        var i = (winningAmount < 50000) ? winningAmount : 50000;
        $('#winning-amount').text(run.decimalFormat(i.toFixed(2)));
        fullAmount = simpleBetPrice * multiplier * totalBets;
        $('#full-amount').text(run.decimalFormat(fullAmount.toFixed(2)));
        run.invisibleToggle($('#field-total-bet'), totalBets);
        $('#total-bet').text(totalBets);
        e = (e === 1 || e === 2) ? 1 : 2;
        teApuestoPlay = '{"play":"' + run.buildItemsListGame(d) + '","multiplier":' + multiplier + ',"combined":"' + aCombinations.join(' ') + '","price":' + fullAmount.toFixed(2) + ',"saleType":' + e + '}'
    },
    allowMultiplier: function (a) {
        var b = $('.btn-multiplier');
        if (a.length > 0) {
            b.prop('disabled', false).removeClass('disabled')
        } else {
            b.each(function () {
                if ($(this).hasClass('on')) {
                    $(this).trigger('click')
                }
            });
            multiplier = 1;
            b.prop('disabled', true).addClass('disabled').removeClass('on')
        }
    },
    allowCombination: function (d) {
        var e = $('.btn-combined');
        var f = 0;
        var g = 0;
        for (var x in d) {
            f = (f < d[x].minimun) ? d[x].minimun : f
        }
        g = (d.length <= f) ? f : d.length;
        g = (f === 0) ? f : g;
        e.prop('disabled', true);
        e.each(function (a, b) {
            var c = $(this).val();
            if (c >= f && c <= g && c <= d.length) {
                $(this).prop('disabled', false).removeClass('disabled')
            } else {
                if ($(this).hasClass('on')) {
                    $(this).trigger('click')
                }
                $(this).prop('disabled', true).addClass('disabled')
            }
        })
    }
};
var runBuy = {
    calculate_total_cost: function (a) {
        var b = 0;
        for (var i in a) {
            b += parseFloat(a[i].price)
        }
        $(".result1").html("S/." + floatFormat(b))
    },
    process_buy: function () {
        $('#transition').removeClass().addClass('transition-two');
        $('#content').hide();
        var a = $('#nav-bar').children('.indicator');
        if (a.hasClass('start')) {
            a.removeClass('start').addClass('end');
            $('#menu, #content').hide();
            $('#shopping-cart').fadeIn(250);
            $('#user-client').focus()
        }
        teApuestoJson.push(run.toJSON(teApuestoPlay));
        runBuy.tickets_grid(teApuestoJson);
        runBuy.paged_grid(teApuestoJson);
        runBuy.calculate_total_cost(teApuestoJson);
        $('.label_resu2').text(TeApuesto.BetData.priceMessage)
    },
    fecha_actual: function () {
        var f = new Date();
        var a = "";
        var b = "";
        var c = f.getMonth() + "";
        var d = f.getDate() + "";
        if (c.length == 1) {
            a = "0" + (f.getMonth() + 1) + ""
        } else {
            a = (f.getMonth() + 1) + ""
        } if (d.length == 1) {
            b = "0" + f.getDate() + ""
        } else {
            b = f.getDate() + ""
        }
        return b + "/" + a + "/" + f.getFullYear()
    },
    paged_grid: function (a) {
        var b = a.length;
        if (b > 0) {
            var c = '';
            var d = 0;
            var e = '';
            var f = 0;
            var g = 1;
            var h = 2;
            for (var i = 0; i < b; i++) {
                e = (i === 0) ? 'num_page_off' : 'num_page_on';
                if (i % 3 == 0) {
                    d++;
                    c += "&nbsp;<a class='lnk-pag1 lnk " + e + " ' id='" + f + "-" + g + "-" + h + "' rel='" + f + "-" + g + "-" + h + "' >" + d + "</a>&nbsp;";
                    f = f + 3;
                    g = g + 3;
                    h = h + 3
                }
            }
            $('#num_link').html("<span class='indice_page'>1</span> de " + d + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<" + c + ">")
        } else {
            $('#num_link').html('')
        }
    },
    paged_grid2: function (a) {
        var b = a.length;
        var c = '';
        var d = 0;
        var e = '';
        var f = 0;
        var g = 1;
        var h = 2;
        for (var i = 0; i < b; i++) {
            e = (i === 0) ? 'num_page_off' : 'num_page_on';
            if (i % 3 == 0) {
                d++;
                c += "&nbsp;<a class='lnk-pag2 lnk " + e + " ' id='id" + f + "_" + g + "_" + h + "i' rel='" + f + "-" + g + "-" + h + "' >" + d + "</a>&nbsp;";
                f = f + 3;
                g = g + 3;
                h = h + 3
            }
        }
        $('#num_link').html("<span class='indice_page'>1</span> de " + d + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<" + c + ">")
    },
    tickets_grid: function (a) {
        var b = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>ANULAR</div>" + "</div>";
        for (var x in a) {
            var c = "";
            c = a[x].play;
            var d = "row_grid";
            if (x % 2 != 0) {
                d += " row_grid_mouseover"
            }
            if (x > 2) {
                d += " row_null"
            }
            b += "<div class='" + d + "'>" + "<div class='column_1'>" + (parseInt(x) + 1) + "</div>" + "<div class='column_2'>" + c.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + "<div class='column_3'>" + "<div class='delete process-delete1' rel='" + x + "'></div>" + "</div>" + "</div>"
        }
        b += "</div>";
        $('#content-grid-result').html(b)
    },
    tickets_grid2: function (a) {
        var b = 0;
        var c = "<div id='grilla_boleto'>" + "<div class='boleto_cabecera'>" + "<div class='head_title_1'>N.</div>" + "<div class='head_title_2'>BOLETOS</div>" + "<div class='head_title_3'>VER</div>" + "</div>";
        for (var x in a) {
            var d = "";
            d = a[x].play;
            var e = "row_grid";
            if (x % 2 != 0) {
                e += " row_grid_mouseover"
            }
            if (x > 2) {
                e += " row_null"
            }
            var f = (a[x].ticket).split("&");
            var g = "";
            if (f[1] == "null") {
                g = "<div class='column3-no-process'>No procesado&nbsp;&nbsp;<span class='no-process' rel='" + b + "#" + f[0] + "'>[?]</span> </div>";
                g += "<div class='tooltip-no-process'></div><div class='tooltip-no-process-arrow-img'></div>";
                b++;
                var h = "<div class='title-text'><div><b>Jugadas no procesadas</b></div>" + "<div>Tienes apuestas que no se han podido procesar.</div></div>" + "<div id='no-process-section'><a href='#' class='buttom-go' id='btn-no-process' onclick='return false;'></a></div>";
                $("#game-no-process-info").show().html(h)
            } else {
                g = "<div class='column3-codigo'>" + f[1] + "</div><div class='column3-search' onclick='openPreviewWindow(" + a[x].gameId + ",\"" + a[x].name_game + "\",\"" + f[1] + "\")'></div>"
            }
            c += "<div class='" + e + "'>" + "<div class='column_1'>" + a[x].num_row + "</div>" + "<div class='column_2'>" + d.substring(0, 25) + "&nbsp;&nbsp;<span class='row-info' rel='" + x + "'>[+]</span>" + "<div class='tooltip-info'></div><div class='tooltip-info-arrow-img'></div></div>" + g + "</div>"
        }
        c += "</div>";
        $('#content-grid-result').html(c)
    }
};
var app = function () {
    run.prepareGame();
    var y = $('#menu');
    y.find('.tab a').on('click', function (a) {
        a.preventDefault();
        var b = $('#bcg .area-name, #bcg .btn-combined');
        var c = (gameItems[0] === undefined) ? 0 : gameItems[0].tab;
        switch ($(this).attr('id')) {
        case 'go-daily-programs':
            if (c === 1 || c === 2) {
                run.goTo($(this))
            } else if (c === 3) {
                run.leaveConfirmTab($(this))
            } else {
                run.goTo($(this));
                b.removeClass('through')
            }
            break;
        case 'go-exact-maker':
            if (c === 2 || c === 1) {
                run.goTo($(this))
            } else if (c === 3) {
                run.leaveConfirmTab($(this))
            } else {
                run.goTo($(this));
                b.removeClass('through')
            }
            $('#em-ugl').find('.unique-game').eq(0).trigger('click');
            break;
        case 'go-special-bets':
            if (c === 3) {
                run.goTo($(this))
            } else if (c === 1 || c === 2) {
                run.leaveConfirmTab($(this))
            } else {
                run.goTo($(this));
                b.addClass('through')
            }
            $('#special-bets-header').children('.btn-sport').eq(0).trigger('click');
            $('#special-bets-menu').children('ul').eq(0).children('.menu-item').eq(0).trigger('click');
            break;
        default:
            run.goTo($(this));
            break
        }
        $('.bottom-box').stop().hide().fadeIn();
        $('#dp-body').scrollTop(0).scrollLeft(0);
        $('#dp-body-list').find('.content-events').removeClass('fix')
    });
    var z = $('#ho').css('left');
    var A = $('#dp-head');
    var B = $('#dp-body');
    B.on('scroll', function () {
        if (B.scrollLeft() === 0) {
            $('#ho').css('left', z);
            $('#he, .content-events').removeClass('fix');
            $('#ce').css('left', 0)
        } else if (B.scrollLeft() > 0) {
            $('#he, .content-events').addClass('fix');
            $('.content-events').css('left', B.scrollLeft());
            $('#ho').css('left', ((parseInt(z)) - B.scrollLeft()))
        }
        if (B.scrollTop() === 0) {
            A.removeClass('fix')
        } else if (B.scrollTop() > 0) {
            A.addClass('fix')
        }
    });
    var C = '';
    var D = '';
    $.map(TeApuesto.DrawData, function (e) {
        var b = '';
        var c = '';
        var d = e.drawId;
        $.map(e.events, function (i) {
            var a = 1;
            b += create.row('' + create.customCell(i.hour, 'hour') + create.customCell(i.eventId, 'code') + create.customCell(create.iconBox('sA', i.leagueId), 'tourney') + create.customCell(i.minimun, 'sel minimun-' + i.minimun) + create.customCell(i.teams, 'vs') + create.customCell(create.exactGolTag(i.exactGoal, create.dataAttributeExactGoal(i.exactGoal, d, i.eventId)), 'ball'));
            c += create.row('' + create.optionCell(create.gameItemTag(i.local, create.dataAttributeGame(d, i.eventId, i.minimun, 'L', i.local, a))) + create.optionCell(create.gameItemTag(i.equal, create.dataAttributeGame(d, i.eventId, i.minimun, 'E', i.equal, a))) + create.optionCell(create.gameItemTag(i.visitor, create.dataAttributeGame(d, i.eventId, i.minimun, 'V', i.visitor, a))) + create.optionCell(create.gameItemTag(i.localEqual, create.dataAttributeGame(d, i.eventId, i.minimun, 'LE', i.localEqual, a))) + create.optionCell(create.gameItemTag(i.localVisitor, create.dataAttributeGame(d, i.eventId, i.minimun, 'LV', i.localVisitor, a))) + create.optionCell(create.gameItemTag(i.equalVisitor, create.dataAttributeGame(d, i.eventId, i.minimun, 'EV', i.equalVisitor, a))) + create.optionCell(create.gameItemTag(i.t1tLocal, create.dataAttributeGame(d, i.eventId, i.minimun, 'L/', i.t1tLocal, a))) + create.optionCell(create.gameItemTag(i.t1tEqual, create.dataAttributeGame(d, i.eventId, i.minimun, 'E/', i.t1tEqual, a))) + create.optionCell(create.gameItemTag(i.t1tVisitor, create.dataAttributeGame(d, i.eventId, i.minimun, 'V/', i.t1tVisitor, a))) + create.optionCell(create.gameItemTag(i.t1tLocal2tLocal, create.dataAttributeGame(d, i.eventId, i.minimun, 'L/L', i.t1tLocal2tLocal, a))) + create.optionCell(create.gameItemTag(i.t1tEqual2tLocal, create.dataAttributeGame(d, i.eventId, i.minimun, 'E/L', i.t1tEqual2tLocal, a))) + create.optionCell(create.gameItemTag(i.t1tVisitor2tLocal, create.dataAttributeGame(d, i.eventId, i.minimun, 'V/L', i.t1tVisitor2tLocal, a))) + create.optionCell(create.gameItemTag(i.t1tLocal2tEqual, create.dataAttributeGame(d, i.eventId, i.minimun, 'L/E', i.t1tLocal2tEqual, a))) + create.optionCell(create.gameItemTag(i.t1tEqual2tEqual, create.dataAttributeGame(d, i.eventId, i.minimun, 'E/E', i.t1tEqual2tEqual, a))) + create.optionCell(create.gameItemTag(i.t1tVisitor2tEqual, create.dataAttributeGame(d, i.eventId, i.minimun, 'V/E', i.t1tVisitor2tEqual, a))) + create.optionCell(create.gameItemTag(i.t1tLocal2tVisitor, create.dataAttributeGame(d, i.eventId, i.minimun, 'L/V', i.t1tLocal2tVisitor, a))) + create.optionCell(create.gameItemTag(i.t1tEqual2tVisitor, create.dataAttributeGame(d, i.eventId, i.minimun, 'E/V', i.t1tEqual2tVisitor, a))) + create.optionCell(create.gameItemTag(i.t1tVisitor2tVisitor, create.dataAttributeGame(d, i.eventId, i.minimun, 'V/V', i.t1tVisitor2tVisitor, a))) + create.optionCell(create.gameItemTag(i.goalLower2, create.dataAttributeGame(d, i.eventId, i.minimun, '-', i.goalLower2, a))) + create.optionCell(create.gameItemTag(i.goalOver3, create.dataAttributeGame(d, i.eventId, i.minimun, '+', i.goalOver3, a))) + create.optionCell(create.gameItemTag(i.goal_0_1, create.dataAttributeGame(d, i.eventId, i.minimun, 'G01', i.goal_0_1, a))) + create.optionCell(create.gameItemTag(i.goal_2_3, create.dataAttributeGame(d, i.eventId, i.minimun, 'G23', i.goal_2_3, a))) + create.optionCell(create.gameItemTag(i.goal4More, create.dataAttributeGame(d, i.eventId, i.minimun, 'G4M', i.goal4More, a))))
        });
        C += create.programButton(e.drawId, e.date);
        D += '<div id="program-' + d + '" class="single-list group" style="display:none">' + '<ul class="content-events">' + b + '</ul>' + '<ul class="content-options">' + c + '</ul>' + '</div>'
    });
    $('#dp-body-list').html(D);
    $('#section-programs').on('click', '.btn-program', function () {
        $('.btn-program').not($(this)).removeClass('current');
        $(this).addClass('current');
        $('.single-list').hide();
        var a = $(this).val();
        $('#program-' + a).stop().fadeIn('slow');
        $('#date-program').text($(this).data('date') + ' - ' + 'Programa' + ' ' + a);
        $('#dp-body').scrollTop(0).scrollLeft(0)
    }).append(C);
    $('.btn-multiplier').on('click', function () {
        if ($(this).hasClass('on')) {
            $(this).removeClass('on')
        } else {
            if ($('.btn-multiplier.on').length < config.maxMultiplier) {
                $(this).addClass('on')
            } else {
                jAlert('¡Solo puede escoger 3 opciones!')
            }
        }
        multiplier = 1;
        $('.btn-multiplier.on').each(function () {
            multiplier = multiplier * parseInt($(this).val())
        });
        $('#multiplier').text(((multiplier === 1) ? 0 : run.decimalFormat(multiplier)));
        run.invisibleToggle($('#field-multiplier'), ((multiplier === 1) ? 0 : multiplier));
        run.calculateWinningAmount(gameItems)
    }).prop('disabled', true).addClass('disabled');
    $('.btn-combined').on('click', function () {
        aCombinations = [];
        if ($(this).hasClass('on')) {
            $(this).removeClass('on')
        } else if (!$(this).hasClass('disabled')) {
            $(this).addClass('on')
        }
        $('.btn-combined.on').each(function () {
            aCombinations.push(parseInt($(this).val()))
        });
        var a = aCombinations.join(' ');
        $('#combined').text((a === '') ? '0' : a);
        run.invisibleToggle($('#field-combined'), aCombinations.length);
        run.calculateWinningAmount(gameItems)
    }).prop('disabled', true).addClass('disabled');
    $('#daily-programs').on('click', '.ball .icon.exact-goal', function () {
        if (!$.isEmptyObject($(this).data('exactGoal'))) {
            $('#go-exact-maker').trigger('click');
            $('#event-' + $(this).data('exactGoal').eventId).trigger('click')
        }
    }).on('mouseenter', '.ball .icon.exact-goal', function () {
        $(this).parent('.cell.ball').prepend(create.tooltip($(this).data('title')))
    }).on('mouseleave', '.ball .icon.exact-goal', function () {
        $(this).siblings('.tooltip').remove()
    });
    if (TeApuesto.ExactData.length === 0) {
        $('#go-exact-maker').on('mouseenter', function () {
            $(this).parent('.tab').prepend(create.tooltip($(this).data('title')))
        }).on('mouseleave', function () {
            $(this).siblings('.tooltip').remove()
        }).off('click').data('title', 'Esta vez no hay marcador exacto!')
    }
    var E = '';
    var F = '';
    var G = '';
    var H = '';
    $.map(TeApuesto.ExactData, function (e) {
        var a = 1;
        var b = 2;
        H += "<li id='event-" + e.eventId + "' data-unique-game='" + create.dataAttirbuteUniqueGame(e.drawId, e.eventId, e.data.hour, e.data.date) + "' class='unique-game arrow-button'><span>" + e.teamsMenu + "</span></li>";
        E += '<ul id="lw-' + e.eventId + '" class="body-list" style="display: none">' + create.row('' + create.optionCell('1 - 0') + create.optionCell(create.gameItemTag(e.data.s10, create.dataAttributeGame(e.drawId, e.eventId, a, 'S1-0', e.data.s10, b))) + create.optionCell('4 - 2') + create.optionCell(create.gameItemTag(e.data.s42, create.dataAttributeGame(e.drawId, e.eventId, a, 'S4-2', e.data.s42, b)))) + create.row('' + create.optionCell('2 - 0') + create.optionCell(create.gameItemTag(e.data.s20, create.dataAttributeGame(e.drawId, e.eventId, a, 'S2-0', e.data.s20, b))) + create.optionCell('4 - 3') + create.optionCell(create.gameItemTag(e.data.s43, create.dataAttributeGame(e.drawId, e.eventId, a, 'S4-3', e.data.s43, b)))) + create.row('' + create.optionCell('2 - 1') + create.optionCell(create.gameItemTag(e.data.s21, create.dataAttributeGame(e.drawId, e.eventId, a, 'S2-1', e.data.s21, b))) + create.optionCell('5+ - 0') + create.optionCell(create.gameItemTag(e.data.s5More0, create.dataAttributeGame(e.drawId, e.eventId, a, 'S5-0', e.data.s5More0, b)))) + create.row('' + create.optionCell('3 - 0') + create.optionCell(create.gameItemTag(e.data.s30, create.dataAttributeGame(e.drawId, e.eventId, a, 'S3-0', e.data.s30, b))) + create.optionCell('5+ - 1') + create.optionCell(create.gameItemTag(e.data.s5More1, create.dataAttributeGame(e.drawId, e.eventId, a, 'S5-1', e.data.s5More1, b)))) + create.row('' + create.optionCell('3 - 1') + create.optionCell(create.gameItemTag(e.data.s31, create.dataAttributeGame(e.drawId, e.eventId, a, 'S3-1', e.data.s31, b))) + create.optionCell('5+ - 2') + create.optionCell(create.gameItemTag(e.data.s5More2, create.dataAttributeGame(e.drawId, e.eventId, a, 'S5-2', e.data.s5More2, b)))) + create.row('' + create.optionCell('3 - 2') + create.optionCell(create.gameItemTag(e.data.s32, create.dataAttributeGame(e.drawId, e.eventId, a, 'S3-2', e.data.s32, b))) + create.optionCell('5+ - 3') + create.optionCell(create.gameItemTag(e.data.s5More3, create.dataAttributeGame(e.drawId, e.eventId, a, '5-3', e.data.s5More3, b)))) + create.row('' + create.optionCell('4 - 0') + create.optionCell(create.gameItemTag(e.data.s40, create.dataAttributeGame(e.drawId, e.eventId, a, 'S4-0', e.data.s40, b))) + create.optionCell('5+ - 4') + create.optionCell(create.gameItemTag(e.data.s5More4, create.dataAttributeGame(e.drawId, e.eventId, a, 'S5-4', e.data.s5More4, b)))) + create.row('' + create.optionCell('4 - 1') + create.optionCell(create.gameItemTag(e.data.s41, create.dataAttributeGame(e.drawId, e.eventId, a, 'S4-1', e.data.s41, b))) + create.optionCell('5+ - 5+') + create.optionCell(create.gameItemTag(e.data.s5More5, create.dataAttributeGame(e.drawId, e.eventId, a, 'S5-5', e.data.s5More5, b)))) + '</ul>';
        F += '<ul id="eq-' + e.eventId + '" class="body-list" style="display:none">' + create.row(create.optionCell('0 - 0') + create.optionCell(create.gameItemTag(e.data.s00, create.dataAttributeGame(e.drawId, e.eventId, a, 'S0-0', e.data.s00, b)))) + create.row(create.optionCell('1 - 1') + create.optionCell(create.gameItemTag(e.data.s11, create.dataAttributeGame(e.drawId, e.eventId, a, 'S1-1', e.data.s11, b)))) + create.row(create.optionCell('2 - 2') + create.optionCell(create.gameItemTag(e.data.s22, create.dataAttributeGame(e.drawId, e.eventId, a, 'S2-2', e.data.s22, b)))) + create.row(create.optionCell('3 - 3') + create.optionCell(create.gameItemTag(e.data.s33, create.dataAttributeGame(e.drawId, e.eventId, a, 'S3-3', e.data.s33, b)))) + create.row(create.optionCell('4 - 4') + create.optionCell(create.gameItemTag(e.data.s44, create.dataAttributeGame(e.drawId, e.eventId, a, 'S4-4', e.data.s44, b)))) + create.row(create.optionCell('5+ - 5+') + create.optionCell(create.gameItemTag(e.data.s5More5, create.dataAttributeGame(e.drawId, e.eventId, a, 'S5-5', e.data.s5More5, b)))) + '</ul>';
        G += '<ul id="vw-' + e.eventId + '" class="body-list" style="display:none">' + create.row('' + create.optionCell('0 - 1') + create.optionCell(create.gameItemTag(e.data.s01, create.dataAttributeGame(e.drawId, e.eventId, a, 'S0-1', e.data.s01, b))) + create.optionCell('2 - 4') + create.optionCell(create.gameItemTag(e.data.s24, create.dataAttributeGame(e.drawId, e.eventId, a, 'S2-4', e.data.s24, b)))) + create.row('' + create.optionCell('0 - 2') + create.optionCell(create.gameItemTag(e.data.s02, create.dataAttributeGame(e.drawId, e.eventId, a, 'S0-2', e.data.s02, b))) + create.optionCell('3 - 4') + create.optionCell(create.gameItemTag(e.data.s34, create.dataAttributeGame(e.drawId, e.eventId, a, 'S3-4', e.data.s34, b)))) + create.row('' + create.optionCell('1 - 2') + create.optionCell(create.gameItemTag(e.data.s12, create.dataAttributeGame(e.drawId, e.eventId, a, 'S1-2', e.data.s12, b))) + create.optionCell('0 - 5+') + create.optionCell(create.gameItemTag(e.data.s05More, create.dataAttributeGame(e.drawId, e.eventId, a, 'S0-5', e.data.s05More, b)))) + create.row('' + create.optionCell('0 - 3') + create.optionCell(create.gameItemTag(e.data.s03, create.dataAttributeGame(e.drawId, e.eventId, a, 'S0-3', e.data.s03, b))) + create.optionCell('1 - 5+') + create.optionCell(create.gameItemTag(e.data.s15More, create.dataAttributeGame(e.drawId, e.eventId, a, 'S1-5', e.data.s15More, b)))) + create.row('' + create.optionCell('1 - 3') + create.optionCell(create.gameItemTag(e.data.s13, create.dataAttributeGame(e.drawId, e.eventId, a, 'S1-3', e.data.s13, b))) + create.optionCell('2 - 5+') + create.optionCell(create.gameItemTag(e.data.s25More, create.dataAttributeGame(e.drawId, e.eventId, a, 'S2-5', e.data.s25More, b)))) + create.row('' + create.optionCell('2 - 3') + create.optionCell(create.gameItemTag(e.data.s23, create.dataAttributeGame(e.drawId, e.eventId, a, 'S2-3', e.data.s23, b))) + create.optionCell('3 - 5+') + create.optionCell(create.gameItemTag(e.data.s35More, create.dataAttributeGame(e.drawId, e.eventId, a, 'S3-5', e.data.s35More, b)))) + create.row('' + create.optionCell('0 - 4') + create.optionCell(create.gameItemTag(e.data.s04, create.dataAttributeGame(e.drawId, e.eventId, a, 'S0-4', e.data.s04, b))) + create.optionCell('4 - 5+') + create.optionCell(create.gameItemTag(e.data.s45More, create.dataAttributeGame(e.drawId, e.eventId, a, 'S4-5', e.data.s45More, b)))) + create.row('' + create.optionCell('1 - 4') + create.optionCell(create.gameItemTag(e.data.s14, create.dataAttributeGame(e.drawId, e.eventId, a, 'S1-4', e.data.s14, b))) + create.optionCell('5+ - 5+') + create.optionCell(create.gameItemTag(e.data.s5More5, create.dataAttributeGame(e.drawId, e.eventId, a, 'S5-5', e.data.s5More5, b)))) + '</ul>'
    });
    $('#eg-local-win').append(E);
    $('#eg-equals').append(F);
    $('#eg-visitor-win').append(G);
    $('#em-ugl').on('click', '.unique-game', function () {
        $('.unique-game').not($(this)).removeClass('on');
        $(this).addClass('on');
        $('#title-game').text('CÓDIGO:' + ' ' + $(this).data('uniqueGame').eventId + ' - ' + $(this).text());
        $('#DateGame').text($(this).data('uniqueGame').date + ' ' + $(this).data('uniqueGame').hour);
        $('#exact-list').find('.body-list').stop().slideUp(100).delay(100);
        $('#lw-' + $(this).data('uniqueGame').eventId).slideDown(400);
        $('#eq-' + $(this).data('uniqueGame').eventId).slideDown(400);
        $('#vw-' + $(this).data('uniqueGame').eventId).slideDown(400)
    }).html(H);
    $('#game-list, #exact-list').on('click', '.game', function () {
        if ($(this).hasClass('on')) {
            if (run.findAndRemoveGame(gameItems, 'eventId', $(this).data('gameItem').eventId)) {
                $(this).removeClass('on')
            }
        } else {
            if (run.findGame(gameItems, 'eventId', $(this).data('gameItem').eventId)) {
                jAlert('Solo puede marcar una vez por cada evento')
            } else {
                if (gameItems.length < config.maxGame) {
                    gameItems[gameItems.length] = $(this).data('gameItem');
                    $(this).addClass('on')
                } else {
                    jAlert('Solo puede marcar hasta ' + config.maxGame + ' juegos por boleto.')
                }
            }
        }
        $('#bet-result').text(run.buildItemsListGame(gameItems));
        run.calculateWinningAmount(gameItems)
    });
    var I = '';
    var J = '';
    var K = '';
    $.map(TeApuesto.SpecialData, function (e) {
        I += create.sportButton(e.header, e.name, create.iconBox('sA', e.header));
        var i = '';
        var j = 0;
        $.map(e.data, function (f) {
            var d = '';
            $.map(f.groupList, function (g) {
                var a = '<div class="row header"><div class="cell head date">fecha</div><div class="cell head hour">hora</div><div class="cell head code">cod.</div><div class="cell head img"></div><div class="cell head team">' + g.subHeader + '</div><div class="cell head op">prob.</div></div>';
                var b = '';
                var c = '';
                $.map(g.lists, function (h) {
                    c = h.groupCode;
                    b += create.row('' + create.customCell(h.itemDate, 'date') + create.customCell(h.itemHour, 'hour') + create.customCell(h.itemCode, 'code') + create.customCell(create.iconBox('sC', h.itemImage), 'img') + create.customCell(h.itemDescription, 'team') + create.customCell(create.gameItemTag(h.odds, create.dataAttributeSpecialGame(h.groupCode, h.itemCode, j, h.itemDescription, h.odds, 3)), 'op'))
                });
                d += '<li class="special-item">' + '<a class="tab" href="#list-' + g.leagueId + '">' + create.iconBox('sB', g.groupImage) + '<span class="group-title">CÓDIGO: ' + c + ' ' + g.groupTitle + '</span>' + '</a>' + '<div id="list-' + g.leagueId + '" class="container-list" style="display:none">' + a + create.list(b) + '</div>' + '</li>'
            });
            i += '<li data-tadrawid="' + f.tadrawId + '" class="menu-item arrow-button"><span>' + f.menu + '</span></li>';
            K += '<ul id="gi-' + f.tadrawId + '" class="group-itemt" style="display:none">' + d + '</ul>'
        });
        J += '<ul id="' + e.header + '" style="display: none">' + i + '</ul>'
    });
    $('#special-list').html(K);
    $('#special-bets-menu').on('click', '.menu-item', function () {
        $('.menu-item').not($(this)).removeClass('on');
        $(this).addClass('on');
        $('#special-bets-title').html($(this).html());
        $('.group-itemt').hide();
        $('#gi-' + $(this).data('tadrawid')).stop().fadeIn();
        $('#special-list').find('a.tab.on').trigger('click')
    }).html(J);
    $('#special-bets-header').on('click', '.btn-sport', function () {
        $('.btn-sport').not($(this)).removeClass('on');
        $(this).addClass('on');
        $('#special-bets-menu').children('ul').hide();
        var a = $('#' + $(this).val());
        a.stop().fadeIn(function () {
            a.children('.menu-item').eq(0).trigger('click')
        });
        $('.menu-item').removeClass('on');
        $('.group-itemt').hide();
        $('#special-bets-title').html('')
    }).html(I);
    $('#special-list').find('a.tab').on('click', function (a) {
        a.preventDefault();
        $(this).toggleClass('on');
        $($(this).attr('href')).stop().slideToggle(200);
        if ($('#special-list').find('a.tab.on').length > 0) {
            $('#collapse-all').stop().fadeIn()
        } else {
            $('#collapse-all').stop().fadeOut()
        }
    });
    $('#collapse-all').on('click', function (a) {
        a.preventDefault();
        var b = $('#special-list').find('a.tab');
        if (b.hasClass('on')) {
            $('.container-list').stop().slideUp(350);
            b.removeClass('on')
        }
        $(this).fadeOut()
    });
    $('#special-bets').on('click', '.game', function () {
        if (!$(this).hasClass('on')) {
            $('#special-bets').find('.game').removeClass('on');
            $(this).addClass('on');
            gameItems[0] = $(this).data('gameItem')
        } else {
            $(this).removeClass('on');
            gameItems = []
        }
        $('#bet-result').text(run.buildItemsListGame(gameItems));
        run.calculateWinningAmount(gameItems)
    });
    $('#buy').on('click', function () {
        if (fullAmount > 0) {
            runBuy.process_buy()
        } else {
            jAlert('Elige correctamente tu apuesta.', null)
        }
    });
    $('#more_plays').on('click', function () {
        run.resetGame();
        $('#nav-bar').children('.indicator').removeClass('end').addClass('start');
        $('#shopping-cart').hide();
        $('#menu, #content').fadeIn(250);
        costoTotalBet = 0
    });
    $('.left-panel').on('click', '.process-delete1', function () {
        var a = parseInt($(this).attr("rel"));
        teApuestoJson.splice(a, 1);
        runBuy.tickets_grid(teApuestoJson);
        runBuy.paged_grid(teApuestoJson);
        runBuy.calculate_total_cost(teApuestoJson);
        if (teApuestoJson.length == 0) {
            $('#more_plays').click()
        }
    });
    $('.left-panel').on('mouseover', '.row-info', function () {
        var a = $(this).attr('rel');
        a = parseInt(a);
        var b = teApuestoJson[a].play;
        $('.tooltip-info').eq(a).show().html(b);
        $('.tooltip-info-arrow-img').eq(a).show()
    }).on('mouseout', '.row-info', function () {
        var a = $(this).attr('rel');
        $('.tooltip-info').eq(a).hide();
        $('.tooltip-info-arrow-img').eq(a).hide()
    });
    $('.left-panel').on('mouseover', '.no-process', function () {
        var a = $(this).attr('rel');
        var b = (a + '').split('#');
        var c = parseInt(b[0]);
        var d = b[1] + '';
        $('.tooltip-no-process').eq(c).show().html(d);
        $('.tooltip-no-process-arrow-img').eq(c).show()
    }).on('mouseout', '.no-process', function () {
        var a = $(this).attr('rel');
        var b = a.split('#');
        var c = parseInt(b[0]);
        var d = b[1];
        $('.tooltip-no-process').eq(c).hide().html(d);
        $('.tooltip-no-process-arrow-img').eq(c).hide()
    });
    $('.left-panel').on('click', '.lnk-pag1', function () {
        var a = $(this).attr('rel');
        var b = $(this).attr('id');
        var c = a.split('-');
        $('.row_grid').removeClass('row_null').addClass('row_null');
        for (var d in c) {
            $('.row_grid').eq(c[d]).removeClass('row_null')
        }
        $('.indice_page').html($('#' + b).html());
        $('.lnk').removeClass('num_page_on num_page_off').addClass('num_page_on');
        $('#' + $(this).attr('id')).removeClass('num_page_on').addClass('num_page_off')
    });
    $('.left-panel').on('click', '.lnk-pag2', function () {
        var a = $(this).attr('rel');
        var b = $(this).attr('id');
        var c = a.split('-');
        $('.row_grid').removeClass('row_null').addClass('row_null');
        for (var d in c) {
            $('.row_grid').eq(c[d]).removeClass('row_null')
        }
        $('.indice_page').html($('#' + b).html());
        $('.lnk').removeClass('num_page_on num_page_off').addClass('num_page_on');
        $('#' + $(this).attr('id')).removeClass('num_page_on').addClass('num_page_off')
    });
    $('.label_2').html(runBuy.fecha_actual());
    $('#frmLoginClient').on('submit', function (v) {
    	v.preventDefault();
        var w = $('#user-client').val();
        var x = $('#password-client').val();
        var valida_session = "", _id = $(this).attr("id");
        if (w == '' || x == '') {
            jAlert('Complete los datos de usuario')
        } else {
            $.ajax({
                type: "POST",
                url: "login_teapuesto.html",
                dataType: "text",
                data: $("#frmLoginClient").serialize(),
                success: function (a) {
                	//$('#password-client').val('');
                    var b = $.trim(a).split("|");
                    valida_session = b[0];
                    if (valida_session === 'OK' || valida_session === 'TC' || valida_session === 'MV' || valida_session === 'AC' || valida_session === 'RD') {
                        var d = b[1];
                        var e = b[2];
                        var f = b[3];
                        var g = floatFormat(b[4]);
                        var h = floatFormat(b[5]);
                        var i = b[7];
                        var j = b[8];
                        var k = b[9];
                        var l = b[10];
                        var m = b[11];
                        var n = b[12];
                        var o = b[13];
                        var p = b[14];
                        var q = b[15];
                        var r = b[16];
                        var s = b[17];
                        var t = b[18];
                        var u = b[20];
                        $('#field-balance-amount').text(g);
                        $('#saldo-promocional').text((h == '0.0') ? '' : ' ' + 'ó de mi saldo promocional S/.' + h);
                        $('#clientId').val(f);
                        $('#clientSale-name').text(d);
                        $('#clientSale-amount').text(floatFormat(e));
                        $('#user-ico').addClass(b[6]);
                        $("#nombre").val(i);
                        $("#apPaterno").val(j);
                        $("#apMaterno").val(k);
                        $("#mail").val(l);
                        $("#phone").val(m);
                        $("#country").val(n);
                        $("#city").val(o);
                        $("#addres").val(p);
                        $("#typeId").val(q);
                        $("#numberId").val(r);
                        $("#amount").val(floatFormat(s));
                        $("#email").val(b[18]);
                        $("#sesionId").val(u);
                        
                        if(valida_session === 'MV') {
                        	exe.openeml(_id,arrresp[1]);
                        } else if(valida_session === 'AC') {
                        	exe.openphn(_id,arrresp[1]);
                        } else if(valida_session === 'TC') exe.opentyc(_id);
                        else if(valida_session === 'RD') { exe.openrdb(_id,arrresp[1]); }
                        else viewNext();
                        /*$('.logout').show();
                        $('.unlogout').hide();
                        $('#payments_section').show();
                        $('#login_section').hide();
                        $('#btn_finaliza_compra').show();
                        $('#panel_finaliza_compra').show();*/
                    } else if(valida_session === 'CC' ){
                        jAlert(arrresp[1], null);
                        $('#user-client').focus();
                        setCaptcha(true);
                    } else {
                        jAlert(valida_session, null);
                        $('#user-client').focus();
                    }
                }
            })
        }
    });
    $('#frmLoginClientIndex').attr('id', 'frmLoginClientTeApuesto').attr('action', 'login_teapuesto.html');
    $('#frmLoginClientTeApuesto').on('submit', function (i) {
        i.preventDefault();
        var valida_session = "", _id = $(this).attr("id");
        $.ajax({
            type: $(this).attr('method'),
            url: $(this).attr('action'),
            dataType: $(this).data('responseType'),
            data: $(this).serialize(),
            success: function (a) {
            	//$('#password-client-header').val('');
                var b = $.trim(a).split('|');
                valida_session = b[0];
                if (valida_session === 'OK' || valida_session === 'TC' || valida_session === 'MV' || valida_session === 'AC' || valida_session === 'RD') {
                    var d = b[1];
                    var e = b[2];
                    var f = b[3];
                    var g = floatFormat(b[4]);
                    var h = floatFormat(b[5]);
                    $('#field-balance-amount').text(g);
                    $('#saldo-promocional').text((h == '0.0') ? '' : ' ' + 'ó de mi saldo promocional S/.' + h);
                    $('#clientId').val(f);
                    $('#clientSale-name').text(d);
                    $('#clientSale-amount').text(floatFormat(e));
                    $('#user-ico').addClass(b[6]);
                    
                    if(valida_session === 'MV') {
                    	exe.openeml(_id,arrresp[1]);
                    } else if(valida_session === 'AC') {
                    	exe.openphn(_id,arrresp[1]);
                    } else if(valida_session === 'TC') exe.opentyc(_id);
                    else if(valida_session === 'RD') { exe.openrdb(_id,arrresp[1]); }
                    else viewNext();
                    /*$('.logout').show();
                    $('.unlogout').hide();
                    $('#payments_section').show();
                    $('#login_section').hide();
                    $('#panel_finaliza_compra').show();*/
                } else if(valida_session === 'CC' ){
                    jAlert(arrresp[1], null);
                    $('#user-client-header').focus();
                    setCaptcha(true);
                } else {
                    jAlert(valida_session, null);
                    $('#user-client-header').focus();
                }
            }
        })
    });
    $('#btn_finaliza_compra').on('click', function (e) {
        e.preventDefault();
        var f = $('[name=option-card]:checked').val();
        var g = $('[name=pin-number]').val();
        var h = '';
        var j = 0.00;
        var k = 0.00;
        if (f == 0) {
            if (teApuestoJson.length != 0) {
                var l = "<div class='label-top'></div>" + "<div class='label_1'>TE APUESTO</div>" + "<div id='ajax-loader'>" + "<img src='layer-view-image/game/kinelo/ajax-loader.gif'>" + "</div><div id='content-grid-result'></div>" + "<div id='num_link'></div>";
                l += "<div id='game-no-process-info'></div>";
                $('.left-panel').html(l);
                $('#panel_more_plays').hide();
                $('#panel_finaliza_compra').hide();
                $('#panel_keep-playing').show();
                $('#panel_game-history').show();
                $("#ico-block").show();
                $('.label-top').show();
                $('#sub_panel').hide();
                $('#ajax-loader').show();
                var m = 0;
                $.ajax({
                    type: 'POST',
                    url: 'ajaxJugadasTeapuesto.html',
                    dataType: 'json',
                    data: {
                        "data": JSON.stringify(teApuestoJson)
                    },
                    success: function (a) {
                        nteApuestoJson = a;
                        $('.label_resu3').html('<b>Saldo Disponible: S/. </b>' + floatFormat(nteApuestoJson[(nteApuestoJson.length - 1)].available_balance));
                        var b = parseFloat(nteApuestoJson[(nteApuestoJson.length - 1)].promotional_balance);
                        if (b > 0) {
                            $('.label_resu4').html('<b>Saldo Promocional: S/. </b>' + nteApuestoJson[(nteApuestoJson.length - 1)].promotional_balance)
                        }
                        $('#clientSale-amount').text(floatFormat(nteApuestoJson[(nteApuestoJson.length - 1)].available_balance));
                        $('#ajax-loader').hide();
                        runBuy.tickets_grid2(nteApuestoJson);
                        runBuy.paged_grid2(nteApuestoJson);
                        var c = 0;
                        for (var i in nteApuestoJson) {
                            var d = (nteApuestoJson[i].ticket).split('&');
                            if (d[1] != 'null') {
                                $('.label-top').text('¡GRACIAS POR TU COMPRA!');
                                c += parseFloat(nteApuestoJson[i].price)
                                
                            }
                        }
                        
                        $('.result1').text('S/.' + floatFormat(c));
                        $('.label_resu1').text('TOTAL PAGADO:')
                    }
                })
            } else {
                jAlert('No se tiene jugadas por procesar', null)
            } if (f === 1) {
                jAlert('Se ha realizado una recarga de saldo.\n\nMonto cargado: S/. ' + j + '\nTu saldo es: S/. ' + k, null)
            }
        } else {
            if (f === 1) {
                jAlert('No se ha logrado realizar la recarga.\n' + h + '\n\nMonto cargado: S/. ' + j + '\nTu saldo es: S/. ' + k, null)
            }
        }
    });
    $('#keep-playing').on('click', function (a) {
        location.href = 'juega-teapuesto.html'
    }).off();
    $("#game-history").on("click", function () {
        location.href = 'mi-cuenta.html#jugadas'
    }).off();
    var L = [];
    $('.left-panel').on('click', '#btn-no-process', function () {
        var a = 0;
        for (var i in nteApuestoJson) {
            var b = (nteApuestoJson[i].ticket).split('&');
            if (b[1] == 'null') {
                L.push(nteApuestoJson[i]);
                a++
            }
        }
        $('#panel_keep-playing').hide();
        $('#panel_game-history').hide();
        $("#ico-block").hide();
        $('#panel_finaliza_compra').show();
        $('#panel_more_plays').show();
        $('#sub_panel').show();
        $('.left-panel').html("<span class='label_1'>TE APUESTO</span>" + "<div id='content-grid-result'></div>" + "<div id='num_link'></div>");
        $('#start_play').hide();
        $('#help-part1').hide();
        $('.finalize-purchase').show();
        teApuestoJson = L;
        L = [];
        nteApuestoJson = [];
        runBuy.tickets_grid(teApuestoJson);
        runBuy.paged_grid(teApuestoJson);
        $('.clear').click();
        var c = 0;
        for (var i in teApuestoJson) {
            c += parseFloat(teApuestoJson[i].price)
        }
        $('.result1').text('S/.' + floatFormat(c));
        $('.result2').text('S/.' + parseFloat($('#simpleBetPrice_repeated').val()));
        $('.label_resu1').html('TOTAL A PAGAR:')
    });
    var M = $('#clientId').val();
    if(M != '' && $("#agreement").val() == ''){
    	 $('#login_section').show();
    	exe.opentyc(null);
    } else if (M == '') {
        $('#login_section').show();
    } else {
        $('#login_section').hide();
        $('#panel_finaliza_compra').show();
        $("#panel_finaliza_compra").show();
        $('#payments_section').show();
    }
    
    function viewNext(){
    	$('#password-client-header').val('');
    	$('#password-client').val('');
    	$('.logout').show();
        $('.unlogout').hide();
        $('#payments_section').show();
        $('#login_section').hide();
        $('#btn_finaliza_compra').show();
        $('#panel_finaliza_compra').show();
        //location.reload();
	}
};
$(app);
$(window).on('load', function () {
    run.setup()
});
