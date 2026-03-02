$.fn.mPopup = function (options) {
    // Setting component
    let settings = $.extend({
            popup_id: '',
            open_element: '.m-popup__open-element',
            close_element: ''
        }, options)

    // Validating close element
    if (settings.close_element && settings.close_element !== '') {
        settings.close_element = ', ' + settings.close_element
    }

    // Vars
    let $currentPopup = $(this),
        $closeElements = $('.m-popup__close-element, .m-overlay' + settings.close_element),
        $popupElement = $('.m-popup'),
        $overlayElement = $('.m-overlay'),
        closePopup,
        openPopup

    // Open current popup function
    openPopup = function() {
        $overlayElement.addClass ('js--active')
        $currentPopup.addClass ('js--active')

        // Run setings open function
        if (settings.on_open !== null && settings.on_open !== undefined) {
            settings.on_open($currentPopup)
        }
    }

    // Close current popup function
    closePopup = function() {
        $overlayElement.removeClass ('js--active')
        $popupElement.removeClass ('js--active')

        // Run setings close function
        if (settings.on_close !== null && settings.on_close !== undefined) {
            settings.on_close($currentPopup)
        }
    }

    // Click event to open the current popup
    $('body').on('click', settings.open_element, function(e) {
        e.preventDefault()

        // Open popup
        openPopup()
    })

    // Click event to close popup
    $closeElements.on('click', function(e) {
        e.preventDefault()

        let $closeElement = $(this)

        $closeElement.fadeOut()

        setTimeout(function() {
            $closeElement.fadeIn()
        }, 900)

        // Close popup
        closePopup()
    })

    // Key event
    $(document).keyup(function(e) {
        if (e.keyCode == 27) {
            // Load close popup function
            closePopup()
        }
    })
}

// Load winners popup
$('#winners-popup').mPopup({
    open_element: '.open-winners-popup',
    on_open: function (current_popup){
    },
    on_close: function (current_popup){
    }
})

class SliderWinners {
    constructor(options) {
        // options
        this.numSlides = (options && options.numSlides) ? options.numSlides : 1

        // vars
        this.slider = null
        this.$slider = document.querySelector('#m-winners__slider')
        this.$winnerPopUp = document.querySelector('#winners-popup')
        this.$containerNumbers = document.querySelectorAll('.m-popup-winner__numbers div')
        this.options = {
            gap : 0,
            startAt: 0, 
            perView: 1, 
            type: 'slider', 
            focusAt: 'center',
            animationDuration: 800
        }
    }

    load() {
        if (this.$slider) {
            this.slider = new Glide(this.$slider, this.options)

            // load
            this.slider.mount()

            // rung events
            this.events()

            // set total nav
            document.querySelector('.slider-bullet-count').innerHTML = this.numSlides
        }
    }

    events() {
        let
            currentIndex,
            $currentSlider

        this.slider.on(['run.after'], () => {
            // get current
            $currentSlider = document.querySelector(`#m-winners__slider li.glide__slide--active`)

            // update number nav
            currentIndex = (this.slider.index + 1)
            document.querySelector('.slider-bullet-current-index').innerHTML = currentIndex
            
            // update nav
            this.setArrowsClass(currentIndex)
        })
    }

    setArrowsClass(currentIndex) {
        let
            $prev = document.querySelector('.glide__arrow--prev'),
            $next = document.querySelector('.glide__arrow--next')

        // reset
        $next.classList.remove('glide__arrow--disabled')
        $prev.classList.remove('glide__arrow--disabled')

        if (currentIndex === 1) {
            $prev.classList.add('glide__arrow--disabled')
        } else if (this.numSlides === currentIndex) {
            $next.classList.add('glide__arrow--disabled')
        }
    }

    destroy() {
        if (this.slider) {
            this.slider.destroy()
        }
    }
}

class Winners {
    constructor(url) {
        // options
        this.url = url

        // vars
        this.data = null
        this.$containerGlide = document.querySelector('.glide')
        this.$popupWinner = document.querySelector('.m-popup-winner')
        this.$containerSlides = document.querySelector('.glide__slides')
        this.$banner = document.querySelector('.m-banner-winner__gana-diario')
        this.$containerNumbers = document.querySelectorAll('.m-popup-winner__numbers div')
    }

    renderNumbers(numbers) {
        if (numbers) {
            numbers = numbers.split('-')

            // interating dots
            this.$containerNumbers.forEach( (elementNumber, index) => {
                elementNumber.innerHTML = numbers[index]
            })
        }
    }

