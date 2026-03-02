
/**
 * Tinka Express Alert Dialog
 */
class AlertDialog {
  constructor({ element }) {
    this.dialogEl = document.querySelector(element);
    this.backdropEl = this.dialogEl.querySelector('.Dialog-backdrop');
    this.paperEl = this.dialogEl.querySelector('.Dialog-paper');
    this.headerEl = this.dialogEl.querySelector('.AlertDialog-header');
    this.imageEl = this.dialogEl.querySelector('.AlertDialog-image');

    this.closeEl = this.dialogEl.querySelector('#alert-dialog-close');
    this.titleEl = this.dialogEl.querySelector('#alert-dialog-title');
    this.paragraphEl = this.dialogEl.querySelector('#alert-dialog-paragraph');
    this.btnAgreeEl = this.dialogEl.querySelector('#btn-agree-dialog');
    this.btnDisagreeEl = this.dialogEl.querySelector('#btn-disagree-dialog');

    this.types = ['error', 'success'];

    this.addEventListeners();
  }

  addEventListeners() {
    this.closeEl.addEventListener('click', (e) => {
      e.preventDefault();
      this.close();
    });

    this.btnAgreeEl.addEventListener('click', (e) => {
      e.preventDefault();
      this.close();
    });

    this.btnDisagreeEl.addEventListener('click', (e) => {
      e.preventDefault();
      this.close();
    });
  }

  open(config) {

    this.configure(config);

    document.body.style.overflow = 'hidden !important';
    this.dialogEl.classList.add('is-open');
  }

  close() {
    document.body.style.overflow = '';
    this.dialogEl.classList.remove('is-open');
  }

  /**
   * Configure dialog
   */
  configure(config) {
    const defaultConfig = this.getDefaultConfig();
    const { type, title, message, showClose, showIcon = true, actions } = config ?? defaultConfig;
    const { agree, disagree } = actions ?? defaultConfig.actions;

    const imgEl = this.getImgTypeEl(type);

    if (showClose) {
      this.headerEl.classList.remove('is-hidden');
    } else {
      this.headerEl.classList.add('is-hidden');
    }

    if (imgEl && showIcon) {
      imgEl.classList.remove('is-hidden');
      this.imageEl.classList.remove('is-hidden');
    } else {
      this.imageEl.classList.add('is-hidden');
    }

    if (this.titleEl && title) {
      this.titleEl.innerHTML = title;
      this.titleEl.parentElement.classList.remove('is-hidden');
    } else {
      this.titleEl.parentElement.classList.add('is-hidden');
      this.titleEl.innerHTML = '';
    }

    if (this.paragraphEl && message) {
      this.paragraphEl.innerHTML = message;
      this.paragraphEl.parentElement.classList.remove('is-hidden');
    } else {
      this.paragraphEl.parentElement.classList.add('is-hidden');
      this.paragraphEl.innerHTML = '';
    }

    if (this.btnAgreeEl && agree) {
      this.btnAgreeEl.innerHTML = agree.label;
      this.btnAgreeEl.classList.remove('is-hidden');
    } else {
      this.btnAgreeEl.classList.add('is-hidden');
      this.btnAgreeEl.innerHTML = 'Agree';
    }

    if (this.btnDisagreeEl && disagree) {
      this.btnDisagreeEl.innerHTML = disagree.label;
      this.btnDisagreeEl.classList.remove('is-hidden');
    } else {
      this.btnDisagreeEl.classList.add('is-hidden');
      this.btnDisagreeEl.innerHTML = 'Disagree';
    }
  }

  /**
   * Default config
   */
  getDefaultConfig() {
    return {
      type: 'error',
      title: '',
      message: '',
      showClose: false,
      showIcon: true,
      disableClose: true,
      actions: {
        agree: {
          label: 'Aceptar'
        }
      }
    }
  }

  getImgTypeEl(type = 'error') {
    const isAvailable = this.types.includes(type);

    if (!isAvailable) return null;

    const imgs = this.imageEl.querySelectorAll('img');

    imgs.forEach((img) => {
      img.classList.add('is-hidden');
    });

    return this.imageEl.querySelector(`img.is-${type}`);
  }
}

/**
 * Tinka Express Help Dialog
 */
class HelpDialog {
  constructor({ element }) {
    this.dialogEl = document.querySelector(element);
    this.closeEl = this.dialogEl.querySelector('#help-dialog-close');

    this.addEventListeners();
  }

  addEventListeners() {
    this.closeEl.addEventListener('click', (e) => {
      e.preventDefault();
      this.close();
    });
  }

  open() {
    document.body.style.overflow = 'hidden !important';
    this.dialogEl.classList.add('is-open');
  }

