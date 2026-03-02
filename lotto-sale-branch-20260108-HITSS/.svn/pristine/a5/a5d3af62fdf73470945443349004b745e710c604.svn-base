/**
 * User: george.minaya
 * Date: 19/08/13
 * Time: 02:55 PM
 */
// jQuery Alert Dialogs Plugin
//
// Version 1.1
//
// Cory S.N. LaViska
// A Beautiful Site (http://abeautifulsite.net/)
// 14 May 2009
//
// Visit http://abeautifulsite.net/notebook/87 for more information
//
// Usage:
//      jAlert( message, [title, callback] )
//      jConfirm( message, [title, callback] )
//      jPrompt( message, [value, title, callback] )
//
// History:
//
//      1.00 - Released (29 December 2008)
//
//      1.01 - Fixed bug where unbinding would destroy all resize events
//
// License:
//
// This plugin is dual-licensed under the GNU General Public License and the MIT License and
// is copyright 2008 A Beautiful Site, LLC.
//
;
(function ($) {
    $.alerts = {
        // These properties can be read/written by accessing $.alerts.propertyName from your scripts at any time
        verticalOffset: -75,                // vertical offset of the dialog from center screen, in pixels
        horizontalOffset: 0,                // horizontal offset of the dialog from center screen, in pixels/
        repositionOnResize: true,           // re-centers the dialog on window resize
        overlayOpacity: .7,                // transparency level of overlay
        overlayColor: '#000',               // base color of overlay
        draggable: true,                    // make the dialogs draggable (requires UI Draggables plugin)
        printButton: '&nbsp;Imprimir&nbsp;',
        okButton: '&nbsp;Aceptar&nbsp;',         // text for the OK button
        continueButton: '&nbsp;Continuar&nbsp;', // text for the Continue button
        cancelButton: '&nbsp;Cancelar&nbsp;', // text for the Cancel button
        toLoadBalance: '&nbsp;Ir a cargar saldo&nbsp;', // text for the to load balance button
        collectPrize: '&nbsp;Cobrar en Efectivo&nbsp;', // text for the collect cash prize button
        loadBalance: '&nbsp;Cargar al Saldo&nbsp;', // text for the Award load balance button
        dialogClass: null,                  // if specified, this class will be applied to all dialogs

        // Public methods

        alert: function (message, title, callback) {
            if (title == null) title = 'Aviso';
            $.alerts._show(title, message, null, 'alert', function (result) {
                if (callback) {
                    callback(result)
                }
            })
        },
        alertAgora: function (message, title, callback) {//
            if (title == null) title = 'Volver a mi cuenta';
            $.alerts._show('Aviso', message, title, 'alertAgora', function (result) {
                if (callback) {
                    callback(result)
                }
            })
        },
        confirm: function (message, title, callback) {
            if (title == null) title = 'Importante';
            $.alerts._show(title, message, null, 'confirm', function (result) {
                if (callback) {
                    callback(result)
                }
            })
        },
        prompt: function (message, value, title, callback) {
            if (title == null) title = 'Requerido';
            $.alerts._show(title, message, value, 'prompt', function (result) {
                if (callback) {
                    callback(result)
                }
            })
        },
        condition: function (message, title, callback, callback2) {
            if (title == null) title = 'Importante';
            $.alerts._show(title, message, null, 'condition', function (result) {
                if (callback) {
                    callback(result)
                }
            }, function (result2) {
                if (callback2) {
                    callback2(result2)
                }
            })
        },
        print: function (message, title, callback) {
            if (title == null) title = 'Importante';
            $.alerts._show(title, message, null, 'print', function (result) {
                if (callback) {
                    callback(result)
                }
            })
        },
        awards: function (message, title, callback, callback2) {
            if (title == null) title = 'Importante';
            $.alerts._show(title, message, null, 'awards', function (result) {
                if (callback) {
                    callback(result)
                }
            }, ((callback2==null)?callback2:(function (result2) {
                if (callback2) {
                    callback2(result2)
                }
            })))
        },
        // Private methods
        _show: function (title, msg, value, type, callback, callback2) {
            $.alerts._hide();
            $.alerts._overlay('show');
            $("body").append('<div id="popup_container">' +
                '<h1 id="popup_title"></h1>' +
                '<div id="popup_content">' +
                '<div id="popup_message"></div>' +
                '</div>' +
                '</div>');

            if ($.alerts.dialogClass) $("#popup_container").addClass($.alerts.dialogClass);
            $("#popup_container").css({
                position: 'fixed',
                zIndex: 99999,
                padding: 0,
                margin: 0
            });
            $("#popup_title").text(title);
            $("#popup_content").addClass(type);
            $("#popup_message").text(msg).html($("#popup_message").text().replace(/\n/g, '<br />'));
            $("#popup_container").css({
                minWidth: $("#popup_container").outerWidth(),
                maxWidth: $("#popup_container").outerWidth()
            });

            $.alerts._reposition();
            $.alerts._maintainPosition(true);
            switch (type) {
                case 'alert':
                    $("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /></div>');
                    $("#popup_ok").on("click", function () {
                        $.alerts._hide();
                        callback(true);
                    });
                    $("#popup_ok").focus().keypress(function (e) {
                        if (e.keyCode == 13 || e.keyCode == 27) $("#popup_ok").trigger('click')
                    });
                    break;
                case 'alertAgora':
                    $("#popup_message").after('<div id="popup_panel"><input type="button" value="' + value + '" id="popup_ok" /></div>');
                    $("#popup_ok").on("click", function () {
                        $.alerts._hide();
                        callback(true);
                    });
                    $("#popup_ok").focus().keypress(function (e) {
                        if (e.keyCode == 13 || e.keyCode == 27) $("#popup_ok").trigger('click')
                    });
                    break;    
                case 'confirm':
                    $("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
                    $("#popup_ok").on("click", function () {
                        $.alerts._hide();
                        if (callback) callback(true)
                    });
                    $("#popup_cancel").on("click", function () {
                        $.alerts._hide();
                        if (callback) callback(false)
                    });
                    /*$("#popup_ok").focus();
                     $("#popup_ok, #popup_cancel").keypress( function(e) {
                     if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
                     if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
                     });*/
                    $("#popup_cancel").focus();
                    $("#popup_ok").keypress(function (e) {
                        if (e.keyCode == 13) {
                            $("#popup_ok").trigger('click')
                        }
                        if (e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    $("#popup_cancel").keypress(function (e) {
                        if (e.keyCode == 13 || e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    break;
                case 'print':
                    $("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.printButton + '" id="popup_print" /> <input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
                    $("#popup_print").on("click", function () {
                        $.alerts._hide();
                        if (callback) {
                            callback(true)
                        }
                    });
                    $("#popup_cancel").on("click", function () {
                        $.alerts._hide();
                        if (callback) {
                            callback(false)
                        }
                    });
                    /*$("#popup_ok").focus();
                     $("#popup_ok, #popup_cancel").keypress( function(e) {
                     if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
                     if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
                     });*/
                    $("#popup_cancel").focus();
                    $("#popup_print").keypress(function (e) {
                        if (e.keyCode == 13) {
                            $("#popup_print").trigger('click')
                        }
                        if (e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    $("#popup_cancel").keypress(function (e) {
                        if (e.keyCode == 13 || e.keyCode == 27) $("#popup_cancel").trigger('click')
                    });
                    break;
                case 'prompt':
                    $("#popup_message").append('<br /><input type="text" size="30" id="popup_prompt" />').after('<div id="popup_panel"><input type="button" value="' + $.alerts.okButton + '" id="popup_ok" /> <input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
                    $("#popup_prompt").width($("#popup_message").width());
                    $("#popup_ok").on("click", function () {
                        var val = $("#popup_prompt").val();
                        $.alerts._hide();
                        if (callback) {
                            callback(val)
                        }
                    });
                    $("#popup_cancel").on("click", function () {
                        $.alerts._hide();
                        if (callback) {
                            callback(null)
                        }
                    });
                    $("#popup_prompt, #popup_ok, #popup_cancel").keypress(function (e) {
                        if (e.keyCode == 13) {
                            $("#popup_ok").trigger('click')
                        }
                        if (e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    if (value) {
                        $("#popup_prompt").val(value)
                    }
                    $("#popup_prompt").focus().select();
                    break;
                case 'condition':
                    $("#popup_message").after('<div id="popup_panel"><input type="button" value="' + $.alerts.collectPrize + '" id="popup_collect" /> <input type="button" value="' + $.alerts.loadBalance + '" id="popup_load" /> <input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>');
                    $("#popup_collect").on("click", function () {
                        $.alerts._hide();
                        if (callback) {
                            callback(true)
                        }
                    });
                    $("#popup_load").on("click", function () {
                        $.alerts._hide();
                        if (callback2) {
                            callback2(true)
                        }
                    });
                    $("#popup_cancel").on("click", function () {
                        $.alerts._hide();
                        if (callback) {
                            callback(false)
                        }
                        if (callback2) {
                            callback2(false)
                        }
                    });
                    $("#popup_cancel").focus();
                    $("#popup_collect").keypress(function (e) {
                        if (e.keyCode == 13) {
                            $("#popup_collect").trigger('click')
                        }
                        if (e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    $("#popup_load").keypress(function (e) {
                        if (e.keyCode == 13) {
                            $("#popup_load").trigger('click')
                        }
                        if (e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    $("#popup_cancel").keypress(function (e) {
                        if (e.keyCode == 13 || e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    break
                case 'awards':
                    var content = '<div id="popup_panel"><input type="button" value="' + $.alerts.continueButton + '" id="popup_continue" />';
                    if(callback2!=null) {
                        content += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="' + $.alerts.toLoadBalance + '" id="popup_toload" />';
                    }
                    content += '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="' + $.alerts.cancelButton + '" id="popup_cancel" /></div>'
                    $("#popup_message").after(content);
                    $("#popup_continue").on("click", function () {
                        $.alerts._hide();
                        if (callback) {
                            callback(true)
                        }
                    });
                    $("#popup_toload").on("click", function () {
                        $.alerts._hide();
                        if (callback2) {
                            callback2(true)
                        }
                    });
                    $("#popup_cancel").on("click", function () {
                        $.alerts._hide();
                        if(callback) {
                            callback(false)
                        }
                        if(callback2) {
                            callback2(false)
                        }
                    });
                    $("#popup_cancel").focus();
                    $("#popup_continue").keypress(function (e) {
                        if (e.keyCode == 13) {
                            $("#popup_continue").trigger('click')
                        }
                        if (e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    $("#popup_toload").keypress(function (e) {
                        if (e.keyCode == 13) {
                            $("#popup_toload").trigger('click')
                        }
                        if (e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    $("#popup_cancel").keypress(function (e) {
                        if (e.keyCode == 13 || e.keyCode == 27) {
                            $("#popup_cancel").trigger('click')
                        }
                    });
                    break
            }
            // Make draggable
            if ($.alerts.draggable) {
                try {
                    $("#popup_container").draggable({ handle: $("#popup_title") });
                    $("#popup_title").css({ cursor: 'move' })
                } catch (e) { /* requires jQuery UI draggables */
                }
            }
        },
        _hide: function () {
            $("#popup_container").remove();
            $.alerts._overlay('hide');
            $.alerts._maintainPosition(false)
        },
        _overlay: function (status) {
            switch (status) {
                case 'show':
                    $.alerts._overlay('hide');
                    $("BODY").append('<div id="popup_overlay"></div>');
                    $("#popup_overlay").css({
                        position: 'absolute',
                        zIndex: 99998,
                        top: '0px',
                        left: '0px',
                        width: '100%',
                        height: $(document).height(),
                        background: $.alerts.overlayColor,
                        opacity: $.alerts.overlayOpacity
                    });
                    break;
                case 'hide':
                    $("#popup_overlay").remove();
                    break
            }
        },
        _reposition: function () {
            var top = (($(window).height() / 2) - ($("#popup_container").outerHeight() / 2)) + $.alerts.verticalOffset;
            var left = (($(window).width() / 2) - ($("#popup_container").outerWidth() / 2)) + $.alerts.horizontalOffset;
            if (top < 0) top = 0;
            if (left < 0) left = 0;
            $("#popup_container").css({
                top: top + 'px',
                left: left + 'px'
            });
            $("#popup_overlay").height($(document).height())
        },

        _maintainPosition: function (status) {
            if ($.alerts.repositionOnResize) {
                switch (status) {
                    case true:
                        $(window).bind('resize', $.alerts._reposition);
                        break;
                    case false:
                        $(window).unbind('resize', $.alerts._reposition);
                        break
                }
            }
        }
    };
    // Shortuct functions
    jAlert = function (message, title, callback) {
        $.alerts.alert(message, title, callback)
    };
    jAlertAgora = function (message, title, callback) {
        $.alerts.alertAgora(message, title, callback)
    };
    jConfirm = function (message, title, callback) {
        $.alerts.confirm(message, title, callback)
    };
    jPrompt = function (message, value, title, callback) {
        $.alerts.prompt(message, value, title, callback)
    };
    jCondition = function (message, title, callback, callback2) {
        $.alerts.condition(message, title, callback, callback2)
    };
    jPrint = function (message, title, callback) {
        $.alerts.print(message, title, callback)
    };
    jAwards = function (message, title, callback, callback2) {
        $.alerts.awards(message, title, callback, callback2)
    };
})(jQuery);