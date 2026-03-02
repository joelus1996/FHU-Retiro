! function(e, t) {
    "object" == typeof exports && "undefined" != typeof module ? t(require("jquery")) : "function" == typeof define && define.amd ? define(["jquery"], t) : t((e = e || self).jQuery)
}(this, function(C) {
    "use strict";

    function i(e, t) {
        for (var a = 0; a < t.length; a++) {
            var i = t[a];
            i.enumerable = i.enumerable || !1, i.configurable = !0, "value" in i && (i.writable = !0), Object.defineProperty(e, i.key, i)
        }
    }
    C = C && C.hasOwnProperty("default") ? C.default : C;
    var n = {
            autoShow: !1,
            autoHide: !1,
            autoPick: !1,
            inline: !1,
            container: null,
            trigger: null,
            language: "",
            format: "mm/dd/yyyy",
            date: null,
            startDate: null,
            endDate: null,
            startView: 0,
            weekStart: 0,
            yearFirst: !1,
            yearSuffix: "",
            days: ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"],
            daysShort: ["Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"],
            daysMin: ["Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"],
            months: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
            monthsShort: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
            itemTag: "li",
            mutedClass: "muted",
            pickedClass: "picked",
            disabledClass: "disabled",
            highlightedClass: "highlighted",
            template: '<div class="datepicker-container"><div class="datepicker-panel" data-view="years picker"><ul><li data-view="years prev">&lsaquo;</li><li data-view="years current"></li><li data-view="years next">&rsaquo;</li></ul><ul data-view="years"></ul></div><div class="datepicker-panel" data-view="months picker"><ul><li data-view="year prev">&lsaquo;</li><li data-view="year current"></li><li data-view="year next">&rsaquo;</li></ul><ul data-view="months"></ul></div><div class="datepicker-panel" data-view="days picker"><ul><li data-view="month prev">&lsaquo;</li><li data-view="month current"></li><li data-view="month next">&rsaquo;</li></ul><ul data-view="week"></ul><ul data-view="days"></ul></div></div>',
            offset: 10,
            zIndex: 1e3,
            filter: null,
            show: null,
            hide: null,
            pick: null
        },
        e = "undefined" != typeof window,
        t = e ? window : {},
        a = !!e && "ontouchstart" in t.document.documentElement,
        u = "datepicker",
        r = "click.".concat(u),
        s = "focus.".concat(u),
        o = "hide.".concat(u),
        l = "keyup.".concat(u),
        d = "pick.".concat(u),
        c = "resize.".concat(u),
        h = "scroll.".concat(u),
        f = "show.".concat(u),
        g = "touchstart.".concat(u),
        p = "".concat(u, "-hide"),
        m = {},
        v = Object.prototype.toString;

    function y(e) {
        return "string" == typeof e
    }
    var b = Number.isNaN || t.isNaN;

    function w(e) {
        return "number" == typeof e && !b(e)
    }

    function k(e) {
        return void 0 === e
    }

    function F(e) {
        return "date" === (t = e, v.call(t).slice(8, -1).toLowerCase()) && !b(e.getTime());
        var t
    }

    function x(i, n) {
        for (var e = arguments.length, r = new Array(2 < e ? e - 2 : 0), t = 2; t < e; t++) r[t - 2] = arguments[t];
        return function() {
            for (var e = arguments.length, t = new Array(e), a = 0; a < e; a++) t[a] = arguments[a];
            return i.apply(n, r.concat(t))
        }
    }

    function S(e) {
        return '[data-view="'.concat(e, '"]')
    }

    function Y(e, t) {
        return [31, (a = e, a % 4 == 0 && a % 100 != 0 || a % 400 == 0 ? 29 : 28), 31, 30, 31, 30, 31, 31, 30, 31, 30, 31][t];
        var a
    }

    function D(e, t, a) {
        return Math.min(a, Y(e, t))
    }
    var M = /(y|m|d)+/g;

    function A(e) {
        var t = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : 1,
            a = String(Math.abs(e)),
            i = a.length,
            n = "";
        for (e < 0 && (n += "-"); i < t;) i += 1, n += "0";
        return n + a
    }
    var U = /\d+/g,
        V = {
            show: function() {
                this.built || this.build(), this.shown || this.trigger(f).isDefaultPrevented() || (this.shown = !0, this.$picker.removeClass(p).on(r, C.proxy(this.click, this)), this.showView(this.options.startView), this.inline || (this.$scrollParent.on(h, C.proxy(this.place, this)), C(window).on(c, this.onResize = x(this.place, this)), C(document).on(r, this.onGlobalClick = x(this.globalClick, this)), C(document).on(l, this.onGlobalKeyup = x(this.globalKeyup, this)), a && C(document).on(g, this.onTouchStart = x(this.touchstart, this)), this.place()))
            },
            hide: function() {
                this.shown && (this.trigger(o).isDefaultPrevented() || (this.shown = !1, this.$picker.addClass(p).off(r, this.click), this.inline || (this.$scrollParent.off(h, this.place), C(window).off(c, this.onResize), C(document).off(r, this.onGlobalClick), C(document).off(l, this.onGlobalKeyup), a && C(document).off(g, this.onTouchStart))))
            },
            toggle: function() {
                this.shown ? this.hide() : this.show()
            },
            update: function() {
                var e = this.getValue();
                e !== this.oldValue && (this.setDate(e, !0), this.oldValue = e)
            },
            pick: function(e) {
                var t = this.$element,
                    a = this.date;
                this.trigger(d, {
                    view: e || "",
                    date: a
                }).isDefaultPrevented() || (a = this.formatDate(this.date), this.setValue(a), this.isInput && (t.trigger("input"), t.trigger("change")))
            },
            reset: function() {
                this.setDate(this.initialDate, !0), this.setValue(this.initialValue), this.shown && this.showView(this.options.startView)
            },
            getMonthName: function(e, t) {
                var a = this.options,
                    i = a.monthsShort,
                    n = a.months;
                return C.isNumeric(e) ? e = Number(e) : k(t) && (t = e), !0 === t && (n = i), n[w(e) ? e : this.date.getMonth()]
            },
            getDayName: function(e, t, a) {
                var i = this.options,
                    n = i.days;
                return C.isNumeric(e) ? e = Number(e) : (k(a) && (a = t), k(t) && (t = e)), a ? n = i.daysMin : t && (n = i.daysShort), n[w(e) ? e : this.date.getDay()]
            },
            getDate: function(e) {
                var t = this.date;
                return e ? this.formatDate(t) : new Date(t)
            },
            setDate: function(e, t) {
                var a = this.options.filter;
                if (F(e) || y(e)) {
                    if (e = this.parseDate(e), C.isFunction(a) && !1 === a.call(this.$element, e, "day")) return;
                    this.date = e, this.viewDate = new Date(e), t || this.pick(), this.built && this.render()
                }
            },
            setStartDate: function(e) {
                F(e) || y(e) ? this.startDate = this.parseDate(e) : this.startDate = null, this.built && this.render()
            },
            setEndDate: function(e) {
                F(e) || y(e) ? this.endDate = this.parseDate(e) : this.endDate = null, this.built && this.render()
            },
            parseDate: function(i) {
                var n = this.format,
                    e = [];
                return F(i) || (y(i) && (e = i.match(U) || []), F(i = i ? new Date(i) : new Date) || (i = new Date), e.length === n.parts.length && C.each(e, function(e, t) {
                    var a = parseInt(t, 10);
                    switch (n.parts[e]) {
                        case "dd":
                        case "d":
                            i.setDate(a);
                            break;
                        case "mm":
                        case "m":
                            i.setMonth(a - 1);
                            break;
                        case "yy":
                            i.setFullYear(2e3 + a);
                            break;
                        case "yyyy":
                            i.setFullYear(2 === t.length ? 2e3 + a : a)
                    }
                })), new Date(i.getFullYear(), i.getMonth(), i.getDate())
            },
            formatDate: function(e) {
                var t = this.format,
                    a = "";
                if (F(e)) {
                    var i = e.getFullYear(),
                        n = e.getMonth(),
                        r = e.getDate(),
                        s = {
                            d: r,
                            dd: A(r, 2),
                            m: n + 1,
                            mm: A(n + 1, 2),
                            yy: String(i).substring(2),
                            yyyy: A(i, 4)
                        };
                    a = t.source, C.each(t.parts, function(e, t) {
                        a = a.replace(t, s[t])
                    })
                }
                return a
            },
            destroy: function() {
                this.unbind(), this.unbuild(), this.$element.removeData(u)
            }
        },
        E = {
            click: function(e) {
                var t = C(e.target),
                    a = this.options,
                    i = this.date,
                    n = this.viewDate,
                    r = this.format;
                if (e.stopPropagation(), e.preventDefault(), !t.hasClass("disabled")) {
                    var s = t.data("view"),
                        o = n.getFullYear(),
                        l = n.getMonth(),
                        d = n.getDate();
                    switch (s) {
                        case "years prev":
                        case "years next":
                            o = "years prev" === s ? o - 10 : o + 10, n.setFullYear(o), n.setDate(D(o, l, d)), this.renderYears();
                            break;
                        case "year prev":
                        case "year next":
                            o = "year prev" === s ? o - 1 : o + 1, n.setFullYear(o), n.setDate(D(o, l, d)), this.renderMonths();
                            break;
                        case "year current":
                            r.hasYear && this.showView(2);
                            break;
                        case "year picked":
                            r.hasMonth ? this.showView(1) : (t.addClass(a.pickedClass).siblings().removeClass(a.pickedClass), this.hideView()), this.pick("year");
                            break;
                        case "year":
                            o = parseInt(t.text(), 10), i.setFullYear(o), i.setDate(D(o, l, d)), n.setFullYear(o), n.setDate(D(o, l, d)), r.hasMonth ? this.showView(1) : (t.addClass(a.pickedClass).siblings().removeClass(a.pickedClass), this.hideView()), this.pick("year");
                            break;
                        case "month prev":
                        case "month next":
                            (l = "month prev" === s ? l - 1 : l + 1) < 0 ? (o -= 1, l += 12) : 11 < l && (o += 1, l -= 12), n.setFullYear(o), n.setDate(D(o, l, d)), n.setMonth(l), this.renderDays();
                            break;
                        case "month current":
                            r.hasMonth && this.showView(1);
                            break;
                        case "month picked":
                            r.hasDay ? this.showView(0) : (t.addClass(a.pickedClass).siblings().removeClass(a.pickedClass), this.hideView()), this.pick("month");
                            break;
                        case "month":
                            l = C.inArray(t.text(), a.monthsShort), i.setFullYear(o), i.setDate(D(o, l, d)), i.setMonth(l), n.setFullYear(o), n.setDate(D(o, l, d)), n.setMonth(l), r.hasDay ? this.showView(0) : (t.addClass(a.pickedClass).siblings().removeClass(a.pickedClass), this.hideView()), this.pick("month");
                            break;
                        case "day prev":
                        case "day next":
                        case "day":
                            "day prev" === s ? l -= 1 : "day next" === s && (l += 1), d = parseInt(t.text(), 10), i.setFullYear(o), i.setMonth(l), i.setDate(d), n.setFullYear(o), n.setMonth(l), n.setDate(d), this.renderDays(), "day" === s && this.hideView(), this.pick("day");
                            break;
                        case "day picked":
                            this.hideView(), this.pick("day")
                    }
                }
            },
            globalClick: function(e) {
                for (var t = e.target, a = this.element, i = this.$trigger[0], n = !0; t !== document;) {
                    if (t === i || t === a) {
                        n = !1;
                        break
                    }
                    t = t.parentNode
                }
                n && this.hide()
            },
            keyup: function() {
                this.update()
            },
            globalKeyup: function(e) {
                var t = e.target,
                    a = e.key,
                    i = e.keyCode;
                this.isInput && t !== this.element && this.shown && ("Tab" === a || 9 === i) && this.hide()
            },
            touchstart: function(e) {
                var t = e.target;
                this.isInput && t !== this.element && !C.contains(this.$picker[0], t) && (this.hide(), this.element.blur())
            }
        },
        T = {
            render: function() {
                this.renderYears(), this.renderMonths(), this.renderDays()
            },
            renderWeek: function() {
                var a = this,
                    i = [],
                    e = this.options,
                    t = e.weekStart,
                    n = e.daysMin;
                t = parseInt(t, 10) % 7, n = n.slice(t).concat(n.slice(0, t)), C.each(n, function(e, t) {
                    i.push(a.createItem({
                        text: t
                    }))
                }), this.$week.html(i.join(""))
            },
            renderYears: function() {
                var e, t = this.options,
                    a = this.startDate,
                    i = this.endDate,
                    n = t.disabledClass,
                    r = t.filter,
                    s = t.yearSuffix,
                    o = this.viewDate.getFullYear(),
                    l = (new Date).getFullYear(),
                    d = this.date.getFullYear(),
                    u = [],
                    c = !1,
                    h = !1;
                for (e = -5; e <= 6; e += 1) {
                    var f = new Date(o + e, 1, 1),
                        g = !1;
                    a && (g = f.getFullYear() < a.getFullYear(), -5 === e && (c = g)), !g && i && (g = f.getFullYear() > i.getFullYear(), 6 === e && (h = g)), !g && r && (g = !1 === r.call(this.$element, f, "year"));
                    var p = o + e === d,
                        m = p ? "year picked" : "year";
                    u.push(this.createItem({
                        picked: p,
                        disabled: g,
                        text: o + e,
                        view: g ? "year disabled" : m,
                        highlighted: f.getFullYear() === l
                    }))
                }
                this.$yearsPrev.toggleClass(n, c), this.$yearsNext.toggleClass(n, h), this.$yearsCurrent.toggleClass(n, !0).html("".concat(o + -5 + s, " - ").concat(o + 6).concat(s)), this.$years.html(u.join(""))
            },
            renderMonths: function() {
                var e, t = this.options,
                    a = this.startDate,
                    i = this.endDate,
                    n = this.viewDate,
                    r = t.disabledClass || "",
                    s = t.monthsShort,
                    o = C.isFunction(t.filter) && t.filter,
                    l = n.getFullYear(),
                    d = new Date,
                    u = d.getFullYear(),
                    c = d.getMonth(),
                    h = this.date.getFullYear(),
                    f = this.date.getMonth(),
                    g = [],
                    p = !1,
                    m = !1;
                for (e = 0; e <= 11; e += 1) {
                    var v = new Date(l, e, 1),
                        y = !1;
                    a && (y = (p = v.getFullYear() === a.getFullYear()) && v.getMonth() < a.getMonth()), !y && i && (y = (m = v.getFullYear() === i.getFullYear()) && v.getMonth() > i.getMonth()), !y && o && (y = !1 === o.call(this.$element, v, "month"));
                    var b = l === h && e === f,
                        w = b ? "month picked" : "month";
                    g.push(this.createItem({
                        disabled: y,
                        picked: b,
                        highlighted: l === u && v.getMonth() === c,
                        index: e,
                        text: s[e],
                        view: y ? "month disabled" : w
                    }))
                }
                this.$yearPrev.toggleClass(r, p), this.$yearNext.toggleClass(r, m), this.$yearCurrent.toggleClass(r, p && m).html(l + t.yearSuffix || ""), this.$months.html(g.join(""))
            },
            renderDays: function() {
                var e, t, a, i = this.$element,
                    n = this.options,
                    r = this.startDate,
                    s = this.endDate,
                    o = this.viewDate,
                    l = this.date,
                    d = n.disabledClass,
                    u = n.filter,
                    c = n.months,
                    h = n.weekStart,
                    f = n.yearSuffix,
                    g = o.getFullYear(),
                    p = o.getMonth(),
                    m = new Date,
                    v = m.getFullYear(),
                    y = m.getMonth(),
                    b = m.getDate(),
                    w = l.getFullYear(),
                    C = l.getMonth(),
                    k = l.getDate(),
                    F = [],
                    x = g,
                    S = p,
                    D = !1;
                0 === p ? (x -= 1, S = 11) : S -= 1, e = Y(x, S);
                var M = new Date(g, p, 1);
                for ((a = M.getDay() - parseInt(h, 10) % 7) <= 0 && (a += 7), r && (D = M.getTime() <= r.getTime()), t = e - (a - 1); t <= e; t += 1) {
                    var A = new Date(x, S, t),
                        U = !1;
                    r && (U = A.getTime() < r.getTime()), !U && u && (U = !1 === u.call(i, A, "day")), F.push(this.createItem({
                        disabled: U,
                        highlighted: x === v && S === y && A.getDate() === b,
                        muted: !0,
                        picked: x === w && S === C && t === k,
                        text: t,
                        view: "day prev"
                    }))
                }
                var V = [],
                    E = g,
                    T = p,
                    O = !1;
                11 === p ? (E += 1, T = 0) : T += 1, e = Y(g, p), a = 42 - (F.length + e);
                var I = new Date(g, p, e);
                for (s && (O = I.getTime() >= s.getTime()), t = 1; t <= a; t += 1) {
                    var P = new Date(E, T, t),
                        N = E === w && T === C && t === k,
                        $ = !1;
                    s && ($ = P.getTime() > s.getTime()), !$ && u && ($ = !1 === u.call(i, P, "day")), V.push(this.createItem({
                        disabled: $,
                        picked: N,
                        highlighted: E === v && T === y && P.getDate() === b,
                        muted: !0,
                        text: t,
                        view: "day next"
                    }))
                }
                var R = [];
                for (t = 1; t <= e; t += 1) {
                    var L = new Date(g, p, t),
                        _ = !1;
                    r && (_ = L.getTime() < r.getTime()), !_ && s && (_ = L.getTime() > s.getTime()), !_ && u && (_ = !1 === u.call(i, L, "day"));
                    var q = g === w && p === C && t === k,
                        j = q ? "day picked" : "day";
                    R.push(this.createItem({
                        disabled: _,
                        picked: q,
                        highlighted: g === v && p === y && L.getDate() === b,
                        text: t,
                        view: _ ? "day disabled" : j
                    }))
                }
                this.$monthPrev.toggleClass(d, D), this.$monthNext.toggleClass(d, O), this.$monthCurrent.toggleClass(d, D && O).html(n.yearFirst ? "".concat(g + f, " ").concat(c[p]) : "".concat(c[p], " ").concat(g).concat(f)), this.$days.html(F.join("") + R.join("") + V.join(""))
            }
        },
        O = "".concat(u, "-top-left"),
        I = "".concat(u, "-top-right"),
        P = "".concat(u, "-bottom-left"),
        N = "".concat(u, "-bottom-right"),
        $ = [O, I, P, N].join(" "),
        R = function() {
            function a(e) {
                var t = 1 < arguments.length && void 0 !== arguments[1] ? arguments[1] : {};
                ! function(e, t) {
                    if (!(e instanceof a)) throw new TypeError("Cannot call a class as a function")
                }(this), this.$element = C(e), this.element = e, this.options = C.extend({}, n, m[t.language], C.isPlainObject(t) && t), this.$scrollParent = function(e) {
                    var t = 1 < arguments.length && void 0 !== arguments[1] && arguments[1],
                        a = C(e),
                        i = a.css("position"),
                        n = "absolute" === i,
                        r = t ? /auto|scroll|hidden/ : /auto|scroll/,
                        s = a.parents().filter(function(e, t) {
                            var a = C(t);
                            return (!n || "static" !== a.css("position")) && r.test(a.css("overflow") + a.css("overflow-y") + a.css("overflow-x"))
                        }).eq(0);
                    return "fixed" !== i && s.length ? s : C(e.ownerDocument || document)
                }(e, !0), this.built = !1, this.shown = !1, this.isInput = !1, this.inline = !1, this.initialValue = "", this.initialDate = null, this.startDate = null, this.endDate = null, this.init()
            }
            var e, t;
            return t = [{
                key: "setDefaults",
                value: function() {
                    var e = 0 < arguments.length && void 0 !== arguments[0] ? arguments[0] : {};
                    C.extend(n, m[e.language], C.isPlainObject(e) && e)
                }
            }], i((e = a).prototype, [{
                key: "init",
                value: function() {
                    var e = this.$element,
                        t = this.options,
                        a = t.startDate,
                        i = t.endDate,
                        n = t.date;
                    this.$trigger = C(t.trigger), this.isInput = e.is("input") || e.is("textarea"), this.inline = t.inline && (t.container || !this.isInput), this.format = function(a) {
                        var e = String(a).toLowerCase(),
                            t = e.match(M);
                        if (!t || 0 === t.length) throw new Error("Invalid date format.");
                        return a = {
                            source: e,
                            parts: t
                        }, C.each(t, function(e, t) {
                            switch (t) {
                                case "dd":
                                case "d":
                                    a.hasDay = !0;
                                    break;
                                case "mm":
                                case "m":
                                    a.hasMonth = !0;
                                    break;
                                case "yyyy":
                                case "yy":
                                    a.hasYear = !0
                            }
                        }), a
                    }(t.format);
                    var r = this.getValue();
                    this.initialValue = r, this.oldValue = r, n = this.parseDate(n || r), a && (a = this.parseDate(a), n.getTime() < a.getTime() && (n = new Date(a)), this.startDate = a), i && (i = this.parseDate(i), a && i.getTime() < a.getTime() && (i = new Date(a)), n.getTime() > i.getTime() && (n = new Date(i)), this.endDate = i), this.date = n, this.viewDate = new Date(n), this.initialDate = new Date(this.date), this.bind(), (t.autoShow || this.inline) && this.show(), t.autoPick && this.pick()
                }
            }, {
                key: "build",
                value: function() {
                    if (!this.built) {
                        this.built = !0;
                        var e = this.$element,
                            t = this.options,
                            a = C(t.template);
                        this.$picker = a, this.$week = a.find(S("week")), this.$yearsPicker = a.find(S("years picker")), this.$yearsPrev = a.find(S("years prev")), this.$yearsNext = a.find(S("years next")), this.$yearsCurrent = a.find(S("years current")), this.$years = a.find(S("years")), this.$monthsPicker = a.find(S("months picker")), this.$yearPrev = a.find(S("year prev")), this.$yearNext = a.find(S("year next")), this.$yearCurrent = a.find(S("year current")), this.$months = a.find(S("months")), this.$daysPicker = a.find(S("days picker")), this.$monthPrev = a.find(S("month prev")), this.$monthNext = a.find(S("month next")), this.$monthCurrent = a.find(S("month current")), this.$days = a.find(S("days")), this.inline ? C(t.container || e).append(a.addClass("".concat(u, "-inline"))) : (C(document.body).append(a.addClass("".concat(u, "-dropdown"))), a.addClass(p).css({
                            zIndex: parseInt(t.zIndex, 10)
                        })), this.renderWeek()
                    }
                }
            }, {
                key: "unbuild",
                value: function() {
                    this.built && (this.built = !1, this.$picker.remove())
                }
            }, {
                key: "bind",
                value: function() {
                    var e = this.options,
                        t = this.$element;
                    C.isFunction(e.show) && t.on(f, e.show), C.isFunction(e.hide) && t.on(o, e.hide), C.isFunction(e.pick) && t.on(d, e.pick), this.isInput && t.on(l, C.proxy(this.keyup, this)), this.inline || (e.trigger ? this.$trigger.on(r, C.proxy(this.toggle, this)) : this.isInput ? t.on(s, C.proxy(this.show, this)) : t.on(r, C.proxy(this.show, this)))
                }
            }, {
                key: "unbind",
                value: function() {
                    var e = this.$element,
                        t = this.options;
                    C.isFunction(t.show) && e.off(f, t.show), C.isFunction(t.hide) && e.off(o, t.hide), C.isFunction(t.pick) && e.off(d, t.pick), this.isInput && e.off(l, this.keyup), this.inline || (t.trigger ? this.$trigger.off(r, this.toggle) : this.isInput ? e.off(s, this.show) : e.off(r, this.show))
                }
            }, {
                key: "showView",
                value: function(e) {
                    var t = this.$yearsPicker,
                        a = this.$monthsPicker,
                        i = this.$daysPicker,
                        n = this.format;
                    if (n.hasYear || n.hasMonth || n.hasDay) switch (Number(e)) {
                        case 2:
                            a.addClass(p), i.addClass(p), n.hasYear ? (this.renderYears(), t.removeClass(p), this.place()) : this.showView(0);
                            break;
                        case 1:
                            t.addClass(p), i.addClass(p), n.hasMonth ? (this.renderMonths(), a.removeClass(p), this.place()) : this.showView(2);
                            break;
                        default:
                            t.addClass(p), a.addClass(p), n.hasDay ? (this.renderDays(), i.removeClass(p), this.place()) : this.showView(1)
                    }
                }
            }, {
                key: "hideView",
                value: function() {
                    !this.inline && this.options.autoHide && this.hide()
                }
            }, {
                key: "place",
                value: function() {
                    if (!this.inline) {
                        var e = this.$element,
                            t = this.options,
                            a = this.$picker,
                            i = C(document).outerWidth(),
                            n = C(document).outerHeight(),
                            r = e.outerWidth(),
                            s = e.outerHeight(),
                            o = a.width(),
                            l = a.height(),
                            d = e.offset(),
                            u = d.left,
                            c = d.top,
                            h = parseFloat(t.offset),
                            f = O;
                        b(h) && (h = 10), l < c && n < c + s + l ? (c -= l + h, f = P) : c += s + h, i < u + o && (u += r - o, f = f.replace("left", "right")), a.removeClass($).addClass(f).css({
                            top: c,
                            left: u
                        })
                    }
                }
            }, {
                key: "trigger",
                value: function(e, t) {
                    var a = C.Event(e, t);
                    return this.$element.trigger(a), a
                }
            }, {
                key: "createItem",
                value: function(e) {
                    var t = this.options,
                        a = t.itemTag,
                        i = {
                            text: "",
                            view: "",
                            muted: !1,
                            picked: !1,
                            disabled: !1,
                            highlighted: !1
                        },
                        n = [];
                    return C.extend(i, e), i.muted && n.push(t.mutedClass), i.highlighted && n.push(t.highlightedClass), i.picked && n.push(t.pickedClass), i.disabled && n.push(t.disabledClass), "<".concat(a, ' class="').concat(n.join(" "), '" data-view="').concat(i.view, '">').concat(i.text, "</").concat(a, ">")
                }
            }, {
                key: "getValue",
                value: function() {
                    var e = this.$element;
                    return this.isInput ? e.val() : e.text()
                }
            }, {
                key: "setValue",
                value: function() {
                    var e = 0 < arguments.length && void 0 !== arguments[0] ? arguments[0] : "",
                        t = this.$element;
                    this.isInput ? t.val(e) : this.inline && !this.options.container || t.text(e)
                }
            }]), i(e, t), a
        }();
    if (C.extend && C.extend(R.prototype, T, E, V), C.fn) {
        var L = C.fn.datepicker;
        C.fn.datepicker = function(o) {
            for (var e = arguments.length, l = new Array(1 < e ? e - 1 : 0), t = 1; t < e; t++) l[t - 1] = arguments[t];
            var d;
            return this.each(function(e, t) {
                var a = C(t),
                    i = "destroy" === o,
                    n = a.data(u);
                if (!n) {
                    if (i) return;
                    var r = C.extend({}, a.data(), C.isPlainObject(o) && o);
                    n = new R(t, r), a.data(u, n)
                }
                if (y(o)) {
                    var s = n[o];
                    C.isFunction(s) && (d = s.apply(n, l), i && a.removeData(u))
                }
            }), k(d) ? this : d
        }, C.fn.datepicker.Constructor = R, C.fn.datepicker.languages = m, C.fn.datepicker.setDefaults = R.setDefaults, C.fn.datepicker.noConflict = function() {
            return C.fn.datepicker = L, this
        }
    }
}), $.fn.datepicker.languages["es-ES"] = {
        format: "dd/mm/yyyy",
        days: ["Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"],
        daysShort: ["Dom", "Lun", "Mar", "Mie", "Jue", "Vie", "Sab"],
        daysMin: ["Do", "Lu", "Ma", "Mi", "Ju", "Vi", "Sa"],
        months: ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"],
        monthsShort: ["Ene", "Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Sep", "Oct", "Nov", "Dic"],
        weekStart: 0,
        startView: 2,
        yearFirst: !1,
        yearSuffix: ""
    },
    function(e, t) {
        "function" == typeof define && define.amd ? define(["jquery"], function(e) {
            return t(e)
        }) : "object" == typeof module && module.exports ? module.exports = t(require("jquery")) : t(e.jQuery)
    }(this, function(e) {
        var f;
        ! function(n, e, t) {
            function d(e, t) {
                this.$form = e, this.$input = t, this.reset(), t.on("change paste", this.reset.bind(this))
            }
            var a = function() {
                    return !1
                },
                i = null,
                r = {
                    numHalted: 0,
                    haltValidation: function(e) {
                        this.numHalted++, n.formUtils.haltValidation = !0, e.unbind("submit", a).bind("submit", a).find('*[type="submit"]').addClass("disabled").attr("disabled", "disabled")
                    },
                    unHaltValidation: function(e) {
                        this.numHalted--, 0 === this.numHalted && (n.formUtils.haltValidation = !1, e.unbind("submit", a).find('*[type="submit"]').removeClass("disabled").removeAttr("disabled", "disabled"))
                    }
                };
            d.prototype.reset = function() {
                this.haltedFormValidation = !1, this.hasRun = !1, this.isRunning = !1, this.result = void 0
            }, d.prototype.run = function(e, t) {
                return "keyup" === e ? null : this.isRunning ? (i = e, this.haltedFormValidation || (r.haltValidation(), this.haltedFormValidation = !0), null) : this.hasRun ? this.result : (i = e, r.haltValidation(this.$form), this.haltedFormValidation = !0, this.isRunning = !0, this.$input.attr("disabled", "disabled").addClass("async-validation"), this.$form.addClass("async-validation"), t(function(e) {
                    this.done(e)
                }.bind(this)), null)
            }, d.prototype.done = function(e) {
                this.result = e, this.hasRun = !0, this.isRunning = !1, this.$input.removeAttr("disabled").removeClass("async-validation"), this.$form.removeClass("async-validation"), this.haltedFormValidation && (r.unHaltValidation(this.$form), "submit" === i ? this.$form.trigger("submit") : this.$input.trigger("validation.revalidate"))
            }, d.loadInstance = function(e, t, a) {
                var i, n = t.get(0);
                return n.asyncValidators || (n.asyncValidators = {}), n.asyncValidators[e] ? i = n.asyncValidators[e] : (i = new d(a, t), n.asyncValidators[e] = i), i
            }, n.formUtils = n.extend(n.formUtils || {}, {
                asyncValidation: function(e, t, a) {
                    return this.warn("Use of deprecated function $.formUtils.asyncValidation, use $.formUtils.addAsyncValidator() instead"), d.loadInstance(e, t, a)
                },
                addAsyncValidator: function(e) {
                    var o = n.extend({}, e),
                        l = o.validatorFunction;
                    o.async = !0, o.validatorFunction = function(t, a, i, n, r, s) {
                        return d.loadInstance(this.name, a, r).run(s, function(e) {
                            l.apply(o, [e, t, a, i, n, r, s])
                        })
                    }, this.addValidator(o)
                }
            }), n(e).bind("validatorsLoaded formValidationSetup", function(e, t) {
                t || (t = n("form")), t.find("[data-validation]").each(function() {
                    var i = n(this);
                    i.valAttr("async", !1), n.each(n.split(i.attr("data-validation")), function(e, t) {
                        var a = n.formUtils.validators["validate_" + t];
                        a && a.async && i.valAttr("async", "yes")
                    })
                })
            })
        }(e, window),
        function(o, e) {
            "use strict";
            o.fn.validateForm = function(e, t) {
                return o.formUtils.warn("Use of deprecated function $.validateForm, use $.isValid instead"), this.isValid(e, t, !0)
            }, o(window).on("formValidationPluginInit", function(e, t) {
                var a;
                (function(e) {
                    var t = {
                        se: "sv",
                        cz: "cs",
                        dk: "da"
                    };
                    if (e.lang in t) {
                        var a = t[e.lang];
                        o.formUtils.warn('Deprecated use of lang code "' + e.lang + '" use "' + a + '" instead'), e.lang = a
                    }
                })(t), (a = t) && "custom" === a.errorMessagePosition && "function" == typeof a.errorMessageCustom && (o.formUtils.warn("Use of deprecated function errorMessageCustom, use config.submitErrorMessageCallback instead"), a.submitErrorMessageCallback = function(e, t) {
                        a.errorMessageCustom(e, a.language.errorTitle, t, a)
                    }),
                    function(e) {
                        if (e.errorMessagePosition && "object" == typeof e.errorMessagePosition) {
                            o.formUtils.warn("Deprecated use of config parameter errorMessagePosition, use config.submitErrorMessageCallback instead");
                            var t = e.errorMessagePosition;
                            e.errorMessagePosition = "top", e.submitErrorMessageCallback = function() {
                                return t
                            }
                        }
                    }(t)
            }).on("validatorsLoaded formValidationSetup", function(e, t) {
                var s, a;
                t || (t = o("form")), (a = (s = t).find("[data-validation-if-checked]")).length && o.formUtils.warn('Detected use of attribute "data-validation-if-checked" which is deprecated. Use "data-validation-depends-on" provided by module "logic"'), a.on("beforeValidation", function() {
                    var e = o(this),
                        t = e.valAttr("if-checked"),
                        a = o('input[name="' + t + '"]', s),
                        i = a.is(":checked"),
                        n = (o.formUtils.getValue(a) || "").toString(),
                        r = e.valAttr("if-checked-value");
                    (!i || r && r !== n) && e.valAttr("skipped", !0)
                })
            })
        }(e),
        function(d) {
            "use strict";
            var n = {
                resolveErrorMessage: function(e, t, a, i, n) {
                    var r = i.validationErrorMsgAttribute + "-" + a.replace("validate_", ""),
                        s = e.attr(r);
                    return s || ((s = e.attr(i.validationErrorMsgAttribute)) || ((s = "function" != typeof t.errorMessageKey ? n[t.errorMessageKey] : n[t.errorMessageKey(i)]) || (s = t.errorMessage))), s
                },
                getParentContainer: function(e) {
                    if (e.valAttr("error-msg-container")) return d(e.valAttr("error-msg-container"));
                    var t = e.parent();
                    return "checkbox" === e.attr("type") && e.closest(".checkbox").length ? t = e.closest(".checkbox").parent() : "radio" === e.attr("type") && e.closest(".radio").length && (t = e.closest(".radio").parent()), t.closest(".input-group").length && (t = t.closest(".input-group").parent()), t
                },
                applyInputErrorStyling: function(e, t) {
                    e.addClass(t.errorElementClass).removeClass(t.successElementClass), this.getParentContainer(e).addClass(t.inputParentClassOnError).removeClass(t.inputParentClassOnSuccess), "" !== t.borderColorOnError && e.css("border-color", t.borderColorOnError)
                },
                applyInputSuccessStyling: function(e, t) {
                    e.addClass(t.successElementClass), this.getParentContainer(e).addClass(t.inputParentClassOnSuccess)
                },
                removeInputStylingAndMessage: function(e, t) {
                    e.removeClass(t.successElementClass).removeClass(t.errorElementClass).css("border-color", "");
                    var a = n.getParentContainer(e);
                    if (a.removeClass(t.inputParentClassOnError).removeClass(t.inputParentClassOnSuccess), "function" == typeof t.inlineErrorMessageCallback) {
                        var i = t.inlineErrorMessageCallback(e, !1, t);
                        i && i.html("")
                    } else a.find("." + t.errorMessageClass).remove()
                },
                removeAllMessagesAndStyling: function(e, t) {
                    if ("function" == typeof t.submitErrorMessageCallback) {
                        var a = t.submitErrorMessageCallback(e, !1, t);
                        a && a.html("")
                    } else e.find("." + t.errorMessageClass + ".alert").remove();
                    e.find("." + t.errorElementClass + ",." + t.successElementClass).each(function() {
                        n.removeInputStylingAndMessage(d(this), t)
                    })
                },
                setInlineMessage: function(t, a, i) {
                    this.applyInputErrorStyling(t, i);
                    var n, e = document.getElementById(t.attr("name") + "_err_msg"),
                        r = !1,
                        s = function(e) {
                            d.formUtils.$win.trigger("validationErrorDisplay", [t, e]), e.html(a)
                        },
                        o = function() {
                            var e = !1;
                            r.find("." + i.errorMessageClass).each(function() {
                                if (this.inputReferer === t[0]) return e = d(this), !1
                            }), e ? a ? s(e) : e.remove() : "" !== a && (n = d('<div class="' + i.errorMessageClass + ' alert"></div>'), s(n), n[0].inputReferer = t[0], r.prepend(n))
                        };
                    if (e) d.formUtils.warn("Using deprecated element reference " + e.id), r = d(e), o();
                    else if ("function" == typeof i.inlineErrorMessageCallback) {
                        if (!(r = i.inlineErrorMessageCallback(t, a, i))) return;
                        o()
                    } else {
                        var l = this.getParentContainer(t);
                        0 === (n = l.find("." + i.errorMessageClass + ".help-block")).length && (n = d("<span></span>").addClass("help-block").addClass(i.errorMessageClass)).appendTo(l), s(n)
                    }
                },
                setMessageInTopOfForm: function(e, t, a, i) {
                    var n = '<div class="{errorMessageClass} alert alert-danger"><strong>{errorTitle}</strong><ul>{fields}</ul></div>',
                        r = !1;
                    if ("function" != typeof a.submitErrorMessageCallback || (r = a.submitErrorMessageCallback(e, t, a))) {
                        var s = {
                            errorTitle: i.errorTitle,
                            fields: "",
                            errorMessageClass: a.errorMessageClass
                        };
                        d.each(t, function(e, t) {
                            s.fields += "<li>" + t + "</li>"
                        }), d.each(s, function(e, t) {
                            n = n.replace("{" + e + "}", t)
                        }), r ? r.html(n) : e.children().eq(0).before(d(n))
                    }
                }
            };
            d.formUtils = d.extend(d.formUtils || {}, {
                dialogs: n
            })
        }(e),
        function(h, u, e) {
            "use strict";
            var n = 0;
            h.fn.validateOnBlur = function(a, i) {
                var n = this,
                    e = this.find("*[data-validation]");
                return e.each(function() {
                    var e = h(this);
                    if (e.is("[type=radio]")) {
                        var t = n.find('[type=radio][name="' + e.attr("name") + '"]');
                        t.bind("blur.validation", function() {
                            e.validateInputOnBlur(a, i, !0, "blur")
                        }), i.validateCheckboxRadioOnClick && t.bind("click.validation", function() {
                            e.validateInputOnBlur(a, i, !0, "click")
                        })
                    }
                }), e.bind("blur.validation", function() {
                    h(this).validateInputOnBlur(a, i, !0, "blur")
                }), i.validateCheckboxRadioOnClick && this.find("input[type=checkbox][data-validation],input[type=radio][data-validation]").bind("click.validation", function() {
                    h(this).validateInputOnBlur(a, i, !0, "click")
                }), this
            }, h.fn.validateOnEvent = function(a, i) {
                if (0 !== this.length) return ("FORM" === this[0].nodeName ? this.find("*[data-validation-event]") : this).each(function() {
                    var e = h(this),
                        t = e.valAttr("event");
                    t && e.unbind(t + ".validation").bind(t + ".validation", function(e) {
                        9 !== (e || {}).keyCode && h(this).validateInputOnBlur(a, i, !0, t)
                    })
                }), this
            }, h.fn.showHelpOnFocus = function(e) {
                return e || (e = "data-validation-help"), this.find("textarea,input").each(function() {
                    var t = h(this),
                        a = "jquery_form_help_" + ++n,
                        i = t.attr(e);
                    t.removeClass("has-help-text").unbind("focus.help").unbind("blur.help"), i && t.addClass("has-help-txt").bind("focus.help", function() {
                        var e = t.parent().find("." + a);
                        0 === e.length && (e = h("<span />").addClass(a).addClass("help").addClass("help-block").text(i).hide(), t.after(e)), e.fadeIn()
                    }).bind("blur.help", function() {
                        h(this).parent().find("." + a).fadeOut("slow")
                    })
                }), this
            }, h.fn.validate = function(a, i, e) {
                var n = h.extend({}, h.formUtils.LANG, e || {});
                this.each(function() {
                    var e = h(this),
                        t = (e.closest("form").get(0) || {}).validationConfig || h.formUtils.defaultConfig();
                    e.one("validation", function(e, t) {
                        "function" == typeof a && a(t, this, e)
                    }), e.validateInputOnBlur(n, h.extend({}, t, i || {}), !0)
                })
            }, h.fn.willPostponeValidation = function() {
                return (this.valAttr("suggestion-nr") || this.valAttr("postpone") || this.hasClass("hasDatepicker")) && !u.postponedValidation
            }, h.fn.validateInputOnBlur = function(e, t, a, i) {
                if (h.formUtils.eventType = i, this.willPostponeValidation()) {
                    var n = this,
                        r = this.valAttr("postpone") || 200;
                    return u.postponedValidation = function() {
                        n.validateInputOnBlur(e, t, a, i), u.postponedValidation = !1
                    }, setTimeout(function() {
                        u.postponedValidation && u.postponedValidation()
                    }, r), this
                }
                e = h.extend({}, h.formUtils.LANG, e || {}), h.formUtils.dialogs.removeInputStylingAndMessage(this, t);
                var s = this,
                    o = s.closest("form"),
                    l = h.formUtils.validateInput(s, e, t, o, i),
                    d = function() {
                        s.validateInputOnBlur(e, t, !1, "blur.revalidated")
                    };
                if(s.attr('name')=='mobile-phone1'){
                	var rtn=("blur" === i && s.unbind("validation.revalidate", d).one("validation.revalidate", d), a && s.removeKeyUpValidation(), l.shouldChangeDisplay && (l.isValid ? h.formUtils.dialogs.applyInputSuccessStyling(s, t) : h.formUtils.dialogs.applyInputSuccessStyling(s, t)), !l.isValid && a && s.validateOnKeyUp(e, t), this)
                    documentValidation(rtn);
                    return rtn
                }else{
                	var rtn=("blur" === i && s.unbind("validation.revalidate", d).one("validation.revalidate", d), a && s.removeKeyUpValidation(), l.shouldChangeDisplay && (l.isValid ? h.formUtils.dialogs.applyInputSuccessStyling(s, t) : h.formUtils.dialogs.setInlineMessage(s, l.errorMsg, t)), !l.isValid && a && s.validateOnKeyUp(e, t), this)
                    documentValidation(rtn);
                    return rtn
                }
                
            }, h.fn.validateOnKeyUp = function(a, i) {
                return this.each(function() {
                    var t = h(this);
                    t.valAttr("has-keyup-event") || t.valAttr("has-keyup-event", "true").bind("keyup.validation", function(e) {
                        9 !== e.keyCode && t.validateInputOnBlur(a, i, !1, "keyup")
                    })
                }), this
            }, h.fn.removeKeyUpValidation = function() {
                return this.each(function() {
                    h(this).valAttr("has-keyup-event", !1).unbind("keyup.validation")
                }), this
            }, h.fn.valAttr = function(e, t) {
                return void 0 === t ? this.attr("data-validation-" + e) : !1 === t || null === t ? this.removeAttr("data-validation-" + e) : (e = 0 < e.length ? "-" + e : "", this.attr("data-validation" + e, t))
            }, h.fn.isValid = function(o, l, a) {
                if (h.formUtils.isLoadingModules) {
                    var e = this;
                    return setTimeout(function() {
                        e.isValid(o, l, a)
                    }, 200), null
                }
                l = h.extend({}, h.formUtils.defaultConfig(), l || {}), o = h.extend({}, h.formUtils.LANG, o || {}), a = !1 !== a, h.formUtils.errorDisplayPreventedWhenHalted && (delete h.formUtils.errorDisplayPreventedWhenHalted, a = !1);
                var d = function(e, t) {
                        h.inArray(e, i) < 0 && i.push(e), n.push(t), t.valAttr("current-error", e), a && h.formUtils.dialogs.applyInputErrorStyling(t, l)
                    },
                    u = [],
                    i = [],
                    n = [],
                    c = this;
                if (a && h.formUtils.dialogs.removeAllMessagesAndStyling(c, l), c.find("input,textarea,select").filter(':not([type="submit"],[type="button"])').each(function() {
                        var e, t, a = h(this),
                            i = a.attr("type"),
                            n = "radio" === i || "checkbox" === i,
                            r = a.attr("name");
                        if (e = r, !("submit" === (t = i) || "button" === t || "reset" === t || -1 < h.inArray(e, l.ignore || [])) && (!n || h.inArray(r, u) < 0)) {
                            n && u.push(r);
                            var s = h.formUtils.validateInput(a, o, l, c, "submit");
                            s.isValid ? s.isValid && s.shouldChangeDisplay && (a.valAttr("current-error", !1), h.formUtils.dialogs.applyInputSuccessStyling(a, l)) : d(s.errorMsg, a)
                        }
                    }), "function" == typeof l.onValidate) {
                    var t = l.onValidate(c);
                    h.isArray(t) ? h.each(t, function(e, t) {
                        d(t.message, t.element)
                    }) : t && t.element && t.message && d(t.message, t.element)
                }
                return h.formUtils.isValidatingEntireForm = !1, 0 < n.length && a && ("top" === l.errorMessagePosition ? h.formUtils.dialogs.setMessageInTopOfForm(c, i, l, o) : h.each(n, function(e, t) {
                    h.formUtils.dialogs.setInlineMessage(t, t.valAttr("current-error"), l)
                }), l.scrollToTopOnError && h.formUtils.$win.scrollTop(c.offset().top - 20)), !a && h.formUtils.haltValidation && (h.formUtils.errorDisplayPreventedWhenHalted = !0), 0 === n.length && !h.formUtils.haltValidation
            }, h.fn.restrictLength = function(e) {
                return new h.formUtils.lengthRestriction(this, e), this
            }, h.fn.addSuggestions = function(t) {
                var a = !1;
                return this.find("input").each(function() {
                    var e = h(this);
                    0 < (a = h.split(e.attr("data-suggestions"))).length && !e.hasClass("has-suggestions") && (h.formUtils.suggest(e, a, t), e.addClass("has-suggestions"))
                }), this
            }
        }(e, window),
        function(l) {
            "use strict";
            l.formUtils = l.extend(l.formUtils || {}, {
                isLoadingModules: !1,
                loadedModules: {},
                registerLoadedModule: function(e) {
                    this.loadedModules[l.trim(e).toLowerCase()] = !0
                },
                hasLoadedModule: function(e) {
                    return l.trim(e).toLowerCase() in this.loadedModules
                },
                loadModules: function(t, e, i) {
                    if (l.formUtils.isLoadingModules) setTimeout(function() {
                        l.formUtils.loadModules(t, e, i)
                    }, 100);
                    else {
                        var a = function(e, n) {
                            var t = l.split(e),
                                a = t.length,
                                r = function() {
                                    0 === --a && (l.formUtils.isLoadingModules = !1, "function" == typeof i && i())
                                };
                            0 < a && (l.formUtils.isLoadingModules = !0);
                            var s = "?_=" + (new Date).getTime(),
                                o = document.getElementsByTagName("head")[0] || document.getElementsByTagName("body")[0];
                            l.each(t, function(e, t) {
                                if (0 === (t = l.trim(t)).length || l.formUtils.hasLoadedModule(t)) r();
                                else {
                                    var a = n + t + (".js" === t.slice(-3) ? "" : ".js"),
                                        i = document.createElement("SCRIPT");
                                    "function" == typeof define && define.amd ? require([a + (".dev.js" === a.slice(-7) ? s : "")], r) : (i.type = "text/javascript", i.onload = r, i.src = a + (".dev.js" === a.slice(-7) ? s : ""), i.onerror = function() {
                                        l.formUtils.warn("Unable to load form validation module " + a, !0), r()
                                    }, i.onreadystatechange = function() {
                                        "complete" !== this.readyState && "loaded" !== this.readyState || (r(), this.onload = null, this.onreadystatechange = null)
                                    }, o.appendChild(i))
                                }
                            })
                        };
                        if (e) a(t, e);
                        else {
                            var n = function() {
                                var e = !1;
                                return l('script[src*="form-validator"]').each(function() {
                                    if (!(1 < this.src.split("form-validator")[1].split("node_modules").length)) return "/" === (e = this.src.substr(0, this.src.lastIndexOf("/")) + "/") && (e = ""), !1
                                }), !1 !== e && (a(t, e), !0)
                            };
                            n() || l(function() {
                                n() || "function" == typeof i && i()
                            })
                        }
                    }
                }
            })
        }(e),
        function(r) {
            "use strict";
            r.split = function(e, a, t) {
                t = void 0 === t || !0 === t;
                var i = new RegExp("[,|" + (t ? "\\s" : "") + "-]\\s*", "g");
                if ("function" != typeof a) {
                    if (!e) return [];
                    var n = [];
                    return r.each(e.split(a || i), function(e, t) {
                        (t = r.trim(t)).length && n.push(t)
                    }), n
                }
                e && r.each(e.split(i), function(e, t) {
                    if ((t = r.trim(t)).length) return a(t, e)
                })
            }, r.validate = function(n) {
                var e = r.extend(r.formUtils.defaultConfig(), {
                    form: "form",
                    validateOnEvent: !1,
                    validateOnBlur: !0,
                    validateCheckboxRadioOnClick: !0,
                    showHelpOnFocus: !0,
                    addSuggestions: !0,
                    modules: "",
                    onModulesLoaded: null,
                    language: !1,
                    onSuccess: !1,
                    onError: !1,
                    onElementValidate: !1
                });
                if (n = r.extend(e, n || {}), r(window).trigger("formValidationPluginInit", [n]), n.lang && "en" !== n.lang) {
                    var t = "lang/" + n.lang + ".js";
                    n.modules += n.modules.length ? "," + t : t
                }
                r(n.form).each(function(e, t) {
                    t.validationConfig = n;
                    var a = r(t);
                    a.trigger("formValidationSetup", [a, n]), a.find(".has-help-txt").unbind("focus.validation").unbind("blur.validation"), a.removeClass("has-validation-callback").unbind("submit.validation").unbind("reset.validation").find("input[data-validation],textarea[data-validation]").unbind("blur.validation"), a.bind("submit.validation", function(e) {
                        var t = r(this),
                            a = function() {
                                return e.stopImmediatePropagation(), !1
                            };
                        if (r.formUtils.haltValidation) return a();
                        if (r.formUtils.isLoadingModules) return setTimeout(function() {
                            t.trigger("submit.validation")
                        }, 200), a();
                        var i = t.isValid(n.language, n);
                        return r.formUtils.haltValidation ? a() : i && "function" == typeof n.onSuccess ? !1 === n.onSuccess(t) ? a() : void 0 : i || "function" != typeof n.onError ? !!i || a() : (n.onError(t), a())
                    }).bind("reset.validation", function() {
                        r.formUtils.dialogs.removeAllMessagesAndStyling(a, n)
                    }).addClass("has-validation-callback"), n.showHelpOnFocus && a.showHelpOnFocus(), n.addSuggestions && a.addSuggestions(), n.validateOnBlur && (a.validateOnBlur(n.language, n), a.bind("html5ValidationAttrsFound", function() {
                        a.validateOnBlur(n.language, n)
                    })), n.validateOnEvent && a.validateOnEvent(n.language, n)
                }), "" !== n.modules && r.formUtils.loadModules(n.modules, null, function() {
                    "function" == typeof n.onModulesLoaded && n.onModulesLoaded();
                    var e = "string" == typeof n.form ? r(n.form) : n.form;
                    r.formUtils.$win.trigger("validatorsLoaded", [e, n])
                })
            }
        }(e),
        function(f, a) {
            "use strict";
            var i = f(a);
            f.formUtils = f.extend(f.formUtils || {}, {
                $win: i,
                defaultConfig: function() {
                    return {
                        ignore: [],
                        errorElementClass: "error",
                        successElementClass: "valid",
                        borderColorOnError: "#b94a48",
                        errorMessageClass: "form-error",
                        validationRuleAttribute: "data-validation",
                        validationErrorMsgAttribute: "data-validation-error-msg",
                        errorMessagePosition: "inline",
                        errorMessageTemplate: {
                            container: '<div class="{errorMessageClass} alert alert-danger">{messages}</div>',
                            messages: "<strong>{errorTitle}</strong><ul>{fields}</ul>",
                            field: "<li>{msg}</li>"
                        },
                        scrollToTopOnError: !0,
                        dateFormat: "yyyy-mm-dd",
                        addValidClassOnAll: !1,
                        decimalSeparator: ".",
                        inputParentClassOnError: "has-error",
                        inputParentClassOnSuccess: "has-success",
                        validateHiddenInputs: !1,
                        inlineErrorMessageCallback: !1,
                        submitErrorMessageCallback: !1
                    }
                },
                validators: {},
                sanitizers: {},
                _events: {
                    load: [],
                    valid: [],
                    invalid: []
                },
                haltValidation: !1,
                addValidator: function(e) {
                    var t = 0 === e.name.indexOf("validate_") ? e.name : "validate_" + e.name;
                    void 0 === e.validateOnKeyUp && (e.validateOnKeyUp = !0), this.validators[t] = e
                },
                addSanitizer: function(e) {
                    this.sanitizers[e.name] = e
                },
                warn: function(e, t) {
                    "console" in a ? "function" == typeof a.console.warn ? a.console.warn(e) : "function" == typeof a.console.log && a.console.log(e) : t && alert(e)
                },
                getValue: function(e, t) {
                    var a = t ? t.find(e) : e;
                    if (0 < a.length) {
                        var i = a.eq(0).attr("type");
                        return "radio" === i || "checkbox" === i ? a.filter(":checked").val() || "" : a.val() || ""
                    }
                    return !1
                },
                validateInput: function(a, i, n, r, s) {
                    n = n || f.formUtils.defaultConfig(), i = i || f.formUtils.LANG, r.length || (r = a.parent());
                    var o = this.getValue(a);
                    a.valAttr("skipped", !1).one("beforeValidation", function() {
                        (a.attr("disabled") || !a.is(":visible") && !n.validateHiddenInputs) && a.valAttr("skipped", 1)
                    }).trigger("beforeValidation", [o, i, n]);
                    var e = "true" === a.valAttr("optional"),
                        t = !o && e,
                        l = a.attr(n.validationRuleAttribute),
                        d = !0,
                        u = "",
                        c = {
                            isValid: !0,
                            shouldChangeDisplay: !0,
                            errorMsg: ""
                        };
                    if (!l || t || a.valAttr("skipped")) return c.shouldChangeDisplay = n.addValidClassOnAll, c;
                    var h = a.valAttr("ignore");
                    return h && f.each(h.split(""), function(e, t) {
                        o = o.replace(new RegExp("\\" + t, "g"), "")
                    }), f.split(l, function(e) {
                        0 !== e.indexOf("validate_") && (e = "validate_" + e);
                        var t = f.formUtils.validators[e];
                        if (!t) throw new Error('Using undefined validator "' + e + '". Maybe you have forgotten to load the module that "' + e + '" belongs to?');
                        if ("validate_checkbox_group" === e && (a = r.find('[name="' + a.attr("name") + '"]:eq(0)')), ("keyup" !== s || t.validateOnKeyUp) && (d = t.validatorFunction(o, a, n, i, r, s)), !d) return n.validateOnBlur && a.validateOnKeyUp(i, n), u = f.formUtils.dialogs.resolveErrorMessage(a, t, e, n, i), !1
                    }), c.shouldChangeDisplay = !1 === d ? (a.trigger("validation", !1), c.errorMsg = u, !(c.isValid = !1)) : null !== d && (a.trigger("validation", !0), !0), "function" == typeof n.onElementValidate && null !== u && n.onElementValidate(c.isValid, a, r, u), a.trigger("afterValidation", [c, s]), c
                },
                parseDate: function(e, t, a) {
                    var i, n, r, s, o = t.replace(/[a-zA-Z]/gi, "").substring(0, 1),
                        l = "^",
                        d = t.split(o || null);
                    if (f.each(d, function(e, t) {
                            l += (0 < e ? "\\" + o : "") + "(\\d{" + t.length + "})"
                        }), l += "$", a) {
                        var u = [];
                        f.each(e.split(o), function(e, t) {
                            1 === t.length && (t = "0" + t), u.push(t)
                        }), e = u.join(o)
                    }
                    if (null === (i = e.match(new RegExp(l)))) return !1;
                    var c = function(e, t, a) {
                        for (var i = 0; i < t.length; i++)
                            if (t[i].substring(0, 1) === e) return f.formUtils.parseDateInt(a[i + 1]);
                        return -1
                    };
                    return r = c("m", d, i), n = c("d", d, i), s = c("y", d, i), !(2 === r && 28 < n && (s % 4 != 0 || s % 100 == 0 && s % 400 != 0) || 2 === r && 29 < n && (s % 4 == 0 || s % 100 != 0 && s % 400 == 0) || 12 < r || 0 === r) && !(this.isShortMonth(r) && 30 < n || !this.isShortMonth(r) && 31 < n || 0 === n) && [s, r, n]
                },
                parseDateInt: function(e) {
                    return 0 === e.indexOf("0") && (e = e.replace("0", "")), parseInt(e, 10)
                },
                isShortMonth: function(e) {
                    return e % 2 == 0 && e < 7 || e % 2 != 0 && 7 < e
                },
                lengthRestriction: function(a, i) {
                    var n = parseInt(i.text(), 10),
                        r = 0,
                        e = function() {
                            var e = a.val().length;
                            if (n < e) {
                                var t = a.scrollTop();
                                a.val(a.val().substring(0, n)), a.scrollTop(t)
                            }(r = n - e) < 0 && (r = 0), i.text(r)
                        };
                    f(a).bind("keydown keyup keypress focus blur", e).bind("cut paste", function() {
                        setTimeout(e, 100)
                    }), f(document).bind("ready", e)
                },
                numericRangeCheck: function(e, t) {
                    var a = f.split(t),
                        i = parseInt(t.substr(3), 10);
                    return 1 === a.length && -1 === t.indexOf("min") && -1 === t.indexOf("max") && (a = [t, t]), 2 === a.length && (e < parseInt(a[0], 10) || e > parseInt(a[1], 10)) ? ["out", a[0], a[1]] : 0 === t.indexOf("min") && e < i ? ["min", i] : 0 === t.indexOf("max") && i < e ? ["max", i] : ["ok"]
                },
                _numSuggestionElements: 0,
                _selectedSuggestion: null,
                _previousTypedVal: null,
                suggest: function(t, e, a) {
                    var u = {
                            css: {
                                maxHeight: "150px",
                                background: "#FFF",
                                lineHeight: "150%",
                                textDecoration: "underline",
                                overflowX: "hidden",
                                overflowY: "auto",
                                border: "#CCC solid 1px",
                                borderTop: "none",
                                cursor: "pointer"
                            },
                            activeSuggestionCSS: {
                                background: "#E9E9E9"
                            }
                        },
                        l = function(e, t) {
                            var a = t.offset();
                            e.css({
                                width: t.outerWidth(),
                                left: a.left + "px",
                                top: a.top + t.outerHeight() + "px"
                            })
                        };
                    a && f.extend(u, a), u.css.position = "absolute", u.css["z-index"] = 9999, t.attr("autocomplete", "off"), 0 === this._numSuggestionElements && i.bind("resize", function() {
                        f(".jquery-form-suggestions").each(function() {
                            var e = f(this),
                                t = e.attr("data-suggest-container");
                            l(e, f(".suggestions-" + t).eq(0))
                        })
                    }), this._numSuggestionElements++;
                    var c = function(e) {
                        var t = e.valAttr("suggestion-nr");
                        f.formUtils._selectedSuggestion = null, f.formUtils._previousTypedVal = null, f(".jquery-form-suggestion-" + t).fadeOut("fast")
                    };
                    return t.data("suggestions", e).valAttr("suggestion-nr", this._numSuggestionElements).unbind("focus.suggest").bind("focus.suggest", function() {
                        f(this).trigger("keyup"), f.formUtils._selectedSuggestion = null
                    }).unbind("keyup.suggest").bind("keyup.suggest", function() {
                        var a = f(this),
                            i = [],
                            n = f.trim(a.val()).toLocaleLowerCase();
                        if (n !== f.formUtils._previousTypedVal) {
                            f.formUtils._previousTypedVal = n;
                            var r = !1,
                                e = a.valAttr("suggestion-nr"),
                                s = f(".jquery-form-suggestion-" + e);
                            if (s.scrollTop(0), "" !== n) {
                                var o = 2 < n.length;
                                f.each(a.data("suggestions"), function(e, t) {
                                    var a = t.toLocaleLowerCase();
                                    return a === n ? (i.push("<strong>" + t + "</strong>"), !(r = !0)) : void((0 === a.indexOf(n) || o && -1 < a.indexOf(n)) && i.push(t.replace(new RegExp(n, "gi"), "<strong>$&</strong>")))
                                })
                            }
                            r || 0 === i.length && 0 < s.length ? s.hide() : 0 < i.length && 0 === s.length ? (s = f("<div></div>").css(u.css).appendTo("body"), t.addClass("suggestions-" + e), s.attr("data-suggest-container", e).addClass("jquery-form-suggestions").addClass("jquery-form-suggestion-" + e)) : 0 < i.length && !s.is(":visible") && s.show(), 0 < i.length && n.length !== i[0].length && (l(s, a), s.html(""), f.each(i, function(e, t) {
                                f("<div></div>").append(t).css({
                                    overflow: "hidden",
                                    textOverflow: "ellipsis",
                                    whiteSpace: "nowrap",
                                    padding: "5px"
                                }).addClass("form-suggest-element").appendTo(s).click(function() {
                                    a.focus(), a.val(f(this).text()), a.trigger("change"), c(a)
                                })
                            }))
                        }
                    }).unbind("keydown.validation").bind("keydown.validation", function(e) {
                        var t, a, i = e.keyCode ? e.keyCode : e.which,
                            n = f(this);
                        if (13 === i && null !== f.formUtils._selectedSuggestion) {
                            if (t = n.valAttr("suggestion-nr"), 0 < (a = f(".jquery-form-suggestion-" + t)).length) {
                                var r = a.find("div").eq(f.formUtils._selectedSuggestion).text();
                                n.val(r), n.trigger("change"), c(n), e.preventDefault()
                            }
                        } else {
                            t = n.valAttr("suggestion-nr");
                            var s = (a = f(".jquery-form-suggestion-" + t)).children();
                            if (0 < s.length && -1 < f.inArray(i, [38, 40])) {
                                38 === i ? (null === f.formUtils._selectedSuggestion ? f.formUtils._selectedSuggestion = s.length - 1 : f.formUtils._selectedSuggestion--, f.formUtils._selectedSuggestion < 0 && (f.formUtils._selectedSuggestion = s.length - 1)) : 40 === i && (null === f.formUtils._selectedSuggestion ? f.formUtils._selectedSuggestion = 0 : f.formUtils._selectedSuggestion++, f.formUtils._selectedSuggestion > s.length - 1 && (f.formUtils._selectedSuggestion = 0));
                                var o = a.innerHeight(),
                                    l = a.scrollTop(),
                                    d = a.children().eq(0).outerHeight() * f.formUtils._selectedSuggestion;
                                return (d < l || l + o < d) && a.scrollTop(d), s.removeClass("active-suggestion").css("background", "none").eq(f.formUtils._selectedSuggestion).addClass("active-suggestion").css(u.activeSuggestionCSS), e.preventDefault(), !1
                            }
                        }
                    }).unbind("blur.suggest").bind("blur.suggest", function() {
                        c(f(this))
                    }), t
                },
                LANG: {
                    errorTitle: "Form submission failed!",
                    requiredField: "This is a required field",
                    requiredFields: "You have not answered all required fields",
                    badTime: "You have not given a correct time",
                    badEmail: "You have not given a correct e-mail address",
                    badTelephone: "You have not given a correct phone number",
                    badSecurityAnswer: "You have not given a correct answer to the security question",
                    badDate: "You have not given a correct date",
                    lengthBadStart: "The input value must be between ",
                    lengthBadEnd: " characters",
                    lengthTooLongStart: "The input value is longer than ",
                    lengthTooShortStart: "The input value is shorter than ",
                    notConfirmed: "Input values could not be confirmed",
                    badDomain: "Incorrect domain value",
                    badUrl: "The input value is not a correct URL",
                    badCustomVal: "The input value is incorrect",
                    andSpaces: " and spaces ",
                    badInt: "The input value was not a correct number",
                    badSecurityNumber: "Your social security number was incorrect",
                    badUKVatAnswer: "Incorrect UK VAT Number",
                    badUKNin: "Incorrect UK NIN",
                    badUKUtr: "Incorrect UK UTR Number",
                    badStrength: "The password isn't strong enough",
                    badNumberOfSelectedOptionsStart: "You have to choose at least ",
                    badNumberOfSelectedOptionsEnd: " answers",
                    badAlphaNumeric: "The input value can only contain alphanumeric characters ",
                    badAlphaNumericExtra: " and ",
                    wrongFileSize: "The file you are trying to upload is too large (max %s)",
                    wrongFileType: "Only files of type %s is allowed",
                    groupCheckedRangeStart: "Please choose between ",
                    groupCheckedTooFewStart: "Please choose at least ",
                    groupCheckedTooManyStart: "Please choose a maximum of ",
                    groupCheckedEnd: " item(s)",
                    badCreditCard: "The credit card number is not correct",
                    badCVV: "The CVV number was not correct",
                    wrongFileDim: "Incorrect image dimensions,",
                    imageTooTall: "the image can not be taller than",
                    imageTooWide: "the image can not be wider than",
                    imageTooSmall: "the image was too small",
                    min: "min",
                    max: "max",
                    imageRatioNotAccepted: "Image ratio is not be accepted",
                    badBrazilTelephoneAnswer: "The phone number entered is invalid",
                    badBrazilCEPAnswer: "The CEP entered is invalid",
                    badBrazilCPFAnswer: "The CPF entered is invalid",
                    badPlPesel: "The PESEL entered is invalid",
                    badPlNip: "The NIP entered is invalid",
                    badPlRegon: "The REGON entered is invalid",
                    badreCaptcha: "Please confirm that you are not a bot",
                    passwordComplexityStart: "Password must contain at least ",
                    passwordComplexitySeparator: ", ",
                    passwordComplexityUppercaseInfo: " uppercase letter(s)",
                    passwordComplexityLowercaseInfo: " lowercase letter(s)",
                    passwordComplexitySpecialCharsInfo: " special character(s)",
                    passwordComplexityNumericCharsInfo: " numeric character(s)",
                    passwordComplexityEnd: "."
                }
            })
        }(e, window), (f = e).formUtils.addValidator({
            name: "email",
            validatorFunction: function(e) {
                var t = e.toLowerCase().split("@"),
                    a = t[0],
                    i = t[1];
                if (a && i) {
                    if (0 === a.indexOf('"')) {
                        var n = a.length;
                        if ((a = a.replace(/\"/g, "")).length !== n - 2) return !1
                    }
                    return f.formUtils.validators.validate_domain.validatorFunction(t[1]) && 0 !== a.indexOf(".") && "." !== a.substring(a.length - 1, a.length) && -1 === a.indexOf("..") && !/[^\w\+\.\-\#\-\_\~\!\$\&\'\(\)\*\+\,\;\=\:]/.test(a)
                }
                return !1
            },
            errorMessage: "",
            errorMessageKey: "badEmail"
        }), f.formUtils.addValidator({
            name: "domain",
            validatorFunction: function(e) {
                return 0 < e.length && e.length <= 253 && !/[^a-zA-Z0-9]/.test(e.slice(-2)) && !/[^a-zA-Z0-9]/.test(e.substr(0, 1)) && !/[^a-zA-Z0-9\.\-]/.test(e) && 1 === e.split("..").length && 1 < e.split(".").length
            },
            errorMessage: "",
            errorMessageKey: "badDomain"
        }), f.formUtils.addValidator({
            name: "required",
            validatorFunction: function(e, t, a, i, n) {
                switch (t.attr("type")) {
                    case "checkbox":
                        return t.is(":checked");
                    case "radio":
                        return 0 < n.find('input[name="' + t.attr("name") + '"]').filter(":checked").length;
                    default:
                        return "" !== f.trim(e)
                }
            },
            errorMessage: "",
            errorMessageKey: function(e) {
                return "top" === e.errorMessagePosition || "function" == typeof e.errorMessagePosition ? "requiredFields" : "requiredField"
            }
        }), f.formUtils.addValidator({
            name: "length",
            validatorFunction: function(e, t, a, i) {
                var n = t.valAttr("length"),
                    r = t.attr("type");
                if (void 0 === n) return alert('Please add attribute "data-validation-length" to ' + t[0].nodeName + " named " + t.attr("name")), !0;
                var s, o = "file" === r && void 0 !== t.get(0).files ? t.get(0).files.length : e.length,
                    l = f.formUtils.numericRangeCheck(o, n);
                switch (l[0]) {
                    case "out":
                        this.errorMessage = i.lengthBadStart + n + i.lengthBadEnd, s = !1;
                        break;
                    case "min":
                        this.errorMessage = i.lengthTooShortStart + l[1] + i.lengthBadEnd, s = !1;
                        break;
                    case "max":
                        this.errorMessage = i.lengthTooLongStart + l[1] + i.lengthBadEnd, s = !1;
                        break;
                    default:
                        s = !0
                }
                return s
            },
            errorMessage: "",
            errorMessageKey: ""
        }), f.formUtils.addValidator({
            name: "url",
            validatorFunction: function(e) {
                if (/^(https?|ftp):\/\/((((\w|-|\.|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:)*@)?(((\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5])\.(\d|[1-9]\d|1\d\d|2[0-4]\d|25[0-5]))|((([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])(\w|-|\.|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|\d|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.)+(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])(\w|-|\.|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])*([a-z]|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])))\.?)(:\d*)?)(\/(((\w|-|\.|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)+(\/((\w|-|\.|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)*)*)?)?(\?((([a-z]|\d|\[|\]|-|\.|_|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|[\uE000-\uF8FF]|\/|\?)*)?(\#(((\w|-|\.|~|[\u00A0-\uD7FF\uF900-\uFDCF\uFDF0-\uFFEF])|(%[\da-f]{2})|[!\$&'\(\)\*\+,;=]|:|@)|\/|\?)*)?$/i.test(e)) {
                    var t = e.split("://")[1],
                        a = t.indexOf("/");
                    return -1 < a && (t = t.substr(0, a)), f.formUtils.validators.validate_domain.validatorFunction(t)
                }
                return !1
            },
            errorMessage: "",
            errorMessageKey: "badUrl"
        }), f.formUtils.addValidator({
            name: "number",
            validatorFunction: function(e, t, a) {
                if ("" !== e) {
                    var i, n, r = t.valAttr("allowing") || "",
                        s = t.valAttr("decimal-separator") || a.decimalSeparator,
                        o = !1,
                        l = t.valAttr("step") || "",
                        d = !1;
                    if ((t.attr("data-sanitize") || "").match(/(^|[\s])numberFormat([\s]|$)/i)) {
                        if (!window.numeral) throw new ReferenceError("The data-sanitize value numberFormat cannot be used without the numeral library. Please see Data Validation in http://www.formvalidator.net for more information.");
                        e.length && (e = String(numeral().unformat(e)))
                    }
                    if (-1 === r.indexOf("number") && (r += ",number"), -1 === r.indexOf("negative") && 0 === e.indexOf("-")) return !1;
                    if (-1 < r.indexOf("range") && (i = parseFloat(r.substring(r.indexOf("[") + 1, r.indexOf(";"))), n = parseFloat(r.substring(r.indexOf(";") + 1, r.indexOf("]"))), o = !0), "" !== l && (d = !0), "," === s) {
                        if (-1 < e.indexOf(".")) return !1;
                        e = e.replace(",", ".")
                    }
                    if ("" === e.replace(/[0-9-]/g, "") && (!o || i <= e && e <= n) && (!d || e % l == 0)) return !0;
                    if (-1 < r.indexOf("float") && null !== e.match(new RegExp("^([0-9-]+)\\.([0-9]+)$")) && (!o || i <= e && e <= n) && (!d || e % l == 0)) return !0
                }
                return !1
            },
            errorMessage: "",
            errorMessageKey: "badInt"
        }), f.formUtils.addValidator({
            name: "alphanumeric",
            validatorFunction: function(e, t, a, i) {
                var n = "^([a-zA-Z0-9",
                    r = t.valAttr("allowing"),
                    s = "",
                    o = !1;
                if (r) {
                    s = n + r + "]+)$";
                    var l = r.replace(/\\/g, ""); - 1 < l.indexOf(" ") && (o = !0, l = l.replace(" ", ""), l += i.andSpaces || f.formUtils.LANG.andSpaces), i.badAlphaNumericAndExtraAndSpaces && i.badAlphaNumericAndExtra ? this.errorMessage = o ? i.badAlphaNumericAndExtraAndSpaces + l : i.badAlphaNumericAndExtra + l + i.badAlphaNumericExtra : this.errorMessage = i.badAlphaNumeric + i.badAlphaNumericExtra + l
                } else s = n + "]+)$", this.errorMessage = i.badAlphaNumeric;
                return new RegExp(s).test(e)
            },
            errorMessage: "",
            errorMessageKey: ""
        }), f.formUtils.addValidator({
            name: "custom",
            validatorFunction: function(e, t) {
                return new RegExp(t.valAttr("regexp")).test(e)
            },
            errorMessage: "",
            errorMessageKey: "badCustomVal"
        }), f.formUtils.addValidator({
            name: "date",
            validatorFunction: function(e, t, a) {
                var i = t.valAttr("format") || a.dateFormat || "yyyy-mm-dd",
                    n = "false" === t.valAttr("require-leading-zero");
                return !1 !== f.formUtils.parseDate(e, i, n)
            },
            errorMessage: "",
            errorMessageKey: "badDate"
        }), f.formUtils.addValidator({
            name: "checkbox_group",
            validatorFunction: function(e, t, a, i, n) {
                var r = !0,
                    s = t.attr("name"),
                    o = f('input[type=checkbox][name^="' + s + '"]', n),
                    l = o.filter(":checked").length,
                    d = t.valAttr("qty");
                if (void 0 === d) {
                    var u = t.get(0).nodeName;
                    alert('Attribute "data-validation-qty" is missing from ' + u + " named " + t.attr("name"))
                }
                var c = f.formUtils.numericRangeCheck(l, d);
                switch (c[0]) {
                    case "out":
                        this.errorMessage = i.groupCheckedRangeStart + d + i.groupCheckedEnd, r = !1;
                        break;
                    case "min":
                        this.errorMessage = i.groupCheckedTooFewStart + c[1] + (i.groupCheckedTooFewEnd || i.groupCheckedEnd), r = !1;
                        break;
                    case "max":
                        this.errorMessage = i.groupCheckedTooManyStart + c[1] + (i.groupCheckedTooManyEnd || i.groupCheckedEnd), r = !1;
                        break;
                    default:
                        r = !0
                }
                if (!r) {
                    var h = function() {
                        o.unbind("click", h), o.filter("*[data-validation]").validateInputOnBlur(i, a, !1, "blur")
                    };
                    o.bind("click", h)
                }
                return r
            }
        })
    }),
    function(l) {
        l.fn.alphanum = function(e) {
            return a(this, m, s(e)), this
        }, l.fn.alpha = function(e) {
            return a(this, m, s(e, s("alpha"))), this
        };
        var e, t, d = {
                allow: "",
                disallow: "",
                allowSpace: !0,
                allowNewline: !0,
                allowNumeric: !0,
                allowUpper: !0,
                allowLower: !0,
                allowCaseless: !0,
                allowLatin: !0,
                allowOtherCharSets: !0,
                forceUpper: !(l.fn.numeric = function(e) {
                    var t = f(e);
                    return a(this, v, t), this.blur(function() {
                        ! function(e, t) {
                            var a = parseFloat(l(e).val()),
                                i = l(e);
                            if (isNaN(a)) return i.val("");
                            r(t.min) && a < t.min && i.val("");
                            r(t.max) && a > t.max && i.val("")
                        }(this, t)
                    }), this
                }),
                forceLower: !1,
                maxLength: NaN
            },
            i = {
                allowPlus: !1,
                allowMinus: !0,
                allowThouSep: !0,
                allowDecSep: !0,
                allowLeadingSpaces: !1,
                maxDigits: NaN,
                maxDecimalPlaces: NaN,
                maxPreDecimalPlaces: NaN,
                max: NaN,
                min: NaN
            },
            u = {
                alpha: {
                    allowNumeric: !1
                },
                upper: {
                    allowNumeric: !1,
                    allowUpper: !0,
                    allowLower: !1,
                    allowCaseless: !0
                },
                lower: {
                    allowNumeric: !1,
                    allowUpper: !1,
                    allowLower: !0,
                    allowCaseless: !0
                }
            },
            n = {
                integer: {
                    allowPlus: !1,
                    allowMinus: !0,
                    allowThouSep: !1,
                    allowDecSep: !1
                },
                positiveInteger: {
                    allowPlus: !1,
                    allowMinus: !1,
                    allowThouSep: !1,
                    allowDecSep: !1
                }
            },
            c = "!@#$%^&*()+=[]\\';,/{}|\":<>?~`.-_ ¬€£¦",
            o = ",",
            h = ".",
            y = function() {
                var e, t = "0123456789".split(""),
                    a = {},
                    i = 0;
                for (i = 0; i < t.length; i++) e = t[i], a[e] = !0;
                return a
            }(),
            b = (t = (e = "abcdefghijklmnopqrstuvwxyz").toUpperCase(), new w(e + t));

        function a(e, u, c) {
            e.each(function() {
                var d = l(this);
                d.off(".alphanum").on("keyup.alphanum change.alphanum paste.alphanum", function(e) {
                    var t = "";
                    e.originalEvent && e.originalEvent.clipboardData && e.originalEvent.clipboardData.getData && (t = e.originalEvent.clipboardData.getData("text/plain")), setTimeout(function() {
                        ! function(e, t, a, i) {
                            var n = e.val();
                            "" == n && 0 < i.length && (n = i);
                            var r = t(n, a);
                            if (n == r) return;
                            var s = e.alphanum_caret();
                            e.val(r), n.length == r.length + 1 ? e.alphanum_caret(s - 1) : e.alphanum_caret(s)
                        }(d, u, c, t)
                    }, 0)
                }).on("keypress.alphanum", function(e) {
                    var t = e.charCode ? e.charCode : e.which;
                    if ((32 <= (a = t) || 10 == a || 13 == a) && !e.ctrlKey && !e.metaKey) {
                        var a, i = String.fromCharCode(t),
                            n = d.selection(),
                            r = n.start,
                            s = n.end,
                            o = d.val(),
                            l = o.substring(0, r) + i + o.substring(s);
                        u(l, c) != l && e.preventDefault()
                    }
                })
            })
        }

        function r(e) {
            return !isNaN(e)
        }

        function s(e, t) {
            void 0 === t && (t = d);
            var a, i, n, r, s, o = {};
            return a = "string" == typeof e ? u[e] : void 0 === e ? {} : e, l.extend(o, t, a), void 0 === o.blacklist && (o.blacklistSet = (i = o.allow, n = o.disallow, r = new w(c + n), s = new w(i), r.subtract(s))), o
        }

        function f(e) {
            var t, a = {};
            return t = "string" == typeof e ? n[e] : void 0 === e ? {} : e, l.extend(a, i, t), a
        }

        function g(e, t, a) {
            if (y[t]) return ! function(e, t) {
                var a = t.maxDigits;
                if ("" === a || isNaN(a)) return !1;
                var i = p(e);
                return a <= i
            }(e, a) && (! function(e, t) {
                var a = t.maxPreDecimalPlaces;
                if ("" === a || isNaN(a)) return !1;
                if (0 <= e.indexOf(h)) return !1;
                var i = p(e);
                return a <= i
            }(e, a) && (! function(e, t) {
                var a = t.maxDecimalPlaces;
                if ("" === a || isNaN(a)) return !1;
                var i = e.indexOf(h);
                if (-1 == i) return !1;
                var n = p(e.substring(i));
                return a <= n
            }(e, a) && (r = e + t, (!(s = a).max || s.max < 0 || !(parseFloat(r) > s.max)) && (i = e + t, !(n = a).min || 0 < n.min || !(parseFloat(i) < n.min)))));
            var i, n, r, s;
            if (a.allowPlus && "+" == t && "" == e) return !0;
            if (a.allowMinus && "-" == t && "" == e) return !0;
            if (t == o && a.allowThouSep && function(e) {
                    if (0 == e.length) return !1;
                    if (0 <= e.indexOf(h)) return !1;
                    var t = e.indexOf(o);
                    if (t < 0) return !0;
                    var a = e.lastIndexOf(o);
                    return !(e.length - a - 1 < 3 || 0 < p(e.substring(t)) % 3)
                }(e)) return !0;
            if (t == h) {
                if (0 <= e.indexOf(h)) return !1;
                if (a.allowDecSep && 0 === a.maxDecimalPlaces) return !1;
                if (a.allowDecSep) return !0
            }
            return !1
        }

        function p(e) {
            return (e += "").replace(/[^0-9]/g, "").length
        }

        function m(e, t) {
            if ("string" != typeof e) return e;
            var a, i, n, r, s, o, l, d, u, c, h, f = e.split(""),
                g = [],
                p = 0;
            for (p = 0; p < f.length; p++) {
                a = f[p];
                var m = g.join("");
                i = m, n = a, h = c = u = d = l = o = s = void 0, (r = t).maxLength && i.length >= r.maxLength || !(0 <= r.allow.indexOf(n) || r.allowSpace && " " == n) && (!(r.allowNewline || "\n" != n && "\r" != n) || r.blacklistSet.contains(n) || !r.allowNumeric && y[n] || !r.allowUpper && (o = (s = n).toUpperCase(), l = s.toLowerCase(), s == o && o != l) || !r.allowLower && (u = (d = n).toUpperCase(), c = d.toLowerCase(), d == c && u != c) || !r.allowCaseless && (h = n).toUpperCase() == h.toLowerCase() || !r.allowLatin && b.contains(n) || !(r.allowOtherCharSets || y[n] || b.contains(n))) || g.push(a)
            }
            var v = g.join("");
            return t.forceLower ? v = v.toLowerCase() : t.forceUpper && (v = v.toUpperCase()), v
        }

        function v(e, t) {
            if ("string" != typeof e) return e;
            var a, i = e.split(""),
                n = [],
                r = 0;
            for (r = 0; r < i.length; r++) {
                a = i[r], g(n.join(""), a, t) && n.push(a)
            }
            return n.join("")
        }

        function w(e) {
            this.map = "string" == typeof e ? function(e) {
                var t, a = {},
                    i = e.split(""),
                    n = 0;
                for (n = 0; n < i.length; n++) t = i[n], a[t] = !0;
                return a
            }(e) : {}
        }
        w.prototype.add = function(e) {
            var t = this.clone();
            for (var a in e.map) t.map[a] = !0;
            return t
        }, w.prototype.subtract = function(e) {
            var t = this.clone();
            for (var a in e.map) delete t.map[a];
            return t
        }, w.prototype.contains = function(e) {
            return !!this.map[e]
        }, w.prototype.clone = function() {
            var e = new w;
            for (var t in this.map) e.map[t] = !0;
            return e
        }, l.fn.alphanum.backdoorAlphaNum = function(e, t) {
            return m(e, s(t))
        }, l.fn.alphanum.backdoorNumeric = function(e, t) {
            return v(e, f(t))
        }, l.fn.alphanum.setNumericSeparators = function(e) {
            1 == e.thousandsSeparator.length && 1 == e.decimalSeparator.length && (o = e.thousandsSeparator, h = e.decimalSeparator)
        }
    }(jQuery),
    function(n) {
        function r(e, t) {
            if (e.createTextRange) {
                var a = e.createTextRange();
                a.move("character", t), a.select()
            } else null != e.selectionStart && (e.focus(), e.setSelectionRange(t, t))
        }
        n.fn.alphanum_caret = function(a, i) {
            return void 0 === a ? function(e) {
                if ("selection" in document) {
                    var t = e.createTextRange();
                    try {
                        t.setEndPoint("EndToStart", document.selection.createRange())
                    } catch (e) {
                        return 0
                    }
                    return t.text.length
                }
                if (null != e.selectionStart) return e.selectionStart
            }(this.get(0)) : this.queue(function(e) {
                if (isNaN(a)) {
                    var t = n(this).val().indexOf(a);
                    !0 === i ? t += a.length : void 0 !== i && (t += i), r(this, t)
                } else r(this, a);
                e()
            })
        }
    }(jQuery),
    function(d) {
        var u = function(e) {
                return e ? e.ownerDocument.defaultView || e.ownerDocument.parentWindow : window
            },
            c = function(e, t) {
                var a = d.Range.current(e).clone(),
                    i = d.Range(e).select(e);
                return a.overlaps(i) ? (a.compare("START_TO_START", i) < 1 ? (startPos = 0, a.move("START_TO_START", i)) : (fromElementToCurrent = i.clone(), fromElementToCurrent.move("END_TO_START", a), startPos = fromElementToCurrent.toString().length), 0 <= a.compare("END_TO_END", i) ? endPos = i.toString().length : endPos = startPos + a.toString().length, {
                    start: startPos,
                    end: endPos
                }) : null
            },
            h = function(e, t, a) {
                var i, n, r, s, o, l;
                a = a || 0;
                for (var d = 0; e[d]; d++) 3 === (i = e[d]).nodeType || 4 === i.nodeType ? (n = a, a += i.nodeValue.length, r = n, s = a, l = i, "number" == typeof(o = t)[0] && o[0] < s && (o[0] = {
                    el: l,
                    count: o[0] - r
                }), "number" == typeof o[1] && o[1] <= s && (o[1] = {
                    el: l,
                    count: o[1] - r
                })) : 8 !== i.nodeType && (a = h(i.childNodes, t, a));
                return a
            };
        jQuery.fn.selection = function(e, t) {
            return void 0 !== e ? this.each(function() {
                ! function(e, t, a) {
                    var i = u(e);
                    if (e.setSelectionRange) void 0 === a ? (e.focus(), e.setSelectionRange(t, t)) : (e.select(), e.selectionStart = t, e.selectionEnd = a);
                    else if (e.createTextRange) {
                        var n = e.createTextRange();
                        n.moveStart("character", t), a = a || t, n.moveEnd("character", a - e.value.length), n.select()
                    } else if (i.getSelection) {
                        var r = i.document,
                            s = i.getSelection(),
                            o = r.createRange(),
                            l = [t, void 0 !== a ? a : t];
                        h([e], l), o.setStart(l[0].el, l[0].count), o.setEnd(l[1].el, l[1].count), s.removeAllRanges(), s.addRange(o)
                    } else i.document.body.createTextRange && ((o = document.body.createTextRange()).moveToElementText(e), o.collapse(), o.moveStart("character", t), o.moveEnd("character", void 0 !== a ? a : t), o.select())
                }(this, e, t)
            }) : function(t) {
                var e = u(t);
                if (void 0 !== t.selectionStart) return document.activeElement && document.activeElement != t && t.selectionStart == t.selectionEnd && 0 == t.selectionStart ? {
                    start: t.value.length,
                    end: t.value.length
                } : {
                    start: t.selectionStart,
                    end: t.selectionEnd
                };
                if (e.getSelection) return c(t);
                try {
                    if ("input" == t.nodeName.toLowerCase()) {
                        var a = u(t).document.selection.createRange(),
                            i = t.createTextRange();
                        i.setEndPoint("EndToStart", a);
                        var n = i.text.length;
                        return {
                            start: n,
                            end: n + a.text.length
                        }
                    }
                    var r = c(t);
                    if (!r) return r;
                    var s = d.Range.current().clone(),
                        o = s.clone().collapse().range,
                        l = s.clone().collapse(!1).range;
                    return o.moveStart("character", -1), l.moveStart("character", -1), 0 != r.startPos && "" == o.text && (r.startPos += 2), 0 != r.endPos && "" == l.text && (r.endPos += 2), r
                } catch (e) {
                    return {
                        start: t.value.length,
                        end: t.value.length
                    }
                }
            }(this[0])
        }, d.fn.selection.getCharElement = h
    }(jQuery),
    function(h) {
        "use strict";
        h.formUtils.registerLoadedModule("logic");
        h.formUtils.$win.bind("validatorsLoaded formValidationSetup", function(e, t, a) {
            var n, r, i, s, o, l, d, u, c;
            t || (t = h("form")), r = a, i = function() {
                var e = h(this),
                    t = e.valAttr("depends-on") || e.valAttr("if-checked");
                if (t) {
                    var a = h.formUtils.getValue('[name="' + t + '"]', n),
                        i = h.split(e.valAttr("depends-on-value"), !1, !1);
                    (!a || i.length && !s(a, i)) && e.valAttr("skipped", "1")
                }
            }, s = function(e, t) {
                var a = !1,
                    i = e.toLocaleLowerCase();
                return h.each(t, function(e, t) {
                    if (i === t.toLocaleLowerCase()) return !(a = !0)
                }), a
            }, o = function() {
                var e = h(this),
                    i = h.formUtils.getValue(e),
                    n = e.valAttr("depending-value");
                h.each(this.dependingInputs, function(e, t) {
                    var a = !!h.formUtils.getValue(t);
                    (!i || n && n !== i) && !a && h.formUtils.dialogs.removeInputStylingAndMessage(t, r)
                })
            }, (n = t).find("[data-validation-depends-on]").off("beforeValidation", i).on("beforeValidation", i).each(function() {
                var e = h(this);
                n.find('[name="' + e.valAttr("depends-on") + '"]').each(function() {
                    h(this).off("change", o).on("change", o).valAttr("depending-value", e.valAttr("depends-on-value")), this.dependingInputs = this.dependingInputs || [], this.dependingInputs.push(e)
                })
            }), d = a, u = function() {
                var e = h(this),
                    t = e.valAttr("optional-if-answered"),
                    i = !1;
                h.formUtils.getValue(e) || (h.each(h.split(t), function(e, t) {
                    var a = l.find('[name="' + t + '"]');
                    if (i = !!h.formUtils.getValue(a)) return !1
                }), i && e.valAttr("skipped", 1))
            }, c = function() {
                var e = h(this).valAttr("optional-if-answered");
                h.each(h.split(e), function(e, t) {
                    var a = l.find('[name="' + t + '"]');
                    h.formUtils.getValue(a) || h.formUtils.dialogs.removeInputStylingAndMessage(a, d)
                })
            }, (l = t).find("[data-validation-optional-if-answered]").off("beforeValidation", u).on("beforeValidation", u).each(function() {
                h(this).off("change", c).on("change", c)
            })
        })
    }(jQuery),
    function(c, e) {
        "use strict";
        c.formUtils.registerLoadedModule("security"), c.formUtils.addValidator({
            name: "spamcheck",
            validatorFunction: function(e, t) {
                return t.valAttr("captcha") === e
            },
            errorMessage: "",
            errorMessageKey: "badSecurityAnswer"
        }), c.formUtils.addValidator({
            name: "confirmation",
            validatorFunction: function(e, t, a, i, n) {
                var r, s = t.valAttr("confirm") || t.attr("name") + "_confirmation",
                    o = n.find('[name="' + s + '"]');
                if (!o.length) return c.formUtils.warn('Password confirmation validator: could not find an input with name "' + s + '"', !0), !1;
                if (r = o.val(), a.validateOnBlur && !o[0].hasValidationCallback) {
                    o[0].hasValidationCallback = !0;
                    var l = function() {
                        t.validate()
                    };
                    o.on("keyup", l), n.one("formValidationSetup", function() {
                        o[0].hasValidationCallback = !1, o.off("keyup", l)
                    })
                }
                return e === r
            },
            errorMessage: "",
            errorMessageKey: "notConfirmed"
        });
        var r = {
                amex: [15, 15],
                diners_club: [14, 14],
                cjb: [16, 16],
                laser: [16, 19],
                visa: [16, 16],
                mastercard: [16, 16],
                maestro: [12, 19],
                discover: [16, 16]
            },
            s = !1,
            o = !1;
        c.formUtils.addValidator({
            name: "creditcard",
            validatorFunction: function(a, e) {
                var t = c.split(e.valAttr("allowing") || "");
                if (o = -1 < c.inArray("amex", t), s = o && 1 === t.length, 0 < t.length) {
                    var i = !1;
                    if (c.each(t, function(e, t) {
                            if (t in r) {
                                if (a.length >= r[t][0] && a.length <= r[t][1]) return !(i = !0)
                            } else c.formUtils.warn('Use of unknown credit card "' + t + '"', !0)
                        }), !i) return !1
                }
                if ("" !== a.replace(new RegExp("[0-9]", "g"), "")) return !1;
                var n = 0;
                return c.each(a.split("").reverse(), function(e, t) {
                    t = parseInt(t, 10), n += e % 2 == 0 ? t : (t *= 2) < 10 ? t : t - 9
                }), n % 10 == 0
            },
            errorMessage: "",
            errorMessageKey: "badCreditCard"
        }), c.formUtils.addValidator({
            name: "cvv",
            validatorFunction: function(e) {
                return "" === e.replace(/[0-9]/g, "") && (e += "", s ? 4 === e.length : o ? 3 === e.length || 4 === e.length : 3 === e.length)
            },
            errorMessage: "",
            errorMessageKey: "badCVV"
        }), c.formUtils.addValidator({
            name: "strength",
            validatorFunction: function(e, t) {
                var a = t.valAttr("strength") || 2;
                return a && 3 < a && (a = 3), c.formUtils.validators.validate_strength.calculatePasswordStrength(e, t) >= a
            },
            errorMessage: "",
            errorMessageKey: "badStrength",
            calculatePasswordStrength: function(e, u) {
            	if(u.attr("id")==='password-actual'){
        	 		if (e.length < 4) return 0;
            	}            	
            	else if(u.hasClass("new-password") || u.hasClass("confirm-password")){
                  // Obtener nivel de contraseña
                  var divparent = u.parent();
                  var divstrength = divparent.find(".strength-meter");
                  var ul = divstrength.find(".status-level");
                  // Validar nivel de contraseña
                  if (ul.hasClass("bad") || ul.hasClass("weak")) return 0;
            	}            	
            	else if (e.length < 8 || !e.match(/[A-Z]/) || !e.match(/[a-z]/) || !e.match(/[0-9]/) || !e.match(/[!@#$%^&*()+=\[\]\\';,/\{\}|\":<>?~`.\-_¬€£¦]/)) {
                    return 0;
                }
            	
                var t = 0,
                    a = function(e, t) {
                        for (var a = "", i = 0; i < t.length; i++) {
                            for (var n = !0, r = 0; r < e && r + i + e < t.length; r++) n = n && t.charAt(r + i) === t.charAt(r + i + e);
                            r < e && (n = !1), n ? (i += e - 1, n = !1) : a += t.charAt(i)
                        }
                        return a
                    };
                return t += 4 * e.length, t += 1 * (a(1, e).length - e.length), t += 1 * (a(2, e).length - e.length), t += 1 * (a(3, e).length - e.length), t += 1 * (a(4, e).length - e.length), e.match(/(.*[0-9].*[0-9].*[0-9])/) && (t += 5), e.match(/(.*[!,@,#,$,%,^,&,*,?,_,~].*[!,@,#,$,%,^,&,*,?,_,~])/) && (t += 5), e.match(/([a-z].*[A-Z])|([A-Z].*[a-z])/) && (t += 10), e.match(/([a-zA-Z])/) && e.match(/([0-9])/) && (t += 15), e.match(/([!,@,#,$,%,^,&,*,?,_,~])/) && e.match(/([0-9])/) && (t += 15), e.match(/([!,@,#,$,%,^,&,*,?,_,~])/) && e.match(/([a-zA-Z])/) && (t += 15), (e.match(/^\w+$/) || e.match(/^\d+$/)) && (t -= 10), t < 0 && (t = 0), 100 < t && (t = 100), t < 20 ? 0 : t < 40 ? 1 : t <= 60 ? 2 : 3
            },
            strengthDisplay: function(e, t) {
                var r = {
                    fontSize: "12pt",
                    padding: "4px",
                    bad: "Very bad",
                    weak: "Weak",
                    good: "Good",
                    strong: "Strong"
                };
                t && c.extend(r, t), e.bind("keyup",
                    function() {
	                	var atleastOneUppercase = new RegExp(/.*[A-Z]+.*/);
	                    var atleastOneLowercase = new RegExp(/.*[a-z]+.*/);
                        var atleastOneNumber = new RegExp(/.*[0-9]+.*/);
                        var atleastOneSimbol = new RegExp(/.*[!@#$%^&*()+=\[\]\\';,/{}|\":<>?~`.\-_¬€£¦]+.*/);
                        var e = c(this).val(),
                            t = void 0 === r.parent ? c(this).parent() : c(r.parent),
                            a = t.find(".strength-meter"),
                            i = c.formUtils.validators.validate_strength.calculatePasswordStrength(e,$(this)),
                            n = r.bad;
                            if (!c(this).hasClass("confirm-password")) {
                            	0 === a.length && (a = c("<span></span>")).addClass("strength-meter").appendTo(t), e ? a.show() : a.hide(),
                                        (atleastOneUppercase.test(e) && atleastOneLowercase.test(e) && atleastOneNumber.test(e) && e.length >= 8) ? (atleastOneSimbol.test(e)) ? n = r.good : n = r.weak : n = r.bad, a.html(n);
                            	if($(".confirm-password").length>0){
                            		var confirPassword = $(".confirm-password").val();
                            		var t2 = void 0 === r.parent ? c($(".confirm-password")).parent() : c(r.parent),
                                            a2 = t2.find(".strength-meter");
                            		if (e === confirPassword) {
                                    	// Verificar que new-password tenga fortaleza como "bueno" 
                                    	
                                        if(a.html()!=r.good){
                                        	// Establecer el nivel de fortaleza de confir-password igual a new-password
                                        	a2.html(a.html());
                                        }else{
                                        	// Establecer el nivel de fortaleza como "bueno"
                                        	n = r.good;
                                        	a2.html(n);
                                        }                                	
                                    } else {
                                        // Establecer el nivel de fortaleza como "malo"
                                        n = '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>La contrase&ntilde;a debe coincidir.</span>';
                                        a2.html(n);
                                    }
                            		confirPassword ? a2.show() : a2.hide();
                            	}
                            	
                            }else{
                            	var newPassword = $(".new-password").val(); // Obtener el valor del campo de nueva contraseña
                                if (e === newPassword) {
                                	// Verificar que new-password tenga fortaleza como "bueno" 
                                	var t2 = void 0 === r.parent ? c($(".new-password")).parent() : c(r.parent),
                                    a2 = t2.find(".strength-meter")
                                    if(a2.html()!=r.good){
                                    	// Establecer el nivel de fortaleza de confir-password igual a new-password
                                    	a.html(a2.html());
                                    }else{
                                    	// Establecer el nivel de fortaleza como "bueno"
                                    	n = r.good;
                                    	a.html(n);
                                    }                                	
                                } else {
                                    // Establecer el nivel de fortaleza como "malo"
                                    n = '<ul class="status-level bad"><li></li><li></li><li></li></ul><span>La contrase&ntilde;a debe coincidir.</span>';
                                    a.html(n);
                                }
                                e ? a.show() : a.hide();
                            }
                            // Obtener el formulario de input
                            var $form = $(this).closest("form");
                            // Obtener el botón con la clase "button"
                  		  	var botonEnvio = $form.find(".button");
                  		  	if(botonEnvio.length===0) botonEnvio = $form.find(".btn");
                            if ($form.isValid({}, {}, false) && a.html()===r.good && a2.length==0) {                 		  	
                      		  	botonEnvio.attr('disabled', false);
                      		} else if($form.isValid({}, {}, false) && a.html()===r.good && a2.length>0 && a2.html()===r.good){                      		  	
                      		  	botonEnvio.attr('disabled', false);
                      		}else {
                      			botonEnvio.attr('disabled', true);
                      		}
                    })
            }
        });
        c.formUtils.addAsyncValidator({
            name: "server",
            validatorFunction: function(t, e, a, i, n, r) {
                var s = a.valAttr("url") || i.backendUrl || document.location.href;
                r.addClass("validating-server-side"), a.addClass("validating-server-side"),
                    function(e, t, a, i, n) {
                        var r = t.valAttr("req-params") || t.data("validation-req-params") || {},
                            s = t.valAttr("param-name") || t.attr("name"),
                            o = function(e, t) {
                                t(e)
                            };
                        if (!s) throw new Error("Missing input name used for http requests made by server validator");
                        r || (r = {}), "string" == typeof r && (r = c.parseJSON(r)), r[s] = a, c.ajax({
                            url: e,
                            type: "POST",
                            cache: !1,
                            data: r,
                            dataType: "json",
                            error: function(e) {
                                return o({
                                    valid: !1,
                                    message: "Connection failed with status: " + e.statusText
                                }, n), !1
                            },
                            success: function(e) {
                                o(e, n)
                            }
                        })
                    }(s, a, e, 0, function(e) {
                        r.removeClass("validating-server-side"), a.removeClass("validating-server-side"), e.message && a.attr(i.validationErrorMsgAttribute, e.message), t(e.valid)
                    })
            },
            errorMessage: "",
            errorMessageKey: "badBackend"
        }), c.formUtils.addValidator({
            name: "letternumeric",
            validatorFunction: function(e, t, a, i) {
                var n = "^([a-zA-Z0-9ªµºÀ-ÖØ-öø-ˁˆ-ˑˠ-ˤˬˮͰ-ʹͶͷͺ-ͽΆΈ-ΊΌΎ-ΡΣ-ϵϷ-ҁҊ-ԧԱ-Ֆՙա-ևא-תװ-ײؠ-يٮٯٱ-ۓەۥۦۮۯۺ-ۼۿܐܒ-ܯݍ-ޥޱߊ-ߪߴߵߺࠀ-ࠕࠚࠤࠨࡀ-ࡘࢠࢢ-ࢬऄ-हऽॐक़-ॡॱ-ॷॹ-ॿঅ-ঌএঐও-নপ-রলশ-হঽৎড়ঢ়য়-ৡৰৱਅ-ਊਏਐਓ-ਨਪ-ਰਲਲ਼ਵਸ਼ਸਹਖ਼-ੜਫ਼ੲ-ੴઅ-ઍએ-ઑઓ-નપ-રલળવ-હઽૐૠૡଅ-ଌଏଐଓ-ନପ-ରଲଳଵ-ହଽଡ଼ଢ଼ୟ-ୡୱஃஅ-ஊஎ-ஐஒ-கஙசஜஞடணதந-பம-ஹௐఅ-ఌఎ-ఐఒ-నప-ళవ-హఽౘౙౠౡಅ-ಌಎ-ಐಒ-ನಪ-ಳವ-ಹಽೞೠೡೱೲഅ-ഌഎ-ഐഒ-ഺഽൎൠൡൺ-ൿඅ-ඖක-නඳ-රලව-ෆก-ะาำเ-ๆກຂຄງຈຊຍດ-ທນ-ຟມ-ຣລວສຫອ-ະາຳຽເ-ໄໆໜ-ໟༀཀ-ཇཉ-ཬྈ-ྌက-ဪဿၐ-ၕၚ-ၝၡၥၦၮ-ၰၵ-ႁႎႠ-ჅჇჍა-ჺჼ-ቈቊ-ቍቐ-ቖቘቚ-ቝበ-ኈኊ-ኍነ-ኰኲ-ኵኸ-ኾዀዂ-ዅወ-ዖዘ-ጐጒ-ጕጘ-ፚᎀ-ᎏᎠ-Ᏼᐁ-ᙬᙯ-ᙿᚁ-ᚚᚠ-ᛪᜀ-ᜌᜎ-ᜑᜠ-ᜱᝀ-ᝑᝠ-ᝬᝮ-ᝰក-ឳៗៜᠠ-ᡷᢀ-ᢨᢪᢰ-ᣵᤀ-ᤜᥐ-ᥭᥰ-ᥴᦀ-ᦫᧁ-ᧇᨀ-ᨖᨠ-ᩔᪧᬅ-ᬳᭅ-ᭋᮃ-ᮠᮮᮯᮺ-ᯥᰀ-ᰣᱍ-ᱏᱚ-ᱽᳩ-ᳬᳮ-ᳱᳵᳶᴀ-ᶿḀ-ἕἘ-Ἕἠ-ὅὈ-Ὅὐ-ὗὙὛὝὟ-ώᾀ-ᾴᾶ-ᾼιῂ-ῄῆ-ῌῐ-ΐῖ-Ίῠ-Ῥῲ-ῴῶ-ῼⁱⁿₐ-ₜℂℇℊ-ℓℕℙ-ℝℤΩℨK-ℭℯ-ℹℼ-ℿⅅ-ⅉⅎↃↄⰀ-Ⱞⰰ-ⱞⱠ-ⳤⳫ-ⳮⳲⳳⴀ-ⴥⴧⴭⴰ-ⵧⵯⶀ-ⶖⶠ-ⶦⶨ-ⶮⶰ-ⶶⶸ-ⶾⷀ-ⷆⷈ-ⷎⷐ-ⷖⷘ-ⷞⸯ々〆〱-〵〻〼ぁ-ゖゝ-ゟァ-ヺー-ヿㄅ-ㄭㄱ-ㆎㆠ-ㆺㇰ-ㇿ㐀-䶵一-鿌ꀀ-ꒌꓐ-ꓽꔀ-ꘌꘐ-ꘟꘪꘫꙀ-ꙮꙿ-ꚗꚠ-ꛥꜗ-ꜟꜢ-ꞈꞋ-ꞎꞐ-ꞓꞠ-Ɦꟸ-ꠁꠃ-ꠅꠇ-ꠊꠌ-ꠢꡀ-ꡳꢂ-ꢳꣲ-ꣷꣻꤊ-ꤥꤰ-ꥆꥠ-ꥼꦄ-ꦲꧏꨀ-ꨨꩀ-ꩂꩄ-ꩋꩠ-ꩶꩺꪀ-ꪯꪱꪵꪶꪹ-ꪽꫀꫂꫛ-ꫝꫠ-ꫪꫲ-ꫴꬁ-ꬆꬉ-ꬎꬑ-ꬖꬠ-ꬦꬨ-ꬮꯀ-ꯢ가-힣ힰ-ퟆퟋ-ퟻ豈-舘並-龎ﬀ-ﬆﬓ-ﬗיִײַ-ﬨשׁ-זּטּ-לּמּנּסּףּפּצּ-ﮱﯓ-ﴽﵐ-ﶏﶒ-ﷇﷰ-ﷻﹰ-ﹴﹶ-ﻼＡ-Ｚａ-ｚｦ-ﾾￂ-ￇￊ-ￏￒ-ￗￚ-ￜ",
                    r = t.valAttr("allowing"),
                    s = "";
                if (r) {
                    s = n + r + "]+)$";
                    var o = r.replace(/\\/g, ""); - 1 < o.indexOf(" ") && (o = o.replace(" ", ""), o += i.andSpaces || c.formUtils.LANG.andSpaces), this.errorMessage = i.badAlphaNumeric + i.badAlphaNumericExtra + o
                } else s = n + "]+)$", this.errorMessage = i.badAlphaNumeric;
                return new RegExp(s).test(e)
            },
            errorMessage: "",
            errorMessageKey: "requiredFields"
        }), c.formUtils.addValidator({
            name: "complexity",
            validatorFunction: function(n, r, e, s) {
                var t = r.valAttr("require-uc-letter") || "0",
                    a = r.valAttr("require-lc-letter") || "0",
                    i = r.valAttr("require-special-char") || "0",
                    o = r.valAttr("require-numeral") || "0",
                    l = r.valAttr("require-length") || "0",
                    d = {
                        "uc-letter": {
                            pattern: "^(?=(?:.*[A-Z]){" + t + ",}).+",
                            numRequired: t,
                            dialogEnd: s.passwordComplexityUppercaseInfo
                        },
                        "lc-letter": {
                            pattern: "^(?=(?:.*[a-z]){" + a + ",}).+",
                            numRequired: a,
                            dialogEnd: s.passwordComplexityLowercaseInfo
                        },
                        "special-char": {
                            pattern: "^(?=(?:.*(_|[!\"#$%&'()*+\\\\,-./:;<=>?@[\\]^_`{|}~])){" + i + ",}).+",
                            numRequired: i,
                            dialogEnd: s.passwordComplexitySpecialCharsInfo
                        },
                        numeral: {
                            pattern: "^(?=(?:.*\\d){" + o + ",}).+",
                            numRequired: o,
                            dialogEnd: s.passwordComplexityNumericCharsInfo
                        },
                        length: {
                            callback: function(e) {
                                return e.length >= l
                            },
                            numRequired: l,
                            dialogEnd: s.lengthBadEnd
                        }
                    },
                    u = "";
                return c.each(d, function(e, t) {
                    var a = parseInt(t.numRequired, 10);
                    if (a) {
                        var i = new RegExp(t.pattern);
                        (t.callback ? t.callback(n) : i.test(n)) ? r.trigger("complexityRequirementValidation", [!0, e]): ("" === u && (u = s.passwordComplexityStart), u += s.passwordComplexitySeparator + a + t.dialogEnd, r.trigger("complexityRequirementValidation", [!1, e]))
                    }
                }), !u || (this.errorMessage = u + s.passwordComplexityEnd, !1)
            },
            errorMessage: "",
            errorMessageKey: ""
        }), c.fn.displayPasswordStrength = function(e) {
            return new c.formUtils.validators.validate_strength.strengthDisplay(this, e), this
        };
        
    }(jQuery, window);
    
    function documentValidation(rtn){
    	if(rtn.attr('id')=='document-number'){
        	if(rtn.attr('class')=='error'){
        		$('#document_number_msg').hide();
        	}else{
        		
        		$('#document_number_msg').show();
        	}                	
        }
    	if(rtn.attr('id')=='document-number-pasap'){
        	if(rtn.attr('class')=='error'){
        		$('#document_number_pasap_msg').hide();
        	}else{
        		
        		$('#document_number_pasap_msg').show();
        	}                	
        }
    	if(rtn.attr('id')=='document-number-carex'){
        	if(rtn.attr('class')=='error'){
        		$('#document_number_carex_msg').hide();
        	}else{
        		
        		$('#document_number_carex_msg').show();
        	}                	
        }
    	
    }
    
//    $( "#typeDoc" ).click(function() {
//	    	if($( "#document-number" ).attr('class')=='error'){
//	    		$('#document_number_msg').hide();
//	    	}else{
//	    		$('#divNumberDoc').css("margin-bottom","28px");
//	    		$('#document_number_msg').text("ESTE DATO SERÁ USADO COMO TU USUARIO");
//	    		$('#document_number_msg').css("color","#07663a");
//	    		$('#document_number_msg').show();
//	    	}
//        	if($('#document-number-pasap').attr('class')=='error'){
//        		$('#document_number_pasap_msg').hide();
//        	}else{
//        		$('#div-documento-pasap').css("margin-bottom","28px");
//	    		$('#document_number_pasap_msg').text("ESTE DATO SERÁ USADO COMO TU USUARIO");
//	    		$('#document_number_pasap_msg').css("color","#07663a");
//        		$('#document_number_pasap_msg').show();
//        	}
//        	if($('#document-number-carex').attr('class')=='error'){
//        		$('#document_number_carex_msg').hide();
//        	}else{
//        		$('#div-documento-carex').css("margin-bottom","28px");
//	    		$('#document_number_carex_msg').text("ESTE DATO SERÁ USADO COMO TU USUARIO");
//	    		$('#document_number_carex_msg').css("color","#07663a");
//        		$('#documento_carex_msg').show();
//        	}                	
//	        
//    	});