  close() {
    document.body.style.overflow = '';
    this.dialogEl.classList.remove('is-open');
  }
}

/**
 * Tinka Express Ticket Dialog
 */
class TicketDialog {
  constructor({ element }) {
    this.dialogEl = document.querySelector(element);
    this.closeEl = this.dialogEl.querySelector('#ticket-dialog-close');
    this.downloadEl = this.dialogEl.querySelector('#ticket-dialog-download');

    this.imageEl = this.dialogEl.querySelector('#ticket-dialog-image');

    this.addEventListeners();
  }

  addEventListeners() {
    this.closeEl.addEventListener('click', (e) => {
      e.preventDefault();
      this.close();
    });
  }

  open(data = {}, iframe = null) {
    const { image } = data;

    this.imageEl.src = image;

    const timeout = setTimeout(() => {
      document.body.style.overflow = 'hidden !important';
      this.dialogEl.classList.add('is-open');
      clearTimeout(timeout);
    }, 100);

    if (iframe) {

      this.handleOnDownload = (e) => {
        e.preventDefault();

        // Send message to iframe to download ticket
        iframe.iFrameResizer.sendMessage({ type: 'download-ticket', data: {} }, '*');
      }

      this.downloadEl.addEventListener('click', this.handleOnDownload);
    }
  }

  close() {
    document.body.style.overflow = '';
    this.dialogEl.classList.remove('is-open');

    if (this.handleOnDownload) {
      this.downloadEl.removeEventListener('click', this.handleOnDownload);
    }
  }
}

