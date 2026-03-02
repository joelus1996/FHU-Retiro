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
        this.numbers = (options && options.numbers) ? options.numbers : []

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
            document.querySelector('.slider-bullet-current-index').innerHTML = 1
            document.querySelector('.slider-bullet-count').innerHTML = this.numSlides

            // get current
            let
                $currentSlider = document.querySelector(`#m-winners__slider li.glide__slide--active`),
                currentGame = $currentSlider.getAttribute('data-game')

            // change style
            this.changeStyle(currentGame)

            // render numbers
            this.renderNumbers(currentGame)
        }
    }

    events() {
        let
            currentGame,
            currentIndex,
            $currentSlider

        this.slider.on(['run.after'], () => {
            // get current
            $currentSlider = document.querySelector(`#m-winners__slider li.glide__slide--active`)
            currentGame = $currentSlider.getAttribute('data-game')

            // change style
            this.changeStyle(currentGame)

            // update number nav
            currentIndex = (this.slider.index + 1)
            document.querySelector('.slider-bullet-current-index').innerHTML = currentIndex

            // update nav
            this.setArrowsClass(currentIndex)

            // update numbers
            this.renderNumbers(currentGame)
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

    changeStyle(currentGame) {
        if (currentGame == 'chau-chamba') {
            this.$winnerPopUp.classList.remove('js-kabala')
            this.$winnerPopUp.classList.add('js-chau-chamba')
        } else {
            this.$winnerPopUp.classList.remove('js-chau-chamba')
            this.$winnerPopUp.classList.add('js-kabala')
        }
    }

    renderNumbers(currentGame) {
        let
            numbers

        // validating game
        if (currentGame === 'kabala') {
            numbers = this.numbers.kabala
        } else {
            numbers = this.numbers.chauchamba
        }

        // get numbers
        numbers = numbers.split('-')

        // iterating and print numbers
        this.$containerNumbers.forEach((elementNumber, index) => {
            elementNumber.innerHTML = numbers[index]
        })
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

        // Vars
        this.data = null
        this.$containerGlide = document.querySelector('.glide')
        this.$popupWinner = document.querySelector('.m-popup-winner')
        this.$containerSlides = document.querySelector('.glide__slides')
        this.$banner = document.querySelector('.m-banner-winner__kabala')
        this.$winnerBanners = document.querySelectorAll('.m-banner-winner')
    }

    handleBanner(bannerId) {
        let
            $winnerBanner = document.querySelector(`#${bannerId}`)

        // hidding all winnner banners
        this.$winnerBanners.forEach($banner => {
            $banner.style.display = 'none'
        })

        // activating current winner banner
        if ($winnerBanner) {
            $winnerBanner.style.display = 'block'
        }
    }

    showBanner(data) {
        let
            banner,
            winnerObject,
            currentGame = this.isGame()

        switch (currentGame) {
            case 'both':
                banner = 'm-kabala-chau-chamba'
                winnerObject = {'kabala': this.data.kabala, 'chau-chamba': this.data.chauchamba}
                break
            
            case 'kabala':
                banner = 'm-kabala'
                winnerObject = {'kabala': this.data.kabala}
                break

            case 'chau-chamba':
                banner = 'm-chau-chamba'
                winnerObject = {'chau-chamba': this.data.chauchamba}
                break
        }

        this.handleBanner(banner)
        this.renderWinner(winnerObject)
    }
    
    // Renderiza el ganador
    renderWinner(data) {
        let
            iterating,
            element = '',
            totalWinners = 0

        // iterating function
        iterating = (dataArray, game) => {
            dataArray.forEach( (data, index) => {
                element += `
                    <li class="glide__slide" data-slider-index="${index}" data-game="${game}">
                        <div class="m-popup-winner__info">
                            <div class="m-box-container">
                                <div class="m-box">
                                <h4>Fecha</h4>
                                <p>${data.date}</p>
                                </div>
                                <div class="m-box">
                                <h4>Punto de venta</h4>
                                <p>${data.location}</p>
                                </div>
                            </div>
                            <div class="m-box m-box--height">
                                <h4>Dirección</h4>
                                <p>${data.address.split(' [')[0]}</p>
                            </div>
                        </div>
                    </li>`
            })
        }

        if (data) {
            Object.keys(data).forEach(game => {
                if (data[game].length > 1) {
                    this.$popupWinner.classList.add('m-large')
                    document.querySelector('.glide__arrows').style.display = 'inline-flex'
                } else {
                    document.querySelector('.glide__arrows').style.display = 'none'
                }
    
                // set total
                totalWinners += data[game].length
    
                // render
                iterating(data[game], game)
            })

            new SliderWinners().destroy()
    
            this.$containerSlides.innerHTML = element
    
            // load slider
            new SliderWinners({
                numSlides: totalWinners,
                numbers: this.data.numbers
            }).load()
        }
    }

    // Retorna que tipo de juego es.
    isGame() {
        switch (true) {
            case Boolean(this.data.kabala.length && this.data.chauchamba.length):
                return 'both'
                break

            case Boolean(this.data.kabala.length):
                return 'kabala'
                break
                
            case Boolean(this.data.chauchamba.length):
                return 'chau-chamba'
                break

            default:
                return false
        }
    }

    async fetch() {
        let response = await fetch(this.url)
        if(response.ok) {
            let winners = await response.json()

            this.data = winners.winners

            this.showBanner()
        }
    }

    init() {
        if (this.$banner && this.$popupWinner && this.$containerGlide && this.$containerSlides) {
            this.fetch()
        }
    }
}

window.addEventListener('DOMContentLoaded', (event) => {
    const
        winnerKabala = new Winners('https://www.latinka.com.pe/kl-app-ws/api/draw/data ')

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
                            winnerKabala.init()
                        }, 156000)
                        break

                    // error video
                    default:
                        this.showVideoBannerError()
                        this.setVideoMessageError(message)
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
                        winnerKabala.init()

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
                $('.m-banner-notice').css('display', 'none')
            },
            showVideoBanner: function() {
                $('.m-banner-count-down').css('display', 'none')
                $('.m-banner-video').css('display', 'block')
                $('.m-banner-notice').css('display', 'none')
            },
            showVideoBannerError: function() {
                $('.m-banner-count-down').css('display', 'none')
                $('.m-banner-video').css('display', 'none')
                $('.m-banner-notice').css('display', 'block')
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
                    url: 'https://www.latinka.com.pe/kl-app-ws/api/draw/data ',
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
                        winnerKabala.init()
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
            winnerKabala.init()

            // focus window event
            let media = window.matchMedia('(max-width: 768px)'),
                doMobile = function(x) {
                    if (x.matches) {
                        window.onfocus = function() {
                            videoService.load()

                            // banner winner
                            winnerKabala.init()
                        }
                    }
                }

            // do
            doMobile(media)
            media.addListener(doMobile)
        }

        return {
            init: init
        }
    }())

    home.init() 
})