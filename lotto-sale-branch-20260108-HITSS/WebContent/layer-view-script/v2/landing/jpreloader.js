(function($) {
    var items = new Array(),
        errors = new Array(),
        onComplete = function() {},
        current = 0,
        precurrent = 0;

    var jpreOptions = {
        splashVPos: '35%',
        loaderVPos: '75%',
        splashID: '#jpreContent',
        showSplash: true,
        showPercentage: true,
        autoClose: true,
        closeBtnText: 'Start!',
        onetimeLoad: false,
        debugMode: false
    }

    //cookie
    var getCookie = function() {
        if( jpreOptions.onetimeLoad ) {
            var cookies = document.cookie.split('; ');
            for (var i = 0, parts; (parts = cookies[i] && cookies[i].split('=')); i++) {
                if ((parts.shift()) === "jpreLoader") {
                    return (parts.join('='));
                }
            }
            return false;
        } else {
            return false;
        }

    }
    var setCookie = function(expires) {
        if( jpreOptions.onetimeLoad ) {
            var exdate = new Date();
            exdate.setDate( exdate.getDate() + expires );
            var c_value = ((expires==null) ? "" : "expires=" + exdate.toUTCString());
            document.cookie="jpreLoader=loaded; " + c_value;
        }
    }

    //get all images from css and <img> tag
    var getImages = function(element) {

        var event = document.createEvent('Event');
        event.initEvent('percentUpdate', true, true);

        $(element).find('*:not(script)').each(function() {
            var url = "";

            if ($(this).css('background-image').indexOf('none') == -1 && $(this).css('background-image').indexOf('-gradient') == -1) {
                url = $(this).css('background-image');
                if(url.indexOf('url') != -1) {
                    var temp = url.match(/url\((.*?)\)/);
                    url = temp[1].replace(/\"/g, '');
                }
            } else if ($(this).get(0).nodeName.toLowerCase() == 'img' && typeof($(this).attr('src')) != 'undefined') {
                url = $(this).attr('src');
            }

            if (url.length > 0) {
                items.push(url);
            }
        });
    }

    //create preloaded image
    var preloading = function(element) {
        for (var i = 0; i < items.length; i++) {
            if(loadImg(items[i], element));
        }
    }
    var loadImg = function(url, element) {
        var imgLoad = new Image();
        $(imgLoad).on('load', function() {
                completeLoading(element);
            }
        ).on('error', function() {
                errors.push($(this).attr('src'));
                completeLoading(element);
            }
        ).attr('src', url);
    }

    //update progress bar once image loaded
    var completeLoading = function(element) {
        current++;

        var per = Math.round((current / items.length) * 100);

        $(element).trigger( 'percentUpdate', [ per ] );

        //if all images loaded
        if(current >= items.length) {
            current = items.length;
            setCookie();    //create cookie
            loadComplete();
            //fire debug mode
            if (jpreOptions.debugMode) {
                var error = debug();
            }
        }
    }
    //triggered when all images are loaded
    var loadComplete = function() {
        onComplete();   //callback function
    }

    //debug mode
    var debug = function() {
        if(errors.length > 0) {
            var str = 'ERROR - IMAGE FILES MISSING!!!\n\r'
            str += errors.length + ' image files cound not be found. \n\r';
            str += 'Please check your image paths and filenames:\n\r';
            for (var i = 0; i < errors.length; i++) {
                str += '- ' + errors[i] + '\n\r';
            }
            return true;
        } else {
            return false;
        }
    }

    $.fn.jpreLoader = function(options, callback) {
        if(options) {
            $.extend(jpreOptions, options );
        }
        if(typeof callback == 'function') {
            onComplete = callback;
        }

        return this.each(function() {
            if( !(getCookie()) ) {
                getImages(this);
                preloading(this);
            }
            else {  //onetime load / cookie is set
                onComplete();
            }
        });
    };

})(jQuery);