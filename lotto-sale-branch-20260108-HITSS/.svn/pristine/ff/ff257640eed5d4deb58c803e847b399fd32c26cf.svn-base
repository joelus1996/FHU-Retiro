/**
 * @Global +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

(function(funcName, baseObj) {
    "use strict";
    funcName = funcName || "docReady";
    baseObj = baseObj || window;
    var readyList = [];
    var readyFired = false;
    var readyEventHandlersInstalled = false;

    function ready() {
        if (!readyFired) {
            readyFired = true;
            for (var i = 0; i < readyList.length; i++) {
                readyList[i].fn.call(window, readyList[i].ctx);
            }
            readyList = [];
        }
    }

    function readyStateChange() {
        if ( document.readyState === "complete" ) {
            ready();
        }
    }

    baseObj[funcName] = function(callback, context) {
        if (typeof callback !== "function") {
            throw new TypeError("callback for docReady(fn) must be a function");
        }

        if (readyFired) {
            setTimeout(function() {callback(context);}, 1);
            return;
        } else {
            readyList.push({fn: callback, ctx: context});
        }

        if (document.readyState === "complete" || (!document.attachEvent && document.readyState === "interactive")) {
            setTimeout(ready, 1);
        } else if (!readyEventHandlersInstalled) {
            if (document.addEventListener) {
                document.addEventListener("DOMContentLoaded", ready, false);
                window.addEventListener("load", ready, false);
            } else {
                document.attachEvent("onreadystatechange", readyStateChange);
                window.attachEvent("onload", ready);
            }
            readyEventHandlersInstalled = true;
        }
    }
})('documentReadyStatement', window);


function scrollToReferer( destination, duration, easing, callback ) {

    var easings = {
        linear: function(t) { return t; },
        easeInQuad: function(t) { return t * t; },
        easeOutQuad: function(t) { return t * (2 - t); },
        easeInOutQuad: function(t) { return t < 0.5 ? 2 * t * t : -1 + (4 - 2 * t) * t; },
        easeInCubic: function(t) { return t * t * t; },
        easeOutCubic: function(t) { return (--t) * t * t + 1; },
        easeInOutCubic: function(t) { return t < 0.5 ? 4 * t * t * t : (t - 1) * (2 * t - 2) * (2 * t - 2) + 1; },
        easeInQuart: function(t) { return t * t * t * t; },
        easeOutQuart: function(t) { return 1 - (--t) * t * t * t; },
        easeInOutQuart: function(t) { return t < 0.5 ? 8 * t * t * t * t : 1 - 8 * (--t) * t * t * t; },
        easeInQuint: function(t) { return t * t * t * t * t; },
        easeOutQuint: function(t) { return 1 + (--t) * t * t * t * t; },
        easeInOutQuint: function(t) { return t < 0.5 ? 16 * t * t * t * t * t : 1 + 16 * (--t) * t * t * t * t; }
    };

    var start = window.pageYOffset;
    var startTime = 'now' in window.performance ? performance.now() : new Date().getTime();

    var documentHeight = Math.max(document.body.scrollHeight, document.body.offsetHeight, document.documentElement.clientHeight, document.documentElement.scrollHeight, document.documentElement.offsetHeight);
    var windowHeight = window.innerHeight || document.documentElement.clientHeight || document.getElementsByTagName('body')[0].clientHeight;
    var destinationOffset = typeof destination === 'number' ? destination : destination.offsetTop;
    var destinationOffsetToScroll = Math.round(documentHeight - destinationOffset < windowHeight ? documentHeight - windowHeight : destinationOffset);

    if ('requestAnimationFrame' in window === false) {
        window.scroll(0, destinationOffsetToScroll);
        if (callback) {
            callback();
        }
        return;
    }

    function scroll() {
        var now = 'now' in window.performance ? performance.now() : new Date().getTime();
        var time = Math.min(1, ((now - startTime) / duration));
        var timeFunction = easings[easing](time);
        window.scroll(0, Math.ceil((timeFunction * (destinationOffsetToScroll - start)) + start));

        if (window.pageYOffset === destinationOffsetToScroll) {
            if (callback) {
                callback(destination);
            }
            return;
        }

        requestAnimationFrame(scroll);
    }

    scroll();
}


/**
 * form serialize
 */
function formSerialize( form ) {
    var obj = {};
    var elements = form.querySelectorAll( "input, select, textarea" );
    for( var i = 0; i < elements.length; ++i ) {
        var element = elements[i];
        var name = element.name;
        var value = element.value;

        if( name ) {
            obj[ name ] = value;
        }
    }

    return obj;
}


/**
 * @JsxModal
 */
var JsxModal = {
    open: function( idx ) {
        if ( typeof idx !== 'undefined' ) { document.querySelectorAll('[data-jsx-modal-id="'+idx+'"]')[0].classList.add('is-active'); }
        if ( ! document.body.classList.contains('md-hidden') ) { document.body.classList.add('md-hidden') }
    },
    close: function( idx, callback ) {
        if ( typeof idx !== 'undefined' ) { document.querySelectorAll('[data-jsx-modal-id="'+idx+'"]')[0].classList.remove('is-active'); }
        if ( document.body.classList.contains('md-hidden') ) { document.body.classList.remove('md-hidden') }
    }
};

