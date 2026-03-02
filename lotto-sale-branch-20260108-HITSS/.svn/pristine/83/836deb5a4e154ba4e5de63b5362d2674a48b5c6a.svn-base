'use strict';

function onLoad () {
	const $iframePage = document.querySelector('#tinkaBoletoIframe');
	//const $btnShowBoleto = document.querySelector('#btnShowBoleto');

	if (!$iframePage ) { // || !$btnShowBoleto
	return;
	}

	// Page iframe state
	const pageState = {
	isLoaded: false,
	isReady: false
	}
		
	iFrameResize({
		log: false,
		autoResize: true,
		checkOrigin: false,
		scrolling: false,
		onInit: (iframe) => {
			pageState.isReady = true;
		},
		onResized: ({ iframe, type }) => {
			if (type === "init") {
				pageState.isReady = true;
			};
		},
		onMessage: ({ iframe, message }) => {
			if (typeof message !== 'object') return;
			
			const { type, data } = message ?? {};
			
			console.log('iFrame Boleto: onMessage', { type, data});
			
			if (type === 'preview-ticket-loaded') {
				pageState.isLoaded = true;
			}
			if (type === 'preview-ticket-error') {
				//$btnShowBoleto.classList.remove('is-loading');
			}
			if (type === 'preview-ticket-success') {
				//$btnShowBoleto.classList.remove('is-loading');
			}
			if (type === 'preview-ticket-close') {
				$iframePage.classList.add('is-hidden');
			}
		}
	}, $iframePage);
	
	/*$btnShowBoleto.addEventListener('click', () => {
		if (!pageState.isLoaded) {
			console.error('iFrame Boleto: not loaded');
			return;
		}
		// Boleto de prueba WEB
		 const data = {
		 idVerify: '463501',
		 codigoValidacion: '56345544586c374f5a666f3d',
		 }
		// Boleto de prueba PDV
		//const data = {
		//idVerify: '464145',
		//codigoValidacion: '444c2f52575856653674383d',
		//}
		
		$btnShowBoleto.classList.add('is-loading');
		// Send post message to iframe
		$iframePage.iFrameResizer.sendMessage({ type: 'preview-ticket-show', data }, ALLOW_TARGET_ORIGIN);
		$iframePage.classList.remove('is-hidden');
		
	});*/
}

window.addEventListener('load', onLoad);

function openTicketTinkaExpress(codigoValidacion,idVerify){
	const data = {
		 idVerify: idVerify,
		 codigoValidacion: codigoValidacion,
	};
	
	console.log("ticket tinka express:: ", data);
	
	// TODO: Test with real domain
	// https://ticket-digital-dev.clouduat.com.pe
	// https://jugadas.latinka.com.pe
	const ALLOW_TARGET_ORIGIN = '*';
	
	const $iframePage = document.querySelector('#tinkaBoletoIframe');
	$iframePage.iFrameResizer.sendMessage({ type: 'preview-ticket-show', data }, ALLOW_TARGET_ORIGIN);
	$iframePage.classList.remove('is-hidden');
	
	
}