function onLoad () {
  // Payment methods
  const VISA = 'VISA'
  const YAPE_PLIN = 'YAPE-PLIN'

  // iFrame elements
  const $iframePage = document.querySelector('#tinkaExpressIframe');
  const $iframeCheckout = document.querySelector('#tinkaExpressCheckout');

  const $alertDialog = new AlertDialog({
    element: '#tinka-express-alert-dialog',
  });

  const $helpDialog = new HelpDialog({
    element: '#tinka-express-help-dialog',
  });

  const $ticketDialog = new TicketDialog({
    element: '#tinka-express-ticket-dialog',
  });


  // Page iframe state
  const pageState = {
    isLoaded: false,
    isReady: false
  }

  // Checkout iframe state
  const checkoutState = {
    isLoaded: false,
    isReady: false
  }

  if (!$iframePage) {
    console.error('TinkaExpress iFrame: Page not found!');

    return;
  }

  if (typeof window.iFrameResize === "undefined") {
    console.error('TinkaExpress iFrame: iFrameResize not found!');

    return;
  }

  window.iFrameResize({
    log: false,
    autoResize: true,
    checkOrigin: false,
    scrolling: false,
    onInit: (iframe) => {
      pageState.isReady = true;

      iframe.iFrameResizer.sendMessage({
        type: 'page-url',
        data: window.location.href,
      }, '*');
    },
    onResized: ({ iframe }) => {
      iframe.iFrameResizer.sendMessage({
        type: 'page-url',
        data: window.location.href,
      }, '*');
    },
    onMessage: ({ iframe, message }) => {

      if (typeof message !== 'object') return;

      const { type, data } = message ?? {};

      // console.log('iFrame Tinka Express: onMessage', {
      //   pageState,
      //   checkoutState,
      //   message
      // });

      // Open alert dialog
      if (type === 'open-alert') {
        $alertDialog.open(data);
      }

      // Open help dialog
      if (type === 'open-help-modal') {
        $helpDialog.open();
      }

      // Open preview ticket dialog
      if (type === 'open-ticket-modal') {
        $ticketDialog.open(data, iframe);
      }

      /**
       * Open Niubiz checkout form
       * TODO: Validate if checkout is loaded
       */
      if (type === 'open-checkout-form') { // && checkoutState.isLoaded
        if (!$iframeCheckout)  return;

        $iframeCheckout.classList.remove('is-hidden');

        // Send postMessage to checkout iframe to open the form
        $iframeCheckout.iFrameResizer.sendMessage({  type: 'payment-open-form', data }, '*');
      }

      // Scroll to top of the page, will be used when you navigate to another page in tinka express
      if (type === 'scroll-to-top') {

        if ('scroll' in window) {
          window.scroll({
            top: 0,
            left: 0,
            behavior: 'smooth',
          });
        } else {
          window.scrollTo(0, 0);
        }

        iframe.iFrameResizer.resize()
      }

      /**
       * Remove selected plays
       * Only for desktop
       */
      if (type === 'remove-play') {
        // Aquí la lógica para eliminar la jugada seleccionada y volver a "PASO 1: ELIGE TU JUGADA"
    	  let boxContentGame = $(".wrapper-buying"); 
    	  boxContentGame.find(".box-wrapper-game").show();
    	  $(".play-help").show();
    	  let iframe = $("#tinkaExpressIframe");
    	  iframe.attr('src', 'about:blank');
    	  iframe.hide();
    	  
    	  $('.process-delete1').trigger('click');
      }

      // Payment verify with error
      if (type === 'payment-verify-error') {
        if (!$iframeCheckout)  return;

        $iframeCheckout.classList.add('is-hidden');

        $iframeCheckout.iFrameResizer.sendMessage({
          type: 'reload-page',
          data: {},
        }, '*');
      }

      // Payment completed successfully
      if (type === 'payment-complete') {
        console.log('Payment completed successfully', { type, data });

        // If payment method is Visa, close the checkout iFrame
        if (data?.paymentMethod === VISA) {
          if (!$iframeCheckout)  return;

          $iframeCheckout.classList.add('is-hidden');

          const timeout = setTimeout(() => {
            if ($iframeCheckout?.iFrameResizer?.close) {
              $iframeCheckout.iFrameResizer.close();
            }

            clearTimeout(timeout);
          }, 200);
        }

        window.parent.postMessage('eliminarTinkaSession', '*');
      }
      
      if (type === 'tinka-express-ready') {
	      console.log('iFrame Tinka Express: tinka-express-ready')
	      iframe.iFrameResizer.sendMessage(
	        {
	          type: 'parent-ready',
	          data: {},
	        },
	        '*'
	      )
      }

      // Google tag event tracking
      if (type === 'gtag-event') {
        const dataLayer = window.dataLayer || []
        dataLayer.push(data)
        console.log('Gtag event', data)
      } 
    }
  }, $iframePage);

  // Init iframe Checkout only if it exists
  if ($iframeCheckout) {
    window.iFrameResize({
      log: false,
      autoResize: true,
      checkOrigin: false,
      scrolling: false,
      onInit: (iframe) => {
        checkoutState.isReady = true;
      },
      onMessage: ({ message }) => {

        if (typeof message !== 'object') return;

        const { type, data } = message ?? {};

        // console.log('iFrame Checkout: onMessage', message);

        // The checkout iframe is loaded
        if (type === 'payment-loaded') {
          checkoutState.isLoaded = true;

          $iframePage.iFrameResizer.sendMessage({
            type: 'payment-loaded',
            data,
          }, '*');
        }

        // The checkout form was canceled
        if (type === 'payment-cancel') {
          $iframeCheckout.classList.add('is-hidden');

          $iframePage.iFrameResizer.sendMessage({
            type: 'payment-cancel',
            data,
          }, '*');
        }

        // The checkout form has an error in the payment process
        if (type === 'payment-error') {
          $iframeCheckout.classList.add('is-hidden');

          $iframePage.iFrameResizer.sendMessage({
            type: 'payment-error',
            data,
          }, '*');
        }

        // The checkout form was completed successfully
        if (type === 'payment-success') {
          $iframeCheckout.classList.add('is-hidden');

          $iframePage.iFrameResizer.sendMessage({
            type: 'payment-success',
            data,
          }, '*');

          const timeout = setTimeout(() => {
            $iframeCheckout.iFrameResizer.close();
            clearTimeout(timeout);
          }, 200);
        }
      }
    }, $iframeCheckout);
  }
}


$("#password-client").focus(function(){
	$("#password-client-label").css("top", "10px");
	$("#password-client-label").css("color", "#07663a");
	$("#password-client-label").css("background-color", "#E8E8E8");
});

$("#user-client").focus(function(){
	$("#user-client-label").css("top", "10px");
	$("#user-client-label").css("color", "#07663a");
	$("#user-client-label").css("background-color", "#E8E8E8");
});





$("#password-client").focusout(function(){
	var value = $("#password-client").val();
	
	if(value == ""){
		$("#password-client-label").css("top", "30px");
		$("#password-client-label").css("color", "#000");
		$("#password-client-label").css("background-color", "#FFF");
	}else{
		$("#password-client-label").css("top", "10px");
		$("#password-client-label").css("color", "#07663a");
		$("#password-client-label").css("background-color", "#E8E8E8");
	}
});

$("#user-client").focusout(function(){
	var value = $("#user-client").val();
	
	if(value == ""){
		$("#user-client-label").css("top", "30px");
		$("#user-client-label").css("color", "#000");
		$("#user-client-label").css("background-color", "#FFF");
	}else{
		$("#user-client-label").css("top", "10px");
		$("#user-client-label").css("color", "#07663a");
		$("#user-client-label").css("background-color", "#E8E8E8");
	}
});

window.addEventListener('load', onLoad);