/**
 * @Global -------------------------------------------------------------------------
 */


documentReadyStatement(function() {
    /**
     * define @JsxModal
     */
    if ( document.querySelectorAll('[data-jsx-modal-open]') || document.querySelectorAll('[data-jsx-modal-close]') ) {
        var jsxModalTargets = document.querySelectorAll('[data-jsx-modal-open]');
        var jsxModalCloseTargets = document.querySelectorAll('[data-jsx-modal-close]');

        [].forEach.call(jsxModalTargets, function (jsxModalTarget) {
            jsxModalTarget.addEventListener('click', function (e) {
                e.preventDefault();
                var idx = e.currentTarget.getAttribute('data-jsx-modal-open');
                idx != '' ? JsxModal.open(idx) : console.error('The JsxModal ID is not provided.');
            }, false);
        });

        [].forEach.call(jsxModalCloseTargets, function (jsxModalCloseTarget) {
            jsxModalCloseTarget.addEventListener('click', function (e) {
                e.preventDefault();
                var idx = e.currentTarget.getAttribute('data-jsx-modal-close');
                idx != '' ? JsxModal.close(idx) : console.error('The JsxModal ID is not provided.');

                var videoId = idx.replace('#', '');
                var myPlayer = videojs(videoId);
                myPlayer.pause();
            }, false);
        });
    }


    /**
     * define @video Slider
     */
    if ( document.querySelector('.il-rs-video-list') ) {
        var videoSlides = document.querySelectorAll('.il-rs-video-item');
        var videoSlideActive = document.querySelector('.il-rs-video-item.is-active');
        for ( var i = 0; i < videoSlides.length; i++ ) {
            videoSlides[i].addEventListener('click', function() {
                for ( var j = 0; j < videoSlides.length; j++ ) {
                    if ( videoSlides[j].classList.contains('is-active') ) {
                        videoSlides[j].classList.remove('is-active');
                    }

                    if ( videoSlides[j].classList.contains('is-prev') ) {
                        videoSlides[j].classList.remove('is-prev');
                    }

                    if ( videoSlides[j].classList.contains('is-next') ) {
                        videoSlides[j].classList.remove('is-next');
                    }
                }

                if ( ! this.classList.contains('is-active') ) {
                    this.classList.add('is-active');

                    if ( this.previousElementSibling ) {
                        this.previousElementSibling.classList.add('is-prev');
                    } else {
                        videoSlides[videoSlides.length-1].classList.add('is-prev');
                    }

                    if ( this.nextElementSibling ) {
                        this.nextElementSibling.classList.add('is-next');
                    } else {
                        console.log(videoSlides[0]);
                        videoSlides[0].classList.add('is-next');
                    }
                }
            }, false);
        }

        document.querySelector('.il-rs-video-control-prev').addEventListener('click', function( e ) {
            e.preventDefault();

        }, false);

        document.querySelector('.il-rs-video-control-next').addEventListener('click', function( e ) {
            e.preventDefault();

            var activeIdx = 0;

            for ( var k = 0; k < videoSlides.length; k++ ) {
                if ( videoSlides[k] == videoSlideActive ) {
                    activeIdx = k;
                }
            }
        }, false);
    }


    /**
     * @Dropdown
     */
    if ( document.querySelector('.il-r-dropdown') ) {
        var dropdowns = document.querySelectorAll('.il-r-dropdown');

        for ( var k = 0; k < dropdowns.length; k++ ) {
            dropdowns[k].querySelector('a').addEventListener('click', function( e ) {
                e.preventDefault();
                this.classList.toggle('is-active');
            }, false);

            var selectItems = dropdowns[k].querySelectorAll('.dropdown-select li');
            for ( var j = 0; j < selectItems.length; j++ ) {
                selectItems[j].addEventListener('click', function( e ) {
                    var dropdownId = this.parentNode.parentNode.getAttribute('data-dropdown-id');
                    var data = {
                        field: this.getAttribute('data-field-name'),
                        value: this.getAttribute('data-value')
                    };

                    if ( document.querySelector('input[name="'+data.field+'"]') ) {
                        document.querySelector('input[name="'+data.field+'"]').value = data.value;
                    }

                    this.parentNode.previousElementSibling.querySelector('span').innerText = data.value;

                    if ( this.parentNode.previousElementSibling.classList.contains('is-active') ) {
                        this.parentNode.previousElementSibling.classList.remove('is-active');
                    }

                    if ( dropdownId == 'memories' ) {
                        console.log(data);
                        var inputData = data;
                        var xhr = new XMLHttpRequest();
                        xhr.open('GET', 'https://jsonplaceholder.typicode.com/posts/'+data.value);
                        xhr.onload = function() {
                            if ( xhr.status == 200 ) {
                                var data = JSON.parse(xhr.responseText);
                                document.querySelector('.download-memory').setAttribute('href', 'https://jsonplaceholder.typicode.com/posts/'+inputData.value);
                            } else {
                                console.error('something went wrong.');
                            }
                        };
                        xhr.send();
                    }
                }, false);
            }

            dropdowns[k].querySelector('.dropdown-select').addEventListener('mouseleave', function() {
                if ( this.previousElementSibling.classList.contains('is-active') ) {
                    this.previousElementSibling.classList.remove('is-active');
                }
            }, false);
        }
    }


    /**
     * scroll to referer
     */
    var scrollToRefererElements = document.querySelectorAll('[data-scroll-to-referer="true"]');
    for ( var dx = 0; dx < scrollToRefererElements.length; dx++ ) {
        scrollToRefererElements[dx].addEventListener('click', function( e ) {
            e.preventDefault();

            var href = this.getAttribute('href') || this.getAttribute('data-referer');
            if ( typeof href !== 'undefined' || href != '' ) {
                scrollToReferer(document.getElementById(href), 1000, 'easeInOutQuint', function( idx ) {
                    var active = idx.getAttribute('id');

                    for ( var dy = 0; dy < scrollToRefererElements.length; dy++ ) {
                        if ( scrollToRefererElements[dy].classList.contains('is-active') ) {
                            scrollToRefererElements[dy].classList.remove('is-active');
                        }
                    }

                    document.querySelector('[href="'+active+'"]').classList.add('is-active');
                });
            }
        });
    }

    /**
     * ajax form '#financial-information'
     */
    if ( document.getElementById('financial-information') ) {
        document.getElementById('financial-information').addEventListener('submit', function( e ) {
            e.preventDefault(); e.stopPropagation();
            var formData = formSerialize( this );
            var formDataLn = Object.keys(formData).length;
            var formId = this.getAttribute('id');
            var resultContent = document.querySelector('[data-search-result-content="'+formId+'"]');
            var iteral = 0;

            for ( var prop in formData ) {
                iteral++;
                if ( formData.hasOwnProperty(prop) ) {
                    if ( formData[prop] != '' ) {
                        if ( document.querySelector('[data-dropdown-name="'+prop+'"]').classList.contains('is-empty') ) {
                            document.querySelector('[data-dropdown-name="'+prop+'"]').classList.remove('is-empty');
                        }

                        if ( iteral == formDataLn ) {
                            var xhr = new XMLHttpRequest();
                            var htmlMarkup = '<div class="il-r-table-row"> <div class="il-r-table-col">año</div><div class="il-r-table-col">Documento</div><div class="il-r-table-col">descargar</div></div>';

                            xhr.open('GET', 'https://jsonplaceholder.typicode.com/posts');

                            xhr.onload = function() {
                                if ( xhr.status == 200 ) {
                                    var data = JSON.parse(xhr.responseText);

                                    data.forEach(function( value, key ) {
                                        if ( key <= 15 ) {
                                            htmlMarkup += '<div class="il-r-table-row">';
                                            htmlMarkup += '<div class="il-r-table-col"><span>'+value.id+'</span></div>';
                                            htmlMarkup += '<div class="il-r-table-col"><span>'+value.title+'</span></div>';
                                            htmlMarkup += '<div class="il-r-table-col"><a href="#" download><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 16.89 15.48" width="16.89" height="15.48"><polygon points="4.22 6.33 8.44 11.26 12.66 6.33 9.15 6.33 9.15 0 7.74 0 7.74 6.33 4.22 6.33" fill="#959595"/><path d="M15.48,14.07H1.41V9.85H0v4.93a.7.7,0,0,0,.7.7H16.18a.7.7,0,0,0,.7-.7V9.85H15.48Z" fill="#959595"/></svg></a></div>';
                                            htmlMarkup += '</div>';

                                            if ( key == 15 ) { // data.length
                                                resultContent.innerHTML = htmlMarkup;
                                            }
                                        }
                                    });

                                    for ( var property in formData ) {
                                        var placeholder = document.querySelector('[data-dropdown-name="'+property+'"]').getAttribute('data-placeholder');
                                        document.querySelector('[data-dropdown-name="'+property+'"] span').innerText = placeholder;
                                        document.querySelector('input[name="'+property+'"]').value = '';
                                    }
                                } else {
                                    console.error('something went wrong.');
                                }
                            };

                            xhr.loadstart = function() {
                                this.querySelector('button').setAttribute('disabled', 'disabled');
                            };

                            xhr.loadend = function() {
                                this.querySelector('button').removeAttribute('disabled');
                            };

                            xhr.send();
                        }
                    } else {
                        if ( ! document.querySelector('[data-value-empty="'+prop+'"]').classList.contains('is-empty') ) {
                            document.querySelector('[data-value-empty="'+prop+'"]').classList.add('is-empty');
                        }
                    }
                }
            }
        }, false);
    }
});