    renderArrows() {
        let
            arrows = `
                <div class="glide__controls glide__arrows" data-glide-el="controls">
                    <button class="slider__arrow slider__arrow--prev glide__arrow glide__arrow--prev glide__arrow--circle glide__arrow--hover" data-glide-dir="<">
                    <svg xmlns="http://www.w3.org/2000/svg" width="9" height="12" viewBox="0 0 9 15" fill="none">
                        <path xmlns="http://www.w3.org/2000/svg" fill-rule="evenodd" clip-rule="evenodd" d="M9 1.75L3.40541 7.5L9 13.25L7.2973 15L2.98319e-08 7.5L7.2973 -2.23283e-07L9 1.75Z" fill="#F06500"></path>
                    </svg>
                    </button>
                    <div class="slider__bullet-wrapper">  
                        <div class="slider__bullets-index">
                            <small>
                                <span class="slider-bullet-current-index">1</span>
                                <span> de </span>
                                <span class="slider-bullet-count"></span>
                            </small>
                        </div>
                    </div>
                    <button class="slider__arrow slider__arrow--next glide__arrow glide__arrow--next glide__arrow--circle glide__arrow--hover" data-glide-dir=">">
                    <svg xmlns="http://www.w3.org/2000/svg" width="9" height="12" viewBox="0 0 9 15" fill="none">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M-5.79176e-07 13.25L5.59459 7.5L-7.64949e-08 1.75L1.7027 7.44275e-08L9 7.5L1.7027 15L-5.79176e-07 13.25Z" fill="#F06500"></path>
                    </svg>
                    </button>
                </div>`

        this.$containerGlide.innerHTML += arrows
    }

    isActive() {
        if (this.data && this.data.length) {
            // show banner
            this.$banner.style.display = 'inline-block'

            return true
        } else {
            // hide banner
            this.$banner.style.display = 'none'

            return false
        }
    }

    renderWinner() {
        let
            winnersHtml = ''
        
        // validating data
        if (this.isActive()) {
            // validating number of winners
            if (this.data.length > 1) {
                this.$popupWinner.classList.add('m-large')
            }

            // iterating data winners
            this.data.forEach((winner, index) => {
                winnersHtml += `
                    <li class="glide__slide" data-slider-index="${index}">
                        <div class="m-popup-winner__info">
                            <div class="m-box-container">
                                <div class="m-box">
                                    <h4>Fecha</h4>
                                    <p>${winner.date}</p>
                                    </div>
                                    <div class="m-box">
                                    <h4>Punto de venta</h4>
                                    <p>${winner.location}</p>
                                </div>
                            </div>
                            <div class="m-box m-box--height">
                                <h4>Direcci&oacute;n</h4>
                                <p>${winner.address.split(' [')[0]}</p>
                            </div>
                        </div>
                    </li>`
            })

            new SliderWinners().destroy()

            // render
            this.$containerSlides.innerHTML = winnersHtml

            // do slider
            new SliderWinners({
                numSlides: this.data.length
            }).load()
        }
    }

    async fetch() {
        let response = await fetch(this.url)

        if (response.ok) {
            let
                winners = await response.json()

            this.data = winners.winners.data

            // render
            this.renderNumbers(winners.winners.numbers)
            this.renderWinner()
        }
    }

    init() {
        if (this.$banner && this.$containerNumbers && this.$popupWinner && this.$containerGlide && this.$containerSlides) {
            this.fetch()
        }
    }
}

