<%@page import="pe.com.intralot.loto.utils.Constantes"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html lang="es">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover">
	<script type="text/javascript" src="layer-view-script/jquery-3.6.3.min.js"></script>
	<script src="<%=Constantes.fdCheckoutJs%>"></script>
<!-- 	<script src="https://static-content-qas.vnforapps.com/vToken/js/checkout.js"></script> -->
<!-- 	<script src="https://static-content-nlb.vnforapps.com/vToken/js/checkout.js?static=true"></script> -->
	<style>
		html, body { height: 100%; margin: 0; }
		#logo { display: block !important; }
		#logoText { display: none !important; }
		#ta-terms-container {
			position: fixed;
			left: 0;
			right: 0;
			bottom: 10px;
			z-index: 2147483647;
			display: none;
			pointer-events: auto;
			padding: 0 12px;
			box-sizing: border-box;
		}
		#ta-terms-inner {
			max-width: 420px;
			margin: 0 auto;
			font-size: 12px;
			line-height: 1.2;
			display: flex;
			align-items: center;
			gap: 8px;
		}
		#ta-terms-check {
			margin-top: 0;
			flex: 0 0 auto;
		}
		#ta-terms-label {
			flex: 1 1 auto;
			user-select: none;
			color: #8a8a8a;
		}
		#ta-terms-label a {
			color: #FF8000;
			text-decoration: underline;
		}
		#ta-visa-brand {
			position: absolute;
			top: 12px;
			left: 50%;
			transform: translateX(-50%);
			z-index: 2147483647;
			pointer-events: none;
			display: none;
		}
		#ta-visa-brand img {
			display: block;
			max-width: 60vw;
			max-height: 48px;
			height: auto;
			width: auto;
		}
	</style>
	<script>
		function isVisibleEl(el) {
			try {
				if (!el) return false;
				var style = window.getComputedStyle ? window.getComputedStyle(el) : null;
				if (!style) return true;
				return style.display !== 'none' && style.visibility !== 'hidden' && style.opacity !== '0';
			} catch (e) {
				return true;
			}
		}

		function hasSavedCardOptions(root) {
			try {
				if (!root) return false;
				var radios = root.querySelectorAll('input[type="radio"]');
				if (radios && radios.length) {
					for (var i = 0; i < radios.length; i++) {
						var r = radios[i];
						if (!r || r.disabled) continue;
						if (!isVisibleEl(r)) continue;
						return true;
					}
				}
				var nodes = root.querySelectorAll('div, span, li, label, button, a');
				for (var j = 0; j < nodes.length; j++) {
					var n = nodes[j];
					if (!n) continue;
					var txt = (n.textContent || '').replace(/\s+/g, ' ').trim();
					if (!txt) continue;
					if (txt.indexOf('****') >= 0 && isVisibleEl(n)) return true;
				}
				return false;
			} catch (e) {
				return false;
			}
		}

		function isNewCardFormView(root) {
			try {
				if (!root) return false;
				// When the "Nueva tarjeta" form is shown, typical inputs appear.
				var inputs = root.querySelectorAll('input');
				for (var i = 0; i < inputs.length; i++) {
					var inp = inputs[i];
					var ph = (inp.getAttribute('placeholder') || '').toLowerCase();
					var aria = (inp.getAttribute('aria-label') || '').toLowerCase();
					var name = (inp.getAttribute('name') || '').toLowerCase();
					var id = (inp.getAttribute('id') || '').toLowerCase();
					var combo = (ph + ' ' + aria + ' ' + name + ' ' + id);
					if (combo.indexOf('número') >= 0 || combo.indexOf('numero') >= 0 || combo.indexOf('card') >= 0 || combo.indexOf('pan') >= 0 || combo.indexOf('cvv') >= 0) {
						if (isVisibleEl(inp)) return true;
					}
				}
				return false;
			} catch (e) {
				return false;
			}
		}

		function getTokenizationCompletionMode() {
			try {
				var root = document.getElementById('visaNetJS');
				if (!root) return 'unknown';
				var saved = hasSavedCardOptions(root);
				var isNew = isNewCardFormView(root);
				// Saved-card flow may still show a CVV field; prioritize saved when options exist.
				if (saved) return 'saved';
				if (isNew) return 'new';
				return 'unknown';
			} catch (e) {
				return 'unknown';
			}
		}

		function autoSelectFirstSavedCardOnce() {
			try {
				var root = document.getElementById('visaNetJS');
				if (!root) return false;
				// Do not interfere if user already navigated to "Nueva tarjeta" form.
				if (isNewCardFormView(root)) return false;

				// Prefer radio inputs if present.
				var radios = root.querySelectorAll('input[type="radio"]');
				if (radios && radios.length) {
					for (var i = 0; i < radios.length; i++) {
						var r = radios[i];
						if (!r || r.disabled) continue;
						if (!isVisibleEl(r)) continue;
						if (r.checked) return true;
						// Click the closest label/container if possible to trigger Niubiz handlers.
						var clickable = r.closest ? (r.closest('label') || r.closest('div') || r) : r;
						try { clickable.click(); } catch (e) { }
						try { r.checked = true; } catch (e) { }
						try { r.dispatchEvent(new Event('change', { bubbles: true })); } catch (e) { }
						return true;
					}
				}

				// Fallback: look for a masked card row (contains ****) and click it.
				var nodes = root.querySelectorAll('div, span, li, label, button, a');
				for (var j = 0; j < nodes.length; j++) {
					var n = nodes[j];
					if (!n) continue;
					var txt = (n.textContent || '').replace(/\s+/g, ' ').trim();
					if (!txt) continue;
					if (txt.indexOf('****') >= 0 && isVisibleEl(n)) {
						try { n.click(); } catch (e) { }
						return true;
					}
				}
				return false;
			} catch (e) {
				return false;
			}
		}

		function ensureDefaultSavedCardSelected(maxWaitMs) {
			var start = new Date().getTime();
			var done = false;
			var timer = setInterval(function() {
				if (done) return;
				if (autoSelectFirstSavedCardOnce()) {
					done = true;
					clearInterval(timer);
					return;
				}
				var elapsed = new Date().getTime() - start;
				if (elapsed > (maxWaitMs || 15000)) {
					clearInterval(timer);
				}
			}, 250);

			// Also react quickly to Niubiz DOM changes.
			try {
				var root = document.getElementById('visaNetJS') || document.documentElement;
				if (root && window.MutationObserver) {
					var obs = new MutationObserver(function() {
						if (done) return;
						if (autoSelectFirstSavedCardOnce()) {
							done = true;
							try { obs.disconnect(); } catch (e) { }
							try { clearInterval(timer); } catch (e) { }
						}
					});
					obs.observe(root, { childList: true, subtree: true, attributes: true });
					setTimeout(function() { try { obs.disconnect(); } catch (e) { } }, (maxWaitMs || 15000));
				}
			} catch (e) { }
		}

		function mountTaTermsIntoNiubiz(btn) {
			try {
				var container = document.getElementById('ta-terms-container');
				if (!container) return false;
				var checkoutRoot = document.getElementById('visaNetJS');
				if (!checkoutRoot) return false;

				// Prefer placing right before the action button (as per UI mock).
				if (btn && btn.parentNode) {
					if (container.parentNode !== btn.parentNode) {
						btn.parentNode.insertBefore(container, btn);
					} else if (container.nextSibling !== btn) {
						btn.parentNode.insertBefore(container, btn);
					}
					container.style.position = 'static';
					container.style.top = 'auto';
					container.style.bottom = 'auto';
					container.style.padding = '0 12px';
					container.style.marginTop = '0';
					container.style.marginBottom = '10px';
					return true;
				}

				// Fallback: append inside visaNetJS.
				if (container.parentNode !== checkoutRoot) {
					checkoutRoot.appendChild(container);
				}
				container.style.position = 'static';
				container.style.top = 'auto';
				container.style.bottom = 'auto';
				container.style.padding = '0 12px';
				container.style.marginTop = '8px';
				container.style.marginBottom = '0';
				return true;
			} catch (e) {
				return false;
			}
		}

		function positionTaTermsContainerNearButton(buttonEl) {
			try {
				var container = document.getElementById('ta-terms-container');
				if (!container || !buttonEl || !buttonEl.getBoundingClientRect) return;
				var rect = buttonEl.getBoundingClientRect();
				if (!rect || !isFinite(rect.bottom)) return;
				// Show right below the Niubiz action button, if there's enough space.
				var h = container.getBoundingClientRect ? container.getBoundingClientRect().height : 0;
				var desiredTop = Math.round(rect.bottom + 8);
				if (h > 0 && (desiredTop + h) < (window.innerHeight || 0)) {
					container.style.top = desiredTop + 'px';
					container.style.bottom = 'auto';
				} else {
					container.style.top = 'auto';
					container.style.bottom = '10px';
				}
			} catch (e) {
				// no-op
			}
		}

		function ensureTaTermsContainer() {
			var container = document.getElementById('ta-terms-container');
			if (container) return container;
			return null;
		}

		function findTaConfirmButton(buttonText) {
			var root = document.getElementById('visaNetJS') || document.body;
			if (!root) return null;
			var nodes = root.querySelectorAll('button, input[type="button"], input[type="submit"]');
			if (!nodes || !nodes.length) return null;
			var targetText = (buttonText || '').toString().trim().toLowerCase();
			for (var i = 0; i < nodes.length; i++) {
				var n = nodes[i];
				var txt = '';
				try {
					txt = (n.tagName && n.tagName.toLowerCase() === 'input') ? (n.value || '') : (n.textContent || '');
				} catch (e) { }
				txt = (txt || '').trim().toLowerCase();
				if (!txt) continue;
				if (targetText && (txt === targetText || txt.indexOf(targetText) >= 0)) return n;
				if (!targetText && (txt === 'confirmar' || txt.indexOf('confirmar') >= 0)) return n;
			}
			return null;
		}

		function applyTaTermsGate(buttonText) {
			var termsContainer = ensureTaTermsContainer();
			if (!termsContainer) return false;
			var checkbox = document.getElementById('ta-terms-check');
			if (!checkbox) return false;

			var btn = findTaConfirmButton(buttonText);
			if (!btn) return false;
			// Place within the Niubiz overlay so it can't be covered.
			mountTaTermsIntoNiubiz(btn);
			// Keep an extra positioning fallback for older DOMs.
			positionTaTermsContainerNearButton(btn);

			var accepted = !!checkbox.checked;
			try {
				btn.disabled = !accepted;
				if (!accepted) {
					btn.setAttribute('aria-disabled', 'true');
				} else {
					btn.removeAttribute('aria-disabled');
				}
			} catch (e) { }
			return true;
		}

		function setupTaTermsGate(buttonText, maxWaitMs) {
			var termsContainer = ensureTaTermsContainer();
			if (!termsContainer) return;
			termsContainer.style.display = 'block';
			// Default positioning (if we never manage to mount into Niubiz)
			termsContainer.style.position = 'fixed';
			termsContainer.style.left = '0';
			termsContainer.style.right = '0';
			termsContainer.style.bottom = '10px';
			termsContainer.style.top = 'auto';

			var checkbox = document.getElementById('ta-terms-check');
			if (!checkbox) return;
			checkbox.checked = false;
			applyTaTermsGate(buttonText);

			var start = new Date().getTime();
			var timer = setInterval(function() {
				applyTaTermsGate(buttonText);
				var elapsed = new Date().getTime() - start;
				if (elapsed > (maxWaitMs || 15000)) {
					clearInterval(timer);
				}
			}, 250);

			checkbox.addEventListener('change', function() {
				applyTaTermsGate(buttonText);
			});

			try {
				var root = document.getElementById('visaNetJS') || document.documentElement;
				if (root && window.MutationObserver) {
					var obs = new MutationObserver(function() {
						applyTaTermsGate(buttonText);
					});
					obs.observe(root, { childList: true, subtree: true, attributes: true });
					setTimeout(function() { try { obs.disconnect(); } catch (e) { } }, (maxWaitMs || 15000));
				}
			} catch (e) { }
		}

		function unhideNiubizLogo() {
			try {
				var logo = document.getElementById('logo');
				if (!logo) return false;
				if (logo.style && logo.style.setProperty) {
					logo.style.setProperty('display', 'block', 'important');
				} else {
					logo.style.display = 'block';
				}
				if (logo.classList) {
					logo.classList.remove('header--noLogo');
					logo.classList.remove('header-noLogo');
					logo.classList.remove('noLogo');
				}
				var logoText = document.getElementById('logoText');
				if (logoText && logoText.style && logoText.style.setProperty) {
					logoText.style.setProperty('display', 'none', 'important');
				}
				return true;
			} catch (e) {
				return false;
			}
		}

		function observeNiubizLogo(maxWaitMs) {
			var start = new Date().getTime();
			if (unhideNiubizLogo()) return;
			try {
				var obs = new MutationObserver(function() {
					unhideNiubizLogo();
					if (document.getElementById('logo')) {
						obs.disconnect();
					}
				});
				obs.observe(document.documentElement || document.body, { childList: true, subtree: true, attributes: true });
				setTimeout(function() {
					try { obs.disconnect(); } catch (e) { }
				}, maxWaitMs);
			} catch (e) {
				// no-op
			}
			var timer = setInterval(function() {
				unhideNiubizLogo();
				var elapsed = new Date().getTime() - start;
				if (document.getElementById('logo') || elapsed > maxWaitMs) {
					clearInterval(timer);
				}
			}, 100);
		}

		function mountTaBrandIntoNiubiz() {
			try {
				var brand = document.getElementById('ta-visa-brand');
				if (!brand) return;
				var container = document.getElementById('visaNetJS');
				if (!container) return;
				try {
					var pos = window.getComputedStyle ? window.getComputedStyle(container).position : null;
					if (!pos || pos === 'static') {
						container.style.position = 'relative';
					}
				} catch (e) { }
				if (brand.parentNode !== container) {
					container.appendChild(brand);
				}
				// Keep overlay hidden; prefer Niubiz merchantlogo in-header.
				brand.style.display = 'none';
				return true;
			} catch (e) {
				return false;
			}
		}

		function waitAndMountTaBrand(maxWaitMs) {
			var start = new Date().getTime();
			var timer = setInterval(function() {
				var mounted = mountTaBrandIntoNiubiz();
				var elapsed = new Date().getTime() - start;
				if (mounted || elapsed > maxWaitMs) {
					clearInterval(timer);
				}
			}, 100);
		}

		function openNiubiz(data) {
			observeNiubizLogo(15000);
			var merchantLogoTa = data.merchantlogo;
			try {
				if (typeof merchantLogoTa === 'string') {
					var idx = merchantLogoTa.indexOf('/layer-view-image/');
					if (idx > 0) {
						var baseUri = merchantLogoTa.substring(0, idx);
						// If we're on localhost/loopback, Niubiz (served from https://static-content-*.vnforapps.com)
						// will be blocked by the browser from fetching private/loopback resources.
						// Only override merchantlogo when the URL is publicly reachable.
						if (!/^(https?:\/\/)?(localhost|127\.0\.0\.1|\[::1\])(?::\d+)?(\/|$)/i.test(baseUri)) {
							merchantLogoTa = baseUri + '/layer-view-image/v2/TE_APUESTO_Logotipo_RGB_visa.png';
						}
					}
				}
			} catch (e) {
				merchantLogoTa = data.merchantlogo;
			}
			VisanetCheckout.configure({
				sessiontoken : JSON.parse(data.json).sessionKey,
				channel : 'paycard',
				merchantid : data.merchantid,
				purchasenumber : data.purchasenumber,
				amount : '1',
				formbuttoncolor : '#FF8000',
				formbuttontext : data.formbuttontext,
				merchantlogo : merchantLogoTa,
				showamount : 'false',
				cardholdername : data.cardholdername.replace(/[0123456789]/g,''),
				cardholderlastname : data.cardholderlastname.replace(/[0123456789]/g,''),
				usertoken : data.userToken,
				cardholderemail : data.cardholderemail,
				expirationminutes : '20',
				timeouturl : data.timeouturl,
				action: 'tokenizeCard.html?prizetoken='+data.prizetoken,
				method: 'POST',
				cancel: function (){
					console.log("Cancel VisanetCheckout");
					try { window.parent.postMessage('hideLightboxTokenization','*'); } catch (e) {   }	
				},
				close: function (){
					console.log("Close VisanetCheckout");
				},
				qrcomplete: function (){
					console.log("QRcomplete VisanetCheckout");
				},
				addfingerprint: function (){
					console.log("Addfingerprint VisanetCheckout");
				},
				complete: function (params) {
					console.log("Complete VisanetCheckout");
					try {
						var mode = getTokenizationCompletionMode();
						window.parent.postMessage('tokenizationCompleted|' + mode,'*');
					} catch (e) { }
				}
			});
			VisanetCheckout.open();
			// If the user has saved cards, select the first one by default so
			// "Confirmar" doesn't fall back to the "Nueva tarjeta" form.
			ensureDefaultSavedCardSelected(15000);
			setupTaTermsGate(data.formbuttontext, 15000);
			observeNiubizLogo(15000);
		}
	
		
		function createSessionTokenization(){
			var vheaders={"prizetoken":$('#prizetoken').val()};
			console.log("createSessionTokenizationta vheaders="+vheaders);
			$.ajax({
		        type: "POST",
		        url: "createSessionTokenizationCardTa.html",
		        headers: vheaders,
		        dataType: "json",
			})
			.done(function(data) {
				if(data.status=="OK"){
					var sesion = JSON.parse(data.json).sessionKey;
					openNiubiz(data);
					setTimeout(function(){ try { window.parent.postMessage('hideLoadingTokenization','*'); } catch (e) {   } }, 1500);
					setTimeout(function(){ try { window.parent.postMessage('observerLightboxTokenization','*'); } catch (e) {   } }, 5000);
					setTimeout(function(){ try { window.parent.postMessage('hideLightboxTokenization','*'); } catch (e) {   } }, 900000);
				}else{
					window.parent.postMessage('errorLoadingTokenization|'+data.message,'*');	
				}
			})
			.fail(function(jqXHR, textStatus, errorThrown) {
				if(jqXHR.status==403){
					window.location.href = 'home.html';
		    	}else{
		    		window.parent.postMessage('errorLoadingTokenization|Por favor, int&eacute;ntalo de nuevo en unos minutos','*');	
		    	}			
			});		
		}
	</script>
	<script type='text/javascript'>
		$(document).ready(function(){
			const queryString = window.location.search;
			const urlParams = new URLSearchParams(queryString);
			var prizetoken = urlParams.get('prizetoken');
			if(prizetoken==undefined || prizetoken==null || prizetoken==""){				
				prizetoken=localStorage.getItem("prizetoken");
				console.log("createSessionTokenizationta ready localStorage prizetokenta="+prizetoken);
			}
			console.log("createSessionTokenizationta ready prizetokenta="+prizetoken);
			$('#prizetoken').val(prizetoken);
			createSessionTokenization();
		});
	</script>
</head>
<body>
	<div id="ta-visa-brand">
		<img src="layer-view-image/v2/TE_APUESTO_Logotipo_RGB_visa.png" alt="Te Apuesto">
	</div>
	<div id="ta-terms-container">
		<div id="ta-terms-inner">
			<input type="checkbox" id="ta-terms-check" />
			<label id="ta-terms-label" for="ta-terms-check">
				He le&iacute;do y acepto los <a href="<%= Constantes.URL_QW%>/terminos-y-condiciones/" target="_blank" rel="noopener noreferrer">T&eacute;rminos y Condiciones</a>
			</label>
		</div>
	</div>
<input type="hidden" id="prizetoken" value="${prizetoken}" />
</body>
</html>