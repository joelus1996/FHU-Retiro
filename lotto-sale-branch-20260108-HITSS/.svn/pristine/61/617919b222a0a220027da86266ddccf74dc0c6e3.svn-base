/**************************************
 * modal
 **************************************/
const simpleModal = (function () {
    'use strict';
    let modalClose = $('.modal .iclose'),
        modalToggle = $('.modal [toggle-modal]'),

        open = function (select) {
            let box = $(select);
            box.fadeIn(350);
            $('body').addClass('no-scroll');

        },

        close = function (select) {
            const box = $(select);
            box.fadeOut(250, function () {
                $('body').removeClass('no-scroll');
            });
        },

        onClickClose = function () {
        	closePopUpIframeTYCPDP();
        },

        preOpen = function (e) {
            e.preventDefault();
            open($(this).attr('open-modal'));
        },

        onToggleModal = function (e) {
            e.preventDefault();
            var target = $(e.currentTarget).attr('toggle-modal');
            const box = $('.ioverlay');

            box.fadeOut(250, function () {
                $('body').removeClass('no-scroll');
                setTimeout(function () {
                    open(target);
                }, 250);
            });
        },

        onToggleModalButton = function (e) {
            const target = $(e).attr('toggle-modal');
            const box = $('.ioverlay');
            box.fadeOut(250, function () {
                $('body').removeClass('no-scroll');
                setTimeout(function () {
                    open(target);
                }, 250);
            });
        },

        onToggleModalButtonOld = function (e) {
            const target = $(e).attr('toggle-modal');
            const box = $('.ioverlay');
            box.fadeOut(250, function () {
                $('body').removeClass('no-scroll');
                setTimeout(function () {
                    open(target);
                }, 250);
            });
        },

        onToggleModalMsg = function (toggle) {
            const target = toggle;
            const box = $('.ioverlay');
            box.fadeOut(250, function () {
                $('body').removeClass('no-scroll');
                setTimeout(function () {
                    open(target);
                }, 250);
            });
        },

        init = function () {
            modalClose.on('click', onClickClose);
            modalToggle.on('click', onToggleModal);
            $('*[open-modal]').on('click', preOpen);
        };

    return {
        init: init,
        open: open,
        close: close,
        onToggleModalButton: onToggleModalButton,
        onToggleModalMsg: onToggleModalMsg,
        onToggleModalButtonOld: onToggleModalButtonOld
    };
}());

$(document).ready(function () {
    'use strict';
    simpleModal.init();
    window.parent.postMessage('footerRetirarLoading', '*');
});

function saveAcceptedDocumentsTYCPDP(fnTraza) {
    $.ajax({
        url: 'save-accepted-documents.html',
        type: 'post',
        contentType: 'application/json',
        dataType: 'json',
        beforeSend: function () {
            $('body').append('<div id="loading-recharge" class="loading-ilot" style="z-index: 2147483648 !important;"></div>');
        }
    }).done(function (data) {
    	if (data.result == "OK") {
    		window.parent.postMessage(fnTraza, "*");
    	}
    }).always(function () {
    	$('body').find('#loading-recharge').remove();
    	closePopUpIframeTYCPDP();    	
    });
}

function closePopUpIframeTYCPDP() {
    const box = $(this).closest('.ioverlay');
    datalayerCerrarModal();
    box.fadeOut(250, function () {
        $('body').removeClass('no-scroll');
    });
    try {
        window.parent.postMessage('closeLightboxTYCPDP', '*');
    } catch (e) { }
}