window.addEventListener('DOMContentLoaded', (event) => {
    const
        winnerGandaDiario = new Winners('https://www.latinka.com.pe/gd-app-ws/api/draw/data')

    // video
    let home = (function() {
        let init,
            timer,
            popups,
            videoCore,
            videoService,
            urlVideo = ''

        // principal video logic
        videoCore = {
            load: function(dataVideo) {
                let message = (dataVideo.hasOwnProperty('message')) ? dataVideo.message : 'Sigue cruzando los dedos, en unos minutos estaremos de vuelta',
                    status = (dataVideo.hasOwnProperty('status')) ? dataVideo.status : 3,
                    hours = (dataVideo.hasOwnProperty('data') && dataVideo.data.hasOwnProperty('w_hour')) ? dataVideo.data.w_hour : 0,
                    minutes = (dataVideo.hasOwnProperty('data') &&dataVideo.data.hasOwnProperty('w_minute')) ? dataVideo.data.w_minute : 0,
                    seconds = (dataVideo.hasOwnProperty('data') && dataVideo.data.hasOwnProperty('w_second')) ? dataVideo.data.w_second : 0

                // reset banners
                this.resetBanners()

                // validating URL video
                urlVideo = (dataVideo.hasOwnProperty('video')) ? dataVideo.video : ''

                // switch video status
                switch (status) {
                    // count down active
                    case 1:
                        clearInterval(timer)
                        this.doCountDown(hours, minutes, seconds)
                        this.showCountDownBanner()
                        break

                    // video active
                    case 2:
                        // show video
                        this.showVideoBanner()

                        // consulting service again
                        setTimeout(function() {
                            videoService.load()
                            
                            // banner winner
                            winnerGandaDiario.init()
                        }, 81000)
                        break

                    // error video
                    default:
                        // show error
                        this.showVideoBannerError()
                        this.setVideoMessageError(message)

                        // consulting service again
                        setTimeout(function() {
                            videoService.load()

                            // banner winner
                            winnerGandaDiario.init()
                        }, 90000)
                        break
                }
            },
            doCountDown: function(hours, minutes, seconds) {
                let setTimeString

                setTimeString = function(time) {
                    if (time.toString().length === 1) {
                        return '0' + time
                    } else {
                        return '' + time
                    }
                }

                timer = setInterval(function() {
                    // distance equals zero
                    if (hours === 0 && minutes === 0 && seconds === 0) {
                        // finish timer
                        clearInterval(timer)

                        // consulting service again
                        videoService.load()
                        
                        // banner winner
                        winnerGandaDiario.init()

                        return
                    }

                    // validating minutes
                    if (minutes === 0 && seconds === 0) {
                        hours--
                        minutes = 60
                    }

                    // validating seconds
                    if (seconds === 0) {
                        minutes--
                        seconds = 60
                    }

                    seconds--

                    // display the result in the elements
                    $('#hours, #popup-hours').html(setTimeString(hours))
                    $('#minutes, #popup-minutes').html(setTimeString(minutes))
                    $('#seconds, #popup-seconds').html(setTimeString(seconds))
                }, 1000)
            },
            showCountDownBanner: function() {
                $('.m-banner-count-down').css('display', 'block')
                $('.m-banner-video').css('display', 'none')
            },
            showVideoBanner: function() {
                $('.m-banner-video').css('display', 'block')
                    .addClass('open-video-popup')
                    .removeClass('open-error-popup')
                $('.m-banner-count-down').css('display', 'none')

                // hide message error
                $('.m-banner-video').find('.m-button').show()
                $('.m-banner-video').find('.m-banner-count-down__title')
                    .html('El sorteo comienza en')
                    .attr('style', '')
            },
            showVideoBannerError: function() {
                $('.m-banner-count-down').css('display', 'none')
                $('.m-banner-video').css('display', 'block')
                    .removeClass('open-video-popup')
                    .addClass('open-error-popup')

                // print message error
                $('.m-banner-video').find('.m-button').hide()
                $('.m-banner-video').find('.m-banner-count-down__title')
                    .html('Pronto regresaremos con el sorteo')
                    .attr('style', 'top: 0; bottom: 0; height: 85px; padding: 0 20px; font-size: 23px;')
            },
            setVideoMessageError: function(message) {
                $('#error-popup').find('.m-popup-error__title').html(message)
            },
            resetBanners: function() {
                $('.m-banner-count-down, .m-banner-video').css('display', 'block')
                $('.m-overlay, .m-popup').removeClass('js--active')
            }
        }

        // video init
        videoService = {
            load: function() {
                this.getData()
            },
            getData: function() {
                $.ajax({
                    type: 'GET',
                    url: 'https://www.latinka.com.pe/gd-app-ws/api/draw/data',
                    datatype: 'json',
                    async: false,
                    complete: function(response) {
                        let dataVideo = JSON.parse(response.responseText)

                        videoCore.load(dataVideo)
                    }
                })
            }
        }

        // popups
        popups = {
            load: function() {
                this.countDown()
                this.video()
                this.error()
            },
            countDown: function() {
                $('#count-down-popup').mPopup({
                    open_element: '.open-count-down-popup'
                })
            },
            video: function() {
                $('#video-popup').mPopup({
                    open_element: '.open-video-popup',
                    on_open: function (){
                        $('#video-popup .m-popup__content').html('<video id="video_live" width="100%" height="100%"></video>')

                        let video = document.getElementById('video_live')

                        if (Hls.isSupported()) {
                            let hls = new Hls()

                            hls.loadSource(urlVideo)
                            hls.attachMedia(video)
                            hls.on(Hls.Events.MANIFEST_PARSED, function() {
                                video.play()
                            })
                        } else if (video.canPlayType('application/vnd.apple.mpegurl')) {
                            video.src = urlVideo
                            video.addEventListener('loadedmetadata', function() {
                                video.play()
                            })
                        }
                    },
                    on_close: function() {
                        // reset content video
                        $('#video-popup .m-popup__content').html('')

                        // consulting service again
                        videoService.load()

                        // banner winner
                        winnerGandaDiario.init()
                    }
                })
            },
            error: function() {
                $('#error-popup').mPopup({
                    open_element: '.open-error-popup',
                    close_element: '.m-popup-error .m-button'
                })
            }
        }

        // init
        init = function () {
            videoService.load()
            popups.load()

            // banner winner
            winnerGandaDiario.init()
        }

        return {
            init: init
        }
    }())

    home.init() 
})