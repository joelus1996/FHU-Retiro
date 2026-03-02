/* jQuery Validator 1.0
 * - Form Validate -
 * by: George Breagan Minaya Silencio
 *
 */
;
(function ($, window) {
    var Validator = function (selector, options) {
        this.$selector = $(selector);
        this.init(options)
    };
    var regExp = {
        email: /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
        number: /^\d*$/
    };
    var checker = true;
    var message = '';
    Validator.prototype = {

        defaults : {
            messages: true,
            valid : function(){}
        },
        init: function (options) {
            this.config = $.extend({}, this.defaults, options);
            this.getFields();
//            this.fn = fn;
            this.disabledSubmit();
            this.remakeForm();
            var that = this;
            $(this.$selector).find('*[type="button"]').eq(0).on('click', function () {
                that.process();
                that.execute()
            })
        },
        getFields: function () {
            this.$fields = this.$selector.find('input, select')
        },
        disabledSubmit: function () {
            this.$selector.find('*[type="submit"]').eq(0).attr('type', 'button')
        },
        remakeForm: function () {
            this.$fields.each(function () {
                if ($(this).attr('type') !== 'submit' || $(this).attr('type') !== 'button') {
                    $(this).wrap(Validator.wrapper())
                }
            });
            this.getFields()
        },
        process: function () {
            var that = this;
            checker = true;
            message = '';
            this.$fields.each(function () {
                if ($(this).val() === '' && $(this).attr('required') !== undefined) {
                    message = 'Campo requerido';
                    checker = false;
                } else {
                    if ($(this).data('type') !== undefined) {
                        if ($(this).attr('type') === 'text' &&
                            $(this).data('type') === 'number' && !regExp.number.test($(this).val())) {
                            message = 'Escriba un número';
                            checker = false
                        } else if ($(this).attr('type') === 'text' &&
                            $(this).data('type') === 'email' && !regExp.email.test($(this).val())) {
                            message = 'Email no válido';
                            checker = false
                        } else if ($(this).attr('type') === 'checkbox' &&
                            $(this).data('type') === 'check') {
                            if (!$(this).prop('checked')) {
                                message = 'Opción requerida';
                                checker = false
                            }
                        }
                    }
                }
                if ($(this).data('sise') !== undefined && parseInt($(this).data('sise')) < $.trim($(this).val()).length) {
                    message = 'Debe contener ' + $(this).data('sise') + 'dígitos';
                    checker = false
                }
                if (!checker) {
                    if (that.config.messages) {
                        $(this).bubble(message)
                    } else {
                        $(this).explode()
                    }
                }
                return checker
            });
            return checker
        },
        execute: function () {
            if (checker) {
                this.config.valid.call(this)
            }
        }
    };
    Validator.wrapper = function () {
        return '<div class="ui-wrapper-field">'
    };
//    $.fn.extend({
    $.fn.exists= function () {
            return ($(this).length > 0)
        };
    $.fn.bubble= function (message) {
            if (!this.prev('.ui-bubble').exists()) {
                this.parent('.ui-wrapper-field').prepend('<div class="ui-bubble shake">' + message + '</div>');
                this.on('keyup change', function () {
                    if ($(this).val() !== '') {
                        $(this).prev('.ui-bubble').remove();
                        $(this).off()
                    }
                });
            } else {
                var bubble = this.prev('.ui-bubble');
                bubble.addClass('pulse');
                setTimeout(function () {
                    bubble.removeClass('shake pulse')
                }, 300)
            }
        };
    $.fn.explode= function () {
            if (!this.parent('.ui-wrapper-field').hasClass('invalid')) {
                this.parent('.ui-wrapper-field').addClass('invalid');
                this.on('keyup change', function () {
                    if ($(this).val() !== '') {
                        $(this).parent('.ui-wrapper-field').removeClass('invalid');
                        $(this).off()
                    }
                });
            } else {
                var field = this.parent('.ui-wrapper-field');
                field.addClass('explode');
                setTimeout(function () {
                    field.removeClass('explode')
                }, 1000)
            }
        };
//    });
    $.fn.validator = function (options) {
        if (typeof options == 'object' || !options) {
            this.data('validator', new Validator(this, options))
        } else {
            $.error('Parámetro enviado no es un objecto.')
        }
        return this
    };
//    $.fn.exists = function () {
//        return ($(this).length > 0)
//    };
//    $.fn.bubble = function (message) {
//        if (!this.prev('.ui-bubble').exists()) {
//            this.parent('.ui-wrapper-field').prepend('<div class="ui-bubble shake">' + message + '</div>');
//            this.on('keyup change', function () {
//                if ($(this).val() !== '') {
//                    $(this).prev('.ui-bubble').remove();
//                    $(this).off()
//                }
//            });
//        } else {
//            var bubble = this.prev('.ui-bubble');
//            bubble.addClass('pulse');
//            setTimeout(function () {
//                bubble.removeClass('shake pulse')
//            }, 300)
//        }
//    };
   // window.Validator = Validator
})(jQuery, window);